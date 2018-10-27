package android.support.v7.widget;

import android.support.v4.view.ac;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

final class es
  implements bg
{
  es(RecyclerView paramRecyclerView) {}
  
  public final int a()
  {
    return this.a.getChildCount();
  }
  
  public final int a(View paramView)
  {
    return this.a.indexOfChild(paramView);
  }
  
  public final void a(int paramInt)
  {
    View localView = this.a.getChildAt(paramInt);
    if (localView != null)
    {
      this.a.h(localView);
      localView.clearAnimation();
    }
    this.a.removeViewAt(paramInt);
  }
  
  public final void a(View paramView, int paramInt)
  {
    this.a.addView(paramView, paramInt);
    RecyclerView localRecyclerView = this.a;
    RecyclerView.b(paramView);
    localRecyclerView.e(paramView);
    paramView = localRecyclerView.g;
  }
  
  public final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    fz localfz = RecyclerView.b(paramView);
    if (localfz != null)
    {
      if ((!localfz.m()) && (!localfz.b()))
      {
        paramView = new StringBuilder();
        paramView.append("Called attach on a child which is not detached: ");
        paramView.append(localfz);
        paramView.append(this.a.a());
        throw new IllegalArgumentException(paramView.toString());
      }
      localfz.i();
    }
    RecyclerView.a(this.a, paramView, paramInt, paramLayoutParams);
  }
  
  public final fz b(View paramView)
  {
    return RecyclerView.b(paramView);
  }
  
  public final View b(int paramInt)
  {
    return this.a.getChildAt(paramInt);
  }
  
  public final void b()
  {
    int j = this.a.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = b(i);
      this.a.h(localView);
      localView.clearAnimation();
      i += 1;
    }
    this.a.removeAllViews();
  }
  
  public final void c(int paramInt)
  {
    Object localObject = b(paramInt);
    if (localObject != null)
    {
      localObject = RecyclerView.b((View)localObject);
      if (localObject != null)
      {
        if ((((fz)localObject).m()) && (!((fz)localObject).b()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("called detach on an already detached child ");
          localStringBuilder.append(localObject);
          localStringBuilder.append(this.a.a());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        ((fz)localObject).c(256);
      }
    }
    RecyclerView.a(this.a, paramInt);
  }
  
  public final void c(View paramView)
  {
    paramView = RecyclerView.b(paramView);
    RecyclerView localRecyclerView;
    int i;
    if (paramView != null)
    {
      localRecyclerView = this.a;
      i = paramView.k;
      if (i == -1) {
        break label37;
      }
    }
    label37:
    for (paramView.q = i;; paramView.q = ac.f(paramView.c))
    {
      localRecyclerView.a(paramView, 4);
      return;
    }
  }
  
  public final void d(View paramView)
  {
    paramView = RecyclerView.b(paramView);
    if (paramView != null)
    {
      this.a.a(paramView, paramView.q);
      paramView.q = 0;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */