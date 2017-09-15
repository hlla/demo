package com.tencent.mm.modelvoice;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.h.a;
import com.tencent.mm.h.a.a;
import com.tencent.mm.network.j;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bie;
import com.tencent.mm.protocal.c.bif;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.a;
import com.tencent.mm.y.k.b;
import junit.framework.Assert;

public final class f
  extends k
  implements j
{
  private int endFlag;
  public int fEO;
  public String fyw;
  private com.tencent.mm.y.b gUq;
  public com.tencent.mm.y.e gUt;
  ai hqz;
  private boolean iaN;
  private int iaR;
  public long iaS;
  private int iav;
  
  public f(String paramString)
  {
    this(paramString, 0);
    GMTrace.i(551634862080L, 4110);
    GMTrace.o(551634862080L, 4110);
  }
  
  public f(String paramString, int paramInt)
  {
    GMTrace.i(551769079808L, 4111);
    this.fEO = 0;
    this.iav = 0;
    this.iaN = false;
    this.endFlag = 0;
    this.hqz = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(571767521280L, 4260);
        p localp = q.me(f.this.fyw);
        if ((localp == null) || (!localp.LD()))
        {
          v.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + f.this.fyw);
          f.this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
          f.this.gUt.a(3, -1, "doScene failed", f.this);
          GMTrace.o(571767521280L, 4260);
          return false;
        }
        if ((3 != localp.status) && (8 != localp.status))
        {
          long l = System.currentTimeMillis();
          if (l / 1000L - localp.hZT > 30L)
          {
            v.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + f.this.fyw);
            f.this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
            f.this.gUt.a(3, -1, "doScene failed", f.this);
            GMTrace.o(571767521280L, 4260);
            return false;
          }
          if (l - f.this.iaS < 2000L)
          {
            v.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + f.this.fyw + " but last send time:" + (l - f.this.iaS));
            GMTrace.o(571767521280L, 4260);
            return true;
          }
          g localg = q.lW(f.this.fyw).bd(localp.hYB, 6000);
          v.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + f.this.fyw + " readByte:" + localg.fAB + " stat:" + localp.status);
          if (localg.fAB < 2000)
          {
            GMTrace.o(571767521280L, 4260);
            return true;
          }
        }
        if (f.this.a(f.this.hsm, f.this.gUt) == -1)
        {
          f.this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
          f.this.gUt.a(3, -1, "doScene failed", f.this);
        }
        GMTrace.o(571767521280L, 4260);
        return false;
      }
    }, true);
    if (paramString != null) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      v.d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:" + paramString);
      this.fyw = paramString;
      this.iaR = paramInt;
      GMTrace.o(551769079808L, 4111);
      return;
      bool = false;
    }
  }
  
  public final boolean BJ()
  {
    GMTrace.i(552305950720L, 4115);
    boolean bool = super.BJ();
    if (bool) {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 239L, 1L, false);
    }
    GMTrace.o(552305950720L, 4115);
    return bool;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(551903297536L, 4112);
    this.gUt = parame1;
    this.iaN = false;
    if (this.fyw == null)
    {
      v.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
      this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
      GMTrace.o(551903297536L, 4112);
      return -1;
    }
    p localp = q.me(this.fyw);
    if ((localp == null) || (!localp.LD()))
    {
      v.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fyw);
      this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
      GMTrace.o(551903297536L, 4112);
      return -1;
    }
    v.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fyw + " netTimes:" + localp.hZX);
    if (!q.lV(this.fyw))
    {
      v.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fyw);
      q.lB(this.fyw);
      this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
      GMTrace.o(551903297536L, 4112);
      return -1;
    }
    parame1 = new g();
    int k;
    int j;
    int i;
    Object localObject;
    if (localp.status == 8)
    {
      v.v("MicroMsg.NetSceneUploadVoice", this.fyw + " cancelFlag = 1");
      this.endFlag = 0;
      q.mb(localp.fyw);
      k = 1;
      j = 0;
      int m = localp.ibS;
      v.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", new Object[] { Integer.valueOf(m) });
      i = m;
      if (m == 0)
      {
        m = q.mf(this.fyw);
        v.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", new Object[] { Integer.valueOf(m) });
        i = m;
        if (m < 0)
        {
          i = q.gO(this.iav);
          v.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      localObject = new b.a();
      ((b.a)localObject).hrV = new bie();
      ((b.a)localObject).hrW = new bif();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadvoice";
      ((b.a)localObject).hrU = 127;
      ((b.a)localObject).hrX = 19;
      ((b.a)localObject).hrY = 1000000019;
      this.gUq = ((b.a)localObject).BE();
      localObject = (bie)this.gUq.hrS.hsa;
      ((bie)localObject).muu = m.xL();
      ((bie)localObject).mut = localp.fRV;
      ((bie)localObject).tjF = localp.hYB;
      ((bie)localObject).teo = localp.clientId;
      ((bie)localObject).tsw = i;
      ((bie)localObject).the = this.endFlag;
      ((bie)localObject).tdE = localp.fTG;
      ((bie)localObject).tsx = k;
      ((bie)localObject).ugg = this.iaR;
      ((bie)localObject).tdC = ba.zA();
      ((bie)localObject).tdC = a.a.qB().p(localp.fRV, localp.hZW);
      ((bie)localObject).tNn = j;
      if (k == 1) {
        break label1698;
      }
      ((bie)localObject).tqC = new avt().z(parame1.buf, parame1.fAB);
    }
    for (((bie)localObject).tsu = parame1.fAB;; ((bie)localObject).tsu = 1)
    {
      v.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + k + " endFlag:" + this.endFlag + " svrId:" + localp.fTG);
      v.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + ((bie)localObject).tdE + " user:" + ((bie)localObject).mut + " offset:" + ((bie)localObject).tjF + " dataLen:" + ((bie)localObject).tqC.tXB + " endFlag:" + ((bie)localObject).the);
      v.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + localp.fTG + " voiceFormat:" + j + " file:" + this.fyw + " readBytes:" + parame1.fAB + " neTTTOff:" + localp.hYB + " neWWWOff:" + this.iav + " endFlag:" + this.endFlag + " cancelFlag:" + k + " status:" + localp.status + " voiceLen:" + i);
      this.iaS = System.currentTimeMillis();
      i = a(parame, this.gUq, this);
      GMTrace.o(551903297536L, 4112);
      return i;
      if (localp.status == 3) {
        this.iaN = true;
      }
      parame1 = q.lW(this.fyw);
      if (parame1 == null)
      {
        this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
        v.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", new Object[] { this.fyw });
        GMTrace.o(551903297536L, 4112);
        return -1;
      }
      j = parame1.getFormat();
      v.d("MicroMsg.NetSceneUploadVoice", "format " + j);
      parame1 = parame1.bd(localp.hYB, 6000);
      v.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fyw + "] read ret:" + parame1.ret + " readlen:" + parame1.fAB + " newOff:" + parame1.iav + " netOff:" + localp.hYB + " line:" + com.tencent.mm.compatible.util.g.sb());
      if (parame1.ret < 0)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(111L, 241L, 1L, false);
        v.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fyw + "] read ret:" + parame1.ret + " readlen:" + parame1.fAB + " newOff:" + parame1.iav + " netOff:" + localp.hYB);
        q.lB(this.fyw);
        this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
        GMTrace.o(551903297536L, 4112);
        return -1;
      }
      this.iav = parame1.iav;
      if ((this.iav < localp.hYB) || (this.iav >= 469000))
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(111L, 240L, 1L, false);
        v.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fyw + "] newOff:" + this.iav + " OldtOff:" + localp.hYB);
        q.lB(this.fyw);
        this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
        GMTrace.o(551903297536L, 4112);
        return -1;
      }
      this.endFlag = 0;
      if ((parame1.fAB == 0) && (!this.iaN))
      {
        v.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fyw + " No Data temperature , will be retry");
        this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
        GMTrace.o(551903297536L, 4112);
        return -1;
      }
      if (this.iaN)
      {
        if (localp.hrb <= 0)
        {
          v.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fyw + "] read totalLen:" + localp.hrb);
          q.lB(this.fyw);
          this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
          GMTrace.o(551903297536L, 4112);
          return -1;
        }
        if ((localp.hrb > this.iav) && (parame1.fAB < 6000))
        {
          v.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fyw + "] readlen:" + parame1.fAB + " newOff:" + parame1.iav + " netOff:" + localp.hYB + " totalLen:" + localp.hrb);
          q.lB(this.fyw);
          this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
          GMTrace.o(551903297536L, 4112);
          return -1;
        }
        if (localp.hrb <= this.iav) {
          this.endFlag = 1;
        }
      }
      k = 0;
      break;
      label1698:
      ((bie)localObject).tqC = new avt().b(com.tencent.mm.bd.b.aU(new byte[1]));
    }
  }
  
  protected final int a(com.tencent.mm.network.p paramp)
  {
    GMTrace.i(552037515264L, 4113);
    paramp = (bie)((com.tencent.mm.y.b)paramp).hrS.hsa;
    v.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + paramp.tdE + " offset:" + paramp.tjF + " dataLen:" + paramp.tqC.tXB + " endFlag:" + paramp.the);
    if (((paramp.tdE == 0L) && (paramp.tjF != 0)) || (((paramp.tqC == null) || (paramp.tqC.tXB == 0)) && (paramp.the != 1) && (paramp.tsx != 1)))
    {
      i = k.b.hsD;
      GMTrace.o(552037515264L, 4113);
      return i;
    }
    int i = k.b.hsC;
    GMTrace.o(552037515264L, 4113);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(552574386176L, 4117);
    v.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fyw + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bie)((com.tencent.mm.y.b)paramp).hrS.hsa;
    paramp = (bif)((com.tencent.mm.y.b)paramp).hrT.hsa;
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      q.lC(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(552574386176L, 4117);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      q.lB(this.fyw);
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 237L, 1L, false);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(552574386176L, 4117);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 236L, 1L, false);
      v.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fyw + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(552574386176L, 4117);
      return;
    }
    v.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + paramp.tdE + " toUser:" + paramArrayOfByte.mut);
    if ((paramp.tdE <= 0L) && (!x.eO(paramArrayOfByte.mut)))
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(111L, 235L, 1L, false);
      v.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fyw + " getMsgId:" + paramp.tdE + " netoff:" + paramp.tjF);
      q.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(552574386176L, 4117);
      return;
    }
    v.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramp.tdE), Integer.valueOf(r.iiD) });
    if ((10007 == r.iiC) && (r.iiD != 0))
    {
      paramp.tdE = r.iiD;
      r.iiD = 0;
    }
    paramInt1 = q.a(this.fyw, this.iav, paramp.tdE, paramp.teo, this.endFlag, this.iaR);
    v.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fyw + " MsgSvrId:" + paramp.tdE + " clientId:" + paramp.teo + " neWWOff:" + this.iav + " neTTTT:" + paramp.tsu + " forwardflag:" + this.iaR);
    if (paramInt1 < 0)
    {
      q.lB(this.fyw);
      v.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fyw + "UpdateAfterSend Ret:" + paramInt1);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(552574386176L, 4117);
      return;
    }
    if (paramInt1 == 1)
    {
      v.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fyw);
      paramp = q.me(this.fyw);
      paramp = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramp.hZW);
      com.tencent.mm.modelstat.b.hTV.f(paramp);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(552574386176L, 4117);
      return;
    }
    if (this.iaN) {}
    for (long l = 0L;; l = 500L)
    {
      v.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fyw + " delay:" + l);
      this.hqz.v(l, l);
      GMTrace.o(552574386176L, 4117);
      return;
    }
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(552440168448L, 4116);
    com.tencent.mm.plugin.report.service.g.oSF.a(111L, 238L, 1L, false);
    q.lB(this.fyw);
    GMTrace.o(552440168448L, 4116);
  }
  
  public final int getType()
  {
    GMTrace.i(552708603904L, 4118);
    GMTrace.o(552708603904L, 4118);
    return 127;
  }
  
  protected final int ub()
  {
    GMTrace.i(552171732992L, 4114);
    GMTrace.o(552171732992L, 4114);
    return 60;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvoice/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */