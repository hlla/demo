package com.tencent.mm.modelvoice;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.c.b.a;
import com.tencent.mm.c.b.c;
import com.tencent.mm.c.b.c.a;
import com.tencent.mm.c.b.g.a;
import com.tencent.mm.c.c.d;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.h.a;

public final class k
  implements a
{
  private static int ibJ;
  int fyY;
  c.a fzV;
  public c fzm;
  public d ibK;
  private String mFileName;
  public int mStatus;
  
  static
  {
    GMTrace.i(550829555712L, 4104);
    ibJ = 100;
    GMTrace.o(550829555712L, 4104);
  }
  
  public k()
  {
    GMTrace.i(549487378432L, 4094);
    this.mFileName = null;
    this.fyY = 0;
    this.mStatus = 0;
    this.fzV = new c.a()
    {
      public final void ax(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(536468258816L, 3997);
        GMTrace.o(536468258816L, 3997);
      }
      
      public final void d(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int i = 0;
        GMTrace.i(536334041088L, 3996);
        if (k.this.ibK != null) {
          k.this.ibK.a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt), 0, false);
        }
        k localk = k.this;
        while (i < paramAnonymousInt / 2)
        {
          int j = (short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8);
          if (j > localk.fyY) {
            localk.fyY = j;
          }
          i += 1;
        }
        GMTrace.o(536334041088L, 3996);
      }
    };
    GMTrace.o(549487378432L, 4094);
  }
  
  private void clean()
  {
    GMTrace.i(550158467072L, 4099);
    if (this.fzm != null)
    {
      this.fzm.oX();
      this.fzm = null;
    }
    if (this.ibK != null)
    {
      this.ibK.ps();
      this.ibK = null;
    }
    GMTrace.o(550158467072L, 4099);
  }
  
  public final void a(h.a parama)
  {
    GMTrace.i(549755813888L, 4096);
    GMTrace.o(549755813888L, 4096);
  }
  
  public final boolean bw(String paramString)
  {
    GMTrace.i(549621596160L, 4095);
    if (!bf.mA(this.mFileName))
    {
      v.e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
      GMTrace.o(549621596160L, 4095);
      return false;
    }
    this.mStatus = 1;
    this.fyY = 0;
    this.fzm = new c(16000, 0);
    this.fzm.fzK = -19;
    if (p.gRb.gPO > 0) {
      this.fzm.r(p.gRb.gPO, true);
    }
    for (;;)
    {
      this.fzm.as(false);
      this.fzm.fzV = this.fzV;
      this.ibK = new d();
      if (this.ibK.bz(paramString)) {
        break;
      }
      v.e("MicroMsg.SpeexRecorder", "init speex writer failed");
      clean();
      this.mStatus = -1;
      GMTrace.o(549621596160L, 4095);
      return false;
      this.fzm.r(5, false);
    }
    if (!this.fzm.pf())
    {
      v.e("MicroMsg.SpeexRecorder", "start record failed");
      clean();
      this.mStatus = -1;
      GMTrace.o(549621596160L, 4095);
      return false;
    }
    this.mFileName = paramString;
    GMTrace.o(549621596160L, 4095);
    return true;
  }
  
  public final int getMaxAmplitude()
  {
    GMTrace.i(550292684800L, 4100);
    int i = this.fyY;
    this.fyY = 0;
    if (i > ibJ) {
      ibJ = i;
    }
    i = i * 100 / ibJ;
    GMTrace.o(550292684800L, 4100);
    return i;
  }
  
  public final int getStatus()
  {
    GMTrace.i(550024249344L, 4098);
    int i = this.mStatus;
    GMTrace.o(550024249344L, 4098);
    return i;
  }
  
  public final boolean oX()
  {
    GMTrace.i(549890031616L, 4097);
    this.mFileName = null;
    this.mStatus = 0;
    clean();
    GMTrace.o(549890031616L, 4097);
    return true;
  }
  
  public final int oY()
  {
    GMTrace.i(550426902528L, 4101);
    int i = this.fzm.fAa;
    GMTrace.o(550426902528L, 4101);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvoice/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */