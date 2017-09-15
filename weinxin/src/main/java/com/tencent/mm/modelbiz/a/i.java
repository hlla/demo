package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.u.af;

public final class i
{
  public i()
  {
    GMTrace.i(4580985274368L, 34131);
    GMTrace.o(4580985274368L, 34131);
  }
  
  private static void aa(String paramString1, String paramString2)
  {
    GMTrace.i(4581253709824L, 34133);
    long l = e.iz(paramString1);
    if (l == -1L)
    {
      v.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", new Object[] { paramString1 });
      GMTrace.o(4581253709824L, 34133);
      return;
    }
    int i = w.DK().U(l).field_newUnReadCount;
    w.DK().W(l);
    paramString1 = w.DJ().aa(l);
    ae localae = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rl(paramString2);
    if (localae == null)
    {
      v.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", new Object[] { paramString2 });
      GMTrace.o(4581253709824L, 34133);
      return;
    }
    if (paramString1.fu(1))
    {
      if (localae.field_unReadMuteCount <= i)
      {
        localae.dA(0);
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().a(localae, paramString2);
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
        GMTrace.o(4581253709824L, 34133);
        return;
      }
      localae.dA(localae.field_unReadMuteCount - i);
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().a(localae, paramString2);
      GMTrace.o(4581253709824L, 34133);
      return;
    }
    if (localae.field_unReadCount <= i)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rn(paramString2);
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(paramString2);
      GMTrace.o(4581253709824L, 34133);
      return;
    }
    localae.dz(0);
    localae.dt(localae.field_unReadCount - i);
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().a(localae, paramString2);
    GMTrace.o(4581253709824L, 34133);
  }
  
  public static void f(int paramInt, String paramString1, String paramString2)
  {
    GMTrace.i(4581119492096L, 34132);
    if (!"EnterpriseChatStatus".equals(paramString1))
    {
      GMTrace.o(4581119492096L, 34132);
      return;
    }
    paramString1 = paramString2.split(";");
    paramString2 = paramString1[0];
    String str = paramString1[1];
    bf.getInt(paramString1[2], 0);
    if (paramInt == 7)
    {
      aa(str, paramString2);
      GMTrace.o(4581119492096L, 34132);
      return;
    }
    if (paramInt == 8)
    {
      aa(str, paramString2);
      GMTrace.o(4581119492096L, 34132);
      return;
    }
    if (paramInt == 9) {
      aa(str, paramString2);
    }
    GMTrace.o(4581119492096L, 34132);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */