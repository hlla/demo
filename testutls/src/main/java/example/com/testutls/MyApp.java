package example.com.testutls;

import android.app.Application;
import android.content.Context;

/**
 * Created by chengjian on 17-11-8.
 */

public class MyApp extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
