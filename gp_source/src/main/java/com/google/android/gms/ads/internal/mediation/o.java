package com.google.android.gms.ads.internal.mediation;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.g.j;
import com.google.android.gms.ads.internal.g.l;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class o
  implements a
{
  private final AdRequestInfoParcel a;
  private final String b;
  private final com.google.android.gms.ads.internal.mediation.client.b c;
  private final Context d;
  private final long e;
  private boolean f = false;
  private final boolean g;
  private final boolean h;
  private f i;
  private final Object j = new Object();
  private final c k;
  private final long l;
  private final l m;
  private List n = new ArrayList();
  
  public o(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, com.google.android.gms.ads.internal.mediation.client.b paramb, c paramc, boolean paramBoolean1, boolean paramBoolean2, String paramString, long paramLong1, long paramLong2, l paraml, boolean paramBoolean3)
  {
    this.d = paramContext;
    this.a = paramAdRequestInfoParcel;
    this.c = paramb;
    this.k = paramc;
    this.g = paramBoolean1;
    this.h = paramBoolean2;
    this.b = paramString;
    this.l = paramLong1;
    this.e = paramLong2;
    this.m = paraml;
  }
  
  public final i a(List arg1)
  {
    e.b("Starting mediation.");
    ArrayList localArrayList = new ArrayList();
    j localj1 = this.m.a();
    Object localObject1 = this.a.c;
    Object localObject3 = new int[2];
    Object localObject4;
    int i2;
    int i1;
    if (((AdSizeParcel)localObject1).h != null)
    {
      localObject4 = bt.A.w;
      if (k.a(this.b, (int[])localObject3))
      {
        i2 = localObject3[0];
        int i3 = localObject3[1];
        localObject4 = ((AdSizeParcel)localObject1).h;
        int i4 = localObject4.length;
        i1 = 0;
        if (i1 < i4)
        {
          localObject3 = localObject4[i1];
          if (i2 != ((AdSizeParcel)localObject3).i) {}
          while (i3 != ((AdSizeParcel)localObject3).b)
          {
            i1 += 1;
            break;
          }
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      localObject3 = ???.iterator();
      i1 = 1;
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (b)((Iterator)localObject3).next();
        ??? = String.valueOf(((b)localObject4).d);
        if (???.length() == 0) {}
        for (??? = new String("Trying mediation network: ");; ??? = "Trying mediation network: ".concat(???))
        {
          e.d(???);
          Iterator localIterator = ((b)localObject4).f.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            j localj2 = this.m.a();
            synchronized (this.j)
            {
              if (!this.f)
              {
                Context localContext = this.d;
                com.google.android.gms.ads.internal.mediation.client.b localb = this.c;
                c localc = this.k;
                AdRequestInfoParcel localAdRequestInfoParcel = this.a;
                this.i = new f(localContext, str, localb, localc, (b)localObject4, localAdRequestInfoParcel.b, (AdSizeParcel)localObject1, localAdRequestInfoParcel.ae, this.g, this.h, localAdRequestInfoParcel.G, localAdRequestInfoParcel.J, localAdRequestInfoParcel.I, localAdRequestInfoParcel.q);
                ??? = this.i.a(this.l, this.e);
                this.n.add(???);
                i2 = ???.a;
                if (i2 == 0)
                {
                  e.b("Adapter succeeded.");
                  this.m.a("mediation_network_succeed", str);
                  if (!localArrayList.isEmpty()) {
                    this.m.a("mediation_networks_fail", TextUtils.join(",", localArrayList));
                  }
                  this.m.a(localj2, new String[] { "mls" });
                  this.m.a(localj1, new String[] { "ttm" });
                  return (i)???;
                }
                localArrayList.add(str);
                this.m.a(localj2, new String[] { "mlf" });
                i1 = i2;
                if (???.c != null)
                {
                  com.google.android.gms.ads.internal.util.n.a.post(new p(???));
                  i1 = i2;
                }
              }
              else
              {
                localObject1 = new i(-1);
                return (i)localObject1;
              }
            }
          }
          break;
        }
      }
      if (!localArrayList.isEmpty()) {
        this.m.a("mediation_networks_fail", TextUtils.join(",", localArrayList));
      }
      if (((Boolean)com.google.android.gms.ads.internal.f.n.bt.a()).booleanValue()) {
        return new i(i1);
      }
      return new i(1);
      continue;
    }
  }
  
  public final void a()
  {
    synchronized (this.j)
    {
      this.f = true;
      f localf = this.i;
      if (localf == null) {
        return;
      }
      localf.a();
    }
  }
  
  public final List b()
  {
    return this.n;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */