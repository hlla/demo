package com.google.android.gms.ads.internal.w.b;

import com.google.android.gms.ads.internal.q.a.a;

@a
public final class c
{
  private long a;
  
  /* Error */
  public final long a(java.nio.ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/google/android/gms/ads/internal/w/b/c:a	J
    //   4: lstore 4
    //   6: lload 4
    //   8: lstore_2
    //   9: lload 4
    //   11: lconst_0
    //   12: lcmp
    //   13: ifgt +140 -> 153
    //   16: aload_1
    //   17: invokevirtual 25	java/nio/ByteBuffer:duplicate	()Ljava/nio/ByteBuffer;
    //   20: astore_1
    //   21: aload_1
    //   22: invokevirtual 29	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   25: pop
    //   26: new 31	com/a/a/d
    //   29: dup
    //   30: new 33	com/google/android/gms/ads/internal/w/b/a
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 36	com/google/android/gms/ads/internal/w/b/a:<init>	(Ljava/nio/ByteBuffer;)V
    //   38: getstatic 41	com/google/android/gms/ads/internal/w/b/e:a	Lcom/google/android/gms/ads/internal/w/b/e;
    //   41: invokespecial 44	com/a/a/d:<init>	(Lcom/b/a/f;Lcom/a/a/c;)V
    //   44: invokevirtual 50	com/b/a/d:c	()Ljava/util/List;
    //   47: invokeinterface 56 1 0
    //   52: astore_1
    //   53: aload_1
    //   54: invokeinterface 62 1 0
    //   59: ifeq +101 -> 160
    //   62: aload_1
    //   63: invokeinterface 66 1 0
    //   68: checkcast 68	com/a/a/a/a
    //   71: astore 6
    //   73: aload 6
    //   75: instanceof 70
    //   78: ifeq -25 -> 53
    //   81: aload 6
    //   83: checkcast 70	com/a/a/a/c
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 50	com/b/a/d:c	()Ljava/util/List;
    //   91: invokeinterface 56 1 0
    //   96: astore_1
    //   97: aload_1
    //   98: invokeinterface 62 1 0
    //   103: ifeq +52 -> 155
    //   106: aload_1
    //   107: invokeinterface 66 1 0
    //   112: checkcast 68	com/a/a/a/a
    //   115: astore 6
    //   117: aload 6
    //   119: instanceof 72
    //   122: ifeq -25 -> 97
    //   125: aload 6
    //   127: checkcast 72	com/a/a/a/d
    //   130: astore_1
    //   131: aload_0
    //   132: aload_1
    //   133: getfield 73	com/a/a/a/d:a	J
    //   136: ldc2_w 74
    //   139: lmul
    //   140: aload_1
    //   141: getfield 78	com/a/a/a/d:b	J
    //   144: ldiv
    //   145: putfield 19	com/google/android/gms/ads/internal/w/b/c:a	J
    //   148: aload_0
    //   149: getfield 19	com/google/android/gms/ads/internal/w/b/c:a	J
    //   152: lstore_2
    //   153: lload_2
    //   154: lreturn
    //   155: aconst_null
    //   156: astore_1
    //   157: goto -26 -> 131
    //   160: aconst_null
    //   161: astore_1
    //   162: goto -75 -> 87
    //   165: astore_1
    //   166: lconst_0
    //   167: lreturn
    //   168: astore_1
    //   169: goto -3 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	c
    //   0	172	1	paramByteBuffer	java.nio.ByteBuffer
    //   8	146	2	l1	long
    //   4	6	4	l2	long
    //   71	55	6	locala	com.a.a.a.a
    // Exception table:
    //   from	to	target	type
    //   16	53	165	java/lang/RuntimeException
    //   53	87	165	java/lang/RuntimeException
    //   87	97	165	java/lang/RuntimeException
    //   97	131	165	java/lang/RuntimeException
    //   131	153	165	java/lang/RuntimeException
    //   16	53	168	java/io/IOException
    //   53	87	168	java/io/IOException
    //   87	97	168	java/io/IOException
    //   97	131	168	java/io/IOException
    //   131	153	168	java/io/IOException
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */