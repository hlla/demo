package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

final class m
  extends l
{
  private static final int[] Vw = { 16843666, 16843667 };
  private an Vx;
  private an Vy;
  
  m(TextView paramTextView)
  {
    super(paramTextView);
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    Context localContext = this.Vr.getContext();
    h localh = h.ey();
    paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, Vw, paramInt, 0);
    if (paramAttributeSet.hasValue(0)) {
      this.Vx = a(localContext, localh, paramAttributeSet.getResourceId(0, 0));
    }
    if (paramAttributeSet.hasValue(1)) {
      this.Vy = a(localContext, localh, paramAttributeSet.getResourceId(1, 0));
    }
    paramAttributeSet.recycle();
  }
  
  final void eB()
  {
    super.eB();
    if ((this.Vx != null) || (this.Vy != null))
    {
      Drawable[] arrayOfDrawable = this.Vr.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], this.Vx);
      a(arrayOfDrawable[2], this.Vy);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */