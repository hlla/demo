package com.tencent.mm.booter;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.s;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import java.util.LinkedList;

public final class i
{
  public static void run()
  {
    GMTrace.i(497276682240L, 3705);
    LinkedList localLinkedList = new LinkedList();
    int j = bf.a((Integer)ap.yW().get(19), 0);
    int i = 0;
    aie localaie;
    while (i < j)
    {
      localaie = new aie();
      localaie.oSb = 31;
      localaie.oSl = "0";
      localLinkedList.add(localaie);
      i += 1;
    }
    j = bf.a((Integer)ap.yW().get(20), 0);
    i = 0;
    while (i < j)
    {
      localaie = new aie();
      localaie.oSb = 31;
      localaie.oSl = "1";
      localLinkedList.add(localaie);
      i += 1;
    }
    if (localLinkedList.size() > 0)
    {
      bm.a(localLinkedList);
      ap.yW().set(19, Integer.valueOf(0));
      ap.yW().set(20, Integer.valueOf(0));
    }
    GMTrace.o(497276682240L, 3705);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */