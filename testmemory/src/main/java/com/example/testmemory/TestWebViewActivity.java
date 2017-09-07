
package com.example.testmemory;

import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import android.webkit.JavascriptInterface;

public class TestWebViewActivity extends Activity implements
        SensorEventListener {
    private WebView myWebView = null;
    private static final String TAG = "TestWebViewActivity";
    private Button myButton = null;
    private View view;
    private ViewStub viewstub;
    private FrameLayout mLinear;
    int w = 97;
    int h = 53;
    private ImageView imageView;
    private static TestWebViewActivity sInstance;
    String path3 = "http://10.58.93.48:8080/video/8.mp4";
    String path4 = "http://g3.letv.com/vod/v1/MTMwLzEzLzkyL2xldHYtZ3VnLzE3L3Zlcl8wMF8yMi0zMzE5NDY2MS1hdmMtNTcwMDQ2LWFhYy02NDMzNi0xNDk2MC0xMjExMDAxLTZlNjM3YWY0Yzk0MDcwZTA2MGE5MDdhMzgwMTgwZmM1LTE0MjY0ODYzMDMzNzgubXA0?platid=100&splatid=10000&gugtype=1&mmsid=28125503&type=m_gaoqing_mp4&playid=0&termid=2&pay=0&hwtype=MX4_Pro&ostype=android";
    String path5 = "http://g3.letv.com/vod/v1/MTEzLzI0LzMvbGV0di1ndWcvMTcvdmVyXzAwXzIyLTMzMTk0MTA3LWF2Yy01OTk5MzEtYWFjLTY0MTczLTI5OTYwLTI1MzM3NjYtNWRkZGIwZThjOGE3OWFhMjA5ZGVlOTA2ZGIwODQyN2QtMTQyNTUzNzkwMTc2MC5tcDQ=?platid=100&splatid=10000&gugtype=1&mmsid=27641072&type=m_gaoqing_mp4";
    String path6 = "http://123.125.89.62/130/13/92/letv-gug/17/ver_00_22-33194661-avc-570046-aac-64336-14960-1211001-6e637af4c94070e060a907a380180fc5-1426486303378.letv?crypt=26aa7f2e131400&b=1314&nlh=3072&nlt=45&bf=8000&p2p=1&video_type=mp4&termid=2&tss=no&geo=CN-1-9-2&platid=100&splatid=10000&its=0&qos=5&proxy=1981430583,1981430583,2007471094&keyitem=rxWmhiz4nvsenbC4B_PU1Ho7JhJWOKmfhaz0NA..&ntm=1474451400&nkey=80ba06db8c0c06bbb10f712211e87a0c&nkey2=8dbe42662441cc7c2cfed3b2bf1b227b&mltag=1&gugtype=1&mmsid=28125503&type=m_gaoqing_mp4&playid=0&pay=0&hwtype=MX4_Pro&ostype=android&errc=0&gn=706&buss=1&cips=10.58.93.22";
    String path7 = "http://123.125.89.54/130/13/92/letv-gug/17/ver_00_22-33194661-avc-570046-aac-64336-14960-1211001-6e637af4c94070e060a907a380180fc5-1426486303378.letv?crypt=26aa7f2e131400&b=1314&nlh=3072&nlt=45&bf=8000&p2p=1&video_type=mp4&termid=2&tss=no&geo=CN-1-9-2&platid=100&splatid=10000&its=0&qos=5&proxy=1981430583,1981430583,2007471094&keyitem=rxWmhiz4nvsenbC4B_PU1Ho7JhJWOKmfhaz0NA..&ntm=1474451400&nkey=80ba06db8c0c06bbb10f712211e87a0c&nkey2=8dbe42662441cc7c2cfed3b2bf1b227b&mltag=1&gugtype=1&mmsid=28125503&type=m_gaoqing_mp4&playid=0&pay=0&hwtype=MX4_Pro&ostype=android&errc=0&gn=706&buss=1&cips=10.58.93.22";

    @Override
    public void onAttachedToWindow() {
        // TODO Auto-generated method stub
        super.onAttachedToWindow();
        // final View view = getWindow().getDecorView();
        // final WindowManager.LayoutParams lp = (WindowManager.LayoutParams)
        // view
        // .getLayoutParams();
        //
        // lp.gravity = Gravity.CENTER;
        //
        // lp.width = 250;
        // lp.height = 250;
        // getWindowManager().updateViewLayout(view, lp);
    }

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onStart()
     */
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myWebView != null) {
            myWebView.setDownloadListener(null);
            myWebView.setWebChromeClient(null);
            myWebView.setWebViewClient(null);
            myWebView.stopLoading();
            /**
             * 3.0以上系统编译，如果不隐藏webview会出现崩溃
             */
            // the WebView must be removed from the view hierarchy before calling destroy
            // to prevent a memory leak (#75)
            // See https://developer.android.com/reference/android/webkit/WebView
            // .html#destroy()
            ViewParent viewParent = myWebView.getParent();
            if (null != viewParent && viewParent instanceof ViewGroup) {
                ((ViewGroup) viewParent).removeView(myWebView);
            }
            myWebView.removeAllViews();
            myWebView.setVisibility(View.GONE);
            myWebView.destroy();
            myWebView = null;
        }
//         myWebView.destroy();
        // android.widget.ZoomButtonsController
        // myWebView.getSettings().setBuiltInZoomControls(false);
        // myWebView.getSettings().setDisplayZoomControls(false);
        // myWebView.setVisibility(View.GONE);// 把destroy()延后
        // ViewGroup view = (ViewGroup) getWindow().getDecorView();
        // view.removeAllViews();
//        myWebView.destroy();
        long timeout = ViewConfiguration.getZoomControlsTimeout();
        // System.out.println("time==" + timeout);
        Log.d(TAG, "onDestroy timeout=" + timeout);
        // new Timer().schedule(new TimerTask() {
        // @Override
        // public void run() {
        // Log.d(TAG, "destroy");
        // // TODO Auto-generated method stub
        // myWebView.destroy();
        // }
        // }, timeout);
    }

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onStop()
     */
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        Log.d(TAG, "onStop");
    }

    public static TestWebViewActivity getInstance() {
        if (sInstance == null) {
            synchronized (TestWebViewActivity.class) {
                if (sInstance == null)
                    sInstance = new TestWebViewActivity();
            }
        }
        return sInstance;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);
        boolean isLandScape = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE;
        Log.d(TAG, "onConfigurationChanged isLandScape=" + isLandScape);
    }

    /**
     * */
    public int getScreenWidth() {
        return ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay().getWidth();
    }

    /**
     * */
    public int zoomWidth(int w) {
        int sw = 0;
        sw = getScreenWidth();

        return (int) (w * sw / 320f + 0.5f);
    }

    public void zoomyWebView(int w, int h, String url) {
        int width = zoomWidth(w);
        int height = zoomWidth(h);
        String html = "<p><img src=\"" + url + "\" width=\"" + width + "\""
                + "\" height=\"" + height + "\"/></p>";
        Log.d(TAG, "zoomView html=" + html);
        // myWebView.loadDataWithBaseURL("", html, "text/html", "UTF-8", "");
        // myWebView.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.GONE);
    }

    /**
     * */
    public void zoomView(int w, int h, View view) {
        TextView textView = new TextView(this);
        // textView.setTextSize(size);
        view.setScaleX((float) 0.5);
        view.setScaleY((float) 0.5);
        // AsyncTask<Params, Progress, Result>
        if (view == null) {
            return;
        }

        LayoutParams params = view.getLayoutParams();

        if (params == null) {
            return;
        }
        // String imageUrl =
        // "http://b.hiphotos.baidu.com/zhidao/pic/item/0b46f21fbe096b63bfbe97970d338744eaf8ac56.jpg";
        // String imageUrl = "http://www.51cto.com/";
        // params.width = w;
        // params.height = h;
        // view.setlayoupargms(new LayoutParams(w, h));
        // myWebView.setLayoutParams(new LayoutParams(w, h));
        // view.requestLayout();
        // view.invalidate();
        // String html = "<p><img src=\"" + imageUrl + "\" width=\""
        // + params.width + "\"" + "\" height=\"" + params.height
        // + "\"/></p>";
        // Log.d(TAG, "zoomView html=" + html);
        // myWebView.loadDataWithBaseURL("", html, "text/html", "UTF-8", "");
        // myWebView.setScaleX((float) 1);
        // myWebView.setScaleY((float) 1);
    }

    private class LetvWebViewClient extends WebViewClient {

        /*
         * (non-Javadoc)
         * @see
         * android.webkit.WebViewClient#onReceivedError(android.webkit.WebView,
         * int, java.lang.String, java.lang.String)
         */
        @Override
        public void onReceivedError(WebView view, int errorCode,
                String description, String failingUrl) {
            // TODO Auto-generated method stub

            super.onReceivedError(view, errorCode, description, failingUrl);
            // view.stopLoading();
            Log.d(TAG, "onReceivedError  errorCode=" + errorCode
                    + " description=" + description + " failingUrl="
                    + failingUrl);
        }

        // @Override
        // public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // view.loadUrl(url);
        // return false;
        // }

        /*
         * (non-Javadoc)
         * @see
         * android.webkit.WebViewClient#shouldOverrideUrlLoading(android.webkit
         * .WebView, java.lang.String)
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            boolean result = true;
            result = super.shouldOverrideUrlLoading(view, url);
            Log.d(TAG, "shouldOverrideUrlLoading result=" + result + " url="
                    + url);
            // view.loadUrl(url);

            return result;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            Log.d(TAG, "onPageStarted url=" + url);
        }

        // @Override
        // public void onLoadResource(WebView view, String url) {
        // // TODO Auto-generated method stub
        // super.onLoadResource(view, url);
        // Log.d(TAG, "onLoadResource url=" + url);
        // }

        public void onPageFinished(WebView view, String url) {
            Log.d(TAG, "onPageFinished url=" + url);
            // view.loadUrl("javascript:window.local_obj.showSource('<head>'+"
            // +
            // "document.getElementsByTagName('html')[0].innerHTML+'</head>');");
            super.onPageFinished(view, url);
            // view.getSettings().setBlockNetworkImage(false);s
        }
    }

    private class LetvWebViewChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            Log.d(TAG, "onProgressChanged  newProgress=" + newProgress);
        }

    }

    private SensorManager mSensorManager;

    // @SuppressLint("SetJavaScriptEnabled")
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_js);
        // List<UserInfo> list = new ArrayList<UserInfo>();
        // UserInfo user = new UserInfo(1001, "张三");
        // UserInfo user1 = new UserInfo(1002, "李四");
        // list.add(user);
        // list.add(user1);
        HashMap<String, Object> deviceInfo = new HashMap<String, Object>();
        deviceInfo.put("pversion", "001");
        deviceInfo.put("type", "Phone");
        deviceInfo.put("values", new int[] {
                1, 2, 3
        });
        // list.add(user);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(deviceInfo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.d(TAG, "onCreate e=" + e.toString());
        }
        // System.out.println(jsonArray);
        Log.d(TAG, "onCreate jsonObject=" + jsonObject);
        JSONArray array = null;
        try {
            array = jsonObject.getJSONArray("values");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.d(TAG, "onCreate e111=" + e.toString());
        }
        Log.d(TAG, "onCreate array=" + array);
        // Log.d(TAG, "onCreate user1=" + user1);
        mSensorManager = (SensorManager) getApplicationContext()
                .getSystemService(Context.SENSOR_SERVICE);
        // 得到手机上所有的传感器
        List<Sensor> listSensor = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        int i = 1;
        // for (Sensor sensor : listSensor) {
        // Log.d(TAG, sensor.getName());
        // Log.d(TAG, sensor.getVendor());
        // Log.d(TAG, "" + sensor.getType());
        // }
        myWebView = (WebView) findViewById(R.id.myWebView);
        mLinear = (FrameLayout) findViewById(R.id.liner);
        // myWebView = new AdWebView(getApplicationContext());
        // // zoomView(247, 243, mLinear);
        WebSettings webSettings = myWebView.getSettings();
        // myWebView.clearCache(false);
        // webSettings.setSupportZoom(true);
        // webSettings.setBuiltInZoomControls(true);
        // myWebView.setVerticalScrollBarEnabled(true);
        // myWebView.setHorizontalScrollBarEnabled(true);
        // 支持javascript
        myWebView.getSettings().setJavaScriptEnabled(true);
        // 自适应屏幕
        // myWebView.getSettings().setLayoutAlgorithm(
        // LayoutAlgorithm.SINGLE_COLUMN);
        // myWebView.getSettings().setLoadWithOverviewMode(true);
        // webSettings.setJavaScriptEnabled(true);
        // webSettings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        // myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new LetvWebViewClient());
        myWebView.setWebChromeClient(new LetvWebViewChromeClient());
        // webSettings.setBlockNetworkLoads(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setSaveFormData(false);
        // webSettings.setUseWideViewPort(true);

        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        // webSettings.setDomStorageEnabled(true);
        // webSettings.setBlockNetworkImage(true);
        // webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        // myWebView.addJavascriptInterface(new WebAppInterface(this),
        // "myInterfaceName");
        String dir = this.getApplicationContext()
                .getDir("cache", Context.MODE_PRIVATE).getPath();
                // webSettings.setAppCacheEnabled(true);
                // webSettings.setDatabaseEnabled(true);
                // 设置应用缓存的路径
                // webSettings.setAppCachePath(dir);
                // 设置缓存的模式
                // webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                // 设置应用缓存的最大尺寸
                // webSettings.setAppCacheMaxSize(1024 * 1024 * 8);

        // String appCachePath = getApplicationContext().getCacheDir()
        // .getAbsolutePath();
        String appCachePath = Environment.getExternalStorageDirectory()
                .getPath() + "/web_cache/";
        Log.d(TAG, "onCreate webSettings=" + webSettings);
        Log.d(TAG, "onCreate getDatabasePath=" + webSettings.getDatabasePath());
        // webSettings.setAllowFileAccess(true);
        // webSettings.setAppCachePath(appCachePath);
        Log.d(TAG, "onCreate DatabasePath=" + webSettings.getDatabasePath());
        Log.d(TAG, "onCreate dir=" + dir);
        // webSettings.setDefaultTextEncodingName("GBK");

        // Log.d(TAG, "onCreate url=" + myWebView.getSettings().getCacheMode());
        String imageUrl = "http://b.hiphotos.baidu.com/zhidao/pic/item/0b46f21fbe096b63bfbe97970d338744eaf8ac56.jpg";
        String url20 = "file:///android_asset/a.gif";
        String url21 = "file:///android_asset/b.png";
        String url22 = "http://img5.duitang.com/uploads/blog/201405/26/20140526130452_yJXw5.thumb.600_0.gif";
        String url23 = "http://create.maka.im/k/1AKD5H8C";
        String url244 = "http://c.admaster.com.cn/c/a56535,b627510,c1066,i0,m101,h";
        String url25 = "http://game1.plant.e2capp.com/show/wx?from=groupmessage&isappinstalled=0";
        String url26 = "http://www.html5tricks.com/demo/html5-svg-shanche-animation/index.html";
        String url27 = "http://x.jd.com/exsites?spread_type=2&ad_ids=604:5&location_info=0&callback=getjjsku_callback";
        String tm = "http://ark.letv.com/t?mid=797049&rt=2&oid=96928&im=1&cuid=f1034549a7cdee344d01783dd21e827f&t=1446705522&data=63%2C1156110000%2C200%2Cf1034549a7cdee344d01783dd21e827f_1446705378226%2C7688%2C2119151%2C93235%2C2%2C1%2C6%2C010110000%2C%2C0%2C1446705522%2C0%2Candroid_6000&s=dc8f&u=https%3A%2F%2Fleshitv.m.tmall.com%2F";
        String tm1 = "http://tb.cn/YwY2Jlx?tm=c73d6d";
        String tm2 = "https://leshitv.m.tmall.com/";
        String tm3 = "http://www.c-i-m.com.cn/cm/zed20151112/m?utm_source=LETV";
        String tm4 = "tmall://page.tm/webview?url=http://baron.laiwang.com/mobile/page/llb?shareid=8437246&_bind=true&asac=D5JJFW716103XOLRS2OX&lpid=63211&lpt=1&lsid=217101303&ut_sk=1.VgFs+miUuMMDANOACl3rr5PN_21380790_1446533364.Copy.1&ut_sk=1.VgFs+miUuMMDANOACl3rr5PN_21380790_1446533364.Copy.1&sourceType=item&sourceType=item&price=47.6&price=47.6&un=0b9a89333cd5c94a4b68d5f77a161062&un=0b9a89333cd5c94a4b68d5f77a161062&share_crt_v=1&share_crt_v=1&cpp=1&cpp=1&short_name=h.1Jplg&short_name=h.1Jplg&sm=1d99cd&sm=1d99cd&app=chrome&app=chrome&mt=&mt=&id=522683656907&_reqfrom=other&_ns=1&ut_sk=1.VgFs+miUuMMDANOACl3rr5PN_21380790_1446533364.Copy.1";
//        myWebView.loadUrl(
//                "http://ark.letv.com/t?mid=11036&rt=2&oid=7&im=1&cuid=3a4ab747cf1e86f88e4b3759d8027893&t=1448553003&data=64%2C1156110000%2C200%2C3a4ab747cf1e86f88e4b3759d8027893_1448553000215%2C6%2C21004542%2C93327%2C2%2C2%2C2%2C010110000%2C%2C1%2C1448553003%2C0%2Candroid_6100%2C%2C0&s=a45b&u=https%3A%2F%2Fleshitv.m.tmall.com%2F");
        myWebView.loadUrl("http://www.2345.com");
    }

    // private Handler mHandler = new Handler() {
    // public void handleMessage(android.os.Message msg) {
    // String url20 = "file:///android_asset/a.gif";
    // if (myWebView.getWidth() > 0) {
    // String html = "<p><img src=\"" + url20 + "\" width=\"" + 1080
    // + "\"" + "\" height=\"" + 1555 + "\"/></p>";
    // Log.d(TAG, "zoomView html=" + html);
    // Log.d(TAG, "handleMessage w=" + myWebView.getWidth() + " h="
    // + myWebView.getHeight());
    // myWebView.loadDataWithBaseURL("", html, "text/html", "UTF-8",
    // "");
    // } else {
    // mHandler.sendEmptyMessageDelayed(0, 300);
    // }
    // };
    // };

    final class InJavaScriptLocalObj {
        public void showSource(String html) {
            Log.d(TAG, "showSource=" + html);
        }
    }

    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        // myWebView.getSettings().setCacheMode(
        // WebSettings.LOAD_CACHE_ELSE_NETWORK);
        // mSensorManager.unregisterListener(this);
        // mSensorManager.unregisterListener(this);
        // mSensorManager.unregisterListener(this);
        // mSensorManager.unregisterListener(this);
        // mLinear.removeView(adWebView1);
        // mLinear.setVisibility(View.GONE);
        // adWebView1.setVisibility(View.GONE);
        // myWebView
        // .loadUrl("http://img5.duitang.com/uploads/blog/201405/26/20140526130452_yJXw5.thumb.600_0.gif");
    }

    private int w1 = 200;
    private int h1 = 200;

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onBackPressed()
     */
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        // mLinear.removeAllViews();
        // if (myWebView instanceof AdWebView) {
        // // ((AdWebView)myWebView).reload();
        // ((AdWebView) myWebView).vibrator();
        // }
        // myWebView.removeAllViews();
        w1 += 100;
        h1 += 100;
        // myWebView.setVisibility(View.GONE);
        // mLinear.removeAllViews();
        // zoomView(800, 400, mLinear);
        // mLinear.addView(myWebView);
        // boolean result = myWebView.zoomOut();
        // Log.d(TAG, "onBackPressed result=" + result);
        // myWebView.reload();
        // myWebView.removeAllViewsInLayout();
        // myWebView.refreshDrawableState();
        // myWebView.loadUrl("about:blank");
        // myWebView.zoomIn();
        // myWebView.r
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Log.d(TAG,"DalvikMaxHeapSize : "+(Runtime.getRuntime().maxMemory()/(1024* 1024))+ "MB");

        Log.d(TAG,"AllocatedHeapSize : "+(Debug.getNativeHeapAllocatedSize()/(1024* 1024))+ "MB");
        Log.d(TAG,"getNativeHeapFreeSize : "+(Debug.getNativeHeapFreeSize()/(1024* 1024))+ "MB");
        Log.d(TAG,"getPss : "+(Debug.getPss()/(1024* 1024))+ "MB");
        String url27 = "http://x.jd.com/exsites?spread_type=2&ad_ids=604:5&location_info=0&callback=getjjsku_callback";
        // myWebView.loadUrl(url27);
        // myWebView.loadUrl("http://www.22222.com");
        // 加速度传感器
        // mSensorManager.registerListener(this,
        // mSensorManager.getDefaultSensor(Sensor.TYPE_ALL),
        // // 还有SENSOR_DELAY_UI、SENSOR_DELAY_FASTEST、SENSOR_DELAY_GAME等，
        // // 根据不同应用，需要的反应速率不同，具体根据实际情况设定
        // SensorManager.SENSOR_DELAY_UI);
        // mSensorManager.registerListener(this,
        // mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
        // // 还有SENSOR_DELAY_UI、SENSOR_DELAY_FASTEST、SENSOR_DELAY_GAME等，
        // // 根据不同应用，需要的反应速率不同，具体根据实际情况设定
        // SensorManager.SENSOR_DELAY_UI);
        // mSensorManager.registerListener(this,
        // mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR),
        // // 还有SENSOR_DELAY_UI、SENSOR_DELAY_FASTEST、SENSOR_DELAY_GAME等，
        // // 根据不同应用，需要的反应速率不同，具体根据实际情况设定
        // SensorManager.SENSOR_DELAY_UI);
        // Log.d(TAG, "onResume visible=" + adWebView1.getVisibility());
        // Log.d(TAG, "onResume getParent=" + adWebView1.getParent());
        // Exception exception = new Exception("onResume()onResume()");
        // Log.d(TAG, "onResume getParent=" + exception);
        // myWebView.setVisibility(View.VISIBLE);
    }

    static class UserInfo {
        int useId;
        String name;

        public int getUseId() {
            return useId;
        }

        public String getName() {
            return name;
        }

        public UserInfo(int useId, String name) {
            this.useId = useId;
            this.name = name;
        }

        /*
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return useId + name;
        }
    }

    /**
     * @author 1
     */
    public class WebAppInterface {
        Context mContext;

        /**
         * Instantiate the interface and set the context
         */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /**
         * Show a toast from the web page
         */
        public void showToast(String toast) {
            Log.d(TAG, "showToast toast=" + toast);
            // Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
            Toast.makeText(mContext, toast, Toast.LENGTH_LONG).show();
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * android.hardware.SensorEventListener#onSensorChanged(android.hardware
     * .SensorEvent)
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d(TAG, "onSensorChanged event.accuracy=" + event.accuracy
                + " Type=" + event.sensor.getType());
        for (float f : event.values) {
            Log.d(TAG, "onSensorChanged  values f=" + f);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d(TAG,
                "onAccuracyChanged accuracy=" + accuracy + " type="
                        + sensor.getType());
    }

}
