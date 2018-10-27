package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.gmsg.HttpClient;
import com.google.android.gms.ads.internal.gmsg.ad;
import com.google.android.gms.ads.internal.js.y;
import com.google.android.gms.ads.internal.util.a.af;
import com.google.android.gms.ads.internal.util.e;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class al
  extends com.google.android.gms.ads.internal.util.a
{
  public static ad c = null;
  public static y d;
  private static final long e = TimeUnit.SECONDS.toMillis(10L);
  private static HttpClient m;
  private static boolean n;
  private static com.google.android.gms.ads.internal.gmsg.u o = null;
  private static final Object p = new Object();
  public final b a;
  public com.google.android.gms.ads.internal.js.al b;
  private final Object f = new Object();
  private com.google.android.gms.ads.internal.d.h g;
  private final Context h;
  private final u i;
  
  static
  {
    n = false;
    d = null;
    m = null;
  }
  
  public al(Context paramContext, u paramu, b arg3, com.google.android.gms.ads.internal.d.h paramh)
  {
    super((byte)0);
    this.a = ???;
    this.h = paramContext;
    this.i = paramu;
    this.g = paramh;
    synchronized (p)
    {
      if (!n)
      {
        c = new ad();
        m = new HttpClient(paramContext.getApplicationContext(), paramu.Y);
        o = new at();
        d = new y(this.h.getApplicationContext(), this.i.Y, (String)com.google.android.gms.ads.internal.f.n.bE.a(), new as(), new ar());
        n = true;
      }
      return;
    }
  }
  
  private final AdResponseParcel a(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    Object localObject = bt.A.e;
    localObject = com.google.android.gms.ads.internal.util.n.a();
    JSONObject localJSONObject = a(paramAdRequestInfoParcel, (String)localObject);
    if (localJSONObject == null) {
      paramAdRequestInfoParcel = new AdResponseParcel(0);
    }
    for (;;)
    {
      return paramAdRequestInfoParcel;
      long l1 = bt.A.l.b();
      ad localad = c;
      af localaf = new af();
      localad.a.put(localObject, localaf);
      com.google.android.gms.ads.internal.util.client.a.g.post(new an(this, localJSONObject, (String)localObject));
      long l2 = e;
      long l3 = bt.A.l.b();
      try
      {
        localObject = (JSONObject)localaf.get(l2 - (l3 - l1), TimeUnit.MILLISECONDS);
        if (localObject != null)
        {
          localObject = com.google.android.gms.ads.internal.request.a.h.a(this.h, paramAdRequestInfoParcel, ((JSONObject)localObject).toString());
          paramAdRequestInfoParcel = (AdRequestInfoParcel)localObject;
          if (((AdResponseParcel)localObject).n == -3) {
            continue;
          }
          paramAdRequestInfoParcel = (AdRequestInfoParcel)localObject;
          if (!TextUtils.isEmpty(((AdResponseParcel)localObject).f)) {
            continue;
          }
          return new AdResponseParcel(3);
        }
        return new AdResponseParcel(-1);
      }
      catch (InterruptedException paramAdRequestInfoParcel)
      {
        return new AdResponseParcel(-1);
      }
      catch (TimeoutException paramAdRequestInfoParcel)
      {
        return new AdResponseParcel(2);
      }
      catch (ExecutionException paramAdRequestInfoParcel)
      {
        return new AdResponseParcel(0);
      }
      catch (CancellationException paramAdRequestInfoParcel)
      {
        for (;;) {}
      }
    }
  }
  
  private final JSONObject a(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  protected static void a(com.google.android.gms.ads.internal.js.n paramn)
  {
    paramn.a("/loadAd", c);
    paramn.a("/fetchHttpRequest", m);
    paramn.a("/invalidRequest", o);
  }
  
  protected static void b(com.google.android.gms.ads.internal.js.n paramn)
  {
    paramn.b("/loadAd", c);
    paramn.b("/fetchHttpRequest", m);
    paramn.b("/invalidRequest", o);
  }
  
  public final void a()
  {
    e.b("SdkLessAdLoaderBackgroundTask started.");
    Object localObject1 = bt.A.B;
    localObject1 = this.i;
    Object localObject2 = bt.A.B;
    localObject2 = bt.A.B;
    localObject2 = bt.A.B;
    localObject1 = new AdRequestInfoParcel((u)localObject1, -1L, null, null, null, null);
    localObject2 = a((AdRequestInfoParcel)localObject1);
    int j = ((AdResponseParcel)localObject2).n;
    if (j == -2) {}
    for (;;)
    {
      if (!TextUtils.isEmpty(null)) {
        com.google.android.gms.ads.internal.s.b localb = bt.A.B;
      }
      do
      {
        long l = bt.A.l.b();
        localObject1 = new com.google.android.gms.ads.internal.v.b((AdRequestInfoParcel)localObject1, (AdResponseParcel)localObject2, ((AdResponseParcel)localObject2).n, l, ((AdResponseParcel)localObject2).o, this.g);
        com.google.android.gms.ads.internal.util.client.a.g.post(new am(this, (com.google.android.gms.ads.internal.v.b)localObject1));
        return;
      } while (j != 3);
    }
  }
  
  public final void be_()
  {
    synchronized (this.f)
    {
      com.google.android.gms.ads.internal.util.client.a.g.post(new aq(this));
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */