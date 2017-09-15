package com.tencent.mm.plugin.bbom;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.R.l;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.booter.MMReceivers.SandBoxProcessReceiver;
import com.tencent.mm.booter.MMReceivers.ToolsProcessReceiver;
import com.tencent.mm.booter.d.a;
import com.tencent.mm.booter.d.b;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.x;
import com.tencent.mm.compatible.loader.f.1;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.modelfriend.s.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.t.f.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.d.b.3;
import com.tencent.mm.u.i.1;
import com.tencent.mm.u.i.2;
import com.tencent.mm.u.i.3;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMAppMgr.Receiver;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteTrace;
import java.util.Iterator;
import java.util.List;

public class PluginBigBallOfMud
  extends com.tencent.mm.kernel.b.d
  implements ApplicationLifeCycleBucket
{
  private static final String TAG = "MicroMsg.PluginBigBallOfMud";
  public Application app;
  private final MMAppMgr appMgr;
  private com.tencent.mm.compatible.loader.e mProfileCompat;
  
  public PluginBigBallOfMud()
  {
    GMTrace.i(8021522513920L, 59765);
    this.appMgr = new MMAppMgr();
    GMTrace.o(8021522513920L, 59765);
  }
  
  private void autoScaleFontSize()
  {
    GMTrace.i(8022193602560L, 59770);
    GMTrace.o(8022193602560L, 59770);
  }
  
  public void configure(com.tencent.mm.kernel.b.e parame)
  {
    GMTrace.i(8021925167104L, 59768);
    MMReceivers.ToolsProcessReceiver.a(new d.b());
    MMReceivers.SandBoxProcessReceiver.a(new d.a());
    Object localObject1 = (com.tencent.mm.plugin.zero.a.d)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.zero.a.d.class);
    ((com.tencent.mm.plugin.zero.a.d)localObject1).setILightPushDelegate(new g());
    ((com.tencent.mm.plugin.zero.a.d)localObject1).addNotifyReceiverCallback(new k());
    ((com.tencent.mm.plugin.zero.a.d)localObject1).addICoreServiceLifecycleCallback(new d());
    v.i("MicroMsg.PluginBigBallOfMud", "zero %s", new Object[] { localObject1 });
    this.app = parame.gZp;
    com.tencent.mm.modelstat.d.b(this.app);
    v.i("MicroMsg.PluginBigBallOfMud", "app.getResources() is:" + parame.gZp.getResources());
    aa.a(com.tencent.mm.bh.a.a(parame.gZp.getResources(), parame.gZp));
    autoScaleFontSize();
    com.tencent.mm.app.c.ac(this.app.getApplicationContext());
    long l = System.currentTimeMillis();
    Object localObject3 = new com.tencent.mm.compatible.loader.f();
    localObject1 = this.app;
    Object localObject2 = parame.gWE;
    if ((localObject2 == null) || (((String)localObject2).length() <= 0))
    {
      HandlerThread localHandlerThread = com.tencent.mm.sdk.f.e.Qt("ProfileFactoryImp_handlerThread");
      localHandlerThread.start();
      localObject2 = (String)new f.1((com.tencent.mm.compatible.loader.f)localObject3).b(new ad(localHandlerThread.getLooper()));
      localHandlerThread.getLooper().quit();
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        v.e("MicroMsg.ProfileFactoryImpl", "get process name failed, retry later");
        localObject1 = null;
        this.mProfileCompat = ((com.tencent.mm.compatible.loader.e)localObject1);
        if ((this.mProfileCompat != null) && (!parame.ej("")))
        {
          v.i("MicroMsg.PluginBigBallOfMud", "before profile oncreate.");
          this.mProfileCompat.onCreate();
        }
        v.i("MicroMsg.PluginBigBallOfMud", "after profile oncreate.");
        ((com.tencent.mm.kernel.b.f)parame).mProfileCompat = this.mProfileCompat;
        localObject1 = parame.gZp.getSharedPreferences("system_config_prefs", 0);
        if (localObject1 == null) {
          break label3187;
        }
      }
      label3185:
      label3187:
      for (int i = ((SharedPreferences)localObject1).getInt("default_uin", 0);; i = 0)
      {
        v.i("MicroMsg.PluginBigBallOfMud", "APPonCreate proc:%s time:%d (loader:%d) ueh:%d data[%s] sdcard[%s]", new Object[] { parame.gWE, Long.valueOf(bf.aA(MMApplicationLike.sAppStartTime)), Long.valueOf(bf.aA(l)), Integer.valueOf(i), w.hgg, com.tencent.mm.compatible.util.e.hgi });
        com.tencent.mm.h.a.a.a(new com.tencent.mm.h.a()
        {
          public final void b(au paramAnonymousau)
          {
            GMTrace.i(14554167771136L, 108437);
            if (com.tencent.mm.modelbiz.e.dr(paramAnonymousau.field_talker)) {
              paramAnonymousau.cN(com.tencent.mm.modelbiz.a.e.zz());
            }
            GMTrace.o(14554167771136L, 108437);
          }
          
          public final String c(au paramAnonymousau)
          {
            GMTrace.i(16315238580224L, 121558);
            if (com.tencent.mm.modelbiz.e.dr(paramAnonymousau.field_talker))
            {
              paramAnonymousau = com.tencent.mm.modelbiz.a.e.ix(paramAnonymousau.gxv);
              GMTrace.o(16315238580224L, 121558);
              return paramAnonymousau;
            }
            GMTrace.o(16315238580224L, 121558);
            return null;
          }
          
          public final boolean dr(String paramAnonymousString)
          {
            GMTrace.i(16315372797952L, 121559);
            boolean bool = com.tencent.mm.modelbiz.e.dr(paramAnonymousString);
            GMTrace.o(16315372797952L, 121559);
            return bool;
          }
          
          public final String p(String paramAnonymousString, int paramAnonymousInt)
          {
            GMTrace.i(14554301988864L, 108438);
            if (com.tencent.mm.modelbiz.e.dr(paramAnonymousString))
            {
              paramAnonymousString = com.tencent.mm.modelbiz.a.e.ix(((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramAnonymousInt).gxv);
              GMTrace.o(14554301988864L, 108438);
              return paramAnonymousString;
            }
            paramAnonymousString = ba.zA();
            GMTrace.o(14554301988864L, 108438);
            return paramAnonymousString;
          }
        });
        if (parame.ej(""))
        {
          com.tencent.mm.modelfriend.s.hBh = new s.a()
          {
            public final String FG()
            {
              GMTrace.i(14555107295232L, 108444);
              if (com.tencent.mm.sdk.platformtools.f.uqJ)
              {
                str = aa.getContext().getString(R.l.eND);
                GMTrace.o(14555107295232L, 108444);
                return str;
              }
              String str = aa.getContext().getString(R.l.eNC);
              GMTrace.o(14555107295232L, 108444);
              return str;
            }
          };
          com.tencent.mm.bj.e.a(new SQLiteTrace()
          {
            public final void onConnectionObtained(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, long paramAnonymousLong, boolean paramAnonymousBoolean)
            {
              GMTrace.i(18911412092928L, 140901);
              GMTrace.o(18911412092928L, 140901);
            }
            
            public final void onConnectionPoolBusy(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString1, List<String> paramAnonymousList, String paramAnonymousString2)
            {
              GMTrace.i(14703552102400L, 109550);
              GMTrace.o(14703552102400L, 109550);
            }
            
            public final void onDatabaseCorrupted(SQLiteDatabase paramAnonymousSQLiteDatabase)
            {
              GMTrace.i(14703686320128L, 109551);
              GMTrace.o(14703686320128L, 109551);
            }
            
            public final void onSQLExecuted(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, int paramAnonymousInt, long paramAnonymousLong)
            {
              GMTrace.i(14703417884672L, 109549);
              for (;;)
              {
                com.tencent.mm.u.d.b localb;
                try
                {
                  localb = com.tencent.mm.u.d.b.AG();
                  boolean bool1 = ae.isMainThread();
                  paramAnonymousSQLiteDatabase = paramAnonymousSQLiteDatabase.getPath();
                  if (((paramAnonymousLong > localb.hpg) && (bool1)) || ((paramAnonymousLong > localb.hpi) && (!bool1)))
                  {
                    Iterator localIterator = com.tencent.mm.u.d.b.hpo.iterator();
                    if (localIterator.hasNext())
                    {
                      String str = (String)localIterator.next();
                      if (bool1) {
                        continue;
                      }
                      boolean bool2 = paramAnonymousSQLiteDatabase.contains(str);
                      if (!bool2) {
                        continue;
                      }
                    }
                  }
                  else
                  {
                    GMTrace.o(14703417884672L, 109549);
                    return;
                  }
                  if ((paramAnonymousInt == 2) && (bool1) && (paramAnonymousLong < localb.hph)) {
                    continue;
                  }
                  if (localb.hoL) {
                    break label497;
                  }
                  paramAnonymousString = paramAnonymousString.trim().toUpperCase();
                  if ((!paramAnonymousString.startsWith("INSERT")) && (!paramAnonymousString.startsWith("UPDATE")) && (!paramAnonymousString.startsWith("DELETE")) && (!paramAnonymousString.startsWith("COMMIT")) && (!paramAnonymousString.startsWith("SELECT")))
                  {
                    paramAnonymousSQLiteDatabase = null;
                    if (!bf.mA(paramAnonymousSQLiteDatabase))
                    {
                      paramAnonymousString = new StringBuilder();
                      com.tencent.mm.u.d.b.a("tid", String.valueOf(Thread.currentThread().getId()), paramAnonymousString);
                      com.tencent.mm.u.d.b.a("sql", paramAnonymousSQLiteDatabase, paramAnonymousString);
                      com.tencent.mm.u.d.b.a("lastTime", String.valueOf(paramAnonymousLong), paramAnonymousString);
                      if (!com.tencent.mm.sdk.a.b.foreground) {
                        break label513;
                      }
                      paramAnonymousSQLiteDatabase = "1";
                      com.tencent.mm.u.d.b.a("foreground", paramAnonymousSQLiteDatabase, paramAnonymousString);
                      com.tencent.mm.u.d.b.a("tname", Thread.currentThread().getName(), paramAnonymousString);
                      paramAnonymousSQLiteDatabase = paramAnonymousString.toString();
                      v.d("MicroMsg.SQLTraceManager", "SQL Trace mark : " + paramAnonymousSQLiteDatabase);
                      ap.vL().D(new b.3(localb, paramAnonymousSQLiteDatabase));
                    }
                    GMTrace.o(14703417884672L, 109549);
                    return;
                  }
                }
                catch (Exception paramAnonymousSQLiteDatabase)
                {
                  v.printErrStackTrace("MicroMsg.SQLiteTrace", paramAnonymousSQLiteDatabase, "Failed to send trace.", new Object[0]);
                  GMTrace.o(14703417884672L, 109549);
                  return;
                }
                if (paramAnonymousString.startsWith("INSERT")) {
                  paramAnonymousSQLiteDatabase = paramAnonymousString.substring(0, paramAnonymousString.indexOf("(", 0));
                }
                for (;;)
                {
                  paramAnonymousString = paramAnonymousSQLiteDatabase;
                  if (paramAnonymousSQLiteDatabase.length() > 512) {
                    paramAnonymousString = paramAnonymousSQLiteDatabase.substring(0, 512) + "...";
                  }
                  paramAnonymousSQLiteDatabase = paramAnonymousString;
                  if (paramAnonymousString.trim().endsWith(";")) {
                    break;
                  }
                  paramAnonymousSQLiteDatabase = paramAnonymousString + ";";
                  break;
                  paramAnonymousSQLiteDatabase = paramAnonymousString;
                  if (paramAnonymousString.startsWith("COMMIT"))
                  {
                    if (paramAnonymousLong <= localb.hpj) {
                      break label508;
                    }
                    paramAnonymousSQLiteDatabase = paramAnonymousString + "task:" + bf.bJP();
                  }
                }
                label497:
                v.i("MicroMsg.SQLTraceManager", "mark stop as file is full !");
                continue;
                label508:
                paramAnonymousSQLiteDatabase = null;
                continue;
                label513:
                paramAnonymousSQLiteDatabase = "0";
              }
            }
          });
          com.tencent.mm.storage.e.uxf = new com.tencent.mm.plugin.messenger.foundation.a.j()
          {
            public final String F(au paramAnonymousau)
            {
              GMTrace.i(14555241512960L, 108445);
              int i;
              if ((paramAnonymousau.field_bizChatId != -1L) && (com.tencent.mm.modelbiz.e.dr(paramAnonymousau.field_talker)))
              {
                i = 1;
                if (i == 0) {
                  break label95;
                }
                paramAnonymousau = paramAnonymousau.field_talker + ":" + paramAnonymousau.field_bizChatId;
                v.d("MicroMsg.PluginBigBallOfMud", "mapNotifyInfo key:%s", new Object[] { paramAnonymousau });
              }
              for (;;)
              {
                GMTrace.o(14555241512960L, 108445);
                return paramAnonymousau;
                i = 0;
                break;
                label95:
                paramAnonymousau = paramAnonymousau.field_talker;
              }
            }
          };
          com.tencent.mm.u.p.a(new com.tencent.mm.u.p.a()
          {
            public final boolean a(String paramAnonymousString1, String paramAnonymousString2, PInt paramAnonymousPInt)
            {
              GMTrace.i(14554973077504L, 108443);
              if (com.tencent.mm.u.o.eV(paramAnonymousString1))
              {
                if (com.tencent.mm.modelbiz.e.dr(paramAnonymousString1)) {
                  if (com.tencent.mm.modelbiz.a.e.it(paramAnonymousString2)) {
                    paramAnonymousPInt.value = 5;
                  }
                }
                for (;;)
                {
                  GMTrace.o(14554973077504L, 108443);
                  return true;
                  paramAnonymousPInt.value = 4;
                  continue;
                  if (com.tencent.mm.modelbiz.e.ia(paramAnonymousString1)) {
                    paramAnonymousPInt.value = 3;
                  } else if (com.tencent.mm.modelbiz.e.ib(paramAnonymousString1)) {
                    paramAnonymousPInt.value = 0;
                  } else if (com.tencent.mm.modelbiz.e.hX(paramAnonymousString1)) {
                    paramAnonymousPInt.value = 6;
                  } else {
                    paramAnonymousPInt.value = 7;
                  }
                }
              }
              GMTrace.o(14554973077504L, 108443);
              return false;
            }
          });
          s.b(new com.tencent.mm.bn.b() {});
          localObject1 = new com.tencent.mm.modelmulti.a();
          com.tencent.mm.plugin.messenger.foundation.a.p.a.a(69, (com.tencent.mm.plugin.messenger.foundation.a.p)localObject1);
          com.tencent.mm.plugin.messenger.foundation.a.p.a.a(68, (com.tencent.mm.plugin.messenger.foundation.a.p)localObject1);
          com.tencent.mm.plugin.messenger.foundation.a.p.a.a(22, (com.tencent.mm.plugin.messenger.foundation.a.p)localObject1);
          com.tencent.mm.plugin.messenger.foundation.a.p.a.a(13, (com.tencent.mm.plugin.messenger.foundation.a.p)localObject1);
          com.tencent.mm.plugin.messenger.foundation.a.p.a.a(15, (com.tencent.mm.plugin.messenger.foundation.a.p)localObject1);
          com.tencent.mm.plugin.messenger.foundation.a.p.a.a(23, (com.tencent.mm.plugin.messenger.foundation.a.p)localObject1);
          com.tencent.mm.plugin.messenger.foundation.a.p.a.a(25, (com.tencent.mm.plugin.messenger.foundation.a.p)localObject1);
          com.tencent.mm.plugin.messenger.foundation.a.p.a.a(24, (com.tencent.mm.plugin.messenger.foundation.a.p)localObject1);
          com.tencent.mm.plugin.messenger.foundation.a.p.a.a(33, (com.tencent.mm.plugin.messenger.foundation.a.p)localObject1);
          com.tencent.mm.plugin.messenger.foundation.a.p.a.a(35, (com.tencent.mm.plugin.messenger.foundation.a.p)localObject1);
          com.tencent.mm.plugin.messenger.foundation.a.p.a.a(44, (com.tencent.mm.plugin.messenger.foundation.a.p)localObject1);
          com.tencent.mm.plugin.messenger.foundation.a.p.a.a(999999, (com.tencent.mm.plugin.messenger.foundation.a.p)localObject1);
          com.tencent.mm.plugin.messenger.foundation.a.p.a.a(53, (com.tencent.mm.plugin.messenger.foundation.a.p)localObject1);
          com.tencent.mm.plugin.messenger.foundation.a.p.a.a(204, (com.tencent.mm.plugin.messenger.foundation.a.p)localObject1);
          localObject1 = new c();
          ((com.tencent.mm.plugin.messenger.foundation.a.c)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a((com.tencent.mm.plugin.messenger.foundation.a.b)localObject1);
          com.tencent.mm.kernel.h.vd().a(681, (com.tencent.mm.y.e)localObject1);
          s.a(5, new h());
          s.a(1, new o());
          s.a(4, new e());
          ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new a());
          localObject1 = new i();
          ((com.tencent.mm.plugin.messenger.foundation.a.o)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.o.class)).a((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1);
          ((com.tencent.mm.plugin.messenger.foundation.a.o)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.o.class)).a((com.tencent.mm.plugin.messenger.foundation.a.f)localObject1);
          com.tencent.mm.u.e.a(new b());
          new com.tencent.mm.permission.b();
          new m().bIo();
          com.tencent.mm.kernel.h.vd().b(138, j.jOi);
          com.tencent.mm.kernel.h.vd().b(39, j.jOi);
          com.tencent.mm.kernel.h.vd().b(268369922, j.jOi);
          if (j.jOi == null) {
            j.jOi = new j();
          }
          com.tencent.mm.kernel.h.vd().a(138, j.jOi);
          com.tencent.mm.kernel.h.vd().a(39, j.jOi);
          com.tencent.mm.kernel.h.vd().a(268369922, j.jOi);
          l.bJ(this.app);
          com.tencent.mm.an.a.a.a("delchatroommember", new i.1());
          com.tencent.mm.an.a.a.a("NewXmlChatRoomAccessVerifyApplication", new i.2());
          com.tencent.mm.an.a.a.a("NewXmlChatRoomAccessVerifyApproval", new i.3());
          localObject1 = this.appMgr;
          localObject2 = this.app;
          if (((MMAppMgr)localObject1).uSv == null) {
            ((MMAppMgr)localObject1).uSv = new MMAppMgr.Receiver((MMAppMgr)localObject1);
          }
          MMActivity.bPG();
          localObject3 = new IntentFilter();
          ((IntentFilter)localObject3).addAction("com.tencent.mm.ui.ACTION_ACTIVE");
          ((IntentFilter)localObject3).addAction("com.tencent.mm.ui.ACTION_DEACTIVE");
          ((IntentFilter)localObject3).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
          ((IntentFilter)localObject3).addAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
          ((IntentFilter)localObject3).addAction("MINIQB_OPEN_RET");
          ((Context)localObject2).registerReceiver(((MMAppMgr)localObject1).uSv, (IntentFilter)localObject3, "com.tencent.mm.permission.MM_MESSAGE", null);
          localObject1 = new x(com.tencent.mm.booter.c.ao(this.app));
          ((x)localObject1).cR("MM");
          com.tencent.mm.platformtools.r.iiI = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.use_cdn_down_thumb"), false);
          com.tencent.mm.platformtools.r.ihQ = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.display_errcode"), false);
          com.tencent.mm.platformtools.r.ihR = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.display_msgstate"), false);
          com.tencent.mm.platformtools.r.ihS = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.network.simulate_fault"), false);
          com.tencent.mm.platformtools.r.ihT = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.network.force_touch"), false);
          com.tencent.mm.platformtools.r.ihU = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
          com.tencent.mm.platformtools.r.ihV = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.crashIsExit"), false);
          com.tencent.mm.platformtools.r.iiu = bf.getInt(bf.ap(((x)localObject1).getString(".com.tencent.mm.debug.datatransfer.times"), "0"), 0);
          com.tencent.mm.platformtools.r.iiv = bf.getInt(bf.ap(((x)localObject1).getString(".com.tencent.mm.debug.datatransfer.duration"), "0"), 0);
          com.tencent.mm.platformtools.r.ihX = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.album_drop_table"), false);
          com.tencent.mm.platformtools.r.ihY = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.album_dle_file"), false);
          com.tencent.mm.platformtools.r.ihZ = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.album_show_info"), false);
          com.tencent.mm.platformtools.r.iia = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.location_help"), false);
          com.tencent.mm.platformtools.r.iid = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.force_soso"), false);
          com.tencent.mm.platformtools.r.iie = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.simulatePostServerError"), false);
          com.tencent.mm.platformtools.r.iif = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
          com.tencent.mm.platformtools.r.iig = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
          com.tencent.mm.platformtools.r.iij = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.filterfpnp"), false);
          com.tencent.mm.platformtools.r.iik = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.testForPull"), false);
          i = bf.a(((x)localObject1).getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
          com.tencent.mm.platformtools.r.iih = i;
          if ((i != 4) && (com.tencent.mm.platformtools.r.iih > 0))
          {
            com.tencent.mm.storage.v.uxs = com.tencent.mm.platformtools.r.iih;
            v.e("MicroMsg.WorkerDebugger", "cdn thread num " + com.tencent.mm.platformtools.r.iih);
          }
          com.tencent.mm.platformtools.r.iii = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
          com.tencent.mm.platformtools.r.iil = bf.ap(((x)localObject1).getString(".com.tencent.mm.debug.server.host.http"), "");
          com.tencent.mm.platformtools.r.iim = bf.ap(((x)localObject1).getString(".com.tencent.mm.debug.server.host.socket"), "");
          if (bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.show_full_version"), false)) {
            com.tencent.mm.sdk.platformtools.f.uqG = true;
          }
        }
        for (;;)
        {
          try
          {
            i = Integer.decode(((x)localObject1).getString(".com.tencent.mm.debug.log.setversion")).intValue();
            com.tencent.mm.protocal.d.xR(i);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(i));
          }
          catch (Exception localException4)
          {
            try
            {
              localObject2 = ((x)localObject1).getString(".com.tencent.mm.debug.log.setapilevel");
              if (!bf.mA((String)localObject2))
              {
                com.tencent.mm.protocal.d.DEVICE_TYPE = "android-" + (String)localObject2;
                com.tencent.mm.protocal.d.sXc = "android-" + (String)localObject2;
                com.tencent.mm.protocal.d.sXe = (String)localObject2;
                com.tencent.mm.sdk.a.b.Pa((String)localObject2);
                new StringBuilder("set up test protocal apilevel = ").append(com.tencent.mm.protocal.d.DEVICE_TYPE).append(" ").append(com.tencent.mm.sdk.a.b.bIl());
              }
            }
            catch (Exception localException4)
            {
              try
              {
                l = Long.decode(((x)localObject1).getString(".com.tencent.mm.debug.log.setuin")).longValue();
                new StringBuilder("set up test protocal uin old: ").append(com.tencent.mm.protocal.d.sXg).append(" new: ").append(l);
                com.tencent.mm.protocal.d.sXg = l;
              }
              catch (Exception localException4)
              {
                try
                {
                  i = Integer.decode(((x)localObject1).getString(".com.tencent.mm.debug.log.setchannel")).intValue();
                  ((q)localObject1).gKs.gJB = i;
                }
                catch (Exception localException4)
                {
                  try
                  {
                    boolean bool1 = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.report.debugmodel"), false);
                    boolean bool2 = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.report.kvstat"), false);
                    boolean bool3 = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.report.clientpref"), false);
                    boolean bool4 = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.report.useraction"), false);
                    com.tencent.mm.plugin.report.a.c.a(bool1, bool2, bool3, bool4);
                    new StringBuilder("try control report : debugModel[").append(bool1).append("],kv[").append(bool2).append("], clientPref[").append(bool3).append("], useraction[").append(bool4).append("]");
                    com.tencent.mm.platformtools.r.iip = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.update_test"), false);
                    com.tencent.mm.platformtools.r.iiq = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.scan_save_image"), false);
                    com.tencent.mm.platformtools.r.iis = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.shake_get_config_list"), false);
                    com.tencent.mm.platformtools.r.iit = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.test.shake_show_shaketv"), false);
                    com.tencent.mm.platformtools.r.iix = bf.ap(((x)localObject1).getString(".com.tencent.mm.debug.jsapi.permission"), "");
                    v.d("MicroMsg.WorkerDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.r.iix);
                    com.tencent.mm.platformtools.r.iiM = bf.ap(((x)localObject1).getString(".com.tencent.mm.debug.cdn.front"), "");
                    com.tencent.mm.platformtools.r.iiN = bf.ap(((x)localObject1).getString(".com.tencent.mm.debug.cdn.zone"), "");
                    com.tencent.mm.platformtools.r.iiO = bf.ap(((x)localObject1).getString(".com.tencent.mm.debug.cdn.wifi_elt"), "");
                    com.tencent.mm.platformtools.r.iiP = bf.ap(((x)localObject1).getString(".com.tencent.mm.debug.cdn.nowifi_elt"), "");
                    com.tencent.mm.platformtools.r.iiQ = bf.ap(((x)localObject1).getString(".com.tencent.mm.debug.cdn.ptl"), "");
                    com.tencent.mm.platformtools.r.iiR = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.cdn.usestream"), false);
                    com.tencent.mm.platformtools.r.iiS = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.cdn.onlysendetl"), false);
                    com.tencent.mm.platformtools.r.iiT = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.cdn.onlysendptl"), false);
                    com.tencent.mm.platformtools.r.iiV = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.cdn.enable_debug"), false);
                    com.tencent.mm.platformtools.r.iiW = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.cdn.enable_conn_verify"), false);
                    com.tencent.mm.platformtools.r.iiX = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.cdn.enable_video_redirect_oc"), false);
                    com.tencent.mm.platformtools.r.ijd = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.bakmove_hardcode"), false);
                    v.d("MicroMsg.WorkerDebugger", "Test.bakmove_hardcode = " + com.tencent.mm.platformtools.r.ijd);
                    com.tencent.mm.platformtools.r.ije = bf.ap(((x)localObject1).getString(".com.tencent.mm.debug.bakmove_ip"), "");
                    com.tencent.mm.platformtools.r.ijf = bf.getInt(bf.ap(((x)localObject1).getString(".com.tencent.mm.debug.bakmove_port"), "0"), 0);
                    com.tencent.mm.platformtools.r.ija = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.cursormode_enabled"), true);
                    com.tencent.mm.platformtools.r.ijB = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.disaster_ignore_interval"), false);
                    com.tencent.mm.platformtools.r.ijC = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.disaster_ignore_expire"), false);
                    com.tencent.mm.platformtools.r.ijD = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.disaster_ignore_remove"), false);
                    com.tencent.mm.platformtools.r.ijs = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.netscene_sniffer.enable_snapshot"), false);
                    com.tencent.mm.platformtools.r.iju = bf.ap(((x)localObject1).getString(".com.tencent.mm.debug.netscene_sniffer.snapshot_protocal"), "");
                    com.tencent.mm.platformtools.r.ijt = bf.b(((x)localObject1).cS(".com.tencent.mm.debug.netscene_sniffer.enable_inject"), false);
                    com.tencent.mm.platformtools.r.ijv = bf.ap(((x)localObject1).getString(".com.tencent.mm.debug.netscene_sniffer.inject_protocal"), "");
                    localObject1 = bf.er(aa.getContext());
                    if ((localObject1 != null) && (((ComponentName)localObject1).getPackageName().equals(aa.getPackageName())) && (((ComponentName)localObject1).getClassName().equals(aa.bIL())))
                    {
                      WorkerProfile.oC().fwZ = true;
                      WorkerProfile.oC().fxa = true;
                      v.i("MicroMsg.PluginBigBallOfMud", "start time check currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { ((ComponentName)localObject1).getPackageName(), ((ComponentName)localObject1).getClassName() });
                      com.tencent.mm.kernel.a.a.a(new com.tencent.mm.plugin.i.d(), parame);
                      com.tencent.mm.u.d.b.AG();
                      com.tencent.mm.u.d.b.setup();
                      AppLogic.setCallBack(new AppCallBack(aa.getContext()));
                      SmcLogic.setCallBack(new com.tencent.mm.plugin.report.service.h());
                      com.tencent.mm.plugin.report.service.h.oSS = (WorkerProfile)this.mProfileCompat;
                      com.tencent.mm.compatible.util.k.b(com.tencent.mm.sdk.a.uqe, WorkerProfile.class.getClassLoader());
                      BaseEvent.onCreate();
                      SmcLogic.SetDebugFlag(com.tencent.mm.plugin.report.a.c.oRC);
                      parame = (com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.messenger.foundation.a.n.class);
                      com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.zero.a.d.class);
                      localObject1 = (com.tencent.mm.plugin.i.c)new com.tencent.mm.plugin.i.c().after(parame).before(this);
                      localObject1 = (com.tencent.mm.plugin.i.a)new com.tencent.mm.plugin.i.a().after((com.tencent.mm.kernel.b.a)localObject1).before(this);
                      new com.tencent.mm.plugin.i.e().after((com.tencent.mm.kernel.b.a)localObject1).before(this);
                      new com.tencent.mm.plugin.i.b().after(parame).before(this);
                      com.tencent.mm.pluginsdk.k.a.b.m.a(new com.tencent.mm.pluginsdk.k.a.a.a()
                      {
                        public final boolean jE(int paramAnonymousInt)
                        {
                          GMTrace.i(16314835927040L, 121555);
                          if ((paramAnonymousInt == 39) && (!com.tencent.mm.plugin.ipcall.d.aDF()))
                          {
                            GMTrace.o(16314835927040L, 121555);
                            return true;
                          }
                          GMTrace.o(16314835927040L, 121555);
                          return false;
                        }
                      });
                      f.b.a(new com.tencent.mm.bn.b() {});
                      f.b.a(new com.tencent.mm.bn.b() {});
                      f.b.a(new com.tencent.mm.bn.b() {});
                      f.b.a(new com.tencent.mm.bn.b() {});
                      GMTrace.o(8021925167104L, 59768);
                      return;
                      aa.Pq((String)localObject2);
                      if (((String)localObject2).equals(aa.getPackageName()))
                      {
                        localObject1 = com.tencent.mm.compatible.loader.f.a((Application)localObject1, ".app.WorkerProfile");
                        v.w("MicroMsg.ProfileFactoryImpl", "application started, profile = %s", new Object[] { localObject2 });
                        break;
                      }
                      if (((String)localObject2).equals(aa.getPackageName() + ":push"))
                      {
                        localObject1 = com.tencent.mm.compatible.loader.f.a((Application)localObject1, ".app.PusherProfile");
                        continue;
                      }
                      if (((String)localObject2).equals(aa.getPackageName() + ":tools"))
                      {
                        localObject1 = com.tencent.mm.compatible.loader.f.a((Application)localObject1, ".app.ToolsProfile");
                        continue;
                      }
                      if (((String)localObject2).equals(aa.getPackageName() + ":sandbox"))
                      {
                        localObject1 = com.tencent.mm.compatible.loader.f.a((Application)localObject1, ".app.SandBoxProfile");
                        continue;
                      }
                      if (((String)localObject2).equals(aa.getPackageName() + ":exdevice"))
                      {
                        localObject1 = com.tencent.mm.compatible.loader.f.a((Application)localObject1, ".app.ExDeviceProfile");
                        continue;
                      }
                      if (((String)localObject2).equals(aa.getPackageName() + ":TMAssistantDownloadSDKService"))
                      {
                        localObject1 = com.tencent.mm.compatible.loader.f.a((Application)localObject1, ".app.TMAssistantProfile");
                        continue;
                      }
                      if (((String)localObject2).equals(aa.getPackageName() + ":nospace"))
                      {
                        localObject1 = com.tencent.mm.compatible.loader.f.a((Application)localObject1, ".app.NoSpaceProfile");
                        continue;
                      }
                      if (((String)localObject2).equals(aa.getPackageName() + ":patch"))
                      {
                        localObject1 = com.tencent.mm.compatible.loader.f.a((Application)localObject1, ".app.PatchProfile");
                        continue;
                      }
                      if (((String)localObject2).equals(aa.getPackageName() + ":recovery"))
                      {
                        localObject1 = com.tencent.mm.compatible.loader.f.a((Application)localObject1, ".app.RecoveryProfile");
                        continue;
                      }
                      if (((String)localObject2).startsWith(aa.getPackageName() + ":appbrand"))
                      {
                        localObject1 = com.tencent.mm.compatible.loader.f.a((Application)localObject1, ".app.AppBrandProfile");
                        continue;
                      }
                      if (((String)localObject2).startsWith(aa.getPackageName() + ":support"))
                      {
                        localObject1 = com.tencent.mm.compatible.loader.f.a((Application)localObject1, ".app.SupportProfile");
                        continue;
                      }
                      com.tencent.mm.sdk.a.b.r("MMApplication onCreate profile == null", "profile is null and initMMcore failed");
                      localObject1 = null;
                      break;
                      localException1 = localException1;
                      v.i("MicroMsg.WorkerDebugger", "no debugger was got");
                      continue;
                      localException2 = localException2;
                      v.i("MicroMsg.WorkerDebugger", "no debugger was got");
                      continue;
                      localException3 = localException3;
                      v.i("MicroMsg.WorkerDebugger", "no debugger was got");
                      continue;
                      localException4 = localException4;
                      v.i("MicroMsg.WorkerDebugger", "no debugger was got");
                      continue;
                    }
                  }
                  catch (Exception localException5)
                  {
                    v.i("MicroMsg.WorkerDebugger", "no debugger was got");
                    continue;
                  }
                }
              }
            }
          }
          if (localObject1 != null) {
            v.i("MicroMsg.PluginBigBallOfMud", "start time check onCreate appOnCreate currentActivity.getPackageName() :%s, currentActivity.getClassName(): %s", new Object[] { ((ComponentName)localObject1).getPackageName(), ((ComponentName)localObject1).getClassName() });
          }
          for (;;)
          {
            if ((localObject1 == null) || (((ComponentName)localObject1).getPackageName().equals(aa.getPackageName()))) {
              break label3185;
            }
            WorkerProfile.oC().fwZ = true;
            break;
            v.i("MicroMsg.PluginBigBallOfMud", "start time check onCreate appOnCreate currentActivity == null");
          }
        }
      }
    }
  }
  
  public void dependency()
  {
    GMTrace.i(8021790949376L, 59767);
    dependsOn(com.tencent.mm.plugin.auth.a.b.class);
    dependsOn(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    GMTrace.o(8021790949376L, 59767);
  }
  
  public void execute(com.tencent.mm.kernel.b.e parame)
  {
    GMTrace.i(8022059384832L, 59769);
    GMTrace.o(8022059384832L, 59769);
  }
  
  public void installed()
  {
    GMTrace.i(14554033553408L, 108436);
    GMTrace.o(14554033553408L, 108436);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    GMTrace.i(8022998908928L, 59776);
    GMTrace.o(8022998908928L, 59776);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(8022462038016L, 59772);
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onConfigurationChanged(paramConfiguration);
    }
    paramConfiguration = aa.getResources();
    if ((paramConfiguration instanceof com.tencent.mm.bh.a)) {
      ((com.tencent.mm.bh.a)paramConfiguration).bHu();
    }
    GMTrace.o(8022462038016L, 59772);
  }
  
  public void onCreate()
  {
    GMTrace.i(8022864691200L, 59775);
    GMTrace.o(8022864691200L, 59775);
  }
  
  public void onLowMemory()
  {
    GMTrace.i(8022596255744L, 59773);
    GMTrace.o(8022596255744L, 59773);
  }
  
  public void onTerminate()
  {
    GMTrace.i(8022327820288L, 59771);
    v.i("MicroMsg.PluginBigBallOfMud", "onTerminate(%s)", new Object[] { aa.um() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTerminate();
    }
    MMAppMgr localMMAppMgr = this.appMgr;
    Application localApplication = this.app;
    if (localMMAppMgr.uSv != null) {
      localApplication.unregisterReceiver(localMMAppMgr.uSv);
    }
    GMTrace.o(8022327820288L, 59771);
  }
  
  public void onTrimMemory(int paramInt)
  {
    GMTrace.i(8022730473472L, 59774);
    v.i("MicroMsg.PluginBigBallOfMud", "onTrimMemory, level = %d, process = %s", new Object[] { Integer.valueOf(paramInt), aa.um() });
    if (this.mProfileCompat != null) {
      this.mProfileCompat.onTrimMemory(paramInt);
    }
    GMTrace.o(8022730473472L, 59774);
  }
  
  public String toString()
  {
    GMTrace.i(8021656731648L, 59766);
    GMTrace.o(8021656731648L, 59766);
    return "plugin-big-ball-of-mud";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/bbom/PluginBigBallOfMud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */