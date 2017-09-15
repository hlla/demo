package com.tencent.mm.compatible.util;

import com.tencent.gmtrace.GMTrace;
import java.security.PrivilegedAction;

public final class i
  implements PrivilegedAction
{
  private String gSG;
  private String gSH;
  
  public i(String paramString)
  {
    GMTrace.i(13779865698304L, 102668);
    this.gSG = paramString;
    GMTrace.o(13779865698304L, 102668);
  }
  
  public final Object run()
  {
    GMTrace.i(13779999916032L, 102669);
    String str = System.getProperty(this.gSG);
    if (str == null)
    {
      str = this.gSH;
      GMTrace.o(13779999916032L, 102669);
      return str;
    }
    GMTrace.o(13779999916032L, 102669);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/util/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */