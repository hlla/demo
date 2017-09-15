package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.api.c.d;
import com.google.android.gms.common.api.c.d.a;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.k.f;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.d;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class i
  extends k<f>
  implements d
{
  private final boolean aDl;
  private final ExecutorService aDm;
  private final h anu;
  private final com.google.android.gms.signin.e aqo;
  private Integer aqp;
  
  public i(Context paramContext, Looper paramLooper, boolean paramBoolean, h paramh, c.b paramb, c.c paramc, ExecutorService paramExecutorService)
  {
    super(paramContext, paramLooper, 44, paramh, paramb, paramc);
    this.aDl = paramBoolean;
    this.anu = paramh;
    this.aqo = paramh.aqo;
    this.aqp = paramh.aqp;
    this.aDm = paramExecutorService;
  }
  
  public final void a(p paramp, Set<Scope> paramSet, e parame)
  {
    w.h(parame, "Expecting a valid ISignInCallbacks");
    try
    {
      ((f)jY()).a(new AuthAccountRequest(paramp, paramSet), parame);
      return;
    }
    catch (RemoteException paramp)
    {
      try
      {
        parame.a(new ConnectionResult(8, null), new AuthAccountResult());
        return;
      }
      catch (RemoteException paramp)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.");
      }
    }
  }
  
  public final void a(p paramp, boolean paramBoolean)
  {
    try
    {
      ((f)jY()).a(paramp, this.aqp.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException paramp) {}
  }
  
  public final void a(t paramt)
  {
    w.h(paramt, "Expecting a valid IResolveAccountCallbacks");
    try
    {
      Object localObject = this.anu;
      if (((h)localObject).akV != null) {}
      for (localObject = ((h)localObject).akV;; localObject = new Account("<<default account>>", "com.google"))
      {
        ((f)jY()).a(new ResolveAccountRequest((Account)localObject, this.aqp.intValue()), paramt);
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      try
      {
        paramt.a(new ResolveAccountResponse());
        return;
      }
      catch (RemoteException paramt)
      {
        Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.");
      }
    }
  }
  
  public final void connect()
  {
    a(new k.f(this));
  }
  
  protected final Bundle jX()
  {
    Object localObject = this.aqo;
    Integer localInteger = this.anu.aqp;
    ExecutorService localExecutorService = this.aDm;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", ((com.google.android.gms.signin.e)localObject).aDC);
    localBundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", ((com.google.android.gms.signin.e)localObject).aDD);
    localBundle.putString("com.google.android.gms.signin.internal.serverClientId", ((com.google.android.gms.signin.e)localObject).alT);
    if (((com.google.android.gms.signin.e)localObject).aDE != null) {
      localBundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new a((com.google.android.gms.signin.e)localObject, localExecutorService).asBinder()));
    }
    if (localInteger != null) {
      localBundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", localInteger.intValue());
    }
    localObject = this.anu.amt;
    if (!this.mContext.getPackageName().equals(localObject)) {
      localBundle.putString("com.google.android.gms.signin.internal.realClientPackageName", this.anu.amt);
    }
    return localBundle;
  }
  
  public final boolean jk()
  {
    return this.aDl;
  }
  
  protected final String jm()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  protected final String jn()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  public final void lI()
  {
    try
    {
      ((f)jY()).cv(this.aqp.intValue());
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  private static final class a
    extends d.a
  {
    private final ExecutorService aDm;
    private final com.google.android.gms.signin.e aqo;
    
    public a(com.google.android.gms.signin.e parame, ExecutorService paramExecutorService)
    {
      this.aqo = parame;
      this.aDm = paramExecutorService;
    }
    
    public final void a(final String paramString1, final String paramString2, final f paramf)
    {
      this.aDm.submit(new Runnable()
      {
        public final void run()
        {
          try
          {
            boolean bool = i.a.a(i.a.this).jt();
            paramf.af(bool);
            return;
          }
          catch (RemoteException localRemoteException) {}
        }
      });
    }
    
    public final void a(final String paramString, final List<Scope> paramList, final f paramf)
    {
      this.aDm.submit(new Runnable()
      {
        public final void run()
        {
          try
          {
            Object localObject = i.a.a(i.a.this);
            Collections.unmodifiableSet(new HashSet(paramList));
            localObject = ((c.d)localObject).js();
            localObject = new CheckServerAuthResult(((c.d.a)localObject).amJ, ((c.d.a)localObject).amK);
            paramf.a((CheckServerAuthResult)localObject);
            return;
          }
          catch (RemoteException localRemoteException) {}
        }
      });
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/signin/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */