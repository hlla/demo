package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

public final class aq
  extends RatingBar
{
  private final ap a = new ap(this);
  
  public aq(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  private aq(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    super(paramContext, paramAttributeSet, 2130969454);
    this.a.a(paramAttributeSet, 2130969454);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      Bitmap localBitmap = this.a.a;
      if (localBitmap != null) {
        setMeasuredDimension(View.resolveSizeAndState(localBitmap.getWidth() * getNumStars(), paramInt1, 0), getMeasuredHeight());
      }
      return;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */