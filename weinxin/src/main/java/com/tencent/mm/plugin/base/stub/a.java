package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;

public final class a
  extends d
{
  public a(Context paramContext, String paramString1, String paramString2, d.a parama)
  {
    super(paramContext, paramString1, paramString2, parama);
    GMTrace.i(12839804731392L, 95664);
    GMTrace.o(12839804731392L, 95664);
  }
  
  protected final void Nk()
  {
    GMTrace.i(12839938949120L, 95665);
    g.a(this.context, R.l.epg, R.l.dIG, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(12830543708160L, 95595);
        paramAnonymousDialogInterface = l.a.szQ;
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.I(a.this.openId, m.xO(), a.this.appId);
        }
        a.this.jNr.cP(false);
        GMTrace.o(12830543708160L, 95595);
      }
    });
    GMTrace.o(12839938949120L, 95665);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/base/stub/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */