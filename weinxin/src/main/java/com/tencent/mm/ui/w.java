package com.tencent.mm.ui;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.qn;
import com.tencent.mm.sdk.b.a;

public final class w
{
  public static void aB(int paramInt, String paramString)
  {
    GMTrace.i(1604304502784L, 11953);
    if (a.uql != null)
    {
      qn localqn = new qn();
      localqn.fXu.className = paramString;
      localqn.fXu.fXv = paramInt;
      a.uql.m(localqn);
    }
    GMTrace.o(1604304502784L, 11953);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */