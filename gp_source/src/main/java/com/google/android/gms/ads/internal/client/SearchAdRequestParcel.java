package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public final class SearchAdRequestParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new ck();
  public final String a;
  
  public SearchAdRequestParcel()
  {
    throw new NoSuchMethodError();
  }
  
  SearchAdRequestParcel(String paramString)
  {
    this.a = paramString;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 15, this.a);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/SearchAdRequestParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */