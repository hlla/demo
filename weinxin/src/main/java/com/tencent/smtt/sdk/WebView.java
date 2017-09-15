package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.sdk.a.c;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.r;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WebView
  extends FrameLayout
  implements View.OnLongClickListener
{
  public static final int GETPVERROR = -1;
  public static int NIGHT_MODE_ALPHA = 153;
  public static final int NIGHT_MODE_COLOR = -16777216;
  public static final int NORMAL_MODE_ALPHA = 255;
  public static final String SCHEME_GEO = "geo:0,0?q=";
  public static final String SCHEME_MAILTO = "mailto:";
  public static final String SCHEME_TEL = "tel:";
  public static boolean mSysWebviewCreated;
  private static Context ty;
  private static BroadcastReceiver wUF;
  private static r wUG;
  private static Method wUH;
  private static String wUI;
  private static Paint wUO;
  private static boolean wUP;
  private static final Lock wUv = new ReentrantLock();
  private static OutputStream wUw = null;
  private final String DU = "WebView";
  private WebViewClient ixf = null;
  private WebChromeClient jcW = null;
  private Context mContext = null;
  public ab mWebViewCallbackClient;
  private WebSettings wUA = null;
  int wUB = 0;
  private boolean wUC = false;
  private o wUD = null;
  private boolean wUE = false;
  private final int wUJ = 1;
  private final int wUK = 2;
  private final int wUL = 3;
  private final String wUM = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
  private final String wUN = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
  private Object wUQ = null;
  private View.OnLongClickListener wUR = null;
  boolean wUx = false;
  IX5WebViewBase wUy;
  SystemWebView wUz;
  
  static
  {
    ty = null;
    wUF = null;
    wUG = null;
    wUH = null;
    wUI = null;
    mSysWebviewCreated = false;
    wUO = null;
    wUP = true;
  }
  
  public WebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, false);
  }
  
  @TargetApi(11)
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, Map<String, Object> paramMap, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if ((QbSdk.getIsSysWebViewForcedByOuter()) && (t.gu(paramContext)))
    {
      this.mContext = paramContext;
      this.wUy = null;
      this.wUx = false;
      QbSdk.bu(paramContext, "failed to createTBSWebview!");
      this.wUz = new SystemWebView(paramContext, paramAttributeSet);
      CookieManager.getInstance().n(paramContext, false);
      CookieSyncManager.createInstance(this.mContext).startSync();
    }
    try
    {
      paramAttributeSet = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
      paramAttributeSet.setAccessible(true);
      ((Handler)paramAttributeSet.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
      mSysWebviewCreated = true;
      CookieManager.getInstance().cdE();
      this.wUz.setFocusableInTouchMode(true);
      addView(this.wUz, new FrameLayout.LayoutParams(-1, -1));
      TbsLog.i("WebView", "SystemWebView Created Success! #3");
      TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
      i.cdS().a(paramContext, 402, new Throwable());
      for (;;)
      {
        return;
        if (t.gu(paramContext)) {
          TbsLog.setWriteLogJIT(true);
        }
        for (;;)
        {
          this.wUD = new o();
          this.wUD.al("free_ram_begin", a.fC(paramContext));
          this.wUD.a("init_all", (byte)1);
          this.wUD.a("tbslog_init", (byte)1);
          TbsLog.initIfNeed(paramContext);
          this.wUD.a("tbslog_init", (byte)2);
          if (paramContext != null) {
            break;
          }
          throw new IllegalArgumentException("Invalid context argument");
          TbsLog.setWriteLogJIT(false);
        }
        if (wUG == null) {
          wUG = r.ha(paramContext);
        }
        if (wUG.wWw)
        {
          TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
          QbSdk.bu(paramContext, "debug.conf force syswebview!");
        }
        b(paramContext, this.wUD);
        this.mContext = paramContext;
        if (paramContext != null) {
          ty = paramContext.getApplicationContext();
        }
        if ((this.wUx) && (!QbSdk.wQZ))
        {
          this.wUD.a("init_x5_webview", (byte)1);
          this.wUy = ac.ceR().wUU.gG(paramContext);
          this.wUD.a("init_x5_webview", (byte)2);
          if ((this.wUy == null) || (this.wUy.getView() == null))
          {
            TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
            this.wUy = null;
            this.wUx = false;
            QbSdk.bu(paramContext, "failed to createTBSWebview!");
            b(paramContext, this.wUD);
            if (t.gu(this.mContext))
            {
              this.wUz = new SystemWebView(paramContext, paramAttributeSet);
              label563:
              TbsLog.i("WebView", "SystemWebView Created Success! #1");
              CookieManager.getInstance().n(paramContext, false);
              CookieManager.getInstance().cdE();
              this.wUz.setFocusableInTouchMode(true);
              addView(this.wUz, new FrameLayout.LayoutParams(-1, -1));
            }
          }
        }
        try
        {
          if (Build.VERSION.SDK_INT >= 11)
          {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
          }
          gA(paramContext);
          TbsLog.writeLogToDisk();
          p.fS(paramContext);
          return;
          this.wUz = new SystemWebView(paramContext);
          break label563;
          TbsLog.i("WebView", "X5 WebView Created Success!!");
          this.wUy.getView().setFocusableInTouchMode(true);
          e(paramAttributeSet);
          addView(this.wUy.getView(), new FrameLayout.LayoutParams(-1, -1));
          this.wUy.setDownloadListener(new b(this, null));
          paramMap = this.wUy.getX5WebViewExtension();
          paramAttributeSet = ac.ceR().wUU.wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
          if (paramAttributeSet == null)
          {
            paramAttributeSet = null;
            label778:
            paramMap.setWebViewClientExtension(new X5ProxyWebViewClientExtension(paramAttributeSet)
            {
              public void invalidate() {}
              
              public void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
              {
                super.onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
                WebView.a(WebView.this, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt1, paramAnonymousInt2);
              }
            });
          }
          try
          {
            if (Build.VERSION.SDK_INT >= 11)
            {
              removeJavascriptInterface("searchBoxJavaBridge_");
              removeJavascriptInterface("accessibility");
              removeJavascriptInterface("accessibilityTraversal");
            }
            if (("com.tencent.mobileqq".equals(this.mContext.getApplicationInfo().packageName)) || ("com.tencent.mm".equals(this.mContext.getApplicationInfo().packageName)))
            {
              d.lY(true);
              if ((d.useSoftWare()) && (Build.VERSION.SDK_INT >= 11)) {
                setLayerType(1, null);
              }
            }
            if (this.wUD != null) {
              this.wUD.a("load_url_gap", (byte)1);
            }
            if (this.wUy == null) {
              continue;
            }
            TbsLog.writeLogToDisk();
            if (t.gu(paramContext)) {
              continue;
            }
            paramInt = k.fM(paramContext).wSA.getInt("tbs_decouplecoreversion", 0);
            if (paramInt > 0)
            {
              p.ceq();
              if ((paramInt != p.gb(paramContext)) && (paramInt == p.ceq().gc(paramContext)))
              {
                p.ceq().gg(paramContext);
                return;
                paramAttributeSet = (IX5WebViewClientExtension)paramAttributeSet;
                break label778;
                this.wUy = null;
                if (t.gu(this.mContext)) {}
                for (this.wUz = new SystemWebView(paramContext, paramAttributeSet);; this.wUz = new SystemWebView(paramContext))
                {
                  TbsLog.i("WebView", "SystemWebView Created Success! #2");
                  CookieManager.getInstance().n(paramContext, false);
                  CookieManager.getInstance().cdE();
                  this.wUz.setFocusableInTouchMode(true);
                  addView(this.wUz, new FrameLayout.LayoutParams(-1, -1));
                  setDownloadListener(null);
                  gA(paramContext);
                  TbsLog.writeLogToDisk();
                  p.fS(paramContext);
                  break;
                }
              }
            }
            paramAttributeSet = new StringBuilder("webview construction #1 deCoupleCoreVersion is ").append(paramInt).append(" getTbsCoreShareDecoupleCoreVersion is ");
            p.ceq();
            TbsLog.i("WebView", p.gb(paramContext) + " getTbsCoreInstalledVerInNolock is " + p.ceq().gc(paramContext));
            return;
          }
          catch (Throwable paramAttributeSet)
          {
            for (;;) {}
          }
        }
        catch (Throwable paramAttributeSet)
        {
          for (;;) {}
        }
      }
    }
    catch (Exception paramAttributeSet)
    {
      for (;;) {}
    }
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, paramInt, null, paramBoolean);
  }
  
  private void b(Context paramContext, o paramo)
  {
    if ((QbSdk.wRk) && (t.gu(paramContext))) {
      m.ceo().fR(paramContext);
    }
    if (paramo != null) {
      paramo.a("x5_core_engine_init_sync", (byte)1);
    }
    ac localac = ac.ceR();
    localac.b(paramContext, paramo);
    this.wUx = localac.ceS();
  }
  
  private static long ceL()
  {
    synchronized (QbSdk.wRj)
    {
      if (QbSdk.wRh)
      {
        QbSdk.sWifiConnectedTime += System.currentTimeMillis() - QbSdk.wRi;
        TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.sWifiConnectedTime);
      }
      long l = QbSdk.sWifiConnectedTime / 1000L;
      QbSdk.sWifiConnectedTime = 0L;
      QbSdk.wRi = System.currentTimeMillis();
      return l;
    }
  }
  
  static void ceM()
  {
    new Thread()
    {
      public final void run()
      {
        if (WebView.ceP() == null) {
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
        }
        int i;
        int j;
        do
        {
          return;
          d.lY(true);
          if (d.wRF)
          {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
            return;
          }
          j localj = j.fL(WebView.ceP());
          i = localj.Vl("install_status");
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + i);
          if (i == 2)
          {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
            d.Vk(String.valueOf(localj.Vm("install_core_ver")));
            d.cdK();
            return;
          }
          j = localj.Vl("copy_status");
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + j);
          if (j == 1)
          {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
            d.Vk(String.valueOf(localj.Vm("copy_core_ver")));
            d.cdK();
            return;
          }
        } while ((ac.ceR().ceS()) || ((i != 3) && (j != 3)));
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
        d.Vk(String.valueOf(d.cdJ()));
        d.cdK();
      }
    }.start();
  }
  
  private boolean dE(View paramView)
  {
    if ((this.mContext != null) && (getTbsCoreVersion(this.mContext) > 36200)) {
      return false;
    }
    paramView = com.tencent.smtt.utils.o.a(this.wUQ, "onLongClick", new Class[] { View.class }, new Object[] { paramView });
    if (paramView != null) {
      return ((Boolean)paramView).booleanValue();
    }
    return false;
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    if (!ac.ceR().ceS()) {
      com.tencent.smtt.utils.o.fl("android.webkit.WebView", "disablePlatformNotifications");
    }
  }
  
  private void e(AttributeSet paramAttributeSet)
  {
    int i = 0;
    if (paramAttributeSet != null) {
      try
      {
        int j = paramAttributeSet.getAttributeCount();
        while (i < j)
        {
          if (paramAttributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars"))
          {
            int[] arrayOfInt = getResources().getIntArray(16842974);
            int k = paramAttributeSet.getAttributeIntValue(i, -1);
            if (k == arrayOfInt[1])
            {
              this.wUy.getView().setVerticalScrollBarEnabled(false);
              this.wUy.getView().setHorizontalScrollBarEnabled(false);
            }
            else if (k == arrayOfInt[2])
            {
              this.wUy.getView().setVerticalScrollBarEnabled(false);
            }
            else if (k == arrayOfInt[3])
            {
              this.wUy.getView().setHorizontalScrollBarEnabled(false);
            }
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramAttributeSet) {}
    }
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    if (!ac.ceR().ceS()) {
      com.tencent.smtt.utils.o.fl("android.webkit.WebView", "enablePlatformNotifications");
    }
  }
  
  public static String findAddress(String paramString)
  {
    if (!ac.ceR().ceS()) {
      return android.webkit.WebView.findAddress(paramString);
    }
    return null;
  }
  
  private void gA(final Context paramContext)
  {
    if (wUF != null) {
      return;
    }
    wUF = new ConnectivityChangedReceiver(null);
    new Thread()
    {
      public void run()
      {
        try
        {
          if (com.tencent.smtt.utils.b.gN(paramContext) == 3) {}
          for (boolean bool = true;; bool = false)
          {
            QbSdk.wRh = bool;
            QbSdk.wRi = System.currentTimeMillis();
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            paramContext.getApplicationContext().registerReceiver(WebView.ceN(), localIntentFilter);
            return;
          }
          return;
        }
        catch (Throwable localThrowable) {}
      }
    }.start();
  }
  
  private static boolean gB(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageName().indexOf("com.tencent.mobileqq");
      if (i >= 0) {
        return true;
      }
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  /* Error */
  private static int gC(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: ldc_w 739
    //   5: invokestatic 744	com/tencent/smtt/utils/f:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   8: astore 5
    //   10: aload 5
    //   12: ifnull +15 -> 27
    //   15: aload 5
    //   17: invokestatic 747	com/tencent/smtt/utils/f:a	(Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   20: astore 6
    //   22: aload 6
    //   24: ifnonnull +5 -> 29
    //   27: iconst_m1
    //   28: ireturn
    //   29: getstatic 110	com/tencent/smtt/sdk/WebView:wUv	Ljava/util/concurrent/locks/Lock;
    //   32: invokeinterface 752 1 0
    //   37: ifeq +384 -> 421
    //   40: aconst_null
    //   41: astore 4
    //   43: aload_0
    //   44: ldc_w 754
    //   47: iconst_0
    //   48: invokevirtual 758	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   51: astore_0
    //   52: new 760	java/io/File
    //   55: dup
    //   56: new 559	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 761	java/lang/StringBuilder:<init>	()V
    //   63: aload_0
    //   64: invokevirtual 764	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: getstatic 767	java/io/File:separator	Ljava/lang/String;
    //   70: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 769
    //   76: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: ldc_w 771
    //   85: invokespecial 773	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 776	java/io/File:exists	()Z
    //   93: istore_2
    //   94: iload_2
    //   95: ifne +20 -> 115
    //   98: getstatic 110	com/tencent/smtt/sdk/WebView:wUv	Ljava/util/concurrent/locks/Lock;
    //   101: invokeinterface 779 1 0
    //   106: aload 6
    //   108: aload 5
    //   110: invokestatic 782	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   113: iconst_m1
    //   114: ireturn
    //   115: new 784	java/util/Properties
    //   118: dup
    //   119: invokespecial 785	java/util/Properties:<init>	()V
    //   122: astore 7
    //   124: new 787	java/io/FileInputStream
    //   127: dup
    //   128: aload_0
    //   129: invokespecial 790	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   132: astore_3
    //   133: aload_3
    //   134: astore_0
    //   135: aload 7
    //   137: aload_3
    //   138: invokevirtual 794	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   141: aload_3
    //   142: astore_0
    //   143: aload_3
    //   144: invokevirtual 797	java/io/FileInputStream:close	()V
    //   147: aload_3
    //   148: astore_0
    //   149: aload 7
    //   151: ldc_w 799
    //   154: invokevirtual 802	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 4
    //   159: aload 4
    //   161: ifnonnull +54 -> 215
    //   164: aload_3
    //   165: invokevirtual 797	java/io/FileInputStream:close	()V
    //   168: getstatic 110	com/tencent/smtt/sdk/WebView:wUv	Ljava/util/concurrent/locks/Lock;
    //   171: invokeinterface 779 1 0
    //   176: aload 6
    //   178: aload 5
    //   180: invokestatic 782	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   183: iconst_m1
    //   184: ireturn
    //   185: astore_0
    //   186: ldc_w 804
    //   189: new 559	java/lang/StringBuilder
    //   192: dup
    //   193: ldc_w 806
    //   196: invokespecial 562	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   199: aload_0
    //   200: invokevirtual 807	java/io/IOException:toString	()Ljava/lang/String;
    //   203: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 809	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: goto -44 -> 168
    //   215: aload_3
    //   216: astore_0
    //   217: aload 4
    //   219: invokestatic 814	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   222: istore_1
    //   223: aload_3
    //   224: invokevirtual 797	java/io/FileInputStream:close	()V
    //   227: getstatic 110	com/tencent/smtt/sdk/WebView:wUv	Ljava/util/concurrent/locks/Lock;
    //   230: invokeinterface 779 1 0
    //   235: aload 6
    //   237: aload 5
    //   239: invokestatic 782	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   242: iload_1
    //   243: ireturn
    //   244: astore_0
    //   245: ldc_w 804
    //   248: new 559	java/lang/StringBuilder
    //   251: dup
    //   252: ldc_w 806
    //   255: invokespecial 562	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   258: aload_0
    //   259: invokevirtual 807	java/io/IOException:toString	()Ljava/lang/String;
    //   262: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 809	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: goto -44 -> 227
    //   274: astore 4
    //   276: aconst_null
    //   277: astore_3
    //   278: aload_3
    //   279: astore_0
    //   280: ldc_w 804
    //   283: new 559	java/lang/StringBuilder
    //   286: dup
    //   287: ldc_w 816
    //   290: invokespecial 562	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: aload 4
    //   295: invokevirtual 817	java/lang/Exception:toString	()Ljava/lang/String;
    //   298: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 809	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload_3
    //   308: ifnull +7 -> 315
    //   311: aload_3
    //   312: invokevirtual 797	java/io/FileInputStream:close	()V
    //   315: getstatic 110	com/tencent/smtt/sdk/WebView:wUv	Ljava/util/concurrent/locks/Lock;
    //   318: invokeinterface 779 1 0
    //   323: aload 6
    //   325: aload 5
    //   327: invokestatic 782	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   330: iconst_m1
    //   331: ireturn
    //   332: astore_0
    //   333: ldc_w 804
    //   336: new 559	java/lang/StringBuilder
    //   339: dup
    //   340: ldc_w 806
    //   343: invokespecial 562	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   346: aload_0
    //   347: invokevirtual 807	java/io/IOException:toString	()Ljava/lang/String;
    //   350: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 809	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   359: goto -44 -> 315
    //   362: astore_0
    //   363: aload 4
    //   365: astore_3
    //   366: aload_3
    //   367: ifnull +7 -> 374
    //   370: aload_3
    //   371: invokevirtual 797	java/io/FileInputStream:close	()V
    //   374: getstatic 110	com/tencent/smtt/sdk/WebView:wUv	Ljava/util/concurrent/locks/Lock;
    //   377: invokeinterface 779 1 0
    //   382: aload 6
    //   384: aload 5
    //   386: invokestatic 782	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   389: aload_0
    //   390: athrow
    //   391: astore_3
    //   392: ldc_w 804
    //   395: new 559	java/lang/StringBuilder
    //   398: dup
    //   399: ldc_w 806
    //   402: invokespecial 562	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   405: aload_3
    //   406: invokevirtual 807	java/io/IOException:toString	()Ljava/lang/String;
    //   409: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 809	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   418: goto -44 -> 374
    //   421: aload 6
    //   423: aload 5
    //   425: invokestatic 782	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   428: iconst_m1
    //   429: ireturn
    //   430: astore 4
    //   432: aload_0
    //   433: astore_3
    //   434: aload 4
    //   436: astore_0
    //   437: goto -71 -> 366
    //   440: astore 4
    //   442: goto -164 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	paramContext	Context
    //   222	21	1	i	int
    //   93	2	2	bool	boolean
    //   132	239	3	localObject1	Object
    //   391	15	3	localIOException	java.io.IOException
    //   433	1	3	localContext	Context
    //   41	177	4	str	String
    //   274	90	4	localException1	Exception
    //   430	5	4	localObject2	Object
    //   440	1	4	localException2	Exception
    //   8	416	5	localFileOutputStream	FileOutputStream
    //   20	402	6	localFileLock	java.nio.channels.FileLock
    //   122	28	7	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   164	168	185	java/io/IOException
    //   223	227	244	java/io/IOException
    //   43	94	274	java/lang/Exception
    //   115	133	274	java/lang/Exception
    //   311	315	332	java/io/IOException
    //   43	94	362	finally
    //   115	133	362	finally
    //   370	374	391	java/io/IOException
    //   135	141	430	finally
    //   143	147	430	finally
    //   149	159	430	finally
    //   217	223	430	finally
    //   280	307	430	finally
    //   135	141	440	java/lang/Exception
    //   143	147	440	java/lang/Exception
    //   149	159	440	java/lang/Exception
    //   217	223	440	java/lang/Exception
  }
  
  static void gD(Context paramContext)
  {
    int i = gC(paramContext);
    if (i != -1) {}
    for (String str = "PV=" + String.valueOf(i + 1);; str = "PV=1")
    {
      paramContext = paramContext.getDir("tbs", 0);
      paramContext = new File(paramContext + File.separator + "core_private", "pv.db");
      try
      {
        paramContext.getParentFile().mkdirs();
        if ((!paramContext.isFile()) || (!paramContext.exists())) {
          paramContext.createNewFile();
        }
        paramContext = new FileOutputStream(paramContext, false);
        wUw = paramContext;
        paramContext.write(str.getBytes());
      }
      finally
      {
        if (wUw != null) {
          wUw.flush();
        }
      }
      try
      {
        if (wUw != null) {
          wUw.flush();
        }
        return;
      }
      catch (Throwable paramContext) {}
    }
  }
  
  private static void gE(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getDir("tbs", 0);
      paramContext = new File(paramContext + File.separator + "core_private", "pv.db");
      if (!paramContext.exists()) {
        return;
      }
      paramContext.delete();
      return;
    }
    catch (Exception paramContext)
    {
      TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + paramContext.toString());
    }
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    String str1 = null;
    if (paramContext == null) {
      return "";
    }
    String str2 = "tbs_core_version:" + QbSdk.getTbsVersion(paramContext) + ";tbs_sdk_version:43501" + ";";
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = d.lY(true);
    if ((((d)localObject1).wRz == null) || (QbSdk.wQZ)) {
      localObject1 = "system webview get nothing...";
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("\n");
      localStringBuilder.append(str2);
      if ((!t.gu(paramContext)) && (QbSdk.wRu != null) && (QbSdk.wRu.containsKey("weapp_id")) && (QbSdk.wRu.containsKey("weapp_name")))
      {
        paramContext = "weapp_id:" + QbSdk.wRu.get("weapp_id") + ";weapp_name:" + QbSdk.wRu.get("weapp_name") + ";";
        localStringBuilder.append("\n");
        localStringBuilder.append(paramContext);
      }
      if (localStringBuilder.length() <= 8192) {
        break;
      }
      return localStringBuilder.substring(localStringBuilder.length() - 8192);
      w localw = ((d)localObject1).wRz;
      localObject1 = localw.wUo;
      Object localObject2 = Boolean.TYPE;
      Object[] arrayOfObject = new Object[0];
      localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[] { localObject2, String.class, String.class, Class[].class, Object[].class }, new Object[] { Boolean.valueOf(true), "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, arrayOfObject });
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localw.wUo.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
      }
      if (localObject1 != null)
      {
        str1 = String.valueOf(localObject1);
        str1 = str1 + " ReaderPackName=" + s.wTR + " ReaderPackVersion=" + s.wTS;
      }
      localObject1 = str1;
      if (str1 == null) {
        localObject1 = "X5 core get nothing...";
      }
    }
    return localStringBuilder.toString();
  }
  
  public static PackageInfo getCurrentWebViewPackage()
  {
    if (!ac.ceR().ceS())
    {
      if (Build.VERSION.SDK_INT < 26) {
        return null;
      }
      try
      {
        PackageInfo localPackageInfo = (PackageInfo)com.tencent.smtt.utils.o.fl("android.webkit.WebView", "getCurrentWebViewPackage");
        return localPackageInfo;
      }
      catch (Exception localException)
      {
        return null;
      }
    }
    return null;
  }
  
  /* Error */
  @Deprecated
  public static Object getPluginList()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 392	com/tencent/smtt/sdk/ac:ceR	()Lcom/tencent/smtt/sdk/ac;
    //   6: invokevirtual 605	com/tencent/smtt/sdk/ac:ceS	()Z
    //   9: ifne +18 -> 27
    //   12: ldc_w 672
    //   15: ldc_w 954
    //   18: invokestatic 677	com/tencent/smtt/utils/o:fl	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   21: astore_0
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: aconst_null
    //   28: astore_0
    //   29: goto -7 -> 22
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	8	0	localObject1	Object
    //   32	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	22	32	finally
  }
  
  public static int getTbsCoreVersion(Context paramContext)
  {
    return QbSdk.getTbsVersion(paramContext);
  }
  
  public static boolean getTbsNeedReboot()
  {
    ceM();
    return d.lY(true).getTbsNeedReboot();
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    return 43501;
  }
  
  public static void setSysDayOrNight(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = wUP;
        if (paramBoolean == bool) {
          return;
        }
        wUP = paramBoolean;
        if (wUO == null)
        {
          Paint localPaint = new Paint();
          wUO = localPaint;
          localPaint.setColor(-16777216);
        }
        if (!paramBoolean)
        {
          if (wUO.getAlpha() == NIGHT_MODE_ALPHA) {
            continue;
          }
          wUO.setAlpha(NIGHT_MODE_ALPHA);
          continue;
        }
        if (wUO.getAlpha() == 255) {
          continue;
        }
      }
      finally {}
      wUO.setAlpha(255);
    }
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      Method localMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[] { Boolean.TYPE });
      wUH = localMethod;
      if (localMethod != null)
      {
        wUH.setAccessible(true);
        wUH.invoke(null, new Object[] { Boolean.valueOf(paramBoolean) });
      }
      return;
    }
    catch (Exception localException)
    {
      TbsLog.e("QbSdk", "Exception:" + localException.getStackTrace());
    }
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (!this.wUx)
    {
      this.wUz.addJavascriptInterface(paramObject, paramString);
      return;
    }
    this.wUy.addJavascriptInterface(paramObject, paramString);
  }
  
  public void addView(View paramView)
  {
    if (!this.wUx)
    {
      this.wUz.addView(paramView);
      return;
    }
    View localView = this.wUy.getView();
    try
    {
      Method localMethod = com.tencent.smtt.utils.o.b(localView, "addView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public boolean canGoBack()
  {
    if (!this.wUx) {
      return this.wUz.canGoBack();
    }
    return this.wUy.canGoBack();
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    if (!this.wUx) {
      return this.wUz.canGoBackOrForward(paramInt);
    }
    return this.wUy.canGoBackOrForward(paramInt);
  }
  
  public boolean canGoForward()
  {
    if (!this.wUx) {
      return this.wUz.canGoForward();
    }
    return this.wUy.canGoForward();
  }
  
  @Deprecated
  public boolean canZoomIn()
  {
    if (!this.wUx)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = com.tencent.smtt.utils.o.c(this.wUz, "canZoomIn");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.wUy.canZoomIn();
  }
  
  @Deprecated
  public boolean canZoomOut()
  {
    if (!this.wUx)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = com.tencent.smtt.utils.o.c(this.wUz, "canZoomOut");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.wUy.canZoomOut();
  }
  
  @Deprecated
  public Picture capturePicture()
  {
    if (!this.wUx)
    {
      Object localObject = com.tencent.smtt.utils.o.c(this.wUz, "capturePicture");
      if (localObject == null) {
        return null;
      }
      return (Picture)localObject;
    }
    return this.wUy.capturePicture();
  }
  
  public void clearCache(boolean paramBoolean)
  {
    if (!this.wUx)
    {
      this.wUz.clearCache(paramBoolean);
      return;
    }
    this.wUy.clearCache(paramBoolean);
  }
  
  public void clearFormData()
  {
    if (!this.wUx)
    {
      this.wUz.clearFormData();
      return;
    }
    this.wUy.clearFormData();
  }
  
  public void clearHistory()
  {
    if (!this.wUx)
    {
      this.wUz.clearHistory();
      return;
    }
    this.wUy.clearHistory();
  }
  
  @TargetApi(3)
  public void clearMatches()
  {
    if (!this.wUx)
    {
      this.wUz.clearMatches();
      return;
    }
    this.wUy.clearMatches();
  }
  
  public void clearSslPreferences()
  {
    if (!this.wUx)
    {
      this.wUz.clearSslPreferences();
      return;
    }
    this.wUy.clearSslPreferences();
  }
  
  @Deprecated
  public void clearView()
  {
    if (!this.wUx)
    {
      com.tencent.smtt.utils.o.c(this.wUz, "clearView");
      return;
    }
    this.wUy.clearView();
  }
  
  public int computeHorizontalScrollExtent()
  {
    try
    {
      if (this.wUx)
      {
        localMethod = com.tencent.smtt.utils.o.b(this.wUy.getView(), "computeHorizontalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.wUy.getView(), null)).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.o.b(this.wUz, "computeHorizontalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(this.wUz, null)).intValue();
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public int computeHorizontalScrollOffset()
  {
    try
    {
      if (this.wUx)
      {
        localMethod = com.tencent.smtt.utils.o.b(this.wUy.getView(), "computeHorizontalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.wUy.getView(), null)).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.o.b(this.wUz, "computeHorizontalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(this.wUz, null)).intValue();
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public int computeHorizontalScrollRange()
  {
    try
    {
      if (this.wUx) {
        return ((Integer)com.tencent.smtt.utils.o.a(this.wUy.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.o.b(this.wUz, "computeHorizontalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(this.wUz, null)).intValue();
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public void computeScroll()
  {
    if (!this.wUx)
    {
      this.wUz.computeScroll();
      return;
    }
    this.wUy.computeScroll();
  }
  
  public int computeVerticalScrollRange()
  {
    try
    {
      if (this.wUx) {
        return ((Integer)com.tencent.smtt.utils.o.a(this.wUy.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.o.b(this.wUz, "computeVerticalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i = ((Integer)localMethod.invoke(this.wUz, null)).intValue();
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    if (this.wUx) {
      return WebBackForwardList.a(this.wUy.copyBackForwardList());
    }
    return WebBackForwardList.a(this.wUz.copyBackForwardList());
  }
  
  public Object createPrintDocumentAdapter(String paramString)
  {
    Object localObject = null;
    if (this.wUx) {}
    for (;;)
    {
      try
      {
        localObject = this.wUy.createPrintDocumentAdapter(paramString);
        return localObject;
      }
      catch (Throwable paramString) {}
      if (Build.VERSION.SDK_INT >= 21) {
        return com.tencent.smtt.utils.o.a(this.wUz, "createPrintDocumentAdapter", new Class[] { String.class }, new Object[] { paramString });
      }
    }
    return null;
  }
  
  public void customDiskCachePathEnabled(boolean paramBoolean, String paramString)
  {
    if ((this.wUx) && (getX5WebViewExtension() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("enabled", paramBoolean);
      localBundle.putString("path", paramString);
      getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", localBundle);
    }
  }
  
  public void destroy()
  {
    Object localObject4;
    Object localObject1;
    int i;
    if ((!this.wUC) && (this.wUB != 0))
    {
      this.wUC = true;
      String str1 = "";
      String str2 = "";
      String str3 = "";
      localObject4 = str1;
      ??? = str2;
      localObject1 = str3;
      if (this.wUx)
      {
        Bundle localBundle = this.wUy.getX5WebViewExtension().getSdkQBStatisticsInfo();
        localObject4 = str1;
        ??? = str2;
        localObject1 = str3;
        if (localBundle != null)
        {
          localObject4 = localBundle.getString("guid");
          ??? = localBundle.getString("qua2");
          localObject1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName))
      {
        int j = gC(this.mContext);
        i = j;
        if (j == -1) {
          i = this.wUB;
        }
        this.wUB = i;
        gE(this.mContext);
      }
      com.tencent.smtt.sdk.a.b.a(this.mContext, (String)localObject4, (String)???, (String)localObject1, this.wUB, this.wUx, ceL());
      this.wUB = 0;
      this.wUC = false;
    }
    if (!this.wUx) {}
    try
    {
      localObject1 = Class.forName("android.webkit.WebViewClassic");
      ??? = ((Class)localObject1).getMethod("fromWebView", new Class[] { android.webkit.WebView.class });
      ((Method)???).setAccessible(true);
      ??? = ((Method)???).invoke(null, new Object[] { this.wUz });
      if (??? != null)
      {
        localObject1 = ((Class)localObject1).getDeclaredField("mListBoxDialog");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(???);
        if (localObject1 != null)
        {
          localObject1 = (Dialog)localObject1;
          ((Dialog)localObject1).setOnCancelListener(null);
          ??? = Class.forName("android.app.Dialog");
          localObject4 = ((Class)???).getDeclaredField("CANCEL");
          ((Field)localObject4).setAccessible(true);
          i = ((Integer)((Field)localObject4).get(localObject1)).intValue();
          ??? = ((Class)???).getDeclaredField("mListenersHandler");
          ((Field)???).setAccessible(true);
          ((Handler)((Field)???).get(localObject1)).removeMessages(i);
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
    this.wUz.destroy();
    for (;;)
    {
      try
      {
        ??? = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
        ((Field)???).setAccessible(true);
        localObject1 = (ComponentCallbacks)((Field)???).get(null);
        if (localObject1 != null)
        {
          ((Field)???).set(null, null);
          ??? = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
          ((Field)???).setAccessible(true);
          ??? = ((Field)???).get(null);
          if (??? == null) {}
        }
      }
      catch (Exception localException1)
      {
        continue;
      }
      synchronized ((List)???)
      {
        ((List)???).remove(localObject1);
        TbsLog.i("WebView", "X5 GUID = " + QbSdk.cdH());
        return;
      }
      this.wUy.destroy();
    }
  }
  
  public void documentHasImages(Message paramMessage)
  {
    if (!this.wUx)
    {
      this.wUz.documentHasImages(paramMessage);
      return;
    }
    this.wUy.documentHasImages(paramMessage);
  }
  
  public void dumpViewHierarchyWithProperties(BufferedWriter paramBufferedWriter, int paramInt)
  {
    if (!this.wUx)
    {
      com.tencent.smtt.utils.o.a(this.wUz, "dumpViewHierarchyWithProperties", new Class[] { BufferedWriter.class, Integer.TYPE }, new Object[] { paramBufferedWriter, Integer.valueOf(paramInt) });
      return;
    }
    this.wUy.dumpViewHierarchyWithProperties(paramBufferedWriter, paramInt);
  }
  
  public void evaluateJavascript(String paramString, y<String> paramy)
  {
    if (this.wUx) {}
    Method localMethod;
    while (Build.VERSION.SDK_INT < 19) {
      try
      {
        localMethod = com.tencent.smtt.utils.o.b(this.wUy.getView(), "evaluateJavascript", new Class[] { String.class, ValueCallback.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.wUy.getView(), new Object[] { paramString, paramy });
        return;
      }
      catch (Exception paramy)
      {
        loadUrl(paramString);
        return;
      }
    }
    try
    {
      localMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[] { String.class, ValueCallback.class });
      localMethod.setAccessible(true);
      localMethod.invoke(this.wUz, new Object[] { paramString, paramy });
      return;
    }
    catch (Exception paramString) {}
  }
  
  @Deprecated
  public int findAll(String paramString)
  {
    if (!this.wUx)
    {
      paramString = com.tencent.smtt.utils.o.a(this.wUz, "findAll", new Class[] { String.class }, new Object[] { paramString });
      if (paramString == null) {
        return 0;
      }
      return ((Integer)paramString).intValue();
    }
    return this.wUy.findAll(paramString);
  }
  
  @TargetApi(16)
  public void findAllAsync(String paramString)
  {
    if (!this.wUx)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        com.tencent.smtt.utils.o.a(this.wUz, "findAllAsync", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.wUy.findAllAsync(paramString);
  }
  
  public View findHierarchyView(String paramString, int paramInt)
  {
    if (!this.wUx) {
      return (View)com.tencent.smtt.utils.o.a(this.wUz, "findHierarchyView", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    return this.wUy.findHierarchyView(paramString, paramInt);
  }
  
  @TargetApi(3)
  public void findNext(boolean paramBoolean)
  {
    if (!this.wUx)
    {
      this.wUz.findNext(paramBoolean);
      return;
    }
    this.wUy.findNext(paramBoolean);
  }
  
  public void flingScroll(int paramInt1, int paramInt2)
  {
    if (!this.wUx)
    {
      this.wUz.flingScroll(paramInt1, paramInt2);
      return;
    }
    this.wUy.flingScroll(paramInt1, paramInt2);
  }
  
  @Deprecated
  public void freeMemory()
  {
    if (!this.wUx)
    {
      com.tencent.smtt.utils.o.c(this.wUz, "freeMemory");
      return;
    }
    this.wUy.freeMemory();
  }
  
  public SslCertificate getCertificate()
  {
    if (!this.wUx) {
      return this.wUz.getCertificate();
    }
    return this.wUy.getCertificate();
  }
  
  public int getContentHeight()
  {
    if (!this.wUx) {
      return this.wUz.getContentHeight();
    }
    return this.wUy.getContentHeight();
  }
  
  public int getContentWidth()
  {
    if (!this.wUx)
    {
      Object localObject = com.tencent.smtt.utils.o.c(this.wUz, "getContentWidth");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.wUy.getContentWidth();
  }
  
  public Bitmap getFavicon()
  {
    if (!this.wUx) {
      return this.wUz.getFavicon();
    }
    return this.wUy.getFavicon();
  }
  
  public HitTestResult getHitTestResult()
  {
    if (!this.wUx) {
      return new HitTestResult(this.wUz.getHitTestResult());
    }
    return new HitTestResult(this.wUy.getHitTestResult());
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    if (!this.wUx) {
      return this.wUz.getHttpAuthUsernamePassword(paramString1, paramString2);
    }
    return this.wUy.getHttpAuthUsernamePassword(paramString1, paramString2);
  }
  
  @TargetApi(3)
  public String getOriginalUrl()
  {
    if (!this.wUx) {
      return this.wUz.getOriginalUrl();
    }
    return this.wUy.getOriginalUrl();
  }
  
  public int getProgress()
  {
    if (!this.wUx) {
      return this.wUz.getProgress();
    }
    return this.wUy.getProgress();
  }
  
  public boolean getRendererPriorityWaivedWhenNotVisible()
  {
    try
    {
      if (!this.wUx)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return false;
        }
        Object localObject = com.tencent.smtt.utils.o.c(this.wUz, "getRendererPriorityWaivedWhenNotVisible");
        if (localObject == null) {
          return false;
        }
        boolean bool = ((Boolean)localObject).booleanValue();
        return bool;
      }
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public int getRendererRequestedPriority()
  {
    try
    {
      if (!this.wUx)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return 0;
        }
        Object localObject = com.tencent.smtt.utils.o.c(this.wUz, "getRendererRequestedPriority");
        if (localObject == null) {
          return 0;
        }
        int i = ((Integer)localObject).intValue();
        return i;
      }
      return 0;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  @Deprecated
  public float getScale()
  {
    if (!this.wUx)
    {
      Object localObject = com.tencent.smtt.utils.o.c(this.wUz, "getScale");
      if (localObject == null) {
        return 0.0F;
      }
      return ((Float)localObject).floatValue();
    }
    return this.wUy.getScale();
  }
  
  public int getScrollBarDefaultDelayBeforeFade()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarDefaultDelayBeforeFade();
  }
  
  public int getScrollBarFadeDuration()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarFadeDuration();
  }
  
  public int getScrollBarSize()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarSize();
  }
  
  public int getScrollBarStyle()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarStyle();
  }
  
  public WebSettings getSettings()
  {
    if (this.wUA != null) {
      return this.wUA;
    }
    if (this.wUx)
    {
      localWebSettings = new WebSettings(this.wUy.getSettings());
      this.wUA = localWebSettings;
      return localWebSettings;
    }
    WebSettings localWebSettings = new WebSettings(this.wUz.getSettings());
    this.wUA = localWebSettings;
    return localWebSettings;
  }
  
  public IX5WebSettingsExtension getSettingsExtension()
  {
    if (!this.wUx) {
      return null;
    }
    return this.wUy.getX5WebViewExtension().getSettingsExtension();
  }
  
  public int getSysNightModeAlpha()
  {
    return NIGHT_MODE_ALPHA;
  }
  
  public String getTitle()
  {
    if (!this.wUx) {
      return this.wUz.getTitle();
    }
    return this.wUy.getTitle();
  }
  
  public String getUrl()
  {
    if (!this.wUx) {
      return this.wUz.getUrl();
    }
    return this.wUy.getUrl();
  }
  
  public View getView()
  {
    if (!this.wUx) {
      return this.wUz;
    }
    return this.wUy.getView();
  }
  
  public int getVisibleTitleHeight()
  {
    if (!this.wUx)
    {
      Object localObject = com.tencent.smtt.utils.o.c(this.wUz, "getVisibleTitleHeight");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.wUy.getVisibleTitleHeight();
  }
  
  public WebChromeClient getWebChromeClient()
  {
    return this.jcW;
  }
  
  public IX5WebChromeClientExtension getWebChromeClientExtension()
  {
    if (!this.wUx) {
      return null;
    }
    return this.wUy.getX5WebViewExtension().getWebChromeClientExtension();
  }
  
  public int getWebScrollX()
  {
    if (this.wUx) {
      return this.wUy.getView().getScrollX();
    }
    return this.wUz.getScrollX();
  }
  
  public int getWebScrollY()
  {
    if (this.wUx) {
      return this.wUy.getView().getScrollY();
    }
    return this.wUz.getScrollY();
  }
  
  public WebViewClient getWebViewClient()
  {
    return this.ixf;
  }
  
  public IX5WebViewClientExtension getWebViewClientExtension()
  {
    if (!this.wUx) {
      return null;
    }
    return this.wUy.getX5WebViewExtension().getWebViewClientExtension();
  }
  
  public IX5WebViewExtension getX5WebViewExtension()
  {
    if (!this.wUx) {
      return null;
    }
    return this.wUy.getX5WebViewExtension();
  }
  
  @Deprecated
  public View getZoomControls()
  {
    if (!this.wUx) {
      return (View)com.tencent.smtt.utils.o.c(this.wUz, "getZoomControls");
    }
    return this.wUy.getZoomControls();
  }
  
  public void goBack()
  {
    if (!this.wUx)
    {
      this.wUz.goBack();
      return;
    }
    this.wUy.goBack();
  }
  
  public void goBackOrForward(int paramInt)
  {
    if (!this.wUx)
    {
      this.wUz.goBackOrForward(paramInt);
      return;
    }
    this.wUy.goBackOrForward(paramInt);
  }
  
  public void goForward()
  {
    if (!this.wUx)
    {
      this.wUz.goForward();
      return;
    }
    this.wUy.goForward();
  }
  
  public void invokeZoomPicker()
  {
    if (!this.wUx)
    {
      this.wUz.invokeZoomPicker();
      return;
    }
    this.wUy.invokeZoomPicker();
  }
  
  public boolean isDayMode()
  {
    return wUP;
  }
  
  public boolean isPrivateBrowsingEnabled()
  {
    if (!this.wUx)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = com.tencent.smtt.utils.o.c(this.wUz, "isPrivateBrowsingEnabled");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.wUy.isPrivateBrowsingEnable();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    if (!this.wUx)
    {
      this.wUz.loadData(paramString1, paramString2, paramString3);
      return;
    }
    this.wUy.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!this.wUx)
    {
      this.wUz.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      return;
    }
    this.wUy.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if ((this.wUx) && (this.wUD != null) && (!this.wUE))
    {
      this.wUD.a("load_url_gap", (byte)2);
      this.wUD.a("init_all", (byte)2);
      this.wUD.al("free_ram_end", a.fC(this.mContext));
      if (this.wUD.aK(this.wUy.hashCode(), paramString)) {
        this.wUE = true;
      }
    }
    if ((paramString == null) || (showDebugView(paramString))) {
      return;
    }
    if (!this.wUx)
    {
      this.wUz.loadUrl(paramString);
      return;
    }
    this.wUy.loadUrl(paramString);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    if ((this.wUx) && (this.wUD != null) && (!this.wUE))
    {
      this.wUD.a("load_url_gap", (byte)2);
      this.wUD.a("init_all", (byte)2);
      this.wUD.al("free_ram_end", a.fC(this.mContext));
      if (this.wUD.aK(this.wUy.hashCode(), paramString)) {
        this.wUE = true;
      }
    }
    if ((paramString == null) || (showDebugView(paramString))) {}
    do
    {
      return;
      if (this.wUx) {
        break;
      }
    } while (Build.VERSION.SDK_INT < 8);
    this.wUz.loadUrl(paramString, paramMap);
    return;
    this.wUy.loadUrl(paramString, paramMap);
  }
  
  public void onDetachedFromWindow()
  {
    if ((!this.wUC) && (this.wUB != 0))
    {
      this.wUC = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str3 = str4;
      String str2 = str5;
      String str1 = str6;
      if (this.wUx)
      {
        Bundle localBundle = this.wUy.getX5WebViewExtension().getSdkQBStatisticsInfo();
        str3 = str4;
        str2 = str5;
        str1 = str6;
        if (localBundle != null)
        {
          str3 = localBundle.getString("guid");
          str2 = localBundle.getString("qua2");
          str1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName))
      {
        int j = gC(this.mContext);
        int i = j;
        if (j == -1) {
          i = this.wUB;
        }
        this.wUB = i;
        gE(this.mContext);
      }
      com.tencent.smtt.sdk.a.b.a(this.mContext, str3, str2, str1, this.wUB, this.wUx, ceL());
      this.wUB = 0;
      this.wUC = false;
    }
    super.onDetachedFromWindow();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.wUR != null)
    {
      if (!this.wUR.onLongClick(paramView)) {
        return dE(paramView);
      }
      return true;
    }
    return dE(paramView);
  }
  
  public void onPause()
  {
    if (!this.wUx)
    {
      com.tencent.smtt.utils.o.c(this.wUz, "onPause");
      return;
    }
    this.wUy.onPause();
  }
  
  public void onResume()
  {
    if (!this.wUx)
    {
      com.tencent.smtt.utils.o.c(this.wUz, "onResume");
      return;
    }
    this.wUy.onResume();
  }
  
  @TargetApi(11)
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT >= 21) && (gB(this.mContext)) && (isHardwareAccelerated()) && (paramInt1 > 0) && (paramInt2 > 0)) {
      getLayerType();
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (this.mContext == null)
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if (wUI == null) {
      wUI = this.mContext.getApplicationInfo().packageName;
    }
    if ((wUI != null) && ((wUI.equals("com.tencent.mm")) || (wUI.equals("com.tencent.mobileqq"))))
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if ((paramInt != 0) && (!this.wUC) && (this.wUB != 0))
    {
      this.wUC = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str3 = str4;
      String str2 = str5;
      String str1 = str6;
      if (this.wUx)
      {
        Bundle localBundle = this.wUy.getX5WebViewExtension().getSdkQBStatisticsInfo();
        str3 = str4;
        str2 = str5;
        str1 = str6;
        if (localBundle != null)
        {
          str3 = localBundle.getString("guid");
          str2 = localBundle.getString("qua2");
          str1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName))
      {
        int j = gC(this.mContext);
        int i = j;
        if (j == -1) {
          i = this.wUB;
        }
        this.wUB = i;
        gE(this.mContext);
      }
      com.tencent.smtt.sdk.a.b.a(this.mContext, str3, str2, str1, this.wUB, this.wUx, ceL());
      this.wUB = 0;
      this.wUC = false;
    }
    super.onVisibilityChanged(paramView, paramInt);
  }
  
  public boolean overlayHorizontalScrollbar()
  {
    if (!this.wUx) {
      return this.wUz.overlayHorizontalScrollbar();
    }
    return this.wUy.overlayHorizontalScrollbar();
  }
  
  public boolean overlayVerticalScrollbar()
  {
    if (this.wUx) {
      return this.wUy.overlayVerticalScrollbar();
    }
    return this.wUz.overlayVerticalScrollbar();
  }
  
  public boolean pageDown(boolean paramBoolean)
  {
    if (!this.wUx) {
      return this.wUz.pageDown(paramBoolean);
    }
    return this.wUy.pageDown(paramBoolean, -1);
  }
  
  public boolean pageUp(boolean paramBoolean)
  {
    if (!this.wUx) {
      return this.wUz.pageUp(paramBoolean);
    }
    return this.wUy.pageUp(paramBoolean, -1);
  }
  
  public void pauseTimers()
  {
    if (!this.wUx)
    {
      this.wUz.pauseTimers();
      return;
    }
    this.wUy.pauseTimers();
  }
  
  @TargetApi(5)
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    if (!this.wUx)
    {
      this.wUz.postUrl(paramString, paramArrayOfByte);
      return;
    }
    this.wUy.postUrl(paramString, paramArrayOfByte);
  }
  
  @Deprecated
  public void refreshPlugins(boolean paramBoolean)
  {
    if (!this.wUx)
    {
      com.tencent.smtt.utils.o.a(this.wUz, "refreshPlugins", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.wUy.refreshPlugins(paramBoolean);
  }
  
  public void reload()
  {
    if (!this.wUx)
    {
      this.wUz.reload();
      return;
    }
    this.wUy.reload();
  }
  
  @TargetApi(11)
  public void removeJavascriptInterface(String paramString)
  {
    if (!this.wUx)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        com.tencent.smtt.utils.o.a(this.wUz, "removeJavascriptInterface", new Class[] { String.class }, new Object[] { paramString });
      }
    }
    else {
      return;
    }
    this.wUy.removeJavascriptInterface(paramString);
  }
  
  public void removeView(View paramView)
  {
    if (!this.wUx)
    {
      this.wUz.removeView(paramView);
      return;
    }
    View localView = this.wUy.getView();
    try
    {
      Method localMethod = com.tencent.smtt.utils.o.b(localView, "removeView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public void reportInitPerformance(long paramLong)
  {
    TbsLog.i("sdkreport", "reportInitPerformance initType is " + paramLong + " isX5Core is " + this.wUx + " isPerformanceDataRecorded" + this.wUE);
    if ((this.wUx) && (this.wUD != null) && (!this.wUE))
    {
      this.wUD.al("init_type", paramLong);
      if (this.wUD.aK(this.wUy.hashCode(), getUrl())) {
        this.wUE = true;
      }
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    if (this.wUx)
    {
      localObject1 = this.wUy.getView();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject2 = (ViewGroup)localObject1;
        if (paramView == this) {
          paramView = (View)localObject1;
        }
        for (;;)
        {
          return ((ViewGroup)localObject2).requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
        }
      }
      return false;
    }
    Object localObject2 = this.wUz;
    Object localObject1 = paramView;
    if (paramView == this) {
      localObject1 = this.wUz;
    }
    return ((android.webkit.WebView)localObject2).requestChildRectangleOnScreen((View)localObject1, paramRect, paramBoolean);
  }
  
  public void requestFocusNodeHref(Message paramMessage)
  {
    if (!this.wUx)
    {
      this.wUz.requestFocusNodeHref(paramMessage);
      return;
    }
    this.wUy.requestFocusNodeHref(paramMessage);
  }
  
  public void requestImageRef(Message paramMessage)
  {
    if (!this.wUx)
    {
      this.wUz.requestImageRef(paramMessage);
      return;
    }
    this.wUy.requestImageRef(paramMessage);
  }
  
  @Deprecated
  public boolean restorePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.wUx)
    {
      paramBundle = com.tencent.smtt.utils.o.a(this.wUz, "restorePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.wUy.restorePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    if (!this.wUx) {
      return WebBackForwardList.a(this.wUz.restoreState(paramBundle));
    }
    return WebBackForwardList.a(this.wUy.restoreState(paramBundle));
  }
  
  public void resumeTimers()
  {
    if (!this.wUx)
    {
      this.wUz.resumeTimers();
      return;
    }
    this.wUy.resumeTimers();
  }
  
  @Deprecated
  public void savePassword(String paramString1, String paramString2, String paramString3)
  {
    if (!this.wUx)
    {
      com.tencent.smtt.utils.o.a(this.wUz, "savePassword", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      return;
    }
    this.wUy.savePassword(paramString1, paramString2, paramString3);
  }
  
  @Deprecated
  public boolean savePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.wUx)
    {
      paramBundle = com.tencent.smtt.utils.o.a(this.wUz, "savePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.wUy.savePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList saveState(Bundle paramBundle)
  {
    if (!this.wUx) {
      return WebBackForwardList.a(this.wUz.saveState(paramBundle));
    }
    return WebBackForwardList.a(this.wUy.saveState(paramBundle));
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString)
  {
    if (!this.wUx)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        com.tencent.smtt.utils.o.a(this.wUz, "saveWebArchive", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.wUy.saveWebArchive(paramString);
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString, boolean paramBoolean, y<String> paramy)
  {
    if (!this.wUx)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        com.tencent.smtt.utils.o.a(this.wUz, "saveWebArchive", new Class[] { String.class, Boolean.TYPE, ValueCallback.class }, new Object[] { paramString, Boolean.valueOf(paramBoolean), paramy });
      }
      return;
    }
    this.wUy.saveWebArchive(paramString, paramBoolean, paramy);
  }
  
  public void setARModeEnable(boolean paramBoolean)
  {
    try
    {
      if (this.wUx) {
        getSettingsExtension().setARModeEnable(paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (!this.wUx) {
      this.wUz.setBackgroundColor(paramInt);
    }
    for (;;)
    {
      super.setBackgroundColor(paramInt);
      return;
      this.wUy.setBackgroundColor(paramInt);
    }
  }
  
  @Deprecated
  public void setCertificate(SslCertificate paramSslCertificate)
  {
    if (!this.wUx)
    {
      this.wUz.setCertificate(paramSslCertificate);
      return;
    }
    this.wUy.setCertificate(paramSslCertificate);
  }
  
  public void setDayOrNight(boolean paramBoolean)
  {
    try
    {
      if (this.wUx) {
        getSettingsExtension().setDayOrNight(paramBoolean);
      }
      setSysDayOrNight(paramBoolean);
      getView().postInvalidate();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void setDownloadListener(final DownloadListener paramDownloadListener)
  {
    if (!this.wUx)
    {
      this.wUz.setDownloadListener(new android.webkit.DownloadListener()
      {
        public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          if (paramDownloadListener == null)
          {
            c.a(WebView.c(WebView.this), paramAnonymousString1, null, null);
            return;
          }
          paramDownloadListener.onDownloadStart(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4, paramAnonymousLong);
        }
      });
      return;
    }
    this.wUy.setDownloadListener(new b(this, paramDownloadListener));
  }
  
  @TargetApi(16)
  public void setFindListener(final IX5WebViewBase.FindListener paramFindListener)
  {
    if (!this.wUx)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.wUz.setFindListener(new WebView.FindListener()
        {
          public void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            paramFindListener.onFindResultReceived(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
          }
        });
      }
      return;
    }
    this.wUy.setFindListener(paramFindListener);
  }
  
  public void setHorizontalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.wUx)
    {
      this.wUz.setHorizontalScrollbarOverlay(paramBoolean);
      return;
    }
    this.wUy.setHorizontalScrollbarOverlay(paramBoolean);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!this.wUx)
    {
      this.wUz.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
      return;
    }
    this.wUy.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void setInitialScale(int paramInt)
  {
    if (!this.wUx)
    {
      this.wUz.setInitialScale(paramInt);
      return;
    }
    this.wUy.setInitialScale(paramInt);
  }
  
  @Deprecated
  public void setMapTrackballToArrowKeys(boolean paramBoolean)
  {
    if (!this.wUx)
    {
      com.tencent.smtt.utils.o.a(this.wUz, "setMapTrackballToArrowKeys", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.wUy.setMapTrackballToArrowKeys(paramBoolean);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    if (!this.wUx)
    {
      if (Build.VERSION.SDK_INT >= 3) {
        this.wUz.setNetworkAvailable(paramBoolean);
      }
      return;
    }
    this.wUy.setNetworkAvailable(paramBoolean);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    if (!this.wUx)
    {
      this.wUz.setOnLongClickListener(paramOnLongClickListener);
      return;
    }
    Object localObject1 = this.wUy.getView();
    try
    {
      if (this.wUQ == null)
      {
        Object localObject2 = com.tencent.smtt.utils.o.b(localObject1, "getListenerInfo", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        localObject1 = ((Method)localObject2).invoke(localObject1, null);
        localObject2 = localObject1.getClass().getDeclaredField("mOnLongClickListener");
        ((Field)localObject2).setAccessible(true);
        this.wUQ = ((Field)localObject2).get(localObject1);
      }
      this.wUR = paramOnLongClickListener;
      getView().setOnLongClickListener(this);
      return;
    }
    catch (Throwable paramOnLongClickListener) {}
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    getView().setOnTouchListener(paramOnTouchListener);
  }
  
  public void setPictureListener(final PictureListener paramPictureListener)
  {
    if (!this.wUx)
    {
      if (paramPictureListener == null)
      {
        this.wUz.setPictureListener(null);
        return;
      }
      this.wUz.setPictureListener(new android.webkit.WebView.PictureListener()
      {
        public void onNewPicture(android.webkit.WebView paramAnonymousWebView, Picture paramAnonymousPicture)
        {
          paramPictureListener.onNewPicture(WebView.this, paramAnonymousPicture);
        }
      });
      return;
    }
    if (paramPictureListener == null)
    {
      this.wUy.setPictureListener(null);
      return;
    }
    this.wUy.setPictureListener(new IX5WebViewBase.PictureListener()
    {
      public void onNewPicture(IX5WebViewBase paramAnonymousIX5WebViewBase, Picture paramAnonymousPicture, boolean paramAnonymousBoolean)
      {
        WebView.this.wUy = paramAnonymousIX5WebViewBase;
        paramPictureListener.onNewPicture(WebView.this, paramAnonymousPicture);
      }
      
      public void onNewPictureIfHaveContent(IX5WebViewBase paramAnonymousIX5WebViewBase, Picture paramAnonymousPicture) {}
    });
  }
  
  public void setRendererPriorityPolicy(int paramInt, boolean paramBoolean)
  {
    try
    {
      if (!this.wUx)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return;
        }
        com.tencent.smtt.utils.o.a(this.wUz, "setRendererPriorityPolicy", new Class[] { Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        return;
      }
    }
    catch (Exception localException) {}
  }
  
  public void setScrollBarStyle(int paramInt)
  {
    if (this.wUx)
    {
      this.wUy.getView().setScrollBarStyle(paramInt);
      return;
    }
    this.wUz.setScrollBarStyle(paramInt);
  }
  
  public void setSysNightModeAlpha(int paramInt)
  {
    NIGHT_MODE_ALPHA = paramInt;
  }
  
  public void setVerticalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.wUx)
    {
      this.wUz.setVerticalScrollbarOverlay(paramBoolean);
      return;
    }
    this.wUy.setVerticalScrollbarOverlay(paramBoolean);
  }
  
  public boolean setVideoFullScreen(Context paramContext, boolean paramBoolean)
  {
    if ((paramContext.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader")) && (this.wUy != null))
    {
      paramContext = new Bundle();
      if (paramBoolean) {
        paramContext.putInt("DefaultVideoScreen", 2);
      }
      for (;;)
      {
        this.wUy.getX5WebViewExtension().invokeMiscMethod("setVideoParams", paramContext);
        return true;
        paramContext.putInt("DefaultVideoScreen", 1);
      }
    }
    return false;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (getView() == null) {
      return;
    }
    getView().setVisibility(paramInt);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    if (this.wUx)
    {
      localIX5WebViewBase = this.wUy;
      if (paramWebChromeClient == null)
      {
        localIX5WebViewBase.setWebChromeClient((IX5WebChromeClient)localObject);
        this.jcW = paramWebChromeClient;
        return;
      }
      localObject = ac.ceR().wUU;
      if (((ad)localObject).wUo == null) {
        localObject = null;
      }
      for (;;)
      {
        localObject = new e((IX5WebChromeClient)localObject, this, paramWebChromeClient);
        break;
        localObject = ((ad)localObject).wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = (IX5WebChromeClient)localObject;
        }
      }
    }
    SystemWebView localSystemWebView = this.wUz;
    if (paramWebChromeClient == null) {}
    for (localObject = localIX5WebViewBase;; localObject = new SystemWebChromeClient(this, paramWebChromeClient))
    {
      localSystemWebView.setWebChromeClient((android.webkit.WebChromeClient)localObject);
      break;
    }
  }
  
  public void setWebChromeClientExtension(IX5WebChromeClientExtension paramIX5WebChromeClientExtension)
  {
    if (!this.wUx) {
      return;
    }
    this.wUy.getX5WebViewExtension().setWebChromeClientExtension(paramIX5WebChromeClientExtension);
  }
  
  public void setWebViewCallbackClient(ab paramab)
  {
    this.mWebViewCallbackClient = paramab;
    if ((this.wUx) && (getX5WebViewExtension() != null))
    {
      paramab = new Bundle();
      paramab.putBoolean("flag", true);
      getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", paramab);
    }
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    if (this.wUx)
    {
      localIX5WebViewBase = this.wUy;
      if (paramWebViewClient == null)
      {
        localIX5WebViewBase.setWebViewClient((IX5WebViewClient)localObject);
        this.ixf = paramWebViewClient;
        return;
      }
      localObject = ac.ceR().wUU.wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
      if (localObject == null) {}
      for (localObject = null;; localObject = (IX5WebViewClient)localObject)
      {
        localObject = new f((IX5WebViewClient)localObject, this, paramWebViewClient);
        break;
      }
    }
    SystemWebView localSystemWebView = this.wUz;
    if (paramWebViewClient == null) {}
    for (localObject = localIX5WebViewBase;; localObject = new SystemWebViewClient(this, paramWebViewClient))
    {
      localSystemWebView.setWebViewClient((android.webkit.WebViewClient)localObject);
      break;
    }
  }
  
  public void setWebViewClientExtension(IX5WebViewClientExtension paramIX5WebViewClientExtension)
  {
    if (!this.wUx) {
      return;
    }
    this.wUy.getX5WebViewExtension().setWebViewClientExtension(paramIX5WebViewClientExtension);
  }
  
  @SuppressLint({"NewApi"})
  public boolean showDebugView(String paramString)
  {
    boolean bool2 = false;
    paramString = paramString.toLowerCase();
    boolean bool1;
    if (paramString.startsWith("http://debugtbs.qq.com"))
    {
      getView().setVisibility(4);
      com.tencent.smtt.utils.e.gS(this.mContext).a(paramString, this, this.mContext, n.cep().getLooper());
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!paramString.startsWith("http://debugx5.qq.com"));
      bool1 = bool2;
    } while (this.wUx);
    paramString = new StringBuilder();
    paramString.append("<!DOCTYPE html><html><body>");
    paramString.append("<head>");
    paramString.append("<title>无法打开debugx5</title>");
    paramString.append("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />");
    paramString.append("</head>");
    paramString.append("<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />");
    paramString.append("尝试<a href=\"http://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>");
    paramString.append("</body></html>");
    loadDataWithBaseURL(null, paramString.toString(), "text/html", "utf-8", null);
    return true;
  }
  
  public boolean showFindDialog(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public void stopLoading()
  {
    if (!this.wUx)
    {
      this.wUz.stopLoading();
      return;
    }
    this.wUy.stopLoading();
  }
  
  public void super_computeScroll()
  {
    if (!this.wUx)
    {
      this.wUz.super_computeScroll();
      return;
    }
    View localView = this.wUy.getView();
    try
    {
      com.tencent.smtt.utils.o.c(localView, "super_computeScroll");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.wUx) {
      return this.wUz.super_dispatchTouchEvent(paramMotionEvent);
    }
    View localView = this.wUy.getView();
    try
    {
      paramMotionEvent = com.tencent.smtt.utils.o.a(localView, "super_dispatchTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.wUx) {
      return this.wUz.super_onInterceptTouchEvent(paramMotionEvent);
    }
    View localView = this.wUy.getView();
    try
    {
      paramMotionEvent = com.tencent.smtt.utils.o.a(localView, "super_onInterceptTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.wUx)
    {
      this.wUz.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
    View localView = this.wUy.getView();
    try
    {
      com.tencent.smtt.utils.o.a(localView, "super_onOverScrolled", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.wUx)
    {
      this.wUz.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    View localView = this.wUy.getView();
    try
    {
      com.tencent.smtt.utils.o.a(localView, "super_onScrollChanged", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.wUx) {
      return this.wUz.super_onTouchEvent(paramMotionEvent);
    }
    View localView = this.wUy.getView();
    try
    {
      paramMotionEvent = com.tencent.smtt.utils.o.a(localView, "super_onTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (!this.wUx) {
      return this.wUz.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    }
    Object localObject = this.wUy.getView();
    try
    {
      localObject = com.tencent.smtt.utils.o.a(localObject, "super_overScrollBy", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Boolean.valueOf(paramBoolean) });
      if (localObject == null) {
        return false;
      }
      paramBoolean = ((Boolean)localObject).booleanValue();
      return paramBoolean;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public void switchNightMode(boolean paramBoolean)
  {
    if (paramBoolean == wUP) {
      return;
    }
    wUP = paramBoolean;
    if (paramBoolean)
    {
      TbsLog.e("QB_SDK", "deleteNightMode");
      loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
      return;
    }
    TbsLog.e("QB_SDK", "nightMode");
    loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
  }
  
  public void switchToNightMode()
  {
    TbsLog.e("QB_SDK", "switchToNightMode 01");
    if (!wUP)
    {
      TbsLog.e("QB_SDK", "switchToNightMode");
      loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }
  }
  
  public boolean zoomIn()
  {
    if (!this.wUx) {
      return this.wUz.zoomIn();
    }
    return this.wUy.zoomIn();
  }
  
  public boolean zoomOut()
  {
    if (!this.wUx) {
      return this.wUz.zoomOut();
    }
    return this.wUy.zoomOut();
  }
  
  private static class ConnectivityChangedReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context arg1, Intent paramIntent)
    {
      if (paramIntent != null) {}
      for (;;)
      {
        try
        {
          int i;
          long l;
          if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
          {
            i = com.tencent.smtt.utils.b.gN(???);
            l = System.currentTimeMillis();
          }
          synchronized (QbSdk.wRj)
          {
            if (QbSdk.wRh) {
              QbSdk.sWifiConnectedTime += l - QbSdk.wRi;
            }
            QbSdk.wRi = l;
            TbsLog.d("sdkreport", "pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=" + QbSdk.sWifiConnectedTime + " apnType=" + i);
            if (i == 3)
            {
              bool = true;
              QbSdk.wRh = bool;
              return;
            }
          }
          boolean bool = false;
        }
        catch (Throwable ???)
        {
          return;
        }
      }
    }
  }
  
  public static class HitTestResult
  {
    @Deprecated
    public static final int ANCHOR_TYPE = 1;
    public static final int EDIT_TEXT_TYPE = 9;
    public static final int EMAIL_TYPE = 4;
    public static final int GEO_TYPE = 3;
    @Deprecated
    public static final int IMAGE_ANCHOR_TYPE = 6;
    public static final int IMAGE_TYPE = 5;
    public static final int PHONE_TYPE = 2;
    public static final int SRC_ANCHOR_TYPE = 7;
    public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
    public static final int UNKNOWN_TYPE = 0;
    private IX5WebViewBase.HitTestResult mHitTestResultImpl;
    private android.webkit.WebView.HitTestResult mSysHitTestResult = null;
    
    public HitTestResult()
    {
      this.mHitTestResultImpl = null;
      this.mSysHitTestResult = null;
    }
    
    public HitTestResult(android.webkit.WebView.HitTestResult paramHitTestResult)
    {
      this.mHitTestResultImpl = null;
      this.mSysHitTestResult = paramHitTestResult;
    }
    
    public HitTestResult(IX5WebViewBase.HitTestResult paramHitTestResult)
    {
      this.mHitTestResultImpl = paramHitTestResult;
      this.mSysHitTestResult = null;
    }
    
    public String getExtra()
    {
      String str = "";
      if (this.mHitTestResultImpl != null) {
        str = this.mHitTestResultImpl.getExtra();
      }
      while (this.mSysHitTestResult == null) {
        return str;
      }
      return this.mSysHitTestResult.getExtra();
    }
    
    public int getType()
    {
      int i = 0;
      if (this.mHitTestResultImpl != null) {
        i = this.mHitTestResultImpl.getType();
      }
      while (this.mSysHitTestResult == null) {
        return i;
      }
      return this.mSysHitTestResult.getType();
    }
    
    public void setExtra(String paramString)
    {
      if (this.mHitTestResultImpl != null) {
        this.mHitTestResultImpl.setExtra(paramString);
      }
    }
    
    public void setType(int paramInt)
    {
      if (this.mHitTestResultImpl != null) {
        this.mHitTestResultImpl.setType(paramInt);
      }
    }
  }
  
  public static abstract interface PictureListener
  {
    public abstract void onNewPicture(WebView paramWebView, Picture paramPicture);
  }
  
  private class SystemWebView
    extends android.webkit.WebView
  {
    public SystemWebView(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public SystemWebView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      if ((!QbSdk.getIsSysWebViewForcedByOuter()) || (!t.gu(paramContext))) {
        CookieSyncManager.createInstance(WebView.c(WebView.this)).startSync();
      }
      try
      {
        this$1 = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
        WebView.this.setAccessible(true);
        ((Handler)WebView.this.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
        WebView.mSysWebviewCreated = true;
        return;
      }
      catch (Exception this$1) {}
    }
    
    public void computeScroll()
    {
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.VZ();
        return;
      }
      super.computeScroll();
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      try
      {
        super.dispatchDraw(paramCanvas);
        if ((!WebView.co()) && (WebView.ceO() != null))
        {
          paramCanvas.save();
          paramCanvas.drawPaint(WebView.ceO());
          paramCanvas.restore();
        }
        return;
      }
      catch (Throwable paramCanvas) {}
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.t(paramMotionEvent);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    
    public android.webkit.WebSettings getSettings()
    {
      try
      {
        android.webkit.WebSettings localWebSettings = super.getSettings();
        return localWebSettings;
      }
      catch (Exception localException) {}
      return null;
    }
    
    public void invalidate()
    {
      super.invalidate();
      if (WebView.this.mWebViewCallbackClient != null) {
        ab localab = WebView.this.mWebViewCallbackClient;
      }
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.u(paramMotionEvent);
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    @TargetApi(9)
    public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        WebView.this.mWebViewCallbackClient.b(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
      while (Build.VERSION.SDK_INT < 9) {
        return;
      }
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    }
    
    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
        return;
      }
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      WebView.b(WebView.this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if (!hasFocus()) {
        requestFocus();
      }
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.s(paramMotionEvent);
      }
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent) {}
      return false;
    }
    
    @TargetApi(9)
    public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      }
      if (Build.VERSION.SDK_INT >= 9) {
        return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      }
      return false;
    }
    
    public void setOverScrollMode(int paramInt)
    {
      try
      {
        super.setOverScrollMode(paramInt);
        return;
      }
      catch (Exception localException) {}
    }
    
    public void super_computeScroll()
    {
      super.computeScroll();
    }
    
    public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    
    public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    @TargetApi(9)
    public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
    }
    
    public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
    {
      return super.onTouchEvent(paramMotionEvent);
    }
    
    @TargetApi(9)
    public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      }
      return false;
    }
  }
  
  public class WebViewTransport
  {
    private WebView mWebview;
    
    public WebViewTransport() {}
    
    public WebView getWebView()
    {
      try
      {
        WebView localWebView = this.mWebview;
        return localWebView;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void setWebView(WebView paramWebView)
    {
      try
      {
        this.mWebview = paramWebView;
        return;
      }
      finally
      {
        paramWebView = finally;
        throw paramWebView;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/WebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */