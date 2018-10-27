package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.IconAdOptionsParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.am;
import com.google.android.gms.ads.internal.client.ar;
import com.google.android.gms.ads.internal.client.au;
import com.google.android.gms.ads.internal.client.ba;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.k;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.p.a.f;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zxxz.GADUrlException;
import com.google.android.gms.ads.internal.zxxz.aa;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

@com.google.android.gms.ads.internal.q.a.a
public final class bn
  extends am
{
  public aa a;
  public com.google.android.gms.ads.internal.client.z b;
  public final Context c;
  public final Future d;
  public final VersionInfoParcel e;
  public WebView f;
  private final AdSizeParcel g;
  private final bs h;
  private AsyncTask i;
  
  public bn(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, VersionInfoParcel paramVersionInfoParcel)
  {
    this.c = paramContext;
    this.e = paramVersionInfoParcel;
    this.g = paramAdSizeParcel;
    this.f = new WebView(this.c);
    this.d = com.google.android.gms.ads.internal.util.l.a(new bq(this));
    this.h = new bs(paramString);
    a(0);
    this.f.setVerticalScrollBarEnabled(false);
    this.f.getSettings().setJavaScriptEnabled(true);
    this.f.setWebViewClient(new bo(this));
    this.f.setOnTouchListener(new bp(this));
  }
  
  public final String N()
  {
    return null;
  }
  
  public final String O()
  {
    return null;
  }
  
  public final void P()
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void a()
  {
    com.google.android.gms.common.internal.z.a("destroy must be called on the main UI thread.");
    this.i.cancel(true);
    this.d.cancel(true);
    this.f.destroy();
    this.f = null;
  }
  
  final void a(int paramInt)
  {
    if (this.f != null)
    {
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, paramInt);
      this.f.setLayoutParams(localLayoutParams);
    }
  }
  
  public final void a(AdSizeParcel paramAdSizeParcel)
  {
    throw new IllegalStateException("AdSize must be set before initialization");
  }
  
  public final void a(IconAdOptionsParcel paramIconAdOptionsParcel)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void a(VideoOptionsParcel paramVideoOptionsParcel)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void a(ar paramar)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void a(au paramau)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void a(ba paramba)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void a(w paramw)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void a(com.google.android.gms.ads.internal.client.z paramz)
  {
    this.b = paramz;
  }
  
  public final void a(com.google.android.gms.ads.internal.h.a.e parame)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void a(com.google.android.gms.ads.internal.p.a.a parama)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void a(f paramf, String paramString)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void a(com.google.android.gms.ads.internal.reward.client.l paraml)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void a(String paramString)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void a(boolean paramBoolean) {}
  
  public final com.google.android.gms.ads.internal.j.a b()
  {
    com.google.android.gms.common.internal.z.a("getAdFrame must be called on the main UI thread.");
    return com.google.android.gms.dynamic.e.a(this.f);
  }
  
  public final void b(String paramString)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void b(boolean paramBoolean)
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final boolean b(AdRequestParcel paramAdRequestParcel)
  {
    com.google.android.gms.common.internal.z.a(this.f, "This Search Ad has already been torn down");
    bs localbs = this.h;
    VersionInfoParcel localVersionInfoParcel = this.e;
    localbs.d = paramAdRequestParcel.r.a;
    paramAdRequestParcel = paramAdRequestParcel.n;
    if (paramAdRequestParcel != null) {}
    for (paramAdRequestParcel = paramAdRequestParcel.getBundle(AdMobAdapter.class.getName());; paramAdRequestParcel = null)
    {
      if (paramAdRequestParcel != null)
      {
        Object localObject = n.H;
        localObject = (String)u.h.e.a((c)localObject);
        Iterator localIterator = paramAdRequestParcel.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!((String)localObject).equals(str))
          {
            if (str.startsWith("csa_")) {
              localbs.b.put(str.substring(4), paramAdRequestParcel.getString(str));
            }
          }
          else {
            localbs.a = paramAdRequestParcel.getString(str);
          }
        }
        localbs.b.put("SDKVersion", localVersionInfoParcel.a);
      }
      this.i = new br(this).execute(new Void[0]);
      return true;
    }
  }
  
  final int c(String paramString)
  {
    int j = 0;
    paramString = Uri.parse(paramString).getQueryParameter("height");
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      com.google.android.gms.ads.internal.util.client.a locala = u.h.a;
      j = com.google.android.gms.ads.internal.util.client.a.a(this.c, Integer.parseInt(paramString));
      return j;
    }
    catch (NumberFormatException paramString) {}
    return 0;
  }
  
  public final AdSizeParcel c()
  {
    return this.g;
  }
  
  final String d(String paramString)
  {
    Object localObject = paramString;
    if (this.a != null) {
      paramString = Uri.parse(paramString);
    }
    try
    {
      localObject = this.a.a(paramString, this.c, null, null);
      paramString = (String)localObject;
    }
    catch (GADUrlException localGADUrlException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.e.e("Unable to process ad data", localGADUrlException);
      }
    }
    localObject = paramString.toString();
    return (String)localObject;
  }
  
  public final boolean d()
  {
    return false;
  }
  
  final String e()
  {
    Object localObject1 = new Uri.Builder();
    Object localObject3 = ((Uri.Builder)localObject1).scheme("https://");
    Object localObject4 = n.L;
    ((Uri.Builder)localObject3).appendEncodedPath((String)u.h.e.a((c)localObject4));
    ((Uri.Builder)localObject1).appendQueryParameter("query", this.h.d);
    ((Uri.Builder)localObject1).appendQueryParameter("pubId", this.h.c);
    localObject3 = this.h.b;
    localObject4 = ((Map)localObject3).keySet().iterator();
    while (((Iterator)localObject4).hasNext())
    {
      String str = (String)((Iterator)localObject4).next();
      ((Uri.Builder)localObject1).appendQueryParameter(str, (String)((Map)localObject3).get(str));
    }
    localObject3 = ((Uri.Builder)localObject1).build();
    localObject4 = this.a;
    localObject1 = localObject3;
    if (localObject4 != null) {}
    try
    {
      localObject1 = ((aa)localObject4).a((Uri)localObject3, this.c);
      localObject3 = f();
      localObject1 = ((Uri)localObject1).getEncodedQuery();
      localObject4 = new StringBuilder(String.valueOf(localObject3).length() + 1 + String.valueOf(localObject1).length());
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append("#");
      ((StringBuilder)localObject4).append((String)localObject1);
      return ((StringBuilder)localObject4).toString();
    }
    catch (GADUrlException localGADUrlException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.e.e("Unable to process ad data", localGADUrlException);
        Object localObject2 = localObject3;
      }
    }
  }
  
  final String f()
  {
    String str = this.h.a;
    if (TextUtils.isEmpty(str)) {
      str = "www.google.com";
    }
    for (;;)
    {
      Object localObject = n.L;
      localObject = (String)u.h.e.a((c)localObject);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 8 + String.valueOf(localObject).length());
      localStringBuilder.append("https://");
      localStringBuilder.append(str);
      localStringBuilder.append((String)localObject);
      return localStringBuilder.toString();
    }
  }
  
  public final void g()
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void h()
  {
    com.google.android.gms.common.internal.z.a("pause must be called on the main UI thread.");
  }
  
  public final void i()
  {
    com.google.android.gms.common.internal.z.a("resume must be called on the main UI thread.");
  }
  
  public final Bundle j()
  {
    throw new IllegalStateException("Unused method");
  }
  
  public final void k() {}
  
  public final boolean l()
  {
    return false;
  }
  
  public final com.google.android.gms.ads.internal.client.bo m()
  {
    return null;
  }
  
  public final String w()
  {
    throw new IllegalStateException("getAdUnitId not implemented");
  }
  
  public final au x()
  {
    throw new IllegalStateException("getIAppEventListener not implemented");
  }
  
  public final com.google.android.gms.ads.internal.client.z y()
  {
    throw new IllegalStateException("getIAdListener not implemented");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */