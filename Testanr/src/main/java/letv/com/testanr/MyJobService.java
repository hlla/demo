package letv.com.testanr;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by chengjian on 17/6/6.
 */

public class MyJobService extends JobService {
    private static final String TAG = "Testanr_MyJobService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Log.d(TAG, "handleMessage: ");
            Toast.makeText(MyJobService.this, "MyJobService", Toast.LENGTH_SHORT).show();
            JobParameters param = (JobParameters) msg.obj;
            jobFinished(param, true);
            return true;
        }
    });

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG, "onStartJob: id=" + params.getJobId());
//        Message m = Message.obtain();
//        m.obj = params;
//        handler.sendMessage(m);
        Log.i(TAG, "Totally and completely working on job " + params.getJobId());
        // First, check the network, and then attempt to connect.
        if (isNetworkConnected()) {
            new SimpleDownloadTask().execute(params);
            return true;
        } else {
            Log.i(TAG, "No connection on job " + params.getJobId() + "; sad face");
        }
//        FutureTask futureTask = new FutureTask(pAccount);
//        // 使用futureTask创建一个线程
//        Thread thread = new Thread(futureTask);
//        thread.start();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG, "onStopJob: id=" + params.getJobId());
        handler.removeCallbacksAndMessages(null);
        return false;
    }

    /**
     * Determines if the device is currently online.
     */
    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    /**
     * Uses AsyncTask to create a task away from the main UI thread. This task creates a
     * HTTPUrlConnection, and then downloads the contents of the webpage as an InputStream.
     * The InputStream is then converted to a String, which is logged by the
     * onPostExecute() method.
     */
    private class SimpleDownloadTask extends AsyncTask<JobParameters, Void, String> {

        protected JobParameters mJobParam;

        @Override
        protected String doInBackground(JobParameters... params) {
            // cache system provided job requirements
            mJobParam = params[0];
            try {
                InputStream is = null;
                // Only display the first 50 characters of the retrieved web page content.
                int len = 50;

                URL url = new URL("https://www.baidu.com");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000); //10sec
                conn.setConnectTimeout(15000); //15sec
                conn.setRequestMethod("GET");
                //Starts the query
                conn.connect();
                int response = conn.getResponseCode();
                Log.d(TAG, "The response is: " + response);
                is = conn.getInputStream();

                // Convert the input stream to a string
                Reader reader = null;
                reader = new InputStreamReader(is, "UTF-8");
                char[] buffer = new char[len];
                reader.read(buffer);
                return new String(buffer);

            } catch (IOException e) {
                return "Unable to retrieve web page.";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            jobFinished(mJobParam, false);
            Log.i(TAG, ""+result.length());
            HashMap<String, String> map = new HashMap<String, String>();
        }
    }
}
