package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

public final class af
{
  public static void a(ImageView paramImageView, ColorStateList paramColorStateList)
  {
    int j = 0;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView.setImageTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramImageView.getDrawable();
        i = j;
        if (paramImageView.getImageTintList() != null)
        {
          i = j;
          if (paramImageView.getImageTintMode() != null) {
            i = 1;
          }
        }
        if ((paramColorStateList != null) && (i != 0))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramColorStateList);
        }
      }
    }
    while (!(paramImageView instanceof ay))
    {
      int i;
      return;
    }
    ((ay)paramImageView).setSupportImageTintList(paramColorStateList);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */