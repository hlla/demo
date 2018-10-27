package android.support.d.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;

final class t
  extends Drawable.ConstantState
{
  private final Drawable.ConstantState a;
  
  public t(Drawable.ConstantState paramConstantState)
  {
    this.a = paramConstantState;
  }
  
  public final boolean canApplyTheme()
  {
    return this.a.canApplyTheme();
  }
  
  public final int getChangingConfigurations()
  {
    return this.a.getChangingConfigurations();
  }
  
  public final Drawable newDrawable()
  {
    l locall = new l();
    locall.b = ((VectorDrawable)this.a.newDrawable());
    return locall;
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    l locall = new l();
    locall.b = ((VectorDrawable)this.a.newDrawable(paramResources));
    return locall;
  }
  
  public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
  {
    l locall = new l();
    locall.b = ((VectorDrawable)this.a.newDrawable(paramResources, paramTheme));
    return locall;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/d/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */