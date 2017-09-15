package com.tencent.recovery.log;

import java.util.ArrayList;
import java.util.List;

public class RecoveryCacheLog
  implements RecoveryLog.RecoveryLogImpl
{
  List<LogItem> wOc = new ArrayList(100);
  
  public final void If() {}
  
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.wOc.size() < 100)
    {
      LogItem localLogItem = new LogItem();
      localLogItem.level = 2;
      localLogItem.tag = paramString1;
      localLogItem.wOd = paramString2;
      localLogItem.wOe = paramVarArgs;
      this.wOc.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.wOc.size() < 100)
    {
      LogItem localLogItem = new LogItem();
      localLogItem.level = 5;
      localLogItem.tag = paramString1;
      localLogItem.wOd = paramString2;
      localLogItem.wOe = paramVarArgs;
      this.wOc.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.wOc.size() < 100)
    {
      LogItem localLogItem = new LogItem();
      localLogItem.level = 3;
      localLogItem.tag = paramString1;
      localLogItem.wOd = paramString2;
      localLogItem.wOe = paramVarArgs;
      this.wOc.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (this.wOc.size() < 100)
    {
      LogItem localLogItem = new LogItem();
      localLogItem.level = 5;
      localLogItem.tag = paramString1;
      localLogItem.wOd = paramString2;
      localLogItem.wOe = paramVarArgs;
      localLogItem.wOf = paramThrowable;
      this.wOc.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.wOc.size() < 100)
    {
      LogItem localLogItem = new LogItem();
      localLogItem.level = 1;
      localLogItem.tag = paramString1;
      localLogItem.wOd = paramString2;
      localLogItem.wOe = paramVarArgs;
      this.wOc.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (this.wOc.size() < 100)
    {
      LogItem localLogItem = new LogItem();
      localLogItem.level = 4;
      localLogItem.tag = paramString1;
      localLogItem.wOd = paramString2;
      localLogItem.wOe = paramVarArgs;
      this.wOc.add(localLogItem);
    }
    String.format(paramString2, paramVarArgs);
  }
  
  private class LogItem
  {
    int level;
    String tag;
    String wOd;
    Object[] wOe;
    Throwable wOf;
    
    public LogItem() {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/log/RecoveryCacheLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */