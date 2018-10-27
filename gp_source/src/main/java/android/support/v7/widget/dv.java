package android.support.v7.widget;

import android.view.View;

final class dv
  implements Runnable
{
  dv(du paramdu) {}
  
  public final void run()
  {
    View localView = this.a.e;
    if ((localView != null) && (localView.getWindowToken() != null)) {
      this.a.b();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */