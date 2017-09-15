package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.y.d;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.d.g;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.l;
import com.tencent.smtt.sdk.q;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.t;

public final class d
  implements a
{
  private Intent intent;
  Notification qWm;
  private a upb;
  int upc;
  boolean upd;
  private boolean upe;
  
  static
  {
    GMTrace.i(3599853682688L, 26821);
    TbsLog.setTbsLogClient(new t(aa.getContext())
    {
      public final void qM(String paramAnonymousString)
      {
        GMTrace.i(3580794765312L, 26679);
        v.i("TBSDownloadMgr.TbsLogClient", "TbsLogClient: " + paramAnonymousString);
        GMTrace.o(3580794765312L, 26679);
      }
    });
    GMTrace.o(3599853682688L, 26821);
  }
  
  public d()
  {
    GMTrace.i(3598779940864L, 26813);
    this.upb = null;
    this.intent = new Intent();
    this.qWm = null;
    this.upc = 999;
    this.upd = false;
    this.upe = false;
    GMTrace.o(3598779940864L, 26813);
  }
  
  public static d bHL()
  {
    GMTrace.i(3598645723136L, 26812);
    d locald = b.upg;
    GMTrace.o(3598645723136L, 26812);
    return locald;
  }
  
  private void bHM()
  {
    GMTrace.i(3599048376320L, 26815);
    l.fO(aa.getContext());
    SharedPreferences localSharedPreferences = aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
    if (localSharedPreferences != null)
    {
      v.i("MicroMsg.TBSDownloadMgr", "now start download,hasDownloadOverSea over sea = %b, is now oversea = %b", new Object[] { Boolean.valueOf(this.upe), Boolean.valueOf(this.upd) });
      if ((this.upe) || (this.upd)) {
        localSharedPreferences.edit().putBoolean("tbs_download_oversea", true).commit();
      }
    }
    GMTrace.o(3599048376320L, 26815);
  }
  
  public final boolean ab(Intent paramIntent)
  {
    GMTrace.i(3599182594048L, 26816);
    this.intent = paramIntent;
    if (this.intent.getIntExtra("intent_extra_download_type", 1) == 2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.upd = bool1;
      paramIntent = aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (paramIntent != null) {
        this.upe = paramIntent.getBoolean("tbs_download_oversea", false);
      }
      v.i("MicroMsg.TBSDownloadMgr", "isOverSea = %b, hasDownloadOverSea = %b", new Object[] { Boolean.valueOf(this.upd), Boolean.valueOf(this.upe) });
      if (!l.atd()) {
        break;
      }
      v.i("MicroMsg.TBSDownloadMgr", "TBS already downloading, ignore duplicated request");
      GMTrace.o(3599182594048L, 26816);
      return true;
    }
    paramIntent = aa.getContext();
    int i = WebView.getTbsCoreVersion(paramIntent);
    bool1 = l.q(paramIntent, this.upd | this.upe);
    boolean bool2 = al.isWifi(paramIntent);
    boolean bool3 = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
    v.i("MicroMsg.TBSDownloadMgr", "TBS download, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if (((bool2) || (bool3)) && (bool1))
    {
      if (this.upb == null)
      {
        this.upb = new a();
        QbSdk.setTbsListener(this.upb);
        j.mJ(2);
      }
      bHM();
      j.mJ(3);
      GMTrace.o(3599182594048L, 26816);
      return true;
    }
    GMTrace.o(3599182594048L, 26816);
    return false;
  }
  
  public final boolean isBusy()
  {
    GMTrace.i(3599316811776L, 26817);
    boolean bool1 = l.atd();
    boolean bool2 = QbSdk.getTBSInstalling();
    v.i("MicroMsg.TBSDownloadMgr", "isBusy isDownloading = %b, isInstalling = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) || (bool2))
    {
      GMTrace.o(3599316811776L, 26817);
      return true;
    }
    GMTrace.o(3599316811776L, 26817);
    return false;
  }
  
  public final void jJ(boolean paramBoolean)
  {
    GMTrace.i(3598914158592L, 26814);
    if (this.upb == null)
    {
      v.w("MicroMsg.TBSDownloadMgr", "TBS download not inited, ignore");
      GMTrace.o(3598914158592L, 26814);
      return;
    }
    Context localContext = aa.getContext();
    boolean bool1 = l.atd();
    boolean bool2 = l.q(localContext, this.upd | this.upe);
    boolean bool3 = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
    boolean bool4 = l.cef();
    v.i("MicroMsg.TBSDownloadMgr", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if (((paramBoolean) || (bool3)) && (!bool1) && (bool2))
    {
      bHM();
      j.mJ(3);
      GMTrace.o(3598914158592L, 26814);
      return;
    }
    if ((!paramBoolean) && (!bool3) && (bool1) && (!bool4))
    {
      l.stopDownload();
      j.mJ(4);
    }
    GMTrace.o(3598914158592L, 26814);
  }
  
  public final void onDestroy()
  {
    GMTrace.i(3599451029504L, 26818);
    v.i("MicroMsg.TBSDownloadMgr", "onDestroy");
    GMTrace.o(3599451029504L, 26818);
  }
  
  private final class a
    implements q
  {
    public a()
    {
      GMTrace.i(3575828709376L, 26642);
      GMTrace.o(3575828709376L, 26642);
    }
    
    public final void ir(int paramInt)
    {
      GMTrace.i(3575962927104L, 26643);
      v.i("MicroMsg.MyTbsListener", "onDownloadFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
      j.dJ(5, paramInt);
      if (paramInt != 110)
      {
        if (paramInt != 100) {
          break label110;
        }
        g.oSF.n(64, 64, 4, 3);
      }
      for (;;)
      {
        Object localObject = aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (localObject != null)
        {
          v.i("MicroMsg.MyTbsListener", "tbs has download finished, save to sharedpreference");
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putBoolean("tbs_download_finished", true);
          ((SharedPreferences.Editor)localObject).apply();
        }
        GMTrace.o(3575962927104L, 26643);
        return;
        label110:
        g.oSF.a(64L, 3L, 1L, false);
      }
    }
    
    public final void is(int paramInt)
    {
      GMTrace.i(3576097144832L, 26644);
      v.i("MicroMsg.MyTbsListener", "onInstallFinish, result = %d", new Object[] { Integer.valueOf(paramInt) });
      j.dJ(6, paramInt);
      if ((paramInt == 200) || (paramInt == 220))
      {
        g.oSF.n(64, 64, 7, 6);
        Object localObject1 = d.this;
        if (((d)localObject1).upd)
        {
          Object localObject2 = bf.bk(aa.getContext());
          v.i("MicroMsg.TBSDownloadMgr", "topActivityName = %s", new Object[] { localObject2 });
          if ((bf.mA((String)localObject2)) || (!((String)localObject2).equalsIgnoreCase("com.tencent.mm.plugin.webview.ui.tools.WebViewUI")))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).setComponent(new ComponentName(d.g.uMO, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            ((Intent)localObject2).putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
            aa.getContext().sendBroadcast((Intent)localObject2);
            Object localObject3 = aa.getContext();
            localObject2 = new y.d((Context)localObject3);
            NotificationManager localNotificationManager = (NotificationManager)((Context)localObject3).getSystemService("notification");
            ((y.d)localObject2).L(com.tencent.mm.ba.a.bCc());
            ((y.d)localObject2).a(((Context)localObject3).getString(R.l.fmw));
            ((y.d)localObject2).b(((Context)localObject3).getString(R.l.fmv));
            ((y.d)localObject2).j(2, false);
            ((y.d)localObject2).o(true);
            localObject3 = new Intent();
            ((y.d)localObject2).rR = PendingIntent.getActivity(aa.getContext(), 0, (Intent)localObject3, 0);
            ((d)localObject1).qWm = ((y.d)localObject2).build();
            localNotificationManager.notify(((d)localObject1).upc, ((d)localObject1).qWm);
            localObject1 = new Intent();
            ((Intent)localObject1).setComponent(new ComponentName(d.g.uMO, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            ((Intent)localObject1).putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            aa.getContext().sendBroadcast((Intent)localObject1);
          }
        }
        GMTrace.o(3576097144832L, 26644);
        return;
      }
      g.oSF.a(64L, 6L, 1L, false);
      GMTrace.o(3576097144832L, 26644);
    }
    
    public final void it(int paramInt)
    {
      GMTrace.i(3576231362560L, 26645);
      GMTrace.o(3576231362560L, 26645);
    }
  }
  
  private static final class b
  {
    public static final d upg;
    
    static
    {
      GMTrace.i(3569520476160L, 26595);
      upg = new d();
      GMTrace.o(3569520476160L, 26595);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/updater/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */