package com.tencent.mm.platformtools;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;

public final class k
  implements Runnable
{
  String fTc;
  String hkD;
  String ihE;
  
  public k(String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(14608794386432L, 108844);
    this.fTc = paramString1;
    this.hkD = paramString2;
    this.ihE = paramString3;
    GMTrace.o(14608794386432L, 108844);
  }
  
  public final void run()
  {
    GMTrace.i(14608928604160L, 108845);
    if ((bf.mA(this.fTc)) || (bf.mA(this.hkD)))
    {
      GMTrace.o(14608928604160L, 108845);
      return;
    }
    v.d("MicroMsg.MoveDataFiles", "MoveDataFiles %s :" + this.fTc + " to :" + this.hkD, new Object[] { this.ihE });
    if (!f.rZ())
    {
      GMTrace.o(14608928604160L, 108845);
      return;
    }
    if (!this.hkD.substring(0, e.hgk.length()).equals(e.hgk))
    {
      GMTrace.o(14608928604160L, 108845);
      return;
    }
    j.p(this.fTc + "/" + this.ihE, this.hkD + "/" + this.ihE, true);
    GMTrace.o(14608928604160L, 108845);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/platformtools/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */