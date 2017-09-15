package com.c.a.a;

import android.content.Context;
import android.os.Handler;

final class w
  extends n
{
  private static w aOU;
  private boolean aOV;
  private int aOW;
  private long aOX;
  private long aOY;
  
  static w nI()
  {
    if (aOU == null) {
      aOU = new w();
    }
    return aOU;
  }
  
  final void a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    if (this.aOV) {
      stop();
    }
    super.a(paramInt, paramString, paramLong1, paramLong2);
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    if (this.aOV) {
      if (k.nl().isReady) {
        k.nl().nh();
      }
    }
    for (;;)
    {
      super.a(paramContext, paramHandler, parama);
      return;
      if (!k.nl().isReady) {
        try
        {
          k.nl().a(paramContext, new m[] { this });
        }
        catch (Exception localException) {}
      }
    }
  }
  
  final void a(Handler paramHandler, d.a parama)
  {
    try
    {
      this.aOV = false;
      super.a(paramHandler, parama);
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  public final void a(p paramp)
  {
    long l = paramp.aMb;
    if ((this.aOV) && (l - this.aOY > this.aOX)) {
      stop();
    }
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    super.a(paramp);
  }
  
  final void a(x paramx, long paramLong1, long paramLong2)
  {
    if (paramx.aPd == null) {
      paramx.aPd = new x.a();
    }
    float f = paramx.aPd.aPg;
    if ((this.aOV) && (f >= this.aOW)) {
      stop();
    }
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    super.a(paramx, paramLong1, paramLong2);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */