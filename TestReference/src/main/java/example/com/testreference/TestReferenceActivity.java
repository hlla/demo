package example.com.testreference;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestReferenceActivity extends Activity {
    private static final String TAG = "TestReferenceActivity";
    @BindView(R.id.test_phantom_reference)
    Button testPhantomReference;
    @BindView(R.id.test_weak_reference)
    Button testWeakReference;
    //    @BindView(R.id.start_other_process)
//    Button startOtherProcess;
    private PhantomReferenceQueue<TestReferenceActivity> mPhantomReferenceQueue = new
            PhantomReferenceQueue();
    private WeakReferenceQueue mWeakReferenceQueue = new WeakReferenceQueue();
    private TestPhantomReference mPhantomReference;
    private TestWeakReference mWeakReference;
    private TestObjectWithFinalize mTestObject;
    private long total1;
    private long total2;
    private long total3;

    public static class A {
        byte b1;
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte b6;
        byte b7;
        byte b8;
        byte b;
    }

    private class WeakReferenceQueue<T> extends ReferenceQueue {
    }

    private class PhantomReferenceQueue<T> extends ReferenceQueue {
    }

    class BaseObject {
//        public ArrayList<A> arrayList = new ArrayList<>();
//        public ArrayList<A> list1 = new ArrayList<>();

        BaseObject() {
            Log.d(TAG, "BaseObject(): ");
//            for (int i = 0; i < 100000; i++) {
//                arrayList.add(new A());
//            }
//            for (int i = 0; i < 100000; i++) {
//                list1.add(new A());
//            }
        }
    }

    private class TestObjectWithFinalize extends BaseObject {
        private ArrayList<A> list = new ArrayList<>();
        private A[] as;

        TestObjectWithFinalize() {
            Log.d(TAG, "TestObjectWithFinalize(): ");
            as = new A[1000000];
            for (int i = 0; i < 1000000; i++) {
                as[i] = new A();
            }
//            for (int i = 0; i < 1000000; i++) {
//                list.add(new A());
//            }
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            Exception exception = new Exception("finalize");
            Log.d(TAG, "TestObjectWithFinalize finalize() mTestObject=" + mTestObject, exception);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Object object = getReflectReferent(mPhantomReference);
        Log.d(TAG, "onResume: Phantom  object.reflect=" + object + " " +
                "mPhantomReference=" + mPhantomReference);
    }

    private class TestObjectWithoutFinalize extends BaseObject {
        public ArrayList<String> arrayList = new ArrayList<>();
        public ArrayList<A> list2 = new ArrayList<>();

        TestObjectWithoutFinalize() {
            Log.d(TAG, "TestObjectWithoutFinalize(): ");
            for (int i = 0; i < 1000000; i++) {
                list2.add(new A());
            }
//            for (int i = 0; i < 50000; i++) {
//                list2.add(new A());
//            }
        }
    }

    class TestPhantomReference<T> extends PhantomReference<T> {

        public TestPhantomReference(T referent, ReferenceQueue q) {
            super(referent, q);
        }

        @Override
        public boolean enqueue() {
            Exception exception = new Exception("enqueue");
            Log.d(TAG, "enqueue: PhantomReference enqueue()", exception);
            return super.enqueue();
        }

        @Override
        public boolean isEnqueued() {
            Exception exception = new Exception("isEnqueued");
            Log.d(TAG, "isEnqueued: PhantomReference isEnqueued()", exception);
            return super.isEnqueued();
        }

        @Override
        public void clear() {
            super.clear();
            Exception exception = new Exception("clear");
            Log.d(TAG, "clear(): PhantomReference clear()", exception);
        }
    }

    class TestWeakReference<T> extends WeakReference<T> {

        public TestWeakReference(T referent, ReferenceQueue<? super T> q) {
            super(referent, q);
        }

        @Override
        public boolean enqueue() {
            Exception exception = new Exception("enqueue");
            Log.d(TAG, "TestWeakReference enqueue()", exception);
            return super.enqueue();
        }

        @Override
        public boolean isEnqueued() {
            Exception exception = new Exception("isEnqueued");
            Log.d(TAG, "TestWeakReference isEnqueued()", exception);
            return super.isEnqueued();
        }

//        public boolean test() {
//            Exception exception = new Exception("a");
//            Log.d(TAG, "TestWeakReference isEnqueued()", exception);
//            return super.isEnqueued();
//        }

        @Override
        public void clear() {
            super.clear();
            Exception exception = new Exception("clear");
            Log.d(TAG, "TestWeakReference clear()", exception);
        }
    }

    private static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "reference-pool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_reference);
        ButterKnife.bind(this);
        ExecutorService singleThreadPool = new ThreadPoolExecutor(4, 4,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), new DefaultThreadFactory(), new
                ThreadPoolExecutor.AbortPolicy());
        singleThreadPool.execute(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        Object object = getReflectReferent(mPhantomReference);
                        Log.d(TAG, "before remove run: Phantom  object.reflect=" + object + " " +
                                "mPhantomReference=" + mPhantomReference);
                        Reference<? extends TestReferenceActivity> phantomreference =
                                mPhantomReferenceQueue.remove(0);
                        if (null != phantomreference) {
                            Log.d(TAG, "run: Phantom reference=" + phantomreference + " " +
                                    "object.get=" + phantomreference.get());
                            Object object1 = getReflectReferent(mPhantomReference);
                            Log.d(TAG, "after remove run: Phantom  object.reflect=" + object1);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.d(TAG, "run: Phantom e=" + e);
                    }
                }
            }
        });
        singleThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Reference<?> weakReference = mWeakReferenceQueue.remove();
                        if (null != weakReference) {
                            Log.d(TAG, "run: Weak reference=" + weakReference + " object.get=" +
                                    weakReference.get());
                            Object object = getReflectReferent(mWeakReference);
                            Log.d(TAG, "run: Weak  object.reflect=" + object);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.d(TAG, "run: Weak e=" + e);
                    }
                }
            }
        });
//
        singleThreadPool.shutdown();
        int res = getResources().getIdentifier("ic_launcher_round_pp", "drawable", getPackageName
                ());
        Log.d(TAG, "onCreate: res-" + res);
        try {
            JSONObject jsonObject = new JSONObject("a");
            String name = "";
            if (jsonObject.has("c")) {
                name = jsonObject.getString("e");
            }
            Log.d(TAG, "onCreate: name-" + name);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    A[] ints = new A[500000];


    @OnClick(R.id.test_phantom_reference)
    public void onTestPhantomReferenceClicked() {
//        ints = new A[100000];
//        for (int i = 0; i < 500000; i++) {
//            A a = new A();
//            ints[i] = a;
//        }
        BaseObject testObject = getTestObject();
        mPhantomReference = new TestPhantomReference<>(testObject, mPhantomReferenceQueue);
        Log.d(TAG, "onTestPhantomReferenceClicked: mPhantomReference=" + mPhantomReference);
        testObject = null;
        Object referent = mPhantomReference.get();
        Log.d(TAG, "onTestPhantomReferenceClicked: mPhantomReference referent object=" + referent);
        Object object = getReflectReferent(mPhantomReference);
        Log.d(TAG, "onTestPhantomReferenceClicked: Phantom object.reflect=" + object);
    }

    @OnClick(R.id.test_weak_reference)
    public void onTestWeakReferenceClicked() {
        total1 = 0;
        total2 = 0;
        BaseObject testObject = getTestObject();
        mWeakReference = new TestWeakReference<>(testObject, mWeakReferenceQueue);
        Log.d(TAG, "onTestWeakReferenceClicked: mWeakReference=" + mWeakReference);
        testObject = null;
        Object referent = mWeakReference.get();
        Log.d(TAG, "onTestWeakReferenceClicked: mWeakReference referent object=" + referent);
        Object object = getReflectReferent(mWeakReference);
        Log.d(TAG, "onTestWeakReferenceClicked: weak object.reflect=" + object);
    }

    @NonNull
    private BaseObject getTestObject() {
        boolean isFinalize = SystemProperties.getBoolean("debug.finalize", false);
        Log.d(TAG, "getTestObject: isFinalize=" + isFinalize);
        BaseObject testObject = null;
        if (isFinalize) {
            testObject = new TestObjectWithFinalize();
        } else {
            testObject = new TestObjectWithoutFinalize();
        }
        return testObject;
    }

    Object getReflectReferent(Reference reference) {
        Object referent = null;
        try {
            Field rereferent = Reference.class
                    .getDeclaredField("referent");
            rereferent.setAccessible(true);
            referent = rereferent.get(reference);
        } catch (Exception e) {

        }
        return referent;
    }
}
