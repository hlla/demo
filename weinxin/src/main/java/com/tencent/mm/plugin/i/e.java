package com.tencent.mm.plugin.i;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.sdk.platformtools.v;

public final class e
  extends c
{
  public e()
  {
    GMTrace.i(5214090297344L, 38848);
    GMTrace.o(5214090297344L, 38848);
  }
  
  public final void execute(com.tencent.mm.kernel.b.e parame)
  {
    GMTrace.i(5214224515072L, 38849);
    int i = l.rl();
    if ((i & 0x400) != 0)
    {
      v.i("MicroMsg.SightInitTask", "load wechatsight_v7a, core number[%d]", new Object[] { Integer.valueOf(i >> 12) });
      k.b("wechatsight_v7a", getClass().getClassLoader());
      if (i >> 12 >= 4)
      {
        com.tencent.mm.plugin.sight.base.b.prV = 3;
        com.tencent.mm.plugin.sight.base.b.prX = 3;
        com.tencent.mm.plugin.sight.base.b.prY = 544000;
        GMTrace.o(5214224515072L, 38849);
        return;
      }
      com.tencent.mm.plugin.sight.base.b.prV = 1;
      com.tencent.mm.plugin.sight.base.b.prX = 1;
      com.tencent.mm.plugin.sight.base.b.prY = 640000;
      GMTrace.o(5214224515072L, 38849);
      return;
    }
    v.i("MicroMsg.SightInitTask", "load wechatsight");
    k.b("wechatsight", getClass().getClassLoader());
    com.tencent.mm.plugin.sight.base.b.prV = 1;
    com.tencent.mm.plugin.sight.base.b.prX = 1;
    com.tencent.mm.plugin.sight.base.b.prY = 640000;
    GMTrace.o(5214224515072L, 38849);
  }
  
  public final String name()
  {
    GMTrace.i(5214358732800L, 38850);
    GMTrace.o(5214358732800L, 38850);
    return "boot-sight-init";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/i/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */