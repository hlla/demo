package com.tencent.mm.u.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import java.util.HashMap;

public class g
  implements am
{
  private c hon;
  
  public g()
  {
    GMTrace.i(690952863744L, 5148);
    this.hon = null;
    GMTrace.o(690952863744L, 5148);
  }
  
  private static g Ad()
  {
    GMTrace.i(691087081472L, 5149);
    g localg = (g)l.o(g.class);
    GMTrace.o(691087081472L, 5149);
    return localg;
  }
  
  public static c Ae()
  {
    GMTrace.i(691892387840L, 5155);
    h.vG().uQ();
    if (Ad().hon == null) {
      Ad().hon = new c();
    }
    c localc = Ad().hon;
    GMTrace.o(691892387840L, 5155);
    return localc;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(691489734656L, 5152);
    c localc = Ae();
    long l = System.currentTimeMillis();
    try
    {
      localc.gv((String)h.vI().vr().get(328193, null));
      if (localc.Ac()) {
        f.gx(localc.hoh.hod);
      }
      v.i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      GMTrace.o(691489734656L, 5152);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { localException.toString() });
      }
    }
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(691623952384L, 5153);
    GMTrace.o(691623952384L, 5153);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(691355516928L, 5151);
    GMTrace.o(691355516928L, 5151);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(691758170112L, 5154);
    c localc = Ae();
    localc.hoi = null;
    localc.hoh = null;
    GMTrace.o(691758170112L, 5154);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(691221299200L, 5150);
    GMTrace.o(691221299200L, 5150);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */