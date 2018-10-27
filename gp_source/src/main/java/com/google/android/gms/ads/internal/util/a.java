package com.google.android.gms.ads.internal.util;

@com.google.android.gms.ads.internal.q.a.a
public abstract class a
  implements ag
{
  public boolean j;
  public final Runnable k = new b(this);
  public volatile Thread l;
  
  public a()
  {
    this.j = false;
  }
  
  public a(byte paramByte)
  {
    this.j = true;
  }
  
  public abstract void a();
  
  public final void b()
  {
    be_();
    if (this.l != null) {
      this.l.interrupt();
    }
  }
  
  public abstract void be_();
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */