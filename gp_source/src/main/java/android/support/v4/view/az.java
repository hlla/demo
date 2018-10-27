package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class az
{
  public WeakReference a;
  
  az(View paramView)
  {
    this.a = new WeakReference(paramView);
  }
  
  public final az a(float paramFloat)
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().alpha(paramFloat);
    }
    return this;
  }
  
  public final az a(long paramLong)
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().setDuration(paramLong);
    }
    return this;
  }
  
  public final az a(bc parambc)
  {
    View localView = (View)this.a.get();
    if (localView != null)
    {
      if (parambc != null) {
        localView.animate().setListener(new ba(parambc, localView));
      }
    }
    else {
      return this;
    }
    localView.animate().setListener(null);
    return this;
  }
  
  public final az a(be parambe)
  {
    View localView = (View)this.a.get();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 19)) {
      if (parambe == null) {
        break label47;
      }
    }
    label47:
    for (parambe = new bb(parambe);; parambe = null)
    {
      localView.animate().setUpdateListener(parambe);
      return this;
    }
  }
  
  public final az a(Interpolator paramInterpolator)
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().setInterpolator(paramInterpolator);
    }
    return this;
  }
  
  public final void a()
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().cancel();
    }
  }
  
  public final az b(float paramFloat)
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().translationY(paramFloat);
    }
    return this;
  }
  
  public final void b()
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().start();
    }
  }
  
  public final az c(float paramFloat)
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().scaleX(paramFloat);
    }
    return this;
  }
  
  public final az d(float paramFloat)
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.animate().scaleY(paramFloat);
    }
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */