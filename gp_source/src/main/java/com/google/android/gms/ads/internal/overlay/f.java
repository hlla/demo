package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.webview.i;

@a
public final class f
{
  public final Context a;
  public final int b;
  public final ViewGroup.LayoutParams c;
  public final ViewGroup d;
  
  public f(i parami)
  {
    this.c = parami.getLayoutParams();
    ViewParent localViewParent = parami.getParent();
    this.a = parami.getOriginalContext();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
    {
      this.d = ((ViewGroup)localViewParent);
      this.b = this.d.indexOfChild(parami.getView());
      this.d.removeView(parami.getView());
      parami.setIsExpanded(true);
      return;
    }
    throw new AdOverlay.AdOverlayException("Could not get the parent of the WebView for an overlay.");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/overlay/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */