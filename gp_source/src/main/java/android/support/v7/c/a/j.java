package android.support.v7.c.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

final class j
  implements Drawable.Callback
{
  public Drawable.Callback a;
  
  public final Drawable.Callback a()
  {
    Drawable.Callback localCallback = this.a;
    this.a = null;
    return localCallback;
  }
  
  public final void invalidateDrawable(Drawable paramDrawable) {}
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    Drawable.Callback localCallback = this.a;
    if (localCallback != null) {
      localCallback.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
    }
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    Drawable.Callback localCallback = this.a;
    if (localCallback != null) {
      localCallback.unscheduleDrawable(paramDrawable, paramRunnable);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/c/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */