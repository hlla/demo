package example.com.testchengjianview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.chengjian.gl.engine.Engine;
import com.chengjian.gl.view.chengjianview;

import java.lang.reflect.Method;

public class MainActivity extends Activity {
    private static final String TAG = "chengjianview_test";
    private com.chengjian.gl.view.LayoutInflater mGLInflater;
    private LayoutInflater mInflater;
    private ViewGroup mRootView;
    private chengjianview mRootchengjianview;
    private Engine mEngine;
    private LauncherViewFrameLayout mLauncherView;
    private InsertDialog mInsertDialog;

    private void initEngine() {
        mEngine = Engine.init(this.getApplicationContext(), WallpaperTranslucent
                .isWallpaperTranslucent(WallpaperTranslucent.WPType.WP_TYPE_NORMAL));
        if (mEngine == null) {
            throw new IllegalStateException("wallpaper changed,need restart process");
        }
        test(null);
    }

    private void test(WindowInsets insets) {

    }

    private int getHasVirtualKey() {
        int dpi = 0;
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        @SuppressWarnings("rawtypes")
        Class c;
        try {
            c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            dpi = dm.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dpi;
    }

    private static int getNavigationHeightFromResource(Context context) {

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int navigationBarHeight = 0;
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("config_showNavigationBar",
                "bool", "android");
        if (resourceId > 0) {
            boolean hasNav = resources.getBoolean(resourceId);
            if (hasNav) {
                resourceId = resources.getIdentifier("navigation_bar_height",
                        "dimen", "android");
                if (resourceId > 0) {
                    navigationBarHeight = resources
                            .getDimensionPixelSize(resourceId);
                }
            }
        }

        if (navigationBarHeight <= 0) {
            DisplayMetrics dMetrics = new DisplayMetrics();
            display.getMetrics(dMetrics);
            int screenHeight = Math.max(dMetrics.widthPixels, dMetrics.heightPixels);
            int realHeight = 0;
            try {
                Method mt = display.getClass().getMethod("getRealSize", Point.class);
                Point size = new Point();
                mt.invoke(display, size);
                realHeight = Math.max(size.x, size.y);
            } catch (NoSuchMethodException e) {
                Method mt = null;
                try {
                    mt = display.getClass().getMethod("getRawHeight");
                } catch (NoSuchMethodException e2) {
                    try {
                        mt = display.getClass().getMethod("getRealHeight");
                    } catch (NoSuchMethodException e3) {
                        Log.e(TAG, "getScreenRealHeight Failed: ", e3);
                    }
                }
                if (mt != null) {
                    try {
                        realHeight = (Integer) mt.invoke(display);
                    } catch (Exception e1) {
                        Log.e(TAG, "getScreenRealHeight Failed: ", e1);
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "getScreenRealHeight Failed: ", e);
            }
            navigationBarHeight = realHeight - screenHeight;
        }

        return navigationBarHeight;
    }

    int systemBottom;
    int systemTop;

    public int getSystemBottom() {
        return systemBottom;
    }

    public int getSystemTop() {
        return systemTop;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemUtils.initSysSettings(getApplicationContext());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int SCREEN_WIDTH = 0;
        int SCREEN_HEIGHT = 0;
        if (getResources().getConfiguration().orientation == Configuration
                .ORIENTATION_LANDSCAPE) {
            SCREEN_WIDTH = dm.heightPixels;
            SCREEN_HEIGHT = dm.widthPixels;
        } else {
            SCREEN_WIDTH = dm.widthPixels;
            SCREEN_HEIGHT = dm.heightPixels;
        }
        Log.e(TAG, "onCreate: SCREEN_HEIGHT=" + SCREEN_HEIGHT + " getHasVirtualKey()=" +
                getHasVirtualKey() + " navigation=" + getNavigationHeightFromResource(this) + " " +
                "StatusBarHeight=" + SystemUtils.getStatusBarHeight(this));
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        initEngine();
//        mGLInflater = com.chengjian.gl.view.LayoutInflater.from(this);
        mInflater = LayoutInflater.from(this);
//        mRootchengjianview = mGLInflater.inflate(R.layout.activity_main_gl, null);
//        mRootView = mEngine.getRootView();
        mRootView = new TestFrameLayout(this);
        mRootView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams
                .MATCH_PARENT));
//        mRootView.setFitsSystemWindows(true);
        mRootView.addView(mInflater.inflate(R.layout.activity_main, null));
//        int count = mRootView.getChildCount();
//        for (int i = 0; i < count; i++) {
//            mRootView.getChildAt(i).setFitsSystemWindows(true);
//        }
//        mRootView.setFitsSystemWindows(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            mRootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                    Exception exception = new Exception("onApplyWindowInsets");
                    Log.e(TAG, "onApplyWindowInsets: insets=" + insets);
//                mLauncherView.setPadding(insets.getSystemWindowInsetLeft(), insets
//                        .getSystemWindowInsetTop(), insets.getSystemWindowInsetRight(), insets
//                        .getSystemWindowInsetBottom());
//                mRootView.setBackgroundColor(Color.TRANSPARENT);
                    systemTop = insets.getSystemWindowInsetTop();
                    systemBottom = insets.getSystemWindowInsetBottom();
//                    if (null != mInsertDialog && null != mInsertDialog.insertRoot) {
//                        mInsertDialog.insertRoot.setPadding(0, systemTop, 0, 0);
//                        ViewGroup.LayoutParams params = mInsertDialog.insertRoot.getLayoutParams();
//                        params.height = SystemUtils.getRealHeight(MainActivity.this) - systemBottom;
//                        mInsertDialog.insertRoot.setLayoutParams(params);
//                    }
                    return insets;
                }
            });
        } else {
            systemTop = SystemUtils.getStatusBarHeight(this);
            systemBottom = SystemUtils.getNavigationBarHeight(this);
        }
//        mRootchengjianview.setFitsSystemWindows(true);
//        mEngine.setContentView(mRootchengjianview);
        setContentView(mRootView);
//        final View view = mInflater.inflate(R.layout.activity_main, null);
//        mRootView.addView(view);
//        view.setVisibility(View.GONE);
//        mLauncherView = (LauncherViewFrameLayout) mRootchengjianview.findViewById(R.id.launcher);
        mRootView.findViewById(R.id.launcher_first).setOnClickListener(new View.OnClickListener
                () {
            @Override
            public void onClick(View chengjianview) {
                if (null == mInsertDialog) {
                    mInsertDialog = new InsertDialog(MainActivity.this);
                }
                mInsertDialog.show();
//                FrameLayout rootView = new FrameLayout(MainActivity.this);
//                rootView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams
//                        .MATCH_PARENT, ViewGroup.LayoutParams
//                        .MATCH_PARENT));
//                rootView.setBackgroundColor(Color.YELLOW);
//                view.setVisibility(View.VISIBLE);
//                mLauncherView.setVisibility(View.GONE);
//                toggle();
            }
        });
//        mRootView.findViewById(R.id.launcher).setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
//                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View
//                        .SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//        mRootchengjianview.findViewById(R.id.launcher).setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
//                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View
//                        .SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//        mRootchengjianview.findViewById(R.id.sub_launcher).setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
//                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View
//                        .SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mRootView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View
                        .SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    }

    boolean mVisible = true;

    private void toggle() {
        Log.e("chengjianview_test", "toggle: mVisible=" + mVisible);
        if (mVisible) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LOW_PROFILE
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                           /* | View.SYSTEM_UI_FLAG_LAYOUT_STABLE*/
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            );
        }

        mVisible = !mVisible;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart(): ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
//        SystemUtils.setupTransparentSystemBarsForLollipop(getWindow());
    }

}
