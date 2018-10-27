package android.support.v7.view;

import android.support.v4.view.bc;
import android.support.v4.view.bd;
import android.view.View;
import java.util.ArrayList;

final class m
  extends bd
{
  private int a = 0;
  private boolean b = false;
  
  m(l paraml) {}
  
  public final void a()
  {
    if (!this.b)
    {
      this.b = true;
      bc localbc = this.c.c;
      if (localbc != null) {
        localbc.a();
      }
    }
  }
  
  public final void a(View paramView)
  {
    int i = this.a + 1;
    this.a = i;
    if (i == this.c.a.size())
    {
      paramView = this.c.c;
      if (paramView != null) {
        paramView.a(null);
      }
      this.a = 0;
      this.b = false;
      this.c.b = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */