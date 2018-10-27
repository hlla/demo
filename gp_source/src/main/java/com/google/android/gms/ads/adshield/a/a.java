package com.google.android.gms.ads.adshield.a;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.ads.c.b;
import com.google.android.gms.ads.internal.zxxz.GADUrlException;
import com.google.android.gms.ads.internal.zxxz.aa;
import com.google.android.gms.ads.internal.zxxz.w;
import com.google.android.gms.ads.internal.zxxz.x;
import com.google.android.gms.ads.internal.zxxz.z;
import com.google.android.gms.dynamic.e;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  extends d
{
  private final x a;
  private boolean b = false;
  private final z c;
  private final aa d;
  
  public a(String paramString, Context paramContext, boolean paramBoolean)
  {
    this.c = z.a(paramString, paramContext, false);
    this.d = new aa(this.c);
    this.a = x.b(paramContext);
  }
  
  private final com.google.android.gms.ads.internal.j.a a(com.google.android.gms.ads.internal.j.a parama1, com.google.android.gms.ads.internal.j.a parama2, boolean paramBoolean)
  {
    try
    {
      parama1 = (Uri)e.a(parama1);
      parama2 = (Context)e.a(parama2);
      if (!paramBoolean) {}
      for (parama1 = this.d.a(parama1, parama2, null, null);; parama1 = this.d.a(parama1, parama2)) {
        return e.a(parama1);
      }
      return null;
    }
    catch (GADUrlException parama1) {}
  }
  
  public final com.google.android.gms.ads.internal.j.a a(com.google.android.gms.ads.internal.j.a parama1, com.google.android.gms.ads.internal.j.a parama2)
  {
    return a(parama1, parama2, true);
  }
  
  public final String a()
  {
    return "ms";
  }
  
  public final String a(com.google.android.gms.ads.internal.j.a parama, String paramString)
  {
    parama = (Context)e.a(parama);
    return this.c.a(parama, paramString, null);
  }
  
  public final String a(com.google.android.gms.ads.internal.j.a parama, byte[] paramArrayOfByte)
  {
    parama = (Context)e.a(parama);
    String str = this.c.a(parama, paramArrayOfByte);
    x localx = this.a;
    if ((localx != null) && (this.b))
    {
      parama = x.a(str, localx.a(parama, paramArrayOfByte));
      this.b = false;
      return parama;
    }
    return str;
  }
  
  public final void a(String paramString)
  {
    this.d.d = paramString.split(",");
  }
  
  public final void a(String paramString1, String paramString2)
  {
    aa localaa = this.d;
    localaa.a = paramString1;
    localaa.b = paramString2;
  }
  
  public final boolean a(com.google.android.gms.ads.internal.j.a parama)
  {
    parama = (Uri)e.a(parama);
    return this.d.a(parama);
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    if (this.a != null)
    {
      paramString = new b(paramString, paramBoolean);
      this.a.r = paramString;
      this.b = true;
      return true;
    }
    return false;
  }
  
  public final com.google.android.gms.ads.internal.j.a b(com.google.android.gms.ads.internal.j.a parama1, com.google.android.gms.ads.internal.j.a parama2)
  {
    return a(parama1, parama2, false);
  }
  
  public final boolean b(com.google.android.gms.ads.internal.j.a parama)
  {
    parama = (Uri)e.a(parama);
    return this.d.b(parama);
  }
  
  public final String c(com.google.android.gms.ads.internal.j.a parama)
  {
    return a(parama, null);
  }
  
  public final void d(com.google.android.gms.ads.internal.j.a parama)
  {
    parama = (MotionEvent)e.a(parama);
    this.d.a(parama);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/adshield/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */