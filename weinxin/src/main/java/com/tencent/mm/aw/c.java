package com.tencent.mm.aw;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bji;
import com.tencent.mm.protocal.c.bjj;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.a;
import com.tencent.mm.y.k.b;
import java.util.LinkedList;
import java.util.Set;

public final class c
  extends a
  implements j
{
  public int fEO;
  public String filename;
  private com.tencent.mm.y.b gUq;
  public com.tencent.mm.y.e gUt;
  public int hTs;
  ai hqz;
  public boolean iaN;
  private long icr;
  private boolean ics;
  private int ict;
  private String[] icu;
  
  public c(String paramString, int paramInt)
  {
    GMTrace.i(4392006713344L, 32723);
    this.fEO = 0;
    this.hTs = 0;
    this.filename = null;
    this.icr = -1L;
    this.ics = false;
    this.iaN = false;
    this.icu = new String[0];
    this.hqz = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(4389188141056L, 32702);
        long l = com.tencent.mm.a.e.aN(c.this.filename);
        v.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.sd() + " onTimerExpired: file:" + c.this.filename + " nowlen:" + l + " oldoff:" + c.this.hTs + " isFin:" + c.this.iaN);
        if ((l - c.this.hTs < 3300L) && (!c.this.iaN))
        {
          GMTrace.o(4389188141056L, 32702);
          return true;
        }
        if (c.this.a(c.this.hsm, c.this.gUt) == -1)
        {
          c.this.fEO = (com.tencent.mm.compatible.util.g.sb() + 40000);
          c.this.gUt.a(3, -1, "doScene failed", c.this);
        }
        GMTrace.o(4389188141056L, 32702);
        return false;
      }
    }, true);
    this.icr = bf.NA();
    this.filename = paramString;
    this.ict = paramInt;
    GMTrace.o(4392006713344L, 32723);
  }
  
  public final void LH()
  {
    GMTrace.i(4391469842432L, 32719);
    this.iaN = true;
    GMTrace.o(4391469842432L, 32719);
  }
  
  public final String[] LI()
  {
    GMTrace.i(4391604060160L, 32720);
    String[] arrayOfString = this.icu;
    GMTrace.o(4391604060160L, 32720);
    return arrayOfString;
  }
  
  public final long LJ()
  {
    GMTrace.i(4391738277888L, 32721);
    long l = this.icr;
    GMTrace.o(4391738277888L, 32721);
    return l;
  }
  
  public final Set<String> LK()
  {
    GMTrace.i(4391872495616L, 32722);
    GMTrace.o(4391872495616L, 32722);
    return null;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4392140931072L, 32724);
    this.gUt = parame1;
    int k = com.tencent.mm.a.e.aN(this.filename);
    v.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.sd() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.hTs + " isFin:" + this.iaN);
    if (k <= 0)
    {
      v.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
      this.fEO = (com.tencent.mm.compatible.util.g.sb() + 40000);
      GMTrace.o(4392140931072L, 32724);
      return -1;
    }
    int j = k - this.hTs;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      v.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.sd() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.hTs + " isFin:" + this.iaN + " endFlag:" + this.ics);
      parame1 = com.tencent.mm.a.e.c(this.filename, this.hTs, i);
      if (parame1 != null) {
        break;
      }
      v.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.sd() + " read failed :" + this.filename + " read:" + i);
      this.fEO = (com.tencent.mm.compatible.util.g.sb() + 40000);
      GMTrace.o(4392140931072L, 32724);
      return -1;
      if ((j < 3300) && (!this.iaN))
      {
        v.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.sd() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.iaN);
        this.fEO = (com.tencent.mm.compatible.util.g.sb() + 40000);
        GMTrace.o(4392140931072L, 32724);
        return -1;
      }
      i = j;
      if (this.iaN)
      {
        this.ics = true;
        i = j;
      }
    }
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new bji();
    ((b.a)localObject).hrW = new bjj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voiceaddr";
    ((b.a)localObject).hrU = 206;
    ((b.a)localObject).hrX = 94;
    ((b.a)localObject).hrY = 1000000094;
    this.gUq = ((b.a)localObject).BE();
    localObject = (bji)this.gUq.hrS.hsa;
    ((bji)localObject).tqC = new avt().bb(parame1);
    v.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.sd() + " read file:" + this.filename + " readlen:" + parame1.length + " datalen:" + ((bji)localObject).tqC.tXD.toByteArray().length + " dataiLen:" + ((bji)localObject).tqC.tXB + " md5:" + com.tencent.mm.a.g.n(parame1) + " datamd5:" + com.tencent.mm.a.g.n(((bji)localObject).tqC.tXD.toByteArray()));
    ((bji)localObject).jLx = ((String)h.vI().vr().get(2, ""));
    ((bji)localObject).tjF = this.hTs;
    ((bji)localObject).ufm = this.icr;
    if (this.ics) {}
    for (int i = 1;; i = 0)
    {
      ((bji)localObject).the = i;
      ((bji)localObject).ufn = 0;
      ((bji)localObject).tfj = 0;
      ((bji)localObject).ufo = 0;
      ((bji)localObject).tfg = 0;
      ((bji)localObject).uhi = this.ict;
      v.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.icr);
      i = a(parame, this.gUq, this);
      GMTrace.o(4392140931072L, 32724);
      return i;
    }
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(4392275148800L, 32725);
    int i = k.b.hsC;
    GMTrace.o(4392275148800L, 32725);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4392677801984L, 32728);
    v.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.sd() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bji)((com.tencent.mm.y.b)paramp).hrS.hsa;
    paramp = (bjj)((com.tencent.mm.y.b)paramp).hrT.hsa;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.sd() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4392677801984L, 32728);
      return;
    }
    v.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.g.sd() + " onGYNetEnd  file:" + this.filename + " endflag:" + paramp.the + " lst:" + paramp.thh);
    if (paramArrayOfByte.the == 1)
    {
      this.icu = new String[paramp.thh.size()];
      paramInt1 = 0;
      while (paramInt1 < paramp.thh.size())
      {
        this.icu[paramInt1] = ((avu)paramp.thh.get(paramInt1)).tXF;
        paramInt1 += 1;
      }
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4392677801984L, 32728);
      return;
    }
    paramInt1 = paramArrayOfByte.tjF;
    this.hTs = (paramArrayOfByte.tqC.tXB + paramInt1);
    if (this.iaN) {}
    for (long l = 0L;; l = 500L)
    {
      v.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.hqz.v(l, l);
      GMTrace.o(4392677801984L, 32728);
      return;
    }
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(4392543584256L, 32727);
    this.gUt.a(3, com.tencent.mm.compatible.util.g.sb() + 40000, "ecurityCheckError", this);
    GMTrace.o(4392543584256L, 32727);
  }
  
  public final int getType()
  {
    GMTrace.i(4392812019712L, 32729);
    GMTrace.o(4392812019712L, 32729);
    return 206;
  }
  
  protected final int ub()
  {
    GMTrace.i(4392409366528L, 32726);
    GMTrace.o(4392409366528L, 32726);
    return 20;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/aw/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */