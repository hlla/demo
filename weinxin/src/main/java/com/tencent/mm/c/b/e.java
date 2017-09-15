package com.tencent.mm.c.b;

import android.media.AudioRecord;
import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.b.a;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class e
  extends f
{
  public int fAf;
  public boolean fAg;
  private int fAj;
  private b fAk;
  public a fAl;
  public c.a fAm;
  private final Object fAn;
  public final byte[] fAo;
  public final Object fAp;
  private Timer fAq;
  private boolean fAr;
  private boolean fAs;
  public boolean fzG;
  public AudioRecord fzU;
  public int mStatus;
  
  public e(AudioRecord paramAudioRecord, boolean paramBoolean1, int paramInt, c.a parama, boolean paramBoolean2)
  {
    GMTrace.i(4481395720192L, 33389);
    this.mStatus = 0;
    this.fAj = 12800;
    this.fAg = false;
    this.fAk = new b();
    this.fAl = null;
    this.fAn = new Object();
    this.fAo = new byte[0];
    this.fAp = new Object();
    this.fAq = null;
    this.fAr = false;
    this.fAs = false;
    this.fzU = paramAudioRecord;
    this.fzG = paramBoolean1;
    this.fAf = paramInt;
    this.fAm = parama;
    this.fAs = paramBoolean2;
    GMTrace.o(4481395720192L, 33389);
  }
  
  public final void au(boolean paramBoolean)
  {
    GMTrace.i(4482201026560L, 33395);
    this.fAg = paramBoolean;
    GMTrace.o(4482201026560L, 33395);
  }
  
  public final int g(byte[] paramArrayOfByte, int paramInt)
  {
    int j = -1;
    GMTrace.i(4482066808832L, 33394);
    for (;;)
    {
      a locala;
      synchronized (this.fAn)
      {
        if (this.fAl == null) {
          break label301;
        }
        locala = this.fAl;
        i = j;
        if (paramInt > 0)
        {
          i = j;
          if (paramInt <= locala.qC())
          {
            if (paramArrayOfByte != null) {
              continue;
            }
            i = j;
          }
        }
        GMTrace.o(4482066808832L, 33394);
        return i;
        i = j;
        if (locala.gMU == locala.gMV) {
          continue;
        }
        if (locala.gMW) {
          locala.gMX.lock();
        }
        if (locala.gMU < locala.gMV)
        {
          System.arraycopy(locala.gMT, locala.gMU, paramArrayOfByte, 0, paramInt);
          locala.gMU += paramInt;
          if (!locala.gMW) {
            break label314;
          }
          locala.gMX.unlock();
          break label314;
        }
        if (paramInt <= locala.gMR - locala.gMU)
        {
          System.arraycopy(locala.gMT, locala.gMU, paramArrayOfByte, 0, paramInt);
          locala.gMU += paramInt;
        }
      }
      System.arraycopy(locala.gMT, locala.gMU, paramArrayOfByte, 0, locala.gMR - locala.gMU);
      System.arraycopy(locala.gMT, 0, paramArrayOfByte, locala.gMR - locala.gMU, paramInt - (locala.gMR - locala.gMU));
      locala.gMU = (paramInt - (locala.gMR - locala.gMU));
      continue;
      label301:
      GMTrace.o(4482066808832L, 33394);
      return -1;
      label314:
      int i = 0;
    }
  }
  
  public final void oP()
  {
    GMTrace.i(4481664155648L, 33391);
    v.i("MicroMsg.RecordModeAsyncRead", "stopRecord");
    synchronized (this.fAp)
    {
      this.mStatus = 3;
      synchronized (this.fAo)
      {
        this.fAo.notify();
        com.tencent.mm.sdk.f.e.O(this.fAk);
      }
    }
    try
    {
      com.tencent.mm.sdk.f.e.Q(this.fAk);
      if (this.fAl != null)
      {
        if (this.fAq != null)
        {
          this.fAq.cancel();
          this.fAq = null;
        }
        ??? = this.fAl;
        ((a)???).gMR = 0;
        ((a)???).gMS = 0;
        ((a)???).gMU = 0;
        ((a)???).gMV = 0;
        ((a)???).gMT = null;
      }
      synchronized (this.fAn)
      {
        this.fAl = null;
        this.fAm = null;
        this.fAr = false;
        this.fAl = null;
        GMTrace.o(4481664155648L, 33391);
        return;
        localObject2 = finally;
        throw ((Throwable)localObject2);
        localObject3 = finally;
        throw ((Throwable)localObject3);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public final boolean pf()
  {
    int j = -1;
    GMTrace.i(4481529937920L, 33390);
    v.i("MicroMsg.RecordModeAsyncRead", "startRecord");
    int i;
    for (;;)
    {
      synchronized (this.fAp)
      {
        this.mStatus = 1;
        com.tencent.mm.sdk.f.e.b(this.fAk, "RecordModeAsyncRead_record", 10);
        if (true != this.fAs) {
          break label356;
        }
        this.fAl = new a();
        if (this.fAl == null)
        {
          v.e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
          i = 0;
          if (i != 0) {
            break;
          }
          v.e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
          GMTrace.o(4481529937920L, 33390);
          return false;
        }
      }
      this.fAj = (this.fAf * 20);
      v.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.fAj);
      ??? = this.fAl;
      i = this.fAj;
      if (i <= 0) {
        i = -1;
      }
      for (;;)
      {
        if (i == 0) {
          break label229;
        }
        v.e("MicroMsg.RecordModeAsyncRead", "audioBuffer init failed, error code = -1");
        i = 0;
        break;
        ((a)???).gMT = new byte[i];
        if (((a)???).gMT == null)
        {
          i = -1;
        }
        else
        {
          ((a)???).gMR = i;
          if (((a)???).gMW) {
            ((a)???).gMX = new ReentrantLock();
          }
          i = 0;
        }
      }
      label229:
      i = 1;
    }
    if ((this.fAr) || (this.fAq != null))
    {
      v.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.fAr);
      i = j;
    }
    while (i != 0)
    {
      v.e("MicroMsg.RecordModeAsyncRead", "InitAudioRecTimer failed, error code = -1");
      GMTrace.o(4481529937920L, 33390);
      return false;
      this.fAq = new Timer();
      i = j;
      if (this.fAq != null) {
        i = 0;
      }
    }
    this.fAq.scheduleAtFixedRate(new a(), 60L, 20L);
    this.fAr = true;
    label356:
    GMTrace.o(4481529937920L, 33390);
    return true;
  }
  
  public final int pi()
  {
    GMTrace.i(4481798373376L, 33392);
    synchronized (this.fAn)
    {
      if (this.fAl != null)
      {
        int i = this.fAl.gMR;
        GMTrace.o(4481798373376L, 33392);
        return i;
      }
      GMTrace.o(4481798373376L, 33392);
      return -1;
    }
  }
  
  public final int pj()
  {
    GMTrace.i(4481932591104L, 33393);
    synchronized (this.fAn)
    {
      if (this.fAl != null)
      {
        int i = this.fAl.qC();
        GMTrace.o(4481932591104L, 33393);
        return i;
      }
      GMTrace.o(4481932591104L, 33393);
      return -1;
    }
  }
  
  final class a
    extends TimerTask
  {
    private int fAt;
    private int fAu;
    byte[] fAv;
    
    a()
    {
      GMTrace.i(4482335244288L, 33396);
      this.fAt = (e.this.fAf * 2);
      this.fAu = e.this.fAf;
      this.fAv = new byte[this.fAt];
      GMTrace.o(4482335244288L, 33396);
    }
    
    public final void run()
    {
      GMTrace.i(4482469462016L, 33397);
      int j;
      if (!e.this.fAx)
      {
        j = (int)(0.8D * e.this.pi());
        i = j;
        if (j < e.this.fAf * 8) {
          i = e.this.fAf * 8;
        }
        if (e.this.pj() <= i) {
          break label146;
        }
      }
      label146:
      for (int i = 8;; i = 1)
      {
        j = 0;
        while (j < i)
        {
          int k = e.this.g(this.fAv, this.fAu);
          if ((e.this.fAm != null) && (k == 0)) {
            e.this.fAm.d(this.fAv, this.fAu);
          }
          j += 1;
        }
        GMTrace.o(4482469462016L, 33397);
        return;
      }
    }
  }
  
  final class b
    implements Runnable
  {
    b()
    {
      GMTrace.i(4474684833792L, 33339);
      GMTrace.o(4474684833792L, 33339);
    }
    
    public final void run()
    {
      GMTrace.i(4474819051520L, 33340);
      v.i("MicroMsg.RecordModeAsyncRead", "RecordThread started. frameSize:%d", new Object[] { Integer.valueOf(e.this.fAf) });
      if (-123456789 != e.this.fzK)
      {
        v.i("MicroMsg.RecordModeAsyncRead", "set priority to " + e.this.fzK);
        Process.setThreadPriority(e.this.fzK);
      }
      for (;;)
      {
        synchronized (e.this.fAp)
        {
          if (1 != e.this.mStatus)
          {
            v.e("MicroMsg.RecordModeAsyncRead", "status is not inited, now status: " + e.this.mStatus);
            GMTrace.o(4474819051520L, 33340);
            return;
          }
          e.this.mStatus = 2;
          ??? = new byte[e.this.fAf];
          if (2 == e.this.mStatus) {
            synchronized (e.this.fAo)
            {
              boolean bool = e.this.fAx;
              if (!bool) {}
            }
          }
        }
        try
        {
          e.this.fAo.wait();
          if (2 != e.this.mStatus) {}
          Object localObject6;
          int i;
          do
          {
            for (;;)
            {
              v.i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
              GMTrace.o(4474819051520L, 33340);
              return;
              localObject4 = finally;
              throw ((Throwable)localObject4);
              if (e.this.fzU != null) {
                break;
              }
              v.i("MicroMsg.RecordModeAsyncRead", "mAudioRecord is null, so stop record.");
              synchronized (e.this.fAp)
              {
                e.this.mStatus = 3;
              }
            }
            localObject2 = finally;
            throw ((Throwable)localObject2);
            localObject6 = localObject2;
            if (e.this.fzG) {
              localObject6 = new byte[e.this.fAf];
            }
            e.this.fAy += 1;
            new g.a();
            i = e.this.fzU.read((byte[])localObject6, 0, e.this.fAf);
          } while (2 != e.this.mStatus);
          if (e.this.fAb != null) {
            e.this.fAb.c(i, (byte[])localObject6);
          }
          if (e.this.fAf != i) {
            v.i("MicroMsg.RecordModeAsyncRead", "read len " + i);
          }
          if (i < e.this.fAf) {
            v.i("MicroMsg.RecordModeAsyncRead", "read too fast? sleep 10 ms");
          }
          try
          {
            Thread.sleep(10L);
            Object localObject3 = localObject6;
            if (e.this.fAm == null) {
              continue;
            }
            localObject3 = localObject6;
            if (i <= 0) {
              continue;
            }
            int j = i;
            if (i > localObject6.length) {
              j = localObject6.length;
            }
            if (e.this.fAl != null)
            {
              if (e.this.fAg) {
                Arrays.fill((byte[])localObject6, 0, j, (byte)0);
              }
              localObject3 = e.this.fAl;
              if (j > 0)
              {
                if (((a)localObject3).gMW) {
                  ((a)localObject3).gMX.lock();
                }
                if (((a)localObject3).gMU != ((a)localObject3).gMV) {
                  break label641;
                }
                i = ((a)localObject3).gMR;
                label585:
                if (j <= i) {
                  break label767;
                }
              }
              for (i = -1;; i = -1)
              {
                localObject3 = localObject6;
                if (i == 0) {
                  break;
                }
                v.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(e.this.fAl.qC()) });
                localObject3 = localObject6;
                break;
                label641:
                if ((((a)localObject3).gMV + 1) % ((a)localObject3).gMR == ((a)localObject3).gMU)
                {
                  i = 0;
                  break label585;
                }
                if (((a)localObject3).gMU < ((a)localObject3).gMV) {
                  ((a)localObject3).gMS = (((a)localObject3).gMV - ((a)localObject3).gMU);
                }
                for (;;)
                {
                  if (((a)localObject3).gMW) {
                    ((a)localObject3).gMX.unlock();
                  }
                  i = ((a)localObject3).gMR - ((a)localObject3).gMS;
                  break;
                  if (((a)localObject3).gMU > ((a)localObject3).gMV) {
                    ((a)localObject3).gMS = (((a)localObject3).gMV + ((a)localObject3).gMR - ((a)localObject3).gMU);
                  }
                }
                label767:
                if ((((a)localObject3).gMV + j) % ((a)localObject3).gMR != ((a)localObject3).gMU) {
                  break label793;
                }
              }
              label793:
              if (((a)localObject3).gMW) {
                ((a)localObject3).gMX.lock();
              }
              if ((((a)localObject3).gMU < ((a)localObject3).gMV) && (j > ((a)localObject3).gMR - ((a)localObject3).gMV))
              {
                System.arraycopy(localObject6, 0, ((a)localObject3).gMT, ((a)localObject3).gMV, ((a)localObject3).gMR - ((a)localObject3).gMV);
                System.arraycopy(localObject6, ((a)localObject3).gMR - ((a)localObject3).gMV, ((a)localObject3).gMT, 0, j - (((a)localObject3).gMR - ((a)localObject3).gMV));
                ((a)localObject3).gMV = (j - (((a)localObject3).gMR - ((a)localObject3).gMV));
              }
              for (((a)localObject3).gMV %= ((a)localObject3).gMR;; ((a)localObject3).gMV = ((j + ((a)localObject3).gMV) % ((a)localObject3).gMR))
              {
                if (((a)localObject3).gMW) {
                  ((a)localObject3).gMX.unlock();
                }
                i = 0;
                break;
                System.arraycopy(localObject6, 0, ((a)localObject3).gMT, ((a)localObject3).gMV, j);
              }
            }
            localObject3 = localObject6;
            if (e.this.fAm == null) {
              continue;
            }
            if (e.this.fAg) {
              Arrays.fill((byte[])localObject6, 0, j, (byte)0);
            }
            e.this.fAm.d((byte[])localObject6, j);
            localObject3 = localObject6;
          }
          catch (InterruptedException localInterruptedException1)
          {
            for (;;) {}
          }
        }
        catch (InterruptedException localInterruptedException2)
        {
          for (;;) {}
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/c/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */