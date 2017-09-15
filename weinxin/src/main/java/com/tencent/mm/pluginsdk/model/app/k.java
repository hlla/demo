package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.t.f;

public final class k
  extends i<f>
{
  public static final String[] gUn;
  
  static
  {
    GMTrace.i(790810853376L, 5892);
    gUn = new String[] { i.a(f.gTF, "AppMessage") };
    GMTrace.o(790810853376L, 5892);
  }
  
  public k(e parame)
  {
    super(parame, f.gTF, "AppMessage", null);
    GMTrace.i(790542417920L, 5890);
    GMTrace.o(790542417920L, 5890);
  }
  
  public final f ec(long paramLong)
  {
    GMTrace.i(790676635648L, 5891);
    f localf = new f();
    localf.field_msgId = paramLong;
    if (super.b(localf, new String[0]))
    {
      GMTrace.o(790676635648L, 5891);
      return localf;
    }
    GMTrace.o(790676635648L, 5891);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */