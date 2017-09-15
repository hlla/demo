package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.g.a.c.a;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public class FacebookLoginUI
  extends MMPreference
  implements com.tencent.mm.y.e
{
  private String fWO;
  private DialogInterface.OnCancelListener jqB;
  private String oTI;
  private com.tencent.mm.sdk.b.c uVQ;
  private com.tencent.mm.ui.g.a.c uVZ;
  private ProgressDialog uVv;
  private String uWa;
  private u uWb;
  private b uWc;
  boolean uWd;
  
  public FacebookLoginUI()
  {
    GMTrace.i(2693615583232L, 20069);
    this.uWa = "";
    this.fWO = "";
    this.uVQ = new com.tencent.mm.sdk.b.c() {};
    this.uWd = true;
    GMTrace.o(2693615583232L, 20069);
  }
  
  private void bQB()
  {
    GMTrace.i(2694555107328L, 20076);
    try
    {
      if (this.uVZ != null) {
        this.uVZ.fb(this);
      }
      com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",L14," + ap.ec("L14") + ",1");
      this.uVZ = new com.tencent.mm.ui.g.a.c("290293790992170");
      this.uVZ.a(this, FacebookAuthUI.uVN, new a());
      com.tencent.mm.plugin.report.service.g.oSF.a(582L, 5L, 1L, false);
      GMTrace.o(2694555107328L, 20076);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.FacebookLoginUI", localException, "", new Object[0]);
      }
    }
  }
  
  private void goBack()
  {
    GMTrace.i(2694420889600L, 20075);
    com.tencent.mm.plugin.c.b.mN(this.oTI);
    finish();
    GMTrace.o(2694420889600L, 20075);
  }
  
  protected final void KD()
  {
    GMTrace.i(2694823542784L, 20078);
    this.uVZ = new com.tencent.mm.ui.g.a.c("290293790992170");
    this.jqB = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(2710258581504L, 20193);
        if (FacebookLoginUI.b(FacebookLoginUI.this) != null) {
          ap.vd().c(FacebookLoginUI.b(FacebookLoginUI.this));
        }
        GMTrace.o(2710258581504L, 20193);
      }
    };
    bQB();
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2683146600448L, 19991);
        FacebookLoginUI.c(FacebookLoginUI.this);
        GMTrace.o(2683146600448L, 19991);
        return true;
      }
    });
    GMTrace.o(2694823542784L, 20078);
  }
  
  public final int OO()
  {
    GMTrace.i(2695091978240L, 20080);
    int i = R.o.ftC;
    GMTrace.o(2695091978240L, 20080);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2694689325056L, 20077);
    v.i("MicroMsg.FacebookLoginUI", "dkwt onSceneEnd: hash:%d type:%d [%d,%d,%s]", new Object[] { Integer.valueOf(paramk.hashCode()), Integer.valueOf(paramk.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.uVv != null)
    {
      this.uVv.dismiss();
      this.uVv = null;
    }
    if (!bf.bp(this))
    {
      GMTrace.o(2694689325056L, 20077);
      return;
    }
    if (!(paramk instanceof u))
    {
      GMTrace.o(2694689325056L, 20077);
      return;
    }
    this.fWO = ((u)paramk).Ji();
    int j = 0;
    int i = j;
    if (paramk.getType() == 701)
    {
      i = j;
      if (paramInt1 == 4) {
        if (paramInt2 != -16)
        {
          i = j;
          if (paramInt2 != -17) {}
        }
        else
        {
          i = 1;
          ap.vd().a(new bb(new bb.a()
          {
            public final void a(com.tencent.mm.network.e paramAnonymouse)
            {
              GMTrace.i(2709721710592L, 20189);
              if (paramAnonymouse == null)
              {
                GMTrace.o(2709721710592L, 20189);
                return;
              }
              paramAnonymouse = paramAnonymouse.Cc();
              ap.yY();
              int i = com.tencent.mm.u.c.uH();
              paramAnonymouse.i(new byte[0], i);
              GMTrace.o(2709721710592L, 20189);
            }
          }), 0);
        }
      }
    }
    if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
    {
      ap.unhold();
      m.mv("");
      com.tencent.mm.modelsimple.d.bc(this);
      m.a(this, new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2725290967040L, 20305);
          ap.yY();
          int i;
          Intent localIntent1;
          if (bf.a((Integer)com.tencent.mm.u.c.vr().get(65833, null), 0) > 0)
          {
            i = 1;
            if (i == 0) {
              break label117;
            }
            localIntent1 = com.tencent.mm.plugin.c.a.imb.ak(FacebookLoginUI.this);
            localIntent1.addFlags(67108864);
            Intent localIntent2 = new Intent(FacebookLoginUI.this.uRf.uRz, BindMContactIntroUI.class);
            localIntent2.putExtra("key_upload_scene", 1);
            MMWizardActivity.b(FacebookLoginUI.this, localIntent2, localIntent1);
          }
          for (;;)
          {
            FacebookLoginUI.this.finish();
            GMTrace.o(2725290967040L, 20305);
            return;
            i = 0;
            break;
            label117:
            localIntent1 = com.tencent.mm.plugin.c.a.imb.ak(FacebookLoginUI.this);
            localIntent1.addFlags(67108864);
            FacebookLoginUI.this.startActivity(localIntent1);
            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + FacebookLoginUI.this.getClass().getName() + ",L14," + ap.ec("L14") + ",4");
          }
        }
      }, false, 2);
      GMTrace.o(2694689325056L, 20077);
      return;
    }
    if (paramInt2 == -106)
    {
      m.E(this, paramString);
      GMTrace.o(2694689325056L, 20077);
      return;
    }
    if (paramInt2 == 65319)
    {
      m.a(this, com.tencent.mm.pluginsdk.a.a.a((u)paramk), paramInt2);
      GMTrace.o(2694689325056L, 20077);
      return;
    }
    Object localObject;
    if ((paramInt2 == -6) || (paramInt2 == 65225) || (paramInt2 == 65226))
    {
      if (this.uWc == null) {
        this.uWc = new b()
        {
          public final k a(k paramAnonymousk, String paramAnonymousString)
          {
            GMTrace.i(2696836808704L, 20093);
            paramAnonymousk = new u("facebook@wechat_auth", FacebookLoginUI.a(FacebookLoginUI.this), ((u)paramAnonymousk).Jj(), paramAnonymousString, ((u)paramAnonymousk).FK(), ((u)paramAnonymousk).Jk(), 0, "", true, false);
            GMTrace.o(2696836808704L, 20093);
            return paramAnonymousk;
          }
        };
      }
      paramString = this.uWc;
      localObject = ((u)paramk).FJ();
      paramString.uVo = paramk;
      if (paramString.uSI == null)
      {
        paramString.uSI = SecurityImage.a.a(this, R.l.eJY, 0, (byte[])localObject, "", "", new b.1(paramString, this), null, new b.2(paramString), paramString);
        GMTrace.o(2694689325056L, 20077);
        return;
      }
      paramString.uSI.a(0, (byte[])localObject, "", "");
      GMTrace.o(2694689325056L, 20077);
      return;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (com.tencent.mm.plugin.c.a.imc.a(this.uRf.uRz, paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      break;
    }
    while (i != 0)
    {
      GMTrace.o(2694689325056L, 20077);
      return;
      if (ap.vd().BR() == 5)
      {
        com.tencent.mm.ui.base.g.h(this, R.l.eDh, R.l.eDg);
        i = 1;
      }
      else
      {
        com.tencent.mm.ui.base.g.h(this, R.l.eeU, R.l.ewF);
        i = 1;
        continue;
        com.tencent.mm.ui.base.g.h(this, R.l.ewE, R.l.ewF);
        i = 1;
        continue;
        com.tencent.mm.ui.base.g.h(this.uRf.uRz, R.l.eJR, R.l.dIG);
        i = 1;
        continue;
        m.bo(this.uRf.uRz);
        i = 1;
        continue;
        com.tencent.mm.ui.base.g.h(this.uRf.uRz, R.l.ehf, R.l.dIG);
        i = 1;
        continue;
        com.tencent.mm.ui.base.g.h(this.uRf.uRz, R.l.ehg, R.l.dIG);
        i = 1;
        continue;
        if (com.tencent.mm.protocal.d.sXk)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", this.fWO);
          ((Intent)localObject).putExtra("showShare", false);
          ((Intent)localObject).putExtra("show_bottom", false);
          ((Intent)localObject).putExtra("needRedirect", false);
          ((Intent)localObject).putExtra("neverGetA8Key", true);
          ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
          ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
          com.tencent.mm.plugin.c.a.imb.j((Intent)localObject, this);
        }
        i = 1;
        continue;
        i = 0;
      }
    }
    if (paramk.getType() == 701)
    {
      paramString = com.tencent.mm.f.a.dn(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        GMTrace.o(2694689325056L, 20077);
        return;
      }
    }
    Toast.makeText(this, getString(R.l.ekZ, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    GMTrace.o(2694689325056L, 20077);
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    GMTrace.i(2695226195968L, 20081);
    paramf = paramPreference.igr;
    if (paramf == null)
    {
      v.e("MicroMsg.FacebookLoginUI", "onPreferenceTreeClick, key is null");
      GMTrace.o(2695226195968L, 20081);
      return true;
    }
    if (paramf.equals("facebook_auth_bind_btn"))
    {
      bQB();
      GMTrace.o(2695226195968L, 20081);
      return true;
    }
    GMTrace.o(2695226195968L, 20081);
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    GMTrace.i(2694957760512L, 20079);
    boolean bool;
    String str;
    int j;
    if (paramIntent == null)
    {
      bool = true;
      v.i("MicroMsg.FacebookLoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label177;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      j = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bf.mA(str);
      if (!bf.mA(str)) {
        break label167;
      }
    }
    for (;;)
    {
      v.i("MicroMsg.FacebookLoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if (j != 65319) {
        break label177;
      }
      bQB();
      GMTrace.o(2694957760512L, 20079);
      return;
      bool = false;
      break;
      label167:
      i = str.length();
    }
    label177:
    this.uVZ.e(paramInt1, paramInt2, paramIntent);
    GMTrace.o(2694957760512L, 20079);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2693749800960L, 20070);
    super.onCreate(paramBundle);
    zd(R.l.bpC);
    com.tencent.mm.plugin.c.a.imc.ox();
    this.oTI = com.tencent.mm.plugin.c.b.OA();
    KD();
    ap.vd().a(701, this);
    GMTrace.o(2693749800960L, 20070);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(2693884018688L, 20071);
    super.onDestroy();
    ap.vd().b(701, this);
    GMTrace.o(2693884018688L, 20071);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2694286671872L, 20074);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      GMTrace.o(2694286671872L, 20074);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2694286671872L, 20074);
    return bool;
  }
  
  public void onPause()
  {
    GMTrace.i(2694152454144L, 20073);
    super.onPause();
    com.tencent.mm.sdk.b.a.uql.c(this.uVQ);
    com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",L100_200_FB," + ap.ec("L100_200_FB") + ",2");
    GMTrace.o(2694152454144L, 20073);
  }
  
  protected void onResume()
  {
    GMTrace.i(2694018236416L, 20072);
    com.tencent.mm.sdk.b.a.uql.b(this.uVQ);
    super.onResume();
    com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",L100_200_FB," + ap.ec("L100_200_FB") + ",1");
    com.tencent.mm.plugin.c.b.mM("L100_200_FB");
    GMTrace.o(2694018236416L, 20072);
  }
  
  private final class a
    implements c.a
  {
    public a()
    {
      GMTrace.i(2737907433472L, 20399);
      GMTrace.o(2737907433472L, 20399);
    }
    
    public final void a(com.tencent.mm.ui.g.a.b paramb)
    {
      GMTrace.i(2738310086656L, 20402);
      v.d("MicroMsg.FacebookLoginUI", "onError:" + paramb.getMessage());
      com.tencent.mm.ui.base.g.b(FacebookLoginUI.this, paramb.getMessage(), FacebookLoginUI.this.getString(R.l.dXT), true);
      FacebookLoginUI.kA(false);
      com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + FacebookLoginUI.this.getClass().getName() + ",L14," + ap.ec("L14") + ",2");
      com.tencent.mm.plugin.report.service.g.oSF.a(582L, 8L, 1L, false);
      GMTrace.o(2738310086656L, 20402);
    }
    
    public final void a(com.tencent.mm.ui.g.a.d paramd)
    {
      GMTrace.i(2738175868928L, 20401);
      v.d("MicroMsg.FacebookLoginUI", "onFacebookError:" + paramd.wek);
      com.tencent.mm.ui.base.g.b(FacebookLoginUI.this, paramd.getMessage(), FacebookLoginUI.this.getString(R.l.dXT), true);
      FacebookLoginUI.kA(false);
      com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + FacebookLoginUI.this.getClass().getName() + ",L14," + ap.ec("L14") + ",2");
      com.tencent.mm.plugin.report.service.g.oSF.a(582L, 7L, 1L, false);
      GMTrace.o(2738175868928L, 20401);
    }
    
    public final void m(Bundle paramBundle)
    {
      GMTrace.i(2738041651200L, 20400);
      paramBundle = FacebookLoginUI.this.getString(R.l.dIG);
      String str = FacebookLoginUI.this.getString(R.l.egP);
      FacebookLoginUI.a(FacebookLoginUI.this, ProgressDialog.show(FacebookLoginUI.this, paramBundle, str, true));
      FacebookLoginUI.e(FacebookLoginUI.this).setOnCancelListener(FacebookLoginUI.d(FacebookLoginUI.this));
      FacebookLoginUI.a(FacebookLoginUI.this, FacebookLoginUI.f(FacebookLoginUI.this).vqP);
      v.i("MicroMsg.FacebookLoginUI", "dkwt Ready to Facebook auth user[%s] token[%d][%s]", new Object[] { "facebook@wechat_auth", Integer.valueOf(FacebookLoginUI.a(FacebookLoginUI.this).length()), FacebookLoginUI.a(FacebookLoginUI.this).substring(0, 4) });
      FacebookLoginUI.a(FacebookLoginUI.this, new u("facebook@wechat_auth", FacebookLoginUI.a(FacebookLoginUI.this), 0, "", "", "", 0, "", true, false));
      ap.vd().a(FacebookLoginUI.b(FacebookLoginUI.this), 0);
      FacebookLoginUI.kA(true);
      com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + FacebookLoginUI.this.getClass().getName() + ",L14," + ap.ec("L14") + ",2");
      com.tencent.mm.plugin.report.service.g.oSF.a(582L, 6L, 1L, false);
      GMTrace.o(2738041651200L, 20400);
    }
    
    public final void onCancel()
    {
      GMTrace.i(2738444304384L, 20403);
      v.d("MicroMsg.FacebookLoginUI", "onCancel");
      FacebookLoginUI.kA(false);
      com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + FacebookLoginUI.this.getClass().getName() + ",L14," + ap.ec("L14") + ",2");
      com.tencent.mm.plugin.report.service.g.oSF.a(582L, 9L, 1L, false);
      GMTrace.o(2738444304384L, 20403);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/FacebookLoginUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */