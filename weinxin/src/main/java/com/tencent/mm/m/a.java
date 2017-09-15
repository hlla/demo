package com.tencent.mm.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.StatFs;
import android.preference.PreferenceManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public final class a
{
  public static void b(Context paramContext, long paramLong)
  {
    GMTrace.i(1369691914240L, 10205);
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("db_check_tip_time", paramLong).commit();
    GMTrace.o(1369691914240L, 10205);
  }
  
  public static int tP()
  {
    GMTrace.i(1369557696512L, 10204);
    for (;;)
    {
      long l1;
      int i;
      long l3;
      try
      {
        localStatFs = new StatFs(h.getDataDirectory().getPath());
        l1 = localStatFs.getAvailableBlocks();
        i = localStatFs.getBlockSize();
        l3 = i * l1;
      }
      catch (Exception localException1)
      {
        StatFs localStatFs;
        l1 = 0L;
        v.e("MicroMsg.DbChecker", "get db spare space error");
        long l2 = 0L;
        l3 = l1;
        l1 = 0L;
        continue;
        if (l3 < 10485760L)
        {
          i = 1;
          continue;
        }
      }
      try
      {
        l1 = localStatFs.getBlockCount() * localStatFs.getBlockSize();
        l2 = localStatFs.getFreeBlocks();
        i = localStatFs.getBlockSize();
        l2 = i * l2;
        v.i("MicroMsg.DbChecker", "checkRomSparespace available:%d all:%d freeSize :%d", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2) });
        if ((l1 == 0L) || (l3 / l1 >= 0.10000000149011612D)) {
          break label192;
        }
        if (l3 >= 5242880L) {
          continue;
        }
        i = 2;
      }
      catch (Exception localException2)
      {
        l1 = l3;
        continue;
        i = 0;
      }
    }
    GMTrace.o(1369557696512L, 10204);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/m/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */