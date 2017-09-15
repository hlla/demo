package com.tencent.c.d.a;

import com.tencent.c.e.g;
import java.io.File;
import java.io.IOException;

public final class a
{
  public static boolean UY(String paramString)
  {
    if (!new File(paramString).exists()) {
      return true;
    }
    try
    {
      boolean bool = com.tencent.c.d.b.a.UY(paramString);
      if (!bool) {
        g.Ve("BootScriptChecker found no-elf file : " + paramString);
      }
      return bool;
    }
    catch (IOException paramString)
    {
      g.i(paramString);
    }
    return true;
  }
  
  public static boolean UZ(String paramString)
  {
    boolean bool2 = true;
    Object localObject = new File(paramString);
    boolean bool1 = bool2;
    if (((File)localObject).exists())
    {
      if (((File)localObject).length() <= 51200L) {
        break label35;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        label35:
        localObject = new String(com.tencent.c.d.b.a.Va(((File)localObject).getAbsolutePath()));
        bool2 = ((String)localObject).contains("applypatch ");
        g.d("BootScriptChecker script (" + paramString + ") content : \n" + (String)localObject);
        bool1 = bool2;
        if (!bool2)
        {
          g.Ve("BootScriptChecker found unofficial file : " + paramString);
          return bool2;
        }
      }
      catch (Exception paramString)
      {
        g.i(paramString);
      }
    }
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */