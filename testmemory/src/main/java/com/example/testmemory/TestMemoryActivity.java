package com.example.testmemory;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemProperties;
import android.os.Trace;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.leakcanary.RefWatcher;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//import android.support.v7.app.AppCompatActivity;

public class TestMemoryActivity extends Activity {
    private final static int DARK_COLOR_ALPHA = 230;
    private final static int DARK_COLOR_RED = 50;
    private final static int DARK_COLOR_GREEN = 50;
    private final static int DARK_COLOR_BLUE = 50;
    private final static float DARK_COLOR_MIN_RATE = 0.2f;
    private static final String TAG = "TestMemoryActivity";
    private static ArrayList<Bitmap> sBitmaps = new ArrayList<>();
    //    private static ArrayList<AppCompatActivity> sActivities = new ArrayList<>();
    private static ImageView sImageView;
    //    @BindView(R.id.test_webview)
    Button testWebview;
    @BindView(R.id.test_drawable)
    Button testDrawable;
    @BindView(R.id.test_file)
    Button testFile;
    @BindView(R.id.test_image)
    MyImageView testImage;
    @BindView(R.id.test_smooth)
    Button testSmooth;
    @BindView(R.id.view)
    View view;
    private Bitmap bmp;
    private Bitmap bmp1;
    private Button dd;

    static int add(int a, int b) {
        int sum = a;

	/*直到进位的结果为0*/
        while (b != 0) {
            sum = a ^ b; /*不考虑进位的和*/
            b = (a & b) << 1; /*只考虑进位的产生值*/
            a = sum;
        }//while
        return sum;
    }

    /**
     * 分析Bitmap的平均色及纯黑像素所点的比例
     *
     * @param bitmap 需要分析的图片
     * @return float[3] result[0] is average color [0..0xffffffff], result[1] is black color rate
     * [0.. 1],
     * result[3] is main color of the whole bitmap
     */
    public static Bitmap getAverageColorInfoForBitmap(Bitmap bitmap) {
        Log.d(TAG, "getAverageColorInfoForBitmap: start width=" + bitmap.getWidth() + " height="
                + bitmap.getHeight());
        int redValue = 0;
        int greenValue = 0;
        int blueValue = 0;

        int rate = bitmap.getWidth() / 60;
        rate = rate == 0 ? 1 : rate;
        int newW = Math.max(bitmap.getWidth() / rate, 0);
        int newH = Math.max(bitmap.getHeight() / rate, 0);
        Log.d(TAG, "getAverageColorInfoForBitmap: newW=" + newW + " newH=" + newH);
        Bitmap tmpBitmap = null;
        try {
            tmpBitmap = (rate == 1 ? bitmap : Bitmap.createScaledBitmap(bitmap, newW, newH, false));
        } catch (OutOfMemoryError e) {
        }
        int index = 0;
        int blackCount = 0;
        int[] colorMapPixels = new int[newW * newH];
        tmpBitmap.getPixels(colorMapPixels, 0, newW, 0, 0, newW, newH);
        int length = newW * newH;
        while (index < length) {
            int color = colorMapPixels[index];
            int alpha = Color.alpha(color);
            int red = Color.red(color);
            int green = Color.green(color);
            int blue = Color.blue(color);
            redValue += red;
            greenValue += green;
            blueValue += blue;
//                redValue += add(red, redValue);
//                total = totalRed;
//                greenValue += add(green, greenValue);
//                blueValue += add(blueValue, blueValue);
            if (alpha > DARK_COLOR_ALPHA && red < DARK_COLOR_RED && green < DARK_COLOR_GREEN
                    && blue < DARK_COLOR_BLUE) {
                blackCount++;
            }
            index += 3;
        }
//        for (int y = 0; y < length; y++) {
//            for (int x = 0; x < newW; x++) {
//                int color = colorMapPixels[index];
//                int alpha = Color.alpha(color);
//                int red = Color.red(color);
//                int green = Color.green(color);
//                int blue = Color.blue(color);
//                redValue += red;
//                greenValue += green;
//                blueValue += blue;
////                redValue += add(red, redValue);
////                total = totalRed;
////                greenValue += add(green, greenValue);
////                blueValue += add(blueValue, blueValue);
//                if (alpha > DARK_COLOR_ALPHA && red < DARK_COLOR_RED && green < DARK_COLOR_GREEN
//                        && blue < DARK_COLOR_BLUE) {
//                    blackCount++;
//                }
//                index++;
//            }
//        }
//        if (tmpBitmap != bitmap) {
//            tmpBitmap.recycle();
//        }
        Log.d(TAG, "getAverageColorInfoForBitmap: end");
        return tmpBitmap;
    }

    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    ReentrantLock reentrantLock = new ReentrantLock(false);

    @OnClick(R.id.test_drawable)
    public void onTestDrawableClicked() {
        TestBean bean = new TestBean();
        File file = new File(getFilesDir(), "/test.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread s = new Thread() {
            @Override
            public void run() {
                Log.d(TAG, "1111111111");
                readWriteLock.readLock().lock();
//                reentrantLock.lock();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                reentrantLock.unlock();
                readWriteLock.readLock().unlock();
                Log.d(TAG, "2222222222");
                Log.d(TAG, "2222222222");
                Log.d(TAG, "2222222222");
                Log.d(TAG, "2222222222");
                Log.d(TAG, "2222222222");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                readWriteLock.writeLock().lock();
//                reentrantLock.lock();
                Log.d(TAG, "333333");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "444444");
                readWriteLock.writeLock().unlock();
//                reentrantLock.unlock();
//                readWriteLock.readLock().lock();
            }
        };
        s.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
//                        Log.d(TAG, "run: 111111");
//                        sleep(20000);
//                        Log.d(TAG, "run: 22222");
//                        ArrayList<String> strings = new ArrayList<>();
//                        for (int i = 0; i < 500000; i++) {
//                            strings.add(i + "fghfdhfhfhgfhghhhgdhgf");
//                        }
//                        Log.d(TAG, "run: 33333");
//                        sleep(20000);
//                        Log.d(TAG, "run: 444444");
                    } catch (Exception e) {

                    }
                }

//                Log.d(TAG, "5555");
//                readWriteLock.writeLock().lock();
////                reentrantLock.lock();
//                Log.d(TAG, "6666");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Log.d(TAG, "777777");
//                readWriteLock.writeLock().unlock();
//                reentrantLock.unlock();
            }
        }.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s.interrupt();
        Drawable drawable = getDrawable(R.drawable.biggest_1);
        showDialog(this, drawable);
        InputStream is1 = null;
        try {
            is1 = getResources().getAssets().open("wb.jpg");
            is1 = new FileInputStream(new File(Environment.getExternalStorageDirectory() + "/" +
                    "wb.jpg"));

            Log.d(TAG, "is1" + is1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ALPHA_8;
        options.outWidth = 100;
        options.outHeight = 100;
        options.inDensity = 1;
        options.inTargetDensity = 1;
        bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.a,
                options);
        testImage.setImageBitmap(bmp1);
        Log.d(TAG, "onTestDrawableClicked: height=" + options.outHeight + " width=" + options
                .outWidth + " byte=" +
                bmp1.getByteCount() + " type=" + options.outMimeType);
        bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.cheetcare_type_phone,
                options);
        testImage.setImageBitmap(bmp1);
        Log.d(TAG, "onTestDrawableClicked: height=" + options.outHeight + " width=" + options
                .outWidth + " byte=" +
                bmp1.getByteCount() + " type=" + options.outMimeType);
        bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.cheetcare_default_cheetah,
                options);
        testImage.setImageBitmap(bmp1);
        Log.d(TAG, "onTestDrawableClicked: height=" + options.outHeight + " width=" + options
                .outWidth + " byte=" +
                bmp1.getByteCount() + " type=" + options.outMimeType);
        bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.cheetah_pet_tip_cheetah,
                options);
        testImage.setImageBitmap(bmp1);
        Log.d(TAG, "onTestDrawableClicked: cheetah_pet_tip_cheetah height=" + options.outHeight +
                " width=" + options
                .outWidth + " byte=" +
                bmp1.getByteCount() + " type=" + options.outMimeType);
        bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.t,
                options);
        testImage.setImageBitmap(bmp1);
        Log.d(TAG, "onTestDrawableClicked: t height=" + options.outHeight + " width=" + options
                .outWidth + " byte=" +
                bmp1.getByteCount() + " type=" + options.outMimeType);
        bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.a22,
                options);
        testImage.setImageBitmap(bmp1);
        Log.d(TAG, "onTestDrawableClicked: a22 height=" + options.outHeight + " width=" + options
                .outWidth + " byte=" +
                bmp1.getByteCount() + " type=" + options.outMimeType);
        bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.cheetah_life_tips,
                options);
        testImage.setImageBitmap(bmp1);
        Log.d(TAG, "onTestDrawableClicked: cheetah_life_tips height=" + options.outHeight + " " +
                "width=" + options
                .outWidth + " byte=" +
                bmp1.getByteCount() + " type=" + options.outMimeType);
        bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.cheetcare_type_app,
                options);
        testImage.setImageBitmap(bmp1);
        Log.d(TAG, "onTestDrawableClicked: cheetcare_type_app height=" + options.outHeight + " " +
                "width=" + options
                .outWidth + " byte=" +
                bmp1.getByteCount() + " type=" + options.outMimeType);
        bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher,
                options);
        testImage.setImageBitmap(bmp1);
        Log.d(TAG, "onTestDrawableClicked: ic_launcher height=" + options.outHeight + " " +
                "width=" + options
                .outWidth + " byte=" +
                bmp1.getByteCount() + " type=" + options.outMimeType);
        sBitmaps.add(bmp1);
    }

    @OnClick(R.id.test_file)
    public void onTestFileClicked() {
    }

    @OnClick(R.id.test_image)
    public void onTestImageClicked() {
    }

    @OnClick(R.id.test_smooth)
    public void onTestSmoothClicked() {
    }

    @OnClick(R.id.view)
    public void onViewClicked() {
    }

    public class A {
        //        int a;
        byte b;
//        double c;
//        double e;
//        Integer d;
    }

    private ArrayList<A> mAArrayList = new ArrayList<>();
    private A[] ints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Trace.beginSection("testmemory");
        Log.d(TAG, "onCreate: start");
        setContentView(R.layout.activity_test_memory);
        ButterKnife.bind(this);
        Button button = (Button) findViewById(R.id.button1);
        String path = Environment.getExternalStorageDirectory().getPath();
        File file = new File(path, "CMLauncher");
        Log.d(TAG, "onCreate: file=" + file.getPath() + " exist=" + file.exists() + " list" + file
                .list());
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        getWindow().setBackgroundDrawable(null);
        final int num = SystemProperties.getInt("debug.test.num", 1500000);
        TestHandler testHandler = new TestHandler();
        Thread thread = new MyThread();
        thread.start();
//        new Thread() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
//        ints = new A[num];
//        testWebview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final int num = SystemProperties.getInt("debug.test.num", 1500000);
//                ints = new A[1500000];
//                for (int i = 0; i < num; i++) {
//                    A a = new A();
////                    mAArrayList.add(a);
//                    ints[i] = a;
//                }
////                Intent intent = new Intent(TestMemoryActivity.this, TestWebViewActivity.class);
////                startActivity(intent);
////                clearPreloadedDrawables();
////                BitmapFactory.Options options1 = new BitmapFactory.Options();
////                options1.inPreferredConfig = Bitmap.Config.RGB_565;
////                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wb,
////                        options1);
////                Log.d(TAG, "onClick: options1=" + options1.outMimeType);
////                testImage.setImageBitmap(bitmap);
////                bitmap.recycle();
////                testWebview.setBackground(new BitmapDrawable(getAverageColorInfoForBitmap
//// (bitmap)));
//            }
//        });
//        new Thread() {
//            @Override
//            public void run() {
//                dd = null;
//            }
//        }.start();
        Log.d(TAG, "onCreate: this=" + this + " dd=" + dd);
//        ButterKnife.bind(this);
        sImageView = new ImageView(this);
        Log.d(TAG, "onCreate: sImageView=" + sImageView);
//        sActivities.add(this);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
//        options.inPurgeable = true;//允许可清除
//        options.inInputShareable = true;// 以上options的两个属性必须联合使用才会有效果
//        options.inDensity = 210;
//        options.inTargetDensity = 240;
//        options.inJustDecodeBounds = true;
//        InputStream is = null;
//        try {
//            is = getResources().getAssets().open("ic_launcher.jpeg");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Log.d(TAG, "onCreate is=" + is);
//        bmp = BitmapFactory.decodeStream(is, null, options);
//        options.inScaled = false;
//        options.inSampleSize = 2;
//        options.outWidth = 80;
//        options.outHeight = 90;
//        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.wb, options);
//        Log.d(TAG, "onCreate: byteCount=" + bmp.getByteCount() / 1024 + " allocate=" + bmp
//                .getAllocationByteCount() / 1024 + " height=" + bmp.getHeight() + "  width=" + bmp
//                .getWidth() + " options.outHeight=" + options
//                .outHeight + " onfig=" + options.inPreferredConfig + " dd=" + bmp.getConfig());
//////
//        BitmapFactory.Options options1 = new BitmapFactory.Options();
//        options1.inPreferredConfig = Bitmap.Config.RGB_565;
//        options1.outHeight = 640;
//        options1.outWidth = 360;
//        options1.inSampleSize = 7;
//        options1.inBitmap = bmp;
//        options1.inMutable = true;
////        options1.inPreferredConfig = Bitmap.Config.RGB_565;
////        options1.inPurgeable = true;//允许可清除
////        options1.inInputShareable = true;// 以上options的两个属性必须联合使用才会有效果
//        InputStream is1 = null;
////        options1.inDensity = 120;
//        options1.inDensity = 210;
//        options1.inTargetDensity = 480;
//        options1.inTargetDensity = 480;
//        InputStream is1 = null;
//        try {
//            is1 = getResources().getAssets().open("wb.jpg");
////            is1 = new FileInputStream(new File(Environment.getExternalStorageDirectory() + "/" +
////                    "wb.jpg"));
//
//            Log.d(TAG, "is1" + is1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        bmp1 = BitmapFactory.decodeStream(is1, null, options1);
//        setWallpaper(bmp1);
//        bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.wb, options1);
////        Log.d(TAG, "onCreate bmp1=" + bmp1);
//        Log.d(TAG, "onCreate1111: byteCount=" + bmp1.getByteCount() / 1024 + " allocate=" + bmp1
//                .getAllocationByteCount() / 1024 + " height=" + bmp1.getHeight() + "  width=" +
//                bmp1.getWidth() + " options=" + options1
//                .outHeight + " config=" + options1.inPreferredConfig + " dd=" + bmp1.getConfig()
//                + " inTargetDensity=" + options1.inTargetDensity + " inDensity=" +
//                options1.inDensity);
//        sBitmaps.add(bmp);
//        sBitmaps.add(bmp1);
//        clearPreloadedDrawables();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        bmp1.compress(Bitmap.CompressFormat.JPEG, 100, out);
//        Log.d(TAG, "onCreate: size1=" + out.size() / 1024 + " out=" + out.toByteArray()[out.size
//                () - 1]);
//        bmp1.compress(Bitmap.CompressFormat.PNG, 100, out);
//        Log.d(TAG, "onCreate: size2=" + out.size() / 1024);
//        bmp1.compress(Bitmap.CompressFormat.WEBP, 100, out);
//        Log.d(TAG, "onCreate: size3=" + out.size() / 1024);
        Trace.endSection();
    }

    public void setWallpaper(Bitmap bitmap) {
//        int screenWidth = DimenUtils.getScreenRealWidth(context);
//        int screenHeight = DimenUtils.getScreenRealHeight(context);

        Bitmap bm = null;
        ByteArrayOutputStreamWrapper out = null;
        ByteArrayOutputStreamWrapper out1 = null;
        ByteArrayOutputStreamWrapper out2 = null;
        ByteArrayOutputStreamWrapper out3 = null;
        ByteArrayInputStream in = null;
        boolean isSucc = false;
        int bmWidth = bitmap.getWidth();
        int bmHeight = bitmap.getHeight();
//        int scaledWidth = screenWidth * (singleScreen ? 1 : 2);
//        int scaledHeight = screenHeight;
//        //Log.e("asasass","bmWidth:"+bmWidth+",bmHeight:"+bmHeight+",
// scaledWidth:"+scaledWidth+",scaledHeight:"+scaledHeight);
//        try {
//            if (bmWidth != scaledWidth || bmHeight != scaledHeight) {
//                bm = BitmapUtil.getSquareBitmap(bitmap, scaledWidth, scaledHeight);
//            }
//        } catch (Throwable e) {
//
//        }

        if (bm == null) {
            bm = bitmap;
        }

        try {
            out = new ByteArrayOutputStreamWrapper();
            bm.compress(Bitmap.CompressFormat.PNG, 100, out);
            Log.d(TAG, "out.size()=" + out.size());
//            out1 = new ByteArrayOutputStreamWrapper();
//            bm.compress(Bitmap.CompressFormat.JPEG, 100, out1);
//            Log.d(TAG, "out1.size()=" + out1.size());
//            out2 = new ByteArrayOutputStreamWrapper();
//            bm.compress(Bitmap.CompressFormat.PNG, 100, out2);
//            Log.d(TAG, "out2.size()=" + out2.size());
//            out3 = new ByteArrayOutputStreamWrapper();
//            bm.compress(Bitmap.CompressFormat.WEBP, 100, out3);
//            Log.d(TAG, "out3.size()=" + out3.size());
//            in = new ByteArrayInputStream(out.getBuffer(), 0, out.size());
            isSucc = true;
        } catch (Throwable e) {
            Log.d(TAG, "setWallpaper e=" + e);

        } finally {
//            if (in != null) {
//                try {
//                    in.close();
//                    in = null;
//                } catch (Exception e) {
//
//                }
//            }
//
            if (out != null) {
                try {
                    out.close();
                    out = null;
                } catch (Exception e) {

                }
            }
        }

    }

    MyDialog mDialog;

    void showDialog(Context context, Drawable drawable) {
        mDialog = new MyDialog(context);
        TextView textView = new TextView(this);
        textView.setBackground(drawable);
        mDialog.setTitle("showDialog");
        mDialog.setContentView(textView);
        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

            @Override
            public void onDismiss(DialogInterface dialog) {
                Log.d("chengjian", "onDismiss: ");
            }
        });
        mDialog.show();
    }

    class MyDialog extends Dialog {
        public MyDialog(Context context) {
            super(context);
        }

        @Override
        protected void onStop() {
            Log.d("chengjian", "onStop: ");
        }

        @Override
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            Log.d("chengjian", "onDetachedFromWindow: ");
        }
    }


    static class MyMsg {
        public TestHandler target11;

        MyMsg() {
        }
    }

    static class MyMsgQueue {
        public MyMsg next;

        MyMsgQueue() {
            next = new MyMsg();
        }

        public MyMsg getNext() {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return next;
        }

        ;
    }

    static class MyLooper {
        public static MyLooper sMyLooper = new MyLooper();
        MyMsgQueue mMyMsgQueue = null;

        MyLooper() {
            mMyMsgQueue = new MyMsgQueue();
        }

        public static void loop() {
            final MyMsgQueue queue = MyLooper.sMyLooper.mMyMsgQueue;
            MyMsg myMsg = queue.getNext();
            Log.d(TAG, "run: myMsg=" + myMsg);
        }
    }

    class TestHandler {
        TestHandler() {
            MyLooper.sMyLooper.mMyMsgQueue.next.target11 = this;
        }
    }

    static class MyThread extends Thread {
//        private TestMemoryActivity mTestMemoryActivity;
//
//        MyThread(TestMemoryActivity activity) {
//            mTestMemoryActivity = activity;
//        }

        @Override
        public void run() {
//            while (true) {
            try {
                MyLooper.loop();
//                final MyMsgQueue queue = MyLooper.sMyLooper.mMyMsgQueue;
//                MyMsg myMsg = queue.next;
//                Log.d(TAG, "run: myMsg=" + myMsg);
//                sleep(203000);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            }
        }
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }

    private Handler mHandler = new MyHandler();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.sendEmptyMessageDelayed(0, 6000);
//        clearPreloadedDrawables();
//        bmp.recycle();
//        bmp1.recycle();
        RefWatcher refWatcher = MyApplication.getRefWatcher(this);
        refWatcher.watch(sBitmaps);
    }

    //    @OnClick(R.id.test_webview)
//    public void onViewClicked() {
//        Intent intent = new Intent(this, TestWebViewActivity.class);
//        startActivity(intent);
//
//    }
    Drawable.ConstantState createDrawableConstant() {
        Drawable drawable = getDrawable(R.drawable.wb);
        Log.d(TAG, "drawable =" + drawable);
        return drawable.getConstantState();
    }

    int[] aa;
    String[] bb;

    private void clearPreloadedDrawables() {
        try {
            Field mFieldPreloadedDrawables = Resources.class.getDeclaredField
                    ("sPreloadedDrawables");
            if (mFieldPreloadedDrawables != null) {
                mFieldPreloadedDrawables.setAccessible(true);

                boolean access = mFieldPreloadedDrawables.isAccessible();
                if (!access) {
                    mFieldPreloadedDrawables.setAccessible(true);
                }

                if (Build.VERSION.SDK_INT <= 17) {
                    LongSparseArray<Drawable.ConstantState> dArray = (LongSparseArray<Drawable
                            .ConstantState>) mFieldPreloadedDrawables.get(getResources());
//                    if (dArray != null) {
//                        dArray.clear();
//                    }

                    // dArray.put(1, createDrawableConstant());
                } else if (Build.VERSION.SDK_INT >= 18) {
                    LongSparseArray<Drawable.ConstantState>[] dArray = (LongSparseArray<Drawable
                            .ConstantState>[]) mFieldPreloadedDrawables.get(getResources());
                    if (dArray != null) {
                        for (int i = 0; i < dArray.length; i++) {
                            if (dArray[i] != null) {
//                                aa = new int[4000000];
//                                bb = new String[4000000];
//                                for (int b = 0; b < aa.length; b++) {
//                                    aa[b] = b;
//                                }
//                                Log.d(TAG, "aa=" + aa);
//                                dArray[i].clear();
                                dArray[i].put(1000000, createDrawableConstant());
                            }
                        }
                    }
                }

                mFieldPreloadedDrawables.setAccessible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
