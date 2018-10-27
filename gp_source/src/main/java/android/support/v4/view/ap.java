package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.a;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

final class ap
  extends b
{
  ap(ViewPager paramViewPager) {}
  
  private final boolean a()
  {
    boolean bool = true;
    z localz = this.b.b;
    if ((localz == null) || (localz.a() <= 1)) {
      bool = false;
    }
    return bool;
  }
  
  public final void a(View paramView, a parama)
  {
    super.a(paramView, parama);
    parama.b(ViewPager.class.getName());
    parama.j(a());
    if (this.b.canScrollHorizontally(1)) {
      parama.a(4096);
    }
    if (this.b.canScrollHorizontally(-1)) {
      parama.a(8192);
    }
  }
  
  public final void a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    paramAccessibilityEvent.setScrollable(a());
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      paramView = this.b.b;
      if (paramView != null)
      {
        paramAccessibilityEvent.setItemCount(paramView.a());
        paramAccessibilityEvent.setFromIndex(this.b.d);
        paramAccessibilityEvent.setToIndex(this.b.d);
      }
    }
  }
  
  public final boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
    if (!super.a(paramView, paramInt, paramBundle)) {}
    switch (paramInt)
    {
    default: 
      bool = false;
      return bool;
    case 8192: 
      if (this.b.canScrollHorizontally(-1))
      {
        paramView = this.b;
        paramView.setCurrentItem(paramView.d - 1);
        return true;
      }
      return false;
    }
    if (this.b.canScrollHorizontally(1))
    {
      paramView = this.b;
      paramView.setCurrentItem(paramView.d + 1);
      return true;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */