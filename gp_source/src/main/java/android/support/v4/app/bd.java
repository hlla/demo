package android.support.v4.app;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import java.util.ArrayList;

final class bd
  implements Transition.TransitionListener
{
  bd(ba paramba, Object paramObject1, ArrayList paramArrayList1, Object paramObject2, ArrayList paramArrayList2, Object paramObject3, ArrayList paramArrayList3) {}
  
  public final void onTransitionCancel(Transition paramTransition) {}
  
  public final void onTransitionEnd(Transition paramTransition) {}
  
  public final void onTransitionPause(Transition paramTransition) {}
  
  public final void onTransitionResume(Transition paramTransition) {}
  
  public final void onTransitionStart(Transition paramTransition)
  {
    paramTransition = this.b;
    if (paramTransition != null) {
      this.a.b(paramTransition, this.c, null);
    }
    paramTransition = this.d;
    if (paramTransition != null) {
      this.a.b(paramTransition, this.e, null);
    }
    paramTransition = this.f;
    if (paramTransition != null) {
      this.a.b(paramTransition, this.g, null);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */