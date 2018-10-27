package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.q;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class f
  extends b
  implements q
{
  private c c;
  private Context d;
  private ActionBarContextView e;
  private WeakReference f;
  private boolean g;
  private p h;
  
  public f(Context paramContext, ActionBarContextView paramActionBarContextView, c paramc)
  {
    this.d = paramContext;
    this.e = paramActionBarContextView;
    this.c = paramc;
    paramContext = new p(paramActionBarContextView.getContext());
    paramContext.d = 1;
    this.h = paramContext;
    this.h.a(this);
  }
  
  public final MenuInflater a()
  {
    return new i(this.e.getContext());
  }
  
  public final void a(int paramInt)
  {
    b(this.d.getString(paramInt));
  }
  
  public final void a(p paramp)
  {
    d();
    this.e.a();
  }
  
  public final void a(View paramView)
  {
    this.e.setCustomView(paramView);
    if (paramView != null) {}
    for (paramView = new WeakReference(paramView);; paramView = null)
    {
      this.f = paramView;
      return;
    }
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.e.setSubtitle(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.e.setTitleOptional(paramBoolean);
  }
  
  public final boolean a(p paramp, MenuItem paramMenuItem)
  {
    return this.c.a(this, paramMenuItem);
  }
  
  public final Menu b()
  {
    return this.h;
  }
  
  public final void b(int paramInt)
  {
    a(this.d.getString(paramInt));
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    this.e.setTitle(paramCharSequence);
  }
  
  public final void c()
  {
    if (!this.g)
    {
      this.g = true;
      this.e.sendAccessibilityEvent(32);
      this.c.a(this);
    }
  }
  
  public final void d()
  {
    this.c.b(this, this.h);
  }
  
  public final CharSequence f()
  {
    return this.e.getTitle();
  }
  
  public final CharSequence g()
  {
    return this.e.getSubtitle();
  }
  
  public final boolean h()
  {
    return this.e.g;
  }
  
  public final View i()
  {
    WeakReference localWeakReference = this.f;
    if (localWeakReference != null) {
      return (View)localWeakReference.get();
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */