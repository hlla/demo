package com.google.android.finsky.dc;

import android.os.Environment;
import com.google.android.finsky.ds.a.ds;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.em.g;
import com.google.android.finsky.utils.FinskyLog;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
{
  private static final Pattern a = Pattern.compile("^main\\.(\\d+)\\.([\\w\\.]+)\\.obb$");
  private static final Pattern b = Pattern.compile("^patch\\.(\\d+)\\.([\\w\\.]+)\\.obb$");
  private static File c;
  
  @Deprecated
  public static long a(o paramo, g paramg)
  {
    int i = 0;
    long l = 0L;
    paramg = paramo.n;
    if (i < paramg.length)
    {
      paramg = paramg[i];
      int j = paramg.c;
      switch (j)
      {
      default: 
        FinskyLog.c("Bad file type %d in %s entry# %d", new Object[] { Integer.valueOf(j), paramo.t, Integer.valueOf(i) });
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 2) {}
        for (boolean bool = true;; bool = false)
        {
          paramg = new a(bool, paramo.t, paramg.g, paramg.e);
          if (paramg.c == 4)
          {
            l += paramg.b;
            break;
          }
          break;
        }
        l += paramg.e;
      }
    }
    return l;
  }
  
  public static File a(String paramString)
  {
    try
    {
      if (c == null) {
        c = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "obb");
      }
      paramString = new File(c, paramString);
      return paramString;
    }
    finally {}
  }
  
  public static Integer a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    Pattern localPattern;
    for (Object localObject = a;; localPattern = b)
    {
      localObject = ((Pattern)localObject).matcher(paramString1);
      if (((Matcher)localObject).matches())
      {
        if (((Matcher)localObject).group(2).equals(paramString2)) {
          try
          {
            int i = Integer.parseInt(((Matcher)localObject).group(1));
            return Integer.valueOf(i);
          }
          catch (NumberFormatException localNumberFormatException) {}
        }
        FinskyLog.d("Unable to parse version code from OBB file name %s for package %s", new Object[] { paramString1, paramString2 });
      }
      return null;
    }
  }
  
  public static String a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean) {}
    for (String str = "main";; str = "patch")
    {
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 17 + String.valueOf(paramString).length());
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".obb");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dc/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */