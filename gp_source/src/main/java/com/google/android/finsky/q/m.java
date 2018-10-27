package com.google.android.finsky.q;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.o;
import com.google.android.finsky.e.d;
import com.google.android.finsky.e.i;
import com.google.android.finsky.e.u;
import com.google.android.finsky.utils.FinskyLog;
import java.io.IOException;

final class m
  implements AccountManagerCallback
{
  m(a parama) {}
  
  public final void run(AccountManagerFuture paramAccountManagerFuture)
  {
    d locald = new d(528);
    ((i)this.a.T.a()).cV().a(locald.a);
    try
    {
      paramAccountManagerFuture = (Intent)((Bundle)paramAccountManagerFuture.getResult()).getParcelable("intent");
      this.a.startActivityForResult(paramAccountManagerFuture, 21);
      this.a.ax = true;
      return;
    }
    catch (OperationCanceledException paramAccountManagerFuture)
    {
      FinskyLog.c("Account add canceled. Finishing.", new Object[0]);
      this.a.finish();
      return;
    }
    catch (IOException paramAccountManagerFuture)
    {
      FinskyLog.c("IOException while adding account: %s. Finishing.", new Object[] { paramAccountManagerFuture });
      this.a.finish();
      return;
    }
    catch (AuthenticatorException paramAccountManagerFuture)
    {
      FinskyLog.c("AuthenticatorException while adding account: %s. Finishing.", new Object[] { paramAccountManagerFuture });
      this.a.finish();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/q/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */