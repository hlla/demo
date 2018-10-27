package android.support.d.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

final class c
  implements Drawable.Callback
{
  c(b paramb) {}
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    this.a.invalidateSelf();
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    this.a.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.a.unscheduleSelf(paramRunnable);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/d/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */