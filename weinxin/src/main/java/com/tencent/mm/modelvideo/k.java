package com.tencent.mm.modelvideo;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bf;

public final class k
{
  public static final String KS()
  {
    GMTrace.i(16387313500160L, 122095);
    String str = h.vI().gXV + "draft/";
    GMTrace.o(16387313500160L, 122095);
    return str;
  }
  
  public static final String ln(String paramString)
  {
    GMTrace.i(329907175424L, 2458);
    if (bf.mA(paramString))
    {
      GMTrace.o(329907175424L, 2458);
      return null;
    }
    paramString = KS() + paramString;
    GMTrace.o(329907175424L, 2458);
    return paramString;
  }
  
  public static final String lo(String paramString)
  {
    GMTrace.i(330041393152L, 2459);
    if (bf.mA(paramString))
    {
      GMTrace.o(330041393152L, 2459);
      return null;
    }
    paramString = KS() + paramString + ".thumb";
    GMTrace.o(330041393152L, 2459);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */