package com.google.android.gms.ads.internal.util.d;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.q.a.a;
import java.lang.ref.WeakReference;

@a
final class c
  extends d
  implements ViewTreeObserver.OnScrollChangedListener
{
  private final WeakReference a;
  
  public c(View paramView, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    super(paramView);
    this.a = new WeakReference(paramOnScrollChangedListener);
  }
  
  protected final void a(ViewTreeObserver paramViewTreeObserver)
  {
    paramViewTreeObserver.addOnScrollChangedListener(this);
  }
  
  protected final void b(ViewTreeObserver paramViewTreeObserver)
  {
    paramViewTreeObserver.removeOnScrollChangedListener(this);
  }
  
  public final void onScrollChanged()
  {
    ViewTreeObserver.OnScrollChangedListener localOnScrollChangedListener = (ViewTreeObserver.OnScrollChangedListener)this.a.get();
    if (localOnScrollChangedListener != null)
    {
      localOnScrollChangedListener.onScrollChanged();
      return;
    }
    b();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */