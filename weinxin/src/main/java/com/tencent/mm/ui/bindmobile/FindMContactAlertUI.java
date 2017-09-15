package com.tencent.mm.ui.bindmobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelfriend.y;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.protocal.c.ajj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ae.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAlertUI
  extends MMWizardActivity
{
  private String fOz;
  private List<String[]> hAI;
  private e hTN;
  private String iXW;
  private String iXX;
  private ProgressDialog isb;
  private String kuu;
  private String oTI;
  private int qkj;
  private String vcf;
  private int vcg;
  private String vsi;
  private String vsj;
  private boolean vsk;
  private y vsl;
  private int vsm;
  private final int vsn;
  private int vso;
  private int vsp;
  private int vsq;
  private int vsr;
  private int vss;
  
  public FindMContactAlertUI()
  {
    GMTrace.i(3133849731072L, 23349);
    this.kuu = null;
    this.vcf = "";
    this.vcg = 2;
    this.vsi = null;
    this.vsj = null;
    this.vsk = false;
    this.hAI = null;
    this.hTN = null;
    this.isb = null;
    this.vsm = 0;
    this.vsn = 200;
    this.vso = 0;
    this.vsp = 0;
    this.vsq = 0;
    this.qkj = 0;
    this.vsr = 0;
    this.vss = 0;
    GMTrace.o(3133849731072L, 23349);
  }
  
  private void aXL()
  {
    GMTrace.i(3135326126080L, 23360);
    b.mN(this.oTI);
    aGY();
    zp(1);
    GMTrace.o(3135326126080L, 23360);
  }
  
  private void bSY()
  {
    GMTrace.i(3134655037440L, 23355);
    if (this.vsk)
    {
      b.mO(ap.uY() + "," + getClass().getName() + ",R300_200_phone," + ap.ec("R300_200_phone") + ",1");
      com.tencent.mm.ui.base.g.a(this, false, getString(R.l.ekn), getString(R.l.dIG), getString(R.l.dHL), getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3101905911808L, 23111);
          ap.yY();
          c.vr().set(12322, Boolean.valueOf(true));
          b.mN("R200_100");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("mobile_input_purpose", 4);
          paramAnonymousDialogInterface.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
          com.tencent.mm.plugin.c.a.imb.a(FindMContactAlertUI.this, paramAnonymousDialogInterface);
          b.mN("R300_300_phone");
          b.b(false, ap.uY() + "," + FindMContactAlertUI.this.getClass().getName() + ",R300_200_phone," + ap.ec("R300_200_phone") + ",2");
          GMTrace.o(3101905911808L, 23111);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3098282033152L, 23084);
          ap.yY();
          c.vr().set(12322, Boolean.valueOf(false));
          b.mO(ap.uY() + "," + FindMContactAlertUI.this.getClass().getName() + ",R300_200_phone," + ap.ec("R300_200_phone") + ",2");
          FindMContactAlertUI.d(FindMContactAlertUI.this);
          GMTrace.o(3098282033152L, 23084);
        }
      });
      GMTrace.o(3134655037440L, 23355);
      return;
    }
    if (com.tencent.mm.modelfriend.m.Fl())
    {
      final Object localObject = this.iXX;
      String str = this.iXW;
      int i = R.l.ekB;
      int j = R.l.ekA;
      DialogInterface.OnClickListener local5 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3102442782720L, 23115);
          ap.yY();
          c.vr().set(12322, Boolean.valueOf(true));
          FindMContactAlertUI.e(FindMContactAlertUI.this);
          paramAnonymousDialogInterface.dismiss();
          GMTrace.o(3102442782720L, 23115);
        }
      };
      DialogInterface.OnClickListener local6 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3138681569280L, 23385);
          paramAnonymousDialogInterface = new Intent(FindMContactAlertUI.this, FindMContactLearmMoreUI.class);
          paramAnonymousDialogInterface.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
          paramAnonymousDialogInterface.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
          MMWizardActivity.w(FindMContactAlertUI.this, paramAnonymousDialogInterface);
          GMTrace.o(3138681569280L, 23385);
        }
      };
      final com.tencent.mm.ui.base.h localh = new com.tencent.mm.ui.base.h(this);
      localh.setTitle(str);
      localh.setMessage((CharSequence)localObject);
      localh.a(i, local5);
      localh.b(j, local6);
      localh.rLu.setVisibility(0);
      localh.setCancelable(false);
      localh.show();
      localh.getWindow().clearFlags(2);
      a(localh);
      localh.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          GMTrace.i(3148479463424L, 23458);
          localh.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
          int i = localh.getWindow().getDecorView().getMeasuredWidth();
          int j = localh.getWindow().getDecorView().getMeasuredHeight();
          View localView = FindMContactAlertUI.a(FindMContactAlertUI.this, (ViewGroup)localh.getWindow().getDecorView());
          if (localView != null) {
            i = localView.getMeasuredWidth() * 2;
          }
          for (;;)
          {
            v.d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            FindMContactAlertUI.a(FindMContactAlertUI.this, i, j);
            GMTrace.o(3148479463424L, 23458);
            return;
          }
        }
      });
      localObject = findViewById(R.h.background);
      ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          GMTrace.i(3149284769792L, 23464);
          localObject.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          int i = localObject.getMeasuredHeight();
          int j = localObject.getMeasuredWidth();
          v.d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          FindMContactAlertUI.b(FindMContactAlertUI.this, j, i);
          GMTrace.o(3149284769792L, 23464);
        }
      });
      GMTrace.o(3134655037440L, 23355);
      return;
    }
    bTa();
    GMTrace.o(3134655037440L, 23355);
  }
  
  private void bSZ()
  {
    GMTrace.i(3134923472896L, 23357);
    int j = getWindowManager().getDefaultDisplay().getHeight();
    int i = this.vsq - (getResources().getDimensionPixelSize(R.f.aXJ) + com.tencent.mm.bg.a.fromDPToPix(this, 48));
    int k = j / 2;
    int m = this.vsp / 2;
    int n = this.qkj;
    j = com.tencent.mm.bg.a.fromDPToPix(this, 20) + (k + m - (j - n));
    if ((i != this.vsr) || (j != this.vss))
    {
      this.vsr = i;
      this.vss = j;
      View localView = findViewById(R.h.bPF);
      localView.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.setMargins(i - localView.getMeasuredWidth() / 2, j, 0, 0);
      v.d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localView.getMeasuredWidth()) });
      localView.setLayoutParams(localLayoutParams);
      localView.startAnimation(AnimationUtils.loadAnimation(this, R.a.aQN));
    }
    GMTrace.o(3134923472896L, 23357);
  }
  
  private void bTa()
  {
    GMTrace.i(3135057690624L, 23358);
    boolean bool = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    v.i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP() });
    if (!bool)
    {
      GMTrace.o(3135057690624L, 23358);
      return;
    }
    Object localObject = findViewById(R.h.bPF);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = ap.vd();
    e local9 = new e()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk)
      {
        GMTrace.i(3120830611456L, 23252);
        if (FindMContactAlertUI.f(FindMContactAlertUI.this) != null)
        {
          FindMContactAlertUI.f(FindMContactAlertUI.this).dismiss();
          FindMContactAlertUI.g(FindMContactAlertUI.this);
        }
        if (FindMContactAlertUI.h(FindMContactAlertUI.this) != null)
        {
          ap.vd().b(431, FindMContactAlertUI.h(FindMContactAlertUI.this));
          FindMContactAlertUI.i(FindMContactAlertUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((y)paramAnonymousk).FL();
          af.f(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label399;
          }
          paramAnonymousk = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousk.hasNext())
          {
            ajj localajj = (ajj)paramAnonymousk.next();
            if (localajj != null)
            {
              if (localajj.jLP != 1) {
                break label396;
              }
              paramAnonymousInt1 += 1;
            }
          }
          if (paramAnonymousInt1 > 0) {
            paramAnonymousInt2 = 1;
          }
        }
        for (;;)
        {
          if (paramAnonymousString == null) {}
          for (int i = 0;; i = paramAnonymousString.size())
          {
            v.d("MicroMsg.FindMContactAlertUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactAlertUI.b(FindMContactAlertUI.this) == null) || (!FindMContactAlertUI.b(FindMContactAlertUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label323;
            }
            b.mN("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactAlertUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(FindMContactAlertUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.w(FindMContactAlertUI.this, paramAnonymousString);
            GMTrace.o(3120830611456L, 23252);
            return;
            paramAnonymousInt2 = 0;
            break;
          }
          label323:
          FindMContactAlertUI.d(FindMContactAlertUI.this);
          GMTrace.o(3120830611456L, 23252);
          return;
          Toast.makeText(FindMContactAlertUI.this, FindMContactAlertUI.this.getString(R.l.dGM, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }), 0).show();
          FindMContactAlertUI.d(FindMContactAlertUI.this);
          GMTrace.o(3120830611456L, 23252);
          return;
          label396:
          break;
          label399:
          paramAnonymousInt1 = 0;
          paramAnonymousInt2 = 0;
        }
      }
    };
    this.hTN = local9;
    ((n)localObject).a(431, local9);
    localObject = this.uRf.uRz;
    getString(R.l.dIG);
    this.isb = com.tencent.mm.ui.base.g.a((Context)localObject, getString(R.l.fnD), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(3104456048640L, 23130);
        if (FindMContactAlertUI.h(FindMContactAlertUI.this) != null)
        {
          ap.vd().b(431, FindMContactAlertUI.h(FindMContactAlertUI.this));
          FindMContactAlertUI.i(FindMContactAlertUI.this);
          FindMContactAlertUI.j(FindMContactAlertUI.this);
        }
        GMTrace.o(3104456048640L, 23130);
      }
    });
    ap.vL().a(new ae.a()
    {
      public final boolean Bn()
      {
        GMTrace.i(3097879379968L, 23081);
        for (;;)
        {
          try
          {
            FindMContactAlertUI.a(FindMContactAlertUI.this, com.tencent.mm.pluginsdk.a.dn(FindMContactAlertUI.this));
            StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
            if (FindMContactAlertUI.k(FindMContactAlertUI.this) != null) {
              continue;
            }
            i = 0;
            v.d("MicroMsg.FindMContactAlertUI", i);
          }
          catch (Exception localException)
          {
            int i;
            v.printErrStackTrace("MicroMsg.FindMContactAlertUI", localException, "", new Object[0]);
            continue;
          }
          GMTrace.o(3097879379968L, 23081);
          return true;
          i = FindMContactAlertUI.k(FindMContactAlertUI.this).size();
        }
      }
      
      public final boolean Bo()
      {
        GMTrace.i(3097745162240L, 23080);
        if ((FindMContactAlertUI.k(FindMContactAlertUI.this) != null) && (FindMContactAlertUI.k(FindMContactAlertUI.this).size() != 0))
        {
          FindMContactAlertUI.a(FindMContactAlertUI.this, new y(FindMContactAlertUI.a(FindMContactAlertUI.this), FindMContactAlertUI.k(FindMContactAlertUI.this)));
          ap.vd().a(FindMContactAlertUI.l(FindMContactAlertUI.this), 0);
        }
        for (;;)
        {
          GMTrace.o(3097745162240L, 23080);
          return false;
          if (FindMContactAlertUI.f(FindMContactAlertUI.this) != null)
          {
            FindMContactAlertUI.f(FindMContactAlertUI.this).dismiss();
            FindMContactAlertUI.g(FindMContactAlertUI.this);
          }
          FindMContactAlertUI.d(FindMContactAlertUI.this);
        }
      }
      
      public final String toString()
      {
        GMTrace.i(3098013597696L, 23082);
        String str = super.toString() + "|doUpload";
        GMTrace.o(3098013597696L, 23082);
        return str;
      }
    });
    com.tencent.mm.platformtools.m.f(true, false);
    com.tencent.mm.modelfriend.a.EM();
    com.tencent.mm.plugin.report.service.g.oSF.i(11438, new Object[] { Integer.valueOf(1) });
    v.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(1) });
    GMTrace.o(3135057690624L, 23358);
  }
  
  private View i(ViewGroup paramViewGroup)
  {
    GMTrace.i(3134789255168L, 23356);
    if (this.vsm >= 200)
    {
      GMTrace.o(3134789255168L, 23356);
      return null;
    }
    this.vsm += 1;
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof Button))
      {
        GMTrace.o(3134789255168L, 23356);
        return localView;
      }
      if ((localView instanceof ViewGroup))
      {
        localView = i((ViewGroup)localView);
        if (localView != null)
        {
          GMTrace.o(3134789255168L, 23356);
          return localView;
        }
      }
      i += 1;
    }
    GMTrace.o(3134789255168L, 23356);
    return null;
  }
  
  protected final void KD()
  {
    GMTrace.i(3134520819712L, 23354);
    this.iXW = getString(R.l.eko);
    this.iXX = getString(R.l.ekn);
    if (!bf.mA(this.vsi)) {
      this.iXW = this.vsi;
    }
    if (!bf.mA(this.vsj)) {
      this.iXX = this.vsj;
    }
    ap.yY();
    this.fOz = ((String)c.vr().get(6, null));
    if ((this.fOz == null) || (this.fOz.equals("")))
    {
      ap.yY();
      this.fOz = ((String)c.vr().get(4097, null));
    }
    GMTrace.o(3134520819712L, 23354);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(3135460343808L, 23361);
    int i = R.i.dcR;
    GMTrace.o(3135460343808L, 23361);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3133983948800L, 23350);
    super.onCreate(paramBundle);
    zd(R.l.bPE);
    com.tencent.mm.plugin.c.a.imc.ox();
    this.kuu = getIntent().getStringExtra("regsetinfo_ticket");
    this.vcf = getIntent().getStringExtra("regsetinfo_NextStep");
    this.vcg = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.vsi = getIntent().getStringExtra("alert_title");
    this.vsj = getIntent().getStringExtra("alert_message");
    if (com.tencent.mm.modelfriend.m.Fm() != m.a.hBa) {}
    for (boolean bool = true;; bool = false)
    {
      this.vsk = bool;
      this.oTI = b.OA();
      v.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.vcf, Integer.valueOf(this.vcg) });
      if (!isFinishing()) {
        break;
      }
      GMTrace.o(3133983948800L, 23350);
      return;
    }
    KD();
    bSY();
    GMTrace.o(3133983948800L, 23350);
  }
  
  public void onDestroy()
  {
    GMTrace.i(3134118166528L, 23351);
    v.d("MicroMsg.FindMContactAlertUI", "ondestroy");
    if (this.hTN != null)
    {
      ap.vd().b(431, this.hTN);
      this.hTN = null;
    }
    super.onDestroy();
    GMTrace.o(3134118166528L, 23351);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(3135191908352L, 23359);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aXL();
      GMTrace.o(3135191908352L, 23359);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(3135191908352L, 23359);
    return bool;
  }
  
  protected void onPause()
  {
    GMTrace.i(3134386601984L, 23353);
    super.onPause();
    if (this.vsk)
    {
      b.b(false, ap.uY() + "," + getClass().getName() + ",R300_100_QQ," + ap.ec("R300_100_QQ") + ",2");
      GMTrace.o(3134386601984L, 23353);
      return;
    }
    b.b(false, ap.uY() + "," + getClass().getName() + ",RE300_100," + ap.ec("RE300_100") + ",2");
    GMTrace.o(3134386601984L, 23353);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    GMTrace.i(3135594561536L, 23362);
    v.i("MicroMsg.FindMContactAlertUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(3135594561536L, 23362);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bTa();
        GMTrace.o(3135594561536L, 23362);
        return;
      }
      com.tencent.mm.ui.base.g.a(this, getString(R.l.eFz), getString(R.l.eFE), getString(R.l.evo), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3124857143296L, 23282);
          paramAnonymousDialogInterface.dismiss();
          FindMContactAlertUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
          GMTrace.o(3124857143296L, 23282);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3105261355008L, 23136);
          paramAnonymousDialogInterface.dismiss();
          GMTrace.o(3105261355008L, 23136);
        }
      });
    }
  }
  
  protected void onResume()
  {
    GMTrace.i(3134252384256L, 23352);
    super.onResume();
    if (this.vsk)
    {
      b.mM("R300_100_QQ");
      b.b(true, ap.uY() + "," + getClass().getName() + ",R300_100_QQ," + ap.ec("R300_100_QQ") + ",1");
      GMTrace.o(3134252384256L, 23352);
      return;
    }
    b.mM("R300_100_phone");
    b.b(true, ap.uY() + "," + getClass().getName() + ",RE300_100," + ap.ec("RE300_100") + ",1");
    GMTrace.o(3134252384256L, 23352);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindmobile/FindMContactAlertUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */