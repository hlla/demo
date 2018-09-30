package example.com.testui;

import android.app.Application;

/**
 * Created by chengjian on 18-6-13.
 */

public class TestApp extends Application {
    private static TestApp sTestApp;

    public static TestApp getInstance() {
        return sTestApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sTestApp = this;
    }
}
