package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.b.a;
import com.tencent.mm.b.b;
import com.tencent.mm.b.h;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public final class i
{
  private static final long[] ijE;
  
  static
  {
    GMTrace.i(3568580952064L, 26588);
    ijE = new long[] { 0L, 259200000L, 604800000L };
    GMTrace.o(3568580952064L, 26588);
  }
  
  public static String Nv()
  {
    GMTrace.i(3566567686144L, 26573);
    String str = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_md5_key", null);
    GMTrace.o(3566567686144L, 26573);
    return str;
  }
  
  public static boolean OX(String paramString)
  {
    GMTrace.i(3567507210240L, 26580);
    String[] arrayOfString = bHT();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equals(paramString))
        {
          GMTrace.o(3567507210240L, 26580);
          return true;
        }
        i += 1;
      }
    }
    GMTrace.o(3567507210240L, 26580);
    return false;
  }
  
  public static long OY(String paramString)
  {
    GMTrace.i(3568446734336L, 26587);
    long l = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_flowstat_prefs", 4).getLong(paramString, 0L);
    v.i("MicroMsg.UpdateUtil", "getPackFlowStat pack %s, flow %s", new Object[] { paramString, Long.valueOf(l) });
    GMTrace.o(3568446734336L, 26587);
    return l;
  }
  
  public static void X(Context paramContext, int paramInt)
  {
    GMTrace.i(3566165032960L, 26570);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
    localIntent.putExtra("intent_extra_is_silence_stat", false);
    localIntent.putExtra("intent_extra_opcode", paramInt);
    paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
    GMTrace.o(3566165032960L, 26570);
  }
  
  public static void Y(Context paramContext, int paramInt)
  {
    GMTrace.i(3566299250688L, 26571);
    f(paramContext, paramInt, 0);
    GMTrace.o(3566299250688L, 26571);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    GMTrace.i(3567104557056L, 26577);
    MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).edit().putString("update_downloaded_pack_md5_key", paramString1).putString("update_downloaded_pack_sig_key", paramString2).putString("update_downloaded_pack_desc_key", paramString3).putInt("update_downloaded_pack_size_key", paramInt1).putInt("update_downloaded_pack_download_mode", paramInt2).putInt("update_downloaded_pack_update_type", paramInt3).putString("update_download_not_auto_download_range", paramString4).commit();
    v.i("MicroMsg.UpdateUtil", "summerupdate putDownloadedPackInfo md5: %s size: %s range: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString4 });
    GMTrace.o(3567104557056L, 26577);
  }
  
  public static String bHO()
  {
    GMTrace.i(3566701903872L, 26574);
    String str = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_sig_key", null);
    GMTrace.o(3566701903872L, 26574);
    return str;
  }
  
  public static String bHP()
  {
    GMTrace.i(3566836121600L, 26575);
    String str = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_desc_key", null);
    GMTrace.o(3566836121600L, 26575);
    return str;
  }
  
  public static int bHQ()
  {
    GMTrace.i(3566970339328L, 26576);
    int i = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).getInt("update_downloaded_pack_download_mode", 0);
    GMTrace.o(3566970339328L, 26576);
    return i;
  }
  
  public static int bHR()
  {
    GMTrace.i(3567238774784L, 26578);
    int i = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).getInt("update_downloaded_cancel_times", 0);
    v.i("MicroMsg.UpdateUtil", "getIgnoreDownloadedPackTimes times %s", new Object[] { Integer.valueOf(i) });
    GMTrace.o(3567238774784L, 26578);
    return i;
  }
  
  public static void bHS()
  {
    int i = 0;
    GMTrace.i(3567372992512L, 26579);
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4);
    int j = localSharedPreferences.getInt("update_downloaded_cancel_times", 0);
    v.i("MicroMsg.UpdateUtil", "putIgnoreDownloadedPack times %s", new Object[] { Integer.valueOf(j) });
    if (j >= ijE.length - 1)
    {
      String str = Nv();
      Object localObject = null;
      if (!bf.mA(str))
      {
        String[] arrayOfString = bHT();
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        localObject = localStringBuffer;
        if (arrayOfString != null)
        {
          j = arrayOfString.length;
          for (;;)
          {
            localObject = localStringBuffer;
            if (i >= j) {
              break;
            }
            localObject = arrayOfString[i];
            if (!bf.mA((String)localObject))
            {
              localStringBuffer.append(":");
              localStringBuffer.append((String)localObject);
            }
            i += 1;
          }
        }
      }
      localSharedPreferences.edit().clear().commit();
      if (localObject != null) {
        localSharedPreferences.edit().putString("update_downloaded_ignored_pack", ((StringBuffer)localObject).toString()).commit();
      }
      GMTrace.o(3567372992512L, 26579);
      return;
    }
    localSharedPreferences.edit().putLong("update_downloaded_cancel_ts", System.currentTimeMillis()).putInt("update_downloaded_cancel_times", j + 1).commit();
    GMTrace.o(3567372992512L, 26579);
  }
  
  private static String[] bHT()
  {
    GMTrace.i(3567641427968L, 26581);
    Object localObject = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).getString("update_downloaded_ignored_pack", null);
    if (bf.mA((String)localObject))
    {
      GMTrace.o(3567641427968L, 26581);
      return null;
    }
    localObject = ((String)localObject).split(":");
    GMTrace.o(3567641427968L, 26581);
    return (String[])localObject;
  }
  
  public static void bHU()
  {
    GMTrace.i(3567775645696L, 26582);
    MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).edit().putLong("update_downloading_in_silence", System.currentTimeMillis()).putBoolean("update_download_start_one_immediate", false).commit();
    v.i("MicroMsg.UpdateUtil", "putDowningInSilence");
    GMTrace.o(3567775645696L, 26582);
  }
  
  public static void bHV()
  {
    GMTrace.i(3567909863424L, 26583);
    MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).edit().putBoolean("update_download_start_one_immediate", true).commit();
    v.i("MicroMsg.UpdateUtil", "putOneDownloadTask");
    GMTrace.o(3567909863424L, 26583);
  }
  
  public static void bHW()
  {
    GMTrace.i(3568044081152L, 26584);
    MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).edit().remove("update_downloading_in_silence").commit();
    v.i("MicroMsg.UpdateUtil", "removeUnfinishDownloadingInSilence");
    GMTrace.o(3568044081152L, 26584);
  }
  
  public static void bHX()
  {
    GMTrace.i(3568178298880L, 26585);
    MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_config_prefs", 4).edit().clear().commit();
    v.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
    GMTrace.o(3568178298880L, 26585);
  }
  
  private static String cq(Context paramContext)
  {
    GMTrace.i(3565762379776L, 26567);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.sourceDir;
      GMTrace.o(3565762379776L, 26567);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      v.printErrStackTrace("MicroMsg.UpdateUtil", paramContext, "", new Object[0]);
      GMTrace.o(3565762379776L, 26567);
    }
    return null;
  }
  
  public static String dS(Context paramContext)
  {
    GMTrace.i(3565896597504L, 26568);
    paramContext = cq(paramContext);
    if ((paramContext == null) || (!new File(paramContext).exists()))
    {
      GMTrace.o(3565896597504L, 26568);
      return null;
    }
    a locala = a.aZ(paramContext);
    if ((locala != null) && (locala.fuK != null))
    {
      paramContext = locala.fuK.apkMd5;
      GMTrace.o(3565896597504L, 26568);
      return paramContext;
    }
    paramContext = g.aV(paramContext);
    GMTrace.o(3565896597504L, 26568);
    return paramContext;
  }
  
  public static int e(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(3566030815232L, 26569);
    int i = h.b(cq(paramContext), paramString1, paramString2, paramString3);
    GMTrace.o(3566030815232L, 26569);
    return i;
  }
  
  public static void f(Context paramContext, int paramInt1, int paramInt2)
  {
    GMTrace.i(3566433468416L, 26572);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
    localIntent.putExtra("intent_extra_is_silence_stat", true);
    localIntent.putExtra("intent_extra_opcode", paramInt1);
    if (paramInt1 == 2) {
      localIntent.putExtra("intent_extra_install_dialog_times", paramInt2);
    }
    paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
    GMTrace.o(3566433468416L, 26572);
  }
  
  public static long l(String paramString, long paramLong1, long paramLong2)
  {
    GMTrace.i(3568312516608L, 26586);
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "update_flowstat_prefs", 4);
    long l = localSharedPreferences.getLong(paramString, 0L);
    v.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flowUp %s, flowDown %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    v.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flow %s", new Object[] { paramString, Long.valueOf(l) });
    paramLong1 = l + (paramLong1 + paramLong2);
    localSharedPreferences.edit().putLong(paramString, paramLong1).commit();
    GMTrace.o(3568312516608L, 26586);
    return paramLong1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/updater/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */