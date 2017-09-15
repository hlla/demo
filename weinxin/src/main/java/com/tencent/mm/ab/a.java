package com.tencent.mm.ab;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.d;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ab;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends ab
{
  public a()
  {
    GMTrace.i(4497636065280L, 33510);
    GMTrace.o(4497636065280L, 33510);
  }
  
  public final boolean eX(int paramInt)
  {
    GMTrace.i(4497770283008L, 33511);
    if ((paramInt != 0) && (paramInt < 604372991))
    {
      GMTrace.o(4497770283008L, 33511);
      return true;
    }
    GMTrace.o(4497770283008L, 33511);
    return false;
  }
  
  public final String getTag()
  {
    GMTrace.i(4497904500736L, 33512);
    GMTrace.o(4497904500736L, 33512);
    return "MicroMsg.App.BizInfoDataTransfer";
  }
  
  public final void transfer(int paramInt)
  {
    GMTrace.i(4498038718464L, 33513);
    v.d("MicroMsg.App.BizInfoDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 0) && (paramInt < 604372991))
    {
      ap.yY();
      Object localObject2 = c.wO();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("select BizInfo.username").append(", BizInfo.extInfo");
      ((StringBuilder)localObject3).append(" from rcontact , BizInfo");
      ((StringBuilder)localObject3).append(" where rcontact.username").append(" = BizInfo.username");
      ((StringBuilder)localObject3).append(" and (rcontact.type").append(" & 1 ) != 0 ");
      ((StringBuilder)localObject3).append(" and ( rcontact.verifyFlag").append(" & 8 ) != 0 ");
      String str = ((StringBuilder)localObject3).toString();
      Object localObject1 = new ArrayList();
      v.d("MicroMsg.App.BizInfoDataTransfer", "sql %s", new Object[] { str });
      localObject2 = ((g)localObject2).a(((StringBuilder)localObject3).toString(), null, 2);
      if (localObject2 != null)
      {
        while (((Cursor)localObject2).moveToNext())
        {
          localObject3 = new BizInfo();
          ((BizInfo)localObject3).b((Cursor)localObject2);
          if (((BizInfo)localObject3).bd(false).De() == 1) {
            ((List)localObject1).add(((BizInfo)localObject3).field_username);
          }
        }
        ((Cursor)localObject2).close();
      }
      if (((List)localObject1).size() > 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Update BizInfo set type").append(" = 1 where 1 !=1 ");
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          ((StringBuilder)localObject2).append(" or username = '").append((String)localObject3).append("'");
        }
        localObject1 = ((StringBuilder)localObject2).toString();
        v.d("MicroMsg.App.BizInfoDataTransfer", "update sql %s", new Object[] { localObject1 });
        w.DH().eE("BizInfo", (String)localObject1);
      }
    }
    GMTrace.o(4498038718464L, 33513);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ab/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */