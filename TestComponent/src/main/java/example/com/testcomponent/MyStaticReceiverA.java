package example.com.testcomponent;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chengjian on 17/5/31.
 */

public class MyStaticReceiverA extends BroadcastReceiver {
    private static final String TAG = "TestComponent1_ReceiA";
    private AtomicInteger integer = new AtomicInteger(500);
    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.d(TAG, "onReceive: action=" + intent.getAction());
        for (int m = 0; m < 500; m++) {
            new Thread() {
                @Override
                public void run() {
                    synchronized (MyStaticReceiverA.this) {
                        try {
                            sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //                    DatabaseHelper helper = new DatabaseHelper(TestComponentActivity.this,
//                            "hizone.db");
//                    SQLiteDatabase database = helper.getReadableDatabase();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("login_account", "cj" + integer.getAndIncrement());
//                    ContentValues contentValues = new ContentValues();
//                        context.getContentResolver().insert(URIField.ACCOUNT_URI, contentValues);
//                    if (integer.get() % 2 == 0) {
//                    database.insert(DatabaseHelper.Tables.ACCOUNT, null, contentValues);
//                    } else {
//                        database.query(DatabaseHelper.Tables.ACCOUNT, null, null, null, null,
// null,
//                                null);
//                    }
//                    database.close();
                    }
                }
            }.start();
        }
//        abortBroadcast();
//        try {
//            Thread.sleep(12000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
