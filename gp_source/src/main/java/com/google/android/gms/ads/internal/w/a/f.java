package com.google.android.gms.ads.internal.w.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.gms.ads.exoplayer1.af;
import com.google.android.gms.ads.exoplayer1.j;
import com.google.android.gms.ads.exoplayer1.upstream.DefaultUriDataSource;
import com.google.android.gms.ads.exoplayer1.x;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.w.ac;
import com.google.android.gms.ads.internal.w.ad;
import com.google.android.gms.ads.internal.w.ae;
import com.google.android.gms.ads.internal.w.ag;
import com.google.android.gms.ads.internal.w.k;
import com.google.android.gms.common.util.b;
import java.nio.ByteBuffer;

@com.google.android.gms.ads.internal.q.a.a
@TargetApi(16)
public final class f
  extends com.google.android.gms.ads.internal.w.l
  implements TextureView.SurfaceTextureListener
{
  private com.google.android.gms.ads.internal.w.ab A;
  private Surface B;
  private float C;
  private x D;
  private final com.google.android.gms.ads.exoplayer1.ab E = new u(this);
  public k a;
  public final ac d;
  public float e;
  public int f = 1;
  public int g;
  public final ad h;
  public final ae i;
  public int j;
  private a k;
  private com.google.android.gms.ads.exoplayer1.l l;
  private final com.google.android.gms.ads.exoplayer1.o m = new v(this);
  private final Context n;
  private final com.google.android.gms.ads.exoplayer1.f o = new t(this);
  private boolean p;
  private int q;
  private int r;
  private String s;
  private boolean t;
  private boolean u;
  private com.google.android.gms.ads.exoplayer1.d v;
  private boolean w;
  private final int x;
  private final boolean y;
  private String z;
  
  public f(Context paramContext, ae paramae, ad paramad, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ac paramac)
  {
    super(paramContext);
    this.n = paramContext;
    this.y = paramBoolean2;
    this.h = paramad;
    this.x = paramInt;
    this.i = paramae;
    this.p = paramBoolean1;
    this.d = paramac;
    setSurfaceTextureListener(this);
    this.i.a(this);
  }
  
  private final void a(float paramFloat, boolean paramBoolean)
  {
    com.google.android.gms.ads.exoplayer1.d locald = this.v;
    com.google.android.gms.ads.exoplayer1.l locall;
    if (locald != null)
    {
      locall = this.l;
      if (locall != null) {}
    }
    else
    {
      e.e("Trying to set volume before player and renderers are initalized.");
      return;
    }
    if (!paramBoolean)
    {
      locald.a(locall, Float.valueOf(paramFloat));
      return;
    }
    locald.b(locall, Float.valueOf(paramFloat));
  }
  
  private final void a(Surface paramSurface, boolean paramBoolean)
  {
    com.google.android.gms.ads.exoplayer1.d locald = this.v;
    x localx;
    if (locald != null)
    {
      localx = this.D;
      if (localx != null) {}
    }
    else
    {
      e.e("Trying to set surface before player and renderers are initalized.");
      return;
    }
    if (!paramBoolean)
    {
      locald.a(localx, paramSurface);
      return;
    }
    locald.b(localx, paramSurface);
  }
  
  private final boolean g()
  {
    return (this.v != null) && (!this.w);
  }
  
  private final boolean h()
  {
    return (g()) && (this.f != 1);
  }
  
  private final void i()
  {
    if (this.v == null)
    {
      ??? = this.z;
      if ((??? != null) && (this.B != null))
      {
        if (!((String)???).startsWith("cache:")) {
          break label602;
        }
        ??? = this.h.a(this.z);
        if ((??? == null) || (!(??? instanceof com.google.android.gms.ads.internal.w.b.a.f))) {
          break label219;
        }
      }
    }
    synchronized ((com.google.android.gms.ads.internal.w.b.a.f)???)
    {
      ((com.google.android.gms.ads.internal.w.b.a.f)???).f = true;
      ((com.google.android.gms.ads.internal.w.b.a.f)???).d.b();
      ??? = ((com.google.android.gms.ads.internal.w.b.a.f)???).d;
      ((a)???).a(this.o, this.E, this.m);
      this.k = ((a)???);
      ??? = this.k;
      if (??? == null)
      {
        ??? = String.valueOf(this.z);
        if (((String)???).length() == 0)
        {
          ??? = new String("AdExoPlayerHelper is null. Source: ");
          e.e((String)???);
        }
      }
      do
      {
        do
        {
          return;
          ??? = "AdExoPlayerHelper is null. Source: ".concat((String)???);
          break;
          this.v = ((a)???).c;
          this.D = ((a)???).e;
          this.l = ((a)???).a;
        } while (this.v == null);
        a(this.B, false);
        this.f = this.v.a();
      } while (this.f != 4);
      e();
      return;
      label219:
      Object localObject4;
      if ((??? instanceof com.google.android.gms.ads.internal.w.b.a.a))
      {
        ??? = (com.google.android.gms.ads.internal.w.b.a.a)???;
        ByteBuffer localByteBuffer = ((com.google.android.gms.ads.internal.w.b.a.a)???).c();
        String str = ((com.google.android.gms.ads.internal.w.b.a.a)???).e;
        boolean bool = ((com.google.android.gms.ads.internal.w.b.a.a)???).d;
        localObject2 = j();
        if (!"video/webm".equals(this.s)) {}
        for (localObject4 = new com.google.android.gms.ads.exoplayer1.b.a.f();; localObject4 = new com.google.android.gms.ads.exoplayer1.b.b.f())
        {
          if (!bool)
          {
            label278:
            ??? = bt.A.e.b(this.h.getContext(), this.h.getVersionInfo().a);
            ??? = new DefaultUriDataSource(this.h.getContext(), (String)???);
            if (((Boolean)com.google.android.gms.ads.internal.f.n.A.a()).booleanValue())
            {
              ??? = new w(this.n, (com.google.android.gms.ads.exoplayer1.upstream.d)???, new h(this));
              label363:
              if (localByteBuffer.limit() > 0)
              {
                byte[] arrayOfByte = new byte[localByteBuffer.limit()];
                localByteBuffer.get(arrayOfByte);
                ??? = new y(new com.google.android.gms.ads.exoplayer1.upstream.c(arrayOfByte), arrayOfByte.length, (com.google.android.gms.ads.exoplayer1.upstream.d)???);
              }
            }
          }
          label409:
          for (??? = new com.google.android.gms.ads.exoplayer1.b.g(Uri.parse(str), (com.google.android.gms.ads.exoplayer1.upstream.d)???, (com.google.android.gms.ads.exoplayer1.b.d)localObject4, this.d.c);; ??? = new com.google.android.gms.ads.exoplayer1.b.g(Uri.parse(str), (com.google.android.gms.ads.exoplayer1.upstream.d)???, (com.google.android.gms.ads.exoplayer1.b.d)localObject4, this.d.c))
          {
            ((a)localObject2).a(this.o, this.E, this.m);
            if (!((a)localObject2).a((af)???))
            {
              a("AdExoPlayerHelper Error", "Prepare from ByteBuffer failed.");
              ??? = localObject2;
              break;
            }
            ??? = localObject2;
            break;
            break label409;
            break label363;
            if (localByteBuffer.limit() <= 0) {
              break label278;
            }
            ??? = new byte[localByteBuffer.limit()];
            localByteBuffer.get((byte[])???);
            ??? = new com.google.android.gms.ads.exoplayer1.upstream.c((byte[])???);
          }
        }
      }
      ??? = String.valueOf(this.z);
      if (((String)???).length() == 0) {}
      for (??? = new String("Source is MD5 but not found in cache. Source: ");; ??? = "Source is MD5 but not found in cache. Source: ".concat((String)???))
      {
        e.e((String)???);
        ??? = null;
        break;
      }
      label602:
      int i1 = this.x;
      if (i1 == 1) {}
      for (Object localObject2 = new j(this.h.getContext(), Uri.parse(this.z));; localObject2 = new com.google.android.gms.ads.exoplayer1.b.g(Uri.parse(this.z), (com.google.android.gms.ads.exoplayer1.upstream.d)???, (com.google.android.gms.ads.exoplayer1.b.d)localObject2, this.d.c))
      {
        localObject4 = j();
        ((a)localObject4).a(this.o, this.E, this.m);
        ??? = localObject4;
        if (((a)localObject4).a((af)localObject2)) {
          break;
        }
        a("AdExoPlayerHelper Error", "Prepare failed.");
        ??? = localObject4;
        break;
        if (i1 != 2) {
          break label852;
        }
        ??? = bt.A.e.b(this.h.getContext(), this.h.getVersionInfo().a);
        localObject2 = new DefaultUriDataSource(this.h.getContext(), (String)???);
        ??? = localObject2;
        if (((Boolean)com.google.android.gms.ads.internal.f.n.A.a()).booleanValue()) {
          ??? = new w(this.n, (com.google.android.gms.ads.exoplayer1.upstream.d)localObject2, new g(this));
        }
        if ("video/webm".equals(this.s)) {
          break label833;
        }
        localObject2 = new com.google.android.gms.ads.exoplayer1.b.a.f();
      }
      label833:
      localObject2 = new com.google.android.gms.ads.exoplayer1.b.b.f();
    }
    label852:
    throw new IllegalArgumentException();
  }
  
  private static a j()
  {
    return new a();
  }
  
  private final void k()
  {
    com.google.android.gms.ads.exoplayer1.d locald = this.v;
    if (locald != null) {
      locald.a(true);
    }
  }
  
  public final void a()
  {
    if (g())
    {
      this.v.c();
      if (this.v != null)
      {
        a(null, true);
        a locala = this.k;
        if (locala != null)
        {
          locala.a();
          this.k = null;
        }
        this.v = null;
        this.D = null;
        this.l = null;
        this.f = 1;
        this.w = false;
        this.t = false;
        this.u = false;
      }
    }
    this.i.a = false;
    this.c.c();
    this.i.b();
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    com.google.android.gms.ads.internal.w.ab localab = this.A;
    if (localab != null) {
      localab.a(paramFloat1, paramFloat2);
    }
  }
  
  public final void a(int paramInt)
  {
    if (h()) {
      this.v.a(paramInt);
    }
  }
  
  final void a(int paramInt1, int paramInt2, float paramFloat)
  {
    if (paramInt2 != 0) {}
    for (paramFloat = paramInt1 * paramFloat / paramInt2;; paramFloat = 1.0F)
    {
      if (this.C != paramFloat)
      {
        this.C = paramFloat;
        requestLayout();
      }
      return;
    }
  }
  
  final void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString1).length() + 19 + String.valueOf(paramString2).length());
    localStringBuilder.append("Error received: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" : ");
    localStringBuilder.append(paramString2);
    e.e(localStringBuilder.toString());
    this.w = true;
    if (this.d.a) {
      f();
    }
    com.google.android.gms.ads.internal.util.n.a.post(new n(this, paramString1, paramString2));
  }
  
  public final void b()
  {
    if (h())
    {
      if (this.d.a) {
        k();
      }
      this.v.b(true);
      this.i.c();
      this.c.b();
      this.b.a = true;
      com.google.android.gms.ads.internal.util.n.a.post(new o(this));
      return;
    }
    this.u = true;
  }
  
  public final void c()
  {
    if (h())
    {
      if (this.d.a) {
        f();
      }
      this.v.b(false);
      this.i.a = false;
      this.c.c();
      com.google.android.gms.ads.internal.util.n.a.post(new p(this));
    }
  }
  
  public final void d()
  {
    a(this.c.a(), false);
  }
  
  final void e()
  {
    if (!this.t)
    {
      this.t = true;
      e.a("Video is ready.");
      com.google.android.gms.ads.internal.util.n.a.post(new l(this));
      d();
      this.i.a();
      if (this.u) {
        b();
      }
    }
  }
  
  final void f()
  {
    com.google.android.gms.ads.exoplayer1.d locald = this.v;
    if (locald != null) {
      locald.a(false);
    }
  }
  
  public final int getCurrentPosition()
  {
    if (h()) {
      return (int)this.v.f();
    }
    return 0;
  }
  
  public final int getDuration()
  {
    if (h()) {
      return (int)this.v.e();
    }
    return 0;
  }
  
  public final com.google.android.gms.ads.exoplayer1.f getExoPlayerListener()
  {
    return this.o;
  }
  
  public final String getPlayerName()
  {
    int i1 = this.x;
    String str;
    if (i1 == 1) {
      str = "/Framework";
    }
    for (;;)
    {
      if (!this.p) {}
      for (Object localObject = "";; localObject = " spherical")
      {
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(localObject).length());
        localStringBuilder.append("ExoPlayer/1");
        localStringBuilder.append(str);
        localStringBuilder.append((String)localObject);
        return localStringBuilder.toString();
      }
      if (i1 == 2)
      {
        str = this.s;
        localObject = new StringBuilder(String.valueOf(str).length() + 12);
        ((StringBuilder)localObject).append("/Extractor(");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(")");
        str = ((StringBuilder)localObject).toString();
      }
      else
      {
        str = "/Unknown";
      }
    }
  }
  
  public final int getVideoHeight()
  {
    return this.g;
  }
  
  public final com.google.android.gms.ads.exoplayer1.ab getVideoTrackRendererListener()
  {
    return this.E;
  }
  
  public final int getVideoWidth()
  {
    return this.j;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = getMeasuredWidth();
    int i2 = getMeasuredHeight();
    float f1 = this.C;
    if (f1 == 0.0F)
    {
      paramInt2 = i2;
      paramInt1 = i1;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      com.google.android.gms.ads.internal.w.ab localab = this.A;
      if (localab != null) {
        localab.a(paramInt1, paramInt2);
      }
      if (Build.VERSION.SDK_INT == 16)
      {
        i1 = this.r;
        if (i1 > 0) {
          break label256;
        }
      }
      for (;;)
      {
        i1 = this.q;
        if (i1 <= 0) {}
        label186:
        label256:
        do
        {
          while ((!this.y) || (!g()) || (this.v.f() <= 0L) || (this.v.b())) {
            do
            {
              this.r = paramInt1;
              this.q = paramInt2;
              return;
            } while (i1 == paramInt2);
          }
          a(0.0F, true);
          this.v.b(true);
          long l1 = this.v.f();
          long l2 = bt.A.l.a();
          if ((!g()) || (this.v.f() != l1)) {}
          for (;;)
          {
            if (g()) {
              this.v.b(false);
            }
            d();
            break;
            if (bt.A.l.a() - l2 <= 250L) {
              break label186;
            }
          }
        } while (i1 != paramInt1);
      }
      paramInt1 = i1;
      paramInt2 = i2;
      if (this.A == null)
      {
        float f2 = i1;
        float f3 = i2;
        float f4 = f1 / (f2 / f3) - 1.0F;
        if (f4 > 0.01F)
        {
          paramInt2 = (int)(f2 / f1);
          paramInt1 = i1;
        }
        else
        {
          paramInt1 = i1;
          paramInt2 = i2;
          if (f4 < -0.01F)
          {
            paramInt1 = (int)(f3 * f1);
            paramInt2 = i2;
          }
        }
      }
    }
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    SurfaceTexture localSurfaceTexture = paramSurfaceTexture;
    if (this.p)
    {
      this.A = new com.google.android.gms.ads.internal.w.ab(getContext());
      this.A.a(paramSurfaceTexture, paramInt1, paramInt2);
      this.A.start();
      localSurfaceTexture = this.A.c();
      if (localSurfaceTexture != null) {
        break label153;
      }
      this.A.b();
      this.A = null;
      localSurfaceTexture = paramSurfaceTexture;
    }
    label153:
    for (;;)
    {
      this.B = new Surface(localSurfaceTexture);
      if (this.v == null) {
        i();
      }
      for (;;)
      {
        a(this.j, this.g, this.e);
        com.google.android.gms.ads.internal.util.n.a.post(new q(this));
        return;
        a(this.B, true);
        if (!this.d.a) {
          k();
        }
      }
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    e.a("Surface destroyed");
    c();
    paramSurfaceTexture = this.A;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.b();
      this.A = null;
    }
    if (this.v != null)
    {
      f();
      paramSurfaceTexture = this.B;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.release();
      }
      this.B = null;
      a(null, true);
    }
    com.google.android.gms.ads.internal.util.n.a.post(new s(this));
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    paramSurfaceTexture = this.A;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.a(paramInt1, paramInt2);
    }
    com.google.android.gms.ads.internal.util.n.a.post(new r(this, paramInt1, paramInt2));
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    this.i.b(this);
    this.b.a(paramSurfaceTexture, this.a);
  }
  
  protected final void onWindowVisibilityChanged(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(57);
    localStringBuilder.append("AdExoPlayerView1 window visibility changed to ");
    localStringBuilder.append(paramInt);
    e.a(localStringBuilder.toString());
    com.google.android.gms.ads.internal.util.n.a.post(new i(this, paramInt));
    super.onWindowVisibilityChanged(paramInt);
  }
  
  public final void setListener(k paramk)
  {
    this.a = paramk;
  }
  
  public final void setMimeType(String paramString)
  {
    this.s = paramString;
  }
  
  public final void setTestSurface(Surface paramSurface)
  {
    this.B = paramSurface;
  }
  
  public final void setVideoPath(String paramString)
  {
    if (paramString == null)
    {
      e.e("Path is null.");
      return;
    }
    this.z = paramString;
    i();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */