package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public final class AdLauncherIntentInfoParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new b();
  public final String a;
  public final Intent b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  private final String g;
  private final String h;
  
  public AdLauncherIntentInfoParcel(Intent paramIntent)
  {
    this(null, null, null, null, null, null, null, paramIntent);
  }
  
  public AdLauncherIntentInfoParcel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, null);
  }
  
  public AdLauncherIntentInfoParcel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Intent paramIntent)
  {
    this.g = paramString1;
    this.f = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.a = paramString5;
    this.c = paramString6;
    this.h = paramString7;
    this.b = paramIntent;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.g);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.f);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 4, this.d);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 5, this.e);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 6, this.a);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 7, this.c);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 8, this.h);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 9, this.b, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/overlay/AdLauncherIntentInfoParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */