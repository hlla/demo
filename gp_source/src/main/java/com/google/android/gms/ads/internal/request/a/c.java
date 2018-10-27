package com.google.android.gms.ads.internal.request.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.cache.i;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.g.j;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.NonagonRequestParcel;
import com.google.android.gms.ads.internal.request.aa;
import com.google.android.gms.ads.internal.request.ac;
import com.google.android.gms.ads.internal.request.af;
import com.google.android.gms.ads.internal.util.a.v;
import com.google.android.gms.ads.internal.util.bj;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class c
  extends aa
{
  private static c d;
  private static final Object e = new Object();
  private final Context a;
  private final b b;
  private final ScheduledExecutorService c = Executors.newSingleThreadScheduledExecutor();
  
  private c(Context paramContext, b paramb)
  {
    this.a = paramContext;
    this.b = paramb;
  }
  
  private static AdResponseParcel a(Context paramContext, b paramb, AdRequestInfoParcel paramAdRequestInfoParcel, ScheduledExecutorService paramScheduledExecutorService)
  {
    com.google.android.gms.ads.internal.util.e.b("Starting ad request from service using: google.afma.request.getAdDictionary");
    com.google.android.gms.ads.internal.g.l locall = new com.google.android.gms.ads.internal.g.l(((Boolean)com.google.android.gms.ads.internal.f.n.M.a()).booleanValue(), "load_ad", paramAdRequestInfoParcel.c.a);
    if (paramAdRequestInfoParcel.ad > 10)
    {
      long l = paramAdRequestInfoParcel.l;
      if (l != -1L) {
        locall.a(locall.a(l), new String[] { "cts" });
      }
    }
    j localj = locall.a();
    Object localObject5 = com.google.android.gms.ads.internal.util.a.h.a(paramb.h.a(), ((Long)com.google.android.gms.ads.internal.f.n.bk.a()).longValue(), TimeUnit.MILLISECONDS, paramScheduledExecutorService);
    Object localObject2 = com.google.android.gms.ads.internal.util.a.h.a(null);
    Object localObject1;
    if (((Boolean)com.google.android.gms.ads.internal.f.n.ai.a()).booleanValue())
    {
      localObject1 = paramb.b;
      localObject2 = paramAdRequestInfoParcel.N.packageName;
      localObject2 = ((com.google.android.gms.ads.internal.t.a)localObject1).a();
    }
    for (;;)
    {
      localObject1 = paramb.b;
      Object localObject3 = paramAdRequestInfoParcel.N.packageName;
      Object localObject6 = ((com.google.android.gms.ads.internal.t.a)localObject1).b();
      localObject1 = paramb.i;
      localObject3 = paramAdRequestInfoParcel.O;
      Object localObject4 = paramAdRequestInfoParcel.N;
      Object localObject8 = ((com.google.android.gms.ads.internal.u.c)localObject1).a((String)localObject3);
      Object localObject7 = bt.A.p.a(paramContext);
      localObject1 = com.google.android.gms.ads.internal.util.a.h.a(null);
      localObject3 = paramAdRequestInfoParcel.b.f;
      int i;
      if (localObject3 != null) {
        if (((Bundle)localObject3).getString("_ad") != null)
        {
          i = 1;
          label261:
          if (!paramAdRequestInfoParcel.z)
          {
            label268:
            Object localObject9 = com.google.android.gms.ads.internal.util.a.h.a((v)localObject1, ((Long)com.google.android.gms.ads.internal.f.n.s.a()).longValue(), TimeUnit.MILLISECONDS, paramScheduledExecutorService);
            localObject3 = com.google.android.gms.ads.internal.util.a.h.a(null);
            if (((Boolean)com.google.android.gms.ads.internal.f.n.e.a()).booleanValue())
            {
              localObject3 = com.google.android.gms.ads.internal.util.a.h.a(paramb.i.a(paramContext), ((Long)com.google.android.gms.ads.internal.f.n.d.a()).longValue(), TimeUnit.MILLISECONDS, paramScheduledExecutorService);
              label343:
              if (paramAdRequestInfoParcel.ad >= 4)
              {
                localObject1 = paramAdRequestInfoParcel.n;
                if (localObject1 == null)
                {
                  localObject1 = null;
                  label365:
                  localObject4 = bt.A.e;
                  if ((com.google.android.gms.ads.internal.util.n.a(paramContext, "android.permission.ACCESS_NETWORK_STATE")) && (((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo() == null)) {
                    com.google.android.gms.ads.internal.util.e.b("Device is offline.");
                  }
                  if (paramAdRequestInfoParcel.ad >= 7)
                  {
                    localObject4 = paramAdRequestInfoParcel.P;
                    label417:
                    Object localObject10 = paramAdRequestInfoParcel.b.f;
                    if (localObject10 != null)
                    {
                      localObject10 = ((Bundle)localObject10).getString("_ad");
                      if (localObject10 != null) {
                        return h.a(paramContext, paramAdRequestInfoParcel, (String)localObject10);
                      }
                    }
                    localObject10 = paramb.c.a(paramAdRequestInfoParcel.s);
                    localObject5 = (Bundle)com.google.android.gms.ads.internal.util.a.h.a((Future)localObject5, null, ((Long)com.google.android.gms.ads.internal.f.n.bk.a()).longValue(), TimeUnit.MILLISECONDS);
                    localObject9 = (Location)com.google.android.gms.ads.internal.util.a.h.a((Future)localObject9, null);
                    com.google.android.gms.ads.c.b localb = (com.google.android.gms.ads.c.b)com.google.android.gms.ads.internal.util.a.h.a((Future)localObject3, null);
                    localObject8 = (String)com.google.android.gms.ads.internal.util.a.h.a((Future)localObject8, null);
                    localObject2 = (String)com.google.android.gms.ads.internal.util.a.h.a((Future)localObject2, null);
                    localObject3 = (String)com.google.android.gms.ads.internal.util.a.h.a((Future)localObject6, null);
                    localObject6 = (l)com.google.android.gms.ads.internal.util.a.h.a((Future)localObject7, null);
                    if (localObject6 == null)
                    {
                      com.google.android.gms.ads.internal.util.e.e("Error fetching device info. This is not recoverable.");
                      return new AdResponseParcel(0);
                    }
                    localObject7 = new a();
                    ((a)localObject7).a = paramAdRequestInfoParcel;
                    ((a)localObject7).e = ((l)localObject6);
                    ((a)localObject7).j = ((Location)localObject9);
                    ((a)localObject7).k = ((Bundle)localObject5);
                    ((a)localObject7).l = ((String)localObject8);
                    ((a)localObject7).b = localb;
                    if (localObject10 == null) {
                      ((a)localObject7).h.clear();
                    }
                    ((a)localObject7).h = ((List)localObject10);
                    ((a)localObject7).d = ((Bundle)localObject1);
                    ((a)localObject7).f = ((String)localObject2);
                    ((a)localObject7).g = ((String)localObject3);
                    ((a)localObject7).c = paramb.a.a();
                    ((a)localObject7).i = true;
                    localObject1 = h.a(paramContext, (a)localObject7);
                    if (localObject1 == null) {
                      return new AdResponseParcel(0);
                    }
                    if (paramAdRequestInfoParcel.ad >= 7) {}
                  }
                }
              }
            }
          }
        }
      }
      try
      {
        ((JSONObject)localObject1).put("request_id", localObject4);
        locall.a(localj, new String[] { "arc" });
        paramScheduledExecutorService = com.google.android.gms.ads.internal.util.a.h.a(com.google.android.gms.ads.internal.util.a.h.a(paramb.d.a().b(localObject1), d.a, paramScheduledExecutorService), 10L, TimeUnit.SECONDS, paramScheduledExecutorService);
        localObject1 = paramb.e.a();
        if (localObject1 != null) {
          com.google.android.gms.ads.internal.util.a.e.a((v)localObject1, "AdRequestServiceImpl.loadAd.flags");
        }
        localObject4 = (k)com.google.android.gms.ads.internal.util.a.h.a(paramScheduledExecutorService, null);
        if (localObject4 == null) {
          return new AdResponseParcel(0);
        }
        i = ((k)localObject4).c;
        if (i != -2) {
          return new AdResponseParcel(i);
        }
        locall.d();
        if (!TextUtils.isEmpty(((k)localObject4).a)) {}
        for (localObject1 = h.a(paramContext, paramAdRequestInfoParcel, ((k)localObject4).a);; localObject1 = null)
        {
          paramScheduledExecutorService = (ScheduledExecutorService)localObject1;
          if (localObject1 == null)
          {
            paramScheduledExecutorService = (ScheduledExecutorService)localObject1;
            if (!TextUtils.isEmpty(((k)localObject4).j)) {
              paramScheduledExecutorService = a(paramAdRequestInfoParcel, paramContext, paramAdRequestInfoParcel.ae.a, ((k)localObject4).j, (String)localObject2, (String)localObject3, (k)localObject4, locall, paramb);
            }
          }
          paramContext = paramScheduledExecutorService;
          if (paramScheduledExecutorService == null) {
            paramContext = new AdResponseParcel(0);
          }
          locall.a(localj, new String[] { "tts" });
          paramContext.j = locall.b();
          paramContext.T = ((k)localObject4).i;
          return paramContext;
        }
        localObject4 = UUID.randomUUID().toString();
        break label417;
        break label365;
        localObject1 = null;
        break label365;
        break label343;
        if (i != 0) {
          break label268;
        }
        localObject1 = paramb.f;
        localObject3 = paramAdRequestInfoParcel.k;
        localObject1 = ((com.google.android.gms.ads.internal.l.a)localObject1).a();
        break label268;
        i = 0;
        break label261;
        i = 0;
        break label261;
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  public static AdResponseParcel a(AdRequestInfoParcel paramAdRequestInfoParcel, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, k paramk, com.google.android.gms.ads.internal.g.l paraml, b paramb)
  {
    // Byte code:
    //   0: aload 7
    //   2: ifnull +1143 -> 1145
    //   5: aload 7
    //   7: invokevirtual 106	com/google/android/gms/ads/internal/g/l:a	()Lcom/google/android/gms/ads/internal/g/j;
    //   10: astore 30
    //   12: new 445	com/google/android/gms/ads/internal/request/a/i
    //   15: dup
    //   16: aload_0
    //   17: aload 6
    //   19: getfield 447	com/google/android/gms/ads/internal/request/a/k:b	Ljava/lang/String;
    //   22: invokespecial 450	com/google/android/gms/ads/internal/request/a/i:<init>	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Ljava/lang/String;)V
    //   25: astore 34
    //   27: aload_3
    //   28: invokestatic 454	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   31: astore 31
    //   33: aload 31
    //   35: invokevirtual 458	java/lang/String:length	()I
    //   38: ifne +1094 -> 1132
    //   41: new 98	java/lang/String
    //   44: dup
    //   45: ldc_w 460
    //   48: invokespecial 462	java/lang/String:<init>	(Ljava/lang/String;)V
    //   51: astore 31
    //   53: aload 31
    //   55: invokestatic 49	com/google/android/gms/ads/internal/util/e:b	(Ljava/lang/String;)V
    //   58: new 464	java/net/URL
    //   61: dup
    //   62: aload_3
    //   63: invokespecial 465	java/net/URL:<init>	(Ljava/lang/String;)V
    //   66: astore 31
    //   68: getstatic 178	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   71: getfield 468	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   74: invokeinterface 472 1 0
    //   79: lstore 11
    //   81: iconst_0
    //   82: istore 9
    //   84: goto +1103 -> 1187
    //   87: aload 31
    //   89: invokevirtual 476	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   92: checkcast 478	java/net/HttpURLConnection
    //   95: astore 33
    //   97: getstatic 178	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   100: getfield 224	com/google/android/gms/ads/internal/bt:e	Lcom/google/android/gms/ads/internal/util/n;
    //   103: aload_1
    //   104: aload_2
    //   105: aload 33
    //   107: invokevirtual 481	com/google/android/gms/ads/internal/util/n:a	(Landroid/content/Context;Ljava/lang/String;Ljava/net/HttpURLConnection;)V
    //   110: aload 6
    //   112: getfield 483	com/google/android/gms/ads/internal/request/a/k:d	Z
    //   115: ifne +962 -> 1077
    //   118: aload_0
    //   119: getfield 486	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:ag	Ljava/lang/String;
    //   122: astore_3
    //   123: aload_3
    //   124: invokestatic 400	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +18 -> 145
    //   130: ldc_w 488
    //   133: invokestatic 49	com/google/android/gms/ads/internal/util/e:b	(Ljava/lang/String;)V
    //   136: aload 33
    //   138: ldc_w 490
    //   141: aload_3
    //   142: invokevirtual 494	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload 6
    //   147: ifnull +925 -> 1072
    //   150: aload 6
    //   152: getfield 496	com/google/android/gms/ads/internal/request/a/k:e	Ljava/lang/String;
    //   155: invokestatic 400	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne +909 -> 1067
    //   161: aload 33
    //   163: iconst_1
    //   164: invokevirtual 500	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   167: aload 6
    //   169: getfield 496	com/google/android/gms/ads/internal/request/a/k:e	Ljava/lang/String;
    //   172: invokevirtual 504	java/lang/String:getBytes	()[B
    //   175: astore 32
    //   177: aload 33
    //   179: aload 32
    //   181: arraylength
    //   182: invokevirtual 507	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   185: new 509	java/io/BufferedOutputStream
    //   188: dup
    //   189: aload 33
    //   191: invokevirtual 513	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   194: invokespecial 516	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   197: astore_3
    //   198: aload_3
    //   199: aload 32
    //   201: invokevirtual 520	java/io/BufferedOutputStream:write	([B)V
    //   204: aload_3
    //   205: invokestatic 525	com/google/android/gms/common/util/g:a	(Ljava/io/Closeable;)V
    //   208: aload 32
    //   210: astore_3
    //   211: new 527	com/google/android/gms/ads/internal/util/client/e
    //   214: dup
    //   215: aload_0
    //   216: getfield 250	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:P	Ljava/lang/String;
    //   219: invokespecial 528	com/google/android/gms/ads/internal/util/client/e:<init>	(Ljava/lang/String;)V
    //   222: astore 32
    //   224: aload 32
    //   226: aload 33
    //   228: aload_3
    //   229: invokevirtual 531	com/google/android/gms/ads/internal/util/client/e:a	(Ljava/net/HttpURLConnection;[B)V
    //   232: aload 33
    //   234: invokevirtual 534	java/net/HttpURLConnection:getResponseCode	()I
    //   237: istore 10
    //   239: aload 33
    //   241: invokevirtual 538	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   244: astore_3
    //   245: aload 32
    //   247: aload 33
    //   249: iload 10
    //   251: invokevirtual 541	com/google/android/gms/ads/internal/util/client/e:a	(Ljava/net/HttpURLConnection;I)V
    //   254: iload 10
    //   256: sipush 200
    //   259: if_icmpge +300 -> 559
    //   262: aload 31
    //   264: invokevirtual 542	java/net/URL:toString	()Ljava/lang/String;
    //   267: aload_3
    //   268: aconst_null
    //   269: iload 10
    //   271: invokestatic 545	com/google/android/gms/ads/internal/request/a/c:a	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   274: iload 10
    //   276: sipush 300
    //   279: if_icmpge +70 -> 349
    //   282: new 547	java/lang/StringBuilder
    //   285: dup
    //   286: bipush 46
    //   288: invokespecial 548	java/lang/StringBuilder:<init>	(I)V
    //   291: astore_0
    //   292: aload_0
    //   293: ldc_w 550
    //   296: invokevirtual 554	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_0
    //   301: iload 10
    //   303: invokevirtual 557	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_0
    //   308: invokevirtual 558	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 282	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   314: new 284	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   317: dup
    //   318: iconst_0
    //   319: invokespecial 287	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   322: astore_1
    //   323: aload 33
    //   325: invokevirtual 561	java/net/HttpURLConnection:disconnect	()V
    //   328: aload_1
    //   329: astore_0
    //   330: aload 8
    //   332: ifnull +15 -> 347
    //   335: aload 8
    //   337: getfield 564	com/google/android/gms/ads/internal/request/a/b:g	Lcom/google/android/gms/ads/internal/request/a/t;
    //   340: invokeinterface 568 1 0
    //   345: aload_1
    //   346: astore_0
    //   347: aload_0
    //   348: areturn
    //   349: iload 10
    //   351: sipush 400
    //   354: if_icmpge -72 -> 282
    //   357: aload 33
    //   359: ldc_w 570
    //   362: invokevirtual 573	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   365: astore 31
    //   367: aload 31
    //   369: invokestatic 400	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   372: ifne +148 -> 520
    //   375: new 464	java/net/URL
    //   378: dup
    //   379: aload 31
    //   381: invokespecial 465	java/net/URL:<init>	(Ljava/lang/String;)V
    //   384: astore 31
    //   386: iload 9
    //   388: iconst_1
    //   389: iadd
    //   390: istore 9
    //   392: iload 9
    //   394: getstatic 576	com/google/android/gms/ads/internal/f/n:aE	Lcom/google/android/gms/ads/internal/f/c;
    //   397: invokevirtual 62	com/google/android/gms/ads/internal/f/c:a	()Ljava/lang/Object;
    //   400: checkcast 578	java/lang/Integer
    //   403: invokevirtual 581	java/lang/Integer:intValue	()I
    //   406: if_icmple +82 -> 488
    //   409: ldc_w 583
    //   412: invokestatic 282	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   415: new 284	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   418: dup
    //   419: iconst_0
    //   420: invokespecial 287	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   423: astore_1
    //   424: aload 33
    //   426: invokevirtual 561	java/net/HttpURLConnection:disconnect	()V
    //   429: aload_1
    //   430: astore_0
    //   431: aload 8
    //   433: ifnull -86 -> 347
    //   436: aload 8
    //   438: getfield 564	com/google/android/gms/ads/internal/request/a/b:g	Lcom/google/android/gms/ads/internal/request/a/t;
    //   441: invokeinterface 568 1 0
    //   446: aload_1
    //   447: areturn
    //   448: astore_0
    //   449: aload_0
    //   450: invokevirtual 586	java/io/IOException:getMessage	()Ljava/lang/String;
    //   453: invokestatic 454	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   456: astore_0
    //   457: aload_0
    //   458: invokevirtual 458	java/lang/String:length	()I
    //   461: ifne +709 -> 1170
    //   464: new 98	java/lang/String
    //   467: dup
    //   468: ldc_w 588
    //   471: invokespecial 462	java/lang/String:<init>	(Ljava/lang/String;)V
    //   474: astore_0
    //   475: aload_0
    //   476: invokestatic 282	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   479: new 284	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   482: dup
    //   483: iconst_2
    //   484: invokespecial 287	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   487: areturn
    //   488: aload 34
    //   490: aload_3
    //   491: invokevirtual 591	com/google/android/gms/ads/internal/request/a/i:a	(Ljava/util/Map;)V
    //   494: aload 33
    //   496: invokevirtual 561	java/net/HttpURLConnection:disconnect	()V
    //   499: aload 8
    //   501: ifnull +16 -> 517
    //   504: aload 8
    //   506: getfield 564	com/google/android/gms/ads/internal/request/a/b:g	Lcom/google/android/gms/ads/internal/request/a/t;
    //   509: invokeinterface 568 1 0
    //   514: goto +673 -> 1187
    //   517: goto +670 -> 1187
    //   520: ldc_w 593
    //   523: invokestatic 282	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;)V
    //   526: new 284	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   529: dup
    //   530: iconst_0
    //   531: invokespecial 287	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   534: astore_1
    //   535: aload 33
    //   537: invokevirtual 561	java/net/HttpURLConnection:disconnect	()V
    //   540: aload_1
    //   541: astore_0
    //   542: aload 8
    //   544: ifnull -197 -> 347
    //   547: aload 8
    //   549: getfield 564	com/google/android/gms/ads/internal/request/a/b:g	Lcom/google/android/gms/ads/internal/request/a/t;
    //   552: invokeinterface 568 1 0
    //   557: aload_1
    //   558: areturn
    //   559: iload 10
    //   561: sipush 300
    //   564: if_icmpge -302 -> 262
    //   567: aload 31
    //   569: invokevirtual 542	java/net/URL:toString	()Ljava/lang/String;
    //   572: astore_1
    //   573: new 595	java/io/InputStreamReader
    //   576: dup
    //   577: aload 33
    //   579: invokevirtual 599	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   582: invokespecial 602	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   585: astore_0
    //   586: getstatic 178	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   589: getfield 224	com/google/android/gms/ads/internal/bt:e	Lcom/google/android/gms/ads/internal/util/n;
    //   592: astore_2
    //   593: aload_0
    //   594: invokestatic 605	com/google/android/gms/ads/internal/util/n:a	(Ljava/io/InputStreamReader;)Ljava/lang/String;
    //   597: astore_2
    //   598: aload_0
    //   599: invokestatic 525	com/google/android/gms/common/util/g:a	(Ljava/io/Closeable;)V
    //   602: aload 32
    //   604: aload_2
    //   605: invokevirtual 607	com/google/android/gms/ads/internal/util/client/e:a	(Ljava/lang/String;)V
    //   608: aload_1
    //   609: aload_3
    //   610: aload_2
    //   611: iload 10
    //   613: invokestatic 545	com/google/android/gms/ads/internal/request/a/c:a	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   616: aload 34
    //   618: aload_2
    //   619: putfield 608	com/google/android/gms/ads/internal/request/a/i:g	Ljava/lang/String;
    //   622: aload 34
    //   624: aload_3
    //   625: invokevirtual 591	com/google/android/gms/ads/internal/request/a/i:a	(Ljava/util/Map;)V
    //   628: aload 7
    //   630: ifnonnull +393 -> 1023
    //   633: aload 34
    //   635: getfield 610	com/google/android/gms/ads/internal/request/a/i:b	Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;
    //   638: astore_0
    //   639: aload 34
    //   641: getfield 611	com/google/android/gms/ads/internal/request/a/i:f	Ljava/lang/String;
    //   644: astore_1
    //   645: aload 34
    //   647: getfield 608	com/google/android/gms/ads/internal/request/a/i:g	Ljava/lang/String;
    //   650: astore_2
    //   651: aload 34
    //   653: getfield 612	com/google/android/gms/ads/internal/request/a/i:h	Ljava/util/List;
    //   656: astore_3
    //   657: aload 34
    //   659: getfield 615	com/google/android/gms/ads/internal/request/a/i:o	Ljava/util/List;
    //   662: astore 4
    //   664: aload 34
    //   666: getfield 617	com/google/android/gms/ads/internal/request/a/i:p	J
    //   669: lstore 13
    //   671: aload 34
    //   673: getfield 620	com/google/android/gms/ads/internal/request/a/i:v	Z
    //   676: istore 17
    //   678: aload 34
    //   680: getfield 623	com/google/android/gms/ads/internal/request/a/i:B	Ljava/util/List;
    //   683: astore 5
    //   685: aload 34
    //   687: getfield 626	com/google/android/gms/ads/internal/request/a/i:G	J
    //   690: lstore 15
    //   692: aload 34
    //   694: getfield 629	com/google/android/gms/ads/internal/request/a/i:F	I
    //   697: istore 10
    //   699: aload 34
    //   701: getfield 631	com/google/android/gms/ads/internal/request/a/i:c	Ljava/lang/String;
    //   704: astore 7
    //   706: aload 34
    //   708: getfield 633	com/google/android/gms/ads/internal/request/a/i:k	Ljava/lang/String;
    //   711: astore 30
    //   713: aload 34
    //   715: getfield 634	com/google/android/gms/ads/internal/request/a/i:a	Ljava/lang/String;
    //   718: astore 31
    //   720: aload 34
    //   722: getfield 637	com/google/android/gms/ads/internal/request/a/i:t	Z
    //   725: istore 18
    //   727: aload 34
    //   729: getfield 640	com/google/android/gms/ads/internal/request/a/i:w	Z
    //   732: istore 19
    //   734: aload 34
    //   736: getfield 643	com/google/android/gms/ads/internal/request/a/i:L	Z
    //   739: istore 20
    //   741: aload 34
    //   743: getfield 644	com/google/android/gms/ads/internal/request/a/i:i	Z
    //   746: istore 21
    //   748: aload 34
    //   750: getfield 646	com/google/android/gms/ads/internal/request/a/i:n	Ljava/lang/String;
    //   753: astore 32
    //   755: aload 34
    //   757: getfield 649	com/google/android/gms/ads/internal/request/a/i:u	Z
    //   760: istore 22
    //   762: aload 34
    //   764: getfield 652	com/google/android/gms/ads/internal/request/a/i:x	Z
    //   767: istore 23
    //   769: aload 34
    //   771: getfield 656	com/google/android/gms/ads/internal/request/a/i:H	Lcom/google/android/gms/ads/internal/reward/mediation/client/RewardItemParcel;
    //   774: astore 35
    //   776: aload 34
    //   778: getfield 658	com/google/android/gms/ads/internal/request/a/i:J	Ljava/util/List;
    //   781: astore 36
    //   783: aload 34
    //   785: getfield 660	com/google/android/gms/ads/internal/request/a/i:I	Ljava/util/List;
    //   788: astore 37
    //   790: aload 34
    //   792: getfield 662	com/google/android/gms/ads/internal/request/a/i:A	Z
    //   795: istore 24
    //   797: aload 34
    //   799: getfield 665	com/google/android/gms/ads/internal/request/a/i:e	Lcom/google/android/gms/ads/internal/request/AutoClickProtectionConfigurationParcel;
    //   802: astore 38
    //   804: aload 34
    //   806: getfield 668	com/google/android/gms/ads/internal/request/a/i:q	Z
    //   809: istore 25
    //   811: aload 34
    //   813: getfield 670	com/google/android/gms/ads/internal/request/a/i:M	Ljava/lang/String;
    //   816: astore 39
    //   818: aload 34
    //   820: getfield 673	com/google/android/gms/ads/internal/request/a/i:C	Ljava/util/List;
    //   823: astore 40
    //   825: aload 34
    //   827: getfield 676	com/google/android/gms/ads/internal/request/a/i:D	Z
    //   830: istore 26
    //   832: aload 34
    //   834: getfield 678	com/google/android/gms/ads/internal/request/a/i:d	Ljava/lang/String;
    //   837: astore 41
    //   839: aload 34
    //   841: getfield 682	com/google/android/gms/ads/internal/request/a/i:K	Lcom/google/android/gms/ads/internal/safebrowsing/SafeBrowsingConfigParcel;
    //   844: astore 42
    //   846: aload 34
    //   848: getfield 683	com/google/android/gms/ads/internal/request/a/i:l	Ljava/lang/String;
    //   851: astore 43
    //   853: aload 34
    //   855: getfield 685	com/google/android/gms/ads/internal/request/a/i:j	Z
    //   858: istore 27
    //   860: aload 34
    //   862: getfield 688	com/google/android/gms/ads/internal/request/a/i:y	Z
    //   865: istore 28
    //   867: aload 34
    //   869: getfield 690	com/google/android/gms/ads/internal/request/a/i:s	Z
    //   872: istore 29
    //   874: aload 6
    //   876: getfield 692	com/google/android/gms/ads/internal/request/a/k:g	Z
    //   879: ifne +138 -> 1017
    //   882: iconst_1
    //   883: istore 9
    //   885: new 284	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   888: dup
    //   889: aload_0
    //   890: aload_1
    //   891: aload_2
    //   892: aload_3
    //   893: aload 4
    //   895: lload 13
    //   897: iload 17
    //   899: aload 5
    //   901: lload 15
    //   903: iload 10
    //   905: aload 7
    //   907: lload 11
    //   909: aload 30
    //   911: aload 31
    //   913: iload 18
    //   915: iload 19
    //   917: iload 20
    //   919: iload 21
    //   921: aload 32
    //   923: iload 22
    //   925: iload 23
    //   927: aload 35
    //   929: aload 36
    //   931: aload 37
    //   933: iload 24
    //   935: aload 38
    //   937: iload 25
    //   939: aload 39
    //   941: aload 40
    //   943: iload 26
    //   945: aload 41
    //   947: aload 42
    //   949: aload 43
    //   951: iload 27
    //   953: iload 28
    //   955: iload 29
    //   957: iload 9
    //   959: aload 34
    //   961: getfield 693	com/google/android/gms/ads/internal/request/a/i:z	Z
    //   964: aload 34
    //   966: getfield 696	com/google/android/gms/ads/internal/request/a/i:m	Ljava/util/List;
    //   969: aload 34
    //   971: getfield 699	com/google/android/gms/ads/internal/request/a/i:r	Z
    //   974: aload 34
    //   976: getfield 702	com/google/android/gms/ads/internal/request/a/i:E	Ljava/lang/String;
    //   979: aload 6
    //   981: getfield 420	com/google/android/gms/ads/internal/request/a/k:i	Ljava/lang/String;
    //   984: aload 6
    //   986: getfield 704	com/google/android/gms/ads/internal/request/a/k:h	Z
    //   989: invokespecial 707	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JZLjava/util/List;JILjava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;ZZLcom/google/android/gms/ads/internal/reward/mediation/client/RewardItemParcel;Ljava/util/List;Ljava/util/List;ZLcom/google/android/gms/ads/internal/request/AutoClickProtectionConfigurationParcel;ZLjava/lang/String;Ljava/util/List;ZLjava/lang/String;Lcom/google/android/gms/ads/internal/safebrowsing/SafeBrowsingConfigParcel;Ljava/lang/String;ZZZIZLjava/util/List;ZLjava/lang/String;Ljava/lang/String;Z)V
    //   992: astore_1
    //   993: aload 33
    //   995: invokevirtual 561	java/net/HttpURLConnection:disconnect	()V
    //   998: aload_1
    //   999: astore_0
    //   1000: aload 8
    //   1002: ifnull -655 -> 347
    //   1005: aload 8
    //   1007: getfield 564	com/google/android/gms/ads/internal/request/a/b:g	Lcom/google/android/gms/ads/internal/request/a/t;
    //   1010: invokeinterface 568 1 0
    //   1015: aload_1
    //   1016: areturn
    //   1017: iconst_2
    //   1018: istore 9
    //   1020: goto -135 -> 885
    //   1023: aload 7
    //   1025: aload 30
    //   1027: iconst_1
    //   1028: anewarray 98	java/lang/String
    //   1031: dup
    //   1032: iconst_0
    //   1033: ldc_w 709
    //   1036: aastore
    //   1037: invokevirtual 103	com/google/android/gms/ads/internal/g/l:a	(Lcom/google/android/gms/ads/internal/g/j;[Ljava/lang/String;)Z
    //   1040: pop
    //   1041: goto -408 -> 633
    //   1044: astore_0
    //   1045: aload 33
    //   1047: invokevirtual 561	java/net/HttpURLConnection:disconnect	()V
    //   1050: aload 8
    //   1052: ifnull +13 -> 1065
    //   1055: aload 8
    //   1057: getfield 564	com/google/android/gms/ads/internal/request/a/b:g	Lcom/google/android/gms/ads/internal/request/a/t;
    //   1060: invokeinterface 568 1 0
    //   1065: aload_0
    //   1066: athrow
    //   1067: aconst_null
    //   1068: astore_3
    //   1069: goto -858 -> 211
    //   1072: aconst_null
    //   1073: astore_3
    //   1074: goto -863 -> 211
    //   1077: aload 4
    //   1079: invokestatic 400	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1082: ifeq +24 -> 1106
    //   1085: aload 5
    //   1087: invokestatic 400	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1090: ifne -972 -> 118
    //   1093: aload 33
    //   1095: ldc_w 711
    //   1098: aload 5
    //   1100: invokevirtual 494	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1103: goto -985 -> 118
    //   1106: aload 33
    //   1108: ldc_w 713
    //   1111: aload 4
    //   1113: invokevirtual 494	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1116: goto -31 -> 1085
    //   1119: aload 8
    //   1121: getfield 564	com/google/android/gms/ads/internal/request/a/b:g	Lcom/google/android/gms/ads/internal/request/a/t;
    //   1124: invokeinterface 715 1 0
    //   1129: goto -1042 -> 87
    //   1132: ldc_w 460
    //   1135: aload 31
    //   1137: invokevirtual 718	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1140: astore 31
    //   1142: goto -1089 -> 53
    //   1145: aconst_null
    //   1146: astore 30
    //   1148: goto -1136 -> 12
    //   1151: astore_1
    //   1152: aconst_null
    //   1153: astore_0
    //   1154: aload_0
    //   1155: invokestatic 525	com/google/android/gms/common/util/g:a	(Ljava/io/Closeable;)V
    //   1158: aload_1
    //   1159: athrow
    //   1160: aload_0
    //   1161: invokestatic 525	com/google/android/gms/common/util/g:a	(Ljava/io/Closeable;)V
    //   1164: aload_1
    //   1165: athrow
    //   1166: astore_1
    //   1167: goto -7 -> 1160
    //   1170: ldc_w 588
    //   1173: aload_0
    //   1174: invokevirtual 718	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1177: astore_0
    //   1178: goto -703 -> 475
    //   1181: astore_1
    //   1182: aload_3
    //   1183: astore_0
    //   1184: goto -30 -> 1154
    //   1187: aload 8
    //   1189: ifnonnull -70 -> 1119
    //   1192: goto -1105 -> 87
    //   1195: astore_1
    //   1196: aconst_null
    //   1197: astore_0
    //   1198: goto -38 -> 1160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1201	0	paramAdRequestInfoParcel	AdRequestInfoParcel
    //   0	1201	1	paramContext	Context
    //   0	1201	2	paramString1	String
    //   0	1201	3	paramString2	String
    //   0	1201	4	paramString3	String
    //   0	1201	5	paramString4	String
    //   0	1201	6	paramk	k
    //   0	1201	7	paraml	com.google.android.gms.ads.internal.g.l
    //   0	1201	8	paramb	b
    //   82	937	9	i	int
    //   237	667	10	j	int
    //   79	829	11	l1	long
    //   669	227	13	l2	long
    //   690	212	15	l3	long
    //   676	222	17	bool1	boolean
    //   725	189	18	bool2	boolean
    //   732	184	19	bool3	boolean
    //   739	179	20	bool4	boolean
    //   746	174	21	bool5	boolean
    //   760	164	22	bool6	boolean
    //   767	159	23	bool7	boolean
    //   795	139	24	bool8	boolean
    //   809	129	25	bool9	boolean
    //   830	114	26	bool10	boolean
    //   858	94	27	bool11	boolean
    //   865	89	28	bool12	boolean
    //   872	84	29	bool13	boolean
    //   10	1137	30	localObject1	Object
    //   31	1110	31	localObject2	Object
    //   175	747	32	localObject3	Object
    //   95	1012	33	localHttpURLConnection	java.net.HttpURLConnection
    //   25	950	34	locali	i
    //   774	154	35	localRewardItemParcel	com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel
    //   781	149	36	localList1	List
    //   788	144	37	localList2	List
    //   802	134	38	localAutoClickProtectionConfigurationParcel	com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel
    //   816	124	39	str1	String
    //   823	119	40	localList3	List
    //   837	109	41	str2	String
    //   844	104	42	localSafeBrowsingConfigParcel	com.google.android.gms.ads.internal.safebrowsing.SafeBrowsingConfigParcel
    //   851	99	43	str3	String
    // Exception table:
    //   from	to	target	type
    //   12	53	448	java/io/IOException
    //   53	81	448	java/io/IOException
    //   87	97	448	java/io/IOException
    //   323	328	448	java/io/IOException
    //   335	345	448	java/io/IOException
    //   424	429	448	java/io/IOException
    //   436	446	448	java/io/IOException
    //   494	499	448	java/io/IOException
    //   504	514	448	java/io/IOException
    //   535	540	448	java/io/IOException
    //   547	557	448	java/io/IOException
    //   993	998	448	java/io/IOException
    //   1005	1015	448	java/io/IOException
    //   1045	1050	448	java/io/IOException
    //   1055	1065	448	java/io/IOException
    //   1065	1067	448	java/io/IOException
    //   1119	1129	448	java/io/IOException
    //   1132	1142	448	java/io/IOException
    //   97	118	1044	finally
    //   118	145	1044	finally
    //   150	185	1044	finally
    //   204	208	1044	finally
    //   211	254	1044	finally
    //   262	274	1044	finally
    //   282	323	1044	finally
    //   357	386	1044	finally
    //   392	424	1044	finally
    //   488	494	1044	finally
    //   520	535	1044	finally
    //   567	573	1044	finally
    //   598	628	1044	finally
    //   633	882	1044	finally
    //   885	993	1044	finally
    //   1023	1041	1044	finally
    //   1077	1085	1044	finally
    //   1085	1103	1044	finally
    //   1106	1116	1044	finally
    //   1154	1160	1044	finally
    //   1160	1166	1044	finally
    //   185	198	1151	finally
    //   586	598	1166	finally
    //   198	204	1181	finally
    //   573	586	1195	finally
  }
  
  public static c a(Context paramContext, b paramb)
  {
    synchronized (e)
    {
      if (d != null)
      {
        paramContext = d;
        return paramContext;
      }
      Context localContext = paramContext;
      if (paramContext.getApplicationContext() != null) {
        localContext = paramContext.getApplicationContext();
      }
      com.google.android.gms.ads.internal.f.n.a(localContext);
      d = new c(localContext, paramb);
      if (localContext.getApplicationContext() != null) {
        bt.A.e.c(localContext);
      }
      com.google.android.gms.ads.internal.util.c.a(localContext);
    }
  }
  
  private static void a(String paramString1, Map paramMap, String paramString2, int paramInt)
  {
    if (com.google.android.gms.ads.internal.util.e.a(2))
    {
      Object localObject1 = new StringBuilder(String.valueOf(paramString1).length() + 39);
      ((StringBuilder)localObject1).append("Http Response: {\n  URL:\n    ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("\n  Headers:");
      com.google.android.gms.ads.internal.util.e.a(((StringBuilder)localObject1).toString());
      if (paramMap != null)
      {
        localObject1 = paramMap.keySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          paramString1 = (String)((Iterator)localObject1).next();
          Object localObject2 = new StringBuilder(String.valueOf(paramString1).length() + 5);
          ((StringBuilder)localObject2).append("    ");
          ((StringBuilder)localObject2).append(paramString1);
          ((StringBuilder)localObject2).append(":");
          com.google.android.gms.ads.internal.util.e.a(((StringBuilder)localObject2).toString());
          localObject2 = ((List)paramMap.get(paramString1)).iterator();
          label165:
          if (((Iterator)localObject2).hasNext())
          {
            paramString1 = String.valueOf((String)((Iterator)localObject2).next());
            if (paramString1.length() != 0) {
              break label214;
            }
          }
          label214:
          for (paramString1 = new String("      ");; paramString1 = "      ".concat(paramString1))
          {
            com.google.android.gms.ads.internal.util.e.a(paramString1);
            break label165;
            break;
          }
        }
      }
      com.google.android.gms.ads.internal.util.e.a("  Body:");
      if (paramString2 != null) {
        break label281;
      }
      com.google.android.gms.ads.internal.util.e.a("    null");
    }
    for (;;)
    {
      paramString1 = new StringBuilder(34);
      paramString1.append("  Response Code:\n    ");
      paramString1.append(paramInt);
      paramString1.append("\n}");
      com.google.android.gms.ads.internal.util.e.a(paramString1.toString());
      return;
      label281:
      int j;
      for (int i = 0; i < Math.min(paramString2.length(), 100000); i = j)
      {
        j = i + 1000;
        com.google.android.gms.ads.internal.util.e.a(paramString2.substring(i, Math.min(paramString2.length(), j)));
      }
    }
  }
  
  public final AdResponseParcel a(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    return a(this.a, this.b, paramAdRequestInfoParcel, this.c);
  }
  
  public final void a(AdRequestInfoParcel paramAdRequestInfoParcel, ac paramac)
  {
    bt.A.i.a(this.a, paramAdRequestInfoParcel.ae);
    paramAdRequestInfoParcel = com.google.android.gms.ads.internal.util.l.a(new e(this, paramAdRequestInfoParcel, paramac));
    bt.A.t.a();
    bt.A.t.a.postDelayed(new f(paramAdRequestInfoParcel), 60000L);
  }
  
  public final void a(NonagonRequestParcel paramNonagonRequestParcel, af paramaf)
  {
    com.google.android.gms.ads.internal.util.e.a("Nonagon code path entered in octagon");
    throw new IllegalArgumentException();
  }
  
  public final void b(NonagonRequestParcel paramNonagonRequestParcel, af paramaf)
  {
    com.google.android.gms.ads.internal.util.e.a("Nonagon code path entered in octagon");
    throw new IllegalArgumentException();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */