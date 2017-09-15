package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.c.os;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.p.a;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSwitchEditText;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.a;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.b;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.Iterator;

public class EmailVerifyUI
  extends MMActivity
  implements e
{
  private ProgressDialog isb;
  private String oTI;
  private TextView uVA;
  private MMAutoSwitchEditTextView uVB;
  private Button uVC;
  private Button uVD;
  private String uVE;
  private String uVF;
  private String uVG;
  private String uVH;
  private boolean uVI;
  private TextView uVz;
  
  public EmailVerifyUI()
  {
    GMTrace.i(2671872311296L, 19907);
    this.isb = null;
    this.uVI = false;
    GMTrace.o(2671872311296L, 19907);
  }
  
  private void goBack()
  {
    GMTrace.i(2672811835392L, 19914);
    b.mN(this.oTI);
    finish();
    GMTrace.o(2672811835392L, 19914);
  }
  
  protected final void KD()
  {
    GMTrace.i(2672543399936L, 19912);
    zd(R.l.eJo);
    this.uVz = ((TextView)findViewById(R.h.cLq));
    String str = getString(R.l.eJb);
    this.uVz.setText(Html.fromHtml(str));
    this.uVA = ((TextView)findViewById(R.h.bKK));
    this.uVE = getIntent().getStringExtra("email_address");
    if (!bf.mA(this.uVE))
    {
      this.uVA.setText(this.uVE);
      this.uVG = getIntent().getStringExtra("password");
      this.uVF = getIntent().getStringExtra("email_login_page");
      v.i("MicroMsg.EmailVerifyUI", "user register:email add:[%s], password not allowed to printf, login page:[%s]", new Object[] { this.uVE, this.uVF });
      this.uVB = ((MMAutoSwitchEditTextView)findViewById(R.h.bqw));
      this.uVB.vgX = new MMAutoSwitchEditTextView.a()
      {
        public final void SK(String paramAnonymousString)
        {
          GMTrace.i(2684488777728L, 20001);
          EmailVerifyUI.this.ko(true);
          EmailVerifyUI.a(EmailVerifyUI.this, paramAnonymousString);
          GMTrace.o(2684488777728L, 20001);
        }
      };
      this.uVB.vgY = new MMAutoSwitchEditTextView.b()
      {
        public final void bQz()
        {
          GMTrace.i(2767166898176L, 20617);
          EmailVerifyUI.this.ko(false);
          GMTrace.o(2767166898176L, 20617);
        }
      };
      this.uVD = ((Button)findViewById(R.h.cvf));
      this.uVD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2680730681344L, 19973);
          b.mO(ap.uY() + "," + getClass().getName() + ",R500_250," + ap.ec("R500_250") + ",3");
          g.a(EmailVerifyUI.this, R.l.eJf, R.l.eIZ, R.l.dHL, R.l.dGk, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GMTrace.i(2783004590080L, 20735);
              paramAnonymous2DialogInterface = new u(EmailVerifyUI.a(EmailVerifyUI.this), EmailVerifyUI.b(EmailVerifyUI.this));
              ap.vd().a(paramAnonymous2DialogInterface, 0);
              EmailVerifyUI localEmailVerifyUI1 = EmailVerifyUI.this;
              EmailVerifyUI localEmailVerifyUI2 = EmailVerifyUI.this;
              EmailVerifyUI.this.getString(R.l.dIG);
              EmailVerifyUI.a(localEmailVerifyUI1, g.a(localEmailVerifyUI2, EmailVerifyUI.this.getString(R.l.eJn), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                {
                  GMTrace.i(2666235166720L, 19865);
                  ap.vd().c(paramAnonymous2DialogInterface);
                  GMTrace.o(2666235166720L, 19865);
                }
              }));
              GMTrace.o(2783004590080L, 20735);
            }
          }, null);
          GMTrace.o(2680730681344L, 19973);
        }
      });
      this.uVC = ((Button)findViewById(R.h.cpj));
      if ((!bf.mA(this.uVF)) && (!bf.mA(this.uVE))) {
        break label322;
      }
      this.uVC.setVisibility(8);
    }
    for (;;)
    {
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2718311645184L, 20253);
          EmailVerifyUI.d(EmailVerifyUI.this);
          GMTrace.o(2718311645184L, 20253);
          return true;
        }
      });
      a(0, getString(R.l.dHH), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2707305791488L, 20171);
          EmailVerifyUI localEmailVerifyUI = EmailVerifyUI.this;
          Object localObject = EmailVerifyUI.e(EmailVerifyUI.this);
          paramAnonymousMenuItem = "";
          localObject = ((MMAutoSwitchEditTextView)localObject).vgV.iterator();
          if (((Iterator)localObject).hasNext())
          {
            MMAutoSwitchEditText localMMAutoSwitchEditText = (MMAutoSwitchEditText)((Iterator)localObject).next();
            if (bf.mA(localMMAutoSwitchEditText.getText().toString().trim())) {
              break label172;
            }
            paramAnonymousMenuItem = paramAnonymousMenuItem + localMMAutoSwitchEditText.getText().toString().trim();
          }
          label172:
          for (;;)
          {
            break;
            EmailVerifyUI.b(localEmailVerifyUI, paramAnonymousMenuItem);
            if ((!bf.mA(EmailVerifyUI.f(EmailVerifyUI.this))) && (EmailVerifyUI.f(EmailVerifyUI.this).length() == 12)) {
              EmailVerifyUI.a(EmailVerifyUI.this, EmailVerifyUI.f(EmailVerifyUI.this));
            }
            for (;;)
            {
              GMTrace.o(2707305791488L, 20171);
              return true;
              EmailVerifyUI.this.ko(false);
            }
          }
        }
      });
      ko(false);
      GMTrace.o(2672543399936L, 19912);
      return;
      v.w("MicroMsg.EmailVerifyUI", "email add is null or nill");
      break;
      label322:
      this.uVC.setVisibility(0);
      this.uVC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2663013941248L, 19841);
          bf.F(EmailVerifyUI.this, EmailVerifyUI.c(EmailVerifyUI.this));
          GMTrace.o(2663013941248L, 19841);
        }
      });
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2672946053120L, 19915);
    v.i("MicroMsg.EmailVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    this.uVI = false;
    if ((this.isb != null) && (this.isb.isShowing()))
    {
      this.isb.dismiss();
      this.isb = null;
    }
    if (paramk.getType() != 481)
    {
      v.e("MicroMsg.EmailVerifyUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramk.getType()) });
      GMTrace.o(2672946053120L, 19915);
      return;
    }
    int j = ((p.a)((u)paramk).htc.BG()).sYi.tgi;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (j == 2)
      {
        b.mN("R200_900_email");
        paramString = new Intent(this, RegSetInfoUI.class);
        paramString.putExtra("regsetinfo_ticket", ((p.b)((u)paramk).htc.zg()).sYj.tsG);
        paramString.putExtra("regsetinfo_user", this.uVE);
        paramString.putExtra("regsetinfo_ismobile", 3);
        paramString.putExtra("regsetinfo_NextStyle", ((u)paramk).FC());
        paramString.putExtra("regsetinfo_pwd", this.uVG);
        paramString.putExtra("regsetinfo_bind_email", this.uVE);
        startActivity(paramString);
        GMTrace.o(2672946053120L, 19915);
        return;
      }
      if (j == 1)
      {
        b.mO(ap.uY() + "," + getClass().getName() + ",R22_resend_email_code_alert," + ap.ec("R22_resend_email_code_alert") + ",3");
        g.bk(this, getString(R.l.eJh));
        GMTrace.o(2672946053120L, 19915);
        return;
      }
      v.e("MicroMsg.EmailVerifyUI", "err opcode");
      GMTrace.o(2672946053120L, 19915);
      return;
    }
    int i;
    if (a.imc.a(this, paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      GMTrace.o(2672946053120L, 19915);
      return;
      switch (paramInt2)
      {
      default: 
        i = 0;
        break;
      case -32: 
        g.a(this, R.l.eJa, R.l.eIZ, null);
        b.mO(ap.uY() + "," + getClass().getName() + ",R500_260," + ap.ec("R500_260") + ",3");
        i = 1;
        break;
      case -33: 
        g.a(this, R.l.eIY, R.l.eIZ, null);
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, R.l.eIX, 0).show();
        i = 1;
      }
    }
    if (j == 2)
    {
      Toast.makeText(this, getString(R.l.eJp, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      GMTrace.o(2672946053120L, 19915);
      return;
    }
    if (j == 1) {
      Toast.makeText(this, getString(R.l.eJg, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    GMTrace.o(2672946053120L, 19915);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2672409182208L, 19911);
    int i = R.i.dph;
    GMTrace.o(2672409182208L, 19911);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2672006529024L, 19908);
    super.onCreate(paramBundle);
    KD();
    this.oTI = b.OA();
    GMTrace.o(2672006529024L, 19908);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2672677617664L, 19913);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      GMTrace.o(2672677617664L, 19913);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2672677617664L, 19913);
    return bool;
  }
  
  protected void onPause()
  {
    GMTrace.i(2672274964480L, 19910);
    super.onPause();
    ap.vd().b(481, this);
    b.b(false, ap.uY() + "," + getClass().getName() + ",R500_200," + ap.ec("R500_200") + ",2");
    GMTrace.o(2672274964480L, 19910);
  }
  
  protected void onResume()
  {
    GMTrace.i(2672140746752L, 19909);
    super.onResume();
    ap.vd().a(481, this);
    b.b(true, ap.uY() + "," + getClass().getName() + ",R500_200," + ap.ec("R500_200") + ",1");
    b.mM("R500_200");
    GMTrace.o(2672140746752L, 19909);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/EmailVerifyUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */