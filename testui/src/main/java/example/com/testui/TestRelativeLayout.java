/**
 *
 */

package example.com.testui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

/**
 * Created by chengjian ����11:11:52
 */
public class TestRelativeLayout extends RelativeLayout {
    private static final String TAG = "Touch_TestRelative";
    /**
     * @param context
     * @param attrs
     */
    public TestRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver
                .OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
//                Log.d(TAG, "onGlobalLayout: w=" + getWidth() + " h=" + getHeight() + " this=" +
//                        getViewTreeObserver());
            }
        });
        // LayoutInflater factory = LayoutInflater.from(context);
        // RelativeLayout relativeLayout = (RelativeLayout) factory.inflate(
        // R.layout.ad_view_merge, this, true);
        // // ViewGroup viewGroup = (ViewGroup) inflate(context,
        // R.layout.ad_view,
        // // this);
        // ImageView imageView = new ImageView(context);
        // imageView.setId(11111);
        // imageView.setScaleType(ScaleType.FIT_XY);
        // imageView.setImageResource(R.drawable.a);
        // RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
        // LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        // relativeLayout.addView(imageView, 0, params);
        // relativeLayout.setBackgroundColor(Color.RED);
        // addView(relativeLayout);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasWindowFocus);
//        Log.d(TAG, "onWindowFocusChanged hasWindowFocus=" + hasWindowFocus);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        // TODO Auto-generated method stub
        super.onWindowVisibilityChanged(visibility);
//        Log.d(TAG, "onWindowVisibilityChanged visibility=" + visibility);
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
//        Log.d(TAG, "onVisibilityChanged visibility=" + visibility + "  changedView=" +
// changedView);
    }

    @Override
    public void onHoverChanged(boolean hovered) {
        super.onHoverChanged(hovered);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "TestRelativeLayout onTouchEvent action=" + event.getAction());
        boolean handle = super.onTouchEvent(event);
        Log.d(TAG, "TestRelativeLayout onTouchEvent  handle=" +
                handle);
        if (MotionEvent.ACTION_UP == event.getAction()) {
//            setScaleX((float) 3.0);
//            setScaleY((float) 3.0);
//            setVisibility(VISIBLE);
        } else {
//            addView(new TextView(getContext()));
//            setVisibility(GONE);
//            setScaleX((float) 3.0);
//            setScaleY((float) 3.0);
        }
        return handle;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "TestRelativeLayout dispatchTouchEvent action=" + ev.getAction());
        boolean handle = super.dispatchTouchEvent(ev);
        Log.d(TAG, "TestRelativeLayout dispatchTouchEvent handle=" + handle);
        return handle;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "TestRelativeLayout onInterceptTouchEvent action=" + ev.getAction());
        boolean handle = false;
//        boolean handle = ev.getAction() == MotionEvent.ACTION_UP;
        Log.d(TAG, "TestRelativeLayout onInterceptTouchEvent handle = " + handle);
        return handle;
    }

    @Override
    public void onViewRemoved(View child) {
        super.onViewRemoved(child);
        Log.d(TAG, "onViewRemoved: child=" + child);
    }
}
