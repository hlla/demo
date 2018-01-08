package com.android.launcher2;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.util.Log;
import android.widget.RemoteViews;
import com.samsung.android.feature.FloatingFeature;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class LauncherModel
  extends BroadcastReceiver
{
  public static final String BACKUP_RESTORE_PREF_NAME = "ExtraStuff";
  protected static final boolean DEBUGGABLE = ;
  protected static final boolean DEBUG_LOADERS = true;
  protected static final int ITEMS_CHUNK = 6;
  private static final String TAG = "Launcher.Model";
  public static boolean UseLauncherHighPriority;
  static final ArrayList<HomeItem> sAddedHomeItems = new ArrayList();
  protected static final ArrayList<HomeWidgetItem> sAppWidgets;
  protected static int sCellCountX;
  protected static int sCellCountY;
  protected static final HashMap<Object, byte[]> sDbIconCache;
  protected static final HashMap<Long, HomeFolderItem> sHomeFolders;
  protected static final HashMap<Long, HomeItem> sHomeItemIdMap;
  protected static final ArrayList<HomeItem> sHomeItems;
  static final ArrayList<SamsungWidgetItem> sSamsungWidgets;
  static final ArrayList<SurfaceWidgetItem> sSurfaceWidgets;
  protected static final Handler sWorker;
  protected static final HandlerThread sWorkerThread = new HandlerThread("launcher-loader");
  private boolean isLauncherProviderLoaded = false;
  protected volatile boolean mAllAppsLoaded;
  protected final LauncherApplication mApp;
  private final boolean mAppsCanBeOnExternalStorage;
  private final BadgeCache mBadgeCache;
  protected volatile WeakReference<Callbacks> mCallbacks;
  private volatile int mConfigMccWhenLoaded;
  private volatile int mConfigMncWhenLoaded;
  protected DeferredHandler mHandler = new DeferredHandler();
  private final HomeLoader mHomeLoader;
  private volatile LoaderTask mLoaderTask;
  private volatile String mLocaleWhenLoaded;
  protected final Object mLock = new Object();
  protected final MenuAppLoader mMenuAppLoader;
  protected final PkgResCache mPkgResCache;
  protected volatile boolean mRefreshRequired;
  protected volatile boolean mWorkspaceLoaded;
  
  static
  {
    sWorkerThread.start();
    sWorker = new Handler(sWorkerThread.getLooper());
    UseLauncherHighPriority = FloatingFeature.getInstance().getEnableStatus("SEC_FLOATING_FEATURE_LAUNCHER_BOOT_HIGHPRIORITY");
    sHomeItemIdMap = new HashMap();
    sHomeItems = new ArrayList();
    sAppWidgets = new ArrayList();
    sSamsungWidgets = new ArrayList();
    sSurfaceWidgets = new ArrayList();
    sHomeFolders = new HashMap();
    sDbIconCache = new HashMap();
  }
  
  LauncherModel(LauncherApplication paramLauncherApplication, PkgResCache paramPkgResCache)
  {
    if (!Environment.isExternalStorageEmulated()) {
      bool = true;
    }
    this.mAppsCanBeOnExternalStorage = bool;
    this.mBadgeCache = new BadgeCache(paramLauncherApplication);
    this.mHomeLoader = new HomeLoader(paramLauncherApplication, paramPkgResCache, this.mBadgeCache);
    this.mMenuAppLoader = new MenuAppLoader(paramLauncherApplication, paramPkgResCache, this.mBadgeCache);
    this.mApp = paramLauncherApplication;
    this.mPkgResCache = paramPkgResCache;
  }
  
  LauncherModel(LauncherApplication paramLauncherApplication, PkgResCache paramPkgResCache1, PkgResCache paramPkgResCache2)
  {
    if (!Environment.isExternalStorageEmulated()) {
      bool = true;
    }
    this.mAppsCanBeOnExternalStorage = bool;
    this.mBadgeCache = new BadgeCache(paramLauncherApplication);
    this.mHomeLoader = new HomeLoader(paramLauncherApplication, paramPkgResCache1, this.mBadgeCache);
    this.mMenuAppLoader = new MenuAppLoader(paramLauncherApplication, paramPkgResCache2, this.mBadgeCache);
    this.mApp = paramLauncherApplication;
    this.mPkgResCache = paramPkgResCache1;
  }
  
  private boolean addHomeItem(HomeView paramHomeView, HomeItem paramHomeItem)
  {
    boolean bool = true;
    paramHomeView = paramHomeView.getCellLayout(paramHomeItem.container, paramHomeItem.mScreen);
    if (paramHomeView != null)
    {
      if (paramHomeItem.container == -101L)
      {
        ((CellLayoutHotseat)paramHomeView).mTargetCell = paramHomeItem.mScreen;
        bool = ((CellLayoutHotseat)paramHomeView).addItem(paramHomeItem);
        ((CellLayoutHotseat)paramHomeView).mTargetCell = -1;
      }
    }
    else {
      return bool;
    }
    paramHomeView.mDragCell[0] = paramHomeItem.cellX;
    paramHomeView.mDragCell[1] = paramHomeItem.cellY;
    bool = paramHomeView.addItem(paramHomeItem);
    paramHomeView.mDragCell[0] = -1;
    paramHomeView.mDragCell[1] = -1;
    return bool;
  }
  
  static void addItemToDatabase(Context paramContext, final HomeItem paramHomeItem, long paramLong, int paramInt1, int paramInt2, int paramInt3, final boolean paramBoolean)
  {
    paramHomeItem.container = paramLong;
    paramHomeItem.mScreen = paramInt1;
    paramHomeItem.cellX = paramInt2;
    paramHomeItem.cellY = paramInt3;
    if ((paramLong == -101L) && (paramInt1 < 0) && ((paramContext instanceof Launcher)))
    {
      paramHomeItem.mScreen = ((Launcher)paramContext).getHotseat().getOrderInHotseat(paramInt2, paramInt3);
      paramHomeItem.cellX = -1;
      paramHomeItem.cellY = -1;
    }
    final Object localObject = new ContentValues();
    ContentResolver localContentResolver = paramContext.getContentResolver();
    paramHomeItem.onAddToDatabase((ContentValues)localObject);
    paramContext = (LauncherApplication)paramContext.getApplicationContext();
    paramHomeItem.mId = paramContext.getLauncherProvider().generateNewHomeId();
    ((ContentValues)localObject).put("_id", Long.valueOf(paramHomeItem.mId));
    paramHomeItem.updateValuesWithCoordinates((ContentValues)localObject, paramHomeItem.cellX, paramHomeItem.cellY);
    if (paramHomeItem.mType == BaseItem.Type.HOME_FOLDER) {
      HomeView.sFolders.put(Long.valueOf(paramHomeItem.mId), (HomeFolderItem)paramHomeItem);
    }
    if ((paramHomeItem.mType == BaseItem.Type.HOME_SHORTCUT) && (paramHomeItem.container == -100L)) {
      sAddedHomeItems.add(paramHomeItem);
    }
    if (paramHomeItem.mFestivalType > 0) {
      ((ContentValues)localObject).put("festival", Integer.valueOf(paramHomeItem.mFestivalType));
    }
    localObject = new Runnable()
    {
      public void run()
      {
        ContentResolver localContentResolver = this.val$cr;
        if (paramBoolean) {}
        for (Uri localUri = LauncherSettings.Favorites.CONTENT_URI();; localUri = LauncherSettings.Favorites.CONTENT_URI_NO_NOTIFICATION())
        {
          localContentResolver.insert(localUri, localObject);
          if (!LauncherModel.sHomeItemIdMap.containsKey(Long.valueOf(paramHomeItem.mId))) {
            break;
          }
          throw new RuntimeException("Error: HomeItem id (" + paramHomeItem.mId + ") passed to " + "addItemToDatabase already exists." + paramHomeItem.toString());
        }
        LauncherModel.sHomeItemIdMap.put(Long.valueOf(paramHomeItem.mId), paramHomeItem);
        switch (LauncherModel.12.$SwitchMap$com$android$launcher2$BaseItem$Type[paramHomeItem.mType.ordinal()])
        {
        default: 
        case 1: 
        case 2: 
        case 3: 
          do
          {
            return;
            LauncherModel.sHomeFolders.put(Long.valueOf(paramHomeItem.mId), (HomeFolderItem)paramHomeItem);
          } while ((paramHomeItem.container != -100L) && (paramHomeItem.container != -101L));
          LauncherModel.sHomeItems.add(paramHomeItem);
          LauncherModel.sAddedHomeItems.remove(paramHomeItem);
          return;
        case 4: 
          LauncherModel.sAppWidgets.add((HomeWidgetItem)paramHomeItem);
          return;
        case 5: 
          LauncherModel.sSamsungWidgets.add((SamsungWidgetItem)paramHomeItem);
          return;
        }
        LauncherModel.sSurfaceWidgets.add((SurfaceWidgetItem)paramHomeItem);
      }
    };
    if (BaseItem.isWidget(paramHomeItem))
    {
      LauncherApplication.getInst().insertLog("WGAD", paramHomeItem.getPackageName(), -1L, false);
      LauncherApplication.getInst().insertLog("WGCT", null, paramContext.getModel().WidgetCount() + 1, true);
    }
    if (sWorkerThread.getThreadId() == Process.myTid())
    {
      ((Runnable)localObject).run();
      return;
    }
    sWorker.post((Runnable)localObject);
  }
  
  static void addItemToItemList(Context paramContext, HomeItem paramHomeItem)
  {
    if (sHomeItemIdMap.containsKey(Long.valueOf(paramHomeItem.mId)))
    {
      Log.e("Launcher.Model", "Error: HomeItem id (" + paramHomeItem.mId + ") passed to " + "addItemToDatabase already exists." + paramHomeItem.toString());
      return;
    }
    sHomeItemIdMap.put(Long.valueOf(paramHomeItem.mId), paramHomeItem);
    switch (paramHomeItem.mType)
    {
    case ???: 
    case ???: 
    default: 
      return;
    case ???: 
      sHomeFolders.put(Long.valueOf(paramHomeItem.mId), (HomeFolderItem)paramHomeItem);
      HomeView.sFolders.put(Long.valueOf(paramHomeItem.mId), (HomeFolderItem)paramHomeItem);
      return;
    case ???: 
      sAppWidgets.add((HomeWidgetItem)paramHomeItem);
      return;
    case ???: 
      sSamsungWidgets.add((SamsungWidgetItem)paramHomeItem);
      return;
    }
    sSurfaceWidgets.add((SurfaceWidgetItem)paramHomeItem);
  }
  
  static void addOrMoveItemInDatabase(Context paramContext, HomeItem paramHomeItem, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramHomeItem.mId == -1L)
    {
      addItemToDatabase(paramContext, paramHomeItem, paramLong, paramInt1, paramInt2, paramInt3, false);
      return;
    }
    moveItemInDatabase(paramContext, paramHomeItem, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, "moveItemInDatabase");
  }
  
  private void changeHomeItem(HomeView paramHomeView, ArrayList<HomeItem> paramArrayList1, ArrayList<HomeItem> paramArrayList2)
  {
    if (paramArrayList1.size() == paramArrayList2.size())
    {
      int i = 0;
      while (i < paramArrayList1.size())
      {
        HomeItem localHomeItem1 = (HomeItem)paramArrayList1.get(i);
        HomeItem localHomeItem2 = (HomeItem)paramArrayList2.get(i);
        if (removeHomeItem(paramHomeView, localHomeItem1)) {
          deleteItemFromDatabase(paramHomeView.getActivity(), localHomeItem1);
        }
        if (addHomeItem(paramHomeView, localHomeItem2)) {
          addItemToDatabase(paramHomeView.getActivity(), localHomeItem2, localHomeItem2.container, localHomeItem2.mScreen, localHomeItem2.cellX, localHomeItem2.cellY, false);
        }
        i += 1;
      }
    }
  }
  
  static void deleteItemFromDatabase(Context paramContext, HomeItem paramHomeItem)
  {
    final Object localObject = paramContext.getContentResolver();
    final Uri localUri = LauncherSettings.Favorites.getContentUri(paramHomeItem.mId, false);
    if (paramHomeItem.mType == BaseItem.Type.HOME_FOLDER) {
      HomeView.sFolders.remove(Long.valueOf(paramHomeItem.mId));
    }
    localObject = new Runnable()
    {
      public void run()
      {
        switch (LauncherModel.12.$SwitchMap$com$android$launcher2$BaseItem$Type[this.val$item.mType.ordinal()])
        {
        }
        for (;;)
        {
          localObject.delete(localUri, null, null);
          LauncherModel.sHomeItemIdMap.remove(Long.valueOf(this.val$item.mId));
          LauncherModel.sDbIconCache.remove(this.val$item);
          return;
          LauncherModel.sHomeFolders.remove(Long.valueOf(this.val$item.mId));
          LauncherModel.sHomeItems.remove(this.val$item);
          localObject.delete(LauncherSettings.Favorites.CONTENT_URI_NO_NOTIFICATION, "container=" + this.val$item.mId, null);
          Iterator localIterator = ((HomeFolderItem)this.val$item).contents.iterator();
          while (localIterator.hasNext())
          {
            BaseItem localBaseItem = (BaseItem)localIterator.next();
            LauncherModel.sHomeItemIdMap.remove(Long.valueOf(localBaseItem.mId));
            LauncherModel.sDbIconCache.remove(localBaseItem);
          }
          LauncherModel.sHomeItems.remove(this.val$item);
          continue;
          LauncherModel.sAppWidgets.remove(this.val$item);
          continue;
          LauncherModel.sSamsungWidgets.remove(this.val$item);
          continue;
          LauncherModel.sSurfaceWidgets.remove(this.val$item);
        }
      }
    };
    if (BaseItem.isWidget(paramHomeItem))
    {
      LauncherApplication.getInst().insertLog("WGDT", paramHomeItem.getPackageName(), -1L, false);
      LauncherApplication.getInst().insertLog("WGCT", null, ((LauncherApplication)paramContext.getApplicationContext()).getModel().WidgetCount() - 1, true);
    }
    if (sWorkerThread.getThreadId() == Process.myTid())
    {
      ((Runnable)localObject).run();
      return;
    }
    sWorker.post((Runnable)localObject);
  }
  
  static void deleteItemsFromDatabase(final Context paramContext, List<Long> paramList, final boolean paramBoolean)
  {
    paramContext = new Runnable()
    {
      public void run()
      {
        int i = 0;
        Iterator localIterator = this.val$ids.iterator();
        while (localIterator.hasNext())
        {
          long l = ((Long)localIterator.next()).longValue();
          final Object localObject = LauncherSettings.Favorites.getContentUri(l, false);
          if (this.val$cr.delete((Uri)localObject, null, null) != 0)
          {
            localObject = (HomeItem)LauncherModel.sHomeItemIdMap.remove(Long.valueOf(l));
            if (localObject != null)
            {
              int j = 1;
              LauncherModel.sDbIconCache.remove(localObject);
              switch (LauncherModel.12.$SwitchMap$com$android$launcher2$BaseItem$Type[localObject.mType.ordinal()])
              {
              default: 
                i = j;
                break;
              case 1: 
                LauncherModel.sHomeFolders.remove(Long.valueOf(l));
                i = j;
                break;
              case 2: 
              case 3: 
                if (!BaseItem.isItemInFolder((BaseItem)localObject))
                {
                  LauncherModel.sHomeItems.remove(localObject);
                  i = j;
                }
                else
                {
                  final HomeFolderItem localHomeFolderItem = (HomeFolderItem)LauncherModel.sHomeFolders.get(Long.valueOf(((HomeItem)localObject).container));
                  i = j;
                  if (localHomeFolderItem != null)
                  {
                    new Handler(paramContext.getMainLooper()).post(new Runnable()
                    {
                      public void run()
                      {
                        localHomeFolderItem.removeItem(localObject);
                      }
                    });
                    i = j;
                  }
                }
                break;
              case 4: 
                LauncherModel.sAppWidgets.remove(localObject);
                i = j;
                break;
              case 5: 
                LauncherModel.sSamsungWidgets.remove(localObject);
                i = j;
                break;
              case 6: 
                LauncherModel.sSurfaceWidgets.remove(localObject);
                i = j;
              }
            }
          }
        }
        if ((i != 0) && (paramBoolean)) {
          this.val$cr.notifyChange(LauncherSettings.Favorites.CONTENT_URI, null);
        }
      }
    };
    if (sWorkerThread.getThreadId() == Process.myTid())
    {
      paramContext.run();
      return;
    }
    sWorker.post(paramContext);
  }
  
  private void dynamicCscToggleEasyMode(final boolean paramBoolean1, final boolean paramBoolean2, final int paramInt, final Context paramContext, final String paramString)
  {
    Log.d("Launcher.Model", "dynamicCscToggleEasyMode: " + paramBoolean1 + ", fromSettings: " + paramBoolean2);
    sWorker.post(new Runnable()
    {
      public void run()
      {
        if (LauncherModel.this.mApp.getLauncherProvider().switchToDynamicMode(paramInt)) {
          LauncherModel.access$402(LauncherModel.this, true);
        }
        if (LauncherModel.this.isLauncherProviderLoaded)
        {
          if (paramBoolean2)
          {
            localObject = LauncherModel.this.mCallbacks;
            if ((localObject != null) && (((WeakReference)localObject).get() != null))
            {
              Log.d("Launcher.Model", "dynamicCscToggleEasyMode: Line 1863");
              LauncherModel.this.mHandler.post(new Runnable()
              {
                public void run()
                {
                  LauncherModel.Callbacks localCallbacks = (LauncherModel.Callbacks)LauncherModel.this.mCallbacks.get();
                  Log.d("Launcher.Model", "dynamicCscToggleEasyMode: Line 1868");
                  if ((localCallbacks != null) && (localCallbacks == localObject.get())) {
                    Log.d("Launcher.Model", "called bindModeChange");
                  }
                }
              });
            }
          }
          LauncherModel.this.startLoaderFromBackground(true);
          LauncherModel.this.mWorkspaceLoaded = false;
        }
        final Object localObject = new Intent("com.android.launcher.action.DYNAMIC_CSC_CHANGES_APPLIED");
        ((Intent)localObject).putExtra("UpdateNotification", paramBoolean1);
        ((Intent)localObject).putExtra("Theme_Installed", paramString);
        paramContext.sendBroadcast((Intent)localObject);
      }
    });
  }
  
  private void enqueuePackageUpdated(PackageUpdatedTask paramPackageUpdatedTask)
  {
    sWorker.post(paramPackageUpdatedTask);
  }
  
  protected static HomeFolderItem findOrMakeFolder(HashMap<Long, HomeFolderItem> paramHashMap, long paramLong)
  {
    HomeFolderItem localHomeFolderItem2 = (HomeFolderItem)paramHashMap.get(Long.valueOf(paramLong));
    HomeFolderItem localHomeFolderItem1 = localHomeFolderItem2;
    if (localHomeFolderItem2 == null)
    {
      localHomeFolderItem1 = new HomeFolderItem();
      paramHashMap.put(Long.valueOf(paramLong), localHomeFolderItem1);
    }
    return localHomeFolderItem1;
  }
  
  static int getCellCountX()
  {
    return sCellCountX;
  }
  
  static int getCellCountY()
  {
    return sCellCountY;
  }
  
  static int getCellLayoutChildId(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return ((int)paramLong & 0xFF) << 24 | (paramInt1 & 0xFF) << 16 | (paramInt2 & 0xFF) << 8 | paramInt3 & 0xFF;
  }
  
  private Bitmap getFallbackIcon()
  {
    return this.mPkgResCache.getDefaultIcon();
  }
  
  private Bitmap getIconFromCursor(Cursor paramCursor, int paramInt, Context paramContext)
  {
    paramCursor = paramCursor.getBlob(paramInt);
    try
    {
      paramCursor = Utilities.createIconBitmap(BitmapFactory.decodeByteArray(paramCursor, 0, paramCursor.length), paramContext);
      return paramCursor;
    }
    catch (Exception paramCursor) {}
    return null;
  }
  
  /* Error */
  static ArrayList<HomeItem> getItemsInLocalCoordinates(Context paramContext, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: new 205	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 206	java/util/ArrayList:<init>	()V
    //   7: astore 9
    //   9: aload_0
    //   10: invokevirtual 344	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: getstatic 633	com/android/launcher2/LauncherSettings$Favorites:CONTENT_URI	Landroid/net/Uri;
    //   16: bipush 6
    //   18: anewarray 635	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: ldc_w 636
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc_w 637
    //   32: aastore
    //   33: dup
    //   34: iconst_2
    //   35: ldc_w 639
    //   38: aastore
    //   39: dup
    //   40: iconst_3
    //   41: ldc_w 641
    //   44: aastore
    //   45: dup
    //   46: iconst_4
    //   47: ldc_w 643
    //   50: aastore
    //   51: dup
    //   52: iconst_5
    //   53: ldc_w 414
    //   56: aastore
    //   57: ldc_w 645
    //   60: iconst_2
    //   61: anewarray 635	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: lload_1
    //   67: invokestatic 648	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: iload_3
    //   74: invokestatic 651	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   77: aastore
    //   78: aconst_null
    //   79: invokevirtual 657	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore_0
    //   83: aload_0
    //   84: ldc_w 636
    //   87: invokeinterface 661 2 0
    //   92: istore 4
    //   94: aload_0
    //   95: ldc_w 637
    //   98: invokeinterface 661 2 0
    //   103: istore 5
    //   105: aload_0
    //   106: ldc_w 639
    //   109: invokeinterface 661 2 0
    //   114: istore 6
    //   116: aload_0
    //   117: ldc_w 641
    //   120: invokeinterface 661 2 0
    //   125: istore 7
    //   127: aload_0
    //   128: ldc_w 643
    //   131: invokeinterface 661 2 0
    //   136: istore 8
    //   138: aload_0
    //   139: invokeinterface 664 1 0
    //   144: ifeq +121 -> 265
    //   147: new 284	com/android/launcher2/HomeItem
    //   150: dup
    //   151: invokespecial 665	com/android/launcher2/HomeItem:<init>	()V
    //   154: astore 10
    //   156: aload 10
    //   158: lload_1
    //   159: putfield 288	com/android/launcher2/HomeItem:container	J
    //   162: aload 10
    //   164: iload_3
    //   165: putfield 291	com/android/launcher2/HomeItem:mScreen	I
    //   168: aload 10
    //   170: aload_0
    //   171: iload 4
    //   173: invokeinterface 669 2 0
    //   178: putfield 317	com/android/launcher2/HomeItem:cellX	I
    //   181: aload 10
    //   183: aload_0
    //   184: iload 5
    //   186: invokeinterface 669 2 0
    //   191: putfield 320	com/android/launcher2/HomeItem:cellY	I
    //   194: aload 10
    //   196: aload_0
    //   197: iload 6
    //   199: invokeinterface 669 2 0
    //   204: putfield 671	com/android/launcher2/HomeItem:spanX	I
    //   207: aload 10
    //   209: aload_0
    //   210: iload 7
    //   212: invokeinterface 669 2 0
    //   217: putfield 673	com/android/launcher2/HomeItem:spanY	I
    //   220: aload_0
    //   221: iload 8
    //   223: invokeinterface 669 2 0
    //   228: iconst_1
    //   229: if_icmpne +9 -> 238
    //   232: aload 10
    //   234: iconst_1
    //   235: putfield 676	com/android/launcher2/HomeItem:mSecretItem	Z
    //   238: aload 9
    //   240: aload 10
    //   242: invokevirtual 409	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   245: pop
    //   246: goto -108 -> 138
    //   249: astore 10
    //   251: aload 9
    //   253: invokevirtual 679	java/util/ArrayList:clear	()V
    //   256: aload_0
    //   257: invokeinterface 682 1 0
    //   262: aload 9
    //   264: areturn
    //   265: aload_0
    //   266: invokeinterface 682 1 0
    //   271: aload 9
    //   273: areturn
    //   274: astore 9
    //   276: aload_0
    //   277: invokeinterface 682 1 0
    //   282: aload 9
    //   284: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramContext	Context
    //   0	285	1	paramLong	long
    //   0	285	3	paramInt	int
    //   92	80	4	i	int
    //   103	82	5	j	int
    //   114	84	6	k	int
    //   125	86	7	m	int
    //   136	86	8	n	int
    //   7	265	9	localArrayList	ArrayList
    //   274	9	9	localObject	Object
    //   154	87	10	localHomeItem	HomeItem
    //   249	1	10	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   138	238	249	java/lang/Exception
    //   238	246	249	java/lang/Exception
    //   138	238	274	finally
    //   238	246	274	finally
    //   251	256	274	finally
  }
  
  private boolean isKnoxShortcut(Intent paramIntent)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    String str = paramIntent.getStringExtra("shortcutIntent");
    if (("com.samsung.knox.rcp.components".equals(localComponentName.getPackageName())) && ("com.samsung.knox.rcp.components.KnoxShortcutActivity".equals(localComponentName.getClassName())) && (str != null) && (str.startsWith("persona_shortcut://")))
    {
      if (DEBUGGABLE) {
        Log.i("Launcher.Model", "knoxShortcut. will not remove " + paramIntent);
      }
      return true;
    }
    return false;
  }
  
  /* Error */
  private static void loadShortcutMovie(Context paramContext, HomeShortcutItem paramHomeShortcutItem)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 734	com/android/launcher2/HomeShortcutItem:mIconMovieUri	Landroid/net/Uri;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +101 -> 107
    //   9: aload_0
    //   10: invokevirtual 344	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: aload_3
    //   14: invokevirtual 738	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   17: astore_0
    //   18: new 740	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: sipush 1024
    //   25: invokespecial 743	java/io/ByteArrayOutputStream:<init>	(I)V
    //   28: astore 4
    //   30: sipush 1024
    //   33: newarray <illegal type>
    //   35: astore 5
    //   37: aload_0
    //   38: ifnull +82 -> 120
    //   41: aload_0
    //   42: aload 5
    //   44: invokevirtual 749	java/io/InputStream:read	([B)I
    //   47: istore_2
    //   48: iload_2
    //   49: iflt +71 -> 120
    //   52: aload 4
    //   54: aload 5
    //   56: iconst_0
    //   57: iload_2
    //   58: invokevirtual 753	java/io/ByteArrayOutputStream:write	([BII)V
    //   61: goto -20 -> 41
    //   64: astore 4
    //   66: aload_0
    //   67: invokevirtual 754	java/io/InputStream:close	()V
    //   70: aload 4
    //   72: athrow
    //   73: astore_0
    //   74: getstatic 159	com/android/launcher2/LauncherModel:DEBUGGABLE	Z
    //   77: ifeq +30 -> 107
    //   80: ldc 99
    //   82: new 480	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 481	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 756
    //   92: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_3
    //   96: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: aload_0
    //   103: invokestatic 759	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   106: pop
    //   107: aload_1
    //   108: getfield 763	com/android/launcher2/HomeShortcutItem:mIconMovie	Landroid/graphics/Movie;
    //   111: ifnonnull +8 -> 119
    //   114: aload_1
    //   115: aconst_null
    //   116: putfield 734	com/android/launcher2/HomeShortcutItem:mIconMovieUri	Landroid/net/Uri;
    //   119: return
    //   120: aload 4
    //   122: invokevirtual 767	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   125: astore 4
    //   127: aload_1
    //   128: aload 4
    //   130: iconst_0
    //   131: aload 4
    //   133: arraylength
    //   134: invokestatic 772	android/graphics/Movie:decodeByteArray	([BII)Landroid/graphics/Movie;
    //   137: putfield 763	com/android/launcher2/HomeShortcutItem:mIconMovie	Landroid/graphics/Movie;
    //   140: aload_0
    //   141: invokevirtual 754	java/io/InputStream:close	()V
    //   144: goto -37 -> 107
    //   147: astore_0
    //   148: getstatic 159	com/android/launcher2/LauncherModel:DEBUGGABLE	Z
    //   151: ifeq -44 -> 107
    //   154: ldc 99
    //   156: new 480	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 481	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 774
    //   166: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_3
    //   170: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: aload_0
    //   177: invokestatic 759	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   180: pop
    //   181: goto -74 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramContext	Context
    //   0	184	1	paramHomeShortcutItem	HomeShortcutItem
    //   47	11	2	i	int
    //   4	166	3	localUri	Uri
    //   28	25	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   64	57	4	localObject	Object
    //   125	7	4	arrayOfByte1	byte[]
    //   35	20	5	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   30	37	64	finally
    //   41	48	64	finally
    //   52	61	64	finally
    //   120	140	64	finally
    //   9	30	73	java/io/FileNotFoundException
    //   66	73	73	java/io/FileNotFoundException
    //   140	144	73	java/io/FileNotFoundException
    //   9	30	147	java/io/IOException
    //   66	73	147	java/io/IOException
    //   140	144	147	java/io/IOException
  }
  
  static void moveItemInDatabase(Context paramContext, HomeItem paramHomeItem, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    paramHomeItem.container = paramLong;
    paramHomeItem.mScreen = paramInt1;
    paramHomeItem.cellX = paramInt2;
    paramHomeItem.cellY = paramInt3;
    paramHomeItem.spanX = paramInt4;
    paramHomeItem.spanY = paramInt5;
    if ((paramLong == -101L) && (paramInt1 < 0) && ((paramContext instanceof Launcher)))
    {
      paramHomeItem.mScreen = ((Launcher)paramContext).getHotseat().getOrderInHotseat(paramInt2, paramInt3);
      paramHomeItem.cellX = -1;
      paramHomeItem.cellY = -1;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("container", Long.valueOf(paramHomeItem.container));
    localContentValues.put("cellX", Integer.valueOf(paramHomeItem.cellX));
    localContentValues.put("cellY", Integer.valueOf(paramHomeItem.cellY));
    if (BaseItem.isWidget(paramHomeItem))
    {
      localContentValues.put("spanX", Integer.valueOf(paramInt4));
      localContentValues.put("spanY", Integer.valueOf(paramInt5));
    }
    localContentValues.put("screen", Integer.valueOf(paramHomeItem.mScreen));
    if (paramHomeItem.mSecretItem) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localContentValues.put("secret", Integer.valueOf(paramInt1));
      localContentValues.put("festival", Integer.valueOf(paramHomeItem.mFestivalType));
      updateItemInDatabaseHelper(paramContext, localContentValues, paramHomeItem, paramString);
      return;
    }
  }
  
  public static void moveItemsInDatabase(Context paramContext, List<HomeItem> paramList)
  {
    final ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      HomeItem localHomeItem = (HomeItem)paramList.next();
      LauncherSettings.FavoritePos localFavoritePos = new LauncherSettings.FavoritePos();
      localFavoritePos.id = localHomeItem.mId;
      localFavoritePos.container = localHomeItem.container;
      localFavoritePos.screen = localHomeItem.mScreen;
      localFavoritePos.cellX = localHomeItem.cellX;
      localFavoritePos.cellY = localHomeItem.cellY;
      if (localHomeItem.mSecretItem) {}
      for (int i = 1;; i = 0)
      {
        localFavoritePos.secret = i;
        localFavoritePos.festival = localHomeItem.mFestivalType;
        localArrayList.add(localFavoritePos);
        break;
      }
    }
    paramContext = new Runnable()
    {
      public void run()
      {
        Object localObject = this.val$app.getLauncherProvider();
        if (localObject != null)
        {
          ((LauncherProvider)localObject).moveFavorites(localArrayList);
          localObject = localArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            LauncherSettings.FavoritePos localFavoritePos = (LauncherSettings.FavoritePos)((Iterator)localObject).next();
            HomeItem localHomeItem = (HomeItem)LauncherModel.sHomeItemIdMap.get(Long.valueOf(localFavoritePos.id));
            if (localHomeItem == null)
            {
              if (LauncherModel.DEBUGGABLE) {
                Log.e("Launcher.Model", "Attempted to move an item that is not in sItemsIdMap. Id: " + localFavoritePos.id);
              }
            }
            else if ((localFavoritePos.container == -100L) || (localFavoritePos.container == -101L))
            {
              if (!LauncherModel.sHomeItems.contains(localHomeItem)) {
                LauncherModel.sHomeItems.add(localHomeItem);
              }
            }
            else {
              LauncherModel.sHomeItems.remove(localHomeItem);
            }
          }
        }
      }
    };
    if (sWorkerThread.getThreadId() == Process.myTid())
    {
      paramContext.run();
      return;
    }
    sWorker.post(paramContext);
  }
  
  private boolean removeHomeItem(HomeView paramHomeView, HomeItem paramHomeItem)
  {
    boolean bool = true;
    paramHomeView = paramHomeView.getCellLayout(paramHomeItem.container, paramHomeItem.mScreen);
    if (paramHomeView != null)
    {
      if (paramHomeItem.container == -101L) {
        bool = ((CellLayoutHotseat)paramHomeView).removeItem(paramHomeItem);
      }
    }
    else {
      return bool;
    }
    return paramHomeView.removeItem(paramHomeItem);
  }
  
  static boolean shortcutExists(Context paramContext, String paramString, Intent paramIntent)
  {
    paramContext = paramContext.getContentResolver();
    Uri localUri = LauncherSettings.Favorites.CONTENT_URI_NO_NOTIFICATION;
    paramIntent = paramIntent.toUri(0);
    paramContext = paramContext.query(localUri, new String[] { "_id" }, "title=? and intent=?", new String[] { paramString, paramIntent }, null);
    boolean bool = false;
    if (paramContext != null)
    {
      bool = paramContext.moveToFirst();
      paramContext.close();
    }
    return bool;
  }
  
  private void startLoader(boolean paramBoolean1, boolean paramBoolean2)
  {
    Log.d("Launcher.Model", "startLoader. isLaunching: " + paramBoolean1 + "; forceRefresh: " + paramBoolean2);
    Object localObject1 = this.mLock;
    if (paramBoolean2) {}
    try
    {
      this.mRefreshRequired = true;
      if ((this.mCallbacks != null) && (this.mCallbacks.get() != null))
      {
        this.mLoaderTask = new LoaderTask(paramBoolean1 | stopLoaderLocked());
        sWorkerThread.setPriority(5);
        sWorker.post(this.mLoaderTask);
      }
      return;
    }
    finally {}
  }
  
  static void updateAppItems(Context paramContext, final List<LauncherSettings.AppOrderModify> paramList)
  {
    paramContext = new Runnable()
    {
      public void run()
      {
        if (this.val$provider != null) {
          this.val$provider.updateAppItems(paramList);
        }
      }
    };
    if (sWorkerThread.getThreadId() == Process.myTid())
    {
      paramContext.run();
      return;
    }
    sWorker.post(paramContext);
  }
  
  static void updateItemInDatabase(Context paramContext, long paramLong, final ContentValues paramContentValues)
  {
    if (paramContentValues.containsKey("container")) {
      throw new RuntimeException("Cannot change container field for item id: " + paramLong);
    }
    final Uri localUri = LauncherSettings.Favorites.getContentUri(paramLong, false);
    paramContext = new Runnable()
    {
      public void run()
      {
        int i = this.val$cr.update(localUri, paramContentValues, null, null);
        if ((i != 1) && (LauncherModel.DEBUGGABLE)) {
          Log.e("Launcher.Model", "updateItemInDatabase modified " + i + " rows for uri: " + localUri);
        }
      }
    };
    if (sWorkerThread.getThreadId() == Process.myTid())
    {
      paramContext.run();
      return;
    }
    sWorker.post(paramContext);
  }
  
  static void updateItemInDatabase(Context paramContext, HomeItem paramHomeItem)
  {
    ContentValues localContentValues = new ContentValues();
    paramHomeItem.onAddToDatabase(localContentValues);
    paramHomeItem.updateValuesWithCoordinates(localContentValues, paramHomeItem.cellX, paramHomeItem.cellY);
    updateItemInDatabaseHelper(paramContext, localContentValues, paramHomeItem, "updateItemInDatabase");
  }
  
  private static void updateItemInDatabaseHelper(Context paramContext, final ContentValues paramContentValues, HomeItem paramHomeItem, final String paramString)
  {
    final long l = paramHomeItem.mId;
    final Uri localUri = LauncherSettings.Favorites.getContentUri(l, false);
    paramContext = new Runnable()
    {
      public void run()
      {
        this.val$cr.update(localUri, paramContentValues, null, null);
        Object localObject = (HomeItem)LauncherModel.sHomeItemIdMap.get(Long.valueOf(l));
        if (paramString != localObject)
        {
          if (LauncherModel.DEBUGGABLE) {
            Log.d("Launcher.Model", "modelItem: " + System.identityHashCode(localObject) + ", item: " + System.identityHashCode(paramString));
          }
          StringBuilder localStringBuilder = new StringBuilder().append("item: ").append(paramString.toString()).append("modelItem: ");
          if (localObject != null) {}
          for (localObject = ((HomeItem)localObject).toString();; localObject = "null") {
            throw new RuntimeException((String)localObject + "Error: HomeItem passed to " + this.val$callingFunction + " doesn't match original");
          }
        }
        if ((((HomeItem)localObject).container == -100L) || (((HomeItem)localObject).container == -101L))
        {
          if (!LauncherModel.sHomeItems.contains(localObject)) {
            LauncherModel.sHomeItems.add(localObject);
          }
          return;
        }
        LauncherModel.sHomeItems.remove(localObject);
      }
    };
    if (sWorkerThread.getThreadId() == Process.myTid())
    {
      paramContext.run();
      return;
    }
    sWorker.post(paramContext);
  }
  
  static void updateWorkspaceLayoutCells(int paramInt1, int paramInt2)
  {
    sCellCountX = paramInt1;
    sCellCountY = paramInt2;
  }
  
  public void ChangeCallapp(HomeView paramHomeView, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (this.mApp.getApplicationContext().getResources().getBoolean(2131427337))
    {
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= sHomeItems.size()) {
          break;
        }
        HomeItem localHomeItem1 = (HomeItem)sHomeItems.get(j);
        k = i;
        if (localHomeItem1.container == -101L)
        {
          k = i;
          if (localHomeItem1.getComponentName() != null)
          {
            k = i;
            if (localHomeItem1.getComponentName().getClassName() != null)
            {
              k = i;
              if (localHomeItem1.getComponentName().getClassName().toString().equals(paramString2))
              {
                HomeItem localHomeItem2 = setCallAppItem(paramHomeView, localHomeItem1, paramString3, paramString4);
                localArrayList2.add(localHomeItem1);
                localArrayList1.add(localHomeItem2);
                k = 1;
              }
            }
          }
        }
        j += 1;
        i = k;
      }
    }
    int k = 1;
    if (k != 0) {
      i = 0;
    }
    for (;;)
    {
      if (i < sHomeItems.size())
      {
        paramString3 = (HomeItem)sHomeItems.get(i);
        if ((paramString3.container == -100L) && (paramString3.mScreen == LauncherApplication.getHomeScreenIndex()) && (paramString3.getComponentName() != null) && (paramString3.getComponentName().getClassName() != null) && (paramString3.getComponentName().getClassName().toString().equals(paramString4)))
        {
          paramString1 = setCallAppItem(paramHomeView, paramString3, paramString1, paramString2);
          localArrayList2.add(paramString3);
          localArrayList1.add(paramString1);
        }
      }
      else
      {
        changeHomeItem(paramHomeView, localArrayList2, localArrayList1);
        return;
      }
      i += 1;
    }
  }
  
  public void ChangeTphoneMode(HomeView paramHomeView)
  {
    if (Settings.System.getInt(paramHomeView.getContext().getContentResolver(), "skt_phone20_settings", 0) == 1)
    {
      ChangeCallapp(paramHomeView, "com.android.contacts", "com.android.dialer.DialtactsActivity", "com.skt.prod.dialer", "com.skt.prod.dialer.activities.main.MainActivity");
      Log.i("ChangeTphoneMode", "OEM -> T phone app");
      return;
    }
    ChangeCallapp(paramHomeView, "com.skt.prod.dialer", "com.skt.prod.dialer.activities.main.MainActivity", "com.android.contacts", "com.android.dialer.DialtactsActivity");
    Log.i("ChangeTphoneMode", "T -> OEM phone app");
  }
  
  public int HomeViewCount()
  {
    return sAppWidgets.size() + sSamsungWidgets.size() + sHomeItems.size() + sSurfaceWidgets.size();
  }
  
  public int WidgetCount()
  {
    return sAppWidgets.size() + sSamsungWidgets.size() + sSurfaceWidgets.size();
  }
  
  HomeShortcutItem addShortcut(Context paramContext, Intent paramIntent, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramIntent = infoFromShortcutIntent(paramContext, paramIntent, null);
    addItemToDatabase(paramContext, paramIntent, paramLong, paramInt1, paramInt2, paramInt3, paramBoolean);
    return paramIntent;
  }
  
  public void dumpState()
  {
    Log.d("Launcher.Model", "mCallbacks=" + this.mCallbacks);
    AppItem.dumpApplicationInfoList("Launcher.Model", "mMainAppCache.added", this.mMenuAppLoader.added);
    AppItem.dumpApplicationInfoList("Launcher.Model", "mMainAppCache.removed", this.mMenuAppLoader.removed);
    AppItem.dumpApplicationInfoList("Launcher.Model", "mMainAppCache.modified", this.mMenuAppLoader.modified);
    LoaderTask localLoaderTask = this.mLoaderTask;
    if (localLoaderTask != null)
    {
      localLoaderTask.dumpState();
      return;
    }
    Log.d("Launcher.Model", "mLoaderTask=null");
  }
  
  HomeFolderItem getFolderById(Context paramContext, HashMap<Long, HomeFolderItem> paramHashMap, long paramLong)
  {
    paramContext = paramContext.getContentResolver().query(LauncherSettings.Favorites.CONTENT_URI, null, "_id=? and itemType=?", new String[] { String.valueOf(paramLong), String.valueOf(2) }, null);
    try
    {
      if (paramContext.moveToFirst())
      {
        int i = paramContext.getColumnIndexOrThrow("title");
        int j = paramContext.getColumnIndexOrThrow("container");
        int k = paramContext.getColumnIndexOrThrow("screen");
        int m = paramContext.getColumnIndexOrThrow("cellX");
        int n = paramContext.getColumnIndexOrThrow("cellY");
        paramHashMap = findOrMakeFolder(paramHashMap, paramLong);
        paramHashMap.mTitle = paramContext.getString(i);
        paramHashMap.mId = paramLong;
        paramHashMap.container = paramContext.getInt(j);
        paramHashMap.mScreen = paramContext.getInt(k);
        paramHashMap.cellX = paramContext.getInt(m);
        paramHashMap.cellY = paramContext.getInt(n);
        return paramHashMap;
      }
      return null;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public HomeShortcutItem getShortcutInfo(PackageManager paramPackageManager, Intent paramIntent, Context paramContext)
  {
    return getShortcutInfo(paramPackageManager, paramIntent, paramContext, null, -1, -1, -1);
  }
  
  HomeShortcutItem getShortcutInfo(PackageManager paramPackageManager, Intent paramIntent, Context paramContext, Cursor paramCursor, int paramInt1, int paramInt2, int paramInt3)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName == null)
    {
      paramIntent = null;
      return paramIntent;
    }
    paramContext = null;
    Object localObject = null;
    paramIntent = paramPackageManager.resolveActivity(paramIntent, 0);
    if (paramIntent == null) {}
    for (;;)
    {
      try
      {
        paramIntent = paramPackageManager.getPackageInfo(localComponentName.getPackageName(), 8192).applicationInfo;
        paramPackageManager = (PackageManager)localObject;
        if (paramIntent != null)
        {
          paramPackageManager = (PackageManager)localObject;
          if ((paramIntent.flags & 0x40000) != 0)
          {
            paramPackageManager = new HomeShortcutItem(BaseItem.Type.HOME_APPLICATION);
            if (paramCursor != null) {
              continue;
            }
            paramIntent = null;
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramPackageManager)
      {
        paramPackageManager = paramContext;
      }
      try
      {
        paramPackageManager.mTitle = paramIntent;
        paramPackageManager.mIconBitmap = this.mPkgResCache.getUnavailableIcon();
        paramIntent = paramPackageManager;
        if (paramPackageManager == null) {
          break;
        }
        if (paramPackageManager.mIconBitmap == null)
        {
          paramPackageManager.mIconBitmap = getFallbackIcon();
          paramPackageManager.usingFallbackIcon = true;
        }
        if (paramPackageManager.mTitle == null) {
          paramPackageManager.mTitle = localComponentName.getClassName();
        }
        paramPackageManager.mBadgeCount = this.mBadgeCache.getBadgeCount(localComponentName);
        return paramPackageManager;
      }
      catch (PackageManager.NameNotFoundException paramIntent)
      {
        for (;;) {}
      }
      paramIntent = paramCursor.getString(paramInt2);
      continue;
      if (Launcher.isHomescreenRestoring)
      {
        paramIntent = new HomeShortcutItem(BaseItem.Type.HOME_APPLICATION);
        if (paramCursor == null) {}
        for (paramPackageManager = null;; paramPackageManager = paramCursor.getString(paramInt2))
        {
          paramIntent.mTitle = paramPackageManager;
          paramIntent.mIconBitmap = Utilities.createIconBitmap(this.mApp.getResources().getDrawable(2130837768), this.mApp);
          paramPackageManager = paramIntent;
          break;
        }
        paramPackageManager = new HomeShortcutItem(BaseItem.Type.HOME_APPLICATION);
        paramContext = new PkgResCache.TitleIconInfo();
        this.mPkgResCache.getTitleAndIcon(paramContext, paramIntent);
        paramPackageManager.mIconBitmap = paramContext.mIcon;
        paramPackageManager.mTitle = paramContext.mTitle;
      }
    }
  }
  
  protected HomeShortcutItem getShortcutInfo(Cursor paramCursor, Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, PackageManager paramPackageManager, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    HomeShortcutItem localHomeShortcutItem = null;
    ComponentName localComponentName = paramIntent.getComponent();
    ResolveInfo localResolveInfo;
    if (localComponentName != null)
    {
      localResolveInfo = paramPackageManager.resolveActivity(paramIntent, 0);
      if (localResolveInfo == null)
      {
        paramInt1 = 0;
        paramInt3 = 0;
        localHomeShortcutItem = null;
        localObject1 = null;
        paramContext = paramIntent.getCategories();
        paramInt2 = paramInt1;
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          do
          {
            paramInt2 = paramInt1;
            if (!paramContext.hasNext()) {
              break;
            }
          } while ((!"android.intent.category.LAUNCHER".equals((String)paramContext.next())) || (!"android.intent.action.MAIN".equals(paramIntent.getAction())));
          paramInt1 = 1;
          paramInt2 = paramInt1;
          if (DEBUGGABLE)
          {
            Log.i("Launcher.Model", "getShortcutInfo resolveInfo == null but not yet ready cn=" + localComponentName);
            paramInt2 = paramInt1;
          }
        }
        paramContext = localHomeShortcutItem;
        paramInt1 = paramInt3;
        if (paramInt2 == 0) {
          break label842;
        }
        for (;;)
        {
          try
          {
            paramPackageManager = paramPackageManager.getPackageInfo(localComponentName.getPackageName(), 8192);
            paramContext = localHomeShortcutItem;
            paramInt1 = paramInt3;
            if (paramPackageManager == null) {
              break label842;
            }
            paramPackageManager = paramPackageManager.applicationInfo;
            paramContext = localHomeShortcutItem;
            paramInt1 = paramInt3;
            if (paramPackageManager == null) {
              break label842;
            }
            paramContext = localHomeShortcutItem;
            paramInt1 = paramInt3;
            if ((paramPackageManager.flags & 0x40000) == 0) {
              break label842;
            }
            paramContext = new HomeShortcutItem(BaseItem.Type.HOME_SHORTCUT);
            if (paramCursor == null) {
              paramPackageManager = null;
            }
          }
          catch (PackageManager.NameNotFoundException paramContext)
          {
            paramContext = (Context)localObject1;
          }
          try
          {
            paramContext.mTitle = paramPackageManager;
            paramContext.mIconBitmap = this.mPkgResCache.getUnavailableIcon();
            paramInt1 = 1;
          }
          catch (PackageManager.NameNotFoundException paramPackageManager)
          {
            for (;;) {}
          }
          paramPackageManager = paramCursor.getString(paramInt5);
        }
        paramInt1 = paramInt3;
        if (!Launcher.isHomescreenRestoring) {
          break label842;
        }
        paramContext = new HomeShortcutItem(BaseItem.Type.HOME_APPLICATION);
        if (paramCursor == null)
        {
          paramCursor = null;
          paramContext.mTitle = paramCursor;
          paramContext.mIconBitmap = Utilities.createIconBitmap(this.mApp.getResources().getDrawable(2130837768), this.mApp);
          paramInt1 = 1;
          break label842;
        }
        paramCursor = paramCursor.getString(paramInt5);
      }
    }
    label822:
    label842:
    while (paramInt1 == 0)
    {
      return null;
      localObject1 = localHomeShortcutItem;
      if (!localComponentName.getPackageName().equals("com.android.email")) {
        if (!paramIntent.hasCategory("com.android.settings.SHORTCUT"))
        {
          localObject1 = localHomeShortcutItem;
          if (!paramIntent.hasCategory("android.intent.category.LAUNCHER")) {}
        }
        else
        {
          localObject1 = this.mPkgResCache.getTitle(localResolveInfo);
        }
      }
      if (localComponentName.getPackageName().equals("com.sec.android.app.latin.launcher.stk")) {
        localObject1 = this.mPkgResCache.getTitle(localResolveInfo);
      }
      localHomeShortcutItem = new HomeShortcutItem();
      paramIntent = (Intent)localObject1;
      if (localObject1 == null) {
        paramIntent = paramCursor.getString(paramInt5);
      }
      localHomeShortcutItem.mTitle = paramIntent;
      switch (paramCursor.getInt(paramInt1))
      {
      default: 
        paramPackageManager = getFallbackIcon();
        localHomeShortcutItem.usingFallbackIcon = true;
        localHomeShortcutItem.customIcon = false;
        paramIntent = paramPackageManager;
        if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE)
        {
          localObject1 = LauncherApplication.getInst().getThemeLoader();
          paramIntent = new AvailableShortcutWidgetListProvider(paramContext);
          if (localComponentName != null) {
            break label822;
          }
        }
        break;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bool1;
        if (paramIntent != null)
        {
          bool2 = bool1;
          if (localComponentName != null) {
            bool2 = paramIntent.isShortcutWidget(localComponentName.getClassName());
          }
        }
        paramIntent = paramPackageManager;
        if (!((ThemeLoader)localObject1).isUseDefaultTheme())
        {
          paramIntent = paramPackageManager;
          if (!bool2) {
            paramIntent = ((ThemeLoader)localObject1).load3rdAppIconBitmap(paramPackageManager);
          }
        }
        localHomeShortcutItem.setIcon(paramIntent);
        paramPackageManager = paramCursor.getString(paramCursor.getColumnIndexOrThrow("iconMovieUri"));
        paramCursor = localHomeShortcutItem;
        if (paramPackageManager == null) {
          return paramCursor;
        }
        localHomeShortcutItem.mIconMovieUri = Uri.parse(paramPackageManager);
        loadShortcutMovie(paramContext, localHomeShortcutItem);
        return localHomeShortcutItem;
        localObject1 = paramCursor.getString(paramInt2);
        paramIntent = paramCursor.getString(paramInt3);
        localHomeShortcutItem.customIcon = false;
        try
        {
          localObject1 = paramPackageManager.getResourcesForApplication((String)localObject1);
          paramInt1 = ((Resources)localObject1).getIdentifier(paramIntent, null, null);
          paramPackageManager = (PackageManager)localObject2;
          if (paramInt1 != 0) {
            paramPackageManager = this.mPkgResCache.loadBitmap((Resources)localObject1, paramInt1, paramIntent);
          }
        }
        catch (PackageManager.NameNotFoundException paramPackageManager)
        {
          for (;;)
          {
            paramPackageManager = (PackageManager)localObject2;
          }
        }
        paramIntent = paramPackageManager;
        if (paramPackageManager == null) {
          paramIntent = getIconFromCursor(paramCursor, paramInt4, paramContext);
        }
        paramPackageManager = paramIntent;
        if (paramIntent != null) {
          break;
        }
        paramPackageManager = getFallbackIcon();
        localHomeShortcutItem.usingFallbackIcon = true;
        break;
        paramPackageManager = getIconFromCursor(paramCursor, paramInt4, paramContext);
        if (paramPackageManager == null)
        {
          paramPackageManager = getFallbackIcon();
          localHomeShortcutItem.customIcon = false;
          localHomeShortcutItem.usingFallbackIcon = true;
          break;
        }
        localHomeShortcutItem.customIcon = true;
        break;
      }
    }
    paramCursor = paramContext;
    return paramCursor;
  }
  
  protected HomeShortcutItem getShortcutInfoExtra(PackageManager paramPackageManager, Intent paramIntent, Context paramContext, Cursor paramCursor, int paramInt1, int paramInt2)
  {
    Log.i("Launcher.Model", "getShortcutInfo");
    ComponentName localComponentName = paramIntent.getComponent();
    if (DEBUGGABLE) {
      Log.i("Launcher.Model", "getShortcutInfo componentName=" + localComponentName);
    }
    Object localObject = paramPackageManager.resolveActivity(paramIntent, 0);
    if (DEBUGGABLE) {
      Log.i("Launcher.Model", "getShortcutInfo rInfo=" + localObject);
    }
    if (localObject == null)
    {
      if (localComponentName == null) {
        return null;
      }
      for (bool1 = false;; bool1 = false)
      {
        try
        {
          int i = paramPackageManager.getApplicationInfo(localComponentName.getPackageName(), 8192).flags;
          if ((i & 0x40000) == 0) {
            continue;
          }
          bool1 = true;
        }
        catch (PackageManager.NameNotFoundException paramPackageManager)
        {
          HomeShortcutItem localHomeShortcutItem;
          for (;;) {}
        }
        if (DEBUGGABLE) {
          Log.i("Launcher.Model", "getShortcutInfo unmounted=" + bool1);
        }
        if ((bool1) || (isKnoxShortcut(paramIntent))) {
          break;
        }
        return null;
      }
    }
    localHomeShortcutItem = new HomeShortcutItem(BaseItem.Type.HOME_APPLICATION);
    if (localObject == null)
    {
      paramPackageManager = null;
      localHomeShortcutItem.packageName = paramPackageManager;
      paramPackageManager = new PkgResCache.TitleIconInfo();
      this.mPkgResCache.getTitleAndIcon(paramPackageManager, paramIntent);
      if (DEBUGGABLE) {
        Log.d("Launcher.Model", "info.mTitle = " + localHomeShortcutItem.mTitle);
      }
      if ((localHomeShortcutItem.mIconBitmap == null) && (paramCursor != null))
      {
        localHomeShortcutItem.mIconBitmap = getIconFromCursor(paramCursor, paramInt1, paramContext);
        if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE)
        {
          paramIntent = LauncherApplication.getInst().getThemeLoader();
          localObject = new AvailableShortcutWidgetListProvider(paramContext);
          if (localComponentName != null) {
            break label626;
          }
        }
      }
    }
    label626:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (localObject != null)
      {
        bool2 = bool1;
        if (localComponentName != null) {
          bool2 = ((AvailableWidgetListProvider)localObject).isShortcutWidget(localComponentName.getClassName());
        }
      }
      if ((!paramIntent.isUseDefaultTheme()) && (!bool2)) {
        localHomeShortcutItem.mIconBitmap = paramIntent.load3rdAppIconBitmap(localHomeShortcutItem.mIconBitmap);
      }
      if (localHomeShortcutItem.mIconBitmap == null) {
        localHomeShortcutItem.mIconBitmap = paramPackageManager.mIcon;
      }
      if (localHomeShortcutItem.mIconBitmap == null)
      {
        localHomeShortcutItem.mIconBitmap = getFallbackIcon();
        localHomeShortcutItem.usingFallbackIcon = true;
      }
      if ((localHomeShortcutItem.mTitle == null) && (paramCursor != null))
      {
        if (DEBUGGABLE) {
          Log.d("Launcher.Model", "info.mTitle from DB = " + localHomeShortcutItem.mTitle);
        }
        localHomeShortcutItem.mTitle = paramCursor.getString(paramInt2);
      }
      if (localHomeShortcutItem.mTitle == null) {
        localHomeShortcutItem.mTitle = paramPackageManager.mTitle;
      }
      if (localHomeShortcutItem.mTitle == null)
      {
        if (DEBUGGABLE) {
          Log.d("Launcher.Model", "info.mTitle from PM = " + localHomeShortcutItem.mTitle);
        }
        localHomeShortcutItem.mTitle = localComponentName.getClassName();
      }
      if (paramCursor != null)
      {
        paramPackageManager = paramCursor.getString(paramCursor.getColumnIndexOrThrow("iconMovieUri"));
        if (paramPackageManager != null)
        {
          localHomeShortcutItem.mIconMovieUri = Uri.parse(paramPackageManager);
          loadShortcutMovie(paramContext, localHomeShortcutItem);
        }
      }
      localHomeShortcutItem.mBadgeCount = this.mBadgeCache.getBadgeCount(localComponentName);
      return localHomeShortcutItem;
      paramPackageManager = ((ResolveInfo)localObject).activityInfo.packageName;
      break;
    }
  }
  
  protected HomeShortcutItem getShortcutInfoExtra(PackageManager paramPackageManager, Intent paramIntent, Context paramContext, Cursor paramCursor, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Log.i("Launcher.Model", "getShortcutInfo");
    ComponentName localComponentName = paramIntent.getComponent();
    if (DEBUGGABLE) {
      Log.i("Launcher.Model", "getShortcutInfo componentName=" + localComponentName);
    }
    Object localObject = paramPackageManager.resolveActivity(paramIntent, 0);
    if (DEBUGGABLE) {
      Log.i("Launcher.Model", "getShortcutInfo rInfo=" + localObject);
    }
    if (localObject == null)
    {
      if (localComponentName == null) {
        return null;
      }
      for (boolean bool = false;; bool = false)
      {
        try
        {
          int i = paramPackageManager.getApplicationInfo(localComponentName.getPackageName(), 8192).flags;
          if ((i & 0x40000) == 0) {
            continue;
          }
          bool = true;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          PkgResCache.TitleIconInfo localTitleIconInfo;
          for (;;) {}
        }
        if (DEBUGGABLE) {
          Log.i("Launcher.Model", "getShortcutInfo unmounted=" + bool);
        }
        if (bool) {
          break;
        }
        return null;
      }
    }
    localObject = new HomeShortcutItem();
    localTitleIconInfo = new PkgResCache.TitleIconInfo();
    this.mPkgResCache.getTitleAndIcon(localTitleIconInfo, paramIntent);
    if (DEBUGGABLE) {
      Log.d("Launcher.Model", "info.mTitle = " + ((HomeShortcutItem)localObject).mTitle);
    }
    switch (paramCursor.getInt(paramInt1))
    {
    default: 
      ((HomeShortcutItem)localObject).mIconBitmap = localTitleIconInfo.mIcon;
      if (((HomeShortcutItem)localObject).mIconBitmap == null)
      {
        ((HomeShortcutItem)localObject).mIconBitmap = getFallbackIcon();
        ((HomeShortcutItem)localObject).usingFallbackIcon = true;
        ((HomeShortcutItem)localObject).customIcon = false;
      }
      break;
    }
    for (;;)
    {
      if (((HomeShortcutItem)localObject).mTitle == null)
      {
        if (DEBUGGABLE) {
          Log.d("Launcher.Model", "info.mTitle from DB = " + ((HomeShortcutItem)localObject).mTitle);
        }
        ((HomeShortcutItem)localObject).mTitle = paramCursor.getString(paramInt5);
      }
      if (((HomeShortcutItem)localObject).mTitle == null) {
        ((HomeShortcutItem)localObject).mTitle = localTitleIconInfo.mTitle;
      }
      if (((HomeShortcutItem)localObject).mTitle == null)
      {
        if (DEBUGGABLE) {
          Log.d("Launcher.Model", "info.mTitle from PM = " + ((HomeShortcutItem)localObject).mTitle);
        }
        ((HomeShortcutItem)localObject).mTitle = localComponentName.getClassName();
      }
      paramPackageManager = paramCursor.getString(paramCursor.getColumnIndexOrThrow("iconMovieUri"));
      if (paramPackageManager != null)
      {
        ((HomeShortcutItem)localObject).mIconMovieUri = Uri.parse(paramPackageManager);
        loadShortcutMovie(paramContext, (HomeShortcutItem)localObject);
      }
      ((HomeShortcutItem)localObject).mBadgeCount = this.mBadgeCache.getBadgeCount(localComponentName);
      return (HomeShortcutItem)localObject;
      String str = paramCursor.getString(paramInt2);
      paramIntent = paramCursor.getString(paramInt3);
      ((HomeShortcutItem)localObject).customIcon = false;
      try
      {
        paramPackageManager = paramPackageManager.getResourcesForApplication(str);
        paramInt1 = paramPackageManager.getIdentifier(paramIntent, null, null);
        if (paramInt1 != 0) {
          ((HomeShortcutItem)localObject).mIconBitmap = this.mPkgResCache.loadBitmap(paramPackageManager, paramInt1, paramIntent);
        }
      }
      catch (PackageManager.NameNotFoundException paramPackageManager)
      {
        for (;;) {}
      }
      if (((HomeShortcutItem)localObject).mIconBitmap == null) {
        ((HomeShortcutItem)localObject).mIconBitmap = getIconFromCursor(paramCursor, paramInt4, paramContext);
      }
      if (((HomeShortcutItem)localObject).mIconBitmap == null) {
        ((HomeShortcutItem)localObject).mIconBitmap = localTitleIconInfo.mIcon;
      }
      if (((HomeShortcutItem)localObject).mIconBitmap == null)
      {
        ((HomeShortcutItem)localObject).mIconBitmap = getFallbackIcon();
        ((HomeShortcutItem)localObject).usingFallbackIcon = true;
        continue;
        ((HomeShortcutItem)localObject).mIconBitmap = getIconFromCursor(paramCursor, paramInt4, paramContext);
        if (((HomeShortcutItem)localObject).mIconBitmap == null) {
          ((HomeShortcutItem)localObject).mIconBitmap = localTitleIconInfo.mIcon;
        }
        if (((HomeShortcutItem)localObject).mIconBitmap == null)
        {
          ((HomeShortcutItem)localObject).mIconBitmap = getFallbackIcon();
          ((HomeShortcutItem)localObject).customIcon = false;
          ((HomeShortcutItem)localObject).usingFallbackIcon = true;
        }
        else
        {
          ((HomeShortcutItem)localObject).customIcon = true;
        }
      }
    }
  }
  
  public boolean hasLocaleChanged()
  {
    synchronized (this.mLock)
    {
      boolean bool = hasLocaleChangedLocked();
      return bool;
    }
  }
  
  protected boolean hasLocaleChangedLocked()
  {
    Configuration localConfiguration = this.mApp.getResources().getConfiguration();
    if ((!this.mWorkspaceLoaded) || (!this.mAllAppsLoaded) || (this.mConfigMccWhenLoaded != localConfiguration.mcc) || (this.mConfigMncWhenLoaded != localConfiguration.mnc) || (!localConfiguration.locale.toString().equals(this.mLocaleWhenLoaded))) {}
    for (boolean bool = true;; bool = false)
    {
      if (DEBUGGABLE) {
        Log.d("Launcher.Model", " mWorkspaceLoaded:" + this.mWorkspaceLoaded + " mAllAppsLoaded:" + this.mAllAppsLoaded + " hasLocaleChangedLocked. mcc: " + this.mConfigMccWhenLoaded + "-->" + localConfiguration.mcc + "; mnc: " + this.mConfigMncWhenLoaded + "-->" + localConfiguration.mnc + "; locale: " + this.mLocaleWhenLoaded + "-->" + localConfiguration.locale.toString() + "; return: " + bool);
      }
      return bool;
    }
  }
  
  HomeShortcutItem infoFromShortcutIntent(Context paramContext, Intent paramIntent, Bitmap paramBitmap)
  {
    Intent localIntent = (Intent)paramIntent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
    String str = paramIntent.getStringExtra("android.intent.extra.shortcut.NAME");
    Object localObject1 = paramIntent.getParcelableExtra("android.intent.extra.shortcut.ICON");
    ComponentName localComponentName = null;
    boolean bool1 = false;
    Object localObject5 = null;
    Object localObject3 = null;
    boolean bool2;
    Object localObject4;
    if ((localObject1 instanceof Bitmap)) {
      if (LauncherApplication.isTabletLayout())
      {
        localObject1 = Utilities.createIconBitmap(new BitmapDrawable(this.mApp.getResources(), (Bitmap)localObject1), paramContext);
        bool2 = true;
        localObject4 = localObject3;
        label88:
        localObject5 = new HomeShortcutItem();
        if ((Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) && (bool2 == true) && (localObject1 != null)) {
          ((HomeShortcutItem)localObject5).setCustomIcon((Bitmap)localObject1);
        }
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          if (paramBitmap == null) {
            break label631;
          }
          localObject3 = paramBitmap;
        }
        label137:
        paramBitmap = (Bitmap)localObject3;
        if (Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE)
        {
          localObject1 = LauncherApplication.getInst().getThemeLoader();
          paramBitmap = new AvailableShortcutWidgetListProvider(paramContext);
          boolean bool3 = false;
          bool1 = bool3;
          if (localIntent != null)
          {
            bool1 = bool3;
            if (paramBitmap != null)
            {
              localComponentName = localIntent.getComponent();
              if (localComponentName != null) {
                break label646;
              }
            }
          }
        }
      }
    }
    label631:
    label646:
    for (bool1 = true;; bool1 = paramBitmap.isShortcutWidget(localComponentName.getClassName()))
    {
      Log.e("Launcher.Model", "infoFromShortcutIntent isWidgetShortcut : " + bool1);
      paramBitmap = (Bitmap)localObject3;
      if (!((ThemeLoader)localObject1).isUseDefaultTheme())
      {
        paramBitmap = (Bitmap)localObject3;
        if (!bool1) {
          paramBitmap = ((ThemeLoader)localObject1).load3rdAppIconBitmap((Bitmap)localObject3);
        }
      }
      ((HomeShortcutItem)localObject5).setIcon(paramBitmap);
      ((HomeShortcutItem)localObject5).mIconMovieUri = ((Uri)paramIntent.getParcelableExtra("photoUri"));
      if (((HomeShortcutItem)localObject5).mIconMovieUri != null) {
        loadShortcutMovie(paramContext, (HomeShortcutItem)localObject5);
      }
      ((HomeShortcutItem)localObject5).mTitle = str;
      ((HomeShortcutItem)localObject5).intent = localIntent;
      ((HomeShortcutItem)localObject5).customIcon = bool2;
      ((HomeShortcutItem)localObject5).iconResource = ((Intent.ShortcutIconResource)localObject4);
      if (DEBUGGABLE) {
        Log.d("Launcher.Model", "title: " + str + ", intent: " + localIntent + ", customIcon: " + bool2 + ", iconResource: " + localObject4);
      }
      if (localIntent != null)
      {
        paramContext = localIntent.getComponent();
        if (paramContext != null) {
          ((HomeShortcutItem)localObject5).mBadgeCount = this.mBadgeCache.getBadgeCount(paramContext);
        }
      }
      return (HomeShortcutItem)localObject5;
      localObject1 = Utilities.createIconBitmap((Bitmap)localObject1, paramContext);
      break;
      Parcelable localParcelable = paramIntent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE");
      bool2 = bool1;
      localObject1 = localComponentName;
      localObject4 = localObject3;
      if (localParcelable == null) {
        break label88;
      }
      bool2 = bool1;
      localObject1 = localComponentName;
      localObject4 = localObject3;
      if (!(localParcelable instanceof Intent.ShortcutIconResource)) {
        break label88;
      }
      localObject3 = localObject5;
      try
      {
        localObject5 = (Intent.ShortcutIconResource)localParcelable;
        localObject3 = localObject5;
        Resources localResources = paramContext.getPackageManager().getResourcesForApplication(((Intent.ShortcutIconResource)localObject5).packageName);
        localObject3 = localObject5;
        int i = localResources.getIdentifier(((Intent.ShortcutIconResource)localObject5).resourceName, null, null);
        bool2 = bool1;
        localObject1 = localComponentName;
        localObject4 = localObject5;
        if (i == 0) {
          break label88;
        }
        localObject3 = localObject5;
        localObject1 = this.mPkgResCache.loadBitmap(localResources, i, ((Intent.ShortcutIconResource)localObject5).resourceName);
        bool2 = bool1;
        localObject4 = localObject5;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        bool2 = bool1;
        localObject2 = localComponentName;
        localObject4 = localObject3;
      }
      if (!DEBUGGABLE) {
        break label88;
      }
      Log.w("Launcher.Model", "Could not load shortcut icon: " + localParcelable);
      bool2 = bool1;
      Object localObject2 = localComponentName;
      localObject4 = localObject3;
      break label88;
      localObject3 = getFallbackIcon();
      ((HomeShortcutItem)localObject5).usingFallbackIcon = true;
      break label137;
    }
  }
  
  public void initialize(Callbacks paramCallbacks)
  {
    synchronized (this.mLock)
    {
      this.mCallbacks = new WeakReference(paramCallbacks);
      if (hasLocaleChangedLocked())
      {
        MenuAppModel.INSTANCE.onLocaleChanged();
        Log.d("Launcher.Model", "MenuAppModel.onLocaleChanged called");
      }
      return;
    }
  }
  
  /* Error */
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: getstatic 159	com/android/launcher2/LauncherModel:DEBUGGABLE	Z
    //   3: ifeq +29 -> 32
    //   6: ldc 99
    //   8: new 480	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 481	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 1326
    //   18: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 581	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   31: pop
    //   32: aload_2
    //   33: invokevirtual 1084	android/content/Intent:getAction	()Ljava/lang/String;
    //   36: astore 11
    //   38: ldc_w 1328
    //   41: aload 11
    //   43: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifne +25 -> 71
    //   49: ldc_w 1330
    //   52: aload 11
    //   54: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifne +14 -> 71
    //   60: ldc_w 1332
    //   63: aload 11
    //   65: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifeq +884 -> 952
    //   71: aload_2
    //   72: invokevirtual 1336	android/content/Intent:getData	()Landroid/net/Uri;
    //   75: invokevirtual 1339	android/net/Uri:getSchemeSpecificPart	()Ljava/lang/String;
    //   78: astore 12
    //   80: aload 12
    //   82: ifnull +15 -> 97
    //   85: aload 12
    //   87: ldc_w 1341
    //   90: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq +4 -> 97
    //   96: return
    //   97: aload_2
    //   98: ldc_w 1343
    //   101: iconst_0
    //   102: invokevirtual 1347	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   105: istore 10
    //   107: iconst_0
    //   108: istore_3
    //   109: aload 12
    //   111: ifnull -15 -> 96
    //   114: aload 12
    //   116: invokevirtual 1350	java/lang/String:length	()I
    //   119: ifeq -23 -> 96
    //   122: ldc_w 1328
    //   125: aload 11
    //   127: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: ifeq +82 -> 212
    //   133: iconst_2
    //   134: istore_3
    //   135: iload_3
    //   136: ifeq -40 -> 96
    //   139: aload_0
    //   140: new 74	com/android/launcher2/LauncherModel$PackageUpdatedTask
    //   143: dup
    //   144: aload_0
    //   145: iload_3
    //   146: iconst_1
    //   147: anewarray 635	java/lang/String
    //   150: dup
    //   151: iconst_0
    //   152: aload 12
    //   154: aastore
    //   155: invokespecial 1353	com/android/launcher2/LauncherModel$PackageUpdatedTask:<init>	(Lcom/android/launcher2/LauncherModel;I[Ljava/lang/String;)V
    //   158: invokespecial 1355	com/android/launcher2/LauncherModel:enqueuePackageUpdated	(Lcom/android/launcher2/LauncherModel$PackageUpdatedTask;)V
    //   161: getstatic 1361	com/android/launcher2/SurfaceWidgetPackageManager:INST	Lcom/android/launcher2/SurfaceWidgetPackageManager;
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 1364	com/android/launcher2/SurfaceWidgetPackageManager:clearWidgets	()V
    //   169: getstatic 214	com/android/launcher2/LauncherModel:sSurfaceWidgets	Ljava/util/ArrayList;
    //   172: invokevirtual 530	java/util/ArrayList:size	()I
    //   175: istore 4
    //   177: iconst_0
    //   178: istore_3
    //   179: iload_3
    //   180: iload 4
    //   182: if_icmpge -86 -> 96
    //   185: aload_0
    //   186: getfield 270	com/android/launcher2/LauncherModel:mLoaderTask	Lcom/android/launcher2/LauncherModel$LoaderTask;
    //   189: ifnull +707 -> 896
    //   192: aload_0
    //   193: getfield 270	com/android/launcher2/LauncherModel:mLoaderTask	Lcom/android/launcher2/LauncherModel$LoaderTask;
    //   196: invokevirtual 1367	com/android/launcher2/LauncherModel$LoaderTask:isLaunching	()Z
    //   199: ifeq +697 -> 896
    //   202: ldc 99
    //   204: ldc_w 1369
    //   207: invokestatic 504	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   210: pop
    //   211: return
    //   212: ldc_w 1330
    //   215: aload 11
    //   217: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   220: ifeq +13 -> 233
    //   223: iload 10
    //   225: ifne -90 -> 135
    //   228: iconst_3
    //   229: istore_3
    //   230: goto -95 -> 135
    //   233: ldc_w 1332
    //   236: aload 11
    //   238: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   241: ifeq -106 -> 135
    //   244: iload 10
    //   246: ifne +645 -> 891
    //   249: aload_1
    //   250: ldc 89
    //   252: iconst_0
    //   253: invokevirtual 1373	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   256: astore 13
    //   258: aload_1
    //   259: invokevirtual 352	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   262: checkcast 354	com/android/launcher2/LauncherApplication
    //   265: invokevirtual 1374	com/android/launcher2/LauncherApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   268: astore 14
    //   270: aconst_null
    //   271: astore_2
    //   272: aload 14
    //   274: getstatic 633	com/android/launcher2/LauncherSettings$Favorites:CONTENT_URI	Landroid/net/Uri;
    //   277: aconst_null
    //   278: ldc_w 1376
    //   281: iconst_2
    //   282: anewarray 635	java/lang/String
    //   285: dup
    //   286: iconst_0
    //   287: bipush -100
    //   289: invokestatic 651	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   292: aastore
    //   293: dup
    //   294: iconst_1
    //   295: new 480	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 481	java/lang/StringBuilder:<init>	()V
    //   302: aload 12
    //   304: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: bipush 37
    //   309: invokevirtual 1379	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   312: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: aastore
    //   316: aconst_null
    //   317: invokevirtual 657	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   320: astore 11
    //   322: iconst_m1
    //   323: istore_3
    //   324: aload 11
    //   326: astore_2
    //   327: aload 11
    //   329: invokeinterface 664 1 0
    //   334: ifeq +509 -> 843
    //   337: aload 11
    //   339: astore_2
    //   340: aload 13
    //   342: invokeinterface 1385 1 0
    //   347: ldc_w 1387
    //   350: iconst_1
    //   351: invokeinterface 1393 3 0
    //   356: invokeinterface 1396 1 0
    //   361: pop
    //   362: aload 11
    //   364: astore_2
    //   365: aload 11
    //   367: aload 11
    //   369: ldc_w 777
    //   372: invokeinterface 661 2 0
    //   377: invokeinterface 669 2 0
    //   382: istore 4
    //   384: aload 11
    //   386: astore_2
    //   387: aload 11
    //   389: aload 11
    //   391: ldc_w 1398
    //   394: invokeinterface 661 2 0
    //   399: invokeinterface 669 2 0
    //   404: istore 5
    //   406: iload 5
    //   408: iconst_4
    //   409: if_icmpeq +22 -> 431
    //   412: iload 5
    //   414: sipush 900
    //   417: if_icmpeq +14 -> 431
    //   420: iload 4
    //   422: istore_3
    //   423: iload 5
    //   425: sipush 901
    //   428: if_icmpne -104 -> 324
    //   431: aload 11
    //   433: astore_2
    //   434: aload 11
    //   436: aload 11
    //   438: ldc_w 369
    //   441: invokeinterface 661 2 0
    //   446: invokeinterface 669 2 0
    //   451: istore_3
    //   452: aload 11
    //   454: astore_2
    //   455: aload 11
    //   457: aload 11
    //   459: ldc_w 1400
    //   462: invokeinterface 661 2 0
    //   467: invokeinterface 669 2 0
    //   472: pop
    //   473: aload 11
    //   475: astore_2
    //   476: aload 11
    //   478: aload 11
    //   480: ldc_w 639
    //   483: invokeinterface 661 2 0
    //   488: invokeinterface 669 2 0
    //   493: istore 6
    //   495: aload 11
    //   497: astore_2
    //   498: aload 11
    //   500: aload 11
    //   502: ldc_w 641
    //   505: invokeinterface 661 2 0
    //   510: invokeinterface 669 2 0
    //   515: istore 7
    //   517: aload 11
    //   519: astore_2
    //   520: aload 11
    //   522: aload 11
    //   524: ldc_w 636
    //   527: invokeinterface 661 2 0
    //   532: invokeinterface 669 2 0
    //   537: istore 8
    //   539: aload 11
    //   541: astore_2
    //   542: aload 11
    //   544: aload 11
    //   546: ldc_w 637
    //   549: invokeinterface 661 2 0
    //   554: invokeinterface 669 2 0
    //   559: istore 9
    //   561: aload 11
    //   563: astore_2
    //   564: aload 11
    //   566: aload 11
    //   568: ldc_w 1401
    //   571: invokeinterface 661 2 0
    //   576: invokeinterface 982 2 0
    //   581: ldc_w 1403
    //   584: invokevirtual 1407	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   587: iconst_1
    //   588: aaload
    //   589: astore 15
    //   591: aload 11
    //   593: astore_2
    //   594: new 687	android/content/Intent
    //   597: dup
    //   598: invokespecial 1408	android/content/Intent:<init>	()V
    //   601: astore 16
    //   603: aload 11
    //   605: astore_2
    //   606: aload 16
    //   608: ldc_w 1410
    //   611: invokevirtual 1414	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   614: pop
    //   615: aload 11
    //   617: astore_2
    //   618: aload 16
    //   620: ldc_w 1387
    //   623: iconst_1
    //   624: invokevirtual 1418	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   627: pop
    //   628: aload 11
    //   630: astore_2
    //   631: aload 16
    //   633: ldc_w 1420
    //   636: aload 12
    //   638: invokevirtual 1423	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   641: pop
    //   642: aload 11
    //   644: astore_2
    //   645: aload 16
    //   647: ldc_w 1425
    //   650: aload 15
    //   652: invokevirtual 1423	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   655: pop
    //   656: aload 11
    //   658: astore_2
    //   659: aload 16
    //   661: ldc_w 1427
    //   664: iload 5
    //   666: invokevirtual 1430	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   669: pop
    //   670: aload 11
    //   672: astore_2
    //   673: aload 16
    //   675: ldc_w 636
    //   678: iload 8
    //   680: invokevirtual 1430	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   683: pop
    //   684: aload 11
    //   686: astore_2
    //   687: aload 16
    //   689: ldc_w 637
    //   692: iload 9
    //   694: invokevirtual 1430	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   697: pop
    //   698: aload 11
    //   700: astore_2
    //   701: aload 16
    //   703: ldc_w 639
    //   706: iload 6
    //   708: invokevirtual 1430	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   711: pop
    //   712: aload 11
    //   714: astore_2
    //   715: aload 16
    //   717: ldc_w 641
    //   720: iload 7
    //   722: invokevirtual 1430	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   725: pop
    //   726: aload 11
    //   728: astore_2
    //   729: aload 16
    //   731: ldc_w 777
    //   734: iload 4
    //   736: invokevirtual 1430	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   739: pop
    //   740: aload 11
    //   742: astore_2
    //   743: aload_1
    //   744: iconst_0
    //   745: aload 16
    //   747: ldc_w 1431
    //   750: invokestatic 1437	android/app/PendingIntent:getBroadcast	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   753: astore 15
    //   755: aload 11
    //   757: astore_2
    //   758: aload 15
    //   760: invokevirtual 1440	android/app/PendingIntent:send	()V
    //   763: aload 11
    //   765: astore_2
    //   766: aload 14
    //   768: getstatic 633	com/android/launcher2/LauncherSettings$Favorites:CONTENT_URI	Landroid/net/Uri;
    //   771: new 480	java/lang/StringBuilder
    //   774: dup
    //   775: invokespecial 481	java/lang/StringBuilder:<init>	()V
    //   778: ldc_w 1442
    //   781: invokevirtual 487	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: iload_3
    //   785: invokevirtual 1236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   788: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: aconst_null
    //   792: invokevirtual 1446	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   795: pop
    //   796: iload 4
    //   798: istore_3
    //   799: goto -475 -> 324
    //   802: astore_1
    //   803: aload_2
    //   804: ifnull +18 -> 822
    //   807: aload_2
    //   808: invokeinterface 1449 1 0
    //   813: ifne +9 -> 822
    //   816: aload_2
    //   817: invokeinterface 682 1 0
    //   822: aload_1
    //   823: athrow
    //   824: astore 15
    //   826: aload 11
    //   828: astore_2
    //   829: ldc 99
    //   831: ldc_w 1451
    //   834: aload 15
    //   836: invokestatic 759	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   839: pop
    //   840: goto -77 -> 763
    //   843: iload_3
    //   844: iconst_m1
    //   845: if_icmpeq +19 -> 864
    //   848: aload 11
    //   850: astore_2
    //   851: aload_0
    //   852: iconst_1
    //   853: invokevirtual 1455	com/android/launcher2/LauncherModel:setRefreshRequired	(Z)V
    //   856: aload 11
    //   858: astore_2
    //   859: aload_0
    //   860: iconst_1
    //   861: invokevirtual 1458	com/android/launcher2/LauncherModel:startLoaderFromBackground	(Z)V
    //   864: aload 11
    //   866: ifnull +20 -> 886
    //   869: aload 11
    //   871: invokeinterface 1449 1 0
    //   876: ifne +10 -> 886
    //   879: aload 11
    //   881: invokeinterface 682 1 0
    //   886: iconst_1
    //   887: istore_3
    //   888: goto -753 -> 135
    //   891: iconst_2
    //   892: istore_3
    //   893: goto -758 -> 135
    //   896: getstatic 214	com/android/launcher2/LauncherModel:sSurfaceWidgets	Ljava/util/ArrayList;
    //   899: iload_3
    //   900: invokevirtual 534	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   903: checkcast 516	com/android/launcher2/SurfaceWidgetItem
    //   906: astore_2
    //   907: aload_1
    //   908: aload_2
    //   909: invokevirtual 1459	com/android/launcher2/SurfaceWidgetItem:getComponentName	()Landroid/content/ComponentName;
    //   912: aload_2
    //   913: invokevirtual 1462	com/android/launcher2/SurfaceWidgetItem:getThemName	()Ljava/lang/String;
    //   916: invokevirtual 1466	com/android/launcher2/SurfaceWidgetPackageManager:findWidget	(Landroid/content/ComponentName;Ljava/lang/String;)Lcom/samsung/surfacewidget/SurfaceWidgetProviderInfo;
    //   919: astore 11
    //   921: aload 11
    //   923: ifnull +22 -> 945
    //   926: aload_2
    //   927: getfield 1470	com/android/launcher2/SurfaceWidgetItem:mInfo	Lcom/samsung/surfacewidget/SurfaceWidgetProviderInfo;
    //   930: ifnull +15 -> 945
    //   933: aload_2
    //   934: getfield 1470	com/android/launcher2/SurfaceWidgetItem:mInfo	Lcom/samsung/surfacewidget/SurfaceWidgetProviderInfo;
    //   937: aload 11
    //   939: getfield 1475	com/samsung/surfacewidget/SurfaceWidgetProviderInfo:resizeMode	I
    //   942: putfield 1475	com/samsung/surfacewidget/SurfaceWidgetProviderInfo:resizeMode	I
    //   945: iload_3
    //   946: iconst_1
    //   947: iadd
    //   948: istore_3
    //   949: goto -770 -> 179
    //   952: ldc_w 1477
    //   955: aload 11
    //   957: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   960: ifeq +30 -> 990
    //   963: aload_2
    //   964: ldc_w 1479
    //   967: invokevirtual 1482	android/content/Intent:getStringArrayExtra	(Ljava/lang/String;)[Ljava/lang/String;
    //   970: astore_1
    //   971: aload_1
    //   972: ifnull -876 -> 96
    //   975: aload_0
    //   976: new 74	com/android/launcher2/LauncherModel$PackageUpdatedTask
    //   979: dup
    //   980: aload_0
    //   981: iconst_4
    //   982: aload_1
    //   983: invokespecial 1353	com/android/launcher2/LauncherModel$PackageUpdatedTask:<init>	(Lcom/android/launcher2/LauncherModel;I[Ljava/lang/String;)V
    //   986: invokespecial 1355	com/android/launcher2/LauncherModel:enqueuePackageUpdated	(Lcom/android/launcher2/LauncherModel$PackageUpdatedTask;)V
    //   989: return
    //   990: ldc_w 1484
    //   993: aload 11
    //   995: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   998: ifeq +30 -> 1028
    //   1001: aload_2
    //   1002: ldc_w 1479
    //   1005: invokevirtual 1482	android/content/Intent:getStringArrayExtra	(Ljava/lang/String;)[Ljava/lang/String;
    //   1008: astore_1
    //   1009: aload_1
    //   1010: ifnull -914 -> 96
    //   1013: aload_0
    //   1014: new 74	com/android/launcher2/LauncherModel$PackageUpdatedTask
    //   1017: dup
    //   1018: aload_0
    //   1019: iconst_5
    //   1020: aload_1
    //   1021: invokespecial 1353	com/android/launcher2/LauncherModel$PackageUpdatedTask:<init>	(Lcom/android/launcher2/LauncherModel;I[Ljava/lang/String;)V
    //   1024: invokespecial 1355	com/android/launcher2/LauncherModel:enqueuePackageUpdated	(Lcom/android/launcher2/LauncherModel$PackageUpdatedTask;)V
    //   1027: return
    //   1028: ldc_w 1486
    //   1031: aload 11
    //   1033: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1036: ifeq +16 -> 1052
    //   1039: aload_0
    //   1040: invokevirtual 1488	com/android/launcher2/LauncherModel:hasLocaleChanged	()Z
    //   1043: ifeq -947 -> 96
    //   1046: aload_0
    //   1047: iconst_0
    //   1048: invokevirtual 1458	com/android/launcher2/LauncherModel:startLoaderFromBackground	(Z)V
    //   1051: return
    //   1052: ldc_w 1490
    //   1055: aload 11
    //   1057: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1060: ifne +14 -> 1074
    //   1063: ldc_w 1492
    //   1066: aload 11
    //   1068: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1071: ifeq +32 -> 1103
    //   1074: aload_0
    //   1075: getfield 846	com/android/launcher2/LauncherModel:mCallbacks	Ljava/lang/ref/WeakReference;
    //   1078: ifnull -982 -> 96
    //   1081: aload_0
    //   1082: getfield 846	com/android/launcher2/LauncherModel:mCallbacks	Ljava/lang/ref/WeakReference;
    //   1085: invokevirtual 850	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1088: checkcast 36	com/android/launcher2/LauncherModel$Callbacks
    //   1091: astore_1
    //   1092: aload_1
    //   1093: ifnull -997 -> 96
    //   1096: aload_1
    //   1097: invokeinterface 1495 1 0
    //   1102: return
    //   1103: aload 11
    //   1105: ldc_w 1497
    //   1108: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1111: ifeq +3 -> 1114
    //   1114: invokestatic 1502	com/sec/android/app/CscFeature:getInstance	()Lcom/sec/android/app/CscFeature;
    //   1117: ldc_w 1504
    //   1120: invokevirtual 1505	com/sec/android/app/CscFeature:getEnableStatus	(Ljava/lang/String;)Z
    //   1123: ifeq +20 -> 1143
    //   1126: ldc_w 1507
    //   1129: aload 11
    //   1131: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1134: ifeq +9 -> 1143
    //   1137: aload_0
    //   1138: iconst_1
    //   1139: invokevirtual 1458	com/android/launcher2/LauncherModel:startLoaderFromBackground	(Z)V
    //   1142: return
    //   1143: ldc_w 1509
    //   1146: aload 11
    //   1148: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1151: ifeq -1055 -> 96
    //   1154: getstatic 159	com/android/launcher2/LauncherModel:DEBUGGABLE	Z
    //   1157: ifeq +12 -> 1169
    //   1160: ldc 99
    //   1162: ldc_w 1511
    //   1165: invokestatic 581	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1168: pop
    //   1169: invokestatic 1502	com/sec/android/app/CscFeature:getInstance	()Lcom/sec/android/app/CscFeature;
    //   1172: ldc_w 1513
    //   1175: invokevirtual 1505	com/sec/android/app/CscFeature:getEnableStatus	(Ljava/lang/String;)Z
    //   1178: istore 10
    //   1180: invokestatic 1502	com/sec/android/app/CscFeature:getInstance	()Lcom/sec/android/app/CscFeature;
    //   1183: ldc_w 1515
    //   1186: invokevirtual 1517	com/sec/android/app/CscFeature:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1189: astore_1
    //   1190: ldc_w 1519
    //   1193: aconst_null
    //   1194: invokestatic 1524	android/os/SystemProperties:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1197: astore 11
    //   1199: aload_1
    //   1200: ifnull +20 -> 1220
    //   1203: aload_1
    //   1204: invokevirtual 1350	java/lang/String:length	()I
    //   1207: ifle +13 -> 1220
    //   1210: aload_1
    //   1211: ldc_w 1526
    //   1214: invokevirtual 715	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1217: ifeq -1121 -> 96
    //   1220: aload 11
    //   1222: ifnull -1126 -> 96
    //   1225: aload 11
    //   1227: invokevirtual 1350	java/lang/String:length	()I
    //   1230: ifle -1134 -> 96
    //   1233: aload_2
    //   1234: invokevirtual 1336	android/content/Intent:getData	()Landroid/net/Uri;
    //   1237: invokevirtual 1339	android/net/Uri:getSchemeSpecificPart	()Ljava/lang/String;
    //   1240: astore_1
    //   1241: aload_1
    //   1242: ifnull -1146 -> 96
    //   1245: aload_1
    //   1246: invokevirtual 1350	java/lang/String:length	()I
    //   1249: ifeq -1153 -> 96
    //   1252: iload 10
    //   1254: ifeq +37 -> 1291
    //   1257: aload_0
    //   1258: new 74	com/android/launcher2/LauncherModel$PackageUpdatedTask
    //   1261: dup
    //   1262: aload_0
    //   1263: iconst_2
    //   1264: iconst_2
    //   1265: anewarray 635	java/lang/String
    //   1268: dup
    //   1269: iconst_0
    //   1270: aload_1
    //   1271: aastore
    //   1272: dup
    //   1273: iconst_1
    //   1274: ldc_w 1099
    //   1277: aastore
    //   1278: invokespecial 1353	com/android/launcher2/LauncherModel$PackageUpdatedTask:<init>	(Lcom/android/launcher2/LauncherModel;I[Ljava/lang/String;)V
    //   1281: invokespecial 1355	com/android/launcher2/LauncherModel:enqueuePackageUpdated	(Lcom/android/launcher2/LauncherModel$PackageUpdatedTask;)V
    //   1284: getstatic 1361	com/android/launcher2/SurfaceWidgetPackageManager:INST	Lcom/android/launcher2/SurfaceWidgetPackageManager;
    //   1287: invokevirtual 1364	com/android/launcher2/SurfaceWidgetPackageManager:clearWidgets	()V
    //   1290: return
    //   1291: aload_0
    //   1292: new 74	com/android/launcher2/LauncherModel$PackageUpdatedTask
    //   1295: dup
    //   1296: aload_0
    //   1297: iconst_2
    //   1298: iconst_1
    //   1299: anewarray 635	java/lang/String
    //   1302: dup
    //   1303: iconst_0
    //   1304: aload_1
    //   1305: aastore
    //   1306: invokespecial 1353	com/android/launcher2/LauncherModel$PackageUpdatedTask:<init>	(Lcom/android/launcher2/LauncherModel;I[Ljava/lang/String;)V
    //   1309: invokespecial 1355	com/android/launcher2/LauncherModel:enqueuePackageUpdated	(Lcom/android/launcher2/LauncherModel$PackageUpdatedTask;)V
    //   1312: goto -28 -> 1284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1315	0	this	LauncherModel
    //   0	1315	1	paramContext	Context
    //   0	1315	2	paramIntent	Intent
    //   108	841	3	i	int
    //   175	622	4	j	int
    //   404	261	5	k	int
    //   493	214	6	m	int
    //   515	206	7	n	int
    //   537	142	8	i1	int
    //   559	134	9	i2	int
    //   105	1148	10	bool	boolean
    //   36	1190	11	localObject1	Object
    //   78	559	12	str	String
    //   256	85	13	localSharedPreferences	SharedPreferences
    //   268	499	14	localContentResolver	ContentResolver
    //   589	170	15	localObject2	Object
    //   824	11	15	localCanceledException	android.app.PendingIntent.CanceledException
    //   601	145	16	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   272	322	802	finally
    //   327	337	802	finally
    //   340	362	802	finally
    //   365	384	802	finally
    //   387	406	802	finally
    //   434	452	802	finally
    //   455	473	802	finally
    //   476	495	802	finally
    //   498	517	802	finally
    //   520	539	802	finally
    //   542	561	802	finally
    //   564	591	802	finally
    //   594	603	802	finally
    //   606	615	802	finally
    //   618	628	802	finally
    //   631	642	802	finally
    //   645	656	802	finally
    //   659	670	802	finally
    //   673	684	802	finally
    //   687	698	802	finally
    //   701	712	802	finally
    //   715	726	802	finally
    //   729	740	802	finally
    //   743	755	802	finally
    //   758	763	802	finally
    //   766	796	802	finally
    //   829	840	802	finally
    //   851	856	802	finally
    //   859	864	802	finally
    //   758	763	824	android/app/PendingIntent$CanceledException
  }
  
  protected boolean queueIconToBeChecked(HashMap<Object, byte[]> paramHashMap, HomeShortcutItem paramHomeShortcutItem, Cursor paramCursor, int paramInt)
  {
    if (!this.mAppsCanBeOnExternalStorage) {}
    while ((paramHomeShortcutItem.customIcon) || (paramHomeShortcutItem.usingFallbackIcon)) {
      return false;
    }
    paramHashMap.put(paramHomeShortcutItem, paramCursor.getBlob(paramInt));
    return true;
  }
  
  public void reloadBadges()
  {
    Log.d("Launcher.Model", "reloadBadges entered.");
    Runnable local11 = new Runnable()
    {
      public void run()
      {
        final Object localObject = LauncherModel.this.mBadgeCache.updateBadgeCounts();
        final List localList;
        final WeakReference localWeakReference;
        if (!((Map)localObject).isEmpty())
        {
          if (LauncherModel.DEBUGGABLE) {
            Log.d("Launcher.Model", "reloadBadges, badges count : " + ((Map)localObject).size());
          }
          localList = LauncherModel.this.mMenuAppLoader.updateBadgeCounts((Map)localObject);
          localObject = LauncherModel.this.mHomeLoader.updateBadgeCounts(LauncherModel.sHomeItemIdMap, (Map)localObject);
          if ((!localList.isEmpty()) || (!((List)localObject).isEmpty()))
          {
            localWeakReference = LauncherModel.this.mCallbacks;
            Log.d("Launcher.Model", "reloadBadges, origCallbacks : " + localWeakReference);
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              break label154;
            }
            Log.w("Launcher.Model", "Nobody to tell about new badge counts. Launcher is not running.");
          }
        }
        return;
        label154:
        LauncherModel.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            LauncherModel.Callbacks localCallbacks = (LauncherModel.Callbacks)LauncherModel.this.mCallbacks.get();
            if ((localCallbacks != null) && (localCallbacks == localWeakReference.get()))
            {
              Log.d("Launcher.Model", "reloadBadges, bindBadgeUpdated !");
              localCallbacks.bindBadgeUpdated(localList, localObject);
            }
          }
        });
      }
    };
    if (sWorkerThread.getThreadId() == Process.myTid())
    {
      local11.run();
      return;
    }
    sWorker.post(local11);
  }
  
  public HomeItem setCallAppItem(HomeView paramHomeView, HomeItem paramHomeItem, String paramString1, String paramString2)
  {
    HomeShortcutItem localHomeShortcutItem = new HomeShortcutItem(paramHomeItem.mType);
    Intent localIntent = new Intent();
    paramString1 = new ComponentName(paramString1, paramString2);
    localIntent.setAction("android.intent.action.MAIN").setComponent(paramString1).addCategory("android.intent.category.LAUNCHER").setFlags(270532608);
    paramString1 = new PkgResCache.TitleIconInfo();
    paramHomeView.getPkgResCache().getTitleAndIcon(paramString1, localIntent);
    localHomeShortcutItem.mIconBitmap = paramString1.mIcon;
    localHomeShortcutItem.mTitle = paramString1.mTitle;
    localHomeShortcutItem.intent = localIntent;
    localHomeShortcutItem.mId = paramHomeItem.mId;
    localHomeShortcutItem.mScreen = paramHomeItem.mScreen;
    localHomeShortcutItem.cellX = paramHomeItem.cellX;
    localHomeShortcutItem.cellY = paramHomeItem.cellY;
    localHomeShortcutItem.container = paramHomeItem.container;
    return localHomeShortcutItem;
  }
  
  protected void setLocaleLocked()
  {
    Configuration localConfiguration = this.mApp.getResources().getConfiguration();
    this.mConfigMccWhenLoaded = localConfiguration.mcc;
    this.mConfigMncWhenLoaded = localConfiguration.mnc;
    this.mLocaleWhenLoaded = localConfiguration.locale.toString();
    if (DEBUGGABLE) {
      Log.d("Launcher.Model", "setLocaleLocked. mcc: " + this.mConfigMccWhenLoaded + "; mnc: " + this.mConfigMncWhenLoaded + "; locale: " + this.mLocaleWhenLoaded);
    }
  }
  
  public void setRefreshRequired(boolean paramBoolean)
  {
    this.mRefreshRequired = paramBoolean;
  }
  
  public void startLoader()
  {
    startLoader(true, false);
  }
  
  public void startLoader(boolean paramBoolean)
  {
    startLoader();
  }
  
  public void startLoaderFromBackground(boolean paramBoolean)
  {
    if (this.mCallbacks == null) {}
    for (??? = null; (??? != null) && (!((Callbacks)???).setLoadOnResume()); ??? = (Callbacks)this.mCallbacks.get())
    {
      startLoader(false, paramBoolean);
      return;
    }
    synchronized (this.mLock)
    {
      stopLoaderLocked();
      if (paramBoolean) {
        this.mRefreshRequired = true;
      }
      return;
    }
  }
  
  public void stopLoader()
  {
    synchronized (this.mLock)
    {
      if (this.mLoaderTask != null)
      {
        this.mWorkspaceLoaded = false;
        this.mLoaderTask.stopLocked();
      }
      return;
    }
  }
  
  protected boolean stopLoaderLocked()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    LoaderTask localLoaderTask = this.mLoaderTask;
    this.mLoaderTask = null;
    if (localLoaderTask != null)
    {
      bool1 = bool2;
      if (localLoaderTask.isLaunching()) {
        bool1 = true;
      }
      localLoaderTask.stopLocked();
    }
    return bool1;
  }
  
  public void unbindAllHomeItems()
  {
    sWorker.post(new Runnable()
    {
      public void run()
      {
        LauncherModel.this.unbindAllHomeItemsOnMainThread();
      }
    });
  }
  
  void unbindAllHomeItemsOnMainThread()
  {
    final ArrayList localArrayList = new ArrayList(sHomeItemIdMap.values());
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext()) {
          ((HomeItem)localIterator.next()).unbind();
        }
      }
    });
  }
  
  protected void updateHiddenAddButtonInHomeFolder(Map<Long, HomeFolderItem> paramMap)
  {
    Object localObject = this.mApp.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getString("HomeFolderIds", null);
    if ((localObject != null) && (paramMap != null))
    {
      localObject = ((String)localObject).split(":");
      int i = 0;
      while (i < localObject.length)
      {
        long l = Long.parseLong(localObject[i]);
        if (paramMap.containsKey(Long.valueOf(l))) {
          ((HomeFolderItem)paramMap.get(Long.valueOf(l))).setHiddenAddButton(true);
        }
        i += 1;
      }
    }
  }
  
  protected void updateSavedIcon(Context paramContext, HomeShortcutItem paramHomeShortcutItem, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        boolean bool = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length).sameAs(paramHomeShortcutItem.mIconBitmap);
        if (bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramArrayOfByte)
      {
        int i = 1;
        continue;
      }
      if (i != 0)
      {
        if (DEBUGGABLE) {
          Log.d("Launcher.Model", "going to save icon bitmap for info=" + paramHomeShortcutItem);
        }
        updateItemInDatabase(paramContext, paramHomeShortcutItem);
      }
      return;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public static abstract interface Callbacks
  {
    public abstract void bindAllAppsSecretMode();
    
    public abstract void bindAppsLoaded();
    
    public abstract void bindBadgeUpdated(List<AppItem> paramList, List<HomeItem> paramList1);
    
    public abstract void bindFestivalModeChange(boolean paramBoolean);
    
    public abstract void bindHomeAppWidget(HomeWidgetItem paramHomeWidgetItem);
    
    public abstract void bindHomeBegin();
    
    public abstract void bindHomeDeleteFestivalPage(List<HomeWidgetItem> paramList);
    
    public abstract void bindHomeDeleteSecretPage();
    
    public abstract void bindHomeEnd();
    
    public abstract void bindHomeFolders(Map<Long, HomeFolderItem> paramMap);
    
    public abstract void bindHomeInsertFestivalPage();
    
    public abstract void bindHomeInsertSecretPage();
    
    public abstract void bindHomeItemsRemoved(List<HomeItem> paramList);
    
    public abstract void bindHomeItemsUpdated(List<HomeItem> paramList);
    
    public abstract void bindHomeSamsungWidget(SamsungWidgetItem paramSamsungWidgetItem);
    
    public abstract void bindHomeShortcuts(List<HomeItem> paramList, int paramInt1, int paramInt2);
    
    public abstract void bindHomeSurfaceWidget(SurfaceWidgetItem paramSurfaceWidgetItem);
    
    public abstract void bindHotseatItems(List<HomeItem> paramList);
    
    public abstract void bindModeChange();
    
    public abstract void bindPackagesChanged(boolean paramBoolean);
    
    public abstract void bindSearchablesChanged();
    
    public abstract void bindSecretModeChange(boolean paramBoolean);
    
    public abstract boolean setLoadOnResume();
  }
  
  private class LoaderTask
    implements Runnable
  {
    private boolean mIsLaunching;
    private boolean mStep1Finished;
    private volatile boolean mStopped;
    
    LoaderTask(boolean paramBoolean)
    {
      this.mIsLaunching = paramBoolean;
    }
    
    private void bindWorkspace()
    {
      final long l = SystemClock.uptimeMillis();
      if (getLoaderTaskCallbacks() == null)
      {
        Log.w("Launcher.Model", "LoaderTask running with no launcher");
        return;
      }
      LauncherModel.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          LauncherModel.Callbacks localCallbacks = LauncherModel.LoaderTask.this.getLoaderTaskCallbacks();
          if (localCallbacks != null) {
            localCallbacks.bindHomeBegin();
          }
        }
      });
      final Object localObject1 = new ArrayList(LauncherModel.sHomeItems.size());
      final Object localObject2 = new ArrayList();
      Object localObject3 = LauncherModel.this.mApp.getApplicationContext().getResources();
      final int i = 0;
      final int j = Math.max(((Resources)localObject3).getInteger(2131492901), ((Resources)localObject3).getInteger(2131492902));
      localObject3 = LauncherModel.sHomeItems.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        HomeItem localHomeItem = (HomeItem)((Iterator)localObject3).next();
        if ((localHomeItem.container == -101L) && (i < j - 1))
        {
          ((List)localObject2).add(localHomeItem);
          i += 1;
        }
        else if (localHomeItem.container == -100L)
        {
          ((List)localObject1).add(localHomeItem);
        }
      }
      LauncherModel.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          LauncherModel.Callbacks localCallbacks = LauncherModel.LoaderTask.this.getLoaderTaskCallbacks();
          if (localCallbacks != null) {
            localCallbacks.bindHotseatItems(localObject2);
          }
        }
      });
      int k = ((List)localObject1).size();
      i = 0;
      if (i < k)
      {
        if (i + 6 <= k) {}
        for (j = 6;; j = k - i)
        {
          LauncherModel.this.mHandler.post(new Runnable()
          {
            public void run()
            {
              LauncherModel.Callbacks localCallbacks = LauncherModel.LoaderTask.this.getLoaderTaskCallbacks();
              if (localCallbacks != null) {
                localCallbacks.bindHomeShortcuts(localObject1, i, i + j);
              }
            }
          });
          i += 6;
          break;
        }
      }
      localObject1 = new HashMap(LauncherModel.sHomeFolders);
      LauncherModel.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          LauncherModel.Callbacks localCallbacks = LauncherModel.LoaderTask.this.getLoaderTaskCallbacks();
          if (localCallbacks != null) {
            localCallbacks.bindHomeFolders(localObject1);
          }
        }
      });
      LauncherModel.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          Log.d("Launcher.Model", "Going to start binding widgets soon.");
        }
      });
      localObject1 = LauncherModel.sAppWidgets.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HomeWidgetItem)((Iterator)localObject1).next();
        if (((HomeWidgetItem)localObject2).mScreen == 0) {
          LauncherModel.this.mHandler.post(new Runnable()
          {
            public void run()
            {
              LauncherModel.Callbacks localCallbacks = LauncherModel.LoaderTask.this.getLoaderTaskCallbacks();
              if (localCallbacks != null) {
                localCallbacks.bindHomeAppWidget(localObject2);
              }
            }
          });
        }
      }
      localObject1 = LauncherModel.sAppWidgets.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HomeWidgetItem)((Iterator)localObject1).next();
        if (((HomeWidgetItem)localObject2).mScreen != 0) {
          LauncherModel.this.mHandler.post(new Runnable()
          {
            public void run()
            {
              LauncherModel.Callbacks localCallbacks = LauncherModel.LoaderTask.this.getLoaderTaskCallbacks();
              if (localCallbacks != null) {
                localCallbacks.bindHomeAppWidget(localObject2);
              }
            }
          });
        }
      }
      localObject1 = LauncherModel.sSamsungWidgets.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SamsungWidgetItem)((Iterator)localObject1).next();
        LauncherModel.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            LauncherModel.Callbacks localCallbacks = LauncherModel.LoaderTask.this.getLoaderTaskCallbacks();
            if (localCallbacks != null) {
              localCallbacks.bindHomeSamsungWidget(localObject2);
            }
          }
        });
      }
      localObject1 = LauncherModel.sSurfaceWidgets.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SurfaceWidgetItem)((Iterator)localObject1).next();
        LauncherModel.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            LauncherModel.Callbacks localCallbacks = LauncherModel.LoaderTask.this.getLoaderTaskCallbacks();
            if (localCallbacks != null) {
              localCallbacks.bindHomeSurfaceWidget(localObject2);
            }
          }
        });
      }
      LauncherModel.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          LauncherModel.Callbacks localCallbacks = LauncherModel.LoaderTask.this.getLoaderTaskCallbacks();
          if (localCallbacks != null) {
            localCallbacks.bindHomeEnd();
          }
        }
      });
      LauncherModel.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          Log.d("Launcher.Model", "bound workspace in " + (SystemClock.uptimeMillis() - l) + "ms");
        }
      });
    }
    
    private boolean checkItemPlacement(HomeItem[][][] paramArrayOfHomeItem, HomeItem paramHomeItem)
    {
      int k = paramHomeItem.mScreen;
      if (paramHomeItem.container == -101L)
      {
        i = LauncherApplication.getMaxScreenCount();
        if (paramArrayOfHomeItem[i][paramHomeItem.mScreen][0] != null)
        {
          if (LauncherModel.DEBUGGABLE) {
            Log.e("Launcher.Model", "Error loading shortcut into hotseat " + paramHomeItem + " into position (" + paramHomeItem.mScreen + ":" + paramHomeItem.cellX + "," + paramHomeItem.cellY + ") occupied by " + paramArrayOfHomeItem[i][paramHomeItem.mScreen][0]);
          }
          return false;
        }
        paramArrayOfHomeItem[i][paramHomeItem.mScreen][0] = paramHomeItem;
        return true;
      }
      if (paramHomeItem.container != -100L) {
        return true;
      }
      int i = paramHomeItem.cellX;
      int j;
      for (;;)
      {
        if (i >= paramHomeItem.cellX + paramHomeItem.spanX) {
          break label313;
        }
        j = paramHomeItem.cellY;
        for (;;)
        {
          if (j >= paramHomeItem.cellY + paramHomeItem.spanY) {
            break label306;
          }
          if (paramArrayOfHomeItem[k][i][j] != null)
          {
            if (!LauncherModel.DEBUGGABLE) {
              break;
            }
            Log.e("Launcher.Model", "Error loading shortcut " + paramHomeItem + " into cell (" + k + "-" + paramHomeItem.mScreen + ":" + i + "," + j + ") occupied by " + paramArrayOfHomeItem[k][i][j]);
            return false;
          }
          j += 1;
        }
        label306:
        i += 1;
      }
      label313:
      i = paramHomeItem.cellX;
      while (i < paramHomeItem.cellX + paramHomeItem.spanX)
      {
        j = paramHomeItem.cellY;
        while (j < paramHomeItem.cellY + paramHomeItem.spanY)
        {
          paramArrayOfHomeItem[k][i][j] = paramHomeItem;
          j += 1;
        }
        i += 1;
      }
      return true;
    }
    
    private LauncherModel.Callbacks getLoaderTaskCallbacks()
    {
      LauncherModel.Callbacks localCallbacks = null;
      synchronized (LauncherModel.this.mLock)
      {
        if (!this.mStopped) {
          localCallbacks = (LauncherModel.Callbacks)LauncherModel.this.mCallbacks.get();
        }
        return localCallbacks;
      }
    }
    
    private void loadAllApps()
    {
      final Map localMap = LauncherModel.this.mMenuAppLoader.loadAllItems(false);
      if ((!this.mStopped) && (localMap != null))
      {
        LauncherModel.this.mAllAppsLoaded = true;
        LauncherModel.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            MenuAppModel.INSTANCE.setModelItems(localMap);
            Log.d("Launcher.Model", "MenuAppModel.setModelItems called");
          }
        });
      }
    }
    
    private void loadAndBindAllApps()
    {
      Log.d("Launcher.Model", "loadAndBindAllApps mAllAppsLoaded: " + LauncherModel.this.mAllAppsLoaded + ", mRefreshRequired: " + LauncherModel.this.mRefreshRequired);
      if (!LauncherModel.this.mAllAppsLoaded)
      {
        loadAllApps();
        if (getLoaderTaskCallbacks() == null) {
          Log.w("Launcher.Model", "LoaderTask aborted or running with no launcher (bindAllApps)");
        }
      }
      do
      {
        do
        {
          return;
          LauncherModel.this.mHandler.post(new Runnable()
          {
            public void run()
            {
              LauncherModel.Callbacks localCallbacks = LauncherModel.LoaderTask.this.getLoaderTaskCallbacks();
              if (localCallbacks != null) {
                localCallbacks.bindAppsLoaded();
              }
            }
          });
          return;
        } while (!LauncherModel.this.mRefreshRequired);
        LauncherModel.this.mMenuAppLoader.refreshAllApps();
      } while (this.mStopped);
      postModelRefreshed();
    }
    
    private void loadAndBindWorkspace()
    {
      Log.d("Launcher.Model", "loadAndBindWorkspace mWorkspaceLoaded: " + LauncherModel.this.mWorkspaceLoaded + ", mRefreshRequired: " + LauncherModel.this.mRefreshRequired);
      LauncherModel.this.unbindAllHomeItemsOnMainThread();
      if ((!LauncherModel.this.mWorkspaceLoaded) || (LauncherModel.this.mRefreshRequired))
      {
        LauncherModel.sHomeItems.clear();
        LauncherModel.sAppWidgets.clear();
        LauncherModel.sSamsungWidgets.clear();
        LauncherModel.sSurfaceWidgets.clear();
        LauncherModel.sHomeFolders.clear();
        LauncherModel.sHomeItemIdMap.clear();
        LauncherModel.sDbIconCache.clear();
        loadWorkspace();
        if (!this.mStopped) {
          break label146;
        }
        LauncherModel.sDbIconCache.clear();
      }
      for (;;)
      {
        if (!this.mStopped) {
          bindWorkspace();
        }
        return;
        label146:
        LauncherModel.this.mWorkspaceLoaded = true;
      }
    }
    
    private void loadWorkspace()
    {
      long l1 = SystemClock.uptimeMillis();
      ContentResolver localContentResolver = LauncherModel.this.mApp.getContentResolver();
      PackageManager localPackageManager = LauncherModel.this.mApp.getPackageManager();
      AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(LauncherModel.this.mApp);
      boolean bool1 = localPackageManager.isSafeMode();
      ArrayList localArrayList = new ArrayList();
      Cursor localCursor = localContentResolver.query(LauncherSettings.Favorites.CONTENT_URI(), null, null, null, null);
      int m = LauncherApplication.getMaxScreenCount();
      HomeItem[][][] arrayOfHomeItem = (HomeItem[][][])Array.newInstance(HomeItem.class, new int[] { m + 1, LauncherModel.sCellCountX + 1, LauncherModel.sCellCountY + 1 });
      int i = 0;
      for (;;)
      {
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int j;
        Object localObject5;
        long l2;
        try
        {
          n = localCursor.getColumnIndexOrThrow("_id");
          i1 = localCursor.getColumnIndexOrThrow("intent");
          i2 = localCursor.getColumnIndexOrThrow("title");
          i3 = localCursor.getColumnIndexOrThrow("iconType");
          i4 = localCursor.getColumnIndexOrThrow("icon");
          i5 = localCursor.getColumnIndexOrThrow("iconPackage");
          i6 = localCursor.getColumnIndexOrThrow("iconResource");
          i7 = localCursor.getColumnIndexOrThrow("container");
          int i8 = localCursor.getColumnIndexOrThrow("itemType");
          i9 = localCursor.getColumnIndexOrThrow("appWidgetId");
          i10 = localCursor.getColumnIndexOrThrow("screen");
          i11 = localCursor.getColumnIndexOrThrow("cellX");
          i12 = localCursor.getColumnIndexOrThrow("cellY");
          i13 = localCursor.getColumnIndexOrThrow("spanX");
          i14 = localCursor.getColumnIndexOrThrow("spanY");
          i15 = localCursor.getColumnIndexOrThrow("color");
          if (this.mStopped) {
            break label2630;
          }
          boolean bool2 = localCursor.moveToNext();
          if (!bool2) {
            break label2630;
          }
          k = i;
          try
          {
            j = localCursor.getInt(i8);
            switch (j)
            {
            case 0: 
            case 1: 
              k = i;
              localObject1 = localCursor.getString(i1);
              k = i;
            }
          }
          catch (Exception localException)
          {
            Object localObject1;
            label673:
            i = k;
          }
        }
        finally
        {
          localCursor.close();
        }
        try
        {
          localObject5 = Intent.parseUri((String)localObject1, 0);
          if (bool1)
          {
            k = i;
            localObject1 = localPackageManager.resolveActivity((Intent)localObject5, 0);
            if (localObject1 == null) {
              continue;
            }
            k = i;
            if ((((ResolveInfo)localObject1).activityInfo.applicationInfo.flags & 0x1) == 0) {
              continue;
            }
          }
          if (j != 0) {
            break label770;
          }
          k = i;
          localObject1 = LauncherModel.this.getShortcutInfo(localPackageManager, (Intent)localObject5, LauncherModel.this.mApp, localCursor, i4, i2, -1);
          if (localObject1 == null) {
            break label956;
          }
          k = i;
          ((HomeShortcutItem)localObject1).intent = ((Intent)localObject5);
          k = i;
          ((HomeShortcutItem)localObject1).mId = localCursor.getLong(n);
          k = i;
          l2 = localCursor.getLong(i7);
          k = i;
          ((HomeShortcutItem)localObject1).container = l2;
          k = i;
          ((HomeShortcutItem)localObject1).mScreen = localCursor.getInt(i10);
          k = i;
          ((HomeShortcutItem)localObject1).cellX = localCursor.getInt(i11);
          k = i;
          ((HomeShortcutItem)localObject1).cellY = localCursor.getInt(i12);
          k = i;
          j = i;
          if (checkItemPlacement(arrayOfHomeItem, (HomeItem)localObject1)) {
            break label3005;
          }
          k = i;
          j = i;
          if (((HomeShortcutItem)localObject1).container != -101L) {
            break label3005;
          }
          k = i;
          Log.i("Launcher.Model", "wrong hotseat item : we remove the item in launcher.db - item=" + localObject1);
          k = i;
          localCursor.getLong(n);
          j = 1;
        }
        catch (URISyntaxException localURISyntaxException1) {}
        int k = j;
        LauncherModel.sHomeItems.add(localObject1);
        label684:
        k = j;
        LauncherModel.sHomeItemIdMap.put(Long.valueOf(((HomeShortcutItem)localObject1).mId), localObject1);
        k = j;
        LauncherModel.this.queueIconToBeChecked(LauncherModel.sDbIconCache, (HomeShortcutItem)localObject1, localCursor, i4);
        i = j;
        continue;
        if (LauncherModel.DEBUGGABLE)
        {
          Log.w("Launcher.Model", "Desktop items loading interrupted:", localException);
          i = k;
          continue;
          continue;
          label770:
          if (localObject5 != null)
          {
            k = i;
            if (((Intent)localObject5).getExtras() != null)
            {
              k = i;
              if (!((Intent)localObject5).getExtras().isEmpty())
              {
                k = i;
                if (LauncherModel.DEBUGGABLE)
                {
                  k = i;
                  Log.d("Launcher.Model", "loadWorkspace : intent.getExtras().isEmpty = " + ((Intent)localObject5).getExtras().isEmpty());
                  k = i;
                  Log.d("Launcher.Model", "loadWorkspace : intent.getExtras().isEmpty = " + localObject5);
                }
                k = i;
                localObject3 = LauncherModel.this.getShortcutInfoExtra(localPackageManager, (Intent)localObject5, LauncherModel.this.mApp, localCursor, i4, i2);
                continue;
              }
            }
          }
          k = i;
          Object localObject3 = LauncherModel.this.getShortcutInfo(localCursor, LauncherModel.this.mApp, i3, i5, i6, i4, i2, localPackageManager, (Intent)localObject5);
          continue;
          label956:
          label2105:
          label2630:
          label3005:
          do
          {
            k = j;
            LauncherModel.findOrMakeFolder(LauncherModel.sHomeFolders, l2).loadItem((HomeItem)localObject3);
            break label684;
            k = i;
            l2 = localCursor.getLong(n);
            k = i;
            localArrayList.add(Long.valueOf(l2));
            k = i;
            if (!LauncherModel.DEBUGGABLE) {
              break;
            }
            k = i;
            Log.e("Launcher.Model", "Error loading shortcut " + l2 + ", removing it");
            break;
            k = i;
            l2 = localCursor.getLong(n);
            k = i;
            localObject3 = LauncherModel.findOrMakeFolder(LauncherModel.sHomeFolders, l2);
            k = i;
            ((HomeFolderItem)localObject3).mTitle = localCursor.getString(i2);
            k = i;
            ((HomeFolderItem)localObject3).mId = l2;
            k = i;
            l2 = localCursor.getLong(i7);
            k = i;
            ((HomeFolderItem)localObject3).container = l2;
            k = i;
            ((HomeFolderItem)localObject3).mScreen = localCursor.getInt(i10);
            k = i;
            ((HomeFolderItem)localObject3).cellX = localCursor.getInt(i11);
            k = i;
            ((HomeFolderItem)localObject3).cellY = localCursor.getInt(i12);
            k = i;
            ((HomeFolderItem)localObject3).mColor = -1;
            k = i;
            if (LauncherApplication.sIsFolderColorSupport)
            {
              k = i;
              ((HomeFolderItem)localObject3).mColor = localCursor.getInt(i15);
            }
            k = i;
            if (!checkItemPlacement(arrayOfHomeItem, (HomeItem)localObject3)) {
              break;
            }
            if ((l2 == -100L) || (l2 == -101L))
            {
              k = i;
              LauncherModel.sHomeItems.add(localObject3);
            }
            k = i;
            LauncherModel.sHomeItemIdMap.put(Long.valueOf(((HomeFolderItem)localObject3).mId), localObject3);
            k = i;
            LauncherModel.sHomeFolders.put(Long.valueOf(((HomeFolderItem)localObject3).mId), localObject3);
            break;
            k = i;
            j = localCursor.getInt(i9);
            k = i;
            l2 = localCursor.getLong(n);
            k = i;
            Object localObject6 = localAppWidgetManager.getAppWidgetInfo(j);
            if ((!bool1) && (j != -1) && (localObject6 == null))
            {
              k = i;
              localObject3 = "Deleting widget that isn't installed anymore: id=" + l2 + " appWidgetId=" + j;
              k = i;
              if (LauncherModel.DEBUGGABLE)
              {
                k = i;
                Log.e("Launcher.Model", (String)localObject3);
              }
              k = i;
              HomeView.sDumpLogs.add(localObject3);
              k = i;
              localArrayList.add(Long.valueOf(l2));
              break;
            }
            localObject5 = null;
            localObject3 = localObject5;
            if (0 == 0)
            {
              localObject3 = localObject5;
              if (localObject6 != null)
              {
                k = i;
                localObject3 = new HomeWidgetItem((AppWidgetProviderInfo)localObject6, j);
              }
            }
            if (localObject3 == null) {
              break;
            }
            k = i;
            ((HomeWidgetItem)localObject3).mId = l2;
            k = i;
            ((HomeWidgetItem)localObject3).mScreen = localCursor.getInt(i10);
            k = i;
            ((HomeWidgetItem)localObject3).cellX = localCursor.getInt(i11);
            k = i;
            ((HomeWidgetItem)localObject3).cellY = localCursor.getInt(i12);
            k = i;
            ((HomeWidgetItem)localObject3).spanX = localCursor.getInt(i13);
            k = i;
            ((HomeWidgetItem)localObject3).spanY = localCursor.getInt(i14);
            k = i;
            localObject5 = localCursor.getString(i1);
            if (localObject5 != null)
            {
              k = i;
              localObject5 = localObject5.split(":")[0];
              k = i;
              localObject6 = AppWidgetManager.getInstance(LauncherModel.this.mApp.getApplicationContext());
              k = i;
              RemoteViews localRemoteViews = new RemoteViews(((HomeWidgetItem)localObject3).getPackageName(), 2130903049);
              k = i;
              localRemoteViews.setTextViewText(2131689521, localCursor.getString(i2));
              k = i;
              Intent localIntent = new Intent("android.intent.action.VIEW");
              k = i;
              localIntent.setData(Uri.parse("market://details?id=" + (String)localObject5));
              k = i;
              localIntent.putExtra("pkgName", (String)localObject5);
              k = i;
              localRemoteViews.setOnClickPendingIntent(2131689520, PendingIntent.getActivity(LauncherModel.this.mApp.getApplicationContext(), 0, localIntent, 0));
              k = i;
              ((AppWidgetManager)localObject6).updateAppWidget(j, localRemoteViews);
            }
            k = i;
            l2 = localCursor.getInt(i7);
            if ((l2 != -100L) && (l2 != -101L))
            {
              k = i;
              Log.e("Launcher.Model", "Widget found where container != CONTAINER_DESKTOP nor CONTAINER_HOTSEAT - ignoring!");
              break;
            }
            k = i;
            ((HomeWidgetItem)localObject3).container = localCursor.getInt(i7);
            k = i;
            if (!checkItemPlacement(arrayOfHomeItem, (HomeItem)localObject3)) {
              break;
            }
            k = i;
            LauncherModel.sHomeItemIdMap.put(Long.valueOf(((HomeWidgetItem)localObject3).mId), localObject3);
            k = i;
            LauncherModel.sAppWidgets.add(localObject3);
            if (0 == 0) {
              break;
            }
            k = i;
            LauncherModel.updateItemInDatabase(LauncherModel.this.mApp, (HomeItem)localObject3);
            break;
            k = i;
            localObject3 = new SamsungWidgetItem();
            k = i;
            l2 = localCursor.getLong(n);
            k = i;
            ((SamsungWidgetItem)localObject3).mId = l2;
            k = i;
            ((SamsungWidgetItem)localObject3).mScreen = localCursor.getInt(i10);
            k = i;
            ((SamsungWidgetItem)localObject3).cellX = localCursor.getInt(i11);
            k = i;
            ((SamsungWidgetItem)localObject3).cellY = localCursor.getInt(i12);
            k = i;
            ((SamsungWidgetItem)localObject3).spanX = localCursor.getInt(i13);
            k = i;
            ((SamsungWidgetItem)localObject3).spanY = localCursor.getInt(i14);
            k = i;
            ((SamsungWidgetItem)localObject3).widgetId = localCursor.getInt(i9);
            k = i;
            long l3 = localCursor.getInt(i7);
            if ((l3 != -100L) && (l3 != -101L))
            {
              k = i;
              Log.e("Launcher.Model", "Samsung Widget found where container != CONTAINER_DESKTOP nor CONTAINER_HOTSEAT - ignoring!");
              break;
            }
            k = i;
            ((SamsungWidgetItem)localObject3).container = localCursor.getInt(i7);
            k = i;
            localObject5 = localCursor.getString(i1);
            k = i;
            try
            {
              localObject5 = Intent.parseUri((String)localObject5, 0);
              k = i;
              ((SamsungWidgetItem)localObject3).intent = ((Intent)localObject5);
              k = i;
              localObject5 = localPackageManager.resolveActivity((Intent)localObject5, 0);
              if (localObject5 != null) {
                break label2105;
              }
              k = i;
              Log.e("Launcher.Model", "Can't resolve SamsungWidget's activity. Deleting it.");
              k = i;
              localArrayList.add(Long.valueOf(l2));
            }
            catch (URISyntaxException localURISyntaxException2) {}
            break;
            k = i;
            try
            {
              localPackageManager.getApplicationInfo(((ResolveInfo)localObject5).activityInfo.packageName, 0);
              k = i;
              if (!checkItemPlacement(arrayOfHomeItem, localURISyntaxException2)) {
                break;
              }
              k = i;
              LauncherModel.sHomeItemIdMap.put(Long.valueOf(localURISyntaxException2.mId), localURISyntaxException2);
              k = i;
              LauncherModel.sSamsungWidgets.add(localURISyntaxException2);
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException)
            {
              k = i;
              Log.e("Launcher.Model", "SamsungWidget's apk has move to sdcard and unmounted. Deleting it.");
              k = i;
              localArrayList.add(Long.valueOf(l2));
            }
            break;
            k = i;
            Object localObject4 = localCursor.getString(i1);
            k = i;
            try
            {
              localObject4 = Intent.parseUri((String)localObject4, 0);
              k = i;
              localObject5 = SurfaceWidgetPackageManager.INST.findWidget(((Intent)localObject4).getComponent(), ((Intent)localObject4).getExtras().getString("com.samsung.sec.android.SURFACE_WIDGET.themename"));
              k = i;
              l2 = localCursor.getLong(n);
              if (localObject5 == null)
              {
                k = i;
                Log.e("Launcher.Model", "SurfaceWidget-" + ((Intent)localObject4).getComponent() + "'s provider info could not be found. Deleting it.");
                k = i;
                localArrayList.add(Long.valueOf(l2));
                break;
              }
              k = i;
              localObject5 = new SurfaceWidgetItem();
              k = i;
              ((SurfaceWidgetItem)localObject5).mId = l2;
              k = i;
              ((SurfaceWidgetItem)localObject5).mScreen = localCursor.getInt(i10);
              k = i;
              ((SurfaceWidgetItem)localObject5).cellX = localCursor.getInt(i11);
              k = i;
              ((SurfaceWidgetItem)localObject5).cellY = localCursor.getInt(i12);
              k = i;
              ((SurfaceWidgetItem)localObject5).spanX = localCursor.getInt(i13);
              k = i;
              ((SurfaceWidgetItem)localObject5).spanY = localCursor.getInt(i14);
              k = i;
              ((SurfaceWidgetItem)localObject5).mWidgetId = localCursor.getInt(i9);
              k = i;
              ((SurfaceWidgetItem)localObject5).mThemeName = ((Intent)localObject4).getExtras().getString("com.samsung.sec.android.SURFACE_WIDGET.themename");
              k = i;
              l2 = localCursor.getInt(i7);
              if ((l2 != -100L) && (l2 != -101L))
              {
                k = i;
                Log.e("Launcher.Model", "Surface Widget found where container != CONTAINER_DESKTOP nor CONTAINER_HOTSEAT - ignoring!");
                break;
              }
              k = i;
              ((SurfaceWidgetItem)localObject5).container = localCursor.getInt(i7);
              k = i;
              ((SurfaceWidgetItem)localObject5).mComponentName = ((Intent)localObject4).getComponent();
              k = i;
              ((SurfaceWidgetItem)localObject5).mInstance = ((Intent)localObject4).getIntExtra("instance", -1);
              k = i;
              if (LauncherModel.DEBUGGABLE)
              {
                k = i;
                Log.d("Launcher.Model", "LauncherModel read out SurfaceWidgetItem mInstance = " + ((SurfaceWidgetItem)localObject5).mInstance);
              }
              k = i;
              if (!checkItemPlacement(arrayOfHomeItem, (HomeItem)localObject5)) {
                break;
              }
              k = i;
              LauncherModel.sHomeItemIdMap.put(Long.valueOf(((SurfaceWidgetItem)localObject5).mId), localObject5);
              k = i;
              LauncherModel.sSurfaceWidgets.add(localObject5);
            }
            catch (URISyntaxException localURISyntaxException3) {}
            localCursor.close();
            if (i != 0) {
              rearrangeHotseatData(LauncherModel.sHomeItems);
            }
            if (localArrayList.size() > 0)
            {
              localObject4 = localContentResolver.acquireContentProviderClient(LauncherSettings.Favorites.CONTENT_URI());
              localObject5 = localArrayList.iterator();
              while (((Iterator)localObject5).hasNext())
              {
                l2 = ((Long)((Iterator)localObject5).next()).longValue();
                Log.d("Launcher.Model", "Removed id = " + l2);
                if (localObject4 != null)
                {
                  try
                  {
                    ((ContentProviderClient)localObject4).delete(LauncherSettings.Favorites.getContentUri(l2, false), null, null);
                  }
                  catch (RemoteException localRemoteException) {}
                  if (LauncherModel.DEBUGGABLE) {
                    Log.w("Launcher.Model", "Could not remove id = " + l2);
                  }
                }
              }
            }
            Log.d("Launcher.Model", "loaded workspace in " + (SystemClock.uptimeMillis() - l1) + "ms");
            Log.d("Launcher.Model", "workspace layout: ");
            i = 0;
            while (i < LauncherModel.sCellCountY)
            {
              localObject4 = "";
              j = 0;
              while (j < m)
              {
                localObject5 = localObject4;
                if (j > 0) {
                  localObject5 = (String)localObject4 + " | ";
                }
                k = 0;
                localObject4 = localObject5;
                if (k < LauncherModel.sCellCountX)
                {
                  localObject5 = new StringBuilder().append((String)localObject4);
                  if (arrayOfHomeItem[j][k][i] != null) {}
                  for (localObject4 = "#";; localObject4 = ".")
                  {
                    localObject4 = (String)localObject4;
                    k += 1;
                    break;
                  }
                }
                j += 1;
              }
              Log.d("Launcher.Model", "[ " + (String)localObject4 + " ]");
              i += 1;
            }
            return;
            break;
            if (l2 == -100L) {
              break label673;
            }
          } while (l2 != -101L);
        }
      }
    }
    
    private void postModelRefreshed()
    {
      LauncherModel.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          if (!LauncherModel.LoaderTask.this.mStopped)
          {
            MenuAppModel.INSTANCE.onModelRefreshed();
            Log.d("Launcher.Model", "MenuAppModel.onModelRefreshed called");
            LauncherModel.Callbacks localCallbacks = LauncherModel.LoaderTask.this.getLoaderTaskCallbacks();
            if (localCallbacks != null)
            {
              localCallbacks.bindAppsLoaded();
              Log.d("Launcher.Model", "bindAppsLoaded called");
            }
          }
        }
      });
    }
    
    private void rearrangeHotseatData(ArrayList<HomeItem> paramArrayList)
    {
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int i = 0;
      while (i < paramArrayList.size())
      {
        int k = j;
        if (((HomeItem)paramArrayList.get(i)).container == -101L)
        {
          localArrayList.add(paramArrayList.get(i));
          ((HomeItem)localArrayList.get(j)).mScreen = j;
          LauncherModel.updateItemInDatabase(LauncherModel.this.mApp.getApplicationContext(), (HomeItem)localArrayList.get(j));
          k = j + 1;
        }
        i += 1;
        j = k;
      }
    }
    
    private void waitForIdle()
    {
      try
      {
        long l = SystemClock.uptimeMillis();
        LauncherModel.this.mHandler.postIdle(new Runnable()
        {
          public void run()
          {
            synchronized (LauncherModel.LoaderTask.this)
            {
              LauncherModel.LoaderTask.access$002(LauncherModel.LoaderTask.this, true);
              Log.d("Launcher.Model", "done with first binding step");
              LauncherModel.LoaderTask.this.notify();
              return;
            }
          }
        });
        while (!this.mStopped)
        {
          boolean bool = this.mStep1Finished;
          if (bool) {
            break;
          }
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException) {}
        }
        Log.d("Launcher.Model", "waited " + (SystemClock.uptimeMillis() - l) + "ms for previous step to finish binding");
        return;
      }
      finally {}
    }
    
    public void dumpState()
    {
      if (LauncherModel.DEBUGGABLE)
      {
        Log.d("Launcher.Model", "mLoaderTask.mIsLaunching=" + this.mIsLaunching);
        Log.d("Launcher.Model", "mLoaderTask.mStopped=" + this.mStopped);
        Log.d("Launcher.Model", "mLoaderTask.mStep1Finished=" + this.mStep1Finished);
        Log.d("Launcher.Model", "mItems size=" + LauncherModel.sHomeItems.size());
      }
    }
    
    boolean isLaunching()
    {
      return this.mIsLaunching;
    }
    
    public void run()
    {
      Log.d("Launcher.Model", "Begin LoaderTask: " + System.identityHashCode(this));
      if (this.mStopped)
      {
        Log.d("Launcher.Model", "Comparing loaded icons to database icons");
        ??? = LauncherModel.sDbIconCache.keySet().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = ((Iterator)???).next();
          LauncherModel.this.updateSavedIcon(LauncherModel.this.mApp, (HomeShortcutItem)localObject2, (byte[])LauncherModel.sDbIconCache.get(localObject2));
        }
      }
      Object localObject2 = new StringBuilder().append("Setting thread priority to ");
      if (this.mIsLaunching) {
        ??? = "DEFAULT";
      }
      for (;;)
      {
        Log.d("Launcher.Model", (String)???);
        synchronized (LauncherModel.this.mLock)
        {
          if (LauncherModel.UseLauncherHighPriority)
          {
            Process.setThreadPriority(-2);
            if ((!LauncherModel.this.mRefreshRequired) && (!LauncherModel.this.hasLocaleChangedLocked())) {
              break label345;
            }
            LauncherModel.this.setLocaleLocked();
            LauncherModel.this.mRefreshRequired = true;
            LauncherModel.this.mPkgResCache.clear();
            label209:
            Log.d("Launcher.Model", "step 1: loading workspace");
            loadAndBindWorkspace();
            if (this.mStopped) {
              break;
            }
            if (this.mIsLaunching) {
              Log.d("Launcher.Model", "Setting thread priority to BACKGROUND");
            }
          }
        }
        synchronized (LauncherModel.this.mLock)
        {
          if (LauncherModel.UseLauncherHighPriority)
          {
            Process.setThreadPriority(-2);
            waitForIdle();
            Log.d("Launcher.Model", "step 2: loading all apps");
            loadAndBindAllApps();
            synchronized (LauncherModel.this.mLock)
            {
              Process.setThreadPriority(0);
            }
            ??? = "BACKGROUND";
            continue;
            if (this.mIsLaunching) {}
            for (int i = 0;; i = 10)
            {
              Process.setThreadPriority(i);
              break;
              localObject4 = finally;
              throw ((Throwable)localObject4);
            }
            label345:
            if ((!LauncherModel.this.mAllAppsLoaded) || (LauncherModel.this.mRefreshRequired)) {
              break label209;
            }
            postModelRefreshed();
            break label209;
          }
          else
          {
            Process.setThreadPriority(10);
          }
        }
      }
      LauncherModel.sDbIconCache.clear();
      if (!this.mStopped)
      {
        LauncherModel.this.mRefreshRequired = false;
        LauncherModel.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            synchronized (LauncherModel.this.mLock)
            {
              if (LauncherModel.this.mLoaderTask == LauncherModel.LoaderTask.this)
              {
                LauncherModel.access$102(LauncherModel.this, null);
                Log.d("Launcher.Model", "Normal End LoaderTask: " + System.identityHashCode(LauncherModel.LoaderTask.this));
              }
              return;
            }
          }
        });
      }
    }
    
    public void stopLocked()
    {
      Log.d("Launcher.Model", "Stopping LoaderTask: " + System.identityHashCode(this));
      this.mStopped = true;
      LauncherModel.this.mMenuAppLoader.abortLoader();
      try
      {
        notify();
        return;
      }
      finally {}
    }
  }
  
  private class PackageUpdatedTask
    implements Runnable
  {
    public static final int OP_ADD = 1;
    public static final int OP_AVAILABLE = 4;
    public static final int OP_NONE = 0;
    public static final int OP_REMOVE = 3;
    public static final int OP_UNAVAILABLE = 5;
    public static final int OP_UPDATE = 2;
    int mOp;
    String[] mPackages;
    
    public PackageUpdatedTask(int paramInt, String[] paramArrayOfString)
    {
      this.mOp = paramInt;
      this.mPackages = paramArrayOfString;
    }
    
    public void run()
    {
      final Object localObject = this.mPackages;
      int j = localObject.length;
      final ArrayList localArrayList3 = new ArrayList();
      final ArrayList localArrayList4 = new ArrayList();
      final ArrayList localArrayList1;
      final ArrayList localArrayList2;
      int i;
      switch (this.mOp)
      {
      default: 
      case 1: 
      case 2: 
        for (;;)
        {
          localObject = null;
          localArrayList1 = null;
          localArrayList2 = null;
          if (LauncherModel.this.mMenuAppLoader.added.size() > 0)
          {
            localObject = LauncherModel.this.mMenuAppLoader.added;
            LauncherModel.this.mMenuAppLoader.added = new ArrayList();
          }
          if (LauncherModel.this.mMenuAppLoader.removed.size() > 0)
          {
            localArrayList1 = LauncherModel.this.mMenuAppLoader.removed;
            LauncherModel.this.mMenuAppLoader.removed = new ArrayList();
          }
          if (LauncherModel.this.mMenuAppLoader.modified.size() > 0)
          {
            localArrayList2 = LauncherModel.this.mMenuAppLoader.modified;
            LauncherModel.this.mMenuAppLoader.modified = new ArrayList();
          }
          if ((localObject != null) || (localArrayList1 != null)) {
            LauncherModel.this.mHandler.post(new Runnable()
            {
              public void run()
              {
                MenuAppModel.INSTANCE.appsAddedOrRemoved(localObject, localArrayList1);
              }
            });
          }
          if (localArrayList2 != null) {
            LauncherModel.this.mHandler.post(new Runnable()
            {
              public void run()
              {
                MenuAppModel.INSTANCE.appsUpdated(localArrayList2);
              }
            });
          }
          if (!LauncherModel.this.mRefreshRequired) {
            break;
          }
          return;
          i = 0;
          while (i < j)
          {
            if (LauncherModel.DEBUGGABLE) {
              Log.d("Launcher.Model", "mMenuAppLoader.updatePackage " + localObject[i]);
            }
            LauncherModel.this.mPkgResCache.removePackage(localObject[i]);
            if ((LauncherApplication.isMenuIconSizeChanged()) && (LauncherModel.this.mApp.getPkgResCacheForMenu() != null)) {
              LauncherModel.this.mApp.getPkgResCacheForMenu().removePackage(localObject[i]);
            }
            LauncherModel.this.mMenuAppLoader.updatePackage(localObject[i]);
            LauncherModel.this.mHomeLoader.updatePackage(LauncherModel.sHomeItemIdMap, localObject[i], localArrayList3, localArrayList4);
            i += 1;
          }
          if (LauncherModel.this.hasLocaleChanged()) {
            LauncherModel.this.startLoaderFromBackground(true);
          }
        }
      case 3: 
        i = 0;
        while (i < j)
        {
          if (LauncherModel.DEBUGGABLE) {
            Log.d("Launcher.Model", "mMenuAppLoader.removePackage " + localObject[i]);
          }
          LauncherModel.this.mPkgResCache.removePackage(localObject[i]);
          if ((LauncherApplication.isMenuIconSizeChanged()) && (LauncherModel.this.mApp.getPkgResCacheForMenu() != null)) {
            LauncherModel.this.mApp.getPkgResCacheForMenu().removePackage(localObject[i]);
          }
          LauncherModel.this.mMenuAppLoader.removePackage(localObject[i]);
          LauncherModel.this.mHomeLoader.removePackage(LauncherModel.sHomeItemIdMap, localObject[i], localArrayList3);
          i += 1;
        }
      }
      if (this.mOp == 4) {}
      for (final boolean bool = true;; bool = false)
      {
        i = 0;
        while (i < j)
        {
          if (LauncherModel.DEBUGGABLE) {
            Log.d("Launcher.Model", "mMenuAppLoader.updatePackageAvailability " + localObject[i] + " " + bool);
          }
          LauncherModel.this.mPkgResCache.removePackage(localObject[i]);
          if ((LauncherApplication.isMenuIconSizeChanged()) && (LauncherModel.this.mApp.getPkgResCacheForMenu() != null)) {
            LauncherModel.this.mApp.getPkgResCacheForMenu().removePackage(localObject[i]);
          }
          LauncherModel.this.mMenuAppLoader.updatePackageAvailability(localObject[i], bool);
          LauncherModel.this.mHomeLoader.updatePackageAvailability(LauncherModel.sHomeItemIdMap, localObject[i], bool, localArrayList3, localArrayList4);
          i += 1;
        }
        break;
      }
      final WeakReference localWeakReference = LauncherModel.this.mCallbacks;
      if ((localWeakReference == null) || (localWeakReference.get() == null))
      {
        Log.w("Launcher.Model", "Nobody to tell about the app changes. Launcher is not running.");
        return;
      }
      if (!localArrayList4.isEmpty()) {
        LauncherModel.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            LauncherModel.Callbacks localCallbacks = (LauncherModel.Callbacks)LauncherModel.this.mCallbacks.get();
            if ((localCallbacks != null) && (localCallbacks == localWeakReference.get())) {
              localCallbacks.bindHomeItemsUpdated(localArrayList4);
            }
          }
        });
      }
      if (!localArrayList3.isEmpty()) {
        LauncherModel.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            LauncherModel.Callbacks localCallbacks = (LauncherModel.Callbacks)LauncherModel.this.mCallbacks.get();
            if ((localCallbacks != null) && (localCallbacks == localWeakReference.get())) {
              localCallbacks.bindHomeItemsRemoved(localArrayList3);
            }
          }
        });
      }
      if ((localObject != null) || (localArrayList1 != null) || (localArrayList2 != null)) {}
      for (bool = true;; bool = false)
      {
        LauncherModel.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            LauncherModel.Callbacks localCallbacks = (LauncherModel.Callbacks)LauncherModel.this.mCallbacks.get();
            if ((localCallbacks != null) && (localCallbacks == localWeakReference.get())) {
              localCallbacks.bindPackagesChanged(bool);
            }
          }
        });
        return;
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/LauncherModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */