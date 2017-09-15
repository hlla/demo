package com.tencent.mm.ao;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;

public final class j
  extends com.tencent.mm.sdk.e.j
  implements e
{
  public static final String[] gUn;
  g hnp;
  
  static
  {
    GMTrace.i(13186354905088L, 98246);
    gUn = new String[] { "CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) " };
    GMTrace.o(13186354905088L, 98246);
  }
  
  public j(g paramg)
  {
    GMTrace.i(13186086469632L, 98244);
    this.hnp = paramg;
    GMTrace.o(13186086469632L, 98244);
  }
  
  public final boolean a(e.b paramb)
  {
    GMTrace.i(13186220687360L, 98245);
    if (paramb == null)
    {
      GMTrace.o(13186220687360L, 98245);
      return true;
    }
    if (this.hnp.delete("oplog2", "id= ? AND inserTime= ?", new String[] { paramb.id, paramb.hDk }) >= 0)
    {
      GMTrace.o(13186220687360L, 98245);
      return true;
    }
    GMTrace.o(13186220687360L, 98245);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ao/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */