package com.tencent.recovery.log;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.recovery.storage.MMappedFileStorage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecoveryFileLog
  implements RecoveryLog.RecoveryLogImpl
{
  private MMappedFileStorage wOh;
  private SimpleDateFormat wOi;
  private boolean wOj;
  
  public RecoveryFileLog(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), "recovery");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    paramContext = new File(paramContext, "recovery.log");
    if (paramContext.length() > 5242880L) {
      paramContext.delete();
    }
    this.wOh = new MMappedFileStorage(paramContext.getAbsolutePath());
    this.wOi = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
  }
  
  private String ae(String paramString1, String paramString2, String paramString3)
  {
    String str = this.wOi.format(new Date());
    return String.format("%s​%s​[%d][%d][%s]: %s​​", new Object[] { paramString1, paramString2, Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()), str, paramString3 });
  }
  
  public final void If()
  {
    this.wOj = true;
  }
  
  public final void bc(String paramString, boolean paramBoolean)
  {
    try
    {
      this.wOh.c(paramString.getBytes(), paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    bc(ae("D", paramString1, String.format(paramString2, paramVarArgs)), false);
    if (this.wOj) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    bc(ae("E", paramString1, String.format(paramString2, paramVarArgs)), false);
    if (this.wOj) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public final void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    bc(ae("I", paramString1, String.format(paramString2, paramVarArgs)), false);
    if (this.wOj) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public final void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    String str = String.format(paramString2, paramVarArgs);
    bc(ae("E", paramString1, str + "  " + Log.getStackTraceString(paramThrowable)), false);
    if (this.wOj) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public final void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    bc(ae("V", paramString1, String.format(paramString2, paramVarArgs)), false);
    if (this.wOj) {
      String.format(paramString2, paramVarArgs);
    }
  }
  
  public final void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    bc(ae("W", paramString1, String.format(paramString2, paramVarArgs)), false);
    if (this.wOj) {
      String.format(paramString2, paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/log/RecoveryFileLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */