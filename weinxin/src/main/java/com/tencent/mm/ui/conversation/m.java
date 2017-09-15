package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.gc;
import com.tencent.mm.e.a.iq;
import com.tencent.mm.e.a.kd;
import com.tencent.mm.e.a.lo;
import com.tencent.mm.e.a.mc;
import com.tencent.mm.e.a.mt;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.pluginsdk.l.m;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.y.n;

public final class m
  implements l.m
{
  public Activity fOZ;
  c kHQ;
  public MessageQueue.IdleHandler uOM;
  Runnable vTM;
  public g vZM;
  public ListView vZj;
  c wcv;
  c wcw;
  
  public m()
  {
    GMTrace.i(14491890745344L, 107973);
    this.kHQ = null;
    this.wcv = null;
    this.wcw = null;
    this.vTM = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(14491219656704L, 107968);
        m localm = m.this;
        LauncherUI localLauncherUI = (LauncherUI)localm.fOZ;
        if ((localLauncherUI == null) || (localLauncherUI.uPX.lBf == 0))
        {
          BackwardSupportUtil.c.a(localm.vZj);
          new ad().postDelayed(new m.3(localm), 300L);
        }
        GMTrace.o(14491219656704L, 107968);
      }
    };
    GMTrace.o(14491890745344L, 107973);
  }
  
  public final void B(String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(14492024963072L, 107974);
    if (this.vZM != null) {
      this.vZM.notifyDataSetChanged();
    }
    GMTrace.o(14492024963072L, 107974);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */