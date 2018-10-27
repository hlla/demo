package com.google.android.f.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.a.b;

public abstract class e
  extends b
  implements d
{
  public e()
  {
    super("com.google.android.vending.verifier.IPackageVerificationApiService");
  }
  
  protected boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    paramParcel2 = null;
    switch (paramInt1)
    {
    default: 
      return false;
    case 1: 
      localObject = paramParcel1.readStrongBinder();
      paramParcel1 = paramParcel2;
      if (localObject != null)
      {
        paramParcel1 = ((IBinder)localObject).queryLocalInterface("com.google.android.vending.verifier.IListHarmfulAppsCallback");
        if (!(paramParcel1 instanceof a)) {
          break label76;
        }
      }
      for (paramParcel1 = (a)paramParcel1;; paramParcel1 = new c((IBinder)localObject))
      {
        a(paramParcel1);
        return true;
      }
    case 3: 
      label76:
      paramParcel2 = paramParcel1.readStrongBinder();
      if (paramParcel2 != null)
      {
        localObject = paramParcel2.queryLocalInterface("com.google.android.vending.verifier.IVerifyAppsDataCallback");
        if ((localObject instanceof f)) {
          paramParcel2 = (f)localObject;
        }
      }
      for (;;)
      {
        a(paramParcel2, (Bundle)com.google.android.a.c.a(paramParcel1, Bundle.CREATOR));
        break;
        paramParcel2 = new h(paramParcel2);
        continue;
        paramParcel2 = null;
      }
    }
    IBinder localIBinder = paramParcel1.readStrongBinder();
    paramParcel2 = (Parcel)localObject;
    if (localIBinder != null)
    {
      paramParcel2 = localIBinder.queryLocalInterface("com.google.android.vending.verifier.IVerifyAppsDataCallback");
      if (!(paramParcel2 instanceof f)) {
        break label205;
      }
    }
    label205:
    for (paramParcel2 = (f)paramParcel2;; paramParcel2 = new h(localIBinder))
    {
      a(paramParcel2, paramParcel1.readLong());
      break;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/f/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */