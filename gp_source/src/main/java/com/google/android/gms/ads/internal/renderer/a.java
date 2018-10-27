package com.google.android.gms.ads.internal.renderer;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.ag;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.ads.internal.util.v;
import com.google.android.gms.ads.internal.v.b;
import com.google.android.gms.ads.internal.webview.ap;
import com.google.android.gms.ads.internal.webview.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public abstract class a
  implements ag, ap
{
  public AdResponseParcel a;
  public final i b;
  public final Context c;
  public AtomicBoolean d;
  private final f e;
  private final b f;
  private Runnable g;
  
  protected a(Context paramContext, b paramb, i parami, f paramf)
  {
    new Object();
    this.d = new AtomicBoolean(true);
    this.c = paramContext;
    this.f = paramb;
    this.a = this.f.e;
    this.b = parami;
    this.e = paramf;
  }
  
  protected abstract void a();
  
  protected void a(int paramInt)
  {
    if (paramInt != -2) {
      this.a = new AdResponseParcel(paramInt, this.a.M);
    }
    this.b.e();
    f localf = this.e;
    Object localObject2 = this.f;
    Object localObject1 = ((b)localObject2).d;
    AdRequestParcel localAdRequestParcel = ((AdRequestInfoParcel)localObject1).b;
    i locali = this.b;
    Object localObject3 = this.a;
    List localList1 = ((AdResponseParcel)localObject3).g;
    List localList2 = ((AdResponseParcel)localObject3).q;
    List localList3 = ((AdResponseParcel)localObject3).F;
    int i = ((AdResponseParcel)localObject3).K;
    long l1 = ((AdResponseParcel)localObject3).M;
    localObject1 = ((AdRequestInfoParcel)localObject1).X;
    boolean bool1 = ((AdResponseParcel)localObject3).y;
    long l2 = ((AdResponseParcel)localObject3).G;
    AdSizeParcel localAdSizeParcel = ((b)localObject2).g;
    l2 = ((AdResponseParcel)localObject3).r;
    l2 = ((b)localObject2).f;
    long l3 = ((AdResponseParcel)localObject3).o;
    String str1 = ((AdResponseParcel)localObject3).k;
    JSONObject localJSONObject = ((b)localObject2).a;
    RewardItemParcel localRewardItemParcel = ((AdResponseParcel)localObject3).P;
    List localList4 = ((AdResponseParcel)localObject3).Q;
    List localList5 = ((AdResponseParcel)localObject3).O;
    boolean bool2 = ((AdResponseParcel)localObject3).E;
    Object localObject4 = ((AdResponseParcel)localObject3).d;
    localObject4 = ((AdResponseParcel)localObject3).H;
    String str2 = ((AdResponseParcel)localObject3).l;
    com.google.android.gms.ads.internal.d.a locala = ((b)localObject2).c;
    AdResponseParcel localAdResponseParcel = ((b)localObject2).e;
    boolean bool3 = localAdResponseParcel.u;
    boolean bool4 = ((b)localObject2).j;
    boolean bool5 = localAdResponseParcel.C;
    localObject2 = ((AdResponseParcel)localObject3).m;
    boolean bool6 = localAdResponseParcel.t;
    localObject3 = localAdResponseParcel.J;
    localf.b(new com.google.android.gms.ads.internal.v.a(localAdRequestParcel, locali, localList1, paramInt, localList2, localList3, i, l1, (String)localObject1, bool1, null, null, null, null, null, localAdSizeParcel, l2, l3, str1, localJSONObject, null, localRewardItemParcel, localList4, localList5, bool2, null, (List)localObject4, str2, locala, bool3, bool4, bool5, (List)localObject2, bool6, localAdResponseParcel.S));
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = 0;
    e.b("WebView finished loading.");
    if (this.d.getAndSet(false)) {
      if (paramBoolean) {
        break label38;
      }
    }
    for (;;)
    {
      a(i);
      n.a.removeCallbacks(this.g);
      return;
      label38:
      i = -2;
    }
  }
  
  public void b()
  {
    if (this.d.getAndSet(false))
    {
      this.b.stopLoading();
      v localv = bt.A.g;
      v.a(this.b);
      a(-1);
      n.a.removeCallbacks(this.g);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/renderer/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */