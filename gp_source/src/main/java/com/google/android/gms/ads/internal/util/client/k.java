package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.ads.internal.q.a.a;

@a
public class k
{
  private static String a(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    Object localObject = paramString;
    if (arrayOfStackTraceElement.length >= 4)
    {
      int i = arrayOfStackTraceElement[3].getLineNumber();
      localObject = new StringBuilder(String.valueOf(paramString).length() + 13);
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" @");
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= 5) || (Log.isLoggable("Ads", paramInt));
  }
  
  public static void b(String paramString)
  {
    if (a(3)) {
      Log.d("Ads", paramString);
    }
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    if (a(3)) {
      Log.d("Ads", paramString, paramThrowable);
    }
  }
  
  public static void c(String paramString)
  {
    if (a(6)) {
      Log.e("Ads", paramString);
    }
  }
  
  public static void c(String paramString, Throwable paramThrowable)
  {
    if (a(6)) {
      Log.e("Ads", paramString, paramThrowable);
    }
  }
  
  public static void d(String paramString)
  {
    if (a(4)) {
      Log.i("Ads", paramString);
    }
  }
  
  public static void d(String paramString, Throwable paramThrowable)
  {
    if (a(4)) {
      Log.i("Ads", paramString, paramThrowable);
    }
  }
  
  public static void e(String paramString)
  {
    if (a(5)) {
      Log.w("Ads", paramString);
    }
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    if (a(5)) {
      Log.w("Ads", paramString, paramThrowable);
    }
  }
  
  public static void f(String paramString, Throwable paramThrowable)
  {
    if (a(5))
    {
      if (paramThrowable == null) {
        e(a(paramString));
      }
    }
    else {
      return;
    }
    e(a(paramString), paramThrowable);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/client/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */