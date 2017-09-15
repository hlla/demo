package com.tencent.mm.sdk.f;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class e
  implements f.a
{
  private static e uvT;
  static int[] uvU;
  public static long uvV;
  public static long uvW;
  private static b uvX;
  private static a uvY;
  private static b uvZ;
  private boolean fCw;
  volatile boolean fKw;
  Object lock;
  f uvL;
  private int uvM;
  private PriorityBlockingQueue<Runnable> uvN;
  LinkedList<g> uvO;
  private ArrayList<g> uvP;
  private HashMap<g, Thread> uvQ;
  ArrayList<c> uvR;
  c uvS;
  
  static
  {
    GMTrace.i(13987768958976L, 104217);
    uvU = new int[] { 19, 16, 13, 10, 0, -2, -4, -5, -6, -8 };
    uvV = 0L;
    uvW = 0L;
    GMTrace.o(13987768958976L, 104217);
  }
  
  private e()
  {
    GMTrace.i(13983473991680L, 104185);
    this.fCw = false;
    this.uvN = new PriorityBlockingQueue(33);
    this.uvO = new LinkedList();
    this.uvP = new ArrayList();
    this.uvQ = new HashMap();
    this.uvR = new ArrayList();
    this.lock = new Object();
    this.fKw = false;
    this.uvM = bKj();
    this.uvL = new f(this.uvM + 2, TimeUnit.SECONDS, this.uvN, this);
    HandlerThread localHandlerThread = Qt("THREAD_POOL_HANDLER");
    localHandlerThread.start();
    this.uvS = new c(localHandlerThread.getLooper());
    GMTrace.o(13983473991680L, 104185);
  }
  
  public static void O(Runnable paramRunnable)
  {
    GMTrace.i(13984950386688L, 104196);
    e locale = bKi();
    synchronized (locale.lock)
    {
      Thread localThread = locale.P(paramRunnable);
      if (localThread != null)
      {
        localThread.interrupt();
        GMTrace.o(13984950386688L, 104196);
        return;
      }
      locale.V(paramRunnable);
    }
  }
  
  private Thread P(Runnable paramRunnable)
  {
    GMTrace.i(13985084604416L, 104197);
    if (paramRunnable == null)
    {
      GMTrace.o(13985084604416L, 104197);
      return null;
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        Iterator localIterator = this.uvQ.keySet().iterator();
        if (localIterator != null)
        {
          if (!localIterator.hasNext()) {
            break label131;
          }
          g localg = (g)localIterator.next();
          if ((localg == null) || (!localg.urM.equals(paramRunnable))) {
            continue;
          }
          paramRunnable = localg;
          if (paramRunnable != null)
          {
            paramRunnable = (Thread)this.uvQ.get(paramRunnable);
            GMTrace.o(13985084604416L, 104197);
            return paramRunnable;
          }
        }
        GMTrace.o(13985084604416L, 104197);
        return null;
      }
      label131:
      paramRunnable = null;
    }
  }
  
  public static void Q(Runnable paramRunnable)
  {
    GMTrace.i(13985218822144L, 104198);
    bKi().R(paramRunnable);
    GMTrace.o(13985218822144L, 104198);
  }
  
  public static HandlerThread Qt(String paramString)
  {
    GMTrace.i(13987097870336L, 104212);
    paramString = bKn().cD(paramString, 0);
    GMTrace.o(13987097870336L, 104212);
    return paramString;
  }
  
  private void R(Runnable paramRunnable)
  {
    GMTrace.i(13985353039872L, 104199);
    Assert.assertNotNull("join arg runnable is null!", paramRunnable);
    a locala = null;
    synchronized (this.lock)
    {
      if (U(paramRunnable))
      {
        locala = new a(paramRunnable);
        b(locala);
      }
      if (locala == null) {
        break label102;
      }
    }
    try
    {
      if (this.uvR.contains(locala)) {
        paramRunnable.wait();
      }
      for (;;)
      {
        GMTrace.o(13985353039872L, 104199);
        return;
        paramRunnable = finally;
        throw paramRunnable;
        v.d("MicroMsg.ThreadPool", "|MMThreadPool joinTask runnable is not in observerList, just removed!");
      }
      GMTrace.o(13985353039872L, 104199);
    }
    finally {}
    label102:
  }
  
  public static void S(Runnable paramRunnable)
  {
    int j = 1;
    GMTrace.i(13985487257600L, 104200);
    e locale = bKi();
    Assert.assertNotNull("join arg runnable is null!", paramRunnable);
    if (5000L < 0L) {
      throw new IllegalArgumentException();
    }
    int i;
    if (5000L >= 9223372036854L)
    {
      i = 1;
      if (5000L != 0L) {
        break label85;
      }
    }
    for (;;)
    {
      if ((j | i) == 0) {
        break label90;
      }
      locale.R(paramRunnable);
      GMTrace.o(13985487257600L, 104200);
      return;
      i = 0;
      break;
      label85:
      j = 0;
    }
    label90:
    a locala = null;
    synchronized (locale.lock)
    {
      if (locale.U(paramRunnable))
      {
        locala = new a(locale, paramRunnable);
        bKi().b(locala);
      }
      if (locala == null) {
        break label193;
      }
    }
    try
    {
      if (locale.uvR.contains(locala)) {
        paramRunnable.wait(5000L, 0);
      }
      for (;;)
      {
        GMTrace.o(13985487257600L, 104200);
        return;
        paramRunnable = finally;
        throw paramRunnable;
        v.d("MicroMsg.ThreadPool", "|MMThreadPool joinTask runnable is not in observerList, just removed!");
      }
      GMTrace.o(13985487257600L, 104200);
    }
    finally {}
    label193:
  }
  
  public static boolean T(Runnable paramRunnable)
  {
    GMTrace.i(13985621475328L, 104201);
    boolean bool = bKi().U(paramRunnable);
    GMTrace.o(13985621475328L, 104201);
    return bool;
  }
  
  private boolean U(Runnable paramRunnable)
  {
    GMTrace.i(13985755693056L, 104202);
    if (paramRunnable == null)
    {
      GMTrace.o(13985755693056L, 104202);
      return false;
    }
    synchronized (this.lock)
    {
      Iterator localIterator = this.uvP.iterator();
      g localg;
      while ((localIterator != null) && (localIterator.hasNext()))
      {
        localg = (g)localIterator.next();
        if ((localg != null) && (localg.urM.equals(paramRunnable)))
        {
          GMTrace.o(13985755693056L, 104202);
          return true;
        }
      }
      localIterator = this.uvQ.keySet().iterator();
      while ((localIterator != null) && (localIterator.hasNext()))
      {
        localg = (g)localIterator.next();
        if ((localg != null) && (localg.urM.equals(paramRunnable)))
        {
          GMTrace.o(13985755693056L, 104202);
          return true;
        }
      }
      GMTrace.o(13985755693056L, 104202);
      return false;
    }
  }
  
  private boolean V(Runnable paramRunnable)
  {
    GMTrace.i(13986024128512L, 104204);
    if (paramRunnable == null)
    {
      GMTrace.o(13986024128512L, 104204);
      return false;
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        Iterator localIterator = this.uvP.iterator();
        if (localIterator != null)
        {
          if (!localIterator.hasNext()) {
            break label134;
          }
          g localg = (g)localIterator.next();
          if ((localg == null) || (!localg.urM.equals(paramRunnable))) {
            continue;
          }
          localIterator.remove();
          paramRunnable = localg;
          if (paramRunnable != null)
          {
            this.uvL.remove(paramRunnable);
            GMTrace.o(13986024128512L, 104204);
            return true;
          }
        }
        GMTrace.o(13986024128512L, 104204);
        return false;
      }
      label134:
      paramRunnable = null;
    }
  }
  
  public static void a(c paramc)
  {
    GMTrace.i(13984010862592L, 104189);
    bKi().b(paramc);
    GMTrace.o(13984010862592L, 104189);
  }
  
  public static void a(Runnable paramRunnable, String paramString)
  {
    GMTrace.i(13984816168960L, 104195);
    e locale = bKi();
    synchronized (locale.lock)
    {
      paramRunnable = new g(paramRunnable, paramString, Integer.MAX_VALUE, true, uvZ);
      locale.uvP.add(paramRunnable);
      locale.uvL.execute(paramRunnable);
      if ((locale.uvL.getActiveCount() >= locale.uvM) && (locale.uvM < bKj() * 2))
      {
        locale.uvM += 1;
        locale.uvL.setCorePoolSize(locale.uvM);
        locale.uvL.setMaximumPoolSize(locale.uvM);
        v.i("MicroMsg.ThreadPool", "|MMThreadPool postAtFront expand core pool size=" + locale.uvM);
        paramString = new ArrayList(locale.uvR).iterator();
      }
      while (paramString.hasNext())
      {
        paramString.next();
        Runnable localRunnable = paramRunnable.urM;
        continue;
        locale.bKk();
      }
    }
    locale.jT(false);
    GMTrace.o(13984816168960L, 104195);
  }
  
  public static Thread b(Runnable paramRunnable, String paramString)
  {
    GMTrace.i(13986695217152L, 104209);
    paramRunnable = bKm().a(paramRunnable, paramString, 5);
    GMTrace.o(13986695217152L, 104209);
    return paramRunnable;
  }
  
  private void b(c paramc)
  {
    GMTrace.i(13984145080320L, 104190);
    synchronized (this.lock)
    {
      if (!this.uvR.contains(paramc)) {
        this.uvR.add(paramc);
      }
      GMTrace.o(13984145080320L, 104190);
      return;
    }
  }
  
  public static void b(Runnable paramRunnable, String paramString, int paramInt)
  {
    GMTrace.i(13984547733504L, 104193);
    bKi().c(paramRunnable, paramString, paramInt);
    GMTrace.o(13984547733504L, 104193);
  }
  
  public static e bKi()
  {
    GMTrace.i(13983339773952L, 104184);
    if (uvT == null) {}
    try
    {
      if (uvT == null) {
        uvT = new e();
      }
      e locale = uvT;
      GMTrace.o(13983339773952L, 104184);
      return locale;
    }
    finally {}
  }
  
  private static int bKj()
  {
    int i = 32;
    GMTrace.i(13983608209408L, 104186);
    int j = Runtime.getRuntime().availableProcessors() * 4 + 2;
    if (j > 32) {}
    for (;;)
    {
      GMTrace.o(13983608209408L, 104186);
      return i;
      i = j;
    }
  }
  
  public static void bKl()
  {
    GMTrace.i(13986292563968L, 104206);
    bKi().jT(true);
    GMTrace.o(13986292563968L, 104206);
  }
  
  private static b bKm()
  {
    GMTrace.i(13986560999424L, 104208);
    if (uvX == null) {
      uvX = new b(uvZ);
    }
    b localb = uvX;
    GMTrace.o(13986560999424L, 104208);
    return localb;
  }
  
  private static a bKn()
  {
    GMTrace.i(13986963652608L, 104211);
    if (uvY == null) {
      uvY = new a(uvZ);
    }
    a locala = uvY;
    GMTrace.o(13986963652608L, 104211);
    return locala;
  }
  
  public static void c(c paramc)
  {
    GMTrace.i(13984279298048L, 104191);
    e locale = bKi();
    synchronized (locale.lock)
    {
      locale.uvR.remove(paramc);
      GMTrace.o(13984279298048L, 104191);
      return;
    }
  }
  
  private void c(Runnable paramRunnable, String paramString, int paramInt)
  {
    GMTrace.i(13984681951232L, 104194);
    synchronized (this.lock)
    {
      paramRunnable = new g(paramRunnable, paramString, paramInt, true, uvZ);
      this.uvO.add(paramRunnable);
      this.uvP.add(paramRunnable);
      this.uvS.sendEmptyMessage(1);
      jT(false);
      GMTrace.o(13984681951232L, 104194);
      return;
    }
  }
  
  public static HandlerThread cE(String paramString, int paramInt)
  {
    GMTrace.i(13987232088064L, 104213);
    paramString = bKn().cD(paramString, paramInt);
    GMTrace.o(13987232088064L, 104213);
    return paramString;
  }
  
  public static Thread d(Runnable paramRunnable, String paramString, int paramInt)
  {
    GMTrace.i(13986829434880L, 104210);
    paramRunnable = bKm().a(paramRunnable, paramString, paramInt);
    GMTrace.o(13986829434880L, 104210);
    return paramRunnable;
  }
  
  private void jT(boolean paramBoolean)
  {
    GMTrace.i(13986426781696L, 104207);
    if (!paramBoolean)
    {
      GMTrace.o(13986426781696L, 104207);
      return;
    }
    g localg;
    synchronized (this.lock)
    {
      v.i("MicroMsg.ThreadPool", "------------------------------------------");
      Iterator localIterator1 = this.uvO.iterator();
      if ((localIterator1 != null) && (localIterator1.hasNext()))
      {
        localg = (g)localIterator1.next();
        v.i("MicroMsg.ThreadPool", "|MMThreadPool adding task{" + localg + "}");
      }
    }
    v.i("MicroMsg.ThreadPool", "-----------");
    Iterator localIterator2 = this.uvP.iterator();
    if (localIterator2 != null) {
      while (localIterator2.hasNext())
      {
        localg = (g)localIterator2.next();
        v.i("MicroMsg.ThreadPool", "|MMThreadPool waiting task{" + localg + "}");
      }
    }
    v.i("MicroMsg.ThreadPool", "-----------");
    localIterator2 = this.uvQ.keySet().iterator();
    if (localIterator2 != null) {
      while (localIterator2.hasNext())
      {
        localg = (g)localIterator2.next();
        v.i("MicroMsg.ThreadPool", "|MMThreadPool running task{" + localg + "}");
      }
    }
    v.i("MicroMsg.ThreadPool", "-----------");
    v.i("MicroMsg.ThreadPool", "|MMThreadPool poolSize=" + this.uvL.getPoolSize() + "|activeCount=" + this.uvL.getActiveCount() + "|corePoolSize=" + this.uvL.getPoolSize() + "|largestPoolSize=" + this.uvL.getLargestPoolSize() + "|maximuPoolSize=" + this.uvL.getMaximumPoolSize());
    v.i("MicroMsg.ThreadPool", "------------------------------------------");
    GMTrace.o(13986426781696L, 104207);
  }
  
  public static void post(Runnable paramRunnable, String paramString)
  {
    GMTrace.i(13984413515776L, 104192);
    bKi().c(paramRunnable, paramString, 5);
    GMTrace.o(13984413515776L, 104192);
  }
  
  public static boolean remove(Runnable paramRunnable)
  {
    GMTrace.i(13985889910784L, 104203);
    boolean bool = bKi().V(paramRunnable);
    GMTrace.o(13985889910784L, 104203);
    return bool;
  }
  
  public final void N(Runnable paramRunnable)
  {
    GMTrace.i(13983876644864L, 104188);
    for (;;)
    {
      synchronized (this.lock)
      {
        paramRunnable = (g)paramRunnable;
        Iterator localIterator = this.uvQ.keySet().iterator();
        if (localIterator != null)
        {
          if (!localIterator.hasNext()) {
            break label269;
          }
          g localg = (g)localIterator.next();
          if ((localg == null) || (!localg.equals(paramRunnable))) {
            continue;
          }
          localIterator.remove();
          i = 1;
          if (i != 0)
          {
            localIterator = new ArrayList(this.uvR).iterator();
            if (localIterator.hasNext()) {
              ((c)localIterator.next()).x(paramRunnable.urM);
            }
          }
        }
      }
      int i = this.uvL.getActiveCount();
      int j = this.uvL.getQueue().size();
      int k = this.uvL.getCorePoolSize();
      if ((i == 1) && (j == 0))
      {
        if (k > 0)
        {
          this.uvM = bKj();
          this.uvL.setCorePoolSize(0);
          this.uvL.setMaximumPoolSize(this.uvM + 2);
        }
        paramRunnable = new ArrayList(this.uvR).iterator();
        while (paramRunnable.hasNext()) {
          paramRunnable.next();
        }
        this.fCw = false;
      }
      GMTrace.o(13983876644864L, 104188);
      return;
      label269:
      i = 0;
    }
  }
  
  final void bKk()
  {
    GMTrace.i(13986158346240L, 104205);
    if (this.uvL.getCorePoolSize() < this.uvM)
    {
      this.uvL.setCorePoolSize(this.uvM);
      this.uvL.setMaximumPoolSize(this.uvM);
    }
    GMTrace.o(13986158346240L, 104205);
  }
  
  public final void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    int i = 10;
    GMTrace.i(13983742427136L, 104187);
    for (;;)
    {
      Object localObject2;
      int j;
      synchronized (this.lock)
      {
        localObject2 = this.uvP.iterator();
        if (localObject2 == null) {
          break label225;
        }
        paramRunnable = (g)paramRunnable;
        j = paramRunnable.priority;
        if (j <= 0)
        {
          i = 1;
          paramThread.setPriority(i);
          paramThread.setName(paramRunnable.mih);
          if (!((Iterator)localObject2).hasNext()) {
            break label238;
          }
          g localg = (g)((Iterator)localObject2).next();
          if ((localg == null) || (!localg.equals(paramRunnable))) {
            continue;
          }
          ((Iterator)localObject2).remove();
          i = 1;
          if (i == 0) {
            break label225;
          }
          this.uvQ.put(paramRunnable, paramThread);
          paramThread = new ArrayList(this.uvR);
          if (this.fCw) {
            break label190;
          }
          localObject2 = paramThread.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label190;
          }
          ((Iterator)localObject2).next();
        }
      }
      if (j <= 10)
      {
        i = j;
        continue;
        label190:
        this.fCw = true;
        paramThread = paramThread.iterator();
        while (paramThread.hasNext())
        {
          paramThread.next();
          localObject2 = paramRunnable.urM;
        }
        label225:
        GMTrace.o(13983742427136L, 104187);
        return;
        label238:
        i = 0;
      }
    }
  }
  
  final class a
    implements c
  {
    private final Runnable uwa;
    
    public a(Runnable paramRunnable)
    {
      GMTrace.i(13980923854848L, 104166);
      this.uwa = paramRunnable;
      GMTrace.o(13980923854848L, 104166);
    }
    
    public final void x(Runnable arg1)
    {
      GMTrace.i(13981058072576L, 104167);
      if (???.equals(this.uwa)) {
        synchronized (this.uwa)
        {
          this.uwa.notifyAll();
          e.c(this);
          GMTrace.o(13981058072576L, 104167);
          return;
        }
      }
      GMTrace.o(13981058072576L, 104167);
    }
  }
  
  public static abstract interface b {}
  
  final class c
    extends ad
  {
    public c(Looper paramLooper)
    {
      super();
      GMTrace.i(13981863378944L, 104173);
      GMTrace.o(13981863378944L, 104173);
    }
    
    public final void handleMessage(Message arg1)
    {
      GMTrace.i(13981997596672L, 104174);
      switch (???.what)
      {
      default: 
        GMTrace.o(13981997596672L, 104174);
        return;
      }
      removeMessages(???.what);
      if (e.this.fKw)
      {
        long l = System.currentTimeMillis();
        e locale1;
        if ((e.uvV > 0L) && (Math.abs(e.uvW - l) > e.uvV))
        {
          v.i("MicroMsg.ThreadPool", "|MMThreadPool thread pool is auto wakeup");
          locale1 = e.this;
        }
        synchronized (locale1.lock)
        {
          locale1.fKw = false;
          e.uvW = 0L;
          e.uvV = 0L;
          sendEmptyMessageDelayed(1, 1000L);
          GMTrace.o(13981997596672L, 104174);
          return;
        }
      }
      e locale2 = e.this;
      synchronized (locale2.lock)
      {
        if (!locale2.uvO.isEmpty())
        {
          Iterator localIterator = locale2.uvO.iterator();
          if ((localIterator != null) && (localIterator.hasNext()))
          {
            g localg = (g)localIterator.next();
            localIterator.remove();
            locale2.bKk();
            locale2.uvL.execute(localg);
            localIterator = new ArrayList(locale2.uvR).iterator();
            if (localIterator.hasNext())
            {
              localIterator.next();
              Runnable localRunnable = localg.urM;
              locale2.uvL.getActiveCount();
            }
          }
        }
      }
      if (!((e)localObject2).uvO.isEmpty()) {
        ((e)localObject2).uvS.sendEmptyMessage(1);
      }
      GMTrace.o(13981997596672L, 104174);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */