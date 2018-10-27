package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.IconAdOptionsParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.ar;
import com.google.android.gms.ads.internal.client.ba;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.client.z;
import com.google.android.gms.ads.internal.f.k;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.a.aj;
import com.google.android.gms.ads.internal.formats.a.as;
import com.google.android.gms.ads.internal.instream.InstreamAdConfigurationParcel;
import com.google.android.gms.ads.internal.reward.client.d;
import com.google.android.gms.ads.internal.reward.client.l;
import com.google.android.gms.ads.internal.util.bm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.v.f;
import com.google.android.gms.ads.internal.v.m;
import com.google.android.gms.ads.internal.webview.ao;
import com.google.android.gms.ads.internal.webview.i;
import com.google.android.gms.ads.internal.zxxz.aa;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@com.google.android.gms.ads.internal.q.a.a
public final class bu
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  public aj A;
  public android.support.v4.g.v B;
  public com.google.android.gms.ads.internal.h.a.e C;
  public android.support.v4.g.v D;
  public as E;
  public com.google.android.gms.ads.internal.formats.a.au F;
  public com.google.android.gms.ads.internal.v.b G;
  public int H = 0;
  public d I;
  public String J;
  public l K;
  public final String L;
  public m M = null;
  public final aa N;
  public boolean O = false;
  public final VersionInfoParcel P;
  public VideoOptionsParcel Q;
  private int R = -1;
  private int S = -1;
  private bm T;
  public w a;
  public bv b;
  public z c;
  public com.google.android.gms.ads.internal.util.a d;
  public ar e;
  public com.google.android.gms.ads.internal.util.ag f;
  public AdSizeParcel g;
  public com.google.android.gms.ads.internal.v.a h;
  public com.google.android.gms.ads.internal.v.c i;
  public String j;
  public List k;
  public com.google.android.gms.ads.internal.client.au l;
  public final Context m;
  public ba n;
  public View o = null;
  public IconAdOptionsParcel p;
  public InstreamAdConfigurationParcel q;
  public com.google.android.gms.ads.internal.instream.a.e r;
  public boolean s = true;
  public boolean t = false;
  public boolean u = true;
  public HashSet v = null;
  public String w;
  public NativeAdOptionsParcel x;
  public List y;
  public com.google.android.gms.ads.internal.formats.a.ag z;
  
  public bu(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, VersionInfoParcel paramVersionInfoParcel)
  {
    this(paramContext, paramAdSizeParcel, paramString, paramVersionInfoParcel, (byte)0);
  }
  
  private bu(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, VersionInfoParcel paramVersionInfoParcel, byte paramByte)
  {
    n.a(paramContext);
    List localList;
    com.google.android.gms.ads.internal.g.b localb;
    if (bt.A.i.a() != null)
    {
      localList = n.b();
      paramByte = paramVersionInfoParcel.b;
      if (paramByte != 0) {
        localList.add(Integer.toString(paramByte));
      }
      localb = bt.A.i.a();
      if (localList != null) {
        break label264;
      }
    }
    for (;;)
    {
      this.L = UUID.randomUUID().toString();
      if ((paramAdSizeParcel.e) || (paramAdSizeParcel.f)) {
        this.b = null;
      }
      for (;;)
      {
        this.g = paramAdSizeParcel;
        this.j = paramString;
        this.m = paramContext;
        this.P = paramVersionInfoParcel;
        this.N = new aa(new af(this));
        this.T = new bm(200L);
        this.D = new android.support.v4.g.v();
        return;
        this.b = new bv(paramContext, paramString, paramVersionInfoParcel.a, this, this);
        this.b.setMinimumWidth(paramAdSizeParcel.j);
        this.b.setMinimumHeight(paramAdSizeParcel.c);
        this.b.setVisibility(4);
      }
      label264:
      if (!localList.isEmpty()) {
        localb.g.put("e", TextUtils.join(",", localList));
      }
    }
  }
  
  private final void b(boolean paramBoolean)
  {
    Object localObject1;
    if (this.b != null)
    {
      localObject1 = this.h;
      if (localObject1 != null)
      {
        localObject1 = ((com.google.android.gms.ads.internal.v.a)localObject1).g;
        if ((localObject1 != null) && (((i)localObject1).getAdWebViewClient() != null)) {
          if (paramBoolean) {
            break label274;
          }
        }
      }
    }
    label274:
    while (this.T.a())
    {
      Object localObject2;
      if (this.h.g.getAdWebViewClient().b())
      {
        localObject1 = new int[2];
        this.b.getLocationOnScreen((int[])localObject1);
        localObject2 = u.h.a;
        int i1 = com.google.android.gms.ads.internal.util.client.a.b(this.m, localObject1[0]);
        localObject2 = u.h.a;
        int i2 = com.google.android.gms.ads.internal.util.client.a.b(this.m, localObject1[1]);
        if ((i1 != this.R) || (i2 != this.S))
        {
          this.R = i1;
          this.S = i2;
          this.h.g.getAdWebViewClient().a(this.R, this.S, paramBoolean ^ true);
        }
      }
      localObject1 = this.b;
      if (localObject1 != null)
      {
        localObject1 = ((bv)localObject1).getRootView().findViewById(16908290);
        if (localObject1 != null)
        {
          localObject2 = new Rect();
          Rect localRect = new Rect();
          this.b.getGlobalVisibleRect((Rect)localObject2);
          ((View)localObject1).getGlobalVisibleRect(localRect);
          if (((Rect)localObject2).top != localRect.top) {
            this.u = false;
          }
          if (((Rect)localObject2).bottom != localRect.bottom) {
            this.s = false;
          }
        }
      }
      return;
    }
  }
  
  public final void a()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((com.google.android.gms.ads.internal.v.a)localObject).g;
      if (localObject != null) {
        ((i)localObject).destroy();
      }
    }
  }
  
  final void a(View paramView)
  {
    Object localObject = n.bN;
    if (((Boolean)u.h.e.a((com.google.android.gms.ads.internal.f.c)localObject)).booleanValue())
    {
      localObject = this.N.e;
      if (localObject != null) {
        ((com.google.android.gms.ads.internal.zxxz.v)localObject).a(paramView);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.H != 0) {}
    for (;;)
    {
      Object localObject = this.d;
      if (localObject != null) {
        ((com.google.android.gms.ads.internal.util.a)localObject).b();
      }
      localObject = this.f;
      if (localObject != null) {
        ((com.google.android.gms.ads.internal.util.ag)localObject).b();
      }
      if (paramBoolean) {
        this.h = null;
      }
      return;
      localObject = this.h;
      if (localObject != null)
      {
        localObject = ((com.google.android.gms.ads.internal.v.a)localObject).g;
        if (localObject != null) {
          ((i)localObject).stopLoading();
        }
      }
    }
  }
  
  public final void b()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((com.google.android.gms.ads.internal.v.a)localObject).B;
      if (localObject == null) {}
    }
    try
    {
      ((com.google.android.gms.ads.internal.mediation.client.e)localObject).c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.e.e("Could not destroy mediation adapter.");
    }
  }
  
  public final boolean c()
  {
    return this.H == 0;
  }
  
  public final boolean d()
  {
    boolean bool = true;
    if (this.H != 1) {
      bool = false;
    }
    return bool;
  }
  
  public final void onGlobalLayout()
  {
    b(false);
  }
  
  public final void onScrollChanged()
  {
    b(true);
    this.t = true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */