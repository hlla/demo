package com.google.android.common.http;

import android.content.ContentResolver;
import android.util.Log;
import com.google.android.b.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UrlRules
{
  public static final Pattern a = Pattern.compile(" +");
  private static final Pattern b = Pattern.compile("\\W");
  private static UrlRules e = new UrlRules(new c[0]);
  private static Object f;
  private final Pattern c;
  private final c[] d;
  
  private UrlRules(c[] paramArrayOfc)
  {
    Arrays.sort(paramArrayOfc);
    StringBuilder localStringBuilder = new StringBuilder("(");
    int i = 0;
    if (i < paramArrayOfc.length)
    {
      if (i <= 0) {}
      for (;;)
      {
        localStringBuilder.append(b.matcher(paramArrayOfc[i].c).replaceAll("\\\\$0"));
        i += 1;
        break;
        localStringBuilder.append(")|(");
      }
    }
    localStringBuilder.append(")");
    this.c = Pattern.compile(localStringBuilder.toString());
    this.d = paramArrayOfc;
  }
  
  public static UrlRules a(ContentResolver paramContentResolver)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      try
      {
        localObject1 = g.a(paramContentResolver);
        if (localObject1 == f)
        {
          if (Log.isLoggable("UrlRules", 2))
          {
            paramContentResolver = new StringBuilder();
            paramContentResolver.append("Using cached rules, versionToken: ");
            paramContentResolver.append(localObject1);
            Log.v("UrlRules", paramContentResolver.toString());
          }
          paramContentResolver = e;
          return paramContentResolver;
        }
        if (Log.isLoggable("UrlRules", 2)) {
          Log.v("UrlRules", "Scanning for Gservices \"url:*\" rules");
        }
        Object localObject2 = g.a(paramContentResolver, new String[] { "url:" });
        paramContentResolver = new ArrayList();
        localObject2 = ((Map)localObject2).entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label275;
        }
        localObject3 = (Entry)((Iterator)localObject2).next();
        try
        {
          String str = ((String)((Entry)localObject3).getKey()).substring(4);
          localObject3 = (String)((Entry)localObject3).getValue();
          if ((localObject3 == null) || (((String)localObject3).length() == 0)) {
            continue;
          }
          if (Log.isLoggable("UrlRules", 2)) {
            break label221;
          }
          paramContentResolver.add(new c(str, (String)localObject3));
        }
        catch (UrlRules.RuleFormatException localRuleFormatException)
        {
          Log.e("UrlRules", "Invalid rule from Gservices", localRuleFormatException);
        }
        continue;
        localStringBuilder = new StringBuilder();
      }
      finally {}
      label221:
      StringBuilder localStringBuilder;
      localStringBuilder.append("  Rule ");
      localStringBuilder.append(localRuleFormatException);
      localStringBuilder.append(": ");
      localStringBuilder.append((String)localObject3);
      Log.v("UrlRules", localStringBuilder.toString());
      continue;
      label275:
      e = new UrlRules((c[])paramContentResolver.toArray(new c[paramContentResolver.size()]));
      f = localObject1;
      if (Log.isLoggable("UrlRules", 2))
      {
        paramContentResolver = new StringBuilder();
        paramContentResolver.append("New rules stored, versionToken: ");
        paramContentResolver.append(localObject1);
        Log.v("UrlRules", paramContentResolver.toString());
      }
      paramContentResolver = e;
    }
  }
  
  public final c a(String paramString)
  {
    paramString = this.c.matcher(paramString);
    if (paramString.lookingAt())
    {
      int i = 0;
      while (i < this.d.length)
      {
        int j = i + 1;
        if (paramString.group(j) == null) {
          i = j;
        } else {
          return this.d[i];
        }
      }
    }
    return c.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/common/http/UrlRules.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */