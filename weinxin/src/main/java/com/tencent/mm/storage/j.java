package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.protocal.c.eb;
import com.tencent.mm.protocal.c.ec;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class j
  extends com.tencent.mm.sdk.e.i<i>
{
  public static final String[] gUn;
  public e gUp;
  
  static
  {
    GMTrace.i(17947728805888L, 133721);
    gUn = new String[] { com.tencent.mm.sdk.e.i.a(i.gTF, "BackupMoveTime") };
    GMTrace.o(17947728805888L, 133721);
  }
  
  public j(g paramg)
  {
    super(paramg, i.gTF, "BackupMoveTime", null);
    GMTrace.i(17947057717248L, 133716);
    this.gUp = paramg;
    long l1 = System.currentTimeMillis();
    long l2 = paramg.cs(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new String[] { "CREATE INDEX IF NOT EXISTS BackupMoveTimeDeviceIdSessionIndex ON BackupMoveTime ( deviceId,sessionName )" }));
    int i = 0;
    while (i < localArrayList.size())
    {
      paramg.eE("BackupMoveTime", (String)localArrayList.get(i));
      i += 1;
    }
    v.d("MicroMsg.BackupMoveTimeStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramg.aD(l2);
    v.i("MicroMsg.BackupMoveTimeStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    GMTrace.o(17947057717248L, 133716);
  }
  
  private static void a(LinkedList<eb> paramLinkedList, m paramm)
  {
    GMTrace.i(17947460370432L, 133719);
    if (paramm.field_startTime > paramm.field_endTime)
    {
      GMTrace.o(17947460370432L, 133719);
      return;
    }
    Object localObject = paramLinkedList.iterator();
    eb localeb1;
    int i;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localeb1 = (eb)((Iterator)localObject).next();
        if (paramm.field_startTime < localeb1.endTime) {
          if (paramm.field_endTime < localeb1.startTime)
          {
            localObject = new eb();
            ((eb)localObject).startTime = paramm.field_startTime;
            ((eb)localObject).endTime = paramm.field_endTime;
            paramLinkedList.add(localObject);
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject = new eb();
        ((eb)localObject).startTime = paramm.field_startTime;
        ((eb)localObject).endTime = paramm.field_endTime;
        paramLinkedList.add(localObject);
      }
      GMTrace.o(17947460370432L, 133719);
      return;
      if (paramm.field_startTime < localeb1.startTime) {
        localeb1.startTime = paramm.field_startTime;
      }
      if (paramm.field_endTime > localeb1.endTime)
      {
        localeb1.endTime = paramm.field_endTime;
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label275;
          }
          eb localeb2 = (eb)((Iterator)localObject).next();
          if (paramm.field_endTime <= localeb2.startTime) {
            break label275;
          }
          if (paramm.field_endTime <= localeb2.endTime)
          {
            localeb1.endTime = localeb2.endTime;
            ((Iterator)localObject).remove();
            i = 1;
            break;
          }
          ((Iterator)localObject).remove();
        }
      }
      label275:
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public final void a(String paramString, LinkedList<String> paramLinkedList1, LinkedList<Long> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<Long> paramLinkedList4)
  {
    GMTrace.i(17947191934976L, 133717);
    paramLinkedList2 = paramLinkedList2.iterator();
    Iterator localIterator = paramLinkedList1.iterator();
    label332:
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
          paramLinkedList1 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + paramString + "\" AND sessionName = \"" + str + "\" ";
          v.d("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession:" + paramLinkedList1);
          paramLinkedList1 = this.gUp.rawQuery(paramLinkedList1, null);
          if (paramLinkedList1 == null)
          {
            v.e("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession failed, deviceid:%s, sessionName:%s ", new Object[] { paramString, str });
            paramLinkedList1 = null;
          }
          for (;;)
          {
            if ((paramLinkedList1 != null) && (paramLinkedList1.tgk.size() > 0) && (l2 >= ((eb)paramLinkedList1.tgk.getFirst()).startTime) && (l1 <= ((eb)paramLinkedList1.tgk.getLast()).endTime)) {
              break label332;
            }
            paramLinkedList3.add(str);
            paramLinkedList4.add(Long.valueOf(l1));
            paramLinkedList4.add(Long.valueOf(l2));
            break;
            if (paramLinkedList1.moveToFirst())
            {
              localObject = new i();
              ((i)localObject).b(paramLinkedList1);
              paramLinkedList1.close();
              paramLinkedList1 = ((i)localObject).field_moveTime;
            }
            else
            {
              paramLinkedList1.close();
              paramLinkedList1 = null;
            }
          }
          paramLinkedList1 = paramLinkedList1.tgk;
          j = 0;
          if ((j >= paramLinkedList1.size()) || (l1 > l2)) {
            break label562;
          }
          Object localObject = (eb)paramLinkedList1.get(j);
          if (l1 > ((eb)localObject).endTime) {
            break label565;
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
              label444:
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
    label562:
    label565:
    for (;;)
    {
      j += 1;
      break;
      GMTrace.o(17947191934976L, 133717);
      return;
      break label444;
    }
  }
  
  public final void d(String paramString, LinkedList<m> paramLinkedList)
  {
    GMTrace.i(17947326152704L, 133718);
    v.i("MicroMsg.BackupMoveTimeStorage", "start mergeDataByDeviceIdSession.");
    HashMap localHashMap = new HashMap();
    Object localObject1 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + paramString + "\" ";
    v.d("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice:" + (String)localObject1);
    localObject1 = this.gUp.rawQuery((String)localObject1, null);
    if (localObject1 == null) {
      v.e("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice failed, deviceid:%s", new Object[] { paramString });
    }
    Object localObject2;
    while (this.gUp.delete("BackupMoveTime", "deviceId= ? ", new String[] { paramString }) < 0)
    {
      v.e("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId delete db failed, deviceid:%s", new Object[] { paramString });
      GMTrace.o(17947326152704L, 133718);
      return;
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new i();
        ((i)localObject2).b((Cursor)localObject1);
        localHashMap.put(((i)localObject2).field_sessionName, localObject2);
      }
      ((Cursor)localObject1).close();
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (m)paramLinkedList.next();
      localObject2 = (i)localHashMap.get(((m)localObject1).field_sessionName);
      if (localObject2 == null)
      {
        localObject2 = new eb();
        ((eb)localObject2).startTime = ((m)localObject1).field_startTime;
        ((eb)localObject2).endTime = ((m)localObject1).field_endTime;
        i locali = new i();
        locali.field_deviceId = paramString;
        locali.field_sessionName = ((m)localObject1).field_sessionName;
        locali.field_moveTime = new ec();
        locali.field_moveTime.tgk = new LinkedList();
        locali.field_moveTime.tgk.add(localObject2);
        localHashMap.put(((m)localObject1).field_sessionName, locali);
      }
      else
      {
        a(((i)localObject2).field_moveTime.tgk, (m)localObject1);
      }
    }
    paramString = localHashMap.keySet().iterator();
    while (paramString.hasNext())
    {
      paramLinkedList = (String)paramString.next();
      v.i("MicroMsg.BackupMoveTimeStorage", "summerbak insert BackupMoveTimeStorage ret[%b], sessionName:%s", new Object[] { Boolean.valueOf(b((c)localHashMap.get(paramLinkedList))), paramLinkedList });
    }
    GMTrace.o(17947326152704L, 133718);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */