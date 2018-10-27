package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.util.bk;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.ads.internal.util.v;
import java.util.Map;

@com.google.android.gms.ads.internal.q.a.a
final class g
  extends com.google.android.gms.ads.internal.util.a
{
  g(AdOverlay paramAdOverlay) {}
  
  public final void a()
  {
    Object localObject1 = bt.A.x;
    int i = this.a.b.k.a;
    localObject1 = (Bitmap)((bk)localObject1).b.get(Integer.valueOf(i));
    if (localObject1 != null)
    {
      v localv = bt.A.g;
      Object localObject2 = this.a;
      Activity localActivity = ((AdOverlay)localObject2).a;
      localObject2 = ((AdOverlay)localObject2).b.k;
      localObject1 = localv.a(localActivity, (Bitmap)localObject1, ((InterstitialAdParameterParcel)localObject2).b, ((InterstitialAdParameterParcel)localObject2).c);
      n.a.post(new h(this, (Drawable)localObject1));
    }
  }
  
  public final void be_() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/overlay/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */