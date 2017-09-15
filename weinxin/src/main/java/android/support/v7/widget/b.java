package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class b
  extends Drawable
{
  final ActionBarContainer RH;
  
  public b(ActionBarContainer paramActionBarContainer)
  {
    this.RH = paramActionBarContainer;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.RH.RO) {
      if (this.RH.RN != null) {
        this.RH.RN.draw(paramCanvas);
      }
    }
    do
    {
      return;
      if (this.RH.Qd != null) {
        this.RH.Qd.draw(paramCanvas);
      }
    } while ((this.RH.RM == null) || (!this.RH.RP));
    this.RH.RM.draw(paramCanvas);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */