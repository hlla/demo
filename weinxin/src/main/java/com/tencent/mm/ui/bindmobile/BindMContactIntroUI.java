package com.tencent.mm.ui.bindmobile;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.friend.i.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public class BindMContactIntroUI
  extends MMWizardActivity
  implements com.tencent.mm.y.e
{
  private String fOz;
  private p irp;
  private boolean jDA;
  private String pjN;
  private String pjO;
  private com.tencent.mm.ui.friend.i vaL;
  private ImageView vau;
  private boolean vba;
  private TextView vrM;
  private TextView vrN;
  private Button vrO;
  private Button vrP;
  private m.a vrQ;
  private boolean vrR;
  private int vrS;
  
  public BindMContactIntroUI()
  {
    GMTrace.i(3094255501312L, 23054);
    this.irp = null;
    this.pjN = null;
    this.pjO = null;
    this.vba = false;
    this.jDA = false;
    this.vrR = false;
    this.vrS = 0;
    GMTrace.o(3094255501312L, 23054);
  }
  
  private void aXL()
  {
    GMTrace.i(3095195025408L, 23061);
    aGY();
    if (this.vrR)
    {
      cancel();
      finish();
      GMTrace.o(3095195025408L, 23061);
      return;
    }
    zp(1);
    GMTrace.o(3095195025408L, 23061);
  }
  
  private void kZ(boolean paramBoolean)
  {
    GMTrace.i(3095329243136L, 23062);
    Intent localIntent = new Intent(this, BindMContactUI.class);
    localIntent.putExtra("is_bind_for_safe_device", this.vba);
    localIntent.putExtra("is_bind_for_contact_sync", this.vrR);
    localIntent.putExtra("is_bind_for_change_mobile", paramBoolean);
    Object localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
    if (!bf.mA((String)localObject))
    {
      localObject = com.tencent.mm.ai.b.g(this, (String)localObject, getString(R.l.bGH));
      if (localObject != null)
      {
        localIntent.putExtra("country_name", ((b.a)localObject).hJn);
        localIntent.putExtra("couttry_code", ((b.a)localObject).hJm);
      }
    }
    w(this, localIntent);
    GMTrace.o(3095329243136L, 23062);
  }
  
  protected final void KD()
  {
    GMTrace.i(3094926589952L, 23059);
    this.vba = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
    this.vrR = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
    this.jDA = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.vrS = getIntent().getIntExtra("key_upload_scene", 0);
    this.vrQ = com.tencent.mm.modelfriend.m.Fm();
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BindMContactIntroUI", "state " + this.vrQ);
    ap.yY();
    this.fOz = ((String)c.vr().get(6, null));
    if ((this.fOz == null) || (this.fOz.equals("")))
    {
      ap.yY();
      this.fOz = ((String)c.vr().get(4097, null));
    }
    this.vau = ((ImageView)findViewById(R.h.cCQ));
    this.vrM = ((TextView)findViewById(R.h.cCO));
    this.vrN = ((TextView)findViewById(R.h.cCN));
    this.vrO = ((Button)findViewById(R.h.cCM));
    this.vrP = ((Button)findViewById(R.h.cCP));
    this.vrO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(3141768577024L, 23408);
        BindMContactIntroUI.a(BindMContactIntroUI.this);
        GMTrace.o(3141768577024L, 23408);
      }
    });
    this.vrP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(3125796667392L, 23289);
        BindMContactIntroUI.b(BindMContactIntroUI.this);
        GMTrace.o(3125796667392L, 23289);
      }
    });
    if (getIntent().getBooleanExtra("skip", false))
    {
      a(0, getString(R.l.dHq), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(3103650742272L, 23124);
          BindMContactIntroUI.c(BindMContactIntroUI.this);
          GMTrace.o(3103650742272L, 23124);
          return true;
        }
      });
      if ((this.vrQ == m.a.hBb) || (this.vrQ == m.a.hBa))
      {
        String str = com.tencent.mm.i.g.sV().getValue("ShowUnbindPhone");
        final int i = 2;
        if (!bf.mA(str)) {
          i = bf.PX(str);
        }
        if (i != 0) {
          a(1, R.g.bha, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              GMTrace.i(3122441224192L, 23264);
              paramAnonymousMenuItem = new com.tencent.mm.ui.tools.l(BindMContactIntroUI.this.uRf.uRz);
              paramAnonymousMenuItem.qHD = new n.c()
              {
                public final void a(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  GMTrace.i(3126333538304L, 23293);
                  paramAnonymous2l.setHeaderTitle(R.l.dNC);
                  if ((BindMContactIntroUI.23.this.vrW & 0x2) != 0) {
                    paramAnonymous2l.dX(0, R.l.dNP);
                  }
                  if ((BindMContactIntroUI.23.this.vrW & 0x1) != 0) {
                    paramAnonymous2l.dX(1, R.l.dNk);
                  }
                  GMTrace.o(3126333538304L, 23293);
                }
              };
              paramAnonymousMenuItem.qHE = new n.d()
              {
                public final void c(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  GMTrace.i(3107945709568L, 23156);
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    GMTrace.o(3107945709568L, 23156);
                    return;
                    BindMContactIntroUI.d(BindMContactIntroUI.this);
                    GMTrace.o(3107945709568L, 23156);
                    return;
                    paramAnonymous2MenuItem = new Intent();
                    paramAnonymous2MenuItem.putExtra("need_matte_high_light_item", "settings_find_me_by_mobile");
                    com.tencent.mm.bb.d.b(BindMContactIntroUI.this, "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymous2MenuItem);
                  }
                }
              };
              paramAnonymousMenuItem.bkT();
              GMTrace.o(3122441224192L, 23264);
              return false;
            }
          });
        }
      }
      switch (20.vrV[this.vrQ.ordinal()])
      {
      }
    }
    for (;;)
    {
      GMTrace.o(3094926589952L, 23059);
      return;
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(3109153669120L, 23165);
          BindMContactIntroUI.c(BindMContactIntroUI.this);
          GMTrace.o(3109153669120L, 23165);
          return true;
        }
      });
      break;
      af(1, false);
      this.vau.setImageResource(R.k.dxy);
      this.vrN.setVisibility(0);
      this.vrP.setVisibility(8);
      this.vrM.setText(R.l.dNA);
      this.vrN.setText(R.l.dNz);
      this.vrO.setText(R.l.dNc);
      GMTrace.o(3094926589952L, 23059);
      return;
      af(1, false);
      this.vau.setImageResource(R.k.dxy);
      this.vrN.setVisibility(0);
      this.vrP.setVisibility(0);
      this.vrM.setText(String.format(getString(R.l.dOa), new Object[] { this.fOz }));
      this.vrN.setText(R.l.dNS);
      this.vrO.setText(R.l.dNV);
      this.vrP.setText(R.l.dNl);
      GMTrace.o(3094926589952L, 23059);
      return;
      af(1, true);
      this.vau.setImageResource(R.k.dxx);
      this.vrN.setVisibility(0);
      this.vrP.setVisibility(0);
      this.vrM.setText(String.format(getString(R.l.dOa), new Object[] { this.fOz }));
      this.vrN.setText(R.l.dNh);
      this.vrO.setText(R.l.dNT);
      this.vrP.setText(R.l.dNj);
      GMTrace.o(3094926589952L, 23059);
      return;
      af(1, true);
      this.vau.setImageResource(R.k.dxx);
      this.vrN.setVisibility(0);
      this.vrP.setVisibility(0);
      this.vrM.setText(String.format(getString(R.l.dOa), new Object[] { this.fOz }));
      this.vrN.setText(R.l.dNh);
      this.vrO.setText(R.l.dNy);
      this.vrP.setText(R.l.dNj);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, final String paramString, k paramk)
  {
    GMTrace.i(3095463460864L, 23063);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BindMContactIntroUI", "summerunbind onSceneEnd type: " + paramk.getType() + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramk.getType() == 132) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.irp != null)
      {
        this.irp.dismiss();
        this.irp = null;
      }
      if (((com.tencent.mm.modelfriend.t)paramk).AJ() == 3)
      {
        com.tencent.mm.modelsimple.d.bd(this);
        if (!bf.mA(this.pjO))
        {
          com.tencent.mm.ui.base.g.a(this, this.pjO, "", getString(R.l.dAD), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(3149016334336L, 23462);
              MMWizardActivity.w(BindMContactIntroUI.this, new Intent(BindMContactIntroUI.this, BindMContactStatusUI.class));
              GMTrace.o(3149016334336L, 23462);
            }
          });
          GMTrace.o(3095463460864L, 23063);
          return;
        }
        w(this, new Intent(this, BindMContactStatusUI.class));
      }
      GMTrace.o(3095463460864L, 23063);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.c.a.imc.a(this, paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      if (this.irp != null)
      {
        this.irp.dismiss();
        this.irp = null;
      }
      GMTrace.o(3095463460864L, 23063);
      return;
      i = 0;
      switch (paramInt2)
      {
      default: 
        break;
      case -214: 
        paramString = com.tencent.mm.f.a.dn(paramString);
        if (paramString != null) {
          paramString.a(this, null, null);
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
      case -35: 
        Toast.makeText(this, R.l.dNo, 0).show();
        i = 1;
        break;
      case -36: 
        Toast.makeText(this, R.l.dNs, 0).show();
        i = 1;
      }
    }
    if (paramk.getType() == 254)
    {
      if (this.irp != null)
      {
        this.irp.dismiss();
        this.irp = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.pjO = ((com.tencent.mm.modelsimple.h)paramk).IQ().tpO;
        this.pjN = ((com.tencent.mm.modelsimple.h)paramk).IP();
        if (!bf.mA(this.pjO))
        {
          paramString = new com.tencent.mm.modelfriend.t(this.fOz, 3, "", 0, "");
          ap.vd().a(paramString, 0);
          paramk = this.uRf.uRz;
          getString(R.l.dIG);
          this.irp = com.tencent.mm.ui.base.g.a(paramk, getString(R.l.dNR), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              GMTrace.i(3129286328320L, 23315);
              ap.vd().c(paramString);
              GMTrace.o(3129286328320L, 23315);
            }
          });
          GMTrace.o(3095463460864L, 23063);
          return;
        }
        paramString = new com.tencent.mm.modelsimple.v(2);
        ap.vd().a(paramString, 0);
        GMTrace.o(3095463460864L, 23063);
        return;
      }
      if (paramInt2 == -3)
      {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        com.tencent.mm.ui.base.g.a(this.uRf.uRz, getString(R.l.eUy), null, getString(R.l.eUz), getString(R.l.eUx), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(3148211027968L, 23456);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("kintent_hint", BindMContactIntroUI.this.getString(R.l.eUw));
            paramAnonymousDialogInterface.putExtra("from_unbind", true);
            com.tencent.mm.bb.d.b(BindMContactIntroUI.this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
            GMTrace.o(3148211027968L, 23456);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(3147942592512L, 23454);
            GMTrace.o(3147942592512L, 23454);
          }
        });
      }
    }
    else if (paramk.getType() == 255)
    {
      if (this.irp != null)
      {
        this.irp.dismiss();
        this.irp = null;
      }
      if (paramInt2 != 0) {
        break label1020;
      }
      paramString = new com.tencent.mm.modelfriend.t(this.fOz, 3, "", 0, "");
      ap.vd().a(paramString, 0);
      ActionBarActivity localActionBarActivity = this.uRf.uRz;
      getString(R.l.dIG);
      this.irp = com.tencent.mm.ui.base.g.a(localActionBarActivity, getString(R.l.dNR), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(3140157964288L, 23396);
          ap.vd().c(paramString);
          GMTrace.o(3140157964288L, 23396);
        }
      });
    }
    for (;;)
    {
      if (paramk.getType() == 132)
      {
        if (this.irp != null)
        {
          this.irp.dismiss();
          this.irp = null;
        }
        if (((com.tencent.mm.modelfriend.t)paramk).AJ() == 3)
        {
          if (paramInt2 == -82)
          {
            com.tencent.mm.ui.base.g.a(this, R.l.eRA, R.l.dIG, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(3126601973760L, 23295);
                GMTrace.o(3126601973760L, 23295);
              }
            });
            GMTrace.o(3095463460864L, 23063);
            return;
            if (paramInt2 == -81)
            {
              com.tencent.mm.ui.base.g.a(this, R.l.eRz, R.l.dIG, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  GMTrace.i(3110764281856L, 23177);
                  GMTrace.o(3110764281856L, 23177);
                }
              });
              break;
            }
            if (paramInt2 == -82)
            {
              com.tencent.mm.ui.base.g.a(this, R.l.eRA, R.l.dIG, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  GMTrace.i(3129017892864L, 23313);
                  GMTrace.o(3129017892864L, 23313);
                }
              });
              break;
            }
            if (paramInt2 == -83)
            {
              com.tencent.mm.ui.base.g.a(this, R.l.eRx, R.l.dIG, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  GMTrace.i(3122709659648L, 23266);
                  GMTrace.o(3122709659648L, 23266);
                }
              });
              break;
            }
            if (paramInt2 == -84)
            {
              com.tencent.mm.ui.base.g.a(this, R.l.eRy, R.l.dIG, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  GMTrace.i(3121635917824L, 23258);
                  GMTrace.o(3121635917824L, 23258);
                }
              });
              break;
            }
            if (paramInt2 == -85)
            {
              com.tencent.mm.ui.base.g.a(this, R.l.eRv, R.l.dIG, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  GMTrace.i(3133447077888L, 23346);
                  GMTrace.o(3133447077888L, 23346);
                }
              });
              break;
            }
            if (paramInt2 != -86) {
              break;
            }
            com.tencent.mm.ui.base.g.a(this, R.l.eRB, R.l.dIG, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(3122978095104L, 23268);
                GMTrace.o(3122978095104L, 23268);
              }
            });
            break;
            label1020:
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
            com.tencent.mm.ui.base.g.a(this.uRf.uRz, getString(R.l.eUy), null, getString(R.l.eUz), getString(R.l.eUx), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(3115193466880L, 23210);
                paramAnonymousDialogInterface = new Intent();
                paramAnonymousDialogInterface.putExtra("kintent_hint", BindMContactIntroUI.this.getString(R.l.eUw));
                paramAnonymousDialogInterface.putExtra("from_unbind", true);
                com.tencent.mm.bb.d.b(BindMContactIntroUI.this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
                GMTrace.o(3115193466880L, 23210);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(3138144698368L, 23381);
                GMTrace.o(3138144698368L, 23381);
              }
            });
            continue;
          }
          if (paramInt2 == -83)
          {
            com.tencent.mm.ui.base.g.a(this, R.l.eRx, R.l.dIG, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(3126065102848L, 23291);
                GMTrace.o(3126065102848L, 23291);
              }
            });
            GMTrace.o(3095463460864L, 23063);
            return;
          }
          if (paramInt2 == -84)
          {
            com.tencent.mm.ui.base.g.a(this, R.l.eRy, R.l.dIG, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(3139621093376L, 23392);
                GMTrace.o(3139621093376L, 23392);
              }
            });
            GMTrace.o(3095463460864L, 23063);
            return;
          }
          if (paramInt2 == -85)
          {
            com.tencent.mm.ui.base.g.a(this, R.l.eRv, R.l.dIG, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(3147674157056L, 23452);
                GMTrace.o(3147674157056L, 23452);
              }
            });
            GMTrace.o(3095463460864L, 23063);
            return;
          }
          Toast.makeText(this, getString(R.l.dNO, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        }
      }
    }
    GMTrace.o(3095463460864L, 23063);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(3094389719040L, 23055);
    int i = R.i.cVt;
    GMTrace.o(3094389719040L, 23055);
    return i;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(3095597678592L, 23064);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.BindMContactIntroUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      GMTrace.o(3095597678592L, 23064);
      return;
      if (paramInt2 == -1)
      {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.fOz);
        paramIntent = new com.tencent.mm.modelsimple.h(com.tencent.mm.modelsimple.h.hRs);
        ap.vd().a(paramIntent, 0);
        getString(R.l.dIG);
        this.irp = com.tencent.mm.ui.base.g.a(this, getString(R.l.eSD), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(3141231706112L, 23404);
            GMTrace.o(3141231706112L, 23404);
          }
        });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3094523936768L, 23056);
    super.onCreate(paramBundle);
    ap.vd().a(132, this);
    ap.vd().a(255, this);
    ap.vd().a(254, this);
    zd(R.l.dNJ);
    GMTrace.o(3094523936768L, 23056);
  }
  
  public void onDestroy()
  {
    GMTrace.i(3094658154496L, 23057);
    ap.vd().b(132, this);
    ap.vd().b(255, this);
    ap.vd().b(254, this);
    if (this.vaL != null)
    {
      getContentResolver().unregisterContentObserver(this.vaL);
      this.vaL.recycle();
    }
    super.onDestroy();
    GMTrace.o(3094658154496L, 23057);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(3095060807680L, 23060);
    if (paramInt == 4)
    {
      aXL();
      GMTrace.o(3095060807680L, 23060);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(3095060807680L, 23060);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    GMTrace.i(3095731896320L, 23065);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      if (paramArrayOfInt == null) {}
      for (int i = -1;; i = paramArrayOfInt.length)
      {
        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.BindMContactIntroUI", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bf.bJP() });
        GMTrace.o(3095731896320L, 23065);
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.BindMContactIntroUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(3095731896320L, 23065);
      return;
      if ((paramArrayOfInt[0] == 0) && (this.vaL != null)) {
        this.vaL.bRc();
      }
    }
  }
  
  protected void onResume()
  {
    GMTrace.i(3094792372224L, 23058);
    super.onResume();
    KD();
    GMTrace.o(3094792372224L, 23058);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindmobile/BindMContactIntroUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */