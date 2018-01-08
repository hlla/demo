package com.android.launcher2;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.util.secutil.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LauncherExModel
  extends LauncherModel
{
  public static final String ACTION_FESTIVAL_HOMESETTING_CHANGED = "com.sec.festival.FESTIVAL_HOME_CHANGED";
  public static final String ACTION_FESTIVAL_SETTING_CHANGED = "com.sec.festival.FESTIVAL_SETTINGS_CHANGED";
  public static final String ACTION_PICKUP_FESTIVAL_DAY = "com.bst.action.PICKUP_FESTIVAL";
  public static final String ACTION_PICKUP_FESTIVAL_DAY_OFF = "com.bst.action.PICKUP_COMMON";
  private static final String FESTIVAL_EFFECT_ENABLED = "festival_effect_enabled";
  private static final String FESTIVAL_EFFECT_HOME_ENABLED = "festival_effect_festival_home";
  public static final String INTENT_SECRET_MODE_OFF = "com.samsung.android.intent.action.PRIVATE_MODE_OFF";
  public static final String INTENT_SECRET_MODE_ON = "com.samsung.android.intent.action.PRIVATE_MODE_ON";
  public static final String INTENT_UPDATING_APPWDGET_COMPLETED = "com.samsung.android.intent.action.UPDATING_APPWIDGET_COMPLETED";
  private static final String TAG = "LauncherExModel";
  private boolean mIsCurrentFestivalMode = false;
  private boolean mIsCurrentSecretMode = false;
  private boolean mIsLoaderTaskRunning;
  private volatile LoaderTask mLoaderTask;
  private volatile boolean mRefreshRequiredInSecretModeChange = false;
  
  LauncherExModel(LauncherApplication paramLauncherApplication, PkgResCache paramPkgResCache)
  {
    super(paramLauncherApplication, paramPkgResCache);
  }
  
  private void runOnMainThread(Runnable paramRunnable)
  {
    if (sWorkerThread.getThreadId() == Process.myTid())
    {
      this.mHandler.post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  private static void runOnWorkerThread(Runnable paramRunnable)
  {
    if (sWorkerThread.getThreadId() == Process.myTid())
    {
      paramRunnable.run();
      return;
    }
    sWorker.post(paramRunnable);
  }
  
  private void startLoader(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    startLoader(true, false, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  /* Error */
  private void startLoader(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, final boolean paramBoolean5)
  {
    // Byte code:
    //   0: ldc 106
    //   2: new 195	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   9: ldc -57
    //   11: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: iload_1
    //   15: invokevirtual 206	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   18: ldc -48
    //   20: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_2
    //   24: invokevirtual 206	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: ldc -46
    //   29: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_3
    //   33: invokevirtual 206	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: ldc -44
    //   38: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload 4
    //   43: invokevirtual 206	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: ldc -42
    //   48: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload 5
    //   53: invokevirtual 206	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   56: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 224	android/util/secutil/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   62: pop
    //   63: aload_0
    //   64: getfield 228	com/android/launcher2/LauncherExModel:mLock	Ljava/lang/Object;
    //   67: astore 6
    //   69: aload 6
    //   71: monitorenter
    //   72: iload_2
    //   73: ifeq +8 -> 81
    //   76: aload_0
    //   77: iconst_1
    //   78: putfield 231	com/android/launcher2/LauncherExModel:mRefreshRequired	Z
    //   81: aload_0
    //   82: getfield 235	com/android/launcher2/LauncherExModel:mCallbacks	Ljava/lang/ref/WeakReference;
    //   85: ifnull +72 -> 157
    //   88: aload_0
    //   89: getfield 235	com/android/launcher2/LauncherExModel:mCallbacks	Ljava/lang/ref/WeakReference;
    //   92: invokevirtual 241	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   95: ifnull +62 -> 157
    //   98: aload_0
    //   99: new 10	com/android/launcher2/LauncherExModel$LoaderTask
    //   102: dup
    //   103: aload_0
    //   104: iload_1
    //   105: aload_0
    //   106: invokevirtual 245	com/android/launcher2/LauncherExModel:stopLoaderLocked	()Z
    //   109: ior
    //   110: iload_3
    //   111: iload 4
    //   113: iload 5
    //   115: invokespecial 248	com/android/launcher2/LauncherExModel$LoaderTask:<init>	(Lcom/android/launcher2/LauncherExModel;ZZZZ)V
    //   118: putfield 128	com/android/launcher2/LauncherExModel:mLoaderTask	Lcom/android/launcher2/LauncherExModel$LoaderTask;
    //   121: iload 4
    //   123: ifeq +38 -> 161
    //   126: aload_0
    //   127: getfield 251	com/android/launcher2/LauncherExModel:mAllAppsLoaded	Z
    //   130: ifeq +31 -> 161
    //   133: aload_0
    //   134: getfield 254	com/android/launcher2/LauncherExModel:mWorkspaceLoaded	Z
    //   137: ifeq +24 -> 161
    //   140: getstatic 183	com/android/launcher2/LauncherExModel:sWorker	Landroid/os/Handler;
    //   143: new 6	com/android/launcher2/LauncherExModel$1
    //   146: dup
    //   147: aload_0
    //   148: iload 5
    //   150: invokespecial 257	com/android/launcher2/LauncherExModel$1:<init>	(Lcom/android/launcher2/LauncherExModel;Z)V
    //   153: invokevirtual 188	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   156: pop
    //   157: aload 6
    //   159: monitorexit
    //   160: return
    //   161: getstatic 153	com/android/launcher2/LauncherExModel:sWorkerThread	Landroid/os/HandlerThread;
    //   164: iconst_5
    //   165: invokevirtual 261	android/os/HandlerThread:setPriority	(I)V
    //   168: getstatic 183	com/android/launcher2/LauncherExModel:sWorker	Landroid/os/Handler;
    //   171: aload_0
    //   172: getfield 128	com/android/launcher2/LauncherExModel:mLoaderTask	Lcom/android/launcher2/LauncherExModel$LoaderTask;
    //   175: invokevirtual 188	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   178: pop
    //   179: goto -22 -> 157
    //   182: astore 7
    //   184: aload 6
    //   186: monitorexit
    //   187: aload 7
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	LauncherExModel
    //   0	190	1	paramBoolean1	boolean
    //   0	190	2	paramBoolean2	boolean
    //   0	190	3	paramBoolean3	boolean
    //   0	190	4	paramBoolean4	boolean
    //   0	190	5	paramBoolean5	boolean
    //   67	118	6	localObject1	Object
    //   182	6	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   76	81	182	finally
    //   81	121	182	finally
    //   126	157	182	finally
    //   157	160	182	finally
    //   161	179	182	finally
    //   184	187	182	finally
  }
  
  public void dumpState()
  {
    Log.d("LauncherExModel", "mCallbacks=" + this.mCallbacks);
    AppItem.dumpApplicationInfoList("LauncherExModel", "mMainAppCache.added", this.mMenuAppLoader.added);
    AppItem.dumpApplicationInfoList("LauncherExModel", "mMainAppCache.removed", this.mMenuAppLoader.removed);
    AppItem.dumpApplicationInfoList("LauncherExModel", "mMainAppCache.modified", this.mMenuAppLoader.modified);
    LoaderTask localLoaderTask = this.mLoaderTask;
    if (localLoaderTask != null)
    {
      localLoaderTask.dumpState();
      return;
    }
    Log.d("LauncherExModel", "mLoaderTask=null");
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (("android.intent.action.PACKAGE_CHANGED".equals(str)) && (0 != 0)) {}
    label76:
    label147:
    label166:
    label334:
    label390:
    label439:
    label445:
    label450:
    label461:
    label467:
    do
    {
      int i;
      int j;
      do
      {
        boolean bool;
        do
        {
          do
          {
            do
            {
              return;
              super.onReceive(paramContext, paramIntent);
              if (!"com.samsung.android.intent.action.PRIVATE_MODE_ON".equals(str)) {
                break label390;
              }
              if (("com.samsung.android.intent.action.UPDATING_APPWIDGET_COMPLETED".equals(str)) && (0 != 0) && (!this.mIsCurrentSecretMode))
              {
                startLoader(true, true, false);
                if (this.mIsCurrentSecretMode) {
                  break label439;
                }
                bool = true;
                this.mIsCurrentSecretMode = bool;
              }
              if (("com.bst.action.PICKUP_COMMON".equals(str)) && (this.mIsCurrentFestivalMode))
              {
                startLoader(false, true, true);
                this.mIsCurrentFestivalMode = false;
                FestivalPageManager.setFestivalString(this.mApp, null);
              }
              if (!"com.bst.action.PICKUP_FESTIVAL".equals(str)) {
                break;
              }
              if (Settings.System.getInt(this.mApp.getContentResolver(), "festival_effect_enabled", 0) == 0) {
                break label445;
              }
              i = 1;
              if (Settings.System.getInt(this.mApp.getContentResolver(), "festival_effect_festival_home", 0) == 0) {
                break label450;
              }
              j = 1;
              paramContext = paramIntent.getStringExtra("festivalString");
              Log.i("LauncherExModel", "onReceive: currentFestivalString : " + paramContext + " mWorkspaceLoaded : " + this.mWorkspaceLoaded);
            } while ((i == 0) || (j == 0) || (!this.mWorkspaceLoaded));
            if (!this.mIsCurrentFestivalMode) {
              break;
            }
          } while (!FestivalPageManager.checkPrevFestivalStatus(paramContext));
          startLoader(false, true, true);
          this.mIsCurrentFestivalMode = false;
          FestivalPageManager.setFestivalString(this.mApp, null);
          if (!this.mIsCurrentFestivalMode)
          {
            startLoader(true, true, true);
            this.mIsCurrentFestivalMode = true;
            FestivalPageManager.setFestivalString(this.mApp, paramIntent.getStringExtra("festivalString"));
          }
        } while ((!"com.sec.festival.FESTIVAL_SETTINGS_CHANGED".equals(str)) && (!"com.sec.festival.FESTIVAL_HOME_CHANGED".equals(str)));
        if (Settings.System.getInt(this.mApp.getContentResolver(), "festival_effect_enabled", 0) != 0)
        {
          i = 1;
          if (Settings.System.getInt(this.mApp.getContentResolver(), "festival_effect_festival_home", 0) == 0) {
            break label461;
          }
        }
        for (j = 1;; j = 0)
        {
          if (((i != 0) && (j != 0)) || (!this.mIsCurrentFestivalMode)) {
            break label467;
          }
          startLoader(false, true, true);
          this.mIsCurrentFestivalMode = false;
          FestivalPageManager.setFestivalString(this.mApp, null);
          return;
          if ((!"com.samsung.android.intent.action.PRIVATE_MODE_OFF".equals(str)) || (!this.mIsCurrentSecretMode)) {
            break;
          }
          startLoader(false, true, false);
          if (!this.mIsCurrentSecretMode) {}
          for (bool = true;; bool = false)
          {
            this.mIsCurrentSecretMode = bool;
            break;
          }
          bool = false;
          break label76;
          i = 0;
          break label147;
          j = 0;
          break label166;
          i = 0;
          break label334;
        }
      } while ((i == 0) || (j == 0) || (this.mIsCurrentFestivalMode));
      paramContext = Settings.System.getString(this.mApp.getContentResolver(), "FestivalList");
    } while ((paramContext == null) || (paramContext.isEmpty()));
    startLoader(true, true, true);
    this.mIsCurrentFestivalMode = true;
    FestivalPageManager.setFestivalString(this.mApp, paramContext);
  }
  
  public void startLoader(boolean paramBoolean)
  {
    startLoader(true, false, paramBoolean, false, false);
  }
  
  public void startLoaderFromBackground(boolean paramBoolean)
  {
    if (this.mCallbacks == null) {}
    for (??? = null; (??? != null) && (!((LauncherModel.Callbacks)???).setLoadOnResume()); ??? = (LauncherModel.Callbacks)this.mCallbacks.get())
    {
      startLoader(false, paramBoolean, this.mIsCurrentSecretMode, false, false);
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
  
  public void updateHomeDataBase(boolean paramBoolean)
  {
    if (LauncherApplication.getSecretScreenCount() == 0) {
      return;
    }
    Object localObject2 = new ArrayList();
    final Object localObject1 = sHomeItemIdMap.keySet().iterator();
    HomeItem localHomeItem;
    while (((Iterator)localObject1).hasNext())
    {
      long l = ((Long)((Iterator)localObject1).next()).longValue();
      localHomeItem = (HomeItem)sHomeItemIdMap.get(Long.valueOf(l));
      if ((localHomeItem.container != -101L) && (localHomeItem.container <= 0L) && (!localHomeItem.mSecretItem)) {
        if (paramBoolean)
        {
          localHomeItem.mScreen += LauncherApplication.getSecretScreenCount();
          ((ArrayList)localObject2).add(localHomeItem);
        }
        else
        {
          localHomeItem.mScreen -= LauncherApplication.getSecretScreenCount();
          ((ArrayList)localObject2).add(localHomeItem);
        }
      }
    }
    localObject1 = new ArrayList(((ArrayList)localObject2).size());
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localHomeItem = (HomeItem)((Iterator)localObject2).next();
      LauncherSettings.FavoritePos localFavoritePos = new LauncherSettings.FavoritePos();
      localFavoritePos.id = localHomeItem.mId;
      localFavoritePos.screen = localHomeItem.mScreen;
      ((ArrayList)localObject1).add(localFavoritePos);
    }
    runOnWorkerThread(new Runnable()
    {
      public void run()
      {
        LauncherExModel.this.mApp.getLauncherProvider().updateScreenIdFavorites(localObject1);
      }
    });
  }
  
  private class LoaderTask
    implements Runnable
  {
    private final Comparator<Integer> PAGEINDEX_COMPARATOR = new Comparator()
    {
      public final int compare(Integer paramAnonymousInteger1, Integer paramAnonymousInteger2)
      {
        return paramAnonymousInteger1.intValue() - paramAnonymousInteger2.intValue();
      }
    };
    private volatile boolean mIsFestival;
    private volatile boolean mIsFestivalLoader;
    private volatile boolean mIsFestivalModeChanged;
    private boolean mIsLaunching;
    private volatile boolean mIsModeChanged;
    private volatile boolean mIsSecret;
    private boolean mStep1Finished;
    private volatile boolean mStopped;
    
    LoaderTask(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.mIsLaunching = paramBoolean1;
      Log.d("LauncherExModel", "LoaderTask isFestivalLoader: " + paramBoolean4);
      this.mIsFestivalLoader = paramBoolean4;
      if (paramBoolean4)
      {
        this.mIsFestival = paramBoolean2;
        this.mIsFestivalModeChanged = paramBoolean3;
        return;
      }
      this.mIsSecret = paramBoolean2;
      this.mIsModeChanged = paramBoolean3;
    }
    
    private void bindFestivalPageModeChange()
    {
      Runnable local26 = new Runnable()
      {
        public void run()
        {
          LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
          if (localCallbacks != null) {
            localCallbacks.bindFestivalModeChange(LauncherExModel.LoaderTask.this.mIsFestival);
          }
        }
      };
      LauncherExModel.this.runOnMainThread(local26);
    }
    
    private void bindFestivalWorkspace()
    {
      if (!this.mIsFestival)
      {
        if (getLoaderTaskCallbacks() == null) {
          return;
        }
        localObject = new Runnable()
        {
          public void run()
          {
            LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
            if (localCallbacks != null) {
              localCallbacks.bindHomeDeleteFestivalPage(null);
            }
          }
        };
        LauncherExModel.this.runOnMainThread((Runnable)localObject);
        return;
      }
      Object localObject = new Runnable()
      {
        public void run()
        {
          LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
          if (localCallbacks != null) {
            localCallbacks.bindHomeInsertFestivalPage();
          }
        }
      };
      LauncherExModel.this.runOnMainThread((Runnable)localObject);
    }
    
    private void bindSecretAllApps()
    {
      if (getLoaderTaskCallbacks() == null)
      {
        Log.w("LauncherExModel", "LoaderTask running with no launcher");
        return;
      }
      Runnable local25 = new Runnable()
      {
        public void run()
        {
          MenuAppModel.INSTANCE.normalizeModel(false);
          LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
          if (localCallbacks != null)
          {
            if ((LauncherExModel.this.mRefreshRequiredInSecretModeChange) && (LauncherExModel.LoaderTask.this.mIsSecret)) {
              LauncherExModel.this.mMenuAppLoader.refreshAllApps();
            }
            LauncherExModel.access$502(LauncherExModel.this, false);
            localCallbacks.bindAllAppsSecretMode();
          }
        }
      };
      LauncherExModel.this.runOnMainThread(local25);
    }
    
    private void bindSecretPageModeChange()
    {
      Runnable local17 = new Runnable()
      {
        public void run()
        {
          LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
          if (localCallbacks != null) {
            localCallbacks.bindSecretModeChange(LauncherExModel.LoaderTask.this.mIsSecret);
          }
        }
      };
      LauncherExModel.this.runOnMainThread(local17);
    }
    
    private void bindSecretWorkspace()
    {
      if (!this.mIsSecret)
      {
        if (getLoaderTaskCallbacks() == null) {
          return;
        }
        localObject1 = new Runnable()
        {
          public void run()
          {
            LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
            if (localCallbacks != null) {
              localCallbacks.bindHomeDeleteSecretPage();
            }
          }
        };
        LauncherExModel.this.runOnMainThread((Runnable)localObject1);
        return;
      }
      Object localObject1 = new Runnable()
      {
        public void run()
        {
          LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
          if (localCallbacks != null) {
            localCallbacks.bindHomeInsertSecretPage();
          }
        }
      };
      LauncherExModel.this.runOnMainThread((Runnable)localObject1);
      localObject1 = new ArrayList(LauncherModel.sHomeItems.size());
      Object localObject2 = LauncherModel.sHomeItems.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HomeItem)((Iterator)localObject2).next();
        if ((((HomeItem)localObject3).container == -100L) && (((HomeItem)localObject3).mSecretItem)) {
          ((List)localObject1).add(localObject3);
        }
      }
      localObject2 = new HashMap();
      Object localObject3 = LauncherModel.sHomeFolders.keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        long l = ((Long)((Iterator)localObject3).next()).longValue();
        localObject4 = (HomeFolderItem)LauncherModel.sHomeFolders.get(Long.valueOf(l));
        if (((HomeFolderItem)localObject4).mSecretItem) {
          ((HashMap)localObject2).put(Long.valueOf(l), localObject4);
        }
      }
      localObject3 = new ArrayList();
      Object localObject4 = LauncherModel.sAppWidgets.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (HomeWidgetItem)((Iterator)localObject4).next();
        if (((HomeWidgetItem)localObject5).mSecretItem) {
          ((List)localObject3).add(localObject5);
        }
      }
      localObject4 = new ArrayList();
      Object localObject5 = LauncherModel.sSamsungWidgets.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (SamsungWidgetItem)((Iterator)localObject5).next();
        if (((SamsungWidgetItem)localObject6).mSecretItem) {
          ((List)localObject4).add(localObject6);
        }
      }
      localObject5 = new ArrayList();
      Object localObject6 = LauncherModel.sSurfaceWidgets.iterator();
      while (((Iterator)localObject6).hasNext())
      {
        SurfaceWidgetItem localSurfaceWidgetItem = (SurfaceWidgetItem)((Iterator)localObject6).next();
        if (localSurfaceWidgetItem.mSecretItem) {
          ((List)localObject5).add(localSurfaceWidgetItem);
        }
      }
      bindSecretWorkspace((List)localObject1, (HashMap)localObject2, (List)localObject3, (List)localObject4, (List)localObject5);
    }
    
    private void bindSecretWorkspace(final List<HomeItem> paramList, final HashMap<Long, HomeFolderItem> paramHashMap, List<HomeWidgetItem> paramList1, List<SamsungWidgetItem> paramList2, List<SurfaceWidgetItem> paramList3)
    {
      if (getLoaderTaskCallbacks() == null) {
        Log.w("LauncherExModel", "bindSecretWorkspace running with no launcher");
      }
      for (;;)
      {
        return;
        int k = paramList.size();
        final int i = 0;
        if (i < k)
        {
          if (i + 6 <= k) {}
          for (final int j = 6;; j = k - i)
          {
            Runnable local18 = new Runnable()
            {
              public void run()
              {
                LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
                if (localCallbacks != null) {
                  localCallbacks.bindHomeShortcuts(paramList, i, i + j);
                }
              }
            };
            LauncherExModel.this.runOnMainThread(local18);
            i += 6;
            break;
          }
        }
        paramList = new Runnable()
        {
          public void run()
          {
            LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
            if (localCallbacks != null) {
              localCallbacks.bindHomeFolders(paramHashMap);
            }
          }
        };
        LauncherExModel.this.runOnMainThread(paramList);
        paramList = paramList1.iterator();
        while (paramList.hasNext())
        {
          paramHashMap = new Runnable()
          {
            public void run()
            {
              LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
              if (localCallbacks != null) {
                localCallbacks.bindHomeAppWidget(this.val$secretWidget);
              }
            }
          };
          LauncherExModel.this.runOnMainThread(paramHashMap);
        }
        paramList = paramList2.iterator();
        while (paramList.hasNext())
        {
          paramHashMap = new Runnable()
          {
            public void run()
            {
              LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
              if (localCallbacks != null) {
                localCallbacks.bindHomeSamsungWidget(this.val$secretWidget);
              }
            }
          };
          LauncherExModel.this.runOnMainThread(paramHashMap);
        }
        paramList = paramList3.iterator();
        while (paramList.hasNext())
        {
          paramHashMap = new Runnable()
          {
            public void run()
            {
              LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
              if (localCallbacks != null) {
                localCallbacks.bindHomeSurfaceWidget(this.val$secretWidget);
              }
            }
          };
          LauncherExModel.this.runOnMainThread(paramHashMap);
        }
      }
    }
    
    private void bindWorkspace()
    {
      final long l1 = SystemClock.uptimeMillis();
      if (getLoaderTaskCallbacks() == null)
      {
        Log.w("LauncherExModel", "LoaderTask running with no launcher");
        return;
      }
      Object localObject1 = new Runnable()
      {
        public void run()
        {
          LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
          if (localCallbacks != null) {
            localCallbacks.bindHomeBegin();
          }
        }
      };
      LauncherExModel.this.runOnMainThread((Runnable)localObject1);
      if (this.mIsSecret)
      {
        localObject1 = new Runnable()
        {
          public void run()
          {
            LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
            if (localCallbacks != null) {
              localCallbacks.bindHomeInsertSecretPage();
            }
          }
        };
        LauncherExModel.this.runOnMainThread((Runnable)localObject1);
      }
      final Object localObject2 = new ArrayList(LauncherModel.sHomeItems.size());
      final Object localObject3 = new ArrayList();
      localObject1 = new ArrayList();
      Object localObject4 = LauncherModel.sHomeItems.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (HomeItem)((Iterator)localObject4).next();
        if (((HomeItem)localObject5).mSecretItem) {
          ((List)localObject1).add(localObject5);
        } else if (((HomeItem)localObject5).container == -101L) {
          ((List)localObject3).add(localObject5);
        } else if (((HomeItem)localObject5).container == -100L) {
          ((List)localObject2).add(localObject5);
        }
      }
      localObject3 = new Runnable()
      {
        public void run()
        {
          LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
          if (localCallbacks != null) {
            localCallbacks.bindHotseatItems(localObject3);
          }
          Log.d("LauncherExModel", "bindWorkspace:: Callback to Bind hotseat");
        }
      };
      LauncherExModel.this.runOnMainThread((Runnable)localObject3);
      int k = ((List)localObject2).size();
      final int i = 0;
      if (i < k)
      {
        if (i + 6 <= k) {}
        for (final int j = 6;; j = k - i)
        {
          localObject3 = new Runnable()
          {
            public void run()
            {
              LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
              if (localCallbacks != null) {
                localCallbacks.bindHomeShortcuts(localObject2, i, i + j);
              }
            }
          };
          LauncherExModel.this.runOnMainThread((Runnable)localObject3);
          i += 6;
          break;
        }
      }
      localObject3 = new HashMap();
      localObject2 = new HashMap();
      localObject4 = LauncherModel.sHomeFolders.keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        long l2 = ((Long)((Iterator)localObject4).next()).longValue();
        localObject5 = (HomeFolderItem)LauncherModel.sHomeFolders.get(Long.valueOf(l2));
        if (((HomeFolderItem)localObject5).mSecretItem) {
          ((HashMap)localObject2).put(Long.valueOf(l2), localObject5);
        } else {
          ((HashMap)localObject3).put(Long.valueOf(l2), localObject5);
        }
      }
      localObject3 = new Runnable()
      {
        public void run()
        {
          LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
          if (localCallbacks != null)
          {
            HomeView.sFolders.clear();
            localCallbacks.bindHomeFolders(this.val$folders);
          }
        }
      };
      LauncherExModel.this.runOnMainThread((Runnable)localObject3);
      localObject3 = new Runnable()
      {
        public void run()
        {
          Log.d("LauncherExModel", "Going to start binding widgets soon.");
        }
      };
      LauncherExModel.this.runOnMainThread((Runnable)localObject3);
      localObject3 = new ArrayList();
      localObject4 = new ArrayList();
      Object localObject5 = LauncherModel.sAppWidgets.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (HomeWidgetItem)((Iterator)localObject5).next();
        if (((HomeWidgetItem)localObject6).mScreen == 0) {
          if (((HomeWidgetItem)localObject6).mSecretItem)
          {
            ((List)localObject3).add(localObject6);
          }
          else if (((HomeWidgetItem)localObject6).mFestivalType > 0)
          {
            ((List)localObject4).add(localObject6);
          }
          else
          {
            localObject6 = new Runnable()
            {
              public void run()
              {
                LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
                if (localCallbacks != null) {
                  localCallbacks.bindHomeAppWidget(localObject6);
                }
              }
            };
            LauncherExModel.this.runOnMainThread((Runnable)localObject6);
          }
        }
      }
      localObject5 = LauncherModel.sAppWidgets.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (HomeWidgetItem)((Iterator)localObject5).next();
        if (((HomeWidgetItem)localObject6).mScreen != 0) {
          if (((HomeWidgetItem)localObject6).mSecretItem)
          {
            ((List)localObject3).add(localObject6);
          }
          else if (((HomeWidgetItem)localObject6).mFestivalType > 0)
          {
            ((List)localObject4).add(localObject6);
          }
          else
          {
            localObject6 = new Runnable()
            {
              public void run()
              {
                LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
                if (localCallbacks != null) {
                  localCallbacks.bindHomeAppWidget(localObject6);
                }
              }
            };
            LauncherExModel.this.runOnMainThread((Runnable)localObject6);
          }
        }
      }
      localObject5 = new ArrayList();
      final Object localObject6 = LauncherModel.sSamsungWidgets.iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (SamsungWidgetItem)((Iterator)localObject6).next();
        if (((SamsungWidgetItem)localObject7).mSecretItem)
        {
          ((List)localObject5).add(localObject7);
        }
        else
        {
          localObject7 = new Runnable()
          {
            public void run()
            {
              LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
              if (localCallbacks != null) {
                localCallbacks.bindHomeSamsungWidget(localObject7);
              }
            }
          };
          LauncherExModel.this.runOnMainThread((Runnable)localObject7);
        }
      }
      localObject6 = new ArrayList();
      final Object localObject7 = LauncherModel.sSurfaceWidgets.iterator();
      while (((Iterator)localObject7).hasNext())
      {
        final Object localObject8 = (SurfaceWidgetItem)((Iterator)localObject7).next();
        if (((SurfaceWidgetItem)localObject8).mSecretItem)
        {
          ((List)localObject6).add(localObject8);
        }
        else
        {
          localObject8 = new Runnable()
          {
            public void run()
            {
              LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
              if (localCallbacks != null) {
                localCallbacks.bindHomeSurfaceWidget(localObject8);
              }
            }
          };
          LauncherExModel.this.runOnMainThread((Runnable)localObject8);
        }
      }
      if (LauncherApplication.sIsTheFisrt)
      {
        LauncherApplication.getInst().insertLog("WGCT", null, LauncherExModel.this.mApp.getModel().WidgetCount(), true);
        LauncherApplication.sIsTheFisrt = false;
      }
      if (this.mIsSecret) {
        bindSecretWorkspace((List)localObject1, (HashMap)localObject2, (List)localObject3, (List)localObject5, (List)localObject6);
      }
      if ((LauncherApplication.sFestivalPageLauncher) && (!this.mIsFestival) && (!this.mIsFestivalModeChanged)) {
        checkBindFestivalWorkspace((List)localObject4);
      }
      localObject1 = new Runnable()
      {
        public void run()
        {
          LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
          if (localCallbacks != null) {
            localCallbacks.bindHomeEnd();
          }
        }
      };
      LauncherExModel.this.runOnMainThread((Runnable)localObject1);
      localObject1 = new Runnable()
      {
        public void run()
        {
          Log.d("LauncherExModel", "bound workspace in " + (SystemClock.uptimeMillis() - l1) + "ms");
        }
      };
      LauncherExModel.this.runOnMainThread((Runnable)localObject1);
    }
    
    private void changeScreenIdInAppsDataBase(final Map<Long, AppItem> paramMap)
    {
      if (!this.mIsModeChanged) {
        return;
      }
      Object localObject2 = new ArrayList();
      Object localObject4 = new ArrayList();
      Object localObject5 = new ArrayList();
      Object localObject1 = new ArrayList();
      int i;
      if (this.mIsSecret)
      {
        localObject3 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        Object localObject6 = paramMap.keySet().iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject7 = (AppItem)paramMap.get(Long.valueOf(((Long)((Iterator)localObject6).next()).longValue()));
          if (((AppItem)localObject7).mSecretItem)
          {
            if (!((ArrayList)localObject3).contains(Integer.valueOf(((AppItem)localObject7).mScreen))) {
              ((ArrayList)localObject3).add(Integer.valueOf(((AppItem)localObject7).mScreen));
            }
            localArrayList.add(localObject7);
          }
          else
          {
            if (!((ArrayList)localObject2).contains(Integer.valueOf(((AppItem)localObject7).mScreen))) {
              ((ArrayList)localObject2).add(Integer.valueOf(((AppItem)localObject7).mScreen));
            }
            ((ArrayList)localObject5).add(localObject7);
          }
        }
        Collections.sort((List)localObject2, this.PAGEINDEX_COMPARATOR);
        Collections.sort((List)localObject3, this.PAGEINDEX_COMPARATOR);
        localObject6 = new ArrayList((Collection)localObject3);
        Object localObject7 = new boolean[((ArrayList)localObject2).size() + ((ArrayList)localObject3).size()];
        int j = ((ArrayList)localObject3).size();
        i = 1;
        while (i <= j)
        {
          int k = ((ArrayList)localObject3).size() - 1;
          if (((Integer)((ArrayList)localObject3).get(k)).intValue() < localObject7.length - i) {
            break;
          }
          localObject7[(localObject7.length - i)] = 1;
          ((ArrayList)localObject3).remove(k);
          i += 1;
        }
        i = 0;
        while (i < localObject7.length)
        {
          if (((ArrayList)localObject3).contains(Integer.valueOf(i)))
          {
            localObject7[i] = 1;
            ((ArrayList)localObject3).remove(Integer.valueOf(i));
          }
          i += 1;
        }
        i = 0;
        while (i < localObject7.length)
        {
          if (localObject7[i] != 0) {
            ((ArrayList)localObject3).add(Integer.valueOf(i));
          }
          i += 1;
        }
        paramMap = new String();
        i = 0;
        if (i < localObject7.length)
        {
          if (localObject7[i] != 0) {}
          for (paramMap = paramMap + "S";; paramMap = paramMap + "N")
          {
            i += 1;
            break;
          }
        }
        Log.e("LauncherExModel", paramMap);
        i = 0;
        if (i < ((ArrayList)localObject2).size())
        {
          j = 0;
          for (;;)
          {
            if (j < localObject7.length)
            {
              if (localObject7[j] == 0) {
                localObject7[j] = 1;
              }
            }
            else
            {
              ((ArrayList)localObject4).add(Integer.valueOf(j));
              i += 1;
              break;
            }
            j += 1;
          }
        }
        paramMap = ((ArrayList)localObject5).iterator();
        while (paramMap.hasNext())
        {
          localObject5 = (AppItem)paramMap.next();
          i = ((Integer)((ArrayList)localObject4).get(((ArrayList)localObject2).indexOf(Integer.valueOf(((AppItem)localObject5).mScreen)))).intValue();
          if (((AppItem)localObject5).mScreen != i)
          {
            ((AppItem)localObject5).mScreen = i;
            ((ArrayList)localObject1).add(localObject5);
          }
        }
        paramMap = localArrayList.iterator();
        while (paramMap.hasNext())
        {
          localObject2 = (AppItem)paramMap.next();
          i = ((Integer)((ArrayList)localObject3).get(((ArrayList)localObject6).indexOf(Integer.valueOf(((AppItem)localObject2).mScreen)))).intValue();
          if (((AppItem)localObject2).mScreen != i)
          {
            ((AppItem)localObject2).mScreen = i;
            ((ArrayList)localObject1).add(localObject2);
          }
        }
      }
      Object localObject3 = paramMap.keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (AppItem)paramMap.get(Long.valueOf(((Long)((Iterator)localObject3).next()).longValue()));
        if (!((AppItem)localObject4).mSecretItem)
        {
          if (!((ArrayList)localObject2).contains(Integer.valueOf(((AppItem)localObject4).mScreen))) {
            ((ArrayList)localObject2).add(Integer.valueOf(((AppItem)localObject4).mScreen));
          }
          ((ArrayList)localObject5).add(localObject4);
        }
      }
      Collections.sort((List)localObject2, this.PAGEINDEX_COMPARATOR);
      paramMap = ((ArrayList)localObject5).iterator();
      while (paramMap.hasNext())
      {
        localObject3 = (AppItem)paramMap.next();
        i = ((ArrayList)localObject2).indexOf(Integer.valueOf(((AppItem)localObject3).mScreen));
        if (((AppItem)localObject3).mScreen != i)
        {
          ((AppItem)localObject3).mScreen = i;
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      paramMap = new ArrayList(((ArrayList)localObject1).size());
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppItem)((Iterator)localObject1).next();
        localObject3 = new LauncherSettings.AppOrderModify();
        ((LauncherSettings.AppOrderModify)localObject3).id = ((AppItem)localObject2).mId;
        ((LauncherSettings.AppOrderModify)localObject3).screen = ((AppItem)localObject2).mScreen;
        paramMap.add(localObject3);
      }
      LauncherExModel.runOnWorkerThread(new Runnable()
      {
        public void run()
        {
          LauncherExModel.this.mApp.getLauncherProvider().moveAppOrderModify(paramMap);
        }
      });
    }
    
    private void changeScreenIdInHomeDataBase()
    {
      int i = 1;
      if (((this.mIsSecret) && (LauncherApplication.getScreenModeForSecret() == 1)) || ((!this.mIsSecret) && (LauncherApplication.getScreenModeForSecret() == 0))) {
        return;
      }
      LauncherExModel.this.updateHomeDataBase(this.mIsSecret);
      LauncherApplication localLauncherApplication = LauncherExModel.this.mApp;
      if (this.mIsSecret) {}
      for (;;)
      {
        LauncherApplication.setScreenModeForSecret(localLauncherApplication, i);
        return;
        i = 0;
      }
    }
    
    private void checkBindFestivalWorkspace(final List<HomeWidgetItem> paramList)
    {
      int i;
      int j;
      label44:
      String str1;
      int k;
      if (Settings.System.getInt(LauncherExModel.this.mApp.getContentResolver(), "festival_effect_enabled", 0) != 0)
      {
        i = 1;
        if (Settings.System.getInt(LauncherExModel.this.mApp.getContentResolver(), "festival_effect_festival_home", 0) == 0) {
          break label174;
        }
        j = 1;
        str1 = Settings.System.getString(LauncherExModel.this.mApp.getContentResolver(), "FestivalList");
        String str2 = LauncherExModel.this.mApp.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getString("festivalstring", null);
        if ((str1 == null) || (str1.isEmpty()) || (!str1.equals(str2))) {
          break label179;
        }
        k = 1;
        label113:
        if (k == 0) {
          FestivalPageManager.setFestivalString(LauncherExModel.this.mApp, str1);
        }
        Log.d("LauncherExModel", "checkBindFestivalWorkspace:: festivalWidgets : " + paramList.size());
        if (getLoaderTaskCallbacks() != null) {
          break label185;
        }
      }
      label174:
      label179:
      label185:
      do
      {
        do
        {
          return;
          i = 0;
          break;
          j = 0;
          break label44;
          k = 0;
          break label113;
          paramList = new Runnable()
          {
            public void run()
            {
              LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
              if (localCallbacks != null) {
                localCallbacks.bindHomeDeleteFestivalPage(paramList);
              }
            }
          };
          LauncherExModel.this.runOnMainThread(paramList);
        } while ((i == 0) || (j == 0));
        Log.i("LauncherExModel", "checkBindFestivalWorkspace:: insert festivalList : " + str1);
      } while ((str1 == null) || (str1.isEmpty()));
      this.mIsFestival = true;
      bindFestivalPageModeChange();
      LauncherExModel.access$1102(LauncherExModel.this, true);
      paramList = new Runnable()
      {
        public void run()
        {
          LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
          if (localCallbacks != null) {
            localCallbacks.bindHomeInsertFestivalPage();
          }
        }
      };
      LauncherExModel.this.runOnMainThread(paramList);
    }
    
    private boolean checkItemPlacement(HomeItem[][][] paramArrayOfHomeItem1, HomeItem[][][] paramArrayOfHomeItem2, HomeItem paramHomeItem)
    {
      int k = paramHomeItem.mScreen;
      if (paramHomeItem.container == -101L)
      {
        i = LauncherApplication.getMaxScreenCount() + LauncherApplication.getMaxSecretScreenCount();
        if (paramArrayOfHomeItem1[i][paramHomeItem.mScreen][0] != null)
        {
          if (LauncherModel.DEBUGGABLE) {
            Log.e("LauncherExModel", "Error loading shortcut into hotseat " + paramHomeItem + " into position (" + paramHomeItem.mScreen + ":" + paramHomeItem.cellX + "," + paramHomeItem.cellY + ") occupied by " + paramArrayOfHomeItem1[i][paramHomeItem.mScreen][0]);
          }
          return false;
        }
        paramArrayOfHomeItem1[i][paramHomeItem.mScreen][0] = paramHomeItem;
        return true;
      }
      if (paramHomeItem.container != -100L) {
        return true;
      }
      if (paramHomeItem.mSecretItem) {
        label167:
        i = paramHomeItem.cellX;
      }
      int j;
      for (;;)
      {
        if (i >= paramHomeItem.cellX + paramHomeItem.spanX) {
          break label342;
        }
        j = paramHomeItem.cellY;
        for (;;)
        {
          if (j >= paramHomeItem.cellY + paramHomeItem.spanY) {
            break label333;
          }
          if (paramArrayOfHomeItem2[k][i][j] != null)
          {
            if (!LauncherModel.DEBUGGABLE) {
              break;
            }
            Log.e("LauncherExModel", "Error loading shortcut " + paramHomeItem + " into cell (" + k + "-" + paramHomeItem.mScreen + ":" + i + "," + j + ") occupied by " + paramArrayOfHomeItem2[k][i][j]);
            return false;
            paramArrayOfHomeItem2 = paramArrayOfHomeItem1;
            break label167;
          }
          j += 1;
        }
        label333:
        i += 1;
      }
      label342:
      int i = paramHomeItem.cellX;
      while (i < paramHomeItem.cellX + paramHomeItem.spanX)
      {
        j = paramHomeItem.cellY;
        while (j < paramHomeItem.cellY + paramHomeItem.spanY)
        {
          paramArrayOfHomeItem2[k][i][j] = paramHomeItem;
          j += 1;
        }
        i += 1;
      }
      return true;
    }
    
    private LauncherModel.Callbacks getLoaderTaskCallbacks()
    {
      LauncherModel.Callbacks localCallbacks = null;
      synchronized (LauncherExModel.this.mLock)
      {
        if (!this.mStopped) {
          localCallbacks = (LauncherModel.Callbacks)LauncherExModel.this.mCallbacks.get();
        }
        return localCallbacks;
      }
    }
    
    private Map<Long, AppItem> loadAllApps()
    {
      final Map localMap = LauncherExModel.this.mMenuAppLoader.loadAllItems(this.mIsSecret);
      if ((!this.mStopped) && (localMap != null))
      {
        LauncherExModel.this.mAllAppsLoaded = true;
        LauncherExModel.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            MenuAppModel.INSTANCE.setModelItems(localMap);
            Log.d("LauncherExModel", "MenuAppModel.setModelItems called");
          }
        });
      }
      return localMap;
    }
    
    private void loadAndBindAllApps()
    {
      Log.d("LauncherExModel", "loadAndBindAllApps mAllAppsLoaded: " + LauncherExModel.this.mAllAppsLoaded + ", mRefreshRequired: " + LauncherExModel.this.mRefreshRequired);
      Map localMap;
      if (!LauncherExModel.this.mAllAppsLoaded)
      {
        localMap = loadAllApps();
        if (getLoaderTaskCallbacks() == null) {
          Log.w("LauncherExModel", "LoaderTask aborted or running with no launcher (bindAllApps)");
        }
      }
      do
      {
        do
        {
          do
          {
            return;
            LauncherExModel.this.mHandler.post(new Runnable()
            {
              public void run()
              {
                LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
                if (localCallbacks != null) {
                  localCallbacks.bindAppsLoaded();
                }
              }
            });
            if ((localMap != null) && (localMap.size() > 0)) {
              changeScreenIdInAppsDataBase(localMap);
            }
          } while (!this.mIsSecret);
          bindSecretAllApps();
          return;
          if (!LauncherExModel.this.mRefreshRequired) {
            break;
          }
          LauncherExModel.this.mMenuAppLoader.refreshAllApps();
        } while (this.mStopped);
        postModelRefreshed();
        return;
      } while ((!LauncherExModel.this.mAllAppsLoaded) || (!this.mIsSecret));
      bindSecretAllApps();
    }
    
    private void loadAndBindWorkspace()
    {
      Log.d("LauncherExModel", "loadAndBindWorkspace mWorkspaceLoaded: " + LauncherExModel.this.mWorkspaceLoaded + ", mRefreshRequired: " + LauncherExModel.this.mRefreshRequired);
      LauncherExModel.this.unbindAllHomeItemsOnMainThread();
      if ((!LauncherExModel.this.mWorkspaceLoaded) || (LauncherExModel.this.mRefreshRequired))
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
          break label150;
        }
        LauncherModel.sDbIconCache.clear();
      }
      for (;;)
      {
        if (!this.mStopped)
        {
          changeScreenIdInHomeDataBase();
          bindWorkspace();
        }
        return;
        label150:
        LauncherExModel.this.mWorkspaceLoaded = true;
      }
    }
    
    private void loadWorkspace()
    {
      long l1 = SystemClock.uptimeMillis();
      ContentResolver localContentResolver = LauncherExModel.this.mApp.getContentResolver();
      PackageManager localPackageManager = LauncherExModel.this.mApp.getPackageManager();
      AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(LauncherExModel.this.mApp);
      boolean bool2 = localPackageManager.isSafeMode();
      ArrayList localArrayList = new ArrayList();
      Cursor localCursor = localContentResolver.query(LauncherSettings.Favorites.CONTENT_URI(), null, null, null, null);
      int m = LauncherApplication.getMaxScreenCount() + LauncherApplication.getMaxSecretScreenCount() + LauncherApplication.getMaxFestivalScreenCount();
      HomeItem[][][] arrayOfHomeItem1 = (HomeItem[][][])Array.newInstance(HomeItem.class, new int[] { m + 1, LauncherModel.sCellCountX + 1, LauncherModel.sCellCountY + 1 });
      HomeItem[][][] arrayOfHomeItem2 = (HomeItem[][][])Array.newInstance(HomeItem.class, new int[] { m + 1, LauncherModel.sCellCountX + 1, LauncherModel.sCellCountY + 1 });
      int i = 0;
      int n;
      int i1;
      int i7;
      int i9;
      int i10;
      int i11;
      int i12;
      int i13;
      int i14;
      int i16;
      boolean bool1;
      int j;
      Object localObject5;
      long l2;
      for (;;)
      {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i15;
        int i17;
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
          i16 = localCursor.getColumnIndexOrThrow("secret");
          i17 = localCursor.getColumnIndexOrThrow("festival");
          if (this.mStopped) {
            break;
          }
          bool1 = localCursor.moveToNext();
          if (!bool1) {
            break;
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
            label687:
            label775:
            i = k;
          }
        }
        finally
        {
          if ((this.mStopped) && (localCursor.moveToNext())) {
            LauncherExModel.this.mWorkspaceLoaded = false;
          }
          localCursor.close();
        }
        try
        {
          localObject5 = Intent.parseUri((String)localObject1, 0);
          if (bool2)
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
            break label897;
          }
          k = i;
          localObject1 = LauncherExModel.this.getShortcutInfo(localPackageManager, (Intent)localObject5, LauncherExModel.this.mApp, localCursor, i4, i2, i16);
          if (localObject1 == null) {
            break label1083;
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
          if (i16 <= 0) {
            break label3355;
          }
          k = i;
          if (localCursor.getInt(i16) == 0) {
            break label3355;
          }
          bool1 = true;
          k = i;
          ((HomeShortcutItem)localObject1).mSecretItem = bool1;
          k = i;
          j = i;
          if (checkItemPlacement(arrayOfHomeItem1, arrayOfHomeItem2, (HomeItem)localObject1)) {
            break label3334;
          }
          k = i;
          j = i;
          if (((HomeShortcutItem)localObject1).container != -101L) {
            break label3334;
          }
          k = i;
          Log.i("LauncherExModel", "wrong hotseat item : we remove the item in launcher.db - item=" + localObject1);
          k = i;
          localCursor.getLong(n);
          j = 1;
        }
        catch (URISyntaxException localURISyntaxException1) {}
        k = j;
        LauncherModel.sHomeItems.add(localObject1);
        k = j;
        LauncherModel.sHomeItemIdMap.put(Long.valueOf(((HomeShortcutItem)localObject1).mId), localObject1);
        k = j;
        LauncherExModel.this.queueIconToBeChecked(LauncherModel.sDbIconCache, (HomeShortcutItem)localObject1, localCursor, i4);
        i = j;
        continue;
        if (LauncherModel.DEBUGGABLE)
        {
          Log.w("LauncherExModel", "Desktop items loading interrupted:", localException);
          i = k;
          continue;
          continue;
          label897:
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
                  Log.d("LauncherExModel", "loadWorkspace : intent.getExtras().isEmpty = " + ((Intent)localObject5).getExtras().isEmpty());
                  k = i;
                  Log.d("LauncherExModel", "loadWorkspace : intent.getExtras().isEmpty = " + localObject5);
                }
                k = i;
                localObject3 = LauncherExModel.this.getShortcutInfoExtra(localPackageManager, (Intent)localObject5, LauncherExModel.this.mApp, localCursor, i4, i2);
                continue;
              }
            }
          }
          k = i;
          Object localObject3 = LauncherExModel.this.getShortcutInfo(localCursor, LauncherExModel.this.mApp, i3, i5, i6, i4, i2, localPackageManager, (Intent)localObject5);
          continue;
          label1065:
          k = j;
          LauncherModel.findOrMakeFolder(LauncherModel.sHomeFolders, l2).loadItem((HomeItem)localObject3);
          continue;
          label1083:
          k = i;
          l2 = localCursor.getLong(n);
          k = i;
          localArrayList.add(Long.valueOf(l2));
          k = i;
          if (LauncherModel.DEBUGGABLE)
          {
            k = i;
            Log.e("LauncherExModel", "Error loading shortcut " + l2 + ", removing it");
            continue;
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
            ((HomeFolderItem)localObject3).mColor = localCursor.getInt(i15);
            if (i16 <= 0) {
              break label3361;
            }
            k = i;
            if (localCursor.getInt(i16) == 0) {
              break label3361;
            }
            bool1 = true;
            label1313:
            k = i;
            ((HomeFolderItem)localObject3).mSecretItem = bool1;
            k = i;
            if (checkItemPlacement(arrayOfHomeItem1, arrayOfHomeItem2, (HomeItem)localObject3))
            {
              if ((l2 == -100L) || (l2 == -101L))
              {
                k = i;
                LauncherModel.sHomeItems.add(localObject3);
              }
              k = i;
              LauncherModel.sHomeItemIdMap.put(Long.valueOf(((HomeFolderItem)localObject3).mId), localObject3);
              k = i;
              LauncherModel.sHomeFolders.put(Long.valueOf(((HomeFolderItem)localObject3).mId), localObject3);
              continue;
              k = i;
              j = localCursor.getInt(i9);
              k = i;
              l2 = localCursor.getLong(n);
              k = i;
              localObject3 = localAppWidgetManager.getAppWidgetInfo(j);
              localObject5 = localObject3;
              if (localObject3 == null)
              {
                localObject5 = localObject3;
                if (i16 > 0)
                {
                  k = i;
                  localObject5 = localObject3;
                  if (localCursor.getInt(i16) != 0) {
                    localObject5 = null;
                  }
                }
              }
              if ((localObject5 == null) && (j != -1) && (i17 > 0))
              {
                k = i;
                if (localCursor.getInt(i17) != 0)
                {
                  k = i;
                  localArrayList.add(Long.valueOf(l2));
                }
              }
              if ((!bool2) && (j != -1) && (localObject5 == null))
              {
                k = i;
                localObject3 = "Deleting widget that isn't installed anymore: id=" + l2 + " appWidgetId=" + j;
                k = i;
                if (LauncherModel.DEBUGGABLE)
                {
                  k = i;
                  Log.e("LauncherExModel", (String)localObject3);
                }
                k = i;
                HomeView.sDumpLogs.add(localObject3);
                k = i;
                localArrayList.add(Long.valueOf(l2));
              }
              else
              {
                Object localObject6 = null;
                if (i16 <= 0) {
                  break label3367;
                }
                k = i;
                if (localCursor.getInt(i16) == 0) {
                  break label3367;
                }
                bool1 = true;
                label1643:
                if (bool1)
                {
                  k = i;
                  MenuAppModel.INSTANCE.setHasPreSecretWidget(true);
                }
                localObject3 = localObject6;
                if (bool1)
                {
                  localObject3 = localObject6;
                  if (j == -1)
                  {
                    k = i;
                    String str = LauncherExModel.this.mApp.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getString("PrefsPreSecret" + Long.toString(l2), null);
                    localObject3 = localObject6;
                    if (str != null)
                    {
                      k = i;
                      localObject3 = str.split(":");
                      k = i;
                      localObject3 = new ComponentName(localObject3[0], localObject3[1]);
                      if (localObject3 != null) {
                        break label1987;
                      }
                    }
                  }
                }
                for (localObject3 = null;; localObject3 = new HomeWidgetItem((ComponentName)localObject3, j))
                {
                  localObject6 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject6 = localObject3;
                    if (localObject5 != null)
                    {
                      k = i;
                      localObject6 = new HomeWidgetItem((AppWidgetProviderInfo)localObject5, j);
                    }
                  }
                  if (localObject6 == null) {
                    break;
                  }
                  k = i;
                  ((HomeWidgetItem)localObject6).mId = l2;
                  k = i;
                  ((HomeWidgetItem)localObject6).mScreen = localCursor.getInt(i10);
                  k = i;
                  ((HomeWidgetItem)localObject6).cellX = localCursor.getInt(i11);
                  k = i;
                  ((HomeWidgetItem)localObject6).cellY = localCursor.getInt(i12);
                  k = i;
                  ((HomeWidgetItem)localObject6).spanX = localCursor.getInt(i13);
                  k = i;
                  ((HomeWidgetItem)localObject6).spanY = localCursor.getInt(i14);
                  k = i;
                  ((HomeWidgetItem)localObject6).mSecretItem = bool1;
                  if (i17 > 0)
                  {
                    k = i;
                    if (localCursor.getInt(i17) != 0)
                    {
                      k = i;
                      ((HomeWidgetItem)localObject6).mFestivalType = localCursor.getInt(i17);
                    }
                  }
                  k = i;
                  l2 = localCursor.getInt(i7);
                  if ((l2 == -100L) || (l2 == -101L)) {
                    break label2004;
                  }
                  k = i;
                  Log.e("LauncherExModel", "Widget found where container != CONTAINER_DESKTOP nor CONTAINER_HOTSEAT - ignoring!");
                  break;
                  label1987:
                  k = i;
                }
                label2004:
                k = i;
                ((HomeWidgetItem)localObject6).container = localCursor.getInt(i7);
                k = i;
                if (checkItemPlacement(arrayOfHomeItem1, arrayOfHomeItem2, (HomeItem)localObject6))
                {
                  k = i;
                  LauncherModel.sHomeItemIdMap.put(Long.valueOf(((HomeWidgetItem)localObject6).mId), localObject6);
                  k = i;
                  LauncherModel.sAppWidgets.add(localObject6);
                  continue;
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
                  if (i16 <= 0) {
                    break label3373;
                  }
                  k = i;
                  if (localCursor.getInt(i16) == 0) {
                    break label3373;
                  }
                  bool1 = true;
                  label2221:
                  k = i;
                  ((SamsungWidgetItem)localObject3).mSecretItem = bool1;
                  k = i;
                  long l3 = localCursor.getInt(i7);
                  if ((l3 != -100L) && (l3 != -101L))
                  {
                    k = i;
                    Log.e("LauncherExModel", "Samsung Widget found where container != CONTAINER_DESKTOP nor CONTAINER_HOTSEAT - ignoring!");
                  }
                  else
                  {
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
                        break label2374;
                      }
                      k = i;
                      Log.e("LauncherExModel", "Can't resolve SamsungWidget's activity. Deleting it.");
                      k = i;
                      localArrayList.add(Long.valueOf(l2));
                    }
                    catch (URISyntaxException localURISyntaxException2) {}
                    continue;
                    label2374:
                    k = i;
                    try
                    {
                      localPackageManager.getApplicationInfo(((ResolveInfo)localObject5).activityInfo.packageName, 0);
                      k = i;
                      if (checkItemPlacement(arrayOfHomeItem1, arrayOfHomeItem2, localURISyntaxException2))
                      {
                        k = i;
                        LauncherModel.sHomeItemIdMap.put(Long.valueOf(localURISyntaxException2.mId), localURISyntaxException2);
                        k = i;
                        LauncherModel.sSamsungWidgets.add(localURISyntaxException2);
                      }
                    }
                    catch (PackageManager.NameNotFoundException localNameNotFoundException)
                    {
                      k = i;
                      Log.e("LauncherExModel", "SamsungWidget's apk has move to sdcard and unmounted. Deleting it.");
                      k = i;
                      localArrayList.add(Long.valueOf(l2));
                    }
                  }
                }
              }
            }
          }
        }
      }
      int k = i;
      Object localObject4 = localCursor.getString(i1);
      k = i;
      for (;;)
      {
        label3334:
        label3355:
        label3361:
        label3367:
        label3373:
        try
        {
          localObject4 = Intent.parseUri((String)localObject4, 0);
          k = i;
          localObject5 = SurfaceWidgetPackageManager.INST.findWidget(((Intent)localObject4).getComponent(), null);
          k = i;
          l2 = localCursor.getLong(n);
          if (localObject5 == null)
          {
            k = i;
            Log.e("LauncherExModel", "SurfaceWidget-" + ((Intent)localObject4).getComponent() + "'s provider info could not be found. Deleting it.");
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
          if (i16 <= 0) {
            break label3384;
          }
          k = i;
          if (localCursor.getInt(i16) == 0) {
            break label3384;
          }
          bool1 = true;
          k = i;
          ((SurfaceWidgetItem)localObject5).mSecretItem = bool1;
          k = i;
          l2 = localCursor.getInt(i7);
          if ((l2 != -100L) && (l2 != -101L))
          {
            k = i;
            Log.e("LauncherExModel", "Surface Widget found where container != CONTAINER_DESKTOP nor CONTAINER_HOTSEAT - ignoring!");
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
            Log.d("LauncherExModel", "LauncherModel read out SurfaceWidgetItem mInstance = " + ((SurfaceWidgetItem)localObject5).mInstance);
          }
          k = i;
          if (!checkItemPlacement(arrayOfHomeItem1, arrayOfHomeItem2, (HomeItem)localObject5)) {
            break;
          }
          k = i;
          LauncherModel.sHomeItemIdMap.put(Long.valueOf(((SurfaceWidgetItem)localObject5).mId), localObject5);
          k = i;
          LauncherModel.sSurfaceWidgets.add(localObject5);
        }
        catch (URISyntaxException localURISyntaxException3) {}
        if ((this.mStopped) && (localCursor.moveToNext())) {
          LauncherExModel.this.mWorkspaceLoaded = false;
        }
        localCursor.close();
        if (i != 0) {
          rearrangeHotseatData(LauncherModel.sHomeItems);
        }
        LauncherExModel.this.updateHiddenAddButtonInHomeFolder(LauncherModel.sHomeFolders);
        if (localArrayList.size() > 0)
        {
          localObject4 = localContentResolver.acquireContentProviderClient(LauncherSettings.Favorites.CONTENT_URI());
          localObject5 = localArrayList.iterator();
          if (((Iterator)localObject5).hasNext())
          {
            l2 = ((Long)((Iterator)localObject5).next()).longValue();
            Log.d("LauncherExModel", "Removed id = " + l2);
            if (localObject4 == null) {
              continue;
            }
            try
            {
              ((ContentProviderClient)localObject4).delete(LauncherSettings.Favorites.getContentUri(l2, false), null, null);
            }
            catch (RemoteException localRemoteException) {}
            if (!LauncherModel.DEBUGGABLE) {
              continue;
            }
            Log.w("LauncherExModel", "Could not remove id = " + l2);
            continue;
          }
        }
        Log.d("LauncherExModel", "loaded workspace in " + (SystemClock.uptimeMillis() - l1) + "ms");
        Log.d("LauncherExModel", "workspace layout: ");
        i = 0;
        if (i < LauncherModel.sCellCountY)
        {
          localObject4 = "";
          j = 0;
          if (j < m)
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
              if (arrayOfHomeItem1[j][k][i] != null)
              {
                localObject4 = "#";
                localObject4 = (String)localObject4;
                k += 1;
              }
              else
              {
                localObject4 = ".";
              }
            }
            else
            {
              j += 1;
            }
          }
          else
          {
            Log.d("LauncherExModel", "[ " + (String)localObject4 + " ]");
            i += 1;
          }
        }
        else
        {
          return;
          break;
          if (l2 == -100L) {
            break label775;
          }
          if (l2 != -101L) {
            break label1065;
          }
          break label775;
          bool1 = false;
          break label687;
          bool1 = false;
          break label1313;
          bool1 = false;
          break label1643;
          bool1 = false;
          break label2221;
          break;
          label3384:
          bool1 = false;
        }
      }
    }
    
    private void postModelRefreshed()
    {
      LauncherExModel.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          if (!LauncherExModel.LoaderTask.this.mStopped)
          {
            MenuAppModel.INSTANCE.onModelRefreshed();
            Log.d("LauncherExModel", "MenuAppModel.onModelRefreshed called");
            LauncherModel.Callbacks localCallbacks = LauncherExModel.LoaderTask.this.getLoaderTaskCallbacks();
            if (localCallbacks != null)
            {
              localCallbacks.bindAppsLoaded();
              Log.d("LauncherExModel", "bindAppsLoaded called");
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
          LauncherModel.updateItemInDatabase(LauncherExModel.this.mApp.getApplicationContext(), (HomeItem)localArrayList.get(j));
          k = j + 1;
        }
        i += 1;
        j = k;
      }
    }
    
    private void runBindFestivalPage()
    {
      if (!LauncherExModel.this.mWorkspaceLoaded) {
        throw new RuntimeException("Expecting Workspace to be loaded");
      }
      synchronized (LauncherExModel.this.mLock)
      {
        if (LauncherExModel.this.mIsLoaderTaskRunning) {
          throw new RuntimeException("Error! Background loading is already running");
        }
      }
      bindFestivalPageModeChange();
      bindFestivalWorkspace();
    }
    
    private void runBindSecretPage()
    {
      if ((!LauncherExModel.this.mAllAppsLoaded) || (!LauncherExModel.this.mWorkspaceLoaded)) {
        throw new RuntimeException("Expecting AllApps and Workspace to be loaded");
      }
      synchronized (LauncherExModel.this.mLock)
      {
        if (LauncherExModel.this.mIsLoaderTaskRunning) {
          throw new RuntimeException("Error! Background loading is already running");
        }
      }
      bindSecretPageModeChange();
      changeScreenIdInHomeDataBase();
      bindSecretWorkspace();
      bindSecretAllApps();
    }
    
    private void waitForIdle()
    {
      try
      {
        long l = SystemClock.uptimeMillis();
        LauncherExModel.this.mHandler.postIdle(new Runnable()
        {
          public void run()
          {
            synchronized (LauncherExModel.LoaderTask.this)
            {
              LauncherExModel.LoaderTask.access$302(LauncherExModel.LoaderTask.this, true);
              Log.d("LauncherExModel", "done with first binding step");
              LauncherExModel.LoaderTask.this.notify();
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
        Log.d("LauncherExModel", "waited " + (SystemClock.uptimeMillis() - l) + "ms for previous step to finish binding");
        return;
      }
      finally {}
    }
    
    public void dumpState()
    {
      if (LauncherModel.DEBUGGABLE)
      {
        Log.d("LauncherExModel", "mLoaderTask.mIsLaunching=" + this.mIsLaunching);
        Log.d("LauncherExModel", "mLoaderTask.mStopped=" + this.mStopped);
        Log.d("LauncherExModel", "mLoaderTask.mStep1Finished=" + this.mStep1Finished);
        Log.d("LauncherExModel", "mItems size=" + LauncherModel.sHomeItems.size());
      }
    }
    
    boolean isLaunching()
    {
      return this.mIsLaunching;
    }
    
    public void run()
    {
      synchronized (LauncherExModel.this.mLock)
      {
        LauncherExModel.access$402(LauncherExModel.this, true);
        Log.d("LauncherExModel", "Begin LoaderTask: " + System.identityHashCode(this));
        if (this.mStopped)
        {
          Log.d("LauncherExModel", "Comparing loaded icons to database icons");
          ??? = LauncherModel.sDbIconCache.keySet().iterator();
          if (!((Iterator)???).hasNext()) {
            break label442;
          }
          Object localObject2 = ((Iterator)???).next();
          LauncherExModel.this.updateSavedIcon(LauncherExModel.this.mApp, (HomeShortcutItem)localObject2, (byte[])LauncherModel.sDbIconCache.get(localObject2));
        }
      }
      StringBuilder localStringBuilder = new StringBuilder().append("Setting thread priority to ");
      if (this.mIsLaunching) {
        ??? = "DEFAULT";
      }
      for (;;)
      {
        Log.d("LauncherExModel", (String)???);
        synchronized (LauncherExModel.this.mLock)
        {
          if (LauncherModel.UseLauncherHighPriority)
          {
            Process.setThreadPriority(-2);
            if ((!LauncherExModel.this.mRefreshRequired) && (!LauncherExModel.this.hasLocaleChangedLocked())) {
              break label402;
            }
            LauncherExModel.this.setLocaleLocked();
            LauncherExModel.this.mRefreshRequired = true;
            LauncherExModel.access$502(LauncherExModel.this, true);
            LauncherExModel.this.mPkgResCache.clear();
            label244:
            if (this.mIsModeChanged) {
              bindSecretPageModeChange();
            }
            if (this.mIsFestivalModeChanged) {
              bindFestivalPageModeChange();
            }
            Log.d("LauncherExModel", "step 1: loading workspace");
            loadAndBindWorkspace();
            if (this.mStopped) {
              break;
            }
            if (this.mIsLaunching) {
              Log.d("LauncherExModel", "Setting thread priority to BACKGROUND");
            }
          }
        }
        synchronized (LauncherExModel.this.mLock)
        {
          if (LauncherModel.UseLauncherHighPriority)
          {
            Process.setThreadPriority(-2);
            waitForIdle();
            Log.d("LauncherExModel", "step 2: loading all apps");
            loadAndBindAllApps();
            synchronized (LauncherExModel.this.mLock)
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
              localObject5 = finally;
              throw ((Throwable)localObject5);
            }
            label402:
            if ((!LauncherExModel.this.mAllAppsLoaded) || (LauncherExModel.this.mRefreshRequired)) {
              break label244;
            }
            postModelRefreshed();
            break label244;
          }
          else
          {
            Process.setThreadPriority(10);
          }
        }
      }
      label442:
      LauncherModel.sDbIconCache.clear();
      LauncherExModel.this.mRefreshRequired = false;
      synchronized (LauncherExModel.this.mLock)
      {
        if (LauncherExModel.this.mLoaderTask == this) {
          LauncherExModel.access$002(LauncherExModel.this, null);
        }
        LauncherExModel.access$402(LauncherExModel.this, false);
        return;
      }
    }
    
    public void stopLocked()
    {
      Log.d("LauncherExModel", "Stopping LoaderTask: " + System.identityHashCode(this));
      this.mStopped = true;
      LauncherExModel.this.mMenuAppLoader.abortLoader();
      try
      {
        notify();
        return;
      }
      finally {}
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/LauncherExModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */