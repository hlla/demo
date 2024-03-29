package com.tencent.mm.plugin.downloader.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

@JgClassChecked(author=20, fComment="checked", lastDate="20150202", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class FileDownloadReceiver
  extends BroadcastReceiver
{
  public FileDownloadReceiver()
  {
    GMTrace.i(18603382407168L, 138606);
    GMTrace.o(18603382407168L, 138606);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(18603516624896L, 138607);
    if ((paramContext == null) || (paramIntent == null))
    {
      GMTrace.o(18603516624896L, 138607);
      return;
    }
    paramContext = paramIntent.getAction();
    v.i("MicroMsg.FileDownloadReceiver", paramContext);
    if (bf.mA(paramContext))
    {
      v.e("MicroMsg.FileDownloadReceiver", "action is null or nill, ignore");
      GMTrace.o(18603516624896L, 138607);
      return;
    }
    paramContext.equals("android.intent.action.DOWNLOAD_COMPLETE");
    GMTrace.o(18603516624896L, 138607);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/downloader/model/FileDownloadReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */