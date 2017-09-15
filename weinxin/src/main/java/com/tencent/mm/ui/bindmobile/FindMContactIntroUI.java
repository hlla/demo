package com.tencent.mm.ui.bindmobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelfriend.y;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.h;
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
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactIntroUI
  extends MMWizardActivity
{
  private String fOz;
  private List<String[]> hAI;
  private e hTN;
  private ProgressDialog isb;
  private String kuu;
  private String oTI;
  private TextView oXR;
  private String vcf;
  private int vcg;
  private boolean vsk;
  private y vsl;
  private Button vsv;
  private TextView vsw;
  
  public FindMContactIntroUI()
  {
    GMTrace.i(3111032717312L, 23179);
    this.kuu = null;
    this.vcf = "";
    this.vcg = 2;
    this.vsk = false;
    this.hAI = null;
    this.hTN = null;
    this.isb = null;
    GMTrace.o(3111032717312L, 23179);
  }
  
  private void aXL()
  {
    GMTrace.i(3112106459136L, 23187);
    b.mN(this.oTI);
    aGY();
    zp(1);
    GMTrace.o(3112106459136L, 23187);
  }
  
  private void bTa()
  {
    GMTrace.i(3111838023680L, 23185);
    boolean bool = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    v.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP() });
    if (!bool)
    {
      GMTrace.o(3111838023680L, 23185);
      return;
    }
    Object localObject = ap.vd();
    e local9 = new e()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk)
      {
        GMTrace.i(3098550468608L, 23086);
        if (FindMContactIntroUI.g(FindMContactIntroUI.this) != null)
        {
          FindMContactIntroUI.g(FindMContactIntroUI.this).dismiss();
          FindMContactIntroUI.h(FindMContactIntroUI.this);
        }
        if (FindMContactIntroUI.i(FindMContactIntroUI.this) != null)
        {
          ap.vd().b(431, FindMContactIntroUI.i(FindMContactIntroUI.this));
          FindMContactIntroUI.j(FindMContactIntroUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((y)paramAnonymousk).FL();
          af.f(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label392;
          }
          paramAnonymousk = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousk.hasNext())
          {
            ajj localajj = (ajj)paramAnonymousk.next();
            if (localajj != null)
            {
              if (localajj.jLP != 1) {
                break label389;
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
            v.d("MicroMsg.FindMContactIntroUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactIntroUI.d(FindMContactIntroUI.this) == null) || (!FindMContactIntroUI.d(FindMContactIntroUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label323;
            }
            b.mN("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactIntroUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactIntroUI.c(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactIntroUI.d(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.e(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.w(FindMContactIntroUI.this, paramAnonymousString);
            GMTrace.o(3098550468608L, 23086);
            return;
            paramAnonymousInt2 = 0;
            break;
          }
          label323:
          FindMContactIntroUI.b(FindMContactIntroUI.this);
          GMTrace.o(3098550468608L, 23086);
          return;
          Toast.makeText(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(R.l.dGM, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }), 0).show();
          GMTrace.o(3098550468608L, 23086);
          return;
          label389:
          break;
          label392:
          paramAnonymousInt1 = 0;
          paramAnonymousInt2 = 0;
        }
      }
    };
    this.hTN = local9;
    ((n)localObject).a(431, local9);
    localObject = this.uRf.uRz;
    getString(R.l.dIG);
    this.isb = g.a((Context)localObject, getString(R.l.fnD), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(3106603532288L, 23146);
        if (FindMContactIntroUI.i(FindMContactIntroUI.this) != null)
        {
          ap.vd().b(431, FindMContactIntroUI.i(FindMContactIntroUI.this));
          FindMContactIntroUI.j(FindMContactIntroUI.this);
        }
        GMTrace.o(3106603532288L, 23146);
      }
    });
    ap.vL().a(new ae.a()
    {
      public final boolean Bn()
      {
        GMTrace.i(3104858701824L, 23133);
        for (;;)
        {
          try
          {
            FindMContactIntroUI.a(FindMContactIntroUI.this, com.tencent.mm.pluginsdk.a.dn(FindMContactIntroUI.this));
            StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
            if (FindMContactIntroUI.k(FindMContactIntroUI.this) != null) {
              continue;
            }
            i = 0;
            v.d("MicroMsg.FindMContactIntroUI", i);
          }
          catch (Exception localException)
          {
            int i;
            v.printErrStackTrace("MicroMsg.FindMContactIntroUI", localException, "", new Object[0]);
            continue;
          }
          GMTrace.o(3104858701824L, 23133);
          return true;
          i = FindMContactIntroUI.k(FindMContactIntroUI.this).size();
        }
      }
      
      public final boolean Bo()
      {
        GMTrace.i(3104724484096L, 23132);
        if ((FindMContactIntroUI.k(FindMContactIntroUI.this) != null) && (FindMContactIntroUI.k(FindMContactIntroUI.this).size() != 0))
        {
          FindMContactIntroUI.a(FindMContactIntroUI.this, new y(FindMContactIntroUI.c(FindMContactIntroUI.this), FindMContactIntroUI.k(FindMContactIntroUI.this)));
          ap.vd().a(FindMContactIntroUI.l(FindMContactIntroUI.this), 0);
        }
        for (;;)
        {
          GMTrace.o(3104724484096L, 23132);
          return false;
          if (FindMContactIntroUI.g(FindMContactIntroUI.this) != null)
          {
            FindMContactIntroUI.g(FindMContactIntroUI.this).dismiss();
            FindMContactIntroUI.h(FindMContactIntroUI.this);
          }
          FindMContactIntroUI.b(FindMContactIntroUI.this);
        }
      }
      
      public final String toString()
      {
        GMTrace.i(3104992919552L, 23134);
        String str = super.toString() + "|doUpload";
        GMTrace.o(3104992919552L, 23134);
        return str;
      }
    });
    GMTrace.o(3111838023680L, 23185);
  }
  
  protected final void KD()
  {
    GMTrace.i(3111703805952L, 23184);
    this.vsv = ((Button)findViewById(R.h.cCL));
    this.vsw = ((TextView)findViewById(R.h.bPI));
    this.oXR = ((TextView)findViewById(R.h.bPH));
    if ((this.vcf != null) && (this.vcf.contains("2"))) {
      this.oXR.setText(getString(R.l.ekk));
    }
    for (;;)
    {
      ap.yY();
      this.fOz = ((String)c.vr().get(6, null));
      if ((this.fOz == null) || (this.fOz.equals("")))
      {
        ap.yY();
        this.fOz = ((String)c.vr().get(4097, null));
      }
      this.vsv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(3121099046912L, 23254);
          FindMContactIntroUI.a(FindMContactIntroUI.this);
          GMTrace.o(3121099046912L, 23254);
        }
      });
      this.vsw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(3121367482368L, 23256);
          g.b(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(R.l.ekx), null, FindMContactIntroUI.this.getString(R.l.eky), FindMContactIntroUI.this.getString(R.l.ekw), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GMTrace.i(3110227410944L, 23173);
              FindMContactIntroUI.b(FindMContactIntroUI.this);
              GMTrace.o(3110227410944L, 23173);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GMTrace.i(3106335096832L, 23144);
              GMTrace.o(3106335096832L, 23144);
            }
          });
          GMTrace.o(3121367482368L, 23256);
        }
      });
      GMTrace.o(3111703805952L, 23184);
      return;
      this.oXR.setText(getString(R.l.ekl));
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(3112240676864L, 23188);
    int i = R.i.dcP;
    GMTrace.o(3112240676864L, 23188);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3111166935040L, 23180);
    super.onCreate(paramBundle);
    zd(R.l.bPE);
    com.tencent.mm.plugin.c.a.imc.ox();
    this.kuu = getIntent().getStringExtra("regsetinfo_ticket");
    this.vcf = getIntent().getStringExtra("regsetinfo_NextStep");
    this.vcg = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    if (m.Fm() != m.a.hBa) {}
    for (boolean bool = true;; bool = false)
    {
      this.vsk = bool;
      this.oTI = b.OA();
      v.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.vcf, Integer.valueOf(this.vcg) });
      GMTrace.o(3111166935040L, 23180);
      return;
    }
  }
  
  public void onDestroy()
  {
    GMTrace.i(3111301152768L, 23181);
    if (this.hTN != null)
    {
      ap.vd().b(431, this.hTN);
      this.hTN = null;
    }
    super.onDestroy();
    GMTrace.o(3111301152768L, 23181);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(3111972241408L, 23186);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aXL();
      GMTrace.o(3111972241408L, 23186);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(3111972241408L, 23186);
    return bool;
  }
  
  protected void onPause()
  {
    GMTrace.i(3111569588224L, 23183);
    super.onPause();
    b.mN("RE900_100");
    if (this.vsk)
    {
      b.b(false, ap.uY() + "," + getClass().getName() + ",R300_100_QQ," + ap.ec("R300_100_QQ") + ",4");
      GMTrace.o(3111569588224L, 23183);
      return;
    }
    b.b(false, ap.uY() + "," + getClass().getName() + ",R300_100_phone," + ap.ec("R300_100_phone") + ",4");
    GMTrace.o(3111569588224L, 23183);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    GMTrace.i(3112374894592L, 23189);
    v.i("MicroMsg.FindMContactIntroUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(3112374894592L, 23189);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bTa();
        GMTrace.o(3112374894592L, 23189);
        return;
      }
      g.a(this, getString(R.l.eFz), getString(R.l.eFE), getString(R.l.evo), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3124051836928L, 23276);
          paramAnonymousDialogInterface.dismiss();
          FindMContactIntroUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
          GMTrace.o(3124051836928L, 23276);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3105529790464L, 23138);
          paramAnonymousDialogInterface.dismiss();
          GMTrace.o(3105529790464L, 23138);
        }
      });
    }
  }
  
  protected void onResume()
  {
    GMTrace.i(3111435370496L, 23182);
    super.onResume();
    KD();
    if (this.vsk)
    {
      b.b(true, ap.uY() + "," + getClass().getName() + ",R300_100_QQ," + ap.ec("R300_100_QQ") + ",1");
      b.mM("R300_100_QQ");
      GMTrace.o(3111435370496L, 23182);
      return;
    }
    b.b(true, ap.uY() + "," + getClass().getName() + ",R300_100_phone," + ap.ec("R300_100_phone") + ",1");
    b.mM("R300_100_phone");
    GMTrace.o(3111435370496L, 23182);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindmobile/FindMContactIntroUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */