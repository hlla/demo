package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.ay.a;

public final class t
{
  public static aq I(String paramString1, String paramString2)
  {
    GMTrace.i(616193589248L, 4591);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      GMTrace.o(616193589248L, 4591);
      return null;
    }
    ap.yY();
    ay localay = c.wZ().AF(paramString1);
    if (localay != null) {
      if (localay.uIV != 1) {
        break label77;
      }
    }
    label77:
    for (int i = 1; i == 0; i = 0)
    {
      GMTrace.o(616193589248L, 4591);
      return null;
    }
    String str2 = localay.name;
    String str1 = localay.uIU.RT("");
    paramString1 = "";
    if (str1 != null) {
      paramString1 = "" + str1.replace("@", "");
    }
    str1 = paramString1;
    if (paramString2 != null) {
      str1 = paramString1 + paramString2;
    }
    paramString1 = new aq("@domain.android", str2, str1, localay.uIU.RT(""), localay.isEnable(), true);
    GMTrace.o(616193589248L, 4591);
    return paramString1;
  }
  
  public static aq fT(String paramString)
  {
    GMTrace.i(615925153792L, 4589);
    paramString = new aq("@black.android", null, paramString, null, true, true);
    GMTrace.o(615925153792L, 4589);
    return paramString;
  }
  
  public static aq fU(String paramString)
  {
    GMTrace.i(616059371520L, 4590);
    ap.yY();
    ay localay = c.wZ().AF("@t.qq.com");
    if (localay == null)
    {
      GMTrace.o(616059371520L, 4590);
      return null;
    }
    paramString = new aq("@t.qq.com", null, paramString, null, localay.isEnable(), localay.bMI());
    GMTrace.o(616059371520L, 4590);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */