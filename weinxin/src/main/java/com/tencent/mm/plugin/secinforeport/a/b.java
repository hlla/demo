package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public enum b
  implements a
{
  private static a pgh;
  
  static
  {
    GMTrace.i(17524137656320L, 130565);
    pgg = new b("INSTANCE");
    pgi = new b[] { pgg };
    pgh = new a();
    GMTrace.o(17524137656320L, 130565);
  }
  
  private b()
  {
    GMTrace.i(17523466567680L, 130560);
    GMTrace.o(17523466567680L, 130560);
  }
  
  public static void a(a parama)
  {
    GMTrace.i(17523600785408L, 130561);
    if (parama != null) {
      pgh = parama;
    }
    GMTrace.o(17523600785408L, 130561);
  }
  
  public final void DY(String paramString)
  {
    GMTrace.i(18975433949184L, 141378);
    pgh.DY(paramString);
    GMTrace.o(18975433949184L, 141378);
  }
  
  public final boolean aZE()
  {
    GMTrace.i(17523735003136L, 130562);
    boolean bool = pgh.aZE();
    GMTrace.o(17523735003136L, 130562);
    return bool;
  }
  
  public final void bC(String paramString, int paramInt)
  {
    GMTrace.i(18975568166912L, 141379);
    pgh.bC(paramString, paramInt);
    GMTrace.o(18975568166912L, 141379);
  }
  
  private static final class a
    implements a
  {
    public a()
    {
      GMTrace.i(17522258608128L, 130551);
      GMTrace.o(17522258608128L, 130551);
    }
    
    public final void DY(String paramString)
    {
      GMTrace.i(18975970820096L, 141382);
      v.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      GMTrace.o(18975970820096L, 141382);
    }
    
    public final boolean aZE()
    {
      GMTrace.i(17522392825856L, 130552);
      v.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      GMTrace.o(17522392825856L, 130552);
      return false;
    }
    
    public final void bC(String paramString, int paramInt)
    {
      GMTrace.i(18976105037824L, 141383);
      v.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
      GMTrace.o(18976105037824L, 141383);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/secinforeport/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */