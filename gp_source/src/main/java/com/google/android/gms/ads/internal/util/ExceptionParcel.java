package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public class ExceptionParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new as();
  public final int a;
  public final String b;
  
  public ExceptionParcel(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.b = str;
    this.a = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 1, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.a);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/ExceptionParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */