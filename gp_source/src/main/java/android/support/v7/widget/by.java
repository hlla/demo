package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.c.a.l;

final class by
  extends l
{
  public boolean a = true;
  
  by(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.a) {
      super.draw(paramCanvas);
    }
  }
  
  public final void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.a) {
      super.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a) {
      super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    if (this.a) {
      return super.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a) {
      return super.setVisible(paramBoolean1, paramBoolean2);
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */