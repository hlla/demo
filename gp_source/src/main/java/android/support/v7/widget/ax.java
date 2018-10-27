package android.support.v7.widget;

import android.support.v4.view.ac;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class ax
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ax(av paramav) {}
  
  public final void onGlobalLayout()
  {
    av localav = this.a;
    AppCompatSpinner localAppCompatSpinner = localav.d;
    if ((ac.L(localAppCompatSpinner)) && (localAppCompatSpinner.getGlobalVisibleRect(localav.c)))
    {
      this.a.a();
      av.a(this.a);
      return;
    }
    this.a.c();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */