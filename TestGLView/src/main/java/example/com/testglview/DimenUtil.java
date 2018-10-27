package example.com.testglview;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class DimenUtil {

    private static DisplayMetrics sMetrics = new DisplayMetrics();


    public static void init(Context context) {
        sMetrics = context.getResources().getDisplayMetrics();
    }

    public static int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, sMetrics);
    }

    public static float dp2pxf(float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, sMetrics);
    }

    public static int sp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, sMetrics);
    }

    public static int px2dp(float value) {
        return (int) (value / sMetrics.density);
    }

    public static int px2sp(float value) {
        return (int) (value / sMetrics.scaledDensity);
    }

    public static DisplayMetrics getDisplayDeMetrics() {
        return sMetrics;
    }
}
