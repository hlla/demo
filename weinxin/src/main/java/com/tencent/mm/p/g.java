package com.tencent.mm.p;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yg;
import com.tencent.mm.protocal.c.yh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;

public final class g
  extends k
  implements j
{
  private b gUq;
  private yg gUr;
  yh gUs;
  public com.tencent.mm.y.e gUt;
  d gUu;
  private String gUv;
  private ad handler;
  private int retryCount;
  
  public g(d paramd)
  {
    GMTrace.i(4506762870784L, 33578);
    this.gUt = null;
    this.retryCount = 0;
    this.handler = new ad(Looper.getMainLooper());
    this.gUv = null;
    if (paramd == null)
    {
      GMTrace.o(4506762870784L, 33578);
      return;
    }
    this.gUu = paramd;
    v.d("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", new Object[] { paramd.field_cgi, Integer.valueOf(paramd.field_cmdid), paramd.field_functionmsgid });
    b.a locala = new b.a();
    locala.hrV = new yg();
    locala.hrW = new yh();
    locala.hrU = 825;
    locala.uri = paramd.field_cgi;
    locala.hrX = paramd.field_cmdid;
    locala.hrY = 0;
    this.gUq = locala.BE();
    this.gUr = ((yg)this.gUq.hrS.hsa);
    this.gUr.tDc = paramd.field_functionmsgid;
    if (paramd.field_custombuff != null) {
      this.gUr.tDd = paramd.field_custombuff;
    }
    GMTrace.o(4506762870784L, 33578);
  }
  
  private void uc()
  {
    GMTrace.i(4507568177152L, 33584);
    this.handler.postDelayed(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(4508105048064L, 33588);
        v.i("MicroMsg.NetSceneGetFuncMsg", "do retry");
        if (g.this.a(g.this.hsm, g.this.gUt) == -1) {
          g.this.gUt.a(3, -1, "doScene failed", g.this);
        }
        GMTrace.o(4508105048064L, 33588);
      }
    }, this.gUu.field_retryinterval * 1000);
    GMTrace.o(4507568177152L, 33584);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4507031306240L, 33580);
    if (this.gUu != null)
    {
      v.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", new Object[] { this.gUu.field_functionmsgid });
      this.gUu.field_status = 1;
    }
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(4507031306240L, 33580);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(4507299741696L, 33582);
    int i = k.b.hsC;
    GMTrace.o(4507299741696L, 33582);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4507433959424L, 33583);
    this.gUs = ((yh)((b)paramp).hrT.hsa);
    this.gUv = this.gUs.tDd;
    v.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.gUs.tay), Boolean.valueOf(bf.mA(this.gUv)), Long.valueOf(this.gUs.tDe) });
    if (!bf.mA(this.gUv))
    {
      this.gUr = ((yg)this.gUq.hrS.hsa);
      this.gUr.tDd = this.gUv;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        v.i("MicroMsg.NetSceneGetFuncMsg", "server error");
        if (this.gUs.tay != 1)
        {
          uc();
          GMTrace.o(4507433959424L, 33583);
          return;
        }
        v.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, stop retry, directly return");
        this.gUt.a(paramInt2, paramInt3, paramString, this);
        GMTrace.o(4507433959424L, 33583);
        return;
      }
      v.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
      com.tencent.mm.plugin.report.service.g.oSF.a(this.gUu.field_reportid, this.gUu.field_failkey, 1L, false);
      if (this.retryCount < 2)
      {
        v.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, retry, retryCount: %s", new Object[] { Integer.valueOf(this.retryCount) });
        this.retryCount += 1;
        uc();
        GMTrace.o(4507433959424L, 33583);
        return;
      }
      v.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, reach retry limit, directly return");
      com.tencent.mm.plugin.report.service.g.oSF.a(this.gUu.field_reportid, this.gUu.field_finalfailkey, 1L, false);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4507433959424L, 33583);
      return;
    }
    com.tencent.mm.plugin.report.service.g.oSF.a(this.gUu.field_reportid, this.gUu.field_successkey, 1L, false);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(4507433959424L, 33583);
  }
  
  public final int getType()
  {
    GMTrace.i(4506897088512L, 33579);
    GMTrace.o(4506897088512L, 33579);
    return 825;
  }
  
  protected final int ub()
  {
    GMTrace.i(4507165523968L, 33581);
    GMTrace.o(4507165523968L, 33581);
    return 6;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/p/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */