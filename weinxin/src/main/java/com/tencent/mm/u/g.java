package com.tencent.mm.u;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.n;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import junit.framework.Assert;

public final class g
{
  public static int a(String paramString, final long paramLong, ay.a parama)
  {
    GMTrace.i(649748021248L, 4841);
    v.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.kernel.h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(641023868928L, 4776);
        Cursor localCursor = ((n)com.tencent.mm.kernel.h.h(n.class)).wU().af(this.gTs, paramLong);
        if (localCursor.moveToFirst()) {
          while ((!localCursor.isAfterLast()) && ((this.hkT == null) || (!this.hkT.zs())))
          {
            au localau = new au();
            localau.b(localCursor);
            ay.j(localau);
            localCursor.moveToNext();
          }
        }
        localCursor.close();
        ((n)com.tencent.mm.kernel.h.h(n.class)).wU().ae(this.gTs, paramLong);
        com.tencent.mm.sdk.platformtools.ae.v(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(614985629696L, 4582);
            if (g.1.this.hkT != null) {
              g.1.this.hkT.zr();
            }
            GMTrace.o(614985629696L, 4582);
          }
        });
        GMTrace.o(641023868928L, 4776);
      }
      
      public final String toString()
      {
        GMTrace.i(641158086656L, 4777);
        String str = super.toString() + "|deleteMsgByTalker";
        GMTrace.o(641158086656L, 4777);
        return str;
      }
    });
    GMTrace.o(649748021248L, 4841);
    return 0;
  }
  
  public static void eq(String paramString)
  {
    GMTrace.i(649613803520L, 4840);
    if (!bf.mA(paramString)) {}
    Object localObject;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString);
      if ((localObject != null) && (!bf.mA(((af)localObject).field_username))) {
        break;
      }
      GMTrace.o(649613803520L, 4840);
      return;
    }
    ((x)localObject).setType(((af)localObject).field_type | 0x800);
    o.t((x)localObject);
    if ((((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rl(paramString) == null) && (((x)localObject).bKU()))
    {
      if (!e.hY(paramString)) {
        break label273;
      }
      if (((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rl("officialaccounts") == null)
      {
        localObject = new com.tencent.mm.storage.ae("officialaccounts");
        ((com.tencent.mm.storage.ae)localObject).bLr();
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().d((com.tencent.mm.storage.ae)localObject);
      }
      localObject = new com.tencent.mm.storage.ae(paramString);
      ((com.tencent.mm.storage.ae)localObject).s(System.currentTimeMillis());
      ((com.tencent.mm.storage.ae)localObject).cw("officialaccounts");
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().d((com.tencent.mm.storage.ae)localObject);
    }
    for (;;)
    {
      v.i("MicroMsg.BizConversationLogic", "setPlacedTop username = " + paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rq(paramString);
      GMTrace.o(649613803520L, 4840);
      return;
      label273:
      if ((e.ia(paramString)) && (!e.dr(paramString)))
      {
        localObject = e.hW(paramString);
        if (((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rl(((BizInfo)localObject).field_enterpriseFather) == null)
        {
          localae = new com.tencent.mm.storage.ae(((BizInfo)localObject).field_enterpriseFather);
          localae.bLr();
          ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().d(localae);
        }
        com.tencent.mm.storage.ae localae = new com.tencent.mm.storage.ae(paramString);
        localae.s(System.currentTimeMillis());
        localae.cw(((BizInfo)localObject).CO());
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().d(localae);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */