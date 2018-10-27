package com.google.android.f.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.a.a;
import com.google.android.a.c;

public final class h
  extends a
  implements f
{
  h(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.vending.verifier.IVerifyAppsDataCallback");
  }
  
  public final void a(boolean paramBoolean, Bundle paramBundle)
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    c.a(localParcel, paramBoolean);
    c.a(localParcel, paramBundle);
    transactOneway(1, localParcel);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/f/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */