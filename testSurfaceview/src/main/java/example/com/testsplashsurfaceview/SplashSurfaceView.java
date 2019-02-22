//
//package example.com.testsplashsurfaceview;
//
//import android.animation.Animator;
//import android.animation.AnimatorListenerAdapter;
//import android.animation.ValueAnimator;
//import android.app.WallpaperInfo;
//import android.app.WallpaperManager;
//import android.content.Context;
//import android.content.Intent;
//import android.content.res.Configuration;
//import android.content.res.Resources;
//import android.graphics.Bitmap;
//import android.graphics.Bitmap.Config;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.LinearGradient;
//import android.graphics.Matrix;
//import android.graphics.NinePatch;
//import android.graphics.Paint;
//import android.graphics.Paint.Style;
//import android.graphics.PixelFormat;
//import android.graphics.PorterDuff;
//import android.graphics.PorterDuffXfermode;
//import android.graphics.Rect;
//import android.graphics.RectF;
//import android.graphics.Shader;
//import android.graphics.SweepGradient;
//import android.graphics.Typeface;
//import android.graphics.drawable.BitmapDrawable;
//import android.graphics.drawable.Drawable;
//import android.os.Build;
//import android.os.SystemClock;
//import android.text.Layout;
//import android.text.StaticLayout;
//import android.text.TextPaint;
//import android.text.TextUtils;
//import android.util.AttributeSet;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.animation.AccelerateDecelerateInterpolator;
//import android.view.animation.AccelerateInterpolator;
//import android.view.animation.DecelerateInterpolator;
//import android.view.animation.Interpolator;
//import android.view.animation.OvershootInterpolator;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.List;
//import java.util.Random;
//
//public class SplashSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
//
//    private static String TAG = "SplashSurfaceView";
//
//    private static final int FPS = 60;
//    private static final int NANO = 1000000000;
//    // private static final int TITILE_MARGIN_TOP = 161;
//    private static final int TITLE_MARGIN_LARGE = 44;
//    private static final int TITLE_MARGIN_MEDIUM = 15;
//    private static final int PRIVACY_MARGIN = 8;
//    private static final float TITLE_MARGIN_SMALL = 20;
//    private static final float FONT_SIZE_XLARGE = 21.0f;
//    private static final float FONT_SIZE_LARGE = 29.0f;
//    private static final float FONT_SIZE_SMALL = 16.0f;
//    private static final float PRIVACY_CLICK_AREA = 8.0f;
//    private static final float DELAY_ZERO = 0.80f;
//    private static final float ICON_IN_DURATION = 0.50f;
//    private static final float TRANSLATE_DELAY = DELAY_ZERO + ICON_IN_DURATION + 0.1f;
//    private static final float TRANSLATE_DURATION = 0.6f;
//    private static final float DELAY_FIRST = TRANSLATE_DELAY + TRANSLATE_DURATION + 0.1f;
//    private static final float DELAY_SECOND = DELAY_FIRST + 0.8f;
//    private static final float BUBBLE_DURATION = 1.3f;
//    private static final float TOP_DISTANCE_PERCENT = 0.59f;
//    private static final float PRIVACY_TOP_DISTANCE = 35.0f;
//    private static final float UAGETOP_PRIVACY_TOP_DISTANCE = 57.5f;
//    private static final float DELAY_PRIVACYPOLICY = DELAY_SECOND + 0.8f;
//    private static final float PRIVACYPOLICY_BUTTOM = 16.5f;
//    private static final float USAGEAGREE_BUTTOM = 8f;
//
//    public static final int TYPE_SHOW_WALLPAPER = 0;
//    public static final int TYPE_SHOW_THEME = 1;
//    public static final int TYPE_SHOW_ORGANIZING = 2;
//    public static final int TYPE_SHOW_WALLPAPER_NEW = 3;
//
//    private boolean mIsFirstLaunch = false;
//    private boolean mIsClick = false;
//    private boolean mIsPrivacyClick = false;
//    private boolean mIsUsageClick = false;
//    private boolean mIsPrivacyCheckClick = true;
//    private boolean mIsPrivacyCheck = true;
//
//    private boolean mIsLockerScreenCheck = true;
//    private boolean mIsLockerScreenClick = true;
//    private boolean mIsTouchStart = false;
//    private boolean mIsStart = false;
//    private boolean mIsHide = false;
//    private boolean mIsRunning = false;
//    private boolean mStopped = false;
//    private int mMaxRadius = -1;
//    private int mMaxRadiusOffset = -1;
//    private int mStartCycleRadius = -1;
//    private int mLogoRadius = -1;
//    private int mTitleTop = -1;
//    private int mTitleBottom = -1;
//    private int mStartTextWidth = -1;
//    private int mTitleTextWidth = -1;
//    private int mStartTextWidthDimen = -1;
//    private int mSubTitleUpperTextWidth = -1;
//    private int mSubTitleLowerTextWidth = -1;
//    private int mOrganizingTipTextWidth = -1;
//    private int mUsageAgreeTextWidth = -1;
//    private int mPrivacyPolicyTextWidth = -1;
//    private int mUsagePolicyTextWidth = -1;
//    //locker&screen textWidth
//    private int mLockerScreenPolicyWidth = -1;
//    private long mStartTime = 0l;
//    private long mDrawStartTime = 0l;
//    private long mPrivacyHideTime = 0l;
//    private long mProgressTime = 0l;
//    private long mThemeWallPaperShowTime = 0l;
//    private long mProgressOffsetTime = 0l;
//    private long mWallPaperStartTime = 0l;
//    private long mButtonStartTime = 0l;
//    private float mDensity = 1;
//    private float mProgress = 0f;
//    private float mButtonCenterX = 0;
//    private float mButtonCenterY = 0; // 原点坐标
//    private float mScreenCenterX = 0;
//    private float mScreenCenterY = 0;
//    private float mPrivacyFontSize = 12.0f;
//    private String mSubTitleLower = null;
//    private String mSubTitleUpper = null;
//    private String mTitleText = null;
//    private String mStartText = null;
//    private String mPrivacyPolicyText = null;
//    private String mUsagePolicyText = null;
//    private String mUsageAgreeText = null;
//    //locker&screen title
//    private String mLockerScreenPolicyText = null;
//    private String mChooseWallpaperTitle;
//    private String mRecommendWallpaper;
//    private String mCurrentWallpaper;
//    private String mNext;
//    private String mOrganizingTips = null;
//    //    private boolean mHasInstallCMTTheme = false;
////    private boolean mHasThemeAndLiveWallpaper = false;
//    private boolean mShowTurnAround = false;
//    private boolean mApplyCMTFinsh = false;
//    private boolean mShowPolicy = true;
//
//    private boolean isClickNext;
//    private boolean isClickApply;
//    private boolean isLoadingClickNext;
//    private Paint paint = null;
//    //    private Bitmap mBigWallpaper = null;
//    private Bitmap mIconBitmap = null;
//    private Bitmap mBmpAround = null;
//    private Bitmap mPrivacyPolicyIcon = null;
//    private Bitmap mPrivacyPolicyIconCheck = null;
//
//    private Bitmap mLockerWallpaper;
//    private Bitmap mLight;
//
//    private boolean isClickCurrent = false;
//
//
//    //locker&screen的圆圈图片
//    private Bitmap mLockerScreenPolicyIcon = null;
//    //locker&screen的check图片
//    private Bitmap mLockerScreenPolicyIconCheck;
//
//    private Bitmap mWallPaperBitmap = null;
//    private Stars mStars = null;
//    private Drawable mStartArrowDrawable = null;
//    private BgDrawable mBgDrawable = null;
//    private StartCycles mStartCycles = null;
//    private CycleProgress mCycleProgress = null;
//    private DrawingThread mDrawingThread = null;
//    private OrganizingDesktop mOrganizingDesktop = null;
//    private WallpaperChoose mWallpaperChoose = null;
//    private LockerChoose mLockerChoose = null;
//    private ThemeChoose mThemeChoose = null;
//    //    private NewWallpaperChoose mNewWallpaperChoose = null;
//    private OnSplashProgressListener mListener = null;
//    private LauncherColdStartWaitingReport mColdStartReport = null;
//    private boolean mFirstFrameDisplayIsComplete;
//
//    private ValueAnimator mStartAnimator = null;
//    private ValueAnimator mStartEndAnimator = null;
//
//    private NinePatch mRecommendNinePath;
//
//    private AccelerateInterpolator mLogoInterpolator;
//    private DecelerateInterpolator mLogoTransferInterpolator;
//    private boolean isSelectedWallpaperFinish = false;
//
//    public long scenesAnimTime;
//    public static float SCENESANIM_DURATION = 2.4f;
//    public static float SCENESANIM_LOGO_DELAY = 0.4f;
//    public static float SCENESANIM_FIRST_DELAY = 0.46f;
//    public static float SCENESANIM_SECOND_DELAY = 0.52f;
//    public static float SCENESANIM_LOGO_DURATION = 0.8f;
//    public boolean scenesAnimFinish;
//    private float mBarLeftMargin = 0;
//    private float mBarTopMargin = 0;
//    private float mBarTextLeftMargin = 0;
//    private float mBarTextTopMargin = 0;
//    private float mBarWidht = 0;
//    private float mBarHeight = 0;
//    private float mBarTopOffset = 0;
//    private boolean mShowProgressReport = false;
//    private float mAutoInstallCMTin = 0;
//    private boolean mWallpaperChangedSuccess = false;
//    private float mNavigationBarHeight = 0;
//    public boolean mIsShowReport = false;
//    private int mCurrentShowType = TYPE_SHOW_WALLPAPER;
//    private boolean showLockerScreenPolicy = false;
//    //locker圆圈的左边位置
//    private int lockerBitmapLeft;
//    private int lockerBitmapRight;
//    private int lockerBitmapTop;
//    private int lockerBitmapBottom;
//
//    //locker文字的左边位置
//    private int lockerTextLeft;
//    private int lockerTextRight;
//    private int lockerTextTop;
//    private int locketTextBottom;
//
//    //policy圆圈的左边位置
//    private int policyBitmapLeft;
//    private int policyBitmapTop;
//    //policy文字的位置
//    private int policyTextLeft;
//    private int policyTextTop;
//    private int firstLeft;
//    private int firstTop;
//    private Matrix wallPaperMatrix = new Matrix();
//    private boolean showEnableLocker;
//    private Bitmap wallpaper;
//    private boolean mIsCombineVersion = false;
//    // private boolean mDownLocker;
//    // private boolean mDownPolicy;
//
//    //    private float indicatorY;
//    private Rect mNextRect;
//    private RectF mNextRectF;
//    private String mTermServiceText;
//    private String mPrivacyPolicyNewText;
//    private int mPrivacyPolicyNewTextWidth;
//    private int mTermServiceTextWidth;
//    private String mAndText;
//    private int mAndTextWidth;
//    private int mTermsServiceLeft;
//    private int mAndLeft;
//    private int mPrivacyPolicyLeft;
//    private boolean mIsTermsServiceClick;
//    private boolean mIsPrivacyPolicyClick;
//    private int mMargin;
//    //    private SplashLockerEnableHelper enableHelper;
//    private boolean mDrawFlag = true;
//    private Object mLockObject = new Object();
//
//    public SplashSurfaceView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        setZOrderOnTop(true);
//        getHolder().setFormat(PixelFormat.RGBA_8888);
//        getHolder().addCallback(this);
//        setFocusable(true);
//    }
//
//    public void init(boolean isFirstLaunch) {
////        EventBus.getDefault().register(this);
//        mIsFirstLaunch = isFirstLaunch;
//        initPaint(getContext());
//
//        initResources();
//        initDrawables();
////        initBitmap();
//        measureText();
//
//        mIsStart = mIsFirstLaunch ? false : true;
//        if (mIsFirstLaunch) {
//            mStartTime = System.nanoTime();
//            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//                mStartTime -= 10 * NANO;
//            }
//        } else {
//            mStartTime = 0;
//        }
//
//        mLogoInterpolator = new AccelerateInterpolator(4f);
//        mLogoTransferInterpolator = new DecelerateInterpolator();
//    }
//
////    public void lookupCMTTheme(boolean bFind){
////        mHasInstallCMTTheme = bFind;
////    }
////
////    public void lookupCMTThemeAndLiveWallpaper(boolean bFind){
////        mHasThemeAndLiveWallpaper= bFind;
////    }
//
//    public void setShowType(int showType) {
//        mCurrentShowType = showType;
//        initShowType();
//    }
//
//    public void initShowType() {
//        if (mCurrentShowType == TYPE_SHOW_ORGANIZING) {
//            mOrganizingDesktop = new OrganizingDesktop(false);
//        } else if (mCurrentShowType == TYPE_SHOW_THEME) {
//            mThemeChoose = new ThemeChoose();
//        } else {
//            mWallpaperChoose = new WallpaperChoose();
//            mLockerChoose = new LockerChoose();
//
//        }
//    }
//
//    public void setWallPaperBitmap(Bitmap b) {
//        mWallPaperBitmap = b;
//    }
//
//
//    private void initResources() {
//        final Resources resources = getResources();
//        mDensity = resources.getDisplayMetrics().density;
//        mStartText = resources.getString(R.string.start);
//        mTitleText = resources.getString(R.string.application_name);
//        mSubTitleUpper = resources.getString(R.string.cm_sub_title_1);
//        //mSubTitleLower = resources.getString(R.string.cm_sub_title_2);
//        mChooseWallpaperTitle = resources.getString(R.string.splash_choose_wallpaper_new);
//        mRecommendWallpaper = resources.getString(R.string.splash_recommend_wallpaper);
//        mCurrentWallpaper = resources.getString(R.string.splash_current_wallpaper);
//        mNext = resources.getString(R.string.splash_next);
//        mOrganizingTips = resources.getString(R.string.splash_orgainizing_desktop);
//        mMaxRadius = (int) (resources.getDimension(R.dimen.splash_cycle_max) / 2);
//        mMaxRadiusOffset = (int) (mMaxRadius - (29 * mDensity));
//        mLogoRadius = (int) (resources.getDimension(R.dimen.splash_logo_width) / 2);
//        mStartCycleRadius = (int) (resources.getDimension(R.dimen.splash_start_cycle_width) / 2);
//        mStartTextWidthDimen = (int) (resources.getDimension(R.dimen.splash_start_cycle_width));
//        mIconBitmap = BitmapFactory.decodeResource(resources, R.drawable.icon_loading_logo);
//        mBmpAround = BitmapFactory.decodeResource(resources, R.drawable.splash_loading);
//        mBarLeftMargin = resources.getDimension(R.dimen.splash_progressbar_left_margin);
//        mBarTopMargin = resources.getDimension(R.dimen.splash_progressbar_top_margin);
//        mBarTextTopMargin = resources.getDimension(R.dimen.splash_progressbar_text_top_margin);
//        mBarTextLeftMargin = resources.getDimension(R.dimen.splash_progressbar_text_left_margin);
//
//        mBarWidht = resources.getDimension(R.dimen.splash_progressbar_width);
//        mBarHeight = resources.getDimension(R.dimen.splash_progressbar_height);
//        mBarTopOffset = resources.getDimension(R.dimen.splash_progressbar_top_offset);
//
//        Bitmap recommendBitmap = BitmapFactory.decodeResource(resources,
//                R.drawable.splash_recommend_bg);
//        mRecommendNinePath = new NinePatch(recommendBitmap, recommendBitmap.getNinePatchChunk(),
//                null);
//
//        mNavigationBarHeight = SystemUtils.getNavigationBarHeight(getContext());
//        if (mIsFirstLaunch) {
//            mPrivacyPolicyText = resources.getString(R.string.usage_policy);
//            mPrivacyPolicyIcon = BitmapFactory
//                    .decodeResource(resources, R.drawable.privacy_uncheck);
//            mPrivacyPolicyIconCheck = BitmapFactory.decodeResource(resources,
//                    R.drawable.privacy_selected);
//            mUsagePolicyText = resources.getString(R.string.splash_view_privacy);
//
//            mTermServiceText = resources.getString(R.string.splash_term_service);
//            mPrivacyPolicyNewText = resources.getString(R.string.splash_privacy_policy);
//            mAndText = "&";
//
//            mUsageAgreeText = resources.getString(R.string.splsh_agree_text);
//        }
//
//        if (showLockerScreenPolicy) {
//            mLockerScreenPolicyIcon = BitmapFactory.decodeResource(resources, R.drawable
//                    .privacy_uncheck);
//            mLockerScreenPolicyIconCheck = BitmapFactory.decodeResource(resources, R.drawable
//                    .privacy_selected);
//            mLockerScreenPolicyText = resources.getString(R.string.splash_locker_screen_policy);
//        }
//    }
//
//    private void initPaint(Context context) {
//        paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setColor(0xffffffff);
//        paint.setTypeface(TextFontsManager.getInstance().getCurrentFonts());
//    }
//
//    private void initDrawables() {
//        mStars = new Stars();
//        mStartCycles = new StartCycles();
//        mCycleProgress = new CycleProgress(true);
//    }
//
////    private void initBitmap() {
////        if (mIsFirstLaunch || mBigWallpaper != null) {
////            return;
////        }
////        Runnable r = new Runnable() {
////
////            @Override
////            public void run() {
////                try {
////                    File bitmapFile ;
////                    bitmapFile = new File(getContext().getFilesDir(),
////                            WallpaperHelper.DEFAULT_WALLPAPER_WITH_EFFECT_FILE_NAME);
////                    if (bitmapFile == null || !bitmapFile.exists()) {
////                        return;
////                    }
////                    setWallPaper(BitmapFactory.decodeStream(new FileInputStream(bitmapFile)));
////                } catch (Throwable t) {
////                    KLog.e(TAG, "tryDecodeBitmap ", t);
////                }
////            }
////        };
////        ThreadManager.post(ThreadManager.THREAD_DATA, r);
////    }
//
//    private void measureText() {
//        paint.setTextSize(FONT_SIZE_XLARGE * mDensity);
//        paint.setFakeBoldText(false);
//        mStartTextWidth = (int) paint.measureText(mStartText);
//        if (mStartTextWidth >= mStartTextWidthDimen - 10) {
//            mStartArrowDrawable = getResources().getDrawable(R.drawable.ic_startarrow);
//        }
//
//        paint.setTextSize(FONT_SIZE_LARGE * mDensity);
//        paint.setFakeBoldText(false);
//        mTitleTextWidth = (int) paint.measureText(mTitleText);
//
//        paint.setTextSize(FONT_SIZE_SMALL * mDensity);
//        paint.setFakeBoldText(false);
//        mSubTitleUpperTextWidth = (int) paint.measureText(mSubTitleUpper);
//        //mSubTitleLowerTextWidth = (int) paint.measureText(mSubTitleLower);
//
//        paint.setTextSize(FONT_SIZE_SMALL * mDensity);
//        paint.setFakeBoldText(false);
//        String temp = String.format(mOrganizingTips, String.valueOf(10));
//        mOrganizingTipTextWidth = (int) paint.measureText(temp);
//
//        if (mIsFirstLaunch) {
//            updatePrivacyTextWidth();
//        }
//
//    }
//
//
//    private void updatePrivacyTextWidth() {
//        int width = getResources().getDisplayMetrics().widthPixels;
////        while (true) {
//        paint.setTextSize(mPrivacyFontSize * mDensity);
//        paint.setFakeBoldText(false);
//        mUsageAgreeTextWidth = (int) paint.measureText(mUsageAgreeText);
//        paint.setUnderlineText(true);
//        mPrivacyPolicyTextWidth = (int) paint.measureText(mPrivacyPolicyText);
//
//        mPrivacyPolicyNewTextWidth = (int) paint.measureText(mPrivacyPolicyNewText);
//        mTermServiceTextWidth = (int) paint.measureText(mTermServiceText);
//        mAndTextWidth = (int) paint.measureText(mAndText);
//        mMargin = mAndTextWidth / 2;   //这个是和&的间距
//
//        mUsagePolicyTextWidth = (int) paint.measureText(mUsagePolicyText);
//        paint.setUnderlineText(false);
//        //满足ab显示条件
//        if (showLockerScreenPolicy) {
//            mLockerScreenPolicyWidth = (int) paint.measureText(mLockerScreenPolicyText);
//        }
//
////            if (mUsageAgreeTextWidth + mUsagePolicyTextWidth > width - 20) {
//////                mPrivacyFontSize -= 1.0f;
////            } else {
////                break;
////            }
////        }
//    }
//
//    @Override
//    public void surfaceCreated(SurfaceHolder holder) {
//        synchronized (mLockObject) {
//            mDrawFlag = true;
//        }
//        if (mCurrentShowType == TYPE_SHOW_THEME) {
//            if (!(mThemeChoose != null && mIsStart) || isRunning()) {
//                setRunning(true);
//                mDrawingThread = new DrawingThread();
//                mDrawingThread.start();
//                requestFocus();
//            } else {
//                destroy();
//            }
//        } else {
//            if (!(mWallpaperChoose != null && mWallpaperChoose.isGone() && mIsStart) || isRunning
//                    ()) {
//                setRunning(true);
//                mDrawingThread = new DrawingThread();
//                mDrawingThread.start();
//                requestFocus();
//            } else {
//                destroy();
//            }
//        }
//
//        //
//        UserBehaviorIPCManager.getInstance().report(false, InfocConstants
//                        .MODEL_LAUNCHER_SPLASH_START,
//                InfocConstants.COMMON_KEY_CLKTIME, String.valueOf(System.nanoTime()));
//    }
//
//    @Override
//    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//        mButtonCenterX = width / 2f;
//        mButtonCenterY = TOP_DISTANCE_PERCENT * height + (1 - TOP_DISTANCE_PERCENT) * height / 2f
//                - 30 * mDensity;
//        mScreenCenterX = mButtonCenterX;
//        mScreenCenterY = height / 2;
//
//        mTitleTop = Math.max(0, (int) ((TOP_DISTANCE_PERCENT * height - (FONT_SIZE_LARGE + 2
//                * FONT_SIZE_SMALL
//                + TITLE_MARGIN_LARGE + TITLE_MARGIN_SMALL)
//                * mDensity) / 2));
//        mTitleBottom = mTitleTop + (int) (FONT_SIZE_LARGE * mDensity);
//
//        if (mStartArrowDrawable != null) {
//            mStartArrowDrawable.setBounds(
//                    (int) (mButtonCenterX - mStartArrowDrawable.getIntrinsicWidth() / 2),
//                    (int) (mButtonCenterY - mStartArrowDrawable.getIntrinsicHeight() / 2),
//                    (int) (mButtonCenterX + mStartArrowDrawable.getIntrinsicWidth() / 2),
//                    (int) (mButtonCenterY + mStartArrowDrawable.getIntrinsicHeight() / 2));
//        }
//        mBgDrawable = new BgDrawable(width, height);
//    }
//
//    @Override
//    public void surfaceDestroyed(SurfaceHolder holder) {
//        setRunning(false);
//        synchronized (mLockObject) {
//            mDrawFlag = false;
//        }
//        if (mDrawingThread != null) {
//            synchronized (this) {
//                if (mStopped) {
//                    mStopped = false;
//                    notify();
//                }
//            }
//            try {
//                mDrawingThread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public void surfaceRedrawNeeded(SurfaceHolder holder) {
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        if (!isRunning())
//            return true;
//        if (mIsStart && mCurrentShowType == TYPE_SHOW_ORGANIZING) {
//            return true;
//        }
//
//        if (mIsStart && scenesAnimFinish) {
//            if (mCurrentShowType == TYPE_SHOW_THEME) {
//                if (null != mThemeChoose) {
//                    mThemeChoose.onTouchEvent(event);
//                }
//            } else {
//                if (null != mWallpaperChoose && !isClickNext) {
//                    mWallpaperChoose.onTouchEvent(event);
//                } else {
//                    if (mLockerChoose != null) {
//                        mLockerChoose.onTouchEvent(event);
//                    }
//                }
//
//            }
//
//            return true;
//        }
//
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//
//            if (mDrawStartTime == 0) {
//                return true;
//            }
//            float x = event.getX();
//            float y = event.getY();
//
//            if (x >= mButtonCenterX - mStartCycleRadius / 2
//                    && x <= mButtonCenterX + mStartCycleRadius / 2) {
//                if (y >= mButtonCenterY - mStartCycleRadius / 2
//                        && y <= mButtonCenterY + mStartCycleRadius / 2) {
//                    mIsClick = true;
//                    mIsTouchStart = true;
//                    onTouchStart();
//                    invalidate();
//                    //隐私条款是否勾选
//                    UserBehaviorIPCManager.getInstance().report(false, InfocConstants
//                                    .MODEL_LAUNCHER_SPLASH_CLICK,
//                            InfocConstants.COMMON_KEY_CLKTIME, String.valueOf(System.nanoTime()),
//                            InfocConstants.COMMON_KEY_VALUE, mIsPrivacyCheck ? "1" : "0");
//                    return true;
//                }
//            }
//
//            //文字
//            int lockerIconTop = lockerBitmapTop;
//            // int top =  lockerIconTop - (int) (mPrivacyFontSize * mDensity) - (int)
//            // (USAGEAGREE_BUTTOM* mDensity);
//            int top = policyBitmapTop;
//            int usageTop = top - (int) (mPrivacyFontSize * mDensity) - (int) (USAGEAGREE_BUTTOM *
//                    mDensity);
//            int left = (int) ((getWidth() + mPrivacyPolicyIcon.getWidth()
//                    - mPrivacyPolicyTextWidth + PRIVACY_MARGIN * mDensity) / 2);
//
//            //点击terms of service
//
//            if (x >= mTermsServiceLeft && x <= mTermsServiceLeft + mTermServiceTextWidth) {
//                if (y >= top - PRIVACY_CLICK_AREA * mDensity
//                        && y <= top + mPrivacyFontSize * mDensity + PRIVACY_CLICK_AREA
//                        * mDensity) {
//                    mIsTermsServiceClick = true;
//                    return true;
//                }
//            }
//
//
//            if (x >= mPrivacyPolicyLeft && x <= mPrivacyPolicyLeft + mPrivacyPolicyNewTextWidth) {
//                if (y >= top - PRIVACY_CLICK_AREA * mDensity
//                        && y <= top + mPrivacyFontSize * mDensity + PRIVACY_CLICK_AREA
//                        * mDensity) {
//                    mIsPrivacyPolicyClick = true;
//                    return true;
//                }
//            }
//
//            //locker勾选框
//            if (showLockerScreenPolicy) {
//                int lockerIconLeft = lockerBitmapLeft;
//                if (x >= lockerIconLeft - PRIVACY_CLICK_AREA * mDensity
//                        && x <= lockerIconLeft + mLockerScreenPolicyIcon.getWidth() +
//                        PRIVACY_CLICK_AREA
//                                * mDensity) {
//                    if (y >= lockerIconTop - PRIVACY_CLICK_AREA * mDensity
//                            && y <= lockerIconTop + mLockerScreenPolicyIcon.getHeight() +
//                            PRIVACY_CLICK_AREA
//                                    * mDensity) {
//                        //   mDownLocker = true;
//                        mIsLockerScreenClick = !mIsLockerScreenClick;
//                        return true;
//                    }
//                }
//            }
//
//        } else if (event.getAction() == MotionEvent.ACTION_UP) {
//
//            float x = event.getX();
//            float y = event.getY();
//            int iconTop = lockerBitmapTop;
//            int top = policyBitmapTop;
//
//            //点击terms of service
//            if (mIsFirstLaunch && mIsTermsServiceClick) {
//                if (x >= mTermsServiceLeft && x <= mTermsServiceLeft + mTermServiceTextWidth) {
//                    if (y >= top - PRIVACY_CLICK_AREA * mDensity
//                            && y <= top + mPrivacyFontSize * mDensity + PRIVACY_CLICK_AREA
//                            * mDensity) {
//                        onTermsServiceClick();
//                    }
//                }
//
//            }
//
//            //点击privacy policy
//            if (mIsFirstLaunch && mIsPrivacyPolicyClick) {
//                if (x >= mPrivacyPolicyLeft && x <= mPrivacyPolicyLeft +
//                        mPrivacyPolicyNewTextWidth) {
//                    if (y >= top - PRIVACY_CLICK_AREA * mDensity
//                            && y <= top + mPrivacyFontSize * mDensity + PRIVACY_CLICK_AREA
//                            * mDensity) {
//                        onPrivacyPolicyClick();
//                    }
//                }
//
//            }
//
//            //locker勾选框 判断其他的条件
//            if (showLockerScreenPolicy && mIsLockerScreenCheck != mIsLockerScreenClick) {
//                // int iconLeft = (int) ((getWidth() - mLockerScreenPolicyIcon.getWidth()
//                //       - mLockerScreenPolicyWidth - PRIVACY_MARGIN * mDensity) / 2);
//                int iconLeft = lockerBitmapLeft;
//                if (x >= iconLeft - PRIVACY_CLICK_AREA * mDensity
//                        && x <= iconLeft + mLockerScreenPolicyIcon.getWidth() + PRIVACY_CLICK_AREA
//                        * mDensity) {
//                    if (y >= iconTop - PRIVACY_CLICK_AREA * mDensity
//                            && y <= iconTop + mLockerScreenPolicyIcon.getHeight() +
//                            PRIVACY_CLICK_AREA
//                                    * mDensity) {
//                        mIsLockerScreenCheck = mIsLockerScreenClick;
//                    }
//                }
//            }
//
//            mIsPrivacyCheckClick = mIsPrivacyCheck;
//            mIsPrivacyClick = false;
//
//            if (!mIsClick) {
//
//                return true;
//            }
//
//            if (mDrawStartTime == 0) {
//                return true;
//            }
//            if (mIsTouchStart) {
//                onTouchStartEnd();
//                invalidate();
//            }
//
//
//            if (x >= mButtonCenterX - mStartCycleRadius / 2
//                    && x <= mButtonCenterX + mStartCycleRadius / 2) {
//                if (y >= mButtonCenterY - mStartCycleRadius / 2
//                        && y <= mButtonCenterY + mStartCycleRadius / 2) {
//                    onStartClick();
//                    //判断那个勾选的值，如果勾选上了那就记录一下
//                    SplashLockerDelegate.onSplashStartClick(mIsLockerScreenCheck,
//                            showLockerScreenPolicy);
//                }
//            }
//            mIsClick = false;
//        }
//
//        return true;
//    }
//
//    private float getProgress(long startTime, float delay, float duration) {
//        if (System.nanoTime() == startTime) {
//            return 0;
//        }
//        mProgress = (System.nanoTime() - startTime - delay * NANO) / NANO / duration;
//        if (mProgress > 1)
//            mProgress = 1;
//        else if (mProgress < 0)
//            mProgress = 0;
//        return mProgress;
//    }
//
//    private float getHideAlpha() {
//        // if (mIsHide && mIsStart && mBubbleStartTime > 0) {
//        // float alpha = (float) (System.nanoTime() - mBubbleStartTime) / NANO /
//        // HIDE_DURATION;
//        // return alpha > 1 ? 0 : 1 - alpha;
//        // } else {
//        return 1f;
//        // }
//    }
//
//    public void hide() {
//        ThreadUtils.postOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                mIsHide = true;
//            }
//        });
//    }
//
//    private void destroy() {
//
//        ThreadUtils.postOnUiThread(new Runnable() {
//
//            @Override
//            public void run() {
//                setVisibility(View.GONE);
//                if (getParent() != null) {
//                    ((ViewGroup) getParent()).removeView(SplashSurfaceView.this);
//                }
//                if (mListener != null) {
//                    mListener.onProgress(1, OnSplashProgressListener.Mode.SplashEnd);
//
//                    if (mIsFirstLaunch) {
//                        mListener.onTermsAndConditionInit(mIsPrivacyCheck);
//                    }
//                }
//                if (null != mSynchronizedUpdateManager) {
//                    mSynchronizedUpdateManager.clearListner();
//                    mSynchronizedUpdateManager = null;
//                }
//            }
//        });
//        setRunning(false);
//
//        Log.d("cold_start_waiting", "destroy");
//        if (mColdStartReport != null) {
//            mColdStartReport.setOuttime(SystemClock.uptimeMillis() -
//                    PerformanceMetrics.getApplicationOnCreateTimecurrentTimeMillis());
//            mColdStartReport.report();
//            Log.d("cold_start_waiting", "report");
//        }
//
//        mColdStartReport = null;
//        mDrawingThread = null;
////        mBigWallpaper = null;
//        mIconBitmap = null;
//        mPrivacyPolicyIcon = null;
//        mPrivacyPolicyIconCheck = null;
//        mStars = null;
//        mStartArrowDrawable = null;
//        mBgDrawable = null;
//        mStartCycles = null;
//        mCycleProgress = null;
//        if (null != mWallpaperChoose) {
//            mWallpaperChoose.mSplashLockerWallpaperHelper = null;
//        }
//        mWallpaperChoose = null;
//        mOrganizingDesktop = null;
//        mThemeChoose = null;
//    }
//
//    private synchronized boolean isRunning() {
//        return mIsRunning;
//    }
//
//    private void onStartClick() {
//        if (!mIsStart) {
//            mPrivacyHideTime = 0;
//        }
//        mIsStart = true;
//    }
//
//    private void onTouchStart() {
//        mStartAnimator = ValueAnimator.ofFloat(1f, 0);
//        mStartAnimator.setDuration(100);
//        mStartAnimator.start();
//    }
//
//    private void onTouchStartEnd() {
//        if (mStartAnimator != null) {
//            mStartAnimator.end();
//            mStartAnimator = null;
//        }
//        mStartEndAnimator = ValueAnimator.ofFloat(0, 1f);
//        mStartEndAnimator.setDuration(100);
//        mStartEndAnimator.start();
//        mStartEndAnimator.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                mStartEndAnimator = null;
//                mIsTouchStart = false;
//            }
//        });
//    }
//
//    private void onPrivacyClick() {
//        Intent intent = new Intent();
//        intent.putExtra(SettingAboutWebView.EXTRA_IS_FULL_SCREEN, true);
//        intent.setClass(getContext(), SettingAboutWebView.class);
//        getContext().startActivity(intent);
//        UserBehaviorIPCManager.getInstance().report(false, InfocConstants
//                        .MODEL_SETTING_ABOUT_SELECT,
//                InfocConstants.COMMON_KEY_CLICK, InfocConstants.COMMON_VALUE_2);
//    }
//
//    private void onUsageClick() {
//        SettingAboutActivity.openPrivacyPage(getContext());
//        UserBehaviorIPCManager.getInstance().report(false, InfocConstants
//                        .MODEL_SETTING_ABOUT_SELECT,
//                InfocConstants.COMMON_KEY_CLICK, InfocConstants.COMMON_VALUE_2);
//    }
//
//    private void onTermsServiceClick() {
//        Intent intent = new Intent();
//        intent.putExtra(SettingAboutWebView.EXTRA_IS_FULL_SCREEN, true);
//        intent.putExtra(SettingAboutWebView.EXTRA_TITLE, getResources().getString(R.string
//                .splash_term_service));
//        intent.putExtra(SettingAboutWebView.EXTRA_URL, "http://www.cmcm.com/protocol/site/tos" +
//                ".html");
//        intent.setClass(getContext(), SettingAboutWebView.class);
//        getContext().startActivity(intent);
//    }
//
//    private void onPrivacyPolicyClick() {
//        Intent intent = new Intent();
//        intent.putExtra(SettingAboutWebView.EXTRA_IS_FULL_SCREEN, true);
//        intent.putExtra(SettingAboutWebView.EXTRA_TITLE, getResources().getString(R.string
//                .splash_privacy_policy));
//        intent.putExtra(SettingAboutWebView.EXTRA_URL, "http://www.cmcm.com/protocol/site/privacy" +
//                ".html");
//        intent.setClass(getContext(), SettingAboutWebView.class);
//        getContext().startActivity(intent);
//    }
//
//    public void setOnSplashProgressListener(OnSplashProgressListener listener) {
//        mListener = listener;
//    }
//
//    private synchronized void setRunning(boolean running) {
//        this.mIsRunning = running;
//    }
//
////    public void setWallPaper(Bitmap b) {
////        mBigWallpaper = b;
////    }
//
//    public void showLockerPolicy(boolean showLockerScreenPolicy) {
//        this.showLockerScreenPolicy = showLockerScreenPolicy;
//        //this.showLockerScreenPolicy = true;
//    }
//
//    public interface OnSplashProgressListener {
//
//        void onProgress(float precent, Mode mode);
//
//        void onTermsAndConditionInit(boolean agreed);
//
//        enum Mode {
//            HideProgress, AnimateHide, SplashEnd
//        }
//    }
//
//    // -----------------------------------DRAWING THREAD
//    // START-----------------------------------//
//    // -----------------------------------DRAWING THREAD
//    // START-----------------------------------//
//    // -----------------------------------DRAWING THREAD
//    // START-----------------------------------//
//    private class DrawingThread extends Thread {
//        private Paint mClearPaint = null;
//        private AccelerateInterpolator wallpaerInterpolator = new AccelerateInterpolator();
//        private OvershootInterpolator subTitleInterpolator = new OvershootInterpolator();
//        private float outAnimMoveMaxY;
//
//        public DrawingThread() {
//            mClearPaint = new Paint();
//            mClearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
//            mColdStartReport = new LauncherColdStartWaitingReport();
//        }
//
//        private void drawCanvas() {
//            synchronized (mLockObject) {
//                if (mDrawFlag) {
//                    Canvas canvas = getHolder().lockCanvas();
//                    if (canvas != null) {
//                        try {
//                            canvas.drawPaint(mClearPaint);
//                            if (mIsFirstLaunch) {
//                                drawCanvasFirstLaunch(canvas);
//                            } else {
//                                drawCanvasStartup(canvas);
//                            }
//
//                            if (!mFirstFrameDisplayIsComplete) {
//                                mFirstFrameDisplayIsComplete = true;
//                                if (mColdStartReport != null) {
//                                    mColdStartReport.setStarttime(SystemClock.uptimeMillis() -
//                                            PerformanceMetrics
//                                                    .getApplicationOnCreateTimecurrentTimeMillis());
//                                }
//                            }
//                        } catch (Exception e) {
//                            KLog.w(TAG, "run() lockCanvas()", e);
//                        } finally {
//                            if (canvas != null) {
//                                try {
//                                    getHolder().unlockCanvasAndPost(canvas);
//                                } catch (Exception e) {
//                                    KLog.w(TAG, "run() unlockCanvasAndPost()", e);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        private void drawCanvasFirstLaunch(Canvas canvas) {
//            if (!isSelectedWallpaperFinish) {
//                drawBackground(canvas);
//                drawStars(canvas);
//            }
//            if (mIsStart) {
//                //scenesAnimFinish表述星星上移的动画播放完成
//                if (scenesAnimFinish) {
//                    if (mCurrentShowType == TYPE_SHOW_ORGANIZING) {
//                        //进去界面时间
//                        if (!mShowProgressReport) {
//                            mShowProgressReport = true;
//                            mAutoInstallCMTin = System.currentTimeMillis();
//                        }
//                        if (null != mOrganizingDesktop) {
//                            mOrganizingDesktop.draw(canvas);
//                        }
//                    } else {
//                        if (mCurrentShowType == TYPE_SHOW_THEME) {
//                            if (null != mThemeChoose) {
//                                mThemeChoose.draw(canvas);
//                            }
//
//                            //埋点上报
//                            if (!mIsShowReport && !SplashThemeHelper.getInstance()
//                                    .getHasLiveWallpaper()) {
//                                mIsShowReport = true;
//                                if (SplashThemeHelper.getInstance().getIsAndroidId()) {
//                                    reportShow("1");
//                                } else {
//                                    reportShow("2");
//                                }
//                            }
//                        } else {
//                            if (null != mWallpaperChoose) {
//                                mWallpaperChoose.draw(canvas);
//                                if (isClickNext) {
//                                    if (mLockerChoose != null) {
//                                        mLockerChoose.draw(canvas);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    return;
//                } else if (scenesAnimTime == 0) {
//                    scenesAnimTime = System.nanoTime();
//                }
//            }
//            drawIconAndTitle(canvas);
//            drawSubTitle(canvas);
//
//            drawStart(canvas);
//            drawPrivacyPolicy(canvas);
//        }
//
//        private void drawCanvasStartup(Canvas canvas) {
//            drawBackground(canvas);
//            drawStars(canvas);
//            drawIconAndTitle(canvas);
//            drawSubTitle(canvas);
//            drawProgress(canvas);
//        }
//
//        private void drawCanvasRestore(Canvas canvas) {
//            drawSimpleBackground(canvas);
//            drawSimpleProgress(canvas);
//
//            if (mIsHide) {
//                SplashSurfaceView.this.destroy();
//            }
//        }
//
//        private void drawBackground(Canvas canvas) {
//            if (mBgDrawable != null) {
//                mBgDrawable.draw(canvas);
//            }
//
//            if (System.nanoTime() - mStartTime > 4f * NANO && mDrawStartTime == 0) {
//                mDrawStartTime = System.nanoTime();
//            }
//        }
//
//        private void drawSimpleBackground(Canvas canvas) {
//            // bgRect.set(0, 0, canvas.getWidth(), canvas.getHeight());
//            // paint.setARGB(60, 0, 0, 0);
//            // canvas.drawRect(bgRect, paint);
//        }
//
//        private void drawStars(Canvas canvas) {
//            if (System.nanoTime() < mWallPaperStartTime || !mIsFirstLaunch) {
//                return;
//            }
//            mStars.draw(canvas);
//        }
//
//        private void drawIconAndTitle(Canvas canvas) {
//
//            if (Math.signum(System.nanoTime() - mStartTime - DELAY_ZERO * NANO) < 0) {
//                return;
//            }
//            float outProgress = 0;
//            if (mIsStart && scenesAnimTime > 0) {//mIsStart为true后，开始进行了这个坐标系的排列
//                outProgress = getProgress(scenesAnimTime, SCENESANIM_LOGO_DELAY,
//                        SCENESANIM_LOGO_DURATION);
//                outProgress = wallpaerInterpolator.getInterpolation(outProgress);
//            }
//
//            float iconInProgress = getProgress(mStartTime, DELAY_ZERO, ICON_IN_DURATION);
//            iconInProgress = mLogoInterpolator.getInterpolation(iconInProgress);
//            // 500ms 做图片渐显动画 延时 100ms 后做transfer动画（600ms）
//            float transferProgress = getProgress(mStartTime, TRANSLATE_DELAY, TRANSLATE_DURATION);
//            transferProgress = mLogoTransferInterpolator.getInterpolation(transferProgress);
//
//            int alpha = (int) (iconInProgress * 255);
//            paint.setAlpha(alpha);
//            paint.setTextSize(FONT_SIZE_LARGE * mDensity);
//            paint.setFakeBoldText(false);
//
//            int left = (int) ((canvas.getWidth() - mIconBitmap.getWidth() - mTitleTextWidth -
//                    TITLE_MARGIN_MEDIUM
//                            * mDensity) / 2);
//            float startPos = (canvas.getWidth() - mIconBitmap.getWidth()) / 2f;
//            float moveX = left - startPos;
//            float currentFade = moveX * transferProgress;
//            canvas.drawBitmap(mIconBitmap, startPos + currentFade, mTitleTop - outProgress
//                    * outAnimMoveMaxY - DimenUtils.dp2px(3), paint);
//
//            left = (int) (left + mIconBitmap.getWidth() + TITLE_MARGIN_MEDIUM * mDensity);
//            float top = mTitleTop - outProgress * outAnimMoveMaxY;
//            float start = (left - moveX) + currentFade;
//            RectF rect = new RectF(start, top, start + paint.measureText(mTitleText),
//                    top + (FONT_SIZE_LARGE) * mDensity + 5 * mDensity);
//            canvas.save();
//            canvas.clipRect(rect);
//            float textStartPos = (left - moveX) - paint.measureText(mTitleText);
//            float textMoveX = left - textStartPos;
//            float textCurrentFade = textMoveX * transferProgress;
//            float textTop = top + (FONT_SIZE_LARGE) * mDensity;
//            //Log.e("shenzhixin","top:"+textTop);
//            canvas.drawText(mTitleText, textStartPos + textCurrentFade, textTop, paint);
//
//
//            canvas.restore();
//        }
//
//        private void drawSubTitle(Canvas canvas) {
//
//            if (Math.signum(System.nanoTime() - mStartTime - DELAY_FIRST * NANO) < 0) {
//                return;
//            }
//
//            float x = (canvas.getWidth() - mSubTitleUpperTextWidth) / 2;
//            float y = mTitleBottom + (FONT_SIZE_SMALL + TITLE_MARGIN_LARGE) * mDensity;
//
//            float outProgress = 0f;
//            if (mIsStart) {
//                outProgress = getProgress(scenesAnimTime, SCENESANIM_FIRST_DELAY,
//                        SCENESANIM_LOGO_DURATION);
//                outProgress = wallpaerInterpolator.getInterpolation(outProgress);
//            }
//            float progress = getProgress(mStartTime, DELAY_FIRST, 0.80f);
//
//            progress = subTitleInterpolator.getInterpolation(progress);
//            paint.setTextSize(FONT_SIZE_SMALL * mDensity);
//            int alpha = (int) (progress * 255 * 0.6f);
//            alpha = alpha > 255 * 0.6f ? (int) (255 * 0.6f) : alpha;
//            paint.setAlpha(alpha);
//            paint.setFakeBoldText(false);
//
//            canvas.save();
//
//            canvas.scale(1f, progress, x, y - FONT_SIZE_SMALL * mDensity);
//            y -= outProgress * outAnimMoveMaxY;
//            if (outAnimMoveMaxY == 0) {
//                outAnimMoveMaxY = y + FONT_SIZE_SMALL * mDensity;
//            }
//            canvas.drawText(mSubTitleUpper, x, y, paint);
//            canvas.restore();
//
//
//        }
//
//        private void drawStart(Canvas canvas) {
//            if (mDrawStartTime == 0) {
//                return;
//            }
//            float progress = getProgress(mDrawStartTime, 0, 0.8f);
//            if (mIsStart) {
//                if (mButtonStartTime <= 0 && mIsFirstLaunch) {
//                    mButtonStartTime = System.nanoTime();
//                }
//
//                progress = 1 - getProgress(mButtonStartTime, 0, 0.4f);
//                if (progress == 0) {
//                    return;
//                }
//            }
//            mStartCycles.setProgress(progress, CyclesMode.open, progress);
//            mStartCycles.draw(canvas);
//        }
//
//        private void drawPrivacyPolicy(Canvas canvas) {
//            if (Math.signum(System.nanoTime() - mStartTime - DELAY_PRIVACYPOLICY * NANO) < 0) {
//                return;
//            }
//
//            if (!mShowPolicy) {
//                return;
//            }
//
//            if (mPrivacyHideTime <= 0) {
//                mPrivacyHideTime = System.nanoTime();
//            }
//
//
//            float showAlpha = 255 * 0.3f;
//            if (mIsStart) {
//                float progress = getProgress(mPrivacyHideTime, 0, 0.4f);
//                paint.setAlpha((int) (showAlpha - (progress * showAlpha)));
//                if (progress == 1) {
//                    mShowPolicy = true;
//                    return;
//                }
//            } else {
//                float progress = getProgress(mPrivacyHideTime, 0, 0.8f);
//                paint.setAlpha((int) (progress * showAlpha));
//            }
//
//            //policy的各个坐标
//            policyBitmapTop = (int) (mScreenCenterY * 2 - PRIVACYPOLICY_BUTTOM * mDensity -
//                    mPrivacyFontSize * mDensity - mNavigationBarHeight);
//            policyBitmapLeft = (int) ((canvas.getWidth() - mPrivacyPolicyIcon.getWidth() -
//                    mPrivacyPolicyTextWidth - PRIVACY_MARGIN * mDensity) / 2);
//            policyTextTop = (int) (policyBitmapTop + mPrivacyFontSize * mDensity);
//            policyTextLeft = (int) (policyBitmapLeft + mPrivacyPolicyIcon.getWidth() +
//                    PRIVACY_MARGIN * mDensity);
//
//            //最底行文案的各个坐标
//            mTermsServiceLeft = (int) ((canvas.getWidth() - mTermServiceTextWidth - mAndTextWidth
//                    - mPrivacyPolicyNewTextWidth - 2 * mMargin) / 2);
//            mAndLeft = mTermsServiceLeft + mTermServiceTextWidth + mMargin;
//            mPrivacyPolicyLeft = mAndLeft + mAndTextWidth + mMargin;
//
//            if (showLockerScreenPolicy) {
//                //确定locker的图案以及文字
//                lockerBitmapLeft = (int) ((canvas.getWidth() - mLockerScreenPolicyIcon.getWidth()
//                        - mLockerScreenPolicyWidth - PRIVACY_MARGIN * mDensity) / 2);
//                lockerBitmapTop = policyBitmapTop - (int) (mPrivacyFontSize * mDensity) - (int)
//                        (USAGEAGREE_BUTTOM * mDensity);
//                lockerTextLeft = (int) (lockerBitmapLeft + mLockerScreenPolicyIcon.getWidth() +
//                        PRIVACY_MARGIN * mDensity);
//                lockerTextTop = (int) (lockerBitmapTop + mPrivacyFontSize * mDensity);
//                //第一行
////                firstLeft = (canvas.getWidth() - mUsagePolicyTextWidth - mUsageAgreeTextWidth)
//// / 2;
//                firstLeft = (canvas.getWidth() - mUsageAgreeTextWidth) / 2;
//                firstTop = lockerBitmapTop - (int) (mPrivacyFontSize * mDensity) - (int)
//                        (USAGEAGREE_BUTTOM * mDensity);
//            } else {
////                firstLeft = (canvas.getWidth() - mUsagePolicyTextWidth - mUsageAgreeTextWidth)
//// / 2;
//                firstLeft = (canvas.getWidth() - mUsageAgreeTextWidth) / 2;
//                firstTop = policyBitmapTop - (int) (mPrivacyFontSize * mDensity) - (int)
//                        (USAGEAGREE_BUTTOM * mDensity);
//            }
//
//            //第三行
//            //第三行勾选框
////            canvas.drawBitmap(mPrivacyPolicyIcon,policyBitmapLeft,policyBitmapTop,paint);
//            if (mIsPrivacyCheck) {
////                canvas.drawBitmap(mPrivacyPolicyIconCheck,policyBitmapLeft,policyBitmapTop,paint);
//            }
//            //最底行文字
//            paint.setUnderlineText(true);
//            paint.setFakeBoldText(false);
//            paint.setTextSize(mPrivacyFontSize * mDensity);
////            canvas.drawText(mPrivacyPolicyText,policyTextLeft,policyTextTop,paint);
//
//            canvas.drawText(mTermServiceText, mTermsServiceLeft, policyTextTop, paint);
//            canvas.drawText(mPrivacyPolicyNewText, mPrivacyPolicyLeft, policyTextTop, paint);
//
//            paint.setUnderlineText(false);
//            canvas.drawText(mAndText, mAndLeft, policyTextTop, paint);
//
//            //第二行
//            if (showLockerScreenPolicy) {
//                //绘制的是policy
//                canvas.drawBitmap(mLockerScreenPolicyIcon, lockerBitmapLeft, lockerBitmapTop,
//                        paint);
//                if (mIsLockerScreenCheck) {
//                    canvas.drawBitmap(mLockerScreenPolicyIconCheck, lockerBitmapLeft,
//                            lockerBitmapTop, paint);
//                }
//                paint.setFakeBoldText(false);
//                paint.setTextSize(mPrivacyFontSize * mDensity);
//                canvas.drawText(mLockerScreenPolicyText, lockerTextLeft, lockerTextTop, paint);
//            }
//
//
//            //第一行文字
//            canvas.drawText(mUsageAgreeText,
//                    firstLeft,
//                    firstTop + mPrivacyFontSize * mDensity,
//                    paint);
//
////            paint.setUnderlineText(true);
////            canvas.drawText(mUsagePolicyText, firstLeft + mUsageAgreeTextWidth,
////                    firstTop + mPrivacyFontSize * mDensity, paint);
//            paint.setUnderlineText(false);
//
//
//            //得先判断是不是要画这个玩意儿
//            //计算位置
//            // int thirdLeft = (int) ((canvas.getWidth() - mLockerScreenPolicyIcon.getWidth() -
//            // mLockerScreenPolicyWidth - PRIVACY_MARGIN * mDensity) / 2);//中心位置，还要考虑到默认的margin
//            // int thirdTop  = (int) (mScreenCenterY * 2 - PRIVACYPOLICY_BUTTOM * mDensity -
//            // mPrivacyFontSize * mDensity - mNavigationBarHeight);
//            // 屏幕高度-默认的间距-字体大小的间距-navigationBarHeight
//            //当第三行不绘制时，那么第二行的位置也就改变了
//
//            //第三行勾选框
//           /* if(showLockerScreenPolicy){
//                canvas.drawBitmap(mLockerScreenPolicyIcon,lockerBitmapLeft,lockerBitmapTop,paint);
//                if(mIsLockerScreenCheck){
//                    canvas.drawBitmap(mLockerScreenPolicyIconCheck,lockerBitmapLeft,
//                    lockerBitmapTop,paint);
//                }
//                paint.setFakeBoldText(false);
//                paint.setTextSize(mPrivacyFontSize * mDensity);
//                canvas.drawText(mLockerScreenPolicyText,lockerTextLeft,lockerTextTop,paint);
//            }*/
//            //canvas.drawBitmap(mLockerScreenPolicyIcon,thirdLeft,thirdTop,paint);
//           /* if(mIsLockerScreenCheck){
//                canvas.drawBitmap(mLockerScreenPolicyIconCheck,thirdLeft,thirdTop,paint);
//            }*/
//
//            //第三行文字
//            //    canvas.drawText(mLockerScreenPolicyText,thirdLeft + mLockerScreenPolicyIcon
//            // .getWidth() + PRIVACY_MARGIN * mDensity,thirdTop + mPrivacyFontSize * mDensity,
//            // paint);
//
//
//            //    int secondLeft = (int) ((canvas.getWidth() - mPrivacyPolicyIcon.getWidth() -
//            // mPrivacyPolicyTextWidth - PRIVACY_MARGIN * mDensity) / 2);
//            //thirdTop - 间距 - 字体大小的高度
//            //   int secondTop = (int) (mScreenCenterY*2 - PRIVACYPOLICY_BUTTOM * mDensity -
//            // mPrivacyFontSize * mDensity - mNavigationBarHeight);//得加上第三行的文字了，這個是第三行的高度
//            //    int secondTop = thirdTop -  (int) (mPrivacyFontSize * mDensity) - (int)
//            // (USAGEAGREE_BUTTOM* mDensity);
//
//            //     int firstLeft = (canvas.getWidth() - mUsagePolicyTextWidth -
//            // mUsageAgreeTextWidth) / 2;
//            //   int firstTop = policyBitmapTop - (int) (mPrivacyFontSize * mDensity) - (int)
//            // (USAGEAGREE_BUTTOM* mDensity);
//            //第二行勾选框
//            //  canvas.drawBitmap(mPrivacyPolicyIcon, secondLeft, secondTop, paint);
//            //  canvas.drawBitmap(mPrivacyPolicyIcon,policyBitmapLeft,policyBitmapTop,paint);
//
//
//            //第一行文字
//            //   canvas.drawText(mUsageAgreeText,
//            //           firstLeft,
//            //          firstTop + mPrivacyFontSize * mDensity,
//            //           paint);
//
//            //  paint.setUnderlineText(true);
//            //   canvas.drawText(mUsagePolicyText, firstLeft + mUsageAgreeTextWidth,
//            //         firstTop + mPrivacyFontSize * mDensity, paint);
//
//            //第二行文字
//
//           /* canvas.drawText(mPrivacyPolicyText,
//                    secondLeft + mPrivacyPolicyIcon.getWidth() + PRIVACY_MARGIN * mDensity,
//                    secondTop + mPrivacyFontSize * mDensity,
//                    paint);*/
//            //   canvas.drawText(mPrivacyPolicyText,policyTextLeft,policyTextTop,paint);
//
//
//
//
//           /* //第三行勾选框
//            canvas.drawBitmap(mPrivacyPolicyIcon, secondLeft, secondTop+20, paint);
//            if (mIsPrivacyCheck) {
//                canvas.drawBitmap(mPrivacyPolicyIconCheck, secondLeft, secondTop+20, paint);
//            }
//
//            paint.setFakeBoldText(false);
//            paint.setTextSize(mPrivacyFontSize * mDensity);
//
//
//
//            paint.setUnderlineText(true);
//            canvas.drawText(mUsagePolicyText, firstLeft + mUsageAgreeTextWidth,
//                    firstTop + mPrivacyFontSize * mDensity + 20, paint);*/
//
//            //第二行文字
//
//
//        }
//
//        private void drawProgress(Canvas canvas) {
//            if (!mIsStart) {
//                return;
//            }
//            if (!mCycleProgress.isVisible()) {
//                mCycleProgress.setVisible(true);
//            }
//            if (mButtonStartTime <= 0) {
//                mButtonStartTime = System.nanoTime();
//            }
//
//            mCycleProgress.setCenter(mButtonCenterX, mButtonCenterY);
//            mCycleProgress.setAlpha(1.0f);
//            mCycleProgress.draw(canvas);
//        }
//
//        private void drawSimpleProgress(Canvas canvas) {
//            if (!mIsStart) {
//                return;
//            }
//            if (!mCycleProgress.isVisible()) {
//                mCycleProgress.setVisible(true);
//            }
//            mCycleProgress.setProgress(1.0f);
//            mCycleProgress.setAlpha(1.0f);
//            mCycleProgress.setCenter(mScreenCenterX, mScreenCenterY);
//            mCycleProgress.draw(canvas);
//        }
//
//
//        @Override
//        public void run() {
//            super.run();
//            long duration;
//            long FPS_D = 1000 / FPS;
//            while (isRunning()) {
//                duration = System.currentTimeMillis();
//                synchronized (SplashSurfaceView.this) {
//                    if (mStopped) {
//                        try {
//                            SplashSurfaceView.this.wait();
//                        } catch (Exception e) {
//                            KLog.e("DrawingThread", "wait", e);
//                        }
//                    }
//                }
//                drawCanvas();
//                duration = System.currentTimeMillis() - duration;
//                if (duration < FPS_D) {
//                    try {
//                        sleep(FPS_D - duration);//按照android的绘制机制来绘制一次
//                    } catch (InterruptedException e) {
//                    }
//                }
//            }
//        }
//    }
//
//    // -----------------------------------DRAWING THREAD
//    // END-----------------------------------//
//    // -----------------------------------DRAWING THREAD
//    // END-----------------------------------//
//    // -----------------------------------DRAWING THREAD
//    // END-----------------------------------//
//
//    // -----------------------------------DRAWING OBJECTS
//    // START-----------------------------------//
//    // -----------------------------------DRAWING OBJECTS
//    // START-----------------------------------//
//    // -----------------------------------DRAWING OBJECTS
//    // START-----------------------------------//
//    private enum CyclesMode {
//        close, hide, open, show
//    }
//
//    /**
//     * 光圈
//     */
//    private static class Aperture {
//
//        private float duration = 1.2f;
//        private float DELAY_TIME = 0.3f;
//        private long startTime;
//        private static final int NANO = 1000000000;
//
//        private DecelerateInterpolator interpolator;
//        private long startDelay;
//        private boolean isStart = false;
//
//        private Aperture() {
//            interpolator = new DecelerateInterpolator();
//        }
//
//        public boolean draw(Canvas c, float cx, float cy, float startRadius, float maxAddRadius,
//                            Paint paint, boolean isShow, float density, int alpha, float
//                                    strokeWidth) {
//            if (((System.nanoTime() - startDelay * 1f) / NANO) < DELAY_TIME) {
//                return false;
//            } else {
//                if (!isStart) {
//                    startTime = 0;
//                }
//            }
//            if (startTime == 0) {
//                isStart = true;
//                startTime = System.nanoTime();
//            }
//            float progress = getProgress(startTime, 0, duration);
//            progress = interpolator.getInterpolation(progress);
//            if (progress >= 1) {
//                startDelay = System.nanoTime();
//                isStart = false;
//                return false;
//            }
//            paint.setAlpha((int) ((1 - progress) * 255));
//            paint.setStrokeWidth(strokeWidth * (1 - progress));
//            c.drawCircle(cx, cy, startRadius + progress * maxAddRadius, paint);
//            return true;
//        }
//
//        private float getProgress(long startTime, float delay, float duration) {
//            float progress = (System.nanoTime() - startTime - delay * NANO) / NANO / duration;
//            if (progress > 1)
//                progress = 1;
//            else if (progress < 0)
//                progress = 0;
//            return progress;
//        }
//    }
//
//    /**
//     * 渐变背景
//     */
//    private class BgDrawable {
//        private int alpha = 255;
//        private Paint mPaint = new Paint();
//        private Paint mPaint1 = new Paint();
//
//        public BgDrawable(int width, int height) {
//            init(width, height);
//        }
//
//        public void draw(Canvas canvas) {
//            mPaint.setAlpha(alpha);
//            canvas.drawPaint(mPaint);
//            canvas.drawPaint(mPaint1);
//        }
//
//        void init(int width, int height) {
//            int startx = (int) (width / 2 + width / 2 * Math.tan(10));
//            int starty = 0;
//            int endx = (int) (width / 2 - width / 2 * Math.tan(10));
//            int endy = height;
//            LinearGradient lg = new LinearGradient(startx, starty, endx, endy, new int[]{
//                    0xff043C90, 0xff1D60C4
//            }, new float[]{
//                    0f, 1f
//            }, Shader.TileMode.MIRROR);
//            mPaint.setShader(lg);
//            mPaint.setAntiAlias(true);
//
//            mPaint1.setColor(Color.BLACK);
//            mPaint1.setAlpha((int) (255 * 0.2));
//        }
//
//        public void setAlpha(int alpha) {
//            this.alpha = alpha;
//        }
//
//    }
//
//    /**
//     * 转圈
//     */
//    private class CycleProgress {
//        private static final float STROKE_WIDTH = 3f;
//        private static final float STROKE_WIDTH_THIN = 1.5f;
//        private boolean visible;
//        private boolean isShowing;
//        private long startTime = 0;
//        private float progress = 1.0f;
//        private float speedFactor = 360 * 1f / 1050; // 1050ms 转一圈
//        private float showV = 1 / 400f;
//        private float showAlpha = 0;
//        private float centerX;
//        private float centerY;
//        private Paint paint;
//        private SweepGradient mGradientSweep;
//
//        public void setAlpha(float f) {
//            int alpha = (int) (f * 255);
//            paint.setAlpha(alpha);
//        }
//
//        public void setProgress(float p) {
//            progress = p;
//        }
//
//        private long getAnimateTime() {
//            return System.currentTimeMillis() - startTime;
//        }
//
//        private CycleProgress(boolean useFully) {
//            paint = new Paint();
//            paint.setAntiAlias(true);
//            paint.setStyle(Style.STROKE);
//            if (useFully) {
//                paint.setStrokeWidth(STROKE_WIDTH * mDensity);
//            } else {
//                paint.setStrokeWidth(STROKE_WIDTH_THIN * mDensity);
//                speedFactor = 360 * 1.0f / 1750; // 1750ms 转一圈
//            }
//        }
//
//        public void setCenter(float cx, float cy) {
//            centerX = cx;
//            centerY = cy;
//        }
//
//        public void draw(Canvas c) {
//            if (!visible) {
//                return;
//            }
//            if (mGradientSweep == null) {
//                startTime = System.currentTimeMillis();
//                int[] colors = new int[]{
//                        0x00ffffff, 0x00ffffff, 0xffffffff
//                };
//                float[] percents = new float[]{
//                        0, 0.2f, 1f
//                };
//                mGradientSweep = new SweepGradient(centerX, centerY, colors, percents);
//                paint.setShader(mGradientSweep);
//            }
//            long time = getAnimateTime();
//            float rotate = time * speedFactor;
//            showAlpha = time * showV;
//            if (isShowing) {
//                int alpha = (int) (showAlpha * 255);
//                paint.setAlpha(alpha);
//                if (showAlpha > 1) {
//                    isShowing = false;
//                }
//            }
//            if (progress == 1.0f) {
//                c.save();
//                c.rotate(rotate, centerX, centerY);
//                c.drawCircle(centerX, centerY, mLogoRadius * progress + (STROKE_WIDTH / 2)
//                        * mDensity, paint);
//                c.restore();
//            } else {
//                c.drawCircle(centerX, centerY, mLogoRadius * progress + (STROKE_WIDTH / 2)
//                        * mDensity, paint);
//            }
//        }
//
//        public boolean isVisible() {
//            return visible;
//        }
//
//        public void setVisible(boolean visible) {
//            this.visible = visible;
//            isShowing = true;
//        }
//    }
//
//    /**
//     * 开始按钮
//     */
//    private class StartCycles {
//        private static final int STROKE_WIDTH = 2;
//        private float alpha;
//        /**
//         * 外面的光圈向里缩,此时,实心圆不会收缩
//         */
//        private float CLOSE_1_PERCENT = 0.01f;
//        /**
//         * 实心圆和外光圈一起收缩的分界线,大于0.92就不再缩小了
//         */
//        private float CLOSE_2_PERCENT = 0.92f;
//        CyclesMode mode;
//        Paint paint;
//        private float progress = -1;
//        private Aperture aperture;
//
//        private StartCycles() {
//            paint = new Paint();
//            paint.setAntiAlias(true);
//            paint.setColor(Color.WHITE);
//            aperture = new Aperture();
//        }
//
//        public void draw(Canvas c) {
//            if (mode == null) {
//                return;
//            }
//            switch (mode) {
//                case show:
//                    paint.setStyle(Style.STROKE);
//                    paint.setStrokeWidth(STROKE_WIDTH * mDensity);
//                    int alpha = (int) (255 * progress);
//                    paint.setAlpha(alpha);
//                    // 小空心
//                    c.drawCircle(mButtonCenterX, mButtonCenterY, mStartCycleRadius
//                            + (STROKE_WIDTH / 2) * mDensity, paint);
//                    break;
//                case open:
//                    paint.setStyle(Style.STROKE);
//                    paint.setStrokeWidth(STROKE_WIDTH * mDensity);
//                    paint.setAlpha((int) (this.alpha * 255));
//                    c.save();
//                    float scaleValue = 1f;
//                    float touchProgress = 0;
//                    if (mIsTouchStart) {
//                        if (mStartAnimator != null) {
//                            touchProgress = (Float) mStartAnimator.getAnimatedValue();
//                        }
//                        if (mStartEndAnimator != null) {
//                            touchProgress = (Float) mStartEndAnimator.getAnimatedValue();
//                        }
//                        scaleValue = touchProgress * 0.15f + 0.85f;
//                        paint.setAlpha((int) (touchProgress * 0.4f + 0.6f * 255));
//                    }
//                    c.scale(scaleValue, scaleValue,
//                            mButtonCenterX,
//                            mButtonCenterY);
//                    if (this.progress != 1) {
//                        c.scale(this.progress * 0.15f + 0.85f, this.progress * 0.15f + 0.85f,
//                                mButtonCenterX,
//                                mButtonCenterY);
//                    }
//                    // 小空心
//                    c.drawCircle(mButtonCenterX, mButtonCenterY, mStartCycleRadius
//                                    + (STROKE_WIDTH / 2) * mDensity,
//                            paint);
//                    if (this.progress == 1) {
//                        aperture.draw(c, mButtonCenterX, mButtonCenterY, mStartCycleRadius
//                                        + (STROKE_WIDTH / 2) * mDensity,
//                                mMaxRadius - (mStartCycleRadius + (STROKE_WIDTH / 2) * mDensity),
//                                paint, true, mDensity, 22, STROKE_WIDTH * mDensity);
//                    }
//                    if (mStartArrowDrawable == null) {
//                        SplashSurfaceView.this.paint.setTextSize(FONT_SIZE_XLARGE * mDensity);
//                        SplashSurfaceView.this.paint.setFakeBoldText(true);
//                        if (mIsTouchStart) {
//                            SplashSurfaceView.this.paint
//                                    .setAlpha((int) (touchProgress * 0.4f + 0.6f * 255));
//                        } else {
//                            SplashSurfaceView.this.paint.setAlpha((int) (this.alpha * 255));
//                        }
//                        int height = (int) (SplashSurfaceView.this.paint.getFontMetrics().bottom
//                                - SplashSurfaceView.this.paint
//                                .getFontMetrics().top);
//                        float offY = height / 2
//                                - SplashSurfaceView.this.paint.getFontMetrics().bottom;
//                        c.drawText(mStartText, mButtonCenterX - mStartTextWidth / 2, mButtonCenterY
//                                + height / 2 - offY, SplashSurfaceView.this.paint);
//                    } else {
//                        if (mIsTouchStart) {
//                            mStartArrowDrawable.setAlpha((int) (touchProgress * 0.4f + 0.6f * 255));
//                        } else {
//                            mStartArrowDrawable.setAlpha((int) (this.alpha * 255));
//                        }
//                        mStartArrowDrawable.draw(c);
//                    }
//                    c.restore();
//                    break;
//                case close:
//                    float radius = 1 * mStartCycleRadius;
//                    int alpha255 = 0;
//                    if (progress >= CLOSE_1_PERCENT) {
//                        float maxProgress = Math.min(progress, CLOSE_2_PERCENT);
//                        float value = (maxProgress - CLOSE_1_PERCENT) / (1 - CLOSE_1_PERCENT);
//                        radius = mStartCycleRadius * (1 - value);
//                    }
//                    paint.setStyle(Style.STROKE);
//                    float strokeWidth = STROKE_WIDTH * mDensity * (1 - progress);
//                    paint.setStrokeWidth(strokeWidth);
//                    alpha255 = (int) (255 * this.alpha);
//                    paint.setAlpha(alpha255);
//                    c.drawCircle(mButtonCenterX, mButtonCenterY, radius + strokeWidth / 2, paint);
//                default:
//                    break;
//            }
//
//        }
//
//        public void setProgress(float progress, CyclesMode mode, float alpha) {
//            this.mode = mode;
//            this.progress = progress;
//            this.alpha = alpha;
//        }
//    }
//
//    private class Stars {
//        private List<Star> starts;
//        private Paint starPaint;
//        private float MOVE_MAX_H, progress;
//        private CustomAccelerateDecelerateInterpolator interpolator;
//        private int screenH;
//
//        public class CustomAccelerateDecelerateInterpolator implements Interpolator {
//            public CustomAccelerateDecelerateInterpolator() {
//            }
//
//            public float getInterpolation(float input) {
//                return (float) (Math.cos((input + 1) * Math.PI) / 2.0f) + 0.5f;
//            }
//        }
//
//        class Star {
//            private static final float BLINK_DURATION = 0.3f;
//            private static final float BLINK_ALPHA = 0.4f;
//            public int X, Y;
//            private float mAlpha, mSize, tempY, mBlinkDelay, tempAlpha;
//            private boolean isBlink = false;
//            private long mBlinkStartTime;
//            private float blinkProgress = 0f;
//
//            public Star(int x, int y, float alpha, float size, boolean blink, float blinkDelay) {
//                X = x;
//                Y = y;
//                mAlpha = alpha;
//                mSize = size;
//                isBlink = blink;
//                mBlinkDelay = blinkDelay;
//            }
//
//            public void draw(Canvas canvas, float progress) {
//                tempY = Y;
//                if (progress != 0) {
//                    tempY = tempY - MOVE_MAX_H * progress;
//                }
//                if (tempY < 0 || tempY > screenH) {
//                    return;
//                }
//
//                starPaint.setAlpha((int) (mAlpha * 255));
//                if (isBlink) {
//                    if (mBlinkStartTime == 0) {
//                        mBlinkStartTime = System.nanoTime();
//                    }
//                    blinkProgress = getProgress(mBlinkStartTime, mBlinkDelay, BLINK_DURATION);
//                    if (blinkProgress == 1) {
//                        mBlinkStartTime = 0;
//                    }
//                    if (blinkProgress >= 0 && blinkProgress <= 0.5f) {
//                        tempAlpha = mAlpha - (mAlpha - BLINK_ALPHA) * 2 * blinkProgress;
//                    } else {
//                        tempAlpha = BLINK_ALPHA + (mAlpha - BLINK_ALPHA) * 2
//                                * (blinkProgress - 0.5f);
//                    }
//                    starPaint.setAlpha((int) (tempAlpha * 255));
//                }
//
//                canvas.drawCircle(X, tempY, mSize * mDensity, starPaint);
//            }
//        }
//
//        public Stars() {
//            starts = Lists.newArrayList();
//            interpolator = new CustomAccelerateDecelerateInterpolator();
//            starPaint = new Paint();
//            starPaint.setColor(0xffffffff);
//            DisplayMetrics display = getContext().getResources().getDisplayMetrics();
//            int screenW = display.widthPixels;
//            screenH = display.heightPixels;
//
//            MOVE_MAX_H = screenH * 1.5f;
//            for (int i = 0; i < 20; i++) {
//                Random random = new Random();
//                int x = random.nextInt(screenW);
//                int y = random.nextInt(screenH);
//                float alpha = (3 + (int) (random.nextFloat() * 6)) / 10f;
//                float size = (50 + (int) (random.nextFloat() * 66)) / 100f;
//                float delay = (3 + (int) (random.nextFloat() * 117)) / 100f;
//                starts.add(new Star(x, y, alpha, size, i < (20 * 0.4), delay));
//            }
//            //这20个star是点start按钮后动画由下面出来的
//            for (int i = 0; i < 20; i++) {
//                Random random = new Random();
//                int x = random.nextInt(screenW);
//                int y = screenH + random.nextInt(screenH);
//                float alpha = (3 + (int) (random.nextFloat() * 6)) / 10f;
//                float size = (50 + (int) (random.nextFloat() * 66)) / 100f;
//                starts.add(new Star(x, y, alpha, size, false, 0));
//            }
//        }
//
//        public void draw(Canvas canvas) {
//            progress = 0f;
//            //当mIsStart为true后即点击start按钮后，scenesAnimTime才会被赋值不再等于0
//            //progress被赋值，这就是点击start后星星上移动画的逻辑
//            if (scenesAnimTime != 0) {
//                progress = getProgress(scenesAnimTime, 0, SCENESANIM_DURATION);
//            }
//            progress = interpolator.getInterpolation(progress);
//            if (progress == 1) {
//                scenesAnimFinish = true;
//            }
//            for (Star star : starts) {
//                star.draw(canvas, progress);
//            }
//        }
//
//    }
//
//    private class LauncherColdStartWaitingReport {
//        private static final long NS_PER_MS = 1000000L;
//        private long starttime;
//        private long intime;
//        private long outtime;
//
//        public long getStarttime() {
//            return starttime;
//        }
//
//        public void setStarttime(long starttime) {
//            this.starttime = starttime / NS_PER_MS;
//        }
//
//        public long getIntime() {
//            return intime;
//        }
//
//        public void setIntime(long intime) {
//            this.intime = intime / NS_PER_MS;
//        }
//
//        public long getOuttime() {
//            return outtime;
//        }
//
//        public void setOuttime(long outtime) {
//            this.outtime = outtime / NS_PER_MS;
//        }
//
//        public void report() {
//            if (starttime <= 0 && intime <= 0 && outtime <= 0) {
//                Log.d("cold_start_waiting", "report: starttime=0 intime=0 outtime= 0");
//                return;
//            }
//            Log.d("cold_start_waiting", "report: starttime=" + starttime + " intime=" + intime +
//                    " outtime=" + outtime);
//            UserBehaviorIPCManager.getInstance().report(false,
//                    InfocConstants.MODEL_LAUNCHER_COLD_START_WAITING,
//                    InfocConstants.VALUE_LAUNCHER_COLD_START_STARTTIME, String.valueOf(starttime),
//                    InfocConstants.VALUE_LAUNCHER_COLD_START_INTIME, String.valueOf(intime),
//                    InfocConstants.VALUE_LAUNCHER_COLD_START_OUTTIME, String.valueOf(outtime),
//                    InfocConstants.VALUE_LAUNCHER_COLD_START_WAY, "0");
//        }
//    }
//
//    public void onAllBindingFinish(boolean isFirstRunLauncher) {
//        if (mThemeChoose != null) {
//            if (isFirstRunLauncher) {
//
//            } else {
//                mThemeChoose.onAppBind();
//            }
//        }
//    }
//
//    private class ThemeChoose {
//        private float SKIP_SIZE = 14;
//        private float SKIP_MARGIN = 16;
//        private float SKIP_MARGIN_TOP = 35;
//        private float TITLE_SIZE = 20;
//        private float TITLE_GAP = 32;
//        private float TITLE_MARGIN = 48;
//        private float THEME_BORDER_WIDTH = 1;
//        private float THEME_GAP = 24;
//        private float THEME_HEIGHT_GAP = 24;
//        private float THEME_MARGIN_TOP = 24;
//        private float LOADING_TEXT_SIZE = 15;
//        private float LOADING_TEXT_GAP = 8;
//        private float LOADING_TEXT_WIDTH = 200;
//        private float LOADING_ROUND_SIZE = 15;
//        private float LOADING_ROUND_WIDTH = 48;
//        private float BOTTOM_MARGIN = 5;
//
//        private static final float WHRATIO = 240f / 426f;
//        private ThemeItem[] mThemeItems = new ThemeItem[4];
//        private Paint mSpikPaint;
//        private TextPaint mLoadingPaint;
//        private Paint mLoadingProgressPaint;
//        private Paint mPaint;
//        private int screenW;
//        private int screenH;
//        private StaticLayout mLoadingTextlayout;
//
//        private float dWidth;
//        private float dHeight;
//        private Rect mRect;
//        private RectF mSkipRect;
//        private Rect mChooseBorderRect;
//        private Matrix currentMatrix;
//        private Bitmap mBitmap;
//        private float left;
//        private float top;
//        private float bottom;
//
//        private int mTouchItem = -1;
//        private int mSelectItem = -1;
//        public boolean mInApplay = false;
//        public boolean mIsSelected = false;
//        private String skipStr;
//        private String title;
//        private String loadingContent;
//        private String loadingContentNext;
//
//        private Typeface tf;
//
//        private boolean mApplyFinsh = false;
//        private boolean mAppBind = false;
//        private boolean mFadeClose = false;//渐隐关闭splash
//        private long mHideStartTime;
//        private float mRotate = 0f;
//        private Paint mAroundPaint;
//
//        private long startChooseTime = 0L;
//        private long startloadTime = 0L;
//        private long startRoundTime = 0L;
//        private long startOverTime = 0L;
//
//        private void initDensity() {
//            TITLE_SIZE = TITLE_SIZE * mDensity;
//            SKIP_SIZE = SKIP_SIZE * mDensity;
//            TITLE_MARGIN = TITLE_MARGIN * mDensity;
//            TITLE_GAP = TITLE_GAP * mDensity;
//            SKIP_MARGIN = SKIP_MARGIN * mDensity;
//            SKIP_MARGIN_TOP = SKIP_MARGIN_TOP * mDensity;
//            THEME_BORDER_WIDTH = THEME_BORDER_WIDTH * mDensity;
//            THEME_GAP = THEME_GAP * mDensity;
//            THEME_MARGIN_TOP = THEME_MARGIN_TOP * mDensity;
//            LOADING_TEXT_SIZE = LOADING_TEXT_SIZE * mDensity;
//            LOADING_TEXT_GAP = LOADING_TEXT_GAP * mDensity;
//            LOADING_TEXT_WIDTH = LOADING_TEXT_WIDTH * mDensity;
//            LOADING_ROUND_SIZE = LOADING_ROUND_SIZE * mDensity;
//            LOADING_ROUND_WIDTH = LOADING_ROUND_WIDTH * mDensity;
//            THEME_HEIGHT_GAP = THEME_HEIGHT_GAP * mDensity;
//            BOTTOM_MARGIN = BOTTOM_MARGIN * mDensity;
//        }
//
//        private void initThemeItems() {
//            for (int i = 0; i < mThemeItems.length; i++) {
//                ThemeItem themeItem = new ThemeItem();
//                mThemeItems[i] = themeItem;
//            }
//            //liujia 减size
////            BitmapDrawable bitmapDrawable ;
////            mThemeItems[0].name = null;
////            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable
//// .splash_theme_system);
////            mThemeItems[0].bitmap  = bitmapDrawable.getBitmap();
////
////            mThemeItems[1].name = getResources().getString(R.string.recom_nextteck);
////            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable
//// .splash_theme_nextteck);
////            mThemeItems[1].bitmap  = bitmapDrawable.getBitmap();
////
////            mThemeItems[2].name = getResources().getString(R.string.recom_blackfusion);
////            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable
//// .splash_theme_blackfusion);
////            mThemeItems[2].bitmap  = bitmapDrawable.getBitmap();
////
////            mThemeItems[3].name = getResources().getString(R.string.recom_marsh);
////            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable
//// .splash_theme_marsh);
////            mThemeItems[3].bitmap  = bitmapDrawable.getBitmap();
//
//            mBitmap = mThemeItems[0].bitmap;
//            randomCommon(mThemeItems);
//        }
//
//        private void randomCommon(ThemeItem[] mThemeItems) {
//            int length = mThemeItems.length;
//            Random random = new Random();
//            for (int i = 0; i < length; i++) {
//                int ra = random.nextInt(length);
//                ThemeItem temp = mThemeItems[i];
//                mThemeItems[i] = mThemeItems[ra];
//                mThemeItems[ra] = temp;
//            }
//        }
//
//        private void initStr() {
//            skipStr = getContext().getResources().getString(R.string.splash_skip);
//            title = getContext().getResources().getString(R.string.splash_select_theme_title);
//            loadingContent = getContext().getResources().getString(R.string
//                    .splash_load_theme_title);
//            loadingContentNext = getContext().getResources().getString(R.string.splash_apply_theme);
//        }
//
//        public ThemeChoose() {
//            initStr();
//            initDensity();
//            initThemeItems();
//            tf = TextFontsManager.getInstance().getCurrentFonts();
//            mPaint = new Paint();
//            mPaint.setAntiAlias(true);
//            mPaint.setStrokeWidth(0);
//            mPaint.setStyle(Style.FILL);
//            mPaint.setTextSize(TITLE_SIZE);
//            mPaint.setColor(0xffffffff);
//            mPaint.setTypeface(tf);
//
//            mSpikPaint = new Paint();
//            mSpikPaint.setAntiAlias(true);
//            mSpikPaint.setStrokeWidth(0);
//            mSpikPaint.setStyle(Style.FILL);
//            mSpikPaint.setTextSize(SKIP_SIZE);
//            mSpikPaint.setColor(0x99ffffff);
//            mSpikPaint.setFlags(Paint.UNDERLINE_TEXT_FLAG);
//            mSpikPaint.setTypeface(tf);
//
//            mLoadingPaint = new TextPaint();
//            mLoadingPaint.setAntiAlias(true);
//            mLoadingPaint.setStrokeWidth(0);
//            mLoadingPaint.setStyle(Style.FILL);
//            mLoadingPaint.setTextSize(LOADING_TEXT_SIZE);
//            mLoadingPaint.setColor(0xffffffff);
//            mLoadingPaint.setTextAlign(Paint.Align.CENTER);
//            mLoadingPaint.setTypeface(tf);
//
//            mAroundPaint = new Paint();
//            mAroundPaint.setAntiAlias(true);
//            mAroundPaint.setColor(0x99000000);
//
//            mLoadingProgressPaint = new Paint();
//            mLoadingProgressPaint.setAntiAlias(true);
//            mLoadingProgressPaint.setTextSize(LOADING_ROUND_SIZE);
//            mLoadingProgressPaint.setTypeface(tf);
//            mLoadingProgressPaint.setColor(0xffffffff);
//
//            if (isSpecial()) {
//                mLoadingTextlayout = new StaticLayout(loadingContent, mLoadingPaint, (int)
//                        LOADING_TEXT_WIDTH
//                        , Layout.Alignment.ALIGN_CENTER, 1.0F, 1.0F, false);
//            } else {
//                mLoadingTextlayout = new StaticLayout(loadingContent, mLoadingPaint, (int)
//                        LOADING_TEXT_WIDTH
//                        , Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, false);
//            }
//
//
//            DisplayMetrics metrics = getResources().getDisplayMetrics();
//            screenW = metrics.widthPixels;
//            screenH = metrics.heightPixels;
//
//            mSkipRect = new RectF();
//
//            left = TITLE_MARGIN;
//            float width = (screenW - TITLE_MARGIN * 2 - THEME_GAP) / 2;
//            bottom = screenH - BOTTOM_MARGIN;
//            top = SKIP_MARGIN_TOP + SKIP_SIZE + TITLE_GAP;
//            dWidth = width - 2 * THEME_BORDER_WIDTH;
//            dHeight = dWidth / WHRATIO;
//            float heightGap = (bottom - THEME_MARGIN_TOP - top - 2 * dHeight - 4 *
//                    THEME_BORDER_WIDTH) / 2;
//            if (heightGap < THEME_HEIGHT_GAP) {
//                THEME_HEIGHT_GAP = heightGap;
//            }
////            float height = (bottom - THEME_MARGIN_TOP*2 -top - THEME_HEIGHT_GAP)/2 ;
////
////            float realHeight = height- 2 * THEME_BORDER_WIDTH;
////
////            if (realHeight<dHeight){
////                dHeight = realHeight;
////            }
////
//            mRect = new Rect(0, 0, (int) (dWidth), (int) (dHeight));
//            mChooseBorderRect = new Rect(mRect);
//            mChooseBorderRect.right += THEME_BORDER_WIDTH * 2;
//            mChooseBorderRect.bottom += THEME_BORDER_WIDTH * 2;
//
//
//            for (int i = 0; i < mThemeItems.length; i++) {
//                ThemeItem themeItem = mThemeItems[i];
//                if (i == 0) {
//                    themeItem.rect = new RectF(mChooseBorderRect);
//                    themeItem.rect.offset(left, top + THEME_MARGIN_TOP);
//                } else if (i == 1) {
//                    themeItem.rect = new RectF(mChooseBorderRect);
//                    themeItem.rect.offset(left + dWidth + 2 * THEME_BORDER_WIDTH + THEME_GAP, top
//                            + THEME_MARGIN_TOP);
//                } else if (i == 2) {
//                    themeItem.rect = new RectF(mChooseBorderRect);
//                    themeItem.rect.offset(left, top + THEME_MARGIN_TOP + 2 * THEME_BORDER_WIDTH +
//                            THEME_HEIGHT_GAP + dHeight);
//                } else if (i == 3) {
//                    themeItem.rect = new RectF(mChooseBorderRect);
//                    themeItem.rect.offset(left + dWidth + 2 * THEME_BORDER_WIDTH + THEME_GAP, top
//                            + THEME_MARGIN_TOP + 2 * THEME_BORDER_WIDTH + THEME_HEIGHT_GAP +
//                            dHeight);
//                }
//            }
//
//            handlWallpaperMatrix();
//        }
//
//        private void handlWallpaperMatrix() {
//            currentMatrix = new Matrix();
//            float targetRatio = dWidth * 1f / dHeight * 1f;
//            int cBitmapWidth = mBitmap.getWidth();
//            int cBitmapHeight = mBitmap.getHeight();
//
//            float currentRatio = cBitmapWidth * 1f / cBitmapHeight * 1f;
//            if (currentRatio < targetRatio) {
//                currentMatrix.setScale(dWidth / cBitmapWidth, dWidth / cBitmapWidth);
//            } else {
//                currentMatrix.setScale(dHeight / cBitmapHeight, dHeight / cBitmapHeight);
//            }
//        }
//
//        public boolean onTouchEvent(MotionEvent event) {
//            if (mIsSelected) {
//                return true;
//            }
//            float x = event.getX();
//            float y = event.getY();
//            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                mTouchItem = getItemPosition(x, y);
//                return false;
//            } else if (event.getAction() == MotionEvent.ACTION_UP) {
//                mSelectItem = getItemPosition(x, y);
//                if (mTouchItem != -1 && mSelectItem != -1 && mTouchItem == mSelectItem) {
//                    if (mSelectItem >= 0 && mSelectItem < mThemeItems.length) {
//                        ThemeItem themeItem = mThemeItems[mSelectItem];
//                        String xy = "";
//                        if (mSelectItem == 0) {
//                            xy = "11";
//                        } else if (mSelectItem == 1) {
//                            xy = "12";
//                        } else if (mSelectItem == 2) {
//                            xy = "21";
//                        } else if (mSelectItem == 3) {
//                            xy = "22";
//                        }
//                        if (TextUtils.isEmpty(themeItem.name)) {
//                            reportCLick("system", xy);
//                        } else {
//                            reportCLick(themeItem.name, xy);
//                        }
//                    } else if (mSelectItem == 4) {
//                        reportCLick("0", "0");
//                    }
//                    mIsSelected = true;
//                }
//                mTouchItem = -1;
//            }
//            return true;
//        }
//
//        public void onAppBind() {
//            mAppBind = true;
//        }
//
//        private void dispatchApplyTheme() {
//            if (mSelectItem < mThemeItems.length) {
//                ThemeItem themeItem = mThemeItems[mSelectItem];
//                if (null != themeItem) {
//                    applyTheme(themeItem);
//                }
//            } else if (mSelectItem == 4) {
//                ThreadManager.postDelayed(ThreadManager.THREAD_UI, new Runnable() {
//                    @Override
//                    public void run() {
//                        BitmapDrawable wallpaperDrawable = GlobalConfig
//                                .getSystemWallpaperDrawable(WallpaperManager.getInstance(
//                                        LauncherAppState.getInstance().getContext()));
//                        if (wallpaperDrawable != null) {
//                            Bitmap b = wallpaperDrawable.getBitmap();
//                            if (b != null) {
//                                setWallPaperBitmap(b);
//                            }
//                        }
//                        mApplyFinsh = true;
//                        mAppBind = true;
//                    }
//                }, 0);
//            }
//        }
//
//        private void applyTheme(final ThemeItem themeItem) {
//            ThreadManager.post(ThreadManager.THREAD_BACKGROUND, new Runnable() {
//                @Override
//                public void run() {
//                    String themeName = themeItem.name;
//                    String packName = ThemeResourceManager.SYSTEM_PACKAGE;
//                    int from = ThemeResourceManager.APPLY_THEME_FROM_DETAIL;
//
//                    File dir = ThemeDIYUtils.getDIYRootDir(getContext());
//                    CopyAssets(getContext(), "recommend_theme", dir.getPath());
//                    File cmtFile = new File(dir, themeItem.name + ".cmt");
//                    if (("recom_marsh").equals(themeName) || ("recom_blackfusion").equals
//                            (themeName)) {
//                        CMTTheme cmtTheme = ThemeDIYUtils.prepareCmtDir(getContext(), themeName,
//                                cmtFile.getAbsolutePath());
//                        packName = cmtTheme.getPackageName();
//                        from = ThemeResourceManager.APPLY_THEME_FROM_DIY;
//                    } else {
//                        packName = themeName;
//                        from = ThemeResourceManager.APPLY_THEME_FROM_DETAIL;
//                    }
//
//
//                    ThemeResourceManager.getInstance().startApplyTheme(getContext(), new
//                            ThemeManagerService.ThemeApplyCallBack() {
//                                @Override
//                                public void onApplySuccess() {
//                                    ThreadManager.postDelayed(ThreadManager.THREAD_UI, new
//                                            Runnable() {
//                                        @Override
//                                        public void run() {
//                                            BitmapDrawable wallpaperDrawable = GlobalConfig
//                                                    .getSystemWallpaperDrawable(WallpaperManager
//                                                            .getInstance(
//                                                                    LauncherAppState.getInstance
//                                                                            ().getContext()));
//                                            if (wallpaperDrawable != null) {
//                                                Bitmap b = wallpaperDrawable.getBitmap();
//                                                if (b != null) {
//                                                    setWallPaperBitmap(b);
//                                                }
//                                            }
//                                            mApplyFinsh = true;
//                                        }
//                                    }, 0);
//                                }
//
//                                @Override
//                                public void onApplyFailure() {
//                                    ThreadManager.postDelayed(ThreadManager.THREAD_UI, new
//                                            Runnable() {
//                                        @Override
//                                        public void run() {
//                                            mApplyFinsh = true;
//                                        }
//                                    }, 0);
//                                }
//
//                                @Override
//                                public void onApplyVersionNotSupport() {
//                                    ThreadManager.postDelayed(ThreadManager.THREAD_UI, new
//                                            Runnable() {
//                                        @Override
//                                        public void run() {
//                                            mApplyFinsh = true;
//                                        }
//                                    }, 0);
//                                }
//                            }, from, packName);
//                }
//            });
//        }
//
//        /**
//         * 绘制转圈
//         *
//         * @param canvas
//         */
//        private void drawTurnAround(Canvas canvas, float loadingProgress) {
//            if (startloadTime == 0L) {
//                startloadTime = System.nanoTime();
//            }
//            float progress = getProgress(startloadTime, 0.1f, 0.6f);
//
//
//            if (progress < 0) {
//                return;
//            }
//
//            mAroundPaint.setAlpha(Math.round(150 * progress));
//            canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), mAroundPaint);
//
////            canvas.drawLine(screenW/2,0,screenW/2,screenH,mPaint);
////            canvas.drawLine(0,screenH/2,screenW,screenH/2,mPaint);
//            if (mBmpAround == null) {
//                return;
//            }
//            Matrix matrix = new Matrix();
//            float scale = LOADING_ROUND_WIDTH / mBmpAround.getWidth();
//            matrix.postScale(scale, scale);
//
//            float offsetX = LOADING_ROUND_WIDTH / 2;
//            float offsetY = LOADING_ROUND_WIDTH / 2;
//
//            float left = canvas.getWidth() / 2;
//            float top = canvas.getHeight() / 2;
//            matrix.postTranslate(-offsetX, -offsetY);
//            matrix.postRotate(getRotate());
//            matrix.postTranslate(left, top);
//
//            canvas.drawBitmap(mBmpAround, matrix, mAroundPaint);
//
//            mLoadingPaint.setAlpha(Math.round((255 * progress)));
//            Paint.FontMetricsInt fontMetrics = mLoadingPaint.getFontMetricsInt();
//            float roundBottom = canvas.getHeight() / 2 + offsetY;
//            float loadingContentTop = roundBottom + LOADING_TEXT_GAP - fontMetrics.top;
//
//            canvas.save();
//            if (isSpecial()) {
//                canvas.translate((canvas.getWidth() - mLoadingTextlayout.getWidth()) / 2,
//                        loadingContentTop);
//            } else {
//                canvas.translate(canvas.getWidth() / 2, loadingContentTop);
//            }
//            mLoadingTextlayout.draw(canvas);
//            canvas.restore();
//
//            String pstr = String.format("%d%%", Math.round(loadingProgress * 100));
//            mLoadingProgressPaint.setAlpha(Math.round((255 * progress)));
//            float textWidth = mLoadingProgressPaint.measureText(pstr);
//            Paint.FontMetricsInt progressFontMetrics = mLoadingProgressPaint.getFontMetricsInt();
//            float progressTop = (canvas.getHeight() - progressFontMetrics.top) / 2;
//            canvas.save();
//            canvas.translate((canvas.getWidth() - textWidth) / 2, progressTop);
//            canvas.drawText(pstr, 0, 0, mLoadingProgressPaint);
//            canvas.restore();
//        }
//
//        private boolean isSpecial() {
//            return Build.MODEL.contains("LT18i");
//        }
//
//        private float getRotate() {
//            mRotate += 10;
//            if (mRotate > 360) {
//                mRotate = 0;
//            }
//            return mRotate;
//        }
//
//        private int getItemPosition(float x, float y) {
//            for (int i = 0; i < mThemeItems.length; i++) {
//                ThemeItem themeItem = mThemeItems[i];
//                if (themeItem.rect.contains(x, y)) {
//                    return i;
//                }
//            }
//            if (mSkipRect.contains(x, y)) {
//                return 4;
//            }
//            return -1;
//        }
//
//        public void draw(Canvas canvas) {
//            if (startChooseTime == 0L) {
//                startChooseTime = System.nanoTime();
//            }
//            float choseProgress = getProgress(startChooseTime, 0.3f, 0.6f);
//
//            if (choseProgress > 0 && !mFadeClose) {
//                mPaint.setAlpha((int) (choseProgress * 255));
//                mPaint.setColor(0x4c000000);
//                canvas.drawPaint(mPaint);
//                mPaint.setColor(Color.WHITE);
//                drawTitle(canvas);
//                drawChooseTheme(canvas);
//            }
//
//            if (mIsSelected) {
//                float loadProgress = 0;
//                float loadRoundProgress = 0;
//                float loadOverProgress = 0;
//
//                if (mApplyCMTFinsh && !mInApplay) {
//                    mInApplay = true;
//                    dispatchApplyTheme();
//                }
//
//                if (startRoundTime == 0L) {
//                    startRoundTime = System.nanoTime();
//                }
//                loadRoundProgress = getProgress(startRoundTime, 0f, 5f);
//
//                if (loadRoundProgress >= 1) {
//                    loadProgress = 0.95f;
//                } else {
//                    loadProgress = loadRoundProgress * 0.95f;
//                }
//
//                if (mApplyFinsh && mAppBind && loadRoundProgress >= 0.95f) {
//                    if (startOverTime == 0L) {
//                        startOverTime = System.nanoTime();
//                    }
//                    loadOverProgress = getProgress(startOverTime, 0f, 0.5f);
//                    if (loadOverProgress >= 1) {
//                        loadProgress = 1f;
//                    } else {
//                        loadProgress = 0.95f + loadOverProgress * 0.05f;
//                    }
//
//                    mProgressTime = 0;
//
//                    float progress = 0;
//                    if (mFadeClose && loadProgress >= 1) {
//                        if (mHideStartTime == 0l) {
//                            mHideStartTime = System.nanoTime();
//                        }
//
//                        //关闭时渐隐 防止黑屏
//                        progress = getProgress(mHideStartTime, 0f, 1.3f);
//                        final float tempProgress = progress;
//                        if (progress == 1) {
//                            mInApplay = false;
//                            //关闭渐隐完成 关闭splash
//                            close();
//                            return;
//                        }
//
//                        ThreadUtils.postOnUiThread(new Runnable() {
//
//                            @Override
//                            public void run() {
//                                if (mListener != null) {
//                                    mListener.onProgress(tempProgress,
//                                            OnSplashProgressListener.Mode.SplashEnd);
//                                }
//                            }
//                        });
//                    }
//                    if (loadProgress >= 1) {
//                        drawThemeWallPaper(canvas, progress);
//                    }
//                }
//
//                if (!mFadeClose) {
//                    drawTurnAround(canvas, loadProgress);
//                }
//            }
//
//        }
//
//        private void close() {
//            destroy();
//        }
//
//        /**
//         * 绘制主题背景
//         */
//        private void drawThemeWallPaper(Canvas canvas, float hideFade) {
//
//            paint.setColor(Color.BLACK);
//            paint.setStyle(Paint.Style.STROKE);
//            float f = 0;
//            if (mFadeClose) {
//                //splash关闭时渐隐
//                f = hideFade;
//                paint.setAlpha(255 - (int) (255 * f));
//            } else {
//                //主题壁纸渐显
//                f = getProgress(mProgressTime, 0, 0.5f);
//                paint.setAlpha((int) (255 * f));
//            }
//
//            if (mWallPaperBitmap != null) {
//                Rect src = new Rect(0, 0, mWallPaperBitmap.getWidth(), mWallPaperBitmap.getHeight
//                        ());
//                Rect dst = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
//                canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), paint);
//                canvas.drawBitmap(mWallPaperBitmap, src, dst, paint);
//            }
//
//            if (f >= 1 && !mFadeClose) {
//                //主题壁纸显示完成,开始渐隐关闭
//                mFadeClose = true;
//                isSelectedWallpaperFinish = true;
//            }
//        }
//
//        private float getProgress(long startTime, float delay, float duration) {
//            if (System.nanoTime() == startTime) {
//                return 0;
//            }
//            mProgress = (System.nanoTime() - startTime - delay * NANO) / NANO / duration;
//            if (mProgress > 1)
//                mProgress = 1;
//            else if (mProgress < 0)
//                mProgress = 0;
//            return mProgress;
//        }
//
//
//        private void drawChooseTheme(Canvas canvas) {
//            for (int i = 0; i < mThemeItems.length; i++) {
//                ThemeItem themeItem = mThemeItems[i];
//                drawItemChooseTheme(canvas, themeItem);
//            }
//        }
//
//        private void drawItemChooseTheme(Canvas canvas, ThemeItem themeItem) {
//            float progress = getProgress(startChooseTime, 0.3f, 0.6f);
//            mPaint.setAlpha(Math.round(255 * progress));
//            RectF rectF = themeItem.rect;
//            mPaint.setStyle(Style.STROKE);
//            mPaint.setStrokeWidth(THEME_BORDER_WIDTH);
//            canvas.drawRect(rectF, mPaint);
//            mPaint.setStyle(Style.FILL);
//
//            canvas.save();
//            canvas.translate(rectF.left + THEME_BORDER_WIDTH, rectF.top + THEME_BORDER_WIDTH);
//            canvas.clipRect(mRect);
//            canvas.drawBitmap(themeItem.bitmap, currentMatrix, mPaint);
//            canvas.restore();
//        }
//
//        private void drawTitle(Canvas canvas) {
//            float progress = getProgress(startChooseTime, 0.3f, 0.6f);
//            float left = TITLE_MARGIN;
//
//            //skip
//            int textWidth = (int) mSpikPaint.measureText(skipStr);
//            float skipLeft = screenW - textWidth - SKIP_MARGIN;
//            float skipTop = SKIP_MARGIN_TOP;
//            mSpikPaint.setAlpha(Math.round(255 * progress));
//            canvas.drawText(skipStr, skipLeft, skipTop, mSpikPaint);
//
//            Paint.FontMetricsInt fontMetrics = mSpikPaint.getFontMetricsInt();
//            float skipRectTop = skipTop + fontMetrics.top;
//            float skipRectLeft = skipLeft;
//            float skipRectBottom = skipTop + fontMetrics.bottom;
//            float skipRectRight = screenW;
//            mSkipRect.set(skipRectLeft, skipRectTop, skipRectRight, skipRectBottom);
//
//            //main title
//            float mainTitleTop = skipTop + SKIP_SIZE + TITLE_GAP;
//            mPaint.setAlpha(Math.round(255 * progress));
//            canvas.drawText(title, left, mainTitleTop, mPaint);
//        }
//
//
//        class ThemeItem {
//            public Bitmap bitmap;
//            public RectF rect;
//            public String name;
//        }
//
//        private void reportCLick(String themename, String clickxy) {
//            long curTime = System.currentTimeMillis();
//            UserBehaviorIPCManager.getInstance().report(false, InfocConstants
//                            .THEME_ACTION_LAUNCH_CLICK,
//                    InfocConstants.KEY_THEME_NAME, themename,
//                    InfocConstants.KEY_CLICKXY, clickxy,
//                    InfocConstants.KEY_REPORT_CLKTIME, String.valueOf(curTime));
//        }
//
//        public void reportOnback() {
//            reportCLick("2", "2");
//        }
//    }
//
//
//    private void reportShow(String showtype) {
//        long curTime = System.currentTimeMillis();
//        UserBehaviorIPCManager.getInstance().report(false, InfocConstants.THEME_ACTION_LAUNCH_SHOW,
//                InfocConstants.KEY_REPORT_CLKTIME, String.valueOf(curTime),
//                InfocConstants.KEY_SHOWTYPE, showtype);
//    }
//
//    private class LockerChoose {
//        private static final float WHRATIO = 720f / 1280f;
//
//        private final int screenW;
//        private final int screenH;
//        private final TextPaint mTextPaint;
//        private final TextPaint mTextPaint1;
//        //        private final Rect mCloseRect;
////        private final Rect mCloseRectLarger;
////        private final float largerPx;
//        private final float closeButtonTop;
//        private final float readTextWidth;
//        private StaticLayout mLockerDesLayout;
//        private float lockerDesWidth;
//        private float choosedWallpaperLeftMargin;
//        private float lockerDesMargin;
//        private final Paint mDrawButtonPaint;
//        //        private final String containAds;
////        private final float containAdsMargin;
//        private int wallpaperHeight;
//        private float buttonMarginTop;
//        private float tileX;
//        private Rect mLockerStyleRect;
//        private float desMarginTop;
//        private float wallpaperTop;
//        private float wallpaperBottom;
//        private String enableTile;
//        private String enableSubTile;
//        //        private String lockerDes;
//        private String enableNow;
//        private String notNow;
//        private boolean isTouchEnableNow;
//        private boolean isClickEnableNow;
//        private boolean isClickClose;
//        private float progress;
//        private Rect mWindowRect;
//        private long selectWallpaperStartTime;
//        private static final float SELECT_WALLPAPER_DURATION = 0.30f;
//        private Rect scaleDestRect;
//        private int wallpaperWidth;
//        private Rect scaleBorderRect;
//        private float BORDER_WIDTH = 1;
//        private Paint mPaint;
//        private boolean isClickRecommend;
//        private long mHideStartTime;
//        //        private final Bitmap mCloseBitmap;
//        private boolean isTouchClose;
//        private long mLockerStartTime = -1;
//        private int mDuration = 5000;
//        private Rect mChoosedWallpaperRect;
//        private StaticLayout mEnableTitlelayout;
//        private StaticLayout mEnableSubTitlelayout;
//        private Bitmap mResizeLight;
//        private long highLightStartTime;
//        private Rect mHighLightRect;
//        private float highLightProgress;
//        private Interpolator highLightInterpolatror;
//        private float mHighLightx;
//        private float titleMarginTop;
//        private float wallpaperMarginTop;
//        private float desBottom;
//        private float textWidth;
//        private double desMarginRatio = 5.3; //左边距和屏幕宽度比例
//        private int height;
//        private TextPaint mTextPaint2;
//        private float containAdTop;
//        private float desTop;
//        private float mEnableGap = 15;
//        private Rect mEnableRect;
//        private Rect mNotNowRect;
//        private RectF mEnableRectF;
//        private RectF mNotNowRectF;
//        private TextPaint mTextPaintEnable;
//        private SplashLockerHelper mSplashLockerHelper;
//        private Bitmap mLockerStyle;
//
//        private boolean islowDevice = PhoneInfoUtil.isLowPerformancePhone();
//
//        public LockerChoose() {
//
//            DisplayMetrics metrics = getResources().getDisplayMetrics();
//            screenW = metrics.widthPixels;
//            screenH = metrics.heightPixels;
//
//            enableTile = getContext().getResources().getString(R.string.cmlocker_enable_cm_locker);
//            enableTile = enableTile + "?";
//            enableSubTile = getContext().getResources().getString(R.string
//                    .splash_apply_wallpaper_subtitle);
////            lockerDes = getContext().getResources().getString(R.string.splash_locker_des_new);
//            enableNow = getContext().getResources().getString(R.string.splash_locker_enable_now);
//            notNow = getContext().getResources().getString(R.string.wifi_booster_connected_cancel);
////            containAds = getContext().getResources().getString(R.string
//// .splash_locker_contains_ads);
//
//            containAdTop = 15 * mDensity;
//            mEnableGap = mEnableGap * mDensity;
//            int enableWidth = (int) (mNextRect.width() - mEnableGap) / 2;
//            mNotNowRect = new Rect(mNextRect.left, mNextRect.top, mNextRect.left + enableWidth,
//                    mNextRect.bottom);
//            mEnableRect = new Rect(mNextRect.right - enableWidth, mNextRect.top, mNextRect.right,
//                    mNextRect.bottom);
//            mEnableRectF = new RectF(mEnableRect);
//            mNotNowRectF = new RectF(mNotNowRect);
//            mTextPaintEnable = new TextPaint();
//            mTextPaintEnable.setTextSize(16 * mDensity);
//            mTextPaintEnable.setAntiAlias(true);
//
//            float enableNowWidth = mTextPaintEnable.measureText(enableNow);
//            float notNowWidth = mTextPaintEnable.measureText(notNow);
//            if (enableNowWidth > mEnableRect.width() || notNowWidth > mNotNowRect.width()) {
//                mTextPaintEnable.setTextSize(14 * mDensity);
//            }
//
//            BORDER_WIDTH = BORDER_WIDTH * mDensity;
//
//
//            titleMarginTop = getResources().getDimension(R.dimen.splash_locker_title_top);
//            wallpaperMarginTop = getResources().getDimension(R.dimen.splash_locker_wallpaper_top);
//            buttonMarginTop = getResources().getDimension(R.dimen.splash_locker_button_top);
//            desMarginTop = getResources().getDimension(R.dimen.splash_locker_des_top);
//            closeButtonTop = getResources().getDimension(R.dimen.splash_locker_close_top);
//
//            //为N4 N5做适配  N4导航栏占屏幕
//            String deviceModel = SystemProperties.get("ro.product.model", "unknown");
//
//            if (("Nexus 4").equals(deviceModel)) {
//                titleMarginTop = titleMarginTop / 2;
//            }
//
//
//            mTextPaint = new TextPaint();
//            mTextPaint1 = new TextPaint();
//
//            textWidth = screenW;
//            mTextPaint.setTextSize(16 * mDensity);
//            readTextWidth = mTextPaint.measureText(enableTile);
//            //标题为1行 居中显示
//            if (readTextWidth < textWidth) {
//                mEnableTitlelayout = new StaticLayout(enableTile, mTextPaint, (int) (textWidth),
//                        Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
//            } else {
//                mEnableTitlelayout = new StaticLayout(enableTile, mTextPaint, (int) (textWidth),
//                        Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
//            }
//
////            //如果标题超过2行 则增加标题单行宽度,争取2行显示
////            if (mEnableTitlelayout.getLineCount() > 2) {
////                textWidth = (float) (textWidth*1.4);
////                mEnableTitlelayout = new StaticLayout(enableTile, mTextPaint, (int) (textWidth),
////                        Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
////            }
////            //阿拉伯语增加单行宽度 1行显示
////            if ("ar".equals(Locale.getDefault().getLanguage())){
////                mEnableTitlelayout = new StaticLayout(enableTile, mTextPaint, (int)
//// (readTextWidth),
////                        Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
////            }
//
//            if (!TextUtils.isEmpty(enableSubTile)) {
//                mEnableSubTitlelayout = new StaticLayout(enableSubTile, mTextPaint, (int)
//                        (textWidth),
//                        Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
//            }
//
//            tileX = (screenW - textWidth) / 2 + textWidth / 2;
//
//            mPaint = new Paint();
//
//            mPaint.setAntiAlias(true);
//            mTextPaint.setAntiAlias(true);
//            mTextPaint1.setAntiAlias(true);
//
//            mTextPaint.setTextSize(16 * mDensity);
//
//            mTextPaint1.setTextSize(12 * mDensity);
//
//
////            containAdsMargin = (screenW-mTextPaint1.measureText(containAds))/2;
//
//            if (DeviceUtils.isPad(getContext())) {
//                desMarginRatio = 3;
//                titleMarginTop = 60 * mDensity;
//                wallpaperWidth = screenW / 3;
//                wallpaperHeight = (int) (wallpaperWidth / WHRATIO);
//            } else if (screenH / mDensity > 640) {
//                wallpaperWidth = (int) (150 * mDensity);
//                wallpaperHeight = (int) (267 * mDensity);
//                titleMarginTop = (float) (titleMarginTop * 1.1);
//                wallpaperMarginTop = (float) (wallpaperMarginTop * 1.2);
//                desMarginTop = (float) (desMarginTop * 1.5);
//                buttonMarginTop = (float) (buttonMarginTop * 1.5);
//                containAdTop = (float) (containAdTop * 1.5);
//                desMarginRatio = 4;
//            } else {
//                wallpaperWidth = (int) getResources().getDimension(R.dimen
//                        .splash_locker_wallpaper_width);
//                wallpaperHeight = (int) getResources().getDimension(R.dimen
//                        .splash_locker_wallpaper_height);
//            }
//
////            mCloseBitmap = BitmapFactory.decodeResource(getResources(), R.drawable
//// .lottery_btn_icon_close);
////            mCloseBitmap = BitmapFactory.decodeResource(getResources(), R.drawable
//// .custom_dialog_close);
//
////            mCloseRect = new Rect((int)(screenW-16*mDensity-mCloseBitmap.getWidth()), (int)
//// closeButtonTop,
////                    (int)(screenW-16*mDensity),(int)(closeButtonTop+mCloseBitmap.getHeight()));
//            //扩大点击范围
////            largerPx = mCloseBitmap.getHeight()/2;
////            mCloseRectLarger = new Rect((int)(mCloseRect.left-largerPx),(int)(mCloseRect
//// .top-largerPx),
////                    (int)(mCloseRect.right+largerPx),(int)(mCloseRect.bottom+largerPx));
//
//
//            int leftMargin = (screenW - DimenUtil.dp2px(303)) / 2;
//
//
//            processLockerDesConfig();
//
//
//            processWallpaperConfig();
//
//
//            highLightInterpolatror = new AccelerateDecelerateInterpolator();
//            mDrawButtonPaint = new Paint();
//            mDrawButtonPaint.setAntiAlias(true);
//            mDrawButtonPaint.setAlpha((int) (255 * 0.2));
//
////            indicatorY = buttonBottom+43*mDensity;
//
//            //draw title的时候canvas需要translate的值，
//
//            //为Sony LT18i做适配
//            if (("LT18i").equals(deviceModel)) {
//                tileX = (screenW - textWidth) / 2 + 25 * mDensity;
//            }
//
//            if (islowDevice) {
//                mLockerStyle = BitmapFactory.decodeResource(getResources(), com.test.chengjian
//                        .R.drawable.locker_style);
//            } else {
//                mSplashLockerHelper = new SplashLockerHelper();
//                mSplashLockerHelper.init(getContext(), mChoosedWallpaperRect);
//            }
//        }
//
//        private void processWallpaperConfig() {
//            wallpaperBottom = desTop - desMarginTop;//壁纸底部Y值
//            wallpaperTop = titleMarginTop + 60 * mDensity + wallpaperMarginTop;
//            wallpaperHeight = (int) (wallpaperBottom - wallpaperTop);
//            wallpaperWidth = (int) (wallpaperHeight * WHRATIO);
//            choosedWallpaperLeftMargin = (screenW - wallpaperWidth) / 2;
//
//            mChoosedWallpaperRect = new Rect((int) choosedWallpaperLeftMargin, (int) wallpaperTop,
//                    (int) (screenW - choosedWallpaperLeftMargin), (int) wallpaperBottom);
//            mLockerStyleRect = new Rect((int) (mChoosedWallpaperRect.left + BORDER_WIDTH), (int)
//                    (mChoosedWallpaperRect.top - BORDER_WIDTH),
//                    (int) (mChoosedWallpaperRect.right - BORDER_WIDTH), (int)
//                    (mChoosedWallpaperRect.bottom - BORDER_WIDTH));
//        }
//
//        private void processLockerDesConfig() {
//            //描述文字左边距
//            lockerDesMargin = (float) (screenW / desMarginRatio);
//            //描述文字宽度
//            lockerDesWidth = screenW - lockerDesMargin * 2;
//
////            mTextPaint1.setColor(Color.WHITE);
////            mLockerDesLayout = new StaticLayout(lockerDes,mTextPaint1,(int)(lockerDesWidth),
////                        Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
////            mTextPaint2 = new TextPaint();
////            mTextPaint2.setColor(Color.WHITE);
////            mTextPaint2.setAntiAlias(true);
////            mTextPaint2.setAlpha((int) (255*0.8));
////            mTextPaint2.setTextSize(12*mDensity);
//
//            height = 0;
//
//            //锁屏描述底部和顶部Y值
//            desBottom = mNextRect.top - desMarginTop;
//            desTop = desBottom - height;
//        }
//
//        public boolean onTouchEvent(MotionEvent event) {
//            float x = event.getX();
//            float y = event.getY();
//
//            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                if (mEnableRect.contains((int) x, (int) y)) {
//                    isTouchEnableNow = true;
//                    return true;
//                } else if (mNotNowRect.contains((int) x, (int) y)) {
//                    isTouchClose = true;
//                    return true;
//                }
//
//            }
//
//            if (event.getAction() == MotionEvent.ACTION_UP) {
//                if (mNextRect.contains((int) x, (int) y) && isTouchEnableNow) {
//                    isClickEnableNow = true;
////                    if (enableHelper != null) {
////                        startLocker(enableHelper.needRepair());
////                    }
//                    UserBehaviorIPCManager.getInstance().report(false, InfocConstants
//                                    .LAUNCHER_START_LOCKER_GUIDE, InfocConstants.KEY_ACT, "1",
//                            InfocConstants.KEY_DISPLAY, "-1");
//
//                    UserBehaviorIPCManager.getInstance().report(false, InfocConstants
//                                    .LAUNCHER_ONETAP_TEST,
//                            InfocConstants.KEY_USER_TYPE, InfocConstants.COMMON_VALUE_1,
//                            InfocConstants.KEY_ONE_TAP_TEST_ACT, InfocConstants.COMMON_VALUE_2);
//                    if (mColdStartReport != null) {
//                        mColdStartReport.setIntime(SystemClock.uptimeMillis() -
//                                PerformanceMetrics.getApplicationOnCreateTimecurrentTimeMillis());
//                    }
//                    return true;
//                } else if (mNotNowRect.contains((int) x, (int) y) && isTouchClose) {
//                    UserBehaviorIPCManager.getInstance().report(false, InfocConstants
//                                    .LAUNCHER_START_LOCKER_GUIDE, InfocConstants.KEY_ACT, "0",
//                            InfocConstants.KEY_DISPLAY, "-1");
//
//                    UserBehaviorIPCManager.getInstance().report(false, InfocConstants
//                                    .LAUNCHER_ONETAP_TEST,
//                            InfocConstants.KEY_USER_TYPE, InfocConstants.COMMON_VALUE_1,
//                            InfocConstants.KEY_ONE_TAP_TEST_ACT, InfocConstants.COMMON_VALUE_3);
//                    isClickClose = true;
//                }
//            }
//            return true;
//        }
//
//        public void draw(Canvas canvas) {
//            if (mLockerStartTime == -1) {
//                mLockerStartTime = SystemClock.uptimeMillis();
//                UserBehaviorIPCManager.getInstance().report(false, InfocConstants
//                                .LAUNCHER_START_LOCKER_GUIDE, InfocConstants.KEY_ACT, "-1",
//                        InfocConstants.KEY_DISPLAY, "1");
//
//                UserBehaviorIPCManager.getInstance().report(false, InfocConstants
//                                .LAUNCHER_ONETAP_TEST,
//                        InfocConstants.KEY_USER_TYPE, InfocConstants.COMMON_VALUE_1,
//                        InfocConstants.KEY_ONE_TAP_TEST_ACT, InfocConstants.COMMON_VALUE_1);
//            }
//
//            canvas.save();
//            canvas.translate(screenW, 0);
//
//            if (!isSelectedWallpaperFinish) {
//                drawEnableTitle(canvas);
//                drawChoosedWallpaper(canvas);
////                drawLockerDes(canvas);
////                drawCloseButton(canvas);
//                drawEnableButton(canvas);
////                drawContainAds(canvas);
////                drawIndicator(canvas);
//            }
//
//            canvas.restore();
//
//            drawApplyAnimation(canvas);
//
//
//        }
//
//        private void drawContainAds(Canvas canvas) {
////            canvas.drawText(containAds,containAdsMargin,mNextRect.bottom + containAdTop,
//// mTextPaint1);
//        }
//
//        private void drawIndicator(Canvas canvas) {
//
////            //2外圆
////            mDrawButtonPaint.setStyle(Style.STROKE);
////            mDrawButtonPaint.setColor(Color.WHITE);
////            canvas.drawCircle(screenW/2+8*mDensity+9*mDensity,indicatorY,9.5f*mDensity,
//// mDrawButtonPaint);
////
////            //2内圆
////            mDrawButtonPaint.setStyle(Style.FILL);
////            mDrawButtonPaint.setColor(Color.WHITE);
////            mDrawButtonPaint.setAlpha((int)(255*0.2));
////            canvas.drawCircle(screenW/2+8*mDensity+9*mDensity,indicatorY,9*mDensity,
//// mDrawButtonPaint);
////
////            //1外圆
////            mDrawButtonPaint.setStyle(Style.STROKE);
////            mDrawButtonPaint.setColor(Color.WHITE);
////            mDrawButtonPaint.setAlpha((int)(255*0.2));
////            canvas.drawCircle(screenW/2-8*mDensity-9*mDensity,indicatorY,9.5f*mDensity,
//// mDrawButtonPaint);
////
////            //2数字
////            mDrawButtonPaint.setColor(Color.WHITE);
////            mDrawButtonPaint.setTextSize(14*mDensity);
////            mDrawButtonPaint.setStyle(Style.FILL);
////            Paint.FontMetricsInt fontMetricsInt = mDrawButtonPaint.getFontMetricsInt();
////            int baseline = (int)((2*indicatorY-fontMetricsInt.bottom-fontMetricsInt.top)/2);
////            float width = mDrawButtonPaint.measureText("1");
////            canvas.drawText("2",screenW/2+8*mDensity+9*mDensity-width/2,baseline,
//// mDrawButtonPaint);
////
////            //1数字
////            mDrawButtonPaint.setColor(Color.WHITE);
////            mDrawButtonPaint.setAlpha((int)(255*0.2));
////            canvas.drawText("1",screenW/2-8*mDensity-9*mDensity-width/2,baseline,
//// mDrawButtonPaint);
////
////            //线
////            mDrawButtonPaint.setStrokeWidth(1*mDensity);
////            mDrawButtonPaint.setColor(Color.WHITE);
////            mDrawButtonPaint.setAlpha((int)(255*0.2));
////            canvas.drawLine(screenW/2-5.5f*mDensity,indicatorY,screenW/2+5.5f*mDensity,
//// indicatorY,mDrawButtonPaint);
//        }
//
//        private void drawCloseButton(Canvas canvas) {
////            canvas.drawBitmap(mCloseBitmap,null,mCloseRect,null);
//        }
//
//
//        private void drawApplyAnimation(Canvas canvas) {
//            if (isClickEnableNow || isClickClose) {
//                progress = 0;
//                if (isHide() && mIsLockerSettingFinish) {
//                    if (mHideStartTime == 0l) {
//                        mHideStartTime = System.nanoTime();
//                    }
//                    progress = getProgress(mHideStartTime, 0, BUBBLE_DURATION);
//                    final float tempProgress = progress;
//                    if (progress == 1) {
//                        destroy();
//                        if (null != mSplashLockerHelper) {
//                            mSplashLockerHelper.clear();
//                        }
//                        return;
//                    }
//                    com.test.chengjian.cmbase.utils.ThreadUtils.postOnUiThread(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            if (mListener != null) {
//                                mListener.onProgress(tempProgress,
//                                        OnSplashProgressListener.Mode.SplashEnd);
//                            }
//                        }
//                    });
//                }
//                if (selectWallpaperStartTime == 0) {
//                    selectWallpaperStartTime = System.nanoTime();
//                }
//                drawSimpProgress(canvas, progress);
//            }
//
//        }
//
//        public boolean isHide() {
//            return mIsHide && (isClickEnableNow || isClickClose) && (isClickCurrent ||
//                    mWallpaperChangedSuccess);
//        }
//
//        public boolean isGone() {
//            return isHide();
//        }
//
//        private void drawWallpaper(Canvas canvas, float hideProgress) {
//            float progress = getProgress(selectWallpaperStartTime, 0, SELECT_WALLPAPER_DURATION);
//            if (progress == 1) {
//                isSelectedWallpaperFinish = true;
//            }
//
//            mPaint.setAlpha((int) ((1 - hideProgress) * 255));
//        }
//
//        private void drawSimpProgress(Canvas canvas, float hideProgress) {
//            if (!mCycleProgress.isVisible()) {
//                mCycleProgress.setVisible(true);
//            }
//            mCycleProgress.setProgress(1.0f);
//            mCycleProgress.setAlpha(1 - hideProgress);
//            mCycleProgress.setCenter(mScreenCenterX + screenW, mScreenCenterY);
//            mCycleProgress.draw(canvas);
//        }
//
//        private void drawEnableButton(Canvas canvas) {
//            mTextPaintEnable.setColor(Color.WHITE);
////            mTextPaint.setTextSize(16*mDensity);
//            canvas.drawRoundRect(mEnableRectF, 2 * mDensity, 2 * mDensity, mTextPaintEnable);
//            canvas.drawRoundRect(mNotNowRectF, 2 * mDensity, 2 * mDensity, mTextPaintEnable);
//            mTextPaintEnable.setColor(Color.parseColor("#4480F7"));
//            Paint.FontMetricsInt fontMetrics = mTextPaintEnable.getFontMetricsInt();
//            int baseline = (mNextRect.bottom + mNextRect.top - fontMetrics.bottom - fontMetrics
//                    .top) / 2;
//            // 下面这行是实现水平居中，drawText对应改为传入targetRect.centerX()
//            mTextPaintEnable.setTextAlign(Paint.Align.CENTER);
//            canvas.drawText(enableNow, mEnableRect.centerX(), baseline, mTextPaintEnable);
//            canvas.drawText(notNow, mNotNowRect.centerX(), baseline, mTextPaintEnable);
//            drawButtonHighLight(canvas);
//        }
//
//        private void drawButtonHighLight(Canvas canvas) {
//            if (highLightStartTime == 0) {
//                highLightStartTime = System.nanoTime();
//            }
//            highLightProgress = getProgress(highLightStartTime, 1.2f, 1.2f);
//            highLightProgress = highLightInterpolatror.getInterpolation(highLightProgress);
//            if (highLightProgress == 0) {
//                return;
//            }
//            if (highLightProgress == 1f) {
//                highLightStartTime = 0l;
//            }
//            mHighLightx = mEnableRect.left + highLightProgress * mEnableRect.width() - mLight
//                    .getWidth();
//            if (mResizeLight == null) {
//                mResizeLight = Bitmap.createScaledBitmap(mLight, (int) (58.5 * mDensity),
//                        mEnableRect.height(), false);
//            }
//            if (mHighLightx < mEnableRect.left) {
//                return;
//            }
//            mDrawButtonPaint.setAlpha((int) (255 * 0.08));
//            canvas.drawBitmap(mResizeLight, mHighLightx, mEnableRect.top, mDrawButtonPaint);
//        }
//
//
//        private void drawChoosedWallpaper(Canvas canvas) {
//
//            mPaint.setAlpha(255);
//            canvas.drawBitmap(mLockerWallpaper, null, mChoosedWallpaperRect, mPaint);
//            if (islowDevice && null != mLockerStyle) {
//                canvas.drawBitmap(mLockerStyle, null, mChoosedWallpaperRect, mPaint);
//            } else if (null != mSplashLockerHelper) {
//                mSplashLockerHelper.draw(canvas);
//            }
//            //wallpaper外边框
//            mPaint.setStrokeWidth(BORDER_WIDTH);
//            mPaint.setStyle(Style.STROKE);
//            mPaint.setColor(Color.WHITE);
//            canvas.drawRect(mChoosedWallpaperRect.left - BORDER_WIDTH, mChoosedWallpaperRect.top
//                            - BORDER_WIDTH,
//                    mChoosedWallpaperRect.right + BORDER_WIDTH, mChoosedWallpaperRect.bottom +
//                            BORDER_WIDTH, mPaint);
//
//
//        }
//
//        private void drawEnableTitle(Canvas canvas) {
//            mTextPaint.setColor(Color.WHITE);
//            mTextPaint.setTextSize(16 * mDensity);
//            canvas.save();
//            canvas.translate(0, titleMarginTop);
//            mEnableTitlelayout.draw(canvas);
//            canvas.translate(0, mEnableTitlelayout.getHeight());
//            if (null != mEnableSubTitlelayout) {
//                mEnableSubTitlelayout.draw(canvas);
//            }
//            canvas.restore();
//        }
//
//        private void drawLockerDes(Canvas canvas) {
//            canvas.save();
//            canvas.translate(lockerDesMargin, (desTop));
//            mLockerDesLayout.draw(canvas);
//            canvas.restore();
//        }
//
//    }
//
//    private class WallpaperChoose {
//
//        private static final float WHRATIO = 3f / 5f;
//        private static final float TOUCH_SCALE = 0.95f;
//        private static final float TITLE_SIZE = 19;
//        private static final float WALLPAPTER_NAME_SIZE = 14;
//        private static final float SELECT_WALLPAPER_DURATION = 0.30f;
//        private final Paint mDrawButtonPaint;
//        private final float mNextRectTopY;
//        private final float mNextRectBottomY;
//        //        private final float mCheckBoxRectTopY;
////        private final float mCheckBoxRectBottomY;
//        private float boxTopMargin;
//        private float buttonTopMargin;
//        private float buttonHeight;
//        private float indicatorTopMargin;
//        private float TEXT_PADDING = 3f;
//        private Bitmap currentWallpaper;
//        private Bitmap recommendWallpaper;
//        private Bitmap selectIcon;
//        private float mTitleY;
//        private float MARGIN_TOP = 70;  //壁纸到标题的间距
//        private float MARGIN_LEFTRIGHT = 20;
//        private float MIDDLE_GAP = 14;
//        private float BORDER_WIDTH = 1;
//        private float NAME_MARGIN_TOP = 20; //current顶部间距
//        private Paint mPaint;
//        private Paint mTouchPaint;
//        private Rect mRect;
//        private Rect scaleDestRect;
//        private Rect scaleBorderRect;
//        private float dWidth;
//        private float dHeight;
//
//        private boolean isTouchRecommend = false;
//        private boolean isTouchCurrent = false;
//        private boolean isClickRecommend = true;
//        private ValueAnimator highLightAnim;
//        private Rect mHighLightRect;
//
//        private float mWallpaperTitleTop;
//
//
//        // 壁纸放大进入
//        private long startChooseTime = 0L;
//        private static final float START_DELAY = 0.3f;
//        private long selectWallpaperStartTime = 0;
//        private static final float IN_DURATION = 0.3f;
//        private static final float HIGHLIGHT_WIDTH = 30f;
//        private float delayDuration = 0.15f;
//        private Rect mWindowRect;
//        private Rect mWallpaperRect;
//        private ValueAnimator mTouchAnimator;
//        private ValueAnimator mTouchEndAnimator;
//        private long mHideStartTime;
//        private int screenW;
//        private int screenH;
//        private Matrix currentMatrix;
//        private Matrix recommendMatrix;
//        private OvershootInterpolator overshootInterpolator = new OvershootInterpolator(3f);
//        private boolean needSetWallpaper = true;
//        private Rect mChooseBorderRect;
//        private long highLightStartTime;
//        private float highLightProgress = 0f;
//        private AccelerateDecelerateInterpolator highLightInterpolatror;
//        private boolean isTouchNext;
//        private long startClickNextTime;
//        //        private Drawable mCheckBox;
//        private Bitmap mSelect;
//        //        private Drawable mCheckBoxChecked;
//        private float mHighLightx;
//        private Bitmap mResizeLight;
//
//        //        private Rect mCheckBoxRectLeft;
////        private Rect mCheckBoxRectRight;
//        private int mDuration = 300;
//        private long mLockerStartTime;
//        private float t;
//        private final float width;
//        private float mNextRectY;
//        //        private final int leftMargin;
//        public SplashLockerWallpaperHelper mSplashLockerWallpaperHelper;
//
//        public WallpaperChoose() {
//            mPaint = new Paint();
//            mPaint.setAntiAlias(true);
//            mPaint.setColor(0xffffffff);
//            mPaint.setTextSize(TITLE_SIZE * mDensity);
//            mPaint.setFakeBoldText(false);
//
//            mTouchPaint = new Paint();
//            mTouchPaint.setAntiAlias(true);
//            mTouchPaint.setColor(0xffffffff);
//
//            MARGIN_TOP = MARGIN_TOP * mDensity;//panda
//            MIDDLE_GAP = MIDDLE_GAP * mDensity;
//            BORDER_WIDTH = BORDER_WIDTH * mDensity;
//            NAME_MARGIN_TOP = NAME_MARGIN_TOP * mDensity;
//            TEXT_PADDING = TEXT_PADDING * mDensity;
//
//            DisplayMetrics metrics = getResources().getDisplayMetrics();
//            screenW = metrics.widthPixels;
//            screenH = metrics.heightPixels;
//
//
//            mWallpaperTitleTop = getResources().getDimension(R.dimen.splash_wallpaper_title_top);
//            //panda
//            boxTopMargin = getResources().getDimension(R.dimen.splash_box_top);//panda
//            buttonTopMargin = getResources().getDimension(R.dimen.splash_button_top);//panda
//            buttonHeight = getResources().getDimension(R.dimen.splash_button_height);//panda
//            indicatorTopMargin = getResources().getDimension(R.dimen.splash_indicator_top);
//            MARGIN_TOP = getResources().getDimension(R.dimen.splash_wallpaper_top);
//
//            MARGIN_LEFTRIGHT = (screenW - (screenW * 3 / 7) * 2 - MIDDLE_GAP) / 2;
//            width = (screenW - MARGIN_LEFTRIGHT * 2 - MIDDLE_GAP) / 2;
//            dWidth = width - 2 * BORDER_WIDTH;
//            dHeight = dWidth / WHRATIO;
//
//            //为N4 N5做适配  N4导航栏占屏幕
//            String deviceModel = SystemProperties.get("ro.product.model", "unknown");
//
//            if (("Nexus 4").equals(deviceModel)) {
//                mWallpaperTitleTop = mWallpaperTitleTop / 2;
//            }
//            if (("Nexus 5").equals(deviceModel)) {
//                indicatorTopMargin = 38 * mDensity;
//            }
//            if (("XT1058").equals(deviceModel)) {
//                buttonTopMargin = buttonTopMargin * 2 / 3;
//            }
//
//            mRect = new Rect(0, 0, (int) (dWidth), (int) (dHeight));
//            mWallpaperRect = new Rect(0, 0, screenW, screenH);
//            scaleDestRect = new Rect();
//            scaleBorderRect = new Rect();
//            //fasdfzsdf
//            mChooseBorderRect = new Rect(mRect);
//            mChooseBorderRect.right += BORDER_WIDTH * 2;
//            mChooseBorderRect.bottom += BORDER_WIDTH * 2;
//            mHighLightRect = new Rect(0, 0, (int) (HIGHLIGHT_WIDTH * mDensity),
//                    (int) (Math.sqrt(dWidth * dWidth
//                            + dHeight
//                            * dHeight) + 10 * mDensity));
//
//            getWallpaper();
//
//            highLightAnim = ValueAnimator.ofFloat(0, 1);
//            highLightAnim.setRepeatCount(-1);
//            highLightAnim.setDuration(500L);
//
//            highLightInterpolatror = new AccelerateDecelerateInterpolator();
//
//
//            mDrawButtonPaint = new Paint();
//            mDrawButtonPaint.setAntiAlias(true);
//            mDrawButtonPaint.setAlpha((int) (255 * 0.2));
//
//
//            mTitleY = mWallpaperTitleTop + TITLE_SIZE * mDensity;
//
////            mCheckBoxRectTopY = mTitleY + MARGIN_TOP + dHeight + 2 * BORDER_WIDTH +
//// NAME_MARGIN_TOP+19*mDensity+boxTopMargin;
////            mCheckBoxRectBottomY = mCheckBoxRectTopY + 19*mDensity;
//            mNextRectTopY = mTitleY + MARGIN_TOP + dHeight + 2 * BORDER_WIDTH + NAME_MARGIN_TOP +
//                    19 * mDensity + buttonTopMargin;
//            mNextRectBottomY = mNextRectTopY + buttonHeight;
////            indicatorY = mNextRectBottomY+indicatorTopMargin;
////            mCheckBoxRectLeft = new Rect((int)(MARGIN_LEFTRIGHT+width/2-19*mDensity/2), (int)
//// mCheckBoxRectTopY,(int)(MARGIN_LEFTRIGHT+width/2+19*mDensity/2),(int)mCheckBoxRectBottomY);
////            mCheckBoxRectRight = new Rect((int)(screenW-MARGIN_LEFTRIGHT-width/2-19*mDensity/2)
//// ,(int)mCheckBoxRectTopY,
////                    (int)(screenW-MARGIN_LEFTRIGHT-width/2+19*mDensity/2),(int)
//// mCheckBoxRectBottomY);
//
////            leftMargin = (screenW - DimenUtil.dp2px(303)) / 2;
//            mNextRect = new Rect((int) MARGIN_LEFTRIGHT, (int) (mNextRectTopY), (int) (screenW -
//                    MARGIN_LEFTRIGHT), (int) (mNextRectBottomY));
//            mNextRectF = new RectF(mNextRect);
//
//            selectIcon = BitmapFactory.decodeResource(getResources(), R.drawable
//                    .splash_select_icon);
//            mSplashLockerWallpaperHelper = new SplashLockerWallpaperHelper();
//        }
//
//        private void handlWallpaperMatrix() {
//            currentMatrix = new Matrix();
//            recommendMatrix = new Matrix();
//            float targetRatio = dWidth * 1f / dHeight * 1f;
//            int cBitmapWidth = currentWallpaper.getWidth();
//            int cBitmapHeight = currentWallpaper.getHeight();
//
//            float currentRatio = cBitmapWidth * 1f / cBitmapHeight * 1f;
//            if (currentRatio < targetRatio) {
//                currentMatrix.setScale(dWidth / cBitmapWidth, dWidth / cBitmapWidth);
//            } else {
//                currentMatrix.setScale(dHeight / cBitmapHeight, dHeight / cBitmapHeight);
//            }
//
//            int rBitmapWidth = recommendWallpaper.getWidth();
//            int rBitmapHeight = recommendWallpaper.getHeight();
//
//            float recommendRatio = cBitmapWidth * 1f / cBitmapHeight * 1f;
//            if (recommendRatio < targetRatio) {
//                recommendMatrix.setScale(dWidth / rBitmapWidth, dWidth / rBitmapWidth);
//            } else {
//                recommendMatrix.setScale(dHeight / rBitmapHeight, dHeight / rBitmapHeight);
//            }
//        }
//
//        public boolean onTouchEvent(MotionEvent event) {
//            float x = event.getX();
//            float y = event.getY();
////            if (isClickRecommend || isClickCurrent) {
////                return true;
////            }
//            if (isClickNext || isClickApply || isLoadingClickNext) {
//                return true;
//            }
//
//            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                Rect recommendRect = new Rect(mRect);
//                Rect currentRect = new Rect(mRect);
//
//                recommendRect.offset((int) MARGIN_LEFTRIGHT, (int) (mTitleY + MARGIN_TOP));
//                if ((recommendRect.contains((int) x, (int) y))) {
//                    isTouchCurrent = false;
//                    isTouchRecommend = true;
//                    onTouchWallpaper();
//                    invalidate();
//                    return true;
//                }
//
//                currentRect.offset((int) (MARGIN_LEFTRIGHT + recommendRect.width() + MIDDLE_GAP),
//                        (int) (mTitleY + MARGIN_TOP));
//                if ((currentRect.contains((int) x, (int) y))) {
//                    isTouchRecommend = false;
//                    isTouchCurrent = true;
//                    onTouchWallpaper();
//                    invalidate();
//                    return true;
//                }
//                isTouchRecommend = false;
//                isTouchCurrent = false;
//
//                if (mNextRect.contains((int) x, (int) y)) {
//                    isTouchNext = true;
//                    return true;
//                }
//                isTouchNext = false;
//
//
//                return false;
//            } else if (event.getAction() == MotionEvent.ACTION_UP) {
//
//
//                Rect recommendRect = new Rect(mRect);
//                Rect currentRect = new Rect(mRect);
//
//
//                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getContext());
//                WallpaperInfo info = wallpaperManager.getWallpaperInfo();
//                String previous = (info != null) ? info.getPackageName() : "1";
//
//                recommendRect.offset((int) MARGIN_LEFTRIGHT, (int) (mTitleY + MARGIN_TOP));
//                if ((isTouchRecommend && recommendRect.contains((int) x, (int) y))) {
//                    setClickRecommend(previous);
//                }
//
//                currentRect.offset((int) (MARGIN_LEFTRIGHT + recommendRect.width() + MIDDLE_GAP),
//                        (int) (mTitleY + MARGIN_TOP));
//                if ((isTouchCurrent && currentRect.contains((int) x, (int) y))) {
//                    setClickCurrent(previous);
//                }
//                onTouchWallpaperEnd();
//
//                if (isTouchNext && mNextRect.contains((int) x, (int) y)) {
//                    if (mSplashLockerWallpaperHelper != null && mSplashLockerWallpaperHelper
//                            .getIsUpdate()) {
//                        if (mSplashLockerWallpaperHelper.isShowNewWallpaper()) {
//                            isClickNext = true;
//                        } else {
//                            isClickApply = true;
//                        }
//                    } else {
//                        isLoadingClickNext = true;
//                    }
//                    if ((!isClickCurrent) && (!isClickRecommend)) {
//                        mLockerWallpaper = recommendWallpaper;
//                        //如果两个都没click，就选默认
//                        isClickRecommend = true;
//                    }
//                    startClickNextTime = System.nanoTime();
//                    processWallpaper();
//                }
//
//                invalidate();
//            }
//            return true;
//        }
//
//        private void drawApplyAnimation(Canvas canvas) {
//            if (isLoadingClickNext || isClickApply) {
//                float progress = 0;
//                if (mSplashLockerWallpaperHelper != null && mSplashLockerWallpaperHelper
//                        .getIsUpdate()) {
//                    if (mSplashLockerWallpaperHelper.isShowNewWallpaper()) {
//                        isClickNext = true;
//                    } else {
//                        isClickApply = true;
//                        if (isHide() && mIsLockerSettingFinish) {
//                            progress = getProgress(mHideStartTime, 0, BUBBLE_DURATION);
//                            final float tempProgress = progress;
//                            if (progress == 1) {
//                                destroy();
//                                return;
//                            }
//                            com.test.chengjian.cmbase.utils.ThreadUtils.postOnUiThread(new Runnable() {
//
//                                @Override
//                                public void run() {
//                                    if (mListener != null) {
//                                        mListener.onProgress(tempProgress,
//                                                OnSplashProgressListener.Mode.SplashEnd);
//                                    }
//                                }
//                            });
//                        }
//                    }
//                }
//                drawSimpProgress(canvas, progress);
//            }
//        }
//
//        private void processWallpaper() {
//            if (isClickRecommend && needSetWallpaper) {
//                needSetWallpaper = false;
//                String themePackage = com.test.basesdk.sp.impl.cross.commonpre
//                        .CommonPreference.getInstance().getCurrentTheme();
//                if (!TextUtils.isEmpty(themePackage)) {
//                    ThemeResourceManager.getInstance().applyThemeWallpaper(getContext(), true,
//                            false);
//                } else {
//                    WallpaperHelper.setWallpaperChooseType(WallpaperHelper.TYPE_WALLPAPER_CHOOSE_0);
//                    ThreadManager.post(ThreadManager.THREAD_DATA,
//                            WallpaperHelper.getSetDefaultWallPaperRunnable(null, true,
//                                    WallpaperHelper.TYPE_WALLPAPER_CHOOSE_0));
//                }
//            }
//        }
//
//        private void setClickCurrent(String previous) {
//            isClickCurrent = true;
//            isClickRecommend = false;
//            mLockerWallpaper = currentWallpaper;
//            Log.e(TAG, "setClickRecommend: currentWallpaper" + currentWallpaper);
//
//
//            UserBehaviorIPCManager.getInstance().report(false, InfocConstants.MODEL_RESET_WALLPAPER,
//                    InfocConstants.KEY_DISPLAY, InfocConstants.COMMON_VALUE_1,
//                    InfocConstants.KEY_PREVIOUS, previous,
//                    InfocConstants.COMMON_KEY_CLICK, InfocConstants.COMMON_VALUE_5);
//        }
//
//        private void setClickRecommend(String previous) {
//            isClickRecommend = true;
//            isClickCurrent = false;
//            mLockerWallpaper = recommendWallpaper;
//            Log.e(TAG, "setClickRecommend: recommendWallpaper" + recommendWallpaper);
//
//            UserBehaviorIPCManager.getInstance().report(false, InfocConstants.MODEL_RESET_WALLPAPER,
//                    InfocConstants.KEY_DISPLAY, InfocConstants.COMMON_VALUE_1,
//                    InfocConstants.KEY_PREVIOUS, previous,
//                    InfocConstants.COMMON_KEY_CLICK, InfocConstants.COMMON_VALUE_4);
//        }
//
//        private void onTouchWallpaper() {
//            mTouchAnimator = ValueAnimator.ofFloat(1f, 0f);
//            mTouchAnimator.setDuration(100);
//            mTouchAnimator.start();
//        }
//
//        private void onTouchWallpaperEnd() {
//            float value = 0f;
//            if (mTouchAnimator != null) {
//                value = (Float) mTouchAnimator.getAnimatedValue();
//                mTouchAnimator.end();
//                mTouchAnimator = null;
//            }
//            mTouchEndAnimator = ValueAnimator.ofFloat(value, 1f);
//            mTouchEndAnimator.setDuration(100);
//            mTouchEndAnimator.start();
//            mTouchEndAnimator.addListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mTouchEndAnimator = null;
//                    isTouchCurrent = false;
//                    isTouchRecommend = false;
//                }
//            });
//        }
//
//        private void getWallpaper() {
//            new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    WallpaperManager wallpaperManager = WallpaperManager.getInstance(getContext());
//                    WallpaperInfo info = wallpaperManager.getWallpaperInfo();
//                    boolean isLiveWallpaper = info != null;
//
//                    BitmapDrawable wallpaperBitmapDrawable = null;
//                    if (!isLiveWallpaper) {
//                        wallpaperBitmapDrawable = GlobalConfig.getWallpaperDrawable
//                                (wallpaperManager);
//                    }
//
//                    currentWallpaper = Bitmap.createBitmap(screenW, screenH, Config.ARGB_8888);
//                    Canvas canvas = new Canvas(currentWallpaper);
//                    if (!isLiveWallpaper && wallpaperBitmapDrawable != null) {
//                        Bitmap wallpaper = wallpaperBitmapDrawable.getBitmap();
//                        Matrix matrix = new Matrix();
//                        float ratio = 1f;
//                        if ((screenW * 1f / screenH * 1f) > (wallpaper.getWidth() * 1f / wallpaper
//                                .getHeight() * 1f)) {
//                            ratio = screenW * 1f / wallpaper.getWidth() * 1f;
//                        } else {
//                            ratio = screenH * 1f / wallpaper.getHeight() * 1f;
//                            matrix.postTranslate((screenW - wallpaper.getWidth()) / 2, 0);
//                        }
//                        matrix.postScale(ratio, ratio);
//                        canvas.drawBitmap(wallpaper, matrix, mPaint);
//                        if (wallpaper != null && !wallpaper.isRecycled()) {
//                            wallpaper = null;
//                        }
//                    } else {
//                        Drawable drawable = info == null ? null : info.loadThumbnail(getContext()
//                                .getPackageManager());
//                        if (drawable != null) {
//                            float ratio = 1f;
//                            if ((screenW * 1f / screenH * 1f) > (drawable.getIntrinsicWidth() * 1f
//                                    / drawable
//                                    .getIntrinsicHeight() * 1f)) {
//                                ratio = screenW * 1f / drawable.getIntrinsicWidth() * 1f;
//                            } else {
//                                ratio = screenH * 1f / drawable.getIntrinsicHeight() * 1f;
//                            }
//                            drawable.setBounds(0, 0, (int) (drawable.getIntrinsicWidth() * ratio),
//                                    (int) (drawable.getIntrinsicHeight() * ratio));
//                            drawable.draw(canvas);
//                        } else {
//                            canvas.drawColor(Color.BLACK);
//                        }
//                    }
//                    String themePackage = com.test.basesdk.sp.impl.cross.commonpre
//                            .CommonPreference.getInstance().getCurrentTheme();
//                    Bitmap wallpaper = null;
//                    boolean isThemePack = false;
//                    if (!TextUtils.isEmpty(themePackage)) {
//                        isThemePack = true;
//                        wallpaper = ThemeResourceManager.getInstance().getThemeWallpaper();
//                        recommendWallpaper = Bitmap.createBitmap(screenW, screenH, Config
//                                .ARGB_8888);
//                    }
//                    if (wallpaper == null) {
//                        isThemePack = false;
//                        wallpaper = WallpaperHelper.getSvgThumbnail(getContext(), WallpaperHelper
//                                .TYPE_WALLPAPER_CHOOSE_0);
//                        int realWidth = (int) (screenW / WallpaperHelper.RADIO_THUMBNAIL);
//                        int realHeight = (int) (screenH / WallpaperHelper.RADIO_THUMBNAIL);
//                        recommendWallpaper = Bitmap.createBitmap(realWidth, realHeight, Config
//                                .ARGB_8888);
//                    }
//
//
//                    if (recommendWallpaper == null) {
//                        recommendWallpaper = Bitmap.createBitmap(screenW, screenH, Config
//                                .ARGB_8888);
//                    }
//                    canvas = new Canvas(recommendWallpaper);
//                    //冰山壁纸逻辑
//                    if (CommonUtils.isWhiteCardLauncher()) {
//                        if (wallpaper != null) {
//                            Matrix matrix = new Matrix();
//                            float ratio = 1f;
//                            if ((screenW * 1f / screenH * 1f) > (wallpaper.getWidth() * 1f /
//                                    wallpaper
//                                            .getHeight() * 1f)) {
//                                ratio = screenW * 1f / wallpaper.getWidth() * 1f;
//                            } else {
//                                ratio = screenH * 1f / wallpaper.getHeight() * 1f;
//                            }
//                            matrix.postScale(ratio, ratio);
//                            canvas.drawBitmap(wallpaper, matrix, mPaint);
//                            if (wallpaper != null && !wallpaper.isRecycled()) {
//                                wallpaper = null;
//                            }
//                        } else {
//                            canvas.drawColor(Color.BLACK);
//                        }
//                    } else {
//                        if (wallpaper != null && !isThemePack) {
//                            int realWidth = (int) (screenW / WallpaperHelper.RADIO_THUMBNAIL);
//                            int realHeight = (int) (screenH / WallpaperHelper.RADIO_THUMBNAIL);
//                            Matrix matrix = new Matrix();
//                            float ratio = 1f;
//                            if ((realWidth * 1f / realHeight) > (wallpaper.getWidth() * 1f /
//                                    wallpaper.getHeight())) {
//                                ratio = realWidth * 1f / wallpaper.getWidth() * 1f;
//                            } else {
//                                ratio = realHeight * 1f / wallpaper.getHeight() * 1f;
//                                matrix.postTranslate((realWidth - wallpaper.getWidth()) / 2.0f, 0f);
//                            }
//                            matrix.postScale(ratio, ratio);
//                            canvas.drawBitmap(wallpaper, matrix, mPaint);
//                            if (wallpaper != null && !wallpaper.isRecycled()) {
//                                wallpaper.recycle();
//                                wallpaper = null;
//                            }
//
//                            //主题壁纸逻辑
//                        } else if (wallpaper != null && isThemePack) {
//                            Matrix matrix = new Matrix();
//                            float ratio = 1f;
//                            if ((screenW * 1f / screenH * 1f) > (wallpaper.getWidth() * 1f /
//                                    wallpaper
//                                            .getHeight() * 1f)) {
//                                ratio = screenW * 1f / wallpaper.getWidth() * 1f;
//                            } else {
//                                ratio = screenH * 1f / wallpaper.getHeight() * 1f;
//                            }
//                            matrix.postScale(ratio, ratio);
//                            canvas.drawBitmap(wallpaper, matrix, mPaint);
//                            if (wallpaper != null && !wallpaper.isRecycled()) {
//                                wallpaper = null;
//                            }
//                        } else {
//                            canvas.drawColor(Color.BLACK);
//                        }
//                    }
//
//                    if (mLight == null) {
//                        mLight = WallpaperHelper.getSvgBitmap(getContext(), WallpaperHelper
//                                .SPLASH_ELEMENT_LIGHT);
//                    }
////                    if (mCheckBox == null) {
////                        mCheckBox = WallpaperHelper.getSvgBitmap(getContext(), WallpaperHelper
//// .SPLASH_ELEMENT_CHECKBOX);
////                        mCheckBox = getResources().getDrawable(R.drawable.ic_checkbox);
////                    }
////                    if (mCheckBoxChecked == null) {
////                        mCheckBoxChecked = getResources().getDrawable(R.drawable
//// .ic_checkbox_checked);
//
////                        mCheckBoxChecked = WallpaperHelper.getSvgBitmap(getContext(),
//// WallpaperHelper.SPLASH_ELEMENT_CHECKBOX_CHECKED);
////                    }
//                    mLockerWallpaper = recommendWallpaper;
//                    handlWallpaperMatrix();
//                }
//            }).start();
//        }
//
//        public void draw(Canvas canvas) {
//            //t==1表示往左出去的动画已经播完，无需再draw了
////            if (t ==1) {
////                return;
////            }
//
//            if (startChooseTime == 0L) {
//                startChooseTime = System.nanoTime();
//            }
//            if (isClickNext) {
//                if (mLockerStartTime == 0) {
//                    mLockerStartTime = SystemClock.uptimeMillis();
//                }
//                long curTime = SystemClock.uptimeMillis();
//                // t为一个0到1均匀变化的值
//                if (t != 1) {
//                    t = (curTime - mLockerStartTime) / (float) mDuration;
//                    t = Math.max(0, Math.min(t, 1));
//                }
//
//
//                canvas.translate(-screenW * t, 0);
//            }
//            float progress = getProgress(startChooseTime, START_DELAY, 0.6f);
//            if (progress > 0 && !isSelectedWallpaperFinish) {
//                mPaint.setAlpha((int) (progress * 255));
//                mPaint.setColor(0x4c000000);
//                canvas.drawPaint(mPaint);
//                mPaint.setColor(Color.WHITE);
//                drawTitle(canvas);
//                drawChooseWallpaper(canvas);
//                drawCheckBox(canvas);
//                drawIndicator(canvas);
//            }
//            drawApplyAnimation(canvas);
//        }
//
//        private void drawIndicator(Canvas canvas) {
//
////            //1外圆
////            mDrawButtonPaint.setStyle(Style.STROKE);
////            mDrawButtonPaint.setColor(Color.WHITE);
////            canvas.drawCircle(screenW/2-8*mDensity-9*mDensity,indicatorY,9.5f*mDensity,
//// mDrawButtonPaint);
////
////            //1内圆
////            mDrawButtonPaint.setStyle(Style.FILL);
////            mDrawButtonPaint.setColor(Color.WHITE);
////            mDrawButtonPaint.setAlpha((int)(255*0.2));
////            canvas.drawCircle(screenW/2-8*mDensity-9*mDensity,indicatorY,9*mDensity,
//// mDrawButtonPaint);
////
////            //2外圆
////            mDrawButtonPaint.setStyle(Style.STROKE);
////            mDrawButtonPaint.setColor(Color.WHITE);
////            mDrawButtonPaint.setAlpha((int)(255*0.2));
////            canvas.drawCircle(screenW/2+8*mDensity+9*mDensity,indicatorY,9.5f*mDensity,
//// mDrawButtonPaint);
////
////            //1数字
////            mDrawButtonPaint.setColor(Color.WHITE);
////            mDrawButtonPaint.setTextSize(14*mDensity);
////            mDrawButtonPaint.setStyle(Style.FILL);
////            Paint.FontMetricsInt fontMetricsInt = mDrawButtonPaint.getFontMetricsInt();
////            int baseline = (int)((indicatorY*2-fontMetricsInt.bottom-fontMetricsInt.top)/2);
////            float width = mDrawButtonPaint.measureText("1");
////            canvas.drawText("1",screenW/2-8*mDensity-9*mDensity-width/2,baseline,
//// mDrawButtonPaint);
////
////            //2数字
////            mDrawButtonPaint.setColor(Color.WHITE);
////            mDrawButtonPaint.setAlpha((int)(255*0.2));
////            canvas.drawText("2",screenW/2+8*mDensity+9*mDensity-width/2,baseline,
//// mDrawButtonPaint);
////
////            //线
////            mDrawButtonPaint.setStrokeWidth(1*mDensity);
////            mDrawButtonPaint.setColor(Color.WHITE);
////            mDrawButtonPaint.setAlpha((int)(255*0.2));
////            canvas.drawLine(screenW/2-5.5f*mDensity,indicatorY,screenW/2+5.5f*mDensity,
//// indicatorY,mDrawButtonPaint);
//        }
//
//        private void drawCheckBox(Canvas canvas) {
////            if (isClickCurrent) {
////                mCheckBox.setBounds(mCheckBoxRectLeft);
////                mCheckBox.draw(canvas);
////                mCheckBoxChecked.setBounds(mCheckBoxRectRight);
////                mCheckBoxChecked.draw(canvas);
////            } else {
////                mCheckBox.setBounds(mCheckBoxRectRight);
////                mCheckBox.draw(canvas);
////                mCheckBoxChecked.setBounds(mCheckBoxRectLeft);
////                mCheckBoxChecked.draw(canvas);
////            }
//        }
//
//        private boolean isHide() {
//            return mIsHide && (isClickCurrent || (!needSetWallpaper && mWallpaperChangedSuccess));
//        }
//
//        public boolean isGone() {
//            if (isClickApply) {
//                return isHide();
//            } else if (isClickNext) {
//                if (null != mLockerChoose) {
//                    return mLockerChoose.isGone();
//                }
//            }
//            return false;
//        }
//
//        private void drawSimpProgress(Canvas canvas, float hideProgress) {
//            if (!mCycleProgress.isVisible()) {
//                mCycleProgress.setVisible(true);
//            }
//            mCycleProgress.setProgress(1.0f);
//            mCycleProgress.setAlpha(1 - hideProgress);
//            mCycleProgress.setCenter(mScreenCenterX, mScreenCenterY);
//            mCycleProgress.draw(canvas);
//        }
//
//        private void drawWallpaper(Canvas canvas, float hideProgress) {
//            if (mWindowRect == null) {
//                mWindowRect = new Rect();
//                mWindowRect.set(0, 0, canvas.getWidth(), canvas.getHeight());
//            }
//            float progress = getProgress(selectWallpaperStartTime, 0, SELECT_WALLPAPER_DURATION);
//            if (progress == 1) {
//                isSelectedWallpaperFinish = true;
//            }
//            wallpaper = null;
//            scaleDestRect.set(mRect);
//            if (isClickRecommend) {
//                scaleDestRect.offset((int) MARGIN_LEFTRIGHT, (int) (mTitleY + MARGIN_TOP));
//
//                scaleDestRect.left = (int) (scaleDestRect.left + (mWindowRect.left -
//                        scaleDestRect.left)
//                        * progress);
//                scaleDestRect.right = (int) (scaleDestRect.right + (mWindowRect.right -
//                        scaleDestRect.right)
//                        * progress);
//                scaleDestRect.bottom = (int) (scaleDestRect.bottom + (mWindowRect.bottom -
//                        scaleDestRect.bottom)
//                        * progress);
//                scaleDestRect.top = (int) (scaleDestRect.top + (mWindowRect.top - scaleDestRect.top)
//                        * progress);
//                wallpaper = recommendWallpaper;
//            } else {
//                scaleDestRect.offset((int) (MARGIN_LEFTRIGHT + mRect.width() + MIDDLE_GAP),
//                        (int) (mTitleY + MARGIN_TOP));
//
//                scaleDestRect.left = (int) (scaleDestRect.left + (mWindowRect.left -
//                        scaleDestRect.left)
//                        * progress);
//                scaleDestRect.right = (int) (scaleDestRect.right + (mWindowRect.right -
//                        scaleDestRect.right)
//                        * progress);
//                scaleDestRect.bottom = (int) (scaleDestRect.bottom + (mWindowRect.bottom -
//                        scaleDestRect.bottom)
//                        * progress);
//                scaleDestRect.top = (int) (scaleDestRect.top + (mWindowRect.top - scaleDestRect.top)
//                        * progress);
//                wallpaper = currentWallpaper;
//            }
//            if (progress < 1) {
//                scaleBorderRect.set((int) (scaleDestRect.left - BORDER_WIDTH),
//                        (int) (scaleDestRect.top - BORDER_WIDTH),
//                        (int) (scaleDestRect.right + BORDER_WIDTH),
//                        (int) (scaleDestRect.bottom + BORDER_WIDTH));
//                mPaint.setStyle(Style.STROKE);
//                mPaint.setStrokeWidth(BORDER_WIDTH);
//                mPaint.setColor(Color.WHITE);
//                mPaint.setAlpha((int) ((1 - progress) * 255));
//                canvas.drawRect(scaleBorderRect, mPaint);
//                mPaint.setStyle(Style.FILL);
//            }
//            mPaint.setAlpha((int) ((1 - hideProgress) * 255));
//
//            wallPaperMatrix.reset();
//            float scaleX = (float) scaleDestRect.width() / wallpaper.getWidth();
//            float scaleY = (float) scaleDestRect.height() / wallpaper.getHeight();
//            wallPaperMatrix.postScale(scaleX, scaleY);
//            wallPaperMatrix.postTranslate(scaleDestRect.left, scaleDestRect.top);
//            canvas.drawBitmap(wallpaper, wallPaperMatrix, mPaint);
//        }
//
//        private void drawChooseWallpaper(Canvas canvas) {
//
//            // ******************************draw recommed
//            // wallpaper**********************************
//            canvas.save();
//            canvas.translate(MARGIN_LEFTRIGHT, mTitleY + MARGIN_TOP);
//
//            canvas.save();
//
//            // 进入 选择壁纸动画
//            float inProgress = getProgress(startChooseTime, START_DELAY, IN_DURATION);
//            // 0.8---1 alpha and scale
//            if (inProgress >= 0 && inProgress < 1) {
//                float interProgress = overshootInterpolator.getInterpolation(inProgress);
//                float currentPercent = interProgress * 0.2f + 0.8f;
//                mPaint.setAlpha((int) (inProgress * 255f));
//                canvas.scale(currentPercent, currentPercent, dWidth * 0.5f, dHeight * 0.5f);
//            } else {
//                mPaint.setAlpha(255);
//                canvas.scale(1f, 1f, dWidth * 0.5f, dHeight * 0.5f);
//            }
//            // 按下 和抬起动画
//            float touchProgress = 1f;
//            if (mTouchAnimator != null) {
//                touchProgress = (Float) mTouchAnimator.getAnimatedValue();
//            }
//            if (mTouchEndAnimator != null) {
//                touchProgress = (Float) mTouchEndAnimator.getAnimatedValue();
//            }
//            if (isTouchRecommend) {
//                float scale = touchProgress * 0.05f + TOUCH_SCALE;
//                canvas.scale(scale, scale, dWidth * 0.5f, dHeight * 0.5f);
//            }
//
//            mPaint.setStyle(Style.STROKE);
//            mPaint.setStrokeWidth(BORDER_WIDTH);
//            if (isClickRecommend) {
//                canvas.drawRect(mChooseBorderRect, mPaint);
//            }
//            mPaint.setStyle(Style.FILL);
//            canvas.translate(BORDER_WIDTH, BORDER_WIDTH);
//            canvas.save();
//            canvas.clipRect(mRect);
//            canvas.drawBitmap(recommendWallpaper, recommendMatrix, mPaint);
//            canvas.restore();
//
//            canvas.translate(-BORDER_WIDTH, -BORDER_WIDTH);
//            if (isClickRecommend) {
//                canvas.drawBitmap(selectIcon, 0, 0, mPaint);
//            }
//            canvas.translate(BORDER_WIDTH, BORDER_WIDTH);
//            if (isTouchRecommend) {
//                mTouchPaint.setAlpha((int) ((1 - touchProgress) * 0.2 * 255));
//                canvas.drawRect(mRect, mTouchPaint);
//            }
//            drawHighLight(canvas);
//            canvas.restore();
//
//            // *****************draw recommed text************
//            inProgress = getProgress(startChooseTime, delayDuration + START_DELAY + IN_DURATION,
//                    IN_DURATION);
//            canvas.save();
//            mPaint.setAlpha((int) (255 * inProgress));
//            mPaint.setStrokeWidth(0);
//            mPaint.setTextSize(WALLPAPTER_NAME_SIZE * mDensity);
//            mPaint.setTypeface(TextFontsManager.getInstance().getCurrentFonts());
//            canvas.translate(-MARGIN_LEFTRIGHT, dHeight + 2 * BORDER_WIDTH + NAME_MARGIN_TOP);
//
//            float recommendTextW = mPaint.measureText(mRecommendWallpaper);
//            float totleW = recommendTextW + mRecommendNinePath.getWidth() + TEXT_PADDING * 2;
//            // int left = (int) ((dWidth - totleW) / 2);
//            int left = (int) (MARGIN_LEFTRIGHT + (dWidth / 2f) - (totleW / 2f));
//            Rect patchRect = new Rect(left, (int) ((1 - inProgress) * 25 * mDensity), (int) (left
//                    + totleW),
//                    (int) ((1 - inProgress) * 25 * mDensity + mRecommendNinePath.getHeight()));
//            mRecommendNinePath.draw(canvas, patchRect, mPaint);
//            canvas.drawText(mRecommendWallpaper, left + (mRecommendNinePath.getWidth() / 2)
//                    + TEXT_PADDING, WALLPAPTER_NAME_SIZE
//                    * mDensity + (1 - inProgress) * 25 * mDensity, mPaint);
//            canvas.restore();
//            // *****************draw recommed end************
//            // ******************************draw recommed wallpaper
//            // end**********************************
//
//            // ***********************draw current
//            // wallpaper**********************
//            // draw current wallpaper
//            mPaint.setStrokeWidth(BORDER_WIDTH);
//            canvas.translate(dWidth + 2 * BORDER_WIDTH + MIDDLE_GAP, 0);
//            canvas.save();
//            inProgress = getProgress(startChooseTime, delayDuration + START_DELAY, IN_DURATION);
//            // 0.8---1 alpha and scale
//            if (inProgress >= 0 && inProgress < 1) {
//                float interProgress = overshootInterpolator.getInterpolation(inProgress);
//                float currentPercent = interProgress * 0.2f + 0.8f;
//                //recommend和current wallpaper先后出来的效果
//                mPaint.setAlpha((int) (inProgress * 255f));
//                canvas.scale(currentPercent, currentPercent, dWidth * 0.5f, dHeight * 0.5f);
//            } else {
//                mPaint.setAlpha(255);
//                canvas.scale(1f, 1f, dWidth * 0.5f, dHeight * 0.5f);
//            }
//            if (isTouchCurrent) {
//                float scale = touchProgress * 0.05f + TOUCH_SCALE;
//                canvas.scale(scale, scale, dWidth * 0.5f, dHeight * 0.5f);
//            }
//            mPaint.setStyle(Style.STROKE);
//            mPaint.setStrokeWidth(BORDER_WIDTH);
//            if (isClickCurrent) {
//                canvas.drawRect(mChooseBorderRect, mPaint);
//            }
//            paint.setStyle(Style.FILL);
//            canvas.translate(BORDER_WIDTH, BORDER_WIDTH);
//            canvas.save();
//            canvas.clipRect(mRect);
//            canvas.drawBitmap(currentWallpaper, currentMatrix, mPaint);
//            canvas.restore();
//
//            canvas.translate(-BORDER_WIDTH, -BORDER_WIDTH);
//            if (isClickCurrent) {
//                canvas.drawBitmap(selectIcon, 0, 0, mPaint);
//            }
//            canvas.translate(BORDER_WIDTH, BORDER_WIDTH);
//            if (isTouchCurrent) {
//                mTouchPaint.setAlpha((int) ((1 - touchProgress) * 0.2 * 255));
//                canvas.drawRect(mRect, mTouchPaint);
//            }
//            canvas.restore();
//
//            inProgress = getProgress(startChooseTime, delayDuration + delayDuration + START_DELAY
//                    + IN_DURATION, IN_DURATION);
//            // draw current text
//            canvas.save();
//            mPaint.setStyle(Style.FILL);
//            mPaint.setAlpha((int) (inProgress * 255f));
//            mPaint.setStrokeWidth(0);
//            mPaint.setTypeface(TextFontsManager.getInstance().getCurrentFonts());
//            int drawTextX = (int) (((dWidth + 2 * BORDER_WIDTH - mPaint
//                    .measureText(mCurrentWallpaper)) / 2));
//            canvas.translate(drawTextX, dHeight + 2 * BORDER_WIDTH + NAME_MARGIN_TOP);
//            canvas.drawText(mCurrentWallpaper, 0, WALLPAPTER_NAME_SIZE * mDensity
//                    + (1 - inProgress) * 25 * mDensity, mPaint);
//            canvas.restore();
//
//            canvas.restore();
//
//            //draw next button
//
//            drawNextButton(canvas);
//
//
//            //draw bottom number
//
//        }
//
//        private void drawNextButton(Canvas canvas) {
//            float inProgress;
//
//            canvas.save();
//            inProgress = getProgress(startChooseTime, delayDuration + delayDuration + START_DELAY
//                    + IN_DURATION, IN_DURATION);
////            mPaint.setStrokeWidth(3);
//            mPaint.setAlpha((int) (inProgress * 255f));
//            mPaint.setTextSize(16 * mDensity);
//            mPaint.setColor(Color.WHITE);
//            mPaint.setStyle(Style.FILL);
//            float textWidth = mPaint.measureText(mNext);
//            canvas.drawRoundRect(mNextRectF, 2 * mDensity, 2 * mDensity, mPaint);
//            mPaint.setColor(Color.parseColor("#4480F7"));
//            Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
//            int baseline = (mNextRect.bottom + mNextRect.top - fontMetrics.bottom - fontMetrics
//                    .top) / 2;
//            // 下面这行是实现水平居中，drawText对应改为传入targetRect.centerX()
//            paint.setTextAlign(Paint.Align.CENTER);
//            canvas.drawText(mNext, mNextRect.centerX() - textWidth / 2, baseline, mPaint);
//
//            drawButtonHighLight(canvas);
//
//            canvas.restore();
//        }
//
//        private void drawButtonHighLight(Canvas canvas) {
//            mHighLightx = mNextRect.left + highLightProgress * mNextRect.width() - mLight
//                    .getWidth();
//            if (mResizeLight == null) {
//                mResizeLight = Bitmap.createScaledBitmap(mLight, (int) (58.5 * mDensity),
//                        mNextRect.height(), false);
//            }
//            if (mHighLightx < mNextRect.left) {
//                return;
//            }
//            mDrawButtonPaint.setAlpha((int) (255 * 0.08));
//            canvas.drawBitmap(mResizeLight, mHighLightx, mNextRect.top, mDrawButtonPaint);
//        }
//
//        private void drawHighLight(Canvas canvas) {
//            if (highLightStartTime == 0) {
//                highLightStartTime = System.nanoTime();
//                mHighLightRect.set((int) -(HIGHLIGHT_WIDTH * mDensity), 0, 0,
//                        (int) (Math.sqrt(dWidth * dWidth
//                                + dHeight
//                                * dHeight) + HIGHLIGHT_WIDTH * mDensity));
//            }
//            highLightProgress = getProgress(highLightStartTime, 1.2f, 1.2f);
//            highLightProgress = highLightInterpolatror.getInterpolation(highLightProgress);
//            if (highLightProgress == 0) {
//                return;
//            }
//            if (highLightProgress == 1f) {
//                highLightStartTime = 0l;
//            }
//            mHighLightRect.left = (int) (-HIGHLIGHT_WIDTH * mDensity + highLightProgress *
//                    mHighLightRect.height());
//            mHighLightRect.right = (int) (mHighLightRect.left + HIGHLIGHT_WIDTH * mDensity);
//            canvas.clipRect(mRect);
//            //recommend wallpaper上的光影效果，canvas旋转45度后沿Y轴位移
//            canvas.rotate(45);
//            canvas.translate(0, -(int) (Math.sin(45) * dWidth));
//            mPaint.setAlpha((int) ((0.2f - highLightProgress * 0.195f) * 255));
//            canvas.drawRect(mHighLightRect, mPaint);
//        }
//
//        private void drawTitle(Canvas canvas) {
//            float outProgress = 0;
//            float progress = getProgress(startChooseTime, START_DELAY, 0.6f);
//
//            mPaint.setStrokeWidth(0);
//            mPaint.setStyle(Style.FILL);
//            mPaint.setTextSize(TITLE_SIZE * mDensity);
//            mPaint.setAlpha((int) (255 * progress));
//            mPaint.setTypeface(TextFontsManager.getInstance().getCurrentFonts());
//            int textWidth = (int) mPaint.measureText(mChooseWallpaperTitle);
//            int left = (canvas.getWidth() - textWidth) / 2;
//            canvas.drawText(mChooseWallpaperTitle, left, (float) (mWallpaperTitleTop + (TITLE_SIZE
//                    - 26.5 + progress * 26.5) * mDensity - screenH * outProgress), mPaint);
//        }
//    }
//
//    private class OrganizingDesktop {
//        private float mRotate = 0f;
//        private float mProgressShowWidth = 0f;
//        private float mTipShowVlaue = 0;
//        private long mHideStartTime = 0;
//        private boolean mFadeClose = false;//渐隐关闭splash
//        private int mState = 1;
//
//        private float TIP_TOP_OFFSET = 30f;
//        private float GEAR_MRGIN_LINE = 8.5f;
//        private float GREEN_TOP_GEAR_GAP = 2f;
//        private float GREEN_LEFT_GEAR_GAP = -1f;
//        private float YELOOW_TOP_GEAR_GAP = 8f;
//        private float YELOOW_LEFT_GEAR_GAP = 4f;
//        private float TIP_GAP = 27f;
//        private float PROGRESSBAR_GAP = 10f;
//
//        private Bitmap mBlueGearBitmap;
//        private Bitmap mGreenGearBitmap;
//        private Bitmap mYellowGearBitmap;
//        private Matrix mBlueMatrix = new Matrix();
//        private Matrix mGreenMatrix = new Matrix();
//        private Matrix mYellowMatrix = new Matrix();
//        private NinePatch mProgressBarNp;
//        private NinePatch mProgressBarNpBg;
//        private float mProgressBarWidth = 240f;
//        private Rect mPbBgRect;
//        private Rect mPbRect;
//
//        private boolean mIsUseOld = true;
//        private float mTextTop;
//        private SplashWallpaperLayout mSplashWallpaperLayout;
//        private boolean mIsSplashLayoutVisable;
//        private boolean mIsSplashLayoutRemove;
//        private boolean mIsNeedsSplashLayoutShow;
//        private boolean mHasStartLocker;
//        private boolean mEnableLockerSplash = false;
//
//        OrganizingDesktop() {
//        }
//
//        OrganizingDesktop(boolean isUseOld) {
//            mIsUseOld = isUseOld;
//            if (!mIsUseOld) {
//                initDensity();
//            }
//        }
//
//        private void initDensity() {
//            GEAR_MRGIN_LINE = GEAR_MRGIN_LINE * mDensity;
//            GREEN_TOP_GEAR_GAP = GREEN_TOP_GEAR_GAP * mDensity;
//            GREEN_LEFT_GEAR_GAP = GREEN_LEFT_GEAR_GAP * mDensity;
//            YELOOW_TOP_GEAR_GAP = YELOOW_TOP_GEAR_GAP * mDensity;
//            YELOOW_LEFT_GEAR_GAP = YELOOW_LEFT_GEAR_GAP * mDensity;
//            mProgressBarWidth = mProgressBarWidth * mDensity;
//            TIP_GAP = TIP_GAP * mDensity;
//            PROGRESSBAR_GAP = PROGRESSBAR_GAP * mDensity;
//            TIP_TOP_OFFSET = TIP_TOP_OFFSET * mDensity;
//            mBlueGearBitmap = BitmapFactory.decodeResource(getResources(), R.drawable
//                    .splash_blue_gear);
//            mGreenGearBitmap = BitmapFactory.decodeResource(getResources(), R.drawable
//                    .splash_green_gear);
//            mYellowGearBitmap = BitmapFactory.decodeResource(getResources(), R.drawable
//                    .splash_yellow_gear);
//            Bitmap mProgressBarBgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable
//                    .splash_progress_loading_bg);
//            Bitmap mProgressBarBitmap = BitmapFactory.decodeResource(getResources(), R.drawable
//                    .splash_progress_loading);
//            mProgressBarNpBg = new NinePatch(mProgressBarBgBitmap, mProgressBarBgBitmap
//                    .getNinePatchChunk(), null);
//            mProgressBarNp = new NinePatch(mProgressBarBitmap, mProgressBarBitmap
//                    .getNinePatchChunk(), null);
//            mPbRect = new Rect();
//            mPbBgRect = new Rect();
//        }
//
//        /**
//         * param mState   1. 9.5秒走完90% 等真实进度走完后，在0.5秒内进度条达到100%并进入到桌面
//         * 2. 如真实进度在9.5秒内完成，则在0.5秒内，进度条达到100%并进入到桌面
//         */
//        public void setState(int mState) {
//            this.mState = mState;
//        }
//
//        public boolean isSplashWallpaperDestory() {
//            return null == mSplashWallpaperLayout;
//        }
//
//        public void draw(Canvas canvas) {
//
//            float offset = 0;
//            float f = 0;
//            if (mApplyCMTFinsh) {
//                if (mState == 1) {
//                    mState = 2;
//                    mProgressTime = 0;
//                }
//            }
//
//            if (mProgressTime <= 0) {
//                mProgressTime = System.nanoTime();
//            }
//
//            if (mState == 1) {
//                //前9.5秒走完90%
//                f = getProgress(mProgressTime, 0, 9.5f);
//                if (f >= 1) {
//                    mShowTurnAround = true;
//                    if (mProgressOffsetTime <= 0) {
//                        mProgressOffsetTime = System.nanoTime();
//                    }
//                }
//            } else {
//                //真实进度完成,0.5秒内进度条到100%  然后进入桌面
//                f = getProgress(mProgressTime, 0, 1f);
//                if (mThemeWallPaperShowTime == 0) {
//                    mThemeWallPaperShowTime = System.nanoTime();
//                }
//                if (f >= 1 && mEnableLockerSplash) {
//                    if (!mIsSplashLayoutVisable) {
//                        ThreadManager.post(ThreadManager.THREAD_UI, new Runnable() {
//                            @Override
//                            public void run() {
//                                mSplashWallpaperLayout = (SplashWallpaperLayout) LayoutInflater
//                                        .from(getContext()).inflate(R.layout.splash_lock_layout,
//                                                null);
//                                Launcher launcher = LauncherAppState.getInstance().getLauncher();
//                                if (null != launcher && !launcher.isDestroyed()) {
//                                    launcher.addSplashView(mSplashWallpaperLayout);
//                                }
//                                mSplashWallpaperLayout.setSplashSurfaceView(SplashSurfaceView.this);
//
//                            }
//                        });
//                        UserBehaviorIPCManager.getInstance().report(false, InfocConstants
//                                        .LAUNCHER_ONETAP_TEST,
//                                InfocConstants.KEY_USER_TYPE, InfocConstants.COMMON_VALUE_2,
//                                InfocConstants.KEY_ONE_TAP_TEST_ACT, InfocConstants.COMMON_VALUE_1);
//                        mIsSplashLayoutVisable = true;
//                    }
//                    boolean isCancle = (mSplashWallpaperLayout != null && mSplashWallpaperLayout
//                            .getIsCancle());
////                    mSplashWallpaperLayout.setNeedRepair(enableHelper!= null && enableHelper
//// .needRepair());
//                    boolean isEnable = (mSplashWallpaperLayout != null && mSplashWallpaperLayout
//                            .getIsEnable());
//                    mIsNeedsSplashLayoutShow = !isCancle && (!isEnable || (isEnable &&
//                            !mIsLockerSettingFinish));
//
//
//                    if (mIsNeedsSplashLayoutShow) {
//                        return;
//                    } else {
//                        if (!mIsSplashLayoutRemove) {
//                            ThreadManager.post(ThreadManager.THREAD_UI, new Runnable() {
//                                @Override
//                                public void run() {
//                                    Launcher launcher = LauncherAppState.getInstance()
//                                            .getLauncher();
//                                    if (null != launcher && !launcher.isDestroyed()) {
//                                        launcher.removeSplashView();
//                                    }
//                                }
//                            });
//                            mIsSplashLayoutRemove = true;
//                        }
//                    }
//                }
//
//                if (f >= 1 && (mEnableLockerSplash && !mIsNeedsSplashLayoutShow ||
//                        !mEnableLockerSplash)) {
//
//                    float progress = 0;
//                    if (mFadeClose) {
//                        if (mHideStartTime == 0l) {
//                            mHideStartTime = System.nanoTime();
//                        }
//
//                        //关闭时渐隐 防止黑屏
//                        progress = getProgress(mHideStartTime, 0, BUBBLE_DURATION);
//                        final float tempProgress = progress;
//                        if (progress == 1) {
//                            //关闭渐隐完成 关闭splash
//                            if (null != mSplashWallpaperLayout) {
//                                mSplashWallpaperLayout.clear();
//                                mSplashWallpaperLayout = null;
//                            }
//                            close();
//                            return;
//                        }
//
//                        ThreadUtils.postOnUiThread(new Runnable() {
//
//                            @Override
//                            public void run() {
//                                if (mListener != null) {
//                                    mListener.onProgress(tempProgress,
//                                            OnSplashProgressListener.Mode.SplashEnd);
//                                }
//                            }
//                        });
//                    }
//
//                    //绘制主题背景
//                    drawThemeWallPaper(canvas, progress);
//                }
//            }
//
//            if (mFadeClose) {
//                return;
//            }
//
//            if (mShowTurnAround && mIsUseOld) {
//                //显示转圈时,向下滑动 文字和进度条
//                float sild = getProgress(mProgressOffsetTime, 0, 0.5f);
//                offset = sild * (mBarTopOffset);
//                drawTurnAround(canvas, f);
//            }
//            drawTip(canvas, f, offset);
//            if (mIsUseOld) {
//                drawProgressBar(canvas, f, offset);
//            } else {
//                drawGear(canvas, f, offset);
//            }
//        }
//
//        /**
//         * 绘制主题背景
//         */
//        private void drawThemeWallPaper(Canvas canvas, float hideFade) {
//
//            paint.setColor(Color.BLACK);
//            paint.setStyle(Paint.Style.STROKE);
//            float f = 0;
//            if (mFadeClose) {
//                //splash关闭时渐隐
//                f = hideFade;
//                paint.setAlpha(255 - (int) (255 * f));
//            } else {
//                //主题壁纸渐显
//                f = getProgress(mProgressTime, 0, 1f);
//                paint.setAlpha((int) (255 * f));
//            }
//
//            if (mWallPaperBitmap != null) {
//                Rect src = new Rect(0, 0, mWallPaperBitmap.getWidth(), mWallPaperBitmap.getHeight
//                        ());
//                Rect dst = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
//                canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), paint);
//                canvas.drawBitmap(mWallPaperBitmap, src, dst, paint);
//            }
//
//            if (f >= 1 && !mFadeClose) {
//                //主题壁纸显示完成,开始渐隐关闭
//                mFadeClose = true;
//                isSelectedWallpaperFinish = true;
//            }
//        }
//
//        /**
//         * 绘制文字
//         *
//         * @param canvas
//         */
//        private void drawTip(Canvas canvas, float speed, float offset) {
//
//            paint.setAlpha(255);
//            paint.setTextSize(FONT_SIZE_SMALL * mDensity);
//            paint.setStyle(Style.FILL);
//            paint.setFakeBoldText(false);
//            paint.setColor(Color.WHITE);
//            int value = 0;
//            if (mState == 1) {
//                value = (int) (speed * 90);
//                mTipShowVlaue = value;
//            } else {
//                value = (int) (mTipShowVlaue + (100 - mTipShowVlaue) * speed);
//            }
//
//            float topPadding = 4.0f;
//            int top = (int) ((canvas.getHeight()) / 2 - mPrivacyFontSize * mDensity + mDensity *
//                    topPadding + offset);
//            if (!mIsUseOld) {
//                top = top + (int) TIP_TOP_OFFSET;
//            }
//            mTextTop = top;
//            canvas.drawText(String.format(mOrganizingTips, String.valueOf(value)),
//                    (canvas.getWidth() - mOrganizingTipTextWidth) / 2, top, paint);
//        }
//
//        private float getRotate() {
//            return getRotate(10);
//        }
//
//
//        private float getRotate(int speed) {
//            mRotate += speed;
//            if (mRotate > 360) {
//                mRotate = 0;
//            }
//            return mRotate;
//        }
//
//        /**
//         * 绘制转圈
//         *
//         * @param canvas
//         */
//        private void drawTurnAround(Canvas canvas, float scale) {
//            if (mBmpAround == null) {
//                return;
//            }
//            Matrix matrix = new Matrix();
//
//            int offsetX = mBmpAround.getWidth() / 2;
//            int offsetY = mBmpAround.getHeight() / 2;
//
//            float left = canvas.getWidth() / 2;
//            float top = canvas.getHeight() / 2 - offsetY;
//
//            paint.setAlpha((int) (255 * scale));
//            matrix.postTranslate(-offsetX, -offsetY);
//            matrix.postRotate(getRotate());
//            matrix.postTranslate(left, top);
//            canvas.drawBitmap(mBmpAround, matrix, paint);
//        }
//
//        /**
//         * 绘制新版动画
//         *
//         * @param canvas
//         */
//        private void drawGear(Canvas canvas, float scale, float offset) {
//            paint.setAntiAlias(true);
//
//            float bottom = mTextTop - TIP_GAP;
//
//            float f = getProgress(mStartTime, 0, 1f);
//            paint.setAlpha((int) (255 * f));
//            float width = 0;
//            if (mState == 1) {
//                width = scale * (mProgressBarWidth * 0.9f);
//                mProgressShowWidth = width;
//            } else {
//                width = mProgressShowWidth + (mProgressBarWidth - mProgressShowWidth) * scale;
//            }
//
//            //进度条背景
//            float pbBgTop = bottom - mProgressBarNpBg.getHeight();
//            float pbBgLeft = (getWidth() - mProgressBarWidth) / 2;
//            mPbBgRect.left = (int) pbBgLeft;
//            mPbBgRect.right = (int) (pbBgLeft + mProgressBarWidth);
//            mPbBgRect.top = (int) pbBgTop;
//            mPbBgRect.bottom = (int) (pbBgTop + mProgressBarNpBg.getHeight());
//            mProgressBarNpBg.draw(canvas, mPbBgRect, paint);
//
//            //进度条
//            float pbTop = pbBgTop;
//            float pbLeft = pbBgLeft;
//            mPbRect.left = (int) pbLeft;
//            mPbRect.right = (int) (pbLeft + width);
//            mPbRect.top = (int) pbTop;
//            mPbRect.bottom = (int) (pbTop + mProgressBarNp.getHeight());
//            mProgressBarNp.draw(canvas, mPbRect, paint);
//
//
//            float gearBottom = pbBgTop - PROGRESSBAR_GAP;
//
//            float value = getRotate(5);
//            //蓝色齿轮
//            float blueTop = gearBottom - mBlueGearBitmap.getHeight();
//            float blueLeft = (getWidth() - mBlueGearBitmap.getWidth()) / 2;
//            float blueOffsetX = mBlueGearBitmap.getWidth() / 2;
//            float blueOffsetY = mBlueGearBitmap.getHeight() / 2;
//            mBlueMatrix.reset();
//            mBlueMatrix.postTranslate(-blueOffsetX, -blueOffsetY);
//            mBlueMatrix.postRotate(360 - value);
//            mBlueMatrix.postTranslate(blueOffsetX, blueOffsetY);
//            mBlueMatrix.postTranslate(blueLeft, blueTop);
//            canvas.drawBitmap(mBlueGearBitmap, mBlueMatrix, paint);
//
//            //黄色齿轮
//            float yellowTop = blueTop - mYellowGearBitmap.getHeight() + YELOOW_TOP_GEAR_GAP;
//            float yellowLeft = getWidth() / 2 - mYellowGearBitmap.getWidth() - YELOOW_LEFT_GEAR_GAP;
//            float yellowOffsetX = mYellowGearBitmap.getWidth() / 2;
//            float yellowOffsetY = mYellowGearBitmap.getHeight() / 2;
//            mYellowMatrix.reset();
//            mYellowMatrix.postTranslate(-yellowOffsetX, -yellowOffsetY);
//            mYellowMatrix.postRotate(value);
//            mYellowMatrix.postTranslate(yellowOffsetX, yellowOffsetY);
//            mYellowMatrix.postTranslate(yellowLeft, yellowTop);
//            canvas.drawBitmap(mYellowGearBitmap, mYellowMatrix, paint);
//
//            //绿色齿轮
//            float greenTop = blueTop - mGreenGearBitmap.getHeight() + GREEN_TOP_GEAR_GAP;
//            float greenLeft = getWidth() / 2 + GREEN_LEFT_GEAR_GAP;
//            float greenOffsetX = mGreenGearBitmap.getWidth() / 2;
//            float greenOffsetY = mGreenGearBitmap.getHeight() / 2;
//            mGreenMatrix.reset();
//            mGreenMatrix.postTranslate(-greenOffsetX, -greenOffsetY);
//            mGreenMatrix.postRotate(value);
//            mGreenMatrix.postTranslate(greenOffsetX, greenOffsetY);
//            mGreenMatrix.postTranslate(greenLeft, greenTop);
//            canvas.drawBitmap(mGreenGearBitmap, mGreenMatrix, paint);
//
//        }
//
//        /**
//         * 绘制进度条
//         *
//         * @param canvas
//         */
//        private void drawProgressBar(Canvas canvas, float scale, float offset) {
//            paint.setStyle(Style.FILL);
//            paint.setColor(Color.WHITE);
//            paint.setAntiAlias(true);
//
//            float f = getProgress(mStartTime, 0, 1f);
//            paint.setAlpha((int) (255 * f));
//            float width = 0;
//            if (mState == 1) {
//                width = scale * (mBarWidht * 0.9f);
//                mProgressShowWidth = width;
//            } else {
//                width = mProgressShowWidth + (mBarWidht - mProgressShowWidth) * scale;
//            }
//
//            int left = (int) ((canvas.getWidth() - mBarWidht) / 2);
//            float topPadding = 4.0f;
//            int top = (int) ((canvas.getHeight()) / 2 + mBarHeight + mDensity * topPadding +
//                    offset);
//
//            RectF rfFill = new RectF(left, top, left + width, top + mBarHeight);
//            canvas.drawRoundRect(rfFill, 15, 15, paint);
//
//            paint.setStyle(Style.STROKE);
//            RectF rfStroke = new RectF(left, top, left + mBarWidht, top + mBarHeight);
//            canvas.drawRoundRect(rfStroke, 15, 15, paint);
//        }
//
//        private void close() {
//            UserBehaviorIPCManager.getInstance().report(false, InfocConstants
//                            .MODEL_LAUNCHER_SPLASH_WAITING,
//                    InfocConstants.COMMON_KEY_INTIME, String.valueOf(mAutoInstallCMTin),
//                    InfocConstants.COMMON_KEY_OUTTIME, String.valueOf(System.currentTimeMillis()),
//                    InfocConstants.COMMON_KEY_VALUE, mCurrentShowType == TYPE_SHOW_ORGANIZING ?
//                            "0" : "1",
//                    InfocConstants.COMMON_KEY_PKGNAME, "DefaultLike",
//                    InfocConstants.COMMON_KEY_WAY, "2");
//            destroy();
//        }
//    }
//
//    // -----------------------------------DRAWING OBJECTS
//    // END-----------------------------------//
//    // -----------------------------------DRAWING OBJECTS
//    // END-----------------------------------//
//    // -----------------------------------DRAWING OBJECTS
//    // END-----------------------------------//
//    @Override
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        Launcher launcher = LauncherAppState.getInstance().getLauncher();
//        if (launcher != null) {
//            GLSearchBar searchBar = launcher.getSearchBar();
//            if (searchBar != null) {
//                searchBar.handleSplashDetached();
//            }
//        }
//    }
//
//    public void onStart() {
//        synchronized (this) {
//            if (mStopped) {
//                mStopped = false;
//                notify();
//            }
//        }
//    }
//
//    public void onStop() {
//        if (!mIsStart) {
//            mStopped = true;
//        }
//    }
//
//    public void setWallpaperChanged() {
//        mWallpaperChangedSuccess = true;
//    }
//
//    public static void CopyAssets(Context context, String assetDir, String dir) {
//        String[] files;
//        try {
//            files = context.getResources().getAssets().list(assetDir);
//        } catch (IOException e1) {
//            return;
//        }
//        File mWorkingPath = new File(dir);
//        // if this directory does not exists, make one.
//        if (!mWorkingPath.exists()) {
//            if (!mWorkingPath.mkdirs()) {
//
//            }
//        }
//
//        for (int i = 0; i < files.length; i++) {
//            try {
//                String fileName = files[i];
//                // we make sure file name not contains '.' to be a folder.
//                if (!fileName.contains(".")) {
//                    if (0 == assetDir.length()) {
//                        CopyAssets(context, fileName, dir + fileName + "/");
//                    } else {
//                        CopyAssets(context, assetDir + "/" + fileName, dir + fileName + "/");
//                    }
//                    continue;
//                }
//                File outFile = new File(mWorkingPath, fileName);
//                if (outFile.exists())
//                    outFile.delete();
//                InputStream in = null;
//                if (0 != assetDir.length())
//                    in = context.getAssets().open(assetDir + "/" + fileName);
//                else
//                    in = context.getAssets().open(fileName);
//                OutputStream out = new FileOutputStream(outFile);
//
//                // Transfer bytes from in to out
//                byte[] buf = new byte[1024];
//                int len;
//                while ((len = in.read(buf)) > 0) {
//                    out.write(buf, 0, len);
//                }
//
//                in.close();
//                out.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void onBackPressed() {
//        if (mThemeChoose != null && SplashThemeHelper.getInstance().isShowTheme() &&
//                mIsShowReport) {
//            mThemeChoose.reportOnback();
//        }
//
//        if (null != mOrganizingDesktop && mOrganizingDesktop.isSplashWallpaperDestory()) {
//            UserBehaviorIPCManager.getInstance().report(false, InfocConstants.LAUNCHER_ONETAP_TEST,
//                    InfocConstants.KEY_USER_TYPE, InfocConstants.COMMON_VALUE_2,
//                    InfocConstants.KEY_ONE_TAP_TEST_ACT, InfocConstants.COMMON_VALUE_4);
//        }
//
//        if (null != mLockerChoose && isClickNext) {
//            UserBehaviorIPCManager.getInstance().report(false, InfocConstants.LAUNCHER_ONETAP_TEST,
//                    InfocConstants.KEY_USER_TYPE, InfocConstants.COMMON_VALUE_1,
//                    InfocConstants.KEY_ONE_TAP_TEST_ACT, InfocConstants.COMMON_VALUE_4);
//        }
//    }
//
//    public static boolean isTablet(Context context) {
//        return (context.getResources().getConfiguration().screenLayout & Configuration
//                .SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
//    }
//
//    public static boolean mIsLockerSettingFinish = true;
//
//    public void startLocker(boolean needRepair) {
//        final Context context = getContext();
//        Intent intent = new Intent(context, SplashSurfaceViewCoverActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra(SplashSurfaceViewCoverActivity.EXTRA_NEED_REPAIR, needRepair);
//        context.startActivity(intent);
//        mIsLockerSettingFinish = false;
//    }
//
//}
