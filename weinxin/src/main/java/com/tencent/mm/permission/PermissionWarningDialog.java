package com.tencent.mm.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.x;

public class PermissionWarningDialog
  extends MMBaseActivity
{
  private h ihc;
  
  public PermissionWarningDialog()
  {
    GMTrace.i(3493284806656L, 26027);
    this.ihc = null;
    GMTrace.o(3493284806656L, 26027);
  }
  
  private void Nk()
  {
    GMTrace.i(3493955895296L, 26032);
    if (getIntent() == null)
    {
      v.e("MicroMsg.PermissionWarningDialog", "Intent is null");
      GMTrace.o(3493955895296L, 26032);
      return;
    }
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      v.e("MicroMsg.PermissionWarningDialog", "invalid params");
      GMTrace.o(3493955895296L, 26032);
      return;
    }
    int i = localBundle.getInt("warning_type", 0);
    h.a locala;
    if (1 == i)
    {
      locala = new h.a(this);
      locala.SV(localBundle.getString("warning_title"));
      locala.SW(localBundle.getString("warning_content"));
      locala.zU(R.l.dHo).a(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3494492766208L, 26036);
          PermissionWarningDialog.this.finish();
          GMTrace.o(3494492766208L, 26036);
        }
      });
      this.ihc = locala.WD();
      this.ihc.setCanceledOnTouchOutside(false);
      this.ihc.show();
      GMTrace.o(3493955895296L, 26032);
      return;
    }
    if (2 == i)
    {
      locala = new h.a(this);
      final boolean bool1 = localBundle.getBoolean("warning_filter", false);
      final boolean bool2 = localBundle.getBoolean("warning_due2Exception", false);
      locala.zR(R.l.dHZ);
      locala.SW(getString(R.l.dHU));
      locala.zV(R.l.dGk).b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3494761201664L, 26038);
          b.bB(bool2);
          PermissionWarningDialog.this.finish();
          GMTrace.o(3494761201664L, 26038);
        }
      });
      locala.zU(R.l.dHO).a(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3493150588928L, 26026);
          b.e(bool1, bool2);
          PermissionWarningDialog.this.finish();
          GMTrace.o(3493150588928L, 26026);
        }
      });
      this.ihc = locala.WD();
      this.ihc.setCanceledOnTouchOutside(false);
      this.ihc.show();
    }
    GMTrace.o(3493955895296L, 26032);
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(3494224330752L, 26034);
    Intent localIntent = new Intent(paramContext, PermissionWarningDialog.class);
    localIntent.putExtra("warning_type", 2);
    localIntent.putExtra("warning_filter", paramBoolean1);
    localIntent.putExtra("warning_due2Exception", paramBoolean2);
    localIntent.addFlags(805306368);
    paramContext.startActivity(localIntent);
    GMTrace.o(3494224330752L, 26034);
  }
  
  public static void i(Context paramContext, String paramString1, String paramString2)
  {
    GMTrace.i(3494090113024L, 26033);
    Intent localIntent = new Intent(paramContext, PermissionWarningDialog.class);
    localIntent.putExtra("warning_type", 1);
    localIntent.putExtra("warning_title", paramString1);
    localIntent.putExtra("warning_content", paramString2);
    localIntent.addFlags(805306368);
    paramContext.startActivity(localIntent);
    GMTrace.o(3494090113024L, 26033);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3493419024384L, 26028);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    Nk();
    GMTrace.o(3493419024384L, 26028);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    GMTrace.i(3493687459840L, 26030);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.ihc != null)
    {
      this.ihc.dismiss();
      this.ihc = null;
    }
    Nk();
    GMTrace.o(3493687459840L, 26030);
  }
  
  protected void onPause()
  {
    GMTrace.i(3493821677568L, 26031);
    super.onPause();
    x.a(false, null);
    GMTrace.o(3493821677568L, 26031);
  }
  
  protected void onResume()
  {
    GMTrace.i(3493553242112L, 26029);
    super.onResume();
    x.a(true, null);
    GMTrace.o(3493553242112L, 26029);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/permission/PermissionWarningDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */