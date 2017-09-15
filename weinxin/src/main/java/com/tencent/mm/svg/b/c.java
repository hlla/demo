package com.tencent.mm.svg.b;

import com.tencent.gmtrace.GMTrace;

public final class c
{
  private static a uLJ;
  
  static
  {
    GMTrace.i(3481070993408L, 25936);
    uLJ = null;
    GMTrace.o(3481070993408L, 25936);
  }
  
  public static void b(a parama)
  {
    GMTrace.i(3480399904768L, 25931);
    uLJ = parama;
    GMTrace.o(3480399904768L, 25931);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    GMTrace.i(3480802557952L, 25934);
    if (uLJ != null) {
      uLJ.d(paramString1, paramString2, paramVarArgs);
    }
    GMTrace.o(3480802557952L, 25934);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    GMTrace.i(3480534122496L, 25932);
    if (uLJ != null) {
      uLJ.e(paramString1, paramString2, paramVarArgs);
    }
    GMTrace.o(3480534122496L, 25932);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    GMTrace.i(3480668340224L, 25933);
    if (uLJ != null) {
      uLJ.i(paramString1, paramString2, paramVarArgs);
    }
    GMTrace.o(3480668340224L, 25933);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    GMTrace.i(3480936775680L, 25935);
    if (uLJ != null) {
      uLJ.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    GMTrace.o(3480936775680L, 25935);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/svg/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */