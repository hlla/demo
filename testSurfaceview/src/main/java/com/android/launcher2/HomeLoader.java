package com.android.launcher2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HomeLoader
{
  private static final String TAG = "HomeLoader";
  private final BadgeCache mBadgeCache;
  private final boolean mIsSafeMode;
  private final LauncherApplication mLauncherApp;
  private final PackageManager mPkgMgr;
  private final PkgResCache mPkgResCache;
  
  public HomeLoader(LauncherApplication paramLauncherApplication, PkgResCache paramPkgResCache, BadgeCache paramBadgeCache)
  {
    this.mLauncherApp = paramLauncherApplication;
    this.mPkgResCache = paramPkgResCache;
    this.mBadgeCache = paramBadgeCache;
    this.mPkgMgr = paramLauncherApplication.getPackageManager();
    this.mIsSafeMode = this.mPkgMgr.isSafeMode();
  }
  
  private boolean isComponentActive(ComponentName paramComponentName, ComponentInfo[] paramArrayOfComponentInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String str;
    int j;
    int i;
    if (paramArrayOfComponentInfo != null)
    {
      str = paramComponentName.getClassName();
      j = paramArrayOfComponentInfo.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        ComponentInfo localComponentInfo = paramArrayOfComponentInfo[i];
        if (!str.equals(localComponentInfo.name)) {
          break label103;
        }
        bool1 = bool2;
        if (localComponentInfo.exported)
        {
          i = this.mPkgMgr.getComponentEnabledSetting(paramComponentName);
          if (i != 1)
          {
            bool1 = bool2;
            if (i == 0)
            {
              bool1 = bool2;
              if (!localComponentInfo.enabled) {}
            }
          }
          else
          {
            bool1 = true;
          }
        }
      }
      return bool1;
      label103:
      i += 1;
    }
  }
  
  private boolean refreshShortcut(HomeItem paramHomeItem)
  {
    HomeShortcutItem localHomeShortcutItem = (HomeShortcutItem)paramHomeItem;
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    Intent localIntent = localHomeShortcutItem.intent;
    boolean bool1 = bool2;
    if (localIntent != null)
    {
      if (localHomeShortcutItem.mType != BaseItem.Type.HOME_APPLICATION) {
        break label132;
      }
      paramHomeItem = new PkgResCache.TitleIconInfo();
      this.mPkgResCache.getTitleAndIcon(paramHomeItem, localIntent);
      bool2 = bool3;
      if (paramHomeItem.mIcon != null)
      {
        bool2 = bool3;
        if (paramHomeItem.mIcon != localHomeShortcutItem.mIconBitmap)
        {
          localHomeShortcutItem.setIcon(paramHomeItem.mIcon);
          bool2 = true;
        }
      }
      bool1 = bool2;
      if (paramHomeItem.mTitle != null)
      {
        bool1 = bool2;
        if (!paramHomeItem.mTitle.equals(localHomeShortcutItem.mTitle))
        {
          localHomeShortcutItem.mTitle = paramHomeItem.mTitle;
          bool1 = true;
        }
      }
    }
    label132:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (localHomeShortcutItem.mType != BaseItem.Type.HOME_SHORTCUT);
        paramHomeItem = this.mLauncherApp.getLauncherProvider().getShortcutInfo(paramHomeItem);
        bool2 = bool4;
        if (paramHomeItem.mIconBitmap != null)
        {
          bool2 = bool4;
          if (paramHomeItem.mIconBitmap != localHomeShortcutItem.mIconBitmap)
          {
            localHomeShortcutItem.setIcon(paramHomeItem.mIconBitmap);
            bool2 = true;
          }
        }
        bool1 = bool2;
      } while (paramHomeItem.mTitle == null);
      bool1 = bool2;
    } while (paramHomeItem.mTitle.equals(localHomeShortcutItem.mTitle));
    localHomeShortcutItem.mTitle = paramHomeItem.mTitle;
    return true;
  }
  
  public void removePackage(Map<Long, HomeItem> paramMap, String paramString, List<HomeItem> paramList)
  {
    Iterator localIterator = paramMap.values().iterator();
    label115:
    while (localIterator.hasNext())
    {
      HomeItem localHomeItem = (HomeItem)localIterator.next();
      paramMap = null;
      switch (localHomeItem.mType)
      {
      }
      for (;;)
      {
        if ((paramMap == null) || (!paramMap.equals(paramString))) {
          break label115;
        }
        paramList.add(localHomeItem);
        break;
        paramMap = localHomeItem.getPackageName();
      }
    }
  }
  
  List<HomeItem> updateBadgeCounts(Map<Long, HomeItem> paramMap, Map<ComponentName, Integer> paramMap1)
  {
    ArrayList localArrayList = new ArrayList(paramMap1.size());
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Object localObject1 = (HomeItem)paramMap.next();
      if ((((HomeItem)localObject1).mType == BaseItem.Type.HOME_APPLICATION) || (((HomeItem)localObject1).mType == BaseItem.Type.HOME_SHORTCUT))
      {
        localObject1 = (HomeShortcutItem)localObject1;
        if (((HomeShortcutItem)localObject1).intent != null)
        {
          Object localObject2 = ((HomeShortcutItem)localObject1).intent.getComponent();
          if (localObject2 != null)
          {
            localObject2 = (Integer)paramMap1.get(localObject2);
            if ((localObject2 != null) && (((Integer)localObject2).intValue() != ((HomeShortcutItem)localObject1).mBadgeCount))
            {
              ((HomeShortcutItem)localObject1).mBadgeCount = ((Integer)localObject2).intValue();
              localArrayList.add(localObject1);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void updatePackage(Map<Long, HomeItem> paramMap, String paramString, List<HomeItem> paramList1, List<HomeItem> paramList2)
  {
    PackageInfo localPackageInfo2;
    PackageInfo localPackageInfo3;
    Object localObject;
    try
    {
      PackageInfo localPackageInfo1 = this.mPkgMgr.getPackageInfo(paramString, 513);
      localPackageInfo2 = this.mPkgMgr.getPackageInfo(paramString, 2);
      localPackageInfo3 = this.mPkgMgr.getPackageInfo(paramString, 4);
      if ((localPackageInfo1 == null) || (localPackageInfo2 == null) || (localPackageInfo3 == null) || (!localPackageInfo1.applicationInfo.enabled))
      {
        removePackage(paramMap, paramString, paramList1);
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localPackageInfo3 = null;
        localPackageInfo2 = null;
        localObject = null;
      }
      paramMap = paramMap.values().iterator();
    }
    while (paramMap.hasNext())
    {
      HomeItem localHomeItem = (HomeItem)paramMap.next();
      ComponentName localComponentName;
      switch (localHomeItem.mType)
      {
      default: 
        break;
      case ???: 
      case ???: 
        localComponentName = localHomeItem.getComponentName();
        if ((localComponentName != null) && (paramString.equals(localComponentName.getPackageName()))) {
          if (!isComponentActive(localComponentName, ((PackageInfo)localObject).activities)) {
            paramList1.add(localHomeItem);
          } else if (refreshShortcut(localHomeItem)) {
            paramList2.add(localHomeItem);
          }
        }
        break;
      case ???: 
        localComponentName = localHomeItem.getComponentName();
        if ((localComponentName != null) && (paramString.equals(localComponentName.getPackageName())) && (!isComponentActive(localComponentName, localPackageInfo2.receivers))) {
          paramList1.add(localHomeItem);
        }
        break;
      case ???: 
        localComponentName = localHomeItem.getComponentName();
        if ((localComponentName != null) && (paramString.equals(localComponentName.getPackageName())) && (!isComponentActive(localComponentName, ((PackageInfo)localObject).activities))) {
          paramList1.add(localHomeItem);
        }
        break;
      case ???: 
        localComponentName = localHomeItem.getComponentName();
        if ((localComponentName != null) && (paramString.equals(localComponentName.getPackageName()))) {
          if (!isComponentActive(localComponentName, localPackageInfo3.services)) {
            paramList1.add(localHomeItem);
          } else {
            paramList2.add(localHomeItem);
          }
        }
        break;
      }
    }
  }
  
  public void updatePackageAvailability(Map<Long, HomeItem> paramMap, String paramString, boolean paramBoolean, List<HomeItem> paramList1, List<HomeItem> paramList2)
  {
    HomeItem localHomeItem1;
    if (paramBoolean) {
      try
      {
        PackageInfo localPackageInfo = this.mPkgMgr.getPackageInfo(paramString, 3);
        if ((localPackageInfo == null) || (!localPackageInfo.applicationInfo.enabled)) {
          return;
        }
        paramMap = paramMap.values().iterator();
        for (;;)
        {
          if (!paramMap.hasNext()) {
            return;
          }
          localHomeItem2 = (HomeItem)paramMap.next();
          if ((localHomeItem2.mType == BaseItem.Type.HOME_APPLICATION) || (localHomeItem2.mType == BaseItem.Type.HOME_SHORTCUT))
          {
            ComponentName localComponentName = localHomeItem2.getComponentName();
            if ((localComponentName != null) && (paramString.equals(localComponentName.getPackageName())))
            {
              if (isComponentActive(localComponentName, localPackageInfo.activities)) {
                break;
              }
              paramList1.add(localHomeItem2);
            }
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          HomeItem localHomeItem2;
          localHomeItem1 = null;
          continue;
          if (refreshShortcut(localHomeItem2)) {
            paramList2.add(localHomeItem2);
          }
        }
      }
    }
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      localHomeItem1 = (HomeItem)paramMap.next();
      switch (localHomeItem1.mType)
      {
      case ???: 
      default: 
        break;
      case ???: 
      case ???: 
        if (paramString.equals(localHomeItem1.getPackageName()))
        {
          localHomeItem1.mIconBitmap = this.mPkgResCache.getUnavailableIcon();
          localHomeItem1.mIconShadowBitmap = null;
          paramList2.add(localHomeItem1);
        }
        break;
      case ???: 
      case ???: 
        if (paramString.equals(localHomeItem1.getPackageName())) {
          paramList1.add(localHomeItem1);
        }
        break;
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomeLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */