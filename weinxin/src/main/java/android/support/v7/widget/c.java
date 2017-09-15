package android.support.v7.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;

final class c
  extends b
{
  public c(ActionBarContainer paramActionBarContainer)
  {
    super(paramActionBarContainer);
  }
  
  public final void getOutline(Outline paramOutline)
  {
    if (this.RH.RO) {
      if (this.RH.RN != null) {
        this.RH.RN.getOutline(paramOutline);
      }
    }
    while (this.RH.Qd == null) {
      return;
    }
    this.RH.Qd.getOutline(paramOutline);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */