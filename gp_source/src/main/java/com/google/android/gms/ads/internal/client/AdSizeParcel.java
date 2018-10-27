package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.g;
import com.google.android.gms.ads.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@com.google.android.gms.ads.internal.q.a.a
public class AdSizeParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new k();
  public final String a;
  public final int b;
  public final int c;
  public final boolean d;
  public final boolean e;
  public final boolean f;
  public boolean g;
  public final AdSizeParcel[] h;
  public final int i;
  public final int j;
  
  public AdSizeParcel()
  {
    this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
  }
  
  public AdSizeParcel(Context paramContext, g paramg)
  {
    this(paramContext, new g[] { paramg });
  }
  
  public AdSizeParcel(Context paramContext, g[] paramArrayOfg)
  {
    Object localObject = paramArrayOfg[0];
    this.e = false;
    int k = ((g)localObject).c;
    boolean bool;
    if (k == -3) {
      if (((g)localObject).b == -4) {
        bool = true;
      }
    }
    for (;;)
    {
      this.d = bool;
      if (this.d) {
        this.i = g.a.c;
      }
      for (this.b = g.a.b;; this.b = ((g)localObject).b)
      {
        int n = this.i;
        int i1 = this.b;
        DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        if (n != -1)
        {
          k = this.i;
          locala = u.h.a;
          this.j = com.google.android.gms.ads.internal.util.client.a.a(localDisplayMetrics, this.i);
          if (i1 != -2) {}
          for (int m = this.b;; m = c(localDisplayMetrics))
          {
            locala = u.h.a;
            this.c = com.google.android.gms.ads.internal.util.client.a.a(localDisplayMetrics, m);
            if (n == -1)
            {
              localObject = new StringBuilder(26);
              ((StringBuilder)localObject).append(k);
              ((StringBuilder)localObject).append("x");
              ((StringBuilder)localObject).append(m);
              ((StringBuilder)localObject).append("_as");
              this.a = ((StringBuilder)localObject).toString();
            }
            for (;;)
            {
              k = paramArrayOfg.length;
              if (k > 1)
              {
                this.h = new AdSizeParcel[k];
                k = 0;
                while (k < paramArrayOfg.length)
                {
                  this.h[k] = new AdSizeParcel(paramContext, paramArrayOfg[k]);
                  k += 1;
                }
              }
              this.h = null;
              this.f = false;
              this.g = false;
              return;
              if (i1 == -2) {
                break;
              }
              if (this.d) {
                this.a = "320x50_mb";
              } else {
                this.a = ((g)localObject).toString();
              }
            }
          }
        }
        com.google.android.gms.ads.internal.util.client.a locala = u.h.a;
        if (com.google.android.gms.ads.internal.util.client.a.d(paramContext))
        {
          locala = u.h.a;
          if (com.google.android.gms.ads.internal.util.client.a.e(paramContext))
          {
            k = localDisplayMetrics.widthPixels;
            locala = u.h.a;
          }
        }
        for (this.j = (k - com.google.android.gms.ads.internal.util.client.a.f(paramContext));; this.j = localDisplayMetrics.widthPixels)
        {
          double d1 = this.j / localDisplayMetrics.density;
          k = (int)d1;
          if (d1 - k >= 0.01D)
          {
            k += 1;
            break;
          }
          break;
        }
        this.i = k;
      }
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public AdSizeParcel(AdSizeParcel paramAdSizeParcel, AdSizeParcel[] paramArrayOfAdSizeParcel)
  {
    this(paramAdSizeParcel.a, paramAdSizeParcel.b, paramAdSizeParcel.c, paramAdSizeParcel.e, paramAdSizeParcel.i, paramAdSizeParcel.j, paramArrayOfAdSizeParcel, paramAdSizeParcel.f, paramAdSizeParcel.d, paramAdSizeParcel.g);
  }
  
  AdSizeParcel(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, AdSizeParcel[] paramArrayOfAdSizeParcel, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.e = paramBoolean1;
    this.i = paramInt3;
    this.j = paramInt4;
    this.h = paramArrayOfAdSizeParcel;
    this.f = paramBoolean2;
    this.d = paramBoolean3;
    this.g = paramBoolean4;
  }
  
  public static int a(DisplayMetrics paramDisplayMetrics)
  {
    return paramDisplayMetrics.widthPixels;
  }
  
  public static AdSizeParcel a()
  {
    return new AdSizeParcel("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
  }
  
  public static int b(DisplayMetrics paramDisplayMetrics)
  {
    return (int)(c(paramDisplayMetrics) * paramDisplayMetrics.density);
  }
  
  public static AdSizeParcel b()
  {
    return new AdSizeParcel("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
  }
  
  private static int c(DisplayMetrics paramDisplayMetrics)
  {
    int k = (int)(paramDisplayMetrics.heightPixels / paramDisplayMetrics.density);
    if (k > 400)
    {
      if (k > 720) {
        return 90;
      }
      return 50;
    }
    return 32;
  }
  
  public final g c()
  {
    return h.a(this.i, this.b, this.a);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.a);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 4, this.c);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 5, this.e);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 6, this.i);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 7, this.j);
    AdSizeParcel[] arrayOfAdSizeParcel = this.h;
    if (arrayOfAdSizeParcel != null)
    {
      int n = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 8);
      int i1 = arrayOfAdSizeParcel.length;
      paramParcel.writeInt(i1);
      int k = 0;
      if (k < i1)
      {
        AdSizeParcel localAdSizeParcel = arrayOfAdSizeParcel[k];
        if (localAdSizeParcel == null) {
          paramParcel.writeInt(0);
        }
        for (;;)
        {
          k += 1;
          break;
          int i2 = paramParcel.dataPosition();
          paramParcel.writeInt(1);
          int i3 = paramParcel.dataPosition();
          localAdSizeParcel.writeToParcel(paramParcel, paramInt);
          int i4 = paramParcel.dataPosition();
          paramParcel.setDataPosition(i2);
          paramParcel.writeInt(i4 - i3);
          paramParcel.setDataPosition(i4);
        }
      }
      com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, n);
    }
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 9, this.f);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 10, this.d);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 11, this.g);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/client/AdSizeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */