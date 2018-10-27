package com.google.android.finsky.i;

import com.google.android.finsky.utils.ao;

public final class c
{
  public final f a;
  public final com.google.android.finsky.aj.a b;
  public final ao c;
  public boolean d;
  
  public c(f paramf, com.google.android.finsky.aj.a parama, ao paramao)
  {
    this.a = paramf;
    this.b = parama;
    this.c = paramao;
  }
  
  public final void a()
  {
    if (!this.d)
    {
      this.a.a(((Integer)com.google.android.finsky.ag.d.C.b()).intValue(), new d(this));
      this.d = true;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/i/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */