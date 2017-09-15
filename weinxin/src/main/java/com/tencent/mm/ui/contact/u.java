package com.tencent.mm.ui.contact;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class u
{
  public static void BI(int paramInt)
  {
    GMTrace.i(1821334568960L, 13570);
    v.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomClick %d %d", new Object[] { Integer.valueOf(13941), Integer.valueOf(paramInt) });
    g.oSF.i(13941, new Object[] { Integer.valueOf(paramInt) });
    GMTrace.o(1821334568960L, 13570);
  }
  
  public static final void h(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(1821200351232L, 13569);
    if (bf.mA(paramString))
    {
      GMTrace.o(1821200351232L, 13569);
      return;
    }
    paramString = String.format("%s,%d,%d,%d,%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(0) });
    v.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[] { paramString });
    g.oSF.A(13234, paramString);
    GMTrace.o(1821200351232L, 13569);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */