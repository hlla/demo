package com.android.launcher2;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.util.Log;
import com.samsung.surfacewidget.SurfaceWidgetProviderInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AvailableSurfaceWidgetListProvider
  implements AvailableWidgetListProvider
{
  private static final String LOG_TAG = "AvailableSurfaceWidgetListProvider";
  private final Context mContext;
  
  public AvailableSurfaceWidgetListProvider(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public AvailableWidget getAvailableWidget(ComponentName paramComponentName)
  {
    try
    {
      if (DEBUGGABLE) {
        Log.d("AvailableSurfaceWidgetListProvider", "SurfaceWidget getAvailableWidgets on thread" + Thread.currentThread());
      }
      PackageManager localPackageManager = this.mContext.getPackageManager();
      Iterator localIterator = SurfaceWidgetPackageManager.INST.getWidgetItems(true).iterator();
      for (;;)
      {
        SurfaceWidgetProviderInfo localSurfaceWidgetProviderInfo;
        if (localIterator.hasNext())
        {
          localSurfaceWidgetProviderInfo = (SurfaceWidgetProviderInfo)localIterator.next();
          if (0 == 0) {
            break label139;
          }
          localSurfaceWidgetProviderInfo.getPackageName();
          throw new NullPointerException();
        }
        while (localSurfaceWidgetProviderInfo.getComponentName().equals(paramComponentName)) {
          for (paramComponentName = new AvailableSurfaceWidget(localSurfaceWidgetProviderInfo, AvailableWidgetListProvider.Util.canUninstall(localPackageManager, localSurfaceWidgetProviderInfo.getPackageName()), false);; paramComponentName = null) {
            return paramComponentName;
          }
        }
      }
    }
    finally {}
  }
  
  public List<AvailableWidget> getAvailableWidgets()
  {
    label197:
    label222:
    for (;;)
    {
      ArrayList localArrayList;
      PackageManager localPackageManager;
      SurfaceWidgetProviderInfo localSurfaceWidgetProviderInfo;
      try
      {
        localArrayList = new ArrayList();
        if (DEBUGGABLE) {
          Log.d("AvailableSurfaceWidgetListProvider", "SurfaceWidget getAvailableWidgets on thread" + Thread.currentThread());
        }
        localPackageManager = this.mContext.getPackageManager();
        Iterator localIterator = SurfaceWidgetPackageManager.INST.getWidgetItems(true).iterator();
        if (!localIterator.hasNext()) {
          break label197;
        }
        localSurfaceWidgetProviderInfo = (SurfaceWidgetProviderInfo)localIterator.next();
        if (0 == 0) {
          break label222;
        }
        localSurfaceWidgetProviderInfo.getPackageName();
        throw new NullPointerException();
      }
      finally {}
      localArrayList.add(new AvailableSurfaceWidget(localSurfaceWidgetProviderInfo, AvailableWidgetListProvider.Util.canUninstall(localPackageManager, localSurfaceWidgetProviderInfo.getPackageName()), false));
      if (DEBUGGABLE)
      {
        Log.d("AvailableSurfaceWidgetListProvider", "Surface Widget{" + localSurfaceWidgetProviderInfo.label + "}  ComponentInfo{" + localSurfaceWidgetProviderInfo.getPackageName() + "/" + localSurfaceWidgetProviderInfo.getClassName() + "} added");
        continue;
        if ((DEBUGGABLE) && (localArrayList.isEmpty())) {
          Log.e("AvailableSurfaceWidgetListProvider", "No Surface Widgets were loaded");
        }
        return localArrayList;
      }
    }
  }
  
  public boolean isShortcutWidget(String paramString)
  {
    return false;
  }
  
  private class AvailableSurfaceWidget
    implements AvailableWidget
  {
    private final boolean mCanUninstall;
    private final SurfaceWidgetProviderInfo mInfo;
    private boolean mIsSecret;
    
    public AvailableSurfaceWidget(SurfaceWidgetProviderInfo paramSurfaceWidgetProviderInfo, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.mInfo = paramSurfaceWidgetProviderInfo;
      this.mCanUninstall = paramBoolean1;
      this.mIsSecret = paramBoolean2;
    }
    
    public boolean canUninstall()
    {
      return this.mCanUninstall;
    }
    
    public void cleanupCache() {}
    
    public HomePendingItem createHomePendingItem()
    {
      HomePendingSurfaceWidget localHomePendingSurfaceWidget = new HomePendingSurfaceWidget(this.mInfo);
      if (!canUninstall()) {}
      for (boolean bool = true;; bool = false)
      {
        localHomePendingSurfaceWidget.mSystemApp = bool;
        localHomePendingSurfaceWidget.mSecretItem = this.mIsSecret;
        return localHomePendingSurfaceWidget;
      }
    }
    
    public void dump(String paramString)
    {
      Log.d(paramString, "SurfaceWidget TODO");
    }
    
    public void getCellSpan(int[] paramArrayOfInt)
    {
      WorkspaceSpanCalculator.INSTANCE.getSpanForWidget(this.mInfo, paramArrayOfInt);
    }
    
    public String getLabel()
    {
      return this.mInfo.label;
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
      return Utilities.loadWidgetPreview(AvailableSurfaceWidgetListProvider.this.mContext, this.mInfo.provider.getPackageName(), this.mInfo.previewImage, 0, paramInt1, paramInt2, arrayOfInt);
    }
    
    public String getWidgetPackageName()
    {
      return this.mInfo.getPackageName();
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


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AvailableSurfaceWidgetListProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */