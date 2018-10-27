package com.google.android.gms.ads.internal.webview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.a.ac;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.formats.e;
import com.google.android.gms.ads.internal.g.j;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlay;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.v.f;
import com.google.android.gms.ads.internal.w.af;
import com.google.android.gms.ads.internal.w.l;
import com.google.android.gms.ads.internal.w.t;
import com.google.android.gms.ads.internal.zxxz.aa;
import com.google.android.gms.common.internal.z;
import java.util.Map;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class r
  extends FrameLayout
  implements i
{
  public final i a;
  private final t b;
  
  public r(i parami)
  {
    super(parami.getContext());
    this.a = parami;
    this.b = new t(parami.getOriginalContext(), this, this);
    addView(this.a.getView());
  }
  
  public final void Q()
  {
    this.a.Q();
  }
  
  public final void R()
  {
    this.a.R();
  }
  
  public final com.google.android.gms.ads.internal.w.b.k a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public final void a()
  {
    this.a.a();
  }
  
  public final void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public final void a(ac paramac)
  {
    this.a.a(paramac);
  }
  
  public final void a(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel)
  {
    this.a.a(paramAdLauncherIntentInfoParcel);
  }
  
  public final void a(String paramString, com.google.android.gms.ads.internal.gmsg.u paramu)
  {
    this.a.a(paramString, paramu);
  }
  
  public final void a(String paramString, com.google.android.gms.ads.internal.w.b.k paramk)
  {
    this.a.a(paramString, paramk);
  }
  
  public final void a(String paramString, com.google.android.gms.common.util.i parami)
  {
    this.a.a(paramString, parami);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    this.a.a(paramString1, paramString2, paramString3);
  }
  
  public final void a(String paramString, Map paramMap)
  {
    this.a.a(paramString, paramMap);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    this.a.a(paramString, paramJSONObject);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    this.a.a(paramBoolean, paramInt);
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.a.a(paramBoolean, paramInt, paramString);
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this.a.a(paramBoolean, paramInt, paramString1, paramString2);
  }
  
  public final void a(boolean paramBoolean, long paramLong)
  {
    this.a.a(paramBoolean, paramLong);
  }
  
  public final void b()
  {
    this.a.b();
  }
  
  public final void b(String paramString, com.google.android.gms.ads.internal.gmsg.u paramu)
  {
    this.a.b(paramString, paramu);
  }
  
  public final void b(String paramString, JSONObject paramJSONObject)
  {
    this.a.b(paramString, paramJSONObject);
  }
  
  public final void c()
  {
    this.a.c();
  }
  
  public final void d()
  {
    this.a.d();
  }
  
  public final void d(String paramString)
  {
    this.a.d(paramString);
  }
  
  public final void destroy()
  {
    com.google.android.gms.ads.internal.j.a locala = getOmidSession();
    com.google.android.gms.ads.internal.n.a locala1;
    if (locala != null)
    {
      locala1 = bt.A.y;
      synchronized (com.google.android.gms.ads.internal.n.a.c)
      {
        if ((!((Boolean)com.google.android.gms.ads.internal.f.n.bg.a()).booleanValue()) || (!com.google.android.gms.ads.internal.n.a.b)) {}
      }
    }
    try
    {
      locala1.a.c(locala);
      for (;;)
      {
        com.google.android.gms.ads.internal.util.n.a.postDelayed(new s(this), ((Integer)com.google.android.gms.ads.internal.f.n.W.a()).intValue());
        return;
      }
      localObject2 = finally;
      throw ((Throwable)localObject2);
      this.a.destroy();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.k.f("#007 Could not call remote method.", localNullPointerException);
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public final void e()
  {
    this.a.e();
  }
  
  public final boolean f()
  {
    return this.a.f();
  }
  
  public final boolean g()
  {
    return this.a.g();
  }
  
  public final Activity getActivityContext()
  {
    return this.a.getActivityContext();
  }
  
  public final com.google.android.gms.ads.internal.u getAdManagerDependencyProvider()
  {
    return this.a.getAdManagerDependencyProvider();
  }
  
  public final AdOverlay getAdOverlay()
  {
    return this.a.getAdOverlay();
  }
  
  public final au getAdSize()
  {
    return this.a.getAdSize();
  }
  
  public final t getAdVideoUnderlayContainer()
  {
    return this.b;
  }
  
  public final ao getAdWebViewClient()
  {
    return this.a.getAdWebViewClient();
  }
  
  public final j getAdWebViewCreatedLabel()
  {
    return this.a.getAdWebViewCreatedLabel();
  }
  
  public final boolean getCustomClose()
  {
    return this.a.getCustomClose();
  }
  
  public final String getFormatString()
  {
    return this.a.getFormatString();
  }
  
  public final com.google.android.gms.ads.internal.formats.r getNativeMediaViewEventListener()
  {
    return this.a.getNativeMediaViewEventListener();
  }
  
  public final com.google.android.gms.ads.internal.j.a getOmidSession()
  {
    return this.a.getOmidSession();
  }
  
  public final View.OnClickListener getOnClickListener()
  {
    return this.a.getOnClickListener();
  }
  
  public final Context getOriginalContext()
  {
    return this.a.getOriginalContext();
  }
  
  public final String getRequestId()
  {
    return this.a.getRequestId();
  }
  
  public final int getRequestedOrientation()
  {
    return this.a.getRequestedOrientation();
  }
  
  public final AdOverlay getSecondPieceAdOverlay()
  {
    return this.a.getSecondPieceAdOverlay();
  }
  
  public final boolean getShouldDelayPageClose()
  {
    return this.a.getShouldDelayPageClose();
  }
  
  public final aa getSpamSignalsUtil()
  {
    return this.a.getSpamSignalsUtil();
  }
  
  public final com.google.android.gms.ads.internal.g.k getTickStore()
  {
    return this.a.getTickStore();
  }
  
  public final VersionInfoParcel getVersionInfo()
  {
    return this.a.getVersionInfo();
  }
  
  public final int getVideoBoundingHeight()
  {
    return getMeasuredHeight();
  }
  
  public final int getVideoBoundingWidth()
  {
    return getMeasuredWidth();
  }
  
  public final w getVideoController()
  {
    return this.a.getVideoController();
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final WebView getWebView()
  {
    return this.a.getWebView();
  }
  
  public final WebViewClient getWebViewClientForNewWebView()
  {
    return this.a.getWebViewClientForNewWebView();
  }
  
  public final void h()
  {
    t localt = this.b;
    z.a("onDestroy must be called from the UI thread.");
    com.google.android.gms.ads.internal.w.n localn = localt.a;
    if (localn != null)
    {
      localn.c.a();
      l locall = localn.a;
      if (locall != null) {
        locall.a();
      }
      localn.k();
      localt.c.removeView(localt.a);
      localt.a = null;
    }
    this.a.h();
  }
  
  public final boolean i()
  {
    return this.a.i();
  }
  
  public final boolean j()
  {
    return this.a.j();
  }
  
  public final void k()
  {
    this.a.k();
  }
  
  public final void l()
  {
    this.a.l();
  }
  
  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    this.a.loadData(paramString1, paramString2, paramString3);
  }
  
  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public final void loadUrl(String paramString)
  {
    this.a.loadUrl(paramString);
  }
  
  public final void m()
  {
    setBackgroundColor(0);
    this.a.setBackgroundColor(0);
  }
  
  public final void n()
  {
    TextView localTextView = new TextView(getContext());
    Object localObject = bt.A.i.c();
    if (localObject != null) {}
    for (localObject = ((Resources)localObject).getString(2131953238);; localObject = "Test Ad")
    {
      localTextView.setText((CharSequence)localObject);
      localTextView.setTextSize(15.0F);
      localTextView.setTextColor(-1);
      localTextView.setPadding(5, 0, 5, 0);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setShape(0);
      ((GradientDrawable)localObject).setColor(-12303292);
      ((GradientDrawable)localObject).setCornerRadius(8.0F);
      localTextView.setBackground((Drawable)localObject);
      addView(localTextView, new FrameLayout.LayoutParams(-2, -2, 49));
      bringChildToFront(localTextView);
      return;
    }
  }
  
  public final void onPause()
  {
    Object localObject = this.b;
    z.a("onPause must be called from the UI thread.");
    localObject = ((t)localObject).a;
    if (localObject != null) {
      ((com.google.android.gms.ads.internal.w.n)localObject).h();
    }
    this.a.onPause();
  }
  
  public final void onResume()
  {
    this.a.onResume();
  }
  
  public final void setAdOverlay(AdOverlay paramAdOverlay)
  {
    this.a.setAdOverlay(paramAdOverlay);
  }
  
  public final void setAdSize(au paramau)
  {
    this.a.setAdSize(paramau);
  }
  
  public final void setBackButtonAllowed(boolean paramBoolean)
  {
    this.a.setBackButtonAllowed(paramBoolean);
  }
  
  public final void setContext(Context paramContext)
  {
    this.a.setContext(paramContext);
  }
  
  public final void setCustomClose(boolean paramBoolean)
  {
    this.a.setCustomClose(paramBoolean);
  }
  
  public final void setFollowUrls(boolean paramBoolean)
  {
    this.a.setFollowUrls(paramBoolean);
  }
  
  public final void setInstreamAdEventListener(e parame)
  {
    this.a.setInstreamAdEventListener(parame);
  }
  
  public final void setIsExpanded(boolean paramBoolean)
  {
    this.a.setIsExpanded(paramBoolean);
  }
  
  public final void setNativeMediaViewEventListener(com.google.android.gms.ads.internal.formats.r paramr)
  {
    this.a.setNativeMediaViewEventListener(paramr);
  }
  
  public final void setOmidSession(com.google.android.gms.ads.internal.j.a parama)
  {
    this.a.setOmidSession(parama);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.a.setOnTouchListener(paramOnTouchListener);
  }
  
  public final void setRequestId(String paramString)
  {
    this.a.setRequestId(paramString);
  }
  
  public final void setRequestedOrientation(int paramInt)
  {
    this.a.setRequestedOrientation(paramInt);
  }
  
  public final void setSecondPieceOverlay(AdOverlay paramAdOverlay)
  {
    this.a.setSecondPieceOverlay(paramAdOverlay);
  }
  
  public final void setShouldDelayPageClose(boolean paramBoolean)
  {
    this.a.setShouldDelayPageClose(paramBoolean);
  }
  
  public final void setVideoController(w paramw)
  {
    this.a.setVideoController(paramw);
  }
  
  public final void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    this.a.setWebChromeClient(paramWebChromeClient);
  }
  
  public final void setWebViewClient(WebViewClient paramWebViewClient)
  {
    this.a.setWebViewClient(paramWebViewClient);
  }
  
  public final void stopLoading()
  {
    this.a.stopLoading();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/webview/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */