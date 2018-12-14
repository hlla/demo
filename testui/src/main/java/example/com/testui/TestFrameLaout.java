package example.com.testui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by chengjian on 18-9-11.
 */

public class TestFrameLaout extends FrameLayout {
    private static final String TAG = "Touch_TestFrame";

//    @Override
//    protected void onAttachedToWindow() {
//        super.onAttachedToWindow();
////        this.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
////                View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//    }

    public TestFrameLaout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    protected boolean fitSystemWindows(Rect insets) {
//        Log.d(TAG, "fitSystemWindows: insets=" + insets);
//        return super.fitSystemWindows(insets);
//    }
}
