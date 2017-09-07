
package com.example.testservice;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.example.testaidlservice.R;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

public class oTestSerivceActivity extends Activity implements TestCj, TextureView
        .SurfaceTextureListener {
    private static final String TAG = "TestSerivceActivity";
    private static ImageView sImageView;
    private static ArrayList<String> sArrayList = new ArrayList<String>();
    private LinearLayout mLinearLayout;
    private TextureView mTextureView;
    private VideoView mVideoView;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "handleMessage 111");
        }
    };

    public static void testActivity() {
        Log.d("dd", "testActivity");
    }

    private static void testActivity11() {
        Log.d("dd", "testActivity11");
    }

    @Override
    public void setCount(int a) {
        Log.d("dd", "setCount");
    }

    public static int getOperator(Context context) {
        try {
            TelephonyManager tManager = (TelephonyManager) context.getSystemService(Context
                    .TELEPHONY_SERVICE);
            Log.d(TAG, "getOperator tManager=" + tManager);
            if (null != tManager) {
                String imsi = tManager.getSubscriberId();
                Log.d(TAG, "getOperator imsi=" + imsi);

            }
        } catch (Throwable e) {
            e.printStackTrace();
            Log.d(TAG, "getOperator e=" + e);
        }
        return 11;
    }

    public void startService(View view) {
        File file = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        mTextureView = new TextureView(this);
        mTextureView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams
                .MATCH_PARENT, LinearLayout
                .LayoutParams.MATCH_PARENT));
        mTextureView.setSurfaceTextureListener(this);
        mLinearLayout.addView(mTextureView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout
                .LayoutParams.MATCH_PARENT);
        Log.d(TAG, "startService 111111");
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setStartOffset(4000);
//        alphaAnimation.setFillAfter(true);
        alphaAnimation.setFillBefore(true);
        mTextureView.startAnimation(alphaAnimation);
//        mLinearLayout.setVisibility(View.GONE);
        if (null != file) {
            Log.d(TAG, "startService file=" + file.getAbsolutePath());
        }
        final long time = System.currentTimeMillis();
//        try {
//            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + 13700000));
//            startActivity(intent);//内部类
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        TimeZone tz = TimeZone.getDefault();
//        String s = "TimeZone   " + tz.getDisplayName(false, TimeZone.SHORT) + " Timezon id :: " +
//                tz.getID();
//        Log.d(TAG, "onCreate s=" + s);
//        String ls = "TimeZone   " + tz.getDisplayName(false, TimeZone.LONG) + " Timezon id :: "
// + tz
//                .getID();
//        Log.d(TAG, "onCreate ls=" + ls);
//        String ts = "TimeZone   " + tz.getDisplayName(true, TimeZone.SHORT) + " Timezon id :: "
// + tz
//                .getID();
//        Log.d(TAG, "onCreate ts=" + ts);
        DeviceInfoUtils.getOperator();
        Log.d(TAG, "isFullScreen=" + DeviceInfoUtils.isFullScreen(this));
        Log.d(TAG, "getDensityDpi=" + DeviceInfoUtils.getDensityDpi());
        Log.d(TAG, "getUserAgent2=" + DeviceInfoUtils.getDefaultUserAgent());
        Log.d(TAG, "locale1=" + getResources().getConfiguration().locale.getCountry());
        Log.d(TAG, "locale2=" + Locale.getDefault().getCountry());
        Log.d(TAG, "locale3=" + Locale.getDefault().getISO3Country());
        Log.d(TAG, "Language=" + Locale.getDefault().getLanguage());
        Log.d(TAG, "locale4=" + Locale.getDefault());
        Log.d(TAG, "mac1=" + DeviceInfoUtils.getWirelessMacAddress(this));
        Log.d(TAG, "mac2=" + DeviceInfoUtils.getWiredMacAddress(this));
        Log.d(TAG, "wlan0=" + DeviceInfoUtils.getMacAddressForM("wlan0"));
        Log.d(TAG, "adid=" + DeviceInfoUtils.getAndroidId());
        Log.d(TAG, "11111=" + DeviceInfoUtils.isProxyNet(this));
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int widthPixels = dm.widthPixels;
        int heightPixels = dm.heightPixels;
        Log.d(TAG, "widthPixels =" + widthPixels + "  heightPixels=" + heightPixels);
        int screenWidth = getScreenWidth(this);
        int screenHeight = getScreenHeight(this);
        Log.d(TAG, " screenWidth=" + screenWidth + "  screenHeight=" + screenHeight);
//        mHandler.sendEmptyMessage(0);
//        while (true) {
////            if ((System.currentTimeMillis() - time) > 30000) {
////                break;
////            }
//        }
    }

    public void startVideo(View view) {
        mVideoView = new VideoView(this);
        mVideoView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams
                .MATCH_PARENT, LinearLayout
                .LayoutParams.MATCH_PARENT));
        mVideoView.setVideoPath("http://g3.letv" +
                ".com/vod/v1/MjQ2LzI2Lzk0L2xldHYtZ3VnLzE3L3Zlcl8wMF8yMi0xMDY5MDg0MjM5LW" +
                "F2Yy0yNTAzNTUtYWFjLTMyMzY3LTMwMDAwLTExMDEwNDEtYjc3MjQzODg3NTM3MDk0YmI2N2UzYzA" +
                "wYTdlZDJlY2YtMTQ3NzAzODU2OTIwMC5tcDQ=?platid=100&splatid=10000" +
                "&gugtype=1&mmsid=" +
                "61574461&type=m_liuchang_mp4");
//                    mMediaPlayer.setOnBufferingUpdateListener(this);
//                    mMediaPlayer.setOnCompletionListener(this);
//                    mMediaPlayer.setOnPreparedListener(this);
//                    mMediaPlayer.setOnVideoSizeChangedListener(this);
        mLinearLayout.addView(mVideoView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout
                .LayoutParams.MATCH_PARENT);
//
        int numcore = getNumCores();
        int maxFreqKHz = getCPUMaxFreqKHz();
        Log.d(TAG, "startService numcore=" + numcore);
        Log.d(TAG, "startService maxFreqKHz=" + maxFreqKHz);
//        final int duration = 400;
//        final int colorFrom = Color.parseColor("#ff000000");
//        final int colorTo = Color.parseColor("#5f000000");
//        ColorDrawable[] color = {new ColorDrawable(colorFrom), new ColorDrawable(colorTo)};
//        TransitionDrawable transition = new TransitionDrawable(color);
//        mVideoView.setBackgroundDrawable(transition);
//        transition.startTransition(duration);

//        transition.startTransition(duration);
//        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.1f);
//        alphaAnimation.setDuration(8000);
//        alphaAnimation.setStartOffset(4000);
//        alphaAnimation.setFillAfter(true);
//        alphaAnimation.setFillBefore(true);
//        mLinearLayout.startAnimation(alphaAnimation);
        mVideoView.start();
//
    }
//        for (int i = 0; i < 100000; i++) {
//            String str = new String("aaaaaaaaaaa");
//            sArrayList.add(str);
//        }
//        try {
//            Field field = School.class.getField("CREATOR");
//            Object object = field.get(new School());
//            Log.d(TAG, "startService object=" + object + " object.getClass()=" + object
// .getClass());
//            Method[] methods = object.getClass().getDeclaredMethods();
//            for (Method method : methods) {
//                Log.d(TAG, "startService method=" + method);
//            }
//            Method method1 = object.getClass().getMethod("newArray", int.class);
//            method1.invoke(object, 10);
//            Log.d(TAG, "startService method1=" + method1);
//            Annotation[] annotations = method1.getAnnotations();
//            Log.d(TAG, "startService annotations=" + annotations.length);
//            for (Annotation annotation : annotations) {
//                Log.d(TAG, "startService annotation=" + annotation);
//            }
//        } catch (Exception e) {
//            Log.d(TAG, "startService e=" + e);
//        }
//        Method[] methodsss = TestSerivceActivity.class.getDeclaredMethods();
//        for (Method method : methodsss) {
//            Log.d(TAG, "startService11111 method=" + method);
//        }
//        Intent intent = new Intent(this, TestService.class);
//        School school = new School();
//        intent.putExtra("key", school);
//        startService(intent);

    //        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("market://details?id=" + "com.tencent.mobileqq"));
////        intent.setData(Uri.parse("market://details?id=" + "com.tencent.mobileqq"));
//        intent.setData(Uri.parse("market://search?q=letv"));
//        startActivity(intent);
    int screenWidth = getScreenWidth(this);
    int screenHeight = getScreenHeight(this);


//    Log.d(TAG,"startService screenWidth="+screenWidth+"  screenHeight="+screenHeight);

    /**
     * 得到屏幕高度
     */
    public static int getScreenWidth(Context context) {
        Point outPoint = new Point();
        try {
            if (null != context) {
                Display display = ((WindowManager) context.getSystemService(
                        Context.WINDOW_SERVICE)).getDefaultDisplay();
                display.getSize(outPoint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outPoint.x;
    }

    public static int getScreenHeight(Context context) {
        Point outPoint = new Point();
        try {
            if (null != context) {
                Display display = ((WindowManager) context.getSystemService(
                        Context.WINDOW_SERVICE)).getDefaultDisplay();
                display.getSize(outPoint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outPoint.y;

    }

    public static int getNumCores() {
        try {
            File e = new File("/sys/devices/system/cpu/");
            class CpuFilter implements FileFilter {
                CpuFilter() {
                }

                public boolean accept(File pathname) {
                    return Pattern.matches("cpu[0-9]", pathname.getName());
                }
            }

            File[] files = e.listFiles(new CpuFilter());
            return files.length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public static int getCPUMaxFreqKHz() {
        int cpuNum = getNumCores();
        int maxFreq = -1;
        try {
            for (int i = 0; i < cpuNum; i++) {
                String filename =
                        "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
                File cpuInfoMaxFreqFile = new File(filename);
                if (cpuInfoMaxFreqFile.exists()) {
                    byte[] buffer = new byte[128];
                    FileInputStream stream = new FileInputStream(cpuInfoMaxFreqFile);
                    try {
                        stream.read(buffer);
                        int endIndex = 0;
                        while (buffer[endIndex] >= '0' && buffer[endIndex] <= '9'
                                && endIndex < buffer.length) endIndex++;
                        String str = new String(buffer, 0, endIndex);
                        Integer freqBound = Integer.parseInt(str);
                        if (freqBound > maxFreq) maxFreq = freqBound;
                    } catch (NumberFormatException e) {
                        //Fall through and use /proc/cpuinfo.
                    } finally {
                        stream.close();
                    }
                }
            }
        } catch (IOException e) {
        }
        return maxFreq;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams
//                        .FLAG_HARDWARE_ACCELERATED);
        setContentView(R.layout.activity_main);
        DeviceInfoUtils.setContext(this);
        mLinearLayout = (LinearLayout) findViewById(R.id.test_linear);
//        int screenWidth = getScreenWidth(this);
//        int screenHeight = getScreenHeight(this);
//        Log.d(TAG, "onCreate screenWidth=" + screenWidth + "  screenHeight=" + screenHeight);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        Log.d(TAG, "onCreate width=" + width + "  height=" + height);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        float density = dm.density;      // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        float densityDPI = dm.densityDpi;     // 屏幕密度（每寸像素：120/160/240/320）
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;


        int screenWidthDip = dm.widthPixels;        // 屏幕宽（dip，如：320dip）
        int screenHeightDip = dm.heightPixels;      // 屏幕宽（dip，如：533dip）


        screenWidth = (int) (dm.widthPixels * density + 0.5f);      // 屏幕宽（px，如：480px）
        screenHeight = (int) (dm.heightPixels * density + 0.5f);     // 屏幕高（px，如：800px）

        Log.e(TAG, " screenWidth=" + screenWidth + "; screenHeight=" +
                screenHeight + " screenWidthDip=" + screenWidthDip + "  screenHeightDip=" +
                screenHeightDip + "  density=" + density);
//    Log.d(TAG,"startService screenWidth="+scre
//        ActivityManager activityManager = (ActivityManager) getSystemService(Context
//                .ACTIVITY_SERVICE);
//        Debug.MemoryInfo memoryInfo = activityManager.getProcessMemoryInfo(new
//                int[Process.myPid()])[0];
//        ActivityManager.MemoryInfo memoryInfo1 = new ActivityManager.MemoryInfo();
//        activityManager.getMemoryInfo(memoryInfo1);
//        sImageView = new ImageView(this);
//        Log.d(TAG, "onCreate sImageView=" + sImageView);
//        Log.d(TAG, "onCreate dalvikPss=" + memoryInfo.dalvikPss);
//        Log.d(TAG, "onCreate nativePss=" + memoryInfo.nativePss);
//        Log.d(TAG, "onCreate availMem=" + memoryInfo1.availMem);
//        Log.d(TAG, "onCreate totalMem=" + memoryInfo1.totalMem);
        final long time = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            new Thread() {
                @Override
                public void run() {
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    while (true) {
//                        if ((System.currentTimeMillis() - time) > 30000) {
//                            break;
//                        }
                    }
                }
            }.start();
        }
//        new TestSerivceActivity().setCount(10);
//        TestSerivceActivity.testActivity11();
//        String name = new School().getName();
    }

    private MediaPlayer mMediaPlayer;

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        Log.d(TAG, "onSurfaceTextureAvailable width=" + width + "  height=" + height);
        Surface s = new Surface(surface);
        try {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDataSource("http://g3.letv" +
                    ".com/vod/v1/MTYyLzM4Lzk0L2xldHYtZ3VnLzE3L3Zlcl8wMF8yMi0xMDExOTM2MDcwLWF2Yy0yNDc0MTAtYWFjLTMyNzQ5LTE1MDAwLTU0NjY3OC0yN2E4Zjk1ZmYzNTc3ODc3ZTQ5YWI0N2Q4ZmNmZjYxZC0xNDUwNDI0Mzg5NjY1Lm1wNA==?platid=100&splatid=10000&gugtype=1&mmsid=39582686&type=m_liuchang_mp4");
            mMediaPlayer.setSurface(s);
            mMediaPlayer.prepare();
//                    mMediaPlayer.setOnBufferingUpdateListener(this);
//                    mMediaPlayer.setOnCompletionListener(this);
//                    mMediaPlayer.setOnPreparedListener(this);
//                    mMediaPlayer.setOnVideoSizeChangedListener(this);
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.start();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        Log.d(TAG, "onSurfaceTextureSizeChanged width=" + width + "  height=" + height);
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        Log.d(TAG, "onSurfaceTextureDestroyed ");
        if (null != mMediaPlayer) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
        }
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        Log.d(TAG, "onSurfaceTextureUpdated ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        sArrayList.clear();
    }
}
