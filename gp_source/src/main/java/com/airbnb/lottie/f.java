package com.airbnb.lottie;

import java.lang.ref.WeakReference;
import java.util.Map;

final class f
  implements s
{
  f(LottieAnimationView paramLottieAnimationView, g paramg, String paramString) {}
  
  public final void a(i parami)
  {
    if (this.c != g.a) {
      if (this.c == g.b) {
        LottieAnimationView.b.put(this.b, new WeakReference(parami));
      }
    }
    for (;;)
    {
      this.a.setComposition(parami);
      return;
      LottieAnimationView.a.put(this.b, parami);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */