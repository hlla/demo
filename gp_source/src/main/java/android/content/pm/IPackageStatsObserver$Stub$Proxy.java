package android.content.pm;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.a.a;
import com.google.android.a.c;

public class IPackageStatsObserver$Stub$Proxy
  extends a
  implements IPackageStatsObserver
{
  IPackageStatsObserver$Stub$Proxy(IBinder paramIBinder)
  {
    super(paramIBinder, "android.content.pm.IPackageStatsObserver");
  }
  
  public void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean)
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    c.a(localParcel, paramPackageStats);
    c.a(localParcel, paramBoolean);
    transactOneway(1, localParcel);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/content/pm/IPackageStatsObserver$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */