package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.da;
import com.tencent.mm.protocal.c.db;
import com.tencent.mm.protocal.c.dc;
import com.tencent.mm.protocal.c.dg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.k;

public final class a
  extends k
  implements j
{
  public String appId;
  public int fJr;
  com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  public int hrb;
  public int hrc;
  public int lpR;
  public com.tencent.mm.bd.b lpS;
  public String lpT;
  public dg lpU;
  public da lpV;
  int lpW;
  long lpX;
  public int vb;
  
  public a(int paramInt1, String paramString1, int paramInt2, String paramString2, dg paramdg)
  {
    GMTrace.i(5706132488192L, 42514);
    this.lpW = 5000;
    this.lpX = 0L;
    this.fJr = 1;
    this.appId = paramString1;
    this.lpR = paramInt1;
    this.vb = 1;
    this.hrb = paramInt2;
    this.lpU = paramdg;
    this.lpV = null;
    this.lpT = paramString2;
    if (paramdg != null) {}
    for (;;)
    {
      v.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(1), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(1), Boolean.valueOf(bool), Boolean.valueOf(false) });
      GMTrace.o(5706132488192L, 42514);
      return;
      bool = false;
    }
  }
  
  public a(int paramInt, String paramString, da paramda, long paramLong)
  {
    GMTrace.i(5706266705920L, 42515);
    this.lpW = 5000;
    this.lpX = 0L;
    this.fJr = 2;
    this.appId = paramString;
    this.lpR = paramInt;
    this.vb = 1;
    this.lpU = null;
    this.lpV = paramda;
    this.lpX = paramLong;
    v.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", new Object[] { Integer.valueOf(2), paramString, Integer.valueOf(paramInt), Integer.valueOf(1), Boolean.valueOf(false), Boolean.valueOf(true) });
    GMTrace.o(5706266705920L, 42515);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(5706669359104L, 42518);
    this.gUt = parame1;
    parame1 = new b.a();
    parame1.hrU = 985;
    parame1.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
    parame1.hrV = new db();
    parame1.hrW = new dc();
    parame1.hrX = 0;
    parame1.hrY = 0;
    this.gUq = parame1.BE();
    parame1 = (db)this.gUq.hrS.hsa;
    parame1.tay = this.fJr;
    parame1.mrA = this.appId;
    parame1.teP = this.lpR;
    parame1.teQ = this.vb;
    parame1.teR = this.lpU;
    parame1.teS = this.lpV;
    int i = a(parame, this.gUq, this);
    GMTrace.o(5706669359104L, 42518);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(5706400923648L, 42516);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramp != null)) {
      v.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
    while (this.gUt != null)
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(5706400923648L, 42516);
      return;
      v.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
    v.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
    GMTrace.o(5706400923648L, 42516);
  }
  
  public final int getType()
  {
    GMTrace.i(5706535141376L, 42517);
    GMTrace.o(5706535141376L, 42517);
    return 985;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ext/voicecontrol/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */