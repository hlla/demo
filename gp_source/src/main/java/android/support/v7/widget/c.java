package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

final class c
  extends Drawable
{
  private final ActionBarContainer a;
  
  public c(ActionBarContainer paramActionBarContainer)
  {
    this.a = paramActionBarContainer;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Object localObject = this.a;
    if (((ActionBarContainer)localObject).b)
    {
      localObject = ((ActionBarContainer)localObject).d;
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
    }
    Drawable localDrawable;
    do
    {
      return;
      localObject = ((ActionBarContainer)localObject).a;
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
      localObject = this.a;
      localDrawable = ((ActionBarContainer)localObject).e;
    } while ((localDrawable == null) || (!((ActionBarContainer)localObject).c));
    localDrawable.draw(paramCanvas);
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    Object localObject = this.a;
    if (((ActionBarContainer)localObject).b)
    {
      localObject = ((ActionBarContainer)localObject).d;
      if (localObject != null) {
        ((Drawable)localObject).getOutline(paramOutline);
      }
    }
    do
    {
      return;
      localObject = ((ActionBarContainer)localObject).a;
    } while (localObject == null);
    ((Drawable)localObject).getOutline(paramOutline);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */