package com.tencent.mm.plugin.record.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.v;

public final class l
  extends i<k>
{
  public static final String[] gUn;
  e gUp;
  
  static
  {
    GMTrace.i(7516998074368L, 56006);
    gUn = new String[] { i.a(k.gTF, "RecordMessageInfo") };
    GMTrace.o(7516998074368L, 56006);
  }
  
  public l(e parame)
  {
    super(parame, k.gTF, "RecordMessageInfo", null);
    GMTrace.i(7516729638912L, 56004);
    this.gUp = parame;
    GMTrace.o(7516729638912L, 56004);
  }
  
  public final void rN(int paramInt)
  {
    GMTrace.i(7516863856640L, 56005);
    v.d("MicroMsg.RecordMsgStorage", "delete record msg item, local id %d, result %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.gUp.delete("RecordMessageInfo", "localId=?", new String[] { String.valueOf(paramInt) })) });
    GMTrace.o(7516863856640L, 56005);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/record/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */