package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
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
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.il;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.e.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public class LoginUI
  extends MMActivity
  implements com.tencent.mm.y.e
{
  private TextWatcher acO;
  private String fGM;
  private String fWO;
  private ProgressDialog isb;
  private int nWv;
  private String oTE;
  private String oTI;
  private SecurityImage uSI;
  private com.tencent.mm.sdk.b.c uVQ;
  private ResizeLayout uWB;
  private com.tencent.mm.pluginsdk.j.a uWD;
  private f uWv;
  private String uWx;
  private String uWy;
  private MMClearEditText uXo;
  private MMClearEditText uXp;
  private MMFormInputView uXq;
  private MMFormInputView uXr;
  private Button uXs;
  private Button uXt;
  private MMKeyboardUperView uXu;
  private boolean uXv;
  
  public LoginUI()
  {
    GMTrace.i(2738712739840L, 20405);
    this.isb = null;
    this.fGM = null;
    this.uSI = null;
    this.uWv = new f();
    this.fWO = "";
    this.nWv = 0;
    this.acO = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        GMTrace.i(2710527016960L, 20195);
        LoginUI.a(LoginUI.this);
        GMTrace.o(2710527016960L, 20195);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(2710661234688L, 20196);
        GMTrace.o(2710661234688L, 20196);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(2710795452416L, 20197);
        GMTrace.o(2710795452416L, 20197);
      }
    };
    this.uXv = false;
    this.uVQ = new com.tencent.mm.sdk.b.c() {};
    GMTrace.o(2738712739840L, 20405);
  }
  
  private void Tn()
  {
    GMTrace.i(2740189134848L, 20416);
    this.uWv.hRY = this.uXo.getText().toString().trim();
    this.uWv.uXd = this.uXp.getText().toString();
    if (this.uWv.hRY.equals(""))
    {
      com.tencent.mm.ui.base.g.h(this, R.l.eZS, R.l.ewF);
      GMTrace.o(2740189134848L, 20416);
      return;
    }
    if (this.uWv.uXd.equals(""))
    {
      com.tencent.mm.ui.base.g.h(this, R.l.eZP, R.l.ewF);
      GMTrace.o(2740189134848L, 20416);
      return;
    }
    aGY();
    ap.vd().a(701, this);
    final com.tencent.mm.modelsimple.u localu = new com.tencent.mm.modelsimple.u(this.uWv.hRY, this.uWv.uXd, this.oTE, 2);
    ap.vd().a(localu, 0);
    getString(R.l.dIG);
    this.isb = com.tencent.mm.ui.base.g.a(this, getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(16826205470720L, 125365);
        ap.vd().c(localu);
        ap.vd().b(701, LoginUI.this);
        GMTrace.o(16826205470720L, 125365);
      }
    });
    GMTrace.o(2740189134848L, 20416);
  }
  
  private void goBack()
  {
    GMTrace.i(2739786481664L, 20413);
    aGY();
    com.tencent.mm.plugin.c.b.mN(this.oTI);
    com.tencent.mm.pluginsdk.model.app.p.bCW();
    finish();
    GMTrace.o(2739786481664L, 20413);
  }
  
  private boolean p(int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(2739920699392L, 20414);
    if (com.tencent.mm.plugin.c.a.imc.a(this.uRf.uRz, paramInt1, paramInt2, paramString))
    {
      GMTrace.o(2739920699392L, 20414);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      paramString = new com.tencent.mm.pluginsdk.j.p(paramInt1, paramInt2, paramString);
      boolean bool = this.uWD.a(this, paramString);
      GMTrace.o(2739920699392L, 20414);
      return bool;
    case -1: 
      if (ap.vd().BR() == 5)
      {
        com.tencent.mm.ui.base.g.h(this, R.l.eDh, R.l.eDg);
        GMTrace.o(2739920699392L, 20414);
        return true;
      }
      GMTrace.o(2739920699392L, 20414);
      return false;
    case -4: 
    case -3: 
      com.tencent.mm.ui.base.g.h(this, R.l.eeU, R.l.ewF);
      GMTrace.o(2739920699392L, 20414);
      return true;
    case -9: 
      com.tencent.mm.ui.base.g.h(this, R.l.ewE, R.l.ewF);
      GMTrace.o(2739920699392L, 20414);
      return true;
    case -72: 
      com.tencent.mm.ui.base.g.h(this.uRf.uRz, R.l.eJR, R.l.dIG);
      GMTrace.o(2739920699392L, 20414);
      return true;
    case -75: 
      m.bo(this.uRf.uRz);
      GMTrace.o(2739920699392L, 20414);
      return true;
    case -311: 
    case -310: 
    case -6: 
      ap.vd().a(701, this);
      if (this.uSI == null) {
        this.uSI = SecurityImage.a.a(this, R.l.eJY, this.uWv.uXi, this.uWv.uXh, this.uWv.uXf, this.uWv.uXg, new DialogInterface.OnClickListener()
        {
          public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(16826473906176L, 125367);
            if (LoginUI.g(LoginUI.this) == null)
            {
              v.e("MicroMsg.LoginUI", "secimg is null!");
              GMTrace.o(16826473906176L, 125367);
              return;
            }
            v.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.h(LoginUI.this).uXf + " img len" + LoginUI.h(LoginUI.this).uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
            paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.u(LoginUI.h(LoginUI.this).hRY, LoginUI.h(LoginUI.this).uXd, LoginUI.h(LoginUI.this).uXi, LoginUI.g(LoginUI.this).bRp(), LoginUI.g(LoginUI.this).uXf, LoginUI.g(LoginUI.this).uXg, 2, "", false, false);
            ap.vd().a(paramAnonymousDialogInterface, 0);
            LoginUI localLoginUI1 = LoginUI.this;
            LoginUI localLoginUI2 = LoginUI.this;
            LoginUI.this.getString(R.l.dIG);
            LoginUI.a(localLoginUI1, com.tencent.mm.ui.base.g.a(localLoginUI2, LoginUI.this.getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                GMTrace.i(2637915226112L, 19654);
                ap.vd().c(paramAnonymousDialogInterface);
                ap.vd().b(701, LoginUI.this);
                GMTrace.o(2637915226112L, 19654);
              }
            }));
            GMTrace.o(16826473906176L, 125367);
          }
        }, null, new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(16823923769344L, 125348);
            LoginUI.i(LoginUI.this);
            GMTrace.o(16823923769344L, 125348);
          }
        }, this.uWv);
      }
      for (;;)
      {
        GMTrace.o(2739920699392L, 20414);
        return true;
        v.d("MicroMsg.LoginUI", "imgSid:" + this.uWv.uXf + " img len" + this.uWv.uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
        this.uSI.a(this.uWv.uXi, this.uWv.uXh, this.uWv.uXf, this.uWv.uXg);
      }
    case -100: 
      ap.hold();
      ActionBarActivity localActionBarActivity = this.uRf.uRz;
      if (TextUtils.isEmpty(ap.uI())) {}
      for (paramString = com.tencent.mm.bg.a.V(this.uRf.uRz, R.l.eza);; paramString = ap.uI())
      {
        com.tencent.mm.ui.base.g.a(localActionBarActivity, paramString, this.uRf.uRz.getString(R.l.dIG), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(16842714251264L, 125488);
            LoginUI.j(LoginUI.this);
            GMTrace.o(16842714251264L, 125488);
          }
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(16820434108416L, 125322);
            LoginUI.j(LoginUI.this);
            GMTrace.o(16820434108416L, 125322);
          }
        });
        GMTrace.o(2739920699392L, 20414);
        return true;
      }
    case -205: 
      v.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bf.Qi(this.oTE), this.uWy });
      f.a(this.uWv);
      com.tencent.mm.plugin.c.b.mN("L600_100");
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.oTE);
      paramString.putExtra("binded_mobile", this.uWx);
      paramString.putExtra("close_safe_device_style", this.uWy);
      paramString.putExtra("from_source", 1);
      com.tencent.mm.plugin.c.a.imb.f(this, paramString);
      GMTrace.o(2739920699392L, 20414);
      return true;
    }
    if (!bf.mA(this.fWO)) {
      m.j(this, paramString, this.fWO);
    }
    GMTrace.o(2739920699392L, 20414);
    return true;
  }
  
  protected final void KD()
  {
    GMTrace.i(2739518046208L, 20411);
    this.uXq = ((MMFormInputView)findViewById(R.h.cct));
    this.uXr = ((MMFormInputView)findViewById(R.h.ccy));
    this.uXo = ((MMClearEditText)this.uXq.oAr);
    this.uXo.setFocusableInTouchMode(false);
    this.uXo.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(16834124316672L, 125424);
        LoginUI.b(LoginUI.this).setFocusableInTouchMode(true);
        boolean bool = LoginUI.b(LoginUI.this).rku.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
        GMTrace.o(16834124316672L, 125424);
        return bool;
      }
    });
    this.uXp = ((MMClearEditText)this.uXr.oAr);
    this.uXp.setFocusableInTouchMode(false);
    this.uXp.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(16820031455232L, 125319);
        LoginUI.c(LoginUI.this).setFocusableInTouchMode(true);
        LoginUI.b(LoginUI.this).setFocusableInTouchMode(false);
        boolean bool = LoginUI.c(LoginUI.this).rku.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
        GMTrace.o(16820031455232L, 125319);
        return bool;
      }
    });
    com.tencent.mm.ui.tools.a.c.d(this.uXp).Cc(16).a(null);
    this.uXs = ((Button)findViewById(R.h.ccu));
    this.uXs.setEnabled(false);
    this.uXt = ((Button)findViewById(R.h.ccv));
    this.uWB = ((ResizeLayout)findViewById(R.h.cyt));
    this.uXu = ((MMKeyboardUperView)findViewById(R.h.Ki));
    this.uWB.uZT = new ResizeLayout.a()
    {
      public final void bQF()
      {
        GMTrace.i(16827144994816L, 125372);
        LoginUI.d(LoginUI.this).post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(16817481318400L, 125300);
            LoginUI.d(LoginUI.this).fullScroll(130);
            GMTrace.o(16817481318400L, 125300);
          }
        });
        GMTrace.o(16827144994816L, 125372);
      }
    };
    this.uXu.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(16805133287424L, 125208);
        LoginUI.this.aGY();
        GMTrace.o(16805133287424L, 125208);
        return false;
      }
    });
    boolean bool = com.tencent.mm.ai.b.Hn();
    final Object localObject = findViewById(R.h.bPf);
    if (!bool) {}
    for (int i = 8;; i = 0)
    {
      ((View)localObject).setVisibility(i);
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16827681865728L, 125376);
          LoginUI.this.startActivity(new Intent(LoginUI.this, FacebookLoginUI.class));
          GMTrace.o(16827681865728L, 125376);
        }
      });
      localObject = new com.tencent.mm.ui.widget.e(this, com.tencent.mm.ui.widget.e.wsK, false);
      ((com.tencent.mm.ui.widget.e)localObject).qHD = new n.c()
      {
        public final void a(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          GMTrace.i(16838285066240L, 125455);
          if (paramAnonymousl.size() == 0)
          {
            paramAnonymousl.e(1, LoginUI.this.getString(R.l.eIQ));
            paramAnonymousl.e(2, LoginUI.this.getString(R.l.ewH));
          }
          GMTrace.o(16838285066240L, 125455);
        }
      };
      ((com.tencent.mm.ui.widget.e)localObject).qHE = new n.d()
      {
        public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          GMTrace.i(16836808671232L, 125444);
          switch (paramAnonymousMenuItem.getItemId())
          {
          default: 
            GMTrace.o(16836808671232L, 125444);
            return;
          case 1: 
            ActionBarActivity localActionBarActivity = LoginUI.this.uRf.uRz;
            String str = bf.em(localActionBarActivity) + "_" + System.currentTimeMillis();
            v.d("MicroMsg.ForgotPwdMenu", "cpan showProblemH5 randomID:%s", new Object[] { str });
            paramAnonymousMenuItem = localActionBarActivity.getString(R.l.ewD);
            if (com.tencent.mm.sdk.platformtools.u.bID().equals("zh_CN")) {
              paramAnonymousMenuItem = paramAnonymousMenuItem + "zh_CN";
            }
            for (;;)
            {
              e.i(localActionBarActivity, paramAnonymousMenuItem + "&rid=" + str, false);
              com.tencent.mm.plugin.report.service.g.oSF.i(11930, new Object[] { str, Integer.valueOf(3) });
              aa.getContext().getSharedPreferences("randomid_prefs", 4).edit().putString("randomID", str).commit();
              GMTrace.o(16836808671232L, 125444);
              return;
              if ((com.tencent.mm.sdk.platformtools.u.bID().equals("zh_TW")) || (com.tencent.mm.sdk.platformtools.u.bID().equals("zh_HK"))) {
                paramAnonymousMenuItem = paramAnonymousMenuItem + "zh_TW";
              } else {
                paramAnonymousMenuItem = paramAnonymousMenuItem + "en";
              }
            }
          }
          paramAnonymousMenuItem = LoginUI.this.getString(R.l.fmV);
          if (com.tencent.mm.sdk.platformtools.u.bID().equals("zh_CN")) {}
          for (paramAnonymousMenuItem = paramAnonymousMenuItem + "zh_CN";; paramAnonymousMenuItem = "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=")
          {
            LoginUI.bf(LoginUI.this, paramAnonymousMenuItem);
            break;
          }
        }
      };
      ((com.tencent.mm.ui.widget.e)localObject).wsV = new e.a()
      {
        public final void onDismiss()
        {
          GMTrace.i(16823386898432L, 125344);
          localObject.bza();
          GMTrace.o(16823386898432L, 125344);
        }
      };
      qL("");
      cO().cP().setBackgroundDrawable(getResources().getDrawable(R.e.aVj));
      cO().cP().getCustomView().findViewById(R.h.divider).setVisibility(8);
      a(0, R.l.dUy, R.k.dsG, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(16822984245248L, 125341);
          LoginUI.this.aGY();
          localObject.byZ();
          GMTrace.o(16822984245248L, 125341);
          return true;
        }
      });
      a(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(16847009218560L, 125520);
          LoginUI.e(LoginUI.this);
          GMTrace.o(16847009218560L, 125520);
          return true;
        }
      }, R.k.dsF);
      this.uXs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16838956154880L, 125460);
          LoginUI.f(LoginUI.this);
          GMTrace.o(16838956154880L, 125460);
        }
      });
      this.uXt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16805401722880L, 125210);
          paramAnonymousView = new Intent(LoginUI.this, MobileInputUI.class);
          int[] arrayOfInt = new int[5];
          arrayOfInt[0] = 2;
          paramAnonymousView.putExtra("mobile_input_purpose", 1);
          paramAnonymousView.putExtra("kv_report_login_method_data", arrayOfInt);
          LoginUI.this.startActivity(paramAnonymousView);
          LoginUI.this.finish();
          GMTrace.o(16805401722880L, 125210);
        }
      });
      this.oTE = getIntent().getStringExtra("auth_ticket");
      if (!bf.mA(this.oTE))
      {
        this.uXo.setText(bf.mz(f.bQG()));
        this.uXp.setText(bf.mz(f.bQH()));
        new ad().postDelayed(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2660061151232L, 19819);
            LoginUI.f(LoginUI.this);
            GMTrace.o(2660061151232L, 19819);
          }
        }, 500L);
      }
      this.uXo.addTextChangedListener(this.acO);
      this.uXp.addTextChangedListener(this.acO);
      this.uXp.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          GMTrace.i(16845398605824L, 125508);
          if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
          {
            LoginUI.f(LoginUI.this);
            GMTrace.o(16845398605824L, 125508);
            return true;
          }
          GMTrace.o(16845398605824L, 125508);
          return false;
        }
      });
      this.uXp.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          GMTrace.i(16820165672960L, 125320);
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            LoginUI.f(LoginUI.this);
            GMTrace.o(16820165672960L, 125320);
            return true;
          }
          GMTrace.o(16820165672960L, 125320);
          return false;
        }
      });
      if (com.tencent.mm.sdk.platformtools.f.uqI) {
        com.tencent.mm.plugin.c.a.imc.d(this);
      }
      localObject = getIntent().getStringExtra("login_username");
      this.uXv = getIntent().getBooleanExtra("from_deep_link", false);
      if (!bf.mA((String)localObject)) {
        this.uXo.setText((CharSequence)localObject);
      }
      GMTrace.o(2739518046208L, 20411);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, final k paramk)
  {
    GMTrace.i(2740054917120L, 20415);
    v.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.isb != null)
    {
      this.isb.dismiss();
      this.isb = null;
    }
    if (paramk.getType() != 701)
    {
      GMTrace.o(2740054917120L, 20415);
      return;
    }
    ap.vd().b(701, this);
    this.fWO = ((com.tencent.mm.modelsimple.u)paramk).Ji();
    this.uWv.uXf = ((com.tencent.mm.modelsimple.u)paramk).FK();
    this.uWv.uXh = ((com.tencent.mm.modelsimple.u)paramk).FJ();
    this.uWv.uXg = ((com.tencent.mm.modelsimple.u)paramk).Jk();
    this.uWv.uXi = ((com.tencent.mm.modelsimple.u)paramk).Jj();
    if (paramInt2 == 65331)
    {
      this.oTE = ((com.tencent.mm.modelsimple.u)paramk).Fw();
      this.uWx = ((com.tencent.mm.modelsimple.u)paramk).Jl();
      this.uWy = ((com.tencent.mm.modelsimple.u)paramk).Jo();
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      ap.vd().a(new bb(new bb.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          GMTrace.i(16843251122176L, 125492);
          if (paramAnonymouse == null)
          {
            GMTrace.o(16843251122176L, 125492);
            return;
          }
          paramAnonymouse = paramAnonymouse.Cc();
          ap.yY();
          int i = com.tencent.mm.u.c.uH();
          paramAnonymouse.i(new byte[0], i);
          GMTrace.o(16843251122176L, 125492);
        }
      }), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        ap.unhold();
        m.mv(this.uWv.hRY);
        com.tencent.mm.modelsimple.d.bc(this);
        m.a(this, new Runnable()
        {
          public final void run()
          {
            GMTrace.i(16848082960384L, 125528);
            v.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
            Intent localIntent = com.tencent.mm.plugin.c.a.imb.ak(LoginUI.this);
            localIntent.addFlags(67108864);
            localIntent.putExtra("kstyle_show_bind_mobile_afterauth", ((com.tencent.mm.modelsimple.u)paramk).Jm());
            localIntent.putExtra("kstyle_bind_wording", ((com.tencent.mm.modelsimple.u)paramk).Jn());
            localIntent.putExtra("kstyle_bind_recommend_show", ((com.tencent.mm.modelsimple.u)paramk).Jp());
            LoginUI.this.startActivity(localIntent);
            LoginUI.this.finish();
            GMTrace.o(16848082960384L, 125528);
          }
        }, false, 2);
        com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
        if (this.uXv)
        {
          paramString = aa.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", "");
          com.tencent.mm.plugin.report.service.g.oSF.i(11930, new Object[] { paramString, Integer.valueOf(4) });
        }
        GMTrace.o(2740054917120L, 20415);
        return;
      }
      if (paramInt2 == -106)
      {
        m.E(this, paramString);
        GMTrace.o(2740054917120L, 20415);
        return;
      }
      if (paramInt2 == 65319)
      {
        m.a(this, com.tencent.mm.pluginsdk.a.a.a((com.tencent.mm.modelsimple.u)paramk), paramInt2);
        GMTrace.o(2740054917120L, 20415);
        return;
      }
      if (paramInt2 == -30)
      {
        if (com.tencent.mm.protocal.d.sXk)
        {
          paramString = new Intent();
          paramString.putExtra("rawUrl", this.fWO);
          paramString.putExtra("showShare", false);
          paramString.putExtra("show_bottom", false);
          paramString.putExtra("needRedirect", false);
          paramString.putExtra("neverGetA8Key", true);
          paramString.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
          paramString.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
          com.tencent.mm.plugin.c.a.imb.j(paramString, this);
          GMTrace.o(2740054917120L, 20415);
          return;
        }
        com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R400_100_login," + ap.ec("R400_100_login") + ",1");
        com.tencent.mm.ui.base.g.a(this, getString(R.l.ewU), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(16846069694464L, 125513);
            com.tencent.mm.plugin.c.b.mN("R400_100_login");
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("regsetinfo_binduin", LoginUI.h(LoginUI.this).hRY);
            paramAnonymousDialogInterface.putExtra("regsetinfo_pwd", LoginUI.h(LoginUI.this).uXd);
            paramAnonymousDialogInterface.putExtra("regsetinfo_ismobile", 0);
            paramAnonymousDialogInterface.putExtra("regsetinfo_ticket", LoginUI.k(LoginUI.this));
            paramAnonymousDialogInterface.putExtra("regsetinfo_NextControl", ((com.tencent.mm.modelsimple.u)paramk).Fy());
            paramAnonymousDialogInterface.setClass(LoginUI.this, RegSetInfoUI.class);
            LoginUI.this.uRf.uRz.startActivity(paramAnonymousDialogInterface);
            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + LoginUI.this.getClass().getName() + ",R400_100_login," + ap.ec("R400_100_login") + ",2");
            GMTrace.o(16846069694464L, 125513);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(16848485613568L, 125531);
            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + LoginUI.this.getClass().getName() + ",R400_100_login," + ap.ec("R400_100_login") + ",2");
            GMTrace.o(16848485613568L, 125531);
          }
        });
        GMTrace.o(2740054917120L, 20415);
        return;
      }
      if (p(paramInt1, paramInt2, paramString))
      {
        GMTrace.o(2740054917120L, 20415);
        return;
      }
      if (paramInt2 == -5)
      {
        Toast.makeText(this, getString(R.l.ewQ), 0).show();
        GMTrace.o(2740054917120L, 20415);
        return;
      }
      if (paramk.getType() == 701)
      {
        paramString = com.tencent.mm.f.a.dn(paramString);
        if ((paramString != null) && (paramString.a(this, null, null)))
        {
          GMTrace.o(2740054917120L, 20415);
          return;
        }
      }
      Toast.makeText(this, getString(R.l.ekZ, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      GMTrace.o(2740054917120L, 20415);
      return;
    }
  }
  
  public void finish()
  {
    GMTrace.i(16835063840768L, 125431);
    super.finish();
    overridePendingTransition(R.a.aQL, R.a.aQL);
    GMTrace.o(16835063840768L, 125431);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2738846957568L, 20406);
    int i = R.i.dgJ;
    GMTrace.o(2738846957568L, 20406);
    return i;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    GMTrace.i(2740323352576L, 20417);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      v.d("MicroMsg.LoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label184;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bf.mA(str);
      if (!bf.mA(str)) {
        break label175;
      }
    }
    label175:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      v.d("MicroMsg.LoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != 65319) {
        break label184;
      }
      Tn();
      GMTrace.o(2740323352576L, 20417);
      return;
      bool = false;
      break;
    }
    label184:
    GMTrace.o(2740323352576L, 20417);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2738981175296L, 20407);
    super.onCreate(paramBundle);
    paramBundle = "";
    if (com.tencent.mm.protocal.d.sXk) {
      paramBundle = getString(R.l.bpC) + getString(R.l.dCT);
    }
    this.nWv = getIntent().getIntExtra("login_type", 0);
    qL(paramBundle);
    com.tencent.mm.plugin.c.a.imc.ox();
    this.oTI = com.tencent.mm.plugin.c.b.OA();
    KD();
    this.uWD = new com.tencent.mm.pluginsdk.j.a();
    paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
    if (paramBundle != null) {
      com.tencent.mm.plugin.report.service.g.oSF.i(14262, new Object[] { Integer.valueOf(paramBundle[0]), Integer.valueOf(paramBundle[1]), Integer.valueOf(paramBundle[2]), Integer.valueOf(paramBundle[3]), Integer.valueOf(paramBundle[4]) });
    }
    GMTrace.o(2738981175296L, 20407);
  }
  
  public void onDestroy()
  {
    GMTrace.i(2739383828480L, 20410);
    if (this.uWD != null) {
      this.uWD.close();
    }
    ap.vd().b(701, this);
    super.onDestroy();
    GMTrace.o(2739383828480L, 20410);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2739652263936L, 20412);
    if (paramInt == 4)
    {
      goBack();
      GMTrace.o(2739652263936L, 20412);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2739652263936L, 20412);
    return bool;
  }
  
  public void onPause()
  {
    GMTrace.i(2739249610752L, 20409);
    super.onPause();
    com.tencent.mm.sdk.b.a.uql.c(this.uVQ);
    if (this.nWv == 0)
    {
      com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",L100_100_logout," + ap.ec("L100_100_logout") + ",2");
      GMTrace.o(2739249610752L, 20409);
      return;
    }
    if (this.nWv == 1) {
      com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",L400_100_login," + ap.ec("L400_100_login") + ",2");
    }
    GMTrace.o(2739249610752L, 20409);
  }
  
  public void onResume()
  {
    GMTrace.i(2739115393024L, 20408);
    com.tencent.mm.sdk.b.a.uql.b(this.uVQ);
    super.onResume();
    if (this.nWv == 0)
    {
      com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",L100_100_logout," + ap.ec("L100_100_logout") + ",1");
      com.tencent.mm.plugin.c.b.mM("L100_100_logout");
      GMTrace.o(2739115393024L, 20408);
      return;
    }
    if (this.nWv == 1)
    {
      com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",L400_100_login," + ap.ec("L400_100_login") + ",1");
      com.tencent.mm.plugin.c.b.mM("L400_100_login");
    }
    GMTrace.o(2739115393024L, 20408);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/LoginUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */