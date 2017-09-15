package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.l;
import android.util.SparseArray;
import android.view.View;
import com.google.android.gms.c.m;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.h.a;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.d;
import com.google.android.gms.signin.e;
import com.google.android.gms.signin.e.a;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract interface c
{
  public abstract ConnectionResult a(TimeUnit paramTimeUnit);
  
  public abstract <A extends a.b, R extends g, T extends k.a<R, A>> T a(T paramT);
  
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(String paramString, PrintWriter paramPrintWriter);
  
  public abstract <A extends a.b, T extends k.a<? extends g, A>> T b(T paramT);
  
  public abstract void b(b paramb);
  
  public abstract void b(c paramc);
  
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract Looper getLooper();
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public static final class a
  {
    private Account akV;
    public c.c amA;
    public Looper amB;
    public com.google.android.gms.common.b amC = com.google.android.gms.common.b.jg();
    public a.a<? extends d, e> amD = com.google.android.gms.signin.b.aDu;
    public final ArrayList<c.b> amE = new ArrayList();
    public final ArrayList<c.c> amF = new ArrayList();
    private e.a amG = new e.a();
    public final Set<Scope> amq = new HashSet();
    private int amr;
    private View ams;
    private String amt;
    private String amu;
    private final Map<a<?>, h.a> amv = new m();
    public final Map<a<?>, Object> amw = new m();
    public FragmentActivity amx;
    public int amy = -1;
    public int amz = -1;
    public final Context mContext;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
      this.amB = paramContext.getMainLooper();
      this.amt = paramContext.getPackageName();
      this.amu = paramContext.getClass().getName();
    }
    
    public final void a(u paramu, c paramc)
    {
      int i = this.amy;
      Object localObject = this.amA;
      w.h(paramc, "GoogleApiClient instance cannot be null");
      if (paramu.aoo.indexOfKey(i) < 0) {}
      for (boolean bool = true;; bool = false)
      {
        w.a(bool, "Already managing a GoogleApiClient with id " + i);
        localObject = new u.a(paramu, i, paramc, (c.c)localObject);
        paramu.aoo.put(i, localObject);
        if ((paramu.ny) && (!paramu.aok)) {
          paramc.connect();
        }
        return;
      }
    }
    
    public final h jr()
    {
      return new h(this.akV, this.amq, this.amv, this.amr, this.ams, this.amt, this.amu, this.amG.lJ());
    }
  }
  
  public static abstract interface b
  {
    public abstract void bR(int paramInt);
    
    public abstract void g(Bundle paramBundle);
  }
  
  public static abstract interface c
  {
    public abstract void a(ConnectionResult paramConnectionResult);
  }
  
  public static abstract interface d
  {
    public abstract a js();
    
    public abstract boolean jt();
    
    public static final class a
    {
      public boolean amJ;
      public Set<Scope> amK;
    }
  }
  
  public static abstract interface e
  {
    public abstract void b(ConnectionResult paramConnectionResult);
    
    public abstract void c(ConnectionResult paramConnectionResult);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/api/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */