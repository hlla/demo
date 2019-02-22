package example.com.testcomponent;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Button;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OuterShellActivity extends FragmentActivity {
    private static final String TAG = "TestComponent1_Shell";
    @BindView(R.id.agree)
    Button agree;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outer_shell);
        ButterKnife.bind(this);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @OnClick(R.id.agree)
    public void onViewClicked() {
        LocalSocket localSocket = new LocalSocket();
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("abc", Context
                    .MODE_MULTI_PROCESS);
            sharedPreferences.edit().putBoolean("debug.agree", true).commit();
            localSocket.connect(new LocalSocketAddress(MyApplication.SOCK_NAME));
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "connect: e=" + e);
        }
        finish();
    }

    @Override
    public void reportFullyDrawn() {
        super.reportFullyDrawn();
        Log.d(TAG, "reportFullyDrawn: ");
    }
}
