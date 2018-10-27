package android.support.v7.view;

import android.content.Context;
import android.support.v4.c.a.a;
import android.support.v7.view.menu.aj;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public final class g
  extends ActionMode
{
  public final b a;
  private final Context b;
  
  public g(Context paramContext, b paramb)
  {
    this.b = paramContext;
    this.a = paramb;
  }
  
  public final void finish()
  {
    this.a.c();
  }
  
  public final View getCustomView()
  {
    return this.a.i();
  }
  
  public final Menu getMenu()
  {
    return aj.a(this.b, (a)this.a.b());
  }
  
  public final MenuInflater getMenuInflater()
  {
    return this.a.a();
  }
  
  public final CharSequence getSubtitle()
  {
    return this.a.g();
  }
  
  public final Object getTag()
  {
    return this.a.a;
  }
  
  public final CharSequence getTitle()
  {
    return this.a.f();
  }
  
  public final boolean getTitleOptionalHint()
  {
    return this.a.b;
  }
  
  public final void invalidate()
  {
    this.a.d();
  }
  
  public final boolean isTitleOptional()
  {
    return this.a.h();
  }
  
  public final void setCustomView(View paramView)
  {
    this.a.a(paramView);
  }
  
  public final void setSubtitle(int paramInt)
  {
    this.a.b(paramInt);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.a.a(paramCharSequence);
  }
  
  public final void setTag(Object paramObject)
  {
    this.a.a = paramObject;
  }
  
  public final void setTitle(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.a.b(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */