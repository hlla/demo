package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.PlaybackParams;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMTextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoTextureView
  extends MMTextureView
  implements f
{
  private float aLi;
  private int gRt;
  private int gRu;
  private int jWD;
  private int jWE;
  private boolean kkZ;
  private int ls;
  private boolean mMh;
  private Surface nHw;
  public f.a ptG;
  private MediaPlayer pwO;
  private String sVA;
  private boolean sVB;
  private boolean sVC;
  MediaPlayer.OnVideoSizeChangedListener sVD;
  MediaPlayer.OnPreparedListener sVE;
  private MediaPlayer.OnCompletionListener sVF;
  private MediaPlayer.OnErrorListener sVG;
  private f.b sVJ;
  private long sVK;
  public int sVL;
  private MediaPlayer.OnSeekCompleteListener sVM;
  private MediaPlayer.OnBufferingUpdateListener sVN;
  private MediaPlayer.OnInfoListener sVO;
  private boolean sVP;
  private long sVg;
  public boolean sVh;
  public f.e sVj;
  private f.c sVk;
  private f.d sVl;
  private boolean sVn;
  private boolean sVo;
  TextureView.SurfaceTextureListener sVq;
  public o sVr;
  private long startTime;
  
  public VideoTextureView(Context paramContext)
  {
    this(paramContext, null);
    GMTrace.i(1086358290432L, 8094);
    GMTrace.o(1086358290432L, 8094);
  }
  
  public VideoTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(1086492508160L, 8095);
    GMTrace.o(1086492508160L, 8095);
  }
  
  public VideoTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1086626725888L, 8096);
    this.nHw = null;
    this.pwO = null;
    this.startTime = 0L;
    this.sVK = 0L;
    this.jWD = 0;
    this.jWE = 0;
    this.sVL = 0;
    this.mMh = false;
    this.sVh = false;
    this.sVD = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(1095619313664L, 8163);
        try
        {
          if (paramAnonymousMediaPlayer != VideoTextureView.a(VideoTextureView.this))
          {
            v.w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramAnonymousMediaPlayer, VideoTextureView.a(VideoTextureView.this) });
            GMTrace.o(1095619313664L, 8163);
            return;
          }
          VideoTextureView.a(VideoTextureView.this, paramAnonymousMediaPlayer.getVideoWidth());
          VideoTextureView.b(VideoTextureView.this, paramAnonymousMediaPlayer.getVideoHeight());
          v.i("MicroMsg.VideoTextureView", "on size change size:( " + VideoTextureView.b(VideoTextureView.this) + " , " + VideoTextureView.c(VideoTextureView.this) + " )");
          if (VideoTextureView.d(VideoTextureView.this) != null) {
            VideoTextureView.d(VideoTextureView.this).bp(VideoTextureView.b(VideoTextureView.this), VideoTextureView.c(VideoTextureView.this));
          }
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.VideoTextureView", paramAnonymousMediaPlayer, "on video size changed error[%d, %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          }
        }
        VideoTextureView.e(VideoTextureView.this);
        GMTrace.o(1095619313664L, 8163);
      }
    };
    this.sVE = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        GMTrace.i(1109175304192L, 8264);
        if ((paramAnonymousMediaPlayer != VideoTextureView.a(VideoTextureView.this)) && (paramAnonymousMediaPlayer != null))
        {
          v.w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramAnonymousMediaPlayer, VideoTextureView.a(VideoTextureView.this) });
          VideoTextureView.a(VideoTextureView.this, paramAnonymousMediaPlayer);
          GMTrace.o(1109175304192L, 8264);
          return;
        }
        VideoTextureView.f(VideoTextureView.this);
        VideoTextureView localVideoTextureView = VideoTextureView.this;
        int i;
        if (paramAnonymousMediaPlayer != null)
        {
          i = paramAnonymousMediaPlayer.getVideoWidth();
          VideoTextureView.a(localVideoTextureView, i);
          localVideoTextureView = VideoTextureView.this;
          if (paramAnonymousMediaPlayer == null) {
            break label274;
          }
          i = paramAnonymousMediaPlayer.getVideoHeight();
          label109:
          VideoTextureView.b(localVideoTextureView, i);
          v.i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[] { Integer.valueOf(VideoTextureView.b(VideoTextureView.this)), Integer.valueOf(VideoTextureView.c(VideoTextureView.this)), Boolean.valueOf(VideoTextureView.g(VideoTextureView.this)) });
          VideoTextureView.e(VideoTextureView.this);
          if ((VideoTextureView.b(VideoTextureView.this) == 0) || (VideoTextureView.c(VideoTextureView.this) == 0)) {
            break label279;
          }
          if (VideoTextureView.g(VideoTextureView.this))
          {
            VideoTextureView.a(VideoTextureView.this).start();
            VideoTextureView.a(VideoTextureView.this).setLooping(VideoTextureView.h(VideoTextureView.this));
            VideoTextureView.i(VideoTextureView.this);
          }
        }
        for (;;)
        {
          if (VideoTextureView.d(VideoTextureView.this) != null) {
            VideoTextureView.d(VideoTextureView.this).TZ();
          }
          GMTrace.o(1109175304192L, 8264);
          return;
          i = 0;
          break;
          label274:
          i = 0;
          break label109;
          label279:
          if (VideoTextureView.g(VideoTextureView.this))
          {
            VideoTextureView.a(VideoTextureView.this).start();
            VideoTextureView.i(VideoTextureView.this);
            VideoTextureView.a(VideoTextureView.this).setLooping(VideoTextureView.h(VideoTextureView.this));
          }
        }
      }
    };
    this.sVM = new MediaPlayer.OnSeekCompleteListener()
    {
      public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
      {
        GMTrace.i(1105014554624L, 8233);
        int i;
        if (paramAnonymousMediaPlayer != null)
        {
          i = paramAnonymousMediaPlayer.getCurrentPosition();
          v.i("MicroMsg.VideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(VideoTextureView.g(VideoTextureView.this)) });
          if (!VideoTextureView.g(VideoTextureView.this)) {
            break label120;
          }
          VideoTextureView.this.start();
        }
        for (;;)
        {
          if (VideoTextureView.j(VideoTextureView.this) != null) {
            VideoTextureView.j(VideoTextureView.this).br(VideoTextureView.g(VideoTextureView.this));
          }
          VideoTextureView.a(VideoTextureView.this, 0L);
          GMTrace.o(1105014554624L, 8233);
          return;
          i = -1;
          break;
          label120:
          VideoTextureView.this.pause();
        }
      }
    };
    this.sVN = new MediaPlayer.OnBufferingUpdateListener()
    {
      public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
      {
        GMTrace.i(16403016974336L, 122212);
        v.d("MicroMsg.VideoTextureView", "onBufferingUpdate percent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
        VideoTextureView.c(VideoTextureView.this, paramAnonymousInt);
        GMTrace.o(16403016974336L, 122212);
      }
    };
    this.sVO = new MediaPlayer.OnInfoListener()
    {
      public final boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(16406640852992L, 122239);
        v.d("MicroMsg.VideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (VideoTextureView.k(VideoTextureView.this) != null) {
          VideoTextureView.k(VideoTextureView.this).dH(paramAnonymousInt1, paramAnonymousInt2);
        }
        GMTrace.o(16406640852992L, 122239);
        return false;
      }
    };
    this.sVF = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        GMTrace.i(16404090716160L, 122220);
        v.i("MicroMsg.VideoTextureView", "video on completion");
        VideoTextureView.b(VideoTextureView.this, bf.Nz());
        if (VideoTextureView.d(VideoTextureView.this) != null) {
          VideoTextureView.d(VideoTextureView.this).oW();
        }
        GMTrace.o(16404090716160L, 122220);
      }
    };
    this.sVG = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(16403956498432L, 122219);
        v.w("MicroMsg.VideoTextureView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
        if (VideoTextureView.d(VideoTextureView.this) != null) {
          VideoTextureView.d(VideoTextureView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        GMTrace.o(16403956498432L, 122219);
        return true;
      }
    };
    this.sVg = 0L;
    this.sVn = false;
    this.sVo = false;
    this.sVP = false;
    this.sVq = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(16403688062976L, 122217);
        VideoTextureView.d(VideoTextureView.this, paramAnonymousInt1);
        VideoTextureView.e(VideoTextureView.this, paramAnonymousInt2);
        VideoTextureView.this.bSr();
        VideoTextureView.a(VideoTextureView.this, new Surface(paramAnonymousSurfaceTexture));
        v.i("MicroMsg.VideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(VideoTextureView.s(VideoTextureView.this)), Integer.valueOf(VideoTextureView.u(VideoTextureView.this).hashCode()) });
        if ((VideoTextureView.a(VideoTextureView.this) == null) || (!VideoTextureView.s(VideoTextureView.this)))
        {
          VideoTextureView.v(VideoTextureView.this);
          if (VideoTextureView.x(VideoTextureView.this) != null) {
            VideoTextureView.x(VideoTextureView.this).KK();
          }
          GMTrace.o(16403688062976L, 122217);
          return;
        }
        VideoTextureView.a(VideoTextureView.this).setSurface(VideoTextureView.u(VideoTextureView.this));
        if (VideoTextureView.w(VideoTextureView.this)) {
          VideoTextureView.a(VideoTextureView.this).start();
        }
        for (;;)
        {
          VideoTextureView.b(VideoTextureView.this, false);
          break;
          VideoTextureView.a(VideoTextureView.this, true);
          VideoTextureView.a(VideoTextureView.this).setVolume(0.0F, 0.0F);
          VideoTextureView.a(VideoTextureView.this).start();
        }
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        GMTrace.i(16403553845248L, 122216);
        v.i("MicroMsg.VideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Boolean.valueOf(VideoTextureView.s(VideoTextureView.this)) });
        VideoTextureView.a(VideoTextureView.this, null);
        if ((VideoTextureView.a(VideoTextureView.this) != null) && (VideoTextureView.s(VideoTextureView.this))) {
          if (VideoTextureView.this.isPlaying())
          {
            VideoTextureView.b(VideoTextureView.this, true);
            VideoTextureView.a(VideoTextureView.this).pause();
          }
        }
        for (;;)
        {
          GMTrace.o(16403553845248L, 122216);
          return false;
          VideoTextureView.t(VideoTextureView.this);
          VideoTextureView.b(VideoTextureView.this, false);
        }
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(16403419627520L, 122215);
        v.i("MicroMsg.VideoTextureView", "on texture size changed width : " + paramAnonymousInt1 + " height : " + paramAnonymousInt2);
        if ((VideoTextureView.a(VideoTextureView.this) != null) && (VideoTextureView.s(VideoTextureView.this)) && (VideoTextureView.b(VideoTextureView.this) == paramAnonymousInt1) && (VideoTextureView.c(VideoTextureView.this) == paramAnonymousInt2)) {
          VideoTextureView.a(VideoTextureView.this).start();
        }
        GMTrace.o(16403419627520L, 122215);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        GMTrace.i(16403285409792L, 122214);
        if (VideoTextureView.l(VideoTextureView.this)) {
          if (VideoTextureView.a(VideoTextureView.this) != null)
          {
            VideoTextureView.a(VideoTextureView.this).pause();
            if (!VideoTextureView.m(VideoTextureView.this)) {
              break label220;
            }
            VideoTextureView.a(VideoTextureView.this).setVolume(0.0F, 0.0F);
          }
        }
        for (;;)
        {
          VideoTextureView.a(VideoTextureView.this, false);
          if ((VideoTextureView.n(VideoTextureView.this) > 0L) && (VideoTextureView.o(VideoTextureView.this) != null))
          {
            VideoTextureView.o(VideoTextureView.this).aMf();
            VideoTextureView.p(VideoTextureView.this);
          }
          VideoTextureView.a(VideoTextureView.this, System.currentTimeMillis());
          if (VideoTextureView.q(VideoTextureView.this))
          {
            v.i("MicroMsg.VideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(VideoTextureView.this.getCurrentPosition()) });
            if (VideoTextureView.a(VideoTextureView.this) != null)
            {
              VideoTextureView.a(VideoTextureView.this).pause();
              VideoTextureView.this.bQ(VideoTextureView.m(VideoTextureView.this));
            }
            VideoTextureView.r(VideoTextureView.this);
          }
          GMTrace.o(16403285409792L, 122214);
          return;
          label220:
          VideoTextureView.a(VideoTextureView.this).setVolume(1.0F, 1.0F);
        }
      }
    };
    this.kkZ = false;
    this.sVr = new o();
    this.aLi = -1.0F;
    this.gRt = 0;
    this.gRu = 0;
    setSurfaceTextureListener(this.sVq);
    setFocusable(true);
    setFocusableInTouchMode(true);
    GMTrace.o(1086626725888L, 8096);
  }
  
  private boolean ar(float paramFloat)
  {
    GMTrace.i(17473000701952L, 130184);
    if (Build.VERSION.SDK_INT >= 23) {}
    try
    {
      if ((this.pwO != null) && (d.eo(23)))
      {
        PlaybackParams localPlaybackParams2 = this.pwO.getPlaybackParams();
        PlaybackParams localPlaybackParams1 = localPlaybackParams2;
        if (localPlaybackParams2 == null) {
          localPlaybackParams1 = new PlaybackParams();
        }
        this.pwO.setPlaybackParams(localPlaybackParams1.setSpeed(paramFloat));
      }
      GMTrace.o(17473000701952L, 130184);
      return true;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.VideoTextureView", localException, "%s handle play rate error", new Object[] { Integer.valueOf(hashCode()) });
      GMTrace.o(17473000701952L, 130184);
    }
    return false;
  }
  
  private void aux()
  {
    GMTrace.i(1087566249984L, 8103);
    if ((bf.mA(this.sVA)) || (this.nHw == null))
    {
      GMTrace.o(1087566249984L, 8103);
      return;
    }
    bGz();
    v.i("MicroMsg.VideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.sVA });
    try
    {
      this.pwO = new i();
      this.pwO.setOnPreparedListener(this.sVE);
      this.pwO.setOnVideoSizeChangedListener(this.sVD);
      this.sVB = false;
      v.v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
      this.ls = -1;
      this.sVL = 0;
      this.pwO.setOnCompletionListener(this.sVF);
      this.pwO.setOnErrorListener(this.sVG);
      this.pwO.setOnSeekCompleteListener(this.sVM);
      this.pwO.setOnBufferingUpdateListener(this.sVN);
      this.pwO.setOnInfoListener(this.sVO);
      this.pwO.setDataSource(this.sVA);
      this.pwO.setSurface(this.nHw);
      this.pwO.setAudioStreamType(3);
      this.pwO.setScreenOnWhilePlaying(true);
      this.pwO.prepareAsync();
      this.gRu = this.pwO.getVideoHeight();
      this.gRt = this.pwO.getVideoWidth();
      bQ(this.kkZ);
      N(this.aLi);
      v.i("MicroMsg.VideoTextureView", "%d open video success player[%s] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.pwO.hashCode()) });
      GMTrace.o(1087566249984L, 8103);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.VideoTextureView", localException, "prepare async error path", new Object[0]);
      if (this.ptG != null) {
        this.ptG.onError(-1, -1);
      }
      GMTrace.o(1087566249984L, 8103);
    }
  }
  
  private void bGz()
  {
    boolean bool1 = true;
    GMTrace.i(1087297814528L, 8101);
    int i = hashCode();
    boolean bool2 = this.sVB;
    if (this.pwO == null) {}
    for (;;)
    {
      v.i("MicroMsg.VideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (this.pwO != null)
      {
        this.pwO.setOnErrorListener(null);
        this.pwO.setOnVideoSizeChangedListener(null);
      }
      try
      {
        this.pwO.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.pwO.reset();
            this.pwO.release();
            this.pwO = null;
            GMTrace.o(1087297814528L, 8101);
            return;
            bool1 = false;
            break;
            localException1 = localException1;
            v.printErrStackTrace("MicroMsg.VideoTextureView", localException1, "stop media player error", new Object[0]);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.VideoTextureView", localException2, "reset media player error", new Object[0]);
          }
        }
      }
    }
  }
  
  public final String Lt()
  {
    GMTrace.i(1087029379072L, 8099);
    String str = this.sVA;
    GMTrace.o(1087029379072L, 8099);
    return str;
  }
  
  public final boolean N(float paramFloat)
  {
    GMTrace.i(17472866484224L, 130183);
    if (paramFloat <= 0.0F)
    {
      GMTrace.o(17472866484224L, 130183);
      return false;
    }
    this.aLi = paramFloat;
    if (d.eo(23))
    {
      boolean bool = ar(this.aLi);
      GMTrace.o(17472866484224L, 130183);
      return bool;
    }
    GMTrace.o(17472866484224L, 130183);
    return false;
  }
  
  public final void a(f.a parama)
  {
    GMTrace.i(1088371556352L, 8109);
    this.ptG = parama;
    GMTrace.o(1088371556352L, 8109);
  }
  
  public final void a(f.b paramb)
  {
    GMTrace.i(16404493369344L, 122223);
    this.sVJ = paramb;
    GMTrace.o(16404493369344L, 122223);
  }
  
  public final void a(f.c paramc)
  {
    GMTrace.i(16404359151616L, 122222);
    this.sVk = paramc;
    GMTrace.o(16404359151616L, 122222);
  }
  
  public final void a(f.d paramd)
  {
    GMTrace.i(17472598048768L, 130181);
    this.sVl = paramd;
    GMTrace.o(17472598048768L, 130181);
  }
  
  public final void a(f.e parame)
  {
    GMTrace.i(1086760943616L, 8097);
    this.sVj = parame;
    GMTrace.o(1086760943616L, 8097);
  }
  
  public final void aKv()
  {
    GMTrace.i(17472732266496L, 130182);
    if ((this.pwO != null) && (this.sVB) && (this.nHw != null) && (this.nHw.isValid()))
    {
      v.i("MicroMsg.VideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
      this.sVP = true;
      this.pwO.setVolume(0.0F, 0.0F);
      this.pwO.start();
    }
    GMTrace.o(17472732266496L, 130182);
  }
  
  public final void bN(boolean paramBoolean)
  {
    GMTrace.i(1088237338624L, 8108);
    if (this.pwO != null) {
      this.pwO.setLooping(paramBoolean);
    }
    this.mMh = true;
    GMTrace.o(1088237338624L, 8108);
  }
  
  public final void bQ(boolean paramBoolean)
  {
    GMTrace.i(1089579515904L, 8118);
    v.i("MicroMsg.VideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    this.kkZ = paramBoolean;
    if (this.pwO != null)
    {
      if (this.kkZ)
      {
        this.pwO.setVolume(0.0F, 0.0F);
        GMTrace.o(1089579515904L, 8118);
        return;
      }
      this.pwO.setVolume(1.0F, 1.0F);
    }
    GMTrace.o(1089579515904L, 8118);
  }
  
  public final double bcp()
  {
    GMTrace.i(1088908427264L, 8113);
    GMTrace.o(1088908427264L, 8113);
    return 0.0D;
  }
  
  public final long bcq()
  {
    GMTrace.i(1089445298176L, 8117);
    long l = this.sVg;
    GMTrace.o(1089445298176L, 8117);
    return l;
  }
  
  public final void c(double paramDouble, boolean paramBoolean)
  {
    GMTrace.i(1089176862720L, 8115);
    k(paramDouble);
    this.sVC = paramBoolean;
    GMTrace.o(1089176862720L, 8115);
  }
  
  public final int getCurrentPosition()
  {
    GMTrace.i(1087968903168L, 8106);
    if ((this.pwO != null) && (this.sVB))
    {
      int i = this.pwO.getCurrentPosition();
      GMTrace.o(1087968903168L, 8106);
      return i;
    }
    if (this.pwO == null)
    {
      GMTrace.o(1087968903168L, 8106);
      return -1;
    }
    GMTrace.o(1087968903168L, 8106);
    return 0;
  }
  
  public final int getDuration()
  {
    GMTrace.i(1087834685440L, 8105);
    if ((this.pwO != null) && (this.sVB))
    {
      if (this.ls > 0)
      {
        i = this.ls;
        GMTrace.o(1087834685440L, 8105);
        return i;
      }
      this.ls = this.pwO.getDuration();
      i = this.ls;
      GMTrace.o(1087834685440L, 8105);
      return i;
    }
    this.ls = -1;
    int i = this.ls;
    GMTrace.o(1087834685440L, 8105);
    return i;
  }
  
  public final void hd(boolean paramBoolean)
  {
    GMTrace.i(1089311080448L, 8116);
    GMTrace.o(1089311080448L, 8116);
  }
  
  public final boolean i(Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(1088774209536L, 8112);
    paramBoolean = start();
    GMTrace.o(1088774209536L, 8112);
    return paramBoolean;
  }
  
  public final boolean isPlaying()
  {
    GMTrace.i(1088103120896L, 8107);
    if ((this.pwO != null) && (this.sVB))
    {
      boolean bool = this.pwO.isPlaying();
      GMTrace.o(1088103120896L, 8107);
      return bool;
    }
    GMTrace.o(1088103120896L, 8107);
    return false;
  }
  
  public final void k(double paramDouble)
  {
    GMTrace.i(1089042644992L, 8114);
    if (this.pwO != null)
    {
      this.pwO.seekTo((int)paramDouble);
      this.sVC = true;
      v.d("MicroMsg.VideoTextureView", "seek to time: " + paramDouble + " curr pos : " + this.pwO.getCurrentPosition());
    }
    GMTrace.o(1089042644992L, 8114);
  }
  
  public final void onDetach()
  {
    GMTrace.i(1088505774080L, 8110);
    GMTrace.o(1088505774080L, 8110);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(1089713733632L, 8119);
    if ((this.gRt == 0) || (this.gRu == 0))
    {
      setMeasuredDimension(1, 1);
      GMTrace.o(1089713733632L, 8119);
      return;
    }
    paramInt1 = getDefaultSize(1, paramInt1);
    paramInt2 = getDefaultSize(1, paramInt2);
    int i = this.gRt;
    int j = this.gRu;
    this.sVr.r(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.sVr.sVS, this.sVr.sVT);
    GMTrace.o(1089713733632L, 8119);
  }
  
  public final void pause()
  {
    GMTrace.i(1087700467712L, 8104);
    if ((this.pwO != null) && (this.sVB) && (this.pwO.isPlaying()))
    {
      v.d("MicroMsg.VideoTextureView", "pause video.");
      this.pwO.pause();
    }
    this.sVC = false;
    GMTrace.o(1087700467712L, 8104);
  }
  
  public final void setVideoPath(String paramString)
  {
    GMTrace.i(1086895161344L, 8098);
    this.sVA = paramString;
    this.sVC = false;
    aux();
    requestLayout();
    GMTrace.o(1086895161344L, 8098);
  }
  
  public final boolean start()
  {
    GMTrace.i(1088639991808L, 8111);
    if (this.nHw == null)
    {
      v.w("MicroMsg.VideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.sVn = true;
      this.sVC = true;
      GMTrace.o(1088639991808L, 8111);
      return false;
    }
    if (this.startTime == 0L) {}
    for (long l = bf.Nz();; l = this.startTime)
    {
      this.startTime = l;
      v.i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b", new Object[] { Long.valueOf(this.startTime), Boolean.valueOf(this.sVB), Boolean.valueOf(this.sVo) });
      if ((this.pwO == null) || (!this.sVB)) {
        break;
      }
      if (this.sVo)
      {
        this.sVo = false;
        bQ(this.kkZ);
      }
      this.pwO.start();
      this.sVC = true;
      GMTrace.o(1088639991808L, 8111);
      return true;
    }
    if ((this.pwO == null) && (this.sVB))
    {
      this.sVC = true;
      aux();
      requestLayout();
      GMTrace.o(1088639991808L, 8111);
      return true;
    }
    this.sVC = true;
    GMTrace.o(1088639991808L, 8111);
    return false;
  }
  
  public final void stop()
  {
    GMTrace.i(1087163596800L, 8100);
    long l1;
    long l3;
    if (this.sVK > 0L)
    {
      l1 = this.sVK - this.startTime;
      l3 = bf.Nz() - this.startTime;
      if (l1 <= l3) {
        break label530;
      }
    }
    label530:
    for (long l2 = l3;; l2 = l1)
    {
      int j = (int)l2 * 1000;
      int i = j;
      if (j > getDuration()) {
        i = getDuration();
      }
      v.i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", new Object[] { Integer.valueOf(getDuration()), Long.valueOf(l3), Long.valueOf(l1) });
      if (this.ptG != null) {
        this.ptG.bI(i, getDuration());
      }
      bGz();
      this.sVr.reset();
      try
      {
        if ((this.nHw != null) && (this.sVB))
        {
          Object localObject1 = getSurfaceTexture();
          if (localObject1 != null)
          {
            v.i("MicroMsg.VideoTextureView", "%d releaseSurface", new Object[] { Integer.valueOf(hashCode()) });
            EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
            EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            localEGL10.eglInitialize(localEGLDisplay, null);
            Object localObject2 = new EGLConfig[1];
            int[] arrayOfInt = new int[1];
            localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344 }, (EGLConfig[])localObject2, 1, arrayOfInt);
            arrayOfInt = localObject2[0];
            localObject2 = localEGL10.eglCreateContext(localEGLDisplay, arrayOfInt, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
            localObject1 = localEGL10.eglCreateWindowSurface(localEGLDisplay, arrayOfInt, localObject1, new int[] { 12344 });
            localEGL10.eglMakeCurrent(localEGLDisplay, (EGLSurface)localObject1, (EGLSurface)localObject1, (EGLContext)localObject2);
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
            GLES20.glClear(16384);
            localEGL10.eglSwapBuffers(localEGLDisplay, (EGLSurface)localObject1);
            localEGL10.eglDestroySurface(localEGLDisplay, (EGLSurface)localObject1);
            localEGL10.eglMakeCurrent(localEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            localEGL10.eglDestroyContext(localEGLDisplay, (EGLContext)localObject2);
            localEGL10.eglTerminate(localEGLDisplay);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.VideoTextureView", localException, "release surface", new Object[0]);
        }
      }
      this.sVA = "";
      this.sVL = 0;
      this.sVB = false;
      this.sVC = false;
      this.sVg = 0L;
      GMTrace.o(1087163596800L, 8100);
      return;
      l1 = 2147483647L;
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/VideoTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */