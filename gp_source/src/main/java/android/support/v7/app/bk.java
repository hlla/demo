package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.support.v7.view.i;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.q;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.bj;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public final class bk
  extends b
  implements q
{
  private final Context c;
  private c d;
  private WeakReference e;
  private final p f;
  
  public bk(bg parambg, Context paramContext, c paramc)
  {
    this.c = paramContext;
    this.d = paramc;
    parambg = new p(paramContext);
    parambg.d = 1;
    this.f = parambg;
    this.f.a(this);
  }
  
  public final MenuInflater a()
  {
    return new i(this.c);
  }
  
  public final void a(int paramInt)
  {
    b(this.g.e.getResources().getString(paramInt));
  }
  
  public final void a(p paramp)
  {
    if (this.d != null)
    {
      d();
      this.g.f.a();
    }
  }
  
  public final void a(View paramView)
  {
    this.g.f.setCustomView(paramView);
    this.e = new WeakReference(paramView);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.g.f.setSubtitle(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.g.f.setTitleOptional(paramBoolean);
  }
  
  public final boolean a(p paramp, MenuItem paramMenuItem)
  {
    paramp = this.d;
    if (paramp == null) {
      return false;
    }
    return paramp.a(this, paramMenuItem);
  }
  
  public final Menu b()
  {
    return this.f;
  }
  
  public final void b(int paramInt)
  {
    a(this.g.e.getResources().getString(paramInt));
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    this.g.f.setTitle(paramCharSequence);
  }
  
  public final void c()
  {
    Object localObject = this.g;
    if (((bg)localObject).a == this)
    {
      if (bg.a(((bg)localObject).k, ((bg)localObject).l, false)) {
        break label120;
      }
      localObject = this.g;
      ((bg)localObject).i = this;
      ((bg)localObject).j = this.d;
    }
    for (;;)
    {
      this.d = null;
      this.g.f(false);
      localObject = this.g.f;
      if (((ActionBarContextView)localObject).f == null) {
        ((ActionBarContextView)localObject).b();
      }
      this.g.h.a().sendAccessibilityEvent(32);
      localObject = this.g;
      ((bg)localObject).n.setHideOnContentScrollEnabled(((bg)localObject).m);
      this.g.a = null;
      return;
      label120:
      this.d.a(this);
    }
  }
  
  public final void d()
  {
    if (this.g.a == this) {
      this.f.e();
    }
    try
    {
      this.d.b(this, this.f);
      return;
    }
    finally
    {
      this.f.f();
    }
  }
  
  public final boolean e()
  {
    this.f.e();
    try
    {
      boolean bool = this.d.a(this, this.f);
      return bool;
    }
    finally
    {
      this.f.f();
    }
  }
  
  public final CharSequence f()
  {
    return this.g.f.getTitle();
  }
  
  public final CharSequence g()
  {
    return this.g.f.getSubtitle();
  }
  
  public final boolean h()
  {
    return this.g.f.g;
  }
  
  public final View i()
  {
    WeakReference localWeakReference = this.e;
    if (localWeakReference != null) {
      return (View)localWeakReference.get();
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */