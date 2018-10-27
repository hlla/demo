package example.com.testglview;


import android.util.ArrayMap;

import java.util.Map;

/**
 * Created by zhangwenjun@conew.com on 2016/6/4.
 *
 * @Note:一个大坑
 * 控制系统动态壁纸、CML动态壁纸、普通壁纸的透明度切换
 */
public class WallpaperTranslucent {

    public static boolean isTranslucent() {
        return sTranslucent;
    }

    public static void setTranslucent(boolean translucent) {
        WallpaperTranslucent.sTranslucent = translucent;
    }

    private static boolean sTranslucent;

    public enum WPType {
        WP_TYPE_NORMAL, /* 普通的静态壁纸 */
        WP_TYPE_CML_LP, /* CML自绘动态壁纸 */
        WP_TYPE_SY_LP, /* 系统的动态壁纸 */
    }

    private static Map<WPType, Boolean> mMap;

    public static boolean isTranslucentChange(WPType oldType, WPType newType) {
        initIfneeded();
        return mMap.get(oldType) ^ mMap.get(newType);
    }

    public static boolean isWallpaperTranslucent(WPType type) {
        initIfneeded();
        return mMap.get(type);
    }

    private static void initIfneeded() {
        if (mMap == null) {
            mMap = new ArrayMap<WPType, Boolean>(3);
            mMap.put(WPType.WP_TYPE_CML_LP, false);
            mMap.put(WPType.WP_TYPE_NORMAL, false);
            mMap.put(WPType.WP_TYPE_SY_LP, true);
        }
    }
}
