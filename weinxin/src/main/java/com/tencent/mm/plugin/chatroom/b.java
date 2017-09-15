package com.tencent.mm.plugin.chatroom;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.storage.r;
import com.tencent.mm.u.aa;
import java.util.HashMap;

public final class b
  implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.kernel.c.a, com.tencent.mm.plugin.chatroom.b.a
{
  private r kqD;
  
  public b()
  {
    GMTrace.i(14584098324480L, 108660);
    GMTrace.o(14584098324480L, 108660);
  }
  
  public final aa c(g paramg)
  {
    GMTrace.i(17857266057216L, 133047);
    paramg = new r(paramg);
    GMTrace.o(17857266057216L, 133047);
    return paramg;
  }
  
  public final HashMap<Integer, g.c> collectDatabaseFactory()
  {
    GMTrace.i(16419257319424L, 122333);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("CHATROOM_MEMBERS_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(16419123101696L, 122332);
        String[] arrayOfString = r.gUn;
        GMTrace.o(16419123101696L, 122332);
        return arrayOfString;
      }
    });
    GMTrace.o(16419257319424L, 122333);
    return localHashMap;
  }
  
  public final void onDataBaseClosed(g paramg1, g paramg2)
  {
    GMTrace.i(14584903630848L, 108666);
    GMTrace.o(14584903630848L, 108666);
  }
  
  public final void onDataBaseOpened(g paramg1, g paramg2)
  {
    GMTrace.i(14584500977664L, 108663);
    this.kqD = new r(paramg1);
    GMTrace.o(14584500977664L, 108663);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/chatroom/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */