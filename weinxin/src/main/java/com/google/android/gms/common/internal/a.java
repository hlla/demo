package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.common.e;

public final class a
  extends p.a
{
  private Account akV;
  int apM;
  private Context mContext;
  
  public static Account b(p paramp)
  {
    Account localAccount = null;
    long l;
    if (paramp != null) {
      l = Binder.clearCallingIdentity();
    }
    try
    {
      localAccount = paramp.jS();
      Binder.restoreCallingIdentity(l);
      return localAccount;
    }
    catch (RemoteException paramp)
    {
      paramp = paramp;
      Binder.restoreCallingIdentity(l);
      return null;
    }
    finally
    {
      paramp = finally;
      Binder.restoreCallingIdentity(l);
      throw paramp;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    return this.akV.equals(((a)paramObject).akV);
  }
  
  public final Account jS()
  {
    int i = Binder.getCallingUid();
    if (i == this.apM) {
      return this.akV;
    }
    if (e.l(this.mContext, i))
    {
      this.apM = i;
      return this.akV;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */