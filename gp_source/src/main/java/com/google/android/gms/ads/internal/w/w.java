package com.google.android.gms.ads.internal.w;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.q.a.a;
import java.util.concurrent.TimeUnit;

@a
@TargetApi(14)
public final class w
{
  public boolean a = true;
  private final long b = TimeUnit.MILLISECONDS.toNanos(((Long)com.google.android.gms.ads.internal.f.n.cu.a()).longValue());
  private long c;
  
  public final void a(SurfaceTexture paramSurfaceTexture, k paramk)
  {
    if (paramk != null)
    {
      long l = paramSurfaceTexture.getTimestamp();
      if ((this.a) || (Math.abs(l - this.c) >= this.b))
      {
        this.a = false;
        this.c = l;
        com.google.android.gms.ads.internal.util.n.a.post(new x(paramk));
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */