package com.google.android.gms.ads.internal.w.b.a;

import android.annotation.TargetApi;
import android.net.Uri;
import com.google.android.gms.ads.exoplayer1.af;
import com.google.android.gms.ads.exoplayer1.b.g;
import com.google.android.gms.ads.exoplayer1.upstream.DefaultUriDataSource;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.w.a.w;
import com.google.android.gms.ads.internal.w.ad;

@a
@TargetApi(16)
public final class b
  extends f
{
  private final String g = null;
  
  public b(ad paramad)
  {
    super(paramad);
  }
  
  protected final int c()
  {
    return 0;
  }
  
  protected final af c(String paramString)
  {
    Object localObject2 = new DefaultUriDataSource(this.a, this.b);
    Object localObject1 = localObject2;
    if (((Boolean)n.A.a()).booleanValue()) {
      localObject1 = new w(this.a, (com.google.android.gms.ads.exoplayer1.upstream.d)localObject2, new c(this));
    }
    if (!"video/webm".equals(null)) {}
    for (localObject2 = new com.google.android.gms.ads.exoplayer1.b.a.f();; localObject2 = new com.google.android.gms.ads.exoplayer1.b.b.f()) {
      return new g(Uri.parse(paramString), (com.google.android.gms.ads.exoplayer1.upstream.d)localObject1, (com.google.android.gms.ads.exoplayer1.b.d)localObject2, ((Integer)n.ct.a()).intValue());
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/w/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */