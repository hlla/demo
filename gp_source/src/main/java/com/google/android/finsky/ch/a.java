package com.google.android.finsky.ch;

import com.google.android.finsky.bo.c;
import com.google.android.finsky.cg.b;
import com.google.android.finsky.e.i;

public final class a
{
  private final com.google.android.finsky.e.a a;
  private final i b;
  private final c c;
  private final b d;
  
  public a(b paramb, i parami, com.google.android.finsky.e.a parama, c paramc)
  {
    this.d = paramb;
    this.b = parami;
    this.a = parama;
    this.c = paramc;
  }
  
  /* Error */
  public final long a(String paramString, com.google.android.finsky.e.af paramaf, long paramLong, com.google.wireless.android.a.b.a.a.bg parambg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/google/android/finsky/ch/a:c	Lcom/google/android/finsky/bo/c;
    //   6: invokeinterface 33 1 0
    //   11: ldc2_w 34
    //   14: invokeinterface 40 3 0
    //   19: ifne +35 -> 54
    //   22: aload_0
    //   23: getfield 21	com/google/android/finsky/ch/a:b	Lcom/google/android/finsky/e/i;
    //   26: invokeinterface 46 1 0
    //   31: aload 5
    //   33: aconst_null
    //   34: lload_3
    //   35: invokevirtual 51	com/google/android/finsky/e/u:a	(Lcom/google/wireless/android/a/b/a/a/bg;Lcom/google/android/play/b/a/p;J)J
    //   38: lstore_3
    //   39: aload_0
    //   40: getfield 19	com/google/android/finsky/ch/a:d	Lcom/google/android/finsky/cg/b;
    //   43: aload_1
    //   44: lload_3
    //   45: invokeinterface 57 4 0
    //   50: aload_0
    //   51: monitorexit
    //   52: lload_3
    //   53: lreturn
    //   54: aload_2
    //   55: aload 5
    //   57: aconst_null
    //   58: invokevirtual 62	com/google/android/finsky/e/af:a	(Lcom/google/wireless/android/a/b/a/a/bg;Lcom/google/android/play/b/a/p;)Lcom/google/android/finsky/e/af;
    //   61: pop
    //   62: aload_0
    //   63: getfield 19	com/google/android/finsky/ch/a:d	Lcom/google/android/finsky/cg/b;
    //   66: new 64	com/google/android/finsky/cg/f
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 67	com/google/android/finsky/cg/f:<init>	(Ljava/lang/String;)V
    //   74: aload_2
    //   75: invokevirtual 70	com/google/android/finsky/e/af:c	()Lcom/google/android/finsky/e/a/a;
    //   78: invokevirtual 73	com/google/android/finsky/cg/f:a	(Lcom/google/android/finsky/e/a/a;)Lcom/google/android/finsky/cg/f;
    //   81: invokeinterface 76 2 0
    //   86: aload_2
    //   87: invokevirtual 79	com/google/android/finsky/e/af:b	()J
    //   90: lstore_3
    //   91: goto -41 -> 50
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	a
    //   0	99	1	paramString	String
    //   0	99	2	paramaf	com.google.android.finsky.e.af
    //   0	99	3	paramLong	long
    //   0	99	5	parambg	com.google.wireless.android.a.b.a.a.bg
    // Exception table:
    //   from	to	target	type
    //   2	50	94	finally
    //   54	91	94	finally
  }
  
  /* Error */
  public final long a(String paramString, com.google.wireless.android.a.b.a.a.bg parambg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/google/android/finsky/ch/a:d	Lcom/google/android/finsky/cg/b;
    //   6: aload_1
    //   7: invokeinterface 83 2 0
    //   12: astore 6
    //   14: aload 6
    //   16: ifnull +49 -> 65
    //   19: aload_0
    //   20: getfield 23	com/google/android/finsky/ch/a:a	Lcom/google/android/finsky/e/a;
    //   23: aload 6
    //   25: invokevirtual 87	com/google/android/finsky/cg/c:e	()Lcom/google/android/finsky/e/a/a;
    //   28: invokevirtual 92	com/google/android/finsky/e/a:a	(Lcom/google/android/finsky/e/a/a;)Lcom/google/android/finsky/e/af;
    //   31: astore 5
    //   33: aload 6
    //   35: ifnull +23 -> 58
    //   38: aload 6
    //   40: getfield 96	com/google/android/finsky/cg/c:z	J
    //   43: lstore_3
    //   44: aload_0
    //   45: aload_1
    //   46: aload 5
    //   48: lload_3
    //   49: aload_2
    //   50: invokevirtual 98	com/google/android/finsky/ch/a:a	(Ljava/lang/String;Lcom/google/android/finsky/e/af;JLcom/google/wireless/android/a/b/a/a/bg;)J
    //   53: lstore_3
    //   54: aload_0
    //   55: monitorexit
    //   56: lload_3
    //   57: lreturn
    //   58: ldc2_w 99
    //   61: lstore_3
    //   62: goto -18 -> 44
    //   65: aload_0
    //   66: getfield 23	com/google/android/finsky/ch/a:a	Lcom/google/android/finsky/e/a;
    //   69: aconst_null
    //   70: invokevirtual 103	com/google/android/finsky/e/a:a	(Ljava/lang/String;)Lcom/google/android/finsky/e/af;
    //   73: astore 5
    //   75: goto -42 -> 33
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	a
    //   0	83	1	paramString	String
    //   0	83	2	parambg	com.google.wireless.android.a.b.a.a.bg
    //   43	19	3	l	long
    //   31	43	5	localaf	com.google.android.finsky.e.af
    //   12	27	6	localc	com.google.android.finsky.cg.c
    // Exception table:
    //   from	to	target	type
    //   2	14	78	finally
    //   19	33	78	finally
    //   38	44	78	finally
    //   44	54	78	finally
    //   65	75	78	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ch/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */