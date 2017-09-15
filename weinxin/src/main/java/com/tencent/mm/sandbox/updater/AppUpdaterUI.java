package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.b.i.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h.a;
import java.util.ArrayList;

public class AppUpdaterUI
  extends MMBaseActivity
{
  private static AppUpdaterUI uov;
  private Button jKX;
  private com.tencent.mm.ui.base.h oGr;
  private DialogInterface.OnClickListener uor;
  private Button uou;
  private j uow;
  private g uox;
  private DialogInterface.OnClickListener uoy;
  
  static
  {
    GMTrace.i(3563078025216L, 26547);
    uov = null;
    GMTrace.o(3563078025216L, 26547);
  }
  
  public AppUpdaterUI()
  {
    GMTrace.i(3560662106112L, 26529);
    this.oGr = null;
    this.uox = new g()
    {
      public final void FU(String paramAnonymousString)
      {
        GMTrace.i(3559856799744L, 26523);
        if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
          AppUpdaterUI.b(AppUpdaterUI.this).dismiss();
        }
        if (AppUpdaterUI.this.isFinishing())
        {
          GMTrace.o(3559856799744L, 26523);
          return;
        }
        v.d("MicroMsg.AppUpdaterUI", paramAnonymousString);
        if (paramAnonymousString != null)
        {
          AppUpdaterUI.a(AppUpdaterUI.this, paramAnonymousString);
          AppUpdaterUI.a(AppUpdaterUI.this).setEnabled(false);
        }
        GMTrace.o(3559856799744L, 26523);
      }
      
      public final void a(com.tencent.mm.sandbox.monitor.c paramAnonymousc)
      {
        GMTrace.i(3559991017472L, 26524);
        if (AppUpdaterUI.this.isFinishing())
        {
          GMTrace.o(3559991017472L, 26524);
          return;
        }
        if ((paramAnonymousc instanceof c))
        {
          com.tencent.mm.plugin.report.service.g.oSF.a(405L, 67L, 1L, true);
          v.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
          if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
            AppUpdaterUI.b(AppUpdaterUI.this).setMessage(AppUpdaterUI.this.getString(R.l.elV, new Object[] { AppUpdaterUI.e(AppUpdaterUI.this).desc, AppUpdaterUI.this.getString(R.l.eYM), bf.ay(AppUpdaterUI.e(AppUpdaterUI.this).size) }));
          }
          if (AppUpdaterUI.e(AppUpdaterUI.this).upI)
          {
            com.tencent.mm.plugin.report.service.g.oSF.a(405L, 68L, 1L, true);
            AppUpdaterUI.a(AppUpdaterUI.this, paramAnonymousc);
          }
          GMTrace.o(3559991017472L, 26524);
          return;
        }
        com.tencent.mm.plugin.report.service.g.oSF.a(405L, 69L, 1L, true);
        com.tencent.mm.ui.base.g.a(AppUpdaterUI.this, R.l.eYN, R.l.dIG, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            GMTrace.i(3586834563072L, 26724);
            v.d("MicroMsg.AppUpdaterUI", "go to WebView");
            paramAnonymous2DialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
            paramAnonymous2DialogInterface.addFlags(268435456);
            AppUpdaterUI.this.startActivity(paramAnonymous2DialogInterface);
            GMTrace.o(3586834563072L, 26724);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            GMTrace.i(3598243069952L, 26809);
            GMTrace.o(3598243069952L, 26809);
          }
        });
        GMTrace.o(3559991017472L, 26524);
      }
      
      public final void bHI()
      {
        GMTrace.i(3559454146560L, 26520);
        v.e("MicroMsg.AppUpdaterUI", "no sdcard.");
        if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
          AppUpdaterUI.b(AppUpdaterUI.this).dismiss();
        }
        if (AppUpdaterUI.this.isFinishing())
        {
          GMTrace.o(3559454146560L, 26520);
          return;
        }
        AppUpdaterUI.c(AppUpdaterUI.this);
        GMTrace.o(3559454146560L, 26520);
      }
      
      public final void bHJ()
      {
        GMTrace.i(3559588364288L, 26521);
        if (AppUpdaterUI.b(AppUpdaterUI.this) != null) {
          AppUpdaterUI.b(AppUpdaterUI.this).dismiss();
        }
        if (AppUpdaterUI.this.isFinishing())
        {
          GMTrace.o(3559588364288L, 26521);
          return;
        }
        AppUpdaterUI.d(AppUpdaterUI.this);
        GMTrace.o(3559588364288L, 26521);
      }
      
      public final void bgf()
      {
        GMTrace.i(3559722582016L, 26522);
        if (AppUpdaterUI.this.isFinishing())
        {
          GMTrace.o(3559722582016L, 26522);
          return;
        }
        AppUpdaterUI.a(AppUpdaterUI.this).setText(R.l.eYP);
        AppUpdaterUI.a(AppUpdaterUI.this).setEnabled(false);
        GMTrace.o(3559722582016L, 26522);
      }
      
      public final void cx(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(3559319928832L, 26519);
        if (paramAnonymousInt1 <= 0) {}
        for (long l = 0L;; l = paramAnonymousInt2 * 100L / paramAnonymousInt1)
        {
          paramAnonymousInt1 = (int)l;
          if (paramAnonymousInt1 != 100) {
            break;
          }
          AppUpdaterUI.a(AppUpdaterUI.this).setText(AppUpdaterUI.this.getString(R.l.eYR));
          GMTrace.o(3559319928832L, 26519);
          return;
        }
        AppUpdaterUI.a(AppUpdaterUI.this).setText(AppUpdaterUI.this.getString(R.l.eYP) + paramAnonymousInt1 + "%");
        GMTrace.o(3559319928832L, 26519);
      }
    };
    this.uoy = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(3581600071680L, 26685);
        AppUpdaterUI.g(AppUpdaterUI.this);
        GMTrace.o(3581600071680L, 26685);
      }
    };
    this.uor = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(3586297692160L, 26720);
        v.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
        if (AppUpdaterUI.e(AppUpdaterUI.this).qtT == 1) {
          i.Y(AppUpdaterUI.this, 6);
        }
        if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted"))
        {
          v.e("MicroMsg.AppUpdaterUI", "no sdcard.");
          AppUpdaterUI.b(AppUpdaterUI.this).dismiss();
          AppUpdaterUI.c(AppUpdaterUI.this);
          GMTrace.o(3586297692160L, 26720);
          return;
        }
        if ((AppUpdaterUI.e(AppUpdaterUI.this).fuP & 0x1) != 0)
        {
          v.e("MicroMsg.AppUpdaterUI", "package has set external update mode");
          paramAnonymousDialogInterface = Uri.parse(AppUpdaterUI.e(AppUpdaterUI.this).fuR);
          Intent localIntent = new Intent("android.intent.action.VIEW", paramAnonymousDialogInterface).addFlags(268435456);
          if ((paramAnonymousDialogInterface == null) || (localIntent == null) || (!bf.j(AppUpdaterUI.this, localIntent)))
          {
            v.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
            paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456);
            AppUpdaterUI.this.startActivity(paramAnonymousDialogInterface);
          }
          for (;;)
          {
            AppUpdaterUI.f(AppUpdaterUI.this);
            GMTrace.o(3586297692160L, 26720);
            return;
            v.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
            AppUpdaterUI.this.startActivity(localIntent);
          }
        }
        paramAnonymousDialogInterface = com.tencent.mm.sandbox.monitor.c.DC(AppUpdaterUI.e(AppUpdaterUI.this).fFN);
        v.d("MicroMsg.AppUpdaterUI", paramAnonymousDialogInterface);
        if (paramAnonymousDialogInterface != null)
        {
          v.i("MicroMsg.AppUpdaterUI", "update package already exist.");
          AppUpdaterUI.a(AppUpdaterUI.this, 8);
          if (AppUpdaterUI.e(AppUpdaterUI.this).upI) {
            AppUpdaterUI.a(AppUpdaterUI.this, 0);
          }
          for (;;)
          {
            AppUpdaterUI.e(AppUpdaterUI.this).ad(1, true);
            AppUpdaterUI.h(AppUpdaterUI.this).FU(paramAnonymousDialogInterface);
            GMTrace.o(3586297692160L, 26720);
            return;
            AppUpdaterUI.a(AppUpdaterUI.this, 9);
          }
        }
        v.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(AppUpdaterUI.this).qtT) });
        v.d("MicroMsg.AppUpdaterUI", "current updateType : %s", new Object[] { Integer.valueOf(AppUpdaterUI.e(AppUpdaterUI.this).uok) });
        if (AppUpdaterUI.e(AppUpdaterUI.this).qtT == 0)
        {
          AppUpdaterUI.e(AppUpdaterUI.this).bHZ();
          GMTrace.o(3586297692160L, 26720);
          return;
        }
        if (AppUpdaterUI.e(AppUpdaterUI.this).qtT == 1)
        {
          v.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
          AppUpdaterUI.f(AppUpdaterUI.this);
          paramAnonymousDialogInterface = new Intent(AppUpdaterUI.this.getIntent());
          paramAnonymousDialogInterface.setClass(AppUpdaterUI.this, UpdaterService.class);
          paramAnonymousDialogInterface.putExtra("intent_extra_run_in_foreground", true);
          AppUpdaterUI.this.startService(paramAnonymousDialogInterface);
          if (AppUpdaterUI.e(AppUpdaterUI.this).upM) {
            com.tencent.mm.plugin.report.service.g.oSF.a(614L, 56L, 1L, false);
          }
          GMTrace.o(3586297692160L, 26720);
          return;
        }
        v.e("MicroMsg.AppUpdaterUI", "silence download never go here!");
        GMTrace.o(3586297692160L, 26720);
      }
    };
    GMTrace.o(3560662106112L, 26529);
  }
  
  public static AppUpdaterUI bHF()
  {
    GMTrace.i(3560796323840L, 26530);
    AppUpdaterUI localAppUpdaterUI = uov;
    GMTrace.o(3560796323840L, 26530);
    return localAppUpdaterUI;
  }
  
  public static void bHG()
  {
    GMTrace.i(3560930541568L, 26531);
    if (uov != null) {
      uov.bHH();
    }
    GMTrace.o(3560930541568L, 26531);
  }
  
  private void bHH()
  {
    GMTrace.i(3561333194752L, 26534);
    if ((this.oGr != null) && (this.oGr.isShowing())) {
      this.oGr.dismiss();
    }
    finish();
    GMTrace.o(3561333194752L, 26534);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3561064759296L, 26532);
    super.onCreate(paramBundle);
    v.d("MicroMsg.AppUpdaterUI", "onCreate");
    com.tencent.mm.sandbox.c.f(hashCode(), this);
    MMActivity.et(this);
    if ((AppInstallerUI.bHE() != null) && (!AppInstallerUI.bHE().isFinishing()))
    {
      v.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
      finish();
      GMTrace.o(3561064759296L, 26532);
      return;
    }
    if ((uov != null) && (!uov.isFinishing()) && (uov != this))
    {
      v.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
      v.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
      finish();
      GMTrace.o(3561064759296L, 26532);
      return;
    }
    uov = this;
    setContentView(R.i.empty);
    this.uow = j.a.upU;
    if (!this.uow.ac(getIntent()))
    {
      v.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
      bHH();
      GMTrace.o(3561064759296L, 26532);
      return;
    }
    if ((this.uow.uok == 999) && (this.uow.uoM != null) && (this.uow.uoM.length > 0))
    {
      v.d("MicroMsg.AppUpdaterUI", "into emergency status");
      new ad().postDelayed(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(3593008578560L, 26770);
          com.tencent.mm.ui.base.g.a(AppUpdaterUI.this, AppUpdaterUI.e(AppUpdaterUI.this).desc, AppUpdaterUI.this.getString(R.l.dIG), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GMTrace.i(3581063200768L, 26681);
              paramAnonymous2DialogInterface = new Intent("android.intent.action.VIEW", Uri.parse(AppUpdaterUI.e(AppUpdaterUI.this).uoM[0]));
              paramAnonymous2DialogInterface.addFlags(268435456);
              aa.getContext().startActivity(paramAnonymous2DialogInterface);
              AppUpdaterUI.f(AppUpdaterUI.this);
              GMTrace.o(3581063200768L, 26681);
            }
          }).setOnCancelListener(new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              GMTrace.i(3564822855680L, 26560);
              AppUpdaterUI.f(AppUpdaterUI.this);
              GMTrace.o(3564822855680L, 26560);
            }
          });
          GMTrace.o(3593008578560L, 26770);
        }
      }, 100L);
      GMTrace.o(3561064759296L, 26532);
      return;
    }
    v.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.uow.uoM);
    Object localObject = new h.a(this);
    ((h.a)localObject).zR(R.l.elT);
    ((h.a)localObject).kH(true);
    ((h.a)localObject).d(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(3577841975296L, 26657);
        AppUpdaterUI.g(AppUpdaterUI.this);
        GMTrace.o(3577841975296L, 26657);
      }
    });
    if ((this.uow.upI) && (this.uow.upH != null))
    {
      paramBundle = getString(R.l.elV, new Object[] { this.uow.desc, getString(R.l.eYQ), bf.ay(this.uow.upH.size) });
      if (this.uow.uok == 1) {
        break label593;
      }
    }
    label593:
    for (int i = R.l.eYI;; i = R.l.eYL)
    {
      ((h.a)localObject).SW(paramBundle);
      ((h.a)localObject).zU(R.l.eYU).a(false, this.uor);
      ((h.a)localObject).zV(i);
      this.oGr = ((h.a)localObject).WD();
      this.oGr.setCanceledOnTouchOutside(false);
      this.uou = this.oGr.getButton(-1);
      this.jKX = this.oGr.getButton(-2);
      this.oGr.show();
      if (this.uow.qtT == 1) {
        i.Y(this, 5);
      }
      paramBundle = this.uow;
      localObject = this.uox;
      if ((localObject != null) && (!paramBundle.upD.contains(localObject))) {
        paramBundle.upD.add(localObject);
      }
      GMTrace.o(3561064759296L, 26532);
      return;
      v.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
      paramBundle = getString(R.l.elV, new Object[] { this.uow.desc, getString(R.l.eYM), bf.ay(this.uow.size) });
      break;
    }
  }
  
  protected void onDestroy()
  {
    GMTrace.i(3561198977024L, 26533);
    v.d("MicroMsg.AppUpdaterUI", "onDestroy");
    com.tencent.mm.sandbox.c.g(hashCode(), this);
    if (this.uow != null)
    {
      j localj = this.uow;
      g localg = this.uox;
      localj.upD.remove(localg);
    }
    if (uov == this) {
      uov = null;
    }
    super.onDestroy();
    GMTrace.o(3561198977024L, 26533);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/updater/AppUpdaterUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */