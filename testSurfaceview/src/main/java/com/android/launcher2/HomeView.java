package com.android.launcher2;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.FragmentManager;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.ContentObserver;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.DVFSHelper;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.Settings.System;
import android.text.method.TextKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Advanceable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HoverPopupWindow;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.launcher2.guide.AddAppsGuider;
import com.android.launcher2.guide.AddWidgetsGuider;
import com.android.launcher2.guide.ChangeWallpaperGuider;
import com.android.launcher2.guide.GuideFragment;
import com.android.launcher2.guide.HelpAnimatedDialog;
import com.android.launcher2.guide.MoveAppsGuider;
import com.android.launcher2.guide.RemoveItemsGuider;
import com.android.launcher2.guide.ResizeWidgetsGuider;
import com.samsung.surfacewidget.SurfaceWidgetProviderInfo;
import com.sec.android.app.CscFeature;
import com.sec.dtl.launcher.Talk;
import com.sec.dtl.launcher.WallpaperScroller;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class HomeView
  extends FrameLayout
  implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, PagedView.PageSwitchListener, Launcher.HardwareKeys, Launcher.StateAnimatorProvider, Animator.AnimatorListener, QuickViewWorkspace.WorkspaceQuickViewInfoProvider, CreateFolderDialog.CreateFolderInterface, LifeCycle, Launcher.ActivityResultCallback
{
  static final int APPWIDGET_HOST_ID = 1024;
  public static final String CHOOSER_MODE = "mode";
  private static final boolean DEBUGGABLE = ;
  static final boolean DEBUG_WIDGETS = false;
  static final String EXTRA_SHORTCUT_DUPLICATE = "duplicate";
  static final boolean LOGD = false;
  private static final Uri MAGAZINE_CONTENT_URI;
  private static final float MAGAZINE_FLICK_UP_MAX_DEGREE = 20.0F;
  static final int MENU_GROUP_WALLPAPER = 1;
  static final int MENU_HELP = 5;
  static final int MENU_MANAGE_APPS = 3;
  static final int MENU_SYSTEM_SETTINGS = 4;
  static final int MENU_WALLPAPER_SETTINGS = 2;
  private static final String OPEN_FOLDER_ID = "launcher.workspace_open_folder_id";
  private static final String PENDING_FOLDER_EDIT_TEXT = "launcher.workspace_pending_folder_edit_text";
  private static final String PENDING_FOLDER_EDIT_TEXT_SELECTION_END = "launcher.workspace_pending_folder_edit_text_selection_end";
  private static final String PENDING_FOLDER_EDIT_TEXT_SELECTION_START = "launcher.workspace_pending_folder_edit_text_selection_start";
  static final boolean PROFILE_STARTUP = false;
  static final int REQUEST_CREATE_APPWIDGET = 5;
  static final int REQUEST_CREATE_NEW_FOLDER_WITH_SHORTCUT_ITEM = 2;
  static final int REQUEST_CREATE_SHORTCUT = 1;
  static final int REQUEST_PICK_APPWIDGET = 9;
  static final int REQUEST_PICK_SHORTCUT = 7;
  static final int REQUEST_PICK_WALLPAPER = 10;
  public static final int RESPONSE_CODE_SHOW_WIDGETS = -10000;
  private static final String TAG = "Launcher.HomeView";
  private static final String TOOLBAR_ICON_METADATA_NAME = "com.android.launcher.toolbar_icon";
  static final int WIDGET_BACKGROUND = 16777216;
  private static DVFSHelper cpuBooster = null;
  static long mDestinationNewFolderId = 0L;
  static boolean mIsAllAppsButtonDisable = false;
  private static int sCurrentRotationAngle = 0;
  static final ArrayList<String> sDumpLogs;
  static HashMap<Long, HomeFolderItem> sFolders;
  public static boolean sIsBindHotseat = false;
  static boolean sIsDragState = false;
  static PanelDrawer sPanelDrawer;
  private static ArrayList<PendingAddArguments> sPendingAddList;
  private static PointF sTouchPt;
  private static final int sTransitionInDuration = 200;
  private static final int sTransitionOutDuration = 175;
  private final int ADVANCE_MSG = 1;
  private View.OnClickListener MyFilesButtonClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (!Launcher.isHelpAppRunning) {}
      try
      {
        paramAnonymousView = new Intent("android.intent.action.MAIN");
        paramAnonymousView.setFlags(270532608);
        paramAnonymousView.setComponent(new ComponentName("com.sec.android.app.myfiles", "com.sec.android.app.myfiles.MainActivity"));
        HomeView.this.getContext().startActivity(paramAnonymousView);
        return;
      }
      catch (ActivityNotFoundException paramAnonymousView)
      {
        Log.e("Launcher.HomeView", "MyFiles activity not found  " + paramAnonymousView);
      }
    }
  };
  private final int REMOVE_MARKETSAMPLE = 3;
  private final int SHOW_MARKETSAMPLE = 2;
  private View.OnClickListener SearchButtonClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (!HomeView.this.removeHotseat) {}
      while (Launcher.isHelpAppRunning) {
        return;
      }
      try
      {
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName("com.google.android.googlequicksearchbox", "com.google.android.googlequicksearchbox.SearchActivity");
        HomeView.this.getContext().startActivity(paramAnonymousView);
        return;
      }
      catch (ActivityNotFoundException paramAnonymousView)
      {
        Log.e("Launcher.HomeView", "Google search activity not found  " + paramAnonymousView);
      }
    }
  };
  private View.OnClickListener VoiceSearchButtonClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (!HomeView.this.removeHotseat) {}
      while (Launcher.isHelpAppRunning) {
        return;
      }
      try
      {
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName("com.google.android.googlequicksearchbox", "com.google.android.googlequicksearchbox.VoiceSearchActivity");
        HomeView.this.getContext().startActivity(paramAnonymousView);
        return;
      }
      catch (ActivityNotFoundException paramAnonymousView)
      {
        Log.i("Launcher.HomeView", "Google Voice Search Activity Not Found " + paramAnonymousView);
      }
    }
  };
  public boolean isHelpAppPageAdded = false;
  public boolean isHelpAppPageDeleted = true;
  private final int mAdvanceInterval = 20000;
  private final int mAdvanceStagger = 250;
  private boolean mAfterSavedInstanceState = false;
  private View.OnTouchListener mAllAppsIconTouchListener = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      int i = paramAnonymousMotionEvent.getAction();
      HomeView.cpuBooster.addExtraOptionsByDefaultPolicy("Launcher_touch");
      if (i == 0) {
        HomeView.cpuBooster.acquire("Launcher_touch");
      }
      if (i == 1) {
        HomeView.cpuBooster.release();
      }
      return false;
    }
  };
  private AppWidgetBinder mAppWidgetBinder;
  private LauncherAppWidgetHost mAppWidgetHost;
  private AppWidgetManager mAppWidgetManager;
  private boolean mAutoAdvanceRunning = false;
  private long mAutoAdvanceSentTime;
  private long mAutoAdvanceTimeLeft = -1L;
  private ImageView mCameraCut;
  private final ContentObserver mChangeTphoneModeObserver = new ContentObserver(this.mHandler)
  {
    public void onChange(boolean paramAnonymousBoolean)
    {
      HomeView.this.ChangeTphoneMode();
    }
  };
  private int mCreateFolderColor = 0;
  private BaseItem mCurrentDragItem;
  private BaseItem mCurrentResizeWidgetItem = null;
  private View.OnTouchListener mDarkenLayerTouchListener = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if (HomeView.this.mWorkspace != null) {
        HomeView.this.mWorkspace.closeFolder();
      }
      return true;
    }
  };
  private View mDarkenView;
  private QuickViewDragBar mDeleteDropLayout;
  private float mDownMotionX;
  private float mDownMotionY;
  private HomeEditBar mEditBar;
  private View mEditIcon = null;
  private View mEditIconDivider;
  private Bundle mFolderBundle;
  private View mGoogleSearchView;
  private final Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 1)
      {
        int i = 0;
        paramAnonymousMessage = HomeView.this.mWidgetsToAdvance.keySet().iterator();
        while (paramAnonymousMessage.hasNext())
        {
          final View localView = (View)paramAnonymousMessage.next();
          localView = localView.findViewById(((AppWidgetProviderInfo)HomeView.this.mWidgetsToAdvance.get(localView)).autoAdvanceViewId);
          if ((localView instanceof Advanceable)) {
            postDelayed(new Runnable()
            {
              public void run()
              {
                if ((localView instanceof Advanceable)) {
                  ((Advanceable)localView).advance();
                }
              }
            }, i * 250);
          }
          i += 1;
        }
        HomeView.this.sendAdvanceMessage(20000L);
      }
      do
      {
        do
        {
          return;
          if (paramAnonymousMessage.what != 2) {
            break;
          }
        } while (HomeView.this.mMarketSample == null);
        ((ViewStub)HomeView.this.mMarketSample).setVisibility(0);
        HomeView.this.findViewById(2131689597).setOnTouchListener(HomeView.this.mMarketSampleTouchListener);
        return;
      } while ((paramAnonymousMessage.what != 3) || (HomeView.this.mMarketSample == null));
      ((ViewStub)HomeView.this.mMarketSample).setVisibility(4);
    }
  };
  private final ContentObserver mHelphubObserver = new ContentObserver(new Handler())
  {
    public void onChange(boolean paramAnonymousBoolean) {}
  };
  private View mHomeAppsBtn = null;
  private View mHomeBottomBar;
  private View mHomeContainer;
  private View mHomeDarkenLayer;
  private HomeEditTabClickListener mHomeEditButtonListener = new HomeEditTabClickListener();
  MenuItem mHomeEditItem = null;
  private ViewGroup mHomeEditTitleBar;
  public boolean mHomeKeyPress = false;
  private View mHomePhoneBtn = null;
  private HomeScreenOptionMenu mHomeScreenOptionMenu;
  private View mHomeSearchBtn;
  private View mHomeTopBar;
  private Hotseat mHotseat;
  private LayoutInflater mInflater;
  private boolean mIsDeletePopup = false;
  public boolean mIsHelpItemAdded = false;
  private boolean mIsStartFlickUp;
  private AnimationDrawable mLightEffectAnimation;
  private ImageView mLightEffectImage;
  private View mMarketSample;
  private View.OnTouchListener mMarketSampleTouchListener = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      return true;
    }
  };
  private LauncherModel mModel;
  private View mMyFilesView;
  private float mPanelBackgroundAlpha = 1.0F;
  private HomeItem mPendingAddInfo = new HomeItem();
  private PkgResCache mPkgResCache;
  private QuickLaunch mQuickLaunch;
  private QuickLaunch mQuickLaunchCamera;
  private QuickViewWorkspace mQuickViewWorkspace;
  private boolean mRestoring;
  private SavedState mSavedState;
  private ShadowBuilder mShadow;
  private WorkspaceSpanCalculator mSpanCalculator;
  private final Runnable mStopLightEffect = new Runnable()
  {
    public void run()
    {
      if ((HomeView.this.mLightEffectAnimation != null) && (HomeView.this.mLightEffectAnimation.isRunning()))
      {
        HomeView.this.mLightEffectAnimation.stop();
        if (HomeView.this.mLightEffectImage != null) {
          HomeView.this.mLightEffectImage.setVisibility(8);
        }
      }
    }
  };
  private long mTargetFolderId = -1L;
  private WallpaperScroller mTiltWallpaperScroller = null;
  private int[] mTmpAddItemCellCoordinates = new int[2];
  private int[] mTmpAddItemSpans = new int[2];
  private VelocityTracker mVelocityTracker;
  private View mVoiceSearchView;
  boolean mWaitingForResult;
  private final ContentObserver mWidgetObserver = new AppWidgetResetObserver();
  private HashMap<View, AppWidgetProviderInfo> mWidgetsToAdvance = new HashMap();
  private Workspace mWorkspace;
  private boolean mWorkspaceLoading = true;
  private boolean removeHotseat = false;
  private boolean sIsHeadlinesHiddenForEditMode = false;
  private int screenIndexBeforeHelpAppPageAddition = -1;
  private int screenIndexFestivalHelpAppPageAddition = -1;
  
  static
  {
    MAGAZINE_CONTENT_URI = Uri.parse("content://sstream.app.provider.StoryProvider");
    sFolders = new HashMap();
    sDumpLogs = new ArrayList();
    sPendingAddList = new ArrayList();
    sPanelDrawer = new PanelDrawer();
    mDestinationNewFolderId = -1L;
    sCurrentRotationAngle = 0;
    sTouchPt = new PointF();
  }
  
  public HomeView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HomeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HomeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = (LauncherApplication)getActivity().getApplication();
    this.mModel = paramContext.getModel();
    this.mPkgResCache = paramContext.getPkgResCache();
    this.mSpanCalculator = paramContext.getSpanCalculator();
    this.mAfterSavedInstanceState = false;
    this.removeHotseat = LauncherApplication.isTabletLayout();
    registerContentObservers();
  }
  
  private void acquireVelocityTrackerAndAddMovement(MotionEvent paramMotionEvent)
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private void addAppWidgetImpl(int paramInt, HomePendingWidget paramHomePendingWidget)
  {
    Object localObject2 = this.mAppWidgetManager.getAppWidgetInfo(paramInt);
    if ((paramHomePendingWidget == null) || (localObject2 == null)) {
      return;
    }
    Object localObject1 = paramHomePendingWidget.getDefSpans();
    Object localObject3 = paramHomePendingWidget.getResizeSpans();
    calcFinalSpan(paramHomePendingWidget, ((AppWidgetProviderInfo)localObject2).resizeMode, (int[])localObject1, (int[])localObject3);
    if (((AppWidgetProviderInfo)localObject2).configure != null)
    {
      localObject1 = new Intent("android.appwidget.action.APPWIDGET_CONFIGURE");
      ((Intent)localObject1).setComponent(((AppWidgetProviderInfo)localObject2).configure);
      ((Intent)localObject1).putExtra("appWidgetId", paramInt);
      Object localObject4;
      if ((paramHomePendingWidget.mimeType != null) && (!paramHomePendingWidget.mimeType.isEmpty()))
      {
        ((Intent)localObject1).putExtra("com.android.launcher.extra.widget.CONFIGURATION_DATA_MIME_TYPE", paramHomePendingWidget.mimeType);
        localObject2 = paramHomePendingWidget.mimeType;
        localObject3 = (ClipData)paramHomePendingWidget.configurationData;
        localObject4 = ((ClipData)localObject3).getDescription();
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < ((ClipDescription)localObject4).getMimeTypeCount())
        {
          if (!((ClipDescription)localObject4).getMimeType(paramInt).equals(localObject2)) {
            break label357;
          }
          localObject4 = ((ClipData)localObject3).getItemAt(paramInt);
          localObject2 = ((ClipData.Item)localObject4).getText();
          localObject3 = ((ClipData.Item)localObject4).getUri();
          localObject4 = ((ClipData.Item)localObject4).getIntent();
          if (localObject3 == null) {
            break label321;
          }
          ((Intent)localObject1).putExtra("com.android.launcher.extra.widget.CONFIGURATION_DATA", (Parcelable)localObject3);
        }
        for (;;)
        {
          localObject2 = ((LauncherApplication)getActivity().getApplication()).getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
          ((SharedPreferences.Editor)localObject2).putInt("tempScreen", paramHomePendingWidget.mScreen);
          ((SharedPreferences.Editor)localObject2).putInt("tempCellX", paramHomePendingWidget.cellX);
          ((SharedPreferences.Editor)localObject2).putInt("tempCellY", paramHomePendingWidget.cellY);
          ((SharedPreferences.Editor)localObject2).putInt("tempSpanX", paramHomePendingWidget.spanX);
          ((SharedPreferences.Editor)localObject2).putInt("tempSpanY", paramHomePendingWidget.spanY);
          ((SharedPreferences.Editor)localObject2).commit();
          copyToPendingAddInfo(paramHomePendingWidget);
          startActivityForResultSafely((Intent)localObject1, 5);
          return;
          label321:
          if (localObject4 != null) {
            ((Intent)localObject1).putExtra("com.android.launcher.extra.widget.CONFIGURATION_DATA", (Parcelable)localObject4);
          } else if (localObject2 != null) {
            ((Intent)localObject1).putExtra("com.android.launcher.extra.widget.CONFIGURATION_DATA", (CharSequence)localObject2);
          }
        }
        label357:
        paramInt += 1;
      }
    }
    completeAddAppWidget(paramInt, paramHomePendingWidget);
  }
  
  private void addMovementVelocityTracker(MotionEvent paramMotionEvent)
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.addMovement(paramMotionEvent);
    }
  }
  
  private boolean addSamsungWidget(HomePendingSamsungWidget paramHomePendingSamsungWidget)
  {
    Object localObject1 = SamsungWidgetPackageManager.INSTANCE;
    Object localObject2 = paramHomePendingSamsungWidget.mInfo;
    localObject1 = ((SamsungWidgetPackageManager)localObject1).createWidget(getActivity(), (SamsungWidgetProviderInfo)localObject2);
    long l = paramHomePendingSamsungWidget.container;
    int k = paramHomePendingSamsungWidget.mScreen;
    CellLayout localCellLayout = getCellLayout(l, k);
    localObject2 = this.mSpanCalculator.getSpanForSamsungWidget(((SamsungWidgetProviderInfo)localObject2).getWidth(1), ((SamsungWidgetProviderInfo)localObject2).getHeight(1), ((SamsungWidgetProviderInfo)localObject2).getWidth(2), ((SamsungWidgetProviderInfo)localObject2).getHeight(2), null);
    calcFinalSpan(paramHomePendingSamsungWidget, 3, (int[])localObject2, new int[] { localObject2[0], localObject2[1], -1, -1 });
    localObject2 = this.mTmpAddItemSpans;
    localObject2[0] = paramHomePendingSamsungWidget.spanX;
    localObject2[1] = paramHomePendingSamsungWidget.spanY;
    int[] arrayOfInt1 = this.mTmpAddItemCellCoordinates;
    int[] arrayOfInt2 = paramHomePendingSamsungWidget.dropPos;
    int j = 0;
    if ((paramHomePendingSamsungWidget.cellX >= 0) && (paramHomePendingSamsungWidget.cellY >= 0))
    {
      arrayOfInt1[0] = paramHomePendingSamsungWidget.cellX;
      arrayOfInt1[1] = paramHomePendingSamsungWidget.cellY;
      i = 1;
    }
    do
    {
      do
      {
        j = k;
        if (i != 0) {
          break;
        }
        paramHomePendingSamsungWidget = new DropPos();
        boolean bool = findEmptySpanOnHomeScreen(arrayOfInt1, k, getActivity(), paramHomePendingSamsungWidget, localObject2[0], localObject2[1], false);
        j = paramHomePendingSamsungWidget.mScreen;
        arrayOfInt1[0] = paramHomePendingSamsungWidget.mCellX;
        arrayOfInt1[1] = paramHomePendingSamsungWidget.mCellY;
        if (!paramHomePendingSamsungWidget.mFoundInCurrentScreen) {
          showOutOfSpaceMessage();
        }
        if (bool) {
          break;
        }
        return false;
        i = j;
      } while (arrayOfInt2 == null);
      i = j;
    } while (localCellLayout == null);
    if (localCellLayout.findNearestVacantArea(arrayOfInt2[0], arrayOfInt2[1], localObject2[0], localObject2[1], arrayOfInt1) != null) {}
    for (int i = 1;; i = 0) {
      break;
    }
    ((SamsungWidgetItem)localObject1).spanX = localObject2[0];
    ((SamsungWidgetItem)localObject1).spanY = localObject2[1];
    LauncherModel.addItemToDatabase(getActivity(), (HomeItem)localObject1, l, j, arrayOfInt1[0], arrayOfInt1[1], false);
    ((SamsungWidgetItem)localObject1).mWidgetView.setTag(localObject1);
    ((SamsungWidgetItem)localObject1).mWidgetView.setBackgroundColor(16777216);
    this.mWorkspace.addItem((HomeItem)localObject1);
    if (this.mWorkspace.getCurrentPage() == j) {
      this.mWorkspace.resumeScreen(j);
    }
    for (;;)
    {
      if ((Launcher.isHelpAppRunning) && ("add_widgets".equals(GuideFragment.GMode)))
      {
        GuideFragment.isGuideCompleted = true;
        Toast.makeText(this.mWorkspace.getContext(), 2131755180, 1).show();
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            GuideFragment.showCompleteDialog(HomeView.this.getActivity());
          }
        }, 2000L);
      }
      return true;
      this.mWorkspace.snapToPage(j);
    }
  }
  
  private boolean addSurfaceWidget(HomePendingSurfaceWidget paramHomePendingSurfaceWidget)
  {
    final SurfaceWidgetItem localSurfaceWidgetItem = new SurfaceWidgetItem();
    Object localObject = paramHomePendingSurfaceWidget.mInfo;
    Log.d("SurfaceWidgetFlow", "making surface widget on drop");
    localSurfaceWidgetItem.makeSurfaceWidget(getActivity(), (SurfaceWidgetProviderInfo)localObject, null, true);
    if (localSurfaceWidgetItem.mWidgetView == null) {
      return true;
    }
    long l = paramHomePendingSurfaceWidget.container;
    int k = paramHomePendingSurfaceWidget.mScreen;
    final CellLayout localCellLayout = getCellLayout(l, k);
    int[] arrayOfInt1 = localSurfaceWidgetItem.getDefSpans();
    int[] arrayOfInt2 = localSurfaceWidgetItem.getResizeSpans();
    calcFinalSpan(paramHomePendingSurfaceWidget, ((SurfaceWidgetProviderInfo)localObject).resizeMode, arrayOfInt1, arrayOfInt2);
    localObject = this.mTmpAddItemSpans;
    localObject[0] = paramHomePendingSurfaceWidget.spanX;
    localObject[1] = paramHomePendingSurfaceWidget.spanY;
    if (DEBUGGABLE) {
      Log.d("Launcher.HomeView", "adding surface width cells wide = " + localObject[0] + " cells tall = " + localObject[1]);
    }
    arrayOfInt1 = this.mTmpAddItemCellCoordinates;
    arrayOfInt2 = paramHomePendingSurfaceWidget.dropPos;
    int j = 0;
    if ((paramHomePendingSurfaceWidget.cellX >= 0) && (paramHomePendingSurfaceWidget.cellY >= 0))
    {
      arrayOfInt1[0] = paramHomePendingSurfaceWidget.cellX;
      arrayOfInt1[1] = paramHomePendingSurfaceWidget.cellY;
      i = 1;
    }
    do
    {
      do
      {
        j = k;
        if (i != 0) {
          break;
        }
        paramHomePendingSurfaceWidget = new DropPos();
        boolean bool = findEmptySpanOnHomeScreen(arrayOfInt1, k, getActivity(), paramHomePendingSurfaceWidget, localObject[0], localObject[1], false);
        j = paramHomePendingSurfaceWidget.mScreen;
        arrayOfInt1[0] = paramHomePendingSurfaceWidget.mCellX;
        arrayOfInt1[1] = paramHomePendingSurfaceWidget.mCellY;
        if (!paramHomePendingSurfaceWidget.mFoundInCurrentScreen) {
          showOutOfSpaceMessage();
        }
        if (bool) {
          break;
        }
        return false;
        i = j;
      } while (arrayOfInt2 == null);
      i = j;
    } while (localCellLayout == null);
    if (localCellLayout.findNearestVacantArea(arrayOfInt2[0], arrayOfInt2[1], localObject[0], localObject[1], arrayOfInt1) != null) {}
    for (int i = 1;; i = 0) {
      break;
    }
    localSurfaceWidgetItem.spanX = localObject[0];
    localSurfaceWidgetItem.spanY = localObject[1];
    LauncherModel.addItemToDatabase(getActivity(), localSurfaceWidgetItem, l, j, arrayOfInt1[0], arrayOfInt1[1], false);
    localSurfaceWidgetItem.mWidgetView.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        localSurfaceWidgetItem.mWidgetView.removeOnLayoutChangeListener(this);
        localSurfaceWidgetItem.mWidgetView.post(new Runnable()
        {
          public void run()
          {
            if (HomeView.this.mWorkspace != null) {
              HomeView.this.mWorkspace.enterSurfaceWidgetResizeMode(HomeView.19.this.val$homeItem.mWidgetView, HomeView.19.this.val$layout);
            }
          }
        });
      }
    });
    this.mWorkspace.addItem(localSurfaceWidgetItem);
    if (this.mWorkspace.getCurrentPage() == j) {
      this.mWorkspace.resumeScreen(j);
    }
    for (;;)
    {
      if ((Launcher.isHelpAppRunning) && ("add_widgets".equals(GuideFragment.GMode)))
      {
        GuideFragment.isGuideCompleted = true;
        Toast.makeText(this.mWorkspace.getContext(), 2131755180, 1).show();
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            GuideFragment.showCompleteDialog(HomeView.this.getActivity());
          }
        }, 2000L);
      }
      return true;
      this.mWorkspace.snapToPage(j);
    }
  }
  
  private void calcFinalSpan(HomeItem paramHomeItem, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (-1 == paramHomeItem.spanX) {
      paramHomeItem.spanX = paramArrayOfInt1[0];
    }
    if (-1 == paramHomeItem.spanY) {
      paramHomeItem.spanY = paramArrayOfInt1[1];
    }
    if ((paramInt & 0x1) == 1)
    {
      paramHomeItem.spanX = Math.max(paramHomeItem.spanX, paramArrayOfInt2[0]);
      if (-1 != paramArrayOfInt2[2]) {
        paramHomeItem.spanX = Math.min(paramHomeItem.spanX, paramArrayOfInt2[2]);
      }
    }
    if ((paramInt & 0x2) == 2)
    {
      paramHomeItem.spanY = Math.max(paramHomeItem.spanY, paramArrayOfInt2[1]);
      if (-1 != paramArrayOfInt2[3]) {
        paramHomeItem.spanY = Math.min(paramHomeItem.spanY, paramArrayOfInt2[3]);
      }
    }
  }
  
  private void closeQuickViewWorkspaceStartAnimation()
  {
    this.mWorkspace.setVisibility(0);
    this.mWorkspace.getPageIndicatorManager().setDisplayItem(PageIndicatorManager.DISPLAY_ITEM.ALL_PAGE);
    if (this.mHomePhoneBtn != null) {
      this.mHomePhoneBtn.setVisibility(0);
    }
    if (this.mHomeAppsBtn != null) {
      this.mHomeAppsBtn.setVisibility(0);
    }
    int i = this.mQuickViewWorkspace.getCurrentPage();
    if ((i >= 0) && (i < this.mWorkspace.getChildCount()) && (this.mWorkspace.getCurrentPage() != i)) {
      this.mWorkspace.setCurrentPage(i);
    }
    AnimationLayer localAnimationLayer = ((Launcher)getActivity()).getAnimationLayer();
    this.mWorkspace.setVisibility(0);
    if (this.mHotseat != null)
    {
      this.mHotseat.animate().cancel();
      this.mHotseat.setVisibility(0);
      this.mHotseat.setLayerType(2, Launcher.sViewLayerPaint);
      this.mHotseat.animate().alpha(1.0F).setDuration(360L).setListener(localAnimationLayer.mBlockEventsListener).start();
    }
    if (this.mQuickLaunch != null)
    {
      this.mQuickLaunch.animate().cancel();
      this.mQuickLaunch.setVisibility(0);
      this.mQuickLaunch.setLayerType(2, Launcher.sViewLayerPaint);
      this.mQuickLaunch.animate().alpha(1.0F).setDuration(360L).setListener(localAnimationLayer.mBlockEventsListener).start();
    }
    if ((this.mQuickLaunchCamera != null) && (this.mQuickLaunchCamera.isLandscape()))
    {
      this.mQuickLaunchCamera.animate().cancel();
      this.mQuickLaunchCamera.setVisibility(0);
      this.mQuickLaunchCamera.setLayerType(2, Launcher.sViewLayerPaint);
      this.mQuickLaunchCamera.animate().alpha(1.0F).setDuration(360L).setListener(localAnimationLayer.mBlockEventsListener).start();
    }
    if (this.mHomeSearchBtn != null) {
      this.mHomeSearchBtn.setEnabled(true);
    }
    if (this.mHomeTopBar != null)
    {
      this.mHomeTopBar.animate().cancel();
      this.mHomeTopBar.setVisibility(0);
      this.mHomeTopBar.setLayerType(2, Launcher.sViewLayerPaint);
      this.mHomeTopBar.animate().alpha(1.0F).setDuration(360L).setListener(localAnimationLayer.mBlockEventsListener).start();
    }
    if ((this.mHomeBottomBar != null) && (this.removeHotseat))
    {
      this.mHomeBottomBar.animate().cancel();
      this.mHomeBottomBar.setVisibility(0);
      this.mHomeBottomBar.setLayerType(2, Launcher.sViewLayerPaint);
      this.mHomeBottomBar.animate().alpha(1.0F).setDuration(360L).setListener(localAnimationLayer.mBlockEventsListener).start();
    }
    this.mWorkspace.getChildAt(this.mWorkspace.getCurrentPage()).requestFocus();
    this.mWorkspace.showPageIndicator(true);
  }
  
  private boolean completeAdd(PendingAddArguments paramPendingAddArguments)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (paramPendingAddArguments.requestCode)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      resetAddInfo();
      return bool1;
      startActivityForResultSafely(paramPendingAddArguments.intent, 1);
      bool1 = bool2;
      continue;
      completeAddShortcut(paramPendingAddArguments.intent, paramPendingAddArguments.container, paramPendingAddArguments.screen, paramPendingAddArguments.cellX, paramPendingAddArguments.cellY);
      bool1 = true;
      continue;
      paramPendingAddArguments = this.mModel.infoFromShortcutIntent(getActivity(), paramPendingAddArguments.intent, null);
      CreateFolderDialog.createAndShow(((Activity)getContext()).getFragmentManager(), paramPendingAddArguments, -1L, -100L, false, true, -1, -1);
      bool1 = bool2;
      continue;
      addAppWidgetFromPick(paramPendingAddArguments.intent);
      bool1 = bool2;
      continue;
      int i = paramPendingAddArguments.intent.getIntExtra("appWidgetId", -1);
      copyPendingAddToHomeItem(this.mPendingAddInfo, paramPendingAddArguments);
      completeAddAppWidget(i, this.mPendingAddInfo);
      bool1 = true;
    }
  }
  
  private void completeAddAppWidget(final int paramInt, HomeItem paramHomeItem)
  {
    AppWidgetProviderInfo localAppWidgetProviderInfo = this.mAppWidgetManager.getAppWidgetInfo(paramInt);
    if (localAppWidgetProviderInfo == null)
    {
      if (DEBUGGABLE) {
        Log.d("Launcher.HomeView", "App widget info is null. AppWidgetID = " + paramInt);
      }
      return;
    }
    long l = paramHomeItem.container;
    int k = paramHomeItem.mScreen;
    final CellLayout localCellLayout = reAddCreatedPageForDragIfNeeded(getCellLayout(l, k), l, k, paramHomeItem);
    int[] arrayOfInt2 = this.mTmpAddItemSpans;
    arrayOfInt2[0] = paramHomeItem.spanX;
    arrayOfInt2[1] = paramHomeItem.spanY;
    int[] arrayOfInt1 = this.mTmpAddItemCellCoordinates;
    final Object localObject = paramHomeItem.dropPos;
    int j = 0;
    int i;
    if (localCellLayout != null) {
      if ((paramHomeItem.cellX >= 0) && (paramHomeItem.cellY >= 0))
      {
        arrayOfInt1[0] = paramHomeItem.cellX;
        arrayOfInt1[1] = paramHomeItem.cellY;
        j = 1;
        i = k;
      }
    }
    for (;;)
    {
      k = i;
      if (j != 0) {
        break label314;
      }
      localObject = new DropPos();
      boolean bool = findEmptySpanOnHomeScreen(arrayOfInt1, i, getActivity(), (DropPos)localObject, arrayOfInt2[0], arrayOfInt2[1], false);
      k = ((DropPos)localObject).mScreen;
      arrayOfInt1[0] = ((DropPos)localObject).mCellX;
      arrayOfInt1[1] = ((DropPos)localObject).mCellY;
      if (!((DropPos)localObject).mFoundInCurrentScreen) {
        showOutOfSpaceMessage();
      }
      if (bool) {
        break label314;
      }
      if (paramInt == -1) {
        break;
      }
      new Thread("deleteAppWidgetId")
      {
        public void run()
        {
          HomeView.this.mAppWidgetHost.deleteAppWidgetId(paramInt);
        }
      }.start();
      return;
      i = k;
      if (localObject != null)
      {
        if (localCellLayout.findNearestVacantArea(localObject[0], localObject[1], arrayOfInt2[0], arrayOfInt2[1], arrayOfInt1) != null) {}
        for (j = 1;; j = 0)
        {
          i = k;
          break;
        }
        i = -1;
      }
    }
    label314:
    localObject = new HomeWidgetItem(localAppWidgetProviderInfo, paramInt, false);
    ((HomeWidgetItem)localObject).spanX = arrayOfInt2[0];
    ((HomeWidgetItem)localObject).spanY = arrayOfInt2[1];
    if ((paramHomeItem instanceof HomePendingWidget))
    {
      paramHomeItem = (HomePendingWidget)paramHomeItem;
      copySpans(((HomeWidgetItem)localObject).resizeSpans, paramHomeItem.getResizeSpans());
      LauncherModel.addItemToDatabase(getActivity(), (HomeItem)localObject, l, k, arrayOfInt1[0], arrayOfInt1[1], false);
      if (!this.mRestoring)
      {
        ((HomeWidgetItem)localObject).hostView = this.mAppWidgetHost.createView(getActivity(), paramInt, localAppWidgetProviderInfo);
        ((HomeWidgetItem)localObject).hostView.setAppWidget(paramInt, localAppWidgetProviderInfo);
        ((HomeWidgetItem)localObject).hostView.setTag(localObject);
        paramHomeItem = this.mSpanCalculator.getPaddingForWidget(localAppWidgetProviderInfo.provider);
        ((HomeWidgetItem)localObject).hostView.setPadding(paramHomeItem.left, paramHomeItem.top, paramHomeItem.right, paramHomeItem.bottom);
        ((HomeWidgetItem)localObject).hostView.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {
          public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            localObject.hostView.removeOnLayoutChangeListener(this);
            localObject.hostView.post(new Runnable()
            {
              public void run()
              {
                if (HomeView.this.mWorkspace != null) {
                  HomeView.this.mWorkspace.enterWidgetResizeMode((LauncherAppWidgetHostView)HomeView.12.this.val$launcherInfo.hostView, HomeView.12.this.val$layout);
                }
              }
            });
          }
        });
        this.mSpanCalculator.updateWidgetSizeRanges(((HomeWidgetItem)localObject).hostView, (Launcher)getActivity(), ((HomeWidgetItem)localObject).spanX, ((HomeWidgetItem)localObject).spanY);
        paramHomeItem = (CellLayout)this.mWorkspace.getPageAt(k);
        if (paramHomeItem.mChildren.mItems.size() != 0) {
          break label729;
        }
        paramInt = 1;
        label553:
        ((HomeWidgetItem)localObject).hostView.setBackgroundColor(16777216);
        this.mWorkspace.addItem((HomeItem)localObject);
        if ((paramInt != 0) && (paramHomeItem.mChildren.mItems.size() != 0)) {
          this.mWorkspace.turnOffEmptyPageMsg();
        }
        addWidgetToAutoAdvanceIfNeeded(((HomeWidgetItem)localObject).hostView, localAppWidgetProviderInfo);
      }
      if (Launcher.isHelpAppRunning)
      {
        if (!GuideFragment.GMode.equals("add_widgets")) {
          break label734;
        }
        GuideFragment.isGuideCompleted = true;
        Toast.makeText(this.mWorkspace.getContext(), 2131755180, 1).show();
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            GuideFragment.showCompleteDialog(HomeView.this.getActivity());
          }
        }, 2000L);
      }
    }
    for (;;)
    {
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          Talk.INSTANCE.say(2131755211);
        }
      }, 500L);
      return;
      if ((paramHomeItem instanceof HomeWidgetItem))
      {
        paramHomeItem = (HomeWidgetItem)paramHomeItem;
        copySpans(((HomeWidgetItem)localObject).resizeSpans, paramHomeItem.getResizeSpans());
        break;
      }
      ((HomeWidgetItem)localObject).calcResizeSpan(localAppWidgetProviderInfo);
      break;
      label729:
      paramInt = 0;
      break label553;
      label734:
      if (GuideFragment.GMode.equals("resize_widgets")) {
        this.mWorkspace.exitWidgetResizeMode();
      }
    }
  }
  
  private void completeAddShortcut(Intent paramIntent, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramIntent.getParcelableExtra("android.intent.extra.shortcut.INTENT") == null) {
      return;
    }
    completeAddShortcut(this.mModel.infoFromShortcutIntent(getActivity(), paramIntent, null), paramLong, paramInt1, paramInt2, paramInt3);
  }
  
  private static void copyHomeItemToPendingAdd(PendingAddArguments paramPendingAddArguments, HomeItem paramHomeItem)
  {
    paramPendingAddArguments.container = paramHomeItem.container;
    paramPendingAddArguments.screen = paramHomeItem.mScreen;
    paramPendingAddArguments.cellX = paramHomeItem.cellX;
    paramPendingAddArguments.cellY = paramHomeItem.cellY;
    paramPendingAddArguments.spanX = paramHomeItem.spanX;
    paramPendingAddArguments.spanY = paramHomeItem.spanY;
    paramPendingAddArguments.dropPos = paramHomeItem.dropPos;
    paramPendingAddArguments.isSecretItem = paramHomeItem.mSecretItem;
  }
  
  private static void copyPendingAddToHomeItem(HomeItem paramHomeItem, PendingAddArguments paramPendingAddArguments)
  {
    paramHomeItem.container = paramPendingAddArguments.container;
    paramHomeItem.mScreen = paramPendingAddArguments.screen;
    paramHomeItem.cellX = paramPendingAddArguments.cellX;
    paramHomeItem.cellY = paramPendingAddArguments.cellY;
    paramHomeItem.spanX = paramPendingAddArguments.spanX;
    paramHomeItem.spanY = paramPendingAddArguments.spanY;
    paramHomeItem.dropPos = paramPendingAddArguments.dropPos;
    paramHomeItem.mSecretItem = paramPendingAddArguments.isSecretItem;
  }
  
  private void copySpans(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt2.length != 4) || (paramArrayOfInt1.length != 4)) {
      throw new IllegalArgumentException("Bad array passed to copySpans src " + paramArrayOfInt2 + " (" + paramArrayOfInt2.length + ") dst " + paramArrayOfInt1 + " (" + paramArrayOfInt1.length + ")");
    }
    System.arraycopy(paramArrayOfInt2, 0, paramArrayOfInt1, 0, paramArrayOfInt2.length);
  }
  
  private void copyToPendingAddInfo(HomePendingWidget paramHomePendingWidget)
  {
    this.mPendingAddInfo.container = paramHomePendingWidget.container;
    this.mPendingAddInfo.mScreen = paramHomePendingWidget.mScreen;
    this.mPendingAddInfo.cellX = paramHomePendingWidget.cellX;
    this.mPendingAddInfo.cellY = paramHomePendingWidget.cellY;
    this.mPendingAddInfo.spanX = paramHomePendingWidget.spanX;
    this.mPendingAddInfo.spanY = paramHomePendingWidget.spanY;
    this.mPendingAddInfo.dropPos = paramHomePendingWidget.dropPos;
    this.mPendingAddInfo.mSecretItem = paramHomePendingWidget.mSecretItem;
  }
  
  private void createWorkspaceChildren()
  {
    int k = LauncherApplication.getScreenCount();
    int i = 0;
    if (i < k)
    {
      CellLayoutWithResizableWidgets localCellLayoutWithResizableWidgets = (CellLayoutWithResizableWidgets)LayoutInflater.from(getActivity()).inflate(2130903131, this.mWorkspace, false);
      ViewGroup.LayoutParams localLayoutParams2 = localCellLayoutWithResizableWidgets.getLayoutParams();
      ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
      }
      this.mWorkspace.addView(localCellLayoutWithResizableWidgets, localLayoutParams1);
      if (determineEmptyPageMsgVisibility(i)) {}
      for (j = 0;; j = 8)
      {
        localCellLayoutWithResizableWidgets.setEmptyMessageVisibility(j);
        i += 1;
        break;
      }
    }
    int j = LauncherApplication.getHomeScreenIndex();
    if (j >= 0)
    {
      i = j;
      if (j < k) {}
    }
    else
    {
      if (j >= 0) {
        break label139;
      }
    }
    label139:
    for (i = 0;; i = k - 1)
    {
      LauncherApplication.setHomeScreenIndex(getActivity(), i);
      this.mWorkspace.setCurrentPage(i);
      return;
    }
  }
  
  public static boolean findEmptySpanOnHomeScreen(int[] paramArrayOfInt, int paramInt1, Context paramContext, DropPos paramDropPos, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramDropPos == null)
    {
      bool2 = false;
      return bool2;
    }
    Workspace localWorkspace = ((Launcher)paramContext).mHomeView.getWorkspace();
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = localWorkspace.getCurrentPage();
    }
    int m = localWorkspace.getChildCount();
    boolean bool2 = false;
    int j = 0;
    int[] arrayOfInt;
    if (paramArrayOfInt != null)
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length == 2) {}
    }
    else
    {
      arrayOfInt = new int[2];
    }
    paramDropPos.mFoundInCurrentScreen = false;
    int k;
    for (paramInt1 = i;; paramInt1 = k + 1)
    {
      k = paramInt1;
      if (paramInt1 >= m)
      {
        k = 0;
        j = 1;
      }
      boolean bool1;
      if ((j != 0) && (k >= i))
      {
        bool1 = bool2;
        if (!bool2)
        {
          paramInt1 = localWorkspace.newPage(false);
          bool1 = bool2;
          if (paramInt1 != Integer.MIN_VALUE)
          {
            paramArrayOfInt = (CellLayout)localWorkspace.getChildAt(paramInt1);
            bool1 = bool2;
            if (paramArrayOfInt.findCellForSpan(arrayOfInt, 1, 1))
            {
              paramDropPos.assign(paramArrayOfInt, paramInt1, arrayOfInt[0], arrayOfInt[1]);
              bool1 = true;
            }
          }
        }
        bool2 = bool1;
        if (paramDropPos.mFoundInCurrentScreen) {
          break;
        }
        bool2 = bool1;
        if (!paramBoolean) {
          break;
        }
        showOutOfSpaceMessage(paramContext);
        return bool1;
      }
      paramArrayOfInt = localWorkspace.getChildAt(k);
      if ((paramArrayOfInt != null) && ((paramArrayOfInt instanceof CellLayout)))
      {
        paramArrayOfInt = (CellLayout)paramArrayOfInt;
        if (paramArrayOfInt.findCellForSpan(arrayOfInt, paramInt2, paramInt3))
        {
          paramDropPos.assign(paramArrayOfInt, k, arrayOfInt[0], arrayOfInt[1]);
          bool2 = true;
          if (k == i) {}
          for (bool1 = true;; bool1 = false)
          {
            paramDropPos.mFoundInCurrentScreen = bool1;
            break;
          }
        }
      }
    }
  }
  
  private Drawable getExternalPackageToolbarIcon(ComponentName paramComponentName)
  {
    try
    {
      Object localObject = getActivity().getPackageManager();
      Bundle localBundle = ((PackageManager)localObject).getActivityInfo(paramComponentName, 128).metaData;
      if (localBundle != null)
      {
        int i = localBundle.getInt("com.android.launcher.toolbar_icon");
        if (i != 0)
        {
          localObject = ((PackageManager)localObject).getResourcesForActivity(paramComponentName).getDrawable(i);
          return (Drawable)localObject;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      if (DEBUGGABLE) {
        Log.w("Launcher.HomeView", "Failed to load toolbar icon; " + paramComponentName.flattenToShortString() + " not found", localNameNotFoundException);
      }
      return null;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        if (DEBUGGABLE) {
          Log.w("Launcher.HomeView", "Failed to load toolbar icon from " + paramComponentName.flattenToShortString(), localNotFoundException);
        }
      }
    }
  }
  
  public static HomeFolderItem getFolderById(long paramLong)
  {
    return (HomeFolderItem)sFolders.get(Long.valueOf(paramLong));
  }
  
  private void onAppWidgetReset()
  {
    if (this.mAppWidgetHost != null) {
      this.mAppWidgetHost.startListening();
    }
  }
  
  private void performOnHomePressed(boolean paramBoolean)
  {
    Log.d("Launcher.HomeView", "performOnHomePressed");
    Object localObject;
    if ((this.mQuickViewWorkspace != null) && (this.mQuickViewWorkspace.isOpened()))
    {
      localObject = (Launcher)getContext();
      if (HomescreenWallpaperOptionsDialogFragment.isHomeScreenWallpaperDialogVisible) {
        HomescreenWallpaperOptionsDialogFragment.dismiss(((Launcher)localObject).getFragmentManager());
      }
      if (HomeScreenDialogFragment.isHomeScreenDialogVisible)
      {
        HomeScreenDialogFragment.dismiss(((Launcher)localObject).getFragmentManager());
        this.mQuickViewWorkspace.drawCloseAnimation();
      }
    }
    label203:
    label335:
    label345:
    label357:
    do
    {
      do
      {
        return;
        if (getHomeScreenOptionMenu().isActive())
        {
          this.mQuickViewWorkspace.drawCloseAnimation();
          return;
        }
        closeQuickViewWorkspace(true);
        return;
      } while ((this.mWorkspace == null) || ((Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) && (this.mWorkspace.getIsDragOccuring()) && ((Launcher.isHomeEditMode()) || (Launcher.isHomeRemoveMode()))));
      if (Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) {
        if (Launcher.isHomeEditMode())
        {
          this.mWorkspace.exitWidgetResizeMode();
          Launcher.setHomeRemoveMode(false);
          Launcher.setHomeEditMode(false);
          showWorkspace(true);
          this.mWorkspace.closeFolder();
          this.mHomeKeyPress = true;
          if (this.mWorkspace.getOpenFolder() != null)
          {
            localObject = this.mWorkspace.getOpenFolder();
            if (!((Folder)localObject).isEditingName()) {
              break label335;
            }
            ((Folder)localObject).dismissEditingName(true);
          }
          if ((!LauncherApplication.sMagazineLauncher) || (!Launcher.sIsMagazineHomeEnable) || (this.mWorkspace.isFolderOpened()) || (LauncherApplication.getInst().isKnoxMode()) || (LauncherApplication.getHomeScreenIndex() != this.mWorkspace.getComingPage()) || (Launcher.mIsExpandStatusBar)) {
            continue;
          }
          localObject = getActivity().getContentResolver().call(MAGAZINE_CONTENT_URI, "getUsingHomekeySetting()", null, null);
          if (localObject != null) {
            break label345;
          }
        }
      }
      for (boolean bool = true;; bool = ((Bundle)localObject).getBoolean("return getUsingHomekeySetting()", true))
      {
        if (!bool) {
          break label357;
        }
        ((Launcher)getContext()).startMagazineApp(true);
        this.mWorkspace.closeFolder();
        return;
        getActivity().findViewById(2131689617).setAlpha(0.0F);
        break;
        getActivity().findViewById(2131689617).setAlpha(0.0F);
        break;
        this.mWorkspace.closeFolder();
        break label203;
      }
    } while (!paramBoolean);
    this.mWorkspace.moveToDefaultScreen(true);
  }
  
  private CellLayout reAddCreatedPageForDragIfNeeded(CellLayout paramCellLayout, long paramLong, int paramInt, HomeItem paramHomeItem)
  {
    Object localObject = paramCellLayout;
    CellLayout localCellLayout;
    if (paramCellLayout == null)
    {
      localObject = paramCellLayout;
      if (paramLong == -100L)
      {
        localObject = paramCellLayout;
        if (getChildCount() < LauncherApplication.getMaxScreenCount())
        {
          localObject = paramCellLayout;
          if (paramInt == getPageCount())
          {
            localCellLayout = this.mWorkspace.insertWorkspaceScreen(getPageCount(), false);
            localObject = paramCellLayout;
            if (localCellLayout != null) {
              localObject = localCellLayout;
            }
          }
        }
      }
    }
    paramCellLayout = (CellLayout)localObject;
    if (paramHomeItem.mSecretItem)
    {
      paramCellLayout = (CellLayout)localObject;
      if (localObject != null)
      {
        paramCellLayout = (CellLayout)localObject;
        if (((CellLayout)localObject).getPageType() != 1)
        {
          localCellLayout = this.mWorkspace.insertWorkspaceSecretScreen(paramInt, false, true);
          paramCellLayout = (CellLayout)localObject;
          if (localCellLayout != null) {
            paramCellLayout = localCellLayout;
          }
        }
      }
    }
    localObject = paramCellLayout;
    if (LauncherApplication.sFestivalPageLauncher)
    {
      localObject = paramCellLayout;
      if (Launcher.sIsFestivalModeOn)
      {
        localObject = paramCellLayout;
        if (!paramHomeItem.mSecretItem)
        {
          localObject = paramCellLayout;
          if (paramCellLayout != null)
          {
            localObject = paramCellLayout;
            if (paramCellLayout.getPageType() == 2)
            {
              paramHomeItem = this.mWorkspace.insertWorkspaceScreen(paramInt, false);
              localObject = paramCellLayout;
              if (paramHomeItem != null) {
                localObject = paramHomeItem;
              }
            }
          }
        }
      }
    }
    return (CellLayout)localObject;
  }
  
  private void registerContentObservers()
  {
    ContentResolver localContentResolver = getActivity().getContentResolver();
    localContentResolver.registerContentObserver(LauncherProvider.CONTENT_APPWIDGET_RESET_URI, true, this.mWidgetObserver);
    if (((Launcher)getActivity()).isHelpHubAvailable()) {
      localContentResolver.registerContentObserver(Uri.parse("content://com.samsung.helphub.provider/help_page_status/"), true, this.mHelphubObserver);
    }
    localContentResolver.registerContentObserver(Settings.System.getUriFor("skt_phone20_settings"), false, this.mChangeTphoneModeObserver);
  }
  
  private void releaseVelocityTracker()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private void resetAddInfo()
  {
    this.mPendingAddInfo.container = -1L;
    this.mPendingAddInfo.mScreen = -1;
    HomeItem localHomeItem = this.mPendingAddInfo;
    this.mPendingAddInfo.cellY = -1;
    localHomeItem.cellX = -1;
    localHomeItem = this.mPendingAddInfo;
    this.mPendingAddInfo.spanY = -1;
    localHomeItem.spanX = -1;
    this.mPendingAddInfo.dropPos = null;
    this.mPendingAddInfo.mSecretItem = false;
  }
  
  private void restoreState(SavedState paramSavedState)
  {
    if (paramSavedState == null) {
      return;
    }
    int i = paramSavedState.currentScreen;
    if (i > -1) {
      this.mWorkspace.setCurrentPage(i);
    }
    long l = paramSavedState.pendingAddContainer;
    i = paramSavedState.pendingAddScreen;
    HomeItem localHomeItem;
    if ((l != -1L) && (i > -1))
    {
      this.mPendingAddInfo.container = l;
      this.mPendingAddInfo.mScreen = i;
      this.mPendingAddInfo.cellX = paramSavedState.pendingAddCellX;
      this.mPendingAddInfo.cellY = paramSavedState.pendingAddCellY;
      this.mPendingAddInfo.spanX = paramSavedState.pendingAddSpanX;
      this.mPendingAddInfo.spanY = paramSavedState.pendingAddSpanY;
      localHomeItem = this.mPendingAddInfo;
      if (paramSavedState.pendingAddSecretItem != 1) {
        break label265;
      }
    }
    label265:
    for (boolean bool = true;; bool = false)
    {
      localHomeItem.mSecretItem = bool;
      i = paramSavedState.pendingAddDropPosX;
      int j = paramSavedState.pendingAddDropPoxY;
      if ((-1 != i) && (-1 != j))
      {
        this.mPendingAddInfo.dropPos = new int[2];
        this.mPendingAddInfo.dropPos[0] = i;
        this.mPendingAddInfo.dropPos[1] = j;
      }
      this.mRestoring = true;
      this.mFolderBundle = paramSavedState.folderBundle;
      if ((this.mFolderBundle != null) && (this.mHomeDarkenLayer != null))
      {
        i = paramSavedState.darkenLayerVisibility;
        this.mHomeDarkenLayer.setVisibility(i);
      }
      bool = paramSavedState.inQuickView;
      if (LauncherApplication.sFestivalPageLauncher) {
        bool = false;
      }
      if (bool)
      {
        this.mWorkspace.mPagePreviewManager.layoutPageIndicator();
        openQuickViewWorkspace(paramSavedState, false);
      }
      this.mAfterSavedInstanceState = false;
      return;
    }
  }
  
  private void sendAdvanceMessage(long paramLong)
  {
    this.mHandler.removeMessages(1);
    Message localMessage = this.mHandler.obtainMessage(1);
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
    this.mAutoAdvanceSentTime = System.currentTimeMillis();
  }
  
  private void setStartPosition(MotionEvent paramMotionEvent)
  {
    this.mDownMotionX = paramMotionEvent.getX();
    this.mDownMotionY = paramMotionEvent.getY();
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
    }
    this.mIsStartFlickUp = true;
  }
  
  private void setupHomeViewAfterRotationForTB(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.mHomeAppsBtn.getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.mHomePhoneBtn.getLayoutParams();
    int i = 0;
    if (i < this.mWorkspace.getChildCount())
    {
      CellLayoutWithResizableWidgets localCellLayoutWithResizableWidgets = (CellLayoutWithResizableWidgets)this.mWorkspace.getChildAt(i);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localCellLayoutWithResizableWidgets.getLayoutParams();
      if (paramInt == 2) {
        localMarginLayoutParams.setMarginStart(getResources().getDimensionPixelSize(2131624112));
      }
      for (;;)
      {
        localCellLayoutWithResizableWidgets.setLayoutParams(localMarginLayoutParams);
        i += 1;
        break;
        localMarginLayoutParams.setMarginStart(getResources().getDimensionPixelSize(2131624152));
      }
    }
    if (paramInt == 2)
    {
      localLayoutParams1.setMarginEnd(getResources().getDimensionPixelSize(2131624546));
      localLayoutParams2.setMarginStart(getResources().getDimensionPixelSize(2131624545));
      this.mWorkspace.getPageIndicatorManager().getPageIndicator().setPageIndicatorPanelRightAdjust(getResources().getDimensionPixelSize(2131624109));
    }
    for (;;)
    {
      this.mHomeAppsBtn.setLayoutParams(localLayoutParams1);
      this.mHomePhoneBtn.setLayoutParams(localLayoutParams2);
      post(new Runnable()
      {
        public void run()
        {
          HomeView.this.getParent().requestLayout();
        }
      });
      return;
      localLayoutParams1.setMarginEnd(getResources().getDimensionPixelSize(2131624545));
      localLayoutParams2.setMarginStart(getResources().getDimensionPixelSize(2131624546));
      this.mWorkspace.getPageIndicatorManager().getPageIndicator().setPageIndicatorPanelRightAdjust(getResources().getDimensionPixelSize(2131624108));
    }
  }
  
  private void setupViews()
  {
    Resources localResources = getResources();
    this.mWorkspace = ((Workspace)findViewById(2131689593));
    this.mWorkspace.setPageSwitchListener(this);
    this.mQuickViewWorkspace = ((QuickViewWorkspace)findViewById(2131689678));
    this.mDeleteDropLayout = ((QuickViewDragBar)findViewById(2131689679));
    this.mHomeScreenOptionMenu = ((HomeScreenOptionMenu)findViewById(2131689680));
    this.mHomeDarkenLayer = findViewById(2131689596);
    this.mHomeDarkenLayer.setOnTouchListener(this.mDarkenLayerTouchListener);
    this.mHomeContainer = findViewById(2131689592);
    cpuBooster = LauncherApplication.getInst().getCpuBoosterObject();
    this.mHotseat = ((Hotseat)findViewById(2131689595));
    if (this.mHotseat != null) {
      this.mHotseat.setup(this);
    }
    FocusHelper.setup(this);
    if (Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE)
    {
      this.mHomeEditTitleBar = ((ViewGroup)findViewById(2131689594));
      if (this.mHomeEditTitleBar != null)
      {
        this.mHomeEditTitleBar.findViewById(2131689590).setOnClickListener(this.mHomeEditButtonListener);
        this.mHomeEditTitleBar.findViewById(2131689551).setOnClickListener(this.mHomeEditButtonListener);
      }
    }
    this.mEditBar = ((HomeEditBar)findViewById(2131689537));
    if (Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE)
    {
      this.mEditIcon = findViewById(2131689599);
      if (this.mEditIcon != null)
      {
        if (this.mEditIcon.getHoverPopupWindow() != null)
        {
          this.mEditIcon.setHoverPopupType(1);
          this.mEditIcon.getHoverPopupWindow().setContent(localResources.getString(2131755057));
          this.mEditIcon.getHoverPopupWindow().setPopupGravity(12341);
          this.mEditIcon.getHoverPopupWindow().setPopupPosOffset(localResources.getDimensionPixelOffset(2131623960), 0);
          this.mEditIcon.getHoverPopupWindow().setFHAnimationEnabled(false);
        }
        this.mEditIcon.setVisibility(0);
        this.mEditIcon.setOnClickListener(this);
      }
      this.mEditIconDivider = findViewById(2131689605);
      if (this.mEditIconDivider != null) {
        this.mEditIconDivider.setVisibility(0);
      }
    }
    this.mHomeTopBar = findViewById(2131689598);
    if (this.removeHotseat)
    {
      this.mHomeBottomBar = findViewById(2131689609);
      if (this.mHomeBottomBar != null)
      {
        this.mHomeBottomBar.setVisibility(0);
        this.mGoogleSearchView = findViewById(2131689611);
        this.mGoogleSearchView.setOnClickListener(this.SearchButtonClickListener);
        this.mGoogleSearchView.setOnKeyListener(FocusHelper.GOOGLE_SEARCH_KEY_LISTENER);
        this.mVoiceSearchView = findViewById(2131689612);
        this.mVoiceSearchView.setOnClickListener(this.VoiceSearchButtonClickListener);
        this.mVoiceSearchView.setOnKeyListener(FocusHelper.GOOGLE_SEARCH_KEY_LISTENER);
        setTabletHotseat();
      }
    }
    this.mMyFilesView = findViewById(2131689613);
    if (this.mMyFilesView != null) {
      this.mMyFilesView.setOnClickListener(this.MyFilesButtonClickListener);
    }
    this.mWorkspace.setHapticFeedbackEnabled(false);
    this.mWorkspace.setOnLongClickListener(this);
    this.mWorkspace.setup(this);
    createWorkspaceChildren();
    if (this.mHotseat != null) {
      this.mWorkspace.addStateAnimatorProvider(this.mHotseat);
    }
    if (this.mQuickLaunch != null) {
      this.mWorkspace.addStateAnimatorProvider(this.mQuickLaunch);
    }
    if (this.mQuickLaunchCamera != null) {
      this.mWorkspace.addStateAnimatorProvider(this.mQuickLaunchCamera);
    }
    if (this.mEditBar != null) {
      this.mWorkspace.addStateAnimatorProvider(this.mEditBar);
    }
    if (LauncherApplication.sMagazineLauncher)
    {
      this.mLightEffectImage = ((ImageView)findViewById(2131689603));
      if (this.mLightEffectImage != null) {
        this.mLightEffectAnimation = ((AnimationDrawable)this.mLightEffectImage.getBackground());
      }
    }
  }
  
  public static void showNoRoomAnyPageMessage(Context paramContext)
  {
    Toast.makeText(paramContext, paramContext.getString(2131755035), 0).show();
  }
  
  public static void showOutOfSpaceMessage(Context paramContext)
  {
    Toast.makeText(paramContext, paramContext.getString(2131755034), 0).show();
  }
  
  private Drawable.ConstantState updateButtonWithIconFromExternalActivity(int paramInt1, ComponentName paramComponentName, int paramInt2)
  {
    ImageView localImageView = (ImageView)findViewById(paramInt1);
    paramComponentName = getExternalPackageToolbarIcon(paramComponentName);
    if (localImageView != null)
    {
      if (paramComponentName != null) {
        break label40;
      }
      localImageView.setImageResource(paramInt2);
    }
    while (paramComponentName != null)
    {
      return paramComponentName.getConstantState();
      label40:
      localImageView.setImageDrawable(paramComponentName);
    }
    return null;
  }
  
  private Drawable.ConstantState updateTextButtonWithIconFromExternalActivity(int paramInt1, ComponentName paramComponentName, int paramInt2)
  {
    TextView localTextView = (TextView)findViewById(paramInt1);
    paramComponentName = getExternalPackageToolbarIcon(paramComponentName);
    Resources localResources = getResources();
    paramInt1 = localResources.getDimensionPixelSize(2131624207);
    int i = localResources.getDimensionPixelSize(2131624208);
    if (paramComponentName == null)
    {
      paramComponentName = localResources.getDrawable(paramInt2);
      paramComponentName.setBounds(0, 0, paramInt1, i);
      localTextView.setCompoundDrawables(paramComponentName, null, null, null);
      return null;
    }
    paramComponentName.setBounds(0, 0, paramInt1, i);
    localTextView.setCompoundDrawables(paramComponentName, null, null, null);
    return paramComponentName.getConstantState();
  }
  
  public void ChangeTphoneMode()
  {
    if (getResources().getBoolean(2131427337))
    {
      getModel().ChangeTphoneMode(this);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.samsung.android.cocktail.action.CHANGE_CALL_ITEM");
    getContext().sendBroadcast(localIntent);
  }
  
  public HomeWidgetItem HelpAppAddwidget()
  {
    addHelpAppPage();
    int j = getNumPages();
    int[] arrayOfInt = new int[2];
    int[] tmp16_14 = arrayOfInt;
    tmp16_14[0] = 0;
    int[] tmp20_16 = tmp16_14;
    tmp20_16[1] = 0;
    tmp20_16;
    Workspace localWorkspace = this.mWorkspace;
    int k = getAppWidgetHost().allocateAppWidgetId();
    Object localObject1;
    Object localObject2;
    if (CscFeature.getInstance().getEnableStatus("CscFeature_Launcher_DisableGoogleOption"))
    {
      localObject1 = "com.sec.android.app.sbrowser";
      localObject2 = "com.sec.android.app.sbrowser.BookmarkThumbnailWidgetProvider";
    }
    for (;;)
    {
      Object localObject3 = getActivity().getPackageManager();
      try
      {
        localObject3 = ((PackageManager)localObject3).getPackageInfo((String)localObject1, 519);
        if ((localObject3 == null) || (!((PackageInfo)localObject3).applicationInfo.enabled))
        {
          localObject1 = "com.sec.android.widgetapp.SPlannerAppWidget";
          localObject2 = "com.sec.android.widgetapp.SPlannerAppWidget.AgendaWidget.CalendarAppWidgetProvider";
        }
        localObject3 = new ComponentName((String)localObject1, (String)localObject2);
        AppWidgetManager.getInstance(getActivity()).bindAppWidgetIdIfAllowed(k, (ComponentName)localObject3);
        localWorkspace.changeState(Workspace.State.NORMAL, false, 0, null);
        localWorkspace.exitWidgetResizeMode();
        if (k == -1)
        {
          return null;
          localObject1 = "com.android.chrome";
          localObject2 = "com.google.android.apps.chrome.appwidget.bookmarks.BookmarkThumbnailWidgetProvider";
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Object localObject4;
        for (;;)
        {
          localObject4 = null;
        }
        AppWidgetProviderInfo localAppWidgetProviderInfo = new AppWidgetProviderInfo();
        new ArrayList();
        List localList = this.mAppWidgetManager.getInstalledProviders();
        int i = 0;
        for (;;)
        {
          localObject4 = localAppWidgetProviderInfo;
          if (i < localList.size())
          {
            if ((((AppWidgetProviderInfo)localList.get(i)).provider.getPackageName().equals(localObject1)) && (((AppWidgetProviderInfo)localList.get(i)).provider.getClassName().equals(localObject2))) {
              localObject4 = (AppWidgetProviderInfo)localList.get(i);
            }
          }
          else
          {
            localObject1 = new HomeWidgetItem((AppWidgetProviderInfo)localObject4, k);
            ((HomeWidgetItem)localObject1).mScreen = (j - 1);
            ((HomeWidgetItem)localObject1).cellX = arrayOfInt[0];
            ((HomeWidgetItem)localObject1).cellY = arrayOfInt[1];
            ((HomeWidgetItem)localObject1).spanX = 3;
            ((HomeWidgetItem)localObject1).spanY = 3;
            if ((((HomeWidgetItem)localObject1).hostView != null) && (((HomeWidgetItem)localObject1).hostView.getParent() == null)) {
              break label452;
            }
            if (this.mAppWidgetHost != null) {
              break;
            }
            return null;
          }
          i += 1;
        }
        ((HomeWidgetItem)localObject1).hostView = this.mAppWidgetHost.createView(getActivity(), k, (AppWidgetProviderInfo)localObject4);
        ((HomeWidgetItem)localObject1).hostView.setAppWidget(k, (AppWidgetProviderInfo)localObject4);
        ((HomeWidgetItem)localObject1).hostView.setTag(localObject1);
        localObject2 = this.mSpanCalculator.getPaddingForWidget(((AppWidgetProviderInfo)localObject4).provider);
        ((HomeWidgetItem)localObject1).hostView.setPadding(((WorkspaceSpanCalculator.Padding)localObject2).left, ((WorkspaceSpanCalculator.Padding)localObject2).top, ((WorkspaceSpanCalculator.Padding)localObject2).right, ((WorkspaceSpanCalculator.Padding)localObject2).bottom);
        label452:
        ((HomeWidgetItem)localObject1).hostView.setBackgroundColor(16777216);
        LauncherModel.addItemToDatabase(getActivity(), (HomeItem)localObject1, -100L, ((HomeWidgetItem)localObject1).mScreen, ((HomeWidgetItem)localObject1).cellX, ((HomeWidgetItem)localObject1).cellY, false);
        ((LauncherAppWidgetHostView)((HomeWidgetItem)localObject1).hostView).mLastTouch[0] = 222;
        ((LauncherAppWidgetHostView)((HomeWidgetItem)localObject1).hostView).mLastTouch[0] = 275;
        localWorkspace.addItem((HomeItem)localObject1);
      }
    }
    return (HomeWidgetItem)localObject1;
  }
  
  public void addAppWidgetFromDrop(final HomePendingWidget paramHomePendingWidget)
  {
    this.mAppWidgetBinder.allocateBindNew(paramHomePendingWidget.componentName, new AppWidgetBinder.Callback()
    {
      public void onBindFail()
      {
        Log.e("Launcher.HomeView", "Problem binding widget. This should only happen when installed outside of /system/app and user declined authorization.");
        Toast.makeText(HomeView.this.getActivity(), "Not installed with permissions needed for binding widgets and authoization declined", 0).show();
      }
      
      public void onBindSuccess(int paramAnonymousInt)
      {
        HomeView.this.addAppWidgetImpl(paramAnonymousInt, paramHomePendingWidget);
      }
    });
  }
  
  void addAppWidgetFromPick(Intent paramIntent)
  {
    addAppWidgetImpl(paramIntent.getIntExtra("appWidgetId", -1), null);
  }
  
  public void addHelpAppPage()
  {
    if (this.isHelpAppPageAdded) {
      return;
    }
    this.screenIndexBeforeHelpAppPageAddition = this.mWorkspace.getCurrentPage();
    this.screenIndexFestivalHelpAppPageAddition = (getNumPages() - getNumFestivalPages());
    if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn)) {
      this.mWorkspace.insertWorkspaceScreen(this.screenIndexFestivalHelpAppPageAddition, false);
    }
    for (;;)
    {
      this.isHelpAppPageDeleted = false;
      this.isHelpAppPageAdded = true;
      this.mWorkspace.hidePageIndicator(true);
      this.mWorkspace.disableRollNavigation();
      if ((!LauncherApplication.sFestivalPageLauncher) || (!Launcher.sIsFestivalModeOn)) {
        break;
      }
      this.mWorkspace.setCurrentPage(this.screenIndexFestivalHelpAppPageAddition);
      return;
      addPage();
    }
    this.mWorkspace.setCurrentPage(getNumPages() - 1);
  }
  
  public void addItemToHomeScreen()
  {
    if (this.mIsHelpItemAdded) {}
    Workspace localWorkspace;
    do
    {
      return;
      localWorkspace = this.mWorkspace;
    } while (localWorkspace == null);
    this.mIsHelpItemAdded = true;
    addHelpAppPage();
    this.mWorkspace.disableRollNavigation();
    int[] arrayOfInt = new int[2];
    int[] tmp40_38 = arrayOfInt;
    tmp40_38[0] = 1;
    int[] tmp44_40 = tmp40_38;
    tmp44_40[1] = 1;
    tmp44_40;
    Object localObject1 = new ComponentName("com.sec.android.app.popupcalculator", "com.sec.android.app.popupcalculator.Calculator");
    Object localObject2 = getActivity().getPackageManager();
    try
    {
      localObject2 = ((PackageManager)localObject2).getPackageInfo("com.sec.android.app.popupcalculator", 519);
      if ((localObject2 == null) || (!((PackageInfo)localObject2).applicationInfo.enabled)) {
        localObject1 = new ComponentName("com.samsung.helphub", "com.samsung.helphub.HelpHubActivity");
      }
      Object localObject4 = new AppItem((ComponentName)localObject1, false);
      localObject2 = new Intent();
      ((Intent)localObject2).setComponent((ComponentName)localObject1);
      ((AppItem)localObject4).makeHomeItem();
      localObject1 = new HomeShortcutItem(BaseItem.Type.HOME_APPLICATION);
      localObject4 = new PkgResCache.TitleIconInfo();
      this.mPkgResCache.getTitleAndIcon((PkgResCache.TitleIconInfo)localObject4, (Intent)localObject2);
      ((HomeShortcutItem)localObject1).mIconBitmap = ((PkgResCache.TitleIconInfo)localObject4).mIcon;
      ((HomeShortcutItem)localObject1).mTitle = ((PkgResCache.TitleIconInfo)localObject4).mTitle;
      ((HomeShortcutItem)localObject1).cellX = 0;
      ((HomeShortcutItem)localObject1).cellY = 0;
      ((HomeShortcutItem)localObject1).container = -100L;
      ((HomeShortcutItem)localObject1).spanX = arrayOfInt[0];
      ((HomeShortcutItem)localObject1).spanY = arrayOfInt[1];
      ((HomeShortcutItem)localObject1).intent = ((Intent)localObject2);
      ((HomeShortcutItem)localObject1).mScreen = (getNumPages() - 1);
      LauncherModel.addItemToDatabase(getActivity(), (HomeItem)localObject1, -100L, ((HomeShortcutItem)localObject1).mScreen, ((HomeShortcutItem)localObject1).cellX, ((HomeShortcutItem)localObject1).cellY, false);
      localWorkspace.addItem((HomeItem)localObject1);
      localWorkspace.setDataIsReady();
      localWorkspace.invalidatePageData();
      localWorkspace.hidePageIndicator(false);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Object localObject3 = null;
      }
    }
  }
  
  public void addPage()
  {
    int i = 0;
    CellLayout localCellLayout = (CellLayout)LayoutInflater.from(getActivity()).inflate(2130903131, this.mWorkspace, false);
    localCellLayout.setOnLongClickListener(this);
    ViewGroup.LayoutParams localLayoutParams2 = localCellLayout.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
    }
    if (((Launcher)getActivity()).getShowEmptyPageMessagePref()) {}
    for (;;)
    {
      if (this.mWorkspace != null) {
        this.mWorkspace.addView(localCellLayout, localLayoutParams1);
      }
      localCellLayout.setEmptyMessageVisibility(i);
      WorkspacePages.addPageAt(getNumPages() - 1, getActivity());
      saveScreenInfo();
      return;
      i = 8;
    }
  }
  
  public boolean addSamsungWidgetFromDrop(HomePendingSamsungWidget paramHomePendingSamsungWidget)
  {
    try
    {
      boolean bool = addSamsungWidget(paramHomePendingSamsungWidget);
      return bool;
    }
    catch (SecurityException paramHomePendingSamsungWidget)
    {
      Log.e("Launcher.HomeView", "Problem binding samsung widget. This should only happen when running in a separate process", paramHomePendingSamsungWidget);
      Toast.makeText(getActivity(), "Widget is not running in the same process", 0).show();
    }
    return false;
  }
  
  public void addShortcutItemsIntoExistingFolder(List<HomeShortcutItem> paramList)
  {
    Activity localActivity = getActivity();
    HomeFolderItem localHomeFolderItem = getFolderById(this.mTargetFolderId);
    if (localHomeFolderItem != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        HomeShortcutItem localHomeShortcutItem = (HomeShortcutItem)paramList.next();
        LauncherModel.addOrMoveItemInDatabase(localActivity, localHomeShortcutItem, localHomeFolderItem.mId, localHomeFolderItem.getItemCount(), 0, 0, localHomeShortcutItem.spanX, localHomeShortcutItem.spanY);
        localHomeFolderItem.addItem(localHomeShortcutItem);
      }
      setDestinationNewFolderId(-1L);
    }
  }
  
  public void addShortcutItemsIntoNewFolder(List<HomeShortcutItem> paramList)
  {
    Activity localActivity = getActivity();
    HomeFolderItem localHomeFolderItem = getFolderById(mDestinationNewFolderId);
    if (localHomeFolderItem != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        HomeShortcutItem localHomeShortcutItem = (HomeShortcutItem)paramList.next();
        LauncherModel.addOrMoveItemInDatabase(localActivity, localHomeShortcutItem, localHomeFolderItem.mId, localHomeFolderItem.getItemCount(), 0, 0, localHomeShortcutItem.spanX, localHomeShortcutItem.spanY);
        localHomeFolderItem.addItem(localHomeShortcutItem);
      }
      this.mWorkspace.snapToPage(localHomeFolderItem.mScreen);
      setDestinationNewFolderId(-1L);
    }
  }
  
  public boolean addSurfaceWidgetFromDrop(HomePendingSurfaceWidget paramHomePendingSurfaceWidget)
  {
    try
    {
      boolean bool = addSurfaceWidget(paramHomePendingSurfaceWidget);
      return bool;
    }
    catch (SecurityException paramHomePendingSurfaceWidget)
    {
      Log.e("Launcher.HomeView", "Problem binding surface widget. This should only happen when running in a separate process", paramHomePendingSurfaceWidget);
      Toast.makeText(getActivity(), "Widget is not running in the same process", 0).show();
    }
    return false;
  }
  
  public void addWidgetFromIntent(final HomeWidgetItem paramHomeWidgetItem)
  {
    this.mAppWidgetBinder.allocateBindNew(paramHomeWidgetItem.getComponentName(), new AppWidgetBinder.Callback()
    {
      public void onBindFail()
      {
        Log.e("Launcher.HomeView", "Problem binding widget. This should only happen when installed outside of /system/app and user declined authorization.");
        Toast.makeText(HomeView.this.getActivity(), "Not installed with permissions needed for binding widgets and authoization declined", 0).show();
      }
      
      public void onBindSuccess(int paramAnonymousInt)
      {
        AppWidgetProviderInfo localAppWidgetProviderInfo = HomeView.this.mAppWidgetManager.getAppWidgetInfo(paramAnonymousInt);
        if ((paramHomeWidgetItem == null) || (localAppWidgetProviderInfo == null)) {}
        HomeWidgetItem localHomeWidgetItem;
        int i;
        do
        {
          return;
          localHomeWidgetItem = new HomeWidgetItem(localAppWidgetProviderInfo, paramAnonymousInt, true);
          localHomeWidgetItem.container = paramHomeWidgetItem.container;
          localHomeWidgetItem.mScreen = paramHomeWidgetItem.mScreen;
          localHomeWidgetItem.spanX = paramHomeWidgetItem.spanX;
          localHomeWidgetItem.spanY = paramHomeWidgetItem.spanY;
          localHomeWidgetItem.cellX = paramHomeWidgetItem.cellX;
          localHomeWidgetItem.cellY = paramHomeWidgetItem.cellY;
          localHomeWidgetItem.mSecretItem = paramHomeWidgetItem.mSecretItem;
          if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn)) {
            localHomeWidgetItem.mFestivalType = paramHomeWidgetItem.mFestivalType;
          }
          LauncherModel.addItemToDatabase(HomeView.this.getActivity(), localHomeWidgetItem, localHomeWidgetItem.container, localHomeWidgetItem.mScreen, localHomeWidgetItem.cellX, localHomeWidgetItem.cellY, false);
          i = paramHomeWidgetItem.mScreen;
        } while (HomeView.this.mRestoring);
        localHomeWidgetItem.hostView = HomeView.this.mAppWidgetHost.createView(HomeView.this.getActivity(), paramAnonymousInt, localAppWidgetProviderInfo);
        localHomeWidgetItem.hostView.setAppWidget(paramAnonymousInt, localAppWidgetProviderInfo);
        localHomeWidgetItem.hostView.setTag(localHomeWidgetItem);
        Object localObject = HomeView.this.mSpanCalculator.getPaddingForWidget(localAppWidgetProviderInfo.provider);
        localHomeWidgetItem.hostView.setPadding(((WorkspaceSpanCalculator.Padding)localObject).left, ((WorkspaceSpanCalculator.Padding)localObject).top, ((WorkspaceSpanCalculator.Padding)localObject).right, ((WorkspaceSpanCalculator.Padding)localObject).bottom);
        localObject = (CellLayout)HomeView.this.mWorkspace.getPageAt(i);
        localHomeWidgetItem.hostView.setBackgroundColor(16777216);
        HomeView.this.mWorkspace.addItem(localHomeWidgetItem);
        HomeView.this.addWidgetToAutoAdvanceIfNeeded(localHomeWidgetItem.hostView, localAppWidgetProviderInfo);
      }
    });
  }
  
  void addWidgetToAutoAdvanceIfNeeded(View paramView, AppWidgetProviderInfo paramAppWidgetProviderInfo)
  {
    if ((paramAppWidgetProviderInfo == null) || (paramAppWidgetProviderInfo.autoAdvanceViewId == -1)) {}
    View localView;
    do
    {
      return;
      localView = paramView.findViewById(paramAppWidgetProviderInfo.autoAdvanceViewId);
    } while (!(localView instanceof Advanceable));
    this.mWidgetsToAdvance.put(paramView, paramAppWidgetProviderInfo);
    ((Advanceable)localView).fyiWillBeAdvancedByHostKThx();
    updateRunning();
  }
  
  public void bindAppWidget(HomeWidgetItem paramHomeWidgetItem)
  {
    Object localObject1 = this.mWorkspace;
    Object localObject2;
    if ((paramHomeWidgetItem.spanX > ((Workspace)localObject1).mCellCountX) || (paramHomeWidgetItem.spanY > ((Workspace)localObject1).mCellCountY))
    {
      Log.e("Launcher.HomeView", "Attempted to bind a widget larger than what will fit. Removing.");
      if (Utilities.DEBUGGABLE())
      {
        localObject1 = new Date(System.currentTimeMillis());
        localObject1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format((Date)localObject1);
        localObject2 = ((LauncherApplication)((Activity)getContext()).getApplication()).getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
        ((SharedPreferences.Editor)localObject2).putString("delelteFrombindAppWidget", paramHomeWidgetItem.getPackageName().toString() + ", time : " + (String)localObject1);
        ((SharedPreferences.Editor)localObject2).commit();
      }
      LauncherModel.deleteItemFromDatabase(getActivity(), paramHomeWidgetItem);
    }
    int i;
    do
    {
      do
      {
        return;
      } while (paramHomeWidgetItem.appWidgetId == -1);
      i = paramHomeWidgetItem.appWidgetId;
      localObject2 = this.mAppWidgetManager.getAppWidgetInfo(i);
      if (localObject2 != null) {
        break;
      }
    } while (!DEBUGGABLE);
    Log.d("Launcher.HomeView", "App widget info is null. AppWidgetID = " + i);
    return;
    if ((paramHomeWidgetItem.hostView == null) || (paramHomeWidgetItem.hostView.getParent() != null))
    {
      if (this.mAppWidgetHost == null)
      {
        Log.w("Launcher.HomeView", "mAppWidgetHost is null. Was HomeView.onDetachedFromWindow() called previously?");
        return;
      }
      paramHomeWidgetItem.hostView = this.mAppWidgetHost.createView(getActivity(), i, (AppWidgetProviderInfo)localObject2);
      paramHomeWidgetItem.hostView.setAppWidget(i, (AppWidgetProviderInfo)localObject2);
      paramHomeWidgetItem.hostView.setTag(paramHomeWidgetItem);
      if ((paramHomeWidgetItem.getComponentName().equals(Workspace.GOOGLE_SEARCH_WIDGET)) && (paramHomeWidgetItem.mScreen == LauncherApplication.getHomeScreenIndex())) {
        ((Launcher)getContext()).setEnableHotWord(true);
      }
      localObject2 = this.mSpanCalculator.getPaddingForWidget(((AppWidgetProviderInfo)localObject2).provider);
      paramHomeWidgetItem.hostView.setPadding(((WorkspaceSpanCalculator.Padding)localObject2).left, ((WorkspaceSpanCalculator.Padding)localObject2).top, ((WorkspaceSpanCalculator.Padding)localObject2).right, ((WorkspaceSpanCalculator.Padding)localObject2).bottom);
      this.mSpanCalculator.updateWidgetSizeRanges(paramHomeWidgetItem.hostView, (Launcher)getActivity(), paramHomeWidgetItem.spanX, paramHomeWidgetItem.spanY);
    }
    paramHomeWidgetItem.hostView.setBackgroundColor(16777216);
    ((Workspace)localObject1).addItem(paramHomeWidgetItem);
  }
  
  public void bindFolders(Map<Long, HomeFolderItem> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.values().iterator();
    while (localIterator.hasNext()) {
      ((HomeFolderItem)localIterator.next()).normalize(localArrayList);
    }
    sFolders.clear();
    sFolders.putAll(paramMap);
    if (!localArrayList.isEmpty()) {
      LauncherModel.moveItemsInDatabase(getContext(), localArrayList);
    }
    if (!restoreOpenFolder(this.mFolderBundle))
    {
      if (this.mHomeDarkenLayer != null) {
        this.mHomeDarkenLayer.setVisibility(8);
      }
      if (this.mHomeContainer != null) {
        this.mHomeContainer.setAlpha(1.0F);
      }
    }
  }
  
  public void bindHomeDeleteFestivalPage()
  {
    int k = this.mWorkspace.getCurrentPage();
    int j;
    for (int i = 0; i < this.mWorkspace.getChildCount(); i = j + 1)
    {
      j = i;
      if (((CellLayout)this.mWorkspace.getChildAt(i)).getPageType() == 2)
      {
        Log.d("Launcher.HomeView", "bindHomeDeleteFestivalPage : " + i);
        deletePage(i);
        j = i - 1;
      }
    }
    if (k >= this.mWorkspace.getChildCount()) {
      this.mWorkspace.setCurrentPage(LauncherApplication.getHomeScreenIndex());
    }
  }
  
  public void bindHomeDeleteSecretPage()
  {
    int k = this.mWorkspace.getCurrentPage();
    int j;
    for (int i = 0; i < this.mWorkspace.getChildCount(); i = j + 1)
    {
      CellLayout localCellLayout = (CellLayout)this.mWorkspace.getChildAt(i);
      j = i;
      if (localCellLayout.getPageType() == 1)
      {
        this.mWorkspace.removeView(localCellLayout);
        WorkspacePages.deletePageAt(i, getContext());
        j = i - 1;
      }
    }
    if (k < LauncherApplication.getSecretScreenCount())
    {
      i = LauncherApplication.getHomeScreenIndex();
      this.mWorkspace.setCurrentPage(i);
      return;
    }
    this.mWorkspace.setCurrentPage(k - LauncherApplication.getSecretScreenCount());
  }
  
  public void bindHomeInsertFestivalPage()
  {
    FestivalPageManager localFestivalPageManager = ((Launcher)getActivity()).getFestivalPageManager();
    String str = FestivalPageManager.getFestivalString();
    if ((str == null) || (str.isEmpty())) {
      return;
    }
    String[] arrayOfString = str.split(";");
    int m = LauncherApplication.getScreenCount();
    int j = LauncherApplication.getMaxFestivalScreenCount();
    int k = arrayOfString.length;
    if (DEBUGGABLE) {
      Log.d("Launcher.HomeView", "bindHomeInsertFestivalPage toBeCount : " + arrayOfString.length + " festivalDayList : " + str);
    }
    int i = k;
    if (k > j) {
      i = j;
    }
    j = 0;
    for (;;)
    {
      if ((j >= i) || (arrayOfString[j] == null))
      {
        Log.d("Launcher.HomeView", "bindHomeInsertFestivalPage currentPageCount [ " + m);
        this.mWorkspace.setCurrentPage(m);
        return;
      }
      k = m + j;
      int n = FestivalPageManager.getFestivalType(arrayOfString[j]);
      this.mWorkspace.insertWorkspaceFestivalScreen(k, n, false);
      localFestivalPageManager.bindFestivalWidget(this.mAppWidgetBinder, k, 1, arrayOfString[j]);
      localFestivalPageManager.bindFestivalWidget(this.mAppWidgetBinder, k, 2, arrayOfString[j]);
      localFestivalPageManager.bindFestivalWidget(this.mAppWidgetBinder, k, 3, arrayOfString[j]);
      Log.d("Launcher.HomeView", "bindHomeInsertFestivalPage festivalName [ " + j + " ]  = " + arrayOfString[j] + " fesivalKey : " + n);
      j += 1;
    }
  }
  
  public void bindHomeInsertSecretPage()
  {
    int j = LauncherApplication.getSecretScreenCount();
    int i = 0;
    while (i < j)
    {
      this.mWorkspace.insertWorkspaceSecretScreen(i, true, false);
      i += 1;
    }
    if (j > 0) {
      this.mWorkspace.setCurrentPage(0);
    }
  }
  
  public void bindHomeItemsRemoved(List<HomeItem> paramList)
  {
    if (this.mWorkspace != null) {
      this.mWorkspace.removeItems(paramList);
    }
  }
  
  public void bindHomeItemsUpdated(List<HomeItem> paramList, boolean paramBoolean)
  {
    if (this.mWorkspace != null) {
      this.mWorkspace.updateShortcutsAndSurfaceWidgets(paramList, paramBoolean);
    }
  }
  
  public void bindHotseat(List<HomeItem> paramList)
  {
    if (this.mHotseat == null) {
      return;
    }
    Hotseat.normalizeContents(getContext(), paramList);
    this.mHotseat.mContent.removeAllItems();
    this.mHotseat.mContent.beginBind(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      HomeItem localHomeItem = (HomeItem)localIterator.next();
      if (localHomeItem.mScreen < 0) {
        localHomeItem.mScreen = this.mHotseat.getOrderInHotseat(localHomeItem.cellX, localHomeItem.cellY);
      }
      localHomeItem.cellX = this.mHotseat.getCellXFromOrder(localHomeItem.mScreen);
      localHomeItem.cellY = this.mHotseat.getCellYFromOrder(localHomeItem.mScreen, paramList.size());
      this.mHotseat.addItem(localHomeItem);
    }
    this.mHotseat.mContent.endBind();
  }
  
  public void bindItems(List<HomeItem> paramList, int paramInt1, int paramInt2)
  {
    Workspace localWorkspace = this.mWorkspace;
    if (localWorkspace == null) {
      return;
    }
    if (paramInt1 < paramInt2)
    {
      HomeItem localHomeItem = (HomeItem)paramList.get(paramInt1);
      if (localHomeItem.container == -101L) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        switch (localHomeItem.mType)
        {
        default: 
          break;
        case ???: 
        case ???: 
        case ???: 
          localWorkspace.addItem(localHomeItem);
        }
      }
    }
    localWorkspace.setDataIsReady();
    localWorkspace.invalidatePageData();
  }
  
  public void bindSamsungWidget(SamsungWidgetItem paramSamsungWidgetItem)
  {
    Workspace localWorkspace = this.mWorkspace;
    ComponentName localComponentName = paramSamsungWidgetItem.intent.getComponent();
    SamsungWidgetPackageManager localSamsungWidgetPackageManager = ((Launcher)getActivity()).getSamsungWidgetPackageManager();
    SamsungWidgetProviderInfo localSamsungWidgetProviderInfo = localSamsungWidgetPackageManager.findWidget(localComponentName, paramSamsungWidgetItem.intent.getStringExtra("com.samsung.sec.android.SAMSUNG_WIDGET.themename"));
    if (localSamsungWidgetProviderInfo == null) {
      if (DEBUGGABLE) {
        Log.e("Launcher.HomeView", "Unable to find Samsung widget " + localComponentName.toString());
      }
    }
    do
    {
      return;
      localSamsungWidgetPackageManager.createWidget(getActivity(), localSamsungWidgetProviderInfo, paramSamsungWidgetItem);
      paramSamsungWidgetItem.mWidgetView.setTag(paramSamsungWidgetItem);
      paramSamsungWidgetItem.mWidgetView.setBackgroundColor(16777216);
      localWorkspace.addItem(paramSamsungWidgetItem);
    } while (paramSamsungWidgetItem.mScreen != getCurrentPage());
    paramSamsungWidgetItem.fireOnResume(getContext());
  }
  
  public void bindSurfaceWidget(SurfaceWidgetItem paramSurfaceWidgetItem)
  {
    Log.d("Launcher.HomeView", "bindSurfaceWidget: " + paramSurfaceWidgetItem);
    Workspace localWorkspace = this.mWorkspace;
    ComponentName localComponentName = paramSurfaceWidgetItem.getComponentName();
    SurfaceWidgetProviderInfo localSurfaceWidgetProviderInfo = SurfaceWidgetPackageManager.INST.findWidget(localComponentName, paramSurfaceWidgetItem.getThemName());
    if (localSurfaceWidgetProviderInfo == null) {
      Log.e("Launcher.HomeView", "Unable to find Surface widget " + localComponentName.toString());
    }
    do
    {
      do
      {
        return;
        Log.d("SurfaceWidgetFlow", "making surface widget for rebinding");
        paramSurfaceWidgetItem.makeSurfaceWidget(getActivity(), localSurfaceWidgetProviderInfo, null, true);
      } while (paramSurfaceWidgetItem.mWidgetView == null);
      localWorkspace.addItem(paramSurfaceWidgetItem);
    } while (paramSurfaceWidgetItem.mScreen != getCurrentPage());
    paramSurfaceWidgetItem.onResume();
  }
  
  public void bindWidgetsAfterConfigChange()
  {
    if (this.mWorkspace != null)
    {
      this.mWorkspace.changeOrientationExtras();
      this.mWorkspace.bindWidgetsAfterConfigChange();
    }
  }
  
  public void cancelClicksOnHome()
  {
    this.mWorkspace.cancelClicksOnChildrenForCurrentPage();
    if (this.mHotseat != null)
    {
      CellLayoutChildren localCellLayoutChildren = this.mHotseat.getLayout().getChildrenLayout();
      int i = 0;
      while (i < localCellLayoutChildren.getChildCount())
      {
        localCellLayoutChildren.getChildAt(i).cancelLongPress();
        i += 1;
      }
    }
  }
  
  void cancelRemovePage()
  {
    this.mIsDeletePopup = false;
    this.mQuickViewWorkspace.cancelDeleteView();
  }
  
  public void closeHomeScreenOptions()
  {
    if (isVisibleHomeOptionMenu()) {
      exitHomeOptionMenu();
    }
  }
  
  public void closeQuickViewWorkspace(boolean paramBoolean)
  {
    closeQuickViewWorkspace(paramBoolean, true);
  }
  
  public void closeQuickViewWorkspace(final boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mQuickViewWorkspace == null) || (!this.mQuickViewWorkspace.isOpened())) {
      return;
    }
    this.mQuickViewWorkspace.close(paramBoolean2);
    this.mWorkspace.setHideItems(false);
    this.mWorkspace.post(new Runnable()
    {
      public void run()
      {
        if (HomeView.this.mHomeTopBar != null)
        {
          HomeView.this.mHomeTopBar.setLayerType(0, Launcher.sViewLayerPaint);
          HomeView.this.mHomeTopBar.setAlpha(1.0F);
          if (paramBoolean1) {
            HomeView.this.mHomeTopBar.setVisibility(0);
          }
        }
        if ((HomeView.this.mHomeSearchBtn != null) && (paramBoolean1)) {
          HomeView.this.mHomeSearchBtn.setEnabled(true);
        }
        if ((HomeView.this.mHomeBottomBar != null) && (HomeView.this.removeHotseat)) {
          HomeView.this.mHomeBottomBar.setVisibility(0);
        }
        if (HomeView.this.mQuickLaunch != null)
        {
          HomeView.this.mQuickLaunch.setLayerType(0, Launcher.sViewLayerPaint);
          HomeView.this.mQuickLaunch.setAlpha(1.0F);
          HomeView.this.mQuickLaunch.setVisibility(0);
        }
        if ((HomeView.this.mQuickLaunchCamera != null) && (HomeView.this.mQuickLaunchCamera.isLandscape()))
        {
          HomeView.this.mQuickLaunchCamera.setLayerType(0, Launcher.sViewLayerPaint);
          HomeView.this.mQuickLaunchCamera.setAlpha(1.0F);
          HomeView.this.mQuickLaunchCamera.setVisibility(0);
        }
        if (paramBoolean1)
        {
          if ((HomeView.this.mWorkspace != null) && (HomeView.this.mWorkspace.getVisibility() != 0)) {
            HomeView.this.mWorkspace.setVisibility(0);
          }
          if (HomeView.this.mWorkspace != null) {
            HomeView.this.mWorkspace.invalidate();
          }
        }
      }
    });
    if (this.mHotseat != null)
    {
      this.mHotseat.setLayerType(0, Launcher.sViewLayerPaint);
      this.mHotseat.setAlpha(1.0F);
      this.mHotseat.animate().alpha(1.0F).setDuration(0L).start();
      this.mHotseat.setVisibility(0);
    }
    this.mWorkspace.setPageVisibility(getCurrentPage(), 0);
    this.mWorkspace.updateIndicatorWidth(false);
    this.mWorkspace.showPageIndicator(false);
    this.mWorkspace.updateVisiblePages();
    this.mWorkspace.resumeScreen(getCurrentPage());
    int i = 0;
    label152:
    if (i < this.mWorkspace.getChildCount()) {
      if (i != getCurrentPage()) {
        break label178;
      }
    }
    for (;;)
    {
      i += 1;
      break label152;
      break;
      label178:
      CellLayoutChildren localCellLayoutChildren = ((CellLayout)this.mWorkspace.getChildAt(i)).getChildrenLayout();
      int j = 0;
      while (j < localCellLayoutChildren.getChildCount())
      {
        View localView = localCellLayoutChildren.getChildAt(j);
        if ((localView instanceof SurfaceWidgetView)) {
          ((SurfaceWidgetView)localView).onVisibilityChanged(localView, 4);
        }
        j += 1;
      }
    }
  }
  
  void closeSystemDialogs(Boolean paramBoolean)
  {
    Object localObject = (Launcher)getContext();
    ((Launcher)localObject).getWindow().closeAllPanels();
    localObject = ((Launcher)localObject).getFragmentManager();
    AddToHomescreenDialogFragment.dismiss((FragmentManager)localObject);
    if ((!Launcher.isHelpAppRunning) && (paramBoolean.booleanValue())) {
      HomeScreenDialogFragment.dismiss((FragmentManager)localObject);
    }
    if (HomescreenWallpaperOptionsDialogFragment.isHomeScreenWallpaperDialogVisible) {
      HomescreenWallpaperOptionsDialogFragment.dismiss((FragmentManager)localObject);
    }
    DeleteWorkscreenDialogFragment.dismiss((FragmentManager)localObject);
    this.mWaitingForResult = false;
  }
  
  public void collectExitAllAppsAnimators(ArrayList<Animator> paramArrayList)
  {
    Animator localAnimator = AnimatorInflater.loadAnimator(getActivity(), 2131034117);
    localAnimator.setTarget(this);
    localAnimator.addListener(this);
    paramArrayList.add(localAnimator);
    setPivotX(getWidth() / 2.0F);
    setPivotY(0.0F);
  }
  
  public void collectShowAllAppsAnimators(ArrayList<Animator> paramArrayList)
  {
    Animator localAnimator = AnimatorInflater.loadAnimator(getActivity(), 2131034120);
    localAnimator.setTarget(this);
    localAnimator.addListener(this);
    paramArrayList.add(localAnimator);
    setPivotX(getWidth() / 2.0F);
    setPivotY(0.0F);
  }
  
  void completeAddFolderWithShortcutItem(HomeShortcutItem paramHomeShortcutItem, String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Activity localActivity = getActivity();
    Object localObject1;
    int i;
    int j;
    int k;
    label99:
    label116:
    int m;
    HomeFolderItem localHomeFolderItem;
    if ((paramHomeShortcutItem == null) || (paramBoolean2) || (paramHomeShortcutItem.mScreen == -1) || (paramHomeShortcutItem.cellX == -1) || (paramHomeShortcutItem.cellY == -1))
    {
      localObject1 = new DropPos();
      if (!findEmptySpanOnHomeScreen(this.mTmpAddItemCellCoordinates, -1, localActivity, (DropPos)localObject1, 1, 1, false))
      {
        showNoRoomAnyPageMessage(getContext());
        return;
      }
      paramLong = -100L;
      i = ((DropPos)localObject1).mScreen;
      j = ((DropPos)localObject1).mCellX;
      k = ((DropPos)localObject1).mCellY;
      if (paramLong != -101L) {
        break label438;
      }
      localObject1 = this.mHotseat.getLayout();
      m = 0;
      if (localObject1 != null)
      {
        localHomeFolderItem = new HomeFolderItem();
        localHomeFolderItem.mIconBitmap = this.mPkgResCache.getFolderIcon();
        localHomeFolderItem.viewForThisHasSeenLightOfDayBefore = false;
        LauncherModel.addItemToDatabase(localActivity, localHomeFolderItem, paramLong, i, j, k, false);
        localHomeFolderItem.setTitle(localActivity, paramString);
        localHomeFolderItem.setFolderColor(this.mCreateFolderColor);
        if (paramHomeShortcutItem != null) {
          if (paramBoolean1)
          {
            if (paramHomeShortcutItem.container != -101L) {
              break label455;
            }
            paramString = this.mHotseat.getLayout();
          }
        }
      }
    }
    for (;;)
    {
      if (paramString != null) {
        paramString.removeItem(paramHomeShortcutItem);
      }
      setDestinationNewFolderId(localHomeFolderItem.mId);
      LauncherModel.addOrMoveItemInDatabase(localActivity, paramHomeShortcutItem, localHomeFolderItem.mId, 0, 0, 0, paramHomeShortcutItem.spanX, paramHomeShortcutItem.spanY);
      localHomeFolderItem.addItem(paramHomeShortcutItem);
      if ((paramLong == -100L) && (i != this.mWorkspace.getCurrentPage())) {
        this.mWorkspace.snapToPage(i);
      }
      ((CellLayout)localObject1).addItem(localHomeFolderItem);
      i = 1;
      m = i;
      if (paramLong == -100L)
      {
        ((CellLayout)localObject1).mPositioner.addDelta(new PositionDelta(localHomeFolderItem));
        m = i;
      }
      if (m == 0) {
        showOutOfSpaceMessage();
      }
      if (!Launcher.isHelpAppRunning) {
        break label558;
      }
      if (!GuideFragment.GMode.equals("create_folder")) {
        break;
      }
      GuideFragment.isGuideCompleted = true;
      Toast.makeText(this.mWorkspace.getContext(), 2131755180, 1).show();
      mIsAllAppsButtonDisable = true;
      HomeEditBar.isfolderCreated = false;
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          GuideFragment.showCompleteDialog(HomeView.this.getActivity());
          HomeView.mIsAllAppsButtonDisable = false;
        }
      }, 900L);
      return;
      paramLong = paramHomeShortcutItem.container;
      i = paramHomeShortcutItem.mScreen;
      j = paramHomeShortcutItem.cellX;
      k = paramHomeShortcutItem.cellY;
      break label99;
      label438:
      localObject1 = (CellLayout)this.mWorkspace.getChildAt(i);
      break label116;
      label455:
      if (paramHomeShortcutItem.container == -100L)
      {
        paramString = (CellLayout)this.mWorkspace.getChildAt(i);
      }
      else
      {
        Object localObject2 = null;
        paramString = getFolderById(paramHomeShortcutItem.container);
        if (paramString != null)
        {
          paramString.removeItem(paramHomeShortcutItem);
          paramString = (String)localObject2;
        }
        else
        {
          paramString = (String)localObject2;
          if (DEBUGGABLE)
          {
            Log.e("Launcher.HomeView", "completeAddFolderWithShortcutItem. removeItem is true but container " + paramHomeShortcutItem.container + " is unknown");
            paramString = (String)localObject2;
          }
        }
      }
    }
    label558:
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        Talk.INSTANCE.say(2131755208);
      }
    }, 300L);
  }
  
  public void completeAddShortcut(HomeShortcutItem paramHomeShortcutItem, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2;
    Object localObject3;
    int i;
    int j;
    Object localObject1;
    if (paramLong < 0L)
    {
      localObject2 = this.mTmpAddItemCellCoordinates;
      localObject3 = this.mPendingAddInfo.dropPos;
      i = paramInt1;
      j = i;
      if (Launcher.sIsSecretModeOn)
      {
        j = i;
        if (!paramHomeShortcutItem.mSecretItem) {
          j = i + LauncherApplication.getSecretScreenCount();
        }
      }
      localObject1 = reAddCreatedPageForDragIfNeeded(getCellLayout(paramLong, j), paramLong, j, paramHomeShortcutItem);
      i = 0;
      if (localObject1 != null) {
        if ((paramInt2 >= 0) && (paramInt3 >= 0))
        {
          localObject2[0] = paramInt2;
          localObject2[1] = paramInt3;
          paramInt2 = 1;
          paramInt3 = paramInt1;
          i = paramInt3;
          if (paramInt2 != 0) {
            break label257;
          }
          if (paramLong == -100L) {
            break label185;
          }
        }
      }
    }
    label185:
    label257:
    label331:
    label342:
    label557:
    label603:
    label623:
    label634:
    label638:
    do
    {
      boolean bool;
      do
      {
        return;
        paramInt2 = i;
        paramInt3 = paramInt1;
        if (localObject3 == null) {
          break;
        }
        if (((CellLayout)localObject1).findNearestVacantArea(localObject3[0], localObject3[1], 1, 1, (int[])localObject2) != null) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          paramInt3 = paramInt1;
          break;
        }
        paramInt3 = -1;
        paramInt2 = i;
        break;
        localObject3 = new DropPos();
        bool = findEmptySpanOnHomeScreen((int[])localObject2, paramInt3, getActivity(), (DropPos)localObject3, 1, 1, false);
        i = ((DropPos)localObject3).mScreen;
        localObject2[0] = ((DropPos)localObject3).mCellX;
        localObject2[1] = ((DropPos)localObject3).mCellY;
        if (!((DropPos)localObject3).mFoundInCurrentScreen) {
          showNoRoomAnyPageMessage(getContext());
        }
      } while (!bool);
      LauncherModel.addItemToDatabase(getActivity(), paramHomeShortcutItem, paramLong, i, localObject2[0], localObject2[1], false);
      if (!this.mRestoring)
      {
        if (paramLong != -101L) {
          break label342;
        }
        this.mHotseat.mContent.setItemLocation(paramHomeShortcutItem, localObject2[0], localObject2[1], paramHomeShortcutItem.spanX, paramHomeShortcutItem.spanY, i, paramLong);
        this.mHotseat.addItem(paramHomeShortcutItem);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((CellLayout)localObject1).commitDeltas();
          return;
          localObject2 = (CellLayout)this.mWorkspace.getPageAt(i);
          if (i == this.mWorkspace.getCurrentPage()) {
            break label623;
          }
          if (this.mWorkspace.mDefaultTransitionEffect != PagedView.TransitionEffect.CARD) {
            break label603;
          }
          this.mWorkspace.setContentIsRefreshable(true);
          this.mWorkspace.snapToPage(i);
          this.mWorkspace.addItem(paramHomeShortcutItem);
          this.mWorkspace.invalidatePageData(i, false);
          paramInt3 = this.mWorkspace.getPageCount();
          if (paramInt3 > 3)
          {
            j = 0;
            paramInt2 = paramInt3;
            paramInt1 = j;
            if (i == paramInt3 - 1)
            {
              paramInt1 = j;
              if (!Launcher.sIsHeadlinesAppEnable) {
                paramInt1 = 1;
              }
            }
            while (paramInt1 < i - 1)
            {
              this.mWorkspace.syncPageItems(paramInt1, false);
              paramInt1 += 1;
            }
            paramInt1 = paramInt2;
            if (i == 0)
            {
              paramInt1 = paramInt2;
              if (!Launcher.sIsHeadlinesAppEnable) {
                paramInt1 = paramInt3 - 1;
              }
            }
            paramInt2 = i + 2;
            while (paramInt2 < paramInt1)
            {
              this.mWorkspace.syncPageItems(paramInt2, false);
              paramInt2 += 1;
            }
          }
          this.mWorkspace.setContentIsRefreshable(false);
          if (((CellLayout)localObject2).mChildren.mItems.size() != 0) {
            break label634;
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if ((paramInt1 == 0) || (((CellLayout)localObject2).mChildren.mItems.size() == 0)) {
            break label638;
          }
          this.mWorkspace.turnOffEmptyPageMsg();
          break label331;
          break;
          this.mWorkspace.snapToPage(i);
          this.mWorkspace.addItem(paramHomeShortcutItem);
          break label557;
          this.mWorkspace.addItem(paramHomeShortcutItem);
          break label557;
        }
      }
      localObject1 = findItemById(paramLong);
    } while ((localObject1 == null) || (!(localObject1 instanceof HomeFolderItem)));
    ((HomeFolderItem)localObject1).addItem(paramHomeShortcutItem);
    LauncherModel.addItemToDatabase(getActivity(), paramHomeShortcutItem, paramLong, paramInt1, paramInt2, paramInt2, false);
  }
  
  View createFolder(HomeFolderItem paramHomeFolderItem, int paramInt, ViewGroup paramViewGroup)
  {
    paramHomeFolderItem.mIconBitmap = this.mPkgResCache.getFolderIcon();
    paramViewGroup = (FolderIconView)this.mInflater.inflate(paramInt, paramViewGroup, false);
    paramViewGroup.applyBaseItem(paramHomeFolderItem);
    paramViewGroup.setOnClickListener(this.mWorkspace);
    paramViewGroup.showBadge();
    return paramViewGroup;
  }
  
  View createShortcut(HomeShortcutItem paramHomeShortcutItem, int paramInt)
  {
    return createShortcut(paramHomeShortcutItem, AppIconView.getHomeIconLayout(paramHomeShortcutItem), (ViewGroup)this.mWorkspace.getChildAt(this.mWorkspace.getCurrentPage()));
  }
  
  View createShortcut(HomeShortcutItem paramHomeShortcutItem, int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = (AppIconView)this.mInflater.inflate(paramInt, paramViewGroup, false);
    paramViewGroup.applyBaseItem(paramHomeShortcutItem);
    paramViewGroup.setOnClickListener(this);
    if (paramHomeShortcutItem.mBadgeCount > 0) {
      paramViewGroup.showBadge();
    }
    if ((Launcher.isHelpAppRunning) && (!this.mWorkspace.mIsHelpOrientationChanged) && (!this.mWorkspaceLoading))
    {
      if (GuideFragment.GMode.equals("addapps"))
      {
        GuideFragment.isGuideCompleted = true;
        Toast.makeText(this.mWorkspace.getContext(), 2131755180, 0).show();
        mIsAllAppsButtonDisable = true;
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            HomeView.mIsAllAppsButtonDisable = false;
            GuideFragment.showCompleteDialog(HomeView.this.getActivity());
          }
        }, 2000L);
      }
      if (GuideFragment.GMode.equals("add_widgets")) {
        ((AddWidgetsGuider)new AddWidgetsGuider(getActivity())).dismissShowHelpDialog_step3();
      }
    }
    return paramViewGroup;
  }
  
  public void deletePage(int paramInt)
  {
    Object localObject2 = (CellLayout)this.mWorkspace.getPageAt(paramInt);
    Object localObject1 = ((CellLayout)localObject2).getChildrenLayout();
    int i;
    if (((CellLayout)localObject2).getPageType() == 1)
    {
      i = 1;
      if (((CellLayout)localObject2).getPageType() != 2) {
        break label87;
      }
    }
    label87:
    for (int j = 1;; j = 0)
    {
      k = ((CellLayoutChildren)localObject1).getChildCount() - 1;
      for (;;)
      {
        if (k < 0) {
          break label187;
        }
        localObject2 = ((CellLayoutChildren)localObject1).getChildAt(k);
        if (!(localObject2 instanceof Folder)) {
          break;
        }
        k -= 1;
      }
      i = 0;
      break;
    }
    localObject2 = (HomeItem)((View)localObject2).getTag();
    if ((localObject2 instanceof HomeWidgetItem))
    {
      HomeWidgetItem localHomeWidgetItem = (HomeWidgetItem)localObject2;
      LauncherAppWidgetHost localLauncherAppWidgetHost = this.mAppWidgetHost;
      if (localLauncherAppWidgetHost != null) {
        localLauncherAppWidgetHost.deleteAppWidgetId(localHomeWidgetItem.appWidgetId);
      }
    }
    for (;;)
    {
      LauncherModel.deleteItemFromDatabase(getActivity(), (HomeItem)localObject2);
      break;
      if ((localObject2 instanceof SurfaceWidgetItem))
      {
        Log.d("SurfaceWidgetFlow", "destroying surface widget with delete page");
        ((SurfaceWidgetItem)localObject2).destroyWidget(getActivity(), SurfaceWidgetPackageManager.INST, true);
      }
    }
    label187:
    localObject1 = new ArrayList();
    int m = this.mWorkspace.getPageCount();
    int k = 0;
    if (k < m)
    {
      if (k <= paramInt) {}
      for (;;)
      {
        k += 1;
        break;
        ((CellLayout)this.mWorkspace.getPageAt(k)).getChildrenLayout().updateChildrenToNewPage(k - 1, (List)localObject1);
      }
    }
    LauncherModel.moveItemsInDatabase(getActivity(), (List)localObject1);
    localObject1 = this.mWorkspace.getChildAt(paramInt);
    this.mWorkspace.removeView((View)localObject1);
    WorkspacePages.deletePageAt(paramInt, this.mWorkspace.getContext());
    paramInt = this.mWorkspace.getChildCount();
    if (paramInt <= this.mWorkspace.getCurrentPage()) {
      this.mWorkspace.setCurrentPage(paramInt - 1);
    }
    if (i != 0)
    {
      saveSecretScreenInfo();
      return;
    }
    if (j != 0)
    {
      saveFestivalScreenInfo();
      return;
    }
    saveScreenInfo();
  }
  
  public void deleteWidgetFestivalPage(List<HomeWidgetItem> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      HomeWidgetItem localHomeWidgetItem = (HomeWidgetItem)paramList.next();
      if (localHomeWidgetItem.mFestivalType > 0)
      {
        Log.d("Launcher.HomeView", "deleteWidgetIFestivalPage appWidgetId: " + localHomeWidgetItem.appWidgetId);
        if (this.mAppWidgetHost != null)
        {
          this.mAppWidgetHost.deleteAppWidgetId(localHomeWidgetItem.appWidgetId);
          LauncherModel.deleteItemFromDatabase(getActivity(), localHomeWidgetItem);
        }
      }
    }
    saveFestivalScreenInfo();
  }
  
  public boolean determineEmptyPageMsgVisibility(int paramInt)
  {
    return ((Launcher)getActivity()).getShowEmptyPageMessagePref() & WorkspacePages.pageHasAlwaysBeenEmpty(paramInt, getActivity());
  }
  
  public boolean dispatchDragEvent(DragEvent paramDragEvent)
  {
    if (Launcher.isInValidDragState(paramDragEvent)) {
      return false;
    }
    DragState localDragState;
    if (paramDragEvent.getLocalState() != null)
    {
      localDragState = (DragState)paramDragEvent.getLocalState();
      if (paramDragEvent.getAction() != 1) {
        break label57;
      }
      this.mShadow = localDragState.getShadow();
      sIsDragState = true;
    }
    for (;;)
    {
      return super.dispatchDragEvent(paramDragEvent);
      localDragState = Launcher.dragstate;
      break;
      label57:
      if (paramDragEvent.getAction() == 4)
      {
        this.mShadow = null;
        sIsDragState = false;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.println(" ");
    paramPrintWriter.println("Debug logs: ");
    int i = 0;
    while (i < sDumpLogs.size())
    {
      paramPrintWriter.println("  " + (String)sDumpLogs.get(i));
      i += 1;
    }
  }
  
  public void dumpState()
  {
    if (DEBUGGABLE)
    {
      Log.d("Launcher.HomeView", "BEGIN launcher2 dump state for launcher " + this);
      Log.d("Launcher.HomeView", "mSavedState=" + this.mSavedState);
      Log.d("Launcher.HomeView", "mWorkspaceLoading=" + this.mWorkspaceLoading);
      Log.d("Launcher.HomeView", "mRestoring=" + this.mRestoring);
      Log.d("Launcher.HomeView", "mWaitingForResult=" + this.mWaitingForResult);
      Log.d("Launcher.HomeView", "sFolders.size=" + sFolders.size());
      this.mModel.dumpState();
      Log.d("Launcher.HomeView", "END launcher2 dump state");
    }
  }
  
  public void exitHomeOptionMenu()
  {
    setVisibilityHomeOptionMenu(8);
    setVisibilityHotseat(0);
  }
  
  public HomeItem findItemById(long paramLong)
  {
    int i = 0;
    BaseItem localBaseItem;
    while (i < this.mWorkspace.getChildCount())
    {
      localIterator = ((CellLayout)this.mWorkspace.getChildAt(i)).getChildrenLayout().mItems.iterator();
      while (localIterator.hasNext())
      {
        localBaseItem = (BaseItem)localIterator.next();
        if (localBaseItem.mId == paramLong) {
          return (HomeItem)localBaseItem;
        }
      }
      i += 1;
    }
    Iterator localIterator = this.mHotseat.getLayout().getChildrenLayout().mItems.iterator();
    while (localIterator.hasNext())
    {
      localBaseItem = (BaseItem)localIterator.next();
      if (localBaseItem.mId == paramLong) {
        return (HomeItem)localBaseItem;
      }
    }
    return null;
  }
  
  public void finishBindingItems()
  {
    if (this.mWorkspace == null) {}
    do
    {
      do
      {
        return;
        if (this.mSavedState != null)
        {
          if ((!this.mWorkspace.hasFocus()) && (this.mWorkspace.isShown()) && (this.mWorkspace.getOpenFolder() == null))
          {
            localObject = this.mWorkspace.getChildAt(this.mWorkspace.getCurrentPage());
            if (localObject != null) {
              ((View)localObject).requestFocus();
            }
          }
          this.mSavedState = null;
        }
        this.mWorkspaceLoading = false;
        int i = 0;
        while (i < sPendingAddList.size())
        {
          completeAdd((PendingAddArguments)sPendingAddList.get(i));
          i += 1;
        }
        sPendingAddList.clear();
        if ((this.mQuickViewWorkspace != null) && (this.mQuickViewWorkspace.isOpened())) {
          this.mQuickViewWorkspace.invalidate();
        }
        ((Launcher)getActivity()).addAnyPendingWidgetsToWorkspace();
      } while (Settings.System.getInt(getActivity().getContentResolver(), "skt_phone20_settings", 0) != 1);
      localObject = ((LauncherApplication)getActivity().getApplication()).getSharedPreferences("com.sec.android.app.launcher.prefs", 0);
    } while (!((SharedPreferences)localObject).getBoolean("PrefsIsCSCLoad", false));
    Log.i("ChangeTphoneMode", "T phone and isCscLoad = true");
    ChangeTphoneMode();
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("PrefsIsCSCLoad", false);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public Activity getActivity()
  {
    return (Activity)getContext();
  }
  
  View getAllAppsIcon()
  {
    return null;
  }
  
  public LauncherAppWidgetHost getAppWidgetHost()
  {
    return this.mAppWidgetHost;
  }
  
  CellLayout getCellLayout(long paramLong, int paramInt)
  {
    if (paramLong == -101L)
    {
      if (this.mHotseat != null) {
        return this.mHotseat.getLayout();
      }
      return null;
    }
    return (CellLayout)this.mWorkspace.getChildAt(paramInt);
  }
  
  public void getCreateFolderColor(int paramInt)
  {
    this.mCreateFolderColor = paramInt;
  }
  
  public BaseItem getCurrentDragItem()
  {
    return this.mCurrentDragItem;
  }
  
  public int getCurrentPage()
  {
    if (this.mWorkspace != null) {
      return this.mWorkspace.getCurrentPage();
    }
    return -1;
  }
  
  public BaseItem getCurrentResizeWidgetItem()
  {
    return this.mCurrentResizeWidgetItem;
  }
  
  public View getDarkenView()
  {
    if ((this.mDarkenView == null) && (((Launcher)getActivity()).mAttached)) {
      this.mDarkenView = getActivity().findViewById(2131689617);
    }
    return this.mDarkenView;
  }
  
  public QuickViewDragBar getDeleteDropLayout()
  {
    return this.mDeleteDropLayout;
  }
  
  HomeEditBar getEditBar()
  {
    return this.mEditBar;
  }
  
  public View getGoogleSearchView()
  {
    return this.mGoogleSearchView;
  }
  
  View getHomeAppsBtn()
  {
    return this.mHomeAppsBtn;
  }
  
  public View getHomeBottomBar()
  {
    return this.mHomeBottomBar;
  }
  
  View getHomeContainer()
  {
    return this.mHomeContainer;
  }
  
  View getHomeDarkenLayer()
  {
    return this.mHomeDarkenLayer;
  }
  
  View getHomeEditBtn()
  {
    return this.mEditIcon;
  }
  
  ViewGroup getHomeEditTitleBar()
  {
    return this.mHomeEditTitleBar;
  }
  
  View getHomePhoneBtn()
  {
    return this.mHomePhoneBtn;
  }
  
  public HomeScreenOptionMenu getHomeScreenOptionMenu()
  {
    if (this.mHomeScreenOptionMenu == null) {
      this.mHomeScreenOptionMenu = ((HomeScreenOptionMenu)findViewById(2131689680));
    }
    return this.mHomeScreenOptionMenu;
  }
  
  Hotseat getHotseat()
  {
    return this.mHotseat;
  }
  
  public int getHotseatItemcount()
  {
    if (this.mHotseat != null) {
      return this.mHotseat.mContent.getChildrenLayout().getChildCount();
    }
    return 0;
  }
  
  public LauncherModel getLauncherModel()
  {
    return this.mModel;
  }
  
  public LauncherModel getModel()
  {
    return this.mModel;
  }
  
  public int getNumFestivalPages()
  {
    return LauncherApplication.getFestivalScreenCount();
  }
  
  public int getNumPages()
  {
    return this.mWorkspace.getChildCount();
  }
  
  public int getNumSecretPages()
  {
    return LauncherApplication.getSecretScreenCount();
  }
  
  public CellLayout getPage(int paramInt)
  {
    return (CellLayout)this.mWorkspace.getPageAt(paramInt);
  }
  
  public int getPageCount()
  {
    if (this.mWorkspace == null) {
      return 0;
    }
    return this.mWorkspace.getChildCount();
  }
  
  public int getPageHorizontalOffset()
  {
    return (this.mWorkspace.getWidth() - this.mWorkspace.getPageAt(0).getWidth()) / 2 + this.mWorkspace.getPageSpacing();
  }
  
  public void getPagesLocationOnScreen(int[] paramArrayOfInt)
  {
    this.mWorkspace.getLocationOnScreen(paramArrayOfInt);
  }
  
  public int getPagesTop()
  {
    return this.mWorkspace.getChildAt(0).getTop();
  }
  
  public float getPanelBackgroundAlpha()
  {
    return this.mPanelBackgroundAlpha;
  }
  
  public PkgResCache getPkgResCache()
  {
    return this.mPkgResCache;
  }
  
  QuickLaunch getQuickLaunch()
  {
    return this.mQuickLaunch;
  }
  
  QuickLaunch getQuickLaunchCamera()
  {
    return this.mQuickLaunchCamera;
  }
  
  QuickViewWorkspace getQuickViewWorkspace()
  {
    return this.mQuickViewWorkspace;
  }
  
  View getTopBar()
  {
    return this.mHomeTopBar;
  }
  
  Workspace getWorkspace()
  {
    return this.mWorkspace;
  }
  
  public boolean getWorkspaceLoading()
  {
    return this.mWorkspaceLoading;
  }
  
  public void goHomeOptionMenu()
  {
    showWorkspaceEditmode(true);
    setVisibilityHomeOptionMenu(0);
    setVisibilityHotseat(8);
  }
  
  public boolean handleResizeWidget()
  {
    boolean bool2 = false;
    Workspace localWorkspace = getWorkspace();
    boolean bool1 = bool2;
    if (Launcher.isHelpAppRunning)
    {
      bool1 = bool2;
      if (localWorkspace.getState() == Workspace.State.RESIZE)
      {
        bool1 = bool2;
        if (GuideFragment.sHelpHubStepNumber == 2)
        {
          bool1 = bool2;
          if (Workspace.widgetSizeChanged)
          {
            localWorkspace.exitWidgetResizeMode();
            if ("resize_widgets".equals(GuideFragment.GMode))
            {
              GuideFragment.isGuideCompleted = true;
              Toast.makeText(getContext(), 2131755202, 1).show();
              new Handler().postDelayed(new Runnable()
              {
                public void run()
                {
                  GuideFragment.showCompleteDialog(HomeView.this.getActivity());
                }
              }, 2000L);
            }
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void helpHubSnapToLastPage()
  {
    this.mWorkspace.setCurrentPage(getNumPages() - 1);
  }
  
  public void hideHomeBottomBar()
  {
    if ((this.mHomeBottomBar != null) && (this.mHomeBottomBar.getVisibility() == 0)) {
      this.mHomeBottomBar.setVisibility(8);
    }
    if ((LauncherApplication.isTabletLayout()) && (this.mHotseat != null) && (this.mHotseat.getVisibility() == 0)) {
      this.mHotseat.setVisibility(8);
    }
  }
  
  void hideHotseat(boolean paramBoolean)
  {
    if (this.mHotseat != null)
    {
      if (paramBoolean) {
        this.mHotseat.animate().alpha(0.0F).setDuration(175L);
      }
    }
    else {
      return;
    }
    this.mHotseat.setAlpha(0.0F);
  }
  
  public boolean isDeleteWorkScreenPopup()
  {
    return this.mIsDeletePopup;
  }
  
  public boolean isFolderPage(int paramInt)
  {
    return false;
  }
  
  boolean isHotseatLayout(View paramView)
  {
    return (this.mHotseat != null) && (paramView != null) && (paramView == this.mHotseat.getLayout());
  }
  
  public boolean isIncludeItem(int paramInt)
  {
    CellLayoutChildren localCellLayoutChildren = ((CellLayout)this.mWorkspace.getPageAt(paramInt)).getChildrenLayout();
    if (localCellLayoutChildren == null) {
      return false;
    }
    if (localCellLayoutChildren.getChildCount() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isVisible()
  {
    return getVisibility() == 0;
  }
  
  public boolean isVisibleHomeOptionMenu()
  {
    View localView = findViewById(2131689680);
    return (localView == null) || (localView.getVisibility() == 0);
  }
  
  public boolean isWorkspaceLocked()
  {
    return (this.mWorkspaceLoading) || (this.mWaitingForResult);
  }
  
  public void movePage(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    WorkspacePages.movePage(paramInt1, paramInt2, getActivity());
    int k = LauncherApplication.getHomeScreenIndex();
    ArrayList localArrayList = new ArrayList();
    int n = this.mWorkspace.getChildCount();
    int j = 0;
    if (j < n)
    {
      int i;
      if (j == paramInt1) {
        i = paramInt2;
      }
      for (;;)
      {
        label57:
        CellLayoutChildren localCellLayoutChildren = ((CellLayout)this.mWorkspace.getPageAt(j)).removeChildrenLayout();
        ((CellLayout)this.mWorkspace.getPageAt(i)).addChildrenLayout(localCellLayoutChildren, 0);
        localCellLayoutChildren.updateChildrenToNewPage(i, localArrayList);
        int m = k;
        if (k >= 0)
        {
          m = k;
          if (j == k)
          {
            setHomeScreenAt(i);
            m = -1;
          }
        }
        do
        {
          do
          {
            j += 1;
            k = m;
            break;
            if ((j > paramInt1) && (j <= paramInt2))
            {
              i = j - 1;
              break label57;
            }
            m = k;
          } while (j >= paramInt1);
          m = k;
        } while (j < paramInt2);
        i = j + 1;
      }
    }
    paramInt1 = 0;
    while (paramInt1 < n)
    {
      ((CellLayout)this.mWorkspace.getPageAt(paramInt1)).reset();
      paramInt1 += 1;
    }
    LauncherModel.moveItemsInDatabase(getActivity(), localArrayList);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mWaitingForResult = false;
    PendingAddArguments localPendingAddArguments;
    if ((paramInt2 == -1) && (this.mPendingAddInfo.container != -1L))
    {
      localPendingAddArguments = new PendingAddArguments(null);
      localPendingAddArguments.requestCode = paramInt1;
      localPendingAddArguments.intent = paramIntent;
      copyHomeItemToPendingAdd(localPendingAddArguments, this.mPendingAddInfo);
      if (isWorkspaceLocked()) {
        sPendingAddList.add(localPendingAddArguments);
      }
    }
    for (;;)
    {
      paramIntent = ((LauncherApplication)getActivity().getApplication()).getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
      paramIntent.remove("tempScreen");
      paramIntent.remove("tempCellX");
      paramIntent.remove("tempCellY");
      paramIntent.remove("tempSpanX");
      paramIntent.remove("tempSpanY");
      paramIntent.commit();
      ((Launcher)getActivity()).addAnyPendingWidgetsToWorkspace();
      return;
      completeAdd(localPendingAddArguments);
      continue;
      if (((paramInt1 == 9) || (paramInt1 == 5)) && (paramInt2 == 0))
      {
        if (paramIntent != null)
        {
          paramInt1 = paramIntent.getIntExtra("appWidgetId", -1);
          if (paramInt1 != -1) {
            this.mAppWidgetHost.deleteAppWidgetId(paramInt1);
          }
        }
      }
      else if ((paramInt1 == 10) && (this.mQuickViewWorkspace != null) && (this.mQuickViewWorkspace.getVisibility() == 0) && (paramInt2 == -1)) {
        closeQuickViewWorkspace(true);
      }
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    setLayerType(0, Launcher.sViewLayerPaint);
    paramAnimator = getWorkspace();
    if (paramAnimator != null) {
      paramAnimator.onFadeEnd();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    setLayerType(2, Launcher.sViewLayerPaint);
  }
  
  public boolean onBackPressed()
  {
    Workspace localWorkspace = getWorkspace();
    this.mQuickViewWorkspace.drawCloseAnimation();
    if ((localWorkspace != null) && (localWorkspace.getOpenFolder() != null))
    {
      Folder localFolder = localWorkspace.getOpenFolder();
      if (localFolder.isEditingName()) {
        localFolder.dismissEditingName(true);
      }
    }
    do
    {
      do
      {
        return true;
        localWorkspace.closeFolder();
        return true;
        localWorkspace.exitWidgetResizeMode();
      } while (!Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE);
      Launcher.setHomeRemoveMode(false);
    } while (!Launcher.isHomeEditMode());
    Launcher.setHomeEditMode(false);
    showWorkspace(true);
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = paramView;
    Object localObject1;
    if (Launcher.isHelpAppRunning)
    {
      localObject1 = paramView;
      if (!(paramView instanceof CellLayout)) {
        localObject1 = (View)paramView.getParent().getParent();
      }
      localObject2 = localObject1;
      if ((localObject1 instanceof CellLayout))
      {
        paramView = (CellLayout)localObject1;
        localObject2 = localObject1;
        if (paramView != null)
        {
          localObject2 = localObject1;
          if (!(paramView.getContainer() instanceof Hotseat)) {}
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (((Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) && (Launcher.isHomeEditMode())) || (((View)localObject2).getWindowToken() == null) || (this.mWorkspace == null) || (this.mWorkspace.isSwitchingState()));
        cancelClicksOnHome();
        paramView = ((View)localObject2).getTag();
        if (!(paramView instanceof HomeShortcutItem)) {
          break;
        }
        localObject1 = ((HomeShortcutItem)paramView).intent;
      } while (localObject1 == null);
      int[] arrayOfInt = new int[2];
      ((View)localObject2).getLocationOnScreen(arrayOfInt);
      ((Intent)localObject1).setSourceBounds(new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + ((View)localObject2).getWidth(), arrayOfInt[1] + ((View)localObject2).getHeight()));
      ((Launcher)getActivity()).startActivitySafely((View)localObject2, (Intent)localObject1, paramView);
      return;
    } while ((!Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) || (localObject2 != this.mEditIcon));
    onClickEditButton((View)localObject2);
  }
  
  public void onClickAllAppsButton(View paramView)
  {
    if (Launcher.isHelpAppRunning)
    {
      if (((GuideFragment.GMode.equals("addapps")) || (GuideFragment.GMode.equals("create_folder"))) && (mIsAllAppsButtonDisable)) {}
      do
      {
        do
        {
          return;
        } while (((!GuideFragment.GMode.equals("addapps")) && (!GuideFragment.isViewApps) && (!GuideFragment.GMode.equals("create_folder"))) || ((!GuideFragment.GMode.equals("addapps")) && (!GuideFragment.GMode.equals("create_folder"))));
        paramView = new AddAppsGuider(getActivity());
      } while (!((AddAppsGuider)paramView).isStep1DialogVisible());
      showAllApps();
      ((AddAppsGuider)paramView).dismissShowHelpDialog_step1();
      ((AddAppsGuider)paramView).showHelpDialog_step2();
      return;
    }
    paramView.performAccessibilityAction(128, null);
    paramView = new Intent();
    paramView.setAction("com.android.launcher.action.USE_EXPAND_MODE");
    getContext().sendBroadcast(paramView);
    showAllApps();
  }
  
  public void onClickAlwaysButton(View paramView)
  {
    paramView = new Intent("android.intent.action.MAIN");
    paramView.addCategory("android.intent.category.LAUNCHER");
    paramView.setFlags(270532608);
    paramView.setClassName("com.samsung.android.app.always", "com.samsung.android.app.always.ui.MainActivity");
    this.mWorkspace.getContext().startActivity(paramView);
  }
  
  public void onClickEditButton(View paramView)
  {
    if (Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE)
    {
      Launcher.setHomeEditMode(true);
      showWorkspaceEditmode(true);
    }
  }
  
  public void onClickSearchButton(View paramView)
  {
    paramView = (Launcher)getActivity();
    if (!Launcher.isHelpAppRunning) {
      paramView.onSearchRequested();
    }
  }
  
  public void onDestroy()
  {
    Log.d("Launcher.HomeView", "onDestroyView");
    ((Launcher)getActivity()).removeStateAnimatorProvider(this);
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(0);
    this.mAppWidgetHost = null;
    this.mWidgetsToAdvance.clear();
    TextKeyListener.getInstance().release();
    if (this.mModel != null) {
      this.mModel.unbindAllHomeItems();
    }
    getActivity().getContentResolver().unregisterContentObserver(this.mWidgetObserver);
    getActivity().getContentResolver().unregisterContentObserver(this.mHelphubObserver);
    getActivity().getContentResolver().unregisterContentObserver(this.mChangeTphoneModeObserver);
    ((ViewGroup)this.mWorkspace.getParent()).removeAllViews();
    this.mWorkspace.removeAllViews();
    this.mWorkspace = null;
    this.mHomeDarkenLayer.setOnTouchListener(null);
    if (this.mTiltWallpaperScroller != null) {
      this.mTiltWallpaperScroller.shutdown();
    }
    if ((LauncherApplication.sMagazineLauncher) && (this.mLightEffectAnimation != null)) {
      this.mLightEffectAnimation.stop();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.mInflater = getActivity().getLayoutInflater();
    this.mAppWidgetManager = AppWidgetManager.getInstance(getActivity());
    this.mAppWidgetHost = new LauncherAppWidgetHost(getActivity(), 1024);
    this.mAppWidgetHost.startListening();
    this.mAppWidgetBinder = new AppWidgetBinder((Launcher)getActivity(), this.mAppWidgetManager, this.mAppWidgetHost);
    setupViews();
    updateGlobalSearchIcon();
    ((Launcher)getActivity()).addStateAnimatorProvider(this);
    Log.d("Launcher.HomeView", "OnFinishInflate() completed");
  }
  
  public void onFolderCreated(BaseItem paramBaseItem, String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    completeAddFolderWithShortcutItem((HomeShortcutItem)paramBaseItem, paramString, paramLong, paramBoolean1, paramBoolean2);
  }
  
  public boolean onHomePressed(final boolean paramBoolean)
  {
    if (Launcher.isHelpAppRunning)
    {
      this.mHomeKeyPress = true;
      return false;
    }
    if (this.mWorkspace.getMeasuredWidth() == 0)
    {
      this.mWorkspace.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          HomeView.this.mWorkspace.removeOnLayoutChangeListener(this);
          HomeView.this.mWorkspace.post(new Runnable()
          {
            public void run()
            {
              HomeView.this.performOnHomePressed(HomeView.1.this.val$moveToDefaultScreen);
            }
          });
        }
      });
      return true;
    }
    performOnHomePressed(paramBoolean);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if ((Launcher.isHelpAppRunning) && (paramMotionEvent.getActionMasked() == 1)) {
      HelpAnimatedDialog.setAlpha();
    }
    boolean bool1 = bool2;
    if (paramMotionEvent.getActionMasked() == 0)
    {
      bool1 = bool2;
      if (this.mWorkspace.getState() == Workspace.State.RESIZE)
      {
        j = 1;
        k = this.mWorkspace.getChildCount();
        int m = this.mWorkspace.getCurrentPage();
        i = j;
        if (m > -1)
        {
          i = j;
          if (m < k)
          {
            AppWidgetResizeFrame localAppWidgetResizeFrame = ((CellLayoutWithResizableWidgets)this.mWorkspace.getChildAt(m)).getResizeFrame();
            i = j;
            if (localAppWidgetResizeFrame != null)
            {
              sTouchPt.set(paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
              i = j;
              if (localAppWidgetResizeFrame.isPointInFrame(sTouchPt.x, sTouchPt.y)) {
                i = 0;
              }
            }
          }
        }
        j = i;
        if (Launcher.isHelpAppRunning)
        {
          j = i;
          if (!Workspace.widgetSizeChanged) {
            j = 0;
          }
        }
        bool1 = bool2;
        if (j != 0)
        {
          this.mWorkspace.exitWidgetResizeMode();
          if ((Launcher.isHelpAppRunning) && ("resize_widgets".equals(GuideFragment.GMode)))
          {
            GuideFragment.isGuideCompleted = true;
            Toast.makeText(getContext(), 2131755202, 1).show();
            new Handler().postDelayed(new Runnable()
            {
              public void run()
              {
                GuideFragment.showCompleteDialog(HomeView.this.getActivity());
              }
            }, 2000L);
          }
          bool1 = true;
        }
      }
    }
    float f1;
    float f2;
    if ((LauncherApplication.sMagazineLauncher) && (Launcher.sIsMagazineHomeEnable))
    {
      i = paramMotionEvent.getAction();
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      if ((this.mWorkspace != null) && (!this.mWorkspace.isPageMoving()) && (!Launcher.isHelpAppRunning) && (!Launcher.isPopupMenuShowing()) && (!this.mQuickViewWorkspace.isOpened())) {
        break label336;
      }
      this.mIsStartFlickUp = false;
      releaseVelocityTracker();
    }
    label336:
    do
    {
      return bool1;
      switch (i & 0xFF)
      {
      default: 
        return bool1;
      case 0: 
        setStartPosition(paramMotionEvent);
        acquireVelocityTrackerAndAddMovement(paramMotionEvent);
        return bool1;
      case 2: 
        i = getResources().getDimensionPixelSize(2131624602);
        if (!this.mIsStartFlickUp)
        {
          releaseVelocityTracker();
          return bool1;
        }
        addMovementVelocityTracker(paramMotionEvent);
      }
    } while ((f2 > i) || (this.mDownMotionY <= i));
    int i = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity();
    int j = getResources().getDimensionPixelSize(2131624603);
    this.mVelocityTracker.computeCurrentVelocity(1000, i);
    int k = (int)this.mVelocityTracker.getYVelocity(0);
    if (Math.abs(f1 - this.mDownMotionX) / Math.abs(f2 - this.mDownMotionY) <= (float)Math.tan(Math.toRadians(20.0D))) {}
    for (i = 1;; i = 0)
    {
      this.mIsStartFlickUp = false;
      releaseVelocityTracker();
      if ((Math.abs(k) <= j) || (i == 0)) {
        break;
      }
      if (!LauncherApplication.getInst().isKnoxMode())
      {
        if (this.mLightEffectImage != null) {
          this.mLightEffectImage.setVisibility(0);
        }
        if (this.mLightEffectAnimation != null)
        {
          this.mLightEffectAnimation.start();
          new Handler().postDelayed(this.mStopLightEffect, 400L);
        }
        ((Launcher)getContext()).startMagazineApp(true);
      }
      return true;
    }
    this.mIsStartFlickUp = false;
    releaseVelocityTracker();
    return bool1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (Launcher.is_TB)
    {
      paramInt1 = Utilities.getDeviceRotation(getContext());
      if (sCurrentRotationAngle != paramInt1)
      {
        sCurrentRotationAngle = paramInt1;
        setupHomeViewAfterRotationForTB(paramInt1);
      }
    }
    paramInt2 = getChildCount();
    paramInt1 = 0;
    View localView;
    while (paramInt1 < paramInt2)
    {
      localView = getChildAt(paramInt1);
      Object localObject = (FrameLayout.LayoutParams)localView.getLayoutParams();
      if ((localObject instanceof LayoutParams))
      {
        localObject = (LayoutParams)localObject;
        if (((LayoutParams)localObject).customPosition) {
          localView.layout(((LayoutParams)localObject).x, ((LayoutParams)localObject).y, ((LayoutParams)localObject).x + ((LayoutParams)localObject).width, ((LayoutParams)localObject).y + ((LayoutParams)localObject).height);
        }
      }
      paramInt1 += 1;
    }
    if (paramBoolean)
    {
      localView = getRootView();
      sPanelDrawer.setViewport(localView.getWidth(), localView.getHeight());
    }
    if (!sPanelDrawer.hasLoadedResources()) {
      sPanelDrawer.loadResources(getResources());
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    Launcher localLauncher = (Launcher)getContext();
    if (localLauncher.mInMenu) {
      return false;
    }
    if ((Launcher.isHelpAppRunning) && (!GuideFragment.GMode.equals("change_wallpaper")) && (!GuideFragment.GMode.equals("add_widgets")))
    {
      if ((!GuideFragment.GMode.equals("resize_widgets")) && (!GuideFragment.GMode.equals("remove_items")) && (!GuideFragment.GMode.equals("move_app"))) {
        break label311;
      }
      if (!paramView.isInTouchMode()) {
        return false;
      }
      localObject = paramView.getTag();
      if (!(localObject instanceof HomeWidgetItem)) {
        break label172;
      }
      if ((!((HomeWidgetItem)localObject).getComponentName().getClassName().equals("com.google.android.apps.chrome.appwidget.bookmarks.BookmarkThumbnailWidgetProvider")) && (!((HomeWidgetItem)localObject).getComponentName().getClassName().equals("com.sec.android.app.sbrowser.BookmarkThumbnailWidgetProvider"))) {
        break label170;
      }
      ((ResizeWidgetsGuider)new ResizeWidgetsGuider(getActivity())).dismissHelpDialog();
    }
    while (isWorkspaceLocked())
    {
      return false;
      label170:
      return false;
      label172:
      if (((localObject instanceof HomeShortcutItem)) && (((HomeShortcutItem)localObject).getComponentName() != null))
      {
        if ((!((HomeShortcutItem)localObject).getComponentName().getClassName().equals("com.sec.android.app.popupcalculator.Calculator")) && (!((HomeShortcutItem)localObject).getComponentName().getClassName().equals("com.samsung.helphub.HelpHubActivity"))) {
          return false;
        }
        if (GuideFragment.GMode.equals("remove_items"))
        {
          localObject = new RemoveItemsGuider(getActivity());
          ((RemoveItemsGuider)localObject).dismissHelpDialog();
          ((RemoveItemsGuider)localObject).showHelpDialog2();
        }
        else if (GuideFragment.GMode.equals("move_app"))
        {
          localObject = new MoveAppsGuider(getActivity());
          ((MoveAppsGuider)localObject).dismissHelpDialog();
          ((MoveAppsGuider)localObject).showHelpDialog_step2();
          continue;
          label311:
          return false;
        }
      }
    }
    Object localObject = paramView;
    if (!(paramView instanceof CellLayout)) {
      localObject = (View)paramView.getParent().getParent();
    }
    if ((Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) && ((localObject instanceof CellLayout)))
    {
      paramView = (CellLayout)localObject;
      if ((paramView != null) && ((paramView.getContainer() instanceof Hotseat)) && (!Launcher.isHomeEditMode()))
      {
        Log.i("Launcher.HomeView", "Hotseat item long click but we do nothing in normal mode");
        return true;
      }
    }
    resetAddInfo();
    paramView = null;
    if ((localObject instanceof CellLayout))
    {
      CellLayout localCellLayout = (CellLayout)localObject;
      paramView = (CellLayout.CellInfo)localCellLayout.getTag();
      if (paramView == null) {
        return true;
      }
      paramView = paramView.cell;
      localCellLayout.clearTagCellInfo();
    }
    if ((isHotseatLayout((View)localObject)) || (this.mWorkspace.allowLongPress())) {}
    for (int i = 1; (isHotseatLayout((View)localObject)) && (Launcher.isHelpAppRunning); i = 0) {
      return false;
    }
    if ((isHotseatLayout((View)localObject)) && (paramView == null)) {
      return true;
    }
    if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn) && (!Launcher.isHomeEditMode()) && (getPage(getCurrentPage()).getPageType() == 2))
    {
      if (DEBUGGABLE) {
        Log.i("Launcher.HomeView", "-----Skip long click on festival page ");
      }
      return true;
    }
    if (i != 0)
    {
      cpuBooster.addExtraOptionsByDefaultPolicy("Launcher_touch");
      cpuBooster.acquire("Launcher_touch");
      if ((paramView != null) || (this.mAfterSavedInstanceState)) {
        break label808;
      }
      this.mWorkspace.performHapticFeedback(0, 1);
      if ((!Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) || (!Launcher.isHomeEditMode()))
      {
        if (!Launcher.isHelpAppRunning) {
          break label799;
        }
        if (GuideFragment.GMode.equals("change_wallpaper"))
        {
          paramView = new ChangeWallpaperGuider(getActivity());
          ((ChangeWallpaperGuider)paramView).dismissHelpDialog();
          openQuickViewWorkspace(null, true);
          ((ChangeWallpaperGuider)paramView).showHelpDialog_step1();
        }
        if ((!GuideFragment.GMode.equals("remove_items")) && (!GuideFragment.GMode.equals("create_folder")) && (!GuideFragment.GMode.equals("move_app")) && (!GuideFragment.GMode.equals("resize_widgets")) && (!GuideFragment.GMode.equals("add_widgets")) && (!GuideFragment.GMode.equals("change_wallpaper")) && (GuideFragment.sHelpHubStepNumber == 1))
        {
          AddToHomescreenDialogFragment.createAndShow(localLauncher.getFragmentManager());
          GuideFragment.sHelpHubStepNumber = 2;
        }
        if (GuideFragment.GMode.equals("add_widgets"))
        {
          Log.d("DaliLogs", "addwidgets");
          paramView = new AddWidgetsGuider(getActivity());
          ((AddWidgetsGuider)paramView).dismissHelpDialog();
          openQuickViewWorkspace(null, true);
          ((AddWidgetsGuider)paramView).showHelpDialog_step1();
        }
      }
      this.mWorkspace.requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      cpuBooster.release();
      return true;
      label799:
      openQuickViewWorkspace(null, true);
      break;
      label808:
      if ((Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) && (!Launcher.isHelpAppRunning) && (!Launcher.isHomeEditMode()))
      {
        Launcher.setHomeRemoveMode(true);
        Toast.makeText(getActivity(), 2131755154, 1).show();
      }
      this.mWorkspace.startDrag(paramView);
    }
  }
  
  public void onPageSwitch(View paramView, int paramInt)
  {
    if (this.mWorkspace != null) {
      this.mWorkspace.closeFolder();
    }
  }
  
  public void onPause()
  {
    Log.d("Launcher.HomeView", "onPause");
    if (this.mTiltWallpaperScroller != null) {
      this.mTiltWallpaperScroller.pause();
    }
    this.mWorkspace.removeHoverScrollHandler();
    this.mWorkspace.closeFolder();
    sPanelDrawer.pause();
  }
  
  public void onQuickViewCloseAnimationCompleted()
  {
    closeQuickViewWorkspace(false);
  }
  
  public void onQuickViewCloseAnimationStarted()
  {
    closeQuickViewWorkspaceStartAnimation();
  }
  
  public void onQuickViewDragEnd()
  {
    this.mQuickViewWorkspace.setLayerType(0, Launcher.sViewLayerPaint);
  }
  
  public void onQuickViewDragStart()
  {
    this.mQuickViewWorkspace.setLayerType(2, Launcher.sViewLayerPaint);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    restoreState(paramParcelable);
    this.mSavedState = paramParcelable;
  }
  
  public void onResume()
  {
    Log.d("Launcher.HomeView", "onResume");
    if (this.mRestoring)
    {
      this.mWorkspaceLoading = true;
      this.mRestoring = false;
    }
    if ((getVisibility() == 0) && (!this.mQuickViewWorkspace.isOpened()))
    {
      this.mWorkspace.resumeScreen(this.mWorkspace.getCurrentPage());
      if (LauncherApplication.sMagazineLauncher) {
        this.mWorkspace.resumeMagazineCling();
      }
      if (Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) {
        if (!Launcher.isHomeEditMode())
        {
          if (this.mHomePhoneBtn != null) {
            this.mHomePhoneBtn.setVisibility(0);
          }
          if (this.mHomeAppsBtn != null) {
            this.mHomeAppsBtn.setVisibility(0);
          }
        }
      }
    }
    for (;;)
    {
      updateWallpaperOffsets();
      this.mAfterSavedInstanceState = false;
      if (this.mTiltWallpaperScroller != null) {
        this.mTiltWallpaperScroller.resume();
      }
      if (LauncherApplication.sMagazineLauncher)
      {
        if (this.mLightEffectAnimation != null) {
          this.mLightEffectAnimation.stop();
        }
        if (this.mLightEffectImage != null) {
          this.mLightEffectImage.setVisibility(8);
        }
      }
      sPanelDrawer.resume();
      return;
      if (this.mHomePhoneBtn != null) {
        this.mHomePhoneBtn.setVisibility(0);
      }
      if (this.mHomeAppsBtn != null)
      {
        this.mHomeAppsBtn.setVisibility(0);
        continue;
        if (this.mQuickViewWorkspace.isOpened())
        {
          this.mQuickViewWorkspace.invalidate();
          getHomeScreenOptionMenu().setMakeActive(true);
        }
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.currentScreen = this.mWorkspace.getComingPage();
    Bundle localBundle = new Bundle();
    if (saveOpenFolderState(localBundle)) {
      localSavedState.folderBundle = localBundle;
    }
    if ((this.mPendingAddInfo.container != -1L) && (this.mPendingAddInfo.mScreen > -1) && (this.mWaitingForResult))
    {
      localSavedState.pendingAddContainer = this.mPendingAddInfo.container;
      localSavedState.pendingAddScreen = this.mPendingAddInfo.mScreen;
      localSavedState.pendingAddCellX = this.mPendingAddInfo.cellX;
      localSavedState.pendingAddCellY = this.mPendingAddInfo.cellY;
      localSavedState.pendingAddSpanX = this.mPendingAddInfo.spanX;
      localSavedState.pendingAddSpanY = this.mPendingAddInfo.spanY;
      if (!this.mPendingAddInfo.mSecretItem) {
        break label253;
      }
    }
    label253:
    for (int i = 1;; i = 0)
    {
      localSavedState.pendingAddSecretItem = i;
      if (this.mPendingAddInfo.dropPos != null)
      {
        localSavedState.pendingAddDropPosX = this.mPendingAddInfo.dropPos[0];
        localSavedState.pendingAddDropPoxY = this.mPendingAddInfo.dropPos[1];
      }
      if ((this.mQuickViewWorkspace != null) && (this.mQuickViewWorkspace.isOpened()))
      {
        localSavedState.inQuickView = true;
        localSavedState.quickViewDeleteIndex = this.mQuickViewWorkspace.getDeletePageIndex();
      }
      if (this.mHomeDarkenLayer != null) {
        localSavedState.darkenLayerVisibility = this.mHomeDarkenLayer.getVisibility();
      }
      this.mAfterSavedInstanceState = true;
      return localSavedState;
    }
  }
  
  public void onStart()
  {
    Log.d("Launcher.HomeView", "onStart");
    this.mWorkspace.setWallpaperDimension();
  }
  
  public void onStop()
  {
    Log.d("Launcher.HomeView", "onStop");
    this.mWorkspace.closeFolder();
    this.mWorkspace.onStop();
    this.mWorkspace.pauseScreen(getCurrentPage());
    if (this.mQuickViewWorkspace.isOpened()) {
      getHomeScreenOptionMenu().setMakeActive(false);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    showWorkspace(true);
    return false;
  }
  
  public void onVisibilityChanged(View paramView, int paramInt)
  {
    if (paramView == this) {
      if (paramInt == 0) {
        break label58;
      }
    }
    label58:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt == 0) && (Launcher.isHelpAppRunning)) {
        this.mWorkspace.mIsHelpOrientationChanged = false;
      }
      if ((((Launcher)getActivity()).getTransitionToAllApps()) && (paramInt != 0)) {
        ((Launcher)getActivity()).setTransitionToAllApps(false);
      }
      return;
    }
  }
  
  public void onWindowVisibilityChanged(int paramInt)
  {
    updateRunning();
    if (this.mShadow == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.mShadow.draw();
      return;
    }
    this.mShadow.clear();
  }
  
  void openQuickViewWorkspace(SavedState paramSavedState, boolean paramBoolean)
  {
    if ((this.mWorkspace == null) || (this.mQuickViewWorkspace.isOpened())) {}
    do
    {
      return;
      this.mWorkspace.getPageIndicatorManager().getPageIndicator().setPageIndicatorPanelRightAdjust(0);
      if (this.mHomePhoneBtn != null) {
        this.mHomePhoneBtn.setVisibility(4);
      }
      if (this.mHomeAppsBtn != null) {
        this.mHomeAppsBtn.setVisibility(4);
      }
      if (Launcher.isHelpAppRunning) {
        break;
      }
    } while ((((Launcher)getActivity()).isTransitioningToShowAllApps()) || (Launcher.isPopupMenuShowing()) || (this.mWorkspace.isAnimating()));
    if (this.mWorkspace.isInResizeMode()) {
      this.mWorkspace.exitWidgetResizeMode();
    }
    if (LauncherApplication.sFestivalPageLauncher) {
      this.mWorkspace.getPageIndicatorManager().setDisplayItem(PageIndicatorManager.DISPLAY_ITEM.NORMAL_PAGE);
    }
    this.mQuickViewWorkspace.setSecretQuickViewMode(false);
    if ((this.mHomeBottomBar != null) && (this.removeHotseat)) {
      this.mHomeBottomBar.setVisibility(8);
    }
    if (paramBoolean) {
      this.mQuickViewWorkspace.drawOpenAnimation();
    }
    cpuBooster.addExtraOptionsByDefaultPolicy("Launcher_touch");
    Object localObject = new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (this.val$l != null) {
          this.val$l.mBlockEventsListener.onAnimationEnd(paramAnonymousAnimator);
        }
        if ((HomeView.this.mHotseat == null) || (HomeView.this.mQuickLaunch != null)) {
          HomeView.this.mQuickLaunch.setVisibility(8);
        }
        if (HomeView.this.mQuickLaunchCamera != null) {
          HomeView.this.mQuickLaunchCamera.setVisibility(8);
        }
        HomeView.cpuBooster.release();
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        HomeView.cpuBooster.acquire("Launcher_touch");
        if (HomeView.this.mHomeSearchBtn != null) {
          HomeView.this.mHomeSearchBtn.setEnabled(false);
        }
      }
    };
    if (this.mHotseat != null)
    {
      this.mHotseat.setLayerType(2, Launcher.sViewLayerPaint);
      this.mHotseat.setVisibility(4);
      this.mHotseat.animate().alpha(0.0F).setDuration(400L).setListener((Animator.AnimatorListener)localObject).start();
    }
    if (this.mQuickLaunch != null)
    {
      this.mQuickLaunch.setLayerType(2, Launcher.sViewLayerPaint);
      this.mQuickLaunch.animate().alpha(0.0F).setDuration(400L).setListener((Animator.AnimatorListener)localObject).start();
    }
    if ((this.mQuickLaunchCamera != null) && (this.mQuickLaunchCamera.isLandscape()))
    {
      this.mQuickLaunchCamera.setLayerType(2, Launcher.sViewLayerPaint);
      this.mQuickLaunchCamera.animate().alpha(0.0F).setDuration(400L).setListener((Animator.AnimatorListener)localObject).start();
    }
    if (this.mHomeTopBar != null)
    {
      this.mHomeTopBar.setLayerType(2, Launcher.sViewLayerPaint);
      this.mHomeTopBar.setVisibility(8);
      this.mHomeTopBar.animate().alpha(0.0F).setDuration(400L).setListener((Animator.AnimatorListener)localObject).start();
    }
    if ((!Launcher.isHelpAppRunning) && (this.mWorkspace.getOpenFolder() != null)) {
      this.mWorkspace.closeFolder();
    }
    this.mWorkspace.setHideItems(true);
    this.mWorkspace.pauseScreen(getCurrentPage());
    this.mWorkspace.invalidate();
    this.mWorkspace.performAccessibilityAction(128, null);
    this.mQuickViewWorkspace.bringToFront();
    this.mQuickViewWorkspace.initScreen(this);
    if (paramSavedState != null) {
      this.mQuickViewWorkspace.setDeletePageIndex(paramSavedState.quickViewDeleteIndex);
    }
    getActivity().closeOptionsMenu();
    this.mWorkspace.setAllPagesVisibility(4);
    int i = 0;
    while (i < this.mWorkspace.getChildCount())
    {
      paramSavedState = ((CellLayout)this.mWorkspace.getChildAt(i)).getChildrenLayout();
      int j = 0;
      while (j < paramSavedState.getChildCount())
      {
        localObject = paramSavedState.getChildAt(j);
        if ((localObject instanceof SurfaceWidgetView))
        {
          ((SurfaceWidgetView)localObject).onVisibilityChanged((View)localObject, 0);
          ((SurfaceWidgetView)localObject).setAlpha(0.99F);
        }
        j += 1;
      }
      i += 1;
    }
    this.mQuickViewWorkspace.open();
    this.mWorkspace.getPageIndicatorManager().setDisplayItem(PageIndicatorManager.DISPLAY_ITEM.NORMAL_PAGE);
    this.mQuickViewWorkspace.setSecretQuickViewMode(false);
    if ((!Launcher.isHelpAppRunning) && (!paramBoolean)) {
      this.mQuickViewWorkspace.drawOpenNonAnimation();
    }
    this.mWorkspace.updateChildrenLayersEnabled(PagedView.LayerOptions.FORCE_NONE);
  }
  
  void processItemDropToNewFolder(ComponentName paramComponentName)
  {
    resetAddInfo();
    this.mPendingAddInfo.container = -100L;
    Intent localIntent = new Intent("android.intent.action.CREATE_SHORTCUT");
    localIntent.setComponent(paramComponentName);
    startActivityForResultSafely(localIntent, 2);
  }
  
  void processShortcutFromDrop(ComponentName paramComponentName, long paramLong, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    resetAddInfo();
    this.mPendingAddInfo.container = paramLong;
    this.mPendingAddInfo.mScreen = paramInt;
    this.mPendingAddInfo.dropPos = paramArrayOfInt2;
    if (paramArrayOfInt1 != null)
    {
      this.mPendingAddInfo.cellX = paramArrayOfInt1[0];
      this.mPendingAddInfo.cellY = paramArrayOfInt1[1];
    }
    paramArrayOfInt1 = new Intent("android.intent.action.CREATE_SHORTCUT");
    paramArrayOfInt1.setComponent(paramComponentName);
    startActivityForResultSafely(paramArrayOfInt1, 1);
  }
  
  public void refreshQuickViewWorkspace(boolean paramBoolean)
  {
    if (!this.mQuickViewWorkspace.isOpened()) {
      return;
    }
    if (paramBoolean) {
      this.mQuickViewWorkspace.setSecretQuickViewMode(true);
    }
    for (;;)
    {
      this.mQuickViewWorkspace.initScreen(this);
      return;
      this.mQuickViewWorkspace.setSecretQuickViewMode(false);
    }
  }
  
  public void removeAppWidget(HomeWidgetItem paramHomeWidgetItem)
  {
    removeWidgetToAutoAdvance(paramHomeWidgetItem.hostView);
    paramHomeWidgetItem.hostView = null;
  }
  
  void removeFolder(HomeFolderItem paramHomeFolderItem)
  {
    sFolders.remove(Long.valueOf(paramHomeFolderItem.mId));
  }
  
  void removePage()
  {
    this.mIsDeletePopup = false;
    this.mQuickViewWorkspace.removeScreen();
  }
  
  void removeWidgetToAutoAdvance(View paramView)
  {
    if (this.mWidgetsToAdvance.containsKey(paramView))
    {
      this.mWidgetsToAdvance.remove(paramView);
      updateRunning();
    }
  }
  
  public void removehelpAppPage()
  {
    if (this.isHelpAppPageDeleted) {
      return;
    }
    if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn)) {
      deletePage(this.screenIndexFestivalHelpAppPageAddition);
    }
    for (;;)
    {
      this.isHelpAppPageDeleted = true;
      this.isHelpAppPageAdded = false;
      this.mWorkspace.setCurrentPage(this.screenIndexBeforeHelpAppPageAddition);
      this.screenIndexBeforeHelpAppPageAddition = -1;
      this.screenIndexFestivalHelpAppPageAddition = -1;
      return;
      deletePage(getNumPages() - 1);
    }
  }
  
  public void resetPanelViewport()
  {
    if (getWidth() != 0) {
      sPanelDrawer.setViewport(getWidth(), getHeight());
    }
  }
  
  public boolean restoreOpenFolder(Bundle paramBundle)
  {
    if ((paramBundle == null) || (this.mWorkspace == null)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return false;
        } while (this.mWorkspace.getChildAt(getCurrentPage()) == null);
        long l = paramBundle.getLong("launcher.workspace_open_folder_id", -1L);
        localObject = this.mModel.getFolderById(getActivity(), sFolders, l);
      } while ((localObject == null) || (!this.mWorkspace.restoreOpenFolder((HomeFolderItem)localObject)));
      localObject = this.mWorkspace.getOpenFolder();
    } while (localObject == null);
    String str = paramBundle.getString("launcher.workspace_pending_folder_edit_text");
    if (str != null) {
      ((Folder)localObject).restoreText(str, paramBundle.getInt("launcher.workspace_pending_folder_edit_text_selection_start"), paramBundle.getInt("launcher.workspace_pending_folder_edit_text_selection_end"));
    }
    return true;
  }
  
  public void saveCurrentPageOrder()
  {
    saveScreenInfo();
  }
  
  public void saveFestivalScreenInfo()
  {
    if (this.mWorkspace.getChildCount() == 0) {
      return;
    }
    int i = ((Launcher)getActivity()).getFestivalPageManager().getFestivalPageCount();
    LauncherApplication.setFestivalScreenCount(getActivity(), i);
  }
  
  public boolean saveOpenFolderState(Bundle paramBundle)
  {
    if (this.mWorkspace == null) {}
    Folder localFolder;
    do
    {
      return false;
      localFolder = this.mWorkspace.getOpenFolder();
    } while (localFolder == null);
    if (localFolder.isEditingName())
    {
      EditText localEditText = localFolder.getEditTextRegion();
      paramBundle.putString("launcher.workspace_pending_folder_edit_text", localEditText.getText().toString());
      paramBundle.putInt("launcher.workspace_pending_folder_edit_text_selection_start", localEditText.getSelectionStart());
      paramBundle.putInt("launcher.workspace_pending_folder_edit_text_selection_end", localEditText.getSelectionEnd());
    }
    paramBundle.putLong("launcher.workspace_open_folder_id", localFolder.getInfo().getId());
    return true;
  }
  
  public void saveScreenInfo()
  {
    if (this.mWorkspace.getChildCount() == 0) {
      return;
    }
    int i = 0;
    int j = 0;
    Object localObject;
    if (Launcher.sIsSecretModeOn)
    {
      localObject = ((Launcher)getActivity()).getSecretPageManager();
      i = ((SecretPageManager)localObject).getSecretPageCount();
      ((SecretPageManager)localObject).printWorkspaceInfo();
    }
    if (Launcher.sIsFestivalModeOn)
    {
      localObject = ((Launcher)getActivity()).getFestivalPageManager();
      j = ((FestivalPageManager)localObject).getFestivalPageCount();
      ((FestivalPageManager)localObject).printWorkspaceInfo();
    }
    LauncherApplication.setScreenCount(getActivity(), this.mWorkspace.getChildCount() - i - j);
  }
  
  public void saveSecretScreenInfo()
  {
    if (this.mWorkspace.getChildCount() == 0) {
      return;
    }
    int i = ((Launcher)getActivity()).getSecretPageManager().getSecretPageCount();
    LauncherApplication.setSecretScreenCount(getActivity(), i);
  }
  
  public void setCurrentDragItem(BaseItem paramBaseItem)
  {
    this.mCurrentDragItem = paramBaseItem;
  }
  
  public void setCurrentResizeWidgetItem(BaseItem paramBaseItem)
  {
    this.mCurrentResizeWidgetItem = paramBaseItem;
  }
  
  public void setDarkenViewAlpha(float paramFloat)
  {
    if (this.mDarkenView == null) {
      this.mDarkenView = getActivity().findViewById(2131689617);
    }
    this.mDarkenView.setAlpha(paramFloat);
  }
  
  void setDestinationNewFolderId(long paramLong)
  {
    mDestinationNewFolderId = paramLong;
  }
  
  public void setDummyPanelProperties()
  {
    float f1 = this.mPanelBackgroundAlpha;
    Object localObject = getWorkspace();
    if (localObject != null)
    {
      float f2 = ((Workspace)localObject).getBackgroundDarken();
      ((Workspace)localObject).setDummyPanelProperties(PagedView.mix(Workspace.sPanelBaseEditDarkenAmount, f2, 1.0F - f1), -1);
      localObject = ((Launcher)getContext()).getMenuView().getMenuAppsGrid();
      if (localObject != null) {
        ((MenuAppsGrid)localObject).setDummyPanelProperties((1.0F - f1) * f2, -1);
      }
      return;
    }
    boolean bool1;
    boolean bool2;
    if (this.mWorkspace == null)
    {
      bool1 = true;
      if (this.mHotseat != null) {
        break label174;
      }
      bool2 = true;
      label89:
      if (this.mHomeContainer != null) {
        break label180;
      }
    }
    label174:
    label180:
    for (boolean bool3 = true;; bool3 = false)
    {
      Log.d("Launcher.HomeView", "CRR: isWorkspaceNull = " + bool1 + " isHotseatNull = " + bool2 + " isAllAppsIconNull = " + true + " isHomeContainerNull = " + bool3);
      Log.getStackTraceString(new Throwable());
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label89;
    }
  }
  
  public void setEditBar(HomeEditBar paramHomeEditBar)
  {
    this.mEditBar = paramHomeEditBar;
  }
  
  public void setHomeEditItem(MenuItem paramMenuItem)
  {
    this.mHomeEditItem = paramMenuItem;
  }
  
  public void setHomeScreenAt(int paramInt)
  {
    LauncherApplication.setHomeScreenIndex(getActivity(), paramInt);
  }
  
  public void setHotseat(Hotseat paramHotseat)
  {
    this.mHotseat = paramHotseat;
    this.mHotseat.setup(this);
  }
  
  public void setPage(int paramInt)
  {
    this.mWorkspace.setCurrentPage(paramInt);
  }
  
  public void setPanelBackgroundAlpha(float paramFloat)
  {
    this.mPanelBackgroundAlpha = paramFloat;
    setDummyPanelProperties();
  }
  
  public void setPanelViewport(View paramView)
  {
    if (paramView.getWidth() != 0) {
      sPanelDrawer.setViewport(paramView.getWidth(), paramView.getHeight());
    }
  }
  
  public void setQuickLaunch(QuickLaunch paramQuickLaunch)
  {
    this.mQuickLaunch = paramQuickLaunch;
    this.mQuickLaunch.setup(this);
  }
  
  public void setQuickLaunchCamera(QuickLaunch paramQuickLaunch)
  {
    this.mQuickLaunchCamera = paramQuickLaunch;
    this.mQuickLaunchCamera.setup(this);
  }
  
  public void setStateTargetFolder(FolderItem paramFolderItem)
  {
    this.mTargetFolderId = paramFolderItem.getId();
  }
  
  public void setTabletHotseat()
  {
    if (this.mHotseat != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mHotseat.getLayoutParams();
      localLayoutParams.width = getResources().getDimensionPixelSize(2131624200);
      localLayoutParams.height = getResources().getDimensionPixelSize(2131624201);
      localLayoutParams.rightMargin = getResources().getDimensionPixelSize(2131624197);
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131624199);
      localLayoutParams.gravity = 85;
      this.mHotseat.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setVisibilityHomeOptionMenu(int paramInt)
  {
    View localView = findViewById(2131689680);
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
    if (getHomeScreenOptionMenu() != null)
    {
      if (paramInt == 0) {
        getHomeScreenOptionMenu().setMakeActive(true);
      }
    }
    else {
      return;
    }
    getHomeScreenOptionMenu().setMakeActive(false);
  }
  
  public void setVisibilityHotseat(int paramInt)
  {
    View localView = findViewById(2131689595);
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
  }
  
  public void setWorkspaceLoading()
  {
    this.mWorkspaceLoading = true;
  }
  
  public void setupCameraCut(int paramInt)
  {
    this.mCameraCut = ((ImageView)findViewById(2131689608));
    if (paramInt == 2)
    {
      this.mCameraCut.setBackgroundResource(2130837513);
      return;
    }
    this.mCameraCut.setBackgroundResource(2130837514);
  }
  
  void showAllApps()
  {
    if (getActivity() != null) {
      ((Launcher)getActivity()).showAllApps();
    }
  }
  
  public void showCameraCut(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (paramBoolean2)
    {
      localObject = getContext();
      if (paramBoolean1)
      {
        i = 2130968576;
        localObject = AnimationUtils.loadAnimation((Context)localObject, i);
        this.mCameraCut.startAnimation((Animation)localObject);
        label35:
        localObject = this.mCameraCut;
        if (!paramBoolean1) {
          break label71;
        }
      }
    }
    label71:
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      return;
      i = 2130968577;
      break;
      this.mCameraCut.clearAnimation();
      break label35;
    }
  }
  
  public void showDeleteWorkScreen()
  {
    if (((Launcher)getActivity()).isPaused()) {
      return;
    }
    this.mIsDeletePopup = true;
    DeleteWorkscreenDialogFragment.createAndShow(((Activity)getContext()).getFragmentManager());
  }
  
  public void showHomeBottomBar()
  {
    if ((this.mHomeBottomBar != null) && (this.mHomeBottomBar.getVisibility() != 0)) {
      this.mHomeBottomBar.setVisibility(0);
    }
    if ((LauncherApplication.isTabletLayout()) && (this.mHotseat != null) && (this.mHotseat.getVisibility() != 0)) {
      this.mHotseat.setVisibility(0);
    }
  }
  
  void showHotseat(boolean paramBoolean)
  {
    if (this.mHotseat != null)
    {
      if (paramBoolean) {
        this.mHotseat.animate().alpha(1.0F).setDuration(200L);
      }
    }
    else {
      return;
    }
    this.mHotseat.setAlpha(1.0F);
  }
  
  void showOutOfSpaceMessage()
  {
    showOutOfSpaceMessage(getActivity());
  }
  
  void showWorkspace(boolean paramBoolean)
  {
    int i = getResources().getInteger(2131492869);
    if (this.sIsHeadlinesHiddenForEditMode)
    {
      ((Launcher)getActivity()).setEnableHeadlines(true);
      this.sIsHeadlinesHiddenForEditMode = false;
    }
    this.mWorkspace.changeState(Workspace.State.NORMAL, paramBoolean, i, null);
    updateRunning();
    getActivity().getWindow().getDecorView().sendAccessibilityEvent(4);
    closeQuickViewWorkspace(true);
  }
  
  void showWorkspaceEditmode(boolean paramBoolean)
  {
    int i = getResources().getInteger(2131492869);
    if ((Launcher.sIsHeadlinesAppEnable) && (!this.sIsHeadlinesHiddenForEditMode))
    {
      ((Launcher)getActivity()).setEnableHeadlines(false);
      this.sIsHeadlinesHiddenForEditMode = true;
    }
    this.mWorkspace.closeFolder();
    Launcher.setHomeEditMode(true);
    this.mWorkspace.changeState(Workspace.State.EDIT, paramBoolean, i, null);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (paramInt >= 0) {
      this.mWaitingForResult = true;
    }
    ((Launcher)getContext()).startActivityForResult(paramIntent, paramInt, this);
  }
  
  void startActivityForResultSafely(Intent paramIntent, int paramInt)
  {
    try
    {
      startActivityForResult(paramIntent, paramInt);
      return;
    }
    catch (ActivityNotFoundException paramIntent)
    {
      Toast.makeText(getActivity(), 2131755010, 0).show();
      return;
    }
    catch (SecurityException localSecurityException)
    {
      Toast.makeText(getActivity(), 2131755010, 0).show();
      Log.e("Launcher.HomeView", "Launcher does not have the permission to launch " + paramIntent + ". Make sure to create a MAIN intent-filter for the corresponding activity " + "or use the exported attribute for this activity.", localSecurityException);
    }
  }
  
  void startApplicationDetailsActivity(ComponentName paramComponentName)
  {
    paramComponentName = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", paramComponentName.getPackageName(), null));
    paramComponentName.setFlags(276824064);
    getContext().startActivity(paramComponentName);
  }
  
  void startApplicationUninstallActivity(AppItem paramAppItem)
  {
    if (paramAppItem.mComponentName != null)
    {
      if (paramAppItem.mSystemApp) {
        Toast.makeText(getActivity(), 2131755112, 0).show();
      }
    }
    else {
      return;
    }
    paramAppItem = new Intent("android.intent.action.DELETE", Uri.fromParts("package", paramAppItem.mComponentName.getPackageName(), paramAppItem.mComponentName.getClassName()));
    paramAppItem.setFlags(276824064);
    getContext().startActivity(paramAppItem);
  }
  
  public void startBinding()
  {
    Workspace localWorkspace = this.mWorkspace;
    if (localWorkspace == null) {}
    do
    {
      return;
      localWorkspace.abortConfigChanges();
      this.mWorkspaceLoading = true;
      int j = localWorkspace.getChildCount();
      int i = 0;
      while (i < j)
      {
        ((CellLayout)localWorkspace.getChildAt(i)).removeAllViewsInLayout();
        i += 1;
      }
      if (this.mHotseat != null) {
        this.mHotseat.resetLayout();
      }
      if (this.mQuickLaunch != null) {
        this.mQuickLaunch.resetLayout();
      }
    } while (this.mQuickLaunchCamera == null);
    this.mQuickLaunchCamera.resetLayout();
  }
  
  void startWallpaper(int paramInt)
  {
    this.mWorkspace.exitWidgetResizeMode();
    Intent localIntent = new Intent("com.sec.android.app.wallpapers.WallpaperPickerActivity");
    localIntent.putExtra("type", paramInt);
    if (paramInt == 0)
    {
      localIntent.putExtra("android.intent.extra.INTENT", new Intent("android.intent.action.SET_WALLPAPER"));
      if (Launcher.isHelpAppRunning)
      {
        localIntent.putExtra("mode", "Guide_Mode");
        startActivityForResult(localIntent, 10);
        return;
      }
      try
      {
        localIntent.putExtra("mode", "null");
        startActivityForResult(localIntent, 10);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException1)
      {
        Toast.makeText(this.mWorkspace.getContext(), 2131755010, 0).show();
        return;
      }
    }
    try
    {
      startActivityForResult(localActivityNotFoundException1, 10);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException2)
    {
      Toast.makeText(this.mWorkspace.getContext(), 2131755010, 0).show();
    }
  }
  
  public boolean updateGlobalSearchIcon()
  {
    return false;
  }
  
  protected void updateRunning()
  {
    long l = 20000L;
    boolean bool;
    if (!this.mWidgetsToAdvance.isEmpty())
    {
      bool = true;
      if (bool != this.mAutoAdvanceRunning)
      {
        this.mAutoAdvanceRunning = bool;
        if (!bool) {
          break label63;
        }
        if (this.mAutoAdvanceTimeLeft != -1L) {
          break label55;
        }
      }
    }
    for (;;)
    {
      sendAdvanceMessage(l);
      return;
      bool = false;
      break;
      label55:
      l = this.mAutoAdvanceTimeLeft;
    }
    label63:
    if (!this.mWidgetsToAdvance.isEmpty()) {
      this.mAutoAdvanceTimeLeft = Math.max(0L, 20000L - (System.currentTimeMillis() - this.mAutoAdvanceSentTime));
    }
    this.mHandler.removeMessages(1);
    this.mHandler.removeMessages(0);
  }
  
  public void updateWallpaperOffsets()
  {
    this.mWorkspace.updateWallpaperOffsets();
  }
  
  void updateWallpaperVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1048576;; i = 0)
    {
      if (i != (getActivity().getWindow().getAttributes().flags & 0x100000)) {
        getActivity().getWindow().setFlags(i, 1048576);
      }
      return;
    }
  }
  
  public void wallpaperHack()
  {
    this.mWorkspace.setVisibility(0);
  }
  
  private class AppWidgetResetObserver
    extends ContentObserver
  {
    public AppWidgetResetObserver()
    {
      super();
    }
    
    public void onChange(boolean paramBoolean)
    {
      HomeView.this.onAppWidgetReset();
    }
  }
  
  public static class DropPos
  {
    int mCellX;
    int mCellY;
    boolean mFoundInCurrentScreen = false;
    int mScreen;
    
    public void assign(CellLayout paramCellLayout, int paramInt1, int paramInt2, int paramInt3)
    {
      this.mScreen = paramInt1;
      this.mCellX = paramInt2;
      this.mCellY = paramInt3;
    }
  }
  
  public class HomeEditTabClickListener
    implements View.OnClickListener
  {
    public HomeEditTabClickListener() {}
    
    public void onClick(View paramView)
    {
      if ((Launcher.isHelpAppRunning) && (GuideFragment.GMode.equals("add_widgets")) && (GuideFragment.GMode.equals("change_wallpaper"))) {}
      while (!Launcher.isHomeEditMode()) {
        return;
      }
      switch (paramView.getId())
      {
      default: 
        return;
      }
      Launcher.setHomeRemoveMode(false);
      Launcher.setHomeEditMode(false);
      HomeView.this.showWorkspace(true);
    }
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    public boolean customPosition = false;
    public int x;
    public int y;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public int getHeight()
    {
      return this.height;
    }
    
    public int getWidth()
    {
      return this.width;
    }
    
    public int getX()
    {
      return this.x;
    }
    
    public int getY()
    {
      return this.y;
    }
    
    public void setHeight(int paramInt)
    {
      this.height = paramInt;
    }
    
    public void setWidth(int paramInt)
    {
      this.width = paramInt;
    }
    
    public void setX(int paramInt)
    {
      this.x = paramInt;
    }
    
    public void setY(int paramInt)
    {
      this.y = paramInt;
    }
  }
  
  private static class PendingAddArguments
  {
    int cellX;
    int cellY;
    long container;
    int[] dropPos;
    Intent intent;
    boolean isSecretItem;
    int requestCode;
    int screen;
    int spanX;
    int spanY;
  }
  
  private static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public HomeView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new HomeView.SavedState(paramAnonymousParcel);
      }
      
      public HomeView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new HomeView.SavedState[paramAnonymousInt];
      }
    };
    int INVALID = -1;
    int currentScreen = this.INVALID;
    int darkenLayerVisibility = 0;
    Bundle folderBundle = null;
    boolean inQuickView = false;
    int pendingAddCellX = this.INVALID;
    int pendingAddCellY = this.INVALID;
    long pendingAddContainer = this.INVALID;
    int pendingAddDropPosX = this.INVALID;
    int pendingAddDropPoxY = this.INVALID;
    int pendingAddScreen = this.INVALID;
    int pendingAddSecretItem = this.INVALID;
    int pendingAddSpanX = this.INVALID;
    int pendingAddSpanY = this.INVALID;
    int quickViewDeleteIndex = this.INVALID;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.currentScreen = paramParcel.readInt();
      this.pendingAddContainer = paramParcel.readLong();
      this.pendingAddScreen = paramParcel.readInt();
      this.pendingAddCellX = paramParcel.readInt();
      this.pendingAddCellY = paramParcel.readInt();
      this.pendingAddSpanX = paramParcel.readInt();
      this.pendingAddSpanY = paramParcel.readInt();
      this.pendingAddDropPosX = paramParcel.readInt();
      this.pendingAddDropPoxY = paramParcel.readInt();
      this.pendingAddSecretItem = paramParcel.readInt();
      if (paramParcel.readByte() == 1) {}
      for (;;)
      {
        this.inQuickView = bool;
        this.quickViewDeleteIndex = paramParcel.readInt();
        this.darkenLayerVisibility = paramParcel.readInt();
        this.folderBundle = paramParcel.readBundle();
        return;
        bool = false;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.currentScreen);
      paramParcel.writeLong(this.pendingAddContainer);
      paramParcel.writeInt(this.pendingAddScreen);
      paramParcel.writeInt(this.pendingAddCellX);
      paramParcel.writeInt(this.pendingAddCellY);
      paramParcel.writeInt(this.pendingAddSpanX);
      paramParcel.writeInt(this.pendingAddSpanY);
      paramParcel.writeInt(this.pendingAddDropPosX);
      paramParcel.writeInt(this.pendingAddDropPoxY);
      paramParcel.writeInt(this.pendingAddSecretItem);
      if (this.inQuickView) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.quickViewDeleteIndex);
        paramParcel.writeInt(this.darkenLayerVisibility);
        paramParcel.writeBundle(this.folderBundle);
        return;
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */