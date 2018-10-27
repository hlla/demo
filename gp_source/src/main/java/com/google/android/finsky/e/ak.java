package com.google.android.finsky.e;

import com.google.wireless.android.a.b.a.a.bi;
import com.google.wireless.android.a.b.a.a.bn;
import com.google.wireless.android.a.b.a.bp;

public final class ak
{
  private static ak e;
  private boolean a;
  private final bi b = new bi();
  private final bn c = new bn();
  private final bn d = new bn();
  
  public static ak a()
  {
    try
    {
      if (e == null) {
        e = new ak();
      }
      ak localak = e;
      return localak;
    }
    finally {}
  }
  
  public final void a(bp parambp)
  {
    try
    {
      this.b.b = parambp;
      a(false);
      return;
    }
    finally
    {
      parambp = finally;
      throw parambp;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.a = paramBoolean;
      if (this.a)
      {
        this.c.a(0);
        this.b.b = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final bi c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/google/android/finsky/e/ak:b	Lcom/google/wireless/android/a/b/a/a/bi;
    //   6: astore_2
    //   7: aload_0
    //   8: getfield 27	com/google/android/finsky/e/ak:c	Lcom/google/wireless/android/a/b/a/a/bn;
    //   11: getfield 51	com/google/wireless/android/a/b/a/a/bn:a	I
    //   14: ifeq +17 -> 31
    //   17: aload_0
    //   18: getfield 29	com/google/android/finsky/e/ak:d	Lcom/google/wireless/android/a/b/a/a/bn;
    //   21: astore_1
    //   22: aload_2
    //   23: aload_1
    //   24: putfield 53	com/google/wireless/android/a/b/a/a/bi:a	Lcom/google/wireless/android/a/b/a/a/bn;
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: areturn
    //   31: aconst_null
    //   32: astore_1
    //   33: goto -11 -> 22
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	ak
    //   21	12	1	localbn	bn
    //   36	4	1	localObject	Object
    //   6	24	2	localbi	bi
    // Exception table:
    //   from	to	target	type
    //   2	22	36	finally
    //   22	27	36	finally
  }
  
  public final void d()
  {
    try
    {
      this.c.a(1);
      this.d.a(1);
      a(false);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */