package com.tencent.mm.ah.a.f;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.d;

public final class a
  implements Runnable
{
  private final com.tencent.mm.ah.a.a.b hHO;
  private final com.tencent.mm.ah.a.b hIZ;
  private final com.tencent.mm.ah.a.a.c hIg;
  private final com.tencent.mm.ah.a.c.a hIi;
  private final com.tencent.mm.ah.a.c.b hIj;
  private final com.tencent.mm.ah.a.c.c hJa;
  private final String url;
  
  public a(String paramString, com.tencent.mm.ah.a.a.c paramc, com.tencent.mm.ah.a.b paramb, com.tencent.mm.ah.a.c.c paramc1)
  {
    GMTrace.i(13733560582144L, 102323);
    this.url = paramString;
    this.hIZ = paramb;
    this.hHO = this.hIZ.hHO;
    if (paramc == null)
    {
      this.hIg = this.hHO.hIg;
      this.hJa = paramc1;
      if (this.hIg.hIj == null) {
        break label103;
      }
    }
    label103:
    for (this.hIj = this.hIg.hIj;; this.hIj = this.hHO.hIj)
    {
      this.hIi = this.hHO.hIi;
      GMTrace.o(13733560582144L, 102323);
      return;
      this.hIg = paramc;
      break;
    }
  }
  
  public final void run()
  {
    GMTrace.i(13733694799872L, 102324);
    new com.tencent.mm.ah.a.d.b();
    com.tencent.mm.ah.a.d.b localb = this.hIj.jJ(this.url);
    if (localb == null)
    {
      this.hJa.a(false, this.hIg.hIU);
      GMTrace.o(13733694799872L, 102324);
      return;
    }
    if (((d.decodeByteArray(localb.data, 10, 10) != null) || (!this.hIg.hIT)) && (this.hIi.a(this.url, localb.data, this.hIg)))
    {
      if (this.hJa != null)
      {
        this.hJa.a(true, this.hIg.hIU);
        GMTrace.o(13733694799872L, 102324);
      }
    }
    else if (this.hJa != null) {
      this.hJa.a(false, this.hIg.hIU);
    }
    GMTrace.o(13733694799872L, 102324);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/a/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */