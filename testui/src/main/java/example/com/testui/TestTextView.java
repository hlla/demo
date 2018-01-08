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
import android.widget.TextView;

public class TestTextView extends TextView {
    private static final String TAG = "Touch_TestTextView111";

    /**
     * @param context
     * @param attrs
     */
    public TestTextView(Context context, AttributeSet attrs) {
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
//        Log.d(TAG, "onVisibilityChanged visibility=" + visibility + "  changedView=" + changedView);
    }

    @Override
    public void onHoverChanged(boolean hovered) {
        super.onHoverChanged(hovered);
    }

    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        boolean handle = super.onTouchEvent(event);
//        if (MotionEvent.ACTION_UP == event.getAction()) {
////            setScaleX((float) 3.0);
////            setScaleY((float) 3.0);
//            setVisibility(VISIBLE);
//        } else {
//            setVisibility(GONE);
////            setScaleX((float) 3.0);
////            setScaleY((float) 3.0);
//        }
////        invalidate();
        Log.d(TAG, "TestTextView onTouchEvent action=" + event.getAction() + " handle=" + handle);
        return handle;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean handle = super.dispatchTouchEvent(ev);
        Log.d(TAG, "TestTextView dispatchTouchEvent action=" + ev.getAction() + " handle=" +
                handle);
        return handle;
    }

}
