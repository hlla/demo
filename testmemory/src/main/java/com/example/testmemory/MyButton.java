package com.example.testmemory;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

/**
 * Created by chengjian on 17-10-31.
 */

public class MyButton extends Button {
    private static final String TAG = "Memory_MyButton";

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Exception exception = new Exception("onMeasure");
        Log.d(TAG, "onMeasure: ", exception);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Exception exception = new Exception("onLayout");
        Log.d(TAG, "onLayout: ", exception);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Exception exception = new Exception("onDraw");
        Log.d(TAG, "onDraw: ", exception);
    }
}
