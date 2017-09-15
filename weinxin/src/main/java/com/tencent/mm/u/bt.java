package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;

public final class bt
{
  public static boolean ax(Object paramObject)
  {
    GMTrace.i(18730218160128L, 139551);
    if ((paramObject instanceof Boolean)) {
      try
      {
        boolean bool = ((Boolean)paramObject).booleanValue();
        GMTrace.o(18730218160128L, 139551);
        return bool;
      }
      catch (Exception paramObject) {}
    }
    GMTrace.o(18730218160128L, 139551);
    return false;
  }
  
  public static String b(Object paramObject, String paramString)
  {
    GMTrace.i(18730083942400L, 139550);
    if ((paramObject instanceof String)) {
      try
      {
        paramObject = (String)paramObject;
        GMTrace.o(18730083942400L, 139550);
        return (String)paramObject;
      }
      catch (Exception paramObject) {}
    }
    GMTrace.o(18730083942400L, 139550);
    return paramString;
  }
  
  public static int getInt(Object paramObject, int paramInt)
  {
    GMTrace.i(18729949724672L, 139549);
    if ((paramObject instanceof Integer)) {
      try
      {
        int i = ((Integer)paramObject).intValue();
        GMTrace.o(18729949724672L, 139549);
        return i;
      }
      catch (Exception paramObject) {}
    }
    GMTrace.o(18729949724672L, 139549);
    return paramInt;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */