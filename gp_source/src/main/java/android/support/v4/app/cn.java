package android.support.v4.app;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class cn
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
{
  private final Runnable a;
  private final View b;
  private ViewTreeObserver c;
  
  private cn(View paramView, Runnable paramRunnable)
  {
    this.b = paramView;
    this.c = paramView.getViewTreeObserver();
    this.a = paramRunnable;
  }
  
  public static cn a(View paramView, Runnable paramRunnable)
  {
    paramRunnable = new cn(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnPreDrawListener(paramRunnable);
    paramView.addOnAttachStateChangeListener(paramRunnable);
    return paramRunnable;
  }
  
  private final void a()
  {
    if (this.c.isAlive()) {
      this.c.removeOnPreDrawListener(this);
    }
    for (;;)
    {
      this.b.removeOnAttachStateChangeListener(this);
      return;
      this.b.getViewTreeObserver().removeOnPreDrawListener(this);
    }
  }
  
  public final boolean onPreDraw()
  {
    a();
    this.a.run();
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView)
  {
    this.c = paramView.getViewTreeObserver();
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */