package android.support.v7.widget;

import android.view.View;

public abstract class ab
{
  protected final RecyclerView.h YQ;
  int YR = Integer.MIN_VALUE;
  
  public ab(RecyclerView.h paramh)
  {
    this.YQ = paramh;
  }
  
  public abstract int aV(View paramView);
  
  public abstract int aW(View paramView);
  
  public abstract int aX(View paramView);
  
  public abstract int aY(View paramView);
  
  public abstract void ba(int paramInt);
  
  public final int fi()
  {
    if (Integer.MIN_VALUE == this.YR) {
      return 0;
    }
    return fl() - this.YR;
  }
  
  public abstract int fj();
  
  public abstract int fk();
  
  public abstract int fl();
  
  public abstract int fm();
  
  public abstract int getEnd();
  
  public abstract int getEndPadding();
  
  public abstract int getMode();
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */