package com.tencent.mm.ui.tools;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h
  implements InputFilter
{
  private int jsv;
  private int jsw;
  
  public h(int paramInt1, int paramInt2)
  {
    GMTrace.i(2060644777984L, 15353);
    this.jsv = paramInt1;
    this.jsw = paramInt2;
    GMTrace.o(2060644777984L, 15353);
  }
  
  public static int Ul(String paramString)
  {
    int i = 0;
    int j = 0;
    GMTrace.i(2061047431168L, 15356);
    if (bf.mA(paramString))
    {
      GMTrace.o(2061047431168L, 15356);
      return 0;
    }
    int m = paramString.length();
    int n = Um(paramString);
    if (bf.mA(paramString)) {}
    for (i = j;; i = paramString.length() - (j + Um(paramString)))
    {
      GMTrace.o(2061047431168L, 15356);
      return i + (n + m);
      int k;
      for (j = 0; i < paramString.length(); j = k)
      {
        int i1 = paramString.charAt(i);
        k = j;
        if (i1 >= 0)
        {
          k = j;
          if (i1 <= 127) {
            k = j + 1;
          }
        }
        i += 1;
      }
    }
  }
  
  public static int Um(String paramString)
  {
    GMTrace.i(2061181648896L, 15357);
    if (bf.mA(paramString))
    {
      GMTrace.o(2061181648896L, 15357);
      return 0;
    }
    paramString = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(paramString);
    int i = 0;
    if (paramString.find())
    {
      int k = 0;
      int j = i;
      for (;;)
      {
        i = j;
        if (k > paramString.groupCount()) {
          break;
        }
        k += 1;
        j += 1;
      }
    }
    GMTrace.o(2061181648896L, 15357);
    return i;
  }
  
  public static int aH(int paramInt, String paramString)
  {
    GMTrace.i(2061315866624L, 15358);
    if (u.bIz())
    {
      paramInt = Math.round((paramInt - Math.round(Ul(paramString))) / 2.0F);
      GMTrace.o(2061315866624L, 15358);
      return paramInt;
    }
    int i = Ul(paramString);
    GMTrace.o(2061315866624L, 15358);
    return paramInt - i;
  }
  
  public static int aI(int paramInt, String paramString)
  {
    GMTrace.i(2061450084352L, 15359);
    if (u.bIz())
    {
      paramInt = Math.round((Math.round(Ul(paramString)) - paramInt) / 2.0F);
      GMTrace.o(2061450084352L, 15359);
      return paramInt;
    }
    int i = Ul(paramString);
    GMTrace.o(2061450084352L, 15359);
    return i - paramInt;
  }
  
  public static int cY(String paramString, int paramInt)
  {
    GMTrace.i(2060913213440L, 15355);
    if (paramInt == a.wkz)
    {
      if (bf.mA(paramString))
      {
        GMTrace.o(2060913213440L, 15355);
        return 0;
      }
      paramInt = paramString.length();
      GMTrace.o(2060913213440L, 15355);
      return paramInt;
    }
    if (paramInt == a.wkA)
    {
      paramInt = Ul(paramString);
      GMTrace.o(2060913213440L, 15355);
      return paramInt;
    }
    GMTrace.o(2060913213440L, 15355);
    return 0;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    GMTrace.i(2060778995712L, 15354);
    if (cY(paramSpanned.toString(), this.jsw) + cY(paramCharSequence.toString(), this.jsw) > this.jsv)
    {
      GMTrace.o(2060778995712L, 15354);
      return "";
    }
    GMTrace.o(2060778995712L, 15354);
    return paramCharSequence;
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(2058497294336L, 15337);
      wkz = 1;
      wkA = 2;
      wkB = new int[] { wkz, wkA };
      GMTrace.o(2058497294336L, 15337);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */