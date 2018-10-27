package com.google.android.gms.ads.internal.request.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.util.a.aa;
import com.google.android.gms.ads.internal.util.a.h;
import com.google.android.gms.ads.internal.util.a.v;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.common.util.b;
import com.google.android.gms.dynamite.DynamiteModule;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class q
  extends s
{
  public final Context a;
  public SharedPreferences b;
  private final com.google.android.gms.ads.internal.js.function.a c;
  private final Object d = new Object();
  
  public q(Context paramContext, com.google.android.gms.ads.internal.js.function.a parama)
  {
    this.a = paramContext.getApplicationContext();
    this.c = parama;
  }
  
  public final v a()
  {
    synchronized (this.d)
    {
      if (this.b == null)
      {
        this.b = this.a.getSharedPreferences("google_ads_flags_meta", 0);
        long l = this.b.getLong("js_last_update", 0L);
        if (bt.A.l.a() - l < ((Long)n.aR.a()).longValue()) {
          return h.a(null);
        }
        ??? = new JSONObject();
      }
      try
      {
        ((JSONObject)???).put("js", VersionInfoParcel.a().a);
        ((JSONObject)???).put("mf", n.aQ.a());
        ((JSONObject)???).put("cl", "207207134");
        ((JSONObject)???).put("rapid_rc", "dev");
        ((JSONObject)???).put("rapid_rollup", "HEAD");
        ((JSONObject)???).put("dynamite_version", DynamiteModule.a(this.a, "com.google.android.gms.ads.dynamite"));
        ((JSONObject)???).put("container_version", 12451009);
        return h.a(this.c.b(???), new r(this), aa.a);
      }
      catch (JSONException localJSONException)
      {
        e.c("Unable to populate SDK Core Constants parameters.", localJSONException);
      }
    }
    return h.a(null);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */