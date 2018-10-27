package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.ag;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.l;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class AdLoaderBackgroundTask
  extends com.google.android.gms.ads.internal.util.a
  implements m
{
  public boolean a;
  public ag b;
  public final Object c = new Object();
  public final Context d;
  public final u e;
  public Runnable f;
  private final b g;
  private final com.google.android.gms.ads.internal.d.a h;
  private AdRequestInfoParcel i;
  private AdResponseParcel m;
  private final com.google.android.gms.ads.internal.d.h n;
  private com.google.android.gms.ads.internal.mediation.c o;
  
  public AdLoaderBackgroundTask(Context paramContext, u paramu, b paramb, com.google.android.gms.ads.internal.d.h paramh)
  {
    this.g = paramb;
    this.d = paramContext;
    this.e = paramu;
    this.n = paramh;
    this.h = new com.google.android.gms.ads.internal.d.a(this.n);
    this.h.a(new c(this));
    paramContext = new com.google.android.gms.ads.internal.d.a.f();
    paramContext.a = Integer.valueOf(this.e.Y.b);
    paramContext.c = Integer.valueOf(this.e.Y.c);
    if (!this.e.Y.d) {}
    for (int j = 2;; j = 0)
    {
      paramContext.b = Integer.valueOf(j);
      this.h.a(new d(paramContext));
      if (this.e.M != null) {
        this.h.a(new e(this));
      }
      paramContext = this.e.c;
      if ((paramContext.e) && ("interstitial_mb".equals(paramContext.a))) {
        this.h.a(f.a);
      }
      for (;;)
      {
        this.h.a(com.google.android.gms.ads.internal.d.g.f);
        return;
        if ((paramContext.e) && ("reward_mb".equals(paramContext.a))) {
          this.h.a(g.a);
        } else if ((!paramContext.f) && (!paramContext.e)) {
          this.h.a(h.a);
        } else {
          this.h.a(i.a);
        }
      }
    }
  }
  
  private final AdSizeParcel a(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    Object localObject = this.i;
    int k;
    int j;
    if (localObject != null)
    {
      localObject = ((AdRequestInfoParcel)localObject).f;
      if ((localObject != null) && (((List)localObject).size() > 1)) {}
    }
    else if (this.m.w)
    {
      localObject = paramAdRequestInfoParcel.c.h;
      k = localObject.length;
      j = 0;
      label60:
      if (j < k) {}
    }
    else
    {
      localObject = this.m.b;
      if (localObject == null) {
        break label356;
      }
      localObject = ((String)localObject).split("x");
      if (localObject.length != 2)
      {
        paramAdRequestInfoParcel = String.valueOf(this.m.b);
        if (paramAdRequestInfoParcel.length() != 0) {
          break label367;
        }
      }
    }
    label356:
    label367:
    for (paramAdRequestInfoParcel = new String("Invalid ad size format from the ad response: ");; paramAdRequestInfoParcel = "Invalid ad size format from the ad response: ".concat(paramAdRequestInfoParcel))
    {
      throw new AdLoaderBackgroundTask.AdLoaderException(paramAdRequestInfoParcel, 0);
      try
      {
        int i3 = Integer.parseInt(localObject[0]);
        int i4 = Integer.parseInt(localObject[1]);
        localObject = paramAdRequestInfoParcel.c.h;
        int i5 = localObject.length;
        j = 0;
        if (j >= i5) {
          break label416;
        }
        localAdSizeParcel = localObject[j];
        float f1 = this.d.getResources().getDisplayMetrics().density;
        int i1 = localAdSizeParcel.i;
        k = i1;
        if (i1 == -1) {
          k = (int)(localAdSizeParcel.j / f1);
        }
        int i2 = localAdSizeParcel.b;
        i1 = i2;
        if (i2 == -2) {
          i1 = (int)(localAdSizeParcel.c / f1);
        }
        if (i3 != k) {}
        while ((i4 != i1) || (localAdSizeParcel.d))
        {
          j += 1;
          break;
        }
        return new AdSizeParcel(localAdSizeParcel, paramAdRequestInfoParcel.c.h);
      }
      catch (NumberFormatException paramAdRequestInfoParcel)
      {
        AdSizeParcel localAdSizeParcel;
        paramAdRequestInfoParcel = String.valueOf(this.m.b);
        if (paramAdRequestInfoParcel.length() != 0) {
          break label454;
        }
      }
      localAdSizeParcel = localObject[j];
      if (localAdSizeParcel.d) {
        return new AdSizeParcel(localAdSizeParcel, paramAdRequestInfoParcel.c.h);
      }
      j += 1;
      break label60;
      localObject = this.o;
      if ((localObject == null) || (((com.google.android.gms.ads.internal.mediation.c)localObject).j)) {
        break;
      }
      return null;
      throw new AdLoaderBackgroundTask.AdLoaderException("The ad response must specify one of the supported ad sizes.", 0);
    }
    paramAdRequestInfoParcel = new String("Invalid ad size number from the ad response: ");
    throw new AdLoaderBackgroundTask.AdLoaderException(paramAdRequestInfoParcel, 0);
    label416:
    paramAdRequestInfoParcel = String.valueOf(this.m.b);
    if (paramAdRequestInfoParcel.length() == 0) {}
    for (paramAdRequestInfoParcel = new String("The ad size from the ad response was not one of the requested sizes: ");; paramAdRequestInfoParcel = "The ad size from the ad response was not one of the requested sizes: ".concat(paramAdRequestInfoParcel))
    {
      throw new AdLoaderBackgroundTask.AdLoaderException(paramAdRequestInfoParcel, 0);
      label454:
      paramAdRequestInfoParcel = "Invalid ad size number from the ad response: ".concat(paramAdRequestInfoParcel);
      break;
    }
  }
  
  public final void a()
  {
    com.google.android.gms.ads.internal.util.e.b("AdLoaderBackgroundTask started.");
    this.f = new j(this);
    com.google.android.gms.ads.internal.util.n.a.postDelayed(this.f, ((Long)com.google.android.gms.ads.internal.f.n.g.a()).longValue());
    long l = bt.A.l.b();
    Object localObject = this.e.b.f;
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("_ad");
      if (localObject != null)
      {
        this.i = new AdRequestInfoParcel(this.e, l, null, null, null, null);
        a(com.google.android.gms.ads.internal.request.a.h.a(this.d, this.i, (String)localObject));
        return;
      }
    }
    localObject = new com.google.android.gms.ads.internal.util.c.e();
    l.a(new k(this, (com.google.android.gms.ads.internal.util.c.a)localObject));
    com.google.android.gms.ads.internal.s.b localb = bt.A.B;
    localb = bt.A.B;
    localb = bt.A.B;
    localb = bt.A.B;
    this.i = new AdRequestInfoParcel(this.e, l, null, null, null, null);
    ((com.google.android.gms.ads.internal.util.c.a)localObject).a(this.i);
  }
  
  final void a(int paramInt, String paramString)
  {
    if ((paramInt != 3) && (paramInt != -1)) {
      com.google.android.gms.ads.internal.util.e.e(paramString);
    }
    for (;;)
    {
      paramString = this.m;
      if (paramString == null) {}
      for (this.m = new AdResponseParcel(paramInt);; this.m = new AdResponseParcel(paramInt, paramString.M))
      {
        Object localObject = this.i;
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = new AdRequestInfoParcel(this.e, -1L, null, null, null, null);
        }
        localObject = this.m;
        paramString = new com.google.android.gms.ads.internal.v.b(paramString, (AdResponseParcel)localObject, this.o, null, paramInt, -1L, ((AdResponseParcel)localObject).o, null, this.h, null);
        this.g.a(paramString);
        return;
      }
      com.google.android.gms.ads.internal.util.e.d(paramString);
    }
  }
  
  /* Error */
  public final void a(AdResponseParcel paramAdResponseParcel)
  {
    // Byte code:
    //   0: ldc_w 386
    //   3: invokestatic 258	com/google/android/gms/ads/internal/util/e:b	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: aload_1
    //   8: putfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   11: aload_0
    //   12: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   15: getfield 389	com/google/android/gms/ads/internal/request/AdResponseParcel:T	Ljava/lang/String;
    //   18: invokestatic 395	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +678 -> 699
    //   24: getstatic 296	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   27: getfield 300	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   30: invokeinterface 304 1 0
    //   35: lstore_3
    //   36: aload_0
    //   37: getfield 41	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:c	Ljava/lang/Object;
    //   40: astore_1
    //   41: aload_1
    //   42: monitorenter
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 397	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:b	Lcom/google/android/gms/ads/internal/util/ag;
    //   48: aload_1
    //   49: monitorexit
    //   50: getstatic 296	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   53: getfield 400	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   56: invokevirtual 405	com/google/android/gms/ads/internal/v/f:f	()Lcom/google/android/gms/ads/internal/util/g;
    //   59: aload_0
    //   60: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   63: getfield 408	com/google/android/gms/ads/internal/request/AdResponseParcel:s	Z
    //   66: invokeinterface 413 2 0
    //   71: getstatic 416	com/google/android/gms/ads/internal/f/n:aL	Lcom/google/android/gms/ads/internal/f/c;
    //   74: invokevirtual 278	com/google/android/gms/ads/internal/f/c:a	()Ljava/lang/Object;
    //   77: checkcast 418	java/lang/Boolean
    //   80: invokevirtual 422	java/lang/Boolean:booleanValue	()Z
    //   83: ifeq +34 -> 117
    //   86: aload_0
    //   87: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   90: getfield 424	com/google/android/gms/ads/internal/request/AdResponseParcel:B	Z
    //   93: ifeq +582 -> 675
    //   96: getstatic 296	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   99: getfield 400	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   102: invokevirtual 405	com/google/android/gms/ads/internal/v/f:f	()Lcom/google/android/gms/ads/internal/util/g;
    //   105: aload_0
    //   106: getfield 157	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:i	Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;
    //   109: getfield 426	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:d	Ljava/lang/String;
    //   112: invokeinterface 428 2 0
    //   117: aload_0
    //   118: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   121: astore_1
    //   122: aload_1
    //   123: getfield 430	com/google/android/gms/ads/internal/request/AdResponseParcel:n	I
    //   126: istore_2
    //   127: iload_2
    //   128: bipush -2
    //   130: if_icmpne +496 -> 626
    //   133: goto +655 -> 788
    //   136: aload_0
    //   137: getfield 157	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:i	Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;
    //   140: astore_1
    //   141: aload_1
    //   142: getfield 176	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:c	Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   145: getfield 179	com/google/android/gms/ads/internal/client/AdSizeParcel:h	[Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   148: ifnull +285 -> 433
    //   151: aload_0
    //   152: aload_1
    //   153: invokespecial 432	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:a	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)Lcom/google/android/gms/ads/internal/client/AdSizeParcel;
    //   156: astore 7
    //   158: getstatic 296	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   161: getfield 400	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   164: invokevirtual 405	com/google/android/gms/ads/internal/v/f:f	()Lcom/google/android/gms/ads/internal/util/g;
    //   167: aload_0
    //   168: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   171: getfield 434	com/google/android/gms/ads/internal/request/AdResponseParcel:h	Z
    //   174: invokeinterface 436 2 0
    //   179: getstatic 296	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   182: getfield 400	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   185: invokevirtual 405	com/google/android/gms/ads/internal/v/f:f	()Lcom/google/android/gms/ads/internal/util/g;
    //   188: aload_0
    //   189: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   192: getfield 438	com/google/android/gms/ads/internal/request/AdResponseParcel:i	Z
    //   195: invokeinterface 440 2 0
    //   200: aload_0
    //   201: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   204: getfield 441	com/google/android/gms/ads/internal/request/AdResponseParcel:a	Ljava/lang/String;
    //   207: invokestatic 395	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   210: ifne +217 -> 427
    //   213: new 443	org/json/JSONObject
    //   216: dup
    //   217: aload_0
    //   218: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   221: getfield 441	com/google/android/gms/ads/internal/request/AdResponseParcel:a	Ljava/lang/String;
    //   224: invokespecial 444	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   227: astore 6
    //   229: aload_0
    //   230: getfield 157	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:i	Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;
    //   233: getfield 445	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:b	Lcom/google/android/gms/ads/internal/client/AdRequestParcel;
    //   236: getfield 447	com/google/android/gms/ads/internal/client/AdRequestParcel:n	Landroid/os/Bundle;
    //   239: astore 10
    //   241: aload_0
    //   242: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   245: getfield 450	com/google/android/gms/ads/internal/request/AdResponseParcel:N	I
    //   248: istore_2
    //   249: iload_2
    //   250: iconst_2
    //   251: if_icmpne +142 -> 393
    //   254: iconst_1
    //   255: invokestatic 453	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   258: astore_1
    //   259: aload 10
    //   261: invokestatic 458	com/google/android/gms/ads/internal/util/bp:a	(Landroid/os/Bundle;)V
    //   264: aload_0
    //   265: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   268: getfield 461	com/google/android/gms/ads/internal/request/AdResponseParcel:S	Z
    //   271: ifeq +56 -> 327
    //   274: aload 10
    //   276: ldc_w 463
    //   279: invokevirtual 469	java/lang/Class:getName	()Ljava/lang/String;
    //   282: invokevirtual 473	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   285: astore 9
    //   287: aload 9
    //   289: astore 8
    //   291: aload 9
    //   293: ifnonnull +25 -> 318
    //   296: new 316	android/os/Bundle
    //   299: dup
    //   300: invokespecial 474	android/os/Bundle:<init>	()V
    //   303: astore 8
    //   305: aload 10
    //   307: ldc_w 463
    //   310: invokevirtual 469	java/lang/Class:getName	()Ljava/lang/String;
    //   313: aload 8
    //   315: invokevirtual 478	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   318: aload 8
    //   320: ldc_w 480
    //   323: iconst_1
    //   324: invokevirtual 484	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   327: aload_0
    //   328: getfield 157	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:i	Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;
    //   331: astore 8
    //   333: aload_0
    //   334: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   337: astore 9
    //   339: new 362	com/google/android/gms/ads/internal/v/b
    //   342: dup
    //   343: aload 8
    //   345: aload 9
    //   347: aload_0
    //   348: getfield 238	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:o	Lcom/google/android/gms/ads/internal/mediation/c;
    //   351: aload 7
    //   353: bipush -2
    //   355: lload_3
    //   356: aload 9
    //   358: getfield 365	com/google/android/gms/ads/internal/request/AdResponseParcel:o	J
    //   361: aload 6
    //   363: aload_0
    //   364: getfield 56	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:h	Lcom/google/android/gms/ads/internal/d/a;
    //   367: aload_1
    //   368: invokespecial 368	com/google/android/gms/ads/internal/v/b:<init>	(Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;Lcom/google/android/gms/ads/internal/request/AdResponseParcel;Lcom/google/android/gms/ads/internal/mediation/c;Lcom/google/android/gms/ads/internal/client/AdSizeParcel;IJJLorg/json/JSONObject;Lcom/google/android/gms/ads/internal/d/a;Ljava/lang/Boolean;)V
    //   371: astore_1
    //   372: aload_0
    //   373: getfield 43	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:g	Lcom/google/android/gms/ads/internal/request/b;
    //   376: aload_1
    //   377: invokeinterface 373 2 0
    //   382: getstatic 268	com/google/android/gms/ads/internal/util/n:a	Landroid/os/Handler;
    //   385: aload_0
    //   386: getfield 263	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:f	Ljava/lang/Runnable;
    //   389: invokevirtual 488	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   392: return
    //   393: iload_2
    //   394: iconst_1
    //   395: if_icmpne +11 -> 406
    //   398: iconst_0
    //   399: invokestatic 453	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   402: astore_1
    //   403: goto -139 -> 264
    //   406: iload_2
    //   407: ifne +15 -> 422
    //   410: aload 10
    //   412: invokestatic 491	com/google/android/gms/ads/internal/util/bp:b	(Landroid/os/Bundle;)Z
    //   415: invokestatic 453	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   418: astore_1
    //   419: goto -155 -> 264
    //   422: aconst_null
    //   423: astore_1
    //   424: goto -160 -> 264
    //   427: aconst_null
    //   428: astore 6
    //   430: goto -201 -> 229
    //   433: aconst_null
    //   434: astore 7
    //   436: goto -278 -> 158
    //   439: aload_1
    //   440: getfield 493	com/google/android/gms/ads/internal/request/AdResponseParcel:f	Ljava/lang/String;
    //   443: invokestatic 395	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   446: ifeq +39 -> 485
    //   449: new 200	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   452: dup
    //   453: ldc_w 495
    //   456: iconst_3
    //   457: invokespecial 203	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException:<init>	(Ljava/lang/String;I)V
    //   460: athrow
    //   461: astore_1
    //   462: aload_0
    //   463: aload_1
    //   464: getfield 497	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException:a	I
    //   467: aload_1
    //   468: invokevirtual 500	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException:getMessage	()Ljava/lang/String;
    //   471: invokevirtual 502	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:a	(ILjava/lang/String;)V
    //   474: getstatic 268	com/google/android/gms/ads/internal/util/n:a	Landroid/os/Handler;
    //   477: aload_0
    //   478: getfield 263	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:f	Ljava/lang/Runnable;
    //   481: invokevirtual 488	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   484: return
    //   485: getstatic 296	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   488: getfield 400	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   491: invokevirtual 405	com/google/android/gms/ads/internal/v/f:f	()Lcom/google/android/gms/ads/internal/util/g;
    //   494: aload_0
    //   495: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   498: getfield 505	com/google/android/gms/ads/internal/request/AdResponseParcel:U	Z
    //   501: invokeinterface 507 2 0
    //   506: aload_0
    //   507: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   510: astore_1
    //   511: aload_1
    //   512: getfield 510	com/google/android/gms/ads/internal/request/AdResponseParcel:y	Z
    //   515: istore 5
    //   517: iload 5
    //   519: ifeq +88 -> 607
    //   522: aload_0
    //   523: new 240	com/google/android/gms/ads/internal/mediation/c
    //   526: dup
    //   527: aload_1
    //   528: getfield 493	com/google/android/gms/ads/internal/request/AdResponseParcel:f	Ljava/lang/String;
    //   531: invokespecial 511	com/google/android/gms/ads/internal/mediation/c:<init>	(Ljava/lang/String;)V
    //   534: putfield 238	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:o	Lcom/google/android/gms/ads/internal/mediation/c;
    //   537: getstatic 296	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   540: getfield 400	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   543: aload_0
    //   544: getfield 238	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:o	Lcom/google/android/gms/ads/internal/mediation/c;
    //   547: getfield 513	com/google/android/gms/ads/internal/mediation/c:o	Z
    //   550: invokevirtual 514	com/google/android/gms/ads/internal/v/f:a	(Z)V
    //   553: aload_0
    //   554: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   557: getfield 517	com/google/android/gms/ads/internal/request/AdResponseParcel:V	Ljava/lang/String;
    //   560: invokestatic 395	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   563: ifne -427 -> 136
    //   566: ldc_w 519
    //   569: invokestatic 258	com/google/android/gms/ads/internal/util/e:b	(Ljava/lang/String;)V
    //   572: getstatic 296	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   575: getfield 522	com/google/android/gms/ads/internal/bt:g	Lcom/google/android/gms/ads/internal/util/v;
    //   578: aload_0
    //   579: getfield 45	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:d	Landroid/content/Context;
    //   582: invokevirtual 527	com/google/android/gms/ads/internal/util/v:c	(Landroid/content/Context;)Landroid/webkit/CookieManager;
    //   585: astore_1
    //   586: aload_1
    //   587: ifnull -451 -> 136
    //   590: aload_1
    //   591: ldc_w 529
    //   594: aload_0
    //   595: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   598: getfield 517	com/google/android/gms/ads/internal/request/AdResponseParcel:V	Ljava/lang/String;
    //   601: invokevirtual 535	android/webkit/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: goto -468 -> 136
    //   607: getstatic 296	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   610: getfield 400	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   613: aload_0
    //   614: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   617: getfield 537	com/google/android/gms/ads/internal/request/AdResponseParcel:I	Z
    //   620: invokevirtual 514	com/google/android/gms/ads/internal/v/f:a	(Z)V
    //   623: goto -70 -> 553
    //   626: iload_2
    //   627: bipush -3
    //   629: if_icmpeq +159 -> 788
    //   632: new 539	java/lang/StringBuilder
    //   635: dup
    //   636: bipush 66
    //   638: invokespecial 540	java/lang/StringBuilder:<init>	(I)V
    //   641: astore_1
    //   642: aload_1
    //   643: ldc_w 542
    //   646: invokevirtual 546	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload_1
    //   651: iload_2
    //   652: invokevirtual 549	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   655: pop
    //   656: new 200	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   659: dup
    //   660: aload_1
    //   661: invokevirtual 552	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: aload_0
    //   665: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   668: getfield 430	com/google/android/gms/ads/internal/request/AdResponseParcel:n	I
    //   671: invokespecial 203	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException:<init>	(Ljava/lang/String;I)V
    //   674: athrow
    //   675: getstatic 296	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   678: getfield 400	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   681: invokevirtual 405	com/google/android/gms/ads/internal/v/f:f	()Lcom/google/android/gms/ads/internal/util/g;
    //   684: aload_0
    //   685: getfield 157	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:i	Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;
    //   688: getfield 426	com/google/android/gms/ads/internal/request/AdRequestInfoParcel:d	Ljava/lang/String;
    //   691: invokeinterface 553 2 0
    //   696: goto -579 -> 117
    //   699: getstatic 296	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   702: getfield 347	com/google/android/gms/ads/internal/bt:B	Lcom/google/android/gms/ads/internal/s/b;
    //   705: astore_1
    //   706: goto -682 -> 24
    //   709: astore 6
    //   711: aload_1
    //   712: monitorexit
    //   713: aload 6
    //   715: athrow
    //   716: astore_1
    //   717: ldc_w 555
    //   720: aload_1
    //   721: invokestatic 558	com/google/android/gms/ads/internal/util/e:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   724: aconst_null
    //   725: astore 6
    //   727: goto -498 -> 229
    //   730: astore_1
    //   731: ldc_w 560
    //   734: aload_1
    //   735: invokestatic 558	com/google/android/gms/ads/internal/util/e:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   738: aload_0
    //   739: getfield 170	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask:m	Lcom/google/android/gms/ads/internal/request/AdResponseParcel;
    //   742: getfield 493	com/google/android/gms/ads/internal/request/AdResponseParcel:f	Ljava/lang/String;
    //   745: invokestatic 190	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   748: astore_1
    //   749: aload_1
    //   750: invokevirtual 193	java/lang/String:length	()I
    //   753: ifne +24 -> 777
    //   756: new 121	java/lang/String
    //   759: dup
    //   760: ldc_w 562
    //   763: invokespecial 198	java/lang/String:<init>	(Ljava/lang/String;)V
    //   766: astore_1
    //   767: new 200	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   770: dup
    //   771: aload_1
    //   772: iconst_0
    //   773: invokespecial 203	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException:<init>	(Ljava/lang/String;I)V
    //   776: athrow
    //   777: ldc_w 562
    //   780: aload_1
    //   781: invokevirtual 248	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   784: astore_1
    //   785: goto -18 -> 767
    //   788: iload_2
    //   789: bipush -3
    //   791: if_icmpne -352 -> 439
    //   794: goto -658 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	797	0	this	AdLoaderBackgroundTask
    //   0	797	1	paramAdResponseParcel	AdResponseParcel
    //   126	666	2	j	int
    //   35	321	3	l	long
    //   515	3	5	bool	boolean
    //   227	202	6	localJSONObject	org.json.JSONObject
    //   709	5	6	localObject1	Object
    //   725	1	6	localObject2	Object
    //   156	279	7	localAdSizeParcel	AdSizeParcel
    //   289	55	8	localObject3	Object
    //   285	72	9	localObject4	Object
    //   239	172	10	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   117	127	461	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   136	158	461	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   439	461	461	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   485	517	461	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   522	553	461	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   553	586	461	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   590	604	461	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   607	623	461	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   632	675	461	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   731	767	461	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   767	777	461	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   777	785	461	com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask$AdLoaderException
    //   43	50	709	finally
    //   711	713	709	finally
    //   213	229	716	java/lang/Exception
    //   522	553	730	org/json/JSONException
  }
  
  public final void be_()
  {
    synchronized (this.c)
    {
      ag localag = this.b;
      if (localag == null) {
        return;
      }
      localag.b();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/AdLoaderBackgroundTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */