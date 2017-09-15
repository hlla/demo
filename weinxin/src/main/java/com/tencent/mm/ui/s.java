package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.a.d.b;
import com.tencent.mm.ah.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.mq;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.c;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.i;
import com.tencent.mm.ui.contact.AddressUI;

public class s
  extends a
  implements m.b
{
  public f isp;
  private a.a pkR;
  
  public s()
  {
    GMTrace.i(1593432866816L, 11872);
    this.pkR = new a.a()
    {
      public final void a(w.a paramAnonymousa)
      {
        GMTrace.i(1854217912320L, 13815);
        if (paramAnonymousa == w.a.uyN) {
          s.this.bQi();
        }
        for (;;)
        {
          s.this.isp.notifyDataSetChanged();
          GMTrace.o(1854217912320L, 13815);
          return;
          if (paramAnonymousa == w.a.uyO) {
            s.this.bQi();
          } else if (paramAnonymousa == w.a.uGE) {
            s.this.bQm();
          }
        }
      }
      
      public final void eE(int paramAnonymousInt)
      {
        GMTrace.i(1853949476864L, 13813);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 266260) || (paramAnonymousInt == 262157) || (paramAnonymousInt == 266267) || (paramAnonymousInt == 262158))
        {
          s.this.bQj();
          s.this.aZN();
        }
        for (;;)
        {
          s.this.isp.notifyDataSetChanged();
          GMTrace.o(1853949476864L, 13813);
          return;
          if (paramAnonymousInt == 262147) {
            s.this.bQk();
          } else if (paramAnonymousInt == 262156) {
            s.this.bQm();
          } else if (paramAnonymousInt == 262152) {
            s.this.bQi();
          }
        }
      }
      
      public final void eF(int paramAnonymousInt)
      {
        GMTrace.i(1854083694592L, 13814);
        GMTrace.o(1854083694592L, 13814);
      }
    };
    GMTrace.o(1593432866816L, 11872);
  }
  
  private void bQl()
  {
    GMTrace.i(1595043479552L, 11884);
    boolean bool = com.tencent.mm.u.m.xU();
    v.d("MicroMsg.MoreTabUI", "wallet status: is open" + bool);
    f localf = this.isp;
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      localf.aV("settings_mm_wallet", bool);
      this.vpG.notifyDataSetChanged();
      GMTrace.o(1595043479552L, 11884);
      return;
    }
  }
  
  public final int OO()
  {
    GMTrace.i(1593701302272L, 11874);
    int i = R.o.ftK;
    GMTrace.o(1593701302272L, 11874);
    return i;
  }
  
  public final boolean WV()
  {
    GMTrace.i(1593969737728L, 11876);
    GMTrace.o(1593969737728L, 11876);
    return true;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    GMTrace.i(1595311915008L, 11886);
    int i = u.aC(paramObject);
    v.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    ap.yY();
    if ((paramm != com.tencent.mm.u.c.vr()) || (i <= 0))
    {
      v.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
      GMTrace.o(1595311915008L, 11886);
      return;
    }
    if ((204817 == i) || (204820 == i))
    {
      bQm();
      GMTrace.o(1595311915008L, 11886);
      return;
    }
    if (40 == i)
    {
      bQl();
      GMTrace.o(1595311915008L, 11886);
      return;
    }
    if ("208899".equals(Integer.valueOf(paramInt))) {
      bQk();
    }
    GMTrace.o(1595311915008L, 11886);
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    GMTrace.i(1594372390912L, 11879);
    if (paramPreference.igr.equals("more_tab_setting_personal_info"))
    {
      paramf = new Intent();
      d.b(this.uRf.uRz, "setting", ".ui.setting.SettingsPersonalInfoUI", paramf);
      GMTrace.o(1594372390912L, 11879);
      return true;
    }
    if (paramPreference.igr.equals("settings_my_address"))
    {
      paramf = new Intent(this.uRf.uRz, AddressUI.class);
      paramf.putExtra("Contact_GroupFilter_Type", "@biz.contact");
      startActivity(paramf);
      GMTrace.o(1594372390912L, 11879);
      return true;
    }
    if (paramPreference.igr.equals("settings_my_add_contact"))
    {
      d.b(this.uRf.uRz, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
      GMTrace.o(1594372390912L, 11879);
      return true;
    }
    boolean bool1;
    int i;
    if (paramPreference.igr.equals("settings_mm_wallet"))
    {
      bool1 = com.tencent.mm.q.c.uk().aC(262156, 266248);
      boolean bool2 = com.tencent.mm.q.c.uk().aD(262156, 266248);
      com.tencent.mm.plugin.report.service.g.oSF.A(10958, "9");
      paramf = com.tencent.mm.plugin.report.service.g.oSF;
      if ((bool1) || (bool2)) {}
      for (i = 1;; i = 0)
      {
        paramf.i(13341, new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.g.oSF.i(14419, new Object[] { Integer.valueOf(0) });
        paramf = new mq();
        paramf.fTM.context = this.uRf.uRz;
        paramPreference = new Intent();
        paramPreference.putExtra("key_wallet_has_red", bool2);
        paramf.fTM.intent = paramPreference;
        com.tencent.mm.sdk.b.a.uql.m(paramf);
        com.tencent.mm.q.c.uk().aE(262156, 266248);
        com.tencent.mm.q.c.uk().c(w.a.uGE, w.a.uGG);
        ap.yY();
        com.tencent.mm.u.c.vr().a(w.a.uGq, "");
        ap.yY();
        com.tencent.mm.u.c.vr().a(w.a.uGr, Integer.valueOf(-1));
        GMTrace.o(1594372390912L, 11879);
        return true;
      }
    }
    if (paramPreference.igr.equals("settings_mm_cardpackage"))
    {
      ap.yY();
      com.tencent.mm.u.c.vr().a(w.a.uyT, "");
      paramf = new Intent();
      paramf.putExtra("key_from_scene", 22);
      d.b(this.uRf.uRz, "card", ".ui.CardHomePageUI", paramf);
      GMTrace.o(1594372390912L, 11879);
      return true;
    }
    if (paramPreference.igr.equals("settings_my_album"))
    {
      ap.yY();
      if (!com.tencent.mm.u.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.s.eP(this.uRf.uRz);
        GMTrace.o(1594372390912L, 11879);
        return true;
      }
      ap.yY();
      paramf = (String)com.tencent.mm.u.c.vr().get(2, null);
      paramPreference = new Intent();
      paramPreference.putExtra("sns_userName", paramf);
      paramPreference.setFlags(536870912);
      paramPreference.addFlags(67108864);
      ap.yY();
      i = u.g((Integer)com.tencent.mm.u.c.vr().get(68389, null));
      ap.yY();
      com.tencent.mm.u.c.vr().set(68389, Integer.valueOf(i + 1));
      d.b(this.uRf.uRz, "sns", ".ui.SnsUserUI", paramPreference);
      GMTrace.o(1594372390912L, 11879);
      return true;
    }
    if (paramPreference.igr.equals("settings_mm_favorite"))
    {
      com.tencent.mm.plugin.report.service.g.oSF.A(10958, "8");
      com.tencent.mm.plugin.report.service.g.oSF.i(14103, new Object[] { Integer.valueOf(0) });
      d.w(this.uRf.uRz, "favorite", ".ui.FavoriteIndexUI");
      paramf = new Intent();
      paramf.setComponent(new ComponentName(d.g.uMO, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
      paramf.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
      sendBroadcast(paramf);
      GMTrace.o(1594372390912L, 11879);
      return true;
    }
    if (paramPreference.igr.equals("settings_emoji_store"))
    {
      com.tencent.mm.plugin.report.service.g.oSF.A(10958, "7");
      com.tencent.mm.q.c.uk().aE(262147, 266244);
      com.tencent.mm.q.c.uk().aE(262149, 266244);
      paramf = new Intent();
      paramf.putExtra("preceding_scence", 2);
      d.b(this.uRf.uRz, "emoji", ".ui.v2.EmojiStoreV2UI", paramf);
      com.tencent.mm.plugin.report.service.g.oSF.i(12065, new Object[] { Integer.valueOf(1) });
      GMTrace.o(1594372390912L, 11879);
      return true;
    }
    if (paramPreference.igr.equals("more_setting"))
    {
      bool1 = com.tencent.mm.q.c.uk().aC(262145, 266242);
      com.tencent.mm.q.c.uk().aE(262145, 266242);
      com.tencent.mm.q.c.uk().aE(262157, 266261);
      com.tencent.mm.q.c.uk().aE(262158, 266264);
      paramPreference = new Intent();
      d.b(this.uRf.uRz, "setting", ".ui.setting.SettingsUI", paramPreference);
      ap.yY();
      i = ((Integer)com.tencent.mm.u.c.vr().get(w.a.uEO, Integer.valueOf(0))).intValue();
      ap.yY();
      int j = ((Integer)com.tencent.mm.u.c.vr().get(w.a.uEP, Integer.valueOf(0))).intValue();
      if ((!bool1) && (i > j))
      {
        ap.yY();
        com.tencent.mm.u.c.vr().a(w.a.uEP, Integer.valueOf(i));
        paramf = (IconPreference)paramf.Tc("more_setting");
        if (paramf != null) {
          paramf.Ap(8);
        }
        com.tencent.mm.q.c.uk().aE(266260, 266241);
      }
      GMTrace.o(1594372390912L, 11879);
      return true;
    }
    if (paramPreference.igr.equals("more_uishow"))
    {
      com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.ag.a.a.a.class);
      new Intent();
      GMTrace.o(1594372390912L, 11879);
      return true;
    }
    GMTrace.o(1594372390912L, 11879);
    return false;
  }
  
  public final void aZN()
  {
    GMTrace.i(1594506608640L, 11880);
    if (!d.Jr("sns"))
    {
      this.isp.aV("settings_my_album", true);
      GMTrace.o(1594506608640L, 11880);
      return;
    }
    this.isp.aV("settings_my_album", false);
    GMTrace.o(1594506608640L, 11880);
  }
  
  public final void bOX()
  {
    GMTrace.i(1596654092288L, 11896);
    GMTrace.o(1596654092288L, 11896);
  }
  
  protected final void bOb()
  {
    GMTrace.i(1595446132736L, 11887);
    this.isp = this.vpG;
    GMTrace.o(1595446132736L, 11887);
  }
  
  protected final void bOc()
  {
    GMTrace.i(1595580350464L, 11888);
    this.isp = this.vpG;
    ap.yY();
    com.tencent.mm.u.c.vr().a(this);
    com.tencent.mm.q.c.uk().a(this.pkR);
    this.isp.aV("more_tab_setting_personal_info", false);
    AccountInfoPreference localAccountInfoPreference = (AccountInfoPreference)this.vpG.Tc("more_tab_setting_personal_info");
    final Object localObject = com.tencent.mm.u.m.xM();
    if (u.mA((String)localObject))
    {
      localObject = com.tencent.mm.u.m.xL();
      if (x.QP((String)localObject))
      {
        localAccountInfoPreference.sQi = null;
        localAccountInfoPreference.userName = com.tencent.mm.u.m.xL();
        String str = com.tencent.mm.u.m.xN();
        localObject = str;
        if (u.mA(str)) {
          localObject = com.tencent.mm.u.m.xL();
        }
        localAccountInfoPreference.sQh = com.tencent.mm.pluginsdk.ui.d.h.a(this.uRf.uRz, (CharSequence)localObject);
        ((AccountInfoPreference)this.isp.Tc("more_tab_setting_personal_info")).sQk = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(16804999069696L, 125207);
            com.tencent.mm.plugin.report.service.g.oSF.i(11264, new Object[] { Integer.valueOf(1) });
            s.this.startActivity(new Intent(s.this.uRf.uRz, SelfQRCodeUI.class));
            GMTrace.o(16804999069696L, 125207);
          }
        };
        localObject = (IconPreference)this.isp.Tc("settings_my_address");
        if (localObject != null)
        {
          int i = com.tencent.mm.av.l.Kz().Kn();
          if (i <= 0) {
            break label358;
          }
          ((IconPreference)localObject).An(0);
          ((IconPreference)localObject).cM(String.valueOf(i), R.g.bhA);
        }
        label206:
        aZN();
        bQk();
        bQj();
        if (d.Jr("favorite")) {
          break label375;
        }
        this.isp.aV("settings_mm_favorite", true);
        label240:
        bQm();
        bQl();
        bQi();
        if (!com.tencent.mm.kernel.h.vE().g(com.tencent.mm.plugin.ag.a.a.class)) {
          break label391;
        }
        this.isp.aV("more_uishow", false);
      }
    }
    for (;;)
    {
      this.isp.notifyDataSetChanged();
      localObject = findViewById(R.h.cbM);
      if ((localObject != null) && (((View)localObject).getVisibility() != 8)) {
        new ad(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(16855464935424L, 125583);
            localObject.setVisibility(8);
            localObject.startAnimation(AnimationUtils.loadAnimation(s.this.uRf.uRz, R.a.aQY));
            GMTrace.o(16855464935424L, 125583);
          }
        });
      }
      GMTrace.o(1595580350464L, 11888);
      return;
      localAccountInfoPreference.sQi = ((String)localObject);
      break;
      localAccountInfoPreference.sQi = ((String)localObject);
      break;
      label358:
      ((IconPreference)localObject).An(8);
      ((IconPreference)localObject).cM("", -1);
      break label206;
      label375:
      this.isp.aV("settings_mm_favorite", false);
      break label240;
      label391:
      this.isp.aV("more_uishow", true);
    }
  }
  
  protected final void bOd()
  {
    GMTrace.i(1595714568192L, 11889);
    GMTrace.o(1595714568192L, 11889);
  }
  
  protected final void bOe()
  {
    GMTrace.i(1595848785920L, 11890);
    com.tencent.mm.q.c.uk().b(this.pkR);
    ap.yY();
    com.tencent.mm.u.c.vr().b(this);
    GMTrace.o(1595848785920L, 11890);
  }
  
  protected final void bOf()
  {
    GMTrace.i(1595983003648L, 11891);
    GMTrace.o(1595983003648L, 11891);
  }
  
  protected final void bOg()
  {
    GMTrace.i(1596117221376L, 11892);
    GMTrace.o(1596117221376L, 11892);
  }
  
  public final void bOi()
  {
    GMTrace.i(1596251439104L, 11893);
    if (this.isp != null) {
      this.isp.removeAll();
    }
    this.mTv.setAdapter(null);
    GMTrace.o(1596251439104L, 11893);
  }
  
  public final void bOj()
  {
    GMTrace.i(1596385656832L, 11894);
    if (this.isp != null)
    {
      this.isp.removeAll();
      this.isp.addPreferencesFromResource(R.o.ftK);
    }
    this.mTv.setAdapter(this.vpG);
    GMTrace.o(1596385656832L, 11894);
  }
  
  public final void bOl()
  {
    GMTrace.i(1596519874560L, 11895);
    GMTrace.o(1596519874560L, 11895);
  }
  
  public final void bQi()
  {
    GMTrace.i(1594640826368L, 11881);
    Object localObject1 = l.a.szP;
    if ((localObject1 == null) || ((!((l.c)localObject1).afD()) && (!((l.c)localObject1).afE())) || (!d.Jr("card")))
    {
      this.isp.aV("settings_mm_cardpackage", true);
      GMTrace.o(1594640826368L, 11881);
      return;
    }
    if (localObject1 != null) {}
    for (localObject1 = ((l.c)localObject1).afF();; localObject1 = "")
    {
      boolean bool1 = com.tencent.mm.q.c.uk().aD(262152, 266256);
      boolean bool2 = com.tencent.mm.q.c.uk().aC(262152, 266256);
      boolean bool3 = com.tencent.mm.q.c.uk().a(w.a.uyN, w.a.uyP);
      boolean bool4 = com.tencent.mm.q.c.uk().a(w.a.uyO, w.a.uyQ);
      this.isp.aV("settings_mm_cardpackage", false);
      final IconPreference localIconPreference = (IconPreference)this.isp.Tc("settings_mm_cardpackage");
      if (localIconPreference == null)
      {
        GMTrace.o(1594640826368L, 11881);
        return;
      }
      localIconPreference.setTitle(R.l.eSH);
      if (bool2)
      {
        localIconPreference.An(0);
        localIconPreference.cM(getString(R.l.dHG), R.g.bhA);
        localIconPreference.Ap(8);
        localIconPreference.setSummary(null);
        localIconPreference.P(null);
        localIconPreference.Ar(8);
        localIconPreference.cN("", -1);
        localIconPreference.Ao(8);
        GMTrace.o(1594640826368L, 11881);
        return;
      }
      ap.yY();
      String str = (String)com.tencent.mm.u.c.vr().get(w.a.uyW, "");
      if ((bool4) && (!TextUtils.isEmpty(str)))
      {
        int i = getResources().getDimensionPixelOffset(R.f.aYD);
        Object localObject2 = new c.a();
        ((c.a)localObject2).hIw = com.tencent.mm.compatible.util.e.hgk;
        n.GY();
        ((c.a)localObject2).hIO = null;
        ((c.a)localObject2).hIv = com.tencent.mm.plugin.card.model.m.ss(str);
        ((c.a)localObject2).hIt = true;
        ((c.a)localObject2).hIQ = true;
        ((c.a)localObject2).hIr = true;
        ((c.a)localObject2).hIA = i;
        ((c.a)localObject2).hIz = i;
        localObject2 = ((c.a)localObject2).Hh();
        n.GX().a(str, localIconPreference.nut, (com.tencent.mm.ah.a.a.c)localObject2, new com.tencent.mm.ah.a.c.g()
        {
          public final void a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
          {
            GMTrace.i(2078898388992L, 15489);
            if (paramAnonymousb.bitmap != null)
            {
              ae.v(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(2906484899840L, 21655);
                  s.2.this.uTv.P(this.kpu);
                  s.2.this.uTv.Ar(0);
                  GMTrace.o(2906484899840L, 21655);
                }
              });
              GMTrace.o(2078898388992L, 15489);
              return;
            }
            ae.v(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(1703894056960L, 12695);
                s.2.this.uTv.P(null);
                s.2.this.uTv.Ar(8);
                GMTrace.o(1703894056960L, 12695);
              }
            });
            GMTrace.o(2078898388992L, 15489);
          }
          
          public final void jL(String paramAnonymousString)
          {
            GMTrace.i(2078764171264L, 15488);
            ae.v(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(2077287776256L, 15477);
                s.2.this.uTv.Ar(0);
                s.2.this.uTv.Aq(R.g.bho);
                GMTrace.o(2077287776256L, 15477);
              }
            });
            GMTrace.o(2078764171264L, 15488);
          }
        });
        if (!bool1) {
          break label513;
        }
        localIconPreference.Ap(0);
      }
      for (;;)
      {
        if (bool3)
        {
          localIconPreference.cM("", -1);
          localIconPreference.An(8);
          if (bool4)
          {
            localIconPreference.setSummary(null);
            if (!u.mA((String)localObject1))
            {
              localIconPreference.R((String)localObject1, -1, getResources().getColor(R.e.aUo));
              localIconPreference.Ao(0);
              GMTrace.o(1594640826368L, 11881);
              return;
              localIconPreference.P(null);
              localIconPreference.Ar(8);
              break;
              label513:
              localIconPreference.Ap(8);
              continue;
            }
            localIconPreference.cN("", -1);
            localIconPreference.Ao(8);
            GMTrace.o(1594640826368L, 11881);
            return;
          }
          localIconPreference.cN("", -1);
          localIconPreference.Ao(8);
          if (!u.mA((String)localObject1))
          {
            localIconPreference.setSummary((CharSequence)localObject1);
            GMTrace.o(1594640826368L, 11881);
            return;
          }
          localIconPreference.setSummary(null);
          GMTrace.o(1594640826368L, 11881);
          return;
        }
      }
      localIconPreference.Ao(8);
      localIconPreference.An(8);
      localIconPreference.setSummary(null);
      GMTrace.o(1594640826368L, 11881);
      return;
    }
  }
  
  public final void bQj()
  {
    GMTrace.i(1594775044096L, 11882);
    this.isp.aV("more_setting", false);
    IconPreference localIconPreference = (IconPreference)this.isp.Tc("more_setting");
    if (localIconPreference != null)
    {
      localIconPreference.As(8);
      boolean bool = com.tencent.mm.q.c.uk().aC(262145, 266242);
      if (bool)
      {
        localIconPreference.An(0);
        localIconPreference.cM(getString(R.l.dHG), R.g.bhA);
        ap.yY();
        if (((Integer)com.tencent.mm.u.c.vr().get(9, Integer.valueOf(0))).intValue() != 0)
        {
          if (com.tencent.mm.u.m.xT()) {
            break label168;
          }
          localIconPreference.setSummary(R.l.eNB);
        }
      }
      for (;;)
      {
        localIconPreference.Ap(8);
        if (!bool) {
          break label179;
        }
        GMTrace.o(1594775044096L, 11882);
        return;
        localIconPreference.An(8);
        localIconPreference.cM("", -1);
        break;
        label168:
        localIconPreference.setSummary("");
      }
      label179:
      ap.yY();
      int i = ((Integer)com.tencent.mm.u.c.vr().get(w.a.uEO, Integer.valueOf(0))).intValue();
      ap.yY();
      int j = ((Integer)com.tencent.mm.u.c.vr().get(w.a.uEP, Integer.valueOf(0))).intValue();
      if (((((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.welab.a.a.c.class)).bAC()) || (((com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.welab.a.a.c.class)).bAD()) || (i > j)) && (!bool))
      {
        localIconPreference.Ap(0);
        localIconPreference.An(8);
        localIconPreference.cM("", -1);
        GMTrace.o(1594775044096L, 11882);
        return;
      }
      localIconPreference.Ap(8);
      if (com.tencent.mm.q.c.uk().aD(262157, 266261))
      {
        localIconPreference.Ap(0);
        localIconPreference.An(8);
        localIconPreference.cM("", -1);
        GMTrace.o(1594775044096L, 11882);
        return;
      }
      if (com.tencent.mm.q.c.uk().aD(262158, 266264))
      {
        localIconPreference.Ap(0);
        localIconPreference.An(8);
        localIconPreference.cM("", -1);
        GMTrace.o(1594775044096L, 11882);
        return;
      }
    }
    GMTrace.o(1594775044096L, 11882);
  }
  
  public final void bQk()
  {
    GMTrace.i(1594909261824L, 11883);
    boolean bool1;
    boolean bool2;
    final IconPreference localIconPreference;
    if (d.Jr("emoji"))
    {
      d.bGH();
      this.isp.aV("settings_emoji_store", false);
      bool1 = com.tencent.mm.q.c.uk().aC(262147, 266244);
      bool2 = com.tencent.mm.q.c.uk().aC(262149, 266244);
      localIconPreference = (IconPreference)this.isp.Tc("settings_emoji_store");
      if (localIconPreference == null) {
        GMTrace.o(1594909261824L, 11883);
      }
    }
    else
    {
      this.isp.aV("settings_emoji_store", false);
      GMTrace.o(1594909261824L, 11883);
      return;
    }
    if (bool1)
    {
      localIconPreference.An(0);
      localIconPreference.cM(getString(R.l.dHG), R.g.bhA);
    }
    while ((bool2) || (bool1))
    {
      ap.yY();
      String str = (String)com.tencent.mm.u.c.vr().get(229633, null);
      n.GX().a(str, localIconPreference.nut, new com.tencent.mm.ah.a.c.g()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          GMTrace.i(16855196499968L, 125581);
          if ((paramAnonymousb.status == 0) && (paramAnonymousb.bitmap != null))
          {
            ae.v(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(16854525411328L, 125576);
                s.4.this.uTx.P(this.kpu);
                s.4.this.uTx.Ar(0);
                GMTrace.o(16854525411328L, 125576);
              }
            });
            GMTrace.o(16855196499968L, 125581);
            return;
          }
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(16851706839040L, 125555);
              s.4.this.uTx.Ar(8);
              GMTrace.o(16851706839040L, 125555);
            }
          });
          GMTrace.o(16855196499968L, 125581);
        }
        
        public final void jL(String paramAnonymousString)
        {
          GMTrace.i(16855062282240L, 125580);
          GMTrace.o(16855062282240L, 125580);
        }
      });
      GMTrace.o(1594909261824L, 11883);
      return;
      if (bool2)
      {
        localIconPreference.An(0);
        localIconPreference.cM(getString(R.l.dHi), R.g.bhA);
      }
      else
      {
        localIconPreference.An(8);
        localIconPreference.cM("", -1);
      }
    }
    localIconPreference.Ar(8);
    GMTrace.o(1594909261824L, 11883);
  }
  
  public final void bQm()
  {
    GMTrace.i(1595177697280L, 11885);
    ap.yY();
    int i = u.g((Integer)com.tencent.mm.u.c.vr().get(204820, null));
    ap.yY();
    i += u.g((Integer)com.tencent.mm.u.c.vr().get(204817, null));
    boolean bool2 = com.tencent.mm.q.c.uk().aC(262156, 266248);
    boolean bool1 = com.tencent.mm.q.c.uk().aD(262156, 266248);
    boolean bool3 = com.tencent.mm.q.c.uk().b(w.a.uGE, w.a.uGG);
    ap.yY();
    String str1 = (String)com.tencent.mm.u.c.vr().get(w.a.uGH, "");
    IconPreference localIconPreference = (IconPreference)this.isp.Tc("settings_mm_wallet");
    if (localIconPreference == null)
    {
      GMTrace.o(1595177697280L, 11885);
      return;
    }
    v.d("MicroMsg.MoreTabUI", "isShowNew : " + bool2);
    v.d("MicroMsg.MoreTabUI", "isShowDot : " + bool1);
    ap.yY();
    String str2 = (String)com.tencent.mm.u.c.vr().get(w.a.uGq, "");
    ap.yY();
    int j = ((Integer)com.tencent.mm.u.c.vr().get(w.a.uGr, Integer.valueOf(-1))).intValue();
    if ((bool2) || (bool1))
    {
      ap.yY();
      long l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uGo, Long.valueOf(-1L))).longValue();
      long l2 = u.mB(com.tencent.mm.i.g.sV().getValue("PayWalletRedDotExpire"));
      long l3 = System.currentTimeMillis();
      double d = (l3 - l1) / 8.64E7D;
      v.i("MicroMsg.MoreTabUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(86400000L * l2), Long.valueOf(l3), Double.valueOf(d) });
      if ((l1 > 0L) && (l2 > 0L) && (d >= l2))
      {
        bool2 = false;
        bool1 = false;
        com.tencent.mm.q.c.uk().s(262156, false);
      }
    }
    for (;;)
    {
      v.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      v.d("MicroMsg.MoreTabUI", "bankcardDot : " + bool3);
      if (bool3)
      {
        if (!bf.mA(str1))
        {
          localIconPreference.Ao(0);
          localIconPreference.R(str1, -1, -7566196);
          localIconPreference.kV(true);
          localIconPreference.Ap(8);
          GMTrace.o(1595177697280L, 11885);
          return;
        }
        localIconPreference.cN("", -1);
        localIconPreference.Ao(8);
        localIconPreference.Ap(0);
        GMTrace.o(1595177697280L, 11885);
        return;
      }
      if (bool2)
      {
        localIconPreference.An(0);
        localIconPreference.cM(getString(R.l.dHG), R.g.bhA);
        localIconPreference.Ap(8);
        GMTrace.o(1595177697280L, 11885);
        return;
      }
      if (i > 99)
      {
        localIconPreference.An(0);
        localIconPreference.cM(getString(R.l.fkr), com.tencent.mm.ui.tools.s.fg(this.uRf.uRz));
        localIconPreference.Ap(8);
        GMTrace.o(1595177697280L, 11885);
        return;
      }
      if (i > 0)
      {
        localIconPreference.An(0);
        localIconPreference.cM(String.valueOf(i), com.tencent.mm.ui.tools.s.fg(this.uRf.uRz));
        localIconPreference.Ap(8);
        GMTrace.o(1595177697280L, 11885);
        return;
      }
      if (bool1)
      {
        localIconPreference.cM("", -1);
        localIconPreference.An(8);
        localIconPreference.Ap(0);
        GMTrace.o(1595177697280L, 11885);
        return;
      }
      if (j == 1)
      {
        localIconPreference.cM("", -1);
        localIconPreference.An(8);
        localIconPreference.Ao(0);
        localIconPreference.kV(true);
        if (!u.mA(str2)) {
          localIconPreference.R(str2, -1, Color.parseColor("#888888"));
        }
        localIconPreference.As(8);
        GMTrace.o(1595177697280L, 11885);
        return;
      }
      localIconPreference.cM("", -1);
      localIconPreference.An(8);
      localIconPreference.Ap(8);
      localIconPreference.Ao(8);
      localIconPreference.cN("", -1);
      GMTrace.o(1595177697280L, 11885);
      return;
    }
  }
  
  public final boolean bin()
  {
    GMTrace.i(1593835520000L, 11875);
    GMTrace.o(1593835520000L, 11875);
    return false;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    GMTrace.i(1594238173184L, 11878);
    v.i("MicroMsg.MoreTabUI", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.isp = this.vpG;
    this.isp.aV("more_setting", true);
    this.isp.aV("settings_emoji_store", true);
    this.isp.aV("settings_mm_wallet", true);
    this.isp.aV("settings_mm_cardpackage", true);
    this.isp.aV("settings_mm_favorite", true);
    this.isp.aV("settings_my_album", true);
    this.isp.aV("settings_my_address", true);
    this.isp.aV("more_tab_setting_personal_info", true);
    this.isp.aV("more_uishow", true);
    GMTrace.o(1594238173184L, 11878);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1593567084544L, 11873);
    super.onCreate(paramBundle);
    if ((!ap.zb()) || (ap.uP()))
    {
      v.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", new Object[] { Boolean.valueOf(ap.zb()), Boolean.valueOf(ap.uP()) });
      GMTrace.o(1593567084544L, 11873);
      return;
    }
    GMTrace.o(1593567084544L, 11873);
  }
  
  public final void onDestroy()
  {
    GMTrace.i(1594103955456L, 11877);
    super.onDestroy();
    GMTrace.o(1594103955456L, 11877);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */