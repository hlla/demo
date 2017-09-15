package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.widget.MMEditText.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;

public class ModRemarkNameUI
  extends MMActivity
  implements e
{
  private String fRV;
  private String iAN;
  private x jht;
  private bb oGo;
  private int orm;
  private ArrayList<String> orw;
  private String osd;
  private MMTagPanel ouO;
  private TextView vUV;
  private View vUW;
  private View vUX;
  private View vUY;
  private TextView vVg;
  private EditText vWX;
  private int vWY;
  private String vWZ;
  private TextView vXa;
  private EditText vXb;
  private TextView vXc;
  private String vXd;
  private boolean vXe;
  private a vXf;
  private View vXg;
  
  public ModRemarkNameUI()
  {
    GMTrace.i(1758118019072L, 13099);
    this.vWZ = "";
    this.iAN = "";
    this.vXa = null;
    this.vXb = null;
    this.vXc = null;
    this.vXd = "";
    this.vXe = false;
    this.orm = 9;
    this.vXf = new a();
    GMTrace.o(1758118019072L, 13099);
  }
  
  protected final void KD()
  {
    GMTrace.i(1758520672256L, 13102);
    this.fRV = getIntent().getStringExtra("Contact_User");
    if ((this.fRV != null) && (this.fRV.length() > 0))
    {
      ap.yY();
      this.jht = com.tencent.mm.u.c.wR().Rb(this.fRV);
      ap.yY();
      this.oGo = com.tencent.mm.u.c.wS().AG(this.fRV);
      if ((this.jht == null) || (u.mA(this.jht.field_username)))
      {
        this.jht = new x(this.fRV);
        this.jht.bR(u.mz(this.vWZ));
        this.jht.bP(u.mz(this.iAN));
      }
    }
    this.vWX = ((EditText)findViewById(R.h.bFj));
    final Object localObject = new MMEditText.b()
    {
      public final void aXJ()
      {
        GMTrace.i(1789524967424L, 13333);
        if (ModRemarkNameUI.a(ModRemarkNameUI.this).getText().toString().trim().length() > 0) {
          ModRemarkNameUI.this.ko(true);
        }
        GMTrace.o(1789524967424L, 13333);
      }
    };
    h.a locala = new h.a();
    locala.sUR = ((MMEditText.b)localObject);
    this.vWX.addTextChangedListener(locala);
    com.tencent.mm.ui.tools.a.c.d(this.vWX).Cc(100).a(null);
    if ((this.jht != null) && (this.vWY != 3))
    {
      if (this.vWY == 4)
      {
        this.vWX.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.vWZ), this.vWX.getTextSize()));
        this.vWX.setSelection(this.vWX.getText().length());
      }
    }
    else
    {
      if (this.vWY != 0) {
        break label981;
      }
      zd(R.l.dYH);
      localObject = com.tencent.mm.modelfriend.af.FZ().ja(this.jht.field_username);
      if ((localObject != null) && (!u.mA(((com.tencent.mm.modelfriend.b)localObject).ES())) && (!((com.tencent.mm.modelfriend.b)localObject).ES().equals(this.vWX.getText()))) {
        break label893;
      }
      label329:
      a(0, getString(R.l.dIp), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(1737314271232L, 12944);
          switch (ModRemarkNameUI.b(ModRemarkNameUI.this))
          {
          }
          for (;;)
          {
            GMTrace.o(1737314271232L, 12944);
            return true;
            ModRemarkNameUI.c(ModRemarkNameUI.this);
            continue;
            ModRemarkNameUI.d(ModRemarkNameUI.this);
            continue;
            ModRemarkNameUI.e(ModRemarkNameUI.this);
          }
        }
      });
      if ((this.vWX == null) || (this.vWX.getText().toString().trim().length() <= 0)) {
        break label1114;
      }
      ko(true);
    }
    for (;;)
    {
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(1749662302208L, 13036);
          ModRemarkNameUI.this.finish();
          GMTrace.o(1749662302208L, 13036);
          return true;
        }
      });
      this.vXa = ((TextView)findViewById(R.h.bFq));
      this.vXb = ((EditText)findViewById(R.h.bFi));
      this.vXc = ((TextView)findViewById(R.h.cSY));
      this.vUY = findViewById(R.h.bFh);
      com.tencent.mm.ui.tools.a.c.d(this.vXb).Cc(800).a(null);
      this.vXc.setText(com.tencent.mm.ui.tools.h.aH(800, this.vXb.getEditableText().toString()));
      this.vXb.append(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.vXd), this.vXb.getTextSize()));
      this.vXa.append(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.vXd), this.vXa.getTextSize()));
      if (this.oGo != null)
      {
        this.vXb.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.oGo.field_conDescription), this.vXb.getTextSize()));
        this.vXa.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.oGo.field_conDescription), this.vXb.getTextSize()));
      }
      this.vXb.addTextChangedListener(new b());
      this.vXa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(1761339244544L, 13123);
          ModRemarkNameUI.f(ModRemarkNameUI.this).setVisibility(0);
          ModRemarkNameUI.g(ModRemarkNameUI.this).setVisibility(8);
          ModRemarkNameUI.h(ModRemarkNameUI.this).requestFocus();
          ModRemarkNameUI.this.aHc();
          GMTrace.o(1761339244544L, 13123);
        }
      });
      GMTrace.o(1758520672256L, 13102);
      return;
      if (!u.mA(this.jht.field_conRemark))
      {
        this.vWX.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.jht.field_conRemark), this.vWX.getTextSize()));
        break;
      }
      if (!u.mA(this.iAN))
      {
        this.vWX.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.iAN), this.vWX.getTextSize()));
        break;
      }
      if (!u.mA(this.jht.field_nickname))
      {
        this.vWX.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.jht.field_nickname), this.vWX.getTextSize()));
        break;
      }
      if (!u.mA(this.vWZ))
      {
        this.vWX.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.vWZ), this.vWX.getTextSize()));
        break;
      }
      localObject = this.jht.field_nickname;
      if ((u.mA((String)localObject)) || (((String)localObject).length() > 50)) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label881;
        }
        this.vWX.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, u.mz(this.jht.tL()), this.vWX.getTextSize()));
        break;
      }
      label881:
      this.vWX.setText("");
      break;
      label893:
      this.vUV = ((TextView)findViewById(R.h.ckL));
      this.vUW = findViewById(R.h.ckG);
      this.vUX = findViewById(R.h.ckM);
      this.vUW.setVisibility(0);
      this.vUV.setText(getString(R.l.dZu, new Object[] { ((com.tencent.mm.modelfriend.b)localObject).ES() }));
      this.vUX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(1811536674816L, 13497);
          ModRemarkNameUI.a(ModRemarkNameUI.this).setText(localObject.ES());
          ModRemarkNameUI.a(ModRemarkNameUI.this).setSelection(ModRemarkNameUI.a(ModRemarkNameUI.this).getText().length());
          ModRemarkNameUI.i(ModRemarkNameUI.this).setVisibility(8);
          GMTrace.o(1811536674816L, 13497);
        }
      });
      break label329;
      label981:
      if (this.vWY == 3)
      {
        zd(R.l.eXn);
        this.vWX.setHint("");
        if (!u.mA(this.vWZ)) {
          this.vWX.setText(this.vWZ);
        }
        localObject = (TextView)findViewById(R.h.bFk);
        ((TextView)localObject).setText(R.l.eRi);
        ((TextView)localObject).setVisibility(0);
        findViewById(R.h.ckH).setVisibility(8);
        break label329;
      }
      if (this.vWY != 4) {
        break label329;
      }
      zd(R.l.eMH);
      this.vWX.setHint("");
      localObject = (TextView)findViewById(R.h.bFk);
      ((TextView)localObject).setText(R.l.eNa);
      ((TextView)localObject).setVisibility(0);
      break label329;
      label1114:
      ko(false);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(1758923325440L, 13105);
    v.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramk.getType() == 44)
    {
      if ((paramInt1 != 0) && (paramInt2 < 0))
      {
        v.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
        Toast.makeText(this, getString(R.l.eMU, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      finish();
    }
    GMTrace.o(1758923325440L, 13105);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(1758386454528L, 13101);
    int i = R.i.djr;
    GMTrace.o(1758386454528L, 13101);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1758252236800L, 13100);
    super.onCreate(paramBundle);
    this.orm = getIntent().getIntExtra("Contact_Scene", 9);
    this.vWY = getIntent().getIntExtra("Contact_mode_name_type", 0);
    this.vWZ = u.mz(getIntent().getStringExtra("Contact_Nick"));
    this.iAN = u.mz(getIntent().getStringExtra("Contact_RemarkName"));
    this.vXe = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
    KD();
    this.vXg = findViewById(R.h.bFf);
    if (this.vWY != 0) {
      this.vXg.setVisibility(8);
    }
    for (;;)
    {
      this.ouO = ((MMTagPanel)findViewById(R.h.bFg));
      this.ouO.mpl = false;
      this.vVg = ((TextView)findViewById(R.h.bFe));
      this.vVg.setText(R.l.eBc);
      this.ouO.setOnClickListener(this.vXf);
      this.vVg.setOnClickListener(this.vXf);
      GMTrace.o(1758252236800L, 13100);
      return;
      this.vXg.setVisibility(0);
    }
  }
  
  public void onDestroy()
  {
    GMTrace.i(1758789107712L, 13104);
    super.onDestroy();
    GMTrace.o(1758789107712L, 13104);
  }
  
  protected void onResume()
  {
    GMTrace.i(1758654889984L, 13103);
    super.onResume();
    ap.yY();
    this.oGo = com.tencent.mm.u.c.wS().AG(this.fRV);
    if (this.oGo != null)
    {
      this.osd = this.oGo.field_contactLabels;
      this.orw = ((ArrayList)a.aFz().zd(this.osd));
    }
    if (!u.mA(this.osd))
    {
      this.ouO.setVisibility(0);
      this.vVg.setVisibility(8);
      if ((this.orw != null) && (!this.orw.isEmpty()))
      {
        this.ouO.a(this.orw, this.orw);
        GMTrace.o(1758654889984L, 13103);
      }
    }
    else
    {
      this.ouO.setVisibility(8);
      this.vVg.setVisibility(0);
    }
    GMTrace.o(1758654889984L, 13103);
  }
  
  private final class a
    implements View.OnClickListener
  {
    public a()
    {
      GMTrace.i(1755970535424L, 13083);
      GMTrace.o(1755970535424L, 13083);
    }
    
    public final void onClick(View paramView)
    {
      GMTrace.i(1756104753152L, 13084);
      ModRemarkNameUI.l(ModRemarkNameUI.this);
      GMTrace.o(1756104753152L, 13084);
    }
  }
  
  private final class b
    implements TextWatcher
  {
    private int pgY;
    
    public b()
    {
      GMTrace.i(1836769607680L, 13685);
      this.pgY = 800;
      GMTrace.o(1836769607680L, 13685);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      GMTrace.i(1837172260864L, 13688);
      this.pgY = com.tencent.mm.ui.tools.h.aH(800, paramEditable.toString());
      if (this.pgY < 0) {
        this.pgY = 0;
      }
      if (ModRemarkNameUI.j(ModRemarkNameUI.this) != null) {
        ModRemarkNameUI.j(ModRemarkNameUI.this).setText(this.pgY);
      }
      ModRemarkNameUI.k(ModRemarkNameUI.this);
      GMTrace.o(1837172260864L, 13688);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(1836903825408L, 13686);
      GMTrace.o(1836903825408L, 13686);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(1837038043136L, 13687);
      GMTrace.o(1837038043136L, 13687);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/ModRemarkNameUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */