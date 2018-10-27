package com.google.android.gms.ads.internal.webview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.bm;
import com.google.android.gms.ads.internal.formats.e;
import com.google.android.gms.ads.internal.formats.r;
import com.google.android.gms.ads.internal.js.x;
import com.google.android.gms.ads.internal.overlay.AdOverlay;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zxxz.aa;

@com.google.android.gms.ads.internal.q.a.a
public abstract interface i
  extends com.google.android.gms.ads.internal.a.ad, bm, com.google.android.gms.ads.internal.js.a, x, com.google.android.gms.ads.internal.w.ad, ad, ae, ai, al, am, an
{
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString, com.google.android.gms.ads.internal.gmsg.u paramu);
  
  public abstract void a(String paramString, com.google.android.gms.ads.internal.w.b.k paramk);
  
  public abstract void a(String paramString, com.google.android.gms.common.util.i parami);
  
  public abstract void a(String paramString1, String paramString2, String paramString3);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(String paramString, com.google.android.gms.ads.internal.gmsg.u paramu);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void destroy();
  
  public abstract void e();
  
  public abstract boolean f();
  
  public abstract boolean g();
  
  public abstract Activity getActivityContext();
  
  public abstract com.google.android.gms.ads.internal.u getAdManagerDependencyProvider();
  
  public abstract AdOverlay getAdOverlay();
  
  public abstract au getAdSize();
  
  public abstract ao getAdWebViewClient();
  
  public abstract Context getContext();
  
  public abstract boolean getCustomClose();
  
  public abstract String getFormatString();
  
  public abstract int getHeight();
  
  public abstract ViewGroup.LayoutParams getLayoutParams();
  
  public abstract void getLocationOnScreen(int[] paramArrayOfInt);
  
  public abstract r getNativeMediaViewEventListener();
  
  public abstract com.google.android.gms.ads.internal.j.a getOmidSession();
  
  public abstract View.OnClickListener getOnClickListener();
  
  public abstract Context getOriginalContext();
  
  public abstract ViewParent getParent();
  
  public abstract int getRequestedOrientation();
  
  public abstract AdOverlay getSecondPieceAdOverlay();
  
  public abstract boolean getShouldDelayPageClose();
  
  public abstract aa getSpamSignalsUtil();
  
  public abstract com.google.android.gms.ads.internal.g.k getTickStore();
  
  public abstract VersionInfoParcel getVersionInfo();
  
  public abstract w getVideoController();
  
  public abstract View getView();
  
  public abstract WebView getWebView();
  
  public abstract WebViewClient getWebViewClientForNewWebView();
  
  public abstract int getWidth();
  
  public abstract void h();
  
  public abstract boolean i();
  
  public abstract boolean j();
  
  public abstract void k();
  
  public abstract void l();
  
  public abstract void loadData(String paramString1, String paramString2, String paramString3);
  
  public abstract void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void loadUrl(String paramString);
  
  public abstract void m();
  
  public abstract void measure(int paramInt1, int paramInt2);
  
  public abstract void n();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void setAdOverlay(AdOverlay paramAdOverlay);
  
  public abstract void setAdSize(au paramau);
  
  public abstract void setBackButtonAllowed(boolean paramBoolean);
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setContext(Context paramContext);
  
  public abstract void setCustomClose(boolean paramBoolean);
  
  public abstract void setInstreamAdEventListener(e parame);
  
  public abstract void setIsExpanded(boolean paramBoolean);
  
  public abstract void setNativeMediaViewEventListener(r paramr);
  
  public abstract void setOmidSession(com.google.android.gms.ads.internal.j.a parama);
  
  public abstract void setOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);
  
  public abstract void setRequestId(String paramString);
  
  public abstract void setRequestedOrientation(int paramInt);
  
  public abstract void setSecondPieceOverlay(AdOverlay paramAdOverlay);
  
  public abstract void setShouldDelayPageClose(boolean paramBoolean);
  
  public abstract void setVideoController(w paramw);
  
  public abstract void setWebChromeClient(WebChromeClient paramWebChromeClient);
  
  public abstract void setWebViewClient(WebViewClient paramWebViewClient);
  
  public abstract void stopLoading();
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/webview/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */