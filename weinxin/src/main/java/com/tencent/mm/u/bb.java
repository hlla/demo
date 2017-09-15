package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.k;

public final class bb
  extends k
  implements j
{
  private com.tencent.mm.y.e gUt;
  private final a hmZ;
  private final String hna;
  private long hnb;
  
  public bb(a parama)
  {
    this(parama, null);
    GMTrace.i(13475191455744L, 100398);
    GMTrace.o(13475191455744L, 100398);
  }
  
  public bb(a parama, String paramString)
  {
    GMTrace.i(13475325673472L, 100399);
    v.i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s [%s] ", new Object[] { paramString, bf.bJP() });
    this.hmZ = parama;
    this.hna = paramString;
    GMTrace.o(13475325673472L, 100399);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13475594108928L, 100401);
    c(parame);
    this.gUt = parame1;
    this.hnb = bf.NB();
    h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(13478412681216L, 100422);
        bb.this.a(0, 0, 0, null, null, null);
        GMTrace.o(13478412681216L, 100422);
      }
      
      public final String toString()
      {
        GMTrace.i(13478546898944L, 100423);
        String str = super.toString() + "|doScene";
        GMTrace.o(13478546898944L, 100423);
        return str;
      }
    });
    GMTrace.o(13475594108928L, 100401);
    return 0;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13475728326656L, 100402);
    if (this.hmZ != null)
    {
      v.d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", new Object[] { this.hna, Long.valueOf(bf.aB(this.hnb)) });
      this.hmZ.a(this.hsm);
    }
    this.gUt.a(0, 0, null, this);
    GMTrace.o(13475728326656L, 100402);
  }
  
  public final int getType()
  {
    GMTrace.i(13475459891200L, 100400);
    GMTrace.o(13475459891200L, 100400);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.network.e parame);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */