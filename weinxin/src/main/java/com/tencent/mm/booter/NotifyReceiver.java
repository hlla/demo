package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.kernel.i;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.PluginZero.b;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyReceiver
  extends BroadcastReceiver
{
  private static WakerLock gJJ;
  private static Set<Long> gJK;
  private static Lock gJL;
  private static byte[] gJM;
  private static byte[] gJN;
  private static a gJO;
  private static boolean gJP;
  private static WakerLock gJw;
  
  static
  {
    GMTrace.i(13472775536640L, 100380);
    gJw = null;
    gJJ = null;
    gJK = new HashSet();
    gJL = new ReentrantLock(false);
    gJM = new byte[0];
    gJN = new byte[0];
    gJP = true;
    GMTrace.o(13472775536640L, 100380);
  }
  
  public NotifyReceiver()
  {
    GMTrace.i(13471030706176L, 100367);
    GMTrace.o(13471030706176L, 100367);
  }
  
  public static void pW()
  {
    GMTrace.i(13471164923904L, 100368);
    v.i("MicroMsg.NotifyReceiver", "markUIShow");
    gJP = false;
    z.MI().edit().putBoolean("is_in_notify_mode", false).commit();
    GMTrace.o(13471164923904L, 100368);
  }
  
  public static void pX()
  {
    GMTrace.i(13471299141632L, 100369);
    com.tencent.mm.kernel.h.vd().b(138, gJO);
    com.tencent.mm.kernel.h.vd().b(39, gJO);
    com.tencent.mm.kernel.h.vd().b(268369922, gJO);
    if (gJO == null) {
      gJO = new a();
    }
    com.tencent.mm.kernel.h.vd().a(138, gJO);
    com.tencent.mm.kernel.h.vd().a(39, gJO);
    com.tencent.mm.kernel.h.vd().a(268369922, gJO);
    GMTrace.o(13471299141632L, 100369);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(13471433359360L, 100370);
    v.i("MicroMsg.NotifyReceiver", "onReceive intent :%s", new Object[] { paramIntent });
    if (paramIntent == null)
    {
      GMTrace.o(13471433359360L, 100370);
      return;
    }
    if (com.tencent.mm.kernel.k.aK(paramContext))
    {
      v.i("MicroMsg.NotifyReceiver", "fully exited, no need to start service");
      GMTrace.o(13471433359360L, 100370);
      return;
    }
    Intent localIntent = new Intent(paramContext, NotifyService.class);
    if (paramIntent.getBooleanExtra("intent_from_shoot_key", false)) {
      localIntent.putExtra("notify_option_type", 3);
    }
    localIntent.putExtras(paramIntent);
    paramContext.startService(localIntent);
    GMTrace.o(13471433359360L, 100370);
  }
  
  public static class NotifyService
    extends Service
  {
    Boolean gJS;
    private com.tencent.mm.kernel.api.h gJT;
    
    public NotifyService()
    {
      GMTrace.i(13469822746624L, 100358);
      this.gJS = null;
      GMTrace.o(13469822746624L, 100358);
    }
    
    public static void cT(String paramString)
    {
      GMTrace.i(13470628052992L, 100364);
      synchronized (NotifyReceiver.pY())
      {
        if (NotifyReceiver.pZ() == null) {
          NotifyReceiver.a(new WakerLock(aa.getContext()));
        }
        NotifyReceiver.pZ().lock(5000L, paramString);
        GMTrace.o(13470628052992L, 100364);
        return;
      }
    }
    
    private void k(Intent paramIntent)
    {
      GMTrace.i(13470359617536L, 100362);
      if (paramIntent == null)
      {
        v.e("MicroMsg.NotifyReceiver", "receiveImp receiveIntent == null");
        GMTrace.o(13470359617536L, 100362);
        return;
      }
      if (!com.tencent.mm.kernel.h.vJ().gYz.gYV)
      {
        v.e("MicroMsg.NotifyReceiver", "summerboot WorkerProfile not has create, status %d", new Object[] { Integer.valueOf(0) });
        if (this.gJT != null) {
          com.tencent.mm.kernel.h.vJ().b(this.gJT);
        }
        this.gJT = new com.tencent.mm.kernel.api.h()
        {
          public final void ak(boolean paramAnonymousBoolean)
          {
            GMTrace.i(14896691412992L, 110989);
            GMTrace.o(14896691412992L, 110989);
          }
          
          public final void oh()
          {
            GMTrace.i(14896557195264L, 110988);
            com.tencent.mm.kernel.h.vJ().b(this);
            NotifyReceiver.NotifyService.a(NotifyReceiver.NotifyService.this);
            long l = System.currentTimeMillis() - this.gJU;
            v.i("MicroMsg.NotifyReceiver", "summerboot startupDone[%b] take[%d]ms tid[%d] post last notify task", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.h.vJ().gYz.gYV), Long.valueOf(l), Long.valueOf(Thread.currentThread().getId()) });
            c.oRz.i(11098, new Object[] { Integer.valueOf(3600), Long.valueOf(l) });
            c.oRz.a(99L, 214L, 1L, false);
            ae.f(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(14897362501632L, 110994);
                v.i("MicroMsg.NotifyReceiver", "summerboot startupDone do delay notify task");
                NotifyReceiver.NotifyService.a(NotifyReceiver.NotifyService.this, NotifyReceiver.NotifyService.1.this.gJV);
                c.oRz.a(99L, 215L, 1L, false);
                GMTrace.o(14897362501632L, 110994);
              }
            }, 500L);
            GMTrace.o(14896557195264L, 110988);
          }
        };
        com.tencent.mm.kernel.h.vJ().a(this.gJT);
        c.oRz.a(99L, 213L, 1L, false);
      }
      for (int i = -1;; i = 0)
      {
        if (i < 0)
        {
          v.e("MicroMsg.NotifyReceiver", "summerboot status %s", new Object[] { Integer.valueOf(-1) });
          GMTrace.o(13470359617536L, 100362);
          return;
        }
        l(paramIntent);
        GMTrace.o(13470359617536L, 100362);
        return;
      }
    }
    
    private void l(Intent paramIntent)
    {
      GMTrace.i(14896825630720L, 110990);
      int i = paramIntent.getIntExtra("notify_option_type", 0);
      if (i == 0)
      {
        v.e("MicroMsg.NotifyReceiver", "receiveImp invalid opcode.");
        GMTrace.o(14896825630720L, 110990);
        return;
      }
      if (!com.tencent.mm.kernel.h.vG().uV()) {
        com.tencent.mm.kernel.h.vG().initialize();
      }
      if ((!com.tencent.mm.kernel.h.vG().uV()) || (com.tencent.mm.kernel.a.uP()))
      {
        v.e("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:%b  isHold:%b  opcode:%d", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.h.vG().uV()), Boolean.valueOf(com.tencent.mm.kernel.a.uP()), Integer.valueOf(i) });
        GMTrace.o(14896825630720L, 110990);
        return;
      }
      if (com.tencent.mm.kernel.h.vd().hsI == null)
      {
        v.w("MicroMsg.NotifyReceiver", "receiveImp  opcode:%d  getDispatcher == null", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.kernel.h.vd().aW(true);
      }
      if (this.gJS == null) {
        if (!com.tencent.mm.sdk.a.b.bIk()) {
          break label254;
        }
      }
      Object localObject;
      boolean bool;
      label254:
      int j;
      label454:
      byte[] arrayOfByte;
      long l;
      label963:
      label1110:
      label1115:
      label1911:
      label1996:
      label2001:
      label2179:
      for (;;)
      {
        localObject = this;
        bool = false;
        for (;;)
        {
          ((NotifyService)localObject).gJS = Boolean.valueOf(bool);
          v.i("MicroMsg.NotifyReceiver", "handleCommand useOld:%s operationCode:%d", new Object[] { this.gJS, Integer.valueOf(i) });
          switch (i)
          {
          default: 
            v.e("MicroMsg.NotifyReceiver", "invald opCode:" + i);
            GMTrace.o(14896825630720L, 110990);
            return;
            j = bf.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("AndroidOldNotifyReceiver"), 0);
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vG();
            if (j <= com.tencent.mm.a.h.aw(com.tencent.mm.kernel.a.uH(), 100)) {
              break label2179;
            }
            bool = true;
            localObject = this;
          }
        }
        if (this.gJS.booleanValue()) {
          s(aa.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NETWORK_AVAILABLE");
        }
        paramIntent = aa.getContext();
        v.i("MicroMsg.NotifyReceiver", "dealWithLooper");
        if ((!com.tencent.mm.kernel.h.vG().uV()) || (com.tencent.mm.kernel.a.uP()))
        {
          v.w("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:" + com.tencent.mm.kernel.h.vG().uV() + " isHold:" + com.tencent.mm.kernel.a.uP());
          GMTrace.o(14896825630720L, 110990);
          return;
        }
        if (!com.tencent.mm.kernel.h.vd().foreground) {
          if ((paramIntent == null) || (al.isWap(paramIntent))) {
            break label454;
          }
        }
        for (i = 1; i == 0; i = 0)
        {
          ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.b.class)).Hz().gg(2);
          GMTrace.o(14896825630720L, 110990);
          return;
        }
        com.tencent.mm.kernel.h.vd().a(new com.tencent.mm.modelmulti.k(), 0);
        GMTrace.o(14896825630720L, 110990);
        return;
        if (this.gJS.booleanValue())
        {
          s(aa.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NOTIFY");
          j = paramIntent.getIntExtra("notify_respType", 0);
          localObject = paramIntent.getByteArrayExtra("notify_respBuf");
          arrayOfByte = paramIntent.getByteArrayExtra("notify_skey");
          l = paramIntent.getLongExtra("notfiy_recv_time", -1L);
          if (localObject == null) {}
          for (i = -1;; i = localObject.length)
          {
            v.i("MicroMsg.NotifyReceiver", "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ", new Object[] { Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(i), bf.Qi(bf.bo(arrayOfByte)) });
            switch (j)
            {
            default: 
              ((PluginZero)com.tencent.mm.kernel.h.j(PluginZero.class)).szn.a(this, j, (byte[])localObject, arrayOfByte, l);
              GMTrace.o(14896825630720L, 110990);
              return;
            }
          }
          if (bf.bm(arrayOfByte))
          {
            v.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session:" + arrayOfByte);
            GMTrace.o(14896825630720L, 110990);
            return;
          }
          if ((bf.bm((byte[])localObject)) || (localObject.length <= 8))
          {
            v.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
            GMTrace.o(14896825630720L, 110990);
            return;
          }
          i = com.tencent.mm.a.n.c((byte[])localObject, 0);
          j = com.tencent.mm.a.n.c((byte[])localObject, 4);
          if (j != localObject.length - 8)
          {
            v.e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + localObject.length);
            GMTrace.o(14896825630720L, 110990);
            return;
          }
          paramIntent = new byte[j];
          System.arraycopy(localObject, 8, paramIntent, 0, j);
          v.i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localObject.length), Long.valueOf(l) });
          try
          {
            NotifyReceiver.qc().lock();
            m.a(i, paramIntent, arrayOfByte, l);
            NotifyReceiver.qd().add(Long.valueOf(l));
            t(aa.getContext(), "NotifyReceiver.NotifyData");
            try
            {
              NotifyReceiver.qc().unlock();
              GMTrace.o(14896825630720L, 110990);
              return;
            }
            catch (Exception paramIntent)
            {
              GMTrace.o(14896825630720L, 110990);
              return;
            }
            try
            {
              NotifyReceiver.qc().unlock();
              throw paramIntent;
              if (localObject == null)
              {
                i = 7;
                if (localObject != null) {
                  break label1110;
                }
                j = 2;
                if (localObject != null) {
                  break label1115;
                }
              }
              for (int k = -1;; k = localObject.length)
              {
                v.d("MicroMsg.NotifyReceiver", "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                try
                {
                  NotifyReceiver.qc().lock();
                  i = ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.b.class)).Hz().a(i, j, "");
                  if (i > 0)
                  {
                    v.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", new Object[] { Integer.valueOf(i) });
                    NotifyReceiver.qd().add(Long.valueOf(i));
                    t(aa.getContext(), "NotifyReceiver.dealWithNotify:MMFunc_NewSync");
                  }
                  try
                  {
                    NotifyReceiver.qc().unlock();
                    GMTrace.o(14896825630720L, 110990);
                    return;
                  }
                  catch (Exception paramIntent)
                  {
                    GMTrace.o(14896825630720L, 110990);
                    return;
                  }
                  i = com.tencent.mm.a.n.c((byte[])localObject, 0);
                  break;
                }
                finally {}
                j = 1;
                break label963;
              }
              try
              {
                NotifyReceiver.qc().unlock();
                throw paramIntent;
                paramIntent = new StringBuilder("oreh on newsynccheck2 notify, notify=");
                if (localObject != null) {
                  bool = true;
                }
                for (;;)
                {
                  v.d("MicroMsg.NotifyReceiver", bool);
                  paramIntent = new aa.b();
                  try
                  {
                    paramIntent.y((byte[])localObject);
                    NotifyReceiver.qc().lock();
                    i = ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.b.class)).Hz().a(paramIntent.sYC, 1, paramIntent.bHh());
                    if (i > 0)
                    {
                      v.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", new Object[] { Integer.valueOf(i) });
                      NotifyReceiver.qd().add(Long.valueOf(i));
                      t(aa.getContext(), "NotifyReceiver.dealWithNotify:MM_PKT_NEW_SYNC_CHECK2_RESP");
                    }
                    try
                    {
                      NotifyReceiver.qc().unlock();
                      GMTrace.o(14896825630720L, 110990);
                      return;
                    }
                    catch (Exception paramIntent)
                    {
                      GMTrace.o(14896825630720L, 110990);
                      return;
                    }
                    bool = false;
                  }
                  catch (Exception paramIntent)
                  {
                    paramIntent = paramIntent;
                    v.printErrStackTrace("MicroMsg.NotifyReceiver", paramIntent, "", new Object[0]);
                    try
                    {
                      NotifyReceiver.qc().unlock();
                      GMTrace.o(14896825630720L, 110990);
                      return;
                    }
                    catch (Exception paramIntent)
                    {
                      GMTrace.o(14896825630720L, 110990);
                      return;
                    }
                  }
                  finally {}
                }
                try
                {
                  NotifyReceiver.qc().unlock();
                  throw paramIntent;
                  com.tencent.mm.kernel.h.vd().a(new com.tencent.mm.modelmulti.k(), 0);
                  GMTrace.o(14896825630720L, 110990);
                  return;
                  v.d("MicroMsg.NotifyReceiver", "dkpush GCM Notify");
                  i = ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.b.class)).Hz().a(7L, 13, "");
                  try
                  {
                    NotifyReceiver.qc().lock();
                    if (i > 0)
                    {
                      v.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", new Object[] { Integer.valueOf(i) });
                      NotifyReceiver.qd().add(Long.valueOf(i));
                      t(aa.getContext(), "NotifyReceiver.dealWithNotify:MM_PKT_GCM_NOTIFY");
                    }
                    try
                    {
                      NotifyReceiver.qc().unlock();
                      GMTrace.o(14896825630720L, 110990);
                      return;
                    }
                    catch (Exception paramIntent)
                    {
                      GMTrace.o(14896825630720L, 110990);
                      return;
                    }
                    try
                    {
                      NotifyReceiver.qc().unlock();
                      throw paramIntent;
                      j = paramIntent.getIntExtra("notify_respType", 0);
                      localObject = paramIntent.getByteArrayExtra("notify_respBuf");
                      arrayOfByte = paramIntent.getByteArrayExtra("notify_skey");
                      l = paramIntent.getLongExtra("notfiy_recv_time", -1L);
                      if (localObject == null) {}
                      for (i = -1;; i = localObject.length)
                      {
                        v.i("MicroMsg.NotifyReceiver", "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ", new Object[] { Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(i), bf.Qi(bf.bo(arrayOfByte)) });
                        switch (j)
                        {
                        default: 
                          ((PluginZero)com.tencent.mm.kernel.h.j(PluginZero.class)).szn.a(this, j, (byte[])localObject, arrayOfByte, l);
                          GMTrace.o(14896825630720L, 110990);
                          return;
                        }
                      }
                      if (bf.bm(arrayOfByte))
                      {
                        v.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session:" + arrayOfByte);
                        GMTrace.o(14896825630720L, 110990);
                        return;
                      }
                      if ((bf.bm((byte[])localObject)) || (localObject.length <= 8))
                      {
                        v.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
                        GMTrace.o(14896825630720L, 110990);
                        return;
                      }
                      i = com.tencent.mm.a.n.c((byte[])localObject, 0);
                      j = com.tencent.mm.a.n.c((byte[])localObject, 4);
                      if (j != localObject.length - 8)
                      {
                        v.e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + localObject.length);
                        GMTrace.o(14896825630720L, 110990);
                        return;
                      }
                      paramIntent = new byte[j];
                      System.arraycopy(localObject, 8, paramIntent, 0, j);
                      v.i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localObject.length), Long.valueOf(l) });
                      m.a(i, paramIntent, arrayOfByte, l);
                      GMTrace.o(14896825630720L, 110990);
                      return;
                      if (localObject == null)
                      {
                        i = 7;
                        if (localObject != null) {
                          break label1996;
                        }
                        j = 2;
                        if (localObject != null) {
                          break label2001;
                        }
                      }
                      for (k = -1;; k = localObject.length)
                      {
                        v.i("MicroMsg.NotifyReceiver", "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                        ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.b.class)).Hz().a(i, j, "");
                        GMTrace.o(14896825630720L, 110990);
                        return;
                        i = com.tencent.mm.a.n.c((byte[])localObject, 0);
                        break;
                        j = 1;
                        break label1911;
                      }
                      v.i("MicroMsg.NotifyReceiver", "dkpush GCM Notify");
                      ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.b.class)).Hz().a(7L, 13, "");
                      GMTrace.o(14896825630720L, 110990);
                      return;
                      paramIntent = new StringBuilder("oreh on newsynccheck2 notify, notify=");
                      if (localObject != null) {}
                      for (bool = true;; bool = false)
                      {
                        v.i("MicroMsg.NotifyReceiver", bool);
                        paramIntent = new aa.b();
                        ((com.tencent.mm.plugin.zero.b.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.b.class)).Hz().a(paramIntent.sYC, 1, paramIntent.bHh());
                        GMTrace.o(14896825630720L, 110990);
                        return;
                      }
                      com.tencent.mm.kernel.h.vd().a(new com.tencent.mm.modelmulti.k(), 0);
                      GMTrace.o(14896825630720L, 110990);
                      return;
                    }
                    catch (Exception localException1)
                    {
                      for (;;) {}
                    }
                  }
                  finally {}
                }
                catch (Exception localException2)
                {
                  for (;;) {}
                }
              }
              catch (Exception localException3)
              {
                for (;;) {}
              }
            }
            catch (Exception localException4)
            {
              for (;;) {}
            }
          }
          finally {}
        }
      }
    }
    
    private static void s(Context paramContext, String paramString)
    {
      GMTrace.i(13470762270720L, 100365);
      synchronized (NotifyReceiver.pY())
      {
        if (NotifyReceiver.pZ() == null) {
          NotifyReceiver.a(new WakerLock(paramContext));
        }
        NotifyReceiver.pZ().lock(14000L, paramString);
        GMTrace.o(13470762270720L, 100365);
        return;
      }
    }
    
    private static void t(Context paramContext, String paramString)
    {
      GMTrace.i(13470896488448L, 100366);
      synchronized (NotifyReceiver.qa())
      {
        if (NotifyReceiver.qb() == null) {
          NotifyReceiver.b(new WakerLock(paramContext));
        }
        NotifyReceiver.qb().lock(60000L, paramString);
        GMTrace.o(13470896488448L, 100366);
        return;
      }
    }
    
    public IBinder onBind(Intent paramIntent)
    {
      GMTrace.i(13470225399808L, 100361);
      GMTrace.o(13470225399808L, 100361);
      return null;
    }
    
    public void onCreate()
    {
      GMTrace.i(13470493835264L, 100363);
      super.onCreate();
      if ((Build.VERSION.SDK_INT < 24) && (!com.tencent.mm.compatible.util.h.sf()))
      {
        if (Build.VERSION.SDK_INT >= 18) {
          break label94;
        }
        startForeground(64324, new Notification());
      }
      for (;;)
      {
        long l = aa.bIO().getLong("mm_stop_service_time", 86400000L);
        new ad().postDelayed(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(14895751888896L, 110982);
            NotifyReceiver.NotifyService.this.stopForeground(true);
            GMTrace.o(14895751888896L, 110982);
          }
        }, l);
        GMTrace.o(13470493835264L, 100363);
        return;
        label94:
        if (getSharedPreferences("system_config_prefs", 4).getBoolean("set_service", false))
        {
          startForeground(64324, new Notification());
          startService(new Intent(this, InnerService.class));
          v.i("MicroMsg.NotifyReceiver", "set service for mm.");
        }
      }
    }
    
    public void onStart(Intent paramIntent, int paramInt)
    {
      GMTrace.i(13469956964352L, 100359);
      k(paramIntent);
      GMTrace.o(13469956964352L, 100359);
    }
    
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      GMTrace.i(13470091182080L, 100360);
      v.i("MicroMsg.NotifyReceiver", "NotifyService onStartCommand flags :" + paramInt1 + "startId :" + paramInt2 + " intent " + paramIntent);
      k(paramIntent);
      GMTrace.o(13470091182080L, 100360);
      return 2;
    }
    
    public static class InnerService
      extends Service
    {
      public InnerService()
      {
        GMTrace.i(13458548457472L, 100274);
        GMTrace.o(13458548457472L, 100274);
      }
      
      public IBinder onBind(Intent paramIntent)
      {
        GMTrace.i(13458951110656L, 100277);
        GMTrace.o(13458951110656L, 100277);
        return null;
      }
      
      public void onCreate()
      {
        GMTrace.i(13458682675200L, 100275);
        super.onCreate();
        try
        {
          startForeground(64324, new Notification());
          stopSelf();
          GMTrace.o(13458682675200L, 100275);
          return;
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            v.e("MicroMsg.NotifyReceiver", "set service for mm exception:%s", new Object[] { localNullPointerException });
          }
        }
      }
      
      public void onDestroy()
      {
        GMTrace.i(13458816892928L, 100276);
        stopForeground(true);
        super.onDestroy();
        GMTrace.o(13458816892928L, 100276);
      }
    }
  }
  
  public static final class a
    implements com.tencent.mm.y.e
  {
    public static long gJQ;
    
    static
    {
      GMTrace.i(13460427505664L, 100288);
      gJQ = 0L;
      GMTrace.o(13460427505664L, 100288);
    }
    
    public a()
    {
      GMTrace.i(13459487981568L, 100281);
      GMTrace.o(13459487981568L, 100281);
    }
    
    public final void C(long paramLong)
    {
      GMTrace.i(13459756417024L, 100283);
      if (!z.MI().getBoolean("is_in_notify_mode", false))
      {
        GMTrace.o(13459756417024L, 100283);
        return;
      }
      new ad(Looper.myLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13462574989312L, 100304);
          v.i("MicroMsg.NotifyReceiver", "checkKillProcess, canKillProcess :%b", new Object[] { Boolean.valueOf(NotifyReceiver.qe()) });
          synchronized (NotifyReceiver.pY())
          {
            if (NotifyReceiver.pZ() != null) {
              NotifyReceiver.pZ().unLock();
            }
            NotifyReceiver.a(null);
            if (NotifyReceiver.qe())
            {
              ??? = (PluginZero)com.tencent.mm.kernel.h.j(PluginZero.class);
              if (((PluginZero)???).szm != null) {
                ((PluginZero)???).szm.acJ();
              }
              v.bIG();
              Process.killProcess(Process.myPid());
            }
            GMTrace.o(13462574989312L, 100304);
            return;
          }
        }
      }, paramLong);
      GMTrace.o(13459756417024L, 100283);
    }
    
    public final void a(int paramInt1, int paramInt2, String arg3, com.tencent.mm.y.k paramk)
    {
      GMTrace.i(13459622199296L, 100282);
      long l = paramk.hashCode();
      if (paramk.getType() == 268369922) {
        l = ((com.tencent.mm.modelmulti.h)paramk).hJQ;
      }
      for (;;)
      {
        try
        {
          NotifyReceiver.qc().lock();
          int i = paramk.getType();
          boolean bool2 = NotifyReceiver.qd().contains(Long.valueOf(l));
          if (NotifyReceiver.qb() != null)
          {
            bool1 = NotifyReceiver.qb().isLocking();
            v.i("MicroMsg.NotifyReceiver", "NotifyReceiver onSceneEnd type:%d syncHash: %d hashInMemo: %b isLocking: %b", new Object[] { Integer.valueOf(i), Long.valueOf(l), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            NotifyReceiver.qd().remove(Long.valueOf(l));
          }
        }
        finally
        {
          try
          {
            boolean bool1;
            NotifyReceiver.qc().unlock();
            if (NotifyReceiver.qd().isEmpty()) {
              synchronized (NotifyReceiver.qa())
              {
                if (NotifyReceiver.qb() != null) {
                  NotifyReceiver.qb().unLock();
                }
                v.i("MicroMsg.NotifyReceiver", "all scene done, unlock wakelock.");
                switch (paramk.getType())
                {
                default: 
                  C(7000L);
                  GMTrace.o(13459622199296L, 100282);
                  return;
                  bool1 = false;
                  continue;
                  ??? = finally;
                }
              }
            }
            try
            {
              NotifyReceiver.qc().unlock();
              throw ???;
              paramk = finally;
              throw paramk;
              v.i("MicroMsg.NotifyReceiver", "rest %d scene undone, keep wakelock.", new Object[] { Integer.valueOf(NotifyReceiver.qd().size()) });
              continue;
              if (com.tencent.mm.kernel.h.vG().uV())
              {
                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
                {
                  public final boolean queueIdle()
                  {
                    GMTrace.i(13460964376576L, 100292);
                    NotifyReceiver.a locala = NotifyReceiver.a.this;
                    com.tencent.mm.kernel.h.vJ();
                    com.tencent.mm.kernel.h.vL().D(new NotifyReceiver.a.3(locala));
                    GMTrace.o(13460964376576L, 100292);
                    return false;
                  }
                });
                if ((paramInt1 == 0) && (paramInt2 == 0) && (com.tencent.mm.u.a.wI()))
                {
                  try
                  {
                    com.tencent.mm.kernel.h.vJ();
                    ??? = com.tencent.mm.kernel.h.vG().gWZ;
                    if (???.hkp > -1L) {
                      ???.hkp += 1L;
                    }
                    v.i("MicroMsg.AccInfoCacheInWorker", "countNormalCgi :%s ", new Object[] { Long.valueOf(???.hkp) });
                    if ((???.hkp != 2L) && (???.hkp != 5L)) {
                      continue;
                    }
                    paramk = c.oRz;
                    if (???.hkp != 2L) {
                      continue;
                    }
                    l = 37L;
                    paramk.a(226L, l, 1L, false);
                    c.oRz.i(11098, new Object[] { Integer.valueOf(2001), Long.valueOf(???.hkp) });
                  }
                  catch (Throwable ???)
                  {
                    v.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", new Object[] { bf.g(???) });
                  }
                  continue;
                  l = 38L;
                }
              }
            }
            catch (Exception paramk) {}
          }
          catch (Exception ???) {}
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/NotifyReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */