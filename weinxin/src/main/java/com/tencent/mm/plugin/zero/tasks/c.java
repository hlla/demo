package com.tencent.mm.plugin.zero.tasks;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.d.a;
import com.tencent.mm.kernel.b.e;

public final class c
  extends com.tencent.mm.kernel.a.c
{
  public c()
  {
    GMTrace.i(13627662794752L, 101534);
    GMTrace.o(13627662794752L, 101534);
  }
  
  public final void execute(e parame)
  {
    GMTrace.i(13627797012480L, 101535);
    a.b(parame.gZp, true);
    GMTrace.o(13627797012480L, 101535);
  }
  
  public final String name()
  {
    GMTrace.i(13627931230208L, 101536);
    GMTrace.o(13627931230208L, 101536);
    return "boot-multi-dex-install";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/zero/tasks/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */