package com.google.android.finsky.ag;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class q
{
  public final Object a;
  public f b;
  public final String c;
  
  protected q(f paramf, String paramString, Object paramObject)
  {
    this.b = paramf;
    this.c = paramString;
    this.a = paramObject;
  }
  
  public final Object a()
  {
    return a(this.b.a());
  }
  
  protected abstract Object a(SharedPreferences paramSharedPreferences);
  
  protected abstract void a(Editor paramEditor, Object paramObject);
  
  public final void a(Object paramObject)
  {
    Editor localEditor = this.b.a().edit();
    a(localEditor, paramObject);
    localEditor.apply();
  }
  
  public final boolean b()
  {
    return this.b.a().contains(this.c);
  }
  
  public final void c()
  {
    this.b.a().edit().remove(this.c).apply();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ag/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */