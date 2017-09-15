package com.tencent.mm.ap;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;

public final class q
  extends com.tencent.mm.sdk.b.c<lc>
{
  private static long gKk;
  
  static
  {
    GMTrace.i(12943286599680L, 96435);
    gKk = 86400000L;
    GMTrace.o(12943286599680L, 96435);
  }
  
  public q()
  {
    GMTrace.i(12942749728768L, 96431);
    this.uqt = lc.class.getName().hashCode();
    GMTrace.o(12942749728768L, 96431);
  }
  
  private static boolean Ia()
  {
    GMTrace.i(12942883946496L, 96432);
    v.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + qf());
    if (qf()) {
      c.HW().update();
    }
    GMTrace.o(12942883946496L, 96432);
    return false;
  }
  
  private static boolean qf()
  {
    GMTrace.i(12943018164224L, 96433);
    if (bf.az(Long.valueOf(bf.c((Long)h.vI().vr().get(81938, null))).longValue()) * 1000L > gKk)
    {
      GMTrace.o(12943018164224L, 96433);
      return true;
    }
    GMTrace.o(12943018164224L, 96433);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */