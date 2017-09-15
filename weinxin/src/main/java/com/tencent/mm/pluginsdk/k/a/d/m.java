package com.tencent.mm.pluginsdk.k.a.d;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class m
  extends f<k>
{
  private final f<k>.a sFd;
  public final c sFe;
  
  public m(t paramt, c paramc)
  {
    this(paramt, paramc, (byte)0);
    GMTrace.i(879394553856L, 6552);
    GMTrace.o(879394553856L, 6552);
  }
  
  private m(t paramt, c paramc, byte paramByte)
  {
    GMTrace.i(879528771584L, 6553);
    this.sFd = new f.a(this, 4, 4, 3000L, TimeUnit.MILLISECONDS, new c(), paramt);
    this.sFd.setKeepAliveTime(30000L, TimeUnit.MILLISECONDS);
    this.sFd.allowCoreThreadTimeOut(true);
    this.sFe = paramc;
    GMTrace.o(879528771584L, 6553);
  }
  
  public f.d a(k paramk)
  {
    GMTrace.i(880065642496L, 6557);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + paramk.getClass().getSimpleName());
    Object localObject = o.a.sFk;
    a locala = o.c(paramk);
    localObject = locala;
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
      localObject = new b(paramk);
    }
    ((a)localObject).sFg = this.sFe;
    GMTrace.o(880065642496L, 6557);
    return (f.d)localObject;
  }
  
  public int b(k paramk)
  {
    int j = 0;
    GMTrace.i(879662989312L, 6554);
    if ((Mr(paramk.sDr)) || (isDownloading(paramk.sDr)))
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", new Object[] { paramk.sDr });
      GMTrace.o(879662989312L, 6554);
      return 0;
    }
    int i = com.tencent.mm.compatible.d.v.rR();
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(paramk.networkType) });
    if (i != 0) {
      if (2 == paramk.networkType) {
        i = 1;
      }
    }
    while (i == 0)
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", new Object[] { paramk.sDr });
      GMTrace.o(879662989312L, 6554);
      return 1;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((!this.sFd.isShutdown()) && (!this.sFd.isTerminated()))
    {
      i = j;
      if (!this.sFd.isTerminating()) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0)
    {
      GMTrace.o(879662989312L, 6554);
      return 4;
    }
    super.b(paramk);
    GMTrace.o(879662989312L, 6554);
    return 2;
  }
  
  protected final f<k>.a bDn()
  {
    GMTrace.i(879931424768L, 6556);
    f.a locala = this.sFd;
    GMTrace.o(879931424768L, 6556);
    return locala;
  }
  
  public final boolean isDownloading(String paramString)
  {
    GMTrace.i(879797207040L, 6555);
    boolean bool = this.sEO.containsKey(paramString);
    GMTrace.o(879797207040L, 6555);
    return bool;
  }
  
  public void shutdown()
  {
    GMTrace.i(17774587936768L, 132431);
    this.sFd.shutdownNow();
    Iterator localIterator = this.sEO.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Future)this.sEO.get(localObject);
      if (localObject != null) {
        ((Future)localObject).cancel(true);
      }
    }
    this.sEN.clear();
    this.sEO.clear();
    GMTrace.o(17774587936768L, 132431);
  }
  
  public static abstract class a<Req extends k>
    extends f.d<Req>
    implements e
  {
    private static final ThreadLocal<j> sFf;
    private volatile int hNz;
    private final int sDB;
    public volatile c sFg;
    
    static
    {
      GMTrace.i(874965368832L, 6519);
      sFf = new ThreadLocal() {};
      GMTrace.o(874965368832L, 6519);
    }
    
    public a(Req paramReq)
    {
      super();
      GMTrace.i(872281014272L, 6499);
      this.sDB = paramReq.sDB;
      this.hNz = this.sDB;
      GMTrace.o(872281014272L, 6499);
    }
    
    public boolean Qp()
    {
      GMTrace.i(872817885184L, 6503);
      GMTrace.o(872817885184L, 6503);
      return false;
    }
    
    public boolean Qq()
    {
      GMTrace.i(872952102912L, 6504);
      GMTrace.o(872952102912L, 6504);
      return true;
    }
    
    public boolean Qr()
    {
      GMTrace.i(873086320640L, 6505);
      GMTrace.o(873086320640L, 6505);
      return false;
    }
    
    public boolean Qs()
    {
      GMTrace.i(872549449728L, 6501);
      GMTrace.o(872549449728L, 6501);
      return true;
    }
    
    public boolean Qt()
    {
      GMTrace.i(873220538368L, 6506);
      GMTrace.o(873220538368L, 6506);
      return true;
    }
    
    public boolean Qu()
    {
      GMTrace.i(874562715648L, 6516);
      int i = this.hNz - 1;
      this.hNz = i;
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.sFg.n(bDh(), this.sDB, this.hNz);
        GMTrace.o(874562715648L, 6516);
        return bool;
      }
    }
    
    public l a(j paramj)
    {
      GMTrace.i(872415232000L, 6500);
      if (!Qs())
      {
        paramj = paramj.a(this);
        GMTrace.o(872415232000L, 6500);
        return paramj;
      }
      q localq = o.a.sFk.Mt(bDh());
      if (localq != null)
      {
        localq.field_status = 1;
        o.a.sFk.e(localq);
      }
      paramj = paramj.a(this);
      GMTrace.o(872415232000L, 6500);
      return paramj;
    }
    
    public final String bDh()
    {
      GMTrace.i(874294280192L, 6514);
      String str = ((k)Qv()).sDr;
      GMTrace.o(874294280192L, 6514);
      return str;
    }
    
    public final String bDt()
    {
      GMTrace.i(873488973824L, 6508);
      GMTrace.o(873488973824L, 6508);
      return "GET";
    }
    
    public final Collection<b> bDu()
    {
      GMTrace.i(873623191552L, 6509);
      Map localMap = ((k)Qv()).getRequestHeaders();
      if ((localMap == null) || (localMap.size() == 0))
      {
        GMTrace.o(873623191552L, 6509);
        return null;
      }
      Object localObject = localMap.keySet();
      if ((localObject == null) || (((Set)localObject).size() == 0))
      {
        GMTrace.o(873623191552L, 6509);
        return null;
      }
      LinkedList localLinkedList = new LinkedList();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = (String)localMap.get(str1);
        if (!bf.mA(str2)) {
          localLinkedList.add(new b(str1, str2));
        }
      }
      GMTrace.o(873623191552L, 6509);
      return localLinkedList;
    }
    
    public final int bDv()
    {
      GMTrace.i(874025844736L, 6512);
      int i = ((k)Qv()).bDv();
      GMTrace.o(874025844736L, 6512);
      return i;
    }
    
    public final String bDw()
    {
      GMTrace.i(874160062464L, 6513);
      GMTrace.o(874160062464L, 6513);
      return "application/x-www-form-urlencoded;charset=utf-8";
    }
    
    public boolean dW(long paramLong)
    {
      GMTrace.i(874696933376L, 6517);
      this.sFg.n(bDh(), paramLong);
      long l = au.bJu();
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", new Object[] { bDh(), Long.valueOf(l) });
      if (l >= paramLong)
      {
        GMTrace.o(874696933376L, 6517);
        return true;
      }
      GMTrace.o(874696933376L, 6517);
      return false;
    }
    
    public final int getConnectTimeout()
    {
      GMTrace.i(873757409280L, 6510);
      int i = ((k)Qv()).getConnectTimeout();
      GMTrace.o(873757409280L, 6510);
      return i;
    }
    
    public final String getFilePath()
    {
      GMTrace.i(874428497920L, 6515);
      String str = ((k)Qv()).getFilePath();
      GMTrace.o(874428497920L, 6515);
      return str;
    }
    
    public final int getReadTimeout()
    {
      GMTrace.i(873891627008L, 6511);
      int i = ((k)Qv()).getReadTimeout();
      GMTrace.o(873891627008L, 6511);
      return i;
    }
    
    public String getURL()
    {
      GMTrace.i(873354756096L, 6507);
      String str = ((k)Qv()).url;
      GMTrace.o(873354756096L, 6507);
      return str;
    }
    
    public final void run()
    {
      GMTrace.i(872683667456L, 6502);
      l locall = a((j)sFf.get());
      if (locall != null)
      {
        this.sFg.a(this, locall);
        GMTrace.o(872683667456L, 6502);
        return;
      }
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", new Object[] { Qo() });
      GMTrace.o(872683667456L, 6502);
    }
  }
  
  private static final class b
    extends m.a<k>
  {
    b(k paramk)
    {
      super();
      GMTrace.i(868657135616L, 6472);
      GMTrace.o(868657135616L, 6472);
    }
    
    public final String Qo()
    {
      GMTrace.i(868791353344L, 6473);
      GMTrace.o(868791353344L, 6473);
      return "ResDownload";
    }
  }
  
  private static final class c
    extends PriorityBlockingQueue<Runnable>
  {
    public c()
    {
      super(new Comparator() {});
      GMTrace.i(875099586560L, 6520);
      GMTrace.o(875099586560L, 6520);
    }
    
    private static String E(Runnable paramRunnable)
    {
      GMTrace.i(875233804288L, 6521);
      if ((paramRunnable instanceof f.c))
      {
        if ((((f.c)paramRunnable).sEQ instanceof k))
        {
          paramRunnable = String.format("priority = %d, urlKey = %s", new Object[] { Integer.valueOf(((k)((f.c)paramRunnable).sEQ).priority), ((f.c)paramRunnable).sEQ.bDh() });
          GMTrace.o(875233804288L, 6521);
          return paramRunnable;
        }
        paramRunnable = String.format("unknown request = %s", new Object[] { ((f.c)paramRunnable).sEQ });
        GMTrace.o(875233804288L, 6521);
        return paramRunnable;
      }
      paramRunnable = String.format("unknown runnable = %s", new Object[] { paramRunnable });
      GMTrace.o(875233804288L, 6521);
      return paramRunnable;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/d/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */