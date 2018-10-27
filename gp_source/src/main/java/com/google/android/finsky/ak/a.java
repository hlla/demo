package com.google.android.finsky.ak;

import android.content.Context;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.dn.e;
import com.google.android.finsky.e.i;

public final class a
{
  private final com.google.android.finsky.accounts.c a;
  private final Context b;
  private boolean c;
  private final com.google.android.finsky.ba.a d;
  private final i e;
  private final e f;
  private final com.google.android.finsky.bo.c g;
  
  public a(Context paramContext, e parame, com.google.android.finsky.bo.c paramc, i parami, com.google.android.finsky.ba.a parama, com.google.android.finsky.accounts.c paramc1)
  {
    this.b = paramContext;
    this.f = parame;
    this.g = paramc;
    this.e = parami;
    this.d = parama;
    this.a = paramc1;
  }
  
  private final boolean a(long paramLong, String paramString1, com.google.android.play.utils.b.a parama, String paramString2)
  {
    return ((this.g.cY().a(paramLong)) || (this.f.c("NetworkOptimizations", paramString1, this.a.cS()))) && (((Boolean)parama.b()).booleanValue()) && (!this.f.c("NetworkOptimizations", paramString2, this.a.cS()));
  }
  
  private final boolean d()
  {
    return (a(12655307L, "enable_quic_server_configs_to_store", d.iU, "kill_switch_to_disable_quic_server_configs_to_store")) && (c());
  }
  
  private final boolean e()
  {
    return (a(12655308L, "enable_quic_idle_connection_timeout", d.cG, "kill_switch_to_disable_quic_idle_connection_timeout")) && (c());
  }
  
  private final boolean f()
  {
    return (a(12657496L, "migrate_quic_sessions_on_network_change", d.iS, "kill_switch_to_disable_migrate_quic_sessions_on_network_change")) && (c());
  }
  
  private final boolean g()
  {
    return (a(12655309L, "enable_quic_connection_options", d.cF, "kill_switch_to_disable_quic_connection_options")) && (c());
  }
  
  private final boolean h()
  {
    return a(12657495L, "enable_stale_dns", d.cM, "kill_switch_to_disable_stale_dns");
  }
  
  /* Error */
  public final org.chromium.net.h a()
  {
    // Byte code:
    //   0: getstatic 135	com/google/android/finsky/ag/d:cp	Lcom/google/android/play/utils/b/a;
    //   3: invokevirtual 66	com/google/android/play/utils/b/a:b	()Ljava/lang/Object;
    //   6: checkcast 68	java/lang/Boolean
    //   9: invokevirtual 72	java/lang/Boolean:booleanValue	()Z
    //   12: ifeq +654 -> 666
    //   15: aload_0
    //   16: getfield 29	com/google/android/finsky/ak/a:g	Lcom/google/android/finsky/bo/c;
    //   19: invokeinterface 43 1 0
    //   24: ldc2_w 136
    //   27: invokeinterface 48 3 0
    //   32: ifeq +634 -> 666
    //   35: getstatic 140	com/google/android/finsky/ag/d:m	Lcom/google/android/play/utils/b/a;
    //   38: invokevirtual 66	com/google/android/play/utils/b/a:b	()Ljava/lang/Object;
    //   41: checkcast 68	java/lang/Boolean
    //   44: invokevirtual 72	java/lang/Boolean:booleanValue	()Z
    //   47: ifne +13 -> 60
    //   50: aload_0
    //   51: getfield 33	com/google/android/finsky/ak/a:d	Lcom/google/android/finsky/ba/a;
    //   54: invokevirtual 144	com/google/android/finsky/ba/a:a	()Z
    //   57: ifeq +609 -> 666
    //   60: aload_0
    //   61: getfield 146	com/google/android/finsky/ak/a:c	Z
    //   64: ifne +602 -> 666
    //   67: aload_0
    //   68: invokevirtual 88	com/google/android/finsky/ak/a:c	()Z
    //   71: istore_1
    //   72: aload_0
    //   73: invokevirtual 148	com/google/android/finsky/ak/a:b	()Z
    //   76: istore_2
    //   77: aload_0
    //   78: invokespecial 150	com/google/android/finsky/ak/a:e	()Z
    //   81: ifeq +542 -> 623
    //   84: new 152	org/chromium/net/o
    //   87: dup
    //   88: aload_0
    //   89: getfield 25	com/google/android/finsky/ak/a:b	Landroid/content/Context;
    //   92: invokespecial 155	org/chromium/net/o:<init>	(Landroid/content/Context;)V
    //   95: astore_3
    //   96: new 157	org/json/JSONObject
    //   99: dup
    //   100: invokespecial 158	org/json/JSONObject:<init>	()V
    //   103: astore 4
    //   105: aload_0
    //   106: invokespecial 150	com/google/android/finsky/ak/a:e	()Z
    //   109: ifne +496 -> 605
    //   112: aload_0
    //   113: invokespecial 160	com/google/android/finsky/ak/a:f	()Z
    //   116: ifne +476 -> 592
    //   119: aload_0
    //   120: invokespecial 162	com/google/android/finsky/ak/a:g	()Z
    //   123: ifne +451 -> 574
    //   126: aload_0
    //   127: invokespecial 164	com/google/android/finsky/ak/a:d	()Z
    //   130: ifne +332 -> 462
    //   133: new 157	org/json/JSONObject
    //   136: dup
    //   137: invokespecial 158	org/json/JSONObject:<init>	()V
    //   140: ldc -90
    //   142: aload 4
    //   144: invokevirtual 170	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   147: astore 4
    //   149: aload_0
    //   150: invokespecial 172	com/google/android/finsky/ak/a:h	()Z
    //   153: ifne +180 -> 333
    //   156: aload 4
    //   158: invokevirtual 175	org/json/JSONObject:toString	()Ljava/lang/String;
    //   161: astore 4
    //   163: aload_3
    //   164: getfield 178	org/chromium/net/o:a	Lorg/chromium/net/v;
    //   167: aload 4
    //   169: invokevirtual 183	org/chromium/net/v:a	(Ljava/lang/String;)Lorg/chromium/net/v;
    //   172: pop
    //   173: iload_1
    //   174: ifne +131 -> 305
    //   177: aload_3
    //   178: iload_2
    //   179: invokevirtual 188	org/chromium/net/i:b	(Z)Lorg/chromium/net/i;
    //   182: pop
    //   183: getstatic 191	com/google/android/finsky/ag/d:cn	Lcom/google/android/play/utils/b/a;
    //   186: invokevirtual 66	com/google/android/play/utils/b/a:b	()Ljava/lang/Object;
    //   189: checkcast 68	java/lang/Boolean
    //   192: invokevirtual 72	java/lang/Boolean:booleanValue	()Z
    //   195: ifne +33 -> 228
    //   198: aload_3
    //   199: invokevirtual 193	org/chromium/net/i:a	()Lorg/chromium/net/h;
    //   202: astore_3
    //   203: ldc -61
    //   205: iconst_2
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: iload_1
    //   212: invokestatic 199	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   215: aastore
    //   216: dup
    //   217: iconst_1
    //   218: iload_2
    //   219: invokestatic 199	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   222: aastore
    //   223: invokestatic 204	com/google/android/finsky/utils/FinskyLog:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: aload_3
    //   227: areturn
    //   228: aload_0
    //   229: getfield 27	com/google/android/finsky/ak/a:f	Lcom/google/android/finsky/dn/e;
    //   232: ldc 50
    //   234: ldc -50
    //   236: aload_0
    //   237: getfield 35	com/google/android/finsky/ak/a:a	Lcom/google/android/finsky/accounts/c;
    //   240: invokeinterface 56 1 0
    //   245: invokeinterface 61 4 0
    //   250: ifne -52 -> 198
    //   253: aload_3
    //   254: iconst_1
    //   255: invokevirtual 208	org/chromium/net/i:c	(Z)Lorg/chromium/net/i;
    //   258: pop
    //   259: goto -61 -> 198
    //   262: astore_3
    //   263: ldc -46
    //   265: iconst_0
    //   266: anewarray 4	java/lang/Object
    //   269: invokestatic 212	com/google/android/finsky/utils/FinskyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: aload_0
    //   273: getfield 31	com/google/android/finsky/ak/a:e	Lcom/google/android/finsky/e/i;
    //   276: invokeinterface 218 1 0
    //   281: new 220	com/google/android/finsky/e/d
    //   284: dup
    //   285: sipush 569
    //   288: invokespecial 223	com/google/android/finsky/e/d:<init>	(I)V
    //   291: getfield 226	com/google/android/finsky/e/d:a	Lcom/google/wireless/android/a/b/a/a/bg;
    //   294: invokevirtual 231	com/google/android/finsky/e/u:a	(Lcom/google/wireless/android/a/b/a/a/bg;)J
    //   297: pop2
    //   298: aload_0
    //   299: iconst_1
    //   300: putfield 146	com/google/android/finsky/ak/a:c	Z
    //   303: aconst_null
    //   304: areturn
    //   305: aload_3
    //   306: iconst_1
    //   307: invokevirtual 233	org/chromium/net/i:a	(Z)Lorg/chromium/net/i;
    //   310: getstatic 238	com/google/android/finsky/api/h:g	Landroid/net/Uri;
    //   313: invokevirtual 243	android/net/Uri:getHost	()Ljava/lang/String;
    //   316: sipush 443
    //   319: sipush 443
    //   322: invokevirtual 246	org/chromium/net/i:a	(Ljava/lang/String;II)Lorg/chromium/net/i;
    //   325: pop
    //   326: goto -149 -> 177
    //   329: astore_3
    //   330: goto -67 -> 263
    //   333: aload 4
    //   335: ldc -8
    //   337: new 157	org/json/JSONObject
    //   340: dup
    //   341: invokespecial 158	org/json/JSONObject:<init>	()V
    //   344: ldc -6
    //   346: iconst_1
    //   347: invokevirtual 253	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   350: ldc -1
    //   352: aload_0
    //   353: getfield 27	com/google/android/finsky/ak/a:f	Lcom/google/android/finsky/dn/e;
    //   356: ldc 50
    //   358: ldc_w 257
    //   361: aload_0
    //   362: getfield 35	com/google/android/finsky/ak/a:a	Lcom/google/android/finsky/accounts/c;
    //   365: invokeinterface 56 1 0
    //   370: invokeinterface 260 4 0
    //   375: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   378: ldc_w 265
    //   381: aload_0
    //   382: getfield 27	com/google/android/finsky/ak/a:f	Lcom/google/android/finsky/dn/e;
    //   385: ldc 50
    //   387: ldc_w 267
    //   390: aload_0
    //   391: getfield 35	com/google/android/finsky/ak/a:a	Lcom/google/android/finsky/accounts/c;
    //   394: invokeinterface 56 1 0
    //   399: invokeinterface 270 4 0
    //   404: invokevirtual 273	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   407: ldc_w 275
    //   410: iconst_1
    //   411: invokevirtual 253	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   414: invokevirtual 170	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   417: pop
    //   418: goto -262 -> 156
    //   421: astore 4
    //   423: ldc_w 277
    //   426: iconst_0
    //   427: anewarray 4	java/lang/Object
    //   430: invokestatic 212	com/google/android/finsky/utils/FinskyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   433: aload_0
    //   434: getfield 31	com/google/android/finsky/ak/a:e	Lcom/google/android/finsky/e/i;
    //   437: invokeinterface 218 1 0
    //   442: new 220	com/google/android/finsky/e/d
    //   445: dup
    //   446: sipush 4001
    //   449: invokespecial 223	com/google/android/finsky/e/d:<init>	(I)V
    //   452: getfield 226	com/google/android/finsky/e/d:a	Lcom/google/wireless/android/a/b/a/a/bg;
    //   455: invokevirtual 231	com/google/android/finsky/e/u:a	(Lcom/google/wireless/android/a/b/a/a/bg;)J
    //   458: pop2
    //   459: goto -286 -> 173
    //   462: new 279	java/io/File
    //   465: dup
    //   466: aload_0
    //   467: getfield 25	com/google/android/finsky/ak/a:b	Landroid/content/Context;
    //   470: invokevirtual 285	android/content/Context:getCacheDir	()Ljava/io/File;
    //   473: ldc_w 287
    //   476: invokespecial 290	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   479: astore 5
    //   481: aload 5
    //   483: invokevirtual 293	java/io/File:exists	()Z
    //   486: ifne +11 -> 497
    //   489: aload 5
    //   491: invokevirtual 296	java/io/File:mkdirs	()Z
    //   494: ifeq +67 -> 561
    //   497: aload_3
    //   498: aload 5
    //   500: invokevirtual 299	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   503: invokevirtual 302	org/chromium/net/i:a	(Ljava/lang/String;)Lorg/chromium/net/i;
    //   506: pop
    //   507: aload 4
    //   509: ldc_w 304
    //   512: getstatic 307	com/google/android/finsky/ag/d:fl	Lcom/google/android/play/utils/b/a;
    //   515: invokevirtual 66	com/google/android/play/utils/b/a:b	()Ljava/lang/Object;
    //   518: invokevirtual 170	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   521: pop
    //   522: aload_0
    //   523: ldc2_w 308
    //   526: ldc_w 311
    //   529: getstatic 314	com/google/android/finsky/ag/d:hr	Lcom/google/android/play/utils/b/a;
    //   532: ldc_w 316
    //   535: invokespecial 86	com/google/android/finsky/ak/a:a	(JLjava/lang/String;Lcom/google/android/play/utils/b/a;Ljava/lang/String;)Z
    //   538: ifeq -405 -> 133
    //   541: aload_0
    //   542: invokespecial 164	com/google/android/finsky/ak/a:d	()Z
    //   545: ifeq -412 -> 133
    //   548: aload 4
    //   550: ldc_w 311
    //   553: iconst_1
    //   554: invokevirtual 253	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   557: pop
    //   558: goto -425 -> 133
    //   561: ldc_w 318
    //   564: iconst_0
    //   565: anewarray 4	java/lang/Object
    //   568: invokestatic 212	com/google/android/finsky/utils/FinskyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: goto -49 -> 522
    //   574: aload 4
    //   576: ldc_w 320
    //   579: getstatic 323	com/google/android/finsky/ag/d:hq	Lcom/google/android/play/utils/b/a;
    //   582: invokevirtual 66	com/google/android/play/utils/b/a:b	()Ljava/lang/Object;
    //   585: invokevirtual 170	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   588: pop
    //   589: goto -463 -> 126
    //   592: aload 4
    //   594: ldc_w 325
    //   597: iconst_1
    //   598: invokevirtual 253	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   601: pop
    //   602: goto -483 -> 119
    //   605: aload 4
    //   607: ldc_w 327
    //   610: getstatic 330	com/google/android/finsky/ag/d:fk	Lcom/google/android/play/utils/b/a;
    //   613: invokevirtual 66	com/google/android/play/utils/b/a:b	()Ljava/lang/Object;
    //   616: invokevirtual 170	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   619: pop
    //   620: goto -508 -> 112
    //   623: aload_0
    //   624: invokespecial 160	com/google/android/finsky/ak/a:f	()Z
    //   627: ifne -543 -> 84
    //   630: aload_0
    //   631: invokespecial 162	com/google/android/finsky/ak/a:g	()Z
    //   634: ifne -550 -> 84
    //   637: aload_0
    //   638: invokespecial 164	com/google/android/finsky/ak/a:d	()Z
    //   641: ifne -557 -> 84
    //   644: aload_0
    //   645: invokespecial 172	com/google/android/finsky/ak/a:h	()Z
    //   648: ifne -564 -> 84
    //   651: new 185	org/chromium/net/i
    //   654: dup
    //   655: aload_0
    //   656: getfield 25	com/google/android/finsky/ak/a:b	Landroid/content/Context;
    //   659: invokespecial 331	org/chromium/net/i:<init>	(Landroid/content/Context;)V
    //   662: astore_3
    //   663: goto -490 -> 173
    //   666: aconst_null
    //   667: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	668	0	this	a
    //   71	141	1	bool1	boolean
    //   76	143	2	bool2	boolean
    //   95	159	3	localObject1	Object
    //   262	44	3	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   329	169	3	localException	Exception
    //   662	1	3	locali	org.chromium.net.i
    //   103	231	4	localObject2	Object
    //   421	185	4	localJSONException	org.json.JSONException
    //   479	20	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   77	84	262	java/lang/UnsatisfiedLinkError
    //   84	96	262	java/lang/UnsatisfiedLinkError
    //   96	112	262	java/lang/UnsatisfiedLinkError
    //   112	119	262	java/lang/UnsatisfiedLinkError
    //   119	126	262	java/lang/UnsatisfiedLinkError
    //   126	133	262	java/lang/UnsatisfiedLinkError
    //   133	156	262	java/lang/UnsatisfiedLinkError
    //   156	173	262	java/lang/UnsatisfiedLinkError
    //   177	198	262	java/lang/UnsatisfiedLinkError
    //   198	226	262	java/lang/UnsatisfiedLinkError
    //   228	259	262	java/lang/UnsatisfiedLinkError
    //   305	326	262	java/lang/UnsatisfiedLinkError
    //   333	418	262	java/lang/UnsatisfiedLinkError
    //   423	459	262	java/lang/UnsatisfiedLinkError
    //   462	497	262	java/lang/UnsatisfiedLinkError
    //   497	522	262	java/lang/UnsatisfiedLinkError
    //   522	558	262	java/lang/UnsatisfiedLinkError
    //   561	571	262	java/lang/UnsatisfiedLinkError
    //   574	589	262	java/lang/UnsatisfiedLinkError
    //   592	602	262	java/lang/UnsatisfiedLinkError
    //   605	620	262	java/lang/UnsatisfiedLinkError
    //   623	663	262	java/lang/UnsatisfiedLinkError
    //   77	84	329	java/lang/Exception
    //   84	96	329	java/lang/Exception
    //   96	112	329	java/lang/Exception
    //   112	119	329	java/lang/Exception
    //   119	126	329	java/lang/Exception
    //   126	133	329	java/lang/Exception
    //   133	156	329	java/lang/Exception
    //   156	173	329	java/lang/Exception
    //   177	198	329	java/lang/Exception
    //   198	226	329	java/lang/Exception
    //   228	259	329	java/lang/Exception
    //   305	326	329	java/lang/Exception
    //   333	418	329	java/lang/Exception
    //   423	459	329	java/lang/Exception
    //   462	497	329	java/lang/Exception
    //   497	522	329	java/lang/Exception
    //   522	558	329	java/lang/Exception
    //   561	571	329	java/lang/Exception
    //   574	589	329	java/lang/Exception
    //   592	602	329	java/lang/Exception
    //   605	620	329	java/lang/Exception
    //   623	663	329	java/lang/Exception
    //   96	112	421	org/json/JSONException
    //   112	119	421	org/json/JSONException
    //   119	126	421	org/json/JSONException
    //   126	133	421	org/json/JSONException
    //   133	156	421	org/json/JSONException
    //   156	173	421	org/json/JSONException
    //   333	418	421	org/json/JSONException
    //   462	497	421	org/json/JSONException
    //   497	522	421	org/json/JSONException
    //   522	558	421	org/json/JSONException
    //   561	571	421	org/json/JSONException
    //   574	589	421	org/json/JSONException
    //   592	602	421	org/json/JSONException
    //   605	620	421	org/json/JSONException
  }
  
  public final boolean b()
  {
    return (((Boolean)d.cx.b()).booleanValue()) && (!this.g.cY().a(12630389L));
  }
  
  public final boolean c()
  {
    return (((Boolean)d.cH.b()).booleanValue()) && (this.g.cY().a(12628174L));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ak/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */