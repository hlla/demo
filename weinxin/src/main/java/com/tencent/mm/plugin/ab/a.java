package com.tencent.mm.plugin.ab;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import java.util.List;

public final class a
  implements com.tencent.mm.kernel.api.bucket.b, com.tencent.mm.kernel.b.b
{
  private static a oOA;
  
  private a()
  {
    GMTrace.i(16418452013056L, 122327);
    GMTrace.o(16418452013056L, 122327);
  }
  
  public static a aWR()
  {
    try
    {
      GMTrace.i(16418720448512L, 122329);
      if (oOA == null) {
        oOA = new a();
      }
      a locala = oOA;
      GMTrace.o(16418720448512L, 122329);
      return locala;
    }
    finally {}
  }
  
  public static String xd()
  {
    GMTrace.i(16418854666240L, 122330);
    String str = h.vI().gXV + "remark/";
    GMTrace.o(16418854666240L, 122330);
    return str;
  }
  
  public final List<String> collectStoragePaths()
  {
    GMTrace.i(16418586230784L, 122328);
    GMTrace.o(16418586230784L, 122328);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ab/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */