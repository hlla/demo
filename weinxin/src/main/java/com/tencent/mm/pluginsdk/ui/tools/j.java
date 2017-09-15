package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.WebView;

public final class j
{
  private static String sUW;
  private static final String[] sUX;
  
  static
  {
    GMTrace.i(1106088296448L, 8241);
    sUW = null;
    sUX = new String[] { "", "dynamic_config_recv", "trigger_download", "start_download", "stop_download", "download_finish", "install_finish", "use" };
    GMTrace.o(1106088296448L, 8241);
  }
  
  private static String dF(Context paramContext)
  {
    GMTrace.i(1105954078720L, 8240);
    if (sUW != null)
    {
      paramContext = sUW;
      GMTrace.o(1105954078720L, 8240);
      return paramContext;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(aa.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.getString("com.tencent.mtt.TBS_CODE");
        if (!bf.mA(paramContext))
        {
          sUW = paramContext;
          GMTrace.o(1105954078720L, 8240);
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      v.e("MicroMsg.TBSReporter", "getMetaTbsCode, ex = %s", new Object[] { paramContext.getMessage() });
      GMTrace.o(1105954078720L, 8240);
    }
    return null;
  }
  
  public static void dJ(int paramInt1, int paramInt2)
  {
    GMTrace.i(1105819860992L, 8239);
    if ((paramInt1 <= 0) || (paramInt1 > 7))
    {
      v.e("MicroMsg.TBSReporter", "report invalid scene = %d", new Object[] { Integer.valueOf(paramInt1) });
      GMTrace.o(1105819860992L, 8239);
      return;
    }
    v.i("MicroMsg.TBSReporter", "logSceneDetail, scene = %d_%s, errcode = %d", new Object[] { Integer.valueOf(paramInt1), sUX[paramInt1], Integer.valueOf(paramInt2) });
    Object localObject = aa.getContext();
    int i = WebView.getTbsCoreVersion((Context)localObject);
    int j = WebView.getTbsSDKVersion((Context)localObject);
    localObject = dF((Context)localObject);
    g.oSF.a(11633, false, true, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(paramInt2) });
    GMTrace.o(1105819860992L, 8239);
  }
  
  public static void mJ(int paramInt)
  {
    GMTrace.i(1105685643264L, 8238);
    dJ(paramInt, 0);
    GMTrace.o(1105685643264L, 8238);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */