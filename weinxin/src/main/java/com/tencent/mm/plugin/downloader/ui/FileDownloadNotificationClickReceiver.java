package com.tencent.mm.plugin.downloader.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.pu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public class FileDownloadNotificationClickReceiver
  extends BroadcastReceiver
{
  public FileDownloadNotificationClickReceiver()
  {
    GMTrace.i(18588886892544L, 138498);
    GMTrace.o(18588886892544L, 138498);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(18589021110272L, 138499);
    v.i("MicroMsg.FileDownloadNotificationClickReceiver", "onReceive");
    Object localObject = bf.bk(paramContext);
    v.i("MicroMsg.FileDownloadNotificationClickReceiver", "topActivityName = " + (String)localObject);
    paramIntent = paramIntent.getExtras();
    if (bf.mz((String)localObject).equals("com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI"))
    {
      paramContext = new pu();
      paramContext.fWH.bundle = paramIntent;
      a.uql.m(paramContext);
      GMTrace.o(18589021110272L, 138499);
      return;
    }
    localObject = new Intent(paramContext, FileDownloadConfirmUI.class);
    ((Intent)localObject).putExtras(paramIntent);
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
    GMTrace.o(18589021110272L, 138499);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/downloader/ui/FileDownloadNotificationClickReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */