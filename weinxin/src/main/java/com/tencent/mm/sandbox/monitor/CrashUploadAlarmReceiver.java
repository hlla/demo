package com.tencent.mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public class CrashUploadAlarmReceiver
  extends BroadcastReceiver
{
  public CrashUploadAlarmReceiver()
  {
    GMTrace.i(3600524771328L, 26826);
    GMTrace.o(3600524771328L, 26826);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(3600658989056L, 26827);
    v.d("MicroMsg.CrashUploadAlarmReceiver", "dkcrash AlarmReceiver.onReceive");
    if (a.bHB() == 0) {
      ExceptionMonitorService.dR(paramContext);
    }
    GMTrace.o(3600658989056L, 26827);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/monitor/CrashUploadAlarmReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */