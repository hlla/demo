package com.tencent.mm.ab;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ab;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;

public final class h
  extends ab
{
  public h()
  {
    GMTrace.i(4498709807104L, 33518);
    GMTrace.o(4498709807104L, 33518);
  }
  
  public final boolean eX(int paramInt)
  {
    GMTrace.i(4498978242560L, 33520);
    if ((paramInt != 0) && (paramInt < 620758015))
    {
      GMTrace.o(4498978242560L, 33520);
      return true;
    }
    GMTrace.o(4498978242560L, 33520);
    return false;
  }
  
  public final String getTag()
  {
    GMTrace.i(4498844024832L, 33519);
    GMTrace.o(4498844024832L, 33519);
    return "MicroMsg.App.SyncTopConversation";
  }
  
  public final void transfer(int paramInt)
  {
    GMTrace.i(4499112460288L, 33521);
    v.d("MicroMsg.App.SyncTopConversation", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    ap.yY();
    Object localObject1 = c.wO();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select username from rconversation");
    ((StringBuilder)localObject2).append(" where flag & 4611686018427387904").append(" != 0");
    v.d("MicroMsg.App.SyncTopConversation", "sql:%s", new Object[] { localObject2 });
    localObject1 = ((g)localObject1).a(((StringBuilder)localObject2).toString(), null, 2);
    if (localObject1 != null)
    {
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = ((Cursor)localObject1).getString(0);
        v.v("MicroMsg.App.SyncTopConversation", "userName %s", new Object[] { localObject2 });
        o.l((String)localObject2, false);
      }
      ((Cursor)localObject1).close();
    }
    GMTrace.o(4499112460288L, 33521);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ab/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */