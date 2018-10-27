package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.ah;

@a
final class e
  extends RelativeLayout
{
  public boolean a;
  private ah b;
  
  public e(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    this.b = new ah(paramContext, paramString1);
    this.b.b = paramString2;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.a) {
      this.b.a(paramMotionEvent);
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/overlay/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */