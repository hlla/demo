package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.il;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public class LoginIndepPass
  extends MMActivity
  implements com.tencent.mm.y.e
{
  private String fWO;
  private String hRY;
  private ProgressDialog isb;
  private String oTE;
  private String oTI;
  private SecurityImage uSI;
  private com.tencent.mm.sdk.b.c uVQ;
  private EditText uWT;
  private String uWU;
  private Button uWV;
  private p uWW;
  private f uWv;
  private String uWx;
  private String uWy;
  
  public LoginIndepPass()
  {
    GMTrace.i(2666637819904L, 19868);
    this.isb = null;
    this.uSI = null;
    this.uWv = new f();
    this.uVQ = new com.tencent.mm.sdk.b.c() {};
    GMTrace.o(2666637819904L, 19868);
  }
  
  private void Tn()
  {
    GMTrace.i(2667577344000L, 19875);
    final Object localObject = this.uWT.getText().toString();
    if (bf.mA(this.hRY))
    {
      com.tencent.mm.ui.base.g.h(this, R.l.eZS, R.l.ewF);
      GMTrace.o(2667577344000L, 19875);
      return;
    }
    if (((String)localObject).equals(""))
    {
      com.tencent.mm.ui.base.g.h(this, R.l.eZP, R.l.ewF);
      GMTrace.o(2667577344000L, 19875);
      return;
    }
    aGY();
    ap.vd().a(701, this);
    localObject = new u(this.hRY, (String)localObject, null, 1);
    ap.vd().a((k)localObject, 0);
    getString(R.l.dIG);
    this.isb = com.tencent.mm.ui.base.g.a(this, getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(2671201222656L, 19902);
        ap.vd().c(localObject);
        GMTrace.o(2671201222656L, 19902);
      }
    });
    GMTrace.o(2667577344000L, 19875);
  }
  
  private boolean p(int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(2667845779456L, 19877);
    if (com.tencent.mm.plugin.c.a.imc.a(this.uRf.uRz, paramInt1, paramInt2, paramString))
    {
      GMTrace.o(2667845779456L, 19877);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      GMTrace.o(2667845779456L, 19877);
      return false;
    case -1: 
      if (ap.vd().BR() == 5)
      {
        com.tencent.mm.ui.base.g.h(this, R.l.eDh, R.l.eDg);
        GMTrace.o(2667845779456L, 19877);
        return true;
      }
      GMTrace.o(2667845779456L, 19877);
      return false;
    case -4: 
    case -3: 
      com.tencent.mm.ui.base.g.h(this, R.l.eeU, R.l.ewF);
      GMTrace.o(2667845779456L, 19877);
      return true;
    case -9: 
      com.tencent.mm.ui.base.g.h(this, R.l.ewE, R.l.ewF);
      GMTrace.o(2667845779456L, 19877);
      return true;
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
            GMTrace.i(2753610907648L, 20516);
            GMTrace.o(2753610907648L, 20516);
          }
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(2660329586688L, 19821);
            GMTrace.o(2660329586688L, 19821);
          }
        });
        GMTrace.o(2667845779456L, 19877);
        return true;
      }
    }
    if (!bf.mA(this.fWO)) {
      m.j(this.uRf.uRz, paramString, this.fWO);
    }
    GMTrace.o(2667845779456L, 19877);
    return true;
  }
  
  protected final void KD()
  {
    GMTrace.i(2667443126272L, 19874);
    this.uWT = ((EditText)findViewById(R.h.bXq));
    this.uWV = ((Button)findViewById(R.h.ccB));
    ko(false);
    a(0, getString(R.l.ewK), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2712137629696L, 20207);
        LoginIndepPass.a(LoginIndepPass.this);
        GMTrace.o(2712137629696L, 20207);
        return true;
      }
    });
    this.uWT.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        GMTrace.i(2743544578048L, 20441);
        LoginIndepPass.b(LoginIndepPass.this);
        GMTrace.o(2743544578048L, 20441);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(2743678795776L, 20442);
        GMTrace.o(2743678795776L, 20442);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(2743813013504L, 20443);
        GMTrace.o(2743813013504L, 20443);
      }
    });
    this.uWT.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        GMTrace.i(2642747064320L, 19690);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          LoginIndepPass.a(LoginIndepPass.this);
          GMTrace.o(2642747064320L, 19690);
          return true;
        }
        GMTrace.o(2642747064320L, 19690);
        return false;
      }
    });
    this.uWT.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        GMTrace.i(2749987028992L, 20489);
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          LoginIndepPass.a(LoginIndepPass.this);
          GMTrace.o(2749987028992L, 20489);
          return true;
        }
        GMTrace.o(2749987028992L, 20489);
        return false;
      }
    });
    this.uWV.setText(getString(R.l.ewN));
    this.uWV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2652813393920L, 19765);
        com.tencent.mm.ui.base.g.a(LoginIndepPass.this, LoginIndepPass.this.getString(R.l.eJN) + LoginIndepPass.c(LoginIndepPass.this), LoginIndepPass.this.getString(R.l.eJO), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            GMTrace.i(2719116951552L, 20259);
            ap.vd().a(145, LoginIndepPass.this);
            paramAnonymous2DialogInterface = new s(LoginIndepPass.d(LoginIndepPass.this), 16, "", 0, "");
            ap.vd().a(paramAnonymous2DialogInterface, 0);
            LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
            LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
            LoginIndepPass.this.getString(R.l.dIG);
            LoginIndepPass.a(localLoginIndepPass1, com.tencent.mm.ui.base.g.a(localLoginIndepPass2, LoginIndepPass.this.getString(R.l.eSD), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
              {
                GMTrace.i(2732941377536L, 20362);
                ap.vd().c(paramAnonymous2DialogInterface);
                ap.vd().b(701, LoginIndepPass.this);
                GMTrace.o(2732941377536L, 20362);
              }
            }));
            GMTrace.o(2719116951552L, 20259);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            GMTrace.i(2760724447232L, 20569);
            GMTrace.o(2760724447232L, 20569);
          }
        });
        GMTrace.o(2652813393920L, 19765);
      }
    });
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2678583197696L, 19957);
        b.mN("L200_100");
        paramAnonymousMenuItem = new Intent(LoginIndepPass.this, MobileInputUI.class);
        paramAnonymousMenuItem.putExtra("mobile_input_purpose", 1);
        paramAnonymousMenuItem.addFlags(67108864);
        LoginIndepPass.this.startActivity(paramAnonymousMenuItem);
        LoginIndepPass.this.finish();
        GMTrace.o(2678583197696L, 19957);
        return true;
      }
    });
    this.oTE = getIntent().getStringExtra("auth_ticket");
    if (!bf.mA(this.oTE)) {
      new ad().postDelayed(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2783273025536L, 20737);
          LoginIndepPass.a(LoginIndepPass.this, f.bQG(), f.bQH());
          GMTrace.o(2783273025536L, 20737);
        }
      }, 500L);
    }
    GMTrace.o(2667443126272L, 19874);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2667711561728L, 19876);
    v.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.isb != null)
    {
      this.isb.dismiss();
      this.isb = null;
    }
    if (this.uWW != null)
    {
      this.uWW.dismiss();
      this.uWW = null;
    }
    if (paramk.getType() == 701)
    {
      this.fWO = ((u)paramk).Ji();
      ap.vd().b(701, this);
      this.uWv.uXf = ((u)paramk).FK();
      this.uWv.uXh = ((u)paramk).FJ();
      this.uWv.uXg = ((u)paramk).Jk();
      this.uWv.uXi = ((u)paramk).Jj();
      this.uWv.hRY = this.hRY;
      this.uWv.uXd = this.uWT.getText().toString();
      int j = 0;
      if (paramInt2 == -75)
      {
        m.bo(this.uRf.uRz);
        GMTrace.o(2667711561728L, 19876);
        return;
      }
      if (paramInt2 == -106)
      {
        m.E(this, paramString);
        GMTrace.o(2667711561728L, 19876);
        return;
      }
      if (paramInt2 == 65319)
      {
        m.a(this, com.tencent.mm.pluginsdk.a.a.a((u)paramk), paramInt2);
        GMTrace.o(2667711561728L, 19876);
        return;
      }
      if (paramInt2 == 65331)
      {
        this.oTE = ((u)paramk).Fw();
        this.uWx = ((u)paramk).Jl();
        this.uWy = ((u)paramk).Jo();
        v.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bf.Qi(this.oTE), this.uWy });
        f.a(this.uWv);
        paramString = new Intent();
        paramString.putExtra("auth_ticket", this.oTE);
        paramString.putExtra("binded_mobile", this.uWx);
        paramString.putExtra("close_safe_device_style", this.uWy);
        paramString.putExtra("from_source", 5);
        com.tencent.mm.plugin.c.a.imb.f(this, paramString);
        GMTrace.o(2667711561728L, 19876);
        return;
      }
      if (paramInt2 == 65396)
      {
        if (!bf.mA(this.fWO)) {
          m.j(this, paramString, this.fWO);
        }
        GMTrace.o(2667711561728L, 19876);
        return;
      }
      int i = j;
      if (paramInt1 == 4) {
        if (paramInt2 != -16)
        {
          i = j;
          if (paramInt2 != -17) {}
        }
        else
        {
          i = 1;
          ap.vd().a(new bb(new bb.a()
          {
            public final void a(com.tencent.mm.network.e paramAnonymouse)
            {
              GMTrace.i(2733880901632L, 20369);
              if (paramAnonymouse == null)
              {
                GMTrace.o(2733880901632L, 20369);
                return;
              }
              paramAnonymouse = paramAnonymouse.Cc();
              ap.yY();
              int i = com.tencent.mm.u.c.uH();
              paramAnonymouse.i(new byte[0], i);
              GMTrace.o(2733880901632L, 20369);
            }
          }), 0);
        }
      }
      if ((paramInt2 == -6) || (paramInt2 == 65225) || (paramInt2 == 65226))
      {
        ap.vd().a(701, this);
        if (this.uSI == null)
        {
          this.uSI = SecurityImage.a.a(this.uRf.uRz, R.l.eJY, this.uWv.uXi, this.uWv.uXh, this.uWv.uXf, this.uWv.uXg, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(2679925374976L, 19967);
              v.d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.e(LoginIndepPass.this).uXf + " img len" + LoginIndepPass.e(LoginIndepPass.this).uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
              paramAnonymousDialogInterface = new u(LoginIndepPass.e(LoginIndepPass.this).hRY, LoginIndepPass.e(LoginIndepPass.this).uXd, LoginIndepPass.e(LoginIndepPass.this).uXi, LoginIndepPass.f(LoginIndepPass.this).bRp(), LoginIndepPass.f(LoginIndepPass.this).uXf, LoginIndepPass.f(LoginIndepPass.this).uXg, 1, "", false, false);
              ap.vd().a(paramAnonymousDialogInterface, 0);
              LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
              LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
              LoginIndepPass.this.getString(R.l.dIG);
              LoginIndepPass.a(localLoginIndepPass1, com.tencent.mm.ui.base.g.a(localLoginIndepPass2, LoginIndepPass.this.getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  GMTrace.i(2669590609920L, 19890);
                  ap.vd().c(paramAnonymousDialogInterface);
                  ap.vd().b(701, LoginIndepPass.this);
                  GMTrace.o(2669590609920L, 19890);
                }
              }));
              GMTrace.o(2679925374976L, 19967);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              GMTrace.i(2671469658112L, 19904);
              LoginIndepPass.g(LoginIndepPass.this);
              GMTrace.o(2671469658112L, 19904);
            }
          }, this.uWv);
          GMTrace.o(2667711561728L, 19876);
          return;
        }
        v.d("MicroMsg.LoginIndepPass", "imgSid:" + this.uWv.uXf + " img len" + this.uWv.uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
        this.uSI.a(this.uWv.uXi, this.uWv.uXh, this.uWv.uXf, this.uWv.uXg);
        GMTrace.o(2667711561728L, 19876);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        ap.unhold();
        m.mv(this.uWv.hRY);
        com.tencent.mm.modelsimple.d.bc(this);
        m.a(this, new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2711063887872L, 20199);
            v.d("MicroMsg.LoginIndepPass", "onSceneEnd, in runnable");
            Intent localIntent = com.tencent.mm.plugin.c.a.imb.ak(LoginIndepPass.this);
            localIntent.addFlags(67108864);
            LoginIndepPass.this.startActivity(localIntent);
            LoginIndepPass.this.finish();
            GMTrace.o(2711063887872L, 20199);
          }
        }, false, 2);
        GMTrace.o(2667711561728L, 19876);
        return;
      }
      if (p(paramInt1, paramInt2, paramString))
      {
        GMTrace.o(2667711561728L, 19876);
        return;
      }
      if (paramk.getType() == 701)
      {
        paramString = com.tencent.mm.f.a.dn(paramString);
        if ((paramString != null) && (paramString.a(this, null, null)))
        {
          GMTrace.o(2667711561728L, 19876);
          return;
        }
      }
      Toast.makeText(this, getString(R.l.ekZ, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      GMTrace.o(2667711561728L, 19876);
      return;
    }
    if (paramk.getType() == 145)
    {
      ap.vd().b(145, this);
      paramString = ((s)paramk).Fx();
      if (paramInt2 == -41)
      {
        com.tencent.mm.ui.base.g.h(this, R.l.eJB, R.l.eJC);
        GMTrace.o(2667711561728L, 19876);
        return;
      }
      if (paramInt2 == -75)
      {
        com.tencent.mm.ui.base.g.b(this, getString(R.l.dCV), "", true);
        GMTrace.o(2667711561728L, 19876);
        return;
      }
      b.mN("L3");
      b.b(true, ap.uY() + "," + getClass().getName() + ",L3," + ap.ec("L3") + ",1");
      Intent localIntent = new Intent();
      localIntent.putExtra("bindmcontact_mobile", this.uWU);
      localIntent.putExtra("bindmcontact_shortmobile", paramString);
      localIntent.putExtra("mobile_verify_purpose", 1);
      localIntent.putExtra("login_type", 3);
      localIntent.putExtra("mobileverify_countdownsec", ((s)paramk).Fz());
      localIntent.putExtra("mobileverify_countdownstyle", ((s)paramk).FA());
      localIntent.putExtra("mobileverify_fb", ((s)paramk).FB());
      a(MobileVerifyUI.class, localIntent);
      GMTrace.o(2667711561728L, 19876);
      return;
    }
    if (p(paramInt1, paramInt2, paramString))
    {
      GMTrace.o(2667711561728L, 19876);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this, getString(R.l.ekZ, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    GMTrace.o(2667711561728L, 19876);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2666772037632L, 19869);
    int i = R.i.dgL;
    GMTrace.o(2666772037632L, 19869);
    return i;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    GMTrace.i(2667979997184L, 19878);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      v.d("MicroMsg.LoginIndepPass", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
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
      v.d("MicroMsg.LoginIndepPass", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != 65319) {
        break label184;
      }
      Tn();
      GMTrace.o(2667979997184L, 19878);
      return;
      bool = false;
      break;
    }
    label184:
    GMTrace.o(2667979997184L, 19878);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2666906255360L, 19870);
    super.onCreate(paramBundle);
    paramBundle = getString(R.l.ewI);
    if (com.tencent.mm.protocal.d.sXk) {
      paramBundle = getString(R.l.bpC) + getString(R.l.dCT);
    }
    qL(paramBundle);
    this.uWU = getIntent().getStringExtra("bindmcontact_mobile");
    if (this.uWU != null) {
      this.hRY = am.PA(this.uWU);
    }
    com.tencent.mm.plugin.c.a.imc.ox();
    this.oTI = b.OA();
    KD();
    GMTrace.o(2666906255360L, 19870);
  }
  
  public void onDestroy()
  {
    GMTrace.i(2667308908544L, 19873);
    ap.vd().b(701, this);
    super.onDestroy();
    GMTrace.o(2667308908544L, 19873);
  }
  
  public void onPause()
  {
    GMTrace.i(2667174690816L, 19872);
    super.onPause();
    com.tencent.mm.sdk.b.a.uql.c(this.uVQ);
    b.b(false, ap.uY() + "," + getClass().getName() + ",L200_200," + ap.ec("L200_200") + ",2");
    GMTrace.o(2667174690816L, 19872);
  }
  
  public void onResume()
  {
    GMTrace.i(2667040473088L, 19871);
    com.tencent.mm.sdk.b.a.uql.b(this.uVQ);
    super.onResume();
    b.b(true, ap.uY() + "," + getClass().getName() + ",L200_200," + ap.ec("L200_200") + ",1");
    b.mM("L200_200");
    GMTrace.o(2667040473088L, 19871);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/LoginIndepPass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */