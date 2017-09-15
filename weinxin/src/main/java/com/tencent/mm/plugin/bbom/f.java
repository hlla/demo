package com.tencent.mm.plugin.bbom;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.c.aln;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ba;

public final class f
  implements k
{
  private String jOg;
  
  public f(String paramString)
  {
    GMTrace.i(8026085916672L, 59799);
    this.jOg = null;
    this.jOg = paramString;
    GMTrace.o(8026085916672L, 59799);
  }
  
  public final void a(aln paramaln, au paramau)
  {
    GMTrace.i(8026220134400L, 59800);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append("<strangerantispamticket ticket=\"" + this.jOg + "\"></strangerantispamticket>");
    localStringBuilder.append(bf.mz(ba.zy()));
    if ((bf.mA(paramaln.tdC)) || (!paramaln.tdC.startsWith("<msgsource>"))) {}
    for (paramau = "<msgsource></msgsource>";; paramau = paramaln.tdC)
    {
      paramaln.tdC = paramau;
      paramaln.tdC = paramaln.tdC.replace("<msgsource>", localStringBuilder.toString());
      GMTrace.o(8026220134400L, 59800);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/bbom/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */