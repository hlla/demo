package com.tencent.mm.ui.bindqq;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.a.o;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public class BindQQUI
  extends MMWizardActivity
  implements e
{
  p irp;
  private String pjN;
  private String pjO;
  private int type;
  
  public BindQQUI()
  {
    GMTrace.i(1903073165312L, 14179);
    this.type = 0;
    this.pjN = null;
    this.pjO = null;
    GMTrace.o(1903073165312L, 14179);
  }
  
  protected final void KD()
  {
    GMTrace.i(1903744253952L, 14184);
    ap.yY();
    long l = new o(bf.f((Integer)c.vr().get(9, null))).longValue();
    Object localObject;
    if (l == 0L)
    {
      zd(R.l.dOn);
      localObject = (TextView)findViewById(R.h.cCR);
      ((TextView)localObject).setVisibility(8);
      ((TextView)localObject).setText(R.l.dOm);
      ((TextView)findViewById(R.h.cCS)).setVisibility(8);
      localObject = (Button)findViewById(R.h.bto);
      ((Button)localObject).setVisibility(0);
      ((Button)localObject).setText(R.l.bto);
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(1899180851200L, 14150);
          MMWizardActivity.w(BindQQUI.this, new Intent(BindQQUI.this, VerifyQQUI.class));
          GMTrace.o(1899180851200L, 14150);
        }
      });
      zi(1);
    }
    while (this.type == 1)
    {
      a(0, getString(R.l.dHq), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(1887772344320L, 14065);
          BindQQUI.a(BindQQUI.this);
          GMTrace.o(1887772344320L, 14065);
          return true;
        }
      });
      GMTrace.o(1903744253952L, 14184);
      return;
      zd(R.l.dOl);
      localObject = (TextView)findViewById(R.h.cCR);
      ((TextView)localObject).setVisibility(8);
      ((TextView)localObject).setText(R.l.dOj);
      localObject = (TextView)findViewById(R.h.cCS);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(getString(R.l.dOk) + l);
      localObject = (Button)findViewById(R.h.bto);
      ((Button)localObject).setVisibility(8);
      ((Button)localObject).setText(R.l.erC);
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(1891798876160L, 14095);
          GMTrace.o(1891798876160L, 14095);
        }
      });
      a(1, R.g.bha, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(1887503908864L, 14063);
          paramAnonymousMenuItem = new com.tencent.mm.ui.tools.l(BindQQUI.this.uRf.uRz);
          paramAnonymousMenuItem.qHD = new n.c()
          {
            public final void a(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              GMTrace.i(1902938947584L, 14178);
              paramAnonymous2l.setHeaderTitle(R.l.dNC);
              paramAnonymous2l.dX(0, R.l.eUv);
              GMTrace.o(1902938947584L, 14178);
            }
          };
          paramAnonymousMenuItem.qHE = new n.d()
          {
            public final void c(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              GMTrace.i(1889651392512L, 14079);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                GMTrace.o(1889651392512L, 14079);
                return;
                paramAnonymous2MenuItem = BindQQUI.this;
                h localh = new h(h.hRr);
                ap.vd().a(localh, 0);
                paramAnonymous2MenuItem.getString(R.l.dIG);
                paramAnonymous2MenuItem.irp = g.a(paramAnonymous2MenuItem, paramAnonymous2MenuItem.getString(R.l.eSD), true, new BindQQUI.2(paramAnonymous2MenuItem));
              }
            }
          };
          paramAnonymousMenuItem.bkT();
          GMTrace.o(1887503908864L, 14063);
          return false;
        }
      });
    }
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(1888309215232L, 14069);
        BindQQUI.this.aGY();
        BindQQUI.this.finish();
        GMTrace.o(1888309215232L, 14069);
        return true;
      }
    });
    GMTrace.o(1903744253952L, 14184);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(1903878471680L, 14185);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BindQQUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramk.getType());
    if (this.irp != null)
    {
      this.irp.dismiss();
      this.irp = null;
    }
    if (paramk.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.pjN = ((h)paramk).IP();
        if ((this.pjN != null) && (this.pjN.length() > 0))
        {
          ap.yY();
          c.vr().set(102407, this.pjN);
        }
        if (!bf.mA(this.pjO))
        {
          paramString = new Intent(this, StartUnbindQQ.class);
          paramString.putExtra("notice", this.pjO);
          w(this, paramString);
          GMTrace.o(1903878471680L, 14185);
          return;
        }
        paramString = new com.tencent.mm.modelsimple.v(2);
        ap.vd().a(paramString, 0);
        GMTrace.o(1903878471680L, 14185);
        return;
      }
      if (this.irp != null)
      {
        this.irp.dismiss();
        this.irp = null;
      }
      if (paramInt2 == -3)
      {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BindQQUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        g.a(this.uRf.uRz, getString(R.l.eUy), null, getString(R.l.eUz), getString(R.l.eUx), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(1899449286656L, 14152);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("kintent_hint", BindQQUI.this.getString(R.l.eUw));
            paramAnonymousDialogInterface.putExtra("from_unbind", true);
            d.b(BindQQUI.this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
            GMTrace.o(1899449286656L, 14152);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(1887235473408L, 14061);
            GMTrace.o(1887235473408L, 14061);
          }
        });
        GMTrace.o(1903878471680L, 14185);
        return;
      }
      if (paramInt2 == -81)
      {
        g.a(this, R.l.eRz, R.l.dIG, null);
        GMTrace.o(1903878471680L, 14185);
        return;
      }
      if (paramInt2 == -82)
      {
        g.a(this, R.l.eRA, R.l.dIG, null);
        GMTrace.o(1903878471680L, 14185);
        return;
      }
      if (paramInt2 == -83)
      {
        g.a(this, R.l.eRx, R.l.dIG, null);
        GMTrace.o(1903878471680L, 14185);
        return;
      }
      if (paramInt2 == -84)
      {
        g.a(this, R.l.eRy, R.l.dIG, null);
        GMTrace.o(1903878471680L, 14185);
        return;
      }
      if (paramInt2 == -85)
      {
        g.a(this, R.l.eRw, R.l.dIG, null);
        GMTrace.o(1903878471680L, 14185);
        return;
      }
      if (paramInt2 == -86)
      {
        g.a(this, R.l.eRB, R.l.dIG, null);
        GMTrace.o(1903878471680L, 14185);
      }
    }
    else if (paramk.getType() == 255)
    {
      if (paramInt2 == 0)
      {
        w(this, new Intent(this, StartUnbindQQ.class));
        GMTrace.o(1903878471680L, 14185);
        return;
      }
      g.a(this.uRf.uRz, getString(R.l.eUy), null, getString(R.l.eUz), getString(R.l.eUx), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(1891530440704L, 14093);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("kintent_hint", BindQQUI.this.getString(R.l.eUw));
          paramAnonymousDialogInterface.putExtra("from_unbind", true);
          d.b(BindQQUI.this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
          GMTrace.o(1891530440704L, 14093);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(1898643980288L, 14146);
          GMTrace.o(1898643980288L, 14146);
        }
      });
    }
    GMTrace.o(1903878471680L, 14185);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(1903610036224L, 14183);
    int i = R.i.cVy;
    GMTrace.o(1903610036224L, 14183);
    return i;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(1904012689408L, 14186);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BindQQUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      GMTrace.o(1904012689408L, 14186);
      return;
      if (paramInt2 == -1)
      {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BindQQUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again qq");
        paramIntent = new h(h.hRr);
        ap.vd().a(paramIntent, 0);
        getString(R.l.dIG);
        this.irp = g.a(this, getString(R.l.eSD), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(1904683778048L, 14191);
            GMTrace.o(1904683778048L, 14191);
          }
        });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1903207383040L, 14180);
    super.onCreate(paramBundle);
    this.type = getIntent().getIntExtra("bindqq_regbymobile", 0);
    ap.vd().a(254, this);
    ap.vd().a(255, this);
    GMTrace.o(1903207383040L, 14180);
  }
  
  public void onDestroy()
  {
    GMTrace.i(1903341600768L, 14181);
    ap.vd().b(254, this);
    ap.vd().b(255, this);
    super.onDestroy();
    GMTrace.o(1903341600768L, 14181);
  }
  
  protected void onResume()
  {
    GMTrace.i(1903475818496L, 14182);
    super.onResume();
    KD();
    GMTrace.o(1903475818496L, 14182);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindqq/BindQQUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */