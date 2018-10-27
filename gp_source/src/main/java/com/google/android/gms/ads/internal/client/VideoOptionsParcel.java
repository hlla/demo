package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public class VideoOptionsParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new cm();
  public final boolean a;
  public final boolean b;
  public final boolean c;
  
  public VideoOptionsParcel(p paramp)
  {
    this(paramp.c, paramp.b, paramp.a);
  }
  
  public VideoOptionsParcel(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.c = paramBoolean1;
    this.b = paramBoolean2;
    this.a = paramBoolean3;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.c);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 4, this.a);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/VideoOptionsParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */