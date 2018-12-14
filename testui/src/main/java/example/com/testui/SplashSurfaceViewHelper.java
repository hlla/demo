package example.com.testui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashSurfaceViewHelper {

    public interface OnClickListener {
        void onClick(boolean isConfirmTouch);
    }

    private Context context;
    private AlertDialog dialog;
    private OnClickListener clickListener;

    public SplashSurfaceViewHelper(Context context) {
        this.context = context;
    }

    public void setClickListener(OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void showEuropePlicyDialog() {
        if (dialog == null) {
            View europePolicyLayout = LayoutInflater.from(context)
                    .inflate(R.layout.splash_europe_policy, null);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                View topView = europePolicyLayout.findViewById(R.id.top_container);
                LinearLayout.LayoutParams topParams = (LinearLayout.LayoutParams) topView
                        .getLayoutParams();
                topParams.weight = 1;
                View bottomView = europePolicyLayout.findViewById(R.id.bottom_container);
                LinearLayout.LayoutParams bottomParams = (LinearLayout.LayoutParams) bottomView
                        .getLayoutParams();
                bottomParams.weight = 2;
            }
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            int deviceWidth = dm.widthPixels;
            int deviceHeight = dm.heightPixels;
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(deviceWidth, deviceHeight);
            europePolicyLayout.setLayoutParams(lp);
            initRecyclerView(europePolicyLayout);
            initAgreeView(europePolicyLayout);
            initDisAgreeView(europePolicyLayout);
            dialog = new AlertDialog.Builder(context, R.style.DialerSmartDialogStyle).create();
            dialog.setView(europePolicyLayout);
            dialog.show();
            dialog.setCanceledOnTouchOutside(false);
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {

                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                        return true;
                    }
                    return false;
                }
            });
            adjustDialogLayout(deviceWidth, deviceHeight);
        } else {
            if (!dialog.isShowing()) {
                dialog.show();
            }
        }
    }

    public void destroy() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
        this.clickListener = null;
    }

    private void adjustDialogLayout(int deviceWidth, int deviceHeight) {

        WindowManager.LayoutParams windowLayoutParams = dialog.getWindow().getAttributes();
        windowLayoutParams.width = deviceWidth;
        windowLayoutParams.height = deviceHeight;
        windowLayoutParams.gravity = Gravity.BOTTOM;
        dialog.getWindow().setAttributes(windowLayoutParams);
    }


    private void initRecyclerView(View europePolicyLayout) {

        final LinearLayout llSnaps = (LinearLayout) europePolicyLayout.findViewById(R.id.ll_snap);
        ViewPager recyclerView = (ViewPager) europePolicyLayout.findViewById(R.id.vp_europe_policy);
        new ProtocolUIController(context, recyclerView, llSnaps);
    }

    private void initAgreeView(View europePolicyLayout) {
        TextView agree = (TextView) europePolicyLayout.findViewById(R.id.btn_agree);
        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null) {
                    clickListener.onClick(true);
                }
            }
        });
    }

    private void initDisAgreeView(View europePolicyLayout) {
        TextView disAgree = (TextView) europePolicyLayout.findViewById(R.id.btn_disagree);
        disAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null) {
                    clickListener.onClick(false);
                }
            }
        });
    }
}
