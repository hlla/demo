package com.google.android.gms.ads.internal.w.b.a;

import android.annotation.TargetApi;
import com.google.android.gms.ads.exoplayer1.af;
import com.google.android.gms.ads.internal.w.ad;
import com.google.android.gms.ads.internal.w.b.k;

@com.google.android.gms.ads.internal.q.a.a
@TargetApi(16)
public abstract class f
  extends k
{
  public final com.google.android.gms.ads.internal.w.a.a d = new com.google.android.gms.ads.internal.w.a.a();
  public String e = null;
  public boolean f;
  private boolean g;
  
  public f(ad paramad)
  {
    super(paramad);
    this.d.a(new g(this));
  }
  
  public final void a()
  {
    try
    {
      this.g = true;
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 49	com/google/android/gms/ads/internal/w/b/a/f:c	(Ljava/lang/String;)Lcom/google/android/gms/ads/exoplayer1/af;
    //   5: astore 21
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 53	com/google/android/gms/ads/internal/w/b/k:b	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore 24
    //   14: aload_0
    //   15: getfield 28	com/google/android/gms/ads/internal/w/b/a/f:d	Lcom/google/android/gms/ads/internal/w/a/a;
    //   18: aload 21
    //   20: invokevirtual 56	com/google/android/gms/ads/internal/w/a/a:a	(Lcom/google/android/gms/ads/exoplayer1/af;)Z
    //   23: ifeq +429 -> 452
    //   26: aload_0
    //   27: getfield 28	com/google/android/gms/ads/internal/w/b/a/f:d	Lcom/google/android/gms/ads/internal/w/a/a;
    //   30: getfield 59	com/google/android/gms/ads/internal/w/a/a:c	Lcom/google/android/gms/ads/exoplayer1/d;
    //   33: astore 21
    //   35: aload 21
    //   37: ifnull +442 -> 479
    //   40: aload_0
    //   41: getfield 62	com/google/android/gms/ads/internal/w/b/a/f:c	Ljava/lang/ref/WeakReference;
    //   44: invokevirtual 68	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   47: checkcast 70	com/google/android/gms/ads/internal/w/ad
    //   50: astore 22
    //   52: aload 22
    //   54: ifnonnull +385 -> 439
    //   57: getstatic 76	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   60: getfield 80	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   63: astore 22
    //   65: aload 22
    //   67: invokeinterface 85 1 0
    //   72: lstore 10
    //   74: getstatic 91	com/google/android/gms/ads/internal/f/n:cr	Lcom/google/android/gms/ads/internal/f/c;
    //   77: invokevirtual 95	com/google/android/gms/ads/internal/f/c:a	()Ljava/lang/Object;
    //   80: checkcast 97	java/lang/Long
    //   83: invokevirtual 100	java/lang/Long:longValue	()J
    //   86: lstore 12
    //   88: getstatic 103	com/google/android/gms/ads/internal/f/n:cq	Lcom/google/android/gms/ads/internal/f/c;
    //   91: invokevirtual 95	com/google/android/gms/ads/internal/f/c:a	()Ljava/lang/Object;
    //   94: checkcast 97	java/lang/Long
    //   97: invokevirtual 100	java/lang/Long:longValue	()J
    //   100: ldc2_w 104
    //   103: lmul
    //   104: lstore 14
    //   106: getstatic 108	com/google/android/gms/ads/internal/f/n:ct	Lcom/google/android/gms/ads/internal/f/c;
    //   109: invokevirtual 95	com/google/android/gms/ads/internal/f/c:a	()Ljava/lang/Object;
    //   112: checkcast 110	java/lang/Integer
    //   115: invokevirtual 114	java/lang/Integer:intValue	()I
    //   118: i2l
    //   119: lstore 16
    //   121: ldc2_w 115
    //   124: lstore_2
    //   125: aload_0
    //   126: monitorenter
    //   127: aload 22
    //   129: invokeinterface 85 1 0
    //   134: lload 10
    //   136: lsub
    //   137: lload 14
    //   139: lcmp
    //   140: ifgt +366 -> 506
    //   143: aload_0
    //   144: getfield 40	com/google/android/gms/ads/internal/w/b/a/f:g	Z
    //   147: ifne +436 -> 583
    //   150: aload_0
    //   151: getfield 118	com/google/android/gms/ads/internal/w/b/a/f:f	Z
    //   154: ifne +280 -> 434
    //   157: aload 21
    //   159: invokeinterface 122 1 0
    //   164: lstore 18
    //   166: lload_2
    //   167: lstore 6
    //   169: lload 18
    //   171: lconst_0
    //   172: lcmp
    //   173: ifle +100 -> 273
    //   176: aload 21
    //   178: invokeinterface 124 1 0
    //   183: lstore 8
    //   185: lload_2
    //   186: lstore 4
    //   188: lload 8
    //   190: lload_2
    //   191: lcmp
    //   192: ifeq +41 -> 233
    //   195: lload 8
    //   197: lconst_0
    //   198: lcmp
    //   199: ifle +229 -> 428
    //   202: iconst_1
    //   203: istore 20
    //   205: getstatic 129	com/google/android/gms/ads/internal/util/client/a:g	Landroid/os/Handler;
    //   208: new 131	com/google/android/gms/ads/internal/w/b/n
    //   211: dup
    //   212: aload_0
    //   213: aload_1
    //   214: aload 24
    //   216: lload 8
    //   218: lload 18
    //   220: iload 20
    //   222: invokespecial 134	com/google/android/gms/ads/internal/w/b/n:<init>	(Lcom/google/android/gms/ads/internal/w/b/k;Ljava/lang/String;Ljava/lang/String;JJZ)V
    //   225: invokevirtual 140	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   228: pop
    //   229: lload 8
    //   231: lstore 4
    //   233: lload 8
    //   235: lload 18
    //   237: lcmp
    //   238: ifge +157 -> 395
    //   241: aload_0
    //   242: invokevirtual 142	com/google/android/gms/ads/internal/w/b/a/f:c	()I
    //   245: pop
    //   246: lload 4
    //   248: lstore 6
    //   250: lload 16
    //   252: lconst_0
    //   253: lcmp
    //   254: ifgt +19 -> 273
    //   257: lload 4
    //   259: lstore 6
    //   261: lload 8
    //   263: lconst_0
    //   264: lcmp
    //   265: ifle +8 -> 273
    //   268: aload_0
    //   269: monitorexit
    //   270: goto +387 -> 657
    //   273: aload_0
    //   274: monitorexit
    //   275: lload 12
    //   277: invokestatic 148	java/lang/Thread:sleep	(J)V
    //   280: lload 6
    //   282: lstore_2
    //   283: goto -158 -> 125
    //   286: astore 21
    //   288: ldc -106
    //   290: astore 22
    //   292: ldc -104
    //   294: astore 21
    //   296: new 43	java/io/IOException
    //   299: dup
    //   300: ldc -102
    //   302: invokespecial 157	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   305: athrow
    //   306: astore 23
    //   308: aload 23
    //   310: invokevirtual 161	java/io/IOException:getMessage	()Ljava/lang/String;
    //   313: astore 23
    //   315: new 163	java/lang/StringBuilder
    //   318: dup
    //   319: aload_1
    //   320: invokestatic 169	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   323: invokevirtual 172	java/lang/String:length	()I
    //   326: bipush 34
    //   328: iadd
    //   329: aload 23
    //   331: invokestatic 169	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   334: invokevirtual 172	java/lang/String:length	()I
    //   337: iadd
    //   338: invokespecial 175	java/lang/StringBuilder:<init>	(I)V
    //   341: astore 25
    //   343: aload 25
    //   345: ldc -79
    //   347: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 25
    //   353: aload_1
    //   354: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 25
    //   360: ldc -73
    //   362: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 25
    //   368: aload 23
    //   370: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 25
    //   376: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 190	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   382: aload_0
    //   383: aload_1
    //   384: aload 24
    //   386: aload 22
    //   388: aload 21
    //   390: invokevirtual 193	com/google/android/gms/ads/internal/w/b/k:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   393: iconst_0
    //   394: ireturn
    //   395: aload_0
    //   396: aload_1
    //   397: aload 24
    //   399: lload 18
    //   401: invokevirtual 196	com/google/android/gms/ads/internal/w/b/k:a	(Ljava/lang/String;Ljava/lang/String;J)V
    //   404: aload_0
    //   405: monitorexit
    //   406: goto +251 -> 657
    //   409: astore 23
    //   411: aconst_null
    //   412: astore 21
    //   414: ldc -106
    //   416: astore 22
    //   418: aload_0
    //   419: monitorexit
    //   420: aload 23
    //   422: athrow
    //   423: astore 23
    //   425: goto -117 -> 308
    //   428: iconst_0
    //   429: istore 20
    //   431: goto -226 -> 205
    //   434: aload_0
    //   435: monitorexit
    //   436: goto +221 -> 657
    //   439: aload 22
    //   441: aload 24
    //   443: aload_0
    //   444: invokeinterface 199 3 0
    //   449: goto -392 -> 57
    //   452: ldc -55
    //   454: astore 22
    //   456: ldc -53
    //   458: astore 21
    //   460: aload_0
    //   461: invokevirtual 205	com/google/android/gms/ads/internal/w/b/k:b	()V
    //   464: new 43	java/io/IOException
    //   467: dup
    //   468: ldc -49
    //   470: invokespecial 157	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   473: athrow
    //   474: astore 23
    //   476: goto -168 -> 308
    //   479: ldc -55
    //   481: astore 22
    //   483: ldc -47
    //   485: astore 21
    //   487: aload_0
    //   488: invokevirtual 205	com/google/android/gms/ads/internal/w/b/k:b	()V
    //   491: new 43	java/io/IOException
    //   494: dup
    //   495: ldc -45
    //   497: invokespecial 157	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   500: athrow
    //   501: astore 23
    //   503: goto -195 -> 308
    //   506: lload 14
    //   508: invokestatic 214	java/lang/Long:toString	(J)Ljava/lang/String;
    //   511: astore 21
    //   513: new 163	java/lang/StringBuilder
    //   516: dup
    //   517: aload 21
    //   519: invokestatic 169	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   522: invokevirtual 172	java/lang/String:length	()I
    //   525: bipush 27
    //   527: iadd
    //   528: invokespecial 175	java/lang/StringBuilder:<init>	(I)V
    //   531: astore 22
    //   533: aload 22
    //   535: ldc -40
    //   537: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 22
    //   543: aload 21
    //   545: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload 22
    //   551: ldc -38
    //   553: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload 22
    //   559: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: astore 21
    //   564: new 43	java/io/IOException
    //   567: dup
    //   568: ldc -36
    //   570: invokespecial 157	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   573: athrow
    //   574: astore 23
    //   576: ldc -34
    //   578: astore 22
    //   580: goto -162 -> 418
    //   583: aload_0
    //   584: getfield 21	com/google/android/gms/ads/internal/w/b/a/f:e	Ljava/lang/String;
    //   587: invokestatic 228	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   590: ifeq +37 -> 627
    //   593: ldc -26
    //   595: astore 22
    //   597: aconst_null
    //   598: astore 21
    //   600: new 43	java/io/IOException
    //   603: dup
    //   604: ldc -24
    //   606: invokespecial 157	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   609: athrow
    //   610: astore 23
    //   612: goto -194 -> 418
    //   615: astore 23
    //   617: ldc -34
    //   619: astore 22
    //   621: aconst_null
    //   622: astore 21
    //   624: goto -206 -> 418
    //   627: ldc -22
    //   629: astore 22
    //   631: aload_0
    //   632: getfield 21	com/google/android/gms/ads/internal/w/b/a/f:e	Ljava/lang/String;
    //   635: astore 21
    //   637: ldc -22
    //   639: astore 22
    //   641: goto -41 -> 600
    //   644: astore 23
    //   646: aconst_null
    //   647: astore 21
    //   649: goto -231 -> 418
    //   652: astore 23
    //   654: goto -236 -> 418
    //   657: iconst_1
    //   658: ireturn
    //   659: astore 23
    //   661: aconst_null
    //   662: astore 21
    //   664: ldc -106
    //   666: astore 22
    //   668: goto -360 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	671	0	this	f
    //   0	671	1	paramString	String
    //   124	159	2	l1	long
    //   186	72	4	l2	long
    //   167	114	6	l3	long
    //   183	79	8	l4	long
    //   72	63	10	l5	long
    //   86	190	12	l6	long
    //   104	403	14	l7	long
    //   119	132	16	l8	long
    //   164	236	18	l9	long
    //   203	227	20	bool	boolean
    //   5	172	21	localObject1	Object
    //   286	1	21	localInterruptedException	InterruptedException
    //   294	369	21	str1	String
    //   50	617	22	localObject2	Object
    //   306	3	23	localIOException1	java.io.IOException
    //   313	56	23	str2	String
    //   409	12	23	localObject3	Object
    //   423	1	23	localIOException2	java.io.IOException
    //   474	1	23	localIOException3	java.io.IOException
    //   501	1	23	localIOException4	java.io.IOException
    //   574	1	23	localObject4	Object
    //   610	1	23	localObject5	Object
    //   615	1	23	localObject6	Object
    //   644	1	23	localObject7	Object
    //   652	1	23	localObject8	Object
    //   659	1	23	localIOException5	java.io.IOException
    //   12	430	24	str3	String
    //   341	34	25	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   275	280	286	java/lang/InterruptedException
    //   296	306	306	java/io/IOException
    //   127	166	409	finally
    //   176	185	409	finally
    //   205	229	409	finally
    //   241	246	409	finally
    //   268	270	409	finally
    //   273	275	409	finally
    //   395	406	409	finally
    //   434	436	409	finally
    //   583	593	409	finally
    //   420	423	423	java/io/IOException
    //   460	474	474	java/io/IOException
    //   487	501	501	java/io/IOException
    //   564	574	574	finally
    //   600	610	610	finally
    //   506	564	615	finally
    //   631	637	644	finally
    //   418	420	652	finally
    //   14	35	659	java/io/IOException
    //   40	52	659	java/io/IOException
    //   57	121	659	java/io/IOException
    //   125	127	659	java/io/IOException
    //   275	280	659	java/io/IOException
    //   439	449	659	java/io/IOException
  }
  
  protected final String b(String paramString)
  {
    String str = String.valueOf("cache:");
    paramString = String.valueOf(super.b(paramString));
    if (paramString.length() == 0) {
      return new String(str);
    }
    return str.concat(paramString);
  }
  
  public final void b()
  {
    this.d.a();
    super.b();
  }
  
  protected abstract int c();
  
  protected abstract af c(String paramString);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/b/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */