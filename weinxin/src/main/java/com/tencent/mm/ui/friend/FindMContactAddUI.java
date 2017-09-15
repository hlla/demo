package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.j;
import com.tencent.mm.modelfriend.j.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ae.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.List;

public class FindMContactAddUI
  extends MMWizardActivity
{
  private e hTN;
  private int iQr;
  private ListView irY;
  private ProgressDialog isb;
  private TextView jUy;
  private String kuu;
  private View nrp;
  private boolean oGy;
  private String oTI;
  private String vcf;
  private int vcg;
  private TextView weA;
  private TextView weB;
  private Button weC;
  private List<String[]> weD;
  private j.a weE;
  private j wex;
  private TextView wey;
  private TextView wez;
  
  public FindMContactAddUI()
  {
    GMTrace.i(2792399831040L, 20805);
    this.isb = null;
    this.jUy = null;
    this.wey = null;
    this.wez = null;
    this.weA = null;
    this.weB = null;
    this.weC = null;
    this.kuu = null;
    this.hTN = null;
    this.vcf = "";
    this.vcg = 2;
    this.oGy = true;
    this.weE = new j.a()
    {
      public final void notifyDataSetChanged()
      {
        GMTrace.i(2807163781120L, 20915);
        if ((FindMContactAddUI.e(FindMContactAddUI.this) != 2) && (FindMContactAddUI.e(FindMContactAddUI.this) == 1))
        {
          FindMContactAddUI.f(FindMContactAddUI.this).setText(FindMContactAddUI.this.getString(R.l.eki));
          if (!FindMContactAddUI.c(FindMContactAddUI.this).Fh()) {
            break label251;
          }
          if ((FindMContactAddUI.e(FindMContactAddUI.this) != 1) && (FindMContactAddUI.f(FindMContactAddUI.this).getVisibility() == 0) && (FindMContactAddUI.g(FindMContactAddUI.this) != null))
          {
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(8);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(0);
          }
        }
        for (;;)
        {
          if ((FindMContactAddUI.c(FindMContactAddUI.this).Fg() <= 0) || (FindMContactAddUI.e(FindMContactAddUI.this) == 1)) {
            break label313;
          }
          FindMContactAddUI.h(FindMContactAddUI.this).setText(FindMContactAddUI.this.getResources().getQuantityString(R.j.drY, FindMContactAddUI.c(FindMContactAddUI.this).Fg(), new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).Fg()) }));
          GMTrace.o(2807163781120L, 20915);
          return;
          FindMContactAddUI.f(FindMContactAddUI.this).setText(FindMContactAddUI.this.getString(R.l.ekh, new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getCount()) }));
          break;
          label251:
          if ((FindMContactAddUI.e(FindMContactAddUI.this) != 1) && (FindMContactAddUI.f(FindMContactAddUI.this).getVisibility() == 8) && (FindMContactAddUI.g(FindMContactAddUI.this) != null))
          {
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(0);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(8);
          }
        }
        label313:
        FindMContactAddUI.h(FindMContactAddUI.this).setText(FindMContactAddUI.this.getResources().getQuantityString(R.j.dsb, FindMContactAddUI.c(FindMContactAddUI.this).getCount(), new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getCount()) }));
        GMTrace.o(2807163781120L, 20915);
      }
    };
    GMTrace.o(2792399831040L, 20805);
  }
  
  private void aXL()
  {
    GMTrace.i(2792936701952L, 20809);
    b.mN(this.oTI);
    aGY();
    zp(1);
    GMTrace.o(2792936701952L, 20809);
  }
  
  private void bYI()
  {
    GMTrace.i(2792668266496L, 20807);
    ActionBarActivity localActionBarActivity = this.uRf.uRz;
    getString(R.l.dIG);
    this.isb = g.a(localActionBarActivity, getString(R.l.eAT), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(2822733037568L, 21031);
        GMTrace.o(2822733037568L, 21031);
      }
    });
    ap.vL().a(new ae.a()
    {
      public final boolean Bn()
      {
        GMTrace.i(2787031121920L, 20765);
        try
        {
          FindMContactAddUI.a(FindMContactAddUI.this, com.tencent.mm.pluginsdk.a.dn(FindMContactAddUI.this));
          FindMContactAddUI.c(FindMContactAddUI.this).hAI = FindMContactAddUI.d(FindMContactAddUI.this);
          FindMContactAddUI.c(FindMContactAddUI.this).e(af.Gf());
          GMTrace.o(2787031121920L, 20765);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.FindMContactAddUI", localException, "", new Object[0]);
          }
        }
      }
      
      public final boolean Bo()
      {
        GMTrace.i(2786896904192L, 20764);
        if (FindMContactAddUI.a(FindMContactAddUI.this) != null)
        {
          FindMContactAddUI.a(FindMContactAddUI.this).dismiss();
          FindMContactAddUI.b(FindMContactAddUI.this);
        }
        FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
        GMTrace.o(2786896904192L, 20764);
        return false;
      }
      
      public final String toString()
      {
        GMTrace.i(2787165339648L, 20766);
        String str = super.toString() + "|listMFriendData";
        GMTrace.o(2787165339648L, 20766);
        return str;
      }
    });
    GMTrace.o(2792668266496L, 20807);
  }
  
  protected final void KD()
  {
    GMTrace.i(2793607790592L, 20814);
    this.jUy = ((TextView)findViewById(R.h.ckn));
    this.jUy.setText(R.l.eAR);
    this.irY = ((ListView)findViewById(R.h.ckp));
    if ((this.vcg != 2) && (this.vcg == 1))
    {
      this.nrp = LayoutInflater.from(this).inflate(R.i.dcO, null);
      this.wey = ((TextView)this.nrp.findViewById(R.h.bPG));
      this.wez = ((TextView)this.nrp.findViewById(R.h.bPJ));
      this.weA = ((TextView)this.nrp.findViewById(R.h.bPE));
      this.weC = ((Button)this.nrp.findViewById(R.h.bPD));
      this.wez.setText(getString(R.l.ekD));
      this.weA.setText(getString(R.l.ekE));
      this.weC.setText(getString(R.l.eki));
    }
    for (;;)
    {
      this.wex = new j(this, this.weE, 1);
      this.weC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2825417392128L, 21051);
          b.mO(ap.uY() + "," + FindMContactAddUI.this.getClass().getName() + ",R300_300_AddAllButton," + ap.ec("R300_300_AddAllButton") + ",3");
          if (FindMContactAddUI.e(FindMContactAddUI.this) == 2)
          {
            FindMContactAddUI.c(FindMContactAddUI.this).bh(true);
            FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(8);
            if (FindMContactAddUI.g(FindMContactAddUI.this) != null)
            {
              FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(0);
              GMTrace.o(2825417392128L, 21051);
            }
          }
          else
          {
            if (FindMContactAddUI.e(FindMContactAddUI.this) == 1)
            {
              FindMContactAddUI.c(FindMContactAddUI.this).bh(true);
              FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
              FindMContactAddUI.i(FindMContactAddUI.this);
              GMTrace.o(2825417392128L, 21051);
              return;
            }
            FindMContactAddUI.c(FindMContactAddUI.this).bh(true);
            FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(8);
            if (FindMContactAddUI.g(FindMContactAddUI.this) != null) {
              FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(0);
            }
          }
          GMTrace.o(2825417392128L, 21051);
        }
      });
      if (this.weB != null)
      {
        this.weB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(2798842281984L, 20853);
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(0);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(8);
            FindMContactAddUI.c(FindMContactAddUI.this).bh(false);
            FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
            GMTrace.o(2798842281984L, 20853);
          }
        });
        this.weB.setVisibility(8);
      }
      this.irY.addHeaderView(this.nrp);
      this.irY.setAdapter(this.wex);
      a(0, getString(R.l.dHH), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2797902757888L, 20846);
          FindMContactAddUI.i(FindMContactAddUI.this);
          GMTrace.o(2797902757888L, 20846);
          return true;
        }
      });
      new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2823269908480L, 21035);
          BackwardSupportUtil.c.a(FindMContactAddUI.j(FindMContactAddUI.this));
          GMTrace.o(2823269908480L, 21035);
        }
      };
      GMTrace.o(2793607790592L, 20814);
      return;
      this.nrp = LayoutInflater.from(this).inflate(R.i.dcN, null);
      this.wey = ((TextView)this.nrp.findViewById(R.h.bPG));
      this.wez = ((TextView)this.nrp.findViewById(R.h.bPJ));
      this.weA = ((TextView)this.nrp.findViewById(R.h.bPE));
      this.weC = ((Button)this.nrp.findViewById(R.h.bPD));
      this.wez.setText(getString(R.l.ekD));
      this.weA.setText(getString(R.l.ekE));
      this.weC.setText(getString(R.l.ekh, new Object[] { Integer.valueOf(0) }));
      this.weB = ((TextView)this.nrp.findViewById(R.h.cki));
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2793473572864L, 20813);
    int i = R.i.dcM;
    GMTrace.o(2793473572864L, 20813);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2792534048768L, 20806);
    super.onCreate(paramBundle);
    zd(R.l.ekm);
    com.tencent.mm.plugin.c.a.imc.ox();
    this.kuu = getIntent().getStringExtra("regsetinfo_ticket");
    this.vcf = getIntent().getStringExtra("regsetinfo_NextStep");
    this.vcg = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.iQr = getIntent().getIntExtra("login_type", 0);
    this.oTI = b.OA();
    KD();
    GMTrace.o(2792534048768L, 20806);
  }
  
  public void onDestroy()
  {
    GMTrace.i(2793339355136L, 20812);
    if (this.hTN != null)
    {
      ap.vd().b(30, this.hTN);
      this.hTN = null;
    }
    super.onDestroy();
    GMTrace.o(2793339355136L, 20812);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2792802484224L, 20808);
    if (paramInt == 4)
    {
      aXL();
      GMTrace.o(2792802484224L, 20808);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2792802484224L, 20808);
    return bool;
  }
  
  public void onPause()
  {
    GMTrace.i(2793205137408L, 20811);
    super.onPause();
    if (this.iQr == 1)
    {
      b.b(false, ap.uY() + "," + getClass().getName() + ",R300_300_QQ," + ap.ec("R300_300_QQ") + ",2");
      GMTrace.o(2793205137408L, 20811);
      return;
    }
    b.b(false, ap.uY() + "," + getClass().getName() + ",R300_300_phone," + ap.ec("R300_300_phone") + ",2");
    GMTrace.o(2793205137408L, 20811);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    GMTrace.i(2793742008320L, 20815);
    v.i("MicroMsg.FindMContactAddUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(2793742008320L, 20815);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bYI();
        GMTrace.o(2793742008320L, 20815);
        return;
      }
      this.oGy = false;
      g.a(this, getString(R.l.eFz), getString(R.l.eFE), getString(R.l.evo), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2798573846528L, 20851);
          FindMContactAddUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
          FindMContactAddUI.q(FindMContactAddUI.this);
          FindMContactAddUI.this.finish();
          GMTrace.o(2798573846528L, 20851);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2810787659776L, 20942);
          FindMContactAddUI.q(FindMContactAddUI.this);
          FindMContactAddUI.this.finish();
          GMTrace.o(2810787659776L, 20942);
        }
      });
    }
  }
  
  protected void onResume()
  {
    GMTrace.i(2793070919680L, 20810);
    super.onResume();
    this.wex.notifyDataSetChanged();
    if (this.iQr == 1)
    {
      b.b(true, ap.uY() + "," + getClass().getName() + ",R300_300_QQ," + ap.ec("R300_300_QQ") + ",1");
      b.mM("R300_300_QQ");
    }
    while (this.oGy)
    {
      boolean bool = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
      v.i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP() });
      if (!bool)
      {
        GMTrace.o(2793070919680L, 20810);
        return;
        b.b(true, ap.uY() + "," + getClass().getName() + ",R300_300_phone," + ap.ec("R300_300_phone") + ",1");
        b.mM("R300_300_phone");
      }
      else
      {
        bYI();
      }
    }
    GMTrace.o(2793070919680L, 20810);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/friend/FindMContactAddUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */