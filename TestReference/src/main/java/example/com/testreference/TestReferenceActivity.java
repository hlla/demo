package example.com.testreference;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestReferenceActivity extends Activity {
    private static final String TAG = "TestReferenceActivity";
    @BindView(R.id.test_phantom_reference)
    Button testPhantomReference;
    @BindView(R.id.test_weak_reference)
    Button testWeakReference;
    @BindView(R.id.start_other_process)
    Button startOtherProcess;
    private ReferenceQueue<TestReferenceActivity> mPhantomReferenceQueue = new
            ReferenceQueue<TestReferenceActivity>();
    private ReferenceQueue mWeakReferenceQueue = new ReferenceQueue<>();
    private TestPhantomReference<TestObject> mPhantomReference;
    private TestWeakReference mWeakReference;
    private TestObject mTestObject;
    private long total1;
    private long total2;
    private long total3;


    private class TestObject extends Object {
        public ArrayList<String> strings = new ArrayList<>();

        TestObject() {
            for (int i = 0; i < 100000; i++) {
                strings.add(i + "");
            }
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            Exception exception = new Exception("finalize");
//            mTestObject = this;
            Log.d(TAG, "onCreate: TestObject finalize() mTestObject=" + mTestObject, exception);
        }
    }

    class TestPhantomReference<T> extends PhantomReference<T> {

        public TestPhantomReference(T referent, ReferenceQueue q) {
            super(referent, q);
        }

        @Override
        public boolean enqueue() {
            Exception exception = new Exception("enqueue");
            Log.d(TAG, "onCreate: PhantomReference enqueue()", exception);
            return super.enqueue();
        }

        @Override
        public boolean isEnqueued() {
            Exception exception = new Exception("isEnqueued");
            Log.d(TAG, "onCreate: PhantomReference isEnqueued()", exception);
            return super.isEnqueued();
        }

        @Override
        public void clear() {
            super.clear();
            Exception exception = new Exception("clear");
            Log.d(TAG, "onCreate: PhantomReference clear()", exception);
        }
    }

    class TestWeakReference<T> extends WeakReference<T> {

        public TestWeakReference(T referent, ReferenceQueue<? super T> q) {
            super(referent, q);
        }

        @Override
        public boolean enqueue() {
            Exception exception = new Exception("enqueue");
            Log.d(TAG, "onCreate: TestWeakReference enqueue()", exception);
            return super.enqueue();
        }

        @Override
        public boolean isEnqueued() {
            Exception exception = new Exception("isEnqueued");
            Log.d(TAG, "onCreate: TestWeakReference isEnqueued()", exception);
            return super.isEnqueued();
        }

        @Override
        public void clear() {
            super.clear();
            Exception exception = new Exception("clear");
            Log.d(TAG, "onCreate: TestWeakReference clear()", exception);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_reference);
        ButterKnife.bind(this);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    try {
                        Thread.sleep(1000);
                        Reference<? extends TestReferenceActivity> phantomreference =
                                mPhantomReferenceQueue.remove(1000);
                        if (null != phantomreference) {
                            Log.d(TAG, "run: Phantom reference=" + phantomreference + " " +
                                    "object.get=" +
                                    phantomreference.get());
                            Field rereferent = Reference.class
                                    .getDeclaredField("referent");
                            rereferent.setAccessible(true);
                            Object result = rereferent.get(phantomreference);
                            Log.d(TAG, "run: Phantom object.reflect=" + result);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.d(TAG, "run: Phantom e=" + e);
                    }
                    try {
                        Reference<?> weakReference = mWeakReferenceQueue.poll();
                        if (null != weakReference) {
                            Log.d(TAG, "run: Weak reference=" + weakReference + " " +
                                    "object.get=" +
                                    weakReference.get());
                            Field rereferent = Reference.class
                                    .getDeclaredField("referent");
                            rereferent.setAccessible(true);
                            Object result = rereferent.get(weakReference);
                            Log.d(TAG, "run: weak object.reflect=" + result);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.d(TAG, "run: Phantom e=" + e);
                    }
                }
            }
        }.start();


    }

    @OnClick(R.id.test_phantom_reference)
    public void onTestPhantomReferenceClicked() {
        new Thread() {
            @Override
            public void run() {
                FileChannel channel = null;
                total3 = 0;
                final File file = new File(Environment.getExternalStorageDirectory() + "/c.test");
                try {
                    final byte[] conent = new byte[1024 * 8];
//                    FileInputStream fileInputStream = new FileInputStream(file);
//                    BufferedInputStream bis = new BufferedInputStream(fileInputStream);
                    RandomAccessFile raf = new RandomAccessFile(file, "rw");
                    channel = raf.getChannel();
                    Log.d(TAG, "3333 before  read lock");
                    FileLock fileLock = channel.lock();
                    Log.d(TAG, "3333 begin read lock");
                    sleep(6000);
//                    FileOutputStream fileOutputStream = new FileOutputStream(Environment
//                            .getExternalStorageDirectory() + "/c.test");
//                    BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
                    int length = 0;
                    long currentTime = System.currentTimeMillis();
//                    while ((length = bis.read(conent, 0, conent.length)) != -1) {
//                        total3 += length;
////                        bos.write(conent, 0, length);
//                        if (System.currentTimeMillis() - currentTime > 1000) {
//                            currentTime = System.currentTimeMillis();
//                            Log.d(TAG, "33333 result total3=" + total3);
//                        }
//                    }
                    Log.d(TAG, "33333 read end result total3333=" + total3);
                    Log.d(TAG, "33333  after read lock");
                    fileLock.release();
                    channel.close();
//                    bos.flush();
//                    fileOutputStream.flush();
//                    fileOutputStream.flush();
//                    bis.close();
//                    fileInputStream.close();
//                    fileOutputStream.close();


                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d(TAG, "onStartFgServiceClicked e=" + e);
                }
            }
        }.start();
//        if (mTestObject != null) {
//            Log.d(TAG, "onTestPhantomReferenceClicked: size=" + mTestObject.strings.size() + " " +
//                    "i=" + mTestObject.strings.get(0));
//        }
//        long test = SystemProperties.getLong("debug.loadad_delay_time", 100);
//        TestObject object = new TestObject();
//        mPhantomReference = new TestPhantomReference<TestObject>(object, mPhantomReferenceQueue);
//        Log.d(TAG, "onTestPhantomReferenceClicked: object=" + object + " test=" + test);
//        object = null;
//        VolleyImageLoader.getInstance().decodeImage("https://ss1.bdstatic" +
//                        ".com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=663436205," +
//                        "463231646&fm=27&gp=0.jpg", 100,
//                100, new VolleyImageLoader.BitmapListener() {
//
//                    @Override
//                    public void onLoaded(Bitmap bitmap) {
//                        findViewById(R.id.test_weak_reference).setBackground(new BitmapDrawable
//                                (getResources(), bitmap));
//                    }
//
//                    @Override
//                    public void onFailed(Throwable error) {
//
//                    }
//                });
    }

    @OnClick(R.id.test_weak_reference)
    public void onTestWeakReferenceClicked() {
        total1 = 0;
        total2 = 0;
        TestObject object = new TestObject();
        mWeakReference = new TestWeakReference<>(object, mWeakReferenceQueue);
        object = null;
//        mTestObject = (TestObject) mWeakReference.get();
        Log.d(TAG, "onTestWeakReferenceClicked: mWeakReference=" + mWeakReference + " value=" +
                mTestObject);
        try {
            Field rereferent = Reference.class
                    .getDeclaredField("referent");
            rereferent.setAccessible(true);
            Object result = rereferent.get(mWeakReference);
            Log.d(TAG, "onCreate: weak object.reflect=" + result);
        } catch (Exception e) {

        }
        new Thread() {
            @Override
            public void run() {
                FileChannel channel = null;
                final File file = new File(Environment.getExternalStorageDirectory() + "/1.dat");
                final File file1 = new File(Environment.getExternalStorageDirectory() + "/c.test");
                try {
                    final byte[] conent = new byte[1024 * 3];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fileInputStream);
                    FileOutputStream fileOutputStream = new FileOutputStream(Environment
                            .getExternalStorageDirectory() + "/c.test");
                    RandomAccessFile raf = new RandomAccessFile(file1, "rw");
                    channel = raf.getChannel();
//                    channel = fileOutputStream.getChannel();
                    Log.d(TAG, "11111 before write lock");
                    FileLock fileLock = channel.lock();
                    BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
                    int length = 0;
                    long currentTime = System.currentTimeMillis();
//                    while ((length = bis.read(conent, 0, conent.length)) != -1) {
//                        total1 += length;
//                        bos.write(conent, 0, length);
//                        if (System.currentTimeMillis() - currentTime > 1000) {
//                            currentTime = System.currentTimeMillis();
//                            Log.d(TAG, "11111  result total1=" + total1);
//                        }
//                    }
                    Thread.sleep(8000);
                    Log.d(TAG, "11111 end result total1111=" + total1);
                    Log.d(TAG, "after write lock");
                    fileLock.release();
                    channel.close();
                    bos.flush();
                    fileOutputStream.flush();
                    bos.close();
                    fileOutputStream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d(TAG, "onTestWeakReferenceClicked e=" + e);
                } finally {

                }
            }
        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//                FileChannel channel = null;
//                final File file = new File(Environment.getExternalStorageDirectory() + "/dump
// .dat");
//                try {
//                    final byte[] conent = new byte[1024 * 5];
//                    FileInputStream fileInputStream = new FileInputStream(file);
//                    BufferedInputStream bis = new BufferedInputStream(fileInputStream);
//                    FileOutputStream fileOutputStream = new FileOutputStream(Environment
//                            .getExternalStorageDirectory() + "/c.test");
//                    channel = fileOutputStream.getChannel();
//                    Log.d(TAG, "22222 before lock");
//                    FileLock fileLock = channel.lock();
//                    BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
//                    int length = 0;
//                    long currentTime = System.currentTimeMillis();
//                    while ((length = bis.read(conent, 0, conent.length)) != -1) {
//                        total2 += length;
//                        bos.write(conent, 0, length);
//                        if (System.currentTimeMillis() - currentTime > 1000) {
//                            currentTime = System.currentTimeMillis();
//                            Log.d(TAG, "22222222  result total2=" + total2);
//                        }
//                    }
//                    Log.d(TAG, "22222222 end result total22222=" + total2);
//                    bos.flush();
//                    fileOutputStream.flush();
//                    bos.close();
//                    fileOutputStream.close();
//                    fileLock.release();
//                    Log.d(TAG, "2222 after lock");
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Log.d(TAG, "onStartFgServiceClicked e=" + e);
//                }
//            }
//        }.start();
    }

    @OnClick(R.id.start_other_process)
    public void onStartOtherProcessClicked() {
        startActivity(new Intent(this, TestVolley.class));
    }
}
