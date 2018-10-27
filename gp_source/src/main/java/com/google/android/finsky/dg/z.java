package com.google.android.finsky.dg;

import com.google.android.finsky.packagemanager.c;

final class z
  implements c
{
  z(x paramx, e parame, String paramString) {}
  
  private final void b()
  {
    synchronized (this.a)
    {
      this.a.c(this.c);
      return;
    }
  }
  
  public final void a()
  {
    b();
    this.b.a();
  }
  
  public final void a(int paramInt, Throwable paramThrowable)
  {
    synchronized (this.a)
    {
      b();
      this.b.a(paramInt, paramThrowable);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dg/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */