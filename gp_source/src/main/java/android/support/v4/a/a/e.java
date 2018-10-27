package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public abstract class e
  extends Drawable.ConstantState
{
  public int a;
  public Drawable.ConstantState b;
  public ColorStateList c = null;
  public PorterDuff.Mode d = d.a;
  
  e(e parame)
  {
    if (parame != null)
    {
      this.a = parame.a;
      this.b = parame.b;
      this.c = parame.c;
      this.d = parame.d;
    }
  }
  
  public int getChangingConfigurations()
  {
    int j = this.a;
    Drawable.ConstantState localConstantState = this.b;
    if (localConstantState != null) {}
    for (int i = localConstantState.getChangingConfigurations();; i = 0) {
      return i | j;
    }
  }
  
  public Drawable newDrawable()
  {
    return newDrawable(null);
  }
  
  public abstract Drawable newDrawable(Resources paramResources);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */