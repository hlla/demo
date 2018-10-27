package com.google.android.finsky.cc;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.finsky.ds.a.bu;
import com.google.android.finsky.ds.a.cp;
import com.google.android.finsky.ds.a.er;
import com.google.android.finsky.ds.a.fb;

public final class d
{
  public static c a(cp paramcp, String paramString)
  {
    if (paramcp.e == 1)
    {
      c localc = new c();
      localc.g = paramcp.g;
      er localer = paramcp.c();
      localc.a = localer.a;
      localc.e = localer.c;
      localc.b = localer.b;
      Object localObject = localer.e;
      if (localObject != null)
      {
        String str = ((fb)localObject).d;
        localObject = str;
        if (!TextUtils.isEmpty(str))
        {
          localObject = str;
          if (!TextUtils.isEmpty(paramString))
          {
            Uri localUri = Uri.parse(str);
            localObject = str;
            if (TextUtils.isEmpty(localUri.getQueryParameter("ctx"))) {
              localObject = localUri.buildUpon().appendQueryParameter("ctx", paramString).toString();
            }
          }
        }
        localc.f = ((String)localObject);
      }
      paramString = localer.d;
      if (paramString != null)
      {
        localc.d = paramString.g;
        localc.c = paramString.h;
      }
      for (;;)
      {
        return localc;
        paramcp = paramcp.d;
        if (paramcp != null)
        {
          localc.d = paramcp.g;
          localc.c = paramcp.h;
        }
      }
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cc/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */