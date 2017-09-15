package com.tencent.mm.c.b;

import android.media.AudioRecord;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.compatible.b.h;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.e.a.kw.b;
import com.tencent.mm.e.a.kx;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class c
{
  public int fAa;
  private f.a fAb;
  public int fzA;
  int fzB;
  int fzC;
  int fzD;
  private int fzE;
  public int fzF;
  private boolean fzG;
  public boolean fzH;
  private int fzI;
  private int fzJ;
  public int fzK;
  private boolean fzL;
  public long fzM;
  int fzN;
  boolean fzO;
  int fzP;
  private boolean fzQ;
  public int fzR;
  public boolean fzS;
  public boolean fzT;
  private AudioRecord fzU;
  public a fzV;
  private f fzW;
  private com.tencent.mm.compatible.b.f fzX;
  public com.tencent.mm.c.c.b fzY;
  private int fzZ;
  private int mSampleRate;
  
  public c(int paramInt1, int paramInt2)
  {
    GMTrace.i(4490254090240L, 33455);
    this.fzA = 0;
    this.fzB = 0;
    this.fzC = 0;
    this.fzD = 0;
    this.fzE = 1;
    this.mSampleRate = 8000;
    this.fzF = 120;
    this.fzG = false;
    this.fzH = false;
    this.fzI = 10;
    this.fzJ = -1;
    this.fzK = -123456789;
    this.fzL = false;
    this.fzM = -1L;
    this.fzO = false;
    this.fzQ = false;
    this.fzR = 0;
    this.fzS = false;
    this.fzT = false;
    this.fzZ = 2;
    this.fAa = 1;
    this.fAb = new f.a()
    {
      public final void c(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(4478308712448L, 33366);
        c.this.fzR += 1;
        if ((c.this.fzT) && (System.currentTimeMillis() - c.this.fzM <= 1000L) && (c.this.fzR - 10 > (System.currentTimeMillis() - c.this.fzM) / c.this.fzF))
        {
          com.tencent.mm.plugin.report.service.g.oSF.a(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.g.oSF.a(151L, 4L, 1L, false);
          v.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", new Object[] { Integer.valueOf(c.this.fzR), Long.valueOf((System.currentTimeMillis() - c.this.fzM) / c.this.fzF) });
          c.this.fzS = true;
        }
        if (c.this.fzY != null) {
          c.this.fzY.h(paramAnonymousArrayOfByte, paramAnonymousInt);
        }
        c localc;
        int m;
        int i;
        int k;
        int n;
        int j;
        if (paramAnonymousInt > 0)
        {
          localc = c.this;
          if ((!localc.fzO) || (-2 != localc.fzC))
          {
            m = paramAnonymousInt / localc.fzN;
            i = 5;
            if (i <= localc.fzP + m)
            {
              k = (i - localc.fzP - 1) * localc.fzN;
              n = localc.fzN + k;
              if (k >= 0)
              {
                j = k;
                if (n <= paramAnonymousInt) {
                  break label642;
                }
              }
              v.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(n) });
            }
            localc.fzP = ((localc.fzP + m) % 5);
            if (localc.fzC == 20)
            {
              localc.fzA = 6;
              v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
              if ((localc.fzB != -1) || (localc.fzD != -1)) {
                break label687;
              }
              localc.fzA = 11;
              v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              label385:
              com.tencent.mm.plugin.report.service.g.oSF.a(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.g.oSF.a(151L, 5L, 1L, false);
              localc.fzC = -2;
              localc.pg();
            }
          }
        }
        if (c.this.fzH)
        {
          if (paramAnonymousInt > 0)
          {
            localc = c.this;
            if (localc.fzB != -1)
            {
              j = 0;
              i = 0;
              label457:
              if (i < paramAnonymousInt / 2)
              {
                m = (short)(paramAnonymousArrayOfByte[(i * 2 + 1)] << 8 | paramAnonymousArrayOfByte[(i * 2 + 0)] & 0xFF);
                if (m < 32760)
                {
                  k = j;
                  if (m != 32768) {}
                }
                else
                {
                  k = j + 1;
                }
                if (k < 5) {
                  break label739;
                }
                localc.fzB += 1;
              }
              if (localc.fzB > 100)
              {
                localc.fzA = 7;
                v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                if ((localc.fzC != -2) || (localc.fzD != -1)) {
                  break label750;
                }
                localc.fzA = 11;
                v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.g.oSF.a(151L, 0L, 1L, false);
              com.tencent.mm.plugin.report.service.g.oSF.a(151L, 6L, 1L, false);
              localc.pg();
              localc.fzB = -1;
              GMTrace.o(4478308712448L, 33366);
              return;
              label642:
              do
              {
                j += 1;
                if (j >= n) {
                  break;
                }
              } while (paramAnonymousArrayOfByte[j] == 0);
              localc.fzC = -1;
              localc.fzO = true;
              localc.fzC += 1;
              i += 5;
              break;
              label687:
              if (localc.fzB == -1)
              {
                localc.fzA = 8;
                v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                break label385;
              }
              if (localc.fzD != -1) {
                break label385;
              }
              localc.fzA = 9;
              v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
              break label385;
              label739:
              i += 1;
              j = k;
              break label457;
              label750:
              if (localc.fzC == -2)
              {
                localc.fzA = 8;
                v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
              }
              else if (localc.fzD == -1)
              {
                localc.fzA = 10;
                v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
              }
            }
          }
          paramAnonymousArrayOfByte = c.this;
          if ((paramAnonymousArrayOfByte.fzD != -1) && (paramAnonymousInt < 0))
          {
            paramAnonymousArrayOfByte.fzD += 1;
            if (paramAnonymousArrayOfByte.fzD >= 50)
            {
              paramAnonymousArrayOfByte.fzA = 5;
              v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
              if ((paramAnonymousArrayOfByte.fzC != -2) || (paramAnonymousArrayOfByte.fzB != -1)) {
                break label925;
              }
              paramAnonymousArrayOfByte.fzA = 11;
              v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.oSF.a(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.g.oSF.a(151L, 7L, 1L, false);
          paramAnonymousArrayOfByte.pg();
          paramAnonymousArrayOfByte.fzD = -1;
          GMTrace.o(4478308712448L, 33366);
          return;
          label925:
          if (paramAnonymousArrayOfByte.fzC == -2)
          {
            paramAnonymousArrayOfByte.fzA = 9;
            v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
          }
          else if (paramAnonymousArrayOfByte.fzB == -1)
          {
            paramAnonymousArrayOfByte.fzA = 10;
            v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
          }
        }
      }
    };
    this.fzE = 1;
    this.mSampleRate = paramInt1;
    this.fzJ = paramInt2;
    if (this.fzE == 2)
    {
      this.fzZ = 3;
      if ((this.fzJ == 0) && (p.gRb.gPL > 0)) {
        this.fzF = p.gRb.gPL;
      }
      if (p.gRb.gPW > 0) {
        this.fzZ = p.gRb.gPW;
      }
      if (p.gRb.gPG > 0) {
        this.fzI = p.gRb.gPG;
      }
      if (p.gQT.gOh) {
        this.fzY = new com.tencent.mm.c.c.b(g.fAz, this.fzE, this.mSampleRate);
      }
      if (1 != g.j("EnableRecorderCheckUnreasonableData", 1)) {
        break label354;
      }
    }
    label354:
    for (boolean bool = true;; bool = false)
    {
      this.fzT = bool;
      v.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", new Object[] { Integer.valueOf(this.mSampleRate), Integer.valueOf(this.fzE), Integer.valueOf(this.fzF), Boolean.valueOf(this.fzG), Integer.valueOf(this.fzJ) });
      GMTrace.o(4490254090240L, 33455);
      return;
      this.fzZ = 2;
      break;
    }
  }
  
  private boolean init()
  {
    GMTrace.i(4491059396608L, 33461);
    this.fAa = 1;
    boolean bool1;
    int i;
    if (p.gRb.gPH == 2)
    {
      bool1 = false;
      i = l.rl();
      j = p.gQT.gOu;
      if ((i & 0x400) == 0) {
        break label167;
      }
      i = j;
      if (j <= 0) {
        i = 0;
      }
      v.i("MicroMsg.MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: " + i);
      label74:
      if (i != 1) {
        break label172;
      }
    }
    int m;
    label167:
    label172:
    for (int k = 1;; k = 0)
    {
      v.d("MicroMsg.MMPcmRecorder", "init, start getMinBufferSize");
      m = AudioRecord.getMinBufferSize(this.mSampleRate, this.fzZ, 2);
      if ((m != -2) && (m != -1)) {
        break label177;
      }
      this.fAa = 3;
      this.fzA = 1;
      v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR " + m);
      pg();
      GMTrace.o(4491059396608L, 33461);
      return false;
      bool1 = true;
      break;
      i = 1;
      break label74;
    }
    label177:
    v.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", new Object[] { Integer.valueOf(m) });
    this.fzN = (this.mSampleRate * 20 * this.fzE * 2 / 1000);
    int n = this.mSampleRate * this.fzF * this.fzE / 1000;
    int i1 = n * 2;
    v.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", new Object[] { Integer.valueOf(m), Integer.valueOf(this.mSampleRate), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(this.fzI), Boolean.valueOf(bool1) });
    int i2 = this.fzJ;
    int j = 1;
    if ((1 == i2) || (6 == i2) || (7 == i2))
    {
      if (Build.VERSION.SDK_INT >= 11) {
        break label600;
      }
      i = 1;
      if (p.gQT.gND) {
        i = 1;
      }
      if (p.gQT.gOb < 0) {
        break label1257;
      }
      i = p.gQT.gOb;
    }
    label600:
    label664:
    label669:
    label737:
    label896:
    label1257:
    for (;;)
    {
      j = i;
      if (6 == i2)
      {
        j = i;
        if (p.gQT.gOE >= 0) {
          j = p.gQT.gOE;
        }
      }
      for (;;)
      {
        try
        {
          this.fzU = new AudioRecord(j, this.mSampleRate, this.fzZ, 2, this.fzI * m);
          if (this.fzU.getState() == 0)
          {
            com.tencent.mm.plugin.report.service.g.oSF.a(151L, 0L, 1L, false);
            com.tencent.mm.plugin.report.service.g.oSF.a(151L, 2L, 1L, false);
            this.fzU.release();
            this.fzA = 2;
            v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
            if (7 != j) {
              break label664;
            }
            i = 1;
            this.fzU = new AudioRecord(i, this.mSampleRate, this.fzZ, 2, this.fzI * m);
          }
          if (this.fzU.getState() != 0) {
            break label669;
          }
          com.tencent.mm.plugin.report.service.g.oSF.a(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.g.oSF.a(151L, 2L, 1L, false);
          this.fzU.release();
          this.fzU = null;
          this.fAa = 2;
          this.fzA = 3;
          v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
          pg();
          GMTrace.o(4491059396608L, 33461);
          return false;
        }
        catch (Exception localException)
        {
          v.e("MicroMsg.MMPcmRecorder", "new AudioRecord failed");
          this.fzA = 12;
          v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
          com.tencent.mm.plugin.report.service.g.oSF.a(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.g.oSF.a(151L, 1L, 1L, false);
          GMTrace.o(4491059396608L, 33461);
          return false;
        }
        i = 7;
        break;
        i = 0;
      }
      Object localObject1;
      Object localObject2;
      if (bool1)
      {
        localObject1 = this.fzU;
        boolean bool2 = this.fzG;
        localObject2 = this.fzV;
        if (((this.fzJ == 1) || (this.fzJ == 6)) && (k != 0))
        {
          bool1 = true;
          this.fzW = new e((AudioRecord)localObject1, bool2, i1, (a)localObject2, bool1);
          this.fzW.a(this.fAb);
          if (-123456789 != this.fzK) {
            this.fzW.cZ(this.fzK);
          }
          if (this.fzL)
          {
            this.fzX = new com.tencent.mm.compatible.b.f();
            localObject1 = this.fzX;
            localObject2 = this.fzU;
            i = this.fzJ;
            v.d("MicroMsg.MMAudioPreProcess", "api " + Build.VERSION.SDK_INT);
            if (!com.tencent.mm.compatible.util.f.ep(16))
            {
              if (localObject2 != null) {
                break label896;
              }
              v.d("MicroMsg.MMAudioPreProcess", "audio is null");
            }
          }
        }
      }
      for (;;)
      {
        GMTrace.o(4491059396608L, 33461);
        return true;
        bool1 = false;
        break;
        this.fzW = new d(this.fzU, this.fzV, this.fzG, n, i1);
        break label737;
        if (1 == i)
        {
          if (p.gRb.gQd != 1)
          {
            v.d("MicroMsg.MMAudioPreProcess", "disable by config");
          }
          else
          {
            if (p.gRb.gQe != 2)
            {
              ((com.tencent.mm.compatible.b.f)localObject1).gNy = new h((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.f)localObject1).gNy != null) && (((com.tencent.mm.compatible.b.f)localObject1).gNy.isAvailable())) {
                ((com.tencent.mm.compatible.b.f)localObject1).gNy.qD();
              }
            }
            if (p.gRb.gQf != 2)
            {
              ((com.tencent.mm.compatible.b.f)localObject1).gNz = new com.tencent.mm.compatible.b.d((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.f)localObject1).gNz != null) && (((com.tencent.mm.compatible.b.f)localObject1).gNz.isAvailable())) {
                ((com.tencent.mm.compatible.b.f)localObject1).gNz.qD();
              }
            }
            if (p.gRb.gQg != 2)
            {
              ((com.tencent.mm.compatible.b.f)localObject1).gNA = new com.tencent.mm.compatible.b.g((AudioRecord)localObject2);
              if ((((com.tencent.mm.compatible.b.f)localObject1).gNA != null) && (((com.tencent.mm.compatible.b.f)localObject1).gNA.isAvailable())) {
                ((com.tencent.mm.compatible.b.f)localObject1).gNA.qD();
              }
            }
          }
        }
        else if (p.gRb.gPK != 1)
        {
          v.d("MicroMsg.MMAudioPreProcess", "disable by config");
        }
        else
        {
          ((com.tencent.mm.compatible.b.f)localObject1).gNy = new h((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.f)localObject1).gNy != null) && (((com.tencent.mm.compatible.b.f)localObject1).gNy.isAvailable())) {
            ((com.tencent.mm.compatible.b.f)localObject1).gNy.qD();
          }
          ((com.tencent.mm.compatible.b.f)localObject1).gNz = new com.tencent.mm.compatible.b.d((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.f)localObject1).gNz != null) && (((com.tencent.mm.compatible.b.f)localObject1).gNz.isAvailable())) {
            ((com.tencent.mm.compatible.b.f)localObject1).gNz.qD();
          }
          ((com.tencent.mm.compatible.b.f)localObject1).gNA = new com.tencent.mm.compatible.b.g((AudioRecord)localObject2);
          if ((((com.tencent.mm.compatible.b.f)localObject1).gNA != null) && (((com.tencent.mm.compatible.b.f)localObject1).gNA.isAvailable())) {
            ((com.tencent.mm.compatible.b.f)localObject1).gNA.qD();
          }
        }
      }
    }
  }
  
  public final void as(boolean paramBoolean)
  {
    GMTrace.i(4490522525696L, 33457);
    this.fzG = paramBoolean;
    v.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.fzG);
    GMTrace.o(4490522525696L, 33457);
  }
  
  public final void at(boolean paramBoolean)
  {
    GMTrace.i(4490925178880L, 33460);
    this.fzL = paramBoolean;
    v.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.fzL);
    GMTrace.o(4490925178880L, 33460);
  }
  
  public final void au(boolean paramBoolean)
  {
    GMTrace.i(4491193614336L, 33462);
    v.i("MicroMsg.MMPcmRecorder", "switchMute mute:" + paramBoolean);
    if (this.fzW != null) {
      this.fzW.au(paramBoolean);
    }
    GMTrace.o(4491193614336L, 33462);
  }
  
  public final void cY(int paramInt)
  {
    GMTrace.i(4490388307968L, 33456);
    this.fzF = paramInt;
    v.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.fzF);
    GMTrace.o(4490388307968L, 33456);
  }
  
  public final boolean oX()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        GMTrace.i(4491462049792L, 33464);
        if (true == this.fzQ)
        {
          v.i("MicroMsg.MMPcmRecorder", "already have stopped");
          GMTrace.o(4491462049792L, 33464);
          return bool1;
        }
        this.fzQ = true;
        Object localObject1 = new g.a();
        if (this.fzY != null)
        {
          this.fzY.pu();
          this.fzY = null;
        }
        ((g.a)localObject1).gSE = SystemClock.elapsedRealtime();
        if (this.fzW != null)
        {
          this.fzW.oP();
          this.fzW = null;
        }
        v.i("MicroMsg.MMPcmRecorder", "cost " + ((g.a)localObject1).se() + "ms to call stopRecord");
        v.i("MicroMsg.MMPcmRecorder", "stopRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
        if (this.fzU == null)
        {
          v.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
          bool1 = false;
          if (((!this.fzO) && (-1L != this.fzM) && (System.currentTimeMillis() - this.fzM >= 2000L)) || (this.fzS))
          {
            v.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
            localObject1 = new kx();
            ((kx)localObject1).fRt.type = 1;
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
            bool2 = false;
          }
          localObject1 = new kw();
          ((kw)localObject1).fRo.type = 1;
          ((kw)localObject1).fRo.fRq = false;
          ((kw)localObject1).fRo.fRr = bool2;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
          v.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", new Object[] { Integer.valueOf(this.fzA) });
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(new IDKey(357, 0, 1));
          if (this.fzA != 0) {
            ((ArrayList)localObject1).add(new IDKey(357, 1, 1));
          }
        }
        switch (this.fzA)
        {
        case 1: 
          v.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
          com.tencent.mm.plugin.report.service.g.oSF.b((ArrayList)localObject1, false);
          GMTrace.o(4491462049792L, 33464);
          continue;
          if (this.fzU.getState() != 1)
          {
            v.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.fzU.getState());
            bool1 = false;
            continue;
          }
          ((g.a)localObject1).gSE = SystemClock.elapsedRealtime();
          this.fzU.stop();
          this.fzU.release();
          this.fzU = null;
          v.i("MicroMsg.MMPcmRecorder", "cost " + ((g.a)localObject1).se() + "ms to call stop and release");
          bool1 = true;
          continue;
          ((ArrayList)localObject1).add(new IDKey(357, 2, 1));
          break;
        case 2: 
          ((ArrayList)localObject2).add(new IDKey(357, 3, 1));
        }
      }
      finally {}
      continue;
      ((ArrayList)localObject2).add(new IDKey(357, 4, 1));
      continue;
      ((ArrayList)localObject2).add(new IDKey(357, 5, 1));
      continue;
      ((ArrayList)localObject2).add(new IDKey(357, 6, 1));
      continue;
      ((ArrayList)localObject2).add(new IDKey(357, 7, 1));
      continue;
      ((ArrayList)localObject2).add(new IDKey(357, 8, 1));
      continue;
      ((ArrayList)localObject2).add(new IDKey(357, 9, 1));
      continue;
      ((ArrayList)localObject2).add(new IDKey(357, 10, 1));
      continue;
      ((ArrayList)localObject2).add(new IDKey(357, 11, 1));
      continue;
      ((ArrayList)localObject2).add(new IDKey(357, 12, 1));
      continue;
      ((ArrayList)localObject2).add(new IDKey(357, 13, 1));
    }
  }
  
  public final void pe()
  {
    GMTrace.i(4490656743424L, 33458);
    this.fzH = true;
    v.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.fzH);
    GMTrace.o(4490656743424L, 33458);
  }
  
  public final boolean pf()
  {
    boolean bool = false;
    GMTrace.i(4491327832064L, 33463);
    v.d("MicroMsg.MMPcmRecorder", "startRecord");
    Object localObject = new kw();
    ((kw)localObject).fRo.type = 1;
    ((kw)localObject).fRo.fRq = true;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    this.fzM = System.currentTimeMillis();
    this.fzO = false;
    if (((kw)localObject).fRp.fRs)
    {
      v.i("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
      this.fzA = 13;
      GMTrace.o(4491327832064L, 33463);
      return false;
    }
    this.fzQ = false;
    localObject = new g.a();
    v.i("MicroMsg.MMPcmRecorder", "startRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
    if (this.fzU != null) {
      v.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
    }
    for (;;)
    {
      if (!bool)
      {
        oX();
        localObject = new kx();
        ((kx)localObject).fRt.type = 1;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
      }
      GMTrace.o(4491327832064L, 33463);
      return bool;
      ((g.a)localObject).gSE = SystemClock.elapsedRealtime();
      v.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
      if (!init())
      {
        v.e("MicroMsg.MMPcmRecorder", "startRecord init error");
      }
      else
      {
        v.i("MicroMsg.MMPcmRecorder", "init cost: " + ((g.a)localObject).se() + "ms");
        ((g.a)localObject).gSE = SystemClock.elapsedRealtime();
        this.fzU.startRecording();
        v.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + ((g.a)localObject).se());
        if (this.fzU.getRecordingState() != 3)
        {
          com.tencent.mm.plugin.report.service.g.oSF.a(151L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.g.oSF.a(151L, 3L, 1L, false);
          this.fAa = 2;
          this.fzA = 4;
          v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
          pg();
        }
        else if (this.fzW != null)
        {
          bool = this.fzW.pf();
        }
        else
        {
          v.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
        }
      }
    }
  }
  
  final void pg()
  {
    GMTrace.i(4491596267520L, 33465);
    if (this.fzV != null) {
      this.fzV.ax(this.fAa, this.fzA);
    }
    GMTrace.o(4491596267520L, 33465);
  }
  
  public final int ph()
  {
    GMTrace.i(4491730485248L, 33466);
    if (this.fzW != null)
    {
      int i = this.fzW.ph();
      GMTrace.o(4491730485248L, 33466);
      return i;
    }
    GMTrace.o(4491730485248L, 33466);
    return -1;
  }
  
  public final void r(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(4490790961152L, 33459);
    if ((10 == this.fzI) || (paramBoolean))
    {
      this.fzI = paramInt;
      v.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.fzI);
    }
    GMTrace.o(4490790961152L, 33459);
  }
  
  public static abstract interface a
  {
    public abstract void ax(int paramInt1, int paramInt2);
    
    public abstract void d(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/c/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */