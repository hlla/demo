package com.tencent.mm.ui.account.mobile;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.e.a.il;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.MMKeyboardUperView;
import com.tencent.mm.ui.account.ResizeLayout;
import com.tencent.mm.ui.account.ResizeLayout.a;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.e.a;

public class MobileInputUI
  extends MMActivity
{
  protected String countryCode;
  protected String hJn;
  protected int hlV;
  protected EditText lhX;
  protected int[] niS;
  protected String oTI;
  protected String ory;
  protected TextView qTr;
  private com.tencent.mm.sdk.b.c uVQ;
  private ResizeLayout uWB;
  protected p uWW;
  protected CheckBox uXJ;
  protected LinearLayout uXQ;
  protected TextView uXR;
  protected String uXU;
  protected boolean uXV;
  protected TextView uXZ;
  protected MMFormInputView uXr;
  private MMKeyboardUperView uXu;
  protected boolean uXv;
  protected Button uYa;
  protected Button uYb;
  protected TextView vbA;
  protected Button vbB;
  protected String vbC;
  private int vbD;
  private b vbE;
  protected MMFormInputView vbv;
  protected EditText vbw;
  protected MMFormVerifyCodeInputView vbx;
  protected View vby;
  protected TextView vbz;
  
  public MobileInputUI()
  {
    GMTrace.i(2592818069504L, 19318);
    this.uXV = true;
    this.vbC = null;
    this.ory = null;
    this.uXU = null;
    this.hJn = null;
    this.countryCode = null;
    this.vbD = 0;
    this.niS = new int[5];
    this.uXv = false;
    this.uVQ = new com.tencent.mm.sdk.b.c() {};
    GMTrace.o(2592818069504L, 19318);
  }
  
  private void bQM()
  {
    GMTrace.i(16811173085184L, 125253);
    if ((!bf.mA(this.hJn)) && (!bf.mA(this.countryCode)))
    {
      this.uXR.setText(am.ez(this.hJn, this.countryCode));
      GMTrace.o(16811173085184L, 125253);
      return;
    }
    this.uXR.setText(getString(R.l.eAP));
    GMTrace.o(16811173085184L, 125253);
  }
  
  private boolean bRg()
  {
    GMTrace.i(2593623375872L, 19324);
    if (this.vbD == 2)
    {
      GMTrace.o(2593623375872L, 19324);
      return true;
    }
    GMTrace.o(2593623375872L, 19324);
    return false;
  }
  
  private void bRh()
  {
    GMTrace.i(2593891811328L, 19326);
    aGY();
    this.vbE.zy(a.vbI);
    GMTrace.o(2593891811328L, 19326);
  }
  
  private void goBack()
  {
    GMTrace.i(2594026029056L, 19327);
    this.vbE.zy(a.vbH);
    com.tencent.mm.plugin.c.b.mN(this.oTI);
    aGY();
    finish();
    GMTrace.o(2594026029056L, 19327);
  }
  
  protected final void KD()
  {
    GMTrace.i(2593757593600L, 19325);
    this.uXr = ((MMFormInputView)findViewById(R.h.cCC));
    this.lhX = this.uXr.oAr;
    com.tencent.mm.ui.tools.a.c.d(this.lhX).Cc(16).a(null);
    this.vbv = ((MMFormInputView)findViewById(R.h.cky));
    this.vbv.setInputType(3);
    this.vbw = this.vbv.oAr;
    this.vbx = ((MMFormVerifyCodeInputView)findViewById(R.h.cFI));
    this.vbx.bRJ();
    this.uXQ = ((LinearLayout)findViewById(R.h.bGJ));
    this.uXR = ((TextView)findViewById(R.h.bGL));
    this.vby = findViewById(R.h.cxi);
    this.uXJ = ((CheckBox)findViewById(R.h.bnU));
    this.uXZ = ((TextView)findViewById(R.h.bnW));
    this.uYa = ((Button)findViewById(R.h.bnT));
    this.uYb = ((Button)findViewById(R.h.cnP));
    this.vbz = ((TextView)findViewById(R.h.cxA));
    this.vbA = ((TextView)findViewById(R.h.ccC));
    this.qTr = ((TextView)findViewById(R.h.ckx));
    this.vbB = ((Button)findViewById(R.h.ccv));
    this.uWB = ((ResizeLayout)findViewById(R.h.cyt));
    this.uXu = ((MMKeyboardUperView)findViewById(R.h.Ki));
    this.uXQ.setVisibility(8);
    this.uXr.setVisibility(8);
    this.vbx.setVisibility(8);
    this.vbv.setVisibility(8);
    this.vbz.setVisibility(8);
    this.vbA.setVisibility(8);
    this.uYb.setVisibility(8);
    this.vby.setVisibility(8);
    this.vbB.setVisibility(8);
    this.uXJ.setVisibility(8);
    this.uXJ.setChecked(true);
    this.uWB.uZT = new ResizeLayout.a()
    {
      public final void bQF()
      {
        GMTrace.i(16814931181568L, 125281);
        MobileInputUI.c(MobileInputUI.this).post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(16810904649728L, 125251);
            MobileInputUI.c(MobileInputUI.this).fullScroll(130);
            GMTrace.o(16810904649728L, 125251);
          }
        });
        GMTrace.o(16814931181568L, 125281);
      }
    };
    this.uXu.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(16816541794304L, 125293);
        MobileInputUI.this.aGY();
        GMTrace.o(16816541794304L, 125293);
        return false;
      }
    });
    this.vbw.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        GMTrace.i(16807683424256L, 125227);
        paramAnonymousEditable = MobileInputUI.this.vbv.getText().toString();
        if (MobileInputUI.a(MobileInputUI.this, paramAnonymousEditable))
        {
          MobileInputUI.this.uYb.setEnabled(true);
          GMTrace.o(16807683424256L, 125227);
          return;
        }
        MobileInputUI.this.uYb.setEnabled(false);
        GMTrace.o(16807683424256L, 125227);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(16807817641984L, 125228);
        GMTrace.o(16807817641984L, 125228);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(16807951859712L, 125229);
        GMTrace.o(16807951859712L, 125229);
      }
    });
    this.vbw.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        GMTrace.i(16815736487936L, 125287);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          boolean bool = MobileInputUI.d(MobileInputUI.this);
          GMTrace.o(16815736487936L, 125287);
          return bool;
        }
        GMTrace.o(16815736487936L, 125287);
        return false;
      }
    });
    this.vbw.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        GMTrace.i(16815602270208L, 125286);
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          boolean bool = MobileInputUI.d(MobileInputUI.this);
          GMTrace.o(16815602270208L, 125286);
          return bool;
        }
        GMTrace.o(16815602270208L, 125286);
        return false;
      }
    });
    this.uYb.setEnabled(false);
    this.uYb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(16808354512896L, 125232);
        MobileInputUI.e(MobileInputUI.this);
        GMTrace.o(16808354512896L, 125232);
      }
    });
    final Object localObject;
    if ((bf.mA(this.hJn)) || (bf.mA(this.countryCode)))
    {
      localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
      v.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + (String)localObject);
      if (!bf.mA((String)localObject)) {
        break label765;
      }
      v.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
    }
    for (;;)
    {
      if ((bf.mA(this.hJn)) || (bf.mA(this.countryCode)))
      {
        this.hJn = getString(R.l.eaI);
        this.countryCode = am.PB(getString(R.l.eaH));
      }
      bQM();
      if (bf.mA(this.uXU)) {
        this.vbw.setText(this.uXU);
      }
      this.uXQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16807549206528L, 125226);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", MobileInputUI.this.hJn);
          paramAnonymousView.putExtra("couttry_code", MobileInputUI.this.countryCode);
          com.tencent.mm.plugin.c.a.imb.b(paramAnonymousView, MobileInputUI.this);
          GMTrace.o(16807549206528L, 125226);
        }
      });
      localObject = new com.tencent.mm.ui.widget.e(this, com.tencent.mm.ui.widget.e.wsK, false);
      ((com.tencent.mm.ui.widget.e)localObject).qHD = new n.c()
      {
        public final void a(l paramAnonymousl)
        {
          GMTrace.i(16806743900160L, 125220);
          if (paramAnonymousl.size() == 0)
          {
            paramAnonymousl.e(1, MobileInputUI.this.getString(R.l.eIQ));
            paramAnonymousl.e(2, MobileInputUI.this.getString(R.l.ewH));
          }
          GMTrace.o(16806743900160L, 125220);
        }
      };
      ((com.tencent.mm.ui.widget.e)localObject).qHE = new n.d()
      {
        public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          GMTrace.i(16812783697920L, 125265);
          switch (paramAnonymousMenuItem.getItemId())
          {
          default: 
            GMTrace.o(16812783697920L, 125265);
            return;
          case 1: 
            paramAnonymousMenuItem = MobileInputUI.this.getString(R.l.ewG) + u.bID();
            MobileInputUI.bg(MobileInputUI.this, paramAnonymousMenuItem);
            GMTrace.o(16812783697920L, 125265);
            return;
          }
          paramAnonymousMenuItem = MobileInputUI.this.getString(R.l.fmV);
          if (u.bID().equals("zh_CN")) {}
          for (paramAnonymousMenuItem = paramAnonymousMenuItem + "zh_CN";; paramAnonymousMenuItem = "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=")
          {
            MobileInputUI.bg(MobileInputUI.this, paramAnonymousMenuItem);
            break;
          }
        }
      };
      ((com.tencent.mm.ui.widget.e)localObject).wsV = new e.a()
      {
        public final void onDismiss()
        {
          GMTrace.i(16814260092928L, 125276);
          localObject.bza();
          GMTrace.o(16814260092928L, 125276);
        }
      };
      qL("");
      cO().cP().setBackgroundDrawable(getResources().getDrawable(R.e.aVj));
      cO().cP().getCustomView().findViewById(R.h.divider).setVisibility(8);
      a(0, R.l.dUy, R.k.dsG, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(16806475464704L, 125218);
          MobileInputUI.this.aGY();
          localObject.byZ();
          GMTrace.o(16806475464704L, 125218);
          return true;
        }
      });
      GMTrace.o(2593757593600L, 19325);
      return;
      label765:
      localObject = com.tencent.mm.ai.b.g(this, (String)localObject, getString(R.l.bGH));
      if (localObject == null)
      {
        v.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
      else
      {
        this.countryCode = am.PB(((b.a)localObject).hJm);
        this.hJn = ((b.a)localObject).hJn;
      }
    }
  }
  
  public void finish()
  {
    GMTrace.i(16811038867456L, 125252);
    super.finish();
    if (this.vbD == 1) {
      overridePendingTransition(R.a.aQL, R.a.aQL);
    }
    g.oSF.i(14262, new Object[] { Integer.valueOf(this.niS[0]), Integer.valueOf(this.niS[1]), Integer.valueOf(this.niS[2]), Integer.valueOf(this.niS[3]), Integer.valueOf(this.niS[4]) });
    GMTrace.o(16811038867456L, 125252);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2592952287232L, 19319);
    int i = R.i.djn;
    GMTrace.o(2592952287232L, 19319);
    return i;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    GMTrace.i(2594294464512L, 19329);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt2)
    {
    }
    do
    {
      GMTrace.o(2594294464512L, 19329);
      return;
      this.hJn = bf.ap(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bf.ap(paramIntent.getStringExtra("couttry_code"), "");
      bQM();
      GMTrace.o(2594294464512L, 19329);
      return;
    } while ((paramInt1 != 1024) || (paramIntent == null));
    String str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
    paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
    boolean bool = bf.mA(str);
    if (bf.mA(str)) {}
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      v.d("MicroMsg.MobileInputUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != 65319) {
        break;
      }
      bRh();
      GMTrace.o(2594294464512L, 19329);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2593086504960L, 19320);
    super.onCreate(paramBundle);
    this.vbD = getIntent().getIntExtra("mobile_input_purpose", 0);
    this.hlV = getIntent().getIntExtra("mobile_auth_type", 0);
    a(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(16816407576576L, 125292);
        MobileInputUI.b(MobileInputUI.this);
        GMTrace.o(16816407576576L, 125292);
        return true;
      }
    }, R.k.dtO);
    switch (this.vbD)
    {
    case 0: 
    default: 
      v.e("MicroMsg.MobileInputUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.vbD) });
      finish();
      GMTrace.o(2593086504960L, 19320);
      return;
    case 1: 
      if (!bf.mA(getIntent().getStringExtra("auth_ticket"))) {
        this.vbE = new e();
      }
      break;
    }
    for (;;)
    {
      this.countryCode = am.PB(bf.ap(getIntent().getStringExtra("input_country_code"), ""));
      this.hJn = bf.ap(getIntent().getStringExtra("country_name"), "");
      this.uXU = bf.ap(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
      this.vbC = am.PC(this.countryCode);
      this.ory = bf.ap(getIntent().getStringExtra("input_mobile_number"), "");
      this.oTI = com.tencent.mm.plugin.c.b.OA();
      KD();
      this.uXv = getIntent().getBooleanExtra("from_deep_link", false);
      if ((this.uXv) && (!bf.mA(this.vbC)) && (!bf.mA(this.ory))) {
        this.vbv.setText(this.ory);
      }
      this.vbE.a(this);
      GMTrace.o(2593086504960L, 19320);
      return;
      paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
      if (paramBundle != null) {
        this.niS = paramBundle;
      }
      this.vbE = new c();
      a(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(16813186351104L, 125268);
          MobileInputUI.b(MobileInputUI.this);
          GMTrace.o(16813186351104L, 125268);
          return true;
        }
      }, R.k.dsF);
      overridePendingTransition(R.a.aQL, R.a.aQL);
      continue;
      this.vbE = new d();
      continue;
      this.vbE = new b();
      continue;
      this.vbE = new d();
      continue;
      this.vbE = new e();
    }
  }
  
  public void onDestroy()
  {
    GMTrace.i(2593489158144L, 19323);
    this.vbx.reset();
    super.onDestroy();
    GMTrace.o(2593489158144L, 19323);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2594160246784L, 19328);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      GMTrace.o(2594160246784L, 19328);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2594160246784L, 19328);
    return bool;
  }
  
  public void onPause()
  {
    GMTrace.i(2593354940416L, 19322);
    super.onPause();
    com.tencent.mm.sdk.b.a.uql.c(this.uVQ);
    this.vbE.stop();
    GMTrace.o(2593354940416L, 19322);
  }
  
  public void onResume()
  {
    GMTrace.i(2593220722688L, 19321);
    com.tencent.mm.sdk.b.a.uql.b(this.uVQ);
    super.onResume();
    this.vbE.start();
    aHc();
    GMTrace.o(2593220722688L, 19321);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    GMTrace.i(2594428682240L, 19330);
    GMTrace.o(2594428682240L, 19330);
  }
  
  protected static enum a
  {
    static
    {
      GMTrace.i(2627983114240L, 19580);
      vbH = 1;
      vbI = 2;
      vbJ = new int[] { vbH, vbI };
      GMTrace.o(2627983114240L, 19580);
    }
    
    public static int[] bRi()
    {
      GMTrace.i(2627848896512L, 19579);
      int[] arrayOfInt = (int[])vbJ.clone();
      GMTrace.o(2627848896512L, 19579);
      return arrayOfInt;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(MobileInputUI paramMobileInputUI);
    
    public abstract void start();
    
    public abstract void stop();
    
    public abstract void zy(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/mobile/MobileInputUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */