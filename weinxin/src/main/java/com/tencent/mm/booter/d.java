package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.QbSdk;

public final class d
{
  public static final class a
    implements MMReceivers.a
  {
    public a()
    {
      GMTrace.i(504792875008L, 3761);
      GMTrace.o(504792875008L, 3761);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      GMTrace.i(504927092736L, 3762);
      if ((paramContext == null) || (paramIntent == null))
      {
        GMTrace.o(504927092736L, 3762);
        return;
      }
      v.i("MicroMsg.SandBoxProcessReceiver", "onReceive");
      QbSdk.reset(paramContext);
      ae.f(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(497545117696L, 3707);
          Process.killProcess(Process.myPid());
          GMTrace.o(497545117696L, 3707);
        }
      }, 5000L);
      GMTrace.o(504927092736L, 3762);
    }
  }
  
  public static final class b
    implements MMReceivers.a
  {
    public b()
    {
      GMTrace.i(496605593600L, 3700);
      GMTrace.o(496605593600L, 3700);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      GMTrace.i(496739811328L, 3701);
      if ((paramContext == null) || (paramIntent == null))
      {
        GMTrace.o(496739811328L, 3701);
        return;
      }
      String str = paramIntent.getStringExtra("tools_process_action_code_key");
      v.i("MicroMsg.ToolsProcessReceiver", "onReceive, action = " + str);
      boolean bool;
      if (str.equals("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS"))
      {
        v.bIG();
        bool = n.isLocked();
        v.i("MicroMsg.ToolsProcessReceiver", "onReceive, ACTION_KILL_TOOLS_PROCESS, x5 kernel video isLocked = %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          Process.killProcess(Process.myPid());
        }
        GMTrace.o(496739811328L, 3701);
        return;
      }
      if (str.equals("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE")) {
        try
        {
          QbSdk.clearAllWebViewCache(paramContext.getApplicationContext(), true);
          GMTrace.o(496739811328L, 3701);
          return;
        }
        catch (Exception paramContext)
        {
          v.i("MicroMsg.ToolsProcessReceiver", "clear cookie faild : " + paramContext.getMessage());
          GMTrace.o(496739811328L, 3701);
          return;
        }
      }
      if (!str.equals("com.tencent.mm.intent.ACIONT_TOOLS_LOAD_DEX"))
      {
        if (str.equals("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE"))
        {
          bool = paramIntent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true);
          v.i("MicroMsg.ToolsProcessReceiver", "WebViewCacheClearTask, clearAllWebViewCache, includeCookie = %b", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            QbSdk.clearAllWebViewCache(paramContext.getApplicationContext(), true);
            GMTrace.o(496739811328L, 3701);
            return;
          }
          QbSdk.clearAllWebViewCache(paramContext.getApplicationContext(), false);
          GMTrace.o(496739811328L, 3701);
          return;
        }
        if (str.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS"))
        {
          v.i("MicroMsg.ToolsProcessReceiver", "start tools process task, try to pre load tbs");
          w.bCC();
          GMTrace.o(496739811328L, 3701);
          return;
        }
        if (str.equals("com.tencent.mm.intent.ACTION_LOCK_TOOLS_PROCESS"))
        {
          n.lock();
          GMTrace.o(496739811328L, 3701);
          return;
        }
        if (str.equals("com.tencent.mm.intent.ACTION_UNLOCK_TOOLS_PROCESS"))
        {
          n.unlock();
          GMTrace.o(496739811328L, 3701);
          return;
        }
        if (str.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS_DO_NOTHING"))
        {
          v.i("MicroMsg.ToolsProcessReceiver", "start tools process and do nothing");
          GMTrace.o(496739811328L, 3701);
          return;
        }
        if (str.equals("com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE")) {
          w.Y(paramIntent);
        }
      }
      GMTrace.o(496739811328L, 3701);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */