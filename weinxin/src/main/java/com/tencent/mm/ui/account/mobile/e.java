package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.account.RegSetInfoUI;
import com.tencent.mm.ui.account.f;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class e
  implements MobileInputUI.b, com.tencent.mm.y.e
{
  private String fWO;
  public String hRY;
  private String oTE;
  public SecurityImage uSI;
  private boolean uWJ;
  public MobileInputUI vbk;
  
  public e()
  {
    GMTrace.i(16808488730624L, 125233);
    this.uSI = null;
    this.uWJ = true;
    GMTrace.o(16808488730624L, 125233);
  }
  
  private boolean p(int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(16809696690176L, 125242);
    if (com.tencent.mm.plugin.c.a.imc.a(this.vbk, paramInt1, paramInt2, paramString))
    {
      GMTrace.o(16809696690176L, 125242);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      GMTrace.o(16809696690176L, 125242);
      return false;
    case -1: 
      if (ap.vd().BR() == 5)
      {
        com.tencent.mm.ui.base.g.h(this.vbk, R.l.eDh, R.l.eDg);
        GMTrace.o(16809696690176L, 125242);
        return true;
      }
      GMTrace.o(16809696690176L, 125242);
      return false;
    case -4: 
    case -3: 
      com.tencent.mm.ui.base.g.h(this.vbk, R.l.eeU, R.l.ewF);
      GMTrace.o(16809696690176L, 125242);
      return true;
    case -9: 
      com.tencent.mm.ui.base.g.h(this.vbk, R.l.ewE, R.l.ewF);
      GMTrace.o(16809696690176L, 125242);
      return true;
    case -100: 
      ap.hold();
      MobileInputUI localMobileInputUI = this.vbk;
      if (TextUtils.isEmpty(ap.uI())) {}
      for (paramString = com.tencent.mm.bg.a.V(this.vbk, R.l.eza);; paramString = ap.uI())
      {
        com.tencent.mm.ui.base.g.a(localMobileInputUI, paramString, this.vbk.getString(R.l.dIG), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(16814796963840L, 125280);
            GMTrace.o(16814796963840L, 125280);
          }
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(16813052133376L, 125267);
            GMTrace.o(16813052133376L, 125267);
          }
        });
        GMTrace.o(16809696690176L, 125242);
        return true;
      }
    case -140: 
      if (!bf.mA(this.fWO)) {
        m.j(this.vbk, paramString, this.fWO);
      }
      GMTrace.o(16809696690176L, 125242);
      return true;
    case -34: 
      Toast.makeText(this.vbk, R.l.dNq, 0).show();
      GMTrace.o(16809696690176L, 125242);
      return true;
    case -32: 
      com.tencent.mm.ui.base.g.a(this.vbk, R.l.dNZ, R.l.btk, null);
      GMTrace.o(16809696690176L, 125242);
      return true;
    }
    com.tencent.mm.ui.base.g.a(this.vbk, R.l.dNX, R.l.btk, null);
    GMTrace.o(16809696690176L, 125242);
    return true;
  }
  
  public final void SQ(final String paramString)
  {
    GMTrace.i(16809294036992L, 125239);
    paramString = new s(paramString, 16, "", 0, "");
    ap.vd().a(paramString, 0);
    MobileInputUI localMobileInputUI1 = this.vbk;
    MobileInputUI localMobileInputUI2 = this.vbk;
    this.vbk.getString(R.l.dIG);
    localMobileInputUI1.uWW = com.tencent.mm.ui.base.g.a(localMobileInputUI2, this.vbk.getString(R.l.dIV), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(16816004923392L, 125289);
        ap.vd().c(paramString);
        GMTrace.o(16816004923392L, 125289);
      }
    });
    GMTrace.o(16809294036992L, 125239);
  }
  
  public final void a(int paramInt1, int paramInt2, final String paramString, final k paramk)
  {
    GMTrace.i(16809562472448L, 125241);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.vbk.uWW != null)
    {
      this.vbk.uWW.dismiss();
      this.vbk.uWW = null;
    }
    int i;
    final Object localObject;
    if (paramk.getType() == 145)
    {
      i = ((s)paramk).AJ();
      if (i == 16)
      {
        if (paramInt2 == -41)
        {
          this.vbk.vbx.reset();
          com.tencent.mm.ui.base.g.h(this.vbk, R.l.eJB, R.l.eJC);
          GMTrace.o(16809562472448L, 125241);
          return;
        }
        if (paramInt2 == -75)
        {
          this.vbk.vbx.reset();
          com.tencent.mm.ui.base.g.b(this.vbk, this.vbk.getString(R.l.dCV), "", true);
          GMTrace.o(16809562472448L, 125241);
        }
      }
      else if (i == 17)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          new a(new a.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              GMTrace.i(16807414988800L, 125225);
              e.this.vbk.uWW = ((p)paramAnonymousProgressDialog);
              GMTrace.o(16807414988800L, 125225);
            }
          }, ((s)paramk).getUsername(), ((s)paramk).Fu(), this.hRY).h(this.vbk);
          GMTrace.o(16809562472448L, 125241);
          return;
        }
        if (paramInt2 == -30)
        {
          b.mO(ap.uY() + "," + getClass().getName() + ",L200_900_phone," + ap.ec("L200_900_phone") + ",1");
          localObject = com.tencent.mm.f.a.dn(paramString).desc;
          MobileInputUI localMobileInputUI = this.vbk;
          paramString = (String)localObject;
          if (bf.mA((String)localObject)) {
            paramString = this.vbk.getString(R.l.ewR);
          }
          com.tencent.mm.ui.base.g.b(localMobileInputUI, paramString, "", this.vbk.getString(R.l.ewT), this.vbk.getString(R.l.ewS), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(16812246827008L, 125261);
              if (com.tencent.mm.protocal.d.sXk)
              {
                paramAnonymousDialogInterface = e.this.vbk.getString(R.l.eaK, new Object[] { "0x" + Integer.toHexString(com.tencent.mm.protocal.d.sXh), com.tencent.mm.sdk.platformtools.u.bID() });
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.MobileInputIndepPassLoginLogic", "url " + paramAnonymousDialogInterface);
                Intent localIntent = new Intent();
                localIntent.putExtra("rawUrl", paramAnonymousDialogInterface);
                localIntent.putExtra("showShare", false);
                localIntent.putExtra("show_bottom", false);
                localIntent.putExtra("needRedirect", false);
                localIntent.putExtra("neverGetA8Key", true);
                localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
                localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
                com.tencent.mm.plugin.c.a.imb.j(localIntent, e.this.vbk);
                GMTrace.o(16812246827008L, 125261);
                return;
              }
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("regsetinfo_ticket", ((s)paramk).Fv());
              paramAnonymousDialogInterface.putExtra("regsetinfo_user", e.this.hRY);
              paramAnonymousDialogInterface.putExtra("regsetinfo_ismobile", 1);
              paramAnonymousDialogInterface.putExtra("regsetinfo_NextControl", ((s)paramk).Fy());
              paramAnonymousDialogInterface.setClass(e.this.vbk, RegSetInfoUI.class);
              b.mN("R200_950_olduser");
              e.this.vbk.startActivity(paramAnonymousDialogInterface);
              b.mO(ap.uY() + "," + getClass().getName() + ",L200_900_phone," + ap.ec("L200_900_phone") + ",2");
              GMTrace.o(16812246827008L, 125261);
            }
          }, null);
          GMTrace.o(16809562472448L, 125241);
          return;
        }
        if (paramInt2 == -51)
        {
          paramString = com.tencent.mm.f.a.dn(paramString);
          if (paramString != null)
          {
            paramString.a(this.vbk, null, null);
            GMTrace.o(16809562472448L, 125241);
            return;
          }
          com.tencent.mm.ui.base.g.h(this.vbk, R.l.eIY, R.l.btk);
          GMTrace.o(16809562472448L, 125241);
          return;
        }
        if (p(paramInt1, paramInt2, paramString))
        {
          GMTrace.o(16809562472448L, 125241);
          return;
        }
      }
      GMTrace.o(16809562472448L, 125241);
      return;
    }
    if (paramk.getType() == 701)
    {
      this.fWO = ((com.tencent.mm.modelsimple.u)paramk).Ji();
      localObject = new f();
      ((f)localObject).uXf = ((com.tencent.mm.modelsimple.u)paramk).FK();
      ((f)localObject).uXh = ((com.tencent.mm.modelsimple.u)paramk).FJ();
      ((f)localObject).uXg = ((com.tencent.mm.modelsimple.u)paramk).Jk();
      ((f)localObject).uXi = ((com.tencent.mm.modelsimple.u)paramk).Jj();
      ((f)localObject).hRY = this.hRY;
      ((f)localObject).uXd = this.vbk.lhX.getText().toString();
      int j = 0;
      if (paramInt2 == -75)
      {
        m.bo(this.vbk);
        GMTrace.o(16809562472448L, 125241);
        return;
      }
      if (paramInt2 == -106)
      {
        m.E(this.vbk, paramString);
        GMTrace.o(16809562472448L, 125241);
        return;
      }
      if (paramInt2 == 65319)
      {
        m.a(this.vbk, com.tencent.mm.pluginsdk.a.a.a((com.tencent.mm.modelsimple.u)paramk), paramInt2);
        GMTrace.o(16809562472448L, 125241);
        return;
      }
      if (paramInt2 == 65331)
      {
        this.oTE = ((com.tencent.mm.modelsimple.u)paramk).Fw();
        paramString = ((com.tencent.mm.modelsimple.u)paramk).Jl();
        paramk = ((com.tencent.mm.modelsimple.u)paramk).Jo();
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bf.Qi(this.oTE), paramk });
        f.a((f)localObject);
        localObject = new Intent();
        ((Intent)localObject).putExtra("auth_ticket", this.oTE);
        ((Intent)localObject).putExtra("binded_mobile", paramString);
        ((Intent)localObject).putExtra("close_safe_device_style", paramk);
        ((Intent)localObject).putExtra("from_source", 6);
        com.tencent.mm.plugin.c.a.imb.f(this.vbk, (Intent)localObject);
        GMTrace.o(16809562472448L, 125241);
        return;
      }
      if (paramInt2 == 65396)
      {
        if (!bf.mA(this.fWO)) {
          m.j(this.vbk, paramString, this.fWO);
        }
        GMTrace.o(16809562472448L, 125241);
        return;
      }
      i = j;
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
              GMTrace.i(16807146553344L, 125223);
              if (paramAnonymouse == null)
              {
                GMTrace.o(16807146553344L, 125223);
                return;
              }
              paramAnonymouse = paramAnonymouse.Cc();
              ap.yY();
              int i = com.tencent.mm.u.c.uH();
              paramAnonymouse.i(new byte[0], i);
              GMTrace.o(16807146553344L, 125223);
            }
          }), 0);
        }
      }
      if ((paramInt2 == -6) || (paramInt2 == 65225) || (paramInt2 == 65226))
      {
        if (this.uSI == null)
        {
          this.uSI = SecurityImage.a.a(this.vbk, R.l.eJY, ((f)localObject).uXi, ((f)localObject).uXh, ((f)localObject).uXf, ((f)localObject).uXg, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(16815468052480L, 125285);
              com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + localObject.uXf + " img len" + localObject.uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.u(localObject.hRY, localObject.uXd, localObject.uXi, e.this.uSI.bRp(), e.this.uSI.uXf, e.this.uSI.uXg, 1, "", false, false);
              ap.vd().a(paramAnonymousDialogInterface, 0);
              MobileInputUI localMobileInputUI1 = e.this.vbk;
              MobileInputUI localMobileInputUI2 = e.this.vbk;
              e.this.vbk.getString(R.l.dIG);
              localMobileInputUI1.uWW = com.tencent.mm.ui.base.g.a(localMobileInputUI2, e.this.vbk.getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  GMTrace.i(16816810229760L, 125295);
                  ap.vd().c(paramAnonymousDialogInterface);
                  GMTrace.o(16816810229760L, 125295);
                }
              });
              GMTrace.o(16815468052480L, 125285);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              GMTrace.i(16816273358848L, 125291);
              e.this.uSI = null;
              GMTrace.o(16816273358848L, 125291);
            }
          }, (SecurityImage.b)localObject);
          GMTrace.o(16809562472448L, 125241);
          return;
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + ((f)localObject).uXf + " img len" + ((f)localObject).uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
        this.uSI.a(((f)localObject).uXi, ((f)localObject).uXh, ((f)localObject).uXf, ((f)localObject).uXg);
        GMTrace.o(16809562472448L, 125241);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        ap.unhold();
        m.mv(((f)localObject).hRY);
        com.tencent.mm.modelsimple.d.bc(this.vbk);
        m.a(this.vbk, new Runnable()
        {
          public final void run()
          {
            GMTrace.i(16809965125632L, 125244);
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
            Intent localIntent = com.tencent.mm.plugin.c.a.imb.ak(e.this.vbk);
            localIntent.addFlags(67108864);
            e.this.vbk.startActivity(localIntent);
            e.this.vbk.finish();
            GMTrace.o(16809965125632L, 125244);
          }
        }, false, 2);
        if (this.vbk.hlV == 6)
        {
          this.uWJ = ((com.tencent.mm.modelsimple.u)paramk).Jq();
          ap.vd().a(255, this);
          paramString = new com.tencent.mm.modelsimple.v(1);
          ap.vd().a(paramString, 0);
          paramk = this.vbk;
          localObject = this.vbk;
          this.vbk.getString(R.l.dIG);
          paramk.uWW = com.tencent.mm.ui.base.g.a((Context)localObject, this.vbk.getString(R.l.eSD), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              GMTrace.i(16814528528384L, 125278);
              ap.vd().c(paramString);
              ap.vd().b(255, e.this);
              GMTrace.o(16814528528384L, 125278);
            }
          });
        }
        GMTrace.o(16809562472448L, 125241);
        return;
      }
      if (p(paramInt1, paramInt2, paramString))
      {
        GMTrace.o(16809562472448L, 125241);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this.vbk, this.vbk.getString(R.l.ekZ, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      paramString = com.tencent.mm.f.a.dn(paramString);
      if ((paramString != null) && (this.vbk != null) && (paramString.a(this.vbk, null, null)))
      {
        GMTrace.o(16809562472448L, 125241);
        return;
      }
      GMTrace.o(16809562472448L, 125241);
      return;
    }
    if (paramk.getType() == 255)
    {
      ap.vd().b(255, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = this.vbk;
        boolean bool = this.uWJ;
        paramk = new Intent(paramString, RegByMobileSetPwdUI.class);
        paramk.putExtra("kintent_hint", paramString.getString(R.l.eSR));
        paramk.putExtra("kintent_cancelable", bool);
        paramString.startActivity(paramk);
      }
      GMTrace.o(16809562472448L, 125241);
      return;
    }
    GMTrace.o(16809562472448L, 125241);
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    GMTrace.i(16808622948352L, 125234);
    this.vbk = paramMobileInputUI;
    paramMobileInputUI.vbA.setVisibility(0);
    this.hRY = paramMobileInputUI.getIntent().getStringExtra("binded_mobile");
    if (bf.mA(this.hRY)) {
      this.hRY = am.PA(paramMobileInputUI.vbC + paramMobileInputUI.ory);
    }
    paramMobileInputUI.vbw.setTextColor(paramMobileInputUI.getResources().getColor(R.e.aUo));
    paramMobileInputUI.vbw.setEnabled(false);
    paramMobileInputUI.vbw.setFocusable(false);
    paramMobileInputUI.vbv.setFocusable(false);
    paramMobileInputUI.vbv.setText(am.PA(this.hRY));
    paramMobileInputUI.vbv.setVisibility(0);
    aRA();
    paramMobileInputUI.vbB.setVisibility(0);
    paramMobileInputUI.uYb.setText(R.l.ewK);
    paramMobileInputUI.uYb.setVisibility(0);
    paramMobileInputUI.uYb.setEnabled(true);
    this.oTE = paramMobileInputUI.getIntent().getStringExtra("auth_ticket");
    if (!bf.mA(this.oTE)) {
      new ad().postDelayed(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(16813991657472L, 125274);
          e.this.eS(f.bQG(), f.bQH());
          GMTrace.o(16813991657472L, 125274);
        }
      }, 500L);
    }
    GMTrace.o(16808622948352L, 125234);
  }
  
  public final void aRA()
  {
    GMTrace.i(16808757166080L, 125235);
    if (this.vbk.hlV == 6)
    {
      this.vbk.vbx.reset();
      this.vbk.vbB.setText(R.l.ewM);
      this.vbk.uXr.setVisibility(8);
      this.vbk.vbx.setVisibility(0);
      this.vbk.vbx.oAr.requestFocus();
      this.vbk.vbx.vhM = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16806207029248L, 125216);
          com.tencent.mm.ui.base.g.a(e.this.vbk, e.this.vbk.getString(R.l.eJN) + e.this.hRY, e.this.vbk.getString(R.l.eJO), e.this.vbk.getString(R.l.dHL), e.this.vbk.getString(R.l.dGk), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GMTrace.i(16813723222016L, 125272);
              e.this.vbk.vbx.bRI();
              e.this.SQ(e.this.hRY);
              GMTrace.o(16813723222016L, 125272);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GMTrace.i(16813454786560L, 125270);
              e.this.vbk.vbx.reset();
              GMTrace.o(16813454786560L, 125270);
            }
          });
          GMTrace.o(16806207029248L, 125216);
        }
      };
      this.vbk.vbB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16808220295168L, 125231);
          e.this.vbk.niS[1] = 2;
          e.this.vbk.hlV = 7;
          e.this.vbk.vbx.reset();
          ap.vd().b(145, e.this);
          e.this.aRA();
          GMTrace.o(16808220295168L, 125231);
        }
      });
      GMTrace.o(16808757166080L, 125235);
      return;
    }
    if (this.vbk.hlV == 7)
    {
      this.vbk.vbB.setText(R.l.ewN);
      this.vbk.uXr.setVisibility(0);
      this.vbk.lhX.requestFocus();
      this.vbk.vbx.setVisibility(8);
      this.vbk.vbB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16815199617024L, 125283);
          e.this.vbk.niS[1] = 1;
          e.this.vbk.hlV = 6;
          ap.vd().a(145, e.this);
          e.this.aRA();
          GMTrace.o(16815199617024L, 125283);
        }
      });
    }
    GMTrace.o(16808757166080L, 125235);
  }
  
  public final void eS(final String paramString1, String paramString2)
  {
    GMTrace.i(16809428254720L, 125240);
    if (bf.mA(paramString1))
    {
      com.tencent.mm.ui.base.g.h(this.vbk, R.l.eZS, R.l.ewF);
      GMTrace.o(16809428254720L, 125240);
      return;
    }
    if (bf.mA(paramString2))
    {
      com.tencent.mm.ui.base.g.h(this.vbk, R.l.eZP, R.l.ewF);
      GMTrace.o(16809428254720L, 125240);
      return;
    }
    this.vbk.lhX.setText(paramString2);
    this.vbk.aGY();
    paramString1 = new com.tencent.mm.modelsimple.u(paramString1, paramString2, null, 1);
    ap.vd().a(paramString1, 0);
    paramString2 = this.vbk;
    MobileInputUI localMobileInputUI = this.vbk;
    this.vbk.getString(R.l.dIG);
    paramString2.uWW = com.tencent.mm.ui.base.g.a(localMobileInputUI, this.vbk.getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(16810501996544L, 125248);
        ap.vd().c(paramString1);
        GMTrace.o(16810501996544L, 125248);
      }
    });
    GMTrace.o(16809428254720L, 125240);
  }
  
  public final void start()
  {
    GMTrace.i(16808891383808L, 125236);
    ap.vd().a(701, this);
    ap.vd().a(145, this);
    b.b(true, ap.uY() + "," + getClass().getName() + ",L200_100," + ap.ec("L200_100") + ",1");
    b.mM("L200_100");
    GMTrace.o(16808891383808L, 125236);
  }
  
  public final void stop()
  {
    GMTrace.i(16809025601536L, 125237);
    ap.vd().b(701, this);
    ap.vd().b(145, this);
    b.b(false, ap.uY() + "," + getClass().getName() + ",L200_100," + ap.ec("L200_100") + ",2");
    GMTrace.o(16809025601536L, 125237);
  }
  
  public final void zy(int paramInt)
  {
    GMTrace.i(16809159819264L, 125238);
    switch (9.vbm[(paramInt - 1)])
    {
    }
    for (;;)
    {
      GMTrace.o(16809159819264L, 125238);
      return;
      this.vbk.vbC = am.PC(this.vbk.countryCode);
      this.vbk.ory = this.vbk.vbw.getText().toString();
      if ((bf.mA(this.vbk.vbC)) || (bf.mA(this.vbk.ory)))
      {
        GMTrace.o(16809159819264L, 125238);
        return;
      }
      if (this.vbk.hlV == 7)
      {
        eS(this.hRY, this.vbk.lhX.getText().toString());
        GMTrace.o(16809159819264L, 125238);
        return;
      }
      if (this.vbk.hlV == 6)
      {
        final Object localObject = this.vbk.vbx.getText().toString().trim();
        if (bf.mA((String)localObject))
        {
          com.tencent.mm.ui.base.g.h(this.vbk, R.l.eZR, R.l.ewF);
          GMTrace.o(16809159819264L, 125238);
          return;
        }
        this.vbk.aGY();
        localObject = new s(this.hRY, 17, (String)localObject, 0, "");
        ap.vd().a((k)localObject, 0);
        MobileInputUI localMobileInputUI1 = this.vbk;
        MobileInputUI localMobileInputUI2 = this.vbk;
        this.vbk.getString(R.l.dIG);
        localMobileInputUI1.uWW = com.tencent.mm.ui.base.g.a(localMobileInputUI2, this.vbk.getString(R.l.dNU), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(16812515262464L, 125263);
            ap.vd().c(localObject);
            GMTrace.o(16812515262464L, 125263);
          }
        });
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/mobile/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */