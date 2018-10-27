package android.support.design.bottomsheet;

import android.support.v4.view.ac;
import android.support.v4.widget.az;
import android.support.v4.widget.bc;
import android.view.View;
import java.lang.ref.WeakReference;

final class a
  extends bc
{
  a(BottomSheetBehavior paramBottomSheetBehavior) {}
  
  public final int a()
  {
    BottomSheetBehavior localBottomSheetBehavior = this.a;
    if (localBottomSheetBehavior.f) {
      return localBottomSheetBehavior.h;
    }
    return localBottomSheetBehavior.b;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == 1) {
      this.a.b(1);
    }
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    int j = 3;
    BottomSheetBehavior localBottomSheetBehavior;
    label29:
    int i;
    if (paramFloat2 >= 0.0F)
    {
      localBottomSheetBehavior = this.a;
      if (!localBottomSheetBehavior.f) {
        if (paramFloat2 == 0.0F)
        {
          i = paramView.getTop();
          localBottomSheetBehavior = this.a;
          if (localBottomSheetBehavior.c) {
            if (Math.abs(i - localBottomSheetBehavior.d) < Math.abs(i - this.a.b)) {
              i = this.a.d;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (this.a.k.a(paramView.getLeft(), i))
      {
        this.a.b(2);
        ac.a(paramView, new c(this.a, paramView, j));
        return;
      }
      this.a.b(j);
      return;
      i = this.a.b;
      j = 4;
      continue;
      int k = localBottomSheetBehavior.e;
      if (i < k)
      {
        if (i >= Math.abs(i - localBottomSheetBehavior.b))
        {
          i = this.a.e;
          j = 6;
        }
        else
        {
          i = 0;
        }
      }
      else if (Math.abs(i - k) < Math.abs(i - this.a.b))
      {
        i = this.a.e;
        j = 6;
      }
      else
      {
        i = this.a.b;
        j = 4;
        continue;
        if (Math.abs(paramFloat1) > Math.abs(paramFloat2)) {
          break label29;
        }
        i = this.a.b;
        j = 4;
        continue;
        if ((!localBottomSheetBehavior.a(paramView, paramFloat2)) || ((paramView.getTop() <= this.a.b) && (Math.abs(paramFloat1) >= Math.abs(paramFloat2)))) {
          break;
        }
        i = this.a.h;
        j = 5;
        continue;
        localBottomSheetBehavior = this.a;
        if (localBottomSheetBehavior.c)
        {
          i = localBottomSheetBehavior.d;
        }
        else
        {
          k = paramView.getTop();
          i = this.a.e;
          if (k > i) {
            j = 6;
          } else {
            i = 0;
          }
        }
      }
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2)
  {
    this.a.b();
  }
  
  public final boolean a(View paramView, int paramInt)
  {
    Object localObject = this.a;
    int i = ((BottomSheetBehavior)localObject).i;
    if (i != 1)
    {
      if (!((BottomSheetBehavior)localObject).j)
      {
        if (i != 3) {}
        do
        {
          do
          {
            localObject = this.a.l;
            return (localObject != null) && (((WeakReference)localObject).get() == paramView);
          } while (((BottomSheetBehavior)localObject).a != paramInt);
          localObject = (View)((BottomSheetBehavior)localObject).g.get();
        } while ((localObject == null) || (!((View)localObject).canScrollVertically(-1)));
        return false;
      }
      return false;
    }
    return false;
  }
  
  public final int c(View paramView, int paramInt)
  {
    return paramView.getLeft();
  }
  
  public final int d(View paramView, int paramInt)
  {
    int j = this.a.a();
    paramView = this.a;
    if (!paramView.f) {}
    for (int i = paramView.b;; i = paramView.h) {
      return android.support.v4.d.a.a(paramInt, j, i);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/bottomsheet/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */