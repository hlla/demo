package letv.com.testanr;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoadingActivity extends Activity {
    private static final String TAG = "Testanr_LoadingActivity";
    public static final String SP_FILE_NAME = "sp_name";
    public static final String KEY_FINISH = "finish";
    @BindView(R.id.loading)
    Button loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        ButterKnife.bind(this);
        int tagerSdkVersion = getApplicationInfo().targetSdkVersion;
        Log.d(TAG, "onCreate:   tagerSdkVersion=" + tagerSdkVersion);
//        try {
//            Thread.currentThread().sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(115000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SharedPreferences dd = getSharedPreferences(SP_FILE_NAME, Context
                        .MODE_PRIVATE);
                dd.edit().putString(KEY_FINISH, "1").commit();
                finish();
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        Log.d(TAG, "onBackPressed: ");
//        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @OnClick(R.id.loading)
    public void onViewClicked() {
        Log.d(TAG, "onViewClicked: ");
    }
}
