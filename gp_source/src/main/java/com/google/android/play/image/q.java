package com.google.android.play.image;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class q
  implements o
{
  private final int a;
  private ThreadPoolExecutor b;
  private final int c;
  
  public q(int paramInt)
  {
    this.a = paramInt;
    this.c = 2;
  }
  
  public s a(byte[] paramArrayOfByte, m paramm, p paramp, bz parambz)
  {
    return new s(paramArrayOfByte, paramm, paramp, parambz);
  }
  
  public void a(s params)
  {
    if (params.b == null) {}
    try
    {
      c().execute(params);
      params.b = this;
      return;
    }
    catch (RejectedExecutionException params)
    {
      throw new RejectedByDecodingQueueException(params);
    }
  }
  
  public final void b(s params)
  {
    this.b.remove(params);
  }
  
  public final ThreadPoolExecutor c()
  {
    if (this.b == null)
    {
      ThreadFactory localThreadFactory = r.a;
      this.b = new ThreadPoolExecutor(this.a, this.c, 5000L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(20), localThreadFactory);
    }
    return this.b;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/play/image/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */