package android.content.pm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.a.b;

public abstract class IPackageDeleteObserver$Stub
  extends b
  implements IPackageDeleteObserver
{
  public static final String DESCRIPTOR = "android.content.pm.IPackageDeleteObserver";
  public static final int TRANSACTION_packageDeleted = 1;
  
  public IPackageDeleteObserver$Stub()
  {
    super("android.content.pm.IPackageDeleteObserver");
  }
  
  public static IPackageDeleteObserver asInterface(IBinder paramIBinder)
  {
    if (paramIBinder != null)
    {
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.content.pm.IPackageDeleteObserver");
      if ((localIInterface instanceof IPackageDeleteObserver)) {
        return (IPackageDeleteObserver)localIInterface;
      }
      return new IPackageDeleteObserver.Stub.Proxy(paramIBinder);
    }
    return null;
  }
  
  protected boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      packageDeleted(paramParcel1.readString(), paramParcel1.readInt());
      return true;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/content/pm/IPackageDeleteObserver$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */