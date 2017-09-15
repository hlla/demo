package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.a.b;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.b.f.1;
import com.tencent.mm.kernel.b.f.2;
import com.tencent.mm.kernel.b.f.3;
import com.tencent.mm.kernel.b.f.4;
import com.tencent.mm.kernel.b.f.5;
import com.tencent.mm.kernel.b.f.6;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.i;
import com.tencent.mm.kernel.i.1;
import com.tencent.mm.vending.g.d.b;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import junit.framework.Assert;

public class MMApplicationWrapper
  implements ApplicationLifeCycle
{
  private static final String TAG = "MicroMsg.MMApplicationWrapper";
  public Application app;
  private final MMApplicationLike lifeCycle;
  private com.tencent.mm.kernel.b.f profile;
  private String thisProcess;
  
  public MMApplicationWrapper(MMApplicationLike paramMMApplicationLike, String paramString)
  {
    GMTrace.i(14280497823744L, 106398);
    this.thisProcess = "";
    this.profile = null;
    this.app = paramMMApplicationLike.getApplication();
    this.lifeCycle = paramMMApplicationLike;
    this.thisProcess = paramString;
    GMTrace.o(14280497823744L, 106398);
  }
  
  public void onBaseContextAttached(Context paramContext)
  {
    GMTrace.i(14280632041472L, 106399);
    com.tencent.mm.kernel.h.a(this.thisProcess, this.app, this.lifeCycle);
    com.tencent.mm.kernel.h.vJ();
    this.profile = ((com.tencent.mm.kernel.b.f)com.tencent.mm.kernel.h.vF().vj());
    com.tencent.mm.kernel.b.f localf = this.profile;
    localf.gZr.a(new f.6(localf, paramContext));
    GMTrace.o(14280632041472L, 106399);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(14281034694656L, 106402);
    if (this.profile != null)
    {
      com.tencent.mm.kernel.b.f localf = this.profile;
      localf.gZr.a(new f.5(localf, paramConfiguration));
    }
    GMTrace.o(14281034694656L, 106402);
  }
  
  public void onCreate()
  {
    GMTrace.i(14280766259200L, 106400);
    try
    {
      Object localObject1 = this.profile;
      ((com.tencent.mm.kernel.b.f)localObject1).gZr.a(new f.1((com.tencent.mm.kernel.b.f)localObject1));
      localObject1 = this.profile.gZo;
      ??? = new f();
      Assert.assertNotNull(???);
      i.vN().vF().vj();
      ((com.tencent.mm.kernel.a.a)localObject1).gZg = ((b)???);
      localObject1 = com.tencent.mm.kernel.h.vJ().gYz;
      synchronized (((i)localObject1).gYU)
      {
        if (((i)localObject1).gYV)
        {
          com.tencent.mm.kernel.a.a.a("warning, mmskeleton has started up already.", new Object[0]);
          GMTrace.o(14280766259200L, 106400);
          return;
        }
        ??? = ((i)localObject1).vF().vj();
        long l1 = com.tencent.mm.kernel.a.a.timestamp();
        com.tencent.mm.kernel.a.a.a("mmskeleton boot startup for process [%s]...", new Object[] { ((e)???).gWE });
        com.tencent.mm.kernel.a.a locala = ((e)???).gZo;
        Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", locala.gZg);
        com.tencent.mm.kernel.a.a.a("hello WeChat.", new Object[0]);
        locala.gZg.od();
        long l2 = com.tencent.mm.kernel.a.a.timestamp();
        com.tencent.mm.kernel.a.a.a("boot install plugins...", new Object[0]);
        locala.gZg.oe();
        i.vN();
        com.tencent.mm.kernel.a.a.a("boot all installed plugins : %s...", new Object[] { i.vE().gXD });
        com.tencent.mm.kernel.a.a.a("boot install plugins done in [%s].", new Object[] { com.tencent.mm.kernel.a.a.H(l2) });
        l2 = com.tencent.mm.kernel.a.a.timestamp();
        com.tencent.mm.kernel.a.a.a("boot make dependency of plugins...", new Object[0]);
        locala.gZg.vO();
        com.tencent.mm.kernel.a.a.a("boot make dependency of done in [%s].", new Object[] { com.tencent.mm.kernel.a.a.H(l2) });
        l2 = com.tencent.mm.kernel.a.a.timestamp();
        com.tencent.mm.kernel.a.a.a("boot configure plugins...", new Object[0]);
        locala.gZg.c((e)???);
        com.tencent.mm.kernel.a.a.a("boot configure plugins done in [%s].", new Object[] { com.tencent.mm.kernel.a.a.H(l2) });
        com.tencent.mm.vending.h.h localh = com.tencent.mm.vending.h.d.wBu;
        localObject1 = new i.1((i)localObject1, l1);
        com.tencent.mm.kernel.a.a.a("boot execute tasks...", new Object[0]);
        locala.gZg.a((e)???, localh, (d.b)localObject1);
        GMTrace.o(14280766259200L, 106400);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      new Handler().postAtFrontOfQueue(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14280363606016L, 106397);
          throw localThrowable;
        }
      });
      GMTrace.o(14280766259200L, 106400);
    }
  }
  
  public void onLowMemory()
  {
    GMTrace.i(14281168912384L, 106403);
    if (this.profile != null)
    {
      com.tencent.mm.kernel.b.f localf = this.profile;
      localf.gZr.a(new f.2(localf));
    }
    GMTrace.o(14281168912384L, 106403);
  }
  
  public void onTerminate()
  {
    GMTrace.i(14280900476928L, 106401);
    if (this.profile != null)
    {
      com.tencent.mm.kernel.b.f localf = this.profile;
      localf.gZr.a(new f.4(localf));
    }
    GMTrace.o(14280900476928L, 106401);
  }
  
  public void onTrimMemory(int paramInt)
  {
    GMTrace.i(14281303130112L, 106404);
    if (this.profile != null)
    {
      com.tencent.mm.kernel.b.f localf = this.profile;
      localf.gZr.a(new f.3(localf, paramInt));
    }
    GMTrace.o(14281303130112L, 106404);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/MMApplicationWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */