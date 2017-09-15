package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.e.a.il;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.g.a.b;
import com.tencent.mm.ui.g.a.c.a;
import com.tencent.mm.ui.g.a.d;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.HashMap;
import java.util.Map;

public class FacebookAuthUI
  extends MMPreference
  implements e
{
  public static final String[] uVN;
  private f isp;
  private final Map<String, Preference> jVf;
  private DialogInterface.OnCancelListener jqB;
  private boolean uVO;
  private boolean uVP;
  private com.tencent.mm.sdk.b.c uVQ;
  private com.tencent.mm.ui.g.a.c uVu;
  private ProgressDialog uVv;
  private com.tencent.mm.modelsimple.g uVw;
  
  static
  {
    GMTrace.i(2748510633984L, 20478);
    uVN = new String[] { "publish_actions", "email" };
    GMTrace.o(2748510633984L, 20478);
  }
  
  public FacebookAuthUI()
  {
    GMTrace.i(2745960497152L, 20459);
    this.uVO = false;
    this.uVP = false;
    this.jVf = new HashMap();
    this.uVQ = new com.tencent.mm.sdk.b.c() {};
    GMTrace.o(2745960497152L, 20459);
  }
  
  private void bQA()
  {
    GMTrace.i(2746900021248L, 20466);
    this.isp.removeAll();
    boolean bool;
    Preference localPreference;
    if (this.uVO)
    {
      bool = false;
      if (this.jVf.containsKey("facebook_auth_tip"))
      {
        localPreference = (Preference)this.jVf.get("facebook_auth_tip");
        if (!bool) {
          break label178;
        }
      }
    }
    label178:
    for (int i = R.l.egU;; i = R.l.egO)
    {
      localPreference.setTitle(i);
      this.isp.a(localPreference);
      if (this.jVf.containsKey("facebook_auth_cat"))
      {
        localPreference = (Preference)this.jVf.get("facebook_auth_cat");
        this.isp.a(localPreference);
      }
      if (bool) {
        break label185;
      }
      if (!this.jVf.containsKey("facebook_auth_bind_btn")) {
        break label346;
      }
      localPreference = (Preference)this.jVf.get("facebook_auth_bind_btn");
      this.isp.a(localPreference);
      GMTrace.o(2746900021248L, 20466);
      return;
      bool = com.tencent.mm.u.m.ym();
      break;
    }
    label185:
    if (this.jVf.containsKey("facebook_auth_account"))
    {
      localPreference = (Preference)this.jVf.get("facebook_auth_account");
      StringBuilder localStringBuilder = new StringBuilder().append(getString(R.l.egQ));
      ap.yY();
      localPreference.setTitle(com.tencent.mm.u.c.vr().get(65826, null));
      this.isp.a(localPreference);
    }
    if (this.jVf.containsKey("facebook_auth_cat2"))
    {
      localPreference = (Preference)this.jVf.get("facebook_auth_cat2");
      this.isp.a(localPreference);
    }
    if (this.jVf.containsKey("facebook_auth_unbind_btn"))
    {
      localPreference = (Preference)this.jVf.get("facebook_auth_unbind_btn");
      this.isp.a(localPreference);
    }
    label346:
    GMTrace.o(2746900021248L, 20466);
  }
  
  protected final void KD()
  {
    GMTrace.i(2746631585792L, 20464);
    this.uVO = getIntent().getBooleanExtra("is_force_unbind", false);
    this.uVu = new com.tencent.mm.ui.g.a.c("290293790992170");
    this.jqB = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(2566914048000L, 19125);
        if (FacebookAuthUI.a(FacebookAuthUI.this) != null) {
          ap.vd().c(FacebookAuthUI.a(FacebookAuthUI.this));
        }
        GMTrace.o(2566914048000L, 19125);
      }
    };
    this.isp.addPreferencesFromResource(R.o.ftB);
    Preference localPreference = this.isp.Tc("facebook_auth_tip");
    if (localPreference != null) {
      this.jVf.put("facebook_auth_tip", localPreference);
    }
    localPreference = this.isp.Tc("facebook_auth_cat");
    if (localPreference != null) {
      this.jVf.put("facebook_auth_cat", localPreference);
    }
    localPreference = this.isp.Tc("facebook_auth_bind_btn");
    if (localPreference != null) {
      this.jVf.put("facebook_auth_bind_btn", localPreference);
    }
    localPreference = this.isp.Tc("facebook_auth_account");
    if (localPreference != null) {
      this.jVf.put("facebook_auth_account", localPreference);
    }
    localPreference = this.isp.Tc("facebook_auth_cat2");
    if (localPreference != null) {
      this.jVf.put("facebook_auth_cat2", localPreference);
    }
    localPreference = this.isp.Tc("facebook_auth_unbind_btn");
    if (localPreference != null) {
      this.jVf.put("facebook_auth_unbind_btn", localPreference);
    }
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2653618700288L, 19771);
        paramAnonymousMenuItem = FacebookAuthUI.this.getIntent();
        paramAnonymousMenuItem.putExtra("bind_facebook_succ", FacebookAuthUI.b(FacebookAuthUI.this));
        FacebookAuthUI.this.setResult(-1, paramAnonymousMenuItem);
        FacebookAuthUI.this.finish();
        GMTrace.o(2653618700288L, 19771);
        return true;
      }
    });
    GMTrace.o(2746631585792L, 20464);
  }
  
  public final int OO()
  {
    GMTrace.i(2746497368064L, 20463);
    int i = R.o.ftB;
    GMTrace.o(2746497368064L, 20463);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2747168456704L, 20468);
    if (paramk.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.uVw = new com.tencent.mm.modelsimple.g(0, "");
        ap.vd().a(this.uVw, 0);
        GMTrace.o(2747168456704L, 20468);
        return;
      }
      if (this.uVv != null) {
        this.uVv.dismiss();
      }
      if (paramInt2 == -82)
      {
        com.tencent.mm.ui.base.g.a(this, R.l.eRA, R.l.dIG, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2753342472192L, 20514);
            GMTrace.o(2753342472192L, 20514);
          }
        });
        GMTrace.o(2747168456704L, 20468);
        return;
      }
      if (paramInt2 == -83)
      {
        com.tencent.mm.ui.base.g.a(this, R.l.eRx, R.l.dIG, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2685830955008L, 20011);
            GMTrace.o(2685830955008L, 20011);
          }
        });
        GMTrace.o(2747168456704L, 20468);
        return;
      }
      if (paramInt2 == -84)
      {
        com.tencent.mm.ui.base.g.a(this, R.l.eRy, R.l.dIG, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2675227754496L, 19932);
            GMTrace.o(2675227754496L, 19932);
          }
        });
        GMTrace.o(2747168456704L, 20468);
        return;
      }
      if (paramInt2 == -85)
      {
        com.tencent.mm.ui.base.g.a(this, R.l.eRw, R.l.dIG, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2553358057472L, 19024);
            GMTrace.o(2553358057472L, 19024);
          }
        });
        GMTrace.o(2747168456704L, 20468);
        return;
      }
      if (paramInt2 == -86)
      {
        com.tencent.mm.ui.base.g.a(this, R.l.eRB, R.l.dIG, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2785286291456L, 20752);
            GMTrace.o(2785286291456L, 20752);
          }
        });
        GMTrace.o(2747168456704L, 20468);
        return;
      }
      if (paramInt2 == -106)
      {
        com.tencent.mm.platformtools.m.E(this, paramString);
        GMTrace.o(2747168456704L, 20468);
        return;
      }
      if (paramInt2 == 65319)
      {
        com.tencent.mm.platformtools.m.a(this, com.tencent.mm.pluginsdk.a.a.a((u)paramk), paramInt2);
        GMTrace.o(2747168456704L, 20468);
        return;
      }
      paramString = com.tencent.mm.f.a.dn(paramString);
      if (paramString != null)
      {
        paramString.a(this, null, null);
        GMTrace.o(2747168456704L, 20468);
        return;
      }
      GMTrace.o(2747168456704L, 20468);
      return;
    }
    if (paramk.getType() == 183)
    {
      if (this.uVv != null) {
        this.uVv.dismiss();
      }
      int i = ((com.tencent.mm.modelsimple.g)paramk).opType;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 0) {}
        for (paramInt1 = R.l.dXX;; paramInt1 = R.l.dXU)
        {
          Toast.makeText(this, paramInt1, 1).show();
          this.uVO = false;
          bQA();
          if (i == 1)
          {
            ap.yY();
            com.tencent.mm.u.c.wW().Rk("facebookapp");
            ap.yY();
            com.tencent.mm.u.c.wT().Am("facebookapp");
            this.uVP = true;
          }
          GMTrace.o(2747168456704L, 20468);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -67))
      {
        Toast.makeText(this, R.l.egR, 1).show();
        GMTrace.o(2747168456704L, 20468);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 == -5))
      {
        if (i == 1) {}
        for (paramInt1 = R.l.egN;; paramInt1 = R.l.egS)
        {
          Toast.makeText(this, paramInt1, 1).show();
          GMTrace.o(2747168456704L, 20468);
          return;
        }
      }
      if (paramInt2 == -106)
      {
        com.tencent.mm.platformtools.m.E(this, paramString);
        GMTrace.o(2747168456704L, 20468);
        return;
      }
      paramString = com.tencent.mm.f.a.dn(paramString);
      if (paramString != null)
      {
        paramString.a(this, null, null);
        GMTrace.o(2747168456704L, 20468);
        return;
      }
      if (i != 0) {
        break label626;
      }
    }
    label626:
    for (paramInt1 = R.l.dXW;; paramInt1 = R.l.dXT)
    {
      Toast.makeText(this, paramInt1, 1).show();
      GMTrace.o(2747168456704L, 20468);
      return;
    }
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    GMTrace.i(2746765803520L, 20465);
    paramf = paramPreference.igr;
    if (paramf == null)
    {
      v.e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
      GMTrace.o(2746765803520L, 20465);
      return true;
    }
    if (paramf.equals("facebook_auth_bind_btn")) {
      try
      {
        this.uVu.fb(this);
        this.uVu = new com.tencent.mm.ui.g.a.c("290293790992170");
        this.uVu.a(this, uVN, new a());
        GMTrace.o(2746765803520L, 20465);
        return true;
      }
      catch (Exception paramf)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.FacebookAuthUI", paramf, "", new Object[0]);
        }
      }
    }
    if (paramf.equals("facebook_auth_unbind_btn"))
    {
      com.tencent.mm.ui.base.g.a(this, R.l.egT, R.l.dIG, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2773475131392L, 20664);
          paramAnonymousDialogInterface = FacebookAuthUI.this.getString(R.l.dIG);
          String str = FacebookAuthUI.this.getString(R.l.egV);
          FacebookAuthUI.a(FacebookAuthUI.this, ProgressDialog.show(FacebookAuthUI.this, paramAnonymousDialogInterface, str, true));
          FacebookAuthUI.d(FacebookAuthUI.this).setOnCancelListener(FacebookAuthUI.c(FacebookAuthUI.this));
          paramAnonymousDialogInterface = new h(h.hRt);
          ap.vd().a(paramAnonymousDialogInterface, 0);
          GMTrace.o(2773475131392L, 20664);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2743007707136L, 20437);
          GMTrace.o(2743007707136L, 20437);
        }
      });
      GMTrace.o(2746765803520L, 20465);
      return true;
    }
    GMTrace.o(2746765803520L, 20465);
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(2747034238976L, 20467);
    boolean bool;
    if (paramIntent == null) {
      bool = true;
    }
    for (;;)
    {
      v.i("MicroMsg.FacebookAuthUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 == -1) && (paramInt1 == 1024) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
        int j = paramIntent.getIntExtra("KVoiceHelpCode", 0);
        bool = bf.mA(str);
        int i;
        if (bf.mA(str))
        {
          i = 0;
          v.i("MicroMsg.FacebookAuthUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
          if (j != 65319) {}
        }
        else
        {
          try
          {
            this.uVu.fb(this);
            this.uVu = new com.tencent.mm.ui.g.a.c("290293790992170");
            this.uVu.a(this, uVN, new a());
            GMTrace.o(2747034238976L, 20467);
            return;
            bool = false;
            continue;
            i = str.length();
          }
          catch (Exception paramIntent)
          {
            for (;;)
            {
              v.printErrStackTrace("MicroMsg.FacebookAuthUI", paramIntent, "", new Object[0]);
            }
          }
        }
      }
    }
    this.uVu.e(paramInt1, paramInt2, paramIntent);
    GMTrace.o(2747034238976L, 20467);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2746094714880L, 20460);
    super.onCreate(paramBundle);
    this.isp = this.vpG;
    KD();
    GMTrace.o(2746094714880L, 20460);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2747302674432L, 20469);
    if (paramInt == 4)
    {
      Intent localIntent = getIntent();
      localIntent.putExtra("bind_facebook_succ", this.uVP);
      setResult(-1, localIntent);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2747302674432L, 20469);
    return bool;
  }
  
  protected void onPause()
  {
    GMTrace.i(2746363150336L, 20462);
    super.onPause();
    com.tencent.mm.sdk.b.a.uql.c(this.uVQ);
    ap.vd().b(183, this);
    ap.vd().b(254, this);
    GMTrace.o(2746363150336L, 20462);
  }
  
  protected void onResume()
  {
    GMTrace.i(2746228932608L, 20461);
    com.tencent.mm.sdk.b.a.uql.b(this.uVQ);
    super.onResume();
    ap.vd().a(183, this);
    ap.vd().a(254, this);
    bQA();
    GMTrace.o(2746228932608L, 20461);
  }
  
  private final class a
    implements c.a
  {
    public a()
    {
      GMTrace.i(2758442745856L, 20552);
      GMTrace.o(2758442745856L, 20552);
    }
    
    public final void a(b paramb)
    {
      GMTrace.i(2758845399040L, 20555);
      v.d("MicroMsg.FacebookAuthUI", "onError:" + paramb.getMessage());
      com.tencent.mm.ui.base.g.b(FacebookAuthUI.this, paramb.getMessage(), FacebookAuthUI.this.getString(R.l.dXT), true);
      FacebookAuthUI.kz(false);
      com.tencent.mm.plugin.report.service.g.oSF.a(582L, 3L, 1L, false);
      GMTrace.o(2758845399040L, 20555);
    }
    
    public final void a(d paramd)
    {
      GMTrace.i(2758711181312L, 20554);
      v.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + paramd.wek);
      com.tencent.mm.ui.base.g.b(FacebookAuthUI.this, paramd.getMessage(), FacebookAuthUI.this.getString(R.l.dXT), true);
      FacebookAuthUI.kz(false);
      com.tencent.mm.plugin.report.service.g.oSF.a(582L, 2L, 1L, false);
      GMTrace.o(2758711181312L, 20554);
    }
    
    public final void m(Bundle paramBundle)
    {
      GMTrace.i(2758576963584L, 20553);
      v.d("MicroMsg.FacebookAuthUI", "token:" + FacebookAuthUI.e(FacebookAuthUI.this).vqP);
      ap.yY();
      com.tencent.mm.u.c.vr().set(65830, FacebookAuthUI.e(FacebookAuthUI.this).vqP);
      if (FacebookAuthUI.e(FacebookAuthUI.this).wed != 0L)
      {
        ap.yY();
        com.tencent.mm.u.c.vr().set(65832, Long.valueOf(FacebookAuthUI.e(FacebookAuthUI.this).wed));
      }
      paramBundle = FacebookAuthUI.this.getString(R.l.dIG);
      String str = FacebookAuthUI.this.getString(R.l.egP);
      FacebookAuthUI.a(FacebookAuthUI.this, ProgressDialog.show(FacebookAuthUI.this, paramBundle, str, true));
      FacebookAuthUI.d(FacebookAuthUI.this).setOnCancelListener(FacebookAuthUI.c(FacebookAuthUI.this));
      FacebookAuthUI.a(FacebookAuthUI.this, new com.tencent.mm.modelsimple.g(1, FacebookAuthUI.e(FacebookAuthUI.this).vqP));
      ap.vd().a(FacebookAuthUI.a(FacebookAuthUI.this), 0);
      FacebookAuthUI.kz(true);
      com.tencent.mm.plugin.report.service.g.oSF.a(582L, 1L, 1L, false);
      GMTrace.o(2758576963584L, 20553);
    }
    
    public final void onCancel()
    {
      GMTrace.i(2758979616768L, 20556);
      v.d("MicroMsg.FacebookAuthUI", "onCancel");
      FacebookAuthUI.kz(false);
      com.tencent.mm.plugin.report.service.g.oSF.a(582L, 4L, 1L, false);
      GMTrace.o(2758979616768L, 20556);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/FacebookAuthUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */