package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class a
{
  private String fWO;
  private String hRY;
  boolean uXv;
  private String username;
  private String vbh;
  private a vbi;
  
  public a(a parama, String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(2591475892224L, 19308);
    this.hRY = "";
    this.username = "";
    this.vbh = "";
    this.uXv = false;
    this.username = paramString1;
    this.hRY = paramString3;
    this.vbh = paramString2;
    this.vbi = parama;
    GMTrace.o(2591475892224L, 19308);
  }
  
  public final void a(final MMActivity paramMMActivity, int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2591744327680L, 19310);
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      ap.vd().a(new bb(new bb.a()
      {
        public final void a(e paramAnonymouse)
        {
          GMTrace.i(2629862162432L, 19594);
          if (paramAnonymouse == null)
          {
            GMTrace.o(2629862162432L, 19594);
            return;
          }
          paramAnonymouse = paramAnonymouse.Cc();
          ap.yY();
          int i = com.tencent.mm.u.c.uH();
          paramAnonymouse.i(new byte[0], i);
          GMTrace.o(2629862162432L, 19594);
        }
      }), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramk instanceof u)) {
        this.fWO = ((u)paramk).Ji();
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        ap.unhold();
        d.bc(paramMMActivity);
        m.mv(this.hRY);
        m.a(paramMMActivity, new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2581141127168L, 19231);
            Intent localIntent = com.tencent.mm.plugin.c.a.imb.ak(paramMMActivity);
            localIntent.addFlags(67108864);
            paramMMActivity.startActivity(localIntent);
            paramMMActivity.finish();
            GMTrace.o(2581141127168L, 19231);
          }
        }, false, 2);
        if (this.uXv)
        {
          paramMMActivity = aa.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", "");
          com.tencent.mm.plugin.report.service.g.oSF.i(11930, new Object[] { paramMMActivity, Integer.valueOf(4) });
        }
        GMTrace.o(2591744327680L, 19310);
        return;
      }
      if (paramInt2 == -106)
      {
        m.E(paramMMActivity, paramString);
        GMTrace.o(2591744327680L, 19310);
        return;
      }
      if (paramInt2 == 65319)
      {
        m.a(paramMMActivity, com.tencent.mm.pluginsdk.a.a.a((u)paramk), paramInt2);
        GMTrace.o(2591744327680L, 19310);
        return;
      }
      if (com.tencent.mm.plugin.c.a.imc.a(paramMMActivity, paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      while (i != 0)
      {
        GMTrace.o(2591744327680L, 19310);
        return;
        if (paramInt1 == 4) {}
        switch (paramInt2)
        {
        default: 
          i = 0;
          break;
        case -1: 
          if (ap.vd().BR() == 5)
          {
            com.tencent.mm.ui.base.g.h(paramMMActivity, R.l.eDh, R.l.eDg);
            i = 1;
          }
          break;
        case -4: 
        case -3: 
          com.tencent.mm.ui.base.g.h(paramMMActivity, R.l.eeU, R.l.ewF);
          i = 1;
          break;
        case -9: 
          com.tencent.mm.ui.base.g.h(paramMMActivity, R.l.ewE, R.l.ewF);
          i = 1;
          break;
        case -72: 
          com.tencent.mm.ui.base.g.h(paramMMActivity, R.l.eJR, R.l.dIG);
          i = 1;
          break;
        case -75: 
          com.tencent.mm.ui.base.g.h(paramMMActivity, R.l.dCV, R.l.dIG);
          i = 1;
          break;
        case -100: 
          ap.hold();
          if (TextUtils.isEmpty(ap.uI())) {}
          for (paramString = com.tencent.mm.bg.a.V(paramMMActivity, R.l.eza);; paramString = ap.uI())
          {
            com.tencent.mm.ui.base.g.a(paramMMActivity, paramString, paramMMActivity.getString(R.l.dIG), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(2612816510976L, 19467);
                GMTrace.o(2612816510976L, 19467);
              }
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                GMTrace.i(2609192632320L, 19440);
                GMTrace.o(2609192632320L, 19440);
              }
            });
            i = 1;
            break;
          }
        case -140: 
          if (!bf.mA(this.fWO)) {
            m.j(paramMMActivity, paramString, this.fWO);
          }
          i = 1;
        }
      }
      Toast.makeText(paramMMActivity, paramMMActivity.getString(R.l.ekZ, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      GMTrace.o(2591744327680L, 19310);
      return;
    }
  }
  
  public final void h(MMActivity paramMMActivity)
  {
    GMTrace.i(2591610109952L, 19309);
    final u localu = new u(this.username, this.vbh, 0, "", "", "", 0, "", false, true);
    ap.vd().a(localu, 0);
    a locala = this.vbi;
    paramMMActivity.getString(R.l.dIG);
    locala.a(com.tencent.mm.ui.base.g.a(paramMMActivity, paramMMActivity.getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(2621272227840L, 19530);
        ap.vd().c(localu);
        GMTrace.o(2621272227840L, 19530);
      }
    }));
    GMTrace.o(2591610109952L, 19309);
  }
  
  public static abstract interface a
  {
    public abstract void a(ProgressDialog paramProgressDialog);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/mobile/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */