package com.google.android.gms.ads.internal.mediation;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.a.v;
import com.google.android.gms.ads.internal.util.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@com.google.android.gms.ads.internal.q.a.a
public final class l
  implements a
{
  public final long a;
  public boolean b = false;
  public final Map c = new HashMap();
  public final Object d = new Object();
  public final long e;
  private final AdRequestInfoParcel f;
  private final String g;
  private final com.google.android.gms.ads.internal.mediation.client.b h;
  private final Context i;
  private final boolean j;
  private final boolean k;
  private final c l;
  private final int m;
  private List n = new ArrayList();
  
  public l(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, com.google.android.gms.ads.internal.mediation.client.b paramb, c paramc, boolean paramBoolean1, boolean paramBoolean2, String paramString, long paramLong1, long paramLong2, boolean paramBoolean3)
  {
    this.i = paramContext;
    this.f = paramAdRequestInfoParcel;
    this.h = paramb;
    this.l = paramc;
    this.j = paramBoolean1;
    this.k = paramBoolean2;
    this.g = paramString;
    this.e = paramLong1;
    this.a = paramLong2;
    this.m = 2;
  }
  
  private final void a(v paramv)
  {
    com.google.android.gms.ads.internal.util.n.a.post(new n(this, paramv));
  }
  
  private final i b(List paramList)
  {
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.b)
        {
          paramList = new i(-1);
          return paramList;
        }
        ??? = paramList.iterator();
        if (((Iterator)???).hasNext()) {
          paramList = (v)((Iterator)???).next();
        }
      }
      try
      {
        i locali = (i)paramList.get();
        this.n.add(locali);
        if ((locali == null) || (locali.a != 0)) {
          continue;
        }
        a(paramList);
        return locali;
      }
      catch (InterruptedException paramList)
      {
        e.e("Exception while processing an adapter; continuing with other adapters", paramList);
        continue;
        a(null);
        return new i(1);
        paramList = finally;
        throw paramList;
      }
      catch (ExecutionException paramList)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  private final i c(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/google/android/gms/ads/internal/mediation/l:d	Ljava/lang/Object;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 41	com/google/android/gms/ads/internal/mediation/l:b	Z
    //   13: ifeq +17 -> 30
    //   16: new 96	com/google/android/gms/ads/internal/mediation/i
    //   19: dup
    //   20: iconst_m1
    //   21: invokespecial 99	com/google/android/gms/ads/internal/mediation/i:<init>	(I)V
    //   24: astore_1
    //   25: aload 8
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload 8
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield 59	com/google/android/gms/ads/internal/mediation/l:l	Lcom/google/android/gms/ads/internal/mediation/c;
    //   37: getfield 143	com/google/android/gms/ads/internal/mediation/c:i	J
    //   40: lstore 4
    //   42: lload 4
    //   44: ldc2_w 144
    //   47: lcmp
    //   48: ifeq +269 -> 317
    //   51: aload_1
    //   52: invokeinterface 105 1 0
    //   57: astore 13
    //   59: aconst_null
    //   60: astore 8
    //   62: aconst_null
    //   63: astore_1
    //   64: iconst_m1
    //   65: istore_2
    //   66: aload 13
    //   68: invokeinterface 111 1 0
    //   73: ifeq +225 -> 298
    //   76: aload 13
    //   78: invokeinterface 115 1 0
    //   83: checkcast 117	com/google/android/gms/ads/internal/util/a/v
    //   86: astore 12
    //   88: getstatic 151	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   91: getfield 154	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   94: invokeinterface 159 1 0
    //   99: lstore 6
    //   101: lload 4
    //   103: lconst_0
    //   104: lcmp
    //   105: ifne +13 -> 118
    //   108: aload 12
    //   110: invokeinterface 162 1 0
    //   115: ifne +168 -> 283
    //   118: aload 12
    //   120: lload 4
    //   122: getstatic 168	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   125: invokeinterface 171 4 0
    //   130: checkcast 96	com/google/android/gms/ads/internal/mediation/i
    //   133: astore 11
    //   135: aload_0
    //   136: getfield 51	com/google/android/gms/ads/internal/mediation/l:n	Ljava/util/List;
    //   139: aload 11
    //   141: invokeinterface 124 2 0
    //   146: pop
    //   147: aload 11
    //   149: ifnonnull +57 -> 206
    //   152: iload_2
    //   153: istore_3
    //   154: aload_1
    //   155: astore 10
    //   157: aload 8
    //   159: astore 9
    //   161: lload 4
    //   163: getstatic 151	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   166: getfield 154	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   169: invokeinterface 159 1 0
    //   174: lload 6
    //   176: lsub
    //   177: lsub
    //   178: lconst_0
    //   179: invokestatic 177	java/lang/Math:max	(JJ)J
    //   182: lstore 4
    //   184: aload 9
    //   186: astore_1
    //   187: aload 10
    //   189: astore 8
    //   191: iload_3
    //   192: istore_2
    //   193: aload 8
    //   195: astore 9
    //   197: aload_1
    //   198: astore 8
    //   200: aload 9
    //   202: astore_1
    //   203: goto -137 -> 66
    //   206: aload 8
    //   208: astore 9
    //   210: aload_1
    //   211: astore 10
    //   213: iload_2
    //   214: istore_3
    //   215: aload 11
    //   217: getfield 126	com/google/android/gms/ads/internal/mediation/i:a	I
    //   220: ifne -59 -> 161
    //   223: aload 11
    //   225: getfield 180	com/google/android/gms/ads/internal/mediation/i:f	Lcom/google/android/gms/ads/internal/mediation/client/k;
    //   228: astore 14
    //   230: aload 8
    //   232: astore 9
    //   234: aload_1
    //   235: astore 10
    //   237: iload_2
    //   238: istore_3
    //   239: aload 14
    //   241: ifnull -80 -> 161
    //   244: aload 8
    //   246: astore 9
    //   248: aload_1
    //   249: astore 10
    //   251: iload_2
    //   252: istore_3
    //   253: aload 14
    //   255: invokeinterface 185 1 0
    //   260: iload_2
    //   261: if_icmple -100 -> 161
    //   264: aload 14
    //   266: invokeinterface 185 1 0
    //   271: istore_3
    //   272: aload 11
    //   274: astore 9
    //   276: aload 12
    //   278: astore 10
    //   280: goto -119 -> 161
    //   283: aload 12
    //   285: invokeinterface 120 1 0
    //   290: checkcast 96	com/google/android/gms/ads/internal/mediation/i
    //   293: astore 11
    //   295: goto -160 -> 135
    //   298: aload_0
    //   299: aload_1
    //   300: invokespecial 128	com/google/android/gms/ads/internal/mediation/l:a	(Lcom/google/android/gms/ads/internal/util/a/v;)V
    //   303: aload 8
    //   305: ifnonnull +111 -> 416
    //   308: new 96	com/google/android/gms/ads/internal/mediation/i
    //   311: dup
    //   312: iconst_1
    //   313: invokespecial 99	com/google/android/gms/ads/internal/mediation/i:<init>	(I)V
    //   316: areturn
    //   317: ldc2_w 186
    //   320: lstore 4
    //   322: goto -271 -> 51
    //   325: astore_1
    //   326: aload 8
    //   328: monitorexit
    //   329: aload_1
    //   330: athrow
    //   331: astore 9
    //   333: ldc -126
    //   335: aload 9
    //   337: invokestatic 135	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   340: lload 4
    //   342: getstatic 151	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   345: getfield 154	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   348: invokeinterface 159 1 0
    //   353: lload 6
    //   355: lsub
    //   356: lsub
    //   357: lconst_0
    //   358: invokestatic 177	java/lang/Math:max	(JJ)J
    //   361: lstore 4
    //   363: aload_1
    //   364: astore 9
    //   366: aload 8
    //   368: astore_1
    //   369: aload 9
    //   371: astore 8
    //   373: goto -180 -> 193
    //   376: astore_1
    //   377: lload 4
    //   379: getstatic 151	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   382: getfield 154	com/google/android/gms/ads/internal/bt:l	Lcom/google/android/gms/common/util/b;
    //   385: invokeinterface 159 1 0
    //   390: lload 6
    //   392: lsub
    //   393: lsub
    //   394: lconst_0
    //   395: invokestatic 177	java/lang/Math:max	(JJ)J
    //   398: pop2
    //   399: aload_1
    //   400: athrow
    //   401: astore 9
    //   403: goto -70 -> 333
    //   406: astore 9
    //   408: goto -75 -> 333
    //   411: astore 9
    //   413: goto -80 -> 333
    //   416: aload 8
    //   418: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	l
    //   0	419	1	paramList	List
    //   65	197	2	i1	int
    //   153	119	3	i2	int
    //   40	338	4	l1	long
    //   99	292	6	l2	long
    //   4	413	8	localObject1	Object
    //   159	116	9	localObject2	Object
    //   331	5	9	localRemoteException	android.os.RemoteException
    //   364	6	9	localList	List
    //   401	1	9	localInterruptedException	InterruptedException
    //   406	1	9	localExecutionException	ExecutionException
    //   411	1	9	localTimeoutException	java.util.concurrent.TimeoutException
    //   155	124	10	localObject3	Object
    //   133	161	11	locali	i
    //   86	198	12	localv	v
    //   57	20	13	localIterator	Iterator
    //   228	37	14	localk	com.google.android.gms.ads.internal.mediation.client.k
    // Exception table:
    //   from	to	target	type
    //   9	28	325	finally
    //   30	33	325	finally
    //   326	329	325	finally
    //   108	118	331	android/os/RemoteException
    //   118	135	331	android/os/RemoteException
    //   135	147	331	android/os/RemoteException
    //   215	230	331	android/os/RemoteException
    //   253	272	331	android/os/RemoteException
    //   283	295	331	android/os/RemoteException
    //   108	118	376	finally
    //   118	135	376	finally
    //   135	147	376	finally
    //   215	230	376	finally
    //   253	272	376	finally
    //   283	295	376	finally
    //   333	340	376	finally
    //   108	118	401	java/lang/InterruptedException
    //   118	135	401	java/lang/InterruptedException
    //   135	147	401	java/lang/InterruptedException
    //   215	230	401	java/lang/InterruptedException
    //   253	272	401	java/lang/InterruptedException
    //   283	295	401	java/lang/InterruptedException
    //   108	118	406	java/util/concurrent/ExecutionException
    //   118	135	406	java/util/concurrent/ExecutionException
    //   135	147	406	java/util/concurrent/ExecutionException
    //   215	230	406	java/util/concurrent/ExecutionException
    //   253	272	406	java/util/concurrent/ExecutionException
    //   283	295	406	java/util/concurrent/ExecutionException
    //   108	118	411	java/util/concurrent/TimeoutException
    //   118	135	411	java/util/concurrent/TimeoutException
    //   135	147	411	java/util/concurrent/TimeoutException
    //   215	230	411	java/util/concurrent/TimeoutException
    //   253	272	411	java/util/concurrent/TimeoutException
    //   283	295	411	java/util/concurrent/TimeoutException
  }
  
  public final i a(List paramList)
  {
    e.b("Starting mediation.");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.f.c;
    Object localObject2 = new int[2];
    Object localObject3;
    if (((AdSizeParcel)localObject1).h != null)
    {
      localObject3 = bt.A.w;
      if (k.a(this.g, (int[])localObject2))
      {
        int i2 = localObject2[0];
        int i3 = localObject2[1];
        localObject3 = ((AdSizeParcel)localObject1).h;
        int i4 = localObject3.length;
        int i1 = 0;
        if (i1 < i4)
        {
          localObject2 = localObject3[i1];
          if (i2 != ((AdSizeParcel)localObject2).i) {}
          while (i3 != ((AdSizeParcel)localObject2).b)
          {
            i1 += 1;
            break;
          }
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      localObject2 = paramList.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (b)((Iterator)localObject2).next();
        paramList = String.valueOf(((b)localObject3).d);
        if (paramList.length() == 0) {}
        for (paramList = new String("Trying mediation network: ");; paramList = "Trying mediation network: ".concat(paramList))
        {
          e.d(paramList);
          paramList = ((b)localObject3).f.iterator();
          while (paramList.hasNext())
          {
            Object localObject4 = (String)paramList.next();
            Object localObject5 = this.i;
            com.google.android.gms.ads.internal.mediation.client.b localb = this.h;
            c localc = this.l;
            AdRequestInfoParcel localAdRequestInfoParcel = this.f;
            localObject4 = new f((Context)localObject5, (String)localObject4, localb, localc, (b)localObject3, localAdRequestInfoParcel.b, (AdSizeParcel)localObject1, localAdRequestInfoParcel.ae, this.j, this.k, localAdRequestInfoParcel.G, localAdRequestInfoParcel.J, localAdRequestInfoParcel.I, localAdRequestInfoParcel.q);
            localObject5 = com.google.android.gms.ads.internal.util.l.a(new m(this, (f)localObject4));
            this.c.put(localObject5, localObject4);
            localArrayList.add(localObject5);
          }
          break;
        }
      }
      switch (this.m)
      {
      default: 
        return b(localArrayList);
      }
      return c(localArrayList);
      continue;
    }
  }
  
  public final void a()
  {
    synchronized (this.d)
    {
      this.b = true;
      Iterator localIterator = this.c.values().iterator();
      if (localIterator.hasNext()) {
        ((f)localIterator.next()).a();
      }
    }
  }
  
  public final List b()
  {
    return this.n;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */