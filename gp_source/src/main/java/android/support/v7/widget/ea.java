package android.support.v7.widget;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;

final class ea
  implements View.OnTouchListener
{
  ea(du paramdu) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (i == 0)
    {
      paramView = this.a.q;
      if (paramView != null) {}
    }
    else if (i == 1)
    {
      paramView = this.a;
      paramView.k.removeCallbacks(paramView.r);
    }
    for (;;)
    {
      return false;
      if ((!paramView.isShowing()) || (j < 0) || (j >= this.a.q.getWidth()) || (k < 0) || (k >= this.a.q.getHeight())) {
        break;
      }
      paramView = this.a;
      paramView.k.postDelayed(paramView.r, 250L);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */