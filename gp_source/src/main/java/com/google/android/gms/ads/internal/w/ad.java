package com.google.android.gms.ads.internal.w;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.internal.g.j;
import com.google.android.gms.ads.internal.u;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.webview.ak;
import com.google.android.gms.ads.internal.webview.an;
import com.google.android.gms.ads.internal.webview.w;

@com.google.android.gms.ads.internal.q.a.a
public abstract interface ad
  extends com.google.android.gms.ads.internal.js.a, ak, an
{
  public abstract com.google.android.gms.ads.internal.w.b.k a(String paramString);
  
  public abstract void a();
  
  public abstract void a(String paramString, com.google.android.gms.ads.internal.w.b.k paramk);
  
  public abstract void a(boolean paramBoolean, long paramLong);
  
  public abstract void b();
  
  public abstract Activity getActivityContext();
  
  public abstract u getAdManagerDependencyProvider();
  
  public abstract t getAdVideoUnderlayContainer();
  
  public abstract j getAdWebViewCreatedLabel();
  
  public abstract Context getContext();
  
  public abstract String getRequestId();
  
  public abstract com.google.android.gms.ads.internal.g.k getTickStore();
  
  public abstract VersionInfoParcel getVersionInfo();
  
  public abstract int getVideoBoundingHeight();
  
  public abstract int getVideoBoundingWidth();
  
  public abstract w getVideoController();
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setFollowUrls(boolean paramBoolean);
  
  public abstract void setVideoController(w paramw);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */