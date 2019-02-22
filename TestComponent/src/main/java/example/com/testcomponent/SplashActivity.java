package example.com.testcomponent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends Activity {
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.query)
    Button query;
    @BindView(R.id.insert)
    Button insert;
    @BindView(R.id.update)
    Button update;
    @BindView(R.id.bindservice)
    Button bindservice;
    @BindView(R.id.unBindservice)
    Button unBindservice;
    @BindView(R.id.main_broadcast)
    Button mainBroadcast;
    @BindView(R.id.loading_broadcast)
    Button loadingBroadcast;
    @BindView(R.id.test_handler)
    Button testHandler;
    @BindView(R.id.test_alarm)
    Button testAlarm;
    @BindView(R.id.test_file_provider)
    Button testFileProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("abc", 0);
        boolean isEuro = sharedPreferences.getBoolean("debug.test.euro", false);
        if (isEuro) {
//            launchLauncher("example.com.testcomponent.MainAliasActivity");
//        } else {
            launchLauncher("example.com.testcomponent.TestComponentActivity");
        }
        setContentView(R.layout.test_component);
        ButterKnife.bind(this);
//        return;
    }

    private void launchLauncher(String name) {
        Intent localIntent = new Intent("android.intent.action.MAIN");
        localIntent.addCategory("android.intent.category.HOME");

//        localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        localIntent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
//        localIntent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
//        localIntent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        try {
            localIntent.setComponent(new ComponentName(getApplication(), name));
            startActivity(localIntent);
        } catch (Exception localException) {
            Log.d("TestComponent1_Activity", "launchLauncher: localException=" + localException);
        } finally {
//            finish();
        }
    }

    @OnClick(R.id.query)
    public void onViewClicked() {
        Intent intent = new Intent(this, TestComponentActivity.class);
        startActivity(intent);
    }
}