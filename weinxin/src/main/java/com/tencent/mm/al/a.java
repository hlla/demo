package com.tencent.mm.al;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.s;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;

public final class a
{
  public static boolean HE()
  {
    GMTrace.i(4502333685760L, 33545);
    if ((l.a.szS != null) && (l.a.szS.aGn()))
    {
      GMTrace.o(4502333685760L, 33545);
      return true;
    }
    GMTrace.o(4502333685760L, 33545);
    return false;
  }
  
  public static h a(Context paramContext, int paramInt, Runnable paramRunnable)
  {
    GMTrace.i(4502467903488L, 33546);
    paramContext = new h.a(paramContext);
    paramContext.zR(R.l.dIG);
    paramContext.zS(paramInt);
    paramContext.zU(R.l.eBS).a(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(4503004774400L, 33550);
        if (this.hMB != null) {
          this.hMB.run();
        }
        GMTrace.o(4503004774400L, 33550);
      }
    });
    paramContext.kH(true);
    paramContext.d(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(4502736338944L, 33548);
        if (this.hMB != null) {
          this.hMB.run();
        }
        GMTrace.o(4502736338944L, 33548);
      }
    });
    paramContext = paramContext.WD();
    paramContext.show();
    GMTrace.o(4502467903488L, 33546);
    return paramContext;
  }
  
  public static boolean aH(Context paramContext)
  {
    GMTrace.i(4501931032576L, 33542);
    boolean bool = com.tencent.mm.n.a.aH(paramContext);
    GMTrace.o(4501931032576L, 33542);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/al/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */