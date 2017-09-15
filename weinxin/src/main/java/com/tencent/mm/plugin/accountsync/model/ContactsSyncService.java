package com.tencent.mm.plugin.accountsync.model;

import android.accounts.Account;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelsimple.b;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class ContactsSyncService
  extends Service
  implements com.tencent.mm.y.e
{
  private static Account hRh;
  private a irN;
  private Looper irO;
  
  public ContactsSyncService()
  {
    GMTrace.i(7832141299712L, 58354);
    this.irN = null;
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
    GMTrace.o(7832141299712L, 58354);
  }
  
  private void OD()
  {
    GMTrace.i(7832543952896L, 58357);
    if (this.irO != null) {
      this.irO.quit();
    }
    GMTrace.o(7832543952896L, 58357);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(7832409735168L, 58356);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsSyncService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramk.getType());
    if (paramk.getType() == 133)
    {
      ap.vd().b(133, this);
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      ap.yY();
      long l1 = ((Long)c.vr().get(327728, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + l2 + ", lastTime=" + l1);
      if ((paramInt2 != 0) && (l2 - l1 < 86400000L))
      {
        OD();
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
        GMTrace.o(7832409735168L, 58356);
        return;
      }
      ap.yY();
      c.vr().set(327728, Long.valueOf(l2));
      ap.vd().a(32, this);
      paramString = (aa)paramk;
      paramString = new com.tencent.mm.modelfriend.v(paramString.hBw, paramString.hBx);
      ap.vd().a(paramString, 0);
    }
    if (paramk.getType() == 32)
    {
      ap.vd().b(32, this);
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        com.tencent.mm.sdk.f.e.b(new b(this, hRh), "MMAccountManager_updateLocalContacts").start();
      }
      OD();
    }
    GMTrace.o(7832409735168L, 58356);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    GMTrace.i(7832275517440L, 58355);
    paramIntent = null;
    if (a.aS(this, "android.permission.READ_CONTACTS"))
    {
      if (this.irN == null) {
        this.irN = new a(getApplicationContext());
      }
      paramIntent = this.irN.getSyncAdapterBinder();
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind ret[%s]", new Object[] { paramIntent });
      GMTrace.o(7832275517440L, 58355);
      return paramIntent;
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind no permission");
    }
  }
  
  public void onDestroy()
  {
    GMTrace.i(7832678170624L, 58358);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsSyncService", "contacts sync service destory");
    super.onDestroy();
    GMTrace.o(7832678170624L, 58358);
  }
  
  private final class a
    extends AbstractThreadedSyncAdapter
  {
    private Context mContext;
    
    public a(Context paramContext)
    {
      super(true);
      GMTrace.i(7831201775616L, 58347);
      this.mContext = paramContext;
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl construction");
      GMTrace.o(7831201775616L, 58347);
    }
    
    public final void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
    {
      GMTrace.i(7831335993344L, 58348);
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl onPerformSync");
      if (!ap.zb())
      {
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ContactsSyncService", "ContactsSyncService account not ready, ignore this sync");
        GMTrace.o(7831335993344L, 58348);
        return;
      }
      try
      {
        Looper.prepare();
        ContactsSyncService.a(ContactsSyncService.this, Looper.myLooper());
        ContactsSyncService.a(ContactsSyncService.this, paramAccount);
        Looper.loop();
        GMTrace.o(7831335993344L, 58348);
        return;
      }
      catch (Exception paramAccount)
      {
        ContactsSyncService.a(ContactsSyncService.this);
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ContactsSyncService", "ContactsSyncService.onPerformSync error: " + paramAccount.getMessage());
        GMTrace.o(7831335993344L, 58348);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/accountsync/model/ContactsSyncService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */