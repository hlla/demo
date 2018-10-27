package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.util.client.m;

@com.google.android.gms.ads.internal.q.a.a
public final class bl
  extends a
{
  private final String a;
  private final m b;
  
  public bl(Context paramContext, String paramString1, String paramString2)
  {
    this(paramString2, bt.A.e.b(paramContext, paramString1));
  }
  
  private bl(String paramString1, String paramString2)
  {
    this.b = new m(paramString2);
    this.a = paramString1;
  }
  
  public final void a()
  {
    this.b.a(this.a);
  }
  
  public final void be_() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */