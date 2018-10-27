package android.content.pm;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.a.a;

public class IPackageDeleteObserver$Stub$Proxy
  extends a
  implements IPackageDeleteObserver
{
  IPackageDeleteObserver$Stub$Proxy(IBinder paramIBinder)
  {
    super(paramIBinder, "android.content.pm.IPackageDeleteObserver");
  }
  
  public void packageDeleted(String paramString, int paramInt)
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    localParcel.writeInt(paramInt);
    transactOneway(1, localParcel);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/content/pm/IPackageDeleteObserver$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */