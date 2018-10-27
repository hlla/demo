package com.google.android.finsky.dg;

import com.google.android.finsky.bo.f;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.d;
import com.google.android.finsky.installer.p;
import com.google.android.finsky.notification.u;
import com.google.android.finsky.packagemanager.h;

public final class a
  implements h
{
  private final f a;
  private final b.a b;
  private final af c;
  private final b.a d;
  
  public a(b.a parama1, b.a parama2, af paramaf, f paramf)
  {
    this.d = parama1;
    this.b = parama2;
    this.c = paramaf;
    this.a = paramf;
  }
  
  public final void a(String[] paramArrayOfString) {}
  
  public final void b(String paramString) {}
  
  public final void b(String paramString, boolean paramBoolean)
  {
    ((u)this.d.a()).c(paramString);
  }
  
  public final void c(String paramString)
  {
    if (!this.a.a(12659780L)) {
      this.c.a(new d(128).a(paramString));
    }
  }
  
  public final void c(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ((u)this.d.a()).a(paramString);
      ((u)this.d.a()).b(paramString);
    }
    for (;;)
    {
      ((p)this.b.a()).b(paramString, paramBoolean);
      return;
      ((u)this.d.a()).b();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */