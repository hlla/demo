package com.tencent.mm.compatible.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;

public final class v
{
  private static v gRC;
  
  static
  {
    GMTrace.i(13807648768000L, 102875);
    gRC = null;
    GMTrace.o(13807648768000L, 102875);
  }
  
  public static int rR()
  {
    GMTrace.i(13807514550272L, 102874);
    NetworkInfo localNetworkInfo = ((ConnectivityManager)aa.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null)
    {
      GMTrace.o(13807514550272L, 102874);
      return 0;
    }
    int i = localNetworkInfo.getSubtype();
    if (localNetworkInfo.getType() == 1)
    {
      GMTrace.o(13807514550272L, 102874);
      return 1;
    }
    switch (i)
    {
    case 8: 
    case 9: 
    case 10: 
    case 16: 
    default: 
      GMTrace.o(13807514550272L, 102874);
      return 0;
    case 13: 
    case 14: 
    case 15: 
      GMTrace.o(13807514550272L, 102874);
      return 4;
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 12: 
    case 17: 
      GMTrace.o(13807514550272L, 102874);
      return 3;
    }
    GMTrace.o(13807514550272L, 102874);
    return 2;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/d/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */