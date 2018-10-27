package com.google.android.b;

import android.content.Intent;

public final class a
{
  static
  {
    new Intent().setPackage("com.google.android.gsf.login").setAction("com.google.android.gsf.action.GET_GLS").addCategory("android.intent.category.DEFAULT");
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("service_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */