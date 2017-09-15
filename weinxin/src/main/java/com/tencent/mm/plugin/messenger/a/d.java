package com.tencent.mm.plugin.messenger.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.sdk.platformtools.v;

public final class d
{
  public static c nwI;
  
  public static c aJP()
  {
    GMTrace.i(18652237660160L, 138970);
    if (nwI == null) {
      nwI = new b();
    }
    if ((nwI instanceof b)) {
      v.w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
    }
    c localc = nwI;
    GMTrace.o(18652237660160L, 138970);
    return localc;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/messenger/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */