package com.tencent.c.d.a;

import com.tencent.c.d.b.a;
import com.tencent.c.d.b.c;
import com.tencent.c.e.g;
import java.io.File;
import java.io.IOException;

public final class f
{
  private static boolean F(File paramFile)
  {
    boolean bool = false;
    try
    {
      int i = c.Vb(paramFile.getAbsolutePath());
      if ((i & 0x800) > 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramFile)
    {
      g.i(paramFile);
    }
    return false;
  }
  
  public static boolean cdy()
  {
    if (com.tencent.c.d.b.f.cdA()) {
      g.Ve("SetuidBitChecker : SELinux is enforcing");
    }
    int j;
    int i;
    label57:
    File localFile;
    for (;;)
    {
      return false;
      try
      {
        Object localObject = new String(a.Va("/proc/mounts"));
        g.d("SetuidBitChecker mounts : " + (String)localObject);
        localObject = ((String)localObject).split("\n");
        j = localObject.length;
        i = 0;
        if (i < j)
        {
          localFile = localObject[i];
          if (localFile.contains(" /system "))
          {
            if (!localFile.contains(",nosuid")) {
              break label115;
            }
            g.Ve("SetuidBitChecker : nosuid found");
          }
        }
        label115:
        for (i = 1; i == 0; i = 0)
        {
          if (c.isAvailable()) {
            break label127;
          }
          g.Ve("SetuidBitChecker : OsUtil isn't available");
          return false;
          i += 1;
          break label57;
        }
        arrayOfFile = new File("/system/bin").listFiles();
      }
      catch (IOException localIOException)
      {
        g.i(localIOException);
        return false;
      }
    }
    label127:
    if (arrayOfFile != null)
    {
      j = arrayOfFile.length;
      i = 0;
      while (i < j)
      {
        localFile = arrayOfFile[i];
        if ((!"run-as".equals(localFile.getName())) && (F(localFile)))
        {
          g.Ve("SetuidBitChecker s-bit found : " + localFile.getAbsolutePath());
          return true;
        }
        i += 1;
      }
    }
    File[] arrayOfFile = new File("/system/xbin").listFiles();
    if (arrayOfFile != null)
    {
      j = arrayOfFile.length;
      i = 0;
      while (i < j)
      {
        localFile = arrayOfFile[i];
        if (F(localFile))
        {
          g.Ve("SetuidBitChecker s-bit found : " + localFile.getAbsolutePath());
          return true;
        }
        i += 1;
      }
    }
    g.Ve("SetuidBitChecker s-bit not found");
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/d/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */