package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.gmsg.d;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.webview.i;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.e;

@com.google.android.gms.ads.internal.q.a.a
public final class AdOverlayInfoParcel
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator CREATOR = new j();
  public final com.google.android.gms.ads.internal.client.a a;
  public final AdLauncherIntentInfoParcel b;
  public final com.google.android.gms.ads.internal.gmsg.b c;
  public final k d;
  public final i e;
  public final d f;
  public final String g;
  public final boolean h;
  public final String i;
  public final String j;
  public final InterstitialAdParameterParcel k;
  public final q l;
  public final int m;
  public final int n;
  public final String o;
  public final VersionInfoParcel p;
  
  public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.a parama, k paramk, com.google.android.gms.ads.internal.gmsg.b paramb, d paramd, q paramq, i parami, boolean paramBoolean, int paramInt, String paramString, VersionInfoParcel paramVersionInfoParcel)
  {
    this.b = null;
    this.a = parama;
    this.d = paramk;
    this.e = parami;
    this.c = paramb;
    this.f = paramd;
    this.g = null;
    this.h = paramBoolean;
    this.j = null;
    this.l = paramq;
    this.m = paramInt;
    this.n = 3;
    this.o = paramString;
    this.p = paramVersionInfoParcel;
    this.i = null;
    this.k = null;
  }
  
  public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.a parama, k paramk, com.google.android.gms.ads.internal.gmsg.b paramb, d paramd, q paramq, i parami, boolean paramBoolean, int paramInt, String paramString1, String paramString2, VersionInfoParcel paramVersionInfoParcel)
  {
    this.b = null;
    this.a = parama;
    this.d = paramk;
    this.e = parami;
    this.c = paramb;
    this.f = paramd;
    this.g = paramString2;
    this.h = paramBoolean;
    this.j = paramString1;
    this.l = paramq;
    this.m = paramInt;
    this.n = 3;
    this.o = null;
    this.p = paramVersionInfoParcel;
    this.i = null;
    this.k = null;
  }
  
  public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.a parama, k paramk, q paramq, i parami, int paramInt, VersionInfoParcel paramVersionInfoParcel, String paramString, InterstitialAdParameterParcel paramInterstitialAdParameterParcel)
  {
    this.b = null;
    this.a = parama;
    this.d = paramk;
    this.e = parami;
    this.c = null;
    this.f = null;
    this.g = null;
    this.h = false;
    this.j = null;
    this.l = paramq;
    this.m = paramInt;
    this.n = 1;
    this.o = null;
    this.p = paramVersionInfoParcel;
    this.i = paramString;
    this.k = paramInterstitialAdParameterParcel;
  }
  
  public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.a parama, k paramk, q paramq, i parami, boolean paramBoolean, int paramInt, VersionInfoParcel paramVersionInfoParcel)
  {
    this.b = null;
    this.a = parama;
    this.d = paramk;
    this.e = parami;
    this.c = null;
    this.f = null;
    this.g = null;
    this.h = paramBoolean;
    this.j = null;
    this.l = paramq;
    this.m = paramInt;
    this.n = 2;
    this.o = null;
    this.p = paramVersionInfoParcel;
    this.i = null;
    this.k = null;
  }
  
  AdOverlayInfoParcel(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt1, int paramInt2, String paramString3, VersionInfoParcel paramVersionInfoParcel, String paramString4, InterstitialAdParameterParcel paramInterstitialAdParameterParcel, IBinder paramIBinder6)
  {
    this.b = paramAdLauncherIntentInfoParcel;
    this.a = ((com.google.android.gms.ads.internal.client.a)e.a(com.google.android.gms.dynamic.b.a(paramIBinder1)));
    this.d = ((k)e.a(com.google.android.gms.dynamic.b.a(paramIBinder2)));
    this.e = ((i)e.a(com.google.android.gms.dynamic.b.a(paramIBinder3)));
    this.c = ((com.google.android.gms.ads.internal.gmsg.b)e.a(com.google.android.gms.dynamic.b.a(paramIBinder6)));
    this.f = ((d)e.a(com.google.android.gms.dynamic.b.a(paramIBinder4)));
    this.g = paramString1;
    this.h = paramBoolean;
    this.j = paramString2;
    this.l = ((q)e.a(com.google.android.gms.dynamic.b.a(paramIBinder5)));
    this.m = paramInt1;
    this.n = paramInt2;
    this.o = paramString3;
    this.p = paramVersionInfoParcel;
    this.i = paramString4;
    this.k = paramInterstitialAdParameterParcel;
  }
  
  public AdOverlayInfoParcel(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, com.google.android.gms.ads.internal.client.a parama, k paramk, q paramq, VersionInfoParcel paramVersionInfoParcel)
  {
    this.b = paramAdLauncherIntentInfoParcel;
    this.a = parama;
    this.d = paramk;
    this.e = null;
    this.c = null;
    this.f = null;
    this.g = null;
    this.h = false;
    this.j = null;
    this.l = paramq;
    this.m = -1;
    this.n = 4;
    this.o = null;
    this.p = paramVersionInfoParcel;
    this.i = null;
    this.k = null;
  }
  
  public static AdOverlayInfoParcel a(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      paramIntent.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
      paramIntent = (AdOverlayInfoParcel)paramIntent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public static void a(Intent paramIntent, AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramAdOverlayInfoParcel);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.b, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, e.a(this.a).asBinder());
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 4, e.a(this.d).asBinder());
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 5, e.a(this.e).asBinder());
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 6, e.a(this.f).asBinder());
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 7, this.g);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 8, this.h);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 9, this.j);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 10, e.a(this.l).asBinder());
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 11, this.m);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 12, this.n);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 13, this.o);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 14, this.p, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 16, this.i);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 17, this.k, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 18, e.a(this.c).asBinder());
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i1);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/overlay/AdOverlayInfoParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */