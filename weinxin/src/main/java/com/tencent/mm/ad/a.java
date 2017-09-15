package com.tencent.mm.ad;

import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;
import junit.framework.Assert;

public final class a
  extends k
  implements j
{
  private au fCQ;
  private com.tencent.mm.y.e gUt;
  private ad handler;
  
  public a(String paramString1, String paramString2)
  {
    GMTrace.i(1368886607872L, 10199);
    this.handler = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(1368752390144L, 10198);
        a.this.a(999, 0, 0, "", null, null);
        GMTrace.o(1368752390144L, 10198);
      }
    };
    this.fCQ = new au();
    this.fCQ.dv(1);
    this.fCQ.cH(paramString1);
    this.fCQ.z(ay.gk(paramString1));
    this.fCQ.dw(1);
    this.fCQ.setContent(paramString2);
    this.fCQ.setType(o.fG(paramString1));
    ap.yY();
    long l = com.tencent.mm.u.c.wT().L(this.fCQ);
    if (l != -1L) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      v.i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = " + l);
      GMTrace.o(1368886607872L, 10199);
      return;
      bool = false;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1369020825600L, 10200);
    this.gUt = parame1;
    v.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.fCQ.field_msgId);
    this.handler.sendEmptyMessageDelayed(0, 500L);
    GMTrace.o(1369020825600L, 10200);
    return 999;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(1369289261056L, 10202);
    int i = k.b.hsC;
    GMTrace.o(1369289261056L, 10202);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1369423478784L, 10203);
    v.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.fCQ.field_msgId);
    this.fCQ.dv(2);
    this.fCQ.z(ay.i(this.fCQ.field_talker, System.currentTimeMillis() / 1000L));
    ap.yY();
    com.tencent.mm.u.c.wT().a(this.fCQ.field_msgId, this.fCQ);
    this.gUt.a(0, 0, paramString, this);
    GMTrace.o(1369423478784L, 10203);
  }
  
  public final int getType()
  {
    GMTrace.i(1369155043328L, 10201);
    GMTrace.o(1369155043328L, 10201);
    return 522;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ad/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */