package android.support.v7.app;

import android.support.v4.view.ac;
import android.support.v4.view.az;
import android.support.v7.widget.ActionBarContextView;
import android.widget.PopupWindow;

final class ag
  implements Runnable
{
  ag(aa paramaa) {}
  
  public final void run()
  {
    aa localaa = this.a;
    localaa.c.showAtLocation(localaa.d, 55, 0, 0);
    this.a.o();
    if (this.a.n())
    {
      this.a.d.setAlpha(0.0F);
      localaa = this.a;
      localaa.h = ac.t(localaa.d).a(1.0F);
      this.a.h.a(new ah(this));
      return;
    }
    this.a.d.setAlpha(1.0F);
    this.a.d.setVisibility(0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */