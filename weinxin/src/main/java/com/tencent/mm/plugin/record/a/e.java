package com.tencent.mm.plugin.record.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.jz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.v;

public final class e
  implements i.a
{
  public e()
  {
    GMTrace.i(7504515825664L, 55913);
    GMTrace.o(7504515825664L, 55913);
  }
  
  public final void a(int paramInt, g paramg)
  {
    GMTrace.i(7504650043392L, 55914);
    if (paramg == null)
    {
      GMTrace.o(7504650043392L, 55914);
      return;
    }
    v.d("MircoMsg.RecordInfoStorageProxy", "notify CdnChanged dataId: %s, status: %d", new Object[] { paramg.field_dataId, Integer.valueOf(paramg.field_status) });
    jz localjz = new jz();
    localjz.fQe.field_dataId = paramg.field_dataId;
    localjz.fQe.field_status = paramg.field_status;
    localjz.fQe.field_offset = paramg.field_offset;
    localjz.fQe.field_totalLen = paramg.field_totalLen;
    localjz.fQe.field_localId = paramg.field_localId;
    localjz.fQe.field_path = paramg.field_path;
    a.uql.m(localjz);
    GMTrace.o(7504650043392L, 55914);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/record/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */