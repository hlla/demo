package com.google.android.gms.ads.internal.mediation;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.mediation.client.k;
import com.google.android.gms.ads.internal.mediation.client.y;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.n;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class f
  implements j
{
  public final b a;
  public AdRequestParcel b;
  public final AdSizeParcel c;
  public com.google.android.gms.ads.internal.mediation.client.e d;
  public final String e;
  public int f = -2;
  public final Context g;
  public final List h;
  public final boolean i;
  public final boolean j;
  public final Object k = new Object();
  public final NativeAdOptionsParcel l;
  public final List m;
  public final List n;
  public final VersionInfoParcel o;
  private final com.google.android.gms.ads.internal.mediation.client.b p;
  private final long q;
  private final c r;
  private k s;
  
  public f(Context paramContext, String paramString, com.google.android.gms.ads.internal.mediation.client.b paramb, c paramc, b paramb1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, VersionInfoParcel paramVersionInfoParcel, boolean paramBoolean1, boolean paramBoolean2, NativeAdOptionsParcel paramNativeAdOptionsParcel, List paramList1, List paramList2, List paramList3)
  {
    this.g = paramContext;
    this.p = paramb;
    this.a = paramb1;
    if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString)) {}
    for (this.e = d();; this.e = paramString)
    {
      this.r = paramc;
      long l1 = paramb1.e;
      if (l1 != -1L) {
        this.q = l1;
      }
      for (;;)
      {
        this.b = paramAdRequestParcel;
        this.c = paramAdSizeParcel;
        this.o = paramVersionInfoParcel;
        this.i = paramBoolean1;
        this.j = paramBoolean2;
        this.l = paramNativeAdOptionsParcel;
        this.n = paramList1;
        this.m = paramList2;
        this.h = paramList3;
        return;
        l1 = paramc.b;
        if (l1 != -1L) {
          this.q = l1;
        } else {
          this.q = 10000L;
        }
      }
    }
  }
  
  private static com.google.android.gms.ads.internal.mediation.client.e a(com.google.android.gms.ads.mediation.b paramb)
  {
    return new y(paramb);
  }
  
  static com.google.android.gms.ads.formats.f b(String paramString)
  {
    int i1 = 0;
    com.google.android.gms.ads.formats.g localg = new com.google.android.gms.ads.formats.g();
    if (paramString == null) {
      return localg.a();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localg.c = paramString.optBoolean("multiple_images", false);
        localg.d = paramString.optBoolean("only_urls", false);
        paramString = paramString.optString("native_image_orientation", "any");
        if ("landscape".equals(paramString)) {
          continue;
        }
        if ("portrait".equals(paramString)) {
          continue;
        }
        if (!"any".equals(paramString)) {
          i1 = -1;
        }
        localg.b = i1;
      }
      catch (JSONException paramString)
      {
        com.google.android.gms.ads.internal.util.e.e("Exception occurred when creating native ad options", paramString);
        continue;
      }
      return localg.a();
      i1 = 1;
      continue;
      i1 = 2;
    }
  }
  
  private final String d()
  {
    try
    {
      if (!TextUtils.isEmpty(this.a.i))
      {
        if (!this.p.c(this.a.i)) {
          return "com.google.ads.mediation.customevent.CustomEventAdapter";
        }
        return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.e.e("Fail to determine the custom event's version, assuming the old one.");
    }
    return "com.google.ads.mediation.customevent.CustomEventAdapter";
  }
  
  private final k e()
  {
    if ((this.f == 0) && (c()))
    {
      try
      {
        if (b(4))
        {
          k localk = this.s;
          if ((localk != null) && (localk.a() != 0))
          {
            localk = this.s;
            return localk;
          }
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.e.e("Could not get cpm value from MediationResponseMetadata");
      }
      return new h(f());
    }
    return null;
  }
  
  private final int f()
  {
    Object localObject = this.a.s;
    if (localObject != null) {}
    try
    {
      localObject = new JSONObject((String)localObject);
      int i2;
      if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.e))
      {
        i2 = ((JSONObject)localObject).optInt("cpm_cents", 0);
        return i2;
      }
      if (b(2)) {}
      for (int i1 = ((JSONObject)localObject).optInt("cpm_floor_cents", 0);; i1 = 0)
      {
        i2 = i1;
        if (i1 != 0) {
          break;
        }
        return ((JSONObject)localObject).optInt("penalized_average_cpm_cents", 0);
      }
      return 0;
    }
    catch (JSONException localJSONException)
    {
      com.google.android.gms.ads.internal.util.e.e("Could not convert to json. Returning 0");
    }
    return 0;
  }
  
  public final i a(long paramLong1, long paramLong2)
  {
    long l1;
    for (;;)
    {
      long l4;
      long l3;
      synchronized (this.k)
      {
        l1 = SystemClock.elapsedRealtime();
        e locale1 = new e();
        n.a.post(new g(this, locale1));
        long l2 = this.q;
        if (this.f != -2) {
          break;
        }
        l4 = SystemClock.elapsedRealtime();
        l3 = l2 - (l4 - l1);
        l4 = paramLong2 - (l4 - paramLong1);
        if (l3 <= 0L)
        {
          com.google.android.gms.ads.internal.util.e.d("Timed out waiting for adapter.");
          this.f = 3;
        }
      }
      if (l4 > 0L) {
        try
        {
          this.k.wait(Math.min(l3, l4));
        }
        catch (InterruptedException localInterruptedException)
        {
          this.f = 5;
        }
      }
    }
    paramLong1 = bt.A.l.b();
    i locali = new i(this.a, this.d, this.e, locale2, this.f, e(), paramLong1 - l1);
    return locali;
  }
  
  final String a(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (c())
      {
        localObject = paramString;
        if (b(2)) {}
      }
    }
    try
    {
      localObject = new JSONObject(paramString);
      ((JSONObject)localObject).remove("cpm_floor_cents");
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      com.google.android.gms.ads.internal.util.e.e("Could not remove field. Returning the original value");
    }
    return paramString;
  }
  
  public final void a()
  {
    synchronized (this.k)
    {
      try
      {
        locale = this.d;
        if (locale != null) {
          break label31;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.mediation.client.e locale;
          label31:
          com.google.android.gms.ads.internal.util.e.e("Could not destroy mediation adapter.", localRemoteException);
        }
      }
      this.f = -1;
      this.k.notify();
      return;
      locale.c();
    }
  }
  
  public final void a(int paramInt)
  {
    synchronized (this.k)
    {
      this.f = paramInt;
      this.k.notify();
      return;
    }
  }
  
  public final void a(k paramk)
  {
    synchronized (this.k)
    {
      this.f = 0;
      this.s = paramk;
      this.k.notify();
      return;
    }
  }
  
  final com.google.android.gms.ads.internal.mediation.client.e b()
  {
    Object localObject = String.valueOf(this.e);
    if (((String)localObject).length() == 0) {}
    for (localObject = new String("Instantiating mediation adapter: ");; localObject = "Instantiating mediation adapter: ".concat((String)localObject))
    {
      com.google.android.gms.ads.internal.util.e.d((String)localObject);
      if ((!this.i) && (!this.a.b()))
      {
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.e)) {
          return a(new AdMobAdapter());
        }
        if ("com.google.ads.mediation.AdUrlAdapter".equals(this.e)) {
          return a(new AdUrlAdapter());
        }
        if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.e)) {
          return new y(new com.google.android.gms.ads.internal.mediation.a.a());
        }
      }
      try
      {
        localObject = this.p.a(this.e);
        return (com.google.android.gms.ads.internal.mediation.client.e)localObject;
      }
      catch (RemoteException localRemoteException)
      {
        localObject = String.valueOf(this.e);
        if (((String)localObject).length() != 0) {
          break;
        }
      }
    }
    for (localObject = new String("Could not instantiate mediation adapter: ");; localObject = "Could not instantiate mediation adapter: ".concat((String)localObject))
    {
      com.google.android.gms.ads.internal.util.e.b((String)localObject, localRemoteException);
      return null;
    }
  }
  
  final boolean b(int paramInt)
  {
    boolean bool2 = false;
    try
    {
      Bundle localBundle;
      if (!this.i) {
        if (!this.c.e) {
          localBundle = this.d.j();
        }
      }
      for (;;)
      {
        boolean bool1 = bool2;
        if (localBundle != null)
        {
          bool1 = bool2;
          if ((localBundle.getInt("capabilities", 0) & paramInt) == paramInt) {
            bool1 = true;
          }
        }
        return bool1;
        localBundle = this.d.k();
        continue;
        localBundle = this.d.l();
      }
      return false;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.e.e("Could not get adapter info. Returning false");
    }
  }
  
  final boolean c()
  {
    return this.r.h != -1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */