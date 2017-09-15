package com.tencent.mm.ui.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.il;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.accountsync.a.b;
import com.tencent.mm.plugin.accountsync.a.b.1;
import com.tencent.mm.plugin.accountsync.a.b.a;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.v.1;
import com.tencent.mm.pluginsdk.model.app.v.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.l;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.Iterator;
import java.util.LinkedList;

public class SimpleLoginUI
  extends MMWizardActivity
  implements com.tencent.mm.y.e
{
  private TextWatcher acO;
  private String fWO;
  private ProgressDialog isb;
  private String oTE;
  private SecurityImage uSI;
  private com.tencent.mm.sdk.b.c uVQ;
  private ResizeLayout uWB;
  private f uWv;
  private String uWx;
  private String uWy;
  private MMClearEditText uXo;
  private MMClearEditText uXp;
  private MMFormInputView uXq;
  private MMFormInputView uXr;
  private Button uXs;
  private MMKeyboardUperView uXu;
  
  public SimpleLoginUI()
  {
    GMTrace.i(2714553548800L, 20225);
    this.isb = null;
    this.uSI = null;
    this.uWv = new f();
    this.fWO = "";
    this.acO = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        GMTrace.i(16833721663488L, 125421);
        SimpleLoginUI.a(SimpleLoginUI.this);
        GMTrace.o(16833721663488L, 125421);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(16833855881216L, 125422);
        GMTrace.o(16833855881216L, 125422);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(16833990098944L, 125423);
        GMTrace.o(16833990098944L, 125423);
      }
    };
    this.uVQ = new com.tencent.mm.sdk.b.c() {};
    GMTrace.o(2714553548800L, 20225);
  }
  
  private void Tn()
  {
    GMTrace.i(2715627290624L, 20233);
    this.uWv.hRY = this.uXo.getText().toString().trim();
    this.uWv.uXd = this.uXp.getText().toString();
    if (this.uWv.hRY.equals(""))
    {
      com.tencent.mm.ui.base.g.h(this, R.l.eZS, R.l.ewF);
      GMTrace.o(2715627290624L, 20233);
      return;
    }
    if (this.uWv.uXd.equals(""))
    {
      com.tencent.mm.ui.base.g.h(this, R.l.eZP, R.l.ewF);
      GMTrace.o(2715627290624L, 20233);
      return;
    }
    aGY();
    final u localu = new u(this.uWv.hRY, this.uWv.uXd, this.oTE, 0);
    ap.vd().a(localu, 0);
    getString(R.l.dIG);
    this.isb = com.tencent.mm.ui.base.g.a(this, getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(16818286624768L, 125306);
        ap.vd().c(localu);
        GMTrace.o(16818286624768L, 125306);
      }
    });
    GMTrace.o(2715627290624L, 20233);
  }
  
  private void aXL()
  {
    GMTrace.i(2715493072896L, 20232);
    boolean bool = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
    if (!bool) {
      cancel();
    }
    zp(1);
    if (bool) {
      exit(1);
    }
    GMTrace.o(2715493072896L, 20232);
  }
  
  protected final void KD()
  {
    GMTrace.i(2715358855168L, 20231);
    this.uXq = ((MMFormInputView)findViewById(R.h.cct));
    this.uXr = ((MMFormInputView)findViewById(R.h.ccy));
    this.uXo = ((MMClearEditText)this.uXq.oAr);
    this.uXo.setFocusableInTouchMode(false);
    this.uXo.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(16839895678976L, 125467);
        SimpleLoginUI.c(SimpleLoginUI.this).setFocusableInTouchMode(true);
        boolean bool = SimpleLoginUI.c(SimpleLoginUI.this).rku.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
        GMTrace.o(16839895678976L, 125467);
        return bool;
      }
    });
    this.uXp = ((MMClearEditText)this.uXr.oAr);
    this.uXp.setFocusableInTouchMode(false);
    this.uXp.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(16829158260736L, 125387);
        SimpleLoginUI.d(SimpleLoginUI.this).setFocusableInTouchMode(true);
        SimpleLoginUI.c(SimpleLoginUI.this).setFocusableInTouchMode(false);
        boolean bool = SimpleLoginUI.d(SimpleLoginUI.this).rku.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
        GMTrace.o(16829158260736L, 125387);
        return bool;
      }
    });
    com.tencent.mm.ui.tools.a.c.d(this.uXp).Cc(16).a(null);
    this.uXs = ((Button)findViewById(R.h.ccu));
    this.uXs.setEnabled(false);
    this.uXo.addTextChangedListener(this.acO);
    this.uXp.addTextChangedListener(this.acO);
    this.uXp.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        GMTrace.i(16829560913920L, 125390);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          SimpleLoginUI.b(SimpleLoginUI.this);
          GMTrace.o(16829560913920L, 125390);
          return true;
        }
        GMTrace.o(16829560913920L, 125390);
        return false;
      }
    });
    this.uXp.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        GMTrace.i(16805267505152L, 125209);
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          SimpleLoginUI.b(SimpleLoginUI.this);
          GMTrace.o(16805267505152L, 125209);
          return true;
        }
        GMTrace.o(16805267505152L, 125209);
        return false;
      }
    });
    this.uWB = ((ResizeLayout)findViewById(R.h.cyt));
    this.uXu = ((MMKeyboardUperView)findViewById(R.h.Ki));
    this.uWB.uZT = new ResizeLayout.a()
    {
      public final void bQF()
      {
        GMTrace.i(16845801259008L, 125511);
        SimpleLoginUI.e(SimpleLoginUI.this).post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(16825265946624L, 125358);
            SimpleLoginUI.e(SimpleLoginUI.this).fullScroll(130);
            GMTrace.o(16825265946624L, 125358);
          }
        });
        GMTrace.o(16845801259008L, 125511);
      }
    };
    this.uXu.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(16834929623040L, 125430);
        SimpleLoginUI.this.aGY();
        GMTrace.o(16834929623040L, 125430);
        return false;
      }
    });
    findViewById(R.h.ccv).setVisibility(8);
    View localView = findViewById(R.h.bPf);
    if (localView != null) {
      localView.setVisibility(8);
    }
    zd(R.l.ccC);
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(16819494584320L, 125315);
        SimpleLoginUI.f(SimpleLoginUI.this);
        GMTrace.o(16819494584320L, 125315);
        return true;
      }
    });
    this.oTE = getIntent().getStringExtra("auth_ticket");
    if (!bf.mA(this.oTE))
    {
      this.uXo.setText(bf.mz(f.bQG()));
      this.uXp.setText(bf.mz(f.bQH()));
      new ad().postDelayed(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(16837882413056L, 125452);
          SimpleLoginUI.b(SimpleLoginUI.this);
          GMTrace.o(16837882413056L, 125452);
        }
      }, 500L);
    }
    if (com.tencent.mm.sdk.platformtools.f.uqI) {
      com.tencent.mm.plugin.c.a.imc.d(this);
    }
    this.uXs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(16849022484480L, 125535);
        SimpleLoginUI.b(SimpleLoginUI.this);
        GMTrace.o(16849022484480L, 125535);
      }
    });
    GMTrace.o(2715358855168L, 20231);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2716029943808L, 20236);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.SimpleLoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.SimpleLoginUI", "Scene Type " + paramk.getType());
    if (this.isb != null)
    {
      this.isb.dismiss();
      this.isb = null;
    }
    this.fWO = ((u)paramk).Ji();
    int i;
    if (paramk.getType() == 701)
    {
      this.uWv.uXi = ((u)paramk).Jj();
      this.uWv.uXf = ((u)paramk).FK();
      this.uWv.uXh = ((u)paramk).FJ();
      this.uWv.uXg = ((u)paramk).Jk();
      if (paramInt2 == 65331)
      {
        this.oTE = ((u)paramk).Fw();
        this.uWx = ((u)paramk).Jl();
        this.uWy = ((u)paramk).Jo();
      }
      if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
      {
        i = 1;
        ap.vd().a(new bb(new bb.a()
        {
          public final void a(com.tencent.mm.network.e paramAnonymouse)
          {
            GMTrace.i(16830097784832L, 125394);
            if (paramAnonymouse == null)
            {
              GMTrace.o(16830097784832L, 125394);
              return;
            }
            paramAnonymouse = paramAnonymouse.Cc();
            ap.yY();
            int i = com.tencent.mm.u.c.uH();
            paramAnonymouse.i(new byte[0], i);
            GMTrace.o(16830097784832L, 125394);
          }
        }), 0);
      }
    }
    for (;;)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        ap.unhold();
        com.tencent.mm.modelsimple.d.bc(this);
        m.mv(this.uWv.hRY);
        paramString = new b(this.uRf.uRz, new b.a()
        {
          public final void OB()
          {
            String str = null;
            GMTrace.i(16840566767616L, 125472);
            com.tencent.mm.pluginsdk.model.app.v localv = new com.tencent.mm.pluginsdk.model.app.v(SimpleLoginUI.this, new v.a()
            {
              public final void boi()
              {
                GMTrace.i(16845667041280L, 125510);
                SimpleLoginUI.this.finish();
                GMTrace.o(16845667041280L, 125510);
              }
            });
            Object localObject1 = aa.bIO();
            if (localObject1 != null)
            {
              localObject1 = ((SharedPreferences)localObject1).getString("key_app_ids_registion_while_not_login", "");
              if (bf.mA((String)localObject1)) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AppUtil", "no saved appids while not login");
              }
            }
            else
            {
              localObject1 = null;
            }
            Object localObject2;
            for (;;)
            {
              localObject2 = str;
              if (localObject1 == null) {
                break label253;
              }
              localObject2 = str;
              if (((LinkedList)localObject1).isEmpty()) {
                break label253;
              }
              localObject2 = new LinkedList();
              localObject1 = ((LinkedList)localObject1).iterator();
              com.tencent.mm.pluginsdk.model.app.f localf;
              while (((Iterator)localObject1).hasNext())
              {
                str = (String)((Iterator)localObject1).next();
                localf = com.tencent.mm.pluginsdk.model.app.g.aJ(str, false);
                if ((localf == null) || (localf.field_status == 0)) {
                  ((LinkedList)localObject2).add(str);
                }
              }
              localObject2 = ((String)localObject1).split("\\|");
              if ((localObject2 == null) || (localObject2.length <= 0)) {
                break;
              }
              localObject1 = new LinkedList();
              int m = localObject2.length;
              int i = 0;
              int k;
              for (int j = 1; i < m; j = k)
              {
                localf = localObject2[i];
                k = j;
                if (!bf.mA(localf))
                {
                  ((LinkedList)localObject1).add(localf);
                  k = j + 1;
                }
                if (k > 5) {
                  break;
                }
                i += 1;
              }
            }
            label253:
            if ((localObject2 == null) || (((LinkedList)localObject2).isEmpty()))
            {
              com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoadAppInfoAfterLogin", "no saved appids, just callback");
              com.tencent.mm.pluginsdk.model.app.g.bCQ();
              if (localv.sBV != null) {
                localv.sBV.boi();
              }
              GMTrace.o(16840566767616L, 125472);
              return;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoadAppInfoAfterLogin", "now do batch get appinfos, appid liSst size is :%d", new Object[] { Integer.valueOf(((LinkedList)localObject2).size()) });
            an.aBz().a(7, localv);
            an.aRj().at((LinkedList)localObject2);
            if ((localv.mContext != null) && (!((Activity)localv.mContext).isFinishing()))
            {
              localObject1 = localv.mContext;
              localv.mContext.getString(R.l.dIG);
              localv.irp = com.tencent.mm.ui.base.g.a((Context)localObject1, localv.mContext.getString(R.l.dIV), true, new v.1(localv));
              GMTrace.o(16840566767616L, 125472);
              return;
            }
            if (localv.sBV != null) {
              localv.sBV.boi();
            }
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LoadAppInfoAfterLogin", "dz[loadAppInfo:catch the null window for progress bar");
            GMTrace.o(16840566767616L, 125472);
          }
        });
        paramString.fFX = com.tencent.mm.plugin.c.a.imc.a(paramString);
        if (paramString.fFX == null)
        {
          if (paramString.irq != null) {
            paramString.irq.OB();
          }
          GMTrace.o(2716029943808L, 20236);
          return;
        }
        if (paramString.fFX.getType() == 139) {
          ap.vd().a(139, paramString);
        }
        for (;;)
        {
          ap.vd().a(paramString.fFX, 0);
          paramk = paramString.context;
          paramString.context.getString(R.l.dIG);
          paramString.irp = com.tencent.mm.ui.base.g.a(paramk, paramString.context.getString(R.l.dHs), true, new b.1(paramString));
          GMTrace.o(2716029943808L, 20236);
          return;
          if (paramString.fFX.getType() == 138) {
            ap.vd().a(138, paramString);
          }
        }
      }
      if (paramInt2 == 65319)
      {
        m.a(this, com.tencent.mm.pluginsdk.a.a.a((u)paramk), paramInt2);
        GMTrace.o(2716029943808L, 20236);
        return;
      }
      if (com.tencent.mm.plugin.c.a.imc.a(this.uRf.uRz, paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      while (i != 0)
      {
        GMTrace.o(2716029943808L, 20236);
        return;
        if (paramInt1 == 4) {}
        switch (paramInt2)
        {
        default: 
          i = 0;
          break;
        case -1: 
          if (ap.vd().BR() == 5)
          {
            com.tencent.mm.ui.base.g.h(this, R.l.eDh, R.l.eDg);
            i = 1;
          }
          break;
        case -30: 
        case -4: 
        case -3: 
          com.tencent.mm.ui.base.g.h(this, R.l.eeU, R.l.ewF);
          i = 1;
          break;
        case -9: 
          com.tencent.mm.ui.base.g.h(this, R.l.ewE, R.l.ewF);
          i = 1;
          break;
        case -72: 
          com.tencent.mm.ui.base.g.h(this.uRf.uRz, R.l.eJR, R.l.dIG);
          i = 1;
          break;
        case -75: 
          m.bo(this.uRf.uRz);
          i = 1;
          break;
        case -311: 
        case -310: 
        case -6: 
          if (this.uSI == null) {
            this.uSI = SecurityImage.a.a(this.uRf.uRz, R.l.eJY, this.uWv.uXi, this.uWv.uXh, this.uWv.uXf, this.uWv.uXg, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(16841372073984L, 125478);
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.SimpleLoginUI", "imgSid:" + SimpleLoginUI.g(SimpleLoginUI.this).uXf + " img len" + SimpleLoginUI.g(SimpleLoginUI.this).uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
                paramAnonymousDialogInterface = new u(SimpleLoginUI.g(SimpleLoginUI.this).hRY, SimpleLoginUI.g(SimpleLoginUI.this).uXd, SimpleLoginUI.g(SimpleLoginUI.this).uXi, SimpleLoginUI.h(SimpleLoginUI.this).bRp(), SimpleLoginUI.h(SimpleLoginUI.this).uXf, SimpleLoginUI.h(SimpleLoginUI.this).uXg, 0, "", false, false);
                ap.vd().a(paramAnonymousDialogInterface, 0);
                SimpleLoginUI localSimpleLoginUI1 = SimpleLoginUI.this;
                SimpleLoginUI localSimpleLoginUI2 = SimpleLoginUI.this;
                SimpleLoginUI.this.getString(R.l.dIG);
                SimpleLoginUI.a(localSimpleLoginUI1, com.tencent.mm.ui.base.g.a(localSimpleLoginUI2, SimpleLoginUI.this.getString(R.l.ewP), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    GMTrace.i(16841908944896L, 125482);
                    ap.vd().c(paramAnonymousDialogInterface);
                    GMTrace.o(16841908944896L, 125482);
                  }
                }));
                GMTrace.o(16841372073984L, 125478);
              }
            }, null, new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                GMTrace.i(16838821937152L, 125459);
                SimpleLoginUI.i(SimpleLoginUI.this);
                GMTrace.o(16838821937152L, 125459);
              }
            }, this.uWv);
          }
          for (;;)
          {
            i = 1;
            break;
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.SimpleLoginUI", "imgSid:" + this.uWv.uXf + " img len" + this.uWv.uXh.length + " " + com.tencent.mm.compatible.util.g.sd());
            this.uSI.a(this.uWv.uXi, this.uWv.uXh, this.uWv.uXf, this.uWv.uXg);
          }
        case -100: 
          ap.hold();
          com.tencent.mm.ui.base.g.a(this, ap.uI(), getString(R.l.dIG), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(16837748195328L, 125451);
              GMTrace.o(16837748195328L, 125451);
            }
          }, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              GMTrace.i(16842982686720L, 125490);
              GMTrace.o(16842982686720L, 125490);
            }
          });
          i = 1;
          break;
        case -205: 
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.SimpleLoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bf.Qi(this.oTE), this.uWy });
          f.a(this.uWv);
          paramk = new Intent();
          paramk.putExtra("auth_ticket", this.oTE);
          paramk.putExtra("binded_mobile", this.uWx);
          paramk.putExtra("close_safe_device_style", this.uWy);
          paramk.putExtra("from_source", 3);
          com.tencent.mm.plugin.c.a.imb.f(this, paramk);
          i = 1;
          break;
        case -140: 
          if (!bf.mA(this.fWO)) {
            m.j(this, paramString, this.fWO);
          }
          i = 1;
          break;
        case -106: 
          m.E(this, paramString);
          i = 1;
        }
      }
      paramString = com.tencent.mm.f.a.dn(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        GMTrace.o(2716029943808L, 20236);
        return;
      }
      Toast.makeText(this, getString(R.l.ekZ, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      GMTrace.o(2716029943808L, 20236);
      return;
      i = 0;
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2714687766528L, 20226);
    int i = R.i.dgJ;
    GMTrace.o(2714687766528L, 20226);
    return i;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    GMTrace.i(2716164161536L, 20237);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.SimpleLoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label184;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bf.mA(str);
      if (!bf.mA(str)) {
        break label175;
      }
    }
    label175:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.SimpleLoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != 65319) {
        break label184;
      }
      Tn();
      GMTrace.o(2716164161536L, 20237);
      return;
      bool = false;
      break;
    }
    label184:
    GMTrace.o(2716164161536L, 20237);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2714821984256L, 20227);
    super.onCreate(paramBundle);
    paramBundle = getSharedPreferences("system_config_prefs", 4);
    if (paramBundle.getBoolean("first_launch_weixin", true))
    {
      paramBundle.edit().putBoolean("first_launch_weixin", false).commit();
      XLogSetup.realSetupXlog();
    }
    zd(R.l.bpC);
    if (com.tencent.mm.plugin.c.a.imc != null) {
      com.tencent.mm.plugin.c.a.imc.ox();
    }
    KD();
    ap.vd().a(701, this);
    GMTrace.o(2714821984256L, 20227);
  }
  
  public void onDestroy()
  {
    GMTrace.i(2715090419712L, 20229);
    ap.vd().b(701, this);
    super.onDestroy();
    GMTrace.o(2715090419712L, 20229);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2715761508352L, 20234);
    if (paramInt == 4)
    {
      aXL();
      GMTrace.o(2715761508352L, 20234);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2715761508352L, 20234);
    return bool;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    GMTrace.i(2715224637440L, 20230);
    super.onNewIntent(paramIntent);
    this.oTE = paramIntent.getStringExtra("auth_ticket");
    paramIntent = getIntent().getExtras();
    if (paramIntent != null) {
      this.oTE = paramIntent.getString("auth_ticket");
    }
    if (!bf.mA(this.oTE))
    {
      this.uXo.setText(bf.mz(f.bQG()));
      this.uXp.setText(bf.mz(f.bQH()));
      new ad().postDelayed(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(16833453228032L, 125419);
          SimpleLoginUI.b(SimpleLoginUI.this);
          GMTrace.o(16833453228032L, 125419);
        }
      }, 500L);
    }
    GMTrace.o(2715224637440L, 20230);
  }
  
  protected void onPause()
  {
    GMTrace.i(2715895726080L, 20235);
    if (this.isb != null)
    {
      this.isb.dismiss();
      this.isb = null;
    }
    super.onPause();
    com.tencent.mm.sdk.b.a.uql.c(this.uVQ);
    GMTrace.o(2715895726080L, 20235);
  }
  
  public void onResume()
  {
    GMTrace.i(2714956201984L, 20228);
    com.tencent.mm.sdk.b.a.uql.b(this.uVQ);
    super.onResume();
    GMTrace.o(2714956201984L, 20228);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/SimpleLoginUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */