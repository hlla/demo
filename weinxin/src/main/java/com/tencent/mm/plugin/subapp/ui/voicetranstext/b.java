package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.acp;
import com.tencent.mm.protocal.c.acq;
import com.tencent.mm.protocal.c.ast;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import junit.framework.Assert;

public final class b
  extends k
  implements j
{
  private final String TAG;
  private com.tencent.mm.y.b hrN;
  private com.tencent.mm.y.e nVH;
  private String qUd;
  public bjp qUk;
  public int qUo;
  
  public b(String paramString)
  {
    GMTrace.i(5773107134464L, 43013);
    this.TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    this.qUo = -1;
    if (!bf.mA(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.qUd = paramString;
      paramString = new b.a();
      paramString.hrV = new acp();
      paramString.hrW = new acq();
      paramString.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
      paramString.hrU = 548;
      paramString.hrX = 0;
      paramString.hrY = 0;
      this.hrN = paramString.BE();
      GMTrace.o(5773107134464L, 43013);
      return;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(5773375569920L, 43015);
    this.nVH = parame1;
    ((acp)this.hrN.hrS.hsa).tpP = this.qUd;
    int i = a(parame, this.hrN, this);
    GMTrace.o(5773375569920L, 43015);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(5773509787648L, 43016);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramp = (acq)this.hrN.hrT.hsa;
      if (paramp.tpT != null) {
        this.qUo = paramp.tpT.tVz;
      }
      this.qUk = paramp.tpR;
    }
    for (;;)
    {
      this.nVH.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(5773509787648L, 43016);
      return;
      v.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
  }
  
  public final boolean bnb()
  {
    GMTrace.i(5773778223104L, 43018);
    if ((this.qUk != null) && (!bf.mA(this.qUk.uhu)))
    {
      GMTrace.o(5773778223104L, 43018);
      return true;
    }
    GMTrace.o(5773778223104L, 43018);
    return false;
  }
  
  public final int getType()
  {
    GMTrace.i(5773241352192L, 43014);
    GMTrace.o(5773241352192L, 43014);
    return 548;
  }
  
  public final boolean isComplete()
  {
    GMTrace.i(5773644005376L, 43017);
    if ((this.qUk != null) && (this.qUk.the == 1))
    {
      GMTrace.o(5773644005376L, 43017);
      return true;
    }
    GMTrace.o(5773644005376L, 43017);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/ui/voicetranstext/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */