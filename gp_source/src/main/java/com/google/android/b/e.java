package com.google.android.b;

import android.content.ContentResolver;
import android.net.Uri;

public final class e
  extends c
{
  public static final Uri a = Uri.parse("content://com.google.settings/partner");
  
  public static String a(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    paramContentResolver = a(paramContentResolver, a, paramString1);
    if (paramContentResolver != null) {
      paramString2 = paramContentResolver;
    }
    return paramString2;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */