package com.tencent.mm.ah.a;

import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.a.c.a;
import com.tencent.mm.ah.a.c.h;
import com.tencent.mm.ah.a.c.l;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b
{
  public com.tencent.mm.ah.a.a.b hHO;
  h hHP;
  Executor hHQ;
  public final Map<Integer, String> hHR;
  public HashMap<Integer, com.tencent.mm.ah.a.f.b> hHS;
  
  public b(com.tencent.mm.ah.a.a.b paramb)
  {
    GMTrace.i(13733829017600L, 102325);
    this.hHR = Collections.synchronizedMap(new HashMap());
    this.hHS = new HashMap();
    this.hHO = paramb;
    this.hHP = paramb.hIo;
    this.hHQ = paramb.hIp;
    this.hHO.hIi.a(this.hHO.hIk);
    GMTrace.o(13733829017600L, 102325);
  }
  
  public final void a(c paramc)
  {
    GMTrace.i(13734097453056L, 102327);
    this.hHR.remove(Integer.valueOf(paramc.Hf()));
    v.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", new Object[] { Integer.valueOf(this.hHR.size()), Integer.valueOf(paramc.Hf()) });
    GMTrace.o(13734097453056L, 102327);
  }
  
  public final Bitmap jI(String paramString)
  {
    GMTrace.i(13733963235328L, 102326);
    if (this.hHO != null)
    {
      paramString = this.hHO.hIh.gS(paramString);
      GMTrace.o(13733963235328L, 102326);
      return paramString;
    }
    GMTrace.o(13733963235328L, 102326);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */