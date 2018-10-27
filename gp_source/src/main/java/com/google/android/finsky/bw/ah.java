package com.google.android.finsky.bw;

import com.google.android.finsky.utils.FinskyLog;
import java.text.NumberFormat;
import java.text.ParseException;

public final class ah
{
  private static final NumberFormat a;
  
  static
  {
    NumberFormat localNumberFormat = NumberFormat.getNumberInstance();
    a = localNumberFormat;
    localNumberFormat.setMinimumFractionDigits(1);
    a.setMaximumFractionDigits(1);
  }
  
  public static float a(float paramFloat)
  {
    String str = b(paramFloat);
    try
    {
      float f = a.parse(str).floatValue();
      return f;
    }
    catch (ParseException localParseException)
    {
      FinskyLog.e("Cannot parse %s. Exception %s", new Object[] { str, localParseException });
    }
    return paramFloat;
  }
  
  public static String b(float paramFloat)
  {
    return a.format(paramFloat);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */