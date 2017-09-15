package com.tencent.mm.y;

import android.os.Looper;
import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class n
  implements e
{
  private static n hsH;
  private static int hsS;
  public boolean foreground;
  public final ad handler;
  public com.tencent.mm.network.e hsI;
  public ae hsJ;
  public Vector<k> hsK;
  public Vector<k> hsL;
  public final Map<Integer, Set<e>> hsM;
  private Boolean hsN;
  public final a hsO;
  private long hsP;
  public boolean hsQ;
  private ai hsR;
  public final Object lock;
  
  static
  {
    GMTrace.i(13417612050432L, 99969);
    hsH = null;
    hsS = 1;
    GMTrace.o(13417612050432L, 99969);
  }
  
  private n(a parama)
  {
    GMTrace.i(13413451300864L, 99938);
    this.hsJ = null;
    this.hsM = new HashMap();
    this.foreground = false;
    this.hsN = null;
    this.lock = new Object();
    this.hsP = 21600000L;
    this.hsQ = false;
    this.hsR = new ai(Looper.getMainLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        boolean bool2 = false;
        GMTrace.i(13407277285376L, 99892);
        if (n.this.hsO == null)
        {
          GMTrace.o(13407277285376L, 99892);
          return false;
        }
        v.v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", new Object[] { Integer.valueOf(n.this.hsK.size()), Integer.valueOf(n.this.hsL.size()), Boolean.valueOf(n.this.foreground) });
        n.a locala = n.this.hsO;
        n localn = n.this;
        boolean bool1 = bool2;
        if (n.this.hsQ)
        {
          bool1 = bool2;
          if (n.this.hsK.isEmpty())
          {
            bool1 = bool2;
            if (n.this.hsL.isEmpty()) {
              bool1 = true;
            }
          }
        }
        locala.a(localn, bool1);
        GMTrace.o(13407277285376L, 99892);
        return true;
      }
    }, true);
    this.hsK = new Vector();
    this.hsL = new Vector();
    this.handler = new ad(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(13411572252672L, 99924);
        n.this.a((k)paramAnonymousMessage.obj, 0);
        GMTrace.o(13411572252672L, 99924);
      }
    };
    this.hsO = parama;
    GMTrace.o(13413451300864L, 99938);
  }
  
  private boolean BW()
  {
    GMTrace.i(13415733002240L, 99955);
    if (this.hsK.size() >= 50)
    {
      GMTrace.o(13415733002240L, 99955);
      return false;
    }
    GMTrace.o(13415733002240L, 99955);
    return true;
  }
  
  public static n a(a parama)
  {
    GMTrace.i(13413719736320L, 99940);
    if (hsH == null) {
      hsH = new n(parama);
    }
    parama = hsH;
    GMTrace.o(13413719736320L, 99940);
    return parama;
  }
  
  private void b(final k paramk, int paramInt)
  {
    GMTrace.i(13415196131328L, 99951);
    boolean bool = BW();
    int j = this.hsK.size();
    int k = paramk.getType();
    int m = paramk.hashCode();
    int n = paramk.BM();
    int i1 = this.hsL.size();
    int i;
    if (this.hsI == null)
    {
      i = 0;
      v.i("MicroMsg.NetSceneQueue", "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((paramInt != 0) || (!bool) || (this.hsI == null)) {
        break label324;
      }
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        this.hsK.add(paramk);
        if (j == this.hsK.size()) {
          v.w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", new Object[] { Integer.valueOf(paramk.getType()), Integer.valueOf(paramk.hashCode()), Integer.valueOf(j), Integer.valueOf(this.hsK.size()), Integer.valueOf(this.hsL.size()) });
        }
        this.hsJ.D(new Runnable()
        {
          public final void run()
          {
            int k = 0;
            GMTrace.i(13400163745792L, 99839);
            paramk.hsr = n.this;
            int j;
            if ((!paramk.hsp) && (n.this.hsI != null))
            {
              j = paramk.a(n.this.hsI, n.this);
              if (j >= 0) {}
            }
            for (int i = j;; i = 0)
            {
              int m = paramk.getType();
              int n = paramk.hashCode();
              int i1 = paramk.BM();
              boolean bool = paramk.hsp;
              int i2 = n.this.hsK.size();
              int i3 = n.this.hsL.size();
              if (n.this.hsI == null) {
                j = k;
              }
              for (;;)
              {
                v.w("MicroMsg.NetSceneQueue", "doscene mmcgi Failed type:%d hash[%d,%d] cancel[%b] run:%d wait:%d ret:%d autoauth:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(j) });
                paramk.hsr = null;
                synchronized (n.this.lock)
                {
                  n.this.hsK.remove(paramk);
                  if (paramk.hsp) {
                    break;
                  }
                  n.this.handler.post(new Runnable()
                  {
                    public final void run()
                    {
                      GMTrace.i(13408082591744L, 99898);
                      n.this.a(3, -1, "doScene failed", n.5.this.fBl);
                      GMTrace.o(13408082591744L, 99898);
                    }
                  });
                  GMTrace.o(13400163745792L, 99839);
                  return;
                  j = n.this.hsI.hashCode();
                }
              }
              k = paramk.getType();
              m = paramk.hashCode();
              n = paramk.BM();
              i1 = n.this.hsK.size();
              i2 = n.this.hsL.size();
              if (n.this.hsI == null) {}
              for (i = 0;; i = n.this.hsI.hashCode())
              {
                v.i("MicroMsg.NetSceneQueue", "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(j), Integer.valueOf(i) });
                paramk.hss = false;
                GMTrace.o(13400163745792L, 99839);
                return;
              }
            }
          }
          
          public final String toString()
          {
            GMTrace.i(13400297963520L, 99840);
            String str = super.toString() + "|doSceneImp_" + paramk + "_type=" + paramk.getType();
            GMTrace.o(13400297963520L, 99840);
            return str;
          }
        });
        if (this.hsI != null) {
          break label580;
        }
        if (this.hsO != null) {
          break;
        }
        v.e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s", new Object[] { this.hsO });
        GMTrace.o(13415196131328L, 99951);
        return;
        i = this.hsI.hashCode();
      }
      label324:
      if (paramInt > 0)
      {
        ??? = Message.obtain();
        ((Message)???).obj = paramk;
        this.handler.sendMessageDelayed((Message)???, paramInt);
        v.i("MicroMsg.NetSceneQueue", "timed: type=" + paramk.getType() + " id=" + paramk.hashCode() + " cur_after_sec=" + paramInt);
      }
      else
      {
        v.i("MicroMsg.NetSceneQueue", "waited: type=" + paramk.getType() + " id=" + paramk.hashCode() + " cur_waiting_cnt=" + this.hsL.size());
        synchronized (this.lock)
        {
          this.hsL.add(paramk);
          v.i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.hsL.size());
        }
      }
    }
    this.hsO.a(this);
    paramk = new ai(Looper.getMainLooper(), new ai.a()
    {
      private long hsX;
      
      public final boolean oQ()
      {
        GMTrace.i(13424322936832L, 100019);
        if (n.this.hsI == null)
        {
          long l = this.hsX;
          this.hsX = (l - 1L);
          if (l > 0L)
          {
            GMTrace.o(13424322936832L, 100019);
            return true;
          }
        }
        n.this.BV();
        GMTrace.o(13424322936832L, 100019);
        return false;
      }
    }, true);
    long l = hsS * 100;
    paramk.v(l, l);
    if (hsS < 512) {
      hsS *= 2;
    }
    GMTrace.o(13415196131328L, 99951);
    return;
    label580:
    hsS = 1;
    GMTrace.o(13415196131328L, 99951);
  }
  
  private void c(final int paramInt1, final int paramInt2, final String paramString, final k paramk)
  {
    GMTrace.i(13415464566784L, 99953);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(13407814156288L, 99896);
        Set localSet = (Set)n.this.hsM.get(Integer.valueOf(paramk.getType()));
        Object localObject;
        e locale;
        if ((localSet != null) && (localSet.size() > 0))
        {
          localObject = new HashSet();
          ((Set)localObject).addAll(localSet);
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            locale = (e)((Iterator)localObject).next();
            if ((locale != null) && (localSet.contains(locale))) {
              locale.a(paramInt1, paramInt2, paramString, paramk);
            }
          }
        }
        localSet = (Set)n.this.hsM.get(Integer.valueOf(-1));
        if ((localSet != null) && (localSet.size() > 0))
        {
          localObject = new HashSet();
          ((Set)localObject).addAll(localSet);
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            locale = (e)((Iterator)localObject).next();
            if ((locale != null) && (localSet.contains(locale))) {
              locale.a(paramInt1, paramInt2, paramString, paramk);
            }
          }
        }
        GMTrace.o(13407814156288L, 99896);
      }
    });
    GMTrace.o(13415464566784L, 99953);
  }
  
  private boolean e(k paramk)
  {
    GMTrace.i(13415867219968L, 99956);
    int i = paramk.getType();
    if (paramk.BI()) {}
    synchronized (this.lock)
    {
      Iterator localIterator = this.hsK.iterator();
      k localk;
      while (localIterator.hasNext())
      {
        localk = (k)localIterator.next();
        if (localk.getType() == i)
        {
          v.i("MicroMsg.NetSceneQueue", "forbid in running: type=" + paramk.getType() + " id=" + paramk.hashCode() + " cur_running_cnt=" + this.hsK.size());
          if (paramk.b(localk))
          {
            GMTrace.o(13415867219968L, 99956);
            return true;
          }
          if (paramk.a(localk))
          {
            v.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + paramk.getType() + " id=" + paramk.hashCode() + " cur_running_cnt=" + this.hsK.size() + " ---" + localk.hashCode());
            if (!this.foreground)
            {
              v.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + paramk.getType() + "acinfo[" + localk.getInfo() + "] scinfo[" + paramk.getInfo() + "]");
              v.bIF();
              Assert.assertTrue("NetsceneQueue forbid in running diagnostic: type=" + paramk.getType(), false);
            }
            c(localk);
            GMTrace.o(13415867219968L, 99956);
            return true;
          }
          GMTrace.o(13415867219968L, 99956);
          return false;
        }
      }
      localIterator = this.hsL.iterator();
      while (localIterator.hasNext())
      {
        localk = (k)localIterator.next();
        if (localk.getType() == i)
        {
          v.i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + paramk.getType() + " id=" + paramk.hashCode() + " cur_waiting_cnt=" + this.hsL.size());
          if (paramk.b(localk))
          {
            GMTrace.o(13415867219968L, 99956);
            return true;
          }
          if (paramk.a(localk))
          {
            v.e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + paramk.getType() + " id=" + paramk.hashCode() + " cur_waiting_cnt=" + this.hsL.size() + " ---" + localk.hashCode());
            if (!this.foreground)
            {
              v.bIF();
              Assert.assertTrue("NetsceneQueue forbid in waiting diagnostic: type=" + paramk.getType(), false);
            }
            c(localk);
            GMTrace.o(13415867219968L, 99956);
            return true;
          }
          GMTrace.o(13415867219968L, 99956);
          return false;
        }
      }
      GMTrace.o(13415867219968L, 99956);
      return true;
    }
  }
  
  public final int BR()
  {
    GMTrace.i(13413048647680L, 99935);
    try
    {
      if ((this.hsI != null) && (this.hsI.Cd() != null))
      {
        int i = this.hsI.Cd().Mt();
        GMTrace.o(13413048647680L, 99935);
        return i;
      }
      v.e("MicroMsg.NetSceneQueue", "[arthurdan.getNetworkStatus] Notice!!! autoAuth and autoAuth.getNetworkEvent() is null!!!!");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.e("MicroMsg.NetSceneQueue", "exception:%s", new Object[] { bf.g(localException) });
      }
      GMTrace.o(13413048647680L, 99935);
    }
    if (al.isConnected(aa.getContext()))
    {
      GMTrace.o(13413048647680L, 99935);
      return 6;
    }
    return 0;
  }
  
  public final boolean BS()
  {
    GMTrace.i(13413182865408L, 99936);
    if (this.hsI != null)
    {
      boolean bool = this.hsI.BS();
      GMTrace.o(13413182865408L, 99936);
      return bool;
    }
    GMTrace.o(13413182865408L, 99936);
    return true;
  }
  
  public final void BT()
  {
    GMTrace.i(13414256607232L, 99944);
    Vector localVector = this.hsK;
    this.hsK = new Vector();
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      v.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + localk.getType());
      localk.cancel();
      c(3, -1, "doScene failed clearRunningQueue", localk);
    }
    localVector.clear();
    GMTrace.o(13414256607232L, 99944);
  }
  
  public final void BU()
  {
    GMTrace.i(13414390824960L, 99945);
    v.i("MicroMsg.NetSceneQueue", "resetDispatcher");
    if (this.hsI != null)
    {
      this.hsI.reset();
      this.hsI = null;
    }
    GMTrace.o(13414390824960L, 99945);
  }
  
  public final void BV()
  {
    GMTrace.i(13415598784512L, 99954);
    for (;;)
    {
      int j;
      synchronized (this.lock)
      {
        if (this.hsL.size() > 0)
        {
          k localk = (k)this.hsL.get(0);
          int i = localk.priority;
          j = 1;
          if (j < this.hsL.size())
          {
            if (((k)this.hsL.get(j)).priority > i)
            {
              this.hsL.get(j);
              if (BW())
              {
                localk = (k)this.hsL.get(j);
                i = localk.priority;
              }
            }
          }
          else
          {
            this.hsL.remove(localk);
            v.i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.hsL.size());
            b(localk, 0);
          }
        }
        else
        {
          GMTrace.o(13415598784512L, 99954);
          return;
        }
      }
      j += 1;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    int i = 0;
    GMTrace.i(13415330349056L, 99952);
    paramk.hss = true;
    for (;;)
    {
      synchronized (this.lock)
      {
        this.hsK.remove(paramk);
        int j = paramk.getType();
        int k = paramk.hashCode();
        int m = paramk.BM();
        int n = this.hsK.size();
        int i1 = this.hsL.size();
        if (this.hsI == null)
        {
          v.i("MicroMsg.NetSceneQueue", "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
          BV();
          c(paramInt1, paramInt2, paramString, paramk);
          if ((this.hsQ) && (this.hsK.isEmpty()) && (this.hsL.isEmpty()))
          {
            paramString = this.hsR;
            long l = this.hsP;
            paramString.v(l, l);
          }
          GMTrace.o(13415330349056L, 99952);
          return;
        }
      }
      i = this.hsI.hashCode();
    }
  }
  
  public final void a(int paramInt, e parame)
  {
    GMTrace.i(13413853954048L, 99941);
    synchronized (this.hsM)
    {
      if (!this.hsM.containsKey(Integer.valueOf(paramInt))) {
        this.hsM.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)this.hsM.get(Integer.valueOf(paramInt))).contains(parame)) {
        ((Set)this.hsM.get(Integer.valueOf(paramInt))).add(parame);
      }
      GMTrace.o(13413853954048L, 99941);
      return;
    }
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(13412780212224L, 99933);
    if (this.hsI == null)
    {
      v.e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
      GMTrace.o(13412780212224L, 99933);
      return;
    }
    this.hsI.a(paramInt1, paramString, paramInt2, paramBoolean);
    GMTrace.o(13412780212224L, 99933);
  }
  
  public final boolean a(k paramk, int paramInt)
  {
    GMTrace.i(13415061913600L, 99950);
    if ((paramk != null) || (paramInt >= 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      if (this.hsJ == null) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("worker thread has not been set", bool);
      if (e(paramk)) {
        break label68;
      }
      GMTrace.o(13415061913600L, 99950);
      return false;
      bool = false;
      break;
    }
    label68:
    b(paramk, paramInt);
    GMTrace.o(13415061913600L, 99950);
    return true;
  }
  
  public final void aW(boolean paramBoolean)
  {
    GMTrace.i(13412645994496L, 99932);
    this.hsQ = paramBoolean;
    if (!this.hsQ)
    {
      this.hsR.KI();
      GMTrace.o(13412645994496L, 99932);
      return;
    }
    v.e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
    ai localai = this.hsR;
    long l = this.hsP;
    localai.v(l, l);
    GMTrace.o(13412645994496L, 99932);
  }
  
  public final void aX(boolean paramBoolean)
  {
    GMTrace.i(13412914429952L, 99934);
    this.foreground = paramBoolean;
    this.hsN = Boolean.valueOf(paramBoolean);
    b.aX(paramBoolean);
    if (this.hsI == null)
    {
      v.e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
      GMTrace.o(13412914429952L, 99934);
      return;
    }
    this.hsI.aZ(paramBoolean);
    GMTrace.o(13412914429952L, 99934);
  }
  
  public final void b(int paramInt, e parame)
  {
    GMTrace.i(13413988171776L, 99942);
    try
    {
      synchronized (this.hsM)
      {
        if (this.hsM.get(Integer.valueOf(paramInt)) != null) {
          ((Set)this.hsM.get(Integer.valueOf(paramInt))).remove(parame);
        }
        GMTrace.o(13413988171776L, 99942);
        return;
      }
    }
    catch (Exception parame)
    {
      for (;;) {}
    }
  }
  
  public final void c(k paramk)
  {
    GMTrace.i(13414793478144L, 99948);
    if (paramk == null)
    {
      GMTrace.o(13414793478144L, 99948);
      return;
    }
    v.j("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", new Object[] { Integer.valueOf(paramk.hashCode()) });
    paramk.cancel();
    synchronized (this.lock)
    {
      this.hsL.remove(paramk);
      this.hsK.remove(paramk);
      GMTrace.o(13414793478144L, 99948);
      return;
    }
  }
  
  public final void cancel(final int paramInt)
  {
    GMTrace.i(13414659260416L, 99947);
    v.j("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.hsJ.D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(13424591372288L, 100021);
        n localn = n.this;
        int i = paramInt;
        synchronized (localn.lock)
        {
          Iterator localIterator = localn.hsK.iterator();
          k localk;
          while (localIterator.hasNext())
          {
            localk = (k)localIterator.next();
            if ((localk != null) && (localk.hashCode() == i))
            {
              localn.c(localk);
              GMTrace.o(13424591372288L, 100021);
              return;
            }
          }
          localIterator = localn.hsL.iterator();
          while (localIterator.hasNext())
          {
            localk = (k)localIterator.next();
            if ((localk != null) && (localk.hashCode() == i))
            {
              localn.c(localk);
              GMTrace.o(13424591372288L, 100021);
              return;
            }
          }
          GMTrace.o(13424591372288L, 100021);
          return;
        }
      }
      
      public final String toString()
      {
        GMTrace.i(13424725590016L, 100022);
        String str = super.toString() + "|cancelImp_" + paramInt;
        GMTrace.o(13424725590016L, 100022);
        return str;
      }
    });
    GMTrace.o(13414659260416L, 99947);
  }
  
  public final void d(com.tencent.mm.network.e parame)
  {
    GMTrace.i(13413585518592L, 99939);
    this.hsI = parame;
    parame.aZ(this.foreground);
    BV();
    GMTrace.o(13413585518592L, 99939);
  }
  
  public final boolean d(k paramk)
  {
    GMTrace.i(13414927695872L, 99949);
    boolean bool = a(paramk, 0);
    GMTrace.o(13414927695872L, 99949);
    return bool;
  }
  
  public final String getNetworkServerIp()
  {
    GMTrace.i(13413317083136L, 99937);
    if (this.hsI != null)
    {
      String str = this.hsI.getNetworkServerIp();
      GMTrace.o(13413317083136L, 99937);
      return str;
    }
    GMTrace.o(13413317083136L, 99937);
    return "unknown";
  }
  
  public final void reset()
  {
    GMTrace.i(13414122389504L, 99943);
    if (this.hsI != null) {
      this.hsI.reset();
    }
    BT();
    Vector localVector = this.hsL;
    this.hsL = new Vector();
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      v.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + localk.getType());
      localk.cancel();
      c(3, -1, "doScene failed clearWaitingQueue", localk);
    }
    localVector.clear();
    GMTrace.o(13414122389504L, 99943);
  }
  
  public final com.tencent.mm.network.e vh()
  {
    GMTrace.i(13414525042688L, 99946);
    com.tencent.mm.network.e locale = this.hsI;
    GMTrace.o(13414525042688L, 99946);
    return locale;
  }
  
  public static abstract interface a
  {
    public abstract void a(n paramn);
    
    public abstract void a(n paramn, boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/y/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */