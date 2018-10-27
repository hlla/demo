package com.google.android.common.http;

import java.io.FilterInputStream;
import java.io.InputStream;

final class b
  extends FilterInputStream
{
  public b(a parama, InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  /* Error */
  public final void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 18	java/io/FilterInputStream:close	()V
    //   4: invokestatic 24	android/os/SystemClock:elapsedRealtime	()J
    //   7: lstore_1
    //   8: aload_0
    //   9: getfield 10	com/google/android/common/http/b:a	Lcom/google/android/common/http/a;
    //   12: astore 9
    //   14: aload 9
    //   16: getfield 29	com/google/android/common/http/a:a	J
    //   19: lstore_3
    //   20: aload 9
    //   22: getfield 33	com/google/android/common/http/a:f	I
    //   25: invokestatic 39	android/net/TrafficStats:getUidTxBytes	(I)J
    //   28: lstore 5
    //   30: aload_0
    //   31: getfield 10	com/google/android/common/http/b:a	Lcom/google/android/common/http/a;
    //   34: getfield 33	com/google/android/common/http/a:f	I
    //   37: invokestatic 42	android/net/TrafficStats:getUidRxBytes	(I)J
    //   40: lstore 7
    //   42: aload_0
    //   43: getfield 10	com/google/android/common/http/b:a	Lcom/google/android/common/http/a;
    //   46: astore 9
    //   48: ldc 43
    //   50: iconst_5
    //   51: anewarray 45	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload 9
    //   58: getfield 49	com/google/android/common/http/a:e	Ljava/lang/String;
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload 9
    //   66: getfield 52	com/google/android/common/http/a:b	J
    //   69: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   72: aastore
    //   73: dup
    //   74: iconst_2
    //   75: lload_1
    //   76: lload_3
    //   77: lsub
    //   78: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   81: aastore
    //   82: dup
    //   83: iconst_3
    //   84: lload 5
    //   86: aload_0
    //   87: getfield 10	com/google/android/common/http/b:a	Lcom/google/android/common/http/a;
    //   90: getfield 61	com/google/android/common/http/a:d	J
    //   93: lsub
    //   94: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   97: aastore
    //   98: dup
    //   99: iconst_4
    //   100: lload 7
    //   102: aload_0
    //   103: getfield 10	com/google/android/common/http/b:a	Lcom/google/android/common/http/a;
    //   106: getfield 64	com/google/android/common/http/a:c	J
    //   109: lsub
    //   110: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   113: aastore
    //   114: invokestatic 70	android/util/EventLog:writeEvent	(I[Ljava/lang/Object;)I
    //   117: pop
    //   118: return
    //   119: astore 9
    //   121: invokestatic 24	android/os/SystemClock:elapsedRealtime	()J
    //   124: lstore_1
    //   125: aload_0
    //   126: getfield 10	com/google/android/common/http/b:a	Lcom/google/android/common/http/a;
    //   129: astore 10
    //   131: aload 10
    //   133: getfield 29	com/google/android/common/http/a:a	J
    //   136: lstore_3
    //   137: aload 10
    //   139: getfield 33	com/google/android/common/http/a:f	I
    //   142: invokestatic 39	android/net/TrafficStats:getUidTxBytes	(I)J
    //   145: lstore 5
    //   147: aload_0
    //   148: getfield 10	com/google/android/common/http/b:a	Lcom/google/android/common/http/a;
    //   151: getfield 33	com/google/android/common/http/a:f	I
    //   154: invokestatic 42	android/net/TrafficStats:getUidRxBytes	(I)J
    //   157: lstore 7
    //   159: aload_0
    //   160: getfield 10	com/google/android/common/http/b:a	Lcom/google/android/common/http/a;
    //   163: astore 10
    //   165: ldc 43
    //   167: iconst_5
    //   168: anewarray 45	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload 10
    //   175: getfield 49	com/google/android/common/http/a:e	Ljava/lang/String;
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload 10
    //   183: getfield 52	com/google/android/common/http/a:b	J
    //   186: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   189: aastore
    //   190: dup
    //   191: iconst_2
    //   192: lload_1
    //   193: lload_3
    //   194: lsub
    //   195: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   198: aastore
    //   199: dup
    //   200: iconst_3
    //   201: lload 5
    //   203: aload_0
    //   204: getfield 10	com/google/android/common/http/b:a	Lcom/google/android/common/http/a;
    //   207: getfield 61	com/google/android/common/http/a:d	J
    //   210: lsub
    //   211: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   214: aastore
    //   215: dup
    //   216: iconst_4
    //   217: lload 7
    //   219: aload_0
    //   220: getfield 10	com/google/android/common/http/b:a	Lcom/google/android/common/http/a;
    //   223: getfield 64	com/google/android/common/http/a:c	J
    //   226: lsub
    //   227: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   230: aastore
    //   231: invokestatic 70	android/util/EventLog:writeEvent	(I[Ljava/lang/Object;)I
    //   234: pop
    //   235: aload 9
    //   237: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	b
    //   7	186	1	l1	long
    //   19	175	3	l2	long
    //   28	174	5	l3	long
    //   40	178	7	l4	long
    //   12	53	9	locala1	a
    //   119	117	9	localObject	Object
    //   129	53	10	locala2	a
    // Exception table:
    //   from	to	target	type
    //   0	4	119	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/common/http/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */