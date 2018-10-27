package com.google.android.gms.ads.internal.renderer.a;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.m;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.util.a.af;
import com.google.android.gms.ads.internal.util.ax;
import com.google.android.gms.ads.internal.util.ba;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class b
  implements Callable
{
  private static long f = 10L;
  public final Context a;
  public final com.google.android.gms.ads.internal.az b;
  public final com.google.android.gms.ads.internal.v.b c;
  public final com.google.android.gms.ads.internal.zxxz.aa d;
  public final com.google.android.gms.ads.internal.g.l e;
  private JSONObject g;
  private String h;
  private int i;
  private boolean j;
  private final Object k = new Object();
  private List l;
  private final u m;
  
  public b(Context paramContext, com.google.android.gms.ads.internal.az paramaz, ax paramax, com.google.android.gms.ads.internal.zxxz.aa paramaa, com.google.android.gms.ads.internal.v.b paramb, com.google.android.gms.ads.internal.g.l paraml)
  {
    this.a = paramContext;
    this.b = paramaz;
    this.c = paramb;
    this.d = paramaa;
    this.e = paraml;
    this.m = paramaz.Z();
    this.j = false;
    this.i = -2;
    this.l = null;
    this.h = null;
  }
  
  static k a(Context paramContext, com.google.android.gms.ads.internal.zxxz.aa paramaa, com.google.android.gms.ads.internal.v.b paramb, com.google.android.gms.ads.internal.g.l paraml, com.google.android.gms.ads.internal.az paramaz)
  {
    return new k(paramContext, paramaa, paramb, paraml, paramaz);
  }
  
  private final com.google.android.gms.ads.internal.v.a a()
  {
    try
    {
      str = this.b.o;
      if (b()) {
        break label851;
      }
      localObject6 = new JSONObject(this.c.e.f);
      localObject1 = new JSONObject(this.c.e.f);
      if (((JSONObject)localObject1).length() == 0) {
        break label838;
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("ads");
      if (localObject1 == null) {
        break label950;
      }
      localObject1 = ((JSONArray)localObject1).optJSONObject(0);
    }
    catch (CancellationException localCancellationException)
    {
      for (;;)
      {
        String str;
        Object localObject1;
        Object localObject7;
        com.google.android.gms.ads.internal.util.e.e("Malformed native JSON response.", localCancellationException);
        if (!this.j) {
          a(0);
        }
        return a(null, false);
        Object localObject2;
        if ("1".equals(localCancellationException))
        {
          localObject2 = new w(bool2, bool3, this.c.j);
        }
        else if ("3".equals(localObject2))
        {
          localObject2 = ((JSONObject)localObject6).getString("custom_template_id");
          localObject8 = new af();
          com.google.android.gms.ads.internal.util.n.a.post(new e(this, (af)localObject8, (String)localObject2));
          if (((af)localObject8).get(f, TimeUnit.SECONDS) != null)
          {
            localObject2 = new x(bool2);
          }
          else
          {
            localObject2 = String.valueOf(((JSONObject)localObject6).getString("custom_template_id"));
            if (((String)localObject2).length() == 0) {}
            for (localObject2 = new String("No handler for custom template: ");; localObject2 = "No handler for custom template: ".concat((String)localObject2))
            {
              com.google.android.gms.ads.internal.util.e.c((String)localObject2);
              localObject2 = null;
              break;
            }
          }
        }
        else
        {
          a(0);
          localObject2 = null;
          continue;
          localObject2 = ((JSONObject)localObject2).optString("omid_html");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject7 = com.google.android.gms.ads.internal.util.a.h.a(com.google.android.gms.ads.internal.util.a.h.a(null), new c(this, (String)localObject2), com.google.android.gms.ads.internal.util.a.aa.b);
            continue;
            a(3);
            continue;
            a(3);
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        continue;
        localObject6 = null;
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.e.e("Timeout when loading native ad.", localTimeoutException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject8;
        com.google.android.gms.ads.internal.util.e.e("Error occured while doing native ads initialization.", localException);
        continue;
        if (localException == null)
        {
          Object localObject3 = null;
          continue;
          localObject8 = null;
          continue;
          localObject8 = null;
          continue;
          localObject3 = null;
        }
      }
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        continue;
        boolean bool3 = false;
        continue;
        boolean bool2 = false;
        continue;
        Object localObject4 = null;
        continue;
        boolean bool1 = false;
        continue;
        Object localObject6 = null;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        label838:
        label851:
        label883:
        label900:
        label906:
        label917:
        label923:
        label928:
        label934:
        label939:
        continue;
        label950:
        Object localObject5 = null;
      }
    }
    if ((localObject1 != null) && (((JSONObject)localObject1).length() != 0))
    {
      localObject1 = (JSONObject)this.m.a((JSONObject)localObject6).get(f, TimeUnit.SECONDS);
      if (!((JSONObject)localObject1).optBoolean("success", false)) {
        break label939;
      }
      localObject6 = ((JSONObject)localObject1).getJSONObject("json").optJSONArray("ads").getJSONObject(0);
      if (localObject6 == null) {
        break label934;
      }
      bool1 = ((JSONObject)localObject6).optBoolean("enable_omid");
      if (bool1)
      {
        localObject1 = ((JSONObject)localObject6).optJSONObject("omid_settings");
        if (localObject1 != null) {}
      }
      else
      {
        localObject7 = com.google.android.gms.ads.internal.util.a.h.a(null);
        if (b()) {
          localObject1 = null;
        }
        for (;;)
        {
          bool2 = b();
          if (!bool2) {
            break label883;
          }
          localObject1 = null;
          for (;;)
          {
            if ((localObject1 instanceof m))
            {
              localObject6 = new f(this, (m)localObject1);
              this.m.a("/nativeAdCustomClick", (com.google.android.gms.ads.internal.gmsg.u)localObject6);
            }
            localObject1 = a((com.google.android.gms.ads.internal.formats.v)localObject1, bool1);
            this.b.m = b((com.google.android.gms.ads.internal.util.a.v)localObject7);
            return (com.google.android.gms.ads.internal.v.a)localObject1;
            if (localObject6 == null) {
              break label906;
            }
            JSONObject localJSONObject = ((JSONObject)localObject6).getJSONObject("tracking_urls_and_actions");
            JSONArray localJSONArray = localJSONObject.optJSONArray("impression_tracking_urls");
            if (localJSONArray == null) {
              break;
            }
            String[] arrayOfString = new String[localJSONArray.length()];
            int n = 0;
            for (;;)
            {
              localObject8 = arrayOfString;
              if (n >= localJSONArray.length()) {
                break;
              }
              arrayOfString[n] = localJSONArray.getString(n);
              n += 1;
            }
            if (localObject8 == null) {
              break label900;
            }
            localObject8 = Arrays.asList((Object[])localObject8);
            this.l = ((List)localObject8);
            this.g = localJSONObject.optJSONObject("active_view");
            this.h = ((JSONObject)localObject6).optString("debug_signals");
            ((JSONObject)localObject6).optString("omid_settings");
            localObject1 = ((j)localObject1).a(this, (JSONObject)localObject6);
            if (localObject1 == null)
            {
              com.google.android.gms.ads.internal.util.e.c("Failed to retrieve ad assets.");
              localObject1 = null;
            }
            else
            {
              ((com.google.android.gms.ads.internal.formats.v)localObject1).a(new com.google.android.gms.ads.internal.formats.x(this.a, this.b, this.m, this.d, (JSONObject)localObject6, (com.google.android.gms.ads.internal.formats.v)localObject1, this.c.d.ae, str));
            }
          }
          if (localObject6 == null) {
            break label928;
          }
          localObject1 = ((JSONObject)localObject6).getString("template_id");
          boolean bool4 = "instream".equals(((JSONObject)localObject6).optString("type"));
          localObject8 = this.c.d.G;
          if (localObject8 == null) {
            break label923;
          }
          bool2 = ((NativeAdOptionsParcel)localObject8).d;
          if (localObject8 == null) {
            break label917;
          }
          bool3 = ((NativeAdOptionsParcel)localObject8).c;
          if (bool4)
          {
            localObject1 = new a();
          }
          else
          {
            if (!"2".equals(localObject1)) {
              break;
            }
            localObject1 = new v(bool2, bool3, this.c.j);
          }
        }
      }
    }
  }
  
  private final com.google.android.gms.ads.internal.v.a a(com.google.android.gms.ads.internal.formats.v paramv, boolean paramBoolean)
  {
    synchronized (this.k)
    {
      int i1 = this.i;
      if (paramv != null) {
        n = i1;
      }
      do
      {
        if (n != -2) {
          paramv = null;
        }
        for (;;)
        {
          ??? = this.c;
          Object localObject2 = ((com.google.android.gms.ads.internal.v.b)???).d;
          AdRequestParcel localAdRequestParcel = ((AdRequestInfoParcel)localObject2).b;
          AdResponseParcel localAdResponseParcel = ((com.google.android.gms.ads.internal.v.b)???).e;
          List localList1 = localAdResponseParcel.g;
          List localList2 = localAdResponseParcel.q;
          List localList3 = this.l;
          i1 = localAdResponseParcel.K;
          long l1 = localAdResponseParcel.M;
          localObject2 = ((AdRequestInfoParcel)localObject2).X;
          AdSizeParcel localAdSizeParcel = ((com.google.android.gms.ads.internal.v.b)???).g;
          long l2 = localAdResponseParcel.r;
          l2 = ((com.google.android.gms.ads.internal.v.b)???).f;
          long l3 = ((com.google.android.gms.ads.internal.v.b)???).b;
          String str = localAdResponseParcel.k;
          JSONObject localJSONObject = this.g;
          boolean bool = localAdResponseParcel.E;
          AutoClickProtectionConfigurationParcel localAutoClickProtectionConfigurationParcel = localAdResponseParcel.d;
          return new com.google.android.gms.ads.internal.v.a(localAdRequestParcel, null, localList1, n, localList2, localList3, i1, l1, (String)localObject2, false, null, null, null, null, null, localAdSizeParcel, l2, l3, str, localJSONObject, paramv, null, null, null, bool, null, localAdResponseParcel.H, this.h, ((com.google.android.gms.ads.internal.v.b)???).c, localAdResponseParcel.u, ((com.google.android.gms.ads.internal.v.b)???).j, paramBoolean, localAdResponseParcel.m, localAdResponseParcel.t, localAdResponseParcel.S);
        }
        n = i1;
      } while (i1 != -2);
      int n = 0;
    }
  }
  
  static com.google.android.gms.ads.internal.webview.i a(com.google.android.gms.ads.internal.util.a.v paramv)
  {
    try
    {
      paramv = (com.google.android.gms.ads.internal.webview.i)paramv.get(((Integer)com.google.android.gms.ads.internal.f.n.ch.a()).intValue(), TimeUnit.SECONDS);
      return paramv;
    }
    catch (InterruptedException paramv)
    {
      com.google.android.gms.ads.internal.util.e.e("InterruptedException occurred while waiting for video to load", paramv);
      Thread.currentThread().interrupt();
      return null;
    }
    catch (ExecutionException paramv)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.e.e("Exception occurred while waiting for video to load", paramv);
      }
    }
    catch (CancellationException paramv)
    {
      for (;;) {}
    }
    catch (TimeoutException paramv)
    {
      for (;;) {}
    }
  }
  
  private final void a(int paramInt)
  {
    synchronized (this.k)
    {
      this.j = true;
      this.i = paramInt;
      return;
    }
  }
  
  private static com.google.android.gms.ads.internal.webview.i b(com.google.android.gms.ads.internal.util.a.v paramv)
  {
    try
    {
      paramv = (com.google.android.gms.ads.internal.webview.i)paramv.get(((Integer)com.google.android.gms.ads.internal.f.n.bh.a()).intValue(), TimeUnit.MILLISECONDS);
      return paramv;
    }
    catch (InterruptedException paramv)
    {
      com.google.android.gms.ads.internal.util.client.k.e("", paramv);
      Thread.currentThread().interrupt();
      return null;
    }
    catch (ExecutionException paramv)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.k.e("", paramv);
      }
    }
    catch (CancellationException paramv)
    {
      for (;;) {}
    }
    catch (TimeoutException paramv)
    {
      for (;;) {}
    }
  }
  
  private static Integer b(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject(paramString);
      int n = Color.rgb(paramJSONObject.getInt("r"), paramJSONObject.getInt("g"), paramJSONObject.getInt("b"));
      return Integer.valueOf(n);
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  private final boolean b()
  {
    synchronized (this.k)
    {
      boolean bool = this.j;
      return bool;
    }
  }
  
  public final com.google.android.gms.ads.internal.util.a.v a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONObject("attribution");
    if (localObject != null)
    {
      String str = ((JSONObject)localObject).optString("text");
      int i1 = ((JSONObject)localObject).optInt("text_size", -1);
      Integer localInteger1 = b((JSONObject)localObject, "text_color");
      Integer localInteger2 = b((JSONObject)localObject, "bg_color");
      int i2 = ((JSONObject)localObject).optInt("animation_ms", 1000);
      int i3 = ((JSONObject)localObject).optInt("presentation_ms", 4000);
      paramJSONObject = this.c.d.G;
      int n;
      if (paramJSONObject != null) {
        if (paramJSONObject.e >= 2) {
          n = paramJSONObject.a;
        }
      }
      for (;;)
      {
        boolean bool = ((JSONObject)localObject).optBoolean("allow_pub_rendering");
        paramJSONObject = new ArrayList();
        if (((JSONObject)localObject).optJSONArray("images") != null) {
          paramJSONObject = b((JSONObject)localObject, "images", false, true);
        }
        for (;;)
        {
          localObject = new af();
          int i4 = paramJSONObject.size();
          AtomicInteger localAtomicInteger = new AtomicInteger(0);
          Iterator localIterator = paramJSONObject.iterator();
          while (localIterator.hasNext()) {
            ((com.google.android.gms.ads.internal.util.a.v)localIterator.next()).a(new i(localAtomicInteger, i4, (af)localObject, paramJSONObject), com.google.android.gms.ads.internal.util.l.c);
          }
          return com.google.android.gms.ads.internal.util.a.h.a((com.google.android.gms.ads.internal.util.a.v)localObject, new g(str, localInteger2, localInteger1, i1, i3, i2, n, bool), com.google.android.gms.ads.internal.util.l.c);
          paramJSONObject.add(a((JSONObject)localObject, "image", false, false));
        }
        n = 1;
        continue;
        n = 1;
      }
    }
    return com.google.android.gms.ads.internal.util.a.h.a(null);
  }
  
  public final com.google.android.gms.ads.internal.util.a.v a(JSONObject paramJSONObject, String paramString)
  {
    paramString = paramJSONObject.optJSONObject(paramString);
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString.optString("vast_xml")))
      {
        com.google.android.gms.ads.internal.util.e.e("Required field 'vast_xml' is missing");
        return com.google.android.gms.ads.internal.util.a.h.a(null);
      }
      k localk = a(this.a, this.d, this.c, this.e, this.b);
      boolean bool = "instream".equals(paramJSONObject.optString("type"));
      paramJSONObject = new af();
      com.google.android.gms.ads.internal.util.a.aa.b.execute(new l(localk, bool, paramString, paramJSONObject));
      return paramJSONObject;
    }
    return com.google.android.gms.ads.internal.util.a.h.a(null);
  }
  
  public final com.google.android.gms.ads.internal.util.a.v a(JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {}
    for (paramJSONObject = paramJSONObject.optJSONObject(paramString);; paramJSONObject = paramJSONObject.getJSONObject(paramString))
    {
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      return a(paramString, paramBoolean1, paramBoolean2);
    }
  }
  
  final com.google.android.gms.ads.internal.util.a.v a(JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {}
    for (String str = paramJSONObject.optString("url");; str = paramJSONObject.getString("url"))
    {
      double d1 = paramJSONObject.optDouble("scale", 1.0D);
      boolean bool = paramJSONObject.optBoolean("is_transparent", true);
      if (TextUtils.isEmpty(str))
      {
        a(0, paramBoolean1);
        return com.google.android.gms.ads.internal.util.a.h.a(null);
      }
      if (!paramBoolean2)
      {
        paramJSONObject = new h(this, paramBoolean1, d1, bool, str);
        return com.google.android.gms.ads.internal.util.a.h.a(com.google.android.gms.ads.internal.util.a.h.a(ax.a(str), new ba(paramJSONObject), com.google.android.gms.ads.internal.util.l.c), Throwable.class, new com.google.android.gms.ads.internal.util.az(paramJSONObject), com.google.android.gms.ads.internal.util.a.aa.a);
      }
      return com.google.android.gms.ads.internal.util.a.h.a(new com.google.android.gms.ads.internal.formats.h(null, Uri.parse(str), d1));
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramInt);
    }
  }
  
  public final List b(JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    ArrayList localArrayList = new ArrayList();
    if ((localJSONArray != null) && (localJSONArray.length() != 0))
    {
      if (paramBoolean2) {}
      for (int n = localJSONArray.length();; n = 1)
      {
        int i1 = 0;
        while (i1 < n)
        {
          paramString = localJSONArray.getJSONObject(i1);
          paramJSONObject = paramString;
          if (paramString == null) {
            paramJSONObject = new JSONObject();
          }
          localArrayList.add(a(paramJSONObject, false, paramBoolean1));
          i1 += 1;
        }
        return localArrayList;
      }
    }
    a(0, false);
    return localArrayList;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/renderer/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */