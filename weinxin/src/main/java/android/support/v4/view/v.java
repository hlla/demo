package android.support.v4.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

final class v
{
  private static final class a
    extends SingleLineTransformationMethod
  {
    private Locale xX;
    
    public a(Context paramContext)
    {
      this.xX = paramContext.getResources().getConfiguration().locale;
    }
    
    public final CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
    {
      paramCharSequence = super.getTransformation(paramCharSequence, paramView);
      if (paramCharSequence != null) {
        return paramCharSequence.toString().toUpperCase(this.xX);
      }
      return null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */