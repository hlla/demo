package android.support.f;

import android.graphics.Matrix;
import android.view.View;

class bg
{
  public float a(View paramView)
  {
    Float localFloat = (Float)paramView.getTag(2131429121);
    if (localFloat != null) {
      return paramView.getAlpha() / localFloat.floatValue();
    }
    return paramView.getAlpha();
  }
  
  public void a(View paramView, float paramFloat)
  {
    Float localFloat = (Float)paramView.getTag(2131429121);
    if (localFloat != null)
    {
      paramView.setAlpha(localFloat.floatValue() * paramFloat);
      return;
    }
    paramView.setAlpha(paramFloat);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setLeft(paramInt1);
    paramView.setTop(paramInt2);
    paramView.setRight(paramInt3);
    paramView.setBottom(paramInt4);
  }
  
  public void a(View paramView, Matrix paramMatrix)
  {
    Object localObject = paramView.getParent();
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      a((View)localObject, paramMatrix);
      paramMatrix.preTranslate(-((View)localObject).getScrollX(), -((View)localObject).getScrollY());
    }
    paramMatrix.preTranslate(paramView.getLeft(), paramView.getTop());
    paramView = paramView.getMatrix();
    if (!paramView.isIdentity()) {
      paramMatrix.preConcat(paramView);
    }
  }
  
  public void b(View paramView)
  {
    if (paramView.getTag(2131429121) == null) {
      paramView.setTag(2131429121, Float.valueOf(paramView.getAlpha()));
    }
  }
  
  public void b(View paramView, Matrix paramMatrix)
  {
    Object localObject = paramView.getParent();
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      b((View)localObject, paramMatrix);
      paramMatrix.postTranslate(((View)localObject).getScrollX(), ((View)localObject).getScrollY());
    }
    paramMatrix.postTranslate(paramView.getLeft(), paramView.getTop());
    paramView = paramView.getMatrix();
    if (!paramView.isIdentity())
    {
      localObject = new Matrix();
      if (paramView.invert((Matrix)localObject)) {
        paramMatrix.postConcat((Matrix)localObject);
      }
    }
  }
  
  public void c(View paramView)
  {
    if (paramView.getVisibility() == 0) {
      paramView.setTag(2131429121, null);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */