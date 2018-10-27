package android.support.v7.widget;

import android.view.View;

final class cv
  extends dc
{
  private int b;
  
  protected final int a(GridLayout paramGridLayout, View paramView, cx paramcx, int paramInt, boolean paramBoolean)
  {
    return Math.max(0, super.a(paramGridLayout, paramView, paramcx, paramInt, paramBoolean));
  }
  
  protected final int a(boolean paramBoolean)
  {
    return Math.max(super.a(paramBoolean), this.b);
  }
  
  protected final void a()
  {
    super.a();
    this.b = Integer.MIN_VALUE;
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.b = Math.max(this.b, paramInt1 + paramInt2);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */