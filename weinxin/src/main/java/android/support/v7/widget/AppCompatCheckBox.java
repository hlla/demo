package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a;
import android.support.v4.widget.t;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class AppCompatCheckBox
  extends CheckBox
  implements t
{
  private h Um = h.ey();
  private g Us = new g(this, this.Um);
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.checkboxStyle);
  }
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(am.p(paramContext), paramAttributeSet, paramInt);
    this.Us.a(paramAttributeSet, paramInt);
  }
  
  public final void b(PorterDuff.Mode paramMode)
  {
    if (this.Us != null) {
      this.Us.b(paramMode);
    }
  }
  
  public final void e(ColorStateList paramColorStateList)
  {
    if (this.Us != null) {
      this.Us.e(paramColorStateList);
    }
  }
  
  public int getCompoundPaddingLeft()
  {
    int j = super.getCompoundPaddingLeft();
    int i = j;
    if (this.Us != null) {
      i = this.Us.aL(j);
    }
    return i;
  }
  
  public void setButtonDrawable(int paramInt)
  {
    if (this.Um != null) {}
    for (Drawable localDrawable = this.Um.a(getContext(), paramInt, false);; localDrawable = a.a(getContext(), paramInt))
    {
      setButtonDrawable(localDrawable);
      return;
    }
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    super.setButtonDrawable(paramDrawable);
    if (this.Us != null) {
      this.Us.ew();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/AppCompatCheckBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */