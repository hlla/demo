package a.a.a.a.a.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b
  extends com.google.android.a.b
  implements a
{
  public b()
  {
    super("aidl.com.google.android.finsky.downloadservice.IDownloadService");
  }
  
  public static a a(IBinder paramIBinder)
  {
    if (paramIBinder != null)
    {
      IInterface localIInterface = paramIBinder.queryLocalInterface("aidl.com.google.android.finsky.downloadservice.IDownloadService");
      if ((localIInterface instanceof a)) {
        return (a)localIInterface;
      }
      return new c(paramIBinder);
    }
    return null;
  }
  
  protected boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    paramParcel2 = null;
    switch (paramInt1)
    {
    default: 
      return false;
    case 2: 
      Bundle localBundle = (Bundle)com.google.android.a.c.a(paramParcel1, Bundle.CREATOR);
      IBinder localIBinder = paramParcel1.readStrongBinder();
      paramParcel1 = paramParcel2;
      if (localIBinder != null)
      {
        paramParcel1 = localIBinder.queryLocalInterface("aidl.com.google.android.finsky.downloadservice.IDownloadServiceCallback");
        if (!(paramParcel1 instanceof d)) {
          break label94;
        }
      }
      for (paramParcel1 = (d)paramParcel1;; paramParcel1 = new f(localIBinder))
      {
        a(localBundle, paramParcel1);
        return true;
      }
    case 6: 
      paramInt1 = paramParcel1.readInt();
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 != null)
      {
        paramParcel2 = paramParcel1.queryLocalInterface("aidl.com.google.android.finsky.downloadservice.IDownloadServiceCallback");
        if ((paramParcel2 instanceof d)) {
          paramParcel1 = (d)paramParcel2;
        }
      }
      for (;;)
      {
        c(paramInt1, paramParcel1);
        break;
        paramParcel1 = new f(paramParcel1);
        continue;
        paramParcel1 = null;
      }
    case 5: 
      paramInt1 = paramParcel1.readInt();
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 != null)
      {
        paramParcel2 = paramParcel1.queryLocalInterface("aidl.com.google.android.finsky.downloadservice.IDownloadServiceCallback");
        if ((paramParcel2 instanceof d)) {
          paramParcel1 = (d)paramParcel2;
        }
      }
      for (;;)
      {
        b(paramInt1, paramParcel1);
        break;
        paramParcel1 = new f(paramParcel1);
        continue;
        paramParcel1 = null;
      }
    case 4: 
      label94:
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 != null)
      {
        paramParcel2 = paramParcel1.queryLocalInterface("aidl.com.google.android.finsky.downloadservice.IDownloadServiceCallback");
        if ((paramParcel2 instanceof d)) {
          paramParcel1 = (d)paramParcel2;
        }
      }
      for (;;)
      {
        a(paramParcel1);
        break;
        paramParcel1 = new f(paramParcel1);
        continue;
        paramParcel1 = null;
      }
    }
    paramInt1 = paramParcel1.readInt();
    paramParcel1 = paramParcel1.readStrongBinder();
    if (paramParcel1 != null)
    {
      paramParcel2 = paramParcel1.queryLocalInterface("aidl.com.google.android.finsky.downloadservice.IDownloadServiceCallback");
      if ((paramParcel2 instanceof d)) {
        paramParcel1 = (d)paramParcel2;
      }
    }
    for (;;)
    {
      a(paramInt1, paramParcel1);
      break;
      paramParcel1 = new f(paramParcel1);
      continue;
      paramParcel1 = null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/a/a/a/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */