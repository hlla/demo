package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.n;

public class LoginFaceUI
  extends LoginHistoryUI
{
  public LoginFaceUI()
  {
    GMTrace.i(2717372121088L, 20246);
    GMTrace.o(2717372121088L, 20246);
  }
  
  protected final void Tn()
  {
    int j = -1;
    GMTrace.i(16836674453504L, 125443);
    super.Tn();
    bQC();
    final u localu = new u(ao.hlE.A("login_user_name", ""), this.raV, "", 0);
    int i;
    String str;
    if (this.raV == null)
    {
      i = -1;
      str = bf.Qi(this.raV);
      if (this.uWv.uXd != null) {
        break label176;
      }
    }
    for (;;)
    {
      v.d("MicroMsg.LoginFaceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), bf.Qi(this.uWv.uXd) });
      getString(R.l.dIG);
      this.isb = com.tencent.mm.ui.base.g.a(this, getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(16841640509440L, 125480);
          ap.vd().c(localu);
          LoginFaceUI.this.bQD();
          GMTrace.o(16841640509440L, 125480);
        }
      });
      ap.vd().a(localu, 0);
      GMTrace.o(16836674453504L, 125443);
      return;
      i = this.raV.length();
      break;
      label176:
      j = this.uWv.uXd.length();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2717506338816L, 20247);
    super.onCreate(paramBundle);
    if (this.uWI)
    {
      GMTrace.o(2717506338816L, 20247);
      return;
    }
    this.iQr = 4;
    this.uWF.setVisibility(0);
    this.uWt.setVisibility(0);
    findViewById(R.h.bNx).setEnabled(false);
    ((TextView)findViewById(R.h.bNy)).setTextColor(getResources().getColorStateList(R.e.aWw));
    ((TextView)findViewById(R.h.bNy)).setBackgroundResource(getResources().getColor(R.e.transparent));
    this.uWt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2741799747584L, 20428);
        com.tencent.mm.plugin.report.service.g.oSF.i(11557, new Object[] { Integer.valueOf(2) });
        paramAnonymousView = ao.hlE.A("login_user_name", "");
        Intent localIntent = new Intent();
        localIntent.putExtra("k_user_name", paramAnonymousView);
        localIntent.putExtra("k_purpose", 2);
        localIntent.putExtra("k_need_signature", true);
        d.b(LoginFaceUI.this.uRf.uRz, "facedetect", ".ui.FaceDetectUI", localIntent, 1025);
        GMTrace.o(2741799747584L, 20428);
      }
    });
    GMTrace.o(2717506338816L, 20247);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/LoginFaceUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */