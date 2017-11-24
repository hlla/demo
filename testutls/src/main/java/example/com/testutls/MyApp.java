package example.com.testutls;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.webkit.WebSettings;

/**
 * Created by chengjian on 17-11-8.
 */

public class MyApp extends Application {
    private static final String TAG = "TestUtil_MyApp";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Exception exception = new Exception("attachBaseContext()");
        SharedPreferences sharedPreferences = getSharedPreferences("sfsdsfsd", MODE_PRIVATE);
        sharedPreferences.edit().apply();
        Log.d(TAG, "attachBaseContext: start", exception);
//        TestUtilActivity.changeWarningLimit();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Log.d(TAG, "attachBaseContext: end");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Exception exception = new Exception("onCreate()");
        Log.d(TAG, "onCreate: start", exception);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Log.d(TAG, "onCreate: end");
//        try {
//        MyApp myApp = null;
//        myApp.onCreate();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            Log.d(TAG, "onCreate: throwable：" + throwable);
//        }
        Log.d(TAG, "onCreate: start");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        final WebView webView = new WebView(MyApp.this);
        Log.d(TAG, "onCreate: 11111");
//        WebSettings webSettings = webView.getSettings();
        String ua = WebSettings.getDefaultUserAgent(MyApp.this);
        Log.d(TAG, "onCreate: 22222 ua=" + ua);
//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                Log.d(TAG, "onCreate: 11");
//                String ua = WebSettings.getDefaultUserAgent(MyApp
//                        .this);
//                Log.d(TAG, "onCreate: 22 ua" + ua);
//            }
//        }.start();
        Log.d(TAG, "onCreate: end");
    }
}
