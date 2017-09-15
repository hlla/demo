package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.x;

public class JDRemindDialog
  extends MMBaseActivity
{
  private h ihc;
  
  public JDRemindDialog()
  {
    GMTrace.i(5856724779008L, 43636);
    this.ihc = null;
    GMTrace.o(5856724779008L, 43636);
  }
  
  private void Nk()
  {
    GMTrace.i(5857395867648L, 43641);
    if (getIntent() == null)
    {
      GMTrace.o(5857395867648L, 43641);
      return;
    }
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      GMTrace.o(5857395867648L, 43641);
      return;
    }
    h.a locala = new h.a(this);
    locala.SV("");
    locala.SW(localBundle.getString("alertcontent"));
    locala.SY(localBundle.getString("alertconfirm")).a(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(5852429811712L, 43604);
        Object localObject2 = null;
        String str = "";
        Object localObject1 = str;
        paramAnonymousDialogInterface = (DialogInterface)localObject2;
        if (JDRemindDialog.this.getIntent() != null)
        {
          localObject1 = str;
          paramAnonymousDialogInterface = (DialogInterface)localObject2;
          if (JDRemindDialog.this.getIntent().getExtras() != null)
          {
            paramAnonymousDialogInterface = JDRemindDialog.this.getIntent().getExtras().getString("alertjumpurl");
            localObject1 = JDRemindDialog.this.getIntent().getExtras().getString("alert_activityid");
          }
        }
        if ((((String)localObject1).equals(c.bmE().bmJ().qQW)) && (c.bmE().bmF()))
        {
          c.bmE().bmI();
          c.bmE().bmH();
        }
        if (!bf.mA(paramAnonymousDialogInterface))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", paramAnonymousDialogInterface);
          ((Intent)localObject1).putExtra("useJs", true);
          ((Intent)localObject1).putExtra("vertical_scroll", true);
          d.b(JDRemindDialog.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          g.oSF.i(11179, new Object[] { paramAnonymousDialogInterface, c.bmE().bmJ().qQW, Integer.valueOf(5) });
        }
        JDRemindDialog.this.finish();
        GMTrace.o(5852429811712L, 43604);
      }
    });
    locala.SZ(localBundle.getString("alert_cancel")).b(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(5850819198976L, 43592);
        JDRemindDialog.this.finish();
        GMTrace.o(5850819198976L, 43592);
      }
    });
    this.ihc = locala.WD();
    this.ihc.setCanceledOnTouchOutside(false);
    this.ihc.show();
    GMTrace.o(5857395867648L, 43641);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    GMTrace.i(5857530085376L, 43642);
    Intent localIntent = new Intent(paramContext, JDRemindDialog.class);
    localIntent.putExtra("alertcontent", paramString1);
    localIntent.putExtra("alertconfirm", paramString2);
    localIntent.putExtra("alert_cancel", paramString3);
    localIntent.putExtra("alertjumpurl", paramString4);
    localIntent.putExtra("alert_activityid", paramString5);
    localIntent.addFlags(805306368);
    paramContext.startActivity(localIntent);
    GMTrace.o(5857530085376L, 43642);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    GMTrace.i(5856858996736L, 43637);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    Nk();
    GMTrace.o(5856858996736L, 43637);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    GMTrace.i(5857127432192L, 43639);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.ihc != null)
    {
      this.ihc.dismiss();
      this.ihc = null;
    }
    Nk();
    GMTrace.o(5857127432192L, 43639);
  }
  
  protected void onPause()
  {
    GMTrace.i(5857261649920L, 43640);
    super.onPause();
    x.a(false, null);
    GMTrace.o(5857261649920L, 43640);
  }
  
  protected void onResume()
  {
    GMTrace.i(5856993214464L, 43638);
    super.onResume();
    x.a(true, null);
    GMTrace.o(5856993214464L, 43638);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/jdbiz/JDRemindDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */