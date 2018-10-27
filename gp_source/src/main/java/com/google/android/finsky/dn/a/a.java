package com.google.android.finsky.dn.a;

import android.os.AsyncTask;
import com.google.android.finsky.dn.f;
import com.google.android.finsky.utils.FinskyLog;

public abstract class a
  extends AsyncTask
{
  private final String a;
  private final i b;
  private final f c;
  
  public a(i parami, String paramString, f paramf)
  {
    this.b = parami;
    this.a = paramString;
    this.c = paramf;
  }
  
  private static boolean a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!paramBoolean)
    {
      FinskyLog.d(paramString2, new Object[0]);
      return paramBoolean;
    }
    FinskyLog.b(paramString1, new Object[0]);
    return paramBoolean;
  }
  
  public abstract boolean a();
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */