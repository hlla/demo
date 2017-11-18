package example.com.testutls;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.lang.reflect.Field;

public class SplashActivity extends Activity {
    private static final String TAG = "TestUtil_SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        launchLauncher();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    private void launchLauncher() {
        Intent localIntent = new Intent();
        localIntent.setClass(this, TestUtilActivity.class);

        try {
            localIntent.setPackage(getPackageName());
            startActivity(localIntent);
        } catch (Exception localException) {
            localIntent.setComponent(new ComponentName(getApplicationContext(),
                    TestUtilActivity.class));
            startActivity(localIntent);
        } finally {
            fixInputMethodManagerLeak(this);
//            finish();
        }
    }

    /**
     * 解决InputMethodManager中的view hold了context问题，将IM中View置为空来解决
     *
     * @param activity
     */
    public static void fixInputMethodManagerLeak(Activity activity) {
        if (activity == null) return;

        @SuppressLint("WrongConstant")
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context
                .INPUT_METHOD_SERVICE);
        if (imm == null) return;

        String[] arr = new String[]{"mCurRootView", "mServedView", "mNextServedView",
                "mLastSrvView"};//lastSrvView for huawei
        Field f;
        Object objMember;
        for (String param : arr) {
            try {
                f = imm.getClass().getDeclaredField(param);
                if (!f.isAccessible()) {
                    f.setAccessible(true);
                }
                objMember = f.get(imm);
                if (objMember != null && objMember instanceof View) {
                    View view = (View) objMember;
                    if (view.getContext() == activity) {
                        // 被InputMethodManager持有引用的context是想要目标销毁的
                        f.set(imm, null); // 置空，破坏掉path to gc节点
                    } else {
                        // 不是想要目标销毁的，即为又进了另一层界面了，不要处理，避免影响原逻辑,也就不用继续for循环了
                        break;
                    }
                }
            } catch (Throwable ignored) {
            }
        }
    }
}