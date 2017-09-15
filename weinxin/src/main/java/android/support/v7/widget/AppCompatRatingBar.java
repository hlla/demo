package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.RatingBar;

public class AppCompatRatingBar
  extends RatingBar
{
  private j UW = new j(this, this.Um);
  private h Um = h.ey();
  
  public AppCompatRatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.ratingBarStyle);
  }
  
  public AppCompatRatingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.UW.a(paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      Bitmap localBitmap = this.UW.UV;
      if (localBitmap != null) {
        setMeasuredDimension(z.resolveSizeAndState(localBitmap.getWidth() * getNumStars(), paramInt1, 0), getMeasuredHeight());
      }
      return;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/AppCompatRatingBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */