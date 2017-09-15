package com.tencent.mm.vending.g;

import com.tencent.gmtrace.GMTrace;
import java.util.Stack;

final class f
{
  private static f wBr;
  ThreadLocal<Stack<c>> wBs;
  
  static
  {
    GMTrace.i(288031244288L, 2146);
    wBr = null;
    wBr = new f();
    GMTrace.o(288031244288L, 2146);
  }
  
  private f()
  {
    GMTrace.i(287762808832L, 2144);
    this.wBs = new ThreadLocal();
    GMTrace.o(287762808832L, 2144);
  }
  
  public static f cby()
  {
    GMTrace.i(287897026560L, 2145);
    f localf = wBr;
    GMTrace.o(287897026560L, 2145);
    return localf;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/vending/g/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */