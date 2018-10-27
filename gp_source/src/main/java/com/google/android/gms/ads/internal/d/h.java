package com.google.android.gms.ads.internal.d;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.util.client.DynamiteLoader;
import com.google.android.gms.ads.internal.util.client.DynamiteLoader.LoadingException;
import com.google.android.gms.dynamic.e;

@com.google.android.gms.ads.internal.q.a.a
public final class h
{
  public com.google.android.gms.ads.a.a a;
  public boolean b;
  
  public h() {}
  
  public h(Context paramContext)
  {
    n.a(paramContext);
    c localc = n.C;
    if (((Boolean)u.h.e.a(localc)).booleanValue()) {}
    try
    {
      this.a = ((com.google.android.gms.ads.a.a)DynamiteLoader.a(paramContext, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", j.a));
      e.a(paramContext);
      this.a.a(e.a(paramContext), "GMA_SDK");
      this.b = true;
      return;
    }
    catch (NullPointerException paramContext)
    {
      com.google.android.gms.ads.internal.util.client.k.b("Cannot dynamite load clearcut");
      return;
    }
    catch (RemoteException paramContext)
    {
      for (;;) {}
    }
    catch (DynamiteLoader.LoadingException paramContext)
    {
      for (;;) {}
    }
  }
  
  public h(Context paramContext, String paramString)
  {
    n.a(paramContext);
    try
    {
      this.a = ((com.google.android.gms.ads.a.a)DynamiteLoader.a(paramContext, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", i.a));
      e.a(paramContext);
      this.a.b(e.a(paramContext), paramString);
      this.b = true;
      return;
    }
    catch (NullPointerException paramContext)
    {
      com.google.android.gms.ads.internal.util.client.k.b("Cannot dynamite load clearcut");
      return;
    }
    catch (RemoteException paramContext)
    {
      for (;;) {}
    }
    catch (DynamiteLoader.LoadingException paramContext)
    {
      for (;;) {}
    }
  }
  
  public final k a(byte[] paramArrayOfByte)
  {
    return new k(this, paramArrayOfByte);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */