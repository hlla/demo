package a.a.a.a.a.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class c
  extends com.google.android.a.a
  implements a
{
  c(IBinder paramIBinder)
  {
    super(paramIBinder, "aidl.com.google.android.finsky.downloadservice.IDownloadService");
  }
  
  public final void a(int paramInt, d paramd)
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    com.google.android.a.c.a(localParcel, paramd);
    transactOneway(3, localParcel);
  }
  
  public final void a(d paramd)
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    com.google.android.a.c.a(localParcel, paramd);
    transactOneway(4, localParcel);
  }
  
  public final void a(Bundle paramBundle, d paramd)
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    com.google.android.a.c.a(localParcel, paramBundle);
    com.google.android.a.c.a(localParcel, paramd);
    transactOneway(2, localParcel);
  }
  
  public final void b(int paramInt, d paramd)
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    com.google.android.a.c.a(localParcel, paramd);
    transactOneway(5, localParcel);
  }
  
  public final void c(int paramInt, d paramd)
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeInt(paramInt);
    com.google.android.a.c.a(localParcel, paramd);
    transactOneway(6, localParcel);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/a/a/a/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */