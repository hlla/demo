package com.google.android.gms.ads.internal.w;

import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.q.a.a;
import org.json.JSONException;
import org.json.JSONObject;

@a
public final class ac
{
  public final boolean a;
  public final int b;
  public final int c;
  public final int d;
  public final String e;
  public final int f;
  public final int g;
  public final boolean h;
  
  public ac(String paramString)
  {
    if (paramString != null) {}
    try
    {
      for (paramString = new JSONObject(paramString);; paramString = null)
      {
        this.a = a(paramString, "aggressive_media_codec_release", n.bX);
        this.b = b(paramString, "byte_buffer_precache_limit", n.bY);
        this.c = b(paramString, "exo_cache_buffer_size", n.ct);
        this.d = b(paramString, "exo_connect_timeout_millis", n.cb);
        this.e = c(paramString, "exo_player_version", n.cf);
        this.f = b(paramString, "exo_read_timeout_millis", n.ce);
        b(paramString, "load_check_interval_bytes", n.cc);
        this.g = b(paramString, "player_precache_limit", n.cd);
        this.h = a(paramString, "use_cache_data_source", n.A);
        a(paramString, "use_dash", false);
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  private static boolean a(JSONObject paramJSONObject, String paramString, c paramc)
  {
    return a(paramJSONObject, paramString, ((Boolean)paramc.a()).booleanValue());
  }
  
  private static boolean a(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramJSONObject != null) {}
    try
    {
      bool = paramJSONObject.getBoolean(paramString);
      return bool;
    }
    catch (JSONException paramJSONObject) {}
    return paramBoolean;
  }
  
  private static int b(JSONObject paramJSONObject, String paramString, c paramc)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return ((Integer)paramc.a()).intValue();
      try
      {
        int i = paramJSONObject.getInt(paramString);
        return i;
      }
      catch (JSONException paramJSONObject) {}
    }
  }
  
  private static String c(JSONObject paramJSONObject, String paramString, c paramc)
  {
    if (paramJSONObject != null) {
      try
      {
        paramJSONObject = paramJSONObject.getString(paramString);
        return paramJSONObject;
      }
      catch (JSONException paramJSONObject) {}
    }
    return (String)paramc.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */