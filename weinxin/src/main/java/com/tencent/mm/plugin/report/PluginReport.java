package com.tencent.mm.plugin.report;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.l;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PluginReport
  extends d
  implements b, a
{
  private l oRy;
  
  public PluginReport()
  {
    GMTrace.i(13127164887040L, 97805);
    GMTrace.o(13127164887040L, 97805);
  }
  
  public List<String> collectStoragePaths()
  {
    GMTrace.i(13127835975680L, 97810);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "logcat/" });
    GMTrace.o(13127835975680L, 97810);
    return localLinkedList;
  }
  
  public void configure(e parame)
  {
    GMTrace.i(13127567540224L, 97808);
    this.oRy = new l(i.class);
    h.a(l.class, new com.tencent.mm.kernel.c.c(this.oRy));
    parame = c.oRz;
    g localg = g.oSF;
    v.i("MicroMsg.ReportService", "instance set %s", new Object[] { localg });
    parame.oRA = localg;
    GMTrace.o(13127567540224L, 97808);
  }
  
  public void dependency()
  {
    GMTrace.i(13127433322496L, 97807);
    dependsOn(n.class);
    GMTrace.o(13127433322496L, 97807);
  }
  
  public void execute(e parame)
  {
    GMTrace.i(13127701757952L, 97809);
    GMTrace.o(13127701757952L, 97809);
  }
  
  public void installed()
  {
    GMTrace.i(13127299104768L, 97806);
    alias(a.class);
    GMTrace.o(13127299104768L, 97806);
  }
  
  public String toString()
  {
    GMTrace.i(13127970193408L, 97811);
    GMTrace.o(13127970193408L, 97811);
    return "plugin-report";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/PluginReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */