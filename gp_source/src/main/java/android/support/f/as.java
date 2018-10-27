package android.support.f;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

final class as
  implements at
{
  private final ViewGroupOverlay a;
  
  as(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup.getOverlay();
  }
  
  public final void a(View paramView)
  {
    this.a.add(paramView);
  }
  
  public final void b(View paramView)
  {
    this.a.remove(paramView);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */