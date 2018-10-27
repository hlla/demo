package example.com.testglview;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.util.concurrent.Future;

/**
 * Created by zhushuang on 2017/9/26.
 */

public class InsertDialog extends SmartDialog implements View.OnClickListener {

    public static final int SOURCE_LAUNCHER = 1;
    private static final String TAG = "glview_Insert";
    private static final int FUNC_TYPE_INSERT_DIALOG_HOME = 9;
    private static final String SECTION_HOME = "startpage_homeclick";
    private static final String KEY_HOME = "click_tohome";
    private static final String LAUNCHER_STARTPAGE_AD_DESTROY = "launcher_startpage_ad_destroy";
    private static final String STARTPAGE_DESTROY_AD = "startpage_destroy_ad";
    private MainActivity mContext;
    private FrameLayout insertContentRoot;
    public View insertRoot;
    private RelativeLayout mRlLoading;
    private View mTopView;
    private int mType;
    private ImageView mIvSet;
    private ProgressBar mPb;
    private Future mFuture;
    private int insertSource;
    private long mStartTime, mEndTime;
    private String closeDialogType;
    private static final String GREETINGSINSERT = "1";
    private static final String WEARTHSINSERT = "2";
    private static final String WALLPAPERINSERT = "3";
    private static final String OTHER = "4";
    private static final String CONSTELLATION_START = "5";
    private static final String CONSTELLATION_DETAILS = "6";
    private boolean isClickLearnMore = false;
    private long mClDetailPageShowTime;
    private String isCover = "2";
    private String startPageShowTime;
    public static boolean isDetailView = false;
    public static boolean isCardView = false;
    private static int fullScreenHeight = 0;
    private int lastHeight;
    private int statusBarHeight;
    private int naviBarHeight;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private Button mInsertButton;
    private LinearLayout mProBarMain;
    private ProgressBar mTimeProbar;

    @Override
    public void onAttachedToWindow() {
//        SystemUtils.setupTransparentSystemBarsForLollipop(getWindow());
    }

    public InsertDialog(MainActivity context) {
        super(context, R.style.InsertDialog, 0);
        this.mContext = context;
        initView();
//        View statusBar = findViewById(R.id.status_bar);
//        setStatusBarHeight(statusBar);
//        if (insertRoot != null) {
//            insertRoot.setBackgroundColor(Color.YELLOW);
//        }
    }

    private void initView() {
//        SystemUtils.setupTransparentSystemBarsForLollipop(getWindow());
        setContentView(R.layout.layout_insert_page);
        mTopView = findViewById(R.id.top_view_layout);
        insertRoot = findViewById(R.id.insert_root);
        insertRoot.post(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "run");
//                ((View) insertRoot.getParent()).setFitsSystemWindows(false);
//                ((View) insertRoot.getParent().getParent()).setFitsSystemWindows(false);
//                ((View) insertRoot.getParent().getParent().getParent()).setFitsSystemWindows
// (false);
//                ((View) insertRoot.getParent().getParent().getParent().getParent())
//                        .setFitsSystemWindows(false);
//                ViewGroup.LayoutParams params = insertRoot.getRootView().getLayoutParams();
//                params.height = SystemUtils.getRealHeight(getContext());
//                insertRoot.getRootView().setLayoutParams(params);
//                insertRoot.getRootView().requestLayout();
            }
        });
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
//            insertRoot.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
//                @Override
//                public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
//                    Exception exception = new Exception("onApplyWindowInsets");
//                    Log.e(TAG, "onApplyWindowInsets: insets=" + insets);
////                mLauncherView.setPadding(insets.getSystemWindowInsetLeft(), insets
////                        .getSystemWindowInsetTop(), insets.getSystemWindowInsetRight(), insets
////                        .getSystemWindowInsetBottom());
////                mRootView.setBackgroundColor(Color.TRANSPARENT);
////                    ViewGroup.LayoutParams params = insertRoot.getRootView().getLayoutParams();
////                    params.height = SystemUtils.getRealHeight(getContext());
////                    insertRoot.getRootView().setLayoutParams(params);
////                    insertRoot.getRootView().requestLayout();
////                    insertRoot.setPadding(0, SystemUtils.getStatusBarHeight(getContext()), 0,
////                            insets.getSystemWindowInsetBottom());
//                    insertRoot.requestLayout();
//                    return insets;
//                }
//            });
//        }
//        insertRoot.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
//                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View
//                        .SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mIvSet = (ImageView) findViewById(R.id.iv_set);
        findViewById(R.id.insert_setting).setOnClickListener(this);
        mIvSet.setOnClickListener(this);
        insertContentRoot = (FrameLayout) findViewById(R.id.insert_content);
        final ImageView backgroundIv = (ImageView) findViewById(R.id.insert_root_iv);
        naviBarHeight = SystemUtils.getNavigationBarHeight(mContext);
        statusBarHeight = SystemUtils.getStatusBarHeight(mContext);
        final Window window = getWindow();

        if (null != window) {
//            if (Build.VERSION.SDK_INT >= 16) {
//                if (0 == fullScreenHeight) {
//                    fullScreenHeight = getFullScreenHeight(mContext);
//                }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = WindowManager.LayoutParams.WRAP_CONTENT;
            Log.e(TAG, "initView:= " + attributes.height + " top=" + mContext.getSystemTop() +
                    "  bottom=" + mContext.getSystemBottom() + " sh=" + SystemUtils
                    .getScreenHeight());
            attributes.screenOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
            if (Build.VERSION.SDK_INT >= 19) {
//                window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
                attributes.height = WindowManager.LayoutParams.MATCH_PARENT;
//                insertRoot.setPadding(0, mContext.getSystemTop(), 0, 0);
            } else {
                attributes.height = WindowManager.LayoutParams.MATCH_PARENT;
            }
            attributes.height = 400;
            window.setAttributes(attributes);
            insertRoot.setBackgroundResource(R.drawable.cheetcare_type_overnight);
//                backgroundIv.setImageDrawable(mContext.getResources().getDrawable(R
//                        .drawable.cheetcare_type_overnight));
//                globalListener = new ViewTreeObserver.OnGlobalLayoutListener() {
//                    @Override
//                    public void onGlobalLayout() {
//                        Log.d(TAG, "onGlobalLayout: ");
//                        int[] location = new int[2];
//                        insertRoot.getLocationOnScreen(location);
//                        WindowManager.LayoutParams attributes = window.getAttributes();
//                        attributes.width = SystemUtils.getScreenWidth();
//                        attributes.height = fullScreenHeight - location[1];
//                        if (lastHeight == attributes.height) {
//                            return;
//                        }
//
//                        ViewGroup.LayoutParams params = insertRoot.getRootView()
// .getLayoutParams();
//                        params.height = attributes.height;
//                        lastHeight = attributes.height;
//                        attributes.screenOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
//                        window.setAttributes(attributes);
//                        insertRoot.getRootView().setLayoutParams(params);
//                        insertRoot.getRootView().requestLayout();
//                        backgroundIv.setImageDrawable(mContext.getResources().getDrawable(R
//                                .drawable.cheetcare_type_overnight));
//                    }
//                };
//                insertRoot.getViewTreeObserver().addOnGlobalLayoutListener(globalListener);
//            } else {
//                WindowManager.LayoutParams attributes = window.getAttributes();
//                attributes.width = SystemUtils.getScreenWidth();
//                attributes.height = SystemUtils.getScreenHeight() + SystemUtils
//                        .getStatusBarHeight(mContext);
//                attributes.screenOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
//                backgroundIv.setImageDrawable(mContext.getResources().getDrawable(R.drawable
//                        .cheetcare_type_overnight));
//            }
        }
//        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager
//                .LayoutParams
//                .MATCH_PARENT);
        SystemUtils.setupTransparentSystemBarsForLollipop1(mContext.getWindow());
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }


    private int getFullScreenHeight(Context context) {
        int fullHeight = 0;
        if (context != null) {
            Window window = this.getWindow();
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            if (null != window && null != dm) {
                fullHeight = dm.heightPixels;
            }
        }
        return fullHeight;
    }

    @Override
    public android.widget.FrameLayout.LayoutParams getContentLayoutParams() {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(RelativeLayout
                .LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER;
        return params;
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void setStatusBarHeight(View statusBar) {
        if (statusBar != null && Build.VERSION.SDK_INT >= 19.) {
            final ViewGroup.LayoutParams layoutParams = statusBar.getLayoutParams();
            layoutParams.height = SystemUtils.getStatusBarHeight(mContext);
            statusBar.setLayoutParams(layoutParams);
            statusBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        globalListener = null;
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 启动页返回逻辑
     */
    interface OnBackPressedListener {
        public void onBackPressed();
    }
}
