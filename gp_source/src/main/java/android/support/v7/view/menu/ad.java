package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.k;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

public class ad
{
  public View a;
  public int b = 8388611;
  public PopupWindow.OnDismissListener c;
  private final Context d;
  private boolean e;
  private final PopupWindow.OnDismissListener f = new ae(this);
  private final p g;
  private final boolean h;
  private ac i;
  private final int j;
  private final int k;
  private ag l;
  
  public ad(Context paramContext, p paramp, View paramView, boolean paramBoolean)
  {
    this(paramContext, paramp, paramView, paramBoolean, 2130968606, 0);
  }
  
  public ad(Context paramContext, p paramp, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.d = paramContext;
    this.g = paramp;
    this.a = paramView;
    this.h = paramBoolean;
    this.j = paramInt1;
    this.k = paramInt2;
  }
  
  public final void a()
  {
    if (!c()) {
      throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }
  }
  
  final void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ac localac = b();
    localac.c(paramBoolean2);
    if (paramBoolean1)
    {
      int m = paramInt1;
      if ((k.a(this.b, android.support.v4.view.ac.h(this.a)) & 0x7) == 5) {
        m = paramInt1 - this.a.getWidth();
      }
      localac.b(m);
      localac.c(paramInt2);
      paramInt1 = (int)(this.d.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localac.g = new Rect(m - paramInt1, paramInt2 - paramInt1, m + paramInt1, paramInt1 + paramInt2);
    }
    localac.b();
  }
  
  public final void a(ag paramag)
  {
    this.l = paramag;
    ac localac = this.i;
    if (localac != null) {
      localac.a(paramag);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    ac localac = this.i;
    if (localac != null) {
      localac.b(paramBoolean);
    }
  }
  
  public final ac b()
  {
    Object localObject;
    Point localPoint;
    if (this.i == null)
    {
      localObject = ((WindowManager)this.d.getSystemService("window")).getDefaultDisplay();
      localPoint = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label193;
      }
      ((Display)localObject).getRealSize(localPoint);
    }
    for (;;)
    {
      if (Math.min(localPoint.x, localPoint.y) >= this.d.getResources().getDimensionPixelSize(2131165206)) {}
      for (localObject = new g(this.d, this.a, this.j, this.k, this.h);; localObject = new am(this.d, this.g, this.a, this.j, this.k, this.h))
      {
        ((ac)localObject).a(this.g);
        ((ac)localObject).a(this.f);
        ((ac)localObject).a(this.a);
        ((ac)localObject).a(this.l);
        ((ac)localObject).b(this.e);
        ((ac)localObject).a(this.b);
        this.i = ((ac)localObject);
        return this.i;
      }
      label193:
      ((Display)localObject).getSize(localPoint);
    }
  }
  
  public final boolean c()
  {
    if (!f())
    {
      if (this.a != null) {
        a(0, 0, false, false);
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final void d()
  {
    if (f()) {
      this.i.c();
    }
  }
  
  public void e()
  {
    this.i = null;
    PopupWindow.OnDismissListener localOnDismissListener = this.c;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss();
    }
  }
  
  public final boolean f()
  {
    ac localac = this.i;
    return (localac != null) && (localac.d());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */