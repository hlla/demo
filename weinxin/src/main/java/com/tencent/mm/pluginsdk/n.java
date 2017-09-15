package com.tencent.mm.pluginsdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.ui.d.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
{
  private static final AtomicInteger sAc;
  
  static
  {
    GMTrace.i(886642311168L, 6606);
    sAc = new AtomicInteger(0);
    GMTrace.o(886642311168L, 6606);
  }
  
  public static void bCm()
  {
    GMTrace.i(14301704224768L, 106556);
    if (!aa.bIT())
    {
      GMTrace.o(14301704224768L, 106556);
      return;
    }
    sAc.getAndSet(0);
    GMTrace.o(14301704224768L, 106556);
  }
  
  public static boolean isLocked()
  {
    GMTrace.i(886239657984L, 6603);
    if (sAc.get() > 0)
    {
      GMTrace.o(886239657984L, 6603);
      return true;
    }
    GMTrace.o(886239657984L, 6603);
    return false;
  }
  
  public static void lock()
  {
    GMTrace.i(886373875712L, 6604);
    if (aa.bIT())
    {
      sAc.incrementAndGet();
      GMTrace.o(886373875712L, 6604);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(d.g.uMO, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_LOCK_TOOLS_PROCESS");
    aa.getContext().sendBroadcast(localIntent);
    GMTrace.o(886373875712L, 6604);
  }
  
  public static void unlock()
  {
    GMTrace.i(886508093440L, 6605);
    if (aa.getContext() == null)
    {
      GMTrace.o(886508093440L, 6605);
      return;
    }
    Object localObject = (ActivityManager)aa.getContext().getSystemService("activity");
    if (localObject == null)
    {
      GMTrace.o(886508093440L, 6605);
      return;
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (bf.bV((List)localObject))
    {
      GMTrace.o(886508093440L, 6605);
      return;
    }
    localObject = ((List)localObject).iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (!"com.tencent.mm:tools".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (aa.bIT())
        {
          sAc.decrementAndGet();
          GMTrace.o(886508093440L, 6605);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).setComponent(new ComponentName(d.g.uMO, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        ((Intent)localObject).putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_UNLOCK_TOOLS_PROCESS");
        aa.getContext().sendBroadcast((Intent)localObject);
      }
      GMTrace.o(886508093440L, 6605);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */