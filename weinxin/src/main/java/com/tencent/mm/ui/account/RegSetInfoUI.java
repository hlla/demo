package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelfriend.x;
import com.tencent.mm.modelsimple.c;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.protocal.c.abl;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ae.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.bindmobile.FindMContactAlertUI;
import com.tencent.mm.ui.bindmobile.FindMContactIntroUI;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.io.File;
import java.util.LinkedList;
import java.util.Map;

public class RegSetInfoUI
  extends MMActivity
  implements com.tencent.mm.y.e
{
  private ProgressDialog isb;
  private ProgressBar kWs;
  private String kuu;
  private String lMX;
  private Button lgL;
  private int nWv;
  private SecurityImage uSI;
  private com.tencent.mm.pluginsdk.j.a uWD;
  private EditText uYA;
  private boolean uYd;
  private boolean uZA;
  private com.tencent.mm.ui.base.o uZB;
  private View uZC;
  private boolean uZD;
  private ai uZE;
  private EditText uZi;
  private String uZj;
  private String uZk;
  private int uZl;
  private String uZm;
  private TextView uZn;
  private View uZo;
  private boolean uZp;
  private ImageView uZq;
  private int uZr;
  private LinkedList<String> uZs;
  private ImageView uZt;
  private ImageView uZu;
  private String uZv;
  private ImageView uZw;
  private View uZx;
  private TextView uZy;
  private String uZz;
  
  public RegSetInfoUI()
  {
    GMTrace.i(2569329967104L, 19143);
    this.isb = null;
    this.nWv = 0;
    this.uSI = null;
    this.uZp = false;
    this.uYd = false;
    this.uZr = 3;
    this.uZs = new LinkedList();
    this.uZv = "";
    this.uZz = null;
    this.uZA = false;
    this.uZD = false;
    this.uZE = new ai(Looper.myLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(2686636261376L, 20017);
        String str = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
        Object localObject2 = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
        Object localObject1 = str;
        if (bf.mA(str))
        {
          localObject1 = str;
          if (!bf.mA((String)localObject2)) {
            if (((String)localObject2).length() <= 5) {
              break label211;
            }
          }
        }
        label211:
        for (localObject1 = ((String)localObject2).substring(0, 5);; localObject1 = localObject2)
        {
          if ((!bf.mA((String)localObject1)) && (bf.mA((String)localObject2))) {
            localObject2 = localObject1;
          }
          for (;;)
          {
            if ((!bf.mA((String)localObject1)) && (RegSetInfoUI.c(RegSetInfoUI.this)) && (RegSetInfoUI.d(RegSetInfoUI.this)))
            {
              int i = RegSetInfoUI.e(RegSetInfoUI.this);
              str = RegSetInfoUI.f(RegSetInfoUI.this);
              ap.vd().a(429, RegSetInfoUI.this);
              localObject1 = new x(str, RegSetInfoUI.g(RegSetInfoUI.this), i, (String)localObject2, (String)localObject1, "", "");
              ap.vd().a((k)localObject1, 0);
              RegSetInfoUI.h(RegSetInfoUI.this).setVisibility(0);
            }
            GMTrace.o(2686636261376L, 20017);
            return false;
          }
        }
      }
    }, true);
    GMTrace.o(2569329967104L, 19143);
  }
  
  private void I(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    GMTrace.i(2570001055744L, 19148);
    if (bf.mA(this.uZi.getText().toString().trim())) {
      paramBoolean1 = false;
    }
    ImageView localImageView = this.uZu;
    if (paramBoolean2)
    {
      i = R.g.bjZ;
      localImageView.setImageResource(i);
      localImageView = this.uZu;
      if (!paramBoolean1) {
        break label113;
      }
    }
    label113:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      boolean bool1 = bool2;
      if (paramBoolean1)
      {
        bool1 = bool2;
        if (paramBoolean2) {
          bool1 = true;
        }
      }
      this.uZA = bool1;
      GMTrace.o(2570001055744L, 19148);
      return;
      i = R.g.bjW;
      break;
    }
  }
  
  private void aXL()
  {
    GMTrace.i(2572014321664L, 19163);
    aGY();
    if (bQU())
    {
      com.tencent.mm.ui.base.g.a(this, getString(R.l.eKa), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2664087683072L, 19849);
          com.tencent.mm.plugin.c.b.mN("R200_100");
          paramAnonymousDialogInterface = new Intent(RegSetInfoUI.this, MobileInputUI.class);
          paramAnonymousDialogInterface.putExtra("mobile_input_purpose", 2);
          paramAnonymousDialogInterface.addFlags(67108864);
          RegSetInfoUI.this.startActivity(paramAnonymousDialogInterface);
          RegSetInfoUI.this.finish();
          GMTrace.o(2664087683072L, 19849);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2714419331072L, 20224);
          GMTrace.o(2714419331072L, 20224);
        }
      });
      GMTrace.o(2572014321664L, 19163);
      return;
    }
    if (!bQV())
    {
      if (this.nWv == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        com.tencent.mm.ui.base.g.a(this, getString(R.l.eJZ), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2759650705408L, 20561);
            com.tencent.mm.plugin.c.b.mN("R400_100_signup");
            paramAnonymousDialogInterface = new Intent(RegSetInfoUI.this, LoginUI.class);
            paramAnonymousDialogInterface.addFlags(67108864);
            RegSetInfoUI.this.startActivity(paramAnonymousDialogInterface);
            RegSetInfoUI.this.finish();
            GMTrace.o(2759650705408L, 20561);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2693481365504L, 20068);
            GMTrace.o(2693481365504L, 20068);
          }
        });
        GMTrace.o(2572014321664L, 19163);
        return;
      }
      if (bQW())
      {
        com.tencent.mm.ui.base.g.a(this, getString(R.l.eJZ), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2745289408512L, 20454);
            com.tencent.mm.plugin.c.b.mN("R500_100");
            paramAnonymousDialogInterface = new Intent(RegSetInfoUI.this, RegByEmailUI.class);
            paramAnonymousDialogInterface.addFlags(67108864);
            RegSetInfoUI.this.startActivity(paramAnonymousDialogInterface);
            RegSetInfoUI.this.finish();
            GMTrace.o(2745289408512L, 20454);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2682878164992L, 19989);
            GMTrace.o(2682878164992L, 19989);
          }
        });
        GMTrace.o(2572014321664L, 19163);
        return;
      }
      com.tencent.mm.plugin.c.b.mN("R200_100");
      Intent localIntent = new Intent(this, MobileInputUI.class);
      localIntent.putExtra("mobile_input_purpose", 2);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      finish();
    }
    GMTrace.o(2572014321664L, 19163);
  }
  
  private boolean bQQ()
  {
    GMTrace.i(2570135273472L, 19149);
    if ((this.uZu.getVisibility() == 8) || (this.uZA))
    {
      GMTrace.o(2570135273472L, 19149);
      return true;
    }
    GMTrace.o(2570135273472L, 19149);
    return false;
  }
  
  private void bQR()
  {
    GMTrace.i(2570269491200L, 19150);
    String str = this.uYA.getText().toString().trim();
    Button localButton = this.lgL;
    if (!bf.mA(str)) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      GMTrace.o(2570269491200L, 19150);
      return;
    }
  }
  
  private boolean bQS()
  {
    GMTrace.i(2570403708928L, 19151);
    if ((this.uZr & 0x1) > 0)
    {
      GMTrace.o(2570403708928L, 19151);
      return true;
    }
    GMTrace.o(2570403708928L, 19151);
    return false;
  }
  
  private boolean bQT()
  {
    GMTrace.i(2570537926656L, 19152);
    if ((this.uZr & 0x2) > 0)
    {
      GMTrace.o(2570537926656L, 19152);
      return true;
    }
    GMTrace.o(2570537926656L, 19152);
    return false;
  }
  
  private boolean bQU()
  {
    GMTrace.i(2570940579840L, 19155);
    if (this.nWv == 1)
    {
      GMTrace.o(2570940579840L, 19155);
      return true;
    }
    GMTrace.o(2570940579840L, 19155);
    return false;
  }
  
  private boolean bQV()
  {
    GMTrace.i(2571074797568L, 19156);
    if (this.nWv == 2)
    {
      GMTrace.o(2571074797568L, 19156);
      return true;
    }
    GMTrace.o(2571074797568L, 19156);
    return false;
  }
  
  private boolean bQW()
  {
    GMTrace.i(2571209015296L, 19157);
    if (this.nWv == 3)
    {
      GMTrace.o(2571209015296L, 19157);
      return true;
    }
    GMTrace.o(2571209015296L, 19157);
    return false;
  }
  
  private int bQX()
  {
    GMTrace.i(2571343233024L, 19158);
    if (bQU())
    {
      GMTrace.o(2571343233024L, 19158);
      return 4;
    }
    if (bQV())
    {
      GMTrace.o(2571343233024L, 19158);
      return 2;
    }
    if (bQW())
    {
      GMTrace.o(2571343233024L, 19158);
      return 6;
    }
    GMTrace.o(2571343233024L, 19158);
    return 2;
  }
  
  private String bQY()
  {
    GMTrace.i(2571477450752L, 19159);
    if (bQU())
    {
      str = this.uZj;
      GMTrace.o(2571477450752L, 19159);
      return str;
    }
    if (bQW())
    {
      str = this.uZk;
      GMTrace.o(2571477450752L, 19159);
      return str;
    }
    String str = this.uZm;
    GMTrace.o(2571477450752L, 19159);
    return str;
  }
  
  private boolean p(int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(2571745886208L, 19161);
    Object localObject = new com.tencent.mm.pluginsdk.j.p(paramInt1, paramInt2, paramString);
    if (this.uWD.a(this, (com.tencent.mm.pluginsdk.j.p)localObject))
    {
      GMTrace.o(2571745886208L, 19161);
      return true;
    }
    if (com.tencent.mm.plugin.c.a.imc.a(this.uRf.uRz, paramInt1, paramInt2, paramString))
    {
      GMTrace.o(2571745886208L, 19161);
      return true;
    }
    switch (paramInt2)
    {
    default: 
      GMTrace.o(2571745886208L, 19161);
      return false;
    case -10: 
    case -7: 
      com.tencent.mm.ui.base.g.h(this, R.l.eIS, R.l.eIT);
      GMTrace.o(2571745886208L, 19161);
      return true;
    case -75: 
      com.tencent.mm.ui.base.g.h(this, R.l.dCW, R.l.eIT);
      GMTrace.o(2571745886208L, 19161);
      return true;
    case -100: 
      ap.hold();
      localObject = this.uRf.uRz;
      if (TextUtils.isEmpty(ap.uI())) {}
      for (paramString = com.tencent.mm.bg.a.V(this.uRf.uRz, R.l.eza);; paramString = ap.uI())
      {
        com.tencent.mm.ui.base.g.a((Context)localObject, paramString, this.uRf.uRz.getString(R.l.dIG), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2651739652096L, 19757);
            GMTrace.o(2651739652096L, 19757);
          }
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(2643955023872L, 19699);
            GMTrace.o(2643955023872L, 19699);
          }
        });
        GMTrace.o(2571745886208L, 19161);
        return true;
      }
    }
    paramString = com.tencent.mm.f.a.dn(paramString);
    if (paramString != null) {
      paramString.a(this, null, null);
    }
    for (;;)
    {
      GMTrace.o(2571745886208L, 19161);
      return true;
      com.tencent.mm.ui.base.g.b(this, getString(R.l.eKf), "", true);
    }
  }
  
  protected final void KD()
  {
    int j = 0;
    GMTrace.i(2569866838016L, 19147);
    this.uZC = findViewById(R.h.crS);
    this.uZx = findViewById(R.h.cCz);
    this.uZq = ((ImageView)findViewById(R.h.cCy));
    this.uYA = ((EditText)findViewById(R.h.cxk));
    this.uZy = ((TextView)findViewById(R.h.cCB));
    this.uZi = ((EditText)findViewById(R.h.cxn));
    this.uZn = ((TextView)findViewById(R.h.boq));
    this.uZo = findViewById(R.h.cxB);
    this.uZt = ((ImageView)findViewById(R.h.cnS));
    this.uZu = ((ImageView)findViewById(R.h.cSC));
    this.kWs = ((ProgressBar)findViewById(R.h.ctf));
    this.uZw = ((ImageView)findViewById(R.h.cCA));
    this.lgL = ((Button)findViewById(R.h.cnP));
    this.uZt.setVisibility(8);
    this.uZu.setVisibility(8);
    this.kWs.setVisibility(8);
    this.uZw.setVisibility(8);
    this.uYd = false;
    this.uZA = false;
    Object localObject = this.uZx;
    int i;
    if (bQS())
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.uZo;
      if (!bQT()) {
        break label520;
      }
      i = 0;
      label263:
      ((View)localObject).setVisibility(i);
      localObject = this.uZn;
      if (!bQT()) {
        break label526;
      }
      i = j;
      label282:
      ((TextView)localObject).setVisibility(i);
      if ((!bQS()) || (!bQT())) {
        break label532;
      }
      this.uZy.setText(getString(R.l.eKe));
    }
    for (;;)
    {
      ap.vL().a(new ae.a()
      {
        Bitmap mBitmap;
        String mvn;
        
        public final boolean Bn()
        {
          GMTrace.i(2719519604736L, 20262);
          try
          {
            this.mvn = c.ba(RegSetInfoUI.this);
            this.mBitmap = c.bb(RegSetInfoUI.this);
            if ((this.mBitmap == null) || (this.mBitmap.isRecycled())) {}
          }
          catch (Exception localException1)
          {
            try
            {
              com.tencent.mm.sdk.platformtools.d.a(this.mBitmap, 100, Bitmap.CompressFormat.PNG, com.tencent.mm.compatible.util.e.gSw + "temp.avatar", false);
              GMTrace.o(2719519604736L, 20262);
              return true;
              localException1 = localException1;
              v.e("MiroMsg.RegSetInfoUI", "getName or getBitmap err : " + localException1.getMessage());
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                v.e("MiroMsg.RegSetInfoUI", "save avatar fail." + localException2.getMessage());
                v.printErrStackTrace("MiroMsg.RegSetInfoUI", localException2, "", new Object[0]);
              }
            }
          }
        }
        
        public final boolean Bo()
        {
          GMTrace.i(2719385387008L, 20261);
          if ((!bf.mA(this.mvn)) && (bf.mA(RegSetInfoUI.b(RegSetInfoUI.this).getText().trim()))) {
            RegSetInfoUI.b(RegSetInfoUI.this).setText(this.mvn);
          }
          if (!f.rZ())
          {
            v.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
            GMTrace.o(2719385387008L, 20261);
            return false;
          }
          if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()) && (!RegSetInfoUI.j(RegSetInfoUI.this)))
          {
            RegSetInfoUI.i(RegSetInfoUI.this).setImageBitmap(this.mBitmap);
            RegSetInfoUI.k(RegSetInfoUI.this);
            RegSetInfoUI.l(RegSetInfoUI.this).setVisibility(0);
          }
          GMTrace.o(2719385387008L, 20261);
          return true;
        }
        
        public final String toString()
        {
          GMTrace.i(2719653822464L, 20263);
          String str = super.toString() + "|initView";
          GMTrace.o(2719653822464L, 20263);
          return str;
        }
      });
      this.uYA.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          GMTrace.i(2640599580672L, 19674);
          paramAnonymousEditable = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
          if ((paramAnonymousEditable != null) && (paramAnonymousEditable.length() > 16))
          {
            RegSetInfoUI.b(RegSetInfoUI.this).setText(paramAnonymousEditable.substring(0, 16));
            GMTrace.o(2640599580672L, 19674);
            return;
          }
          if (!RegSetInfoUI.m(RegSetInfoUI.this).bJg()) {
            RegSetInfoUI.m(RegSetInfoUI.this).KI();
          }
          RegSetInfoUI.n(RegSetInfoUI.this);
          if (bf.mA(RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim())) {
            RegSetInfoUI.o(RegSetInfoUI.this).setVisibility(8);
          }
          for (;;)
          {
            if (!RegSetInfoUI.p(RegSetInfoUI.this)) {
              RegSetInfoUI.a(RegSetInfoUI.this).setText(paramAnonymousEditable);
            }
            GMTrace.o(2640599580672L, 19674);
            return;
            RegSetInfoUI.o(RegSetInfoUI.this).setVisibility(0);
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(2640733798400L, 19675);
          GMTrace.o(2640733798400L, 19675);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(2640868016128L, 19676);
          GMTrace.o(2640868016128L, 19676);
        }
      });
      this.lgL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2765422067712L, 20604);
          RegSetInfoUI.q(RegSetInfoUI.this);
          GMTrace.o(2765422067712L, 20604);
        }
      });
      this.uZi.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          GMTrace.i(2759382269952L, 20559);
          if (paramAnonymousBoolean)
          {
            RegSetInfoUI.r(RegSetInfoUI.this);
            RegSetInfoUI.m(RegSetInfoUI.this).v(200L, 200L);
          }
          GMTrace.o(2759382269952L, 20559);
        }
      });
      this.uZi.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          GMTrace.i(2658987409408L, 19811);
          if (!RegSetInfoUI.m(RegSetInfoUI.this).bJg()) {
            RegSetInfoUI.m(RegSetInfoUI.this).KI();
          }
          paramAnonymousEditable = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
          if (bf.mA(paramAnonymousEditable))
          {
            RegSetInfoUI.s(RegSetInfoUI.this).setText(RegSetInfoUI.this.getString(R.l.eKg));
            RegSetInfoUI.t(RegSetInfoUI.this);
            if (RegSetInfoUI.u(RegSetInfoUI.this) != null)
            {
              RegSetInfoUI.u(RegSetInfoUI.this).dismiss();
              RegSetInfoUI.v(RegSetInfoUI.this);
            }
            RegSetInfoUI.a(RegSetInfoUI.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(2717237903360L, 20245);
                RegSetInfoUI.a(RegSetInfoUI.this).clearFocus();
                RegSetInfoUI.a(RegSetInfoUI.this).requestFocus();
                GMTrace.o(2717237903360L, 20245);
              }
            }, 50L);
          }
          if ((!bf.mA(paramAnonymousEditable)) && ((RegSetInfoUI.c(RegSetInfoUI.this)) || (!paramAnonymousEditable.equals(RegSetInfoUI.w(RegSetInfoUI.this)))))
          {
            RegSetInfoUI.t(RegSetInfoUI.this);
            RegSetInfoUI.m(RegSetInfoUI.this).v(500L, 500L);
          }
          RegSetInfoUI.a(RegSetInfoUI.this, paramAnonymousEditable);
          GMTrace.o(2658987409408L, 19811);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(2659121627136L, 19812);
          GMTrace.o(2659121627136L, 19812);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(2659255844864L, 19813);
          GMTrace.o(2659255844864L, 19813);
        }
      });
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2697373679616L, 20097);
          RegSetInfoUI.x(RegSetInfoUI.this);
          GMTrace.o(2697373679616L, 20097);
          return true;
        }
      });
      this.uYA.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          GMTrace.i(2681804423168L, 19981);
          if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
          {
            RegSetInfoUI.q(RegSetInfoUI.this);
            GMTrace.o(2681804423168L, 19981);
            return true;
          }
          GMTrace.o(2681804423168L, 19981);
          return false;
        }
      });
      this.uYA.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          GMTrace.i(2697105244160L, 20095);
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            RegSetInfoUI.q(RegSetInfoUI.this);
            GMTrace.o(2697105244160L, 20095);
            return true;
          }
          GMTrace.o(2697105244160L, 20095);
          return false;
        }
      });
      this.uZi.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          GMTrace.i(2697642115072L, 20099);
          if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
          {
            RegSetInfoUI.q(RegSetInfoUI.this);
            GMTrace.o(2697642115072L, 20099);
            return true;
          }
          GMTrace.o(2697642115072L, 20099);
          return false;
        }
      });
      this.uZi.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          GMTrace.i(2753879343104L, 20518);
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            RegSetInfoUI.q(RegSetInfoUI.this);
            GMTrace.o(2753879343104L, 20518);
            return true;
          }
          GMTrace.o(2753879343104L, 20518);
          return false;
        }
      });
      this.uZq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2737102127104L, 20393);
          RegSetInfoUI.y(RegSetInfoUI.this);
          GMTrace.o(2737102127104L, 20393);
        }
      });
      localObject = new File(com.tencent.mm.compatible.util.e.gSw);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      bQR();
      GMTrace.o(2569866838016L, 19147);
      return;
      i = 8;
      break;
      label520:
      i = 8;
      break label263;
      label526:
      i = 8;
      break label282;
      label532:
      if ((bQS()) && (!bQT())) {
        this.uZy.setText(getString(R.l.eKc));
      } else if ((!bQS()) && (bQT())) {
        this.uZy.setText(getString(R.l.eKd));
      } else {
        this.uZy.setText(getString(R.l.eKb));
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, final String paramString, final k paramk)
  {
    GMTrace.i(2571611668480L, 19160);
    v.i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    final String str2;
    final String str1;
    final int i;
    String str3;
    final Object localObject1;
    final Object localObject2;
    boolean bool2;
    final boolean bool1;
    Object localObject3;
    if (paramk.getType() == 126)
    {
      ap.vd().b(126, this);
      if (this.isb != null)
      {
        this.isb.dismiss();
        this.isb = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.uZz = null;
        str2 = bQY();
        str1 = ((w)paramk).Js();
        i = ((w)paramk).Jt();
        str3 = ((w)paramk).Ju();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = bg.q(str3, "wording");
        if (localMap == null) {
          break label1669;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!bf.mA((String)localObject3)) {
          break label560;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label1669;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!bf.mA((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (bf.mA((String)localObject3)) {
          break label1666;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      v.d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      ap.unhold();
      ap.aT(true);
      if (this.uYd)
      {
        localObject3 = com.tencent.mm.compatible.util.e.gSw + "temp.avatar";
        str3 = com.tencent.mm.compatible.util.e.gSw + "temp.avatar.hd";
        new File((String)localObject3).renameTo(new File(str3));
        com.tencent.mm.loader.stub.b.deleteFile((String)localObject3);
        com.tencent.mm.sdk.platformtools.d.b(str3, 96, 96, Bitmap.CompressFormat.JPEG, 90, (String)localObject3);
        new com.tencent.mm.pluginsdk.model.o(this, com.tencent.mm.compatible.util.e.gSw + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            GMTrace.i(2736833691648L, 20391);
            RegSetInfoUI.b(RegSetInfoUI.this, ((w)paramk).Jr());
            ao.hlE.L("login_user_name", str2);
            com.tencent.mm.loader.stub.b.deleteFile(com.tencent.mm.compatible.util.e.gSw + "temp.avatar");
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.c.b.mN("R300_100_phone");
              if (!bool1) {
                localIntent1 = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
              }
              for (;;)
              {
                localIntent1.addFlags(67108864);
                localIntent1.putExtra("regsetinfo_ticket", RegSetInfoUI.g(RegSetInfoUI.this));
                localIntent1.putExtra("regsetinfo_NextStep", str1);
                localIntent1.putExtra("regsetinfo_NextStyle", i);
                Intent localIntent2 = com.tencent.mm.plugin.c.a.imb.ak(RegSetInfoUI.this);
                localIntent2.addFlags(67108864);
                MMWizardActivity.b(RegSetInfoUI.this, localIntent1, localIntent2);
                RegSetInfoUI.this.finish();
                GMTrace.o(2736833691648L, 20391);
                return;
                localIntent1 = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                localIntent1.putExtra("alert_title", localObject1);
                localIntent1.putExtra("alert_message", localObject2);
              }
            }
            Intent localIntent1 = com.tencent.mm.plugin.c.a.imb.ak(RegSetInfoUI.this);
            localIntent1.addFlags(67108864);
            RegSetInfoUI.this.startActivity(localIntent1);
            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + RegSetInfoUI.this.getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
            RegSetInfoUI.this.finish();
            GMTrace.o(2736833691648L, 20391);
          }
        }, new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2712406065152L, 20209);
            RegSetInfoUI.b(RegSetInfoUI.this, ((w)paramk).Jr());
            ao.hlE.L("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.c.b.mN("R300_100_phone");
              if (!bool1) {
                localIntent1 = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
              }
              for (;;)
              {
                localIntent1.addFlags(67108864);
                localIntent1.putExtra("regsetinfo_ticket", RegSetInfoUI.g(RegSetInfoUI.this));
                localIntent1.putExtra("regsetinfo_NextStep", str1);
                localIntent1.putExtra("regsetinfo_NextStyle", i);
                Intent localIntent2 = com.tencent.mm.plugin.c.a.imb.ak(RegSetInfoUI.this);
                localIntent2.addFlags(67108864);
                MMWizardActivity.b(RegSetInfoUI.this, localIntent1, localIntent2);
                RegSetInfoUI.this.finish();
                GMTrace.o(2712406065152L, 20209);
                return;
                localIntent1 = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                localIntent1.putExtra("alert_title", localObject1);
                localIntent1.putExtra("alert_message", localObject2);
              }
            }
            Intent localIntent1 = com.tencent.mm.plugin.c.a.imb.ak(RegSetInfoUI.this);
            localIntent1.addFlags(67108864);
            RegSetInfoUI.this.startActivity(localIntent1);
            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + RegSetInfoUI.this.getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
            RegSetInfoUI.this.finish();
            GMTrace.o(2712406065152L, 20209);
          }
        });
      }
      for (;;)
      {
        if ((paramInt2 == -6) || (paramInt2 == 65225) || (paramInt2 == 65226))
        {
          if (this.uSI == null)
          {
            this.uSI = SecurityImage.a.a(this.uRf.uRz, R.l.eJY, 0, ((w)paramk).FJ(), ((w)paramk).FK(), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(2670127480832L, 19894);
                paramAnonymousDialogInterface = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                Object localObject = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                if ((localObject == null) || (((String)localObject).length() <= 0))
                {
                  com.tencent.mm.ui.base.g.h(RegSetInfoUI.this, R.l.eZI, R.l.eJH);
                  GMTrace.o(2670127480832L, 19894);
                  return;
                }
                paramAnonymousInt = RegSetInfoUI.e(RegSetInfoUI.this);
                ap.vd().a(126, RegSetInfoUI.this);
                paramAnonymousDialogInterface = new w("", RegSetInfoUI.z(RegSetInfoUI.this), (String)localObject, RegSetInfoUI.A(RegSetInfoUI.this), RegSetInfoUI.B(RegSetInfoUI.this), RegSetInfoUI.C(RegSetInfoUI.this), "", "", RegSetInfoUI.g(RegSetInfoUI.this), paramAnonymousInt, paramAnonymousDialogInterface, ((w)paramk).FK(), RegSetInfoUI.D(RegSetInfoUI.this).bRp(), RegSetInfoUI.E(RegSetInfoUI.this), RegSetInfoUI.j(RegSetInfoUI.this));
                ap.vd().a(paramAnonymousDialogInterface, 0);
                localObject = RegSetInfoUI.this;
                RegSetInfoUI localRegSetInfoUI = RegSetInfoUI.this;
                RegSetInfoUI.this.getString(R.l.dIG);
                RegSetInfoUI.a((RegSetInfoUI)localObject, com.tencent.mm.ui.base.g.a(localRegSetInfoUI, RegSetInfoUI.this.getString(R.l.eJX), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    GMTrace.i(2749181722624L, 20483);
                    ap.vd().c(paramAnonymousDialogInterface);
                    ap.vd().b(126, RegSetInfoUI.this);
                    GMTrace.o(2749181722624L, 20483);
                  }
                }));
                GMTrace.o(2670127480832L, 19894);
              }
            }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                GMTrace.i(2749450158080L, 20485);
                RegSetInfoUI.F(RegSetInfoUI.this);
                GMTrace.o(2749450158080L, 20485);
              }
            }, new SecurityImage.b()
            {
              public final void bQy()
              {
                GMTrace.i(2656437272576L, 19792);
                RegSetInfoUI.this.aGY();
                Object localObject = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                String str = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                int i = RegSetInfoUI.e(RegSetInfoUI.this);
                ap.vd().a(126, RegSetInfoUI.this);
                localObject = new w("", RegSetInfoUI.z(RegSetInfoUI.this), str, RegSetInfoUI.A(RegSetInfoUI.this), RegSetInfoUI.B(RegSetInfoUI.this), RegSetInfoUI.C(RegSetInfoUI.this), "", "", RegSetInfoUI.g(RegSetInfoUI.this), i, (String)localObject, ((w)paramk).FK(), "", RegSetInfoUI.E(RegSetInfoUI.this), RegSetInfoUI.j(RegSetInfoUI.this));
                ap.vd().a((k)localObject, 0);
                GMTrace.o(2656437272576L, 19792);
              }
            });
            GMTrace.o(2571611668480L, 19160);
            return;
            label560:
            int j = bf.PX((String)localObject3);
            if (j == 0)
            {
              bool1 = false;
              break;
            }
            if (j != 1) {
              break;
            }
            bool1 = true;
            break;
            this.kuu = ((w)paramk).Jr();
            ao.hlE.L("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.c.b.mN("R300_100_phone");
              if (!bool1) {}
              for (localObject1 = new Intent(this, FindMContactIntroUI.class);; localObject1 = localObject3)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", this.kuu);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", i);
                localObject2 = com.tencent.mm.plugin.c.a.imb.ak(this);
                ((Intent)localObject2).addFlags(67108864);
                ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
                MMWizardActivity.b(this, (Intent)localObject1, (Intent)localObject2);
                finish();
                break;
                localObject3 = new Intent(this, FindMContactAlertUI.class);
                ((Intent)localObject3).putExtra("alert_title", (String)localObject1);
                ((Intent)localObject3).putExtra("alert_message", (String)localObject2);
              }
            }
            localObject1 = com.tencent.mm.plugin.c.a.imb.ak(this);
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
            startActivity((Intent)localObject1);
            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
            finish();
            continue;
          }
          this.uSI.a(0, ((w)paramk).FJ(), ((w)paramk).FK(), "");
          GMTrace.o(2571611668480L, 19160);
          return;
        }
      }
      localObject1 = com.tencent.mm.f.a.dn(paramString);
      if (localObject1 != null)
      {
        ((com.tencent.mm.f.a)localObject1).a(this, null, null);
        GMTrace.o(2571611668480L, 19160);
        return;
      }
      if (p(paramInt1, paramInt2, paramString))
      {
        GMTrace.o(2571611668480L, 19160);
        return;
      }
      if (paramk.getType() == 429)
      {
        ap.vd().b(429, this);
        if (this.isb != null)
        {
          this.isb.dismiss();
          this.isb = null;
        }
        this.kWs.setVisibility(8);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.uZz = null;
          paramInt1 = ((t.b)((x)paramk).htc.zg()).sYs.tFB;
          v.d("MiroMsg.RegSetInfoUI", "UsernameRet %d", new Object[] { Integer.valueOf(paramInt1) });
          if ((paramInt1 == -14) || (paramInt1 == -10) || (paramInt1 == -7))
          {
            paramk = ((t.b)((x)paramk).htc.zg()).sYs.jLs;
            paramString = com.tencent.mm.f.a.dn(paramString);
            if (paramString != null) {
              this.uZn.setText(paramString.desc);
            }
            this.uZs.clear();
            if ((paramk != null) && (paramk.size() > 0))
            {
              if (paramk.size() > 3) {}
              for (paramInt1 = 3;; paramInt1 = paramk.size())
              {
                paramString = new String[paramInt1];
                paramInt2 = 0;
                while (paramInt2 < paramInt1)
                {
                  paramString[paramInt2] = ((avu)paramk.get(paramInt2)).tXF;
                  this.uZs.add(paramString[paramInt2]);
                  paramInt2 += 1;
                }
              }
              if (this.uZD)
              {
                if (this.uZB != null)
                {
                  this.uZB.dismiss();
                  this.uZB = null;
                }
                this.uZB = g.a(this, this.uZC, paramString, new AdapterView.OnItemClickListener()
                {
                  public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
                  {
                    GMTrace.i(2640062709760L, 19670);
                    if (RegSetInfoUI.u(RegSetInfoUI.this) != null)
                    {
                      RegSetInfoUI.u(RegSetInfoUI.this).dismiss();
                      RegSetInfoUI.v(RegSetInfoUI.this);
                    }
                    RegSetInfoUI.a(RegSetInfoUI.this).setText(paramString[paramAnonymousInt]);
                    RegSetInfoUI.a(RegSetInfoUI.this).postDelayed(new Runnable()
                    {
                      public final void run()
                      {
                        GMTrace.i(2666503602176L, 19867);
                        RegSetInfoUI.a(RegSetInfoUI.this).clearFocus();
                        RegSetInfoUI.a(RegSetInfoUI.this).requestFocus();
                        GMTrace.o(2666503602176L, 19867);
                      }
                    }, 50L);
                    RegSetInfoUI.s(RegSetInfoUI.this).setText(RegSetInfoUI.this.getString(R.l.eKg));
                    GMTrace.o(2640062709760L, 19670);
                  }
                });
              }
            }
            I(true, true);
            GMTrace.o(2571611668480L, 19160);
            return;
          }
          if (bf.mA(this.uZi.getText().toString().trim()))
          {
            I(false, false);
            GMTrace.o(2571611668480L, 19160);
            return;
          }
          I(true, false);
          this.uZn.setText(getString(R.l.eKg));
          if (this.uZB != null)
          {
            this.uZB.dismiss();
            this.uZB = null;
          }
          this.uZi.postDelayed(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(2780454453248L, 20716);
              RegSetInfoUI.a(RegSetInfoUI.this).clearFocus();
              RegSetInfoUI.a(RegSetInfoUI.this).requestFocus();
              GMTrace.o(2780454453248L, 20716);
            }
          }, 50L);
          GMTrace.o(2571611668480L, 19160);
          return;
        }
        if ((paramInt2 == -6) || (paramInt2 == 65225) || (paramInt2 == 65226))
        {
          if (this.uSI == null)
          {
            this.uSI = SecurityImage.a.a(this.uRf.uRz, R.l.eJY, 0, ((x)paramk).FJ(), ((x)paramk).FK(), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                GMTrace.i(2663282376704L, 19843);
                paramAnonymousDialogInterface = RegSetInfoUI.b(RegSetInfoUI.this).getText().toString().trim();
                Object localObject1 = RegSetInfoUI.a(RegSetInfoUI.this).getText().toString().trim();
                if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.length() <= 0))
                {
                  com.tencent.mm.ui.base.g.h(RegSetInfoUI.this, R.l.eZI, R.l.eJH);
                  GMTrace.o(2663282376704L, 19843);
                  return;
                }
                RegSetInfoUI.this.aGY();
                paramAnonymousInt = RegSetInfoUI.e(RegSetInfoUI.this);
                Object localObject2 = RegSetInfoUI.f(RegSetInfoUI.this);
                ap.vd().a(429, RegSetInfoUI.this);
                paramAnonymousDialogInterface = new x((String)localObject2, RegSetInfoUI.g(RegSetInfoUI.this), paramAnonymousInt, paramAnonymousDialogInterface, (String)localObject1, ((x)paramk).FK(), RegSetInfoUI.D(RegSetInfoUI.this).bRp());
                ap.vd().a(paramAnonymousDialogInterface, 0);
                localObject1 = RegSetInfoUI.this;
                localObject2 = RegSetInfoUI.this;
                RegSetInfoUI.this.getString(R.l.dIG);
                RegSetInfoUI.a((RegSetInfoUI)localObject1, com.tencent.mm.ui.base.g.a((Context)localObject2, RegSetInfoUI.this.getString(R.l.eJX), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    GMTrace.i(2758308528128L, 20551);
                    ap.vd().c(paramAnonymousDialogInterface);
                    ap.vd().b(429, RegSetInfoUI.this);
                    GMTrace.o(2758308528128L, 20551);
                  }
                }));
                GMTrace.o(2663282376704L, 19843);
              }
            }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                GMTrace.i(2655363530752L, 19784);
                RegSetInfoUI.F(RegSetInfoUI.this);
                GMTrace.o(2655363530752L, 19784);
              }
            }, new SecurityImage.b()
            {
              public final void bQy()
              {
                GMTrace.i(2709990146048L, 20191);
                RegSetInfoUI.this.aGY();
                int i = RegSetInfoUI.e(RegSetInfoUI.this);
                Object localObject = RegSetInfoUI.f(RegSetInfoUI.this);
                ap.vd().a(429, RegSetInfoUI.this);
                localObject = new x((String)localObject, RegSetInfoUI.g(RegSetInfoUI.this), i, "", "", ((x)paramk).FK(), "");
                ap.vd().a((k)localObject, 0);
                GMTrace.o(2709990146048L, 20191);
              }
            });
            GMTrace.o(2571611668480L, 19160);
            return;
          }
          this.uSI.a(0, ((x)paramk).FJ(), ((x)paramk).FK(), "");
          GMTrace.o(2571611668480L, 19160);
          return;
        }
        I(true, true);
      }
      if (p(paramInt1, paramInt2, paramString))
      {
        GMTrace.o(2571611668480L, 19160);
        return;
      }
      if (paramInt1 == 8)
      {
        this.uZz = getString(R.l.elm, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Toast.makeText(this, this.uZz, 0).show();
        GMTrace.o(2571611668480L, 19160);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, getString(R.l.elD, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      GMTrace.o(2571611668480L, 19160);
      return;
      label1666:
      continue;
      label1669:
      localObject1 = null;
      bool1 = bool2;
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2570806362112L, 19154);
    int i = R.i.dmr;
    GMTrace.o(2570806362112L, 19154);
    return i;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(2570672144384L, 19153);
    v.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramIntent = com.tencent.mm.plugin.c.a.imc.a(this, paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      this.uZq.setImageBitmap(paramIntent);
      this.uYd = true;
      this.uZw.setVisibility(0);
    }
    GMTrace.o(2570672144384L, 19153);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2569464184832L, 19144);
    super.onCreate(paramBundle);
    paramBundle = getString(R.l.eKh);
    if (com.tencent.mm.protocal.d.sXk) {
      paramBundle = getString(R.l.bpC) + getString(R.l.dCT);
    }
    qL(paramBundle);
    com.tencent.mm.plugin.c.a.imc.ox();
    this.uZj = getIntent().getStringExtra("regsetinfo_user");
    this.uZk = getIntent().getStringExtra("regsetinfo_bind_email");
    this.kuu = getIntent().getStringExtra("regsetinfo_ticket");
    this.lMX = getIntent().getStringExtra("regsetinfo_pwd");
    this.uZm = getIntent().getStringExtra("regsetinfo_binduin");
    if (!bf.mA(this.uZm)) {
      this.uZl = com.tencent.mm.a.o.aY(this.uZm);
    }
    this.nWv = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
    this.uZp = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
    this.uZr = getIntent().getIntExtra("regsetinfo_NextControl", 3);
    KD();
    if (this.nWv == 1)
    {
      com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",1");
      com.tencent.mm.plugin.c.b.mM("R200_900_phone");
    }
    for (;;)
    {
      this.uZD = false;
      this.uWD = new com.tencent.mm.pluginsdk.j.a();
      GMTrace.o(2569464184832L, 19144);
      return;
      if (this.nWv == 2)
      {
        com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",R4_QQ," + ap.ec("R4_QQ") + ",1");
        com.tencent.mm.plugin.c.b.mM("R4_QQ");
      }
      else if (this.nWv == 3)
      {
        com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",R200_900_email," + ap.ec("R200_900_email") + ",1");
        com.tencent.mm.plugin.c.b.mM("R200_900_email");
      }
    }
  }
  
  public void onDestroy()
  {
    GMTrace.i(2569732620288L, 19146);
    super.onDestroy();
    if (this.nWv == 1) {
      com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",2");
    }
    for (;;)
    {
      if (this.uWD != null) {
        this.uWD.close();
      }
      GMTrace.o(2569732620288L, 19146);
      return;
      if (this.nWv == 2) {
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",R4_QQ," + ap.ec("R4_QQ") + ",2");
      } else if (this.nWv == 3) {
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",R200_900_email," + ap.ec("R200_900_email") + ",2");
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2571880103936L, 19162);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aXL();
      GMTrace.o(2571880103936L, 19162);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2571880103936L, 19162);
    return bool;
  }
  
  public void onResume()
  {
    GMTrace.i(2569598402560L, 19145);
    super.onResume();
    this.uYA.postDelayed(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2566645612544L, 19123);
        RegSetInfoUI.i(RegSetInfoUI.this).requestFocus();
        RegSetInfoUI.b(RegSetInfoUI.this).clearFocus();
        GMTrace.o(2566645612544L, 19123);
      }
    }, 500L);
    GMTrace.o(2569598402560L, 19145);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/RegSetInfoUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */