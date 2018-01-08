package com.android.launcher2;

import android.app.admin.DevicePolicyManager;
import android.app.enterprise.ApplicationPolicy;
import android.app.enterprise.EnterpriseDeviceManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemProperties;
import android.util.Log;
import com.sec.android.app.CscFeature;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public enum MenuAppModel
{
  private static final boolean DEBUG;
  public static final List<String> KNOX_DEFAULT_APP;
  public static final Normalizer<AppItem> MENU_ALPHA_NORMALIZER;
  public static final Normalizer<AppItem> MENU_CUSTOM_NORMALIZER;
  public static final Comparator<AppItem> MENU_INSTALL_COMPARATOR_ALPHABETICAL;
  public static final Comparator<AppItem> MENU_INSTALL_COMPARATOR_CUSTOM;
  private static final String TAG = "MenuAppModel";
  private static int mCustomMenuSecretPageCnt;
  private static Collator sCollator;
  private Map<Long, AppItem> mAppDiabledItems;
  private Map<Long, AppItem> mAppItems;
  private LauncherApplication mApplication;
  private List<AvailableWidget> mAvailableWidgets = new ArrayList();
  private boolean mCanUninstallApps;
  private AppFolderItem mFolderToDelete;
  private List<AppFolderItem> mFoldersAdded;
  private List<AppFolderItem> mFoldersRemoved;
  private ArrayList<String> mFrontApps;
  private boolean mHasHiddenItems;
  private boolean mHasPreSecretWidget = false;
  private boolean mInEditMode;
  private boolean mIsFinishFrontAppsLoader = false;
  private boolean mIsSafeMode = false;
  private int mMaxItemsPerPage;
  private Normalizer<AppItem> mNormalizer;
  private List<AppItem> mSecretMoveItems;
  private ArrayList<String> mSprintFeaturedFolderPackages = new ArrayList();
  private ArrayList<String> mSprintFolderPackages = new ArrayList();
  private boolean mSuspendGets;
  private List<AppItem> mTopLevelItems;
  
  static
  {
    $VALUES = new MenuAppModel[] { INSTANCE };
    if (SystemProperties.getInt("ro.debuggable", 0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      DEBUG = bool;
      sCollator = Collator.getInstance();
      mCustomMenuSecretPageCnt = 0;
      KNOX_DEFAULT_APP = Arrays.asList(new String[] { "com.sec.knox.shortcutsms", "com.sec.knox.containeragent2", "com.sec.knox.switcher" });
      MENU_CUSTOM_NORMALIZER = new Normalizer()
      {
        public final int compare(AppItem paramAnonymousAppItem1, AppItem paramAnonymousAppItem2)
        {
          int j;
          if ((paramAnonymousAppItem1.mScreen != -1) && (paramAnonymousAppItem2.mScreen != -1))
          {
            j = MenuAppModel.integerCompare(paramAnonymousAppItem1.mScreen, paramAnonymousAppItem2.mScreen);
            i = j;
            if (j == 0) {
              i = MenuAppModel.integerCompare(paramAnonymousAppItem1.mCell, paramAnonymousAppItem2.mCell);
            }
            j = i;
            if (i == 0)
            {
              if ((paramAnonymousAppItem1.mTitle == null) || (paramAnonymousAppItem2.mTitle == null)) {
                break label185;
              }
              i = MenuAppModel.sCollator.compare(paramAnonymousAppItem1.mTitle, paramAnonymousAppItem2.mTitle);
              label85:
              j = i;
              if (i == 0)
              {
                if ((paramAnonymousAppItem1.mComponentName == null) || (paramAnonymousAppItem2.mComponentName == null)) {
                  break label213;
                }
                i = paramAnonymousAppItem1.mComponentName.compareTo(paramAnonymousAppItem2.mComponentName);
              }
            }
          }
          label185:
          label213:
          while (paramAnonymousAppItem1.mComponentName == paramAnonymousAppItem2.mComponentName)
          {
            j = i;
            if (i == 0) {
              j = MenuAppModel.longCompare(paramAnonymousAppItem1.mId, paramAnonymousAppItem2.mId);
            }
            return j;
            if (paramAnonymousAppItem1.mScreen == paramAnonymousAppItem2.mScreen)
            {
              i = MenuAppModel.longCompare(paramAnonymousAppItem1.mCreateTime, paramAnonymousAppItem2.mCreateTime);
              break;
            }
            if (paramAnonymousAppItem1.mScreen == -1) {}
            for (i = 1;; i = -1) {
              break;
            }
            if (paramAnonymousAppItem1.mTitle == paramAnonymousAppItem2.mTitle) {
              break label85;
            }
            if (paramAnonymousAppItem1.mTitle == null) {}
            for (i = -1;; i = 1) {
              break;
            }
          }
          if (paramAnonymousAppItem1.mComponentName == null) {}
          for (int i = -1;; i = 1) {
            break;
          }
        }
        
        public void normalize(List<AppItem> paramAnonymousList, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          Collections.sort(paramAnonymousList, this);
          int j = 0;
          int i = 0;
          int m = 0;
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            AppItem localAppItem = (AppItem)paramAnonymousList.next();
            if (!localAppItem.mSecretItem)
            {
              int i2 = localAppItem.mScreen;
              int k = m;
              int i1 = i;
              int n = j;
              if (i2 != m)
              {
                k = m;
                i1 = i;
                n = j;
                if (i2 != -1)
                {
                  k = j;
                  if (paramAnonymousBoolean) {
                    k = j + (i2 - m - 1);
                  }
                  j = i;
                  m = k;
                  if (i != 0)
                  {
                    m = k + 1;
                    j = 0;
                  }
                  k = i2;
                  n = m;
                  i1 = j;
                }
              }
              if ((i2 != n) || (localAppItem.mCell != i1))
              {
                localAppItem.mDirty = true;
                localAppItem.mScreen = n;
                localAppItem.mCell = i1;
              }
              i1 += 1;
              m = k;
              i = i1;
              j = n;
              if (i1 == paramAnonymousInt)
              {
                j = n + 1;
                i = 0;
                m = k;
              }
            }
          }
        }
        
        public String toString()
        {
          return "MenuAppModel.MENU_CUSTOM_NORMALIZER";
        }
      };
      MENU_ALPHA_NORMALIZER = new Normalizer()
      {
        public final int compare(AppItem paramAnonymousAppItem1, AppItem paramAnonymousAppItem2)
        {
          int i = 0;
          int j;
          if ((paramAnonymousAppItem1.mTitle != null) && (paramAnonymousAppItem2.mTitle != null))
          {
            i = MenuAppModel.sCollator.compare(paramAnonymousAppItem1.mTitle, paramAnonymousAppItem2.mTitle);
            j = i;
            if (i == 0)
            {
              if ((paramAnonymousAppItem1.mComponentName == null) || (paramAnonymousAppItem2.mComponentName == null)) {
                break label118;
              }
              i = MenuAppModel.sCollator.compare(paramAnonymousAppItem1.mTitle, paramAnonymousAppItem2.mTitle);
            }
          }
          label118:
          while (paramAnonymousAppItem1.mComponentName == paramAnonymousAppItem2.mComponentName)
          {
            j = i;
            if (i == 0) {
              j = MenuAppModel.longCompare(paramAnonymousAppItem1.mId, paramAnonymousAppItem2.mId);
            }
            return j;
            if (paramAnonymousAppItem1.mTitle == paramAnonymousAppItem2.mTitle) {
              break;
            }
            if (paramAnonymousAppItem1.mTitle == null) {}
            for (i = -1;; i = 1) {
              break;
            }
          }
          if (paramAnonymousAppItem1.mComponentName == null) {}
          for (i = -1;; i = 1) {
            break;
          }
        }
        
        public void normalize(List<AppItem> paramAnonymousList, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          Collections.sort(paramAnonymousList, this);
        }
        
        public String toString()
        {
          return "MenuAppModel.MENU_ALPHA_NORMALIZER";
        }
      };
      MENU_INSTALL_COMPARATOR_CUSTOM = new Comparator()
      {
        public final int compare(AppItem paramAnonymousAppItem1, AppItem paramAnonymousAppItem2)
        {
          int i = MenuAppModel.longCompare(paramAnonymousAppItem1.mCreateTime, paramAnonymousAppItem2.mCreateTime);
          int j = i;
          if (i == 0)
          {
            if ((paramAnonymousAppItem1.mTitle == null) || (paramAnonymousAppItem2.mTitle == null)) {
              break label104;
            }
            i = MenuAppModel.sCollator.compare(paramAnonymousAppItem1.mTitle, paramAnonymousAppItem2.mTitle);
            j = i;
            if (i == 0)
            {
              if ((paramAnonymousAppItem1.mComponentName == null) || (paramAnonymousAppItem2.mComponentName == null)) {
                break label132;
              }
              i = paramAnonymousAppItem1.mComponentName.compareTo(paramAnonymousAppItem2.mComponentName);
            }
          }
          label104:
          label132:
          while (paramAnonymousAppItem1.mComponentName == paramAnonymousAppItem2.mComponentName)
          {
            j = i;
            if (i == 0) {
              j = MenuAppModel.longCompare(paramAnonymousAppItem1.mId, paramAnonymousAppItem2.mId);
            }
            return j;
            if (paramAnonymousAppItem1.mTitle == paramAnonymousAppItem2.mTitle) {
              break;
            }
            if (paramAnonymousAppItem1.mTitle == null) {}
            for (i = -1;; i = 1) {
              break;
            }
          }
          if (paramAnonymousAppItem1.mComponentName == null) {}
          for (i = -1;; i = 1) {
            break;
          }
        }
      };
      MENU_INSTALL_COMPARATOR_ALPHABETICAL = new Comparator()
      {
        public final int compare(AppItem paramAnonymousAppItem1, AppItem paramAnonymousAppItem2)
        {
          int j = 0;
          int i = 0;
          if (0 == 0)
          {
            if ((paramAnonymousAppItem1.mTitle == null) || (paramAnonymousAppItem2.mTitle == null)) {
              break label94;
            }
            i = MenuAppModel.sCollator.compare(paramAnonymousAppItem1.mTitle, paramAnonymousAppItem2.mTitle);
            j = i;
            if (i == 0)
            {
              if ((paramAnonymousAppItem1.mComponentName == null) || (paramAnonymousAppItem2.mComponentName == null)) {
                break label122;
              }
              i = paramAnonymousAppItem1.mComponentName.compareTo(paramAnonymousAppItem2.mComponentName);
            }
          }
          label94:
          label122:
          while (paramAnonymousAppItem1.mComponentName == paramAnonymousAppItem2.mComponentName)
          {
            j = i;
            if (i == 0) {
              j = MenuAppModel.longCompare(paramAnonymousAppItem1.mId, paramAnonymousAppItem2.mId);
            }
            return j;
            if (paramAnonymousAppItem1.mTitle == paramAnonymousAppItem2.mTitle) {
              break;
            }
            if (paramAnonymousAppItem1.mTitle == null) {}
            for (i = -1;; i = 1) {
              break;
            }
          }
          if (paramAnonymousAppItem1.mComponentName == null) {}
          for (i = -1;; i = 1) {
            break;
          }
        }
      };
      return;
    }
  }
  
  private MenuAppModel() {}
  
  private boolean addItemtoFolder(AppItem paramAppItem, long paramLong)
  {
    Object localObject = (AppFolderItem)this.mAppItems.get(Long.valueOf(paramLong));
    if (localObject != null)
    {
      ((AppFolderItem)localObject).addItem(paramAppItem);
      localObject = new LauncherSettings.AppOrderModify();
      ((LauncherSettings.AppOrderModify)localObject).action = 4;
      ((LauncherSettings.AppOrderModify)localObject).folderId = paramLong;
      ((LauncherSettings.AppOrderModify)localObject).hidden = paramAppItem.mHidden;
      ((LauncherSettings.AppOrderModify)localObject).id = paramAppItem.mId;
      ((LauncherSettings.AppOrderModify)localObject).screen = paramAppItem.mScreen;
      ((LauncherSettings.AppOrderModify)localObject).title = paramAppItem.mTitle;
      ((LauncherSettings.AppOrderModify)localObject).id = paramAppItem.mId;
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject);
      LauncherModel.updateAppItems(this.mApplication, localArrayList);
      if (DEBUG) {
        Log.d("MenuAppModel", "addItemtoFolder :: ADDED:" + paramAppItem.getPackageName());
      }
      return true;
    }
    return false;
  }
  
  private void checkEditMode(boolean paramBoolean)
  {
    if (this.mInEditMode != paramBoolean) {
      throw new IllegalStateException("Method requires mInEditMode to be " + paramBoolean);
    }
  }
  
  private List<ResolveInfo> findActivitiesForPackage(String paramString)
  {
    Object localObject = new Intent("android.intent.action.MAIN", null);
    ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
    ((Intent)localObject).setPackage(paramString);
    localObject = this.mApplication.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = Collections.emptyList();
    }
    return paramString;
  }
  
  private static int integerCompare(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramInt1 > paramInt2) {
      i = 1;
    }
    while (paramInt1 >= paramInt2) {
      return i;
    }
    return -1;
  }
  
  private boolean isKnoxDefaultShortcutApp(BaseItem paramBaseItem)
  {
    if (KNOX_DEFAULT_APP.contains(paramBaseItem.getPackageName()))
    {
      Log.d("MenuAppModel", "item.getPackageName() : " + paramBaseItem.getPackageName());
      return true;
    }
    return false;
  }
  
  private boolean isSystemSignature(AppItem paramAppItem)
  {
    if (paramAppItem == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramAppItem = this.mApplication.getPackageManager().getPackageInfo(paramAppItem.getPackageName(), 64);
        PackageInfo localPackageInfo = this.mApplication.getPackageManager().getPackageInfo("android", 64);
        if ((paramAppItem != null) && (paramAppItem.signatures != null))
        {
          boolean bool = localPackageInfo.signatures[0].equals(paramAppItem.signatures[0]);
          if (bool) {
            return true;
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramAppItem) {}
    }
    return false;
  }
  
  private static int longCompare(long paramLong1, long paramLong2)
  {
    int i = 0;
    if (paramLong1 > paramLong2) {
      i = 1;
    }
    while (paramLong1 >= paramLong2) {
      return i;
    }
    return -1;
  }
  
  private void setModelFlags()
  {
    this.mCanUninstallApps = false;
    this.mHasHiddenItems = false;
    Iterator localIterator = this.mAppItems.values().iterator();
    for (;;)
    {
      AppItem localAppItem;
      if (localIterator.hasNext())
      {
        localAppItem = (AppItem)localIterator.next();
        if (!localAppItem.mHidden) {
          break label71;
        }
        this.mHasHiddenItems = true;
      }
      while ((this.mCanUninstallApps) && (this.mHasHiddenItems))
      {
        return;
        label71:
        if ((!localAppItem.mSystemApp) && (localAppItem.mType == BaseItem.Type.MENU_APP) && (!localAppItem.mSecretItem)) {
          this.mCanUninstallApps = true;
        }
      }
    }
  }
  
  void appsAddedOrRemoved(List<AppItem> paramList1, List<AppItem> paramList2)
  {
    if (this.mAppItems != null)
    {
      int k = 0;
      int j = 0;
      int i = k;
      if (paramList2 != null)
      {
        i = k;
        if (!paramList2.isEmpty())
        {
          paramList2 = paramList2.iterator();
          i = j;
          while (paramList2.hasNext())
          {
            AppItem localAppItem = (AppItem)paramList2.next();
            if (this.mAppItems.remove(Long.valueOf(localAppItem.mId)) != null)
            {
              if (localAppItem.mFolder != null) {
                localAppItem.mFolder.setToRedrawIcons(true);
              }
              i = 1;
              localAppItem.destroy();
            }
          }
          setModelFlags();
        }
      }
      j = i;
      if (paramList1 != null)
      {
        j = i;
        if (!paramList1.isEmpty())
        {
          paramList1 = paramList1.iterator();
          for (;;)
          {
            j = i;
            if (!paramList1.hasNext()) {
              break;
            }
            paramList2 = (AppItem)paramList1.next();
            this.mAppItems.put(Long.valueOf(paramList2.mId), paramList2);
            if (paramList2.mHidden)
            {
              this.mHasHiddenItems = true;
            }
            else
            {
              if ((!paramList2.mSystemApp) && (paramList2.mType == BaseItem.Type.MENU_APP) && (!paramList2.mSecretItem)) {
                this.mCanUninstallApps = true;
              }
              j = i;
              if (paramList2.mFolder == null) {
                j = 1;
              }
              if (CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension")) {
                checkAndAddAppItemToSprintFolder(paramList2);
              }
              i = j;
              if (this.mInEditMode)
              {
                paramList2.editBegin();
                i = j;
              }
            }
          }
        }
      }
      if (j != 0) {
        invalidateTopLevelItems();
      }
    }
  }
  
  void appsUpdated(List<AppItem> paramList)
  {
    if ((this.mAppItems != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AppItem localAppItem = (AppItem)paramList.next();
        if (localAppItem.mFolder != null) {
          localAppItem.mFolder.setToRedrawIcons(true);
        }
      }
    }
  }
  
  public boolean canDisableable(AppItem paramAppItem)
  {
    boolean bool1 = true;
    Object localObject = (EnterpriseDeviceManager)this.mApplication.getSystemService("enterprise_policy");
    if (localObject != null) {
      bool1 = ((EnterpriseDeviceManager)localObject).getApplicationPolicy().getApplicationUninstallationEnabled(paramAppItem.getPackageName());
    }
    boolean bool2 = false;
    localObject = (DevicePolicyManager)this.mApplication.getSystemService("device_policy");
    if (localObject != null) {
      bool2 = ((DevicePolicyManager)localObject).packageHasActiveAdmins(paramAppItem.getPackageName());
    }
    return ((paramAppItem instanceof AppItem)) && (paramAppItem.mSystemApp) && (!Launcher.mNonDisableItems.contains(paramAppItem.getPackageName())) && (Launcher.isSystemAppDisable) && (!isSystemSignature(paramAppItem)) && (paramAppItem.mType != BaseItem.Type.MENU_FOLDER) && (bool1) && (!bool2);
  }
  
  public boolean canMoveToPrivate(AppItem paramAppItem)
  {
    return (!paramAppItem.mSecretItem) && (!paramAppItem.mSystemApp) && (!BaseItem.isFolder(paramAppItem)) && (!Launcher.mRemovableAppItems.contains(paramAppItem.getPackageName()));
  }
  
  public boolean canMoveToSecretApps()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mAppItems != null)
    {
      Iterator localIterator = this.mAppItems.values().iterator();
      do
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!canMoveToPrivate((AppItem)localIterator.next()));
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean canRemovable(AppItem paramAppItem)
  {
    return (canUninstallable(paramAppItem)) || (canDisableable(paramAppItem));
  }
  
  public boolean canUninstallApps()
  {
    return (this.mAppItems != null) && (!this.mSuspendGets) && (this.mCanUninstallApps);
  }
  
  public boolean canUninstallable(AppItem paramAppItem)
  {
    return ((paramAppItem instanceof AppItem)) && (!paramAppItem.mSystemApp) && (paramAppItem.mType != BaseItem.Type.MENU_FOLDER) && (!isKnoxDefaultShortcutApp(paramAppItem));
  }
  
  public void changeFolderColor(AppFolderItem paramAppFolderItem)
  {
    if (paramAppFolderItem.mId != -1L)
    {
      LauncherSettings.AppOrderModify localAppOrderModify = new LauncherSettings.AppOrderModify();
      localAppOrderModify.action = 6;
      localAppOrderModify.id = paramAppFolderItem.mId;
      localAppOrderModify.color = paramAppFolderItem.mColor;
      paramAppFolderItem = new ArrayList(1);
      paramAppFolderItem.add(localAppOrderModify);
      LauncherModel.updateAppItems(this.mApplication, paramAppFolderItem);
    }
  }
  
  public void changeFolderName(AppFolderItem paramAppFolderItem)
  {
    if (paramAppFolderItem.mId != -1L)
    {
      LauncherSettings.AppOrderModify localAppOrderModify = new LauncherSettings.AppOrderModify();
      localAppOrderModify.action = 2;
      localAppOrderModify.id = paramAppFolderItem.mId;
      localAppOrderModify.title = paramAppFolderItem.mTitle;
      paramAppFolderItem = new ArrayList(1);
      paramAppFolderItem.add(localAppOrderModify);
      LauncherModel.updateAppItems(this.mApplication, paramAppFolderItem);
    }
  }
  
  boolean checkAndAddAppItemToSprintFolder(AppItem paramAppItem)
  {
    boolean bool2;
    if ((this.mSprintFolderPackages.size() == 0) && (this.mSprintFeaturedFolderPackages.size() == 0))
    {
      bool2 = false;
      return bool2;
    }
    LauncherProvider.DatabaseHelper localDatabaseHelper = this.mApplication.getLauncherProvider().getDatabaseHelper();
    String str = paramAppItem.getPackageName();
    boolean bool1 = false;
    Iterator localIterator = this.mSprintFeaturedFolderPackages.iterator();
    while (localIterator.hasNext()) {
      if ((((String)localIterator.next()).equals(str)) && (addItemtoFolder(paramAppItem, localDatabaseHelper.getSprintFolderID(true)))) {
        bool1 = true;
      }
    }
    if (bool1) {
      this.mSprintFeaturedFolderPackages.remove(str);
    }
    for (;;)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      bool2 = bool1;
      if (!DEBUG) {
        break;
      }
      Log.i("MenuAppModel", "checkAndAddAppItemToSprintFolder :: unable to add item to folder : " + str);
      return bool1;
      localIterator = this.mSprintFolderPackages.iterator();
      for (bool2 = bool1; localIterator.hasNext(); bool2 = true) {
        label168:
        if ((!((String)localIterator.next()).equals(str)) || (!addItemtoFolder(paramAppItem, localDatabaseHelper.getSprintFolderID(false)))) {
          break label168;
        }
      }
      bool1 = bool2;
      if (bool2)
      {
        this.mSprintFolderPackages.remove(str);
        bool1 = bool2;
      }
    }
  }
  
  public AppFolderItem editAddFolder()
  {
    checkEditMode(true);
    AppFolderItem localAppFolderItem = new AppFolderItem();
    localAppFolderItem.mId = this.mApplication.getLauncherProvider().generateNewMenuId();
    if ((LauncherApplication.isMenuIconSizeChanged()) && (this.mApplication.getPkgResCacheForMenu() != null)) {}
    for (localAppFolderItem.mIconBitmap = this.mApplication.getPkgResCacheForMenu().getFolderIcon();; localAppFolderItem.mIconBitmap = this.mApplication.getPkgResCache().getFolderIcon())
    {
      localAppFolderItem.mDirty = true;
      localAppFolderItem.editBegin();
      if (this.mFoldersAdded == null) {
        this.mFoldersAdded = new ArrayList();
      }
      this.mFoldersAdded.add(localAppFolderItem);
      if (this.mAppItems != null) {
        this.mAppItems.put(Long.valueOf(localAppFolderItem.mId), localAppFolderItem);
      }
      invalidateTopLevelItems();
      return localAppFolderItem;
    }
  }
  
  public void editBegin()
  {
    if (!this.mInEditMode)
    {
      if (this.mAppItems != null)
      {
        Iterator localIterator = this.mAppItems.values().iterator();
        while (localIterator.hasNext()) {
          ((AppItem)localIterator.next()).editBegin();
        }
        this.mFolderToDelete = null;
      }
      this.mInEditMode = true;
    }
  }
  
  public void editCommit()
  {
    if (this.mInEditMode)
    {
      if (this.mAppItems != null)
      {
        this.mHasHiddenItems = false;
        this.mCanUninstallApps = false;
        Object localObject1 = this.mAppItems.values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AppItem)((Iterator)localObject1).next();
          ((AppItem)localObject2).editCommit();
          if (((AppItem)localObject2).mHidden) {
            this.mHasHiddenItems = true;
          } else if ((!((AppItem)localObject2).mSystemApp) && (((AppItem)localObject2).mType == BaseItem.Type.MENU_APP) && (!((AppItem)localObject2).mSecretItem)) {
            this.mCanUninstallApps = true;
          }
        }
        normalizeModel(false);
        localObject1 = new ArrayList();
        Object localObject3;
        LauncherSettings.AppOrderModify localAppOrderModify;
        if (this.mFoldersAdded != null)
        {
          localObject2 = this.mFoldersAdded.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AppFolderItem)((Iterator)localObject2).next();
            localAppOrderModify = new LauncherSettings.AppOrderModify();
            localAppOrderModify.action = 0;
            localAppOrderModify.id = ((AppFolderItem)localObject3).mId;
            localAppOrderModify.screen = ((AppFolderItem)localObject3).mScreen;
            localAppOrderModify.cell = ((AppFolderItem)localObject3).mCell;
            localAppOrderModify.title = ((AppFolderItem)localObject3).mTitle;
            localAppOrderModify.secret = ((AppFolderItem)localObject3).mSecretItem;
            localAppOrderModify.color = ((AppFolderItem)localObject3).mColor;
            ((List)localObject1).add(localAppOrderModify);
            ((AppFolderItem)localObject3).mDirty = false;
          }
          this.mFoldersAdded = null;
        }
        Object localObject2 = this.mAppItems.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (AppItem)((Iterator)localObject2).next();
          if (((AppItem)localObject3).mDirty)
          {
            localAppOrderModify = new LauncherSettings.AppOrderModify();
            if (((AppItem)localObject3).mType == BaseItem.Type.MENU_FOLDER)
            {
              localAppOrderModify.action = 1;
              localAppOrderModify.id = ((AppItem)localObject3).mId;
              localAppOrderModify.screen = ((AppItem)localObject3).mScreen;
              localAppOrderModify.cell = ((AppItem)localObject3).mCell;
              localAppOrderModify.title = ((AppItem)localObject3).mTitle;
              localAppOrderModify.secret = ((AppItem)localObject3).mSecretItem;
              ((List)localObject1).add(localAppOrderModify);
              ((AppItem)localObject3).mDirty = false;
            }
            else
            {
              localAppOrderModify.action = 4;
              if (((AppItem)localObject3).mFolder != null) {}
              for (long l = ((AppItem)localObject3).mFolder.mId;; l = -1L)
              {
                localAppOrderModify.folderId = l;
                localAppOrderModify.hidden = ((AppItem)localObject3).mHidden;
                break;
              }
            }
          }
        }
        if (this.mFoldersRemoved != null)
        {
          localObject2 = this.mFoldersRemoved.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (AppFolderItem)((Iterator)localObject2).next();
            ((AppFolderItem)localObject3).destroy();
            localAppOrderModify = new LauncherSettings.AppOrderModify();
            localAppOrderModify.action = 5;
            localAppOrderModify.id = ((AppFolderItem)localObject3).mId;
            ((List)localObject1).add(localAppOrderModify);
          }
          this.mFoldersRemoved = null;
        }
        this.mFolderToDelete = null;
        if (!((List)localObject1).isEmpty()) {
          LauncherModel.updateAppItems(this.mApplication, (List)localObject1);
        }
      }
      this.mInEditMode = false;
    }
  }
  
  public void editInsertItemOnNewScreen(AppItem paramAppItem, int paramInt)
  {
    checkEditMode(true);
    if (this.mAppItems != null)
    {
      paramAppItem.removeFromFolder();
      paramAppItem.mScreen = paramInt;
      paramAppItem.mCell = 0;
      Iterator localIterator = this.mAppItems.values().iterator();
      while (localIterator.hasNext())
      {
        AppItem localAppItem = (AppItem)localIterator.next();
        if ((localAppItem != paramAppItem) && (localAppItem.mScreen >= paramInt)) {
          localAppItem.mScreen += 1;
        }
      }
      invalidateTopLevelItems();
    }
  }
  
  public boolean editIsDirty(boolean paramBoolean)
  {
    boolean bool2 = true;
    checkEditMode(true);
    if (this.mFoldersAdded != null)
    {
      bool1 = bool2;
      if (!this.mFoldersAdded.isEmpty()) {}
    }
    else
    {
      if ((this.mFoldersRemoved == null) || (this.mFoldersRemoved.isEmpty())) {
        break label113;
      }
    }
    label113:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (this.mAppItems != null)
        {
          Iterator localIterator = this.mAppItems.values().iterator();
          do
          {
            bool2 = bool1;
            if (!localIterator.hasNext()) {
              break;
            }
          } while (!((AppItem)localIterator.next()).editIsDirty(paramBoolean));
          bool2 = true;
        }
      }
      return bool2;
    }
  }
  
  public void editRemoveFolder()
  {
    checkEditMode(true);
    AppFolderItem localAppFolderItem = this.mFolderToDelete;
    if ((localAppFolderItem == null) || (this.mAppItems == null) || (this.mAppItems.remove(Long.valueOf(localAppFolderItem.mId)) != localAppFolderItem)) {
      throw new IllegalStateException("unknown folder or folder already removed");
    }
    if ((this.mFoldersAdded != null) && (this.mFoldersAdded.remove(localAppFolderItem))) {
      localAppFolderItem.destroy();
    }
    for (;;)
    {
      this.mFolderToDelete = null;
      invalidateTopLevelItems();
      return;
      if (this.mFoldersRemoved == null) {
        this.mFoldersRemoved = new ArrayList();
      }
      this.mFoldersRemoved.add(localAppFolderItem);
      localAppFolderItem.editDestroy();
    }
  }
  
  public void editRevert()
  {
    if (this.mInEditMode)
    {
      if (this.mAppItems != null)
      {
        AppFolderItem localAppFolderItem;
        if (this.mFoldersAdded != null)
        {
          localIterator = this.mFoldersAdded.iterator();
          while (localIterator.hasNext())
          {
            localAppFolderItem = (AppFolderItem)localIterator.next();
            this.mAppItems.remove(Long.valueOf(localAppFolderItem.mId));
          }
          this.mFoldersAdded = null;
        }
        if (this.mFoldersRemoved != null)
        {
          localIterator = this.mFoldersRemoved.iterator();
          while (localIterator.hasNext())
          {
            localAppFolderItem = (AppFolderItem)localIterator.next();
            this.mAppItems.put(Long.valueOf(localAppFolderItem.mId), localAppFolderItem);
          }
          this.mFoldersRemoved = null;
        }
        Iterator localIterator = this.mAppItems.values().iterator();
        while (localIterator.hasNext()) {
          ((AppItem)localIterator.next()).editRevert();
        }
        this.mFolderToDelete = null;
        normalizeModel(false);
      }
      this.mInEditMode = false;
    }
  }
  
  public AppItem findDisabledItemById(Long paramLong)
  {
    AppItem localAppItem = null;
    if (this.mAppDiabledItems != null) {
      localAppItem = (AppItem)this.mAppDiabledItems.get(Long.valueOf(paramLong.longValue()));
    }
    return localAppItem;
  }
  
  public AppItem findItemById(long paramLong)
  {
    AppItem localAppItem = null;
    if (this.mAppItems != null) {
      localAppItem = (AppItem)this.mAppItems.get(Long.valueOf(paramLong));
    }
    return localAppItem;
  }
  
  public Map<Long, AppItem> getAppItems()
  {
    return this.mAppItems;
  }
  
  public List<AvailableWidget> getAvailableWidgets()
  {
    return this.mAvailableWidgets;
  }
  
  public Comparator<AppItem> getCurrentComparator()
  {
    if (this.mNormalizer != null) {
      return this.mNormalizer;
    }
    return MENU_CUSTOM_NORMALIZER;
  }
  
  public int getCustomMenuSecretPageCnt()
  {
    return mCustomMenuSecretPageCnt;
  }
  
  public List<AppItem> getDisabledAppItemsList()
  {
    if ((this.mAppDiabledItems != null) && (this.mAppDiabledItems.size() > 0)) {
      return normalizeAppMap(this.mAppDiabledItems, MENU_ALPHA_NORMALIZER, false);
    }
    return getDisabledAppList();
  }
  
  public List<AppItem> getDisabledAppList()
  {
    if (this.mAppDiabledItems != null) {
      this.mAppDiabledItems.clear();
    }
    PackageManager localPackageManager;
    Object localObject4;
    ApplicationInfo localApplicationInfo;
    Object localObject6;
    int j;
    Object localObject5;
    for (;;)
    {
      localObject1 = null;
      localPackageManager = this.mApplication.getPackageManager();
      List localList = localPackageManager.getInstalledApplications(512);
      localObject4 = Long.valueOf(1L);
      int i = 0;
      for (;;)
      {
        if (i >= localList.size()) {
          break label588;
        }
        localApplicationInfo = (ApplicationInfo)localList.get(i);
        localObject6 = findActivitiesForPackage(localApplicationInfo.packageName);
        try
        {
          j = localPackageManager.getApplicationEnabledSetting(localApplicationInfo.packageName);
          localObject2 = localObject4;
          localObject5 = localObject1;
          if (((List)localObject6).isEmpty())
          {
            localObject2 = localObject4;
            localObject5 = localObject1;
            if (!localApplicationInfo.enabled)
            {
              localObject2 = localObject4;
              localObject5 = localObject1;
              if (j != 2)
              {
                localObject2 = localObject4;
                localObject5 = localObject1;
                if (!localApplicationInfo.packageName.equals("com.sec.android.emergencylauncher"))
                {
                  if (!KNOX_DEFAULT_APP.contains(localApplicationInfo.packageName)) {
                    break;
                  }
                  localObject5 = localObject1;
                  localObject2 = localObject4;
                }
              }
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            Object localObject2;
            Log.d("MenuAppModel", "" + localIllegalArgumentException);
            localObject3 = localObject4;
            localObject5 = localObject1;
          }
          localObject6 = localPackageManager.queryIntentActivities(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").setPackage(localApplicationInfo.packageName), 512).iterator();
        }
        i += 1;
        localObject4 = localObject2;
        localObject1 = localObject5;
      }
      this.mAppDiabledItems = new HashMap();
    }
    ResolveInfo localResolveInfo;
    do
    {
      localObject3 = localObject4;
      localObject5 = localObject1;
      if (!((Iterator)localObject6).hasNext()) {
        break;
      }
      localResolveInfo = (ResolveInfo)((Iterator)localObject6).next();
      localObject3 = new ComponentName(localResolveInfo.activityInfo.packageName, localResolveInfo.activityInfo.name);
      j = localPackageManager.getComponentEnabledSetting((ComponentName)localObject3);
    } while ((j != 1) && ((j != 0) || (!localResolveInfo.activityInfo.enabled)));
    AppItem localAppItem = new AppItem((ComponentName)localObject3, false);
    Object localObject3 = localObject1;
    if (this.mApplication.getPkgResCache() != null) {
      localObject3 = localObject1;
    }
    try
    {
      localObject5 = localPackageManager.getResourcesForApplication(localApplicationInfo);
      localObject3 = localObject1;
      localObject1 = this.mApplication.getPkgResCache().loadBitmap((Resources)localObject5, localResolveInfo.getIconResource(), localResolveInfo.activityInfo.name);
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        localObject1 = Utilities.createIconBitmap(localPackageManager.getDefaultActivityIcon(), this.mApplication);
        localObject3 = localObject1;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      ThemeLoader localThemeLoader;
      label585:
      label588:
      for (;;) {}
    }
    Object localObject1 = localObject3;
    if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE)
    {
      localThemeLoader = LauncherApplication.getInst().getThemeLoader();
      localObject1 = localObject3;
      if (!localThemeLoader.isUseDefaultTheme())
      {
        localObject5 = localThemeLoader.loadAppIconBitmap(localResolveInfo.activityInfo.name);
        localObject1 = localObject5;
        if (localObject5 == null) {
          localObject1 = localThemeLoader.load3rdAppIconBitmap((Bitmap)localObject3);
        }
        if (localObject1 != null) {
          break label585;
        }
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      localAppItem.mIconBitmap = ((Bitmap)localObject1);
      localAppItem.mId = ((Long)localObject4).longValue();
      localAppItem.mTitle = ((String)localResolveInfo.loadLabel(localPackageManager));
      this.mAppDiabledItems.put(localObject4, localAppItem);
      localObject4 = Long.valueOf(((Long)localObject4).longValue() + 1L);
      break;
    }
    return normalizeAppMap(this.mAppDiabledItems, MENU_ALPHA_NORMALIZER, false);
  }
  
  public AppFolderItem getFolderToDelete()
  {
    return this.mFolderToDelete;
  }
  
  public List<AppItem> getHiddenApps()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!this.mSuspendGets)
    {
      localObject1 = localObject2;
      if (this.mAppItems != null)
      {
        localObject2 = new ArrayList();
        localObject1 = this.mAppItems.values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          AppItem localAppItem = (AppItem)((Iterator)localObject1).next();
          if (localAppItem.mHidden) {
            ((List)localObject2).add(localAppItem);
          }
        }
        localObject1 = localObject2;
        if (!((List)localObject2).isEmpty())
        {
          MENU_ALPHA_NORMALIZER.normalize((List)localObject2, 0, false);
          localObject1 = localObject2;
        }
      }
    }
    if (DEBUG)
    {
      localObject2 = new StringBuilder().append("getHiddenApps. count: ");
      if (localObject1 != null) {
        break label149;
      }
    }
    label149:
    for (int i = -1;; i = ((List)localObject1).size())
    {
      Log.d("MenuAppModel", i);
      return (List<AppItem>)localObject1;
    }
  }
  
  public List<AppItem> getNormalItems(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!this.mSuspendGets)
    {
      if (this.mTopLevelItems == null) {
        normalizeModel(this.mInEditMode);
      }
      localObject1 = localObject2;
      if (this.mTopLevelItems != null) {
        localObject1 = Collections.unmodifiableList(this.mTopLevelItems);
      }
    }
    localObject2 = null;
    if (localObject1 != null)
    {
      ArrayList localArrayList = new ArrayList(((List)localObject1).size());
      if (paramBoolean)
      {
        int j = getCustomMenuSecretPageCnt();
        i = 0;
        for (;;)
        {
          localObject2 = localArrayList;
          if (i >= ((List)localObject1).size()) {
            break;
          }
          localObject2 = (AppItem)((List)localObject1).get(i);
          if (!((AppItem)localObject2).mSecretItem)
          {
            ((AppItem)localObject2).mScreen -= j;
            localArrayList.add(localObject2);
          }
          i += 1;
        }
      }
      if (getCustomMenuSecretPageCnt() == 1)
      {
        i = 0;
        for (;;)
        {
          localObject2 = localArrayList;
          if (i >= ((List)localObject1).size()) {
            break;
          }
          localObject2 = (AppItem)((List)localObject1).get(i);
          if (!((AppItem)localObject2).mSecretItem)
          {
            ((AppItem)localObject2).mScreen -= 1;
            localArrayList.add(localObject2);
          }
          i += 1;
        }
      }
      int i = 0;
      for (;;)
      {
        localObject2 = localArrayList;
        if (i >= ((List)localObject1).size()) {
          break;
        }
        localObject2 = (AppItem)((List)localObject1).get(i);
        if (!((AppItem)localObject2).mSecretItem) {
          localArrayList.add(localObject2);
        }
        i += 1;
      }
    }
    return (List<AppItem>)localObject2;
  }
  
  public List<AppItem> getSecretItems()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!this.mSuspendGets)
    {
      if (this.mTopLevelItems == null) {
        normalizeModel(this.mInEditMode);
      }
      localObject1 = localObject2;
      if (this.mTopLevelItems != null) {
        localObject1 = Collections.unmodifiableList(this.mTopLevelItems);
      }
    }
    localObject2 = null;
    if (localObject1 != null)
    {
      ArrayList localArrayList = new ArrayList(((List)localObject1).size());
      int i = 0;
      for (;;)
      {
        localObject2 = localArrayList;
        if (i >= ((List)localObject1).size()) {
          break;
        }
        localObject2 = (AppItem)((List)localObject1).get(i);
        if (((AppItem)localObject2).mSecretItem == true) {
          localArrayList.add(localObject2);
        }
        i += 1;
      }
    }
    return (List<AppItem>)localObject2;
  }
  
  public List<AppItem> getTopLevelItems()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!this.mSuspendGets)
    {
      if (this.mTopLevelItems == null) {
        normalizeModel(this.mInEditMode);
      }
      localObject1 = localObject2;
      if (this.mTopLevelItems != null) {
        localObject1 = Collections.unmodifiableList(this.mTopLevelItems);
      }
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0) && (MenuView.ViewType.valueOf(this.mApplication.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getString("MenuView.ViewType", MenuView.ViewType.CUSTOM_GRID.name())) == MenuView.ViewType.ALPHABETIC_GRID))
    {
      if (!this.mIsFinishFrontAppsLoader)
      {
        this.mIsFinishFrontAppsLoader = true;
        this.mFrontApps = this.mApplication.getLauncherProvider().loadFrontApps();
      }
      if ((this.mFrontApps != null) && (this.mFrontApps.size() > 0))
      {
        ArrayList localArrayList = new ArrayList(((List)localObject1).size());
        int i = 0;
        int j;
        if (i < ((List)localObject1).size())
        {
          localObject2 = (AppItem)((List)localObject1).get(i);
          if ((this.mFrontApps != null) && (this.mFrontApps.size() > 0) && (localObject2 != null) && (((AppItem)localObject2).mComponentName != null)) {
            j = 0;
          }
          for (;;)
          {
            if (j < this.mFrontApps.size())
            {
              if (((AppItem)localObject2).mComponentName.getClassName().equals(this.mFrontApps.get(j))) {
                localArrayList.add(localObject2);
              }
            }
            else
            {
              i += 1;
              break;
            }
            j += 1;
          }
        }
        i = 0;
        localObject2 = localArrayList;
        if (i >= ((List)localObject1).size()) {
          break label419;
        }
        localObject2 = (AppItem)((List)localObject1).get(i);
        int m = 0;
        int k = m;
        if (this.mFrontApps != null)
        {
          k = m;
          if (this.mFrontApps.size() > 0)
          {
            k = m;
            if (localObject2 != null)
            {
              k = m;
              if (((AppItem)localObject2).mComponentName != null) {
                j = 0;
              }
            }
          }
        }
        for (;;)
        {
          k = m;
          if (j < this.mFrontApps.size())
          {
            if (((AppItem)localObject2).mComponentName.getClassName().equals(this.mFrontApps.get(j))) {
              k = 1;
            }
          }
          else
          {
            if (k == 0) {
              localArrayList.add(localObject2);
            }
            i += 1;
            break;
          }
          j += 1;
        }
      }
    }
    localObject2 = localObject1;
    label419:
    return (List<AppItem>)localObject2;
  }
  
  public List<AppItem> getUninstallableApps()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!this.mSuspendGets)
    {
      localObject1 = localObject2;
      if (this.mAppItems != null)
      {
        localObject2 = new ArrayList();
        localObject1 = this.mAppItems.values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          AppItem localAppItem = (AppItem)((Iterator)localObject1).next();
          if ((localAppItem.mType == BaseItem.Type.MENU_APP) && (!localAppItem.mSystemApp) && (!localAppItem.mHidden) && ((!this.mIsSafeMode) || (!localAppItem.mUnavailable)) && (!isKnoxDefaultShortcutApp(localAppItem))) {
            ((List)localObject2).add(localAppItem);
          }
        }
        localObject1 = localObject2;
        if (!((List)localObject2).isEmpty())
        {
          if (MenuView.ViewType.valueOf(this.mApplication.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getString("MenuView.ViewType", MenuView.ViewType.CUSTOM_GRID.name())) != MenuView.ViewType.ALPHABETIC_GRID) {
            break label222;
          }
          Collections.sort((List)localObject2, MENU_INSTALL_COMPARATOR_ALPHABETICAL);
          localObject1 = localObject2;
        }
      }
    }
    if (DEBUG)
    {
      localObject2 = new StringBuilder().append("getUninstallableApps. count: ");
      if (localObject1 != null) {
        break label234;
      }
    }
    label222:
    label234:
    for (int i = -1;; i = ((List)localObject1).size())
    {
      Log.d("MenuAppModel", i);
      return (List<AppItem>)localObject1;
      Collections.sort((List)localObject2, MENU_INSTALL_COMPARATOR_CUSTOM);
      localObject1 = localObject2;
      break;
    }
  }
  
  public boolean hasHiddenApps()
  {
    return (this.mAppItems != null) && (!this.mSuspendGets) && (this.mHasHiddenItems);
  }
  
  public boolean hasSecretApps()
  {
    if (this.mAppItems != null)
    {
      Iterator localIterator = this.mAppItems.values().iterator();
      while (localIterator.hasNext()) {
        if (((AppItem)localIterator.next()).mSecretItem) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean hasSecretWidget()
  {
    return (this.mHasPreSecretWidget) || (hasSecretApps());
  }
  
  public void invalidateTopLevelItems()
  {
    this.mTopLevelItems = null;
  }
  
  boolean isDisableAppListEmpty()
  {
    if (this.mAppDiabledItems == null) {
      getDisabledAppList();
    }
    return this.mAppDiabledItems.isEmpty();
  }
  
  public boolean isSecretItem(AppItem paramAppItem)
  {
    return (paramAppItem.mType == BaseItem.Type.MENU_APP) && (paramAppItem.mSecretItem);
  }
  
  public void loadSprintFolderPackages()
  {
    Cursor localCursor = this.mApplication.getLauncherProvider().query(Uri.parse("content://com.sec.android.app.launcher.settings/sprintFolder"), null, null, null, null);
    if (localCursor != null)
    {
      this.mSprintFolderPackages.clear();
      this.mSprintFeaturedFolderPackages.clear();
      Log.i("MenuAppModel", "loadSprintFolderPackages() : Clear packages list on memory");
      while (localCursor.moveToNext()) {
        if (localCursor.getInt(3) == 0) {
          this.mSprintFolderPackages.add(localCursor.getString(1));
        } else {
          this.mSprintFeaturedFolderPackages.add(localCursor.getString(1));
        }
      }
    }
    localCursor.close();
  }
  
  List<AppItem> normalizeAppMap(Map<Long, AppItem> paramMap, Normalizer<AppItem> paramNormalizer, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      AppItem localAppItem = (AppItem)paramMap.next();
      if ((Launcher.sIsSecretModeOn) || (!localAppItem.mSecretItem)) {
        if (localAppItem.mType == BaseItem.Type.MENU_FOLDER)
        {
          localArrayList.add(localAppItem);
          ((AppFolderItem)localAppItem).normalize(paramNormalizer);
        }
        else if ((localAppItem.mFolder == null) && (!localAppItem.mHidden))
        {
          localArrayList.add(localAppItem);
        }
      }
    }
    paramNormalizer.normalize(localArrayList, this.mMaxItemsPerPage, paramBoolean);
    return localArrayList;
  }
  
  public void normalizeModel(boolean paramBoolean)
  {
    if ((this.mAppItems != null) && (this.mNormalizer != null)) {
      this.mTopLevelItems = normalizeAppMap(this.mAppItems, this.mNormalizer, paramBoolean);
    }
    StringBuilder localStringBuilder;
    if (DEBUG)
    {
      localStringBuilder = new StringBuilder().append("normalizeModel. Normalizer: ").append(this.mNormalizer).append(", count: ");
      if (this.mTopLevelItems != null) {
        break label88;
      }
    }
    label88:
    for (int i = -1;; i = this.mTopLevelItems.size())
    {
      Log.d("MenuAppModel", i);
      return;
    }
  }
  
  void onLocaleChanged()
  {
    this.mSuspendGets = true;
  }
  
  void onModelRefreshed()
  {
    sCollator = Collator.getInstance();
    this.mSuspendGets = false;
    invalidateTopLevelItems();
  }
  
  public void releaseShadows()
  {
    if (this.mAppItems != null)
    {
      Iterator localIterator = this.mAppItems.values().iterator();
      while (localIterator.hasNext()) {
        ((AppItem)localIterator.next()).mIconShadowBitmap = null;
      }
    }
  }
  
  public void setFolderToDelete(AppFolderItem paramAppFolderItem)
  {
    checkEditMode(true);
    this.mFolderToDelete = paramAppFolderItem;
  }
  
  public void setHasPreSecretWidget(boolean paramBoolean)
  {
    this.mHasPreSecretWidget = paramBoolean;
  }
  
  public void setLauncherApplication(LauncherApplication paramLauncherApplication)
  {
    this.mApplication = paramLauncherApplication;
    paramLauncherApplication = paramLauncherApplication.getResources();
    this.mMaxItemsPerPage = (paramLauncherApplication.getInteger(2131492903) * paramLauncherApplication.getInteger(2131492904));
    this.mIsSafeMode = this.mApplication.getPackageManager().isSafeMode();
  }
  
  public void setModelItems(Map<Long, AppItem> paramMap)
  {
    this.mAppItems = paramMap;
    sCollator = Collator.getInstance();
    getDisabledAppList();
    this.mSuspendGets = false;
    invalidateTopLevelItems();
    if ((CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension")) && (this.mSprintFolderPackages.size() <= 0)) {
      loadSprintFolderPackages();
    }
    setModelFlags();
    if (this.mInEditMode)
    {
      this.mInEditMode = false;
      editBegin();
    }
  }
  
  public void setNormalizer(Normalizer<AppItem> paramNormalizer, int paramInt)
  {
    if ((paramNormalizer != this.mNormalizer) || (paramInt != this.mMaxItemsPerPage))
    {
      this.mMaxItemsPerPage = paramInt;
      this.mNormalizer = paramNormalizer;
      invalidateTopLevelItems();
    }
  }
  
  public void updateCanUninstallApps()
  {
    setModelFlags();
  }
  
  static abstract interface Normalizer<T>
    extends Comparator<T>
  {
    public abstract void normalize(List<T> paramList, int paramInt, boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/MenuAppModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */