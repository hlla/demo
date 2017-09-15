package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.q;
import com.tencent.mm.b.i.a;
import com.tencent.mm.e.a.bd;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.l.t;
import com.tencent.mm.protocal.c.aaw;
import com.tencent.mm.protocal.c.aax;
import com.tencent.mm.protocal.c.abx;
import com.tencent.mm.protocal.c.amz;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.protocal.c.lb;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.af;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class Updater
  extends LinearLayout
  implements l.t, com.tencent.mm.y.e
{
  private boolean fEh;
  private int uok;
  private p upq;
  private boolean upr;
  private boolean ups;
  private boolean upt;
  private com.tencent.mm.y.e upu;
  private com.tencent.mm.y.e upv;
  
  private Updater(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(3582539595776L, 26692);
    this.upq = null;
    this.upr = false;
    this.ups = false;
    this.upt = false;
    GMTrace.o(3582539595776L, 26692);
  }
  
  public Updater(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(3582673813504L, 26693);
    this.upq = null;
    this.upr = false;
    this.ups = false;
    this.upt = false;
    GMTrace.o(3582673813504L, 26693);
  }
  
  public static void a(Intent paramIntent, e parame)
  {
    GMTrace.i(18998116745216L, 141547);
    paramIntent.putExtra("intent_short_ips", bHY());
    paramIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.sXh);
    paramIntent.putExtra("intent_update_type", 3);
    int i;
    if ((parame.mKk != null) && (!parame.mKk.isEmpty()) && (parame.mKk.containsKey(Integer.valueOf(4))))
    {
      i = 1;
      if (i == 0) {
        break label359;
      }
      localObject1 = parame.mKk;
      if ((localObject1 != null) && (!((HashMap)localObject1).isEmpty())) {
        break label215;
      }
      localObject1 = "";
    }
    label215:
    Object localObject2;
    LinkedList localLinkedList;
    int j;
    label262:
    do
    {
      do
      {
        do
        {
          paramIntent.putExtra("intent_extra_desc", (String)localObject1);
          paramIntent.putExtra("intent_extra_md5", parame.mKo);
          paramIntent.putExtra("intent_extra_size", parame.fileSize);
          paramIntent.putExtra("intent_extra_download_url", new String[] { parame.mKn });
          paramIntent.putExtra("intent_extra_patchInfo", parame.bHN());
          paramIntent.putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.f.fuP);
          paramIntent.putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.f.uqF);
          paramIntent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
          paramIntent.putExtra("intent_extra_tinker_patch", true);
          paramIntent.putExtra("intent_extra_download_mode", 1);
          GMTrace.o(18998116745216L, 141547);
          return;
          i = 0;
          break;
          localObject2 = "";
          localLinkedList = (LinkedList)((HashMap)localObject1).get(Integer.valueOf(4));
          localObject1 = localObject2;
        } while (localLinkedList == null);
        localObject1 = localObject2;
      } while (localLinkedList.isEmpty());
      j = localLinkedList.size();
      i = 0;
      localObject1 = localObject2;
    } while (i >= j);
    Object localObject1 = (amz)localLinkedList.get(i);
    if (((amz)localObject1).lang.equalsIgnoreCase("default")) {}
    for (localObject1 = new String(Base64.decode(((amz)localObject1).content, 0));; localObject1 = localObject2)
    {
      i += 1;
      localObject2 = localObject1;
      break label262;
      if (((amz)localObject1).lang.equalsIgnoreCase(u.bID()))
      {
        localObject1 = new String(Base64.decode(((amz)localObject1).content, 0));
        break;
        label359:
        localObject1 = "";
        break;
      }
    }
  }
  
  private static String[] bHY()
  {
    int i = 0;
    GMTrace.i(18998250962944L, 141548);
    if ((r.iil != null) && (r.iil.length() > 0))
    {
      localObject = r.iil;
      GMTrace.o(18998250962944L, 141548);
      return new String[] { localObject };
    }
    Object localObject = aa.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    String[] arrayOfString;
    for (;;)
    {
      localObject = com.tencent.mm.protocal.n.NI((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfString[i] = ((com.tencent.mm.protocal.n)((List)localObject).get(i)).mZj;
        i += 1;
      }
      localObject = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
    }
    GMTrace.o(18998250962944L, 141548);
    return arrayOfString;
  }
  
  public static Updater c(Context paramContext, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    GMTrace.i(3583076466688L, 26696);
    if (paramContext == null)
    {
      GMTrace.o(3583076466688L, 26696);
      return null;
    }
    if (((paramContext instanceof Activity)) && ((((Activity)paramContext).isFinishing()) || (((Activity)paramContext).getWindow() == null)))
    {
      v.e("MicroMsg.Updater", "showWithProgress, context isFinishing");
      GMTrace.o(3583076466688L, 26696);
      return null;
    }
    aa.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bf.Nz()).commit();
    ap.getNotification().cancel(34);
    v.i("MicroMsg.Updater", "showWithProgress");
    Updater localUpdater = (Updater)View.inflate(paramContext, R.i.dpf, null);
    localUpdater.onStart();
    paramContext = p.a(paramContext, paramContext.getString(R.l.eYO), true, 0, null);
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(3573949661184L, 26628);
        ap.getNotification().cancel(99);
        g.oSF.a(405L, 47L, 1L, true);
        Updater.yj(2);
        this.upw.onStop();
        if ((!Updater.a(this.upw)) && (paramOnCancelListener != null)) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        GMTrace.o(3573949661184L, 26628);
      }
    });
    try
    {
      localUpdater.upq = paramContext;
      localUpdater.upq.show();
      localUpdater.fEh = true;
      g.oSF.a(405L, 46L, 1L, true);
      GMTrace.o(3583076466688L, 26696);
      return localUpdater;
    }
    catch (Exception paramContext)
    {
      v.e("MicroMsg.Updater", "exception in showWithProgress, ", new Object[] { paramContext.getMessage() });
      v.printErrStackTrace("MicroMsg.Updater", paramContext, "", new Object[0]);
      GMTrace.o(3583076466688L, 26696);
    }
    return null;
  }
  
  public static void cM(Context paramContext)
  {
    GMTrace.i(3583479119872L, 26699);
    paramContext.startActivity(new Intent(paramContext, AppInstallerUI.class));
    GMTrace.o(3583479119872L, 26699);
  }
  
  private void cancel()
  {
    GMTrace.i(3583747555328L, 26701);
    ap.vd().b(11, this);
    GMTrace.o(3583747555328L, 26701);
  }
  
  public static Updater d(Context paramContext, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    GMTrace.i(3583210684416L, 26697);
    aa.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bf.Nz()).commit();
    ap.getNotification().cancel(34);
    v.i("MicroMsg.Updater", "show update dialog");
    Updater localUpdater = (Updater)View.inflate(paramContext, R.i.dpf, null);
    localUpdater.onStart();
    paramContext = p.a(paramContext, "", true, 0, null);
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(3565628162048L, 26566);
        ap.getNotification().cancel(99);
        g.oSF.a(405L, 49L, 1L, true);
        Updater.yj(2);
        this.upw.onStop();
        if ((!Updater.a(this.upw)) && (paramOnCancelListener != null)) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        GMTrace.o(3565628162048L, 26566);
      }
    });
    g.oSF.a(405L, 48L, 1L, true);
    localUpdater.upq = paramContext;
    localUpdater.fEh = false;
    GMTrace.o(3583210684416L, 26697);
    return localUpdater;
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    GMTrace.i(3584150208512L, 26704);
    Intent localIntent = new Intent(aa.getContext(), UpdaterService.class);
    localIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.sXh);
    localIntent.putExtra("intent_update_type", 4);
    localIntent.putExtra("intent_extra_desc", paramString2);
    localIntent.putExtra("intent_extra_md5", paramString1);
    localIntent.putExtra("intent_extra_size", paramInt);
    localIntent.putExtra("intent_extra_download_url", new String[] { paramString3 });
    localIntent.putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.f.fuP);
    localIntent.putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.f.uqF);
    localIntent.putExtra("intent_extra_run_in_foreground", true);
    localIntent.putExtra("intent_extra_download_mode", 2);
    g.oSF.a(405L, 45L, 1L, true);
    aa.getContext().startService(localIntent);
    GMTrace.o(3584150208512L, 26704);
  }
  
  public static Updater dT(Context paramContext)
  {
    GMTrace.i(3583344902144L, 26698);
    aa.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bf.Nz()).commit();
    ap.getNotification().cancel(34);
    g.oSF.a(405L, 50L, 1L, true);
    v.i("MicroMsg.Updater", "updater silence");
    paramContext = new Updater(paramContext);
    paramContext.onStart();
    paramContext.ups = true;
    GMTrace.o(3583344902144L, 26698);
    return paramContext;
  }
  
  private void onStart()
  {
    GMTrace.i(3582808031232L, 26694);
    ap.vd().a(11, this);
    g.oSF.a(405L, 42L, 1L, true);
    GMTrace.o(3582808031232L, 26694);
  }
  
  public static void yj(int paramInt)
  {
    GMTrace.i(3584284426240L, 26705);
    if (!ap.zb())
    {
      GMTrace.o(3584284426240L, 26705);
      return;
    }
    v.d("MicroMsg.Updater", "reportUpdateStat : opCode = " + paramInt);
    ap.yY();
    com.tencent.mm.u.c.wQ().b(new q(paramInt));
    GMTrace.o(3584284426240L, 26705);
  }
  
  public final void a(int paramInt1, int paramInt2, final String paramString, k paramk)
  {
    GMTrace.i(3583613337600L, 26700);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      g.oSF.a(405L, 51L, 1L, true);
      v.i("MicroMsg.Updater", "isShow " + this.fEh);
      if ((!this.fEh) && (this.upq != null)) {
        this.upq.show();
      }
      this.upr = true;
      if (this.upq != null) {
        this.upq.cancel();
      }
      paramString = (com.tencent.mm.sandbox.a.a)paramk;
      ap.vd().a(new bb(new bb.a()
      {
        public final void a(final com.tencent.mm.network.e paramAnonymouse)
        {
          GMTrace.i(3565359726592L, 26564);
          if (paramAnonymouse == null)
          {
            g.oSF.a(405L, 52L, 1L, true);
            Assert.assertTrue("updater invalid assert", false);
          }
          ap.getNotification().cancel(34);
          v.i("MicroMsg.Updater", "go to update");
          if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted"))
          {
            v.e("MicroMsg.Updater", "no sdcard.");
            g.oSF.a(405L, 53L, 1L, true);
            Updater.b(Updater.this);
          }
          int i = paramString.bHy();
          com.tencent.mm.b.i locali = com.tencent.mm.b.i.bc(paramString.bHA());
          String str = i.dS(Updater.this.getContext());
          Object localObject = null;
          if (locali != null) {
            localObject = locali.bb(str);
          }
          if (localObject == null) {}
          for (long l = i;; l = ((i.a)localObject).size + i)
          {
            if (!com.tencent.mm.compatible.util.f.G(l))
            {
              v.e("MicroMsg.Updater", "no enough space.");
              g.oSF.a(405L, 54L, 1L, true);
              Updater.b(Updater.this);
            }
            if ((com.tencent.mm.sdk.platformtools.f.fuP & 0x1) != 0)
            {
              v.i("MicroMsg.Updater", "channel pack, not silence download.");
              g.oSF.a(405L, 55L, 1L, true);
              Updater.b(Updater.this);
            }
            if ((Updater.c(Updater.this) != 2) || (Updater.d(Updater.this))) {
              break;
            }
            localObject = i.Nv();
            if ((com.tencent.mm.sandbox.monitor.c.DC(paramString.bHz()) == null) || (bf.mA((String)localObject)) || (!((String)localObject).equals(paramString.bHz()))) {
              break;
            }
            v.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", new Object[] { localObject });
            g.oSF.a(405L, 56L, 1L, true);
            GMTrace.o(3565359726592L, 26564);
            return;
          }
          localObject = paramString.bCj();
          if ((localObject != null) && (((abx)localObject).tFV != 0) && (!bf.mA(((abx)localObject).tFW)))
          {
            paramAnonymouse = ((abx)localObject).tFW;
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymouse);
            ((Intent)localObject).putExtra("showShare", false);
            ((Intent)localObject).putExtra("show_bottom", false);
            com.tencent.mm.bb.d.b(Updater.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            i.bHS();
            g.oSF.a(405L, 57L, 1L, true);
            GMTrace.o(3565359726592L, 26564);
            return;
          }
          if (Updater.e(Updater.this))
          {
            v.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
            g.oSF.a(405L, 58L, 1L, true);
            ap.vd().a(725, Updater.a(Updater.this, new com.tencent.mm.y.e()
            {
              public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, k paramAnonymous2k)
              {
                GMTrace.i(3594887626752L, 26784);
                ap.vd().b(221, Updater.f(Updater.this));
                Updater.a(Updater.this, null);
                if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                {
                  paramAnonymous2String = (s)paramAnonymous2k;
                  String str;
                  if (((aaw)paramAnonymous2String.hRy.hrS.hsa).jMq == 0)
                  {
                    paramAnonymous2String = ((aax)paramAnonymous2String.hRy.hrT.hsa).oog;
                    if (!bf.mA(paramAnonymous2String))
                    {
                      paramAnonymous2String = bg.q(paramAnonymous2String, "resourcecontrolinfo");
                      if (paramAnonymous2String != null)
                      {
                        paramAnonymous2k = (String)paramAnonymous2String.get(".resourcecontrolinfo.enableupdate");
                        str = (String)paramAnonymous2String.get(".resourcecontrolinfo.expiredtime");
                        v.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate getDisableUpdateTime values[%s]", new Object[] { paramAnonymous2String });
                        if (bf.getInt(paramAnonymous2k, 1) != 0) {}
                      }
                    }
                  }
                  for (long l1 = bf.getLong(str, 0L);; l1 = 0L)
                  {
                    long l2 = System.currentTimeMillis() / 1000L;
                    if (l1 <= l2) {
                      break;
                    }
                    v.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
                    g.oSF.a(405L, 0L, 1L, true);
                    GMTrace.o(3594887626752L, 26784);
                    return;
                  }
                }
                v.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
                g.oSF.a(405L, 59L, 1L, true);
                paramAnonymous2String = new Intent(Updater.this.getContext(), UpdaterService.class);
                Updater.a(Updater.this, paramAnonymous2String, paramAnonymouse, Updater.3.this.upy);
                paramAnonymous2String.putExtra("intent_extra_run_in_foreground", true);
                paramAnonymous2String.putExtra("intent_extra_download_mode", 2);
                Updater.this.getContext().startService(paramAnonymous2String);
                GMTrace.o(3594887626752L, 26784);
              }
            }));
            ap.vd().a(new s(), 0);
            com.tencent.mm.q.c.uk().s(262145, true);
            com.tencent.mm.pluginsdk.model.app.a.bCJ();
            GMTrace.o(3565359726592L, 26564);
            return;
          }
          v.i("MicroMsg.Updater", "gonna start AppUpdaterUI");
          localObject = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
          Updater.a(Updater.this, (Intent)localObject, paramAnonymouse, paramString);
          v.i("MicroMsg.Updater", "current updateType : %s", new Object[] { Integer.valueOf(Updater.c(Updater.this)) });
          if (Updater.c(Updater.this) == 1)
          {
            ((Intent)localObject).putExtra("intent_extra_download_mode", 0);
            g.oSF.a(405L, 60L, 1L, true);
          }
          for (;;)
          {
            Updater.this.getContext().startActivity((Intent)localObject);
            break;
            g.oSF.a(405L, 61L, 1L, true);
            ((Intent)localObject).putExtra("intent_extra_download_mode", 1);
          }
        }
      }), 0);
      onStop();
      GMTrace.o(3583613337600L, 26700);
      return;
    }
    g.oSF.a(405L, 62L, 1L, true);
    if (this.upq != null)
    {
      paramString = this.upq;
      if (paramString.joQ != null) {
        paramString.joQ.setVisibility(8);
      }
      paramString = (TextView)this.upq.findViewById(R.h.cke);
      if ((paramInt1 != 4) || (paramInt2 != -18)) {
        break label272;
      }
      paramk = new bd();
      com.tencent.mm.sdk.b.a.uql.m(paramk);
      paramk = ap.vd();
      paramString = new com.tencent.mm.y.e()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk)
        {
          GMTrace.i(18997579874304L, 141543);
          ap.vd().b(922, Updater.g(Updater.this));
          Updater.a(Updater.this, null);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = ((lb)((b)paramAnonymousk.hst).hrT.hsa).tpL;
            if ((paramAnonymousString != null) && (paramAnonymousString.ued == 3))
            {
              paramAnonymousk = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
              Updater.a(paramAnonymousk, new e(paramAnonymousString));
              Updater.this.getContext().startActivity(paramAnonymousk);
              if (Updater.h(Updater.this) != null) {
                Updater.h(Updater.this).cancel();
              }
              Updater.this.onStop();
              GMTrace.o(18997579874304L, 141543);
              return;
            }
            Updater.h(Updater.this).findViewById(R.h.ckd).setVisibility(8);
            if (paramString != null)
            {
              g.oSF.a(405L, 63L, 1L, true);
              paramString.setText(R.l.eYT);
            }
            GMTrace.o(18997579874304L, 141543);
            return;
          }
          Updater.h(Updater.this).findViewById(R.h.ckd).setVisibility(8);
          if (paramString != null)
          {
            g.oSF.a(405L, 63L, 1L, true);
            paramString.setText(R.l.eYT);
          }
          GMTrace.o(18997579874304L, 141543);
        }
      };
      this.upv = paramString;
      paramk.a(922, paramString);
    }
    for (;;)
    {
      i.bHW();
      cancel();
      GMTrace.o(3583613337600L, 26700);
      return;
      label272:
      if (paramString != null)
      {
        g.oSF.a(405L, 64L, 1L, true);
        paramString.setText(R.l.eYJ);
        com.tencent.mm.pluginsdk.ui.d.h.d(paramString, 1);
      }
    }
  }
  
  public final void ac(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(3584015990784L, 26703);
    v.i("MicroMsg.Updater", "summerupdate begin update routine, type=" + paramInt);
    this.uok = paramInt;
    this.upt = paramBoolean;
    g.oSF.a(405L, 44L, 1L, true);
    com.tencent.mm.sandbox.a.a locala = new com.tencent.mm.sandbox.a.a(paramInt);
    ap.vd().a(locala, 0);
    GMTrace.o(3584015990784L, 26703);
  }
  
  public final void onStop()
  {
    GMTrace.i(3582942248960L, 26695);
    g.oSF.a(405L, 43L, 1L, true);
    cancel();
    GMTrace.o(3582942248960L, 26695);
  }
  
  public final void update(int paramInt)
  {
    GMTrace.i(3583881773056L, 26702);
    ac(paramInt, false);
    GMTrace.o(3583881773056L, 26702);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/updater/Updater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */