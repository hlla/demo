/**
 * @brief Package com.ijinshan.browser.utils
 * @author zhouchenguang
 * @version 1.0.0.0
 * @date 2012-12-23
 * @since 1.0.0.0
 */

package example.com.testchengjianview;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import java.io.File;
import java.lang.reflect.Method;

public class SystemUtils {
    private static final String TAG = "SystemUtils";
    private static int SCREEN_WIDTH = 480;
    private static int SCREEN_HEIGHT = 800;
    private static String sScreenVga = "";
    private static float DENSITY = 1;
    private static int sNavigationBarHeight = Integer.MIN_VALUE;

    public static void initSysSettings(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        if (context.getResources().getConfiguration().orientation == Configuration
                .ORIENTATION_LANDSCAPE) {
            SCREEN_WIDTH = dm.heightPixels;
            SCREEN_HEIGHT = dm.widthPixels;
        } else {
            SCREEN_WIDTH = dm.widthPixels;
            SCREEN_HEIGHT = dm.heightPixels;
        }
        DENSITY = dm.density;
    }

    public static float getDesity() {
        return DENSITY;
    }

    public static int getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public static int getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    public static int getSdkVersion() {
        return VERSION.SDK_INT;
    }

    /**
     * Sets up transparent navigation and status bars in Lollipop.
     * This method is a no-op for other platform versions.
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setupTransparentSystemBarsForLollipop(Window window) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.getAttributes().systemUiVisibility |=
//                    (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//            View decorView = window.getDecorView();
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//            if (null != mRootView) {
//                mRootView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
////                mRootView.setBackgroundColor(Color.YELLOW);
//            }
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN//视图延伸至状态栏区域，状态栏上浮于视图之上
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION//视图延伸至导航栏区域，导航栏上浮于视图之上
//                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE//保持整个View稳定, 常和控制System UI悬浮,
//                    // 隐藏的Flags共用, 使View不会因为System UI的变化而重新layout
//            );
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    public static void setupTransparentSystemBarsForLollipop1(Window window) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.getAttributes().systemUiVisibility |=
//                    (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//            View decorView = window.getDecorView();
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//            if (null != mRootView) {
//                mRootView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
////                mRootView.setBackgroundColor(Color.YELLOW);
//            }
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN//视图延伸至状态栏区域，状态栏上浮于视图之上
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION//视图延伸至导航栏区域，导航栏上浮于视图之上
//                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE//保持整个View稳定, 常和控制System UI悬浮,
//                    // 隐藏的Flags共用, 使View不会因为System UI的变化而重新layout
//            );
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0x5f000000);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    public static String getScreenVga() {
        if (TextUtils.isEmpty(sScreenVga)) {
            StringBuilder vga = new StringBuilder(String.valueOf(getScreenWidth()));
            vga.append("x");
            vga.append(String.valueOf(getScreenHeight()));
            sScreenVga = vga.toString();
        }

        return sScreenVga;
    }


    /**
     * 由于线程竞争或进程竞争， 某些版本的android系统上 context.getFilesDir() 创建目录会失败，并返回null，
     * 为解决该问题， 当发现返回值为null时，try again。
     *
     * @param context
     * @return files directory
     */
    public static File getFilesDir(Context context) {
        File filesDir = context.getFilesDir();
        return filesDir != null ? filesDir : context.getFilesDir();
    }

    /**
     * 一张SD卡的相关信息
     *
     * @author caisenchuan
     */
    public static class SDCard {
        private String path;
        private boolean mount;
        private boolean removeable;

        public SDCard(int index, String path, boolean mount, boolean removeable) {
            this.path = path;
            this.mount = mount;
            this.removeable = removeable;
        }

        /**
         * @return the path
         */
        public String getPath() {
            return path;
        }

        /**
         * @return the mount
         */
        public boolean isMount() {
            return mount;
        }

        /**
         * @return the removeable
         */
        public boolean isRemoveable() {
            return removeable;
        }
    }

    // -------------------------------------------------------------------------

    private static final String SCHEME = "package";
    /**
     * 调用系统InstalledAppDetails界面所需的Extra名称(用于Android 2.1及之前版本)
     */
    private static final String APP_PKG_NAME_21 = "com.android.settings.ApplicationPkgName";
    /**
     * 调用系统InstalledAppDetails界面所需的Extra名称(用于Android 2.2)
     */
    private static final String APP_PKG_NAME_22 = "pkg";

    private static final String ACTION_APPLICATION_DETAILS_SETTINGS_23 = "android.settings" +
            ".APPLICATION_DETAILS_SETTINGS";
    /**
     * InstalledAppDetails所在包名
     */
    private static final String APP_DETAILS_PACKAGE_NAME = "com.android.settings";
    /**
     * InstalledAppDetails类名
     */
    private static final String APP_DETAILS_CLASS_NAME = "com.android.settings.InstalledAppDetails";

    /**
     * 调用系统InstalledAppDetails界面显示已安装应用程序的详细信息。 对于Android 2.3（Api Level
     * 9）以上，使用SDK提供的接口； 2.3以下，使用非公开的接口（查看InstalledAppDetails源码）。
     *
     * @param packageName 应用程序的包名
     */
    public static Intent getPackageDetailsIntent(String packageName) {
        Intent intent = new Intent();
        int apiLevel = 0;
        try {
            apiLevel = VERSION.SDK_INT;
        } catch (Exception ex) {
        }
        if (apiLevel >= 9) { // 2.3（ApiLevel 9）以上，使用SDK提供的接口
            intent.setAction(ACTION_APPLICATION_DETAILS_SETTINGS_23);
            Uri uri = Uri.fromParts(SCHEME, packageName, null);
            intent.setData(uri);
        } else { // 2.3以下，使用非公开的接口（查看InstalledAppDetails源码）
            // 2.2和2.1中，InstalledAppDetails使用的APP_PKG_NAME不同。
            final String appPkgName = (apiLevel > 7 ? APP_PKG_NAME_22 : APP_PKG_NAME_21);
            intent.setAction(Intent.ACTION_VIEW);
            intent.setClassName(APP_DETAILS_PACKAGE_NAME, APP_DETAILS_CLASS_NAME);
            intent.putExtra(appPkgName, packageName);
        }
        return intent;
    }

    /**
     * 清除所有通知
     *
     * @author caisenchuan
     */
    public static void clearAllNotification(Context context) {
        NotificationManager manager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancelAll();
    }


    // 判断APK是否安装
    // *** 如果安装了，但是已经被系统停用，也被认为是没有安装 ***
    public static boolean isAPPInstalled(Context context, String pkg_name) {
        PackageManager pm = context.getPackageManager();
        boolean installed = false;
        try {
            PackageInfo info = pm.getPackageInfo(pkg_name, PackageManager.GET_ACTIVITIES);
            if (info != null)
                installed = info.applicationInfo.enabled;

        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }

    public static boolean isAPPInstalled(Context context, String[] pkg_name) {
        for (String pkg : pkg_name) {
            if (isAPPInstalled(context, pkg)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isSdkVersionJellyBean() {
        return getSdkVersion() >= Build.VERSION_CODES.JELLY_BEAN;
    }

    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        int status_bar_height_id = context.getResources().getIdentifier(
                "status_bar_height", "dimen", "android");
        if (status_bar_height_id > 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(
                    status_bar_height_id);
        } else {
            statusBarHeight = (int) Math.ceil(25 * context.getResources()
                    .getDisplayMetrics().density);
        }
        return statusBarHeight;
    }

//    /**
//     * @Note: 获取状态栏的高度
//     */
//    public static int getStatusBarHeight(Activity activity) {
//        int height = 0;
//        do {
//            if (activity == null)
//                break;
//            if (activity.getWindow() == null)
//                break;
//            if (activity.getWindow().getDecorView() == null)
//                break;
//            Rect rect = new Rect();
//            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
//            height = rect.top;
//        } while (false);
//
//        return height;
//    }

    /**
     * 获取导航栏高度
     *
     * @param context
     * @return
     */
    public static int getNavigationBarHeight(Context context) {
//        if (sNavigationBarHeight != Integer.MIN_VALUE) {
//            return sNavigationBarHeight;
////        }
//        synchronized (SystemUtils.class) {
//            if (sNavigationBarHeight == Integer.MIN_VALUE)
        sNavigationBarHeight = getNavigationBarHeightInternal(context);
//        }
        return sNavigationBarHeight;
    }

    private static int getNavigationBarHeightInternal(Context context) {
//        if (isExceptProcessNavigationBar()) {
//            return 0;
//        }
        return getNavigationHeightFromResource(context);
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


    public static String getApplicationName(Context context, String pkg_name) {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        String applicationName = null;
        try {
            packageManager = context.getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(pkg_name, 0);
            applicationName = (String) packageManager.getApplicationLabel(applicationInfo);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationName;
    }

    public static Drawable getApplicationIcon(Context context, String pkg_name) {
        try {
            return context.getPackageManager().getApplicationIcon(pkg_name);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    // 获取已安装pkg_name的Version code
    // 返回-1，获取失败
    public static int getVersionCode(Context context, String pkg_name) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(pkg_name,
                    PackageManager.GET_ACTIVITIES);
            if (info != null)
                return info.versionCode;
        } catch (Exception e) {
        }
        return -1;
    }


    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();
            return info != null && info.isConnected();
        }
        return false;
    }

    public static int getRealHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getApplicationContext()
                .getSystemService(Context
                        .WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display.getRealMetrics(dm);
        } else {
            display.getMetrics(dm);
        }
        int realHeight = dm.heightPixels;
        return realHeight;
    }

//    private int getFullScreenHeight(Context context) {
//        int fullHeight = 0;
//        if (context != null) {
//            Window window = this.getWindow();
//            DisplayMetrics dm = context.getResources().getDisplayMetrics();
//            if (null != window && null != dm) {
////                if (CommonUtils.isNavigationBarShow(window.getWindowManager())) {
////                    fullHeight = dm.heightPixels + statusBarHeight + naviBarHeight;
////                } else {
////                    fullHeight = dm.heightPixels + statusBarHeight;
////                }
//                fullHeight = dm.heightPixels;
//            }
//        }
//        return fullHeight;
//    }

    public static void hideSoftKeyboard(Context mContext, View view) {
        // Hide soft keyboard, if visible
        InputMethodManager inputMethodManager = (InputMethodManager)
                mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}

