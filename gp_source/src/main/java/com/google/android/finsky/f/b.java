package com.google.android.finsky.f;

import android.content.Context;

public final class b
{
  private final c a;
  private final com.google.android.finsky.l.a b;
  private final com.google.android.finsky.ac.a c;
  private final b.a d;
  private final Context e;
  private final com.google.android.finsky.bo.c f;
  private final com.google.android.finsky.library.c g;
  
  public b(Context paramContext, com.google.android.finsky.l.a parama, com.google.android.finsky.library.c paramc, com.google.android.finsky.bo.c paramc1, c paramc2, com.google.android.finsky.ac.a parama1, b.a parama2)
  {
    this.e = paramContext;
    this.b = parama;
    this.g = paramc;
    this.f = paramc1;
    this.a = paramc2;
    this.c = parama1;
    this.d = parama2;
  }
  
  public final a a(String paramString)
  {
    return new a(this.e, paramString, this.b, this.g, this.f, this.a, this.c, this.d);
  }
  
  public final a b(String paramString)
  {
    this.b.a();
    this.g.c();
    return a(paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */