package com.tencent.mm.pluginsdk.e;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.qd;
import com.tencent.mm.sdk.b.a;

public final class e
{
  public static qd LJ(String paramString)
  {
    GMTrace.i(900869390336L, 6712);
    qd localqd = new qd();
    localqd.fWY.fJr = 1;
    localqd.fWY.fWZ = paramString;
    a.uql.m(localqd);
    GMTrace.o(900869390336L, 6712);
    return localqd;
  }
  
  public static void LK(String paramString)
  {
    GMTrace.i(901003608064L, 6713);
    qd localqd = new qd();
    localqd.fWY.fJr = 2;
    localqd.fWY.fWZ = paramString;
    a.uql.m(localqd);
    GMTrace.o(901003608064L, 6713);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */