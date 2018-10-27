package android.support.v7.app;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class n
  implements AbsListView.OnScrollListener
{
  n(View paramView1, View paramView2) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AlertController.a(paramAbsListView, this.b, this.a);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */