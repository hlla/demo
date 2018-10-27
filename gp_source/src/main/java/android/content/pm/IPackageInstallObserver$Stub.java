package android.content.pm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.a.b;

public abstract class IPackageInstallObserver$Stub
  extends b
  implements IPackageInstallObserver
{
  public static final String DESCRIPTOR = "android.content.pm.IPackageInstallObserver";
  public static final int TRANSACTION_packageInstalled = 1;
  
  public IPackageInstallObserver$Stub()
  {
    super("android.content.pm.IPackageInstallObserver");
  }
  
  public static IPackageInstallObserver asInterface(IBinder paramIBinder)
  {
    if (paramIBinder != null)
    {
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.content.pm.IPackageInstallObserver");
      if ((localIInterface instanceof IPackageInstallObserver)) {
        return (IPackageInstallObserver)localIInterface;
      }
      return new IPackageInstallObserver.Stub.Proxy(paramIBinder);
    }
    return null;
  }
  
  protected boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      packageInstalled(paramParcel1.readString(), paramParcel1.readInt());
      return true;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/content/pm/IPackageInstallObserver$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */