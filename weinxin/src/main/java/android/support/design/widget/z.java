package android.support.design.widget;

import android.view.View;

final class z
{
  private int lJ;
  private int lK;
  int lL;
  int lM;
  private final View mView;
  
  public z(View paramView)
  {
    this.mView = paramView;
  }
  
  public final void ay()
  {
    this.lJ = this.mView.getTop();
    this.lK = this.mView.getLeft();
    az();
  }
  
  final void az()
  {
    android.support.v4.view.z.j(this.mView, this.lL - (this.mView.getTop() - this.lJ));
    android.support.v4.view.z.k(this.mView, this.lM - (this.mView.getLeft() - this.lK));
  }
  
  public final boolean f(int paramInt)
  {
    if (this.lL != paramInt)
    {
      this.lL = paramInt;
      az();
      return true;
    }
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */