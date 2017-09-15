package com.tencent.mm.plugin.s;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ad.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class i
{
  Looper nyk;
  ad nyl;
  HandlerThread nym;
  HandlerThread nyn;
  HandlerThread nyo;
  public j nyp;
  public c nyq;
  private ad.a nyr;
  
  public i(Looper paramLooper)
  {
    this(paramLooper, (byte)0);
    GMTrace.i(12906242506752L, 96159);
    GMTrace.o(12906242506752L, 96159);
  }
  
  private i(Looper paramLooper, byte paramByte)
  {
    GMTrace.i(12906376724480L, 96160);
    this.nyr = new ad.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(12905839853568L, 96156);
        int i = paramAnonymousMessage.what;
        switch (i)
        {
        default: 
          v.w("MicroMsg.VideoPlayer", "%s it has no idea for msg %d ", new Object[] { i.this.aKl(), Integer.valueOf(i) });
        }
        for (;;)
        {
          GMTrace.o(12905839853568L, 96156);
          return false;
          v.i("MicroMsg.VideoPlayer", "%s call prepared ", new Object[] { i.this.aKl() });
          if (i.this.nyq != null)
          {
            i.this.nyq.TZ();
            continue;
            v.i("MicroMsg.VideoPlayer", "%s call completion ", new Object[] { i.this.aKl() });
            if (i.this.nyq != null)
            {
              i.this.nyq.oW();
              continue;
              v.i("MicroMsg.VideoPlayer", "%s call seek completion ", new Object[] { i.this.aKl() });
              if (i.this.nyq != null)
              {
                i.this.nyq.aKg();
                continue;
                v.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", new Object[] { i.this.aKl(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2), Integer.valueOf(((Integer)paramAnonymousMessage.obj).intValue()) });
                if (i.this.nyq != null)
                {
                  i.this.nyq.E(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2, ((Integer)paramAnonymousMessage.obj).intValue());
                  continue;
                  v.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", new Object[] { i.this.aKl(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
                  if (i.this.nyq != null)
                  {
                    i.this.nyq.onError(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
                    continue;
                    try
                    {
                      paramAnonymousMessage = i.this;
                      v.i("MicroMsg.VideoPlayer", "%s clear now.", new Object[] { paramAnonymousMessage.aKl() });
                      paramAnonymousMessage.nym.quit();
                      paramAnonymousMessage.nyn.quit();
                      if (paramAnonymousMessage.nyo != null) {
                        paramAnonymousMessage.nyo.quit();
                      }
                      paramAnonymousMessage.nyl.removeMessages(1);
                      paramAnonymousMessage.nyl.removeMessages(2);
                      paramAnonymousMessage.nyl.removeMessages(3);
                      paramAnonymousMessage.nyl.removeMessages(4);
                      paramAnonymousMessage.nyl.removeMessages(5);
                      paramAnonymousMessage.nym = null;
                      paramAnonymousMessage.nyn = null;
                      paramAnonymousMessage.nyl = null;
                      paramAnonymousMessage.nyk = null;
                      paramAnonymousMessage.nyq = null;
                      paramAnonymousMessage.nyp = null;
                    }
                    catch (Exception paramAnonymousMessage) {}
                  }
                }
              }
            }
          }
        }
      }
    };
    this.nym = e.cE("VideoPlayer:inner", -16);
    this.nym.start();
    this.nyn = e.cE("VideoPlayer:video", -16);
    this.nyn.start();
    this.nyo = e.cE("VideoPlayer:audio", -16);
    this.nyo.start();
    this.nyk = paramLooper;
    this.nyl = new ad(this.nyk, this.nyr);
    ad localad = this.nyl;
    Looper localLooper1 = this.nym.getLooper();
    Looper localLooper2 = this.nyn.getLooper();
    if (this.nyo != null) {}
    for (paramLooper = this.nyo.getLooper();; paramLooper = null)
    {
      this.nyp = new j(localad, localLooper1, localLooper2, paramLooper, false);
      GMTrace.o(12906376724480L, 96160);
      return;
    }
  }
  
  public final String aKl()
  {
    GMTrace.i(12907853119488L, 96171);
    if (this.nyp != null)
    {
      String str = this.nyp.nxT.aKl();
      GMTrace.o(12907853119488L, 96171);
      return str;
    }
    GMTrace.o(12907853119488L, 96171);
    return "has no player!";
  }
  
  public final boolean aKs()
  {
    GMTrace.i(12906913595392L, 96164);
    j localj = this.nyp;
    v.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", new Object[] { localj.nxT.aKl() });
    localj.nyt.obtainMessage(1).sendToTarget();
    if (localj.nyA != null) {
      localj.nyu.obtainMessage(1).sendToTarget();
    }
    GMTrace.o(12906913595392L, 96164);
    return true;
  }
  
  public final int aKt()
  {
    GMTrace.i(12907584684032L, 96169);
    j localj = this.nyp;
    int i;
    int j;
    if (localj.nxT != null)
    {
      i = (int)(localj.nxT.nxH / 1000L);
      j = (int)localj.nxT.nxF;
      if (j == -1)
      {
        j = i;
        if (i < localj.nxT.nxI / 1000L) {
          j = (int)(localj.nxT.nxI / 1000L);
        }
        v.i("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", new Object[] { localj.nxT.aKl(), Integer.valueOf(j), Long.valueOf(localj.nxT.nxH), Long.valueOf(localj.nxT.nxI) });
      }
    }
    for (;;)
    {
      GMTrace.o(12907584684032L, 96169);
      return j;
      i = j;
      break;
      j = 0;
    }
  }
  
  public final void bQ(boolean paramBoolean)
  {
    GMTrace.i(17458370969600L, 130075);
    try
    {
      if (this.nyp != null)
      {
        j localj = this.nyp;
        if (localj.nyA != null)
        {
          v.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", new Object[] { localj.nxT.aKl(), Boolean.valueOf(paramBoolean) });
          localj.nyA.bQ(paramBoolean);
        }
      }
      GMTrace.o(17458370969600L, 130075);
      return;
    }
    catch (Exception localException)
    {
      GMTrace.o(17458370969600L, 130075);
    }
  }
  
  public final void fA(boolean paramBoolean)
  {
    GMTrace.i(18682033995776L, 139192);
    if (this.nyp != null)
    {
      j localj = this.nyp;
      if (localj.nxT != null)
      {
        v.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", new Object[] { localj.nxT.aKl(), Boolean.valueOf(paramBoolean) });
        localj.nxT.nxN = paramBoolean;
      }
    }
    GMTrace.o(18682033995776L, 139192);
  }
  
  public final void fz(boolean paramBoolean)
  {
    GMTrace.i(12906645159936L, 96162);
    if (this.nyp != null)
    {
      j localj = this.nyp;
      if (localj.nxT != null) {
        localj.nxT.nxM = paramBoolean;
      }
    }
    GMTrace.o(12906645159936L, 96162);
  }
  
  public final boolean isPlaying()
  {
    GMTrace.i(12907718901760L, 96170);
    boolean bool = d.pj(this.nyp.state);
    GMTrace.o(12907718901760L, 96170);
    return bool;
  }
  
  public final void pause()
  {
    GMTrace.i(12907182030848L, 96166);
    v.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", new Object[] { aKl(), Integer.valueOf(this.nyp.state), bf.bJP() });
    if ((d.pm(this.nyp.state)) || (d.pk(this.nyp.state)))
    {
      v.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", new Object[] { aKl() });
      GMTrace.o(12907182030848L, 96166);
      return;
    }
    this.nyp.pause();
    GMTrace.o(12907182030848L, 96166);
  }
  
  public final void pq(int paramInt)
  {
    GMTrace.i(12907316248576L, 96167);
    this.nyp.K(paramInt, true);
    GMTrace.o(12907316248576L, 96167);
  }
  
  public final void release()
  {
    GMTrace.i(12907450466304L, 96168);
    try
    {
      this.nyp.release();
      GMTrace.o(12907450466304L, 96168);
      return;
    }
    catch (Exception localException)
    {
      GMTrace.o(12907450466304L, 96168);
    }
  }
  
  public final void setPath(String paramString)
  {
    GMTrace.i(12906510942208L, 96161);
    v.i("MicroMsg.VideoPlayer", "%s video player set path %s", new Object[] { aKl(), paramString });
    j localj = this.nyp;
    v.i("MicroMsg.VideoPlayerImpl", "%s set path %s", new Object[] { localj.nxT.aKl(), paramString });
    localj.nyy.setPath(paramString);
    if (localj.nyA != null) {
      localj.nyA.setPath(paramString);
    }
    GMTrace.o(12906510942208L, 96161);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    GMTrace.i(12906779377664L, 96163);
    if (paramSurface != null)
    {
      j localj = this.nyp;
      v.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", new Object[] { localj.nxT.aKl(), Integer.valueOf(paramSurface.hashCode()) });
      localj.nyy.nyF = paramSurface;
    }
    GMTrace.o(12906779377664L, 96163);
  }
  
  public final void start()
  {
    GMTrace.i(12907047813120L, 96165);
    v.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", new Object[] { aKl(), Integer.valueOf(this.nyp.state), bf.bJP() });
    if ((d.pm(this.nyp.state)) || (d.pk(this.nyp.state)))
    {
      v.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", new Object[] { aKl() });
      GMTrace.o(12907047813120L, 96165);
      return;
    }
    this.nyp.start();
    GMTrace.o(12907047813120L, 96165);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/s/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */