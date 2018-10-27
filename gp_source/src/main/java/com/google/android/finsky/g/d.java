package com.google.android.finsky.g;

import com.google.android.finsky.utils.FinskyLog;

public final class d
  implements c
{
  public final void a(String[] paramArrayOfString, e parame)
  {
    int i = 0;
    FinskyLog.a("backup not available due to pre-O API", new Object[0]);
    int j = paramArrayOfString.length;
    while (i < j)
    {
      parame.b(paramArrayOfString[i]);
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/g/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */