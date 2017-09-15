package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.il;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public class NewTaskUI
  extends MMBaseActivity
  implements e
{
  static NewTaskUI wlG;
  private ProgressDialog isb;
  private SecurityImage uSI;
  private c uVQ;
  private i wlH;
  
  public NewTaskUI()
  {
    GMTrace.i(1960786788352L, 14609);
    this.uSI = null;
    this.wlH = new i();
    this.isb = null;
    this.uVQ = new c() {};
    GMTrace.o(1960786788352L, 14609);
  }
  
  public static NewTaskUI bZE()
  {
    GMTrace.i(1961457876992L, 14614);
    NewTaskUI localNewTaskUI = wlG;
    GMTrace.o(1961457876992L, 14614);
    return localNewTaskUI;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(1961592094720L, 14615);
    v.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((this.isb != null) && (this.isb.isShowing())) {
      this.isb.dismiss();
    }
    if ((paramInt1 == 4) && (paramInt2 == -3))
    {
      v.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", new Object[] { Boolean.valueOf(ap.zb()) });
      if (p.a(wlG, paramInt1, paramInt2, new Intent().setClass(wlG, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString))
      {
        GMTrace.o(1961592094720L, 14615);
        return;
      }
    }
    if ((paramInt1 != 4) || ((paramInt2 != -6) && (paramInt2 != 65225) && (paramInt2 != 65226)))
    {
      wlG = null;
      finish();
      GMTrace.o(1961592094720L, 14615);
      return;
    }
    if ((paramk instanceof u))
    {
      paramString = (u)paramk;
      this.wlH.uXi = paramString.Jj();
      this.wlH.uXh = paramString.FJ();
      this.wlH.uXf = paramString.FK();
      this.wlH.uXg = paramString.Jk();
      v.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.wlH.uXf + " img len" + this.wlH.uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
    }
    if (this.uSI == null)
    {
      this.uSI = SecurityImage.a.a(this, R.l.eJY, this.wlH.uXi, this.wlH.uXh, this.wlH.uXf, this.wlH.uXg, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(1939714605056L, 14452);
          v.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.a(NewTaskUI.this).uXf + " img len" + NewTaskUI.a(NewTaskUI.this).uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
          if (NewTaskUI.b(NewTaskUI.this) == null)
          {
            v.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
            GMTrace.o(1939714605056L, 14452);
            return;
          }
          paramAnonymousDialogInterface = new u(NewTaskUI.a(NewTaskUI.this).uXi, NewTaskUI.b(NewTaskUI.this).bRp(), NewTaskUI.b(NewTaskUI.this).uXf, NewTaskUI.b(NewTaskUI.this).uXg);
          ap.vd().a(paramAnonymousDialogInterface, 0);
          NewTaskUI localNewTaskUI1 = NewTaskUI.this;
          NewTaskUI localNewTaskUI2 = NewTaskUI.this;
          NewTaskUI.this.getString(R.l.dIG);
          NewTaskUI.a(localNewTaskUI1, com.tencent.mm.ui.base.g.a(localNewTaskUI2, NewTaskUI.this.getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              GMTrace.i(1945888620544L, 14498);
              ap.vd().c(paramAnonymousDialogInterface);
              GMTrace.o(1945888620544L, 14498);
            }
          }));
          GMTrace.o(1939714605056L, 14452);
        }
      }, new DialogInterface.OnCancelListener()new DialogInterface.OnDismissListener
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(1952599506944L, 14548);
          if (NewTaskUI.wlG != null)
          {
            NewTaskUI.wlG = null;
            NewTaskUI.this.finish();
          }
          GMTrace.o(1952599506944L, 14548);
        }
      }, new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(1940251475968L, 14456);
          NewTaskUI.c(NewTaskUI.this);
          GMTrace.o(1940251475968L, 14456);
        }
      }, this.wlH);
      GMTrace.o(1961592094720L, 14615);
      return;
    }
    v.d("MicroMsg.NewTaskUI", "imgSid:" + this.wlH.uXf + " img len" + this.wlH.uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
    this.uSI.a(this.wlH.uXi, this.wlH.uXh, this.wlH.uXf, this.wlH.uXg);
    GMTrace.o(1961592094720L, 14615);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    GMTrace.i(1960921006080L, 14610);
    super.onCreate(paramBundle);
    v.i("MicroMsg.NewTaskUI", "onCreate :%d", new Object[] { Integer.valueOf(hashCode()) });
    setContentView(R.i.cUT);
    ap.vd().a(701, this);
    wlG = this;
    paramBundle = new u(0, "", "", "");
    ap.vd().a(paramBundle, 0);
    getString(R.l.dIG);
    this.isb = com.tencent.mm.ui.base.g.a(this, getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(1954478555136L, 14562);
        ap.vd().c(paramBundle);
        GMTrace.o(1954478555136L, 14562);
      }
    });
    GMTrace.o(1960921006080L, 14610);
  }
  
  public void onDestroy()
  {
    GMTrace.i(1961323659264L, 14613);
    v.i("MicroMsg.NewTaskUI", "onDestroy :%d", new Object[] { Integer.valueOf(hashCode()) });
    if (equals(wlG)) {
      wlG = null;
    }
    if ((this.isb != null) && (this.isb.isShowing())) {
      this.isb.dismiss();
    }
    if (this.uSI != null) {
      this.uSI.dismiss();
    }
    ap.vd().b(701, this);
    super.onDestroy();
    GMTrace.o(1961323659264L, 14613);
  }
  
  public void onPause()
  {
    GMTrace.i(1961189441536L, 14612);
    super.onPause();
    a.uql.c(this.uVQ);
    GMTrace.o(1961189441536L, 14612);
  }
  
  public void onResume()
  {
    GMTrace.i(1961055223808L, 14611);
    a.uql.b(this.uVQ);
    super.onResume();
    GMTrace.o(1961055223808L, 14611);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/NewTaskUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */