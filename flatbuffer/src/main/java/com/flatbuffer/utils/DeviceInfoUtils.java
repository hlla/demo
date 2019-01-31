
package com.flatbuffer.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.AppGlobals;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemProperties;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceInfoUtils {
    private static final String TAG = "DeviceInfoUtils";
    public static final int NET_OFF = 0;    //无网络
    public static final int NET_UNKNOWN = 1;    //未知网络
    public static final int NET_WIFI = 2;    //WIFI网络
    public static final int NET_2G = 4;    //2G网络
    public static final int NET_3G = 8;    //3G网络
    public static final int NET_4G = 16;   //4G网络
    public static final int NET_EXCEPTION = 32;   //获取网络状态失败
    public static final int NET_DEFAULT = NET_WIFI + NET_3G + NET_4G;

    private static String sAndroidID;
    private static String sIMEI;
    private static int sNumCores = 0;
    // Any device that runs this or an older version of the system cannot be considered 'low-end'
    // Only support low end device changes on builds greater than JB MR2.
    private static final int ANDROID_LOW_MEMORY_ANDROID_SDK_THRESHOLD = 18;
    //Build.VERSION_CODES.JELLY_BEAN_MR2;

    // A device reporting strictly more total memory in megabytes cannot be considered 'low-end'.
    private static final long ANDROID_LOW_MEMORY_DEVICE_THRESHOLD_MB = 512;

    private static Boolean sLowEndDevice;

    private static String mMccMnc;

    /**
     * sCustomLowEndDevice -1 specific this device no need customize
     * sCustomLowEndDevice 1  specific this device should enable low-end-device
     * sCustomLowEndDevice 0  specific this device should disable low-end-device
     */
    private static int sCustomLowEndDevice = -1;
    private static String sSpecialMobileRom;

    private DeviceInfoUtils() {

    }

    private static Context mContext;


    public static void setAppContext(Context context) {
        if (null != context) {
            if (context instanceof Application) {
                mContext = context;
            } else {
                mContext = context.getApplicationContext();
            }
        }
    }

    /**
     * @return the imei number
     * @brief get the imei number
     */
    public synchronized static String getIMEI() {
        if (sIMEI == null && null != mContext) {
            try {
                TelephonyManager tm = (TelephonyManager) mContext
                        .getSystemService(Context.TELEPHONY_SERVICE);
                sIMEI = tm.getDeviceId();
            } catch (Exception e) {
            }
        }
        return sIMEI;
    }

    /**
     * 获取原始 MAC 地址，以 ":" 分隔
     *
     * @return
     */
    public static String getRawMacAddress() {
        if (null == mContext) {
            return "";
        }
        String macAddress = null;
        try {
            WifiManager wifiMgr = (WifiManager) mContext
                    .getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = (null == wifiMgr ? null : wifiMgr
                    .getConnectionInfo());
            if (null != info) {
                macAddress = info.getMacAddress();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (macAddress == null) {
            macAddress = "";
        }
        return macAddress;
    }

    public static boolean isMemoryOk() {
        return getAvailabeMemoryM() > 256;
    }

    private static long getAvailabeMemoryM() {
        if (null == mContext) {
            return 0;
        }
        MemoryInfo mi = new MemoryInfo();
        ActivityManager activityManager = (ActivityManager) mContext
                .getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        return mi.availMem / 1024 / 1024;
    }

    /**
     * 获取手机mac地址<br/>
     * 错误返回12个0
     */
    public static String getMacAddress() {
        // 获取mac地址：
        String macAddress = getRawMacAddress();
        return macAddress.replace(":", "");
    }

    public static String getLanguage() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        return locale.getLanguage();
    }

    public static String getLanguage2() {
        String localeString = "en-US";
        String language = getLanguage();
        String country = Locale.getDefault().getCountry();
        if (!TextUtils.isEmpty(language)) {
            if (TextUtils.isEmpty(country)) {
                localeString = language;
            } else {
                localeString = String.format("%s-%s", language, country);
            }
        }
        return localeString;
    }

    public static String getLanguage3() {
        String localeString = "en_US";
        String language = getLanguage();
        String country = Locale.getDefault().getCountry();
        if (!TextUtils.isEmpty(language)) {
            if (TextUtils.isEmpty(country)) {
                localeString = language;
            } else {
                localeString = String.format("%s_%s", language, country);
            }
        }
        return localeString;
    }

    public static String getSerial() {
        String serial = "";
        try {
            serial = Build.SERIAL;
        } catch (Exception e) {
        }
        return serial;
    }

    public static boolean getRootAhth() {
        try {
            File su = new File("/system/bin/su");
            return su.exists();
        } catch (Exception e) {
            return false;
        }
    }


    /*
       获取的Android_id用于网络通信，请勿直接使用该接口获取AnndroidId
       参考CommonUtils.getAndroidId()
     */
    public static String getAndroidID() {
        if (sAndroidID != null || null == mContext)
            return sAndroidID;
        sAndroidID = Settings.System.getString(mContext
                        .getContentResolver(),
                Settings.System.ANDROID_ID);
        return sAndroidID;
    }

    public static String getPhoneType() {
        return Build.MODEL;
    }

    public static String getNumCoresStr() {
        int c = getNumCores();
        String r = "" + c;
        return r;
    }

    /**
     * Gets total RAM return -1 if error
     */
    private static final String MEM_TOTAL = "MemTotal:";
    private static final String MEM_UNIT = " kB";

    private static long getTotalRAM() {
        RandomAccessFile reader = null;
        String load = null;
        try {
            reader = new RandomAccessFile("/proc/meminfo", "r");
            load = reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

        if (TextUtils.isEmpty(load))
            return -1;

        int off = load.indexOf(MEM_TOTAL);
        if (off == -1) {
            Log.e("CHECK", "Can't get memory total:" + load);
            return -1;
        }

        off = off + MEM_TOTAL.length();

        int end = load.indexOf(MEM_UNIT);
        if (end == -1) {
            Log.e("CHECK", "Can't get memory total:" + load);
            return -1;
        }

        String num = load.substring(off, end).trim();
        long size = Long.valueOf(num);
        return size;
    }

    /**
     * Gets the number of cores available in this device, across all processors.
     * Requires: Ability to peruse the filesystem at "/sys/devices/system/cpu"
     *
     * @return The number of cores, or 1 if failed to get result
     */
    public static int getNumCores() {
        // Private Class to display only CPU devices in the directory listing
        class CpuFilter implements FileFilter {
            @Override
            public boolean accept(File pathname) {
                // Check if filename is "cpu", followed by a single digit number
                return Pattern.matches("cpu[0-9]", pathname.getName());
            }
        }

        try {
            // Get directory containing CPU info
            File dir = new File("/sys/devices/system/cpu/");
            // Filter to only list the devices we care about
            File[] files = dir.listFiles(new CpuFilter());
            // Return the number of cores (virtual CPU devices)
            return files.length;
        } catch (Exception e) {
            // Default to return 1 core
            return 1;
        }
    }

    public static boolean isLowEndModels() {
        if (sNumCores == 0) {
            sNumCores = getNumCores();
        }
        return sNumCores == 1;
    }

    public static boolean isTablet() {
        if (null == mContext) {
            return false;
        }
        final Resources resources = mContext.getResources();
        final Configuration configuration = resources.getConfiguration();
        int size = configuration.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        return size == Configuration.SCREENLAYOUT_SIZE_LARGE || size == Configuration
                .SCREENLAYOUT_SIZE_XLARGE;
    }

    public static boolean isMdpi() {
        if (null == mContext) {
            return false;
        }
        final Resources resources = mContext.getResources();
        final DisplayMetrics metrics = resources.getDisplayMetrics();

        return metrics.densityDpi <= DisplayMetrics.DENSITY_MEDIUM;
    }

    public static boolean isOSApiLevelEqualOrHigher(int apiLevel) {
        return Build.VERSION.SDK_INT >= apiLevel;
    }

    public static String getProcessName() {
        File f = new File("/proc/self/cmdline");
        InputStream reader = null;
        try {
            reader = new FileInputStream(f);
            byte[] buffer = new byte[256];
            int length = reader.read(buffer);
            if (length > 0)
                return new String(buffer, 0, length).trim();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    // ignore
                }
        }
        return "";
    }

    public static int getDensityDpi() {
        try {
            if (null == mContext) {
                return DisplayMetrics.DENSITY_HIGH;
            }
            return mContext.getResources().getDisplayMetrics().densityDpi;
        } catch (Exception e) {
            return DisplayMetrics.DENSITY_HIGH;
        }
    }

    public static float getDensity() {
        try {
            if (null == mContext) {
                return 1;
            }
            return mContext.getResources().getDisplayMetrics().density;
        } catch (Exception e) {
            return 1;
        }
    }

    /**
     * Return the amount of physical memory on this device in kilobytes.
     * Note: the only reason this is public is for testability reason.
     *
     * @return Amount of physical memory in kilobytes, or 0 if there was
     * an error trying to access the information.
     * <p>
     * Note that this is CalledByNative for testing purpose only.
     */
    public static int amountOfPhysicalMemoryKB() {
        // Extract total memory RAM size by parsing /proc/meminfo, note that
        // this is exactly what the implementation of sysconf(_SC_PHYS_PAGES)
        // does. However, it can't be called because this method must be
        // usable before any native code is loaded.

        // An alternative is to use ActivityManager.getMemoryInfo(), but this
        // requires a valid ActivityManager handle, which can only come from
        // a valid Context object, which itself cannot be retrieved
        // during early startup, where this method is called. And making it
        // an explicit parameter here makes all call paths _much_ more
        // complicated.

        Pattern pattern = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader reader = new BufferedReader(fileReader);
                try {
                    String line;
                    for (; ; ) {
                        line = reader.readLine();
                        if (line == null) {
                            Log.w(TAG, "/proc/meminfo lacks a MemTotal entry?");
                            break;
                        }
                        Matcher m = pattern.matcher(line);
                        if (!m.find()) continue;

                        int totalMemoryKB = Integer.parseInt(m.group(1));
                        // Sanity check.
                        if (totalMemoryKB <= 1024) {
                            Log.w(TAG, "Invalid /proc/meminfo total size in kB: " + m.group(1));
                            break;
                        }

                        return totalMemoryKB;
                    }

                } finally {
                    reader.close();
                }
            } finally {
                fileReader.close();
            }
        } catch (Exception e) {
            Log.w(TAG, "Cannot get total physical size from /proc/meminfo", e);
        }

        return 0;
    }

    /**
     * @return Whether or not this device should be considered a low end device.
     */
    public static boolean isLowEndDevice() {
        if (sCustomLowEndDevice != -1)
            return sCustomLowEndDevice == 1 ? true : false;

        if (sLowEndDevice == null) {
            sLowEndDevice = detectLowEndDevice();
        }

        return sLowEndDevice.booleanValue();
    }

    private static boolean detectLowEndDevice() {
        if (Build.VERSION.SDK_INT <= ANDROID_LOW_MEMORY_ANDROID_SDK_THRESHOLD) {
            return false;
        }

        int ramSizeKB = amountOfPhysicalMemoryKB();
        return (ramSizeKB > 0 && ramSizeKB / 1024 < ANDROID_LOW_MEMORY_DEVICE_THRESHOLD_MB);
    }

    public static int getSDKLevel() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 判断网络是否可用
     *
     * @return true:可用 false:不可用
     */
    public static boolean isNetworkActive() {
        if (null == mContext) {
            return false;
        }
        boolean bReturn = false;
        ConnectivityManager conManager = (ConnectivityManager)
                mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            NetworkInfo netInfo = conManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()) {
                bReturn = true;
            }
        } catch (Exception se) {
            // java.lang.SecurityException: ConnectivityService: Neither user 10035 nor current
            // process has android.permission.ACCESS_NETWORK_STATE.
        }

        return bReturn;
    }

    /**
     * 判断Wifi是否可用
     *
     * @return true:可用 false:不可用
     */
    public static boolean isWiFiActive() {
        if (null == mContext) {
            return false;
        }
        boolean bReturn = false;
        WifiManager mWifiManager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        try {
            WifiInfo wifiInfo = mWifiManager.getConnectionInfo();

            int ipAddress = wifiInfo == null ? 0 : wifiInfo.getIpAddress();
            if (mWifiManager.isWifiEnabled() && ipAddress != 0) {
                bReturn = true;
            }
        } catch (Exception e) {
        } finally {
            return bReturn;
        }
    }

    /**
     * 获取网络类型
     *
     * @return 网络类型
     */
    public static int getNetworkType() {
        if (mContext == null)
            return NET_UNKNOWN;

        int nReturn = NET_OFF;

        try {
            ConnectivityManager cm = (ConnectivityManager) mContext
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                int type = info.getType();
                int subType = info.getSubtype();
                if (type == ConnectivityManager.TYPE_WIFI) {
                    if (isWiFiActive()) {
                        nReturn = NET_WIFI;
                    }
                } else if (type == ConnectivityManager.TYPE_MOBILE) {
                    switch (subType) {
                        case TelephonyManager.NETWORK_TYPE_CDMA: // = 4 ~ 14-64 kbps
                        case TelephonyManager.NETWORK_TYPE_IDEN: // = 11 ~ 25 kbps
                        case TelephonyManager.NETWORK_TYPE_1xRTT: // = 7 2.5G或者
                            // 2.75G ~
                            // 50-100 kbps
                        case TelephonyManager.NETWORK_TYPE_GPRS: // = 1 2.5G ~ 171.2
                            // kbps
                        case TelephonyManager.NETWORK_TYPE_EDGE: // = 2 2.75G ~
                            // 384-473.6
                            // kbps
                            nReturn = NET_2G;
                            break;
                        case TelephonyManager.NETWORK_TYPE_EVDO_0: // = 5 ~ 400-1000
                            // kbps
                        case TelephonyManager.NETWORK_TYPE_UMTS: // = 3 ~ 400-7000
                            // kbps
                        case TelephonyManager.NETWORK_TYPE_EVDO_A: // = 6 ~ 600-1400
                            // kbps
                        case TelephonyManager.NETWORK_TYPE_HSPA: // = 10 3G ~
                            // 700-1700 kbps
                        case TelephonyManager.NETWORK_TYPE_EHRPD: // = 14 3.75g ~
                            // 1-2 Mbps
                        case TelephonyManager.NETWORK_TYPE_HSUPA: // = 9 ~ 1-23 Mbps
                        case TelephonyManager.NETWORK_TYPE_HSDPA: // = 8 ~ 2-14 Mbps
                        case TelephonyManager.NETWORK_TYPE_EVDO_B: // = 12 ~ 9 Mbps
                        case TelephonyManager.NETWORK_TYPE_HSPAP: // = 15 ~ 10-20
                            // Mbps
                            nReturn = NET_3G;
                            break;
                        case TelephonyManager.NETWORK_TYPE_LTE: // = 13 4G ~ 10+
                            // Mbps
                            nReturn = NET_4G;
                            break;
                        case TelephonyManager.NETWORK_TYPE_UNKNOWN:// = 0
                        default:
                            nReturn = NET_UNKNOWN;
                            break;
                    }
                } else {
                    nReturn = NET_UNKNOWN;
                }
            }
        } catch (NullPointerException e) {
            /**
             * java.lang.NullPointerException
             at android.os.Parcel.readException(Parcel.java:1431)
             at android.os.Parcel.readException(Parcel.java:1379)
             at android.net.IConnectivityManager$Stub$Proxy.getActiveNetworkInfo
             (IConnectivityManager.java:688)
             at android.net.ConnectivityManager.getActiveNetworkInfo(ConnectivityManager.java:460)
             at com.cleanmaster.kinfoc.ai.j(KInfocCommon.java:430)
             at com.cleanmaster.util.bt.b(DumpUploader.java:48)
             */
            nReturn = NET_EXCEPTION;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nReturn;
    }

    public static boolean isMiui() {

        String s = Build.DISPLAY;
        if (s != null) {
            if (s.toUpperCase().contains("MIUI")) {
                return true;
            }
        }

        s = Build.MODEL; // 小米
        if (s != null) {
            if (s.contains("MI-ONE")) {
                return true;
            }
        }

        s = Build.DEVICE;
        if (s != null) {
            if (s.contains("mione")) {
                return true;
            }
        }

        s = Build.MANUFACTURER;
        if (s != null) {
            if (s.equalsIgnoreCase("Xiaomi")) {
                return true;
            }
        }

        s = Build.PRODUCT;
        if (s != null) {
            if (s.contains("mione")) {
                return true;
            }
        }

        return false;
    }

    /**
     * 大于MiUI10的系统版本
     *
     * @return
     */
    public static boolean isMiui10() {
        if (isMiui()){
            String romVersion = getSpecificMobileRomVersion();
            if (!TextUtils.isEmpty(romVersion)) {
                String[] versions = romVersion.split(" ");
                if (versions.length <= 0) {
                    return false;
                }

                try {
                    String versionHead = versions[0]; //V10
                    String versionNum = versionHead.substring(1,versionHead.length());

                    int versionInt = Integer.valueOf(versionNum);
                    if (versionInt >= 10){
                        return true;
                    }
                } catch (Exception e){
                }
            }
        }
        return false;
    }

    /**
     * 针对小米 miui10 以上的手机 判断是否需要跳转设置页面进行设默，
     * true 需要跳转设置页面
     * false 不需要跳转设置页面，可直接在当前页面弹出ResolverActivity
     * @return
     */
    public static boolean isGotoSettingSetDefaultForMiUI() {
        if (isMiui10()) {
            //Android 8.1系统不需要跳转设默
            if (Build.VERSION.SDK_INT == 27) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean isMeiZu() {
        String manufacture = Build.MANUFACTURER;
        return manufacture != null && manufacture.toLowerCase().contains("meizu");
    }

    public static boolean isAboveOppoOS(float versionCode) {
        try {
            String versionInfo = SystemProperties.get("ro.build.version.opporom", "");
            if (true) {
                Log.e(TAG, "oppo " + Build.VERSION.SDK_INT + " " + (TextUtils.isEmpty(versionInfo) ?
                        "not oppo " : versionInfo));
            }
            String[] split = versionInfo.split("V");
            String versionCodeStr = split[(split.length - 1)];
            try {
                float versionCodeValue = 0;
                if (!TextUtils.isEmpty(versionCodeStr)) {
                    if (versionCodeStr.length() >= 3) {
                        versionCodeValue = Float.parseFloat(versionCodeStr.substring(0, 3));
                    } else {
                        versionCodeValue = Float.parseFloat(versionCodeStr.substring(0,
                                versionCodeStr.length()));
                    }
                }
                if (versionCodeValue >= versionCode) {
                    return true;
                }
            } catch (NumberFormatException numberFormatException) {}
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isSpecialOppoColor3OS() {
        try {
            String value = SystemProperties.get("ro.build.version.opporom", "");
            if (TextUtils.isEmpty(value)) {
                return false;
            }
            String[] splits = value.split("V");
            if (splits.length == 1) {
                return false;
            }
            String version = splits[(splits.length - 1)];
            try {
                float versionF = Float.parseFloat(version.substring(0, 3));
                if (versionF >= 3.0F) {
                    return true;
                }
            } catch (NumberFormatException numberFormatException) {}
            return false;
        } catch (Exception e) {
            return false;
        }
    }


    public static boolean isSamsung() {
        return Build.MANUFACTURER != null && Build.MANUFACTURER.toLowerCase().contains("samsung");
    }

    public static boolean isGoogle() {
        if (Build.BRAND == null) {
            return false;
        }

        String lower = Build.BRAND.toLowerCase();
        return lower.contains("google") || lower.contains("android");
    }

    // Identity of motorola razr and atrix, these model may have black wallpaper issue
    // @gaomiao 20150526
    public static boolean isMotorolaRazr() {
        if (Build.BRAND == null || Build.MODEL == null) {
            return false;
        }

        if (Build.BRAND.equalsIgnoreCase("motorola")) {
            String modelLower = Build.MODEL.toLowerCase();
            if (modelLower.contains("razr") || modelLower.contains("atrix")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHuaWei() {
        if (Build.BRAND == null) {
            return false;
        }
       // Log.e("qlqlql","brand:"+Build.BRAND.toLowerCase());
        return Build.BRAND.toLowerCase().contains("huawei") ;
    }

    public static boolean isHonor(){
        if (Build.BRAND == null) {
            return false;
        }
       // Log.e("qlqlql","brand:"+Build.BRAND.toLowerCase());
        return Build.BRAND.toLowerCase().contains("honor") ;
    }

    public static boolean isLargeLollipop() {
        return Build.VERSION.SDK_INT > 20;
    }

    public static boolean isSpecialLetv() {
        return (Build.MANUFACTURER.toLowerCase().equals("letv") || "LeMobile".equals(Build.MANUFACTURER)) && isLargeLollipop();
    }

    /**
     * Vivo是否需要打开Launcher限制开关
     *
     * @return
     */
    public static boolean isVivoOpenDskSwitch(Context context) {
        if (isVivoMobileForOpenDskSwitch()) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    setLastChosenActivity(context);
                } catch (Exception e) {}

            }
            if (!"android".equals(getPhoneLauncherPackageName(context))) {
                return true;
            }
        }
        return false;
    }

    public static String getPhoneLauncherPackageName(Context context) {
        Intent localIntent = new Intent("android.intent.action.MAIN");
        localIntent.addCategory("android.intent.category.HOME");
        String packageName = context.getPackageManager().resolveActivity(localIntent, 65536).activityInfo.packageName;
        return packageName;
    }

    private static void setLastChosenActivity(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setComponent(null);
            intent.setFlags(0xFF7FFFFF & intent.getFlags());
            AppGlobals.getPackageManager().setLastChosenActivity(intent, intent.resolveTypeIfNeeded(context.getContentResolver()), PackageManager.MATCH_DEFAULT_ONLY, null, 0, null);
        } catch (Exception e) {}
    }


    public static boolean isVivoMobileForOpenDskSwitch() {
        return isVivo() && Build.VERSION.SDK_INT >= 21;
    }

    public static boolean isVivo() {
        return "vivo".equals(Build.BRAND.toLowerCase());
    }

    public static boolean isAboveVivoOS(float versionCode) {
        try {
            String versionInfo = SystemProperties.get("ro.vivo.rom", "");
            if (true) {
                Log.e(TAG, "vivo " + Build.VERSION.SDK_INT + " " + (TextUtils.isEmpty(versionInfo) ? "not vivo " : versionInfo));
            }
            if (TextUtils.isEmpty(versionInfo)) {
                return false;
            }
            String[] split = versionInfo.split("_");
            String versionCodeStr = split[(split.length - 1)];
            try {
                float versionCodeValue = 0;
                if (!TextUtils.isEmpty(versionCodeStr)) {
                    if (versionCodeStr.length() >= 3) {
                        versionCodeValue = Float.parseFloat(versionCodeStr.substring(0, 3));
                    } else {
                        versionCodeValue = Float.parseFloat(versionCodeStr.substring(0,
                                versionCodeStr.length()));
                    }
                }
                if (versionCodeValue >= versionCode) {
                    return true;
                }
            } catch (NumberFormatException numberFormatException) {}
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    public static boolean isLollipopEnterSettingHome() {
        String str = Build.MANUFACTURER.toLowerCase();
        if (true) {
            Log.e(TAG, Build.VERSION.SDK_INT + " " + str);
        }
        if ("yulong".equals(str) || "coolpad".equals(str) || "lemobile".equals(str) || "letv".equals(str)) {
            return true;
        }
        String display = Build.DISPLAY;
        if (display != null && display.contains("amigo")){
            return true;
        }
        return false;
    }

    public static boolean isSpecialYunosFlyme() {
        if ("Meizu".equals(Build.MANUFACTURER)) {
            String[] split = Build.DISPLAY.split(" ");
            try {
                String trim = split[1].trim();
                int i = Integer.parseInt(trim.substring(0, 1));
                int j = Integer.parseInt(trim.substring(2, 3));
                if ((i >= 5) && (j >= 3)) {
                   return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static boolean isZUK() {
        return "zuk".equals(Build.MANUFACTURER.toLowerCase());
    }

    public static boolean isHuaWeiTabooModel() {
        if (!isHuaWei()) {
            return false;
        }

        if (Build.MODEL == null) {
            return false;
        }

        String model = Build.MODEL.toLowerCase();
        return model.contains("y600-u20");
    }


    public static boolean isEmuiOtherSettings(Context context) {
        if (context == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$PreferredListSettingsActivity");
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean shouldBypassOnHuawei() {
        if (!isHuaWei() || Build.PRODUCT == null) {
            return false;
        }

        String productID = Build.PRODUCT.toUpperCase();
        Log.e("klklkl","pid:"+productID+",:"+ SystemProperties.get("ro.product.model",""));
        // 如果大部分主型号（例如MT7-）都需要bypass,则用主型号替换所有具体型号.
        // 等名单变长了就考虑其他方法.
        String[] tabooProductPrefixId = {"MT7-", "G6-", "G7-", "H60", "PE-TL00", "P6-T00",
                "T1-701", "Y635",
                "CHC-U03", "G750-", "NXT-", "ALE-", "G620S-",
                // 新加入
                "MYA-","EVA-","WAS-","PRA-","NMO-","TRT-","VNS-",
                "DIG-","BGO-","VKY-","CAM-","CAN-","MHA-","G735",
                "CRR-","GEM-", "PE-", "KOB-","Y530","Y321","AGS-",
                "GRA-","P7-",
                // 新加入
                "T1-", "RIO-","VTR-","BLL-"};
        String[] tabooProductId = {"G7"};
        for (String tabooID : tabooProductPrefixId) {
            if (productID.contains(tabooID)) {
                return true;
            }
        }

        for (String tabooID : tabooProductId) {
            if (productID.equals(tabooID)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isLG_G3() {
        return "LGE".equalsIgnoreCase(Build.MANUFACTURER) &&
                Build.PRODUCT.startsWith("g3");

    }

    public static boolean isLG() {
        return "LGE".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isOPPO() {
        if (Build.BRAND == null) {
            return false;
        }

        return Build.BRAND.toLowerCase().contains("oppo");
    }

    public final static String getSpecificMobileRomVersion() {
        if (sSpecialMobileRom != null) {
            return sSpecialMobileRom;
        }
        try {
            sSpecialMobileRom = "";
            if (isSamsung() || isLG() || isMeiZu() || isGionee() || isMicromax() || isHtc() ||
                    isCoolpad() || isLenovo() || isSony() || isOneplus() || isAsus() || isZTE()
                    || isMotorola()) {
                sSpecialMobileRom = SystemProperties.get("ro.build.display.id", "");
            }
            if (isHuaWei() || isHonor()) {
                sSpecialMobileRom = SystemProperties.get("ro.build.version.emui", "");
            }
            if (isXiaoMi()) {
                sSpecialMobileRom = SystemProperties.get("ro.miui.ui.version.name", "") + " " +
                        SystemProperties.get("ro.build.version.incremental", "");
            }
            if (isVivo()) {
                sSpecialMobileRom = SystemProperties.get("ro.vivo.os.build.display.id", "");
                if (TextUtils.isEmpty(sSpecialMobileRom)) {
                    sSpecialMobileRom = SystemProperties.get("ro.vivo.os.name", "") + " " +
                            SystemProperties.get("ro.vivo.rom.version", "");
                }
            }
            if (isOPPO()) {
                sSpecialMobileRom = SystemProperties.get("ro.build.version.opporom", "");
            }
            if (isSpecialLetv()) {
                sSpecialMobileRom = SystemProperties.get("ro.letv.release.version", "");
            }
            if (isNubia()) {
                sSpecialMobileRom = SystemProperties.get("ro.build.nubia.rom.name", "") + " " +
                        SystemProperties.get("ro.build.nubia.rom.code", "") + " " +
                        SystemProperties.get("ro.build.rom.id", "");
            }
            if (isSmart()) {
                sSpecialMobileRom = SystemProperties.get("ro.smartisan.version", "");
            }
        } catch (Exception e) {

        }
        return sSpecialMobileRom;
    }

    private static boolean isMotorola() {
        return "motorola".equals(Build.BRAND.toLowerCase());
    }

    public static boolean isZTE() {
        return "zte".equals(Build.BRAND.toLowerCase());
    }

    public static boolean isAsus() {
        return "asus".equals(Build.BRAND.toLowerCase());
    }

    private static boolean isOneplus() {
        return "oneplus".equals(Build.BRAND.toLowerCase());
    }

    public static boolean isSony() {
        return "sony".equals(Build.BRAND.toLowerCase());
    }

    public static boolean isSecureCameraAvailable() {
        return !isSony() && !isSamsungJ7();// && !isHuaWeiMate7();
    }

    private static boolean isHuaWeiMate7() {
        return isHuaWei() && "MT7-TL10".equalsIgnoreCase(Build.BOARD);
    }

    private static boolean isSamsungJ7() {
        String model = Build.MODEL;
        return (model != null) && model.equals("SM-J700H");
    }

    private static boolean isLenovo() {
        return "lenovo".equals(Build.BRAND.toLowerCase());
    }

    private static boolean isCoolpad() {
        return "qiku".equals(Build.BRAND.toLowerCase()) || "coolpad".equals(Build.BRAND
                .toLowerCase());
    }

    public static boolean isHtc() {
        return "htc".equals(Build.BRAND.toLowerCase());
    }

    private static boolean isMicromax() {
        return "micromax".equals(Build.BRAND.toLowerCase());
    }

    public static boolean isGionee() {
        return "GiONEE".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isXiaoMi() {
        return Build.BRAND.toLowerCase().equals("xiaomi");
    }

    public static boolean isNubia() {
        return "nubia".equals(Build.MANUFACTURER.toLowerCase());
    }

    public static boolean isSmart() {
        return "smartisan".equals(Build.MANUFACTURER.toLowerCase());
    }

    public static boolean isLgDisplayIsKOT49I() {
        return Build.DISPLAY.toLowerCase().contains("kot49i");
    }

    public static boolean isCyanogenMod() {
        String display = Build.DISPLAY;
        if (!TextUtils.isEmpty(display) && display.startsWith("cm_pisces")) {
            return true;
        }
        return false;
    }


    public static boolean isVivoNoAccessibility() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN_MR1 && "vivo"
                .equalsIgnoreCase(Build.BRAND)) {
            return true;
        }
        return false;
    }

    /**
     * AndroidId的指定index位置字符是否包含在aids里面
     */
    public static boolean isAidHit(int index, String allowedXaid) {
        if (TextUtils.isEmpty(allowedXaid)) {
            return false;
        }
        final String aid = DeviceInfoUtils.getAndroidID();
        if (TextUtils.isEmpty(aid)) {
            return false;
        }
        if (aid.length() > index && index > 0) {
            final String substring = aid.substring(index - 1, index);
            if (!TextUtils.isEmpty(substring)) {
                if (allowedXaid.contains(substring.toLowerCase()) || allowedXaid.contains
                        (substring.toUpperCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * this will force to get MCC_MNC
     * @param context
     */
    public synchronized static void initMCCMNC(Context context) {

        final TelephonyManager tm = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
        String mcc_mnc = tm.getSimOperator();
        if (!TextUtils.isEmpty(mcc_mnc)) {
            mMccMnc = mcc_mnc;
            Log.d(TAG, "MCC_NCC Value: " + mMccMnc);
        }
    }
    public synchronized static String getMCC(Context context) {
        if (context == null) {
            return null;
        }
        // if has not get available mcc value, try to get it
        if(TextUtils.isEmpty(mMccMnc) || mMccMnc.length() < 3){
            initMCCMNC(context);
        }

        if(!TextUtils.isEmpty(mMccMnc) && mMccMnc.length() >= 3) {
           String mcc = mMccMnc.substring(0, 3);
           Log.d(TAG, "Cached MCC : " + mcc);
           return mcc;
        }
        return null;
    }

    public synchronized static String getMNC(Context context) {
        if(context == null) {
            return null;
        }

        // if has not get available ncc value, try to get it
        if(TextUtils.isEmpty(mMccMnc) || mMccMnc.length() < 5){
            initMCCMNC(context);
        }

        if(!TextUtils.isEmpty(mMccMnc) && mMccMnc.length() >= 5) {
            String mnc = mMccMnc.substring(3, 5);
            Log.d(TAG, "Cached MNC : " + mnc);
            return mnc;
        }
        return null;
    }

    /**
     * 是否是欧盟手机号 或者 设置地区是否是欧盟国家
     *
     * @return 返回true 是欧盟手机
     */
    public static boolean isEuropeUnionPhone(Context context) {
        String mcc = getMCC(context);
        if ("232".equals(mcc) || // 奥地利
                "206".equals(mcc) || // 比利时
                "284".equals(mcc) || // 保加利亚
                "280".equals(mcc) || // 塞浦路斯
                "219".equals(mcc) || // 克罗地亚
                "230".equals(mcc) || // 捷克
                "238".equals(mcc) || // 丹麦
                "288".equals(mcc) || // 丹麦 法罗群岛
                "290".equals(mcc) || // 丹麦 格陵兰
                "248".equals(mcc) || // 爱沙尼亚
                "244".equals(mcc) || // 芬兰
                "208".equals(mcc) || // 法国
                "308".equals(mcc) || // 法属 圣皮埃尔和密克隆
                "340".equals(mcc) || // 法属 安的列斯群岛340
                "742".equals(mcc) || // 法国 安的列斯群岛742
                "543".equals(mcc) || // 法属 瓦利斯和富图纳
                "546".equals(mcc) || // 法属 新喀里多尼亚
                "547".equals(mcc) || // 法属 波利尼西亚
                "647".equals(mcc) || // 法属 印度洋领土
                "262".equals(mcc) || // 德国
                "202".equals(mcc) || // 希腊
                "216".equals(mcc) || // 匈牙利
                "272".equals(mcc) || // 爱尔兰
                "222".equals(mcc) || // 意大利
                "247".equals(mcc) || // 拉脱维亚
                "246".equals(mcc) || // 立陶宛
                "270".equals(mcc) || // 卢森堡
                "278".equals(mcc) || // 马耳他
                "204".equals(mcc) || // 荷兰
                "260".equals(mcc) || // 波兰
                "268".equals(mcc) || // 葡萄牙
                "226".equals(mcc) || // 罗马尼亚
                "231".equals(mcc) || // 斯洛伐克
                "293".equals(mcc) || // 斯洛文尼亚
                "214".equals(mcc) || // 西班牙
                "240".equals(mcc) || // 瑞典
                "234".equals(mcc) || // 英国234
                "235".equals(mcc) || // 英国235
                "266".equals(mcc) || // 英属 直布罗陀
                "346".equals(mcc) || // 英属 开曼群岛
                "348".equals(mcc) || // 英属 维尔京群岛
                "350".equals(mcc) || // 英属 直布罗陀
                "354".equals(mcc) || // 英属 蒙特塞拉特
                "376".equals(mcc) || // 英属 特克斯和凯科斯群岛
                "273".equals(mcc) || // 冰岛
                "295".equals(mcc) || // 英属 列支敦士登
                "242".equals(mcc) || // 挪威
                "750".equals(mcc)) { // 英属 福克兰群岛
            return true;
        }
        return false;
    }
}
