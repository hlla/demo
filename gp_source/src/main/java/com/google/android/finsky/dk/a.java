package com.google.android.finsky.dk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import com.google.android.finsky.e.d;
import com.google.android.finsky.e.i;
import com.google.android.finsky.e.u;
import com.google.wireless.android.a.b.a.a.au;

public final class a
{
  public final Handler a;
  public final Context b;
  private final i c;
  
  public a(Context paramContext, i parami, Handler paramHandler)
  {
    this.b = paramContext;
    this.c = parami;
    this.a = paramHandler;
  }
  
  final void a(int paramInt, String paramString, Exception paramException, PackageInfo paramPackageInfo)
  {
    d locald = new d(147);
    locald.a(paramInt).a(paramString);
    if (paramException != null) {
      locald.a(paramException);
    }
    if (paramPackageInfo != null)
    {
      paramString = new au();
      paramException = paramPackageInfo.packageName;
      if (paramException != null)
      {
        paramString.a |= 0x1;
        paramString.b = paramException;
        paramInt = paramPackageInfo.versionCode;
        paramString.a |= 0x2;
        paramString.c = paramInt;
        locald.a.af = paramString;
      }
    }
    else
    {
      this.c.cV().a(locald.a);
      return;
    }
    throw new NullPointerException();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */