package com.tencent.mm.plugin.subapp.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bie;
import com.tencent.mm.protocal.c.bif;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.a;
import com.tencent.mm.y.k.b;
import junit.framework.Assert;

public final class b
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
  public long iaS;
  private int iav;
  
  public b(String paramString)
  {
    GMTrace.i(5836457902080L, 43485);
    this.fEO = 0;
    this.iav = 0;
    this.iaN = false;
    this.endFlag = 0;
    this.hqz = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(5844242530304L, 43543);
        g localg = h.Hj(b.this.fyw);
        if ((localg == null) || (!localg.LD()))
        {
          v.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + b.this.fyw);
          b.this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
          b.this.gUt.a(3, -1, "doScene failed", b.this);
          GMTrace.o(5844242530304L, 43543);
          return false;
        }
        if ((3 != localg.field_status) && (8 != localg.field_status))
        {
          long l = System.currentTimeMillis();
          if (l / 1000L - localg.field_lastmodifytime > 30L)
          {
            v.e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + b.this.fyw);
            b.this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
            b.this.gUt.a(3, -1, "doScene failed", b.this);
            GMTrace.o(5844242530304L, 43543);
            return false;
          }
          if (l - b.this.iaS < 2000L)
          {
            v.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + b.this.fyw + " but last send time:" + (l - b.this.iaS));
            GMTrace.o(5844242530304L, 43543);
            return true;
          }
          c.a locala = h.Hk(b.this.fyw).uq(localg.field_offset);
          v.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + b.this.fyw + " readByte:" + locala.fAB + " stat:" + localg.field_status);
          if (locala.fAB < 2000)
          {
            GMTrace.o(5844242530304L, 43543);
            return true;
          }
        }
        if (b.this.a(b.this.hsm, b.this.gUt) == -1)
        {
          b.this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
          b.this.gUt.a(3, -1, "doScene failed", b.this);
        }
        GMTrace.o(5844242530304L, 43543);
        return false;
      }
    }, true);
    if (paramString != null) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      v.d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:" + paramString);
      this.fyw = paramString;
      GMTrace.o(5836457902080L, 43485);
      return;
      bool = false;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(5836592119808L, 43486);
    this.gUt = parame1;
    this.iaN = false;
    if (this.fyw == null)
    {
      v.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
      this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
      GMTrace.o(5836592119808L, 43486);
      return -1;
    }
    g localg = h.Hj(this.fyw);
    if ((localg == null) || (!localg.LD()))
    {
      v.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fyw);
      this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
      GMTrace.o(5836592119808L, 43486);
      return -1;
    }
    v.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fyw + " netTimes:" + localg.field_nettimes);
    parame1 = this.fyw;
    boolean bool;
    if (parame1 == null) {
      bool = false;
    }
    while (!bool)
    {
      v.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fyw);
      h.lB(this.fyw);
      this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
      GMTrace.o(5836592119808L, 43486);
      return -1;
      parame1 = h.Hj(parame1);
      if (parame1 == null)
      {
        bool = false;
      }
      else if (parame1.field_nettimes >= 80)
      {
        bool = false;
      }
      else
      {
        parame1.field_nettimes += 1;
        parame1.fRM = 16384;
        bool = h.a(parame1);
      }
    }
    parame1 = new c.a();
    int i;
    int j;
    if (localg.field_status == 8)
    {
      v.v("MicroMsg.NetSceneUploadVoiceRemind", this.fyw + " cancelFlag = 1");
      this.endFlag = 1;
      h.mb(localg.field_filename);
      i = 1;
      j = localg.field_voicelenght;
      if (j != 0) {
        break label1634;
      }
      j = (this.iav - 6) / 32 * 20;
    }
    label1634:
    for (;;)
    {
      v.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + localg.field_msgid);
      Object localObject = new b.a();
      ((b.a)localObject).hrV = new bie();
      ((b.a)localObject).hrW = new bif();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
      ((b.a)localObject).hrU = 329;
      ((b.a)localObject).hrX = 157;
      ((b.a)localObject).hrY = 1000000157;
      this.gUq = ((b.a)localObject).BE();
      localObject = (bie)this.gUq.hrS.hsa;
      ((bie)localObject).muu = m.xL();
      ((bie)localObject).mut = localg.field_user;
      ((bie)localObject).tjF = localg.field_offset;
      ((bie)localObject).teo = localg.field_clientid;
      ((bie)localObject).tsw = j;
      ((bie)localObject).the = this.endFlag;
      ((bie)localObject).tdE = localg.field_msgid;
      ((bie)localObject).tsx = i;
      ((bie)localObject).ugf = ((int)(localg.field_createtime / 1000L));
      ((bie)localObject).tNn = 1;
      if (i != 1) {
        ((bie)localObject).tqC = new avt().z(parame1.buf, parame1.fAB);
      }
      for (((bie)localObject).tsu = parame1.fAB;; ((bie)localObject).tsu = 1)
      {
        v.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + localg.field_msgid);
        v.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + ((bie)localObject).tdE + " user:" + ((bie)localObject).mut + " offset:" + ((bie)localObject).tjF + " dataLen:" + ((bie)localObject).tqC.tXB + " endFlag:" + ((bie)localObject).the);
        v.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + localg.field_msgid + " file:" + this.fyw + " readBytes:" + parame1.fAB + " neTTTOff:" + localg.field_offset + " neWWWOff:" + this.iav + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + localg.field_status);
        v.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + localObject.toString());
        this.iaS = System.currentTimeMillis();
        i = a(parame, this.gUq, this);
        GMTrace.o(5836592119808L, 43486);
        return i;
        if (localg.field_status == 3) {
          this.iaN = true;
        }
        parame1 = h.Hk(this.fyw);
        if (parame1 == null)
        {
          this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
          GMTrace.o(5836592119808L, 43486);
          return -1;
        }
        parame1 = parame1.uq(localg.field_offset);
        v.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fyw + "] read ret:" + parame1.ret + " readlen:" + parame1.fAB + " newOff:" + parame1.iav + " netOff:" + localg.field_offset + " line:" + com.tencent.mm.compatible.util.g.sb());
        if (parame1.ret < 0)
        {
          v.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fyw + "] read ret:" + parame1.ret + " readlen:" + parame1.fAB + " newOff:" + parame1.iav + " netOff:" + localg.field_offset);
          h.lB(this.fyw);
          this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
          GMTrace.o(5836592119808L, 43486);
          return -1;
        }
        this.iav = parame1.iav;
        if ((this.iav < localg.field_offset) || (this.iav >= 469000))
        {
          v.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fyw + "] newOff:" + this.iav + " OldtOff:" + localg.field_offset);
          h.lB(this.fyw);
          this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
          GMTrace.o(5836592119808L, 43486);
          return -1;
        }
        this.endFlag = 0;
        if ((parame1.fAB == 0) && (!this.iaN))
        {
          v.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fyw + " No Data temperature , will be retry");
          h.lB(this.fyw);
          this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
          GMTrace.o(5836592119808L, 43486);
          return -1;
        }
        if (this.iaN)
        {
          if (localg.field_totallen <= 0)
          {
            v.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fyw + "] read totalLen:" + localg.field_totallen);
            h.lB(this.fyw);
            this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
            GMTrace.o(5836592119808L, 43486);
            return -1;
          }
          if ((localg.field_totallen > this.iav) && (parame1.fAB < 6000))
          {
            v.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fyw + "] readlen:" + parame1.fAB + " newOff:" + parame1.iav + " netOff:" + localg.field_offset + " totalLen:" + localg.field_totallen);
            h.lB(this.fyw);
            this.fEO = (com.tencent.mm.compatible.util.g.sb() + 10000);
            GMTrace.o(5836592119808L, 43486);
            return -1;
          }
          if (localg.field_totallen <= this.iav) {
            this.endFlag = 1;
          }
        }
        i = 0;
        break;
        ((bie)localObject).tqC = new avt().b(com.tencent.mm.bd.b.aU(new byte[1]));
      }
    }
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(5836726337536L, 43487);
    paramp = (bie)((com.tencent.mm.y.b)paramp).hrS.hsa;
    v.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + paramp.tjF + " dataLen:" + paramp.tqC.tXB + " endFlag:" + paramp.the);
    int i = k.b.hsC;
    GMTrace.o(5836726337536L, 43487);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(5837128990720L, 43490);
    v.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fyw + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bie)((com.tencent.mm.y.b)paramp).hrS.hsa;
    paramp = (bif)((com.tencent.mm.y.b)paramp).hrT.hsa;
    v.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + paramp.toString());
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      paramp = h.Hj(this.fyw);
      if (paramp != null)
      {
        if (paramp.field_status == 3)
        {
          ap.yY();
          paramArrayOfByte = com.tencent.mm.u.c.wT().cA(paramp.field_msglocalid);
          paramArrayOfByte.setContent(f.b(paramp.field_human, paramp.field_voicelenght, false));
          paramArrayOfByte.dv(2);
          ap.yY();
          com.tencent.mm.u.c.wT().a(paramp.field_msglocalid, paramArrayOfByte);
        }
        paramp.field_status = 97;
        paramp.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        paramp.fRM = 320;
        h.a(paramp);
      }
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(5837128990720L, 43490);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.lB(this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(5837128990720L, 43490);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fyw + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(5837128990720L, 43490);
      return;
    }
    v.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + paramp.tdE + " toUser:" + paramArrayOfByte.mut);
    paramArrayOfByte = this.fyw;
    int j = this.iav;
    long l = paramp.tdE;
    Object localObject = paramp.teo;
    int k = this.endFlag;
    if (paramArrayOfByte == null) {
      paramInt1 = -1;
    }
    for (;;)
    {
      v.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fyw + " MsgSvrId:" + paramp.tdE + " clientId:" + paramp.teo + " neWWOff:" + this.iav + " neTTTT:" + paramp.tsu);
      if (paramInt1 >= 0) {
        break;
      }
      h.lB(this.fyw);
      v.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fyw + "UpdateAfterSend Ret:" + paramInt1);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(5837128990720L, 43490);
      return;
      v.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + paramArrayOfByte + "] newOff:" + j + " SvrID:" + l + " clientID:" + (String)localObject + " hasSendEndFlag " + k);
      g localg = h.Hj(paramArrayOfByte);
      if (localg == null)
      {
        paramInt1 = -1;
      }
      else
      {
        localg.field_offset = j;
        localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        localg.fRM = 264;
        if ((bf.mA(localg.field_clientid)) && (localObject != null))
        {
          localg.field_clientid = ((String)localObject);
          localg.fRM |= 0x200;
        }
        if ((localg.field_msgid == 0L) && (l != 0L))
        {
          localg.field_msgid = l;
          localg.fRM |= 0x4;
        }
        int i = 0;
        v.d("MicroMsg.VoiceRemindLogic", "info.getTotalLen() " + localg.field_totallen + "  newOffset " + j + "  " + localg.field_status);
        paramInt1 = i;
        if (localg.field_totallen <= j)
        {
          paramInt1 = i;
          if (localg.field_status == 3)
          {
            paramInt1 = i;
            if (k == 1)
            {
              localg.field_status = 99;
              localg.fRM |= 0x40;
              ap.yY();
              localObject = com.tencent.mm.u.c.wT().cA(localg.field_msglocalid);
              ((au)localObject).cH(localg.field_user);
              ((au)localObject).y(localg.field_msgid);
              ((au)localObject).dv(2);
              ((au)localObject).setContent(f.b(localg.field_human, localg.field_voicelenght, false));
              ap.yY();
              com.tencent.mm.u.c.wT().a(localg.field_msglocalid, (au)localObject);
              v.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + paramArrayOfByte + " total:" + localg.field_totallen + " status:" + localg.field_status + " netTimes:" + localg.field_nettimes);
              paramInt1 = 1;
              h.lX(paramArrayOfByte);
            }
          }
        }
        if (!h.a(localg)) {
          paramInt1 = -4;
        }
      }
    }
    if (paramInt1 == 1)
    {
      v.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd finish file:" + this.fyw);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(5837128990720L, 43490);
      return;
    }
    if (this.iaN) {}
    for (l = 0L;; l = 500L)
    {
      v.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fyw + " delay:" + l);
      this.hqz.v(l, l);
      GMTrace.o(5837128990720L, 43490);
      return;
    }
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(5836994772992L, 43489);
    h.lB(this.fyw);
    GMTrace.o(5836994772992L, 43489);
  }
  
  public final int getType()
  {
    GMTrace.i(5837263208448L, 43491);
    GMTrace.o(5837263208448L, 43491);
    return 329;
  }
  
  protected final int ub()
  {
    GMTrace.i(5836860555264L, 43488);
    GMTrace.o(5836860555264L, 43488);
    return 240;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */