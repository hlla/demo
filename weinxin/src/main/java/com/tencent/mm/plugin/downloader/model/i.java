package com.tencent.mm.plugin.downloader.model;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public abstract class i
  implements n
{
  protected b kEX;
  
  public i(b paramb)
  {
    GMTrace.i(18598550568960L, 138570);
    this.kEX = paramb;
    GMTrace.o(18598550568960L, 138570);
  }
  
  public static void tM(String paramString)
  {
    GMTrace.i(18598684786688L, 138571);
    if (!bf.mA(paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        v.i("MicroMsg.FileDownloaderImplBase", "Delete previous file result: %b", new Object[] { Boolean.valueOf(paramString.delete()) });
      }
    }
    GMTrace.o(18598684786688L, 138571);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/downloader/model/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */