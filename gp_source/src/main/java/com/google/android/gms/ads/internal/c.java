package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.IconAdOptionsParcel;
import com.google.android.gms.ads.internal.client.ba;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.a.ac;
import com.google.android.gms.ads.internal.formats.a.am;
import com.google.android.gms.ads.internal.request.AdLoaderBackgroundTask;
import com.google.android.gms.ads.internal.request.al;
import com.google.android.gms.ads.internal.util.a.aa;
import com.google.android.gms.ads.internal.util.af;
import com.google.android.gms.ads.internal.util.ao;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.v.m;
import com.google.android.gms.ads.internal.w.b.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public abstract class c
  extends a
  implements bm, com.google.android.gms.ads.internal.mediation.d, com.google.android.gms.ads.internal.overlay.k
{
  public final com.google.android.gms.ads.internal.mediation.client.b j;
  private transient boolean k;
  
  public c(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, com.google.android.gms.ads.internal.mediation.client.b paramb, VersionInfoParcel paramVersionInfoParcel, u paramu)
  {
    this(new bu(paramContext, paramAdSizeParcel, paramString, paramVersionInfoParcel), paramb, paramu);
  }
  
  private c(bu parambu, com.google.android.gms.ads.internal.mediation.client.b paramb, u paramu)
  {
    super(parambu, paramu);
    this.j = paramb;
    this.k = false;
  }
  
  private final com.google.android.gms.ads.internal.request.u a(AdRequestParcel paramAdRequestParcel, Bundle paramBundle, com.google.android.gms.ads.internal.v.e parame, int paramInt)
  {
    ApplicationInfo localApplicationInfo = this.g.m.getApplicationInfo();
    try
    {
      localObject1 = this.g.m;
      localPackageInfo = com.google.android.gms.common.b.c.a.a((Context)localObject1).a(localApplicationInfo.packageName, 0);
      localObject1 = this.g.m.getResources().getDisplayMetrics();
      localObject2 = this.g.b;
      if (localObject2 != null) {
        if (((bv)localObject2).getParent() != null)
        {
          localObject2 = new int[2];
          this.g.b.getLocationOnScreen((int[])localObject2);
          m = localObject2[0];
          n = localObject2[1];
          i1 = this.g.b.getWidth();
          i2 = this.g.b.getHeight();
          if (this.g.b.isShown()) {
            if (m + i1 > 0) {
              if (n + i2 > 0) {
                if (m <= ((DisplayMetrics)localObject1).widthPixels) {
                  if (n <= ((DisplayMetrics)localObject1).heightPixels)
                  {
                    i = 1;
                    localObject2 = new Bundle(5);
                    ((Bundle)localObject2).putInt("x", m);
                    ((Bundle)localObject2).putInt("y", n);
                    ((Bundle)localObject2).putInt("width", i1);
                    ((Bundle)localObject2).putInt("height", i2);
                    ((Bundle)localObject2).putInt("visible", i);
                    this.g.i = bt.A.i.i.a(bt.A.l, this.g.j);
                    this.g.i.a(paramAdRequestParcel);
                    localObject3 = bt.A.e;
                    localObject3 = this.g;
                    str1 = com.google.android.gms.ads.internal.util.n.a(((bu)localObject3).m, ((bu)localObject3).b, ((bu)localObject3).g);
                    localObject3 = this.g.n;
                    if (localObject3 == null) {}
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        for (;;)
        {
          Object localObject1;
          int m;
          int n;
          int i1;
          int i2;
          Object localObject3;
          String str1;
          for (l = ((ba)localObject3).a();; l = 0L)
          {
            String str2 = UUID.randomUUID().toString();
            Bundle localBundle1 = bt.A.i.i.a(this.g.m, this);
            ArrayList localArrayList1 = new ArrayList();
            ArrayList localArrayList2 = new ArrayList();
            i = 0;
            if (i < this.g.D.size())
            {
              localObject3 = (String)this.g.D.b(i);
              localArrayList1.add(localObject3);
              if ((!this.g.B.containsKey(localObject3)) || (this.g.B.get(localObject3) == null)) {}
              for (;;)
              {
                i += 1;
                break;
                localArrayList2.add(localObject3);
              }
            }
            com.google.android.gms.ads.internal.util.a.v localv1 = com.google.android.gms.ads.internal.util.l.a(new f(this));
            com.google.android.gms.ads.internal.util.a.v localv2 = com.google.android.gms.ads.internal.util.l.a(new g(this));
            if (parame != null) {}
            for (localObject3 = parame.b;; localObject3 = null)
            {
              parame = this.g.y;
              if (parame != null) {
                if (parame.size() <= 0) {
                  parame = null;
                }
              }
              for (;;)
              {
                Object localObject4 = this.g;
                AdSizeParcel localAdSizeParcel = ((bu)localObject4).g;
                String str3 = ((bu)localObject4).j;
                localObject4 = ((bu)localObject4).i.e;
                String str4 = com.google.android.gms.ads.internal.client.u.h.i;
                Object localObject5 = this.g;
                VersionInfoParcel localVersionInfoParcel = ((bu)localObject5).P;
                localObject5 = ((bu)localObject5).y;
                boolean bool3 = bt.A.i.f().a();
                i = ((DisplayMetrics)localObject1).widthPixels;
                m = ((DisplayMetrics)localObject1).heightPixels;
                float f1 = ((DisplayMetrics)localObject1).density;
                List localList = com.google.android.gms.ads.internal.f.n.a();
                localObject1 = this.g;
                String str5 = ((bu)localObject1).L;
                NativeAdOptionsParcel localNativeAdOptionsParcel = ((bu)localObject1).x;
                boolean bool1 = ((bu)localObject1).u;
                if ((bool1) && (((bu)localObject1).s)) {
                  localObject1 = "";
                }
                for (;;)
                {
                  float f2 = bt.A.j.a();
                  boolean bool4 = bt.A.j.b();
                  Object localObject6 = bt.A.e;
                  n = com.google.android.gms.ads.internal.util.n.j(this.g.m);
                  localObject6 = bt.A.e;
                  i1 = com.google.android.gms.ads.internal.util.n.e(this.g.b);
                  boolean bool5 = this.g.m instanceof Activity;
                  boolean bool6 = bt.A.i.f().d();
                  localObject6 = bt.A.i.d;
                  ((com.google.android.gms.ads.internal.v.h)localObject6).a();
                  if (((com.google.android.gms.ads.internal.v.h)localObject6).a == com.google.android.gms.ads.internal.v.i.b) {}
                  for (bool1 = true;; bool1 = false)
                  {
                    i2 = bt.A.D.a.size();
                    localObject6 = bt.A.e;
                    localObject6 = com.google.android.gms.ads.internal.util.n.c();
                    String str6 = bt.A.o.a();
                    IconAdOptionsParcel localIconAdOptionsParcel = this.g.p;
                    boolean bool7 = bt.A.o.b();
                    Object localObject7 = com.google.android.gms.ads.internal.k.b.f;
                    Bundle localBundle2 = new Bundle();
                    localBundle2.putInt("ipl", ((com.google.android.gms.ads.internal.k.b)localObject7).c);
                    localBundle2.putInt("ipds", ((com.google.android.gms.ads.internal.k.b)localObject7).e);
                    localBundle2.putInt("ipde", ((com.google.android.gms.ads.internal.k.b)localObject7).d);
                    localBundle2.putInt("iph", ((com.google.android.gms.ads.internal.k.b)localObject7).a);
                    localBundle2.putInt("ipm", ((com.google.android.gms.ads.internal.k.b)localObject7).b);
                    boolean bool8 = bt.A.i.f().c(this.g.j);
                    Object localObject8 = this.g;
                    localObject7 = ((bu)localObject8).k;
                    localObject8 = ((bu)localObject8).m;
                    boolean bool9 = com.google.android.gms.common.b.c.a.a((Context)localObject8).a();
                    localObject8 = bt.A.i.d;
                    ((com.google.android.gms.ads.internal.v.h)localObject8).a();
                    if (((com.google.android.gms.ads.internal.v.h)localObject8).a == com.google.android.gms.ads.internal.v.i.a) {}
                    for (boolean bool2 = true;; bool2 = false)
                    {
                      localObject8 = bt.A.g;
                      boolean bool10 = com.google.android.gms.ads.internal.util.v.e();
                      localObject8 = bt.A.i;
                      return new com.google.android.gms.ads.internal.request.u((Bundle)localObject2, paramAdRequestParcel, localAdSizeParcel, str3, localApplicationInfo, localPackageInfo, (String)localObject4, str4, localVersionInfoParcel, localBundle1, (List)localObject5, localArrayList1, paramBundle, bool3, i, m, f1, str1, l, str2, localList, str5, localNativeAdOptionsParcel, (String)localObject1, f2, bool4, n, i1, bool5, bool6, localv1, (String)localObject3, bool1, i2, (Bundle)localObject6, str6, localIconAdOptionsParcel, bool7, localBundle2, bool8, localv2, (List)localObject7, parame, localArrayList2, paramInt, bool9, bool2, bool10, (ArrayList)com.google.android.gms.ads.internal.util.a.h.a(com.google.android.gms.ads.internal.v.f.g(), null, 1000L, TimeUnit.MILLISECONDS), bt.A.e.o(this.g.m), this.g.q, bt.A.e.q(this.g.m));
                    }
                  }
                  if (!bool1)
                  {
                    if (!((bu)localObject1).s) {
                      localObject1 = "";
                    } else if (!((bu)localObject1).t) {
                      localObject1 = "bottom-locked";
                    } else {
                      localObject1 = "bottom-scrollable";
                    }
                  }
                  else if (!((bu)localObject1).t) {
                    localObject1 = "top-locked";
                  } else {
                    localObject1 = "top-scrollable";
                  }
                }
                if (localPackageInfo != null) {}
                for (i = localPackageInfo.versionCode;; i = 0)
                {
                  if (i > bt.A.i.f().e())
                  {
                    bt.A.i.f().k();
                    bt.A.i.f().a(i);
                    parame = null;
                    break;
                  }
                  parame = bt.A.i.f().j();
                  if (parame != null)
                  {
                    parame = parame.optJSONArray(this.g.j);
                    if (parame != null)
                    {
                      parame = parame.toString();
                      break;
                    }
                    parame = null;
                    break;
                  }
                  parame = null;
                  break;
                }
                parame = null;
              }
            }
          }
          int i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          Object localObject2 = null;
          continue;
          localObject2 = null;
        }
        localNameNotFoundException = localNameNotFoundException;
        PackageInfo localPackageInfo = null;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.e.e("Cannot get correlation id, default to 0.");
          long l = 0L;
        }
      }
    }
  }
  
  static String c(com.google.android.gms.ads.internal.v.a parama)
  {
    String str2;
    String str1;
    if (parama != null)
    {
      str2 = parama.C;
      if (!"com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str2))
      {
        str1 = str2;
        if (!"com.google.ads.mediation.customevent.CustomEventAdapter".equals(str2)) {}
      }
      else
      {
        parama = parama.A;
        str1 = str2;
        if (parama != null) {
          parama = parama.s;
        }
      }
    }
    try
    {
      str1 = new JSONObject(parama).getString("class_name");
      return str1;
    }
    catch (NullPointerException parama)
    {
      return str2;
    }
    catch (JSONException parama) {}
    return null;
    return str2;
  }
  
  protected boolean A()
  {
    boolean bool2 = false;
    com.google.android.gms.ads.internal.util.n localn = bt.A.e;
    boolean bool1 = bool2;
    if (com.google.android.gms.ads.internal.util.n.a(this.g.m, "android.permission.INTERNET"))
    {
      localn = bt.A.e;
      bool1 = bool2;
      if (com.google.android.gms.ads.internal.util.n.a(this.g.m)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void B()
  {
    this.k = false;
    n();
    this.g.i.c();
  }
  
  public void C()
  {
    this.k = true;
    p();
  }
  
  public final void D()
  {
    this.a.b(this.g.h);
  }
  
  public final void E()
  {
    this.a.c(this.g.h);
  }
  
  public void F()
  {
    com.google.android.gms.ads.internal.util.e.e("Mediated ad does not support onVideoEnd callback");
  }
  
  public void G()
  {
    e();
  }
  
  public final void H()
  {
    B();
  }
  
  public final void I()
  {
    o();
  }
  
  public final void J()
  {
    C();
  }
  
  public final void K()
  {
    Object localObject = this.g.h;
    if (localObject != null)
    {
      localObject = ((com.google.android.gms.ads.internal.v.a)localObject).C;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 74);
      localStringBuilder.append("Mediation adapter ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" refreshed, but mediation adapters should never refresh.");
      com.google.android.gms.ads.internal.util.e.e(localStringBuilder.toString());
    }
    a(this.g.h, true);
    b(this.g.h, true);
    q();
  }
  
  public void L()
  {
    M();
  }
  
  public final void M()
  {
    a(this.g.h, false);
  }
  
  public final String N()
  {
    com.google.android.gms.ads.internal.v.a locala = this.g.h;
    if (locala != null) {
      return locala.C;
    }
    return null;
  }
  
  public final String O()
  {
    com.google.android.gms.ads.internal.v.a locala = this.g.h;
    if (locala != null) {
      return c(locala);
    }
    return null;
  }
  
  public void P()
  {
    com.google.android.gms.ads.internal.util.e.e("showInterstitial is not supported for current ad type");
  }
  
  public final void Q()
  {
    Executor localExecutor = aa.b;
    bj localbj = this.f;
    localbj.getClass();
    localExecutor.execute(new d(localbj));
  }
  
  public final void R()
  {
    Executor localExecutor = aa.b;
    bj localbj = this.f;
    localbj.getClass();
    localExecutor.execute(new e(localbj));
  }
  
  public final void a(ac paramac, String paramString)
  {
    am localam = null;
    if (paramac != null) {}
    for (;;)
    {
      String str;
      android.support.v4.g.v localv;
      try
      {
        str = paramac.c();
        localv = this.g.B;
        if (localv == null)
        {
          if (localam == null)
          {
            com.google.android.gms.ads.internal.util.e.e("Mediation adapter invoked onCustomClick but no listeners were set.");
            return;
          }
          localam.a(paramac, paramString);
          return;
        }
      }
      catch (RemoteException paramac)
      {
        com.google.android.gms.ads.internal.util.e.e("Unable to call onCustomClick.", paramac);
        return;
      }
      if (str != null)
      {
        localam = (am)localv.get(str);
        continue;
        str = null;
      }
    }
  }
  
  public void a(com.google.android.gms.ads.internal.v.a parama, boolean paramBoolean)
  {
    if (parama != null)
    {
      Object localObject;
      if (parama != null)
      {
        com.google.android.gms.ads.internal.util.e.b("Pinging Impression URLs.");
        localObject = this.g.i;
        if (localObject != null) {
          ((com.google.android.gms.ads.internal.v.c)localObject).a();
        }
        parama.c.a(com.google.android.gms.ads.internal.d.g.d);
        if ((parama.m != null) && (!parama.s)) {}
      }
      for (;;)
      {
        if (!parama.w) {}
        while (paramBoolean)
        {
          localObject = parama.E;
          if ((localObject == null) || (((com.google.android.gms.ads.internal.mediation.c)localObject).k == null)) {}
          for (;;)
          {
            localObject = parama.A;
            if ((localObject != null) && (((com.google.android.gms.ads.internal.mediation.b)localObject).n != null))
            {
              localObject = bt.A.w;
              localObject = this.g;
              com.google.android.gms.ads.internal.mediation.k.a(((bu)localObject).m, ((bu)localObject).P.a, parama, ((bu)localObject).j, paramBoolean, parama.A.n);
            }
            parama.w = true;
            return;
            localObject = bt.A.w;
            localObject = this.g;
            com.google.android.gms.ads.internal.mediation.k.a(((bu)localObject).m, ((bu)localObject).P.a, parama, ((bu)localObject).j, paramBoolean, a.a(parama.E.k, parama.N));
          }
        }
        return;
        localObject = bt.A.e;
        localObject = this.g;
        com.google.android.gms.ads.internal.util.n.a(((bu)localObject).m, ((bu)localObject).P.a, a.a(parama.m, parama.N));
        parama.s = true;
        continue;
        com.google.android.gms.ads.internal.util.e.e("Ad state was null when trying to ping impression URLs.");
      }
    }
    com.google.android.gms.ads.internal.util.e.e("Ad state was null when trying to ping impression URLs.");
  }
  
  public boolean a(AdRequestParcel paramAdRequestParcel, com.google.android.gms.ads.internal.g.l paraml)
  {
    return a(paramAdRequestParcel, paraml, 1);
  }
  
  public final boolean a(AdRequestParcel paramAdRequestParcel, com.google.android.gms.ads.internal.g.l paraml, int paramInt)
  {
    boolean bool = false;
    Object localObject;
    if (A())
    {
      localObject = bt.A.e;
      com.google.android.gms.ads.internal.util.n.d();
      this.f.a();
      this.g.H = 0;
      localObject = com.google.android.gms.ads.internal.f.n.av;
      if (!((Boolean)com.google.android.gms.ads.internal.client.u.h.e.a((com.google.android.gms.ads.internal.f.c)localObject)).booleanValue()) {
        break label105;
      }
      localObject = bt.A.i.f().f();
      ad localad = bt.A.m;
    }
    for (;;)
    {
      bool = a(a(paramAdRequestParcel, null, (com.google.android.gms.ads.internal.v.e)localObject, paramInt), paraml);
      return bool;
      label105:
      localObject = null;
    }
  }
  
  public boolean a(AdRequestParcel paramAdRequestParcel, com.google.android.gms.ads.internal.v.a parama, boolean paramBoolean)
  {
    long l;
    if ((!paramBoolean) && (this.g.c()))
    {
      l = parama.J;
      if (l <= 0L) {
        break label45;
      }
      this.f.a(paramAdRequestParcel, l);
    }
    for (;;)
    {
      return this.f.c;
      label45:
      com.google.android.gms.ads.internal.mediation.c localc = parama.E;
      if (localc != null)
      {
        l = localc.r;
        if (l > 0L)
        {
          this.f.a(paramAdRequestParcel, l);
          continue;
        }
      }
      if ((!parama.u) && (parama.l == 2)) {
        this.f.a(paramAdRequestParcel);
      }
    }
  }
  
  public final boolean a(com.google.android.gms.ads.internal.request.u paramu, com.google.android.gms.ads.internal.g.l paraml)
  {
    this.h = paraml;
    paraml.a("seq_num", paramu.S);
    paraml.a("request_id", paramu.O);
    paraml.a("session_id", paramu.T);
    Object localObject = paramu.M;
    if (localObject != null) {
      paraml.a("app_version", String.valueOf(((PackageInfo)localObject).versionCode));
    }
    paraml = this.g;
    localObject = bt.A.b;
    localObject = this.g.m;
    com.google.android.gms.ads.internal.d.h localh = this.c.b;
    if (paramu.b.f.getBundle("sdk_less_server_data") != null) {}
    for (paramu = new al((Context)localObject, paramu, this, localh);; paramu = new AdLoaderBackgroundTask((Context)localObject, paramu, this, localh))
    {
      if (paramu.j)
      {
        localObject = paramu.k;
        com.google.android.gms.ads.internal.util.l.a.a((Runnable)localObject);
      }
      for (;;)
      {
        paraml.d = paramu;
        return true;
        com.google.android.gms.ads.internal.util.l.a(paramu.k);
      }
    }
  }
  
  final boolean a(com.google.android.gms.ads.internal.v.a parama)
  {
    boolean bool = false;
    Object localObject = this.e;
    if (localObject != null) {
      this.e = null;
    }
    for (;;)
    {
      return a((AdRequestParcel)localObject, parama, bool);
      AdRequestParcel localAdRequestParcel = parama.d;
      Bundle localBundle = localAdRequestParcel.f;
      localObject = localAdRequestParcel;
      if (localBundle != null)
      {
        bool = localBundle.getBoolean("_noRefresh", false);
        localObject = localAdRequestParcel;
      }
    }
  }
  
  public boolean a(com.google.android.gms.ads.internal.v.a arg1, com.google.android.gms.ads.internal.v.a arg2)
  {
    int i = 0;
    if (??? == null) {}
    for (;;)
    {
      ??? = ???.F;
      if (??? != null) {
        ???.a(this);
      }
      ??? = ???.E;
      int m;
      label40:
      m localm;
      com.google.android.gms.ads.internal.v.n localn;
      if (??? != null)
      {
        m = ???.l;
        i = ???.m;
        localm = this.g.M;
        synchronized (localm.a)
        {
          localm.b = m;
          localm.c = i;
          localn = localm.e;
        }
      }
      synchronized (localn.b)
      {
        localn.c.add(localm);
        return true;
        m = 0;
        break label40;
        ??? = ???.F;
        if (??? == null) {
          continue;
        }
        ???.a(null);
        continue;
        ??? = finally;
        throw ???;
      }
    }
  }
  
  public final void b(com.google.android.gms.ads.internal.v.a parama)
  {
    super.b(parama);
    Object localObject;
    if (parama.A != null)
    {
      com.google.android.gms.ads.internal.util.e.b("Disable the debug gesture detector on the mediation ad frame.");
      localObject = this.g.b;
      if (localObject == null)
      {
        com.google.android.gms.ads.internal.util.e.b("Pinging network fill URLs.");
        localObject = bt.A.w;
        localObject = this.g;
        com.google.android.gms.ads.internal.mediation.k.a(((bu)localObject).m, ((bu)localObject).P.a, parama, ((bu)localObject).j, false, parama.A.m);
        localObject = parama.E;
        if (localObject != null)
        {
          localObject = ((com.google.android.gms.ads.internal.mediation.c)localObject).n;
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            com.google.android.gms.ads.internal.util.e.b("Pinging urls remotely");
            localObject = bt.A.e;
            com.google.android.gms.ads.internal.util.n.a(this.g.m, parama.E.n);
          }
        }
      }
    }
    for (;;)
    {
      if (parama.l == 3)
      {
        localObject = parama.E;
        if ((localObject != null) && (((com.google.android.gms.ads.internal.mediation.c)localObject).p != null))
        {
          com.google.android.gms.ads.internal.util.e.b("Pinging no fill URLs.");
          localObject = bt.A.w;
          localObject = this.g;
          com.google.android.gms.ads.internal.mediation.k.a(((bu)localObject).m, ((bu)localObject).P.a, parama, ((bu)localObject).j, false, parama.E.p);
        }
      }
      return;
      com.google.android.gms.ads.internal.util.e.a("Disable debug gesture detector on adFrame.");
      ((bv)localObject).a = false;
      break;
      com.google.android.gms.ads.internal.util.e.b("Enable the debug gesture detector on the admob ad frame.");
      localObject = this.g.b;
      if (localObject != null)
      {
        com.google.android.gms.ads.internal.util.e.a("Enable debug gesture detector on adFrame.");
        ((bv)localObject).a = true;
      }
    }
  }
  
  public final void b(com.google.android.gms.ads.internal.v.a parama, boolean paramBoolean)
  {
    if (parama != null) {
      if ((parama != null) && (parama.k != null) && (!parama.r)) {
        break label156;
      }
    }
    for (;;)
    {
      if (!parama.v) {}
      while (paramBoolean)
      {
        localObject = parama.E;
        if ((localObject == null) || (((com.google.android.gms.ads.internal.mediation.c)localObject).g == null)) {}
        for (;;)
        {
          localObject = parama.A;
          if ((localObject != null) && (((com.google.android.gms.ads.internal.mediation.b)localObject).l != null))
          {
            localObject = bt.A.w;
            localObject = this.g;
            com.google.android.gms.ads.internal.mediation.k.a(((bu)localObject).m, ((bu)localObject).P.a, parama, ((bu)localObject).j, paramBoolean, parama.A.l);
          }
          parama.v = true;
          return;
          localObject = bt.A.w;
          localObject = this.g;
          com.google.android.gms.ads.internal.mediation.k.a(((bu)localObject).m, ((bu)localObject).P.a, parama, ((bu)localObject).j, paramBoolean, a.a(parama.E.g));
        }
      }
      return;
      label156:
      Object localObject = bt.A.e;
      localObject = this.g;
      com.google.android.gms.ads.internal.util.n.a(((bu)localObject).m, ((bu)localObject).P.a, a.a(parama.k));
      parama.r = true;
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2);
  }
  
  protected final boolean c(AdRequestParcel paramAdRequestParcel)
  {
    return (super.c(paramAdRequestParcel)) && (!this.k);
  }
  
  public final void e()
  {
    Object localObject = this.g.h;
    if (localObject == null)
    {
      com.google.android.gms.ads.internal.util.e.e("Ad state was null when trying to ping click URLs.");
      return;
    }
    localObject = ((com.google.android.gms.ads.internal.v.a)localObject).E;
    if ((localObject == null) || (((com.google.android.gms.ads.internal.mediation.c)localObject).f == null)) {}
    for (;;)
    {
      localObject = this.g.h.A;
      if ((localObject != null) && (((com.google.android.gms.ads.internal.mediation.b)localObject).k != null))
      {
        localObject = bt.A.w;
        localObject = this.g;
        localContext = ((bu)localObject).m;
        str = ((bu)localObject).P.a;
        locala = ((bu)localObject).h;
        com.google.android.gms.ads.internal.mediation.k.a(localContext, str, locala, ((bu)localObject).j, false, locala.A.k);
      }
      super.e();
      return;
      localObject = bt.A.w;
      localObject = this.g;
      Context localContext = ((bu)localObject).m;
      String str = ((bu)localObject).P.a;
      com.google.android.gms.ads.internal.v.a locala = ((bu)localObject).h;
      com.google.android.gms.ads.internal.mediation.k.a(localContext, str, locala, ((bu)localObject).j, false, a.a(locala.E.f, locala.N));
    }
  }
  
  public void h()
  {
    com.google.android.gms.common.internal.z.a("pause must be called on the main UI thread.");
    Object localObject = this.g;
    com.google.android.gms.ads.internal.v.a locala = ((bu)localObject).h;
    if ((locala == null) || (locala.g == null) || (!((bu)localObject).c())) {}
    for (;;)
    {
      localObject = this.g.h;
      if (localObject != null)
      {
        localObject = ((com.google.android.gms.ads.internal.v.a)localObject).B;
        if (localObject == null) {}
      }
      try
      {
        ((com.google.android.gms.ads.internal.mediation.client.e)localObject).d();
        this.a.b(this.g.h);
        this.f.b();
        return;
        localObject = bt.A.g;
        com.google.android.gms.ads.internal.util.v.a(this.g.h.g);
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.e.e("Could not pause mediation adapter.");
        }
      }
    }
  }
  
  public void i()
  {
    Object localObject2 = null;
    com.google.android.gms.common.internal.z.a("resume must be called on the main UI thread.");
    bu localbu = this.g;
    com.google.android.gms.ads.internal.v.a locala = localbu.h;
    Object localObject1 = localObject2;
    if (locala != null)
    {
      localObject1 = locala.g;
      if (localObject1 != null) {
        break label138;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        label42:
        localObject2 = this.g.h;
        if (localObject2 != null)
        {
          localObject2 = ((com.google.android.gms.ads.internal.v.a)localObject2).B;
          if (localObject2 == null) {}
        }
      }
      try
      {
        ((com.google.android.gms.ads.internal.mediation.client.e)localObject2).e();
        if (localObject1 == null) {}
        for (;;)
        {
          this.f.c();
          do
          {
            this.a.c(this.g.h);
            return;
          } while (((com.google.android.gms.ads.internal.webview.i)localObject1).j());
        }
        if (!localbu.c()) {
          break label42;
        }
        localObject2 = bt.A.g;
        com.google.android.gms.ads.internal.util.v.b(this.g.h.g);
        break label42;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          label138:
          com.google.android.gms.ads.internal.util.e.e("Could not resume mediation adapter.");
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */