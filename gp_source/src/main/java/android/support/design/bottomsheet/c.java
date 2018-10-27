package android.support.design.bottomsheet;

import android.support.v4.view.ac;
import android.support.v4.widget.az;
import android.view.View;

final class c
  implements Runnable
{
  private final int a;
  private final View c;
  
  c(BottomSheetBehavior paramBottomSheetBehavior, View paramView, int paramInt)
  {
    this.c = paramView;
    this.a = paramInt;
  }
  
  public final void run()
  {
    az localaz = this.b.k;
    if ((localaz != null) && (localaz.b()))
    {
      ac.a(this.c, this);
      return;
    }
    this.b.b(this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/bottomsheet/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */