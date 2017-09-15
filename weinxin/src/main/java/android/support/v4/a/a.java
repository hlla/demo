package android.support.v4.a;

import android.os.Build.VERSION;
import android.view.View;

public final class a
{
  private static final c nu = new e();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      nu = new f();
      return;
    }
  }
  
  public static g aB()
  {
    return nu.aB();
  }
  
  public static void v(View paramView)
  {
    nu.v(paramView);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */