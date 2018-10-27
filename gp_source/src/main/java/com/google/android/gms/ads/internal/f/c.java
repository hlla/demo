package com.google.android.gms.ads.internal.f;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.q.a.a;
import java.util.Collection;
import org.json.JSONObject;

@a
public abstract class c
{
  public final Object a;
  public final String b;
  public final int c;
  
  c(int paramInt, String paramString, Object paramObject)
  {
    this.c = paramInt;
    this.b = paramString;
    this.a = paramObject;
    u.h.c.b.add(this);
  }
  
  public static c a(int paramInt, String paramString)
  {
    paramString = a(paramInt, paramString, null);
    u.h.c.a.add(paramString);
    return paramString;
  }
  
  public static c a(int paramInt, String paramString, float paramFloat)
  {
    return new g(paramInt, paramString, Float.valueOf(paramFloat));
  }
  
  public static c a(int paramInt1, String paramString, int paramInt2)
  {
    return new e(paramInt1, paramString, Integer.valueOf(paramInt2));
  }
  
  public static c a(int paramInt, String paramString, long paramLong)
  {
    return new f(paramInt, paramString, Long.valueOf(paramLong));
  }
  
  public static c a(int paramInt, String paramString, Boolean paramBoolean)
  {
    return new d(paramInt, paramString, paramBoolean);
  }
  
  public static c a(int paramInt, String paramString1, String paramString2)
  {
    return new h(paramInt, paramString1, paramString2);
  }
  
  public static c b(int paramInt, String paramString)
  {
    paramString = a(paramInt, paramString, null);
    u.h.c.c.add(paramString);
    return paramString;
  }
  
  public final Object a()
  {
    return u.h.e.a(this);
  }
  
  protected abstract Object a(SharedPreferences paramSharedPreferences);
  
  protected abstract Object a(JSONObject paramJSONObject);
  
  public abstract void a(SharedPreferences.Editor paramEditor, Object paramObject);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */