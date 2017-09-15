package android.support.v4.view;

import android.view.WindowInsets;

final class aq
  extends ap
{
  final WindowInsets zI;
  
  aq(WindowInsets paramWindowInsets)
  {
    this.zI = paramWindowInsets;
  }
  
  public final ap ca()
  {
    return new aq(this.zI.consumeSystemWindowInsets());
  }
  
  public final ap d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new aq(this.zI.replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public final int getSystemWindowInsetBottom()
  {
    return this.zI.getSystemWindowInsetBottom();
  }
  
  public final int getSystemWindowInsetLeft()
  {
    return this.zI.getSystemWindowInsetLeft();
  }
  
  public final int getSystemWindowInsetRight()
  {
    return this.zI.getSystemWindowInsetRight();
  }
  
  public final int getSystemWindowInsetTop()
  {
    return this.zI.getSystemWindowInsetTop();
  }
  
  public final boolean isConsumed()
  {
    return this.zI.isConsumed();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */