package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.sdk.platformtools.v;

public class VideoSurfaceView
  extends SurfaceView
  implements f
{
  private int gRt;
  private int gRu;
  private boolean kkZ;
  private int ls;
  private f.a ptG;
  private MediaPlayer pwO;
  private SurfaceHolder qVa;
  private String sVA;
  private boolean sVB;
  private boolean sVC;
  MediaPlayer.OnVideoSizeChangedListener sVD;
  MediaPlayer.OnPreparedListener sVE;
  private MediaPlayer.OnCompletionListener sVF;
  private MediaPlayer.OnErrorListener sVG;
  SurfaceHolder.Callback sVH;
  
  public VideoSurfaceView(Context paramContext)
  {
    this(paramContext, null);
    GMTrace.i(1068641550336L, 7962);
    GMTrace.o(1068641550336L, 7962);
  }
  
  public VideoSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(1068775768064L, 7963);
    GMTrace.o(1068775768064L, 7963);
  }
  
  public VideoSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1068909985792L, 7964);
    this.qVa = null;
    this.pwO = null;
    this.sVD = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(1060588486656L, 7902);
        VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoWidth());
        VideoSurfaceView.b(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoHeight());
        v.v("MicroMsg.VideoSurfaceView", "on size change size:( " + VideoSurfaceView.a(VideoSurfaceView.this) + " , " + VideoSurfaceView.b(VideoSurfaceView.this) + " )");
        VideoSurfaceView.c(VideoSurfaceView.this);
        GMTrace.o(1060588486656L, 7902);
      }
    };
    this.sVE = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        GMTrace.i(1108906868736L, 8262);
        VideoSurfaceView.d(VideoSurfaceView.this);
        if (VideoSurfaceView.e(VideoSurfaceView.this) != null) {
          VideoSurfaceView.e(VideoSurfaceView.this).TZ();
        }
        VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoWidth());
        VideoSurfaceView.b(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoHeight());
        VideoSurfaceView.c(VideoSurfaceView.this);
        if ((VideoSurfaceView.a(VideoSurfaceView.this) != 0) && (VideoSurfaceView.b(VideoSurfaceView.this) != 0))
        {
          if (VideoSurfaceView.f(VideoSurfaceView.this))
          {
            VideoSurfaceView.g(VideoSurfaceView.this).start();
            VideoSurfaceView.h(VideoSurfaceView.this);
            GMTrace.o(1108906868736L, 8262);
          }
        }
        else if (VideoSurfaceView.f(VideoSurfaceView.this))
        {
          VideoSurfaceView.g(VideoSurfaceView.this).start();
          VideoSurfaceView.h(VideoSurfaceView.this);
        }
        GMTrace.o(1108906868736L, 8262);
      }
    };
    this.sVF = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        GMTrace.i(1131589664768L, 8431);
        if (VideoSurfaceView.e(VideoSurfaceView.this) != null)
        {
          VideoSurfaceView.e(VideoSurfaceView.this).bI(VideoSurfaceView.g(VideoSurfaceView.this).getCurrentPosition(), VideoSurfaceView.g(VideoSurfaceView.this).getDuration());
          VideoSurfaceView.e(VideoSurfaceView.this).oW();
        }
        GMTrace.o(1131589664768L, 8431);
      }
    };
    this.sVG = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(1062735970304L, 7918);
        v.d("MicroMsg.VideoSurfaceView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
        if (VideoSurfaceView.e(VideoSurfaceView.this) != null) {
          VideoSurfaceView.e(VideoSurfaceView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        GMTrace.o(1062735970304L, 7918);
        return true;
      }
    };
    this.sVH = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(1108369997824L, 8258);
        v.i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        if ((VideoSurfaceView.g(VideoSurfaceView.this) != null) && (VideoSurfaceView.i(VideoSurfaceView.this)) && (VideoSurfaceView.a(VideoSurfaceView.this) == paramAnonymousInt2) && (VideoSurfaceView.b(VideoSurfaceView.this) == paramAnonymousInt3)) {
          VideoSurfaceView.g(VideoSurfaceView.this).start();
        }
        GMTrace.o(1108369997824L, 8258);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        GMTrace.i(1108504215552L, 8259);
        v.i("MicroMsg.VideoSurfaceView", "on surface created");
        VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousSurfaceHolder);
        VideoSurfaceView.j(VideoSurfaceView.this);
        GMTrace.o(1108504215552L, 8259);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        GMTrace.i(1108638433280L, 8260);
        v.i("MicroMsg.VideoSurfaceView", "on surface destroyed");
        VideoSurfaceView.a(VideoSurfaceView.this, null);
        if (VideoSurfaceView.g(VideoSurfaceView.this) != null)
        {
          VideoSurfaceView.e(VideoSurfaceView.this).bI(VideoSurfaceView.g(VideoSurfaceView.this).getCurrentPosition(), VideoSurfaceView.g(VideoSurfaceView.this).getDuration());
          VideoSurfaceView.g(VideoSurfaceView.this).reset();
          VideoSurfaceView.g(VideoSurfaceView.this).release();
          VideoSurfaceView.k(VideoSurfaceView.this);
        }
        GMTrace.o(1108638433280L, 8260);
      }
    };
    this.kkZ = false;
    this.gRt = 0;
    this.gRu = 0;
    getHolder().addCallback(this.sVH);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    GMTrace.o(1068909985792L, 7964);
  }
  
  private void aux()
  {
    GMTrace.i(1069446856704L, 7968);
    if ((this.sVA == null) || (this.qVa == null))
    {
      GMTrace.o(1069446856704L, 7968);
      return;
    }
    if (this.pwO != null)
    {
      this.pwO.stop();
      this.pwO.release();
      this.pwO = null;
    }
    try
    {
      this.pwO = new i();
      this.pwO.setOnPreparedListener(this.sVE);
      this.pwO.setOnVideoSizeChangedListener(this.sVD);
      this.sVB = false;
      v.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
      this.ls = -1;
      this.pwO.setOnCompletionListener(this.sVF);
      this.pwO.setOnErrorListener(this.sVG);
      this.pwO.setDataSource(this.sVA);
      this.pwO.setDisplay(this.qVa);
      this.pwO.setAudioStreamType(3);
      this.pwO.setScreenOnWhilePlaying(true);
      this.pwO.prepareAsync();
      this.gRu = this.pwO.getVideoHeight();
      this.gRt = this.pwO.getVideoWidth();
      bQ(this.kkZ);
      GMTrace.o(1069446856704L, 7968);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.VideoSurfaceView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
      if (this.ptG != null) {
        this.ptG.onError(-1, -1);
      }
      GMTrace.o(1069446856704L, 7968);
    }
  }
  
  public final String Lt()
  {
    GMTrace.i(1069178421248L, 7966);
    String str = this.sVA;
    GMTrace.o(1069178421248L, 7966);
    return str;
  }
  
  public final void a(f.a parama)
  {
    GMTrace.i(1070252163072L, 7974);
    this.ptG = parama;
    GMTrace.o(1070252163072L, 7974);
  }
  
  public final void a(f.b paramb)
  {
    GMTrace.i(16381542137856L, 122052);
    GMTrace.o(16381542137856L, 122052);
  }
  
  public final void a(f.c paramc)
  {
    GMTrace.i(16381407920128L, 122051);
    GMTrace.o(16381407920128L, 122051);
  }
  
  public final void a(f.d paramd)
  {
    GMTrace.i(17440251576320L, 129940);
    GMTrace.o(17440251576320L, 129940);
  }
  
  public final void a(f.e parame)
  {
    GMTrace.i(1071594340352L, 7984);
    GMTrace.o(1071594340352L, 7984);
  }
  
  public final void bN(boolean paramBoolean)
  {
    GMTrace.i(1070117945344L, 7973);
    if (this.pwO != null) {
      this.pwO.setLooping(paramBoolean);
    }
    GMTrace.o(1070117945344L, 7973);
  }
  
  public final void bQ(boolean paramBoolean)
  {
    GMTrace.i(1071325904896L, 7982);
    this.kkZ = paramBoolean;
    if (this.pwO != null)
    {
      if (this.kkZ)
      {
        this.pwO.setVolume(0.0F, 0.0F);
        GMTrace.o(1071325904896L, 7982);
        return;
      }
      this.pwO.setVolume(0.5F, 0.5F);
    }
    GMTrace.o(1071325904896L, 7982);
  }
  
  public final double bcp()
  {
    GMTrace.i(1070789033984L, 7978);
    GMTrace.o(1070789033984L, 7978);
    return 0.0D;
  }
  
  public final long bcq()
  {
    GMTrace.i(1071191687168L, 7981);
    GMTrace.o(1071191687168L, 7981);
    return 0L;
  }
  
  public final void c(double paramDouble, boolean paramBoolean)
  {
    GMTrace.i(1071460122624L, 7983);
    k(paramDouble);
    GMTrace.o(1071460122624L, 7983);
  }
  
  public final int getCurrentPosition()
  {
    GMTrace.i(1069849509888L, 7971);
    if ((this.pwO != null) && (this.sVB))
    {
      int i = this.pwO.getCurrentPosition();
      GMTrace.o(1069849509888L, 7971);
      return i;
    }
    GMTrace.o(1069849509888L, 7971);
    return 0;
  }
  
  public final int getDuration()
  {
    GMTrace.i(1069715292160L, 7970);
    if ((this.pwO != null) && (this.sVB))
    {
      if (this.ls > 0)
      {
        i = this.ls;
        GMTrace.o(1069715292160L, 7970);
        return i;
      }
      this.ls = this.pwO.getDuration();
      i = this.ls;
      GMTrace.o(1069715292160L, 7970);
      return i;
    }
    this.ls = -1;
    int i = this.ls;
    GMTrace.o(1069715292160L, 7970);
    return i;
  }
  
  public final void hd(boolean paramBoolean)
  {
    GMTrace.i(1071057469440L, 7980);
    GMTrace.o(1071057469440L, 7980);
  }
  
  public final boolean i(Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(1070654816256L, 7977);
    paramBoolean = start();
    GMTrace.o(1070654816256L, 7977);
    return paramBoolean;
  }
  
  public final boolean isPlaying()
  {
    GMTrace.i(1069983727616L, 7972);
    if ((this.pwO != null) && (this.sVB))
    {
      boolean bool = this.pwO.isPlaying();
      GMTrace.o(1069983727616L, 7972);
      return bool;
    }
    GMTrace.o(1069983727616L, 7972);
    return false;
  }
  
  public final void k(double paramDouble)
  {
    GMTrace.i(1070923251712L, 7979);
    if (this.pwO != null)
    {
      v.d("MicroMsg.VideoSurfaceView", "seek to time: " + paramDouble);
      this.pwO.seekTo((int)paramDouble);
      start();
    }
    GMTrace.o(1070923251712L, 7979);
  }
  
  public final void onDetach()
  {
    GMTrace.i(1070386380800L, 7975);
    GMTrace.o(1070386380800L, 7975);
  }
  
  public final void pause()
  {
    GMTrace.i(1069581074432L, 7969);
    if ((this.pwO != null) && (this.sVB) && (this.pwO.isPlaying())) {
      this.pwO.pause();
    }
    this.sVC = false;
    GMTrace.o(1069581074432L, 7969);
  }
  
  public final void setVideoPath(String paramString)
  {
    GMTrace.i(1069044203520L, 7965);
    this.sVA = paramString;
    this.sVC = false;
    aux();
    requestLayout();
    GMTrace.o(1069044203520L, 7965);
  }
  
  public final boolean start()
  {
    GMTrace.i(1070520598528L, 7976);
    if ((this.pwO != null) && (this.sVB)) {
      this.pwO.start();
    }
    for (this.sVC = false;; this.sVC = true)
    {
      GMTrace.o(1070520598528L, 7976);
      return true;
    }
  }
  
  public final void stop()
  {
    GMTrace.i(1069312638976L, 7967);
    if (this.pwO != null)
    {
      this.pwO.stop();
      this.pwO.release();
      this.pwO = null;
    }
    GMTrace.o(1069312638976L, 7967);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/VideoSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */