package com.tencent.mm.compatible.util;

import android.os.Build.VERSION;
import com.tencent.gmtrace.GMTrace;

public final class d
{
  public static boolean eo(int paramInt)
  {
    GMTrace.i(13789797810176L, 102742);
    if (Build.VERSION.SDK_INT >= paramInt)
    {
      GMTrace.o(13789797810176L, 102742);
      return true;
    }
    GMTrace.o(13789797810176L, 102742);
    return false;
  }
  
  public static boolean ep(int paramInt)
  {
    GMTrace.i(13789932027904L, 102743);
    if (Build.VERSION.SDK_INT < paramInt)
    {
      GMTrace.o(13789932027904L, 102743);
      return true;
    }
    GMTrace.o(13789932027904L, 102743);
    return false;
  }
  
  public static boolean eq(int paramInt)
  {
    GMTrace.i(13790066245632L, 102744);
    if (Build.VERSION.SDK_INT > paramInt)
    {
      GMTrace.o(13790066245632L, 102744);
      return true;
    }
    GMTrace.o(13790066245632L, 102744);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */