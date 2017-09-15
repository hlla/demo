package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

final class j
  extends i
{
  public j(b paramb)
  {
    super(paramb);
    GMTrace.i(18603919278080L, 138610);
    GMTrace.o(18603919278080L, 138610);
  }
  
  public final long a(f paramf)
  {
    GMTrace.i(18604053495808L, 138611);
    if (bf.mA(paramf.iyE))
    {
      GMTrace.o(18604053495808L, 138611);
      return -1L;
    }
    paramf = new Intent("android.intent.action.VIEW", Uri.parse(paramf.iyE));
    paramf.addFlags(268435456);
    try
    {
      aa.getContext().startActivity(paramf);
      GMTrace.o(18604053495808L, 138611);
      return 0L;
    }
    catch (Exception paramf)
    {
      v.e("MicroMsg.FileDownloaderImplNormal", "Add download task failed: " + paramf.toString());
      GMTrace.o(18604053495808L, 138611);
    }
    return -1L;
  }
  
  public final int aT(long paramLong)
  {
    GMTrace.i(18604187713536L, 138612);
    GMTrace.o(18604187713536L, 138612);
    return 1;
  }
  
  public final FileDownloadTaskInfo aU(long paramLong)
  {
    GMTrace.i(18604321931264L, 138613);
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    localFileDownloadTaskInfo.id = paramLong;
    localFileDownloadTaskInfo.status = -1;
    GMTrace.o(18604321931264L, 138613);
    return localFileDownloadTaskInfo;
  }
  
  public final boolean aV(long paramLong)
  {
    GMTrace.i(18604456148992L, 138614);
    GMTrace.o(18604456148992L, 138614);
    return false;
  }
  
  public final boolean aW(long paramLong)
  {
    GMTrace.i(18604590366720L, 138615);
    GMTrace.o(18604590366720L, 138615);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/downloader/model/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */