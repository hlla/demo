package com.google.android.finsky.cg;

import android.os.Handler;
import com.google.android.finsky.af.d;
import com.google.android.finsky.af.e;
import com.google.wireless.android.finsky.b.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executors;

public final class k
  implements b
{
  public final b a;
  private final b b;
  private boolean c;
  private final com.google.android.finsky.af.c d;
  private e e;
  private final Collection f = new ArrayList();
  private final Handler g;
  private final Handler h;
  
  public k(b paramb1, b paramb2, Handler paramHandler1, Handler paramHandler2, d paramd)
  {
    this.b = paramb1;
    this.a = paramb2;
    this.h = paramHandler1;
    this.g = paramHandler2;
    this.d = paramd.a(Executors.newSingleThreadExecutor(l.a));
  }
  
  public final c a(String paramString)
  {
    try
    {
      paramString = this.b.a(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final Collection a()
  {
    try
    {
      Collection localCollection = this.b.a();
      return localCollection;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(c paramc)
  {
    try
    {
      this.b.a(paramc);
      this.h.post(new p(this, paramc));
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public final void a(f paramf)
  {
    try
    {
      this.b.a(paramf);
      this.h.post(new x(this, paramf));
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    try
    {
      this.b.a(paramString, paramInt);
      this.h.post(new ai(this, paramString, paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      this.b.a(paramString1, paramInt, paramString2);
      this.h.post(new am(this, paramString1, paramInt, paramString2));
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void a(String paramString, long paramLong)
  {
    try
    {
      this.b.a(paramString, paramLong);
      this.h.post(new q(this, paramString, paramLong));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(String paramString, com.google.android.finsky.ds.a.o paramo)
  {
    try
    {
      this.b.a(paramString, paramo);
      this.h.post(new ae(this, paramString, paramo));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(String paramString, a parama, long paramLong)
  {
    try
    {
      this.b.a(paramString, parama, paramLong);
      this.h.post(new al(this, paramString, parama, paramLong));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    try
    {
      this.b.a(paramString1, paramString2);
      this.h.post(new r(this, paramString1, paramString2));
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      this.b.a(paramString, paramArrayOfByte);
      this.h.post(new ac(this, paramString, paramArrayOfByte));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(String paramString, String[] paramArrayOfString)
  {
    try
    {
      this.b.a(paramString, paramArrayOfString);
      this.h.post(new aa(this, paramString, paramArrayOfString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final boolean a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 151	com/google/android/finsky/cg/k:c	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 38	com/google/android/finsky/cg/k:g	Landroid/os/Handler;
    //   13: aload_1
    //   14: invokevirtual 77	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   17: pop
    //   18: iconst_1
    //   19: istore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: aload_0
    //   25: invokevirtual 154	com/google/android/finsky/cg/k:d	()Lcom/google/android/finsky/af/e;
    //   28: new 156	com/google/android/finsky/cg/m
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 159	com/google/android/finsky/cg/m:<init>	(Ljava/lang/Runnable;)V
    //   36: invokeinterface 164 2 0
    //   41: iconst_0
    //   42: istore_2
    //   43: goto -23 -> 20
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	k
    //   0	51	1	paramRunnable	Runnable
    //   19	24	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	46	finally
    //   24	41	46	finally
  }
  
  public final void b(String paramString, int paramInt)
  {
    try
    {
      this.b.b(paramString, paramInt);
      this.h.post(new aj(this, paramString, paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(String paramString, long paramLong)
  {
    try
    {
      this.b.b(paramString, paramLong);
      this.h.post(new v(this, paramString, paramLong));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    try
    {
      this.b.b(paramString1, paramString2);
      this.h.post(new t(this, paramString1, paramString2));
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final Void c()
  {
    Object localObject2;
    try
    {
      if (!this.c)
      {
        Iterator localIterator1 = this.a.a().iterator();
        while (localIterator1.hasNext())
        {
          localObject2 = (c)localIterator1.next();
          this.b.a((c)localObject2);
        }
        this.c = true;
      }
    }
    finally {}
    Iterator localIterator2 = this.f.iterator();
    while (localIterator2.hasNext())
    {
      localObject2 = (Runnable)localIterator2.next();
      if (localObject2 != null) {
        this.g.post((Runnable)localObject2);
      }
    }
    this.f.clear();
    return null;
  }
  
  public final void c(String paramString, int paramInt)
  {
    try
    {
      this.b.c(paramString, paramInt);
      this.h.post(new ak(this, paramString, paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void c(String paramString, long paramLong)
  {
    try
    {
      this.b.c(paramString, paramLong);
      this.h.post(new ad(this, paramString, paramLong));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void c(String paramString1, String paramString2)
  {
    try
    {
      this.b.c(paramString1, paramString2);
      this.h.post(new u(this, paramString1, paramString2));
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final e d()
  {
    try
    {
      if (this.e == null) {
        this.e = this.d.a(new n(this));
      }
      e locale = this.e.a(o.a);
      return locale;
    }
    finally {}
  }
  
  public final void d(String paramString, int paramInt)
  {
    try
    {
      this.b.d(paramString, paramInt);
      this.h.post(new s(this, paramString, paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void d(String paramString, long paramLong)
  {
    try
    {
      this.b.d(paramString, paramLong);
      this.h.post(new af(this, paramString, paramLong));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void d(String paramString1, String paramString2)
  {
    try
    {
      this.b.d(paramString1, paramString2);
      this.h.post(new z(this, paramString1, paramString2));
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void e(String paramString, int paramInt)
  {
    try
    {
      this.b.e(paramString, paramInt);
      this.h.post(new w(this, paramString, paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void e(String paramString, long paramLong)
  {
    try
    {
      this.b.e(paramString, paramLong);
      this.h.post(new ag(this, paramString, paramLong));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void e(String paramString1, String paramString2)
  {
    try
    {
      this.b.e(paramString1, paramString2);
      this.h.post(new ab(this, paramString1, paramString2));
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void f(String paramString, int paramInt)
  {
    try
    {
      this.b.f(paramString, paramInt);
      this.h.post(new y(this, paramString, paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void g(String paramString, int paramInt)
  {
    try
    {
      this.b.g(paramString, paramInt);
      this.h.post(new ah(this, paramString, paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cg/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */