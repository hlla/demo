package android.support.v7.widget;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.PopupWindow;

final class dz
  implements AbsListView.OnScrollListener
{
  dz(du paramdu) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 1) && (!this.a.j()) && (this.a.q.getContentView() != null))
    {
      paramAbsListView = this.a;
      paramAbsListView.k.removeCallbacks(paramAbsListView.r);
      this.a.r.run();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */