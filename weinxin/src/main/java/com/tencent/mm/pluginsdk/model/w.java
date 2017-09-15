package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.QbSdk.a;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.l;
import com.tencent.smtt.sdk.y;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.t;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class w
{
  private static long sBn;
  private static final Map<String, Object> sBo;
  
  static
  {
    GMTrace.i(749471793152L, 5584);
    sBo = new HashMap();
    GMTrace.o(749471793152L, 5584);
  }
  
  public static void Y(Intent paramIntent)
  {
    GMTrace.i(748934922240L, 5580);
    String str1 = paramIntent.getStringExtra("file_path");
    final String str2 = paramIntent.getStringExtra("file_ext");
    if (System.currentTimeMillis() - sBn < 1000L)
    {
      GMTrace.o(748934922240L, 5580);
      return;
    }
    if (bf.mA(str1))
    {
      GMTrace.o(748934922240L, 5580);
      return;
    }
    sBn = System.currentTimeMillis();
    final Context localContext = aa.getContext();
    paramIntent = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).putOpt("path", str1);
      ((JSONObject)localObject).putOpt("ext", str2);
      localObject = ((JSONObject)localObject).toString();
      paramIntent = (Intent)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.TBSHelper", localJSONException, "", new Object[0]);
      }
    }
    v.i("MicroMsg.TBSHelper", "openFileByMiniQB, file pathinfo:%s", new Object[] { paramIntent });
    QbSdk.canOpenFile(localContext, paramIntent, new y() {});
    GMTrace.o(748934922240L, 5580);
  }
  
  public static void bCC()
  {
    GMTrace.i(748666486784L, 5578);
    long l = System.currentTimeMillis();
    QbSdk.preInit(aa.getContext(), new QbSdk.a()
    {
      public final void al(boolean paramAnonymousBoolean)
      {
        GMTrace.i(760477646848L, 5666);
        GMTrace.o(760477646848L, 5666);
      }
      
      public final void ot()
      {
        GMTrace.i(760343429120L, 5665);
        v.i("MicroMsg.TBSHelper", "init TBS Core cost = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.gJU) });
        w.a.bCE();
        GMTrace.o(760343429120L, 5665);
      }
    });
    GMTrace.o(748666486784L, 5578);
  }
  
  public static String bCD()
  {
    GMTrace.i(748800704512L, 5579);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<TBSInfo>");
    ((StringBuilder)localObject).append("<TBSCoreVersion>");
    ((StringBuilder)localObject).append(WebView.getTbsCoreVersion(aa.getContext()));
    ((StringBuilder)localObject).append("</TBSCoreVersion>");
    ((StringBuilder)localObject).append("<TBSSDKVersion>");
    ((StringBuilder)localObject).append(WebView.getTbsSDKVersion(aa.getContext()));
    ((StringBuilder)localObject).append("</TBSSDKVersion>");
    ((StringBuilder)localObject).append("</TBSInfo>");
    ((StringBuilder)localObject).append("<IMEI>");
    ((StringBuilder)localObject).append(p.rA());
    ((StringBuilder)localObject).append("</IMEI>");
    localObject = ((StringBuilder)localObject).toString();
    GMTrace.o(748800704512L, 5579);
    return (String)localObject;
  }
  
  public static void ej(String paramString1, String paramString2)
  {
    GMTrace.i(16010966990848L, 119291);
    Intent localIntent = new Intent();
    localIntent.setAction("MINIQB_OPEN_RET");
    localIntent.putExtra("file_path", paramString1);
    localIntent.putExtra("file_ext", paramString2);
    v.i("MicroMsg.TBSHelper", "TBS MiniQB cannot open this file:%s", new Object[] { paramString1 });
    localIntent.putExtra("MINIQB_OPEN_RET_VAL", false);
    aa.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
    GMTrace.o(16010966990848L, 119291);
  }
  
  public static void ek(String paramString1, String paramString2)
  {
    GMTrace.i(16011101208576L, 119292);
    Intent localIntent = new Intent();
    localIntent.setClassName(aa.getContext(), "com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI");
    localIntent.putExtra("file_path", paramString1);
    localIntent.putExtra("file_ext", paramString2);
    localIntent.addFlags(268435456);
    aa.getContext().startActivity(localIntent);
    GMTrace.o(16011101208576L, 119292);
  }
  
  public static void o(String paramString, Object paramObject)
  {
    GMTrace.i(14281437347840L, 106405);
    sBo.put(paramString, paramObject);
    QbSdk.initTbsSettings(sBo);
    GMTrace.o(14281437347840L, 106405);
  }
  
  public static final class a
  {
    private static boolean sBr;
    
    static
    {
      GMTrace.i(762759348224L, 5683);
      TbsLog.setTbsLogClient(new t(aa.getContext())
      {
        public final void qM(String paramAnonymousString)
        {
          GMTrace.i(749740228608L, 5586);
          v.i("TBSDownloadChecker.TbsLogClient", "TbsLogClient: " + paramAnonymousString);
          GMTrace.o(749740228608L, 5586);
        }
      });
      sBr = false;
      GMTrace.o(762759348224L, 5683);
    }
    
    public static void bCE()
    {
      GMTrace.i(761954041856L, 5677);
      if (bf.bJU())
      {
        v.d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
        GMTrace.o(761954041856L, 5677);
        return;
      }
      if ((l.fN(aa.getContext())) && (WebView.getTbsCoreVersion(aa.getContext()) <= 0))
      {
        Intent localIntent = new Intent();
        localIntent.setClassName(aa.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
        localIntent.putExtra("intent_extra_download_type", 1);
        aa.getContext().startService(localIntent);
        v.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
      }
      GMTrace.o(761954041856L, 5677);
    }
    
    public static boolean bCF()
    {
      GMTrace.i(762088259584L, 5678);
      boolean bool1 = l.atd();
      boolean bool2 = QbSdk.getTBSInstalling();
      boolean bool3 = sBr;
      if ((bool1) || (bool2) || (bool3))
      {
        GMTrace.o(762088259584L, 5678);
        return true;
      }
      GMTrace.o(762088259584L, 5678);
      return false;
    }
    
    public static int bCG()
    {
      GMTrace.i(762356695040L, 5680);
      int i = QbSdk.getTbsVersion(aa.getContext());
      if (i < 36824)
      {
        if (bf.bJU())
        {
          if (d.ep(17))
          {
            v.i("MicroMsg.TBSDownloadChecker", "is GP version can not download");
            GMTrace.o(762356695040L, 5680);
            return 2;
          }
          v.i("MicroMsg.TBSDownloadChecker", "is GP version no need download");
          GMTrace.o(762356695040L, 5680);
          return 0;
        }
        v.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d should download", new Object[] { Integer.valueOf(i) });
        GMTrace.o(762356695040L, 5680);
        return 1;
      }
      if (QbSdk.canOpenWebPlus(aa.getContext()))
      {
        v.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d can load x5", new Object[] { Integer.valueOf(i) });
        GMTrace.o(762356695040L, 5680);
        return 0;
      }
      v.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d can not load x5", new Object[] { Integer.valueOf(i) });
      GMTrace.o(762356695040L, 5680);
      return 1;
    }
    
    public static int bCH()
    {
      GMTrace.i(762490912768L, 5681);
      if ((d.eo(19)) || (d.ep(16)))
      {
        GMTrace.o(762490912768L, 5681);
        return 1;
      }
      if (WebView.getTbsCoreVersion(aa.getContext()) > 0)
      {
        GMTrace.o(762490912768L, 5681);
        return 4;
      }
      if (l.atd())
      {
        GMTrace.o(762490912768L, 5681);
        return 2;
      }
      if (QbSdk.getTBSInstalling())
      {
        GMTrace.o(762490912768L, 5681);
        return 3;
      }
      boolean bool = aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false);
      v.i("MicroMsg.TBSDownloadChecker", "oversea = %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        GMTrace.o(762490912768L, 5681);
        return 2;
      }
      v.e("MicroMsg.TBSDownloadChecker", "WTF, how could it be?");
      GMTrace.o(762490912768L, 5681);
      return 0;
    }
    
    public static void dw(Context paramContext)
    {
      GMTrace.i(761819824128L, 5676);
      v.i("MicroMsg.TBSDownloadChecker", "webview start check tbs");
      Object localObject = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      int i = 1;
      boolean bool = ((SharedPreferences)localObject).getBoolean("tbs_download_oversea", false);
      v.i("MicroMsg.TBSDownloadChecker", "user hasDownloadOverSea = %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        i = 2;
      }
      String str;
      while (!bf.bJU())
      {
        str = ((SharedPreferences)localObject).getString("tbs_download", null);
        if ("1".equals(str)) {
          break;
        }
        v.i("MicroMsg.TBSDownloadChecker", "tbsDownload switch is off, value = %s", new Object[] { str });
        GMTrace.o(761819824128L, 5676);
        return;
      }
      v.i("MicroMsg.TBSDownloadChecker", "isGPVersion, ignore this request");
      GMTrace.o(761819824128L, 5676);
      return;
      bool = al.isWifi(paramContext);
      v.i("MicroMsg.TBSDownloadChecker", "check, tbsDownload = %s, isWifi = %b", new Object[] { str, Boolean.valueOf(bool) });
      if (!bool)
      {
        v.i("MicroMsg.TBSDownloadChecker", "check, net type is not wifi");
        GMTrace.o(761819824128L, 5676);
        return;
      }
      if (localObject == null) {
        v.e("MicroMsg.TBSDownloadChecker", "sp is null");
      }
      for (int j = 0;; j = 1)
      {
        if (j != 0) {
          break label299;
        }
        j = WebView.getTbsCoreVersion(paramContext);
        v.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", new Object[] { Integer.valueOf(j) });
        if (j <= 0) {
          break label299;
        }
        GMTrace.o(761819824128L, 5676);
        return;
        long l1 = ((SharedPreferences)localObject).getLong("last_check_ts", 0L);
        long l2 = System.currentTimeMillis();
        if (l2 - l1 <= 7200000L) {
          break;
        }
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putLong("last_check_ts", l2);
        ((SharedPreferences.Editor)localObject).apply();
      }
      label299:
      localObject = new Intent();
      ((Intent)localObject).setClassName(aa.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
      ((Intent)localObject).putExtra("intent_extra_download_type", i);
      paramContext.startService((Intent)localObject);
      v.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
      GMTrace.o(761819824128L, 5676);
    }
    
    public static void dx(Context paramContext)
    {
      GMTrace.i(762625130496L, 5682);
      Intent localIntent = new Intent();
      localIntent.setClassName(aa.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
      localIntent.putExtra("intent_extra_download_type", 2);
      localIntent.putExtra("intent_extra_download_ignore_network_type", true);
      paramContext.startService(localIntent);
      v.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
      paramContext = aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
      if (paramContext != null) {
        paramContext.edit().putBoolean("tbs_download_oversea", true).apply();
      }
      GMTrace.o(762625130496L, 5682);
    }
    
    public static void jg(boolean paramBoolean)
    {
      GMTrace.i(762222477312L, 5679);
      sBr = paramBoolean;
      GMTrace.o(762222477312L, 5679);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */