package example.com.testcomponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created by chengjian on 18-8-13.
 */

public class AlarmBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "TestComponent1_Receiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String text = TestComponentActivity.sContent.getText().toString();
        TestComponentActivity.sContent.setText(text + "\r\n" + TestComponentActivity
                .timeStamp2Date(System.currentTimeMillis(),
                        null) + "  onR..." + "," + TestComponentActivity.timeStamp2Date
                (SystemClock.uptimeMillis(), null));
//        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        String action = intent.getAction();
        Log.e(TAG, "onReceive: action=" + action + " time=" + TestComponentActivity
                .timeStamp2Date(SystemClock
                        .uptimeMillis(),
                null));
//        Intent intent1 = new Intent(context, AlarmBroadcastReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent1,
//                PendingIntent.FLAG_CANCEL_CURRENT);
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, 5 * 1000 + System
//                        .currentTimeMillis(),
//                AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, 5 * 1000 + System
//                .currentTimeMillis(), pendingIntent);
    }
}
