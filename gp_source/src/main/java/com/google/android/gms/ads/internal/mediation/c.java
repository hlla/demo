package com.google.android.gms.ads.internal.mediation;

import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@a
public final class c
{
  public final List a;
  public final long b;
  public final boolean c;
  public final boolean d;
  public final boolean e;
  public final List f;
  public final List g;
  public final int h;
  public final long i;
  public boolean j;
  public final List k;
  public int l;
  public int m;
  public final List n;
  public final boolean o;
  public final List p;
  public final String q;
  public final long r;
  public final int s;
  public final String t;
  public final boolean u;
  
  public c(String paramString)
  {
    this(new JSONObject(paramString));
  }
  
  public c(List paramList1, long paramLong, List paramList2, List paramList3, List paramList4, List paramList5, List paramList6, boolean paramBoolean, String paramString)
  {
    this.a = paramList1;
    this.b = paramLong;
    this.f = paramList2;
    this.k = paramList3;
    this.g = paramList4;
    this.p = paramList5;
    this.n = paramList6;
    this.o = paramBoolean;
    this.q = paramString;
    this.r = -1L;
    this.l = 0;
    this.m = 1;
    this.t = null;
    this.s = 0;
    this.h = -1;
    this.i = -1L;
    this.u = false;
    this.e = false;
    this.d = false;
    this.c = false;
    this.j = false;
  }
  
  public c(JSONObject paramJSONObject)
  {
    if (!e.a(2))
    {
      localObject1 = paramJSONObject.getJSONArray("ad_networks");
      ArrayList localArrayList = new ArrayList(((JSONArray)localObject1).length());
      int i1 = 0;
      for (i2 = -1; i1 < ((JSONArray)localObject1).length(); i2 = i3)
      {
        try
        {
          Object localObject2 = new b(((JSONArray)localObject1).getJSONObject(i1));
          if (((b)localObject2).a()) {
            this.j = true;
          }
          localArrayList.add(localObject2);
          i3 = i2;
          if (i2 < 0)
          {
            localObject2 = ((b)localObject2).f.iterator();
            do
            {
              i3 = i2;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
            } while (!((String)((Iterator)localObject2).next()).equals("com.google.ads.mediation.admob.AdMobAdapter"));
            i3 = i1;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            long l1;
            int i3 = i2;
          }
        }
        i1 += 1;
      }
      this.l = i2;
      this.m = ((JSONArray)localObject1).length();
      this.a = Collections.unmodifiableList(localArrayList);
      this.q = paramJSONObject.optString("qdata");
      this.h = paramJSONObject.optInt("fs_model_type", -1);
      this.i = paramJSONObject.optLong("timeout_ms", -1L);
      paramJSONObject = paramJSONObject.optJSONObject("settings");
      if (paramJSONObject != null)
      {
        this.b = paramJSONObject.optLong("ad_network_timeout_millis", -1L);
        localObject1 = bt.A.w;
        this.f = k.a(paramJSONObject, "click_urls");
        localObject1 = bt.A.w;
        this.k = k.a(paramJSONObject, "imp_urls");
        localObject1 = bt.A.w;
        this.g = k.a(paramJSONObject, "downloaded_imp_urls");
        localObject1 = bt.A.w;
        this.p = k.a(paramJSONObject, "nofill_urls");
        localObject1 = bt.A.w;
        this.n = k.a(paramJSONObject, "remote_ping_urls");
        this.o = paramJSONObject.optBoolean("render_in_browser", false);
        l1 = paramJSONObject.optLong("refresh", -1L);
        if (l1 > 0L) {}
        for (l1 *= 1000L;; l1 = -1L)
        {
          this.r = l1;
          localObject1 = RewardItemParcel.a(paramJSONObject.optJSONArray("rewards"));
          if (localObject1 == null) {
            this.t = null;
          }
          for (this.s = 0;; this.s = ((RewardItemParcel)localObject1).a)
          {
            this.u = paramJSONObject.optBoolean("use_displayed_impression", false);
            this.e = paramJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.d = paramJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            this.c = paramJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
            this.t = ((RewardItemParcel)localObject1).b;
          }
        }
      }
      this.b = -1L;
      this.f = null;
      this.k = null;
      this.g = null;
      this.p = null;
      this.n = null;
      this.r = -1L;
      this.t = null;
      this.s = 0;
      this.u = false;
      this.o = false;
      this.e = false;
      this.d = false;
      this.c = false;
      return;
    }
    Object localObject1 = String.valueOf(paramJSONObject.toString(2));
    if (((String)localObject1).length() == 0) {}
    for (localObject1 = new String("Mediation Response JSON: ");; localObject1 = "Mediation Response JSON: ".concat((String)localObject1))
    {
      e.a((String)localObject1);
      break;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */