package letv.com.testanr.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;

import java.util.List;

public class LetvUtils {
    private static int versionCode;
    private static String versionName;
    private static String ua;
    private static String countryCode;
    public static long mCurrentClickTime = 0;
    public static long mLastClickTime = 0;

    public static final String URL_FLAG = "http://m.letv.com/search/url?to=";
    public static final String URL_FLAG_NEW = "http://m.le.com/search/url?to=";
    public static final String WEB_INNER_FLAG = "letv.com";
    public static final String WEB_INNER_FLAG_NEW = "le.com";

    public static final long ONE_KB = 1024L;
    public static final long ONE_MB = ONE_KB * 1024L;
    public static final long ONE_GB = ONE_MB * 1024L;
    public static final long ONE_TB = ONE_GB * 1024L;


    /**
     * 国家、地区
     */
    public static final String COUNTRY_CHINA = "CN";            // 中国大陆
    public static final String COUNTRY_TAIWAN = "TW";           // 中国台湾
    public static final String COUNTRY_HONGKONG = "HK";         // 中国香港
    public static final String COUNTRY_UNITED_STATES = "US";    // 英语（美国）
    public static final String COUNTRY_UNITED_KINGDOM = "UK";    // 英语（英国）

    /**
     * 字符串资源请求URL接口的分隔符
     */
    public static final int INTERFACE_SEPERATOR_AND = 0x0;    // 以 & 字符分隔
    public static final int INTERFACE_SEPERATOR_BACKSLASH = 0x1;    // 以 / 字符分隔

    public static final String LANG_CHINA = "chs";
    public static final String LANG_TAIWAN = "cht";
    public static final String LANG_UK = "en";
    public static final String LANG_HONGKONG = LANG_TAIWAN;//"chh";
    public static final String LANG_USA = LANG_UK;

    public static final char CHARACTER_AND = '&';
    public static final char CHARACTER_BACKSLASH = '/';
    public static final char CHARACTER_EQUAL = '=';
    public static final String PARAM_LANG = "lang";

    public static final String COUNTRY_CODE_KEY = "region";

    private static final String LETV_BRAND_NAME = "Letv";
    private static final String LETV_BRAND_NAME_NEW = "LeEco";
    private static final String LE_BRAND_NAME = "Le";

    private static String sDevId = "";
    private static String sMacAddress = "";
    //地理位置信息
    private static String sLocationgMessage;
    private static String sAndLocationMessage; //以 & 字符分隔的位置信息
    private static String sBackslashLocationMessage; //以 / 字符分隔的位置信息
    private static final String CN_BELONG_AREA = "100";
    private static final String HK_BELONG_AREA = "101";
    private static final String US_BELONG_AREA = "102";

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /**
     * 获取进程名称
     *
     * @param cxt
     * @param pid
     * @return
     */
    public static String getProcessName(Context cxt, int pid) {
        ActivityManager am = (ActivityManager) cxt.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
            if (procInfo.pid == pid) {
                return procInfo.processName;
            }
        }
        return null;
    }


}
