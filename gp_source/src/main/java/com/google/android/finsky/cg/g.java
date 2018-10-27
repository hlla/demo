package com.google.android.finsky.cg;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;

public final class g
{
  private static final String[] a = new String[0];
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "localappstate.db";
    }
    paramString = Uri.encode(paramString);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 17);
    localStringBuilder.append("node-appstate-");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".db");
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext.deleteDatabase(a(paramString));
  }
  
  public static String[] getDatabaseNodes(Context paramContext)
  {
    String[] arrayOfString = paramContext.databaseList();
    int j = arrayOfString.length;
    int i = 0;
    paramContext = null;
    if (i < j)
    {
      String str = arrayOfString[i];
      Object localObject = paramContext;
      if (str.startsWith("node-appstate-"))
      {
        if (str.endsWith(".db")) {
          break label58;
        }
        localObject = paramContext;
      }
      for (;;)
      {
        i += 1;
        paramContext = (Context)localObject;
        break;
        label58:
        localObject = paramContext;
        if (paramContext == null) {
          localObject = new ArrayList();
        }
        ((ArrayList)localObject).add(Uri.decode(str.substring(14, str.length() - 3)));
      }
    }
    if (paramContext != null) {
      return (String[])paramContext.toArray(new String[paramContext.size()]);
    }
    return a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cg/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */