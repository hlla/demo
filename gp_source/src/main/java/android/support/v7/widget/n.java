package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.a;

final class n
  extends AppCompatImageView
  implements r
{
  public n(j paramj, Context paramContext)
  {
    super(paramContext, null, 2130968605);
    setClickable(true);
    setFocusable(true);
    setVisibility(0);
    setEnabled(true);
    hq.a(this, getContentDescription());
    setOnTouchListener(new o(this, this));
  }
  
  public final boolean c()
  {
    return false;
  }
  
  public final boolean d()
  {
    return false;
  }
  
  public final boolean performClick()
  {
    if (!super.performClick())
    {
      playSoundEffect(0);
      this.a.c();
    }
    return true;
  }
  
  protected final boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable1 = getDrawable();
    Drawable localDrawable2 = getBackground();
    if ((localDrawable1 != null) && (localDrawable2 != null))
    {
      paramInt3 = getWidth();
      paramInt2 = getHeight();
      paramInt1 = Math.max(paramInt3, paramInt2) / 2;
      paramInt3 = (paramInt3 + (getPaddingLeft() - getPaddingRight())) / 2;
      paramInt2 = (paramInt2 + (getPaddingTop() - getPaddingBottom())) / 2;
      a.a(localDrawable2, paramInt3 - paramInt1, paramInt2 - paramInt1, paramInt3 + paramInt1, paramInt2 + paramInt1);
    }
    return bool;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */