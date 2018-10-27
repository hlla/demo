package com.google.android.gms.ads.internal.formats.a;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.client.k;

@a
public final class h
  extends com.google.android.gms.ads.formats.e
{
  private final Drawable a;
  private final e b;
  private final double c;
  private final Uri d;
  
  public h(e parame)
  {
    this.b = parame;
    try
    {
      parame = this.b.a();
      if (parame == null) {
        break label70;
      }
      parame = (Drawable)com.google.android.gms.dynamic.e.a(parame);
    }
    catch (RemoteException parame)
    {
      try
      {
        parame = this.b.b();
        this.d = parame;
      }
      catch (RemoteException parame)
      {
        try
        {
          for (;;)
          {
            d1 = this.b.c();
            this.c = d1;
            return;
            parame = null;
            continue;
            parame = parame;
            k.c("", parame);
            parame = null;
          }
          parame = parame;
          k.c("", parame);
          parame = (e)localObject;
        }
        catch (RemoteException parame)
        {
          for (;;)
          {
            k.c("", parame);
            double d1 = 1.0D;
          }
        }
      }
    }
    this.a = parame;
  }
  
  public final Drawable a()
  {
    return this.a;
  }
  
  public final Uri b()
  {
    return this.d;
  }
  
  public final double c()
  {
    return this.c;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/formats/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */