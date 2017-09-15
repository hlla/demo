package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.v;

public class d
{
  protected String appId;
  protected Context context;
  protected a jNr;
  protected String openId;
  
  public d(Context paramContext, String paramString1, String paramString2, a parama)
  {
    GMTrace.i(12839133642752L, 95659);
    this.context = paramContext;
    this.appId = paramString1;
    this.openId = paramString2;
    this.jNr = parama;
    GMTrace.o(12839133642752L, 95659);
  }
  
  protected void Nk()
  {
    GMTrace.i(12839402078208L, 95661);
    com.tencent.mm.ui.base.g.b(this.context, R.l.eFf, R.l.dIG, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(12830006837248L, 95591);
        paramAnonymousDialogInterface = l.a.szQ;
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.I(d.this.openId, com.tencent.mm.u.m.xO(), d.this.appId);
        }
        d.this.jNr.cP(true);
        GMTrace.o(12830006837248L, 95591);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(12839670513664L, 95663);
        paramAnonymousDialogInterface = l.a.szQ;
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.I(d.this.openId, com.tencent.mm.u.m.xO(), d.this.appId);
        }
        d.this.jNr.cP(false);
        GMTrace.o(12839670513664L, 95663);
      }
    });
    GMTrace.o(12839402078208L, 95661);
  }
  
  public final void acB()
  {
    GMTrace.i(12839267860480L, 95660);
    if ((this.openId == null) || (this.openId.length() == 0))
    {
      v.w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
      this.jNr.cP(true);
      GMTrace.o(12839267860480L, 95660);
      return;
    }
    f localf = com.tencent.mm.pluginsdk.model.app.g.aJ(this.appId, false);
    if (localf == null)
    {
      v.e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
      this.jNr.cP(true);
      GMTrace.o(12839267860480L, 95660);
      return;
    }
    if (u.mA(localf.field_openId))
    {
      v.w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
      v.d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
      an.aRl().Jj(this.appId);
      this.jNr.cP(true);
      GMTrace.o(12839267860480L, 95660);
      return;
    }
    if (this.openId.equalsIgnoreCase(localf.field_openId))
    {
      v.d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
      this.jNr.cP(true);
      GMTrace.o(12839267860480L, 95660);
      return;
    }
    v.w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.openId + ", localOpenId = " + localf.field_openId);
    Nk();
    GMTrace.o(12839267860480L, 95660);
  }
  
  public static abstract interface a
  {
    public abstract void cP(boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/base/stub/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */