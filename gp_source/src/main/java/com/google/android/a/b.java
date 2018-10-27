package com.google.android.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class b
  extends Binder
  implements IInterface
{
  public static d globalInterceptor = null;
  
  public b(String paramString)
  {
    attachInterface(this, paramString);
  }
  
  static void installTransactionInterceptorPackagePrivate(d paramd)
  {
    if (paramd == null) {
      try
      {
        throw new IllegalArgumentException("null interceptor");
      }
      finally {}
    }
    if (globalInterceptor != null) {
      throw new IllegalStateException("Duplicate TransactionInterceptor installation.");
    }
    globalInterceptor = paramd;
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    return false;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (!routeToSuperOrEnforceInterface(paramInt1, paramParcel1, paramParcel2, paramInt2))
    {
      if (globalInterceptor == null) {
        return dispatchTransaction(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      return globalInterceptor.a();
    }
    return true;
  }
  
  protected boolean routeToSuperOrEnforceInterface(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 <= 16777215)
    {
      paramParcel1.enforceInterface(getInterfaceDescriptor());
      return false;
    }
    return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */