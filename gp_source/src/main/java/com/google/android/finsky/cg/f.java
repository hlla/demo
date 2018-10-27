package com.google.android.finsky.cg;

import android.content.ContentValues;
import com.google.android.finsky.e.a.a;
import com.google.android.finsky.utils.j;
import com.google.protobuf.nano.g;

public final class f
{
  public final ContentValues a = new ContentValues();
  public final String b;
  
  public f(String paramString)
  {
    this.b = paramString;
    this.a.put("package_name", paramString);
  }
  
  private final int a(String paramString, int paramInt)
  {
    if (this.a.containsKey(paramString)) {
      paramInt = this.a.getAsInteger(paramString).intValue();
    }
    return paramInt;
  }
  
  private final long a(String paramString, long paramLong)
  {
    if (this.a.containsKey(paramString)) {
      paramLong = this.a.getAsLong(paramString).longValue();
    }
    return paramLong;
  }
  
  private final String a(String paramString1, String paramString2)
  {
    if (this.a.containsKey(paramString1)) {
      paramString2 = this.a.getAsString(paramString1);
    }
    return paramString2;
  }
  
  private final String[] a(String paramString, String[] paramArrayOfString)
  {
    if (this.a.containsKey(paramString)) {
      paramArrayOfString = j.a(this.a.getAsString(paramString));
    }
    return paramArrayOfString;
  }
  
  /* Error */
  public final c a(c paramc)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_3
    //   2: aload_1
    //   3: ifnonnull +15 -> 18
    //   6: new 71	com/google/android/finsky/cg/c
    //   9: dup
    //   10: aload_0
    //   11: getfield 20	com/google/android/finsky/cg/f:b	Ljava/lang/String;
    //   14: invokespecial 73	com/google/android/finsky/cg/c:<init>	(Ljava/lang/String;)V
    //   17: astore_3
    //   18: aload_0
    //   19: getfield 18	com/google/android/finsky/cg/f:a	Landroid/content/ContentValues;
    //   22: ldc 75
    //   24: invokevirtual 32	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   27: ifne +572 -> 599
    //   30: aload_3
    //   31: getfield 79	com/google/android/finsky/cg/c:i	Lcom/google/wireless/android/finsky/b/a;
    //   34: astore 4
    //   36: aload_0
    //   37: getfield 18	com/google/android/finsky/cg/f:a	Landroid/content/ContentValues;
    //   40: ldc 81
    //   42: invokevirtual 32	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   45: ifne +537 -> 582
    //   48: aload_3
    //   49: getfield 85	com/google/android/finsky/cg/c:e	Lcom/google/android/finsky/ds/a/o;
    //   52: astore 5
    //   54: aload_0
    //   55: getfield 18	com/google/android/finsky/cg/f:a	Landroid/content/ContentValues;
    //   58: ldc 87
    //   60: invokevirtual 32	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   63: ifne +502 -> 565
    //   66: aload_3
    //   67: getfield 91	com/google/android/finsky/cg/c:u	Lcom/google/android/finsky/e/a/a;
    //   70: astore 6
    //   72: aload_0
    //   73: getfield 18	com/google/android/finsky/cg/f:a	Landroid/content/ContentValues;
    //   76: ldc 93
    //   78: invokevirtual 32	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   81: ifne +467 -> 548
    //   84: aload_3
    //   85: getfield 96	com/google/android/finsky/cg/c:C	Lcom/google/android/finsky/e/a/a;
    //   88: astore 7
    //   90: aload_0
    //   91: getfield 18	com/google/android/finsky/cg/f:a	Landroid/content/ContentValues;
    //   94: ldc 98
    //   96: invokevirtual 32	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   99: ifne +432 -> 531
    //   102: aload_3
    //   103: getfield 102	com/google/android/finsky/cg/c:w	Lcom/google/android/finsky/installer/b/a/d;
    //   106: astore 8
    //   108: aload_0
    //   109: getfield 18	com/google/android/finsky/cg/f:a	Landroid/content/ContentValues;
    //   112: ldc 104
    //   114: invokevirtual 32	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   117: ifeq +405 -> 522
    //   120: aload_0
    //   121: getfield 18	com/google/android/finsky/cg/f:a	Landroid/content/ContentValues;
    //   124: ldc 104
    //   126: invokevirtual 108	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   129: astore 9
    //   131: aload_0
    //   132: ldc 110
    //   134: aload_3
    //   135: getfield 114	com/google/android/finsky/cg/c:f	I
    //   138: invokespecial 116	com/google/android/finsky/cg/f:a	(Ljava/lang/String;I)I
    //   141: istore_2
    //   142: aload_0
    //   143: getfield 18	com/google/android/finsky/cg/f:a	Landroid/content/ContentValues;
    //   146: ldc 118
    //   148: invokevirtual 32	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   151: ifeq +363 -> 514
    //   154: aload_0
    //   155: getfield 18	com/google/android/finsky/cg/f:a	Landroid/content/ContentValues;
    //   158: ldc 118
    //   160: invokevirtual 58	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore 10
    //   165: aload 10
    //   167: iconst_1
    //   168: invokestatic 124	android/content/Intent:parseUri	(Ljava/lang/String;I)Landroid/content/Intent;
    //   171: astore_1
    //   172: new 71	com/google/android/finsky/cg/c
    //   175: dup
    //   176: aload_3
    //   177: getfield 127	com/google/android/finsky/cg/c:F	Ljava/lang/String;
    //   180: iload_2
    //   181: aload_0
    //   182: ldc -127
    //   184: aload_3
    //   185: getfield 132	com/google/android/finsky/cg/c:n	I
    //   188: invokespecial 116	com/google/android/finsky/cg/f:a	(Ljava/lang/String;I)I
    //   191: aload_0
    //   192: ldc -122
    //   194: aload_3
    //   195: getfield 137	com/google/android/finsky/cg/c:m	I
    //   198: invokespecial 116	com/google/android/finsky/cg/f:a	(Ljava/lang/String;I)I
    //   201: aload_0
    //   202: ldc -117
    //   204: aload_3
    //   205: getfield 142	com/google/android/finsky/cg/c:A	I
    //   208: invokespecial 116	com/google/android/finsky/cg/f:a	(Ljava/lang/String;I)I
    //   211: aload 4
    //   213: aload_0
    //   214: ldc -112
    //   216: aload_3
    //   217: getfield 148	com/google/android/finsky/cg/c:j	J
    //   220: invokespecial 150	com/google/android/finsky/cg/f:a	(Ljava/lang/String;J)J
    //   223: aload_0
    //   224: ldc -104
    //   226: aload_3
    //   227: getfield 155	com/google/android/finsky/cg/c:y	I
    //   230: invokespecial 116	com/google/android/finsky/cg/f:a	(Ljava/lang/String;I)I
    //   233: aload_0
    //   234: ldc -99
    //   236: aload_3
    //   237: getfield 160	com/google/android/finsky/cg/c:o	Ljava/lang/String;
    //   240: invokespecial 162	com/google/android/finsky/cg/f:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   243: aload_0
    //   244: ldc -92
    //   246: aload_3
    //   247: getfield 167	com/google/android/finsky/cg/c:r	J
    //   250: invokespecial 150	com/google/android/finsky/cg/f:a	(Ljava/lang/String;J)J
    //   253: aload_0
    //   254: ldc -87
    //   256: aload_3
    //   257: getfield 172	com/google/android/finsky/cg/c:p	Ljava/lang/String;
    //   260: invokespecial 162	com/google/android/finsky/cg/f:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   263: aload_0
    //   264: ldc -82
    //   266: aload_3
    //   267: getfield 177	com/google/android/finsky/cg/c:h	Ljava/lang/String;
    //   270: invokespecial 162	com/google/android/finsky/cg/f:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   273: aload_0
    //   274: ldc -77
    //   276: aload_3
    //   277: getfield 180	com/google/android/finsky/cg/c:b	Ljava/lang/String;
    //   280: invokespecial 162	com/google/android/finsky/cg/f:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   283: aload_0
    //   284: ldc -74
    //   286: aload_3
    //   287: getfield 185	com/google/android/finsky/cg/c:L	Ljava/lang/String;
    //   290: invokespecial 162	com/google/android/finsky/cg/f:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   293: aload_0
    //   294: ldc -69
    //   296: aload_3
    //   297: getfield 190	com/google/android/finsky/cg/c:s	I
    //   300: invokespecial 116	com/google/android/finsky/cg/f:a	(Ljava/lang/String;I)I
    //   303: aload_0
    //   304: ldc -64
    //   306: aload_3
    //   307: getfield 195	com/google/android/finsky/cg/c:B	J
    //   310: invokespecial 150	com/google/android/finsky/cg/f:a	(Ljava/lang/String;J)J
    //   313: aload_0
    //   314: ldc -59
    //   316: aload_3
    //   317: getfield 199	com/google/android/finsky/cg/c:a	Ljava/lang/String;
    //   320: invokespecial 162	com/google/android/finsky/cg/f:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   323: aload_0
    //   324: ldc -55
    //   326: aload_3
    //   327: getfield 204	com/google/android/finsky/cg/c:q	J
    //   330: invokespecial 150	com/google/android/finsky/cg/f:a	(Ljava/lang/String;J)J
    //   333: aload_0
    //   334: ldc -50
    //   336: aload_3
    //   337: getfield 209	com/google/android/finsky/cg/c:H	I
    //   340: invokespecial 116	com/google/android/finsky/cg/f:a	(Ljava/lang/String;I)I
    //   343: aload_0
    //   344: ldc -45
    //   346: aload_3
    //   347: getfield 214	com/google/android/finsky/cg/c:G	I
    //   350: invokespecial 116	com/google/android/finsky/cg/f:a	(Ljava/lang/String;I)I
    //   353: aload_0
    //   354: ldc -40
    //   356: aload_3
    //   357: getfield 219	com/google/android/finsky/cg/c:k	Ljava/lang/String;
    //   360: invokespecial 162	com/google/android/finsky/cg/f:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   363: aload_0
    //   364: ldc -35
    //   366: aload_3
    //   367: getfield 225	com/google/android/finsky/cg/c:g	[Ljava/lang/String;
    //   370: invokespecial 227	com/google/android/finsky/cg/f:a	(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;
    //   373: aload_0
    //   374: ldc -27
    //   376: aload_3
    //   377: getfield 232	com/google/android/finsky/cg/c:d	Ljava/lang/String;
    //   380: invokespecial 162	com/google/android/finsky/cg/f:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   383: aload_0
    //   384: ldc -22
    //   386: aload_3
    //   387: getfield 236	com/google/android/finsky/cg/c:I	Ljava/lang/String;
    //   390: invokespecial 162	com/google/android/finsky/cg/f:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   393: aload 9
    //   395: aload_0
    //   396: ldc -18
    //   398: aload_3
    //   399: getfield 241	com/google/android/finsky/cg/c:M	J
    //   402: invokespecial 150	com/google/android/finsky/cg/f:a	(Ljava/lang/String;J)J
    //   405: aload 5
    //   407: aload_0
    //   408: ldc -13
    //   410: aload_3
    //   411: getfield 246	com/google/android/finsky/cg/c:t	J
    //   414: invokespecial 150	com/google/android/finsky/cg/f:a	(Ljava/lang/String;J)J
    //   417: aload_0
    //   418: ldc -8
    //   420: aload_3
    //   421: getfield 251	com/google/android/finsky/cg/c:z	J
    //   424: invokespecial 150	com/google/android/finsky/cg/f:a	(Ljava/lang/String;J)J
    //   427: aload_0
    //   428: ldc -3
    //   430: aload_3
    //   431: getfield 256	com/google/android/finsky/cg/c:K	Ljava/lang/String;
    //   434: invokespecial 162	com/google/android/finsky/cg/f:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   437: aload_0
    //   438: ldc_w 258
    //   441: aload_3
    //   442: getfield 261	com/google/android/finsky/cg/c:N	J
    //   445: invokespecial 150	com/google/android/finsky/cg/f:a	(Ljava/lang/String;J)J
    //   448: aload 6
    //   450: aload 7
    //   452: aload_0
    //   453: ldc_w 263
    //   456: aload_3
    //   457: getfield 266	com/google/android/finsky/cg/c:x	J
    //   460: invokespecial 150	com/google/android/finsky/cg/f:a	(Ljava/lang/String;J)J
    //   463: aload_0
    //   464: ldc_w 268
    //   467: aload_3
    //   468: getfield 271	com/google/android/finsky/cg/c:l	I
    //   471: invokespecial 116	com/google/android/finsky/cg/f:a	(Ljava/lang/String;I)I
    //   474: aload_1
    //   475: aload_0
    //   476: ldc_w 273
    //   479: aload_3
    //   480: getfield 276	com/google/android/finsky/cg/c:v	Ljava/lang/String;
    //   483: invokespecial 162	com/google/android/finsky/cg/f:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   486: aload_0
    //   487: ldc_w 278
    //   490: aload_3
    //   491: getfield 280	com/google/android/finsky/cg/c:J	[Ljava/lang/String;
    //   494: invokespecial 227	com/google/android/finsky/cg/f:a	(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;
    //   497: aload 8
    //   499: aload_0
    //   500: ldc_w 282
    //   503: aload_3
    //   504: getfield 285	com/google/android/finsky/cg/c:c	I
    //   507: invokespecial 116	com/google/android/finsky/cg/f:a	(Ljava/lang/String;I)I
    //   510: invokespecial 288	com/google/android/finsky/cg/c:<init>	(Ljava/lang/String;IIIILcom/google/wireless/android/finsky/b/a;JILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;JIILjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BJLcom/google/android/finsky/ds/a/o;JJLjava/lang/String;JLcom/google/android/finsky/e/a/a;Lcom/google/android/finsky/e/a/a;JILandroid/content/Intent;Ljava/lang/String;[Ljava/lang/String;Lcom/google/android/finsky/installer/b/a/d;I)V
    //   513: areturn
    //   514: aload_3
    //   515: getfield 292	com/google/android/finsky/cg/c:E	Landroid/content/Intent;
    //   518: astore_1
    //   519: goto -347 -> 172
    //   522: aload_3
    //   523: getfield 296	com/google/android/finsky/cg/c:D	[B
    //   526: astore 9
    //   528: goto -397 -> 131
    //   531: aload_0
    //   532: getfield 18	com/google/android/finsky/cg/f:a	Landroid/content/ContentValues;
    //   535: ldc 98
    //   537: invokevirtual 108	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   540: invokestatic 301	com/google/android/finsky/installer/b/a/d:a	([B)Lcom/google/android/finsky/installer/b/a/d;
    //   543: astore 8
    //   545: goto -437 -> 108
    //   548: aload_0
    //   549: getfield 18	com/google/android/finsky/cg/f:a	Landroid/content/ContentValues;
    //   552: ldc 93
    //   554: invokevirtual 108	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   557: invokestatic 306	com/google/android/finsky/e/a/a:a	([B)Lcom/google/android/finsky/e/a/a;
    //   560: astore 7
    //   562: goto -472 -> 90
    //   565: aload_0
    //   566: getfield 18	com/google/android/finsky/cg/f:a	Landroid/content/ContentValues;
    //   569: ldc 87
    //   571: invokevirtual 108	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   574: invokestatic 306	com/google/android/finsky/e/a/a:a	([B)Lcom/google/android/finsky/e/a/a;
    //   577: astore 6
    //   579: goto -507 -> 72
    //   582: aload_0
    //   583: getfield 18	com/google/android/finsky/cg/f:a	Landroid/content/ContentValues;
    //   586: ldc 81
    //   588: invokevirtual 108	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   591: invokestatic 311	com/google/android/finsky/ds/a/o:a	([B)Lcom/google/android/finsky/ds/a/o;
    //   594: astore 5
    //   596: goto -542 -> 54
    //   599: aload_0
    //   600: getfield 18	com/google/android/finsky/cg/f:a	Landroid/content/ContentValues;
    //   603: ldc 75
    //   605: invokevirtual 108	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   608: invokestatic 316	com/google/wireless/android/finsky/b/a:a	([B)Lcom/google/wireless/android/finsky/b/a;
    //   611: astore 4
    //   613: goto -577 -> 36
    //   616: astore_1
    //   617: new 318	java/lang/RuntimeException
    //   620: dup
    //   621: aload_1
    //   622: invokespecial 321	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   625: athrow
    //   626: astore_1
    //   627: ldc_w 323
    //   630: iconst_1
    //   631: anewarray 4	java/lang/Object
    //   634: dup
    //   635: iconst_0
    //   636: aload 10
    //   638: invokestatic 327	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;)Ljava/lang/String;
    //   641: aastore
    //   642: invokestatic 330	com/google/android/finsky/utils/FinskyLog:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   645: aload_3
    //   646: getfield 292	com/google/android/finsky/cg/c:E	Landroid/content/Intent;
    //   649: astore_1
    //   650: goto -478 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	653	0	this	f
    //   0	653	1	paramc	c
    //   141	40	2	i	int
    //   1	645	3	localc	c
    //   34	578	4	locala	com.google.wireless.android.finsky.b.a
    //   52	543	5	localo	com.google.android.finsky.ds.a.o
    //   70	508	6	locala1	a
    //   88	473	7	locala2	a
    //   106	438	8	locald	com.google.android.finsky.installer.b.a.d
    //   129	398	9	arrayOfByte	byte[]
    //   163	474	10	str	String
    // Exception table:
    //   from	to	target	type
    //   18	36	616	com/google/protobuf/nano/InvalidProtocolBufferNanoException
    //   36	54	616	com/google/protobuf/nano/InvalidProtocolBufferNanoException
    //   54	72	616	com/google/protobuf/nano/InvalidProtocolBufferNanoException
    //   72	90	616	com/google/protobuf/nano/InvalidProtocolBufferNanoException
    //   90	108	616	com/google/protobuf/nano/InvalidProtocolBufferNanoException
    //   531	545	616	com/google/protobuf/nano/InvalidProtocolBufferNanoException
    //   548	562	616	com/google/protobuf/nano/InvalidProtocolBufferNanoException
    //   565	579	616	com/google/protobuf/nano/InvalidProtocolBufferNanoException
    //   582	596	616	com/google/protobuf/nano/InvalidProtocolBufferNanoException
    //   599	613	616	com/google/protobuf/nano/InvalidProtocolBufferNanoException
    //   165	172	626	java/net/URISyntaxException
  }
  
  public final f a()
  {
    this.a.put("desired_version", Integer.valueOf(-1));
    return this;
  }
  
  public final f a(long paramLong)
  {
    this.a.put("update_discovered_timestamp_ms", Long.valueOf(paramLong));
    return this;
  }
  
  public final f a(a parama)
  {
    this.a.put("logging_context", g.a(parama));
    return this;
  }
  
  public final f b()
  {
    this.a.put("desired_derived_apk_id", Integer.valueOf(0));
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cg/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */