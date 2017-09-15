package com.tencent.mm.c.b;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.au.c.1;
import com.tencent.mm.au.d;
import com.tencent.mm.au.d.a;
import com.tencent.mm.au.d.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public final class b
{
  public static Object fzi;
  public int fyY;
  public String fyZ;
  private int fza;
  public com.tencent.mm.c.c.c fzb;
  public a fzc;
  public com.tencent.mm.au.c fzd;
  public d.a fze;
  public long fzf;
  public long fzg;
  public int fzh;
  public int fzj;
  public boolean fzk;
  public MediaRecorder fzl;
  public c fzm;
  public com.tencent.mm.compatible.b.b.a fzn;
  public b fzo;
  public volatile boolean fzp;
  public com.tencent.mm.compatible.util.g.a fzq;
  private c.a fzr;
  public int mSampleRate;
  
  static
  {
    GMTrace.i(4474550616064L, 33338);
    fzi = new Object();
    GMTrace.o(4474550616064L, 33338);
  }
  
  public b(com.tencent.mm.compatible.b.b.a parama)
  {
    GMTrace.i(4469987213312L, 33304);
    this.fyY = 0;
    this.fyZ = null;
    this.fzb = null;
    this.fzd = null;
    this.fze = null;
    this.fzf = 0L;
    this.fzg = 0L;
    this.fzh = 0;
    this.mSampleRate = 8000;
    this.fzj = 16000;
    this.fzk = false;
    this.fzm = null;
    this.fzp = false;
    this.fzq = new com.tencent.mm.compatible.util.g.a();
    this.fzr = new c.a()
    {
      private static byte[] e(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        GMTrace.i(4478979801088L, 33371);
        int j = paramAnonymousInt % 4;
        int i = paramAnonymousInt;
        if (j != 0) {
          i = paramAnonymousInt - j;
        }
        if (i <= 0)
        {
          GMTrace.o(4478979801088L, 33371);
          return null;
        }
        byte[] arrayOfByte = new byte[i / 2];
        paramAnonymousInt = 0;
        while (paramAnonymousInt < i / 2)
        {
          arrayOfByte[paramAnonymousInt] = paramAnonymousArrayOfByte[(paramAnonymousInt * 2)];
          arrayOfByte[(paramAnonymousInt + 1)] = paramAnonymousArrayOfByte[(paramAnonymousInt * 2 + 1)];
          paramAnonymousInt += 2;
        }
        GMTrace.o(4478979801088L, 33371);
        return arrayOfByte;
      }
      
      private void f(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        GMTrace.i(4479114018816L, 33372);
        int i = 0;
        while (i < paramAnonymousInt / 2)
        {
          int j = (short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8);
          if (j > b.this.fyY) {
            b.this.fyY = j;
          }
          i += 1;
        }
        GMTrace.o(4479114018816L, 33372);
      }
      
      public final void ax(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(4479248236544L, 33373);
        GMTrace.o(4479248236544L, 33373);
      }
      
      public final void d(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        GMTrace.i(4478845583360L, 33370);
        v.i("MicroMsg.MMAudioRecorder", "onRecPcmDataReady, markStop: %s", new Object[] { Boolean.valueOf(b.this.fzp) });
        if ((b.this.fzo == b.b.fzy) && (!b.this.fzp))
        {
          v.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
          GMTrace.o(4478845583360L, 33370);
          return;
        }
        boolean bool1 = false;
        boolean bool2 = false;
        synchronized (b.fzi)
        {
          if (b.this.fzp)
          {
            if (b.this.fzm != null)
            {
              v.i("MicroMsg.MMAudioRecorder", "do stop pcm recorder, last frame data: %s, read: %s", new Object[] { paramAnonymousArrayOfByte, Integer.valueOf(paramAnonymousInt) });
              b.this.fzm.oX();
              b.this.fzm.fzV = null;
              b.this.fzm = null;
              bool1 = true;
              b.this.fzp = false;
            }
          }
          else
          {
            long l = bf.aA(b.this.fzg);
            if ((b.this.fzf <= 0L) || (l <= b.this.fzf)) {
              break label281;
            }
            v.w("MicroMsg.MMAudioRecorder", "Stop now ! expire duration ms:" + l);
            new ad(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(4475758575616L, 33347);
                b.this.pd();
                if (b.this.fzc != null) {
                  b.this.fzc.onError();
                }
                GMTrace.o(4475758575616L, 33347);
              }
            });
            GMTrace.o(4478845583360L, 33370);
            return;
          }
          v.i("MicroMsg.MMAudioRecorder", "stop now, but recorder is null");
          bool1 = bool2;
        }
        label281:
        v.d("MicroMsg.MMAudioRecorder", "read :" + paramAnonymousInt + " time: " + b.this.fzq.se() + " dataReadedCnt: " + b.this.fzh);
        if (paramAnonymousInt < 0)
        {
          if (b.this.fzo == b.b.fzy)
          {
            v.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
            GMTrace.o(4478845583360L, 33370);
            return;
          }
          new ad(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(4480187760640L, 33380);
              b.this.pd();
              if (b.this.fzc != null) {
                b.this.fzc.onError();
              }
              GMTrace.o(4480187760640L, 33380);
            }
          });
          GMTrace.o(4478845583360L, 33370);
          return;
        }
        b.this.fzh += paramAnonymousInt;
        if ((b.this.fzd == null) && ((b.this.fzn == com.tencent.mm.compatible.b.b.a.gMY) || (b.this.fzn == com.tencent.mm.compatible.b.b.a.gNa)) && (b.this.fze != null) && (b.this.fzk))
        {
          b.this.fzd = new com.tencent.mm.au.c();
          ??? = b.this.fzd;
          i = b.this.mSampleRate;
          v.i("MicroMsg.SpeexEncoderWorker", "init ");
          ((com.tencent.mm.au.c)???).hTv.clear();
          d.b localb = new d.b();
          localb.hQT = d.getPrefix();
          localb.sampleRate = i;
          localb.hTq = 1;
          localb.hTr = 16;
          ((com.tencent.mm.au.c)???).mFileName = String.format("%s%d_%d_%d_%d", new Object[] { localb.hQT, Integer.valueOf(localb.sampleRate), Integer.valueOf(localb.hTq), Integer.valueOf(localb.hTr), Long.valueOf(System.currentTimeMillis()) });
        }
        if (b.this.fzd != null)
        {
          ??? = b.this.fzd;
          v.d("MicroMsg.SpeexEncoderWorker", "push into queue queueLen:" + ((com.tencent.mm.au.c)???).hTv.size());
          if ((paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0)) {
            ((com.tencent.mm.au.c)???).hTv.add(new g.a(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length));
          }
        }
        if (b.this.fzn == com.tencent.mm.compatible.b.b.a.gNa)
        {
          if (b.this.fzb == null)
          {
            b.this.fzb = new com.tencent.mm.c.c.c(b.this.mSampleRate, b.this.fzj);
            b.this.fzb.bz(b.this.fyZ);
          }
          f(paramAnonymousArrayOfByte, paramAnonymousInt);
          ??? = b.this.fzb;
          if (((com.tencent.mm.c.c.c)???).fBy == null)
          {
            i = -1;
            if (paramAnonymousArrayOfByte != null) {
              break label888;
            }
          }
          label888:
          for (int j = -1;; j = paramAnonymousArrayOfByte.length)
          {
            v.d("MicroMsg.SilkWriter", "pushBuf queueLen:%d bufLen:%d len:%d, lastFrame: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool1) });
            if (paramAnonymousInt <= 0) {
              break label950;
            }
            if (!((com.tencent.mm.c.c.c)???).fBz) {
              break label895;
            }
            v.e("MicroMsg.SilkWriter", "already stop");
            GMTrace.o(4478845583360L, 33370);
            return;
            i = ((com.tencent.mm.c.c.c)???).fBy.size();
            break;
          }
          label895:
          if (((com.tencent.mm.c.c.c)???).fBF == null)
          {
            ((com.tencent.mm.c.c.c)???).fBF = new com.tencent.mm.c.c.c.a((com.tencent.mm.c.c.c)???);
            com.tencent.mm.sdk.f.e.post(((com.tencent.mm.c.c.c)???).fBF, "SilkWriter_run");
          }
          ((com.tencent.mm.c.c.c)???).fBy.add(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt, bool1));
          label950:
          GMTrace.o(4478845583360L, 33370);
          return;
        }
        ??? = paramAnonymousArrayOfByte;
        int i = paramAnonymousInt;
        if (b.this.mSampleRate == 16000)
        {
          ??? = e(paramAnonymousArrayOfByte, paramAnonymousInt);
          i = ???.length;
        }
        f((byte[])???, i);
        GMTrace.o(4478845583360L, 33370);
      }
    };
    v.i("MicroMsg.MMAudioRecorder", "MMAudioRecorder recMode: " + parama);
    this.fzn = parama;
    if (!g.b.pk())
    {
      v.i("MicroMsg.MMAudioRecorder", "can't use silk encode, force to use amr mode now");
      this.fzn = com.tencent.mm.compatible.b.b.a.gMZ;
    }
    if (this.fzn == com.tencent.mm.compatible.b.b.a.gMZ)
    {
      this.fza = 7;
      this.fzl = new MediaRecorder();
    }
    for (;;)
    {
      this.fzp = false;
      GMTrace.o(4469987213312L, 33304);
      return;
      pc();
      this.fza = 1;
    }
  }
  
  public final void a(a parama)
  {
    GMTrace.i(4470121431040L, 33305);
    if (this.fzn == com.tencent.mm.compatible.b.b.a.gMZ)
    {
      if (this.fzl == null)
      {
        GMTrace.o(4470121431040L, 33305);
        return;
      }
      this.fzc = parama;
      this.fzl.setOnErrorListener(new MediaRecorder.OnErrorListener()
      {
        public final void onError(MediaRecorder paramAnonymousMediaRecorder, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          GMTrace.i(4490119872512L, 33454);
          if (b.this.fzc != null) {
            b.this.fzc.onError();
          }
          try
          {
            b.this.fzl.release();
            b.this.fzo = b.b.fzx;
            GMTrace.o(4490119872512L, 33454);
            return;
          }
          catch (Exception paramAnonymousMediaRecorder)
          {
            for (;;)
            {
              v.e("MicroMsg.MMAudioRecorder", paramAnonymousMediaRecorder.getMessage());
            }
          }
        }
      });
      GMTrace.o(4470121431040L, 33305);
      return;
    }
    if (this.fzo == b.fzu)
    {
      this.fzc = parama;
      GMTrace.o(4470121431040L, 33305);
      return;
    }
    v.e("MicroMsg.MMAudioRecorder", "setOnErrorListener on wrong state");
    GMTrace.o(4470121431040L, 33305);
  }
  
  public final int getMaxAmplitude()
  {
    GMTrace.i(4470926737408L, 33311);
    int i;
    if (this.fzn == com.tencent.mm.compatible.b.b.a.gMZ)
    {
      if (this.fzl == null)
      {
        GMTrace.o(4470926737408L, 33311);
        return 0;
      }
      i = this.fzl.getMaxAmplitude();
      GMTrace.o(4470926737408L, 33311);
      return i;
    }
    if (this.fzo == b.fzw)
    {
      i = this.fyY;
      this.fyY = 0;
      GMTrace.o(4470926737408L, 33311);
      return i;
    }
    GMTrace.o(4470926737408L, 33311);
    return 0;
  }
  
  public final void oZ()
  {
    GMTrace.i(4470524084224L, 33308);
    if (this.fzn == com.tencent.mm.compatible.b.b.a.gMZ)
    {
      if (this.fzl != null) {
        this.fzl.setAudioEncoder(1);
      }
      GMTrace.o(4470524084224L, 33308);
      return;
    }
    GMTrace.o(4470524084224L, 33308);
  }
  
  public final void pa()
  {
    GMTrace.i(4470658301952L, 33309);
    if (this.fzn == com.tencent.mm.compatible.b.b.a.gMZ)
    {
      if (this.fzl == null)
      {
        GMTrace.o(4470658301952L, 33309);
        return;
      }
      this.fzl.setAudioSource(1);
      GMTrace.o(4470658301952L, 33309);
      return;
    }
    GMTrace.o(4470658301952L, 33309);
  }
  
  public final void pb()
  {
    GMTrace.i(4470792519680L, 33310);
    if (this.fzn == com.tencent.mm.compatible.b.b.a.gMZ)
    {
      if (this.fzl == null)
      {
        GMTrace.o(4470792519680L, 33310);
        return;
      }
      this.fzl.setOutputFormat(3);
      GMTrace.o(4470792519680L, 33310);
      return;
    }
    GMTrace.o(4470792519680L, 33310);
  }
  
  public final void pc()
  {
    GMTrace.i(4471060955136L, 33312);
    this.fze = d.a.JR();
    boolean bool;
    if (this.fze != null)
    {
      ??? = this.fze;
      if (1 != g.j("EnableSpeexVoiceUpload", 0)) {
        break label258;
      }
      bool = true;
    }
    for (;;)
    {
      this.fzk = bool;
      Object localObject2;
      if (this.fzn == com.tencent.mm.compatible.b.b.a.gNa)
      {
        ??? = ((a)h.h(a.class)).sV().getValue("VoiceSamplingRate");
        this.mSampleRate = bf.getInt((String)???, 16000);
        localObject2 = ((a)h.h(a.class)).sV().getValue("VoiceRate");
        this.fzj = bf.getInt((String)localObject2, 16000);
        v.i("MicroMsg.MMAudioRecorder", "initMediaRecorder dynamicSample: %s sampleRate: %d dynamicEncoding: %s audioEncoding: %d", new Object[] { ???, Integer.valueOf(this.mSampleRate), localObject2, Integer.valueOf(this.fzj) });
        label162:
        this.fyY = 0;
        this.fyZ = null;
        this.fzd = null;
        this.fzb = null;
        this.fzh = 0;
      }
      try
      {
        synchronized (fzi)
        {
          this.fzm = new c(this.mSampleRate, 0);
          this.fzm.as(true);
          this.fzm.cY(120);
          this.fzm.fzV = this.fzr;
          this.fzo = b.fzu;
          GMTrace.o(4471060955136L, 33312);
          return;
          label258:
          v.d("upload", "type " + d.chatType);
          int j = ((d.a)???).JQ();
          int i = ((d.a)???).JP();
          h.vJ();
          localObject2 = Integer.valueOf(bf.f((Integer)h.vI().vr().get(16646145, null)));
          v.d("upload", "daycount " + ((d.a)???).JQ() + "  count " + localObject2 + " rate " + i);
          if ((((Integer)localObject2).intValue() <= j) && (i != 0) && (al.isWifi(aa.getContext())))
          {
            h.vJ();
            j = bf.a((Integer)h.vI().vr().get(12290, null), 0);
            if (((d.a)???).gkh == 0) {
              bool = true;
            }
            for (;;)
            {
              v.d("upload", "fitSex " + ((d.a)???).gkh + " " + bool + " " + ((d.a)???).gkh);
              if ((!bool) || (!((d.a)???).JO())) {
                break label555;
              }
              j = ((d.a)???).hTJ.nextInt(i);
              v.d("upload", "luck " + j);
              if (j != i / 2) {
                break label555;
              }
              bool = true;
              break;
              if (((d.a)???).gkh == j) {
                bool = true;
              } else {
                bool = false;
              }
            }
          }
          label555:
          bool = false;
          continue;
          if (this.fzk)
          {
            this.mSampleRate = 16000;
            h.vJ();
            i = bf.a((Integer)h.vI().gXM.get(27), 0);
            v.i("MicroMsg.MMAudioRecorder", "sampleRate: " + this.mSampleRate + " notSupp16K: " + i);
            if (i != 1) {
              break label162;
            }
            this.mSampleRate = 8000;
            break label162;
          }
          this.mSampleRate = 8000;
        }
        v.e("MicroMsg.MMAudioRecorder", localException.getMessage());
      }
      catch (Exception localException)
      {
        if (localException.getMessage() == null) {}
      }
    }
    for (;;)
    {
      this.fzo = b.fzx;
      GMTrace.o(4471060955136L, 33312);
      return;
      v.e("MicroMsg.MMAudioRecorder", "Unknown error occured while initializing recording");
    }
  }
  
  public final boolean pd()
  {
    GMTrace.i(4471597826048L, 33316);
    if (this.fzn == com.tencent.mm.compatible.b.b.a.gMZ)
    {
      v.i("MicroMsg.MMAudioRecorder", "stop sysMediaRecorder: %s", new Object[] { this.fzl });
      if (this.fzl != null)
      {
        this.fzl.stop();
        this.fzl.release();
        this.fzl = null;
      }
      GMTrace.o(4471597826048L, 33316);
      return true;
    }
    com.tencent.mm.compatible.util.g.a locala = new com.tencent.mm.compatible.util.g.a();
    v.i("MicroMsg.MMAudioRecorder", "stop now state: " + this.fzo);
    if (this.fzo != b.fzw)
    {
      v.e("MicroMsg.MMAudioRecorder", "stop() called on illegal state");
      this.fzo = b.fzx;
      GMTrace.o(4471597826048L, 33316);
      return true;
    }
    for (;;)
    {
      long l1;
      long l2;
      int i;
      int j;
      synchronized (fzi)
      {
        if (this.fzm != null)
        {
          this.fzp = true;
          l1 = locala.se();
          this.fzo = b.fzy;
          l2 = locala.se();
          if (this.fzp)
          {
            v.i("MicroMsg.MMAudioRecorder", "start to wait pcmrecorder stop, markStop: %s", new Object[] { Boolean.valueOf(this.fzp) });
            i = 0;
            j = i;
            if (this.fzp) {
              j = i + 1;
            }
          }
        }
      }
      try
      {
        Thread.sleep(20L);
        i = j;
        if (j < 25) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        synchronized (fzi)
        {
          v.i("MicroMsg.MMAudioRecorder", "wait pcmrecorder stop, reach maximum count!, mPcmRecorder: %s", new Object[] { this.fzm });
          c localc = this.fzm;
          if (localc != null) {}
          try
          {
            this.fzm.oX();
            this.fzm.fzV = null;
            this.fzm = null;
            v.i("MicroMsg.MMAudioRecorder", "finish to wait pcmrecorder stop, markStop: %s, count: %s", new Object[] { Boolean.valueOf(this.fzp), Integer.valueOf(j) });
            if (this.fzb != null) {
              this.fzb.ps();
            }
            if (this.fzd != null)
            {
              ??? = this.fzd;
              v.i("MicroMsg.SpeexEncoderWorker", "stop ");
              new ad(Looper.getMainLooper()).post(new c.1((com.tencent.mm.au.c)???));
            }
            long l3 = bf.aA(this.fzg);
            v.i("MicroMsg.MMAudioRecorder", "toNow " + l3 + " startTickCnt: " + this.fzg + " pcmDataReadedCnt: " + this.fzh);
            if ((l3 > 2000L) && (this.fzh == 0))
            {
              h.vJ();
              h.vI().gXM.set(27, Integer.valueOf(1));
              v.i("MicroMsg.MMAudioRecorder", "16k not suppourt");
            }
            v.i("MicroMsg.MMAudioRecorder", "Wait Stop Time Media:" + l1 + " Read:" + l2 + " Thr:" + locala.se());
            GMTrace.o(4471597826048L, 33316);
            return false;
            this.fzp = false;
            continue;
            localObject1 = finally;
            throw ((Throwable)localObject1);
            localInterruptedException = localInterruptedException;
            v.printErrStackTrace("MicroMsg.MMAudioRecorder", localInterruptedException, "", new Object[0]);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              v.printErrStackTrace("MicroMsg.MMAudioRecorder", localException, "", new Object[0]);
            }
          }
        }
      }
    }
  }
  
  public final void prepare()
  {
    GMTrace.i(4471329390592L, 33314);
    if (this.fzn == com.tencent.mm.compatible.b.b.a.gMZ)
    {
      if (this.fzl != null) {
        this.fzl.prepare();
      }
      GMTrace.o(4471329390592L, 33314);
      return;
    }
    if ((this.fzo != b.fzu) || (this.fyZ == null))
    {
      this.fzo = b.fzx;
      release();
      GMTrace.o(4471329390592L, 33314);
      return;
    }
    this.fzo = b.fzv;
    GMTrace.o(4471329390592L, 33314);
  }
  
  public final void release()
  {
    GMTrace.i(4471463608320L, 33315);
    if (this.fzn == com.tencent.mm.compatible.b.b.a.gMZ)
    {
      if (this.fzl != null) {
        this.fzl.release();
      }
      GMTrace.o(4471463608320L, 33315);
      return;
    }
    if (this.fzo == b.fzw) {
      pd();
    }
    synchronized (fzi)
    {
      if (this.fzm != null)
      {
        this.fzm.oX();
        this.fzm.fzV = null;
        this.fzm = null;
      }
      GMTrace.o(4471463608320L, 33315);
      return;
      ??? = b.fzv;
    }
  }
  
  public final void setMaxDuration(int paramInt)
  {
    GMTrace.i(4470389866496L, 33307);
    if (this.fzn == com.tencent.mm.compatible.b.b.a.gMZ)
    {
      if (this.fzl != null) {
        this.fzl.setMaxDuration(paramInt);
      }
      GMTrace.o(4470389866496L, 33307);
      return;
    }
    this.fzf = paramInt;
    GMTrace.o(4470389866496L, 33307);
  }
  
  public final void setOutputFile(String paramString)
  {
    GMTrace.i(4470255648768L, 33306);
    if (this.fzn == com.tencent.mm.compatible.b.b.a.gMZ)
    {
      if (this.fzl == null)
      {
        GMTrace.o(4470255648768L, 33306);
        return;
      }
      this.fzl.setOutputFile(paramString);
      this.fyZ = paramString;
      GMTrace.o(4470255648768L, 33306);
      return;
    }
    if (this.fzo == b.fzu)
    {
      this.fyZ = paramString;
      GMTrace.o(4470255648768L, 33306);
      return;
    }
    v.e("MicroMsg.MMAudioRecorder", "set output path on wrong state");
    this.fzo = b.fzx;
    GMTrace.o(4470255648768L, 33306);
  }
  
  public final void start()
  {
    GMTrace.i(4471195172864L, 33313);
    if (this.fzn == com.tencent.mm.compatible.b.b.a.gMZ)
    {
      if (this.fzl != null) {
        this.fzl.start();
      }
      GMTrace.o(4471195172864L, 33313);
      return;
    }
    v.i("MicroMsg.MMAudioRecorder", "Start record now state: " + this.fzo + " recMode: " + this.fzn);
    if (this.fzo == b.fzv)
    {
      this.fzg = System.currentTimeMillis();
      this.fzh = 0;
    }
    for (this.fzo = b.fzw;; this.fzo = b.fzx)
    {
      synchronized (fzi)
      {
        this.fzm.pf();
        this.fzp = false;
        GMTrace.o(4471195172864L, 33313);
        return;
      }
      h.vJ();
      h.vI().gXM.set(27, Integer.valueOf(1));
      v.e("MicroMsg.MMAudioRecorder", "start() called on illegal state");
    }
  }
  
  public static abstract interface a
  {
    public abstract void onError();
  }
  
  public static enum b
  {
    static
    {
      GMTrace.i(4480858849280L, 33385);
      fzu = new b("INITIALIZING", 0);
      fzv = new b("READY", 1);
      fzw = new b("RECORDING", 2);
      fzx = new b("ERROR", 3);
      fzy = new b("STOPPED", 4);
      fzz = new b[] { fzu, fzv, fzw, fzx, fzy };
      GMTrace.o(4480858849280L, 33385);
    }
    
    private b()
    {
      GMTrace.i(4480724631552L, 33384);
      GMTrace.o(4480724631552L, 33384);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/c/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */