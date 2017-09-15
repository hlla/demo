package com.tencent.c.d.a;

import android.text.TextUtils;
import com.tencent.c.e.g;
import java.io.File;

public final class e
{
  public static boolean cdx()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = System.getenv("PATH");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(":");
          int j = localObject.length;
          i = 0;
          if (i < j)
          {
            File localFile = new File(localObject[i], "su");
            if (!localFile.exists()) {
              break label130;
            }
            g.Ve("SuFile found : " + localFile.toString());
            return true;
          }
        }
        else
        {
          if (!new File("/system/bin/su").exists()) {
            break label108;
          }
          g.Ve("SuFile found : /system/bin/su");
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        g.i(localThrowable);
        g.Ve("SuFile not found");
        return false;
      }
      label108:
      if (new File("/system/xbin/su").exists())
      {
        g.Ve("SuFile found : /system/xbin/su");
        return true;
        label130:
        i += 1;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/d/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */