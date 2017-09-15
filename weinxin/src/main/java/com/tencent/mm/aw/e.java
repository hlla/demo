package com.tencent.mm.aw;

import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.c.b.g.a;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.io.File;

public final class e
  implements com.tencent.mm.y.e
{
  public static int fBt;
  private static final String icy;
  private static final String icz;
  public com.tencent.mm.c.b.c.a fzV;
  com.tencent.mm.c.b.c fzm;
  ad handler;
  public int icA;
  int icB;
  boolean icC;
  public int icD;
  public boolean icE;
  b icF;
  com.tencent.mm.c.c.a icG;
  com.tencent.qqpinyin.voicerecoapi.c icH;
  public a icI;
  public int ict;
  
  static
  {
    GMTrace.i(4388248616960L, 32695);
    icy = w.hgg + "tmp_voiceaddr.spx";
    icz = w.hgg + "tmp_voiceaddr.amr";
    fBt = 100;
    GMTrace.o(4388248616960L, 32695);
  }
  
  public e(b paramb, int paramInt)
  {
    GMTrace.i(4386235351040L, 32680);
    this.ict = 1;
    this.icA = 0;
    this.icB = 0;
    this.icC = false;
    this.icD = 500000;
    this.icE = false;
    this.icF = null;
    this.icH = null;
    this.icI = null;
    this.fzV = new com.tencent.mm.c.b.c.a()
    {
      public final void ax(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(4386101133312L, 32679);
        GMTrace.o(4386101133312L, 32679);
      }
      
      public final void d(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        GMTrace.i(4385966915584L, 32678);
        v.d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        com.tencent.qqpinyin.voicerecoapi.c.a locala = new com.tencent.qqpinyin.voicerecoapi.c.a();
        short[] arrayOfShort = new short[paramAnonymousInt / 2];
        int i = 0;
        while (i < paramAnonymousInt / 2)
        {
          arrayOfShort[i] = ((short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8));
          i += 1;
        }
        if (e.this.icH != null) {
          e.this.icH.a(arrayOfShort, paramAnonymousInt / 2, locala);
        }
        e locale = e.this;
        int j = paramAnonymousInt / 2;
        i = 0;
        while (i < j)
        {
          int k = arrayOfShort[i];
          if (k > locale.icA) {
            locale.icA = k;
          }
          i += 1;
        }
        if (e.this.icG != null) {}
        for (paramAnonymousInt = e.this.icG.a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt), 0);; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            e.this.finish();
            v.e("MicroMsg.SceneVoiceAddr", "write to file failed");
            GMTrace.o(4385966915584L, 32678);
            return;
          }
          paramAnonymousArrayOfByte = e.this;
          paramAnonymousArrayOfByte.icB = (paramAnonymousInt + paramAnonymousArrayOfByte.icB);
          if ((e.this.icB > 3300) && (!e.this.icC))
          {
            v.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
            e.this.handler.sendEmptyMessage(0);
            e.this.icC = true;
          }
          if ((locala.wNB == 2) || (locala.wNB == 3))
          {
            v.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + locala.wNB);
            e.this.finish();
          }
          GMTrace.o(4385966915584L, 32678);
          return;
        }
      }
    };
    this.handler = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(4388919705600L, 32700);
        if (paramAnonymousMessage.what == 2)
        {
          if (e.this.icF != null)
          {
            e.this.icF.LQ();
            GMTrace.o(4388919705600L, 32700);
          }
        }
        else
        {
          if (paramAnonymousMessage.what == 0)
          {
            if (e.this.ict == 0)
            {
              v.d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
              h.vd().a(349, e.this);
              if (e.this.ict != 0) {
                break label194;
              }
              if (e.this.icE) {
                break label169;
              }
              e.this.icI = new d(e.this.LO(), 0);
            }
            for (;;)
            {
              h.vd().a(e.this.icI, 0);
              GMTrace.o(4388919705600L, 32700);
              return;
              h.vd().a(206, e.this);
              break;
              label169:
              e.this.icI = new d(e.this.LO(), 1);
              continue;
              label194:
              e.this.icI = new c(e.this.LO(), e.this.ict);
            }
          }
          if ((paramAnonymousMessage.what == 3) && (e.this.icF != null)) {
            e.this.icF.a(new String[0], -1L);
          }
        }
        GMTrace.o(4388919705600L, 32700);
      }
    };
    this.icF = paramb;
    this.ict = paramInt;
    if (this.ict == 1) {}
    for (paramInt = i;; paramInt = 1500000)
    {
      this.icD = paramInt;
      GMTrace.o(4386235351040L, 32680);
      return;
    }
  }
  
  public final String LO()
  {
    GMTrace.i(16022912368640L, 119380);
    if (!this.icE)
    {
      str = icy;
      GMTrace.o(16022912368640L, 119380);
      return str;
    }
    String str = icz;
    GMTrace.o(16022912368640L, 119380);
    return str;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(4386369568768L, 32681);
    long l;
    if (this.ict == 0)
    {
      v.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
      h.vd().b(349, this);
      paramString = ((a)paramk).LI();
      l = ((a)paramk).LJ();
      if (paramString != null) {
        break label143;
      }
    }
    label143:
    for (int i = -1;; i = paramString.length)
    {
      v.i("MicroMsg.SceneVoiceAddr", "onSceneEnd errType:%d errCode:%d list:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if (this.icF == null) {
        break label162;
      }
      if ((paramInt2 == 0) && (paramInt1 == 0)) {
        break label150;
      }
      this.icF.LP();
      cancel();
      GMTrace.o(4386369568768L, 32681);
      return;
      h.vd().b(206, this);
      break;
    }
    label150:
    this.icF.a(paramString, l);
    label162:
    GMTrace.o(4386369568768L, 32681);
  }
  
  public final void cancel()
  {
    GMTrace.i(4386638004224L, 32683);
    this.icF = null;
    finish();
    GMTrace.o(4386638004224L, 32683);
  }
  
  public final void finish()
  {
    GMTrace.i(4386503786496L, 32682);
    v.i("MicroMsg.SceneVoiceAddr", "finish");
    v.j("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
    if (this.icI != null) {
      this.icI.LH();
    }
    this.handler.sendEmptyMessage(2);
    if (!this.icC) {
      this.handler.sendEmptyMessage(3);
    }
    reset();
    GMTrace.o(4386503786496L, 32682);
  }
  
  public final void reset()
  {
    GMTrace.i(4386772221952L, 32684);
    v.i("MicroMsg.SceneVoiceAddr", "reset");
    try
    {
      if (this.fzm != null)
      {
        this.fzm.oX();
        this.fzm = null;
      }
      if (this.icG != null)
      {
        this.icG.ps();
        this.icG = null;
      }
      if (this.icH != null) {
        this.icH.stop();
      }
      this.icH = null;
      if (this.icI != null)
      {
        this.icI.LH();
        this.icI = null;
      }
      this.icB = 0;
      this.icC = false;
      GMTrace.o(4386772221952L, 32684);
      return;
    }
    finally {}
  }
  
  public final class a
    implements Runnable
  {
    public a()
    {
      GMTrace.i(4392946237440L, 32730);
      GMTrace.o(4392946237440L, 32730);
    }
    
    public final void run()
    {
      GMTrace.i(4393080455168L, 32731);
      for (;;)
      {
        synchronized (e.this)
        {
          v.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
          try
          {
            new File(e.this.LO()).delete();
            if (e.this.icE)
            {
              i = 8000;
              e.this.fzm = new com.tencent.mm.c.b.c(i, 3);
              e.this.fzm.fzK = -19;
              e.this.fzm.as(false);
              if (!e.this.icE)
              {
                e.this.icG = new com.tencent.mm.c.c.d();
                if (!e.this.icG.bz(e.this.LO()))
                {
                  v.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                  e.this.icG.ps();
                  e.this.icG = null;
                }
              }
              if ((e.this.icE) || (p.gRb.gPO <= 0)) {
                break label341;
              }
              e.this.fzm.r(p.gRb.gPO, true);
              e.this.fzm.at(false);
              e.this.icH = new com.tencent.qqpinyin.voicerecoapi.c(e.this.icD);
              i = e.this.icH.start();
              if (i == 0) {
                break label356;
              }
              v.e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :" + i);
              e.this.reset();
              GMTrace.o(4393080455168L, 32731);
              return;
            }
          }
          catch (Exception localException)
          {
            v.e("MicroMsg.SceneVoiceAddr", "delete file failed, " + e.this.LO(), new Object[] { localException });
            continue;
          }
        }
        int i = 16000;
        continue;
        label341:
        e.this.fzm.r(5, false);
        continue;
        label356:
        e.this.fzm.fzV = e.this.fzV;
        if (!e.this.fzm.pf())
        {
          v.e("MicroMsg.SceneVoiceAddr", "start record failed");
          e.this.reset();
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void LP();
    
    public abstract void LQ();
    
    public abstract void a(String[] paramArrayOfString, long paramLong);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/aw/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */