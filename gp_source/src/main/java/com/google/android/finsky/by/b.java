package com.google.android.finsky.by;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.gms.b.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.api.t;

public final class b
  implements r, s
{
  public Account a;
  public final Context b;
  public p c;
  
  public b(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public final void a(int paramInt) {}
  
  public final void a(Bundle paramBundle)
  {
    a.a(this.c).a(new c(this));
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    int i = paramConnectionResult.b;
    if ((i != 1) && (i != 2) && (i != 3)) {
      FinskyLog.c("onConnectionFailed result: %s", new Object[] { paramConnectionResult });
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/by/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */