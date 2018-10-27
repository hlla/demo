package com.google.android.gms.ads.internal.httpcache;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.ads.internal.ab;
import com.google.android.gms.common.internal.b;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  extends ab
{
  a(Context paramContext, Looper paramLooper, b paramb, com.google.android.gms.common.internal.c paramc)
  {
    super(com.google.android.gms.ads.internal.reward.c.b(paramContext), paramLooper, 166, paramb, paramc);
  }
  
  protected final String b()
  {
    return "com.google.android.gms.ads.service.HTTP";
  }
  
  protected final String c()
  {
    return "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService";
  }
  
  public final f d()
  {
    return (f)super.bc_();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/httpcache/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */