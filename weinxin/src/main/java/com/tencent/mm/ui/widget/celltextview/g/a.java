package com.tencent.mm.ui.widget.celltextview.g;

import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.gmtrace.GMTrace;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  static Pattern vNO;
  private static Rect wxa;
  
  static
  {
    GMTrace.i(18756793270272L, 139749);
    vNO = Pattern.compile("[`\"~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？「」]$");
    wxa = new Rect();
    GMTrace.o(18756793270272L, 139749);
  }
  
  public static char[] V(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(18756524834816L, 139747);
    int i = paramInt2 - paramInt1;
    if ((paramString != null) && (paramInt1 >= 0) && (paramInt1 <= paramInt2))
    {
      char[] arrayOfChar = new char[i];
      if (paramInt2 <= paramString.length()) {}
      for (;;)
      {
        paramString.getChars(paramInt1, paramInt2, arrayOfChar, 0);
        GMTrace.o(18756524834816L, 139747);
        return arrayOfChar;
        paramInt2 = paramString.length();
      }
    }
    paramString = new char[i];
    GMTrace.o(18756524834816L, 139747);
    return paramString;
  }
  
  public static float a(char paramChar, Paint paramPaint)
  {
    GMTrace.i(18917451890688L, 140946);
    String str = String.valueOf(paramChar);
    float f = paramPaint.measureText(str);
    paramPaint.getTextBounds(str, 0, 1, wxa);
    int i = (int)(f - wxa.right);
    if (i > 0)
    {
      f = i;
      GMTrace.o(18917451890688L, 140946);
      return f;
    }
    GMTrace.o(18917451890688L, 140946);
    return 0.0F;
  }
  
  public static float b(char paramChar, Paint paramPaint)
  {
    GMTrace.i(18917586108416L, 140947);
    paramPaint.getTextBounds(String.valueOf(paramChar), 0, 1, wxa);
    int i = wxa.left;
    if (i > 0)
    {
      float f = i;
      GMTrace.o(18917586108416L, 140947);
      return f;
    }
    GMTrace.o(18917586108416L, 140947);
    return 0.0F;
  }
  
  public static char cZ(String paramString, int paramInt)
  {
    GMTrace.i(18756390617088L, 139746);
    if ((paramInt >= 0) && (paramString != null) && (paramInt < paramString.length()))
    {
      char c = paramString.charAt(paramInt);
      GMTrace.o(18756390617088L, 139746);
      return c;
    }
    GMTrace.o(18756390617088L, 139746);
    return '\000';
  }
  
  public static int db(String paramString, int paramInt)
  {
    GMTrace.i(18755987963904L, 139743);
    int i = paramInt;
    while (i >= 0)
    {
      if (!l(paramString.charAt(i)))
      {
        GMTrace.o(18755987963904L, 139743);
        return i + 1;
      }
      i -= 1;
    }
    GMTrace.o(18755987963904L, 139743);
    return paramInt;
  }
  
  public static int dc(String paramString, int paramInt)
  {
    GMTrace.i(18756122181632L, 139744);
    while (paramInt >= 0)
    {
      if (!o(paramString.charAt(paramInt)))
      {
        GMTrace.o(18756122181632L, 139744);
        return paramInt + 1;
      }
      paramInt -= 1;
    }
    GMTrace.o(18756122181632L, 139744);
    return 0;
  }
  
  public static int dd(String paramString, int paramInt)
  {
    GMTrace.i(18756256399360L, 139745);
    while (paramInt < paramString.length())
    {
      if (!o(paramString.charAt(paramInt)))
      {
        GMTrace.o(18756256399360L, 139745);
        return paramInt - 1;
      }
      paramInt += 1;
    }
    GMTrace.o(18756256399360L, 139745);
    return paramInt - 1;
  }
  
  public static boolean l(char paramChar)
  {
    GMTrace.i(18755585310720L, 139740);
    if (((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= '0') && (paramChar <= '9')) || (paramChar == '_') || (paramChar == '-') || (paramChar == '@'))
    {
      GMTrace.o(18755585310720L, 139740);
      return true;
    }
    GMTrace.o(18755585310720L, 139740);
    return false;
  }
  
  public static boolean m(char paramChar)
  {
    GMTrace.i(18755719528448L, 139741);
    if ((paramChar == '、') || (paramChar == 65289) || (paramChar == 65292) || (paramChar == '。') || (paramChar == '》') || (paramChar == '】') || (paramChar == '」') || (paramChar == 65311) || (paramChar == 65307) || (paramChar == 65306) || (paramChar == '”'))
    {
      GMTrace.o(18755719528448L, 139741);
      return true;
    }
    GMTrace.o(18755719528448L, 139741);
    return false;
  }
  
  public static boolean n(char paramChar)
  {
    GMTrace.i(18755853746176L, 139742);
    if ((paramChar == 65288) || (paramChar == '《') || (paramChar == '「') || (paramChar == '【') || (paramChar == '“'))
    {
      GMTrace.o(18755853746176L, 139742);
      return true;
    }
    GMTrace.o(18755853746176L, 139742);
    return false;
  }
  
  public static boolean o(char paramChar)
  {
    GMTrace.i(18756659052544L, 139748);
    boolean bool = vNO.matcher(Character.toString(paramChar)).find();
    GMTrace.o(18756659052544L, 139748);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/celltextview/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */