package com.google.android.play.utils.b;

import android.content.Context;

public abstract class a
{
  public static volatile h b = null;
  public final String a;
  
  a(String paramString)
  {
    this.a = paramString;
  }
  
  public static a a(String paramString, Boolean paramBoolean)
  {
    return new b(paramString, paramString, paramBoolean);
  }
  
  public static a a(String paramString, Float paramFloat)
  {
    return new e(paramString, paramString, paramFloat);
  }
  
  public static a a(String paramString, Integer paramInteger)
  {
    return new d(paramString, paramString, paramInteger);
  }
  
  public static a a(String paramString, Long paramLong)
  {
    return new c(paramString, paramString, paramLong);
  }
  
  public static a a(String paramString1, String paramString2)
  {
    return new f(paramString1, paramString1, paramString2);
  }
  
  public static void a(Context paramContext, String[] paramArrayOfString)
  {
    b = new i(paramContext.getContentResolver(), paramArrayOfString);
  }
  
  public static boolean a()
  {
    return b != null;
  }
  
  public static a b(String paramString1, String paramString2)
  {
    return new g(paramString1, paramString1, paramString2);
  }
  
  public abstract Object b();
  
  public String toString()
  {
    String str1 = this.a;
    String str2 = String.valueOf(b());
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 1 + String.valueOf(str2).length());
    localStringBuilder.append(str1);
    localStringBuilder.append(":");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/play/utils/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */