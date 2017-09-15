package com.tencent.mm.ui.bindmobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.a.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.friend.InviteFriendUI;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.List;

public class MobileFriendUI
  extends MMActivity
  implements com.tencent.mm.y.e
{
  private ListView irY;
  private View isa;
  private ProgressDialog isb;
  String isc;
  private TextView jUy;
  private TextView uVX;
  a vsQ;
  private aa vsR;
  
  public MobileFriendUI()
  {
    GMTrace.i(3141902794752L, 23409);
    this.isb = null;
    this.jUy = null;
    this.uVX = null;
    GMTrace.o(3141902794752L, 23409);
  }
  
  private void aOB()
  {
    GMTrace.i(3142305447936L, 23412);
    if (!com.tencent.mm.modelfriend.m.Fl())
    {
      Object localObject = this.uRf.uRz;
      getString(R.l.dIG);
      this.isb = com.tencent.mm.ui.base.g.a((Context)localObject, getString(R.l.eAT), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(3138413133824L, 23383);
          if (MobileFriendUI.a(MobileFriendUI.this) != null) {
            ap.vd().c(MobileFriendUI.a(MobileFriendUI.this));
          }
          GMTrace.o(3138413133824L, 23383);
        }
      });
      if (this.vsQ.getCount() == 0)
      {
        if ((!com.tencent.mm.modelfriend.a.a(new a.b()
        {
          public final void bg(boolean paramAnonymousBoolean)
          {
            GMTrace.i(3129823199232L, 23319);
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileFriendUI", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            if (!paramAnonymousBoolean)
            {
              if (MobileFriendUI.b(MobileFriendUI.this) != null)
              {
                MobileFriendUI.b(MobileFriendUI.this).dismiss();
                MobileFriendUI.c(MobileFriendUI.this);
              }
              GMTrace.o(3129823199232L, 23319);
              return;
            }
            System.currentTimeMillis();
            aa localaa = new aa(com.tencent.mm.modelfriend.m.Ft(), com.tencent.mm.modelfriend.m.Fs());
            ap.vd().a(localaa, 0);
            GMTrace.o(3129823199232L, 23319);
          }
        })) && (this.isb != null))
        {
          this.isb.dismiss();
          this.isb = null;
        }
        GMTrace.o(3142305447936L, 23412);
        return;
      }
      localObject = com.tencent.mm.modelfriend.m.Ft();
      List localList = com.tencent.mm.modelfriend.m.Fs();
      if ((((List)localObject).size() != 0) || (localList.size() != 0))
      {
        this.vsR = new aa(com.tencent.mm.modelfriend.m.Ft(), com.tencent.mm.modelfriend.m.Fs());
        ap.vd().a(this.vsR, 0);
        GMTrace.o(3142305447936L, 23412);
        return;
      }
      localObject = new com.tencent.mm.modelfriend.v();
      ap.vd().a((k)localObject, 0);
    }
    GMTrace.o(3142305447936L, 23412);
  }
  
  protected final void KD()
  {
    GMTrace.i(3142976536576L, 23417);
    this.jUy = ((TextView)findViewById(R.h.ckn));
    this.jUy.setText(R.l.eAR);
    this.uVX = ((TextView)findViewById(R.h.bLM));
    this.uVX.setText(R.l.eAW);
    this.isa = findViewById(R.h.ckq);
    this.irY = ((ListView)findViewById(R.h.ckp));
    Object localObject = new p(true, true);
    ((p)localObject).wlY = new p.b()
    {
      public final void OE()
      {
        GMTrace.i(3107408838656L, 23152);
        GMTrace.o(3107408838656L, 23152);
      }
      
      public final void OF()
      {
        GMTrace.i(3107543056384L, 23153);
        GMTrace.o(3107543056384L, 23153);
      }
      
      public final void OG()
      {
        GMTrace.i(3107677274112L, 23154);
        GMTrace.o(3107677274112L, 23154);
      }
      
      public final void OH()
      {
        GMTrace.i(16854256975872L, 125574);
        GMTrace.o(16854256975872L, 125574);
      }
      
      public final boolean mQ(String paramAnonymousString)
      {
        GMTrace.i(3107140403200L, 23150);
        GMTrace.o(3107140403200L, 23150);
        return false;
      }
      
      public final void mR(String paramAnonymousString)
      {
        GMTrace.i(3107274620928L, 23151);
        MobileFriendUI.a(MobileFriendUI.this, bf.my(paramAnonymousString));
        paramAnonymousString = MobileFriendUI.this;
        if (paramAnonymousString.vsQ != null) {
          paramAnonymousString.vsQ.yB(paramAnonymousString.isc);
        }
        GMTrace.o(3107274620928L, 23151);
      }
    };
    a((p)localObject);
    boolean bool;
    if (com.tencent.mm.u.a.g.Ae().gu("2") != null)
    {
      localObject = com.tencent.mm.u.a.g.Ae().gu("2").value;
      if (((String)localObject).equals("0"))
      {
        bool = false;
        f.gy("2");
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileFriendUI", "ABTest Type, NEW(%B)", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {}
      for (this.vsQ = new b(this, new k.a()
          {
            public final void OI()
            {
              GMTrace.i(3114925031424L, 23208);
              MobileFriendUI localMobileFriendUI = MobileFriendUI.this;
              MobileFriendUI.d(MobileFriendUI.this).getCount();
              MobileFriendUI.e(localMobileFriendUI);
              GMTrace.o(3114925031424L, 23208);
            }
            
            public final void OJ()
            {
              GMTrace.i(3114790813696L, 23207);
              GMTrace.o(3114790813696L, 23207);
            }
          });; this.vsQ = new c(this, new k.a()
          {
            public final void OI()
            {
              GMTrace.i(3109556322304L, 23168);
              MobileFriendUI localMobileFriendUI = MobileFriendUI.this;
              MobileFriendUI.d(MobileFriendUI.this).getCount();
              MobileFriendUI.e(localMobileFriendUI);
              GMTrace.o(3109556322304L, 23168);
            }
            
            public final void OJ()
            {
              GMTrace.i(3109422104576L, 23167);
              GMTrace.o(3109422104576L, 23167);
            }
          }))
      {
        this.irY.setAdapter(this.vsQ);
        this.irY.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            GMTrace.i(3127138844672L, 23299);
            if (paramAnonymousInt < MobileFriendUI.f(MobileFriendUI.this).getHeaderViewsCount())
            {
              GMTrace.o(3127138844672L, 23299);
              return;
            }
            int i = MobileFriendUI.f(MobileFriendUI.this).getHeaderViewsCount();
            paramAnonymousAdapterView = (com.tencent.mm.modelfriend.b)MobileFriendUI.d(MobileFriendUI.this).getItem(paramAnonymousInt - i);
            if ((paramAnonymousAdapterView.status == 1) || (paramAnonymousAdapterView.status == 2)) {
              MobileFriendUI.this.b(paramAnonymousAdapterView);
            }
            if (paramAnonymousAdapterView.status == 0)
            {
              paramAnonymousView = new Intent(MobileFriendUI.this, InviteFriendUI.class);
              paramAnonymousView.putExtra("friend_type", 1);
              paramAnonymousView.putExtra("friend_user_name", paramAnonymousAdapterView.getUsername());
              paramAnonymousView.putExtra("friend_num", paramAnonymousAdapterView.EY());
              paramAnonymousView.putExtra("friend_nick", paramAnonymousAdapterView.ES());
              paramAnonymousView.putExtra("friend_weixin_nick", paramAnonymousAdapterView.EV());
              paramAnonymousView.putExtra("friend_scene", 13);
              MobileFriendUI.this.startActivity(paramAnonymousView);
            }
            GMTrace.o(3127138844672L, 23299);
          }
        });
        this.vsQ.a(new a.a()
        {
          public final void zv(int paramAnonymousInt)
          {
            GMTrace.i(3101637476352L, 23109);
            if (paramAnonymousInt > 0)
            {
              MobileFriendUI.g(MobileFriendUI.this).setVisibility(8);
              GMTrace.o(3101637476352L, 23109);
              return;
            }
            MobileFriendUI.g(MobileFriendUI.this).setVisibility(0);
            GMTrace.o(3101637476352L, 23109);
          }
        });
        if ((com.tencent.mm.modelfriend.m.Fm() != m.a.hBa) && (com.tencent.mm.modelfriend.m.Fm() != m.a.hBb))
        {
          this.isa = findViewById(R.h.ckq);
          this.isa.setVisibility(0);
          this.isa.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              GMTrace.i(3141500141568L, 23406);
              paramAnonymousView = new Intent(MobileFriendUI.this.uRf.uRz, BindMContactIntroUI.class);
              paramAnonymousView.putExtra("key_upload_scene", 6);
              MMWizardActivity.w(MobileFriendUI.this, paramAnonymousView);
              GMTrace.o(3141500141568L, 23406);
            }
          });
          this.irY.setVisibility(8);
        }
        b(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            GMTrace.i(3094121283584L, 23053);
            MobileFriendUI.this.aGY();
            MobileFriendUI.this.finish();
            GMTrace.o(3094121283584L, 23053);
            return true;
          }
        });
        new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(3102174347264L, 23113);
            BackwardSupportUtil.c.a(MobileFriendUI.f(MobileFriendUI.this));
            GMTrace.o(3102174347264L, 23113);
          }
        };
        if ((!com.tencent.mm.u.m.yo()) || (com.tencent.mm.modelfriend.m.Fl())) {
          com.tencent.mm.ui.base.g.a(this, R.l.dNb, R.l.dIG, R.l.dHL, R.l.dGk, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(3148747898880L, 23460);
              com.tencent.mm.plugin.report.service.g.oSF.i(11438, new Object[] { Integer.valueOf(6) });
              com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileFriendUI", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(6) });
              ap.yY();
              com.tencent.mm.u.c.vr().set(12322, Boolean.valueOf(true));
              com.tencent.mm.platformtools.m.f(true, true);
              MobileFriendUI.h(MobileFriendUI.this);
              GMTrace.o(3148747898880L, 23460);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(3144721367040L, 23430);
              ap.yY();
              com.tencent.mm.u.c.vr().set(12322, Boolean.valueOf(false));
              com.tencent.mm.platformtools.m.f(false, true);
              MobileFriendUI.this.finish();
              GMTrace.o(3144721367040L, 23430);
            }
          });
        }
        GMTrace.o(3142976536576L, 23417);
        return;
        if (!((String)localObject).equals("1")) {
          break label412;
        }
        bool = true;
        break;
      }
      label412:
      bool = true;
      break;
      bool = true;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(3143244972032L, 23419);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramk.getType() == 32) && (this.isb != null))
    {
      this.isb.dismiss();
      this.isb = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
    }
    if (paramk.getType() == 133)
    {
      paramString = new com.tencent.mm.modelfriend.v();
      ap.vd().a(paramString, 0);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramk.getType() == 32) {
        d.be(getApplicationContext());
      }
      this.vsQ.a(null, null);
      GMTrace.o(3143244972032L, 23419);
      return;
    }
    if (paramk.getType() == 32) {
      Toast.makeText(this, R.l.eAS, 0).show();
    }
    GMTrace.o(3143244972032L, 23419);
  }
  
  public final void b(com.tencent.mm.modelfriend.b paramb)
  {
    GMTrace.i(3143110754304L, 23418);
    if (bf.mA(paramb.getUsername()))
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.MobileFriendUI", "username is null");
      GMTrace.o(3143110754304L, 23418);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramb.getUsername());
    localIntent.putExtra("Contact_Nick", paramb.EV());
    localIntent.putExtra("Contact_Mobile_MD5", paramb.EQ());
    localIntent.putExtra("Contact_Alias", paramb.hAq);
    localIntent.putExtra("Contact_Sex", paramb.hAl);
    localIntent.putExtra("Contact_Signature", paramb.hAo);
    localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(paramb.hAu, paramb.hAm, paramb.hAn));
    localIntent.putExtra("Contact_Scene", 13);
    localIntent.putExtra("Contact_ShowUserName", false);
    com.tencent.mm.plugin.c.a.imb.d(localIntent, this);
    GMTrace.o(3143110754304L, 23418);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(3142842318848L, 23416);
    int i = R.i.djl;
    GMTrace.o(3142842318848L, 23416);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3142037012480L, 23410);
    super.onCreate(paramBundle);
    zd(R.l.eAU);
    af.FZ().hnp.eE("qqlist", "update addr_upload2 set reserved4=0");
    ap.vd().a(32, this);
    ap.vd().a(133, this);
    KD();
    boolean bool = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileFriendUI", "summerper checkPermission checkContacts[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      GMTrace.o(3142037012480L, 23410);
      return;
    }
    aOB();
    GMTrace.o(3142037012480L, 23410);
  }
  
  public void onDestroy()
  {
    GMTrace.i(3142708101120L, 23415);
    f.gz("2");
    ap.vd().b(32, this);
    ap.vd().b(133, this);
    this.vsQ.aEP();
    super.onDestroy();
    GMTrace.o(3142708101120L, 23415);
  }
  
  public void onPause()
  {
    GMTrace.i(3142573883392L, 23414);
    super.onPause();
    GMTrace.o(3142573883392L, 23414);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    GMTrace.i(3142171230208L, 23411);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileFriendUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(3142171230208L, 23411);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aOB();
        GMTrace.o(3142171230208L, 23411);
        return;
      }
      com.tencent.mm.ui.base.g.a(this, getString(R.l.eFz), getString(R.l.eFE), getString(R.l.evo), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3124320272384L, 23278);
          MobileFriendUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
          MobileFriendUI.this.finish();
          GMTrace.o(3124320272384L, 23278);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3106066661376L, 23142);
          MobileFriendUI.this.finish();
          GMTrace.o(3106066661376L, 23142);
        }
      });
    }
  }
  
  protected void onResume()
  {
    GMTrace.i(3142439665664L, 23413);
    super.onResume();
    this.vsQ.notifyDataSetChanged();
    GMTrace.o(3142439665664L, 23413);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindmobile/MobileFriendUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */