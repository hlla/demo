package com.tencent.mm.kernel.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.i;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.g;
import java.util.ArrayList;

public abstract class e
  implements b
{
  public final ArrayList<String> gZj;
  
  public e()
  {
    GMTrace.i(18790750355456L, 140002);
    this.gZj = new ArrayList();
    GMTrace.o(18790750355456L, 140002);
  }
  
  public static void f(Class<? extends com.tencent.mm.kernel.b.d> paramClass)
  {
    GMTrace.i(18791287226368L, 140006);
    i.vN();
    i.vE().f(paramClass);
    GMTrace.o(18791287226368L, 140006);
  }
  
  public void a(com.tencent.mm.kernel.b.e parame, com.tencent.mm.vending.g.c<Void> paramc, com.tencent.mm.vending.h.d paramd)
  {
    GMTrace.i(18791689879552L, 140009);
    GMTrace.o(18791689879552L, 140009);
  }
  
  public void a(final com.tencent.mm.kernel.b.e parame, final com.tencent.mm.vending.h.d paramd, d.b paramb)
  {
    GMTrace.i(18791824097280L, 140010);
    final long l = a.timestamp();
    a.a("boot start to execute task on scheduler [%s]...", new Object[] { paramd.getType() });
    final com.tencent.mm.vending.g.c localc = g.cbz().lS(true);
    if (!of())
    {
      this.gZj.clear();
      a.a("This process(%s) will not install any pending plugin", new Object[] { parame.gWE });
    }
    for (;;)
    {
      localc.d(new com.tencent.mm.vending.c.a() {});
      GMTrace.o(18791824097280L, 140010);
      return;
      a(parame, localc, paramd);
    }
  }
  
  public final void c(com.tencent.mm.kernel.b.e parame)
  {
    GMTrace.i(18791153008640L, 140005);
    i.vN();
    i.vE().a(parame);
    GMTrace.o(18791153008640L, 140005);
  }
  
  public final void ei(String paramString)
  {
    GMTrace.i(18791421444096L, 140007);
    if (!this.gZj.contains(paramString)) {
      this.gZj.add(paramString);
    }
    GMTrace.o(18791421444096L, 140007);
  }
  
  public void od()
  {
    GMTrace.i(18790884573184L, 140003);
    GMTrace.o(18790884573184L, 140003);
  }
  
  public boolean of()
  {
    GMTrace.i(18791555661824L, 140008);
    GMTrace.o(18791555661824L, 140008);
    return true;
  }
  
  public final void vO()
  {
    GMTrace.i(18791018790912L, 140004);
    i.vN();
    i.vE().vi();
    GMTrace.o(18791018790912L, 140004);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kernel/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */