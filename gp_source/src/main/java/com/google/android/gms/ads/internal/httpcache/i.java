package com.google.android.gms.ads.internal.httpcache;

import android.content.Context;
import com.android.volley.k;

@com.google.android.gms.ads.internal.q.a.a
public final class i
  implements k
{
  public volatile a a;
  private final Context b;
  
  public i(Context paramContext)
  {
    this.b = paramContext;
  }
  
  /* Error */
  public final com.android.volley.m a(com.android.volley.n paramn)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_1
    //   4: invokestatic 29	com/google/android/gms/ads/internal/httpcache/HttpRequestParcel:a	(Lcom/android/volley/n;)Lcom/google/android/gms/ads/internal/httpcache/HttpRequestParcel;
    //   7: astore_1
    //   8: getstatic 35	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   11: getfield 39	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   14: invokeinterface 44 1 0
    //   19: lstore_3
    //   20: new 46	com/google/android/gms/ads/internal/util/a/af
    //   23: dup
    //   24: invokespecial 47	com/google/android/gms/ads/internal/util/a/af:<init>	()V
    //   27: astore 8
    //   29: new 49	com/google/android/gms/ads/internal/httpcache/m
    //   32: dup
    //   33: aload_0
    //   34: aload 8
    //   36: invokespecial 52	com/google/android/gms/ads/internal/httpcache/m:<init>	(Lcom/google/android/gms/ads/internal/httpcache/i;Lcom/google/android/gms/ads/internal/util/a/af;)V
    //   39: astore 9
    //   41: new 54	com/google/android/gms/ads/internal/httpcache/n
    //   44: dup
    //   45: aload 8
    //   47: invokespecial 57	com/google/android/gms/ads/internal/httpcache/n:<init>	(Lcom/google/android/gms/ads/internal/util/a/af;)V
    //   50: astore 10
    //   52: aload_0
    //   53: new 59	com/google/android/gms/ads/internal/httpcache/a
    //   56: dup
    //   57: aload_0
    //   58: getfield 18	com/google/android/gms/ads/internal/httpcache/i:b	Landroid/content/Context;
    //   61: getstatic 35	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   64: getfield 63	com/google/android/gms/ads/internal/bt:t	Lcom/google/android/gms/ads/internal/util/bj;
    //   67: invokevirtual 68	com/google/android/gms/ads/internal/util/bj:a	()Landroid/os/Looper;
    //   70: aload 9
    //   72: aload 10
    //   74: invokespecial 71	com/google/android/gms/ads/internal/httpcache/a:<init>	(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/common/internal/b;Lcom/google/android/gms/common/internal/c;)V
    //   77: putfield 73	com/google/android/gms/ads/internal/httpcache/i:a	Lcom/google/android/gms/ads/internal/httpcache/a;
    //   80: aload_0
    //   81: getfield 73	com/google/android/gms/ads/internal/httpcache/i:a	Lcom/google/android/gms/ads/internal/httpcache/a;
    //   84: invokevirtual 78	com/google/android/gms/common/internal/a:r	()V
    //   87: aload 8
    //   89: new 80	com/google/android/gms/ads/internal/httpcache/j
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 83	com/google/android/gms/ads/internal/httpcache/j:<init>	(Lcom/google/android/gms/ads/internal/httpcache/HttpRequestParcel;)V
    //   97: getstatic 89	com/google/android/gms/ads/internal/util/l:c	Lcom/google/android/gms/ads/internal/util/a/z;
    //   100: invokestatic 94	com/google/android/gms/ads/internal/util/a/h:a	(Lcom/google/android/gms/ads/internal/util/a/v;Lcom/google/android/gms/ads/internal/util/a/b;Ljava/util/concurrent/Executor;)Lcom/google/android/gms/ads/internal/util/a/v;
    //   103: getstatic 100	com/google/android/gms/ads/internal/f/n:aD	Lcom/google/android/gms/ads/internal/f/c;
    //   106: invokevirtual 105	com/google/android/gms/ads/internal/f/c:a	()Ljava/lang/Object;
    //   109: checkcast 107	java/lang/Integer
    //   112: invokevirtual 111	java/lang/Integer:intValue	()I
    //   115: i2l
    //   116: getstatic 117	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   119: getstatic 120	com/google/android/gms/ads/internal/util/l:b	Ljava/util/concurrent/ScheduledExecutorService;
    //   122: invokestatic 123	com/google/android/gms/ads/internal/util/a/h:a	(Lcom/google/android/gms/ads/internal/util/a/v;JLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/ScheduledExecutorService;)Lcom/google/android/gms/ads/internal/util/a/v;
    //   125: astore_1
    //   126: aload_1
    //   127: new 125	com/google/android/gms/ads/internal/httpcache/l
    //   130: dup
    //   131: aload_0
    //   132: invokespecial 128	com/google/android/gms/ads/internal/httpcache/l:<init>	(Lcom/google/android/gms/ads/internal/httpcache/i;)V
    //   135: getstatic 89	com/google/android/gms/ads/internal/util/l:c	Lcom/google/android/gms/ads/internal/util/a/z;
    //   138: invokeinterface 133 3 0
    //   143: aload_1
    //   144: invokeinterface 136 1 0
    //   149: checkcast 138	android/os/ParcelFileDescriptor
    //   152: astore_1
    //   153: getstatic 35	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   156: getfield 39	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   159: invokeinterface 44 1 0
    //   164: lstore 5
    //   166: new 140	java/lang/StringBuilder
    //   169: dup
    //   170: bipush 52
    //   172: invokespecial 143	java/lang/StringBuilder:<init>	(I)V
    //   175: astore 8
    //   177: aload 8
    //   179: ldc -111
    //   181: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 8
    //   187: lload 5
    //   189: lload_3
    //   190: lsub
    //   191: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 8
    //   197: ldc -102
    //   199: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 8
    //   205: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 163	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   211: new 165	com/google/android/gms/ads/internal/request/LargeParcelTeleporter
    //   214: dup
    //   215: aload_1
    //   216: invokespecial 168	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   219: getstatic 174	com/google/android/gms/ads/internal/httpcache/HttpResponseParcel:CREATOR	Landroid/os/Parcelable$Creator;
    //   222: invokevirtual 177	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:a	(Landroid/os/Parcelable$Creator;)Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;
    //   225: checkcast 170	com/google/android/gms/ads/internal/httpcache/HttpResponseParcel
    //   228: astore 8
    //   230: aload 7
    //   232: astore_1
    //   233: aload 8
    //   235: ifnull +118 -> 353
    //   238: aload 8
    //   240: getfield 180	com/google/android/gms/ads/internal/httpcache/HttpResponseParcel:c	Z
    //   243: ifeq +16 -> 259
    //   246: new 182	com/android/volley/VolleyError
    //   249: dup
    //   250: aload 8
    //   252: getfield 185	com/google/android/gms/ads/internal/httpcache/HttpResponseParcel:b	Ljava/lang/String;
    //   255: invokespecial 187	com/android/volley/VolleyError:<init>	(Ljava/lang/String;)V
    //   258: athrow
    //   259: aload 7
    //   261: astore_1
    //   262: aload 8
    //   264: getfield 191	com/google/android/gms/ads/internal/httpcache/HttpResponseParcel:d	[Ljava/lang/String;
    //   267: arraylength
    //   268: aload 8
    //   270: getfield 194	com/google/android/gms/ads/internal/httpcache/HttpResponseParcel:e	[Ljava/lang/String;
    //   273: arraylength
    //   274: if_icmpne +79 -> 353
    //   277: new 196	java/util/HashMap
    //   280: dup
    //   281: invokespecial 197	java/util/HashMap:<init>	()V
    //   284: astore_1
    //   285: iconst_0
    //   286: istore_2
    //   287: aload 8
    //   289: getfield 191	com/google/android/gms/ads/internal/httpcache/HttpResponseParcel:d	[Ljava/lang/String;
    //   292: astore 7
    //   294: iload_2
    //   295: aload 7
    //   297: arraylength
    //   298: if_icmpge +26 -> 324
    //   301: aload_1
    //   302: aload 7
    //   304: iload_2
    //   305: aaload
    //   306: aload 8
    //   308: getfield 194	com/google/android/gms/ads/internal/httpcache/HttpResponseParcel:e	[Ljava/lang/String;
    //   311: iload_2
    //   312: aaload
    //   313: invokevirtual 201	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   316: pop
    //   317: iload_2
    //   318: iconst_1
    //   319: iadd
    //   320: istore_2
    //   321: goto -34 -> 287
    //   324: new 203	com/android/volley/m
    //   327: dup
    //   328: aload 8
    //   330: getfield 207	com/google/android/gms/ads/internal/httpcache/HttpResponseParcel:h	I
    //   333: aload 8
    //   335: getfield 210	com/google/android/gms/ads/internal/httpcache/HttpResponseParcel:a	[B
    //   338: aload_1
    //   339: aload 8
    //   341: getfield 213	com/google/android/gms/ads/internal/httpcache/HttpResponseParcel:g	Z
    //   344: aload 8
    //   346: getfield 217	com/google/android/gms/ads/internal/httpcache/HttpResponseParcel:f	J
    //   349: invokespecial 220	com/android/volley/m:<init>	(I[BLjava/util/Map;ZJ)V
    //   352: astore_1
    //   353: aload_1
    //   354: areturn
    //   355: astore_1
    //   356: getstatic 35	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   359: getfield 39	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   362: invokeinterface 44 1 0
    //   367: lstore 5
    //   369: new 140	java/lang/StringBuilder
    //   372: dup
    //   373: bipush 52
    //   375: invokespecial 143	java/lang/StringBuilder:<init>	(I)V
    //   378: astore_1
    //   379: aload_1
    //   380: ldc -111
    //   382: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload_1
    //   387: lload 5
    //   389: lload_3
    //   390: lsub
    //   391: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload_1
    //   396: ldc -102
    //   398: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload_1
    //   403: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 163	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   409: aconst_null
    //   410: areturn
    //   411: astore_1
    //   412: getstatic 35	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   415: getfield 39	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   418: invokeinterface 44 1 0
    //   423: lstore 5
    //   425: new 140	java/lang/StringBuilder
    //   428: dup
    //   429: bipush 52
    //   431: invokespecial 143	java/lang/StringBuilder:<init>	(I)V
    //   434: astore 7
    //   436: aload 7
    //   438: ldc -111
    //   440: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload 7
    //   446: lload 5
    //   448: lload_3
    //   449: lsub
    //   450: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload 7
    //   456: ldc -102
    //   458: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload 7
    //   464: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 163	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   470: aload_1
    //   471: athrow
    //   472: astore_1
    //   473: goto -117 -> 356
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	this	i
    //   0	476	1	paramn	com.android.volley.n
    //   286	35	2	i	int
    //   19	430	3	l1	long
    //   164	283	5	l2	long
    //   1	462	7	localObject1	Object
    //   27	318	8	localObject2	Object
    //   39	32	9	localm	m
    //   50	23	10	localn	n
    // Exception table:
    //   from	to	target	type
    //   20	153	355	java/lang/InterruptedException
    //   20	153	411	finally
    //   20	153	472	java/util/concurrent/ExecutionException
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/httpcache/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */