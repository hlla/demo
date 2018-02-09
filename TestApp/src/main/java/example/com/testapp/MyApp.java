package example.com.testapp;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Intent;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by chengjian on 18-2-7.
 */

public class MyApp extends Application {
    private static MyApp sMyApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sMyApp = this;
    }

    public static void hookInstrumentation() throws Exception {
        Class<?> activityThread = Class.forName("android.app.ActivityThread");
        Method currentActivityThread = activityThread.getDeclaredMethod("currentActivityThread");
        currentActivityThread.setAccessible(true);
        //获取主线程对象
        Object activityThreadObject = currentActivityThread.invoke(null);

        //获取Instrumentation字段
        Field mInstrumentation = activityThread.getDeclaredField("mInstrumentation");
        mInstrumentation.setAccessible(true);
        Instrumentation instrumentation = (Instrumentation) mInstrumentation.get
                (activityThreadObject);
        CustomInstrumentation customInstrumentation = new CustomInstrumentation(instrumentation);
        //替换掉原来的,就是把系统的instrumentation替换为自己的Instrumentation对象
        mInstrumentation.set(activityThreadObject, customInstrumentation);
        Log.d("[app]", "Hook Instrumentation成功");

    }

    private static MyApp getInstance() {
        return sMyApp;
    }

    public static class CustomInstrumentation extends Instrumentation {
        private Instrumentation base;

        public CustomInstrumentation(Instrumentation base) {
            this.base = base;
        }

        private void getLoaderApk() throws NoSuchFieldException, IllegalAccessException,
                ClassNotFoundException {
            MyApp myApplication = MyApp.getInstance();
            Field mLoadedApk = myApplication.getClass().getSuperclass().getDeclaredField
                    ("mLoadedApk");
            mLoadedApk.setAccessible(true);
            Object mLoadedApkObject = mLoadedApk.get(myApplication);
            Log.d("[app]", "获取的mLoadedApkObject=" + mLoadedApkObject);
        }

        //重写创建Activity的方法
        @Override
        public Activity newActivity(ClassLoader cl, String className, Intent intent) throws
                InstantiationException, IllegalAccessException, ClassNotFoundException {
            Log.d("[app]", "哈哈，你被Hook了");
            try {
                getLoaderApk();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            Log.d("[app]", "className=" + className + " intent=" + intent);
            return super.newActivity(cl, className, intent);
        }
    }
}
