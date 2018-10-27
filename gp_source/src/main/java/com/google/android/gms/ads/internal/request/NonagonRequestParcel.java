package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public class NonagonRequestParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new ak();
  public final ApplicationInfo a;
  public final boolean b;
  public final String c;
  public final List d;
  public final PackageInfo e;
  public final String f;
  public final Bundle g;
  public final VersionInfoParcel h;
  public final String i;
  
  public NonagonRequestParcel(Bundle paramBundle, VersionInfoParcel paramVersionInfoParcel, ApplicationInfo paramApplicationInfo, String paramString1, List paramList, PackageInfo paramPackageInfo, String paramString2, boolean paramBoolean, String paramString3)
  {
    this.g = paramBundle;
    this.h = paramVersionInfoParcel;
    this.f = paramString1;
    this.a = paramApplicationInfo;
    this.d = paramList;
    this.e = paramPackageInfo;
    this.i = paramString2;
    this.b = paramBoolean;
    this.c = paramString3;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 1, this.g);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.h, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.a, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 4, this.f);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 5, this.d);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 6, this.e, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 7, this.i);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 8, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 9, this.c);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, j);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/NonagonRequestParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */