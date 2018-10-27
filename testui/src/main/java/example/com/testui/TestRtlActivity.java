package example.com.testui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

public class TestRtlActivity extends Activity {
    private static final String TAG = "Touch_TestRtlActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_rtl);
        Log.e(TAG, "onCreate: taskId=" + getTaskId());
    }
}
