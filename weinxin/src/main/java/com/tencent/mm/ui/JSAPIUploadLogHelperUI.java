package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ad;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.n;

public class JSAPIUploadLogHelperUI
  extends MMBaseActivity
{
  private static volatile boolean lp;
  private byte[] gWs;
  
  static
  {
    GMTrace.i(2860448219136L, 21312);
    lp = false;
    GMTrace.o(2860448219136L, 21312);
  }
  
  public JSAPIUploadLogHelperUI()
  {
    GMTrace.i(2859777130496L, 21307);
    this.gWs = new byte[0];
    GMTrace.o(2859777130496L, 21307);
  }
  
  protected void onCreate(Bundle arg1)
  {
    GMTrace.i(2859911348224L, 21308);
    v.i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", new Object[] { Boolean.valueOf(lp) });
    super.onCreate(???);
    setContentView(R.i.cUT);
    final int i;
    for (;;)
    {
      synchronized (this.gWs)
      {
        if (lp)
        {
          v.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
          finish();
        }
        ??? = getIntent().getStringExtra("key_user");
        i = getIntent().getIntExtra("key_time", 0);
        if ((??? != null) && (???.equals(m.xL())))
        {
          bool = true;
          v.i("MicroMsg.JSAPIUploadLogHelperUI", "upload log from jsapi, in upload activity, username-recv-well:%b, time:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          if (??? != null) {
            break;
          }
          v.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: userName is null.");
          finish();
          GMTrace.o(2859911348224L, 21308);
          return;
        }
      }
      boolean bool = false;
    }
    if (i < 0)
    {
      v.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: illegal time value: %d", new Object[] { Integer.valueOf(i) });
      finish();
      GMTrace.o(2859911348224L, 21308);
      return;
    }
    getString(R.l.dIG);
    final p localp = com.tencent.mm.ui.base.g.a(this, getString(R.l.fnP), false, null);
    ap.vd().a(new bb(new bb.a()
    {
      public final void a(e arg1)
      {
        GMTrace.i(2875212169216L, 21422);
        synchronized (JSAPIUploadLogHelperUI.a(JSAPIUploadLogHelperUI.this))
        {
          JSAPIUploadLogHelperUI.kk(true);
          ap.vd().a(1, "", 0, false);
          v.bIF();
          ap.vd().a(2, paramBundle, i, ap.zb());
          GMTrace.o(2875212169216L, 21422);
          return;
        }
      }
    }), 0);
    ap.a(new ad()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(2905545375744L, 21648);
        if (!JSAPIUploadLogHelperUI.this.isFinishing()) {
          JSAPIUploadLogHelperUI.this.finish();
        }
        GMTrace.o(2905545375744L, 21648);
      }
    }
    {
      public final void ey(int paramAnonymousInt)
      {
        GMTrace.i(2102252273664L, 15663);
        if (paramAnonymousInt < 0)
        {
          v.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          ap.a(null);
          if (localp != null) {
            localp.dismiss();
          }
          ??? = com.tencent.mm.ui.base.g.h(JSAPIUploadLogHelperUI.this, R.l.eYX, R.l.dIG);
          if (??? != null) {
            ((h)???).setOnDismissListener(this.uPR);
          }
          synchronized (JSAPIUploadLogHelperUI.a(JSAPIUploadLogHelperUI.this))
          {
            JSAPIUploadLogHelperUI.kk(false);
            GMTrace.o(2102252273664L, 15663);
            return;
          }
        }
        if (paramAnonymousInt >= 100)
        {
          v.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
          ap.a(null);
          if (localp != null) {
            localp.dismiss();
          }
          ??? = com.tencent.mm.ui.base.g.h(JSAPIUploadLogHelperUI.this, R.l.eZb, R.l.dIG);
          if (??? != null) {
            ((h)???).setOnDismissListener(this.uPR);
          }
          long l = System.currentTimeMillis() / 1000L;
          com.tencent.mm.plugin.report.service.g.oSF.i(12975, new Object[] { Long.valueOf(l) });
          synchronized (JSAPIUploadLogHelperUI.a(JSAPIUploadLogHelperUI.this))
          {
            JSAPIUploadLogHelperUI.kk(false);
            GMTrace.o(2102252273664L, 15663);
            return;
          }
        }
        v.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (localp != null) {
          localp.setMessage(JSAPIUploadLogHelperUI.this.getString(R.l.eYY) + paramAnonymousInt + "%");
        }
        GMTrace.o(2102252273664L, 15663);
      }
    });
    GMTrace.o(2859911348224L, 21308);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(2860045565952L, 21309);
    v.i("MicroMsg.JSAPIUploadLogHelperUI", "onDestroy called, isRunning:%b", new Object[] { Boolean.valueOf(lp) });
    super.onDestroy();
    GMTrace.o(2860045565952L, 21309);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/JSAPIUploadLogHelperUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */