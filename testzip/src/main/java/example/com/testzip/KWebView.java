package example.com.testzip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by general on 09/04/2018.
 */

public class KWebView extends WebView {

    private static final String TAG = "KWebView";
    private WebViewUiCallback mUiCallback;
    private AtomicBoolean mErrorResultReceived = new AtomicBoolean(false);

    public KWebView(Context context) {
        this(context, null);
    }

    public KWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!needCache()) {
            clearView();
            clearCache(true);
            clearHistory();
            removeAllViews();
        }
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setMapTrackballToArrowKeys(false);
        setScrollBarStyle(SCROLLBARS_OUTSIDE_OVERLAY);

        WebSettings settings = getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true); // 设置是否支持JavaScript
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT); // 设置缓冲模式

        PackageManager pm = getContext().getPackageManager();
        boolean supportsMultiTouch = pm.hasSystemFeature(PackageManager
                .FEATURE_TOUCHSCREEN_MULTITOUCH)
                || pm.hasSystemFeature(PackageManager.FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT);
        settings.setDisplayZoomControls(!supportsMultiTouch);


        settings.setBlockNetworkImage(false);
        settings.setNeedInitialFocus(false);
        settings.setEnableSmoothTransition(true);
        settings.setAllowContentAccess(false);

        settings.setAppCacheEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);

        enableCrossDomain(settings);

        if (shouldDisableHardwareRenderInLayer() && Build.VERSION.SDK_INT >= 11) {
            try {
                setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setWebChromeClient(new KWebChromeClient());
        setWebViewClient(new KWebViewClient());
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void enableCrossDomain(WebSettings webSettings) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                webSettings.setAllowUniversalAccessFromFileURLs(true);
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
            }

            Class<?> clazz = webSettings.getClass();
            Method allowUniversalAccessMethod = clazz.getMethod
                    ("setAllowUniversalAccessFromFileURLs", boolean.class);
            if (allowUniversalAccessMethod != null) {
                allowUniversalAccessMethod.invoke(webSettings, true);
            }

            Method method = clazz.getMethod("setMixedContentMode", int.class);
            if (null != method) {
                method.invoke(webSettings, 0);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void releaseWebViewCallback() {
        loadUrl("about:blank");
        if (Build.VERSION.SDK_INT < 16) {
            try {
                Field field = WebView.class.getDeclaredField("mWebViewCore");
                field = field.getType().getDeclaredField("mBrowserFrame");
                field = field.getType().getDeclaredField("sConfigCallback");
                field.setAccessible(true);
                field.set(null, null);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        } else {
            try {
                Field sConfigCallback = Class.forName("android.webkit.BrowserFrame")
                        .getDeclaredField("sConfigCallback");
                if (sConfigCallback != null) {
                    sConfigCallback.setAccessible(true);
                    sConfigCallback.set(null, null);
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public boolean needCache() {
        return false;
    }

    private static boolean shouldDisableHardwareRenderInLayer() {
        // case 1: samsung GS4 on android 4.3 is know to cause crashes at libPowerStretch.so:0x2d4c
        // use GT-I95xx to match more GS4 series devices though GT-I9500 is the typical device
        final boolean isSamsungGs4 = Build.MODEL != null && Build.MODEL.contains("GT-I95")
                && Build.MANUFACTURER != null && Build.MANUFACTURER.equals("samsung");
        final boolean isJbMr2 = Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN_MR2;
        return isSamsungGs4 && isJbMr2;
    }

    public void setWebViewUiCallback(WebViewUiCallback callback) {
        this.mUiCallback = callback;
    }

    private class KWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.e("KWebView", url);
            if (mUiCallback != null) {
                return mUiCallback.onShouldOverrideUrlLoading(url) ? true : super
                        .shouldOverrideUrlLoading(view, url);
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            if (mUiCallback != null) {
                mUiCallback.onStartLoading(url);
            }
            mErrorResultReceived.set(false);
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (mUiCallback != null) {
                mUiCallback.onHideLoading(!mErrorResultReceived.get());
                mUiCallback.onReceivedTitle(view.getTitle());
                if (!view.canGoBack()) {
                    mUiCallback.onHideCloseBtn();
                } else {
                    mUiCallback.onShowCloseBtn();
                }
            }
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String
                failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            Log.e(TAG, "onReceivedError>>failingUrl:" + failingUrl);

            if (mUiCallback != null) {
                if (mErrorResultReceived.compareAndSet(false, true)) {
                    mUiCallback.onLoadError();
                }
                mUiCallback.onHideLoading(!mErrorResultReceived.get());
            }
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            /*
                重要提示：

                当访问https的网址时，浏览器会与服务器进行证书验证，以通过第三方机构证明，你将访问的网站是一个有效网站。
                由于某些原因（譬如12306）使用一些自有机构的证书，不能通过chrome证书验证，当发现这种证书错误的时候，
                此函数被调用。

                针对于这种证书错误问题，可以通过handler接口的两个函数去处理proceed（），忽略证书验证结果，继续访问，
                用户可能进一步访问内容，不受证书影响。cancel（）阻止用户继续访问，用户行为被打断。

                从以上的描述中，我们可能认为调用proceed()是最佳选择，但是，这种方式存在很大的风险。在某一个小区域内
                比如网吧、公共上网场所，某一重要域名被非法网站劫持，非法网站可以冒充正规网站内容，但是对于第三方证书束手无策
                ，chrome可以通过证书机制，发现非法网站，并调用此方法，然而，如果我们简单的使用proceed（），忽视这种
                风险，就会给用户带来损失。

                目前的解决方案是，向用户弹出提示框，用户确认后可继续访问。
                 */
            Log.e(TAG, "onReceivedSslError>> handler = " + handler);
//            com.ksmobile.launcher.webview.SafeSslErrorHandler.getInstance().onReceivedSslError
//                    (handler, error, getContext());
        }
    }


    private class KWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (mUiCallback != null) {
                mUiCallback.onProgressChanged(newProgress);
            }
        }

        @Override
        public void onCloseWindow(WebView window) {
            super.onCloseWindow(window);

            if (mUiCallback != null) {
                mUiCallback.onFinish();
            }
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            if (mUiCallback != null) {
                mUiCallback.onReceivedTitle(title);
            }
        }
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        if (mUiCallback instanceof WebViewUiCallBackForYoutube) {
            WebViewUiCallBackForYoutube youtube = (WebViewUiCallBackForYoutube) mUiCallback;
            youtube.onDetachedFromWindow();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mUiCallback instanceof WebViewUiCallBackForYoutube) {
            WebViewUiCallBackForYoutube youtube = (WebViewUiCallBackForYoutube) mUiCallback;
            youtube.onAttachedToWindow();
        }
    }

    public interface WebViewUiCallback {

        void onHideLoading(boolean success);

        void onStartLoading(String url);

        void onReceivedTitle(String title);

        void onFinish();

        void onProgressChanged(int newProgress);

        void onShowCloseBtn();

        void onHideCloseBtn();

        void onLoadError();

        boolean onShouldOverrideUrlLoading(String url);
    }

    public interface WebViewUiCallBackForYoutube extends WebViewUiCallback {
        void onAttachedToWindow();

        void onDetachedFromWindow();
    }
}
