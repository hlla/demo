package com.tencent.mm.plugin.n;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.n;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.at;
import com.tencent.mm.u.l;

public final class a
  extends l
{
  private static a mKs;
  
  private a()
  {
    super(n.class);
    GMTrace.i(14599801798656L, 108777);
    GMTrace.o(14599801798656L, 108777);
  }
  
  public static a aDn()
  {
    try
    {
      GMTrace.i(14599936016384L, 108778);
      if (mKs == null) {
        mKs = new a();
      }
      a locala = mKs;
      GMTrace.o(14599936016384L, 108778);
      return locala;
    }
    finally {}
  }
  
  public static at wY()
  {
    GMTrace.i(16423820722176L, 122367);
    h.vG().uQ();
    at localat = ((com.tencent.mm.plugin.r.a.a)h.h(com.tencent.mm.plugin.r.a.a.class)).wY();
    GMTrace.o(16423820722176L, 122367);
    return localat;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/n/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */