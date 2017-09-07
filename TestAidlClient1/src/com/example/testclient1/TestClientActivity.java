
package com.example.testclient1;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestClientActivity extends Activity implements OnClickListener {
    private static final String TAG = "TestClient1";
    private ArrayList<String> mList = new ArrayList<String>();
    private test iTest;
    private testcopy iTestcopy;
    private static ImageView sImageView;

    public void testActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bindBtn = (Button) findViewById(R.id.bind);
        bindBtn.setOnClickListener(this);
        Button unbindBtn = (Button) findViewById(R.id.unbind);
        unbindBtn.setOnClickListener(this);
        Button callFunCBtn = (Button) findViewById(R.id.callfunc);
        callFunCBtn.setOnClickListener(this);
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("id", "001");
            jsonObj.put("age", "20");
            jsonObj.put("name", "snoanw");
        } catch (Exception e) {
            Log.i(TAG, "onCreate e=" + e);
        }
        String jsonData = jsonObj.toString();
        Log.d(TAG, "onCreate jsonData=" + jsonData);
        sImageView = new ImageView(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        for (int i = 0; i < 100000; i++) {
            String str = new String("i" + i);
            mList.add(str);
        }
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    private TestServiceConnection connection = new TestServiceConnection();

    public class TestServiceConnection implements ServiceConnection {
        boolean mz = false;
        private final BlockingQueue<IBinder> blockingQueue = new LinkedBlockingQueue<IBinder>();

        public void onServiceConnected(ComponentName name, IBinder service) {
            try {
                Log.d(TAG, "onServiceConnected name=" + name + "  service="
                        + service);
                iTestcopy = testcopy.Stub.asInterface(service);
                // iTest = test.Stub.asInterface(service);
                // this.blockingQueue.put(service);
            } catch (Exception localInterruptedException) {
                Log.d(TAG, "onServiceConnected localInterruptedException="
                        + localInterruptedException);
            }
        }

        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected name=" + name);
        }

        // public IBinder getBinder() throws InterruptedException {
        // if (this.mz)
        // throw new IllegalStateException();
        // this.mz = true;
        // return (IBinder) this.blockingQueue.take();
        // }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bind: {
                Log.d(TAG, "1111 ");
                // new Thread() {
                // public void run() {
                Intent intent = new Intent("test_service");
                intent.setPackage("com.example.testaidlservice");
                final boolean success = bindService(intent,
                        connection, Context.BIND_AUTO_CREATE);
                Log.d(TAG, "success =" + success);
                // new Thread() {
                // public void run() {
                // if (success) {
                // IBinder iBinder;
                // try {
                // iBinder = connection.getBinder();
                // Log.d(TAG, "iBinder =" + iBinder);
                // } catch (InterruptedException e) {
                // Log.d(TAG, "getBinder InterruptedException =" + e);
                // // TODO Auto-generated catch block
                // e.printStackTrace();
                // }
                // }
                // };
                // }.start();

                // };
                // }.start();

                break;
            }
            case R.id.unbind: {
                unbindService(connection);
                break;
            }
            case R.id.callfunc: {
                try {
                    // Log.d(TAG, "1");
                    // iTest.performAction();
                    // Log.d(TAG, "2");
                    // int adid = iTest.getAdId();
                    // Log.d(TAG, "3");
                    // iTest.testCall();
                    // Log.d(TAG, "4");
                    School sc = new School();
                    sc.setName("cj");
                    sc.setType("lj");
                    iTestcopy.testout(sc);
                } catch (Exception exception) {
                    Log.d(TAG, "call Func Exception", exception);
                }

                break;
            }
        }

    }
}
