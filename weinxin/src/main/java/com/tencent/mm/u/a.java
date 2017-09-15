package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.n;

public final class a
{
  public byte[] hko;
  public long hkp;
  
  public a()
  {
    GMTrace.i(13474788802560L, 100395);
    this.hkp = -1L;
    if (wI()) {
      ae.f(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13476667850752L, 100409);
          try
          {
            if (a.wI()) {
              com.tencent.mm.plugin.report.c.oRz.a(226L, 1L, 1L, false);
            }
            GMTrace.o(13476667850752L, 100409);
            return;
          }
          catch (Exception localException)
          {
            v.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", new Object[] { bf.g(localException) });
            GMTrace.o(13476667850752L, 100409);
          }
        }
      }, 5000L);
    }
    GMTrace.o(13474788802560L, 100395);
  }
  
  public static boolean wI()
  {
    GMTrace.i(13474923020288L, 100396);
    if ((com.tencent.mm.kernel.a.uP()) || (!com.tencent.mm.kernel.h.vG().uV()))
    {
      GMTrace.o(13474923020288L, 100396);
      return false;
    }
    int i = bf.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("AndroidUseWorkerAuthCache"), 0);
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG();
    int j = com.tencent.mm.a.h.aw(com.tencent.mm.kernel.a.uH(), 100);
    boolean bool = com.tencent.mm.sdk.a.b.bIk();
    com.tencent.mm.kernel.h.vJ();
    com.tencent.mm.kernel.h.vG();
    v.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.kernel.a.uH()), Integer.valueOf(j), Boolean.valueOf(com.tencent.mm.kernel.h.vG().uV()) });
    if (bool)
    {
      GMTrace.o(13474923020288L, 100396);
      return true;
    }
    if (i > j)
    {
      GMTrace.o(13474923020288L, 100396);
      return true;
    }
    GMTrace.o(13474923020288L, 100396);
    return false;
  }
  
  public static void wJ()
  {
    GMTrace.i(13475057238016L, 100397);
    if (!wI())
    {
      GMTrace.o(13475057238016L, 100397);
      return;
    }
    long l2;
    try
    {
      com.tencent.mm.kernel.h.vJ();
      a locala = com.tencent.mm.kernel.h.vG().gWZ;
      com.tencent.mm.kernel.h.vJ();
      localObject = com.tencent.mm.kernel.h.vH().gXs.hsI.Cc();
      l2 = bf.NA();
      if (localObject == null)
      {
        v.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
        com.tencent.mm.plugin.report.c.oRz.a(226L, 2L, 1L, false);
        GMTrace.o(13475057238016L, 100397);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      v.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", new Object[] { bf.g(localThrowable) });
      GMTrace.o(13475057238016L, 100397);
      return;
    }
    v.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.network.c)localObject).BY()), Integer.valueOf(localThrowable.wH()) });
    if (!((com.tencent.mm.network.c)localObject).BY())
    {
      com.tencent.mm.plugin.report.c.oRz.a(226L, 3L, 1L, false);
      v.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
      GMTrace.o(13475057238016L, 100397);
      return;
    }
    localThrowable.hko = ((com.tencent.mm.network.c)localObject).Cb();
    Object localObject = com.tencent.mm.plugin.report.c.oRz;
    if (localThrowable.wH() > 0)
    {
      l1 = 4L;
      ((com.tencent.mm.plugin.report.c)localObject).a(226L, l1, 1L, false);
      v.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", new Object[] { Long.valueOf(bf.aA(l2)), Integer.valueOf(localThrowable.wH()), Long.valueOf(localThrowable.hkp) });
      if (localThrowable.wH() > 0)
      {
        localObject = com.tencent.mm.plugin.report.c.oRz;
        if (localThrowable.hkp <= 5L) {
          break label383;
        }
      }
    }
    label383:
    for (long l1 = 5L;; l1 = localThrowable.hkp)
    {
      ((com.tencent.mm.plugin.report.c)localObject).a(226L, 31L - l1, 1L, false);
      com.tencent.mm.plugin.report.c.oRz.i(11098, new Object[] { Integer.valueOf(2000), Long.valueOf(localThrowable.hkp) });
      localThrowable.hkp = -1L;
      GMTrace.o(13475057238016L, 100397);
      return;
      l1 = 5L;
      break;
    }
  }
  
  public final int wH()
  {
    GMTrace.i(13474654584832L, 100394);
    if (this.hko == null)
    {
      GMTrace.o(13474654584832L, 100394);
      return -1;
    }
    int i = this.hko.length;
    GMTrace.o(13474654584832L, 100394);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */