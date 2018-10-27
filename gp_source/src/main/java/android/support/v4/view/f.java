package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public final class f
{
  public final g a;
  
  public f(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, (byte)0);
  }
  
  public f(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, byte paramByte)
  {
    if (Build.VERSION.SDK_INT > 17)
    {
      this.a = new j(paramContext, paramOnGestureListener);
      return;
    }
    this.a = new h(paramContext, paramOnGestureListener);
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    return this.a.a(paramMotionEvent);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */