package com.google.android.gms.ads.internal.w;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.webview.i;
import com.google.android.gms.common.internal.z;

@a
public final class t
{
  public n a;
  public final Context b;
  public final ViewGroup c;
  public final ad d;
  
  private t(Context paramContext, ViewGroup paramViewGroup, ad paramad)
  {
    Context localContext = paramContext;
    if (paramContext.getApplicationContext() != null) {
      localContext = paramContext.getApplicationContext();
    }
    this.b = localContext;
    this.c = paramViewGroup;
    this.d = paramad;
    this.a = null;
  }
  
  public t(Context paramContext, ViewGroup paramViewGroup, i parami)
  {
    this(paramContext, paramViewGroup, parami);
  }
  
  public final n a()
  {
    z.a("getAdVideoUnderlay must be called from the UI thread.");
    return this.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */