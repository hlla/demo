package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.a.e;
import com.tencent.mm.b.i.a;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class j
  implements a, g
{
  public String desc;
  public String fFN;
  public int fMU;
  public int fuP;
  public String fuR;
  public byte[] htw;
  public byte[] idE;
  public byte[] idG;
  private Intent intent;
  protected Context mContext;
  private Notification qWm;
  public int qtT;
  public int size;
  public int uin;
  public String[] uoM;
  public int uok;
  public com.tencent.mm.sandbox.monitor.c upC;
  ArrayList<g> upD;
  public String[] upE;
  public String upF;
  public com.tencent.mm.b.i upG;
  public i.a upH;
  public boolean upI;
  public boolean upJ;
  public boolean upK;
  public String upL;
  public boolean upM;
  public boolean upN;
  long upO;
  public f upP;
  private long upQ;
  private b.a upR;
  
  public j()
  {
    GMTrace.i(3569654693888L, 26596);
    this.upC = null;
    this.upD = new ArrayList(1);
    this.fMU = d.sXh;
    this.upI = false;
    this.upJ = false;
    this.upK = false;
    this.upM = false;
    this.upN = false;
    this.intent = null;
    this.qWm = null;
    this.mContext = null;
    this.upP = new f(this);
    this.upQ = -1L;
    this.upR = new b.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, avm paramAnonymousavm)
      {
        GMTrace.i(3579721023488L, 26671);
        j.this.upN = false;
        j.this.upP.stop();
        j.this.upO = System.currentTimeMillis();
        if (j.this.upC == null)
        {
          j.this.ad(2, true);
          GMTrace.o(3579721023488L, 26671);
          return;
        }
        if ((paramAnonymousInt1 == 200) && (paramAnonymousInt2 == 0))
        {
          v.i("MicroMsg.UpdaterManager", "packCallback onSceneEnd ok");
          if (j.this.qtT != 2) {
            j.this.dL(100, 100);
          }
          if (j.this.upI)
          {
            i.X(j.this.mContext, 0);
            paramAnonymousavm = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "yyb_pkg_sig_prefs", 4);
            j.this.upF = paramAnonymousavm.getString(aa.getPackageName(), "");
            v.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess onSceneEnd sig[%s], path[%s]", new Object[] { j.this.upF, j.this.upC.bHC() });
            if (bf.mA(j.this.upF)) {
              break label452;
            }
          }
          for (;;)
          {
            try
            {
              com.tencent.mm.b.c.a(new File(j.this.upC.bHC()), j.this.upF);
              v.i("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode done");
              com.tencent.mm.plugin.report.service.g.oSF.a(322L, 6L, 1L, false);
              com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4006), j.this.upF });
              if (j.this.qtT != 1) {
                break label491;
              }
              i.Y(j.this.mContext, 8);
              j.this.bIe();
              j.this.FU(j.this.upC.bHC());
              if (j.this.upM) {
                com.tencent.mm.plugin.report.service.g.oSF.a(614L, 58L, 1L, false);
              }
              i.bHW();
              GMTrace.o(3579721023488L, 26671);
              return;
              i.X(j.this.mContext, 9);
            }
            catch (Exception paramAnonymousavm)
            {
              v.w("MicroMsg.UpdaterManager", "summertoken downloadsuccess writeSecurityCode e: " + paramAnonymousavm.getMessage());
              com.tencent.mm.plugin.report.service.g.oSF.a(322L, 7L, 1L, false);
              com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4007), paramAnonymousavm.getMessage() });
              continue;
            }
            label452:
            com.tencent.mm.plugin.report.service.g.oSF.a(322L, 8L, 1L, false);
            com.tencent.mm.plugin.report.service.g.oSF.i(11098, new Object[] { Integer.valueOf(4008) });
            continue;
            label491:
            if (j.this.qtT == 0)
            {
              j.this.FU(j.this.upC.bHC());
            }
            else if (j.this.qtT == 2)
            {
              i.Y(j.this.mContext, 1);
              j.this.bIe();
            }
          }
        }
        if (paramAnonymousInt2 == -13)
        {
          v.e("MicroMsg.UpdaterManager", "session timeout, killself and restart");
          UpdaterService.cj();
          AppUpdaterUI.bHG();
          i.bHV();
          GMTrace.o(3579721023488L, 26671);
          return;
        }
        if (((j.this.upC instanceof c)) && (j.this.uok != 4))
        {
          v.e("MicroMsg.UpdaterManager", "download package from cdn error.");
          if (j.this.upI)
          {
            if ((paramAnonymousInt1 == 3) || (paramAnonymousInt1 == 4) || (paramAnonymousInt1 == 2) || (paramAnonymousInt1 == 1) || (paramAnonymousInt1 == 13)) {
              i.X(j.this.mContext, paramAnonymousInt1);
            }
            j.this.upI = false;
            if (j.this.qtT == 1) {
              if (j.this.upM) {
                switch (paramAnonymousInt1)
                {
                }
              }
            }
          }
        }
        for (;;)
        {
          j.this.a(j.this.upC);
          GMTrace.o(3579721023488L, 26671);
          return;
          com.tencent.mm.plugin.report.service.g.oSF.a(614L, 52L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.g.oSF.a(614L, 53L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.g.oSF.a(614L, 54L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.g.oSF.a(614L, 51L, 1L, false);
          continue;
          com.tencent.mm.plugin.report.service.g.oSF.a(614L, 55L, 1L, false);
          continue;
          j.this.bIc();
          continue;
          if (j.this.qtT == 0)
          {
            j.this.ad(1, true);
          }
          else if (j.this.qtT == 2)
          {
            j.this.bIf();
            continue;
            paramAnonymousavm = j.this;
            paramAnonymousInt1 = j.this.size;
            String str = j.this.fFN;
            paramAnonymousInt2 = j.this.uok;
            int i = j.this.uin;
            byte[] arrayOfByte1 = j.this.idE;
            byte[] arrayOfByte2 = j.this.htw;
            String[] arrayOfString = j.this.upE;
            if (j.this.qtT == 2) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousavm.upC = new b(paramAnonymousInt1, str, paramAnonymousInt2, i, arrayOfByte1, arrayOfByte2, arrayOfString, bool);
              j.this.bId();
              break;
            }
            v.e("MicroMsg.UpdaterManager", "update failed");
            i.X(j.this.mContext, 10);
            if (j.this.qtT == 1) {
              j.this.bIb();
            } else if (j.this.qtT == 0) {
              j.this.ad(1, true);
            }
          }
        }
      }
      
      public final void cx(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(3579586805760L, 26670);
        v.i("MicroMsg.UpdaterManager", "total=%d, offset=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (j.this.qtT != 2) {
          j.this.dL(paramAnonymousInt2, paramAnonymousInt1);
        }
        j.this.cx(paramAnonymousInt1, paramAnonymousInt2);
        GMTrace.o(3579586805760L, 26670);
      }
      
      public final void eq(long paramAnonymousLong)
      {
        GMTrace.i(3579855241216L, 26672);
        f localf = j.this.upP;
        localf.fyz.post(new f.2(localf, paramAnonymousLong));
        GMTrace.o(3579855241216L, 26672);
      }
      
      public final void er(long paramAnonymousLong)
      {
        GMTrace.i(3579989458944L, 26673);
        f localf = j.this.upP;
        localf.fyz.post(new f.3(localf, paramAnonymousLong));
        GMTrace.o(3579989458944L, 26673);
      }
    };
    this.mContext = aa.getContext();
    GMTrace.o(3569654693888L, 26596);
  }
  
  private void bIa()
  {
    GMTrace.i(3570862653440L, 26605);
    MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bf.Nz() - 86400L).commit();
    ad(2, true);
    bHJ();
    GMTrace.o(3570862653440L, 26605);
  }
  
  private void jL(boolean paramBoolean)
  {
    boolean bool = true;
    GMTrace.i(3570325782528L, 26601);
    v.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", new Object[] { Boolean.valueOf(paramBoolean) });
    v.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.qtT), Boolean.valueOf(this.upN) });
    if (this.intent == null)
    {
      v.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
      GMTrace.o(3570325782528L, 26601);
      return;
    }
    if (this.upN)
    {
      v.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
      GMTrace.o(3570325782528L, 26601);
      return;
    }
    if (!h.getExternalStorageState().equals("mounted"))
    {
      v.e("MicroMsg.UpdaterManager", "no sdcard.");
      MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bf.Nz() - 86400L).commit();
      ad(2, true);
      bHI();
      GMTrace.o(3570325782528L, 26601);
      return;
    }
    if ((this.qtT == 2) && (!paramBoolean)) {
      i.Y(this.mContext, 0);
    }
    String str1 = com.tencent.mm.sandbox.monitor.c.DC(this.fFN);
    v.i("MicroMsg.UpdaterManager", str1);
    if (str1 != null)
    {
      v.i("MicroMsg.UpdaterManager", "update package already exist.");
      ad(1, true);
      FU(str1);
      if ((this.qtT == 2) && (!i.OX(this.fFN))) {
        i.a(this.fFN, this.upF, this.desc, this.size, this.qtT, this.uok, this.upL);
      }
      GMTrace.o(3570325782528L, 26601);
      return;
    }
    if (this.upK)
    {
      if (this.upC != null) {
        this.upC.deleteTempFile();
      }
      i.X(this.mContext, 11);
    }
    if ((!this.upK) && (this.upI) && (this.upG != null) && (this.upH != null))
    {
      v.i("MicroMsg.UpdaterManager", "Incresment Update");
      i.X(this.mContext, 5);
      if (!com.tencent.mm.compatible.util.f.G(this.size + this.upH.size))
      {
        bIa();
        GMTrace.o(3570325782528L, 26601);
        return;
      }
      cancel();
      int i = this.upH.size;
      str1 = this.fFN;
      int j = this.uok;
      String str2 = this.upG.fvc + this.upH.url;
      String str3 = this.upH.fvg;
      String str4 = this.upH.fvf;
      if (this.qtT == 2) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.upC = new c(i, str1, j, str2, str3, str4, paramBoolean);
        bId();
        GMTrace.o(3570325782528L, 26601);
        return;
      }
    }
    if (!com.tencent.mm.compatible.util.f.G(this.size))
    {
      v.e("MicroMsg.UpdaterManager", "SDCard is full");
      bIa();
      GMTrace.o(3570325782528L, 26601);
      return;
    }
    bIf();
    GMTrace.o(3570325782528L, 26601);
  }
  
  private void reset()
  {
    GMTrace.i(3570728435712L, 26604);
    cancel();
    this.fuP = 0;
    this.fuR = null;
    this.upE = null;
    this.fMU = d.sXh;
    this.uok = 0;
    this.idE = null;
    this.htw = null;
    this.idG = null;
    this.uin = 0;
    this.fFN = null;
    this.size = 0;
    this.desc = null;
    this.uoM = null;
    this.upG = null;
    this.upH = null;
    this.upI = false;
    this.upJ = false;
    this.qtT = 0;
    this.upK = false;
    this.intent = null;
    this.upN = false;
    this.qWm = null;
    this.upQ = 0L;
    GMTrace.o(3570728435712L, 26604);
  }
  
  public final void FU(String paramString)
  {
    GMTrace.i(3571533742080L, 26610);
    Iterator localIterator = this.upD.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).FU(paramString);
    }
    GMTrace.o(3571533742080L, 26610);
  }
  
  public final void a(com.tencent.mm.sandbox.monitor.c paramc)
  {
    GMTrace.i(3571667959808L, 26611);
    Iterator localIterator = this.upD.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(paramc);
    }
    GMTrace.o(3571667959808L, 26611);
  }
  
  public final boolean ab(Intent paramIntent)
  {
    GMTrace.i(3569923129344L, 26598);
    boolean bool = ac(paramIntent);
    v.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      jL(false);
    }
    GMTrace.o(3569923129344L, 26598);
    return bool;
  }
  
  public final boolean ac(Intent paramIntent)
  {
    GMTrace.i(3570057347072L, 26599);
    v.i("MicroMsg.UpdaterManager", "handleCommand(Intent intent)");
    if (paramIntent == null)
    {
      v.i("MicroMsg.UpdaterManager", "intent == null");
      GMTrace.o(3570057347072L, 26599);
      return false;
    }
    int j = paramIntent.getIntExtra("intent_update_type", 3);
    int i = paramIntent.getIntExtra("intent_extra_download_mode", 1);
    String str = paramIntent.getStringExtra("intent_extra_md5");
    if ((this.upN) && (!str.equalsIgnoreCase(this.fFN)) && (this.qtT == 2)) {
      cancel();
    }
    Object localObject1;
    while (!this.upN)
    {
      i.bHW();
      reset();
      this.intent = paramIntent;
      this.fuP = paramIntent.getIntExtra("intent_extra_updateMode", 0);
      this.fuR = paramIntent.getStringExtra("intent_extra_marketUrl");
      this.upE = paramIntent.getStringArrayExtra("intent_short_ips");
      this.fMU = paramIntent.getIntExtra("intent_client_version", d.sXh);
      d.sXh = this.fMU;
      this.uok = j;
      this.idE = paramIntent.getByteArrayExtra("intent_extra_session");
      this.htw = paramIntent.getByteArrayExtra("intent_extra_cookie");
      this.idG = paramIntent.getByteArrayExtra("intent_extra_ecdhkey");
      this.uin = paramIntent.getIntExtra("intent_extra_uin", 0);
      this.fFN = str;
      this.desc = paramIntent.getStringExtra("intent_extra_desc");
      this.size = paramIntent.getIntExtra("intent_extra_size", 0);
      this.uoM = paramIntent.getStringArrayExtra("intent_extra_download_url");
      this.qtT = i;
      this.upK = paramIntent.getBooleanExtra("intent_extra_force_download_full", false);
      localObject1 = paramIntent.getStringExtra("intent_extra_patchInfo");
      if (localObject1 != null)
      {
        v.i("MicroMsg.UpdaterManager", "patchXml != null");
        this.upG = com.tencent.mm.b.i.bc((String)localObject1);
      }
      localObject1 = paramIntent.getStringExtra("intent_extra_extinfo");
      v.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", new Object[] { localObject1 });
      if (!bf.mA((String)localObject1))
      {
        this.upL = ((String)bg.q((String)localObject1, "extinfo").get(".extinfo.notautodownloadrange"));
        v.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", new Object[] { this.upL });
      }
      v.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.upN) });
      if ((j != 999) || (this.uoM == null) || (this.uoM.length <= 0)) {
        break;
      }
      if (i == 2) {
        v.e("MicroMsg.UpdaterManager", "error! DOWNLOAD_MODE_SLIENCE download don't go here! we must process it before start download");
      }
      GMTrace.o(3570057347072L, 26599);
      return true;
    }
    v.i("MicroMsg.UpdaterManager", "downloading, duplicate download request");
    GMTrace.o(3570057347072L, 26599);
    return true;
    Object localObject2;
    if (this.uoM != null)
    {
      localObject1 = this.uoM;
      int k = localObject1.length;
      i = 0;
      while (i < k)
      {
        localObject2 = localObject1[i];
        v.i("MicroMsg.UpdaterManager", "download url : " + (String)localObject2);
        i += 1;
      }
    }
    v.i("MicroMsg.UpdaterManager", "md5 = %s , size = %s", new Object[] { str, Integer.valueOf(this.size) });
    if ((str == null) || (this.size == 0))
    {
      GMTrace.o(3570057347072L, 26599);
      return false;
    }
    if (j == 2)
    {
      boolean bool = com.tencent.mm.modelcontrol.b.iU(this.upL);
      v.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.plugin.report.service.g.oSF.a(405L, 78L, 1L, true);
        GMTrace.o(3570057347072L, 26599);
        return false;
      }
    }
    if (this.upG != null)
    {
      v.i("MicroMsg.UpdaterManager", "patchInfo != null");
      localObject1 = i.dS(this.mContext);
      this.upH = this.upG.bb((String)localObject1);
      localObject2 = new StringBuilder("increase apkMD5 = ").append((String)localObject1).append(" : ");
      if (this.upH == null)
      {
        localObject1 = "not match";
        v.i("MicroMsg.UpdaterManager", (String)localObject1);
      }
    }
    else
    {
      v.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", new Object[] { Boolean.valueOf(this.upK) });
      this.upM = paramIntent.getBooleanExtra("intent_extra_tinker_patch", false);
      if (((this.upH == null) || (com.tencent.mm.sandbox.monitor.c.OV(str))) && (!this.upM)) {
        break label854;
      }
      v.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
      this.upI = true;
    }
    for (;;)
    {
      paramIntent = i.Nv();
      if ((!bf.mA(paramIntent)) && (!paramIntent.equals(str))) {
        i.bHX();
      }
      GMTrace.o(3570057347072L, 26599);
      return true;
      localObject1 = "match";
      break;
      label854:
      v.i("MicroMsg.UpdaterManager", "had try to download full pack.");
    }
  }
  
  public final void ad(final int paramInt, boolean paramBoolean)
  {
    GMTrace.i(3570460000256L, 26602);
    this.upJ = paramBoolean;
    new ad().postDelayed(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(3581331636224L, 26683);
        ((NotificationManager)j.this.mContext.getSystemService("notification")).cancel(99);
        v.d("MicroMsg.UpdaterManager", "finishType == " + paramInt);
        if ((paramInt == 2) && (j.this.uok == 1))
        {
          Intent localIntent = new Intent();
          localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
          j.this.mContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        }
        GMTrace.o(3581331636224L, 26683);
      }
    }, 300L);
    GMTrace.o(3570460000256L, 26602);
  }
  
  public final void bHI()
  {
    GMTrace.i(3571802177536L, 26612);
    Iterator localIterator = this.upD.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).bHI();
    }
    GMTrace.o(3571802177536L, 26612);
  }
  
  public final void bHJ()
  {
    GMTrace.i(3571936395264L, 26613);
    Iterator localIterator = this.upD.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).bHJ();
    }
    GMTrace.o(3571936395264L, 26613);
  }
  
  public final void bHZ()
  {
    GMTrace.i(15343368011776L, 114317);
    jL(false);
    GMTrace.o(15343368011776L, 114317);
  }
  
  public final void bIb()
  {
    GMTrace.i(16022107062272L, 119374);
    Object localObject1 = this.mContext.getString(R.l.dGz);
    Object localObject2 = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
    ((Intent)localObject2).addFlags(268435456);
    localObject2 = PendingIntent.getActivity(this.mContext, 0, (Intent)localObject2, 134217728);
    this.qWm = new Notification.Builder(this.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle((CharSequence)localObject1).setContentText(null).setContentIntent((PendingIntent)localObject2).getNotification();
    this.qWm.icon = R.g.bkT;
    localObject1 = this.qWm;
    ((Notification)localObject1).flags |= 0x10;
    ((NotificationManager)this.mContext.getSystemService("notification")).notify(99, this.qWm);
    GMTrace.o(16022107062272L, 119374);
  }
  
  public final void bIc()
  {
    GMTrace.i(16022241280000L, 119375);
    v.i("MicroMsg.UpdaterManager", "showDownloadFullPackNotification()");
    Object localObject1 = this.mContext.getString(R.l.dGA, new Object[] { bf.ay(this.size) });
    Object localObject2 = this.intent;
    ((Intent)localObject2).putExtra("intent_extra_force_download_full", true);
    localObject2 = PendingIntent.getService(this.mContext, 0, (Intent)localObject2, 134217728);
    this.qWm = new Notification.Builder(this.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle((CharSequence)localObject1).setContentText(null).setContentIntent((PendingIntent)localObject2).getNotification();
    this.qWm.icon = R.g.bkT;
    localObject1 = this.qWm;
    ((Notification)localObject1).flags |= 0x10;
    ((NotificationManager)this.mContext.getSystemService("notification")).notify(99, this.qWm);
    GMTrace.o(16022241280000L, 119375);
  }
  
  public final void bId()
  {
    GMTrace.i(3570996871168L, 26606);
    if ((this.qtT == 2) && (!al.isWifi(this.mContext)))
    {
      i.bHU();
      v.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
      GMTrace.o(3570996871168L, 26606);
      return;
    }
    if ((this.qtT == 2) && (f.OW(this.fFN)))
    {
      v.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
      this.upP.stop();
      GMTrace.o(3570996871168L, 26606);
      return;
    }
    this.upP.cy(this.fFN, this.size);
    if (this.upC != null)
    {
      ad(1, false);
      this.upN = true;
      this.upC.a(this.upR);
      bgf();
      if (this.qtT == 2) {
        i.bHU();
      }
    }
    GMTrace.o(3570996871168L, 26606);
  }
  
  public final void bIe()
  {
    GMTrace.i(16022509715456L, 119377);
    i.a(this.fFN, this.upF, this.desc, this.size, this.qtT, this.uok, this.upL);
    GMTrace.o(16022509715456L, 119377);
  }
  
  public final void bIf()
  {
    GMTrace.i(3571131088896L, 26607);
    cancel();
    v.i("MicroMsg.UpdaterManager", "downloadFullPack");
    i.X(this.mContext, 7);
    if ((this.uoM != null) && (this.uoM.length > 0))
    {
      i = this.size;
      str = this.fFN;
      j = this.uok;
      localObject = this.uoM;
      if (this.qtT == 2) {}
      for (bool = true;; bool = false)
      {
        this.upC = new c(i, str, j, (String[])localObject, bool);
        com.tencent.mm.plugin.report.service.g.oSF.a(405L, 76L, 1L, true);
        bId();
        GMTrace.o(3571131088896L, 26607);
        return;
      }
    }
    int i = this.size;
    String str = this.fFN;
    int j = this.uok;
    int k = this.uin;
    Object localObject = this.idE;
    byte[] arrayOfByte = this.htw;
    String[] arrayOfString = this.upE;
    if (this.qtT == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.upC = new b(i, str, j, k, (byte[])localObject, arrayOfByte, arrayOfString, bool);
      com.tencent.mm.plugin.report.service.g.oSF.a(405L, 77L, 1L, true);
      break;
    }
  }
  
  public final void bgf()
  {
    GMTrace.i(3571399524352L, 26609);
    Iterator localIterator = this.upD.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).bgf();
    }
    GMTrace.o(3571399524352L, 26609);
  }
  
  public final void cancel()
  {
    GMTrace.i(3570594217984L, 26603);
    if (this.upC != null)
    {
      this.upN = false;
      this.upC.cancel();
      this.upC = null;
      this.upO = System.currentTimeMillis();
      this.upP.stop();
    }
    GMTrace.o(3570594217984L, 26603);
  }
  
  public final void cx(int paramInt1, int paramInt2)
  {
    GMTrace.i(3571265306624L, 26608);
    Iterator localIterator = this.upD.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).cx(paramInt1, paramInt2);
    }
    GMTrace.o(3571265306624L, 26608);
  }
  
  public final void dL(int paramInt1, int paramInt2)
  {
    GMTrace.i(16022375497728L, 119376);
    Object localObject1 = this.mContext.getString(R.l.dGy);
    String str;
    Object localObject2;
    if (paramInt1 < paramInt2)
    {
      long l = paramInt1 * 100L / paramInt2;
      if (l - this.upQ < 1L)
      {
        GMTrace.o(16022375497728L, 119376);
        return;
      }
      this.upQ = l;
      str = this.mContext.getString(R.l.dGB) + String.valueOf(this.upQ) + "%";
      localObject2 = new Intent(this.intent);
      ((Intent)localObject2).setClass(this.mContext, AppUpdaterUI.class);
      ((Intent)localObject2).addFlags(536870912);
      localObject2 = PendingIntent.getActivity(this.mContext, 0, (Intent)localObject2, 134217728);
      localObject1 = new Notification.Builder(this.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle((CharSequence)localObject1).setContentText(str).setContentIntent((PendingIntent)localObject2);
      ((Notification.Builder)localObject1).setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), R.g.bkT));
      ((Notification.Builder)localObject1).setSmallIcon(com.tencent.mm.ba.a.bCc());
      this.qWm = ((Notification.Builder)localObject1).getNotification();
      this.qWm.icon = R.g.bkT;
    }
    for (;;)
    {
      if (!this.upJ) {
        ((NotificationManager)this.mContext.getSystemService("notification")).notify(99, this.qWm);
      }
      GMTrace.o(16022375497728L, 119376);
      return;
      if ((this.upM) && (!e.aO(this.upC.bHC())))
      {
        v.i("MicroMsg.UpdaterManager", "do noting. wait for merge apk.");
      }
      else
      {
        str = this.mContext.getString(R.l.dGx);
        localObject2 = new Intent("android.intent.action.VIEW");
        ((Intent)localObject2).setDataAndType(Uri.fromFile(new File(this.upC.bHC())), "application/vnd.android.package-archive");
        ((Intent)localObject2).addFlags(536870912);
        localObject2 = PendingIntent.getActivity(this.mContext, 0, (Intent)localObject2, 134217728);
        localObject1 = new Notification.Builder(this.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle((CharSequence)localObject1).setContentText(str).setContentIntent((PendingIntent)localObject2);
        ((Notification.Builder)localObject1).setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), R.g.bkT));
        ((Notification.Builder)localObject1).setSmallIcon(com.tencent.mm.ba.a.bCc());
        this.qWm = ((Notification.Builder)localObject1).getNotification();
        this.qWm.icon = R.g.bkT;
        localObject1 = this.qWm;
        ((Notification)localObject1).flags |= 0x10;
      }
    }
  }
  
  public final boolean isBusy()
  {
    GMTrace.i(3572070612992L, 26614);
    if ((this.upN) || (System.currentTimeMillis() - this.upO <= UpdaterService.upX))
    {
      v.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", new Object[] { Boolean.valueOf(this.upN), Long.valueOf(this.upO), Long.valueOf(System.currentTimeMillis() - this.upO) });
      GMTrace.o(3572070612992L, 26614);
      return true;
    }
    v.i("MicroMsg.UpdaterManager", "not busy");
    GMTrace.o(3572070612992L, 26614);
    return false;
  }
  
  public final void jJ(boolean paramBoolean)
  {
    GMTrace.i(3569788911616L, 26597);
    v.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", new Object[] { Boolean.valueOf(paramBoolean) });
    f localf = this.upP;
    if (localf.lEf != paramBoolean)
    {
      localf.jK(true);
      localf.lEf = paramBoolean;
    }
    if ((this.qtT != 2) || (this.upN))
    {
      v.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", new Object[] { Integer.valueOf(this.qtT), Boolean.valueOf(this.upN) });
      GMTrace.o(3569788911616L, 26597);
      return;
    }
    if (paramBoolean)
    {
      if (ac(this.intent))
      {
        jL(true);
        GMTrace.o(3569788911616L, 26597);
      }
    }
    else if (this.upN) {
      cancel();
    }
    GMTrace.o(3569788911616L, 26597);
  }
  
  public final void onDestroy()
  {
    GMTrace.i(3572204830720L, 26615);
    v.i("MicroMsg.UpdaterManager", "onDestroy");
    if (!this.upN)
    {
      reset();
      ad(1, true);
    }
    GMTrace.o(3572204830720L, 26615);
  }
  
  private static final class a
  {
    public static final j upU;
    
    static
    {
      GMTrace.i(3593411231744L, 26773);
      upU = new j();
      GMTrace.o(3593411231744L, 26773);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/updater/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */