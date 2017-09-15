package com.google.android.gms.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Binder;
import java.util.Iterator;
import java.util.List;

public final class aa
{
  public static String K(Context paramContext)
  {
    return m(paramContext, Binder.getCallingPid());
  }
  
  public static String cd(int paramInt)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 3;
    if (i < paramInt + 3)
    {
      if (i + 4 >= arrayOfStackTraceElement.length) {}
      for (Object localObject = "<bottom of call stack>";; localObject = ((StackTraceElement)localObject).getClassName() + "." + ((StackTraceElement)localObject).getMethodName() + ":" + ((StackTraceElement)localObject).getLineNumber())
      {
        localStringBuffer.append((String)localObject).append(" ");
        i += 1;
        break;
        localObject = arrayOfStackTraceElement[(i + 4)];
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String m(Context paramContext, int paramInt)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == paramInt) {
          return localRunningAppProcessInfo.processName;
        }
      }
    }
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/c/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */