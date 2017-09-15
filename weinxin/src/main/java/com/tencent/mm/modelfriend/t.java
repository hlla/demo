package com.tencent.mm.modelfriend;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.rb;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.ge;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class t
  extends k
  implements j
{
  private String fMB;
  private String fMD;
  public final b gUq;
  private com.tencent.mm.y.e gUt;
  
  public t(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    GMTrace.i(4429319241728L, 33001);
    this.gUt = null;
    this.fMB = null;
    this.fMD = null;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new gd();
    ((b.a)localObject).hrW = new ge();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindopmobile";
    ((b.a)localObject).hrU = 132;
    ((b.a)localObject).hrX = 45;
    ((b.a)localObject).hrY = 1000000045;
    this.gUq = ((b.a)localObject).BE();
    localObject = (gd)this.gUq.hrS.hsa;
    ((gd)localObject).tgi = paramInt1;
    ((gd)localObject).thT = paramInt2;
    ((gd)localObject).thU = paramString3;
    if ((bf.mA(this.fMB)) && (bf.mA(this.fMD)))
    {
      if (f.uqJ)
      {
        paramString3 = aa.getContext().getString(R.l.eND);
        ((gd)localObject).thW = paramString3;
        ((gd)localObject).thX = d.sXf;
      }
    }
    else
    {
      if ((paramString1 == null) || (paramString1.length() <= 0) || ((paramInt1 != 1) && (paramInt1 != 4) && (paramInt1 != 18))) {
        break label308;
      }
      ap.yY();
      c.vr().set(4097, paramString1);
    }
    for (;;)
    {
      v.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
      ((gd)localObject).thR = paramString1;
      ((gd)localObject).thS = paramString2;
      ((gd)localObject).lda = u.bID();
      GMTrace.o(4429319241728L, 33001);
      return;
      paramString3 = aa.getContext().getString(R.l.eNC);
      break;
      label308:
      if ((paramInt1 == 2) || (paramInt1 == 19))
      {
        ap.yY();
        paramString1 = (String)c.vr().get(4097, null);
      }
      else if (paramInt1 == 3)
      {
        ap.yY();
        paramString1 = (String)c.vr().get(6, null);
      }
    }
  }
  
  public t(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramInt, paramString2, 0, paramString3);
    GMTrace.i(4429185024000L, 33000);
    this.fMB = paramString4;
    this.fMD = paramString5;
    paramString1 = (gd)this.gUq.hrS.hsa;
    paramString1.thW = paramString4;
    paramString1.thX = paramString5;
    GMTrace.o(4429185024000L, 33000);
  }
  
  public final int AJ()
  {
    GMTrace.i(4429453459456L, 33002);
    int i = ((gd)this.gUq.hrS.hsa).tgi;
    GMTrace.o(4429453459456L, 33002);
    return i;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4429587677184L, 33003);
    this.gUt = parame1;
    parame1 = (gd)this.gUq.hrS.hsa;
    if ((parame1.thR == null) || (parame1.thR.length() <= 0))
    {
      v.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + parame1.thR);
      GMTrace.o(4429587677184L, 33003);
      return -1;
    }
    if (((parame1.tgi == 2) || (parame1.tgi == 19)) && ((parame1.thS == null) || (parame1.thS.length() <= 0)))
    {
      v.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + parame1.thR);
      GMTrace.o(4429587677184L, 33003);
      return -1;
    }
    int i = a(parame, this.gUq, this);
    GMTrace.o(4429587677184L, 33003);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4429856112640L, 33005);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4429856112640L, 33005);
      return;
    }
    paramp = (gd)this.gUq.hrS.hsa;
    paramArrayOfByte = (ge)this.gUq.hrT.hsa;
    v.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " sms:" + paramArrayOfByte.tib + "safedevice status = " + paramArrayOfByte.tbY);
    if ((paramp.tgi == 2) || (paramp.tgi == 4) || (paramp.tgi == 11) || (paramp.tgi == 19))
    {
      ap.yY();
      c.vr().set(4097, "");
      ap.yY();
      c.vr().set(6, paramp.thR);
      if ((bf.mA(this.fMB)) || (bf.mA(this.fMD))) {
        m.Fj();
      }
      if ((!bf.mA(this.fMB)) && (!bf.mA(this.fMD)))
      {
        rb localrb = new rb();
        localrb.fXQ.fXR = paramArrayOfByte;
        a.uql.m(localrb);
        ap.yY();
        c.vr().set(64, Integer.valueOf(paramArrayOfByte.tbY));
        paramArrayOfByte = new rc();
        paramArrayOfByte.fXS.fXT = true;
        paramArrayOfByte.fXS.fXU = true;
        a.uql.m(paramArrayOfByte);
      }
      if (paramp.tgi == 19)
      {
        ap.yY();
        c.vr().set(12322, null);
      }
      v.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
    }
    for (;;)
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4429856112640L, 33005);
      return;
      if (paramp.tgi == 3)
      {
        ap.yY();
        c.vr().set(4097, "");
        ap.yY();
        c.vr().set(6, "");
        ap.yY();
        c.vr().set(12322, null);
        ap.yY();
        c.vr().set(64, Integer.valueOf(paramArrayOfByte.tbY));
        paramp = new rc();
        paramp.fXS.fXT = false;
        paramp.fXS.fXU = true;
        a.uql.m(paramp);
        m.Fq();
        m.Fr();
        v.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
      }
    }
  }
  
  public final int getType()
  {
    GMTrace.i(4429721894912L, 33004);
    GMTrace.o(4429721894912L, 33004);
    return 132;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */