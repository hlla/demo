package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ax;
import android.support.v7.b.a.a;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class AppCompatCheckBox
  extends CheckBox
  implements ax
{
  private final ad a = new ad(this);
  
  public AppCompatCheckBox(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968736);
  }
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(hc.a(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
  }
  
  public int getCompoundPaddingLeft()
  {
    int j = super.getCompoundPaddingLeft();
    ad localad = this.a;
    int i = j;
    if (localad != null) {
      i = localad.a(j);
    }
    return i;
  }
  
  public ColorStateList getSupportButtonTintList()
  {
    ad localad = this.a;
    if (localad != null) {
      return localad.a;
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportButtonTintMode()
  {
    ad localad = this.a;
    if (localad != null) {
      return localad.b;
    }
    return null;
  }
  
  public void setButtonDrawable(int paramInt)
  {
    setButtonDrawable(a.b(getContext(), paramInt));
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    super.setButtonDrawable(paramDrawable);
    paramDrawable = this.a;
    if (paramDrawable != null) {
      paramDrawable.a();
    }
  }
  
  public void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    ad localad = this.a;
    if (localad != null) {
      localad.a(paramColorStateList);
    }
  }
  
  public void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    ad localad = this.a;
    if (localad != null) {
      localad.a(paramMode);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/AppCompatCheckBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */