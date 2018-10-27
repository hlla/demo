package com.google.android.gms.ads.internal.mediation;

import com.google.android.gms.ads.internal.formats.a.ac;
import com.google.android.gms.ads.internal.mediation.client.i;
import com.google.android.gms.ads.internal.mediation.client.k;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;

@a
public final class e
  extends i
{
  public j a;
  public final Object b = new Object();
  private d c;
  
  public final void a()
  {
    synchronized (this.b)
    {
      d locald = this.c;
      if (locald == null) {
        return;
      }
      locald.G();
    }
  }
  
  public final void a(int paramInt)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        j localj = this.a;
        if (localj != null)
        {
          if (paramInt == 3)
          {
            paramInt = 1;
            localj.a(paramInt);
            this.a = null;
          }
        }
        else {
          return;
        }
      }
      paramInt = 2;
    }
  }
  
  public final void a(ac paramac, String paramString)
  {
    synchronized (this.b)
    {
      d locald = this.c;
      if (locald == null) {
        return;
      }
      locald.a(paramac, paramString);
    }
  }
  
  public final void a(k paramk)
  {
    j localj;
    synchronized (this.b)
    {
      localj = this.a;
      if (localj == null)
      {
        paramk = this.c;
        if (paramk == null) {
          return;
        }
        paramk.K();
      }
    }
    localj.a(paramk);
    this.a = null;
  }
  
  public final void a(d paramd)
  {
    synchronized (this.b)
    {
      this.c = paramd;
      return;
    }
  }
  
  public final void a(RewardItemParcel paramRewardItemParcel) {}
  
  public final void a(String paramString) {}
  
  public final void a(String paramString1, String paramString2)
  {
    synchronized (this.b)
    {
      d locald = this.c;
      if (locald == null) {
        return;
      }
      locald.b(paramString1, paramString2);
    }
  }
  
  public final void b()
  {
    synchronized (this.b)
    {
      d locald = this.c;
      if (locald == null) {
        return;
      }
      locald.H();
    }
  }
  
  public final void c()
  {
    synchronized (this.b)
    {
      d locald = this.c;
      if (locald == null) {
        return;
      }
      locald.I();
    }
  }
  
  public final void d()
  {
    synchronized (this.b)
    {
      d locald = this.c;
      if (locald == null) {
        return;
      }
      locald.J();
    }
  }
  
  public final void e()
  {
    synchronized (this.b)
    {
      Object localObject2 = this.a;
      if (localObject2 == null)
      {
        localObject2 = this.c;
        if (localObject2 == null) {
          return;
        }
        ((d)localObject2).K();
      }
    }
    ((j)localObject3).a(0);
    this.a = null;
  }
  
  public final void f()
  {
    synchronized (this.b)
    {
      d locald = this.c;
      if (locald == null) {
        return;
      }
      locald.L();
    }
  }
  
  public final void g()
  {
    synchronized (this.b)
    {
      d locald = this.c;
      if (locald == null) {
        return;
      }
      locald.F();
    }
  }
  
  public final void h() {}
  
  public final void i() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */