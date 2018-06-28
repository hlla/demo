package test.example.com.testrx;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class TestRXActivity extends AppCompatActivity {
    private static final String TAG = "TestRXActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_rx);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_rx, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.test_rx_java)
    public void onTestRxJavaClicked() {
        ArrayList<String> strings1 = new ArrayList<>();
        strings1.add("a1qq");
        strings1.add("b1ad");
        strings1.add("c1kak1ad");
        Observable observable1 = Observable.from(strings1);
        ArrayList<Integer> strings2 = new ArrayList<>();
        strings2.add(1);
        strings2.add(2);
        strings2.add(3);
        Observable observable2 = Observable.from(strings2);
        Observable mergeObservable = Observable.merge(observable1, observable2);
//        mergeObservable.observeOn(Schedulers.io())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Action1() {
//                    @Override
//                    public void call(Object o) {
//                        Log.d(TAG, "merge call: o=" + o);
//                    }
//                });
        Observable.combineLatest(observable1, observable2, new Func2<String, Integer, String>() {
            @Override
            public String call(String o, Integer o2) {
                Log.d(TAG, "combineLatest call: o=" + o);
                return null;
            }
        });
//        Observable.from(strings)
//                .flatMap(new Func1<String, Observable<String>>() {
//                    @Override
//                    public Observable<String> call(String str) {
//                        Log.d(TAG, "flatMap call: str=" + str);
//                        return Observable.from(str.split("1"));
//                    }
//                })
//                .subscribeOn(Schedulers.newThread())
//                .filter(new Func1<String, Boolean>() {
//                    @Override
//                    public Boolean call(String str) {
//                        Log.d(TAG, "filter call: str=" + str);
//                        return str.startsWith("a");
//                    }
//                })
////                .subscribeOn(Schedulers.io())
////                .map(new Func1<String, Thread>() {
////                    @Override
////                    public Thread call(String name) {
////                        try {
////                            Thread.sleep(1000);
////                        } catch (InterruptedException e) {
////                            e.printStackTrace();
////                        }
////                        Log.d(TAG, "map call: name=" + name);
////                        return new Thread("name");
////                    }
////                })
//                .map(new Func1<String, String>() {
//                    @Override
//                    public String call(String name) {
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        Log.d(TAG, "map call: name=" + name);
//                        return new String(name);
//                    }
//                })
////                .subscribeOn(Schedulers.immediate())
//                .observeOn(Schedulers.io())
////                .subscribe(new Action1<Thread>() {
////                    @Override
////                    public void call(Thread t) {
////                        Log.d(TAG, "call: t=" + t);
////                    }
////                });
////                .subscribe(new Observer<String>() {
////                    @Override
////                    public void onCompleted() {
////                        Log.d(TAG, "onCompleted");
////                    }
////
////                    @Override
////                    public void onError(Throwable e) {
////                        Log.d(TAG, "onError e=" + e);
////                    }
////
////                    @Override
////                    public void onNext(String s) {
////                        try {
////                            Thread.sleep(1000);
////                        } catch (InterruptedException e) {
////                            e.printStackTrace();
////                        }
////                        Log.d(TAG, "onNext: s=" + s);
////                    }
////                })
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String t) {
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        Log.d(TAG, "call: t=" + t);
//                    }
//                });
    }

    @OnClick(R.id.test_rx_android)
    public void onTestRxAndroidClicked() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a1qq");
        strings.add("b1ad");
        strings.add("c1kak1ad");
        String[] arrays = new String[3];
        io.reactivex.Observable.fromArray(strings.toArray(arrays))
                .flatMap(new Function<String, io.reactivex.Observable<String>>() {
                    @Override
                    public io.reactivex.Observable<String> apply(String s) throws Exception {
                        Log.d(TAG, "flatMap call: str=" + s);
                        return io.reactivex.Observable.fromArray(s.split("1"));
                    }
                }).subscribeOn(io.reactivex.schedulers.Schedulers.newThread())
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String str) {
                        Log.d(TAG, "filter call: str=" + str);
                        return str.startsWith("a");
                    }
                })
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String name) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.d(TAG, "map call: name=" + name);
                        return new String(name);
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String t) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.d(TAG, "accept: t=" + t);
                    }
                });

    }

    @OnClick(R.id.test_back_pressure)
    public void onTextBackPressureClicked() {
        //被观察者在主线程中，每1ms发送一个事件
        Observable.interval(1, TimeUnit.MILLISECONDS)
                //.subscribeOn(Schedulers.newThread())
                //将观察者的工作放在新线程环境中
                .observeOn(Schedulers.newThread())
                //观察者处理每1000ms才处理一个事件
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.w("TAG", "---->" + aLong);
                    }
                });

    }

    @OnClick(R.id.toolbar)
    public void onToolbarClicked() {
    }

    @OnClick(R.id.fab)
    public void onFabClicked() {
    }
}
