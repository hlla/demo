package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.a.v;
import com.google.android.gms.ads.internal.util.a.z;
import com.google.android.gms.common.util.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@a
public final class h
  implements g
{
  public long a = 0L;
  public String b = "";
  public long c = 0L;
  public int d = 0;
  public String e;
  public boolean f = true;
  public String g;
  public boolean h = true;
  public SharedPreferences.Editor i;
  public long j = 0L;
  public boolean k = false;
  public final Object l = new Object();
  public JSONObject m = new JSONObject();
  public Set n = Collections.emptySet();
  public boolean o = false;
  public int p = -1;
  public SharedPreferences q;
  public boolean r = true;
  private v s;
  private final List t = new ArrayList();
  
  private final void o()
  {
    v localv = this.s;
    if ((localv != null) && (!localv.isDone())) {}
    try
    {
      this.s.get(1L, TimeUnit.SECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      e.e("Interrupted while waiting for preferences loaded.", localInterruptedException);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      e.c("Fail to initialize AdSharedPreferenceManager.", localExecutionException);
      return;
    }
    catch (CancellationException localCancellationException)
    {
      for (;;) {}
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;) {}
    }
  }
  
  public final void a(int paramInt)
  {
    o();
    synchronized (this.l)
    {
      if (this.d != paramInt)
      {
        this.d = paramInt;
        SharedPreferences.Editor localEditor = this.i;
        if (localEditor == null)
        {
          new Bundle().putInt("version_code", paramInt);
          n();
          return;
        }
        localEditor.putInt("version_code", paramInt);
        this.i.apply();
      }
    }
  }
  
  public final void a(long paramLong)
  {
    o();
    synchronized (this.l)
    {
      if (this.a != paramLong)
      {
        this.a = paramLong;
        SharedPreferences.Editor localEditor = this.i;
        if (localEditor == null)
        {
          new Bundle().putLong("app_last_background_time_ms", paramLong);
          n();
          return;
        }
        localEditor.putLong("app_last_background_time_ms", paramLong);
        this.i.apply();
      }
    }
  }
  
  public final void a(Context paramContext, String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = String.valueOf("admob__");
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {
        paramString = new String(str);
      }
    }
    for (;;)
    {
      this.s = l.a(new i(this, paramContext, paramString));
      return;
      paramString = str.concat(paramString);
      continue;
      paramString = "admob";
    }
  }
  
  public final void a(Runnable paramRunnable)
  {
    this.t.add(paramRunnable);
  }
  
  public final void a(String paramString)
  {
    o();
    synchronized (this.l)
    {
      if (!this.n.contains(paramString))
      {
        this.n.add(paramString);
        paramString = this.i;
        if (paramString == null)
        {
          paramString = new Bundle();
          Set localSet = this.n;
          paramString.putStringArray("never_pool_slots", (String[])localSet.toArray(new String[localSet.size()]));
          n();
          return;
        }
        paramString.putStringSet("never_pool_slots", this.n);
        this.i.apply();
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i1 = 0;
    o();
    label265:
    label280:
    for (;;)
    {
      JSONArray localJSONArray;
      int i2;
      JSONObject localJSONObject;
      synchronized (this.l)
      {
        localJSONArray = this.m.optJSONArray(paramString1);
        if (localJSONArray != null) {
          break label280;
        }
        localJSONArray = new JSONArray();
        i2 = localJSONArray.length();
        if (i1 < localJSONArray.length())
        {
          localJSONObject = localJSONArray.optJSONObject(i1);
          if (localJSONObject == null) {
            break label265;
          }
          if (!paramString2.equals(localJSONObject.optString("template_id")))
          {
            i1 += 1;
            continue;
          }
          i2 = i1;
          if (paramBoolean == true)
          {
            i2 = i1;
            if (localJSONObject.optBoolean("uses_media_view", false) == paramBoolean) {
              return;
            }
          }
        }
      }
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("template_id", paramString2);
        localJSONObject.put("uses_media_view", paramBoolean);
        localJSONObject.put("timestamp_ms", bt.A.l.a());
        localJSONArray.put(i2, localJSONObject);
        this.m.put(paramString1, localJSONArray);
        paramString1 = this.i;
        if (paramString1 == null) {}
        for (;;)
        {
          new Bundle().putString("native_advanced_settings", this.m.toString());
          n();
          return;
          paramString1 = finally;
          throw paramString1;
          paramString1.putString("native_advanced_settings", this.m.toString());
          this.i.apply();
        }
        return;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          e.e("Could not update native advanced settings", paramString1);
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    o();
    synchronized (this.l)
    {
      if (this.r != paramBoolean)
      {
        this.r = paramBoolean;
        SharedPreferences.Editor localEditor = this.i;
        if (localEditor == null)
        {
          if (!this.o)
          {
            new Bundle().putBoolean("use_https", paramBoolean);
            n();
          }
          return;
        }
        localEditor.putBoolean("use_https", paramBoolean);
        this.i.apply();
      }
    }
  }
  
  public final boolean a()
  {
    boolean bool2 = true;
    o();
    Object localObject1 = this.l;
    boolean bool1 = bool2;
    try
    {
      if (!this.r)
      {
        bool1 = bool2;
        if (!this.o) {
          bool1 = false;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public final void b(int paramInt)
  {
    o();
    synchronized (this.l)
    {
      if (this.p != paramInt)
      {
        this.p = paramInt;
        SharedPreferences.Editor localEditor = this.i;
        if (localEditor == null)
        {
          new Bundle().putInt("request_in_session_count", paramInt);
          n();
          return;
        }
        localEditor.putInt("request_in_session_count", paramInt);
        this.i.apply();
      }
    }
  }
  
  public final void b(long paramLong)
  {
    o();
    synchronized (this.l)
    {
      if (this.j != paramLong)
      {
        this.j = paramLong;
        SharedPreferences.Editor localEditor = this.i;
        if (localEditor == null)
        {
          new Bundle().putLong("first_ad_req_time_ms", paramLong);
          n();
          return;
        }
        localEditor.putLong("first_ad_req_time_ms", paramLong);
        this.i.apply();
      }
    }
  }
  
  public final void b(String paramString)
  {
    o();
    synchronized (this.l)
    {
      if (this.n.contains(paramString))
      {
        this.n.remove(paramString);
        paramString = this.i;
        if (paramString == null)
        {
          paramString = new Bundle();
          Set localSet = this.n;
          paramString.putStringArray("never_pool_slots", (String[])localSet.toArray(new String[localSet.size()]));
          n();
          return;
        }
        paramString.putStringSet("never_pool_slots", this.n);
        this.i.apply();
      }
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    o();
    synchronized (this.l)
    {
      if (this.f != paramBoolean)
      {
        this.f = paramBoolean;
        Object localObject2 = this.i;
        if (localObject2 == null)
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("content_url_opted_out", this.f);
          ((Bundle)localObject2).putBoolean("content_vertical_opted_out", this.h);
          n();
          return;
        }
        ((SharedPreferences.Editor)localObject2).putBoolean("content_url_opted_out", paramBoolean);
        this.i.apply();
      }
    }
  }
  
  public final boolean b()
  {
    o();
    synchronized (this.l)
    {
      boolean bool = this.f;
      return bool;
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    o();
    synchronized (this.l)
    {
      if (this.h != paramBoolean)
      {
        this.h = paramBoolean;
        Object localObject2 = this.i;
        if (localObject2 == null)
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("content_url_opted_out", this.f);
          ((Bundle)localObject2).putBoolean("content_vertical_opted_out", this.h);
          n();
          return;
        }
        ((SharedPreferences.Editor)localObject2).putBoolean("content_vertical_opted_out", paramBoolean);
        this.i.apply();
      }
    }
  }
  
  public final boolean c()
  {
    o();
    synchronized (this.l)
    {
      boolean bool = this.h;
      return bool;
    }
  }
  
  public final boolean c(String paramString)
  {
    o();
    synchronized (this.l)
    {
      boolean bool = this.n.contains(paramString);
      return bool;
    }
  }
  
  public final void d(boolean paramBoolean)
  {
    o();
    synchronized (this.l)
    {
      if (this.k != paramBoolean)
      {
        this.k = paramBoolean;
        SharedPreferences.Editor localEditor = this.i;
        if (localEditor == null)
        {
          new Bundle().putBoolean("auto_collect_location", paramBoolean);
          n();
          return;
        }
        localEditor.putBoolean("auto_collect_location", paramBoolean);
        this.i.apply();
      }
    }
  }
  
  public final boolean d()
  {
    o();
    synchronized (this.l)
    {
      boolean bool = this.k;
      return bool;
    }
  }
  
  public final int e()
  {
    o();
    synchronized (this.l)
    {
      int i1 = this.d;
      return i1;
    }
  }
  
  public final com.google.android.gms.ads.internal.v.e f()
  {
    o();
    synchronized (this.l)
    {
      com.google.android.gms.ads.internal.v.e locale = new com.google.android.gms.ads.internal.v.e(this.b);
      return locale;
    }
  }
  
  public final long g()
  {
    o();
    synchronized (this.l)
    {
      long l1 = this.a;
      return l1;
    }
  }
  
  public final int h()
  {
    o();
    synchronized (this.l)
    {
      int i1 = this.p;
      return i1;
    }
  }
  
  public final long i()
  {
    o();
    synchronized (this.l)
    {
      long l1 = this.j;
      return l1;
    }
  }
  
  public final JSONObject j()
  {
    o();
    synchronized (this.l)
    {
      JSONObject localJSONObject = this.m;
      return localJSONObject;
    }
  }
  
  public final void k()
  {
    o();
    synchronized (this.l)
    {
      this.m = new JSONObject();
      SharedPreferences.Editor localEditor = this.i;
      if (localEditor == null)
      {
        new Bundle().putString("native_advanced_settings", "{}");
        n();
        return;
      }
      localEditor.remove("native_advanced_settings");
      this.i.apply();
    }
  }
  
  public final com.google.android.gms.ads.internal.b.e l()
  {
    return null;
  }
  
  final Bundle m()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("listener_registration_bundle", true);
    synchronized (this.l)
    {
      localBundle.putBoolean("use_https", this.r);
      localBundle.putBoolean("content_url_opted_out", this.f);
      localBundle.putBoolean("content_vertical_opted_out", this.h);
      localBundle.putBoolean("auto_collect_location", this.k);
      localBundle.putInt("version_code", this.d);
      Object localObject3 = this.n;
      localBundle.putStringArray("never_pool_slots", (String[])((Set)localObject3).toArray(new String[((Set)localObject3).size()]));
      localBundle.putString("app_settings_json", this.b);
      localBundle.putLong("app_settings_last_update_ms", this.c);
      localBundle.putLong("app_last_background_time_ms", this.a);
      localBundle.putInt("request_in_session_count", this.p);
      localBundle.putLong("first_ad_req_time_ms", this.j);
      localBundle.putString("native_advanced_settings", this.m.toString());
      localObject3 = this.e;
      if (localObject3 == null)
      {
        localObject3 = this.g;
        if (localObject3 != null) {
          localBundle.putString("content_vertical_hashes", (String)localObject3);
        }
        return localBundle;
      }
      localBundle.putString("content_url_hashes", (String)localObject3);
    }
  }
  
  final void n()
  {
    l.c.execute(new j(this));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */