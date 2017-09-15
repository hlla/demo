package com.tencent.mm.memory;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Set;

public abstract class a<T>
  extends e<T, Integer>
{
  public a()
  {
    GMTrace.i(1285000527872L, 9574);
    GMTrace.o(1285000527872L, 9574);
  }
  
  public T b(Integer paramInteger)
  {
    label160:
    for (;;)
    {
      try
      {
        GMTrace.i(1285134745600L, 9575);
        paramInteger = this.hgs.subMap(paramInteger, true, Integer.valueOf(Integer.MAX_VALUE), true);
        if ((paramInteger != null) && (!paramInteger.isEmpty()))
        {
          Iterator localIterator = paramInteger.keySet().iterator();
          if (!localIterator.hasNext()) {
            break label160;
          }
          d locald = (d)paramInteger.get(Integer.valueOf(((Integer)localIterator.next()).intValue()));
          if (locald.size() <= 0) {
            continue;
          }
          paramInteger = locald.pop();
          this.hgs.put(locald.wm(), locald);
          if (paramInteger != null)
          {
            J(at(paramInteger));
            GMTrace.o(1285134745600L, 9575);
            return paramInteger;
          }
        }
        GMTrace.o(1285134745600L, 9575);
        paramInteger = null;
        continue;
        paramInteger = null;
      }
      finally {}
    }
  }
  
  public T c(Integer paramInteger)
  {
    for (;;)
    {
      d locald;
      try
      {
        GMTrace.i(1285268963328L, 9576);
        locald = (d)this.hgs.get(paramInteger);
        if ((locald != null) && (locald.size() > 0))
        {
          paramInteger = locald.pop();
          this.hgs.put(locald.wm(), locald);
          J(at(paramInteger));
          GMTrace.o(1285268963328L, 9576);
          return paramInteger;
        }
        if (locald == null)
        {
          i = -1;
          v.d("MicroMsg.BiggerThanPool", "BiggerThanPool getExactSize cannot get %s size count %d", new Object[] { paramInteger, Integer.valueOf(i) });
          paramInteger = null;
          GMTrace.o(1285268963328L, 9576);
          continue;
        }
        if (locald.hgq != null) {
          break label137;
        }
      }
      finally {}
      int i = -1;
      continue;
      label137:
      i = locald.hgq.size();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/memory/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */