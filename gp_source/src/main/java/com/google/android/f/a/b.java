package com.google.android.f.a;

import android.os.IBinder;
import android.os.IInterface;

public abstract class b
  extends com.google.android.a.b
  implements a
{
  public static a a(IBinder paramIBinder)
  {
    if (paramIBinder != null)
    {
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.vending.verifier.IListHarmfulAppsCallback");
      if ((localIInterface instanceof a)) {
        return (a)localIInterface;
      }
      return new c(paramIBinder);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/f/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */