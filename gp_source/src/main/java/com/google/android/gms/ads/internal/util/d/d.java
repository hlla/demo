package com.google.android.gms.ads.internal.util.d;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.q.a.a;
import java.lang.ref.WeakReference;

@a
abstract class d
{
  private final WeakReference a;
  
  public d(View paramView)
  {
    this.a = new WeakReference(paramView);
  }
  
  private final ViewTreeObserver c()
  {
    Object localObject = (View)this.a.get();
    if (localObject != null)
    {
      localObject = ((View)localObject).getViewTreeObserver();
      if ((localObject != null) && (((ViewTreeObserver)localObject).isAlive())) {
        return (ViewTreeObserver)localObject;
      }
      return null;
    }
    return null;
  }
  
  public final void a()
  {
    ViewTreeObserver localViewTreeObserver = c();
    if (localViewTreeObserver != null) {
      a(localViewTreeObserver);
    }
  }
  
  protected abstract void a(ViewTreeObserver paramViewTreeObserver);
  
  public final void b()
  {
    ViewTreeObserver localViewTreeObserver = c();
    if (localViewTreeObserver != null) {
      b(localViewTreeObserver);
    }
  }
  
  protected abstract void b(ViewTreeObserver paramViewTreeObserver);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */