package com.google.android.gms.ads.internal.v;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.b.d;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.g;
import com.google.android.gms.common.util.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

@a
public final class n
  implements d
{
  public final j a;
  public final Object b = new Object();
  public final HashSet c = new HashSet();
  private final g d;
  private final HashSet e = new HashSet();
  private final l f;
  
  public n(String paramString, g paramg)
  {
    this.a = new j(paramString, paramg);
    this.d = paramg;
    this.f = new l();
  }
  
  public final Bundle a(Context paramContext, k paramk)
  {
    HashSet localHashSet = new HashSet();
    synchronized (this.b)
    {
      localHashSet.addAll(this.e);
      this.e.clear();
      ??? = new Bundle();
      ((Bundle)???).putBundle("app", this.a.a(paramContext, this.f.b()));
      paramContext = new Bundle();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        m localm = (m)localIterator.next();
        paramContext.putBundle(localm.d, localm.a());
      }
      ((Bundle)???).putBundle("slots", paramContext);
      paramContext = new ArrayList();
      localIterator = localHashSet.iterator();
      while (localIterator.hasNext()) {
        paramContext.add(((c)localIterator.next()).d());
      }
      ((Bundle)???).putParcelableArrayList("ads", paramContext);
      paramk.a(localHashSet);
      return (Bundle)???;
    }
  }
  
  public final c a(b paramb, String paramString)
  {
    return new c(paramb, this, this.f.a(), paramString);
  }
  
  public final void a(c paramc)
  {
    synchronized (this.b)
    {
      this.e.add(paramc);
      return;
    }
  }
  
  public final void a(HashSet paramHashSet)
  {
    synchronized (this.b)
    {
      this.e.addAll(paramHashSet);
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    long l = bt.A.l.a();
    if (paramBoolean)
    {
      if (l - this.d.g() > ((Long)com.google.android.gms.ads.internal.f.n.r.a()).longValue())
      {
        this.a.h = -1;
        return;
      }
      this.a.h = this.d.h();
      return;
    }
    this.d.a(l);
    this.d.b(this.a.h);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/v/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */