package com.tencent.mm.compatible.util;

import android.os.SystemClock;
import com.tencent.gmtrace.GMTrace;

public final class g
{
  public static int sb()
  {
    GMTrace.i(13787516108800L, 102725);
    int i = new Throwable().getStackTrace()[1].getLineNumber();
    GMTrace.o(13787516108800L, 102725);
    return i;
  }
  
  public static String sc()
  {
    GMTrace.i(13787650326528L, 102726);
    String str = new Throwable().getStackTrace()[1].toString();
    GMTrace.o(13787650326528L, 102726);
    return str;
  }
  
  public static String sd()
  {
    GMTrace.i(13787784544256L, 102727);
    Object localObject = new Throwable().getStackTrace()[1];
    int i = ((StackTraceElement)localObject).getMethodName().lastIndexOf('.');
    localObject = ((StackTraceElement)localObject).getMethodName().substring(i + 1) + "(" + ((StackTraceElement)localObject).getFileName() + ":" + ((StackTraceElement)localObject).getLineNumber() + ")";
    GMTrace.o(13787784544256L, 102727);
    return (String)localObject;
  }
  
  public static final class a
  {
    public long gSE;
    
    public a()
    {
      GMTrace.i(13788455632896L, 102732);
      this.gSE = SystemClock.elapsedRealtime();
      GMTrace.o(13788455632896L, 102732);
    }
    
    public final long se()
    {
      GMTrace.i(13788589850624L, 102733);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.gSE;
      GMTrace.o(13788589850624L, 102733);
      return l1 - l2;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/util/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */