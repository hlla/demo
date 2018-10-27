package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public final class VersionInfoParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new n();
  public String a;
  public int b;
  public int c;
  public boolean d;
  public boolean e;
  
  public VersionInfoParcel(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramInt1, paramInt2, paramBoolean, false);
  }
  
  private VersionInfoParcel(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public VersionInfoParcel(int paramInt, boolean paramBoolean)
  {
    this(12451000, paramInt, true, paramBoolean);
  }
  
  VersionInfoParcel(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  public static VersionInfoParcel a()
  {
    return new VersionInfoParcel(12451009, 12451009, true);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.a);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 4, this.c);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 5, this.d);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 6, this.e);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/client/VersionInfoParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */