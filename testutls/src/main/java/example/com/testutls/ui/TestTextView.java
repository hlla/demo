package example.com.testutls.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by chengjian on 17-11-10.
 */

public class TestTextView extends TextView {
    private static final String TAG = "TestUtil_TextView";

    public TestTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Exception exception = new Exception("onLayout");
        Log.d(TAG, "onLayout: changed=" + changed + " left=" + left + " top=" + top, exception);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Exception exception = new Exception("onMeasure");
        Log.d(TAG, "onMeasure: widthMeasureSpec=" + widthMeasureSpec + " heightMeasureSpec=" +
                heightMeasureSpec, exception);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Exception exception = new Exception("onDraw");
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Log.d(TAG, "onDraw:", exception);
    }
}
