package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.im;
import com.tencent.mm.e.a.w;
import com.tencent.mm.e.a.y;
import com.tencent.mm.i.e;
import com.tencent.mm.pluginsdk.l.t;
import com.tencent.mm.pluginsdk.l.v;
import com.tencent.mm.pluginsdk.l.y;
import com.tencent.mm.pluginsdk.ui.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.y.n;
import java.util.Map;

public final class p
{
  static ProgressDialog isb;
  private static boolean uSH;
  static SecurityImage uSI;
  
  static
  {
    GMTrace.i(2873198903296L, 21407);
    uSH = false;
    uSI = null;
    isb = null;
    GMTrace.o(2873198903296L, 21407);
  }
  
  public static h a(final Activity paramActivity, String paramString1, String paramString2, final Intent paramIntent)
  {
    GMTrace.i(2872527814656L, 21402);
    im localim = new im();
    localim.fOb.status = 0;
    localim.fOb.fOc = 1;
    com.tencent.mm.sdk.b.a.uql.m(localim);
    paramActivity = com.tencent.mm.ui.base.g.a(paramActivity, paramString1, paramActivity.getString(R.l.dIG), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(2899908231168L, 21606);
        com.tencent.mm.plugin.report.service.g.oSF.a(322L, 23L, 1L, true);
        com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4023), String.format("%b|%s", new Object[] { Boolean.valueOf(bf.mA(this.val$url)), this.val$url }) });
        ap.hold();
        if (bf.mA(this.val$url))
        {
          paramActivity.startActivity(paramIntent);
          b.x(paramActivity, paramIntent);
        }
        for (;;)
        {
          com.tencent.mm.modelsimple.d.bd(paramActivity);
          GMTrace.o(2899908231168L, 21606);
          return;
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("rawUrl", this.val$url);
          paramAnonymousDialogInterface.putExtra("showShare", false);
          paramAnonymousDialogInterface.putExtra("show_bottom", false);
          paramAnonymousDialogInterface.putExtra("needRedirect", false);
          paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
          paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
          paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
          com.tencent.mm.bb.d.b(paramActivity, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
        }
      }
    }, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(2897492312064L, 21588);
        com.tencent.mm.plugin.report.service.g.oSF.a(322L, 24L, 1L, true);
        com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4024), String.format("%b|%s", new Object[] { Boolean.valueOf(bf.mA(this.val$url)), this.val$url }) });
        paramActivity.startActivity(paramIntent);
        b.x(paramActivity, paramIntent);
        com.tencent.mm.modelsimple.d.bd(paramActivity);
        GMTrace.o(2897492312064L, 21588);
      }
    });
    GMTrace.o(2872527814656L, 21402);
    return paramActivity;
  }
  
  public static boolean a(final Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, final String paramString)
  {
    GMTrace.i(2872393596928L, 21401);
    if (paramInt1 != 4)
    {
      GMTrace.o(2872393596928L, 21401);
      return false;
    }
    v.d("MicroMsg.MMErrorProcessor", "errType = " + paramInt1 + " errCode = " + paramInt2);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      GMTrace.o(2872393596928L, 21401);
      return false;
      v.e("MicroMsg.MMErrorProcessor", "account expired=" + paramInt2);
      com.tencent.mm.ui.base.g.a(paramActivity, R.l.ezb, R.l.dIG, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(1882537852928L, 14026);
          if (this.uSJ != null)
          {
            paramActivity.finish();
            paramActivity.startActivity(this.uSJ);
            b.x(paramActivity, this.uSJ);
            com.tencent.mm.modelsimple.d.bd(paramActivity);
          }
          GMTrace.o(1882537852928L, 14026);
        }
      });
      GMTrace.o(2872393596928L, 21401);
      return true;
      String str = ap.uI();
      v.e("MicroMsg.MMErrorProcessor", "account expired=" + paramInt2 + " lastKickReason=" + str);
      paramString = new w();
      com.tencent.mm.sdk.b.a.uql.m(paramString);
      paramString = new im();
      paramString.fOb.status = 0;
      paramString.fOb.fOc = 1;
      com.tencent.mm.sdk.b.a.uql.m(paramString);
      if (uSH)
      {
        if (bf.mA(str)) {}
        for (paramActivity = "";; paramActivity = str)
        {
          v.i("MicroMsg.MMErrorProcessor", "already show kickout dialog before, ignore. lastKickReason[%s]", new Object[] { paramActivity });
          GMTrace.o(2872393596928L, 21401);
          return true;
        }
      }
      if (!bf.mA(str))
      {
        paramString = com.tencent.mm.f.a.dn(str);
        if (paramString != null)
        {
          v.i("MicroMsg.MMErrorProcessor", "account expired br showType[%d]", new Object[] { Integer.valueOf(paramString.showType) });
          if (((paramString.showType == 3) || (paramString.showType == 4)) && (paramString.a(paramActivity, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(1704162492416L, 12697);
              if (this.uSJ != null)
              {
                if (!(paramActivity instanceof LauncherUI)) {
                  paramActivity.finish();
                }
                ap.hold();
                if (bf.mA(paramString.url)) {
                  break label212;
                }
                paramAnonymousDialogInterface = new Intent();
                StringBuilder localStringBuilder = new StringBuilder(paramString.url);
                localStringBuilder.append("&wechat_real_lang=" + u.bID());
                paramAnonymousDialogInterface.putExtra("rawUrl", localStringBuilder.toString());
                paramAnonymousDialogInterface.putExtra("showShare", false);
                paramAnonymousDialogInterface.putExtra("show_bottom", false);
                paramAnonymousDialogInterface.putExtra("needRedirect", false);
                paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
                paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
                paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
                com.tencent.mm.bb.d.b(paramActivity, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              }
              for (;;)
              {
                com.tencent.mm.modelsimple.d.bd(paramActivity);
                paramAnonymousDialogInterface = new y();
                paramAnonymousDialogInterface.fCW.fCX = true;
                com.tencent.mm.sdk.b.a.uql.m(paramAnonymousDialogInterface);
                GMTrace.o(1704162492416L, 12697);
                return;
                label212:
                paramActivity.startActivity(this.uSJ);
                b.x(paramActivity, this.uSJ);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(3089289445376L, 23017);
              if (this.uSJ != null)
              {
                if (!(paramActivity instanceof LauncherUI)) {
                  paramActivity.finish();
                }
                paramActivity.startActivity(this.uSJ);
                b.x(paramActivity, this.uSJ);
                com.tencent.mm.modelsimple.d.bd(paramActivity);
              }
              GMTrace.o(3089289445376L, 23017);
            }
          })))
          {
            uSH = true;
            v.i("MicroMsg.MMErrorProcessor", "show kickout dialog by new logic.");
            GMTrace.o(2872393596928L, 21401);
            return true;
          }
        }
      }
      paramString = str;
      Map localMap;
      if (!bf.mA(str))
      {
        paramString = str;
        if (str.startsWith("<"))
        {
          localMap = bg.q(str, "e");
          paramString = str;
          if (localMap != null)
          {
            paramString = str;
            if (!bf.mA((String)localMap.get(".e.Content")))
            {
              paramString = (String)localMap.get(".e.Content");
              v.i("MicroMsg.MMErrorProcessor", "account expired summerauthkick errmsg=" + paramString + " |v=" + localMap);
            }
          }
        }
      }
      v.i("MicroMsg.MMErrorProcessor", "account expired lastKickReason[%s]", new Object[] { paramString });
      str = paramString;
      if (bf.mA(paramString)) {
        str = com.tencent.mm.bg.a.V(paramActivity, R.l.eza);
      }
      com.tencent.mm.ui.base.g.a(paramActivity, str, paramActivity.getString(R.l.dIG), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2533762269184L, 18878);
          if (this.uSJ != null)
          {
            if (!(paramActivity instanceof LauncherUI)) {
              paramActivity.finish();
            }
            ap.hold();
            paramActivity.startActivity(this.uSJ);
            b.x(paramActivity, this.uSJ);
            com.tencent.mm.modelsimple.d.bd(paramActivity);
            paramAnonymousDialogInterface = new y();
            paramAnonymousDialogInterface.fCW.fCX = true;
            com.tencent.mm.sdk.b.a.uql.m(paramAnonymousDialogInterface);
          }
          GMTrace.o(2533762269184L, 18878);
        }
      }, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(2786225815552L, 20759);
          if (this.uSJ != null)
          {
            if (!(paramActivity instanceof LauncherUI)) {
              paramActivity.finish();
            }
            paramActivity.startActivity(this.uSJ);
            b.x(paramActivity, this.uSJ);
            com.tencent.mm.modelsimple.d.bd(paramActivity);
          }
          GMTrace.o(2786225815552L, 20759);
        }
      });
      uSH = true;
      v.i("MicroMsg.MMErrorProcessor", "show kickout dialog by old logic.");
      GMTrace.o(2872393596928L, 21401);
      return true;
      v.e("MicroMsg.MMErrorProcessor", "account expired=" + paramInt2);
      com.tencent.mm.ui.base.g.a(paramActivity, R.l.dCV, R.l.dIG, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3466843914240L, 25830);
          if (this.uSJ != null)
          {
            paramActivity.finish();
            paramActivity.startActivity(this.uSJ);
            b.x(paramActivity, this.uSJ);
            com.tencent.mm.modelsimple.d.bd(paramActivity);
          }
          GMTrace.o(3466843914240L, 25830);
        }
      });
      GMTrace.o(2872393596928L, 21401);
      return true;
      v.e("MicroMsg.MMErrorProcessor", "accout errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), paramString });
      if ((!bf.mA(paramString)) && (paramString.startsWith("autoauth_errmsg_"))) {
        str = paramString.substring(16);
      }
      do
      {
        paramString = str;
        if (!bf.mA(str))
        {
          paramString = str;
          if (str.startsWith("<"))
          {
            localMap = bg.q(str, "e");
            paramString = str;
            if (localMap != null)
            {
              paramString = str;
              if (!bf.mA((String)localMap.get(".e.Content"))) {
                paramString = (String)localMap.get(".e.Content");
              }
            }
          }
        }
        str = paramString;
        if (bf.mA(paramString)) {
          str = com.tencent.mm.sdk.platformtools.aa.getContext().getString(R.l.ezb);
        }
        com.tencent.mm.ui.base.g.a(paramActivity, str, com.tencent.mm.sdk.platformtools.aa.getContext().getString(R.l.dIG), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(3056808755200L, 22775);
            if (this.uSJ != null)
            {
              paramActivity.finish();
              paramActivity.startActivity(this.uSJ);
              b.x(paramActivity, this.uSJ);
              com.tencent.mm.modelsimple.d.bd(paramActivity);
            }
            GMTrace.o(3056808755200L, 22775);
          }
        });
        GMTrace.o(2872393596928L, 21401);
        return true;
        str = paramString;
      } while (paramInt2 != -104);
      v.i("MicroMsg.MMErrorProcessor", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", new Object[] { paramString });
    }
  }
  
  public static boolean ab(Activity paramActivity)
  {
    int j = 1;
    GMTrace.i(2872662032384L, 21403);
    if (bf.PX(com.tencent.mm.i.g.sV().getValue("SilentDownloadApkAtWiFi")) != 0)
    {
      GMTrace.o(2872662032384L, 21403);
      return false;
    }
    ap.yY();
    int i;
    if ((((Integer)c.vr().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = 1;
      if ((!al.isWifi(paramActivity)) || (i == 0)) {
        break label130;
      }
      i = j;
      label81:
      if ((f.fuP & 0x1) == 0) {
        break label135;
      }
      v.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      i = 0;
    }
    for (;;)
    {
      if ((i == 0) || (!com.tencent.mm.platformtools.t.Ny())) {
        break label146;
      }
      boolean bool = ac(paramActivity);
      GMTrace.o(2872662032384L, 21403);
      return bool;
      i = 0;
      break;
      label130:
      i = 0;
      break label81;
      label135:
      v.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    }
    label146:
    GMTrace.o(2872662032384L, 21403);
    return false;
  }
  
  private static boolean ac(Activity paramActivity)
  {
    GMTrace.i(2873064685568L, 21406);
    com.tencent.mm.pluginsdk.model.app.a locala = com.tencent.mm.pluginsdk.model.app.a.bCI();
    if (locala != null)
    {
      locala.bCL();
      v.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
      GMTrace.o(2873064685568L, 21406);
      return true;
    }
    if (l.y.bCk() != null)
    {
      l.y.bCk().cL(paramActivity).update(2);
      GMTrace.o(2873064685568L, 21406);
      return true;
    }
    GMTrace.o(2873064685568L, 21406);
    return false;
  }
  
  public static boolean b(final Activity paramActivity, int paramInt1, int paramInt2)
  {
    GMTrace.i(2872930467840L, 21405);
    v.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(com.tencent.mm.protocal.d.sXh), Integer.valueOf(f.fuN), Integer.valueOf(f.fuP) });
    if (paramInt1 != 4)
    {
      GMTrace.o(2872930467840L, 21405);
      return false;
    }
    switch (paramInt2)
    {
    default: 
      GMTrace.o(2872930467840L, 21405);
      return false;
    case -16: 
      if (l.y.bCk() != null)
      {
        paramActivity = l.y.bCk().b(paramActivity, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(1701746573312L, 12679);
            com.tencent.mm.plugin.report.service.g.oSF.a(405L, 37L, 1L, true);
            this.ihI.finish();
            MMAppMgr.a(this.ihI, true);
            GMTrace.o(1701746573312L, 12679);
          }
        });
        com.tencent.mm.plugin.report.service.g.oSF.a(405L, 36L, 1L, true);
        paramActivity.update(1);
        GMTrace.o(2872930467840L, 21405);
        return true;
      }
      GMTrace.o(2872930467840L, 21405);
      return false;
    }
    long l = com.tencent.mm.sdk.platformtools.aa.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1L);
    v.i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", new Object[] { Long.valueOf(l), Long.valueOf(bf.az(l)) });
    if ((l != -1L) && (bf.az(l) < 86400L))
    {
      GMTrace.o(2872930467840L, 21405);
      return true;
    }
    if ((f.fuP & 0x2) != 0)
    {
      v.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      GMTrace.o(2872930467840L, 21405);
      return true;
    }
    v.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    String str = com.tencent.mm.i.g.sV().getValue("SilentDownloadApkAtWiFi");
    ap.yY();
    if ((((Integer)c.vr().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || ((!bf.mA(str)) && (bf.PX(str) != 0))) {
        break label481;
      }
      bool = true;
      label359:
      if ((f.fuP & 0x1) == 0) {
        break label487;
      }
      v.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      bool = false;
    }
    for (;;)
    {
      if (bf.PX(str) != 0) {
        v.d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
      }
      v.d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break label509;
      }
      if (l.y.bCk() == null) {
        break label498;
      }
      paramActivity = l.y.bCk().b(paramActivity, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(3149955858432L, 23469);
          com.tencent.mm.plugin.report.service.g.oSF.a(405L, 39L, 1L, true);
          if (this.uSJ != null)
          {
            paramActivity.finish();
            paramActivity.startActivity(this.uSJ);
            b.x(paramActivity, this.uSJ);
          }
          GMTrace.o(3149955858432L, 23469);
        }
      });
      com.tencent.mm.plugin.report.service.g.oSF.a(405L, 38L, 1L, true);
      paramActivity.update(2);
      GMTrace.o(2872930467840L, 21405);
      return true;
      paramInt1 = 0;
      break;
      label481:
      bool = false;
      break label359;
      label487:
      v.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    }
    label498:
    GMTrace.o(2872930467840L, 21405);
    return false;
    label509:
    com.tencent.mm.plugin.report.service.g.oSF.a(405L, 40L, 1L, true);
    boolean bool = ac(paramActivity);
    GMTrace.o(2872930467840L, 21405);
    return bool;
  }
  
  public static boolean eB(final Context paramContext)
  {
    GMTrace.i(2872796250112L, 21404);
    final String str = com.tencent.mm.platformtools.t.Nv();
    int i = com.tencent.mm.platformtools.t.Nw();
    v.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", new Object[] { str, Integer.valueOf(i) });
    if ((!bf.mA(str)) && (!com.tencent.mm.platformtools.t.Nx()))
    {
      ap.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2832530931712L, 21104);
          if ((this.uSK == 4) && (com.tencent.mm.pluginsdk.model.app.a.bCI() == null))
          {
            v.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
            GMTrace.o(2832530931712L, 21104);
            return;
          }
          if ((l.y.bCk() != null) && (l.y.bCk().DC(str) != null)) {
            ae.v(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(1906160173056L, 14202);
                if (l.y.bCk() != null) {
                  l.y.bCk().cM(p.3.this.val$context);
                }
                GMTrace.o(1906160173056L, 14202);
              }
            });
          }
          GMTrace.o(2832530931712L, 21104);
        }
      });
      GMTrace.o(2872796250112L, 21404);
      return true;
    }
    GMTrace.o(2872796250112L, 21404);
    return false;
  }
  
  public static final class a
  {
    public static boolean a(final Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      GMTrace.i(2070711107584L, 15428);
      switch (paramInt1)
      {
      }
      label175:
      Object localObject;
      do
      {
        do
        {
          GMTrace.o(2070711107584L, 15428);
          return false;
          if ((((paramInt3 & 0x2) == 0) || (!ap.vd().BS()) || (!k.u(paramContext, ap.vd().getNetworkServerIp(), String.valueOf(paramInt2)))) && (((paramInt3 & 0x1) == 0) || (!com.tencent.mm.network.aa.bn(paramContext)) || (!k.dD(paramContext)))) {
            if (((paramInt3 & 0x4) != 0) && (al.isWap(paramContext)))
            {
              if (ap.zb()) {
                break label175;
              }
              paramInt1 = 0;
            }
          }
          for (;;)
          {
            if (paramInt1 == 0) {
              Toast.makeText(paramContext, paramContext.getString(R.l.elm, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
            }
            GMTrace.o(2070711107584L, 15428);
            return true;
            ap.yY();
            if (bf.f((Boolean)c.vr().get(61, null)))
            {
              paramInt1 = 0;
            }
            else if (!ac.Ps("show_wap_adviser"))
            {
              paramInt1 = 0;
            }
            else
            {
              paramString = View.inflate(paramContext, R.i.djX, null);
              ((TextView)paramString.findViewById(R.h.cmU)).setText(R.l.eDp);
              localObject = (CheckBox)paramString.findViewById(R.h.cmT);
              ((CheckBox)localObject).setText(paramContext.getString(R.l.eGM));
              ((CheckBox)localObject).setOnCheckedChangeListener(new MMAppMgr.12());
              ((CheckBox)localObject).setVisibility(0);
              localObject = new h.a(paramContext);
              ((h.a)localObject).zR(R.l.dIG);
              ((h.a)localObject).db(paramString);
              ((h.a)localObject).zU(R.l.eGO).a(new MMAppMgr.13(paramContext));
              ((h.a)localObject).kH(false);
              ((h.a)localObject).zV(R.l.eGN);
              ((h.a)localObject).a(new MMAppMgr.14());
              ((h.a)localObject).WD().show();
              paramInt1 = 1;
            }
          }
          Toast.makeText(paramContext, paramContext.getString(R.l.eln, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 1).show();
          GMTrace.o(2070711107584L, 15428);
          return true;
          GMTrace.o(2070711107584L, 15428);
          return true;
          localObject = com.tencent.mm.f.a.dn(paramString);
        } while (localObject == null);
        v.i("MicroMsg.MMErrorProcessor", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(((com.tencent.mm.f.a)localObject).showType), ((com.tencent.mm.f.a)localObject).url, ((com.tencent.mm.f.a)localObject).desc });
        paramString = null;
        if (!bf.mA(((com.tencent.mm.f.a)localObject).url)) {
          paramString = new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(2905008504832L, 21644);
              paramAnonymousDialogInterface = new Intent();
              StringBuilder localStringBuilder = new StringBuilder(this.ihL.url);
              localStringBuilder.append("&wechat_real_lang=" + u.bID());
              paramAnonymousDialogInterface.putExtra("rawUrl", localStringBuilder.toString());
              paramAnonymousDialogInterface.putExtra("showShare", false);
              paramAnonymousDialogInterface.putExtra("show_bottom", false);
              paramAnonymousDialogInterface.putExtra("needRedirect", false);
              paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
              com.tencent.mm.bb.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              GMTrace.o(2905008504832L, 21644);
            }
          };
        }
      } while (!((com.tencent.mm.f.a)localObject).a(paramContext, paramString, null));
      GMTrace.o(2070711107584L, 15428);
      return true;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */