package letv.com.testanr;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by chengjian on 17/6/2.
 */

public class MessengerService extends Service {
    private static final String TAG = "Testanr_MS";
    /**
     * Command to the service to display a message
     */
    static final int MSG_SAY_HELLO = 1;
    static final int MSG_SAY_CLIENT = 2;
    static final int MSG_SAY_REGISTER = 3;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * Handler of incoming messages from clients.
     */
    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "handleMessage: what=" + msg.what);
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (msg.what) {
                case MSG_SAY_HELLO:
                    Toast.makeText(getApplicationContext(), "hello!", Toast.LENGTH_SHORT).show();
                    break;
                case MSG_SAY_CLIENT:
                    Toast.makeText(getApplicationContext(), "MSG_SAY_CLIENT!", Toast
                            .LENGTH_SHORT).show();
                    break;
                case MSG_SAY_REGISTER: {
                    try {
                        Message msg1 = Message.obtain(null, MessengerService.MSG_SAY_REGISTER, 0,
                                0);
                        msg1.replyTo = mMessenger;
                        msg.replyTo.send(msg1);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
                default:
                    super.handleMessage(msg);
            }
            Log.d(TAG, "handleMessage: end");
        }
    }

    /**
     * Target we publish for clients to send messages to IncomingHandler.
     */
    final Messenger mMessenger = new Messenger(new IncomingHandler());

    /**
     * When binding to the service, we return an interface to our messenger
     * for sending messages to the service.
     */
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(), "binding", Toast.LENGTH_SHORT).show();
        return mMessenger.getBinder();
    }
}
