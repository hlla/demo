package com.android.launcher2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import java.util.HashMap;

public class PkgResCache
{
  private static final boolean DEBUGGABLE = ;
  private static final int INITIAL_ICON_CAPACITY = 3;
  private static final int INITIAL_LABEL_CAPACITY = 3;
  private static final int INITIAL_PACKAGE_CAPACITY = 80;
  private static final String TAG = "PkgResCache";
  private final LauncherApplication mApp;
  private final Bitmap mDefaultIcon;
  private final Bitmap mFolderIcon;
  private final int mIconDpi;
  private int mMenuIconSize;
  private final HashMap<String, PkgEntry> mPkgCache = new HashMap(80);
  private final PackageManager mPkgMgr;
  private int mTargetIconDpi;
  private final Bitmap mUnavailableIcon;
  private final Bitmap nullIcon = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
  private final String nullString = "";
  
  public PkgResCache(LauncherApplication paramLauncherApplication)
  {
    this.mApp = paramLauncherApplication;
    this.mPkgMgr = paramLauncherApplication.getPackageManager();
    paramLauncherApplication = paramLauncherApplication.getResources();
    Resources localResources = Resources.getSystem();
    int i = paramLauncherApplication.getDimensionPixelSize(2131624134);
    int j = localResources.getDimensionPixelSize(17104896);
    DisplayMetrics localDisplayMetrics = paramLauncherApplication.getDisplayMetrics();
    this.mTargetIconDpi = localDisplayMetrics.densityDpi;
    if (i == j) {
      this.mIconDpi = localDisplayMetrics.densityDpi;
    }
    for (;;)
    {
      this.mDefaultIcon = createDefaultBitmap(localResources, 17629184);
      this.mUnavailableIcon = createDefaultBitmap(paramLauncherApplication, 2130837782);
      this.mFolderIcon = createDefaultBitmap(paramLauncherApplication, 2130837691);
      return;
      i = (int)(i / j * localDisplayMetrics.densityDpi);
      if (i <= 120) {
        this.mIconDpi = 120;
      } else if (i <= 160) {
        this.mIconDpi = 160;
      } else if (i <= 240) {
        this.mIconDpi = 240;
      } else if (i <= 320) {
        this.mIconDpi = 320;
      } else if (i <= 480) {
        this.mIconDpi = 480;
      } else {
        this.mIconDpi = 640;
      }
    }
  }
  
  public PkgResCache(LauncherApplication paramLauncherApplication, int paramInt)
  {
    this(paramLauncherApplication);
    this.mMenuIconSize = paramInt;
    Log.e("teeeeeeeeeeeeeeeeeeest", "mIconDpi is " + this.mIconDpi);
  }
  
  private Bitmap createDefaultBitmap(Resources paramResources, int paramInt)
  {
    return Utilities.createIconBitmap(paramResources.getDrawableForDensity(paramInt, this.mIconDpi), this.mApp);
  }
  
  private void loadTitleAndIcon(String paramString, TitleIconInfo paramTitleIconInfo, ComponentInfo paramComponentInfo)
  {
    i = paramTitleIconInfo.mIconResId;
    j = paramTitleIconInfo.mTitleResId;
    Object localObject9 = paramComponentInfo.applicationInfo;
    Object localObject5;
    if ((i != 0) || (j != 0))
    {
      localObject1 = null;
      localObject2 = null;
      localObject3 = null;
      localObject5 = null;
    }
    for (;;)
    {
      Object localObject4;
      synchronized (this.mPkgCache)
      {
        localObject4 = (PkgEntry)this.mPkgCache.get(paramString);
        if (localObject4 == null)
        {
          localObject8 = new PkgEntry(null);
          this.mPkgCache.put(paramString, localObject8);
          localObject1 = localObject2;
          if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE)
          {
            boolean bool = paramTitleIconInfo.mIsWidget;
            localObject1 = localObject2;
            if (bool) {
              localObject1 = null;
            }
          }
          if ((i == 0) || (localObject1 != null))
          {
            localObject3 = localObject1;
            localObject6 = localObject5;
            if (j != 0)
            {
              localObject3 = localObject1;
              localObject6 = localObject5;
              if (localObject5 != null) {}
            }
          }
          else
          {
            if (localObject9 != null) {
              break label992;
            }
            localObject2 = localObject1;
            localObject7 = localObject5;
            localObject3 = localObject1;
            localObject6 = localObject5;
          }
        }
        try
        {
          localObject9 = this.mPkgMgr.getResourcesForApplication(paramString);
          localObject4 = localObject1;
          if (i == 0) {
            continue;
          }
          localObject4 = localObject1;
          if (localObject1 != null) {
            continue;
          }
          localObject2 = localObject1;
          localObject7 = localObject5;
          localObject3 = localObject1;
          localObject6 = localObject5;
          if (!Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) {
            break label1069;
          }
          localObject2 = localObject1;
          localObject7 = localObject5;
          localObject3 = localObject1;
          localObject6 = localObject5;
          ThemeLoader localThemeLoader = LauncherApplication.getInst().getThemeLoader();
          localObject4 = localObject1;
          localObject2 = localObject1;
          localObject7 = localObject5;
          localObject3 = localObject1;
          localObject6 = localObject5;
          if (!localThemeLoader.isUseDefaultTheme())
          {
            localObject2 = localObject1;
            localObject7 = localObject5;
            localObject3 = localObject1;
            localObject6 = localObject5;
            paramString = localThemeLoader.loadAppIconBitmap(paramComponentInfo.name);
            localObject4 = paramString;
            if (paramString == null)
            {
              localObject4 = paramString;
              localObject2 = paramString;
              localObject7 = localObject5;
              localObject3 = paramString;
              localObject6 = localObject5;
              if (!paramTitleIconInfo.mIsWidget)
              {
                localObject2 = paramString;
                localObject7 = localObject5;
                localObject3 = paramString;
                localObject6 = localObject5;
                if (paramComponentInfo.icon == 0) {
                  break label1022;
                }
                localObject2 = paramString;
                localObject7 = localObject5;
                localObject3 = paramString;
                localObject6 = localObject5;
                localObject1 = paramComponentInfo.name;
                localObject2 = paramString;
                localObject7 = localObject5;
                localObject3 = paramString;
                localObject6 = localObject5;
                localObject4 = localThemeLoader.load3rdAppIconBitmap(loadBitmap((Resources)localObject9, i, (String)localObject1));
              }
            }
          }
          paramString = (String)localObject4;
          if (localObject4 == null)
          {
            localObject2 = localObject4;
            localObject7 = localObject5;
            localObject3 = localObject4;
            localObject6 = localObject5;
            if (paramComponentInfo.icon == 0) {
              break label1045;
            }
            localObject2 = localObject4;
            localObject7 = localObject5;
            localObject3 = localObject4;
            localObject6 = localObject5;
            paramString = paramComponentInfo.name;
            localObject2 = localObject4;
            localObject7 = localObject5;
            localObject3 = localObject4;
            localObject6 = localObject5;
            paramString = loadBitmap((Resources)localObject9, i, paramString);
          }
          localObject2 = paramString;
          localObject7 = localObject5;
          localObject3 = paramString;
          localObject6 = localObject5;
          if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE)
          {
            localObject4 = paramString;
            localObject2 = paramString;
            localObject7 = localObject5;
            localObject3 = paramString;
            localObject6 = localObject5;
            if (paramTitleIconInfo.mIsWidget) {
              continue;
            }
          }
          localObject2 = paramString;
          localObject7 = localObject5;
          localObject3 = paramString;
          localObject6 = localObject5;
          localObject4 = ((PkgEntry)localObject8).mBitmaps;
          if (paramString != null) {
            break label1277;
          }
          localObject2 = paramString;
          localObject7 = localObject5;
          localObject3 = paramString;
          localObject6 = localObject5;
          localObject1 = this.nullIcon;
        }
        catch (PackageManager.NameNotFoundException paramString)
        {
          if ((i == 0) || (localObject2 != null)) {
            break;
          }
          ((PkgEntry)localObject8).mBitmaps.put(i, this.nullIcon);
          localObject3 = localObject2;
          localObject6 = localObject7;
          if (j == 0) {
            continue;
          }
          localObject3 = localObject2;
          localObject6 = localObject7;
          if (localObject7 != null) {
            continue;
          }
          ((PkgEntry)localObject8).mStrings.put(j, "");
          localObject3 = localObject2;
          localObject6 = localObject7;
          continue;
        }
        catch (ClassCastException paramString)
        {
          paramString.printStackTrace();
          continue;
          localObject1 = paramString;
          continue;
        }
        localObject2 = paramString;
        localObject7 = localObject5;
        localObject3 = paramString;
        localObject6 = localObject5;
        ((SparseArray)localObject4).put(i, localObject1);
        localObject4 = paramString;
        localObject3 = localObject4;
        localObject6 = localObject5;
        if (j != 0)
        {
          localObject3 = localObject4;
          localObject6 = localObject5;
          if (localObject5 == null)
          {
            localObject2 = localObject4;
            localObject7 = localObject5;
            localObject3 = localObject4;
            localObject6 = localObject5;
            if (paramComponentInfo.labelRes == 0) {
              break label1166;
            }
            localObject2 = localObject4;
            localObject7 = localObject5;
            localObject3 = localObject4;
            localObject6 = localObject5;
            paramString = paramComponentInfo.name;
            localObject2 = localObject4;
            localObject7 = localObject5;
            localObject3 = localObject4;
            localObject6 = localObject5;
            paramString = loadString((Resources)localObject9, j, paramString);
            localObject2 = localObject4;
            localObject7 = paramString;
            localObject3 = localObject4;
            localObject6 = paramString;
            if (DEBUGGABLE)
            {
              localObject2 = localObject4;
              localObject7 = paramString;
              localObject3 = localObject4;
              localObject6 = paramString;
              Log.d("PkgResCache", "loaded app name : " + paramString + ", packageName : " + paramComponentInfo.packageName);
            }
            localObject2 = localObject4;
            localObject7 = paramString;
            localObject3 = localObject4;
            localObject6 = paramString;
            localObject1 = ((PkgEntry)localObject8).mStrings;
            if (paramString != null) {
              break label1190;
            }
            paramComponentInfo = "";
            localObject2 = localObject4;
            localObject7 = paramString;
            localObject3 = localObject4;
            localObject6 = paramString;
            ((SparseArray)localObject1).put(j, paramComponentInfo);
            localObject6 = paramString;
            localObject3 = localObject4;
          }
        }
        if ((localObject3 != null) && (localObject3 != this.nullIcon)) {
          paramTitleIconInfo.mIcon = ((Bitmap)localObject3);
        }
        if ((localObject6 != null) && (localObject6 != "")) {
          paramTitleIconInfo.mTitle = ((String)localObject6);
        }
        return;
        if (i != 0) {
          localObject1 = (Bitmap)((PkgEntry)localObject4).mBitmaps.get(i);
        }
        if (j != 0) {
          localObject3 = (String)((PkgEntry)localObject4).mStrings.get(j);
        }
        localObject2 = localObject1;
        localObject5 = localObject3;
        localObject8 = localObject4;
        if (!DEBUGGABLE) {
          continue;
        }
        localObject2 = localObject1;
        localObject5 = localObject3;
        localObject8 = localObject4;
        if (localObject1 != this.nullIcon) {
          continue;
        }
        Log.d("PkgResCache", "loadTitleAndIcon: pkgEntry bitmap is nullIcon. label = " + (String)localObject3);
        localObject2 = localObject1;
        localObject5 = localObject3;
        localObject8 = localObject4;
      }
      label992:
      localObject2 = localObject1;
      localObject7 = localObject5;
      localObject3 = localObject1;
      localObject6 = localObject5;
      localObject9 = this.mPkgMgr.getResourcesForApplication((ApplicationInfo)localObject9);
      continue;
      label1022:
      localObject2 = paramString;
      localObject7 = localObject5;
      localObject3 = paramString;
      localObject6 = localObject5;
      localObject1 = paramComponentInfo.packageName;
      continue;
      label1045:
      localObject2 = localObject4;
      localObject7 = localObject5;
      localObject3 = localObject4;
      localObject6 = localObject5;
      paramString = paramComponentInfo.packageName;
      continue;
      label1069:
      localObject2 = localObject1;
      localObject7 = localObject5;
      localObject3 = localObject1;
      localObject6 = localObject5;
      if (paramComponentInfo.icon != 0)
      {
        localObject2 = localObject1;
        localObject7 = localObject5;
        localObject3 = localObject1;
        localObject6 = localObject5;
      }
      for (paramString = paramComponentInfo.name;; paramString = paramComponentInfo.packageName)
      {
        localObject2 = localObject1;
        localObject7 = localObject5;
        localObject3 = localObject1;
        localObject6 = localObject5;
        paramString = loadBitmap((Resources)localObject9, i, paramString);
        break;
        localObject2 = localObject1;
        localObject7 = localObject5;
        localObject3 = localObject1;
        localObject6 = localObject5;
      }
      label1166:
      localObject2 = localObject4;
      localObject7 = localObject5;
      localObject3 = localObject4;
      localObject6 = localObject5;
      paramString = paramComponentInfo.packageName;
      continue;
      label1190:
      paramComponentInfo = paramString;
    }
  }
  
  public void clear()
  {
    synchronized (this.mPkgCache)
    {
      this.mPkgCache.clear();
      return;
    }
  }
  
  public Bitmap getDefaultIcon()
  {
    return this.mDefaultIcon;
  }
  
  public Bitmap getFolderIcon()
  {
    return this.mFolderIcon;
  }
  
  public Bitmap getIcon(Intent paramIntent)
  {
    Object localObject = null;
    ResolveInfo localResolveInfo = this.mPkgMgr.resolveActivity(paramIntent, 0);
    paramIntent = (Intent)localObject;
    if (localResolveInfo != null) {
      paramIntent = getIcon(localResolveInfo);
    }
    return paramIntent;
  }
  
  public Bitmap getIcon(ResolveInfo paramResolveInfo)
  {
    Object localObject1 = null;
    ResolveInfo localResolveInfo = null;
    int i = paramResolveInfo.getIconResource();
    Object localObject2;
    if (i != 0)
    {
      if (paramResolveInfo.activityInfo != null) {
        break label88;
      }
      localObject2 = paramResolveInfo.serviceInfo;
    }
    label88:
    label135:
    do
    {
      synchronized (this.mPkgCache)
      {
        for (;;)
        {
          paramResolveInfo = (PkgEntry)this.mPkgCache.get(((ComponentInfo)localObject2).packageName);
          if (paramResolveInfo == null) {
            break;
          }
          localObject1 = (Bitmap)paramResolveInfo.mBitmaps.get(i);
          localResolveInfo = paramResolveInfo;
          if (localObject1 != this.nullIcon) {
            break label135;
          }
          paramResolveInfo = null;
          localObject1 = paramResolveInfo;
          return (Bitmap)localObject1;
          localObject2 = paramResolveInfo.activityInfo;
        }
        paramResolveInfo = new PkgEntry(null);
        this.mPkgCache.put(((ComponentInfo)localObject2).packageName, paramResolveInfo);
        localObject1 = localResolveInfo;
        localResolveInfo = paramResolveInfo;
      }
      paramResolveInfo = (ResolveInfo)localObject1;
    } while (localObject1 != null);
    paramResolveInfo = (ResolveInfo)localObject1;
    for (;;)
    {
      try
      {
        Object localObject3 = this.mPkgMgr.getResourcesForApplication(((ComponentInfo)localObject2).applicationInfo);
        paramResolveInfo = (ResolveInfo)localObject1;
        if (((ComponentInfo)localObject2).icon == 0) {
          break label241;
        }
        paramResolveInfo = (ResolveInfo)localObject1;
        localObject2 = ((ComponentInfo)localObject2).name;
        paramResolveInfo = (ResolveInfo)localObject1;
        localObject1 = loadBitmap((Resources)localObject3, i, (String)localObject2);
        paramResolveInfo = (ResolveInfo)localObject1;
        localObject3 = localResolveInfo.mBitmaps;
        if (localObject1 != null) {
          break label253;
        }
        paramResolveInfo = (ResolveInfo)localObject1;
        localObject2 = this.nullIcon;
        paramResolveInfo = (ResolveInfo)localObject1;
        ((SparseArray)localObject3).put(i, localObject2);
        paramResolveInfo = (ResolveInfo)localObject1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        localResolveInfo.mBitmaps.put(i, this.nullIcon);
      }
      break;
      label241:
      paramResolveInfo = localNameNotFoundException;
      localObject2 = ((ComponentInfo)localObject2).packageName;
      continue;
      label253:
      localObject2 = localNameNotFoundException;
    }
  }
  
  public String getTitle(Intent paramIntent)
  {
    Object localObject = null;
    ResolveInfo localResolveInfo = this.mPkgMgr.resolveActivity(paramIntent, 0);
    paramIntent = (Intent)localObject;
    if (localResolveInfo != null) {
      paramIntent = getTitle(localResolveInfo);
    }
    return paramIntent;
  }
  
  public String getTitle(ResolveInfo paramResolveInfo)
  {
    Object localObject3 = null;
    PkgEntry localPkgEntry = null;
    Object localObject2;
    int i;
    Object localObject1;
    if (paramResolveInfo.activityInfo == null)
    {
      localObject2 = paramResolveInfo.serviceInfo;
      i = 0;
      ??? = paramResolveInfo.nonLocalizedLabel;
      localObject1 = ???;
      if (??? == null)
      {
        int j = paramResolveInfo.labelRes;
        localObject1 = ???;
        i = j;
        if (j == 0)
        {
          paramResolveInfo = ((ComponentInfo)localObject2).nonLocalizedLabel;
          localObject1 = paramResolveInfo;
          i = j;
          if (paramResolveInfo == null)
          {
            j = ((ComponentInfo)localObject2).labelRes;
            localObject1 = paramResolveInfo;
            i = j;
            if (j == 0)
            {
              paramResolveInfo = ((ComponentInfo)localObject2).applicationInfo.nonLocalizedLabel;
              localObject1 = paramResolveInfo;
              i = j;
              if (paramResolveInfo == null)
              {
                i = ((ComponentInfo)localObject2).applicationInfo.labelRes;
                localObject1 = paramResolveInfo;
              }
            }
          }
        }
      }
      if (localObject1 == null) {
        break label138;
      }
      paramResolveInfo = ((CharSequence)localObject1).toString().trim();
    }
    label138:
    do
    {
      return paramResolveInfo;
      localObject2 = paramResolveInfo.activityInfo;
      break;
      paramResolveInfo = localPkgEntry;
    } while (i == 0);
    for (;;)
    {
      synchronized (this.mPkgCache)
      {
        localPkgEntry = (PkgEntry)this.mPkgCache.get(((ComponentInfo)localObject2).packageName);
        if (localPkgEntry != null)
        {
          paramResolveInfo = (String)localPkgEntry.mStrings.get(i);
          break label362;
          return (String)localObject1;
        }
      }
      localPkgEntry = new PkgEntry(null);
      this.mPkgCache.put(((ComponentInfo)localObject2).packageName, localPkgEntry);
      paramResolveInfo = (ResolveInfo)localObject3;
      label343:
      label356:
      label362:
      while (paramResolveInfo != "")
      {
        localObject1 = paramResolveInfo;
        if (paramResolveInfo != null) {
          break;
        }
        localObject1 = paramResolveInfo;
        for (;;)
        {
          try
          {
            localObject3 = this.mPkgMgr.getResourcesForApplication(((ComponentInfo)localObject2).applicationInfo);
            localObject1 = paramResolveInfo;
            if (((ComponentInfo)localObject2).labelRes == 0) {
              break label343;
            }
            localObject1 = paramResolveInfo;
            localObject2 = ((ComponentInfo)localObject2).name;
            localObject1 = paramResolveInfo;
            paramResolveInfo = loadString((Resources)localObject3, i, (String)localObject2);
            localObject1 = paramResolveInfo;
            localObject3 = localPkgEntry.mStrings;
            if (paramResolveInfo != null) {
              break label356;
            }
            localObject2 = "";
            localObject1 = paramResolveInfo;
            ((SparseArray)localObject3).put(i, localObject2);
            localObject1 = paramResolveInfo;
          }
          catch (PackageManager.NameNotFoundException paramResolveInfo)
          {
            localPkgEntry.mStrings.put(i, "");
          }
          break;
          localObject1 = paramResolveInfo;
          localObject2 = ((ComponentInfo)localObject2).packageName;
          continue;
          localObject2 = paramResolveInfo;
        }
      }
      localObject1 = null;
    }
  }
  
  public void getTitleAndIcon(TitleIconInfo paramTitleIconInfo, Intent paramIntent)
  {
    paramIntent = this.mPkgMgr.resolveActivity(paramIntent, 0);
    if (paramIntent != null)
    {
      getTitleAndIcon(paramTitleIconInfo, paramIntent);
      return;
    }
    paramTitleIconInfo.mIconResId = 0;
    paramTitleIconInfo.mIcon = null;
    paramTitleIconInfo.mTitleResId = 0;
    paramTitleIconInfo.mTitle = null;
    paramTitleIconInfo.mIsWidget = false;
  }
  
  public void getTitleAndIcon(TitleIconInfo paramTitleIconInfo, ResolveInfo paramResolveInfo)
  {
    Object localObject3 = null;
    if (paramResolveInfo.activityInfo == null) {}
    for (Object localObject2 = paramResolveInfo.serviceInfo;; localObject2 = paramResolveInfo.activityInfo)
    {
      int k = paramResolveInfo.getIconResource();
      paramTitleIconInfo.mIconResId = k;
      paramTitleIconInfo.mIcon = null;
      int i = 0;
      CharSequence localCharSequence = paramResolveInfo.nonLocalizedLabel;
      Object localObject1 = localCharSequence;
      if (localCharSequence == null)
      {
        int j = paramResolveInfo.labelRes;
        localObject1 = localCharSequence;
        i = j;
        if (j == 0)
        {
          paramResolveInfo = ((ComponentInfo)localObject2).nonLocalizedLabel;
          localObject1 = paramResolveInfo;
          i = j;
          if (paramResolveInfo == null)
          {
            j = ((ComponentInfo)localObject2).labelRes;
            localObject1 = paramResolveInfo;
            i = j;
            if (j == 0)
            {
              paramResolveInfo = ((ComponentInfo)localObject2).applicationInfo.nonLocalizedLabel;
              localObject1 = paramResolveInfo;
              i = j;
              if (paramResolveInfo == null)
              {
                i = ((ComponentInfo)localObject2).applicationInfo.labelRes;
                localObject1 = paramResolveInfo;
              }
            }
          }
        }
      }
      paramTitleIconInfo.mTitleResId = i;
      paramResolveInfo = (ResolveInfo)localObject3;
      if (localObject1 != null) {
        paramResolveInfo = ((CharSequence)localObject1).toString().trim();
      }
      paramTitleIconInfo.mTitle = paramResolveInfo;
      if ((k != 0) || (i != 0)) {
        loadTitleAndIcon(((ComponentInfo)localObject2).packageName, paramTitleIconInfo, (ComponentInfo)localObject2);
      }
      return;
    }
  }
  
  public Bitmap getUnavailableIcon()
  {
    return this.mUnavailableIcon;
  }
  
  public Bitmap loadBitmap(Resources paramResources, int paramInt, String paramString)
  {
    localObject4 = null;
    localObject1 = null;
    try
    {
      localObject2 = this.mPkgMgr.getCSCPackageItemIcon(paramString);
      localObject1 = localObject2;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      Object localObject3;
      try
      {
        if (paramString.contains("com.samsung.helphub")) {}
        for (Object localObject2 = paramResources.getDrawableForDensity(paramInt, this.mTargetIconDpi);; localObject3 = paramResources.getDrawableForDensity(paramInt, this.mIconDpi))
        {
          paramResources = (Resources)localObject4;
          if (localObject2 != null)
          {
            if ((!LauncherApplication.isMenuIconSizeChanged()) || (this.mMenuIconSize <= 0)) {
              break label186;
            }
            paramResources = Utilities.createIconBitmap((Drawable)localObject2, this.mApp, this.mMenuIconSize);
          }
          return paramResources;
          localNoSuchMethodError = localNoSuchMethodError;
          Log.e("PkgResCache", "Cound not call getCSCPackageItemIcon. This should only happen when running on a device without CSC related features");
          break;
        }
      }
      catch (Resources.NotFoundException paramResources)
      {
        for (;;)
        {
          localObject3 = localObject1;
          if (DEBUGGABLE)
          {
            Log.w("PkgResCache", "Failed to load icon from res.getDrawableForDensity : " + paramResources + " resId = " + paramInt);
            localObject3 = localObject1;
          }
        }
      }
      return Utilities.createIconBitmap((Drawable)localObject3, this.mApp);
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (!LauncherApplication.isMenuIconSizeChanged()) {
        break label67;
      }
      localObject2 = localObject1;
      if (this.mMenuIconSize != 0) {
        break label67;
      }
    }
  }
  
  public String loadString(Resources paramResources, int paramInt, String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = this.mPkgMgr.getCSCPackageItemText(paramString);
      localObject = paramString;
      if (paramString != null) {}
    }
    catch (NoSuchMethodError paramString)
    {
      for (;;)
      {
        try
        {
          localObject = paramResources.getText(paramInt);
          paramResources = ((CharSequence)localObject).toString().trim();
          return paramResources;
        }
        catch (Resources.NotFoundException paramResources) {}
        paramString = paramString;
        Log.e("PkgResCache", "Could not call getCSCPackageItemText. This should only happen when running on a device without CSC related features");
        paramString = (String)localObject;
      }
    }
    return null;
  }
  
  public void refreshTitleAndIcon(ComponentName paramComponentName, TitleIconInfo paramTitleIconInfo)
  {
    try
    {
      ActivityInfo localActivityInfo = this.mPkgMgr.getActivityInfo(paramComponentName, 0);
      if (localActivityInfo != null) {
        loadTitleAndIcon(paramComponentName.getPackageName(), paramTitleIconInfo, localActivityInfo);
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  void removePackage(String paramString)
  {
    synchronized (this.mPkgCache)
    {
      this.mPkgCache.remove(paramString);
      return;
    }
  }
  
  private static class PkgEntry
  {
    private final SparseArray<Bitmap> mBitmaps = new SparseArray(3);
    private final SparseArray<String> mStrings = new SparseArray(3);
  }
  
  public static class TitleIconInfo
  {
    public Bitmap mIcon;
    public int mIconResId;
    public boolean mIsWidget;
    public String mTitle;
    public int mTitleResId;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/PkgResCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */