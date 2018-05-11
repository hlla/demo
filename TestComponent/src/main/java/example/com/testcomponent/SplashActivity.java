package example.com.testcomponent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("abc", 0);
        boolean isEuro = sharedPreferences.getBoolean("debug.test.euro", false);
        if (isEuro) {
            launchLauncher("example.com.testcomponent.MainAliasActivity");
        } else {
            launchLauncher("example.com.testcomponent.TestComponentActivity");
        }
        return;
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
}