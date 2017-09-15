package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;

public final class bc
{
  public static a hnd;
  
  static
  {
    GMTrace.i(13488344793088L, 100496);
    hnd = null;
    GMTrace.o(13488344793088L, 100496);
  }
  
  public static j a(j paramj)
  {
    GMTrace.i(13488210575360L, 100495);
    if (hnd == null)
    {
      GMTrace.o(13488210575360L, 100495);
      return paramj;
    }
    paramj = hnd.zB();
    GMTrace.o(13488210575360L, 100495);
    return paramj;
  }
  
  public static abstract interface a
  {
    public abstract j zB();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */