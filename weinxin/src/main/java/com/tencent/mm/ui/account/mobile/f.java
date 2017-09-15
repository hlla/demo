package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class f
  implements MobileVerifyUI.b, e
{
  public SecurityImage uSI;
  public com.tencent.mm.ui.account.f uWv;
  private a vbn;
  public MobileVerifyUI vcb;
  
  public f()
  {
    GMTrace.i(2631338557440L, 19605);
    this.vbn = null;
    this.uSI = null;
    this.uWv = null;
    GMTrace.o(2631338557440L, 19605);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2632009646080L, 19610);
    v.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.vcb.isb != null)
    {
      this.vcb.isb.dismiss();
      this.vcb.isb = null;
    }
    if (this.uWv == null) {
      this.uWv = new com.tencent.mm.ui.account.f();
    }
    if ((paramk.getType() == 701) && (this.vbn != null))
    {
      ap.vd().b(701, this);
      this.uWv.uXf = ((u)paramk).FK();
      this.uWv.uXh = ((u)paramk).FJ();
      this.uWv.uXg = ((u)paramk).Jk();
      this.uWv.uXi = ((u)paramk).Jj();
      if ((paramInt2 == -6) || (paramInt2 == 65225) || (paramInt2 == 65226))
      {
        ap.vd().a(701, this);
        if (this.uSI == null)
        {
          this.uSI = SecurityImage.a.a(this.vcb, R.l.eJY, this.uWv.uXi, this.uWv.uXh, this.uWv.uXf, this.uWv.uXg, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(2627714678784L, 19578);
              v.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + f.this.uWv.uXf + " img len" + f.this.uWv.uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
              paramAnonymousDialogInterface = new u(f.this.uWv.hRY, f.this.uWv.uXe, f.this.uWv.uXi, f.this.uSI.bRp(), f.this.uSI.uXf, f.this.uSI.uXg, 1, "", false, true);
              ap.vd().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI = f.this.vcb;
              f.this.vcb.getString(R.l.dIG);
              com.tencent.mm.ui.base.g.a(localMobileVerifyUI, f.this.vcb.getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  GMTrace.i(2583557046272L, 19249);
                  ap.vd().c(paramAnonymousDialogInterface);
                  ap.vd().b(701, f.this);
                  GMTrace.o(2583557046272L, 19249);
                }
              });
              GMTrace.o(2627714678784L, 19578);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              GMTrace.i(2590536368128L, 19301);
              f.this.uSI = null;
              GMTrace.o(2590536368128L, 19301);
            }
          }, this.uWv);
          GMTrace.o(2632009646080L, 19610);
          return;
        }
        v.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.uWv.uXf + " img len" + this.uWv.uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
        this.uSI.a(this.uWv.uXi, this.uWv.uXh, this.uWv.uXf, this.uWv.uXg);
        GMTrace.o(2632009646080L, 19610);
        return;
      }
      this.vbn.a(this.vcb, paramInt1, paramInt2, paramString, paramk);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        boolean bool = true;
        if ((paramk instanceof u)) {
          bool = ((u)paramk).Jq();
        }
        this.vcb.kB(bool);
      }
      GMTrace.o(2632009646080L, 19610);
      return;
    }
    if (paramk.getType() == 145)
    {
      this.uWv.hRY = ((s)paramk).getUsername();
      this.uWv.uXe = ((s)paramk).Fu();
      ap.vd().b(145, this);
      if (((s)paramk).AJ() != 9)
      {
        GMTrace.o(2632009646080L, 19610);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ap.vd().a(701, this);
        this.vbn = new a(new a.a()
        {
          public final void a(ProgressDialog paramAnonymousProgressDialog)
          {
            GMTrace.i(2587046707200L, 19275);
            f.this.vcb.isb = paramAnonymousProgressDialog;
            GMTrace.o(2587046707200L, 19275);
          }
        }, ((s)paramk).getUsername(), ((s)paramk).Fu(), this.vcb.fOz);
        this.vbn.h(this.vcb);
        GMTrace.o(2632009646080L, 19610);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.f.a.dn(paramString);
        if (paramString != null)
        {
          paramString.a(this.vcb, null, null);
          GMTrace.o(2632009646080L, 19610);
          return;
        }
        com.tencent.mm.ui.base.g.h(this.vcb, R.l.dNX, R.l.btk);
        GMTrace.o(2632009646080L, 19610);
        return;
      }
    }
    if (this.vcb.p(paramInt1, paramInt2, paramString))
    {
      GMTrace.o(2632009646080L, 19610);
      return;
    }
    if (paramk.getType() == 701)
    {
      paramString = com.tencent.mm.f.a.dn(paramString);
      if ((paramString != null) && (paramString.a(this.vcb, null, null)))
      {
        GMTrace.o(2632009646080L, 19610);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.vcb, this.vcb.getString(R.l.dNW, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    GMTrace.o(2632009646080L, 19610);
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    GMTrace.i(2631472775168L, 19606);
    this.vcb = paramMobileVerifyUI;
    GMTrace.o(2631472775168L, 19606);
  }
  
  public final void start()
  {
    GMTrace.i(2631606992896L, 19607);
    b.b(true, ap.uY() + "," + getClass().getName() + ",F200_300," + ap.ec("F200_300") + ",1");
    b.mM("F200_300");
    GMTrace.o(2631606992896L, 19607);
  }
  
  public final void stop()
  {
    GMTrace.i(2631741210624L, 19608);
    int i = 2;
    if (this.vcb.vcC != -1) {
      i = this.vcb.vcC;
    }
    b.b(false, ap.uY() + "," + getClass().getName() + ",F200_300," + ap.ec("F200_300") + "," + i);
    GMTrace.o(2631741210624L, 19608);
  }
  
  public final boolean zz(int paramInt)
  {
    GMTrace.i(2631875428352L, 19609);
    switch (6.vce[(paramInt - 1)])
    {
    }
    for (;;)
    {
      GMTrace.o(2631875428352L, 19609);
      return false;
      ap.vd().a(145, this);
      final s locals = new s(this.vcb.fOz, 9, this.vcb.vaW.getText().toString().trim(), 0, "");
      ap.vd().a(locals, 0);
      MobileVerifyUI localMobileVerifyUI1 = this.vcb;
      MobileVerifyUI localMobileVerifyUI2 = this.vcb;
      this.vcb.getString(R.l.dIG);
      localMobileVerifyUI1.isb = com.tencent.mm.ui.base.g.a(localMobileVerifyUI2, this.vcb.getString(R.l.dNU), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(2610803245056L, 19452);
          ap.vd().c(locals);
          ap.vd().b(145, f.this);
          GMTrace.o(2610803245056L, 19452);
        }
      });
      continue;
      b.mO(ap.uY() + "," + getClass().getName() + ",R200_400," + ap.ec("R200_400") + ",1");
      ap.vd().a(145, this);
      locals = new s(this.vcb.fOz, 8, "", 0, "");
      ap.vd().a(locals, 0);
      continue;
      b.mO(ap.uY() + "," + getClass().getName() + ",R200_350_auto," + ap.ec("R200_350_auto") + ",1");
      ap.vd().a(145, this);
      locals = new s(this.vcb.fOz, 9, this.vcb.vaW.getText().toString().trim(), 0, "");
      ap.vd().a(locals, 0);
      localMobileVerifyUI1 = this.vcb;
      localMobileVerifyUI2 = this.vcb;
      this.vcb.getString(R.l.dIG);
      localMobileVerifyUI1.isb = com.tencent.mm.ui.base.g.a(localMobileVerifyUI2, this.vcb.getString(R.l.dNU), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(2619930050560L, 19520);
          ap.vd().c(locals);
          ap.vd().b(145, f.this);
          GMTrace.o(2619930050560L, 19520);
        }
      });
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/mobile/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */