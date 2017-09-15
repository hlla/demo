package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;

public final class i
{
  public static volatile int wSs = -1;
  private static i wSt = null;
  a wSp = null;
  boolean wSq = false;
  private final int wSr = 3;
  
  public static i cdS()
  {
    if (wSt == null) {
      wSt = new i();
    }
    return wSt;
  }
  
  final void a(Context paramContext, int paramInt, Throwable paramThrowable)
  {
    for (;;)
    {
      try
      {
        if (wSs == -1)
        {
          wSs = paramInt;
          TbsLog.addLog(998, "code=%d,desc=%s", new Object[] { Integer.valueOf(paramInt), String.valueOf(paramThrowable) });
          if (paramThrowable != null)
          {
            r localr = r.gr(paramContext);
            paramContext = "NULL";
            if (paramThrowable != null)
            {
              paramThrowable = "msg: " + paramThrowable.getMessage() + "; err: " + paramThrowable + "; cause: " + Log.getStackTraceString(paramThrowable.getCause());
              paramContext = paramThrowable;
              if (paramThrowable.length() > 1024) {
                paramContext = paramThrowable.substring(0, 1024);
              }
            }
            localr.aM(paramInt, paramContext);
          }
        }
        else
        {
          paramContext = new StringBuilder("setLoadErrorCode :: error(");
          paramContext.append(wSs);
          paramContext.append(") was already reported; ");
          paramContext.append(paramInt);
          paramContext.append(" is duplicated. Try to remove it!");
          TbsLog.w("TbsCoreLoadStat", paramContext.toString());
          continue;
        }
        TbsLog.e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + paramInt + "; Check & correct it!");
      }
      finally {}
    }
  }
  
  final void ai(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, null);
    TbsLog.e("loaderror", String.valueOf(paramInt));
  }
  
  public final class a
  {
    int[] wSu;
    int wSv;
    int wSw;
    
    public final String toString()
    {
      if (this.wSw == this.wSv) {}
      for (int i = 1; i != 0; i = 0) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder("[");
      i = this.wSv;
      while (i < this.wSw)
      {
        localStringBuilder.append(String.valueOf(this.wSu[i]) + ",");
        i += 1;
      }
      i = localStringBuilder.length();
      return "]";
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */