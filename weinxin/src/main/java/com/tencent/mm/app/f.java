package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.boot.a.a;
import com.tencent.mm.modelrecovery.PluginRecovery;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.g.d.b;

public class f
  extends com.tencent.mm.kernel.a.e
  implements h
{
  private static boolean fvQ;
  public boolean fvR;
  private d.b fvS;
  
  static
  {
    GMTrace.i(14279692517376L, 106392);
    fvQ = false;
    GMTrace.o(14279692517376L, 106392);
  }
  
  public f()
  {
    GMTrace.i(14279021428736L, 106387);
    this.fvR = false;
    this.fvS = null;
    GMTrace.o(14279021428736L, 106387);
  }
  
  protected final void a(final com.tencent.mm.kernel.b.e parame, com.tencent.mm.vending.g.c<Void> paramc, com.tencent.mm.vending.h.d paramd)
  {
    GMTrace.i(18800950902784L, 140078);
    super.a(parame, paramc, paramd);
    if (of()) {
      paramc.a(paramd).a(new com.tencent.mm.vending.c.a() {});
    }
    GMTrace.o(18800950902784L, 140078);
  }
  
  public final void a(com.tencent.mm.kernel.b.e parame, com.tencent.mm.vending.h.d paramd, d.b paramb)
  {
    GMTrace.i(14279558299648L, 106391);
    fvQ = false;
    Object localObject;
    Object[] arrayOfObject1;
    String str1;
    if (parame.ej(""))
    {
      localObject = bf.er(aa.getContext());
      if ((localObject == null) || (!((ComponentName)localObject).getPackageName().equals(aa.getPackageName())) || (!((ComponentName)localObject).getClassName().equals(aa.bIL()))) {
        break label172;
      }
      fvQ = true;
      WorkerProfile.fvQ = true;
      arrayOfObject1 = new Object[1];
      str1 = "summerboot executeTasks sStartupOnInitThread true currentActivity[%s]";
    }
    for (Object[] arrayOfObject2 = arrayOfObject1;; arrayOfObject2 = arrayOfObject1)
    {
      localObject = ((ComponentName)localObject).getClassName();
      String str2 = "MicroMsg.DefaultBootStep";
      for (;;)
      {
        arrayOfObject1[0] = localObject;
        v.i(str2, str1, arrayOfObject2);
        if (!fvQ) {
          break;
        }
        v.i("MicroMsg.DefaultBootStep", "summerboot executeTasks sStartupOnInitThread but -- Skip execute mTaskExecuted[%b]", new Object[] { Boolean.valueOf(this.fvR) });
        this.fvS = paramb;
        if (!this.fvR) {
          ae.f(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(18801219338240L, 140080);
              v.i("MicroMsg.DefaultBootStep", "summerboot executeTasks sStartupOnInitThread executeTasksDelay 2s mTaskExecuted[%b]", new Object[] { Boolean.valueOf(f.this.fvR) });
              if (f.this.fvR)
              {
                v.i("MicroMsg.DefaultBootStep", "summerboot executeTasks sStartupOnInitThread executeTasksDelay but has executed -- Skip");
                GMTrace.o(18801219338240L, 140080);
                return;
              }
              f.this.og();
              GMTrace.o(18801219338240L, 140080);
            }
          }, 2000L);
        }
        GMTrace.o(14279558299648L, 106391);
        return;
        label172:
        arrayOfObject1 = new Object[1];
        if (localObject != null) {
          break label223;
        }
        str2 = "MicroMsg.DefaultBootStep";
        arrayOfObject2 = arrayOfObject1;
        localObject = "NULL";
        str1 = "summerboot executeTasks sStartupOnInitThread false currentActivity[%s]";
      }
      this.fvR = true;
      super.a(parame, paramd, paramb);
      GMTrace.o(14279558299648L, 106391);
      return;
      label223:
      str1 = "summerboot executeTasks sStartupOnInitThread false currentActivity[%s]";
    }
  }
  
  public final void od()
  {
    GMTrace.i(14279155646464L, 106388);
    super.od();
    com.tencent.mm.compatible.util.k.b("stlport_shared", f.class.getClassLoader());
    aa.getContext().getSystemService("audio");
    com.tencent.mm.kernel.b.f localf = (com.tencent.mm.kernel.b.f)com.tencent.mm.kernel.h.vF().vj();
    com.tencent.mm.compatible.util.k.b(com.tencent.mm.sdk.a.uqc, f.class.getClassLoader());
    localf.gKs = com.tencent.mm.booter.c.ao(localf.gZp);
    com.tencent.mm.booter.c localc = localf.gKs;
    if (localf.ej("")) {
      localc.cR("MM");
    }
    for (;;)
    {
      com.tencent.mm.kernel.a.a.a("Hello WeChat, DefaultBootStep load debugger and init xlog...", new Object[0]);
      k.bi(((com.tencent.mm.kernel.b.f)com.tencent.mm.kernel.h.vF().vj()).gWE);
      m.d(a.a.class);
      m.bl("com.tencent.mm.boot");
      GMTrace.o(14279155646464L, 106388);
      return;
      if (localf.ej(":push")) {
        localc.cR("PUSH");
      } else if (localf.ej(":tools")) {
        localc.cR("TOOL");
      } else if (localf.ej(":sandbox")) {
        localc.cR("SANDBOX");
      } else if (localf.ej(":exdevice")) {
        localc.cR("EXDEVICE");
      } else if (localf.ej(":patch")) {
        localc.cR("PATCH");
      } else if (localf.ej(":appbrand")) {
        localc.cR("APPBRAND");
      } else if (localf.ej(":TMAssistantDownloadSDKService")) {
        localc.cR("TMSDK");
      }
    }
  }
  
  public final void oe()
  {
    GMTrace.i(14279289864192L, 106389);
    com.tencent.mm.kernel.h.vE().gXJ = n.class;
    f(PluginZero.class);
    f(PluginMessengerFoundation.class);
    f(PluginReport.class);
    f(PluginAuth.class);
    f(PluginBigBallOfMud.class);
    f(PluginRecovery.class);
    ei("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    ei("com.tencent.mm.plugin.performance.PluginPerformance");
    ei("com.tencent.mm.plugin.comm.PluginComm");
    ei("com.tencent.mm.plugin.chatroom.PluginChatroom");
    ei("com.tencent.mm.plugin.audio.PluginVoice");
    ei("com.tencent.mm.plugin.biz.PluginBiz");
    ei("com.tencent.mm.plugin.notification.PluginNotification");
    ei("com.tencent.mm.plugin.messenger.PluginMessenger");
    ei("com.tencent.mm.plugin.welab.PluginWelab");
    ei("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
    ei("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    ei("com.tencent.mm.plugin.uishow.PluginUIShow");
    ei("com.tencent.mm.plugin.emoji.PluginEmoji");
    ei("com.tencent.mm.plugin.video.PluginVideo");
    ei("com.tencent.mm.plugin.sport.PluginSport");
    ei("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
    ei("com.tencent.mm.plugin.fts.PluginFTS");
    ei("com.tencent.mm.plugin.sns.PluginSns");
    ei("com.tencent.mm.plugin.downloader.PluginDownloader");
    ei("com.tencent.mm.plugin.fav.PluginFavorite");
    ei("com.tencent.mm.plugin.music.PluginMusic");
    ei("com.tencent.mm.plugin.facedetect.PluginFace");
    ei("com.tencent.mm.plugin.soter.PluginSoter");
    ei("com.tencent.mm.plugin.mmsight.PluginMMSight");
    ei("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
    ei("com.tencent.mm.plugin.normsg.PluginNormsg");
    GMTrace.o(14279289864192L, 106389);
  }
  
  protected final boolean of()
  {
    GMTrace.i(18800816685056L, 140077);
    com.tencent.mm.kernel.b.e locale = com.tencent.mm.kernel.h.vF().vj();
    if ((locale.ej(":sandbox")) || (locale.ej(":nospace")))
    {
      GMTrace.o(18800816685056L, 140077);
      return false;
    }
    GMTrace.o(18800816685056L, 140077);
    return true;
  }
  
  public final boolean og()
  {
    GMTrace.i(14279424081920L, 106390);
    if (!fvQ)
    {
      v.w("MicroMsg.DefaultBootStep", "--- not executeTasksDelay, why go here?");
      GMTrace.o(14279424081920L, 106390);
      return false;
    }
    if (this.fvR)
    {
      v.w("MicroMsg.DefaultBootStep", "--- mTaskExecuted = true, why go here again?");
      GMTrace.o(14279424081920L, 106390);
      return false;
    }
    this.fvR = true;
    v.i("MicroMsg.DefaultBootStep", "--- executeTasksDelay");
    com.tencent.mm.kernel.b.e locale = com.tencent.mm.kernel.h.vF().vj();
    if (j.fwo == null) {
      j.fwo = new j("initThread");
    }
    final j localj = j.fwo;
    if ((localj.fwp == null) || (!localj.fwp.isAlive())) {
      v.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.vJ().a(new com.tencent.mm.kernel.api.h()
      {
        public final void ak(boolean paramAnonymousBoolean)
        {
          GMTrace.i(18800682467328L, 140076);
          GMTrace.o(18800682467328L, 140076);
        }
        
        public final void oh()
        {
          GMTrace.i(18800548249600L, 140075);
          localj.fwp.quit();
          com.tencent.mm.kernel.h.vJ().b(this);
          GMTrace.o(18800548249600L, 140075);
        }
      });
      super.a(locale, localj.fwq, this.fvS);
      GMTrace.o(14279424081920L, 106390);
      return true;
      int i = localj.fwp.getThreadId();
      try
      {
        if (-8 != Process.getThreadPriority(i)) {
          break label236;
        }
        v.w("MicroMsg.InitThreadController", "setHighPriority No Need.");
      }
      catch (Exception localException)
      {
        v.w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", new Object[] { Integer.valueOf(i) });
        v.printErrStackTrace("MicroMsg.InitThreadController", localException, "", new Object[0]);
      }
      continue;
      label236:
      Process.setThreadPriority(i, -8);
      v.i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Process.getThreadPriority(i)) });
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */