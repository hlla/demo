package android.support.v7.widget;

import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.q;
import android.view.View;

final class m
  implements Runnable
{
  private p a;
  
  public m(j paramj, p paramp)
  {
    this.a = paramp;
  }
  
  public final void run()
  {
    Object localObject = this.b.c;
    if (localObject == null) {}
    for (;;)
    {
      localObject = (View)this.b.d;
      if ((localObject != null) && (((View)localObject).getWindowToken() != null) && (this.a.c())) {
        this.b.j = this.a;
      }
      this.b.n = null;
      return;
      q localq = ((android.support.v7.view.menu.p)localObject).b;
      if (localq != null) {
        localq.a((android.support.v7.view.menu.p)localObject);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */