package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelsimple.u.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.Map;

public final class m
{
  public static void E(final Context paramContext, String paramString)
  {
    GMTrace.i(455534968832L, 3394);
    com.tencent.mm.f.a locala = com.tencent.mm.f.a.dn(paramString);
    if (locala != null)
    {
      paramString = paramContext.getString(R.l.dHL);
      String str = paramContext.getString(R.l.dGk);
      DialogInterface.OnClickListener local5 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(474325450752L, 3534);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("rawUrl", this.ihL.url);
          paramAnonymousDialogInterface.putExtra("showShare", false);
          paramAnonymousDialogInterface.putExtra("show_bottom", false);
          paramAnonymousDialogInterface.putExtra("needRedirect", false);
          paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
          paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
          paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
          com.tencent.mm.plugin.c.a.imb.j(paramAnonymousDialogInterface, paramContext);
          GMTrace.o(474325450752L, 3534);
        }
      };
      DialogInterface.OnClickListener local6 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(457950887936L, 3412);
          GMTrace.o(457950887936L, 3412);
        }
      };
      if ((locala.showType == 1) || (locala.showType == 4))
      {
        if (bf.mA(locala.url))
        {
          com.tencent.mm.ui.base.g.b(paramContext, locala.desc, locala.fDt, true);
          GMTrace.o(455534968832L, 3394);
          return;
        }
        com.tencent.mm.ui.base.g.b(paramContext, locala.desc, locala.fDt, paramString, str, local5, local6);
      }
      GMTrace.o(455534968832L, 3394);
      return;
    }
    paramContext = bg.q(paramString, "e");
    if (paramContext == null)
    {
      v.d("MicroMsg.PostLoginUtil", "this is not errmsg");
      GMTrace.o(455534968832L, 3394);
      return;
    }
    paramContext = (String)paramContext.get(".e.Url");
    if (bf.mA(paramContext))
    {
      GMTrace.o(455534968832L, 3394);
      return;
    }
    v.w("MicroMsg.PostLoginUtil", "url %s", new Object[] { paramContext });
    GMTrace.o(455534968832L, 3394);
  }
  
  public static void a(final Activity paramActivity, final Runnable paramRunnable, boolean paramBoolean, int paramInt)
  {
    GMTrace.i(454729662464L, 3388);
    if ((com.tencent.mm.modelfriend.m.Fm() != m.a.hBa) && (com.tencent.mm.modelfriend.m.Fm() != m.a.hBb)) {
      v.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
    }
    for (;;)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      GMTrace.o(454729662464L, 3388);
      return;
      ap.yY();
      if (bf.f((Boolean)c.vr().get(12322, null)))
      {
        v.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
      }
      else
      {
        if (!paramBoolean)
        {
          ap.yY();
          if (bf.f((Boolean)c.vr().get(12323, null)))
          {
            v.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
            continue;
          }
        }
        ap.yY();
        c.vr().set(12322, Boolean.valueOf(false));
        String str = bf.mz(bf.eo(paramActivity));
        if (str.length() <= 0) {
          break;
        }
        ap.yY();
        if (!str.equals(c.vr().get(6, null))) {
          break;
        }
        ap.yY();
        c.vr().set(12322, Boolean.valueOf(true));
        v.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
      }
    }
    com.tencent.mm.ui.base.g.a(paramActivity, R.l.dNb, R.l.dIG, R.l.dIW, R.l.dHI, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(468419870720L, 3490);
        v.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(this.hQt) });
        com.tencent.mm.plugin.report.service.g.oSF.i(11438, new Object[] { Integer.valueOf(this.hQt) });
        ap.yY();
        c.vr().set(12322, Boolean.valueOf(true));
        m.f(true, false);
        com.tencent.mm.modelfriend.a.EM();
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        paramActivity.getSharedPreferences(aa.bIN(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
        GMTrace.o(468419870720L, 3490);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(470298918912L, 3504);
        ap.yY();
        c.vr().set(12322, Boolean.valueOf(false));
        m.f(false, false);
        if (this.ihJ != null) {
          this.ihJ.run();
        }
        paramActivity.getSharedPreferences(aa.bIN(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
        GMTrace.o(470298918912L, 3504);
      }
    });
    ap.yY();
    c.vr().set(12323, Boolean.valueOf(true));
    GMTrace.o(454729662464L, 3388);
  }
  
  public static void a(Context paramContext, u.a parama, int paramInt)
  {
    GMTrace.i(455400751104L, 3393);
    Intent localIntent = new Intent(paramContext, BioHelperUI.class);
    localIntent.putExtra("k_type", parama.type);
    localIntent.putExtra("KVoiceHelpCode", paramInt);
    localIntent.putExtra("Kvertify_key", parama.fGM);
    localIntent.putExtra("KVoiceHelpUrl", parama.hSj);
    localIntent.putExtra("KVoiceHelpWording", parama.fNx);
    localIntent.putExtra("Kusername", parama.username);
    if (parama.hSk != null) {
      localIntent.getExtras().putAll(parama.hSk);
    }
    paramContext.startActivity(localIntent);
    GMTrace.o(455400751104L, 3393);
  }
  
  public static void bo(final Context paramContext)
  {
    GMTrace.i(455132315648L, 3391);
    String str1 = paramContext.getString(R.l.dCV);
    String str2 = paramContext.getString(R.l.dCU);
    com.tencent.mm.ui.base.g.b(paramContext, str1, "", paramContext.getString(R.l.dXc), paramContext.getString(R.l.dXa), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(465735516160L, 3470);
        paramAnonymousDialogInterface = new Intent();
        paramAnonymousDialogInterface.putExtra("rawUrl", this.ihK);
        paramAnonymousDialogInterface.putExtra("showShare", false);
        paramAnonymousDialogInterface.putExtra("show_bottom", false);
        paramAnonymousDialogInterface.putExtra("needRedirect", false);
        paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
        paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
        paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
        com.tencent.mm.plugin.c.a.imb.j(paramAnonymousDialogInterface, paramContext);
        GMTrace.o(465735516160L, 3470);
      }
    }, null);
    GMTrace.o(455132315648L, 3391);
  }
  
  public static void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(454863880192L, 3389);
    int i = com.tencent.mm.u.m.xP();
    if (paramBoolean1)
    {
      i &= 0xFFFDFFFF;
      v.d("MicroMsg.PostLoginUtil", "Reg By mobile update = " + i);
      ap.yY();
      c.vr().set(7, Integer.valueOf(i));
      if (paramBoolean1) {
        break label120;
      }
    }
    label120:
    for (i = 1;; i = 2)
    {
      ap.yY();
      c.wQ().b(new com.tencent.mm.ao.g(17, i));
      if (paramBoolean2) {
        com.tencent.mm.plugin.c.a.imc.ou();
      }
      GMTrace.o(454863880192L, 3389);
      return;
      i |= 0x20000;
      break;
    }
  }
  
  public static void j(final Context paramContext, String paramString1, String paramString2)
  {
    GMTrace.i(455266533376L, 3392);
    paramString1 = com.tencent.mm.f.a.dn(paramString1);
    if (paramString1 != null) {
      paramString1.a(paramContext, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(466138169344L, 3473);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("rawUrl", this.ihK);
          paramAnonymousDialogInterface.putExtra("showShare", false);
          paramAnonymousDialogInterface.putExtra("show_bottom", false);
          paramAnonymousDialogInterface.putExtra("needRedirect", false);
          paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
          paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
          paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
          com.tencent.mm.plugin.c.a.imb.j(paramAnonymousDialogInterface, paramContext);
          GMTrace.o(466138169344L, 3473);
        }
      }, null);
    }
    GMTrace.o(455266533376L, 3392);
  }
  
  public static void mv(String paramString)
  {
    GMTrace.i(454998097920L, 3390);
    ao.hlE.L("login_user_name", paramString);
    GMTrace.o(454998097920L, 3390);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/platformtools/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */