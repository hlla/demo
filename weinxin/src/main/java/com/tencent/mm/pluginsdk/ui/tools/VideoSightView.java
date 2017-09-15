package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.af.a.h;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.3;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import java.io.File;

public class VideoSightView
  extends SightPlayImageView
  implements f
{
  protected int duration;
  private boolean kkZ;
  protected String psm;
  private boolean qjA;
  public boolean qjB;
  
  public VideoSightView(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(1121925988352L, 8359);
    this.duration = 0;
    this.qjB = true;
    this.kkZ = false;
    init();
    GMTrace.o(1121925988352L, 8359);
  }
  
  public VideoSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1121791770624L, 8358);
    this.duration = 0;
    this.qjB = true;
    this.kkZ = false;
    init();
    GMTrace.o(1121791770624L, 8358);
  }
  
  public VideoSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1121657552896L, 8357);
    this.duration = 0;
    this.qjB = true;
    this.kkZ = false;
    init();
    GMTrace.o(1121657552896L, 8357);
  }
  
  public final void a(f.a parama)
  {
    GMTrace.i(1123268165632L, 8369);
    this.ptG = parama;
    GMTrace.o(1123268165632L, 8369);
  }
  
  public final void a(f.b paramb)
  {
    GMTrace.i(16381810573312L, 122054);
    GMTrace.o(16381810573312L, 122054);
  }
  
  public final void a(f.c paramc)
  {
    GMTrace.i(16381676355584L, 122053);
    GMTrace.o(16381676355584L, 122053);
  }
  
  public final void a(f.d paramd)
  {
    GMTrace.i(17440385794048L, 129941);
    GMTrace.o(17440385794048L, 129941);
  }
  
  public final void a(f.e parame)
  {
    GMTrace.i(1124878778368L, 8381);
    GMTrace.o(1124878778368L, 8381);
  }
  
  public final void bN(boolean paramBoolean)
  {
    GMTrace.i(1123133947904L, 8368);
    if (this.ptA != null) {
      this.ptA.mMh = paramBoolean;
    }
    GMTrace.o(1123133947904L, 8368);
  }
  
  public final void bQ(boolean paramBoolean)
  {
    GMTrace.i(1124610342912L, 8379);
    this.kkZ = paramBoolean;
    if (!this.kkZ) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ha(paramBoolean);
      GMTrace.o(1124610342912L, 8379);
      return;
    }
  }
  
  public double bcp()
  {
    GMTrace.i(1124073472000L, 8375);
    if (this.ptA != null)
    {
      b localb = this.ptA;
      if (localb.psO != -1.0D)
      {
        d = localb.psO;
        GMTrace.o(1124073472000L, 8375);
        return d;
      }
      double d = localb.psL;
      GMTrace.o(1124073472000L, 8375);
      return d;
    }
    GMTrace.o(1124073472000L, 8375);
    return 0.0D;
  }
  
  public final long bcq()
  {
    GMTrace.i(1124476125184L, 8378);
    GMTrace.o(1124476125184L, 8378);
    return 0L;
  }
  
  public final void c(double paramDouble, boolean paramBoolean)
  {
    GMTrace.i(1124744560640L, 8380);
    k(paramDouble);
    GMTrace.o(1124744560640L, 8380);
  }
  
  public int getCurrentPosition()
  {
    GMTrace.i(1123402383360L, 8370);
    v.v("MicroMsg.VideoSightView", "get current position");
    GMTrace.o(1123402383360L, 8370);
    return 0;
  }
  
  public int getDuration()
  {
    GMTrace.i(1123536601088L, 8371);
    int i = super.getDuration();
    v.v("MicroMsg.VideoSightView", "get duration " + i);
    GMTrace.o(1123536601088L, 8371);
    return i;
  }
  
  public void hd(boolean paramBoolean)
  {
    GMTrace.i(1124341907456L, 8377);
    if (paramBoolean)
    {
      a(new b.f()
      {
        public final void a(b paramAnonymousb, long paramAnonymousLong)
        {
          GMTrace.i(1105551425536L, 8237);
          if (VideoSightView.this.duration == 0) {
            VideoSightView.this.duration = VideoSightView.this.getDuration();
          }
          if (VideoSightView.this.ptG != null)
          {
            v.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(VideoSightView.this.duration) });
            VideoSightView.this.ptG.bI((int)paramAnonymousLong, VideoSightView.this.duration);
          }
          GMTrace.o(1105551425536L, 8237);
        }
      });
      GMTrace.o(1124341907456L, 8377);
      return;
    }
    a(null);
    GMTrace.o(1124341907456L, 8377);
  }
  
  public final boolean i(Context paramContext, boolean paramBoolean)
  {
    boolean bool = false;
    GMTrace.i(1123939254272L, 8374);
    if (this.psm == null)
    {
      v.e("MicroMsg.VideoSightView", "start::use path is null!");
      GMTrace.o(1123939254272L, 8374);
      return false;
    }
    if ((bf.ap(p.gRb.gQt, "").equals("other")) || (!b.Eq(this.psm)))
    {
      v.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", new Object[] { this.psm, Boolean.valueOf(this.qjA) });
      if ((this.qjA) && (!paramBoolean))
      {
        GMTrace.o(1123939254272L, 8374);
        return false;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.fromFile(new File(this.psm)), "video/*");
      try
      {
        paramContext.startActivity(Intent.createChooser(localIntent, paramContext.getString(a.h.qYM)));
        this.qjA = true;
        GMTrace.o(1123939254272L, 8374);
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
          g.bk(paramContext, paramContext.getResources().getString(a.h.fac));
        }
      }
    }
    ak(this.psm, false);
    paramBoolean = bool;
    if (!this.kkZ) {
      paramBoolean = true;
    }
    ha(paramBoolean);
    GMTrace.o(1123939254272L, 8374);
    return true;
  }
  
  protected void init()
  {
    GMTrace.i(1122060206080L, 8360);
    if (bf.ap(p.gRb.gQt, "").equals("other")) {
      v.i("MicroMsg.VideoSightView", "init::use other player");
    }
    for (;;)
    {
      a(new b.e()
      {
        public final void a(b paramAnonymousb, int paramAnonymousInt)
        {
          GMTrace.i(1141924429824L, 8508);
          if (-1 == paramAnonymousInt)
          {
            if (VideoSightView.this.ptG != null)
            {
              VideoSightView.this.ptG.onError(0, 0);
              GMTrace.o(1141924429824L, 8508);
            }
          }
          else if ((paramAnonymousInt == 0) && (VideoSightView.this.ptG != null)) {
            VideoSightView.this.ptG.oW();
          }
          GMTrace.o(1141924429824L, 8508);
        }
      });
      GMTrace.o(1122060206080L, 8360);
      return;
      ha(true);
    }
  }
  
  public boolean isPlaying()
  {
    GMTrace.i(1122597076992L, 8364);
    boolean bool = this.ptA.bbS();
    GMTrace.o(1122597076992L, 8364);
    return bool;
  }
  
  public void k(double paramDouble)
  {
    GMTrace.i(1124207689728L, 8376);
    if (this.ptA != null)
    {
      b localb = this.ptA;
      v.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", new Object[] { Double.valueOf(paramDouble), bf.bJP().toString() });
      o.b(new b.3(localb, paramDouble), 0L);
    }
    GMTrace.o(1124207689728L, 8376);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(1122462859264L, 8363);
    super.onConfigurationChanged(paramConfiguration);
    if (this.qjB) {
      sB(getResources().getDisplayMetrics().widthPixels);
    }
    GMTrace.o(1122462859264L, 8363);
  }
  
  public final void onDetach()
  {
    GMTrace.i(1123670818816L, 8372);
    a.uql.c(this.ptA.bbW());
    GMTrace.o(1123670818816L, 8372);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(1122328641536L, 8362);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    v.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(this.ptH) });
    if ((this.ptH) && (paramInt3 - paramInt1 > 0)) {
      sB(paramInt3 - paramInt1);
    }
    GMTrace.o(1122328641536L, 8362);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(1122194423808L, 8361);
    super.onMeasure(paramInt1, paramInt2);
    GMTrace.o(1122194423808L, 8361);
  }
  
  public void pause()
  {
    GMTrace.i(1122999730176L, 8367);
    ak(this.psm, true);
    GMTrace.o(1122999730176L, 8367);
  }
  
  public final void setVideoPath(String paramString)
  {
    GMTrace.i(1122731294720L, 8365);
    if (this.ptG == null) {}
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.VideoSightView", "set sight path %s, callback null ? %B", new Object[] { paramString, Boolean.valueOf(bool) });
      this.duration = 0;
      this.psm = paramString;
      if (this.ptG != null) {
        this.ptG.TZ();
      }
      GMTrace.o(1122731294720L, 8365);
      return;
    }
  }
  
  public boolean start()
  {
    GMTrace.i(1123805036544L, 8373);
    boolean bool = i(getContext(), false);
    GMTrace.o(1123805036544L, 8373);
    return bool;
  }
  
  public void stop()
  {
    GMTrace.i(1122865512448L, 8366);
    this.ptA.clear();
    GMTrace.o(1122865512448L, 8366);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/VideoSightView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */