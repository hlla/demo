package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class n
  implements p
{
  private final o and;
  
  public n(o paramo)
  {
    this.and = paramo;
  }
  
  public final <A extends a.b, R extends g, T extends k.a<R, A>> T a(T paramT)
  {
    this.and.anN.add(paramT);
    return paramT;
  }
  
  public final void a(ConnectionResult paramConnectionResult, a<?> parama, int paramInt) {}
  
  public final <A extends a.b, T extends k.a<? extends g, A>> T b(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  public final void bR(int paramInt) {}
  
  public final void begin()
  {
    Iterator localIterator = this.and.anT.values().iterator();
    while (localIterator.hasNext()) {
      ((a.b)localIterator.next()).disconnect();
    }
    this.and.anV = Collections.emptySet();
  }
  
  public final void connect()
  {
    o localo = this.and;
    localo.anf.lock();
    try
    {
      localo.anW = new m(localo, localo.anu, localo.anv, localo.amC, localo.amD, localo.anf, localo.mContext);
      localo.anW.begin();
      localo.anL.signalAll();
      return;
    }
    finally
    {
      localo.anf.unlock();
    }
  }
  
  public final void disconnect()
  {
    Iterator localIterator = this.and.anN.iterator();
    while (localIterator.hasNext()) {
      ((o.e)localIterator.next()).cancel();
    }
    this.and.anN.clear();
    this.and.anU.clear();
    this.and.jI();
  }
  
  public final void g(Bundle paramBundle) {}
  
  public final String getName()
  {
    return "DISCONNECTED";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/api/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */