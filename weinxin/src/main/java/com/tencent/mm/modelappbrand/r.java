package com.tencent.mm.modelappbrand;

import com.tencent.gmtrace.GMTrace;

public final class r
  implements q
{
  private f hpH;
  private o hpI;
  
  public r(f paramf)
  {
    GMTrace.i(18934631759872L, 141074);
    this.hpH = paramf;
    GMTrace.o(18934631759872L, 141074);
  }
  
  public r(f paramf, o paramo)
  {
    GMTrace.i(18934765977600L, 141075);
    this.hpH = paramf;
    this.hpI = paramo;
    GMTrace.o(18934765977600L, 141075);
  }
  
  public r(q paramq)
  {
    GMTrace.i(18934900195328L, 141076);
    if (paramq == null)
    {
      GMTrace.o(18934900195328L, 141076);
      return;
    }
    this.hpH = paramq.AV();
    this.hpI = paramq.AW();
    GMTrace.o(18934900195328L, 141076);
  }
  
  public final f AV()
  {
    GMTrace.i(18935034413056L, 141077);
    f localf = this.hpH;
    GMTrace.o(18935034413056L, 141077);
    return localf;
  }
  
  public final o AW()
  {
    GMTrace.i(18935168630784L, 141078);
    o localo = this.hpI;
    GMTrace.o(18935168630784L, 141078);
    return localo;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelappbrand/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */