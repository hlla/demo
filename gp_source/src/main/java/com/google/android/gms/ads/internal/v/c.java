package com.google.android.gms.ads.internal.v;

import android.os.Bundle;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.g;
import com.google.android.gms.common.util.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@a
public final class c
{
  public long a = -1L;
  public boolean b = false;
  public final Object c = new Object();
  public long d = -1L;
  public final String e;
  public final n f;
  private final LinkedList g;
  private long h = 0L;
  private final b i;
  private long j = -1L;
  private long k = -1L;
  private long l = -1L;
  private final String m;
  
  c(b paramb, n paramn, String paramString1, String paramString2)
  {
    this.i = paramb;
    this.f = paramn;
    this.e = paramString1;
    this.m = paramString2;
    this.g = new LinkedList();
  }
  
  public final void a()
  {
    for (;;)
    {
      j localj;
      synchronized (this.c)
      {
        if (this.d == -1L)
        {
          ??? = this.f;
          synchronized (((n)???).b)
          {
            localj = ((n)???).a;
          }
        }
      }
      synchronized (localj.f)
      {
        localj.e += 1;
        return;
        if (this.j != -1L) {
          continue;
        }
        this.j = this.i.b();
        this.f.a(this);
        continue;
        localObject3 = finally;
        throw ((Throwable)localObject3);
        localObject5 = finally;
        throw ((Throwable)localObject5);
      }
    }
  }
  
  public final void a(long paramLong)
  {
    synchronized (this.c)
    {
      this.d = paramLong;
      if (this.d != -1L) {
        this.f.a(this);
      }
      return;
    }
  }
  
  public final void a(AdRequestParcel paramAdRequestParcel)
  {
    for (;;)
    {
      long l1;
      j localj;
      synchronized (this.c)
      {
        this.l = this.i.b();
        ??? = this.f;
        l1 = this.l;
        synchronized (((n)???).b)
        {
          localj = ((n)???).a;
          synchronized (localj.f)
          {
            long l2 = localj.a.g();
            long l3 = bt.A.l.a();
            if (localj.d == -1L) {
              if (l3 - l2 <= ((Long)com.google.android.gms.ads.internal.f.n.r.a()).longValue())
              {
                localj.h = localj.a.h();
                localj.d = l1;
                localj.c = localj.d;
                break label292;
                label152:
                localj.g += 1;
                localj.h += 1;
                if (localj.h != 0)
                {
                  localj.i = (l3 - localj.a.i());
                  label205:
                  return;
                }
                localj.i = 0L;
                localj.a.b(l3);
              }
            }
          }
        }
      }
      label292:
      do
      {
        paramAdRequestParcel = paramAdRequestParcel.f;
        if ((paramAdRequestParcel == null) || (paramAdRequestParcel.getInt("gw", 2) != 1)) {
          break label152;
        }
        break label205;
        localj.h = -1;
        break;
        localj.c = l1;
      } while (paramAdRequestParcel != null);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    synchronized (this.c)
    {
      if (this.d != -1L)
      {
        this.k = this.i.b();
        if (!paramBoolean)
        {
          this.j = this.k;
          this.f.a(this);
        }
      }
      return;
    }
  }
  
  public final void b()
  {
    j localj;
    synchronized (this.c)
    {
      if (this.d != -1L)
      {
        ??? = new d(this);
        ((d)???).b = ((d)???).c.i.b();
        this.g.add(???);
        this.h += 1L;
        ??? = this.f;
        synchronized (((n)???).b)
        {
          localj = ((n)???).a;
        }
      }
    }
    synchronized (localj.f)
    {
      localj.b += 1;
      this.f.a(this);
      return;
      localObject3 = finally;
      throw ((Throwable)localObject3);
      localObject5 = finally;
      throw ((Throwable)localObject5);
    }
  }
  
  public final void c()
  {
    synchronized (this.c)
    {
      if ((this.d != -1L) && (!this.g.isEmpty()))
      {
        d locald = (d)this.g.getLast();
        if (locald.a == -1L)
        {
          locald.a = locald.c.i.b();
          this.f.a(this);
        }
      }
      return;
    }
  }
  
  public final Bundle d()
  {
    synchronized (this.c)
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("seq_num", this.e);
      localBundle1.putString("slotid", this.m);
      localBundle1.putBoolean("ismediation", this.b);
      localBundle1.putLong("treq", this.l);
      localBundle1.putLong("tresponse", this.d);
      localBundle1.putLong("timp", this.j);
      localBundle1.putLong("tload", this.k);
      localBundle1.putLong("pcc", this.h);
      localBundle1.putLong("tfetch", this.a);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.g.iterator();
      if (!localIterator.hasNext())
      {
        localBundle1.putParcelableArrayList("tclick", localArrayList);
        return localBundle1;
      }
      d locald = (d)localIterator.next();
      Bundle localBundle2 = new Bundle();
      localBundle2.putLong("topen", locald.b);
      localBundle2.putLong("tclose", locald.a);
      localArrayList.add(localBundle2);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/v/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */