package com.google.android.gms.ads.internal.webview;

import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.q.a.a;

@a
public final class au
{
  public final int a;
  public final int b;
  private final int c;
  
  private au(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.b = paramInt2;
    this.a = paramInt3;
  }
  
  public static au a()
  {
    return new au(0, 0, 0);
  }
  
  public static au a(int paramInt1, int paramInt2)
  {
    return new au(1, paramInt1, paramInt2);
  }
  
  public static au a(AdSizeParcel paramAdSizeParcel)
  {
    if (!paramAdSizeParcel.e)
    {
      if (!paramAdSizeParcel.d)
      {
        if (paramAdSizeParcel.f) {
          return a();
        }
        return a(paramAdSizeParcel.j, paramAdSizeParcel.c);
      }
      return new au(2, 0, 0);
    }
    return new au(3, 0, 0);
  }
  
  public static au b()
  {
    return new au(4, 0, 0);
  }
  
  public static au c()
  {
    return new au(5, 0, 0);
  }
  
  public final boolean d()
  {
    return this.c == 2;
  }
  
  public final boolean e()
  {
    return this.c == 3;
  }
  
  public final boolean f()
  {
    return this.c == 0;
  }
  
  public final boolean g()
  {
    return this.c == 4;
  }
  
  public final boolean h()
  {
    return this.c == 5;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/webview/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */