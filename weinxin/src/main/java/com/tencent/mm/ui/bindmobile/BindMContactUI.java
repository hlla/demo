package com.tencent.mm.ui.bindmobile;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ae.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.friend.i.a;
import java.util.Map;

public class BindMContactUI
  extends MMWizardActivity
{
  private String countryCode;
  private String fOz;
  private int fromScene;
  private String hJn;
  private boolean jDA;
  private LinearLayout uXQ;
  private TextView uXR;
  private String uXU;
  private EditText vaJ;
  private TextView vaK;
  private com.tencent.mm.ui.friend.i vaL;
  private CheckBox vaP;
  private boolean vba;
  private boolean vbc;
  private boolean vrR;
  private TextView vsb;
  private LinearLayout vsc;
  private boolean vsd;
  
  public BindMContactUI()
  {
    GMTrace.i(3129957416960L, 23320);
    this.hJn = null;
    this.countryCode = null;
    this.uXU = null;
    this.vba = false;
    this.vrR = false;
    this.vbc = false;
    this.vsd = false;
    this.jDA = false;
    this.fromScene = 0;
    GMTrace.o(3129957416960L, 23320);
  }
  
  private void bSX()
  {
    GMTrace.i(3130494287872L, 23324);
    if ((this.vba) || (this.vrR))
    {
      uTt.clear();
      zp(1);
      GMTrace.o(3130494287872L, 23324);
      return;
    }
    int i;
    if (this.vsd)
    {
      i = R.l.dNu;
      if (!this.vsd) {
        break label101;
      }
    }
    label101:
    for (int j = R.l.dNw;; j = R.l.dNv)
    {
      com.tencent.mm.ui.base.g.a(this, i, j, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3101369040896L, 23107);
          BindMContactUI.a(BindMContactUI.this);
          GMTrace.o(3101369040896L, 23107);
        }
      }, null);
      GMTrace.o(3130494287872L, 23324);
      return;
      i = R.l.dNt;
      break;
    }
  }
  
  protected final void KD()
  {
    GMTrace.i(3130628505600L, 23325);
    this.vba = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
    this.vrR = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
    this.vbc = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
    this.vsd = getIntent().getBooleanExtra("is_bind_for_change_mobile", false);
    this.jDA = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    v.i("MicroMsg.BindMContactUI", "bindScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    this.vaJ = ((EditText)findViewById(R.h.btb));
    this.uXQ = ((LinearLayout)findViewById(R.h.bGJ));
    this.uXR = ((TextView)findViewById(R.h.bGL));
    this.vaK = ((TextView)findViewById(R.h.bGH));
    this.vaP = ((CheckBox)findViewById(R.h.bsY));
    this.vsc = ((LinearLayout)findViewById(R.h.bsZ));
    this.vsb = ((TextView)findViewById(R.h.cCK));
    String str1;
    if (this.vsd)
    {
      ap.yY();
      String str2 = (String)com.tencent.mm.u.c.vr().get(6, null);
      if (!bf.mA(str2))
      {
        if (!str2.startsWith("+")) {
          break label517;
        }
        str1 = am.yS(str2);
        str2 = str2.substring(str1.length() + 1);
        new am();
        str1 = am.formatNumber(str1, str2);
        this.vsb.setText(getString(R.l.dNi, new Object[] { str1 }));
      }
    }
    if ((this.hJn != null) && (!this.hJn.equals(""))) {
      this.uXR.setText(this.hJn);
    }
    if ((this.countryCode != null) && (!this.countryCode.equals(""))) {
      this.vaK.setText("+" + this.countryCode);
    }
    if ((this.uXU != null) && (!this.uXU.equals("")))
    {
      this.vaJ.setText(this.uXU);
      this.vaJ.setSelection(this.uXU.length());
    }
    for (;;)
    {
      if (com.tencent.mm.ai.b.Hq())
      {
        this.vsc.setVisibility(4);
        this.vaP.setChecked(true);
      }
      a(0, getString(R.l.dHH), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(3125125578752L, 23284);
          BindMContactUI.a(BindMContactUI.this, BindMContactUI.d(BindMContactUI.this).getText().toString().trim() + bf.za(BindMContactUI.b(BindMContactUI.this).getText().toString()));
          if ((!com.tencent.mm.pluginsdk.a.Lz(BindMContactUI.e(BindMContactUI.this))) || (bf.za(BindMContactUI.b(BindMContactUI.this).getText().toString()).length() <= 0))
          {
            com.tencent.mm.ui.base.g.h(BindMContactUI.this, R.l.dND, R.l.dIG);
            GMTrace.o(3125125578752L, 23284);
            return true;
          }
          v.i("MicroMsg.BindMContactUI", "do next, send sms to self");
          BindMContactUI.b(BindMContactUI.this, BindMContactUI.e(BindMContactUI.this));
          GMTrace.o(3125125578752L, 23284);
          return true;
        }
      });
      this.vaJ.requestFocus();
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(3123783401472L, 23274);
          BindMContactUI.f(BindMContactUI.this);
          GMTrace.o(3123783401472L, 23274);
          return true;
        }
      });
      this.uXQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(3127407280128L, 23301);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMContactUI.g(BindMContactUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMContactUI.c(BindMContactUI.this));
          com.tencent.mm.plugin.c.a.imb.b(paramAnonymousView, BindMContactUI.this);
          GMTrace.o(3127407280128L, 23301);
        }
      });
      GMTrace.o(3130628505600L, 23325);
      return;
      label517:
      str1 = "86";
      break;
      ap.vL().a(new ae.a()
      {
        String ktE;
        
        public final boolean Bn()
        {
          GMTrace.i(3123380748288L, 23271);
          this.ktE = com.tencent.mm.modelsimple.c.y(BindMContactUI.this, BindMContactUI.c(BindMContactUI.this));
          GMTrace.o(3123380748288L, 23271);
          return true;
        }
        
        public final boolean Bo()
        {
          GMTrace.i(3123246530560L, 23270);
          if (bf.mA(BindMContactUI.b(BindMContactUI.this).getText().trim()))
          {
            if (bf.mA(this.ktE)) {
              break label93;
            }
            BindMContactUI.b(BindMContactUI.this).setText(this.ktE);
            BindMContactUI.b(BindMContactUI.this).setSelection(this.ktE.length());
          }
          for (;;)
          {
            GMTrace.o(3123246530560L, 23270);
            return true;
            label93:
            BindMContactUI.b(BindMContactUI.this).setText("");
          }
        }
        
        public final String toString()
        {
          GMTrace.i(3123514966016L, 23272);
          String str = super.toString() + "|initView";
          GMTrace.o(3123514966016L, 23272);
          return str;
        }
      });
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(3130896941056L, 23327);
    int i = R.i.cVs;
    GMTrace.o(3130896941056L, 23327);
    return i;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(3130762723328L, 23326);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      GMTrace.o(3130762723328L, 23326);
      return;
      this.hJn = bf.ap(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bf.ap(paramIntent.getStringExtra("couttry_code"), "");
      if (!this.hJn.equals("")) {
        this.uXR.setText(this.hJn);
      }
      if (!this.countryCode.equals("")) {
        this.vaK.setText("+" + this.countryCode);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3130091634688L, 23321);
    super.onCreate(paramBundle);
    zd(R.l.dNH);
    this.hJn = bf.ap(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bf.ap(getIntent().getStringExtra("couttry_code"), "");
    this.uXU = bf.ap(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    KD();
    GMTrace.o(3130091634688L, 23321);
  }
  
  public void onDestroy()
  {
    GMTrace.i(3130225852416L, 23322);
    super.onDestroy();
    if (this.vaL != null)
    {
      getContentResolver().unregisterContentObserver(this.vaL);
      this.vaL.recycle();
    }
    GMTrace.o(3130225852416L, 23322);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(3130360070144L, 23323);
    if (paramInt == 4)
    {
      bSX();
      GMTrace.o(3130360070144L, 23323);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(3130360070144L, 23323);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    GMTrace.i(3131031158784L, 23328);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      if (paramArrayOfInt == null) {}
      for (int i = -1;; i = paramArrayOfInt.length)
      {
        v.w("MicroMsg.BindMContactUI", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bf.bJP() });
        GMTrace.o(3131031158784L, 23328);
        return;
      }
    }
    v.i("MicroMsg.BindMContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(3131031158784L, 23328);
      return;
      if ((paramArrayOfInt[0] == 0) && (this.vaL != null)) {
        this.vaL.bRc();
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindmobile/BindMContactUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */