package android.support.b.a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.a;
import android.support.v4.b.a.l;
import android.util.AttributeSet;

@TargetApi(21)
abstract class e
  extends Drawable
  implements l
{
  Drawable mj;
  
  static TypedArray a(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null) {
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    }
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    if (this.mj != null) {
      a.a(this.mj, paramTheme);
    }
  }
  
  public void clearColorFilter()
  {
    if (this.mj != null)
    {
      this.mj.clearColorFilter();
      return;
    }
    super.clearColorFilter();
  }
  
  public ColorFilter getColorFilter()
  {
    if (this.mj != null) {
      return a.f(this.mj);
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    if (this.mj != null) {
      return this.mj.getCurrent();
    }
    return super.getCurrent();
  }
  
  public int getLayoutDirection()
  {
    if (this.mj != null) {
      a.i(this.mj);
    }
    return 0;
  }
  
  public int getMinimumHeight()
  {
    if (this.mj != null) {
      return this.mj.getMinimumHeight();
    }
    return super.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    if (this.mj != null) {
      return this.mj.getMinimumWidth();
    }
    return super.getMinimumWidth();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    if (this.mj != null) {
      return this.mj.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    if (this.mj != null) {
      return this.mj.getState();
    }
    return super.getState();
  }
  
  public Region getTransparentRegion()
  {
    if (this.mj != null) {
      return this.mj.getTransparentRegion();
    }
    return super.getTransparentRegion();
  }
  
  public boolean isAutoMirrored()
  {
    if (this.mj != null) {
      a.c(this.mj);
    }
    return false;
  }
  
  public void jumpToCurrentState()
  {
    if (this.mj != null) {
      a.b(this.mj);
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.mj != null)
    {
      this.mj.setBounds(paramRect);
      return;
    }
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.mj != null) {
      return this.mj.setLevel(paramInt);
    }
    return super.onLevelChange(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.mj != null) {
      a.a(this.mj, paramBoolean);
    }
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    if (this.mj != null)
    {
      this.mj.setChangingConfigurations(paramInt);
      return;
    }
    super.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    if (this.mj != null)
    {
      this.mj.setColorFilter(paramInt, paramMode);
      return;
    }
    super.setColorFilter(paramInt, paramMode);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    if (this.mj != null) {
      this.mj.setFilterBitmap(paramBoolean);
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.mj != null) {
      a.a(this.mj, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mj != null) {
      a.a(this.mj, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    if (this.mj != null) {
      return this.mj.setState(paramArrayOfInt);
    }
    return super.setState(paramArrayOfInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/b/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */