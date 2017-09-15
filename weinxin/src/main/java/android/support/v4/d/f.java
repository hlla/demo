package android.support.v4.d;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

public final class f
{
  public static final Locale ROOT;
  private static final a vL;
  public static String vM;
  public static String vN;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17) {}
    for (vL = new b();; vL = new a())
    {
      ROOT = new Locale("", "");
      vM = "Arab";
      vN = "Hebr";
      return;
    }
  }
  
  public static int getLayoutDirectionFromLocale(Locale paramLocale)
  {
    return vL.getLayoutDirectionFromLocale(paramLocale);
  }
  
  private static class a
  {
    public int getLayoutDirectionFromLocale(Locale paramLocale)
    {
      int j = 1;
      if ((paramLocale != null) && (!paramLocale.equals(f.ROOT)))
      {
        String str = a.a(paramLocale);
        int i;
        if (str == null)
        {
          i = j;
          switch (Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0)))
          {
          default: 
            i = 0;
          }
        }
        do
        {
          do
          {
            return i;
            i = j;
          } while (str.equalsIgnoreCase(f.vM));
          i = j;
        } while (str.equalsIgnoreCase(f.vN));
      }
      return 0;
    }
  }
  
  private static final class b
    extends f.a
  {
    public final int getLayoutDirectionFromLocale(Locale paramLocale)
    {
      return TextUtils.getLayoutDirectionFromLocale(paramLocale);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */