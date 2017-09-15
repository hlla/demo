package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.n;

public class LoginSmsUI
  extends LoginHistoryUI
{
  private static String TAG;
  
  static
  {
    GMTrace.i(16822715809792L, 125339);
    TAG = "LoginSmsUI";
    GMTrace.o(16822715809792L, 125339);
  }
  
  public LoginSmsUI()
  {
    GMTrace.i(16821776285696L, 125332);
    GMTrace.o(16821776285696L, 125332);
  }
  
  protected final void Tn()
  {
    GMTrace.i(16822044721152L, 125334);
    super.Tn();
    if ((isFinishing()) || (getWindow() == null))
    {
      v.e(TAG, "LoginHistoryUI is finishing");
      GMTrace.o(16822044721152L, 125334);
      return;
    }
    if (!bf.mA(this.uWx))
    {
      this.uWv.hRY = this.uWx;
      aGY();
      bQC();
      final s locals = new s(this.uWx, 17, this.uWH.getText().toString().trim(), 0, "");
      ap.vd().a(locals, 0);
      getString(R.l.dIG);
      this.isb = g.a(this, getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(16843519557632L, 125494);
          ap.vd().c(locals);
          GMTrace.o(16843519557632L, 125494);
        }
      });
    }
    GMTrace.o(16822044721152L, 125334);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(16821910503424L, 125333);
    super.onCreate(paramBundle);
    if (this.uWI)
    {
      GMTrace.o(16821910503424L, 125333);
      return;
    }
    this.iQr = 3;
    if ((!bf.Qg(this.uWC).booleanValue()) && (bf.Qg(this.uWx).booleanValue())) {
      this.uWp.setText(Dg(this.uWx));
    }
    this.uWH.setVisibility(0);
    this.uWH.bRJ();
    this.uWH.vhM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(16840298332160L, 125470);
        g.a(LoginSmsUI.this, LoginSmsUI.this.getString(R.l.eJN) + LoginSmsUI.this.uWx, LoginSmsUI.this.getString(R.l.eJO), LoginSmsUI.this.getString(R.l.dHL), LoginSmsUI.this.getString(R.l.dGk), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            GMTrace.i(16834795405312L, 125429);
            LoginSmsUI.this.uWH.bRI();
            LoginSmsUI.a(LoginSmsUI.this, LoginSmsUI.this.uWx);
            GMTrace.o(16834795405312L, 125429);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            GMTrace.i(16820836761600L, 125325);
            LoginSmsUI.this.uWH.reset();
            GMTrace.o(16820836761600L, 125325);
          }
        });
        GMTrace.o(16840298332160L, 125470);
      }
    };
    paramBundle = this.uWH;
    TextWatcher local2 = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        GMTrace.i(16828218736640L, 125380);
        if (LoginSmsUI.this.uWH.getText().toString().length() > 0)
        {
          LoginSmsUI.this.uWq.setEnabled(true);
          GMTrace.o(16828218736640L, 125380);
          return;
        }
        LoginSmsUI.this.uWq.setEnabled(false);
        GMTrace.o(16828218736640L, 125380);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(16828352954368L, 125381);
        GMTrace.o(16828352954368L, 125381);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(16828487172096L, 125382);
        GMTrace.o(16828487172096L, 125382);
      }
    };
    if (paramBundle.oAr != null)
    {
      paramBundle.oAr.addTextChangedListener(local2);
      if (this.uWH.getText().toString().length() <= 0) {
        break label215;
      }
      this.uWq.setEnabled(true);
    }
    for (;;)
    {
      this.uWq.setVisibility(0);
      this.uWq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16840835203072L, 125474);
          LoginSmsUI.this.Tn();
          GMTrace.o(16840835203072L, 125474);
        }
      });
      GMTrace.o(16821910503424L, 125333);
      return;
      v.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[] { local2, paramBundle.oAr });
      break;
      label215:
      this.uWq.setEnabled(false);
    }
  }
  
  public void onDestroy()
  {
    GMTrace.i(16822447374336L, 125337);
    super.onDestroy();
    this.uWH.reset();
    GMTrace.o(16822447374336L, 125337);
  }
  
  public void onResume()
  {
    GMTrace.i(16822178938880L, 125335);
    super.onResume();
    ap.vd().a(145, this);
    GMTrace.o(16822178938880L, 125335);
  }
  
  protected void onStop()
  {
    GMTrace.i(16822313156608L, 125336);
    super.onStop();
    ap.vd().b(145, this);
    GMTrace.o(16822313156608L, 125336);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/LoginSmsUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */