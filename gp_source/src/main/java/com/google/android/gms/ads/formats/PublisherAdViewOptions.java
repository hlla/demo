package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.au;
import com.google.android.gms.ads.internal.client.av;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public final class PublisherAdViewOptions
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new q();
  public final au a;
  public final boolean b;
  
  PublisherAdViewOptions(boolean paramBoolean, IBinder paramIBinder)
  {
    this.b = paramBoolean;
    if (paramIBinder != null) {}
    for (paramIBinder = av.a(paramIBinder);; paramIBinder = null)
    {
      this.a = paramIBinder;
      return;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 1, this.b);
    Object localObject = this.a;
    if (localObject != null) {}
    for (localObject = ((au)localObject).asBinder();; localObject = null)
    {
      com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, (IBinder)localObject);
      com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/formats/PublisherAdViewOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */