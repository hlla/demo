package android.support.v7.widget;

import android.view.ViewPropertyAnimator;

final class f
  implements Runnable
{
  f(ActionBarOverlayLayout paramActionBarOverlayLayout) {}
  
  public final void run()
  {
    this.a.a();
    ActionBarOverlayLayout localActionBarOverlayLayout = this.a;
    localActionBarOverlayLayout.c = localActionBarOverlayLayout.a.animate().translationY(0.0F).setListener(this.a.e);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */