package com.google.android.gms.ads.internal.renderer;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.mediation.o;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class k
  extends AdRendererBackgroundTask
{
  public final com.google.android.gms.ads.internal.webview.i g;
  public boolean h;
  public com.google.android.gms.ads.internal.mediation.i i;
  private com.google.android.gms.ads.internal.mediation.client.b m;
  private com.google.android.gms.ads.internal.mediation.a n;
  private com.google.android.gms.ads.internal.mediation.c o;
  private final com.google.android.gms.ads.internal.g.l p;
  
  k(Context paramContext, com.google.android.gms.ads.internal.v.b paramb, com.google.android.gms.ads.internal.mediation.client.b paramb1, f paramf, com.google.android.gms.ads.internal.g.l paraml, com.google.android.gms.ads.internal.webview.i parami)
  {
    super(paramContext, paramb, paramf);
    this.m = paramb1;
    this.o = paramb.i;
    this.p = paraml;
    this.g = parami;
  }
  
  protected final com.google.android.gms.ads.internal.v.a a(int paramInt)
  {
    Object localObject2 = this.f.d;
    AdRequestParcel localAdRequestParcel = ((AdRequestInfoParcel)localObject2).b;
    com.google.android.gms.ads.internal.webview.i locali = this.g;
    Object localObject1 = this.b;
    List localList1 = ((AdResponseParcel)localObject1).g;
    List localList2 = ((AdResponseParcel)localObject1).q;
    List localList3 = ((AdResponseParcel)localObject1).F;
    int k = ((AdResponseParcel)localObject1).K;
    long l1 = ((AdResponseParcel)localObject1).M;
    String str2 = ((AdRequestInfoParcel)localObject2).X;
    boolean bool2 = ((AdResponseParcel)localObject1).y;
    localObject1 = this.i;
    if (localObject1 != null) {}
    for (localObject2 = ((com.google.android.gms.ads.internal.mediation.i)localObject1).b;; localObject2 = null)
    {
      if (localObject1 != null) {}
      for (com.google.android.gms.ads.internal.mediation.client.e locale = ((com.google.android.gms.ads.internal.mediation.i)localObject1).c;; locale = null)
      {
        if (localObject1 == null) {}
        for (String str1 = AdMobAdapter.class.getName();; str1 = ((com.google.android.gms.ads.internal.mediation.i)localObject1).d)
        {
          com.google.android.gms.ads.internal.mediation.c localc = this.o;
          localObject1 = this.i;
          if (localObject1 != null) {}
          for (com.google.android.gms.ads.internal.mediation.e locale1 = ((com.google.android.gms.ads.internal.mediation.i)localObject1).e;; locale1 = null)
          {
            localObject1 = this.b;
            long l2 = ((AdResponseParcel)localObject1).G;
            Object localObject3 = this.f;
            AdSizeParcel localAdSizeParcel = ((com.google.android.gms.ads.internal.v.b)localObject3).g;
            l2 = ((AdResponseParcel)localObject1).r;
            l2 = ((com.google.android.gms.ads.internal.v.b)localObject3).f;
            long l3 = ((AdResponseParcel)localObject1).o;
            String str3 = ((AdResponseParcel)localObject1).k;
            localObject3 = ((com.google.android.gms.ads.internal.v.b)localObject3).a;
            RewardItemParcel localRewardItemParcel = ((AdResponseParcel)localObject1).P;
            List localList4 = ((AdResponseParcel)localObject1).Q;
            List localList5 = ((AdResponseParcel)localObject1).O;
            if (localc != null) {}
            for (boolean bool1 = localc.u;; bool1 = false)
            {
              localObject1 = ((AdResponseParcel)localObject1).d;
              localObject1 = this.n;
              if (localObject1 != null)
              {
                localObject1 = ((com.google.android.gms.ads.internal.mediation.a)localObject1).b();
                if (localObject1 == null) {
                  localObject1 = "".toString();
                }
              }
              for (;;)
              {
                Object localObject4 = this.b;
                Object localObject5 = ((AdResponseParcel)localObject4).H;
                Object localObject6 = ((AdResponseParcel)localObject4).l;
                Object localObject7 = this.f;
                com.google.android.gms.ads.internal.d.a locala = ((com.google.android.gms.ads.internal.v.b)localObject7).c;
                boolean bool3 = ((AdResponseParcel)localObject4).u;
                boolean bool4 = ((com.google.android.gms.ads.internal.v.b)localObject7).j;
                boolean bool5 = ((AdResponseParcel)localObject4).C;
                localObject7 = ((AdResponseParcel)localObject4).m;
                boolean bool6 = ((AdResponseParcel)localObject4).t;
                String str4 = ((AdResponseParcel)localObject4).J;
                return new com.google.android.gms.ads.internal.v.a(localAdRequestParcel, locali, localList1, paramInt, localList2, localList3, k, l1, str2, bool2, (com.google.android.gms.ads.internal.mediation.b)localObject2, locale, str1, localc, locale1, localAdSizeParcel, l2, l3, str3, (JSONObject)localObject3, null, localRewardItemParcel, localList4, localList5, bool1, (String)localObject1, (List)localObject5, (String)localObject6, locala, bool3, bool4, bool5, (List)localObject7, bool6, ((AdResponseParcel)localObject4).S);
                localObject4 = ((List)localObject1).iterator();
                localObject1 = "";
                while (((Iterator)localObject4).hasNext())
                {
                  localObject5 = (com.google.android.gms.ads.internal.mediation.i)((Iterator)localObject4).next();
                  if (localObject5 != null)
                  {
                    localObject6 = ((com.google.android.gms.ads.internal.mediation.i)localObject5).b;
                    if ((localObject6 != null) && (!TextUtils.isEmpty(((com.google.android.gms.ads.internal.mediation.b)localObject6).g)))
                    {
                      localObject1 = String.valueOf(localObject1);
                      localObject6 = ((com.google.android.gms.ads.internal.mediation.i)localObject5).b.g;
                      int j;
                      switch (((com.google.android.gms.ads.internal.mediation.i)localObject5).a)
                      {
                      case 2: 
                      default: 
                        j = 6;
                      }
                      for (;;)
                      {
                        long l4 = ((com.google.android.gms.ads.internal.mediation.i)localObject5).g;
                        localObject5 = new StringBuilder(String.valueOf(localObject6).length() + 33);
                        ((StringBuilder)localObject5).append((String)localObject6);
                        ((StringBuilder)localObject5).append(".");
                        ((StringBuilder)localObject5).append(j);
                        ((StringBuilder)localObject5).append(".");
                        ((StringBuilder)localObject5).append(l4);
                        localObject5 = ((StringBuilder)localObject5).toString();
                        localObject6 = new StringBuilder(String.valueOf(localObject1).length() + 1 + String.valueOf(localObject5).length());
                        ((StringBuilder)localObject6).append((String)localObject1);
                        ((StringBuilder)localObject6).append((String)localObject5);
                        ((StringBuilder)localObject6).append("_");
                        localObject1 = ((StringBuilder)localObject6).toString();
                        break;
                        j = 4;
                        continue;
                        j = 5;
                        continue;
                        j = 3;
                        continue;
                        j = 2;
                        continue;
                        j = 1;
                        continue;
                        j = 0;
                      }
                    }
                  }
                }
                localObject1 = ((String)localObject1).substring(0, Math.max(0, ((String)localObject1).length() - 1));
                continue;
                localObject1 = null;
              }
            }
          }
        }
      }
    }
  }
  
  protected final void a(long paramLong)
  {
    synchronized (this.c)
    {
      ??? = this.o;
      if (((com.google.android.gms.ads.internal.mediation.c)???).h != -1)
      {
        localContext = this.d;
        localAdRequestInfoParcel = this.f.d;
        localb = this.m;
        localAdResponseParcel = this.b;
        ??? = new com.google.android.gms.ads.internal.mediation.l(localContext, localAdRequestInfoParcel, localb, (com.google.android.gms.ads.internal.mediation.c)???, localAdResponseParcel.z, localAdResponseParcel.A, localAdResponseParcel.c, paramLong, ((Long)com.google.android.gms.ads.internal.f.n.bq.a()).longValue(), this.f.j);
        this.n = ((com.google.android.gms.ads.internal.mediation.a)???);
        ??? = new ArrayList(this.o.a);
        ??? = this.f.d.b.n;
        if (??? != null)
        {
          ??? = ((Bundle)???).getBundle("com.google.ads.mediation.admob.AdMobAdapter");
          if ((??? != null) && (((Bundle)???).getBoolean("_skipMediation")))
          {
            ??? = ((List)???).listIterator();
            while (((ListIterator)???).hasNext()) {
              if (!((com.google.android.gms.ads.internal.mediation.b)((ListIterator)???).next()).f.contains("com.google.ads.mediation.admob.AdMobAdapter")) {
                ((ListIterator)???).remove();
              }
            }
          }
        }
        this.i = this.n.a((List)???);
        ??? = this.i;
        int j = ((com.google.android.gms.ads.internal.mediation.i)???).a;
        switch (j)
        {
        default: 
          ??? = new StringBuilder(40);
          ((StringBuilder)???).append("Unexpected mediation result: ");
          ((StringBuilder)???).append(j);
          throw new AdRendererBackgroundTask.AdRendererException(((StringBuilder)???).toString(), 0);
        case 1: 
          throw new AdRendererBackgroundTask.AdRendererException("No fill from any mediation ad networks.", 3);
        }
        ??? = ((com.google.android.gms.ads.internal.mediation.i)???).b;
        if ((??? != null) && (((com.google.android.gms.ads.internal.mediation.b)???).j != null))
        {
          ??? = new CountDownLatch(1);
          com.google.android.gms.ads.internal.util.n.a.post(new l(this, (CountDownLatch)???));
        }
      }
      try
      {
        ((CountDownLatch)???).await(10L, TimeUnit.SECONDS);
        synchronized (this.c)
        {
          if (!this.h) {
            break label594;
          }
          if (this.g.g()) {
            throw new AdRendererBackgroundTask.AdRendererException("Assets not loaded, web view is destroyed", 0);
          }
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        String str = String.valueOf(localInterruptedException);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 38);
        localStringBuilder.append("Interrupted while waiting for latch : ");
        localStringBuilder.append(str);
        throw new AdRendererBackgroundTask.AdRendererException(localStringBuilder.toString(), 0);
      }
      Context localContext = this.d;
      AdRequestInfoParcel localAdRequestInfoParcel = this.f.d;
      com.google.android.gms.ads.internal.mediation.client.b localb = this.m;
      AdResponseParcel localAdResponseParcel = this.b;
      ??? = new o(localContext, localAdRequestInfoParcel, localb, (com.google.android.gms.ads.internal.mediation.c)???, localAdResponseParcel.z, localAdResponseParcel.A, localAdResponseParcel.c, paramLong, ((Long)com.google.android.gms.ads.internal.f.n.bq.a()).longValue(), this.p, this.f.j);
    }
    label594:
    throw new AdRendererBackgroundTask.AdRendererException("View could not be prepared", 0);
  }
  
  public final void be_()
  {
    synchronized (this.c)
    {
      super.be_();
      com.google.android.gms.ads.internal.mediation.a locala = this.n;
      if (locala == null) {
        return;
      }
      locala.a();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/renderer/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */