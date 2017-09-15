package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.s.b;
import com.tencent.mm.plugin.s.c;
import com.tencent.mm.plugin.s.g;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.plugin.s.j;
import com.tencent.mm.plugin.s.k;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMTextureView;

public class VideoPlayerTextureView
  extends MMTextureView
  implements f
{
  private boolean Ht;
  private int gRt;
  private int gRu;
  private boolean kkZ;
  public Surface nHw;
  private boolean nxM;
  private boolean nxN;
  public b nxW;
  private String path;
  public f.a ptG;
  public i sVd;
  private int sVe;
  private boolean sVf;
  private long sVg;
  private boolean sVh;
  public boolean sVi;
  private f.e sVj;
  private f.c sVk;
  private f.d sVl;
  private boolean sVm;
  private boolean sVn;
  public boolean sVo;
  private c sVp;
  private TextureView.SurfaceTextureListener sVq;
  public o sVr;
  
  public VideoPlayerTextureView(Context paramContext)
  {
    this(paramContext, null);
    GMTrace.i(1095887749120L, 8165);
    GMTrace.o(1095887749120L, 8165);
  }
  
  public VideoPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(1096021966848L, 8166);
    GMTrace.o(1096021966848L, 8166);
  }
  
  public VideoPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1096156184576L, 8167);
    this.gRu = 0;
    this.gRt = 0;
    this.sVe = 0;
    this.Ht = false;
    this.sVf = true;
    this.sVg = 0L;
    this.sVh = false;
    this.sVi = false;
    this.nxM = false;
    this.nxN = false;
    this.sVm = false;
    this.sVn = false;
    this.sVo = false;
    this.sVp = new c()
    {
      public final void E(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(1118570545152L, 8334);
        v.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        VideoPlayerTextureView.h(VideoPlayerTextureView.this).reset();
        VideoPlayerTextureView.a(VideoPlayerTextureView.this, paramAnonymousInt3);
        VideoPlayerTextureView.b(VideoPlayerTextureView.this, paramAnonymousInt1);
        VideoPlayerTextureView.c(VideoPlayerTextureView.this, paramAnonymousInt2);
        VideoPlayerTextureView.i(VideoPlayerTextureView.this);
        if (VideoPlayerTextureView.c(VideoPlayerTextureView.this) != null) {
          VideoPlayerTextureView.c(VideoPlayerTextureView.this).bp(VideoPlayerTextureView.j(VideoPlayerTextureView.this), VideoPlayerTextureView.k(VideoPlayerTextureView.this));
        }
        GMTrace.o(1118570545152L, 8334);
      }
      
      public final void TZ()
      {
        GMTrace.i(1118033674240L, 8330);
        VideoPlayerTextureView.a(VideoPlayerTextureView.this);
        VideoPlayerTextureView.this.bQ(VideoPlayerTextureView.b(VideoPlayerTextureView.this));
        if (VideoPlayerTextureView.c(VideoPlayerTextureView.this) != null) {
          VideoPlayerTextureView.c(VideoPlayerTextureView.this).TZ();
        }
        VideoPlayerTextureView.this.requestLayout();
        GMTrace.o(1118033674240L, 8330);
      }
      
      public final void aKg()
      {
        GMTrace.i(1118436327424L, 8333);
        if (VideoPlayerTextureView.d(VideoPlayerTextureView.this) != null) {
          VideoPlayerTextureView.d(VideoPlayerTextureView.this).br(VideoPlayerTextureView.e(VideoPlayerTextureView.this));
        }
        if (!VideoPlayerTextureView.e(VideoPlayerTextureView.this))
        {
          v.d("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
          VideoPlayerTextureView.f(VideoPlayerTextureView.this);
          GMTrace.o(1118436327424L, 8333);
          return;
        }
        if (VideoPlayerTextureView.g(VideoPlayerTextureView.this) != null)
        {
          v.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", new Object[] { VideoPlayerTextureView.g(VideoPlayerTextureView.this).aKl() });
          VideoPlayerTextureView.g(VideoPlayerTextureView.this).start();
        }
        GMTrace.o(1118436327424L, 8333);
      }
      
      public final void oW()
      {
        GMTrace.i(1118167891968L, 8331);
        if (VideoPlayerTextureView.c(VideoPlayerTextureView.this) != null) {
          VideoPlayerTextureView.c(VideoPlayerTextureView.this).oW();
        }
        GMTrace.o(1118167891968L, 8331);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(1118302109696L, 8332);
        if (VideoPlayerTextureView.c(VideoPlayerTextureView.this) != null) {
          VideoPlayerTextureView.c(VideoPlayerTextureView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        GMTrace.o(1118302109696L, 8332);
      }
    };
    this.sVq = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(1084747677696L, 8082);
        v.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(VideoPlayerTextureView.l(VideoPlayerTextureView.this)) });
        for (;;)
        {
          try
          {
            VideoPlayerTextureView.this.bSr();
            VideoPlayerTextureView.a(VideoPlayerTextureView.this, new Surface(paramAnonymousSurfaceTexture));
            if ((VideoPlayerTextureView.g(VideoPlayerTextureView.this) == null) || (!VideoPlayerTextureView.m(VideoPlayerTextureView.this)))
            {
              VideoPlayerTextureView.n(VideoPlayerTextureView.this);
              VideoPlayerTextureView.i(VideoPlayerTextureView.this);
              if (VideoPlayerTextureView.p(VideoPlayerTextureView.this) != null) {
                VideoPlayerTextureView.p(VideoPlayerTextureView.this).KK();
              }
              GMTrace.o(1084747677696L, 8082);
              return;
            }
            Object localObject = VideoPlayerTextureView.g(VideoPlayerTextureView.this);
            paramAnonymousSurfaceTexture = VideoPlayerTextureView.o(VideoPlayerTextureView.this);
            if (paramAnonymousSurfaceTexture != null)
            {
              localObject = ((i)localObject).nyp;
              v.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", new Object[] { ((j)localObject).nxT.aKl(), Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()) });
              localObject = ((j)localObject).nyy;
              v.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", new Object[] { ((k)localObject).aKl() });
              ((k)localObject).nyF = paramAnonymousSurfaceTexture;
              if (d.eo(23)) {
                ((k)localObject).aKx();
              }
            }
            else
            {
              if (!VideoPlayerTextureView.l(VideoPlayerTextureView.this)) {
                break label315;
              }
              VideoPlayerTextureView.g(VideoPlayerTextureView.this).start();
              VideoPlayerTextureView.b(VideoPlayerTextureView.this, false);
              continue;
            }
            ((k)localObject).aKy();
          }
          catch (Exception paramAnonymousSurfaceTexture)
          {
            GMTrace.o(1084747677696L, 8082);
            return;
          }
          continue;
          label315:
          VideoPlayerTextureView.a(VideoPlayerTextureView.this, true);
          VideoPlayerTextureView.a(VideoPlayerTextureView.this, 0L);
          VideoPlayerTextureView.g(VideoPlayerTextureView.this).bQ(true);
          VideoPlayerTextureView.g(VideoPlayerTextureView.this).start();
        }
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        GMTrace.i(1085016113152L, 8084);
        v.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()) });
        VideoPlayerTextureView.a(VideoPlayerTextureView.this, null);
        VideoPlayerTextureView.b(VideoPlayerTextureView.this, false);
        VideoPlayerTextureView.a(VideoPlayerTextureView.this, false);
        if (VideoPlayerTextureView.g(VideoPlayerTextureView.this) != null) {
          if (VideoPlayerTextureView.this.isPlaying())
          {
            VideoPlayerTextureView.b(VideoPlayerTextureView.this, true);
            VideoPlayerTextureView.g(VideoPlayerTextureView.this).pause();
          }
        }
        for (;;)
        {
          GMTrace.o(1085016113152L, 8084);
          return false;
          VideoPlayerTextureView.b(VideoPlayerTextureView.this, false);
        }
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(1084881895424L, 8083);
        v.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", new Object[] { Integer.valueOf(paramAnonymousSurfaceTexture.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoPlayerTextureView.i(VideoPlayerTextureView.this);
        GMTrace.o(1084881895424L, 8083);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        GMTrace.i(1085150330880L, 8085);
        if ((VideoPlayerTextureView.q(VideoPlayerTextureView.this)) && (VideoPlayerTextureView.r(VideoPlayerTextureView.this) > 0L))
        {
          VideoPlayerTextureView.g(VideoPlayerTextureView.this).pause();
          VideoPlayerTextureView.g(VideoPlayerTextureView.this).bQ(VideoPlayerTextureView.b(VideoPlayerTextureView.this));
          VideoPlayerTextureView.a(VideoPlayerTextureView.this, false);
        }
        if ((VideoPlayerTextureView.r(VideoPlayerTextureView.this) > 0L) && (VideoPlayerTextureView.s(VideoPlayerTextureView.this) != null))
        {
          v.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", new Object[] { Integer.valueOf(VideoPlayerTextureView.this.hashCode()) });
          VideoPlayerTextureView.s(VideoPlayerTextureView.this).aMf();
          VideoPlayerTextureView.t(VideoPlayerTextureView.this);
        }
        VideoPlayerTextureView.a(VideoPlayerTextureView.this, System.currentTimeMillis());
        GMTrace.o(1085150330880L, 8085);
      }
    };
    this.sVr = new o();
    this.gRt = 0;
    this.gRu = 0;
    setSurfaceTextureListener(this.sVq);
    setFocusable(true);
    setFocusableInTouchMode(true);
    GMTrace.o(1096156184576L, 8167);
  }
  
  private void aux()
  {
    GMTrace.i(1098974756864L, 8188);
    v.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s]", new Object[] { Integer.valueOf(hashCode()), this.path });
    if (this.sVd != null)
    {
      this.sVd.nyq = null;
      this.sVd.nyp.stop();
      this.sVd.release();
      this.sVd = null;
    }
    if ((bf.mA(this.path)) || (this.nHw == null))
    {
      v.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", new Object[] { Integer.valueOf(hashCode()) });
      GMTrace.o(1098974756864L, 8188);
      return;
    }
    try
    {
      this.Ht = false;
      this.sVd = new i(Looper.getMainLooper());
      this.sVd.setPath(this.path);
      i locali = this.sVd;
      b localb = this.nxW;
      if ((localb != null) && (locali.nyp != null)) {
        locali.nyp.nyy.nxW = localb;
      }
      this.sVd.fz(this.nxM);
      this.sVd.fA(this.nxN);
      this.sVd.nyq = this.sVp;
      this.sVd.setSurface(this.nHw);
      locali = this.sVd;
      boolean bool = this.sVm;
      locali.nyp.nyy.nyI = bool;
      if (this.nHw != null)
      {
        this.sVd.aKs();
        GMTrace.o(1098974756864L, 8188);
        return;
      }
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
      if (this.ptG != null) {
        this.ptG.onError(-1, -1);
      }
      GMTrace.o(1098974756864L, 8188);
      return;
    }
    if (this.sVi) {
      this.sVd.aKs();
    }
    GMTrace.o(1098974756864L, 8188);
  }
  
  public final String Lt()
  {
    GMTrace.i(1096827273216L, 8172);
    String str = this.path;
    GMTrace.o(1096827273216L, 8172);
    return str;
  }
  
  public final void a(f.a parama)
  {
    GMTrace.i(1097766797312L, 8179);
    this.ptG = parama;
    GMTrace.o(1097766797312L, 8179);
  }
  
  public final void a(f.b paramb)
  {
    GMTrace.i(16400466837504L, 122193);
    GMTrace.o(16400466837504L, 122193);
  }
  
  public final void a(f.c paramc)
  {
    GMTrace.i(16400332619776L, 122192);
    this.sVk = paramc;
    GMTrace.o(16400332619776L, 122192);
  }
  
  public final void a(f.d paramd)
  {
    GMTrace.i(17470853218304L, 130168);
    this.sVl = paramd;
    GMTrace.o(17470853218304L, 130168);
  }
  
  public final void a(f.e parame)
  {
    GMTrace.i(1096290402304L, 8168);
    this.sVj = parame;
    GMTrace.o(1096290402304L, 8168);
  }
  
  public final void aKv()
  {
    GMTrace.i(17471121653760L, 130170);
    if ((this.sVd != null) && (this.Ht))
    {
      v.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", new Object[] { Integer.valueOf(hashCode()) });
      i locali = this.sVd;
      if (locali.nyp != null) {
        locali.nyp.aKv();
      }
    }
    GMTrace.o(17471121653760L, 130170);
  }
  
  public final void bN(boolean paramBoolean)
  {
    GMTrace.i(1097632579584L, 8178);
    GMTrace.o(1097632579584L, 8178);
  }
  
  public final void bQ(boolean paramBoolean)
  {
    GMTrace.i(1098840539136L, 8187);
    this.kkZ = paramBoolean;
    if (this.sVd != null)
    {
      v.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
      this.sVd.bQ(paramBoolean);
    }
    GMTrace.o(1098840539136L, 8187);
  }
  
  public final double bcp()
  {
    GMTrace.i(1098169450496L, 8182);
    GMTrace.o(1098169450496L, 8182);
    return 0.0D;
  }
  
  public final long bcq()
  {
    GMTrace.i(1098706321408L, 8186);
    long l = this.sVg;
    GMTrace.o(1098706321408L, 8186);
    return l;
  }
  
  public final void c(double paramDouble, boolean paramBoolean)
  {
    GMTrace.i(1098437885952L, 8184);
    this.sVf = paramBoolean;
    k(paramDouble);
    GMTrace.o(1098437885952L, 8184);
  }
  
  public final void fA(boolean paramBoolean)
  {
    GMTrace.i(18681765560320L, 139190);
    this.nxN = paramBoolean;
    if (this.sVd != null) {
      this.sVd.fA(paramBoolean);
    }
    GMTrace.o(18681765560320L, 139190);
  }
  
  public final void fz(boolean paramBoolean)
  {
    GMTrace.i(1096424620032L, 8169);
    this.nxM = paramBoolean;
    if (this.sVd != null) {
      this.sVd.fz(paramBoolean);
    }
    GMTrace.o(1096424620032L, 8169);
  }
  
  public final int getCurrentPosition()
  {
    GMTrace.i(1097901015040L, 8180);
    if (this.sVd != null)
    {
      int i = this.sVd.aKt();
      GMTrace.o(1097901015040L, 8180);
      return i;
    }
    GMTrace.o(1097901015040L, 8180);
    return 0;
  }
  
  public final int getDuration()
  {
    GMTrace.i(1098035232768L, 8181);
    if (this.sVd != null)
    {
      int i = (int)this.sVd.nyp.nya;
      GMTrace.o(1098035232768L, 8181);
      return i;
    }
    GMTrace.o(1098035232768L, 8181);
    return 0;
  }
  
  public final void hd(boolean paramBoolean)
  {
    GMTrace.i(1098572103680L, 8185);
    GMTrace.o(1098572103680L, 8185);
  }
  
  public final boolean i(Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(1097095708672L, 8174);
    paramBoolean = start();
    GMTrace.o(1097095708672L, 8174);
    return paramBoolean;
  }
  
  public final boolean isPlaying()
  {
    GMTrace.i(1096558837760L, 8170);
    if (this.sVd != null)
    {
      boolean bool = this.sVd.isPlaying();
      GMTrace.o(1096558837760L, 8170);
      return bool;
    }
    GMTrace.o(1096558837760L, 8170);
    return false;
  }
  
  public final void k(double paramDouble)
  {
    GMTrace.i(1098303668224L, 8183);
    if (this.sVd != null) {
      this.sVd.pq((int)paramDouble);
    }
    GMTrace.o(1098303668224L, 8183);
  }
  
  public final void onDetach()
  {
    GMTrace.i(1097498361856L, 8177);
    GMTrace.o(1097498361856L, 8177);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(1099108974592L, 8189);
    if ((this.gRt == 0) || (this.gRu == 0))
    {
      setMeasuredDimension(1, 1);
      GMTrace.o(1099108974592L, 8189);
      return;
    }
    paramInt1 = getDefaultSize(1, paramInt1);
    paramInt2 = getDefaultSize(1, paramInt2);
    int i = this.gRt;
    int j = this.gRu;
    this.sVr.r(paramInt1, paramInt2, i, j);
    paramInt1 = this.sVr.sVS;
    paramInt2 = this.sVr.sVT;
    if ((this.sVe == 90) || (this.sVe == 270))
    {
      Matrix localMatrix = new Matrix();
      localMatrix.set(getMatrix());
      float f1 = paramInt1 / 2.0F;
      float f2 = paramInt2 / 2.0F;
      float f3 = paramInt2 / paramInt1;
      localMatrix.postRotate(this.sVe, f1, f2);
      localMatrix.postScale(1.0F / f3, f3, f1, f2);
      setTransform(localMatrix);
    }
    setMeasuredDimension(paramInt1, paramInt2);
    GMTrace.o(1099108974592L, 8189);
  }
  
  public final void pause()
  {
    GMTrace.i(1097364144128L, 8176);
    if ((this.sVd != null) && (this.sVd.isPlaying())) {
      this.sVd.pause();
    }
    this.sVn = false;
    GMTrace.o(1097364144128L, 8176);
  }
  
  public final void setVideoPath(String paramString)
  {
    GMTrace.i(1096693055488L, 8171);
    v.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    this.path = paramString;
    aux();
    requestLayout();
    GMTrace.o(1096693055488L, 8171);
  }
  
  public final boolean start()
  {
    GMTrace.i(1096961490944L, 8173);
    if ((this.sVd != null) && (this.Ht))
    {
      i = hashCode();
      boolean bool2 = this.sVo;
      boolean bool3 = this.sVn;
      if (this.nHw != null) {}
      for (bool1 = true;; bool1 = false)
      {
        v.i("MicroMsg.VideoPlayerTextureView", "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (this.nHw != null) {
          break;
        }
        this.sVn = true;
        GMTrace.o(1096961490944L, 8173);
        return true;
      }
      if (this.sVo)
      {
        this.sVn = true;
        this.sVo = false;
        bQ(this.kkZ);
        GMTrace.o(1096961490944L, 8173);
        return true;
      }
      this.sVd.start();
      GMTrace.o(1096961490944L, 8173);
      return true;
    }
    int i = hashCode();
    if (this.sVd == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      v.w("MicroMsg.VideoPlayerTextureView", "%d player is null[%b] or it prepared [%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(this.Ht) });
      GMTrace.o(1096961490944L, 8173);
      return false;
    }
  }
  
  public final void stop()
  {
    GMTrace.i(1097229926400L, 8175);
    v.i("MicroMsg.VideoPlayerTextureView", "%d player stop", new Object[] { Integer.valueOf(hashCode()) });
    if (this.sVd != null)
    {
      this.sVd.nyq = null;
      this.sVd.nyp.stop();
      this.sVd.release();
      this.sVd = null;
    }
    this.sVr.reset();
    this.Ht = false;
    this.path = null;
    this.sVg = 0L;
    GMTrace.o(1097229926400L, 8175);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */