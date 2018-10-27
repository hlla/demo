package android.support.v7.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.u;
import android.support.v7.c.a.m;
import android.util.Log;
import android.view.View;

public final class e
  implements u
{
  public final int a;
  public boolean b = true;
  public final DrawerLayout c;
  public Drawable d;
  public final int e;
  public m f;
  private final f g;
  private boolean h = true;
  private boolean i = false;
  
  public e(Activity paramActivity, DrawerLayout paramDrawerLayout)
  {
    this(paramActivity, paramDrawerLayout, 2131953002, 2131952998);
  }
  
  private e(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2)
  {
    if ((paramActivity instanceof g)) {}
    for (this.g = ((g)paramActivity).M_();; this.g = new h(paramActivity))
    {
      this.c = paramDrawerLayout;
      this.e = 2131953002;
      this.a = 2131952998;
      this.f = new m(this.g.b());
      this.d = b();
      return;
    }
  }
  
  private final void a(float paramFloat)
  {
    if (paramFloat == 1.0F) {
      this.f.a(true);
    }
    for (;;)
    {
      this.f.a(paramFloat);
      return;
      if (paramFloat == 0.0F) {
        this.f.a(false);
      }
    }
  }
  
  private final void b(int paramInt)
  {
    this.g.a(paramInt);
  }
  
  public final void a()
  {
    if (this.c.at_()) {
      a(1.0F);
    }
    for (;;)
    {
      m localm;
      if (this.b)
      {
        localm = this.f;
        if (this.c.at_()) {
          break label49;
        }
      }
      label49:
      for (int j = this.e;; j = this.a)
      {
        a(localm, j);
        return;
      }
      a(0.0F);
    }
  }
  
  public final void a(Drawable paramDrawable, int paramInt)
  {
    if ((!this.i) && (!this.g.c()))
    {
      Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
      this.i = true;
    }
    this.g.a(paramDrawable, paramInt);
  }
  
  public final void a(View paramView, float paramFloat)
  {
    if (this.h)
    {
      a(Math.min(1.0F, Math.max(0.0F, paramFloat)));
      return;
    }
    a(0.0F);
  }
  
  public final Drawable b()
  {
    return this.g.a();
  }
  
  public final void b_(View paramView)
  {
    a(0.0F);
    if (this.b) {
      b(this.e);
    }
  }
  
  public final void c_(View paramView)
  {
    a(1.0F);
    if (this.b) {
      b(this.a);
    }
  }
  
  public final void g_(int paramInt) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */