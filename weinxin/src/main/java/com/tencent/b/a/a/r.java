package com.tencent.b.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class r
{
  private static r aQG = null;
  private Map<Integer, q> aQE = null;
  private int aQF = 0;
  
  private r(Context paramContext)
  {
    this.aQE.put(Integer.valueOf(1), new o(paramContext));
    this.aQE.put(Integer.valueOf(2), new d(paramContext));
    this.aQE.put(Integer.valueOf(4), new k(paramContext));
  }
  
  static r T(Context paramContext)
  {
    try
    {
      if (aQG == null) {
        aQG = new r(paramContext);
      }
      paramContext = aQG;
      return paramContext;
    }
    finally {}
  }
  
  private a o(List<Integer> paramList)
  {
    if (paramList.size() > 0) {
      paramList = paramList.iterator();
    }
    Object localObject;
    do
    {
      do
      {
        if (!paramList.hasNext()) {
          return new a();
        }
        localObject = (Integer)paramList.next();
        localObject = (q)this.aQE.get(localObject);
      } while (localObject == null);
      localObject = ((q)localObject).nT();
    } while (localObject == null);
    return (a)localObject;
  }
  
  final void b(a parama)
  {
    Iterator localIterator = this.aQE.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((q)((Map.Entry)localIterator.next()).getValue()).b(parama);
    }
  }
  
  final void b(g paramg)
  {
    Iterator localIterator = this.aQE.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((q)((Map.Entry)localIterator.next()).getValue()).b(paramg);
    }
  }
  
  final g n(List<Integer> paramList)
  {
    if (paramList.size() >= 0) {
      paramList = paramList.iterator();
    }
    Object localObject;
    do
    {
      do
      {
        if (!paramList.hasNext()) {
          return new g();
        }
        localObject = (Integer)paramList.next();
        localObject = (q)this.aQE.get(localObject);
      } while (localObject == null);
      localObject = ((q)localObject).nS();
    } while ((localObject == null) || (!s.aK(((g)localObject).aQm)));
    return (g)localObject;
  }
  
  final g nS()
  {
    return n(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4) })));
  }
  
  final a nT()
  {
    return o(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(4) })));
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/b/a/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */