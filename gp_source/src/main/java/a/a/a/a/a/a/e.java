package a.a.a.a.a.a;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.a.b;
import com.google.android.a.c;

public abstract class e
  extends b
  implements d
{
  public e()
  {
    super("aidl.com.google.android.finsky.downloadservice.IDownloadServiceCallback");
  }
  
  protected boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 2: 
      a((Bundle)c.a(paramParcel1, Bundle.CREATOR));
    }
    for (;;)
    {
      return true;
      f((Bundle)c.a(paramParcel1, Bundle.CREATOR));
      continue;
      e((Bundle)c.a(paramParcel1, Bundle.CREATOR));
      continue;
      d((Bundle)c.a(paramParcel1, Bundle.CREATOR));
      continue;
      c((Bundle)c.a(paramParcel1, Bundle.CREATOR));
      continue;
      b((Bundle)c.a(paramParcel1, Bundle.CREATOR));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/a/a/a/a/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */