package com.android.launcher2;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MenuAppLoader
{
  private static final boolean DEBUGGABLE = ;
  private static final boolean DEBUG_LOADER = true;
  private static final int DEFAULT_APP_COUNT = 50;
  private static final int DEFAULT_FOLDER_COUNT = 10;
  private static final String TAG = "MenuAppLoader";
  public static ArrayList<String> nonUninstallableApps = new ArrayList();
  public static ArrayList<String> nonUninstallableWidgets = new ArrayList();
  public ArrayList<AppItem> added = new ArrayList();
  private volatile boolean mAbortLoader;
  private Map<Long, AppItem> mAllItems;
  private final Map<ComponentName, AppItem> mApps = new HashMap(50);
  private final BadgeCache mBadgeCache;
  private final boolean mIsSafeMode;
  private final LauncherApplication mLauncherApp;
  private final PackageManager mPkgMgr;
  private final PkgResCache mPkgResCache;
  public ArrayList<AppItem> modified = new ArrayList();
  public ArrayList<AppItem> removed = new ArrayList();
  private final PkgResCache.TitleIconInfo titleAndIcon = new PkgResCache.TitleIconInfo();
  
  static
  {
    nonUninstallableApps.add("com.agoda.mobile.consumer");
    nonUninstallableApps.add("com.glu.bombshells_samsung");
    nonUninstallableApps.add("com.tecace.cameraace");
    nonUninstallableApps.add("com.izsoft.canimalsabc");
    nonUninstallableApps.add("com.glu.contractkiller2_samsung");
    nonUninstallableApps.add("com.NamcoBandaiGames.DoodleFit2.Samsung");
    nonUninstallableApps.add("com.glu.dragonslayer_samsung");
    nonUninstallableApps.add("com.hcom.android");
    nonUninstallableApps.add("com.oceanhouse_media.booklcjustmeandmymomlite_app");
    nonUninstallableApps.add("com.moleskine.android");
    nonUninstallableApps.add("com.itech.pdfreaderpro");
    nonUninstallableApps.add("air.com.adobe.pstouch.oem1");
    nonUninstallableApps.add("com.namcobandaigames.rocketfox");
    nonUninstallableApps.add("com.sesame.apps.elmocalls.android");
    nonUninstallableApps.add("com.ea.tetrisfree_na");
    nonUninstallableApps.add("com.fuzzypeach.worldfactbook_tab");
    nonUninstallableApps.add("com.ikonet.vhb");
    nonUninstallableApps.add("com.itech.virtualofficepro");
    nonUninstallableApps.add("com.almond.kitty.spen");
    nonUninstallableApps.add("kr.co.rightbrain.RetailMode.Galaxy_TAB3_8_DCT");
    nonUninstallableWidgets.add("com.almond.kitty.spen");
    nonUninstallableWidgets.add("com.tecace.cameraace");
    nonUninstallableWidgets.add("com.hcom.android");
  }
  
  public MenuAppLoader(LauncherApplication paramLauncherApplication, PkgResCache paramPkgResCache, BadgeCache paramBadgeCache)
  {
    this.mLauncherApp = paramLauncherApplication;
    this.mPkgResCache = paramPkgResCache;
    this.mBadgeCache = paramBadgeCache;
    this.mPkgMgr = paramLauncherApplication.getPackageManager();
    this.mIsSafeMode = this.mPkgMgr.isSafeMode();
  }
  
  private AppItem createApp(ResolveInfo paramResolveInfo)
  {
    ActivityInfo localActivityInfo = paramResolveInfo.activityInfo;
    AppItem localAppItem2 = null;
    AppItem localAppItem1 = localAppItem2;
    String str;
    ComponentName localComponentName;
    boolean bool1;
    if (localActivityInfo != null)
    {
      str = localActivityInfo.packageName;
      localComponentName = new ComponentName(str, localActivityInfo.name);
      localAppItem1 = localAppItem2;
      if (!this.mApps.containsKey(localComponentName))
      {
        if ((localActivityInfo.applicationInfo.flags & 0x81) == 0) {
          break label230;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (nonUninstallableApps.contains(str))
      {
        bool2 = bool1;
        if (Build.MODEL.equals("SM-T310X")) {
          bool2 = true;
        }
      }
      localAppItem2 = new AppItem(localComponentName, bool2);
      localAppItem2.mDirty = true;
      setTitleAndIcon(localAppItem2, paramResolveInfo, localComponentName);
      setBadgeCount(localAppItem2);
      if (!localAppItem2.mSystemApp) {}
      try
      {
        localAppItem2.mCreateTime = this.mPkgMgr.getPackageInfo(str, 0).firstInstallTime;
        localAppItem1 = localAppItem2;
        if (DEBUGGABLE)
        {
          Log.d("MenuAppLoader", String.format("createApp title(%s) package(%s)", new Object[] { localAppItem2.mTitle, str }));
          localAppItem1 = localAppItem2;
        }
        if (localAppItem1 != null) {
          this.mApps.put(localAppItem1.mComponentName, localAppItem1);
        }
        return localAppItem1;
        label230:
        bool1 = false;
      }
      catch (PackageManager.NameNotFoundException paramResolveInfo)
      {
        for (;;)
        {
          Log.d("MenuAppLoader", "Cannot find PackageInfo for " + str);
        }
      }
    }
  }
  
  private LauncherSettings.AppOrderModify createDbAppItem(AppItem paramAppItem)
  {
    LauncherSettings.AppOrderModify localAppOrderModify = new LauncherSettings.AppOrderModify();
    if (paramAppItem.mType == BaseItem.Type.MENU_FOLDER)
    {
      localAppOrderModify.action = 0;
      localAppOrderModify.id = paramAppItem.mId;
      localAppOrderModify.screen = paramAppItem.mScreen;
      localAppOrderModify.cell = paramAppItem.mCell;
      localAppOrderModify.title = paramAppItem.mTitle;
      localAppOrderModify.color = paramAppItem.mColor;
      localAppOrderModify.secret = paramAppItem.mSecretItem;
      return localAppOrderModify;
    }
    localAppOrderModify.action = 3;
    if (paramAppItem.mFolder != null) {}
    for (long l = paramAppItem.mFolder.mId;; l = -1L)
    {
      localAppOrderModify.folderId = l;
      localAppOrderModify.component = paramAppItem.mComponentName;
      localAppOrderModify.hidden = paramAppItem.mHidden;
      break;
    }
  }
  
  private List<ResolveInfo> findActivitiesForPackage(String paramString)
  {
    Object localObject = new Intent("android.intent.action.MAIN", null);
    ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
    ((Intent)localObject).setPackage(paramString);
    localObject = this.mPkgMgr.queryIntentActivities((Intent)localObject, 0);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = Collections.emptyList();
    }
    return paramString;
  }
  
  private static boolean findActivity(List<ResolveInfo> paramList, ComponentName paramComponentName)
  {
    paramComponentName = paramComponentName.getClassName();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((ResolveInfo)paramList.next()).activityInfo.name.equals(paramComponentName)) {
        return true;
      }
    }
    return false;
  }
  
  private AppFolderItem getOrCreateFolder(long paramLong)
  {
    AppFolderItem localAppFolderItem = null;
    AppItem localAppItem = (AppItem)this.mAllItems.get(Long.valueOf(paramLong));
    if (localAppItem == null)
    {
      localAppFolderItem = new AppFolderItem();
      localAppFolderItem.mId = paramLong;
      localAppFolderItem.mDirty = true;
      localAppFolderItem.mIconBitmap = this.mPkgResCache.getFolderIcon();
      this.mAllItems.put(Long.valueOf(paramLong), localAppFolderItem);
    }
    while (localAppItem.mType != BaseItem.Type.MENU_FOLDER) {
      return localAppFolderItem;
    }
    return (AppFolderItem)localAppItem;
  }
  
  private void setBadgeCount(AppItem paramAppItem)
  {
    paramAppItem.mBadgeCount = this.mBadgeCache.getBadgeCount(paramAppItem.mComponentName);
  }
  
  private void setTitleAndIcon(AppItem paramAppItem, ResolveInfo paramResolveInfo, ComponentName paramComponentName)
  {
    this.mPkgResCache.getTitleAndIcon(this.titleAndIcon, paramResolveInfo);
    paramAppItem.mIconResId = this.titleAndIcon.mIconResId;
    paramAppItem.mTitleResId = this.titleAndIcon.mTitleResId;
    if (this.titleAndIcon.mIcon == null)
    {
      paramResolveInfo = this.mPkgResCache.getDefaultIcon();
      paramAppItem.mIconBitmap = paramResolveInfo;
      if (this.titleAndIcon.mTitle != null) {
        break label89;
      }
    }
    label89:
    for (paramResolveInfo = paramComponentName.getClassName();; paramResolveInfo = this.titleAndIcon.mTitle)
    {
      paramAppItem.mTitle = paramResolveInfo;
      return;
      paramResolveInfo = this.titleAndIcon.mIcon;
      break;
    }
  }
  
  private AppItem updateOrCreateApp(ComponentName paramComponentName, long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, boolean paramBoolean2)
  {
    Object localObject2 = null;
    AppItem localAppItem;
    if (paramComponentName != null)
    {
      localAppItem = (AppItem)this.mApps.get(paramComponentName);
      localObject1 = localAppItem;
      if (localAppItem == null) {
        localObject3 = localAppItem;
      }
    }
    for (;;)
    {
      try
      {
        str = paramComponentName.getPackageName();
        localObject3 = localAppItem;
        localPackageInfo = this.mPkgMgr.getPackageInfo(str, 8192);
        localObject3 = localAppItem;
        localApplicationInfo = localPackageInfo.applicationInfo;
        localObject1 = localAppItem;
        if (localApplicationInfo != null)
        {
          localObject3 = localAppItem;
          if ((localApplicationInfo.flags & 0x1) == 0) {
            continue;
          }
          j = 1;
          localObject3 = localAppItem;
          if ((localApplicationInfo.flags & 0x40000) == 0) {
            continue;
          }
          i = 1;
          label115:
          if ((j != 0) || (i != 0)) {
            continue;
          }
          localObject3 = localAppItem;
          if ((localApplicationInfo.flags & 0x800000) == 0) {
            continue;
          }
          j = 1;
          label144:
          if (i == 0) {
            continue;
          }
          localObject3 = localAppItem;
          localObject2 = new AppItem(paramComponentName, false);
          localObject1 = localObject2;
        }
      }
      catch (PackageManager.NameNotFoundException paramComponentName)
      {
        String str;
        PackageInfo localPackageInfo;
        ApplicationInfo localApplicationInfo;
        int j;
        int i;
        label264:
        label629:
        localObject1 = localObject3;
        continue;
      }
      try
      {
        ((AppItem)localObject2).mIconBitmap = this.mPkgResCache.getUnavailableIcon();
        localObject1 = localObject2;
        ((AppItem)localObject2).mCreateTime = localPackageInfo.firstInstallTime;
        localObject1 = localObject2;
        ((AppItem)localObject2).mUnavailable = true;
        localObject1 = localObject2;
        ((AppItem)localObject2).mTitle = paramString;
        localObject1 = localObject2;
        ((AppItem)localObject2).mColor = paramInt3;
        localObject1 = localObject2;
        this.mApps.put(paramComponentName, localObject2);
        localObject1 = localObject2;
        ((AppItem)localObject2).mSecretItem = paramBoolean2;
        localObject1 = localObject2;
        setBadgeCount((AppItem)localObject2);
        localObject1 = localObject2;
        localObject3 = localObject2;
        if (DEBUGGABLE)
        {
          localObject3 = localObject2;
          Log.d("MenuAppLoader", String.format("title(%s) pkgName(%s) appInfo.flags(%d) ", new Object[] { paramString, str, Integer.valueOf(localApplicationInfo.flags) }));
          localObject1 = localObject2;
        }
      }
      catch (PackageManager.NameNotFoundException paramComponentName) {}
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((AppItem)localObject1).mId == -1L)
      {
        ((AppItem)localObject1).mId = paramLong1;
        ((AppItem)localObject1).mScreen = paramInt1;
        ((AppItem)localObject1).mCell = paramInt2;
        ((AppItem)localObject1).mHidden = paramBoolean1;
        ((AppItem)localObject1).mDirty = false;
        ((AppItem)localObject1).mSecretItem = paramBoolean2;
        if (paramLong2 != -1L)
        {
          paramComponentName = getOrCreateFolder(paramLong2);
          if (paramComponentName == null) {
            break label629;
          }
          paramComponentName.loadItem((AppItem)localObject1);
        }
      }
    }
    for (;;)
    {
      paramComponentName = (AppItem)this.mAllItems.put(Long.valueOf(paramLong1), localObject1);
      localObject2 = localObject1;
      if (paramComponentName != null)
      {
        localObject2 = localObject1;
        if (paramComponentName.mType == BaseItem.Type.MENU_FOLDER)
        {
          ((AppFolderItem)paramComponentName).destroy();
          localObject2 = localObject1;
        }
      }
      return (AppItem)localObject2;
      j = 0;
      break;
      i = 0;
      break label115;
      j = 0;
      break label144;
      localObject2 = localAppItem;
      localObject3 = localAppItem;
      if (!this.mIsSafeMode) {
        break label264;
      }
      localObject2 = localAppItem;
      if (j == 0) {
        break label264;
      }
      localObject3 = localAppItem;
      localObject2 = new AppItem(paramComponentName, false);
      localObject1 = localObject2;
      ((AppItem)localObject2).mIconBitmap = this.mPkgResCache.getUnavailableIcon();
      localObject1 = localObject2;
      ((AppItem)localObject2).mCreateTime = localPackageInfo.firstInstallTime;
      localObject1 = localObject2;
      ((AppItem)localObject2).mUnavailable = true;
      localObject1 = localObject2;
      ((AppItem)localObject2).mTitle = paramString;
      localObject1 = localObject2;
      ((AppItem)localObject2).mColor = paramInt3;
      localObject1 = localObject2;
      this.mApps.put(paramComponentName, localObject2);
      localObject1 = localObject2;
      setBadgeCount((AppItem)localObject2);
      localObject1 = localObject2;
      ((AppItem)localObject2).mSecretItem = paramBoolean2;
      break label264;
      ((AppItem)localObject1).mDirty = true;
      ((AppItem)localObject1).mScreen = -1;
      ((AppItem)localObject1).mCell = -1;
    }
  }
  
  private AppFolderItem updateOrCreateFolder(long paramLong, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramLong != -1L)
    {
      AppFolderItem localAppFolderItem = getOrCreateFolder(paramLong);
      localObject = localAppFolderItem;
      if (localAppFolderItem != null)
      {
        localAppFolderItem.mScreen = paramInt1;
        localAppFolderItem.mCell = paramInt2;
        localAppFolderItem.mTitle = paramString;
        localAppFolderItem.mDirty = false;
        localAppFolderItem.mColor = paramInt3;
        localAppFolderItem.mSecretItem = paramBoolean;
        localObject = localAppFolderItem;
      }
    }
    return (AppFolderItem)localObject;
  }
  
  private void updatePackageActivities(String paramString, List<ResolveInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    LauncherProvider localLauncherProvider = this.mLauncherApp.getLauncherProvider();
    Object localObject1 = this.mApps.values().iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AppItem)((Iterator)localObject1).next();
      localObject3 = ((AppItem)localObject2).mComponentName;
      if ((paramString.equals(((ComponentName)localObject3).getPackageName())) && (!findActivity(paramList, (ComponentName)localObject3)))
      {
        this.removed.add(localObject2);
        ((Iterator)localObject1).remove();
        localObject3 = new LauncherSettings.AppOrderModify();
        ((LauncherSettings.AppOrderModify)localObject3).action = 5;
        ((LauncherSettings.AppOrderModify)localObject3).id = ((AppItem)localObject2).mId;
        localArrayList.add(localObject3);
      }
    }
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      localObject1 = (ResolveInfo)paramString.next();
      localObject2 = new ComponentName(((ResolveInfo)localObject1).activityInfo.packageName, ((ResolveInfo)localObject1).activityInfo.name);
      paramList = (AppItem)this.mApps.get(localObject2);
      if (paramList == null)
      {
        paramList = createApp((ResolveInfo)localObject1);
        if (paramList != null)
        {
          paramList.mId = localLauncherProvider.generateNewMenuId();
          paramList.mDirty = false;
          this.added.add(paramList);
          localArrayList.add(createDbAppItem(paramList));
        }
      }
      else
      {
        localObject3 = paramList.mTitle;
        setTitleAndIcon(paramList, (ResolveInfo)localObject1, (ComponentName)localObject2);
        paramList.mIconShadowBitmap = null;
        paramList.mUnavailable = false;
        this.modified.add(paramList);
        if (!((String)localObject3).equals(paramList.mTitle))
        {
          localObject1 = new LauncherSettings.AppOrderModify();
          ((LauncherSettings.AppOrderModify)localObject1).action = 2;
          ((LauncherSettings.AppOrderModify)localObject1).id = paramList.mId;
          ((LauncherSettings.AppOrderModify)localObject1).title = paramList.mTitle;
          localArrayList.add(localObject1);
        }
      }
    }
    if (!localArrayList.isEmpty()) {
      LauncherModel.updateAppItems(this.mLauncherApp, localArrayList);
    }
  }
  
  public void abortLoader()
  {
    this.mAbortLoader = true;
  }
  
  public void addPackage(String paramString)
  {
    Object localObject = findActivitiesForPackage(paramString);
    paramString = new ArrayList(((List)localObject).size());
    LauncherProvider localLauncherProvider = this.mLauncherApp.getLauncherProvider();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AppItem localAppItem = createApp((ResolveInfo)((Iterator)localObject).next());
      if (localAppItem != null)
      {
        localAppItem.mId = localLauncherProvider.generateNewMenuId();
        localAppItem.mDirty = false;
        this.added.add(localAppItem);
        paramString.add(createDbAppItem(localAppItem));
      }
    }
    if (!paramString.isEmpty()) {
      LauncherModel.updateAppItems(this.mLauncherApp, paramString);
    }
  }
  
  public Map<Long, AppItem> loadAllItems(boolean paramBoolean)
  {
    if (DEBUGGABLE) {
      Log.d("MenuAppLoader", "loadAllItems");
    }
    long l2 = SystemClock.uptimeMillis();
    this.mAbortLoader = false;
    this.mAllItems = new HashMap(60);
    this.mApps.clear();
    this.added.clear();
    this.removed.clear();
    this.modified.clear();
    Object localObject2 = new Intent("android.intent.action.MAIN");
    ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
    Object localObject1 = this.mLauncherApp.getContentResolver();
    localObject2 = this.mPkgMgr.queryIntentActivities((Intent)localObject2, 0);
    long l3 = SystemClock.uptimeMillis();
    if (localObject2 == null) {
      return null;
    }
    localObject2 = ((List)localObject2).iterator();
    Object localObject3;
    long l4;
    long l5;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ResolveInfo)((Iterator)localObject2).next();
      if (!this.mAbortLoader) {}
    }
    else
    {
      l4 = SystemClock.uptimeMillis();
      localObject1 = ((ContentResolver)localObject1).query(LauncherSettings.AppOrder.CONTENT_URI, null, null, null, null);
      l5 = SystemClock.uptimeMillis();
    }
    long l1;
    Object localObject4;
    int i;
    for (;;)
    {
      int i6;
      int i7;
      try
      {
        int j = ((Cursor)localObject1).getColumnIndexOrThrow("_id");
        int k = ((Cursor)localObject1).getColumnIndexOrThrow("folderId");
        int m = ((Cursor)localObject1).getColumnIndexOrThrow("screen");
        int n = ((Cursor)localObject1).getColumnIndexOrThrow("cell");
        int i1 = ((Cursor)localObject1).getColumnIndexOrThrow("hidden");
        int i2 = ((Cursor)localObject1).getColumnIndexOrThrow("title");
        int i3 = ((Cursor)localObject1).getColumnIndexOrThrow("componentName");
        int i4 = ((Cursor)localObject1).getColumnIndexOrThrow("color");
        int i5 = ((Cursor)localObject1).getColumnIndexOrThrow("secret");
        localObject2 = new ArrayList();
        if ((this.mAbortLoader) || (!((Cursor)localObject1).moveToNext())) {
          break label579;
        }
        l1 = ((Cursor)localObject1).getLong(j);
        l6 = ((Cursor)localObject1).getLong(k);
        i6 = ((Cursor)localObject1).getInt(m);
        i7 = ((Cursor)localObject1).getInt(n);
        if (((Cursor)localObject1).getInt(i1) == 0) {
          break label544;
        }
        paramBoolean = true;
        localObject3 = ((Cursor)localObject1).getString(i2);
        localObject4 = ((Cursor)localObject1).getString(i3);
        if (!LauncherApplication.sIsFolderColorSupport) {
          break label549;
        }
        i = ((Cursor)localObject1).getInt(i4);
        if (((Cursor)localObject1).getInt(i5) == 0) {
          break label554;
        }
        bool = true;
        if (localObject4 == null) {
          break label560;
        }
        if (updateOrCreateApp(ComponentName.unflattenFromString((String)localObject4), l1, l6, i6, i7, paramBoolean, (String)localObject3, i, bool) != null) {
          continue;
        }
        localObject3 = new LauncherSettings.AppOrderModify();
        ((LauncherSettings.AppOrderModify)localObject3).action = 5;
        ((LauncherSettings.AppOrderModify)localObject3).id = l1;
        ((List)localObject2).add(localObject3);
        continue;
        if (!((ResolveInfo)localObject3).activityInfo.packageName.equals("sstream.app")) {
          break label534;
        }
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
      Log.d("MenuAppLoader", "remove from apps (SStream App)");
      break;
      label534:
      createApp((ResolveInfo)localObject3);
      break;
      label544:
      paramBoolean = false;
      continue;
      label549:
      i = -1;
      continue;
      label554:
      boolean bool = false;
      continue;
      label560:
      updateOrCreateFolder(l1, i6, i7, (String)localObject3, i, bool);
    }
    label579:
    if ((!this.mIsSafeMode) && (!localList.isEmpty())) {
      LauncherModel.updateAppItems(this.mLauncherApp, localList);
    }
    ((Cursor)localObject1).close();
    long l6 = SystemClock.uptimeMillis();
    Map localMap = this.mAllItems;
    if (this.mAbortLoader) {
      localObject1 = null;
    }
    for (;;)
    {
      l1 = SystemClock.uptimeMillis();
      Log.d("MenuAppLoader", "loadAllItems; aborted: " + this.mAbortLoader);
      Log.d("MenuAppLoader", "    Query PkgMgr for all main intents: " + (l3 - l2));
      Log.d("MenuAppLoader", "    Create AppItem for all main intents: " + (l4 - l3) + " / " + (l4 - l2));
      Log.d("MenuAppLoader", "    Query AppOrder database table: " + (l5 - l4) + " / " + (l5 - l2));
      Log.d("MenuAppLoader", "    Merge AppOrder and PkgMgr data: " + (l6 - l5) + " / " + (l6 - l2));
      Log.d("MenuAppLoader", "    Normalize items and update DB: " + (l1 - l6) + " / " + (l1 - l2));
      this.mAllItems = null;
      return (Map<Long, AppItem>)localObject1;
      localObject1 = new HashSet();
      localObject3 = localMap.values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (AppItem)((Iterator)localObject3).next();
        if ((((AppItem)localObject4).mDirty) && (((AppItem)localObject4).mType == BaseItem.Type.MENU_FOLDER)) {
          ((Set)localObject1).add(localObject4);
        }
      }
      localObject3 = this.mLauncherApp.getLauncherProvider();
      localObject4 = this.mApps.values().iterator();
      AppItem localAppItem;
      while (((Iterator)localObject4).hasNext())
      {
        localAppItem = (AppItem)((Iterator)localObject4).next();
        if ((localAppItem.mId == -1L) && (localObject3 != null))
        {
          localAppItem.mId = ((LauncherProvider)localObject3).generateNewMenuId();
          localAppItem.mDirty = true;
          localMap.put(Long.valueOf(localAppItem.mId), localAppItem);
          ((Set)localObject1).add(localAppItem);
        }
      }
      MenuAppModel.INSTANCE.normalizeAppMap(localMap, MenuAppModel.MENU_CUSTOM_NORMALIZER, false);
      localObject3 = new ArrayList();
      localObject4 = localMap.values().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localAppItem = (AppItem)((Iterator)localObject4).next();
        if (localAppItem.mDirty)
        {
          LauncherSettings.AppOrderModify localAppOrderModify = new LauncherSettings.AppOrderModify();
          if (((Set)localObject1).contains(localAppItem)) {
            if (localAppItem.mType == BaseItem.Type.MENU_FOLDER)
            {
              localAppOrderModify.action = 0;
              label1173:
              localAppOrderModify.id = localAppItem.mId;
              if (localAppItem.mFolder == null) {
                break label1323;
              }
            }
          }
          label1323:
          for (l1 = localAppItem.mFolder.mId;; l1 = -1L)
          {
            localAppOrderModify.folderId = l1;
            localAppOrderModify.screen = localAppItem.mScreen;
            localAppOrderModify.cell = localAppItem.mCell;
            localAppOrderModify.hidden = localAppItem.mHidden;
            localAppOrderModify.title = localAppItem.mTitle;
            localAppOrderModify.secret = localAppItem.mSecretItem;
            localAppItem.mDirty = false;
            ((List)localObject3).add(localAppOrderModify);
            break;
            localAppOrderModify.action = 3;
            localAppOrderModify.component = localAppItem.mComponentName;
            break label1173;
            if (localAppItem.mType == BaseItem.Type.MENU_APP) {}
            for (i = 4;; i = 1)
            {
              localAppOrderModify.action = i;
              break;
            }
          }
        }
      }
      localObject1 = localMap;
      if (!((List)localObject3).isEmpty())
      {
        LauncherModel.updateAppItems(this.mLauncherApp, (List)localObject3);
        localObject1 = localMap;
      }
    }
  }
  
  void refreshAllApps()
  {
    long l1 = SystemClock.uptimeMillis();
    ArrayList localArrayList = new ArrayList();
    this.mAbortLoader = false;
    Iterator localIterator = this.mApps.values().iterator();
    AppItem localAppItem;
    Object localObject;
    if (localIterator.hasNext())
    {
      localAppItem = (AppItem)localIterator.next();
      if ((localAppItem.mIconResId != 0) || (localAppItem.mTitleResId != 0))
      {
        this.titleAndIcon.mIcon = localAppItem.mIconBitmap;
        this.titleAndIcon.mIconResId = localAppItem.mIconResId;
        localObject = this.titleAndIcon;
        String str = localAppItem.mTitle;
        ((PkgResCache.TitleIconInfo)localObject).mTitle = str;
        this.titleAndIcon.mTitleResId = localAppItem.mTitleResId;
        this.mPkgResCache.refreshTitleAndIcon(localAppItem.mComponentName, this.titleAndIcon);
        localAppItem.mIconBitmap = this.titleAndIcon.mIcon;
        localAppItem.mIconShadowBitmap = null;
        localAppItem.mTitle = this.titleAndIcon.mTitle;
        if (str == null) {
          break label329;
        }
        if (str.equals(localAppItem.mTitle)) {
          break label324;
        }
      }
    }
    label324:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new LauncherSettings.AppOrderModify();
        ((LauncherSettings.AppOrderModify)localObject).action = 2;
        ((LauncherSettings.AppOrderModify)localObject).id = localAppItem.mId;
        ((LauncherSettings.AppOrderModify)localObject).title = localAppItem.mTitle;
        localArrayList.add(localObject);
      }
      if (!this.mAbortLoader) {
        break;
      }
      if ((!this.mAbortLoader) && (!localArrayList.isEmpty())) {
        LauncherModel.updateAppItems(this.mLauncherApp, localArrayList);
      }
      long l2 = SystemClock.uptimeMillis();
      Log.d("MenuAppLoader", "refreshAllApps; aborted: " + this.mAbortLoader + ", refresh time: " + (l2 - l1));
      return;
    }
    label329:
    if (localAppItem.mTitle != null) {}
    for (i = 1;; i = 0) {
      break;
    }
  }
  
  public void removePackage(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mApps.values().iterator();
    while (localIterator.hasNext())
    {
      AppItem localAppItem = (AppItem)localIterator.next();
      if (paramString.equals(localAppItem.mComponentName.getPackageName()))
      {
        this.removed.add(localAppItem);
        localIterator.remove();
        LauncherSettings.AppOrderModify localAppOrderModify = new LauncherSettings.AppOrderModify();
        localAppOrderModify.action = 5;
        localAppOrderModify.id = localAppItem.mId;
        localArrayList.add(localAppOrderModify);
      }
    }
    if (!localArrayList.isEmpty()) {
      LauncherModel.updateAppItems(this.mLauncherApp, localArrayList);
    }
  }
  
  List<AppItem> updateBadgeCounts(Map<ComponentName, Integer> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      AppItem localAppItem = (AppItem)this.mApps.get(localEntry.getKey());
      if (localAppItem != null)
      {
        int i = ((Integer)localEntry.getValue()).intValue();
        if (localAppItem.mBadgeCount != i)
        {
          localAppItem.mBadgeCount = i;
          localArrayList.add(localAppItem);
        }
      }
    }
    return localArrayList;
  }
  
  public void updatePackage(String paramString)
  {
    List localList = findActivitiesForPackage(paramString);
    if (localList.isEmpty())
    {
      removePackage(paramString);
      return;
    }
    updatePackageActivities(paramString, localList);
  }
  
  void updatePackageAvailability(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = findActivitiesForPackage(paramString);
      if (!((List)localObject).isEmpty()) {
        updatePackageActivities(paramString, (List)localObject);
      }
    }
    for (;;)
    {
      return;
      localObject = this.mApps.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppItem localAppItem = (AppItem)((Iterator)localObject).next();
        if ((!localAppItem.mUnavailable) && (paramString.equals(localAppItem.mComponentName.getPackageName())))
        {
          localAppItem.mUnavailable = true;
          localAppItem.mIconBitmap = this.mPkgResCache.getUnavailableIcon();
          localAppItem.mIconShadowBitmap = null;
          this.modified.add(localAppItem);
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/MenuAppLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */