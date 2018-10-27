package com.google.android.gms.ads.internal.mediation;

import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@a
public final class b
{
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final long e;
  public final List f;
  public final String g;
  public final String h;
  public final String i;
  public final String j;
  public final List k;
  public final List l;
  public final List m;
  public final List n;
  public final List o;
  public final List p;
  public final List q;
  public final List r;
  public final String s;
  public final List t;
  private final String u;
  
  public b(String paramString1, List paramList1, List paramList2, List paramList3, List paramList4, List paramList5, String paramString2, List paramList6, List paramList7, List paramList8, List paramList9)
  {
    this.b = paramString1;
    this.d = null;
    this.f = paramList1;
    this.g = null;
    this.i = null;
    this.k = paramList2;
    this.n = paramList3;
    this.l = paramList4;
    this.o = paramList5;
    this.s = paramString2;
    this.r = paramList6;
    this.p = paramList7;
    this.q = paramList8;
    this.j = null;
    this.a = null;
    this.h = null;
    this.t = null;
    this.c = null;
    this.m = paramList9;
    this.u = null;
    this.e = -1L;
  }
  
  public b(JSONObject paramJSONObject)
  {
    this.d = paramJSONObject.optString("id");
    Object localObject1 = paramJSONObject.getJSONArray("adapters");
    Object localObject2 = new ArrayList(((JSONArray)localObject1).length());
    int i1 = 0;
    while (i1 < ((JSONArray)localObject1).length())
    {
      ((List)localObject2).add(((JSONArray)localObject1).getString(i1));
      i1 += 1;
    }
    this.f = Collections.unmodifiableList((List)localObject2);
    this.g = paramJSONObject.optString("allocation_id", null);
    localObject1 = bt.A.w;
    this.k = k.a(paramJSONObject, "clickurl");
    localObject1 = bt.A.w;
    this.n = k.a(paramJSONObject, "imp_urls");
    localObject1 = bt.A.w;
    this.l = k.a(paramJSONObject, "downloaded_imp_urls");
    localObject1 = bt.A.w;
    this.m = k.a(paramJSONObject, "fill_urls");
    localObject1 = bt.A.w;
    this.r = k.a(paramJSONObject, "video_start_urls");
    localObject1 = bt.A.w;
    this.q = k.a(paramJSONObject, "video_complete_urls");
    localObject1 = bt.A.w;
    this.p = k.a(paramJSONObject, "video_reward_urls");
    localObject2 = paramJSONObject.optJSONObject("ad");
    if (localObject2 != null) {
      localObject1 = bt.A.w;
    }
    for (localObject1 = k.a((JSONObject)localObject2, "manual_impression_urls");; localObject1 = null)
    {
      this.o = ((List)localObject1);
      if (localObject2 != null) {}
      for (localObject1 = ((JSONObject)localObject2).toString();; localObject1 = null)
      {
        this.b = ((String)localObject1);
        localObject2 = paramJSONObject.optJSONObject("data");
        if (localObject2 != null) {}
        for (localObject1 = ((JSONObject)localObject2).toString();; localObject1 = null)
        {
          this.s = ((String)localObject1);
          if (localObject2 != null) {}
          for (localObject1 = ((JSONObject)localObject2).optString("class_name");; localObject1 = null)
          {
            this.i = ((String)localObject1);
            this.j = paramJSONObject.optString("html_template", null);
            this.a = paramJSONObject.optString("ad_base_url", null);
            localObject1 = paramJSONObject.optJSONObject("assets");
            if (localObject1 != null) {}
            for (localObject1 = ((JSONObject)localObject1).toString();; localObject1 = null)
            {
              this.h = ((String)localObject1);
              localObject1 = bt.A.w;
              this.t = k.a(paramJSONObject, "template_ids");
              localObject1 = paramJSONObject.optJSONObject("ad_loader_options");
              if (localObject1 != null) {}
              for (localObject1 = ((JSONObject)localObject1).toString();; localObject1 = null)
              {
                this.c = ((String)localObject1);
                this.u = paramJSONObject.optString("response_type", null);
                this.e = paramJSONObject.optLong("ad_network_timeout_millis", -1L);
                return;
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean a()
  {
    return "banner".equalsIgnoreCase(this.u);
  }
  
  public final boolean b()
  {
    return "native".equalsIgnoreCase(this.u);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */