package com.tencent.mm.kernel;

import com.tencent.gmtrace.GMTrace;

public final class j
{
  private static volatile a gZa;
  
  static
  {
    GMTrace.i(18792763621376L, 140017);
    gZa = null;
    GMTrace.o(18792763621376L, 140017);
  }
  
  public static void a(a parama)
  {
    GMTrace.i(18792092532736L, 140012);
    gZa = parama;
    GMTrace.o(18792092532736L, 140012);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    GMTrace.i(18792226750464L, 140013);
    if (gZa != null) {
      gZa.e(paramString1, paramString2, paramVarArgs);
    }
    GMTrace.o(18792226750464L, 140013);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    GMTrace.i(18792495185920L, 140015);
    if (gZa != null) {
      gZa.i(paramString1, paramString2, paramVarArgs);
    }
    GMTrace.o(18792495185920L, 140015);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    GMTrace.i(18792629403648L, 140016);
    if (gZa != null) {
      gZa.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    GMTrace.o(18792629403648L, 140016);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    GMTrace.i(18792360968192L, 140014);
    if (gZa != null) {
      gZa.w(paramString1, paramString2, paramVarArgs);
    }
    GMTrace.o(18792360968192L, 140014);
  }
  
  public static abstract interface a
  {
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kernel/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */