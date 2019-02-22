
package example.com.testchengjianview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;

public class SmartDialog extends Dialog {
    private static final String TAG = "chengjianview_SmartDialog";
    private final static int INVALID_TYPE = -1;
    private View mView;
    private int mWidth;
    private int mHeight;
    protected static float sWidthRatio = 0.9f;
    protected static float sBsWidthRatio = 1.0f; //bottom style
    protected int mType;

    class OnDismissListenerWrapper implements OnDismissListener {
        private OnDismissListener onDismissListener = null;

        OnDismissListenerWrapper(OnDismissListener onDismissListener) {
            this.onDismissListener = onDismissListener;
        }

        @Override
        public void onDismiss(DialogInterface dialog) {
        }
    }

    public SmartDialog(Context context) {
        this(context, R.style.SmartDialogStyle, 0);
    }

    public SmartDialog(Context context, int type) {
        this(context, R.style.SmartDialogStyle, type);
    }

    public SmartDialog(Context context, int themeResId, int type) {
        super(context, themeResId);
        mType = type;
        // 设置对话框背景透明度
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        updateDialogBg(lp);
        getWindow().setAttributes(lp);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams
//                .MATCH_PARENT);
    }

    /**
     * default 0.6
     */
    public void updateDialogBg(WindowManager.LayoutParams lp) {
        lp.dimAmount = 0.6f;
    }


    public FrameLayout addMaskView(View view) {
        FrameLayout rootView = new FrameLayout(getContext());

        rootView.setLayoutParams(new FrameLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));

        rootView.addView(view, getContentLayoutParams());
        return rootView;
    }

    public FrameLayout.LayoutParams getContentLayoutParams() {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        return params;
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = LayoutInflater.from(getContext())
                .inflate(layoutResID, null);
        this.setContentView(view);
    }

    @Override
    public void setContentView(View view) {
        mView = view;
        FrameLayout rootLayout = addMaskView(view);
//        view.measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        mWidth = view.getMeasuredWidth();
//        mHeight = view.getMeasuredHeight();
        super.setContentView(rootLayout);
//        rootLayout.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
//                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View
//                        .SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
//            rootLayout.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
//                @Override
//                public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
//                    Exception exception = new Exception("onApplyWindowInsets");
//                    Log.e(TAG, "onApplyWindowInsets: insets=" + insets);
////                mLauncherView.setPadding(insets.getSystemWindowInsetLeft(), insets
////                        .getSystemWindowInsetTop(), insets.getSystemWindowInsetRight(), insets
////                        .getSystemWindowInsetBottom());
////                mRootView.setBackgroundColor(Color.TRANSPARENT);
//                    return insets;
//                }
//            });
//        }
        rootLayout.setBackgroundColor(Color.GRAY);
    }

    protected void setMargin(FrameLayout.LayoutParams mParams, int m, DisplayMetrics dm) {
        if (mParams != null && dm != null) {
            mParams.setMargins(-(m - dm.widthPixels) / 2, -(m - dm.heightPixels) / 2, 0, 0);
        }
    }


    public void setContentView(View view, Boolean isApkPreInstall) {
        mView = view;
        if (isApkPreInstall) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.dimAmount = 0.0f;
            getWindow().setAttributes(lp);

            final Resources resources = getContext().getResources();
            final DisplayMetrics dm = resources.getDisplayMetrics();

            int m = (int) Math.round(Math
                    .sqrt(dm.widthPixels * dm.widthPixels + dm.heightPixels * dm.heightPixels));
            FrameLayout.LayoutParams mParams = new FrameLayout.LayoutParams(
                    m, m);
            setMargin(mParams, m, dm);
            //mParams.setMargins(-(m - dm.widthPixels) / 2, -(m - dm.heightPixels) / 2,0 , 0);
            mWidth = m;
            mHeight = m;

            super.setContentView(view, mParams);
        } else {
            FrameLayout rootLayout = addMaskView(view);
            view.measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            mWidth = view.getMeasuredWidth();
            mHeight = view.getMeasuredHeight();
            super.setContentView(rootLayout);
        }
    }

    public View getContentView() {
        return mView;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }


    public boolean showSucceed() {
        try {
            super.show();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void setOnDismissListener(final OnDismissListener listener) {
        OnDismissListenerWrapper dismissListenerWrapper = new OnDismissListenerWrapper
                (listener);
        super.setOnDismissListener(dismissListenerWrapper);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
        } finally {
        }
    }
}
