package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.g.a;
import android.view.View;

final class ax
  implements Runnable
{
  ax(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, a parama, View paramView, Rect paramRect) {}
  
  public final void run()
  {
    au.a(this.c, this.f, this.d, this.e, false);
    View localView = this.b;
    if (localView != null) {
      bf.a(localView, this.a);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */