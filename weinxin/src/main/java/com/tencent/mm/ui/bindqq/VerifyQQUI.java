package com.tencent.mm.ui.bindqq;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.hh;
import com.tencent.mm.e.a.hh.b;
import com.tencent.mm.e.a.hi;
import com.tencent.mm.e.a.hi.a;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.c.gg;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class VerifyQQUI
  extends MMWizardActivity
  implements e
{
  private String fMB;
  private String fMD;
  private byte[] hqE;
  private p irp;
  private String rFU;
  private SecurityImage uSI;
  private long vtf;
  private String vtg;
  private String vth;
  
  public VerifyQQUI()
  {
    GMTrace.i(1895154319360L, 14120);
    this.irp = null;
    this.vtf = 0L;
    this.rFU = "";
    this.hqE = null;
    this.vtg = "";
    this.uSI = null;
    GMTrace.o(1895154319360L, 14120);
  }
  
  protected final void KD()
  {
    GMTrace.i(1895959625728L, 14126);
    final Object localObject = new hh();
    ((hh)localObject).fMz.context = this;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    this.fMB = ((hh)localObject).fMA.fMB;
    localObject = new hi();
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    this.fMD = ((hi)localObject).fMC.fMD;
    zd(R.l.dOz);
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(1893543706624L, 14108);
        VerifyQQUI.this.aGY();
        VerifyQQUI.a(VerifyQQUI.this);
        GMTrace.o(1893543706624L, 14108);
        return true;
      }
    });
    localObject = (EditText)findViewById(R.h.btq);
    final EditText localEditText = (EditText)findViewById(R.h.btp);
    a(0, getString(R.l.dHh), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(1893812142080L, 14110);
        paramAnonymousMenuItem = localObject.getText().toString().trim();
        VerifyQQUI.a(VerifyQQUI.this, localEditText.getText().toString().trim());
        try
        {
          VerifyQQUI.a(VerifyQQUI.this, Long.parseLong(paramAnonymousMenuItem));
          if (VerifyQQUI.b(VerifyQQUI.this) < 10000L)
          {
            com.tencent.mm.ui.base.g.h(VerifyQQUI.this.uRf.uRz, R.l.dOv, R.l.dOt);
            GMTrace.o(1893812142080L, 14110);
            return true;
          }
        }
        catch (Exception paramAnonymousMenuItem)
        {
          com.tencent.mm.ui.base.g.h(VerifyQQUI.this.uRf.uRz, R.l.dOv, R.l.dOt);
          GMTrace.o(1893812142080L, 14110);
          return true;
        }
        if (VerifyQQUI.c(VerifyQQUI.this).equals(""))
        {
          com.tencent.mm.ui.base.g.h(VerifyQQUI.this.uRf.uRz, R.l.dOu, R.l.dOt);
          GMTrace.o(1893812142080L, 14110);
          return true;
        }
        VerifyQQUI.this.aGY();
        paramAnonymousMenuItem = new com.tencent.mm.z.a(VerifyQQUI.b(VerifyQQUI.this), VerifyQQUI.c(VerifyQQUI.this), "", "", "", VerifyQQUI.d(VerifyQQUI.this), VerifyQQUI.e(VerifyQQUI.this), false);
        ap.vd().a(paramAnonymousMenuItem, 0);
        VerifyQQUI localVerifyQQUI = VerifyQQUI.this;
        ActionBarActivity localActionBarActivity = VerifyQQUI.this.uRf.uRz;
        VerifyQQUI.this.getString(R.l.dOx);
        VerifyQQUI.a(localVerifyQQUI, com.tencent.mm.ui.base.g.a(localActionBarActivity, VerifyQQUI.this.getString(R.l.dOo), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            GMTrace.i(1895020101632L, 14119);
            ap.vd().c(paramAnonymousMenuItem);
            GMTrace.o(1895020101632L, 14119);
          }
        }));
        GMTrace.o(1893812142080L, 14110);
        return true;
      }
    });
    GMTrace.o(1895959625728L, 14126);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(1896093843456L, 14127);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.VerifyQQUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.irp != null)
    {
      this.irp.dismiss();
      this.irp = null;
    }
    com.tencent.mm.z.a locala = (com.tencent.mm.z.a)paramk;
    byte[] arrayOfByte = ap.yV().R(locala.htM);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneBindQQ", "getRespImgBuf getWtloginMgr getVerifyImg:%d  uin:%d", new Object[] { Integer.valueOf(bf.i(arrayOfByte, new byte[0]).length), Long.valueOf(locala.htM) });
    if (bf.bm(arrayOfByte)) {
      arrayOfByte = com.tencent.mm.platformtools.n.a(((gg)locala.gUq.hrT.hsa).tdB);
    }
    for (;;)
    {
      this.hqE = arrayOfByte;
      this.vtg = ((gg)((com.tencent.mm.z.a)paramk).gUq.hrT.hsa).tip;
      if (this.hqE != null) {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VerifyQQUI", "imgSid:" + this.vtg + " img len" + this.hqE.length + " " + com.tencent.mm.compatible.util.g.sd());
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.c.a.imc.ou();
        com.tencent.mm.ui.base.g.a(this.uRf.uRz, R.l.dOw, R.l.dOx, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(1890993569792L, 14089);
            VerifyQQUI.f(VerifyQQUI.this);
            GMTrace.o(1890993569792L, 14089);
          }
        });
        GMTrace.o(1896093843456L, 14127);
        return;
      }
      int i;
      if (paramInt1 == 4) {
        switch (paramInt2)
        {
        default: 
          paramString = com.tencent.mm.f.a.dn(paramString);
          if (paramString != null)
          {
            paramString.a(this, null, null);
            i = 1;
          }
          break;
        }
      }
      while (i != 0)
      {
        GMTrace.o(1896093843456L, 14127);
        return;
        paramString = com.tencent.mm.f.a.dn(paramString);
        if (paramString != null)
        {
          paramString.a(this, null, null);
          i = 1;
        }
        else
        {
          com.tencent.mm.ui.base.g.h(this.uRf.uRz, R.l.dOy, R.l.dOt);
          i = 1;
          continue;
          com.tencent.mm.ui.base.g.h(this.uRf.uRz, R.l.dOp, R.l.dOt);
          i = 1;
          continue;
          com.tencent.mm.ui.base.g.h(this.uRf.uRz, R.l.dOs, R.l.dIG);
          i = 1;
          continue;
          com.tencent.mm.ui.base.g.h(this.uRf.uRz, R.l.dOq, R.l.dIG);
          i = 1;
          continue;
          com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VerifyQQUI", "imgSid:" + this.vtg + " img len" + this.hqE.length + " " + com.tencent.mm.compatible.util.g.sd());
          if (!ap.zb())
          {
            i = 1;
          }
          else
          {
            if (this.uSI == null) {
              this.uSI = SecurityImage.a.a(this.uRf.uRz, R.l.eJY, 0, this.hqE, this.vtg, this.vth, new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  GMTrace.i(1898912415744L, 14148);
                  paramAnonymousDialogInterface = new com.tencent.mm.z.a(VerifyQQUI.b(VerifyQQUI.this), VerifyQQUI.c(VerifyQQUI.this), VerifyQQUI.g(VerifyQQUI.this).uXf, VerifyQQUI.g(VerifyQQUI.this).bRp(), VerifyQQUI.g(VerifyQQUI.this).uXg, VerifyQQUI.d(VerifyQQUI.this), VerifyQQUI.e(VerifyQQUI.this), true);
                  ap.vd().a(paramAnonymousDialogInterface, 0);
                  VerifyQQUI localVerifyQQUI = VerifyQQUI.this;
                  ActionBarActivity localActionBarActivity = VerifyQQUI.this.uRf.uRz;
                  VerifyQQUI.this.getString(R.l.dOx);
                  VerifyQQUI.a(localVerifyQQUI, com.tencent.mm.ui.base.g.a(localActionBarActivity, VerifyQQUI.this.getString(R.l.dOo), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      GMTrace.i(1890188263424L, 14083);
                      ap.vd().c(paramAnonymousDialogInterface);
                      GMTrace.o(1890188263424L, 14083);
                    }
                  }));
                  GMTrace.o(1898912415744L, 14148);
                }
              }, null, new DialogInterface.OnDismissListener()new a
              {
                public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                {
                  GMTrace.i(1891262005248L, 14091);
                  VerifyQQUI.h(VerifyQQUI.this);
                  GMTrace.o(1891262005248L, 14091);
                }
              }, new a());
            }
            for (;;)
            {
              i = 1;
              break;
              com.tencent.mm.sdk.platformtools.v.d("MicroMsg.VerifyQQUI", "imgSid:" + this.vtg + " img len" + this.hqE.length + " " + com.tencent.mm.compatible.util.g.sd());
              this.uSI.a(0, this.hqE, this.vtg, this.vth);
            }
            com.tencent.mm.ui.base.g.h(this.uRf.uRz, R.l.dOr, R.l.dIG);
            i = 1;
            continue;
            i = 0;
          }
        }
      }
      Toast.makeText(this, getString(R.l.ekZ, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      GMTrace.o(1896093843456L, 14127);
      return;
    }
  }
  
  public final boolean byb()
  {
    GMTrace.i(1895825408000L, 14125);
    aGY();
    finish();
    GMTrace.o(1895825408000L, 14125);
    return true;
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(1895691190272L, 14124);
    int i = R.i.cVz;
    GMTrace.o(1895691190272L, 14124);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1895288537088L, 14121);
    super.onCreate(paramBundle);
    ap.vd().a(144, this);
    GMTrace.o(1895288537088L, 14121);
  }
  
  public void onDestroy()
  {
    GMTrace.i(1895422754816L, 14122);
    super.onDestroy();
    ap.vd().b(144, this);
    GMTrace.o(1895422754816L, 14122);
  }
  
  protected void onResume()
  {
    GMTrace.i(1895556972544L, 14123);
    super.onResume();
    KD();
    GMTrace.o(1895556972544L, 14123);
  }
  
  final class a
    extends SecurityImage.b
  {
    a()
    {
      GMTrace.i(1897972891648L, 14141);
      GMTrace.o(1897972891648L, 14141);
    }
    
    public final void bQy()
    {
      GMTrace.i(1898107109376L, 14142);
      com.tencent.mm.z.a locala = new com.tencent.mm.z.a(VerifyQQUI.b(VerifyQQUI.this), VerifyQQUI.c(VerifyQQUI.this), VerifyQQUI.i(VerifyQQUI.this), "", VerifyQQUI.j(VerifyQQUI.this), 2, true);
      ap.vd().a(locala, 0);
      GMTrace.o(1898107109376L, 14142);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindqq/VerifyQQUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */