package com.example.testservice;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

import static android.content.Context.WINDOW_SERVICE;

public class DeviceInfoUtils {
    private static final String TAG = "DeviceInfoUtils";
    private static Context mcontext;

    /**
     * 网络连接类型
     */
    public interface ArkNetworkType {

        int ARK_NETWORK_NONE = 0;
        int ARK_NETWORK_WIFI = 1;
        int ARK_NETWORK_2G = 2;
        int ARK_NETWORK_3G = 3;
        int ARK_NETWORK_4G = 4;
    }

    /**
     * 运营商网络
     * 设备网络运营商 0-未知 1-移动 2-联通 3-电信
     */
    public interface OperatorType {

        int TYPE_UNKOWN = 0;
        int TYPE_MOBILE = 1;
        int TYPE_UNICOM = 2;
        int TYPE_TELECOM = 3;
    }

    public static void setContext(Context context) {
        mcontext = context;
    }

    public static String getTimeZone() {
        String tz = "";
        try {
            TimeZone timeZone = TimeZone.getDefault();
            tz = timeZone.getDisplayName(false, TimeZone.SHORT);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return tz;
    }

    public static int getScreenHeight(Context context) {
        Point outPoint = new Point();
        try {
            if (null != context) {
                Display display = ((WindowManager) context.getSystemService(
                        WINDOW_SERVICE)).getDefaultDisplay();
                display.getSize(outPoint);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return outPoint.y;
    }

    public static int getOperator() {
        int type = OperatorType.TYPE_UNKOWN;
        if (null == mcontext) {
            return type;
        }
        try {
            TelephonyManager tManager = (TelephonyManager) mcontext.getSystemService(Context
                    .TELEPHONY_SERVICE);
            Log.d(TAG, "getOperator tManager=" + tManager);
            if (null != tManager) {
                String imsi = tManager.getSubscriberId();
                Log.d(TAG, "getOperator imsi=" + imsi);
                if (null != imsi) {
                    if (imsi.startsWith("46000") || imsi.startsWith("46002") || imsi.startsWith
                            ("46007")) {
                        type = OperatorType.TYPE_MOBILE;
                    } else if (imsi.startsWith("46001")) {
                        type = OperatorType.TYPE_UNICOM;
                    } else if (imsi.startsWith("46003")) {
                        type = OperatorType.TYPE_TELECOM;
                    }
                }

            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return type;
    }

    /**
     * @return 判断当前手机是否是全屏
     */
    public static boolean isFullScreen(Context context) {
        try {
            if (null != context && context instanceof Activity) {
                int flag = ((Activity) context).getWindow().getAttributes().flags;
                if ((flag & WindowManager.LayoutParams.FLAG_FULLSCREEN)
                        == WindowManager.LayoutParams.FLAG_FULLSCREEN) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
            Log.d(TAG, "isFullScreen e=" + e);
        }
        return false;
    }

    public static float getDensityDpi() {
        int densityDpi = DisplayMetrics.DENSITY_XHIGH;
        if (null == mcontext) {
            return densityDpi;
        }
        try {
            DisplayMetrics metric = new DisplayMetrics();
            Display display = ((WindowManager) mcontext.getSystemService(
                    WINDOW_SERVICE)).getDefaultDisplay();
            if (null != display) {
                display.getMetrics(metric);
                densityDpi = metric.densityDpi;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            Log.d(TAG, "getDensityDpi e=" + e);
        }
        return densityDpi;
    }

    public static String getUserAgent() {
        String userAgent = "";
        Log.d(TAG, "getUserAgent mcontext=" + mcontext);
        if (null == mcontext) {
            return userAgent;
        }
        try {
            WebView webview;
            webview = new WebView(mcontext);
            webview.layout(0, 0, 0, 0);
            WebSettings settings = webview.getSettings();
            userAgent = settings.getUserAgentString();
        } catch (Throwable e) {
            e.printStackTrace();
            Log.d(TAG, "getUserAgent e=" + e);
        }
        return userAgent;
    }

    public static String getDefaultUserAgent() {
        String userAgent = "";
        try {
            StringBuilder result = new StringBuilder(64);
            result.append("Dalvik/");
            result.append(System.getProperty("java.vm.version")); // such as 1.1.0
            result.append(" (Linux; U; Android ");

            String version = Build.VERSION.RELEASE; // "1.0" or "3.4b5"
            result.append(!TextUtils.isEmpty(version) ? version : "1.0");

            // add the model for the release build
            if ("REL".equals(Build.VERSION.CODENAME)) {
                String model = Build.MODEL;
                if (!TextUtils.isEmpty(model)) {
                    result.append("; ");
                    result.append(model);
                }
            }
            String id = Build.ID; // "MASTER" or "M4-rc20"
            if (!TextUtils.isEmpty(id)) {
                result.append(" Build/");
                result.append(id);
            }
            result.append(")");
            userAgent = result.toString();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return userAgent;
    }

    /**
     * @param context
     * @return 获取无线mac地址
     */
    public static String getWirelessMacAddress(Context context) {
        String result = "";
        if (context != null) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context
                        .WIFI_SERVICE);
                if (wifiManager != null) {
                    WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                    if (wifiInfo != null) {
                        result = wifiInfo.getMacAddress();
                    }
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "wifi manager: " + result);
        if (!isMacAddressValid(result)) {
            result = getMacAddressForM("wlan0");
            Log.d(TAG, "wlan0: " + result);
        }
        Log.d(TAG, "return: " + result);
        return result;
    }

    /**
     * @param context
     * @return 获取有线mac地址
     */
    public static String getWiredMacAddress(Context context) {
        String result = getMacAddressForM("eth0");
        Log.d(TAG, "eth0: " + result);
        return result;
    }

    private static boolean isMacAddressValid(String macAddress) {
        boolean res = false;
        if (null != macAddress
                && !TextUtils.isEmpty(macAddress)
                && !TextUtils.isEmpty(macAddress.trim())
                && !macAddress.equalsIgnoreCase("02:00:00:00:00:00")) {
            res = true;
        }
        return res;
    }

    /**
     * 获取Mac地址,6.0以后版本用
     *
     * @return
     */
    public static String getMacAddressForM(String type) {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase(type)) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(Integer.toHexString(b & 0xFF) + ":");
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return "02:00:00:00:00:00";
    }

    /**
     * 初次获取设备唯一标识
     */
    public static String getAndroidId() {
        String androidId = "";
        try {
            if (null == mcontext) {
                return "";
            }
            androidId = Settings.Secure.getString(mcontext.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return androidId;
    }

    /**
     * 检测是否由代理连接
     *
     * @param context
     * @return
     */
    @SuppressWarnings("deprecation")
    public static boolean isProxyNet(Context context) {
        if (context == null) {
            return false;
        }
        try {
            final WifiManager manager = (WifiManager) context.getSystemService(Context
                    .WIFI_SERVICE);
            if (null != manager) {
                manager.getConnectionInfo();
            }

            String proxyAddress;
//            // android sdk版本大于ics
//            final boolean isAboveICS = Build.VERSION.SDK_INT >= Build.VERSION_CODES
//                    .ICE_CREAM_SANDWICH;
//            if (isAboveICS) {
//                proxyAddress = System.getProperty("http.proxyHost");
//            } else {
            proxyAddress = android.net.Proxy.getHost(context);
//            }

            return !TextUtils.isEmpty(proxyAddress);
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        }
    }
}
