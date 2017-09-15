package com.tencent.mm.plugin.report.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;

public class KVCommCrossProcessReceiver
  extends BroadcastReceiver
{
  private static String className;
  private static Object lock;
  private static ad oSe;
  private static int oSf;
  private static volatile long oSg;
  private static volatile int oSh;
  private static BroadCastData oSi;
  
  static
  {
    GMTrace.i(13117635428352L, 97734);
    HandlerThread localHandlerThread = com.tencent.mm.sdk.f.e.Qt("kv_report");
    localHandlerThread.start();
    oSe = new ad(localHandlerThread.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(14895215017984L, 110978);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 1) {
          KVCommCrossProcessReceiver.aXy();
        }
        GMTrace.o(14895215017984L, 110978);
      }
    };
    className = "";
    oSf = 10000;
    oSg = 10000L;
    oSh = -1;
    oSi = new BroadCastData();
    lock = new Object();
    GMTrace.o(13117635428352L, 97734);
  }
  
  public KVCommCrossProcessReceiver()
  {
    GMTrace.i(13116024815616L, 97722);
    GMTrace.o(13116024815616L, 97722);
  }
  
  public static void O(ArrayList<IDKey> paramArrayList)
  {
    GMTrace.i(16287858163712L, 121354);
    v.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.valueOf(false) });
    synchronized (lock)
    {
      BroadCastData localBroadCastData = oSi;
      paramArrayList = new GroupIDKeyDataInfo(paramArrayList, false);
      localBroadCastData.oRX.add(paramArrayList);
      if ((oSg == 0L) || (aXv()))
      {
        aXu();
        GMTrace.o(16287858163712L, 121354);
        return;
      }
    }
    if (oSe.hasMessages(1))
    {
      GMTrace.o(16287858163712L, 121354);
      return;
    }
    oSe.sendEmptyMessageDelayed(1, oSg);
    GMTrace.o(16287858163712L, 121354);
  }
  
  public static void a(KVReportDataInfo paramKVReportDataInfo)
  {
    GMTrace.i(13116561686528L, 97726);
    v.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, isImportant: %b,isReportNow: %b", new Object[] { Long.valueOf(paramKVReportDataInfo.oSr), Boolean.valueOf(paramKVReportDataInfo.oRZ), Boolean.valueOf(paramKVReportDataInfo.oSs) });
    synchronized (lock)
    {
      oSi.oRV.add(paramKVReportDataInfo);
      if (oSg == 0L)
      {
        aXu();
        GMTrace.o(13116561686528L, 97726);
        return;
      }
    }
    if (oSe.hasMessages(1))
    {
      GMTrace.o(13116561686528L, 97726);
      return;
    }
    oSe.sendEmptyMessageDelayed(1, oSg);
    GMTrace.o(13116561686528L, 97726);
  }
  
  public static void a(StIDKeyDataInfo paramStIDKeyDataInfo)
  {
    GMTrace.i(13116695904256L, 97727);
    v.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", new Object[] { Long.valueOf(paramStIDKeyDataInfo.oST), Long.valueOf(paramStIDKeyDataInfo.key), Long.valueOf(paramStIDKeyDataInfo.value), Boolean.valueOf(paramStIDKeyDataInfo.oRZ) });
    synchronized (lock)
    {
      oSi.oRW.add(paramStIDKeyDataInfo);
      if ((oSg == 0L) || (aXv()))
      {
        aXu();
        GMTrace.o(13116695904256L, 97727);
        return;
      }
    }
    if (oSe.hasMessages(1))
    {
      GMTrace.o(13116695904256L, 97727);
      return;
    }
    oSe.sendEmptyMessageDelayed(1, oSg);
    GMTrace.o(13116695904256L, 97727);
  }
  
  public static void aXs()
  {
    GMTrace.i(18782160420864L, 139938);
    if (100L < 0L)
    {
      GMTrace.o(18782160420864L, 139938);
      return;
    }
    oSg = 100L;
    GMTrace.o(18782160420864L, 139938);
  }
  
  public static void aXt()
  {
    GMTrace.i(18920538898432L, 140969);
    oSh = 1000;
    GMTrace.o(18920538898432L, 140969);
  }
  
  private static void aXu()
  {
    GMTrace.i(16088276402176L, 119867);
    Object localObject5;
    Object localObject6;
    synchronized (lock)
    {
      Object localObject2 = new BroadCastData(oSi);
      localObject5 = oSi;
      ((BroadCastData)localObject5).oRV.clear();
      ((BroadCastData)localObject5).oRW.clear();
      ((BroadCastData)localObject5).oRX.clear();
      localObject6 = ((BroadCastData)localObject2).oRX;
      localObject5 = ((BroadCastData)localObject2).oRW;
      ??? = ((BroadCastData)localObject2).oRV;
      if ((!k.aL(aa.getContext())) && (aa.bIV())) {
        break label240;
      }
      v.i("MicroMsg.ReportManagerKvCheck", "sendKVBroadcast shut_down_weixin, no need to notify worker");
      localObject2 = ((ArrayList)localObject6).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject6 = (GroupIDKeyDataInfo)((Iterator)localObject2).next();
        e.d(((GroupIDKeyDataInfo)localObject6).oRY, ((GroupIDKeyDataInfo)localObject6).oRZ);
      }
    }
    Object localObject4 = ((ArrayList)localObject5).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (StIDKeyDataInfo)((Iterator)localObject4).next();
      e.d((int)((StIDKeyDataInfo)localObject5).oST, (int)((StIDKeyDataInfo)localObject5).key, (int)((StIDKeyDataInfo)localObject5).value, ((StIDKeyDataInfo)localObject5).oRZ);
    }
    ??? = ((ArrayList)???).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject4 = (KVReportDataInfo)((Iterator)???).next();
      e.b((int)((KVReportDataInfo)localObject4).oSr, ((KVReportDataInfo)localObject4).value, ((KVReportDataInfo)localObject4).oSs, ((KVReportDataInfo)localObject4).oRZ);
    }
    GMTrace.o(16088276402176L, 119867);
    return;
    label240:
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
    localIntent.setComponent(new ComponentName(aa.getPackageName(), getClassName()));
    localIntent.putExtra("type", 1);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_IDKEYGROUP", (Parcelable)localObject4);
    localIntent.putExtra("INTENT_IDKEYGROUP", localBundle);
    v.d("MicroMsg.ReportManagerKvCheck", "try sendBroadcast kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", new Object[] { Integer.valueOf(((ArrayList)???).size()), Integer.valueOf(((ArrayList)localObject5).size()), Integer.valueOf(((ArrayList)localObject6).size()) });
    try
    {
      aa.getContext().sendBroadcast(localIntent);
      GMTrace.o(16088276402176L, 119867);
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.ReportManagerKvCheck", localException, "sendBroadcastMessageDirectly", new Object[0]);
      GMTrace.o(16088276402176L, 119867);
    }
  }
  
  private static boolean aXv()
  {
    GMTrace.i(18920673116160L, 140970);
    if (oSh <= 0)
    {
      GMTrace.o(18920673116160L, 140970);
      return false;
    }
    if (oSi == null)
    {
      GMTrace.o(18920673116160L, 140970);
      return false;
    }
    try
    {
      int i = oSi.oRW.size();
      int j = oSi.oRX.size();
      int k = oSi.oRV.size();
      int m = oSh;
      if (i + j + k >= m)
      {
        GMTrace.o(18920673116160L, 140970);
        return true;
      }
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.ReportManagerKvCheck", "checkExceedCacheItemCountLimit e = %s", new Object[] { localException });
      GMTrace.o(18920673116160L, 140970);
    }
    return false;
  }
  
  public static void aXw()
  {
    GMTrace.i(13116964339712L, 97729);
    if ((k.aL(aa.getContext())) || (!aa.bIV()))
    {
      v.w("MicroMsg.ReportManagerKvCheck", "sendOnCrashOrExceptionBroadCast shut_down_weixin, NO MM Process , return.");
      GMTrace.o(13116964339712L, 97729);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
    localIntent.setComponent(new ComponentName(aa.getPackageName(), getClassName()));
    localIntent.putExtra("type", 2);
    aa.getContext().sendBroadcast(localIntent);
    GMTrace.o(13116964339712L, 97729);
  }
  
  public static void aXx()
  {
    GMTrace.i(16287992381440L, 121355);
    if (oSe == null)
    {
      GMTrace.o(16287992381440L, 121355);
      return;
    }
    oSe.removeMessages(1);
    oSe.handleMessage(oSe.obtainMessage(1));
    GMTrace.o(16287992381440L, 121355);
  }
  
  private static String getClassName()
  {
    GMTrace.i(13116427468800L, 97725);
    if (bf.mA(className)) {
      className = aa.getPackageName() + ".plugin.report.service.KVCommCrossProcessReceiver";
    }
    String str = className;
    GMTrace.o(13116427468800L, 97725);
    return str;
  }
  
  public void onReceive(Context paramContext, final Intent paramIntent)
  {
    GMTrace.i(13116159033344L, 97723);
    if (paramIntent == null)
    {
      v.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
      GMTrace.o(13116159033344L, 97723);
      return;
    }
    oSe.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(14894543929344L, 110973);
        v.i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
        KVCommCrossProcessReceiver.a(KVCommCrossProcessReceiver.this, paramIntent);
        GMTrace.o(14894543929344L, 110973);
      }
    });
    GMTrace.o(13116159033344L, 97723);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/service/KVCommCrossProcessReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */