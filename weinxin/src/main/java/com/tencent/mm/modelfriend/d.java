package com.tencent.mm.modelfriend;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ao.n;
import com.tencent.mm.e.a.af;
import com.tencent.mm.e.a.af.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;

final class d
  extends com.tencent.mm.sdk.b.c<af>
{
  d()
  {
    GMTrace.i(4415763251200L, 32900);
    this.uqt = af.class.getName().hashCode();
    GMTrace.o(4415763251200L, 32900);
  }
  
  private static boolean a(af paramaf)
  {
    GMTrace.i(4415897468928L, 32901);
    if (paramaf.fDe.fDg == 0) {}
    try
    {
      int i = m.xW() | 0x1000;
      ap.yY();
      com.tencent.mm.u.c.vr().set(34, Integer.valueOf(i));
      ap.yY();
      com.tencent.mm.u.c.wQ().b(new n("", "", "", "", "", "", "", "", i, "", ""));
      v.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
      GMTrace.o(4415897468928L, 32901);
      return false;
    }
    catch (Exception paramaf)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", paramaf, "", new Object[0]);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */