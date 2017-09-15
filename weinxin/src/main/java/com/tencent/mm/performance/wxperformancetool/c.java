package com.tencent.mm.performance.wxperformancetool;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.performance.c.c.b;
import com.tencent.mm.performance.c.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class c
{
  HashSet<com.tencent.mm.performance.d.a> igG;
  public b igH;
  
  public c()
  {
    GMTrace.i(13136828563456L, 97877);
    this.igG = new HashSet();
    GMTrace.o(13136828563456L, 97877);
  }
  
  private boolean mn(String paramString)
  {
    GMTrace.i(13137902305280L, 97885);
    if (this.igG.isEmpty())
    {
      GMTrace.o(13137902305280L, 97885);
      return false;
    }
    Iterator localIterator = this.igG.iterator();
    while (localIterator.hasNext()) {
      if (((com.tencent.mm.performance.d.a)localIterator.next()).Nc().equals(paramString))
      {
        GMTrace.o(13137902305280L, 97885);
        return true;
      }
    }
    GMTrace.o(13137902305280L, 97885);
    return false;
  }
  
  private com.tencent.mm.performance.d.a mo(String paramString)
  {
    GMTrace.i(13138036523008L, 97886);
    if (this.igG.isEmpty())
    {
      GMTrace.o(13138036523008L, 97886);
      return null;
    }
    Iterator localIterator = this.igG.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.performance.d.a locala = (com.tencent.mm.performance.d.a)localIterator.next();
      if (locala.Nc().equals(paramString))
      {
        GMTrace.o(13138036523008L, 97886);
        return locala;
      }
    }
    GMTrace.o(13138036523008L, 97886);
    return null;
  }
  
  public final boolean Nf()
  {
    GMTrace.i(13136962781184L, 97878);
    boolean bool3 = mn(com.tencent.mm.performance.a.a.TYPE);
    boolean bool2;
    if (!bool3)
    {
      com.tencent.mm.performance.a.a locala = new com.tencent.mm.performance.a.a();
      bool2 = locala.Nb();
      bool1 = bool2;
      if (bool2)
      {
        locala.ifP = new HashSet();
        this.igG.add(locala);
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if ((bool3) || (bool1))
      {
        GMTrace.o(13136962781184L, 97878);
        return true;
      }
      GMTrace.o(13136962781184L, 97878);
      return false;
    }
  }
  
  public final boolean Ng()
  {
    GMTrace.i(13137231216640L, 97880);
    boolean bool = false;
    if (!mn(com.tencent.mm.performance.c.c.TYPE))
    {
      if (!mn(com.tencent.mm.performance.a.a.TYPE)) {
        throw new IllegalArgumentException("setMonitorMemoryLeak, you should setMonitorActivityLifeCycle first(and return true)");
      }
      bool = true;
      com.tencent.mm.performance.c.c localc = new com.tencent.mm.performance.c.c();
      localc.ifY = new HashSet();
      localc.igg = new HashSet();
      localc.igf = new HashMap();
      if (com.tencent.mm.performance.c.a.isEnabled()) {
        com.tencent.mm.performance.c.a.bl(aa.getContext());
      }
      a(new c.b(localc));
      this.igG.add(localc);
    }
    GMTrace.o(13137231216640L, 97880);
    return bool;
  }
  
  public final boolean Nh()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    GMTrace.i(13137499652096L, 97882);
    boolean bool3 = mn(com.tencent.mm.performance.b.a.TYPE);
    if (!bool3)
    {
      com.tencent.mm.performance.b.a locala = new com.tencent.mm.performance.b.a();
      locala.igq = 60000L;
      locala.ifU = 50L;
      locala.ifV = 70L;
      locala.ifW = 90L;
      bool1 = bool2;
      if (locala.ifT > 0L) {
        bool1 = true;
      }
      locala.ifX = bool1;
      bool2 = locala.ifX;
      bool1 = bool2;
      if (bool2)
      {
        locala.ifY = new HashSet();
        this.igG.add(locala);
        bool1 = bool2;
      }
    }
    GMTrace.o(13137499652096L, 97882);
    return bool1 | bool3;
  }
  
  public final void a(com.tencent.mm.performance.a.a.a parama)
  {
    GMTrace.i(13137096998912L, 97879);
    if (mn(com.tencent.mm.performance.a.a.TYPE))
    {
      ((com.tencent.mm.performance.a.a)mo(com.tencent.mm.performance.a.a.TYPE)).a(parama);
      GMTrace.o(13137096998912L, 97879);
      return;
    }
    throw new IllegalArgumentException("registerActivityLifeCycleCallback, you must set monitor activity lifecycle first");
  }
  
  public final void a(com.tencent.mm.performance.b.a.a parama)
  {
    GMTrace.i(13137633869824L, 97883);
    if (mn(com.tencent.mm.performance.b.a.TYPE))
    {
      com.tencent.mm.performance.b.a locala = (com.tencent.mm.performance.b.a)mo(com.tencent.mm.performance.b.a.TYPE);
      synchronized (locala.ifY)
      {
        locala.ifY.add(parama);
        GMTrace.o(13137633869824L, 97883);
        return;
      }
    }
    throw new IllegalArgumentException("registerMemoryAlarmCallback, you must set monitor memoryleak first");
  }
  
  public final void a(c.c paramc)
  {
    GMTrace.i(13137365434368L, 97881);
    if (mn(com.tencent.mm.performance.c.c.TYPE))
    {
      com.tencent.mm.performance.c.c localc = (com.tencent.mm.performance.c.c)mo(com.tencent.mm.performance.c.c.TYPE);
      synchronized (localc.ifY)
      {
        localc.ifY.add(paramc);
        GMTrace.o(13137365434368L, 97881);
        return;
      }
    }
    throw new IllegalArgumentException("registerMemoryLeakCallback, you must set monitor memoryleak first");
  }
  
  public final void mm(String paramString)
  {
    GMTrace.i(13137768087552L, 97884);
    com.tencent.mm.performance.d.a locala = mo(paramString);
    if (locala != null)
    {
      locala.igq = 10000L;
      GMTrace.o(13137768087552L, 97884);
      return;
    }
    throw new IllegalArgumentException("setTypeMointorInterval, " + paramString + " is not opened");
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/performance/wxperformancetool/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */