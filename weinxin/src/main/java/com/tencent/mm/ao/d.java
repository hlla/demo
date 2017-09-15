package com.tencent.mm.ao;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.ng;
import com.tencent.mm.sdk.platformtools.bf;

@Deprecated
public final class d
  extends e.b
{
  private ng hNe;
  
  public d(String paramString, long paramLong)
  {
    super(8);
    GMTrace.i(301184581632L, 2244);
    this.hNe = new ng();
    this.hNe.trH = new avu().OU(bf.mz(paramString));
    this.hNe.tdE = paramLong;
    this.nxx = this.hNe;
    GMTrace.o(301184581632L, 2244);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ao/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */