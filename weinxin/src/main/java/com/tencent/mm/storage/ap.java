package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class ap
  extends i<ao>
{
  public static final String[] gUn;
  private e gUp;
  
  static
  {
    GMTrace.i(1565784014848L, 11666);
    gUn = new String[] { i.a(ao.gTF, "GetSysCmdMsgInfo") };
    GMTrace.o(1565784014848L, 11666);
  }
  
  public ap(g paramg)
  {
    super(paramg, ao.gTF, "GetSysCmdMsgInfo", null);
    GMTrace.i(1565649797120L, 11665);
    this.gUp = paramg;
    GMTrace.o(1565649797120L, 11665);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */