package com.google.android.gms.common.api;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.w;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class l
  implements p
{
  private final o and;
  
  public l(o paramo)
  {
    this.and = paramo;
  }
  
  private <A extends a.b> void a(o.e<A> parame)
  {
    this.and.b(parame);
    Object localObject = this.and;
    a.c localc = parame.ji();
    localObject = (a.b)((o)localObject).anT.get(localc);
    w.h(localObject, "Appropriate Api was not requested.");
    if ((!((a.b)localObject).isConnected()) && (this.and.anU.containsKey(parame.ji())))
    {
      parame.c(new Status(17));
      return;
    }
    parame.a((a.b)localObject);
  }
  
  public final <A extends a.b, R extends g, T extends k.a<R, A>> T a(T paramT)
  {
    return b(paramT);
  }
  
  public final void a(ConnectionResult paramConnectionResult, a<?> parama, int paramInt) {}
  
  public final <A extends a.b, T extends k.a<? extends g, A>> T b(T paramT)
  {
    try
    {
      a(paramT);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      this.and.a(new o.b(this)
      {
        public final void jz()
        {
          l.this.bR(1);
        }
      });
    }
    return paramT;
  }
  
  public final void bR(int paramInt)
  {
    if (paramInt == 1)
    {
      localObject = this.and;
      if (!((o)localObject).anO)
      {
        ((o)localObject).anO = true;
        if (((o)localObject).anS == null)
        {
          ((o)localObject).anS = new o.c((o)localObject);
          IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addDataScheme("package");
          ((o)localObject).mContext.getApplicationContext().registerReceiver(((o)localObject).anS, localIntentFilter);
        }
        ((o)localObject).anR.sendMessageDelayed(((o)localObject).anR.obtainMessage(1), ((o)localObject).anP);
        ((o)localObject).anR.sendMessageDelayed(((o)localObject).anR.obtainMessage(2), ((o)localObject).anQ);
      }
    }
    Object localObject = this.and.anZ.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((o.e)((Iterator)localObject).next()).a(new Status(8, "The connection to Google Play services was lost"));
    }
    this.and.f(null);
    this.and.anM.bY(paramInt);
    this.and.anM.kc();
    if (paramInt == 2) {
      this.and.connect();
    }
  }
  
  public final void begin()
  {
    while (!this.and.anN.isEmpty()) {
      try
      {
        a((o.e)this.and.anN.remove());
      }
      catch (DeadObjectException localDeadObjectException) {}
    }
  }
  
  public final void connect() {}
  
  public final void disconnect()
  {
    this.and.anU.clear();
    this.and.jI();
    this.and.f(null);
    this.and.anM.kc();
  }
  
  public final void g(Bundle paramBundle) {}
  
  public final String getName()
  {
    return "CONNECTED";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/api/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */