package com.tencent.mm.plugin.i;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.b.e;

public final class b
  extends c
{
  public b()
  {
    GMTrace.i(5214895603712L, 38854);
    GMTrace.o(5214895603712L, 38854);
  }
  
  public final void execute(e parame)
  {
    GMTrace.i(5215029821440L, 38855);
    k.b("tencentloc", getClass().getClassLoader());
    GMTrace.o(5215029821440L, 38855);
  }
  
  public final String name()
  {
    GMTrace.i(5215164039168L, 38856);
    GMTrace.o(5215164039168L, 38856);
    return "boot-load-tencentloc-library";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */