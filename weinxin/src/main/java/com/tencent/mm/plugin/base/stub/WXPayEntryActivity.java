package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.plugin.wallet_index.ui.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class WXPayEntryActivity
  extends AutoLoginActivity
{
  private String jNX;
  private long jNY;
  
  public WXPayEntryActivity()
  {
    GMTrace.i(12841817997312L, 95679);
    this.jNX = null;
    this.jNY = 0L;
    GMTrace.o(12841817997312L, 95679);
  }
  
  private void jD(int paramInt)
  {
    GMTrace.i(12842354868224L, 95683);
    PayReq localPayReq = new PayReq();
    localPayReq.fromBundle(r.ad(getIntent()));
    PayReq.Options localOptions = new PayReq.Options();
    localOptions.fromBundle(r.ad(getIntent()));
    PayResp localPayResp = new PayResp();
    localPayResp.prepayId = localPayReq.prepayId;
    localPayResp.extData = localPayReq.extData;
    localPayResp.errCode = paramInt;
    a.a(this, r.i(getIntent(), "_mmessage_appPackage"), localPayResp, localOptions);
    GMTrace.o(12842354868224L, 95683);
  }
  
  protected final void a(AutoLoginActivity.b paramb, Intent paramIntent)
  {
    boolean bool2 = true;
    GMTrace.i(12842220650496L, 95682);
    if (paramIntent == null)
    {
      finish();
      GMTrace.o(12842220650496L, 95682);
      return;
    }
    v.i("MicroMsg.WXPayEntryActivity", "postLogin, delegate intent to OrderHandlerUI, resultCode = " + paramb);
    boolean bool1;
    switch (1.jNz[paramb.ordinal()])
    {
    default: 
      v.e("MicroMsg.WXPayEntryActivity", "postLogin, unknown login result = " + paramb);
    case 1: 
      this.jNX = r.i(paramIntent, "_mmessage_appPackage");
      v.i("MicroMsg.WXPayEntryActivity", "postLogin, getCallingPackage success, value = " + this.jNX);
      if ((getIntent() == null) || (r.ad(getIntent()) == null)) {
        bool1 = false;
      }
      break;
    }
    for (;;)
    {
      if (!bool1) {
        v.e("MicroMsg.WXPayEntryActivity", "postLogin, checkApp fail");
      }
      try
      {
        paramIntent.putExtra("key_scene", 0);
        paramb = r.ad(paramIntent);
        paramb.putLong("wallet_pay_key_check_time", this.jNY);
        e.a(this, paramb, bool1);
        finish();
        GMTrace.o(12842220650496L, 95682);
        return;
        jD(-2);
        v.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = " + paramb);
        finish();
        GMTrace.o(12842220650496L, 95682);
        return;
        jD(-1);
        v.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = " + paramb);
        finish();
        GMTrace.o(12842220650496L, 95682);
        return;
        paramb = new PayReq();
        paramb.fromBundle(r.ad(getIntent()));
        paramb = paramb.appId;
        v.d("MicroMsg.WXPayEntryActivity", "postLogin, appId = " + paramb);
        if ((paramb == null) || (paramb.length() == 0))
        {
          v.e("MicroMsg.WXPayEntryActivity", "checkApp fail, appId is null");
          bool1 = false;
          continue;
        }
        f localf = g.aJ(paramb, true);
        if (localf == null)
        {
          v.w("MicroMsg.WXPayEntryActivity", "checkApp fail, not reg");
          localf = new f();
          localf.field_appId = paramb;
          localf.field_appName = "";
          localf.field_packageName = this.jNX;
          localf.field_status = 0;
          String str = p.aP(this, this.jNX);
          if (str != null) {
            localf.field_signature = str;
          }
          bool1 = bool2;
          if (!an.aRk().l(localf)) {
            continue;
          }
          bool1 = bool2;
          if (!bf.mA(localf.field_openId)) {
            continue;
          }
          v.d("MicroMsg.WXPayEntryActivity", "checkApp, trigger getAppSetting, appId = " + paramb);
          an.aRl().Jj(paramb);
          bool1 = bool2;
          continue;
        }
        if (localf.field_status == 3)
        {
          v.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app is in blacklist");
          bool1 = false;
          continue;
        }
        bool1 = bool2;
        if (p.b(this, localf, this.jNX)) {
          continue;
        }
        a(this, localf, this.jNX, 5);
        v.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app invalid");
        bool1 = false;
      }
      catch (Exception paramb)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.IntentUtil", paramb, "", new Object[0]);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(12841952215040L, 95680);
    this.jNY = System.currentTimeMillis();
    r.b(getIntent(), "key_auto_login_wizard_exit", true);
    super.onCreate(paramBundle);
    GMTrace.o(12841952215040L, 95680);
  }
  
  protected final boolean u(Intent paramIntent)
  {
    GMTrace.i(12842086432768L, 95681);
    GMTrace.o(12842086432768L, 95681);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/base/stub/WXPayEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */