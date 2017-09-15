package com.tencent.mm.ah.a.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.a.c.f;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class d
  implements f
{
  public d()
  {
    GMTrace.i(13721615204352L, 102234);
    GMTrace.o(13721615204352L, 102234);
  }
  
  public final String jK(String paramString)
  {
    GMTrace.i(13721749422080L, 102235);
    String str = null;
    if (!bf.mA(paramString))
    {
      str = g.n(paramString.getBytes());
      v.d("MicroMsg.imageloader.DefaultImageFileNameCreater", "[cpan] create image file name :%s", new Object[] { str });
    }
    GMTrace.o(13721749422080L, 102235);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/a/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */