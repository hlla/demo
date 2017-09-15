package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.a.i;
import android.support.v7.widget.ap;
import android.util.AttributeSet;
import android.view.View;

public final class TabItem
  extends View
{
  final Drawable jQ;
  final int jR;
  final CharSequence mText;
  
  public TabItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = ap.a(paramContext, paramAttributeSet, a.i.cO);
    this.mText = paramContext.getText(a.i.cR);
    this.jQ = paramContext.getDrawable(a.i.cP);
    this.jR = paramContext.getResourceId(a.i.cQ, 0);
    paramContext.aeG.recycle();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/TabItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */