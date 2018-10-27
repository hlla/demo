package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.ads.internal.ab;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.common.internal.b;

@a
public final class t
  extends ab
{
  public t(Context paramContext, Looper paramLooper, b paramb, com.google.android.gms.common.internal.c paramc)
  {
    super(com.google.android.gms.ads.internal.reward.c.b(paramContext), paramLooper, 8, paramb, paramc);
  }
  
  protected final String b()
  {
    return "com.google.android.gms.ads.service.START";
  }
  
  protected final String c()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }
  
  public final z d()
  {
    return (z)super.bc_();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */