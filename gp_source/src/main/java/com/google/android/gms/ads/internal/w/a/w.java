package com.google.android.gms.ads.internal.w.a;

import android.content.Context;
import com.google.android.gms.ads.exoplayer1.upstream.d;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.common.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

@a
public final class w
  implements d
{
  private InputStream a;
  private final Context b;
  private final d c;
  private boolean d;
  private final WeakReference e;
  
  public w(Context paramContext, d paramd, x paramx)
  {
    this.b = paramContext;
    this.c = paramd;
    this.e = new WeakReference(paramx);
  }
  
  public final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.d) {
      throw new IOException("Attempt to read closed CacheDataSource.");
    }
    InputStream localInputStream = this.a;
    if (localInputStream != null) {
      return localInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
    }
    return this.c.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  /* Error */
  public final long a(com.google.android.gms.ads.exoplayer1.upstream.e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/google/android/gms/ads/internal/w/a/w:d	Z
    //   4: ifeq +13 -> 17
    //   7: new 39	java/io/IOException
    //   10: dup
    //   11: ldc 62
    //   13: invokespecial 44	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 37	com/google/android/gms/ads/internal/w/a/w:d	Z
    //   22: aload_1
    //   23: getfield 68	com/google/android/gms/ads/exoplayer1/upstream/e:f	Landroid/net/Uri;
    //   26: invokestatic 73	com/google/android/gms/ads/internal/cache/CacheOffering:a	(Landroid/net/Uri;)Lcom/google/android/gms/ads/internal/cache/CacheOffering;
    //   29: astore 7
    //   31: getstatic 79	com/google/android/gms/ads/internal/f/n:B	Lcom/google/android/gms/ads/internal/f/c;
    //   34: invokevirtual 84	com/google/android/gms/ads/internal/f/c:a	()Ljava/lang/Object;
    //   37: checkcast 86	java/lang/Boolean
    //   40: invokevirtual 90	java/lang/Boolean:booleanValue	()Z
    //   43: ifne +211 -> 254
    //   46: aload 7
    //   48: ifnull +200 -> 248
    //   51: aload 7
    //   53: aload_1
    //   54: getfield 93	com/google/android/gms/ads/exoplayer1/upstream/e:e	J
    //   57: putfield 95	com/google/android/gms/ads/internal/cache/CacheOffering:a	J
    //   60: getstatic 101	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   63: getfield 105	com/google/android/gms/ads/internal/bt:k	Lcom/google/android/gms/ads/internal/cache/a;
    //   66: aload 7
    //   68: invokevirtual 110	com/google/android/gms/ads/internal/cache/a:a	(Lcom/google/android/gms/ads/internal/cache/CacheOffering;)Lcom/google/android/gms/ads/internal/cache/CacheEntryParcel;
    //   71: astore 6
    //   73: aload 6
    //   75: ifnull +118 -> 193
    //   78: aload 6
    //   80: invokevirtual 114	com/google/android/gms/ads/internal/cache/CacheEntryParcel:a	()Z
    //   83: ifeq +110 -> 193
    //   86: aload_0
    //   87: aload 6
    //   89: invokevirtual 117	com/google/android/gms/ads/internal/cache/CacheEntryParcel:b	()Ljava/io/InputStream;
    //   92: putfield 46	com/google/android/gms/ads/internal/w/a/w:a	Ljava/io/InputStream;
    //   95: ldc2_w 118
    //   98: lreturn
    //   99: astore 8
    //   101: aload 6
    //   103: iconst_1
    //   104: invokeinterface 125 2 0
    //   109: pop
    //   110: getstatic 101	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   113: getfield 129	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   116: invokeinterface 134 1 0
    //   121: lload 4
    //   123: lsub
    //   124: lstore_2
    //   125: aload_0
    //   126: getfield 33	com/google/android/gms/ads/internal/w/a/w:e	Ljava/lang/ref/WeakReference;
    //   129: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   132: checkcast 139	com/google/android/gms/ads/internal/w/a/x
    //   135: astore 6
    //   137: aload 6
    //   139: ifnull +12 -> 151
    //   142: aload 6
    //   144: iconst_0
    //   145: lload_2
    //   146: invokeinterface 142 4 0
    //   151: new 144	java/lang/StringBuilder
    //   154: dup
    //   155: bipush 44
    //   157: invokespecial 147	java/lang/StringBuilder:<init>	(I)V
    //   160: astore 6
    //   162: aload 6
    //   164: ldc -107
    //   166: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 6
    //   172: lload_2
    //   173: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 6
    //   179: ldc -98
    //   181: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 6
    //   187: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 166	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   193: aload 7
    //   195: ifnull +50 -> 245
    //   198: new 64	com/google/android/gms/ads/exoplayer1/upstream/e
    //   201: dup
    //   202: aload 7
    //   204: getfield 169	com/google/android/gms/ads/internal/cache/CacheOffering:c	Ljava/lang/String;
    //   207: invokestatic 175	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   210: aload_1
    //   211: getfield 176	com/google/android/gms/ads/exoplayer1/upstream/e:a	J
    //   214: aload_1
    //   215: getfield 93	com/google/android/gms/ads/exoplayer1/upstream/e:e	J
    //   218: aload_1
    //   219: getfield 178	com/google/android/gms/ads/exoplayer1/upstream/e:d	J
    //   222: aload_1
    //   223: getfield 179	com/google/android/gms/ads/exoplayer1/upstream/e:c	Ljava/lang/String;
    //   226: aload_1
    //   227: getfield 182	com/google/android/gms/ads/exoplayer1/upstream/e:b	I
    //   230: invokespecial 185	com/google/android/gms/ads/exoplayer1/upstream/e:<init>	(Landroid/net/Uri;JJJLjava/lang/String;I)V
    //   233: astore_1
    //   234: aload_0
    //   235: getfield 26	com/google/android/gms/ads/internal/w/a/w:c	Lcom/google/android/gms/ads/exoplayer1/upstream/d;
    //   238: aload_1
    //   239: invokeinterface 187 2 0
    //   244: lreturn
    //   245: goto -11 -> 234
    //   248: aconst_null
    //   249: astore 6
    //   251: goto -178 -> 73
    //   254: aload 7
    //   256: ifnull -63 -> 193
    //   259: aload 7
    //   261: aload_1
    //   262: getfield 93	com/google/android/gms/ads/exoplayer1/upstream/e:e	J
    //   265: putfield 95	com/google/android/gms/ads/internal/cache/CacheOffering:a	J
    //   268: aload 7
    //   270: getfield 189	com/google/android/gms/ads/internal/cache/CacheOffering:b	Z
    //   273: ifeq +156 -> 429
    //   276: getstatic 192	com/google/android/gms/ads/internal/f/n:y	Lcom/google/android/gms/ads/internal/f/c;
    //   279: invokevirtual 84	com/google/android/gms/ads/internal/f/c:a	()Ljava/lang/Object;
    //   282: checkcast 194	java/lang/Long
    //   285: astore 6
    //   287: aload 6
    //   289: invokevirtual 197	java/lang/Long:longValue	()J
    //   292: lstore_2
    //   293: getstatic 101	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   296: getfield 129	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   299: invokeinterface 134 1 0
    //   304: lstore 4
    //   306: getstatic 101	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   309: getfield 201	com/google/android/gms/ads/internal/bt:z	Lcom/google/android/gms/ads/internal/cache/u;
    //   312: astore 6
    //   314: new 203	com/google/android/gms/ads/internal/cache/n
    //   317: dup
    //   318: aload_0
    //   319: getfield 24	com/google/android/gms/ads/internal/w/a/w:b	Landroid/content/Context;
    //   322: invokespecial 206	com/google/android/gms/ads/internal/cache/n:<init>	(Landroid/content/Context;)V
    //   325: aload 7
    //   327: invokevirtual 209	com/google/android/gms/ads/internal/cache/n:a	(Lcom/google/android/gms/ads/internal/cache/CacheOffering;)Ljava/util/concurrent/Future;
    //   330: astore 6
    //   332: aload_0
    //   333: aload 6
    //   335: lload_2
    //   336: getstatic 215	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   339: invokeinterface 218 4 0
    //   344: checkcast 48	java/io/InputStream
    //   347: putfield 46	com/google/android/gms/ads/internal/w/a/w:a	Ljava/io/InputStream;
    //   350: getstatic 101	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   353: getfield 129	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   356: invokeinterface 134 1 0
    //   361: lload 4
    //   363: lsub
    //   364: lstore_2
    //   365: aload_0
    //   366: getfield 33	com/google/android/gms/ads/internal/w/a/w:e	Ljava/lang/ref/WeakReference;
    //   369: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   372: checkcast 139	com/google/android/gms/ads/internal/w/a/x
    //   375: astore_1
    //   376: aload_1
    //   377: ifnull +11 -> 388
    //   380: aload_1
    //   381: iconst_1
    //   382: lload_2
    //   383: invokeinterface 142 4 0
    //   388: new 144	java/lang/StringBuilder
    //   391: dup
    //   392: bipush 44
    //   394: invokespecial 147	java/lang/StringBuilder:<init>	(I)V
    //   397: astore_1
    //   398: aload_1
    //   399: ldc -107
    //   401: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_1
    //   406: lload_2
    //   407: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_1
    //   412: ldc -98
    //   414: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload_1
    //   419: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 166	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   425: ldc2_w 118
    //   428: lreturn
    //   429: getstatic 220	com/google/android/gms/ads/internal/f/n:z	Lcom/google/android/gms/ads/internal/f/c;
    //   432: invokevirtual 84	com/google/android/gms/ads/internal/f/c:a	()Ljava/lang/Object;
    //   435: checkcast 194	java/lang/Long
    //   438: astore 6
    //   440: goto -153 -> 287
    //   443: astore 8
    //   445: aload 6
    //   447: iconst_1
    //   448: invokeinterface 125 2 0
    //   453: pop
    //   454: invokestatic 226	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   457: invokevirtual 229	java/lang/Thread:interrupt	()V
    //   460: getstatic 101	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   463: getfield 129	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   466: invokeinterface 134 1 0
    //   471: lload 4
    //   473: lsub
    //   474: lstore_2
    //   475: aload_0
    //   476: getfield 33	com/google/android/gms/ads/internal/w/a/w:e	Ljava/lang/ref/WeakReference;
    //   479: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   482: checkcast 139	com/google/android/gms/ads/internal/w/a/x
    //   485: astore 6
    //   487: aload 6
    //   489: ifnull +12 -> 501
    //   492: aload 6
    //   494: iconst_0
    //   495: lload_2
    //   496: invokeinterface 142 4 0
    //   501: new 144	java/lang/StringBuilder
    //   504: dup
    //   505: bipush 44
    //   507: invokespecial 147	java/lang/StringBuilder:<init>	(I)V
    //   510: astore 6
    //   512: aload 6
    //   514: ldc -107
    //   516: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload 6
    //   522: lload_2
    //   523: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload 6
    //   529: ldc -98
    //   531: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload 6
    //   537: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokestatic 166	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   543: goto -350 -> 193
    //   546: astore_1
    //   547: getstatic 101	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   550: getfield 129	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   553: invokeinterface 134 1 0
    //   558: lload 4
    //   560: lsub
    //   561: lstore_2
    //   562: aload_0
    //   563: getfield 33	com/google/android/gms/ads/internal/w/a/w:e	Ljava/lang/ref/WeakReference;
    //   566: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   569: checkcast 139	com/google/android/gms/ads/internal/w/a/x
    //   572: astore 6
    //   574: aload 6
    //   576: ifnull +12 -> 588
    //   579: aload 6
    //   581: iconst_0
    //   582: lload_2
    //   583: invokeinterface 142 4 0
    //   588: new 144	java/lang/StringBuilder
    //   591: dup
    //   592: bipush 44
    //   594: invokespecial 147	java/lang/StringBuilder:<init>	(I)V
    //   597: astore 6
    //   599: aload 6
    //   601: ldc -107
    //   603: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload 6
    //   609: lload_2
    //   610: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload 6
    //   616: ldc -98
    //   618: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload 6
    //   624: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 166	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   630: aload_1
    //   631: athrow
    //   632: astore 8
    //   634: goto -533 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	637	0	this	w
    //   0	637	1	parame	com.google.android.gms.ads.exoplayer1.upstream.e
    //   124	486	2	l1	long
    //   121	1	4	localObject1	Object
    //   304	255	4	l2	long
    //   71	552	6	localObject2	Object
    //   29	297	7	localCacheOffering	com.google.android.gms.ads.internal.cache.CacheOffering
    //   99	1	8	localExecutionException	java.util.concurrent.ExecutionException
    //   443	1	8	localInterruptedException	InterruptedException
    //   632	1	8	localTimeoutException	java.util.concurrent.TimeoutException
    // Exception table:
    //   from	to	target	type
    //   332	350	99	java/util/concurrent/ExecutionException
    //   332	350	443	java/lang/InterruptedException
    //   101	110	546	finally
    //   332	350	546	finally
    //   445	460	546	finally
    //   332	350	632	java/util/concurrent/TimeoutException
  }
  
  public final void a()
  {
    if (!this.d) {
      throw new IOException("Attempt to close an already closed CacheDataSource.");
    }
    this.d = false;
    InputStream localInputStream = this.a;
    if (localInputStream != null)
    {
      g.a(localInputStream);
      this.a = null;
      return;
    }
    this.c.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */