package com.tencent.mm.pluginsdk.k.a.e;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public enum b
{
  static
  {
    GMTrace.i(843021549568L, 6281);
    sFu = new b[0];
    GMTrace.o(843021549568L, 6281);
  }
  
  public static String ab(Map<String, List<String>> paramMap)
  {
    GMTrace.i(842887331840L, 6280);
    if (paramMap == null)
    {
      GMTrace.o(842887331840L, 6280);
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      localStringBuilder.append(bf.ap((String)((Map.Entry)localObject).getKey(), "null"));
      localStringBuilder.append(" : ");
      localObject = (List)((Map.Entry)localObject).getValue();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append(bf.mz((String)((Iterator)localObject).next())).append("|");
        }
      }
      localStringBuilder.append("\n");
    }
    paramMap = localStringBuilder.toString();
    GMTrace.o(842887331840L, 6280);
    return paramMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */