package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.b;
import com.google.android.gms.ads.internal.q.a.a;

@a
public class v
  extends b
{
  public b a;
  public final Object b = new Object();
  
  public void a()
  {
    synchronized (this.b)
    {
      b localb = this.a;
      if (localb == null) {
        return;
      }
      localb.a();
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.b)
    {
      b localb = this.a;
      if (localb == null) {
        return;
      }
      localb.a(paramInt);
    }
  }
  
  public final void b()
  {
    synchronized (this.b)
    {
      b localb = this.a;
      if (localb == null) {
        return;
      }
      localb.b();
    }
  }
  
  public final void c()
  {
    synchronized (this.b)
    {
      b localb = this.a;
      if (localb == null) {
        return;
      }
      localb.c();
    }
  }
  
  public final void d()
  {
    synchronized (this.b)
    {
      b localb = this.a;
      if (localb == null) {
        return;
      }
      localb.d();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */