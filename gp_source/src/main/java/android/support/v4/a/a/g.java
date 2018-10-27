package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Method;

final class g
  extends d
{
  private static Method d;
  
  g(Drawable paramDrawable)
  {
    super(paramDrawable);
    d();
  }
  
  g(e parame, Resources paramResources)
  {
    super(parame, paramResources);
    d();
  }
  
  private static void d()
  {
    if (d == null) {}
    try
    {
      d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
      return;
    }
    catch (Exception localException)
    {
      Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", localException);
    }
  }
  
  final e b()
  {
    return new h(this.c);
  }
  
  protected final boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT == 21)
    {
      Drawable localDrawable = this.b;
      if ((!(localDrawable instanceof GradientDrawable)) && (!(localDrawable instanceof DrawableContainer)) && (!(localDrawable instanceof InsetDrawable)))
      {
        bool1 = bool2;
        if (!(localDrawable instanceof RippleDrawable)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final Rect getDirtyBounds()
  {
    return this.b.getDirtyBounds();
  }
  
  public final void getOutline(Outline paramOutline)
  {
    this.b.getOutline(paramOutline);
  }
  
  public final void setHotspot(float paramFloat1, float paramFloat2)
  {
    this.b.setHotspot(paramFloat1, paramFloat2);
  }
  
  public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    if (super.setState(paramArrayOfInt))
    {
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public final void setTint(int paramInt)
  {
    if (c())
    {
      super.setTint(paramInt);
      return;
    }
    this.b.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (c())
    {
      super.setTintList(paramColorStateList);
      return;
    }
    this.b.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (c())
    {
      super.setTintMode(paramMode);
      return;
    }
    this.b.setTintMode(paramMode);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */