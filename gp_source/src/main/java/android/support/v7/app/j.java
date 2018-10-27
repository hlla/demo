package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

final class j
{
  public Method a;
  public Method b;
  public ImageView c;
  
  j(Activity paramActivity)
  {
    try
    {
      this.b = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[] { Drawable.class });
      this.a = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[] { Integer.TYPE });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      do
      {
        do
        {
          do
          {
            paramActivity = paramActivity.findViewById(16908332);
          } while (paramActivity == null);
          paramActivity = (ViewGroup)paramActivity.getParent();
        } while (paramActivity.getChildCount() != 2);
        View localView = paramActivity.getChildAt(0);
        paramActivity = paramActivity.getChildAt(1);
        if (localView.getId() != 16908332) {
          paramActivity = localView;
        }
      } while (!(paramActivity instanceof ImageView));
      this.c = ((ImageView)paramActivity);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */