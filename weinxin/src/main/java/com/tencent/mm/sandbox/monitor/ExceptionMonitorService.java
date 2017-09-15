package com.tencent.mm.sandbox.monitor;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public class ExceptionMonitorService
  extends Service
{
  public static long hnB;
  public static int uoc;
  private static ExceptionMonitorService uog;
  private long uod;
  private ad uoe;
  private Runnable uof;
  private long uoh;
  
  static
  {
    GMTrace.i(3604417085440L, 26855);
    uoc = 0;
    hnB = 0L;
    uog = null;
    GMTrace.o(3604417085440L, 26855);
  }
  
  public ExceptionMonitorService()
  {
    GMTrace.i(3603343343616L, 26847);
    this.uod = 300000L;
    this.uoe = new ad();
    this.uof = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(3600390553600L, 26825);
        v.d("MicroMsg.CrashMonitorService", "stopSelf");
        ExceptionMonitorService.this.stopSelf();
        GMTrace.o(3600390553600L, 26825);
      }
    };
    GMTrace.o(3603343343616L, 26847);
  }
  
  public static void dR(Context paramContext)
  {
    GMTrace.i(3604282867712L, 26854);
    Object localObject = new Intent(paramContext, CrashUploadAlarmReceiver.class);
    if (PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject, 536870912) == null)
    {
      localObject = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject, 0);
      paramContext = (AlarmManager)paramContext.getSystemService("alarm");
      long l = bf.NA() + 1800000L;
      paramContext.set(0, l, (PendingIntent)localObject);
      v.d("MicroMsg.CrashMonitorService", "dkcrash startAlarmMgr pendingIntent:%d %d", new Object[] { Integer.valueOf(((PendingIntent)localObject).hashCode()), Long.valueOf(l) });
    }
    GMTrace.o(3604282867712L, 26854);
  }
  
  private void k(Intent paramIntent)
  {
    GMTrace.i(3604014432256L, 26852);
    if (paramIntent == null)
    {
      GMTrace.o(3604014432256L, 26852);
      return;
    }
    this.uoe.removeCallbacks(this.uof);
    this.uoe.postDelayed(this.uof, this.uod);
    String str3 = paramIntent.getAction();
    v.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand action:" + str3);
    String str2;
    String str1;
    String str4;
    boolean bool;
    try
    {
      str2 = paramIntent.getStringExtra("tag");
      str1 = str2;
      if (str2 == null) {
        str1 = "exception";
      }
      int i = paramIntent.getIntExtra("exceptionPid", 0);
      str1.equals("exception");
      uoc = i;
      hnB = paramIntent.getLongExtra("exceptionTime", SystemClock.elapsedRealtime());
      str2 = paramIntent.getStringExtra("exceptionMsg");
      str4 = paramIntent.getStringExtra("userName");
      bool = paramIntent.getBooleanExtra("exceptionWriteSdcard", true);
      v.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand. action=" + str3 + " pid:" + i + " tag=" + str1 + ", userName=" + str4 + ", message" + str2);
      if (bf.mA(str2))
      {
        GMTrace.o(3604014432256L, 26852);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      v.printErrStackTrace("MicroMsg.CrashMonitorService", paramIntent, "", new Object[0]);
      GMTrace.o(3604014432256L, 26852);
      return;
    }
    if (a.a(str4, str1, new b.a(str4, str1, bf.Nz(), str2, bool)) == 0) {
      dR(this);
    }
    if (System.currentTimeMillis() - this.uoh > 600000L)
    {
      this.uoh = System.currentTimeMillis();
      e.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(18485941895168L, 137731);
          com.tencent.mm.modelrecovery.a.Ig();
          GMTrace.o(18485941895168L, 137731);
        }
      }, "RecoveryWriteLogThread");
    }
    GMTrace.o(3604014432256L, 26852);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    GMTrace.i(3604148649984L, 26853);
    GMTrace.o(3604148649984L, 26853);
    return null;
  }
  
  public void onCreate()
  {
    GMTrace.i(3603477561344L, 26848);
    super.onCreate();
    uog = this;
    c.f(hashCode(), this);
    this.uoe.postDelayed(this.uof, this.uod);
    GMTrace.o(3603477561344L, 26848);
  }
  
  public void onDestroy()
  {
    GMTrace.i(3603880214528L, 26851);
    super.onDestroy();
    uog = null;
    c.g(hashCode(), this);
    this.uoe.removeCallbacks(this.uof);
    GMTrace.o(3603880214528L, 26851);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    GMTrace.i(3603611779072L, 26849);
    super.onStart(paramIntent, paramInt);
    k(paramIntent);
    GMTrace.o(3603611779072L, 26849);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    GMTrace.i(3603745996800L, 26850);
    k(paramIntent);
    GMTrace.o(3603745996800L, 26850);
    return 1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/monitor/ExceptionMonitorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */