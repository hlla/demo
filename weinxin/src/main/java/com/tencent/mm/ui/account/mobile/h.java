package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.accountsync.a.c;
import com.tencent.mm.plugin.accountsync.a.c.a;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.RegSetInfoUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.bindmobile.FindMContactAlertUI;
import com.tencent.mm.ui.bindmobile.FindMContactIntroUI;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.io.File;
import java.util.Map;

public final class h
  implements MobileVerifyUI.b, com.tencent.mm.y.e
{
  public String kuu;
  public a vbn;
  public MobileVerifyUI vcb;
  public String vci;
  private boolean vcj;
  
  public h()
  {
    GMTrace.i(2581543780352L, 19234);
    this.vbn = null;
    this.vcj = true;
    GMTrace.o(2581543780352L, 19234);
  }
  
  public final void a(int paramInt1, int paramInt2, final String paramString, final k paramk)
  {
    GMTrace.i(2582214868992L, 19239);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.vcb.isb != null)
    {
      this.vcb.isb.dismiss();
      this.vcb.isb = null;
    }
    if (paramk.getType() == 255)
    {
      ap.vd().b(255, this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        this.vcb.kB(this.vcj);
      }
      GMTrace.o(2582214868992L, 19239);
      return;
    }
    final Object localObject1;
    if ((paramk.getType() == 701) && (this.vbn != null))
    {
      ap.vd().b(701, this);
      this.vbn.a(this.vcb, paramInt1, paramInt2, paramString, paramk);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramk instanceof u)) {
          this.vcj = ((u)paramk).Jq();
        }
        ap.vd().a(255, this);
        paramString = new com.tencent.mm.modelsimple.v(1);
        ap.vd().a(paramString, 0);
        paramk = this.vcb;
        localObject1 = this.vcb;
        this.vcb.getString(R.l.dIG);
        paramk.isb = g.a((Context)localObject1, this.vcb.getString(R.l.eSD), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(2632278081536L, 19612);
            ap.vd().c(paramString);
            GMTrace.o(2632278081536L, 19612);
          }
        });
      }
      GMTrace.o(2582214868992L, 19239);
      return;
    }
    int i;
    final Object localObject2;
    final String str2;
    Object localObject4;
    final String str1;
    final int j;
    String str3;
    boolean bool2;
    final boolean bool1;
    Object localObject3;
    if (paramk.getType() == 145)
    {
      ap.vd().b(145, this);
      i = ((s)paramk).AJ();
      if (i != 15)
      {
        GMTrace.o(2582214868992L, 19239);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 15)
        {
          if (this.vcb.vcz.booleanValue())
          {
            this.vci = ((s)paramk).Fv();
            ap.vd().a(126, this);
            paramString = new w("", this.vcb.lMD, this.vcb.aIO, 0, "", this.vcb.fOz, "", "", this.vci, this.vcb.hSt, "", "", "", true, this.vcb.vcy.booleanValue());
            ap.vd().a(paramString, 0);
            paramk = this.vcb;
            localObject1 = this.vcb;
            this.vcb.getString(R.l.dIG);
            paramk.isb = g.a((Context)localObject1, this.vcb.getString(R.l.eJX), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                GMTrace.i(2579933167616L, 19222);
                ap.vd().c(paramString);
                ap.vd().b(126, h.this);
                GMTrace.o(2579933167616L, 19222);
              }
            });
            GMTrace.o(2582214868992L, 19239);
            return;
          }
          paramString = new Intent();
          paramString.putExtra("regsetinfo_ticket", ((s)paramk).Fv());
          paramString.putExtra("regsetinfo_user", this.vcb.fOz);
          paramString.putExtra("regsetinfo_ismobile", 1);
          paramString.putExtra("regsetinfo_NextControl", ((s)paramk).Fy());
          paramString.setClass(this.vcb, RegSetInfoUI.class);
          this.vcb.startActivity(paramString);
          c.hi(c.a.irD);
          com.tencent.mm.plugin.c.b.mN("R200_900_phone");
          com.tencent.mm.u.bf.zK();
          com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + "," + "RE200_300" + "," + ap.ec("RE200_300") + ",2");
        }
        GMTrace.o(2582214868992L, 19239);
        return;
      }
      if (paramInt2 == -35)
      {
        paramString = com.tencent.mm.f.a.dn(paramString);
        if (paramString != null)
        {
          paramString.a(this.vcb, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(2599126302720L, 19365);
              ap.vd().a(701, h.this);
              h.this.vbn = new a(new a.a()
              {
                public final void a(ProgressDialog paramAnonymous2ProgressDialog)
                {
                  GMTrace.i(2599394738176L, 19367);
                  h.this.vcb.isb = paramAnonymous2ProgressDialog;
                  GMTrace.o(2599394738176L, 19367);
                }
              }, ((s)paramk).getUsername(), ((s)paramk).Fu(), h.this.vcb.fOz);
              h.this.vbn.h(h.this.vcb);
              GMTrace.o(2599126302720L, 19365);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(2620735356928L, 19526);
              GMTrace.o(2620735356928L, 19526);
            }
          });
          GMTrace.o(2582214868992L, 19239);
          return;
        }
        g.a(this.vcb, this.vcb.getString(R.l.dNa), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2620466921472L, 19524);
            ap.vd().a(701, h.this);
            h.this.vbn = new a(new a.a()
            {
              public final void a(ProgressDialog paramAnonymous2ProgressDialog)
              {
                GMTrace.i(2612279640064L, 19463);
                h.this.vcb.isb = paramAnonymous2ProgressDialog;
                GMTrace.o(2612279640064L, 19463);
              }
            }, ((s)paramk).getUsername(), ((s)paramk).Fu(), h.this.vcb.fOz);
            h.this.vbn.h(h.this.vcb);
            GMTrace.o(2620466921472L, 19524);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2595502424064L, 19338);
            GMTrace.o(2595502424064L, 19338);
          }
        });
        GMTrace.o(2582214868992L, 19239);
        return;
      }
      if (paramInt2 == 65324)
      {
        paramString = new Intent(this.vcb, MobileLoginOrForceReg.class);
        paramString.putExtra("ticket", ((s)paramk).Fv());
        paramString.putExtra("moble", this.vcb.fOz);
        paramString.putExtra("next_controll", ((s)paramk).Fy());
        paramString.putExtra("username", ((s)paramk).getUsername());
        paramString.putExtra("password", ((s)paramk).Fu());
        paramString.putExtra("nickname", ((s)paramk).FF());
        paramString.putExtra("avatar_url", ((s)paramk).FE());
        if (this.vcb.vcz.booleanValue())
        {
          paramString.putExtra("kintent_nickname", this.vcb.aIO);
          paramString.putExtra("kintent_password", this.vcb.lMD);
          paramString.putExtra("kintent_hasavatar", this.vcb.vcy);
        }
        this.vcb.startActivity(paramString);
        com.tencent.mm.plugin.c.b.mN("R200_600");
        com.tencent.mm.u.bf.zK();
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + "," + "RE200_300" + "," + ap.ec("RE200_300") + ",2");
        GMTrace.o(2582214868992L, 19239);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.f.a.dn(paramString);
        if (paramString != null)
        {
          paramString.a(this.vcb, null, null);
          GMTrace.o(2582214868992L, 19239);
          return;
        }
        g.h(this.vcb, R.l.dNX, R.l.btk);
        GMTrace.o(2582214868992L, 19239);
      }
    }
    else if (paramk.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == 65225) || (paramInt2 == 65226))
      {
        paramString = this.vcb.vcy;
        localObject1 = this.vcb.lMD;
        localObject2 = this.vcb.aIO;
        if (this.vcb.uSI == null)
        {
          this.vcb.uSI = SecurityImage.a.a(this.vcb, R.l.eJY, 0, ((w)paramk).FJ(), ((w)paramk).FK(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(2629325291520L, 19590);
              ap.vd().a(126, h.this);
              paramAnonymousDialogInterface = new w("", localObject1, localObject2, 0, "", h.this.vcb.fOz, "", "", h.this.vci, h.this.vcb.hSt, "", ((w)paramk).FK(), h.this.vcb.uSI.bRp(), true, paramString.booleanValue());
              ap.vd().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI1 = h.this.vcb;
              MobileVerifyUI localMobileVerifyUI2 = h.this.vcb;
              h.this.vcb.getString(R.l.dIG);
              localMobileVerifyUI1.isb = g.a(localMobileVerifyUI2, h.this.vcb.getString(R.l.eJX), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  GMTrace.i(2613621817344L, 19473);
                  ap.vd().c(paramAnonymousDialogInterface);
                  ap.vd().b(126, h.this);
                  GMTrace.o(2613621817344L, 19473);
                }
              });
              GMTrace.o(2629325291520L, 19590);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              GMTrace.i(2600065826816L, 19372);
              h.this.vcb.uSI = null;
              GMTrace.o(2600065826816L, 19372);
            }
          }, new SecurityImage.b()
          {
            public final void bQy()
            {
              GMTrace.i(2586375618560L, 19270);
              h.this.vcb.aGY();
              ap.vd().a(126, h.this);
              w localw = new w("", localObject1, localObject2, 0, "", h.this.vcb.fOz, "", "", h.this.vci, h.this.vcb.hSt, "", ((w)paramk).FK(), "", true, paramString.booleanValue());
              ap.vd().a(localw, 0);
              GMTrace.o(2586375618560L, 19270);
            }
          });
          GMTrace.o(2582214868992L, 19239);
          return;
        }
        this.vcb.uSI.a(0, ((w)paramk).FJ(), ((w)paramk).FK(), "");
        GMTrace.o(2582214868992L, 19239);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        str2 = this.vcb.fOz;
        localObject4 = this.vcb.vcy;
        i = ((w)paramk).FC();
        str1 = ((w)paramk).Js();
        j = ((w)paramk).Jt();
        str3 = ((w)paramk).Ju();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = bg.q(str3, "wording");
        if (localMap == null) {
          break label2305;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!com.tencent.mm.sdk.platformtools.bf.mA((String)localObject3)) {
          break label1830;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label2305;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!com.tencent.mm.sdk.platformtools.bf.mA((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (com.tencent.mm.sdk.platformtools.bf.mA((String)localObject3)) {
          break label2302;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", new Object[] { localObject4 });
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", new Object[] { str1 });
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", new Object[] { Integer.valueOf(j) });
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      ap.unhold();
      ap.aT(true);
      if (((Boolean)localObject4).booleanValue())
      {
        localObject3 = com.tencent.mm.compatible.util.e.gSw + "temp.avatar";
        localObject4 = com.tencent.mm.compatible.util.e.gSw + "temp.avatar.hd";
        new File((String)localObject3).renameTo(new File((String)localObject4));
        com.tencent.mm.loader.stub.b.deleteFile((String)localObject3);
        d.b((String)localObject4, 96, 96, Bitmap.CompressFormat.JPEG, 90, (String)localObject3);
        new o(this.vcb, com.tencent.mm.compatible.util.e.gSw + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            GMTrace.i(2619661615104L, 19518);
            h.this.kuu = ((w)paramk).Jr();
            ao.hlE.L("login_user_name", str2);
            com.tencent.mm.loader.stub.b.deleteFile(com.tencent.mm.compatible.util.e.gSw + "temp.avatar");
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.c.b.mN("R300_100_phone");
              if (!bool1) {
                localIntent1 = new Intent(h.this.vcb, FindMContactIntroUI.class);
              }
              for (;;)
              {
                localIntent1.addFlags(67108864);
                localIntent1.putExtra("regsetinfo_ticket", h.this.kuu);
                localIntent1.putExtra("regsetinfo_NextStep", str1);
                localIntent1.putExtra("regsetinfo_NextStyle", j);
                Intent localIntent2 = com.tencent.mm.plugin.c.a.imb.ak(h.this.vcb);
                localIntent2.addFlags(67108864);
                MMWizardActivity.b(h.this.vcb, localIntent1, localIntent2);
                h.this.vcb.finish();
                GMTrace.o(2619661615104L, 19518);
                return;
                localIntent1 = new Intent(h.this.vcb, FindMContactAlertUI.class);
                localIntent1.putExtra("alert_title", localObject1);
                localIntent1.putExtra("alert_message", localObject2);
              }
            }
            Intent localIntent1 = com.tencent.mm.plugin.c.a.imb.ak(h.this.vcb);
            localIntent1.addFlags(67108864);
            h.this.vcb.startActivity(localIntent1);
            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + h.this.vcb.getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
            h.this.vcb.finish();
            GMTrace.o(2619661615104L, 19518);
          }
        }, new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2601944875008L, 19386);
            h.this.kuu = ((w)paramk).Jr();
            ao.hlE.L("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.c.b.mN("R300_100_phone");
              if (!bool1) {
                localIntent1 = new Intent(h.this.vcb, FindMContactIntroUI.class);
              }
              for (;;)
              {
                localIntent1.addFlags(67108864);
                localIntent1.putExtra("regsetinfo_ticket", h.this.kuu);
                localIntent1.putExtra("regsetinfo_NextStep", str1);
                localIntent1.putExtra("regsetinfo_NextStyle", j);
                Intent localIntent2 = com.tencent.mm.plugin.c.a.imb.ak(h.this.vcb);
                localIntent2.addFlags(67108864);
                MMWizardActivity.b(h.this.vcb, localIntent1, localIntent2);
                h.this.vcb.finish();
                GMTrace.o(2601944875008L, 19386);
                return;
                localIntent1 = new Intent(h.this.vcb, FindMContactAlertUI.class);
                localIntent1.putExtra("alert_title", localObject1);
                localIntent1.putExtra("alert_message", localObject2);
              }
            }
            Intent localIntent1 = com.tencent.mm.plugin.c.a.imb.ak(h.this.vcb);
            localIntent1.addFlags(67108864);
            h.this.vcb.startActivity(localIntent1);
            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + h.this.vcb.getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
            h.this.vcb.finish();
            GMTrace.o(2601944875008L, 19386);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.f.a.dn(paramString);
        if (localObject1 == null) {
          break label2179;
        }
        ((com.tencent.mm.f.a)localObject1).a(this.vcb, null, null);
        GMTrace.o(2582214868992L, 19239);
        return;
        label1830:
        int k = com.tencent.mm.sdk.platformtools.bf.PX((String)localObject3);
        if (k == 0)
        {
          bool1 = false;
          break;
        }
        if (k != 1) {
          break;
        }
        bool1 = true;
        break;
        this.kuu = ((w)paramk).Jr();
        ao.hlE.L("login_user_name", str2);
        if ((str1 != null) && (str1.contains("0")))
        {
          com.tencent.mm.plugin.c.b.mN("R300_100_phone");
          if (!bool1) {}
          for (localObject1 = new Intent(this.vcb, FindMContactIntroUI.class);; localObject1 = localObject3)
          {
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("regsetinfo_ticket", this.kuu);
            ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
            ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
            localObject2 = com.tencent.mm.plugin.c.a.imb.ak(this.vcb);
            ((Intent)localObject2).addFlags(67108864);
            ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
            MMWizardActivity.b(this.vcb, (Intent)localObject1, (Intent)localObject2);
            this.vcb.finish();
            break;
            localObject3 = new Intent(this.vcb, FindMContactAlertUI.class);
            ((Intent)localObject3).putExtra("alert_title", (String)localObject1);
            ((Intent)localObject3).putExtra("alert_message", (String)localObject2);
          }
        }
        localObject1 = com.tencent.mm.plugin.c.a.imb.ak(this.vcb);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
        this.vcb.startActivity((Intent)localObject1);
        com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + this.vcb.getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
        this.vcb.finish();
      }
      label2179:
      if (this.vcb.p(paramInt1, paramInt2, paramString))
      {
        GMTrace.o(2582214868992L, 19239);
        return;
      }
      if (paramk.getType() == 701)
      {
        paramString = com.tencent.mm.f.a.dn(paramString);
        if ((paramString != null) && (paramString.a(this.vcb, null, null)))
        {
          GMTrace.o(2582214868992L, 19239);
          return;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this.vcb, this.vcb.getString(R.l.dNW, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      GMTrace.o(2582214868992L, 19239);
      return;
      label2302:
      continue;
      label2305:
      localObject1 = null;
      bool1 = bool2;
    }
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    GMTrace.i(2581677998080L, 19235);
    this.vcb = paramMobileVerifyUI;
    GMTrace.o(2581677998080L, 19235);
  }
  
  public final void start()
  {
    GMTrace.i(2581812215808L, 19236);
    com.tencent.mm.u.bf.zK();
    com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",RE200_300," + ap.ec("RE200_300") + ",1");
    com.tencent.mm.plugin.c.b.mM("RE200_300");
    GMTrace.o(2581812215808L, 19236);
  }
  
  public final void stop()
  {
    GMTrace.i(2581946433536L, 19237);
    GMTrace.o(2581946433536L, 19237);
  }
  
  public final boolean zz(int paramInt)
  {
    GMTrace.i(2582080651264L, 19238);
    switch (8.vce[(paramInt - 1)])
    {
    }
    for (;;)
    {
      GMTrace.o(2582080651264L, 19238);
      return false;
      g.b(this.vcb, this.vcb.getString(R.l.eAX), "", this.vcb.getString(R.l.eAY), this.vcb.getString(R.l.eAZ), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2601676439552L, 19384);
          h.this.vcb.finish();
          c.hi(c.a.irB);
          com.tencent.mm.u.bf.zK();
          com.tencent.mm.plugin.c.b.mN(h.this.vcb.oTI);
          com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",RE200_300," + ap.ec("RE200_300") + ",2");
          GMTrace.o(2601676439552L, 19384);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2601139568640L, 19380);
          GMTrace.o(2601139568640L, 19380);
        }
      });
      GMTrace.o(2582080651264L, 19238);
      return true;
      ap.vd().a(145, this);
      final s locals = new s(this.vcb.fOz, 15, this.vcb.vaW.getText().toString().trim(), 0, "");
      ap.vd().a(locals, 0);
      MobileVerifyUI localMobileVerifyUI1 = this.vcb;
      MobileVerifyUI localMobileVerifyUI2 = this.vcb;
      this.vcb.getString(R.l.dIG);
      localMobileVerifyUI1.isb = g.a(localMobileVerifyUI2, this.vcb.getString(R.l.dNU), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(2602884399104L, 19393);
          ap.vd().c(locals);
          ap.vd().b(145, h.this);
          GMTrace.o(2602884399104L, 19393);
        }
      });
      continue;
      com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_400," + ap.ec("R200_400") + ",1");
      com.tencent.mm.u.bf.zK();
      com.tencent.mm.plugin.c.b.mM("RE200_250");
      ap.vd().a(145, this);
      locals = new s(this.vcb.fOz, 14, "", 0, "");
      ap.vd().a(locals, 0);
      c.hi(c.a.irC);
      continue;
      com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_350_auto," + ap.ec("R200_350_auto") + ",1");
      ap.vd().a(145, this);
      locals = new s(this.vcb.fOz, 15, this.vcb.vaW.getText().toString().trim(), 0, "");
      ap.vd().a(locals, 0);
      localMobileVerifyUI1 = this.vcb;
      localMobileVerifyUI2 = this.vcb;
      this.vcb.getString(R.l.dIG);
      localMobileVerifyUI1.isb = g.a(localMobileVerifyUI2, this.vcb.getString(R.l.dNU), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(2587315142656L, 19277);
          ap.vd().c(locals);
          ap.vd().b(145, h.this);
          GMTrace.o(2587315142656L, 19277);
        }
      });
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/mobile/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */