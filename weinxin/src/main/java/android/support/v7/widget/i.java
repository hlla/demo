package android.support.v7.widget;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class i
{
  private final ImageView UO;
  private final h Um;
  
  public i(ImageView paramImageView, h paramh)
  {
    this.UO = paramImageView;
    this.Um = paramh;
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = ap.a(this.UO.getContext(), paramAttributeSet, a.k.bj, paramInt);
    try
    {
      Drawable localDrawable = paramAttributeSet.bG(a.k.LE);
      if (localDrawable != null) {
        this.UO.setImageDrawable(localDrawable);
      }
      paramInt = paramAttributeSet.getResourceId(a.k.LF, -1);
      if (paramInt != -1)
      {
        localDrawable = this.Um.a(this.UO.getContext(), paramInt, false);
        if (localDrawable != null) {
          this.UO.setImageDrawable(localDrawable);
        }
      }
      localDrawable = this.UO.getDrawable();
      if (localDrawable != null) {
        w.n(localDrawable);
      }
      return;
    }
    finally
    {
      paramAttributeSet.aeG.recycle();
    }
  }
  
  public final void setImageResource(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.Um != null) {}
      for (Drawable localDrawable = this.Um.a(this.UO.getContext(), paramInt, false);; localDrawable = a.a(this.UO.getContext(), paramInt))
      {
        if (localDrawable != null) {
          w.n(localDrawable);
        }
        this.UO.setImageDrawable(localDrawable);
        return;
      }
    }
    this.UO.setImageDrawable(null);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */