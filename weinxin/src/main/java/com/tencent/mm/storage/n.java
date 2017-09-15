package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.protocal.c.eb;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class n
  extends i<m>
{
  public static final String[] gUn;
  private e gUp;
  
  static
  {
    GMTrace.i(17948399894528L, 133726);
    gUn = new String[] { i.a(m.gTF, "BackupTempMoveTime") };
    GMTrace.o(17948399894528L, 133726);
  }
  
  public n(g paramg)
  {
    super(paramg, m.gTF, "BackupTempMoveTime", null);
    GMTrace.i(17947863023616L, 133722);
    this.gUp = paramg;
    GMTrace.o(17947863023616L, 133722);
  }
  
  public final void a(LinkedList<String> paramLinkedList1, LinkedList<Long> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<Long> paramLinkedList4)
  {
    GMTrace.i(17947997241344L, 133723);
    if (getCount() <= 0)
    {
      paramLinkedList3.addAll(paramLinkedList1);
      paramLinkedList4.addAll(paramLinkedList2);
      GMTrace.o(17947997241344L, 133723);
      return;
    }
    paramLinkedList2 = paramLinkedList2.iterator();
    Iterator localIterator = paramLinkedList1.iterator();
    label376:
    int j;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i = 0;
      if (paramLinkedList2.hasNext())
      {
        long l1 = ((Long)paramLinkedList2.next()).longValue();
        if (paramLinkedList2.hasNext())
        {
          long l3 = ((Long)paramLinkedList2.next()).longValue();
          long l2 = l3;
          if (l3 == 0L) {
            l2 = Long.MAX_VALUE;
          }
          paramLinkedList1 = new LinkedList();
          Object localObject = "SELECT * FROM BackupTempMoveTime WHERE sessionName = \"" + str + "\" ";
          v.d("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession:" + (String)localObject);
          localObject = this.gUp.rawQuery((String)localObject, null);
          if (localObject == null)
          {
            v.e("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession failed, sessionName:%s ", new Object[] { str });
            paramLinkedList1 = null;
          }
          for (;;)
          {
            if ((paramLinkedList1 != null) && (paramLinkedList1.size() > 0) && (l2 >= ((eb)paramLinkedList1.getFirst()).startTime) && (l1 <= ((eb)paramLinkedList1.getLast()).endTime)) {
              break label376;
            }
            paramLinkedList3.add(str);
            paramLinkedList4.add(Long.valueOf(l1));
            paramLinkedList4.add(Long.valueOf(l2));
            break;
            while (((Cursor)localObject).moveToNext())
            {
              m localm = new m();
              localm.b((Cursor)localObject);
              eb localeb = new eb();
              localeb.startTime = localm.field_startTime;
              localeb.endTime = localm.field_endTime;
              paramLinkedList1.add(localeb);
            }
            ((Cursor)localObject).close();
          }
          j = 0;
          if ((j >= paramLinkedList1.size()) || (l1 > l2)) {
            break label598;
          }
          localObject = (eb)paramLinkedList1.get(j);
          if (l1 > ((eb)localObject).endTime) {
            break label601;
          }
          if (l1 < ((eb)localObject).startTime)
          {
            i = 1;
            paramLinkedList3.add(str);
            paramLinkedList4.add(Long.valueOf(l1));
            if (l2 < ((eb)localObject).startTime)
            {
              paramLinkedList4.add(Long.valueOf(l2));
              l1 = ((eb)localObject).startTime;
              i = 1;
              label482:
              if (l1 <= l2)
              {
                paramLinkedList3.add(str);
                paramLinkedList4.add(Long.valueOf(l1));
                paramLinkedList4.add(Long.valueOf(l2));
                i = 1;
              }
              if (i == 0)
              {
                paramLinkedList3.add(str);
                paramLinkedList4.add(Long.valueOf(l1));
                paramLinkedList4.add(Long.valueOf(l2));
              }
            }
            else
            {
              paramLinkedList4.add(Long.valueOf(((eb)localObject).startTime));
            }
          }
          else
          {
            l1 = ((eb)localObject).endTime;
          }
        }
      }
    }
    label598:
    label601:
    for (;;)
    {
      j += 1;
      break;
      GMTrace.o(17947997241344L, 133723);
      return;
      break label482;
    }
  }
  
  public final boolean bKG()
  {
    GMTrace.i(17948131459072L, 133724);
    boolean bool = this.gUp.eE("BackupTempMoveTime", "delete from BackupTempMoveTime");
    v.i("MicroMsg.BackupTempMoveTimeStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    GMTrace.o(17948131459072L, 133724);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */