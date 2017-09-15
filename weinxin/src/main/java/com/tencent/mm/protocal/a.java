package com.tencent.mm.protocal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public class a
{
  public static int bGQ()
  {
    GMTrace.i(13593168838656L, 101277);
    if (b.foreground) {}
    for (int i = 1;; i = 2)
    {
      GMTrace.o(13593168838656L, 101277);
      return i;
    }
  }
  
  public static int getNetType(Context paramContext)
  {
    GMTrace.i(13593303056384L, 101278);
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext == null)
        {
          GMTrace.o(13593303056384L, 101278);
          return 0;
        }
        i = paramContext.getSubtype();
        int j = paramContext.getType();
        if (j != 1) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramContext)
      {
        v.e("MicroMsg.BgFgBase", "getNetType: %s", new Object[] { bf.g(paramContext) });
        int i = 1;
        continue;
      }
      GMTrace.o(13593303056384L, 101278);
      return i;
      if ((i == 13) || (i == 15) || (i == 14)) {
        i = 4;
      } else if ((i == 3) || (i == 4) || (i == 5) || (i == 6) || (i == 12)) {
        i = 3;
      } else if ((i == 1) || (i == 2)) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */