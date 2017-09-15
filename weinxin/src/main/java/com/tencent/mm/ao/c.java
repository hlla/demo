package com.tencent.mm.ao;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.nd;
import com.tencent.mm.sdk.platformtools.bf;

@Deprecated
public final class c
  extends e.b
{
  private nd hNd;
  
  public c(String paramString)
  {
    this(paramString, 0);
    GMTrace.i(300781928448L, 2241);
    GMTrace.o(300781928448L, 2241);
  }
  
  public c(String paramString, int paramInt)
  {
    super(4);
    GMTrace.i(300916146176L, 2242);
    this.hNd = new nd();
    this.hNd.trH = new avu().OU(bf.mz(paramString));
    this.hNd.trJ = paramInt;
    this.nxx = this.hNd;
    GMTrace.o(300916146176L, 2242);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ao/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */