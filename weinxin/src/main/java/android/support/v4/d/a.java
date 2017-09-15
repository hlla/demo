package android.support.v4.d;

import android.os.Build.VERSION;
import java.util.Locale;

public final class a
{
  private static final a vv = new b();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      vv = new d();
      return;
    }
    if (i >= 14)
    {
      vv = new c();
      return;
    }
  }
  
  public static String a(Locale paramLocale)
  {
    return vv.a(paramLocale);
  }
  
  static abstract interface a
  {
    public abstract String a(Locale paramLocale);
  }
  
  static final class b
    implements a.a
  {
    public final String a(Locale paramLocale)
    {
      return null;
    }
  }
  
  static final class c
    implements a.a
  {
    public final String a(Locale paramLocale)
    {
      return c.a(paramLocale);
    }
  }
  
  static final class d
    implements a.a
  {
    public final String a(Locale paramLocale)
    {
      return b.a(paramLocale);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */