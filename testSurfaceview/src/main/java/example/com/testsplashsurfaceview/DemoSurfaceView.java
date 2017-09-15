package example.com.testsplashsurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewTreeObserver;

import java.lang.reflect.Field;
import java.util.concurrent.locks.ReentrantLock;

public class DemoSurfaceView extends SurfaceView implements Callback {
    private static final String TAG = "DemoSurfaceView";
    LoopThread thread;
    private final Object lock = new Object();

    public DemoSurfaceView(Context context) {
        super(context);
//        for(int i=0;i<10;i++){
        init(); //初始化,设置生命周期回调方法
        Log.d(TAG, "DemoSurfaceView: mContext.getClassLoader()=" + context.getClassLoader());
        Log.d(TAG, "DemoSurfaceView: mContext.getClassLoader()111=" + Context.class
                .getClassLoader());
//        }
//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                .detectAll()
//                .detectDiskReads()
//                .penaltyLog()
//                .penaltyDialog() ////打印logcat，当然也可以定位到dropbox，通过文件保存相应的log
//                .build());
//        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll()
//                .penaltyLog()
//                .build());
//        Log.d(TAG, "hhhh=" + DemoSurfaceView.class.getClassLoader());
    }


    @Override
    protected void updateWindow(boolean force, boolean redrawNeeded) {
        Log.d(TAG, "updateWindow: start");
        super.updateWindow(force, redrawNeeded);
        Log.d(TAG, "updateWindow: end");
    }

    private void init() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        setBackgroundColor(Color.RED);
        ViewTreeObserver observer = getViewTreeObserver();
        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
//                Exception e = new Exception("onPreDraw()");
//                Log.d(TAG, "onPreDraw:", e);
                return true;
            }
        });
        SurfaceHolder holder = getHolder();
        holder.addCallback(this); //设置Surface生命周期回调
//        Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
        thread = new LoopThread(holder, getContext());

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        Exception e = new Exception("surfaceChanged ");
        e.printStackTrace();
        Log.d(TAG, "surfaceChanged:", e);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new LoopThread(holder, getContext());
        thread.isRunning = true;
        thread.start();
        Exception e = new Exception("surfaceCreated ");
        e.printStackTrace();
        Log.d(TAG, "surfaceCreated: ", e);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Exception exception = new Exception("surfaceDestroyed ");
        Log.d(TAG, "surfaceDestroyed: ", exception);
        thread.isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean handle = super.dispatchTouchEvent(event);
        Log.d(TAG, "dispatchTouchEvent: event=" + event.getAction() + " handle=" + handle);
        return handle;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean handle = super.onTouchEvent(event);
        Log.d(TAG, "onTouchEvent: event=" + event.getAction() + " handle=" + handle);
        return handle;
    }

    /**
     * 执行绘制的绘制线程
     *
     * @author Administrator
     */
    class LoopThread extends Thread {

        SurfaceHolder surfaceHolder;
        Context context;
        boolean isRunning;
        float radius = 10f;
        Paint paint;
        ReentrantLock surfaceLock;

        public LoopThread(SurfaceHolder surfaceHolder, Context context) {
            setName("chengjian_thread");
            this.surfaceHolder = surfaceHolder;
            this.context = context;
            isRunning = false;

            paint = new Paint();
            paint.setColor(Color.GREEN);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth((float) 10.0);
            try {
                Field field = SurfaceView.class.getDeclaredField("mSurfaceLock");
                field.setAccessible(true);
                surfaceLock = (ReentrantLock) field.get(DemoSurfaceView
                        .this);
                Log.d(TAG, "LoopThread: surfaceLock=" + surfaceLock + " count=" +
                        surfaceLock.getHoldCount());
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "LoopThread: e=" + e);
            }
        }

        @Override
        public void run() {
            Canvas c = null;
            synchronized (lock) {
                long now = System.currentTimeMillis();
                Log.d(TAG, "run: start");
                //通过它来控制帧数执行一次绘制后休息50ms
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (isRunning) {
                    try {
//                        Log.d(TAG, "lockCanvas: surfaceLock before=" + surfaceLock + " count=" +
//                                surfaceLock.getHoldCount() + "  c=" + c);
                        c = surfaceHolder.lockCanvas(null);
//                        Log.d(TAG, "lockCanvas: c=" + c);
//                        Log.d(TAG, "lockCanvas: surfaceLock=" + surfaceLock + " count=" +
//                                surfaceLock.getHoldCount() + "  c=" + c);
                        if (null != c) {
                            doDraw(c);
                        }
                        //通过它来控制帧数执行一次绘制后休息50ms
//                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
//                        Log.d(TAG, "unlockCanvasAndPost: c=" + c);
                        if (null != c) {
                            surfaceHolder.unlockCanvasAndPost(c);
                        }
//                        if (null != surfaceLock) {
//                            Log.d(TAG, "unlockCanvasAndPost: surfaceLock=" + surfaceLock + " " +
//                                    "count=" +
//                                    surfaceLock.getHoldCount());
//                        }
                    }
                    //通过它来控制帧数执行一次绘制后休息50ms
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
                Log.d(TAG, "run: end duration=" + (System.currentTimeMillis() - now));
            }

        }

        public void doDraw(Canvas c) {
//            c.save();
            //这个很重要，清屏操作，清楚掉上次绘制的残留图像
            c.drawColor(Color.RED);

            c.translate(500, 500);
            c.drawCircle(0, 0, radius++, paint);
//            c.scale(4.5f, 4.5f);
//            c.translate(500, 1000);
//            c.drawRect(new Rect(10, 10, 40, 40), paint);
            if (radius > 100) {
                radius = 10f;
            }
//            c.restore();

        }

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(TAG, "onDetachedFromWindow:");
    }
}