package com.google.android.f.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.a.b;
import com.google.android.a.c;

public abstract class g
  extends b
  implements f
{
  public g()
  {
    super("com.google.android.vending.verifier.IVerifyAppsDataCallback");
  }
  
  public static f a(IBinder paramIBinder)
  {
    if (paramIBinder != null)
    {
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.vending.verifier.IVerifyAppsDataCallback");
      if ((localIInterface instanceof f)) {
        return (f)localIInterface;
      }
      return new h(paramIBinder);
    }
    return null;
  }
  
  protected boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      a(c.a(paramParcel1), (Bundle)c.a(paramParcel1, Bundle.CREATOR));
      return true;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/f/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */