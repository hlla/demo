package com.tencent.mm.modelvoice;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.om;
import com.tencent.mm.protocal.c.on;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.a;
import com.tencent.mm.y.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class e
  extends k
  implements j
{
  private static com.tencent.mm.u.ai iaL;
  private static List<c> iaM;
  public int fEO;
  private String fRV;
  public String fyw;
  private com.tencent.mm.y.b gUq;
  public com.tencent.mm.y.e gUt;
  private com.tencent.mm.sdk.platformtools.ai hqz;
  private String iaK;
  private boolean iaN;
  private boolean iaO;
  
  static
  {
    GMTrace.i(564385546240L, 4205);
    iaL = null;
    iaM = new ArrayList();
    GMTrace.o(564385546240L, 4205);
  }
  
  public e(p paramp)
  {
    GMTrace.i(563043368960L, 4195);
    this.fEO = 0;
    this.iaN = false;
    this.iaO = false;
    this.hqz = new com.tencent.mm.sdk.platformtools.ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(551097991168L, 4106);
        if (e.this.a(e.a(e.this), e.this.gUt) == -1) {
          e.this.gUt.a(3, -1, "doScene failed", e.this);
        }
        GMTrace.o(551097991168L, 4106);
        return false;
      }
    }, false);
    if (paramp != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.fyw = paramp.fyw;
      if (this.fyw == null) {
        break label142;
      }
    }
    label142:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.iaK = paramp.iaK;
      this.fRV = paramp.fRV;
      v.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice:  file[%s] voiceFormat[%s] user[%s]", new Object[] { this.fyw, this.iaK, this.fRV });
      GMTrace.o(563043368960L, 4195);
      return;
      bool = false;
      break;
    }
  }
  
  public static void a(c paramc)
  {
    GMTrace.i(562640715776L, 4192);
    if (!iaM.contains(paramc)) {
      iaM.add(paramc);
    }
    GMTrace.o(562640715776L, 4192);
  }
  
  public static void a(com.tencent.mm.u.ai paramai)
  {
    GMTrace.i(562506498048L, 4191);
    if (iaL == null) {
      iaL = paramai;
    }
    GMTrace.o(562506498048L, 4191);
  }
  
  public static void b(c paramc)
  {
    GMTrace.i(562774933504L, 4193);
    iaM.remove(paramc);
    GMTrace.o(562774933504L, 4193);
  }
  
  private void doNotify()
  {
    GMTrace.i(562909151232L, 4194);
    final au localau = q.md(this.fyw);
    if (localau != null)
    {
      if (iaL != null) {
        iaL.a(localau);
      }
      Iterator localIterator = iaM.iterator();
      while (localIterator.hasNext()) {
        ae.v(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(542642274304L, 4043);
            this.iaP.A(localau);
            GMTrace.o(542642274304L, 4043);
          }
        });
      }
    }
    GMTrace.o(562909151232L, 4194);
  }
  
  public final boolean BJ()
  {
    GMTrace.i(563714457600L, 4200);
    boolean bool = super.BJ();
    if (bool) {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 232L, 1L, false);
    }
    GMTrace.o(563714457600L, 4200);
    return bool;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(563177586688L, 4196);
    this.gUt = parame1;
    if (this.fyw == null)
    {
      v.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
      this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
      GMTrace.o(563177586688L, 4196);
      return -1;
    }
    parame1 = q.me(this.fyw);
    if ((parame1 == null) || (!parame1.LC()))
    {
      v.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fyw);
      this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
      GMTrace.o(563177586688L, 4196);
      return -1;
    }
    v.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fyw + " netTimes:" + parame1.hZX);
    if (!q.lV(this.fyw))
    {
      v.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fyw);
      q.lB(this.fyw);
      this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
      GMTrace.o(563177586688L, 4196);
      return -1;
    }
    int i = parame1.hYB - parame1.hZP;
    if (i <= 0)
    {
      if (parame1.status == 5)
      {
        this.iaO = true;
        v.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fyw + " Net:" + parame1.hYB + " Local:" + parame1.hZP);
        this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
        GMTrace.o(563177586688L, 4196);
        return -1;
      }
      q.a(this.fyw, parame1.hZP, null);
      this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
      GMTrace.o(563177586688L, 4196);
      return -1;
    }
    if (parame1.hrb == parame1.hYB) {
      this.iaN = true;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new om();
    ((b.a)localObject).hrW = new on();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadvoice";
    ((b.a)localObject).hrU = 128;
    ((b.a)localObject).hrX = 20;
    ((b.a)localObject).hrY = 1000000020;
    this.gUq = ((b.a)localObject).BE();
    localObject = (om)this.gUq.hrS.hsa;
    ((om)localObject).teo = parame1.clientId;
    ((om)localObject).tdE = parame1.fTG;
    ((om)localObject).tsu = i;
    ((om)localObject).tjF = parame1.hZP;
    if (o.dH(this.fRV))
    {
      ((om)localObject).trI = this.fRV;
      ((om)localObject).tsv = parame1.ibT;
    }
    v.i("MicroMsg.NetSceneDownloadVoice", "doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", new Object[] { ((om)localObject).teo, Integer.valueOf(((om)localObject).tdw), Long.valueOf(((om)localObject).tdE), Integer.valueOf(((om)localObject).tsu), Integer.valueOf(((om)localObject).tjF), ((om)localObject).trI, Long.valueOf(((om)localObject).tsv) });
    i = a(parame, this.gUq, this);
    GMTrace.o(563177586688L, 4196);
    return i;
  }
  
  protected final int a(com.tencent.mm.network.p paramp)
  {
    GMTrace.i(563311804416L, 4197);
    paramp = (om)((com.tencent.mm.y.b)paramp).hrS.hsa;
    if ((paramp.tdE == 0L) || (paramp.teo == null) || (paramp.teo.length() == 0) || (paramp.tsu <= 0) || (paramp.tjF < 0))
    {
      q.lB(this.fyw);
      i = k.b.hsD;
      GMTrace.o(563311804416L, 4197);
      return i;
    }
    int i = k.b.hsC;
    GMTrace.o(563311804416L, 4197);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(563848675328L, 4201);
    v.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fyw + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (on)((com.tencent.mm.y.b)paramp).hrT.hsa;
    if (paramArrayOfByte.tsx == 1)
    {
      v.v("MicroMsg.NetSceneDownloadVoice", this.fyw + " cancelFlag = 1");
      q.ma(this.fyw);
      GMTrace.o(563848675328L, 4201);
      return;
    }
    if (paramInt3 == -22)
    {
      q.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(563848675328L, 4201);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 231L, 1L, false);
      q.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(563848675328L, 4201);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 230L, 1L, false);
      v.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " resp:" + paramp.zg().sXW);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(563848675328L, 4201);
      return;
    }
    v.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fyw + " Recv:" + paramArrayOfByte.tqC.tXB + " fileOff:" + paramArrayOfByte.tjF);
    if (paramArrayOfByte.tqC.tXD == null)
    {
      v.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
      q.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(563848675328L, 4201);
      return;
    }
    paramp = paramArrayOfByte.tqC.tXD.toByteArray();
    if (paramp.length == 0)
    {
      v.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
      q.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(563848675328L, 4201);
      return;
    }
    paramInt1 = q.an(this.iaK, this.fyw).write(paramp, paramp.length, paramArrayOfByte.tjF);
    if (paramInt1 < 0)
    {
      v.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fyw + " ret:" + paramInt1);
      q.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(563848675328L, 4201);
      return;
    }
    v.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fyw + " filesize:" + paramInt1 + " voiceFormat:" + this.iaK);
    paramInt1 = q.a(this.fyw, paramInt1, null);
    if (paramInt1 < 0)
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 229L, 1L, false);
      v.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fyw + "updateAfterRecv Ret:" + paramInt1);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(563848675328L, 4201);
      return;
    }
    if (paramInt1 == 1)
    {
      doNotify();
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(563848675328L, 4201);
      return;
    }
    long l = 1000L;
    if (this.iaN) {
      l = 0L;
    }
    this.hqz.v(l, l);
    GMTrace.o(563848675328L, 4201);
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(563580239872L, 4199);
    com.tencent.mm.plugin.report.service.g.oSF.a(111L, 233L, 1L, false);
    q.lB(this.fyw);
    GMTrace.o(563580239872L, 4199);
  }
  
  public final int getType()
  {
    GMTrace.i(563982893056L, 4202);
    GMTrace.o(563982893056L, 4202);
    return 128;
  }
  
  protected final int ub()
  {
    GMTrace.i(563446022144L, 4198);
    GMTrace.o(563446022144L, 4198);
    return 100;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvoice/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */