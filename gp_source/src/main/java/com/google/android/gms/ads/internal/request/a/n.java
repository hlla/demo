package com.google.android.gms.ads.internal.request.a;

import android.content.Context;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.l;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

@a
public final class n
{
  public WeakHashMap a = new WeakHashMap();
  
  public final Future a(Context paramContext)
  {
    return l.a(new o(this, paramContext));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */