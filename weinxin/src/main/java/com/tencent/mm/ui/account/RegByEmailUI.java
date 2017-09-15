package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoCompleteTextView;
import com.tencent.mm.ui.base.MMAutoCompleteTextView.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.Map;
import java.util.Set;

public class RegByEmailUI
  extends MMActivity
  implements e
{
  private static String[] uXM;
  private String gkk;
  private ProgressDialog isb;
  private String oTI;
  private MMAutoCompleteTextView uXH;
  private EditText uXI;
  private CheckBox uXJ;
  private String uXK;
  private Map<String, String> uXL;
  private String uXd;
  
  public RegByEmailUI()
  {
    GMTrace.i(2690662793216L, 20047);
    this.isb = null;
    GMTrace.o(2690662793216L, 20047);
  }
  
  private void goBack()
  {
    GMTrace.i(2691468099584L, 20053);
    g.a(this, R.l.eIW, R.l.eIZ, R.l.dHL, R.l.dGk, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(2728914845696L, 20332);
        b.mN(RegByEmailUI.f(RegByEmailUI.this));
        RegByEmailUI.this.aGY();
        RegByEmailUI.this.finish();
        GMTrace.o(2728914845696L, 20332);
      }
    }, null);
    GMTrace.o(2691468099584L, 20053);
  }
  
  protected final void KD()
  {
    GMTrace.i(2691333881856L, 20052);
    this.uXH = ((MMAutoCompleteTextView)findViewById(R.h.cxg));
    this.uXI = ((EditText)findViewById(R.h.cxm));
    this.uXJ = ((CheckBox)findViewById(R.h.bnU));
    if (!bf.mA(this.uXK))
    {
      this.uXI.postDelayed(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2686367825920L, 20015);
          RegByEmailUI.a(RegByEmailUI.this).requestFocus();
          GMTrace.o(2686367825920L, 20015);
        }
      }, 500L);
      this.uXH.setText(this.uXK);
    }
    if (uXM != null)
    {
      c localc = new c(this, uXM, "@");
      MMAutoCompleteTextView localMMAutoCompleteTextView = this.uXH;
      if (!bf.mA("@"))
      {
        localMMAutoCompleteTextView.vgI = new MMAutoCompleteTextView.a(localMMAutoCompleteTextView, "@");
        localMMAutoCompleteTextView.addTextChangedListener(localMMAutoCompleteTextView.vgI);
      }
      this.uXH.setDropDownAnchor(R.h.cxh);
      this.uXH.setDropDownVerticalOffset(this.uXH.getPaddingBottom());
      this.uXH.setAdapter(localc);
    }
    findViewById(R.h.bnT).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2656974143488L, 19796);
        bf.F(RegByEmailUI.this, RegByEmailUI.this.getString(R.l.eZh));
        GMTrace.o(2656974143488L, 19796);
      }
    });
    this.uXJ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        GMTrace.i(2781796630528L, 20726);
        RegByEmailUI.b(RegByEmailUI.this);
        GMTrace.o(2781796630528L, 20726);
      }
    });
    a(0, getString(R.l.dHH), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2733209812992L, 20364);
        RegByEmailUI.c(RegByEmailUI.this);
        GMTrace.o(2733209812992L, 20364);
        return true;
      }
    });
    ko(false);
    this.uXH.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        GMTrace.i(2641136451584L, 19678);
        RegByEmailUI.b(RegByEmailUI.this);
        GMTrace.o(2641136451584L, 19678);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(2641270669312L, 19679);
        GMTrace.o(2641270669312L, 19679);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(2641404887040L, 19680);
        GMTrace.o(2641404887040L, 19680);
      }
    });
    this.uXI.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        GMTrace.i(2650800128000L, 19750);
        RegByEmailUI.b(RegByEmailUI.this);
        GMTrace.o(2650800128000L, 19750);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(2650934345728L, 19751);
        GMTrace.o(2650934345728L, 19751);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(2651068563456L, 19752);
        GMTrace.o(2651068563456L, 19752);
      }
    });
    this.uXI.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        GMTrace.i(2669859045376L, 19892);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          if (!RegByEmailUI.d(RegByEmailUI.this).isChecked())
          {
            GMTrace.o(2669859045376L, 19892);
            return false;
          }
          RegByEmailUI.c(RegByEmailUI.this);
          GMTrace.o(2669859045376L, 19892);
          return true;
        }
        GMTrace.o(2669859045376L, 19892);
        return false;
      }
    });
    this.uXI.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        GMTrace.i(2785017856000L, 20750);
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          if (!RegByEmailUI.d(RegByEmailUI.this).isChecked())
          {
            GMTrace.o(2785017856000L, 20750);
            return false;
          }
          RegByEmailUI.c(RegByEmailUI.this);
          GMTrace.o(2785017856000L, 20750);
          return true;
        }
        GMTrace.o(2785017856000L, 20750);
        return false;
      }
    });
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2639257403392L, 19664);
        RegByEmailUI.e(RegByEmailUI.this);
        GMTrace.o(2639257403392L, 19664);
        return true;
      }
    });
    GMTrace.o(2691333881856L, 20052);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2691736535040L, 20055);
    v.i("MicroMsg.RegByEmailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((this.isb != null) && (this.isb.isShowing()))
    {
      this.isb.dismiss();
      this.isb = null;
    }
    if (paramk.getType() != 481)
    {
      v.e("MicroMsg.RegByEmailUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramk.getType()) });
      GMTrace.o(2691736535040L, 20055);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      b.mN("R500_200");
      paramString = new Intent(this, EmailVerifyUI.class);
      paramString.putExtra("email_address", this.gkk);
      paramString.putExtra("password", this.uXd);
      if ((this.uXL != null) && (!this.uXL.isEmpty()))
      {
        paramk = this.gkk.split("@");
        if ((paramk != null) && (paramk.length == 2))
        {
          paramk = paramk[1];
          paramString.putExtra("email_login_page", (String)this.uXL.get(paramk));
        }
      }
      startActivity(paramString);
      GMTrace.o(2691736535040L, 20055);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.c.a.imc.a(this, paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      GMTrace.o(2691736535040L, 20055);
      return;
      i = 0;
      switch (paramInt2)
      {
      default: 
        break;
      case -111: 
        g.h(this, R.l.eJc, R.l.eIZ);
        i = 1;
        break;
      case -7: 
        b.mO(ap.uY() + "," + getClass().getName() + ",R20_email_duplicate_confirm," + ap.ec("R20_email_duplicate_confirm") + ",3");
        g.a(this, R.l.eJj, R.l.eIZ, R.l.eJl, R.l.eJk, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2781528195072L, 20724);
            RegByEmailUI.this.finish();
            b.mN("L2_signup");
            paramAnonymousDialogInterface = new Intent(RegByEmailUI.this, LoginPasswordUI.class);
            paramAnonymousDialogInterface.putExtra("email_address", RegByEmailUI.g(RegByEmailUI.this));
            RegByEmailUI.this.startActivity(paramAnonymousDialogInterface);
            GMTrace.o(2781528195072L, 20724);
          }
        }, null);
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, R.l.eIX, 0).show();
        i = 1;
        break;
      case -75: 
        g.h(this, R.l.dCW, R.l.eIT);
        i = 1;
      }
    }
    if (!bf.mA(paramString))
    {
      paramString = bg.q(paramString, "e");
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = (String)paramString.get(".e.Content");
        if (!bf.mA(paramString))
        {
          g.b(this, paramString, getString(R.l.eIZ), true);
          GMTrace.o(2691736535040L, 20055);
          return;
        }
      }
    }
    Toast.makeText(this, getString(R.l.eJg, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    GMTrace.o(2691736535040L, 20055);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2691199664128L, 20051);
    int i = R.i.dmk;
    GMTrace.o(2691199664128L, 20051);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2690797010944L, 20048);
    super.onCreate(paramBundle);
    paramBundle = getString(R.l.eJi);
    if (com.tencent.mm.protocal.d.sXk) {
      paramBundle = getString(R.l.bpC) + getString(R.l.dCT);
    }
    qL(paramBundle);
    com.tencent.mm.plugin.c.a.imc.ox();
    this.uXK = com.tencent.mm.modelsimple.d.bj(this);
    v.i("MicroMsg.RegByEmailUI", "get google account:[%s]", new Object[] { this.uXK });
    this.uXL = com.tencent.mm.plugin.accountsync.b.a.irF.bs(this);
    if ((this.uXL != null) && (!this.uXL.isEmpty()))
    {
      uXM = new String[this.uXL.size()];
      this.uXL.keySet().toArray(uXM);
    }
    this.oTI = b.OA();
    KD();
    GMTrace.o(2690797010944L, 20048);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2691602317312L, 20054);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      GMTrace.o(2691602317312L, 20054);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2691602317312L, 20054);
    return bool;
  }
  
  protected void onPause()
  {
    GMTrace.i(2691065446400L, 20050);
    super.onPause();
    ap.vd().b(481, this);
    b.b(false, ap.uY() + "," + getClass().getName() + ",R500_100," + ap.ec("R500_100") + ",2");
    GMTrace.o(2691065446400L, 20050);
  }
  
  protected void onResume()
  {
    GMTrace.i(2690931228672L, 20049);
    super.onResume();
    ap.vd().a(481, this);
    b.b(true, ap.uY() + "," + getClass().getName() + ",R500_100," + ap.ec("R500_100") + ",1");
    b.mM("R500_100");
    GMTrace.o(2690931228672L, 20049);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/RegByEmailUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */