package com.google.android.finsky.bk;

import android.os.SystemClock;
import com.google.android.finsky.ag.c;
import com.google.android.finsky.ag.p;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.volley.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public final Map a = new ConcurrentHashMap();
  private final h b;
  
  public a(h paramh)
  {
    this.b = paramh;
  }
  
  /* Error */
  public final String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +120 -> 123
    //   6: getstatic 28	com/google/android/finsky/ag/c:ad	Lcom/google/android/finsky/ag/p;
    //   9: aload_1
    //   10: invokevirtual 33	com/google/android/finsky/ag/p:b	(Ljava/lang/String;)Lcom/google/android/finsky/ag/q;
    //   13: invokevirtual 38	com/google/android/finsky/ag/q:a	()Ljava/lang/Object;
    //   16: checkcast 40	java/lang/String
    //   19: astore 9
    //   21: aload 9
    //   23: ifnull +94 -> 117
    //   26: getstatic 43	com/google/android/finsky/ag/c:ae	Lcom/google/android/finsky/ag/p;
    //   29: aload_1
    //   30: invokevirtual 33	com/google/android/finsky/ag/p:b	(Ljava/lang/String;)Lcom/google/android/finsky/ag/q;
    //   33: invokevirtual 38	com/google/android/finsky/ag/q:a	()Ljava/lang/Object;
    //   36: checkcast 45	java/lang/Long
    //   39: invokevirtual 49	java/lang/Long:longValue	()J
    //   42: lstore_2
    //   43: getstatic 52	com/google/android/finsky/ag/c:af	Lcom/google/android/finsky/ag/p;
    //   46: aload_1
    //   47: invokevirtual 33	com/google/android/finsky/ag/p:b	(Ljava/lang/String;)Lcom/google/android/finsky/ag/q;
    //   50: invokevirtual 38	com/google/android/finsky/ag/q:a	()Ljava/lang/Object;
    //   53: checkcast 45	java/lang/Long
    //   56: invokevirtual 49	java/lang/Long:longValue	()J
    //   59: lstore 4
    //   61: invokestatic 57	android/os/SystemClock:elapsedRealtime	()J
    //   64: lstore 6
    //   66: lload 6
    //   68: lload_2
    //   69: lload 4
    //   71: ladd
    //   72: lcmp
    //   73: ifgt +26 -> 99
    //   76: aload 9
    //   78: astore 8
    //   80: lload 6
    //   82: lload_2
    //   83: lcmp
    //   84: ifge +28 -> 112
    //   87: aload 9
    //   89: astore 8
    //   91: lload 6
    //   93: lload 4
    //   95: lcmp
    //   96: ifle +16 -> 112
    //   99: getstatic 28	com/google/android/finsky/ag/c:ad	Lcom/google/android/finsky/ag/p;
    //   102: aload_1
    //   103: invokevirtual 33	com/google/android/finsky/ag/p:b	(Ljava/lang/String;)Lcom/google/android/finsky/ag/q;
    //   106: invokevirtual 60	com/google/android/finsky/ag/q:c	()V
    //   109: aconst_null
    //   110: astore 8
    //   112: aload_0
    //   113: monitorexit
    //   114: aload 8
    //   116: areturn
    //   117: aconst_null
    //   118: astore 8
    //   120: goto -8 -> 112
    //   123: aconst_null
    //   124: astore 8
    //   126: goto -14 -> 112
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	a
    //   0	134	1	paramString	String
    //   42	41	2	l1	long
    //   59	35	4	l2	long
    //   64	28	6	l3	long
    //   78	47	8	str1	String
    //   19	69	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   6	21	129	finally
    //   26	66	129	finally
    //   99	109	129	finally
  }
  
  public final void a(String paramString1, String paramString2, long paramLong)
  {
    if (paramString1 != null) {}
    try
    {
      c.ad.b(paramString1).a(paramString2);
      c.ae.b(paramString1).a(Long.valueOf(SystemClock.elapsedRealtime()));
      q localq = c.af.b(paramString1);
      Long localLong = Long.valueOf(paramLong);
      localq.a(localLong);
      FinskyLog.a("Received new enterprise store token: account= %s, token=%s, ttl=%d", new Object[] { paramString1, paramString2, localLong });
      this.b.b(new b(this, paramString1), 1);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public final boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +61 -> 64
    //   6: aload_0
    //   7: getfield 18	com/google/android/finsky/bk/a:a	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 92 2 0
    //   16: ifeq +43 -> 59
    //   19: aload_0
    //   20: getfield 18	com/google/android/finsky/bk/a:a	Ljava/util/Map;
    //   23: aload_1
    //   24: invokeinterface 96 2 0
    //   29: checkcast 98	java/lang/Boolean
    //   32: invokevirtual 102	java/lang/Boolean:booleanValue	()Z
    //   35: ifeq +24 -> 59
    //   38: aload_0
    //   39: getfield 18	com/google/android/finsky/bk/a:a	Ljava/util/Map;
    //   42: aload_1
    //   43: iconst_0
    //   44: invokestatic 105	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   47: invokeinterface 109 3 0
    //   52: pop
    //   53: iconst_1
    //   54: istore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: iload_2
    //   58: ireturn
    //   59: iconst_0
    //   60: istore_2
    //   61: goto -6 -> 55
    //   64: iconst_0
    //   65: istore_2
    //   66: goto -11 -> 55
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   0	74	1	paramString	String
    //   54	12	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	53	69	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */