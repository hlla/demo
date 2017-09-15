package com.tencent.mm.plugin.s;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ad.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class j
{
  public boolean kkZ;
  public long nxG;
  public g nxT;
  public ad nxU;
  public a nyA;
  private ad.a nyB;
  private ad.a nyC;
  private ad.a nyD;
  public long nya;
  public ad nyt;
  public ad nyu;
  public ad nyv;
  public long nyw;
  public boolean nyx;
  public k nyy;
  public boolean nyz;
  public int state;
  
  public j(ad paramad, Looper paramLooper1, Looper paramLooper2, Looper paramLooper3, boolean paramBoolean)
  {
    GMTrace.i(12907987337216L, 96172);
    this.nyx = false;
    this.nyz = false;
    this.nyB = new ad.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(12909597949952L, 96184);
        int i = paramAnonymousMessage.what;
        v.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", new Object[] { j.this.nxT.aKl(), Integer.valueOf(i), Integer.valueOf(j.this.state), Integer.valueOf(j.this.nyy.state) });
        switch (i)
        {
        }
        for (;;)
        {
          GMTrace.o(12909597949952L, 96184);
          return false;
          if (d.pi(j.this.state))
          {
            GMTrace.o(12909597949952L, 96184);
            return false;
          }
          boolean bool2 = d.pi(j.this.nyy.state);
          boolean bool1 = bool2;
          if (j.this.nyA != null) {
            bool1 = bool2 & d.pi(j.this.nyA.state);
          }
          if (bool1)
          {
            j.this.setState(2);
            j.this.nxU.obtainMessage(1).sendToTarget();
            continue;
            j.this.aKw();
            continue;
            if (d.pl(j.this.state))
            {
              GMTrace.o(12909597949952L, 96184);
              return false;
            }
            if ((d.pm(j.this.state)) || (d.pk(j.this.state)))
            {
              j.this.setState(9);
              j.this.nxU.obtainMessage(2).sendToTarget();
              GMTrace.o(12909597949952L, 96184);
              return false;
            }
            bool2 = d.pl(j.this.nyy.state);
            bool1 = bool2;
            if (j.this.nyA != null) {
              bool1 = bool2 & d.pl(j.this.nyA.state);
            }
            if (bool1)
            {
              j.this.setState(9);
              j.this.nxU.obtainMessage(2).sendToTarget();
              continue;
              if ((j.this.nyx) && ((j.this.kkZ) || (j.this.nyz))) {
                j.this.nxU.obtainMessage(6).sendToTarget();
              }
            }
          }
        }
      }
    };
    this.nyC = new ad.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(12906108289024L, 96158);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          GMTrace.o(12906108289024L, 96158);
          return false;
          if (j.this.nyy.aKs())
          {
            j.this.nya = j.this.nyy.nya;
            j.this.a(j.this.nyt, SystemClock.elapsedRealtime(), 0L);
          }
          else
          {
            j.this.nxU.obtainMessage(5, -1, -1).sendToTarget();
            GMTrace.o(12906108289024L, 96158);
            return false;
            paramAnonymousMessage = j.this.nxT;
            long l = bf.aB(paramAnonymousMessage.nxJ);
            if ((paramAnonymousMessage.nxJ > 0L) && (l >= 30L))
            {
              v.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", new Object[] { paramAnonymousMessage.aKl(), Long.valueOf(paramAnonymousMessage.nxJ), Long.valueOf(l) });
              paramAnonymousMessage.nxK = 0L;
            }
            if (d.pl(j.this.nyy.state))
            {
              j.this.nyv.obtainMessage(9).sendToTarget();
              j.this.nyt.removeMessages(2);
            }
            else
            {
              int j = j.this.nyy.l(j.this.nxG, j.this.nyw);
              if (d.pi(j)) {
                j.this.nyv.obtainMessage(2).sendToTarget();
              }
              if (j == 7) {}
              for (int i = 1;; i = 0)
              {
                if (i == 0) {
                  break label356;
                }
                j.this.nyv.obtainMessage(7).sendToTarget();
                j.this.nyt.removeMessages(2);
                break;
              }
              label356:
              if (d.pn(j))
              {
                j.this.a(j.this.nyt, SystemClock.elapsedRealtime(), 0L);
                j.this.nxT.nxJ = bf.NB();
              }
              else
              {
                if (j.this.state == 3) {
                  j.this.a(j.this.nyt, SystemClock.elapsedRealtime(), j.this.nxT.nxK);
                }
                for (;;)
                {
                  j.this.nxT.nxJ = bf.NB();
                  break;
                  if (j.this.state == 5) {
                    j.this.a(j.this.nyt, SystemClock.elapsedRealtime(), 0L);
                  } else if (j.this.state == 1) {
                    j.this.a(j.this.nyt, SystemClock.elapsedRealtime(), 0L);
                  } else if (j.this.state == 0) {
                    j.this.a(j.this.nyt, SystemClock.elapsedRealtime(), 0L);
                  } else if (j.this.state == 6) {
                    j.this.a(j.this.nyt, SystemClock.elapsedRealtime(), 0L);
                  } else {
                    j.this.nyt.removeMessages(2);
                  }
                }
                j.this.pr(3);
                j.this.nyy.start();
                j.this.a(j.this.nyt, SystemClock.elapsedRealtime(), 0L);
                continue;
                j.this.pr(4);
                j.this.a(j.this.nyt, SystemClock.elapsedRealtime(), 0L);
                j.this.nyy.pause();
                continue;
                j.this.nyy.release();
                j.this.nyx = true;
                j.this.nyv.obtainMessage(0).sendToTarget();
              }
            }
          }
        }
      }
    };
    this.nyD = new ad.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(12899665838080L, 96110);
        if (j.this.nyA == null)
        {
          GMTrace.o(12899665838080L, 96110);
          return false;
        }
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          GMTrace.o(12899665838080L, 96110);
          return false;
          if (!j.this.nyA.aKs()) {
            j.this.nyA = null;
          }
          j.this.a(j.this.nyu, SystemClock.elapsedRealtime(), 0L);
          continue;
          if (d.pl(j.this.nyA.state))
          {
            j.this.nyv.obtainMessage(9).sendToTarget();
            j.this.nyu.removeMessages(2);
          }
          else
          {
            if (d.pi(j.this.nyA.l(j.this.nxG, j.this.nyw))) {
              j.this.nyv.obtainMessage(2).sendToTarget();
            }
            if (j.this.state == 3)
            {
              j.this.a(j.this.nyu, SystemClock.elapsedRealtime(), j.this.nxT.nxK);
            }
            else if (j.this.state == 5)
            {
              j.this.a(j.this.nyu, SystemClock.elapsedRealtime(), 0L);
            }
            else if (j.this.state == 1)
            {
              j.this.a(j.this.nyu, SystemClock.elapsedRealtime(), 0L);
            }
            else if (j.this.state == 0)
            {
              j.this.a(j.this.nyu, SystemClock.elapsedRealtime(), 0L);
            }
            else
            {
              j.this.nyu.removeMessages(2);
              continue;
              j.this.nyA.start();
              j.this.a(j.this.nyu, SystemClock.elapsedRealtime(), 0L);
              continue;
              j.this.a(j.this.nyu, SystemClock.elapsedRealtime(), 0L);
              j.this.nyA.pause();
              continue;
              j.this.nyA.release();
              j.this.nyz = true;
              j.this.nyv.obtainMessage(0).sendToTarget();
            }
          }
        }
      }
    };
    this.nxU = paramad;
    this.kkZ = false;
    this.nxT = new g(this.kkZ);
    this.nyv = new ad(paramLooper1, this.nyB);
    this.nyy = new k(this.nxT, this.nxU);
    this.nyt = new ad(paramLooper2, this.nyC);
    if (paramLooper3 != null)
    {
      this.nyA = new a(this.nxT, this.nxU);
      this.nyu = new ad(paramLooper3, this.nyD);
    }
    GMTrace.o(12907987337216L, 96172);
  }
  
  public final void K(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(12908389990400L, 96175);
    v.i("MicroMsg.VideoPlayerImpl", "%s seek to [%d] is precision[%b]", new Object[] { this.nxT.aKl(), Integer.valueOf(paramInt), Boolean.valueOf(true) });
    this.nyy.pause();
    if (this.nyA != null) {
      this.nyA.pause();
    }
    if (paramInt >= this.nya)
    {
      v.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.nya) });
      setState(6);
      this.nyv.obtainMessage(9).sendToTarget();
      GMTrace.o(12908389990400L, 96175);
      return;
    }
    long l = this.nyy.pp(paramInt);
    if ((l >= 0L) && (l < paramInt))
    {
      paramBoolean = true;
      v.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", new Object[] { this.nxT.aKl(), Boolean.valueOf(paramBoolean), Long.valueOf(l), Integer.valueOf(paramInt) });
      this.nyy.setState(6);
      setState(6);
      if (!paramBoolean) {
        break label255;
      }
    }
    label255:
    for (this.nxT.nxF = paramInt;; this.nxT.nxF = l)
    {
      pr(6);
      a(this.nyt, SystemClock.elapsedRealtime(), 0L);
      GMTrace.o(12908389990400L, 96175);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public final void a(ad paramad, long paramLong1, long paramLong2)
  {
    GMTrace.i(12909061079040L, 96180);
    if (d.pl(this.state))
    {
      GMTrace.o(12909061079040L, 96180);
      return;
    }
    try
    {
      Thread localThread = paramad.getLooper().getThread();
      if (localThread != null)
      {
        boolean bool = localThread.isAlive();
        if (!bool)
        {
          GMTrace.o(12909061079040L, 96180);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      paramad.removeMessages(2);
      paramLong1 = paramLong1 + paramLong2 - SystemClock.elapsedRealtime();
      if (paramLong1 <= 0L)
      {
        paramad.sendEmptyMessage(2);
        GMTrace.o(12909061079040L, 96180);
        return;
      }
      paramad.sendEmptyMessageDelayed(2, paramLong1);
      GMTrace.o(12909061079040L, 96180);
    }
  }
  
  public final void aKu()
  {
    GMTrace.i(18681899778048L, 139191);
    v.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", new Object[] { this.nxT.aKl(), Long.valueOf(this.nxT.nxH) });
    if (this.nyy != null)
    {
      this.nyy.m(this.nxT.nxH, -1L);
      this.nyy.aKp();
      this.nyy.nxX = 0L;
    }
    GMTrace.o(18681899778048L, 139191);
  }
  
  public final void aKv()
  {
    GMTrace.i(16173236224000L, 120500);
    if (this.nyy != null)
    {
      v.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", new Object[] { this.nxT.aKl() });
      this.nyy.setState(10);
      a(this.nyt, SystemClock.elapsedRealtime(), 0L);
    }
    GMTrace.o(16173236224000L, 120500);
  }
  
  public final void aKw()
  {
    GMTrace.i(16084652523520L, 119840);
    v.i("MicroMsg.VideoPlayerImpl", "%s seek done", new Object[] { this.nxT.aKl() });
    this.nyy.setState(5);
    if (this.nyA != null)
    {
      this.nxT.nxI = this.nyA.pp((int)this.nxT.nxF);
      this.nyA.setState(5);
    }
    pr(7);
    setState(4);
    this.nxU.obtainMessage(3, 0, 0).sendToTarget();
    this.nxT.nxH = (this.nxT.nxF * 1000L);
    this.nxT.nxF = -1L;
    GMTrace.o(16084652523520L, 119840);
  }
  
  public final void pause()
  {
    GMTrace.i(12908255772672L, 96174);
    setState(4);
    this.nyt.obtainMessage(4).sendToTarget();
    if (this.nyA != null) {
      this.nyu.obtainMessage(4).sendToTarget();
    }
    GMTrace.o(12908255772672L, 96174);
  }
  
  public final void pr(int paramInt)
  {
    GMTrace.i(12908926861312L, 96179);
    v.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", new Object[] { this.nxT.aKl(), Integer.valueOf(paramInt), Long.valueOf(this.nxT.nxD), Long.valueOf(this.nxT.nxE), Long.valueOf(this.nxT.nxG) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.nyw = this.nxT.nxD;
      this.nxG = this.nxT.nxG;
      v.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", new Object[] { this.nxT.aKl(), Integer.valueOf(paramInt), Long.valueOf(this.nyw), Long.valueOf(this.nxG) });
      GMTrace.o(12908926861312L, 96179);
      return;
      g localg;
      if (this.nxT.nxE > 0L)
      {
        localg = this.nxT;
        localg.nxG += this.nxT.nxE - this.nxT.nxD;
        this.nxT.nxE = 0L;
      }
      this.nxT.nxD = SystemClock.elapsedRealtime();
      continue;
      if (this.nxT.nxD <= 0L)
      {
        this.nxT.nxE = 0L;
      }
      else
      {
        this.nxT.nxE = SystemClock.elapsedRealtime();
        continue;
        this.nxT.nxG = this.nxT.nxF;
        this.nxT.nxD = SystemClock.elapsedRealtime();
        this.nxT.nxE = 0L;
        localg = this.nxT;
        this.nxT.nxI = 0L;
        localg.nxH = 0L;
        continue;
        this.nxT.nxG = this.nxT.nxF;
        localg = this.nxT;
        this.nxT.nxE = 0L;
        localg.nxD = 0L;
        localg = this.nxT;
        this.nxT.nxI = 0L;
        localg.nxH = 0L;
        continue;
        this.nxT.nxG = this.nxT.nxF;
        localg = this.nxT;
        this.nxT.nxE = 0L;
        localg.nxD = 0L;
      }
    }
  }
  
  public final void release()
  {
    GMTrace.i(12908658425856L, 96177);
    setState(9);
    this.nyv.removeMessages(2);
    this.nyv.removeMessages(9);
    this.nyt.removeMessages(1);
    this.nyt.removeMessages(2);
    this.nyt.removeMessages(3);
    this.nyt.removeMessages(4);
    this.nyt.removeMessages(6);
    this.nyt.removeCallbacksAndMessages(null);
    try
    {
      this.nyy.setState(9);
      Object localObject = this.nyy;
      v.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", new Object[] { ((k)localObject).aKl(), Boolean.valueOf(((k)localObject).nyG) });
      if ((((k)localObject).nyG) && (com.tencent.mm.compatible.util.d.eq(19))) {
        this.nyy.aKq();
      }
      this.nyt.obtainMessage(7).sendToTarget();
      if (this.nyu != null)
      {
        this.nyu.removeMessages(1);
        this.nyu.removeMessages(2);
        this.nyu.removeMessages(3);
        this.nyu.removeMessages(4);
        this.nyu.removeMessages(6);
        this.nyu.obtainMessage(7).sendToTarget();
      }
      localObject = this.nxT;
      ((g)localObject).nxD = 0L;
      ((g)localObject).nxE = 0L;
      ((g)localObject).nxF = -1L;
      ((g)localObject).nxG = 0L;
      ((g)localObject).nxH = 0L;
      ((g)localObject).nxI = 0L;
      GMTrace.o(12908658425856L, 96177);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.VideoPlayerImpl", localException, "release error %s", new Object[] { localException.toString() });
      }
    }
  }
  
  protected final void setState(int paramInt)
  {
    GMTrace.i(12908792643584L, 96178);
    v.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d stack %s", new Object[] { this.nxT.aKl(), Integer.valueOf(this.state), Integer.valueOf(paramInt), bf.bJP() });
    this.state = paramInt;
    this.nxT.nxJ = 0L;
    GMTrace.o(12908792643584L, 96178);
  }
  
  public final void start()
  {
    GMTrace.i(12908121554944L, 96173);
    setState(3);
    this.nyt.obtainMessage(3).sendToTarget();
    if (this.nyA != null) {
      this.nyu.obtainMessage(3).sendToTarget();
    }
    GMTrace.o(12908121554944L, 96173);
  }
  
  public final void stop()
  {
    GMTrace.i(12908524208128L, 96176);
    setState(8);
    GMTrace.o(12908524208128L, 96176);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/s/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */