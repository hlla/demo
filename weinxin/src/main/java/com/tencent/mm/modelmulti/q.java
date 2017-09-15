package com.tencent.mm.modelmulti;

import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.am;
import com.tencent.mm.u.bn;
import com.tencent.mm.u.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class q
  implements am
{
  private b hLU;
  
  public q()
  {
    GMTrace.i(401982095360L, 2995);
    GMTrace.o(401982095360L, 2995);
  }
  
  public static b HA()
  {
    GMTrace.i(402787401728L, 3001);
    h.vG().uQ();
    if (HB().hLU == null) {
      HB().hLU = new b();
    }
    b localb = HB().hLU;
    GMTrace.o(402787401728L, 3001);
    return localb;
  }
  
  private static q HB()
  {
    GMTrace.i(402921619456L, 3002);
    q localq2 = (q)com.tencent.mm.u.ap.yR().gs(q.class.getName());
    q localq1 = localq2;
    if (localq2 == null)
    {
      localq1 = new q();
      com.tencent.mm.u.ap.yR().a(q.class.getName(), localq1);
    }
    GMTrace.o(402921619456L, 3002);
    return localq1;
  }
  
  public static r Hz()
  {
    GMTrace.i(402653184000L, 3000);
    r localr = ((com.tencent.mm.plugin.zero.b.b)h.h(com.tencent.mm.plugin.zero.b.b.class)).Hz();
    GMTrace.o(402653184000L, 3000);
    return localr;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(402518966272L, 2999);
    b localb = HB().hLU;
    if (localb != null)
    {
      com.tencent.mm.u.ap.yY().xD().a(localb, com.tencent.mm.u.ap.vL().nIe.getLooper());
      com.tencent.mm.u.ap.vL().D(new b.1(localb));
    }
    GMTrace.o(402518966272L, 2999);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(402384748544L, 2998);
    GMTrace.o(402384748544L, 2998);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(402250530816L, 2997);
    GMTrace.o(402250530816L, 2997);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(403055837184L, 3003);
    b localb = HB().hLU;
    if (localb != null)
    {
      v.i("MicroMsg.GetChatRoomMsgService", "clear clearList.size:%d needGetInfosMap.size:%d respList.size:%d, currentListener:%s", new Object[] { Integer.valueOf(localb.hJs.size()), Integer.valueOf(localb.hJr.size()), Integer.valueOf(localb.hDp.size()), localb.hJt });
      localb.hDt.KI();
      localb.hDu.KI();
      localb.hJs.clear();
      localb.hJr.clear();
      localb.hDp.clear();
      localb.hJt = null;
      localb.hqr = false;
      com.tencent.mm.u.ap.yY().xD().f(localb);
    }
    GMTrace.o(403055837184L, 3003);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(402116313088L, 2996);
    GMTrace.o(402116313088L, 2996);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */