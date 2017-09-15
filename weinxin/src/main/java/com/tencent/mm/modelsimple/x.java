package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.ne;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.network.j;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.t.g;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.c;

public final class x
  extends com.tencent.mm.y.k
  implements j
{
  private final long fGD;
  private com.tencent.mm.y.e gUt;
  private final com.tencent.mm.y.b hJX;
  private final String hSz;
  
  public x(au paramau, String paramString)
  {
    GMTrace.i(1352646262784L, 10078);
    ap.yY();
    Object localObject = com.tencent.mm.u.c.vr().get(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = bf.getInt(localObject.toString(), 0);; i = 0)
    {
      this.fGD = paramau.field_msgId;
      this.hSz = paramString;
      localObject = null;
      int k = 0;
      int m = (int)(paramau.field_createTime / 1000L);
      long l = paramau.field_msgSvrId;
      String str1 = com.tencent.mm.u.m.xL();
      String str2 = paramau.field_talker;
      int j = k;
      paramString = (String)localObject;
      if (paramau.gxz != 1) {}
      switch (paramau.field_type)
      {
      default: 
        paramString = (String)localObject;
        j = k;
      case 1: 
      case 42: 
      case 48: 
      case 34: 
      case 43: 
      case 62: 
      case 3: 
      case 47: 
        for (;;)
        {
          paramau = new b.a();
          paramau.hrV = new avq();
          paramau.hrW = new avr();
          paramau.uri = "/cgi-bin/micromsg-bin/revokemsg";
          paramau.hrU = 594;
          paramau.hrX = 0;
          paramau.hrY = 0;
          this.hJX = paramau.BE();
          paramau = (avq)this.hJX.hrS.hsa;
          paramau.teo = paramString;
          paramau.tXv = j;
          paramau.tXw = 0;
          paramau.tXy = l;
          paramau.ofk = m;
          paramau.muu = str1;
          paramau.mut = str2;
          paramau.tXx = i;
          v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { paramau.teo, Integer.valueOf(paramau.tXv), Integer.valueOf(paramau.tXw), Integer.valueOf(paramau.ofk), paramau.muu, paramau.mut, Integer.valueOf(paramau.tXx) });
          GMTrace.o(1352646262784L, 10078);
          return;
          j = com.tencent.mm.u.k.f(com.tencent.mm.u.m.xL(), paramau.field_createTime).hashCode();
          v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", new Object[] { Integer.valueOf(j) });
          paramString = (String)localObject;
          continue;
          paramau = com.tencent.mm.modelvoice.m.Lz().mh(paramau.field_imgPath);
          j = k;
          paramString = (String)localObject;
          if (paramau != null)
          {
            paramString = paramau.clientId;
            v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            paramString = paramau.field_imgPath;
            v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            localObject = n.GT().aj(paramau.field_msgId);
            paramString = paramau.gxC;
            v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", new Object[] { paramau.field_talker, Integer.valueOf(((d)localObject).hEQ), Long.valueOf(((d)localObject).hEG), paramString });
            j = k;
            continue;
            paramString = String.valueOf(aj.RC(paramau.field_content).time);
            v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", new Object[] { paramString });
            j = k;
          }
        }
      }
      paramString = an.abF().eb(paramau.field_msgId);
      if (paramString != null) {}
      for (paramau = paramString.field_clientAppDataId;; paramau = paramau.field_talker + paramau.field_msgId + "T" + paramau.field_createTime)
      {
        v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", new Object[] { paramau });
        j = k;
        paramString = paramau;
        break;
      }
    }
  }
  
  public final avr Jv()
  {
    GMTrace.i(1353183133696L, 10082);
    avr localavr = (avr)this.hJX.hrT.hsa;
    GMTrace.o(1353183133696L, 10082);
    return localavr;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1352914698240L, 10080);
    this.gUt = parame1;
    int i = a(parame, this.hJX, this);
    GMTrace.o(1352914698240L, 10080);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1353048915968L, 10081);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ap.yY();
      paramp = com.tencent.mm.u.c.wT().cA(this.fGD);
      if (paramp.field_msgId != this.fGD) {
        break label336;
      }
      paramArrayOfByte = Jv();
      v.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s", new Object[] { Long.valueOf(paramp.field_msgId), Long.valueOf(paramp.field_msgSvrId), paramArrayOfByte.tXA });
      paramp.setContent(this.hSz);
      int i = paramp.field_type;
      paramp.setType(10000);
      paramp.dw(0);
      paramp.dG(paramp.gxu | 0x4);
      paramArrayOfByte = new ne();
      paramArrayOfByte.fUg.fGD = this.fGD;
      a.uql.m(paramArrayOfByte);
      ap.yY();
      com.tencent.mm.u.c.wT().a(paramp.field_msgId, paramp);
      paramInt1 = 0;
      ap.yY();
      paramArrayOfByte = com.tencent.mm.u.c.vr().get(290818, Integer.valueOf(0));
      if (paramArrayOfByte != null) {
        paramInt1 = bf.getInt(paramArrayOfByte.toString(), 0);
      }
      ap.yY();
      com.tencent.mm.u.c.vr().set(290818, Integer.valueOf(paramInt1 + 1));
      paramp.setType(i);
      if (!paramp.axH()) {
        break label309;
      }
      paramArrayOfByte = com.tencent.mm.modelstat.b.hTV;
      paramInt1 = g.g(paramp);
      if (paramArrayOfByte.JU()) {
        paramArrayOfByte.a(paramp, com.tencent.mm.modelstat.b.b.hUk, paramInt1);
      }
    }
    for (;;)
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(1353048915968L, 10081);
      return;
      label309:
      paramArrayOfByte = com.tencent.mm.modelstat.b.hTV;
      if (paramArrayOfByte.JU())
      {
        paramArrayOfByte.a(paramp, com.tencent.mm.modelstat.b.b.hUk, 0);
        continue;
        label336:
        v.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", new Object[] { Long.valueOf(this.fGD) });
      }
    }
  }
  
  public final int getType()
  {
    GMTrace.i(1352780480512L, 10079);
    GMTrace.o(1352780480512L, 10079);
    return 594;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */