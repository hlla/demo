package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class t
{
  private static final long[] ijE;
  
  static
  {
    GMTrace.i(457414017024L, 3408);
    ijE = new long[] { 0L, 259200000L, 604800000L };
    GMTrace.o(457414017024L, 3408);
  }
  
  public static String Nv()
  {
    GMTrace.i(456877146112L, 3404);
    String str = aa.getContext().getSharedPreferences("update_config_prefs", 4).getString("update_downloaded_pack_md5_key", null);
    GMTrace.o(456877146112L, 3404);
    return str;
  }
  
  public static int Nw()
  {
    GMTrace.i(457011363840L, 3405);
    int i = aa.getContext().getSharedPreferences("update_config_prefs", 4).getInt("update_downloaded_pack_update_type", 3);
    GMTrace.o(457011363840L, 3405);
    return i;
  }
  
  public static boolean Nx()
  {
    GMTrace.i(457145581568L, 3406);
    SharedPreferences localSharedPreferences = aa.getContext().getSharedPreferences("update_config_prefs", 4);
    long l1 = localSharedPreferences.getLong("update_downloaded_cancel_ts", 0L);
    int i = localSharedPreferences.getInt("update_downloaded_cancel_times", 0);
    v.i("MicroMsg.UpdateUtil", "checkIgnoreDownloadedPack last: %s times: %s", new Object[] { Long.valueOf(l1), Integer.valueOf(i) });
    if (i > ijE.length - 1)
    {
      GMTrace.o(457145581568L, 3406);
      return true;
    }
    long l2 = ijE[i];
    if (System.currentTimeMillis() - l1 > l2)
    {
      GMTrace.o(457145581568L, 3406);
      return false;
    }
    if (System.currentTimeMillis() - l1 < 0L)
    {
      v.e("MicroMsg.UpdateUtil", "user modify mobile time. we just remove the config.");
      aa.getContext().getSharedPreferences("update_config_prefs", 4).edit().clear().commit();
      v.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
      GMTrace.o(457145581568L, 3406);
      return true;
    }
    GMTrace.o(457145581568L, 3406);
    return true;
  }
  
  public static boolean Ny()
  {
    GMTrace.i(457279799296L, 3407);
    SharedPreferences localSharedPreferences = aa.getContext().getSharedPreferences("update_config_prefs", 4);
    long l = localSharedPreferences.getLong("update_downloading_in_silence", 0L);
    boolean bool = localSharedPreferences.getBoolean("update_download_start_one_immediate", false);
    v.i("MicroMsg.UpdateUtil", "hasUnfinishDownloadingInSilence unfinish %s", new Object[] { Long.valueOf(l) });
    if ((bool) || ((l != 0L) && (System.currentTimeMillis() - l > 3600000L)))
    {
      GMTrace.o(457279799296L, 3407);
      return true;
    }
    GMTrace.o(457279799296L, 3407);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/platformtools/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */