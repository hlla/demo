package com.example.testmemory;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class TestMemoryActivity extends Activity {
    private final static int DARK_COLOR_ALPHA = 230;
    private final static int DARK_COLOR_RED = 50;
    private final static int DARK_COLOR_GREEN = 50;
    private final static int DARK_COLOR_BLUE = 50;
    private final static float DARK_COLOR_MIN_RATE = 0.2f;
    private static final String TAG = "TestMemoryActivity";
    private static ArrayList<Bitmap> sBitmaps = new ArrayList<>();
    private static ArrayList<Activity> sActivities = new ArrayList<>();
    private static ImageView sImageView;
    //    @BindView(R.id.test_webview)
    Button testWebview;
    ImageView testImage;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Trace.beginSection("testmemory");
        Log.d(TAG, "onCreate: start");
        setContentView(R.layout.activity_test_memory);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Log.d(TAG, "onCreate: end");
        getWindow().setBackgroundDrawable(null);
        testWebview = (Button) findViewById(R.id.test_webview);
        testImage = (ImageView) findViewById(R.id.test_image);
        testWebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(TestMemoryActivity.this, TestWebViewActivity.class);
//                startActivity(intent);
//                clearPreloadedDrawables();
                BitmapFactory.Options options1 = new BitmapFactory.Options();
                options1.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wb,
                        options1);
                Log.d(TAG, "onClick: options1=" + options1.outMimeType);
                testImage.setImageBitmap(bitmap);
//                bitmap.recycle();
//                testWebview.setBackground(new BitmapDrawable(getAverageColorInfoForBitmap
// (bitmap)));
            }
        });
//        new Thread() {
//            @Override
//            public void run() {
//                dd = null;
//            }
//        }.start();
        Log.d(TAG, "onCreate: this=" + this + " dd=" + dd);
//        ButterKnife.bind(this);
//        sImageView = new ImageView(this);
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
        options.inScaled = false;
        options.inSampleSize = 5;
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.wb, options);
        Log.d(TAG, "onCreate: byteCount=" + bmp.getByteCount() / 1024 + " allocate=" + bmp
                .getAllocationByteCount() / 1024 + " height=" + bmp.getHeight() + "  width=" + bmp
                .getWidth() + " options.outHeight=" + options
                .outHeight + " onfig=" + options.inPreferredConfig + " dd=" + bmp.getConfig());
//////
        BitmapFactory.Options options1 = new BitmapFactory.Options();
        options1.inPreferredConfig = Bitmap.Config.RGB_565;
        options1.inBitmap = bmp;
        options1.inMutable = true;
////        options1.inPreferredConfig = Bitmap.Config.RGB_565;
////        options1.inPurgeable = true;//允许可清除
////        options1.inInputShareable = true;// 以上options的两个属性必须联合使用才会有效果
//        InputStream is1 = null;
////        options1.inDensity = 120;
//        options1.inDensity = 210;
//        options1.inTargetDensity = 480;
//        options1.inTargetDensity = 480;
//        try {
////            is1 = getResources().getAssets().open("wb.jpg");
//            is1 = new FileInputStream(new File(Environment.getExternalStorageDirectory() + "/" +
//                    "wb.jpg"));
//
//            Log.d(TAG, "is1" + is1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        bmp1 = BitmapFactory.decodeStream(is1, null, options1);
//        setWallpaper(bmp1);
        bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.wb, options1);
//        Log.d(TAG, "onCreate bmp1=" + bmp1);
        Log.d(TAG, "onCreate1111: byteCount=" + bmp1.getByteCount() / 1024 + " allocate=" + bmp1
                .getAllocationByteCount() / 1024 + " height=" + bmp1.getHeight() + "  width=" +
                bmp1.getWidth() + " options=" + options1
                .outHeight + " config=" + options1.inPreferredConfig + " dd=" + bmp1.getConfig()
                + " inTargetDensity=" + options1.inTargetDensity + " inDensity=" +
                options1.inDensity);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        clearPreloadedDrawables();
//        bmp.recycle();
//        bmp1.recycle();
//        RefWatcher refWatcher = MyApplication.getRefWatcher(this);
//        refWatcher.watch(sBitmaps);
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
