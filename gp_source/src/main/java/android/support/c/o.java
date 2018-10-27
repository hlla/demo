package android.support.c;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class o
  extends Binder
  implements n
{
  public o()
  {
    attachInterface(this, "android.support.customtabs.ICustomTabsCallback");
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 2: 
      paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramInt1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 1598968902: 
      paramParcel2.writeString("android.support.customtabs.ICustomTabsCallback");
      return true;
    case 6: 
      paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (localObject = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);; localObject = null)
      {
        if (paramParcel1.readInt() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          if (paramParcel1.readInt() != 0) {}
          for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
          {
            a(paramInt1, (Uri)localObject, bool, paramParcel1);
            paramParcel2.writeNoException();
            return true;
          }
        }
      }
    case 5: 
      paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
      localObject = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        b((String)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 4: 
      paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
    paramParcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
    Object localObject = paramParcel1.readString();
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a((String)localObject, paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/c/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */