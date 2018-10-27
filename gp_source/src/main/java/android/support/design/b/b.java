package android.support.design.b;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;

@TargetApi(21)
final class b
  extends RippleDrawable
{
  b(ColorStateList paramColorStateList, InsetDrawable paramInsetDrawable, Drawable paramDrawable)
  {
    super(paramColorStateList, paramInsetDrawable, paramDrawable);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (getDrawable(0) != null) {
      ((GradientDrawable)((LayerDrawable)((InsetDrawable)getDrawable(0)).getDrawable()).getDrawable(0)).setColorFilter(paramColorFilter);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */