package com.google.android.gms.ads.internal.n;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.util.client.DynamiteLoader;
import com.google.android.gms.ads.internal.util.client.DynamiteLoader.LoadingException;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.dynamic.e;

@com.google.android.gms.ads.internal.q.a.a
public final class a
{
  public static boolean b = false;
  public static final Object c = new Object();
  private static boolean d = false;
  public com.google.android.gms.ads.e.a a;
  
  private final void c(Context paramContext)
  {
    synchronized (c)
    {
      if (((Boolean)n.bg.a()).booleanValue())
      {
        boolean bool = d;
        if (bool) {}
      }
    }
    try
    {
      d = true;
      this.a = ((com.google.android.gms.ads.e.a)DynamiteLoader.a(paramContext, "com.google.android.gms.ads.omid.DynamiteOmid", b.a));
      return;
      paramContext = finally;
      throw paramContext;
    }
    catch (DynamiteLoader.LoadingException paramContext)
    {
      for (;;)
      {
        k.f("#007 Could not call remote method.", paramContext);
      }
    }
  }
  
  public final com.google.android.gms.ads.internal.j.a a(String paramString1, WebView paramWebView, String paramString2, String paramString3, String paramString4)
  {
    return a(paramString1, paramWebView, paramString2, paramString3, paramString4, "Google");
  }
  
  public final com.google.android.gms.ads.internal.j.a a(String paramString1, WebView paramWebView, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    synchronized (c)
    {
      if ((((Boolean)n.bg.a()).booleanValue()) && (b)) {}
      try
      {
        paramString1 = this.a.a(paramString1, e.a(paramWebView), paramString2, paramString3, paramString4, paramString5);
        return paramString1;
      }
      catch (NullPointerException paramString1)
      {
        k.f("#007 Could not call remote method.", paramString1);
        return null;
      }
      catch (RemoteException paramString1)
      {
        for (;;) {}
      }
      return null;
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama)
  {
    synchronized (c)
    {
      if ((((Boolean)n.bg.a()).booleanValue()) && (b)) {}
      try
      {
        this.a.b(parama);
        return;
      }
      catch (NullPointerException parama)
      {
        k.f("#007 Could not call remote method.", parama);
        return;
      }
      catch (RemoteException parama)
      {
        for (;;) {}
      }
      return;
    }
  }
  
  public final void a(com.google.android.gms.ads.internal.j.a parama, View paramView)
  {
    synchronized (c)
    {
      if ((((Boolean)n.bg.a()).booleanValue()) && (b)) {}
      try
      {
        this.a.a(parama, e.a(paramView));
        return;
      }
      catch (NullPointerException parama)
      {
        k.f("#007 Could not call remote method.", parama);
        return;
      }
      catch (RemoteException parama)
      {
        for (;;) {}
      }
      return;
    }
  }
  
  public final boolean a(Context paramContext)
  {
    synchronized (c)
    {
      boolean bool;
      if (((Boolean)n.bg.a()).booleanValue())
      {
        bool = b;
        if (bool) {}
      }
      try
      {
        c(paramContext);
        bool = this.a.a(e.a(paramContext));
        b = bool;
        return bool;
      }
      catch (NullPointerException paramContext)
      {
        k.f("#007 Could not call remote method.", paramContext);
        return false;
      }
      catch (RemoteException paramContext)
      {
        for (;;) {}
      }
      return true;
      return false;
    }
  }
  
  public final String b(Context paramContext)
  {
    if (((Boolean)n.bg.a()).booleanValue()) {}
    try
    {
      c(paramContext);
      paramContext = String.valueOf(this.a.a());
      if (paramContext.length() == 0) {
        return new String("a.");
      }
      paramContext = "a.".concat(paramContext);
      return paramContext;
    }
    catch (NullPointerException paramContext)
    {
      k.f("#007 Could not call remote method.", paramContext);
      return null;
    }
    catch (RemoteException paramContext)
    {
      for (;;) {}
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/n/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */