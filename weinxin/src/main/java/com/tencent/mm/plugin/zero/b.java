package com.tencent.mm.plugin.zero;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.bo;
import com.tencent.mm.u.bo.a;
import java.util.Queue;

public final class b
  implements c, com.tencent.mm.plugin.zero.b.b
{
  private bo szg;
  private r szh;
  
  public b()
  {
    GMTrace.i(13621220343808L, 101486);
    GMTrace.o(13621220343808L, 101486);
  }
  
  public final r Hz()
  {
    GMTrace.i(13621354561536L, 101487);
    h.vJ();
    h.vG().uQ();
    if (this.szh == null) {
      this.szh = new r();
    }
    r localr = this.szh;
    GMTrace.o(13621354561536L, 101487);
    return localr;
  }
  
  public final bo bCa()
  {
    GMTrace.i(13621488779264L, 101488);
    h.vJ();
    h.vG().uQ();
    if (this.szg == null) {
      this.szg = new bo(new bo.a()
      {
        public final boolean zZ()
        {
          GMTrace.i(13625783746560L, 101520);
          if (b.this.Hz().hLZ == null)
          {
            GMTrace.o(13625783746560L, 101520);
            return true;
          }
          GMTrace.o(13625783746560L, 101520);
          return false;
        }
      });
    }
    bo localbo = this.szg;
    GMTrace.o(13621488779264L, 101488);
    return localbo;
  }
  
  public final void onAccountInitialized(e.f paramf)
  {
    GMTrace.i(13621622996992L, 101489);
    GMTrace.o(13621622996992L, 101489);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(13621757214720L, 101490);
    if (this.szh != null)
    {
      r localr = this.szh;
      v.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", new Object[] { Integer.valueOf(localr.hLW.size()), Integer.valueOf(localr.hLX.size()), localr.hLZ });
      localr.hLW.clear();
      localr.hLX.clear();
    }
    if (this.szg != null) {
      this.szg.zU();
    }
    GMTrace.o(13621757214720L, 101490);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/zero/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */