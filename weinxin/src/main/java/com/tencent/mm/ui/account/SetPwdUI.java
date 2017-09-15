package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.azc;
import com.tencent.mm.protocal.c.dv;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.aq;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.l.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.io.IOException;

public abstract class SetPwdUI
  extends MMActivity
  implements e
{
  public String fGM;
  private ProgressDialog isb;
  public boolean pnV;
  private String uZU;
  private String uZV;
  public avt uZW;
  
  public SetPwdUI()
  {
    GMTrace.i(2760858664960L, 20570);
    this.isb = null;
    this.fGM = null;
    this.uZW = null;
    this.pnV = true;
    GMTrace.o(2760858664960L, 20570);
  }
  
  protected ProgressDialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    GMTrace.i(2761798189056L, 20577);
    paramContext = com.tencent.mm.ui.base.g.a(paramContext, paramString2, true, paramOnCancelListener);
    GMTrace.o(2761798189056L, 20577);
    return paramContext;
  }
  
  protected k a(String paramString1, String paramString2, avt paramavt)
  {
    GMTrace.i(2762066624512L, 20579);
    paramString1 = new af(paramString1, paramString2, paramavt);
    GMTrace.o(2762066624512L, 20579);
    return paramString1;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    SharedPreferences.Editor localEditor = null;
    GMTrace.i(2762200842240L, 20580);
    if (paramk.getType() != bQL())
    {
      GMTrace.o(2762200842240L, 20580);
      return;
    }
    if (this.isb != null)
    {
      this.isb.dismiss();
      this.isb = null;
    }
    if ((paramk.getType() == 383) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      Toast.makeText(this, getString(R.l.elQ), 0).show();
      af localaf = (af)paramk;
      paramk = localEditor;
      if (localaf.gUq != null)
      {
        paramk = localEditor;
        if (localaf.gUq.hrT.hsa != null) {
          paramk = (azc)localaf.gUq.hrT.hsa;
        }
      }
      if ((paramk != null) && (paramk.tfz != null))
      {
        paramk = paramk.tfz.tXD.toByteArray();
        localEditor = aa.getContext().getSharedPreferences("auth_info_key_prefs", 4).edit();
        localEditor.putBoolean("key_auth_info_prefs_created", true);
        localEditor.putInt("key_auth_update_version", d.sXh);
        localEditor.putString("_auth_key", bf.bo(paramk));
        ap.yY();
        localEditor.putInt("_auth_uin", c.uH());
        localEditor.commit();
      }
      setResult(-1);
    }
    if (s(paramInt1, paramInt2, paramString))
    {
      GMTrace.o(2762200842240L, 20580);
      return;
    }
    Toast.makeText(this, getString(R.l.elP, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    GMTrace.o(2762200842240L, 20580);
  }
  
  protected abstract String bQJ();
  
  protected abstract String bQK();
  
  protected int bQL()
  {
    GMTrace.i(2761932406784L, 20578);
    GMTrace.o(2761932406784L, 20578);
    return 383;
  }
  
  public boolean bQO()
  {
    GMTrace.i(2762469277696L, 20582);
    GMTrace.o(2762469277696L, 20582);
    return false;
  }
  
  public void onBackPressed()
  {
    GMTrace.i(2762603495424L, 20583);
    if (this.pnV)
    {
      if (bQO())
      {
        v.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
        com.tencent.mm.plugin.report.service.g.oSF.i(11868, new Object[] { Integer.valueOf(1) });
      }
      super.onBackPressed();
    }
    GMTrace.o(2762603495424L, 20583);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2760992882688L, 20571);
    ap.vd().a(bQL(), this);
    super.onCreate(paramBundle);
    this.fGM = getIntent().getStringExtra("setpwd_ticket");
    paramBundle = bf.PS(aq.ze().getString("_auth_key", ""));
    dv localdv = new dv();
    if (!bf.bm(paramBundle)) {}
    for (this.uZW = new avt().bb(paramBundle);; this.uZW = new avt().bb(new byte[0])) {
      try
      {
        localdv.aD(paramBundle);
        a(0, getString(R.l.dHh), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
          {
            GMTrace.i(2692944494592L, 20064);
            SetPwdUI.a(SetPwdUI.this, SetPwdUI.this.bQJ());
            SetPwdUI.b(SetPwdUI.this, SetPwdUI.this.bQK());
            if (bf.mA(SetPwdUI.a(SetPwdUI.this)))
            {
              GMTrace.o(2692944494592L, 20064);
              return true;
            }
            if (!SetPwdUI.a(SetPwdUI.this).equals(SetPwdUI.b(SetPwdUI.this)))
            {
              SetPwdUI.this.zw(SetPwdUI.a.uZZ);
              GMTrace.o(2692944494592L, 20064);
              return true;
            }
            if (SetPwdUI.a(SetPwdUI.this).length() > 16)
            {
              SetPwdUI.this.zw(SetPwdUI.a.vaa);
              GMTrace.o(2692944494592L, 20064);
              return true;
            }
            if (bf.PG(SetPwdUI.a(SetPwdUI.this)))
            {
              com.tencent.mm.ui.base.g.h(SetPwdUI.this, R.l.eJt, R.l.eJH);
              GMTrace.o(2692944494592L, 20064);
              return true;
            }
            if (!bf.PL(SetPwdUI.a(SetPwdUI.this)))
            {
              if ((SetPwdUI.a(SetPwdUI.this).length() >= 8) && (SetPwdUI.a(SetPwdUI.this).length() < 16)) {
                SetPwdUI.this.zw(SetPwdUI.a.vac);
              }
              for (;;)
              {
                GMTrace.o(2692944494592L, 20064);
                return true;
                SetPwdUI.this.zw(SetPwdUI.a.vab);
              }
            }
            SetPwdUI.this.aGY();
            if (bf.mA(SetPwdUI.this.fGM))
            {
              paramAnonymousMenuItem = SetPwdUI.this;
              ap.yY();
              paramAnonymousMenuItem.fGM = ((String)c.vr().get(77830, null));
            }
            paramAnonymousMenuItem = SetPwdUI.this.a(SetPwdUI.a(SetPwdUI.this), SetPwdUI.this.fGM, SetPwdUI.this.uZW);
            ap.vd().a(paramAnonymousMenuItem, 0);
            SetPwdUI.a(SetPwdUI.this, SetPwdUI.this.a(SetPwdUI.this, SetPwdUI.this.getString(R.l.dIG), SetPwdUI.this.getString(R.l.eIR), new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                GMTrace.i(2664892989440L, 19855);
                ap.vd().c(paramAnonymousMenuItem);
                GMTrace.o(2664892989440L, 19855);
              }
            }));
            if ((SetPwdUI.this.bQO()) && (!SetPwdUI.this.pnV))
            {
              v.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
              com.tencent.mm.plugin.report.service.g.oSF.i(11868, new Object[] { Integer.valueOf(0) });
            }
            GMTrace.o(2692944494592L, 20064);
            return true;
          }
        }, l.b.uSj);
        b(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            GMTrace.i(2706768920576L, 20167);
            if ((SetPwdUI.this.bQO()) && (SetPwdUI.this.pnV))
            {
              v.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
              com.tencent.mm.plugin.report.service.g.oSF.i(11868, new Object[] { Integer.valueOf(1) });
            }
            SetPwdUI.this.aGY();
            SetPwdUI.this.setResult(0);
            SetPwdUI.this.finish();
            GMTrace.o(2706768920576L, 20167);
            return true;
          }
        });
        GMTrace.o(2760992882688L, 20571);
        return;
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.SetPwdUI", paramBundle, "summersetpwd Failed parse autoauthkey buf", new Object[0]);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    GMTrace.i(2761127100416L, 20572);
    ap.vd().b(bQL(), this);
    super.onDestroy();
    GMTrace.o(2761127100416L, 20572);
  }
  
  protected final boolean p(int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(2762335059968L, 20581);
    if (a.imc.a(this.uRf.uRz, paramInt1, paramInt2, paramString))
    {
      GMTrace.o(2762335059968L, 20581);
      return true;
    }
    GMTrace.o(2762335059968L, 20581);
    return false;
  }
  
  protected abstract boolean s(int paramInt1, int paramInt2, String paramString);
  
  protected abstract void zw(int paramInt);
  
  protected static enum a
  {
    static
    {
      GMTrace.i(2654826659840L, 19780);
      uZZ = 1;
      vaa = 2;
      vab = 3;
      vac = 4;
      vad = new int[] { uZZ, vaa, vab, vac };
      GMTrace.o(2654826659840L, 19780);
    }
    
    public static int[] bQZ()
    {
      GMTrace.i(2654692442112L, 19779);
      int[] arrayOfInt = (int[])vad.clone();
      GMTrace.o(2654692442112L, 19779);
      return arrayOfInt;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/SetPwdUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */