package com.tencent.c.d.a;

import com.tencent.c.d.b.d.a;
import com.tencent.c.e.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements b
{
  private final HashSet<Integer> wQb = new HashSet();
  private final List<d.a> wQc = new ArrayList();
  
  public final void a(d.a parama)
  {
    if (parama.uid != 0) {}
    do
    {
      return;
      if ((parama.wQh == 1) && (!"/sbin/adbd".equals(parama.name)))
      {
        g.d("ProcessRelationAnalyzer parent : " + parama.toString());
        this.wQb.add(Integer.valueOf(parama.pid));
        return;
      }
    } while ((parama.wQh <= 1) || (!"sh".equals(parama.name)) || (!"/system/bin/sh".equals(parama.name)));
    g.d("ProcessRelationAnalyzer child : " + parama.toString());
    this.wQc.add(parama);
  }
  
  public final boolean cdw()
  {
    Iterator localIterator = this.wQc.iterator();
    while (localIterator.hasNext())
    {
      d.a locala = (d.a)localIterator.next();
      if (this.wQb.contains(Integer.valueOf(locala.wQh)))
      {
        g.Ve("ProcessRelationAnalyzer match : " + locala.toString());
        return true;
      }
    }
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/d/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */