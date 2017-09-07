package letv.com.testanr;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.util.Log;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static letv.com.testanr.LoadingActivity.KEY_FINISH;
import static letv.com.testanr.LoadingActivity.SP_FILE_NAME;

/**
 * Created by wzj on 2017/1/16.
 */

public class InstallService extends IntentService {
    private static final String TAG = "Testanr_InstallService";
    public InstallService(String name) {
        super(name);
    }

    public InstallService() {
        super("InstallService");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        int result = super.onStartCommand(intent, flags, startId);
        Log.d(TAG, "onStartCommand: result="+result);
        return START_REDELIVER_INTENT;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: intent="+intent);
        //模拟耗时
        // Log.d("wzj" , "install start" );

        try {
            Thread.sleep(35000);
            SharedPreferences dd = getSharedPreferences(SP_FILE_NAME, Context
                        .MODE_PRIVATE);
                dd.edit().putString(KEY_FINISH, "1").commit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Log.d("wzj" , "install finish" );

    }

    private void startLauncher() {
//        sendBroadcast(new Intent(InstallActivity.INSTALL_FINISH_ACTION));
//        Handler handler = new Handler(getMainLooper());
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if(isInstallTopActivity()){
//                    //防止主进程被杀死，无法发送停止广播（这时，install进程没有退出，否则install进程已经退出，不会执行此处）
////                    PackageManager packageManager = getPackageManager();
////                    startActivity(packageManager.getLaunchIntentForPackage(getPackageName()));
//
//                }
//            }
//        },8000);
    }

}
