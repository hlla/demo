package com.google.android.finsky.dn.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.finsky.utils.af;
import com.google.android.play.b.a.c;
import com.google.wireless.android.finsky.dfe.nano.eb;
import java.util.HashMap;
import java.util.Map;

public final class i
{
  public final l a;
  private final Map b = new HashMap();
  private final Map c = new HashMap();
  private com.google.android.finsky.dn.g d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  i(l paraml)
  {
    this.a = paraml;
  }
  
  private final String d(String paramString)
  {
    String str = null;
    for (;;)
    {
      Object localObject;
      com.google.android.finsky.dn.g localg;
      synchronized (this.b)
      {
        localObject = b(paramString);
        localg = a();
        if (localObject == null) {
          break label178;
        }
        eb localeb = new eb();
        if ((localObject != null) && (!TextUtils.isEmpty(((com.google.android.finsky.dn.g)localObject).d)))
        {
          localObject = ((com.google.android.finsky.dn.g)localObject).d;
          if (localObject != null)
          {
            localeb.a |= 0x1;
            localeb.b = ((String)localObject);
          }
        }
        else
        {
          localObject = localeb;
          if (localg != null)
          {
            localObject = localeb;
            if (!TextUtils.isEmpty(localg.d))
            {
              localObject = localg.d;
              if (localObject == null) {
                break label170;
              }
              localeb.a |= 0x2;
              localeb.c = ((String)localObject);
              localObject = localeb;
            }
          }
          if (localObject != null) {
            str = af.b((com.google.protobuf.nano.g)localObject);
          }
          this.b.put(paramString, str);
          return str;
        }
      }
      throw new NullPointerException();
      label170:
      throw new NullPointerException();
      label178:
      if (localg == null) {
        localObject = null;
      }
    }
  }
  
  /* Error */
  public final com.google.android.finsky.dn.g a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	com/google/android/finsky/dn/a/i:e	Z
    //   6: ifeq +12 -> 18
    //   9: aload_0
    //   10: getfield 76	com/google/android/finsky/dn/a/i:d	Lcom/google/android/finsky/dn/g;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: getfield 78	com/google/android/finsky/dn/a/i:f	Z
    //   22: ifeq +18 -> 40
    //   25: new 80	java/lang/IllegalStateException
    //   28: dup
    //   29: ldc 82
    //   31: invokespecial 85	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   34: athrow
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 78	com/google/android/finsky/dn/a/i:f	Z
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 29	com/google/android/finsky/dn/a/i:a	Lcom/google/android/finsky/dn/a/l;
    //   50: ldc 87
    //   52: invokevirtual 91	com/google/android/finsky/dn/a/l:a	(Ljava/lang/String;)Lcom/google/android/finsky/dn/g;
    //   55: putfield 76	com/google/android/finsky/dn/a/i:d	Lcom/google/android/finsky/dn/g;
    //   58: aload_0
    //   59: iconst_1
    //   60: putfield 74	com/google/android/finsky/dn/a/i:e	Z
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 78	com/google/android/finsky/dn/a/i:f	Z
    //   68: goto -59 -> 9
    //   71: astore_1
    //   72: aload_0
    //   73: iconst_0
    //   74: putfield 78	com/google/android/finsky/dn/a/i:f	Z
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	i
    //   13	4	1	localg	com.google.android.finsky.dn.g
    //   35	4	1	localObject1	Object
    //   71	7	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	35	finally
    //   9	16	35	finally
    //   18	35	35	finally
    //   36	38	35	finally
    //   63	68	35	finally
    //   72	79	35	finally
    //   40	63	71	finally
  }
  
  public final String a(String paramString)
  {
    synchronized (this.b)
    {
      if (this.b.containsKey(paramString))
      {
        paramString = (String)this.b.get(paramString);
        return paramString;
      }
      this.b.put(paramString, d(paramString));
    }
  }
  
  public final boolean a(h arg1, c paramc, String paramString)
  {
    paramc = l.a(???, paramc, this.a.a.getFilesDir(), l.b(paramString));
    if (paramc != null) {
      synchronized (this.c)
      {
        this.c.put(paramString, paramc);
        d(paramString);
        return true;
      }
    }
    return false;
  }
  
  public final com.google.android.finsky.dn.g b(String paramString)
  {
    com.google.android.finsky.dn.g localg1;
    synchronized (this.c)
    {
      com.google.android.finsky.dn.g localg2 = (com.google.android.finsky.dn.g)this.c.get(paramString);
      localg1 = localg2;
      if (localg2 == null)
      {
        boolean bool = this.g;
        if (bool) {
          break label86;
        }
      }
    }
    label86:
    throw new IllegalStateException("Cannot utilize regular experiments while loading regular experiments!");
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = l.a(this.a.a.getFilesDir(), "experiment-flags-process-stable");
      return bool;
    }
    finally {}
  }
  
  public final boolean c(String paramString)
  {
    synchronized (this.c)
    {
      this.c.put(paramString, com.google.android.finsky.dn.g.a);
      boolean bool = l.a(this.a.a.getFilesDir(), l.b(paramString));
      return bool;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */