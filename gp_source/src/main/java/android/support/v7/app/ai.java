package android.support.v7.app;

import android.support.v4.view.ac;
import android.support.v4.view.az;
import android.support.v4.view.bd;
import android.support.v7.widget.ActionBarContextView;
import android.view.View;

final class ai
  extends bd
{
  ai(aa paramaa) {}
  
  public final void a()
  {
    this.a.d.setVisibility(0);
    this.a.d.sendAccessibilityEvent(32);
    if ((this.a.d.getParent() instanceof View)) {
      ac.x((View)this.a.d.getParent());
    }
  }
  
  public final void a(View paramView)
  {
    this.a.d.setAlpha(1.0F);
    this.a.h.a(null);
    this.a.h = null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */