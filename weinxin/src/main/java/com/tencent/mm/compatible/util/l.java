package com.tencent.mm.compatible.util;

import android.os.Build;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;

public final class l
{
  public static boolean qq()
  {
    GMTrace.i(13789663592448L, 102741);
    if (bf.ap(Build.MANUFACTURER, "").toLowerCase().indexOf("samsung".toLowerCase()) >= 0)
    {
      GMTrace.o(13789663592448L, 102741);
      return true;
    }
    GMTrace.o(13789663592448L, 102741);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/util/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */