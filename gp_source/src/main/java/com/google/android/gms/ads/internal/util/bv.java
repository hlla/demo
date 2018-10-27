package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import com.google.android.gms.ads.internal.bt;

@com.google.android.gms.ads.internal.q.a.a
public final class bv
{
  public Activity a;
  private boolean b;
  private boolean c;
  private boolean d;
  private ViewTreeObserver.OnGlobalLayoutListener e;
  private ViewTreeObserver.OnScrollChangedListener f;
  private final View g;
  
  public bv(Activity paramActivity, View paramView, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.a = paramActivity;
    this.g = paramView;
    this.e = paramOnGlobalLayoutListener;
    this.f = paramOnScrollChangedListener;
  }
  
  private static ViewTreeObserver a(Activity paramActivity)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getWindow();
      localObject1 = localObject2;
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getDecorView();
        localObject1 = localObject2;
        if (paramActivity != null) {
          localObject1 = paramActivity.getViewTreeObserver();
        }
      }
    }
    return (ViewTreeObserver)localObject1;
  }
  
  private final void e()
  {
    if (!this.d)
    {
      Object localObject1 = this.e;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = this.a;
        if (localObject2 != null)
        {
          localObject2 = a((Activity)localObject2);
          if (localObject2 != null) {
            ((ViewTreeObserver)localObject2).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject1);
          }
        }
        localObject1 = bt.A.E;
        com.google.android.gms.ads.internal.util.d.a.a(this.g, this.e);
      }
      localObject1 = this.f;
      if (localObject1 != null)
      {
        localObject2 = this.a;
        if (localObject2 != null)
        {
          localObject2 = a((Activity)localObject2);
          if (localObject2 != null) {
            ((ViewTreeObserver)localObject2).addOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener)localObject1);
          }
        }
        localObject1 = bt.A.E;
        com.google.android.gms.ads.internal.util.d.a.a(this.g, this.f);
      }
      this.d = true;
    }
  }
  
  private final void f()
  {
    Object localObject2 = this.a;
    Object localObject1;
    if ((localObject2 != null) && (this.d))
    {
      localObject1 = this.e;
      if (localObject1 != null) {
        break label57;
      }
    }
    for (;;)
    {
      localObject1 = this.f;
      if (localObject1 != null)
      {
        localObject2 = a(this.a);
        if (localObject2 != null) {
          ((ViewTreeObserver)localObject2).removeOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener)localObject1);
        }
      }
      this.d = false;
      return;
      label57:
      localObject2 = a((Activity)localObject2);
      if (localObject2 != null) {
        bt.A.g.a((ViewTreeObserver)localObject2, (ViewTreeObserver.OnGlobalLayoutListener)localObject1);
      }
    }
  }
  
  public final void a()
  {
    this.c = true;
    if (this.b) {
      e();
    }
  }
  
  public final void b()
  {
    this.c = false;
    f();
  }
  
  public final void c()
  {
    this.b = true;
    if (this.c) {
      e();
    }
  }
  
  public final void d()
  {
    this.b = false;
    f();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */