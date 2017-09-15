package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class ad
{
  private static ThreadLocal<Rect> yi;
  
  static Rect bO()
  {
    if (yi == null) {
      yi = new ThreadLocal();
    }
    Rect localRect2 = (Rect)yi.get();
    Rect localRect1 = localRect2;
    if (localRect2 == null)
    {
      localRect1 = new Rect();
      yi.set(localRect1);
    }
    localRect1.setEmpty();
    return localRect1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */