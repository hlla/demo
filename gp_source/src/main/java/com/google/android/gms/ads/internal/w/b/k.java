package com.google.android.gms.ads.internal.w.b;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.ads.internal.w.ad;
import com.google.android.gms.common.api.w;
import java.lang.ref.WeakReference;

@com.google.android.gms.ads.internal.q.a.a
public abstract class k
  implements w
{
  public Context a;
  public String b;
  public WeakReference c;
  
  public k(ad paramad)
  {
    this.a = paramad.getContext();
    this.b = bt.A.e.b(this.a, paramad.getVersionInfo().a);
    this.c = new WeakReference(paramad);
  }
  
  public abstract void a();
  
  protected final void a(String paramString1, String paramString2, int paramInt)
  {
    com.google.android.gms.ads.internal.util.client.a.g.post(new o(this, paramString1, paramString2, paramInt));
  }
  
  public final void a(String paramString1, String paramString2, long paramLong)
  {
    com.google.android.gms.ads.internal.util.client.a.g.post(new p(this, paramString1, paramString2, paramLong));
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    com.google.android.gms.ads.internal.util.client.a.g.post(new q(this, paramString1, paramString2, paramString3, paramString4));
  }
  
  public abstract boolean a(String paramString);
  
  public String b(String paramString)
  {
    com.google.android.gms.ads.internal.util.client.a locala = u.h.a;
    return com.google.android.gms.ads.internal.util.client.a.a(paramString);
  }
  
  public void b() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */