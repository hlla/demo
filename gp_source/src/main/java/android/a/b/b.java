package android.a.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class b
{
  public final Map a;
  public final Map b;
  
  b(Map paramMap)
  {
    this.b = paramMap;
    this.a = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      k localk = (k)localEntry.getValue();
      List localList = (List)this.a.get(localk);
      paramMap = localList;
      if (localList == null)
      {
        paramMap = new ArrayList();
        this.a.put(localk, paramMap);
      }
      paramMap.add(localEntry.getKey());
    }
  }
  
  static void a(List paramList, n paramn, k paramk, Object paramObject)
  {
    int i;
    if (paramList != null) {
      i = paramList.size() - 1;
    }
    for (;;)
    {
      if (i >= 0)
      {
        c localc = (c)paramList.get(i);
        try
        {
          switch (localc.a)
          {
          case 2: 
            localc.b.invoke(paramObject, new Object[] { paramn, paramk });
          }
        }
        catch (InvocationTargetException paramList)
        {
          throw new RuntimeException("Failed to call observer method", paramList.getCause());
          localc.b.invoke(paramObject, new Object[] { paramn });
        }
        catch (IllegalAccessException paramList)
        {
          throw new RuntimeException(paramList);
        }
        localc.b.invoke(paramObject, new Object[0]);
      }
      else
      {
        return;
      }
      i -= 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */