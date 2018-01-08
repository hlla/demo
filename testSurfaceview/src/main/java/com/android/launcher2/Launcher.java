package com.android.launcher2;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.app.ActivityGroup;
import android.app.ActivityOptions;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.app.StatusBarManager;
import android.app.enterprise.ApplicationPolicy;
import android.app.enterprise.EnterpriseDeviceManager;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.DVFSHelper;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.TextKeyListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.interpolator.SineInOut90;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView.SearchAutoComplete;
import android.widget.Toast;
import com.android.launcher2.guide.CreateFolderGuider;
import com.android.launcher2.guide.GuideFragment;
import com.android.launcher2.popup.PopupMenu;
import com.android.launcher2.popup.PopupMenu.OnDismissListener;
import com.android.launcher2.popup.PopupMenu.OnMenuItemClickListener;
import com.android.launcher2.tabs.TabManager;
import com.google.android.hotword.client.HotwordServiceClient;
import com.samsung.android.feature.FloatingFeature;
import com.samsung.android.service.gesture.GestureEvent;
import com.samsung.android.service.gesture.GestureListener;
import com.samsung.android.service.gesture.GestureManager;
import com.samsung.android.service.gesture.GestureManager.ServiceConnectionListener;
import com.samsung.surfacewidget.SurfaceWidgetProviderInfo;
import com.sec.android.app.CscFeature;
import com.sec.dtl.launcher.GyroForShadow;
import com.sec.dtl.launcher.Talk;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Launcher
  extends ActivityGroup
  implements PopupMenu.OnMenuItemClickListener, LauncherModel.Callbacks, GestureListener, GestureManager.ServiceConnectionListener
{
  private static final String ACTION_HOME_MODE = "com.android.launcher.action.HOME_MODE_CHANGE";
  private static final String ACTION_HOME_RESTORE = "com.android.launcher.action.ACTION_HOME_RESTORE";
  private static final String ACTION_STATUSBAR_COLLAPSE = "com.android.systemui.statusbar.COLLAPSED";
  private static final String ACTION_STATUSBAR_EXPAND = "com.android.systemui.statusbar.EXPANDED";
  static final String ADD_TOAST_POPUP_DISMISSED_KEY = "add.toast.popup.dismissed.key";
  public static boolean CSCFEATURE_LAUNCHER_DISABLEHELPUI = false;
  public static boolean CSCFEATURE_LAUNCHER_DISABLETILTEFFECT = false;
  public static boolean CSCFEATURE_LAUNCHER_DYNAMICCSCFEATURE = false;
  public static boolean CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE = false;
  public static boolean CSCFEATURE_LAUNCHER_REPLACEHOTSEATAREAINEDITMODE = false;
  public static boolean CSCFEATURE_LAUNCHER_THEME_ENABLE = false;
  public static boolean CSCFEATURE_LAUNCHER_USM_EXISTS = false;
  private static final boolean DEBUGGABLE;
  private static final boolean DEBUG_ADD_WIDGET_VIA_INTENT = false;
  private static final String DEBUG_ADD_WIDGET_VIA_INTENT_TAG = "Launcher.AddWidgetViaIntent";
  static final String DISABLE_TOAST_POPUP_DISMISSED_KEY = "disable.toast.popup.dismissed.key";
  static final String DUMP_STATE_PROPERTY = "launcher_dump_state";
  private static final String EXTRA_HOME_VIEW_HIDDEN = "extra_home_view_hidden";
  private static final String EXTRA_LAUNCHER_ACTION = "sec.android.intent.extra.LAUNCHER_ACTION";
  private static final String HELP_ACTIVITY_TYPE = "help_activity_type";
  public static final String HELP_HUB_CONTENT_URI = "content://com.samsung.helphub.provider/help_page_status/";
  private static final String LAUNCHER_ACTION_ALL_APPS = "com.android.launcher2.ALL_APPS";
  private static final String LAUNCHER_ACTION_IDLE = "com.android.launcher2.IDLE";
  public static final String LAUNCHER_THEME_ACTION = "com.sec.android.intent.action.THEME_CHOOSER";
  private static final String MORE_SERVICE_DOWNLOADABLE_APP_LIST_CLASS_NAME = "com.sec.android.app.moreservices.moreservices";
  private static final String MORE_SERVICE_PACKAGE_NAME = "com.sec.android.app.moreservices";
  static final String PREFERENCES = "com.sec.android.app.launcher.prefs";
  private static final int REQUEST_CODE_UNINSTALL_PACKAGE = 111;
  static final int REQUEST_CREATE_APPWIDGET = 5;
  private static final String SAMSUNG_APPS_DOWNLOADABLE_APP_LIST_CLASS_NAME = "com.sec.android.app.samsungapps.downloadableapps.DownloadableAppsActivity";
  private static final String SAMSUNG_APPS_PACKAGE_NAME = "com.sec.android.app.samsungapps";
  public static boolean SEC_PRODUCT_FEATURE_LAUNCHER_KITKAT_ADD_TO_HOMESCREEN_CONCEPT = false;
  private static final String SETTINGS_SYSTEMUI_TRANSPARENCY = "android.wallpaper.settings_systemui_transparency";
  public static long SHOW_ALL_APPS_TRANSITION_DURATION = 0L;
  private static final boolean SYSTEMUI_TRANSPARENCY = true;
  private static final String TAG = "Launcher";
  public static boolean UseLauncherHighPriority = false;
  public static boolean UseQwertyKeypad = false;
  static final int VIBRATE_DURATION = 35;
  static final String WIDGET_RESIZE_UPDATE_PAUSE = "com.sec.android.intent.action.HOME_PAUSE";
  static final String WIDGET_RESIZE_UPDATE_RESUME = "com.sec.android.intent.action.HOME_RESUME";
  public static boolean bSupportAirMove = false;
  public static int changeWallpaperStatus;
  static DragState dragstate;
  public static boolean isExitingFromHelp;
  public static boolean isExitingFromWallpaperActivity;
  public static boolean isHelpAppRunning;
  public static boolean isHelpIntentFired;
  public static boolean isHomescreenRestoring;
  public static boolean isMotionDialogLaunching;
  public static boolean isSystemAppDisable;
  public static boolean is_TB;
  private static Launcher launcher = null;
  public static boolean mAlwaysMicOn;
  private static boolean mEasyStateForHelpApp;
  public static int mIsBabyCryingEnable;
  public static int mIsDoorbellEnable;
  public static boolean mIsExpandStatusBar;
  public static ArrayList<String> mNonDisableItems;
  public static String mPackageTobeDisabled;
  private static Intent mPendingIntent;
  public static ArrayList<String> mRemovableAppItems;
  public static ArrayList<String> mRemovableCustomerAppItems;
  public static ArrayList<String> mRemovablePreloadAppItems;
  public static boolean mTalkbackEnable;
  public static int sActivityOrientation;
  private static volatile Boolean sHelpHubAvailable;
  private static boolean sHwPopupMenuShowing;
  public static Intent sInComingIntentHelpHub;
  public static boolean sIsEditFromHome;
  public static boolean sIsFestivalModeOn;
  public static boolean sIsHeadlinesAppEnable;
  private static boolean sIsHomeEditMode;
  private static boolean sIsHomeRemoveMode;
  public static boolean sIsMagazineHomeEnable;
  public static boolean sIsSecretModeOn;
  public static boolean sIsStopped;
  static float sMenuBgDarkenAmountNormal;
  private static boolean sPopupMenuShowing;
  public static Paint sViewLayerPaint;
  public static int sWhichTransitionEffect;
  public static boolean wasWidgetsTabShown;
  final String AUTHORITY = "content.alwaysmicon.provider";
  final Uri content_uri = Uri.parse("content://content.alwaysmicon.provider");
  private boolean isEnteredFromMagazine = false;
  public boolean isFolderCreatedFromMenuButton = false;
  private SparseArray<ActivityResultCallback> mActivityCallbacks = new SparseArray();
  private ComponentName mActivityName;
  private final BroadcastReceiver mAirGestureSettingsChangeReceiver = new AirGestureSettingsChangeReceiver(null);
  private final ContentObserver mAlwaysMicOnObserver = new AlwaysMicOnObserver();
  private AnimationLayer mAnimationLayer;
  private Intent mAppMarketIntent = null;
  private ApplicationPolicy mApplicationPolicy;
  public boolean mAttached = false;
  private boolean mAutoRestart = false;
  private ContentObserver mBabyCryingDetector = new ContentObserver(new Handler())
  {
    public void onChange(boolean paramAnonymousBoolean)
    {
      Launcher.mIsBabyCryingEnable = Settings.System.getInt(Launcher.this.getContentResolver(), "isBabyCryingEnable", 0);
    }
  };
  private BadgeCountReceiver mBadgeCountChangedReceiver;
  private ChangeCallAppReceiver mChangeCallAppReceiver;
  private final BroadcastReceiver mCloseSystemDialogsReceiver = new CloseSystemDialogsIntentReceiver(null);
  private View mDarkenView;
  private SpannableStringBuilder mDefaultKeySsb = null;
  private ContentObserver mDoorbellDetector = new ContentObserver(new Handler())
  {
    public void onChange(boolean paramAnonymousBoolean)
    {
      Launcher.mIsDoorbellEnable = Settings.System.getInt(Launcher.this.getContentResolver(), "isDoorbellEnable", 0);
    }
  };
  private EnterpriseDeviceManager mEnterpriseDeviceManager;
  private boolean mExitingAllApps = false;
  private String mFactoryModeString;
  private FestivalPageManager mFestivalPageManager;
  public boolean mFocusState;
  private boolean mGestureListenerRegistered = false;
  private GestureManager mGestureManager;
  private boolean mGestureServiceConnected = false;
  private boolean mHasMenuKey = false;
  HomeView mHomeView;
  private HotwordServiceClient mHotwordServiceClient;
  boolean mInMenu = false;
  private boolean mIsDestroyed = false;
  private boolean mIsExternalHelpActivity = false;
  private boolean mIsFactoryMode;
  private CharSequence mMarketLabelName;
  private View mMenuButtonView;
  private MenuView mMenuView;
  private LauncherModel mModel;
  private boolean mOnResumeNeedsLoad;
  private Menu mOptionsMenu;
  private boolean mPaused = false;
  private PkgResCache mPkgResCache;
  private PkgResCache mPkgResCacheForMenu;
  private PopupMenu mPopupMenu;
  private int mPrevOrientationHelp = 0;
  private final BroadcastReceiver mReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getAction();
      if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
      {
        Launcher.this.exitWidgetResizeMode();
        Launcher.this.mHomeView.updateRunning();
      }
      do
      {
        return;
        if ("android.intent.action.USER_PRESENT".equals(paramAnonymousContext))
        {
          Launcher.this.mHomeView.updateRunning();
          return;
        }
        if (paramAnonymousContext.equals("android.intent.action.REQUEST_HOME_COUNT"))
        {
          paramAnonymousContext = new Intent("android.intent.action.RESPONSE_HOME_COUNT");
          paramAnonymousContext.putExtra("HOME_ALL_COUNT", Launcher.this.mModel.HomeViewCount());
          Launcher.this.sendBroadcast(paramAnonymousContext);
          return;
        }
        if (paramAnonymousContext.equals("android.intent.action.REQUEST_WIDGET_COUNT"))
        {
          int i = Launcher.this.AllWidgetCount();
          paramAnonymousContext = new Intent("android.intent.action.RESPONSE_WIDGET_COUNT");
          paramAnonymousContext.putExtra("WIDGET_ALL_COUNT", i);
          Launcher.this.sendBroadcast(paramAnonymousContext);
          return;
        }
        if (paramAnonymousContext.equals("com.android.launcher.action.ACTION_HOME_RESTORE"))
        {
          Log.d("Launcher", "receive ACTION_HOME_RESTORE");
          Launcher.this.RestoreHomeScreen();
          return;
        }
        if (paramAnonymousContext.equals("com.android.systemui.statusbar.EXPANDED"))
        {
          Launcher.mIsExpandStatusBar = true;
          return;
        }
      } while (!paramAnonymousContext.equals("com.android.systemui.statusbar.COLLAPSED"));
      Launcher.mIsExpandStatusBar = false;
    }
  };
  public boolean mRemainSavedInstance = true;
  private boolean mRestoring;
  private boolean mResumed = true;
  private SamsungWidgetPackageManager mSamsungWidgetPackageManager;
  private SecretPageManager mSecretPageManager;
  private boolean mShowEmptyPageMsg;
  private WorkspaceSpanCalculator mSpanCalculator;
  private ArrayList<StateAnimatorProvider> mStateAnimatorProviders = new ArrayList();
  private StatusBarManager mStatusBarManager;
  private SurfaceWidgetPackageManager mSurfaceWidgetPackageManager;
  private final BroadcastReceiver mTalkbackEnableReceiver = new TalkbackEnableIntentReceiver(null);
  private Animator mTransitionAnimator;
  private boolean mTransitioningToAllApps;
  private ArrayList<WidgetAddInfo> mWidgetAddInfo = new ArrayList();
  
  static
  {
    DEBUGGABLE = Utilities.DEBUGGABLE();
    isHomescreenRestoring = false;
    sIsHeadlinesAppEnable = false;
    sIsMagazineHomeEnable = false;
    mIsExpandStatusBar = false;
    isSystemAppDisable = true;
    mNonDisableItems = new ArrayList();
    mRemovablePreloadAppItems = new ArrayList();
    mRemovableCustomerAppItems = new ArrayList();
    mRemovableAppItems = new ArrayList();
    mPackageTobeDisabled = "";
    isHelpAppRunning = false;
    isHelpIntentFired = false;
    wasWidgetsTabShown = false;
    isExitingFromWallpaperActivity = false;
    isMotionDialogLaunching = false;
    changeWallpaperStatus = -1;
    sPopupMenuShowing = false;
    sHwPopupMenuShowing = false;
    sHelpHubAvailable = null;
    mEasyStateForHelpApp = false;
    SHOW_ALL_APPS_TRANSITION_DURATION = 330L;
    is_TB = false;
    CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE = false;
    CSCFEATURE_LAUNCHER_DISABLETILTEFFECT = false;
    sIsHomeEditMode = false;
    sIsHomeRemoveMode = false;
    UseLauncherHighPriority = FloatingFeature.getInstance().getEnableStatus("SEC_FLOATING_FEATURE_LAUNCHER_BOOT_HIGHPRIORITY");
    UseQwertyKeypad = false;
    CSCFEATURE_LAUNCHER_REPLACEHOTSEATAREAINEDITMODE = false;
    sIsEditFromHome = false;
    CSCFEATURE_LAUNCHER_DISABLEHELPUI = true;
    CSCFEATURE_LAUNCHER_DYNAMICCSCFEATURE = false;
    CSCFEATURE_LAUNCHER_USM_EXISTS = false;
    isExitingFromHelp = false;
    CSCFEATURE_LAUNCHER_THEME_ENABLE = false;
    sIsFestivalModeOn = false;
    SEC_PRODUCT_FEATURE_LAUNCHER_KITKAT_ADD_TO_HOMESCREEN_CONCEPT = false;
    sIsSecretModeOn = false;
    sIsStopped = false;
    sActivityOrientation = 0;
    sWhichTransitionEffect = 0;
    mAlwaysMicOn = true;
    mIsBabyCryingEnable = 0;
    mIsDoorbellEnable = 0;
    mTalkbackEnable = false;
    sViewLayerPaint = new Paint();
    sViewLayerPaint.setFilterBitmap(true);
    sViewLayerPaint.setAntiAlias(true);
  }
  
  public Launcher()
  {
    super(false);
    launcher = this;
    Log.d("Launcher", "Launcher ctor: " + System.identityHashCode(this));
    ShadowStyleable.init();
  }
  
  private int AllWidgetCount()
  {
    return new AvailableAppWidgetListProvider(this).getAvailableWidgets().size() + new AvailableSamsungWidgetListProvider(this).getAvailableWidgets().size() + new AvailableShortcutWidgetListProvider(this).getAvailableWidgets().size() + new AvailableSurfaceWidgetListProvider(this).getAvailableWidgets().size();
  }
  
  private boolean acceptFilter()
  {
    return !((InputMethodManager)getSystemService("input_method")).isFullscreenMode();
  }
  
  /* Error */
  private void addNonDisableAppToList()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 642	com/android/launcher2/Launcher:getResources	()Landroid/content/res/Resources;
    //   4: ldc_w 643
    //   7: invokevirtual 649	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   10: astore_2
    //   11: aload_2
    //   12: ldc_w 651
    //   15: invokestatic 657	com/android/launcher2/LauncherProvider:beginDocument	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V
    //   18: aload_2
    //   19: invokeinterface 662 1 0
    //   24: istore_1
    //   25: iload_1
    //   26: iconst_1
    //   27: if_icmpeq +52 -> 79
    //   30: iload_1
    //   31: iconst_4
    //   32: if_icmpne +16 -> 48
    //   35: getstatic 333	com/android/launcher2/Launcher:mNonDisableItems	Ljava/util/ArrayList;
    //   38: aload_2
    //   39: invokeinterface 665 1 0
    //   44: invokevirtual 669	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   47: pop
    //   48: aload_2
    //   49: invokeinterface 672 1 0
    //   54: istore_1
    //   55: goto -30 -> 25
    //   58: astore_3
    //   59: aload_3
    //   60: invokevirtual 675	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   63: goto -45 -> 18
    //   66: astore_3
    //   67: aload_3
    //   68: invokevirtual 676	java/io/IOException:printStackTrace	()V
    //   71: goto -53 -> 18
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 675	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   79: return
    //   80: astore_2
    //   81: aload_2
    //   82: invokevirtual 676	java/io/IOException:printStackTrace	()V
    //   85: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	Launcher
    //   24	31	1	i	int
    //   10	39	2	localXmlResourceParser	android.content.res.XmlResourceParser
    //   74	2	2	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   80	2	2	localIOException1	java.io.IOException
    //   58	2	3	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   66	2	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   11	18	58	org/xmlpull/v1/XmlPullParserException
    //   11	18	66	java/io/IOException
    //   18	25	74	org/xmlpull/v1/XmlPullParserException
    //   35	48	74	org/xmlpull/v1/XmlPullParserException
    //   48	55	74	org/xmlpull/v1/XmlPullParserException
    //   18	25	80	java/io/IOException
    //   35	48	80	java/io/IOException
    //   48	55	80	java/io/IOException
  }
  
  /* Error */
  private void addNonDisableAppToListCsc()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 4
    //   12: aload 7
    //   14: astore_2
    //   15: new 681	java/io/File
    //   18: dup
    //   19: ldc_w 683
    //   22: invokespecial 686	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 8
    //   27: aload 4
    //   29: astore_3
    //   30: aload 7
    //   32: astore_2
    //   33: aload 8
    //   35: invokevirtual 689	java/io/File:isFile	()Z
    //   38: ifeq +94 -> 132
    //   41: aload 4
    //   43: astore_3
    //   44: aload 7
    //   46: astore_2
    //   47: aload 8
    //   49: invokevirtual 693	java/io/File:length	()J
    //   52: lconst_0
    //   53: lcmp
    //   54: ifle +78 -> 132
    //   57: aload 7
    //   59: astore_2
    //   60: new 695	java/io/FileReader
    //   63: dup
    //   64: ldc_w 683
    //   67: invokespecial 696	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   70: astore_3
    //   71: invokestatic 702	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   74: astore_2
    //   75: aload_2
    //   76: iconst_1
    //   77: invokevirtual 705	org/xmlpull/v1/XmlPullParserFactory:setNamespaceAware	(Z)V
    //   80: aload_2
    //   81: invokevirtual 709	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   84: astore_2
    //   85: aload_2
    //   86: aload_3
    //   87: invokeinterface 713 2 0
    //   92: aload_2
    //   93: invokeinterface 662 1 0
    //   98: istore_1
    //   99: iload_1
    //   100: iconst_1
    //   101: if_icmpeq +31 -> 132
    //   104: iload_1
    //   105: iconst_4
    //   106: if_icmpne +16 -> 122
    //   109: getstatic 333	com/android/launcher2/Launcher:mNonDisableItems	Ljava/util/ArrayList;
    //   112: aload_2
    //   113: invokeinterface 665 1 0
    //   118: invokevirtual 669	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload_2
    //   123: invokeinterface 672 1 0
    //   128: istore_1
    //   129: goto -30 -> 99
    //   132: aload_3
    //   133: ifnull +7 -> 140
    //   136: aload_3
    //   137: invokevirtual 716	java/io/FileReader:close	()V
    //   140: return
    //   141: astore 4
    //   143: aload 5
    //   145: astore_3
    //   146: aload_3
    //   147: astore_2
    //   148: aload 4
    //   150: invokevirtual 675	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   153: aload_3
    //   154: ifnull -14 -> 140
    //   157: aload_3
    //   158: invokevirtual 716	java/io/FileReader:close	()V
    //   161: return
    //   162: astore_2
    //   163: return
    //   164: astore 4
    //   166: aload 6
    //   168: astore_3
    //   169: aload_3
    //   170: astore_2
    //   171: aload 4
    //   173: invokevirtual 676	java/io/IOException:printStackTrace	()V
    //   176: aload_3
    //   177: ifnull -37 -> 140
    //   180: aload_3
    //   181: invokevirtual 716	java/io/FileReader:close	()V
    //   184: return
    //   185: astore_2
    //   186: return
    //   187: astore_3
    //   188: aload_2
    //   189: ifnull +7 -> 196
    //   192: aload_2
    //   193: invokevirtual 716	java/io/FileReader:close	()V
    //   196: aload_3
    //   197: athrow
    //   198: astore_2
    //   199: return
    //   200: astore_2
    //   201: goto -5 -> 196
    //   204: astore 4
    //   206: aload_3
    //   207: astore_2
    //   208: aload 4
    //   210: astore_3
    //   211: goto -23 -> 188
    //   214: astore 4
    //   216: goto -47 -> 169
    //   219: astore 4
    //   221: goto -75 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	Launcher
    //   98	31	1	i	int
    //   14	134	2	localObject1	Object
    //   162	1	2	localException1	Exception
    //   170	1	2	localObject2	Object
    //   185	8	2	localException2	Exception
    //   198	1	2	localException3	Exception
    //   200	1	2	localException4	Exception
    //   207	1	2	localObject3	Object
    //   29	152	3	localObject4	Object
    //   187	20	3	localObject5	Object
    //   210	1	3	localObject6	Object
    //   10	32	4	localObject7	Object
    //   141	8	4	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   164	8	4	localIOException1	java.io.IOException
    //   204	5	4	localObject8	Object
    //   214	1	4	localIOException2	java.io.IOException
    //   219	1	4	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   1	143	5	localObject9	Object
    //   4	163	6	localObject10	Object
    //   7	51	7	localObject11	Object
    //   25	23	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   15	27	141	org/xmlpull/v1/XmlPullParserException
    //   33	41	141	org/xmlpull/v1/XmlPullParserException
    //   47	57	141	org/xmlpull/v1/XmlPullParserException
    //   60	71	141	org/xmlpull/v1/XmlPullParserException
    //   157	161	162	java/lang/Exception
    //   15	27	164	java/io/IOException
    //   33	41	164	java/io/IOException
    //   47	57	164	java/io/IOException
    //   60	71	164	java/io/IOException
    //   180	184	185	java/lang/Exception
    //   15	27	187	finally
    //   33	41	187	finally
    //   47	57	187	finally
    //   60	71	187	finally
    //   148	153	187	finally
    //   171	176	187	finally
    //   136	140	198	java/lang/Exception
    //   192	196	200	java/lang/Exception
    //   71	99	204	finally
    //   109	122	204	finally
    //   122	129	204	finally
    //   71	99	214	java/io/IOException
    //   109	122	214	java/io/IOException
    //   122	129	214	java/io/IOException
    //   71	99	219	org/xmlpull/v1/XmlPullParserException
    //   109	122	219	org/xmlpull/v1/XmlPullParserException
    //   122	129	219	org/xmlpull/v1/XmlPullParserException
  }
  
  /* Error */
  private void addRemovableAppToList()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 6
    //   15: aconst_null
    //   16: astore_3
    //   17: aconst_null
    //   18: astore 10
    //   20: aconst_null
    //   21: astore 9
    //   23: aconst_null
    //   24: astore 14
    //   26: aconst_null
    //   27: astore 7
    //   29: aconst_null
    //   30: astore_2
    //   31: aconst_null
    //   32: astore 8
    //   34: aconst_null
    //   35: astore 5
    //   37: new 721	java/io/FileInputStream
    //   40: dup
    //   41: new 681	java/io/File
    //   44: dup
    //   45: ldc_w 723
    //   48: invokespecial 686	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: invokespecial 726	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore_1
    //   55: aload 14
    //   57: astore_2
    //   58: aload 13
    //   60: astore_3
    //   61: aload_1
    //   62: ifnull +136 -> 198
    //   65: new 728	java/io/InputStreamReader
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 731	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   73: astore_2
    //   74: new 733	java/io/BufferedReader
    //   77: dup
    //   78: aload_2
    //   79: invokespecial 735	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   82: astore_3
    //   83: aload_3
    //   84: invokevirtual 738	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   87: astore 4
    //   89: aload 4
    //   91: ifnull +99 -> 190
    //   94: aload 4
    //   96: ldc_w 740
    //   99: invokevirtual 746	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   102: ifeq -19 -> 83
    //   105: aload 4
    //   107: ldc_w 748
    //   110: ldc_w 341
    //   113: invokevirtual 752	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   116: ldc_w 754
    //   119: ldc_w 341
    //   122: invokevirtual 752	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   125: astore 4
    //   127: getstatic 339	com/android/launcher2/Launcher:mRemovableAppItems	Ljava/util/ArrayList;
    //   130: aload 4
    //   132: invokevirtual 669	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   135: pop
    //   136: goto -53 -> 83
    //   139: astore 5
    //   141: aload_2
    //   142: astore 6
    //   144: aload_3
    //   145: astore 7
    //   147: aload 7
    //   149: astore_2
    //   150: aload 6
    //   152: astore_3
    //   153: aload_1
    //   154: astore 4
    //   156: aload 5
    //   158: invokevirtual 755	java/io/FileNotFoundException:printStackTrace	()V
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 758	java/io/InputStream:close	()V
    //   169: aload 6
    //   171: ifnull +8 -> 179
    //   174: aload 6
    //   176: invokevirtual 759	java/io/InputStreamReader:close	()V
    //   179: aload 7
    //   181: ifnull +8 -> 189
    //   184: aload 7
    //   186: invokevirtual 760	java/io/BufferedReader:close	()V
    //   189: return
    //   190: aload_3
    //   191: astore 4
    //   193: aload_2
    //   194: astore_3
    //   195: aload 4
    //   197: astore_2
    //   198: aload_1
    //   199: ifnull +7 -> 206
    //   202: aload_1
    //   203: invokevirtual 758	java/io/InputStream:close	()V
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 759	java/io/InputStreamReader:close	()V
    //   214: aload_2
    //   215: ifnull +7 -> 222
    //   218: aload_2
    //   219: invokevirtual 760	java/io/BufferedReader:close	()V
    //   222: return
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 676	java/io/IOException:printStackTrace	()V
    //   228: return
    //   229: astore_1
    //   230: aload_1
    //   231: invokevirtual 676	java/io/IOException:printStackTrace	()V
    //   234: return
    //   235: astore 5
    //   237: aload 12
    //   239: astore_1
    //   240: aload 7
    //   242: astore_2
    //   243: aload 6
    //   245: astore_3
    //   246: aload_1
    //   247: astore 4
    //   249: aload 5
    //   251: invokevirtual 676	java/io/IOException:printStackTrace	()V
    //   254: aload_1
    //   255: ifnull +7 -> 262
    //   258: aload_1
    //   259: invokevirtual 758	java/io/InputStream:close	()V
    //   262: aload 6
    //   264: ifnull +8 -> 272
    //   267: aload 6
    //   269: invokevirtual 759	java/io/InputStreamReader:close	()V
    //   272: aload 7
    //   274: ifnull -85 -> 189
    //   277: aload 7
    //   279: invokevirtual 760	java/io/BufferedReader:close	()V
    //   282: return
    //   283: astore_1
    //   284: aload_1
    //   285: invokevirtual 676	java/io/IOException:printStackTrace	()V
    //   288: return
    //   289: astore_1
    //   290: aload 4
    //   292: ifnull +8 -> 300
    //   295: aload 4
    //   297: invokevirtual 758	java/io/InputStream:close	()V
    //   300: aload_3
    //   301: ifnull +7 -> 308
    //   304: aload_3
    //   305: invokevirtual 759	java/io/InputStreamReader:close	()V
    //   308: aload_2
    //   309: ifnull +7 -> 316
    //   312: aload_2
    //   313: invokevirtual 760	java/io/BufferedReader:close	()V
    //   316: aload_1
    //   317: athrow
    //   318: astore_2
    //   319: aload_2
    //   320: invokevirtual 676	java/io/IOException:printStackTrace	()V
    //   323: goto -7 -> 316
    //   326: astore 5
    //   328: aload 8
    //   330: astore_2
    //   331: aload 10
    //   333: astore_3
    //   334: aload_1
    //   335: astore 4
    //   337: aload 5
    //   339: astore_1
    //   340: goto -50 -> 290
    //   343: astore 5
    //   345: aload_2
    //   346: astore_3
    //   347: aload 8
    //   349: astore_2
    //   350: aload_1
    //   351: astore 4
    //   353: aload 5
    //   355: astore_1
    //   356: goto -66 -> 290
    //   359: astore 5
    //   361: aload_2
    //   362: astore 4
    //   364: aload_3
    //   365: astore_2
    //   366: aload 4
    //   368: astore_3
    //   369: aload_1
    //   370: astore 4
    //   372: aload 5
    //   374: astore_1
    //   375: goto -85 -> 290
    //   378: astore 5
    //   380: goto -140 -> 240
    //   383: astore 5
    //   385: aload_2
    //   386: astore 6
    //   388: goto -148 -> 240
    //   391: astore 5
    //   393: aload_3
    //   394: astore 7
    //   396: aload_2
    //   397: astore 6
    //   399: goto -159 -> 240
    //   402: astore_1
    //   403: aload 5
    //   405: astore 7
    //   407: aload_1
    //   408: astore 5
    //   410: aload 9
    //   412: astore 6
    //   414: aload 11
    //   416: astore_1
    //   417: goto -270 -> 147
    //   420: astore_2
    //   421: aload 5
    //   423: astore 7
    //   425: aload_2
    //   426: astore 5
    //   428: aload 9
    //   430: astore 6
    //   432: goto -285 -> 147
    //   435: astore_3
    //   436: aload 5
    //   438: astore 7
    //   440: aload_3
    //   441: astore 5
    //   443: aload_2
    //   444: astore 6
    //   446: goto -299 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	this	Launcher
    //   54	149	1	localFileInputStream	java.io.FileInputStream
    //   223	2	1	localIOException1	java.io.IOException
    //   229	2	1	localIOException2	java.io.IOException
    //   239	20	1	localObject1	Object
    //   283	2	1	localIOException3	java.io.IOException
    //   289	46	1	localObject2	Object
    //   339	36	1	localObject3	Object
    //   402	6	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   416	1	1	localObject4	Object
    //   30	283	2	localObject5	Object
    //   318	2	2	localIOException4	java.io.IOException
    //   330	67	2	localObject6	Object
    //   420	24	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   16	378	3	localObject7	Object
    //   435	6	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   4	367	4	localObject8	Object
    //   35	1	5	localObject9	Object
    //   139	18	5	localFileNotFoundException4	java.io.FileNotFoundException
    //   235	15	5	localIOException5	java.io.IOException
    //   326	12	5	localObject10	Object
    //   343	11	5	localObject11	Object
    //   359	14	5	localObject12	Object
    //   378	1	5	localIOException6	java.io.IOException
    //   383	1	5	localIOException7	java.io.IOException
    //   391	13	5	localIOException8	java.io.IOException
    //   408	34	5	localObject13	Object
    //   13	432	6	localObject14	Object
    //   27	412	7	localObject15	Object
    //   32	316	8	localObject16	Object
    //   21	408	9	localObject17	Object
    //   18	314	10	localObject18	Object
    //   7	408	11	localObject19	Object
    //   1	237	12	localObject20	Object
    //   10	49	13	localObject21	Object
    //   24	32	14	localObject22	Object
    // Exception table:
    //   from	to	target	type
    //   83	89	139	java/io/FileNotFoundException
    //   94	136	139	java/io/FileNotFoundException
    //   202	206	223	java/io/IOException
    //   210	214	223	java/io/IOException
    //   218	222	223	java/io/IOException
    //   165	169	229	java/io/IOException
    //   174	179	229	java/io/IOException
    //   184	189	229	java/io/IOException
    //   37	55	235	java/io/IOException
    //   258	262	283	java/io/IOException
    //   267	272	283	java/io/IOException
    //   277	282	283	java/io/IOException
    //   37	55	289	finally
    //   156	161	289	finally
    //   249	254	289	finally
    //   295	300	318	java/io/IOException
    //   304	308	318	java/io/IOException
    //   312	316	318	java/io/IOException
    //   65	74	326	finally
    //   74	83	343	finally
    //   83	89	359	finally
    //   94	136	359	finally
    //   65	74	378	java/io/IOException
    //   74	83	383	java/io/IOException
    //   83	89	391	java/io/IOException
    //   94	136	391	java/io/IOException
    //   37	55	402	java/io/FileNotFoundException
    //   65	74	420	java/io/FileNotFoundException
    //   74	83	435	java/io/FileNotFoundException
  }
  
  /* Error */
  private void addRemovableCustomerAppToList()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore_3
    //   11: aload 6
    //   13: astore 4
    //   15: aload 7
    //   17: astore 5
    //   19: aload 8
    //   21: astore_2
    //   22: new 681	java/io/File
    //   25: dup
    //   26: ldc_w 763
    //   29: invokespecial 686	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore 9
    //   34: aload 6
    //   36: astore 4
    //   38: aload 7
    //   40: astore 5
    //   42: aload 8
    //   44: astore_2
    //   45: aload 9
    //   47: invokevirtual 689	java/io/File:isFile	()Z
    //   50: ifeq +136 -> 186
    //   53: aload 6
    //   55: astore 4
    //   57: aload 7
    //   59: astore 5
    //   61: aload 8
    //   63: astore_2
    //   64: aload 9
    //   66: invokevirtual 693	java/io/File:length	()J
    //   69: lconst_0
    //   70: lcmp
    //   71: ifle +115 -> 186
    //   74: aload 6
    //   76: astore 4
    //   78: aload 7
    //   80: astore 5
    //   82: aload 8
    //   84: astore_2
    //   85: new 695	java/io/FileReader
    //   88: dup
    //   89: ldc_w 763
    //   92: invokespecial 696	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   95: astore_3
    //   96: invokestatic 702	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   99: astore_2
    //   100: aload_2
    //   101: iconst_1
    //   102: invokevirtual 705	org/xmlpull/v1/XmlPullParserFactory:setNamespaceAware	(Z)V
    //   105: aload_2
    //   106: invokevirtual 709	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   109: astore 6
    //   111: aload 6
    //   113: aload_3
    //   114: invokeinterface 713 2 0
    //   119: aload_3
    //   120: astore 4
    //   122: aload_3
    //   123: astore 5
    //   125: aload_3
    //   126: astore_2
    //   127: aload 6
    //   129: invokeinterface 662 1 0
    //   134: istore_1
    //   135: iload_1
    //   136: iconst_1
    //   137: if_icmpeq +98 -> 235
    //   140: iload_1
    //   141: iconst_4
    //   142: if_icmpne +25 -> 167
    //   145: aload_3
    //   146: astore 4
    //   148: aload_3
    //   149: astore 5
    //   151: aload_3
    //   152: astore_2
    //   153: getstatic 337	com/android/launcher2/Launcher:mRemovableCustomerAppItems	Ljava/util/ArrayList;
    //   156: aload 6
    //   158: invokeinterface 665 1 0
    //   163: invokevirtual 669	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   166: pop
    //   167: aload_3
    //   168: astore 4
    //   170: aload_3
    //   171: astore 5
    //   173: aload_3
    //   174: astore_2
    //   175: aload 6
    //   177: invokeinterface 672 1 0
    //   182: istore_1
    //   183: goto -48 -> 135
    //   186: aload 6
    //   188: astore 4
    //   190: aload 7
    //   192: astore 5
    //   194: aload 8
    //   196: astore_2
    //   197: aload_0
    //   198: invokevirtual 642	com/android/launcher2/Launcher:getResources	()Landroid/content/res/Resources;
    //   201: ldc_w 764
    //   204: invokevirtual 649	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   207: astore 9
    //   209: aload 6
    //   211: astore 4
    //   213: aload 7
    //   215: astore 5
    //   217: aload 8
    //   219: astore_2
    //   220: aload 9
    //   222: ldc_w 766
    //   225: invokestatic 657	com/android/launcher2/LauncherProvider:beginDocument	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V
    //   228: aload 9
    //   230: astore 6
    //   232: goto -113 -> 119
    //   235: aload_3
    //   236: ifnull +7 -> 243
    //   239: aload_3
    //   240: invokevirtual 716	java/io/FileReader:close	()V
    //   243: return
    //   244: astore_3
    //   245: aload 4
    //   247: astore_2
    //   248: aload_3
    //   249: invokevirtual 675	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   252: aload 4
    //   254: ifnull -11 -> 243
    //   257: aload 4
    //   259: invokevirtual 716	java/io/FileReader:close	()V
    //   262: return
    //   263: astore_2
    //   264: return
    //   265: astore_3
    //   266: aload 5
    //   268: astore_2
    //   269: aload_3
    //   270: invokevirtual 676	java/io/IOException:printStackTrace	()V
    //   273: aload 5
    //   275: ifnull -32 -> 243
    //   278: aload 5
    //   280: invokevirtual 716	java/io/FileReader:close	()V
    //   283: return
    //   284: astore_2
    //   285: return
    //   286: astore_3
    //   287: aload_2
    //   288: ifnull +7 -> 295
    //   291: aload_2
    //   292: invokevirtual 716	java/io/FileReader:close	()V
    //   295: aload_3
    //   296: athrow
    //   297: astore_2
    //   298: return
    //   299: astore_2
    //   300: goto -5 -> 295
    //   303: astore 4
    //   305: aload_3
    //   306: astore_2
    //   307: aload 4
    //   309: astore_3
    //   310: goto -23 -> 287
    //   313: astore_2
    //   314: aload_3
    //   315: astore 5
    //   317: aload_2
    //   318: astore_3
    //   319: goto -53 -> 266
    //   322: astore_2
    //   323: aload_3
    //   324: astore 4
    //   326: aload_2
    //   327: astore_3
    //   328: goto -83 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	Launcher
    //   134	49	1	i	int
    //   21	227	2	localObject1	Object
    //   263	1	2	localException1	Exception
    //   268	1	2	localObject2	Object
    //   284	8	2	localException2	Exception
    //   297	1	2	localException3	Exception
    //   299	1	2	localException4	Exception
    //   306	1	2	localObject3	Object
    //   313	5	2	localIOException1	java.io.IOException
    //   322	5	2	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   10	230	3	localFileReader	java.io.FileReader
    //   244	5	3	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   265	5	3	localIOException2	java.io.IOException
    //   286	20	3	localObject4	Object
    //   309	19	3	localObject5	Object
    //   13	245	4	localObject6	Object
    //   303	5	4	localObject7	Object
    //   324	1	4	localObject8	Object
    //   17	299	5	localObject9	Object
    //   1	230	6	localObject10	Object
    //   4	210	7	localObject11	Object
    //   7	211	8	localObject12	Object
    //   32	197	9	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   22	34	244	org/xmlpull/v1/XmlPullParserException
    //   45	53	244	org/xmlpull/v1/XmlPullParserException
    //   64	74	244	org/xmlpull/v1/XmlPullParserException
    //   85	96	244	org/xmlpull/v1/XmlPullParserException
    //   127	135	244	org/xmlpull/v1/XmlPullParserException
    //   153	167	244	org/xmlpull/v1/XmlPullParserException
    //   175	183	244	org/xmlpull/v1/XmlPullParserException
    //   197	209	244	org/xmlpull/v1/XmlPullParserException
    //   220	228	244	org/xmlpull/v1/XmlPullParserException
    //   257	262	263	java/lang/Exception
    //   22	34	265	java/io/IOException
    //   45	53	265	java/io/IOException
    //   64	74	265	java/io/IOException
    //   85	96	265	java/io/IOException
    //   127	135	265	java/io/IOException
    //   153	167	265	java/io/IOException
    //   175	183	265	java/io/IOException
    //   197	209	265	java/io/IOException
    //   220	228	265	java/io/IOException
    //   278	283	284	java/lang/Exception
    //   22	34	286	finally
    //   45	53	286	finally
    //   64	74	286	finally
    //   85	96	286	finally
    //   127	135	286	finally
    //   153	167	286	finally
    //   175	183	286	finally
    //   197	209	286	finally
    //   220	228	286	finally
    //   248	252	286	finally
    //   269	273	286	finally
    //   239	243	297	java/lang/Exception
    //   291	295	299	java/lang/Exception
    //   96	119	303	finally
    //   96	119	313	java/io/IOException
    //   96	119	322	org/xmlpull/v1/XmlPullParserException
  }
  
  /* Error */
  private void addRemovablePreloadAppToList()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore_3
    //   11: aload 6
    //   13: astore 4
    //   15: aload 7
    //   17: astore 5
    //   19: aload 8
    //   21: astore_2
    //   22: new 681	java/io/File
    //   25: dup
    //   26: ldc_w 769
    //   29: invokespecial 686	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore 9
    //   34: aload 6
    //   36: astore 4
    //   38: aload 7
    //   40: astore 5
    //   42: aload 8
    //   44: astore_2
    //   45: aload 9
    //   47: invokevirtual 689	java/io/File:isFile	()Z
    //   50: ifeq +136 -> 186
    //   53: aload 6
    //   55: astore 4
    //   57: aload 7
    //   59: astore 5
    //   61: aload 8
    //   63: astore_2
    //   64: aload 9
    //   66: invokevirtual 693	java/io/File:length	()J
    //   69: lconst_0
    //   70: lcmp
    //   71: ifle +115 -> 186
    //   74: aload 6
    //   76: astore 4
    //   78: aload 7
    //   80: astore 5
    //   82: aload 8
    //   84: astore_2
    //   85: new 695	java/io/FileReader
    //   88: dup
    //   89: ldc_w 769
    //   92: invokespecial 696	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   95: astore_3
    //   96: invokestatic 702	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   99: astore_2
    //   100: aload_2
    //   101: iconst_1
    //   102: invokevirtual 705	org/xmlpull/v1/XmlPullParserFactory:setNamespaceAware	(Z)V
    //   105: aload_2
    //   106: invokevirtual 709	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   109: astore 6
    //   111: aload 6
    //   113: aload_3
    //   114: invokeinterface 713 2 0
    //   119: aload_3
    //   120: astore 4
    //   122: aload_3
    //   123: astore 5
    //   125: aload_3
    //   126: astore_2
    //   127: aload 6
    //   129: invokeinterface 662 1 0
    //   134: istore_1
    //   135: iload_1
    //   136: iconst_1
    //   137: if_icmpeq +98 -> 235
    //   140: iload_1
    //   141: iconst_4
    //   142: if_icmpne +25 -> 167
    //   145: aload_3
    //   146: astore 4
    //   148: aload_3
    //   149: astore 5
    //   151: aload_3
    //   152: astore_2
    //   153: getstatic 335	com/android/launcher2/Launcher:mRemovablePreloadAppItems	Ljava/util/ArrayList;
    //   156: aload 6
    //   158: invokeinterface 665 1 0
    //   163: invokevirtual 669	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   166: pop
    //   167: aload_3
    //   168: astore 4
    //   170: aload_3
    //   171: astore 5
    //   173: aload_3
    //   174: astore_2
    //   175: aload 6
    //   177: invokeinterface 672 1 0
    //   182: istore_1
    //   183: goto -48 -> 135
    //   186: aload 6
    //   188: astore 4
    //   190: aload 7
    //   192: astore 5
    //   194: aload 8
    //   196: astore_2
    //   197: aload_0
    //   198: invokevirtual 642	com/android/launcher2/Launcher:getResources	()Landroid/content/res/Resources;
    //   201: ldc_w 770
    //   204: invokevirtual 649	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   207: astore 9
    //   209: aload 6
    //   211: astore 4
    //   213: aload 7
    //   215: astore 5
    //   217: aload 8
    //   219: astore_2
    //   220: aload 9
    //   222: ldc_w 772
    //   225: invokestatic 657	com/android/launcher2/LauncherProvider:beginDocument	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V
    //   228: aload 9
    //   230: astore 6
    //   232: goto -113 -> 119
    //   235: aload_3
    //   236: ifnull +7 -> 243
    //   239: aload_3
    //   240: invokevirtual 716	java/io/FileReader:close	()V
    //   243: return
    //   244: astore_3
    //   245: aload 4
    //   247: astore_2
    //   248: aload_3
    //   249: invokevirtual 675	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   252: aload 4
    //   254: ifnull -11 -> 243
    //   257: aload 4
    //   259: invokevirtual 716	java/io/FileReader:close	()V
    //   262: return
    //   263: astore_2
    //   264: return
    //   265: astore_3
    //   266: aload 5
    //   268: astore_2
    //   269: aload_3
    //   270: invokevirtual 676	java/io/IOException:printStackTrace	()V
    //   273: aload 5
    //   275: ifnull -32 -> 243
    //   278: aload 5
    //   280: invokevirtual 716	java/io/FileReader:close	()V
    //   283: return
    //   284: astore_2
    //   285: return
    //   286: astore_3
    //   287: aload_2
    //   288: ifnull +7 -> 295
    //   291: aload_2
    //   292: invokevirtual 716	java/io/FileReader:close	()V
    //   295: aload_3
    //   296: athrow
    //   297: astore_2
    //   298: return
    //   299: astore_2
    //   300: goto -5 -> 295
    //   303: astore 4
    //   305: aload_3
    //   306: astore_2
    //   307: aload 4
    //   309: astore_3
    //   310: goto -23 -> 287
    //   313: astore_2
    //   314: aload_3
    //   315: astore 5
    //   317: aload_2
    //   318: astore_3
    //   319: goto -53 -> 266
    //   322: astore_2
    //   323: aload_3
    //   324: astore 4
    //   326: aload_2
    //   327: astore_3
    //   328: goto -83 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	Launcher
    //   134	49	1	i	int
    //   21	227	2	localObject1	Object
    //   263	1	2	localException1	Exception
    //   268	1	2	localObject2	Object
    //   284	8	2	localException2	Exception
    //   297	1	2	localException3	Exception
    //   299	1	2	localException4	Exception
    //   306	1	2	localObject3	Object
    //   313	5	2	localIOException1	java.io.IOException
    //   322	5	2	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   10	230	3	localFileReader	java.io.FileReader
    //   244	5	3	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   265	5	3	localIOException2	java.io.IOException
    //   286	20	3	localObject4	Object
    //   309	19	3	localObject5	Object
    //   13	245	4	localObject6	Object
    //   303	5	4	localObject7	Object
    //   324	1	4	localObject8	Object
    //   17	299	5	localObject9	Object
    //   1	230	6	localObject10	Object
    //   4	210	7	localObject11	Object
    //   7	211	8	localObject12	Object
    //   32	197	9	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   22	34	244	org/xmlpull/v1/XmlPullParserException
    //   45	53	244	org/xmlpull/v1/XmlPullParserException
    //   64	74	244	org/xmlpull/v1/XmlPullParserException
    //   85	96	244	org/xmlpull/v1/XmlPullParserException
    //   127	135	244	org/xmlpull/v1/XmlPullParserException
    //   153	167	244	org/xmlpull/v1/XmlPullParserException
    //   175	183	244	org/xmlpull/v1/XmlPullParserException
    //   197	209	244	org/xmlpull/v1/XmlPullParserException
    //   220	228	244	org/xmlpull/v1/XmlPullParserException
    //   257	262	263	java/lang/Exception
    //   22	34	265	java/io/IOException
    //   45	53	265	java/io/IOException
    //   64	74	265	java/io/IOException
    //   85	96	265	java/io/IOException
    //   127	135	265	java/io/IOException
    //   153	167	265	java/io/IOException
    //   175	183	265	java/io/IOException
    //   197	209	265	java/io/IOException
    //   220	228	265	java/io/IOException
    //   278	283	284	java/lang/Exception
    //   22	34	286	finally
    //   45	53	286	finally
    //   64	74	286	finally
    //   85	96	286	finally
    //   127	135	286	finally
    //   153	167	286	finally
    //   175	183	286	finally
    //   197	209	286	finally
    //   220	228	286	finally
    //   248	252	286	finally
    //   269	273	286	finally
    //   239	243	297	java/lang/Exception
    //   291	295	299	java/lang/Exception
    //   96	119	303	finally
    //   96	119	313	java/io/IOException
    //   96	119	322	org/xmlpull/v1/XmlPullParserException
  }
  
  private void addToHelpMenuOption(MenuItem paramMenuItem)
  {
    for (;;)
    {
      try
      {
        if (Settings.System.getInt(getContentResolver(), "easy_mode_switch", 0) != 0) {
          continue;
        }
        bool = true;
        mEasyStateForHelpApp = bool;
      }
      catch (Exception localException)
      {
        boolean bool;
        if (!DEBUGGABLE) {
          continue;
        }
        Log.e("Launcher", "Stuck to help app because of indicated Easymode now   Error=" + localException);
        continue;
        paramMenuItem.setVisible(true);
      }
      if (isHelpAppAvailable())
      {
        if ((!mEasyStateForHelpApp) && (!LauncherApplication.getInst().isKnoxMode())) {
          continue;
        }
        paramMenuItem.setVisible(false);
      }
      return;
      bool = false;
    }
  }
  
  private void bindAndUnBindGestureService()
  {
    boolean bool = isAirMoveOninSettings();
    if (DEBUGGABLE) {
      Log.d("Launcher", "bindAndUnBindGestureService() isEnable : " + bool + " " + this.mGestureManager);
    }
    if (bool) {
      this.mGestureManager = new GestureManager(this, this);
    }
    while (this.mGestureManager == null) {
      return;
    }
    if (this.mGestureListenerRegistered) {
      this.mGestureManager.unregisterListener(this, "ir_provider");
    }
    this.mGestureManager.unbindFromService();
    this.mGestureManager = null;
  }
  
  private void buildWidgetMap(final HashMap<ComponentName, Integer> paramHashMap)
  {
    Workspace localWorkspace = this.mHomeView.getWorkspace();
    int j = localWorkspace.getChildCount();
    int i = 0;
    while (i < j)
    {
      ((CellLayout)localWorkspace.getChildAt(i)).getChildrenLayout().iterateBaseItems(new CellLayoutChildren.BaseItemIterator()
      {
        public boolean iterate(BaseItem paramAnonymousBaseItem, Integer paramAnonymousInteger)
        {
          if (BaseItem.isWidget(paramAnonymousBaseItem))
          {
            paramAnonymousBaseItem = paramAnonymousBaseItem.getComponentName();
            if ((paramAnonymousBaseItem != null) && (!paramHashMap.containsKey(paramAnonymousBaseItem))) {
              paramHashMap.put(paramAnonymousBaseItem, paramAnonymousInteger);
            }
          }
          return true;
        }
      }, Integer.valueOf(i));
      i += 1;
    }
  }
  
  private void cancelAppFolderRemoveDialog()
  {
    Object localObject = getFragmentManager();
    FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
    localObject = AppFolderRemoveDialog.getCurrentInstance((FragmentManager)localObject);
    if (localObject != null)
    {
      ((AppFolderRemoveDialog)localObject).dismiss();
      localFragmentTransaction.remove((Fragment)localObject);
      ((AppFolderRemoveDialog)localObject).cancelDelete();
      localFragmentTransaction.commit();
    }
  }
  
  private void clearTypedText()
  {
    this.mDefaultKeySsb.clear();
    this.mDefaultKeySsb.clearSpans();
    Selection.setSelection(this.mDefaultKeySsb, 0);
  }
  
  private void exitWidgetResizeMode()
  {
    Workspace localWorkspace = this.mHomeView.getWorkspace();
    if (localWorkspace != null) {
      localWorkspace.exitWidgetResizeMode();
    }
  }
  
  private void fillInHomeItem(HomeItem paramHomeItem, WidgetAddInfo paramWidgetAddInfo, int[] paramArrayOfInt)
  {
    if (paramWidgetAddInfo.mSizeX > 0)
    {
      i = paramArrayOfInt[0];
      paramHomeItem.spanX = i;
      if (paramWidgetAddInfo.mSizeY <= 0) {
        break label60;
      }
    }
    label60:
    for (int i = paramArrayOfInt[1];; i = -1)
    {
      paramHomeItem.spanY = i;
      paramHomeItem.container = -100L;
      paramHomeItem.mScreen = -1;
      paramHomeItem.dropPos = null;
      return;
      i = -1;
      break;
    }
  }
  
  private void finishExitAllApps()
  {
    this.mExitingAllApps = false;
    this.mMenuView.onFinishExitAllApps();
    FragmentManager localFragmentManager = getFragmentManager();
    FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
    this.mHomeView.setVisibility(0);
    this.mMenuView.setVisibility(4);
    if (this.mPaused) {
      localFragmentTransaction.commitAllowingStateLoss();
    }
    for (;;)
    {
      localFragmentManager.executePendingTransactions();
      this.mInMenu = false;
      getWindow().getDecorView().sendAccessibilityEvent(32);
      if ((isHelpAppRunning) && ("create_folder".equals(GuideFragment.GMode)) && (GuideFragment.isViewAppsDialogDismissed)) {
        ((CreateFolderGuider)new CreateFolderGuider(this)).showHelpDialog_step3();
      }
      return;
      try
      {
        localFragmentTransaction.commit();
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Log.e("Launcher", "IllegalStateException should not happen in normal use but may be in stress testing");
        localFragmentTransaction.commitAllowingStateLoss();
      }
    }
  }
  
  private void finishShowAllApps()
  {
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    this.mMenuView.setVisibility(0);
    this.mHomeView.performAccessibilityAction(128, null);
    getWindow().getDecorView().sendAccessibilityEvent(32);
    this.mHomeView.setVisibility(4);
    if (this.mHomeView.getWorkspace() != null) {
      this.mHomeView.getWorkspace().pauseScreen(this.mHomeView.getCurrentPage());
    }
    if (this.mIsDestroyed) {
      return;
    }
    if (this.mPaused)
    {
      localFragmentTransaction.commitAllowingStateLoss();
      return;
    }
    try
    {
      localFragmentTransaction.commit();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.e("Launcher", "IllegalStateException should not happen in normal use but may be in stress testing", new RuntimeException("commit").fillInStackTrace());
    }
  }
  
  public static Launcher getInstance()
  {
    if (launcher == null)
    {
      Log.e("Launcher", "Please Call me after onCreate");
      new NullPointerException().printStackTrace();
    }
    return launcher;
  }
  
  /* Error */
  private Intent getLaunchIntentForHelpHub()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: getfield 448	com/android/launcher2/Launcher:mIsExternalHelpActivity	Z
    //   8: ifeq +185 -> 193
    //   11: new 1048	android/content/Intent
    //   14: dup
    //   15: ldc_w 1050
    //   18: invokespecial 1051	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   21: astore_2
    //   22: aload_0
    //   23: invokevirtual 642	com/android/launcher2/Launcher:getResources	()Landroid/content/res/Resources;
    //   26: invokevirtual 1055	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   29: getfield 1060	android/content/res/Configuration:smallestScreenWidthDp	I
    //   32: sipush 600
    //   35: if_icmplt +29 -> 64
    //   38: aload_2
    //   39: ldc_w 1062
    //   42: ldc_w 1064
    //   45: invokevirtual 1068	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   48: pop
    //   49: aload_2
    //   50: ldc_w 1069
    //   53: invokevirtual 1073	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   56: pop
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 448	com/android/launcher2/Launcher:mIsExternalHelpActivity	Z
    //   62: aload_2
    //   63: areturn
    //   64: aconst_null
    //   65: astore_1
    //   66: getstatic 998	com/android/launcher2/guide/GuideFragment:GMode	Ljava/lang/String;
    //   69: ldc_w 1075
    //   72: invokevirtual 1078	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   75: ifne +207 -> 282
    //   78: getstatic 998	com/android/launcher2/guide/GuideFragment:GMode	Ljava/lang/String;
    //   81: ldc_w 1080
    //   84: invokevirtual 1078	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   87: ifeq +56 -> 143
    //   90: goto +192 -> 282
    //   93: aload_1
    //   94: ifnonnull +87 -> 181
    //   97: aload_2
    //   98: ldc_w 1062
    //   101: ldc_w 1064
    //   104: invokevirtual 1068	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   107: pop
    //   108: aload_2
    //   109: ldc_w 1082
    //   112: iconst_1
    //   113: invokevirtual 1085	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   116: pop
    //   117: goto -68 -> 49
    //   120: astore_3
    //   121: aload_2
    //   122: astore_1
    //   123: aload_1
    //   124: astore_2
    //   125: getstatic 316	com/android/launcher2/Launcher:DEBUGGABLE	Z
    //   128: ifeq +152 -> 280
    //   131: ldc -102
    //   133: ldc_w 1087
    //   136: aload_3
    //   137: invokestatic 1035	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   140: pop
    //   141: aload_1
    //   142: areturn
    //   143: getstatic 998	com/android/launcher2/guide/GuideFragment:GMode	Ljava/lang/String;
    //   146: ldc_w 993
    //   149: invokevirtual 1078	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   152: ifeq +10 -> 162
    //   155: ldc_w 1089
    //   158: astore_1
    //   159: goto -66 -> 93
    //   162: getstatic 998	com/android/launcher2/guide/GuideFragment:GMode	Ljava/lang/String;
    //   165: ldc_w 1091
    //   168: invokevirtual 1078	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   171: ifeq -78 -> 93
    //   174: ldc_w 1093
    //   177: astore_1
    //   178: goto -85 -> 93
    //   181: aload_2
    //   182: ldc_w 1095
    //   185: aload_1
    //   186: invokevirtual 1068	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   189: pop
    //   190: goto -82 -> 108
    //   193: aload_0
    //   194: invokevirtual 642	com/android/launcher2/Launcher:getResources	()Landroid/content/res/Resources;
    //   197: invokevirtual 1055	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   200: getfield 1060	android/content/res/Configuration:smallestScreenWidthDp	I
    //   203: sipush 600
    //   206: if_icmplt +14 -> 220
    //   209: aload_0
    //   210: invokevirtual 1099	com/android/launcher2/Launcher:getPackageManager	()Landroid/content/pm/PackageManager;
    //   213: ldc_w 1101
    //   216: invokevirtual 1107	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   219: areturn
    //   220: new 1048	android/content/Intent
    //   223: dup
    //   224: invokespecial 1108	android/content/Intent:<init>	()V
    //   227: astore_1
    //   228: aload_1
    //   229: ldc_w 1101
    //   232: ldc_w 1110
    //   235: invokevirtual 1113	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   238: pop
    //   239: aload_1
    //   240: ldc_w 1069
    //   243: invokevirtual 1073	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   246: pop
    //   247: aload_1
    //   248: areturn
    //   249: astore_3
    //   250: aload_2
    //   251: astore_1
    //   252: aload_1
    //   253: astore_2
    //   254: getstatic 316	com/android/launcher2/Launcher:DEBUGGABLE	Z
    //   257: ifeq +23 -> 280
    //   260: ldc -102
    //   262: ldc_w 1115
    //   265: aload_3
    //   266: invokestatic 1035	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   269: pop
    //   270: aload_1
    //   271: areturn
    //   272: astore_3
    //   273: goto -21 -> 252
    //   276: astore_3
    //   277: goto -154 -> 123
    //   280: aload_2
    //   281: areturn
    //   282: ldc_w 1117
    //   285: astore_1
    //   286: goto -193 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	Launcher
    //   3	283	1	localObject1	Object
    //   1	280	2	localObject2	Object
    //   120	17	3	localActivityNotFoundException1	ActivityNotFoundException
    //   249	17	3	localActivityNotFoundException2	ActivityNotFoundException
    //   272	1	3	localActivityNotFoundException3	ActivityNotFoundException
    //   276	1	3	localActivityNotFoundException4	ActivityNotFoundException
    // Exception table:
    //   from	to	target	type
    //   22	49	120	android/content/ActivityNotFoundException
    //   49	62	120	android/content/ActivityNotFoundException
    //   66	90	120	android/content/ActivityNotFoundException
    //   97	108	120	android/content/ActivityNotFoundException
    //   108	117	120	android/content/ActivityNotFoundException
    //   143	155	120	android/content/ActivityNotFoundException
    //   162	174	120	android/content/ActivityNotFoundException
    //   181	190	120	android/content/ActivityNotFoundException
    //   193	220	249	android/content/ActivityNotFoundException
    //   220	228	249	android/content/ActivityNotFoundException
    //   228	247	272	android/content/ActivityNotFoundException
    //   11	22	276	android/content/ActivityNotFoundException
  }
  
  public static int getStatusBarHeight(Resources paramResources)
  {
    int i = 0;
    int j = paramResources.getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramResources.getDimensionPixelSize(j);
    }
    return i;
  }
  
  private String getTypedText()
  {
    return this.mDefaultKeySsb.toString();
  }
  
  public static boolean hasPackage(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getApplicationInfo(paramString, 128);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.d("Launcher", "Package not found : " + paramString);
    }
    return false;
  }
  
  private boolean isFactoryMode()
  {
    if (this.mFactoryModeString == null)
    {
      this.mFactoryModeString = readOneLine("/efs/FactoryApp/factorymode");
      if (this.mFactoryModeString.contains("ON")) {
        break label107;
      }
    }
    label107:
    for (boolean bool = true;; bool = false)
    {
      this.mIsFactoryMode = bool;
      if (DEBUGGABLE)
      {
        Log.d("Launcher", "isFactoryMode string: " + this.mFactoryModeString);
        Log.d("Launcher", "isFactoryMode returns: " + this.mIsFactoryMode);
      }
      return this.mIsFactoryMode;
    }
  }
  
  private boolean isFactorySim()
  {
    String str = ((TelephonyManager)getApplicationContext().getSystemService("phone")).getSubscriberId();
    if (DEBUGGABLE) {
      Log.d("Launcher", "isFactorySim() imsi = " + str);
    }
    if ((str != null) && (str.equals("999999999999999")))
    {
      if (DEBUGGABLE) {
        Log.d("Launcher", "isFactorySim() : true");
      }
      return true;
    }
    if (DEBUGGABLE) {
      Log.d("Launcher", "isFactorySim() : false");
    }
    return false;
  }
  
  static boolean isHomeEditMode()
  {
    return sIsHomeEditMode;
  }
  
  static boolean isHomeRemoveMode()
  {
    return sIsHomeRemoveMode;
  }
  
  public static boolean isInValidDragState(DragEvent paramDragEvent)
  {
    if (paramDragEvent == null) {}
    do
    {
      do
      {
        return true;
        if (!LauncherApplication.sDNDBinding) {
          break;
        }
      } while ((!(paramDragEvent.getLocalState() instanceof DragState)) && (dragstate == null));
      return false;
    } while (!(paramDragEvent.getLocalState() instanceof DragState));
    return false;
  }
  
  private boolean isKnoxLauncher()
  {
    return UserHandle.getUserId(Process.myUid()) >= 100;
  }
  
  public static boolean isOptionMenuShowing()
  {
    return (sPopupMenuShowing) || (sHwPopupMenuShowing);
  }
  
  public static boolean isPopupMenuShowing()
  {
    return sPopupMenuShowing;
  }
  
  private static boolean isPropertyEnabled(String paramString)
  {
    return Log.isLoggable(paramString, 2);
  }
  
  private static boolean isWifiOnly(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      paramContext = paramContext.getNetworkInfo(0);
      bool1 = bool2;
      if (0 != 0)
      {
        if (paramContext.isAvailable()) {
          break label42;
        }
        bool1 = true;
      }
    }
    return bool1;
    label42:
    return false;
  }
  
  private boolean processAsAndroidAppWidget(WidgetAddInfo paramWidgetAddInfo)
  {
    Object localObject = AppWidgetManager.getInstance(this).getInstalledProviders().iterator();
    while (((Iterator)localObject).hasNext())
    {
      AppWidgetProviderInfo localAppWidgetProviderInfo = (AppWidgetProviderInfo)((Iterator)localObject).next();
      if (localAppWidgetProviderInfo.provider.equals(paramWidgetAddInfo.mComponentName))
      {
        localObject = new HomePendingWidget(localAppWidgetProviderInfo, null, null);
        fillInHomeItem((HomeItem)localObject, paramWidgetAddInfo, this.mSpanCalculator.getSpanForAppWidget(localAppWidgetProviderInfo, paramWidgetAddInfo.mSizeX, paramWidgetAddInfo.mSizeY, null));
        this.mHomeView.addAppWidgetFromDrop((HomePendingWidget)localObject);
        return true;
      }
    }
    return false;
  }
  
  private boolean processAsSamsungSurfaceWidget(WidgetAddInfo paramWidgetAddInfo)
  {
    Object localObject = this.mSurfaceWidgetPackageManager.findWidget(paramWidgetAddInfo.mComponentName, null);
    if (localObject == null) {
      return false;
    }
    localObject = new HomePendingSurfaceWidget((SurfaceWidgetProviderInfo)localObject);
    fillInHomeItem((HomeItem)localObject, paramWidgetAddInfo, this.mSpanCalculator.getSpanForSurfaceWidget(paramWidgetAddInfo.mSizeX, paramWidgetAddInfo.mSizeY, null));
    this.mHomeView.addSurfaceWidgetFromDrop((HomePendingSurfaceWidget)localObject);
    return true;
  }
  
  private boolean processAsSamsungWidget(WidgetAddInfo paramWidgetAddInfo)
  {
    Object localObject = this.mSamsungWidgetPackageManager.findWidget(paramWidgetAddInfo.mComponentName, null);
    if (localObject == null) {
      return false;
    }
    localObject = new HomePendingSamsungWidget((SamsungWidgetProviderInfo)localObject);
    fillInHomeItem((HomeItem)localObject, paramWidgetAddInfo, this.mSpanCalculator.getSpanForSamsungWidget(paramWidgetAddInfo.mSizeX, paramWidgetAddInfo.mSizeY, paramWidgetAddInfo.mSizeX, paramWidgetAddInfo.mSizeY, null));
    this.mHomeView.addSamsungWidgetFromDrop((HomePendingSamsungWidget)localObject);
    return true;
  }
  
  /* Error */
  private String readOneLine(String paramString)
  {
    // Byte code:
    //   0: ldc_w 341
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
    //   24: new 695	java/io/FileReader
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 696	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: new 733	java/io/BufferedReader
    //   36: dup
    //   37: aload_1
    //   38: sipush 8096
    //   41: invokespecial 1333	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   44: astore_2
    //   45: aload_2
    //   46: invokevirtual 738	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore_3
    //   50: aload_1
    //   51: ifnull +7 -> 58
    //   54: aload_1
    //   55: invokevirtual 716	java/io/FileReader:close	()V
    //   58: aload_2
    //   59: ifnull +7 -> 66
    //   62: aload_2
    //   63: invokevirtual 760	java/io/BufferedReader:close	()V
    //   66: aload_3
    //   67: ifnonnull +216 -> 283
    //   70: ldc_w 341
    //   73: areturn
    //   74: astore_1
    //   75: ldc -102
    //   77: ldc_w 1335
    //   80: invokestatic 1338	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   83: pop
    //   84: aload_1
    //   85: invokevirtual 676	java/io/IOException:printStackTrace	()V
    //   88: goto -22 -> 66
    //   91: astore 5
    //   93: aload 8
    //   95: astore_1
    //   96: aload 4
    //   98: astore_2
    //   99: aload_1
    //   100: astore_3
    //   101: ldc -102
    //   103: ldc_w 1340
    //   106: invokestatic 1338	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   109: pop
    //   110: aload 4
    //   112: astore_2
    //   113: aload_1
    //   114: astore_3
    //   115: aload 5
    //   117: invokevirtual 755	java/io/FileNotFoundException:printStackTrace	()V
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 716	java/io/FileReader:close	()V
    //   128: aload 6
    //   130: astore_3
    //   131: aload 4
    //   133: ifnull -67 -> 66
    //   136: aload 4
    //   138: invokevirtual 760	java/io/BufferedReader:close	()V
    //   141: aload 6
    //   143: astore_3
    //   144: goto -78 -> 66
    //   147: astore_1
    //   148: ldc -102
    //   150: ldc_w 1335
    //   153: invokestatic 1338	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   156: pop
    //   157: aload_1
    //   158: invokevirtual 676	java/io/IOException:printStackTrace	()V
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
    //   181: ldc -102
    //   183: ldc_w 1342
    //   186: invokestatic 1338	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   189: pop
    //   190: aload 4
    //   192: astore_2
    //   193: aload_1
    //   194: astore_3
    //   195: aload 5
    //   197: invokevirtual 676	java/io/IOException:printStackTrace	()V
    //   200: aload_1
    //   201: ifnull +7 -> 208
    //   204: aload_1
    //   205: invokevirtual 716	java/io/FileReader:close	()V
    //   208: aload 6
    //   210: astore_3
    //   211: aload 4
    //   213: ifnull -147 -> 66
    //   216: aload 4
    //   218: invokevirtual 760	java/io/BufferedReader:close	()V
    //   221: aload 6
    //   223: astore_3
    //   224: goto -158 -> 66
    //   227: astore_1
    //   228: ldc -102
    //   230: ldc_w 1335
    //   233: invokestatic 1338	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   236: pop
    //   237: aload_1
    //   238: invokevirtual 676	java/io/IOException:printStackTrace	()V
    //   241: aload 6
    //   243: astore_3
    //   244: goto -178 -> 66
    //   247: astore_1
    //   248: aload_3
    //   249: ifnull +7 -> 256
    //   252: aload_3
    //   253: invokevirtual 716	java/io/FileReader:close	()V
    //   256: aload_2
    //   257: ifnull +7 -> 264
    //   260: aload_2
    //   261: invokevirtual 760	java/io/BufferedReader:close	()V
    //   264: aload_1
    //   265: athrow
    //   266: astore_2
    //   267: ldc -102
    //   269: ldc_w 1335
    //   272: invokestatic 1338	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   275: pop
    //   276: aload_2
    //   277: invokevirtual 676	java/io/IOException:printStackTrace	()V
    //   280: goto -16 -> 264
    //   283: aload_3
    //   284: invokevirtual 1345	java/lang/String:trim	()Ljava/lang/String;
    //   287: areturn
    //   288: astore 4
    //   290: aload 5
    //   292: astore_2
    //   293: aload_1
    //   294: astore_3
    //   295: aload 4
    //   297: astore_1
    //   298: goto -50 -> 248
    //   301: astore 4
    //   303: aload_1
    //   304: astore_3
    //   305: aload 4
    //   307: astore_1
    //   308: goto -60 -> 248
    //   311: astore 5
    //   313: aload 7
    //   315: astore 4
    //   317: goto -141 -> 176
    //   320: astore 5
    //   322: aload_2
    //   323: astore 4
    //   325: goto -149 -> 176
    //   328: astore 5
    //   330: goto -234 -> 96
    //   333: astore 5
    //   335: aload_2
    //   336: astore 4
    //   338: goto -242 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	Launcher
    //   0	341	1	paramString	String
    //   9	252	2	localObject1	Object
    //   266	11	2	localIOException1	java.io.IOException
    //   292	44	2	localObject2	Object
    //   20	285	3	str1	String
    //   14	203	4	localObject3	Object
    //   288	8	4	localObject4	Object
    //   301	5	4	localObject5	Object
    //   315	22	4	localObject6	Object
    //   11	1	5	localObject7	Object
    //   91	25	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   167	124	5	localIOException2	java.io.IOException
    //   311	1	5	localIOException3	java.io.IOException
    //   320	1	5	localIOException4	java.io.IOException
    //   328	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   333	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   3	239	6	str2	String
    //   6	308	7	localObject8	Object
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
    //   33	45	288	finally
    //   45	50	301	finally
    //   33	45	311	java/io/IOException
    //   45	50	320	java/io/IOException
    //   33	45	328	java/io/FileNotFoundException
    //   45	50	333	java/io/FileNotFoundException
  }
  
  public static String readSalesCode()
  {
    Object localObject = "";
    try
    {
      String str1 = SystemProperties.get("ro.csc.sales_code");
      String str2 = str1;
      localObject = str1;
      if (TextUtils.isEmpty(str1))
      {
        localObject = str1;
        str2 = SystemProperties.get("ril.sales_code");
      }
      return str2;
    }
    catch (Exception localException) {}
    return (String)localObject;
  }
  
  private void releaseShadows()
  {
    Log.d("Launcher", "releaseShadows called");
    this.mHomeView.getWorkspace().releaseShadows();
    this.mMenuView.releaseShadows();
    MenuAppModel.INSTANCE.releaseShadows();
  }
  
  public static void requestDownloadingResource(String paramString, Context paramContext)
  {
    paramString = new AlertDialog.Builder(paramContext, 5).setTitle(2131755097).setMessage(2131755241).setNegativeButton(17039360, null).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent();
        paramAnonymousDialogInterface.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
        paramAnonymousDialogInterface.putExtra("directcall", true);
        paramAnonymousDialogInterface.putExtra("callerType", 1);
        paramAnonymousDialogInterface.putExtra("GUID", "com.samsung.helpplugin");
        paramAnonymousDialogInterface.addFlags(335544352);
        this.val$c.startActivity(paramAnonymousDialogInterface);
      }
    }).setCancelable(true);
    if (isWifiOnly(paramContext)) {
      paramString.setMessage(2131755242);
    }
    paramString.show();
  }
  
  static void setHomeEditMode(boolean paramBoolean)
  {
    sIsHomeEditMode = paramBoolean;
  }
  
  static void setHomeRemoveMode(boolean paramBoolean)
  {
    sIsHomeRemoveMode = paramBoolean;
  }
  
  private void setIndicatorTransparency()
  {
    getWindow().addFlags(-2080374784);
  }
  
  private void setMarketLabel()
  {
    try
    {
      if (this.mActivityName != null) {
        this.mMarketLabelName = getPackageManager().getActivityInfo(this.mActivityName, 0).loadLabel(getPackageManager());
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      return;
    }
    finally
    {
      if (this.mMarketLabelName == null) {
        this.mMarketLabelName = getString(2131755056);
      }
    }
  }
  
  private boolean setupOptionsMenu(Menu paramMenu)
  {
    Object localObject1 = this.mHomeView.getWorkspace();
    if ((getAnimationLayer().areTouchEventsBlocked()) || (paramMenu == null)) {
      return false;
    }
    String str = getResources().getString(2131755060);
    MenuItem localMenuItem1 = paramMenu.findItem(2131689703);
    localMenuItem1.setTitle(this.mMarketLabelName);
    MenuItem localMenuItem4 = paramMenu.findItem(2131689704);
    Object localObject2 = paramMenu.findItem(2131689712);
    MenuItem localMenuItem2 = paramMenu.findItem(2131689715);
    MenuItem localMenuItem5 = paramMenu.findItem(2131689714);
    MenuItem localMenuItem6 = paramMenu.findItem(2131689713);
    MenuItem localMenuItem3 = paramMenu.findItem(2131689716);
    MenuItem localMenuItem7 = paramMenu.findItem(2131689717);
    MenuItem localMenuItem8 = paramMenu.findItem(2131689719);
    MenuItem localMenuItem13 = paramMenu.findItem(2131689720);
    MenuItem localMenuItem14 = paramMenu.findItem(2131689721);
    MenuItem localMenuItem9 = paramMenu.findItem(2131689706);
    MenuItem localMenuItem10 = paramMenu.findItem(2131689707);
    MenuItem localMenuItem15 = paramMenu.findItem(2131689705);
    MenuItem localMenuItem16 = paramMenu.findItem(2131689708);
    MenuItem localMenuItem17 = paramMenu.findItem(2131689711);
    MenuItem localMenuItem18 = paramMenu.findItem(2131689723);
    MenuItem localMenuItem19 = paramMenu.findItem(2131689710);
    MenuItem localMenuItem20 = paramMenu.findItem(2131689725);
    MenuItem localMenuItem11 = paramMenu.findItem(2131689726);
    MenuItem localMenuItem21 = paramMenu.findItem(2131689724);
    MenuItem localMenuItem12 = paramMenu.findItem(2131689718);
    MenuItem localMenuItem22 = paramMenu.findItem(2131689709);
    MenuItem localMenuItem23 = paramMenu.findItem(2131689727);
    paramMenu = paramMenu.findItem(2131689722);
    boolean bool3 = MenuAppModel.INSTANCE.canUninstallApps();
    localMenuItem1.setVisible(false);
    localMenuItem4.setVisible(false);
    ((MenuItem)localObject2).setVisible(false);
    localMenuItem2.setVisible(false);
    localMenuItem5.setVisible(false);
    localMenuItem6.setVisible(false);
    localMenuItem3.setVisible(false);
    localMenuItem7.setVisible(false);
    localMenuItem8.setVisible(false);
    localMenuItem12.setVisible(false);
    localMenuItem13.setVisible(false);
    localMenuItem14.setVisible(false);
    localMenuItem9.setVisible(false);
    localMenuItem10.setVisible(false);
    localMenuItem15.setVisible(false);
    localMenuItem16.setVisible(false);
    localMenuItem17.setVisible(false);
    localMenuItem18.setVisible(false);
    localMenuItem19.setVisible(false);
    localMenuItem20.setVisible(false);
    localMenuItem11.setVisible(false);
    localMenuItem21.setVisible(false);
    localMenuItem22.setVisible(false);
    localMenuItem23.setVisible(false);
    paramMenu.setVisible(false);
    if (this.mHomeView.isVisible()) {
      if (0 != 0)
      {
        localMenuItem19.setVisible(true);
        if (CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE)
        {
          if (((Workspace)localObject1).isInResizeMode()) {
            break label812;
          }
          localMenuItem19.setVisible(true);
          localMenuItem19.setTitle(2131755094);
        }
        label612:
        if (CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) {
          paramMenu.setVisible(true);
        }
        addToHelpMenuOption(localMenuItem11);
        if (!isKnoxLauncher()) {
          localMenuItem20.setVisible(true);
        }
        localMenuItem9.setVisible(true);
        if ("KNIGHT".equals("HERA")) {
          localMenuItem15.setVisible(true);
        }
        localMenuItem16.setVisible(true);
        if (CSCFEATURE_LAUNCHER_USM_EXISTS) {
          localMenuItem21.setVisible(true);
        }
        if (CSCFEATURE_LAUNCHER_THEME_ENABLE) {
          localMenuItem22.setVisible(true);
        }
      }
    }
    for (;;)
    {
      if (CscFeature.getInstance().getEnableStatus("CscFeature_Launcher_DisableGoogleOption"))
      {
        localMenuItem1.setVisible(false);
        localMenuItem3.setVisible(false);
      }
      if ((this.mApplicationPolicy != null) && ((!this.mApplicationPolicy.getApplicationStateEnabled("com.android.vending")) || (!this.mApplicationPolicy.getApplicationStateEnabled("com.google.android.finsky")))) {
        localMenuItem1.setVisible(false);
      }
      return true;
      if (LauncherApplication.getInst().isKnoxMode()) {
        break;
      }
      localMenuItem18.setVisible(true);
      break;
      label812:
      localMenuItem19.setVisible(false);
      break label612;
      if (this.mMenuView.isVisible())
      {
        boolean bool1;
        if (this.mMenuView.isCurrentTabWidgets())
        {
          if (!isSystemAppDisable) {
            localMenuItem1.setVisible(true);
          }
          ((MenuItem)localObject2).setVisible(true);
          paramMenu = this.mMenuView.getMenuWidgets();
          if ((paramMenu != null) && (paramMenu.hasUninstallableWidgets())) {}
          for (bool1 = true;; bool1 = false)
          {
            localMenuItem2.setVisible(bool1);
            break;
          }
        }
        switch (this.mMenuView.getViewType())
        {
        default: 
          break;
        case ???: 
        case ???: 
          if (!isSystemAppDisable)
          {
            localMenuItem1.setVisible(true);
            localMenuItem3.setVisible(bool3);
          }
          localMenuItem2.setVisible(bool3);
          switch (14.$SwitchMap$com$android$launcher2$MenuAppsGrid$State[this.mMenuView.getState().ordinal()])
          {
          default: 
            break;
          case 1: 
            if ((LauncherApplication.isOwner()) && (!LauncherApplication.getInst().isKnoxMode())) {
              localMenuItem23.setVisible(true);
            }
            localMenuItem4.setVisible(true);
            paramMenu = MenuAppModel.INSTANCE.getTopLevelItems();
            int j = 0;
            int i = 0;
            boolean bool2 = false;
            bool1 = false;
            if (paramMenu != null)
            {
              localObject1 = paramMenu.iterator();
              bool2 = bool1;
              j = i;
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (AppItem)((Iterator)localObject1).next();
                if ((i == 0) || (!bool1)) {
                  break label1368;
                }
                j = i;
                bool2 = bool1;
              }
            }
            if ((paramMenu != null) && (!paramMenu.isEmpty()))
            {
              bool1 = true;
              localMenuItem4.setVisible(bool1);
              if ((!bool1) || (j == 0)) {
                break label1408;
              }
              bool1 = true;
              localMenuItem9.setVisible(bool1);
              localMenuItem6.setVisible(bool1);
              addToHelpMenuOption(localMenuItem11);
              if ((!bool3) || (!bool1)) {
                break label1414;
              }
              bool3 = true;
              localMenuItem5.setVisible(bool3);
              if ((LauncherApplication.getInst().isKnoxMode()) && (MenuAppModel.INSTANCE.getUninstallableApps().size() == 0)) {
                localMenuItem5.setVisible(false);
              }
              localMenuItem6.setVisible(true);
              localMenuItem7.setVisible(true);
              localMenuItem9.setVisible(true);
              if (MenuAppModel.INSTANCE.getTopLevelItems() == null) {
                break label1420;
              }
              localMenuItem7.setVisible(bool1);
              localMenuItem8.setVisible(MenuAppModel.INSTANCE.hasHiddenApps());
              if (isSystemAppDisable)
              {
                localMenuItem2.setTitle(str);
                localMenuItem2.setVisible(bool1);
                if (MenuAppModel.INSTANCE.isDisableAppListEmpty()) {
                  break label1432;
                }
              }
            }
            for (bool1 = true;; bool1 = false)
            {
              localMenuItem12.setVisible(bool1);
              localMenuItem10.setVisible(bool2);
              break;
              if (!AppItem.isFolder((BaseItem)localObject2))
              {
                i = 1;
                break label1085;
              }
              if (((FolderItem)localObject2).getItemCount() > 0) {
                i = 1;
              }
              bool1 = true;
              break label1085;
              bool1 = false;
              break label1144;
              bool1 = false;
              break label1166;
              bool3 = false;
              break label1205;
              localMenuItem7.setVisible(false);
              break label1293;
            }
          }
          break;
        case ???: 
          label1085:
          label1144:
          label1166:
          label1205:
          label1293:
          label1368:
          label1408:
          label1414:
          label1420:
          label1432:
          localMenuItem6.setVisible(true);
          localMenuItem3.setVisible(false);
        }
      }
    }
  }
  
  public static boolean startDrag(View paramView)
  {
    return startDrag(paramView, new ShadowBuilder(paramView));
  }
  
  public static boolean startDrag(View paramView, float paramFloat)
  {
    return startDrag(paramView, new ShadowBuilder(paramView, paramFloat, paramFloat));
  }
  
  public static boolean startDrag(View paramView, float paramFloat1, float paramFloat2)
  {
    return startDrag(paramView, new ShadowBuilder(paramView, paramFloat1, paramFloat2));
  }
  
  public static boolean startDrag(View paramView, ShadowBuilder paramShadowBuilder)
  {
    DragState localDragState = new DragState(paramView);
    Point localPoint1 = new Point();
    Point localPoint2 = new Point();
    paramShadowBuilder.onProvideShadowMetrics(localPoint1, localPoint2);
    if ((localPoint2.x < 0) || (localPoint2.y < 0))
    {
      Log.d("Launcher", "Drag shadow touch point must not be negative");
      return false;
    }
    if ((localPoint1.x < 0) || (localPoint1.y < 0))
    {
      Log.d("Launcher", "Drag shadow dimensions must not be negative");
      return false;
    }
    boolean bool = paramView.startDrag(null, paramShadowBuilder, localDragState, 0);
    if (bool)
    {
      localDragState.setShadow(paramShadowBuilder);
      localDragState.onDragStartedSuccessfully();
    }
    for (;;)
    {
      Log.i("Launcher", "Start Drag result " + bool);
      return bool;
      if ((localDragState.getView() instanceof SurfaceWidgetView)) {
        localDragState.getView().setVisibility(0);
      }
    }
  }
  
  private boolean tryQueueWidgetAddViaIntent(Intent paramIntent, String paramString)
  {
    int j = -1;
    if ((paramIntent != null) && ("com.sec.launcher.action.INSTALL_WIDGET".equals(paramIntent.getAction())))
    {
      if (paramString != null) {
        paramIntent.setAction(paramString);
      }
      paramString = (ComponentName)paramIntent.getParcelableExtra("com.sec.launcher.intent.extra.COMPONENT");
      WidgetAddInfo localWidgetAddInfo;
      int i;
      if (paramString != null)
      {
        localWidgetAddInfo = new WidgetAddInfo(null);
        localWidgetAddInfo.mComponentName = paramString;
        localWidgetAddInfo.mAllowDuplicate = paramIntent.getBooleanExtra("com.sec.launcher.intent.extra.DUPLICATE", true);
        int k = paramIntent.getIntExtra("com.sec.launcher.intent.extra.sizeX", -1);
        i = k;
        if (k < 1) {
          i = -1;
        }
        localWidgetAddInfo.mSizeX = i;
        i = paramIntent.getIntExtra("com.sec.launcher.intent.extra.sizeY", -1);
        if (i >= 1) {
          break label136;
        }
        i = j;
      }
      label136:
      for (;;)
      {
        localWidgetAddInfo.mSizeY = i;
        this.mWidgetAddInfo.add(localWidgetAddInfo);
        return true;
      }
    }
    return false;
  }
  
  public void RestoreHomeScreen()
  {
    isHomescreenRestoring = true;
    final LauncherApplication localLauncherApplication = (LauncherApplication)getApplicationContext();
    int k = this.mHomeView.getPageCount();
    int j = LauncherApplication.getScreenCount();
    int i = j;
    if (j == -1) {
      i = LauncherApplication.getMaxScreenCount();
    }
    k = i - k;
    if (k > 0)
    {
      j = 0;
      while (j < k)
      {
        this.mHomeView.addPage();
        j += 1;
      }
    }
    if (k < 0)
    {
      j = 0;
      while (j < k * -1)
      {
        this.mHomeView.deletePage(0);
        j += 1;
      }
    }
    j = LauncherApplication.getHomeScreenIndex();
    if ((j != -1) && (j < i)) {
      this.mHomeView.setHomeScreenAt(j);
    }
    localLauncherApplication.getModel().setRefreshRequired(true);
    new Handler().post(new Runnable()
    {
      public void run()
      {
        localLauncherApplication.getModel().startLoaderFromBackground(true);
      }
    });
  }
  
  public void addAnyPendingWidgetsToWorkspace()
  {
    HashMap localHashMap = new HashMap();
    buildWidgetMap(localHashMap);
    Workspace localWorkspace = this.mHomeView.getWorkspace();
    int i = localWorkspace.getCurrentPage();
    while ((this.mWidgetAddInfo.size() > 0) && (!this.mHomeView.isWorkspaceLocked()))
    {
      WidgetAddInfo localWidgetAddInfo = (WidgetAddInfo)this.mWidgetAddInfo.remove(0);
      if (!localWidgetAddInfo.mAllowDuplicate)
      {
        Integer localInteger = (Integer)localHashMap.get(localWidgetAddInfo.mComponentName);
        if (localInteger != null)
        {
          localWorkspace.snapToPage(localInteger.intValue());
          Toast.makeText(this, getString(2131755039, new Object[] { localWidgetAddInfo.mComponentName.flattenToShortString() }), 0).show();
          continue;
        }
      }
      boolean bool2 = processAsSamsungWidget(localWidgetAddInfo);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = processAsSamsungSurfaceWidget(localWidgetAddInfo);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = processAsAndroidAppWidget(localWidgetAddInfo);
      }
      if ((bool2) && (!localHashMap.containsKey(localWidgetAddInfo.mComponentName))) {
        localHashMap.put(localWidgetAddInfo.mComponentName, Integer.valueOf(i));
      }
    }
  }
  
  public void addStateAnimatorProvider(StateAnimatorProvider paramStateAnimatorProvider)
  {
    this.mStateAnimatorProviders.add(paramStateAnimatorProvider);
  }
  
  public void bindAllAppsSecretMode()
  {
    this.mMenuView.bindMenuSecretMode();
    closePopupMenu();
  }
  
  public void bindAppsLoaded()
  {
    this.mMenuView.mMenuAppLoaded = false;
    this.mMenuView.appModelLoaded();
  }
  
  public void bindBadgeUpdated(List<AppItem> paramList, List<HomeItem> paramList1)
  {
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      this.mHomeView.bindHomeItemsUpdated(paramList1, true);
    }
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.mMenuView.appBadgeUpdated(paramList);
    }
  }
  
  public void bindFestivalModeChange(boolean paramBoolean)
  {
    sIsFestivalModeOn = paramBoolean;
    if ((this.mHomeView != null) && (this.mHomeView.isVisible()) && (this.mHomeView.getQuickViewWorkspace().isOpened())) {
      this.mHomeView.closeQuickViewWorkspace(false);
    }
    do
    {
      do
      {
        return;
      } while ((this.mMenuView == null) || (!this.mMenuView.isVisible()));
      if (this.mMenuView.getMenuAppsGrid().getAppsQuickViewState())
      {
        this.mMenuView.onBackPressed();
        return;
      }
    } while (!this.mHomeView.getQuickViewWorkspace().isOpened());
    this.mHomeView.getWorkspace().getPageIndicatorManager().setDisplayItem(PageIndicatorManager.DISPLAY_ITEM.NORMAL_PAGE);
  }
  
  public void bindHomeAppWidget(HomeWidgetItem paramHomeWidgetItem)
  {
    setLoadOnResume();
    this.mHomeView.bindAppWidget(paramHomeWidgetItem);
  }
  
  public void bindHomeBegin()
  {
    this.mHomeView.startBinding();
  }
  
  public void bindHomeDeleteFestivalPage(List<HomeWidgetItem> paramList)
  {
    this.mHomeView.getWorkspace().closeFolder();
    exitWidgetResizeMode();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.mHomeView.deleteWidgetFestivalPage(paramList);
    }
    this.mHomeView.bindHomeDeleteFestivalPage();
  }
  
  public void bindHomeDeleteSecretPage()
  {
    if (this.mSecretPageManager.getSecretPageCount() == 0) {
      return;
    }
    this.mHomeView.getWorkspace().closeFolder();
    exitWidgetResizeMode();
    this.mHomeView.bindHomeDeleteSecretPage();
    this.mHomeView.refreshQuickViewWorkspace(false);
  }
  
  public void bindHomeEnd()
  {
    setLoadOnResume();
    this.mHomeView.finishBindingItems();
    if (isHelpAppRunning)
    {
      String str = GuideFragment.GMode;
      exitHelp(false);
      isHelpAppRunning = true;
      Intent localIntent = new Intent();
      localIntent.putExtra("homescreen:guide_mode", str);
      GuideFragment.deployGuide(this, localIntent);
    }
  }
  
  public void bindHomeFolders(Map<Long, HomeFolderItem> paramMap)
  {
    setLoadOnResume();
    this.mHomeView.bindFolders(paramMap);
  }
  
  public void bindHomeInsertFestivalPage()
  {
    this.mHomeView.getWorkspace().closeFolder();
    exitWidgetResizeMode();
    if (this.mFestivalPageManager.getFestivalPageCount() > 0) {
      return;
    }
    this.mHomeView.bindHomeInsertFestivalPage();
  }
  
  public void bindHomeInsertSecretPage()
  {
    this.mHomeView.getWorkspace().closeFolder();
    exitWidgetResizeMode();
    if (this.mSecretPageManager.getSecretPageCount() > 0) {
      return;
    }
    this.mHomeView.bindHomeInsertSecretPage();
    this.mHomeView.refreshQuickViewWorkspace(true);
  }
  
  public void bindHomeItemsRemoved(List<HomeItem> paramList)
  {
    if (Utilities.DEBUGGABLE())
    {
      Object localObject = new Date(System.currentTimeMillis());
      localObject = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format((Date)localObject);
      SharedPreferences.Editor localEditor = ((LauncherApplication)getApplication()).getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
      int i = 0;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        HomeItem localHomeItem = (HomeItem)localIterator.next();
        localEditor.putString("bindHomeItemsRemoved" + i, localHomeItem.getPackageName().toString() + ", time : " + (String)localObject);
        i += 1;
      }
      localEditor.commit();
    }
    this.mHomeView.bindHomeItemsRemoved(paramList);
  }
  
  public void bindHomeItemsUpdated(List<HomeItem> paramList)
  {
    this.mHomeView.bindHomeItemsUpdated(paramList, false);
  }
  
  public void bindHomeSamsungWidget(SamsungWidgetItem paramSamsungWidgetItem)
  {
    setLoadOnResume();
    this.mHomeView.bindSamsungWidget(paramSamsungWidgetItem);
  }
  
  public void bindHomeShortcuts(List<HomeItem> paramList, int paramInt1, int paramInt2)
  {
    setLoadOnResume();
    this.mHomeView.bindItems(paramList, paramInt1, paramInt2);
  }
  
  public void bindHomeSurfaceWidget(SurfaceWidgetItem paramSurfaceWidgetItem)
  {
    setLoadOnResume();
    this.mHomeView.bindSurfaceWidget(paramSurfaceWidgetItem);
  }
  
  public void bindHotseatItems(List<HomeItem> paramList)
  {
    setLoadOnResume();
    HomeView.sIsBindHotseat = true;
    this.mHomeView.bindHotseat(paramList);
    HomeView.sIsBindHotseat = false;
  }
  
  public void bindModeChange()
  {
    this.mAutoRestart = true;
    finish();
  }
  
  public void bindPackagesChanged(boolean paramBoolean)
  {
    this.mSamsungWidgetPackageManager.forceReload();
    this.mMenuView.packagesChanged(paramBoolean);
  }
  
  public void bindSearchablesChanged()
  {
    this.mHomeView.updateGlobalSearchIcon();
  }
  
  public void bindSecretModeChange(boolean paramBoolean)
  {
    sIsSecretModeOn = paramBoolean;
    if ((this.mHomeView != null) && (this.mHomeView.isVisible()) && (this.mHomeView.getQuickViewWorkspace().isOpened())) {
      this.mHomeView.closeQuickViewWorkspace(false);
    }
    do
    {
      for (;;)
      {
        MenuAppsGrid.mChangeMenuModeForSecretBox = sIsSecretModeOn;
        return;
        if ((this.mMenuView != null) && (this.mMenuView.isVisible()))
        {
          if (!this.mMenuView.getMenuAppsGrid().getAppsQuickViewState()) {
            break;
          }
          this.mMenuView.onBackPressed();
        }
      }
    } while (!this.mHomeView.getQuickViewWorkspace().isOpened());
    PageIndicatorManager localPageIndicatorManager = this.mHomeView.getWorkspace().getPageIndicatorManager();
    if (paramBoolean) {}
    for (PageIndicatorManager.DISPLAY_ITEM localDISPLAY_ITEM = PageIndicatorManager.DISPLAY_ITEM.SECRET_PAGE;; localDISPLAY_ITEM = PageIndicatorManager.DISPLAY_ITEM.NORMAL_PAGE)
    {
      localPageIndicatorManager.setDisplayItem(localDISPLAY_ITEM);
      break;
    }
  }
  
  public void bindWidgetsAfterConfigChange()
  {
    if (!this.mIsDestroyed) {
      this.mHomeView.bindWidgetsAfterConfigChange();
    }
  }
  
  public void callDisableDialog(BaseItem paramBaseItem)
  {
    Object localObject = null;
    try
    {
      ApplicationInfo localApplicationInfo = getApplicationContext().getPackageManager().getApplicationInfo(paramBaseItem.getPackageName(), 0);
      localObject = localApplicationInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
      getApplicationContext().getPackageManager().setApplicationEnabledSetting(paramBaseItem.getPackageName(), 3, 0);
      return;
    }
    if ((localObject != null) && ((((ApplicationInfo)localObject).flags & 0x80) == 0)) {
      if (shouldDisablePopupRepeat())
      {
        DisableAppConfirmationDialog.createAndShow(paramBaseItem.getPackageName(), paramBaseItem.mTitle, getFragmentManager(), false);
        return;
      }
    }
    if (shouldDisablePopupRepeat())
    {
      DisableAppConfirmationDialog.createAndShow(paramBaseItem.getPackageName(), paramBaseItem.mTitle, getFragmentManager(), true);
      return;
    }
    mPackageTobeDisabled = paramBaseItem.getPackageName();
    uninstallPackage(mPackageTobeDisabled);
  }
  
  public boolean checkFactoryMode()
  {
    return (isFactorySim()) || (isFactoryMode());
  }
  
  public void closePopupMenu()
  {
    if (this.mPopupMenu != null)
    {
      this.mPopupMenu.dismiss();
      sPopupMenuShowing = false;
    }
    closeOptionsMenu();
    sHwPopupMenuShowing = false;
  }
  
  public void createPopupMenu(View paramView)
  {
    setMarketLabel();
    if (paramView == null) {
      throw new NullPointerException("Could not find anchor for menu button.");
    }
    this.mMenuButtonView = paramView;
    this.mPopupMenu = new PopupMenu(this, paramView);
    this.mPopupMenu.setOnDismissListener(new PopupMenu.OnDismissListener()
    {
      public void onDismiss(PopupMenu paramAnonymousPopupMenu)
      {
        Launcher.access$902(false);
      }
    });
    this.mOptionsMenu = this.mPopupMenu.getMenu();
    this.mPopupMenu.getMenuInflater().inflate(2131886080, this.mOptionsMenu);
    this.mPopupMenu.setOnMenuItemClickListener(this);
    setupOptionsMenu(this.mOptionsMenu);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int j = 0;
    boolean bool2 = true;
    MenuWidgets localMenuWidgets;
    if (paramKeyEvent.getAction() == 0)
    {
      localMenuWidgets = null;
      if (this.mMenuView != null) {
        localMenuWidgets = this.mMenuView.getMenuWidgets();
      }
      switch (paramKeyEvent.getKeyCode())
      {
      }
    }
    for (;;)
    {
      boolean bool1 = super.dispatchKeyEvent(paramKeyEvent);
      label282:
      label365:
      label1084:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return bool1;
                        if (((GuideFragment.sHelpHubStepNumber == 1) || (GuideFragment.sHelpHubStepNumber == 2)) && (isHelpAppRunning))
                        {
                          if (paramKeyEvent.getKeyCode() == 23) {
                            break;
                          }
                          return false;
                        }
                        if ((getHomeScreenOptionMenu().hasFocus()) || (!isPageEdit())) {
                          break;
                        }
                        return true;
                        bool1 = bool2;
                      } while (!isHelpAppRunning);
                      return false;
                      return false;
                      if (!isPropertyEnabled("launcher_dump_state")) {
                        break;
                      }
                      this.mHomeView.dumpState();
                      return true;
                      if (!isPageEdit()) {
                        break label282;
                      }
                      if (isPageReorderingEdit())
                      {
                        if (getHomeScreenOptionMenu().hasFocus()) {
                          break;
                        }
                        getHomeScreenOptionMenu().requestFocus();
                        break;
                      }
                      bool1 = bool2;
                    } while (localMenuWidgets == null);
                    bool1 = bool2;
                  } while (!localMenuWidgets.isShown());
                  break;
                  if ((!isEmptyPage()) || (getHotseat() == null)) {
                    break;
                  }
                  getHotseat().requestFocus();
                  return true;
                  if (!isPageEdit()) {
                    break label365;
                  }
                  if (isPageReorderingEdit())
                  {
                    if (getHomeScreenOptionMenu().hasFocus()) {
                      break;
                    }
                    getHomeScreenOptionMenu().requestFocus();
                    break;
                  }
                  bool1 = bool2;
                } while (localMenuWidgets == null);
                bool1 = bool2;
              } while (!localMenuWidgets.isShown());
              break;
              if ((isEmptyPage()) && (getHotseat() != null))
              {
                getHotseat().requestFocus();
                return true;
              }
              if (localMenuWidgets == null) {
                break;
              }
              int i = j;
              if (!(getCurrentFocus() instanceof PagedViewWidget))
              {
                i = j;
                if (!(getCurrentFocus() instanceof SearchView.SearchAutoComplete)) {
                  i = 1;
                }
              }
              if ((!this.mMenuView.isVisible()) || (localMenuWidgets.getWidgetState() != MenuWidgets.WidgetState.SEARCH) || (i == 0)) {
                break;
              }
              paramKeyEvent = (ViewGroup)this.mMenuView.findViewById(2131689671);
              bool1 = bool2;
            } while (paramKeyEvent == null);
            paramKeyEvent.requestFocus();
            return true;
            return false;
            if ((this.mHomeView != null) && (this.mHomeView.getWorkspace() != null) && (this.mHomeView.getWorkspace().getOpenFolder() == null)) {
              this.mHomeView.clearChildFocus(getCurrentFocus());
            }
            for (;;)
            {
              return false;
              if ((this.mMenuView != null) && (this.mMenuView.getMenuAppsGrid() != null) && (this.mMenuView.getMenuAppsGrid().getOpenFolder() == null)) {
                this.mMenuView.clearChildFocus(getCurrentFocus());
              }
            }
            if (paramKeyEvent.getAction() != 1) {
              break;
            }
            switch (paramKeyEvent.getKeyCode())
            {
            default: 
              break;
            case 3: 
              bool1 = bool2;
            }
          } while (!isHelpAppRunning);
          return false;
          if ((getHomeScreenOptionMenu().hasFocus()) || (!isPageEdit())) {
            break;
          }
          return true;
          if (isHelpAppRunning) {
            return false;
          }
          if (!this.mHasMenuKey)
          {
            localMenuWidgets = this.mMenuView.getMenuWidgets();
            if ((localMenuWidgets != null) && (this.mMenuView.isVisible()) && (this.mMenuView.isCurrentTabWidgets()))
            {
              WidgetFolder localWidgetFolder = localMenuWidgets.getWidgetFolder();
              if (localMenuWidgets.getWidgetState() != MenuWidgets.WidgetState.NORMAL) {
                return false;
              }
              if ((localWidgetFolder != null) && (localWidgetFolder.isOpened())) {
                return false;
              }
            }
            else
            {
              if ((this.mMenuView.isVisible()) && (this.mMenuView.getState() != MenuAppsGrid.State.NORMAL) && (this.mMenuView.getState() != MenuAppsGrid.State.DOWNLOADED_APPS)) {
                return false;
              }
              if ((this.mHomeView.isVisible()) && (this.mHomeView.getWorkspace().getState() != Workspace.State.NORMAL)) {
                return false;
              }
            }
            if (this.mMenuView.getState() == MenuAppsGrid.State.DOWNLOADED_APPS) {
              if ((this.mPopupMenu == null) || ((this.mMenuButtonView != null) && (this.mMenuButtonView.getId() != 2131689634))) {
                createPopupMenu(this.mMenuView.findViewById(2131689634));
              }
            }
            for (;;)
            {
              setupOptionsMenu(this.mOptionsMenu);
              this.mPopupMenu.dismiss();
              this.mPopupMenu.show();
              sPopupMenuShowing = true;
              return true;
              if ((this.mHomeView.isVisible()) && (this.mHomeView.getWorkspace().getState() == Workspace.State.NORMAL))
              {
                bool1 = bool2;
                if ((paramKeyEvent.getFlags() & 0x20) != 0) {
                  break;
                }
                this.mHomeView.openQuickViewWorkspace(null, true);
                return true;
              }
              if ((this.mPopupMenu == null) || ((this.mMenuButtonView != null) && (this.mMenuButtonView.getId() != 2131689653))) {
                createPopupMenu(findViewById(2131689653));
              }
            }
          }
          if ((!this.mHomeView.isVisible()) || (this.mHomeView.getWorkspace().getState() != Workspace.State.NORMAL)) {
            break label1084;
          }
          bool1 = bool2;
        } while ((paramKeyEvent.getFlags() & 0x20) != 0);
        if (this.mHomeView.getQuickViewWorkspace().isOpened())
        {
          this.mHomeView.getQuickViewWorkspace().drawCloseAnimation();
          return true;
        }
        this.mHomeView.openQuickViewWorkspace(null, true);
        return true;
        return false;
        if (!isPageEdit()) {
          break;
        }
        bool1 = bool2;
      } while (!isPageReorderingEdit());
      if (!getHomeScreenOptionMenu().hasFocus()) {
        getHomeScreenOptionMenu().requestFocus();
      }
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent = paramAccessibilityEvent.getText();
    paramAccessibilityEvent.clear();
    if (this.mMenuView.isVisible())
    {
      if (this.mMenuView.isCurrentTabAppsTab()) {
        if (this.mMenuView.getState() == MenuAppsGrid.State.DOWNLOADED_APPS) {
          paramAccessibilityEvent.add(getString(2131755061));
        }
      }
      while (!this.mMenuView.isCurrentTabWidgets())
      {
        return bool;
        paramAccessibilityEvent.add(getString(2131755225));
        return bool;
      }
      paramAccessibilityEvent.add(getString(2131755011));
      return bool;
    }
    paramAccessibilityEvent.add(getString(2131755032));
    return bool;
  }
  
  public void exitAllApps()
  {
    exitAllApps(false, false);
  }
  
  public void exitAllApps(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mMenuView == null) || ((!this.mMenuView.isVisible()) && (!this.mTransitioningToAllApps)) || ((this.mTransitionAnimator != null) && (this.mTransitionAnimator.isRunning()))) {
      if ((this.mHomeView.getQuickViewWorkspace() != null) && (this.mHomeView.getQuickViewWorkspace().isOpened()) && (this.mTransitionAnimator != null) && (this.mTransitionAnimator.isRunning()))
      {
        if (this.mTransitioningToAllApps) {
          break label107;
        }
        this.mTransitionAnimator.end();
        this.mHomeView.getQuickViewWorkspace().drawCloseAnimation();
      }
    }
    label107:
    Workspace localWorkspace;
    do
    {
      return;
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          Launcher.this.exitAllApps(false, false);
        }
      }, 200L);
      return;
      this.mMenuView.onExitAllApps();
      if ((isHelpAppRunning) && (GuideFragment.GMode.equals("add_widgets"))) {
        this.mHomeView.addHelpAppPage();
      }
      if (this.mTransitionAnimator != null) {
        this.mTransitionAnimator.cancel();
      }
      localWorkspace = this.mHomeView.getWorkspace();
      QuickViewWorkspace localQuickViewWorkspace = this.mHomeView.getQuickViewWorkspace();
      if ((localWorkspace != null) && ((localQuickViewWorkspace == null) || (!localQuickViewWorkspace.isOpened())))
      {
        localWorkspace.resumeScreen(localWorkspace.getCurrentPage());
        if ((!paramBoolean1) && (LauncherApplication.sMagazineLauncher)) {
          localWorkspace.resumeMagazineCling();
        }
        if (this.mHomeView.getHomeAppsBtn() != null) {
          this.mHomeView.getHomeAppsBtn().setVisibility(0);
        }
        if (this.mHomeView.getHomePhoneBtn() != null) {
          this.mHomeView.getHomePhoneBtn().setVisibility(0);
        }
      }
      while (paramBoolean2)
      {
        this.mHomeView.setVisibility(0);
        this.mHomeView.setAlpha(1.0F);
        this.mHomeView.setScaleX(1.0F);
        this.mHomeView.setScaleY(1.0F);
        if (localWorkspace != null)
        {
          float f2 = 0.0F;
          float f1 = f2;
          if (localQuickViewWorkspace != null)
          {
            f1 = f2;
            if (localQuickViewWorkspace.isOpened()) {
              f1 = this.mHomeView.getResources().getFraction(2131558405, 1, 1);
            }
          }
          localWorkspace.setBackgroundDarken(f1);
        }
        finishExitAllApps();
        return;
        this.mHomeView.getHomeScreenOptionMenu().setMakeActive(true);
      }
      this.mExitingAllApps = true;
      this.mHomeView.setVisibility(0);
      if (!paramBoolean1) {
        break;
      }
      if ((localQuickViewWorkspace != null) && (localQuickViewWorkspace.isOpened())) {
        this.mHomeView.closeQuickViewWorkspace(true, false);
      }
    } while (localWorkspace == null);
    localWorkspace.onFadeStart();
    return;
    exitAllappsAnimation(false);
  }
  
  public void exitAllappsAnimation(boolean paramBoolean)
  {
    Object localObject1 = this.mHomeView.getWorkspace();
    Object localObject2 = this.mHomeView.getQuickViewWorkspace();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mStateAnimatorProviders.iterator();
    while (localIterator.hasNext()) {
      ((StateAnimatorProvider)localIterator.next()).collectExitAllAppsAnimators(localArrayList);
    }
    if ((localObject1 != null) && (!paramBoolean))
    {
      int j = 2131034121;
      int i = j;
      if (localObject2 != null)
      {
        i = j;
        if (((QuickViewWorkspace)localObject2).isOpened()) {
          i = 2131034122;
        }
      }
      localObject2 = AnimatorInflater.loadAnimator(this, i);
      ((Animator)localObject2).setTarget(localObject1);
      localArrayList.add(localObject2);
    }
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).playTogether(localArrayList);
    ((AnimatorSet)localObject1).setDuration(400L);
    ((AnimatorSet)localObject1).setInterpolator(new SineInOut90());
    ((AnimatorSet)localObject1).addListener(new AnimatorListenerAdapter()
    {
      private boolean mCancelled = false;
      
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.mCancelled = true;
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if ((!this.mCancelled) && (!Launcher.this.mIsDestroyed)) {
          Launcher.this.finishExitAllApps();
        }
      }
    });
    this.mTransitionAnimator = ((Animator)localObject1);
    ((AnimatorSet)localObject1).start();
    getAnimationLayer().cancelAnimations();
  }
  
  public void exitHelp(boolean paramBoolean)
  {
    if (getHomeView().getQuickViewWorkspace().isOpened()) {
      getHomeView().closeQuickViewWorkspace(true);
    }
    isHelpAppRunning = false;
    Object localObject;
    if (GuideFragment.GMode.equals("add_widgets"))
    {
      isExitingFromHelp = true;
      this.mHomeView.removehelpAppPage();
      this.mHomeView.mIsHelpItemAdded = false;
      HomeEditBar.isfolderCreated = false;
      localObject = new Intent();
      ((Intent)localObject).putExtra("homescreen:guide_mode", "onBackPressed");
      ((Intent)localObject).putExtra("currentGmode", GuideFragment.GMode);
      GuideFragment.deployGuide(this, (Intent)localObject);
      com.android.launcher2.guide.ResizeWidgetsGuider.isWidgetToBeAdded = true;
      GuideFragment.sHelpHubStepNumber = 1;
      GuideFragment.isViewAppsDialogDismissed = false;
      if (paramBoolean)
      {
        localObject = getLaunchIntentForHelpHub();
        if (localObject != null) {
          startActivity((Intent)localObject);
        }
      }
    }
    for (;;)
    {
      if (getResources().getConfiguration().smallestScreenWidthDp < 600) {
        this.mPrevOrientationHelp = 1;
      }
      setRequestedOrientation(this.mPrevOrientationHelp);
      this.mHomeView.getWorkspace().showPageIndicator(false);
      return;
      if (GuideFragment.GMode.equals("change_wallpaper"))
      {
        isExitingFromHelp = true;
        this.mHomeView.removehelpAppPage();
        this.mHomeView.mIsHelpItemAdded = false;
        HomeEditBar.isfolderCreated = false;
        if (HomeScreenDialogFragment.isHomeScreenDialogVisible) {
          HomeScreenDialogFragment.dismiss(getFragmentManager());
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("homescreen:guide_mode", "onBackPressed");
        ((Intent)localObject).putExtra("currentGmode", GuideFragment.GMode);
        GuideFragment.deployGuide(this, (Intent)localObject);
        com.android.launcher2.guide.ResizeWidgetsGuider.isWidgetToBeAdded = true;
        GuideFragment.sHelpHubStepNumber = 1;
        GuideFragment.isViewAppsDialogDismissed = false;
        if (paramBoolean)
        {
          localObject = getLaunchIntentForHelpHub();
          if (localObject != null) {
            startActivity((Intent)localObject);
          }
        }
      }
      else
      {
        if (wasWidgetsTabShown)
        {
          localObject = this.mMenuView.getMenuWidgets();
          if (localObject != null) {
            ((MenuWidgets)localObject).updatePackages("Launcher - exitHelp");
          }
          wasWidgetsTabShown = false;
        }
        GuideFragment.removeWrongActionDialog();
        this.mHomeView.removehelpAppPage();
        this.mHomeView.mIsHelpItemAdded = false;
        HomeEditBar.isfolderCreated = false;
        if (HomeScreenDialogFragment.isHomeScreenDialogVisible) {
          HomeScreenDialogFragment.dismiss(getFragmentManager());
        }
        CellLayout.isWidgetResized = false;
        isExitingFromWallpaperActivity = false;
        AddToHomescreenDialogFragment.setWallpaperSelected = true;
        HomeScreenDialogFragment.homescreenSelected = true;
        if ((MenuView.mOldViewType != this.mMenuView.getViewType()) && (MenuView.mOldViewType != null)) {
          this.mMenuView.setViewType(MenuView.mOldViewType);
        }
        if ((MenuView.oldState != this.mMenuView.getState()) && (MenuView.oldState != null)) {
          this.mMenuView.changeState(MenuView.oldState);
        }
        isExitingFromHelp = true;
        localObject = new Intent();
        ((Intent)localObject).putExtra("homescreen:guide_mode", "onBackPressed");
        ((Intent)localObject).putExtra("currentGmode", GuideFragment.GMode);
        GuideFragment.deployGuide(this, (Intent)localObject);
        com.android.launcher2.guide.ResizeWidgetsGuider.isWidgetToBeAdded = true;
        GuideFragment.sHelpHubStepNumber = 1;
        GuideFragment.isViewAppsDialogDismissed = false;
        if (paramBoolean)
        {
          localObject = getLaunchIntentForHelpHub();
          if (localObject != null) {
            startActivity((Intent)localObject);
          }
        }
      }
    }
  }
  
  public void finishWallpaperGuide(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Toast.makeText(this, 2131755180, 1).show();
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          if (Launcher.isHelpAppRunning) {
            Launcher.this.exitHelp(true);
          }
        }
      }, 2000L);
    }
    while (!isHelpAppRunning) {
      return;
    }
    exitHelp(true);
  }
  
  public AnimationLayer getAnimationLayer()
  {
    return this.mAnimationLayer;
  }
  
  public int getDisplayOrientation()
  {
    switch (getWindowManager().getDefaultDisplay().getRotation())
    {
    case 2: 
    default: 
      return 1;
    }
    return 2;
  }
  
  public FestivalPageManager getFestivalPageManager()
  {
    return this.mFestivalPageManager;
  }
  
  public HomeScreenOptionMenu getHomeScreenOptionMenu()
  {
    return this.mHomeView.getHomeScreenOptionMenu();
  }
  
  public HomeView getHomeView()
  {
    return this.mHomeView;
  }
  
  Hotseat getHotseat()
  {
    return this.mHomeView.getHotseat();
  }
  
  public HotwordServiceClient getHotwordServiceClient()
  {
    return this.mHotwordServiceClient;
  }
  
  public MenuView getMenuView()
  {
    return this.mMenuView;
  }
  
  public boolean getQuickViewWorkspaceOpen()
  {
    if (this.mHomeView.getQuickViewWorkspace() != null) {
      return this.mHomeView.getQuickViewWorkspace().isOpened();
    }
    return false;
  }
  
  public SamsungWidgetPackageManager getSamsungWidgetPackageManager()
  {
    return this.mSamsungWidgetPackageManager;
  }
  
  public SecretPageManager getSecretPageManager()
  {
    return this.mSecretPageManager;
  }
  
  public boolean getShowEmptyPageMessagePref()
  {
    return this.mShowEmptyPageMsg;
  }
  
  public SurfaceWidgetPackageManager getSurfaceWidgetPackageManager()
  {
    return this.mSurfaceWidgetPackageManager;
  }
  
  public boolean getTransitionToAllApps()
  {
    return this.mTransitioningToAllApps;
  }
  
  public IBinder getWindowToken()
  {
    return getWindow().getAttributes().token;
  }
  
  public boolean isAddToScreenDialogShowing()
  {
    return AddToHomescreenDialogFragment.isActive(getFragmentManager());
  }
  
  public boolean isAirMoveOninSettings()
  {
    ContentResolver localContentResolver = getContentResolver();
    return (Settings.System.getInt(localContentResolver, "air_motion_item_move", 0) == 1) && (Settings.System.getInt(localContentResolver, "air_motion_engine", 0) == 1) && (bSupportAirMove);
  }
  
  public boolean isDialogChecked()
  {
    return getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getBoolean("add.toast.popup.dismissed.key", true);
  }
  
  public boolean isEmptyPage()
  {
    Object localObject;
    if (this.mHomeView.isVisible())
    {
      localObject = this.mHomeView.getPage(this.mHomeView.getCurrentPage());
      if ((((CellLayout)localObject).getChildAt(0) instanceof CellLayoutChildren)) {
        break label40;
      }
    }
    label40:
    int j;
    do
    {
      return false;
      localObject = (CellLayoutChildren)((CellLayout)localObject).getChildAt(0);
      j = 0;
      int i = 0;
      while (i < ((CellLayoutChildren)localObject).getChildCount())
      {
        int k = j;
        if ((((CellLayoutChildren)localObject).getChildAt(i) instanceof AppIconView)) {
          k = j + 1;
        }
        i += 1;
        j = k;
      }
    } while ((getCurrentFocus() != null) || (j != 0));
    return true;
  }
  
  public boolean isExitingAllApps()
  {
    return this.mExitingAllApps;
  }
  
  public boolean isHapticFeedbackExtraOn()
  {
    return Settings.System.getInt(getContentResolver(), "haptic_feedback_extra", 0) == 1;
  }
  
  public boolean isHelpAppAvailable()
  {
    boolean bool = false;
    Intent localIntent = new Intent("com.samsung.helphub.HELP");
    if (getPackageManager().queryIntentActivities(localIntent, 0).size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isHelpHubAvailable()
  {
    if (LauncherApplication.isTabletLayout()) {
      sHelpHubAvailable = Boolean.FALSE;
    }
    for (;;)
    {
      return sHelpHubAvailable.booleanValue();
      if (sHelpHubAvailable == null)
      {
        Object localObject = Uri.parse("content://com.samsung.helphub.provider/help_page_status/");
        localObject = getContentResolver().query((Uri)localObject, new String[] { "displayed" }, null, null, null);
        if (localObject == null)
        {
          sHelpHubAvailable = Boolean.FALSE;
        }
        else
        {
          ((Cursor)localObject).close();
          sHelpHubAvailable = Boolean.TRUE;
        }
      }
    }
  }
  
  public boolean isKeyStringBlocked()
  {
    return false;
  }
  
  public boolean isLauncherDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  public void isMagazineHomeEnabled(SharedPreferences paramSharedPreferences)
  {
    sIsMagazineHomeEnable = paramSharedPreferences.getBoolean("pref_my_magazine", true);
    if (!LauncherApplication.sMagazineLauncher) {
      sIsMagazineHomeEnable = false;
    }
  }
  
  public boolean isPageEdit()
  {
    if (this.mMenuView != null)
    {
      MenuWidgets localMenuWidgets = this.mMenuView.getMenuWidgets();
      if (((this.mHomeView.getQuickViewWorkspace().isOpened()) && ((localMenuWidgets == null) || ((localMenuWidgets != null) && (!localMenuWidgets.isShown())))) || (this.mMenuView.getState() == MenuAppsGrid.State.PAGE_EDIT)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isPageReorderingEdit()
  {
    if (this.mMenuView != null)
    {
      MenuWidgets localMenuWidgets = this.mMenuView.getMenuWidgets();
      if ((this.mHomeView.getQuickViewWorkspace().isOpened()) && (!getHomeScreenOptionMenu().isSettingVisible()) && ((localMenuWidgets == null) || ((localMenuWidgets != null) && (!localMenuWidgets.isShown())))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isPaused()
  {
    return this.mPaused;
  }
  
  public boolean isResumed_()
  {
    return this.mResumed;
  }
  
  public boolean isTransitioningRunning()
  {
    return (this.mTransitionAnimator != null) && (this.mTransitionAnimator.isRunning());
  }
  
  public boolean isTransitioningToShowAllApps()
  {
    return (this.mTransitioningToAllApps) || (this.mInMenu) || ((this.mTransitionAnimator != null) && (this.mTransitionAnimator.isRunning()));
  }
  
  public void launchOptionWallpaper()
  {
    if (LauncherApplication.getInst().isKnoxMode())
    {
      getHomeView().startWallpaper(0);
      return;
    }
    getHomeView().startWallpaper(0);
  }
  
  public void menuWidgetsUpdated(boolean paramBoolean)
  {
    if ((this.mOptionsMenu != null) && (isOptionMenuShowing()) && (this.mMenuView.isCurrentTabWidgets()))
    {
      MenuItem localMenuItem = this.mOptionsMenu.findItem(2131689715);
      if ((localMenuItem != null) && (this.mMenuView.getMenuWidgets() != null)) {
        localMenuItem.setEnabled(paramBoolean);
      }
    }
    if ((this.mHomeView != null) && (this.mHomeView.isVisible()) && (this.mHomeView.getQuickViewWorkspace().isOpened())) {
      this.mHomeView.getQuickViewWorkspace().updateWidgetButtonState();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    if (paramInt1 == 111) {
      paramIntent = getApplicationContext().getPackageManager();
    }
    do
    {
      ActivityResultCallback localActivityResultCallback;
      do
      {
        try
        {
          if ((paramIntent.getApplicationInfo(mPackageTobeDisabled, 8704).flags & 0x80) == 0) {
            paramIntent.setApplicationEnabledSetting(mPackageTobeDisabled, 3, 0);
          }
          return;
        }
        catch (PackageManager.NameNotFoundException paramIntent)
        {
          Log.d("Launcher", "onActivityResult pkg:" + mPackageTobeDisabled, paramIntent);
          return;
        }
        if ((paramInt1 == 10) && (isHelpAppRunning))
        {
          if (paramInt2 == -1) {
            bool = true;
          }
          finishWallpaperGuide(bool);
        }
        localActivityResultCallback = (ActivityResultCallback)this.mActivityCallbacks.get(paramInt1);
      } while (localActivityResultCallback == null);
      localActivityResultCallback.onActivityResult(paramInt1, paramInt2, paramIntent);
      this.mActivityCallbacks.remove(paramInt1);
    } while ((!isHelpAppRunning) || (paramInt1 != 5) || (paramInt2 != 0));
    exitHelp(true);
  }
  
  public void onAttachedToWindow()
  {
    Log.d("Launcher", "onAttachedToWindow");
    super.onAttachedToWindow();
    this.mHotwordServiceClient.onAttachedToWindow();
    setEnableHotWord(false);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    localIntentFilter.addAction("android.intent.action.REQUEST_HOME_COUNT");
    localIntentFilter.addAction("android.intent.action.REQUEST_WIDGET_COUNT");
    localIntentFilter.addAction("com.android.launcher.action.ACTION_HOME_RESTORE");
    if (LauncherApplication.sMagazineLauncher)
    {
      localIntentFilter.addAction("com.android.systemui.statusbar.EXPANDED");
      localIntentFilter.addAction("com.android.systemui.statusbar.COLLAPSED");
    }
    registerReceiver(this.mReceiver, localIntentFilter);
    this.mAttached = true;
    if ((mPendingIntent != null) && (this.mRemainSavedInstance)) {
      onNewIntent(mPendingIntent);
    }
    mPendingIntent = null;
    this.mRemainSavedInstance = true;
  }
  
  public void onBackPressed()
  {
    if (isHelpAppRunning)
    {
      if ((this.mHomeView == null) || (this.mHomeView.handleResizeWidget())) {
        break label77;
      }
      exitHelp(true);
    }
    while ((this.mMenuView.isVisible()) || (this.mTransitioningToAllApps))
    {
      if (!this.mMenuView.onBackPressed())
      {
        closeOptionsMenu();
        if (this.isEnteredFromMagazine)
        {
          startMagazineApp(false);
          this.isEnteredFromMagazine = false;
        }
      }
      else
      {
        return;
        label77:
        if ((!GuideFragment.GMode.equals("add_widgets")) && (!GuideFragment.GMode.equals("change_wallpaper"))) {
          continue;
        }
        exitHelp(true);
        continue;
      }
      exitAllApps();
      return;
    }
    this.mHomeView.onBackPressed();
  }
  
  public void onClickAppMarketButton()
  {
    if (this.mAppMarketIntent != null) {
      startActivitySafely(this.mAppMarketIntent, "app market");
    }
  }
  
  public void onClickAppMarketButton(View paramView)
  {
    onClickAppMarketButton();
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.mMenuView.changeState(MenuAppsGrid.State.NORMAL);
  }
  
  public void onClickDownloadedButton(View paramView)
  {
    Talk.INSTANCE.sayByTalkback(32, getString(2131755061), false);
    this.mMenuView.onOptionSelectedDownload();
  }
  
  public void onClickPopupMenuButton(View paramView)
  {
    if (isHelpAppRunning) {}
    do
    {
      return;
      if ((this.mPopupMenu != null) && (sPopupMenuShowing))
      {
        closePopupMenu();
        return;
      }
    } while (((this.mTransitionAnimator != null) && (this.mTransitionAnimator.isRunning())) || ((this.mMenuView != null) && (!this.mMenuView.mMenuAppLoaded)));
    createPopupMenu(paramView);
    this.mPopupMenu.show();
    sPopupMenuShowing = true;
  }
  
  public void onClickonlineHelp()
  {
    int i;
    try
    {
      i = getPackageManager().getPackageInfo("com.samsung.helphub", 0).versionCode % 10;
      if (i == 1) {
        return;
      }
      if (i == 2)
      {
        Intent localIntent1 = new Intent("com.samsung.helphub.HELP");
        localIntent1.putExtra("helphub:section", "homescreen");
        startActivity(localIntent1);
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      return;
    }
    if (i == 3)
    {
      Intent localIntent2 = new Intent("com.samsung.helphub.HELP");
      localIntent2.putExtra("helphub:appid", "home_screen");
      startActivity(localIntent2);
    }
  }
  
  public void onClickstartDownloadableApps()
  {
    Intent localIntent = new Intent();
    if ("CHM".equals(readSalesCode())) {
      localIntent.setClassName("com.sec.android.app.moreservices", "com.sec.android.app.moreservices.moreservices");
    }
    for (;;)
    {
      localIntent.addFlags(335544352);
      try
      {
        startActivity(localIntent);
        return;
        localIntent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.downloadableapps.DownloadableAppsActivity");
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        do
        {
          Toast.makeText(this, 2131755010, 0).show();
        } while (!DEBUGGABLE);
        Log.e("Launcher", "Unable to launch. tag=samsungapps downloadable page intent=" + localIntent, localActivityNotFoundException);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        do
        {
          Toast.makeText(this, 2131755010, 0).show();
        } while (!DEBUGGABLE);
        Log.e("Launcher", "Launcher does not have the permission to launch " + localIntent + ". Make sure to create a MAIN intent-filter for the corresponding activity " + "or use the exported attribute for this activity. " + "tag=" + "samsungapps downloadable page" + " intent=" + localIntent, localSecurityException);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Log.d("Launcher", "onConfigurationChanged. orientation: " + paramConfiguration.orientation);
    if ((sActivityOrientation != paramConfiguration.orientation) && (SurfaceWidgetView.isRotationEnabled()) && (!this.mMenuView.isVisible()))
    {
      int i = this.mHomeView.getWorkspace().getCurrentPage();
      CellLayoutChildren localCellLayoutChildren = ((CellLayout)this.mHomeView.getWorkspace().getChildAt(i)).getChildrenLayout();
      i = 0;
      while (i < localCellLayoutChildren.getChildCount())
      {
        View localView = localCellLayoutChildren.getChildAt(i);
        if ((localView instanceof SurfaceWidgetView)) {
          ((SurfaceWidgetView)localView).orientationChange();
        }
        i += 1;
      }
    }
    sActivityOrientation = paramConfiguration.orientation;
    super.onConfigurationChanged(paramConfiguration);
  }
  
  /* Error */
  protected void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1922	com/android/launcher2/Launcher:getApplication	()Landroid/app/Application;
    //   4: checkcast 791	com/android/launcher2/LauncherApplication
    //   7: astore 4
    //   9: aload 4
    //   11: aload_0
    //   12: invokevirtual 2707	com/android/launcher2/LauncherApplication:setLauncher	(Lcom/android/launcher2/Launcher;)V
    //   15: aload_0
    //   16: invokevirtual 1099	com/android/launcher2/Launcher:getPackageManager	()Landroid/content/pm/PackageManager;
    //   19: ldc_w 2709
    //   22: invokevirtual 2712	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   25: ifeq +7 -> 32
    //   28: iconst_1
    //   29: putstatic 369	com/android/launcher2/Launcher:is_TB	Z
    //   32: new 533	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 534	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 2714
    //   42: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: astore 5
    //   47: aload_1
    //   48: ifnonnull +1286 -> 1334
    //   51: ldc_w 2716
    //   54: astore_3
    //   55: ldc -102
    //   57: aload 5
    //   59: aload_3
    //   60: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc_w 2718
    //   66: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: invokestatic 546	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   73: invokevirtual 549	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: invokevirtual 553	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 559	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: aload_0
    //   84: aload_1
    //   85: invokespecial 2720	android/app/ActivityGroup:onCreate	(Landroid/os/Bundle;)V
    //   88: aload_1
    //   89: ifnull +1252 -> 1341
    //   92: iconst_1
    //   93: istore_2
    //   94: aload_0
    //   95: iload_2
    //   96: putfield 460	com/android/launcher2/Launcher:mRemainSavedInstance	Z
    //   99: aload_0
    //   100: invokevirtual 642	com/android/launcher2/Launcher:getResources	()Landroid/content/res/Resources;
    //   103: astore_3
    //   104: ldc -102
    //   106: new 533	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 534	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 2722
    //   116: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_3
    //   120: invokevirtual 2726	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   123: getfield 2731	android/util/DisplayMetrics:densityDpi	I
    //   126: invokevirtual 549	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 553	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 559	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   135: pop
    //   136: getstatic 2734	com/android/launcher2/LauncherApplication:sDensityDpi	I
    //   139: ifle +22 -> 161
    //   142: getstatic 2734	com/android/launcher2/LauncherApplication:sDensityDpi	I
    //   145: aload_3
    //   146: invokevirtual 2726	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   149: getfield 2731	android/util/DisplayMetrics:densityDpi	I
    //   152: if_icmpeq +9 -> 161
    //   155: invokestatic 2737	android/os/Process:myPid	()I
    //   158: invokestatic 2740	android/os/Process:killProcess	(I)V
    //   161: aload_3
    //   162: invokevirtual 2726	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   165: getfield 2731	android/util/DisplayMetrics:densityDpi	I
    //   168: putstatic 2734	com/android/launcher2/LauncherApplication:sDensityDpi	I
    //   171: aload_0
    //   172: aload 4
    //   174: invokevirtual 2744	com/android/launcher2/LauncherApplication:getSpanCalculator	()Lcom/android/launcher2/WorkspaceSpanCalculator;
    //   177: putfield 1275	com/android/launcher2/Launcher:mSpanCalculator	Lcom/android/launcher2/WorkspaceSpanCalculator;
    //   180: aload_3
    //   181: ldc_w 2745
    //   184: iconst_1
    //   185: iconst_1
    //   186: invokevirtual 2285	android/content/res/Resources:getFraction	(III)F
    //   189: putstatic 2747	com/android/launcher2/Launcher:sMenuBgDarkenAmountNormal	F
    //   192: aload_3
    //   193: invokestatic 2753	com/android/launcher2/FolderIconHelper:initFolderResources	(Landroid/content/res/Resources;)V
    //   196: aload_3
    //   197: invokevirtual 1055	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   200: getfield 2694	android/content/res/Configuration:orientation	I
    //   203: putstatic 417	com/android/launcher2/Launcher:sActivityOrientation	I
    //   206: getstatic 391	com/android/launcher2/Launcher:UseLauncherHighPriority	Z
    //   209: ifeq +8 -> 217
    //   212: bipush -4
    //   214: invokestatic 2756	android/os/Process:setThreadPriority	(I)V
    //   217: aload_0
    //   218: invokespecial 2030	com/android/launcher2/Launcher:isFactorySim	()Z
    //   221: ifne +1219 -> 1440
    //   224: aload_0
    //   225: invokespecial 2032	com/android/launcher2/Launcher:isFactoryMode	()Z
    //   228: ifne +1212 -> 1440
    //   231: aload_0
    //   232: invokevirtual 778	com/android/launcher2/Launcher:getContentResolver	()Landroid/content/ContentResolver;
    //   235: ldc_w 2758
    //   238: iconst_1
    //   239: invokestatic 2764	android/provider/Settings$Secure:putInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)Z
    //   242: ifeq +1104 -> 1346
    //   245: ldc -102
    //   247: ldc_w 2766
    //   250: invokestatic 559	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   253: pop
    //   254: aload_0
    //   255: invokevirtual 778	com/android/launcher2/Launcher:getContentResolver	()Landroid/content/ContentResolver;
    //   258: ldc_w 2758
    //   261: invokestatic 2769	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;)I
    //   264: iconst_1
    //   265: if_icmpne +12 -> 277
    //   268: ldc -102
    //   270: ldc_w 2771
    //   273: invokestatic 559	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   276: pop
    //   277: aload_0
    //   278: invokevirtual 778	com/android/launcher2/Launcher:getContentResolver	()Landroid/content/ContentResolver;
    //   281: ldc_w 2773
    //   284: iconst_1
    //   285: invokestatic 2764	android/provider/Settings$Secure:putInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)Z
    //   288: ifeq +1105 -> 1393
    //   291: ldc -102
    //   293: ldc_w 2775
    //   296: invokestatic 559	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   299: pop
    //   300: aload_0
    //   301: invokevirtual 778	com/android/launcher2/Launcher:getContentResolver	()Landroid/content/ContentResolver;
    //   304: ldc_w 2773
    //   307: invokestatic 2769	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;)I
    //   310: iconst_1
    //   311: if_icmpne +12 -> 323
    //   314: ldc -102
    //   316: ldc_w 2777
    //   319: invokestatic 559	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   322: pop
    //   323: invokestatic 1510	com/sec/android/app/CscFeature:getInstance	()Lcom/sec/android/app/CscFeature;
    //   326: ldc_w 2779
    //   329: invokevirtual 1513	com/sec/android/app/CscFeature:getEnableStatus	(Ljava/lang/String;)Z
    //   332: ifeq +11 -> 343
    //   335: iconst_1
    //   336: putstatic 371	com/android/launcher2/Launcher:CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE	Z
    //   339: iconst_1
    //   340: putstatic 395	com/android/launcher2/Launcher:CSCFEATURE_LAUNCHER_REPLACEHOTSEATAREAINEDITMODE	Z
    //   343: ldc -102
    //   345: new 533	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 534	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 2781
    //   355: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: getstatic 401	com/android/launcher2/Launcher:CSCFEATURE_LAUNCHER_DYNAMICCSCFEATURE	Z
    //   361: invokevirtual 820	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   364: invokevirtual 553	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 1338	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   370: pop
    //   371: getstatic 401	com/android/launcher2/Launcher:CSCFEATURE_LAUNCHER_DYNAMICCSCFEATURE	Z
    //   374: ifeq +31 -> 405
    //   377: aload_1
    //   378: ifnonnull +27 -> 405
    //   381: aload_0
    //   382: new 1048	android/content/Intent
    //   385: dup
    //   386: ldc_w 2783
    //   389: invokespecial 1051	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   392: invokevirtual 2786	com/android/launcher2/Launcher:sendBroadcast	(Landroid/content/Intent;)V
    //   395: ldc_w 2788
    //   398: ldc_w 2790
    //   401: invokestatic 559	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   404: pop
    //   405: iconst_0
    //   406: putstatic 411	com/android/launcher2/Launcher:SEC_PRODUCT_FEATURE_LAUNCHER_KITKAT_ADD_TO_HOMESCREEN_CONCEPT	Z
    //   409: invokestatic 795	com/android/launcher2/LauncherApplication:getInst	()Lcom/android/launcher2/LauncherApplication;
    //   412: invokevirtual 2794	com/android/launcher2/LauncherApplication:getThemeLoader	()Lcom/android/launcher2/ThemeLoader;
    //   415: invokevirtual 2799	com/android/launcher2/ThemeLoader:isSupportTheme	()Z
    //   418: ifeq +7 -> 425
    //   421: iconst_1
    //   422: putstatic 407	com/android/launcher2/Launcher:CSCFEATURE_LAUNCHER_THEME_ENABLE	Z
    //   425: getstatic 316	com/android/launcher2/Launcher:DEBUGGABLE	Z
    //   428: ifeq +43 -> 471
    //   431: ldc -102
    //   433: new 533	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 534	java/lang/StringBuilder:<init>	()V
    //   440: ldc_w 2801
    //   443: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: getstatic 371	com/android/launcher2/Launcher:CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE	Z
    //   449: invokevirtual 820	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   452: ldc_w 2803
    //   455: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: getstatic 395	com/android/launcher2/Launcher:CSCFEATURE_LAUNCHER_REPLACEHOTSEATAREAINEDITMODE	Z
    //   461: invokevirtual 820	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   464: invokevirtual 553	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 1338	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   470: pop
    //   471: aload_0
    //   472: invokevirtual 642	com/android/launcher2/Launcher:getResources	()Landroid/content/res/Resources;
    //   475: invokevirtual 1055	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   478: getfield 2806	android/content/res/Configuration:keyboard	I
    //   481: iconst_2
    //   482: if_icmpne +970 -> 1452
    //   485: iconst_1
    //   486: istore_2
    //   487: iload_2
    //   488: putstatic 393	com/android/launcher2/Launcher:UseQwertyKeypad	Z
    //   491: aload_0
    //   492: invokestatic 2809	com/android/launcher2/LauncherApplication:hasMenuKey	()Z
    //   495: putfield 466	com/android/launcher2/Launcher:mHasMenuKey	Z
    //   498: aload_0
    //   499: aload 4
    //   501: invokevirtual 1700	com/android/launcher2/LauncherApplication:getModel	()Lcom/android/launcher2/LauncherModel;
    //   504: putfield 627	com/android/launcher2/Launcher:mModel	Lcom/android/launcher2/LauncherModel;
    //   507: aload_0
    //   508: getfield 627	com/android/launcher2/Launcher:mModel	Lcom/android/launcher2/LauncherModel;
    //   511: aload_0
    //   512: invokevirtual 2813	com/android/launcher2/LauncherModel:initialize	(Lcom/android/launcher2/LauncherModel$Callbacks;)V
    //   515: aload_0
    //   516: aload 4
    //   518: invokevirtual 2817	com/android/launcher2/LauncherApplication:getPkgResCache	()Lcom/android/launcher2/PkgResCache;
    //   521: putfield 2819	com/android/launcher2/Launcher:mPkgResCache	Lcom/android/launcher2/PkgResCache;
    //   524: aload_0
    //   525: aload 4
    //   527: invokevirtual 2822	com/android/launcher2/LauncherApplication:getPkgResCacheForMenu	()Lcom/android/launcher2/PkgResCache;
    //   530: putfield 2824	com/android/launcher2/Launcher:mPkgResCacheForMenu	Lcom/android/launcher2/PkgResCache;
    //   533: aload_0
    //   534: getfield 627	com/android/launcher2/Launcher:mModel	Lcom/android/launcher2/LauncherModel;
    //   537: invokevirtual 2827	com/android/launcher2/LauncherModel:hasLocaleChanged	()Z
    //   540: ifeq +23 -> 563
    //   543: invokestatic 2830	com/android/launcher2/LauncherApplication:isMenuIconSizeChanged	()Z
    //   546: ifeq +17 -> 563
    //   549: aload_0
    //   550: getfield 2824	com/android/launcher2/Launcher:mPkgResCacheForMenu	Lcom/android/launcher2/PkgResCache;
    //   553: ifnull +10 -> 563
    //   556: aload_0
    //   557: getfield 2824	com/android/launcher2/Launcher:mPkgResCacheForMenu	Lcom/android/launcher2/PkgResCache;
    //   560: invokevirtual 2833	com/android/launcher2/PkgResCache:clear	()V
    //   563: aload_0
    //   564: aload_0
    //   565: ldc -126
    //   567: iconst_0
    //   568: invokevirtual 2494	com/android/launcher2/Launcher:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   571: ldc_w 2835
    //   574: iconst_1
    //   575: invokeinterface 2497 3 0
    //   580: putfield 2468	com/android/launcher2/Launcher:mShowEmptyPageMsg	Z
    //   583: aload_0
    //   584: invokevirtual 1170	com/android/launcher2/Launcher:getApplicationContext	()Landroid/content/Context;
    //   587: invokestatic 2841	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   590: astore 4
    //   592: aload_0
    //   593: aload 4
    //   595: invokevirtual 2843	com/android/launcher2/Launcher:isMagazineHomeEnabled	(Landroid/content/SharedPreferences;)V
    //   598: invokestatic 2518	com/android/launcher2/LauncherApplication:isTabletLayout	()Z
    //   601: ifne +27 -> 628
    //   604: ldc_w 2845
    //   607: ldc_w 1505
    //   610: invokevirtual 1001	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   613: ifne +15 -> 628
    //   616: ldc_w 1505
    //   619: ldc_w 1505
    //   622: invokevirtual 1001	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   625: ifeq +832 -> 1457
    //   628: iconst_0
    //   629: putstatic 320	com/android/launcher2/Launcher:sIsHeadlinesAppEnable	Z
    //   632: invokestatic 2518	com/android/launcher2/LauncherApplication:isTabletLayout	()Z
    //   635: ifeq +867 -> 1502
    //   638: iconst_0
    //   639: putstatic 419	com/android/launcher2/Launcher:sWhichTransitionEffect	I
    //   642: aload_0
    //   643: ldc_w 2846
    //   646: invokevirtual 2849	com/android/launcher2/Launcher:setContentView	(I)V
    //   649: aload_0
    //   650: getstatic 2851	com/android/launcher2/SamsungWidgetPackageManager:INSTANCE	Lcom/android/launcher2/SamsungWidgetPackageManager;
    //   653: putfield 1312	com/android/launcher2/Launcher:mSamsungWidgetPackageManager	Lcom/android/launcher2/SamsungWidgetPackageManager;
    //   656: aload_0
    //   657: getfield 1312	com/android/launcher2/Launcher:mSamsungWidgetPackageManager	Lcom/android/launcher2/SamsungWidgetPackageManager;
    //   660: invokevirtual 2854	com/android/launcher2/SamsungWidgetPackageManager:loadIfNeeded	()V
    //   663: aload_0
    //   664: getstatic 2857	com/android/launcher2/SurfaceWidgetPackageManager:INST	Lcom/android/launcher2/SurfaceWidgetPackageManager;
    //   667: putfield 1290	com/android/launcher2/Launcher:mSurfaceWidgetPackageManager	Lcom/android/launcher2/SurfaceWidgetPackageManager;
    //   670: aload_0
    //   671: getfield 1290	com/android/launcher2/Launcher:mSurfaceWidgetPackageManager	Lcom/android/launcher2/SurfaceWidgetPackageManager;
    //   674: aload_0
    //   675: invokevirtual 2859	com/android/launcher2/SurfaceWidgetPackageManager:loadIfNeeded	(Landroid/content/Context;)V
    //   678: aload_0
    //   679: aload_0
    //   680: ldc_w 2860
    //   683: invokevirtual 2202	com/android/launcher2/Launcher:findViewById	(I)Landroid/view/View;
    //   686: checkcast 844	com/android/launcher2/HomeView
    //   689: putfield 842	com/android/launcher2/Launcher:mHomeView	Lcom/android/launcher2/HomeView;
    //   692: aload_0
    //   693: aload_0
    //   694: ldc_w 2861
    //   697: invokevirtual 2202	com/android/launcher2/Launcher:findViewById	(I)Landroid/view/View;
    //   700: checkcast 962	com/android/launcher2/MenuView
    //   703: putfield 960	com/android/launcher2/Launcher:mMenuView	Lcom/android/launcher2/MenuView;
    //   706: aload_0
    //   707: aload_0
    //   708: ldc_w 2862
    //   711: invokevirtual 2202	com/android/launcher2/Launcher:findViewById	(I)Landroid/view/View;
    //   714: putfield 2864	com/android/launcher2/Launcher:mDarkenView	Landroid/view/View;
    //   717: aload_3
    //   718: ldc_w 2865
    //   721: invokevirtual 1451	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   724: astore 4
    //   726: aload_0
    //   727: aload 4
    //   729: iconst_0
    //   730: invokestatic 1750	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   733: astore 5
    //   735: aload_0
    //   736: getfield 960	com/android/launcher2/Launcher:mMenuView	Lcom/android/launcher2/MenuView;
    //   739: ldc_w 2201
    //   742: invokevirtual 2150	com/android/launcher2/MenuView:findViewById	(I)Landroid/view/View;
    //   745: checkcast 2867	android/widget/FrameLayout
    //   748: astore 6
    //   750: aload 6
    //   752: ifnull +84 -> 836
    //   755: aload 6
    //   757: new 14	com/android/launcher2/Launcher$1
    //   760: dup
    //   761: aload_0
    //   762: aload 5
    //   764: invokespecial 2870	com/android/launcher2/Launcher$1:<init>	(Lcom/android/launcher2/Launcher;Landroid/widget/Toast;)V
    //   767: invokevirtual 2874	android/widget/FrameLayout:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   770: aload 6
    //   772: invokevirtual 2878	android/widget/FrameLayout:getHoverPopupWindow	()Landroid/widget/HoverPopupWindow;
    //   775: ifnull +61 -> 836
    //   778: aload 6
    //   780: iconst_1
    //   781: invokevirtual 2881	android/widget/FrameLayout:setHoverPopupType	(I)V
    //   784: aload 6
    //   786: invokevirtual 2878	android/widget/FrameLayout:getHoverPopupWindow	()Landroid/widget/HoverPopupWindow;
    //   789: aload 4
    //   791: invokevirtual 2887	android/widget/HoverPopupWindow:setContent	(Ljava/lang/CharSequence;)V
    //   794: aload 6
    //   796: invokevirtual 2878	android/widget/FrameLayout:getHoverPopupWindow	()Landroid/widget/HoverPopupWindow;
    //   799: sipush 12341
    //   802: invokevirtual 2890	android/widget/HoverPopupWindow:setPopupGravity	(I)V
    //   805: aload 6
    //   807: invokevirtual 2878	android/widget/FrameLayout:getHoverPopupWindow	()Landroid/widget/HoverPopupWindow;
    //   810: aload_3
    //   811: ldc_w 2891
    //   814: invokevirtual 2894	android/content/res/Resources:getDimensionPixelOffset	(I)I
    //   817: aload_3
    //   818: ldc_w 2895
    //   821: invokevirtual 2894	android/content/res/Resources:getDimensionPixelOffset	(I)I
    //   824: invokevirtual 2899	android/widget/HoverPopupWindow:setPopupPosOffset	(II)V
    //   827: aload 6
    //   829: invokevirtual 2878	android/widget/FrameLayout:getHoverPopupWindow	()Landroid/widget/HoverPopupWindow;
    //   832: iconst_0
    //   833: invokevirtual 2902	android/widget/HoverPopupWindow:setFHAnimationEnabled	(Z)V
    //   836: aload_0
    //   837: invokevirtual 885	com/android/launcher2/Launcher:getFragmentManager	()Landroid/app/FragmentManager;
    //   840: invokevirtual 891	android/app/FragmentManager:beginTransaction	()Landroid/app/FragmentTransaction;
    //   843: astore 4
    //   845: aload_1
    //   846: ifnull +708 -> 1554
    //   849: aload_1
    //   850: ldc 103
    //   852: invokevirtual 2906	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   855: ifeq +672 -> 1527
    //   858: aload_0
    //   859: getfield 960	com/android/launcher2/Launcher:mMenuView	Lcom/android/launcher2/MenuView;
    //   862: iconst_0
    //   863: invokevirtual 970	com/android/launcher2/MenuView:setVisibility	(I)V
    //   866: aload_0
    //   867: iconst_1
    //   868: putfield 506	com/android/launcher2/Launcher:mInMenu	Z
    //   871: aload_0
    //   872: getfield 842	com/android/launcher2/Launcher:mHomeView	Lcom/android/launcher2/HomeView;
    //   875: iconst_4
    //   876: invokevirtual 969	com/android/launcher2/HomeView:setVisibility	(I)V
    //   879: aload_0
    //   880: getfield 2864	com/android/launcher2/Launcher:mDarkenView	Landroid/view/View;
    //   883: getstatic 2747	com/android/launcher2/Launcher:sMenuBgDarkenAmountNormal	F
    //   886: invokevirtual 2907	android/view/View:setAlpha	(F)V
    //   889: aload 4
    //   891: invokevirtual 912	android/app/FragmentTransaction:commit	()I
    //   894: pop
    //   895: aload_0
    //   896: getstatic 419	com/android/launcher2/Launcher:sWhichTransitionEffect	I
    //   899: invokevirtual 2910	com/android/launcher2/Launcher:setWhichTransitionEffect	(I)V
    //   902: aload_0
    //   903: getfield 2912	com/android/launcher2/Launcher:mRestoring	Z
    //   906: ifne +13 -> 919
    //   909: aload_0
    //   910: getfield 627	com/android/launcher2/Launcher:mModel	Lcom/android/launcher2/LauncherModel;
    //   913: getstatic 413	com/android/launcher2/Launcher:sIsSecretModeOn	Z
    //   916: invokevirtual 2915	com/android/launcher2/LauncherModel:startLoader	(Z)V
    //   919: new 2595	android/content/IntentFilter
    //   922: dup
    //   923: ldc_w 2917
    //   926: invokespecial 2918	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   929: astore_1
    //   930: aload_0
    //   931: aload_0
    //   932: getfield 453	com/android/launcher2/Launcher:mCloseSystemDialogsReceiver	Landroid/content/BroadcastReceiver;
    //   935: aload_1
    //   936: invokevirtual 2611	com/android/launcher2/Launcher:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   939: pop
    //   940: new 2595	android/content/IntentFilter
    //   943: dup
    //   944: ldc_w 2920
    //   947: invokespecial 2918	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   950: astore_1
    //   951: aload_0
    //   952: aload_0
    //   953: getfield 456	com/android/launcher2/Launcher:mTalkbackEnableReceiver	Landroid/content/BroadcastReceiver;
    //   956: aload_1
    //   957: invokevirtual 2611	com/android/launcher2/Launcher:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   960: pop
    //   961: aload_0
    //   962: aload_0
    //   963: invokestatic 2925	com/android/launcher2/BadgeCountReceiver:initialize	(Landroid/content/Context;)Lcom/android/launcher2/BadgeCountReceiver;
    //   966: putfield 2927	com/android/launcher2/Launcher:mBadgeCountChangedReceiver	Lcom/android/launcher2/BadgeCountReceiver;
    //   969: aload_3
    //   970: ldc_w 2928
    //   973: invokevirtual 2931	android/content/res/Resources:getBoolean	(I)Z
    //   976: ifne +25 -> 1001
    //   979: aload_0
    //   980: new 2933	com/android/launcher2/ChangeCallAppReceiver
    //   983: dup
    //   984: invokespecial 2934	com/android/launcher2/ChangeCallAppReceiver:<init>	()V
    //   987: putfield 2936	com/android/launcher2/Launcher:mChangeCallAppReceiver	Lcom/android/launcher2/ChangeCallAppReceiver;
    //   990: aload_0
    //   991: getfield 2936	com/android/launcher2/Launcher:mChangeCallAppReceiver	Lcom/android/launcher2/ChangeCallAppReceiver;
    //   994: aload_0
    //   995: getfield 842	com/android/launcher2/Launcher:mHomeView	Lcom/android/launcher2/HomeView;
    //   998: invokevirtual 2939	com/android/launcher2/ChangeCallAppReceiver:init	(Lcom/android/launcher2/HomeView;)V
    //   1001: getstatic 2942	com/android/launcher2/LauncherApplication:sFestivalPageLauncher	Z
    //   1004: ifeq +26 -> 1030
    //   1007: aload_0
    //   1008: new 1892	com/android/launcher2/FestivalPageManager
    //   1011: dup
    //   1012: aload_0
    //   1013: invokespecial 2943	com/android/launcher2/FestivalPageManager:<init>	(Lcom/android/launcher2/Launcher;)V
    //   1016: putfield 1890	com/android/launcher2/Launcher:mFestivalPageManager	Lcom/android/launcher2/FestivalPageManager;
    //   1019: aload_0
    //   1020: getfield 1890	com/android/launcher2/Launcher:mFestivalPageManager	Lcom/android/launcher2/FestivalPageManager;
    //   1023: aload_0
    //   1024: getfield 842	com/android/launcher2/Launcher:mHomeView	Lcom/android/launcher2/HomeView;
    //   1027: invokevirtual 2946	com/android/launcher2/FestivalPageManager:initFestivalPage	(Lcom/android/launcher2/HomeView;)V
    //   1030: aload_0
    //   1031: new 915	android/text/SpannableStringBuilder
    //   1034: dup
    //   1035: invokespecial 2947	android/text/SpannableStringBuilder:<init>	()V
    //   1038: putfield 462	com/android/launcher2/Launcher:mDefaultKeySsb	Landroid/text/SpannableStringBuilder;
    //   1041: aload_0
    //   1042: getfield 462	com/android/launcher2/Launcher:mDefaultKeySsb	Landroid/text/SpannableStringBuilder;
    //   1045: iconst_0
    //   1046: invokestatic 927	android/text/Selection:setSelection	(Landroid/text/Spannable;I)V
    //   1049: new 1048	android/content/Intent
    //   1052: dup
    //   1053: ldc_w 2949
    //   1056: invokespecial 1051	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1059: ldc_w 2951
    //   1062: invokevirtual 2954	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   1065: astore_1
    //   1066: aload_0
    //   1067: aload_1
    //   1068: aload_0
    //   1069: invokevirtual 1099	com/android/launcher2/Launcher:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1072: invokevirtual 2958	android/content/Intent:resolveActivity	(Landroid/content/pm/PackageManager;)Landroid/content/ComponentName;
    //   1075: putfield 1420	com/android/launcher2/Launcher:mActivityName	Landroid/content/ComponentName;
    //   1078: aload_0
    //   1079: getfield 1420	com/android/launcher2/Launcher:mActivityName	Landroid/content/ComponentName;
    //   1082: ifnull +8 -> 1090
    //   1085: aload_0
    //   1086: aload_1
    //   1087: putfield 464	com/android/launcher2/Launcher:mAppMarketIntent	Landroid/content/Intent;
    //   1090: aload_0
    //   1091: aload_0
    //   1092: ldc_w 2959
    //   1095: invokevirtual 2202	com/android/launcher2/Launcher:findViewById	(I)Landroid/view/View;
    //   1098: checkcast 1446	com/android/launcher2/AnimationLayer
    //   1101: putfield 2435	com/android/launcher2/Launcher:mAnimationLayer	Lcom/android/launcher2/AnimationLayer;
    //   1104: aload_0
    //   1105: invokespecial 2961	com/android/launcher2/Launcher:setIndicatorTransparency	()V
    //   1108: aload_0
    //   1109: iconst_1
    //   1110: invokevirtual 2964	com/android/launcher2/Launcher:setSystemUiTransparency	(Z)V
    //   1113: getstatic 371	com/android/launcher2/Launcher:CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE	Z
    //   1116: ifeq +457 -> 1573
    //   1119: iconst_0
    //   1120: invokestatic 2966	com/android/launcher2/Launcher:setHomeEditMode	(Z)V
    //   1123: iconst_0
    //   1124: invokestatic 2968	com/android/launcher2/Launcher:setHomeRemoveMode	(Z)V
    //   1127: aload_3
    //   1128: invokevirtual 1055	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   1131: getfield 1060	android/content/res/Configuration:smallestScreenWidthDp	I
    //   1134: sipush 600
    //   1137: if_icmplt +451 -> 1588
    //   1140: aload_0
    //   1141: iconst_m1
    //   1142: invokevirtual 2380	com/android/launcher2/Launcher:setRequestedOrientation	(I)V
    //   1145: aload_0
    //   1146: aload_0
    //   1147: invokevirtual 2971	com/android/launcher2/Launcher:getIntent	()Landroid/content/Intent;
    //   1150: ldc_w 2949
    //   1153: invokespecial 2973	com/android/launcher2/Launcher:tryQueueWidgetAddViaIntent	(Landroid/content/Intent;Ljava/lang/String;)Z
    //   1156: pop
    //   1157: getstatic 2260	com/android/launcher2/LauncherApplication:sMagazineLauncher	Z
    //   1160: ifeq +7 -> 1167
    //   1163: iconst_0
    //   1164: putstatic 324	com/android/launcher2/Launcher:mIsExpandStatusBar	Z
    //   1167: getstatic 326	com/android/launcher2/Launcher:isSystemAppDisable	Z
    //   1170: ifeq +11 -> 1181
    //   1173: aload_0
    //   1174: invokespecial 2975	com/android/launcher2/Launcher:addNonDisableAppToList	()V
    //   1177: aload_0
    //   1178: invokespecial 2977	com/android/launcher2/Launcher:addNonDisableAppToListCsc	()V
    //   1181: getstatic 2980	com/android/launcher2/LauncherApplication:RemovablePreloadEnabled	I
    //   1184: iconst_1
    //   1185: if_icmpne +15 -> 1200
    //   1188: aload_0
    //   1189: invokespecial 2982	com/android/launcher2/Launcher:addRemovablePreloadAppToList	()V
    //   1192: aload_0
    //   1193: invokespecial 2984	com/android/launcher2/Launcher:addRemovableCustomerAppToList	()V
    //   1196: aload_0
    //   1197: invokespecial 2986	com/android/launcher2/Launcher:addRemovableAppToList	()V
    //   1200: aload_0
    //   1201: aload_0
    //   1202: ldc_w 2988
    //   1205: invokevirtual 599	com/android/launcher2/Launcher:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1208: checkcast 2990	android/app/enterprise/EnterpriseDeviceManager
    //   1211: putfield 2992	com/android/launcher2/Launcher:mEnterpriseDeviceManager	Landroid/app/enterprise/EnterpriseDeviceManager;
    //   1214: aload_0
    //   1215: getfield 2992	com/android/launcher2/Launcher:mEnterpriseDeviceManager	Landroid/app/enterprise/EnterpriseDeviceManager;
    //   1218: ifnull +14 -> 1232
    //   1221: aload_0
    //   1222: aload_0
    //   1223: getfield 2992	com/android/launcher2/Launcher:mEnterpriseDeviceManager	Landroid/app/enterprise/EnterpriseDeviceManager;
    //   1226: invokevirtual 2996	android/app/enterprise/EnterpriseDeviceManager:getApplicationPolicy	()Landroid/app/enterprise/ApplicationPolicy;
    //   1229: putfield 1515	com/android/launcher2/Launcher:mApplicationPolicy	Landroid/app/enterprise/ApplicationPolicy;
    //   1232: aload_0
    //   1233: new 2589	com/google/android/hotword/client/HotwordServiceClient
    //   1236: dup
    //   1237: aload_0
    //   1238: invokespecial 2997	com/google/android/hotword/client/HotwordServiceClient:<init>	(Landroid/app/Activity;)V
    //   1241: putfield 2458	com/android/launcher2/Launcher:mHotwordServiceClient	Lcom/google/android/hotword/client/HotwordServiceClient;
    //   1244: getstatic 3000	com/android/launcher2/LauncherApplication:sIsTheFisrt	Z
    //   1247: ifeq +25 -> 1272
    //   1250: invokestatic 795	com/android/launcher2/LauncherApplication:getInst	()Lcom/android/launcher2/LauncherApplication;
    //   1253: ldc_w 3002
    //   1256: aconst_null
    //   1257: aload_0
    //   1258: getfield 842	com/android/launcher2/Launcher:mHomeView	Lcom/android/launcher2/HomeView;
    //   1261: invokevirtual 848	com/android/launcher2/HomeView:getWorkspace	()Lcom/android/launcher2/Workspace;
    //   1264: invokevirtual 853	com/android/launcher2/Workspace:getChildCount	()I
    //   1267: i2l
    //   1268: iconst_1
    //   1269: invokevirtual 3006	com/android/launcher2/LauncherApplication:insertLog	(Ljava/lang/String;Ljava/lang/String;JZ)V
    //   1272: aload_0
    //   1273: invokevirtual 778	com/android/launcher2/Launcher:getContentResolver	()Landroid/content/ContentResolver;
    //   1276: astore_3
    //   1277: aload_3
    //   1278: aload_0
    //   1279: getfield 495	com/android/launcher2/Launcher:content_uri	Landroid/net/Uri;
    //   1282: aconst_null
    //   1283: aconst_null
    //   1284: aconst_null
    //   1285: aconst_null
    //   1286: invokevirtual 2534	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1289: astore_1
    //   1290: aload_1
    //   1291: ifnull +543 -> 1834
    //   1294: aload_1
    //   1295: invokeinterface 3009 1 0
    //   1300: ifeq +309 -> 1609
    //   1303: aload_1
    //   1304: aload_1
    //   1305: ldc_w 3011
    //   1308: invokeinterface 3015 2 0
    //   1313: invokeinterface 3016 2 0
    //   1318: ldc_w 3018
    //   1321: invokevirtual 1001	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1324: ifeq +278 -> 1602
    //   1327: iconst_0
    //   1328: putstatic 421	com/android/launcher2/Launcher:mAlwaysMicOn	Z
    //   1331: goto -37 -> 1294
    //   1334: ldc_w 3020
    //   1337: astore_3
    //   1338: goto -1283 -> 55
    //   1341: iconst_0
    //   1342: istore_2
    //   1343: goto -1249 -> 94
    //   1346: ldc -102
    //   1348: ldc_w 3022
    //   1351: invokestatic 559	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1354: pop
    //   1355: goto -1078 -> 277
    //   1358: astore 5
    //   1360: ldc -102
    //   1362: new 533	java/lang/StringBuilder
    //   1365: dup
    //   1366: invokespecial 534	java/lang/StringBuilder:<init>	()V
    //   1369: ldc_w 3024
    //   1372: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: aload 5
    //   1377: invokevirtual 3027	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1380: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: invokevirtual 553	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1386: invokestatic 812	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1389: pop
    //   1390: goto -1113 -> 277
    //   1393: ldc -102
    //   1395: ldc_w 3022
    //   1398: invokestatic 559	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1401: pop
    //   1402: goto -1079 -> 323
    //   1405: astore 5
    //   1407: ldc -102
    //   1409: new 533	java/lang/StringBuilder
    //   1412: dup
    //   1413: invokespecial 534	java/lang/StringBuilder:<init>	()V
    //   1416: ldc_w 3029
    //   1419: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1422: aload 5
    //   1424: invokevirtual 3027	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1427: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: invokevirtual 553	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1433: invokestatic 812	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1436: pop
    //   1437: goto -1114 -> 323
    //   1440: ldc -102
    //   1442: ldc_w 3031
    //   1445: invokestatic 559	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1448: pop
    //   1449: goto -1126 -> 323
    //   1452: iconst_0
    //   1453: istore_2
    //   1454: goto -967 -> 487
    //   1457: invokestatic 1562	com/android/launcher2/LauncherApplication:isOwner	()Z
    //   1460: ifeq +35 -> 1495
    //   1463: invokestatic 795	com/android/launcher2/LauncherApplication:getInst	()Lcom/android/launcher2/LauncherApplication;
    //   1466: invokevirtual 798	com/android/launcher2/LauncherApplication:isKnoxMode	()Z
    //   1469: ifne +26 -> 1495
    //   1472: getstatic 322	com/android/launcher2/Launcher:sIsMagazineHomeEnable	Z
    //   1475: ifne +20 -> 1495
    //   1478: aload 4
    //   1480: ldc_w 2546
    //   1483: iconst_1
    //   1484: invokeinterface 2497 3 0
    //   1489: putstatic 320	com/android/launcher2/Launcher:sIsHeadlinesAppEnable	Z
    //   1492: goto -860 -> 632
    //   1495: iconst_0
    //   1496: putstatic 320	com/android/launcher2/Launcher:sIsHeadlinesAppEnable	Z
    //   1499: goto -867 -> 632
    //   1502: aload 4
    //   1504: ldc_w 3033
    //   1507: ldc_w 3035
    //   1510: invokeinterface 3038 3 0
    //   1515: invokestatic 3041	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1518: invokevirtual 1732	java/lang/Integer:intValue	()I
    //   1521: putstatic 419	com/android/launcher2/Launcher:sWhichTransitionEffect	I
    //   1524: goto -882 -> 642
    //   1527: aload_0
    //   1528: getfield 842	com/android/launcher2/Launcher:mHomeView	Lcom/android/launcher2/HomeView;
    //   1531: iconst_0
    //   1532: invokevirtual 969	com/android/launcher2/HomeView:setVisibility	(I)V
    //   1535: aload_0
    //   1536: getfield 960	com/android/launcher2/Launcher:mMenuView	Lcom/android/launcher2/MenuView;
    //   1539: iconst_4
    //   1540: invokevirtual 970	com/android/launcher2/MenuView:setVisibility	(I)V
    //   1543: aload_0
    //   1544: getfield 2864	com/android/launcher2/Launcher:mDarkenView	Landroid/view/View;
    //   1547: fconst_0
    //   1548: invokevirtual 2907	android/view/View:setAlpha	(F)V
    //   1551: goto -662 -> 889
    //   1554: aload_0
    //   1555: getfield 842	com/android/launcher2/Launcher:mHomeView	Lcom/android/launcher2/HomeView;
    //   1558: iconst_0
    //   1559: invokevirtual 969	com/android/launcher2/HomeView:setVisibility	(I)V
    //   1562: aload_0
    //   1563: getfield 960	com/android/launcher2/Launcher:mMenuView	Lcom/android/launcher2/MenuView;
    //   1566: iconst_4
    //   1567: invokevirtual 970	com/android/launcher2/MenuView:setVisibility	(I)V
    //   1570: goto -681 -> 889
    //   1573: iconst_0
    //   1574: putstatic 395	com/android/launcher2/Launcher:CSCFEATURE_LAUNCHER_REPLACEHOTSEATAREAINEDITMODE	Z
    //   1577: iconst_0
    //   1578: invokestatic 2966	com/android/launcher2/Launcher:setHomeEditMode	(Z)V
    //   1581: iconst_0
    //   1582: invokestatic 2968	com/android/launcher2/Launcher:setHomeRemoveMode	(Z)V
    //   1585: goto -458 -> 1127
    //   1588: aload_0
    //   1589: iconst_1
    //   1590: invokevirtual 2380	com/android/launcher2/Launcher:setRequestedOrientation	(I)V
    //   1593: goto -448 -> 1145
    //   1596: astore_1
    //   1597: aconst_null
    //   1598: astore_1
    //   1599: goto -309 -> 1290
    //   1602: iconst_1
    //   1603: putstatic 421	com/android/launcher2/Launcher:mAlwaysMicOn	Z
    //   1606: goto -312 -> 1294
    //   1609: aload_1
    //   1610: invokeinterface 2537 1 0
    //   1615: aload_0
    //   1616: invokevirtual 778	com/android/launcher2/Launcher:getContentResolver	()Landroid/content/ContentResolver;
    //   1619: ldc_w 3043
    //   1622: iconst_0
    //   1623: invokestatic 786	android/provider/Settings$System:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   1626: putstatic 423	com/android/launcher2/Launcher:mIsBabyCryingEnable	I
    //   1629: aload_0
    //   1630: invokevirtual 778	com/android/launcher2/Launcher:getContentResolver	()Landroid/content/ContentResolver;
    //   1633: ldc_w 3045
    //   1636: iconst_0
    //   1637: invokestatic 786	android/provider/Settings$System:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   1640: putstatic 425	com/android/launcher2/Launcher:mIsDoorbellEnable	I
    //   1643: getstatic 2640	com/sec/dtl/launcher/Talk:INSTANCE	Lcom/sec/dtl/launcher/Talk;
    //   1646: invokevirtual 3048	com/sec/dtl/launcher/Talk:checkTalkbackEnabled	()Z
    //   1649: putstatic 427	com/android/launcher2/Launcher:mTalkbackEnable	Z
    //   1652: aload_3
    //   1653: aload_0
    //   1654: getfield 495	com/android/launcher2/Launcher:content_uri	Landroid/net/Uri;
    //   1657: iconst_1
    //   1658: aload_0
    //   1659: getfield 500	com/android/launcher2/Launcher:mAlwaysMicOnObserver	Landroid/database/ContentObserver;
    //   1662: invokevirtual 3052	android/content/ContentResolver:registerContentObserver	(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V
    //   1665: aload_3
    //   1666: ldc_w 3043
    //   1669: invokestatic 3055	android/provider/Settings$System:getUriFor	(Ljava/lang/String;)Landroid/net/Uri;
    //   1672: iconst_1
    //   1673: aload_0
    //   1674: getfield 528	com/android/launcher2/Launcher:mBabyCryingDetector	Landroid/database/ContentObserver;
    //   1677: invokevirtual 3052	android/content/ContentResolver:registerContentObserver	(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V
    //   1680: aload_3
    //   1681: ldc_w 3045
    //   1684: invokestatic 3055	android/provider/Settings$System:getUriFor	(Ljava/lang/String;)Landroid/net/Uri;
    //   1687: iconst_1
    //   1688: aload_0
    //   1689: getfield 531	com/android/launcher2/Launcher:mDoorbellDetector	Landroid/database/ContentObserver;
    //   1692: invokevirtual 3052	android/content/ContentResolver:registerContentObserver	(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V
    //   1695: new 1048	android/content/Intent
    //   1698: dup
    //   1699: aload_0
    //   1700: invokevirtual 2971	com/android/launcher2/Launcher:getIntent	()Landroid/content/Intent;
    //   1703: invokespecial 3057	android/content/Intent:<init>	(Landroid/content/Intent;)V
    //   1706: astore_1
    //   1707: aload_1
    //   1708: invokevirtual 3061	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   1711: ifnull +56 -> 1767
    //   1714: aload_1
    //   1715: ldc_w 1877
    //   1718: invokevirtual 3064	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1721: ifnull +46 -> 1767
    //   1724: getstatic 405	com/android/launcher2/Launcher:isExitingFromHelp	Z
    //   1727: ifne +40 -> 1767
    //   1730: aload_0
    //   1731: aload_0
    //   1732: invokevirtual 3067	com/android/launcher2/Launcher:getRequestedOrientation	()I
    //   1735: putfield 479	com/android/launcher2/Launcher:mPrevOrientationHelp	I
    //   1738: ldc_w 3069
    //   1741: aload_1
    //   1742: ldc 109
    //   1744: invokevirtual 3064	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1747: invokevirtual 1001	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1750: ifeq +8 -> 1758
    //   1753: aload_0
    //   1754: iconst_1
    //   1755: putfield 448	com/android/launcher2/Launcher:mIsExternalHelpActivity	Z
    //   1758: aload_0
    //   1759: aload_1
    //   1760: invokestatic 1881	com/android/launcher2/guide/GuideFragment:deployGuide	(Landroid/app/Activity;Landroid/content/Intent;)V
    //   1763: iconst_1
    //   1764: putstatic 345	com/android/launcher2/Launcher:isHelpAppRunning	Z
    //   1767: ldc_w 2845
    //   1770: ldc_w 1505
    //   1773: invokevirtual 1001	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1776: ifeq +7 -> 1783
    //   1779: iconst_1
    //   1780: putstatic 441	com/android/launcher2/Launcher:bSupportAirMove	Z
    //   1783: invokestatic 383	com/samsung/android/feature/FloatingFeature:getInstance	()Lcom/samsung/android/feature/FloatingFeature;
    //   1786: ldc_w 3071
    //   1789: invokevirtual 389	com/samsung/android/feature/FloatingFeature:getEnableStatus	(Ljava/lang/String;)Z
    //   1792: ifeq +41 -> 1833
    //   1795: getstatic 441	com/android/launcher2/Launcher:bSupportAirMove	Z
    //   1798: ifeq +35 -> 1833
    //   1801: new 2595	android/content/IntentFilter
    //   1804: dup
    //   1805: invokespecial 2596	android/content/IntentFilter:<init>	()V
    //   1808: astore_1
    //   1809: aload_1
    //   1810: ldc_w 3073
    //   1813: invokevirtual 2601	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   1816: aload_1
    //   1817: ldc_w 3075
    //   1820: invokevirtual 2601	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   1823: aload_0
    //   1824: aload_0
    //   1825: getfield 520	com/android/launcher2/Launcher:mAirGestureSettingsChangeReceiver	Landroid/content/BroadcastReceiver;
    //   1828: aload_1
    //   1829: invokevirtual 2611	com/android/launcher2/Launcher:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   1832: pop
    //   1833: return
    //   1834: iconst_1
    //   1835: putstatic 421	com/android/launcher2/Launcher:mAlwaysMicOn	Z
    //   1838: goto -223 -> 1615
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1841	0	this	Launcher
    //   0	1841	1	paramBundle	Bundle
    //   93	1361	2	bool	boolean
    //   54	1627	3	localObject1	Object
    //   7	1496	4	localObject2	Object
    //   45	718	5	localObject3	Object
    //   1358	18	5	localException1	Exception
    //   1405	18	5	localException2	Exception
    //   748	80	6	localFrameLayout	android.widget.FrameLayout
    // Exception table:
    //   from	to	target	type
    //   231	277	1358	java/lang/Exception
    //   1346	1355	1358	java/lang/Exception
    //   277	323	1405	java/lang/Exception
    //   1393	1402	1405	java/lang/Exception
    //   1277	1290	1596	java/lang/Exception
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    if (this.mHasMenuKey) {
      getMenuInflater().inflate(2131886080, paramMenu);
    }
    return true;
  }
  
  protected void onDestroy()
  {
    if (isHelpAppRunning) {
      exitHelp(false);
    }
    Object localObject = getContentResolver();
    ((ContentResolver)localObject).unregisterContentObserver(this.mAlwaysMicOnObserver);
    ((ContentResolver)localObject).unregisterContentObserver(this.mBabyCryingDetector);
    ((ContentResolver)localObject).unregisterContentObserver(this.mDoorbellDetector);
    this.mHomeView.onDestroy();
    this.mIsDestroyed = true;
    Log.d("Launcher", "onDestroy, Launcher: " + System.identityHashCode(this));
    super.onDestroy();
    Utilities.onDestroy();
    localObject = (LauncherApplication)getApplication();
    this.mModel.stopLoader();
    ((LauncherApplication)localObject).setLauncher(null);
    unregisterReceiver(this.mCloseSystemDialogsReceiver);
    unregisterReceiver(this.mTalkbackEnableReceiver);
    if (this.mPopupMenu != null)
    {
      boolean bool = sPopupMenuShowing;
      this.mPopupMenu.dismiss();
      this.mPopupMenu = null;
      sPopupMenuShowing = bool;
    }
    Talk.INSTANCE.shutdown();
    this.mBadgeCountChangedReceiver.unregister();
    if (this.mAutoRestart)
    {
      this.mAutoRestart = false;
      localObject = new Intent(this, Launcher.class);
      ((Intent)localObject).setFlags(335544320);
      ((Intent)localObject).setAction("android.intent.action.MAIN");
      ((Intent)localObject).addFlags(2097152);
      ((Intent)localObject).addCategory("android.intent.category.HOME");
      startActivity((Intent)localObject);
    }
    ShadowGen.getInstance().onDestroy();
  }
  
  public void onDetachedFromWindow()
  {
    Log.d("Launcher", "onDetachedFromWindow");
    super.onDetachedFromWindow();
    this.mHotwordServiceClient.onDetachedFromWindow();
    exitWidgetResizeMode();
    if (this.mAttached)
    {
      unregisterReceiver(this.mReceiver);
      this.mAttached = false;
    }
    this.mHomeView.updateRunning();
  }
  
  public void onGestureEvent(GestureEvent paramGestureEvent)
  {
    if (isHelpAppRunning) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((this.mHomeView == null) || (!this.mHomeView.isVisible())) {
              break;
            }
          } while (this.mHomeView.getWorkspace() == null);
          if ((this.mHomeView.getWorkspace().getState() == Workspace.State.EDIT) && (paramGestureEvent.getEvent() == 1))
          {
            if (DEBUGGABLE) {
              Log.v("Launcher", "GESTURE_EVENT_SWEEP_LEFT");
            }
            this.mHomeView.getWorkspace().moveToLeftScreen(false, true);
            return;
          }
        } while ((this.mHomeView.getWorkspace().getState() != Workspace.State.EDIT) || (paramGestureEvent.getEvent() != 0));
        if (DEBUGGABLE) {
          Log.v("Launcher", "GESTURE_EVENT_SWEEP_RIGHT");
        }
        this.mHomeView.getWorkspace().moveToLeftScreen(true, true);
        return;
      } while ((this.mMenuView == null) || (!this.mMenuView.isVisible()) || (!(this.mMenuView.getTabManager().getFragmentForTab("APPS") instanceof MenuAppsGridFragment)));
      if ((this.mMenuView.getMenuAppsGrid().getState() == MenuAppsGrid.State.EDIT) && (paramGestureEvent.getEvent() == 1))
      {
        if (DEBUGGABLE) {
          Log.v("Launcher", "GESTURE_EVENT_SWEEP_LEFT");
        }
        this.mMenuView.getMenuAppsGrid().scrollToLeft(false, true);
        return;
      }
    } while ((this.mMenuView.getMenuAppsGrid().getState() != MenuAppsGrid.State.EDIT) || (paramGestureEvent.getEvent() != 0));
    if (DEBUGGABLE) {
      Log.v("Launcher", "GESTURE_EVENT_SWEEP_RIGHT");
    }
    this.mMenuView.getMenuAppsGrid().scrollToLeft(true, true);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getUnicodeChar();
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    label81:
    Object localObject;
    if ((i > 0) && (!Character.isWhitespace(i)))
    {
      i = 1;
      if (getResources().getConfiguration().keyboard != 3) {
        break label289;
      }
      if ((paramInt < 7) || (paramInt > 18)) {
        break label247;
      }
      if ((paramInt < 7) || (paramInt > 16)) {
        break label192;
      }
      paramKeyEvent = new Intent("android.intent.action.DIAL", Uri.parse("tel:"));
      localObject = readSalesCode();
      if ((localObject != null) && (("CHZ".equals(localObject)) || ("CHN".equals(localObject)) || ("CHM".equals(localObject)) || ("CHU".equals(localObject)) || ("CTC".equals(localObject)) || ("CHC".equals(localObject)))) {
        paramKeyEvent.putExtra("firstKeycode", paramInt);
      }
      paramKeyEvent.putExtra("isKeyTone", true);
      startActivity(paramKeyEvent);
      clearTypedText();
    }
    label192:
    label247:
    label289:
    do
    {
      return bool;
      i = 0;
      break;
      if (paramInt == 18)
      {
        paramKeyEvent = new Intent("android.intent.action.DIAL", Uri.parse("tel:"));
        paramKeyEvent.putExtra("isPoundKey", true);
        break label81;
      }
      paramKeyEvent = new Intent("android.intent.action.DIAL", Uri.parse("tel:"));
      break label81;
      if (paramInt == 27)
      {
        localObject = new Intent("android.media.action.STILL_IMAGE_CAMERA");
        ((Intent)localObject).setFlags(67108864);
        ((Intent)localObject).addFlags(268435456);
        startActivity((Intent)localObject);
      }
      for (;;)
      {
        if ((paramInt == 262) && (this.mHomeView.isVisible())) {
          showAllApps();
        }
        if ((bool) || (!acceptFilter()) || (i == 0) || (!TextKeyListener.getInstance().onKeyDown(this.mHomeView.getWorkspace(), this.mDefaultKeySsb, paramInt, paramKeyEvent)) || (this.mDefaultKeySsb == null) || (this.mDefaultKeySsb.length() <= 0)) {
          break;
        }
        return onSearchRequested();
        if (paramInt == 67)
        {
          localObject = this.mHomeView.getWorkspace();
          if ((localObject != null) && (!isHelpAppRunning) && (((Workspace)localObject).getOpenFolder() == null) && (this.mHomeView.isVisible())) {
            showAllApps();
          }
        }
      }
    } while ((paramInt != 82) || (!paramKeyEvent.isLongPress()));
    return true;
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    isHelpIntentFired = true;
    super.onNewIntent(paramIntent);
    sInComingIntentHelpHub = paramIntent;
    boolean bool = tryQueueWidgetAddViaIntent(paramIntent, "android.intent.action.MAIN");
    if (!this.mAttached) {
      mPendingIntent = paramIntent;
    }
    do
    {
      return;
      closePopupMenu();
      setIntent(paramIntent);
    } while (!"android.intent.action.MAIN".equals(paramIntent.getAction()));
    if ((paramIntent.getExtras() != null) && (paramIntent.getStringExtra("homescreen:guide_mode") != null))
    {
      if (isHelpAppRunning) {
        exitHelp(false);
      }
      if (this.mHomeView.getQuickViewWorkspace().isOpened()) {
        this.mHomeView.closeQuickViewWorkspace(false);
      }
      this.mPrevOrientationHelp = getRequestedOrientation();
      if ("ExternalHelpActivity".equals(paramIntent.getStringExtra("help_activity_type"))) {
        this.mIsExternalHelpActivity = true;
      }
      GuideFragment.deployGuide(this, paramIntent);
      if (CreateFolderDialog.isActive(getFragmentManager())) {
        CreateFolderDialog.dismiss(getFragmentManager(), false);
      }
      isHelpAppRunning = true;
      this.mHomeView.showWorkspace(true);
      label168:
      exitWidgetResizeMode();
      if (!this.mHomeView.mHomeKeyPress) {
        break label542;
      }
      this.mHomeView.closeSystemDialogs(Boolean.valueOf(true));
    }
    for (;;)
    {
      paramIntent = getFragmentManager();
      if (CreateFolderDialog.isActive(paramIntent)) {
        CreateFolderDialog.dismiss(paramIntent, true);
      }
      if (!DisableAppConfirmationDialog.isActive(paramIntent)) {
        break;
      }
      FragmentTransaction localFragmentTransaction = paramIntent.beginTransaction();
      DisableAppConfirmationDialog.dismiss(localFragmentTransaction, paramIntent);
      localFragmentTransaction.commit();
      return;
      if (((paramIntent.getFlags() & 0x400000) != 4194304) && ((paramIntent.getFlags() & 0x200000) == 2097152))
      {
        if (paramIntent.getStringExtra("sec.android.intent.extra.LAUNCHER_ACTION") == null)
        {
          if (!this.mMenuView.isVisible()) {
            break label409;
          }
          paramIntent = this.mMenuView;
          if (bool) {
            break label399;
          }
          bool = true;
          if (!paramIntent.onHomePressed(bool))
          {
            Log.d("streetlife", "onNewIntent exitAllApps");
            if (!hasWindowFocus()) {
              break label404;
            }
            bool = false;
            exitAllApps(false, bool);
            if ((this.mHomeView.getQuickViewWorkspace() != null) && (this.mHomeView.getQuickViewWorkspace().isOpened())) {
              this.mHomeView.getQuickViewWorkspace().drawCloseAnimation();
            }
          }
        }
        label399:
        label404:
        label409:
        while (((!CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) && (this.mHomeView.getWorkspace().getState() == Workspace.State.EDIT)) || (0 != 0)) {
          for (;;)
          {
            paramIntent = getWindow().peekDecorView();
            if ((paramIntent == null) || (paramIntent.getWindowToken() == null)) {
              break;
            }
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramIntent.getWindowToken(), 0);
            break;
            bool = false;
            continue;
            bool = true;
          }
        }
        paramIntent = this.mHomeView;
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          paramIntent.onHomePressed(bool);
          break;
        }
      }
      if ((paramIntent.getStringExtra("sec.android.intent.extra.LAUNCHER_ACTION") != null) && (this.mMenuView.isVisible()))
      {
        if (paramIntent.getStringExtra("sec.android.intent.extra.LAUNCHER_ACTION").equals("com.android.launcher2.IDLE"))
        {
          exitAllApps(false, true);
          break label168;
        }
        cancelAppFolderRemoveDialog();
        break label168;
      }
      if ((isHelpAppRunning) && (!this.mHomeView.getWorkspace().isStartDragStarted())) {
        exitHelp(false);
      }
      exitAllApps(false, true);
      break label168;
      label542:
      this.mHomeView.closeSystemDialogs(Boolean.valueOf(false));
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    sHwPopupMenuShowing = false;
    invalidateOptionsMenu();
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 2131689727: 
      onClickstartDownloadableApps();
      return true;
    case 2131689703: 
      onClickAppMarketButton();
      return true;
    case 2131689704: 
      this.mMenuView.changeState(MenuAppsGrid.State.EDIT);
      return true;
    case 2131689712: 
      this.mMenuView.onOptionSelectedSearch();
      return true;
    case 2131689715: 
      this.mMenuView.onOptionSelectedUninstall();
      return true;
    case 2131689714: 
      this.mMenuView.onOptionSelectedDownload();
      return true;
    case 2131689713: 
      this.mMenuView.chooseViewType();
      return true;
    case 2131689716: 
      this.mMenuView.changeState(MenuAppsGrid.State.SHARE_SELECT);
      return true;
    case 2131689717: 
      this.mMenuView.changeState(MenuAppsGrid.State.SEL_APPS_TO_HIDE);
      return true;
    case 2131689719: 
      this.mMenuView.changeState(MenuAppsGrid.State.SEL_APPS_TO_UNHIDE);
      return true;
    case 2131689718: 
      this.mMenuView.changeState(MenuAppsGrid.State.SEL_APPS_TO_ENABLE);
      return true;
    case 2131689720: 
      this.mMenuView.changeState(MenuAppsGrid.State.MOVE_TO_SECRET_BOX);
      return true;
    case 2131689721: 
      this.mMenuView.changeState(MenuAppsGrid.State.REMOVE_FROM_SECRET_BOX);
      return true;
    case 2131689723: 
      ((SearchManager)getSystemService("search")).startSearch(null, false, getComponentName(), null, true);
      return true;
    case 2131689722: 
      this.mHomeView.openQuickViewWorkspace(null, true);
      return true;
    case 2131689710: 
      if (CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE)
      {
        setHomeEditMode(true);
        this.mHomeView.showWorkspaceEditmode(true);
      }
      for (;;)
      {
        return true;
        this.mHomeView.openQuickViewWorkspace(null, true);
      }
    case 2131689725: 
      paramMenuItem = new Intent("android.settings.SETTINGS");
      paramMenuItem.setFlags(270532608);
      paramMenuItem.addCategory("android.intent.category.LAUNCHER");
      startActivity(paramMenuItem);
      return true;
    case 2131689726: 
      onClickonlineHelp();
      return true;
    case 2131689706: 
      paramMenuItem = this.mHomeView.getWorkspace();
      if (paramMenuItem != null) {
        paramMenuItem.exitWidgetResizeMode();
      }
      if (this.mMenuView.isVisible()) {}
      for (long l = -102L;; l = -100L)
      {
        if (!this.mMenuView.isVisible()) {
          this.isFolderCreatedFromMenuButton = true;
        }
        CreateFolderDialog.createAndShow(getFragmentManager(), null, -1L, l, false, true, -1, -1);
        return true;
      }
    case 2131689707: 
      this.mMenuView.changeState(MenuAppsGrid.State.REMOVE_FOLDER);
      return true;
    case 2131689705: 
      showAllApps();
      if (shouldToastRepeat()) {
        AddAppsWidgetToastPopUp.createAndShow(getFragmentManager());
      }
      for (;;)
      {
        return true;
        Toast.makeText(getApplicationContext(), 2131755040, 0).show();
      }
    case 2131689708: 
      launchOptionWallpaper();
      return true;
    case 2131689711: 
      paramMenuItem = new Intent();
      paramMenuItem.setClassName("com.samsung.android.app.galaxyfinder", "com.samsung.android.app.galaxyfinder.GalaxyFinderActivity");
      paramMenuItem.putExtra("componentname", new ComponentName("com.sec.android.app.launcher", "com.sec.android.app.launcher.Launcher").toString());
      paramMenuItem.putExtra("callername", 2);
      startActivitySafely(paramMenuItem, null);
      return true;
    case 2131689724: 
      if (CSCFEATURE_LAUNCHER_USM_EXISTS)
      {
        paramMenuItem = new Intent("android.intent.action.MAIN");
        paramMenuItem.setFlags(270532608);
        paramMenuItem.addCategory("android.intent.category.USM_HOME");
        startActivity(paramMenuItem);
      }
      return true;
    }
    if (CSCFEATURE_LAUNCHER_THEME_ENABLE) {
      startActivity(new Intent("com.sec.android.intent.action.THEME_CHOOSER"));
    }
    return true;
  }
  
  public void onOptionsMenuClosed(Menu paramMenu)
  {
    super.onOptionsMenuClosed(paramMenu);
    invalidateOptionsMenu();
    sHwPopupMenuShowing = false;
  }
  
  public void onPause()
  {
    if (DEBUGGABLE) {
      Log.d("Launcher", "onPause, Launcher: " + System.identityHashCode(this));
    }
    this.mHomeView.onPause();
    super.onPause();
    this.mPaused = true;
    this.mResumed = false;
    setSystemUiTransparency(false);
    if (!isHelpAppRunning) {
      exitWidgetResizeMode();
    }
    closePopupMenu();
    Intent localIntent = new Intent();
    localIntent.setAction("com.sec.android.intent.action.HOME_PAUSE");
    sendBroadcast(localIntent);
    GyroForShadow.pauseSensor();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    super.onPrepareOptionsMenu(paramMenu);
    if ((this.mHomeView.getQuickViewWorkspace().isOpened()) && (!this.mMenuView.isCurrentTabWidgets())) {}
    label266:
    for (;;)
    {
      return false;
      if ((!isHelpAppRunning) && ((!CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) || (!isHomeEditMode())))
      {
        Object localObject;
        if (this.mHomeView.isVisible())
        {
          localObject = this.mHomeView.getWorkspace();
          if (localObject != null)
          {
            localObject = ((Workspace)localObject).getOpenFolder();
            if (localObject != null)
            {
              if ((((Folder)localObject).isEditingName()) || (!((Folder)localObject).isFolderOpenAnimationEnded()) || (((Folder)localObject).mFolderAnimator.isAnimating())) {
                continue;
              }
              ((Folder)localObject).close(false, false);
            }
          }
        }
        for (;;)
        {
          if ((this.mTransitioningToAllApps == true) || (this.mExitingAllApps == true)) {
            break label266;
          }
          setMarketLabel();
          boolean bool = true;
          if (this.mHasMenuKey) {
            bool = setupOptionsMenu(paramMenu);
          }
          sHwPopupMenuShowing = bool;
          return bool;
          if (this.mMenuView.isCurrentTabWidgets())
          {
            localObject = this.mMenuView.getMenuWidgets();
            if ((localObject != null) && (((MenuWidgets)localObject).getWidgetState() != MenuWidgets.WidgetState.NORMAL)) {
              return false;
            }
          }
          else
          {
            if ((this.mMenuView.getState() != MenuAppsGrid.State.NORMAL) && (this.mMenuView.getState() != MenuAppsGrid.State.DOWNLOADED_APPS)) {
              break;
            }
            if (this.mMenuView.getState() == MenuAppsGrid.State.NORMAL)
            {
              localObject = this.mMenuView.getMenuAppsGrid();
              if (localObject != null)
              {
                localObject = ((MenuAppsGrid)localObject).getOpenFolder();
                if (localObject != null)
                {
                  if ((((Folder)localObject).isEditingName()) || (!((Folder)localObject).isFolderOpenAnimationEnded())) {
                    break;
                  }
                  ((Folder)localObject).close(false, false);
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void onRestart()
  {
    isHelpIntentFired = isHelpAppRunning;
    Log.d("Launcher", "onRestart, Launcher: " + System.identityHashCode(this));
    if ((isHelpAppRunning) && (GuideFragment.GMode.equals("change_wallpaper")) && (isExitingFromWallpaperActivity))
    {
      isExitingFromWallpaperActivity = false;
      onBackPressed();
    }
    sIsStopped = false;
    super.onRestart();
  }
  
  public void onResume()
  {
    isHelpIntentFired = isHelpAppRunning;
    Log.d("Launcher", "onResume, Launcher: " + System.identityHashCode(this));
    super.onResume();
    this.mResumed = true;
    this.mPaused = false;
    Settings.System.putInt(getContentResolver(), "kids_home_mode", 0);
    this.mHomeView.onResume();
    clearTypedText();
    setSystemUiTransparency(true);
    Utilities.broadcastStkIntent(this);
    if ((this.mRestoring) || (this.mOnResumeNeedsLoad))
    {
      this.mModel.startLoader(sIsSecretModeOn);
      this.mRestoring = false;
      if (this.mOnResumeNeedsLoad)
      {
        this.mSamsungWidgetPackageManager.loadIfNeeded();
        this.mOnResumeNeedsLoad = false;
      }
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.android.launcher.action.HOME_MODE_CHANGE");
    ((Intent)localObject).putExtra("currentMode", "twlauncher");
    sendBroadcast((Intent)localObject);
    localObject = getIntent().getStringExtra("sec.android.intent.extra.LAUNCHER_ACTION");
    if (localObject != null)
    {
      if (((String)localObject).equals("com.android.launcher2.ALL_APPS"))
      {
        if ((!this.mMenuView.isVisible()) && (!this.mTransitioningToAllApps))
        {
          this.mMenuView.selectAppsTab();
          showAllApps();
        }
      }
      else {
        getIntent().removeExtra("sec.android.intent.extra.LAUNCHER_ACTION");
      }
    }
    else
    {
      if (!isKnoxLauncher()) {
        break label478;
      }
      if (DEBUGGABLE) {
        Log.i("Launcher", "Resumed Type : Knox Launcher");
      }
    }
    for (;;)
    {
      this.mHomeView.mHomeKeyPress = false;
      sHwPopupMenuShowing = false;
      Talk.INSTANCE.onResume();
      if (DEBUGGABLE)
      {
        localObject = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        Log.i("Launcher", "Resumed Orientation : " + getResources().getConfiguration().orientation);
        Log.i("Launcher", "Resumed small width : " + getResources().getConfiguration().smallestScreenWidthDp);
        Log.i("Launcher", "Resumed density : " + ((DisplayMetrics)localObject).densityDpi);
      }
      addAnyPendingWidgetsToWorkspace();
      GyroForShadow.resumeSensor();
      localObject = this.mHomeView.getWorkspace();
      if (localObject != null)
      {
        ((Workspace)localObject).removeHoverScrollHandler();
        if ((this.mHomeView.getVisibility() == 0) && (!((Workspace)localObject).isQuickViewWorkspaceOpend()) && (((Workspace)localObject).getBackgroundDarken() > 0.0F) && (!((Workspace)localObject).getIsDragOccuring())) {
          ((Workspace)localObject).setBackgroundDarken(0.0F);
        }
      }
      return;
      if ((!this.mMenuView.isVisible()) || (!this.mMenuView.isCurrentTabWidgets())) {
        break;
      }
      this.mMenuView.selectAppsTab();
      break;
      label478:
      localObject = new Intent();
      ((Intent)localObject).setAction("com.sec.android.intent.action.HOME_RESUME");
      sendBroadcast((Intent)localObject);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (!this.mHomeView.isVisible()) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("extra_home_view_hidden", bool);
      super.onSaveInstanceState(paramBundle);
      return;
    }
  }
  
  public boolean onSearchRequested()
  {
    startSearch(null, false, null, true);
    overridePendingTransition(2130968579, 2130968580);
    return true;
  }
  
  public void onServiceConnected()
  {
    this.mGestureServiceConnected = true;
  }
  
  public void onServiceDisconnected()
  {
    this.mGestureServiceConnected = false;
  }
  
  protected void onStart()
  {
    Log.d("Launcher", "onStart, Launcher: " + System.identityHashCode(this));
    sIsStopped = false;
    super.onStart();
    this.mHomeView.onStart();
  }
  
  protected void onStop()
  {
    if (DEBUGGABLE) {
      Log.d("Launcher", "onStop, Launcher: " + System.identityHashCode(this));
    }
    if ((isHelpAppRunning) && ((GuideFragment.isWrongActionDialogVisible) || (("resize_widgets".equals(GuideFragment.GMode)) && (GuideFragment.sHelpHubStepNumber >= 2))))
    {
      GuideFragment.removeWrongActionDialog();
      exitHelp(false);
    }
    this.mHomeView.onStop();
    sIsStopped = true;
    this.mResumed = false;
    super.onStop();
    if ((Process.getThreadPriority(Process.myTid()) == -4) && (UseLauncherHighPriority)) {
      Process.setThreadPriority(0);
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    Log.d("Launcher", "onTrimMemory. Level: " + paramInt);
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while ((!"ALTIUS".equals("HERA")) || (this.mHomeView == null) || (this.mHomeView.getWorkspace() == null));
    if (DEBUGGABLE) {
      Log.d("Launcher", "Restarting SurfaceWidgets from onTrimMemory: ");
    }
    this.mHomeView.getWorkspace().restartSurfaceWidgets();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.mPaused)) {
      setSystemUiTransparency(true);
    }
  }
  
  public void registerForAirMotionGestureListner()
  {
    if ((FloatingFeature.getInstance().getEnableStatus("SEC_FLOATING_FEATURE_COMMON_GESTURE_WITH_IRSENSOR")) && (this.mGestureServiceConnected) && (bSupportAirMove) && (!this.mGestureListenerRegistered))
    {
      this.mGestureManager.registerListener(this, "ir_provider", "air_motion_item_move", false);
      this.mGestureListenerRegistered = true;
    }
  }
  
  public void removeStateAnimatorProvider(StateAnimatorProvider paramStateAnimatorProvider)
  {
    this.mStateAnimatorProviders.remove(paramStateAnimatorProvider);
  }
  
  public boolean restorePopupMenu()
  {
    if (sPopupMenuShowing)
    {
      if (this.mPopupMenu == null)
      {
        if (this.mMenuView.getState() != MenuAppsGrid.State.DOWNLOADED_APPS) {
          break label49;
        }
        createPopupMenu(this.mMenuView.findViewById(2131689634));
      }
      for (;;)
      {
        this.mPopupMenu.show();
        return true;
        label49:
        createPopupMenu(this.mMenuView.findViewById(2131689653));
      }
    }
    return false;
  }
  
  public void saveToastPopup(Boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
    localEditor.putBoolean("add.toast.popup.dismissed.key", paramBoolean.booleanValue());
    localEditor.apply();
  }
  
  public void saveToastPopupForDisableDialog(Boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
    localEditor.putBoolean("disable.toast.popup.dismissed.key", paramBoolean.booleanValue());
    localEditor.apply();
  }
  
  public void setEnableHeadlines(boolean paramBoolean)
  {
    if (!sIsMagazineHomeEnable) {
      sIsHeadlinesAppEnable = paramBoolean;
    }
  }
  
  public void setEnableHotWord(boolean paramBoolean)
  {
    if (getHotwordServiceClient() != null)
    {
      if ((!mTalkbackEnable) && (mAlwaysMicOn) && (mIsBabyCryingEnable == 0) && (mIsDoorbellEnable == 0)) {
        getHotwordServiceClient().requestHotwordDetection(paramBoolean);
      }
    }
    else {
      return;
    }
    getHotwordServiceClient().requestHotwordDetection(false);
  }
  
  public void setEnableMenuButton(boolean paramBoolean)
  {
    if (this.mMenuButtonView != null) {
      this.mMenuButtonView.setEnabled(paramBoolean);
    }
  }
  
  public boolean setLoadOnResume()
  {
    if (this.mPaused)
    {
      this.mOnResumeNeedsLoad = true;
      return true;
    }
    if (this.mSamsungWidgetPackageManager != null) {
      this.mSamsungWidgetPackageManager.loadIfNeeded();
    }
    return false;
  }
  
  public void setShowEmptyPageMessagePref(boolean paramBoolean)
  {
    this.mShowEmptyPageMsg = paramBoolean;
  }
  
  void setSystemUiTransparency(boolean paramBoolean)
  {
    this.mStatusBarManager = ((StatusBarManager)getSystemService("statusbar"));
    if (this.mStatusBarManager == null) {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (paramBoolean == true) {}
    for (;;)
    {
      try
      {
        i = Settings.System.getInt(getContentResolver(), "android.wallpaper.settings_systemui_transparency");
        if (i != 0)
        {
          localLayoutParams.flags |= 0x80000000;
          getWindow().getDecorView().setSystemUiVisibility(-1073741825);
          getWindow().getDecorView().setSystemUiVisibility(32768);
          getWindow().setAttributes(localLayoutParams);
          Log.d("Launcher", "Launcher::setSystemUiTransparency(): getSystemUiVisibility() after setting  = " + Integer.toHexString(getWindow().getDecorView().getSystemUiVisibility()));
          return;
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        Log.d("Launcher", "setSystemUiTransparency.SettingNotFoundException : set as TRUE");
        int i = 1;
        continue;
        localLayoutParams.flags &= 0x7FFFFFFF;
        getWindow().getDecorView().setSystemUiVisibility(-32769);
        getWindow().getDecorView().setSystemUiVisibility(1073741824);
        continue;
      }
      localLayoutParams.flags &= 0x7FFFFFFF;
      getWindow().getDecorView().setSystemUiVisibility(-32769);
      getWindow().getDecorView().setSystemUiVisibility(1073741824);
    }
  }
  
  public void setTransitionToAllApps(boolean paramBoolean)
  {
    this.mTransitioningToAllApps = paramBoolean;
  }
  
  public void setWhichTransitionEffect(int paramInt)
  {
    sWhichTransitionEffect = paramInt;
    PagedView.TransitionEffect localTransitionEffect;
    switch (paramInt)
    {
    default: 
      localTransitionEffect = PagedView.TransitionEffect.NONE;
    }
    for (;;)
    {
      Log.d("Launcher", "Setting default transition effect:" + localTransitionEffect);
      if ((this.mHomeView.getWorkspace() != null) && (this.mHomeView.getWorkspace() != null)) {
        this.mHomeView.getWorkspace().setDefaultTransitionEffect(localTransitionEffect);
      }
      return;
      localTransitionEffect = PagedView.TransitionEffect.NONE;
      continue;
      localTransitionEffect = PagedView.TransitionEffect.CARD;
      continue;
      localTransitionEffect = PagedView.TransitionEffect.SPIRAL;
    }
  }
  
  public boolean shouldDisablePopupRepeat()
  {
    boolean bool = false;
    if (!getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getBoolean("disable.toast.popup.dismissed.key", false)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean shouldToastRepeat()
  {
    boolean bool = false;
    if (!getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getBoolean("add.toast.popup.dismissed.key", false)) {
      bool = true;
    }
    return bool;
  }
  
  public void showAllApps()
  {
    if ((this.mTransitionAnimator != null) && (this.mTransitionAnimator.isRunning())) {}
    do
    {
      return;
      this.mHomeView.updateRunning();
      this.mHomeView.getWorkspace().closeFolder();
      this.mHomeView.getWorkspace().onPreShowAllApps();
      if (!HomeScreenOptionMenu.isWidgetTab)
      {
        if (LauncherApplication.isTabletLayout()) {
          this.mMenuView.selectAppsTab();
        }
        this.mHomeView.closeQuickViewWorkspace(true);
      }
      ArrayList localArrayList;
      for (;;)
      {
        exitWidgetResizeMode();
        this.mMenuView.onShowAllApps();
        if (this.mTransitionAnimator != null) {
          this.mTransitionAnimator.cancel();
        }
        localArrayList = new ArrayList();
        localObject = this.mStateAnimatorProviders.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((StateAnimatorProvider)((Iterator)localObject).next()).collectShowAllAppsAnimators(localArrayList);
        }
        if (LauncherApplication.isTabletLayout()) {
          this.mMenuView.selectWidgetsTab();
        }
        HomeScreenOptionMenu.isWidgetTab = false;
      }
      if (this.mMenuView.getState() != MenuAppsGrid.State.EDIT)
      {
        localObject = AnimatorInflater.loadAnimator(this, 2131034118);
        ((Animator)localObject).setTarget(this.mHomeView.getWorkspace());
        localArrayList.add(localObject);
      }
      this.mMenuView.setVisibility(0);
      long l = SHOW_ALL_APPS_TRANSITION_DURATION;
      Object localObject = new AnimatorSet();
      ((AnimatorSet)localObject).playTogether(localArrayList);
      ((AnimatorSet)localObject).setDuration(l);
      ((AnimatorSet)localObject).setInterpolator(new SineInOut90());
      ((AnimatorSet)localObject).addListener(new AnimatorListenerAdapter()
      {
        private boolean mCancelled = false;
        
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          this.mCancelled = true;
          Launcher.this.mInMenu = false;
        }
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if ((!this.mCancelled) && (!Launcher.this.mIsDestroyed)) {
            Launcher.this.finishShowAllApps();
          }
        }
      });
      this.mTransitioningToAllApps = true;
      this.mInMenu = true;
      this.mTransitionAnimator = ((Animator)localObject);
      ((AnimatorSet)localObject).start();
    } while ((!isHelpAppRunning) || (!GuideFragment.GMode.equals("view_all_apps")));
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        GuideFragment.showCompleteDialog(Launcher.this);
      }
    }, 1000L);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, ActivityResultCallback paramActivityResultCallback)
  {
    this.mActivityCallbacks.put(paramInt, paramActivityResultCallback);
    startActivityForResult(paramIntent, paramInt);
  }
  
  boolean startActivitySafely(Intent paramIntent)
  {
    return startActivitySafely(paramIntent, null);
  }
  
  boolean startActivitySafely(Intent paramIntent, Object paramObject)
  {
    return startActivitySafely(null, paramIntent, paramObject);
  }
  
  /* Error */
  boolean startActivitySafely(View paramView, Intent paramIntent, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 3208
    //   4: invokevirtual 2672	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   7: pop
    //   8: aload_2
    //   9: invokevirtual 3658	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   12: ifnull +27 -> 39
    //   15: new 3660	android/os/DVFSHelper
    //   18: dup
    //   19: aload_0
    //   20: bipush 12
    //   22: invokespecial 3661	android/os/DVFSHelper:<init>	(Landroid/content/Context;I)V
    //   25: aload_0
    //   26: invokevirtual 1170	com/android/launcher2/Launcher:getApplicationContext	()Landroid/content/Context;
    //   29: aload_2
    //   30: invokevirtual 3658	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   33: invokevirtual 3664	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   36: invokevirtual 3668	android/os/DVFSHelper:onAppLaunchEvent	(Landroid/content/Context;Ljava/lang/String;)V
    //   39: aload_2
    //   40: invokevirtual 3061	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   43: astore 7
    //   45: aconst_null
    //   46: astore 6
    //   48: aload 6
    //   50: astore 5
    //   52: aload 7
    //   54: ifnull +63 -> 117
    //   57: getstatic 316	com/android/launcher2/Launcher:DEBUGGABLE	Z
    //   60: ifeq +30 -> 90
    //   63: ldc -102
    //   65: new 533	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 534	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 3670
    //   75: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload 7
    //   80: invokevirtual 809	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 553	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 559	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   89: pop
    //   90: aload 7
    //   92: ldc_w 3672
    //   95: invokevirtual 3674	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore 7
    //   100: aload 6
    //   102: astore 5
    //   104: aload 7
    //   106: ifnull +11 -> 117
    //   109: aload 7
    //   111: iconst_0
    //   112: invokestatic 3677	android/content/Intent:parseUri	(Ljava/lang/String;I)Landroid/content/Intent;
    //   115: astore 5
    //   117: aload 5
    //   119: ifnull +153 -> 272
    //   122: aload_0
    //   123: aload 5
    //   125: invokevirtual 2786	com/android/launcher2/Launcher:sendBroadcast	(Landroid/content/Intent;)V
    //   128: goto +309 -> 437
    //   131: astore 5
    //   133: ldc -102
    //   135: ldc_w 3679
    //   138: invokestatic 812	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   141: pop
    //   142: aload 6
    //   144: astore 5
    //   146: goto -29 -> 117
    //   149: astore_1
    //   150: aload_2
    //   151: invokevirtual 3658	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   154: astore 6
    //   156: aload 6
    //   158: ifnull +58 -> 216
    //   161: new 1048	android/content/Intent
    //   164: dup
    //   165: ldc_w 3681
    //   168: invokespecial 1051	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   171: astore 5
    //   173: aload 6
    //   175: invokevirtual 3682	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   178: astore 6
    //   180: aload 5
    //   182: new 533	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 534	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 3684
    //   192: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 6
    //   197: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 553	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 493	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   206: invokevirtual 3688	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   209: pop
    //   210: aload_0
    //   211: aload 5
    //   213: invokevirtual 2377	com/android/launcher2/Launcher:startActivity	(Landroid/content/Intent;)V
    //   216: aload_0
    //   217: ldc_w 2673
    //   220: iconst_0
    //   221: invokestatic 2430	android/widget/Toast:makeText	(Landroid/content/Context;II)Landroid/widget/Toast;
    //   224: invokevirtual 1752	android/widget/Toast:show	()V
    //   227: getstatic 316	com/android/launcher2/Launcher:DEBUGGABLE	Z
    //   230: ifeq +40 -> 270
    //   233: ldc -102
    //   235: new 533	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 534	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 3690
    //   245: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_3
    //   249: invokevirtual 809	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   252: ldc_w 2687
    //   255: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_2
    //   259: invokevirtual 809	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 553	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: aload_1
    //   266: invokestatic 1035	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   269: pop
    //   270: iconst_0
    //   271: ireturn
    //   272: aload_1
    //   273: ifnull +127 -> 400
    //   276: iconst_1
    //   277: istore 4
    //   279: iload 4
    //   281: ifeq +143 -> 424
    //   284: getstatic 3695	android/os/Build$VERSION:SDK_INT	I
    //   287: bipush 21
    //   289: if_icmplt +117 -> 406
    //   292: aload_0
    //   293: ldc_w 3696
    //   296: ldc_w 3697
    //   299: invokestatic 3703	android/app/ActivityOptions:makeCustomAnimation	(Landroid/content/Context;II)Landroid/app/ActivityOptions;
    //   302: astore_1
    //   303: aload_1
    //   304: invokevirtual 3706	android/app/ActivityOptions:toBundle	()Landroid/os/Bundle;
    //   307: pop
    //   308: aload_0
    //   309: aload_2
    //   310: aload_1
    //   311: invokevirtual 3706	android/app/ActivityOptions:toBundle	()Landroid/os/Bundle;
    //   314: invokevirtual 3709	com/android/launcher2/Launcher:startActivity	(Landroid/content/Intent;Landroid/os/Bundle;)V
    //   317: goto +120 -> 437
    //   320: astore_1
    //   321: aload_0
    //   322: ldc_w 2673
    //   325: iconst_0
    //   326: invokestatic 2430	android/widget/Toast:makeText	(Landroid/content/Context;II)Landroid/widget/Toast;
    //   329: invokevirtual 1752	android/widget/Toast:show	()V
    //   332: getstatic 316	com/android/launcher2/Launcher:DEBUGGABLE	Z
    //   335: ifeq -65 -> 270
    //   338: ldc -102
    //   340: new 533	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 534	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 2677
    //   350: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_2
    //   354: invokevirtual 809	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   357: ldc_w 2679
    //   360: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: ldc_w 2681
    //   366: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc_w 2683
    //   372: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_3
    //   376: invokevirtual 809	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   379: ldc_w 2687
    //   382: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload_2
    //   386: invokevirtual 809	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 553	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: aload_1
    //   393: invokestatic 1035	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   396: pop
    //   397: goto -127 -> 270
    //   400: iconst_0
    //   401: istore 4
    //   403: goto -124 -> 279
    //   406: aload_1
    //   407: iconst_0
    //   408: iconst_0
    //   409: aload_1
    //   410: invokevirtual 3712	android/view/View:getMeasuredWidth	()I
    //   413: aload_1
    //   414: invokevirtual 3715	android/view/View:getMeasuredHeight	()I
    //   417: invokestatic 3719	android/app/ActivityOptions:makeScaleUpAnimation	(Landroid/view/View;IIII)Landroid/app/ActivityOptions;
    //   420: astore_1
    //   421: goto -118 -> 303
    //   424: aload_0
    //   425: aload_2
    //   426: invokevirtual 2377	com/android/launcher2/Launcher:startActivity	(Landroid/content/Intent;)V
    //   429: goto +8 -> 437
    //   432: astore 5
    //   434: goto -218 -> 216
    //   437: iconst_1
    //   438: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	this	Launcher
    //   0	439	1	paramView	View
    //   0	439	2	paramIntent	Intent
    //   0	439	3	paramObject	Object
    //   277	125	4	i	int
    //   50	74	5	localObject1	Object
    //   131	1	5	localURISyntaxException	java.net.URISyntaxException
    //   144	68	5	localObject2	Object
    //   432	1	5	localActivityNotFoundException	ActivityNotFoundException
    //   46	150	6	localObject3	Object
    //   43	67	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   109	117	131	java/net/URISyntaxException
    //   8	39	149	android/content/ActivityNotFoundException
    //   39	45	149	android/content/ActivityNotFoundException
    //   57	90	149	android/content/ActivityNotFoundException
    //   90	100	149	android/content/ActivityNotFoundException
    //   109	117	149	android/content/ActivityNotFoundException
    //   122	128	149	android/content/ActivityNotFoundException
    //   133	142	149	android/content/ActivityNotFoundException
    //   284	303	149	android/content/ActivityNotFoundException
    //   303	317	149	android/content/ActivityNotFoundException
    //   406	421	149	android/content/ActivityNotFoundException
    //   424	429	149	android/content/ActivityNotFoundException
    //   8	39	320	java/lang/SecurityException
    //   39	45	320	java/lang/SecurityException
    //   57	90	320	java/lang/SecurityException
    //   90	100	320	java/lang/SecurityException
    //   109	117	320	java/lang/SecurityException
    //   122	128	320	java/lang/SecurityException
    //   133	142	320	java/lang/SecurityException
    //   284	303	320	java/lang/SecurityException
    //   303	317	320	java/lang/SecurityException
    //   406	421	320	java/lang/SecurityException
    //   424	429	320	java/lang/SecurityException
    //   161	216	432	android/content/ActivityNotFoundException
  }
  
  public void startActivityWithTransition(Intent paramIntent)
  {
    paramIntent.putExtra("from_right", false);
    startActivitySafely(paramIntent);
    overridePendingTransition(2130968576, 2130968578);
  }
  
  public void startActivityWithTransitionForHeadlines(Intent paramIntent, boolean paramBoolean)
  {
    paramIntent.setFlags(807403520);
    try
    {
      if (paramIntent.getComponent() != null) {
        new DVFSHelper(this, 12).onAppLaunchEvent(getApplicationContext(), paramIntent.getComponent().getClassName());
      }
      if (paramBoolean) {}
      for (ActivityOptions localActivityOptions = ActivityOptions.makeCustomAnimation(this, 2130968581, 2130968584);; localActivityOptions = ActivityOptions.makeCustomAnimation(this, 2130968582, 2130968583))
      {
        startActivity(paramIntent, localActivityOptions.toBundle());
        return;
      }
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Toast.makeText(this, 2131755010, 0).show();
      if (DEBUGGABLE)
      {
        Log.e("Launcher", "Unable to launch. intent=" + paramIntent, localActivityNotFoundException);
        return;
      }
    }
    catch (SecurityException localSecurityException)
    {
      Toast.makeText(this, 2131755010, 0).show();
      if (DEBUGGABLE) {
        Log.e("Launcher", "Launcher does not have the permission to launch " + paramIntent + ". Make sure to create a MAIN intent-filter for the corresponding activity " + "or use the exported attribute for this activity. " + " intent=" + paramIntent, localSecurityException);
      }
    }
  }
  
  public void startMagazineApp(boolean paramBoolean)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setClassName("sstream.app", "sstream.app.activities.StreamActivity");
      localIntent.setFlags(270532608);
      startActivitySafely(localIntent, null);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Log.e("Launcher", "S Stream Activity not found");
    }
  }
  
  public void startSearch(String paramString, boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2)
  {
    String str = paramString;
    if (paramString == null) {
      str = getTypedText();
    }
    paramString = paramBundle;
    if (paramBundle == null)
    {
      paramString = new Bundle();
      paramString.putString("source", "launcher-search");
    }
    ((SearchManager)getSystemService("search")).startSearch(str, paramBoolean1, getComponentName(), paramString, paramBoolean2);
  }
  
  public void unRegisterAirMotionGestureListner()
  {
    if ((FloatingFeature.getInstance().getEnableStatus("SEC_FLOATING_FEATURE_COMMON_GESTURE_WITH_IRSENSOR")) && (this.mGestureServiceConnected) && (bSupportAirMove) && (this.mGestureListenerRegistered == true))
    {
      this.mGestureManager.unregisterListener(this, "ir_provider");
      this.mGestureListenerRegistered = false;
    }
  }
  
  public void uninstallPackage(String paramString)
  {
    startActivityForResult(new Intent("android.intent.action.UNINSTALL_PACKAGE", Uri.parse("package:" + paramString)), 111);
  }
  
  public void updateMotionGestureListner(MenuAppsGrid.State paramState1, MenuAppsGrid.State paramState2)
  {
    if ((isAirMoveOninSettings()) && (bSupportAirMove))
    {
      if ((paramState2 != MenuAppsGrid.State.NORMAL) || (paramState1 != MenuAppsGrid.State.EDIT)) {
        break label32;
      }
      registerForAirMotionGestureListner();
    }
    label32:
    while ((paramState2 != MenuAppsGrid.State.EDIT) || (paramState1 != MenuAppsGrid.State.NORMAL)) {
      return;
    }
    unRegisterAirMotionGestureListner();
  }
  
  public void updateMotionGestureListner(Workspace.State paramState1, Workspace.State paramState2)
  {
    if ((isAirMoveOninSettings()) && (bSupportAirMove))
    {
      if (((paramState2 != Workspace.State.NORMAL) && (paramState2 != Workspace.State.RESIZE)) || (paramState1 != Workspace.State.EDIT)) {
        break label39;
      }
      registerForAirMotionGestureListner();
    }
    label39:
    while ((paramState2 != Workspace.State.EDIT) || ((paramState1 != Workspace.State.NORMAL) && (paramState1 != Workspace.State.RESIZE))) {
      return;
    }
    unRegisterAirMotionGestureListner();
  }
  
  public static abstract interface ActivityResultCallback
  {
    public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  }
  
  private class AirGestureSettingsChangeReceiver
    extends BroadcastReceiver
  {
    public static final String AIR_MOTION_CHANGE = "com.sec.gesture.AIR_MOTION_SETTINGS_CHANGED";
    public static final String AIR_MOVE_CHANGE = "com.sec.gesture.AIR_MOVE_SETTINGS_CHANGED";
    
    private AirGestureSettingsChangeReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (Launcher.DEBUGGABLE) {
        Log.d("Launcher", "AirGestureSettingsChangeReceiver: onReceive - " + paramIntent.getAction() + " isEnable : " + paramIntent.getBooleanExtra("isEnable", false));
      }
      Launcher.this.bindAndUnBindGestureService();
    }
  }
  
  private class AlwaysMicOnObserver
    extends ContentObserver
  {
    public AlwaysMicOnObserver()
    {
      super();
    }
    
    public void onChange(boolean paramBoolean)
    {
      Cursor localCursor = Launcher.this.getContentResolver().query(Launcher.this.content_uri, null, null, null, null);
      if (localCursor != null)
      {
        while (localCursor.moveToNext()) {
          if (localCursor.getString(localCursor.getColumnIndex("isDSPEnabled")).equals("true")) {
            Launcher.mAlwaysMicOn = false;
          } else {
            Launcher.mAlwaysMicOn = true;
          }
        }
        localCursor.close();
        return;
      }
      Launcher.mAlwaysMicOn = true;
    }
  }
  
  private class CloseSystemDialogsIntentReceiver
    extends BroadcastReceiver
  {
    private CloseSystemDialogsIntentReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (Launcher.this.mHomeView.mHomeKeyPress) {
        Launcher.this.mHomeView.closeSystemDialogs(Boolean.valueOf(true));
      }
      for (;;)
      {
        Launcher.this.mHomeView.cancelRemovePage();
        return;
        Launcher.this.mHomeView.closeSystemDialogs(Boolean.valueOf(false));
      }
    }
  }
  
  static abstract interface HardwareKeys
  {
    public abstract boolean onBackPressed();
    
    public abstract boolean onHomePressed(boolean paramBoolean);
  }
  
  public static abstract interface StateAnimatorProvider
  {
    public abstract void collectExitAllAppsAnimators(ArrayList<Animator> paramArrayList);
    
    public abstract void collectShowAllAppsAnimators(ArrayList<Animator> paramArrayList);
  }
  
  private class TalkbackEnableIntentReceiver
    extends BroadcastReceiver
  {
    private TalkbackEnableIntentReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      boolean bool = Talk.INSTANCE.checkTalkbackEnabled();
      if (Launcher.mTalkbackEnable != bool)
      {
        Launcher.mTalkbackEnable = bool;
        if ((Launcher.mTalkbackEnable) || (!Launcher.this.mHomeView.isVisible()) || (Launcher.this.mHomeView.getQuickViewWorkspace().isOpened())) {
          break label88;
        }
        paramContext = Launcher.this.mHomeView.getWorkspace();
        if ((paramContext != null) && (paramContext.isGoogleSearchWidget(paramContext.getCurrentPage()))) {
          Launcher.this.setEnableHotWord(true);
        }
      }
      return;
      label88:
      Launcher.this.setEnableHotWord(false);
    }
  }
  
  private static class WidgetAddInfo
  {
    public boolean mAllowDuplicate;
    public ComponentName mComponentName;
    public int mSizeX = -1;
    public int mSizeY = -1;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/Launcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */