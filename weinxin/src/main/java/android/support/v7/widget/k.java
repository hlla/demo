package android.support.v7.widget;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

final class k
  extends j
{
  private static final int[] PZ = { 16843074 };
  private final SeekBar UY;
  
  k(SeekBar paramSeekBar, h paramh)
  {
    super(paramSeekBar, paramh);
    this.UY = paramSeekBar;
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = ap.a(this.UY.getContext(), paramAttributeSet, PZ, paramInt);
    Drawable localDrawable = paramAttributeSet.bG(0);
    if (localDrawable != null) {
      this.UY.setThumb(localDrawable);
    }
    paramAttributeSet.aeG.recycle();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */