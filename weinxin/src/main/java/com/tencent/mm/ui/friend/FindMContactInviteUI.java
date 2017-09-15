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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.j;
import com.tencent.mm.modelfriend.j.a;
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

public class FindMContactInviteUI
  extends MMWizardActivity
{
  private e hTN;
  private int iQr;
  private ListView irY;
  private ProgressDialog isb;
  private TextView jUy;
  private View nrp;
  private boolean oGy;
  private String oTI;
  private int vcg;
  private TextView weA;
  private TextView weB;
  private Button weC;
  private List<String[]> weD;
  private j.a weE;
  private String weG;
  private j wex;
  private TextView wey;
  private TextView wez;
  
  public FindMContactInviteUI()
  {
    GMTrace.i(2825551609856L, 21052);
    this.isb = null;
    this.jUy = null;
    this.wey = null;
    this.wez = null;
    this.weA = null;
    this.weB = null;
    this.weC = null;
    this.weG = null;
    this.hTN = null;
    this.vcg = 2;
    this.oGy = true;
    this.weE = new j.a()
    {
      public final void notifyDataSetChanged()
      {
        GMTrace.i(2830920318976L, 21092);
        if ((FindMContactInviteUI.d(FindMContactInviteUI.this) != 2) && (FindMContactInviteUI.d(FindMContactInviteUI.this) == 1))
        {
          FindMContactInviteUI.e(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getString(R.l.ekr));
          if (!FindMContactInviteUI.b(FindMContactInviteUI.this).Fh()) {
            break label251;
          }
          if ((FindMContactInviteUI.d(FindMContactInviteUI.this) != 1) && (FindMContactInviteUI.e(FindMContactInviteUI.this).getVisibility() == 0) && (FindMContactInviteUI.f(FindMContactInviteUI.this) != null))
          {
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(8);
            FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(0);
          }
        }
        for (;;)
        {
          if ((FindMContactInviteUI.b(FindMContactInviteUI.this).Fg() <= 0) || (FindMContactInviteUI.d(FindMContactInviteUI.this) == 1)) {
            break label313;
          }
          FindMContactInviteUI.g(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getResources().getQuantityString(R.j.drZ, FindMContactInviteUI.b(FindMContactInviteUI.this).Fg(), new Object[] { Integer.valueOf(FindMContactInviteUI.b(FindMContactInviteUI.this).Fg()) }));
          GMTrace.o(2830920318976L, 21092);
          return;
          FindMContactInviteUI.e(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getString(R.l.ekq, new Object[] { Integer.valueOf(FindMContactInviteUI.b(FindMContactInviteUI.this).getCount()) }));
          break;
          label251:
          if ((FindMContactInviteUI.d(FindMContactInviteUI.this) != 1) && (FindMContactInviteUI.e(FindMContactInviteUI.this).getVisibility() == 8) && (FindMContactInviteUI.f(FindMContactInviteUI.this) != null))
          {
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(0);
            FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(8);
          }
        }
        label313:
        FindMContactInviteUI.g(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getResources().getQuantityString(R.j.dsa, FindMContactInviteUI.b(FindMContactInviteUI.this).getCount(), new Object[] { Integer.valueOf(FindMContactInviteUI.b(FindMContactInviteUI.this).getCount()) }));
        GMTrace.o(2830920318976L, 21092);
      }
    };
    GMTrace.o(2825551609856L, 21052);
  }
  
  private void aXL()
  {
    GMTrace.i(2825954263040L, 21055);
    com.tencent.mm.plugin.c.b.mN(this.oTI);
    aGY();
    zp(1);
    GMTrace.o(2825954263040L, 21055);
  }
  
  private void bYI()
  {
    GMTrace.i(2826222698496L, 21057);
    ActionBarActivity localActionBarActivity = this.uRf.uRz;
    getString(R.l.dIG);
    this.isb = g.a(localActionBarActivity, getString(R.l.eAT), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(2805553168384L, 20903);
        GMTrace.o(2805553168384L, 20903);
      }
    });
    ap.vL().a(new ae.a()
    {
      public final boolean Bn()
      {
        GMTrace.i(2830249230336L, 21087);
        try
        {
          FindMContactInviteUI.a(FindMContactInviteUI.this, com.tencent.mm.pluginsdk.a.dn(FindMContactInviteUI.this));
          FindMContactInviteUI.b(FindMContactInviteUI.this).hAI = FindMContactInviteUI.c(FindMContactInviteUI.this);
          FindMContactInviteUI.b(FindMContactInviteUI.this).e(af.Gf());
          GMTrace.o(2830249230336L, 21087);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.FindMContactInviteUI", localException, "", new Object[0]);
          }
        }
      }
      
      public final boolean Bo()
      {
        GMTrace.i(2830115012608L, 21086);
        if (FindMContactInviteUI.a(FindMContactInviteUI.this) != null)
        {
          FindMContactInviteUI.a(FindMContactInviteUI.this).dismiss();
          FindMContactInviteUI.a(FindMContactInviteUI.this, null);
        }
        FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
        GMTrace.o(2830115012608L, 21086);
        return false;
      }
      
      public final String toString()
      {
        GMTrace.i(2830383448064L, 21088);
        String str = super.toString() + "|listMFriendData";
        GMTrace.o(2830383448064L, 21088);
        return str;
      }
    });
    GMTrace.o(2826222698496L, 21057);
  }
  
  protected final void KD()
  {
    GMTrace.i(2826759569408L, 21061);
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
      this.wez.setText(getString(R.l.eks));
      this.weA.setText(getString(R.l.eks));
      this.weC.setText(getString(R.l.ekr));
    }
    for (;;)
    {
      this.wex = new j(this, this.weE, 2);
      this.weC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2809445482496L, 20932);
          com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + FindMContactInviteUI.this.getClass().getName() + ",R300_400_AddAllButton," + ap.ec("R300_300_AddAllButton") + ",3");
          if (FindMContactInviteUI.d(FindMContactInviteUI.this) == 2)
          {
            FindMContactInviteUI.b(FindMContactInviteUI.this).bh(true);
            FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(8);
            if (FindMContactInviteUI.f(FindMContactInviteUI.this) != null)
            {
              FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(0);
              GMTrace.o(2809445482496L, 20932);
            }
          }
          else
          {
            if (FindMContactInviteUI.d(FindMContactInviteUI.this) == 1)
            {
              FindMContactInviteUI.b(FindMContactInviteUI.this).bh(true);
              FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
              FindMContactInviteUI.h(FindMContactInviteUI.this);
              GMTrace.o(2809445482496L, 20932);
              return;
            }
            FindMContactInviteUI.b(FindMContactInviteUI.this).bh(true);
            FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(8);
            if (FindMContactInviteUI.f(FindMContactInviteUI.this) != null) {
              FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(0);
            }
          }
          GMTrace.o(2809445482496L, 20932);
        }
      });
      if (this.weB != null)
      {
        this.weB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(2804076773376L, 20892);
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(0);
            FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(8);
            FindMContactInviteUI.b(FindMContactInviteUI.this).bh(false);
            FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
            GMTrace.o(2804076773376L, 20892);
          }
        });
        this.weB.setVisibility(8);
      }
      this.irY.addHeaderView(this.nrp);
      this.irY.setAdapter(this.wex);
      this.irY.setOnScrollListener(new com.tencent.mm.ui.applet.a());
      this.irY.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          GMTrace.i(2796426362880L, 20835);
          if (FindMContactInviteUI.b(FindMContactInviteUI.this) != null)
          {
            paramAnonymousView = FindMContactInviteUI.b(FindMContactInviteUI.this);
            if (paramAnonymousView.hAM != null) {
              paramAnonymousView.hAM.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          GMTrace.o(2796426362880L, 20835);
          return false;
        }
      });
      a(0, getString(R.l.dHh), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2805016297472L, 20899);
          FindMContactInviteUI.h(FindMContactInviteUI.this);
          GMTrace.o(2805016297472L, 20899);
          return true;
        }
      });
      new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2808505958400L, 20925);
          BackwardSupportUtil.c.a(FindMContactInviteUI.i(FindMContactInviteUI.this));
          GMTrace.o(2808505958400L, 20925);
        }
      };
      GMTrace.o(2826759569408L, 21061);
      return;
      this.nrp = LayoutInflater.from(this).inflate(R.i.dcN, null);
      this.wey = ((TextView)this.nrp.findViewById(R.h.bPG));
      this.wez = ((TextView)this.nrp.findViewById(R.h.bPJ));
      this.weA = ((TextView)this.nrp.findViewById(R.h.bPE));
      this.weC = ((Button)this.nrp.findViewById(R.h.bPD));
      this.wez.setText(getString(R.l.ekv));
      this.weA.setText(getString(R.l.eks));
      this.weC.setText(getString(R.l.ekq, new Object[] { Integer.valueOf(0) }));
      this.weB = ((TextView)this.nrp.findViewById(R.h.cki));
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2826625351680L, 21060);
    int i = R.i.dcM;
    GMTrace.o(2826625351680L, 21060);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2825685827584L, 21053);
    super.onCreate(paramBundle);
    zd(R.l.eku);
    com.tencent.mm.plugin.c.a.imc.ox();
    this.weG = getIntent().getStringExtra("regsetinfo_ticket");
    this.iQr = getIntent().getIntExtra("login_type", 0);
    this.vcg = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.oTI = com.tencent.mm.plugin.c.b.OA();
    KD();
    GMTrace.o(2825685827584L, 21053);
  }
  
  public void onDestroy()
  {
    GMTrace.i(2826491133952L, 21059);
    if (this.hTN != null)
    {
      ap.vd().b(432, this.hTN);
      this.hTN = null;
    }
    if (this.wex != null)
    {
      j localj = this.wex;
      if (localj.hAM != null)
      {
        localj.hAM.detach();
        localj.hAM = null;
      }
    }
    af.Gg();
    super.onDestroy();
    GMTrace.o(2826491133952L, 21059);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2825820045312L, 21054);
    if (paramInt == 4)
    {
      aXL();
      GMTrace.o(2825820045312L, 21054);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2825820045312L, 21054);
    return bool;
  }
  
  public void onPause()
  {
    GMTrace.i(2826356916224L, 21058);
    super.onPause();
    if (this.iQr == 1)
    {
      com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",R300_400_QQ," + ap.ec("R300_400_QQ") + ",2");
      GMTrace.o(2826356916224L, 21058);
      return;
    }
    com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",R300_400_phone," + ap.ec("R300_400_phone") + ",2");
    GMTrace.o(2826356916224L, 21058);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    GMTrace.i(2826893787136L, 21062);
    v.i("MicroMsg.FindMContactInviteUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(2826893787136L, 21062);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bYI();
        GMTrace.o(2826893787136L, 21062);
        return;
      }
      this.oGy = false;
      g.a(this, getString(R.l.eFz), getString(R.l.eFE), getString(R.l.evo), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2806895345664L, 20913);
          FindMContactInviteUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
          FindMContactInviteUI.n(FindMContactInviteUI.this);
          FindMContactInviteUI.this.finish();
          GMTrace.o(2806895345664L, 20913);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2802197725184L, 20878);
          FindMContactInviteUI.n(FindMContactInviteUI.this);
          FindMContactInviteUI.this.finish();
          GMTrace.o(2802197725184L, 20878);
        }
      });
    }
  }
  
  protected void onResume()
  {
    GMTrace.i(2826088480768L, 21056);
    super.onResume();
    this.wex.notifyDataSetChanged();
    if (this.iQr == 1) {
      com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",R300_400_QQ," + ap.ec("R300_400_QQ") + ",1");
    }
    while (this.oGy)
    {
      boolean bool = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
      v.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP() });
      if (!bool)
      {
        GMTrace.o(2826088480768L, 21056);
        return;
        com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",R300_400_phone," + ap.ec("R300_400_phone") + ",1");
      }
      else
      {
        bYI();
      }
    }
    GMTrace.o(2826088480768L, 21056);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/friend/FindMContactInviteUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */