package android.support.v7.widget;

import android.support.v4.view.ac;
import android.view.View;
import android.widget.PopupWindow;

final class eb
  implements Runnable
{
  eb(du paramdu) {}
  
  public final void run()
  {
    Object localObject = this.a.h;
    if ((localObject != null) && (ac.L((View)localObject)) && (this.a.h.getCount() > this.a.h.getChildCount()))
    {
      int i = this.a.h.getChildCount();
      localObject = this.a;
      if (i <= ((du)localObject).m)
      {
        ((du)localObject).q.setInputMethodMode(2);
        this.a.b();
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */