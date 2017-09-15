package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.il;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ae.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public class RegByMobileRegAIOUI
  extends MMActivity
  implements com.tencent.mm.y.e
{
  private String countryCode;
  private String hJn;
  private int iQr;
  private ImageView ipb;
  private String oTI;
  private String ory;
  private int progress;
  private com.tencent.mm.sdk.b.c uVQ;
  private ResizeLayout uWB;
  private p uWW;
  private LinearLayout uXQ;
  private TextView uXR;
  private EditText uXS;
  private MMFormInputView uXT;
  private String uXU;
  private boolean uXV;
  private String uXW;
  private String uXX;
  private String uXY;
  private TextView uXZ;
  private Button uYa;
  private Button uYb;
  private MMFormInputView uYc;
  private boolean uYd;
  private ImageView uYe;
  private MMFormInputView uYf;
  private int uYg;
  private boolean uYh;
  private boolean uYi;
  private ScrollView uYj;
  private boolean uYk;
  private ProgressBar uYl;
  private com.tencent.mm.ui.base.h uYm;
  private ad uYn;
  private j uYo;
  private boolean uYp;
  private j.a uYq;
  private int uYr;
  private int uYs;
  private boolean uYt;
  private boolean uYu;
  private final int uYv;
  
  public RegByMobileRegAIOUI()
  {
    GMTrace.i(2700594905088L, 20121);
    this.uXU = null;
    this.hJn = null;
    this.countryCode = null;
    this.uXV = true;
    this.uXY = null;
    this.ory = null;
    this.uYd = false;
    this.uYg = 0;
    this.uYk = false;
    this.uVQ = new com.tencent.mm.sdk.b.c() {};
    this.uYm = null;
    this.progress = 0;
    this.uYn = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(16834526969856L, 125427);
        if (((RegByMobileRegAIOUI.o(RegByMobileRegAIOUI.this) != null) && (!RegByMobileRegAIOUI.o(RegByMobileRegAIOUI.this).isShowing())) || (RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this)))
        {
          GMTrace.o(16834526969856L, 125427);
          return;
        }
        RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this, RegByMobileRegAIOUI.q(RegByMobileRegAIOUI.this) + 2);
        RegByMobileRegAIOUI.r(RegByMobileRegAIOUI.this).setProgress(RegByMobileRegAIOUI.q(RegByMobileRegAIOUI.this));
        if (RegByMobileRegAIOUI.q(RegByMobileRegAIOUI.this) < RegByMobileRegAIOUI.r(RegByMobileRegAIOUI.this).getMax())
        {
          sendEmptyMessageDelayed(0, 10L);
          GMTrace.o(16834526969856L, 125427);
          return;
        }
        RegByMobileRegAIOUI.r(RegByMobileRegAIOUI.this).setIndeterminate(true);
        if (!RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this))
        {
          if (RegByMobileRegAIOUI.o(RegByMobileRegAIOUI.this) != null) {
            RegByMobileRegAIOUI.o(RegByMobileRegAIOUI.this).dismiss();
          }
          RegByMobileRegAIOUI.s(RegByMobileRegAIOUI.this);
        }
        GMTrace.o(16834526969856L, 125427);
      }
    };
    this.uYp = false;
    this.uYq = new j.a()
    {
      public final void SO(String paramAnonymousString)
      {
        GMTrace.i(16847680307200L, 125525);
        paramAnonymousString = paramAnonymousString.trim();
        RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this, paramAnonymousString);
        GMTrace.o(16847680307200L, 125525);
      }
      
      public final void bQN()
      {
        GMTrace.i(16847814524928L, 125526);
        RegByMobileRegAIOUI.s(RegByMobileRegAIOUI.this);
        GMTrace.o(16847814524928L, 125526);
      }
    };
    this.uYv = 128;
    GMTrace.o(2700594905088L, 20121);
  }
  
  private void SN(String paramString)
  {
    try
    {
      GMTrace.i(2702071300096L, 20132);
      if (this.uYo != null)
      {
        this.uYo.bRb();
        this.uYo = null;
      }
      if (!this.uYp)
      {
        this.uYp = true;
        finish();
        Intent localIntent = new Intent();
        localIntent.putExtra("bindmcontact_mobile", this.uXY + " " + this.uXS.getText().toString());
        localIntent.putExtra("bindmcontact_shortmobile", this.ory);
        localIntent.putExtra("country_name", this.hJn);
        localIntent.putExtra("couttry_code", this.countryCode);
        localIntent.putExtra("login_type", this.iQr);
        localIntent.putExtra("mobileverify_countdownsec", this.uYr);
        localIntent.putExtra("mobileverify_countdownstyle", this.uYs);
        localIntent.putExtra("mobileverify_fb", this.uYt);
        localIntent.putExtra("mobileverify_reg_qq", this.uYu);
        localIntent.putExtra("kintent_nickname", this.uYf.getText().toString());
        localIntent.putExtra("kintent_password", this.uYc.getText().toString());
        localIntent.putExtra("kintent_hasavatar", this.uYd);
        localIntent.putExtra("mobile_verify_purpose", 2);
        if ((paramString != null) && (paramString.length() > 0)) {
          localIntent.putExtra("MicroMsg.MobileVerifyUIIntent_sms_code", paramString);
        }
        a(MobileVerifyUI.class, localIntent);
      }
      GMTrace.o(2702071300096L, 20132);
      return;
    }
    finally {}
  }
  
  private boolean a(Editable... paramVarArgs)
  {
    GMTrace.i(2702205517824L, 20133);
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      Editable localEditable = paramVarArgs[i];
      if ((localEditable != null) && (localEditable.toString().length() != 0)) {}
    }
    for (i = 0;; i = 1)
    {
      if ((i != 0) && (this.uXV))
      {
        GMTrace.o(2702205517824L, 20133);
        return true;
        i += 1;
        break;
      }
      GMTrace.o(2702205517824L, 20133);
      return false;
    }
  }
  
  private void aXL()
  {
    GMTrace.i(2701534429184L, 20128);
    com.tencent.mm.plugin.c.b.mN(this.oTI);
    com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",RE200_100," + ap.ec("RE200_100") + ",2");
    finish();
    GMTrace.o(2701534429184L, 20128);
  }
  
  private void bQM()
  {
    GMTrace.i(16830366220288L, 125396);
    if ((!com.tencent.mm.sdk.platformtools.bf.mA(this.hJn)) && (!com.tencent.mm.sdk.platformtools.bf.mA(this.countryCode)))
    {
      this.uXR.setText(am.ez(this.hJn, this.countryCode));
      GMTrace.o(16830366220288L, 125396);
      return;
    }
    this.uXR.setText(getString(R.l.eAP));
    GMTrace.o(16830366220288L, 125396);
  }
  
  private void zw(int paramInt)
  {
    GMTrace.i(2702339735552L, 20134);
    switch (18.uXP[(paramInt - 1)])
    {
    }
    for (;;)
    {
      GMTrace.o(2702339735552L, 20134);
      return;
      g.h(this, R.l.eJF, R.l.eJH);
      GMTrace.o(2702339735552L, 20134);
      return;
      g.h(this, R.l.eJG, R.l.eJH);
      GMTrace.o(2702339735552L, 20134);
      return;
      g.h(this, R.l.eZO, R.l.dGK);
      GMTrace.o(2702339735552L, 20134);
      return;
      g.h(this, R.l.eZQ, R.l.dGK);
    }
  }
  
  protected final void KD()
  {
    GMTrace.i(2701265993728L, 20126);
    this.uXQ = ((LinearLayout)findViewById(R.h.bGJ));
    this.uXR = ((TextView)findViewById(R.h.bGL));
    this.uXT = ((MMFormInputView)findViewById(R.h.cxs));
    this.uXT.setInputType(3);
    this.uXS = this.uXT.oAr;
    this.uXZ = ((TextView)findViewById(R.h.bnW));
    this.uYb = ((Button)findViewById(R.h.cxj));
    this.ipb = ((ImageView)findViewById(R.h.cCy));
    this.uYe = ((ImageView)findViewById(R.h.cCA));
    this.uYc = ((MMFormInputView)findViewById(R.h.cxq));
    com.tencent.mm.ui.tools.a.c.d(this.uYc.oAr).Cc(16).a(null);
    this.uYj = ((ScrollView)findViewById(R.h.Ki));
    this.uWB = ((ResizeLayout)findViewById(R.h.cyt));
    this.uYf = ((MMFormInputView)findViewById(R.h.cxl));
    this.uYf.oAr.requestFocus();
    this.uWB.uZT = new ResizeLayout.a()
    {
      public final void bQF()
      {
        GMTrace.i(16819628802048L, 125316);
        RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this);
        GMTrace.o(16819628802048L, 125316);
      }
    };
    Object localObject = new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        GMTrace.i(2690125922304L, 20043);
        if (paramAnonymousBoolean) {
          RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this);
        }
        GMTrace.o(2690125922304L, 20043);
      }
    };
    this.uYf.vhy = ((View.OnFocusChangeListener)localObject);
    this.uYc.vhy = ((View.OnFocusChangeListener)localObject);
    com.tencent.mm.u.bf.zK();
    this.uYi = true;
    com.tencent.mm.u.bf.zK();
    this.uYh = true;
    if (!this.uYh)
    {
      this.ipb.setVisibility(8);
      this.uYe.setVisibility(8);
    }
    if (!this.uYi) {
      this.uYc.setVisibility(8);
    }
    String str1 = getString(R.l.eJQ);
    localObject = str1;
    if (com.tencent.mm.protocal.d.sXk) {
      localObject = str1 + getString(R.l.dCT);
    }
    qL((String)localObject);
    if (this.uYa != null) {
      this.uYa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2773743566848L, 20666);
          com.tencent.mm.sdk.platformtools.bf.F(RegByMobileRegAIOUI.this.uRf.uRz, RegByMobileRegAIOUI.this.getString(R.l.eZh));
          GMTrace.o(2773743566848L, 20666);
        }
      });
    }
    localObject = getString(R.l.evZ);
    String str2;
    String str3;
    Spannable localSpannable;
    if (u.bIA())
    {
      str1 = getString(R.l.ewa);
      str2 = getString(R.l.eGK);
      str3 = getString(R.l.dCY);
      localSpannable = Spannable.Factory.getInstance().newSpannable((String)localObject + "  " + str1 + str3 + str2);
      localSpannable.setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2635230871552L, 19634);
          com.tencent.mm.sdk.platformtools.bf.F(RegByMobileRegAIOUI.this.uRf.uRz, RegByMobileRegAIOUI.this.getString(R.l.eZh));
          GMTrace.o(2635230871552L, 19634);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          GMTrace.i(2635365089280L, 19635);
          paramAnonymousTextPaint.setColor(RegByMobileRegAIOUI.this.getResources().getColor(R.e.aUA));
          paramAnonymousTextPaint.setUnderlineText(true);
          GMTrace.o(2635365089280L, 19635);
        }
      }, ((String)localObject).length() + "  ".length(), ((String)localObject).length() + str1.length() + "  ".length(), 33);
      localSpannable.setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2766764244992L, 20614);
          com.tencent.mm.sdk.platformtools.bf.F(RegByMobileRegAIOUI.this.uRf.uRz, "http://www.qq.com/privacy.htm");
          GMTrace.o(2766764244992L, 20614);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          GMTrace.i(2766898462720L, 20615);
          paramAnonymousTextPaint.setColor(RegByMobileRegAIOUI.this.getResources().getColor(R.e.aUA));
          paramAnonymousTextPaint.setUnderlineText(true);
          GMTrace.o(2766898462720L, 20615);
        }
      }, ((String)localObject).length() + "  ".length() + str1.length() + str3.length(), ((String)localObject).length() + "  ".length() + str1.length() + str3.length() + str2.length(), 33);
      this.uXZ.setText(localSpannable);
      this.uXZ.setMovementMethod(LinkMovementMethod.getInstance());
      this.uXS.addTextChangedListener(new TextWatcher()
      {
        private am mPZ;
        
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          GMTrace.i(2760187576320L, 20565);
          RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
          GMTrace.o(2760187576320L, 20565);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(2760321794048L, 20566);
          GMTrace.o(2760321794048L, 20566);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(2760456011776L, 20567);
          GMTrace.o(2760456011776L, 20567);
        }
      });
      this.uYc.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          GMTrace.i(16827547648000L, 125375);
          RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
          GMTrace.o(16827547648000L, 125375);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(16827413430272L, 125374);
          GMTrace.o(16827413430272L, 125374);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(16827279212544L, 125373);
          GMTrace.o(16827279212544L, 125373);
        }
      });
      this.uYf.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          GMTrace.i(2720459128832L, 20269);
          RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
          GMTrace.o(2720459128832L, 20269);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(2720324911104L, 20268);
          GMTrace.o(2720324911104L, 20268);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(2720190693376L, 20267);
          GMTrace.o(2720190693376L, 20267);
        }
      });
      this.uYb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16833587445760L, 125420);
          paramAnonymousView = com.tencent.mm.ui.tools.a.c.d(RegByMobileRegAIOUI.g(RegByMobileRegAIOUI.this).oAr).em(1, 32);
          paramAnonymousView.wnj = true;
          paramAnonymousView.a(new c.a()
          {
            public final void YH()
            {
              GMTrace.i(16842311598080L, 125485);
              g.h(RegByMobileRegAIOUI.this, R.l.eSO, R.l.eSQ);
              GMTrace.o(16842311598080L, 125485);
            }
            
            public final void Yj()
            {
              GMTrace.i(16842445815808L, 125486);
              g.h(RegByMobileRegAIOUI.this, R.l.eSP, R.l.eSQ);
              GMTrace.o(16842445815808L, 125486);
            }
            
            public final void rk(String paramAnonymous2String)
            {
              GMTrace.i(16842177380352L, 125484);
              RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this, am.PA(RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this).getText().toString()));
              RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this, am.PC(RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this)));
              paramAnonymous2String = RegByMobileRegAIOUI.e(RegByMobileRegAIOUI.this) + RegByMobileRegAIOUI.f(RegByMobileRegAIOUI.this);
              RegByMobileRegAIOUI.this.aGY();
              RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this, paramAnonymous2String);
              GMTrace.o(16842177380352L, 125484);
            }
          });
          GMTrace.o(16833587445760L, 125420);
        }
      });
      this.uYb.setEnabled(false);
      if ((com.tencent.mm.sdk.platformtools.bf.mA(this.hJn)) || (com.tencent.mm.sdk.platformtools.bf.mA(this.countryCode)))
      {
        localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        v.i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + (String)localObject);
        if (!com.tencent.mm.sdk.platformtools.bf.mA((String)localObject)) {
          break label1064;
        }
        v.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
      }
      label729:
      if ((com.tencent.mm.sdk.platformtools.bf.mA(this.hJn)) || (com.tencent.mm.sdk.platformtools.bf.mA(this.countryCode)))
      {
        this.hJn = getString(R.l.eaI);
        this.countryCode = am.PB(getString(R.l.eaH));
      }
      bQM();
      if ((this.uXU == null) || (this.uXU.equals(""))) {
        break label1112;
      }
      this.uXS.setText(this.uXU);
    }
    for (;;)
    {
      this.uXQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16805535940608L, 125211);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", RegByMobileRegAIOUI.h(RegByMobileRegAIOUI.this));
          paramAnonymousView.putExtra("couttry_code", RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this));
          com.tencent.mm.plugin.c.a.imb.b(paramAnonymousView, RegByMobileRegAIOUI.this);
          GMTrace.o(16805535940608L, 125211);
        }
      });
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(16820568326144L, 125323);
          RegByMobileRegAIOUI.this.aGY();
          RegByMobileRegAIOUI.i(RegByMobileRegAIOUI.this);
          RegByMobileRegAIOUI.this.finish();
          GMTrace.o(16820568326144L, 125323);
          return true;
        }
      });
      this.ipb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16824057987072L, 125349);
          com.tencent.mm.plugin.c.a.imc.c(RegByMobileRegAIOUI.this);
          GMTrace.o(16824057987072L, 125349);
        }
      });
      ap.vL().a(new ae.a()
      {
        Bitmap bitmap;
        String fER;
        
        public final boolean Bn()
        {
          GMTrace.i(16826876559360L, 125370);
          this.fER = com.tencent.mm.modelsimple.c.ba(RegByMobileRegAIOUI.this);
          this.bitmap = com.tencent.mm.modelsimple.c.bb(RegByMobileRegAIOUI.this);
          if ((this.bitmap != null) && (!this.bitmap.isRecycled())) {}
          try
          {
            com.tencent.mm.sdk.platformtools.d.a(this.bitmap, 100, Bitmap.CompressFormat.PNG, com.tencent.mm.compatible.util.e.gSw + "temp.avatar", false);
            GMTrace.o(16826876559360L, 125370);
            return true;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              v.e("MicroMsg.RegByMobileRegAIOUI", "save avatar fail." + localException.getMessage());
              v.printErrStackTrace("MicroMsg.RegByMobileRegAIOUI", localException, "", new Object[0]);
            }
          }
        }
        
        public final boolean Bo()
        {
          GMTrace.i(16826742341632L, 125369);
          if ((!com.tencent.mm.sdk.platformtools.bf.mA(this.fER)) && (com.tencent.mm.sdk.platformtools.bf.mA(RegByMobileRegAIOUI.g(RegByMobileRegAIOUI.this).getText().trim()))) {
            RegByMobileRegAIOUI.g(RegByMobileRegAIOUI.this).setText(this.fER);
          }
          if (!f.rZ())
          {
            v.e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
            GMTrace.o(16826742341632L, 125369);
            return false;
          }
          if ((this.bitmap != null) && (!this.bitmap.isRecycled()) && (!RegByMobileRegAIOUI.j(RegByMobileRegAIOUI.this)))
          {
            RegByMobileRegAIOUI.k(RegByMobileRegAIOUI.this).setImageBitmap(this.bitmap);
            RegByMobileRegAIOUI.l(RegByMobileRegAIOUI.this).setVisibility(8);
            RegByMobileRegAIOUI.m(RegByMobileRegAIOUI.this);
          }
          GMTrace.o(16826742341632L, 125369);
          return true;
        }
        
        public final String toString()
        {
          GMTrace.i(16827010777088L, 125371);
          String str = super.toString() + "|initView2";
          GMTrace.o(16827010777088L, 125371);
          return str;
        }
      });
      GMTrace.o(2701265993728L, 20126);
      return;
      str1 = getString(R.l.ewc);
      str2 = getString(R.l.ewb);
      str3 = getString(R.l.dCY);
      localSpannable = Spannable.Factory.getInstance().newSpannable((String)localObject + "  " + str1 + str3 + str2);
      localSpannable.setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2754147778560L, 20520);
          com.tencent.mm.sdk.platformtools.bf.F(RegByMobileRegAIOUI.this.uRf.uRz, RegByMobileRegAIOUI.this.getString(R.l.eZl));
          GMTrace.o(2754147778560L, 20520);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          GMTrace.i(2754281996288L, 20521);
          paramAnonymousTextPaint.setColor(RegByMobileRegAIOUI.this.getResources().getColor(R.e.aUA));
          paramAnonymousTextPaint.setUnderlineText(true);
          GMTrace.o(2754281996288L, 20521);
        }
      }, ((String)localObject).length() + "  ".length(), ((String)localObject).length() + "  ".length() + str1.length(), 33);
      localSpannable.setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2733478248448L, 20366);
          com.tencent.mm.sdk.platformtools.bf.F(RegByMobileRegAIOUI.this.uRf.uRz, RegByMobileRegAIOUI.this.getString(R.l.eZk));
          GMTrace.o(2733478248448L, 20366);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          GMTrace.i(2733612466176L, 20367);
          paramAnonymousTextPaint.setColor(RegByMobileRegAIOUI.this.getResources().getColor(R.e.aUA));
          paramAnonymousTextPaint.setUnderlineText(true);
          GMTrace.o(2733612466176L, 20367);
        }
      }, ((String)localObject).length() + str1.length() + "  ".length() + str3.length(), ((String)localObject).length() + str1.length() + "  ".length() + str3.length() + str2.length(), 33);
      this.uXZ.setText(localSpannable);
      break;
      label1064:
      localObject = com.tencent.mm.ai.b.g(this, (String)localObject, getString(R.l.bGH));
      if (localObject == null)
      {
        v.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
        break label729;
      }
      this.hJn = ((b.a)localObject).hJn;
      this.countryCode = ((b.a)localObject).hJm;
      break label729;
      label1112:
      ap.vL().a(new ae.a()
      {
        String ktE;
        
        public final boolean Bn()
        {
          GMTrace.i(16848754049024L, 125533);
          this.ktE = com.tencent.mm.modelsimple.c.y(RegByMobileRegAIOUI.this, RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this));
          GMTrace.o(16848754049024L, 125533);
          return true;
        }
        
        public final boolean Bo()
        {
          GMTrace.i(16848619831296L, 125532);
          EditText localEditText;
          if (com.tencent.mm.sdk.platformtools.bf.mA(RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this).getText().trim()))
          {
            localEditText = RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this);
            if (!com.tencent.mm.sdk.platformtools.bf.mA(this.ktE)) {
              break label76;
            }
          }
          label76:
          for (String str = "";; str = this.ktE)
          {
            localEditText.setText(str);
            GMTrace.o(16848619831296L, 125532);
            return true;
          }
        }
        
        public final String toString()
        {
          GMTrace.i(16848888266752L, 125534);
          String str = super.toString() + "|initView1";
          GMTrace.o(16848888266752L, 125534);
          return str;
        }
      });
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2701802864640L, 20130);
    v.i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.uWW != null)
    {
      this.uWW.dismiss();
      this.uWW = null;
    }
    if (paramInt2 == -75)
    {
      g.h(this, R.l.dCW, R.l.eIT);
      GMTrace.o(2701802864640L, 20130);
      return;
    }
    if (paramk.getType() == 145)
    {
      int i = ((s)paramk).AJ();
      if (i == 12)
      {
        if ((paramInt2 == -41) || (paramInt2 == -59))
        {
          paramString = com.tencent.mm.f.a.dn(paramString);
          if (paramString != null)
          {
            paramString.a(this, null, null);
            GMTrace.o(2701802864640L, 20130);
            return;
          }
          g.h(this, R.l.eJB, R.l.eJC);
          GMTrace.o(2701802864640L, 20130);
          return;
        }
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramk = ((s)paramk).Fx();
          if (!com.tencent.mm.sdk.platformtools.bf.mA(paramk)) {
            this.ory = paramk.trim();
          }
          this.ory = am.PA(this.ory);
          this.uXX = (this.uXY + this.ory);
          com.tencent.mm.plugin.c.b.mM("RE200_100");
          com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",RE200_200," + ap.ec("RE200_200") + ",1");
          paramString = com.tencent.mm.f.a.dn(paramString);
          if (paramString != null)
          {
            paramString.a(this, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(16820970979328L, 125326);
                paramAnonymousDialogInterface = RegByMobileRegAIOUI.this;
                RegByMobileRegAIOUI localRegByMobileRegAIOUI = RegByMobileRegAIOUI.this;
                RegByMobileRegAIOUI.this.getString(R.l.dIG);
                RegByMobileRegAIOUI.a(paramAnonymousDialogInterface, g.a(localRegByMobileRegAIOUI, RegByMobileRegAIOUI.this.getString(R.l.eJu), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    GMTrace.i(16846338129920L, 125515);
                    GMTrace.o(16846338129920L, 125515);
                  }
                }));
                paramAnonymousDialogInterface = new s(RegByMobileRegAIOUI.e(RegByMobileRegAIOUI.this) + RegByMobileRegAIOUI.f(RegByMobileRegAIOUI.this), 14, "", 0, "");
                ap.vd().a(paramAnonymousDialogInterface, 0);
                com.tencent.mm.plugin.c.b.mN("RE200_250");
                RegByMobileRegAIOUI.n(RegByMobileRegAIOUI.this);
                GMTrace.o(16820970979328L, 125326);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(2752805601280L, 20510);
                com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + RegByMobileRegAIOUI.this.getClass().getName() + ",RE200_200," + ap.ec("RE200_200") + ",2");
                com.tencent.mm.plugin.c.b.mN("RE200_100");
                GMTrace.o(2752805601280L, 20510);
              }
            });
            GMTrace.o(2701802864640L, 20130);
            return;
          }
          getString(R.l.dIG);
          this.uWW = g.a(this, getString(R.l.eJu), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              GMTrace.i(16836942888960L, 125445);
              GMTrace.o(16836942888960L, 125445);
            }
          });
          paramString = new s(this.uXY + this.ory, 14, "", 0, "");
          ap.vd().a(paramString, 0);
          com.tencent.mm.plugin.c.b.mN("RE200_250");
          this.uYk = false;
          GMTrace.o(2701802864640L, 20130);
          return;
        }
        if (paramInt2 == -34)
        {
          g.b(this, getString(R.l.dNq), "", true);
          GMTrace.o(2701802864640L, 20130);
          return;
        }
        if (com.tencent.mm.plugin.c.a.imc.a(this, paramInt1, paramInt2, paramString))
        {
          GMTrace.o(2701802864640L, 20130);
          return;
        }
        Toast.makeText(this, getString(R.l.dNW, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if (i == 14)
      {
        if ((paramInt2 != 0) && (paramString != null)) {
          break label838;
        }
        this.uYr = ((s)paramk).Fz();
        this.uYs = ((s)paramk).FA();
        this.uYt = ((s)paramk).FB();
        this.uYu = ((s)paramk).FD();
        if (this.uYo == null)
        {
          this.uYo = new j(this, this.uYq);
          this.uYo.bRa();
        }
        if (this.uYm != null) {
          break label828;
        }
        View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(R.i.dml, null);
        this.uYl = ((ProgressBar)localView.findViewById(R.h.cth));
        TextView localTextView = (TextView)localView.findViewById(R.h.cLr);
        this.uYm = g.a(this, false, getString(R.l.dNH), localView, "", "", null, null);
        localTextView.setText(this.countryCode + " " + this.uXS.getText().toString());
      }
    }
    for (;;)
    {
      this.progress = 0;
      this.uYl.setIndeterminate(false);
      this.uYn.sendEmptyMessage(10);
      if (!com.tencent.mm.plugin.c.a.imc.a(this, paramInt1, paramInt2, paramString)) {
        break;
      }
      GMTrace.o(2701802864640L, 20130);
      return;
      label828:
      this.uYm.show();
    }
    label838:
    if (paramInt2 == -41)
    {
      g.h(this, R.l.eJB, R.l.eJC);
      GMTrace.o(2701802864640L, 20130);
      return;
    }
    if (paramInt2 == -34)
    {
      g.b(this, getString(R.l.dNq), "", true);
      GMTrace.o(2701802864640L, 20130);
      return;
    }
    if (com.tencent.mm.plugin.c.a.imc.a(this, paramInt1, paramInt2, paramString))
    {
      GMTrace.o(2701802864640L, 20130);
      return;
    }
    Toast.makeText(this, getString(R.l.dNW, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    GMTrace.o(2701802864640L, 20130);
    return;
    if (paramk.getType() == 701)
    {
      paramString = com.tencent.mm.f.a.dn(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        GMTrace.o(2701802864640L, 20130);
        return;
      }
    }
    GMTrace.o(2701802864640L, 20130);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2700729122816L, 20122);
    int i = R.i.dmn;
    GMTrace.o(2700729122816L, 20122);
    return i;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(2701668646912L, 20129);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt2)
    {
    default: 
      paramIntent = com.tencent.mm.plugin.c.a.imc.a(this, paramInt1, paramInt2, paramIntent);
      if (paramIntent != null)
      {
        this.ipb.setImageBitmap(paramIntent);
        this.uYd = true;
        this.uYe.setVisibility(8);
      }
      GMTrace.o(2701668646912L, 20129);
      return;
    }
    this.hJn = com.tencent.mm.sdk.platformtools.bf.ap(paramIntent.getStringExtra("country_name"), "");
    this.countryCode = com.tencent.mm.sdk.platformtools.bf.ap(paramIntent.getStringExtra("couttry_code"), "");
    bQM();
    GMTrace.o(2701668646912L, 20129);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2700863340544L, 20123);
    super.onCreate(paramBundle);
    this.hJn = com.tencent.mm.sdk.platformtools.bf.ap(getIntent().getStringExtra("country_name"), "");
    this.countryCode = com.tencent.mm.sdk.platformtools.bf.ap(getIntent().getStringExtra("couttry_code"), "");
    this.uXU = com.tencent.mm.sdk.platformtools.bf.ap(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.iQr = getIntent().getIntExtra("login_type", 0);
    this.oTI = com.tencent.mm.plugin.c.b.OA();
    com.tencent.mm.u.bf.zK();
    com.tencent.mm.plugin.c.b.hh(20);
    KD();
    GMTrace.o(2700863340544L, 20123);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(2701937082368L, 20131);
    if (this.uYo != null)
    {
      this.uYo.bRb();
      this.uYo = null;
    }
    if (this.uYm != null) {
      this.uYm.dismiss();
    }
    super.onDestroy();
    GMTrace.o(2701937082368L, 20131);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2701400211456L, 20127);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aXL();
      GMTrace.o(2701400211456L, 20127);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2701400211456L, 20127);
    return bool;
  }
  
  public void onPause()
  {
    GMTrace.i(2701131776000L, 20125);
    super.onPause();
    com.tencent.mm.sdk.b.a.uql.c(this.uVQ);
    ap.vd().b(701, this);
    ap.vd().b(145, this);
    ap.vd().b(132, this);
    com.tencent.mm.plugin.c.b.mM("RE200_100");
    GMTrace.o(2701131776000L, 20125);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    GMTrace.i(2702473953280L, 20135);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      if (paramArrayOfInt == null) {}
      for (int i = -1;; i = paramArrayOfInt.length)
      {
        v.w("MicroMsg.RegByMobileRegAIOUI", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, com.tencent.mm.sdk.platformtools.bf.bJP() });
        GMTrace.o(2702473953280L, 20135);
        return;
      }
    }
    v.i("MicroMsg.RegByMobileRegAIOUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(2702473953280L, 20135);
      return;
      if ((paramArrayOfInt[0] == 0) && (this.uYo != null)) {
        this.uYo.bRc();
      }
    }
  }
  
  public void onResume()
  {
    GMTrace.i(2700997558272L, 20124);
    com.tencent.mm.sdk.b.a.uql.b(this.uVQ);
    super.onResume();
    ap.vd().a(701, this);
    ap.vd().a(145, this);
    ap.vd().a(132, this);
    com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",RE200_100," + ap.ec("RE200_100") + ",1");
    aHc();
    this.uYg = 0;
    GMTrace.o(2700997558272L, 20124);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/RegByMobileRegAIOUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */