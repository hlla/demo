package android.content.pm;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.a.a;

public class IPackageInstallObserver$Stub$Proxy
  extends a
  implements IPackageInstallObserver
{
  IPackageInstallObserver$Stub$Proxy(IBinder paramIBinder)
  {
    super(paramIBinder, "android.content.pm.IPackageInstallObserver");
  }
  
  public void packageInstalled(String paramString, int paramInt)
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    transactOneway(1, localParcel);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/content/pm/IPackageInstallObserver$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */