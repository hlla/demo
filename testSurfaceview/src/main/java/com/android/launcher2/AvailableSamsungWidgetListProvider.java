package com.android.launcher2;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AvailableSamsungWidgetListProvider
  implements AvailableWidgetListProvider
{
  private static final String LOG_TAG = "AvailableSamsungWidgetListProvider";
  private final Context mContext;
  private final SamsungWidgetPackageManager mPackageManager;
  
  public AvailableSamsungWidgetListProvider(Context paramContext)
  {
    this.mContext = paramContext;
    this.mPackageManager = SamsungWidgetPackageManager.INSTANCE;
  }
  
  public AvailableWidget getAvailableWidget(ComponentName paramComponentName)
  {
    Iterator localIterator = this.mPackageManager.getWidgetItems().iterator();
    while (localIterator.hasNext())
    {
      SamsungWidgetProviderInfo localSamsungWidgetProviderInfo = (SamsungWidgetProviderInfo)localIterator.next();
      if (0 != 0)
      {
        localSamsungWidgetProviderInfo.getComponentName().getPackageName();
        throw new NullPointerException();
      }
      if (localSamsungWidgetProviderInfo.getComponentName().equals(paramComponentName)) {
        return new AvailableSamsungWidget(localSamsungWidgetProviderInfo, false);
      }
    }
    return null;
  }
  
  public List<AvailableWidget> getAvailableWidgets()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPackageManager.getWidgetItems().iterator();
    while (localIterator.hasNext())
    {
      SamsungWidgetProviderInfo localSamsungWidgetProviderInfo = (SamsungWidgetProviderInfo)localIterator.next();
      if (0 != 0)
      {
        localSamsungWidgetProviderInfo.getComponentName().getPackageName();
        throw new NullPointerException();
      }
      localArrayList.add(new AvailableSamsungWidget(localSamsungWidgetProviderInfo, false));
      if (DEBUGGABLE) {
        Log.d("AvailableSamsungWidgetListProvider", "Samsung Widget{" + localSamsungWidgetProviderInfo.mWidgetTitle + "}  ComponentInfo{" + localSamsungWidgetProviderInfo.mPackageName + "/" + localSamsungWidgetProviderInfo.mClassName + "} added");
      }
    }
    if ((DEBUGGABLE) && (localArrayList.isEmpty())) {
      Log.e("AvailableSamsungWidgetListProvider", "No Samsung App Widgets were loaded");
    }
    return localArrayList;
  }
  
  public boolean isShortcutWidget(String paramString)
  {
    return false;
  }
  
  private class AvailableSamsungWidget
    implements AvailableWidget
  {
    private SamsungWidgetProviderInfo mInfo;
    private boolean mIsSecret;
    
    public AvailableSamsungWidget(SamsungWidgetProviderInfo paramSamsungWidgetProviderInfo, boolean paramBoolean)
    {
      this.mInfo = paramSamsungWidgetProviderInfo;
      this.mIsSecret = paramBoolean;
    }
    
    public boolean canUninstall()
    {
      return false;
    }
    
    public void cleanupCache() {}
    
    public HomePendingItem createHomePendingItem()
    {
      return new HomePendingSamsungWidget(this.mInfo);
    }
    
    public void dump(String paramString)
    {
      Log.d(paramString, "SamsungWidget TODO");
    }
    
    public void getCellSpan(int[] paramArrayOfInt)
    {
      WorkspaceSpanCalculator.INSTANCE.getSpanForSamsungWidget(this.mInfo.getWidth(1), this.mInfo.getHeight(1), this.mInfo.getWidth(2), this.mInfo.getHeight(2), paramArrayOfInt);
    }
    
    public String getLabel()
    {
      if (this.mInfo.mDescription != null) {
        return this.mInfo.mDescription;
      }
      return this.mInfo.mWidgetTitle;
    }
    
    public Bitmap getPreview(int paramInt1, int paramInt2)
    {
      int[] arrayOfInt = new int[2];
      int[] tmp5_4 = arrayOfInt;
      tmp5_4[0] = 1;
      int[] tmp9_5 = tmp5_4;
      tmp9_5[1] = 1;
      tmp9_5;
      getCellSpan(arrayOfInt);
      if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) {
        return Utilities.loadSamsungWidgetThemePreview(AvailableSamsungWidgetListProvider.this.mContext, this.mInfo.mPackageName, this.mInfo.mThemeName, this.mInfo.mWidgetPreview, 0, paramInt1, paramInt2, arrayOfInt);
      }
      return Utilities.loadWidgetPreview(AvailableSamsungWidgetListProvider.this.mContext, this.mInfo.mPackageName, this.mInfo.mWidgetPreview, 0, paramInt1, paramInt2, arrayOfInt);
    }
    
    public String getWidgetPackageName()
    {
      return this.mInfo.mPackageName;
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


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AvailableSamsungWidgetListProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */