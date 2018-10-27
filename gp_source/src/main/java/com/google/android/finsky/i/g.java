package com.google.android.finsky.i;

final class g
  implements Runnable
{
  g(f paramf, Runnable paramRunnable, int paramInt) {}
  
  public final void run()
  {
    if (this.a.a())
    {
      this.c.run();
      return;
    }
    this.a.a(this.b, this.c);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/i/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */