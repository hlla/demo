package com.tencent.mm.plugin.appbrand.config;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;
import org.json.JSONArray;

final class r
{
  static LinkedList<String> g(JSONArray paramJSONArray)
  {
    GMTrace.i(17508836835328L, 130451);
    if (paramJSONArray == null)
    {
      GMTrace.o(17508836835328L, 130451);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localLinkedList.add(paramJSONArray.optString(i));
      i += 1;
    }
    GMTrace.o(17508836835328L, 130451);
    return localLinkedList;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/appbrand/config/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */