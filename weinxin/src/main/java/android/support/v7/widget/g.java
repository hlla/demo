package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.b.a.a;
import android.support.v4.widget.c;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.widget.CompoundButton;

final class g
{
  private final h Um;
  private final CompoundButton Ut;
  private ColorStateList Uu = null;
  private PorterDuff.Mode Uv = null;
  private boolean Uw = false;
  private boolean Ux = false;
  private boolean Uy;
  
  g(CompoundButton paramCompoundButton, h paramh)
  {
    this.Ut = paramCompoundButton;
    this.Um = paramh;
  }
  
  private void ex()
  {
    Drawable localDrawable = c.a(this.Ut);
    if ((localDrawable != null) && ((this.Uw) || (this.Ux)))
    {
      localDrawable = a.g(localDrawable).mutate();
      if (this.Uw) {
        a.a(localDrawable, this.Uu);
      }
      if (this.Ux) {
        a.a(localDrawable, this.Uv);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.Ut.getDrawableState());
      }
      this.Ut.setButtonDrawable(localDrawable);
    }
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.Ut.getContext().obtainStyledAttributes(paramAttributeSet, a.k.bJ, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(a.k.LU))
      {
        paramInt = paramAttributeSet.getResourceId(a.k.LU, 0);
        if (paramInt != 0) {
          this.Ut.setButtonDrawable(this.Um.a(this.Ut.getContext(), paramInt, false));
        }
      }
      if (paramAttributeSet.hasValue(a.k.LV)) {
        c.a(this.Ut, paramAttributeSet.getColorStateList(a.k.LV));
      }
      if (paramAttributeSet.hasValue(a.k.LW)) {
        c.a(this.Ut, w.aQ(paramAttributeSet.getInt(a.k.LW, -1)));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  final int aL(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = c.a(this.Ut);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  final void b(PorterDuff.Mode paramMode)
  {
    this.Uv = paramMode;
    this.Ux = true;
    ex();
  }
  
  final void e(ColorStateList paramColorStateList)
  {
    this.Uu = paramColorStateList;
    this.Uw = true;
    ex();
  }
  
  final void ew()
  {
    if (this.Uy)
    {
      this.Uy = false;
      return;
    }
    this.Uy = true;
    ex();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */