package com.android.launcher2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AvailableShortcutWidgetListProvider
  implements AvailableWidgetListProvider
{
  private static final String TAG = AvailableShortcutWidgetListProvider.class.getSimpleName();
  private final String SETTINGS_SHORTCUT_WIDGET_PACKAGE = "com.android.settings";
  private Context mContext;
  private PkgResCache mPkgResCache;
  
  public AvailableShortcutWidgetListProvider(Context paramContext)
  {
    this.mContext = paramContext;
    this.mPkgResCache = LauncherApplication.getInst().getPkgResCache();
  }
  
  public AvailableWidget getAvailableWidget(ComponentName paramComponentName)
  {
    Iterator localIterator = getAvailableWidgets().iterator();
    while (localIterator.hasNext())
    {
      AvailableWidget localAvailableWidget = (AvailableWidget)localIterator.next();
      if (((localAvailableWidget instanceof AvailableShortcutWidget)) && (((AvailableShortcutWidget)localAvailableWidget).getComponentName().equals(paramComponentName))) {
        return localAvailableWidget;
      }
    }
    return null;
  }
  
  public List<AvailableWidget> getAvailableWidgets()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new Intent("android.intent.action.CREATE_SHORTCUT");
    Iterator localIterator = this.mContext.getPackageManager().queryIntentActivities((Intent)localObject, 0).iterator();
    while (localIterator.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      label79:
      String str;
      if (LauncherApplication.getInst().isKnoxMode())
      {
        if (localResolveInfo.activityInfo == null)
        {
          localObject = localResolveInfo.serviceInfo;
          if (((ComponentInfo)localObject).packageName.equals("com.android.settings")) {
            break label176;
          }
        }
      }
      else
      {
        localArrayList.add(new AvailableShortcutWidget(this.mContext.getPackageManager(), localResolveInfo));
        if (!DEBUGGABLE) {
          continue;
        }
        str = TAG;
        if ("Shortcut " + localResolveInfo.activityInfo == null) {
          break label178;
        }
      }
      label176:
      label178:
      for (localObject = localResolveInfo.activityInfo.toString();; localObject = localResolveInfo.serviceInfo.toString() + " added")
      {
        Log.d(str, (String)localObject);
        break;
        localObject = localResolveInfo.activityInfo;
        break label79;
        break;
      }
    }
    if ((DEBUGGABLE) && (localArrayList.isEmpty())) {
      Log.e(TAG, "No shortcuts were loaded");
    }
    return localArrayList;
  }
  
  public boolean isShortcutWidget(String paramString)
  {
    Iterator localIterator = getAvailableWidgets().iterator();
    while (localIterator.hasNext())
    {
      AvailableWidget localAvailableWidget = (AvailableWidget)localIterator.next();
      if (((localAvailableWidget instanceof AvailableShortcutWidget)) && (((AvailableShortcutWidget)localAvailableWidget).getComponentName().getClassName().equals(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private class AvailableShortcutWidget
    implements AvailableWidget
  {
    private final boolean mCanUninstall;
    private final ComponentName mComponentName;
    private boolean mIsSecret;
    private final PkgResCache.TitleIconInfo mTitleAndIcon = new PkgResCache.TitleIconInfo();
    
    public AvailableShortcutWidget(PackageManager paramPackageManager, ResolveInfo paramResolveInfo)
    {
      if (paramResolveInfo.activityInfo == null) {}
      for (paramPackageManager = paramResolveInfo.serviceInfo;; paramPackageManager = paramResolveInfo.activityInfo)
      {
        this.mComponentName = new ComponentName(paramPackageManager.packageName, paramPackageManager.name);
        this.mCanUninstall = AvailableWidgetListProvider.Util.canUninstall(paramPackageManager.applicationInfo);
        this.mIsSecret = false;
        this.mTitleAndIcon.mIsWidget = true;
        AvailableShortcutWidgetListProvider.this.mPkgResCache.getTitleAndIcon(this.mTitleAndIcon, paramResolveInfo);
        if (this.mTitleAndIcon.mIcon == null) {
          this.mTitleAndIcon.mIcon = AvailableShortcutWidgetListProvider.this.mPkgResCache.getDefaultIcon();
        }
        if (this.mTitleAndIcon.mTitle == null) {
          this.mTitleAndIcon.mTitle = this.mComponentName.getClassName();
        }
        return;
      }
    }
    
    public boolean canUninstall()
    {
      return this.mCanUninstall;
    }
    
    public void cleanupCache() {}
    
    public HomePendingItem createHomePendingItem()
    {
      HomePendingItem localHomePendingItem = new HomePendingItem(BaseItem.Type.HOME_SHORTCUT);
      localHomePendingItem.componentName = this.mComponentName;
      localHomePendingItem.mIconResId = this.mTitleAndIcon.mIconResId;
      localHomePendingItem.mIconBitmap = this.mTitleAndIcon.mIcon;
      localHomePendingItem.mTitleResId = this.mTitleAndIcon.mTitleResId;
      localHomePendingItem.mTitle = this.mTitleAndIcon.mTitle;
      if (!this.mCanUninstall) {}
      for (boolean bool = true;; bool = false)
      {
        localHomePendingItem.mSystemApp = bool;
        localHomePendingItem.mSecretItem = this.mIsSecret;
        return localHomePendingItem;
      }
    }
    
    public void dump(String paramString)
    {
      if (AvailableWidgetListProvider.DEBUGGABLE) {
        Log.d(paramString, "   cn=\"" + this.mComponentName.flattenToShortString() + "\" title=" + this.mTitleAndIcon.mTitle);
      }
    }
    
    public void getCellSpan(int[] paramArrayOfInt)
    {
      paramArrayOfInt[0] = 1;
      paramArrayOfInt[1] = 1;
    }
    
    public ComponentName getComponentName()
    {
      return this.mComponentName;
    }
    
    public String getLabel()
    {
      return this.mTitleAndIcon.mTitle;
    }
    
    public Bitmap getPreview(int paramInt1, int paramInt2)
    {
      return this.mTitleAndIcon.mIcon;
    }
    
    public String getWidgetPackageName()
    {
      return this.mComponentName.getPackageName();
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


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AvailableShortcutWidgetListProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */