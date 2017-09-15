package com.tencent.mm.plugin.gcm.modelgcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.e.a.gf;
import com.tencent.mm.kernel.k;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GcmBroadcastReceiver
  extends BroadcastReceiver
{
  static List<Pair<Long, Long>> mFX;
  private static WakerLock wakerlock;
  
  static
  {
    GMTrace.i(8012261490688L, 59696);
    wakerlock = null;
    mFX = new LinkedList();
    GMTrace.o(8012261490688L, 59696);
  }
  
  public GcmBroadcastReceiver()
  {
    GMTrace.i(8011858837504L, 59693);
    GMTrace.o(8011858837504L, 59693);
  }
  
  public static void aCf()
  {
    GMTrace.i(8011993055232L, 59694);
    mFX.clear();
    GMTrace.o(8011993055232L, 59694);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(8012127272960L, 59695);
    v.i("GcmBroadcastReceiver", "GcmBroadcastReceiver onReceive in.");
    String str1;
    if (paramIntent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION"))
    {
      localObject = a.aCg();
      str1 = ((a)localObject).aCi();
      String str2 = paramIntent.getStringExtra("registration_id");
      v.i("GcmBroadcastReceiver", "REGISTRATION intent received:" + paramIntent.toString());
      if ((paramIntent.getStringExtra("error") == null) && (paramIntent.getStringExtra("unregistered") == null) && (str2 != null) && (str1.compareTo(str2) != 0))
      {
        if (z.MN() != null) {
          break label155;
        }
        v.w("GcmBroadcastReceiver", "gcm reg id recv, but mmpushcore not init, id = " + str2);
      }
      for (;;)
      {
        c.oRz.a(452L, 25L, 1L, false);
        GMTrace.o(8012127272960L, 59695);
        return;
        label155:
        ((a)localObject).ac(paramContext, str2);
        z.MN().post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(8017361764352L, 59734);
            this.mFY.aCk();
            GMTrace.o(8017361764352L, 59734);
          }
        });
      }
    }
    Object localObject = a.aCg();
    if ((localObject == null) || (bf.mA(((a)localObject).aCi())))
    {
      boolean bool1;
      boolean bool2;
      if (localObject == null)
      {
        bool1 = true;
        if (localObject != null) {
          break label307;
        }
        bool2 = false;
        label219:
        v.i("GcmBroadcastReceiver", "Gcm push is not reg to server. reg == null[%b], isRegToSvr[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        g.oSF.A(11250, "1,2");
        paramContext = c.oRz;
        if (localObject != null) {
          break label317;
        }
      }
      label307:
      label317:
      for (l1 = 26L;; l1 = 27L)
      {
        paramContext.a(452L, l1, 1L, false);
        GMTrace.o(8012127272960L, 59695);
        return;
        bool1 = false;
        break;
        bool2 = ((a)localObject).aCm();
        break label219;
      }
    }
    for (;;)
    {
      try
      {
        if (k.aK(paramContext))
        {
          v.i("GcmBroadcastReceiver", "Logout or exit MM. no need show Notification.");
          g.oSF.A(11250, "1,2");
          c.oRz.a(452L, 28L, 1L, false);
          GMTrace.o(8012127272960L, 59695);
          return;
        }
        localObject = paramIntent.getExtras();
        com.google.android.gms.gcm.a.D(paramContext);
        paramIntent = com.google.android.gms.gcm.a.d(paramIntent);
        if (((Bundle)localObject).isEmpty())
        {
          v.i("GcmBroadcastReceiver", "Intent extras is empty: ");
          g.oSF.A(11250, "1,0");
          c.oRz.a(452L, 29L, 1L, false);
          GMTrace.o(8012127272960L, 59695);
          return;
        }
        if (!"send_error".equals(paramIntent)) {
          continue;
        }
        v.i("GcmBroadcastReceiver", "Send error: " + ((Bundle)localObject).toString());
        g.oSF.A(11250, "1,1");
        c.oRz.a(452L, 30L, 1L, false);
      }
      catch (Exception paramContext)
      {
        paramIntent = paramContext.toString();
        v.e("GcmBroadcastReceiver", "GcmBroadcastReceiver error :" + paramIntent);
        v.printErrStackTrace("GcmBroadcastReceiver", paramContext, "", new Object[0]);
        c.oRz.a(452L, 36L, 1L, false);
        continue;
        if (!"gcm".equals(paramIntent)) {
          continue;
        }
        c.oRz.a(452L, 32L, 1L, false);
        v.i("GcmBroadcastReceiver", "Received gcm msg. extras[%s]", new Object[] { ((Bundle)localObject).toString() });
        paramIntent = ((Bundle)localObject).getString("seq");
        str1 = ((Bundle)localObject).getString("uin");
        localObject = ((Bundle)localObject).getString("cmd");
        if (!bf.mA(str1)) {
          break label875;
        }
      }
      v.i("GcmBroadcastReceiver", "GcmBroadcastReceiver onReceive out.");
      GMTrace.o(8012127272960L, 59695);
      return;
      if (!"deleted_messages".equals(paramIntent)) {
        continue;
      }
      v.i("GcmBroadcastReceiver", "Deleted messages on server.");
      g.oSF.A(11250, "1,1");
      c.oRz.a(452L, 31L, 1L, false);
    }
    long l1 = 0L;
    label737:
    long l2;
    label747:
    long l3;
    label758:
    int i;
    if (bf.mA(paramIntent))
    {
      l2 = 0L;
      if (!bf.mA((String)localObject)) {
        break label896;
      }
      l3 = 0L;
      i = com.tencent.mm.kernel.a.uX();
      if ((l1 != 0L) && (Integer.toHexString(i).equals(Long.toHexString(l1)))) {
        break label907;
      }
      v.e("GcmBroadcastReceiver", "Logined user changed. no need show Notification.uin:" + l1 + ", oldUin:" + i);
      g.oSF.A(11250, "1,3");
      paramContext = c.oRz;
      if (l1 != 0L) {
        break label1137;
      }
    }
    label875:
    label896:
    label907:
    label1137:
    for (l1 = 33L;; l1 = 34L)
    {
      paramContext.a(452L, l1, 1L, false);
      GMTrace.o(8012127272960L, 59695);
      return;
      l1 = bf.getLong(str1, 0L);
      break label737;
      l2 = bf.getLong(paramIntent, 0L);
      break label747;
      l3 = bf.getLong((String)localObject, 0L);
      break label758;
      paramIntent = mFX.iterator();
      do
      {
        if (!paramIntent.hasNext()) {
          break;
        }
        localObject = (Pair)paramIntent.next();
      } while ((((Long)((Pair)localObject).first).longValue() != l3) || (((Long)((Pair)localObject).second).longValue() != l2));
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          v.w("GcmBroadcastReceiver", "already has this seq:" + l2);
          c.oRz.a(452L, 35L, 1L, false);
          GMTrace.o(8012127272960L, 59695);
          return;
        }
        mFX.add(Pair.create(Long.valueOf(l3), Long.valueOf(l2)));
        if (mFX.size() > 60) {
          mFX.remove(0);
        }
        if (wakerlock == null)
        {
          wakerlock = new WakerLock(paramContext);
          v.i("GcmBroadcastReceiver", "start new wakerlock");
        }
        wakerlock.lock(200L, "GcmBroadcastReceiver.onReceive");
        paramContext = new gf();
        paramContext.fLn.type = 13;
        com.tencent.mm.sdk.b.a.uql.m(paramContext);
        break;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/gcm/modelgcm/GcmBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */