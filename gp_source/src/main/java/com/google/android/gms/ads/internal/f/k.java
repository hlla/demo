package com.google.android.gms.ads.internal.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.ConditionVariable;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.bo;
import org.json.JSONException;
import org.json.JSONObject;

@a
public final class k
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  public Context a;
  public final ConditionVariable b = new ConditionVariable();
  public volatile boolean c = false;
  public volatile boolean d = false;
  public final Object e = new Object();
  public SharedPreferences f = null;
  private JSONObject g = new JSONObject();
  
  public final Object a(c paramc)
  {
    if (!this.b.block(5000L)) {
      synchronized (this.e)
      {
        if (!this.d) {
          throw new IllegalStateException("Flags.initialize() was not called!");
        }
      }
    }
    if ((!this.c) || (this.f == null)) {}
    synchronized (this.e)
    {
      if (!this.c) {}
      while (this.f == null)
      {
        paramc = paramc.a;
        return paramc;
      }
      if ((paramc.c == 1) && (this.g.has(paramc.b))) {
        return paramc.a(this.g);
      }
      return bo.a(this.a, new m(this, paramc));
    }
  }
  
  final void a()
  {
    if (this.f != null) {}
    try
    {
      this.g = new JSONObject((String)bo.a(this.a, new l(this)));
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public final void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if ("flag_configuration".equals(paramString)) {
      a();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/f/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */