package com.tencent.mm.ui;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import java.util.ArrayList;
import java.util.List;

public final class y
{
  public static List<String> bQw()
  {
    GMTrace.i(2940576202752L, 21909);
    int i = m.xP();
    ArrayList localArrayList = new ArrayList();
    if ((i & 0x8000) == 0)
    {
      localArrayList.add("floatbottle");
      v.d("MicroMsg.LauncherUI", "add bottle into show unread count blacklist.");
    }
    ap.yY();
    if (!c.vr().c(w.a.uCW, true))
    {
      localArrayList.add("notifymessage");
      v.d("MicroMsg.UnreadCountHelper", "add service notify message into show unread count blacklist.");
    }
    ap.yY();
    if (!c.vr().c(w.a.uCX, true))
    {
      localArrayList.add("appbrandcustomerservicemsg");
      v.d("MicroMsg.UnreadCountHelper", "add wxa custom session notify message into show unread count blacklist.");
    }
    v.d("MicroMsg.LauncherUI", "getShowUnreadCountBlacklist unread count blacklist(size : %s).", new Object[] { Integer.valueOf(localArrayList.size()) });
    GMTrace.o(2940576202752L, 21909);
    return localArrayList;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */