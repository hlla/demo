package com.tencent.mm.ap;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.kernel.a;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.bm;
import java.util.Iterator;
import java.util.LinkedList;

public final class p
  extends c<lc>
{
  public p()
  {
    GMTrace.i(12945299865600L, 96450);
    this.uqt = lc.class.getName().hashCode();
    GMTrace.o(12945299865600L, 96450);
  }
  
  private static boolean Ia()
  {
    GMTrace.i(12945434083328L, 96451);
    int i;
    if (com.tencent.mm.kernel.h.vG().uV())
    {
      com.tencent.mm.kernel.h.vG();
      if (!a.uP())
      {
        i = 1;
        if (i == 0) {
          break label352;
        }
        if (bf.az(bf.a((Long)com.tencent.mm.kernel.h.vI().vr().get(68097, null), 0L)) * 1000L <= 3600000L) {
          break label129;
        }
        i = 1;
      }
    }
    LinkedList localLinkedList;
    for (;;)
    {
      if (i != 0)
      {
        localLinkedList = new LinkedList();
        Object localObject = com.tencent.mm.a.e.d(com.tencent.mm.kernel.h.vI().cachePath + "eggresult.rep", 0, -1);
        if (localObject == null)
        {
          GMTrace.o(12945434083328L, 96451);
          return false;
          i = 0;
          break;
          label129:
          i = 0;
          continue;
        }
        try
        {
          localObject = ((h)new h().aD((byte[])localObject)).hNQ.iterator();
          while (((Iterator)localObject).hasNext())
          {
            g localg = (g)((Iterator)localObject).next();
            aie localaie;
            if (localg.hNO != 0)
            {
              localaie = new aie();
              localaie.oSb = 17;
              localaie.oSl = (localg.hND + "," + localg.hNO);
              localLinkedList.add(localaie);
            }
            if (localg.hNP != 0)
            {
              localaie = new aie();
              localaie.oSb = 18;
              localaie.oSl = (localg.hND + "," + localg.hNP);
              localLinkedList.add(localaie);
            }
          }
          if (localLinkedList.isEmpty()) {}
        }
        catch (Exception localException)
        {
          v.e("MicroMsg.PostTaskReportEgg", "exception:%s", new Object[] { bf.g(localException) });
        }
      }
    }
    for (;;)
    {
      bm.a(localLinkedList);
      com.tencent.mm.kernel.h.vI().vr().set(68097, Long.valueOf(bf.Nz()));
      label352:
      v.d("MicroMsg.PostTaskReportEgg", "report egg done");
      GMTrace.o(12945434083328L, 96451);
      return false;
      b.deleteFile(com.tencent.mm.kernel.h.vI().cachePath + "eggresult.rep");
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */