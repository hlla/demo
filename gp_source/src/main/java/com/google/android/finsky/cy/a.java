package com.google.android.finsky.cy;

import android.content.Context;
import android.support.v4.g.h;
import com.google.android.finsky.bo.c;
import com.google.android.finsky.bo.g;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.play.image.br;

public final class a
  implements g
{
  public static final long[] a = { 12605174L, 12605175L, 12605176L, 12605177L, 12605178L, 12605179L, 12605180L };
  public float b = 1.0F;
  public int c = 0;
  public final c d;
  public boolean e = false;
  private final Context f;
  
  public a(c paramc, Context paramContext)
  {
    this.d = paramc;
    this.f = paramContext;
    this.d.cY().a(this);
    c();
  }
  
  private final void a(long paramLong)
  {
    b();
    if (paramLong != 12605174L) {
      if (paramLong != 12605175L) {
        if (paramLong != 12605176L) {
          if (paramLong == 12605177L)
          {
            this.b = 2.0F;
            this.c = 300;
          }
        }
      }
    }
    for (;;)
    {
      FinskyLog.a("Enabling bucket experiment: factor=%.3f, zeroDelta=%dms, forceNetwork=%b", new Object[] { Float.valueOf(this.b), Integer.valueOf(this.c), Boolean.valueOf(this.e) });
      br.a().b = new b(this);
      return;
      if (paramLong != 12605178L)
      {
        if (paramLong != 12605179L)
        {
          if (paramLong == 12605180L) {
            this.e = true;
          } else {
            FinskyLog.a("Bucket experiment disabled", new Object[0]);
          }
        }
        else {
          this.b = 3.0F;
        }
      }
      else
      {
        this.b = 2.5F;
        continue;
        this.b = 2.0F;
        continue;
        this.b = 1.5F;
        continue;
        this.b = 1.0F;
      }
    }
  }
  
  private final void b()
  {
    this.e = false;
    this.b = 1.0F;
    this.c = 0;
    br.a().b = null;
  }
  
  /* Error */
  private final void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/google/android/finsky/cy/a:d	Lcom/google/android/finsky/bo/c;
    //   6: invokeinterface 57 1 0
    //   11: astore 5
    //   13: getstatic 36	com/google/android/finsky/cy/a:a	[J
    //   16: astore 6
    //   18: aload 6
    //   20: arraylength
    //   21: istore_2
    //   22: iconst_0
    //   23: istore_1
    //   24: iload_1
    //   25: iload_2
    //   26: if_icmpge +34 -> 60
    //   29: aload 6
    //   31: iload_1
    //   32: laload
    //   33: lstore_3
    //   34: aload 5
    //   36: lload_3
    //   37: invokeinterface 111 3 0
    //   42: ifne +10 -> 52
    //   45: iload_1
    //   46: iconst_1
    //   47: iadd
    //   48: istore_1
    //   49: goto -25 -> 24
    //   52: aload_0
    //   53: lload_3
    //   54: invokespecial 113	com/google/android/finsky/cy/a:a	(J)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_0
    //   61: invokespecial 67	com/google/android/finsky/cy/a:b	()V
    //   64: goto -7 -> 57
    //   67: astore 5
    //   69: aload_0
    //   70: monitorexit
    //   71: aload 5
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   23	26	1	i	int
    //   21	6	2	j	int
    //   33	21	3	l	long
    //   11	24	5	localf	com.google.android.finsky.bo.f
    //   67	5	5	localObject	Object
    //   16	14	6	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   2	22	67	finally
    //   34	45	67	finally
    //   52	57	67	finally
    //   60	64	67	finally
  }
  
  final int a()
  {
    switch (com.google.android.play.utils.f.b(this.f))
    {
    case 2: 
    case 5: 
    default: 
      return 2;
    case 3: 
    case 4: 
    case 6: 
      return 1;
    }
    return 3;
  }
  
  public final void a(h paramh1, h paramh2)
  {
    int j = 0;
    for (;;)
    {
      long[] arrayOfLong;
      try
      {
        arrayOfLong = a;
        k = arrayOfLong.length;
        i = 0;
      }
      finally {}
      paramh2 = a;
      int k = paramh2.length;
      int i = j;
      if (i < k)
      {
        long l = paramh2[i];
        if (paramh1.b(l) < 0) {
          i += 1;
        } else {
          a(l);
        }
      }
      else
      {
        return;
        if (paramh2.b(arrayOfLong[i]) < 0)
        {
          i += 1;
        }
        else
        {
          b();
          continue;
        }
        if (i < k) {}
      }
    }
  }
  
  public final void a(boolean paramBoolean) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cy/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */