package android.support.v7.app;

import android.content.Context;
import android.support.v7.b.a.a;
import android.support.v7.widget.ContentFrameLayout;
import android.view.KeyEvent;
import android.view.MotionEvent;

final class aq
  extends ContentFrameLayout
{
  public aq(aa paramaa, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (this.b.a(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if (i < -5) {}
      while ((j < -5) || (i > getWidth() + 5) || (j > getHeight() + 5))
      {
        paramMotionEvent = this.b;
        paramMotionEvent.a(paramMotionEvent.d(0), true);
        return true;
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public final void setBackgroundResource(int paramInt)
  {
    setBackgroundDrawable(a.b(getContext(), paramInt));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */