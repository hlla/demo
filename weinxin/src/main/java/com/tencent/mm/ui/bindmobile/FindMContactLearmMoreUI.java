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
import com.tencent.mm.modelfriend.y;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.c.b;
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

public class FindMContactLearmMoreUI
  extends MMWizardActivity
{
  private String fOz;
  private List<String[]> hAI;
  private e hTN;
  private ProgressDialog isb;
  private String kuu;
  private String vcf;
  private int vcg;
  private TextView vsA;
  private y vsl;
  private Button vsz;
  
  public FindMContactLearmMoreUI()
  {
    GMTrace.i(3117475168256L, 23227);
    this.kuu = null;
    this.vcf = "";
    this.vcg = 2;
    this.hAI = null;
    this.hTN = null;
    this.isb = null;
    GMTrace.o(3117475168256L, 23227);
  }
  
  private void aXL()
  {
    GMTrace.i(3118548910080L, 23235);
    aGY();
    zp(1);
    GMTrace.o(3118548910080L, 23235);
  }
  
  private void bTa()
  {
    GMTrace.i(3118280474624L, 23233);
    boolean bool = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    v.i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP() });
    if (!bool)
    {
      GMTrace.o(3118280474624L, 23233);
      return;
    }
    Object localObject = ap.vd();
    e local3 = new e()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk)
      {
        GMTrace.i(3103248089088L, 23121);
        if (FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this) != null)
        {
          FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this).dismiss();
          FindMContactLearmMoreUI.d(FindMContactLearmMoreUI.this);
        }
        if (FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this) != null)
        {
          ap.vd().b(431, FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this));
          FindMContactLearmMoreUI.f(FindMContactLearmMoreUI.this);
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
            v.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this) == null) || (!FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label323;
            }
            b.mN("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactLearmMoreUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactLearmMoreUI.h(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactLearmMoreUI.i(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.w(FindMContactLearmMoreUI.this, paramAnonymousString);
            GMTrace.o(3103248089088L, 23121);
            return;
            paramAnonymousInt2 = 0;
            break;
          }
          label323:
          FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
          GMTrace.o(3103248089088L, 23121);
          return;
          Toast.makeText(FindMContactLearmMoreUI.this, FindMContactLearmMoreUI.this.getString(R.l.dGM, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }), 0).show();
          FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
          GMTrace.o(3103248089088L, 23121);
          return;
          label396:
          break;
          label399:
          paramAnonymousInt1 = 0;
          paramAnonymousInt2 = 0;
        }
      }
    };
    this.hTN = local3;
    ((n)localObject).a(431, local3);
    localObject = this.uRf.uRz;
    getString(R.l.dIG);
    this.isb = g.a((Context)localObject, getString(R.l.fnD), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(3139218440192L, 23389);
        if (FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this) != null)
        {
          ap.vd().b(431, FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this));
          FindMContactLearmMoreUI.f(FindMContactLearmMoreUI.this);
        }
        GMTrace.o(3139218440192L, 23389);
      }
    });
    ap.vL().a(new ae.a()
    {
      public final boolean Bn()
      {
        GMTrace.i(3104053395456L, 23127);
        for (;;)
        {
          try
          {
            FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this, com.tencent.mm.pluginsdk.a.dn(FindMContactLearmMoreUI.this));
            StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
            if (FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this) != null) {
              continue;
            }
            i = 0;
            v.d("MicroMsg.FindMContactLearmMoreUI", i);
          }
          catch (Exception localException)
          {
            int i;
            v.printErrStackTrace("MicroMsg.FindMContactLearmMoreUI", localException, "", new Object[0]);
            continue;
          }
          GMTrace.o(3104053395456L, 23127);
          return true;
          i = FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this).size();
        }
      }
      
      public final boolean Bo()
      {
        GMTrace.i(3103919177728L, 23126);
        if ((FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this) != null) && (FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this).size() != 0))
        {
          FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this, new y(FindMContactLearmMoreUI.h(FindMContactLearmMoreUI.this), FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this)));
          ap.vd().a(FindMContactLearmMoreUI.k(FindMContactLearmMoreUI.this), 0);
        }
        for (;;)
        {
          GMTrace.o(3103919177728L, 23126);
          return false;
          if (FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this) != null)
          {
            FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this).dismiss();
            FindMContactLearmMoreUI.d(FindMContactLearmMoreUI.this);
          }
          FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
        }
      }
      
      public final String toString()
      {
        GMTrace.i(3104187613184L, 23128);
        String str = super.toString() + "|doUpload";
        GMTrace.o(3104187613184L, 23128);
        return str;
      }
    });
    m.f(true, false);
    com.tencent.mm.modelfriend.a.EM();
    GMTrace.o(3118280474624L, 23233);
  }
  
  protected final void KD()
  {
    GMTrace.i(3118146256896L, 23232);
    zd(R.l.ekC);
    this.vsz = ((Button)findViewById(R.h.cpd));
    this.vsA = ((TextView)findViewById(R.h.bvD));
    this.vsz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(3138950004736L, 23387);
        ap.yY();
        c.vr().set(12322, Boolean.valueOf(true));
        m.f(true, false);
        FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this);
        GMTrace.o(3138950004736L, 23387);
      }
    });
    this.vsA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(3133715513344L, 23348);
        ap.yY();
        c.vr().set(12322, Boolean.valueOf(false));
        m.f(false, false);
        FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
        GMTrace.o(3133715513344L, 23348);
      }
    });
    ap.yY();
    c.vr().set(12323, Boolean.valueOf(true));
    ap.yY();
    this.fOz = ((String)c.vr().get(6, null));
    if ((this.fOz == null) || (this.fOz.equals("")))
    {
      ap.yY();
      this.fOz = ((String)c.vr().get(4097, null));
    }
    GMTrace.o(3118146256896L, 23232);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(3118683127808L, 23236);
    int i = R.i.dcQ;
    GMTrace.o(3118683127808L, 23236);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3117609385984L, 23228);
    super.onCreate(paramBundle);
    this.kuu = getIntent().getStringExtra("regsetinfo_ticket");
    this.vcf = getIntent().getStringExtra("regsetinfo_NextStep");
    this.vcg = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    KD();
    GMTrace.o(3117609385984L, 23228);
  }
  
  public void onDestroy()
  {
    GMTrace.i(3117743603712L, 23229);
    if (this.hTN != null)
    {
      ap.vd().b(431, this.hTN);
      this.hTN = null;
    }
    super.onDestroy();
    GMTrace.o(3117743603712L, 23229);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(3118414692352L, 23234);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aXL();
      GMTrace.o(3118414692352L, 23234);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(3118414692352L, 23234);
    return bool;
  }
  
  protected void onPause()
  {
    GMTrace.i(3118012039168L, 23231);
    super.onPause();
    b.b(false, ap.uY() + "," + getClass().getName() + ",RE300_600," + ap.ec("RE300_600") + ",2");
    GMTrace.o(3118012039168L, 23231);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    GMTrace.i(3118817345536L, 23237);
    v.i("MicroMsg.FindMContactLearmMoreUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(3118817345536L, 23237);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bTa();
        GMTrace.o(3118817345536L, 23237);
        return;
      }
      g.a(this, getString(R.l.eFz), getString(R.l.eFE), getString(R.l.evo), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3110495846400L, 23175);
          paramAnonymousDialogInterface.dismiss();
          FindMContactLearmMoreUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
          GMTrace.o(3110495846400L, 23175);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3125528231936L, 23287);
          paramAnonymousDialogInterface.dismiss();
          GMTrace.o(3125528231936L, 23287);
        }
      });
    }
  }
  
  protected void onResume()
  {
    GMTrace.i(3117877821440L, 23230);
    super.onResume();
    b.mM("R300_100_phone");
    b.b(true, ap.uY() + "," + getClass().getName() + ",RE300_600," + ap.ec("RE300_600") + ",1");
    GMTrace.o(3117877821440L, 23230);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindmobile/FindMContactLearmMoreUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */