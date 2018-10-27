package android.support.v7.widget;

import android.support.v4.view.az;
import android.support.v4.view.bc;
import android.view.View;

public final class b
  implements bc
{
  public int a;
  private boolean b = false;
  
  protected b(a parama) {}
  
  public final b a(az paramaz, int paramInt)
  {
    this.c.e = paramaz;
    this.a = paramInt;
    return this;
  }
  
  public final void a()
  {
    a.a(this.c);
    this.b = false;
  }
  
  public final void a(View paramView)
  {
    if (!this.b)
    {
      paramView = this.c;
      paramView.e = null;
      a.a(paramView, this.a);
    }
  }
  
  public final void b()
  {
    this.b = true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */