package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class ResourcesCompat
{
  public Drawable getDrawable(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ResourcesCompatApi21.getDrawable(paramResources, paramInt, paramTheme);
    }
    return paramResources.getDrawable(paramInt);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/android/support/v4/content/res/ResourcesCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */