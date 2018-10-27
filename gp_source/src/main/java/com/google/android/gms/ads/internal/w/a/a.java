package com.google.android.gms.ads.internal.w.a;

import android.annotation.TargetApi;
import com.google.android.gms.ads.exoplayer1.ab;
import com.google.android.gms.ads.exoplayer1.af;
import com.google.android.gms.ads.exoplayer1.ah;
import com.google.android.gms.ads.exoplayer1.f;
import com.google.android.gms.ads.exoplayer1.g;
import com.google.android.gms.ads.exoplayer1.l;
import com.google.android.gms.ads.exoplayer1.o;
import com.google.android.gms.ads.exoplayer1.x;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.common.internal.z;
import java.lang.ref.WeakReference;

@com.google.android.gms.ads.internal.q.a.a
@TargetApi(16)
public final class a
{
  public static int b;
  public static int d;
  public l a;
  public com.google.android.gms.ads.exoplayer1.d c;
  public x e;
  private final b f = new b(this);
  private final c g = new c(this);
  private d h;
  private final e i = new e(this);
  
  public a()
  {
    z.a("ExoPlayer must be created on the main UI thread.");
    if (com.google.android.gms.ads.internal.util.e.a())
    {
      String str = String.valueOf(this);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 29);
      localStringBuilder.append("AdExoPlayerHelper initialize ");
      localStringBuilder.append(str);
      com.google.android.gms.ads.internal.util.e.a(localStringBuilder.toString());
    }
    b += 1;
    this.c = new g();
    this.c.a(this.g);
  }
  
  public final void a()
  {
    com.google.android.gms.ads.exoplayer1.d locald = this.c;
    if (locald != null)
    {
      locald.d();
      this.c = null;
      d -= 1;
    }
  }
  
  public final void a(f paramf, ab paramab, o paramo)
  {
    this.g.a = new WeakReference(paramf);
    this.i.a = new WeakReference(paramab);
    this.f.a = new WeakReference(paramo);
  }
  
  public final void a(d paramd)
  {
    try
    {
      this.h = paramd;
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  final void a(String paramString1, String paramString2)
  {
    try
    {
      d locald = this.h;
      if (locald != null) {
        locald.a(paramString1, paramString2);
      }
      return;
    }
    finally {}
  }
  
  public final boolean a(af paramaf)
  {
    if (this.c != null)
    {
      this.e = new x(paramaf, n.a, this.i);
      this.a = new l(paramaf, n.a, this.f);
      paramaf = this.e;
      l locall = this.a;
      this.c.a(new ah[] { paramaf, locall });
      d += 1;
      return true;
    }
    return false;
  }
  
  public final void b()
  {
    try
    {
      this.h = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void finalize()
  {
    b -= 1;
    if (com.google.android.gms.ads.internal.util.e.a())
    {
      String str = String.valueOf(this);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 27);
      localStringBuilder.append("AdExoPlayerHelper finalize ");
      localStringBuilder.append(str);
      com.google.android.gms.ads.internal.util.e.a(localStringBuilder.toString());
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */