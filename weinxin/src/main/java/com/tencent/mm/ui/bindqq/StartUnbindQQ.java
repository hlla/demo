package com.tencent.mm.ui.bindqq;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.modelfriend.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.x.d;
import com.tencent.mm.x.i;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.z.b;

public class StartUnbindQQ
  extends MMWizardActivity
  implements e
{
  private p irp;
  private com.tencent.mm.ui.base.h piK;
  private String pjO;
  private View vtb;
  
  public StartUnbindQQ()
  {
    GMTrace.i(1899851939840L, 14155);
    this.pjO = null;
    GMTrace.o(1899851939840L, 14155);
  }
  
  protected final void KD()
  {
    GMTrace.i(1900523028480L, 14160);
    zd(R.l.eYy);
    this.vtb = findViewById(R.h.cCT);
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(1899717722112L, 14154);
        StartUnbindQQ.this.finish();
        GMTrace.o(1899717722112L, 14154);
        return true;
      }
    });
    this.vtb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1890456698880L, 14085);
        if (StartUnbindQQ.a(StartUnbindQQ.this) == null)
        {
          StartUnbindQQ.a(StartUnbindQQ.this, com.tencent.mm.ui.base.g.a(StartUnbindQQ.this, StartUnbindQQ.this.getString(R.l.eRC), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GMTrace.i(1888846086144L, 14073);
              paramAnonymous2DialogInterface = new b("");
              ap.vd().a(paramAnonymous2DialogInterface, 0);
              paramAnonymous2DialogInterface = StartUnbindQQ.this;
              StartUnbindQQ localStartUnbindQQ = StartUnbindQQ.this;
              StartUnbindQQ.this.getString(R.l.dIG);
              StartUnbindQQ.a(paramAnonymous2DialogInterface, com.tencent.mm.ui.base.g.a(localStartUnbindQQ, StartUnbindQQ.this.getString(R.l.eRD), true, null));
              GMTrace.o(1888846086144L, 14073);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GMTrace.i(1888040779776L, 14067);
              GMTrace.o(1888040779776L, 14067);
            }
          }));
          GMTrace.o(1890456698880L, 14085);
          return;
        }
        StartUnbindQQ.a(StartUnbindQQ.this).show();
        GMTrace.o(1890456698880L, 14085);
      }
    });
    GMTrace.o(1900523028480L, 14160);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(1900657246208L, 14161);
    v.d("MicroMsg.StartUnbindQQ", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramk.getType());
    if (paramk.getType() == 253)
    {
      if (this.irp != null)
      {
        this.irp.dismiss();
        this.irp = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ap.yY();
        paramInt1 = bf.a((Integer)c.vr().get(9, null), 0);
        v.d("MicroMsg.StartUnbindQQ", "iBindUin " + paramInt1);
        if (paramInt1 != 0)
        {
          ap.yY();
          c.wZ().hP(new o(paramInt1) + "@qqim");
        }
        ap.yY();
        paramk = c.vr().get(102407, null);
        if ((paramk != null) && (((String)paramk).length() > 0))
        {
          ap.yY();
          c.vr().set(102407, null);
        }
      }
      try
      {
        com.tencent.mm.sdk.b.a.uql.m(new com.tencent.mm.e.a.af());
        ap.yY();
        paramInt1 = bf.a((Integer)c.vr().get(9, null), 0);
        paramk = new o(paramInt1) + "@qqim";
        ap.yY();
        c.wZ().hP(paramk);
        ap.yY();
        c.wR().Rh(paramk);
        com.tencent.mm.x.n.Bm().ht(paramk);
        String str = m.xL() + "@qqim";
        com.tencent.mm.x.n.Bm().ht(str);
        com.tencent.mm.x.n.Bl();
        d.s(paramk, false);
        com.tencent.mm.x.n.Bl();
        d.s(paramk, true);
        com.tencent.mm.x.n.Bl();
        d.s(str, false);
        com.tencent.mm.x.n.Bl();
        d.s(str, true);
        paramk = com.tencent.mm.modelfriend.af.Gc();
        v.d("MicroMsg.QQGroupStorage", "delete all");
        if (paramk.hnp.delete("qqgroup", null, null) > 0) {
          paramk.doNotify();
        }
        com.tencent.mm.plugin.c.a.imc.ou();
      }
      catch (Exception paramk)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.StartUnbindQQ", paramk, "", new Object[0]);
          v.printErrStackTrace("MicroMsg.StartUnbindQQ", paramk, "", new Object[0]);
          continue;
          zp(1);
        }
      }
      ap.yY();
      c.vr().set(9, Integer.valueOf(0));
      paramk = new rc();
      paramk.fXS.fXT = false;
      paramk.fXS.fXU = true;
      com.tencent.mm.sdk.b.a.uql.m(paramk);
      if (!bf.mA(this.pjO))
      {
        com.tencent.mm.ui.base.g.a(this, this.pjO, "", getString(R.l.dAD), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(1893006835712L, 14104);
            StartUnbindQQ.b(StartUnbindQQ.this);
            GMTrace.o(1893006835712L, 14104);
          }
        });
        paramString = com.tencent.mm.f.a.dn(paramString);
        if (paramString == null) {
          break label602;
        }
        paramString.a(this, null, null);
        GMTrace.o(1900657246208L, 14161);
      }
    }
    label602:
    GMTrace.o(1900657246208L, 14161);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(1900388810752L, 14159);
    int i = R.i.doK;
    GMTrace.o(1900388810752L, 14159);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1899986157568L, 14156);
    super.onCreate(paramBundle);
    ap.vd().a(253, this);
    this.pjO = getIntent().getStringExtra("notice");
    GMTrace.o(1899986157568L, 14156);
  }
  
  public void onDestroy()
  {
    GMTrace.i(1900120375296L, 14157);
    ap.vd().b(253, this);
    super.onDestroy();
    GMTrace.o(1900120375296L, 14157);
  }
  
  protected void onResume()
  {
    GMTrace.i(1900254593024L, 14158);
    super.onResume();
    KD();
    GMTrace.o(1900254593024L, 14158);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindqq/StartUnbindQQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */