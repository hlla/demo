package com.tencent.mm.vending.f;

import com.tencent.gmtrace.GMTrace;

public final class a
{
  private static a wAD;
  
  static
  {
    GMTrace.i(278770221056L, 2077);
    wAD = null;
    GMTrace.o(278770221056L, 2077);
  }
  
  public static void a(a parama)
  {
    GMTrace.i(277964914688L, 2071);
    wAD = parama;
    GMTrace.o(277964914688L, 2071);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    GMTrace.i(278501785600L, 2075);
    if (wAD != null) {
      wAD.d(paramString1, paramString2, paramVarArgs);
    }
    GMTrace.o(278501785600L, 2075);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    GMTrace.i(278099132416L, 2072);
    if (wAD != null) {
      wAD.e(paramString1, paramString2, paramVarArgs);
    }
    GMTrace.o(278099132416L, 2072);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    GMTrace.i(278367567872L, 2074);
    if (wAD != null) {
      wAD.i(paramString1, paramString2, paramVarArgs);
    }
    GMTrace.o(278367567872L, 2074);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    GMTrace.i(278636003328L, 2076);
    if (wAD != null) {
      wAD.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    GMTrace.o(278636003328L, 2076);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    GMTrace.i(278233350144L, 2073);
    if (wAD != null) {
      wAD.w(paramString1, paramString2, paramVarArgs);
    }
    GMTrace.o(278233350144L, 2073);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/vending/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */