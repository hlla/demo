package com.tencent.mm.y;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.c.a;
import com.tencent.mm.protocal.k.d;

public abstract class i
  implements com.tencent.mm.network.p
{
  private k.d hsi;
  public boolean hsj;
  
  public i()
  {
    GMTrace.i(13424859807744L, 100023);
    this.hsj = false;
    GMTrace.o(13424859807744L, 100023);
  }
  
  public int BD()
  {
    GMTrace.i(13425262460928L, 100026);
    GMTrace.o(13425262460928L, 100026);
    return 0;
  }
  
  public final k.d BG()
  {
    GMTrace.i(13424994025472L, 100024);
    if (this.hsi == null)
    {
      this.hsi = zf();
      locald = this.hsi;
      locald.sXP = com.tencent.mm.compatible.d.p.rB();
      locald.sXO = d.DEVICE_TYPE;
      locald.sXN = d.sXh;
      locald.dj(i.c.a.sXC.zd());
    }
    k.d locald = this.hsi;
    GMTrace.o(13424994025472L, 100024);
    return locald;
  }
  
  public final boolean BH()
  {
    GMTrace.i(13425396678656L, 100027);
    boolean bool = this.hsj;
    GMTrace.o(13425396678656L, 100027);
    return bool;
  }
  
  public abstract k.d zf();
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/y/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */