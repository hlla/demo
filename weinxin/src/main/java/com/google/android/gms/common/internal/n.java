package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class n
  extends m
  implements Handler.Callback
{
  public final Context aiF;
  public final HashMap<a, b> aqV = new HashMap();
  public final b aqW;
  private final long aqX;
  private final Handler mHandler;
  
  n(Context paramContext)
  {
    this.aiF = paramContext.getApplicationContext();
    this.mHandler = new Handler(paramContext.getMainLooper(), this);
    this.aqW = b.kw();
    this.aqX = 5000L;
  }
  
  private void a(a parama, ServiceConnection paramServiceConnection)
  {
    w.h(paramServiceConnection, "ServiceConnection must not be null");
    b localb;
    synchronized (this.aqV)
    {
      localb = (b)this.aqV.get(parama);
      if (localb == null) {
        throw new IllegalStateException("Nonexistent connection status for service config: " + parama);
      }
    }
    if (!localb.a(paramServiceConnection)) {
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + parama);
    }
    localb.arf.aqW.a(localb.arf.aiF, paramServiceConnection, null, null, 4);
    localb.arc.remove(paramServiceConnection);
    if (localb.ke())
    {
      parama = this.mHandler.obtainMessage(0, localb);
      this.mHandler.sendMessageDelayed(parama, this.aqX);
    }
  }
  
  private boolean a(a parama, ServiceConnection paramServiceConnection, String paramString)
  {
    w.h(paramServiceConnection, "ServiceConnection must not be null");
    for (;;)
    {
      b localb;
      synchronized (this.aqV)
      {
        localb = (b)this.aqV.get(parama);
        if (localb == null)
        {
          localb = new b(parama);
          localb.a(paramServiceConnection, paramString);
          localb.R(paramString);
          this.aqV.put(parama, localb);
          parama = localb;
          boolean bool = parama.ard;
          return bool;
        }
        this.mHandler.removeMessages(0, localb);
        if (localb.a(paramServiceConnection)) {
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + parama);
        }
      }
      localb.a(paramServiceConnection, paramString);
      switch (localb.mState)
      {
      case 1: 
        paramServiceConnection.onServiceConnected(localb.ara, localb.apv);
        parama = localb;
        break;
      case 2: 
        localb.R(paramString);
        parama = localb;
        break;
      default: 
        parama = localb;
      }
    }
  }
  
  public final boolean a(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    return a(new a(paramComponentName), paramServiceConnection, paramString);
  }
  
  public final boolean a(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    return a(new a(paramString1, paramString2), paramServiceConnection, paramString3);
  }
  
  public final void b(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    a(new a(paramComponentName), paramServiceConnection);
  }
  
  public final void b(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    a(new a(paramString1, paramString2), paramServiceConnection);
  }
  
  public final boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return false;
    }
    b localb = (b)???.obj;
    synchronized (this.aqV)
    {
      if (localb.ke())
      {
        if (localb.ard)
        {
          localb.arf.aqW.a(localb.arf.aiF, localb.arb);
          localb.ard = false;
          localb.mState = 2;
        }
        this.aqV.remove(localb.are);
      }
      return true;
    }
  }
  
  private static final class a
  {
    private final String aqY;
    private final String aqZ;
    private final ComponentName ara;
    
    public a(ComponentName paramComponentName)
    {
      this.aqY = null;
      this.aqZ = null;
      this.ara = ((ComponentName)w.Z(paramComponentName));
    }
    
    public a(String paramString1, String paramString2)
    {
      this.aqY = w.U(paramString1);
      this.aqZ = w.U(paramString2);
      this.ara = null;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
      } while ((v.d(this.aqY, ((a)paramObject).aqY)) && (v.d(this.ara, ((a)paramObject).ara)));
      return false;
    }
    
    public final int hashCode()
    {
      return Arrays.hashCode(new Object[] { this.aqY, this.ara });
    }
    
    public final Intent kd()
    {
      if (this.aqY != null) {
        return new Intent(this.aqY).setPackage(this.aqZ);
      }
      return new Intent().setComponent(this.ara);
    }
    
    public final String toString()
    {
      if (this.aqY == null) {
        return this.ara.flattenToString();
      }
      return this.aqY;
    }
  }
  
  private final class b
  {
    public IBinder apv;
    public ComponentName ara;
    final a arb;
    public final Set<ServiceConnection> arc;
    boolean ard;
    public final n.a are;
    public int mState;
    
    public b(n.a parama)
    {
      this.are = parama;
      this.arb = new a();
      this.arc = new HashSet();
      this.mState = 2;
    }
    
    public final void R(String paramString)
    {
      this.ard = n.this.aqW.a(n.this.aiF, paramString, this.are.kd(), this.arb, 129);
      if (this.ard)
      {
        this.mState = 3;
        return;
      }
      try
      {
        n.this.aqW.a(n.this.aiF, this.arb);
        return;
      }
      catch (IllegalArgumentException paramString) {}
    }
    
    public final void a(ServiceConnection paramServiceConnection, String paramString)
    {
      n.this.aqW.a(n.this.aiF, paramServiceConnection, paramString, this.are.kd(), 3);
      this.arc.add(paramServiceConnection);
    }
    
    public final boolean a(ServiceConnection paramServiceConnection)
    {
      return this.arc.contains(paramServiceConnection);
    }
    
    public final boolean ke()
    {
      return this.arc.isEmpty();
    }
    
    public final class a
      implements ServiceConnection
    {
      public a() {}
      
      public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        synchronized (n.this.aqV)
        {
          n.b.this.apv = paramIBinder;
          n.b.this.ara = paramComponentName;
          Iterator localIterator = n.b.this.arc.iterator();
          if (localIterator.hasNext()) {
            ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
          }
        }
        n.b.this.mState = 1;
      }
      
      public final void onServiceDisconnected(ComponentName paramComponentName)
      {
        synchronized (n.this.aqV)
        {
          n.b.this.apv = null;
          n.b.this.ara = paramComponentName;
          Iterator localIterator = n.b.this.arc.iterator();
          if (localIterator.hasNext()) {
            ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
          }
        }
        n.b.this.mState = 2;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/internal/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */