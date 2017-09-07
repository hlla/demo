/**
 *
 */

package com.example.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by chengjian
 */
public class TestService extends Service {
    private static final String TAG = "TestService";
//    private testcopy.Stub mTestCopy = new testcopy.Stub() {
//
//        @Override
//        public void testout(School sc) throws RemoteException {
//            Log.d(TAG, "testout sc=" + sc);
//            TestSerivceActivity.testActivity();
//            if (null != sc) {
//                Log.d(TAG, "testout sc.name=" + sc.getName() + "  type=" + sc.getType());
//            }
//        }
//
//        @Override
//        public void testCall(List<School> ssss) throws RemoteException {
//            // TODO Auto-generated method stub
//
//        }
//
//        @Override
//        public School[] testArray(School sc) throws RemoteException {
//            // TODO Auto-generated method stub
//            return null;
//        }
//
//        @Override
//        public List<School> test() throws RemoteException {
//            // TODO Auto-generated method stub
//            return null;
//        }
//
//        @Override
//        public void performAction(School sc) throws RemoteException {
//            // TODO Auto-generated method stub
//
//        }
//
//        @Override
//        public School getAdId() throws RemoteException {
//            // TODO Auto-generated method stub
//            return null;
//        }
//    };

    // private test.Stub mTest = new test.Stub() {
    //
    // @Override
    // public void performAction() throws RemoteException {
    // Log.d(TAG, "performAction thread name="
    // + Thread.currentThread().getName() + " id="
    // + Thread.currentThread().getId());
    // }
    //
    // @Override
    // public int getAdId() throws RemoteException {
    // Log.d(TAG, "getAdId thread name="
    // + Thread.currentThread().getName() + " id="
    // + Thread.currentThread().getId());
    // return 1;
    // }
    //
    // @Override
    // public void testCall() throws RemoteException {
    // // TODO Auto-generated method stub
    // Log.d(TAG, "testCall thread name="
    // + Thread.currentThread().getName() + " id="
    // + Thread.currentThread().getId());
    // }
    // };

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind intent=" + intent);
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Log.d(TAG, "onBind return");
        return null;
    }

    @Override
    public void onRebind(Intent intent) {
        // TODO Auto-generated method stub
        super.onRebind(intent);
        Log.d(TAG, "onRebind");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        if (null != intent) {
            Log.d(TAG, "onStartCommand value=" + intent.getParcelableExtra("key"));
        }
        Log.d(TAG, "onStartCommand value intent=" + intent);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        // TODO Auto-generated method stub
        boolean result = super.onUnbind(intent);
        // boolean result = false;
        Log.d(TAG, "onUnbind intent=" + intent + "  result=" + result);
        return result;
    }
}
