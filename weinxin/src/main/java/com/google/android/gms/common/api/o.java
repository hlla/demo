package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.h.a;
import com.google.android.gms.common.internal.l.a;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.d;
import com.google.android.gms.signin.e;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class o
  implements c
{
  final Looper amB;
  final b amC;
  final a.a<? extends d, e> amD;
  public final int amy;
  private final int amz;
  final Condition anL;
  final com.google.android.gms.common.internal.l anM;
  final Queue<e<?>> anN = new LinkedList();
  volatile boolean anO;
  long anP = 120000L;
  long anQ = 5000L;
  final a anR;
  BroadcastReceiver anS;
  final Map<a.c<?>, a.b> anT = new HashMap();
  final Map<a.c<?>, ConnectionResult> anU = new HashMap();
  Set<Scope> anV = new HashSet();
  public volatile p anW;
  private ConnectionResult anX = null;
  private final Set<r<?>> anY = Collections.newSetFromMap(new WeakHashMap());
  final Set<e<?>> anZ = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75F, 2));
  public final Lock anf = new ReentrantLock();
  final h anu;
  final Map<a<?>, Integer> anv;
  private final d aoa = new d()
  {
    public final void c(o.e<?> paramAnonymouse)
    {
      o.this.anZ.remove(paramAnonymouse);
    }
  };
  private final c.b aob = new c.b()
  {
    public final void bR(int paramAnonymousInt)
    {
      o.this.anf.lock();
      try
      {
        o.this.anW.bR(paramAnonymousInt);
        return;
      }
      finally
      {
        o.this.anf.unlock();
      }
    }
    
    public final void g(Bundle paramAnonymousBundle)
    {
      o.this.anf.lock();
      try
      {
        o.this.anW.g(paramAnonymousBundle);
        return;
      }
      finally
      {
        o.this.anf.unlock();
      }
    }
  };
  private final l.a aoc = new l.a()
  {
    public final boolean isConnected()
    {
      return o.this.anW instanceof l;
    }
  };
  final Context mContext;
  
  public o(Context paramContext, Looper paramLooper, h paramh, b paramb, a.a<? extends d, e> parama, Map<a<?>, Object> paramMap, ArrayList<c.b> paramArrayList, ArrayList<c.c> paramArrayList1, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.anM = new com.google.android.gms.common.internal.l(paramLooper, this.aoc);
    this.amB = paramLooper;
    this.anR = new a(paramLooper);
    this.amC = paramb;
    this.amy = paramInt1;
    this.amz = paramInt2;
    this.anv = new HashMap();
    this.anL = this.anf.newCondition();
    this.anW = new n(this);
    paramb = paramArrayList.iterator();
    while (paramb.hasNext())
    {
      paramArrayList = (c.b)paramb.next();
      this.anM.a(paramArrayList);
    }
    paramb = paramArrayList1.iterator();
    while (paramb.hasNext())
    {
      paramArrayList = (c.c)paramb.next();
      this.anM.a(paramArrayList);
    }
    paramArrayList = paramh.aqn;
    paramArrayList1 = paramMap.keySet().iterator();
    a locala;
    if (paramArrayList1.hasNext())
    {
      locala = (a)paramArrayList1.next();
      paramb = paramMap.get(locala);
      if (paramArrayList.get(locala) == null) {
        break label593;
      }
      if (((h.a)paramArrayList.get(locala)).aqq) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      label408:
      this.anv.put(locala, Integer.valueOf(paramInt1));
      label436:
      boolean bool;
      label452:
      c.b localb;
      c.c localc;
      if (locala.amp != null)
      {
        paramInt2 = 1;
        if (paramInt2 == 0) {
          break label551;
        }
        if (locala.amn == null) {
          break label545;
        }
        bool = true;
        w.a(bool, "This API was constructed with a ClientBuilder. Use getClientBuilder");
        paramb = locala.amn;
        localb = this.aob;
        localc = a(locala, paramInt1);
      }
      label545:
      label551:
      for (paramb = new com.google.android.gms.common.internal.c(paramContext, paramLooper, paramb.jq(), localb, localc, paramh, paramb.jp());; paramb = locala.jh().a(paramContext, paramLooper, paramh, paramb, this.aob, a(locala, paramInt1)))
      {
        this.anT.put(locala.ji(), paramb);
        break;
        paramInt1 = 2;
        break label408;
        paramInt2 = 0;
        break label436;
        bool = false;
        break label452;
      }
      this.anu = paramh;
      this.amD = parama;
      return;
      label593:
      paramInt1 = 0;
    }
  }
  
  private final c.c a(final a<?> parama, final int paramInt)
  {
    new c.c()
    {
      public final void a(ConnectionResult paramAnonymousConnectionResult)
      {
        o.this.anf.lock();
        try
        {
          o.this.anW.a(paramAnonymousConnectionResult, parama, paramInt);
          return;
        }
        finally
        {
          o.this.anf.unlock();
        }
      }
    };
  }
  
  public final ConnectionResult a(TimeUnit paramTimeUnit)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    }
    for (;;)
    {
      w.a(bool, "blockingConnect must not be called on the UI thread");
      this.anf.lock();
      try
      {
        connect();
        long l1 = paramTimeUnit.toNanos(30L);
        for (;;)
        {
          bool = this.anW instanceof m;
          if (!bool) {
            break;
          }
          try
          {
            long l2 = this.anL.awaitNanos(l1);
            l1 = l2;
            if (l2 <= 0L)
            {
              paramTimeUnit = new ConnectionResult(14, null);
              return paramTimeUnit;
            }
          }
          catch (InterruptedException paramTimeUnit)
          {
            Thread.currentThread().interrupt();
            paramTimeUnit = new ConnectionResult(15, null);
            return paramTimeUnit;
          }
        }
        bool = false;
        continue;
        if ((this.anW instanceof l))
        {
          paramTimeUnit = ConnectionResult.alY;
          return paramTimeUnit;
        }
        if (this.anX != null)
        {
          paramTimeUnit = this.anX;
          return paramTimeUnit;
        }
        paramTimeUnit = new ConnectionResult(13, null);
        return paramTimeUnit;
      }
      finally
      {
        this.anf.unlock();
      }
    }
  }
  
  public final <A extends a.b, R extends g, T extends k.a<R, A>> T a(T paramT)
  {
    if (paramT.amo != null) {}
    for (boolean bool = true;; bool = false)
    {
      w.b(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
      w.b(this.anT.containsKey(paramT.amo), "GoogleApiClient is not configured to use the API required for this call.");
      this.anf.lock();
      try
      {
        paramT = this.anW.a(paramT);
        return paramT;
      }
      finally
      {
        this.anf.unlock();
      }
    }
  }
  
  public final void a(c.b paramb)
  {
    this.anM.a(paramb);
  }
  
  public final void a(c.c paramc)
  {
    this.anM.a(paramc);
  }
  
  final void a(b paramb)
  {
    paramb = this.anR.obtainMessage(3, paramb);
    this.anR.sendMessage(paramb);
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    paramPrintWriter.append(paramString).append("mState=").append(this.anW.getName());
    paramPrintWriter.append(" mResuming=").print(this.anO);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.anN.size());
    paramPrintWriter.append(" mUnconsumedRunners.size()=").println(this.anZ.size());
    String str = paramString + "  ";
    Iterator localIterator = this.anv.keySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      paramPrintWriter.append(paramString).append(locala.mName).println(":");
      ((a.b)this.anT.get(locala.ji())).a(str, paramPrintWriter);
    }
  }
  
  public final <A extends a.b, T extends k.a<? extends g, A>> T b(T paramT)
  {
    boolean bool;
    if (paramT.amo != null) {
      bool = true;
    }
    for (;;)
    {
      w.b(bool, "This task can not be executed (it's probably a Batch or malformed)");
      this.anf.lock();
      try
      {
        if (!this.anO) {
          break label113;
        }
        this.anN.add(paramT);
        while (!this.anN.isEmpty())
        {
          e locale = (e)this.anN.remove();
          b(locale);
          locale.c(Status.amO);
        }
        bool = false;
      }
      finally
      {
        this.anf.unlock();
      }
    }
    this.anf.unlock();
    return paramT;
    label113:
    paramT = this.anW.b(paramT);
    this.anf.unlock();
    return paramT;
  }
  
  public final void b(c.b paramb)
  {
    com.google.android.gms.common.internal.l locall = this.anM;
    w.Z(paramb);
    synchronized (locall.aqu)
    {
      if (!locall.aqN.remove(paramb)) {
        new StringBuilder("unregisterConnectionCallbacks(): listener ").append(paramb).append(" not found");
      }
      while (!locall.aqS) {
        return;
      }
      locall.aqO.add(paramb);
    }
  }
  
  public final void b(c.c paramc)
  {
    com.google.android.gms.common.internal.l locall = this.anM;
    w.Z(paramc);
    synchronized (locall.aqu)
    {
      if (!locall.aqP.remove(paramc)) {
        new StringBuilder("unregisterConnectionFailedListener(): listener ").append(paramc).append(" not found");
      }
      return;
    }
  }
  
  final <A extends a.b> void b(e<A> parame)
  {
    this.anZ.add(parame);
    parame.a(this.aoa);
  }
  
  public final void connect()
  {
    this.anf.lock();
    try
    {
      this.anW.connect();
      return;
    }
    finally
    {
      this.anf.unlock();
    }
  }
  
  public final void disconnect()
  {
    this.anf.lock();
    try
    {
      jJ();
      this.anW.disconnect();
      return;
    }
    finally
    {
      this.anf.unlock();
    }
  }
  
  final void f(ConnectionResult paramConnectionResult)
  {
    this.anf.lock();
    try
    {
      this.anX = paramConnectionResult;
      this.anW = new n(this);
      this.anW.begin();
      this.anL.signalAll();
      return;
    }
    finally
    {
      this.anf.unlock();
    }
  }
  
  public final Looper getLooper()
  {
    return this.amB;
  }
  
  public final boolean isConnected()
  {
    return this.anW instanceof l;
  }
  
  public final boolean isConnecting()
  {
    return this.anW instanceof m;
  }
  
  final void jI()
  {
    Iterator localIterator = this.anZ.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      locale.a(null);
      locale.cancel();
    }
    this.anZ.clear();
    localIterator = this.anY.iterator();
    while (localIterator.hasNext()) {
      ((r)localIterator.next()).aoj = null;
    }
    this.anY.clear();
  }
  
  final boolean jJ()
  {
    if (!this.anO) {
      return false;
    }
    this.anO = false;
    this.anR.removeMessages(2);
    this.anR.removeMessages(1);
    if (this.anS != null)
    {
      this.mContext.getApplicationContext().unregisterReceiver(this.anS);
      this.anS = null;
    }
    return true;
  }
  
  public final void resume()
  {
    this.anf.lock();
    try
    {
      if (this.anO) {
        connect();
      }
      return;
    }
    finally
    {
      this.anf.unlock();
    }
  }
  
  final class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        new StringBuilder("Unknown message id: ").append(paramMessage.what);
        return;
      case 1: 
        paramMessage = o.this;
        paramMessage.anf.lock();
        try
        {
          if (paramMessage.jJ()) {
            paramMessage.connect();
          }
          return;
        }
        finally
        {
          paramMessage.anf.unlock();
        }
      case 2: 
        o.this.resume();
        return;
      case 3: 
        ((o.b)paramMessage.obj).a(o.this);
        return;
      }
      throw ((RuntimeException)paramMessage.obj);
    }
  }
  
  static abstract class b
  {
    private final p aog;
    
    protected b(p paramp)
    {
      this.aog = paramp;
    }
    
    public final void a(o paramo)
    {
      paramo.anf.lock();
      try
      {
        p localp1 = paramo.anW;
        p localp2 = this.aog;
        if (localp1 != localp2) {
          return;
        }
        jz();
        return;
      }
      finally
      {
        paramo.anf.unlock();
      }
    }
    
    protected abstract void jz();
  }
  
  private static final class c
    extends BroadcastReceiver
  {
    private WeakReference<o> aoh;
    
    c(o paramo)
    {
      this.aoh = new WeakReference(paramo);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      paramIntent = paramIntent.getData();
      paramContext = null;
      if (paramIntent != null) {
        paramContext = paramIntent.getSchemeSpecificPart();
      }
      if ((paramContext == null) || (!paramContext.equals("com.google.android.gms"))) {}
      do
      {
        return;
        paramContext = (o)this.aoh.get();
      } while (paramContext == null);
      paramContext.resume();
    }
  }
  
  static abstract interface d
  {
    public abstract void c(o.e<?> parame);
  }
  
  static abstract interface e<A extends a.b>
  {
    public abstract void a(Status paramStatus);
    
    public abstract void a(A paramA);
    
    public abstract void a(o.d paramd);
    
    public abstract void c(Status paramStatus);
    
    public abstract void cancel();
    
    public abstract a.c<A> ji();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/api/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */