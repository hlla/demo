package android.support.v7.widget;

import android.graphics.Rect;
import android.view.View;

final class ej
  extends eh
{
  ej(ff paramff)
  {
    super(paramff, (byte)0);
  }
  
  public final int a(View paramView)
  {
    fj localfj = (fj)paramView.getLayoutParams();
    return ff.i(paramView) - localfj.topMargin;
  }
  
  public final void a(int paramInt)
  {
    RecyclerView localRecyclerView = this.b.m;
    if (localRecyclerView != null)
    {
      int j = localRecyclerView.k.a();
      int i = 0;
      while (i < j)
      {
        localRecyclerView.k.b(i).offsetTopAndBottom(paramInt);
        i += 1;
      }
    }
  }
  
  public final int b()
  {
    return this.b.g();
  }
  
  public final int b(View paramView)
  {
    fj localfj = (fj)paramView.getLayoutParams();
    int i = ff.k(paramView);
    return localfj.bottomMargin + i;
  }
  
  public final int c()
  {
    ff localff = this.b;
    return localff.g - localff.h();
  }
  
  public final int c(View paramView)
  {
    this.b.b(paramView, this.c);
    return this.c.bottom;
  }
  
  public final int d()
  {
    return this.b.g;
  }
  
  public final int d(View paramView)
  {
    this.b.b(paramView, this.c);
    return this.c.top;
  }
  
  public final int e()
  {
    ff localff = this.b;
    return localff.g - localff.g() - this.b.h();
  }
  
  public final int e(View paramView)
  {
    fj localfj = (fj)paramView.getLayoutParams();
    int i = ff.g(paramView);
    int j = localfj.topMargin;
    return localfj.bottomMargin + (i + j);
  }
  
  public final int f()
  {
    return this.b.h();
  }
  
  public final int f(View paramView)
  {
    fj localfj = (fj)paramView.getLayoutParams();
    int i = ff.f(paramView);
    int j = localfj.leftMargin;
    return localfj.rightMargin + (i + j);
  }
  
  public final int g()
  {
    return this.b.h;
  }
  
  public final int h()
  {
    return this.b.q;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */