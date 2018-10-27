package android.support.v4.app;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import android.view.View;
import java.util.ArrayList;

final class bc
  implements Transition.TransitionListener
{
  bc(View paramView, ArrayList paramArrayList) {}
  
  public final void onTransitionCancel(Transition paramTransition) {}
  
  public final void onTransitionEnd(Transition paramTransition)
  {
    paramTransition.removeListener(this);
    this.b.setVisibility(8);
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((View)this.a.get(i)).setVisibility(0);
      i += 1;
    }
  }
  
  public final void onTransitionPause(Transition paramTransition) {}
  
  public final void onTransitionResume(Transition paramTransition) {}
  
  public final void onTransitionStart(Transition paramTransition) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */