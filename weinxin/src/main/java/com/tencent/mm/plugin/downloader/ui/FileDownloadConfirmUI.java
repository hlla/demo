package com.tencent.mm.plugin.downloader.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.downloader.b.b;
import com.tencent.mm.plugin.downloader.b.c;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;

public class FileDownloadConfirmUI
  extends MMBaseActivity
{
  private h ihc;
  
  public FileDownloadConfirmUI()
  {
    GMTrace.i(18587947368448L, 138491);
    this.ihc = null;
    GMTrace.o(18587947368448L, 138491);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    GMTrace.i(18588081586176L, 138492);
    super.onCreate(paramBundle);
    setContentView(b.b.empty);
    paramBundle = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(18587813150720L, 138490);
        e.akG().aT(this.kEA);
        v.i("MicroMsg.FileDownloadConfirmUI", "Remove task: %d", new Object[] { Long.valueOf(this.kEA) });
        GMTrace.o(18587813150720L, 138490);
      }
    };
    DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(18588484239360L, 138495);
        GMTrace.o(18588484239360L, 138495);
      }
    };
    DialogInterface.OnDismissListener local3 = new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(18588752674816L, 138497);
        FileDownloadConfirmUI.this.finish();
        GMTrace.o(18588752674816L, 138497);
      }
    };
    h.a locala = new h.a(this);
    locala.SV("");
    locala.zS(b.c.kEm);
    locala.zU(b.c.dIW).a(paramBundle);
    locala.zV(b.c.dHI).b(local2);
    locala.a(local3);
    this.ihc = locala.WD();
    this.ihc.show();
    v.i("MicroMsg.FileDownloadConfirmUI", "Confirm Dialog");
    GMTrace.o(18588081586176L, 138492);
  }
  
  protected void onStop()
  {
    GMTrace.i(18588215803904L, 138493);
    super.onStop();
    this.ihc.dismiss();
    GMTrace.o(18588215803904L, 138493);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/downloader/ui/FileDownloadConfirmUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */