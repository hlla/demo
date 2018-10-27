package android.content.pm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.a.b;
import com.google.android.a.c;

public abstract class IPackageStatsObserver$Stub
  extends b
  implements IPackageStatsObserver
{
  public static final String DESCRIPTOR = "android.content.pm.IPackageStatsObserver";
  public static final int TRANSACTION_onGetStatsCompleted = 1;
  
  public IPackageStatsObserver$Stub()
  {
    super("android.content.pm.IPackageStatsObserver");
  }
  
  public static IPackageStatsObserver asInterface(IBinder paramIBinder)
  {
    if (paramIBinder != null)
    {
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.content.pm.IPackageStatsObserver");
      if ((localIInterface instanceof IPackageStatsObserver)) {
        return (IPackageStatsObserver)localIInterface;
      }
      return new IPackageStatsObserver.Stub.Proxy(paramIBinder);
    }
    return null;
  }
  
  protected boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      onGetStatsCompleted((PackageStats)c.a(paramParcel1, PackageStats.CREATOR), c.a(paramParcel1));
      return true;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/content/pm/IPackageStatsObserver$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */