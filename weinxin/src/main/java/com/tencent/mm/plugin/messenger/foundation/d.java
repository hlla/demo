package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.ao.r;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bc;
import com.tencent.mm.y.e;
import com.tencent.mm.y.n;

public final class d
  implements c, com.tencent.mm.plugin.messenger.foundation.a.h
{
  ad nwQ;
  bc nwR;
  av nwS;
  af nwT;
  r nwU;
  az nwV;
  ai nwW;
  
  public d()
  {
    GMTrace.i(13232794238976L, 98592);
    GMTrace.o(13232794238976L, 98592);
  }
  
  public final void onAccountInitialized(e.f paramf)
  {
    GMTrace.i(13232928456704L, 98593);
    GMTrace.o(13232928456704L, 98593);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(13233062674432L, 98594);
    Object localObject;
    if (this.nwQ != null)
    {
      localObject = this.nwQ;
      ((ad)localObject).uHa.clear();
      ((ad)localObject).uHb.clear();
    }
    if (this.nwU != null)
    {
      localObject = this.nwU;
      com.tencent.mm.kernel.h.vJ();
      com.tencent.mm.kernel.h.vH().gXs.b(681, (e)localObject);
    }
    GMTrace.o(13233062674432L, 98594);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/messenger/foundation/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */