package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.p;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class o
  extends i<p>
{
  public static final String[] gUn;
  public e gUp;
  
  static
  {
    GMTrace.i(802219360256L, 5977);
    gUn = new String[] { i.a(n.gTF, "AppSort") };
    GMTrace.o(802219360256L, 5977);
  }
  
  public o(e parame)
  {
    super(parame, n.gTF, "AppSort", null);
    GMTrace.i(801816707072L, 5974);
    this.gUp = parame;
    parame.eE("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( flag )");
    parame.eE("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( sortId )");
    GMTrace.o(801816707072L, 5974);
  }
  
  public final boolean a(n paramn)
  {
    GMTrace.i(802085142528L, 5976);
    boolean bool = super.b(paramn);
    GMTrace.o(802085142528L, 5976);
    return bool;
  }
  
  public final List<String> ef(long paramLong)
  {
    GMTrace.i(801950924800L, 5975);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder(256);
    ((StringBuilder)localObject).append("select * from AppSort");
    ((StringBuilder)localObject).append(" where ");
    ((StringBuilder)localObject).append("flag = ").append(paramLong);
    ((StringBuilder)localObject).append(" order by sortId desc ");
    localObject = rawQuery(((StringBuilder)localObject).toString(), new String[0]);
    if (localObject == null)
    {
      v.e("MicroMsg.AppSortStorage", "getAppListByFlag : cursor is null");
      GMTrace.o(801950924800L, 5975);
      return null;
    }
    v.d("MicroMsg.AppSortStorage", "getAppListByFlag count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
    int i = ((Cursor)localObject).getColumnIndex("appId");
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(i));
    }
    ((Cursor)localObject).close();
    GMTrace.o(801950924800L, 5975);
    return localArrayList;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */