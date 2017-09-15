package com.tencent.mm.u;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.as;

public final class h
{
  public static int xI()
  {
    GMTrace.i(616730460160L, 4595);
    if (!com.tencent.mm.kernel.h.vG().uV())
    {
      v.w("MicroMsg.BottleConversationLogic", "get Bottle Total Conversation Unread, but has not set uin");
      GMTrace.o(616730460160L, 4595);
      return 0;
    }
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().bLC();
    if ((localCursor != null) && (localCursor.getCount() > 0)) {
      localCursor.moveToFirst();
    }
    for (int i = localCursor.getInt(0);; i = 0)
    {
      if (localCursor != null) {
        localCursor.close();
      }
      GMTrace.o(616730460160L, 4595);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */