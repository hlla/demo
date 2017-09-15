package ct;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class p
{
  public static Context a = null;
  public static String b = "";
  public static String c = "null";
  public static int d = 0;
  public static String e = "";
  public static String f = "";
  public static String g = "1.6.4.1101";
  private static a h = a.b;
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    a = paramContext.getApplicationContext();
    b = paramString1;
    e = paramString3;
    f = paramString2;
    g = "1.6.4.1101";
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      c = paramContext.versionName;
      d = paramContext.versionCode;
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static boolean a()
  {
    return h == a.a;
  }
  
  static enum a
  {
    static
    {
      b = new a("OFFICIAL", 2);
      a locala = a;
      locala = c;
      locala = b;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */