package com.tencent.mm.aw.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class b
  implements e
{
  public b()
  {
    GMTrace.i(4400193994752L, 32784);
    GMTrace.o(4400193994752L, 32784);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(4400328212480L, 32785);
    h.vd().b(228, this);
    if ((paramk instanceof a)) {
      v.i("MicroMsg.NewVoiceInputReportManager", "onSceneEnd errType = %s, errCode = %s, errMsg = %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    GMTrace.o(4400328212480L, 32785);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/aw/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */