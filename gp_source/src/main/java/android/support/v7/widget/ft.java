package android.support.v7.widget;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;

public abstract class ft
{
  public ff a;
  public boolean b;
  public RecyclerView c;
  public boolean d;
  public boolean e;
  public int f = -1;
  public View g;
  private final fu h = new fu();
  
  public PointF a(int paramInt)
  {
    Object localObject = this.a;
    if ((localObject instanceof fv)) {
      return ((fv)localObject).b(paramInt);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
    ((StringBuilder)localObject).append(fv.class.getCanonicalName());
    Log.w("RecyclerView", ((StringBuilder)localObject).toString());
    return null;
  }
  
  public abstract void a();
  
  final void a(int paramInt1, int paramInt2)
  {
    RecyclerView localRecyclerView = this.c;
    if ((!this.d) || (this.f == -1)) {}
    for (;;)
    {
      d();
      label182:
      do
      {
        if ((this.b) && (this.g == null) && (this.a != null))
        {
          localObject = a(this.f);
          if ((localObject != null) && ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F))) {
            localRecyclerView.a((int)Math.signum(((PointF)localObject).x), (int)Math.signum(((PointF)localObject).y), null);
          }
        }
        this.b = false;
        Object localObject = this.g;
        if (localObject == null) {}
        for (;;)
        {
          if (this.d)
          {
            a(paramInt1, paramInt2, localRecyclerView.G, this.h);
            localObject = this.h;
            paramInt1 = ((fu)localObject).f;
            ((fu)localObject).a(localRecyclerView);
            if (paramInt1 >= 0)
            {
              if (!this.d) {
                break label182;
              }
              this.b = true;
              localRecyclerView.L.a();
            }
          }
          return;
          d();
          return;
          if (RecyclerView.d((View)localObject) == this.f)
          {
            a(this.g, localRecyclerView.G, this.h);
            this.h.a(localRecyclerView);
            d();
          }
          else
          {
            Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
            this.g = null;
          }
        }
      } while (localRecyclerView != null);
    }
  }
  
  public abstract void a(int paramInt1, int paramInt2, fw paramfw, fu paramfu);
  
  public abstract void a(View paramView, fw paramfw, fu paramfu);
  
  public abstract void b();
  
  public final void d()
  {
    if (this.d)
    {
      this.d = false;
      b();
      this.c.G.m = -1;
      this.g = null;
      this.f = -1;
      this.b = false;
      ff localff = this.a;
      if (localff.n == this) {
        localff.n = null;
      }
      this.a = null;
      this.c = null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */