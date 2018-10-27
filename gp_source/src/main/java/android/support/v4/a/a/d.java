package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class d
  extends Drawable
  implements Drawable.Callback, b, c
{
  public static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
  public Drawable b;
  public e c;
  private boolean d;
  private int e;
  private PorterDuff.Mode f;
  private boolean g;
  
  d(Drawable paramDrawable)
  {
    this.c = b();
    a(paramDrawable);
  }
  
  d(e parame, Resources paramResources)
  {
    this.c = parame;
    parame = this.c;
    if (parame != null)
    {
      parame = parame.b;
      if (parame != null) {
        a(parame.newDrawable(paramResources));
      }
    }
  }
  
  private final boolean a(int[] paramArrayOfInt)
  {
    if (c())
    {
      Object localObject = this.c;
      ColorStateList localColorStateList = ((e)localObject).c;
      localObject = ((e)localObject).d;
      if (localColorStateList == null)
      {
        this.d = false;
        clearColorFilter();
      }
      int i;
      do
      {
        return false;
        if (localObject == null) {
          break;
        }
        i = localColorStateList.getColorForState(paramArrayOfInt, localColorStateList.getDefaultColor());
      } while ((this.d) && (i == this.e) && (localObject == this.f));
      setColorFilter(i, (PorterDuff.Mode)localObject);
      this.e = i;
      this.f = ((PorterDuff.Mode)localObject);
      this.d = true;
      return true;
    }
    return false;
  }
  
  public final Drawable a()
  {
    return this.b;
  }
  
  public final void a(Drawable paramDrawable)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((Drawable)localObject).setCallback(null);
    }
    this.b = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      setVisible(paramDrawable.isVisible(), true);
      setState(paramDrawable.getState());
      setLevel(paramDrawable.getLevel());
      setBounds(paramDrawable.getBounds());
      localObject = this.c;
      if (localObject != null) {
        ((e)localObject).b = paramDrawable.getConstantState();
      }
    }
    invalidateSelf();
  }
  
  e b()
  {
    return new f(this.c);
  }
  
  protected boolean c()
  {
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.b.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    int j = super.getChangingConfigurations();
    e locale = this.c;
    if (locale != null) {}
    for (int i = locale.getChangingConfigurations();; i = 0) {
      return i | j | this.b.getChangingConfigurations();
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    e locale = this.c;
    if ((locale != null) && (locale.b != null))
    {
      locale.a = getChangingConfigurations();
      return this.c;
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    return this.b.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return this.b.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.b.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    return this.b.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.b.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return this.b.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.b.getPadding(paramRect);
  }
  
  public int[] getState()
  {
    return this.b.getState();
  }
  
  public Region getTransparentRegion()
  {
    return this.b.getTransparentRegion();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    return this.b.isAutoMirrored();
  }
  
  public boolean isStateful()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (c())
    {
      e locale = this.c;
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = locale.c;
      }
    }
    if (localObject1 == null) {}
    for (;;)
    {
      if (this.b.isStateful()) {}
      do
      {
        return true;
        return false;
      } while (((ColorStateList)localObject1).isStateful());
    }
  }
  
  public void jumpToCurrentState()
  {
    this.b.jumpToCurrentState();
  }
  
  public Drawable mutate()
  {
    e locale;
    if ((!this.g) && (super.mutate() == this))
    {
      this.c = b();
      localObject = this.b;
      if (localObject != null) {
        ((Drawable)localObject).mutate();
      }
      locale = this.c;
      if (locale != null)
      {
        localObject = this.b;
        if (localObject == null) {
          break label72;
        }
      }
    }
    label72:
    for (Object localObject = ((Drawable)localObject).getConstantState();; localObject = null)
    {
      locale.b = ((Drawable.ConstantState)localObject);
      this.g = true;
      return this;
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return this.b.setLevel(paramInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.b.setAlpha(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    this.b.setAutoMirrored(paramBoolean);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    this.b.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.b.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.b.setFilterBitmap(paramBoolean);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    boolean bool = this.b.setState(paramArrayOfInt);
    if (a(paramArrayOfInt)) {}
    while (bool) {
      return true;
    }
    return false;
  }
  
  public void setTint(int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.c.c = paramColorStateList;
    a(getState());
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.c.d = paramMode;
    a(getState());
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (super.setVisible(paramBoolean1, paramBoolean2)) || (this.b.setVisible(paramBoolean1, paramBoolean2));
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */