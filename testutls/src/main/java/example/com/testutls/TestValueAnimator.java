package example.com.testutls;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;

/**
 * Created by chengjian on 17-12-2.
 */

public class TestValueAnimator extends Activity {
    private View mBlueBall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout_animation);
        mBlueBall = findViewById(R.id.id_ball);
        mBlueBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestValueAnimator.this.verticalRun(v);
            }
        });
        getMCC(this);
    }

    public static String getMCC(Context context) {
        if (context == null)
            return null;
        final TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String mcc_mnc = tm.getSimOperator();
        StringBuilder mcc = null;
        if (null != mcc_mnc && mcc_mnc.length() >= 3) {
            mcc = new StringBuilder();
            mcc.append(mcc_mnc, 0, 3);
            return mcc.toString();
        }
        return null;
    }

    /**
     * 自由落体
     *
     * @param view
     */
    public void verticalRun(View view) {
        ValueAnimator animator = ValueAnimator.ofFloat(0, 1700
                - mBlueBall.getHeight());
        animator.setTarget(mBlueBall);
        animator.setDuration(3000).start();
//		animator.setInterpolator(value)
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float percent = (Float) animation.getAnimatedValue();
                Log.d("chengjian_11", "onAnimationUpdate: " + percent + " ct=" + animation
                        .getCurrentPlayTime());
                mBlueBall.setTranslationY((Float) animation.getAnimatedValue());
            }

        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Log.d("chengjian_11", "onAnimationEnd");
            }
        });

    }
}