package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public final class RewardedVideoAdRequestParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new u();
  public final AdRequestParcel a;
  public final String b;
  
  public RewardedVideoAdRequestParcel(AdRequestParcel paramAdRequestParcel, String paramString)
  {
    this.a = paramAdRequestParcel;
    this.b = paramString;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.a, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.b);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/reward/client/RewardedVideoAdRequestParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */