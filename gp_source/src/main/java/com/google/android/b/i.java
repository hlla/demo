package com.google.android.b;

import android.content.ContentResolver;

public abstract class i
{
  public static ContentResolver c = null;
  public final Object a;
  public final String b;
  
  protected i(String paramString, Object paramObject)
  {
    this.b = paramString;
    this.a = paramObject;
  }
  
  public static i a(String paramString, Integer paramInteger)
  {
    return new l(paramString, paramInteger);
  }
  
  public static i a(String paramString, Long paramLong)
  {
    return new k(paramString, paramLong);
  }
  
  public static i a(String paramString1, String paramString2)
  {
    return new m(paramString1, paramString2);
  }
  
  public static i a(String paramString, boolean paramBoolean)
  {
    return new j(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public abstract Object a();
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */