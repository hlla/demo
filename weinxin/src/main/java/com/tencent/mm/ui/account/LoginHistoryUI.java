package com.tencent.mm.ui.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.il;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.j.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.a.a;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.e.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class LoginHistoryUI
  extends MMActivity
  implements com.tencent.mm.y.e
{
  private String fWO;
  private SharedPreferences hgn;
  protected int iQr;
  protected ProgressDialog isb;
  protected EditText lhX;
  protected int[] niS;
  protected String oTE;
  protected String raV;
  protected LinearLayout sxl;
  private SecurityImage uSI;
  private com.tencent.mm.sdk.b.c uVQ;
  private MMKeyboardUperView uWA;
  private ResizeLayout uWB;
  protected String uWC;
  private com.tencent.mm.pluginsdk.j.a uWD;
  protected LinearLayout uWE;
  protected LinearLayout uWF;
  protected MMFormInputView uWG;
  protected MMFormVerifyCodeInputView uWH;
  protected boolean uWI;
  protected boolean uWJ;
  private int uWK;
  private int uWL;
  private boolean uWM;
  private String uWN;
  private int uWO;
  protected TextView uWp;
  protected Button uWq;
  protected Button uWr;
  protected View uWs;
  protected View uWt;
  protected View uWu;
  protected f uWv;
  protected String uWw;
  protected String uWx;
  private String uWy;
  private ImageView uWz;
  
  public LoginHistoryUI()
  {
    GMTrace.i(2644626112512L, 19704);
    this.isb = null;
    this.uSI = null;
    this.uWv = new f();
    this.fWO = "";
    this.raV = "";
    this.uWI = false;
    this.uWM = false;
    this.niS = new int[5];
    this.uVQ = new com.tencent.mm.sdk.b.c() {};
    this.uWO = 0;
    GMTrace.o(2644626112512L, 19704);
  }
  
  private void SL(String paramString)
  {
    GMTrace.i(2645968289792L, 19714);
    this.raV = paramString;
    Tn();
    GMTrace.o(2645968289792L, 19714);
  }
  
  private void b(com.tencent.mm.modelsimple.u paramu)
  {
    GMTrace.i(2646236725248L, 19716);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), bf.bJP() });
    Intent localIntent = com.tencent.mm.plugin.c.a.imb.ak(this);
    localIntent.addFlags(67108864);
    if (paramu != null)
    {
      localIntent.putExtra("kstyle_show_bind_mobile_afterauth", paramu.Jm());
      localIntent.putExtra("kstyle_bind_recommend_show", paramu.Jp());
      localIntent.putExtra("kstyle_bind_wording", paramu.Jn());
    }
    startActivity(localIntent);
    finish();
    GMTrace.o(2646236725248L, 19716);
  }
  
  public static void be(Context paramContext, String paramString)
  {
    GMTrace.i(2646773596160L, 19720);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
    com.tencent.mm.bb.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    GMTrace.o(2646773596160L, 19720);
  }
  
  private boolean p(final int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(16844056428544L, 125498);
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (!com.tencent.mm.plugin.c.a.imc.a(this, paramInt1, paramInt2, paramString)) {
        break label814;
      }
      if (this.uSI != null) {
        this.uSI.dismiss();
      }
      GMTrace.o(16844056428544L, 125498);
      return true;
    case -4: 
    case -3: 
      if (this.uWO <= 0)
      {
        com.tencent.mm.ui.base.g.h(this, R.l.eeU, R.l.ewF);
        this.uWO += 1;
      }
      for (;;)
      {
        GMTrace.o(16844056428544L, 125498);
        return true;
        com.tencent.mm.ui.base.g.b(this, getString(R.l.eeV), getString(R.l.ewF), getString(R.l.eeW), getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(16825802817536L, 125362);
            LoginHistoryUI.f(LoginHistoryUI.this);
            GMTrace.o(16825802817536L, 125362);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(16824997511168L, 125356);
            LoginHistoryUI.g(LoginHistoryUI.this);
            GMTrace.o(16824997511168L, 125356);
          }
        });
      }
    case -1: 
      if (ap.vd().BR() == 5)
      {
        com.tencent.mm.ui.base.g.h(this, R.l.eDh, R.l.eDg);
        GMTrace.o(16844056428544L, 125498);
        return true;
      }
    case -9: 
      com.tencent.mm.ui.base.g.h(this, R.l.ewE, R.l.ewF);
      GMTrace.o(16844056428544L, 125498);
      return true;
    case -72: 
      com.tencent.mm.ui.base.g.h(this, R.l.eJR, R.l.dIG);
      GMTrace.o(16844056428544L, 125498);
      return true;
    case -75: 
      com.tencent.mm.platformtools.m.bo(this);
      GMTrace.o(16844056428544L, 125498);
      return true;
    case -32: 
      com.tencent.mm.ui.base.g.a(this, getString(R.l.dNZ), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(16826608123904L, 125368);
          GMTrace.o(16826608123904L, 125368);
        }
      });
      GMTrace.o(16844056428544L, 125498);
      return true;
    case -33: 
      com.tencent.mm.ui.base.g.a(this, R.l.dNX, R.l.btk, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(16847546089472L, 125524);
          GMTrace.o(16847546089472L, 125524);
        }
      });
      GMTrace.o(16844056428544L, 125498);
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
            GMTrace.i(2784480985088L, 20746);
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LoginHistoryUI", "imgSid:" + LoginHistoryUI.this.uWv.uXf + " img len" + LoginHistoryUI.this.uWv.uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
            int j = paramInt1;
            if (LoginHistoryUI.this.raV == null)
            {
              paramAnonymousInt = -1;
              paramAnonymousDialogInterface = bf.Qi(LoginHistoryUI.this.raV);
              if (LoginHistoryUI.this.uWv.uXd != null) {
                break label389;
              }
            }
            label389:
            for (int i = -1;; i = LoginHistoryUI.this.uWv.uXd.length())
            {
              com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LoginHistoryUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), bf.Qi(LoginHistoryUI.this.uWv.uXd) });
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.u(LoginHistoryUI.this.uWv.hRY, LoginHistoryUI.this.uWv.uXd, LoginHistoryUI.this.uWv.uXi, LoginHistoryUI.h(LoginHistoryUI.this).bRp(), LoginHistoryUI.h(LoginHistoryUI.this).uXf, LoginHistoryUI.h(LoginHistoryUI.this).uXg, 0, "", false, false);
              if ((bf.mA(LoginHistoryUI.this.uWv.uXd)) && (!bf.mA(LoginHistoryUI.this.raV)))
              {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { bf.Qi(LoginHistoryUI.this.raV) });
                paramAnonymousDialogInterface.kD(LoginHistoryUI.this.raV);
              }
              ap.vd().a(paramAnonymousDialogInterface, 0);
              LoginHistoryUI localLoginHistoryUI1 = LoginHistoryUI.this;
              LoginHistoryUI localLoginHistoryUI2 = LoginHistoryUI.this;
              LoginHistoryUI.this.getString(R.l.dIG);
              localLoginHistoryUI1.isb = com.tencent.mm.ui.base.g.a(localLoginHistoryUI2, LoginHistoryUI.this.getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  GMTrace.i(16825534382080L, 125360);
                  ap.vd().c(paramAnonymousDialogInterface);
                  ap.vd().b(701, LoginHistoryUI.this);
                  GMTrace.o(16825534382080L, 125360);
                }
              });
              GMTrace.o(2784480985088L, 20746);
              return;
              paramAnonymousInt = LoginHistoryUI.this.raV.length();
              break;
            }
          }
        }, null, new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(16824326422528L, 125351);
            LoginHistoryUI.i(LoginHistoryUI.this);
            GMTrace.o(16824326422528L, 125351);
          }
        }, this.uWv);
      }
      for (;;)
      {
        GMTrace.o(16844056428544L, 125498);
        return true;
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.uWv.uXf + " img len" + this.uWv.uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
        this.uSI.a(this.uWv.uXi, this.uWv.uXh, this.uWv.uXf, this.uWv.uXg);
      }
    case -100: 
      ap.hold();
      if (TextUtils.isEmpty(ap.uI())) {}
      for (paramString = com.tencent.mm.bg.a.V(this, R.l.eza);; paramString = ap.uI())
      {
        com.tencent.mm.ui.base.g.a(this, paramString, getString(R.l.dIG), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2766495809536L, 20612);
            GMTrace.o(2766495809536L, 20612);
          }
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(16825668599808L, 125361);
            GMTrace.o(16825668599808L, 125361);
          }
        });
        GMTrace.o(16844056428544L, 125498);
        return true;
      }
    case -205: 
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bf.Qi(this.oTE), this.uWy });
      f.a(this.uWv);
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.oTE);
      paramString.putExtra("binded_mobile", this.uWx);
      paramString.putExtra("close_safe_device_style", this.uWy);
      paramString.putExtra("from_source", 2);
      com.tencent.mm.plugin.c.a.imb.f(this, paramString);
      GMTrace.o(16844056428544L, 125498);
      return true;
    }
    if (!bf.mA(this.fWO)) {
      com.tencent.mm.platformtools.m.j(this, paramString, this.fWO);
    }
    GMTrace.o(16844056428544L, 125498);
    return true;
    label814:
    paramString = new p(paramInt1, paramInt2, paramString);
    boolean bool = this.uWD.a(this, paramString);
    GMTrace.o(16844056428544L, 125498);
    return bool;
  }
  
  protected final String Dg(String paramString)
  {
    GMTrace.i(16843653775360L, 125495);
    new am();
    String str1 = "86";
    Object localObject = paramString;
    if (this.uWC.startsWith("+"))
    {
      String str2 = paramString.replace("+", "");
      paramString = am.yS(str2);
      str1 = paramString;
      localObject = str2;
      if (paramString != null)
      {
        localObject = str2.substring(paramString.length());
        str1 = paramString;
      }
    }
    paramString = am.formatNumber(str1, (String)localObject);
    GMTrace.o(16843653775360L, 125495);
    return paramString;
  }
  
  protected final void KD()
  {
    GMTrace.i(2645431418880L, 19710);
    this.sxl = ((LinearLayout)findViewById(R.h.cMX));
    this.uWF = ((LinearLayout)findViewById(R.h.bNz));
    this.uWE = ((LinearLayout)findViewById(R.h.bPN));
    this.uWG = ((MMFormInputView)findViewById(R.h.ccz));
    this.uWH = ((MMFormVerifyCodeInputView)findViewById(R.h.cFI));
    this.uWC = ao.hlE.A("login_user_name", "");
    final Object localObject = ao.hlE.hgn.getString("last_avatar_path", "");
    if ((((String)localObject).length() == 0) || (((String)localObject).endsWith("last_avatar"))) {}
    for (;;)
    {
      this.uWL = bf.PX(ao.hlE.A("last_bind_info", "0"));
      if ((this.uWL & 0x1) != 0) {
        this.uWw = ao.hlE.A("last_login_bind_qq", "");
      }
      if ((this.uWL & 0x4) != 0) {
        this.uWx = ao.hlE.A("last_login_bind_mobile", "");
      }
      String str1 = getIntent().getStringExtra("email_address");
      if ((!bf.mA(str1)) && (!str1.equalsIgnoreCase(this.uWC))) {
        this.uWC = str1;
      }
      this.uWz = ((ImageView)findViewById(R.h.cal));
      if (!bf.mA((String)localObject))
      {
        localObject = com.tencent.mm.x.d.hn((String)localObject);
        if ((localObject != null) && (((Bitmap)localObject).getWidth() > 10)) {
          this.uWz.setImageBitmap(Bitmap.createBitmap((Bitmap)localObject, 5, 5, ((Bitmap)localObject).getWidth() - 10, ((Bitmap)localObject).getHeight() - 10, null, false));
        }
      }
      if ((!ap.za()) || (this.uWC.equals(""))) {
        break;
      }
      this.uWI = true;
      b(null);
      GMTrace.o(2645431418880L, 19710);
      return;
      String str2 = (String)localObject + ".bm";
      str1 = com.tencent.mm.compatible.util.e.hgg + "last_avatar";
      String str3 = str1 + ".bm";
      if ((FileOp.p((String)localObject, str1) > 0L) || (FileOp.p(str2, str3) > 0L))
      {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LastLoginInfo", "Copy avatar: %s -> %s", new Object[] { str2, str3 });
        localObject = str1;
      }
      else
      {
        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.LastLoginInfo", "Can't find avatar file: " + str2);
      }
    }
    this.uWK = bf.PX(ao.hlE.A("last_login_use_voice", ""));
    this.uWA = ((MMKeyboardUperView)findViewById(R.h.Ki));
    this.uWp = ((TextView)findViewById(R.h.cct));
    this.lhX = this.uWG.oAr;
    this.uWq = ((Button)findViewById(R.h.ccu));
    this.uWs = findViewById(R.h.ccD);
    this.uWt = findViewById(R.h.ccx);
    this.uWu = ((Button)findViewById(R.h.cFc));
    this.uWr = ((Button)findViewById(R.h.ccw));
    this.uWG.setVisibility(8);
    this.sxl.setVisibility(8);
    this.uWF.setVisibility(8);
    this.uWE.setVisibility(8);
    this.uWq.setVisibility(8);
    this.uWs.setVisibility(8);
    this.uWt.setVisibility(8);
    this.uWu.setVisibility(8);
    this.uWr.setVisibility(8);
    com.tencent.mm.ui.tools.a.c.d(this.lhX).em(4, 16).a(null);
    this.uWB = ((ResizeLayout)findViewById(R.h.cyt));
    if ((bf.Qg(this.uWC).booleanValue()) && (!this.uWC.equals(this.uWw)))
    {
      this.niS[2] = 1;
      this.uWp.setText(Dg(this.uWC));
    }
    for (;;)
    {
      this.uWB.uZT = new ResizeLayout.a()
      {
        public final void bQF()
        {
          GMTrace.i(16838150848512L, 125454);
          LoginHistoryUI.b(LoginHistoryUI.this).post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(16837211324416L, 125447);
              LoginHistoryUI.b(LoginHistoryUI.this).fullScroll(130);
              GMTrace.o(16837211324416L, 125447);
            }
          });
          GMTrace.o(16838150848512L, 125454);
        }
      };
      this.uWA.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          GMTrace.i(16805938593792L, 125214);
          LoginHistoryUI.this.aGY();
          GMTrace.o(16805938593792L, 125214);
          return false;
        }
      });
      localObject = new com.tencent.mm.ui.widget.e(this, com.tencent.mm.ui.widget.e.wsK, false);
      ((com.tencent.mm.ui.widget.e)localObject).qHD = new n.c()
      {
        public final void a(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          GMTrace.i(16821105197056L, 125327);
          if (paramAnonymousl.size() == 0)
          {
            paramAnonymousl.dX(7002, R.l.ewC);
            paramAnonymousl.dX(7009, R.l.eIQ);
            paramAnonymousl.dX(7004, R.l.ewH);
            paramAnonymousl.dX(7003, R.l.esx);
          }
          GMTrace.o(16821105197056L, 125327);
        }
      };
      ((com.tencent.mm.ui.widget.e)localObject).qHE = new n.d()
      {
        public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          GMTrace.i(16846472347648L, 125516);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            GMTrace.o(16846472347648L, 125516);
            return;
            paramAnonymousMenuItem = LoginHistoryUI.this.getString(R.l.ewG) + com.tencent.mm.sdk.platformtools.u.bID();
            LoginHistoryUI.be(LoginHistoryUI.this, paramAnonymousMenuItem);
            GMTrace.o(16846472347648L, 125516);
            return;
            LoginHistoryUI.c(LoginHistoryUI.this);
            GMTrace.o(16846472347648L, 125516);
            return;
            LoginHistoryUI.d(LoginHistoryUI.this);
            GMTrace.o(16846472347648L, 125516);
            return;
            LoginHistoryUI.e(LoginHistoryUI.this);
          }
        }
      };
      ((com.tencent.mm.ui.widget.e)localObject).wsV = new e.a()
      {
        public final void onDismiss()
        {
          GMTrace.i(16824594857984L, 125353);
          localObject.bza();
          GMTrace.o(16824594857984L, 125353);
        }
      };
      qL("");
      bPO();
      cO().cP().setBackgroundDrawable(getResources().getDrawable(R.e.aVj));
      cO().cP().getCustomView().findViewById(R.h.divider).setVisibility(8);
      a(7000, R.l.dUy, R.k.dsG, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(16817212882944L, 125298);
          LoginHistoryUI.this.aGY();
          localObject.byZ();
          GMTrace.o(16817212882944L, 125298);
          return true;
        }
      });
      if (com.tencent.mm.sdk.platformtools.f.uqI) {
        com.tencent.mm.plugin.c.a.imc.d(this);
      }
      GMTrace.o(2645431418880L, 19710);
      return;
      this.niS[2] = 2;
      this.uWp.setText(this.uWC);
    }
  }
  
  protected void Tn()
  {
    GMTrace.i(2645565636608L, 19711);
    this.uWv.hRY = this.uWC.trim();
    GMTrace.o(2645565636608L, 19711);
  }
  
  public final void a(int paramInt1, int paramInt2, final String paramString, final k paramk)
  {
    GMTrace.i(2646102507520L, 19715);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LoginHistoryUI", "Scene Type " + paramk.getType());
    if (paramk.getType() == 145)
    {
      if ((this.isb != null) && (this.isb.isShowing()))
      {
        this.isb.dismiss();
        this.isb = null;
      }
      i = ((s)paramk).AJ();
      if (i == 16)
      {
        if (paramInt2 == -41)
        {
          com.tencent.mm.ui.base.g.h(this, R.l.eJB, R.l.eJC);
          this.uWH.reset();
          GMTrace.o(2646102507520L, 19715);
          return;
        }
        if (paramInt2 == -75)
        {
          com.tencent.mm.ui.base.g.b(this, getString(R.l.dCV), "", true);
          this.uWH.reset();
          GMTrace.o(2646102507520L, 19715);
        }
      }
      else if (i == 17)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          new com.tencent.mm.ui.account.mobile.a(new a.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              GMTrace.i(16829829349376L, 125392);
              LoginHistoryUI.this.isb = paramAnonymousProgressDialog;
              GMTrace.o(16829829349376L, 125392);
            }
          }, ((s)paramk).getUsername(), ((s)paramk).Fu(), this.uWx).h(this);
          GMTrace.o(2646102507520L, 19715);
          return;
        }
        if (paramInt2 == -51)
        {
          paramString = com.tencent.mm.f.a.dn(paramString);
          if (paramString != null)
          {
            paramString.a(this, null, null);
            GMTrace.o(2646102507520L, 19715);
            return;
          }
          com.tencent.mm.ui.base.g.h(this, R.l.eIY, R.l.btk);
          GMTrace.o(2646102507520L, 19715);
        }
      }
    }
    else
    {
      if (paramk.getType() != 701) {
        break label955;
      }
      this.fWO = ((com.tencent.mm.modelsimple.u)paramk).Ji();
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LoginHistoryUI", "url " + this.fWO);
      ap.vd().b(701, this);
      this.uWv.uXi = ((com.tencent.mm.modelsimple.u)paramk).Jj();
      this.uWv.uXf = ((com.tencent.mm.modelsimple.u)paramk).FK();
      this.uWv.uXh = ((com.tencent.mm.modelsimple.u)paramk).FJ();
      this.uWv.uXg = ((com.tencent.mm.modelsimple.u)paramk).Jk();
      if (paramInt2 == 65331)
      {
        this.oTE = ((com.tencent.mm.modelsimple.u)paramk).Fw();
        this.uWx = ((com.tencent.mm.modelsimple.u)paramk).Jl();
        this.uWy = ((com.tencent.mm.modelsimple.u)paramk).Jo();
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label1081;
      }
      ap.vd().a(new bb(new bb.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          GMTrace.i(16846875000832L, 125519);
          if (paramAnonymouse == null)
          {
            GMTrace.o(16846875000832L, 125519);
            return;
          }
          paramAnonymouse = paramAnonymouse.Cc();
          ap.yY();
          int i = com.tencent.mm.u.c.uH();
          paramAnonymouse.i(new byte[0], i);
          GMTrace.o(16846875000832L, 125519);
        }
      }), 0);
    }
    label955:
    label1081:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        ap.unhold();
        com.tencent.mm.modelsimple.d.bc(this);
        com.tencent.mm.platformtools.m.mv(this.uWv.hRY);
        if ((this.isb != null) && (this.isb.isShowing())) {
          this.isb.setMessage(getString(R.l.eSD));
        }
        b((com.tencent.mm.modelsimple.u)paramk);
        if (this.iQr == 3)
        {
          this.uWJ = ((com.tencent.mm.modelsimple.u)paramk).Jq();
          ap.vd().a(255, this);
          paramString = new com.tencent.mm.modelsimple.v(1);
          ap.vd().a(paramString, 0);
          getString(R.l.dIG);
          this.isb = com.tencent.mm.ui.base.g.a(this, getString(R.l.eSD), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              GMTrace.i(16817749753856L, 125302);
              ap.vd().c(paramString);
              ap.vd().b(255, LoginHistoryUI.this);
              GMTrace.o(16817749753856L, 125302);
            }
          });
        }
        GMTrace.o(2646102507520L, 19715);
        return;
      }
      if ((this.isb != null) && (this.isb.isShowing()))
      {
        this.isb.dismiss();
        this.isb = null;
      }
      if (paramInt2 == -106)
      {
        com.tencent.mm.platformtools.m.E(this, paramString);
        GMTrace.o(2646102507520L, 19715);
        return;
      }
      if (paramInt2 == 65319)
      {
        com.tencent.mm.platformtools.m.a(this, com.tencent.mm.pluginsdk.a.a.a((com.tencent.mm.modelsimple.u)paramk), paramInt2);
        GMTrace.o(2646102507520L, 19715);
        return;
      }
      if (paramInt2 == -30)
      {
        if (com.tencent.mm.protocal.d.sXk)
        {
          be(this.uRf.uRz, this.fWO);
          GMTrace.o(2646102507520L, 19715);
          return;
        }
        com.tencent.mm.ui.base.g.a(this, getString(R.l.ewU), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(16846740783104L, 125518);
            com.tencent.mm.plugin.c.b.mN("R400_100_login");
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("regsetinfo_binduin", LoginHistoryUI.this.uWv.hRY);
            paramAnonymousDialogInterface.putExtra("regsetinfo_pwd", LoginHistoryUI.this.uWv.uXd);
            paramAnonymousDialogInterface.putExtra("regsetinfo_ismobile", 0);
            paramAnonymousDialogInterface.putExtra("regsetinfo_NextControl", ((com.tencent.mm.modelsimple.u)paramk).Fy());
            paramAnonymousDialogInterface.setClass(LoginHistoryUI.this, RegSetInfoUI.class);
            LoginHistoryUI.this.uRf.uRz.startActivity(paramAnonymousDialogInterface);
            GMTrace.o(16846740783104L, 125518);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(16816944447488L, 125296);
            GMTrace.o(16816944447488L, 125296);
          }
        });
        GMTrace.o(2646102507520L, 19715);
        return;
      }
      if (p(paramInt1, paramInt2, paramString))
      {
        GMTrace.o(2646102507520L, 19715);
        return;
      }
      paramk = com.tencent.mm.f.a.dn(paramString);
      if ((paramk != null) && (paramk.a(this, null, null)))
      {
        GMTrace.o(2646102507520L, 19715);
        return;
      }
      Toast.makeText(this, getString(R.l.ekZ, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      while (p(paramInt1, paramInt2, paramString))
      {
        GMTrace.o(2646102507520L, 19715);
        return;
        if (paramk.getType() == 255)
        {
          if ((this.isb != null) && (this.isb.isShowing()))
          {
            this.isb.dismiss();
            this.isb = null;
          }
          ap.vd().b(255, this);
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            boolean bool = this.uWJ;
            paramString = new Intent(this, RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(R.l.eSR));
            paramString.putExtra("kintent_cancelable", bool);
            startActivity(paramString);
          }
          GMTrace.o(2646102507520L, 19715);
          return;
        }
      }
      GMTrace.o(2646102507520L, 19715);
      return;
    }
  }
  
  public final void aGY()
  {
    GMTrace.i(2645699854336L, 19712);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      GMTrace.o(2645699854336L, 19712);
      return;
    }
    Object localObject = getCurrentFocus();
    if (localObject == null)
    {
      GMTrace.o(2645699854336L, 19712);
      return;
    }
    localObject = ((View)localObject).getWindowToken();
    if (localObject == null)
    {
      GMTrace.o(2645699854336L, 19712);
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
    GMTrace.o(2645699854336L, 19712);
  }
  
  protected final void bQC()
  {
    GMTrace.i(16843787993088L, 125496);
    ap.vd().a(701, this);
    GMTrace.o(16843787993088L, 125496);
  }
  
  protected final void bQD()
  {
    GMTrace.i(16843922210816L, 125497);
    ap.vd().b(701, this);
    GMTrace.o(16843922210816L, 125497);
  }
  
  public boolean bQE()
  {
    GMTrace.i(2646907813888L, 19721);
    GMTrace.o(2646907813888L, 19721);
    return true;
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2646370942976L, 19717);
    int i = R.i.dgK;
    GMTrace.o(2646370942976L, 19717);
    return i;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    int i = 0;
    GMTrace.i(2645834072064L, 19713);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LoginHistoryUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 != 1024) || (paramIntent == null)) {
        break label182;
      }
      if (paramInt2 != -1) {
        break label255;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bf.mA(str);
      if (!bf.mA(str)) {
        break label173;
      }
    }
    label173:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LoginHistoryUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      SL(str);
      GMTrace.o(2645834072064L, 19713);
      return;
      bool = false;
      break;
    }
    label182:
    if ((paramInt1 == 1025) && (paramIntent != null) && (paramInt2 == 2))
    {
      paramIntent = paramIntent.getStringExtra("KFaceLoginAuthPwd");
      bool = bf.mA(paramIntent);
      if (!bf.mA(paramIntent)) {
        break label265;
      }
    }
    label255:
    label265:
    for (paramInt1 = j;; paramInt1 = paramIntent.length())
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoginHistoryUI", "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
      SL(paramIntent);
      GMTrace.o(2645834072064L, 19713);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2644760330240L, 19705);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.c.a.imc.ox();
    this.hgn = aa.getContext().getSharedPreferences(aa.bIN(), 0);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.uWM = paramBundle.getBooleanExtra("login_success_need_bind_fingerprint", false);
      this.uWM = this.uWM;
      if (this.uWM) {
        this.uWN = paramBundle.getStringExtra("bind_login_fingerprint_info");
      }
    }
    KD();
    this.uWD = new com.tencent.mm.pluginsdk.j.a();
    GMTrace.o(2644760330240L, 19705);
  }
  
  public void onDestroy()
  {
    GMTrace.i(2644894547968L, 19706);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoginHistoryUI", "onDestroy");
    ap.vd().b(701, this);
    if (this.uWD != null) {
      this.uWD.close();
    }
    com.tencent.mm.plugin.report.service.g.oSF.i(14262, new Object[] { Integer.valueOf(this.niS[0]), Integer.valueOf(this.niS[1]), Integer.valueOf(this.niS[2]), Integer.valueOf(this.niS[3]), Integer.valueOf(this.niS[4]) });
    if (this.isb != null)
    {
      this.isb.dismiss();
      this.isb = null;
    }
    super.onDestroy();
    GMTrace.o(2644894547968L, 19706);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2645297201152L, 19709);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Intent localIntent = com.tencent.mm.plugin.c.a.imb.ak(this);
      localIntent.addFlags(67108864);
      localIntent.putExtra("can_finish", true);
      startActivity(localIntent);
      finish();
      com.tencent.mm.ui.base.b.eN(this);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2645297201152L, 19709);
    return bool;
  }
  
  public void onPause()
  {
    GMTrace.i(2645162983424L, 19708);
    super.onPause();
    com.tencent.mm.sdk.b.a.uql.c(this.uVQ);
    GMTrace.o(2645162983424L, 19708);
  }
  
  public void onResume()
  {
    GMTrace.i(2645028765696L, 19707);
    super.onResume();
    final Object localObject1 = new ArrayList();
    final Object localObject2;
    if ((bQE()) && (this.iQr != 1) && ((this.uWK & 0x20000) != 0))
    {
      localObject2 = new com.tencent.mm.ui.base.m(7001, 0);
      ((com.tencent.mm.ui.base.m)localObject2).setTitle(R.l.ewO);
      ((List)localObject1).add(localObject2);
    }
    if ((this.iQr != 5) && ((this.uWK & 0x40000) != 0))
    {
      localObject2 = new com.tencent.mm.ui.base.m(7005, 0);
      ((com.tencent.mm.ui.base.m)localObject2).setTitle(R.l.ewL);
      ((List)localObject1).add(localObject2);
    }
    if (!bf.mA(this.uWC))
    {
      if ((!bf.mA(this.uWx)) && (this.iQr != 3))
      {
        localObject2 = new com.tencent.mm.ui.base.m(7008, 0);
        ((com.tencent.mm.ui.base.m)localObject2).setTitle(getString(R.l.ewN));
        ((List)localObject1).add(localObject2);
      }
      if (this.iQr != 2)
      {
        localObject2 = new com.tencent.mm.ui.base.m(7007, 0);
        ((com.tencent.mm.ui.base.m)localObject2).setTitle(getString(R.l.ewM));
        ((List)localObject1).add(localObject2);
      }
      if (this.uWC.equalsIgnoreCase(this.uWw)) {
        this.lhX.setHint(getString(R.l.eJW));
      }
    }
    if (((List)localObject1).size() > 1)
    {
      localObject2 = new com.tencent.mm.ui.widget.e(this, com.tencent.mm.ui.widget.e.wsK, false);
      ((com.tencent.mm.ui.widget.e)localObject2).qHD = new n.c()
      {
        public final void a(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          GMTrace.i(16847277654016L, 125522);
          if (paramAnonymousl.size() == 0)
          {
            Iterator localIterator = localObject1.iterator();
            while (localIterator.hasNext())
            {
              com.tencent.mm.ui.base.m localm = (com.tencent.mm.ui.base.m)localIterator.next();
              if (localm != null) {
                paramAnonymousl.vjl.add(localm);
              }
            }
          }
          GMTrace.o(16847277654016L, 125522);
        }
      };
      ((com.tencent.mm.ui.widget.e)localObject2).qHE = new n.d()
      {
        public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          GMTrace.i(16848217178112L, 125529);
          LoginHistoryUI.a(LoginHistoryUI.this, paramAnonymousMenuItem.getItemId());
          GMTrace.o(16848217178112L, 125529);
        }
      };
      ((com.tencent.mm.ui.widget.e)localObject2).wsV = new e.a()
      {
        public final void onDismiss()
        {
          GMTrace.i(17777272291328L, 132451);
          localObject2.bza();
          GMTrace.o(17777272291328L, 132451);
        }
      };
      this.uWr.setVisibility(0);
      this.uWr.setText(R.l.ewB);
      this.uWr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16837479759872L, 125449);
          localObject2.byZ();
          GMTrace.o(16837479759872L, 125449);
        }
      });
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.uql.b(this.uVQ);
      ap.uZ();
      localObject1 = ao.hlE.A("login_user_name", "");
      if ((!ap.za()) || (((String)localObject1).equals(""))) {
        break label496;
      }
      if ((this.isb == null) || (!this.isb.isShowing())) {
        break;
      }
      GMTrace.o(2645028765696L, 19707);
      return;
      if (((List)localObject1).size() > 0)
      {
        this.uWr.setVisibility(0);
        this.uWr.setText(((com.tencent.mm.ui.base.m)((List)localObject1).get(0)).getTitle());
        this.uWr.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(17776869638144L, 132448);
            LoginHistoryUI.a(LoginHistoryUI.this, ((com.tencent.mm.ui.base.m)localObject1.get(0)).getItemId());
            GMTrace.o(17776869638144L, 132448);
          }
        });
      }
      else
      {
        this.uWr.setVisibility(8);
      }
    }
    b(null);
    GMTrace.o(2645028765696L, 19707);
    return;
    label496:
    if (com.tencent.mm.m.a.tP() == 2)
    {
      localObject1 = new h.a(this);
      ((h.a)localObject1).zR(R.l.dVP);
      ((h.a)localObject1).SW(getString(R.l.dVO));
      ((h.a)localObject1).kH(false);
      ((h.a)localObject1).zU(R.l.dVM).a(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(16838553501696L, 125457);
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoginHistoryUI", "db dangerous and auto logout");
          LoginHistoryUI.a(LoginHistoryUI.this);
          GMTrace.o(16838553501696L, 125457);
        }
      });
      ((h.a)localObject1).WD().show();
      com.tencent.mm.m.a.b(this, System.currentTimeMillis());
    }
    GMTrace.o(2645028765696L, 19707);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    GMTrace.i(2646505160704L, 19718);
    GMTrace.o(2646505160704L, 19718);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/LoginHistoryUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */