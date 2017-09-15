package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class j<R extends g>
  implements e<R>
{
  private final Object amS = new Object();
  protected final a<R> amT;
  private final CountDownLatch amU = new CountDownLatch(1);
  private final ArrayList<Object> amV = new ArrayList();
  private h<R> amW;
  private volatile R amX;
  private volatile boolean amY;
  private boolean amZ;
  private boolean ana;
  private q anb;
  
  protected j(Looper paramLooper)
  {
    this.amT = new a(paramLooper);
  }
  
  private void b(R paramR)
  {
    this.amX = paramR;
    this.anb = null;
    this.amU.countDown();
    paramR = this.amX;
    if (this.amW != null)
    {
      this.amT.removeMessages(2);
      if (!this.amZ)
      {
        paramR = this.amT;
        paramR.sendMessage(paramR.obtainMessage(1, new Pair(this.amW, jy())));
      }
    }
    paramR = this.amV.iterator();
    while (paramR.hasNext()) {
      paramR.next();
    }
    this.amV.clear();
  }
  
  private static void c(g paramg)
  {
    if ((paramg instanceof f)) {}
    try
    {
      ((f)paramg).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      new StringBuilder("Unable to release ").append(paramg);
    }
  }
  
  private boolean jw()
  {
    return this.amU.getCount() == 0L;
  }
  
  private R jy()
  {
    boolean bool = true;
    synchronized (this.amS)
    {
      if (!this.amY)
      {
        w.a(bool, "Result has already been consumed.");
        w.a(jw(), "Result is not ready.");
        g localg = this.amX;
        this.amX = null;
        this.amW = null;
        this.amY = true;
        jx();
        return localg;
      }
      bool = false;
    }
  }
  
  public final void a(Status paramStatus)
  {
    synchronized (this.amS)
    {
      if (!jw())
      {
        a(b(paramStatus));
        this.ana = true;
      }
      return;
    }
  }
  
  public final void a(R paramR)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.amS)
      {
        if ((this.ana) || (this.amZ))
        {
          c(paramR);
          return;
        }
        if (!jw())
        {
          bool1 = true;
          w.a(bool1, "Results have already been set");
          if (this.amY) {
            break label83;
          }
          bool1 = bool2;
          w.a(bool1, "Result has already been consumed");
          b(paramR);
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label83:
      bool1 = false;
    }
  }
  
  public abstract R b(Status paramStatus);
  
  public final R b(TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((2L <= 0L) || (Looper.myLooper() != Looper.getMainLooper())) {
      bool1 = true;
    }
    for (;;)
    {
      w.a(bool1, "await must not be called on the UI thread when time is greater than zero.");
      if (!this.amY)
      {
        bool1 = bool2;
        w.a(bool1, "Result has already been consumed.");
      }
      try
      {
        if (!this.amU.await(2L, paramTimeUnit)) {
          a(Status.amP);
        }
        w.a(jw(), "Result is not ready.");
        return jy();
        bool1 = false;
        continue;
        bool1 = false;
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;)
        {
          a(Status.amN);
        }
      }
    }
  }
  
  public final void cancel()
  {
    synchronized (this.amS)
    {
      if ((this.amZ) || (this.amY)) {
        return;
      }
      c(this.amX);
      this.amW = null;
      this.amZ = true;
      b(b(Status.amQ));
      return;
    }
  }
  
  public final R ju()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      w.a(bool1, "await must not be called on the UI thread");
      if (!this.amY)
      {
        bool1 = bool2;
        w.a(bool1, "Result has already been consumed");
      }
      try
      {
        this.amU.await();
        w.a(jw(), "Result is not ready.");
        return jy();
        bool1 = false;
        continue;
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          a(Status.amN);
        }
      }
    }
  }
  
  protected void jx() {}
  
  public static final class a<R extends g>
    extends Handler
  {
    public a()
    {
      this(Looper.getMainLooper());
    }
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
        return;
      case 1: 
        paramMessage = (Pair)paramMessage.obj;
        Object localObject = paramMessage.first;
        paramMessage = paramMessage.second;
        return;
      }
      ((j)paramMessage.obj).a(Status.amP);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/api/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */