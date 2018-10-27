package com.google.android.gms.ads.internal.cache;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.ads.internal.ab;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.common.internal.b;

@a
public final class g
  extends ab
{
  g(Context paramContext, Looper paramLooper, b paramb, com.google.android.gms.common.internal.c paramc)
  {
    super(com.google.android.gms.ads.internal.reward.c.b(paramContext), paramLooper, 123, paramb, paramc);
  }
  
  protected final String b()
  {
    return "com.google.android.gms.ads.service.CACHE";
  }
  
  protected final String c()
  {
    return "com.google.android.gms.ads.internal.cache.ICacheService";
  }
  
  public final j d()
  {
    return (j)super.bc_();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/cache/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */