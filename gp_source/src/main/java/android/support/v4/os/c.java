package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Trace;

public final class c
{
  public static void a()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.endSection();
    }
  }
  
  public static void a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.beginSection(paramString);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/os/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */