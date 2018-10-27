package android.support.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ac;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

final class az
  extends ViewGroup
{
  public ay a;
  private ArrayList b = null;
  private ViewGroup c;
  private View d;
  
  static
  {
    try
    {
      ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { Integer.TYPE, Integer.TYPE, Rect.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  az(Context paramContext, ViewGroup paramViewGroup, View paramView, ay paramay)
  {
    super(paramContext);
    this.c = paramViewGroup;
    this.d = paramView;
    setRight(paramViewGroup.getWidth());
    setBottom(paramViewGroup.getHeight());
    paramViewGroup.addView(this);
    this.a = paramay;
  }
  
  public final void a(View paramView)
  {
    if ((paramView.getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if ((localViewGroup != this.c) && (localViewGroup.getParent() != null) && (ac.L(localViewGroup)))
      {
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        localViewGroup.getLocationOnScreen(arrayOfInt1);
        this.c.getLocationOnScreen(arrayOfInt2);
        ac.f(paramView, arrayOfInt1[0] - arrayOfInt2[0]);
        ac.e(paramView, arrayOfInt1[1] - arrayOfInt2[1]);
      }
      localViewGroup.removeView(paramView);
      if (paramView.getParent() != null) {
        localViewGroup.removeView(paramView);
      }
    }
    super.addView(paramView, getChildCount() - 1);
  }
  
  public final void b(View paramView)
  {
    super.removeView(paramView);
    if (getChildCount() == 0) {
      this.c.removeView(this);
    }
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    this.c.getLocationOnScreen(arrayOfInt1);
    this.d.getLocationOnScreen(arrayOfInt2);
    paramCanvas.translate(arrayOfInt2[0] - arrayOfInt1[0], arrayOfInt2[1] - arrayOfInt1[1]);
    paramCanvas.clipRect(new Rect(0, 0, this.d.getWidth(), this.d.getHeight()));
    super.dispatchDraw(paramCanvas);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    if (this.c != null)
    {
      paramRect.offset(paramArrayOfInt[0], paramArrayOfInt[1]);
      ViewGroup localViewGroup = this.c;
      if ((localViewGroup instanceof ViewGroup))
      {
        paramArrayOfInt[0] = 0;
        paramArrayOfInt[1] = 0;
        int[] arrayOfInt1 = new int[2];
        int[] arrayOfInt2 = new int[2];
        int[] arrayOfInt3 = new int[2];
        localViewGroup.getLocationOnScreen(arrayOfInt2);
        this.d.getLocationOnScreen(arrayOfInt3);
        arrayOfInt3[0] -= arrayOfInt2[0];
        arrayOfInt3[1] -= arrayOfInt2[1];
        paramRect.offset(arrayOfInt1[0], arrayOfInt1[1]);
        return super.invalidateChildInParent(paramArrayOfInt, paramRect);
      }
      invalidate(paramRect);
    }
    return null;
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate(paramDrawable.getBounds());
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected final boolean verifyDrawable(Drawable paramDrawable)
  {
    return super.verifyDrawable(paramDrawable);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */