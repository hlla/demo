package com.tencent.mm.az;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.av.i;
import com.tencent.mm.av.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.bf;

public final class a
{
  public static boolean bCb()
  {
    GMTrace.i(299708186624L, 2233);
    String str2 = g.sV().getValue("EnableStrangerChat");
    String str1 = str2;
    if (bf.mA(str2)) {
      str1 = "0";
    }
    boolean bool = "1".equals(str1);
    GMTrace.o(299708186624L, 2233);
    return bool;
  }
  
  public static void dl(Context paramContext)
  {
    GMTrace.i(299842404352L, 2234);
    if ((!bCb()) && (l.KA().Ks() > 0))
    {
      d.w(paramContext, "nearby", ".ui.NearbyFriendShowSayHiUI");
      GMTrace.o(299842404352L, 2234);
      return;
    }
    d.w(paramContext, "nearby", ".ui.NearbyFriendsUI");
    GMTrace.o(299842404352L, 2234);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/az/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */