package com.google.android.finsky.l;

import android.accounts.Account;
import android.os.Handler;
import com.android.volley.VolleyError;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.ax;
import com.google.android.finsky.utils.FinskyLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c
{
  public final com.google.android.finsky.accounts.c a;
  public final String b;
  public final com.google.android.finsky.api.i c;
  public final com.google.android.finsky.library.c d;
  public final Handler e;
  public final com.google.android.finsky.dh.a f;
  public final String g;
  private final com.google.android.finsky.e.a h;
  private final Handler i;
  private final com.google.android.finsky.bo.c j;
  private final List k = new ArrayList();
  
  public c(com.google.android.finsky.accounts.c paramc, com.google.android.finsky.library.c paramc1, com.google.android.finsky.dh.a parama, Handler paramHandler1, Handler paramHandler2, String paramString1, String paramString2, com.google.android.finsky.api.i parami, com.google.android.finsky.e.a parama1, com.google.android.finsky.bo.c paramc2)
  {
    this.a = paramc;
    this.d = paramc1;
    this.f = parama;
    this.e = paramHandler1;
    this.i = paramHandler2;
    this.b = paramString1;
    this.g = paramString2;
    this.c = parami;
    this.h = parama1;
    this.j = paramc2;
  }
  
  final int a(Collection paramCollection, int paramInt)
  {
    if (this.j.cY().a(12650364L)) {
      return new HashSet(paramCollection).hashCode() ^ paramInt;
    }
    return paramCollection.hashCode() ^ paramInt;
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == paramInt1) {
      try
      {
        Iterator localIterator = this.k.iterator();
        while (localIterator.hasNext())
        {
          i locali = (i)localIterator.next();
          FinskyLog.a("Completed %d account content syncs with %d successful.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          if (locali != null) {
            this.e.post(new f(locali, paramInt3, paramInt1));
          }
        }
        this.k.clear();
      }
      finally {}
    }
  }
  
  final void a(Account paramAccount, VolleyError paramVolleyError)
  {
    paramAccount = this.h.a(null).a(paramAccount);
    com.google.android.finsky.e.d locald = new com.google.android.finsky.e.d(162);
    if (paramVolleyError != null) {
      ax.a(locald, paramVolleyError, false);
    }
    paramAccount.a(locald);
  }
  
  public final void a(i parami)
  {
    try
    {
      this.k.add(parami);
      if (this.k.size() <= 1) {
        this.i.post(new e(this));
      }
      return;
    }
    finally
    {
      parami = finally;
      throw parami;
    }
  }
  
  public final void a(Runnable paramRunnable)
  {
    this.d.d().a(new d(this, paramRunnable));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/l/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */