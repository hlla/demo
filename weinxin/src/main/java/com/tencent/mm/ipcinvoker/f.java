package com.tencent.mm.ipcinvoker;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ipcinvoker.extension.a;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class f
{
  public static void dT(String paramString)
  {
    GMTrace.i(18691563454464L, 139263);
    if (dV(paramString))
    {
      GMTrace.o(18691563454464L, 139263);
      return;
    }
    m.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18683107737600L, 139200);
        b localb = b.un();
        String str = this.gVx;
        if (d.dS(str))
        {
          v.i("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", new Object[] { str });
          GMTrace.o(18683107737600L, 139200);
          return;
        }
        localb.dQ(str);
        GMTrace.o(18683107737600L, 139200);
      }
    });
    GMTrace.o(18691563454464L, 139263);
  }
  
  public static void dU(String paramString)
  {
    GMTrace.i(18691697672192L, 139264);
    if (dV(paramString))
    {
      GMTrace.o(18691697672192L, 139264);
      return;
    }
    m.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18689415970816L, 139247);
        b.un().dR(this.gVx);
        GMTrace.o(18689415970816L, 139247);
      }
    });
    GMTrace.o(18691697672192L, 139264);
  }
  
  public static boolean dV(String paramString)
  {
    GMTrace.i(18691831889920L, 139265);
    b localb = b.un();
    if (d.dS(paramString)) {
      v.i("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", new Object[] { paramString });
    }
    while (localb.gVu.get(paramString) == null)
    {
      GMTrace.o(18691831889920L, 139265);
      return false;
    }
    GMTrace.o(18691831889920L, 139265);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ipcinvoker/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */