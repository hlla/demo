package com.google.android.finsky.cd;

import com.google.android.finsky.bw.k;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.play.image.bg;
import com.google.android.play.image.bz;
import com.google.android.play.image.m;
import com.google.android.play.image.p;
import com.google.android.play.image.q;
import com.google.android.play.image.s;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public final class a
  extends q
  implements c, d
{
  private final Semaphore a;
  private final int b;
  
  public a(int paramInt, k paramk)
  {
    super(paramInt);
    float f = bg.a();
    this.b = ((int)(f * (paramk.c() * paramk.b() * f) / 2.0F));
    this.a = new Semaphore(this.b);
  }
  
  public final s a(byte[] paramArrayOfByte, m paramm, p paramp, bz parambz)
  {
    return new b(paramArrayOfByte, paramm, paramp, this, parambz, this);
  }
  
  public final void a()
  {
    for (;;)
    {
      int i;
      synchronized (c())
      {
        i = ???.getCorePoolSize();
        if (i <= 1)
        {
          i = ???.getMaximumPoolSize();
          if (i > 1)
          {
            ???.setMaximumPoolSize(i - 1);
            FinskyLog.d("OutOfMemoryError caught in decoding. Downgrade the maximum pool size from %d to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i - 1) });
            return;
          }
          ???.shutdown();
        }
      }
      ???.setCorePoolSize(i - 1);
    }
  }
  
  public final void a(int paramInt)
  {
    this.a.acquire(paramInt);
  }
  
  public final void a(s params)
  {
    if (!(params instanceof b)) {
      throw new IllegalArgumentException(String.valueOf(params.getClass().getName()).concat(" is not allowed in this queue."));
    }
    super.a(params);
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.a.release(paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cd/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */