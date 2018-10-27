package com.google.android.gms.ads.internal.js;

import android.content.Context;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.at;
import com.google.android.gms.ads.internal.util.c.e;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

@a
public final class y
{
  public final Context a;
  public ap b;
  public at c;
  public final String d;
  public final Object e = new Object();
  public int f = 1;
  public final VersionInfoParcel g;
  private at h;
  
  public y(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString)
  {
    this.d = paramString;
    this.a = paramContext.getApplicationContext();
    this.g = paramVersionInfoParcel;
    this.c = new ak();
    this.h = new ak();
  }
  
  public y(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString, at paramat1, at paramat2)
  {
    this(paramContext, paramVersionInfoParcel, paramString);
    this.c = paramat1;
    this.h = paramat2;
  }
  
  public final al a()
  {
    int i;
    synchronized (this.e)
    {
      Object localObject2 = this.b;
      if ((localObject2 == null) || (((e)localObject2).b == -1)) {
        break label98;
      }
      i = this.f;
      if (i == 0)
      {
        localObject2 = ((ap)localObject2).a();
        return (al)localObject2;
      }
      if (i == 1)
      {
        this.f = 2;
        a(null);
        localObject2 = this.b.a();
        return (al)localObject2;
      }
    }
    if (i == 2)
    {
      localal = ((ap)localObject3).a();
      return localal;
    }
    al localal = localal.a();
    return localal;
    label98:
    this.f = 2;
    this.b = a(null);
    localal = this.b.a();
    return localal;
  }
  
  protected final ap a(com.google.android.gms.ads.internal.zxxz.aa paramaa)
  {
    ap localap = new ap(this.h);
    com.google.android.gms.ads.internal.util.a.aa.b.execute(new z(this, paramaa, localap));
    localap.a(new ah(this, localap), new ai(this, localap));
    return localap;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/js/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */