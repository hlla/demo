package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
  implements Handler.Callback
{
  public final a aqM;
  public final ArrayList<c.b> aqN = new ArrayList();
  public final ArrayList<c.b> aqO = new ArrayList();
  public final ArrayList<c.c> aqP = new ArrayList();
  public volatile boolean aqQ = false;
  public final AtomicInteger aqR = new AtomicInteger(0);
  public boolean aqS = false;
  public final Object aqu = new Object();
  public final Handler mHandler;
  
  public l(Looper paramLooper, a parama)
  {
    this.aqM = parama;
    this.mHandler = new Handler(paramLooper, this);
  }
  
  public final void a(c.b paramb)
  {
    w.Z(paramb);
    synchronized (this.aqu)
    {
      if (this.aqN.contains(paramb))
      {
        new StringBuilder("registerConnectionCallbacks(): listener ").append(paramb).append(" is already registered");
        if (this.aqM.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramb));
        }
        return;
      }
      this.aqN.add(paramb);
    }
  }
  
  public final void a(c.c paramc)
  {
    w.Z(paramc);
    synchronized (this.aqu)
    {
      if (this.aqP.contains(paramc))
      {
        new StringBuilder("registerConnectionFailedListener(): listener ").append(paramc).append(" is already registered");
        return;
      }
      this.aqP.add(paramc);
    }
  }
  
  public final void bY(int paramInt)
  {
    boolean bool = false;
    if (Looper.myLooper() == this.mHandler.getLooper()) {
      bool = true;
    }
    w.a(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    this.mHandler.removeMessages(1);
    synchronized (this.aqu)
    {
      this.aqS = true;
      Object localObject2 = new ArrayList(this.aqN);
      int i = this.aqR.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        c.b localb = (c.b)((Iterator)localObject2).next();
        if ((this.aqQ) && (this.aqR.get() == i)) {
          if (this.aqN.contains(localb)) {
            localb.bR(paramInt);
          }
        }
      }
    }
    this.aqO.clear();
    this.aqS = false;
  }
  
  public final boolean handleMessage(Message arg1)
  {
    if (???.what == 1)
    {
      c.b localb = (c.b)???.obj;
      synchronized (this.aqu)
      {
        if ((this.aqQ) && (this.aqM.isConnected()) && (this.aqN.contains(localb))) {
          localb.g(null);
        }
        return true;
      }
    }
    Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
    return false;
  }
  
  public final void kc()
  {
    this.aqQ = false;
    this.aqR.incrementAndGet();
  }
  
  public static abstract interface a
  {
    public abstract boolean isConnected();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */