package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.api.c.e;
import com.google.android.gms.common.b;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class k<T extends IInterface>
  implements a.b, l.a
{
  public static final String[] aqF = { "service_esmobile", "service_googleme" };
  private final Account akV;
  private final Looper amB;
  private final b amC;
  public final Set<Scope> amK;
  private final h anu;
  private int aqA = 1;
  public final c.b aqB;
  public final c.c aqC;
  private final int aqD;
  protected AtomicInteger aqE = new AtomicInteger(0);
  private final m aqt;
  private final Object aqu = new Object();
  public s aqv;
  public c.e aqw;
  private T aqx;
  public final ArrayList<k<T>.c<?>> aqy = new ArrayList();
  private k<T>.e aqz;
  public final Context mContext;
  final Handler mHandler;
  
  public k(Context paramContext, Looper paramLooper, int paramInt, h paramh, c.b paramb, c.c paramc)
  {
    this(paramContext, paramLooper, m.B(paramContext), b.jg(), paramInt, paramh, (c.b)w.Z(paramb), (c.c)w.Z(paramc));
  }
  
  private k(Context paramContext, Looper paramLooper, m paramm, b paramb, int paramInt, h paramh, c.b paramb1, c.c paramc)
  {
    this.mContext = ((Context)w.h(paramContext, "Context must not be null"));
    this.amB = ((Looper)w.h(paramLooper, "Looper must not be null"));
    this.aqt = ((m)w.h(paramm, "Supervisor must not be null"));
    this.amC = ((b)w.h(paramb, "API availability must not be null"));
    this.mHandler = new b(paramLooper);
    this.aqD = paramInt;
    this.anu = ((h)w.Z(paramh));
    this.akV = paramh.akV;
    this.amK = b(paramh.aqm);
    this.aqB = paramb1;
    this.aqC = paramc;
  }
  
  private static Set<Scope> b(Set<Scope> paramSet)
  {
    if (paramSet == null) {}
    Iterator localIterator;
    do
    {
      while (!localIterator.hasNext())
      {
        return paramSet;
        localIterator = paramSet.iterator();
      }
    } while (paramSet.contains((Scope)localIterator.next()));
    throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
  }
  
  protected static void jU() {}
  
  protected static void jV() {}
  
  private void jW()
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.aqE.get(), 1));
  }
  
  public void a(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramInt2, -1, new g(paramInt1, paramIBinder, paramBundle)));
  }
  
  public final void a(int paramInt, T paramT)
  {
    boolean bool = true;
    int i;
    int j;
    if (paramInt == 3)
    {
      i = 1;
      if (paramT == null) {
        break label313;
      }
      j = 1;
      label17:
      if (i != j) {
        break label319;
      }
    }
    for (;;)
    {
      w.ad(bool);
      for (;;)
      {
        synchronized (this.aqu)
        {
          this.aqA = paramInt;
          this.aqx = paramT;
          switch (paramInt)
          {
          case 3: 
            return;
          case 2: 
            if (this.aqz != null)
            {
              new StringBuilder("Calling connect() while still connected, missing disconnect() for ").append(jm()).append(" on ").append(jT());
              this.aqt.b(jm(), jT(), this.aqz, this.anu.amu);
              this.aqE.incrementAndGet();
            }
            this.aqz = new e(this.aqE.get());
            if (this.aqt.a(jm(), jT(), this.aqz, this.anu.amu)) {
              continue;
            }
            new StringBuilder("unable to connect to service: ").append(jm()).append(" on ").append(jT());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.aqE.get(), 9));
          }
        }
        if (this.aqz != null)
        {
          this.aqt.b(jm(), jT(), this.aqz, this.anu.amu);
          this.aqz = null;
        }
      }
      i = 0;
      break;
      label313:
      j = 0;
      break label17;
      label319:
      bool = false;
    }
  }
  
  public void a(c.e parame)
  {
    this.aqw = ((c.e)w.h(parame, "Connection progress callbacks cannot be null."));
    a(2, null);
  }
  
  public final void a(c.e parame, ConnectionResult paramConnectionResult)
  {
    this.aqw = ((c.e)w.h(parame, "Connection progress callbacks cannot be null."));
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.aqE.get(), paramConnectionResult.alZ, paramConnectionResult.ama));
  }
  
  public final void a(p paramp)
  {
    paramp = new ValidateAccountRequest(paramp, (Scope[])this.amK.toArray(new Scope[this.amK.size()]), this.mContext.getPackageName(), null);
    try
    {
      this.aqv.a(new d(this, this.aqE.get()), paramp);
      return;
    }
    catch (DeadObjectException paramp)
    {
      jW();
      return;
    }
    catch (RemoteException paramp) {}
  }
  
  public final void a(p paramp, Set<Scope> paramSet)
  {
    try
    {
      Bundle localBundle = jX();
      GetServiceRequest localGetServiceRequest = new GetServiceRequest(this.aqD);
      localGetServiceRequest.apC = this.mContext.getPackageName();
      localGetServiceRequest.apF = localBundle;
      if (paramSet != null) {
        localGetServiceRequest.apE = ((Scope[])paramSet.toArray(new Scope[paramSet.size()]));
      }
      if (jk()) {
        if (this.akV == null) {
          break label125;
        }
      }
      label125:
      for (paramSet = this.akV;; paramSet = new Account("<<default account>>", "com.google"))
      {
        localGetServiceRequest.apG = paramSet;
        if (paramp != null) {
          localGetServiceRequest.apD = paramp.asBinder();
        }
        this.aqv.a(new d(this, this.aqE.get()), localGetServiceRequest);
        return;
      }
      return;
    }
    catch (DeadObjectException paramp)
    {
      jW();
      return;
    }
    catch (RemoteException paramp) {}
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    IInterface localIInterface;
    for (;;)
    {
      synchronized (this.aqu)
      {
        int i = this.aqA;
        localIInterface = this.aqx;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i)
        {
        default: 
          paramPrintWriter.print("UNKNOWN");
          paramPrintWriter.append(" mService=");
          if (localIInterface != null) {
            break label142;
          }
          paramPrintWriter.println("null");
          return;
        }
      }
      paramPrintWriter.print("CONNECTING");
      continue;
      paramPrintWriter.print("CONNECTED");
      continue;
      paramPrintWriter.print("DISCONNECTING");
      continue;
      paramPrintWriter.print("DISCONNECTED");
    }
    label142:
    paramPrintWriter.append(jn()).append("@").println(Integer.toHexString(System.identityHashCode(localIInterface.asBinder())));
  }
  
  public final boolean a(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (this.aqu)
    {
      if (this.aqA != paramInt1) {
        return false;
      }
      a(paramInt2, paramT);
      return true;
    }
  }
  
  public void disconnect()
  {
    this.aqE.incrementAndGet();
    synchronized (this.aqy)
    {
      int j = this.aqy.size();
      int i = 0;
      while (i < j)
      {
        ((c)this.aqy.get(i)).kb();
        i += 1;
      }
      this.aqy.clear();
      a(1, null);
      return;
    }
  }
  
  public abstract T f(IBinder paramIBinder);
  
  public final boolean isConnected()
  {
    for (;;)
    {
      synchronized (this.aqu)
      {
        if (this.aqA == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final boolean isConnecting()
  {
    for (;;)
    {
      synchronized (this.aqu)
      {
        if (this.aqA == 2)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public String jT()
  {
    return "com.google.android.gms";
  }
  
  public Bundle jX()
  {
    return new Bundle();
  }
  
  public final T jY()
  {
    synchronized (this.aqu)
    {
      if (this.aqA == 4) {
        throw new DeadObjectException();
      }
    }
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
    if (this.aqx != null) {}
    for (boolean bool = true;; bool = false)
    {
      w.a(bool, "Client is connected but service is null");
      IInterface localIInterface = this.aqx;
      return localIInterface;
    }
  }
  
  public boolean jk()
  {
    return false;
  }
  
  public boolean jl()
  {
    return true;
  }
  
  public abstract String jm();
  
  public abstract String jn();
  
  private abstract class a
    extends k<T>.c<Boolean>
  {
    public final Bundle aqG;
    public final int statusCode;
    
    protected a(int paramInt, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      this.statusCode = paramInt;
      this.aqG = paramBundle;
    }
    
    protected abstract void h(ConnectionResult paramConnectionResult);
    
    protected abstract boolean jZ();
  }
  
  final class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    private static void a(Message paramMessage)
    {
      ((k.c)paramMessage.obj).unregister();
    }
    
    private static boolean b(Message paramMessage)
    {
      return (paramMessage.what == 2) || (paramMessage.what == 1) || (paramMessage.what == 5) || (paramMessage.what == 6);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      PendingIntent localPendingIntent = null;
      if (k.this.aqE.get() != paramMessage.arg1)
      {
        if (b(paramMessage)) {
          a(paramMessage);
        }
        return;
      }
      if (((paramMessage.what == 1) || (paramMessage.what == 5) || (paramMessage.what == 6)) && (!k.this.isConnecting()))
      {
        a(paramMessage);
        return;
      }
      if (paramMessage.what == 3)
      {
        if ((paramMessage.obj instanceof PendingIntent)) {
          localPendingIntent = (PendingIntent)paramMessage.obj;
        }
        paramMessage = new ConnectionResult(paramMessage.arg2, localPendingIntent);
        k.this.aqw.b(paramMessage);
        k.jV();
        return;
      }
      if (paramMessage.what == 4)
      {
        k.this.a(4, null);
        if (k.this.aqB != null) {
          k.this.aqB.bR(paramMessage.arg2);
        }
        int i = paramMessage.arg2;
        k.jU();
        k.this.a(4, 1, null);
        return;
      }
      if ((paramMessage.what == 2) && (!k.this.isConnected()))
      {
        a(paramMessage);
        return;
      }
      if (b(paramMessage))
      {
        ((k.c)paramMessage.obj).ka();
        return;
      }
      Log.wtf("GmsClient", "Don't know how to handle this message.");
    }
  }
  
  protected abstract class c<TListener>
  {
    private TListener aoj;
    private boolean aqI;
    
    public c()
    {
      Object localObject;
      this.aoj = localObject;
      this.aqI = false;
    }
    
    protected abstract void X(TListener paramTListener);
    
    /* Error */
    public final void ka()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 24	com/google/android/gms/common/internal/k$c:aoj	Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield 26	com/google/android/gms/common/internal/k$c:aqI	Z
      //   11: ifeq +22 -> 33
      //   14: new 36	java/lang/StringBuilder
      //   17: dup
      //   18: ldc 38
      //   20: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   23: aload_0
      //   24: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   27: ldc 47
      //   29: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   32: pop
      //   33: aload_0
      //   34: monitorexit
      //   35: aload_1
      //   36: ifnull +8 -> 44
      //   39: aload_0
      //   40: aload_1
      //   41: invokevirtual 52	com/google/android/gms/common/internal/k$c:X	(Ljava/lang/Object;)V
      //   44: aload_0
      //   45: monitorenter
      //   46: aload_0
      //   47: iconst_1
      //   48: putfield 26	com/google/android/gms/common/internal/k$c:aqI	Z
      //   51: aload_0
      //   52: monitorexit
      //   53: aload_0
      //   54: invokevirtual 55	com/google/android/gms/common/internal/k$c:unregister	()V
      //   57: return
      //   58: astore_1
      //   59: aload_0
      //   60: monitorexit
      //   61: aload_1
      //   62: athrow
      //   63: astore_1
      //   64: aload_1
      //   65: athrow
      //   66: astore_1
      //   67: aload_0
      //   68: monitorexit
      //   69: aload_1
      //   70: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	71	0	this	c
      //   6	35	1	localObject1	Object
      //   58	4	1	localObject2	Object
      //   63	2	1	localRuntimeException	RuntimeException
      //   66	4	1	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   2	33	58	finally
      //   33	35	58	finally
      //   59	61	58	finally
      //   39	44	63	java/lang/RuntimeException
      //   46	53	66	finally
      //   67	69	66	finally
    }
    
    public final void kb()
    {
      try
      {
        this.aoj = null;
        return;
      }
      finally {}
    }
    
    public final void unregister()
    {
      kb();
      synchronized (k.this.aqy)
      {
        k.this.aqy.remove(this);
        return;
      }
    }
  }
  
  public static final class d
    extends r.a
  {
    private k aqJ;
    private final int aqK;
    
    public d(k paramk, int paramInt)
    {
      this.aqJ = paramk;
      this.aqK = paramInt;
    }
    
    public final void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      w.h(this.aqJ, "onPostInitComplete can be called only once per call to getRemoteService");
      this.aqJ.a(paramInt, paramIBinder, paramBundle, this.aqK);
      this.aqJ = null;
    }
    
    public final void b(int paramInt, Bundle paramBundle)
    {
      w.h(this.aqJ, "onAccountValidationComplete can be called only once per call to validateAccount");
      k localk = this.aqJ;
      int i = this.aqK;
      localk.mHandler.sendMessage(localk.mHandler.obtainMessage(5, i, -1, new k.i(localk, paramInt, paramBundle)));
      this.aqJ = null;
    }
  }
  
  public final class e
    implements ServiceConnection
  {
    private final int aqK;
    
    public e(int paramInt)
    {
      this.aqK = paramInt;
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      w.h(paramIBinder, "Expecting a valid IBinder");
      k.this.aqv = s.a.i(paramIBinder);
      paramComponentName = k.this;
      int i = this.aqK;
      paramComponentName.mHandler.sendMessage(paramComponentName.mHandler.obtainMessage(6, i, -1, new k.h(paramComponentName)));
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      k.this.mHandler.sendMessage(k.this.mHandler.obtainMessage(4, this.aqK, 1));
    }
  }
  
  protected final class f
    implements c.e
  {
    public f() {}
    
    public final void b(ConnectionResult paramConnectionResult)
    {
      if (paramConnectionResult.isSuccess()) {
        k.this.a(null, k.this.amK);
      }
      while (k.this.aqC == null) {
        return;
      }
      k.this.aqC.a(paramConnectionResult);
    }
    
    public final void c(ConnectionResult paramConnectionResult)
    {
      throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
    }
  }
  
  protected final class g
    extends k<T>.a
  {
    public final IBinder aqL;
    
    public g(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
      this.aqL = paramIBinder;
    }
    
    protected final void h(ConnectionResult paramConnectionResult)
    {
      if (k.this.aqC != null) {
        k.this.aqC.a(paramConnectionResult);
      }
      k.jV();
    }
    
    protected final boolean jZ()
    {
      try
      {
        Object localObject = this.aqL.getInterfaceDescriptor();
        if (!k.this.jn().equals(localObject)) {
          new StringBuilder("service descriptor mismatch: ").append(k.this.jn()).append(" vs. ").append((String)localObject);
        }
        do
        {
          return false;
          localObject = k.this.f(this.aqL);
        } while ((localObject == null) || (!k.this.a(2, 3, (IInterface)localObject)));
        if (k.this.aqB != null) {
          k.this.aqB.g(null);
        }
        return true;
      }
      catch (RemoteException localRemoteException) {}
      return false;
    }
  }
  
  protected final class h
    extends k<T>.a
  {
    public h()
    {
      super(0, null);
    }
    
    protected final void h(ConnectionResult paramConnectionResult)
    {
      k.this.aqw.b(paramConnectionResult);
      k.jV();
    }
    
    protected final boolean jZ()
    {
      k.this.aqw.b(ConnectionResult.alY);
      return true;
    }
  }
  
  protected final class i
    extends k<T>.a
  {
    public i(int paramInt, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
    }
    
    protected final void h(ConnectionResult paramConnectionResult)
    {
      k.this.aqw.c(paramConnectionResult);
      k.jV();
    }
    
    protected final boolean jZ()
    {
      k.this.aqw.c(ConnectionResult.alY);
      return true;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/internal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */