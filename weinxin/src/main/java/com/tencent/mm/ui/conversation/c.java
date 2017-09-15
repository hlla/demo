package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.ba;
import com.tencent.mm.e.a.is;
import com.tencent.mm.e.a.md;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public Activity activity;
  HashMap<String, Integer> vZJ;
  int vZK;
  public int vZL;
  public g vZM;
  com.tencent.mm.sdk.b.c vZN;
  com.tencent.mm.sdk.b.c vZO;
  com.tencent.mm.sdk.b.c vZP;
  public ListView vZj;
  
  public c()
  {
    GMTrace.i(14515781500928L, 108151);
    this.vZJ = new HashMap();
    this.vZK = -1;
    this.vZL = -1;
    this.vZN = new com.tencent.mm.sdk.b.c() {};
    this.vZO = new com.tencent.mm.sdk.b.c() {};
    this.vZP = new com.tencent.mm.sdk.b.c()
    {
      private final long INTERVAL;
      public long vZS;
      public int vZT;
    };
    GMTrace.o(14515781500928L, 108151);
  }
  
  final ae TT(String paramString)
  {
    GMTrace.i(14516184154112L, 108154);
    if (this.vZM != null)
    {
      paramString = (ae)this.vZM.bC(paramString);
      GMTrace.o(14516184154112L, 108154);
      return paramString;
    }
    GMTrace.o(14516184154112L, 108154);
    return null;
  }
  
  public final void ae(Activity paramActivity)
  {
    GMTrace.i(14515915718656L, 108152);
    this.vZL = ((LauncherUI)paramActivity).uPX.bPr();
    GMTrace.o(14515915718656L, 108152);
  }
  
  public final void bYl()
  {
    GMTrace.i(14516049936384L, 108153);
    if (this.activity == null)
    {
      GMTrace.o(14516049936384L, 108153);
      return;
    }
    long l = System.currentTimeMillis();
    LauncherUI localLauncherUI = (LauncherUI)this.activity;
    v.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  resetStatus %d", new Object[] { Integer.valueOf(this.vZK) });
    switch (this.vZK)
    {
    default: 
      this.vZL = localLauncherUI.uPX.bPr();
      v.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_ALL totalUnReadCount %d, usetime %d,", new Object[] { Integer.valueOf(this.vZL), Long.valueOf(System.currentTimeMillis() - l) });
      GMTrace.o(14516049936384L, 108153);
      return;
    case 2: 
      Iterator localIterator = this.vZJ.entrySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        int j = ((Integer)((Map.Entry)localObject).getValue()).intValue();
        v.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s, preunread %d", new Object[] { str, Integer.valueOf(j) });
        localObject = TT(str);
        if ((localObject == null) || (y.bQw().contains(str)))
        {
          j = 0 - j;
          v.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov == null username %s, change %d", new Object[] { str, Integer.valueOf(j) });
          label277:
          if ((j != 0) && (this.vZM.TU(str)))
          {
            v.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s isWithoutItemCache", new Object[] { str });
            ap.yY();
            localObject = com.tencent.mm.u.c.wR().Rb(str);
            if (localObject == null) {
              continue;
            }
            if (!o.dH(str)) {
              break label419;
            }
            if (((af)localObject).gkp == 0) {
              continue;
            }
          }
        }
        for (;;)
        {
          i += j;
          v.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  real change usename %s, change %d, totalchange %d", new Object[] { str, Integer.valueOf(j), Integer.valueOf(i) });
          break;
          j = ((aj)localObject).field_unReadCount - j + 0;
          v.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov != null username %s, change %d", new Object[] { str, Integer.valueOf(j) });
          break label277;
          label419:
          if (((x)localObject).tD()) {
            break;
          }
        }
      }
      this.vZL += i;
      localLauncherUI.uPX.yY(this.vZL);
      v.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_PART totalUnReadCount %d, change %d, usetime %d,", new Object[] { Integer.valueOf(this.vZL), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      GMTrace.o(14516049936384L, 108153);
      return;
    }
    GMTrace.o(14516049936384L, 108153);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */