package com.tencent.mm.plugin.zero;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bn.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class c
{
  public static volatile b<f> szy;
  private final f szz;
  
  public c()
  {
    GMTrace.i(13623636262912L, 101504);
    if (szy != null)
    {
      this.szz = ((f)szy.get());
      GMTrace.o(13623636262912L, 101504);
      return;
    }
    this.szz = null;
    GMTrace.o(13623636262912L, 101504);
  }
  
  public final boolean a(lt paramlt, boolean paramBoolean)
  {
    GMTrace.i(13623904698368L, 101506);
    if (!h.vG().uV())
    {
      v.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
      GMTrace.o(13623904698368L, 101506);
      return false;
    }
    long l = bf.NA();
    byte[] arrayOfByte = n.a(paramlt.tqt);
    v.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(paramlt.tqs), Integer.valueOf(bf.bn(arrayOfByte)), Long.valueOf(Thread.currentThread().getId()) });
    if (bf.bm(arrayOfByte))
    {
      v.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
      GMTrace.o(13623904698368L, 101506);
      return false;
    }
    try
    {
      if (this.szz != null) {
        this.szz.a(paramlt, arrayOfByte, paramBoolean);
      }
      v.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramlt.tqs), Long.valueOf(bf.aA(l)) });
      GMTrace.o(13623904698368L, 101506);
      return true;
    }
    catch (Exception paramlt)
    {
      v.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", paramlt, "", new Object[0]);
      GMTrace.o(13623904698368L, 101506);
    }
    return false;
  }
  
  public final void aX(Object paramObject)
  {
    GMTrace.i(13623770480640L, 101505);
    if (this.szz != null) {
      this.szz.aX(paramObject);
    }
    GMTrace.o(13623770480640L, 101505);
  }
  
  public final void aY(Object paramObject)
  {
    GMTrace.i(13624038916096L, 101507);
    if (this.szz != null) {
      this.szz.aY(paramObject);
    }
    GMTrace.o(13624038916096L, 101507);
  }
  
  public final void aZ(Object paramObject)
  {
    GMTrace.i(13624173133824L, 101508);
    if (this.szz != null) {
      this.szz.aZ(paramObject);
    }
    GMTrace.o(13624173133824L, 101508);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/zero/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */