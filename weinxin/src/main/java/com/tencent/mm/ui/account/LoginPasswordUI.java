package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.n;

public class LoginPasswordUI
  extends LoginHistoryUI
{
  private static String TAG;
  
  static
  {
    GMTrace.i(16829024043008L, 125386);
    TAG = "LoginPasswordUI";
    GMTrace.o(16829024043008L, 125386);
  }
  
  public LoginPasswordUI()
  {
    GMTrace.i(16828621389824L, 125383);
    GMTrace.o(16828621389824L, 125383);
  }
  
  protected final void Tn()
  {
    GMTrace.i(16828889825280L, 125385);
    super.Tn();
    if ((isFinishing()) || (getWindow() == null))
    {
      v.e(TAG, "LoginHistoryUI is finishing");
      GMTrace.o(16828889825280L, 125385);
      return;
    }
    this.uWv.uXd = this.lhX.getText().toString();
    if (this.uWv.hRY.equals(""))
    {
      g.h(this, R.l.eZS, R.l.ewF);
      GMTrace.o(16828889825280L, 125385);
      return;
    }
    if (this.uWv.uXd.equals(""))
    {
      g.h(this, R.l.eZP, R.l.ewF);
      GMTrace.o(16828889825280L, 125385);
      return;
    }
    aGY();
    bQC();
    final u localu = new u(this.uWv.hRY, this.uWv.uXd, this.oTE, 0);
    ap.vd().a(localu, 0);
    getString(R.l.dIG);
    this.isb = g.a(this, getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(16839224590336L, 125462);
        ap.vd().c(localu);
        LoginPasswordUI.this.bQD();
        GMTrace.o(16839224590336L, 125462);
      }
    });
    GMTrace.o(16828889825280L, 125385);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(16828755607552L, 125384);
    super.onCreate(paramBundle);
    if (this.uWI)
    {
      GMTrace.o(16828755607552L, 125384);
      return;
    }
    this.iQr = 2;
    this.uWG.setVisibility(0);
    this.uWq.setVisibility(0);
    this.lhX.setTypeface(Typeface.DEFAULT);
    this.lhX.setTransformationMethod(new PasswordTransformationMethod());
    this.lhX.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        GMTrace.i(16818018189312L, 125304);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          LoginPasswordUI.this.Tn();
          GMTrace.o(16818018189312L, 125304);
          return true;
        }
        GMTrace.o(16818018189312L, 125304);
        return false;
      }
    });
    this.lhX.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        GMTrace.i(16821373632512L, 125329);
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          LoginPasswordUI.this.Tn();
          GMTrace.o(16821373632512L, 125329);
          return true;
        }
        GMTrace.o(16821373632512L, 125329);
        return false;
      }
    });
    this.lhX.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        GMTrace.i(16839493025792L, 125464);
        if (LoginPasswordUI.this.lhX.getText().toString().length() > 0)
        {
          LoginPasswordUI.this.uWq.setEnabled(true);
          GMTrace.o(16839493025792L, 125464);
          return;
        }
        LoginPasswordUI.this.uWq.setEnabled(false);
        GMTrace.o(16839493025792L, 125464);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(16839627243520L, 125465);
        GMTrace.o(16839627243520L, 125465);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(16839761461248L, 125466);
        GMTrace.o(16839761461248L, 125466);
      }
    });
    if (this.lhX.getText().toString().length() > 0) {
      this.uWq.setEnabled(true);
    }
    for (;;)
    {
      this.uWq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16827950301184L, 125378);
          LoginPasswordUI.this.Tn();
          GMTrace.o(16827950301184L, 125378);
        }
      });
      this.oTE = getIntent().getStringExtra("auth_ticket");
      if (!bf.mA(this.oTE))
      {
        this.uWp.setText(bf.mz(f.bQG()));
        this.lhX.setText(bf.mz(f.bQH()));
        new ad().postDelayed(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(16821642067968L, 125331);
            LoginPasswordUI.this.Tn();
            GMTrace.o(16821642067968L, 125331);
          }
        }, 500L);
      }
      GMTrace.o(16828755607552L, 125384);
      return;
      this.uWq.setEnabled(false);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/LoginPasswordUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */