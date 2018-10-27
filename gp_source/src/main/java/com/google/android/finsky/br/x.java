package com.google.android.finsky.br;

import android.app.Activity;
import android.content.Intent;
import com.google.android.finsky.accounts.c;
import com.google.android.finsky.ds.a.bu;
import com.google.android.finsky.utils.FinskyLog;
import com.google.wireless.android.finsky.dfe.k.a.d;

final class x
  extends q
{
  public final String a;
  public d b;
  public String c;
  public bu d;
  public final u e;
  public final android.support.v4.g.w f;
  public bu g;
  private final a i;
  
  public x(w paramw, Activity paramActivity)
  {
    String str2 = paramActivity.getIntent().getStringExtra("accountName");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramw.a.cS();
    }
    this.a = str1;
    if (((s)paramActivity).u()) {}
    for (this.i = new a("pfm", "play");; this.i = new a("pfl", "play"))
    {
      this.e = new u(this);
      this.e.a = paramActivity;
      this.f = new android.support.v4.g.w();
      return;
    }
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final String a(int paramInt)
  {
    String str2 = (String)this.f.a(paramInt, null);
    String str1 = str2;
    if (str2 == null)
    {
      FinskyLog.b("Unable to find server text for %d", new Object[] { Integer.valueOf(paramInt) });
      str1 = "";
    }
    return str1;
  }
  
  public final bu b()
  {
    return this.d;
  }
  
  public final d c()
  {
    return this.b;
  }
  
  public final u d()
  {
    return this.e;
  }
  
  public final a e()
  {
    return this.i;
  }
  
  public final bu f()
  {
    return this.g;
  }
  
  public final String g()
  {
    return this.c;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */