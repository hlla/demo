package com.tencent.wework.api.utils;

public class Log
{
  private static int wMN = 8;
  private static ILogger xjZ = new WWAPILogger(new LogcatLogger());
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (wMN <= 5) {
      xjZ.a(5, paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (wMN <= 3) {
      xjZ.a(3, paramString1, paramString2, null);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (wMN <= 6) {
      xjZ.a(6, paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (wMN <= 4) {
      xjZ.a(4, paramString1, paramString2, null);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (wMN <= 5) {
      xjZ.a(5, paramString1, paramString2, null);
    }
  }
  
  public static abstract interface ILogger
  {
    public abstract void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable);
  }
  
  private static class LogcatLogger
    implements Log.ILogger
  {
    public final void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable) {}
  }
  
  private static class WWAPILogger
    implements Log.ILogger
  {
    Log.ILogger xka;
    
    WWAPILogger(Log.ILogger paramILogger)
    {
      this.xka = paramILogger;
    }
    
    public final void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
    {
      this.xka.a(paramInt, "WWAPI-" + paramString1, paramString2, paramThrowable);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/wework/api/utils/Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */