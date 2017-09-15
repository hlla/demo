package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;

public class AppInstallerUI
  extends MMBaseActivity
{
  private static AppInstallerUI uoq;
  private String desc;
  private String fFN;
  private h oGr;
  private int qtT;
  private h uop;
  private DialogInterface.OnClickListener uor;
  
  static
  {
    GMTrace.i(3590726877184L, 26753);
    uoq = null;
    GMTrace.o(3590726877184L, 26753);
  }
  
  public AppInstallerUI()
  {
    GMTrace.i(3589384699904L, 26743);
    this.oGr = null;
    this.uop = null;
    this.uor = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(3560527888384L, 26528);
        v.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
        if (AppInstallerUI.b(AppInstallerUI.this) == 2) {
          i.Y(AppInstallerUI.this, 3);
        }
        paramAnonymousDialogInterface = com.tencent.mm.sandbox.monitor.c.DC(AppInstallerUI.c(AppInstallerUI.this));
        v.d("MicroMsg.AppInstallerUI", paramAnonymousDialogInterface);
        if (paramAnonymousDialogInterface != null)
        {
          j.a.upU.ad(1, true);
          com.tencent.mm.plugin.report.service.g.oSF.a(405L, 72L, 1L, true);
          AppInstallerUI.a(AppInstallerUI.this, paramAnonymousDialogInterface);
          GMTrace.o(3560527888384L, 26528);
          return;
        }
        com.tencent.mm.plugin.report.service.g.oSF.a(405L, 73L, 1L, true);
        v.e("MicroMsg.AppInstallerUI", "pack not found!");
        com.tencent.mm.ui.base.g.bk(AppInstallerUI.this, AppInstallerUI.this.getString(R.l.eYK));
        i.bHX();
        AppInstallerUI.this.finish();
        GMTrace.o(3560527888384L, 26528);
      }
    };
    GMTrace.o(3589384699904L, 26743);
  }
  
  public static AppInstallerUI bHE()
  {
    GMTrace.i(3589518917632L, 26744);
    AppInstallerUI localAppInstallerUI = uoq;
    GMTrace.o(3589518917632L, 26744);
    return localAppInstallerUI;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3589653135360L, 26745);
    super.onCreate(paramBundle);
    v.d("MicroMsg.AppInstallerUI", "onCreate");
    com.tencent.mm.sandbox.c.f(hashCode(), this);
    MMActivity.et(this);
    if ((AppUpdaterUI.bHF() != null) && (!AppUpdaterUI.bHF().isFinishing()))
    {
      v.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
      finish();
      GMTrace.o(3589653135360L, 26745);
      return;
    }
    if ((uoq != null) && (!uoq.isFinishing()) && (uoq != this))
    {
      v.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
      finish();
      GMTrace.o(3589653135360L, 26745);
      return;
    }
    uoq = this;
    this.fFN = i.Nv();
    if ((bf.mA(this.fFN)) || (com.tencent.mm.sandbox.monitor.c.DC(this.fFN) == null))
    {
      finish();
      GMTrace.o(3589653135360L, 26745);
      return;
    }
    this.desc = i.bHP();
    this.qtT = i.bHQ();
    setContentView(R.i.empty);
    paramBundle = new h.a(this);
    paramBundle.zR(R.l.elT);
    paramBundle.kH(true);
    paramBundle.d(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(3573412790272L, 26624);
        AppInstallerUI.a(AppInstallerUI.this);
        GMTrace.o(3573412790272L, 26624);
      }
    });
    paramBundle.SW(getString(R.l.elW, new Object[] { this.desc }));
    paramBundle.zU(R.l.esw).a(false, this.uor);
    paramBundle.zV(R.l.eYI).b(null);
    this.oGr = paramBundle.WD();
    this.oGr.setCanceledOnTouchOutside(false);
    this.oGr.show();
    com.tencent.mm.plugin.report.service.g.oSF.a(405L, 71L, 1L, true);
    if (this.qtT == 2) {
      i.f(this, 2, i.bHR() + 1);
    }
    GMTrace.o(3589653135360L, 26745);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(3589787353088L, 26746);
    v.d("MicroMsg.AppInstallerUI", "onDestroy");
    if ((this.oGr != null) && (this.oGr.isShowing())) {
      this.oGr.dismiss();
    }
    if ((this.uop != null) && (this.uop.isShowing())) {
      this.uop.dismiss();
    }
    if (uoq == this) {
      uoq = null;
    }
    com.tencent.mm.sandbox.c.g(hashCode(), this);
    super.onDestroy();
    GMTrace.o(3589787353088L, 26746);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/updater/AppInstallerUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */