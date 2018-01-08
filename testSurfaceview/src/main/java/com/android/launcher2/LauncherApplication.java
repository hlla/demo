package com.android.launcher2;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.DVFSHelper;
import android.os.Handler;
import android.os.PersonaManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewConfiguration;
import com.samsung.android.feature.FloatingFeature;
import com.sec.android.app.CscFeature;
import java.lang.ref.WeakReference;

public class LauncherApplication
  extends Application
{
  public static final String ACTION_DYNAMICCSC_MODE = "com.android.launcher.action.DYNAMICCSC_MODE_CHANGE";
  public static final String APP_ID = "com.sec.android.app.launcher";
  public static String DEVICE_NAME;
  public static final String FEATURE_NAME_ENTER_APPS_MENU = "MENU";
  public static final String FEATURE_NAME_HOME_PAGE_COUNT = "HOME";
  public static final String FEATURE_NAME_HOTSEAT_ADD = "HSAD";
  public static final String FEATURE_NAME_HOTSEAT_DELETE = "HSDT";
  public static final String FEATURE_NAME_WIDGET_ADD = "WGAD";
  public static final String FEATURE_NAME_WIDGET_COUNT = "WGCT";
  public static final String FEATURE_NAME_WIDGET_DELETE = "WGDT";
  static final String PREFERENCES_SCREENCOUNT = "screencount";
  static final String PREFERENCES_SCREENCOUNT_FESTIVAL = "screencount.festival";
  static final String PREFERENCES_SCREENCOUNT_SECRET = "screencount.secret";
  static final String PREFERENCES_SCREENINDEX = "homescreenindex";
  static final String PREFERENCES_SCREENINDEX_FESTIVAL = "homescreenindex.festival";
  static final String PREFERENCES_SCREENINDEX_SECRET = "homescreenindex.secret";
  static final String PREFERENCES_SCREENMODE_FOR_FESTIVAL = "screenmode.festival";
  static final String PREFERENCES_SCREENMODE_FOR_SECRET = "screenmode.secret";
  public static int RemovablePreloadEnabled = 0;
  public static final String SHOW_DEFAULT_WALLPAPER_KEY = "SHOW_DEFAULT_WALLPAPER";
  public static final String SHOW_EMPTY_PAGE_MSG_KEY = "SHOW_EMPTY_PAGE_MSG";
  public static final String SHOW_MAGAZINE_CLING_MSG_KEY = "SHOW_MAGAZINE_CLING_MSG";
  private static final String TAG = "LauncherApplication";
  private static final String mProductName;
  public static boolean sDNDBinding = true;
  public static int sDensityDpi = 0;
  public static boolean sFestivalPageLauncher;
  private static boolean sHasMenuKey;
  private static LauncherApplication sInst;
  private static boolean sIsAppsListAllowed;
  private static boolean sIsDeleteDropTargetTextRight;
  private static boolean sIsDeleteDropTargetTop;
  public static boolean sIsFolderColorSupport = true;
  private static boolean sIsLargeTabletLayout;
  private static boolean sIsScreenLarge;
  private static boolean sIsScreenSmall;
  private static boolean sIsTabletLayout;
  public static boolean sIsTheFisrt;
  private static boolean sIsUsingMoreLineinFolder;
  private static boolean sIsWidgetSearchTextColorLight;
  private static WeakReference<Launcher> sLauncher;
  private static WeakReference<LauncherProvider> sLauncherProvider;
  public static boolean sMagazineLauncher = false;
  private static int sMaxFestivalScreenCount;
  private static int sMaxScreenCount;
  private static int sMaxSecretScreenCount;
  private static int sMenuIconSize;
  private static int sScreenCountFestival;
  private static int sScreenCountNormal;
  private static int sScreenCountSecret;
  private static float sScreenDensity;
  private static int sScreenIndexNormal;
  private static int sScreenModeForFestival;
  private static int sScreenModeForSecret;
  public static final boolean sSecretPageLauncher = false;
  public boolean SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE = false;
  private DVFSHelper busBooster = null;
  private DVFSHelper cpuBooster = null;
  private DVFSHelper cpuMaxBooster = null;
  private DVFSHelper gpuBooster = null;
  private final ContentObserver mBadgeObserver = new ContentObserver(this.mHandler)
  {
    public void onChange(boolean paramAnonymousBoolean)
    {
      LauncherApplication.this.mModel.reloadBadges();
    }
  };
  private String mFactoryModeString;
  private final ContentObserver mFavoritesObserver = new ContentObserver(this.mHandler)
  {
    public void onChange(boolean paramAnonymousBoolean)
    {
      LauncherApplication.this.mModel.startLoaderFromBackground(false);
    }
  };
  private Handler mHandler = new Handler();
  private boolean mIsFactoryMode;
  private MenuAppModel mMenuAppModel;
  private LauncherModel mModel;
  private PkgResCache mPkgResCache;
  private PkgResCache mPkgResCacheForMenu;
  private WorkspaceSpanCalculator mSpanCalculator;
  private final ContentObserver mSprintFolderObserver = new ContentObserver(this.mHandler)
  {
    public void onChange(boolean paramAnonymousBoolean)
    {
      Log.d("LauncherApplication", "mSprintFolderObserver onChange");
      MenuAppModel.INSTANCE.loadSprintFolderPackages();
    }
  };
  private ThemeLoader mThemeLoader;
  private int sKnox = -1;
  
  static
  {
    mProductName = SystemProperties.get("ro.product.name");
    DEVICE_NAME = SystemProperties.get("ro.product.model", "Unknown");
    RemovablePreloadEnabled = SystemProperties.getInt("ro.config.rm_preload_enabled", 0);
    sFestivalPageLauncher = false;
  }
  
  public LauncherApplication()
  {
    sInst = this;
  }
  
  public static int getFestivalScreenCount()
  {
    return sScreenCountFestival;
  }
  
  public static int getHomeScreenIndex()
  {
    return sScreenIndexNormal;
  }
  
  public static LauncherApplication getInst()
  {
    return sInst;
  }
  
  public static int getMaxFestivalScreenCount()
  {
    return sMaxFestivalScreenCount;
  }
  
  public static int getMaxScreenCount()
  {
    return sMaxScreenCount;
  }
  
  public static int getMaxSecretScreenCount()
  {
    return sMaxSecretScreenCount;
  }
  
  public static int getScreenCount()
  {
    return sScreenCountNormal;
  }
  
  public static float getScreenDensity()
  {
    return sScreenDensity;
  }
  
  public static int getScreenModeForFestival()
  {
    return sScreenModeForFestival;
  }
  
  public static int getScreenModeForSecret()
  {
    return sScreenModeForSecret;
  }
  
  public static int getSecretScreenCount()
  {
    return sScreenCountSecret;
  }
  
  public static int getSmallestWidth()
  {
    return Resources.getSystem().getConfiguration().smallestScreenWidthDp;
  }
  
  public static boolean hasMenuKey()
  {
    return sHasMenuKey;
  }
  
  public static boolean isAppsListAllowed()
  {
    return sIsAppsListAllowed;
  }
  
  public static boolean isDeleteDropTargetTextRight()
  {
    return sIsDeleteDropTargetTextRight;
  }
  
  public static boolean isDeleteDropTargetTop()
  {
    return sIsDeleteDropTargetTop;
  }
  
  private boolean isFactoryMode()
  {
    if (this.mFactoryModeString == null)
    {
      this.mFactoryModeString = readOneLine("/efs/FactoryApp/factorymode");
      if (this.mFactoryModeString.contains("ON")) {
        break label43;
      }
    }
    label43:
    for (boolean bool = true;; bool = false)
    {
      this.mIsFactoryMode = bool;
      return this.mIsFactoryMode;
    }
  }
  
  private boolean isFactorySim()
  {
    String str = ((TelephonyManager)getApplicationContext().getSystemService("phone")).getSubscriberId();
    return (str != null) && (str.equals("999999999999999"));
  }
  
  public static boolean isKioskModeEnabled(Context paramContext)
  {
    return "true".equals(PersonaManager.getKnoxInfoForApp(paramContext, "isKioskModeEnabled").getString("isKioskModeEnabled"));
  }
  
  public static boolean isLargeTabletLayout()
  {
    return sIsLargeTabletLayout;
  }
  
  public static boolean isMenuIconSizeChanged()
  {
    return sMenuIconSize > 0;
  }
  
  public static boolean isOwner()
  {
    return UserHandle.getCallingUserId() == 0;
  }
  
  public static boolean isPossibleAddToPersonal(String paramString)
  {
    Log.e("", " isPossibleAddToPersonal(name) = " + paramString);
    try
    {
      if (!isKioskModeEnabled(getInst().getApplicationContext()))
      {
        boolean bool = PersonaManager.isPossibleAddToPersonal(paramString);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (NoClassDefFoundError paramString)
    {
      Log.e("LauncherApplication", "not call android.os.PersonaManager." + paramString);
      return false;
    }
    catch (NoSuchMethodError paramString)
    {
      Log.e("LauncherApplication", "not call isPossibleAddToPersonal." + paramString);
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static boolean isScreenLarge()
  {
    return sIsScreenLarge;
  }
  
  public static boolean isScreenSmall()
  {
    return sIsScreenSmall;
  }
  
  public static boolean isTabletLayout()
  {
    return sIsTabletLayout;
  }
  
  public static boolean isUsingMoreLineinFolder()
  {
    return sIsUsingMoreLineinFolder;
  }
  
  public static boolean isWidgetSearchTextColorLight()
  {
    return sIsWidgetSearchTextColorLight;
  }
  
  /* Error */
  private String readOneLine(String paramString)
  {
    // Byte code:
    //   0: ldc_w 363
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore 9
    //   19: aconst_null
    //   20: astore_3
    //   21: aconst_null
    //   22: astore 8
    //   24: new 418	java/io/FileReader
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 421	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: new 423	java/io/BufferedReader
    //   36: dup
    //   37: aload_1
    //   38: sipush 8096
    //   41: invokespecial 426	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   44: astore_2
    //   45: aload_2
    //   46: invokevirtual 429	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore_3
    //   50: aload_1
    //   51: ifnull +7 -> 58
    //   54: aload_1
    //   55: invokevirtual 432	java/io/FileReader:close	()V
    //   58: aload_2
    //   59: ifnull +7 -> 66
    //   62: aload_2
    //   63: invokevirtual 433	java/io/BufferedReader:close	()V
    //   66: aload_3
    //   67: ifnonnull +216 -> 283
    //   70: ldc_w 363
    //   73: areturn
    //   74: astore_1
    //   75: ldc 78
    //   77: ldc_w 435
    //   80: invokestatic 438	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   83: pop
    //   84: aload_1
    //   85: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   88: goto -22 -> 66
    //   91: astore 5
    //   93: aload 8
    //   95: astore_1
    //   96: aload 4
    //   98: astore_2
    //   99: aload_1
    //   100: astore_3
    //   101: ldc 78
    //   103: ldc_w 441
    //   106: invokestatic 438	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   109: pop
    //   110: aload 4
    //   112: astore_2
    //   113: aload_1
    //   114: astore_3
    //   115: aload 5
    //   117: invokevirtual 442	java/io/FileNotFoundException:printStackTrace	()V
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 432	java/io/FileReader:close	()V
    //   128: aload 6
    //   130: astore_3
    //   131: aload 4
    //   133: ifnull -67 -> 66
    //   136: aload 4
    //   138: invokevirtual 433	java/io/BufferedReader:close	()V
    //   141: aload 6
    //   143: astore_3
    //   144: goto -78 -> 66
    //   147: astore_1
    //   148: ldc 78
    //   150: ldc_w 435
    //   153: invokestatic 438	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   156: pop
    //   157: aload_1
    //   158: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   161: aload 6
    //   163: astore_3
    //   164: goto -98 -> 66
    //   167: astore 5
    //   169: aload 9
    //   171: astore_1
    //   172: aload 7
    //   174: astore 4
    //   176: aload 4
    //   178: astore_2
    //   179: aload_1
    //   180: astore_3
    //   181: ldc 78
    //   183: ldc_w 444
    //   186: invokestatic 438	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   189: pop
    //   190: aload 4
    //   192: astore_2
    //   193: aload_1
    //   194: astore_3
    //   195: aload 5
    //   197: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   200: aload_1
    //   201: ifnull +7 -> 208
    //   204: aload_1
    //   205: invokevirtual 432	java/io/FileReader:close	()V
    //   208: aload 6
    //   210: astore_3
    //   211: aload 4
    //   213: ifnull -147 -> 66
    //   216: aload 4
    //   218: invokevirtual 433	java/io/BufferedReader:close	()V
    //   221: aload 6
    //   223: astore_3
    //   224: goto -158 -> 66
    //   227: astore_1
    //   228: ldc 78
    //   230: ldc_w 435
    //   233: invokestatic 438	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   236: pop
    //   237: aload_1
    //   238: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   241: aload 6
    //   243: astore_3
    //   244: goto -178 -> 66
    //   247: astore_1
    //   248: aload_3
    //   249: ifnull +7 -> 256
    //   252: aload_3
    //   253: invokevirtual 432	java/io/FileReader:close	()V
    //   256: aload_2
    //   257: ifnull +7 -> 264
    //   260: aload_2
    //   261: invokevirtual 433	java/io/BufferedReader:close	()V
    //   264: aload_1
    //   265: athrow
    //   266: astore_2
    //   267: ldc 78
    //   269: ldc_w 435
    //   272: invokestatic 438	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   275: pop
    //   276: aload_2
    //   277: invokevirtual 439	java/io/IOException:printStackTrace	()V
    //   280: goto -16 -> 264
    //   283: aload_3
    //   284: invokevirtual 447	java/lang/String:trim	()Ljava/lang/String;
    //   287: pop
    //   288: aload_3
    //   289: areturn
    //   290: astore 4
    //   292: aload 5
    //   294: astore_2
    //   295: aload_1
    //   296: astore_3
    //   297: aload 4
    //   299: astore_1
    //   300: goto -52 -> 248
    //   303: astore 4
    //   305: aload_1
    //   306: astore_3
    //   307: aload 4
    //   309: astore_1
    //   310: goto -62 -> 248
    //   313: astore 5
    //   315: aload 7
    //   317: astore 4
    //   319: goto -143 -> 176
    //   322: astore 5
    //   324: aload_2
    //   325: astore 4
    //   327: goto -151 -> 176
    //   330: astore 5
    //   332: goto -236 -> 96
    //   335: astore 5
    //   337: aload_2
    //   338: astore 4
    //   340: goto -244 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	LauncherApplication
    //   0	343	1	paramString	String
    //   9	252	2	localObject1	Object
    //   266	11	2	localIOException1	java.io.IOException
    //   294	44	2	localObject2	Object
    //   20	287	3	str1	String
    //   14	203	4	localObject3	Object
    //   290	8	4	localObject4	Object
    //   303	5	4	localObject5	Object
    //   317	22	4	localObject6	Object
    //   11	1	5	localObject7	Object
    //   91	25	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   167	126	5	localIOException2	java.io.IOException
    //   313	1	5	localIOException3	java.io.IOException
    //   322	1	5	localIOException4	java.io.IOException
    //   330	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   335	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   3	239	6	str2	String
    //   6	310	7	localObject8	Object
    //   22	72	8	localObject9	Object
    //   17	153	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   54	58	74	java/io/IOException
    //   62	66	74	java/io/IOException
    //   24	33	91	java/io/FileNotFoundException
    //   124	128	147	java/io/IOException
    //   136	141	147	java/io/IOException
    //   24	33	167	java/io/IOException
    //   204	208	227	java/io/IOException
    //   216	221	227	java/io/IOException
    //   24	33	247	finally
    //   101	110	247	finally
    //   115	120	247	finally
    //   181	190	247	finally
    //   195	200	247	finally
    //   252	256	266	java/io/IOException
    //   260	264	266	java/io/IOException
    //   33	45	290	finally
    //   45	50	303	finally
    //   33	45	313	java/io/IOException
    //   45	50	322	java/io/IOException
    //   33	45	330	java/io/FileNotFoundException
    //   45	50	335	java/io/FileNotFoundException
  }
  
  public static void setFestivalScreenCount(Context paramContext, int paramInt)
  {
    if (sScreenCountFestival != paramInt)
    {
      sScreenCountFestival = paramInt;
      paramContext = paramContext.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
      paramContext.putInt("screencount.festival", paramInt);
      paramContext.commit();
    }
  }
  
  public static void setHomeScreenIndex(Context paramContext, int paramInt)
  {
    setHomeScreenIndex(paramContext, paramInt, true);
  }
  
  public static void setHomeScreenIndex(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (sScreenIndexNormal != paramInt)
    {
      sScreenIndexNormal = paramInt;
      paramContext = paramContext.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
      paramContext.putInt("homescreenindex", paramInt);
      paramContext.commit();
    }
  }
  
  public static void setScreenCount(Context paramContext, int paramInt)
  {
    setScreenCount(paramContext, paramInt, true);
  }
  
  public static void setScreenCount(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (sScreenCountNormal != paramInt)
    {
      sScreenCountNormal = paramInt;
      paramContext = paramContext.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
      paramContext.putInt("screencount", paramInt);
      paramContext.commit();
    }
    getInst().insertLog("HOME", null, paramInt, true);
  }
  
  public static void setScreenModeForFestival(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
    paramContext.putInt("screenmode.festival", paramInt);
    paramContext.commit();
    sScreenModeForFestival = paramInt;
  }
  
  public static void setScreenModeForSecret(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
    paramContext.putInt("screenmode.secret", paramInt);
    paramContext.commit();
    sScreenModeForSecret = paramInt;
  }
  
  public static void setSecretScreenCount(Context paramContext, int paramInt)
  {
    if (sScreenCountSecret != paramInt)
    {
      sScreenCountSecret = paramInt;
      paramContext = paramContext.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
      paramContext.putInt("screencount.secret", paramInt);
      paramContext.commit();
    }
  }
  
  public boolean checkFactoryMode()
  {
    return (isFactorySim()) || (isFactoryMode());
  }
  
  public String getBinaryType()
  {
    return SystemProperties.get("ro.build.type", "Unknown");
  }
  
  public DVFSHelper getBusBoosterObject()
  {
    return this.busBooster;
  }
  
  public DVFSHelper getCpuBoosterObject()
  {
    return this.cpuBooster;
  }
  
  public DVFSHelper getCpuMaxBoosterObject()
  {
    return this.cpuMaxBooster;
  }
  
  public DVFSHelper getGpuBoosterObject()
  {
    return this.gpuBooster;
  }
  
  Launcher getLauncher()
  {
    if (sLauncher != null) {
      return (Launcher)sLauncher.get();
    }
    return null;
  }
  
  LauncherProvider getLauncherProvider()
  {
    return (LauncherProvider)sLauncherProvider.get();
  }
  
  LauncherModel getModel()
  {
    return this.mModel;
  }
  
  PkgResCache getPkgResCache()
  {
    return this.mPkgResCache;
  }
  
  PkgResCache getPkgResCacheForMenu()
  {
    return this.mPkgResCacheForMenu;
  }
  
  public WorkspaceSpanCalculator getSpanCalculator()
  {
    return this.mSpanCalculator;
  }
  
  ThemeLoader getThemeLoader()
  {
    return this.mThemeLoader;
  }
  
  public void insertLog(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    ContentValues localContentValues;
    if (this.SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE)
    {
      localContentValues = new ContentValues();
      localContentValues.put("app_id", "com.sec.android.app.launcher");
      localContentValues.put("feature", paramString1);
      if (paramString2 != null) {
        localContentValues.put("extra", paramString2);
      }
      if (paramLong != -1L) {
        localContentValues.put("value", Long.valueOf(1000L * paramLong));
      }
      paramString1 = new Intent();
      if (!paramBoolean) {
        break label117;
      }
      paramString1.setAction("com.samsung.android.providers.context.log.action.REPORT_APP_STATUS_SURVEY");
    }
    for (;;)
    {
      paramString1.putExtra("data", localContentValues);
      paramString1.setPackage("com.samsung.android.providers.context");
      sendBroadcast(paramString1);
      return;
      label117:
      paramString1.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
    }
  }
  
  public boolean isKnoxMode()
  {
    if (this.sKnox == -1) {
      this.sKnox = 0;
    }
    try
    {
      Bundle localBundle = PersonaManager.getKnoxInfoForApp(this, "isKnoxMode");
      if (("2.0".equals(localBundle.getString("version"))) && ("true".equals(localBundle.getString("isKnoxMode")))) {
        this.sKnox = 1;
      }
      if (this.sKnox == 1) {
        return true;
      }
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      for (;;)
      {
        Log.e("LauncherApplication", "not call android.os.PersonaManager." + localNoClassDefFoundError);
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      for (;;)
      {
        Log.e("LauncherApplication", "not call getKnoxInfoForApp." + localNoSuchMethodError);
      }
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    Object localObject1 = getResources();
    boolean bool;
    int i;
    if ((ViewConfiguration.get(this).hasPermanentMenuKey()) || (((Resources)localObject1).getBoolean(2131427330)))
    {
      bool = true;
      sHasMenuKey = bool;
      i = ((Resources)localObject1).getConfiguration().screenLayout & 0xF;
      if (i != 1) {
        break label1040;
      }
      bool = true;
      label56:
      sIsScreenSmall = bool;
      if ((i != 3) && (i != 4)) {
        break label1045;
      }
      bool = true;
      label72:
      sIsScreenLarge = bool;
      sScreenDensity = ((Resources)localObject1).getDisplayMetrics().density;
      sIsTabletLayout = ((Resources)localObject1).getBoolean(2131427331);
      sIsDeleteDropTargetTop = ((Resources)localObject1).getBoolean(2131427335);
      sIsDeleteDropTargetTextRight = ((Resources)localObject1).getBoolean(2131427336);
      sIsAppsListAllowed = ((Resources)localObject1).getBoolean(2131427332);
      sIsWidgetSearchTextColorLight = ((Resources)localObject1).getBoolean(2131427334);
      if (((Resources)localObject1).getConfiguration().smallestScreenWidthDp < 800) {
        break label1050;
      }
      bool = true;
      label158:
      sIsLargeTabletLayout = bool;
      sIsUsingMoreLineinFolder = ((Resources)localObject1).getBoolean(2131427343);
      this.mThemeLoader = new ThemeLoader(getApplicationContext());
      if (("HERA".equals("HERA")) || (mProductName.startsWith("jsglte"))) {
        sMagazineLauncher = true;
      }
      this.mMenuAppModel = MenuAppModel.INSTANCE;
      this.mMenuAppModel.setLauncherApplication(this);
      this.mPkgResCache = new PkgResCache(this);
      bool = ((Resources)localObject1).getBoolean(2131427341);
      sMenuIconSize = 0;
      if (bool) {
        i = 0;
      }
    }
    try
    {
      sMenuIconSize = (int)getResources().getDimension(2131624604);
      float f = getResources().getDimension(2131624134);
      i = (int)f;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Object localObject2;
      for (;;) {}
    }
    if (sMenuIconSize == i) {
      sMenuIconSize = 0;
    }
    if (this.mThemeLoader.isSupportFestival()) {
      sFestivalPageLauncher = true;
    }
    if (sFestivalPageLauncher)
    {
      this.mModel = new LauncherExModel(this, this.mPkgResCache);
      localObject2 = new IntentFilter("com.bst.action.PICKUP_FESTIVAL");
      ((IntentFilter)localObject2).addAction("com.bst.action.PICKUP_COMMON");
      ((IntentFilter)localObject2).addAction("com.sec.festival.FESTIVAL_SETTINGS_CHANGED");
      ((IntentFilter)localObject2).addAction("com.sec.festival.FESTIVAL_HOME_CHANGED");
      registerReceiver(this.mModel, (IntentFilter)localObject2);
    }
    for (;;)
    {
      this.mSpanCalculator = WorkspaceSpanCalculator.INSTANCE;
      this.mSpanCalculator.setLauncherApplication(this);
      localObject2 = new IntentFilter("android.intent.action.PACKAGE_ADDED");
      ((IntentFilter)localObject2).addAction("android.intent.action.PACKAGE_REMOVED");
      ((IntentFilter)localObject2).addAction("android.intent.action.PACKAGE_CHANGED");
      ((IntentFilter)localObject2).addAction("android.intent.action.STK_TITLE_IS_LOADED");
      ((IntentFilter)localObject2).addDataScheme("package");
      registerReceiver(this.mModel, (IntentFilter)localObject2);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
      ((IntentFilter)localObject2).addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
      ((IntentFilter)localObject2).addAction("android.intent.action.CONFIGURATION_CHANGED");
      if (CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension")) {
        ((IntentFilter)localObject2).addAction("com.sec.sprextension.FORCE_LAUNCHER_REFRESH");
      }
      registerReceiver(this.mModel, (IntentFilter)localObject2);
      localObject2 = getContentResolver();
      ((ContentResolver)localObject2).registerContentObserver(LauncherSettings.Favorites.CONTENT_URI, true, this.mFavoritesObserver);
      SharedPreferences localSharedPreferences = getSharedPreferences("com.sec.android.app.launcher.prefs", 0);
      Object localObject3 = CscFeature.getInstance();
      sMaxScreenCount = ((Resources)localObject1).getInteger(2131492873);
      sScreenCountNormal = localSharedPreferences.getInt("screencount", 0);
      if ((sScreenCountNormal <= 0) || (sScreenCountNormal > sMaxScreenCount))
      {
        sScreenCountNormal = ((CscFeature)localObject3).getInteger("CscFeature_Launcher_TotalPageCount");
        if ((sScreenCountNormal <= 0) || (sScreenCountNormal > sMaxScreenCount))
        {
          sScreenCountNormal = ((Resources)localObject1).getInteger(2131492871);
          if ((sScreenCountNormal <= 0) || (sScreenCountNormal > sMaxScreenCount)) {
            sScreenCountNormal = sMaxScreenCount;
          }
        }
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        localEditor.putInt("screencount", sScreenCountNormal);
        localEditor.commit();
      }
      sScreenIndexNormal = localSharedPreferences.getInt("homescreenindex", -1);
      if ((sScreenIndexNormal < 0) || (sScreenIndexNormal >= sScreenCountNormal))
      {
        sScreenIndexNormal = ((CscFeature)localObject3).getInteger("CscFeature_Launcher_DefaultPageNumber");
        if ((sScreenIndexNormal < 0) || (sScreenIndexNormal >= sScreenCountNormal))
        {
          sScreenIndexNormal = ((Resources)localObject1).getInteger(2131492874);
          if ((sScreenIndexNormal < 0) || (sScreenIndexNormal >= sScreenCountNormal)) {
            sScreenIndexNormal = 0;
          }
        }
        localObject3 = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject3).putInt("homescreenindex", sScreenIndexNormal);
        ((SharedPreferences.Editor)localObject3).commit();
      }
      if (sFestivalPageLauncher)
      {
        sMaxFestivalScreenCount = ((Resources)localObject1).getInteger(2131492877);
        sScreenCountFestival = localSharedPreferences.getInt("screencount.festival", 0);
        sScreenModeForFestival = localSharedPreferences.getInt("screenmode.festival", 0);
        if ((sScreenCountFestival < 0) || (sScreenCountFestival > sMaxFestivalScreenCount))
        {
          sScreenCountFestival = 0;
          localObject1 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject1).putInt("screencount.festival", sScreenCountFestival);
          ((SharedPreferences.Editor)localObject1).commit();
        }
      }
      this.cpuBooster = new DVFSHelper(getApplicationContext(), 12);
      this.busBooster = new DVFSHelper(getApplicationContext(), 19);
      this.cpuMaxBooster = new DVFSHelper(getApplicationContext(), 14);
      this.gpuBooster = new DVFSHelper(getApplicationContext(), 16);
      this.gpuBooster.addExtraOptionsByDefaultPolicy("Launcher_homemenu");
      ((ContentResolver)localObject2).registerContentObserver(BadgeCache.BADGE_URI, true, this.mBadgeObserver);
      this.mModel.reloadBadges();
      if (CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension"))
      {
        Log.d("LauncherApplication", "registerSprintFolderObserver");
        ((ContentResolver)localObject2).registerContentObserver(LauncherProviderID.SPRINTFOLDER_URI, true, this.mSprintFolderObserver);
      }
      this.SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE = FloatingFeature.getInstance().getEnableStatus("SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE");
      sIsTheFisrt = true;
      return;
      bool = false;
      break;
      label1040:
      bool = false;
      break label56;
      label1045:
      bool = false;
      break label72;
      label1050:
      bool = false;
      break label158;
      if (isMenuIconSizeChanged())
      {
        this.mPkgResCacheForMenu = new PkgResCache(this, sMenuIconSize);
        this.mModel = new LauncherModel(this, this.mPkgResCache, this.mPkgResCacheForMenu);
      }
      else
      {
        this.mModel = new LauncherModel(this, this.mPkgResCache);
      }
    }
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    unregisterReceiver(this.mModel);
    ContentResolver localContentResolver = getContentResolver();
    localContentResolver.unregisterContentObserver(this.mFavoritesObserver);
    localContentResolver.unregisterContentObserver(this.mBadgeObserver);
    if (CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension"))
    {
      Log.d("LauncherApplication", "unregisterSprintFolderObserver");
      localContentResolver.unregisterContentObserver(this.mSprintFolderObserver);
    }
    this.cpuBooster = null;
    this.busBooster = null;
    this.cpuMaxBooster = null;
    this.gpuBooster = null;
  }
  
  void setLauncher(Launcher paramLauncher)
  {
    sLauncher = new WeakReference(paramLauncher);
  }
  
  void setLauncherProvider(LauncherProvider paramLauncherProvider)
  {
    sLauncherProvider = new WeakReference(paramLauncherProvider);
  }
  
  public void updatePageCount() {}
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/LauncherApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */