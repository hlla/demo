package com.google.android.gms.ads.internal.request.a;

import com.google.android.gms.ads.internal.q.a.a;
import java.util.Arrays;
import org.json.JSONObject;

@a
public final class k
{
  public final String a;
  public final String b;
  public final int c;
  public final boolean d;
  public final String e;
  public final JSONObject f;
  public final boolean g;
  public final boolean h;
  public final String i;
  public String j;
  
  public k(JSONObject paramJSONObject)
  {
    this.j = paramJSONObject.optString("url");
    this.b = paramJSONObject.optString("base_uri");
    this.e = paramJSONObject.optString("post_parameters");
    Object localObject = paramJSONObject.optString("drt_include");
    boolean bool;
    if (localObject != null) {
      if (!((String)localObject).equals("1")) {
        if (((String)localObject).equals("true")) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      this.d = bool;
      paramJSONObject.optString("request_id");
      paramJSONObject.optString("type");
      localObject = paramJSONObject.optString("errors");
      if (localObject != null) {
        Arrays.asList(((String)localObject).split(","));
      }
      if (paramJSONObject.optInt("valid", 0) == 1) {
        k = -2;
      }
      this.c = k;
      this.a = paramJSONObject.optString("fetched_ad");
      this.g = paramJSONObject.optBoolean("render_test_ad_label");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("preprocessor_flags");
      localObject = localJSONObject;
      if (localJSONObject == null) {
        localObject = new JSONObject();
      }
      this.f = ((JSONObject)localObject);
      this.i = paramJSONObject.optString("analytics_query_ad_event_id");
      this.h = paramJSONObject.optBoolean("is_analytics_logging_enabled");
      return;
      bool = false;
      continue;
      bool = true;
      continue;
      bool = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */