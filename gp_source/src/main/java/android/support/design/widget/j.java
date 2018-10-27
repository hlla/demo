package android.support.design.widget;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

final class j
  implements ViewGroup.OnHierarchyChangeListener
{
  j(CoordinatorLayout paramCoordinatorLayout) {}
  
  public final void onChildViewAdded(View paramView1, View paramView2)
  {
    ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = this.a.d;
    if (localOnHierarchyChangeListener != null) {
      localOnHierarchyChangeListener.onChildViewAdded(paramView1, paramView2);
    }
  }
  
  public final void onChildViewRemoved(View paramView1, View paramView2)
  {
    this.a.a(2);
    ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = this.a.d;
    if (localOnHierarchyChangeListener != null) {
      localOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/widget/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */