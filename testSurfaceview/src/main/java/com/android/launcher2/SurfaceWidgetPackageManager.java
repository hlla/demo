package com.android.launcher2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.samsung.surfacewidget.SurfaceWidgetProviderInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public enum SurfaceWidgetPackageManager
{
  INST(LauncherApplication.getInst());
  
  private static final boolean DEBUG = true;
  private static final boolean DEBUGGABLE = Utilities.DEBUGGABLE();
  private static final int DEFAULT_WIDGET_NUMBER = 10;
  private static final String INTENT_ACTION = "com.samsung.sec.android.SURFACE_WIDGET_ACTION";
  private static final String INTENT_CATEGORY = "com.samsung.sec.android.SURFACE_WIDGET";
  private static final String LOG_TAG = "Launcher.SurfaceWidgetPkgMgr";
  private static final String METADATA_NAME = "com.samsung.sec.android.SURFACE_WIDGET";
  private final Map<ComponentName, SurfaceWidgetInfoInstances> mActiveSurfaceWidgetMap = new HashMap();
  private final Context mAppContext;
  private int mConfigMccWhenLoaded;
  private int mConfigMncWhenLoaded;
  private final Map<ComponentName, SurfaceWidgetProviderInfo[]> mInfoCache = new HashMap(10);
  private String mLocaleWhenLoaded;
  private List<SurfaceWidgetProviderInfo> mSurfaceWidgets = null;
  
  private SurfaceWidgetPackageManager(Context paramContext)
  {
    this.mAppContext = paramContext.getApplicationContext();
  }
  
  private SurfaceWidgetProviderInfo[] makeWidgetItem(Context paramContext, ResolveInfo paramResolveInfo)
  {
    ComponentName localComponentName = new ComponentName(paramResolveInfo.serviceInfo.packageName, paramResolveInfo.serviceInfo.name);
    SurfaceWidgetProviderInfo[] arrayOfSurfaceWidgetProviderInfo = (SurfaceWidgetProviderInfo[])this.mInfoCache.get(localComponentName);
    if (arrayOfSurfaceWidgetProviderInfo == null)
    {
      localObject = paramResolveInfo.serviceInfo.metaData;
      if (localObject == null) {
        Log.e("Launcher.SurfaceWidgetPkgMgr", "SurfaceWidget didn't provide meta data XML file!");
      }
    }
    else
    {
      return arrayOfSurfaceWidgetProviderInfo;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((Bundle)localObject).keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (str.startsWith("com.samsung.sec.android.SURFACE_WIDGET")) {
        localArrayList.add(str);
      }
    }
    int m = localArrayList.size();
    int j;
    int i;
    if (m > 0)
    {
      arrayOfSurfaceWidgetProviderInfo = new SurfaceWidgetProviderInfo[m];
      j = 0;
      i = 0;
      if (j < m)
      {
        localObject = SurfaceWidgetProviderInfo.create(paramContext, paramResolveInfo, localComponentName, (String)localArrayList.get(j));
        if (localObject == null) {
          break label262;
        }
        int k = i + 1;
        arrayOfSurfaceWidgetProviderInfo[i] = localObject;
        i = k;
      }
    }
    label262:
    for (;;)
    {
      j += 1;
      break;
      if (i <= 0) {
        return null;
      }
      paramContext = arrayOfSurfaceWidgetProviderInfo;
      if (i < m) {
        paramContext = (SurfaceWidgetProviderInfo[])Arrays.copyOf(arrayOfSurfaceWidgetProviderInfo, i);
      }
      this.mInfoCache.put(localComponentName, paramContext);
      return paramContext;
      Log.e("Launcher.SurfaceWidgetPkgMgr", "SurfaceWidget didn't provide meta data XML file!");
      return arrayOfSurfaceWidgetProviderInfo;
    }
  }
  
  public void clearWidgetInstanceNumbers(SurfaceWidgetProviderInfo paramSurfaceWidgetProviderInfo)
  {
    SurfaceWidgetInfoInstances localSurfaceWidgetInfoInstances = (SurfaceWidgetInfoInstances)this.mActiveSurfaceWidgetMap.get(paramSurfaceWidgetProviderInfo.getComponentName());
    if (localSurfaceWidgetInfoInstances != null)
    {
      localSurfaceWidgetInfoInstances.clear();
      this.mActiveSurfaceWidgetMap.remove(paramSurfaceWidgetProviderInfo.getComponentName());
    }
  }
  
  public void clearWidgets()
  {
    try
    {
      this.mSurfaceWidgets = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  int createWidgetInstance(SurfaceWidgetProviderInfo paramSurfaceWidgetProviderInfo)
  {
    if (paramSurfaceWidgetProviderInfo == null)
    {
      Log.e("Launcher.SurfaceWidgetPkgMgr", "SurfaceWidgetInfo null in createWidgetInstance");
      return -1;
    }
    SurfaceWidgetInfoInstances localSurfaceWidgetInfoInstances2 = (SurfaceWidgetInfoInstances)this.mActiveSurfaceWidgetMap.get(paramSurfaceWidgetProviderInfo.getComponentName());
    SurfaceWidgetInfoInstances localSurfaceWidgetInfoInstances1 = localSurfaceWidgetInfoInstances2;
    if (localSurfaceWidgetInfoInstances2 == null)
    {
      localSurfaceWidgetInfoInstances1 = new SurfaceWidgetInfoInstances(paramSurfaceWidgetProviderInfo.label);
      this.mActiveSurfaceWidgetMap.put(paramSurfaceWidgetProviderInfo.getComponentName(), localSurfaceWidgetInfoInstances1);
    }
    if ((paramSurfaceWidgetProviderInfo.isOneInstanceOnly()) && (localSurfaceWidgetInfoInstances1.getCount() >= 1))
    {
      if (this.mAppContext.getResources().getBoolean(2131427339)) {
        this.mAppContext.setTheme(16974130);
      }
      Toast.makeText(this.mAppContext, 2131755016, 1).show();
      return -1;
    }
    int i = localSurfaceWidgetInfoInstances1.createNextInstance();
    Log.d("Launcher.SurfaceWidgetPkgMgr", "createWidgetInstance: " + i + ", updated list: " + localSurfaceWidgetInfoInstances1);
    return i;
  }
  
  public SurfaceWidgetProviderInfo findWidget(ComponentName paramComponentName, String paramString)
  {
    if (paramComponentName != null)
    {
      Iterator localIterator = getWidgetItems(false).iterator();
      while (localIterator.hasNext())
      {
        SurfaceWidgetProviderInfo localSurfaceWidgetProviderInfo = (SurfaceWidgetProviderInfo)localIterator.next();
        if ((paramComponentName.equals(localSurfaceWidgetProviderInfo.getComponentName())) && ((paramString == null) || (paramString.equals(localSurfaceWidgetProviderInfo.getThemeName())))) {
          return localSurfaceWidgetProviderInfo;
        }
      }
    }
    return null;
  }
  
  public List<SurfaceWidgetProviderInfo> getWidgetItems(boolean paramBoolean)
  {
    for (;;)
    {
      ArrayList localArrayList;
      Object localObject3;
      try
      {
        if ((this.mSurfaceWidgets == null) || (paramBoolean))
        {
          this.mInfoCache.clear();
          PackageManager localPackageManager = this.mAppContext.getPackageManager();
          Object localObject2 = localPackageManager.queryIntentServices(new Intent("com.samsung.sec.android.SURFACE_WIDGET_ACTION").addCategory("com.samsung.sec.android.SURFACE_WIDGET"), 128);
          if (DEBUGGABLE) {
            Log.d("Launcher.SurfaceWidgetPkgMgr", "Query the installed surface widgets from surface widget package manager: list obtained with size= " + ((List)localObject2).size());
          }
          localArrayList = new ArrayList(10);
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ResolveInfo)((Iterator)localObject2).next();
            if (DEBUGGABLE) {
              Log.d("Launcher.SurfaceWidgetPkgMgr", "" + ((ResolveInfo)localObject3).loadLabel(localPackageManager));
            }
            localObject3 = makeWidgetItem(this.mAppContext, (ResolveInfo)localObject3);
            if (localObject3 == null)
            {
              if (!DEBUGGABLE) {
                continue;
              }
              Log.e("Launcher.SurfaceWidgetPkgMgr", "failed to load SurfaceWidgetInfos!");
              continue;
            }
            i = 0;
          }
        }
      }
      finally {}
      int i;
      while (i < localObject3.length)
      {
        if (localObject3[i] != null)
        {
          localArrayList.add(localObject3[i]);
          break label259;
          this.mSurfaceWidgets = Collections.unmodifiableList(localArrayList);
          List localList = this.mSurfaceWidgets;
          return localList;
        }
        label259:
        i += 1;
      }
    }
  }
  
  boolean hasWidgetInstance(SurfaceWidgetProviderInfo paramSurfaceWidgetProviderInfo, int paramInt)
  {
    paramSurfaceWidgetProviderInfo = (SurfaceWidgetInfoInstances)this.mActiveSurfaceWidgetMap.get(paramSurfaceWidgetProviderInfo.getComponentName());
    if (paramSurfaceWidgetProviderInfo != null) {
      return paramSurfaceWidgetProviderInfo.instanceExists(paramInt);
    }
    return false;
  }
  
  void loadIfNeeded(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getConfiguration();
      if ((this.mConfigMccWhenLoaded != paramContext.mcc) || (this.mConfigMncWhenLoaded != paramContext.mnc) || (!paramContext.locale.toString().equals(this.mLocaleWhenLoaded)))
      {
        this.mConfigMccWhenLoaded = paramContext.mcc;
        this.mConfigMncWhenLoaded = paramContext.mnc;
        this.mLocaleWhenLoaded = paramContext.locale.toString();
        this.mSurfaceWidgets = null;
      }
      return;
    }
    finally {}
  }
  
  public void removeWidgetInstance(SurfaceWidgetProviderInfo paramSurfaceWidgetProviderInfo, int paramInt)
  {
    if (paramSurfaceWidgetProviderInfo == null)
    {
      Log.e("Launcher.SurfaceWidgetPkgMgr", "SurfaceWidgetInfo null in removeWidgetInstance");
      return;
    }
    SurfaceWidgetInfoInstances localSurfaceWidgetInfoInstances = (SurfaceWidgetInfoInstances)this.mActiveSurfaceWidgetMap.get(paramSurfaceWidgetProviderInfo.getComponentName());
    if (!hasWidgetInstance(paramSurfaceWidgetProviderInfo, paramInt))
    {
      Log.w("Launcher.SurfaceWidgetPkgMgr", "removeWidgetInstance -- Instance does not exist instanceNumber: " + paramInt + "/");
      if (localSurfaceWidgetInfoInstances != null) {
        Log.w("Launcher.SurfaceWidgetPkgMgr", "removeWidgetInstance -- Instance does not exist: " + localSurfaceWidgetInfoInstances);
      }
    }
    if (localSurfaceWidgetInfoInstances != null)
    {
      localSurfaceWidgetInfoInstances.removeInstance(paramInt);
      if (localSurfaceWidgetInfoInstances.getCount() == 0) {
        this.mActiveSurfaceWidgetMap.remove(paramSurfaceWidgetProviderInfo.getComponentName());
      }
    }
    Log.d("Launcher.SurfaceWidgetPkgMgr", "removeWidgetInstance: " + paramInt + ", updated list: " + localSurfaceWidgetInfoInstances);
  }
  
  void updateWidgetInstance(SurfaceWidgetProviderInfo paramSurfaceWidgetProviderInfo, int paramInt)
  {
    SurfaceWidgetInfoInstances localSurfaceWidgetInfoInstances2 = (SurfaceWidgetInfoInstances)this.mActiveSurfaceWidgetMap.get(paramSurfaceWidgetProviderInfo.getComponentName());
    SurfaceWidgetInfoInstances localSurfaceWidgetInfoInstances1 = localSurfaceWidgetInfoInstances2;
    if (localSurfaceWidgetInfoInstances2 == null)
    {
      localSurfaceWidgetInfoInstances1 = new SurfaceWidgetInfoInstances(paramSurfaceWidgetProviderInfo.label);
      this.mActiveSurfaceWidgetMap.put(paramSurfaceWidgetProviderInfo.getComponentName(), localSurfaceWidgetInfoInstances1);
    }
    if (localSurfaceWidgetInfoInstances1.instanceExists(paramInt)) {
      Log.d("Launcher.SurfaceWidgetPkgMgr", "createWidgetInstance(update) instance number already exist: " + localSurfaceWidgetInfoInstances1);
    }
    localSurfaceWidgetInfoInstances1.addInstance(paramInt);
    Log.d("Launcher.SurfaceWidgetPkgMgr", "updateWidgetInstance: " + paramInt + ", updated list: " + localSurfaceWidgetInfoInstances1);
  }
  
  private static final class SurfaceWidgetInfoInstances
  {
    private List<Integer> mInstances = new LinkedList();
    private String mName;
    private int mNextInstance = 1;
    
    SurfaceWidgetInfoInstances(String paramString)
    {
      this.mName = paramString;
    }
    
    boolean addInstance(int paramInt)
    {
      if (instanceExists(paramInt)) {
        return false;
      }
      this.mInstances.add(Integer.valueOf(paramInt));
      if (paramInt >= this.mNextInstance) {
        this.mNextInstance = (paramInt + 1);
      }
      return true;
    }
    
    void clear()
    {
      this.mInstances.clear();
    }
    
    int createNextInstance()
    {
      int i = this.mNextInstance;
      this.mInstances.add(Integer.valueOf(i));
      this.mNextInstance += 1;
      return i;
    }
    
    int getCount()
    {
      return this.mInstances.size();
    }
    
    boolean instanceExists(int paramInt)
    {
      return this.mInstances.indexOf(Integer.valueOf(paramInt)) != -1;
    }
    
    boolean removeInstance(int paramInt)
    {
      return this.mInstances.remove(Integer.valueOf(paramInt));
    }
    
    public String toString()
    {
      int j = this.mInstances.size();
      String str = "'" + this.mName + "': [";
      int i = 0;
      if (i < j)
      {
        int k = ((Integer)this.mInstances.get(i)).intValue();
        if (i > 0) {}
        for (str = str + ", " + k;; str = str + k)
        {
          i += 1;
          break;
        }
      }
      return str + "]";
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/SurfaceWidgetPackageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */