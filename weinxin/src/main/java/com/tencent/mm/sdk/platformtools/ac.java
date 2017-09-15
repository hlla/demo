package com.tencent.mm.sdk.platformtools;

import com.tencent.gmtrace.GMTrace;
import java.util.HashSet;
import java.util.Set;

public final class ac
{
  private static Set<String> urp;
  
  static
  {
    GMTrace.i(13904553967616L, 103597);
    urp = new HashSet();
    GMTrace.o(13904553967616L, 103597);
  }
  
  public static boolean Ps(String paramString)
  {
    GMTrace.i(13904151314432L, 103594);
    if (Pu(paramString))
    {
      v.d("MicroMsg.MMEntryLock", "locked-" + paramString);
      GMTrace.o(13904151314432L, 103594);
      return false;
    }
    v.d("MicroMsg.MMEntryLock", "lock-" + paramString);
    boolean bool = urp.add(paramString);
    GMTrace.o(13904151314432L, 103594);
    return bool;
  }
  
  public static void Pt(String paramString)
  {
    GMTrace.i(13904285532160L, 103595);
    urp.remove(paramString);
    v.d("MicroMsg.MMEntryLock", "unlock-" + paramString);
    GMTrace.o(13904285532160L, 103595);
  }
  
  public static boolean Pu(String paramString)
  {
    GMTrace.i(13904419749888L, 103596);
    boolean bool = urp.contains(paramString);
    GMTrace.o(13904419749888L, 103596);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */