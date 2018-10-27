package com.google.android.finsky.ag;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashSet;
import java.util.Set;

public final class f
{
  public static Context a;
  private final String b;
  
  public f(String paramString)
  {
    new HashSet();
    this.b = paramString;
  }
  
  public final SharedPreferences a()
  {
    return a.getSharedPreferences(this.b, 0);
  }
  
  final q a(String paramString, Boolean paramBoolean)
  {
    return new j(this, paramString, paramBoolean);
  }
  
  public final q a(String paramString, Integer paramInteger)
  {
    return new k(this, paramString, paramInteger);
  }
  
  public final q a(String paramString, Long paramLong)
  {
    return new g(this, paramString, paramLong);
  }
  
  public final q a(String paramString1, String paramString2)
  {
    return new h(this, paramString1, paramString2);
  }
  
  public final q a(String paramString, Set paramSet)
  {
    return new i(this, paramString, paramSet);
  }
  
  public final p b(String paramString, Boolean paramBoolean)
  {
    return new n(this, this, paramString, paramBoolean);
  }
  
  public final p b(String paramString, Integer paramInteger)
  {
    return new o(this, this, paramString, paramInteger);
  }
  
  public final p b(String paramString, Long paramLong)
  {
    return new l(this, this, paramString, paramLong);
  }
  
  public final p b(String paramString1, String paramString2)
  {
    return new m(this, this, paramString1, paramString2);
  }
  
  public final void b()
  {
    a().edit().clear().commit();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ag/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */