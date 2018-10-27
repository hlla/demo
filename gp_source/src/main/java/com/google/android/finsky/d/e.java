package com.google.android.finsky.d;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import com.google.android.finsky.bw.k;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.bg;

final class e
  implements ActivityLifecycleCallbacks, OnGlobalLayoutListener, OnScrollChangedListener
{
  public final Application a;
  public g b;
  public View c;
  public ViewTreeObserver d;
  private final Rect e;
  private final Context f;
  private final boolean g;
  private boolean h = false;
  private final j i;
  private final l j;
  private int k = -1;
  
  e(Context paramContext, g paramg, j paramj, l paraml, boolean paramBoolean)
  {
    this.a = ((Application)paramContext.getApplicationContext());
    this.f = paramContext;
    this.b = paramg;
    this.i = paramj;
    this.j = paraml;
    this.e = new Rect();
    this.g = paramBoolean;
  }
  
  private final void a(Activity paramActivity, int paramInt)
  {
    if (this.c != null)
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null)
      {
        paramActivity = paramActivity.peekDecorView();
        View localView = this.c;
        if ((localView != null) && (paramActivity != null) && (localView.getRootView() == paramActivity.getRootView())) {
          this.k = paramInt;
        }
      }
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    double d2 = -1.0D;
    double d1 = 0.0D;
    boolean bool2;
    boolean bool1;
    if ((this.b != null) && (this.c != null))
    {
      if (this.g) {
        break label359;
      }
      bool2 = a();
      bool1 = bool2;
      if (bool2) {
        bool1 = this.c.getGlobalVisibleRect(this.e);
      }
      if ((bool1 != this.h) || (this.j.a())) {
        if (paramBoolean) {
          break label346;
        }
      }
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label328:
    label336:
    label341:
    label346:
    while ((bool1) || (this.h))
    {
      paramBoolean = bool1;
      double d3;
      if (bool1)
      {
        localObject1 = this.i;
        localObject2 = this.c;
        ((View)localObject2).getLocationOnScreen(((j)localObject1).b);
        ((j)localObject1).a.left = localObject1.b[0];
        ((j)localObject1).a.top = localObject1.b[1];
        localObject3 = ((j)localObject1).a;
        ((Rect)localObject3).right = (((Rect)localObject3).left + ((View)localObject2).getWidth());
        localObject3 = ((j)localObject1).a;
        int m = ((Rect)localObject3).top;
        ((Rect)localObject3).bottom = (((View)localObject2).getHeight() + m);
        localObject1 = ((j)localObject1).a;
        localObject2 = this.e;
        localObject3 = this.f.getResources();
        if (((Rect)localObject1).left != ((Rect)localObject2).left) {
          break label341;
        }
        if (((Rect)localObject1).top != ((Rect)localObject2).top) {
          break label336;
        }
        d1 = j.a(new Rect(0, 0, k.k((Resources)localObject3), k.l((Resources)localObject3)), (Rect)localObject2);
        m = ((Rect)localObject1).width();
        d3 = ((Rect)localObject1).height() * m;
        if (d3 != 0.0D) {
          break label328;
        }
        FinskyLog.d("Error while calculating exposure of a view.", new Object[0]);
        d1 = d2;
      }
      for (;;)
      {
        paramBoolean = bool1;
        this.h = paramBoolean;
        bg.a(new f(this, this.b, d1), new Void[0]);
        return;
        d1 /= d3;
        continue;
        d1 = 0.0D;
        continue;
        d1 = 0.0D;
      }
    }
    return;
    label359:
    if (!paramBoolean) {}
    while (this.j.a())
    {
      bool2 = a();
      bool1 = bool2;
      if (bool2) {
        bool1 = this.c.getGlobalVisibleRect(this.e);
      }
      if (!paramBoolean) {}
      while ((bool1) || (this.h))
      {
        paramBoolean = bool1;
        if (!bool1) {
          break;
        }
        localObject1 = this.e;
        localObject2 = this.c;
        localObject3 = this.f.getResources();
        d1 = j.a(new Rect(0, 0, k.k((Resources)localObject3), k.l((Resources)localObject3)), (Rect)localObject1);
        d2 = ((View)localObject2).getWidth() * ((View)localObject2).getHeight();
        if (d2 == 0.0D)
        {
          FinskyLog.d("Error while calculating exposure of a view.", new Object[0]);
          d1 = -1.0D;
          paramBoolean = bool1;
          break;
        }
        d1 /= d2;
        paramBoolean = bool1;
        break;
      }
      return;
    }
  }
  
  private final boolean a()
  {
    int n = this.k;
    int m = n;
    if (n == -1) {
      m = this.c.getWindowVisibility();
    }
    return m == 0;
  }
  
  final void a(View paramView)
  {
    if (paramView != null) {}
    try
    {
      paramView = this.d;
      if ((paramView != null) && (paramView.isAlive()))
      {
        this.d.removeOnScrollChangedListener(this);
        this.d.removeGlobalOnLayoutListener(this);
      }
      this.d = null;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        try
        {
          paramView.unregisterActivityLifecycleCallbacks(this);
          return;
        }
        catch (Exception paramView)
        {
          FinskyLog.a(paramView, "Error unregistering activity lifecycle callbacks.", new Object[0]);
        }
        paramView = paramView;
        FinskyLog.a(paramView, "Error while unregistering listeners from the last ViewTreeObserver.", new Object[0]);
      }
    }
    paramView = this.a;
    if (paramView != null) {}
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    a(paramActivity, 0);
    a(false);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    a(false);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    a(paramActivity, 4);
    a(false);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity, 0);
    a(false);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    a(false);
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    a(paramActivity, 0);
    a(false);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    a(false);
  }
  
  public final void onGlobalLayout()
  {
    a(false);
  }
  
  public final void onScrollChanged()
  {
    a(true);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */