package com.tencent.mm.plugin.bbom;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.c.aln;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.au;

public final class i
  implements f, k
{
  public i()
  {
    GMTrace.i(8024609521664L, 59788);
    GMTrace.o(8024609521664L, 59788);
  }
  
  public final void a(aln paramaln, au paramau)
  {
    GMTrace.i(8024743739392L, 59789);
    if (com.tencent.mm.modelbiz.e.dr(paramau.field_talker))
    {
      paramaln.tdC = paramau.gxv;
      if (bf.mA(paramaln.tdC))
      {
        paramaln.tdC = com.tencent.mm.modelbiz.a.e.ix(paramau.gxv);
        GMTrace.o(8024743739392L, 59789);
      }
    }
    else
    {
      paramaln.tdC = paramau.gxv;
    }
    GMTrace.o(8024743739392L, 59789);
  }
  
  public final String s(au paramau)
  {
    GMTrace.i(8025012174848L, 59791);
    if (com.tencent.mm.modelbiz.e.dr(paramau.field_talker))
    {
      paramau = com.tencent.mm.modelbiz.a.e.zz();
      GMTrace.o(8025012174848L, 59791);
      return paramau;
    }
    GMTrace.o(8025012174848L, 59791);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/bbom/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */