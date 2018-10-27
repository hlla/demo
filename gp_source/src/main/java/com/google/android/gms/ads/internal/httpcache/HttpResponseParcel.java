package com.google.android.gms.ads.internal.httpcache;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public class HttpResponseParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new c();
  public final byte[] a;
  public final String b;
  public final boolean c;
  public final String[] d;
  public final String[] e;
  public final long f;
  public final boolean g;
  public final int h;
  
  HttpResponseParcel(boolean paramBoolean1, String paramString, int paramInt, byte[] paramArrayOfByte, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean2, long paramLong)
  {
    this.c = paramBoolean1;
    this.b = paramString;
    this.h = paramInt;
    this.a = paramArrayOfByte;
    this.d = paramArrayOfString1;
    this.e = paramArrayOfString2;
    this.g = paramBoolean2;
    this.f = paramLong;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 1, this.c);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.h);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 4, this.a);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 5, this.d);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 6, this.e);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 7, this.g);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 8, this.f);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/httpcache/HttpResponseParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */