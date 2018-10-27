package com.google.android.finsky.s.a;

import com.google.android.finsky.ag.d;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.j;
import com.google.android.play.utils.b.a;
import java.util.ArrayList;
import java.util.List;

final class f
{
  public final int a;
  public final int b;
  public final int c;
  public final String d;
  
  private f(String paramString)
  {
    String[] arrayOfString = j.a(paramString);
    int i = arrayOfString.length;
    if (i != 4) {
      throw new IllegalArgumentException(String.format("Invalid number of items for the Rapid Auto Update data (Expecting 4, got %d). Data: %s", new Object[] { Integer.valueOf(i), paramString }));
    }
    try
    {
      this.d = arrayOfString[0];
      this.c = Integer.parseInt(arrayOfString[1]);
      this.b = Integer.parseInt(arrayOfString[2]);
      this.a = Integer.parseInt(arrayOfString[3]);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new IllegalArgumentException(String.format("Invalid format for the Rapid Auto Update data: %s", new Object[] { paramString }));
    }
  }
  
  static List a()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = ((String)d.hs.b()).split(";", -1);
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = arrayOfString[i];
        try
        {
          localArrayList.add(new f(str));
          i += 1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            FinskyLog.c(localIllegalArgumentException.getMessage(), new Object[0]);
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/s/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */