package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class b
  implements MobileInputUI.b, e
{
  private String uXW;
  private String uXX;
  private int uYg;
  private MobileInputUI vbk;
  
  public b()
  {
    GMTrace.i(2597381472256L, 19352);
    this.uYg = 0;
    GMTrace.o(2597381472256L, 19352);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2598052560896L, 19357);
    v.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.vbk.uWW != null)
    {
      this.vbk.uWW.dismiss();
      this.vbk.uWW = null;
    }
    if (paramInt2 == -75)
    {
      g.h(this.vbk, R.l.dCW, R.l.eIT);
      GMTrace.o(2598052560896L, 19357);
      return;
    }
    if ((paramInt2 == -41) || (paramInt2 == -59))
    {
      paramString = a.dn(paramString);
      if (paramString != null)
      {
        paramString.a(this.vbk, null, null);
        GMTrace.o(2598052560896L, 19357);
        return;
      }
      g.h(this.vbk, R.l.eJB, R.l.eJC);
      GMTrace.o(2598052560896L, 19357);
      return;
    }
    if (paramk.getType() == 145)
    {
      int i = ((s)paramk).AJ();
      if (i == 12)
      {
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramk = ((s)paramk).Fx();
          if (!bf.mA(paramk)) {
            this.vbk.ory = paramk.trim();
          }
          this.vbk.ory = am.PA(this.vbk.ory);
          this.uXX = (this.vbk.vbC + this.vbk.ory);
          com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",F200_200," + ap.ec("F200_200") + ",1");
          paramString = a.dn(paramString);
          if (paramString != null)
          {
            paramString.a(this.vbk, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(2630399033344L, 19598);
                b.this.bRf();
                com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",F200_200," + ap.ec("F200_200") + ",2");
                GMTrace.o(2630399033344L, 19598);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(2595770859520L, 19340);
                com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",F200_200," + ap.ec("F200_200") + ",2");
                GMTrace.o(2595770859520L, 19340);
              }
            });
            GMTrace.o(2598052560896L, 19357);
            return;
          }
          bRf();
          com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",F200_200," + ap.ec("F200_200") + ",2");
          GMTrace.o(2598052560896L, 19357);
          return;
        }
        if (paramInt2 == -34)
        {
          g.b(this.vbk, this.vbk.getString(R.l.dNq), "", true);
          GMTrace.o(2598052560896L, 19357);
          return;
        }
        Toast.makeText(this.vbk, this.vbk.getString(R.l.dNW, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if ((i == 8) && (paramInt2 == 0))
      {
        paramString = new Intent();
        paramString.putExtra("bindmcontact_mobile", this.vbk.vbC + " " + this.vbk.vbv.getText().toString());
        paramString.putExtra("bindmcontact_shortmobile", this.vbk.ory);
        paramString.putExtra("country_name", this.vbk.hJn);
        paramString.putExtra("couttry_code", this.vbk.countryCode);
        paramString.putExtra("mobileverify_countdownsec", ((s)paramk).Fz());
        paramString.putExtra("mobileverify_countdownstyle", ((s)paramk).FA());
        paramString.putExtra("mobileverify_fb", ((s)paramk).FB());
        paramString.putExtra("mobileverify_reg_qq", ((s)paramk).FD());
        paramString.putExtra("mobile_verify_purpose", 3);
        paramString.setClass(this.vbk, MobileVerifyUI.class);
        this.vbk.startActivity(paramString);
      }
    }
    GMTrace.o(2598052560896L, 19357);
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    GMTrace.i(2597515689984L, 19353);
    this.vbk = paramMobileInputUI;
    paramMobileInputUI.vbw.requestFocus();
    paramMobileInputUI.aHc();
    String str2 = paramMobileInputUI.getString(R.l.eJQ);
    String str1 = str2;
    if (d.sXk) {
      str1 = str2 + paramMobileInputUI.getString(R.l.dCT);
    }
    paramMobileInputUI.qL(str1);
    paramMobileInputUI.uXQ.setVisibility(0);
    paramMobileInputUI.vbv.setVisibility(0);
    paramMobileInputUI.vbw.requestFocus();
    paramMobileInputUI.uYb.setText(R.l.dHH);
    paramMobileInputUI.uYb.setVisibility(0);
    GMTrace.o(2597515689984L, 19353);
  }
  
  public final void bRf()
  {
    GMTrace.i(2598186778624L, 19358);
    Object localObject = this.vbk;
    MobileInputUI localMobileInputUI = this.vbk;
    this.vbk.getString(R.l.dIG);
    ((MobileInputUI)localObject).uWW = g.a(localMobileInputUI, this.vbk.getString(R.l.eJu), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(2596844601344L, 19348);
        GMTrace.o(2596844601344L, 19348);
      }
    });
    localObject = new s(this.vbk.vbC + this.vbk.ory, 8, "", 0, "");
    ap.vd().a((k)localObject, 0);
    GMTrace.o(2598186778624L, 19358);
  }
  
  public final void start()
  {
    GMTrace.i(2597649907712L, 19354);
    ap.vd().a(145, this);
    com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",F200_100," + ap.ec("F200_100") + ",1");
    com.tencent.mm.plugin.c.b.mM("F200_100");
    this.uYg = 0;
    GMTrace.o(2597649907712L, 19354);
  }
  
  public final void stop()
  {
    GMTrace.i(2597784125440L, 19355);
    ap.vd().b(145, this);
    com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",F200_100," + ap.ec("F200_100") + ",2");
    GMTrace.o(2597784125440L, 19355);
  }
  
  public final void zy(int paramInt)
  {
    GMTrace.i(2597918343168L, 19356);
    switch (5.vbm[(paramInt - 1)])
    {
    default: 
      GMTrace.o(2597918343168L, 19356);
      return;
    }
    this.vbk.vbC = am.PC(this.vbk.countryCode);
    this.vbk.ory = this.vbk.vbv.getText().toString();
    Object localObject1 = this.vbk.vbC + this.vbk.ory;
    if (this.vbk.uWW != null)
    {
      v.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
      GMTrace.o(2597918343168L, 19356);
      return;
    }
    Object localObject2 = this.vbk;
    MobileInputUI localMobileInputUI = this.vbk;
    this.vbk.getString(R.l.dIG);
    ((MobileInputUI)localObject2).uWW = g.a(localMobileInputUI, this.vbk.getString(R.l.eJu), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(2621003792384L, 19528);
        GMTrace.o(2621003792384L, 19528);
      }
    });
    localObject2 = this.vbk.vbv.getText().toString();
    if ((this.uXW != null) && (this.uXX != null) && (!((String)localObject2).equals(this.uXW)) && (((String)localObject2).equals(this.uXX))) {
      paramInt = 1;
    }
    for (;;)
    {
      localObject1 = new s((String)localObject1, 12, "", 0, "");
      ((s)localObject1).fG(this.uYg);
      ((s)localObject1).fH(paramInt);
      ap.vd().a((k)localObject1, 0);
      this.uXW = this.vbk.vbv.getText().toString();
      this.uYg += 1;
      break;
      if ((this.uXW != null) && (this.uXX != null) && (!this.uXX.equals(this.uXW)) && (!((String)localObject2).equals(this.uXX))) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/mobile/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */