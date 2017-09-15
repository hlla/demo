package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.compatible.d.a;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class s
  implements d
{
  public String fyw;
  public MediaPlayer ibY;
  public b ibZ;
  public d.a ibu;
  public d.b ibv;
  public int status;
  
  public s()
  {
    GMTrace.i(569217384448L, 4241);
    this.fyw = "";
    this.ibu = null;
    this.ibv = null;
    this.status = 0;
    this.ibY = new i();
    LF();
    LG();
    v.d("MicroMsg.VoicePlayer", "VoicePlayer");
    GMTrace.o(569217384448L, 4241);
  }
  
  public s(Context paramContext)
  {
    this();
    GMTrace.i(569351602176L, 4242);
    this.ibZ = new b(paramContext);
    v.d("MicroMsg.VoicePlayer", "VoicePlayer context");
    GMTrace.o(569351602176L, 4242);
  }
  
  private void LF()
  {
    GMTrace.i(569754255360L, 4245);
    this.ibY.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        GMTrace.i(571499085824L, 4258);
        v.d("MicroMsg.VoicePlayer", "OnCompletionListener");
        if (s.this.ibZ != null)
        {
          v.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
          s.this.ibZ.rY();
        }
        if (s.this.ibu != null)
        {
          v.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
          s.this.ibu.oW();
        }
        try
        {
          v.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
          s.this.ibY.release();
          s.this.status = 0;
          GMTrace.o(571499085824L, 4258);
          return;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          v.e("MicroMsg.VoicePlayer", "setCompletion File[" + s.this.fyw + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
          GMTrace.o(571499085824L, 4258);
        }
      }
    });
    GMTrace.o(569754255360L, 4245);
  }
  
  private void LG()
  {
    GMTrace.i(569888473088L, 4246);
    this.ibY.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(546266152960L, 4070);
        v.d("MicroMsg.VoicePlayer", "OnErrorListener");
        if (s.this.ibZ != null)
        {
          v.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
          s.this.ibZ.rY();
        }
        if (s.this.ibv != null)
        {
          v.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
          s.this.ibv.onError();
        }
        try
        {
          v.d("MicroMsg.VoicePlayer", "OnErrorListener release");
          s.this.ibY.release();
          s.this.status = -1;
          GMTrace.o(546266152960L, 4070);
          return false;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          for (;;)
          {
            v.e("MicroMsg.VoicePlayer", "setErrorListener File[" + s.this.fyw + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
          }
        }
      }
    });
    GMTrace.o(569888473088L, 4246);
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    int j = 3;
    GMTrace.i(570559561728L, 4251);
    if (!e.aO(this.fyw))
    {
      GMTrace.o(570559561728L, 4251);
      return;
    }
    int i;
    if (paramBoolean) {
      i = 3;
    }
    label251:
    for (;;)
    {
      try
      {
        v.d("MicroMsg.VoicePlayer", "playImp speakerOn:%s,seekTo:%s,type:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (!p.gQT.gND) {
          break label251;
        }
        p.gQT.dump();
        if (p.gQT.gNK != 1) {
          break label251;
        }
        i = j;
        if (this.ibZ != null)
        {
          v.d("MicroMsg.VoicePlayer", "playImp audioFocusHelper.requestFocus");
          this.ibZ.requestFocus();
        }
        this.ibY.setAudioStreamType(i);
        this.ibY.setDataSource(this.fyw);
        this.ibY.prepare();
        if (paramInt > 0) {
          this.ibY.seekTo(paramInt);
        }
        this.ibY.start();
        GMTrace.o(570559561728L, 4251);
        return;
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.VoicePlayer", "playImp : fail, exception = " + localException.getMessage());
        v.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { bf.g(localException) });
        if (this.ibZ == null) {
          continue;
        }
        this.ibZ.rY();
        GMTrace.o(570559561728L, 4251);
        return;
      }
      i = 0;
    }
  }
  
  private boolean d(String paramString, boolean paramBoolean, int paramInt)
  {
    GMTrace.i(570425344000L, 4250);
    if (this.status != 0)
    {
      v.e("MicroMsg.VoicePlayer", "startPlay error status:" + this.status);
      GMTrace.o(570425344000L, 4250);
      return false;
    }
    v.i("MicroMsg.VoicePlayer", "startPlay speakerOn:%s,seekTo:%s,", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    this.fyw = paramString;
    try
    {
      b(paramBoolean, paramInt);
      this.status = 1;
      GMTrace.o(570425344000L, 4250);
      return true;
    }
    catch (Exception paramString)
    {
      try
      {
        b(true, paramInt);
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.VoicePlayer", "startPlay File[" + this.fyw + "] failed");
        v.e("MicroMsg.VoicePlayer", "exception:%s", new Object[] { bf.g(paramString) });
        this.status = -1;
        GMTrace.o(570425344000L, 4250);
      }
    }
    return false;
  }
  
  public final boolean C(String paramString, boolean paramBoolean)
  {
    GMTrace.i(570156908544L, 4248);
    paramBoolean = d(paramString, paramBoolean, 0);
    GMTrace.o(570156908544L, 4248);
    return paramBoolean;
  }
  
  public final void a(d.a parama)
  {
    GMTrace.i(569485819904L, 4243);
    this.ibu = parama;
    GMTrace.o(569485819904L, 4243);
  }
  
  public final void a(d.b paramb)
  {
    GMTrace.i(569620037632L, 4244);
    this.ibv = paramb;
    GMTrace.o(569620037632L, 4244);
  }
  
  public final boolean ao(boolean paramBoolean)
  {
    GMTrace.i(17482127507456L, 130252);
    if (this.status != 1)
    {
      v.e("MicroMsg.VoicePlayer", "pause not STATUS_PLAYING error status:" + this.status);
      GMTrace.o(17482127507456L, 130252);
      return false;
    }
    try
    {
      v.d("MicroMsg.VoicePlayer", "pause mediaPlayer.pause()");
      this.ibY.pause();
      if ((this.ibZ != null) && (paramBoolean))
      {
        v.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.ibZ.rY();
      }
      this.status = 2;
      GMTrace.o(17482127507456L, 130252);
      return true;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.VoicePlayer", "pause File[" + this.fyw + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      if ((this.ibZ != null) && (paramBoolean))
      {
        v.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.ibZ.rY();
      }
      GMTrace.o(17482127507456L, 130252);
      return false;
    }
    finally
    {
      if ((this.ibZ != null) && (paramBoolean))
      {
        v.d("MicroMsg.VoicePlayer", "pause audioFocusHelper.abandonFocus()");
        this.ibZ.rY();
      }
    }
  }
  
  public final void aq(boolean paramBoolean)
  {
    GMTrace.i(570022690816L, 4247);
    v.d("MicroMsg.VoicePlayer", "setSpeakerOn=" + paramBoolean);
    if (this.ibY == null)
    {
      GMTrace.o(570022690816L, 4247);
      return;
    }
    if (ao.oS())
    {
      v.v("MicroMsg.VoicePlayer", "setSpeakOn return when calling");
      GMTrace.o(570022690816L, 4247);
      return;
    }
    int i = this.ibY.getCurrentPosition();
    pd();
    this.ibY = new i();
    LF();
    LG();
    d(this.fyw, paramBoolean, i);
    GMTrace.o(570022690816L, 4247);
  }
  
  public final void b(b.a parama)
  {
    GMTrace.i(17482261725184L, 130253);
    if ((this.ibZ != null) && (parama != null)) {
      this.ibZ.a(parama);
    }
    GMTrace.o(17482261725184L, 130253);
  }
  
  public final boolean c(String paramString, boolean paramBoolean, int paramInt)
  {
    GMTrace.i(570291126272L, 4249);
    paramBoolean = d(paramString, paramBoolean, paramInt);
    GMTrace.o(570291126272L, 4249);
    return paramBoolean;
  }
  
  public final int getStatus()
  {
    GMTrace.i(569083166720L, 4240);
    int i = this.status;
    GMTrace.o(569083166720L, 4240);
    return i;
  }
  
  public final boolean isPlaying()
  {
    GMTrace.i(570962214912L, 4254);
    if (this.status == 1)
    {
      GMTrace.o(570962214912L, 4254);
      return true;
    }
    GMTrace.o(570962214912L, 4254);
    return false;
  }
  
  public final boolean oR()
  {
    GMTrace.i(570827997184L, 4253);
    if (this.status != 2)
    {
      v.e("MicroMsg.VoicePlayer", "resume not STATUS_PAUSE error status:" + this.status);
      GMTrace.o(570827997184L, 4253);
      return false;
    }
    try
    {
      v.d("MicroMsg.VoicePlayer", "resume mediaPlayer.start()");
      this.ibY.start();
      if (this.ibZ != null)
      {
        v.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.ibZ.requestFocus();
      }
      this.status = 1;
      GMTrace.o(570827997184L, 4253);
      return true;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.VoicePlayer", "resume File[" + this.fyw + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      if (this.ibZ != null)
      {
        v.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.ibZ.requestFocus();
      }
      GMTrace.o(570827997184L, 4253);
      return false;
    }
    finally
    {
      if (this.ibZ != null)
      {
        v.d("MicroMsg.VoicePlayer", "resume audioFocusHelper.requestFocus()");
        this.ibZ.requestFocus();
      }
    }
  }
  
  public final double oU()
  {
    GMTrace.i(571230650368L, 4256);
    if ((this.status != 1) && (this.status != 2))
    {
      GMTrace.o(571230650368L, 4256);
      return 0.0D;
    }
    int i;
    int j;
    try
    {
      i = this.ibY.getCurrentPosition();
      j = this.ibY.getDuration();
      if (j == 0)
      {
        v.e("MicroMsg.VoicePlayer", "getDuration File[" + this.fyw + "] Failed");
        GMTrace.o(571230650368L, 4256);
        return 0.0D;
      }
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.VoicePlayer", "getNowProgress File[" + this.fyw + "] ErrMsg[" + localException.getStackTrace() + "]");
      pd();
      GMTrace.o(571230650368L, 4256);
      return 0.0D;
    }
    double d = i / j;
    GMTrace.o(571230650368L, 4256);
    return d;
  }
  
  public final boolean pd()
  {
    GMTrace.i(571096432640L, 4255);
    if ((this.status != 1) && (this.status != 2))
    {
      v.e("MicroMsg.VoicePlayer", "stop not STATUS_PLAYING or STATUS_PAUSE error status:" + this.status);
      GMTrace.o(571096432640L, 4255);
      return false;
    }
    try
    {
      v.d("MicroMsg.VoicePlayer", "stop mediaPlayer.stop()");
      this.ibY.stop();
      this.ibY.release();
      if (this.ibZ != null)
      {
        v.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.ibZ.rY();
      }
      this.status = 0;
      GMTrace.o(571096432640L, 4255);
      return true;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.VoicePlayer", "stop File[" + this.fyw + "] ErrMsg[" + localException.getStackTrace() + "]");
      this.status = -1;
      if (this.ibZ != null)
      {
        v.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.ibZ.rY();
      }
      GMTrace.o(571096432640L, 4255);
      return false;
    }
    finally
    {
      if (this.ibZ != null)
      {
        v.d("MicroMsg.VoicePlayer", "stop audioFocusHelper.abandonFocus()");
        this.ibZ.rY();
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvoice/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */