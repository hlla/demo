package com.tencent.mm.aw;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bhl;
import com.tencent.mm.protocal.c.bhm;
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
import java.util.Set;

public final class d
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
  private String[] icu;
  private int icw;
  
  public d(String paramString, int paramInt)
  {
    GMTrace.i(4384893173760L, 32670);
    this.fEO = 0;
    this.iaN = false;
    this.hTs = 0;
    this.filename = null;
    this.icr = -1L;
    this.ics = false;
    this.icw = 0;
    this.icu = new String[0];
    this.hqz = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(4400596647936L, 32787);
        long l = com.tencent.mm.a.e.aN(d.this.filename);
        v.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.sd() + " onTimerExpired: file:" + d.this.filename + " nowlen:" + l + " oldoff:" + d.this.hTs + " isFin:" + d.this.iaN);
        if ((l - d.this.hTs < 3300L) && (!d.this.iaN))
        {
          GMTrace.o(4400596647936L, 32787);
          return true;
        }
        if (d.this.a(d.this.hsm, d.this.gUt) == -1)
        {
          d.this.fEO = (com.tencent.mm.compatible.util.g.sb() + 40000);
          d.this.gUt.a(3, -1, "doScene failed", d.this);
        }
        GMTrace.o(4400596647936L, 32787);
        return false;
      }
    }, true);
    this.icr = bf.NA().hashCode();
    this.filename = paramString;
    this.icw = paramInt;
    GMTrace.o(4384893173760L, 32670);
  }
  
  public final void LH()
  {
    GMTrace.i(4384356302848L, 32666);
    this.iaN = true;
    GMTrace.o(4384356302848L, 32666);
  }
  
  public final String[] LI()
  {
    GMTrace.i(4384490520576L, 32667);
    String[] arrayOfString = this.icu;
    GMTrace.o(4384490520576L, 32667);
    return arrayOfString;
  }
  
  public final long LJ()
  {
    GMTrace.i(4384624738304L, 32668);
    long l = this.icr;
    GMTrace.o(4384624738304L, 32668);
    return l;
  }
  
  public final Set<String> LK()
  {
    GMTrace.i(4384758956032L, 32669);
    GMTrace.o(4384758956032L, 32669);
    return null;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4385027391488L, 32671);
    this.gUt = parame1;
    int k = com.tencent.mm.a.e.aN(this.filename);
    v.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", new Object[] { this.filename, Integer.valueOf(k), Integer.valueOf(this.hTs), Boolean.valueOf(this.iaN) });
    if (k <= 0)
    {
      v.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
      this.fEO = (com.tencent.mm.compatible.util.g.sb() + 40000);
      GMTrace.o(4385027391488L, 32671);
      return -1;
    }
    int j = k - this.hTs;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      v.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", new Object[] { this.filename, Integer.valueOf(k), Boolean.valueOf(this.iaN), Boolean.valueOf(this.iaN), Boolean.valueOf(this.ics) });
      parame1 = com.tencent.mm.a.e.c(this.filename, this.hTs, i);
      if (parame1 != null) {
        break;
      }
      v.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.sd() + " read failed :" + this.filename + " read:" + i);
      this.fEO = (com.tencent.mm.compatible.util.g.sb() + 40000);
      GMTrace.o(4385027391488L, 32671);
      return -1;
      if ((j < 3300) && (!this.iaN))
      {
        v.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.sd() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.iaN);
        this.fEO = (com.tencent.mm.compatible.util.g.sb() + 40000);
        GMTrace.o(4385027391488L, 32671);
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
    ((b.a)localObject).hrV = new bhl();
    ((b.a)localObject).hrW = new bhm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((b.a)localObject).hrU = 349;
    ((b.a)localObject).hrX = 158;
    ((b.a)localObject).hrY = 1000000158;
    this.gUq = ((b.a)localObject).BE();
    localObject = (bhl)this.gUq.hrS.hsa;
    ((bhl)localObject).jLx = ((String)h.vI().vr().get(2, ""));
    ((bhl)localObject).tqC = new avt().bb(parame1);
    v.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.sd() + " read file:" + this.filename + " readlen:" + parame1.length + " datalen:" + ((bhl)localObject).tqC.tXD.toByteArray().length + " dataiLen:" + ((bhl)localObject).tqC.tXB + " md5:" + com.tencent.mm.a.g.n(parame1) + " datamd5:" + com.tencent.mm.a.g.n(((bhl)localObject).tqC.tXD.toByteArray()));
    ((bhl)localObject).tjF = this.hTs;
    ((bhl)localObject).ufm = this.icr;
    if (this.ics) {}
    for (int i = 1;; i = 0)
    {
      ((bhl)localObject).the = i;
      ((bhl)localObject).ufn = 0;
      ((bhl)localObject).tfj = 0;
      ((bhl)localObject).ufo = this.icw;
      ((bhl)localObject).tfg = 0;
      v.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.icr);
      i = a(parame, this.gUq, this);
      GMTrace.o(4385027391488L, 32671);
      return i;
    }
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(4385161609216L, 32672);
    int i = k.b.hsC;
    GMTrace.o(4385161609216L, 32672);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4385564262400L, 32675);
    v.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bhl)((com.tencent.mm.y.b)paramp).hrS.hsa;
    paramp = (bhm)((com.tencent.mm.y.b)paramp).hrT.hsa;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.sd() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4385564262400L, 32675);
      return;
    }
    v.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.g.sd() + " onGYNetEnd  file:" + this.filename + " endflag:" + paramp.the);
    if (paramArrayOfByte.the == 1)
    {
      if ((paramp.ufp != null) && (paramp.ufp.tXD != null)) {
        this.icu = new String[] { paramp.ufp.tXD.bGP() };
      }
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4385564262400L, 32675);
      return;
    }
    paramInt1 = paramArrayOfByte.tjF;
    this.hTs = (paramArrayOfByte.tqC.tXB + paramInt1);
    if (this.iaN) {}
    for (long l = 0L;; l = 500L)
    {
      v.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.hqz.v(l, l);
      GMTrace.o(4385564262400L, 32675);
      return;
    }
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(4385430044672L, 32674);
    this.gUt.a(3, com.tencent.mm.compatible.util.g.sb() + 40000, "ecurityCheckError", this);
    GMTrace.o(4385430044672L, 32674);
  }
  
  public final int getType()
  {
    GMTrace.i(4385698480128L, 32676);
    GMTrace.o(4385698480128L, 32676);
    return 349;
  }
  
  protected final int ub()
  {
    GMTrace.i(4385295826944L, 32673);
    GMTrace.o(4385295826944L, 32673);
    return 20;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/aw/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */