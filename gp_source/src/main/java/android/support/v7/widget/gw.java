package android.support.v7.widget;

import android.view.View;

public abstract class gw
  extends ez
{
  public static final boolean DEBUG = false;
  public static final String TAG = "SimpleItemAnimator";
  public boolean mSupportsChangeAnimations = true;
  
  public abstract boolean animateAdd(fz paramfz);
  
  public boolean animateAppearance(fz paramfz, fc paramfc1, fc paramfc2)
  {
    if (paramfc1 != null)
    {
      int i = paramfc1.a;
      int j = paramfc2.a;
      if ((i != j) || (paramfc1.b != paramfc2.b)) {
        return animateMove(paramfz, i, paramfc1.b, j, paramfc2.b);
      }
    }
    return animateAdd(paramfz);
  }
  
  public abstract boolean animateChange(fz paramfz1, fz paramfz2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean animateChange(fz paramfz1, fz paramfz2, fc paramfc1, fc paramfc2)
  {
    int k = paramfc1.a;
    int m = paramfc1.b;
    int i;
    if (paramfz2.b()) {
      i = paramfc1.a;
    }
    for (int j = paramfc1.b;; j = paramfc2.b)
    {
      return animateChange(paramfz1, paramfz2, k, m, i, j);
      i = paramfc2.a;
    }
  }
  
  public boolean animateDisappearance(fz paramfz, fc paramfc1, fc paramfc2)
  {
    int k = paramfc1.a;
    int m = paramfc1.b;
    paramfc1 = paramfz.c;
    if (paramfc2 != null) {}
    for (int i = paramfc2.a;; i = paramfc1.getLeft())
    {
      if (paramfc2 != null) {}
      for (int j = paramfc2.b;; j = paramfc1.getTop())
      {
        if ((!paramfz.l()) && ((k != i) || (m != j)))
        {
          paramfc1.layout(i, j, paramfc1.getWidth() + i, paramfc1.getHeight() + j);
          return animateMove(paramfz, k, m, i, j);
        }
        return animateRemove(paramfz);
      }
    }
  }
  
  public abstract boolean animateMove(fz paramfz, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public boolean animatePersistence(fz paramfz, fc paramfc1, fc paramfc2)
  {
    int i = paramfc1.a;
    int j = paramfc2.a;
    if ((i != j) || (paramfc1.b != paramfc2.b)) {
      return animateMove(paramfz, i, paramfc1.b, j, paramfc2.b);
    }
    dispatchMoveFinished(paramfz);
    return false;
  }
  
  public abstract boolean animateRemove(fz paramfz);
  
  public boolean canReuseUpdatedViewHolder(fz paramfz)
  {
    return (!this.mSupportsChangeAnimations) || (paramfz.j());
  }
  
  public final void dispatchAddFinished(fz paramfz)
  {
    onAddFinished(paramfz);
    dispatchAnimationFinished(paramfz);
  }
  
  public final void dispatchAddStarting(fz paramfz)
  {
    onAddStarting(paramfz);
  }
  
  public final void dispatchChangeFinished(fz paramfz, boolean paramBoolean)
  {
    onChangeFinished(paramfz, paramBoolean);
    dispatchAnimationFinished(paramfz);
  }
  
  public final void dispatchChangeStarting(fz paramfz, boolean paramBoolean)
  {
    onChangeStarting(paramfz, paramBoolean);
  }
  
  public final void dispatchMoveFinished(fz paramfz)
  {
    onMoveFinished(paramfz);
    dispatchAnimationFinished(paramfz);
  }
  
  public final void dispatchMoveStarting(fz paramfz)
  {
    onMoveStarting(paramfz);
  }
  
  public final void dispatchRemoveFinished(fz paramfz)
  {
    onRemoveFinished(paramfz);
    dispatchAnimationFinished(paramfz);
  }
  
  public final void dispatchRemoveStarting(fz paramfz)
  {
    onRemoveStarting(paramfz);
  }
  
  public boolean getSupportsChangeAnimations()
  {
    return this.mSupportsChangeAnimations;
  }
  
  public void onAddFinished(fz paramfz) {}
  
  public void onAddStarting(fz paramfz) {}
  
  public void onChangeFinished(fz paramfz, boolean paramBoolean) {}
  
  public void onChangeStarting(fz paramfz, boolean paramBoolean) {}
  
  public void onMoveFinished(fz paramfz) {}
  
  public void onMoveStarting(fz paramfz) {}
  
  public void onRemoveFinished(fz paramfz) {}
  
  public void onRemoveStarting(fz paramfz) {}
  
  public void setSupportsChangeAnimations(boolean paramBoolean)
  {
    this.mSupportsChangeAnimations = paramBoolean;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/gw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */