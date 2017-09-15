package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RemoveListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RemoveListenerRequest> CREATOR = new ah();
  public final w aGt;
  final int mVersionCode;
  
  RemoveListenerRequest(int paramInt, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    if (paramIBinder != null)
    {
      this.aGt = w.a.s(paramIBinder);
      return;
    }
    this.aGt = null;
  }
  
  public RemoveListenerRequest(w paramw)
  {
    this.mVersionCode = 1;
    this.aGt = paramw;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ah.a(this, paramParcel);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/RemoveListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */