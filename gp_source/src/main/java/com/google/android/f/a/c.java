package com.google.android.f.a;

import android.os.IBinder;
import android.os.Parcel;

public final class c
  extends com.google.android.a.a
  implements a
{
  c(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.vending.verifier.IListHarmfulAppsCallback");
  }
  
  public final void a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    com.google.android.a.c.a(localParcel, paramBoolean);
    localParcel.writeByteArray(paramArrayOfByte);
    transactOneway(1, localParcel);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/f/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */