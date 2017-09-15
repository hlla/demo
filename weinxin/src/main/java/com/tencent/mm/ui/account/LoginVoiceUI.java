package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
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

public class LoginVoiceUI
  extends LoginHistoryUI
{
  public LoginVoiceUI()
  {
    GMTrace.i(2785688944640L, 20755);
    GMTrace.o(2785688944640L, 20755);
  }
  
  protected final void Tn()
  {
    int j = -1;
    GMTrace.i(16830232002560L, 125395);
    super.Tn();
    bQC();
    final u localu = new u(ao.hlE.A("login_user_name", ""), this.raV, "", 0);
    localu.kD(this.raV);
    int i;
    String str;
    if (this.raV == null)
    {
      i = -1;
      str = bf.Qi(this.raV);
      if (this.uWv.uXd != null) {
        break label184;
      }
    }
    for (;;)
    {
      v.d("MicroMsg.LoginVoiceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(j), bf.Qi(this.uWv.uXd) });
      getString(R.l.dIG);
      this.isb = com.tencent.mm.ui.base.g.a(this, getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(16834392752128L, 125426);
          ap.vd().c(localu);
          LoginVoiceUI.this.bQD();
          GMTrace.o(16834392752128L, 125426);
        }
      });
      ap.vd().a(localu, 0);
      GMTrace.o(16830232002560L, 125395);
      return;
      i = this.raV.length();
      break;
      label184:
      j = this.uWv.uXd.length();
    }
  }
  
  public final boolean bQE()
  {
    GMTrace.i(2785957380096L, 20757);
    GMTrace.o(2785957380096L, 20757);
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2785823162368L, 20756);
    super.onCreate(paramBundle);
    if (this.uWI)
    {
      GMTrace.o(2785823162368L, 20756);
      return;
    }
    this.iQr = 1;
    this.sxl.setVisibility(0);
    this.uWs.setVisibility(0);
    paramBundle = (LinearLayout.LayoutParams)this.uWr.getLayoutParams();
    paramBundle.gravity = 1;
    paramBundle.leftMargin = 0;
    this.uWr.setLayoutParams(paramBundle);
    findViewById(R.h.cME).setEnabled(false);
    ((TextView)findViewById(R.h.cMI)).setTextColor(getResources().getColorStateList(R.e.aWw));
    ((TextView)findViewById(R.h.cMI)).setBackgroundResource(getResources().getColor(R.e.transparent));
    this.uWs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2718848516096L, 20257);
        com.tencent.mm.plugin.report.service.g.oSF.i(11557, new Object[] { Integer.valueOf(2) });
        paramAnonymousView = ao.hlE.A("login_user_name", "");
        Intent localIntent = new Intent();
        localIntent.putExtra("Kusername", paramAnonymousView);
        localIntent.putExtra("kscene_type", 1);
        d.b(LoginVoiceUI.this.uRf.uRz, "voiceprint", ".ui.VoiceLoginUI", localIntent, 1024);
        GMTrace.o(2718848516096L, 20257);
      }
    });
    GMTrace.o(2785823162368L, 20756);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/LoginVoiceUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */