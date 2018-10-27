package com.google.android.gms.ads.internal.mediation.client.rtb;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public final class RtbVersionInfoParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new v();
  private final int a;
  private final int b;
  private final int c;
  
  RtbVersionInfoParcel(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.c = paramInt2;
    this.b = paramInt3;
  }
  
  public static RtbVersionInfoParcel a()
  {
    throw new NoSuchMethodError();
  }
  
  public final String toString()
  {
    int i = this.a;
    int j = this.c;
    int k = this.b;
    StringBuilder localStringBuilder = new StringBuilder(35);
    localStringBuilder.append(i);
    localStringBuilder.append(".");
    localStringBuilder.append(j);
    localStringBuilder.append(".");
    localStringBuilder.append(k);
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 1, this.a);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.c);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.b);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/client/rtb/RtbVersionInfoParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */