package android.support.design.snackbar;

import android.animation.ValueAnimator;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.design.behavior.SwipeDismissBehavior;
import android.support.design.widget.k;
import android.support.v4.view.ac;
import android.view.ViewGroup;

final class a
  implements Handler.Callback
{
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      paramMessage = (BaseTransientBottomBar)paramMessage.obj;
      if (paramMessage.i.getParent() == null)
      {
        localObject = paramMessage.i.getLayoutParams();
        if ((localObject instanceof k))
        {
          localObject = (k)localObject;
          SwipeDismissBehavior localSwipeDismissBehavior = paramMessage.f();
          if ((localSwipeDismissBehavior instanceof BaseTransientBottomBar.Behavior)) {
            ((BaseTransientBottomBar.Behavior)localSwipeDismissBehavior).g.a(paramMessage);
          }
          localSwipeDismissBehavior.d = new g(paramMessage);
          ((k)localObject).a(localSwipeDismissBehavior);
          ((k)localObject).d = 80;
        }
        paramMessage.h.addView(paramMessage.i);
      }
      paramMessage.i.a = new h(paramMessage);
      if (ac.I(paramMessage.i)) {
        if (paramMessage.j()) {
          paramMessage.g();
        }
      }
      for (;;)
      {
        return true;
        paramMessage.i();
        continue;
        paramMessage.i.b = new j(paramMessage);
      }
    }
    Object localObject = (BaseTransientBottomBar)paramMessage.obj;
    int i = paramMessage.arg1;
    if ((!((BaseTransientBottomBar)localObject).j()) || (((BaseTransientBottomBar)localObject).i.getVisibility() != 0)) {
      ((BaseTransientBottomBar)localObject).b(i);
    }
    for (;;)
    {
      return true;
      paramMessage = new ValueAnimator();
      paramMessage.setIntValues(new int[] { 0, ((BaseTransientBottomBar)localObject).h() });
      paramMessage.setInterpolator(android.support.design.a.a.c);
      paramMessage.setDuration(250L);
      paramMessage.addListener(new b((BaseTransientBottomBar)localObject, i));
      paramMessage.addUpdateListener(new c((BaseTransientBottomBar)localObject));
      paramMessage.start();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */