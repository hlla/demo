package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.hh;
import com.tencent.mm.e.a.hh.b;
import com.tencent.mm.e.a.hi;
import com.tencent.mm.e.a.hi.a;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.protocal.c.st;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public class BindMContactVerifyUI
  extends MMWizardActivity
  implements e
{
  private String fOz;
  private int fromScene;
  private SharedPreferences hgn;
  private p irp;
  private boolean jDA;
  private int status;
  private EditText vaW;
  private Button vaZ;
  private TextView vbO;
  private boolean vba;
  private boolean vbc;
  private boolean vrR;
  private boolean vsd;
  private boolean vsf;
  
  public BindMContactVerifyUI()
  {
    GMTrace.i(3144855584768L, 23431);
    this.irp = null;
    this.vba = false;
    this.vrR = false;
    this.vbc = false;
    this.vsf = false;
    this.vsd = false;
    this.jDA = false;
    this.fromScene = 0;
    GMTrace.o(3144855584768L, 23431);
  }
  
  protected final void KD()
  {
    GMTrace.i(3145392455680L, 23435);
    ap.yY();
    this.fOz = ((String)c.vr().get(4097, null));
    this.vaW = ((EditText)findViewById(R.h.btj));
    this.vba = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
    this.vrR = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
    this.vbc = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
    this.vsf = getIntent().getBooleanExtra("BIND_FIND_ME_BY_MOBILE", false);
    this.vsd = getIntent().getBooleanExtra("is_bind_for_change_mobile", false);
    this.jDA = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    Button localButton = (Button)findViewById(R.h.btg);
    if ((this.fOz == null) || (this.fOz.equals("")))
    {
      ap.yY();
      this.fOz = ((String)c.vr().get(6, null));
    }
    InputFilter local1 = new InputFilter()
    {
      public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        GMTrace.i(3105798225920L, 23140);
        paramAnonymousCharSequence = bf.K(paramAnonymousCharSequence);
        GMTrace.o(3105798225920L, 23140);
        return paramAnonymousCharSequence;
      }
    };
    this.vaW.setFilters(new InputFilter[] { local1 });
    this.vaZ = ((Button)findViewById(R.h.btl));
    this.vbO = ((TextView)findViewById(R.h.bth));
    boolean bool = this.vsf;
    if (!bool)
    {
      this.status |= 0x200;
      this.hgn.edit().putBoolean("settings_find_me_by_mobile", bool).commit();
      v.d("MicroMsg.BindMContactVerifyUI", "Bind mobile update = " + this.status);
      this.vbO.setText(getString(R.l.dNB, new Object[] { this.fOz }));
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          GMTrace.i(3102979653632L, 23119);
          paramAnonymousView = BindMContactVerifyUI.a(BindMContactVerifyUI.this).getText().toString().trim();
          if (paramAnonymousView.equals(""))
          {
            com.tencent.mm.ui.base.g.h(BindMContactVerifyUI.this, R.l.dOd, R.l.dIG);
            GMTrace.o(3102979653632L, 23119);
            return;
          }
          BindMContactVerifyUI.this.aGY();
          Object localObject1 = new hh();
          ((hh)localObject1).fMz.context = BindMContactVerifyUI.this;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
          localObject1 = ((hh)localObject1).fMA.fMB;
          Object localObject2 = new hi();
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
          localObject2 = ((hi)localObject2).fMC.fMD;
          int i = 2;
          if (BindMContactVerifyUI.b(BindMContactVerifyUI.this)) {
            i = 19;
          }
          paramAnonymousView = new com.tencent.mm.modelfriend.t(BindMContactVerifyUI.c(BindMContactVerifyUI.this), i, paramAnonymousView, "", (String)localObject1, (String)localObject2);
          ap.vd().a(paramAnonymousView, 0);
          localObject1 = BindMContactVerifyUI.this;
          localObject2 = BindMContactVerifyUI.this;
          BindMContactVerifyUI.this.getString(R.l.dIG);
          BindMContactVerifyUI.a((BindMContactVerifyUI)localObject1, com.tencent.mm.ui.base.g.a((Context)localObject2, BindMContactVerifyUI.this.getString(R.l.dNU), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              GMTrace.i(3129554763776L, 23317);
              ap.vd().c(paramAnonymousView);
              GMTrace.o(3129554763776L, 23317);
            }
          }));
          GMTrace.o(3102979653632L, 23119);
        }
      });
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(3127944151040L, 23305);
          BindMContactVerifyUI.d(BindMContactVerifyUI.this);
          GMTrace.o(3127944151040L, 23305);
          return true;
        }
      });
      localButton = this.vaZ;
      if (!com.tencent.mm.ai.b.jO(this.fOz)) {
        break label425;
      }
    }
    label425:
    for (int i = 0;; i = 8)
    {
      localButton.setVisibility(i);
      this.vaZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(3139889528832L, 23394);
          BindMContactVerifyUI.this.aGY();
          paramAnonymousView = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("bindmcontact_mobile", BindMContactVerifyUI.c(BindMContactVerifyUI.this));
          localBundle.putInt("voice_verify_type", 4);
          paramAnonymousView.putExtras(localBundle);
          com.tencent.mm.plugin.c.a.imb.e(BindMContactVerifyUI.this, paramAnonymousView);
          GMTrace.o(3139889528832L, 23394);
        }
      });
      GMTrace.o(3145392455680L, 23435);
      return;
      this.status &= 0xFDFF;
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(3145660891136L, 23437);
    v.i("MicroMsg.BindMContactVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((((com.tencent.mm.modelfriend.t)paramk).AJ() != 2) && (((com.tencent.mm.modelfriend.t)paramk).AJ() != 19))
    {
      GMTrace.o(3145660891136L, 23437);
      return;
    }
    if (this.irp != null)
    {
      this.irp.dismiss();
      this.irp = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((((com.tencent.mm.modelfriend.t)paramk).AJ() == 2) || (((com.tencent.mm.modelfriend.t)paramk).AJ() == 19))
      {
        if (this.fromScene == 5)
        {
          v.i("MicroMsg.BindMContactVerifyUI", "onScene end, finish wizard from app brand reg phone");
          zp(-1);
          GMTrace.o(3145660891136L, 23437);
          return;
        }
        if (this.vba)
        {
          if (!m.xT())
          {
            paramString = new rc();
            paramString.fXS.fXT = true;
            paramString.fXS.fXU = true;
            com.tencent.mm.sdk.b.a.uql.m(paramString);
          }
          zp(1);
          paramString = new Intent();
          paramString.addFlags(67108864);
          com.tencent.mm.plugin.c.a.imb.d(this, paramString);
          GMTrace.o(3145660891136L, 23437);
          return;
        }
        if (this.vbc)
        {
          zp(1);
          startActivity(new Intent(this, FindMContactAddUI.class));
          GMTrace.o(3145660891136L, 23437);
          return;
        }
        if ((this.status & 0x200) <= 0) {
          break label480;
        }
        paramInt1 = 1;
        ap.yY();
        c.vr().set(7, Integer.valueOf(this.status));
        paramString = new st();
        paramString.tyY = 8;
        if (paramInt1 == 0) {
          break label485;
        }
        paramInt1 = 1;
        label344:
        paramString.tyZ = paramInt1;
        ap.yY();
        c.wQ().b(new e.a(23, paramString));
        com.tencent.mm.plugin.c.a.imc.ou();
        if (!this.vrR)
        {
          getApplicationContext();
          com.tencent.mm.modelfriend.a.EM();
        }
        if (this.vsd) {
          com.tencent.mm.ui.base.g.bk(this, getString(R.l.dNg));
        }
        if (this.jDA)
        {
          if (!this.vrR) {
            break label490;
          }
          com.tencent.mm.plugin.report.service.g.oSF.i(11002, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
        }
      }
      for (;;)
      {
        w(this, new Intent(this, BindMContactStatusUI.class));
        GMTrace.o(3145660891136L, 23437);
        return;
        label480:
        paramInt1 = 0;
        break;
        label485:
        paramInt1 = 2;
        break label344;
        label490:
        com.tencent.mm.plugin.report.service.g.oSF.i(11002, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
      }
    }
    paramk = com.tencent.mm.f.a.dn(paramString);
    if (paramk != null)
    {
      paramk.a(this, null, null);
      GMTrace.o(3145660891136L, 23437);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.c.a.imc.a(this, paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      GMTrace.o(3145660891136L, 23437);
      return;
      switch (paramInt2)
      {
      default: 
        i = 0;
        break;
      case -34: 
        Toast.makeText(this, R.l.dNq, 0).show();
        i = 1;
        break;
      case -43: 
        Toast.makeText(this, R.l.dNn, 0).show();
        i = 1;
        break;
      case -214: 
        paramString = com.tencent.mm.f.a.dn(paramString);
        if (paramString != null) {
          paramString.a(this, null, null);
        }
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
        break;
      case -32: 
        com.tencent.mm.ui.base.g.a(this, R.l.dNY, R.l.btk, null);
        i = 1;
        break;
      case -33: 
        com.tencent.mm.ui.base.g.a(this, R.l.dNX, R.l.btk, null);
        i = 1;
      }
    }
    Toast.makeText(this, getString(R.l.dNW, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    GMTrace.o(3145660891136L, 23437);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(3145258237952L, 23434);
    int i = R.i.cVv;
    GMTrace.o(3145258237952L, 23434);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3144989802496L, 23432);
    super.onCreate(paramBundle);
    ap.vd().a(132, this);
    zd(R.l.dNK);
    this.hgn = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.status = m.xP();
    KD();
    GMTrace.o(3144989802496L, 23432);
  }
  
  public void onDestroy()
  {
    GMTrace.i(3145124020224L, 23433);
    ap.vd().b(132, this);
    super.onDestroy();
    GMTrace.o(3145124020224L, 23433);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(3145526673408L, 23436);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      zp(1);
      GMTrace.o(3145526673408L, 23436);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(3145526673408L, 23436);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindmobile/BindMContactVerifyUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */