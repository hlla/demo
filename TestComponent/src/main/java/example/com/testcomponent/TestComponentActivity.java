package example.com.testcomponent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestComponentActivity extends Activity {
    private static final String TAG = "TestComponent1_Activity";
    public static final String ACTION = "android.intent.action.mystaticreceiver";
    @BindView(R.id.bindservice)
    Button bindservice;
    @BindView(R.id.broadcast)
    Button broadcast;
    private WeakHashMap<TestComponentActivity, String> weakHashMap = new WeakHashMap<>();
    @BindView(R.id.query)
    Button query;
    @BindView(R.id.insert)
    Button insert;
    @BindView(R.id.update)
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_component);
        ButterKnife.bind(this);
        getContentResolver().registerContentObserver(URIField.ACCOUNT_URI, true, new
                ContentObserver(null) {
                    @Override
                    public void onChange(boolean selfChange) {
                        Log.d(TAG, "onChange selfChange=" + selfChange);
                    }
                });
    }

    @OnClick(R.id.query)
    public void onQueryClicked() {
        new Thread() {
            @Override
            public void run() {
                try {
                    Class cr = getClassLoader().loadClass("android.content.ContentResolver");
                    Method method = cr.getMethod("acquireProvider", Uri.class);
                    Object transport = method.invoke(getContentResolver(), URIField
                            .ACCOUNT_URI);
                    Log.d(TAG, "onQueryClicked: " + transport + "  class=" + transport.getClass());
                    Class tsCl = transport.getClass();
                    Method get = tsCl.getDeclaredMethod("getContentProvider");
                    get.setAccessible(true);
                    Log.d(TAG, "onQueryClicked: get" + get.invoke(transport));
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d(TAG, "onQueryClicked: e" + e);
                }
                getContentResolver().query(URIField.ACCOUNT_URI, null, null, null, null, null);
                weakHashMap.put(TestComponentActivity.this, "aaaa");
            }
        }.start();
        weakHashMap.put(new TestComponentActivity(), "bbbb");
    }

    int i = 0;

    @OnClick(R.id.insert)
    public void onInsertClicked() {
        i++;
        new Thread() {
            @Override
            public void run() {
                ContentValues contentValues = new ContentValues();
                contentValues.put("login_account", "cj" + i);
                getContentResolver().insert(URIField.ACCOUNT_URI, contentValues);
                Iterator keys = weakHashMap.keySet().iterator();
                while (keys.hasNext()) {
                    Log.d(TAG, "onInsertClicked: " + weakHashMap.get(keys.next()));
                }
            }
        }.start();
//
    }

    @OnClick(R.id.update)
    public void onUpdateClicked() {
        new Thread() {
            @Override
            public void run() {
                getContentResolver().update(URIField.ACCOUNT_URI, new ContentValues(), null, null);
            }
        }.start();
    }

    @OnClick({R.id.bindservice, R.id.broadcast})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bindservice:
                Intent intent = new Intent();
                intent.setClassName("letv.com.testanr11", "letv.com.testanr.MyService");
                boolean result = bindService(intent, new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        Log.d(TAG, "onServiceConnected: ");
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        Log.d(TAG, "onServiceDisconnected: ");

                    }
                }, BIND_AUTO_CREATE);
                Log.d(TAG, "onBindServiceClicked: end result=" + result);
                break;
            case R.id.broadcast:
                Intent intent1 = new Intent(ACTION);
                intent1.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
                sendBroadcast(intent1);
                break;
        }
    }
}
