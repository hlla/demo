package com.tencent.mm.plugin.i;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.e;

public final class c
  extends com.tencent.mm.kernel.a.c
{
  public c()
  {
    GMTrace.i(5214492950528L, 38851);
    GMTrace.o(5214492950528L, 38851);
  }
  
  public final void execute(e parame)
  {
    GMTrace.i(5214627168256L, 38852);
    k.b("wechatvoicereco", getClass().getClassLoader());
    GMTrace.o(5214627168256L, 38852);
  }
  
  public final String name()
  {
    GMTrace.i(5214761385984L, 38853);
    GMTrace.o(5214761385984L, 38853);
    return "boot-load-wechatvoicereco-library";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/i/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */