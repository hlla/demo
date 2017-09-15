package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class e
  extends b
  implements f.a
{
  private b.a IE;
  private WeakReference<View> IF;
  private ActionBarContextView Ig;
  private boolean OE;
  private f dW;
  private Context mContext;
  private boolean mFinished;
  
  public e(Context paramContext, ActionBarContextView paramActionBarContextView, b.a parama, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.Ig = paramActionBarContextView;
    this.IE = parama;
    paramContext = new f(paramActionBarContextView.getContext());
    paramContext.Qx = 1;
    this.dW = paramContext;
    this.dW.a(this);
    this.OE = paramBoolean;
  }
  
  public final boolean a(f paramf, MenuItem paramMenuItem)
  {
    return this.IE.a(this, paramMenuItem);
  }
  
  public final void b(f paramf)
  {
    invalidate();
    this.Ig.showOverflowMenu();
  }
  
  public final void finish()
  {
    if (this.mFinished) {
      return;
    }
    this.mFinished = true;
    this.Ig.sendAccessibilityEvent(32);
    this.IE.a(this);
  }
  
  public final View getCustomView()
  {
    if (this.IF != null) {
      return (View)this.IF.get();
    }
    return null;
  }
  
  public final Menu getMenu()
  {
    return this.dW;
  }
  
  public final MenuInflater getMenuInflater()
  {
    return new g(this.Ig.getContext());
  }
  
  public final CharSequence getSubtitle()
  {
    return this.Ig.uJ;
  }
  
  public final CharSequence getTitle()
  {
    return this.Ig.uI;
  }
  
  public final void invalidate()
  {
    this.IE.b(this, this.dW);
  }
  
  public final boolean isTitleOptional()
  {
    return this.Ig.RW;
  }
  
  public final void setCustomView(View paramView)
  {
    this.Ig.setCustomView(paramView);
    if (paramView != null) {}
    for (paramView = new WeakReference(paramView);; paramView = null)
    {
      this.IF = paramView;
      return;
    }
  }
  
  public final void setSubtitle(int paramInt)
  {
    setSubtitle(this.mContext.getString(paramInt));
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.Ig.setSubtitle(paramCharSequence);
  }
  
  public final void setTitle(int paramInt)
  {
    setTitle(this.mContext.getString(paramInt));
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.Ig.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    this.Ig.K(paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */