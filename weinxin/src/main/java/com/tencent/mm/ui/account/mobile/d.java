package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.plugin.accountsync.a.c;
import com.tencent.mm.plugin.accountsync.a.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class d
  implements MobileInputUI.b, e
{
  private String uXW;
  private String uXX;
  private int uYg;
  private MobileInputUI vbk;
  
  public d()
  {
    GMTrace.i(2584228134912L, 19254);
    this.uYg = 0;
    GMTrace.o(2584228134912L, 19254);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2584899223552L, 19259);
    v.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.vbk.uWW != null)
    {
      this.vbk.uWW.dismiss();
      this.vbk.uWW = null;
    }
    if (paramInt2 == -75)
    {
      g.h(this.vbk, R.l.dCW, R.l.eIT);
      GMTrace.o(2584899223552L, 19259);
      return;
    }
    if (paramk.getType() == 145)
    {
      if ((paramInt2 == -41) || (paramInt2 == -59))
      {
        paramString = a.dn(paramString);
        if (paramString != null)
        {
          paramString.a(this.vbk, null, null);
          GMTrace.o(2584899223552L, 19259);
          return;
        }
        g.h(this.vbk, R.l.eJB, R.l.eJC);
        GMTrace.o(2584899223552L, 19259);
        return;
      }
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
          b.b(true, ap.uY() + "," + getClass().getName() + ",R200_200," + ap.ec("R200_200") + ",1");
          paramString = a.dn(paramString);
          if (paramString != null)
          {
            paramString.a(this.vbk, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(2630667468800L, 19600);
                d.this.bRf();
                GMTrace.o(2630667468800L, 19600);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(2608387325952L, 19434);
                b.b(true, ap.uY() + "," + getClass().getName() + ",R200_200," + ap.ec("R200_200") + ",2");
                GMTrace.o(2608387325952L, 19434);
              }
            });
            GMTrace.o(2584899223552L, 19259);
            return;
          }
          bRf();
          b.b(true, ap.uY() + "," + getClass().getName() + ",R200_200," + ap.ec("R200_200") + ",2");
          GMTrace.o(2584899223552L, 19259);
          return;
        }
        if (paramInt2 == -34)
        {
          g.b(this.vbk, this.vbk.getString(R.l.dNq), "", true);
          GMTrace.o(2584899223552L, 19259);
          return;
        }
        Toast.makeText(this.vbk, this.vbk.getString(R.l.dNW, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if (i == 14)
      {
        b.mN("R200_300");
        paramString = new Intent();
        paramString.putExtra("bindmcontact_mobile", this.vbk.vbC + " " + this.vbk.vbv.getText().toString());
        paramString.putExtra("bindmcontact_shortmobile", this.vbk.ory);
        paramString.putExtra("country_name", this.vbk.hJn);
        paramString.putExtra("couttry_code", this.vbk.countryCode);
        paramString.putExtra("mobileverify_countdownsec", ((s)paramk).Fz());
        paramString.putExtra("mobileverify_countdownstyle", ((s)paramk).FA());
        paramString.putExtra("mobileverify_fb", ((s)paramk).FB());
        paramString.putExtra("mobileverify_reg_qq", ((s)paramk).FD());
        paramString.putExtra("mobile_verify_purpose", 2);
        paramString.setClass(this.vbk, MobileVerifyUI.class);
        this.vbk.startActivity(paramString);
        c.hi(c.a.irC);
      }
    }
    GMTrace.o(2584899223552L, 19259);
  }
  
  public final void a(final MobileInputUI paramMobileInputUI)
  {
    GMTrace.i(2584362352640L, 19255);
    this.vbk = paramMobileInputUI;
    String str2 = paramMobileInputUI.getString(R.l.eJP);
    String str1 = str2;
    if (com.tencent.mm.protocal.d.sXk) {
      str1 = str2 + paramMobileInputUI.getString(R.l.dCT);
    }
    paramMobileInputUI.qL(str1);
    paramMobileInputUI.kp(false);
    paramMobileInputUI.vbz.setVisibility(0);
    paramMobileInputUI.vbz.setVisibility(0);
    paramMobileInputUI.uXQ.setVisibility(0);
    paramMobileInputUI.vbv.setVisibility(0);
    paramMobileInputUI.vbw.requestFocus();
    paramMobileInputUI.vby.setVisibility(0);
    paramMobileInputUI.uYb.setVisibility(0);
    paramMobileInputUI.uYb.setText(R.l.ewT);
    if (paramMobileInputUI.uYa != null) {
      paramMobileInputUI.uYa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2595233988608L, 19336);
          bf.F(paramMobileInputUI, paramMobileInputUI.getString(R.l.eZh));
          GMTrace.o(2595233988608L, 19336);
        }
      });
    }
    str1 = paramMobileInputUI.getString(R.l.evZ);
    String str3;
    String str4;
    Spannable localSpannable;
    if (u.bIA())
    {
      str2 = paramMobileInputUI.getString(R.l.ewa);
      str3 = paramMobileInputUI.getString(R.l.eGK);
      str4 = paramMobileInputUI.getString(R.l.dCY);
      localSpannable = Spannable.Factory.getInstance().newSpannable(str1 + "  " + str2 + str4 + str3);
      localSpannable.setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2580470038528L, 19226);
          bf.F(paramMobileInputUI.uRf.uRz, paramMobileInputUI.getString(R.l.eZh));
          GMTrace.o(2580470038528L, 19226);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          GMTrace.i(2580604256256L, 19227);
          paramAnonymousTextPaint.setColor(paramMobileInputUI.getResources().getColor(R.e.aUA));
          paramAnonymousTextPaint.setUnderlineText(true);
          GMTrace.o(2580604256256L, 19227);
        }
      }, str1.length() + "  ".length(), str1.length() + str2.length() + "  ".length(), 33);
      localSpannable.setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2602213310464L, 19388);
          bf.F(paramMobileInputUI.uRf.uRz, "http://www.qq.com/privacy.htm");
          GMTrace.o(2602213310464L, 19388);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          GMTrace.i(2602347528192L, 19389);
          paramAnonymousTextPaint.setColor(paramMobileInputUI.getResources().getColor(R.e.aUA));
          paramAnonymousTextPaint.setUnderlineText(true);
          GMTrace.o(2602347528192L, 19389);
        }
      }, str1.length() + "  ".length() + str2.length() + str4.length(), str1.length() + str2.length() + "  ".length() + str4.length() + str3.length(), 33);
      paramMobileInputUI.uXZ.setText(localSpannable);
    }
    for (;;)
    {
      paramMobileInputUI.uXZ.setMovementMethod(LinkMovementMethod.getInstance());
      GMTrace.o(2584362352640L, 19255);
      return;
      str2 = paramMobileInputUI.getString(R.l.ewc);
      str3 = paramMobileInputUI.getString(R.l.ewb);
      str4 = paramMobileInputUI.getString(R.l.dCY);
      localSpannable = Spannable.Factory.getInstance().newSpannable(str1 + "  " + str2 + str4 + str3);
      localSpannable.setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2604763447296L, 19407);
          bf.F(paramMobileInputUI.uRf.uRz, paramMobileInputUI.getString(R.l.eZl));
          GMTrace.o(2604763447296L, 19407);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          GMTrace.i(2604897665024L, 19408);
          paramAnonymousTextPaint.setColor(paramMobileInputUI.getResources().getColor(R.e.aUA));
          paramAnonymousTextPaint.setUnderlineText(true);
          GMTrace.o(2604897665024L, 19408);
        }
      }, str1.length() + "  ".length(), str1.length() + "  ".length() + str2.length(), 33);
      localSpannable.setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2587852013568L, 19281);
          bf.F(paramMobileInputUI.uRf.uRz, paramMobileInputUI.getString(R.l.eZk));
          GMTrace.o(2587852013568L, 19281);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          GMTrace.i(2587986231296L, 19282);
          paramAnonymousTextPaint.setColor(paramMobileInputUI.getResources().getColor(R.e.aUA));
          paramAnonymousTextPaint.setUnderlineText(true);
          GMTrace.o(2587986231296L, 19282);
        }
      }, str1.length() + str2.length() + "  ".length() + str4.length(), str1.length() + str2.length() + "  ".length() + str4.length() + str3.length(), 33);
      paramMobileInputUI.uXZ.setText(localSpannable);
    }
  }
  
  public final void bRf()
  {
    GMTrace.i(2585033441280L, 19260);
    Object localObject = this.vbk;
    MobileInputUI localMobileInputUI = this.vbk;
    this.vbk.getString(R.l.dIG);
    ((MobileInputUI)localObject).uWW = g.a(localMobileInputUI, this.vbk.getString(R.l.eJu), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(2584093917184L, 19253);
        GMTrace.o(2584093917184L, 19253);
      }
    });
    localObject = new s(this.vbk.vbC + this.vbk.ory, 14, "", 0, "");
    ap.vd().a((k)localObject, 0);
    GMTrace.o(2585033441280L, 19260);
  }
  
  public final void start()
  {
    GMTrace.i(2584496570368L, 19256);
    ap.vd().a(145, this);
    b.b(true, ap.uY() + "," + getClass().getName() + ",R200_100," + ap.ec("R200_100") + ",1");
    b.mM("R200_100");
    this.uYg = 0;
    GMTrace.o(2584496570368L, 19256);
  }
  
  public final void stop()
  {
    GMTrace.i(2584630788096L, 19257);
    ap.vd().b(145, this);
    b.b(false, ap.uY() + "," + getClass().getName() + ",R200_100," + ap.ec("R200_100") + ",2");
    GMTrace.o(2584630788096L, 19257);
  }
  
  public final void zy(int paramInt)
  {
    GMTrace.i(2584765005824L, 19258);
    switch (2.vbm[(paramInt - 1)])
    {
    default: 
      GMTrace.o(2584765005824L, 19258);
      return;
    }
    this.vbk.vbC = am.PC(this.vbk.countryCode);
    this.vbk.ory = this.vbk.vbv.getText().toString();
    Object localObject1 = this.vbk.vbC + this.vbk.ory;
    if (this.vbk.uWW != null)
    {
      v.d("MicroMsg.MobileInputRegLogic", "already checking ");
      GMTrace.o(2584765005824L, 19258);
      return;
    }
    Object localObject2 = this.vbk;
    MobileInputUI localMobileInputUI = this.vbk;
    this.vbk.getString(R.l.dIG);
    ((MobileInputUI)localObject2).uWW = g.a(localMobileInputUI, this.vbk.getString(R.l.eJu), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(2626909372416L, 19572);
        GMTrace.o(2626909372416L, 19572);
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


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/mobile/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */