package android.support.design.appbar;

import android.support.v4.view.ac;
import android.view.View;

final class j
{
  public int a;
  public int b;
  public int c;
  public final View d;
  
  public j(View paramView)
  {
    this.d = paramView;
  }
  
  final void a()
  {
    View localView = this.d;
    ac.e(localView, this.c - (localView.getTop() - this.b));
    localView = this.d;
    ac.f(localView, -(localView.getLeft() - this.a));
  }
  
  public final boolean a(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      a();
      return true;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/appbar/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */