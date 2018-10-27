package com.google.android.d;

import android.os.IBinder;
import android.os.Parcel;

public final class c
  extends com.google.android.a.a
  implements a
{
  c(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.nfcprovision.ISchoolOwnedService");
  }
  
  public final boolean a()
  {
    Parcel localParcel = transactAndReadException(1, obtainAndWriteInterfaceToken());
    boolean bool = com.google.android.a.c.a(localParcel);
    localParcel.recycle();
    return bool;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */