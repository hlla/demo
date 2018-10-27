package android.content.pm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.a.b;
import com.google.android.a.c;

public abstract class IPackageDataObserver$Stub
  extends b
  implements IPackageDataObserver
{
  public static final String DESCRIPTOR = "android.content.pm.IPackageDataObserver";
  public static final int TRANSACTION_onRemoveCompleted = 1;
  
  public IPackageDataObserver$Stub()
  {
    super("android.content.pm.IPackageDataObserver");
  }
  
  public static IPackageDataObserver asInterface(IBinder paramIBinder)
  {
    if (paramIBinder != null)
    {
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.content.pm.IPackageDataObserver");
      if ((localIInterface instanceof IPackageDataObserver)) {
        return (IPackageDataObserver)localIInterface;
      }
      return new IPackageDataObserver.Stub.Proxy(paramIBinder);
    }
    return null;
  }
  
  protected boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      onRemoveCompleted(paramParcel1.readString(), c.a(paramParcel1));
      return true;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/content/pm/IPackageDataObserver$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */