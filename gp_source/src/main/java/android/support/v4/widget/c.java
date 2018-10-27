package android.support.v4.widget;

import android.os.SystemClock;
import android.support.v4.view.ac;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;

final class c
  implements Runnable
{
  c(a parama) {}
  
  public final void run()
  {
    Object localObject = this.a;
    if (((a)localObject).a)
    {
      if (((a)localObject).c)
      {
        ((a)localObject).c = false;
        localObject = ((a)localObject).d;
        ((b)localObject).f = AnimationUtils.currentAnimationTimeMillis();
        ((b)localObject).g = -1L;
        ((b)localObject).a = ((b)localObject).f;
        ((b)localObject).h = 0.5F;
        ((b)localObject).b = 0;
      }
      localObject = this.a.d;
      if ((((b)localObject).g <= 0L) || (AnimationUtils.currentAnimationTimeMillis() <= ((b)localObject).g + ((b)localObject).c)) {
        break label121;
      }
    }
    label121:
    while (!this.a.a())
    {
      this.a.a = false;
      return;
    }
    a locala = this.a;
    if (locala.b)
    {
      locala.b = false;
      l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
      locala.e.onTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
    if (((b)localObject).a == 0L) {
      throw new RuntimeException("Cannot compute scroll delta before calling start()");
    }
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    float f = ((b)localObject).a(l1);
    long l2 = ((b)localObject).a;
    ((b)localObject).a = l1;
    ((b)localObject).b = ((int)((float)(l1 - l2) * (-4.0F * f * f + f * 4.0F) * ((b)localObject).j));
    int i = ((b)localObject).b;
    this.a.a(i);
    ac.a(this.a.e, this);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */