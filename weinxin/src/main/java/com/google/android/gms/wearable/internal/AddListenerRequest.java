package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AddListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddListenerRequest> CREATOR = new ab();
  public final w aGt;
  public final IntentFilter[] aGu;
  public final String aGv;
  public final String aGw;
  final int mVersionCode;
  
  AddListenerRequest(int paramInt, IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    if (paramIBinder != null) {}
    for (this.aGt = w.a.s(paramIBinder);; this.aGt = null)
    {
      this.aGu = paramArrayOfIntentFilter;
      this.aGv = paramString1;
      this.aGw = paramString2;
      return;
    }
  }
  
  public AddListenerRequest(ap paramap)
  {
    this.mVersionCode = 1;
    this.aGt = paramap;
    this.aGu = paramap.aHP;
    this.aGv = paramap.aHQ;
    this.aGw = paramap.aHR;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ab.a(this, paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/AddListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */