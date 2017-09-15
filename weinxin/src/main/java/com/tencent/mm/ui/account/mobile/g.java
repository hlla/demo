package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.hh;
import com.tencent.mm.e.a.hh.b;
import com.tencent.mm.e.a.hi;
import com.tencent.mm.e.a.hi.a;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.List;

public final class g
  implements MobileVerifyUI.b, e
{
  private String kuu;
  private MobileVerifyUI vcb;
  private String vcf;
  private int vcg;
  
  public g()
  {
    GMTrace.i(2607179366400L, 19425);
    this.kuu = null;
    this.vcf = "";
    this.vcg = 2;
    GMTrace.o(2607179366400L, 19425);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    int i = 0;
    GMTrace.i(2607850455040L, 19430);
    v.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.vcb.isb != null)
    {
      this.vcb.isb.dismiss();
      this.vcb.isb = null;
    }
    if (paramk.getType() == 132)
    {
      ap.vd().b(132, this);
      if ((((t)paramk).AJ() == 2) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        ap.unhold();
        paramInt1 = i;
        if (com.tencent.mm.pluginsdk.a.dp(this.vcb).size() != 0) {
          paramInt1 = 1;
        }
        if ((this.vcf != null) && (this.vcf.contains("1")) && (paramInt1 != 0))
        {
          com.tencent.mm.plugin.c.b.mN("R300_300_QQ");
          paramString = new Intent(this.vcb, FindMContactAddUI.class);
          paramString.addFlags(67108864);
          paramString.putExtra("regsetinfo_ticket", this.kuu);
          paramString.putExtra("regsetinfo_NextStep", this.vcf);
          paramString.putExtra("regsetinfo_NextStyle", this.vcg);
          paramString.putExtra("login_type", 1);
          paramk = com.tencent.mm.plugin.c.a.imb.ak(this.vcb);
          paramk.addFlags(67108864);
          MMWizardActivity.b(this.vcb, paramString, paramk);
          this.vcb.finish();
          GMTrace.o(2607850455040L, 19430);
          return;
        }
        paramString = com.tencent.mm.plugin.c.a.imb.ak(this.vcb);
        paramString.addFlags(67108864);
        this.vcb.startActivity(paramString);
        this.vcb.vcC = 4;
        this.vcb.finish();
        GMTrace.o(2607850455040L, 19430);
        return;
      }
      GMTrace.o(2607850455040L, 19430);
      return;
    }
    if (this.vcb.p(paramInt1, paramInt2, paramString))
    {
      GMTrace.o(2607850455040L, 19430);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.vcb, this.vcb.getString(R.l.dNW, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    GMTrace.o(2607850455040L, 19430);
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    GMTrace.i(2607313584128L, 19426);
    this.vcb = paramMobileVerifyUI;
    this.kuu = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.vcf = paramMobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.vcg = paramMobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    GMTrace.o(2607313584128L, 19426);
  }
  
  public final void start()
  {
    GMTrace.i(2607447801856L, 19427);
    GMTrace.o(2607447801856L, 19427);
  }
  
  public final void stop()
  {
    GMTrace.i(2607582019584L, 19428);
    GMTrace.o(2607582019584L, 19428);
  }
  
  public final boolean zz(int paramInt)
  {
    GMTrace.i(2607716237312L, 19429);
    switch (3.vce[(paramInt - 1)])
    {
    }
    for (;;)
    {
      GMTrace.o(2607716237312L, 19429);
      return false;
      final Object localObject1 = new hh();
      ((hh)localObject1).fMz.context = this.vcb;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((hh)localObject1).fMA.fMB;
      Object localObject2 = new hi();
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
      localObject2 = ((hi)localObject2).fMC.fMD;
      ap.vd().a(132, this);
      localObject1 = new t(this.vcb.fOz, 2, this.vcb.vaW.getText().toString().trim(), "", (String)localObject1, (String)localObject2);
      ap.vd().a((k)localObject1, 0);
      localObject2 = this.vcb;
      MobileVerifyUI localMobileVerifyUI = this.vcb;
      this.vcb.getString(R.l.dIG);
      ((MobileVerifyUI)localObject2).isb = com.tencent.mm.ui.base.g.a(localMobileVerifyUI, this.vcb.getString(R.l.dNU), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(2614695559168L, 19481);
          ap.vd().c(localObject1);
          ap.vd().b(132, g.this);
          GMTrace.o(2614695559168L, 19481);
        }
      });
      continue;
      ap.vd().a(132, this);
      localObject1 = new t(this.vcb.fOz, 1, "", 0, "");
      ap.vd().a((k)localObject1, 0);
      continue;
      localObject1 = new hh();
      ((hh)localObject1).fMz.context = this.vcb;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((hh)localObject1).fMA.fMB;
      localObject2 = new hi();
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
      localObject2 = ((hi)localObject2).fMC.fMD;
      ap.vd().a(132, this);
      localObject1 = new t(this.vcb.fOz, 2, this.vcb.vaW.getText().toString().trim(), "", (String)localObject1, (String)localObject2);
      ap.vd().a((k)localObject1, 0);
      localObject2 = this.vcb;
      localMobileVerifyUI = this.vcb;
      this.vcb.getString(R.l.dIG);
      ((MobileVerifyUI)localObject2).isb = com.tencent.mm.ui.base.g.a(localMobileVerifyUI, this.vcb.getString(R.l.dNU), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(2602615963648L, 19391);
          ap.vd().c(localObject1);
          ap.vd().b(132, g.this);
          GMTrace.o(2602615963648L, 19391);
        }
      });
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/mobile/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */