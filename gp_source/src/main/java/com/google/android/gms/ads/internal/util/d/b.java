package com.google.android.gms.ads.internal.util.d;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.v;
import java.lang.ref.WeakReference;

@a
final class b
  extends d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final WeakReference a;
  
  public b(View paramView, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    super(paramView);
    this.a = new WeakReference(paramOnGlobalLayoutListener);
  }
  
  protected final void a(ViewTreeObserver paramViewTreeObserver)
  {
    paramViewTreeObserver.addOnGlobalLayoutListener(this);
  }
  
  protected final void b(ViewTreeObserver paramViewTreeObserver)
  {
    bt.A.g.a(paramViewTreeObserver, this);
  }
  
  public final void onGlobalLayout()
  {
    ViewTreeObserver.OnGlobalLayoutListener localOnGlobalLayoutListener = (ViewTreeObserver.OnGlobalLayoutListener)this.a.get();
    if (localOnGlobalLayoutListener != null)
    {
      localOnGlobalLayoutListener.onGlobalLayout();
      return;
    }
    b();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */