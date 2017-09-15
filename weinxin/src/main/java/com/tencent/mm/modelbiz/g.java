package com.tencent.mm.modelbiz;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.b;
import com.tencent.mm.protocal.c.ahv;
import com.tencent.mm.protocal.c.ahw;
import com.tencent.mm.protocal.c.ahy;
import com.tencent.mm.protocal.c.bph;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.x.c;
import com.tencent.mm.x.i;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class g
  implements e
{
  Object hvp;
  Set<String> hvq;
  public LinkedList<a> hvr;
  
  public g()
  {
    GMTrace.i(4550652067840L, 33905);
    this.hvp = new Object();
    this.hvq = new HashSet();
    this.hvr = new LinkedList();
    GMTrace.o(4550652067840L, 33905);
  }
  
  private void b(LinkedList<bph> paramLinkedList)
  {
    GMTrace.i(4551323156480L, 33910);
    for (;;)
    {
      int i;
      synchronized (this.hvp)
      {
        ArrayList localArrayList = new ArrayList(this.hvr);
        i = 0;
        if (i < localArrayList.size())
        {
          a locala = (a)localArrayList.get(i);
          if (locala != null) {
            locala.c(paramLinkedList);
          }
        }
        else
        {
          GMTrace.o(4551323156480L, 33910);
          return;
        }
      }
      i += 1;
    }
  }
  
  public final void U(String paramString1, String paramString2)
  {
    GMTrace.i(4551054721024L, 33908);
    if ((bf.mA(paramString1)) || (bf.mA(paramString2)))
    {
      v.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", new Object[] { paramString1, paramString2 });
      GMTrace.o(4551054721024L, 33908);
      return;
    }
    if (this.hvq.contains(paramString2))
    {
      v.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", new Object[] { paramString2 });
      GMTrace.o(4551054721024L, 33908);
      return;
    }
    this.hvq.add(paramString2);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add(paramString2);
    localObject = new u(paramString1, (LinkedList)localObject);
    ((u)localObject).tag = paramString2;
    com.tencent.mm.kernel.h.vH().gXs.a((k)localObject, 0);
    v.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d", new Object[] { paramString1, paramString2, Integer.valueOf(this.hvr.size()) });
    GMTrace.o(4551054721024L, 33908);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(4551188938752L, 33909);
    v.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramk == null)
    {
      v.e("MicroMsg.BizKFService", "scene == null");
      b(null);
      GMTrace.o(4551188938752L, 33909);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      v.e("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramk.getType()) });
      b(null);
      if (paramk.getType() == 675) {
        this.hvq.remove(((u)paramk).tag);
      }
      GMTrace.o(4551188938752L, 33909);
      return;
    }
    v.i("MicroMsg.BizKFService", "scene.getType() = %s", new Object[] { Integer.valueOf(paramk.getType()) });
    i locali = com.tencent.mm.x.n.Bm();
    LinkedList localLinkedList = new LinkedList();
    paramString = null;
    long l = System.currentTimeMillis();
    Iterator localIterator;
    bph localbph;
    com.tencent.mm.x.h localh;
    if (paramk.getType() == 672)
    {
      if (((t)paramk).DD() == null)
      {
        v.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramk.getType()) });
        b(null);
        GMTrace.o(4551188938752L, 33909);
        return;
      }
      paramString = ((t)paramk).DD().tKt;
      if ((paramString == null) || (paramString.size() <= 0))
      {
        v.e("MicroMsg.BizKFService", "empty workers");
        b(null);
        GMTrace.o(4551188938752L, 33909);
        return;
      }
      localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        localbph = (bph)localIterator.next();
        localLinkedList.add(new f(localbph.ume, ((t)paramk).hvO, localbph.mrE, localbph.tLN, 1, l));
        if (locali != null)
        {
          localh = new com.tencent.mm.x.h();
          localh.username = localbph.ume;
          localh.hrj = localbph.mrE;
          localh.aV(false);
          localh.gkg = 3;
          locali.a(localh);
          com.tencent.mm.x.n.Bz().hg(localbph.ume);
        }
      }
    }
    for (;;)
    {
      v.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(w.DG().d(localLinkedList)) });
      b(paramString);
      GMTrace.o(4551188938752L, 33909);
      return;
      if (paramk.getType() == 675)
      {
        this.hvq.remove(((u)paramk).tag);
        if (((u)paramk).DE() == null)
        {
          v.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", new Object[] { Integer.valueOf(paramk.getType()) });
          b(null);
          GMTrace.o(4551188938752L, 33909);
          return;
        }
        paramString = ((u)paramk).DE().tKt;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          v.e("MicroMsg.BizKFService", "empty workers");
          b(null);
          GMTrace.o(4551188938752L, 33909);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localbph = (bph)localIterator.next();
          v.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s", new Object[] { localbph.ume, ((u)paramk).tag });
          localLinkedList.add(new f(localbph.ume, ((u)paramk).hvO, localbph.mrE, localbph.tLN, ((u)paramk).hvP, l));
          if (locali != null)
          {
            localh = new com.tencent.mm.x.h();
            localh.username = localbph.ume;
            localh.hrj = localbph.mrE;
            localh.aV(false);
            localh.gkg = 3;
            locali.a(localh);
            com.tencent.mm.x.n.Bz().hg(localbph.ume);
          }
        }
      }
      else if (paramk.getType() == 674)
      {
        if (((s)paramk).DC() == null)
        {
          v.e("MicroMsg.BizKFService", "resp is null, type = %s", new Object[] { Integer.valueOf(paramk.getType()) });
          b(null);
          GMTrace.o(4551188938752L, 33909);
          return;
        }
        paramString = ((s)paramk).DC().tKt;
        if ((paramString == null) || (paramString.size() <= 0))
        {
          v.e("MicroMsg.BizKFService", "empty workers");
          b(null);
          GMTrace.o(4551188938752L, 33909);
          return;
        }
        localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          localbph = (bph)localIterator.next();
          localLinkedList.add(new f(localbph.ume, ((s)paramk).hvO, localbph.mrE, localbph.tLN, 2, l));
          if (locali != null)
          {
            localh = new com.tencent.mm.x.h();
            localh.username = localbph.ume;
            localh.hrj = localbph.mrE;
            localh.aV(false);
            localh.gkg = 3;
            locali.a(localh);
            com.tencent.mm.x.n.Bz().hg(localbph.ume);
          }
        }
      }
    }
  }
  
  public final void a(a parama)
  {
    GMTrace.i(4550786285568L, 33906);
    synchronized (this.hvp)
    {
      if (!this.hvr.contains(parama))
      {
        Iterator localIterator = this.hvr.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if ((parama != null) && (locala != null) && (bf.mz(parama.Dz()).equals(bf.mz(locala.Dz()))))
          {
            v.i("MicroMsg.BizKFService", "the same callbacker %s, return", new Object[] { parama.Dz() });
            GMTrace.o(4550786285568L, 33906);
            return;
          }
        }
        this.hvr.add(parama);
      }
      GMTrace.o(4550786285568L, 33906);
      return;
    }
  }
  
  public final void b(a parama)
  {
    GMTrace.i(4550920503296L, 33907);
    synchronized (this.hvp)
    {
      if (this.hvr.contains(parama)) {
        this.hvr.remove(parama);
      }
      GMTrace.o(4550920503296L, 33907);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract String Dz();
    
    public abstract void c(LinkedList<bph> paramLinkedList);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */