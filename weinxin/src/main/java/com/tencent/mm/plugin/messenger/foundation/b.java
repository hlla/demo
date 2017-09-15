package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.na;
import com.tencent.mm.storage.as;

public final class b
  implements p
{
  public b()
  {
    GMTrace.i(13231317843968L, 98581);
    GMTrace.o(13231317843968L, 98581);
  }
  
  public final void a(lt paramlt, byte[] paramArrayOfByte, boolean paramBoolean, r paramr)
  {
    GMTrace.i(13231452061696L, 98582);
    switch (paramlt.tqs)
    {
    }
    for (;;)
    {
      GMTrace.o(13231452061696L, 98582);
      return;
      paramlt = (na)new na().aD(paramArrayOfByte);
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rk(n.a(paramlt.trH));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/messenger/foundation/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */