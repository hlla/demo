package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.ac;
import android.support.v4.view.ag;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;

final class hr
  implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener
{
  public static hr b;
  public static hr c;
  public final View a;
  private int d;
  private int e;
  private boolean f;
  private final Runnable g = new ht(this);
  private final int h;
  private hu i;
  private final Runnable j = new hs(this);
  private final CharSequence k;
  
  hr(View paramView, CharSequence paramCharSequence)
  {
    this.a = paramView;
    this.k = paramCharSequence;
    this.h = ag.a(ViewConfiguration.get(this.a.getContext()));
    b();
    this.a.setOnLongClickListener(this);
    this.a.setOnHoverListener(this);
  }
  
  static void a(hr paramhr)
  {
    if (c != null)
    {
      hr localhr = c;
      localhr.a.removeCallbacks(localhr.j);
    }
    c = paramhr;
    if (paramhr != null)
    {
      paramhr = c;
      paramhr.a.postDelayed(paramhr.j, ViewConfiguration.getLongPressTimeout());
    }
  }
  
  private final void b()
  {
    this.d = Integer.MAX_VALUE;
    this.e = Integer.MAX_VALUE;
  }
  
  final void a()
  {
    if (b == this)
    {
      b = null;
      hu localhu = this.i;
      if (localhu == null) {
        break label65;
      }
      localhu.a();
      this.i = null;
      b();
      this.a.removeOnAttachStateChangeListener(this);
    }
    for (;;)
    {
      if (c == this) {
        a(null);
      }
      this.a.removeCallbacks(this.g);
      return;
      label65:
      Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
    }
  }
  
  final void a(boolean paramBoolean)
  {
    hu localhu;
    View localView;
    int m;
    int i1;
    Object localObject1;
    WindowManager.LayoutParams localLayoutParams;
    int n;
    if (ac.L(this.a))
    {
      a(null);
      if (b != null) {
        b.a();
      }
      b = this;
      this.f = paramBoolean;
      this.i = new hu(this.a.getContext());
      localhu = this.i;
      localView = this.a;
      m = this.d;
      i1 = this.e;
      paramBoolean = this.f;
      localObject1 = this.k;
      if (localhu.b()) {
        localhu.a();
      }
      localhu.d.setText((CharSequence)localObject1);
      localLayoutParams = localhu.c;
      localLayoutParams.token = localView.getApplicationWindowToken();
      n = localhu.b.getResources().getDimensionPixelOffset(2131167492);
      if (localView.getWidth() >= n) {
        break label771;
      }
      m = localView.getWidth() / 2;
    }
    label307:
    label771:
    for (;;)
    {
      int i2;
      if (localView.getHeight() >= n)
      {
        i2 = localhu.b.getResources().getDimensionPixelOffset(2131167491);
        n = i1 + i2;
        i1 -= i2;
      }
      for (;;)
      {
        localLayoutParams.gravity = 49;
        localObject1 = localhu.b.getResources();
        if (!paramBoolean) {}
        for (i2 = 2131167494;; i2 = 2131167495)
        {
          int i3 = ((Resources)localObject1).getDimensionPixelOffset(i2);
          Object localObject3 = localView.getRootView();
          Object localObject2 = ((View)localObject3).getLayoutParams();
          if ((localObject2 instanceof WindowManager.LayoutParams))
          {
            localObject1 = localObject3;
            if (((WindowManager.LayoutParams)localObject2).type == 2) {
              break label307;
            }
          }
          for (localObject2 = localView.getContext();; localObject2 = ((ContextWrapper)localObject2).getBaseContext())
          {
            localObject1 = localObject3;
            if ((localObject2 instanceof ContextWrapper))
            {
              if ((localObject2 instanceof Activity)) {
                localObject1 = ((Activity)localObject2).getWindow().getDecorView();
              }
            }
            else
            {
              if (localObject1 != null)
              {
                ((View)localObject1).getWindowVisibleDisplayFrame(localhu.g);
                if ((localhu.g.left < 0) && (localhu.g.top < 0))
                {
                  localObject2 = localhu.b.getResources();
                  i2 = ((Resources)localObject2).getIdentifier("status_bar_height", "dimen", "android");
                  if (i2 != 0)
                  {
                    i2 = ((Resources)localObject2).getDimensionPixelSize(i2);
                    localObject2 = ((Resources)localObject2).getDisplayMetrics();
                    localhu.g.set(0, i2, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
                  }
                }
                else
                {
                  ((View)localObject1).getLocationOnScreen(localhu.f);
                  localView.getLocationOnScreen(localhu.e);
                  localObject2 = localhu.e;
                  i2 = localObject2[0];
                  localObject3 = localhu.f;
                  localObject2[0] = (i2 - localObject3[0]);
                  localObject2[1] -= localObject3[1];
                  localLayoutParams.x = (localObject2[0] + m - ((View)localObject1).getWidth() / 2);
                  m = View.MeasureSpec.makeMeasureSpec(0, 0);
                  localhu.a.measure(m, m);
                  m = localhu.a.getMeasuredHeight();
                  i2 = localhu.e[1];
                  i1 = i1 + i2 - i3 - m;
                  n = i2 + n + i3;
                  if (!paramBoolean) {
                    if (m + n <= localhu.g.height()) {
                      localLayoutParams.y = n;
                    }
                  }
                }
              }
              for (;;)
              {
                ((WindowManager)localhu.b.getSystemService("window")).addView(localhu.a, localhu.c);
                this.a.addOnAttachStateChangeListener(this);
                long l;
                if (!this.f) {
                  if ((ac.w(this.a) & 0x1) == 1) {
                    l = 3000L - ViewConfiguration.getLongPressTimeout();
                  }
                }
                for (;;)
                {
                  this.a.removeCallbacks(this.g);
                  this.a.postDelayed(this.g, l);
                  return;
                  l = 15000L - ViewConfiguration.getLongPressTimeout();
                  continue;
                  l = 2500L;
                }
                localLayoutParams.y = i1;
                continue;
                if (i1 < 0)
                {
                  localLayoutParams.y = n;
                }
                else
                {
                  localLayoutParams.y = i1;
                  continue;
                  i2 = 0;
                  break;
                  Log.e("TooltipPopup", "Cannot find app view");
                }
              }
            }
          }
        }
        n = localView.getHeight();
        i1 = 0;
      }
    }
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.i == null) || (!this.f))
    {
      paramView = (AccessibilityManager)this.a.getContext().getSystemService("accessibility");
      if ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled())) {}
    }
    switch (paramMotionEvent.getAction())
    {
    case 8: 
    case 9: 
    default: 
    case 7: 
      int m;
      int n;
      do
      {
        do
        {
          return false;
        } while ((!this.a.isEnabled()) || (this.i != null));
        m = (int)paramMotionEvent.getX();
        n = (int)paramMotionEvent.getY();
      } while ((Math.abs(m - this.d) <= this.h) && (Math.abs(n - this.e) <= this.h));
      this.d = m;
      this.e = n;
      a(this);
      return false;
    }
    b();
    a();
    return false;
  }
  
  public final boolean onLongClick(View paramView)
  {
    this.d = (paramView.getWidth() / 2);
    this.e = (paramView.getHeight() / 2);
    a(true);
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/hr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */