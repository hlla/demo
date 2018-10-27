package android.support.v7.widget;

import android.database.DataSetObserver;
import android.widget.PopupWindow;

final class dy
  extends DataSetObserver
{
  dy(du paramdu) {}
  
  public final void onChanged()
  {
    if (this.a.q.isShowing()) {
      this.a.b();
    }
  }
  
  public final void onInvalidated()
  {
    this.a.c();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */