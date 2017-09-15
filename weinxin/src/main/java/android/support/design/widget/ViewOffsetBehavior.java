package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private z lG;
  private int lH = 0;
  private int lI = 0;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int I()
  {
    if (this.lG != null) {
      return this.lG.lL;
    }
    return 0;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    d(paramCoordinatorLayout, paramV, paramInt);
    if (this.lG == null) {
      this.lG = new z(paramV);
    }
    this.lG.ay();
    if (this.lH != 0)
    {
      this.lG.f(this.lH);
      this.lH = 0;
    }
    if (this.lI != 0)
    {
      paramCoordinatorLayout = this.lG;
      paramInt = this.lI;
      if (paramCoordinatorLayout.lM != paramInt)
      {
        paramCoordinatorLayout.lM = paramInt;
        paramCoordinatorLayout.az();
      }
      this.lI = 0;
    }
    return true;
  }
  
  protected void d(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    paramCoordinatorLayout.e(paramV, paramInt);
  }
  
  public boolean f(int paramInt)
  {
    if (this.lG != null) {
      return this.lG.f(paramInt);
    }
    this.lH = paramInt;
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/ViewOffsetBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */