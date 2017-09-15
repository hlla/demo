package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.account.LoginUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class c
  implements MobileInputUI.b, e
{
  private SecurityImage uSI;
  private MobileInputUI vbk;
  private a vbn;
  
  public c()
  {
    GMTrace.i(2605031882752L, 19409);
    this.uSI = null;
    this.vbn = null;
    GMTrace.o(2605031882752L, 19409);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2605837189120L, 19415);
    v.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.vbk.uWW != null)
    {
      this.vbk.uWW.dismiss();
      this.vbk.uWW = null;
    }
    if ((paramk.getType() == 701) && (this.vbn != null))
    {
      this.vbn.uXv = this.vbk.uXv;
      this.vbn.a(this.vbk, paramInt1, paramInt2, paramString, paramk);
      GMTrace.o(2605837189120L, 19415);
      return;
    }
    if ((paramk.getType() == 145) && (((s)paramk).AJ() == 13))
    {
      if (paramInt2 == -41)
      {
        paramString = com.tencent.mm.f.a.dn(paramString);
        if (paramString != null)
        {
          paramString.a(this.vbk, null, null);
          GMTrace.o(2605837189120L, 19415);
          return;
        }
        g.h(this.vbk, R.l.eJB, R.l.eJC);
        GMTrace.o(2605837189120L, 19415);
        return;
      }
      if (paramInt2 == -1)
      {
        Toast.makeText(this.vbk, this.vbk.getString(R.l.ekZ, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        GMTrace.o(2605837189120L, 19415);
        return;
      }
      if (paramInt2 == -34)
      {
        g.b(this.vbk, this.vbk.getString(R.l.dNq), "", true);
        GMTrace.o(2605837189120L, 19415);
        return;
      }
      this.vbk.aGY();
      paramString = new Intent(this.vbk, MobileInputUI.class);
      paramString.putExtra("mobile_input_purpose", -1);
      paramString.putExtra("mobile_auth_type", 7);
      paramString.putExtra("input_country_code", this.vbk.countryCode);
      paramString.putExtra("input_mobile_number", this.vbk.ory);
      this.vbk.startActivity(paramString);
      GMTrace.o(2605837189120L, 19415);
      return;
    }
    GMTrace.o(2605837189120L, 19415);
  }
  
  public final void a(final MobileInputUI paramMobileInputUI)
  {
    GMTrace.i(2605166100480L, 19410);
    this.vbk = paramMobileInputUI;
    paramMobileInputUI.uXQ.setVisibility(0);
    paramMobileInputUI.vbv.setVisibility(0);
    paramMobileInputUI.vbw.requestFocus();
    paramMobileInputUI.uYb.setText(R.l.dHH);
    paramMobileInputUI.uYb.setVisibility(0);
    paramMobileInputUI.vbA.setVisibility(0);
    paramMobileInputUI.vbB.setText(R.l.ewA);
    paramMobileInputUI.vbB.setVisibility(0);
    paramMobileInputUI.vbB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(16810233561088L, 125246);
        paramMobileInputUI.niS[0] = 1;
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(paramMobileInputUI, LoginUI.class);
        paramMobileInputUI.startActivity(paramAnonymousView);
        paramMobileInputUI.finish();
        GMTrace.o(16810233561088L, 125246);
      }
    });
    GMTrace.o(2605166100480L, 19410);
  }
  
  public final void start()
  {
    GMTrace.i(2605434535936L, 19412);
    ap.vd().a(145, this);
    b.b(true, ap.uY() + "," + getClass().getName() + ",L200_100," + ap.ec("L200_100") + ",1");
    b.mM("L200_100");
    GMTrace.o(2605434535936L, 19412);
  }
  
  public final void stop()
  {
    GMTrace.i(2605568753664L, 19413);
    ap.vd().b(145, this);
    b.b(false, ap.uY() + "," + getClass().getName() + ",L200_100," + ap.ec("L200_100") + ",2");
    GMTrace.o(2605568753664L, 19413);
  }
  
  public final void zy(int paramInt)
  {
    GMTrace.i(2605702971392L, 19414);
    switch (3.vbm[(paramInt - 1)])
    {
    }
    for (;;)
    {
      GMTrace.o(2605702971392L, 19414);
      return;
      this.vbk.vbC = am.PC(this.vbk.countryCode);
      this.vbk.ory = this.vbk.vbw.getText().toString();
      Object localObject = am.PA(this.vbk.vbC + this.vbk.ory);
      MobileInputUI localMobileInputUI1 = this.vbk;
      MobileInputUI localMobileInputUI2 = this.vbk;
      this.vbk.getString(R.l.dIG);
      localMobileInputUI1.uWW = g.a(localMobileInputUI2, this.vbk.getString(R.l.eJu), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(2588791537664L, 19288);
          GMTrace.o(2588791537664L, 19288);
        }
      });
      localObject = new s((String)localObject, 13, "", 0, "");
      ap.vd().a((k)localObject, 0);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/mobile/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */