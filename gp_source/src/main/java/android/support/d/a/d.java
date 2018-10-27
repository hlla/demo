package android.support.d.a;

import android.animation.AnimatorSet;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.g.a;
import java.util.ArrayList;

final class d
  extends Drawable.ConstantState
{
  public AnimatorSet a;
  public ArrayList b;
  public a c;
  public l d;
  
  public final int getChangingConfigurations()
  {
    return 0;
  }
  
  public final Drawable newDrawable()
  {
    throw new IllegalStateException("No constant state support for SDK < 24.");
  }
  
  public final Drawable newDrawable(Resources paramResources)
  {
    throw new IllegalStateException("No constant state support for SDK < 24.");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/d/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */