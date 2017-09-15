package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.d;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

public final class c
{
  static int wQQ = 5;
  static int wQR = 16;
  static char[] wQS = new char[16];
  static String wQT = "dex2oat-cmdline";
  static long wQU = 4096L;
  
  public static String Vi(String paramString)
  {
    paramString = new d(paramString);
    paramString.a(wQS);
    if (wQS[wQQ] == '\001') {}
    char[] arrayOfChar2;
    for (boolean bool = true;; bool = false)
    {
      paramString.wVx = bool;
      long l = wQU;
      paramString.wVv.seek(l);
      arrayOfChar1 = new char[4];
      arrayOfChar2 = new char[4];
      paramString.a(arrayOfChar1);
      if ((arrayOfChar1[0] == 'o') && (arrayOfChar1[1] == 'a') && (arrayOfChar1[2] == 't')) {
        break;
      }
      throw new UnknownFormatConversionException(String.format("Invalid art magic %c%c%c", new Object[] { Character.valueOf(arrayOfChar1[0]), Character.valueOf(arrayOfChar1[1]), Character.valueOf(arrayOfChar1[2]) }));
    }
    paramString.a(arrayOfChar2);
    paramString.readInt();
    paramString.readInt();
    paramString.readInt();
    paramString.readInt();
    paramString.readInt();
    paramString.readInt();
    paramString.readInt();
    paramString.readInt();
    if (arrayOfChar2[1] <= '4')
    {
      paramString.readInt();
      paramString.readInt();
      paramString.readInt();
    }
    paramString.readInt();
    paramString.readInt();
    paramString.readInt();
    paramString.readInt();
    paramString.readInt();
    paramString.readInt();
    paramString.readInt();
    char[] arrayOfChar1 = new char[paramString.readInt()];
    paramString.a(arrayOfChar1);
    return Vj(new String(arrayOfChar1));
  }
  
  private static String Vj(String paramString)
  {
    paramString = paramString.split(new String("\000"));
    int i = 0;
    while (i < paramString.length)
    {
      int j = i + 1;
      Object localObject = paramString[i];
      i = j + 1;
      String str = paramString[j];
      if (((String)localObject).equals(wQT)) {
        return str;
      }
    }
    return "";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */