package com.c.a.a;

import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class o
{
  private static String aLX;
  private static final SimpleDateFormat aLY = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", Locale.US);
  private static final SimpleDateFormat aLZ = new SimpleDateFormat("yyyMMddHHmmss", Locale.US);
  
  protected static boolean m(String paramString1, String paramString2)
  {
    String str = null;
    if (aLX == null)
    {
      boolean bool1;
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        File localFile = new File(Environment.getExternalStorageDirectory() + "/" + y.aPr);
        boolean bool2 = localFile.exists();
        bool1 = bool2;
        if (!bool2) {
          bool1 = localFile.mkdir();
        }
        if (bool1) {
          str = localFile.toString();
        }
        aLX = str;
      }
      while (!bool1)
      {
        return false;
        aLX = null;
        bool1 = false;
      }
    }
    try
    {
      paramString1 = new FileWriter(aLX + "/" + paramString1 + ".txt", true);
      paramString1.write("\n" + aLY.format(new Date()) + ',' + paramString2);
      paramString1.flush();
      paramString1.close();
      return true;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  protected static String no()
  {
    return aLZ.format(new Date());
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */