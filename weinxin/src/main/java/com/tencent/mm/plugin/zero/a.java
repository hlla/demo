package com.tencent.mm.plugin.zero;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public final class a
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.zero.b.a
{
  private com.tencent.mm.i.e sze;
  private com.tencent.mm.i.c szf;
  
  public a()
  {
    GMTrace.i(13631152455680L, 101560);
    this.sze = new com.tencent.mm.i.e();
    this.szf = new com.tencent.mm.i.c();
    GMTrace.o(13631152455680L, 101560);
  }
  
  public final void onAccountInitialized(e.f paramf)
  {
    GMTrace.i(13631555108864L, 101563);
    if (paramf.gYp)
    {
      paramf = this.szf;
      File localFile1 = new File(com.tencent.mm.compatible.util.e.hgk + "configlist/");
      if (localFile1.exists())
      {
        File localFile2 = new File(com.tencent.mm.i.c.gSY);
        if (!localFile2.exists())
        {
          v.d("MicroMsg.ConfigListDecoder", "bugfix");
          paramf.a(localFile1, localFile2);
        }
      }
    }
    this.sze.sL();
    this.szf.init();
    GMTrace.o(13631555108864L, 101563);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(13631689326592L, 101564);
    GMTrace.o(13631689326592L, 101564);
  }
  
  public final com.tencent.mm.i.e sV()
  {
    GMTrace.i(13631286673408L, 101561);
    h.vJ();
    h.vG().uQ();
    com.tencent.mm.i.e locale = this.sze;
    GMTrace.o(13631286673408L, 101561);
    return locale;
  }
  
  public final com.tencent.mm.i.c sW()
  {
    GMTrace.i(13631420891136L, 101562);
    h.vJ();
    h.vG().uQ();
    com.tencent.mm.i.c localc = this.szf;
    GMTrace.o(13631420891136L, 101562);
    return localc;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/zero/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */