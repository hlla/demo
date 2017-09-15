package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.gmtrace.GMTrace;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static List<a> gWa;
  private static Map<String, a> gWb;
  
  static
  {
    GMTrace.i(18713709379584L, 139428);
    gWa = new LinkedList();
    gWb = new HashMap();
    GMTrace.o(18713709379584L, 139428);
  }
  
  public static Object a(String paramString, Parcel paramParcel)
  {
    GMTrace.i(18713440944128L, 139426);
    paramString = (a)gWb.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.d(paramParcel);
      GMTrace.o(18713440944128L, 139426);
      return paramString;
    }
    GMTrace.o(18713440944128L, 139426);
    return null;
  }
  
  public static void a(a parama)
  {
    GMTrace.i(18713575161856L, 139427);
    if ((parama == null) || (gWa.contains(parama)))
    {
      GMTrace.o(18713575161856L, 139427);
      return;
    }
    gWb.put(parama.getClass().getName(), parama);
    gWa.add(parama);
    GMTrace.o(18713575161856L, 139427);
  }
  
  public static void a(Object paramObject, Parcel paramParcel)
  {
    GMTrace.i(18713306726400L, 139425);
    a locala = an(paramObject);
    if (locala != null) {
      locala.a(paramObject, paramParcel);
    }
    GMTrace.o(18713306726400L, 139425);
  }
  
  public static a an(Object paramObject)
  {
    GMTrace.i(18713172508672L, 139424);
    Iterator localIterator = gWa.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.am(paramObject))
      {
        GMTrace.o(18713172508672L, 139424);
        return locala;
      }
    }
    GMTrace.o(18713172508672L, 139424);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ipcinvoker/extension/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */