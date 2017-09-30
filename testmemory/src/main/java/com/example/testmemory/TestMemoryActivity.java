package com.example.testmemory;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class TestMemoryActivity extends Activity {
    private static final String TAG = "TestMemoryActivity";
    private static ArrayList<Bitmap> sBitmaps = new ArrayList<>();
    private static ArrayList<Activity> sActivities = new ArrayList<>();
    private static ImageView sImageView;
    //    @BindView(R.id.test_webview)
    Button testWebview;
    private Bitmap bmp;
    private Bitmap bmp1;
    private Button dd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_memory);
        testWebview = (Button) findViewById(R.id.test_webview);
        testWebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(TestMemoryActivity.this, TestWebViewActivity.class);
//                startActivity(intent);
                clearPreloadedDrawables();
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
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bmp1.compress(Bitmap.CompressFormat.JPEG, 100, out);
        Log.d(TAG, "onCreate: size1=" + out.size() / 1024 + " out=" + out.toByteArray()[out.size
                () - 1]);
        bmp1.compress(Bitmap.CompressFormat.PNG, 100, out);
        Log.d(TAG, "onCreate: size2=" + out.size() / 1024);
        bmp1.compress(Bitmap.CompressFormat.WEBP, 100, out);
        Log.d(TAG, "onCreate: size3=" + out.size() / 1024);

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
