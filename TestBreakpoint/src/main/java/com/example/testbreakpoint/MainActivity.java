
package com.example.testbreakpoint;

import android.Manifest;
import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ListActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity1";
    // 固定下载的资源路径，这里可以设置网络上的地址
    // private static final String URL =
    // "http://ark11.letv11.com/s?ark=ddd&ct=fff,
    // 3&n=1&res=xml&cuid=806f43bbeaf3540d2d24cd2c83e5d380&v=android_5800&did=c678153b07945b42
    // &vid=22216798&offline=0&t=1432694944";
    // private static final String URL = "http://192.168.1.100:8080/music/";
    // private static final String URL =
    // "http://192.168.1.100:8080/music/4.mp3";
    // private static final String URL =
    // "http://192.168.1.100:8080/cjapp/HitServlet";
    // private static final String URL =
    // "http://10.150.160.136:8889/test_json.txt";
    // private static final String URL =
    // "http://ark.letv.com/apsconf/?os=0&cpu=00&term=XT1085 pro&y=0";
//    private static final String URL = "http://192.168.1.100:8080";
//    private static final String URL = "https://ws.ksmobile" +
//            ".net/api/GetCloudMsgAdv?version=2&lan=zh_CN&apkversion=5.36.1&channelid=null" +
//            "&osversion=6.0&mcc=null&pkg=com.ksmobile.launcher&aid=ww71j1q7221611d3&ft=0";
    private static final String URL = "http://horoscope.cmcm.com/daily/20180712.json";
    //    private static final String URL_1=
    // private static final String URL =
    // "http://10.150.160.136:8889/?os=0&cpu=00&apptype=0&pcode=010110000&mma=0&osvs=5.1&term
    // =XT1085&pv=android_6100&aps=6&cuid=3a4ab747cf1e86f88e4b3759d8027893&mac=f8:cf:c5:1d:e6:70";
    // 固定存放下载的音乐的路径：SD卡目录下
    private static final String SD_PATH = "/mnt/sdcard/";
    // 存放各个下载器
    private Map<String, Downloader> downloaders = new HashMap<String, Downloader>();
    // 存放与下载器对应的进度条
    private Map<String, ProgressBar> ProgressBars = new HashMap<String, ProgressBar>();
    /**
     * 利用消息处理机制适时更新进度条
     */
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                String url = (String) msg.obj;
                int length = msg.arg1;
                ProgressBar bar = ProgressBars.get(url);
                if (bar != null) {
                    // 设置进度条按读取的length长度更新
                    bar.incrementProgressBy(length);
                    if (bar.getProgress() == bar.getMax()) {
                        Toast.makeText(MainActivity.this, "下载完成！", 0).show();
                        // 下载完成后清除进度条并将map中的数据清空
                        LinearLayout layout = (LinearLayout) bar.getParent();
                        layout.removeView(bar);
                        ProgressBars.remove(url);
                        downloaders.get(url).delete(url);
                        downloaders.get(url).reset();
                        downloaders.remove(url);

                    }
                }
            }
        }
    };

    public static String loadAssets(Context context, String fileName) throws IOException {
        InputStream inputStream = context.getAssets().open(fileName);
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer("");
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return sb.toString();
    }

    String content;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        int hasPermission = ContextCompat.checkSelfPermission(this, Manifest.permission
                .SYSTEM_ALERT_WINDOW);
        boolean isCanDraw = Settings.canDrawOverlays(this);
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams params1 = new WindowManager.LayoutParams();
        TextView view1 = new TextView(this);
        params1.flags = WindowManager.LayoutParams.FLAG_FULLSCREEN
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;
        params1.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        params1.width = 500;
        params1.height = 500;
        params1.gravity = Gravity.CENTER_HORIZONTAL;
        view1.setText("Phone");
        view1.setBackgroundColor(Color.YELLOW);
        windowManager.addView(view1, params1);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.SYSTEM_ALERT_WINDOW},1);
        SharedPreferences sp = getSharedPreferences("abc",
                Context.MODE_PRIVATE);
        Log.d(TAG, "version=" + sp.getInt("com.letv.ads", -1) + " hasPermission=" + hasPermission
                + " isCanDraw=" + isCanDraw);
        sp.edit().putInt("com.letv.ads", 5).apply();
        Button startBtn = (Button) findViewById(R.id.start);
        startBtn.setOnClickListener(this);
        showListView();
//        android.support.v4.os.
        String str = "select thread_id, start_pos, end_pos,compelete_size,url,shortUrl,localPath " +
                "from download_info where \'compelete_size\'<\'filesize\'";
        Log.d(TAG, "ssss=" + str);
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        String sql = "select count(*)  from download_info";
        Cursor cursor = database.rawQuery(sql, null);
        Log.d(TAG, "cursor=" + cursor);
        content = "";
        Log.d(TAG, "load before");
        try {
            content = loadAssets(MainActivity.this, "content.json");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Log.d(TAG, "load after");
        // new Thread() {
        // public void run() {
        // String content = "";
        // Log.d(TAG, "load before");
        // try {
        // content = loadAssets(MainActivity.this, "content.json");
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // Log.d(TAG, "load after");
        // String result =
        // HttpClientFactory.post("http://n.mark.letv.com/m3u8api/", content);
        // Log.d(TAG, "post result=" + result);
        // // HttpURLConnection connection = null;
        // // InputStream is = null;
        // // try {
        // // URL url = new URL(URL);
        // // connection = (HttpURLConnection) url.openConnection();
        // // Log.d(TAG, "onCreate connection=" + connection);
        // // connection.setConnectTimeout(5000);
        // // connection.setReadTimeout(200);
        // // connection.setInstanceFollowRedirects(false);
        // // connection.setRequestMethod("GET");
        // // // connection.setRequestProperty("content-type",
        // // // "application/json; charset=utf-8");
        // // connection.setRequestProperty("Accept-Encoding", HTTP.UTF_8);
        // // Log.d(TAG, "ResponseCode 11");
        // // int ResponseCode = connection.getResponseCode();
        // // Log.d(TAG, "ResponseCode=" + ResponseCode);
        // // // 将要下载的文件写到保存在保存路径下的文件中
        // // is = connection.getInputStream();
        // // int fileSize = connection.getContentLength();
        // // Log.d(TAG, "fileSize=" + fileSize);
        // // byte[] buffer = new byte[fileSize];
        // // int length = -1;
        // // while ((length = is.read(buffer)) != -1) {
        // // Log.d(TAG, "download buffer =" + buffer + "length =" +
        // // length);
        // // }
        // // Log.d(TAG, "msg=" + connection.getResponseMessage());
        // // String encoding = System.getProperty("file.encoding",
        // // "UTF-8");
        // // Log.d(TAG, "result=" + new String(buffer,
        // // HTTP.DEFAULT_CONTENT_CHARSET));
        // // Log.d(TAG, "result11=" + encoding);
        // // Log.d(TAG, "type=" + connection.getContentType());
        // // Log.d(TAG, "getContentEncoding=" +
        // // connection.getContentEncoding());
        // // } catch (Exception e) {
        // // e.printStackTrace();
        // // Log.d(TAG, "download Exception =" + e);
        // // } finally {
        // // try {
        // // is.close();
        // // connection.disconnect();
        // // } catch (Exception e) {
        // // e.printStackTrace();
        // // }
        // // }
        //
        // };
        // }.start();
        File file = new File(
                Environment.getExternalStorageDirectory().getPath() + "/LetvClient.apk_update");
        PackageInfo packageInfo = CommonUtility.getPackageInfo(this, file
                .getPath());
        Log.d(TAG, "download packageInfo=" + packageInfo + " exist=" + file.exists());
        if (null != packageInfo) {
            Log.d(TAG, "download version=" + packageInfo.versionCode);
        }

        TestHttp.download(this, file, "http://10.58.92.65:8080/LetvClient.apk");
    }

    // 显示listView，这里可以随便添加音乐
    private void showListView() {
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "1.mp3");
        data.add(map);
        map = new HashMap<String, String>();
        map.put("name", "2.mp3");
        data.add(map);
        map = new HashMap<String, String>();
        map.put("name", "3.mp3");
        data.add(map);
        map = new HashMap<String, String>();
        map.put("name", "4.mp3");
        data.add(map);
        SimpleAdapter adapter = new SimpleAdapter(this, data,
                R.layout.list_item, new String[]{
                "name"
        },
                new int[]{
                        R.id.tv_resouce_name
                });
        setListAdapter(adapter);
    }

    /**
     * 响应开始下载按钮的点击事件
     */
    public void startDownload(View v) {
        new Thread() {
            public void run() {
                // String content = "";
                // Log.d(TAG, "load before");
                // try {
                // content = loadAssets(MainActivity.this, "content.json");
                // } catch (IOException e) {
                // // TODO Auto-generated catch block
                // e.printStackTrace();
                // }
                // Log.d(TAG, "load after");
                // String result =
                // HttpClientFactory.post("http://n.mark.letv.com/m3u8api/", content);
                // Log.d(TAG, "post result=" + result);
                HttpURLConnection connection = null;
                InputStream is = null;
                try

                {
                    java.net.URL url = new URL(URL);
                    connection = (HttpURLConnection) url.openConnection();
                    Log.d(TAG, "onCreate connection=" + connection);
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(200);
                    connection.setInstanceFollowRedirects(false);
                    connection.setRequestMethod("GET");
                    // connection.setRequestProperty("content-type",
                    // "application/json; charset=utf-8");
//            connection.setRequestProperty("Accept-Encoding", HTTP.UTF_8);
                    Log.d(TAG, "ResponseCode 11");
                    int ResponseCode = connection.getResponseCode();
                    Log.d(TAG, "ResponseCode=" + ResponseCode);
                    // 将要下载的文件写到保存在保存路径下的文件中
                    is = connection.getInputStream();
//                    int fileSize = connection.getContentLength();
//                    Log.d(TAG, "fileSize=" + fileSize);
//                    byte[] buffer = new byte[fileSize];
//                    int length = -1;
//                    while ((length = is.read(buffer)) != -1) {
//                        Log.d(TAG, "download buffer =" + buffer + "length =" +
//                                length);
//                    }
//                    Log.d(TAG, "msg=" + connection.getResponseMessage());
//                    String encoding = System.getProperty("file.encoding",
//                            "UTF-8");
////            Log.d(TAG, "result=" + new String(buffer,
////                    HTTP.DEFAULT_CONTENT_CHARSET));
//                    Log.d(TAG, "result11=" + encoding);
//                    Log.d(TAG, "type=" + connection.getContentType());
//                    Log.d(TAG, "getContentEncoding=" +
//                            connection.getContentEncoding());
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d(TAG, "download Exception =" + e);
                } finally

                {
                    try {
                        is.close();
                        connection.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();

//        // 得到textView的内容
//        LinearLayout layout = (LinearLayout) v.getParent();
//        String musicName = ((TextView) layout
//                .findViewById(R.id.tv_resouce_name)).getText().toString();
//        String urlstr = URL + musicName;
//        String localfile = SD_PATH + musicName;
//        // 设置下载线程数为4，这里是我为了方便随便固定的
//        int threadcount = 4;
//        // 初始化一个downloader下载器
//        Downloader downloader = downloaders.get(urlstr);
//        if (downloader == null) {
//            downloader = new Downloader(urlstr, localfile, threadcount, this,
//                    mHandler);
//            downloaders.put(urlstr, downloader);
//        }
//        if (downloader.isdownloading())
//            return;
//        // 得到下载信息类的个数组成集合
//        LoadInfo loadInfo = downloader.getDownloaderInfors();
//        // 显示进度条
//        showProgress(loadInfo, urlstr, v);
//        // 调用方法开始下载
//        downloader.download();
    }

    /**
     * 显示进度条
     */
    private void showProgress(LoadInfo loadInfo, String url, View v) {
//        ProgressBar bar = ProgressBars.get(url);
//        if (bar == null) {
//            bar = new ProgressBar(this, null,
//                    android.R.attr.progressBarStyleHorizontal);
//            bar.setMax(loadInfo.getFileSize());
//            bar.setProgress(loadInfo.getComplete());
//            ProgressBars.put(url, bar);
//            LayoutParams params = new LayoutParams(
//                    LayoutParams.FILL_PARENT, 5);
//            ((LinearLayout) ((LinearLayout) v.getParent()).getParent())
//                    .addView(bar, params);
//        }
    }

    /**
     * 响应暂停下载按钮的点击事件
     */
    public void pauseDownload(View v) {
        LinearLayout layout = (LinearLayout) v.getParent();
        String musicName = ((TextView) layout
                .findViewById(R.id.tv_resouce_name)).getText().toString();
        String urlstr = URL + musicName;
        downloaders.get(urlstr).pause();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.start:
                new Thread() {
                    public void run() {
                        Log.d(TAG, "start");
                        String result = HttpClientFactory.post("http://n.mark.letv.com/m3u8api/",
                                content);
                        Log.d(TAG, "post result=" + result.length());
                    }

                    ;
                }.start();
                break;

            default:
                break;
        }

    }
}
