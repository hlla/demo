package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public final class q
{
  private final View mView;
  private ViewParent xj;
  public boolean xk;
  private int[] xl;
  
  public q(View paramView)
  {
    this.mView = paramView;
  }
  
  public final boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((this.xk) && (this.xj != null)) {
      return ag.a(this.xj, this.mView, paramFloat1, paramFloat2, paramBoolean);
    }
    return false;
  }
  
  public final boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    if ((this.xk) && (this.xj != null)) {
      return ag.a(this.xj, this.mView, paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public final boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (this.xk)
    {
      bool1 = bool2;
      if (this.xj != null)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          break label171;
        }
        if (paramArrayOfInt2 == null) {
          break label192;
        }
        this.mView.getLocationInWindow(paramArrayOfInt2);
        j = paramArrayOfInt2[0];
        i = paramArrayOfInt2[1];
      }
    }
    for (;;)
    {
      int[] arrayOfInt = paramArrayOfInt1;
      if (paramArrayOfInt1 == null)
      {
        if (this.xl == null) {
          this.xl = new int[2];
        }
        arrayOfInt = this.xl;
      }
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
      ag.a(this.xj, this.mView, paramInt1, paramInt2, arrayOfInt);
      if (paramArrayOfInt2 != null)
      {
        this.mView.getLocationInWindow(paramArrayOfInt2);
        paramArrayOfInt2[0] -= j;
        paramArrayOfInt2[1] -= i;
      }
      if (arrayOfInt[0] == 0)
      {
        bool1 = bool2;
        if (arrayOfInt[1] == 0) {}
      }
      else
      {
        bool1 = true;
      }
      label171:
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramArrayOfInt2 == null);
      paramArrayOfInt2[0] = 0;
      paramArrayOfInt2[1] = 0;
      return false;
      label192:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (this.xk)
    {
      bool1 = bool2;
      if (this.xj != null)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0)) {
          break label126;
        }
        if (paramArrayOfInt == null) {
          break label147;
        }
        this.mView.getLocationInWindow(paramArrayOfInt);
        j = paramArrayOfInt[0];
        i = paramArrayOfInt[1];
      }
    }
    for (;;)
    {
      ag.a(this.xj, this.mView, paramInt1, paramInt2, paramInt3, paramInt4);
      if (paramArrayOfInt != null)
      {
        this.mView.getLocationInWindow(paramArrayOfInt);
        paramArrayOfInt[0] -= j;
        paramArrayOfInt[1] -= i;
      }
      bool1 = true;
      label126:
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramArrayOfInt == null);
      paramArrayOfInt[0] = 0;
      paramArrayOfInt[1] = 0;
      return false;
      label147:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean hasNestedScrollingParent()
  {
    return this.xj != null;
  }
  
  public final void setNestedScrollingEnabled(boolean paramBoolean)
  {
    if (this.xk) {
      z.ai(this.mView);
    }
    this.xk = paramBoolean;
  }
  
  public final boolean startNestedScroll(int paramInt)
  {
    if (hasNestedScrollingParent()) {
      return true;
    }
    if (this.xk)
    {
      ViewParent localViewParent = this.mView.getParent();
      View localView = this.mView;
      while (localViewParent != null)
      {
        if (ag.a(localViewParent, localView, this.mView, paramInt))
        {
          this.xj = localViewParent;
          ag.b(localViewParent, localView, this.mView, paramInt);
          return true;
        }
        if ((localViewParent instanceof View)) {
          localView = (View)localViewParent;
        }
        localViewParent = localViewParent.getParent();
      }
    }
    return false;
  }
  
  public final void stopNestedScroll()
  {
    if (this.xj != null)
    {
      ag.a(this.xj, this.mView);
      this.xj = null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */