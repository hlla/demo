package com.google.android.common.http;

import java.util.regex.Pattern;

public final class c
  implements Comparable
{
  public static final c a = new c();
  public final String b;
  public final String c;
  private final boolean d;
  private final String e;
  
  private c()
  {
    this.b = "DEFAULT";
    this.c = "";
    this.e = null;
    this.d = false;
  }
  
  public c(String paramString1, String paramString2)
  {
    this.b = paramString1;
    String[] arrayOfString = UrlRules.a.split(paramString2);
    if (arrayOfString.length == 0) {
      throw new UrlRules.RuleFormatException("Empty rule");
    }
    this.c = arrayOfString[0];
    paramString1 = null;
    int i = 1;
    for (;;)
    {
      int j = arrayOfString.length;
      if (i >= j) {
        break;
      }
      String str = arrayOfString[i].toLowerCase();
      if (!str.equals("rewrite")) {}
      int k;
      do
      {
        if (!str.equals("block")) {
          break label136;
        }
        i += 1;
        bool = true;
        break;
        k = i + 1;
      } while (k >= j);
      paramString1 = arrayOfString[k];
      i += 2;
    }
    this.e = paramString1;
    this.d = bool;
    return;
    label136:
    paramString1 = new StringBuilder();
    paramString1.append("Illegal rule: ");
    paramString1.append(paramString2);
    throw new UrlRules.RuleFormatException(paramString1.toString());
  }
  
  public final String a(String paramString)
  {
    if (!this.d)
    {
      Object localObject = paramString;
      if (this.e != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(paramString.substring(this.c.length()));
        localObject = ((StringBuilder)localObject).toString();
      }
      return (String)localObject;
    }
    return null;
  }
  
  public final int compareTo(Object paramObject)
  {
    return ((c)paramObject).c.compareTo(this.c);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/common/http/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */