package com.google.android.finsky.be;

import android.accounts.Account;
import com.google.android.finsky.e.af;
import com.google.android.finsky.installer.p;
import com.google.android.finsky.installqueue.InstallRequest;
import com.google.android.finsky.installqueue.g;

public final class f
{
  public final Account a;
  public final com.google.android.finsky.billing.lightpurchase.f b;
  public final com.google.android.finsky.bj.a c;
  public InstallRequest d;
  public final k e;
  public final com.google.android.finsky.bo.f f;
  public final n g;
  public final p h;
  public final af i;
  private final g j;
  
  public f(Account paramAccount, com.google.android.finsky.billing.lightpurchase.f paramf, com.google.android.finsky.bj.a parama, com.google.android.finsky.bo.f paramf1, n paramn, k paramk, p paramp, g paramg, af paramaf, com.google.android.finsky.de.a parama1)
  {
    this.a = paramAccount;
    this.b = paramf;
    this.c = parama;
    this.e = paramk;
    this.f = paramf1;
    this.g = paramn;
    this.h = paramp;
    this.j = paramg;
    this.i = paramaf;
  }
  
  public final void a(InstallRequest paramInstallRequest)
  {
    if (this.f.a(12643667L))
    {
      com.google.android.finsky.billing.lightpurchase.f localf = this.b;
      if ((localf != null) && (a.class.isInstance(localf)))
      {
        ((a)this.b).a(paramInstallRequest, this.i);
        return;
      }
    }
    this.j.a(paramInstallRequest);
  }
  
  public final boolean a()
  {
    return this.e.b == 3;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */