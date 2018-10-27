package com.google.android.finsky.a;

import android.accounts.Account;
import com.google.android.finsky.accounts.b;

final class d
  implements b
{
  d(a parama) {}
  
  public final void a(Account paramAccount)
  {
    if (this.a.k == 2)
    {
      if ((paramAccount != null) && (paramAccount.name.equals(this.a.i.b)))
      {
        paramAccount = this.a;
        paramAccount.k = 3;
        paramAccount.a(4053);
      }
    }
    else {
      return;
    }
    this.a.b();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */