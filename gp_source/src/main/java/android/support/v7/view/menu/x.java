package android.support.v7.view.menu;

import android.support.v7.view.d;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

final class x
  extends FrameLayout
  implements d
{
  public final CollapsibleActionView a;
  
  x(View paramView)
  {
    super(paramView.getContext());
    this.a = ((CollapsibleActionView)paramView);
    addView(paramView);
  }
  
  public final void onActionViewCollapsed()
  {
    this.a.onActionViewCollapsed();
  }
  
  public final void onActionViewExpanded()
  {
    this.a.onActionViewExpanded();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */