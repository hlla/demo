package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.internal.formats.a.f;
import com.google.android.gms.dynamic.e;

@com.google.android.gms.ads.internal.q.a.a
public final class h
  extends f
{
  public final Drawable a;
  private final double b;
  private final Uri c;
  
  public h(Drawable paramDrawable, Uri paramUri, double paramDouble)
  {
    this.a = paramDrawable;
    this.c = paramUri;
    this.b = paramDouble;
  }
  
  public final com.google.android.gms.ads.internal.j.a a()
  {
    return e.a(this.a);
  }
  
  public final Uri b()
  {
    return this.c;
  }
  
  public final double c()
  {
    return this.b;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */