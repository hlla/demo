package com.google.android.play.dfe.api;

import android.accounts.Account;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.volley.a.b;
import com.google.android.play.utils.PlayCommonLog;
import com.google.android.play.utils.b.j;
import com.google.android.play.utils.k;
import com.google.android.volley.l;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class e
{
  private static String h;
  public final boolean a;
  public final b b;
  public final com.android.volley.a c;
  private final int d;
  private final Context e;
  private final Map f = new HashMap();
  private String g;
  
  private e(Context paramContext, Account paramAccount, com.android.volley.a parama, String paramString1, String paramString2, int paramInt1, Locale paramLocale, String paramString3, String paramString4, String paramString5, int paramInt2, boolean paramBoolean)
  {
    label54:
    String str;
    if (paramInt2 == 0)
    {
      this.e = paramContext;
      this.a = paramBoolean;
      if ((paramAccount != null) && (paramAccount.name != null) && (paramAccount.name.endsWith("@android-for-work.gserviceaccount.com")))
      {
        str = (String)j.d.b();
        this.d = 1;
        label70:
        this.b = new b(paramContext, paramAccount, str);
        this.c = parama;
        this.f.put("X-DFE-Device-Id", Long.toHexString(((Long)j.b.b()).longValue()));
        paramContext = this.f;
        paramAccount = paramLocale.getLanguage();
        parama = paramLocale.getCountry();
        paramLocale = new StringBuilder(String.valueOf(paramAccount).length() + 1 + String.valueOf(parama).length());
        paramLocale.append(paramAccount);
        paramLocale.append("-");
        paramLocale.append(parama);
        paramContext.put("Accept-Language", paramLocale.toString());
        if (!TextUtils.isEmpty(paramString3)) {
          this.f.put("X-DFE-MCCMNC", paramString3);
        }
        if (!TextUtils.isEmpty(paramString4)) {
          this.f.put("X-DFE-Client-Id", paramString4);
        }
        if (!TextUtils.isEmpty(paramString4)) {
          this.f.put("X-DFE-Logging-Id", paramString5);
        }
        paramContext = this.f;
        paramInt2 = VERSION.SDK_INT;
        paramString3 = Build.DEVICE;
        paramLocale = Build.HARDWARE;
        paramAccount = Build.PRODUCT;
        parama = b(paramString2);
        paramString2 = b(paramString3);
        paramLocale = b(paramLocale);
        paramAccount = b(paramAccount);
        paramContext.put("User-Agent", String.format(Locale.US, "Android-%s/%s (api=%d,versionCode=%d,sdk=%d,device=%s,hardware=%s,product=%s)", new Object[] { paramString1, parama, Integer.valueOf(4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2, paramLocale, paramAccount }));
        paramContext = d.a.toString();
        paramAccount = l.a(this.e, paramContext);
        if (paramAccount == null)
        {
          paramContext = String.valueOf(paramContext);
          if (paramContext.length() != 0) {
            break label623;
          }
        }
      }
    }
    label536:
    label623:
    for (paramContext = new String("BASE_URI blocked by UrlRules: ");; paramContext = "BASE_URI blocked by UrlRules: ".concat(paramContext))
    {
      throw new RuntimeException(paramContext);
      try
      {
        paramContext = new URL(paramAccount);
        if ((!paramContext.getProtocol().toLowerCase().equals("https")) && (!paramContext.getHost().toLowerCase().endsWith("corp.google.com")) && (!paramContext.getHost().toLowerCase().endsWith("prod.google.com")) && (!paramContext.getHost().startsWith("192.168.0")))
        {
          paramBoolean = paramContext.getHost().startsWith("127.0.0");
          if (!paramBoolean) {}
          do
          {
            paramContext = String.valueOf(paramAccount);
            if (paramContext.length() != 0) {
              break;
            }
            paramContext = new String("Insecure URL: ");
            throw new RuntimeException(paramContext);
            paramBoolean = k.a();
          } while (!paramBoolean);
        }
        return;
      }
      catch (MalformedURLException paramContext)
      {
        paramContext = String.valueOf(paramAccount);
        if (paramContext.length() != 0) {
          break label677;
        }
      }
      if (paramInt2 == 1) {
        break label54;
      }
      str = (String)j.c.b();
      this.d = 0;
      break label70;
      if (paramInt2 == 1) {
        break;
      }
      paramContext = new StringBuilder(30);
      paramContext.append("Unknown auth type: ");
      paramContext.append(paramInt2);
      throw new RuntimeException(paramContext.toString());
    }
    label677:
    for (paramContext = new String("Cannot parse URL: ");; paramContext = "Cannot parse URL: ".concat(paramContext))
    {
      PlayCommonLog.c(paramContext, new Object[0]);
      break;
      paramContext = "Insecure URL: ".concat(paramContext);
      break label536;
    }
  }
  
  public static e a(Context paramContext, String paramString, com.android.volley.a parama, Account paramAccount, int paramInt, boolean paramBoolean)
  {
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      String str = ((PackageInfo)localObject).versionName;
      int i = ((PackageInfo)localObject).versionCode;
      localObject = (TelephonyManager)paramContext.getSystemService("phone");
      paramContext = new e(paramContext, paramAccount, parama, paramString, str, i, Locale.getDefault(), ((TelephonyManager)localObject).getSimOperator(), (String)j.g.b(), (String)j.n.b(), paramInt, paramBoolean);
      return paramContext;
    }
    catch (NameNotFoundException paramContext)
    {
      throw new RuntimeException("Can't find our own package", paramContext);
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      h = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static String b(String paramString)
  {
    return Uri.encode(paramString).replace("(", "%28").replace(")", "%29");
  }
  
  private static String c()
  {
    try
    {
      String str = h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a()
  {
    String str = this.g;
    if (str != null)
    {
      this.b.a(str);
      this.g = null;
    }
  }
  
  public final Map b()
  {
    for (;;)
    {
      HashMap localHashMap;
      try
      {
        this.g = this.b.a();
        localHashMap = new HashMap();
        localHashMap.putAll(this.f);
        switch (this.d)
        {
        case 1: 
          str1 = c();
          if ((str1 != null) && (this.a)) {
            localHashMap.put("x-obscura-nonce", str1);
          }
          return localHashMap;
        }
      }
      finally {}
      String str1 = String.valueOf(this.g);
      if (str1.length() == 0)
      {
        str1 = new String("Bearer ");
        localHashMap.put("Authorization", str1);
      }
      else
      {
        String str3 = "Bearer ".concat(str2);
        continue;
        str3 = String.valueOf(this.g);
        if (str3.length() == 0) {}
        for (str3 = new String("GoogleLogin auth=");; str3 = "GoogleLogin auth=".concat(str3))
        {
          localHashMap.put("Authorization", str3);
          break;
        }
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[PlayDfeApiContext headers={");
    Iterator localIterator = this.f.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i == 0) {
        localStringBuilder.append(", ");
      }
      for (;;)
      {
        localStringBuilder.append(str);
        localStringBuilder.append(": ");
        localStringBuilder.append((String)this.f.get(str));
        break;
        i = 0;
      }
    }
    localStringBuilder.append("}]");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/play/dfe/api/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */