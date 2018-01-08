package com.android.launcher2;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AvailableAppWidgetListProvider
  implements AvailableWidgetListProvider
{
  private static final String LOG_TAG = "AvailableAppWidgetListProvider";
  private final Context mContext;
  private final Map<ComponentName, Bitmap> mPreviewCache = Collections.synchronizedMap(new HashMap());
  
  public AvailableAppWidgetListProvider(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public AvailableWidget getAvailableWidget(ComponentName paramComponentName)
  {
    PackageManager localPackageManager = this.mContext.getPackageManager();
    Object localObject1 = AppWidgetManager.getInstance(this.mContext).getInstalledProviders();
    Object localObject2 = AppWidgetManager.getInstance(this.mContext).getInstalledProviders(512);
    Iterator localIterator;
    if (localObject1 != null)
    {
      ((List)localObject1).addAll((Collection)localObject2);
      localObject2 = new int[2];
      localIterator = ((List)localObject1).iterator();
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject1 = (AppWidgetProviderInfo)localIterator.next();
        if ((((AppWidgetProviderInfo)localObject1).minWidth <= 0) || (((AppWidgetProviderInfo)localObject1).minHeight <= 0))
        {
          if (!DEBUGGABLE) {
            continue;
          }
          Log.d("AvailableAppWidgetListProvider", "AppWidget specifies an invalid size: " + ((AppWidgetProviderInfo)localObject1).provider.flattenToShortString());
          continue;
          localObject1 = localObject2;
          break;
        }
        Object localObject3 = ((AppWidgetProviderInfo)localObject1).provider.getPackageName();
        if (0 != 0) {
          throw new NullPointerException();
        }
        localObject3 = new AvailableAppWidget((AppWidgetProviderInfo)localObject1, AvailableWidgetListProvider.Util.canUninstall(localPackageManager, (String)localObject3), false);
        if (Launcher.isHelpAppRunning)
        {
          ((AvailableAppWidget)localObject3).getCellSpan((int[])localObject2);
          if ((localObject2[0] == 1) && (localObject2[1] == 1)) {}
        }
        else if (((AppWidgetProviderInfo)localObject1).provider.equals(paramComponentName))
        {
          return (AvailableWidget)localObject3;
        }
      }
    }
    return null;
  }
  
  public List<AvailableWidget> getAvailableWidgets()
  {
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = this.mContext.getPackageManager();
    HashSet localHashSet = new HashSet();
    Object localObject1 = localPackageManager.queryBroadcastReceivers(new Intent("android.appwidget.action.EASY_MODE"), 0);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResolveInfo)((Iterator)localObject1).next();
        localHashSet.add(new ComponentName(((ResolveInfo)localObject2).activityInfo.packageName, ((ResolveInfo)localObject2).activityInfo.name));
      }
    }
    Object localObject2 = new HashSet();
    if (LauncherApplication.getInst().isKnoxMode()) {
      ((Set)localObject2).add(new ComponentName("com.android.settings", "com.android.settings.dualsimwidget.DualsimWidget_data"));
    }
    localObject1 = new HashSet();
    Object localObject3 = localPackageManager.queryBroadcastReceivers(new Intent("android.appwidget.action.APPWIDGET_UPDATE"), 33280);
    if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
    {
      localIterator = ((List)localObject3).iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (ResolveInfo)localIterator.next();
        localObject4 = new ComponentName(((ResolveInfo)localObject3).activityInfo.packageName, ((ResolveInfo)localObject3).activityInfo.name);
        int i = localPackageManager.getComponentEnabledSetting((ComponentName)localObject4);
        if ((i != 1) && ((i != 0) || (!((ResolveInfo)localObject3).activityInfo.enabled))) {
          ((Set)localObject1).add(localObject4);
        }
      }
    }
    Object localObject4 = AppWidgetManager.getInstance(this.mContext).getInstalledProviders();
    localObject3 = new int[2];
    Iterator localIterator = ((List)localObject4).iterator();
    while (localIterator.hasNext())
    {
      localObject4 = (AppWidgetProviderInfo)localIterator.next();
      if ((localHashSet.contains(((AppWidgetProviderInfo)localObject4).provider)) || (((Set)localObject2).contains(((AppWidgetProviderInfo)localObject4).provider)) || (((Set)localObject1).contains(((AppWidgetProviderInfo)localObject4).provider)))
      {
        if (DEBUGGABLE) {
          Log.d("AvailableAppWidgetListProvider", "AppWidget ignored: " + ((AppWidgetProviderInfo)localObject4).provider.flattenToShortString());
        }
      }
      else if ((((AppWidgetProviderInfo)localObject4).minWidth <= 0) || (((AppWidgetProviderInfo)localObject4).minHeight <= 0))
      {
        if (DEBUGGABLE) {
          Log.d("AvailableAppWidgetListProvider", "AppWidget specifies an invalid size: " + ((AppWidgetProviderInfo)localObject4).provider.flattenToShortString());
        }
      }
      else
      {
        Object localObject5 = ((AppWidgetProviderInfo)localObject4).provider.getPackageName();
        if (0 != 0) {
          throw new NullPointerException();
        }
        localObject5 = new AvailableAppWidget((AppWidgetProviderInfo)localObject4, AvailableWidgetListProvider.Util.canUninstall(localPackageManager, (String)localObject5), false);
        if (Launcher.isHelpAppRunning)
        {
          ((AvailableAppWidget)localObject5).getCellSpan((int[])localObject3);
          if ((localObject3[0] == 1) && (localObject3[1] == 1)) {}
        }
        else
        {
          if (!((AppWidgetProviderInfo)localObject4).provider.getPackageName().equalsIgnoreCase("com.sec.android.app.launcher")) {
            localArrayList.add(localObject5);
          }
          if (DEBUGGABLE) {
            Log.d("AvailableAppWidgetListProvider", "Widget{" + ((AppWidgetProviderInfo)localObject4).label + "} " + ((AppWidgetProviderInfo)localObject4).provider.flattenToShortString() + " added");
          }
        }
      }
    }
    return localArrayList;
  }
  
  public boolean isShortcutWidget(String paramString)
  {
    return false;
  }
  
  public class AvailableAppWidget
    implements AvailableWidget
  {
    private Bitmap mCachedPreview;
    private final boolean mCanUninstall;
    private boolean mIsSecret;
    private final AppWidgetProviderInfo mProviderInfo;
    
    public AvailableAppWidget(AppWidgetProviderInfo paramAppWidgetProviderInfo, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.mProviderInfo = paramAppWidgetProviderInfo;
      this.mCanUninstall = paramBoolean1;
      this.mIsSecret = paramBoolean2;
    }
    
    public boolean canUninstall()
    {
      return this.mCanUninstall;
    }
    
    public void cleanupCache()
    {
      try
      {
        if (this.mCachedPreview != null)
        {
          if (AvailableWidgetListProvider.DEBUGGABLE) {
            Log.i("AvailableAppWidgetListProvider", "Setting to NULL, " + this.mCachedPreview + " on this: " + this);
          }
          this.mCachedPreview = null;
        }
        if (this.mProviderInfo.previewImage != 0) {
          AvailableAppWidgetListProvider.this.mPreviewCache.remove(this.mProviderInfo.provider);
        }
        return;
      }
      finally {}
    }
    
    public HomePendingItem createHomePendingItem()
    {
      boolean bool = true;
      HomePendingWidget localHomePendingWidget = new HomePendingWidget(this.mProviderInfo, null, null);
      int[] arrayOfInt = new int[2];
      getCellSpan(arrayOfInt);
      localHomePendingWidget.spanX = arrayOfInt[0];
      localHomePendingWidget.spanY = arrayOfInt[1];
      if (!canUninstall()) {}
      for (;;)
      {
        localHomePendingWidget.mSystemApp = bool;
        localHomePendingWidget.mSecretItem = this.mIsSecret;
        return localHomePendingWidget;
        bool = false;
      }
    }
    
    public void dump(String paramString)
    {
      AppWidgetProviderInfo localAppWidgetProviderInfo = this.mProviderInfo;
      if (AvailableWidgetListProvider.DEBUGGABLE) {
        Log.d(paramString, "   label=\"" + localAppWidgetProviderInfo.label + "\" previewImage=" + localAppWidgetProviderInfo.previewImage + " resizeMode=" + localAppWidgetProviderInfo.resizeMode + " configure=" + localAppWidgetProviderInfo.configure + " initialLayout=" + localAppWidgetProviderInfo.initialLayout + " minWidth=" + localAppWidgetProviderInfo.minWidth + " minHeight=" + localAppWidgetProviderInfo.minHeight);
      }
    }
    
    public void getCellSpan(int[] paramArrayOfInt)
    {
      WorkspaceSpanCalculator.INSTANCE.getSpanForWidget(this.mProviderInfo, paramArrayOfInt);
    }
    
    public String getLabel()
    {
      return this.mProviderInfo.label;
    }
    
    public Bitmap getPreview(int paramInt1, int paramInt2)
    {
      for (;;)
      {
        try
        {
          AppWidgetProviderInfo localAppWidgetProviderInfo = this.mProviderInfo;
          if (localAppWidgetProviderInfo.previewImage != 0) {
            this.mCachedPreview = ((Bitmap)AvailableAppWidgetListProvider.this.mPreviewCache.get(localAppWidgetProviderInfo.provider));
          }
          if (this.mCachedPreview != null)
          {
            localObject = this.mCachedPreview;
            return (Bitmap)localObject;
          }
          Object localObject = new int[2];
          Object tmp61_60 = localObject;
          tmp61_60[0] = 1;
          Object tmp65_61 = tmp61_60;
          tmp65_61[1] = 1;
          tmp65_61;
          getCellSpan((int[])localObject);
          if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE)
          {
            localObject = Utilities.loadWidgetThemePreview(AvailableAppWidgetListProvider.this.mContext, localAppWidgetProviderInfo.provider.getPackageName(), localAppWidgetProviderInfo.previewImage, localAppWidgetProviderInfo.icon, paramInt1, paramInt2, (int[])localObject);
            if (localAppWidgetProviderInfo.previewImage != 0) {
              AvailableAppWidgetListProvider.this.mPreviewCache.put(localAppWidgetProviderInfo.provider, localObject);
            }
            this.mCachedPreview = ((Bitmap)localObject);
          }
          else
          {
            Bitmap localBitmap = Utilities.loadWidgetPreview(AvailableAppWidgetListProvider.this.mContext, localAppWidgetProviderInfo.provider.getPackageName(), localAppWidgetProviderInfo.previewImage, localAppWidgetProviderInfo.icon, paramInt1, paramInt2, arrayOfInt);
          }
        }
        finally {}
      }
    }
    
    public String getWidgetPackageName()
    {
      return this.mProviderInfo.provider.getPackageName();
    }
    
    public boolean isSecret()
    {
      return this.mIsSecret;
    }
    
    public void setSecret(boolean paramBoolean)
    {
      this.mIsSecret = paramBoolean;
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AvailableAppWidgetListProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */