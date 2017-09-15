package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.il;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.j.p;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.RegByMobileRegAIOUI;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.account.RegSetInfoUI;
import com.tencent.mm.ui.account.f;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.io.File;

public class MobileLoginOrForceReg
  extends MMActivity
  implements com.tencent.mm.y.e
{
  private String fER;
  private String fGM;
  private String fOz;
  private String fWO;
  private int hSt;
  private ad handler;
  private String iLH;
  private ImageView ipb;
  protected ProgressDialog isb;
  private TextView jUr;
  private String lMD;
  private SecurityImage uSI;
  private String uSu;
  private c uVQ;
  private com.tencent.mm.pluginsdk.j.a uWD;
  private f uWv;
  private String username;
  private Button vbK;
  private Button vbL;
  private LinearLayout vbM;
  private LinearLayout vbN;
  private TextView vbO;
  private int vbP;
  private boolean vbQ;
  private boolean vbR;
  private String vbS;
  private String vbT;
  private a vbn;
  
  public MobileLoginOrForceReg()
  {
    GMTrace.i(2615903518720L, 19490);
    this.isb = null;
    this.vbn = null;
    this.vbQ = true;
    this.handler = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(2603958140928L, 19401);
        if (paramAnonymousMessage.obj != null)
        {
          paramAnonymousMessage = (Bitmap)paramAnonymousMessage.obj;
          MobileLoginOrForceReg.a(MobileLoginOrForceReg.this).setImageBitmap(paramAnonymousMessage);
        }
        GMTrace.o(2603958140928L, 19401);
      }
    };
    this.uSI = null;
    this.uVQ = new c() {};
    this.uWv = null;
    GMTrace.o(2615903518720L, 19490);
  }
  
  private void goBack()
  {
    GMTrace.i(2616843042816L, 19497);
    com.tencent.mm.plugin.c.b.mN("R200_100");
    com.tencent.mm.u.bf.zK();
    Intent localIntent = new Intent(this, RegByMobileRegAIOUI.class);
    localIntent.putExtra("mobile_input_purpose", 2);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    com.tencent.mm.plugin.c.b.mM(this.uSu);
    com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",R200_600," + ap.ec("R200_600") + ",2");
    finish();
    GMTrace.o(2616843042816L, 19497);
  }
  
  public final void KD()
  {
    GMTrace.i(2616171954176L, 19492);
    this.vbK = ((Button)findViewById(R.h.bGz));
    this.vbL = ((Button)findViewById(R.h.bQR));
    this.vbM = ((LinearLayout)findViewById(R.h.bVF));
    this.vbN = ((LinearLayout)findViewById(R.h.cnX));
    this.ipb = ((ImageView)findViewById(R.h.bqF));
    this.jUr = ((TextView)findViewById(R.h.cnW));
    this.vbO = ((TextView)findViewById(R.h.bth));
    new am();
    final Object localObject;
    if (this.fOz.startsWith("+"))
    {
      localObject = am.yS(this.fOz);
      if (!com.tencent.mm.sdk.platformtools.bf.mA((String)localObject))
      {
        String str = this.fOz.substring(((String)localObject).length() + 1);
        localObject = "+" + (String)localObject + " " + am.formatNumber((String)localObject, str);
      }
    }
    for (;;)
    {
      this.vbO.setText((CharSequence)localObject);
      if ((!com.tencent.mm.sdk.platformtools.bf.mA(this.fER)) || (!com.tencent.mm.sdk.platformtools.bf.mA(this.iLH))) {
        break;
      }
      this.vbN.setVisibility(0);
      this.vbM.setVisibility(8);
      this.vbK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2620198486016L, 19522);
          MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, new a(new a.a()
          {
            public final void a(ProgressDialog paramAnonymous2ProgressDialog)
            {
              GMTrace.i(2611742769152L, 19459);
              MobileLoginOrForceReg.this.isb = paramAnonymous2ProgressDialog;
              GMTrace.o(2611742769152L, 19459);
            }
          }, MobileLoginOrForceReg.c(MobileLoginOrForceReg.this), MobileLoginOrForceReg.d(MobileLoginOrForceReg.this), MobileLoginOrForceReg.e(MobileLoginOrForceReg.this)));
          MobileLoginOrForceReg.f(MobileLoginOrForceReg.this).h(MobileLoginOrForceReg.this);
          GMTrace.o(2620198486016L, 19522);
        }
      });
      this.vbL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2607045148672L, 19424);
          if (MobileLoginOrForceReg.g(MobileLoginOrForceReg.this) == null)
          {
            paramAnonymousView = new Intent();
            com.tencent.mm.plugin.c.b.mN("R200_900_phone");
            paramAnonymousView.putExtra("regsetinfo_ticket", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this));
            paramAnonymousView.putExtra("regsetinfo_user", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this));
            paramAnonymousView.putExtra("regsetinfo_ismobile", 1);
            paramAnonymousView.putExtra("regsetinfo_isForce", true);
            paramAnonymousView.putExtra("regsetinfo_NextControl", MobileLoginOrForceReg.i(MobileLoginOrForceReg.this));
            paramAnonymousView.setClass(MobileLoginOrForceReg.this, RegSetInfoUI.class);
            MobileLoginOrForceReg.this.startActivity(paramAnonymousView);
            GMTrace.o(2607045148672L, 19424);
            return;
          }
          MobileLoginOrForceReg.j(MobileLoginOrForceReg.this);
          GMTrace.o(2607045148672L, 19424);
        }
      });
      zd(R.l.eAV);
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2587583578112L, 19279);
          MobileLoginOrForceReg.k(MobileLoginOrForceReg.this);
          GMTrace.o(2587583578112L, 19279);
          return false;
        }
      });
      GMTrace.o(2616171954176L, 19492);
      return;
      localObject = this.fOz;
      continue;
      localObject = "+86 " + am.formatNumber("86", this.fOz);
    }
    this.vbN.setVisibility(8);
    this.vbM.setVisibility(0);
    if (com.tencent.mm.sdk.platformtools.bf.mA(this.fER)) {
      this.jUr.setVisibility(8);
    }
    for (;;)
    {
      localObject = a.b.bDS().nZ();
      if (localObject != null) {
        this.ipb.setImageBitmap((Bitmap)localObject);
      }
      if (com.tencent.mm.sdk.platformtools.bf.mA(this.iLH)) {
        break;
      }
      localObject = this.iLH;
      ap.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2592012763136L, 19312);
          Object localObject = null;
          try
          {
            Bitmap localBitmap = d.decodeStream(com.tencent.mm.network.b.k(localObject, 10000, 20000));
            localObject = localBitmap;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.v.e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
              com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicorMsg.MobileLoginOrForceReg", localException, "", new Object[0]);
            }
          }
          MobileLoginOrForceReg.b(MobileLoginOrForceReg.this).sendMessage(MobileLoginOrForceReg.b(MobileLoginOrForceReg.this).obtainMessage(0, localObject));
          GMTrace.o(2592012763136L, 19312);
        }
        
        public final String toString()
        {
          GMTrace.i(2592146980864L, 19313);
          String str = super.toString() + "|loadBitmap";
          GMTrace.o(2592146980864L, 19313);
          return str;
        }
      });
      break;
      this.jUr.setText(this.fER);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, final String paramString, final k paramk)
  {
    GMTrace.i(2617111478272L, 19499);
    if (this.isb != null)
    {
      this.isb.dismiss();
      this.isb = null;
    }
    if (this.uWv == null) {
      this.uWv = new f();
    }
    boolean bool;
    if (paramk.getType() == 255)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        bool = this.vbQ;
        paramString = new Intent(this, RegByMobileSetPwdUI.class);
        paramString.putExtra("kintent_hint", getString(R.l.eSR));
        paramString.putExtra("kintent_cancelable", bool);
        startActivityForResult(paramString, 0);
      }
      GMTrace.o(2617111478272L, 19499);
      return;
    }
    if ((paramk.getType() == 701) && (this.vbn != null))
    {
      if ((paramInt2 == -6) || (paramInt2 == 65225) || (paramInt2 == 65226))
      {
        this.uWv.hRY = this.username;
        this.uWv.uXe = this.vbT;
        this.uWv.uXf = ((u)paramk).FK();
        this.uWv.uXh = ((u)paramk).FJ();
        this.uWv.uXg = ((u)paramk).Jk();
        this.uWv.uXi = ((u)paramk).Jj();
        if (this.uSI == null)
        {
          this.uSI = SecurityImage.a.a(this, R.l.eJY, this.uWv.uXi, this.uWv.uXh, this.uWv.uXf, this.uWv.uXg, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(2601408004096L, 19382);
              com.tencent.mm.sdk.platformtools.v.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + MobileLoginOrForceReg.l(MobileLoginOrForceReg.this).uXf + " img len" + MobileLoginOrForceReg.l(MobileLoginOrForceReg.this).uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
              paramAnonymousDialogInterface = new u(MobileLoginOrForceReg.l(MobileLoginOrForceReg.this).hRY, MobileLoginOrForceReg.l(MobileLoginOrForceReg.this).uXe, MobileLoginOrForceReg.l(MobileLoginOrForceReg.this).uXi, MobileLoginOrForceReg.m(MobileLoginOrForceReg.this).bRp(), MobileLoginOrForceReg.m(MobileLoginOrForceReg.this).uXf, MobileLoginOrForceReg.m(MobileLoginOrForceReg.this).uXg, 1, "", false, true);
              ap.vd().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              MobileLoginOrForceReg.this.getString(R.l.dIG);
              com.tencent.mm.ui.base.g.a(localMobileLoginOrForceReg, MobileLoginOrForceReg.this.getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  GMTrace.i(2603152834560L, 19395);
                  ap.vd().c(paramAnonymousDialogInterface);
                  GMTrace.o(2603152834560L, 19395);
                }
              });
              GMTrace.o(2601408004096L, 19382);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              GMTrace.i(2613890252800L, 19475);
              MobileLoginOrForceReg.n(MobileLoginOrForceReg.this);
              GMTrace.o(2613890252800L, 19475);
            }
          }, this.uWv);
          GMTrace.o(2617111478272L, 19499);
          return;
        }
        this.uSI.a(this.uWv.uXi, this.uWv.uXh, this.uWv.uXf, this.uWv.uXg);
        GMTrace.o(2617111478272L, 19499);
        return;
      }
      this.fWO = ((u)paramk).Ji();
      this.vbn.a(this, paramInt1, paramInt2, paramString, paramk);
      if ((paramk instanceof u)) {
        this.vbQ = ((u)paramk).Jq();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new com.tencent.mm.modelsimple.v(1);
        ap.vd().a(paramString, 0);
        getString(R.l.dIG);
        this.isb = com.tencent.mm.ui.base.g.a(this, getString(R.l.eSD), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(2610266374144L, 19448);
            ap.vd().c(paramString);
            GMTrace.o(2610266374144L, 19448);
          }
        });
      }
      GMTrace.o(2617111478272L, 19499);
      return;
    }
    final Object localObject2;
    if (paramk.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == 65225) || (paramInt2 == 65226))
      {
        paramString = Boolean.valueOf(this.vbR);
        localObject1 = this.vbT;
        localObject2 = this.vbS;
        if (this.uSI == null)
        {
          this.uSI = SecurityImage.a.a(this, R.l.eJY, 0, ((w)paramk).FJ(), ((w)paramk).FK(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(2600602697728L, 19376);
              paramAnonymousDialogInterface = new w("", localObject1, localObject2, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.o(MobileLoginOrForceReg.this), "", ((w)paramk).FK(), MobileLoginOrForceReg.m(MobileLoginOrForceReg.this).bRp(), true, paramString.booleanValue());
              ap.vd().a(paramAnonymousDialogInterface, 0);
              MobileLoginOrForceReg localMobileLoginOrForceReg = MobileLoginOrForceReg.this;
              ActionBarActivity localActionBarActivity = MobileLoginOrForceReg.this.uRf.uRz;
              MobileLoginOrForceReg.this.getString(R.l.dIG);
              localMobileLoginOrForceReg.isb = com.tencent.mm.ui.base.g.a(localActionBarActivity, MobileLoginOrForceReg.this.getString(R.l.eJX), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  GMTrace.i(2600871133184L, 19378);
                  ap.vd().c(paramAnonymousDialogInterface);
                  GMTrace.o(2600871133184L, 19378);
                }
              });
              GMTrace.o(2600602697728L, 19376);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              GMTrace.i(2598589431808L, 19361);
              MobileLoginOrForceReg.n(MobileLoginOrForceReg.this);
              GMTrace.o(2598589431808L, 19361);
            }
          }, new SecurityImage.b()
          {
            public final void bQy()
            {
              GMTrace.i(2591073239040L, 19305);
              MobileLoginOrForceReg.this.aGY();
              w localw = new w("", localObject1, localObject2, 0, "", MobileLoginOrForceReg.e(MobileLoginOrForceReg.this), "", "", MobileLoginOrForceReg.h(MobileLoginOrForceReg.this), MobileLoginOrForceReg.o(MobileLoginOrForceReg.this), "", ((w)paramk).FK(), "", true, paramString.booleanValue());
              ap.vd().a(localw, 0);
              GMTrace.o(2591073239040L, 19305);
            }
          });
          GMTrace.o(2617111478272L, 19499);
          return;
        }
        this.uSI.a(0, ((w)paramk).FJ(), ((w)paramk).FK(), "");
        GMTrace.o(2617111478272L, 19499);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = this.fOz;
        bool = this.vbR;
        ap.unhold();
        ap.aT(true);
        if (!Boolean.valueOf(bool).booleanValue()) {
          break label873;
        }
        localObject2 = com.tencent.mm.compatible.util.e.gSw + "temp.avatar";
        String str = com.tencent.mm.compatible.util.e.gSw + "temp.avatar.hd";
        new File((String)localObject2).renameTo(new File(str));
        com.tencent.mm.loader.stub.b.deleteFile((String)localObject2);
        d.b(str, 96, 96, Bitmap.CompressFormat.JPEG, 90, (String)localObject2);
        new o(this, com.tencent.mm.compatible.util.e.gSw + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            GMTrace.i(2596576165888L, 19346);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((w)paramk).Jr());
            ao.hlE.L("login_user_name", localObject1);
            com.tencent.mm.loader.stub.b.deleteFile(com.tencent.mm.compatible.util.e.gSw + "temp.avatar");
            Intent localIntent = com.tencent.mm.plugin.c.a.imb.ak(MobileLoginOrForceReg.this);
            localIntent.addFlags(67108864);
            MobileLoginOrForceReg.this.startActivity(localIntent);
            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_600," + ap.ec("R200_600") + ",4");
            MobileLoginOrForceReg.this.finish();
            GMTrace.o(2596576165888L, 19346);
          }
        }, new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2589194190848L, 19291);
            MobileLoginOrForceReg.a(MobileLoginOrForceReg.this, ((w)paramk).Jr());
            ao.hlE.L("login_user_name", localObject1);
            Intent localIntent = com.tencent.mm.plugin.c.a.imb.ak(MobileLoginOrForceReg.this);
            localIntent.addFlags(67108864);
            MobileLoginOrForceReg.this.startActivity(localIntent);
            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_600," + ap.ec("R200_600") + ",4");
            MobileLoginOrForceReg.this.finish();
            GMTrace.o(2589194190848L, 19291);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.f.a.dn(paramString);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.f.a)localObject1).a(this, null, null);
        GMTrace.o(2617111478272L, 19499);
        return;
        label873:
        this.fGM = ((w)paramk).Jr();
        ao.hlE.L("login_user_name", (String)localObject1);
        localObject1 = com.tencent.mm.plugin.c.a.imb.ak(this);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
        startActivity((Intent)localObject1);
        finish();
        com.tencent.mm.plugin.c.b.mN("RE900_100");
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",R200_600," + ap.ec("R200_600") + ",4");
      }
    }
    final Object localObject1 = new p(paramInt1, paramInt2, paramString);
    int i;
    if (this.uWD.a(this, (p)localObject1)) {
      i = 1;
    }
    while (i != 0)
    {
      GMTrace.o(2617111478272L, 19499);
      return;
      i = 0;
      switch (paramInt2)
      {
      default: 
        break;
      case -140: 
        if (!com.tencent.mm.sdk.platformtools.bf.mA(this.fWO)) {
          m.j(this.uRf.uRz, paramString, this.fWO);
        }
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, R.l.dNq, 0).show();
        i = 1;
        break;
      case -43: 
        Toast.makeText(this, R.l.dNn, 0).show();
        i = 1;
        break;
      case -41: 
        Toast.makeText(this, R.l.dNp, 0).show();
        i = 1;
        break;
      case -36: 
        Toast.makeText(this, R.l.dNs, 0).show();
        i = 1;
        break;
      case -32: 
        com.tencent.mm.ui.base.g.a(this, getString(R.l.dNZ), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2608118890496L, 19432);
            GMTrace.o(2608118890496L, 19432);
          }
        });
        i = 1;
        break;
      case -33: 
        com.tencent.mm.ui.base.g.a(this, R.l.dNX, R.l.btk, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2625835630592L, 19564);
            GMTrace.o(2625835630592L, 19564);
          }
        });
        i = 1;
        break;
      case -75: 
        com.tencent.mm.ui.base.g.h(this, R.l.dCW, R.l.eIT);
        i = 1;
        break;
      case -100: 
        ap.hold();
        localObject2 = this.uRf.uRz;
        if (TextUtils.isEmpty(ap.uI())) {}
        for (localObject1 = com.tencent.mm.bg.a.V(this.uRf.uRz, R.l.eza);; localObject1 = ap.uI())
        {
          com.tencent.mm.ui.base.g.a((Context)localObject2, (String)localObject1, this.uRf.uRz.getString(R.l.dIG), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(2597247254528L, 19351);
              GMTrace.o(2597247254528L, 19351);
            }
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              GMTrace.i(2585838747648L, 19266);
              GMTrace.o(2585838747648L, 19266);
            }
          });
          i = 1;
          break;
        }
      }
    }
    if (paramk.getType() == 701)
    {
      paramString = com.tencent.mm.f.a.dn(paramString);
      if ((paramString != null) && (paramString.a(this.uRf.uRz, null, null)))
      {
        GMTrace.o(2617111478272L, 19499);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.uRf.uRz, getString(R.l.dNW, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    GMTrace.o(2617111478272L, 19499);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2616708825088L, 19496);
    int i = R.i.djo;
    GMTrace.o(2616708825088L, 19496);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2616037736448L, 19491);
    super.onCreate(paramBundle);
    this.uSu = com.tencent.mm.plugin.c.b.OA();
    ap.vd().a(701, this);
    ap.vd().a(126, this);
    ap.vd().a(255, this);
    this.fGM = getIntent().getStringExtra("ticket");
    this.fOz = getIntent().getStringExtra("moble");
    this.vbP = getIntent().getIntExtra("next_controll", 0);
    this.username = getIntent().getStringExtra("username");
    this.lMD = getIntent().getStringExtra("password");
    this.fER = getIntent().getStringExtra("nickname");
    this.iLH = getIntent().getStringExtra("avatar_url");
    this.vbR = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.vbS = getIntent().getStringExtra("kintent_nickname");
    this.vbT = getIntent().getStringExtra("kintent_password");
    if ((this.vbT != null) && (this.vbT.length() >= 8)) {}
    for (this.hSt = 1;; this.hSt = 4)
    {
      KD();
      this.uWD = new com.tencent.mm.pluginsdk.j.a();
      GMTrace.o(2616037736448L, 19491);
      return;
    }
  }
  
  public void onDestroy()
  {
    GMTrace.i(2616574607360L, 19495);
    ap.vd().b(701, this);
    ap.vd().b(126, this);
    ap.vd().b(255, this);
    if (this.uWD != null) {
      this.uWD.close();
    }
    super.onDestroy();
    GMTrace.o(2616574607360L, 19495);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2616977260544L, 19498);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      GMTrace.o(2616977260544L, 19498);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2616977260544L, 19498);
    return bool;
  }
  
  public void onPause()
  {
    GMTrace.i(2616440389632L, 19494);
    super.onPause();
    com.tencent.mm.sdk.b.a.uql.c(this.uVQ);
    GMTrace.o(2616440389632L, 19494);
  }
  
  public void onResume()
  {
    GMTrace.i(2616306171904L, 19493);
    com.tencent.mm.sdk.b.a.uql.b(this.uVQ);
    super.onResume();
    com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_600," + ap.ec("R200_600") + ",1");
    com.tencent.mm.plugin.c.b.mM("R200_600");
    GMTrace.o(2616306171904L, 19493);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/mobile/MobileLoginOrForceReg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */