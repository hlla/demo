package android.support.v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class ad
  implements View.OnApplyWindowInsetsListener
{
  ad(y paramy) {}
  
  public final WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    paramWindowInsets = bf.a(paramWindowInsets);
    return (WindowInsets)bf.a(this.a.a(paramView, paramWindowInsets));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */