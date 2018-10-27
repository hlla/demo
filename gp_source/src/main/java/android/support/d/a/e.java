package android.support.d.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class e
  extends Drawable.ConstantState
{
  private final Drawable.ConstantState a;
  
  public e(Drawable.ConstantState paramConstantState)
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
    b localb = new b();
    localb.b = this.a.newDrawable();
    localb.b.setCallback(localb.a);
    return localb;
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    b localb = new b();
    localb.b = this.a.newDrawable(paramResources);
    localb.b.setCallback(localb.a);
    return localb;
  }
  
  public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
  {
    b localb = new b();
    localb.b = this.a.newDrawable(paramResources, paramTheme);
    localb.b.setCallback(localb.a);
    return localb;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/d/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */