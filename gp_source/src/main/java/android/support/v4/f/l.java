package android.support.v4.f;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

public final class l
{
  private static final Locale a = new Locale("", "");
  
  public static int a(Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT < 17)
    {
      if ((paramLocale != null) && (!paramLocale.equals(a)))
      {
        String str = a.a(paramLocale);
        if (str != null)
        {
          if ((str.equalsIgnoreCase("Arab")) || (str.equalsIgnoreCase("Hebr"))) {
            return 1;
          }
        }
        else
        {
          switch (Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0)))
          {
          }
          return 0;
        }
      }
      return 0;
    }
    return TextUtils.getLayoutDirectionFromLocale(paramLocale);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/f/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */