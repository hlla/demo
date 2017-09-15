package com.tencent.mm.ah;

import com.tencent.gmtrace.GMTrace;

public final class e
{
  public static d a(d paramd)
  {
    GMTrace.i(3518115086336L, 26212);
    if (paramd == null)
    {
      GMTrace.o(3518115086336L, 26212);
      return null;
    }
    if (paramd.GC())
    {
      d locald = n.GT().fT(paramd.hEQ);
      if (locald == null)
      {
        GMTrace.o(3518115086336L, 26212);
        return paramd;
      }
      GMTrace.o(3518115086336L, 26212);
      return locald;
    }
    GMTrace.o(3518115086336L, 26212);
    return paramd;
  }
  
  public static boolean b(d paramd)
  {
    GMTrace.i(3518249304064L, 26213);
    if (paramd == null)
    {
      GMTrace.o(3518249304064L, 26213);
      return false;
    }
    int j = paramd.offset;
    int i = paramd.hrb;
    long l = paramd.fTG;
    if (paramd.GC())
    {
      paramd = n.GT().fT(paramd.hEQ);
      j = paramd.offset;
      i = paramd.hrb;
      l = paramd.fTG;
    }
    if (i == 0)
    {
      GMTrace.o(3518249304064L, 26213);
      return true;
    }
    if (((j == i) && (i != 0)) || (l != 0L))
    {
      GMTrace.o(3518249304064L, 26213);
      return true;
    }
    GMTrace.o(3518249304064L, 26213);
    return false;
  }
  
  public static String c(d paramd)
  {
    GMTrace.i(3518383521792L, 26214);
    if (paramd == null)
    {
      GMTrace.o(3518383521792L, 26214);
      return "";
    }
    if (paramd.GC())
    {
      paramd = n.GT().fT(paramd.hEQ);
      if (paramd == null)
      {
        GMTrace.o(3518383521792L, 26214);
        return "";
      }
      paramd = paramd.hEH;
      GMTrace.o(3518383521792L, 26214);
      return paramd;
    }
    paramd = paramd.hEH;
    GMTrace.o(3518383521792L, 26214);
    return paramd;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */