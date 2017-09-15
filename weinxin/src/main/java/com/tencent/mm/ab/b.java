package com.tencent.mm.ab;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ab;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class b
  extends ab
{
  public b()
  {
    GMTrace.i(4499246678016L, 33522);
    GMTrace.o(4499246678016L, 33522);
  }
  
  public final boolean eX(int paramInt)
  {
    GMTrace.i(4499380895744L, 33523);
    if ((paramInt != 0) && (paramInt < 637735215))
    {
      GMTrace.o(4499380895744L, 33523);
      return true;
    }
    GMTrace.o(4499380895744L, 33523);
    return false;
  }
  
  public final String getTag()
  {
    GMTrace.i(4499515113472L, 33524);
    GMTrace.o(4499515113472L, 33524);
    return "MicroMsg.App.BizPlaceTopDataTransfer";
  }
  
  public final void transfer(int paramInt)
  {
    GMTrace.i(4499649331200L, 33525);
    v.d("MicroMsg.App.BizPlaceTopDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    long l1;
    long l2;
    if (eX(paramInt))
    {
      v.i("MicroMsg.App.BizPlaceTopDataTransfer", "begin biz place to top data transfer.");
      l1 = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.g.oSF.a(336L, 0L, 1L, true);
      ap.yY();
      com.tencent.mm.bj.g localg = c.wO();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("select conv.username");
      ((StringBuilder)localObject).append(" from ");
      ((StringBuilder)localObject).append("rconversation");
      ((StringBuilder)localObject).append(" as conv, ");
      ((StringBuilder)localObject).append("rcontact");
      ((StringBuilder)localObject).append(" as ct ");
      ((StringBuilder)localObject).append(" where conv.");
      ((StringBuilder)localObject).append("parentRef");
      ((StringBuilder)localObject).append("='");
      ((StringBuilder)localObject).append("officialaccounts");
      ((StringBuilder)localObject).append("' and conv.");
      ((StringBuilder)localObject).append("username");
      ((StringBuilder)localObject).append(" = ct.");
      ((StringBuilder)localObject).append("username");
      ((StringBuilder)localObject).append(" and ct.");
      ((StringBuilder)localObject).append("verifyFlag");
      ((StringBuilder)localObject).append(" & ");
      ((StringBuilder)localObject).append(8);
      ((StringBuilder)localObject).append(" = 0");
      localObject = ((StringBuilder)localObject).toString();
      v.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer query sql(%s)", new Object[] { localObject });
      localObject = localg.a((String)localObject, null, 2);
      if (localObject == null)
      {
        v.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor is null.");
        GMTrace.o(4499649331200L, 33525);
        return;
      }
      l2 = System.currentTimeMillis();
      v.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, query cost : %s msec.", new Object[] { Long.valueOf(l2 - l1) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update ");
      localStringBuilder.append("rconversation");
      localStringBuilder.append(" set ");
      localStringBuilder.append("parentRef");
      localStringBuilder.append("='' where ");
      localStringBuilder.append("username");
      localStringBuilder.append(" in (");
      if (((Cursor)localObject).moveToFirst())
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(336L, 1L, 1L, true);
        localStringBuilder.append("'");
        localStringBuilder.append(((Cursor)localObject).getString(0));
        localStringBuilder.append("'");
        paramInt = 1;
        while (((Cursor)localObject).moveToNext())
        {
          localStringBuilder.append(",");
          localStringBuilder.append("'");
          localStringBuilder.append(((Cursor)localObject).getString(0));
          localStringBuilder.append("'");
          paramInt += 1;
        }
      }
      ((Cursor)localObject).close();
      v.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor count is 0.");
      GMTrace.o(4499649331200L, 33525);
      return;
      localStringBuilder.append(")");
      String str = localStringBuilder.toString();
      v.i("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update count(%d)", new Object[] { Integer.valueOf(paramInt) });
      v.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update sql(%s)", new Object[] { str });
      ((Cursor)localObject).close();
      if (!localg.eE("rconversation", localStringBuilder.toString())) {
        break label636;
      }
      com.tencent.mm.plugin.report.service.g.oSF.a(336L, 2L, 1L, true);
    }
    for (;;)
    {
      long l3 = System.currentTimeMillis();
      v.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, update cost : %s msec,  total cost : %s msec.", new Object[] { Long.valueOf(l3 - l2), Long.valueOf(l3 - l1) });
      GMTrace.o(4499649331200L, 33525);
      return;
      label636:
      com.tencent.mm.plugin.report.service.g.oSF.a(336L, 3L, 1L, true);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ab/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */