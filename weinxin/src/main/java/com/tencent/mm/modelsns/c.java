package com.tencent.mm.modelsns;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class c
{
  public static int hTl;
  public static c hTm;
  
  static
  {
    GMTrace.i(4458444488704L, 33218);
    hTl = 0;
    hTm = new c();
    GMTrace.o(4458444488704L, 33218);
  }
  
  public c()
  {
    GMTrace.i(4458176053248L, 33216);
    GMTrace.o(4458176053248L, 33216);
  }
  
  public static void JG()
  {
    GMTrace.i(4458310270976L, 33217);
    com.tencent.mm.storage.c localc = com.tencent.mm.u.c.c.Az().dX("100024");
    v.i("MicroMsg.StatisticsOplogAbTest", "test " + localc.field_rawXML + " " + localc.isValid());
    if (localc.isValid())
    {
      hTl = bf.PX((String)localc.bKA().get("Switch"));
      v.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + hTl);
    }
    GMTrace.o(4458310270976L, 33217);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsns/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */