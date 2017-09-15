package com.tencent.mm.pluginsdk.k.a.d;

import android.os.Looper;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public final class o
{
  public final ad handler;
  private volatile ae hsJ;
  public final boolean rWt;
  public final r sFh;
  public final m sFi;
  public final i sFj;
  
  public o()
  {
    GMTrace.i(877381287936L, 6537);
    this.hsJ = null;
    p.init();
    this.sFh = r.bDA();
    if (this.sFh == null)
    {
      this.rWt = false;
      this.sFi = null;
      this.handler = null;
      this.sFj = null;
      GMTrace.o(877381287936L, 6537);
      return;
    }
    this.rWt = true;
    t localt = new t();
    this.handler = new ad(Looper.getMainLooper());
    this.sFj = new i(vL().bJb());
    this.sFi = new m(localt, this.sFj);
    GMTrace.o(877381287936L, 6537);
  }
  
  static m.a c(k paramk)
  {
    GMTrace.i(877918158848L, 6541);
    v.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
    int i = paramk.Qo().hashCode();
    Iterator localIterator = p.bDz().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      v.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", new Object[] { localg.getClass().getSimpleName(), localg.Qo() });
      if (localg.Qo().hashCode() == i)
      {
        paramk = localg.c(paramk);
        GMTrace.o(877918158848L, 6541);
        return paramk;
      }
    }
    GMTrace.o(877918158848L, 6541);
    return null;
  }
  
  public final q Mt(String paramString)
  {
    GMTrace.i(878186594304L, 6543);
    if (this.rWt)
    {
      long l = bf.NA();
      q localq = this.sFh.Mt(paramString);
      if (localq == null) {}
      for (paramString = "null";; paramString = localq.field_urlKey)
      {
        v.i("MicroMsg.ResDownloaderCore", "doQuery: urlKey = %s, cost = %d", new Object[] { paramString, Long.valueOf(bf.aA(l)) });
        GMTrace.o(878186594304L, 6543);
        return localq;
      }
    }
    GMTrace.o(878186594304L, 6543);
    return null;
  }
  
  public final boolean Mu(String paramString)
  {
    GMTrace.i(878455029760L, 6545);
    if (this.rWt)
    {
      if ((this.sFi.isDownloading(paramString)) || (this.sFi.Mr(paramString)))
      {
        GMTrace.o(878455029760L, 6545);
        return true;
      }
      GMTrace.o(878455029760L, 6545);
      return false;
    }
    GMTrace.o(878455029760L, 6545);
    return false;
  }
  
  public final void Mv(String paramString)
  {
    GMTrace.i(878589247488L, 6546);
    if (this.rWt)
    {
      m localm = this.sFi;
      Future localFuture = (Future)localm.sEO.remove(paramString);
      if (localFuture != null) {
        localFuture.cancel(true);
      }
      localm.sEN.remove(paramString);
    }
    GMTrace.o(878589247488L, 6546);
  }
  
  public final void a(String paramString, d paramd)
  {
    GMTrace.i(877783941120L, 6540);
    v.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", new Object[] { paramString, paramd });
    if (this.rWt)
    {
      i locali = this.sFj;
      v.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = " + paramd);
      if (paramd == null)
      {
        GMTrace.o(877783941120L, 6540);
        return;
      }
      int i = paramString.hashCode();
      synchronized (locali.sET)
      {
        List localList = (List)locali.sES.get(i);
        paramString = localList;
        if (localList == null) {
          paramString = new LinkedList();
        }
        paramString.add(paramd);
        locali.sES.put(i, paramString);
        GMTrace.o(877783941120L, 6540);
        return;
      }
    }
    GMTrace.o(877783941120L, 6540);
  }
  
  public final int d(k paramk)
  {
    GMTrace.i(878320812032L, 6544);
    if (this.rWt)
    {
      if (bf.mA(paramk.url))
      {
        v.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", new Object[] { paramk.sDr });
        GMTrace.o(878320812032L, 6544);
        return 3;
      }
      v.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", new Object[] { paramk.sDr });
      int i = this.sFi.b(paramk);
      GMTrace.o(878320812032L, 6544);
      return i;
    }
    GMTrace.o(878320812032L, 6544);
    return -1;
  }
  
  public final void e(q paramq)
  {
    GMTrace.i(878052376576L, 6542);
    long l;
    if (this.rWt)
    {
      l = bf.NA();
      if (this.sFh.Mt(paramq.field_urlKey) == null) {
        break label90;
      }
      v.i("MicroMsg.ResDownloaderCore", "doUpdate: update existing record");
      this.sFh.f(paramq);
    }
    for (;;)
    {
      v.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, cost = %d", new Object[] { paramq.field_urlKey, Long.valueOf(bf.aA(l)) });
      GMTrace.o(878052376576L, 6542);
      return;
      label90:
      v.i("MicroMsg.ResDownloaderCore", "doUpdate: insert new record");
      this.sFh.g(paramq);
    }
  }
  
  final ae vL()
  {
    GMTrace.i(877649723392L, 6539);
    if (this.hsJ == null) {
      this.hsJ = new ae("ResDownloader-WorkerThread");
    }
    ae localae = this.hsJ;
    GMTrace.o(877649723392L, 6539);
    return localae;
  }
  
  public final void y(Runnable paramRunnable)
  {
    GMTrace.i(877515505664L, 6538);
    vL().D(new b(paramRunnable));
    GMTrace.o(877515505664L, 6538);
  }
  
  private static final class a
  {
    public static final o sFk;
    
    static
    {
      GMTrace.i(878991900672L, 6549);
      sFk = new o();
      GMTrace.o(878991900672L, 6549);
    }
  }
  
  private static final class b
    implements Runnable
  {
    private final Runnable ibz;
    
    public b(Runnable paramRunnable)
    {
      GMTrace.i(871744143360L, 6495);
      this.ibz = paramRunnable;
      GMTrace.o(871744143360L, 6495);
    }
    
    public final void run()
    {
      GMTrace.i(871878361088L, 6496);
      if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (Process.getThreadPriority(Process.myTid()) != 10)) {
          Process.setThreadPriority(10);
        }
        if (this.ibz != null) {
          this.ibz.run();
        }
        GMTrace.o(871878361088L, 6496);
        return;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/d/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */