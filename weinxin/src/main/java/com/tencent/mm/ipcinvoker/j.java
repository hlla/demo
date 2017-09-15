package com.tencent.mm.ipcinvoker;

import com.tencent.gmtrace.GMTrace;
import java.util.HashMap;
import java.util.Map;

public class j
{
  private static j gVN;
  Map<String, BaseIPCService> gVO;
  
  private j()
  {
    GMTrace.i(18688744882176L, 139242);
    this.gVO = new HashMap();
    GMTrace.o(18688744882176L, 139242);
  }
  
  public static j uq()
  {
    GMTrace.i(18688879099904L, 139243);
    if (gVN == null) {}
    try
    {
      if (gVN == null) {
        gVN = new j();
      }
      j localj = gVN;
      GMTrace.o(18688879099904L, 139243);
      return localj;
    }
    finally {}
  }
  
  public final BaseIPCService dW(String paramString)
  {
    GMTrace.i(18689013317632L, 139244);
    paramString = (BaseIPCService)this.gVO.get(paramString);
    GMTrace.o(18689013317632L, 139244);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ipcinvoker/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */