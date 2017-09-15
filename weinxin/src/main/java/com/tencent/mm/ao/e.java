package com.tencent.mm.ao;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.nm;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.LinkedList;

@Deprecated
public final class e
  extends e.b
{
  private nm hNf;
  
  public e(String paramString, long paramLong)
  {
    super(9);
    GMTrace.i(301721452544L, 2248);
    this.hNf = new nm();
    this.hNf.trH = new avu().OU(bf.mz(paramString));
    this.hNf.trO.add(Integer.valueOf((int)paramLong));
    this.hNf.jLr = 1;
    this.nxx = this.hNf;
    GMTrace.o(301721452544L, 2248);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ao/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */