package com.tencent.mm.plugin.zero;

import android.app.Service;
import android.os.Build.VERSION;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.w;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.y.n;
import com.tencent.mm.y.n.a;
import java.io.File;

public class PluginZero
  extends com.tencent.mm.kernel.b.d
  implements com.tencent.mm.plugin.zero.a.d
{
  private a szj;
  private b szk;
  public final com.tencent.mm.app.d szl;
  public com.tencent.mm.plugin.zero.a.b szm;
  public b szn;
  public a szo;
  
  public PluginZero()
  {
    GMTrace.i(13629541842944L, 101548);
    this.szj = new a();
    this.szk = new b();
    this.szl = new com.tencent.mm.app.d();
    this.szn = new b();
    this.szo = new a();
    GMTrace.o(13629541842944L, 101548);
  }
  
  private void initSDRoot()
  {
    GMTrace.i(13630212931584L, 101553);
    if (!new File(w.hgg + "SdcardInfo.cfg").exists())
    {
      com.tencent.mm.compatible.util.e.dw(com.tencent.mm.compatible.util.e.hgi);
      v.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", new Object[] { com.tencent.mm.compatible.util.e.hgi });
      GMTrace.o(13630212931584L, 101553);
      return;
    }
    String str2 = com.tencent.mm.compatible.util.e.hgi;
    s locals = new s(w.hgg + "SdcardInfo.cfg");
    String str3 = (String)locals.get(1, "");
    int i = ((Integer)locals.get(2, Integer.valueOf(0))).intValue();
    int j = Build.VERSION.SDK_INT;
    if (bf.mA(str3))
    {
      locals.set(1, str2);
      locals.set(2, Integer.valueOf(j));
    }
    for (String str1 = str2;; str1 = str3)
    {
      v.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", new Object[] { str3, str1, str2, Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.compatible.util.e.dw(str1);
      if ((i == j) || (com.tencent.mm.compatible.util.f.rZ())) {
        break label351;
      }
      if ((!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted")) || (!new File(com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()).canWrite())) {
        break;
      }
      locals.set(1, str2);
      locals.set(2, Integer.valueOf(j));
      com.tencent.mm.compatible.util.e.dw(str2);
      v.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", new Object[] { com.tencent.mm.compatible.util.e.hgi, Boolean.valueOf(com.tencent.mm.compatible.util.f.rZ()) });
      GMTrace.o(13630212931584L, 101553);
      return;
    }
    v.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", new Object[] { com.tencent.mm.compatible.util.e.hgi, Boolean.valueOf(com.tencent.mm.compatible.util.f.rZ()), str2 });
    label351:
    GMTrace.o(13630212931584L, 101553);
  }
  
  private void setupVendingLog()
  {
    GMTrace.i(13630481367040L, 101555);
    com.tencent.mm.vending.f.a.a(new com.tencent.mm.vending.f.a.a()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(13622696738816L, 101497);
        v.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(13622696738816L, 101497);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(13622294085632L, 101494);
        v.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(13622294085632L, 101494);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(13622562521088L, 101496);
        v.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(13622562521088L, 101496);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(13622830956544L, 101498);
        v.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(13622830956544L, 101498);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        GMTrace.i(13622428303360L, 101495);
        v.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        GMTrace.o(13622428303360L, 101495);
      }
    });
    GMTrace.o(13630481367040L, 101555);
  }
  
  public com.tencent.mm.vending.b.b addICoreServiceLifecycleCallback(com.tencent.mm.plugin.zero.a.a parama)
  {
    GMTrace.i(13630884020224L, 101558);
    parama = this.szo.bI(parama);
    GMTrace.o(13630884020224L, 101558);
    return parama;
  }
  
  public com.tencent.mm.vending.b.b addNotifyReceiverCallback(com.tencent.mm.plugin.zero.a.c paramc)
  {
    GMTrace.i(13630749802496L, 101557);
    v.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", new Object[] { this, paramc });
    paramc = this.szn.bI(paramc);
    GMTrace.o(13630749802496L, 101557);
    return paramc;
  }
  
  public void configure(final com.tencent.mm.kernel.b.e parame)
  {
    GMTrace.i(13630078713856L, 101552);
    try
    {
      initSDRoot();
      aa.Pq(parame.gWE);
      com.tencent.mm.kernel.a.a.a("configure [%s], setup broken library handler...", new Object[] { this });
      com.tencent.mm.compatible.util.k.setupBrokenLibraryHandler();
      setupVendingLog();
      if (parame.ej(""))
      {
        com.tencent.mm.kernel.a.a.a("configure [%s], for process[%s]...", new Object[] { this, parame.gWE });
        com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.zero.b.a.class, new com.tencent.mm.kernel.c.c(this.szj));
        com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.zero.b.b.class, new com.tencent.mm.kernel.c.c(this.szk));
        com.tencent.mm.kernel.a.a.a("configure [%s], make worker core...", new Object[] { this });
        com.tencent.mm.kernel.h localh = com.tencent.mm.kernel.h.vJ();
        if (!localh.gYJ)
        {
          localh.gYJ = true;
          localh.gYC = new com.tencent.mm.kernel.e(localh.gXS, localh.gXP, localh.gYH, localh.gXN, localh.gXO);
          localh.gYD = new com.tencent.mm.kernel.a(localh.gYF);
          localh.gYE = new com.tencent.mm.kernel.b(localh.gYG, localh.gXr);
        }
        com.tencent.mm.kernel.h.vJ().a(new com.tencent.mm.kernel.api.h()
        {
          public final void ak(boolean paramAnonymousBoolean)
          {
            GMTrace.i(13632091979776L, 101567);
            if (paramAnonymousBoolean)
            {
              com.tencent.mm.kernel.k.e(parame.gZp, true);
              com.tencent.mm.kernel.k.f(parame.gZp, true);
            }
            v.bIF();
            GMTrace.o(13632091979776L, 101567);
          }
          
          public final void oh()
          {
            GMTrace.i(13631957762048L, 101566);
            com.tencent.mm.kernel.a.a.a("onStartupDone", new Object[0]);
            GMTrace.o(13631957762048L, 101566);
          }
        });
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.bn.f.wEc = new com.tencent.mm.vending.h.h(com.tencent.mm.bn.c.c(com.tencent.mm.kernel.h.vL().bJb()), "WeChat.WORKER");
        g.a("WeChat.WORKER", com.tencent.mm.bn.f.wEc);
        new com.tencent.mm.plugin.zero.tasks.a().before(this);
        parame.gZo.a(new com.tencent.mm.kernel.a.d()
        {
          public final void execute(com.tencent.mm.kernel.b.e paramAnonymouse)
          {
            GMTrace.i(13624441569280L, 101510);
            com.tencent.mm.kernel.a.a.a("startup final step, account initialize...", new Object[0]);
            if (!com.tencent.mm.kernel.a.uP()) {
              com.tencent.mm.kernel.h.vG().initialize();
            }
            GMTrace.o(13624441569280L, 101510);
          }
          
          public final String name()
          {
            GMTrace.i(13624575787008L, 101511);
            GMTrace.o(13624575787008L, 101511);
            return "final-task-account-initialize";
          }
        });
      }
      if ((parame.ej("")) || (parame.ej(":push"))) {
        new LoadProtocolJNITask().before(this);
      }
      parame = (com.tencent.mm.kernel.b.f)parame;
      v.i("MicroMsg.PluginZero", "oldversion:%s, newversion:%s, gettime:%d, settime:%d", new Object[] { parame.gZq.mOldVersionCode, parame.gZq.mNewVersionCode, Long.valueOf(parame.gZq.mGetRevTime), Long.valueOf(parame.gZq.mSetRevTime) });
      GMTrace.o(13630078713856L, 101552);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.PluginZero", localException, "what happened?", new Object[0]);
      }
    }
  }
  
  public void dependency()
  {
    GMTrace.i(13629944496128L, 101551);
    dependsOnRoot();
    GMTrace.o(13629944496128L, 101551);
  }
  
  public void execute(final com.tencent.mm.kernel.b.e parame)
  {
    GMTrace.i(13630347149312L, 101554);
    if (parame.ej(""))
    {
      com.tencent.mm.kernel.h.vJ().gYG.bI(new n.a()
      {
        public final void a(n paramAnonymousn)
        {
          GMTrace.i(13623233609728L, 101501);
          PluginZero.this.szl.ad(parame.gZp);
          GMTrace.o(13623233609728L, 101501);
        }
        
        public final void a(n paramAnonymousn, boolean paramAnonymousBoolean)
        {
          GMTrace.i(13623099392000L, 101500);
          GMTrace.o(13623099392000L, 101500);
        }
      });
      NotifyReceiver.pX();
    }
    GMTrace.o(13630347149312L, 101554);
  }
  
  public void installed()
  {
    GMTrace.i(13629810278400L, 101550);
    alias(com.tencent.mm.plugin.zero.a.d.class);
    GMTrace.o(13629810278400L, 101550);
  }
  
  public void setILightPushDelegate(com.tencent.mm.plugin.zero.a.b paramb)
  {
    GMTrace.i(13630615584768L, 101556);
    this.szm = paramb;
    GMTrace.o(13630615584768L, 101556);
  }
  
  public String toString()
  {
    GMTrace.i(13629676060672L, 101549);
    GMTrace.o(13629676060672L, 101549);
    return "plugin-zero";
  }
  
  public static final class a
    extends com.tencent.mm.bn.a<com.tencent.mm.plugin.zero.a.a>
    implements com.tencent.mm.plugin.zero.a.a
  {
    public a()
    {
      GMTrace.i(13624710004736L, 101512);
      GMTrace.o(13624710004736L, 101512);
    }
    
    public final void a(final Service paramService)
    {
      GMTrace.i(13624844222464L, 101513);
      a(new com.tencent.mm.bn.a.a() {});
      GMTrace.o(13624844222464L, 101513);
    }
    
    public final void b(final Service paramService)
    {
      GMTrace.i(13624978440192L, 101514);
      a(new com.tencent.mm.bn.a.a() {});
      GMTrace.o(13624978440192L, 101514);
    }
  }
  
  public static final class b
    extends com.tencent.mm.bn.a<com.tencent.mm.plugin.zero.a.c>
    implements com.tencent.mm.plugin.zero.a.c
  {
    public b()
    {
      GMTrace.i(13620951908352L, 101484);
      GMTrace.o(13620951908352L, 101484);
    }
    
    public final void a(final NotifyReceiver.NotifyService paramNotifyService, final int paramInt, final byte[] paramArrayOfByte1, final byte[] paramArrayOfByte2, final long paramLong)
    {
      GMTrace.i(13621086126080L, 101485);
      a(new com.tencent.mm.bn.a.a() {});
      GMTrace.o(13621086126080L, 101485);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/zero/PluginZero.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */