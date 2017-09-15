package com.tencent.mm.t;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.Map;

public final class j
{
  public int hke;
  public int hkf;
  
  public j()
  {
    GMTrace.i(17446694027264L, 129988);
    GMTrace.o(17446694027264L, 129988);
  }
  
  public static final j eo(String paramString)
  {
    GMTrace.i(17446828244992L, 129989);
    j localj = new j();
    paramString = f.a.B(paramString, null);
    if (paramString != null)
    {
      paramString = paramString.hjP;
      if (paramString != null)
      {
        localj.hke = bf.getInt((String)paramString.get(".msg.appmsg.xmlfulllen"), 0);
        localj.hkf = bf.getInt((String)paramString.get(".msg.appmsg.realinnertype"), 0);
      }
    }
    GMTrace.o(17446828244992L, 129989);
    return localj;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/t/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */