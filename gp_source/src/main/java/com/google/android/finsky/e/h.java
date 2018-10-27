package com.google.android.finsky.e;

import android.content.Context;
import android.content.SharedPreferences;

public final class h
{
  private static h f;
  private long a;
  private final long b;
  private long c;
  private final long d;
  private final SharedPreferences e;
  
  private h(Context paramContext, long paramLong1, long paramLong2, int paramInt)
  {
    this.e = paramContext.getSharedPreferences("event_generator", 0);
    this.b = paramLong1;
    this.d = paramLong2;
    this.a = (this.e.getLong("last_event_id", paramInt) + this.d);
    this.c = (this.a + 1L);
  }
  
  /* Error */
  public static h a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 48	com/google/android/finsky/e/h:f	Lcom/google/android/finsky/e/h;
    //   6: ifnonnull +104 -> 110
    //   9: getstatic 54	com/google/android/finsky/ag/d:db	Lcom/google/android/play/utils/b/a;
    //   12: invokevirtual 59	com/google/android/play/utils/b/a:b	()Ljava/lang/Object;
    //   15: checkcast 61	java/lang/Long
    //   18: invokevirtual 65	java/lang/Long:longValue	()J
    //   21: lstore_1
    //   22: getstatic 68	com/google/android/finsky/ag/d:da	Lcom/google/android/play/utils/b/a;
    //   25: invokevirtual 59	com/google/android/play/utils/b/a:b	()Ljava/lang/Object;
    //   28: checkcast 61	java/lang/Long
    //   31: invokevirtual 65	java/lang/Long:longValue	()J
    //   34: lstore_3
    //   35: lload_1
    //   36: lconst_0
    //   37: lcmp
    //   38: ifgt +81 -> 119
    //   41: ldc 70
    //   43: iconst_2
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: getstatic 54	com/google/android/finsky/ag/d:db	Lcom/google/android/play/utils/b/a;
    //   52: invokevirtual 59	com/google/android/play/utils/b/a:b	()Ljava/lang/Object;
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: getstatic 68	com/google/android/finsky/ag/d:da	Lcom/google/android/play/utils/b/a;
    //   61: invokevirtual 59	com/google/android/play/utils/b/a:b	()Ljava/lang/Object;
    //   64: aastore
    //   65: invokestatic 75	com/google/android/finsky/utils/FinskyLog:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: ldc2_w 76
    //   71: lstore_1
    //   72: ldc2_w 78
    //   75: lstore_3
    //   76: new 2	com/google/android/finsky/e/h
    //   79: dup
    //   80: aload_0
    //   81: lload_1
    //   82: lload_3
    //   83: ldc 80
    //   85: new 82	java/util/Random
    //   88: dup
    //   89: invokestatic 86	com/google/android/finsky/utils/i:a	()J
    //   92: invokespecial 89	java/util/Random:<init>	(J)V
    //   95: sipush 9000
    //   98: invokevirtual 93	java/util/Random:nextInt	(I)I
    //   101: iconst_1
    //   102: iadd
    //   103: imul
    //   104: invokespecial 95	com/google/android/finsky/e/h:<init>	(Landroid/content/Context;JJI)V
    //   107: putstatic 48	com/google/android/finsky/e/h:f	Lcom/google/android/finsky/e/h;
    //   110: getstatic 48	com/google/android/finsky/e/h:f	Lcom/google/android/finsky/e/h;
    //   113: astore_0
    //   114: ldc 2
    //   116: monitorexit
    //   117: aload_0
    //   118: areturn
    //   119: lload_3
    //   120: lconst_0
    //   121: lcmp
    //   122: ifle -81 -> 41
    //   125: goto -49 -> 76
    //   128: astore_0
    //   129: ldc 2
    //   131: monitorexit
    //   132: aload_0
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramContext	Context
    //   21	61	1	l1	long
    //   34	86	3	l2	long
    // Exception table:
    //   from	to	target	type
    //   3	35	128	finally
    //   41	68	128	finally
    //   76	110	128	finally
    //   110	114	128	finally
  }
  
  /* Error */
  public final long a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 42	com/google/android/finsky/e/h:a	J
    //   7: lconst_1
    //   8: ladd
    //   9: putfield 42	com/google/android/finsky/e/h:a	J
    //   12: aload_0
    //   13: getfield 42	com/google/android/finsky/e/h:a	J
    //   16: lstore_1
    //   17: aload_0
    //   18: getfield 30	com/google/android/finsky/e/h:b	J
    //   21: lstore_3
    //   22: lload_1
    //   23: lload_3
    //   24: lcmp
    //   25: ifle +52 -> 77
    //   28: aload_0
    //   29: lconst_1
    //   30: putfield 42	com/google/android/finsky/e/h:a	J
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 32	com/google/android/finsky/e/h:d	J
    //   38: lconst_1
    //   39: ladd
    //   40: putfield 44	com/google/android/finsky/e/h:c	J
    //   43: aload_0
    //   44: getfield 28	com/google/android/finsky/e/h:e	Landroid/content/SharedPreferences;
    //   47: invokeinterface 99 1 0
    //   52: ldc 34
    //   54: aload_0
    //   55: getfield 44	com/google/android/finsky/e/h:c	J
    //   58: invokeinterface 105 4 0
    //   63: invokeinterface 108 1 0
    //   68: aload_0
    //   69: getfield 42	com/google/android/finsky/e/h:a	J
    //   72: lstore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: lload_1
    //   76: lreturn
    //   77: aload_0
    //   78: getfield 44	com/google/android/finsky/e/h:c	J
    //   81: lstore 5
    //   83: lload_1
    //   84: lload 5
    //   86: lcmp
    //   87: ifne -19 -> 68
    //   90: aload_0
    //   91: lload_3
    //   92: aload_0
    //   93: getfield 32	com/google/android/finsky/e/h:d	J
    //   96: lload 5
    //   98: ladd
    //   99: invokestatic 114	java/lang/Math:min	(JJ)J
    //   102: putfield 44	com/google/android/finsky/e/h:c	J
    //   105: aload_0
    //   106: getfield 28	com/google/android/finsky/e/h:e	Landroid/content/SharedPreferences;
    //   109: invokeinterface 99 1 0
    //   114: ldc 34
    //   116: aload_0
    //   117: getfield 44	com/google/android/finsky/e/h:c	J
    //   120: invokeinterface 105 4 0
    //   125: invokeinterface 108 1 0
    //   130: goto -62 -> 68
    //   133: astore 7
    //   135: aload_0
    //   136: monitorexit
    //   137: aload 7
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	h
    //   16	68	1	l1	long
    //   21	71	3	l2	long
    //   81	16	5	l3	long
    //   133	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	133	finally
    //   28	68	133	finally
    //   68	73	133	finally
    //   77	83	133	finally
    //   90	130	133	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */