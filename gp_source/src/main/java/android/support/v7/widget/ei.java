package android.support.v7.widget;

import android.graphics.Rect;
import android.view.View;

final class ei
  extends eh
{
  ei(ff paramff)
  {
    super(paramff, (byte)0);
  }
  
  public final int a(View paramView)
  {
    fj localfj = (fj)paramView.getLayoutParams();
    return ff.h(paramView) - localfj.leftMargin;
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
        localRecyclerView.k.b(i).offsetLeftAndRight(paramInt);
        i += 1;
      }
    }
  }
  
  public final int b()
  {
    return this.b.i();
  }
  
  public final int b(View paramView)
  {
    fj localfj = (fj)paramView.getLayoutParams();
    int i = ff.j(paramView);
    return localfj.rightMargin + i;
  }
  
  public final int c()
  {
    ff localff = this.b;
    return localff.p - localff.j();
  }
  
  public final int c(View paramView)
  {
    this.b.b(paramView, this.c);
    return this.c.right;
  }
  
  public final int d()
  {
    return this.b.p;
  }
  
  public final int d(View paramView)
  {
    this.b.b(paramView, this.c);
    return this.c.left;
  }
  
  public final int e()
  {
    ff localff = this.b;
    return localff.p - localff.i() - this.b.j();
  }
  
  public final int e(View paramView)
  {
    fj localfj = (fj)paramView.getLayoutParams();
    int i = ff.f(paramView);
    int j = localfj.leftMargin;
    return localfj.rightMargin + (i + j);
  }
  
  public final int f()
  {
    return this.b.j();
  }
  
  public final int f(View paramView)
  {
    fj localfj = (fj)paramView.getLayoutParams();
    int i = ff.g(paramView);
    int j = localfj.topMargin;
    return localfj.bottomMargin + (i + j);
  }
  
  public final int g()
  {
    return this.b.q;
  }
  
  public final int h()
  {
    return this.b.h;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */