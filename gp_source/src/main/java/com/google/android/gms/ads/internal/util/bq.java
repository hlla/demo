package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import com.google.android.gms.ads.internal.q.a.a;

@a
@TargetApi(17)
public final class bq
{
  private static bq b = null;
  public String a;
  
  public static bq a()
  {
    if (b == null) {
      b = new bq();
    }
    return b;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */