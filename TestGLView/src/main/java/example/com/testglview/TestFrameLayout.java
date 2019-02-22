package example.com.testchengjianview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

/**
 * Created by chengjian on 18-9-14.
 */

public class TestFrameLayout extends FrameLayout {
    private static final String TAG = "chengjianviewddd_test";

    public TestFrameLayout(Context context) {
        super(context);
        Log.d(TAG, "TestFrameLayout 1: this=" + this);
    }

    public TestFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.PagedView, 0, 0);
        int mPageLayoutPaddingTop = a.getDimensionPixelSize(
                R.styleable.PagedView_pageLayoutPaddingTop, 0);
        int mPageLayoutPaddingBottom = a.getDimensionPixelSize(
                R.styleable.PagedView_pageLayoutPaddingBottom, 0);
        int mPageLayoutPaddingLeft = a.getDimensionPixelSize(
                R.styleable.PagedView_pageLayoutPaddingLeft, 0);
        int mPageLayoutPaddingRight = a.getDimensionPixelSize(
                R.styleable.PagedView_pageLayoutPaddingRight, 0);
        int mPageLayoutWidthGap = a.getDimensionPixelSize(
                R.styleable.PagedView_pageLayoutWidthGap, 0);
        int mPageLayoutHeightGap = a.getDimensionPixelSize(
                R.styleable.PagedView_pageLayoutHeightGap, 0);
        int mPageIndicatorViewId = a.getResourceId(R.styleable.PagedView_pageIndicator, -1);
        a.recycle();
        Log.d(TAG, "TestFrameLayout 2: this=" + this + " mPageIndicatorViewId=" +
                mPageIndicatorViewId);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "onLayout 2: this=" + this);
    }
}
