package com.tencent.mm.network;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.a.b;
import com.tencent.mm.sdk.platformtools.al;

public final class aa
{
  public b ifi;
  public boolean ifj;
  
  public aa()
  {
    GMTrace.i(13676920700928L, 101901);
    this.ifi = null;
    this.ifj = false;
    GMTrace.o(13676920700928L, 101901);
  }
  
  public static boolean bn(Context paramContext)
  {
    GMTrace.i(13677054918656L, 101902);
    if ((paramContext != null) && (al.isWifi(paramContext)))
    {
      GMTrace.o(13677054918656L, 101902);
      return true;
    }
    GMTrace.o(13677054918656L, 101902);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/network/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */