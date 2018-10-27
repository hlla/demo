package com.google.android.finsky.r;

import android.accounts.Account;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.bo.f;
import java.util.Map;

public final class c
{
  public static String a(Account paramAccount, f paramf, long paramLong)
  {
    if (!((Boolean)d.gc.b()).booleanValue()) {}
    for (;;)
    {
      if (com.google.android.finsky.devicemanagement.a.c(paramAccount)) {}
      do
      {
        return (String)d.gL.b();
        return (String)d.gK.b();
        if (paramf == null) {
          break;
        }
      } while (paramf.a(paramLong));
    }
  }
  
  public static void a(Map paramMap, String paramString1, String paramString2)
  {
    if (paramString2.startsWith("oauth2:"))
    {
      paramString2 = String.valueOf("Bearer ");
      paramString1 = String.valueOf(paramString1);
      if (paramString1.length() == 0) {}
      for (paramString1 = new String(paramString2);; paramString1 = paramString2.concat(paramString1))
      {
        paramMap.put("Authorization", paramString1);
        return;
      }
    }
    paramString2 = String.valueOf("GoogleLogin auth=");
    paramString1 = String.valueOf(paramString1);
    if (paramString1.length() == 0) {}
    for (paramString1 = new String(paramString2);; paramString1 = paramString2.concat(paramString1))
    {
      paramMap.put("Authorization", paramString1);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/r/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */