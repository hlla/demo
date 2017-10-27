package it.gmariotti.recyclerview.itemanimator.demo.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * Created by chengjian on 17-10-20.
 */

public class TestLinearLayout extends LinearLayout {
    private static final String TAG = "Recycler_LinearLayout";

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d(TAG, "finalize: ");
    }

    public TestLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Exception exception = new Exception("onAttachedToWindow");
        Log.d(TAG, "onDetachedFromWindow: tag=" + this.getTag() + " this=" + this, exception);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Exception exception = new Exception("onDetachedFromWindow");
        Log.d(TAG, "onDetachedFromWindow: tag=" + this.getTag() + " this=" + this, exception);
    }

}
