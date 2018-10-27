package com.google.android.gms.ads.internal.renderer;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.ads.internal.v.b;

@com.google.android.gms.ads.internal.q.a.a
public abstract class AdRendererBackgroundTask
  extends com.google.android.gms.ads.internal.util.a
{
  public final f a;
  public AdResponseParcel b;
  public final Object c = new Object();
  public final Context d;
  public final Object e = new Object();
  public final b f;
  
  protected AdRendererBackgroundTask(Context paramContext, b paramb, f paramf)
  {
    super((byte)0);
    this.d = paramContext;
    this.f = paramb;
    this.b = paramb.e;
    this.a = paramf;
  }
  
  protected abstract com.google.android.gms.ads.internal.v.a a(int paramInt);
  
  public final void a()
  {
    int i;
    synchronized (this.e)
    {
      e.b("AdRendererBackgroundTask started.");
      i = this.f.h;
    }
    try
    {
      a(SystemClock.elapsedRealtime());
      com.google.android.gms.ads.internal.v.a locala = a(i);
      n.a.post(new d(this, locala));
      return;
    }
    catch (AdRendererBackgroundTask.AdRendererException localAdRendererException)
    {
      i = localAdRendererException.a;
      if (i != 3) {
        break label118;
      }
    }
    localObject2 = finally;
    throw ((Throwable)localObject2);
    label68:
    e.d(localAdRendererException.getMessage());
    label75:
    AdResponseParcel localAdResponseParcel = this.b;
    if (localAdResponseParcel != null) {}
    for (this.b = new AdResponseParcel(i, localAdResponseParcel.M);; this.b = new AdResponseParcel(i))
    {
      n.a.post(new c(this));
      break;
      label118:
      if (i == -1) {
        break label68;
      }
      e.e(localAdResponseParcel.getMessage());
      break label75;
    }
  }
  
  protected abstract void a(long paramLong);
  
  public void be_() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/renderer/AdRendererBackgroundTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */