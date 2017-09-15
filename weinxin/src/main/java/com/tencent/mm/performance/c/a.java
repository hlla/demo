package com.tencent.mm.performance.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.performance.d.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static a ifZ;
  public static b iga;
  
  static
  {
    GMTrace.i(13128909717504L, 97818);
    ifZ = new a((byte)0);
    iga = null;
    GMTrace.o(13128909717504L, 97818);
  }
  
  public static void bl(Context paramContext)
  {
    GMTrace.i(13128641282048L, 97816);
    v.i("MicroMsg.HprofAnalyzerComm", "register receiver is called.");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("ha_resp_action_send_result");
    paramContext.registerReceiver(ifZ, localIntentFilter, "com.tencent.mm.debug.RECV_CMD", null);
    GMTrace.o(13128641282048L, 97816);
  }
  
  public static void h(Context paramContext, String paramString1, String paramString2)
  {
    GMTrace.i(13128507064320L, 97815);
    Intent localIntent = new Intent();
    localIntent.putExtra("ha_version", 2);
    localIntent.putExtra("ha_hprof_filepath", paramString1);
    localIntent.putExtra("ha_obj_key", paramString2);
    localIntent.putExtra("ha_weakref_with_key_class", d.class.getName());
    paramString2 = "mKey";
    Field[] arrayOfField = d.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      if (localField.getAnnotation(com.tencent.mm.performance.d.b.class) != null) {
        paramString2 = localField.getName();
      }
      i += 1;
    }
    v.i("MicroMsg.HprofAnalyzerComm", "weakRef key field name: %s", new Object[] { paramString2 });
    localIntent.putExtra("ha_weakref_key_attr_name", paramString2);
    localIntent.setClassName("com.tencent.mm.coolassist", "com.tencent.mm.coolassist.hprofanalyzer.BroadcastCmdReceiver");
    localIntent.setAction("ha_action_analyze_hprof");
    try
    {
      paramContext.sendBroadcast(localIntent, "com.tencent.mm.debug.RECV_CMD");
      e.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(17801699917824L, 132633);
          File[] arrayOfFile = new File(this.igb).getParentFile().listFiles(new FilenameFilter()
          {
            public final boolean accept(File paramAnonymous2File, String paramAnonymous2String)
            {
              GMTrace.i(17801968353280L, 132635);
              boolean bool = paramAnonymous2String.endsWith(".hprof");
              GMTrace.o(17801968353280L, 132635);
              return bool;
            }
          });
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            File localFile = arrayOfFile[i];
            if (System.currentTimeMillis() - localFile.lastModified() > TimeUnit.DAYS.toMillis(1L)) {
              localFile.delete();
            }
            i += 1;
          }
          GMTrace.o(17801699917824L, 132633);
        }
      }, "clean_old_hprof");
      GMTrace.o(13128507064320L, 97815);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.HprofAnalyzerComm", paramContext, "Failed to wake up hprof analyzer app.", new Object[0]);
      }
    }
  }
  
  public static boolean isEnabled()
  {
    GMTrace.i(13128775499776L, 97817);
    boolean bool = com.tencent.mm.sdk.a.b.bIi();
    GMTrace.o(13128775499776L, 97817);
    return bool;
  }
  
  private static final class a
    extends BroadcastReceiver
  {
    private a()
    {
      GMTrace.i(13129715023872L, 97824);
      GMTrace.o(13129715023872L, 97824);
    }
    
    public final void onReceive(final Context paramContext, Intent paramIntent)
    {
      GMTrace.i(13129849241600L, 97825);
      paramContext = paramIntent.getAction();
      v.i("MicroMsg.HARespReceiver", "received cmd: %s", new Object[] { paramContext });
      if ("ha_resp_action_send_result".equals(paramContext))
      {
        int i = paramIntent.getIntExtra("ha_version", -1);
        if (i == 2)
        {
          paramContext = paramIntent.getExtras().getString("ha_hprof_filepath");
          String str = paramIntent.getExtras().getString("ha_obj_class");
          Object localObject = paramIntent.getExtras().getString("ha_obj_key");
          paramIntent = paramIntent.getExtras().getString("ha_result_refchain_logstr");
          if ((paramIntent == null) || (paramIntent.length() == 0)) {
            v.e("MicroMsg.HARespReceiver", "object '%s' with key '%s' is not leaked, sometimes his method may hit this wrong case.", new Object[] { str, localObject });
          }
          for (;;)
          {
            e.post(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(13129178152960L, 97820);
                new File(paramContext).delete();
                GMTrace.o(13129178152960L, 97820);
              }
            }, "del_hprof_file");
            GMTrace.o(13129849241600L, 97825);
            return;
            v.i("MicroMsg.HARespReceiver", "analyse result: key:%s, class:%s, refchain:%s", new Object[] { localObject, str, paramIntent });
            localObject = new HashMap();
            ((Map)localObject).put("leaked_activity", str);
            if (a.iga != null) {
              a.iga.a("UILeaksV2", paramIntent, (Map)localObject);
            } else {
              v.e("MicroMsg.HARespReceiver", "no report impl set!");
            }
          }
        }
        v.e("MicroMsg.HARespReceiver", "analyzer version mismatch, expected: %s, actual: %s, ignored.", new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
        GMTrace.o(13129849241600L, 97825);
        return;
      }
      v.e("MicroMsg.HARespReceiver", "unknown command: %s", new Object[] { paramContext });
      GMTrace.o(13129849241600L, 97825);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/performance/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */