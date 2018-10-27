package android.support.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public final class y
{
  public Runnable a;
  public int b = -1;
  public ViewGroup c;
  
  public y(ViewGroup paramViewGroup)
  {
    this.c = paramViewGroup;
  }
  
  public static y a(View paramView)
  {
    return (y)paramView.getTag(2131429557);
  }
  
  public final void a()
  {
    if (this.b <= 0) {}
    for (;;)
    {
      Runnable localRunnable = this.a;
      if (localRunnable != null) {
        localRunnable.run();
      }
      this.c.setTag(2131429557, this);
      return;
      this.c.removeAllViews();
      if (this.b > 0) {
        LayoutInflater.from(null).inflate(this.b, this.c);
      } else {
        this.c.addView(null);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */