package android.content.pm;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.a.a;
import com.google.android.a.c;

public class IPackageDataObserver$Stub$Proxy
  extends a
  implements IPackageDataObserver
{
  IPackageDataObserver$Stub$Proxy(IBinder paramIBinder)
  {
    super(paramIBinder, "android.content.pm.IPackageDataObserver");
  }
  
  public void onRemoveCompleted(String paramString, boolean paramBoolean)
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeString(paramString);
    c.a(localParcel, paramBoolean);
    transactOneway(1, localParcel);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/content/pm/IPackageDataObserver$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */