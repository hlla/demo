package com.google.android.gms.ads.internal.w;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.u;
import com.google.android.gms.ads.internal.util.a.aa;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.common.internal.z;
import com.google.android.gms.common.util.b;
import java.util.HashMap;
import java.util.concurrent.Executor;

@a
public final class n
  extends FrameLayout
  implements k
{
  public l a;
  public String b;
  public final af c;
  private final com.google.android.gms.ads.internal.g.l d;
  private final long e;
  private boolean f;
  private boolean g;
  private boolean h;
  private Bitmap i;
  private long j;
  private long k;
  private boolean l;
  private ImageView m;
  private boolean n;
  private final FrameLayout o;
  private final ad p;
  
  public n(Context paramContext, ad paramad, int paramInt, boolean paramBoolean, com.google.android.gms.ads.internal.g.l paraml, ac paramac)
  {
    super(paramContext);
    this.p = paramad;
    this.d = paraml;
    this.o = new FrameLayout(paramContext);
    addView(this.o, new FrameLayout.LayoutParams(-1, -1));
    z.a(paramad.getAdManagerDependencyProvider());
    this.a = paramad.getAdManagerDependencyProvider().a.a(paramContext, paramad, paramInt, paramBoolean, paraml, paramac);
    paramad = this.a;
    if (paramad != null)
    {
      this.o.addView(paramad, new FrameLayout.LayoutParams(-1, -1, 17));
      if (((Boolean)com.google.android.gms.ads.internal.f.n.cg.a()).booleanValue()) {
        i();
      }
    }
    this.m = new ImageView(paramContext);
    this.e = ((Long)com.google.android.gms.ads.internal.f.n.cm.a()).longValue();
    this.n = ((Boolean)com.google.android.gms.ads.internal.f.n.cl.a()).booleanValue();
    paramad = this.d;
    if (paramad != null) {
      if (this.n) {
        break label239;
      }
    }
    label239:
    for (paramContext = "0";; paramContext = "1")
    {
      paramad.a("spinner_used", paramContext);
      this.c = new af(this);
      paramContext = this.a;
      if (paramContext != null) {
        paramContext.setListener(this);
      }
      if (this.a == null) {
        a("AdVideoUnderlay Error", "Allocating player failed.");
      }
      return;
    }
  }
  
  private final boolean l()
  {
    return this.m.getParent() != null;
  }
  
  public final void a()
  {
    this.c.b();
    com.google.android.gms.ads.internal.util.n.a.post(new q(this));
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (this.n)
    {
      paramInt1 = Math.max(paramInt1 / ((Integer)com.google.android.gms.ads.internal.f.n.cn.a()).intValue(), 1);
      paramInt2 = Math.max(paramInt2 / ((Integer)com.google.android.gms.ads.internal.f.n.cn.a()).intValue(), 1);
      Bitmap localBitmap = this.i;
      if ((localBitmap == null) || (localBitmap.getWidth() != paramInt1) || (this.i.getHeight() != paramInt2))
      {
        this.i = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        this.f = false;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 != 0) && (paramInt4 != 0))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt3, paramInt4);
      localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
      this.o.setLayoutParams(localLayoutParams);
      requestLayout();
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    a("error", new String[] { "what", paramString1, "extra", paramString2 });
  }
  
  public final void a(String paramString, String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", paramString);
    int i2 = paramVarArgs.length;
    int i1 = 0;
    for (Object localObject = null; i1 < i2; localObject = paramString)
    {
      String str = paramVarArgs[i1];
      paramString = str;
      if (localObject != null)
      {
        localHashMap.put(localObject, str);
        paramString = null;
      }
      i1 += 1;
    }
    this.p.a("onVideoEvent", localHashMap);
  }
  
  public final void b()
  {
    l locall = this.a;
    if ((locall != null) && (this.k == 0L))
    {
      int i1 = locall.getDuration();
      int i2 = this.a.getVideoWidth();
      int i3 = this.a.getVideoHeight();
      a("canplaythrough", new String[] { "duration", String.valueOf(i1 / 1000.0F), "videoWidth", String.valueOf(i2), "videoHeight", String.valueOf(i3) });
    }
  }
  
  public final void c()
  {
    if ((this.p.getActivityContext() != null) && (!this.h)) {
      if ((this.p.getActivityContext().getWindow().getAttributes().flags & 0x80) == 0) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      this.l = bool;
      if (!this.l)
      {
        this.p.getActivityContext().getWindow().addFlags(128);
        this.h = true;
      }
      this.g = true;
      return;
    }
  }
  
  public final void d()
  {
    a("pause", new String[0]);
    k();
    this.g = false;
  }
  
  public final void e()
  {
    a("ended", new String[0]);
    k();
  }
  
  public final void f()
  {
    if ((this.f) && (this.i != null) && (!l()))
    {
      this.m.setImageBitmap(this.i);
      this.m.invalidate();
      this.o.addView(this.m, new FrameLayout.LayoutParams(-1, -1));
      this.o.bringChildToFront(this.m);
    }
    this.c.a();
    this.k = this.j;
    com.google.android.gms.ads.internal.util.n.a.post(new r(this));
  }
  
  public final void finalize()
  {
    try
    {
      this.c.a();
      l locall = this.a;
      if (locall != null)
      {
        Executor localExecutor = aa.b;
        locall.getClass();
        localExecutor.execute(new o(locall));
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final void g()
  {
    if (!this.g) {}
    for (;;)
    {
      if (this.i != null)
      {
        long l1 = bt.A.l.b();
        if (this.a.getBitmap(this.i) != null) {
          this.f = true;
        }
        l1 = bt.A.l.b() - l1;
        Object localObject;
        if (e.a())
        {
          localObject = new StringBuilder(46);
          ((StringBuilder)localObject).append("Spinner frame grab took ");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append("ms");
          e.a(((StringBuilder)localObject).toString());
        }
        if (l1 > this.e)
        {
          e.e("Spinner frame grab crossed jank threshold! Suspending spinner.");
          this.n = false;
          this.i = null;
          localObject = this.d;
          if (localObject != null) {
            ((com.google.android.gms.ads.internal.g.l)localObject).a("spinner_jank", Long.toString(l1));
          }
        }
      }
      return;
      if (l()) {
        this.o.removeView(this.m);
      }
    }
  }
  
  public final l getVideoPlayer()
  {
    return this.a;
  }
  
  public final void h()
  {
    l locall = this.a;
    if (locall != null) {
      locall.c();
    }
  }
  
  @TargetApi(14)
  public final void i()
  {
    Object localObject = this.a;
    TextView localTextView;
    if (localObject != null)
    {
      localTextView = new TextView(((l)localObject).getContext());
      localObject = String.valueOf(this.a.getPlayerName());
      if (((String)localObject).length() != 0) {
        break label99;
      }
    }
    label99:
    for (localObject = new String("AdMob - ");; localObject = "AdMob - ".concat((String)localObject))
    {
      localTextView.setText((CharSequence)localObject);
      localTextView.setTextColor(-65536);
      localTextView.setBackgroundColor(65280);
      this.o.addView(localTextView, new FrameLayout.LayoutParams(-2, -2, 17));
      this.o.bringChildToFront(localTextView);
      return;
    }
  }
  
  final void j()
  {
    l locall = this.a;
    if (locall != null)
    {
      long l1 = locall.getCurrentPosition();
      if ((this.j != l1) && (l1 > 0L))
      {
        a("timeupdate", new String[] { "time", String.valueOf((float)l1 / 1000.0F) });
        this.j = l1;
      }
    }
  }
  
  public final void k()
  {
    if ((this.p.getActivityContext() != null) && (this.h) && (!this.l))
    {
      this.p.getActivityContext().getWindow().clearFlags(128);
      this.h = false;
    }
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.c.b();
    }
    for (;;)
    {
      com.google.android.gms.ads.internal.util.n.a.post(new p(this, paramBoolean));
      return;
      this.c.a();
      this.k = this.j;
    }
  }
  
  public final void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0) {
      this.c.b();
    }
    for (boolean bool = true;; bool = false)
    {
      com.google.android.gms.ads.internal.util.n.a.post(new s(this, bool));
      return;
      this.c.a();
      this.k = this.j;
    }
  }
  
  public final void setBufferForPlayback(int paramInt)
  {
    this.a.setBufferForPlayback(paramInt);
  }
  
  public final void setBufferForPlaybackAfterRebuffer(int paramInt)
  {
    this.a.setBufferForPlaybackAfterRebuffer(paramInt);
  }
  
  public final void setHighWaterMark(int paramInt)
  {
    this.a.setHighWaterMark(paramInt);
  }
  
  public final void setLowWaterMark(int paramInt)
  {
    this.a.setLowWaterMark(paramInt);
  }
  
  public final void setSrc(String paramString)
  {
    this.b = paramString;
  }
  
  public final void setVolume(float paramFloat)
  {
    l locall = this.a;
    if (locall != null) {
      locall.setVolume(paramFloat);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */