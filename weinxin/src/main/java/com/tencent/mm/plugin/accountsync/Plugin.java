package com.tencent.mm.plugin.accountsync;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.u.am;

public final class Plugin
  implements com.tencent.mm.pluginsdk.d.c
{
  public Plugin()
  {
    GMTrace.i(7849589604352L, 58484);
    GMTrace.o(7849589604352L, 58484);
  }
  
  public final k createApplication()
  {
    GMTrace.i(7849723822080L, 58485);
    a locala = new a();
    GMTrace.o(7849723822080L, 58485);
    return locala;
  }
  
  public final am createSubCore()
  {
    GMTrace.i(7849992257536L, 58487);
    com.tencent.mm.plugin.accountsync.a.c localc = new com.tencent.mm.plugin.accountsync.a.c();
    GMTrace.o(7849992257536L, 58487);
    return localc;
  }
  
  public final b getContactWidgetFactory()
  {
    GMTrace.i(7849858039808L, 58486);
    GMTrace.o(7849858039808L, 58486);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/accountsync/Plugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */