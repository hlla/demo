package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class be
  extends Transition.EpicenterCallback
{
  be(Rect paramRect) {}
  
  public final Rect onGetEpicenter(Transition paramTransition)
  {
    paramTransition = this.a;
    if ((paramTransition != null) && (!paramTransition.isEmpty())) {
      return this.a;
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */