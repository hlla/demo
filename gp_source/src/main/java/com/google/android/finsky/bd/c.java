package com.google.android.finsky.bd;

import android.accounts.Account;
import android.support.v4.app.Fragment;
import com.google.android.finsky.bc.b.a;
import com.google.android.finsky.be.e;
import com.google.android.finsky.be.k;
import com.google.android.finsky.be.n;
import com.google.android.finsky.billing.j.f;

public final class c
{
  public final Account a;
  public final int b;
  public final String c;
  public final k d;
  public final n e;
  private final e f;
  private final com.google.android.finsky.bc.b.b g;
  
  public c(Account paramAccount, int paramInt, String paramString, e parame, k paramk, n paramn, com.google.android.finsky.bc.b.b paramb)
  {
    this.a = paramAccount;
    this.b = paramInt;
    this.c = paramString;
    this.f = parame;
    this.d = paramk;
    this.e = paramn;
    this.g = paramb;
  }
  
  public final void a(Fragment paramFragment)
  {
    if ((paramFragment instanceof a))
    {
      com.google.android.finsky.bc.b.b localb = this.g;
      if (localb != null) {
        ((a)paramFragment).ac = localb;
      }
      if ((paramFragment instanceof com.google.android.finsky.billing.g.c)) {
        ((com.google.android.finsky.billing.g.c)paramFragment).b = this.f;
      }
      if ((paramFragment instanceof com.google.android.finsky.billing.j.b)) {
        ((com.google.android.finsky.billing.j.b)paramFragment).b = this.d;
      }
      if ((paramFragment instanceof f)) {
        ((f)paramFragment).a = this.d;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bd/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */