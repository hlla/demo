package com.tencent.mm.modelfriend;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.ContentObserver;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.hx;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.n;
import java.util.Random;

public final class AddrBookObserver
  extends ContentObserver
{
  private static ad handler;
  private static boolean hzK;
  private static Intent hzL;
  private final Context context;
  
  static
  {
    GMTrace.i(4444217409536L, 33112);
    hzK = false;
    handler = new ad(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(4448915030016L, 33147);
        super.handleMessage(paramAnonymousMessage);
        paramAnonymousMessage = (Context)paramAnonymousMessage.obj;
        if (AddrBookObserver.EL() == null)
        {
          AddrBookObserver.n(new Intent());
          AddrBookObserver.EL().setClass(paramAnonymousMessage, AddrBookObserver.AddrBookService.class);
        }
        float f = new Random(System.currentTimeMillis()).nextFloat();
        AddrBookObserver.EL().putExtra(AddrBookObserver.AddrBookService.hzM, f);
        try
        {
          v.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", new Object[] { Float.valueOf(f) });
          paramAnonymousMessage.startService(AddrBookObserver.EL());
          GMTrace.o(4448915030016L, 33147);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          v.printErrStackTrace("MicroMsg.AddrBookObserver", paramAnonymousMessage, "startService failed", new Object[0]);
          GMTrace.o(4448915030016L, 33147);
        }
      }
    };
    GMTrace.o(4444217409536L, 33112);
  }
  
  public AddrBookObserver(Context paramContext)
  {
    super(ad.fetchFreeHandler());
    GMTrace.i(4443680538624L, 33108);
    this.context = paramContext;
    GMTrace.o(4443680538624L, 33108);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    GMTrace.i(4443814756352L, 33109);
    super.onChange(paramBoolean);
    v.i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
    if (hzK)
    {
      v.e("MicroMsg.AddrBookObserver", "isSyncing:" + hzK + ", is time to sync:true , return");
      GMTrace.o(4443814756352L, 33109);
      return;
    }
    handler.removeMessages(0);
    Message localMessage = handler.obtainMessage();
    localMessage.obj = this.context;
    localMessage.what = 0;
    handler.sendMessageDelayed(localMessage, 20000L);
    GMTrace.o(4443814756352L, 33109);
  }
  
  public static class AddrBookService
    extends Service
  {
    public static boolean hsp;
    public static boolean hzK;
    public static String hzM;
    private a.b hzN;
    
    static
    {
      GMTrace.i(4445962240000L, 33125);
      hzM = "key_sync_session";
      hsp = false;
      hzK = false;
      GMTrace.o(4445962240000L, 33125);
    }
    
    public AddrBookService()
    {
      GMTrace.i(4445559586816L, 33122);
      this.hzN = new a.b()
      {
        public final void bg(boolean paramAnonymousBoolean)
        {
          GMTrace.i(4431064072192L, 33014);
          if (!paramAnonymousBoolean)
          {
            v.v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
            AddrBookObserver.AddrBookService.this.stopSelf();
            AddrBookObserver.AddrBookService.hzK = false;
            GMTrace.o(4431064072192L, 33014);
            return;
          }
          System.currentTimeMillis();
          aa localaa = new aa(m.Ft(), m.Fs());
          ap.vd().a(localaa, 0);
          AddrBookObserver.AddrBookService.this.stopSelf();
          AddrBookObserver.AddrBookService.hzK = false;
          GMTrace.o(4431064072192L, 33014);
        }
      };
      GMTrace.o(4445559586816L, 33122);
    }
    
    public IBinder onBind(Intent paramIntent)
    {
      GMTrace.i(4445828022272L, 33124);
      GMTrace.o(4445828022272L, 33124);
      return null;
    }
    
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      GMTrace.i(4445693804544L, 33123);
      super.onStartCommand(paramIntent, paramInt1, paramInt2);
      if (paramIntent == null) {}
      for (boolean bool = true;; bool = false)
      {
        v.i("MicroMsg.AddrBookObserver", "service start intent:%b", new Object[] { Boolean.valueOf(bool) });
        if (paramIntent != null) {
          break;
        }
        v.e("MicroMsg.AddrBookObserver", "intent == null, stop service");
        stopSelf();
        GMTrace.o(4445693804544L, 33123);
        return 2;
      }
      float f1 = paramIntent.getFloatExtra(hzM, -1.0F);
      if (f1 == -1.0F)
      {
        v.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
        stopSelf();
        GMTrace.o(4445693804544L, 33123);
        return 2;
      }
      paramIntent = com.tencent.mm.sdk.platformtools.aa.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.aa.bIN(), 0);
      float f2 = paramIntent.getFloat(hzM, 0.0F);
      if (f2 == f1)
      {
        v.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", new Object[] { Float.valueOf(f2) });
        stopSelf();
        GMTrace.o(4445693804544L, 33123);
        return 2;
      }
      paramIntent.edit().putFloat(hzM, f1).commit();
      v.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", new Object[] { Float.valueOf(f1) });
      if (hsp)
      {
        v.i("MicroMsg.AddrBookObserver", "service canceled");
        hsp = false;
        stopSelf();
        GMTrace.o(4445693804544L, 33123);
        return 2;
      }
      if (ap.yQ())
      {
        v.e("MicroMsg.AddrBookObserver", "[onStartCommand] getCode is null, stop service");
        stopSelf();
        GMTrace.o(4445693804544L, 33123);
        return 2;
      }
      h.vG().initialize();
      for (;;)
      {
        try
        {
          if (!ap.zb())
          {
            v.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
            stopSelf();
            GMTrace.o(4445693804544L, 33123);
            return 2;
          }
          if (com.tencent.mm.plugin.ipcall.d.aDF())
          {
            paramIntent = new hx();
            com.tencent.mm.sdk.b.a.uql.m(paramIntent);
          }
          if ((!m.Fp()) || (m.Fl())) {
            continue;
          }
          v.i("MicroMsg.AddrBookObserver", "start sync");
          if (com.tencent.mm.modelsimple.d.bg(this)) {
            continue;
          }
          hzK = true;
          a.a(this.hzN);
        }
        catch (Exception paramIntent)
        {
          v.printErrStackTrace("MicroMsg.AddrBookObserver", paramIntent, "", new Object[0]);
          v.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", new Object[] { paramIntent.getMessage() });
          stopSelf();
          continue;
        }
        GMTrace.o(4445693804544L, 33123);
        return 2;
        v.e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
        stopSelf();
        GMTrace.o(4445693804544L, 33123);
        return 2;
        v.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
        stopSelf();
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/AddrBookObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */