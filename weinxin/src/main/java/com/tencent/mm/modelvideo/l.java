package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends i<j>
{
  public static final String[] gUn;
  public e gUp;
  
  static
  {
    GMTrace.i(345744867328L, 2576);
    gUn = new String[] { i.a(j.gTF, "SightDraftInfo") };
    GMTrace.o(345744867328L, 2576);
  }
  
  public l(e parame)
  {
    super(parame, j.gTF, "SightDraftInfo", null);
    GMTrace.i(344805343232L, 2569);
    this.gUp = parame;
    GMTrace.o(344805343232L, 2569);
  }
  
  public final List<j> KT()
  {
    GMTrace.i(345073778688L, 2571);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = "SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC " + new StringBuilder(" LIMIT 5").toString();
    localObject = this.gUp.a((String)localObject, new String[] { "7" }, 2);
    if (localObject == null)
    {
      GMTrace.o(345073778688L, 2571);
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      j localj = new j();
      localj.b((Cursor)localObject);
      localLinkedList.add(localj);
    }
    ((Cursor)localObject).close();
    GMTrace.o(345073778688L, 2571);
    return localLinkedList;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */