package android.support.design.behavior;

import android.support.v4.view.ac;
import android.support.v4.widget.az;
import android.view.View;

final class d
  implements Runnable
{
  private final boolean a;
  private final View c;
  
  d(SwipeDismissBehavior paramSwipeDismissBehavior, View paramView, boolean paramBoolean)
  {
    this.c = paramView;
    this.a = paramBoolean;
  }
  
  public final void run()
  {
    Object localObject = this.b.f;
    if ((localObject != null) && (((az)localObject).b())) {
      ac.a(this.c, this);
    }
    do
    {
      do
      {
        return;
      } while (!this.a);
      localObject = this.b.d;
    } while (localObject == null);
    ((c)localObject).a(this.c);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/behavior/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */