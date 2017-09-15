package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.LocationManager;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.provider.Settings.Secure;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.au.e.1;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.z;
import com.tencent.mm.booter.z.a;
import com.tencent.mm.e.a.cj;
import com.tencent.mm.e.a.fl;
import com.tencent.mm.e.a.im;
import com.tencent.mm.e.a.l;
import com.tencent.mm.e.a.mi;
import com.tencent.mm.e.a.nb;
import com.tencent.mm.e.a.pt;
import com.tencent.mm.e.a.qf;
import com.tencent.mm.e.a.qs;
import com.tencent.mm.e.a.ss;
import com.tencent.mm.e.a.w;
import com.tencent.mm.kernel.i.a;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.l.aa;
import com.tencent.mm.pluginsdk.l.l;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.s;
import com.tencent.mm.u.af;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.ui.base.h.a;
import java.util.Map;

public final class MMAppMgr
{
  public static StringBuffer uSs;
  private static long uSt;
  public long hSI;
  public String uSu;
  public Receiver uSv;
  public boolean uSw;
  public boolean uSx;
  public final ai uSy;
  private final ai uSz;
  
  public MMAppMgr()
  {
    GMTrace.i(1609404776448L, 11991);
    this.uSw = false;
    this.uSx = false;
    this.uSy = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(2850381889536L, 21237);
        Object localObject = bf.bk(aa.getContext());
        if ((localObject != null) && (((String)localObject).toLowerCase().startsWith(aa.getPackageName())))
        {
          v.i("MicroMsg.MMAppMgr", "onTimerExpired, top activity belongs to mm, skip kill tools");
          GMTrace.o(2850381889536L, 21237);
          return false;
        }
        v.i("MicroMsg.MMAppMgr", "onTimerExpired, kill tools process");
        localObject = new Intent();
        ((Intent)localObject).setComponent(new ComponentName(d.g.uMO, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        ((Intent)localObject).putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        aa.getContext().sendBroadcast((Intent)localObject);
        GMTrace.o(2850381889536L, 21237);
        return false;
      }
    }, true);
    this.uSz = new ai(Looper.getMainLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(3012785340416L, 22447);
        if (MMAppMgr.this.uSx == MMAppMgr.this.uSw)
        {
          v.d("MicroMsg.MMAppMgr", "status not changed, cur=" + MMAppMgr.this.uSx);
          GMTrace.o(3012785340416L, 22447);
          return true;
        }
        if (ap.yQ())
        {
          GMTrace.o(3012785340416L, 22447);
          return false;
        }
        MMAppMgr.this.uSx = MMAppMgr.this.uSw;
        BaseEvent.onForeground(MMAppMgr.this.uSx);
        if (MMAppMgr.this.uSx)
        {
          v.w("MicroMsg.MMAppMgr", "[ACTIVATED MODE]");
          WorkerProfile.an(false);
          ap.vd().aX(true);
          if ((ap.zb()) && (com.tencent.mm.kernel.h.vG().gXf) && (!ap.uP()))
          {
            localObject1 = z.gKu;
            if (!((z)localObject1).hasInit)
            {
              ((z)localObject1).hasInit = true;
              Object localObject2 = com.tencent.mm.u.c.c.Az().dX("100066");
              if (((com.tencent.mm.storage.c)localObject2).isValid())
              {
                localObject2 = ((com.tencent.mm.storage.c)localObject2).bKA();
                ((z)localObject1).gKB = u.getInt((String)((Map)localObject2).get("maxCacheCount"), 20);
                ((z)localObject1).gKC = u.getInt((String)((Map)localObject2).get("maxCacheHours"), 24);
              }
              localObject2 = com.tencent.mm.u.c.c.Az().dX("100058");
              if (((com.tencent.mm.storage.c)localObject2).isValid())
              {
                localObject2 = ((com.tencent.mm.storage.c)localObject2).bKA();
                ((z)localObject1).gKD = u.getInt((String)((Map)localObject2).get("cacheLogCount"), 30);
                ((z)localObject1).gKE = u.getInt((String)((Map)localObject2).get("maxCacheTime"), 10800);
              }
              v.i("MicroMsg.StayTimeReport", "initAbtestChattingArg appMaxCnt:%d, appMaxHour:%d, chattingMaxCnt:%d, chattingMaxSeconds:%d", new Object[] { Integer.valueOf(((z)localObject1).gKB), Integer.valueOf(((z)localObject1).gKC), Integer.valueOf(((z)localObject1).gKD), Integer.valueOf(((z)localObject1).gKE) });
            }
            com.tencent.mm.modelsimple.f.bn(true);
            q.Hz().gg(3);
            ap.vd().a(new j(), 0);
            ap.vL().D(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(2531480567808L, 18861);
                com.tencent.mm.modelvoice.m.LB().run();
                com.tencent.mm.modelvideo.o.Lb().run();
                com.tencent.mm.ah.n.GR().run();
                an.bDe().run();
                if (ag.a.hlD != null) {
                  ag.a.hlD.yK();
                }
                com.tencent.mm.sdk.b.a.uql.m(new pt());
                ap.yY();
                com.tencent.mm.u.c.wQ().b(null);
                GMTrace.o(2531480567808L, 18861);
              }
            });
            bm.zN().c(19, new Object[] { Integer.valueOf(1) });
            localObject1 = com.tencent.mm.au.e.JS();
            v.d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
            ((com.tencent.mm.au.e)localObject1).hCD.jR(true);
            com.tencent.mm.ah.n.GV().aX(true);
            if (l.aa.sAa != null) {
              l.aa.sAa.bmL();
            }
            localObject1 = new l();
            ((l)localObject1).fCv.fCw = true;
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
            com.tencent.mm.modelstat.n.gH(4);
            com.tencent.mm.modelstat.n.gH(3);
            com.tencent.mm.modelstat.n.bq(true);
            localObject1 = new qf();
            ((qf)localObject1).fXa.fXb = true;
            ((qf)localObject1).fXa.scene = 1;
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
            localObject1 = new ss();
            ((ss)localObject1).gau.fEx = 5;
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
          }
          ap.vd().aW(false);
          aa.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", false).commit();
          if (!MMAppMgr.this.uSy.bJg()) {
            MMAppMgr.this.uSy.KI();
          }
          GMTrace.o(3012785340416L, 22447);
          return true;
        }
        v.w("MicroMsg.MMAppMgr", "[DEACTIVATED MODE]");
        WorkerProfile.an(true);
        MMAppMgr.this.hSI = bf.NB();
        MMAppMgr.this.uSu = "desktop";
        Object localObject1 = new l();
        ((l)localObject1).fCv.fCw = false;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
        ap.vd().aX(false);
        boolean bool;
        if (ap.zb())
        {
          com.tencent.mm.kernel.h.vJ();
          if (com.tencent.mm.kernel.h.vG().gXf)
          {
            com.tencent.mm.bc.a.NC(com.tencent.mm.bc.a.bGI());
            localObject1 = com.tencent.mm.au.e.JS();
            Looper.myQueue().addIdleHandler(new e.1((com.tencent.mm.au.e)localObject1));
            localObject1 = new mi();
            ((mi)localObject1).fTu.state = 0;
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
            localObject1 = new qs();
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
            localObject1 = new com.tencent.mm.e.a.e();
            ((com.tencent.mm.e.a.e)localObject1).fCd.fCe = false;
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
            localObject1 = new nb();
            ((nb)localObject1).fUa.fCg = false;
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
            com.tencent.mm.ah.n.GV().aX(false);
            v.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod]");
            ap.yY();
            localObject1 = com.tencent.mm.u.c.vr().get(327808, null);
            if (localObject1 != null) {
              break label1117;
            }
            bool = true;
          }
        }
        for (;;)
        {
          v.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod] needToStat:%s", new Object[] { String.valueOf(bool) });
          if (bool) {}
          try
          {
            localObject1 = Settings.Secure.getString(aa.getContext().getContentResolver(), "default_input_method");
            com.tencent.mm.plugin.report.service.g.oSF.A(11375, bf.mz((String)localObject1));
            ap.yY();
            com.tencent.mm.u.c.vr().set(327808, Long.valueOf(System.currentTimeMillis()));
            localObject1 = new cj();
            ((cj)localObject1).fFG.state = 0;
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
            localObject1 = new ss();
            ((ss)localObject1).gau.fEx = 3;
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
            com.tencent.mm.modelsimple.f.bn(false);
            com.tencent.mm.modelstat.n.bq(false);
            if (!MMAppMgr.this.uSy.bJg()) {
              MMAppMgr.this.uSy.KI();
            }
            bool = bf.ba(aa.getContext(), aa.getPackageName() + ":tools");
            v.i("MicroMsg.MMAppMgr", "before kill tools, tools is running : %b", new Object[] { Boolean.valueOf(bool) });
            if (!bool) {
              break;
            }
            MMAppMgr.this.uSy.v(60000L, 60000L);
            break;
            label1117:
            if (bf.mA(localObject1.toString()))
            {
              bool = true;
            }
            else
            {
              long l = bf.PY(localObject1.toString());
              if (System.currentTimeMillis() - l >= 604800000L) {
                bool = true;
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              v.e("MicroMsg.MMAppMgr", "[oneliang][inputMethodStat]exception:" + localException.getMessage());
            }
            bool = false;
          }
        }
      }
    }, false);
    GMTrace.o(1609404776448L, 11991);
  }
  
  private static String SF(String paramString)
  {
    GMTrace.i(1609807429632L, 11994);
    int i = paramString.length();
    int j = 0;
    i -= 1;
    while (i >= 0)
    {
      int k = j;
      if (paramString.charAt(i) == '|') {
        k = j + 1;
      }
      if (k == 3) {
        break;
      }
      i -= 1;
      j = k;
    }
    paramString = paramString.substring(i + 1);
    GMTrace.o(1609807429632L, 11994);
    return paramString;
  }
  
  public static void Sh()
  {
    GMTrace.i(1610210082816L, 11997);
    ks(true);
    GMTrace.o(1610210082816L, 11997);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(1610612736000L, 12000);
    com.tencent.mm.kernel.h.vJ().gYz.gYW.ak(paramBoolean);
    BaseEvent.onSingalCrash(0);
    MMNativeJpeg.Destroy();
    com.tencent.mm.booter.o.oA();
    if ((ap.vd() != null) && (ap.vd().hsI != null)) {
      ap.vd().hsI.bb(paramBoolean);
    }
    Intent localIntent = new Intent().setClass(paramContext, LauncherUI.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("absolutely_exit_pid", Process.myPid());
    localIntent.putExtra("kill_service", paramBoolean);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
    GMTrace.o(1610612736000L, 12000);
  }
  
  public static boolean a(Context paramContext, int paramInt, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    GMTrace.i(1611283824640L, 12005);
    View localView = View.inflate(paramContext, R.i.djX, null);
    Object localObject = (CheckBox)localView.findViewById(R.h.cmT);
    ((CheckBox)localObject).setText(paramContext.getString(R.l.eDk));
    ((CheckBox)localObject).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        GMTrace.i(2849442365440L, 21230);
        ap.yY();
        paramAnonymousCompoundButton = com.tencent.mm.u.c.vr();
        if (!paramAnonymousBoolean) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          paramAnonymousCompoundButton.set(16385, Boolean.valueOf(paramAnonymousBoolean));
          GMTrace.o(2849442365440L, 21230);
          return;
        }
      }
    });
    localView.findViewById(R.h.cmV).setVisibility(8);
    localObject = (TextView)localView.findViewById(R.h.cmU);
    switch (paramInt)
    {
    case 2: 
    default: 
      ((TextView)localObject).setText(R.l.eDq);
      paramInt = 1;
    }
    while (paramInt != 0)
    {
      paramContext = new h.a(paramContext);
      paramContext.zR(R.l.dIG);
      paramContext.kH(false);
      paramContext.db(localView);
      paramContext.zU(R.l.eDn).a(paramOnClickListener1);
      paramContext.zV(R.l.eDk).b(paramOnClickListener2);
      paramContext.WD().show();
      GMTrace.o(1611283824640L, 12005);
      return true;
      ((TextView)localObject).setText(R.l.eDq);
      paramInt = 0;
      continue;
      ((TextView)localObject).setText(R.l.eDj);
      paramInt = 1;
    }
    GMTrace.o(1611283824640L, 12005);
    return false;
  }
  
  public static void aa(Activity paramActivity)
  {
    GMTrace.i(1610881171456L, 12002);
    com.tencent.mm.bb.d.b(paramActivity, "whatsnew", ".ui.WhatsNewUI", new Intent(), 57005);
    GMTrace.o(1610881171456L, 12002);
  }
  
  public static void ai(Context paramContext)
  {
    GMTrace.i(1610478518272L, 11999);
    a(paramContext, true);
    GMTrace.o(1610478518272L, 11999);
  }
  
  public static com.tencent.mm.ui.base.h aj(Context paramContext)
  {
    GMTrace.i(1611418042368L, 12006);
    try
    {
      localObject = (LocationManager)paramContext.getSystemService("location");
      if (al.isWifi(paramContext))
      {
        boolean bool = ((LocationManager)localObject).isProviderEnabled("gps");
        if (bool)
        {
          GMTrace.o(1611418042368L, 12006);
          return null;
        }
      }
    }
    catch (Exception paramContext)
    {
      v.printErrStackTrace("MicroMsg.MMAppMgr", paramContext, "showLbsTipsAlert error", new Object[0]);
      GMTrace.o(1611418042368L, 12006);
      return null;
    }
    ap.yY();
    Object localObject = (Boolean)com.tencent.mm.u.c.vr().get(4105, Boolean.valueOf(false));
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      GMTrace.o(1611418042368L, 12006);
      return null;
    }
    localObject = View.inflate(paramContext, R.i.dgB, null);
    ((CheckBox)((View)localObject).findViewById(R.h.caQ)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        GMTrace.i(2076482469888L, 15471);
        if (paramAnonymousBoolean)
        {
          ap.yY();
          com.tencent.mm.u.c.vr().set(4105, Boolean.valueOf(true));
          GMTrace.o(2076482469888L, 15471);
          return;
        }
        ap.yY();
        com.tencent.mm.u.c.vr().set(4105, Boolean.valueOf(false));
        GMTrace.o(2076482469888L, 15471);
      }
    });
    DialogInterface.OnClickListener local7 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(1882269417472L, 14024);
        try
        {
          paramAnonymousDialogInterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
          this.val$context.startActivity(paramAnonymousDialogInterface);
          GMTrace.o(1882269417472L, 14024);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          v.printErrStackTrace("MicroMsg.MMAppMgr", paramAnonymousDialogInterface, "showLbsTipsAlert", new Object[0]);
          GMTrace.o(1882269417472L, 14024);
        }
      }
    };
    paramContext = new h.a(paramContext);
    paramContext.zR(R.l.eCT);
    paramContext.db((View)localObject);
    paramContext.zU(R.l.dIv).a(local7);
    paramContext.zV(R.l.dHq);
    paramContext = paramContext.WD();
    paramContext.show();
    GMTrace.o(1611418042368L, 12006);
    return paramContext;
  }
  
  public static void bPX()
  {
    GMTrace.i(1609673211904L, 11993);
    StringBuffer localStringBuffer = new StringBuffer(800);
    if (uSs == null)
    {
      uSs = localStringBuffer;
      uSt = bf.Nz();
      GMTrace.o(1609673211904L, 11993);
      return;
    }
    String str = uSs.toString();
    localStringBuffer.append(SF(str));
    uSs = localStringBuffer;
    v.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", new Object[] { str });
    com.tencent.mm.plugin.report.service.g.oSF.A(10508, "1," + uSt + "," + str);
    uSt = bf.Nz();
    GMTrace.o(1609673211904L, 11993);
  }
  
  public static void cancelNotification(String paramString)
  {
    GMTrace.i(1609941647360L, 11995);
    ap.getNotification().cancelNotification(paramString);
    GMTrace.o(1609941647360L, 11995);
  }
  
  public static void d(final Activity paramActivity)
  {
    GMTrace.i(1611149606912L, 12004);
    final Object localObject = paramActivity.getSharedPreferences(aa.bIN(), 0);
    boolean bool = ((SharedPreferences)localObject).getBoolean("gprs_alert", true);
    com.tencent.mm.sdk.platformtools.f.uqH &= bool;
    if (bool)
    {
      View localView = View.inflate(paramActivity, R.i.dfp, null);
      CheckBox localCheckBox = (CheckBox)localView.findViewById(R.h.bVr);
      localObject = com.tencent.mm.ui.base.g.a(paramActivity, false, null, localView, paramActivity.getString(R.l.dXc), paramActivity.getString(R.l.ezc), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(1609270558720L, 11990);
          if (this.uSB.isChecked())
          {
            SharedPreferences.Editor localEditor = localObject.edit();
            localEditor.putBoolean("gprs_alert", false);
            localEditor.commit();
          }
          com.tencent.mm.sdk.platformtools.f.uqH = false;
          paramAnonymousDialogInterface.dismiss();
          MMAppMgr.eA(paramActivity);
          GMTrace.o(1609270558720L, 11990);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3012516904960L, 22445);
          paramAnonymousDialogInterface.dismiss();
          MMAppMgr.a(this.ihI, true);
          GMTrace.o(3012516904960L, 22445);
        }
      });
      if (localObject == null)
      {
        GMTrace.o(1611149606912L, 12004);
        return;
      }
      ((Dialog)localObject).setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(2859374477312L, 21304);
          this.ihI.onKeyDown(4, new KeyEvent(0, 4));
          GMTrace.o(2859374477312L, 21304);
        }
      });
    }
    GMTrace.o(1611149606912L, 12004);
  }
  
  public static void eA(Context paramContext)
  {
    GMTrace.i(1611015389184L, 12003);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(aa.bIN(), 0);
    if (!localSharedPreferences.getBoolean("Main_ShortCut", false))
    {
      Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramContext.getString(R.l.evY));
      localIntent1.putExtra("duplicate", false);
      Intent localIntent2 = new Intent("android.intent.action.MAIN");
      localIntent2.addCategory("android.intent.category.LAUNCHER");
      localIntent2.setComponent(new ComponentName(paramContext.getPackageName(), aa.bIM() + ".ui.LauncherUI"));
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramContext, R.g.icon));
      paramContext.sendBroadcast(localIntent1);
      paramContext = localSharedPreferences.edit();
      paramContext.putBoolean("Main_ShortCut", true);
      paramContext.commit();
    }
    GMTrace.o(1611015389184L, 12003);
  }
  
  public static void ks(boolean paramBoolean)
  {
    GMTrace.i(1610344300544L, 11998);
    v.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), bf.bJP(), Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.report.b.d.o(2, 0, "");
    if (paramBoolean)
    {
      localObject = aa.getContext();
      if (localObject != null)
      {
        ((Context)localObject).stopService(new Intent((Context)localObject, CoreService.class));
        ((Context)localObject).stopService(new Intent((Context)localObject, NotifyReceiver.NotifyService.class));
        ((Context)localObject).stopService(new Intent((Context)localObject, CacheService.class));
        ((Context)localObject).stopService(new Intent().setClassName((Context)localObject, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"));
      }
    }
    Object localObject = new w();
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    localObject = new im();
    ((im)localObject).fOb.status = 0;
    ((im)localObject).fOb.fOc = 2;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    bPX();
    if (paramBoolean)
    {
      ap.eb(bf.bJP().toString());
      com.tencent.mm.kernel.h.vJ().releaseAll();
    }
    v.appenderClose();
    BaseEvent.onSingalCrash(0);
    Process.killProcess(Process.myPid());
    GMTrace.o(1610344300544L, 11998);
  }
  
  public static boolean oK()
  {
    GMTrace.i(1610746953728L, 12001);
    if (com.tencent.mm.protocal.d.sXk)
    {
      GMTrace.o(1610746953728L, 12001);
      return false;
    }
    if (!com.tencent.mm.bb.d.NB("whatsnew"))
    {
      v.i("MicroMsg.MMAppMgr", "plugin cannot load");
      GMTrace.o(1610746953728L, 12001);
      return false;
    }
    if (!com.tencent.mm.plugin.ipcall.d.aDF())
    {
      GMTrace.o(1610746953728L, 12001);
      return false;
    }
    GMTrace.o(1610746953728L, 12001);
    return true;
  }
  
  public static void ox()
  {
    GMTrace.i(1610075865088L, 11996);
    ap.getNotification().ox();
    GMTrace.o(1610075865088L, 11996);
  }
  
  public final void e(Intent paramIntent, boolean paramBoolean)
  {
    GMTrace.i(1609538994176L, 11992);
    if (paramBoolean)
    {
      com.tencent.mm.x.m.Bw();
      localObject1 = new mi();
      ((mi)localObject1).fTu.state = 1;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new com.tencent.mm.e.a.e();
      ((com.tencent.mm.e.a.e)localObject1).fCd.fCe = true;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new nb();
      ((nb)localObject1).fUa.fCg = true;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new cj();
      ((cj)localObject1).fFG.state = 1;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
    }
    Object localObject1 = new fl();
    ((fl)localObject1).fJS.fCw = paramBoolean;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
    this.uSw = paramBoolean;
    paramIntent = paramIntent.getStringExtra("classname");
    Object localObject2;
    if (bf.mA(paramIntent))
    {
      paramIntent = "";
      if (!paramBoolean) {
        break label354;
      }
      localObject2 = z.gKu;
      if (((z)localObject2).gKA == -1L)
      {
        if (((z)localObject2).gKv.yv(3) == 0) {
          ((z)localObject2).gKv.setLong(1, u.Nz());
        }
        ((z)localObject2).gKA = u.Nz();
        if (((z)localObject2).gKw != null) {
          break label341;
        }
        localObject1 = "null";
        label241:
        v.i("MicroMsg.StayTimeReport", "onAppResume chatUser:%s, class:%s", new Object[] { localObject1, paramIntent });
        if (((z)localObject2).gKw != null)
        {
          ((z)localObject2).gKx = u.NB();
          if ((paramIntent != null) && (paramIntent.contains("WebViewUI"))) {
            ((z)localObject2).gKy = u.NB();
          }
        }
      }
    }
    for (;;)
    {
      this.uSz.v(800L, 800L);
      GMTrace.o(1609538994176L, 11992);
      return;
      paramIntent = paramIntent.substring(paramIntent.lastIndexOf(".") + 1);
      break;
      label341:
      localObject1 = ((z)localObject2).gKw.gKF;
      break label241;
      label354:
      localObject1 = z.gKu;
      if (((z)localObject1).gKA != -1L)
      {
        long l = u.Nz();
        localObject2 = (String)((z)localObject1).gKv.get(2, "");
        localObject2 = (String)localObject2 + ((z)localObject1).gKA + "|" + l + "#";
        ((z)localObject1).gKv.set(2, localObject2);
        int i = ((z)localObject1).gKv.yv(3) + 1;
        ((z)localObject1).gKv.setInt(3, i);
        v.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", new Object[] { Integer.valueOf(i), Long.valueOf(((z)localObject1).gKA), Long.valueOf(l) });
        ((z)localObject1).gKA = -1L;
        if ((u.az(((z)localObject1).gKv.getLong(1, 0L)) > 3600L * ((z)localObject1).gKC) || (i > ((z)localObject1).gKB))
        {
          com.tencent.mm.plugin.report.service.g.oSF.A(13110, (String)localObject2);
          v.i("MicroMsg.StayTimeReport", "report appStayTime:%s", new Object[] { localObject2 });
          ((z)localObject1).gKv.set(2, "");
          ((z)localObject1).gKv.setInt(3, 0);
        }
        if (((z)localObject1).gKw != null)
        {
          localObject2 = ((z)localObject1).gKw;
          ((z.a)localObject2).time += u.aB(((z)localObject1).gKx) / 1000L;
          if ((paramIntent != null) && (paramIntent.contains("WebViewUI")))
          {
            paramIntent = ((z)localObject1).gKw;
            paramIntent.gKJ = ((int)(paramIntent.gKJ + u.aB(((z)localObject1).gKy) / 1000L));
          }
          v.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", new Object[] { Long.valueOf(((z)localObject1).gKw.time) });
        }
      }
    }
  }
  
  public final void f(Intent paramIntent, boolean paramBoolean)
  {
    GMTrace.i(16013517127680L, 119310);
    paramIntent = paramIntent.getStringExtra("classname");
    if (bf.mA(paramIntent))
    {
      v.i("MicroMsg.MMAppMgr", "dealWithClickStream className is null, broadcast should set this intent flag");
      GMTrace.o(16013517127680L, 119310);
      return;
    }
    paramIntent = paramIntent.substring(paramIntent.lastIndexOf(".") + 1);
    com.tencent.mm.sdk.a.b.OZ(paramIntent);
    if (uSs == null)
    {
      uSs = new StringBuffer(800);
      uSt = bf.Nz();
      uSs.append("start:");
      uSs.append(bf.Nz());
      uSs.append("|");
    }
    if (paramBoolean)
    {
      if ("desktop".equals(this.uSu))
      {
        uSs.append("desktop:");
        uSs.append(bf.aB(this.hSI) + 800L);
        uSs.append("|");
      }
      this.hSI = bf.NB();
      this.uSu = paramIntent;
    }
    for (;;)
    {
      com.tencent.mm.e.a.f localf = new com.tencent.mm.e.a.f();
      localf.fCf.fCg = paramBoolean;
      localf.fCf.className = paramIntent;
      com.tencent.mm.sdk.b.a.uql.m(localf);
      v.i("MicroMsg.MMAppMgr", "dkact classname %s, isAcitvity %b", new Object[] { paramIntent, Boolean.valueOf(paramBoolean) });
      GMTrace.o(16013517127680L, 119310);
      return;
      uSs.append(this.uSu + ":");
      uSs.append(bf.aB(this.hSI));
      uSs.append("|");
    }
  }
  
  @JgClassChecked(author=20, fComment="checked", lastDate="20141015", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
  public static class Receiver
    extends BroadcastReceiver
  {
    private MMAppMgr appMgr;
    
    public Receiver()
    {
      GMTrace.i(2071382196224L, 15433);
      GMTrace.o(2071382196224L, 15433);
    }
    
    public Receiver(MMAppMgr paramMMAppMgr)
    {
      GMTrace.i(2071516413952L, 15434);
      this.appMgr = paramMMAppMgr;
      GMTrace.o(2071516413952L, 15434);
    }
    
    private static boolean ah(Intent paramIntent)
    {
      GMTrace.i(2071650631680L, 15435);
      if (!paramIntent.getBooleanExtra("process_is_mm", false))
      {
        GMTrace.o(2071650631680L, 15435);
        return true;
      }
      if (paramIntent.getIntExtra("process_id", 0) == Process.myPid())
      {
        GMTrace.o(2071650631680L, 15435);
        return true;
      }
      GMTrace.o(2071650631680L, 15435);
      return false;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      GMTrace.i(2071784849408L, 15436);
      if (paramIntent == null)
      {
        GMTrace.o(2071784849408L, 15436);
        return;
      }
      if ((ap.yQ()) || (ap.yS()))
      {
        GMTrace.o(2071784849408L, 15436);
        return;
      }
      String str = paramIntent.getAction();
      if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(str))
      {
        if (!ah(paramIntent))
        {
          v.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
          GMTrace.o(2071784849408L, 15436);
          return;
        }
        this.appMgr.f(paramIntent, true);
        this.appMgr.e(paramIntent, true);
        GMTrace.o(2071784849408L, 15436);
        return;
      }
      if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(str))
      {
        if (!ah(paramIntent))
        {
          v.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
          GMTrace.o(2071784849408L, 15436);
          return;
        }
        com.tencent.mm.booter.o.qg();
        this.appMgr.f(paramIntent, false);
        this.appMgr.e(paramIntent, false);
        if ((MMAppMgr.uSs != null) && (MMAppMgr.uSs.length() > 800)) {
          new ad(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(2076750905344L, 15473);
              MMAppMgr.bPX();
              GMTrace.o(2076750905344L, 15473);
            }
          });
        }
        GMTrace.o(2071784849408L, 15436);
        return;
      }
      if ("com.tencent.mm.ui.ACTION_ABTEST".equals(str))
      {
        paramContext = paramIntent.getStringExtra("content");
        if (bf.mA(paramContext)) {
          v.i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
        }
        for (;;)
        {
          if ((MMAppMgr.uSs != null) && (MMAppMgr.uSs.length() > 800)) {
            new ad(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(1703222968320L, 12690);
                MMAppMgr.bPX();
                GMTrace.o(1703222968320L, 12690);
              }
            });
          }
          GMTrace.o(2071784849408L, 15436);
          return;
          if (MMAppMgr.uSs == null) {
            MMAppMgr.uSs = new StringBuffer(800);
          }
          MMAppMgr.uSs.append(paramContext);
          v.i("MicroMsg.MMAppMgr", "cpan content: %s", new Object[] { paramContext });
        }
      }
      if (paramIntent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE"))
      {
        int i;
        if (!paramIntent.getBooleanExtra("intent_extra_is_silence_stat", false))
        {
          i = paramIntent.getIntExtra("intent_extra_opcode", 0);
          v.d("MicroMsg.MMAppMgr", "incremental_update = " + i);
          if (ap.zb()) {
            com.tencent.mm.plugin.report.service.g.oSF.i(10328, new Object[] { Integer.valueOf(i) });
          }
        }
        long l1;
        long l2;
        label706:
        for (;;)
        {
          l1 = paramIntent.getLongExtra("intent_extra_flow_stat_upstream", 0L);
          l2 = paramIntent.getLongExtra("intent_extra_flow_stat_downstream", 0L);
          boolean bool = paramIntent.getBooleanExtra("intent_extra_flow_stat_is_wifi", false);
          if ((!ap.zb()) || ((l1 == 0L) && (l2 == 0L))) {
            break label718;
          }
          v.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
          if (!bool) {
            break;
          }
          com.tencent.mm.modelstat.m.s((int)l2, (int)l1, 0);
          GMTrace.o(2071784849408L, 15436);
          return;
          i = paramIntent.getIntExtra("intent_extra_opcode", 0);
          v.d("MicroMsg.MMAppMgr", "silence_update_stat = " + i);
          if (ap.zb())
          {
            if (i == 2)
            {
              int j = paramIntent.getIntExtra("intent_extra_install_dialog_times", 0);
              com.tencent.mm.plugin.report.service.g.oSF.i(11147, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            for (;;)
            {
              if ((i != 4) || (com.tencent.mm.platformtools.t.Nw() != 4)) {
                break label706;
              }
              paramContext = com.tencent.mm.pluginsdk.model.app.a.bCI();
              if (paramContext == null) {
                break;
              }
              paramContext.bCK();
              break;
              com.tencent.mm.plugin.report.service.g.oSF.i(11147, new Object[] { Integer.valueOf(i) });
            }
          }
        }
        com.tencent.mm.modelstat.m.t((int)l2, (int)l1, 0);
        label718:
        GMTrace.o(2071784849408L, 15436);
        return;
      }
      if (paramIntent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP"))
      {
        MMAppMgr.a(paramContext, true);
        GMTrace.o(2071784849408L, 15436);
        return;
      }
      if (paramIntent.getAction().equals("MINIQB_OPEN_RET"))
      {
        com.tencent.mm.pluginsdk.ui.tools.a.aa(paramIntent);
        GMTrace.o(2071784849408L, 15436);
        return;
      }
      v.e("MicroMsg.MMAppMgr", "unknown broadcast action");
      GMTrace.o(2071784849408L, 15436);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/MMAppMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */