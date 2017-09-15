package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.y;
import java.lang.reflect.Method;
import java.util.Map;

public class MMWebView
  extends WebView
{
  public boolean gRK;
  private View.OnTouchListener rku;
  protected boolean wuN;
  public boolean wuO;
  private boolean wuP;
  public ViewGroup wuQ;
  
  public MMWebView(Context paramContext)
  {
    this(paramContext, null);
    GMTrace.i(1631148048384L, 12153);
    GMTrace.o(1631148048384L, 12153);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(1631282266112L, 12154);
    GMTrace.o(1631282266112L, 12154);
  }
  
  public MMWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1631416483840L, 12155);
    this.gRK = false;
    this.wuN = false;
    this.wuO = false;
    this.wuP = false;
    caw();
    GMTrace.o(1631416483840L, 12155);
  }
  
  private static boolean a(MMWebView paramMMWebView, String paramString)
  {
    GMTrace.i(1632624443392L, 12164);
    try
    {
      paramMMWebView = new c(new c(new c(paramMMWebView, "mSysWebView", null).get(), "mProvider", null).get(), "mWebViewCore", null).get();
      Method localMethod = paramMMWebView.getClass().getDeclaredMethod("sendMessage", new Class[] { Message.class });
      localMethod.setAccessible(true);
      localMethod.invoke(paramMMWebView, new Object[] { Message.obtain(null, 194, paramString) });
      GMTrace.o(1632624443392L, 12164);
      return true;
    }
    catch (Exception paramMMWebView)
    {
      v.e("MicroMsg.MMWebView", "reflectJSExec, e = %s", new Object[] { paramMMWebView });
      GMTrace.o(1632624443392L, 12164);
    }
    return false;
  }
  
  public static void fh(Context paramContext)
  {
    GMTrace.i(1633832402944L, 12173);
    Object localObject = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    paramContext = ((SharedPreferences)localObject).getString("tbs_webview_disable", "0");
    String str = ((SharedPreferences)localObject).getString("tbs_webview_min_sdk_version", null);
    localObject = ((SharedPreferences)localObject).getString("tbs_webview_max_sdk_version", null);
    v.i("MicroMsg.MMWebView", "initTbsSettings, tbsDisable = %s, minSdkVersion = %s, maxSdkVersion = %s", new Object[] { paramContext, str, localObject });
    if ("1".equals(paramContext))
    {
      int i = bf.getInt(str, 0);
      int j = bf.getInt((String)localObject, 0);
      int k = Build.VERSION.SDK_INT;
      if ((k >= i) && ((k <= j) || (j == 0))) {
        v.i("MicroMsg.MMWebView", "in selection, disable x5");
      }
    }
    for (boolean bool = false;; bool = true)
    {
      v.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        QbSdk.forceSysWebView();
      }
      GMTrace.o(1633832402944L, 12173);
      return;
    }
  }
  
  public final boolean I(MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    GMTrace.i(1633027096576L, 12167);
    int i = paramMotionEvent.getAction();
    boolean bool2 = super.super_onTouchEvent(paramMotionEvent);
    switch (i & 0xFF)
    {
    case 1: 
    default: 
      if (bool2) {
        if (this.wuP) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      GMTrace.o(1633027096576L, 12167);
      return bool1;
      this.wuP = false;
      break;
      if (this.wuQ == null) {
        break;
      }
      if (this.wuP)
      {
        this.wuQ.requestDisallowInterceptTouchEvent(false);
        break;
      }
      this.wuQ.requestDisallowInterceptTouchEvent(true);
      break;
      bool1 = false;
      continue;
      bool1 = bool2;
    }
  }
  
  public final boolean J(MotionEvent paramMotionEvent)
  {
    GMTrace.i(1633295532032L, 12169);
    boolean bool = super.super_dispatchTouchEvent(paramMotionEvent);
    GMTrace.o(1633295532032L, 12169);
    return bool;
  }
  
  public final boolean K(MotionEvent paramMotionEvent)
  {
    GMTrace.i(1633429749760L, 12170);
    boolean bool = super.super_onInterceptTouchEvent(paramMotionEvent);
    GMTrace.o(1633429749760L, 12170);
    return bool;
  }
  
  @TargetApi(9)
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    GMTrace.i(1632892878848L, 12166);
    paramBoolean = super.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    if ((paramInt4 < 0) || ((paramInt4 == 0) && (paramInt2 < 0))) {
      this.wuP = true;
    }
    GMTrace.o(1632892878848L, 12166);
    return paramBoolean;
  }
  
  @TargetApi(9)
  public final void c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(1633161314304L, 12168);
    super.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    GMTrace.o(1633161314304L, 12168);
  }
  
  @TargetApi(11)
  public final void caw()
  {
    GMTrace.i(1632087572480L, 12160);
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        super.removeJavascriptInterface("searchBoxJavaBridge_");
      }
      GMTrace.o(1632087572480L, 12160);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.MMWebView", "removeConfigJsInterface, ex = %s", new Object[] { localException.getMessage() });
      GMTrace.o(1632087572480L, 12160);
    }
  }
  
  public final void cax()
  {
    GMTrace.i(1632221790208L, 12161);
    if (Build.VERSION.SDK_INT >= 5)
    {
      new c();
      setScrollbarFadingEnabled(true);
      setScrollBarStyle(0);
      GMTrace.o(1632221790208L, 12161);
      return;
    }
    new b();
    setScrollBarStyle(0);
    GMTrace.o(1632221790208L, 12161);
  }
  
  public final void cay()
  {
    GMTrace.i(1632758661120L, 12165);
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(1626181992448L, 12116);
        switch (paramAnonymousMotionEvent.getAction() & 0xFF)
        {
        default: 
          MMWebView.b(MMWebView.this).requestDisallowInterceptTouchEvent(true);
        }
        while (MMWebView.c(MMWebView.this) != null)
        {
          boolean bool = MMWebView.c(MMWebView.this).onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          GMTrace.o(1626181992448L, 12116);
          return bool;
          MMWebView.b(MMWebView.this).requestDisallowInterceptTouchEvent(true);
          continue;
          MMWebView.b(MMWebView.this).requestDisallowInterceptTouchEvent(false);
        }
        GMTrace.o(1626181992448L, 12116);
        return false;
      }
    });
    GMTrace.o(1632758661120L, 12165);
  }
  
  @TargetApi(9)
  public final void caz()
  {
    GMTrace.i(1633563967488L, 12171);
    super.super_computeScroll();
    GMTrace.o(1633563967488L, 12171);
  }
  
  public void evaluateJavascript(String paramString, y<String> paramy)
  {
    GMTrace.i(1632490225664L, 12163);
    if (bf.mA(paramString))
    {
      GMTrace.o(1632490225664L, 12163);
      return;
    }
    if ((d.eo(19)) || (getX5WebViewExtension() != null)) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.evaluateJavascript(paramString, paramy);
      GMTrace.o(1632490225664L, 12163);
      return;
    }
    if ((this.wuN) && (a(this, paramString)))
    {
      GMTrace.o(1632490225664L, 12163);
      return;
    }
    paramy = paramString;
    try
    {
      if (!paramString.startsWith("javascript:")) {
        paramy = "javascript:" + paramString;
      }
      super.loadUrl(paramy);
      GMTrace.o(1632490225664L, 12163);
      return;
    }
    catch (Exception paramString)
    {
      v.i("MicroMsg.MMWebView", "evaluateJavascript failed : %s", new Object[] { paramString.getMessage() });
      GMTrace.o(1632490225664L, 12163);
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(1631550701568L, 12156);
    super.loadData(paramString1, paramString2, paramString3);
    GMTrace.o(1631550701568L, 12156);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    GMTrace.i(1631684919296L, 12157);
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    GMTrace.o(1631684919296L, 12157);
  }
  
  public void loadUrl(String paramString)
  {
    GMTrace.i(1631953354752L, 12159);
    super.loadUrl(paramString);
    GMTrace.o(1631953354752L, 12159);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    GMTrace.i(1631819137024L, 12158);
    super.loadUrl(paramString, paramMap);
    GMTrace.o(1631819137024L, 12158);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    GMTrace.i(17512460713984L, 130478);
    this.rku = paramOnTouchListener;
    super.setOnTouchListener(paramOnTouchListener);
    GMTrace.o(17512460713984L, 130478);
  }
  
  public void switchNightMode(boolean paramBoolean)
  {
    GMTrace.i(1632356007936L, 12162);
    v.d("MicroMsg.MMWebView", "[cpan] swithc mode.");
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setDayOrNight(paramBoolean);
      GMTrace.o(1632356007936L, 12162);
      return;
    }
  }
  
  public final void v(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(1633698185216L, 12172);
    super.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    GMTrace.o(1633698185216L, 12172);
  }
  
  public static final class a
  {
    public static MMWebView fi(Context paramContext)
    {
      boolean bool = true;
      GMTrace.i(1626316210176L, 12117);
      MMWebView.fh(paramContext);
      paramContext = new MMWebView(paramContext);
      paramContext.gRK = true;
      if (paramContext.getX5WebViewExtension() != null) {}
      for (;;)
      {
        paramContext.wuO = bool;
        GMTrace.o(1626316210176L, 12117);
        return paramContext;
        bool = false;
      }
    }
    
    public static MMWebView fj(Context paramContext)
    {
      GMTrace.i(1626450427904L, 12118);
      MMWebView.fh(paramContext);
      paramContext = new MMWebView(paramContext);
      paramContext.gRK = true;
      if (paramContext.getX5WebViewExtension() != null) {}
      for (boolean bool = true;; bool = false)
      {
        paramContext.wuO = bool;
        paramContext.wuN = true;
        GMTrace.o(1626450427904L, 12118);
        return paramContext;
      }
    }
    
    public static MMWebView i(Activity paramActivity, int paramInt)
    {
      boolean bool = true;
      GMTrace.i(1626584645632L, 12119);
      MMWebView.fh(paramActivity);
      paramActivity = (MMWebView)paramActivity.findViewById(paramInt);
      paramActivity.gRK = true;
      if (paramActivity.getX5WebViewExtension() != null) {}
      for (;;)
      {
        paramActivity.wuO = bool;
        GMTrace.o(1626584645632L, 12119);
        return paramActivity;
        bool = false;
      }
    }
  }
  
  private final class b
  {
    public b()
    {
      GMTrace.i(1634906144768L, 12181);
      GMTrace.o(1634906144768L, 12181);
    }
  }
  
  private final class c
  {
    public c()
    {
      GMTrace.i(1639603765248L, 12216);
      GMTrace.o(1639603765248L, 12216);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/MMWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */