package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ac;
import android.support.v4.view.az;
import android.support.v7.view.menu.ag;
import android.support.v7.view.menu.d;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.q;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.widget.TextView;

public final class hn
  implements bj
{
  public boolean a;
  public CharSequence b;
  public Toolbar c;
  public Window.Callback d;
  private j e;
  private View f;
  private int g = 0;
  private Drawable h;
  private int i;
  private CharSequence j;
  private Drawable k;
  private Drawable l;
  private Drawable m;
  private CharSequence n;
  private View o;
  private boolean p;
  
  public hn(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, (byte)0);
  }
  
  private hn(Toolbar paramToolbar, boolean paramBoolean, byte paramByte)
  {
    this.c = paramToolbar;
    this.b = paramToolbar.getTitle();
    this.n = paramToolbar.getSubtitle();
    if (this.b != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.p = bool;
      this.m = paramToolbar.getNavigationIcon();
      paramToolbar = hf.a(paramToolbar.getContext(), null, android.support.v7.a.a.a, 2130968581, 0);
      this.h = paramToolbar.a(android.support.v7.a.a.n);
      if (paramBoolean)
      {
        Object localObject1 = paramToolbar.c(android.support.v7.a.a.t);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          b((CharSequence)localObject1);
        }
        localObject1 = paramToolbar.c(android.support.v7.a.a.r);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          c((CharSequence)localObject1);
        }
        localObject1 = paramToolbar.a(android.support.v7.a.a.p);
        if (localObject1 != null) {
          b((Drawable)localObject1);
        }
        localObject1 = paramToolbar.a(android.support.v7.a.a.o);
        if (localObject1 != null) {
          a((Drawable)localObject1);
        }
        if (this.m == null)
        {
          localObject1 = this.h;
          if (localObject1 != null) {
            c((Drawable)localObject1);
          }
        }
        c(paramToolbar.a(android.support.v7.a.a.j, 0));
        paramByte = paramToolbar.g(android.support.v7.a.a.i, 0);
        Object localObject2;
        if (paramByte != 0)
        {
          localObject1 = LayoutInflater.from(this.c.getContext()).inflate(paramByte, this.c, false);
          localObject2 = this.f;
          if ((localObject2 != null) && ((this.i & 0x10) != 0)) {
            this.c.removeView((View)localObject2);
          }
          this.f = ((View)localObject1);
          if ((localObject1 != null) && ((this.i & 0x10) != 0)) {
            this.c.addView(this.f);
          }
          c(this.i | 0x10);
        }
        paramByte = paramToolbar.f(android.support.v7.a.a.l, 0);
        if (paramByte > 0)
        {
          localObject1 = this.c.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).height = paramByte;
          this.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        int i1 = paramToolbar.d(android.support.v7.a.a.h, -1);
        paramByte = paramToolbar.d(android.support.v7.a.a.g, -1);
        if (i1 >= 0) {}
        for (;;)
        {
          localObject1 = this.c;
          i1 = Math.max(i1, 0);
          paramByte = Math.max(paramByte, 0);
          ((Toolbar)localObject1).h();
          ((Toolbar)localObject1).f.a(i1, paramByte);
          do
          {
            paramByte = paramToolbar.g(android.support.v7.a.a.u, 0);
            if (paramByte != 0)
            {
              localObject2 = this.c;
              localObject1 = ((Toolbar)localObject2).getContext();
              ((Toolbar)localObject2).r = paramByte;
              localObject2 = ((Toolbar)localObject2).s;
              if (localObject2 != null) {
                ((TextView)localObject2).setTextAppearance((Context)localObject1, paramByte);
              }
            }
            paramByte = paramToolbar.g(android.support.v7.a.a.s, 0);
            if (paramByte != 0)
            {
              localObject2 = this.c;
              localObject1 = ((Toolbar)localObject2).getContext();
              ((Toolbar)localObject2).p = paramByte;
              localObject2 = ((Toolbar)localObject2).q;
              if (localObject2 != null) {
                ((TextView)localObject2).setTextAppearance((Context)localObject1, paramByte);
              }
            }
            paramByte = paramToolbar.g(android.support.v7.a.a.q, 0);
            if (paramByte != 0) {
              this.c.setPopupTheme(paramByte);
            }
            paramToolbar.c.recycle();
            if (this.g != 2131951617)
            {
              this.g = 2131951617;
              if (TextUtils.isEmpty(this.c.getNavigationContentDescription())) {
                e(this.g);
              }
            }
            this.j = this.c.getNavigationContentDescription();
            this.c.setNavigationOnClickListener(new ho(this));
            return;
          } while (paramByte < 0);
        }
      }
      if (this.c.getNavigationIcon() != null) {
        this.h = this.c.getNavigationIcon();
      }
      for (paramByte = 15;; paramByte = 11)
      {
        this.i = paramByte;
        break;
      }
    }
  }
  
  private final void d(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    if ((this.i & 0x8) != 0) {
      this.c.setTitle(paramCharSequence);
    }
  }
  
  private final void u()
  {
    int i1 = this.i;
    Object localObject;
    if ((i1 & 0x2) != 0) {
      if ((i1 & 0x1) == 0) {
        localObject = this.k;
      }
    }
    for (;;)
    {
      this.c.setLogo((Drawable)localObject);
      return;
      Drawable localDrawable = this.l;
      localObject = localDrawable;
      if (localDrawable == null)
      {
        localObject = this.k;
        continue;
        localObject = null;
      }
    }
  }
  
  private final void v()
  {
    if ((this.i & 0x4) != 0)
    {
      Toolbar localToolbar = this.c;
      Drawable localDrawable2 = this.m;
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null) {
        localDrawable1 = this.h;
      }
      localToolbar.setNavigationIcon(localDrawable1);
      return;
    }
    this.c.setNavigationIcon(null);
  }
  
  private final void w()
  {
    if ((this.i & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.j)) {
        this.c.setNavigationContentDescription(this.g);
      }
    }
    else {
      return;
    }
    this.c.setNavigationContentDescription(this.j);
  }
  
  public final az a(int paramInt, long paramLong)
  {
    az localaz = ac.t(this.c);
    if (paramInt == 0) {}
    for (float f1 = 1.0F;; f1 = 0.0F) {
      return localaz.a(f1).a(paramLong).a(new hp(this, paramInt));
    }
  }
  
  public final ViewGroup a()
  {
    return this.c;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.b.a.a.b(this.c.getContext(), paramInt);; localDrawable = null)
    {
      a(localDrawable);
      return;
    }
  }
  
  public final void a(Drawable paramDrawable)
  {
    this.k = paramDrawable;
    u();
  }
  
  public final void a(ag paramag, q paramq)
  {
    Object localObject = this.c;
    ((Toolbar)localObject).a = paramag;
    ((Toolbar)localObject).j = paramq;
    localObject = ((Toolbar)localObject).k;
    if (localObject != null) {
      ((ActionMenuView)localObject).a(paramag, paramq);
    }
  }
  
  public final void a(Menu paramMenu, ag paramag)
  {
    if (this.e == null) {
      this.e = new j(this.c.getContext());
    }
    j localj = this.e;
    localj.a = paramag;
    paramag = this.c;
    paramMenu = (p)paramMenu;
    if ((paramMenu != null) || (paramag.k != null))
    {
      paramag.f();
      p localp = paramag.k.a;
      if (localp != paramMenu)
      {
        if (localp != null)
        {
          localp.b(paramag.m);
          localp.b(paramag.h);
        }
        if (paramag.h == null) {
          paramag.h = new hj(paramag);
        }
        localj.g = true;
        if (paramMenu == null) {
          break label172;
        }
        paramMenu.a(localj, paramag.n);
        paramMenu.a(paramag.h, paramag.n);
      }
    }
    for (;;)
    {
      paramag.k.setPopupTheme(paramag.o);
      paramag.k.setPresenter(localj);
      paramag.m = localj;
      return;
      label172:
      localj.a(paramag.n, null);
      paramag.h.a(paramag.n, null);
      localj.a(true);
      paramag.h.a(true);
    }
  }
  
  public final void a(Window.Callback paramCallback)
  {
    this.d = paramCallback;
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    if (!this.p) {
      d(paramCharSequence);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c.setCollapsible(false);
  }
  
  public final Context b()
  {
    return this.c.getContext();
  }
  
  public final void b(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.b.a.a.b(this.c.getContext(), paramInt);; localDrawable = null)
    {
      b(localDrawable);
      return;
    }
  }
  
  public final void b(Drawable paramDrawable)
  {
    this.l = paramDrawable;
    u();
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    this.p = true;
    d(paramCharSequence);
  }
  
  public final void c(int paramInt)
  {
    int i1 = this.i ^ paramInt;
    this.i = paramInt;
    if (i1 != 0)
    {
      if ((i1 & 0x4) != 0) {
        break label134;
      }
      if ((i1 & 0x3) != 0) {
        break label127;
      }
    }
    for (;;)
    {
      if ((i1 & 0x8) == 0) {}
      for (;;)
      {
        View localView;
        if ((i1 & 0x10) != 0)
        {
          localView = this.f;
          if (localView != null)
          {
            if ((paramInt & 0x10) != 0) {
              break label67;
            }
            this.c.removeView(localView);
          }
        }
        return;
        label67:
        this.c.addView(localView);
        return;
        if ((paramInt & 0x8) != 0)
        {
          this.c.setTitle(this.b);
          this.c.setSubtitle(this.n);
        }
        else
        {
          this.c.setTitle(null);
          this.c.setSubtitle(null);
        }
      }
      label127:
      u();
    }
    label134:
    if ((paramInt & 0x4) == 0) {}
    for (;;)
    {
      v();
      break;
      w();
    }
  }
  
  public final void c(Drawable paramDrawable)
  {
    this.m = paramDrawable;
    v();
  }
  
  public final void c(CharSequence paramCharSequence)
  {
    this.n = paramCharSequence;
    if ((this.i & 0x8) != 0) {
      this.c.setSubtitle(paramCharSequence);
    }
  }
  
  public final boolean c()
  {
    return this.c.d();
  }
  
  public final void d()
  {
    this.c.e();
  }
  
  public final void d(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.b.a.a.b(this.c.getContext(), paramInt);; localDrawable = null)
    {
      c(localDrawable);
      return;
    }
  }
  
  public final void d(Drawable paramDrawable)
  {
    ac.a(this.c, paramDrawable);
  }
  
  public final CharSequence e()
  {
    return this.c.getTitle();
  }
  
  public final void e(int paramInt)
  {
    if (paramInt != 0) {}
    for (String str = this.c.getContext().getString(paramInt);; str = null)
    {
      this.j = str;
      w();
      return;
    }
  }
  
  public final void f()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public final void f(int paramInt)
  {
    this.c.setVisibility(paramInt);
  }
  
  public final void g()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public final boolean h()
  {
    Object localObject = this.c;
    if (((Toolbar)localObject).getVisibility() == 0)
    {
      localObject = ((Toolbar)localObject).k;
      if ((localObject != null) && (((ActionMenuView)localObject).e)) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean i()
  {
    return this.c.b();
  }
  
  public final boolean j()
  {
    Object localObject = this.c.k;
    if (localObject != null)
    {
      localObject = ((ActionMenuView)localObject).d;
      if ((localObject != null) && ((((j)localObject).n != null) || (((j)localObject).g()))) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean k()
  {
    return this.c.c();
  }
  
  public final boolean l()
  {
    Object localObject = this.c.k;
    if (localObject != null)
    {
      localObject = ((ActionMenuView)localObject).d;
      if ((localObject != null) && (((j)localObject).d())) {
        return true;
      }
    }
    return false;
  }
  
  public final void m()
  {
    this.a = true;
  }
  
  public final void n()
  {
    ActionMenuView localActionMenuView = this.c.k;
    if (localActionMenuView != null) {
      localActionMenuView.b();
    }
  }
  
  public final int o()
  {
    return this.i;
  }
  
  public final void p()
  {
    this.o = null;
  }
  
  public final void q() {}
  
  public final int r()
  {
    return 0;
  }
  
  public final int s()
  {
    return this.c.getHeight();
  }
  
  public final Menu t()
  {
    return this.c.getMenu();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/hn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */