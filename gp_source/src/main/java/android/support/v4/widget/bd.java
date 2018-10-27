package android.support.v4.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public final class bd
{
  private static final ThreadLocal a = new ThreadLocal();
  private static final ThreadLocal b = new ThreadLocal();
  
  public static void a(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix = (Matrix)a.get();
    if (localMatrix == null)
    {
      localMatrix = new Matrix();
      a.set(localMatrix);
    }
    for (;;)
    {
      a(paramViewGroup, paramView, localMatrix);
      paramView = (RectF)b.get();
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = new RectF();
        b.set(paramViewGroup);
      }
      paramViewGroup.set(paramRect);
      localMatrix.mapRect(paramViewGroup);
      paramRect.set((int)(paramViewGroup.left + 0.5F), (int)(paramViewGroup.top + 0.5F), (int)(paramViewGroup.right + 0.5F), (int)(paramViewGroup.bottom + 0.5F));
      return;
      localMatrix.reset();
    }
  }
  
  private static void a(ViewParent paramViewParent, View paramView, Matrix paramMatrix)
  {
    Object localObject = paramView.getParent();
    if (!(localObject instanceof View)) {}
    for (;;)
    {
      paramMatrix.preTranslate(paramView.getLeft(), paramView.getTop());
      if (!paramView.getMatrix().isIdentity()) {
        paramMatrix.preConcat(paramView.getMatrix());
      }
      return;
      if (localObject != paramViewParent)
      {
        localObject = (View)localObject;
        a(paramViewParent, (View)localObject, paramMatrix);
        paramMatrix.preTranslate(-((View)localObject).getScrollX(), -((View)localObject).getScrollY());
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */