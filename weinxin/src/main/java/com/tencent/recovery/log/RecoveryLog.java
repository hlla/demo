package com.tencent.recovery.log;

import java.util.ArrayList;
import java.util.List;

public class RecoveryLog
{
  private static RecoveryLogImpl hOn = new RecoveryCacheLog();
  
  public static void If()
  {
    hOn.If();
  }
  
  public static void a(RecoveryLogImpl paramRecoveryLogImpl)
  {
    if ((hOn instanceof RecoveryCacheLog))
    {
      RecoveryCacheLog localRecoveryCacheLog = (RecoveryCacheLog)hOn;
      int j = localRecoveryCacheLog.wOc.size();
      int i = 0;
      if (i < j)
      {
        RecoveryCacheLog.LogItem localLogItem = (RecoveryCacheLog.LogItem)localRecoveryCacheLog.wOc.get(i);
        switch (localLogItem.level)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          paramRecoveryLogImpl.v(localLogItem.tag, localLogItem.wOd, localLogItem.wOe);
          continue;
          paramRecoveryLogImpl.d(localLogItem.tag, localLogItem.wOd, localLogItem.wOe);
          continue;
          paramRecoveryLogImpl.i(localLogItem.tag, localLogItem.wOd, localLogItem.wOe);
          continue;
          paramRecoveryLogImpl.w(localLogItem.tag, localLogItem.wOd, localLogItem.wOe);
          continue;
          if (localLogItem.wOf != null) {
            paramRecoveryLogImpl.printErrStackTrace(localLogItem.tag, localLogItem.wOf, localLogItem.wOd, localLogItem.wOe);
          } else {
            paramRecoveryLogImpl.e(localLogItem.tag, localLogItem.wOd, localLogItem.wOe);
          }
        }
      }
      localRecoveryCacheLog.wOc = new ArrayList();
    }
    hOn = paramRecoveryLogImpl;
  }
  
  public static void cdn()
  {
    if ((hOn instanceof RecoveryFileLog)) {
      ((RecoveryFileLog)hOn).bc("", true);
    }
  }
  
  public static RecoveryLogImpl cdo()
  {
    return hOn;
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (hOn != null) {
      hOn.e(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (hOn != null) {
      hOn.i(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (hOn != null) {
      hOn.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
  }
  
  public static abstract interface RecoveryLogImpl
  {
    public abstract void If();
    
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract void v(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/log/RecoveryLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */