package com.tencent.recovery.crash;

import com.tencent.recovery.Recovery;
import com.tencent.recovery.log.RecoveryLog;

public class JNICrashHandler
{
  private static final String TAG = "Recovery.JNICrashHandler";
  
  private static void onCrash()
  {
    RecoveryLog.i("Recovery.JNICrashHandler", "onCrash", new Object[0]);
    Recovery.cdj();
  }
  
  public static native void testSignal(int paramInt);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/crash/JNICrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */